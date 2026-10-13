package androidx.camera.camera2.pipe.graph;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: Controller3A.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.camera.camera2.pipe.graph.Controller3A", f = "Controller3A.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {373}, m = "lock3A-Qz1gx5w", n = {"aeLockBehavior", "awbLockBehavior", "afTriggerStartAeMode", "lockedCondition", "lockedTimeLimitNs", "afLockBehaviorSanitized", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "frameLimit"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0"}, v = 1)
final class Controller3A$lock3A$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Controller3A this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Controller3A$lock3A$1(Controller3A controller3A, Continuation<? super Controller3A$lock3A$1> continuation) {
        super(continuation);
        this.this$0 = controller3A;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.m953lock3AQz1gx5w(null, null, null, null, null, null, null, null, null, 0, null, null, this);
    }
}
