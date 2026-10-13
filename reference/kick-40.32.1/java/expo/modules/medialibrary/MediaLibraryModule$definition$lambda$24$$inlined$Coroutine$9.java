package expo.modules.medialibrary;

import android.content.Context;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.medialibrary.albums.AddAssetsToAlbumKt;
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
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0010\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0004H\n¨\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "<destruct>", "", "expo/modules/kotlin/functions/AsyncFunctionBuilder$SuspendBody$7"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.medialibrary.MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$9", f = "MediaLibraryModule.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {272, 279}, m = "invokeSuspend", n = {"<destruct>", "p0", "p1", "p2", "$completion", "albumId", "assetsId", "copyToAlbum", "$i$a$-Coroutine-MediaLibraryModule$definition$1$8", "<destruct>", "p0", "p1", "p2", "$completion", "albumId", "assetsId", "copyToAlbum", "$i$a$-Coroutine-MediaLibraryModule$definition$1$8"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "I$0"})
public final class MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$9 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
    int I$0;
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    boolean Z$0;
    int label;
    final /* synthetic */ MediaLibraryModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$9(Continuation continuation, MediaLibraryModule mediaLibraryModule) {
        super(3, continuation);
        this.this$0 = mediaLibraryModule;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<? super Object> continuation) {
        return invoke2(coroutineScope, objArr, (Continuation<Object>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
        MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$9 mediaLibraryModule$definition$lambda$24$$inlined$Coroutine$9 = new MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$9(continuation, this.this$0);
        mediaLibraryModule$definition$lambda$24$$inlined$Coroutine$9.L$0 = objArr;
        return mediaLibraryModule$definition$lambda$24$$inlined$Coroutine$9.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws PermissionsException, Exceptions.ReactContextLost {
        Object obj2;
        Object obj3;
        int i;
        Object obj4;
        Continuation continuation;
        boolean z;
        String str;
        String[] strArr;
        Object[] objArr = (Object[]) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            obj2 = objArr[0];
            obj3 = objArr[1];
            Object obj5 = objArr[2];
            MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$9 mediaLibraryModule$definition$lambda$24$$inlined$Coroutine$9 = this;
            boolean zBooleanValue = ((Boolean) obj5).booleanValue();
            String str2 = (String) obj3;
            String[] strArr2 = (String[]) obj2;
            MediaLibraryModule.requireSystemPermissions$default(this.this$0, false, 1, null);
            MediaLibraryModule mediaLibraryModule = this.this$0;
            String[] strArr3 = zBooleanValue ? new String[0] : strArr2;
            this.L$0 = SpillingKt.nullOutSpilledVariable(objArr);
            this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
            this.L$2 = SpillingKt.nullOutSpilledVariable(obj3);
            this.L$3 = SpillingKt.nullOutSpilledVariable(obj5);
            this.L$4 = SpillingKt.nullOutSpilledVariable(mediaLibraryModule$definition$lambda$24$$inlined$Coroutine$9);
            this.L$5 = str2;
            this.L$6 = strArr2;
            this.Z$0 = zBooleanValue;
            this.I$0 = 0;
            this.label = 1;
            if (MediaLibraryModule.requestMediaLibraryActionPermission$default(mediaLibraryModule, strArr3, false, this, 2, null) != coroutine_suspended) {
                i = 0;
                obj4 = obj5;
                continuation = mediaLibraryModule$definition$lambda$24$$inlined$Coroutine$9;
                z = zBooleanValue;
                str = str2;
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
        z = this.Z$0;
        strArr = (String[]) this.L$6;
        str = (String) this.L$5;
        continuation = (Continuation) this.L$4;
        obj4 = this.L$3;
        obj3 = this.L$2;
        obj2 = this.L$1;
        ResultKt.throwOnFailure(obj);
        Context context = this.this$0.getContext();
        this.L$0 = SpillingKt.nullOutSpilledVariable(objArr);
        this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
        this.L$2 = SpillingKt.nullOutSpilledVariable(obj3);
        this.L$3 = SpillingKt.nullOutSpilledVariable(obj4);
        this.L$4 = SpillingKt.nullOutSpilledVariable(continuation);
        this.L$5 = SpillingKt.nullOutSpilledVariable(str);
        this.L$6 = SpillingKt.nullOutSpilledVariable(strArr);
        this.Z$0 = z;
        this.I$0 = i;
        this.label = 2;
        Object objAddAssetsToAlbum = AddAssetsToAlbumKt.addAssetsToAlbum(context, strArr, str, z, this);
        return objAddAssetsToAlbum == coroutine_suspended ? coroutine_suspended : objAddAssetsToAlbum;
    }
}
