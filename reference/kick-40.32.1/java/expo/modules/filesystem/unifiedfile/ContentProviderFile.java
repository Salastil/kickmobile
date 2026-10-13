package expo.modules.filesystem.unifiedfile;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.webkit.MimeTypeMap;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.filesystem.fsops.CopyMoveStrategy;
import expo.modules.filesystem.fsops.DestinationSpec;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.exception.Exceptions;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ContentProviderFile.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\u0018\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0016J\b\u0010\u0017\u001a\u00020\u000bH\u0016J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u0019H\u0016J\u000f\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0002\u0010\u001fJ\u0010\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u000bH\u0016J\b\u0010+\u001a\u00020,H\u0016J\u0012\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u00020\u0013H\u0016J\b\u00100\u001a\u00020\u001eH\u0016J\u000e\u00101\u001a\b\u0012\u0004\u0012\u00020\u000102H\u0016J\u0012\u00107\u001a\u0004\u0018\u00010\u00132\u0006\u00108\u001a\u00020\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u001eX\u0096\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b!\u0010\u001fR\u0016\u0010#\u001a\u0004\u0018\u00010\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u001cR\u0014\u00103\u001a\u000204X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00106¨\u00069"}, d2 = {"Lexpo/modules/filesystem/unifiedfile/ContentProviderFile;", "Lexpo/modules/filesystem/unifiedfile/UnifiedFileInterface;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "<init>", "(Landroid/content/Context;Landroid/net/Uri;)V", "getUri", "()Landroid/net/Uri;", "exists", "", "isFile", "isDirectory", "parentFile", "getParentFile", "()Lexpo/modules/filesystem/unifiedfile/UnifiedFileInterface;", "createFile", "mimeType", "", "displayName", "createDirectory", "delete", "deleteRecursively", "listFilesAsUnified", "", "type", "getType", "()Ljava/lang/String;", "lastModified", "", "()Ljava/lang/Long;", "creationTime", "getCreationTime", "Ljava/lang/Long;", "fileName", "getFileName", "getContentUri", "appContext", "Lexpo/modules/kotlin/AppContext;", "outputStream", "Ljava/io/OutputStream;", "append", "inputStream", "Ljava/io/InputStream;", "openFileDescriptor", "Landroid/os/ParcelFileDescriptor;", "mode", "length", "walkTopDown", "Lkotlin/sequences/Sequence;", "copyMoveStrategy", "Lexpo/modules/filesystem/fsops/CopyMoveStrategy;", "getCopyMoveStrategy", "()Lexpo/modules/filesystem/fsops/CopyMoveStrategy;", "queryColumn", "column", "expo-file-system_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ContentProviderFile implements UnifiedFileInterface {
    private final Context context;
    private final CopyMoveStrategy copyMoveStrategy;
    private final Long creationTime;
    private final UnifiedFileInterface parentFile;
    private final Uri uri;

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public boolean isDirectory() {
        return false;
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public Long lastModified() {
        return null;
    }

    public ContentProviderFile(Context context, Uri uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.context = context;
        this.uri = uri;
        this.copyMoveStrategy = new CopyMoveStrategy.ContentProvider(this);
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public Object copyTo(DestinationSpec destinationSpec, Continuation<? super Unit> continuation) {
        return super.copyTo(destinationSpec, continuation);
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public Object moveTo(DestinationSpec destinationSpec, Continuation<? super Uri> continuation) {
        return super.moveTo(destinationSpec, continuation);
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public Uri getUri() {
        return this.uri;
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public boolean exists() {
        Object objM12684constructorimpl;
        Boolean bool;
        try {
            Result.Companion companion = Result.INSTANCE;
            ContentProviderFile contentProviderFile = this;
            InputStream inputStreamOpenInputStream = this.context.getContentResolver().openInputStream(getUri());
            if (inputStreamOpenInputStream != null) {
                InputStream inputStream = inputStreamOpenInputStream;
                try {
                    bool = true;
                    CloseableKt.closeFinally(inputStream, null);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(inputStream, th);
                        throw th2;
                    }
                }
            } else {
                bool = null;
            }
            objM12684constructorimpl = Result.m12684constructorimpl(bool);
        } catch (Throwable th3) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th3));
        }
        Boolean bool2 = (Boolean) (Result.m12690isFailureimpl(objM12684constructorimpl) ? null : objM12684constructorimpl);
        if (bool2 != null) {
            return bool2.booleanValue();
        }
        return false;
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public boolean isFile() {
        return exists();
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public UnifiedFileInterface getParentFile() {
        return this.parentFile;
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public UnifiedFileInterface createFile(String mimeType, String displayName) {
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        throw new UnsupportedOperationException("Cannot create files in generic content provider: " + getUri());
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public UnifiedFileInterface createDirectory(String displayName) {
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        throw new UnsupportedOperationException("Cannot create directories in generic content provider: " + getUri());
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public boolean delete() {
        throw new UnsupportedOperationException("Cannot delete from generic content provider: " + getUri());
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public boolean deleteRecursively() {
        throw new UnsupportedOperationException("Cannot delete from generic content provider: " + getUri());
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public List<UnifiedFileInterface> listFilesAsUnified() {
        return CollectionsKt.emptyList();
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public String getType() {
        String type = this.context.getContentResolver().getType(getUri());
        if (type != null) {
            return type;
        }
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(getUri().toString());
        String str = fileExtensionFromUrl;
        if (str == null || str.length() == 0) {
            fileExtensionFromUrl = null;
        }
        if (fileExtensionFromUrl == null) {
            return null;
        }
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        String lowerCase = fileExtensionFromUrl.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return singleton.getMimeTypeFromExtension(lowerCase);
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public Long getCreationTime() {
        return this.creationTime;
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public String getFileName() {
        String strQueryColumn = queryColumn("_display_name");
        return strQueryColumn == null ? getUri().getLastPathSegment() : strQueryColumn;
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public Uri getContentUri(AppContext appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        return getUri();
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public OutputStream outputStream(boolean append) throws Exceptions.IllegalStateException, FileNotFoundException {
        OutputStream outputStreamOpenOutputStream = this.context.getContentResolver().openOutputStream(getUri());
        if (outputStreamOpenOutputStream != null) {
            return outputStreamOpenOutputStream;
        }
        throw new Exceptions.IllegalStateException("Unable to open output stream for URI: " + getUri(), null, 2, null);
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public InputStream inputStream() throws Exceptions.IllegalStateException, FileNotFoundException {
        InputStream inputStreamOpenInputStream = this.context.getContentResolver().openInputStream(getUri());
        if (inputStreamOpenInputStream != null) {
            return inputStreamOpenInputStream;
        }
        throw new Exceptions.IllegalStateException("Unable to open input stream for URI: " + getUri(), null, 2, null);
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public ParcelFileDescriptor openFileDescriptor(String mode) {
        Object objM12684constructorimpl;
        Intrinsics.checkNotNullParameter(mode, "mode");
        try {
            Result.Companion companion = Result.INSTANCE;
            ContentProviderFile contentProviderFile = this;
            objM12684constructorimpl = Result.m12684constructorimpl(this.context.getContentResolver().openFileDescriptor(getUri(), mode));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        return (ParcelFileDescriptor) objM12684constructorimpl;
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public long length() {
        Object objM12684constructorimpl;
        Long longOrNull;
        String strQueryColumn = queryColumn("_size");
        if (strQueryColumn != null && (longOrNull = StringsKt.toLongOrNull(strQueryColumn)) != null) {
            return longOrNull.longValue();
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            ContentProviderFile contentProviderFile = this;
            InputStream inputStream = inputStream();
            try {
                InputStream inputStream2 = inputStream;
                byte[] bArr = new byte[8192];
                long j = 0;
                while (true) {
                    int i = inputStream2.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    j += (long) i;
                }
                CloseableKt.closeFinally(inputStream, null);
                objM12684constructorimpl = Result.m12684constructorimpl(Long.valueOf(j));
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(inputStream, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th3));
        }
        Long l = (Long) (Result.m12690isFailureimpl(objM12684constructorimpl) ? null : objM12684constructorimpl);
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public Sequence<UnifiedFileInterface> walkTopDown() {
        return SequencesKt.sequenceOf(this);
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public CopyMoveStrategy getCopyMoveStrategy() {
        return this.copyMoveStrategy;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x004c  */
    private final String queryColumn(String column) {
        Object objM12684constructorimpl;
        String string;
        try {
            Result.Companion companion = Result.INSTANCE;
            ContentProviderFile contentProviderFile = this;
            Cursor cursorQuery = this.context.getContentResolver().query(getUri(), new String[]{column}, null, null, null);
            if (cursorQuery != null) {
                Cursor cursor = cursorQuery;
                try {
                    Cursor cursor2 = cursor;
                    if (!cursor2.moveToFirst()) {
                        cursor2 = null;
                    }
                    if (cursor2 != null) {
                        Integer numValueOf = Integer.valueOf(cursor2.getColumnIndex(column));
                        if (numValueOf.intValue() < 0) {
                            numValueOf = null;
                        }
                        if (numValueOf != null) {
                            string = cursor2.getString(numValueOf.intValue());
                        } else {
                            string = null;
                        }
                    } else {
                        string = null;
                    }
                    CloseableKt.closeFinally(cursor, null);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(cursor, th);
                        throw th2;
                    }
                }
            } else {
                string = null;
            }
            objM12684constructorimpl = Result.m12684constructorimpl(string);
        } catch (Throwable th3) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th3));
        }
        return (String) (Result.m12690isFailureimpl(objM12684constructorimpl) ? null : objM12684constructorimpl);
    }
}
