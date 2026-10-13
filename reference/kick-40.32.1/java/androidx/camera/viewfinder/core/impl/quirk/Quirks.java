package androidx.camera.viewfinder.core.impl.quirk;

import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Quirks.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001c\u0010\b\u001a\u0004\u0018\u0001H\t\"\n\b\u0000\u0010\t\u0018\u0001*\u00020\u0004H\u0086\b¢\u0006\u0002\u0010\nJ\u0015\u0010\u000b\u001a\u00020\f\"\n\b\u0000\u0010\t\u0018\u0001*\u00020\u0004H\u0086\bJ\u0016\u0010\r\u001a\u00020\u000e2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0007R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/camera/viewfinder/core/impl/quirk/Quirks;", "", "quirks", "", "Landroidx/camera/viewfinder/core/impl/quirk/Quirk;", "<init>", "(Ljava/util/List;)V", "", "get", ExifInterface.GPS_DIRECTION_TRUE, "()Landroidx/camera/viewfinder/core/impl/quirk/Quirk;", "contains", "", "reset", "", "viewfinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Quirks {
    private final List<Quirk> quirks;

    public Quirks(List<? extends Quirk> quirks) {
        Intrinsics.checkNotNullParameter(quirks, "quirks");
        this.quirks = CollectionsKt.toMutableList((Collection) quirks);
    }

    public final /* synthetic */ <T extends Quirk> T get() {
        for (Object obj : this.quirks) {
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
        List<Quirk> list = this.quirks;
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

    public final void reset(List<? extends Quirk> quirks) {
        Intrinsics.checkNotNullParameter(quirks, "quirks");
        this.quirks.clear();
        this.quirks.addAll(quirks);
    }
}
