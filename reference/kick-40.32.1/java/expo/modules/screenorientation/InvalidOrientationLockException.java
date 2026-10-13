package expo.modules.screenorientation;

import expo.modules.kotlin.exception.CodedException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScreenOrientationExceptions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lexpo/modules/screenorientation/InvalidOrientationLockException;", "Lexpo/modules/kotlin/exception/CodedException;", "orientationLock", "", "cause", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<init>", "(ILjava/lang/Exception;)V", "expo-screen-orientation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InvalidOrientationLockException extends CodedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InvalidOrientationLockException(int i, Exception cause) {
        super("An invalid OrientationLock was passed in: " + i, cause);
        Intrinsics.checkNotNullParameter(cause, "cause");
    }
}
