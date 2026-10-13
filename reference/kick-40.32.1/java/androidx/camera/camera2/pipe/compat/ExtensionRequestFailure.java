package androidx.camera.camera2.pipe.compat;

import androidx.camera.camera2.pipe.FrameNumber;
import androidx.camera.camera2.pipe.RequestFailure;
import androidx.camera.camera2.pipe.RequestMetadata;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: ExtensionRequestFailure.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u0015\u001a\u0004\u0018\u0001H\u0016\"\b\b\u0000\u0010\u0016*\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0019H\u0016¢\u0006\u0002\u0010\u001aJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u001d\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0011J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J8\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b!\u0010\"J\u0014\u0010#\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\u0017HÖ\u0083\u0004J\n\u0010%\u001a\u00020\tHÖ\u0081\u0004J\n\u0010&\u001a\u00020'HÖ\u0081\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006("}, d2 = {"Landroidx/camera/camera2/pipe/compat/ExtensionRequestFailure;", "Landroidx/camera/camera2/pipe/RequestFailure;", "requestMetadata", "Landroidx/camera/camera2/pipe/RequestMetadata;", "wasImageCaptured", "", "frameNumber", "Landroidx/camera/camera2/pipe/FrameNumber;", "reason", "", "<init>", "(Landroidx/camera/camera2/pipe/RequestMetadata;ZJILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getRequestMetadata", "()Landroidx/camera/camera2/pipe/RequestMetadata;", "getWasImageCaptured", "()Z", "getFrameNumber-Ugla2oM", "()J", "J", "getReason", "()I", "unwrapAs", ExifInterface.GPS_DIRECTION_TRUE, "", "type", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "component1", "component2", "component3", "component3-Ugla2oM", "component4", "copy", "copy-FsN21Hw", "(Landroidx/camera/camera2/pipe/RequestMetadata;ZJI)Landroidx/camera/camera2/pipe/compat/ExtensionRequestFailure;", "equals", "other", "hashCode", "toString", "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class ExtensionRequestFailure implements RequestFailure {
    private final long frameNumber;
    private final int reason;
    private final RequestMetadata requestMetadata;
    private final boolean wasImageCaptured;

    public /* synthetic */ ExtensionRequestFailure(RequestMetadata requestMetadata, boolean z, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(requestMetadata, z, j, i);
    }

    /* JADX INFO: renamed from: copy-FsN21Hw$default, reason: not valid java name */
    public static /* synthetic */ ExtensionRequestFailure m873copyFsN21Hw$default(ExtensionRequestFailure extensionRequestFailure, RequestMetadata requestMetadata, boolean z, long j, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            requestMetadata = extensionRequestFailure.requestMetadata;
        }
        if ((i2 & 2) != 0) {
            z = extensionRequestFailure.wasImageCaptured;
        }
        if ((i2 & 4) != 0) {
            j = extensionRequestFailure.frameNumber;
        }
        if ((i2 & 8) != 0) {
            i = extensionRequestFailure.reason;
        }
        int i3 = i;
        return extensionRequestFailure.m875copyFsN21Hw(requestMetadata, z, j, i3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final RequestMetadata getRequestMetadata() {
        return this.requestMetadata;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getWasImageCaptured() {
        return this.wasImageCaptured;
    }

    /* JADX INFO: renamed from: component3-Ugla2oM, reason: not valid java name and from getter */
    public final long getFrameNumber() {
        return this.frameNumber;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getReason() {
        return this.reason;
    }

    /* JADX INFO: renamed from: copy-FsN21Hw, reason: not valid java name */
    public final ExtensionRequestFailure m875copyFsN21Hw(RequestMetadata requestMetadata, boolean wasImageCaptured, long frameNumber, int reason) {
        Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
        return new ExtensionRequestFailure(requestMetadata, wasImageCaptured, frameNumber, reason, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExtensionRequestFailure)) {
            return false;
        }
        ExtensionRequestFailure extensionRequestFailure = (ExtensionRequestFailure) other;
        return Intrinsics.areEqual(this.requestMetadata, extensionRequestFailure.requestMetadata) && this.wasImageCaptured == extensionRequestFailure.wasImageCaptured && FrameNumber.m534equalsimpl0(this.frameNumber, extensionRequestFailure.frameNumber) && this.reason == extensionRequestFailure.reason;
    }

    public int hashCode() {
        return (((((this.requestMetadata.hashCode() * 31) + Boolean.hashCode(this.wasImageCaptured)) * 31) + FrameNumber.m535hashCodeimpl(this.frameNumber)) * 31) + Integer.hashCode(this.reason);
    }

    public String toString() {
        return "ExtensionRequestFailure(requestMetadata=" + this.requestMetadata + ", wasImageCaptured=" + this.wasImageCaptured + ", frameNumber=" + ((Object) FrameNumber.m536toStringimpl(this.frameNumber)) + ", reason=" + this.reason + ')';
    }

    @Override // androidx.camera.camera2.pipe.UnsafeWrapper
    public <T> T unwrapAs(KClass<T> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return null;
    }

    private ExtensionRequestFailure(RequestMetadata requestMetadata, boolean z, long j, int i) {
        Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
        this.requestMetadata = requestMetadata;
        this.wasImageCaptured = z;
        this.frameNumber = j;
        this.reason = i;
    }

    @Override // androidx.camera.camera2.pipe.RequestFailure
    public RequestMetadata getRequestMetadata() {
        return this.requestMetadata;
    }

    @Override // androidx.camera.camera2.pipe.RequestFailure
    public boolean getWasImageCaptured() {
        return this.wasImageCaptured;
    }

    @Override // androidx.camera.camera2.pipe.RequestFailure
    /* JADX INFO: renamed from: getFrameNumber-Ugla2oM */
    public long mo706getFrameNumberUgla2oM() {
        return this.frameNumber;
    }

    @Override // androidx.camera.camera2.pipe.RequestFailure
    public int getReason() {
        return this.reason;
    }
}
