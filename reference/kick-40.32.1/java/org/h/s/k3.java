package org.h.s;

import io.mobileshield.sdk.logger.LocalLogger;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: loaded from: classes9.dex */
public final class k3 extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    public k3(CoroutineExceptionHandler.Companion companion) {
        super(companion);
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public final void handleException(CoroutineContext coroutineContext, Throwable th) {
        LocalLogger.log(2, 22900L, String.valueOf(th.getMessage()));
    }
}
