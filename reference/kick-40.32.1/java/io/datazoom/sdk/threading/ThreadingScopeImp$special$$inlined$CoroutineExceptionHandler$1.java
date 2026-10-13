package io.datazoom.sdk.threading;

import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.notifications.service.NotificationsService;
import io.datazoom.sdk.logs.Logger_androidKt;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: compiled from: CoroutineExceptionHandler.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lkotlin/coroutines/CoroutineContext;", NotificationsService.EXCEPTION_KEY, "", "kotlinx-coroutines-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ThreadingScopeImp$special$$inlined$CoroutineExceptionHandler$1 extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    final /* synthetic */ ThreadingScopeImp this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadingScopeImp$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Companion companion, ThreadingScopeImp threadingScopeImp) {
        super(companion);
        this.this$0 = threadingScopeImp;
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public void handleException(CoroutineContext context, Throwable exception) {
        Logger_androidKt.getLogger().e("CoroutineException: " + exception.getMessage());
        this.this$0._errorsState.tryEmit(exception);
    }
}
