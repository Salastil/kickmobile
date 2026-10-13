package expo.modules.imagemanipulator;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileUtils.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0002¨\u0006\f"}, d2 = {"Lexpo/modules/imagemanipulator/FileUtils;", "", "<init>", "()V", "generateRandomOutputPath", "", "cacheDirectory", "Ljava/io/File;", "imageFormat", "Lexpo/modules/imagemanipulator/ImageFormat;", "ensureDirExists", "dir", "expo-image-manipulator_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FileUtils {
    public static final FileUtils INSTANCE = new FileUtils();

    private FileUtils() {
    }

    public final String generateRandomOutputPath(File cacheDirectory, ImageFormat imageFormat) throws ImageWriteFailedException, IOException {
        Intrinsics.checkNotNullParameter(cacheDirectory, "cacheDirectory");
        Intrinsics.checkNotNullParameter(imageFormat, "imageFormat");
        File file = new File(cacheDirectory, "ImageManipulator");
        ensureDirExists(file);
        return file + File.separator + UUID.randomUUID() + imageFormat.getFileExtension();
    }

    private final File ensureDirExists(File dir) throws ImageWriteFailedException, IOException {
        if (dir.isDirectory() || dir.mkdirs()) {
            return dir;
        }
        String path = dir.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        throw new ImageWriteFailedException(path);
    }
}
