package expo.modules.filesystem;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FilePickerContract.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/filesystem/FilePickerContractResult;", "", "<init>", "()V", "Success", "Cancelled", "Lexpo/modules/filesystem/FilePickerContractResult$Cancelled;", "Lexpo/modules/filesystem/FilePickerContractResult$Success;", "expo-file-system_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class FilePickerContractResult {
    public /* synthetic */ FilePickerContractResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: FilePickerContract.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lexpo/modules/filesystem/FilePickerContractResult$Success;", "Lexpo/modules/filesystem/FilePickerContractResult;", "paths", "", "Lexpo/modules/filesystem/FileSystemPath;", "<init>", "(Ljava/util/List;)V", "getPaths", "()Ljava/util/List;", "expo-file-system_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Success extends FilePickerContractResult {
        private final List<FileSystemPath> paths;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public Success(List<? extends FileSystemPath> paths) {
            super(null);
            Intrinsics.checkNotNullParameter(paths, "paths");
            this.paths = paths;
        }

        public final List<FileSystemPath> getPaths() {
            return this.paths;
        }
    }

    private FilePickerContractResult() {
    }

    /* JADX INFO: compiled from: FilePickerContract.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/filesystem/FilePickerContractResult$Cancelled;", "Lexpo/modules/filesystem/FilePickerContractResult;", "<init>", "()V", "expo-file-system_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Cancelled extends FilePickerContractResult {
        public static final Cancelled INSTANCE = new Cancelled();

        private Cancelled() {
            super(null);
        }
    }
}
