package io.ktor.client.plugins.logging;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.slf4j.MDCContext;

/* JADX INFO: compiled from: KtorMDCContext.jvm.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"Lkotlin/coroutines/CoroutineContext$Element;", "MDCContext", "()Lkotlin/coroutines/CoroutineContext$Element;", "ktor-client-logging"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class KtorMDCContext_jvmKt {
    public static final CoroutineContext.Element MDCContext() {
        return new MDCContext(null, 1, null);
    }
}
