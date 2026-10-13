package expo.modules.clipboard;

import android.content.ClipData;
import android.content.Context;
import expo.modules.kotlin.exception.CodedException;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AsyncFunctionBuilder.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0010\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0004H\n¨\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "<destruct>", "", "expo/modules/kotlin/functions/AsyncFunctionBuilder$SuspendBody$5"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$Coroutine$5", f = "ClipboardModule.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {272}, m = "invokeSuspend", n = {"<destruct>", "p0", "p1", "$completion", "options", "imageData", "$i$a$-Coroutine-ClipboardModule$definition$1$5"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0"})
public final class ClipboardModule$definition$lambda$12$$inlined$Coroutine$5 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
    int I$0;
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ ClipboardModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClipboardModule$definition$lambda$12$$inlined$Coroutine$5(Continuation continuation, ClipboardModule clipboardModule) {
        super(3, continuation);
        this.this$0 = clipboardModule;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<? super Object> continuation) {
        return invoke2(coroutineScope, objArr, (Continuation<Object>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
        ClipboardModule$definition$lambda$12$$inlined$Coroutine$5 clipboardModule$definition$lambda$12$$inlined$Coroutine$5 = new ClipboardModule$definition$lambda$12$$inlined$Coroutine$5(continuation, this.this$0);
        clipboardModule$definition$lambda$12$$inlined$Coroutine$5.L$0 = objArr;
        return clipboardModule$definition$lambda$12$$inlined$Coroutine$5.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws CopyFailureException {
        SetImageOptions setImageOptions;
        Object[] objArr = (Object[]) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Object obj2 = objArr[0];
                Object obj3 = objArr[1];
                ClipboardModule$definition$lambda$12$$inlined$Coroutine$5 clipboardModule$definition$lambda$12$$inlined$Coroutine$5 = this;
                SetImageOptions setImageOptions2 = (SetImageOptions) obj3;
                String str = (String) obj2;
                Context context = this.this$0.getContext();
                File clipboardCacheDir = this.this$0.getClipboardCacheDir();
                this.L$0 = SpillingKt.nullOutSpilledVariable(objArr);
                this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
                this.L$2 = SpillingKt.nullOutSpilledVariable(obj3);
                this.L$3 = SpillingKt.nullOutSpilledVariable(clipboardModule$definition$lambda$12$$inlined$Coroutine$5);
                this.L$4 = setImageOptions2;
                this.L$5 = SpillingKt.nullOutSpilledVariable(str);
                this.I$0 = 0;
                this.label = 1;
                obj = ClipboardImageKt.clipDataFromBase64Image(context, str, clipboardCacheDir, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                setImageOptions = setImageOptions2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                setImageOptions = (SetImageOptions) this.L$4;
                ResultKt.throwOnFailure(obj);
            }
            this.this$0.getClipboardManager().setPrimaryClip(ClipboardModuleKt.applyIsSensitive((ClipData) obj, setImageOptions.getIsSensitive()));
            return Unit.INSTANCE;
        } catch (Throwable th) {
            th.printStackTrace();
            if (th instanceof CodedException) {
                throw th;
            }
            throw new CopyFailureException(th, "image");
        }
    }
}
