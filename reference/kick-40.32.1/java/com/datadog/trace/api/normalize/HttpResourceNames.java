package com.datadog.trace.api.normalize;

import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.datadog.android.trace.internal.compat.function.Function;
import com.datadog.trace.api.Config;
import com.datadog.trace.api.Pair;
import com.datadog.trace.api.cache.DDCache;
import com.datadog.trace.api.cache.DDCaches;
import com.datadog.trace.bootstrap.instrumentation.api.AgentSpan;
import com.datadog.trace.bootstrap.instrumentation.api.UTF8BytesString;

/* JADX INFO: loaded from: classes6.dex */
public class HttpResourceNames {
    private static HttpResourceNames INSTANCE;
    public static final UTF8BytesString DEFAULT_RESOURCE_NAME = UTF8BytesString.create(DomExceptionUtils.SEPARATOR);
    private static final Function<Pair<CharSequence, CharSequence>, UTF8BytesString> JOINER = new Function() { // from class: com.datadog.trace.api.normalize.HttpResourceNames$$ExternalSyntheticLambda0
        @Override // com.datadog.android.trace.internal.compat.function.Function
        public final Object apply(Object obj) {
            return HttpResourceNames.lambda$static$0((Pair) obj);
        }
    };
    private static final DDCache<Pair<CharSequence, CharSequence>, CharSequence> JOINER_CACHE = DDCaches.newFixedSizeCache(128);
    private static final SimpleHttpPathNormalizer simpleHttpPathNormalizer = new SimpleHttpPathNormalizer();
    private final AntPatternHttpPathNormalizer serverAntPatternHttpPathNormalizer = new AntPatternHttpPathNormalizer(Config.get().getHttpServerPathResourceNameMapping());
    private final AntPatternHttpPathNormalizer clientAntPatternHttpPathNormalizer = new AntPatternHttpPathNormalizer(Config.get().getHttpClientPathResourceNameMapping());
    private final boolean removeTrailingSlash = Config.get().getHttpResourceRemoveTrailingSlash();

    static /* synthetic */ UTF8BytesString lambda$static$0(Pair pair) {
        StringBuilder sb;
        CharSequence charSequence = (CharSequence) pair.getRight();
        if (charSequence == null) {
            return DEFAULT_RESOURCE_NAME;
        }
        CharSequence charSequence2 = (CharSequence) pair.getLeft();
        if (charSequence2 == null) {
            sb = new StringBuilder(charSequence.length());
        } else {
            StringBuilder sb2 = new StringBuilder(charSequence.length() + charSequence2.length() + 1);
            sb2.append(charSequence2);
            for (int i = 0; i < sb2.length(); i++) {
                sb2.setCharAt(i, Character.toUpperCase(sb2.charAt(i)));
            }
            sb2.append(' ');
            sb = sb2;
        }
        int length = charSequence.length() - 1;
        if (instance().removeTrailingSlash && length > 0 && charSequence.charAt(length) == '/') {
            sb.append(charSequence, 0, length);
        } else {
            sb.append(charSequence);
        }
        return UTF8BytesString.create(sb);
    }

    private static HttpResourceNames instance() {
        if (INSTANCE == null) {
            INSTANCE = new HttpResourceNames();
        }
        return INSTANCE;
    }

    private HttpResourceNames() {
    }

    public static AgentSpan setForServer(AgentSpan agentSpan, CharSequence charSequence, CharSequence charSequence2, boolean z) {
        Pair<CharSequence, Byte> pairComputeForServer = computeForServer(charSequence, charSequence2, z);
        if (pairComputeForServer.hasLeft()) {
            agentSpan.setResourceName(pairComputeForServer.getLeft(), pairComputeForServer.getRight().byteValue());
        }
        return agentSpan;
    }

    public static Pair<CharSequence, Byte> computeForServer(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        byte b;
        String strNormalize = instance().serverAntPatternHttpPathNormalizer.normalize(charSequence2.toString(), z);
        if (strNormalize != null) {
            b = 4;
        } else {
            strNormalize = simpleHttpPathNormalizer.normalize(charSequence2.toString(), z);
            b = 1;
        }
        return Pair.of(join(charSequence, strNormalize), Byte.valueOf(b));
    }

    public static Pair<CharSequence, Byte> computeForClient(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        byte b;
        String strNormalize = instance().clientAntPatternHttpPathNormalizer.normalize(charSequence2.toString(), z);
        if (strNormalize != null) {
            b = 4;
        } else {
            strNormalize = simpleHttpPathNormalizer.normalize(charSequence2.toString(), z);
            b = 1;
        }
        return Pair.of(join(charSequence, strNormalize), Byte.valueOf(b));
    }

    public static AgentSpan setForClient(AgentSpan agentSpan, CharSequence charSequence, CharSequence charSequence2, boolean z) {
        Pair<CharSequence, Byte> pairComputeForClient = computeForClient(charSequence, charSequence2, z);
        if (pairComputeForClient.hasLeft()) {
            agentSpan.setResourceName(pairComputeForClient.getLeft(), pairComputeForClient.getRight().byteValue());
        }
        return agentSpan;
    }

    public static CharSequence join(CharSequence charSequence, CharSequence charSequence2) {
        return JOINER_CACHE.computeIfAbsent(Pair.of(charSequence, charSequence2), JOINER);
    }
}
