package androidx.camera.camera2.pipe;

/* JADX INFO: compiled from: Frames.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\bH¦\u0002¢\u0006\u0004\b\t\u0010\nR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\r\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0015À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/FrameInfo;", "Landroidx/camera/camera2/pipe/UnsafeWrapper;", "metadata", "Landroidx/camera/camera2/pipe/FrameMetadata;", "getMetadata", "()Landroidx/camera/camera2/pipe/FrameMetadata;", "get", "camera", "Landroidx/camera/camera2/pipe/CameraId;", "get-EfqyGwQ", "(Ljava/lang/String;)Landroidx/camera/camera2/pipe/FrameMetadata;", "getCamera-Dz_R5H8", "()Ljava/lang/String;", "frameNumber", "Landroidx/camera/camera2/pipe/FrameNumber;", "getFrameNumber-Ugla2oM", "()J", "requestMetadata", "Landroidx/camera/camera2/pipe/RequestMetadata;", "getRequestMetadata", "()Landroidx/camera/camera2/pipe/RequestMetadata;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface FrameInfo extends UnsafeWrapper {
    /* JADX INFO: renamed from: get-EfqyGwQ */
    FrameMetadata mo107getEfqyGwQ(String camera);

    /* JADX INFO: renamed from: getCamera-Dz_R5H8 */
    String mo108getCameraDz_R5H8();

    /* JADX INFO: renamed from: getFrameNumber-Ugla2oM */
    long mo109getFrameNumberUgla2oM();

    FrameMetadata getMetadata();

    RequestMetadata getRequestMetadata();
}
