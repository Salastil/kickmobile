package androidx.camera.camera2.pipe.graph;

import androidx.camera.camera2.pipe.Lock3ABehavior;
import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import kotlin.Metadata;

/* JADX INFO: compiled from: Controller3A.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u001a'\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0004\u0018\u0001H\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0002¢\u0006\u0002\u0010\u0005\u001a\u0013\u0010\u0006\u001a\u00020\u0001*\u0004\u0018\u00010\u0007H\u0000¢\u0006\u0002\b\b\u001a\u0013\u0010\t\u001a\u00020\u0001*\u0004\u0018\u00010\u0007H\u0000¢\u0006\u0002\b\n\u001a\u0013\u0010\u000b\u001a\u00020\u0001*\u0004\u0018\u00010\u0007H\u0000¢\u0006\u0002\b\f\u001a\u0013\u0010\r\u001a\u00020\u0001*\u0004\u0018\u00010\u0007H\u0000¢\u0006\u0002\b\u000e\u001a\u0013\u0010\u000f\u001a\u00020\u0001*\u0004\u0018\u00010\u0007H\u0000¢\u0006\u0002\b\u0010\u001a\u0013\u0010\u0011\u001a\u00020\u0001*\u0004\u0018\u00010\u0007H\u0000¢\u0006\u0002\b\u0012¨\u0006\u0013"}, d2 = {"isNullOrIn", "", ExifInterface.GPS_DIRECTION_TRUE, "collection", "", "(Ljava/lang/Object;Ljava/util/Collection;)Z", "shouldUnlockAe", "Landroidx/camera/camera2/pipe/Lock3ABehavior;", "shouldUnlockAe-t6FjEyI", "shouldUnlockAf", "shouldUnlockAf-t6FjEyI", "shouldUnlockAwb", "shouldUnlockAwb-t6FjEyI", "shouldWaitForAeToConverge", "shouldWaitForAeToConverge-t6FjEyI", "shouldWaitForAwbToConverge", "shouldWaitForAwbToConverge-t6FjEyI", "shouldWaitForAfToConverge", "shouldWaitForAfToConverge-t6FjEyI", "camera-camera2-pipe"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class Controller3AKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> boolean isNullOrIn(T t, Collection<? extends T> collection) {
        if (t != null) {
            return collection.contains(t);
        }
        return true;
    }

    /* JADX INFO: renamed from: shouldUnlockAe-t6FjEyI, reason: not valid java name */
    public static final boolean m957shouldUnlockAet6FjEyI(Lock3ABehavior lock3ABehavior) {
        int iM566getAFTER_NEW_SCANhRqSH3k = Lock3ABehavior.INSTANCE.m566getAFTER_NEW_SCANhRqSH3k();
        if (lock3ABehavior == null) {
            return false;
        }
        return Lock3ABehavior.m561equalsimpl0(lock3ABehavior.m564unboximpl(), iM566getAFTER_NEW_SCANhRqSH3k);
    }

    /* JADX INFO: renamed from: shouldUnlockAf-t6FjEyI, reason: not valid java name */
    public static final boolean m958shouldUnlockAft6FjEyI(Lock3ABehavior lock3ABehavior) {
        int iM566getAFTER_NEW_SCANhRqSH3k = Lock3ABehavior.INSTANCE.m566getAFTER_NEW_SCANhRqSH3k();
        if (lock3ABehavior == null) {
            return false;
        }
        return Lock3ABehavior.m561equalsimpl0(lock3ABehavior.m564unboximpl(), iM566getAFTER_NEW_SCANhRqSH3k);
    }

    /* JADX INFO: renamed from: shouldUnlockAwb-t6FjEyI, reason: not valid java name */
    public static final boolean m959shouldUnlockAwbt6FjEyI(Lock3ABehavior lock3ABehavior) {
        int iM566getAFTER_NEW_SCANhRqSH3k = Lock3ABehavior.INSTANCE.m566getAFTER_NEW_SCANhRqSH3k();
        if (lock3ABehavior == null) {
            return false;
        }
        return Lock3ABehavior.m561equalsimpl0(lock3ABehavior.m564unboximpl(), iM566getAFTER_NEW_SCANhRqSH3k);
    }

    /* JADX INFO: renamed from: shouldWaitForAeToConverge-t6FjEyI, reason: not valid java name */
    public static final boolean m960shouldWaitForAeToConverget6FjEyI(Lock3ABehavior lock3ABehavior) {
        if (lock3ABehavior != null) {
            return !Lock3ABehavior.m561equalsimpl0(lock3ABehavior.m564unboximpl(), Lock3ABehavior.INSTANCE.m567getIMMEDIATEhRqSH3k());
        }
        return false;
    }

    /* JADX INFO: renamed from: shouldWaitForAwbToConverge-t6FjEyI, reason: not valid java name */
    public static final boolean m962shouldWaitForAwbToConverget6FjEyI(Lock3ABehavior lock3ABehavior) {
        if (lock3ABehavior != null) {
            return !Lock3ABehavior.m561equalsimpl0(lock3ABehavior.m564unboximpl(), Lock3ABehavior.INSTANCE.m567getIMMEDIATEhRqSH3k());
        }
        return false;
    }

    /* JADX INFO: renamed from: shouldWaitForAfToConverge-t6FjEyI, reason: not valid java name */
    public static final boolean m961shouldWaitForAfToConverget6FjEyI(Lock3ABehavior lock3ABehavior) {
        if (lock3ABehavior != null) {
            return !Lock3ABehavior.m561equalsimpl0(lock3ABehavior.m564unboximpl(), Lock3ABehavior.INSTANCE.m567getIMMEDIATEhRqSH3k());
        }
        return false;
    }
}
