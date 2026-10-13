package io.datazoom.sdk.openmeasurement;

import androidx.mediarouter.media.MediaRouteProviderProtocol;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OmEvent.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u000f\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u000f\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !¨\u0006\""}, d2 = {"Lio/datazoom/sdk/openmeasurement/OmEvent;", "", "<init>", "()V", "Impression", "Loaded", "Start", "FirstQuartile", "MidPoint", "ThirdQuartile", "Complete", "Mute", "Unmute", "Pause", "Resume", "Fullscreen", "ExitFullscreen", "ClickThrough", "Skip", "Lio/datazoom/sdk/openmeasurement/OmEvent$ClickThrough;", "Lio/datazoom/sdk/openmeasurement/OmEvent$Complete;", "Lio/datazoom/sdk/openmeasurement/OmEvent$ExitFullscreen;", "Lio/datazoom/sdk/openmeasurement/OmEvent$FirstQuartile;", "Lio/datazoom/sdk/openmeasurement/OmEvent$Fullscreen;", "Lio/datazoom/sdk/openmeasurement/OmEvent$Impression;", "Lio/datazoom/sdk/openmeasurement/OmEvent$Loaded;", "Lio/datazoom/sdk/openmeasurement/OmEvent$MidPoint;", "Lio/datazoom/sdk/openmeasurement/OmEvent$Mute;", "Lio/datazoom/sdk/openmeasurement/OmEvent$Pause;", "Lio/datazoom/sdk/openmeasurement/OmEvent$Resume;", "Lio/datazoom/sdk/openmeasurement/OmEvent$Skip;", "Lio/datazoom/sdk/openmeasurement/OmEvent$Start;", "Lio/datazoom/sdk/openmeasurement/OmEvent$ThirdQuartile;", "Lio/datazoom/sdk/openmeasurement/OmEvent$Unmute;", "openmeasurement_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class OmEvent {
    public /* synthetic */ OmEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: OmEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/datazoom/sdk/openmeasurement/OmEvent$Impression;", "Lio/datazoom/sdk/openmeasurement/OmEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "openmeasurement_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Impression extends OmEvent {
        public static final Impression INSTANCE = new Impression();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Impression)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 144952916;
        }

        public String toString() {
            return "Impression";
        }

        private Impression() {
            super(null);
        }
    }

    private OmEvent() {
    }

    /* JADX INFO: compiled from: OmEvent.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lio/datazoom/sdk/openmeasurement/OmEvent$Loaded;", "Lio/datazoom/sdk/openmeasurement/OmEvent;", "vastProperties", "Lio/datazoom/sdk/openmeasurement/OMVastProperties;", "<init>", "(Lio/datazoom/sdk/openmeasurement/OMVastProperties;)V", "getVastProperties", "()Lio/datazoom/sdk/openmeasurement/OMVastProperties;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "openmeasurement_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Loaded extends OmEvent {
        private final OMVastProperties vastProperties;

        public static /* synthetic */ Loaded copy$default(Loaded loaded, OMVastProperties oMVastProperties, int i, Object obj) {
            if ((i & 1) != 0) {
                oMVastProperties = loaded.vastProperties;
            }
            return loaded.copy(oMVastProperties);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final OMVastProperties getVastProperties() {
            return this.vastProperties;
        }

        public final Loaded copy(OMVastProperties vastProperties) {
            Intrinsics.checkNotNullParameter(vastProperties, "vastProperties");
            return new Loaded(vastProperties);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Loaded) && Intrinsics.areEqual(this.vastProperties, ((Loaded) other).vastProperties);
        }

        public int hashCode() {
            return this.vastProperties.hashCode();
        }

        public String toString() {
            return "Loaded(vastProperties=" + this.vastProperties + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Loaded(OMVastProperties vastProperties) {
            super(null);
            Intrinsics.checkNotNullParameter(vastProperties, "vastProperties");
            this.vastProperties = vastProperties;
        }

        public final OMVastProperties getVastProperties() {
            return this.vastProperties;
        }
    }

    /* JADX INFO: compiled from: OmEvent.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0015"}, d2 = {"Lio/datazoom/sdk/openmeasurement/OmEvent$Start;", "Lio/datazoom/sdk/openmeasurement/OmEvent;", "duration", "", MediaRouteProviderProtocol.CLIENT_DATA_VOLUME, "<init>", "(FF)V", "getDuration", "()F", "getVolume", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "openmeasurement_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Start extends OmEvent {
        private final float duration;
        private final float volume;

        public static /* synthetic */ Start copy$default(Start start, float f, float f2, int i, Object obj) {
            if ((i & 1) != 0) {
                f = start.duration;
            }
            if ((i & 2) != 0) {
                f2 = start.volume;
            }
            return start.copy(f, f2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final float getDuration() {
            return this.duration;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final float getVolume() {
            return this.volume;
        }

        public final Start copy(float duration, float volume) {
            return new Start(duration, volume);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Start)) {
                return false;
            }
            Start start = (Start) other;
            return Float.compare(this.duration, start.duration) == 0 && Float.compare(this.volume, start.volume) == 0;
        }

        public int hashCode() {
            return (Float.hashCode(this.duration) * 31) + Float.hashCode(this.volume);
        }

        public String toString() {
            return "Start(duration=" + this.duration + ", volume=" + this.volume + ')';
        }

        public Start(float f, float f2) {
            super(null);
            this.duration = f;
            this.volume = f2;
        }

        public final float getDuration() {
            return this.duration;
        }

        public final float getVolume() {
            return this.volume;
        }
    }

    /* JADX INFO: compiled from: OmEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/datazoom/sdk/openmeasurement/OmEvent$FirstQuartile;", "Lio/datazoom/sdk/openmeasurement/OmEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "openmeasurement_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class FirstQuartile extends OmEvent {
        public static final FirstQuartile INSTANCE = new FirstQuartile();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FirstQuartile)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -495344600;
        }

        public String toString() {
            return "FirstQuartile";
        }

        private FirstQuartile() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: OmEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/datazoom/sdk/openmeasurement/OmEvent$MidPoint;", "Lio/datazoom/sdk/openmeasurement/OmEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "openmeasurement_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class MidPoint extends OmEvent {
        public static final MidPoint INSTANCE = new MidPoint();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MidPoint)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1974091571;
        }

        public String toString() {
            return "MidPoint";
        }

        private MidPoint() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: OmEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/datazoom/sdk/openmeasurement/OmEvent$ThirdQuartile;", "Lio/datazoom/sdk/openmeasurement/OmEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "openmeasurement_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class ThirdQuartile extends OmEvent {
        public static final ThirdQuartile INSTANCE = new ThirdQuartile();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ThirdQuartile)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1901572063;
        }

        public String toString() {
            return "ThirdQuartile";
        }

        private ThirdQuartile() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: OmEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/datazoom/sdk/openmeasurement/OmEvent$Complete;", "Lio/datazoom/sdk/openmeasurement/OmEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "openmeasurement_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Complete extends OmEvent {
        public static final Complete INSTANCE = new Complete();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Complete)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1251933116;
        }

        public String toString() {
            return "Complete";
        }

        private Complete() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: OmEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/datazoom/sdk/openmeasurement/OmEvent$Mute;", "Lio/datazoom/sdk/openmeasurement/OmEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "openmeasurement_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Mute extends OmEvent {
        public static final Mute INSTANCE = new Mute();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Mute)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1991271076;
        }

        public String toString() {
            return "Mute";
        }

        private Mute() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: OmEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/datazoom/sdk/openmeasurement/OmEvent$Unmute;", "Lio/datazoom/sdk/openmeasurement/OmEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "openmeasurement_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Unmute extends OmEvent {
        public static final Unmute INSTANCE = new Unmute();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Unmute)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1721530883;
        }

        public String toString() {
            return "Unmute";
        }

        private Unmute() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: OmEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/datazoom/sdk/openmeasurement/OmEvent$Pause;", "Lio/datazoom/sdk/openmeasurement/OmEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "openmeasurement_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Pause extends OmEvent {
        public static final Pause INSTANCE = new Pause();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Pause)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1602037451;
        }

        public String toString() {
            return "Pause";
        }

        private Pause() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: OmEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/datazoom/sdk/openmeasurement/OmEvent$Resume;", "Lio/datazoom/sdk/openmeasurement/OmEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "openmeasurement_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Resume extends OmEvent {
        public static final Resume INSTANCE = new Resume();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Resume)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1815551496;
        }

        public String toString() {
            return "Resume";
        }

        private Resume() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: OmEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/datazoom/sdk/openmeasurement/OmEvent$Fullscreen;", "Lio/datazoom/sdk/openmeasurement/OmEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "openmeasurement_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Fullscreen extends OmEvent {
        public static final Fullscreen INSTANCE = new Fullscreen();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Fullscreen)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 134395910;
        }

        public String toString() {
            return "Fullscreen";
        }

        private Fullscreen() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: OmEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/datazoom/sdk/openmeasurement/OmEvent$ExitFullscreen;", "Lio/datazoom/sdk/openmeasurement/OmEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "openmeasurement_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class ExitFullscreen extends OmEvent {
        public static final ExitFullscreen INSTANCE = new ExitFullscreen();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ExitFullscreen)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1751179844;
        }

        public String toString() {
            return "ExitFullscreen";
        }

        private ExitFullscreen() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: OmEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/datazoom/sdk/openmeasurement/OmEvent$ClickThrough;", "Lio/datazoom/sdk/openmeasurement/OmEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "openmeasurement_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class ClickThrough extends OmEvent {
        public static final ClickThrough INSTANCE = new ClickThrough();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ClickThrough)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1123412392;
        }

        public String toString() {
            return "ClickThrough";
        }

        private ClickThrough() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: OmEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/datazoom/sdk/openmeasurement/OmEvent$Skip;", "Lio/datazoom/sdk/openmeasurement/OmEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "openmeasurement_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Skip extends OmEvent {
        public static final Skip INSTANCE = new Skip();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Skip)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1991439882;
        }

        public String toString() {
            return "Skip";
        }

        private Skip() {
            super(null);
        }
    }
}
