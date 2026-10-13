package expo.modules.filesystem;

import android.net.Uri;
import com.google.android.gms.common.internal.ImagesContract;
import expo.modules.filesystem.unifiedfile.JavaFile;
import expo.modules.filesystem.unifiedfile.SAFDocumentFile;
import expo.modules.filesystem.unifiedfile.UnifiedFileInterface;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.services.FilePermissionService;
import java.io.File;
import java.net.URI;
import java.net.URLConnection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: FileSystemDownloadTask.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006\u001a\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0010"}, d2 = {"filename", "", "Ljava/net/URI;", "getFilename", "(Ljava/net/URI;)Ljava/lang/String;", "calculateDownloadTotalBytes", "", "responseCode", "", "contentLength", "effectiveOffset", "resolveDownloadDestination", "Lexpo/modules/filesystem/unifiedfile/UnifiedFileInterface;", "to", "Lexpo/modules/filesystem/FileSystemPath;", ImagesContract.URL, "expo-file-system_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class FileSystemDownloadTaskKt {
    public static final long calculateDownloadTotalBytes(int i, long j, long j2) {
        if (i == 206 && j >= 0) {
            return j2 + j;
        }
        if (i == 206) {
            return -1L;
        }
        return j;
    }

    public static final String getFilename(URI uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        String path = uri.getPath();
        if (path == null) {
            path = "";
        }
        String strSubstringAfterLast$default = StringsKt.substringAfterLast$default(path, '/', (String) null, 2, (Object) null);
        if (StringsKt.isBlank(strSubstringAfterLast$default)) {
            String lastPathSegment = Uri.parse(uri.toString()).getLastPathSegment();
            strSubstringAfterLast$default = lastPathSegment != null ? lastPathSegment : "";
        }
        String str = strSubstringAfterLast$default;
        if (StringsKt.isBlank(str)) {
            str = "download";
        }
        return str;
    }

    public static final UnifiedFileInterface resolveDownloadDestination(FileSystemPath to, URI url) throws UnableToDownloadException, InvalidPermissionException, Exceptions.ReactContextLost {
        Intrinsics.checkNotNullParameter(to, "to");
        Intrinsics.checkNotNullParameter(url, "url");
        to.validatePermission(FilePermissionService.Permission.WRITE);
        if (to instanceof FileSystemDirectory) {
            String filename = getFilename(url);
            Object file = to.getFile();
            if (file instanceof SAFDocumentFile) {
                SAFDocumentFile sAFDocumentFile = (SAFDocumentFile) file;
                SAFDocumentFile sAFDocumentFileFindFile = sAFDocumentFile.findFile(filename);
                if (sAFDocumentFileFindFile != null) {
                    return sAFDocumentFileFindFile;
                }
                String strGuessContentTypeFromName = URLConnection.guessContentTypeFromName(filename);
                if (strGuessContentTypeFromName == null) {
                    strGuessContentTypeFromName = "application/octet-stream";
                }
                UnifiedFileInterface unifiedFileInterfaceCreateFile = sAFDocumentFile.createFile(strGuessContentTypeFromName, filename);
                if (unifiedFileInterfaceCreateFile != null) {
                    return unifiedFileInterfaceCreateFile;
                }
                throw new UnableToDownloadException("Unable to create destination file");
            }
            if (file instanceof JavaFile) {
                return new JavaFile(Uri.fromFile(new File((File) file, filename)));
            }
            throw new UnableToDownloadException("Invalid destination directory type");
        }
        if (to instanceof FileSystemFile) {
            return to.getFile();
        }
        throw new UnableToDownloadException("Invalid destination type");
    }
}
