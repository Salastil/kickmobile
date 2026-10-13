package expo.modules.medialibrary.next.extensions;

import expo.modules.medialibrary.FileChannelExtensionsKt;
import expo.modules.medialibrary.MediaLibraryUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileExtensions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0012\u0010\u0003\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0018\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\b"}, d2 = {"safeMove", "Ljava/io/File;", "destinationDirectory", "safeCopy", "createUniqueFileIn", "directory", "newFileName", "", "expo-media-library_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class FileExtensionsKt {
    public static final File safeMove(File file, File destinationDirectory) throws IOException {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(destinationDirectory, "destinationDirectory");
        File fileSafeCopy = safeCopy(file, destinationDirectory);
        file.delete();
        return fileSafeCopy;
    }

    public static final File safeCopy(File file, File destinationDirectory) throws IOException {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(destinationDirectory, "destinationDirectory");
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        File fileCreateUniqueFileIn = createUniqueFileIn(destinationDirectory, name);
        FileChannel channel = new FileInputStream(file).getChannel();
        try {
            FileChannel fileChannel = channel;
            FileChannel channel2 = new FileOutputStream(fileCreateUniqueFileIn).getChannel();
            try {
                FileChannel fileChannel2 = channel2;
                Intrinsics.checkNotNull(fileChannel);
                Intrinsics.checkNotNull(fileChannel2);
                if (FileChannelExtensionsKt.transferAllTo(fileChannel, fileChannel2) != fileChannel.size()) {
                    fileCreateUniqueFileIn.delete();
                    throw new IOException("Could not save file to " + destinationDirectory + " Not enough space.");
                }
                CloseableKt.closeFinally(channel2, null);
                CloseableKt.closeFinally(channel, null);
                return fileCreateUniqueFileIn;
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

    private static final File createUniqueFileIn(File file, String str) throws IOException {
        File file2 = new File(file, str);
        Pair<String, String> fileNameAndExtension = MediaLibraryUtils.INSTANCE.getFileNameAndExtension(str);
        String strComponent1 = fileNameAndExtension.component1();
        String strComponent2 = fileNameAndExtension.component2();
        int i = 2;
        while (file2.exists()) {
            file2 = new File(file, strComponent1 + "_" + i + strComponent2);
            i++;
            if (i > 32767) {
                throw new IOException("File name suffix limit reached (32767)");
            }
        }
        return file2;
    }
}
