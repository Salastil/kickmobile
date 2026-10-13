package io.ktor.websocket;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: WebSocketExtensionHeader.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u0002H\u0096\u0080\u0004¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\rR\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lio/ktor/websocket/WebSocketExtensionHeader;", "", "", "name", "", "parameters", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "Lkotlin/sequences/Sequence;", "Lkotlin/Pair;", "parseParameters", "()Lkotlin/sequences/Sequence;", "toString", "()Ljava/lang/String;", "parametersToString", "Ljava/lang/String;", "getName", "Ljava/util/List;", "getParameters", "()Ljava/util/List;", "ktor-websockets"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class WebSocketExtensionHeader {
    private final String name;
    private final List<String> parameters;

    public WebSocketExtensionHeader(String name, List<String> parameters) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        this.name = name;
        this.parameters = parameters;
    }

    public final String getName() {
        return this.name;
    }

    public final List<String> getParameters() {
        return this.parameters;
    }

    public final Sequence<Pair<String, String>> parseParameters() {
        return SequencesKt.map(CollectionsKt.asSequence(this.parameters), new Function1() { // from class: io.ktor.websocket.WebSocketExtensionHeader$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WebSocketExtensionHeader.parseParameters$lambda$0((String) obj);
            }
        });
    }

    static final Pair parseParameters$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) it, '=', 0, false, 6, (Object) null);
        String strSubstring = "";
        if (iIndexOf$default < 0) {
            return TuplesKt.to(it, "");
        }
        String strSubstring2 = StringsKt.substring(it, RangesKt.until(0, iIndexOf$default));
        int i = iIndexOf$default + 1;
        if (i < it.length()) {
            strSubstring = it.substring(i);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        }
        return TuplesKt.to(strSubstring2, strSubstring);
    }

    public String toString() {
        return this.name + ' ' + parametersToString();
    }

    private final String parametersToString() {
        if (this.parameters.isEmpty()) {
            return "";
        }
        return "; " + CollectionsKt.joinToString$default(this.parameters, ";", null, null, 0, null, null, 62, null);
    }
}
