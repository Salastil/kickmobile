package io.ktor.client.plugins.logging;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Logging.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\t\u001a\u0004\b\n\u0010\u000bR#\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/client/plugins/logging/SanitizedHeader;", "", "", "placeholder", "Lkotlin/Function1;", "", "predicate", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "Ljava/lang/String;", "getPlaceholder", "()Ljava/lang/String;", "Lkotlin/jvm/functions/Function1;", "getPredicate", "()Lkotlin/jvm/functions/Function1;", "ktor-client-logging"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SanitizedHeader {
    private final String placeholder;
    private final Function1<String, Boolean> predicate;

    /* JADX WARN: Multi-variable type inference failed */
    public SanitizedHeader(String placeholder, Function1<? super String, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(placeholder, "placeholder");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        this.placeholder = placeholder;
        this.predicate = predicate;
    }

    public final String getPlaceholder() {
        return this.placeholder;
    }

    public final Function1<String, Boolean> getPredicate() {
        return this.predicate;
    }
}
