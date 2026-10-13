package expo.modules.device;

import expo.modules.kotlin.exception.CodedException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeviceExceptions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lexpo/modules/device/MissingRequestInstallPackagesPermissionException;", "Lexpo/modules/kotlin/exception/CodedException;", "cause", "", "<init>", "(Ljava/lang/Throwable;)V", "expo-device_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MissingRequestInstallPackagesPermissionException extends CodedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MissingRequestInstallPackagesPermissionException(Throwable cause) {
        super("Device.isSideLoadingEnabledAsync() could not read whether sideloading is allowed, because Android refuses the check to apps that do not declare the REQUEST_INSTALL_PACKAGES permission. Add `<uses-permission android:name=\"android.permission.REQUEST_INSTALL_PACKAGES\" />` to your AndroidManifest.xml (in a config plugin, or app.json under android.permissions) if your app installs APKs. Note that Google Play restricts this permission to apps whose core purpose is installing other apps.", cause);
        Intrinsics.checkNotNullParameter(cause, "cause");
    }
}
