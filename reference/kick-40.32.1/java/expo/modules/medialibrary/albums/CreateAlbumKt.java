package expo.modules.medialibrary.albums;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.medialibrary.AlbumException;
import expo.modules.medialibrary.AssetFileException;
import expo.modules.medialibrary.MediaLibraryUtils;
import expo.modules.medialibrary.assets.CreateAssetWithAlbumFile;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.bouncycastle.asn1.eac.EACTags;

/* JADX INFO: compiled from: CreateAlbum.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a0\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010\t\u001a(\u0010\n\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"createAlbum", "Landroid/os/Bundle;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "albumName", "", "assetId", "copyAsset", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createAlbumWithInitialFileUri", "assetUri", "Landroid/net/Uri;", "(Landroid/content/Context;Ljava/lang/String;Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-media-library_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CreateAlbumKt {

    /* JADX INFO: renamed from: expo.modules.medialibrary.albums.CreateAlbumKt$createAlbumWithInitialFileUri$1, reason: invalid class name */
    /* JADX INFO: compiled from: CreateAlbum.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.albums.CreateAlbumKt", f = "CreateAlbum.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {EACTags.APPLICATION_IMAGE, EACTags.DISPLAY_IMAGE}, m = "createAlbumWithInitialFileUri", n = {RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "albumName", "assetUri", "mimeType", "assetUriPath", "albumFile", "mediaFile", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "albumName", "assetUri", "mimeType", "assetUriPath", "albumFile", "mediaFile"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CreateAlbumKt.createAlbumWithInitialFileUri(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.albums.CreateAlbumKt$createAlbum$2, reason: invalid class name */
    /* JADX INFO: compiled from: CreateAlbum.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/os/Bundle;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.albums.CreateAlbumKt$createAlbum$2", f = "CreateAlbum.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {36, 43}, m = "invokeSuspend", n = {"$this$withContext", "mStrategy", "files", "albumCreator", "album", "newFile", "$this$withContext", "mStrategy", "files", "albumCreator", "album", "newFile", "path", "uri", "selection", "args"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bundle>, Object> {
        final /* synthetic */ String $albumName;
        final /* synthetic */ String $assetId;
        final /* synthetic */ Context $context;
        final /* synthetic */ boolean $copyAsset;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(boolean z, Context context, String str, String str2, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$copyAsset = z;
            this.$context = context;
            this.$assetId = str;
            this.$albumName = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$copyAsset, this.$context, this.$assetId, this.$albumName, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Bundle> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x0146, code lost:
        
            if (r15 == r1) goto L27;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) throws expo.modules.medialibrary.UnableToLoadException, expo.modules.medialibrary.AlbumException, expo.modules.medialibrary.AssetFileException {
            /*
                Method dump skipped, instruction units count: 394
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: expo.modules.medialibrary.albums.CreateAlbumKt.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final Object createAlbum(Context context, String str, String str2, boolean z, Continuation<? super Bundle> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(z, context, str2, str, null), continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object createAlbumWithInitialFileUri(Context context, String str, Uri uri, Continuation<? super Bundle> continuation) throws AlbumException, AssetFileException {
        AnonymousClass1 anonymousClass1;
        String mimeType;
        String path;
        File fileCreateAlbumFile;
        File file;
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
            MediaLibraryUtils mediaLibraryUtils = MediaLibraryUtils.INSTANCE;
            ContentResolver contentResolver = context.getContentResolver();
            Intrinsics.checkNotNullExpressionValue(contentResolver, "getContentResolver(...)");
            mimeType = mediaLibraryUtils.getMimeType(contentResolver, uri);
            if (mimeType == null) {
                throw new AlbumException("Failed to create album: could not determine MIME type of the asset with uri: `" + uri + "`.");
            }
            path = uri.getPath();
            if (path == null) {
                throw new AlbumException("Failed to create album: could not determine path of the asset with uri: `" + uri + "`.");
            }
            fileCreateAlbumFile = AlbumUtilsKt.createAlbumFile(mimeType, str);
            file = new File(path);
            if (!file.exists()) {
                throw new AlbumException("Failed to create album: the local media file with uri: `" + uri + "` does not exist.");
            }
            String string = uri.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            CreateAssetWithAlbumFile createAssetWithAlbumFile = new CreateAssetWithAlbumFile(context, string, false, fileCreateAlbumFile);
            anonymousClass1.L$0 = context;
            anonymousClass1.L$1 = str;
            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(uri);
            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(mimeType);
            anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(path);
            anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(fileCreateAlbumFile);
            anonymousClass1.L$6 = SpillingKt.nullOutSpilledVariable(file);
            anonymousClass1.label = 1;
            if (createAssetWithAlbumFile.execute(anonymousClass1) != coroutine_suspended) {
            }
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        File file2 = (File) anonymousClass1.L$6;
        File file3 = (File) anonymousClass1.L$5;
        String str2 = (String) anonymousClass1.L$4;
        mimeType = (String) anonymousClass1.L$3;
        Uri uri2 = (Uri) anonymousClass1.L$2;
        String str3 = (String) anonymousClass1.L$1;
        Context context2 = (Context) anonymousClass1.L$0;
        ResultKt.throwOnFailure(obj);
        file = file2;
        context = context2;
        fileCreateAlbumFile = file3;
        str = str3;
        path = str2;
        uri = uri2;
        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(context);
        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str);
        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(uri);
        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(mimeType);
        anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(path);
        anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(fileCreateAlbumFile);
        anonymousClass1.L$6 = SpillingKt.nullOutSpilledVariable(file);
        anonymousClass1.label = 2;
        Object album = GetAlbumKt.getAlbum(context, str, anonymousClass1);
        return album == coroutine_suspended ? coroutine_suspended : album;
    }
}
