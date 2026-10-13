package expo.modules.medialibrary.next;

import android.net.Uri;
import expo.modules.medialibrary.next.exceptions.AlbumPropertyNotFoundException;
import expo.modules.medialibrary.next.exceptions.ContentResolverNotObtainedException;
import expo.modules.medialibrary.next.objects.album.Album;
import expo.modules.medialibrary.next.objects.asset.factories.AssetFactory;
import expo.modules.medialibrary.next.objects.wrappers.RelativePath;
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
@DebugMetadata(c = "expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$37", f = "MediaLibraryNextModule.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {271, 271}, m = "invokeSuspend", n = {"<destruct>", "p0", "p1", "$completion", "album", "filePath", "$i$a$-Coroutine-MediaLibraryNextModule$definition$1$3$19", "<destruct>", "p0", "p1", "$completion", "album", "filePath", "$i$a$-Coroutine-MediaLibraryNextModule$definition$1$3$19"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0"})
public final class MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$37 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
    int I$0;
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    final /* synthetic */ MediaLibraryNextModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$37(Continuation continuation, MediaLibraryNextModule mediaLibraryNextModule) {
        super(3, continuation);
        this.this$0 = mediaLibraryNextModule;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<? super Object> continuation) {
        return invoke2(coroutineScope, objArr, (Continuation<Object>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
        MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$37 mediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$37 = new MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$37(continuation, this.this$0);
        mediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$37.L$0 = objArr;
        return mediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$37.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x00df A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws AlbumPropertyNotFoundException, ContentResolverNotObtainedException {
        int i;
        Object obj2;
        Object obj3;
        MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$37 mediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$37;
        Album album;
        Uri uri;
        AssetFactory assetFactory;
        int i2;
        String str;
        Uri uri2;
        AssetFactory assetFactory2;
        Object objM12049unboximpl;
        Uri uri3;
        Object objMo12019createBuevYFM;
        Object[] objArr = (Object[]) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            i = 0;
            obj2 = objArr[0];
            obj3 = objArr[1];
            mediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$37 = this;
            album = (Album) obj3;
            uri = (Uri) obj2;
            assetFactory = this.this$0.getAssetFactory();
            if (album != null) {
                this.L$0 = SpillingKt.nullOutSpilledVariable(objArr);
                this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
                this.L$2 = SpillingKt.nullOutSpilledVariable(obj3);
                this.L$3 = SpillingKt.nullOutSpilledVariable(mediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$37);
                this.L$4 = SpillingKt.nullOutSpilledVariable(album);
                this.L$5 = SpillingKt.nullOutSpilledVariable(uri);
                this.L$6 = uri;
                this.L$7 = assetFactory;
                this.I$0 = 0;
                this.label = 1;
                Object objM12005getRelativePathMwbCjzw = album.m12005getRelativePathMwbCjzw(this);
                if (objM12005getRelativePathMwbCjzw != coroutine_suspended) {
                    assetFactory2 = assetFactory;
                    objM12049unboximpl = objM12005getRelativePathMwbCjzw;
                    uri3 = uri;
                }
            } else {
                i2 = 0;
                str = null;
                uri2 = uri;
                this.L$0 = SpillingKt.nullOutSpilledVariable(objArr);
                this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
                this.L$2 = SpillingKt.nullOutSpilledVariable(obj3);
                this.L$3 = SpillingKt.nullOutSpilledVariable(mediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$37);
                this.L$4 = SpillingKt.nullOutSpilledVariable(album);
                this.L$5 = SpillingKt.nullOutSpilledVariable(uri);
                this.L$6 = null;
                this.L$7 = null;
                this.I$0 = i2;
                this.label = 2;
                objMo12019createBuevYFM = assetFactory.mo12019createBuevYFM(uri2, str, this);
                if (objMo12019createBuevYFM != coroutine_suspended) {
                    return objMo12019createBuevYFM;
                }
            }
            return coroutine_suspended;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        i = this.I$0;
        assetFactory2 = (AssetFactory) this.L$7;
        uri = (Uri) this.L$6;
        uri3 = (Uri) this.L$5;
        album = (Album) this.L$4;
        mediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$37 = (Continuation) this.L$3;
        obj3 = this.L$2;
        obj2 = this.L$1;
        ResultKt.throwOnFailure(obj);
        objM12049unboximpl = ((RelativePath) obj).m12049unboximpl();
        int i4 = i;
        str = (String) objM12049unboximpl;
        assetFactory = assetFactory2;
        i2 = i4;
        Uri uri4 = uri3;
        uri2 = uri;
        uri = uri4;
        this.L$0 = SpillingKt.nullOutSpilledVariable(objArr);
        this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
        this.L$2 = SpillingKt.nullOutSpilledVariable(obj3);
        this.L$3 = SpillingKt.nullOutSpilledVariable(mediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$37);
        this.L$4 = SpillingKt.nullOutSpilledVariable(album);
        this.L$5 = SpillingKt.nullOutSpilledVariable(uri);
        this.L$6 = null;
        this.L$7 = null;
        this.I$0 = i2;
        this.label = 2;
        objMo12019createBuevYFM = assetFactory.mo12019createBuevYFM(uri2, str, this);
        if (objMo12019createBuevYFM != coroutine_suspended) {
            return coroutine_suspended;
        }
        return objMo12019createBuevYFM;
    }
}
