package expo.modules.filesystem.fsops;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NioUtilities.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0001\u001a\u0018\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0001¨\u0006\u0006"}, d2 = {"copyFileNio", "", "source", "Ljava/nio/file/Path;", "dest", "moveFileNio", "expo-file-system_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class NioUtilitiesKt {
    public static final void copyFileNio(Path source, Path dest) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(dest, "dest");
        Files.copy(source, dest, StandardCopyOption.REPLACE_EXISTING);
    }

    public static final void moveFileNio(Path source, Path dest) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(dest, "dest");
        Files.move(source, dest, StandardCopyOption.REPLACE_EXISTING);
    }
}
