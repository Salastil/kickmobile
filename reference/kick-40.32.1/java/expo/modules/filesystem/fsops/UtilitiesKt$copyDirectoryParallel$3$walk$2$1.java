package expo.modules.filesystem.fsops;

import expo.modules.filesystem.unifiedfile.UnifiedFileInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Semaphore;

/* JADX INFO: compiled from: Utilities.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.filesystem.fsops.UtilitiesKt$copyDirectoryParallel$3$walk$2$1", f = "Utilities.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class UtilitiesKt$copyDirectoryParallel$3$walk$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ UnifiedFileInterface $child;
    final /* synthetic */ UnifiedFileInterface $childDest;
    final /* synthetic */ Function2<UnifiedFileInterface, UnifiedFileInterface, Unit> $copyFile;
    final /* synthetic */ Semaphore $semaphore;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    UtilitiesKt$copyDirectoryParallel$3$walk$2$1(Function2<? super UnifiedFileInterface, ? super UnifiedFileInterface, Unit> function2, UnifiedFileInterface unifiedFileInterface, UnifiedFileInterface unifiedFileInterface2, Semaphore semaphore, Continuation<? super UtilitiesKt$copyDirectoryParallel$3$walk$2$1> continuation) {
        super(2, continuation);
        this.$copyFile = function2;
        this.$child = unifiedFileInterface;
        this.$childDest = unifiedFileInterface2;
        this.$semaphore = semaphore;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UtilitiesKt$copyDirectoryParallel$3$walk$2$1(this.$copyFile, this.$child, this.$childDest, this.$semaphore, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((UtilitiesKt$copyDirectoryParallel$3$walk$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        try {
            this.$copyFile.invoke(this.$child, this.$childDest);
            return Unit.INSTANCE;
        } finally {
            this.$semaphore.release();
        }
    }
}
