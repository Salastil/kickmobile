package androidx.camera.camera2.impl;

import androidx.camera.core.imagecapture.CameraCapturePipeline;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.Deferred;

/* JADX INFO: compiled from: CapturePipeline.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JT\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n0\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003H¦@¢\u0006\u0004\b\u0015\u0010\u0016J&\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0019R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001aÀ\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/impl/CapturePipeline;", "", "template", "", "getTemplate", "()I", "setTemplate", "(I)V", "submitStillCaptures", "", "Lkotlinx/coroutines/Deferred;", "Ljava/lang/Void;", "configs", "Landroidx/camera/core/impl/CaptureConfig;", "requestTemplate", "Landroidx/camera/camera2/pipe/RequestTemplate;", "sessionConfigOptions", "Landroidx/camera/core/impl/Config;", "captureMode", "flashType", "flashMode", "submitStillCaptures-BvXKQx0", "(Ljava/util/List;ILandroidx/camera/core/impl/Config;IIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCameraCapturePipeline", "Landroidx/camera/core/imagecapture/CameraCapturePipeline;", "(IIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface CapturePipeline {
    Object getCameraCapturePipeline(int i, int i2, int i3, Continuation<? super CameraCapturePipeline> continuation);

    int getTemplate();

    void setTemplate(int i);

    /* JADX INFO: renamed from: submitStillCaptures-BvXKQx0 */
    Object mo75submitStillCapturesBvXKQx0(List<CaptureConfig> list, int i, Config config, int i2, int i3, int i4, Continuation<? super List<? extends Deferred<Void>>> continuation);
}
