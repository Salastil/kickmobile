package androidx.camera.camera2.pipe;

import android.hardware.camera2.params.MultiResolutionStreamInfo;
import java.util.List;

/* JADX INFO: compiled from: CameraMultiResolutionStreamConfigurationMap.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00032\u0006\u0010\b\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00032\u0006\u0010\b\u001a\u00020\u0004H&¢\u0006\u0004\b\f\u0010\nJ\u0017\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000f\u0010\u0010ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/CameraMultiResolutionStreamConfigurationMap;", "Landroidx/camera/camera2/pipe/UnsafeWrapper;", "getOutputFormats", "", "Landroidx/camera/camera2/pipe/StreamFormat;", "getInputFormats", "getOutputInfo", "Landroid/hardware/camera2/params/MultiResolutionStreamInfo;", "format", "getOutputInfo-hNQ4ISI", "(I)Ljava/util/List;", "getInputInfo", "getInputInfo-hNQ4ISI", "isConcurrentReadersSupported", "", "isConcurrentReadersSupported-hNQ4ISI", "(I)Z", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface CameraMultiResolutionStreamConfigurationMap extends UnsafeWrapper {
    List<StreamFormat> getInputFormats();

    /* JADX INFO: renamed from: getInputInfo-hNQ4ISI, reason: not valid java name */
    List<MultiResolutionStreamInfo> mo447getInputInfohNQ4ISI(int format);

    List<StreamFormat> getOutputFormats();

    /* JADX INFO: renamed from: getOutputInfo-hNQ4ISI, reason: not valid java name */
    List<MultiResolutionStreamInfo> mo448getOutputInfohNQ4ISI(int format);

    /* JADX INFO: renamed from: isConcurrentReadersSupported-hNQ4ISI, reason: not valid java name */
    boolean mo449isConcurrentReadersSupportedhNQ4ISI(int format);
}
