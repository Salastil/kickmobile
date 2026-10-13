package androidx.camera.camera2.impl;

import androidx.camera.core.UseCase;
import androidx.camera.core.imagecapture.CameraCapturePipeline;
import com.facebook.react.uimanager.ViewProps;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: UseCaseCamera.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H&J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H&J\b\u0010\u0018\u001a\u00020\u0013H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0019À\u0006\u0003"}, d2 = {"Landroidx/camera/camera2/impl/UseCaseCamera;", "", "requestControl", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "getRequestControl", "()Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", ViewProps.START, "", "getCameraCapturePipeline", "Landroidx/camera/core/imagecapture/CameraCapturePipeline;", "captureMode", "", "flashMode", "flashType", "(IIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setActiveResumeMode", "enabled", "", "updateRepeatingRequestAsync", "Lkotlinx/coroutines/Job;", "isPrimary", "runningUseCases", "", "Landroidx/camera/core/UseCase;", "close", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface UseCaseCamera {
    Job close();

    Object getCameraCapturePipeline(int i, int i2, int i3, Continuation<? super CameraCapturePipeline> continuation);

    UseCaseCameraRequestControl getRequestControl();

    default void setActiveResumeMode(boolean enabled) {
    }

    void start();

    Job updateRepeatingRequestAsync(boolean isPrimary, Collection<? extends UseCase> runningUseCases);

    /* JADX INFO: compiled from: UseCaseCamera.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void setActiveResumeMode(UseCaseCamera useCaseCamera, boolean z) {
            UseCaseCamera.super.setActiveResumeMode(z);
        }
    }
}
