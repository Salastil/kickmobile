package androidx.camera.camera2.adapter;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import android.util.Size;
import androidx.camera.camera2.compat.StreamConfigurationMapCompat;
import androidx.camera.camera2.compat.quirk.CameraQuirks;
import androidx.camera.camera2.compat.workaround.OutputSizesCorrector;
import androidx.camera.camera2.config.CameraAppComponent;
import androidx.camera.camera2.config.CameraModule;
import androidx.camera.camera2.impl.Camera2Logger;
import androidx.camera.camera2.impl.FeatureCombinationQueryImpl;
import androidx.camera.camera2.pipe.CameraDevices;
import androidx.camera.camera2.pipe.CameraId;
import androidx.camera.camera2.pipe.CameraMetadata;
import androidx.camera.camera2.pipe.DoNotDisturbException;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.core.InitializationException;
import androidx.camera.core.Logger;
import androidx.camera.core.featuregroup.impl.FeatureCombinationQuery;
import androidx.camera.core.impl.AttachedSurfaceInfo;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.CameraUpdateException;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.core.impl.StreamUseCase;
import androidx.camera.core.impl.SurfaceConfig;
import androidx.camera.core.impl.SurfaceStreamSpecQueryResult;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.stabilization.VideoStabilization;
import androidx.core.util.Preconditions;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.datadog.trace.bootstrap.instrumentation.api.Tags;
import io.ktor.http.ContentDisposition;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CameraSurfaceAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0014H\u0016J\"\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0014H\u0002J0\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0015\u0010!\u001a\u00020\"2\u0006\u0010\u001b\u001a\u00020\bH\u0001¢\u0006\u0002\b#Jd\u0010$\u001a\u00020%2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\b2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u00142\u001c\u0010(\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030)\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00140\u000f2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\"2\u0006\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020\"H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Landroidx/camera/camera2/adapter/CameraSurfaceAdapter;", "Landroidx/camera/core/impl/CameraDeviceSurfaceManager;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "cameraComponent", "", "availableCameraIds", "", "", "<init>", "(Landroid/content/Context;Ljava/lang/Object;Ljava/util/Set;)V", Tags.COMPONENT, "Landroidx/camera/camera2/config/CameraAppComponent;", "lock", "supportedSurfaceCombinationMap", "", "Landroidx/camera/camera2/adapter/SupportedSurfaceCombination;", "onCamerasUpdated", "", "cameraIds", "", "buildSurfaceCombinations", "cameraIdsToBuild", "transformSurfaceConfig", "Landroidx/camera/core/impl/SurfaceConfig;", "cameraMode", "", "cameraId", "imageFormat", ContentDisposition.Parameters.Size, "Landroid/util/Size;", "streamUseCase", "Landroidx/camera/core/impl/StreamUseCase;", "checkIfSupportedCombinationExist", "", "checkIfSupportedCombinationExist$camera_camera2", "getSuggestedStreamSpecs", "Landroidx/camera/core/impl/SurfaceStreamSpecQueryResult;", "existingSurfaces", "Landroidx/camera/core/impl/AttachedSurfaceInfo;", "newUseCaseConfigsSupportedSizeMap", "Landroidx/camera/core/impl/UseCaseConfig;", "videoStabilization", "Landroidx/camera/core/impl/stabilization/VideoStabilization;", "hasVideoCapture", "isFeatureComboInvocation", "findMaxSupportedFrameRate", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraSurfaceAdapter implements CameraDeviceSurfaceManager {
    private final CameraAppComponent component;
    private final Context context;
    private final Object lock;
    private Map<String, SupportedSurfaceCombination> supportedSurfaceCombinationMap;

    public CameraSurfaceAdapter(Context context, Object obj, Set<String> availableCameraIds) throws InitializationException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(availableCameraIds, "availableCameraIds");
        this.context = context;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.camera.camera2.config.CameraAppComponent");
        this.component = (CameraAppComponent) obj;
        this.lock = new Object();
        this.supportedSurfaceCombinationMap = MapsKt.emptyMap();
        try {
            onCamerasUpdated(CollectionsKt.toList(availableCameraIds));
        } catch (CameraUpdateException e) {
            throw new InitializationException(e);
        }
    }

    @Override // androidx.camera.core.impl.InternalCameraPresenceListener
    public void onCamerasUpdated(List<String> cameraIds) throws CameraUpdateException {
        List<String> listMinus;
        Intrinsics.checkNotNullParameter(cameraIds, "cameraIds");
        synchronized (this.lock) {
            listMinus = CollectionsKt.minus((Iterable) cameraIds, (Iterable) this.supportedSurfaceCombinationMap.keySet());
            Unit unit = Unit.INSTANCE;
        }
        if (!listMinus.isEmpty()) {
            Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "Creating new surface combinations for: " + listMinus);
            }
        }
        Map<String, SupportedSurfaceCombination> mapBuildSurfaceCombinations = buildSurfaceCombinations(listMinus);
        synchronized (this.lock) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (String str : cameraIds) {
                if (this.supportedSurfaceCombinationMap.containsKey(str)) {
                    SupportedSurfaceCombination supportedSurfaceCombination = this.supportedSurfaceCombinationMap.get(str);
                    Intrinsics.checkNotNull(supportedSurfaceCombination);
                    linkedHashMap.put(str, supportedSurfaceCombination);
                }
            }
            linkedHashMap.putAll(mapBuildSurfaceCombinations);
            this.supportedSurfaceCombinationMap = linkedHashMap;
            Camera2Logger camera2Logger2 = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "Committed new surface combination map. Total cameras: " + linkedHashMap.size());
            }
            Unit unit2 = Unit.INSTANCE;
        }
    }

    private final Map<String, SupportedSurfaceCombination> buildSurfaceCombinations(List<String> cameraIdsToBuild) throws CameraUpdateException {
        FeatureCombinationQueryImpl featureCombinationQueryImpl;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (!cameraIdsToBuild.isEmpty()) {
            try {
                for (String str : cameraIdsToBuild) {
                    CameraMetadata cameraMetadataM312awaitCameraMetadataFpsL5FU$default = CameraDevices.m312awaitCameraMetadataFpsL5FU$default(this.component.getCameraDevices(), CameraId.m427constructorimpl(str), null, 2, null);
                    if (cameraMetadataM312awaitCameraMetadataFpsL5FU$default != null) {
                        CameraCharacteristics.Key SCALER_STREAM_CONFIGURATION_MAP = CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP;
                        Intrinsics.checkNotNullExpressionValue(SCALER_STREAM_CONFIGURATION_MAP, "SCALER_STREAM_CONFIGURATION_MAP");
                        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraMetadataM312awaitCameraMetadataFpsL5FU$default.get(SCALER_STREAM_CONFIGURATION_MAP);
                        CameraQuirks cameraQuirks = new CameraQuirks(cameraMetadataM312awaitCameraMetadataFpsL5FU$default, new StreamConfigurationMapCompat(streamConfigurationMap, new OutputSizesCorrector(cameraMetadataM312awaitCameraMetadataFpsL5FU$default, streamConfigurationMap)));
                        Context context = this.context;
                        EncoderProfilesProvider encoderProfilesProviderProvideEncoderProfilesProvider = CameraModule.INSTANCE.provideEncoderProfilesProvider(str, cameraQuirks);
                        if (Build.VERSION.SDK_INT >= 35) {
                            featureCombinationQueryImpl = new FeatureCombinationQueryImpl(cameraMetadataM312awaitCameraMetadataFpsL5FU$default, this.component.getCameraPipe(), cameraQuirks);
                        } else {
                            featureCombinationQueryImpl = FeatureCombinationQuery.NO_OP_FEATURE_COMBINATION_QUERY;
                        }
                        linkedHashMap.put(str, new SupportedSurfaceCombination(context, cameraMetadataM312awaitCameraMetadataFpsL5FU$default, encoderProfilesProviderProvideEncoderProfilesProvider, featureCombinationQueryImpl));
                    }
                }
            } catch (DoNotDisturbException e) {
                throw new CameraUpdateException("Failed to query camera metadata", e);
            } catch (Exception e2) {
                throw new CameraUpdateException("Failed to build surface combinations", e2);
            }
        }
        return linkedHashMap;
    }

    @Override // androidx.camera.core.impl.CameraDeviceSurfaceManager
    public SurfaceConfig transformSurfaceConfig(int cameraMode, String cameraId, int imageFormat, Size size, StreamUseCase streamUseCase) {
        SupportedSurfaceCombination supportedSurfaceCombination;
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(streamUseCase, "streamUseCase");
        Preconditions.checkArgument(checkIfSupportedCombinationExist$camera_camera2(cameraId), "No such camera id in supported combination list: " + cameraId);
        synchronized (this.lock) {
            supportedSurfaceCombination = this.supportedSurfaceCombinationMap.get(cameraId);
        }
        if (supportedSurfaceCombination == null) {
            throw new IllegalArgumentException("No such camera id in supported combination list: " + cameraId);
        }
        return supportedSurfaceCombination.transformSurfaceConfig(cameraMode, imageFormat, size, streamUseCase);
    }

    public final boolean checkIfSupportedCombinationExist$camera_camera2(String cameraId) {
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        return this.supportedSurfaceCombinationMap.containsKey(cameraId);
    }

    @Override // androidx.camera.core.impl.CameraDeviceSurfaceManager
    public SurfaceStreamSpecQueryResult getSuggestedStreamSpecs(int cameraMode, String cameraId, List<? extends AttachedSurfaceInfo> existingSurfaces, Map<UseCaseConfig<?>, ? extends List<Size>> newUseCaseConfigsSupportedSizeMap, VideoStabilization videoStabilization, boolean hasVideoCapture, boolean isFeatureComboInvocation, boolean findMaxSupportedFrameRate) {
        SupportedSurfaceCombination supportedSurfaceCombination;
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        Intrinsics.checkNotNullParameter(existingSurfaces, "existingSurfaces");
        Intrinsics.checkNotNullParameter(newUseCaseConfigsSupportedSizeMap, "newUseCaseConfigsSupportedSizeMap");
        Intrinsics.checkNotNullParameter(videoStabilization, "videoStabilization");
        Preconditions.checkArgument(checkIfSupportedCombinationExist$camera_camera2(cameraId), "No such camera id in supported combination list: " + cameraId);
        synchronized (this.lock) {
            supportedSurfaceCombination = this.supportedSurfaceCombinationMap.get(cameraId);
        }
        if (supportedSurfaceCombination == null) {
            throw new IllegalArgumentException("No such camera id in supported combination list: " + cameraId);
        }
        return supportedSurfaceCombination.getSuggestedStreamSpecifications(cameraMode, existingSurfaces, newUseCaseConfigsSupportedSizeMap, videoStabilization, hasVideoCapture, isFeatureComboInvocation, findMaxSupportedFrameRate);
    }
}
