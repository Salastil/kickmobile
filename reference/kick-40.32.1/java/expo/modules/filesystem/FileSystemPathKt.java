package expo.modules.filesystem;

import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.common.util.UriUtil;
import expo.modules.filesystem.fsops.DestinationSpec;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: FileSystemPath.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0012\u0010\t\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b\u001a\u0012\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u001a\u0014\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0005\"\u0015\u0010\u0004\u001a\u00020\u0005*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0007\"\u0015\u0010\b\u001a\u00020\u0005*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"validateFileSystemChildName", "", "name", "", "isContentUri", "", "Landroid/net/Uri;", "(Landroid/net/Uri;)Z", "isAssetUri", "isSAFUri", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "slashifyFilePath", "path", "asCopyOrMoveDestination", "Lexpo/modules/filesystem/fsops/DestinationSpec;", "Lexpo/modules/filesystem/FileSystemPath;", "overwrite", "expo-file-system_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class FileSystemPathKt {
    public static final void validateFileSystemChildName(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        String str = name;
        if (str.length() != 0 && !Intrinsics.areEqual(name, ".") && !Intrinsics.areEqual(name, "..")) {
            for (int i = 0; i < str.length(); i++) {
                char cCharAt = str.charAt(i);
                if (cCharAt != '/' && cCharAt != '\\') {
                }
            }
            return;
        }
        throw new UnableToCreateException("child name must be a single path segment");
    }

    public static final boolean isContentUri(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        return Intrinsics.areEqual(uri.getScheme(), "content");
    }

    public static final boolean isAssetUri(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        return Intrinsics.areEqual(uri.getScheme(), UriUtil.LOCAL_ASSET_SCHEME);
    }

    public static final boolean isSAFUri(Uri uri, Context context) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (isContentUri(uri)) {
            return DocumentsContract.isDocumentUri(context, uri) || DocumentsContract.isTreeUri(uri);
        }
        return false;
    }

    public static final String slashifyFilePath(String str) {
        if (str == null) {
            return null;
        }
        return StringsKt.startsWith$default(str, "file:///", false, 2, (Object) null) ? str : Pattern.compile("^file:/*").matcher(str).replaceAll("file:///");
    }

    public static final DestinationSpec asCopyOrMoveDestination(FileSystemPath fileSystemPath, boolean z) {
        Intrinsics.checkNotNullParameter(fileSystemPath, "<this>");
        return new DestinationSpec(fileSystemPath.getFile(), z, fileSystemPath instanceof FileSystemDirectory);
    }

    public static /* synthetic */ DestinationSpec asCopyOrMoveDestination$default(FileSystemPath fileSystemPath, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return asCopyOrMoveDestination(fileSystemPath, z);
    }
}
