package expo.modules.clipboard;

import expo.modules.kotlin.exception.CodedException;
import kotlin.Metadata;

/* JADX INFO: compiled from: ClipboardExceptions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lexpo/modules/clipboard/NoPermissionException;", "Lexpo/modules/kotlin/exception/CodedException;", "cause", "Ljava/lang/SecurityException;", "<init>", "(Ljava/lang/SecurityException;)V", "expo-clipboard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NoPermissionException extends CodedException {
    public NoPermissionException(SecurityException securityException) {
        super("App has no permission to read this clipboard item", securityException);
    }
}
