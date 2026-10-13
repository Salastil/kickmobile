package expo.modules.haptics.arguments;

import expo.modules.kotlin.exception.CodedException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HapticsExceptions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lexpo/modules/haptics/arguments/HapticTypeNotSupportedException;", "Lexpo/modules/kotlin/exception/CodedException;", "type", "", "<init>", "(Ljava/lang/String;)V", "expo-haptics_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class HapticTypeNotSupportedException extends CodedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HapticTypeNotSupportedException(String type) {
        super("This device doesn't support the selected haptic type: " + type, null, 2, null);
        Intrinsics.checkNotNullParameter(type, "type");
    }
}
