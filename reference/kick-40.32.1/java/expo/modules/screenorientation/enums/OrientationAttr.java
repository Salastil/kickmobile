package expo.modules.screenorientation.enums;

import expo.modules.core.errors.InvalidArgumentException;
import expo.modules.kotlin.types.Enumerable;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OrientationAttr.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u0000 \u001c2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u001cB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0019\u001a\u00020\u001aH\u0000¢\u0006\u0002\b\u001bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u001d"}, d2 = {"Lexpo/modules/screenorientation/enums/OrientationAttr;", "Lexpo/modules/kotlin/types/Enumerable;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Behind", "Landscape", "Portrait", "FullSensor", "Unspecified", "Locked", "FullUser", "NoSensor", "ReverseLandscape", "ReversePortrait", "Sensor", "SensorPortrait", "SensorLandscape", "User", "UserPortrait", "UserLandscape", "toOrientationLock", "Lexpo/modules/screenorientation/enums/OrientationLock;", "toOrientationLock$expo_screen_orientation_release", "Companion", "expo-screen-orientation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum OrientationAttr implements Enumerable {
    Behind(3),
    Landscape(0),
    Portrait(1),
    FullSensor(10),
    Unspecified(-1),
    Locked(14),
    FullUser(13),
    NoSensor(5),
    ReverseLandscape(8),
    ReversePortrait(9),
    Sensor(4),
    SensorPortrait(7),
    SensorLandscape(6),
    User(2),
    UserPortrait(12),
    UserLandscape(11);

    private final int value;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public static EnumEntries<OrientationAttr> getEntries() {
        return $ENTRIES;
    }

    OrientationAttr(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }

    public final OrientationLock toOrientationLock$expo_screen_orientation_release() {
        try {
            for (OrientationLock orientationLock : OrientationLock.values()) {
                if (Intrinsics.areEqual(orientationLock.name(), name())) {
                    return orientationLock;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        } catch (NoSuchElementException unused) {
            return OrientationLock.Other;
        }
    }

    /* JADX INFO: compiled from: OrientationAttr.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/screenorientation/enums/OrientationAttr$Companion;", "", "<init>", "()V", "fromInt", "Lexpo/modules/screenorientation/enums/OrientationAttr;", "value", "", "expo-screen-orientation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final OrientationAttr fromInt(int value) throws InvalidArgumentException {
            try {
                for (OrientationAttr orientationAttr : OrientationAttr.values()) {
                    if (orientationAttr.getValue() == value) {
                        return orientationAttr;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            } catch (NoSuchElementException unused) {
                throw new InvalidArgumentException("Platform orientation " + value + " is not a valid Android orientation attr");
            }
        }
    }
}
