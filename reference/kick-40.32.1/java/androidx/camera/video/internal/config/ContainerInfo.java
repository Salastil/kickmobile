package androidx.camera.video.internal.config;

import androidx.camera.core.impl.EncoderProfilesProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContainerInfo.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\u00020\u0003¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Landroidx/camera/video/internal/config/ContainerInfo;", "", "outputFormat", "", "compatibleEncoderProfiles", "Landroidx/camera/core/impl/EncoderProfilesProxy;", "<init>", "(ILandroidx/camera/core/impl/EncoderProfilesProxy;)V", "getOutputFormat$annotations", "()V", "getOutputFormat", "()I", "getCompatibleEncoderProfiles", "()Landroidx/camera/core/impl/EncoderProfilesProxy;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "camera-video"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class ContainerInfo {
    private final EncoderProfilesProxy compatibleEncoderProfiles;
    private final int outputFormat;

    public static /* synthetic */ ContainerInfo copy$default(ContainerInfo containerInfo, int i, EncoderProfilesProxy encoderProfilesProxy, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = containerInfo.outputFormat;
        }
        if ((i2 & 2) != 0) {
            encoderProfilesProxy = containerInfo.compatibleEncoderProfiles;
        }
        return containerInfo.copy(i, encoderProfilesProxy);
    }

    public static /* synthetic */ void getOutputFormat$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getOutputFormat() {
        return this.outputFormat;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final EncoderProfilesProxy getCompatibleEncoderProfiles() {
        return this.compatibleEncoderProfiles;
    }

    public final ContainerInfo copy(int outputFormat, EncoderProfilesProxy compatibleEncoderProfiles) {
        return new ContainerInfo(outputFormat, compatibleEncoderProfiles);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ContainerInfo)) {
            return false;
        }
        ContainerInfo containerInfo = (ContainerInfo) other;
        return this.outputFormat == containerInfo.outputFormat && Intrinsics.areEqual(this.compatibleEncoderProfiles, containerInfo.compatibleEncoderProfiles);
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.outputFormat) * 31;
        EncoderProfilesProxy encoderProfilesProxy = this.compatibleEncoderProfiles;
        return iHashCode + (encoderProfilesProxy == null ? 0 : encoderProfilesProxy.hashCode());
    }

    public String toString() {
        return "ContainerInfo(outputFormat=" + this.outputFormat + ", compatibleEncoderProfiles=" + this.compatibleEncoderProfiles + ')';
    }

    public ContainerInfo(int i, EncoderProfilesProxy encoderProfilesProxy) {
        this.outputFormat = i;
        this.compatibleEncoderProfiles = encoderProfilesProxy;
    }

    public final int getOutputFormat() {
        return this.outputFormat;
    }

    public final EncoderProfilesProxy getCompatibleEncoderProfiles() {
        return this.compatibleEncoderProfiles;
    }
}
