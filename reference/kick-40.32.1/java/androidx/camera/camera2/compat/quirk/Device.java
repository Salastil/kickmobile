package androidx.camera.camera2.compat.quirk;

import android.os.Build;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Device.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\n\u001a\u00020\u0005J\u0006\u0010\u000b\u001a\u00020\u0005J\u0006\u0010\f\u001a\u00020\u0005J\u0006\u0010\r\u001a\u00020\u0005J\u0006\u0010\u000e\u001a\u00020\u0005J\u0006\u0010\u000f\u001a\u00020\u0005J\u0006\u0010\u0010\u001a\u00020\u0005J\u0006\u0010\u0011\u001a\u00020\u0005J\u0006\u0010\u0012\u001a\u00020\u0005J\u0006\u0010\u0013\u001a\u00020\u0005J\u0006\u0010\u0014\u001a\u00020\u0005J\u0006\u0010\u0015\u001a\u00020\u0005J\u0006\u0010\u0016\u001a\u00020\u0005J\u0006\u0010\u0017\u001a\u00020\u0005J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0016\u0010\u001b\u001a\u00020\u0005*\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001aH\u0002J\u0006\u0010\u001d\u001a\u00020\u0005¨\u0006\u001e"}, d2 = {"Landroidx/camera/camera2/compat/quirk/Device;", "", "<init>", "()V", "isBluDevice", "", "isHuaweiDevice", "isInfinixDevice", "isItelDevice", "isJioDevice", "isGoogleDevice", "isMotorolaDevice", "isNokiaDevice", "isOnePlusDevice", "isOppoDevice", "isPositivoDevice", "isRealmeDevice", "isRedmiDevice", "isSamsungDevice", "isSonyDevice", "isTecnoDevice", "isXiaomiDevice", "isVivoDevice", "isPocoDevice", "isDeviceFrom", "vendor", "", "equalsCaseInsensitive", "other", "isUniSocChipsetDevice", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Device {
    public static final Device INSTANCE = new Device();

    private Device() {
    }

    public final boolean isBluDevice() {
        return isDeviceFrom("Blu");
    }

    public final boolean isHuaweiDevice() {
        return isDeviceFrom("Huawei");
    }

    public final boolean isInfinixDevice() {
        return isDeviceFrom("Infinix");
    }

    public final boolean isItelDevice() {
        return isDeviceFrom("Itel");
    }

    public final boolean isJioDevice() {
        return isDeviceFrom("Jio");
    }

    public final boolean isGoogleDevice() {
        return isDeviceFrom("Google");
    }

    public final boolean isMotorolaDevice() {
        return isDeviceFrom("Motorola");
    }

    public final boolean isNokiaDevice() {
        return isDeviceFrom("Nokia");
    }

    public final boolean isOnePlusDevice() {
        return isDeviceFrom("OnePlus");
    }

    public final boolean isOppoDevice() {
        return isDeviceFrom("Oppo");
    }

    public final boolean isPositivoDevice() {
        return isDeviceFrom("Positivo");
    }

    public final boolean isRealmeDevice() {
        return isDeviceFrom("Realme");
    }

    public final boolean isRedmiDevice() {
        return isDeviceFrom("Redmi");
    }

    public final boolean isSamsungDevice() {
        return isDeviceFrom("Samsung");
    }

    public final boolean isSonyDevice() {
        return isDeviceFrom("Sony");
    }

    public final boolean isTecnoDevice() {
        return isDeviceFrom("Tecno") || isDeviceFrom("Tecno-mobile");
    }

    public final boolean isXiaomiDevice() {
        return isDeviceFrom("Xiaomi");
    }

    public final boolean isVivoDevice() {
        return isDeviceFrom("Vivo");
    }

    public final boolean isPocoDevice() {
        return isDeviceFrom("Poco");
    }

    private final boolean isDeviceFrom(String vendor) {
        String MANUFACTURER = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
        if (equalsCaseInsensitive(MANUFACTURER, vendor)) {
            return true;
        }
        String BRAND = Build.BRAND;
        Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
        return equalsCaseInsensitive(BRAND, vendor);
    }

    private final boolean equalsCaseInsensitive(String str, String str2) {
        return StringsKt.equals(str, str2, true);
    }

    public final boolean isUniSocChipsetDevice() {
        if (Build.VERSION.SDK_INT < 31 || !StringsKt.equals("Spreadtrum", Build.SOC_MANUFACTURER, true)) {
            String HARDWARE = Build.HARDWARE;
            Intrinsics.checkNotNullExpressionValue(HARDWARE, "HARDWARE");
            String lowerCase = HARDWARE.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (!StringsKt.startsWith$default(lowerCase, "ums", false, 2, (Object) null)) {
                if (isItelDevice()) {
                    String HARDWARE2 = Build.HARDWARE;
                    Intrinsics.checkNotNullExpressionValue(HARDWARE2, "HARDWARE");
                    String lowerCase2 = HARDWARE2.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                    if (StringsKt.startsWith$default(lowerCase2, "sp", false, 2, (Object) null)) {
                    }
                }
                return false;
            }
        }
        return true;
    }
}
