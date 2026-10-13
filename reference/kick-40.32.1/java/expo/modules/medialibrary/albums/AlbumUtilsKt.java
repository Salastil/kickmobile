package expo.modules.medialibrary.albums;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.medialibrary.AlbumException;
import expo.modules.medialibrary.AssetFileException;
import expo.modules.medialibrary.MediaLibraryConstantsKt;
import expo.modules.medialibrary.MediaLibraryException;
import expo.modules.medialibrary.MediaLibraryUtils;
import expo.modules.medialibrary.UnableToLoadException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: AlbumUtils.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001a0\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007H\u0086@¢\u0006\u0002\u0010\b\u001a1\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0007\"\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\f\u001a.\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0080@¢\u0006\u0002\u0010\b\u001a \u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0005H\u0080@¢\u0006\u0002\u0010\u0011\u001a \u0010\u0012\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0005H\u0080@¢\u0006\u0002\u0010\u0011\u001a\u001e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0005H\u0080@¢\u0006\u0002\u0010\u0011\u001a\u0018\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0000¨\u0006\u0017"}, d2 = {"queryAlbum", "Landroid/os/Bundle;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "selection", "", "selectionArgs", "", "(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAssetsInAlbums", "", "albumIds", "(Landroid/content/Context;[Ljava/lang/String;)Ljava/util/List;", "getFileOrNullByContextResolver", "Ljava/io/File;", "getAlbumFileByNameOrNull", "albumName", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAlbumFileOrNull", "albumId", "getAlbumFile", "createAlbumFile", "mimeType", "expo-media-library_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AlbumUtilsKt {

    /* JADX INFO: renamed from: expo.modules.medialibrary.albums.AlbumUtilsKt$getAlbumFile$1, reason: invalid class name */
    /* JADX INFO: compiled from: AlbumUtils.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.albums.AlbumUtilsKt", f = "AlbumUtils.kt", i = {0, 0}, l = {133}, m = "getAlbumFile", n = {RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "albumId"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AlbumUtilsKt.getAlbumFile(null, null, this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.albums.AlbumUtilsKt$queryAlbum$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AlbumUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/os/Bundle;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.albums.AlbumUtilsKt$queryAlbum$2", f = "AlbumUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C08712 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bundle>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ String $selection;
        final /* synthetic */ String[] $selectionArgs;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08712(Context context, String str, String[] strArr, Continuation<? super C08712> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$selection = str;
            this.$selectionArgs = strArr;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C08712 c08712 = new C08712(this.$context, this.$selection, this.$selectionArgs, continuation);
            c08712.L$0 = obj;
            return c08712;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Bundle> continuation) {
            return ((C08712) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws UnableToLoadException {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                Cursor cursorQuery = this.$context.getContentResolver().query(MediaLibraryConstantsKt.getEXTERNAL_CONTENT_URI(), new String[]{"bucket_id", "bucket_display_name"}, this.$selection, this.$selectionArgs, "bucket_display_name");
                try {
                    Cursor cursor = cursorQuery;
                    JobKt.ensureActive(coroutineScope.getCoroutineContext());
                    if (cursor == null) {
                        throw new AlbumException("Could not get album. Query is incorrect.");
                    }
                    if (!cursor.moveToNext()) {
                        CloseableKt.closeFinally(cursorQuery, null);
                        return null;
                    }
                    int columnIndex = cursor.getColumnIndex("bucket_id");
                    int columnIndex2 = cursor.getColumnIndex("bucket_display_name");
                    Bundle bundle = new Bundle();
                    bundle.putString("id", cursor.getString(columnIndex));
                    bundle.putString("title", cursor.getString(columnIndex2));
                    bundle.putInt("assetCount", cursor.getCount());
                    CloseableKt.closeFinally(cursorQuery, null);
                    return bundle;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(cursorQuery, th);
                        throw th2;
                    }
                }
            } catch (IllegalArgumentException e) {
                throw new UnableToLoadException("Could not get album: " + e.getMessage(), e);
            } catch (SecurityException e2) {
                throw new UnableToLoadException("Could not get albums: need READ_EXTERNAL_STORAGE permission " + e2.getMessage(), e2);
            }
        }
    }

    public static final Object queryAlbum(Context context, String str, String[] strArr, Continuation<? super Bundle> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C08712(context, str, strArr, null), continuation);
    }

    public static final List<String> getAssetsInAlbums(Context context, String... albumIds) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(albumIds, "albumIds");
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = context.getContentResolver().query(MediaLibraryConstantsKt.getEXTERNAL_CONTENT_URI(), new String[]{"_id"}, "bucket_id IN (" + MediaLibraryUtils.INSTANCE.queryPlaceholdersFor(albumIds) + " )", albumIds, null);
        try {
            Cursor cursor = cursorQuery;
            if (cursor == null) {
                CloseableKt.closeFinally(cursorQuery, null);
                return arrayList;
            }
            while (cursor.moveToNext()) {
                String string = cursor.getString(cursor.getColumnIndex("_id"));
                Intrinsics.checkNotNull(string);
                arrayList.add(string);
            }
            Unit unit = Unit.INSTANCE;
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

    /* JADX INFO: renamed from: expo.modules.medialibrary.albums.AlbumUtilsKt$getFileOrNullByContextResolver$2, reason: invalid class name */
    /* JADX INFO: compiled from: AlbumUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.albums.AlbumUtilsKt$getFileOrNullByContextResolver$2", f = "AlbumUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super File>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ String $selection;
        final /* synthetic */ String[] $selectionArgs;
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
            return new AnonymousClass2(this.$context, this.$selection, this.$selectionArgs, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super File> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Cursor cursorQuery = this.$context.getContentResolver().query(MediaLibraryConstantsKt.getEXTERNAL_CONTENT_URI(), new String[]{"_data"}, this.$selection, this.$selectionArgs, null);
            try {
                Cursor cursor = cursorQuery;
                if (cursor == null) {
                    throw new AlbumException("Could not get album. Query returns null.");
                }
                if (cursor.getCount() == 0) {
                    CloseableKt.closeFinally(cursorQuery, null);
                    return null;
                }
                cursor.moveToNext();
                File file = new File(cursor.getString(cursor.getColumnIndex("_data")));
                if (!file.isFile() && !file.isDirectory()) {
                    throw new MediaLibraryException();
                }
                String parent = file.getParent();
                Intrinsics.checkNotNull(parent);
                File file2 = new File(parent);
                CloseableKt.closeFinally(cursorQuery, null);
                return file2;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(cursorQuery, th);
                    throw th2;
                }
            }
        }
    }

    public static final Object getFileOrNullByContextResolver(Context context, String str, String[] strArr, Continuation<? super File> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(context, str, strArr, null), continuation);
    }

    public static final Object getAlbumFileByNameOrNull(Context context, String str, Continuation<? super File> continuation) {
        return getFileOrNullByContextResolver(context, "media_type != 0 AND bucket_display_name=?", new String[]{str}, continuation);
    }

    public static final Object getAlbumFileOrNull(Context context, String str, Continuation<? super File> continuation) {
        return getFileOrNullByContextResolver(context, "bucket_id=?", new String[]{str}, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object getAlbumFile(Context context, String str, Continuation<? super File> continuation) throws AlbumException {
        AnonymousClass1 anonymousClass1;
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
        Object albumFileOrNull = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(albumFileOrNull);
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(context);
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str);
            anonymousClass1.label = 1;
            albumFileOrNull = getAlbumFileOrNull(context, str, anonymousClass1);
            if (albumFileOrNull == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(albumFileOrNull);
        }
        File file = (File) albumFileOrNull;
        if (file != null) {
            return file;
        }
        throw new AlbumException("Could not get album. Query returns null.");
    }

    public static final File createAlbumFile(String mimeType, String albumName) throws AlbumException, AssetFileException {
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        Intrinsics.checkNotNullParameter(albumName, "albumName");
        File envDirectoryForAssetType = MediaLibraryUtils.INSTANCE.getEnvDirectoryForAssetType(mimeType, false);
        if (envDirectoryForAssetType == null) {
            throw new AssetFileException("Could not guess asset type.");
        }
        File file = new File(envDirectoryForAssetType.getPath(), albumName);
        if (!file.exists() && !file.mkdirs()) {
            file = null;
        }
        if (file != null) {
            return file;
        }
        throw new AlbumException("Could not create album directory.");
    }
}
