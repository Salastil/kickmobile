package expo.modules.filesystem;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: FileSystemPath.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/net/Uri;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.filesystem.FileSystemPath$move$finalUri$1", f = "FileSystemPath.kt", i = {}, l = {245}, m = "invokeSuspend", n = {}, s = {})
final class FileSystemPath$move$finalUri$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Uri>, Object> {
    final /* synthetic */ RelocationOptions $options;
    final /* synthetic */ FileSystemPath $to;
    int label;
    final /* synthetic */ FileSystemPath this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FileSystemPath$move$finalUri$1(FileSystemPath fileSystemPath, FileSystemPath fileSystemPath2, RelocationOptions relocationOptions, Continuation<? super FileSystemPath$move$finalUri$1> continuation) {
        super(2, continuation);
        this.this$0 = fileSystemPath;
        this.$to = fileSystemPath2;
        this.$options = relocationOptions;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FileSystemPath$move$finalUri$1(this.this$0, this.$to, this.$options, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Uri> continuation) {
        return ((FileSystemPath$move$finalUri$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        ResultKt.throwOnFailure(obj);
        this.label = 1;
        Object objMoveTo = this.this$0.getFile().moveTo(FileSystemPathKt.asCopyOrMoveDestination(this.$to, this.$options.getOverwrite()), this);
        return objMoveTo == coroutine_suspended ? coroutine_suspended : objMoveTo;
    }
}
