package androidx.camera.camera2.pipe;

import androidx.camera.camera2.pipe.media.ImageWrapper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Requests.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Landroidx/camera/camera2/pipe/InputRequest;", "", "image", "Landroidx/camera/camera2/pipe/media/ImageWrapper;", "frameInfo", "Landroidx/camera/camera2/pipe/FrameInfo;", "<init>", "(Landroidx/camera/camera2/pipe/media/ImageWrapper;Landroidx/camera/camera2/pipe/FrameInfo;)V", "getImage", "()Landroidx/camera/camera2/pipe/media/ImageWrapper;", "getFrameInfo", "()Landroidx/camera/camera2/pipe/FrameInfo;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class InputRequest {
    private final FrameInfo frameInfo;
    private final ImageWrapper image;

    public static /* synthetic */ InputRequest copy$default(InputRequest inputRequest, ImageWrapper imageWrapper, FrameInfo frameInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            imageWrapper = inputRequest.image;
        }
        if ((i & 2) != 0) {
            frameInfo = inputRequest.frameInfo;
        }
        return inputRequest.copy(imageWrapper, frameInfo);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ImageWrapper getImage() {
        return this.image;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final FrameInfo getFrameInfo() {
        return this.frameInfo;
    }

    public final InputRequest copy(ImageWrapper image, FrameInfo frameInfo) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(frameInfo, "frameInfo");
        return new InputRequest(image, frameInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InputRequest)) {
            return false;
        }
        InputRequest inputRequest = (InputRequest) other;
        return Intrinsics.areEqual(this.image, inputRequest.image) && Intrinsics.areEqual(this.frameInfo, inputRequest.frameInfo);
    }

    public int hashCode() {
        return (this.image.hashCode() * 31) + this.frameInfo.hashCode();
    }

    public String toString() {
        return "InputRequest(image=" + this.image + ", frameInfo=" + this.frameInfo + ')';
    }

    public InputRequest(ImageWrapper image, FrameInfo frameInfo) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(frameInfo, "frameInfo");
        this.image = image;
        this.frameInfo = frameInfo;
    }

    public final FrameInfo getFrameInfo() {
        return this.frameInfo;
    }

    public final ImageWrapper getImage() {
        return this.image;
    }
}
