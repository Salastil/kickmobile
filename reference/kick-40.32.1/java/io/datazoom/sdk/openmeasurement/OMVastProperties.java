package io.datazoom.sdk.openmeasurement;

import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OmEvent.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\bHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lio/datazoom/sdk/openmeasurement/OMVastProperties;", "", "skipAble", "", "skipOffset", "", "autoStart", ViewProps.POSITION, "", "<init>", "(ZFZLjava/lang/String;)V", "getSkipAble", "()Z", "getSkipOffset", "()F", "getAutoStart", "getPosition", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "openmeasurement_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class OMVastProperties {
    private final boolean autoStart;
    private final String position;
    private final boolean skipAble;
    private final float skipOffset;

    public static /* synthetic */ OMVastProperties copy$default(OMVastProperties oMVastProperties, boolean z, float f, boolean z2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = oMVastProperties.skipAble;
        }
        if ((i & 2) != 0) {
            f = oMVastProperties.skipOffset;
        }
        if ((i & 4) != 0) {
            z2 = oMVastProperties.autoStart;
        }
        if ((i & 8) != 0) {
            str = oMVastProperties.position;
        }
        return oMVastProperties.copy(z, f, z2, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getSkipAble() {
        return this.skipAble;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getSkipOffset() {
        return this.skipOffset;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getAutoStart() {
        return this.autoStart;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPosition() {
        return this.position;
    }

    public final OMVastProperties copy(boolean skipAble, float skipOffset, boolean autoStart, String position) {
        Intrinsics.checkNotNullParameter(position, "position");
        return new OMVastProperties(skipAble, skipOffset, autoStart, position);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OMVastProperties)) {
            return false;
        }
        OMVastProperties oMVastProperties = (OMVastProperties) other;
        return this.skipAble == oMVastProperties.skipAble && Float.compare(this.skipOffset, oMVastProperties.skipOffset) == 0 && this.autoStart == oMVastProperties.autoStart && Intrinsics.areEqual(this.position, oMVastProperties.position);
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.skipAble) * 31) + Float.hashCode(this.skipOffset)) * 31) + Boolean.hashCode(this.autoStart)) * 31) + this.position.hashCode();
    }

    public String toString() {
        return "OMVastProperties(skipAble=" + this.skipAble + ", skipOffset=" + this.skipOffset + ", autoStart=" + this.autoStart + ", position=" + this.position + ')';
    }

    public OMVastProperties(boolean z, float f, boolean z2, String position) {
        Intrinsics.checkNotNullParameter(position, "position");
        this.skipAble = z;
        this.skipOffset = f;
        this.autoStart = z2;
        this.position = position;
    }

    public final boolean getAutoStart() {
        return this.autoStart;
    }

    public final String getPosition() {
        return this.position;
    }

    public final boolean getSkipAble() {
        return this.skipAble;
    }

    public final float getSkipOffset() {
        return this.skipOffset;
    }
}
