package expo.modules.filesystem;

import expo.modules.kotlin.exception.CodedException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FileSystemExceptions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/filesystem/FilePreviewUnsupportedException;", "Lexpo/modules/kotlin/exception/CodedException;", "mimeType", "", "cause", "", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "expo-file-system_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FilePreviewUnsupportedException extends CodedException {
    public /* synthetic */ FilePreviewUnsupportedException(String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : th);
    }

    /* JADX WARN: Code duplicated, block: B:5:0x0017  */
    /* JADX WARN: Illegal instructions before constructor call */
    public FilePreviewUnsupportedException(String str, Throwable th) {
        String str2;
        if (str != null) {
            str2 = "No app can preview files of type '" + str + "'.";
            str2 = str2 == null ? "No MIME type could be resolved for this file." : str2;
        }
        super(str2, th);
    }
}
