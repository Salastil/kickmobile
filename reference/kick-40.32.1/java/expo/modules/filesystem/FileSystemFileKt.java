package expo.modules.filesystem;

import expo.modules.kotlin.services.FilePermissionService;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileSystemFile.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0000¨\u0006\u0004"}, d2 = {"requiredPermissions", "", "Lexpo/modules/kotlin/services/FilePermissionService$Permission;", "Lexpo/modules/filesystem/FileMode;", "expo-file-system_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class FileSystemFileKt {

    /* JADX INFO: compiled from: FileSystemFile.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FileMode.values().length];
            try {
                iArr[FileMode.READ.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FileMode.WRITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FileMode.APPEND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FileMode.TRUNCATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[FileMode.READ_WRITE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final List<FilePermissionService.Permission> requiredPermissions(FileMode fileMode) {
        Intrinsics.checkNotNullParameter(fileMode, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[fileMode.ordinal()];
        if (i == 1) {
            return CollectionsKt.listOf(FilePermissionService.Permission.READ);
        }
        if (i == 2 || i == 3 || i == 4) {
            return CollectionsKt.listOf(FilePermissionService.Permission.WRITE);
        }
        if (i == 5) {
            return CollectionsKt.listOf((Object[]) new FilePermissionService.Permission[]{FilePermissionService.Permission.READ, FilePermissionService.Permission.WRITE});
        }
        throw new NoWhenBranchMatchedException();
    }
}
