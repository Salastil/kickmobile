package expo.modules.medialibrary.assets;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import androidx.media3.muxer.WebmConstants;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.common.util.UriUtil;
import expo.modules.medialibrary.AssetException;
import expo.modules.medialibrary.AssetFileException;
import expo.modules.medialibrary.ContentEntryException;
import expo.modules.medialibrary.FileChannelExtensionsKt;
import expo.modules.medialibrary.MediaLibraryUtils;
import expo.modules.medialibrary.UnableToLoadPermissionException;
import expo.modules.medialibrary.UnableToSaveException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: CreateAsset.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\n\u0010\u0011\u001a\u0004\u0018\u00010\rH\u0003J\u001e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\rH\u0083@¢\u0006\u0002\u0010\u0016J\"\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020\u0019\u0018\u0001`\u001aH\u0083@¢\u0006\u0002\u0010\u001bJ\u0014\u0010\u001c\u001a\u00020\t2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\"\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020\u0019\u0018\u0001`\u001aH\u0086@¢\u0006\u0002\u0010\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001e"}, d2 = {"Lexpo/modules/medialibrary/assets/CreateAssetWithAlbumFile;", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "uri", "", "resolveWithAdditionalData", "", "albumFile", "Ljava/io/File;", "<init>", "(Landroid/content/Context;Ljava/lang/String;ZLjava/io/File;)V", "mUri", "Landroid/net/Uri;", "normalizeAssetUri", "isFileExtensionPresent", "()Z", "createContentResolverAssetEntry", "writeFileContentsToAsset", "", "localFile", "assetUri", "(Ljava/io/File;Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createAssetUsingContentResolver", "Ljava/util/ArrayList;", "Landroid/os/Bundle;", "Lkotlin/collections/ArrayList;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createAssetFileLegacy", "execute", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CreateAssetWithAlbumFile {
    private final File albumFile;
    private final Context context;
    private final Uri mUri;
    private final boolean resolveWithAdditionalData;

    /* JADX INFO: renamed from: expo.modules.medialibrary.assets.CreateAssetWithAlbumFile$execute$1, reason: invalid class name */
    /* JADX INFO: compiled from: CreateAsset.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.assets.CreateAssetWithAlbumFile", f = "CreateAsset.kt", i = {1, 2, 2, 2, 2, 2}, l = {147, 152, WebmConstants.MkvEbmlElement.BLOCK}, m = "execute", n = {UriUtil.LOCAL_ASSET_SCHEME, UriUtil.LOCAL_ASSET_SCHEME, "path", "uri", "selection", "args"}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CreateAssetWithAlbumFile.this.execute(this);
        }
    }

    public CreateAssetWithAlbumFile(Context context, String uri, boolean z, File file) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.context = context;
        this.resolveWithAdditionalData = z;
        this.albumFile = file;
        this.mUri = normalizeAssetUri(uri);
    }

    public /* synthetic */ CreateAssetWithAlbumFile(Context context, String str, boolean z, File file, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, (i & 4) != 0 ? true : z, file);
    }

    private final Uri normalizeAssetUri(String uri) {
        if (StringsKt.startsWith$default(uri, DomExceptionUtils.SEPARATOR, false, 2, (Object) null)) {
            Uri uriFromFile = Uri.fromFile(new File(uri));
            Intrinsics.checkNotNull(uriFromFile);
            return uriFromFile;
        }
        Uri uri2 = Uri.parse(uri);
        Intrinsics.checkNotNull(uri2);
        return uri2;
    }

    private final boolean isFileExtensionPresent() {
        String lastPathSegment = this.mUri.getLastPathSegment();
        if (lastPathSegment != null) {
            return StringsKt.contains$default((CharSequence) lastPathSegment, (CharSequence) ".", false, 2, (Object) null);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:8:0x0031  */
    public final Uri createContentResolverAssetEntry() {
        String relativePathForAssetType;
        ContentResolver contentResolver = this.context.getContentResolver();
        MediaLibraryUtils mediaLibraryUtils = MediaLibraryUtils.INSTANCE;
        Intrinsics.checkNotNull(contentResolver);
        String mimeType = mediaLibraryUtils.getMimeType(contentResolver, this.mUri);
        String lastPathSegment = this.mUri.getLastPathSegment();
        File file = this.albumFile;
        if (file != null) {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            Intrinsics.checkNotNullExpressionValue(externalStorageDirectory, "getExternalStorageDirectory(...)");
            File fileRelativeTo = FilesKt.relativeTo(file, externalStorageDirectory);
            if (fileRelativeTo == null || (relativePathForAssetType = fileRelativeTo.getPath()) == null) {
                relativePathForAssetType = MediaLibraryUtils.INSTANCE.getRelativePathForAssetType(mimeType, true);
            }
        } else {
            relativePathForAssetType = MediaLibraryUtils.INSTANCE.getRelativePathForAssetType(mimeType, true);
        }
        Uri uriMimeTypeToExternalUri = MediaLibraryUtils.INSTANCE.mimeTypeToExternalUri(mimeType);
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", lastPathSegment);
        contentValues.put("mime_type", mimeType);
        contentValues.put("relative_path", relativePathForAssetType);
        contentValues.put("is_pending", (Integer) 1);
        return contentResolver.insert(uriMimeTypeToExternalUri, contentValues);
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.assets.CreateAssetWithAlbumFile$writeFileContentsToAsset$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CreateAsset.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.assets.CreateAssetWithAlbumFile$writeFileContentsToAsset$2", f = "CreateAsset.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C08732 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
        final /* synthetic */ Uri $assetUri;
        final /* synthetic */ File $localFile;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08732(File file, Uri uri, Continuation<? super C08732> continuation) {
            super(2, continuation);
            this.$localFile = file;
            this.$assetUri = uri;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C08732 c08732 = CreateAssetWithAlbumFile.this.new C08732(this.$localFile, this.$assetUri, continuation);
            c08732.L$0 = obj;
            return c08732;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
            return ((C08732) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ContentResolver contentResolver = CreateAssetWithAlbumFile.this.context.getContentResolver();
                JobKt.ensureActive(coroutineScope.getCoroutineContext());
                FileChannel channel = new FileInputStream(this.$localFile).getChannel();
                Uri uri = this.$assetUri;
                try {
                    FileChannel fileChannel = channel;
                    OutputStream outputStreamOpenOutputStream = contentResolver.openOutputStream(uri);
                    Intrinsics.checkNotNull(outputStreamOpenOutputStream, "null cannot be cast to non-null type java.io.FileOutputStream");
                    FileChannel channel2 = ((FileOutputStream) outputStreamOpenOutputStream).getChannel();
                    try {
                        FileChannel fileChannel2 = channel2;
                        Intrinsics.checkNotNull(fileChannel);
                        Intrinsics.checkNotNull(fileChannel2);
                        if (FileChannelExtensionsKt.transferAllTo(fileChannel, fileChannel2) != fileChannel.size()) {
                            contentResolver.delete(uri, null, null);
                            throw new IOException("Could not save file to " + uri + " Not enough space.");
                        }
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(channel2, null);
                        Unit unit2 = Unit.INSTANCE;
                        CloseableKt.closeFinally(channel, null);
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("is_pending", Boxing.boxInt(0));
                        return Boxing.boxInt(contentResolver.update(this.$assetUri, contentValues, null, null));
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(channel2, th);
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    try {
                        throw th3;
                    } catch (Throwable th4) {
                        CloseableKt.closeFinally(channel, th3);
                        throw th4;
                    }
                }
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object writeFileContentsToAsset(File file, Uri uri, Continuation<? super Integer> continuation) throws IOException {
        return BuildersKt.withContext(Dispatchers.getIO(), new C08732(file, uri, null), continuation);
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.assets.CreateAssetWithAlbumFile$createAssetUsingContentResolver$2, reason: invalid class name */
    /* JADX INFO: compiled from: CreateAsset.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0003*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Ljava/util/ArrayList;", "Landroid/os/Bundle;", "Lkotlin/collections/ArrayList;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.assets.CreateAssetWithAlbumFile$createAssetUsingContentResolver$2", f = "CreateAsset.kt", i = {0, 0, 1, 1, 1, 1}, l = {111, 117}, m = "invokeSuspend", n = {"$this$withContext", "assetUri", "$this$withContext", "assetUri", "selection", "args"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ArrayList<Bundle>>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = CreateAssetWithAlbumFile.this.new AnonymousClass2(continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ArrayList<Bundle>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws ContentEntryException {
            Uri uriCreateContentResolverAssetEntry;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                uriCreateContentResolverAssetEntry = CreateAssetWithAlbumFile.this.createContentResolverAssetEntry();
                if (uriCreateContentResolverAssetEntry == null) {
                    throw new ContentEntryException();
                }
                CreateAssetWithAlbumFile createAssetWithAlbumFile = CreateAssetWithAlbumFile.this;
                String path = CreateAssetWithAlbumFile.this.mUri.getPath();
                Intrinsics.checkNotNull(path);
                this.L$0 = coroutineScope;
                this.L$1 = uriCreateContentResolverAssetEntry;
                this.label = 1;
                if (createAssetWithAlbumFile.writeFileContentsToAsset(new File(path), uriCreateContentResolverAssetEntry, this) != coroutine_suspended) {
                }
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            uriCreateContentResolverAssetEntry = (Uri) this.L$1;
            ResultKt.throwOnFailure(obj);
            JobKt.ensureActive(coroutineScope.getCoroutineContext());
            if (!CreateAssetWithAlbumFile.this.resolveWithAdditionalData) {
                return null;
            }
            String[] strArr = {String.valueOf(ContentUris.parseId(uriCreateContentResolverAssetEntry))};
            this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
            this.L$1 = SpillingKt.nullOutSpilledVariable(uriCreateContentResolverAssetEntry);
            this.L$2 = SpillingKt.nullOutSpilledVariable("_id=?");
            this.L$3 = SpillingKt.nullOutSpilledVariable(strArr);
            this.label = 2;
            Object objQueryAssetInfo = AssetUtilsKt.queryAssetInfo(CreateAssetWithAlbumFile.this.context, "_id=?", strArr, false, this);
            return objQueryAssetInfo == coroutine_suspended ? coroutine_suspended : objQueryAssetInfo;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object createAssetUsingContentResolver(Continuation<? super ArrayList<Bundle>> continuation) throws IOException {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(null), continuation);
    }

    static /* synthetic */ File createAssetFileLegacy$default(CreateAssetWithAlbumFile createAssetWithAlbumFile, File file, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            file = null;
        }
        return createAssetWithAlbumFile.createAssetFileLegacy(file);
    }

    private final File createAssetFileLegacy(File albumFile) throws IOException, AssetFileException {
        String path = this.mUri.getPath();
        Intrinsics.checkNotNull(path);
        File file = new File(path);
        MediaLibraryUtils mediaLibraryUtils = MediaLibraryUtils.INSTANCE;
        ContentResolver contentResolver = this.context.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(contentResolver, "getContentResolver(...)");
        String mimeType = mediaLibraryUtils.getMimeType(contentResolver, this.mUri);
        if (mimeType == null) {
            throw new AssetFileException("Could not guess file type.");
        }
        if (albumFile == null) {
            albumFile = MediaLibraryUtils.INSTANCE.getEnvDirectoryForAssetType(mimeType, true);
        }
        File fileSafeCopyFile = MediaLibraryUtils.INSTANCE.safeCopyFile(file, albumFile);
        if (albumFile.exists() && fileSafeCopyFile.isFile()) {
            return fileSafeCopyFile;
        }
        throw new AssetFileException("Could not create asset record. Related file does not exist.");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object execute(Continuation<? super ArrayList<Bundle>> continuation) throws UnableToSaveException, UnableToLoadPermissionException, IOException, AssetFileException {
        AnonymousClass1 anonymousClass1;
        File fileCreateAssetFileLegacy;
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
        Object objScanFile = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        fileCreateAssetFileLegacy = (File) anonymousClass1.L$0;
                        ResultKt.throwOnFailure(objScanFile);
                    } else {
                        if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    }
                }
                ResultKt.throwOnFailure(objScanFile);
                return objScanFile;
            }
            ResultKt.throwOnFailure(objScanFile);
            if (!isFileExtensionPresent()) {
                throw new AssetFileException("Could not get the file's extension.");
            }
            if (Build.VERSION.SDK_INT >= 30) {
                anonymousClass1.label = 1;
                Object objCreateAssetUsingContentResolver = createAssetUsingContentResolver(anonymousClass1);
                if (objCreateAssetUsingContentResolver != coroutine_suspended) {
                    return objCreateAssetUsingContentResolver;
                }
            } else {
                fileCreateAssetFileLegacy = createAssetFileLegacy(this.albumFile);
                JobKt.ensureActive(anonymousClass1.getContext());
                MediaLibraryUtils mediaLibraryUtils = MediaLibraryUtils.INSTANCE;
                Context context = this.context;
                String path = fileCreateAssetFileLegacy.getPath();
                Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(fileCreateAssetFileLegacy);
                anonymousClass1.label = 2;
                objScanFile = mediaLibraryUtils.scanFile(context, new String[]{path}, null, anonymousClass1);
                if (objScanFile == coroutine_suspended) {
                }
            }
            Pair pair = (Pair) objScanFile;
            String str = (String) pair.component1();
            Uri uri = (Uri) pair.component2();
            JobKt.ensureActive(anonymousClass1.getContext());
            if (uri == null) {
                throw new AssetException();
            }
            if (!this.resolveWithAdditionalData) {
                return null;
            }
            String[] strArr = {str};
            Context context2 = this.context;
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(fileCreateAssetFileLegacy);
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str);
            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(uri);
            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable("_data=?");
            anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(strArr);
            anonymousClass1.label = 3;
            Object objQueryAssetInfo = AssetUtilsKt.queryAssetInfo(context2, "_data=?", strArr, false, anonymousClass1);
            return objQueryAssetInfo == coroutine_suspended ? coroutine_suspended : objQueryAssetInfo;
        } catch (IOException e) {
            throw new IOException("Unable to copy file into external storage.", e);
        } catch (SecurityException e2) {
            throw new UnableToLoadPermissionException("Could not get asset: need READ_EXTERNAL_STORAGE permission", e2);
        } catch (Exception e3) {
            throw new UnableToSaveException("Could not create asset: " + e3.getMessage(), e3);
        }
    }
}
