package androidx.camera.camera2.adapter;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.InputConfiguration;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Size;
import android.view.Surface;
import androidx.camera.camera2.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.compat.quirk.ZslDisablerQuirk;
import androidx.camera.camera2.config.CameraScope;
import androidx.camera.camera2.impl.Camera2Logger;
import androidx.camera.camera2.impl.CameraProperties;
import androidx.camera.camera2.impl.SizesKt;
import androidx.camera.camera2.pipe.CameraMetadata;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.MetadataImageReader;
import androidx.camera.core.SafeCloseImageReaderProxy;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.internal.utils.RingBuffer;
import androidx.camera.core.internal.utils.ZslRingBuffer;
import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ZslControl.kt */
/* JADX INFO: loaded from: classes.dex */
@CameraScope
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 42\u00020\u0001:\u00014B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\u0018\u0010'\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020\u0015H\u0016J\b\u0010-\u001a\u00020\u0015H\u0016J\u0010\u0010.\u001a\u00020$2\u0006\u0010,\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\n\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00101\u001a\u00020$H\u0016J\b\u00102\u001a\u00020$H\u0002J\b\u00103\u001a\u00020$H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u000e\u001a\u00020\u000f8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Landroidx/camera/camera2/adapter/ZslControlImpl;", "Landroidx/camera/camera2/adapter/ZslControl;", "cameraProperties", "Landroidx/camera/camera2/impl/CameraProperties;", "<init>", "(Landroidx/camera/camera2/impl/CameraProperties;)V", "cameraMetadata", "Landroidx/camera/camera2/pipe/CameraMetadata;", "streamConfigurationMap", "Landroid/hardware/camera2/params/StreamConfigurationMap;", "getStreamConfigurationMap", "()Landroid/hardware/camera2/params/StreamConfigurationMap;", "streamConfigurationMap$delegate", "Lkotlin/Lazy;", "zslRingBuffer", "Landroidx/camera/core/internal/utils/ZslRingBuffer;", "getZslRingBuffer$camera_camera2$annotations", "()V", "getZslRingBuffer$camera_camera2", "()Landroidx/camera/core/internal/utils/ZslRingBuffer;", "isZslDisabledByUseCaseConfig", "", "isZslDisabledByFlashMode", "isZslDisabledByQuirks", "reprocessingImageReader", "Landroidx/camera/core/SafeCloseImageReaderProxy;", "getReprocessingImageReader$camera_camera2$annotations", "getReprocessingImageReader$camera_camera2", "()Landroidx/camera/core/SafeCloseImageReaderProxy;", "setReprocessingImageReader$camera_camera2", "(Landroidx/camera/core/SafeCloseImageReaderProxy;)V", "metadataMatchingCaptureCallback", "Landroidx/camera/core/impl/CameraCaptureCallback;", "reprocessingImageDeferrableSurface", "Landroidx/camera/core/impl/DeferrableSurface;", "addZslConfig", "", "sessionConfigBuilder", "Landroidx/camera/core/impl/SessionConfig$Builder;", "isZslSurface", "surface", "sessionConfig", "Landroidx/camera/core/impl/SessionConfig;", "setZslDisabledByUserCaseConfig", "disabled", "isZslDisabledByUserCaseConfig", "setZslDisabledByFlashMode", "dequeueImageFromBuffer", "Landroidx/camera/core/ImageProxy;", "clearZslConfig", "reset", "clearRingBuffer", "Companion", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ZslControlImpl implements ZslControl {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int FORMAT = 34;
    public static final int MAX_IMAGES = 9;
    public static final int RING_BUFFER_CAPACITY = 3;
    private final CameraMetadata cameraMetadata;
    private final CameraProperties cameraProperties;
    private boolean isZslDisabledByFlashMode;
    private boolean isZslDisabledByQuirks;
    private boolean isZslDisabledByUseCaseConfig;
    private CameraCaptureCallback metadataMatchingCaptureCallback;
    private DeferrableSurface reprocessingImageDeferrableSurface;
    private SafeCloseImageReaderProxy reprocessingImageReader;

    /* JADX INFO: renamed from: streamConfigurationMap$delegate, reason: from kotlin metadata */
    private final Lazy streamConfigurationMap;
    private final ZslRingBuffer zslRingBuffer;

    public static /* synthetic */ void getReprocessingImageReader$camera_camera2$annotations() {
    }

    public static /* synthetic */ void getZslRingBuffer$camera_camera2$annotations() {
    }

    @Inject
    public ZslControlImpl(CameraProperties cameraProperties) {
        Intrinsics.checkNotNullParameter(cameraProperties, "cameraProperties");
        this.cameraProperties = cameraProperties;
        this.cameraMetadata = cameraProperties.getMetadata();
        this.streamConfigurationMap = LazyKt.lazy(new Function0() { // from class: androidx.camera.camera2.adapter.ZslControlImpl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ZslControlImpl.streamConfigurationMap_delegate$lambda$0(this.f$0);
            }
        });
        this.zslRingBuffer = new ZslRingBuffer(3, new RingBuffer.OnRemoveCallback() { // from class: androidx.camera.camera2.adapter.ZslControlImpl$$ExternalSyntheticLambda1
            @Override // androidx.camera.core.internal.utils.RingBuffer.OnRemoveCallback
            public final void onRemove(Object obj) {
                ZslControlImpl.zslRingBuffer$lambda$0((ImageProxy) obj);
            }
        });
        this.isZslDisabledByQuirks = DeviceQuirks.INSTANCE.get(ZslDisablerQuirk.class) != null;
    }

    private final StreamConfigurationMap getStreamConfigurationMap() {
        return (StreamConfigurationMap) this.streamConfigurationMap.getValue();
    }

    static final StreamConfigurationMap streamConfigurationMap_delegate$lambda$0(ZslControlImpl zslControlImpl) {
        CameraMetadata cameraMetadata = zslControlImpl.cameraMetadata;
        CameraCharacteristics.Key SCALER_STREAM_CONFIGURATION_MAP = CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP;
        Intrinsics.checkNotNullExpressionValue(SCALER_STREAM_CONFIGURATION_MAP, "SCALER_STREAM_CONFIGURATION_MAP");
        Object obj = cameraMetadata.get((CameraCharacteristics.Key<Object>) SCALER_STREAM_CONFIGURATION_MAP);
        if (obj != null) {
            return (StreamConfigurationMap) obj;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    /* JADX INFO: renamed from: getZslRingBuffer$camera_camera2, reason: from getter */
    public final ZslRingBuffer getZslRingBuffer() {
        return this.zslRingBuffer;
    }

    static final void zslRingBuffer$lambda$0(ImageProxy imageProxy) {
        Intrinsics.checkNotNullParameter(imageProxy, "imageProxy");
        imageProxy.close();
    }

    /* JADX INFO: renamed from: getReprocessingImageReader$camera_camera2, reason: from getter */
    public final SafeCloseImageReaderProxy getReprocessingImageReader() {
        return this.reprocessingImageReader;
    }

    public final void setReprocessingImageReader$camera_camera2(SafeCloseImageReaderProxy safeCloseImageReaderProxy) {
        this.reprocessingImageReader = safeCloseImageReaderProxy;
    }

    @Override // androidx.camera.camera2.adapter.ZslControl
    public void addZslConfig(SessionConfig.Builder sessionConfigBuilder) {
        Intrinsics.checkNotNullParameter(sessionConfigBuilder, "sessionConfigBuilder");
        reset();
        if (this.isZslDisabledByUseCaseConfig) {
            sessionConfigBuilder.setTemplateType(1);
            return;
        }
        if (this.isZslDisabledByQuirks) {
            sessionConfigBuilder.setTemplateType(1);
            return;
        }
        if (!CameraMetadata.INSTANCE.getSupportsPrivateReprocessing(this.cameraMetadata)) {
            Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
            if (Logger.isInfoEnabled(Log.TAG)) {
                android.util.Log.i(Camera2Logger.TRUNCATED_TAG, "ZslControlImpl: Private reprocessing isn't supported");
            }
            sessionConfigBuilder.setTemplateType(1);
            return;
        }
        Size[] inputSizes = getStreamConfigurationMap().getInputSizes(34);
        Intrinsics.checkNotNullExpressionValue(inputSizes, "getInputSizes(...)");
        Iterator it = ArraysKt.toList(inputSizes).iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Object next = it.next();
        if (it.hasNext()) {
            Size size = (Size) next;
            Intrinsics.checkNotNull(size);
            int iArea = SizesKt.area(size);
            do {
                Object next2 = it.next();
                Size size2 = (Size) next2;
                Intrinsics.checkNotNull(size2);
                int iArea2 = SizesKt.area(size2);
                if (iArea < iArea2) {
                    next = next2;
                    iArea = iArea2;
                }
            } while (it.hasNext());
        }
        Size size3 = (Size) next;
        if (size3 == null) {
            Camera2Logger camera2Logger2 = Camera2Logger.INSTANCE;
            if (Logger.isWarnEnabled(Log.TAG)) {
                android.util.Log.w(Camera2Logger.TRUNCATED_TAG, "ZslControlImpl: Unable to find a supported size for ZSL");
                return;
            }
            return;
        }
        Camera2Logger camera2Logger3 = Camera2Logger.INSTANCE;
        if (Logger.isDebugEnabled(Log.TAG)) {
            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "ZslControlImpl: Selected ZSL size: " + size3);
        }
        int[] validOutputFormatsForInput = getStreamConfigurationMap().getValidOutputFormatsForInput(34);
        Intrinsics.checkNotNullExpressionValue(validOutputFormatsForInput, "getValidOutputFormatsForInput(...)");
        if (!ArraysKt.contains(validOutputFormatsForInput, 256)) {
            Camera2Logger camera2Logger4 = Camera2Logger.INSTANCE;
            if (Logger.isWarnEnabled(Log.TAG)) {
                android.util.Log.w(Camera2Logger.TRUNCATED_TAG, "ZslControlImpl: JPEG isn't valid output for ZSL format");
                return;
            }
            return;
        }
        MetadataImageReader metadataImageReader = new MetadataImageReader(size3.getWidth(), size3.getHeight(), 34, 9);
        CameraCaptureCallback cameraCaptureCallback = metadataImageReader.getCameraCaptureCallback();
        Intrinsics.checkNotNullExpressionValue(cameraCaptureCallback, "getCameraCaptureCallback(...)");
        final SafeCloseImageReaderProxy safeCloseImageReaderProxy = new SafeCloseImageReaderProxy(metadataImageReader);
        metadataImageReader.setOnImageAvailableListener(new ImageReaderProxy.OnImageAvailableListener() { // from class: androidx.camera.camera2.adapter.ZslControlImpl$$ExternalSyntheticLambda2
            @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
            public final void onImageAvailable(ImageReaderProxy imageReaderProxy) {
                ZslControlImpl.addZslConfig$lambda$5(this.f$0, imageReaderProxy);
            }
        }, CameraXExecutors.ioExecutor());
        Surface surface = safeCloseImageReaderProxy.getSurface();
        if (surface == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        ImmediateSurface immediateSurface = new ImmediateSurface(surface, new Size(safeCloseImageReaderProxy.getWidth(), safeCloseImageReaderProxy.getHeight()), 34);
        immediateSurface.getTerminationFuture().addListener(new Runnable() { // from class: androidx.camera.camera2.adapter.ZslControlImpl$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                safeCloseImageReaderProxy.safeClose();
            }
        }, CameraXExecutors.mainThreadExecutor());
        ImmediateSurface immediateSurface2 = immediateSurface;
        sessionConfigBuilder.addSurface(immediateSurface2);
        sessionConfigBuilder.addCameraCaptureCallback(cameraCaptureCallback);
        sessionConfigBuilder.setInputConfiguration(new InputConfiguration(safeCloseImageReaderProxy.getWidth(), safeCloseImageReaderProxy.getHeight(), safeCloseImageReaderProxy.getImageFormat()));
        this.metadataMatchingCaptureCallback = cameraCaptureCallback;
        this.reprocessingImageReader = safeCloseImageReaderProxy;
        this.reprocessingImageDeferrableSurface = immediateSurface2;
    }

    static final void addZslConfig$lambda$5(ZslControlImpl zslControlImpl, ImageReaderProxy reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        try {
            ImageProxy imageProxyAcquireLatestImage = reader.acquireLatestImage();
            if (imageProxyAcquireLatestImage != null) {
                zslControlImpl.zslRingBuffer.enqueue(imageProxyAcquireLatestImage);
            }
        } catch (IllegalStateException unused) {
            Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
            if (Logger.isErrorEnabled(Log.TAG)) {
                android.util.Log.e(Camera2Logger.TRUNCATED_TAG, "Failed to acquire latest image");
            }
        }
    }

    @Override // androidx.camera.camera2.adapter.ZslControl
    public boolean isZslSurface(DeferrableSurface surface, SessionConfig sessionConfig) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        Intrinsics.checkNotNullParameter(sessionConfig, "sessionConfig");
        InputConfiguration inputConfiguration = sessionConfig.getInputConfiguration();
        return inputConfiguration != null && surface.getPrescribedStreamFormat() == inputConfiguration.getFormat() && surface.getPrescribedSize().getWidth() == inputConfiguration.getWidth() && surface.getPrescribedSize().getHeight() == inputConfiguration.getHeight();
    }

    @Override // androidx.camera.camera2.adapter.ZslControl
    public void setZslDisabledByUserCaseConfig(boolean disabled) {
        if (this.isZslDisabledByUseCaseConfig != disabled && disabled) {
            clearRingBuffer();
        }
        this.isZslDisabledByUseCaseConfig = disabled;
    }

    @Override // androidx.camera.camera2.adapter.ZslControl
    /* JADX INFO: renamed from: isZslDisabledByUserCaseConfig, reason: from getter */
    public boolean getIsZslDisabledByUseCaseConfig() {
        return this.isZslDisabledByUseCaseConfig;
    }

    @Override // androidx.camera.camera2.adapter.ZslControl
    public void setZslDisabledByFlashMode(boolean disabled) {
        this.isZslDisabledByFlashMode = disabled;
    }

    @Override // androidx.camera.camera2.adapter.ZslControl
    /* JADX INFO: renamed from: isZslDisabledByFlashMode, reason: from getter */
    public boolean getIsZslDisabledByFlashMode() {
        return this.isZslDisabledByFlashMode;
    }

    @Override // androidx.camera.camera2.adapter.ZslControl
    public ImageProxy dequeueImageFromBuffer() {
        try {
            return this.zslRingBuffer.dequeue();
        } catch (NoSuchElementException unused) {
            Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
            if (!Logger.isWarnEnabled(Log.TAG)) {
                return null;
            }
            android.util.Log.w(Camera2Logger.TRUNCATED_TAG, "ZslControlImpl#dequeueImageFromBuffer: No such element");
            return null;
        }
    }

    @Override // androidx.camera.camera2.adapter.ZslControl
    public void clearZslConfig() {
        reset();
    }

    private final void reset() {
        DeferrableSurface deferrableSurface = this.reprocessingImageDeferrableSurface;
        if (deferrableSurface != null) {
            final SafeCloseImageReaderProxy safeCloseImageReaderProxy = this.reprocessingImageReader;
            if (safeCloseImageReaderProxy != null) {
                deferrableSurface.getTerminationFuture().addListener(new Runnable() { // from class: androidx.camera.camera2.adapter.ZslControlImpl$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        safeCloseImageReaderProxy.safeClose();
                    }
                }, CameraXExecutors.mainThreadExecutor());
                safeCloseImageReaderProxy.clearOnImageAvailableListener();
                this.reprocessingImageReader = null;
            }
            deferrableSurface.close();
            this.reprocessingImageDeferrableSurface = null;
        }
        clearRingBuffer();
    }

    private final void clearRingBuffer() {
        ZslRingBuffer zslRingBuffer = this.zslRingBuffer;
        while (!zslRingBuffer.isEmpty()) {
            zslRingBuffer.dequeue().close();
        }
    }

    /* JADX INFO: compiled from: ZslControl.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u00020\u00058\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0003R\u0016\u0010\b\u001a\u00020\u00058\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\t\u0010\u0003¨\u0006\n"}, d2 = {"Landroidx/camera/camera2/adapter/ZslControlImpl$Companion;", "", "<init>", "()V", "FORMAT", "", "RING_BUFFER_CAPACITY", "getRING_BUFFER_CAPACITY$camera_camera2$annotations", "MAX_IMAGES", "getMAX_IMAGES$camera_camera2$annotations", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getMAX_IMAGES$camera_camera2$annotations() {
        }

        public static /* synthetic */ void getRING_BUFFER_CAPACITY$camera_camera2$annotations() {
        }

        private Companion() {
        }
    }
}
