package androidx.camera.camera2.pipe;

import java.util.List;

/* JADX INFO: compiled from: CaptureSequence.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\bg\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0001\u001fR\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000eR\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000eR\u0012\u0010\u0015\u001a\u00020\u0016X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0019\u001a\u00020\u001aX¦\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006 À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/CaptureSequence;", "TCaptureRequest", "", "cameraId", "Landroidx/camera/camera2/pipe/CameraId;", "getCameraId-Dz_R5H8", "()Ljava/lang/String;", "repeating", "", "getRepeating", "()Z", "captureRequestList", "", "getCaptureRequestList", "()Ljava/util/List;", "captureMetadataList", "Landroidx/camera/camera2/pipe/RequestMetadata;", "getCaptureMetadataList", "listeners", "Landroidx/camera/camera2/pipe/Request$Listener;", "getListeners", "sequenceListener", "Landroidx/camera/camera2/pipe/CaptureSequence$CaptureSequenceListener;", "getSequenceListener", "()Landroidx/camera/camera2/pipe/CaptureSequence$CaptureSequenceListener;", "sequenceNumber", "", "getSequenceNumber", "()I", "setSequenceNumber", "(I)V", "CaptureSequenceListener", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface CaptureSequence<TCaptureRequest> {

    /* JADX INFO: compiled from: CaptureSequence.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/CaptureSequence$CaptureSequenceListener;", "", "onCaptureSequenceComplete", "", "captureSequence", "Landroidx/camera/camera2/pipe/CaptureSequence;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface CaptureSequenceListener {
        void onCaptureSequenceComplete(CaptureSequence<?> captureSequence);
    }

    /* JADX INFO: renamed from: getCameraId-Dz_R5H8, reason: not valid java name */
    String mo468getCameraIdDz_R5H8();

    List<RequestMetadata> getCaptureMetadataList();

    List<TCaptureRequest> getCaptureRequestList();

    List<Request.Listener> getListeners();

    boolean getRepeating();

    CaptureSequenceListener getSequenceListener();

    int getSequenceNumber();

    void setSequenceNumber(int i);
}
