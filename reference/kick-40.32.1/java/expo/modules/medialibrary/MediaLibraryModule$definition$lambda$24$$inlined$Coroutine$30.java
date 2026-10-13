package expo.modules.medialibrary;

import android.content.Context;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.medialibrary.albums.AlbumUtilsKt;
import expo.modules.medialibrary.albums.DeleteAlbumsKt;
import java.util.Arrays;
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
@DebugMetadata(c = "expo.modules.medialibrary.MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$30", f = "MediaLibraryModule.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {277, 278}, m = "invokeSuspend", n = {"<destruct>", "p0", "$completion", "albumIds", "assetIds", "$i$a$-Coroutine-MediaLibraryModule$definition$1$16", "<destruct>", "p0", "$completion", "albumIds", "assetIds", "$i$a$-Coroutine-MediaLibraryModule$definition$1$16"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0"})
public final class MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$30 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
    int I$0;
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ MediaLibraryModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$30(Continuation continuation, MediaLibraryModule mediaLibraryModule) {
        super(3, continuation);
        this.this$0 = mediaLibraryModule;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<? super Object> continuation) {
        return invoke2(coroutineScope, objArr, (Continuation<Object>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
        MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$30 mediaLibraryModule$definition$lambda$24$$inlined$Coroutine$30 = new MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$30(continuation, this.this$0);
        mediaLibraryModule$definition$lambda$24$$inlined$Coroutine$30.L$0 = objArr;
        return mediaLibraryModule$definition$lambda$24$$inlined$Coroutine$30.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws PermissionsException, Exceptions.ReactContextLost {
        int i;
        Object obj2;
        MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$30 mediaLibraryModule$definition$lambda$24$$inlined$Coroutine$30;
        String[] strArr;
        MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$30 mediaLibraryModule$definition$lambda$24$$inlined$Coroutine$31;
        String[] strArr2;
        Object[] objArr = (Object[]) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            i = 0;
            obj2 = objArr[0];
            mediaLibraryModule$definition$lambda$24$$inlined$Coroutine$30 = this;
            strArr = (String[]) obj2;
            MediaLibraryModule.requireSystemPermissions$default(this.this$0, false, 1, null);
            String[] strArr3 = (String[]) AlbumUtilsKt.getAssetsInAlbums(this.this$0.getContext(), (String[]) Arrays.copyOf(strArr, strArr.length)).toArray(new String[0]);
            MediaLibraryModule mediaLibraryModule = this.this$0;
            this.L$0 = SpillingKt.nullOutSpilledVariable(objArr);
            this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
            this.L$2 = SpillingKt.nullOutSpilledVariable(mediaLibraryModule$definition$lambda$24$$inlined$Coroutine$30);
            this.L$3 = strArr;
            this.L$4 = SpillingKt.nullOutSpilledVariable(strArr3);
            this.I$0 = 0;
            this.label = 1;
            mediaLibraryModule$definition$lambda$24$$inlined$Coroutine$31 = this;
            if (MediaLibraryModule.requestMediaLibraryActionPermission$default(mediaLibraryModule, strArr3, false, mediaLibraryModule$definition$lambda$24$$inlined$Coroutine$31, 2, null) != coroutine_suspended) {
                strArr2 = strArr3;
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
        strArr2 = (String[]) this.L$4;
        strArr = (String[]) this.L$3;
        mediaLibraryModule$definition$lambda$24$$inlined$Coroutine$30 = (Continuation) this.L$2;
        obj2 = this.L$1;
        ResultKt.throwOnFailure(obj);
        mediaLibraryModule$definition$lambda$24$$inlined$Coroutine$31 = this;
        Context context = mediaLibraryModule$definition$lambda$24$$inlined$Coroutine$31.this$0.getContext();
        mediaLibraryModule$definition$lambda$24$$inlined$Coroutine$31.L$0 = SpillingKt.nullOutSpilledVariable(objArr);
        mediaLibraryModule$definition$lambda$24$$inlined$Coroutine$31.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
        mediaLibraryModule$definition$lambda$24$$inlined$Coroutine$31.L$2 = SpillingKt.nullOutSpilledVariable(mediaLibraryModule$definition$lambda$24$$inlined$Coroutine$30);
        mediaLibraryModule$definition$lambda$24$$inlined$Coroutine$31.L$3 = SpillingKt.nullOutSpilledVariable(strArr);
        mediaLibraryModule$definition$lambda$24$$inlined$Coroutine$31.L$4 = SpillingKt.nullOutSpilledVariable(strArr2);
        mediaLibraryModule$definition$lambda$24$$inlined$Coroutine$31.I$0 = i;
        mediaLibraryModule$definition$lambda$24$$inlined$Coroutine$31.label = 2;
        Object objDeleteAlbums = DeleteAlbumsKt.deleteAlbums(context, strArr, mediaLibraryModule$definition$lambda$24$$inlined$Coroutine$31);
        return objDeleteAlbums == coroutine_suspended ? coroutine_suspended : objDeleteAlbums;
    }
}
