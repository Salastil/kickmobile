package expo.modules.filesystem;

import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.types.Enumerable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: FileSystemFileHandle.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u000e\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u0013"}, d2 = {"Lexpo/modules/filesystem/FileMode;", "Lexpo/modules/kotlin/types/Enumerable;", "", "descriptor", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getDescriptor", "()Ljava/lang/String;", "READ", "WRITE", "APPEND", "TRUNCATE", "READ_WRITE", "rafMode", "getRafMode", "ensureCanRead", "", "ensureCanWrite", "expo-file-system_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum FileMode implements Enumerable {
    READ("r"),
    WRITE("w"),
    APPEND("wa"),
    TRUNCATE("wt"),
    READ_WRITE("rw");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String descriptor;

    /* JADX INFO: compiled from: FileSystemFileHandle.kt */
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
                iArr[FileMode.READ_WRITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FileMode.WRITE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FileMode.APPEND.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[FileMode.TRUNCATE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static EnumEntries<FileMode> getEntries() {
        return $ENTRIES;
    }

    FileMode(String str) {
        this.descriptor = str;
    }

    public final String getDescriptor() {
        return this.descriptor;
    }

    public final String getRafMode() {
        if (this == READ) {
            return "r";
        }
        return "rw";
    }

    public final void ensureCanRead() throws Exceptions.IllegalStateException {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1 || i == 2) {
            return;
        }
        if (i != 3 && i != 4 && i != 5) {
            throw new NoWhenBranchMatchedException();
        }
        throw new Exceptions.IllegalStateException("Cannot read. File opened in write-only mode.", null, 2, null);
    }

    public final void ensureCanWrite() throws Exceptions.IllegalStateException {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            throw new Exceptions.IllegalStateException("Cannot write. File opened in read-only mode.", null, 2, null);
        }
        if (i != 2 && i != 3 && i != 4 && i != 5) {
            throw new NoWhenBranchMatchedException();
        }
    }
}
