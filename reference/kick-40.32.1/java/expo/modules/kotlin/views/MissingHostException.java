package expo.modules.kotlin.views;

import expo.modules.kotlin.exception.CodedException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExpoComposeView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lexpo/modules/kotlin/views/MissingHostException;", "Lexpo/modules/kotlin/exception/CodedException;", "componentName", "", "<init>", "(Ljava/lang/String;)V", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MissingHostException extends CodedException {
    public static final int $stable = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MissingHostException(String componentName) {
        super("A Jetpack Compose view \"" + componentName + "\" must be rendered as a direct child of a <Host> component. Wrap your component with `<Host>` from '@expo/ui/jetpack-compose'. Note that inserting another `<View>` (or any non-Compose ViewGroup) between `<Host>` and this component breaks the Compose composition boundary and will still trigger this error.", null, 2, null);
        Intrinsics.checkNotNullParameter(componentName, "componentName");
    }
}
