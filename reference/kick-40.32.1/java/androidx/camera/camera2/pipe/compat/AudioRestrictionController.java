package androidx.camera.camera2.pipe.compat;

import androidx.camera.camera2.pipe.AudioRestrictionMode;
import androidx.camera.camera2.pipe.CameraGraph;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;

/* JADX INFO: compiled from: AudioRestrictionController.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0014J\u001f\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H&¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H&R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0015À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/compat/AudioRestrictionController;", "", "globalAudioRestrictionMode", "Landroidx/camera/camera2/pipe/AudioRestrictionMode;", "getGlobalAudioRestrictionMode-4o0Og1A", "()Landroidx/camera/camera2/pipe/AudioRestrictionMode;", "setGlobalAudioRestrictionMode-3NUV5dA", "(Landroidx/camera/camera2/pipe/AudioRestrictionMode;)V", "updateCameraGraphAudioRestrictionMode", "", "cameraGraph", "Landroidx/camera/camera2/pipe/CameraGraph;", "mode", "updateCameraGraphAudioRestrictionMode-TyYSX5E", "(Landroidx/camera/camera2/pipe/CameraGraph;I)V", "removeCameraGraph", "addListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroidx/camera/camera2/pipe/compat/AudioRestrictionController$Listener;", "removeListener", "Listener", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface AudioRestrictionController {

    /* JADX INFO: compiled from: AudioRestrictionController.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/compat/AudioRestrictionController$Listener;", "", "onCameraAudioRestrictionUpdated", "", "mode", "Landroidx/camera/camera2/pipe/AudioRestrictionMode;", "onCameraAudioRestrictionUpdated-LwUUkyU", "(I)V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface Listener {
        /* JADX INFO: renamed from: onCameraAudioRestrictionUpdated-LwUUkyU */
        void mo803onCameraAudioRestrictionUpdatedLwUUkyU(int mode);
    }

    void addListener(Listener listener);

    /* JADX INFO: renamed from: getGlobalAudioRestrictionMode-4o0Og1A, reason: not valid java name */
    AudioRestrictionMode mo818getGlobalAudioRestrictionMode4o0Og1A();

    void removeCameraGraph(CameraGraph cameraGraph);

    void removeListener(Listener listener);

    /* JADX INFO: renamed from: setGlobalAudioRestrictionMode-3NUV5dA, reason: not valid java name */
    void mo819setGlobalAudioRestrictionMode3NUV5dA(AudioRestrictionMode audioRestrictionMode);

    /* JADX INFO: renamed from: updateCameraGraphAudioRestrictionMode-TyYSX5E, reason: not valid java name */
    void mo820updateCameraGraphAudioRestrictionModeTyYSX5E(CameraGraph cameraGraph, int mode);
}
