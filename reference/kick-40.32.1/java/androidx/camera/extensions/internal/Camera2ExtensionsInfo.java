package androidx.camera.extensions.internal;

import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraExtensionCharacteristics;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.util.Size;
import androidx.camera.camera2.pipe.CameraColorSpace$$ExternalSyntheticApiModelOutline6;
import androidx.camera.core.Logger;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Camera2ExtensionsInfo.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\nH\u0017J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0010H\u0016J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\r2\u0006\u0010\u0012\u001a\u00020\nH\u0003J&\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0010H\u0016J \u0010\u0019\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\"\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\t8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\r0\t8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Landroidx/camera/extensions/internal/Camera2ExtensionsInfo;", "Landroidx/camera/extensions/internal/Camera2ExtensionsInfoProvider;", "cameraManager", "Landroid/hardware/camera2/CameraManager;", "<init>", "(Landroid/hardware/camera2/CameraManager;)V", "lock", "", "cachedCharacteristics", "", "", "Landroid/hardware/camera2/CameraExtensionCharacteristics;", "cachedSupportedOutputSizes", "", "Landroid/util/Size;", "cachedSupportedExtensions", "", "getExtensionCharacteristics", "cameraId", "isExtensionAvailable", "", "mode", "getSupportedExtensions", "getSupportedOutputSizes", "format", "getCachedOutputSizesKey", "Companion", "camera-extensions"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Camera2ExtensionsInfo implements Camera2ExtensionsInfoProvider {
    private static final Companion Companion = new Companion(null);
    private static final String TAG = "Camera2ExtensionsInfo";
    private final Map<String, CameraExtensionCharacteristics> cachedCharacteristics;
    private final Map<String, List<Integer>> cachedSupportedExtensions;
    private final Map<String, List<Size>> cachedSupportedOutputSizes;
    private final CameraManager cameraManager;
    private final Object lock;

    public Camera2ExtensionsInfo(CameraManager cameraManager) {
        Intrinsics.checkNotNullParameter(cameraManager, "cameraManager");
        this.cameraManager = cameraManager;
        this.lock = new Object();
        this.cachedCharacteristics = new LinkedHashMap();
        this.cachedSupportedOutputSizes = new LinkedHashMap();
        this.cachedSupportedExtensions = new LinkedHashMap();
    }

    @Override // androidx.camera.extensions.internal.Camera2ExtensionsInfoProvider
    public CameraExtensionCharacteristics getExtensionCharacteristics(String cameraId) {
        CameraExtensionCharacteristics cameraExtensionCharacteristicsM255m;
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        synchronized (this.lock) {
            cameraExtensionCharacteristicsM255m = CameraColorSpace$$ExternalSyntheticApiModelOutline6.m255m((Object) this.cachedCharacteristics.get(cameraId));
            if (cameraExtensionCharacteristicsM255m == null) {
                cameraExtensionCharacteristicsM255m = this.cameraManager.getCameraExtensionCharacteristics(cameraId);
                this.cachedCharacteristics.put(cameraId, cameraExtensionCharacteristicsM255m);
                Intrinsics.checkNotNullExpressionValue(cameraExtensionCharacteristicsM255m, "also(...)");
            }
        }
        return cameraExtensionCharacteristicsM255m;
    }

    @Override // androidx.camera.extensions.internal.Camera2ExtensionsInfoProvider
    public boolean isExtensionAvailable(String cameraId, int mode) {
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        if (Build.VERSION.SDK_INT < 31) {
            return false;
        }
        return getSupportedExtensions(cameraId).contains(Integer.valueOf(mode));
    }

    private final List<Integer> getSupportedExtensions(String cameraId) {
        List<Integer> supportedExtensions;
        synchronized (this.lock) {
            supportedExtensions = this.cachedSupportedExtensions.get(cameraId);
            if (supportedExtensions == null) {
                supportedExtensions = getExtensionCharacteristics(cameraId).getSupportedExtensions();
                this.cachedSupportedExtensions.put(cameraId, supportedExtensions);
                Intrinsics.checkNotNullExpressionValue(supportedExtensions, "also(...)");
            }
        }
        return supportedExtensions;
    }

    @Override // androidx.camera.extensions.internal.Camera2ExtensionsInfoProvider
    public List<Size> getSupportedOutputSizes(String cameraId, int mode, int format) {
        List<Size> list;
        List<Size> extensionSupportedSizes;
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        if (Build.VERSION.SDK_INT < 31) {
            return CollectionsKt.emptyList();
        }
        String cachedOutputSizesKey = getCachedOutputSizesKey(cameraId, mode, format);
        synchronized (this.lock) {
            list = this.cachedSupportedOutputSizes.get(cachedOutputSizesKey);
        }
        if (list != null) {
            return list;
        }
        try {
            if (format == 34) {
                extensionSupportedSizes = getExtensionCharacteristics(cameraId).getExtensionSupportedSizes(mode, SurfaceTexture.class);
            } else {
                extensionSupportedSizes = getExtensionCharacteristics(cameraId).getExtensionSupportedSizes(mode, format);
            }
            synchronized (this.lock) {
                this.cachedSupportedOutputSizes.put(cachedOutputSizesKey, extensionSupportedSizes);
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(extensionSupportedSizes);
            return extensionSupportedSizes;
        } catch (IllegalArgumentException e) {
            Logger.e(TAG, "Failed to retrieve supported output sizes for camera " + cameraId + ", mode " + mode + ", format " + format, e);
            return CollectionsKt.emptyList();
        }
    }

    private final String getCachedOutputSizesKey(String cameraId, int mode, int format) {
        return cameraId + '-' + mode + '-' + format;
    }

    /* JADX INFO: compiled from: Camera2ExtensionsInfo.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/camera/extensions/internal/Camera2ExtensionsInfo$Companion;", "", "<init>", "()V", "TAG", "", "camera-extensions"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
