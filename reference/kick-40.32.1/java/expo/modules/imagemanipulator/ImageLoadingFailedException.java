package expo.modules.imagemanipulator;

import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.DecoratedException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImageManipulatorExceptions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/imagemanipulator/ImageLoadingFailedException;", "Lexpo/modules/kotlin/exception/DecoratedException;", "image", "", "cause", "Lexpo/modules/kotlin/exception/CodedException;", "<init>", "(Ljava/lang/String;Lexpo/modules/kotlin/exception/CodedException;)V", "expo-image-manipulator_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ImageLoadingFailedException extends DecoratedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageLoadingFailedException(String image, CodedException cause) {
        super("Could not load the image: " + image, cause);
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(cause, "cause");
    }
}
