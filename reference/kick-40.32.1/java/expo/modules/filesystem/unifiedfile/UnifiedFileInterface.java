package expo.modules.filesystem.unifiedfile;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import expo.modules.filesystem.fsops.CopyMoveStrategy;
import expo.modules.filesystem.fsops.DestinationSpec;
import expo.modules.kotlin.AppContext;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: UnifiedFileInterface.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00002\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH&J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00002\u0006\u0010\f\u001a\u00020\u000bH&J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0003H&J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00000\u0011H&J\u000f\u0010\u0019\u001a\u0004\u0018\u00010\u001aH&¢\u0006\u0002\u0010\u001bJ\u0010\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"H&J\u0012\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u0003H&J\b\u0010&\u001a\u00020'H&J\u0012\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020\u000bH\u0016J\b\u0010+\u001a\u00020\u001aH&J\u000e\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00000-H&J\u0016\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0096@¢\u0006\u0002\u00106J\u0016\u00107\u001a\u00020\u00132\u0006\u00104\u001a\u000205H\u0096@¢\u0006\u0002\u00106R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u001aX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001bR\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0018R\u0012\u0010.\u001a\u00020/X¦\u0004¢\u0006\u0006\u001a\u0004\b0\u00101¨\u00068À\u0006\u0003"}, d2 = {"Lexpo/modules/filesystem/unifiedfile/UnifiedFileInterface;", "", "exists", "", "isDirectory", "isFile", "parentFile", "getParentFile", "()Lexpo/modules/filesystem/unifiedfile/UnifiedFileInterface;", "createFile", "mimeType", "", "displayName", "createDirectory", "delete", "deleteRecursively", "listFilesAsUnified", "", "uri", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "type", "getType", "()Ljava/lang/String;", "lastModified", "", "()Ljava/lang/Long;", "creationTime", "getCreationTime", "fileName", "getFileName", "getContentUri", "appContext", "Lexpo/modules/kotlin/AppContext;", "outputStream", "Ljava/io/OutputStream;", "append", "inputStream", "Ljava/io/InputStream;", "openFileDescriptor", "Landroid/os/ParcelFileDescriptor;", "mode", "length", "walkTopDown", "Lkotlin/sequences/Sequence;", "copyMoveStrategy", "Lexpo/modules/filesystem/fsops/CopyMoveStrategy;", "getCopyMoveStrategy", "()Lexpo/modules/filesystem/fsops/CopyMoveStrategy;", "copyTo", "", "dest", "Lexpo/modules/filesystem/fsops/DestinationSpec;", "(Lexpo/modules/filesystem/fsops/DestinationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "moveTo", "expo-file-system_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface UnifiedFileInterface {
    default Object copyTo(DestinationSpec destinationSpec, Continuation<? super Unit> continuation) {
        return copyTo$suspendImpl(this, destinationSpec, continuation);
    }

    UnifiedFileInterface createDirectory(String displayName);

    UnifiedFileInterface createFile(String mimeType, String displayName);

    boolean delete();

    boolean deleteRecursively();

    boolean exists();

    Uri getContentUri(AppContext appContext);

    CopyMoveStrategy getCopyMoveStrategy();

    Long getCreationTime();

    String getFileName();

    UnifiedFileInterface getParentFile();

    String getType();

    Uri getUri();

    InputStream inputStream();

    boolean isDirectory();

    boolean isFile();

    Long lastModified();

    long length();

    List<UnifiedFileInterface> listFilesAsUnified();

    default Object moveTo(DestinationSpec destinationSpec, Continuation<? super Uri> continuation) {
        return moveTo$suspendImpl(this, destinationSpec, continuation);
    }

    default ParcelFileDescriptor openFileDescriptor(String mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        return null;
    }

    OutputStream outputStream(boolean append);

    Sequence<UnifiedFileInterface> walkTopDown();

    /* JADX INFO: compiled from: UnifiedFileInterface.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static ParcelFileDescriptor openFileDescriptor(UnifiedFileInterface unifiedFileInterface, String mode) {
            Intrinsics.checkNotNullParameter(mode, "mode");
            return UnifiedFileInterface.super.openFileDescriptor(mode);
        }

        @Deprecated
        public static Object copyTo(UnifiedFileInterface unifiedFileInterface, DestinationSpec destinationSpec, Continuation<? super Unit> continuation) {
            return UnifiedFileInterface.super.copyTo(destinationSpec, continuation);
        }

        @Deprecated
        public static Object moveTo(UnifiedFileInterface unifiedFileInterface, DestinationSpec destinationSpec, Continuation<? super Uri> continuation) {
            return UnifiedFileInterface.super.moveTo(destinationSpec, continuation);
        }
    }

    static /* synthetic */ OutputStream outputStream$default(UnifiedFileInterface unifiedFileInterface, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: outputStream");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        return unifiedFileInterface.outputStream(z);
    }

    static /* synthetic */ Object copyTo$suspendImpl(UnifiedFileInterface unifiedFileInterface, DestinationSpec destinationSpec, Continuation<? super Unit> continuation) {
        Object objCopyTo = unifiedFileInterface.getCopyMoveStrategy().copyTo(destinationSpec, continuation);
        return objCopyTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCopyTo : Unit.INSTANCE;
    }

    static /* synthetic */ Object moveTo$suspendImpl(UnifiedFileInterface unifiedFileInterface, DestinationSpec destinationSpec, Continuation<? super Uri> continuation) {
        return unifiedFileInterface.getCopyMoveStrategy().moveTo(destinationSpec, continuation);
    }
}
