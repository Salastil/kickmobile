package expo.modules.blur;

import expo.modules.kotlin.exception.CodedException;
import io.ktor.sse.ServerSentEventKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: BlurModuleExceptions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/blur/InvalidBlurTargetIdException;", "Lexpo/modules/kotlin/exception/CodedException;", "info", "", "<init>", "(Ljava/lang/String;)V", "getInfo", "()Ljava/lang/String;", "expo-blur_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InvalidBlurTargetIdException extends CodedException {
    private final String info;

    public final String getInfo() {
        return this.info;
    }

    /* JADX WARN: Code duplicated, block: B:5:0x0012  */
    /* JADX WARN: Illegal instructions before constructor call */
    public InvalidBlurTargetIdException(String str) {
        String str2;
        if (str != null) {
            str2 = ServerSentEventKt.SPACE + str;
            str2 = str2 == null ? "" : str2;
        }
        super("The provided blur target id is invalid." + str2, null, 2, null);
        this.info = str;
    }
}
