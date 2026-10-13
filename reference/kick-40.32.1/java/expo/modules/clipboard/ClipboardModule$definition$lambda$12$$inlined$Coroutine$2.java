package expo.modules.clipboard;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.net.Uri;
import expo.modules.kotlin.exception.CodedException;
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
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0010\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0004H\n¨\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "<destruct>", "", "expo/modules/kotlin/functions/AsyncFunctionBuilder$SuspendBody$3"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$Coroutine$2", f = "ClipboardModule.kt", i = {0, 0, 0, 0, 0, 0}, l = {282}, m = "invokeSuspend", n = {"<destruct>", "p0", "$completion", "options", "imageUri", "$i$a$-Coroutine-ClipboardModule$definition$1$4"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"})
public final class ClipboardModule$definition$lambda$12$$inlined$Coroutine$2 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
    int I$0;
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ ClipboardModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClipboardModule$definition$lambda$12$$inlined$Coroutine$2(Continuation continuation, ClipboardModule clipboardModule) {
        super(3, continuation);
        this.this$0 = clipboardModule;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<? super Object> continuation) {
        return invoke2(coroutineScope, objArr, (Continuation<Object>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
        ClipboardModule$definition$lambda$12$$inlined$Coroutine$2 clipboardModule$definition$lambda$12$$inlined$Coroutine$2 = new ClipboardModule$definition$lambda$12$$inlined$Coroutine$2(continuation, this.this$0);
        clipboardModule$definition$lambda$12$$inlined$Coroutine$2.L$0 = objArr;
        return clipboardModule$definition$lambda$12$$inlined$Coroutine$2.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws PasteFailureException, ClipboardUnavailableException, NoPermissionException {
        ClipData.Item firstItem;
        Object[] objArr = (Object[]) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Object obj2 = objArr[0];
                ClipboardModule$definition$lambda$12$$inlined$Coroutine$2 clipboardModule$definition$lambda$12$$inlined$Coroutine$2 = this;
                GetImageOptions getImageOptions = (GetImageOptions) obj2;
                ClipboardManager clipboardManager = this.this$0.getClipboardManager();
                if (!this.this$0.clipboardHasItemWithType("image/*")) {
                    clipboardManager = null;
                }
                Uri uri = (clipboardManager == null || (firstItem = this.this$0.getFirstItem(clipboardManager)) == null) ? null : firstItem.getUri();
                if (uri == null) {
                    return null;
                }
                Context context = this.this$0.getContext();
                this.L$0 = SpillingKt.nullOutSpilledVariable(objArr);
                this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
                this.L$2 = SpillingKt.nullOutSpilledVariable(clipboardModule$definition$lambda$12$$inlined$Coroutine$2);
                this.L$3 = SpillingKt.nullOutSpilledVariable(getImageOptions);
                this.L$4 = SpillingKt.nullOutSpilledVariable(uri);
                this.I$0 = 0;
                this.label = 1;
                obj = ClipboardImageKt.imageFromContentUri(context, uri, getImageOptions, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return ((ImageResult) obj).toBundle();
        } catch (Throwable th) {
            th.printStackTrace();
            if (th instanceof CodedException) {
                throw th;
            }
            if (th instanceof SecurityException) {
                throw new NoPermissionException(th);
            }
            throw new PasteFailureException(th, "image");
        }
    }
}
