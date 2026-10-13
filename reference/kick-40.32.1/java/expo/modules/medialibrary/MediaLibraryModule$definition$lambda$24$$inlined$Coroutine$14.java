package expo.modules.medialibrary;

import android.content.Context;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.medialibrary.assets.DeleteAssetsKt;
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
@DebugMetadata(c = "expo.modules.medialibrary.MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$14", f = "MediaLibraryModule.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {272, 273}, m = "invokeSuspend", n = {"<destruct>", "p0", "$completion", "assetsId", "$i$a$-Coroutine-MediaLibraryModule$definition$1$10", "<destruct>", "p0", "$completion", "assetsId", "$i$a$-Coroutine-MediaLibraryModule$definition$1$10"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0"})
public final class MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$14 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
    int I$0;
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ MediaLibraryModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$14(Continuation continuation, MediaLibraryModule mediaLibraryModule) {
        super(3, continuation);
        this.this$0 = mediaLibraryModule;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<? super Object> continuation) {
        return invoke2(coroutineScope, objArr, (Continuation<Object>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
        MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$14 mediaLibraryModule$definition$lambda$24$$inlined$Coroutine$14 = new MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$14(continuation, this.this$0);
        mediaLibraryModule$definition$lambda$24$$inlined$Coroutine$14.L$0 = objArr;
        return mediaLibraryModule$definition$lambda$24$$inlined$Coroutine$14.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws PermissionsException, Exceptions.ReactContextLost {
        int i;
        Object obj2;
        MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$14 mediaLibraryModule$definition$lambda$24$$inlined$Coroutine$14;
        String[] strArr;
        Object[] objArr = (Object[]) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            i = 0;
            obj2 = objArr[0];
            mediaLibraryModule$definition$lambda$24$$inlined$Coroutine$14 = this;
            String[] strArr2 = (String[]) obj2;
            MediaLibraryModule.requireSystemPermissions$default(this.this$0, false, 1, null);
            MediaLibraryModule mediaLibraryModule = this.this$0;
            this.L$0 = SpillingKt.nullOutSpilledVariable(objArr);
            this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
            this.L$2 = SpillingKt.nullOutSpilledVariable(mediaLibraryModule$definition$lambda$24$$inlined$Coroutine$14);
            this.L$3 = strArr2;
            this.I$0 = 0;
            this.label = 1;
            if (mediaLibraryModule.requestMediaLibraryActionPermission(strArr2, true, this) != coroutine_suspended) {
                strArr = strArr2;
            }
        }
        if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        i = this.I$0;
        strArr = (String[]) this.L$3;
        mediaLibraryModule$definition$lambda$24$$inlined$Coroutine$14 = (Continuation) this.L$2;
        obj2 = this.L$1;
        ResultKt.throwOnFailure(obj);
        Context context = this.this$0.getContext();
        this.L$0 = SpillingKt.nullOutSpilledVariable(objArr);
        this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
        this.L$2 = SpillingKt.nullOutSpilledVariable(mediaLibraryModule$definition$lambda$24$$inlined$Coroutine$14);
        this.L$3 = SpillingKt.nullOutSpilledVariable(strArr);
        this.I$0 = i;
        this.label = 2;
        Object objDeleteAssets = DeleteAssetsKt.deleteAssets(context, strArr, this);
        return objDeleteAssets == coroutine_suspended ? coroutine_suspended : objDeleteAssets;
    }
}
