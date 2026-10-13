package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import androidx.camera.camera2.config.CameraAppComponent;
import androidx.camera.camera2.config.CameraConfig;
import androidx.camera.camera2.impl.Camera2Logger;
import androidx.camera.camera2.pipe.CameraDevices;
import androidx.camera.camera2.pipe.CameraId;
import androidx.camera.camera2.pipe.CameraMetadata;
import androidx.camera.camera2.pipe.DoNotDisturbException;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.InitializationException;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraFactory;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.internal.StreamSpecsCalculator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CameraSelectionOptimizer.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroidx/camera/camera2/internal/CameraSelectionOptimizer;", "", "<init>", "()V", "Companion", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraSelectionOptimizer {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: CameraSelectionOptimizer.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fJ4\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u000b\u001a\u00020\fJ!\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, d2 = {"Landroidx/camera/camera2/internal/CameraSelectionOptimizer$Companion;", "", "<init>", "()V", "getSelectedAvailableCameraIds", "", "", "cameraFactory", "Landroidx/camera/core/impl/CameraFactory;", "availableCamerasSelector", "Landroidx/camera/core/CameraSelector;", "streamSpecsCalculator", "Landroidx/camera/core/internal/StreamSpecsCalculator;", "cameraAppComponent", "Landroidx/camera/camera2/config/CameraAppComponent;", "cameraIdList", "decideSkippedCameraIdByHeuristic", "cameraDevices", "Landroidx/camera/camera2/pipe/CameraDevices;", "lensFacingInteger", "", "(Landroidx/camera/camera2/pipe/CameraDevices;Ljava/lang/Integer;)Ljava/lang/String;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<String> getSelectedAvailableCameraIds(CameraFactory cameraFactory, CameraSelector availableCamerasSelector, StreamSpecsCalculator streamSpecsCalculator) {
            Intrinsics.checkNotNullParameter(cameraFactory, "cameraFactory");
            Intrinsics.checkNotNullParameter(streamSpecsCalculator, "streamSpecsCalculator");
            Object cameraManager = cameraFactory.getCameraManager();
            Intrinsics.checkNotNull(cameraManager, "null cannot be cast to non-null type androidx.camera.camera2.config.CameraAppComponent");
            CameraAppComponent cameraAppComponent = (CameraAppComponent) cameraManager;
            List listM311awaitCameraIdsSeavPBo$default = CameraDevices.m311awaitCameraIdsSeavPBo$default(cameraAppComponent.getCameraDevices(), null, 1, null);
            if (listM311awaitCameraIdsSeavPBo$default == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            List list = listM311awaitCameraIdsSeavPBo$default;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((CameraId) it.next()).m433unboximpl());
            }
            return getSelectedAvailableCameraIds(cameraAppComponent, availableCamerasSelector, arrayList, streamSpecsCalculator);
        }

        public final List<String> getSelectedAvailableCameraIds(CameraAppComponent cameraAppComponent, CameraSelector availableCamerasSelector, List<String> cameraIdList, StreamSpecsCalculator streamSpecsCalculator) {
            String strDecideSkippedCameraIdByHeuristic;
            Intrinsics.checkNotNullParameter(cameraAppComponent, "cameraAppComponent");
            Intrinsics.checkNotNullParameter(cameraIdList, "cameraIdList");
            Intrinsics.checkNotNullParameter(streamSpecsCalculator, "streamSpecsCalculator");
            try {
                ArrayList arrayList = new ArrayList();
                CameraDevices cameraDevices = cameraAppComponent.getCameraDevices();
                if (availableCamerasSelector == null) {
                    return cameraIdList;
                }
                try {
                    strDecideSkippedCameraIdByHeuristic = decideSkippedCameraIdByHeuristic(cameraDevices, availableCamerasSelector.getLensFacing());
                } catch (IllegalStateException e) {
                    Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
                    IllegalStateException illegalStateException = e;
                    if (Logger.isDebugEnabled(Log.TAG)) {
                        android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "Unable to get Metadata for cameraID 0 and/or 1", illegalStateException);
                    }
                    strDecideSkippedCameraIdByHeuristic = null;
                }
                ArrayList arrayList2 = new ArrayList();
                for (String str : cameraIdList) {
                    if (!Intrinsics.areEqual(str, strDecideSkippedCameraIdByHeuristic)) {
                        CameraInfoInternal cameraInfo = cameraAppComponent.cameraBuilder().config(new CameraConfig(CameraId.m427constructorimpl(str), null)).streamSpecsCalculator(streamSpecsCalculator).build().getCameraInternal().getCameraInfo();
                        Intrinsics.checkNotNullExpressionValue(cameraInfo, "getCameraInfoInternal(...)");
                        arrayList2.add(cameraInfo);
                    }
                }
                List<CameraInfo> listFilter = availableCamerasSelector.filter(arrayList2);
                Intrinsics.checkNotNullExpressionValue(listFilter, "filter(...)");
                for (CameraInfo cameraInfo2 : listFilter) {
                    Intrinsics.checkNotNull(cameraInfo2, "null cannot be cast to non-null type androidx.camera.core.impl.CameraInfoInternal");
                    String cameraId = ((CameraInfoInternal) cameraInfo2).getCameraId();
                    Intrinsics.checkNotNullExpressionValue(cameraId, "getCameraId(...)");
                    arrayList.add(cameraId);
                }
                return arrayList;
            } catch (IllegalStateException e2) {
                Camera2Logger camera2Logger2 = Camera2Logger.INSTANCE;
                IllegalStateException illegalStateException2 = e2;
                if (Logger.isErrorEnabled(Log.TAG)) {
                    android.util.Log.e(Camera2Logger.TRUNCATED_TAG, "Error while accessing info about cameras.", illegalStateException2);
                }
                throw new InitializationException(illegalStateException2);
            }
        }

        private final String decideSkippedCameraIdByHeuristic(CameraDevices cameraDevices, Integer lensFacingInteger) {
            if (lensFacingInteger == null) {
                return null;
            }
            try {
                if (lensFacingInteger.intValue() == 1) {
                    CameraMetadata cameraMetadataM312awaitCameraMetadataFpsL5FU$default = CameraDevices.m312awaitCameraMetadataFpsL5FU$default(cameraDevices, CameraId.m427constructorimpl("0"), null, 2, null);
                    if (cameraMetadataM312awaitCameraMetadataFpsL5FU$default == null) {
                        throw new IllegalStateException("Required value was null.".toString());
                    }
                    CameraCharacteristics.Key LENS_FACING = CameraCharacteristics.LENS_FACING;
                    Intrinsics.checkNotNullExpressionValue(LENS_FACING, "LENS_FACING");
                    Integer num = (Integer) cameraMetadataM312awaitCameraMetadataFpsL5FU$default.get(LENS_FACING);
                    if (num != null && num.intValue() == 1) {
                        return "1";
                    }
                } else if (lensFacingInteger.intValue() == 0) {
                    CameraMetadata cameraMetadataM312awaitCameraMetadataFpsL5FU$default2 = CameraDevices.m312awaitCameraMetadataFpsL5FU$default(cameraDevices, CameraId.m427constructorimpl("1"), null, 2, null);
                    if (cameraMetadataM312awaitCameraMetadataFpsL5FU$default2 == null) {
                        throw new IllegalStateException("Required value was null.".toString());
                    }
                    CameraCharacteristics.Key LENS_FACING2 = CameraCharacteristics.LENS_FACING;
                    Intrinsics.checkNotNullExpressionValue(LENS_FACING2, "LENS_FACING");
                    Integer num2 = (Integer) cameraMetadataM312awaitCameraMetadataFpsL5FU$default2.get(LENS_FACING2);
                    if (num2 != null && num2.intValue() == 0) {
                        return "0";
                    }
                }
            } catch (DoNotDisturbException unused) {
                Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
                if (Logger.isErrorEnabled(Log.TAG)) {
                    android.util.Log.e(Camera2Logger.TRUNCATED_TAG, "Received Do Not Disturb exception while deciding camera id to skip. Please turn off Do Not Disturb mode");
                }
            }
            return null;
        }
    }
}
