package io.mobileshield.sdk.config;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.h.s.s0;
import org.h.s.s1;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0016\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB=\b\u0000\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u000b\"\u00020\u0007¢\u0006\u0002\u0010\fJ\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0007R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR!\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u000fj\b\u0012\u0004\u0012\u00020\u0007`\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001e"}, d2 = {"Lio/mobileshield/sdk/config/Config;", "Ljava/io/Serializable;", "protocol", "Lio/mobileshield/sdk/config/Protocol;", "type", "Lio/mobileshield/sdk/config/Method;", "domain", "", "port", "", "endpoints", "", "(Lio/mobileshield/sdk/config/Protocol;Lio/mobileshield/sdk/config/Method;Ljava/lang/String;I[Ljava/lang/String;)V", "getDomain", "()Ljava/lang/String;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getEndpoints", "()Ljava/util/ArrayList;", "formattedProtocol", "getFormattedProtocol", "getPort", "()I", "getType", "()Lio/mobileshield/sdk/config/Method;", "isMatch", "", "path", "checkWith", "Companion", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class Config implements Serializable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long serialVersionUID = 1;
    private final String domain;
    private final ArrayList<String> endpoints;
    private final String formattedProtocol;
    private final int port;
    private final Method type;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ;\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\b\"\u00020\u0006H\u0007¢\u0006\u0004\b\u000b\u0010\fJ3\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\b\"\u00020\u0006H\u0007¢\u0006\u0004\b\u000b\u0010\rJC\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\b\"\u00020\u0006H\u0007¢\u0006\u0004\b\u000b\u0010\u0010J\u001f\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0012H\u0000¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lio/mobileshield/sdk/config/Config$Companion;", "", "Lio/mobileshield/sdk/config/Protocol;", "protocol", "Lio/mobileshield/sdk/config/Method;", "type", "", "domain", "", "endpoints", "Lio/mobileshield/sdk/config/Config;", "create", "(Lio/mobileshield/sdk/config/Protocol;Lio/mobileshield/sdk/config/Method;Ljava/lang/String;[Ljava/lang/String;)Lio/mobileshield/sdk/config/Config;", "(Lio/mobileshield/sdk/config/Method;Ljava/lang/String;[Ljava/lang/String;)Lio/mobileshield/sdk/config/Config;", "", "port", "(Lio/mobileshield/sdk/config/Protocol;Lio/mobileshield/sdk/config/Method;Ljava/lang/String;I[Ljava/lang/String;)Lio/mobileshield/sdk/config/Config;", "config", "Lorg/h/s/s0;", "internalPath", "createConfigForInternalEndpoints$sdk_release", "(Lio/mobileshield/sdk/config/Config;Lorg/h/s/s0;)Lio/mobileshield/sdk/config/Config;", "createConfigForInternalEndpoints", "", "serialVersionUID", "J", "<init>", "()V", "sdk_release"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final Config create(Protocol protocol, Method type, String domain, String... endpoints) {
            Intrinsics.checkNotNullParameter(protocol, "protocol");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(domain, "domain");
            Intrinsics.checkNotNullParameter(endpoints, "endpoints");
            return new Config(protocol, type, domain, -1, (String[]) Arrays.copyOf(endpoints, endpoints.length));
        }

        public final Config createConfigForInternalEndpoints$sdk_release(Config config, s0 internalPath) {
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(internalPath, "internalPath");
            return create(Protocol.HTTPS, internalPath.b, config.getDomain(), config.getPort(), internalPath.f569a);
        }

        @JvmStatic
        public final Config create(Method type, String domain, String... endpoints) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(domain, "domain");
            Intrinsics.checkNotNullParameter(endpoints, "endpoints");
            return new Config(Protocol.HTTPS, type, domain, -1, (String[]) Arrays.copyOf(endpoints, endpoints.length));
        }

        @JvmStatic
        public final Config create(Protocol protocol, Method type, String domain, int port, String... endpoints) {
            Intrinsics.checkNotNullParameter(protocol, "protocol");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(domain, "domain");
            Intrinsics.checkNotNullParameter(endpoints, "endpoints");
            return new Config(protocol, type, domain, -1, (String[]) Arrays.copyOf(endpoints, endpoints.length));
        }
    }

    public Config(Protocol protocol, Method type, String domain, int i, String... endpoints) {
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(domain, "domain");
        Intrinsics.checkNotNullParameter(endpoints, "endpoints");
        this.type = type;
        this.domain = domain;
        this.port = i;
        this.endpoints = new ArrayList<>();
        this.formattedProtocol = protocol.formatted();
        for (String str : endpoints) {
            this.endpoints.add(str);
        }
    }

    @JvmStatic
    public static final Config create(Method method, String str, String... strArr) {
        return INSTANCE.create(method, str, strArr);
    }

    public final String getDomain() {
        return this.domain;
    }

    public final ArrayList<String> getEndpoints() {
        return this.endpoints;
    }

    public final String getFormattedProtocol() {
        return this.formattedProtocol;
    }

    public final int getPort() {
        return this.port;
    }

    public final Method getType() {
        return this.type;
    }

    public final boolean isMatch(String path, String checkWith) {
        String[] strArr;
        boolean z;
        int i;
        boolean zStartsWith$default;
        int iIndexOf$default;
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(checkWith, "checkWith");
        Intrinsics.checkNotNullParameter(path, "stringToMatch");
        Intrinsics.checkNotNullParameter(checkWith, "wildcardMatcherString");
        String strA = s1.a(path, false);
        String strA2 = s1.a(checkWith, false);
        if (StringsKt.indexOf$default((CharSequence) strA2, "?", 0, false, 6, (Object) null) == -1 && StringsKt.indexOf$default((CharSequence) strA2, "*", 0, false, 6, (Object) null) == -1) {
            strArr = new String[]{strA2};
        } else {
            char[] charArray = strA2.toCharArray();
            Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
            ArrayList arrayList = new ArrayList();
            StringBuffer stringBuffer = new StringBuffer();
            int length = charArray.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                char c = charArray[i2];
                int i4 = i3 + 1;
                if (c == '?' || c == '*') {
                    if (stringBuffer.length() > 0) {
                        arrayList.add(stringBuffer.toString());
                        stringBuffer.setLength(0);
                    }
                    if (c == '?') {
                        arrayList.add("?");
                    } else if (arrayList.isEmpty() || (i3 > 0 && !Intrinsics.areEqual(arrayList.get(arrayList.size() - 1), "*"))) {
                        arrayList.add("*");
                    }
                } else {
                    stringBuffer.append(c);
                }
                i2++;
                i3 = i4;
            }
            if (stringBuffer.length() > 0) {
                arrayList.add(stringBuffer.toString());
            }
            strArr = (String[]) arrayList.toArray(new String[0]);
        }
        Stack stack = new Stack();
        boolean z2 = false;
        int length2 = 0;
        int i5 = 0;
        while (true) {
            if (stack.isEmpty()) {
                z = z2;
                i = i5;
            } else {
                Object objPop = stack.pop();
                Intrinsics.checkNotNull(objPop, "null cannot be cast to non-null type kotlin.IntArray");
                int[] iArr = (int[]) objPop;
                int i6 = iArr[0];
                length2 = iArr[1];
                i = i6;
                z = true;
            }
            while (i < strArr.length) {
                if (Intrinsics.areEqual(strArr[i], "?")) {
                    length2++;
                    z = false;
                } else if (Intrinsics.areEqual(strArr[i], "*")) {
                    if (i == strArr.length - 1) {
                        length2 = strA.length();
                    }
                    z = true;
                } else {
                    if (z) {
                        int iIndexOf$default2 = StringsKt.indexOf$default((CharSequence) strA, strArr[i], length2, false, 4, (Object) null);
                        if (iIndexOf$default2 != -1 && (iIndexOf$default = StringsKt.indexOf$default((CharSequence) strA, strArr[i], iIndexOf$default2 + 1, false, 4, (Object) null)) >= 0) {
                            stack.push(new int[]{i, iIndexOf$default});
                        }
                        zStartsWith$default = iIndexOf$default2 != -1;
                        length2 = iIndexOf$default2;
                    } else {
                        zStartsWith$default = StringsKt.startsWith$default(strA, strArr[i], length2, false, 4, (Object) null);
                    }
                    if (!zStartsWith$default) {
                        break;
                    }
                    z = false;
                    length2 = strArr[i].length() + length2;
                }
                i++;
            }
            Triple triple = new Triple(Boolean.valueOf(z), Integer.valueOf(length2), Integer.valueOf(i));
            boolean zBooleanValue = ((Boolean) triple.getFirst()).booleanValue();
            int iIntValue = ((Number) triple.getSecond()).intValue();
            int iIntValue2 = ((Number) triple.getThird()).intValue();
            if (iIntValue2 == strArr.length && iIntValue == strA.length()) {
                return true;
            }
            if (stack.isEmpty()) {
                return false;
            }
            i5 = iIntValue2;
            z2 = zBooleanValue;
            length2 = iIntValue;
        }
    }

    @JvmStatic
    public static final Config create(Protocol protocol, Method method, String str, int i, String... strArr) {
        return INSTANCE.create(protocol, method, str, i, strArr);
    }

    @JvmStatic
    public static final Config create(Protocol protocol, Method method, String str, String... strArr) {
        return INSTANCE.create(protocol, method, str, strArr);
    }

    public /* synthetic */ Config(Protocol protocol, Method method, String str, int i, String[] strArr, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? Protocol.HTTPS : protocol, method, str, i, strArr);
    }
}
