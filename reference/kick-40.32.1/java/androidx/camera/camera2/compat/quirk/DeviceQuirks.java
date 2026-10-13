package androidx.camera.camera2.compat.quirk;

import androidx.camera.core.Logger;
import androidx.camera.core.impl.Quirk;
import androidx.camera.core.impl.QuirkSettings;
import androidx.camera.core.impl.QuirkSettingsHolder;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.core.util.Consumer;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeviceQuirks.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\r\u001a\u0004\u0018\u0001H\u000e\"\n\b\u0000\u0010\u000e*\u0004\u0018\u00010\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0011H\u0086\u0002¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R$\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087.¢\u0006\u0014\n\u0000\u0012\u0004\b\b\u0010\u0003\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Landroidx/camera/camera2/compat/quirk/DeviceQuirks;", "", "<init>", "()V", "TAG", "", "all", "Landroidx/camera/core/impl/Quirks;", "getAll$annotations", "getAll", "()Landroidx/camera/core/impl/Quirks;", "setAll", "(Landroidx/camera/core/impl/Quirks;)V", "get", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/camera/core/impl/Quirk;", "quirkClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/camera/core/impl/Quirk;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeviceQuirks {
    public static final DeviceQuirks INSTANCE = new DeviceQuirks();
    private static final String TAG = "DeviceQuirks";
    public static volatile Quirks all;

    @JvmStatic
    public static /* synthetic */ void getAll$annotations() {
    }

    private DeviceQuirks() {
    }

    public static final Quirks getAll() {
        Quirks quirks = all;
        if (quirks != null) {
            return quirks;
        }
        Intrinsics.throwUninitializedPropertyAccessException("all");
        return null;
    }

    public static final void setAll(Quirks quirks) {
        Intrinsics.checkNotNullParameter(quirks, "<set-?>");
        all = quirks;
    }

    static {
        QuirkSettingsHolder.instance().observe(CameraXExecutors.directExecutor(), new Consumer() { // from class: androidx.camera.camera2.compat.quirk.DeviceQuirks$$ExternalSyntheticLambda0
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                DeviceQuirks._init_$lambda$0((QuirkSettings) obj);
            }
        });
    }

    static final void _init_$lambda$0(QuirkSettings quirkSettings) {
        DeviceQuirksLoader deviceQuirksLoader = DeviceQuirksLoader.INSTANCE;
        Intrinsics.checkNotNull(quirkSettings);
        setAll(new Quirks(deviceQuirksLoader.loadQuirks(quirkSettings)));
        Logger.d(TAG, "camera2 DeviceQuirks = " + Quirks.toString(getAll()));
    }

    public final <T extends Quirk> T get(Class<T> quirkClass) {
        Intrinsics.checkNotNullParameter(quirkClass, "quirkClass");
        return (T) getAll().get(quirkClass);
    }
}
