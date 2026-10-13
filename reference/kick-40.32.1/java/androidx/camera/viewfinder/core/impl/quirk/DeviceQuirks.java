package androidx.camera.viewfinder.core.impl.quirk;

import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeviceQuirks.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0006\u001a\u0004\u0018\u0001H\u0007\"\n\b\u0000\u0010\u0007\u0018\u0001*\u00020\bH\u0086\b¢\u0006\u0002\u0010\tJ\u0015\u0010\n\u001a\u00020\u000b\"\n\b\u0000\u0010\u0007\u0018\u0001*\u00020\bH\u0086\bJ\b\u0010\f\u001a\u00020\rH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/camera/viewfinder/core/impl/quirk/DeviceQuirks;", "", "<init>", "()V", "QUIRKS", "Landroidx/camera/viewfinder/core/impl/quirk/Quirks;", "get", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/camera/viewfinder/core/impl/quirk/Quirk;", "()Landroidx/camera/viewfinder/core/impl/quirk/Quirk;", "contains", "", "reload", "", "viewfinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DeviceQuirks {
    public static final DeviceQuirks INSTANCE = new DeviceQuirks();
    private static final Quirks QUIRKS = new Quirks(DeviceQuirksLoader.loadQuirks());

    private DeviceQuirks() {
    }

    public final /* synthetic */ <T extends Quirk> T get() {
        for (Object obj : QUIRKS.quirks) {
            Class<?> cls = ((Quirk) obj).getClass();
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            if (cls == Quirk.class) {
                Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
                return (T) obj;
            }
        }
        obj = null;
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) obj;
    }

    public final /* synthetic */ <T extends Quirk> boolean contains() {
        List<Quirk> list = QUIRKS.quirks;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        for (Quirk quirk : list) {
            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (quirk instanceof Quirk) {
                return true;
            }
        }
        return false;
    }

    public final void reload() {
        QUIRKS.reset(DeviceQuirksLoader.loadQuirks());
    }
}
