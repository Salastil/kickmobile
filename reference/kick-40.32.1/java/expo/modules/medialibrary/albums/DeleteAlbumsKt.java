package expo.modules.medialibrary.albums;

import android.content.Context;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.medialibrary.MediaLibraryUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;

/* JADX INFO: compiled from: DeleteAlbums.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a$\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0086@¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"deleteAlbums", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "albumIds", "", "", "(Landroid/content/Context;[Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-media-library_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DeleteAlbumsKt {

    /* JADX INFO: renamed from: expo.modules.medialibrary.albums.DeleteAlbumsKt$deleteAlbums$1, reason: invalid class name */
    /* JADX INFO: compiled from: DeleteAlbums.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.albums.DeleteAlbumsKt", f = "DeleteAlbums.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {12, 13}, m = "deleteAlbums", n = {RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "albumIds", "selectionImages", "selectionVideos", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "albumIds", "selectionImages", "selectionVideos"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DeleteAlbumsKt.deleteAlbums(null, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object deleteAlbums(Context context, String[] strArr, Continuation<? super Boolean> continuation) {
        AnonymousClass1 anonymousClass1;
        String str;
        String str2;
        Object objDeleteAssets;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            str = "bucket_id IN (" + MediaLibraryUtils.INSTANCE.queryPlaceholdersFor(strArr) + ")";
            str2 = "bucket_id IN (" + MediaLibraryUtils.INSTANCE.queryPlaceholdersFor(strArr) + ")";
            MediaLibraryUtils mediaLibraryUtils = MediaLibraryUtils.INSTANCE;
            anonymousClass1.L$0 = context;
            anonymousClass1.L$1 = strArr;
            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(str);
            anonymousClass1.L$3 = str2;
            anonymousClass1.label = 1;
            objDeleteAssets = mediaLibraryUtils.deleteAssets(context, str, strArr, anonymousClass1);
            if (objDeleteAssets != coroutine_suspended) {
            }
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        String str3 = (String) anonymousClass1.L$3;
        String str4 = (String) anonymousClass1.L$2;
        String[] strArr2 = (String[]) anonymousClass1.L$1;
        Context context2 = (Context) anonymousClass1.L$0;
        ResultKt.throwOnFailure(obj);
        str2 = str3;
        context = context2;
        objDeleteAssets = obj;
        str = str4;
        strArr = strArr2;
        if (((Boolean) objDeleteAssets).booleanValue()) {
            MediaLibraryUtils mediaLibraryUtils2 = MediaLibraryUtils.INSTANCE;
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(context);
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(strArr);
            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(str);
            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(str2);
            anonymousClass1.label = 2;
            Object objDeleteAssets2 = mediaLibraryUtils2.deleteAssets(context, str2, strArr, anonymousClass1);
            return objDeleteAssets2 == coroutine_suspended ? coroutine_suspended : objDeleteAssets2;
        }
        return Boxing.boxBoolean(false);
    }
}
