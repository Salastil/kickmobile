package expo.modules.filesystem;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: FileSystemModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.filesystem.FileSystemModule$definition$1$14$12$1", f = "FileSystemModule.kt", i = {}, l = {428}, m = "invokeSuspend", n = {}, s = {})
final class FileSystemModule$definition$1$14$12$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FileSystemPath $destination;
    final /* synthetic */ FileSystemDirectory $directory;
    final /* synthetic */ RelocationOptions $options;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FileSystemModule$definition$1$14$12$1(FileSystemDirectory fileSystemDirectory, FileSystemPath fileSystemPath, RelocationOptions relocationOptions, Continuation<? super FileSystemModule$definition$1$14$12$1> continuation) {
        super(2, continuation);
        this.$directory = fileSystemDirectory;
        this.$destination = fileSystemPath;
        this.$options = relocationOptions;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FileSystemModule$definition$1$14$12$1(this.$directory, this.$destination, this.$options, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FileSystemModule$definition$1$14$12$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FileSystemDirectory fileSystemDirectory = this.$directory;
            FileSystemPath fileSystemPath = this.$destination;
            RelocationOptions relocationOptions = this.$options;
            if (relocationOptions == null) {
                relocationOptions = new RelocationOptions(false, 1, null);
            }
            this.label = 1;
            if (fileSystemDirectory.move(fileSystemPath, relocationOptions, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
