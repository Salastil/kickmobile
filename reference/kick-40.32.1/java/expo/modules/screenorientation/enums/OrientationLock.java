package expo.modules.screenorientation.enums;

import com.datadog.android.rum.internal.utils.ViewUtilsKt;
import expo.modules.core.errors.InvalidArgumentException;
import expo.modules.kotlin.types.Enumerable;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OrientationLock.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u0000 \u00182\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0018B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0013\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u0015J\r\u0010\u0016\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0017R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0019"}, d2 = {"Lexpo/modules/screenorientation/enums/OrientationLock;", "Lexpo/modules/kotlin/types/Enumerable;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Unspecified", "FullSensor", "SensorPortrait", "Portrait", "ReversePortrait", "SensorLandscape", "ReverseLandscape", "Landscape", "Other", ViewUtilsKt.UNKNOWN_DESTINATION_URL, "toOrientationAttr", "Lexpo/modules/screenorientation/enums/OrientationAttr;", "toOrientationAttr$expo_screen_orientation_release", "toPlatformInt", "toPlatformInt$expo_screen_orientation_release", "Companion", "expo-screen-orientation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum OrientationLock implements Enumerable {
    Unspecified(0),
    FullSensor(1),
    SensorPortrait(2),
    Portrait(3),
    ReversePortrait(4),
    SensorLandscape(5),
    ReverseLandscape(6),
    Landscape(7),
    Other(8),
    Unknown(9);

    private final int value;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public static EnumEntries<OrientationLock> getEntries() {
        return $ENTRIES;
    }

    OrientationLock(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }

    public final OrientationAttr toOrientationAttr$expo_screen_orientation_release() throws InvalidArgumentException {
        try {
            for (OrientationAttr orientationAttr : OrientationAttr.values()) {
                if (Intrinsics.areEqual(orientationAttr.name(), name())) {
                    return orientationAttr;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        } catch (NoSuchElementException unused) {
            throw new InvalidArgumentException("OrientationLock " + this + " is not mappable to a native Android orientation attr");
        }
    }

    public final int toPlatformInt$expo_screen_orientation_release() throws InvalidArgumentException {
        return toOrientationAttr$expo_screen_orientation_release().getValue();
    }

    /* JADX INFO: compiled from: OrientationLock.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\n"}, d2 = {"Lexpo/modules/screenorientation/enums/OrientationLock$Companion;", "", "<init>", "()V", "fromPlatformInt", "Lexpo/modules/screenorientation/enums/OrientationLock;", "value", "", "supportsOrientationLock", "", "expo-screen-orientation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final OrientationLock fromPlatformInt(int value) throws InvalidArgumentException {
            return OrientationAttr.INSTANCE.fromInt(value).toOrientationLock$expo_screen_orientation_release();
        }

        public final boolean supportsOrientationLock(int value) {
            for (OrientationLock orientationLock : OrientationLock.values()) {
                if (orientationLock.getValue() == value) {
                    if (value == OrientationLock.Other.getValue() || value == OrientationLock.Unknown.getValue()) {
                        break;
                    }
                    return true;
                }
            }
            return false;
        }
    }
}
