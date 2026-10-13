package androidx.camera.camera2.pipe.compat;

import androidx.camera.camera2.pipe.CameraError;
import androidx.camera.camera2.pipe.CameraId;
import androidx.camera.camera2.pipe.core.DurationNs;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VirtualCamera.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010$\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b%\u0010\u0014J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010(\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\b)J\u000b\u0010*\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\b,J\u0010\u0010-\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\b.J\u0010\u0010/\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\b0J\u0010\u00101\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\b2Jx\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0004\b4\u00105J\u0014\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u000109HÖ\u0083\u0004J\n\u0010:\u001a\u00020\u0007HÖ\u0081\u0004J\n\u0010;\u001a\u00020<HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0013\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u0006="}, d2 = {"Landroidx/camera/camera2/pipe/compat/CameraStateClosed;", "Landroidx/camera/camera2/pipe/compat/CameraState;", "cameraId", "Landroidx/camera/camera2/pipe/CameraId;", "cameraClosedReason", "Landroidx/camera/camera2/pipe/compat/ClosedReason;", "cameraRetryCount", "", "cameraRetryDurationNs", "Landroidx/camera/camera2/pipe/core/DurationNs;", "cameraException", "", "cameraOpenDurationNs", "cameraActiveDurationNs", "cameraClosingDurationNs", "cameraErrorCode", "Landroidx/camera/camera2/pipe/CameraError;", "<init>", "(Ljava/lang/String;Landroidx/camera/camera2/pipe/compat/ClosedReason;Ljava/lang/Integer;Landroidx/camera/camera2/pipe/core/DurationNs;Ljava/lang/Throwable;Landroidx/camera/camera2/pipe/core/DurationNs;Landroidx/camera/camera2/pipe/core/DurationNs;Landroidx/camera/camera2/pipe/core/DurationNs;Landroidx/camera/camera2/pipe/CameraError;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCameraId-Dz_R5H8", "()Ljava/lang/String;", "Ljava/lang/String;", "getCameraClosedReason", "()Landroidx/camera/camera2/pipe/compat/ClosedReason;", "getCameraRetryCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCameraRetryDurationNs-QWez1Bs", "()Landroidx/camera/camera2/pipe/core/DurationNs;", "getCameraException", "()Ljava/lang/Throwable;", "getCameraOpenDurationNs-QWez1Bs", "getCameraActiveDurationNs-QWez1Bs", "getCameraClosingDurationNs-QWez1Bs", "getCameraErrorCode-mVEW8x0", "()Landroidx/camera/camera2/pipe/CameraError;", "component1", "component1-Dz_R5H8", "component2", "component3", "component4", "component4-QWez1Bs", "component5", "component6", "component6-QWez1Bs", "component7", "component7-QWez1Bs", "component8", "component8-QWez1Bs", "component9", "component9-mVEW8x0", "copy", "copy-21rfiog", "(Ljava/lang/String;Landroidx/camera/camera2/pipe/compat/ClosedReason;Ljava/lang/Integer;Landroidx/camera/camera2/pipe/core/DurationNs;Ljava/lang/Throwable;Landroidx/camera/camera2/pipe/core/DurationNs;Landroidx/camera/camera2/pipe/core/DurationNs;Landroidx/camera/camera2/pipe/core/DurationNs;Landroidx/camera/camera2/pipe/CameraError;)Landroidx/camera/camera2/pipe/compat/CameraStateClosed;", "equals", "", "other", "", "hashCode", "toString", "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class CameraStateClosed extends CameraState {
    private final DurationNs cameraActiveDurationNs;
    private final ClosedReason cameraClosedReason;
    private final DurationNs cameraClosingDurationNs;
    private final CameraError cameraErrorCode;
    private final Throwable cameraException;
    private final String cameraId;
    private final DurationNs cameraOpenDurationNs;
    private final Integer cameraRetryCount;
    private final DurationNs cameraRetryDurationNs;

    public /* synthetic */ CameraStateClosed(String str, ClosedReason closedReason, Integer num, DurationNs durationNs, Throwable th, DurationNs durationNs2, DurationNs durationNs3, DurationNs durationNs4, CameraError cameraError, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, closedReason, num, durationNs, th, durationNs2, durationNs3, durationNs4, cameraError);
    }

    /* JADX INFO: renamed from: copy-21rfiog$default, reason: not valid java name */
    public static /* synthetic */ CameraStateClosed m853copy21rfiog$default(CameraStateClosed cameraStateClosed, String str, ClosedReason closedReason, Integer num, DurationNs durationNs, Throwable th, DurationNs durationNs2, DurationNs durationNs3, DurationNs durationNs4, CameraError cameraError, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cameraStateClosed.cameraId;
        }
        if ((i & 2) != 0) {
            closedReason = cameraStateClosed.cameraClosedReason;
        }
        if ((i & 4) != 0) {
            num = cameraStateClosed.cameraRetryCount;
        }
        if ((i & 8) != 0) {
            durationNs = cameraStateClosed.cameraRetryDurationNs;
        }
        if ((i & 16) != 0) {
            th = cameraStateClosed.cameraException;
        }
        if ((i & 32) != 0) {
            durationNs2 = cameraStateClosed.cameraOpenDurationNs;
        }
        if ((i & 64) != 0) {
            durationNs3 = cameraStateClosed.cameraActiveDurationNs;
        }
        if ((i & 128) != 0) {
            durationNs4 = cameraStateClosed.cameraClosingDurationNs;
        }
        if ((i & 256) != 0) {
            cameraError = cameraStateClosed.cameraErrorCode;
        }
        DurationNs durationNs5 = durationNs4;
        CameraError cameraError2 = cameraError;
        DurationNs durationNs6 = durationNs2;
        DurationNs durationNs7 = durationNs3;
        Throwable th2 = th;
        Integer num2 = num;
        return cameraStateClosed.m860copy21rfiog(str, closedReason, num2, durationNs, th2, durationNs6, durationNs7, durationNs5, cameraError2);
    }

    /* JADX INFO: renamed from: component1-Dz_R5H8, reason: not valid java name and from getter */
    public final String getCameraId() {
        return this.cameraId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ClosedReason getCameraClosedReason() {
        return this.cameraClosedReason;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getCameraRetryCount() {
        return this.cameraRetryCount;
    }

    /* JADX INFO: renamed from: component4-QWez1Bs, reason: not valid java name and from getter */
    public final DurationNs getCameraRetryDurationNs() {
        return this.cameraRetryDurationNs;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Throwable getCameraException() {
        return this.cameraException;
    }

    /* JADX INFO: renamed from: component6-QWez1Bs, reason: not valid java name and from getter */
    public final DurationNs getCameraOpenDurationNs() {
        return this.cameraOpenDurationNs;
    }

    /* JADX INFO: renamed from: component7-QWez1Bs, reason: not valid java name and from getter */
    public final DurationNs getCameraActiveDurationNs() {
        return this.cameraActiveDurationNs;
    }

    /* JADX INFO: renamed from: component8-QWez1Bs, reason: not valid java name and from getter */
    public final DurationNs getCameraClosingDurationNs() {
        return this.cameraClosingDurationNs;
    }

    /* JADX INFO: renamed from: component9-mVEW8x0, reason: not valid java name and from getter */
    public final CameraError getCameraErrorCode() {
        return this.cameraErrorCode;
    }

    /* JADX INFO: renamed from: copy-21rfiog, reason: not valid java name */
    public final CameraStateClosed m860copy21rfiog(String cameraId, ClosedReason cameraClosedReason, Integer cameraRetryCount, DurationNs cameraRetryDurationNs, Throwable cameraException, DurationNs cameraOpenDurationNs, DurationNs cameraActiveDurationNs, DurationNs cameraClosingDurationNs, CameraError cameraErrorCode) {
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        Intrinsics.checkNotNullParameter(cameraClosedReason, "cameraClosedReason");
        return new CameraStateClosed(cameraId, cameraClosedReason, cameraRetryCount, cameraRetryDurationNs, cameraException, cameraOpenDurationNs, cameraActiveDurationNs, cameraClosingDurationNs, cameraErrorCode, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CameraStateClosed)) {
            return false;
        }
        CameraStateClosed cameraStateClosed = (CameraStateClosed) other;
        return CameraId.m429equalsimpl0(this.cameraId, cameraStateClosed.cameraId) && this.cameraClosedReason == cameraStateClosed.cameraClosedReason && Intrinsics.areEqual(this.cameraRetryCount, cameraStateClosed.cameraRetryCount) && Intrinsics.areEqual(this.cameraRetryDurationNs, cameraStateClosed.cameraRetryDurationNs) && Intrinsics.areEqual(this.cameraException, cameraStateClosed.cameraException) && Intrinsics.areEqual(this.cameraOpenDurationNs, cameraStateClosed.cameraOpenDurationNs) && Intrinsics.areEqual(this.cameraActiveDurationNs, cameraStateClosed.cameraActiveDurationNs) && Intrinsics.areEqual(this.cameraClosingDurationNs, cameraStateClosed.cameraClosingDurationNs) && Intrinsics.areEqual(this.cameraErrorCode, cameraStateClosed.cameraErrorCode);
    }

    public int hashCode() {
        int iM430hashCodeimpl = ((CameraId.m430hashCodeimpl(this.cameraId) * 31) + this.cameraClosedReason.hashCode()) * 31;
        Integer num = this.cameraRetryCount;
        int iHashCode = (iM430hashCodeimpl + (num == null ? 0 : num.hashCode())) * 31;
        DurationNs durationNs = this.cameraRetryDurationNs;
        int iM920hashCodeimpl = (iHashCode + (durationNs == null ? 0 : DurationNs.m920hashCodeimpl(durationNs.m925unboximpl()))) * 31;
        Throwable th = this.cameraException;
        int iHashCode2 = (iM920hashCodeimpl + (th == null ? 0 : th.hashCode())) * 31;
        DurationNs durationNs2 = this.cameraOpenDurationNs;
        int iM920hashCodeimpl2 = (iHashCode2 + (durationNs2 == null ? 0 : DurationNs.m920hashCodeimpl(durationNs2.m925unboximpl()))) * 31;
        DurationNs durationNs3 = this.cameraActiveDurationNs;
        int iM920hashCodeimpl3 = (iM920hashCodeimpl2 + (durationNs3 == null ? 0 : DurationNs.m920hashCodeimpl(durationNs3.m925unboximpl()))) * 31;
        DurationNs durationNs4 = this.cameraClosingDurationNs;
        int iM920hashCodeimpl4 = (iM920hashCodeimpl3 + (durationNs4 == null ? 0 : DurationNs.m920hashCodeimpl(durationNs4.m925unboximpl()))) * 31;
        CameraError cameraError = this.cameraErrorCode;
        return iM920hashCodeimpl4 + (cameraError != null ? CameraError.m355hashCodeimpl(cameraError.m358unboximpl()) : 0);
    }

    public String toString() {
        return "CameraStateClosed(cameraId=" + ((Object) CameraId.m432toStringimpl(this.cameraId)) + ", cameraClosedReason=" + this.cameraClosedReason + ", cameraRetryCount=" + this.cameraRetryCount + ", cameraRetryDurationNs=" + this.cameraRetryDurationNs + ", cameraException=" + this.cameraException + ", cameraOpenDurationNs=" + this.cameraOpenDurationNs + ", cameraActiveDurationNs=" + this.cameraActiveDurationNs + ", cameraClosingDurationNs=" + this.cameraClosingDurationNs + ", cameraErrorCode=" + this.cameraErrorCode + ')';
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private CameraStateClosed(String cameraId, ClosedReason cameraClosedReason, Integer num, DurationNs durationNs, Throwable th, DurationNs durationNs2, DurationNs durationNs3, DurationNs durationNs4, CameraError cameraError) {
        super(null);
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        Intrinsics.checkNotNullParameter(cameraClosedReason, "cameraClosedReason");
        this.cameraId = cameraId;
        this.cameraClosedReason = cameraClosedReason;
        this.cameraRetryCount = num;
        this.cameraRetryDurationNs = durationNs;
        this.cameraException = th;
        this.cameraOpenDurationNs = durationNs2;
        this.cameraActiveDurationNs = durationNs3;
        this.cameraClosingDurationNs = durationNs4;
        this.cameraErrorCode = cameraError;
    }

    public /* synthetic */ CameraStateClosed(String str, ClosedReason closedReason, Integer num, DurationNs durationNs, Throwable th, DurationNs durationNs2, DurationNs durationNs3, DurationNs durationNs4, CameraError cameraError, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, closedReason, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : durationNs, (i & 16) != 0 ? null : th, (i & 32) != 0 ? null : durationNs2, (i & 64) != 0 ? null : durationNs3, (i & 128) != 0 ? null : durationNs4, (i & 256) != 0 ? null : cameraError, null);
    }

    /* JADX INFO: renamed from: getCameraId-Dz_R5H8, reason: not valid java name */
    public final String m864getCameraIdDz_R5H8() {
        return this.cameraId;
    }

    public final ClosedReason getCameraClosedReason() {
        return this.cameraClosedReason;
    }

    public final Integer getCameraRetryCount() {
        return this.cameraRetryCount;
    }

    /* JADX INFO: renamed from: getCameraRetryDurationNs-QWez1Bs, reason: not valid java name */
    public final DurationNs m866getCameraRetryDurationNsQWez1Bs() {
        return this.cameraRetryDurationNs;
    }

    public final Throwable getCameraException() {
        return this.cameraException;
    }

    /* JADX INFO: renamed from: getCameraOpenDurationNs-QWez1Bs, reason: not valid java name */
    public final DurationNs m865getCameraOpenDurationNsQWez1Bs() {
        return this.cameraOpenDurationNs;
    }

    /* JADX INFO: renamed from: getCameraActiveDurationNs-QWez1Bs, reason: not valid java name */
    public final DurationNs m861getCameraActiveDurationNsQWez1Bs() {
        return this.cameraActiveDurationNs;
    }

    /* JADX INFO: renamed from: getCameraClosingDurationNs-QWez1Bs, reason: not valid java name */
    public final DurationNs m862getCameraClosingDurationNsQWez1Bs() {
        return this.cameraClosingDurationNs;
    }

    /* JADX INFO: renamed from: getCameraErrorCode-mVEW8x0, reason: not valid java name */
    public final CameraError m863getCameraErrorCodemVEW8x0() {
        return this.cameraErrorCode;
    }
}
