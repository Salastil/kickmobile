package expo.modules.blur;

import expo.modules.kotlin.exception.CodedException;
import kotlin.Metadata;

/* JADX INFO: compiled from: BlurModuleExceptions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/blur/DuplicateBlurTargetIdException;", "Lexpo/modules/kotlin/exception/CodedException;", "<init>", "()V", "expo-blur_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DuplicateBlurTargetIdException extends CodedException {
    public DuplicateBlurTargetIdException() {
        super("You have registered multiple BlurTargetViews without providing an unique `blurTargetId` prop. Every `BlurTargetView` has to have an unique blur target identifier.", null, 2, null);
    }
}
