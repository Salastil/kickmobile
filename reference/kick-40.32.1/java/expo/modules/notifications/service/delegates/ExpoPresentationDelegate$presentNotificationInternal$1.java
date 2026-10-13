package expo.modules.notifications.service.delegates;

import androidx.compose.runtime.GapComposerKt;
import expo.modules.notifications.service.NotificationsService;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: ExpoPresentationDelegate.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.notifications.service.delegates.ExpoPresentationDelegate", f = "ExpoPresentationDelegate.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {GapComposerKt.nodeKey, 347}, m = "presentNotificationInternal$expo_notifications_release", n = {NotificationsService.NOTIFICATION_KEY, "behavior", NotificationsService.NOTIFICATION_KEY, "behavior", "androidNotification", "request", "tag", "$this$withLock_u24default$iv", "id", "$i$f$withLock"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1"})
final class ExpoPresentationDelegate$presentNotificationInternal$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ExpoPresentationDelegate this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ExpoPresentationDelegate$presentNotificationInternal$1(ExpoPresentationDelegate expoPresentationDelegate, Continuation<? super ExpoPresentationDelegate$presentNotificationInternal$1> continuation) {
        super(continuation);
        this.this$0 = expoPresentationDelegate;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.presentNotificationInternal$expo_notifications_release(null, null, this);
    }
}
