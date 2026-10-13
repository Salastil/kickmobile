package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.camera2.impl.Camera2Logger;
import androidx.camera.camera2.pipe.CameraDevices;
import androidx.camera.camera2.pipe.CameraId;
import androidx.camera.camera2.pipe.CameraMetadata;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.core.InitializationException;
import androidx.camera.core.Logger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CameraCompatibilityFilter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\r"}, d2 = {"Landroidx/camera/camera2/internal/CameraCompatibilityFilter;", "", "<init>", "()V", "getBackwardCompatibleCameraIds", "", "", "cameraDevices", "Landroidx/camera/camera2/pipe/CameraDevices;", "availableCameraIds", "isBackwardCompatible", "", "cameraId", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraCompatibilityFilter {
    public static final CameraCompatibilityFilter INSTANCE = new CameraCompatibilityFilter();

    private CameraCompatibilityFilter() {
    }

    @JvmStatic
    public static final List<String> getBackwardCompatibleCameraIds(CameraDevices cameraDevices, List<String> availableCameraIds) {
        Intrinsics.checkNotNullParameter(cameraDevices, "cameraDevices");
        Intrinsics.checkNotNullParameter(availableCameraIds, "availableCameraIds");
        ArrayList arrayList = new ArrayList();
        for (String str : availableCameraIds) {
            if (Intrinsics.areEqual(str, "0") || Intrinsics.areEqual(str, "1")) {
                arrayList.add(str);
            } else if (isBackwardCompatible(str, cameraDevices)) {
                arrayList.add(str);
            } else {
                Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
                if (Logger.isDebugEnabled(Log.TAG)) {
                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "Camera " + str + " is filtered out because its capabilities do not contain REQUEST_AVAILABLE_CAPABILITIES_BACKWARD_COMPATIBLE.");
                }
            }
        }
        return arrayList;
    }

    @JvmStatic
    public static final boolean isBackwardCompatible(String cameraId, CameraDevices cameraDevices) throws InitializationException {
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        Intrinsics.checkNotNullParameter(cameraDevices, "cameraDevices");
        if (Intrinsics.areEqual(Build.FINGERPRINT, "robolectric")) {
            Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
            if (!Logger.isDebugEnabled(Log.TAG)) {
                return true;
            }
            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "isBackwardCompatible method returns true because robolectric build detected.");
            return true;
        }
        try {
            CameraMetadata cameraMetadataM312awaitCameraMetadataFpsL5FU$default = CameraDevices.m312awaitCameraMetadataFpsL5FU$default(cameraDevices, CameraId.m427constructorimpl(cameraId), null, 2, null);
            if (cameraMetadataM312awaitCameraMetadataFpsL5FU$default == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            CameraCharacteristics.Key REQUEST_AVAILABLE_CAPABILITIES = CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES;
            Intrinsics.checkNotNullExpressionValue(REQUEST_AVAILABLE_CAPABILITIES, "REQUEST_AVAILABLE_CAPABILITIES");
            int[] iArr = (int[]) cameraMetadataM312awaitCameraMetadataFpsL5FU$default.get(REQUEST_AVAILABLE_CAPABILITIES);
            if (iArr != null) {
                return ArraysKt.contains(iArr, 0);
            }
            return false;
        } catch (CameraAccessException e) {
            Camera2Logger camera2Logger2 = Camera2Logger.INSTANCE;
            CameraAccessException cameraAccessException = e;
            if (Logger.isErrorEnabled(Log.TAG)) {
                android.util.Log.e(Camera2Logger.TRUNCATED_TAG, "Error while accessing metadata for cameraID: " + cameraId, cameraAccessException);
            }
            throw new InitializationException(cameraAccessException);
        }
    }
}
