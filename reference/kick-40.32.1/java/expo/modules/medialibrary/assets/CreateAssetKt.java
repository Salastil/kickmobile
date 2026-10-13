package expo.modules.medialibrary.assets;

import android.content.Context;
import androidx.media3.muxer.WebmConstants;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.imagepipeline.common.RotationOptions;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: CreateAsset.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001aH\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0086@¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"createAssetWithAlbumId", "Ljava/util/ArrayList;", "Landroid/os/Bundle;", "Lkotlin/collections/ArrayList;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "uri", "", "resolveWithAdditionalData", "", "albumId", "(Landroid/content/Context;Ljava/lang/String;ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-media-library_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CreateAssetKt {

    /* JADX INFO: renamed from: expo.modules.medialibrary.assets.CreateAssetKt$createAssetWithAlbumId$1, reason: invalid class name */
    /* JADX INFO: compiled from: CreateAsset.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.assets.CreateAssetKt", f = "CreateAsset.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {RotationOptions.ROTATE_180, WebmConstants.MkvEbmlElement.SAMPLING_FREQUENCY}, m = "createAssetWithAlbumId", n = {RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "uri", "albumId", "it", "resolveWithAdditionalData", "$i$a$-let-CreateAssetKt$createAssetWithAlbumId$album$1", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "uri", "albumId", "album", "resolveWithAdditionalData"}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "Z$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CreateAssetKt.createAssetWithAlbumId(null, null, false, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x00b2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0083, code lost:
    
        if (r10 == r1) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object createAssetWithAlbumId(android.content.Context r6, java.lang.String r7, boolean r8, java.lang.String r9, kotlin.coroutines.Continuation<? super java.util.ArrayList<android.os.Bundle>> r10) throws expo.modules.medialibrary.UnableToSaveException, expo.modules.medialibrary.UnableToLoadPermissionException, java.io.IOException, expo.modules.medialibrary.AssetFileException {
        /*
            boolean r0 = r10 instanceof expo.modules.medialibrary.assets.CreateAssetKt.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r10
            expo.modules.medialibrary.assets.CreateAssetKt$createAssetWithAlbumId$1 r0 = (expo.modules.medialibrary.assets.CreateAssetKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            expo.modules.medialibrary.assets.CreateAssetKt$createAssetWithAlbumId$1 r0 = new expo.modules.medialibrary.assets.CreateAssetKt$createAssetWithAlbumId$1
            r0.<init>(r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L63
            if (r2 == r4) goto L47
            if (r2 != r3) goto L3f
            boolean r6 = r0.Z$0
            java.lang.Object r6 = r0.L$3
            java.io.File r6 = (java.io.File) r6
            java.lang.Object r6 = r0.L$2
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r6 = r0.L$1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r6 = r0.L$0
            android.content.Context r6 = (android.content.Context) r6
            kotlin.ResultKt.throwOnFailure(r10)
            return r10
        L3f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L47:
            int r6 = r0.I$0
            boolean r6 = r0.Z$0
            java.lang.Object r7 = r0.L$3
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r7 = r0.L$2
            r9 = r7
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r7 = r0.L$1
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = r0.L$0
            android.content.Context r8 = (android.content.Context) r8
            kotlin.ResultKt.throwOnFailure(r10)
            r5 = r8
            r8 = r6
            r6 = r5
            goto L86
        L63:
            kotlin.ResultKt.throwOnFailure(r10)
            if (r9 == 0) goto L89
            r0.L$0 = r6
            r0.L$1 = r7
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r0.L$2 = r10
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r0.L$3 = r10
            r0.Z$0 = r8
            r10 = 0
            r0.I$0 = r10
            r0.label = r4
            java.lang.Object r10 = expo.modules.medialibrary.albums.AlbumUtilsKt.getAlbumFileOrNull(r6, r9, r0)
            if (r10 != r1) goto L86
            goto Lb1
        L86:
            java.io.File r10 = (java.io.File) r10
            goto L8a
        L89:
            r10 = 0
        L8a:
            expo.modules.medialibrary.assets.CreateAssetWithAlbumFile r2 = new expo.modules.medialibrary.assets.CreateAssetWithAlbumFile
            r2.<init>(r6, r7, r8, r10)
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$0 = r6
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r0.L$1 = r6
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r0.L$2 = r6
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r0.L$3 = r6
            r0.Z$0 = r8
            r0.label = r3
            java.lang.Object r6 = r2.execute(r0)
            if (r6 != r1) goto Lb2
        Lb1:
            return r1
        Lb2:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.medialibrary.assets.CreateAssetKt.createAssetWithAlbumId(android.content.Context, java.lang.String, boolean, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object createAssetWithAlbumId$default(Context context, String str, boolean z, String str2, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        return createAssetWithAlbumId(context, str, z, str2, continuation);
    }
}
