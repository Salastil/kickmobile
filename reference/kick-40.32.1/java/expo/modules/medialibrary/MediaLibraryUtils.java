package expo.modules.medialibrary;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.datadog.android.webview.internal.log.WebViewLogEventConsumer;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: MediaLibraryUtils.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u00012B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tJ\u0016\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tJ4\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0012\u0010\u0012\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0013H\u0086@¢\u0006\u0002\u0010\u0014J\u001d\u0010\u0015\u001a\u00020\u00062\u0010\u0010\u0016\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\u0013¢\u0006\u0002\u0010\u0017J1\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u000f\u001a\u00020\u00102\u0016\u0010\u001b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\u0013\"\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u001cJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001e\u001a\u00020\u0006H\u0002J\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00062\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J'\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u00192\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\u0010\u001cJ\u0010\u0010%\u001a\u00020#2\b\u0010&\u001a\u0004\u0018\u00010\u0006J\u0018\u0010'\u001a\u00020\u00062\b\u0010&\u001a\u0004\u0018\u00010\u00062\u0006\u0010(\u001a\u00020\u000eJ\u0018\u0010)\u001a\u00020\t2\b\u0010&\u001a\u0004\u0018\u00010\u00062\u0006\u0010(\u001a\u00020\u000eJ\u0016\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00060+2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0016\u0010,\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u0006JB\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010#0\u00052\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00060\u00132\u000e\u00100\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013H\u0086@¢\u0006\u0002\u00101¨\u00063"}, d2 = {"Lexpo/modules/medialibrary/MediaLibraryUtils;", "", "<init>", "()V", "getFileNameAndExtension", "Lkotlin/Pair;", "", "name", "safeMoveFile", "Ljava/io/File;", "src", "destDir", "safeCopyFile", "deleteAssets", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "selection", "selectionArgs", "", "(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryPlaceholdersFor", "assetIds", "([Ljava/lang/String;)Ljava/lang/String;", "getAssetsById", "", "Lexpo/modules/medialibrary/MediaLibraryUtils$AssetFile;", "assetsId", "(Landroid/content/Context;[Ljava/lang/String;)Ljava/util/List;", "getMimeTypeFromFileUrl", ImagesContract.URL, "getMimeType", "contentResolver", "Landroid/content/ContentResolver;", "uri", "Landroid/net/Uri;", "getAssetsUris", "mimeTypeToExternalUri", "mimeType", "getRelativePathForAssetType", "useCameraDir", "getEnvDirectoryForAssetType", "getManifestPermissions", "", "hasManifestPermission", "permission", "scanFile", "paths", "mimeTypes", "(Landroid/content/Context;[Ljava/lang/String;[Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "AssetFile", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MediaLibraryUtils {
    public static final MediaLibraryUtils INSTANCE = new MediaLibraryUtils();

    /* JADX INFO: compiled from: MediaLibraryUtils.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"Lexpo/modules/medialibrary/MediaLibraryUtils$AssetFile;", "Ljava/io/File;", "pathname", "", "assetId", "mimeType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAssetId", "()Ljava/lang/String;", "getMimeType", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class AssetFile extends File {
        private final String assetId;
        private final String mimeType;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AssetFile(String pathname, String assetId, String mimeType) {
            super(pathname);
            Intrinsics.checkNotNullParameter(pathname, "pathname");
            Intrinsics.checkNotNullParameter(assetId, "assetId");
            Intrinsics.checkNotNullParameter(mimeType, "mimeType");
            this.assetId = assetId;
            this.mimeType = mimeType;
        }

        public final String getAssetId() {
            return this.assetId;
        }

        public final String getMimeType() {
            return this.mimeType;
        }
    }

    private MediaLibraryUtils() {
    }

    public final Pair<String, String> getFileNameAndExtension(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Integer numValueOf = Integer.valueOf(StringsKt.lastIndexOf$default((CharSequence) name, ".", 0, false, 6, (Object) null));
        if (numValueOf.intValue() == -1) {
            numValueOf = null;
        }
        int iIntValue = numValueOf != null ? numValueOf.intValue() : name.length();
        String strSubstring = name.substring(iIntValue);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        String strSubstring2 = name.substring(0, iIntValue);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
        return new Pair<>(strSubstring2, strSubstring);
    }

    public final File safeMoveFile(File src, File destDir) throws IOException {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(destDir, "destDir");
        File fileSafeCopyFile = safeCopyFile(src, destDir);
        src.delete();
        return fileSafeCopyFile;
    }

    public final File safeCopyFile(File src, File destDir) throws IOException {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(destDir, "destDir");
        File file = new File(destDir, src.getName());
        String name = src.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        Pair<String, String> fileNameAndExtension = getFileNameAndExtension(name);
        String strComponent1 = fileNameAndExtension.component1();
        String strComponent2 = fileNameAndExtension.component2();
        int i = 0;
        while (file.exists()) {
            file = new File(destDir, strComponent1 + "_" + i + strComponent2);
            i++;
            if (i > 32767) {
                throw new IOException("File name suffix limit reached (32767)");
            }
        }
        FileChannel channel = new FileInputStream(src).getChannel();
        try {
            FileChannel fileChannel = channel;
            FileChannel channel2 = new FileOutputStream(file).getChannel();
            try {
                FileChannel fileChannel2 = channel2;
                Intrinsics.checkNotNull(fileChannel);
                Intrinsics.checkNotNull(fileChannel2);
                if (FileChannelExtensionsKt.transferAllTo(fileChannel, fileChannel2) != fileChannel.size()) {
                    file.delete();
                    throw new IOException("Could not save file to " + destDir + " Not enough space.");
                }
                CloseableKt.closeFinally(channel2, null);
                CloseableKt.closeFinally(channel, null);
                return file;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(channel2, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            throw th3;
        }
        try {
            throw th3;
        } catch (Throwable th4) {
            CloseableKt.closeFinally(channel, th3);
            throw th4;
        }
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.MediaLibraryUtils$deleteAssets$2, reason: invalid class name */
    /* JADX INFO: compiled from: MediaLibraryUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.MediaLibraryUtils$deleteAssets$2", f = "MediaLibraryUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ String $selection;
        final /* synthetic */ String[] $selectionArgs;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Context context, String str, String[] strArr, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$selection = str;
            this.$selectionArgs = strArr;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$context, this.$selection, this.$selectionArgs, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws UnableToDeleteException {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                Cursor cursorQuery = this.$context.getContentResolver().query(MediaLibraryConstantsKt.getEXTERNAL_CONTENT_URI(), new String[]{"_id", "_data"}, this.$selection, this.$selectionArgs, null);
                Context context = this.$context;
                try {
                    Cursor cursor = cursorQuery;
                    if (cursor == null) {
                        throw new AssetFileException("Could not delete assets. Cursor is null.");
                    }
                    while (cursor.moveToNext()) {
                        JobKt.ensureActive(coroutineScope.getCoroutineContext());
                        if (Build.VERSION.SDK_INT >= 30) {
                            Uri uriWithAppendedId = ContentUris.withAppendedId(MediaLibraryConstantsKt.getEXTERNAL_CONTENT_URI(), cursor.getLong(cursor.getColumnIndex("_id")));
                            Intrinsics.checkNotNullExpressionValue(uriWithAppendedId, "withAppendedId(...)");
                            if (context.getContentResolver().delete(uriWithAppendedId, null) == 0) {
                                throw new AssetFileException("Could not delete file.");
                            }
                        } else {
                            String string = cursor.getString(cursor.getColumnIndex("_data"));
                            if (!new File(string).delete()) {
                                throw new AssetFileException("Could not delete file.");
                            }
                            Boxing.boxInt(context.getContentResolver().delete(MediaLibraryConstantsKt.getEXTERNAL_CONTENT_URI(), "_data=?", new String[]{string}));
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(cursorQuery, null);
                    return Boxing.boxBoolean(true);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(cursorQuery, th);
                        throw th2;
                    }
                }
            } catch (SecurityException e) {
                throw new UnableToDeleteException("Could not delete asset: need WRITE_EXTERNAL_STORAGE permission.", e);
            } catch (Exception e2) {
                throw new UnableToDeleteException("Could not delete file: " + e2.getMessage(), e2);
            }
        }
    }

    public final Object deleteAssets(Context context, String str, String[] strArr, Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(context, str, strArr, null), continuation);
    }

    public final String queryPlaceholdersFor(String[] assetIds) {
        Intrinsics.checkNotNullParameter(assetIds, "assetIds");
        String[] strArr = new String[assetIds.length];
        ArraysKt.fill$default(strArr, "?", 0, 0, 6, (Object) null);
        return ArraysKt.joinToString$default(strArr, WebViewLogEventConsumer.DDTAGS_SEPARATOR, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    public final List<AssetFile> getAssetsById(Context context, String... assetsId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(assetsId, "assetsId");
        Cursor cursorQuery = context.getContentResolver().query(MediaLibraryConstantsKt.getEXTERNAL_CONTENT_URI(), new String[]{"_id", "_data", "bucket_id", "mime_type"}, "_id IN ( " + queryPlaceholdersFor(assetsId) + " )", assetsId, null);
        try {
            Cursor cursor = cursorQuery;
            if (cursor == null) {
                throw new AssetFileException("Could not get assets. Query returns null.");
            }
            if (cursor.getCount() != assetsId.length) {
                throw new AssetFileException("Could not get all of the requested assets");
            }
            ArrayList arrayList = new ArrayList();
            while (cursor.moveToNext()) {
                String string = cursor.getString(cursor.getColumnIndex("_data"));
                int columnIndex = cursor.getColumnIndex("_id");
                int columnIndex2 = cursor.getColumnIndex("mime_type");
                Intrinsics.checkNotNull(string);
                String string2 = cursor.getString(columnIndex);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                String string3 = cursor.getString(columnIndex2);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                AssetFile assetFile = new AssetFile(string, string2, string3);
                if (!assetFile.exists() || !assetFile.isFile()) {
                    throw new AssetFileException("Path " + string + " does not exist or isn't file.");
                }
                arrayList.add(assetFile);
            }
            CloseableKt.closeFinally(cursorQuery, null);
            return arrayList;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(cursorQuery, th);
                throw th2;
            }
        }
    }

    private final String getMimeTypeFromFileUrl(String url) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(url);
        if (fileExtensionFromUrl == null) {
            return null;
        }
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
    }

    public final String getMimeType(ContentResolver contentResolver, Uri uri) {
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        Intrinsics.checkNotNullParameter(uri, "uri");
        String type = contentResolver.getType(uri);
        if (type != null) {
            return type;
        }
        String string = uri.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return getMimeTypeFromFileUrl(string);
    }

    public final List<Uri> getAssetsUris(Context context, String[] assetsId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(assetsId, "assetsId");
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = context.getContentResolver().query(MediaLibraryConstantsKt.getEXTERNAL_CONTENT_URI(), new String[]{"_id", "mime_type"}, "_id IN (" + TextUtils.join(WebViewLogEventConsumer.DDTAGS_SEPARATOR, assetsId) + " )", null, null);
        if (cursorQuery == null) {
            return arrayList;
        }
        Cursor cursor = cursorQuery;
        try {
            Cursor cursor2 = cursor;
            while (cursor2.moveToNext()) {
                int columnIndex = cursor2.getColumnIndex("_id");
                Uri uriWithAppendedId = ContentUris.withAppendedId(INSTANCE.mimeTypeToExternalUri(cursor2.getString(cursor2.getColumnIndex("mime_type"))), cursor2.getLong(columnIndex));
                Intrinsics.checkNotNullExpressionValue(uriWithAppendedId, "withAppendedId(...)");
                arrayList.add(uriWithAppendedId);
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(cursor, null);
            return arrayList;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(cursor, th);
                throw th2;
            }
        }
    }

    public final Uri mimeTypeToExternalUri(String mimeType) {
        if (mimeType == null) {
            Uri EXTERNAL_CONTENT_URI = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            Intrinsics.checkNotNullExpressionValue(EXTERNAL_CONTENT_URI, "EXTERNAL_CONTENT_URI");
            return EXTERNAL_CONTENT_URI;
        }
        String str = mimeType;
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "image", false, 2, (Object) null)) {
            Uri EXTERNAL_CONTENT_URI2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            Intrinsics.checkNotNullExpressionValue(EXTERNAL_CONTENT_URI2, "EXTERNAL_CONTENT_URI");
            return EXTERNAL_CONTENT_URI2;
        }
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "video", false, 2, (Object) null)) {
            Uri EXTERNAL_CONTENT_URI3 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            Intrinsics.checkNotNullExpressionValue(EXTERNAL_CONTENT_URI3, "EXTERNAL_CONTENT_URI");
            return EXTERNAL_CONTENT_URI3;
        }
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "audio", false, 2, (Object) null)) {
            Uri EXTERNAL_CONTENT_URI4 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            Intrinsics.checkNotNullExpressionValue(EXTERNAL_CONTENT_URI4, "EXTERNAL_CONTENT_URI");
            return EXTERNAL_CONTENT_URI4;
        }
        return MediaLibraryConstantsKt.getEXTERNAL_CONTENT_URI();
    }

    public final String getRelativePathForAssetType(String mimeType, boolean useCameraDir) {
        if ((mimeType != null && StringsKt.contains$default((CharSequence) mimeType, (CharSequence) "image", false, 2, (Object) null)) || (mimeType != null && StringsKt.contains$default((CharSequence) mimeType, (CharSequence) "video", false, 2, (Object) null))) {
            if (useCameraDir) {
                String str = Environment.DIRECTORY_DCIM;
                Intrinsics.checkNotNull(str);
                return str;
            }
            String str2 = Environment.DIRECTORY_PICTURES;
            Intrinsics.checkNotNull(str2);
            return str2;
        }
        if (mimeType != null && StringsKt.contains$default((CharSequence) mimeType, (CharSequence) "audio", false, 2, (Object) null)) {
            String DIRECTORY_MUSIC = Environment.DIRECTORY_MUSIC;
            Intrinsics.checkNotNullExpressionValue(DIRECTORY_MUSIC, "DIRECTORY_MUSIC");
            return DIRECTORY_MUSIC;
        }
        if (useCameraDir) {
            String str3 = Environment.DIRECTORY_DCIM;
            Intrinsics.checkNotNull(str3);
            return str3;
        }
        String str4 = Environment.DIRECTORY_PICTURES;
        Intrinsics.checkNotNull(str4);
        return str4;
    }

    public final File getEnvDirectoryForAssetType(String mimeType, boolean useCameraDir) {
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(getRelativePathForAssetType(mimeType, useCameraDir));
        Intrinsics.checkNotNullExpressionValue(externalStoragePublicDirectory, "getExternalStoragePublicDirectory(...)");
        return externalStoragePublicDirectory;
    }

    private final Set<String> getManifestPermissions(Context context) {
        Set<String> set;
        PackageManager packageManager = context.getPackageManager();
        Intrinsics.checkNotNullExpressionValue(packageManager, "getPackageManager(...)");
        try {
            String[] strArr = packageManager.getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr != null && (set = ArraysKt.toSet(strArr)) != null) {
                return set;
            }
            return SetsKt.emptySet();
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("expo-media-library", "Failed to list AndroidManifest.xml permissions");
            e.printStackTrace();
            return SetsKt.emptySet();
        }
    }

    public final boolean hasManifestPermission(Context context, String permission) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(permission, "permission");
        return getManifestPermissions(context).contains(permission);
    }

    public final Object scanFile(Context context, String[] strArr, String[] strArr2, Continuation<? super Pair<String, ? extends Uri>> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        MediaScannerConnection.scanFile(context, strArr, strArr2, new MediaScannerConnection.OnScanCompletedListener() { // from class: expo.modules.medialibrary.MediaLibraryUtils$scanFile$2$1
            @Override // android.media.MediaScannerConnection.OnScanCompletedListener
            public final void onScanCompleted(String path, Uri uri) {
                Intrinsics.checkNotNullParameter(path, "path");
                Continuation<Pair<String, ? extends Uri>> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m12684constructorimpl(new Pair(path, uri)));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }
}
