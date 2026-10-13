package androidx.camera.camera2.impl;

import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.DynamicRangeProfiles;
import android.media.MediaCodec;
import android.os.Build;
import android.util.Range;
import android.util.Size;
import android.view.SurfaceHolder;
import androidx.camera.camera2.adapter.GraphStateToCameraStateAdapter;
import androidx.camera.camera2.adapter.ZslControl;
import androidx.camera.camera2.compat.DynamicRangeProfilesCompat;
import androidx.camera.camera2.compat.quirk.CameraQuirks;
import androidx.camera.camera2.compat.quirk.CaptureSessionStuckQuirk;
import androidx.camera.camera2.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.compat.quirk.DisableAbortCapturesOnStopQuirk;
import androidx.camera.camera2.compat.quirk.DisableAbortCapturesOnStopWithSessionProcessorQuirk;
import androidx.camera.camera2.compat.quirk.FinalizeSessionOnCloseQuirk;
import androidx.camera.camera2.compat.quirk.QuickSuccessiveImageCaptureFailsRepeatingRequestQuirk;
import androidx.camera.camera2.compat.workaround.CloseCameraOnCameraGraphClose;
import androidx.camera.camera2.compat.workaround.TemplateParamsOverride;
import androidx.camera.camera2.config.CameraConfig;
import androidx.camera.camera2.config.CameraScope;
import androidx.camera.camera2.internal.DynamicRangeConversions;
import androidx.camera.camera2.interop.Camera2CaptureRequestConfigurator;
import androidx.camera.camera2.interop.Camera2CaptureRequestConfiguratorKt;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.CameraId;
import androidx.camera.camera2.pipe.CameraMetadata;
import androidx.camera.camera2.pipe.CameraStream;
import androidx.camera.camera2.pipe.ImageSourceConfig;
import androidx.camera.camera2.pipe.InputStream;
import androidx.camera.camera2.pipe.OutputStream;
import androidx.camera.camera2.pipe.Request;
import androidx.camera.camera2.pipe.RequestTemplate;
import androidx.camera.camera2.pipe.StreamFormat;
import androidx.camera.camera2.pipe.compat.CameraPipeKeys;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.TagBundle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

/* JADX INFO: compiled from: CameraGraphConfigProvider.kt */
/* JADX INFO: loaded from: classes.dex */
@CameraScope
@Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001IB[\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015Jk\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\u0014\b\u0002\u0010&\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)0'2\u0014\b\u0002\u0010*\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)0'¢\u0006\u0004\b+\u0010,J\u001c\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102H\u0002J5\u00103\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u00020(2\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)0'2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0002\b7J+\u00108\u001a\u0004\u0018\u0001092\u0006\u00105\u001a\u00020(2\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)0'H\u0002¢\u0006\u0002\b:J\u0018\u0010;\u001a\u00020<2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010=\u001a\u00020!H\u0002J\u0013\u0010>\u001a\u0004\u0018\u00010?*\u00020@H\u0002¢\u0006\u0002\bAJ\f\u0010B\u001a\u00020C*\u00020\u001fH\u0002J\u0017\u0010D\u001a\u0004\u0018\u00010%2\u0006\u0010E\u001a\u00020FH\u0002¢\u0006\u0002\u0010GJ\b\u0010H\u001a\u000202H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Landroidx/camera/camera2/impl/CameraGraphConfigProvider;", "", "callbackMap", "Landroidx/camera/camera2/impl/CameraCallbackMap;", "requestListener", "Landroidx/camera/camera2/impl/ComboRequestListener;", "cameraConfig", "Landroidx/camera/camera2/config/CameraConfig;", "cameraQuirks", "Landroidx/camera/camera2/compat/quirk/CameraQuirks;", "zslControl", "Landroidx/camera/camera2/adapter/ZslControl;", "templateParamsOverride", "Landroidx/camera/camera2/compat/workaround/TemplateParamsOverride;", "cameraMetadata", "Landroidx/camera/camera2/pipe/CameraMetadata;", "cameraXConfig", "Landroidx/camera/core/CameraXConfig;", "cameraInteropStateCallbackRepository", "Landroidx/camera/camera2/impl/CameraInteropStateCallbackRepository;", "<init>", "(Landroidx/camera/camera2/impl/CameraCallbackMap;Landroidx/camera/camera2/impl/ComboRequestListener;Landroidx/camera/camera2/config/CameraConfig;Landroidx/camera/camera2/compat/quirk/CameraQuirks;Landroidx/camera/camera2/adapter/ZslControl;Landroidx/camera/camera2/compat/workaround/TemplateParamsOverride;Landroidx/camera/camera2/pipe/CameraMetadata;Landroidx/camera/core/CameraXConfig;Landroidx/camera/camera2/impl/CameraInteropStateCallbackRepository;)V", "closeCameraOnCameraGraphClose", "Landroidx/camera/camera2/compat/workaround/CloseCameraOnCameraGraphClose;", "supportedDynamicRangeProfiles", "Landroid/hardware/camera2/params/DynamicRangeProfiles;", "create", "Landroidx/camera/camera2/impl/CameraGraphConfigProvider$CameraGraphCreationResult;", "operatingMode", "Landroidx/camera/camera2/pipe/CameraGraph$OperatingMode;", "sessionConfig", "Landroidx/camera/core/impl/SessionConfig;", "setOutputType", "", "graphStateToCameraStateAdapter", "Landroidx/camera/camera2/adapter/GraphStateToCameraStateAdapter;", "camera2ExtensionMode", "", "surfaceToStreamUseCaseMap", "", "Landroidx/camera/core/impl/DeferrableSurface;", "", "surfaceToStreamUseHintMap", "create-79VDu0o", "(ILandroidx/camera/core/impl/SessionConfig;ZLandroidx/camera/camera2/adapter/GraphStateToCameraStateAdapter;Ljava/lang/Integer;Ljava/util/Map;Ljava/util/Map;)Landroidx/camera/camera2/impl/CameraGraphConfigProvider$CameraGraphCreationResult;", "createPostviewStream", "Landroidx/camera/camera2/pipe/CameraStream$Config;", "postviewConfig", "Landroidx/camera/core/impl/SessionConfig$OutputConfig;", "physicalCameraIdForAllStreams", "", "getStreamUseCase", "Landroidx/camera/camera2/pipe/OutputStream$StreamUseCase;", "deferrableSurface", "mapping", "getStreamUseCase-MhLBY4I", "getStreamUseHint", "Landroidx/camera/camera2/pipe/OutputStream$StreamUseHint;", "getStreamUseHint-kVKJKLA", "createCameraGraphFlags", "Landroidx/camera/camera2/pipe/CameraGraph$Flags;", "isExtensions", "toDynamicRangeProfile", "Landroidx/camera/camera2/pipe/OutputStream$DynamicRangeProfile;", "Landroidx/camera/core/DynamicRange;", "toDynamicRangeProfile--zsJmt4", "toCamera2ImplConfig", "Landroidx/camera/camera2/impl/Camera2ImplConfig;", "getVideoStabilizationModeFromCaptureConfig", "captureConfig", "Landroidx/camera/core/impl/CaptureConfig;", "(Landroidx/camera/core/impl/CaptureConfig;)Ljava/lang/Integer;", "toString", "CameraGraphCreationResult", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraGraphConfigProvider {
    private final CameraCallbackMap callbackMap;
    private final CameraConfig cameraConfig;
    private final CameraInteropStateCallbackRepository cameraInteropStateCallbackRepository;
    private final CameraMetadata cameraMetadata;
    private final CameraQuirks cameraQuirks;
    private final CameraXConfig cameraXConfig;
    private final CloseCameraOnCameraGraphClose closeCameraOnCameraGraphClose;
    private final ComboRequestListener requestListener;
    private final DynamicRangeProfiles supportedDynamicRangeProfiles;
    private final TemplateParamsOverride templateParamsOverride;
    private final ZslControl zslControl;

    @Inject
    public CameraGraphConfigProvider(CameraCallbackMap callbackMap, ComboRequestListener requestListener, CameraConfig cameraConfig, CameraQuirks cameraQuirks, ZslControl zslControl, TemplateParamsOverride templateParamsOverride, CameraMetadata cameraMetadata, CameraXConfig cameraXConfig, CameraInteropStateCallbackRepository cameraInteropStateCallbackRepository) {
        DynamicRangeProfilesCompat dynamicRangeProfilesCompatFromCameraMetaData;
        Intrinsics.checkNotNullParameter(callbackMap, "callbackMap");
        Intrinsics.checkNotNullParameter(requestListener, "requestListener");
        Intrinsics.checkNotNullParameter(cameraConfig, "cameraConfig");
        Intrinsics.checkNotNullParameter(cameraQuirks, "cameraQuirks");
        Intrinsics.checkNotNullParameter(zslControl, "zslControl");
        Intrinsics.checkNotNullParameter(templateParamsOverride, "templateParamsOverride");
        this.callbackMap = callbackMap;
        this.requestListener = requestListener;
        this.cameraConfig = cameraConfig;
        this.cameraQuirks = cameraQuirks;
        this.zslControl = zslControl;
        this.templateParamsOverride = templateParamsOverride;
        this.cameraMetadata = cameraMetadata;
        this.cameraXConfig = cameraXConfig;
        this.cameraInteropStateCallbackRepository = cameraInteropStateCallbackRepository;
        this.closeCameraOnCameraGraphClose = new CloseCameraOnCameraGraphClose();
        DynamicRangeProfiles dynamicRangeProfiles = null;
        if (Build.VERSION.SDK_INT >= 33 && cameraMetadata != null && (dynamicRangeProfilesCompatFromCameraMetaData = DynamicRangeProfilesCompat.INSTANCE.fromCameraMetaData(cameraMetadata)) != null) {
            dynamicRangeProfiles = dynamicRangeProfilesCompatFromCameraMetaData.toDynamicRangeProfiles();
        }
        this.supportedDynamicRangeProfiles = dynamicRangeProfiles;
    }

    public /* synthetic */ CameraGraphConfigProvider(CameraCallbackMap cameraCallbackMap, ComboRequestListener comboRequestListener, CameraConfig cameraConfig, CameraQuirks cameraQuirks, ZslControl zslControl, TemplateParamsOverride templateParamsOverride, CameraMetadata cameraMetadata, CameraXConfig cameraXConfig, CameraInteropStateCallbackRepository cameraInteropStateCallbackRepository, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(cameraCallbackMap, comboRequestListener, cameraConfig, cameraQuirks, zslControl, templateParamsOverride, cameraMetadata, (i & 128) != 0 ? null : cameraXConfig, (i & 256) != 0 ? null : cameraInteropStateCallbackRepository);
    }

    /* JADX INFO: compiled from: CameraGraphConfigProvider.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005HÆ\u0001J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Landroidx/camera/camera2/impl/CameraGraphConfigProvider$CameraGraphCreationResult;", "", "config", "Landroidx/camera/camera2/pipe/CameraGraph$Config;", "streamConfigMap", "", "Landroidx/camera/camera2/pipe/CameraStream$Config;", "Landroidx/camera/core/impl/DeferrableSurface;", "<init>", "(Landroidx/camera/camera2/pipe/CameraGraph$Config;Ljava/util/Map;)V", "getConfig", "()Landroidx/camera/camera2/pipe/CameraGraph$Config;", "getStreamConfigMap", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class CameraGraphCreationResult {
        private final CameraGraph.Config config;
        private final Map<CameraStream.Config, DeferrableSurface> streamConfigMap;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CameraGraphCreationResult copy$default(CameraGraphCreationResult cameraGraphCreationResult, CameraGraph.Config config, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                config = cameraGraphCreationResult.config;
            }
            if ((i & 2) != 0) {
                map = cameraGraphCreationResult.streamConfigMap;
            }
            return cameraGraphCreationResult.copy(config, map);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final CameraGraph.Config getConfig() {
            return this.config;
        }

        public final Map<CameraStream.Config, DeferrableSurface> component2() {
            return this.streamConfigMap;
        }

        public final CameraGraphCreationResult copy(CameraGraph.Config config, Map<CameraStream.Config, ? extends DeferrableSurface> streamConfigMap) {
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(streamConfigMap, "streamConfigMap");
            return new CameraGraphCreationResult(config, streamConfigMap);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CameraGraphCreationResult)) {
                return false;
            }
            CameraGraphCreationResult cameraGraphCreationResult = (CameraGraphCreationResult) other;
            return Intrinsics.areEqual(this.config, cameraGraphCreationResult.config) && Intrinsics.areEqual(this.streamConfigMap, cameraGraphCreationResult.streamConfigMap);
        }

        public int hashCode() {
            return (this.config.hashCode() * 31) + this.streamConfigMap.hashCode();
        }

        public String toString() {
            return "CameraGraphCreationResult(config=" + this.config + ", streamConfigMap=" + this.streamConfigMap + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public CameraGraphCreationResult(CameraGraph.Config config, Map<CameraStream.Config, ? extends DeferrableSurface> streamConfigMap) {
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(streamConfigMap, "streamConfigMap");
            this.config = config;
            this.streamConfigMap = streamConfigMap;
        }

        public final CameraGraph.Config getConfig() {
            return this.config;
        }

        public final Map<CameraStream.Config, DeferrableSurface> getStreamConfigMap() {
            return this.streamConfigMap;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: create-79VDu0o$default, reason: not valid java name */
    public static /* synthetic */ CameraGraphCreationResult m88create79VDu0o$default(CameraGraphConfigProvider cameraGraphConfigProvider, int i, SessionConfig sessionConfig, boolean z, GraphStateToCameraStateAdapter graphStateToCameraStateAdapter, Integer num, Map map, Map map2, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            graphStateToCameraStateAdapter = null;
        }
        if ((i2 & 16) != 0) {
            num = null;
        }
        if ((i2 & 32) != 0) {
            map = MapsKt.emptyMap();
        }
        if ((i2 & 64) != 0) {
            map2 = MapsKt.emptyMap();
        }
        return cameraGraphConfigProvider.m92create79VDu0o(i, sessionConfig, z, graphStateToCameraStateAdapter, num, map, map2);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0115  */
    /* JADX WARN: Code duplicated, block: B:34:0x0125  */
    /* JADX WARN: Code duplicated, block: B:35:0x012c  */
    /* JADX WARN: Code duplicated, block: B:37:0x0134  */
    /* JADX WARN: Code duplicated, block: B:38:0x013b  */
    /* JADX WARN: Code duplicated, block: B:40:0x0143  */
    /* JADX WARN: Code duplicated, block: B:41:0x014a  */
    /* JADX WARN: Code duplicated, block: B:42:0x0151  */
    /* JADX WARN: Code duplicated, block: B:45:0x015b  */
    /* JADX WARN: Code duplicated, block: B:46:0x0164  */
    /* JADX WARN: Code duplicated, block: B:48:0x0168  */
    /* JADX WARN: Code duplicated, block: B:49:0x016f  */
    /* JADX WARN: Code duplicated, block: B:53:0x0198  */
    /* JADX WARN: Code duplicated, block: B:55:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:57:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:58:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:59:0x01de  */
    /* JADX WARN: Code duplicated, block: B:62:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:64:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:65:0x01fa  */
    /* JADX INFO: renamed from: create-79VDu0o, reason: not valid java name */
    public final CameraGraphCreationResult m92create79VDu0o(int operatingMode, SessionConfig sessionConfig, boolean setOutputType, GraphStateToCameraStateAdapter graphStateToCameraStateAdapter, Integer camera2ExtensionMode, Map<DeferrableSurface, Long> surfaceToStreamUseCaseMap, Map<DeferrableSurface, Long> surfaceToStreamUseHintMap) {
        char c;
        Integer videoStabilizationModeFromCaptureConfig;
        ArrayList arrayList;
        CameraStream.Config config;
        Camera2CaptureRequestConfigurator camera2CaptureRequestConfigurator;
        CameraStream.Config configCreatePostviewStream;
        CameraStream.Config config2;
        String strM427constructorimpl;
        OutputStream.MirrorMode mirrorModeM631boximpl;
        OutputStream.MirrorMode mirrorMode;
        OutputStream.OutputType surface;
        OutputStream.StreamUseCase streamUseCaseM89getStreamUseCaseMhLBY4I;
        OutputStream.StreamUseHint streamUseHintM90getStreamUseHintkVKJKLA;
        OutputStream.Config configM607createvBYXiEU$default;
        CameraStream.Config configCreate$default;
        ZslControl zslControl;
        List list;
        Class<?> containerClass;
        Map<DeferrableSurface, Long> surfaceToStreamUseCaseMap2 = surfaceToStreamUseCaseMap;
        Map<DeferrableSurface, Long> surfaceToStreamUseHintMap2 = surfaceToStreamUseHintMap;
        Intrinsics.checkNotNullParameter(surfaceToStreamUseCaseMap2, "surfaceToStreamUseCaseMap");
        Intrinsics.checkNotNullParameter(surfaceToStreamUseHintMap2, "surfaceToStreamUseHintMap");
        boolean zM410equalsimpl0 = CameraGraph.OperatingMode.m410equalsimpl0(operatingMode, CameraGraph.OperatingMode.INSTANCE.m415getEXTENSION2uNL3no());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList arrayList2 = new ArrayList();
        int iM715constructorimpl = RequestTemplate.m715constructorimpl(1);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        if (sessionConfig != null) {
            CameraInteropStateCallbackRepository cameraInteropStateCallbackRepository = this.cameraInteropStateCallbackRepository;
            if (cameraInteropStateCallbackRepository != null) {
                cameraInteropStateCallbackRepository.updateCallbacks(sessionConfig);
            }
            c = 0;
            if (sessionConfig.getTemplateType() != -1) {
                iM715constructorimpl = RequestTemplate.m715constructorimpl(sessionConfig.getTemplateType());
            }
            linkedHashMap2.putAll(this.templateParamsOverride.mo81getOverrideParamsxlOpshk(RequestTemplate.m714boximpl(iM715constructorimpl)));
            Config implementationOptions = sessionConfig.getImplementationOptions();
            Intrinsics.checkNotNullExpressionValue(implementationOptions, "getImplementationOptions(...)");
            linkedHashMap2.putAll(Camera2ImplConfigKt.toParameters(implementationOptions));
            if (CameraGraph.OperatingMode.m410equalsimpl0(operatingMode, CameraGraph.OperatingMode.INSTANCE.m415getEXTENSION2uNL3no())) {
                androidx.camera.camera2.pipe.Metadata.Key<Integer> camera2ExtensionMode2 = CameraPipeKeys.INSTANCE.getCamera2ExtensionMode();
                Intrinsics.checkNotNull(camera2ExtensionMode);
                linkedHashMap2.put(camera2ExtensionMode2, camera2ExtensionMode);
            }
            String physicalCameraId = toCamera2ImplConfig(sessionConfig).getPhysicalCameraId(null);
            CameraStream.Config config3 = null;
            for (SessionConfig.OutputConfig outputConfig : sessionConfig.getOutputConfigs()) {
                int i = 2;
                DeferrableSurface surface2 = outputConfig.getSurface();
                Intrinsics.checkNotNullExpressionValue(surface2, "getSurface(...)");
                String physicalCameraId2 = physicalCameraId == null ? outputConfig.getPhysicalCameraId() : physicalCameraId;
                DynamicRange dynamicRange = outputConfig.getDynamicRange();
                Intrinsics.checkNotNullExpressionValue(dynamicRange, "getDynamicRange(...)");
                int mirrorMode2 = outputConfig.getMirrorMode();
                OutputStream.Config.Companion companion = OutputStream.Config.INSTANCE;
                OutputStream.DynamicRangeProfile dynamicRangeProfileM91toDynamicRangeProfilezsJmt4 = m91toDynamicRangeProfilezsJmt4(dynamicRange);
                Size prescribedSize = surface2.getPrescribedSize();
                int i2 = iM715constructorimpl;
                Intrinsics.checkNotNullExpressionValue(prescribedSize, "getPrescribedSize(...)");
                int iM746constructorimpl = StreamFormat.m746constructorimpl(surface2.getPrescribedStreamFormat());
                if (physicalCameraId2 == null) {
                    strM427constructorimpl = null;
                } else {
                    CameraId.Companion companion2 = CameraId.INSTANCE;
                    strM427constructorimpl = CameraId.m427constructorimpl(physicalCameraId2);
                }
                if (mirrorMode2 != 0) {
                    if (mirrorMode2 != 1) {
                        mirrorMode = null;
                    } else {
                        mirrorModeM631boximpl = OutputStream.MirrorMode.m631boximpl(OutputStream.MirrorMode.m632constructorimpl(2));
                    }
                    if (setOutputType) {
                        containerClass = outputConfig.getSurface().getContainerClass();
                        if (Intrinsics.areEqual(containerClass, MediaCodec.class)) {
                            surface = OutputStream.OutputType.INSTANCE.getMEDIA_CODEC();
                        } else if (Intrinsics.areEqual(containerClass, SurfaceHolder.class)) {
                            surface = OutputStream.OutputType.INSTANCE.getSURFACE_VIEW();
                        } else if (Intrinsics.areEqual(containerClass, SurfaceTexture.class)) {
                            surface = OutputStream.OutputType.INSTANCE.getSURFACE_TEXTURE();
                        } else {
                            surface = OutputStream.OutputType.INSTANCE.getSURFACE();
                        }
                    } else {
                        surface = OutputStream.OutputType.INSTANCE.getSURFACE();
                    }
                    OutputStream.OutputType outputType = surface;
                    if (zM410equalsimpl0) {
                        streamUseCaseM89getStreamUseCaseMhLBY4I = null;
                    } else {
                        streamUseCaseM89getStreamUseCaseMhLBY4I = m89getStreamUseCaseMhLBY4I(surface2, surfaceToStreamUseCaseMap2, this.cameraMetadata);
                    }
                    if (zM410equalsimpl0) {
                        streamUseHintM90getStreamUseHintkVKJKLA = null;
                    } else {
                        streamUseHintM90getStreamUseHintkVKJKLA = m90getStreamUseHintkVKJKLA(surface2, surfaceToStreamUseHintMap2);
                    }
                    configM607createvBYXiEU$default = OutputStream.Config.Companion.m607createvBYXiEU$default(companion, prescribedSize, iM746constructorimpl, strM427constructorimpl, outputType, mirrorMode, null, dynamicRangeProfileM91toDynamicRangeProfilezsJmt4, streamUseCaseM89getStreamUseCaseMhLBY4I, streamUseHintM90getStreamUseHintkVKJKLA, null, 544, null);
                    List<DeferrableSurface> sharedSurfaces = outputConfig.getSharedSurfaces();
                    Intrinsics.checkNotNullExpressionValue(sharedSurfaces, "getSharedSurfaces(...)");
                    for (DeferrableSurface deferrableSurface : CollectionsKt.plus((Collection<? extends DeferrableSurface>) sharedSurfaces, surface2)) {
                        configCreate$default = CameraStream.Config.Companion.create$default(CameraStream.Config.INSTANCE, configM607createvBYXiEU$default, (ImageSourceConfig) null, i, (Object) null);
                        linkedHashMap3.put(configCreate$default, deferrableSurface);
                        if (outputConfig.getSurfaceGroupId() == -1) {
                            list = (List) linkedHashMap.get(Integer.valueOf(outputConfig.getSurfaceGroupId()));
                            if (list == null) {
                                linkedHashMap.put(Integer.valueOf(outputConfig.getSurfaceGroupId()), CollectionsKt.mutableListOf(configCreate$default));
                            } else {
                                list.add(configCreate$default);
                            }
                        }
                        if (Intrinsics.areEqual(deferrableSurface, surface2)) {
                            zslControl = this.zslControl;
                            Intrinsics.checkNotNull(deferrableSurface);
                            if (zslControl.isZslSurface(deferrableSurface, sessionConfig)) {
                                config3 = configCreate$default;
                            }
                        }
                        i = 2;
                    }
                    surfaceToStreamUseCaseMap2 = surfaceToStreamUseCaseMap;
                    surfaceToStreamUseHintMap2 = surfaceToStreamUseHintMap;
                    iM715constructorimpl = i2;
                } else {
                    mirrorModeM631boximpl = OutputStream.MirrorMode.m631boximpl(OutputStream.MirrorMode.m632constructorimpl(1));
                }
                mirrorMode = mirrorModeM631boximpl;
                if (setOutputType) {
                    containerClass = outputConfig.getSurface().getContainerClass();
                    if (Intrinsics.areEqual(containerClass, MediaCodec.class)) {
                        surface = OutputStream.OutputType.INSTANCE.getMEDIA_CODEC();
                    } else if (Intrinsics.areEqual(containerClass, SurfaceHolder.class)) {
                        surface = OutputStream.OutputType.INSTANCE.getSURFACE_VIEW();
                    } else if (Intrinsics.areEqual(containerClass, SurfaceTexture.class)) {
                        surface = OutputStream.OutputType.INSTANCE.getSURFACE_TEXTURE();
                    } else {
                        surface = OutputStream.OutputType.INSTANCE.getSURFACE();
                    }
                } else {
                    surface = OutputStream.OutputType.INSTANCE.getSURFACE();
                }
                OutputStream.OutputType outputType2 = surface;
                if (zM410equalsimpl0) {
                    streamUseCaseM89getStreamUseCaseMhLBY4I = m89getStreamUseCaseMhLBY4I(surface2, surfaceToStreamUseCaseMap2, this.cameraMetadata);
                } else {
                    streamUseCaseM89getStreamUseCaseMhLBY4I = null;
                }
                if (zM410equalsimpl0) {
                    streamUseHintM90getStreamUseHintkVKJKLA = m90getStreamUseHintkVKJKLA(surface2, surfaceToStreamUseHintMap2);
                } else {
                    streamUseHintM90getStreamUseHintkVKJKLA = null;
                }
                configM607createvBYXiEU$default = OutputStream.Config.Companion.m607createvBYXiEU$default(companion, prescribedSize, iM746constructorimpl, strM427constructorimpl, outputType2, mirrorMode, null, dynamicRangeProfileM91toDynamicRangeProfilezsJmt4, streamUseCaseM89getStreamUseCaseMhLBY4I, streamUseHintM90getStreamUseHintkVKJKLA, null, 544, null);
                List<DeferrableSurface> sharedSurfaces2 = outputConfig.getSharedSurfaces();
                Intrinsics.checkNotNullExpressionValue(sharedSurfaces2, "getSharedSurfaces(...)");
                while (r8.hasNext()) {
                    configCreate$default = CameraStream.Config.Companion.create$default(CameraStream.Config.INSTANCE, configM607createvBYXiEU$default, (ImageSourceConfig) null, i, (Object) null);
                    linkedHashMap3.put(configCreate$default, deferrableSurface);
                    if (outputConfig.getSurfaceGroupId() == -1) {
                        list = (List) linkedHashMap.get(Integer.valueOf(outputConfig.getSurfaceGroupId()));
                        if (list == null) {
                            linkedHashMap.put(Integer.valueOf(outputConfig.getSurfaceGroupId()), CollectionsKt.mutableListOf(configCreate$default));
                        } else {
                            list.add(configCreate$default);
                        }
                    }
                    if (Intrinsics.areEqual(deferrableSurface, surface2)) {
                        zslControl = this.zslControl;
                        Intrinsics.checkNotNull(deferrableSurface);
                        if (zslControl.isZslSurface(deferrableSurface, sessionConfig)) {
                            config3 = configCreate$default;
                        }
                    }
                    i = 2;
                }
                surfaceToStreamUseCaseMap2 = surfaceToStreamUseCaseMap;
                surfaceToStreamUseHintMap2 = surfaceToStreamUseHintMap;
                iM715constructorimpl = i2;
            }
            int i3 = iM715constructorimpl;
            if (sessionConfig.getInputConfiguration() != null && (config2 = config3) != null) {
                arrayList2.add(new InputStream.Config(config2, 1, ((OutputStream.Config) CollectionsKt.single((List) config2.getOutputs())).getFormat(), null));
            }
            iM715constructorimpl = i3;
        } else {
            c = 0;
        }
        CameraGraph.Flags flagsCreateCameraGraphFlags = createCameraGraphFlags(this.cameraQuirks, zM410equalsimpl0);
        if (sessionConfig != null) {
            CaptureConfig repeatingCaptureConfig = sessionConfig.getRepeatingCaptureConfig();
            Intrinsics.checkNotNullExpressionValue(repeatingCaptureConfig, "getRepeatingCaptureConfig(...)");
            videoStabilizationModeFromCaptureConfig = getVideoStabilizationModeFromCaptureConfig(repeatingCaptureConfig);
        } else {
            videoStabilizationModeFromCaptureConfig = null;
        }
        Range<Integer> expectedFrameRateRange = sessionConfig != null ? sessionConfig.getExpectedFrameRateRange() : null;
        if (Intrinsics.areEqual(expectedFrameRateRange, StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED)) {
            expectedFrameRateRange = null;
        }
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        if (zM410equalsimpl0) {
            mapCreateMapBuilder.put(CameraPipeKeys.INSTANCE.getIgnore3ARequiredParameters(), true);
        }
        if (videoStabilizationModeFromCaptureConfig != null) {
            mapCreateMapBuilder.put(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, Integer.valueOf(videoStabilizationModeFromCaptureConfig.intValue()));
        }
        mapCreateMapBuilder.put(CameraPipeKeys.INSTANCE.getCamera2CaptureRequestTag(), TagBundle.CAMERAX_USER_TAG_PREFIX);
        if (expectedFrameRateRange != null) {
            mapCreateMapBuilder.put(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, expectedFrameRateRange);
        }
        Map mapBuild = MapsKt.build(mapCreateMapBuilder);
        if (expectedFrameRateRange != null) {
            linkedHashMap2.put(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, expectedFrameRateRange);
        }
        if (videoStabilizationModeFromCaptureConfig != null) {
            videoStabilizationModeFromCaptureConfig.intValue();
            linkedHashMap2.put(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, videoStabilizationModeFromCaptureConfig);
        }
        if (sessionConfig != null) {
            arrayList = null;
            String physicalCameraId3 = toCamera2ImplConfig(sessionConfig).getPhysicalCameraId(null);
            SessionConfig.OutputConfig postviewOutputConfig = sessionConfig.getPostviewOutputConfig();
            if (postviewOutputConfig == null || (configCreatePostviewStream = createPostviewStream(postviewOutputConfig, physicalCameraId3)) == null) {
                configCreatePostviewStream = null;
            } else {
                linkedHashMap3.put(configCreatePostviewStream, postviewOutputConfig.getSurface());
            }
            config = configCreatePostviewStream;
        } else {
            arrayList = null;
            config = null;
        }
        CameraXConfig cameraXConfig = this.cameraXConfig;
        if (cameraXConfig != null && (camera2CaptureRequestConfigurator = Camera2CaptureRequestConfiguratorKt.getCamera2CaptureRequestConfigurator(cameraXConfig)) != null) {
            Camera2CaptureRequestConfiguratorKt.configureWithUnchecked(camera2CaptureRequestConfigurator, linkedHashMap2);
        }
        String cameraId = this.cameraConfig.getCameraId();
        List list2 = CollectionsKt.toList(linkedHashMap3.keySet());
        List list3 = CollectionsKt.toList(linkedHashMap.values());
        if (arrayList2.isEmpty()) {
            arrayList2 = arrayList;
        }
        Request.Listener[] listenerArr = new Request.Listener[2];
        listenerArr[c] = this.callbackMap;
        listenerArr[1] = this.requestListener;
        return new CameraGraphCreationResult(new CameraGraph.Config(cameraId, list2, list3, arrayList2, config, iM715constructorimpl, linkedHashMap2, operatingMode, 0, mapBuild, CollectionsKt.listOf((Object[]) listenerArr), CollectionsKt.listOfNotNull(graphStateToCameraStateAdapter), null, null, null, null, flagsCreateCameraGraphFlags, null, 192768, null), MapsKt.toMap(linkedHashMap3));
    }

    private final CameraStream.Config createPostviewStream(SessionConfig.OutputConfig postviewConfig, String physicalCameraIdForAllStreams) {
        String strM427constructorimpl;
        OutputStream.MirrorMode mirrorModeM631boximpl;
        OutputStream.MirrorMode mirrorMode;
        DeferrableSurface surface = postviewConfig.getSurface();
        Intrinsics.checkNotNullExpressionValue(surface, "getSurface(...)");
        if (physicalCameraIdForAllStreams == null) {
            physicalCameraIdForAllStreams = postviewConfig.getPhysicalCameraId();
        }
        int mirrorMode2 = postviewConfig.getMirrorMode();
        OutputStream.Config.Companion companion = OutputStream.Config.INSTANCE;
        Size prescribedSize = surface.getPrescribedSize();
        Intrinsics.checkNotNullExpressionValue(prescribedSize, "getPrescribedSize(...)");
        int iM746constructorimpl = StreamFormat.m746constructorimpl(surface.getPrescribedStreamFormat());
        if (physicalCameraIdForAllStreams == null) {
            strM427constructorimpl = null;
        } else {
            CameraId.Companion companion2 = CameraId.INSTANCE;
            strM427constructorimpl = CameraId.m427constructorimpl(physicalCameraIdForAllStreams);
        }
        if (mirrorMode2 != 0) {
            if (mirrorMode2 != 1) {
                mirrorMode = null;
            } else {
                mirrorModeM631boximpl = OutputStream.MirrorMode.m631boximpl(OutputStream.MirrorMode.m632constructorimpl(2));
            }
            return CameraStream.Config.Companion.create$default(CameraStream.Config.INSTANCE, OutputStream.Config.Companion.m607createvBYXiEU$default(companion, prescribedSize, iM746constructorimpl, strM427constructorimpl, null, mirrorMode, null, null, null, null, null, 1000, null), (ImageSourceConfig) null, 2, (Object) null);
        }
        mirrorModeM631boximpl = OutputStream.MirrorMode.m631boximpl(OutputStream.MirrorMode.m632constructorimpl(1));
        mirrorMode = mirrorModeM631boximpl;
        return CameraStream.Config.Companion.create$default(CameraStream.Config.INSTANCE, OutputStream.Config.Companion.m607createvBYXiEU$default(companion, prescribedSize, iM746constructorimpl, strM427constructorimpl, null, mirrorMode, null, null, null, null, null, 1000, null), (ImageSourceConfig) null, 2, (Object) null);
    }

    /* JADX INFO: renamed from: getStreamUseCase-MhLBY4I, reason: not valid java name */
    private final OutputStream.StreamUseCase m89getStreamUseCaseMhLBY4I(DeferrableSurface deferrableSurface, Map<DeferrableSurface, Long> mapping, CameraMetadata cameraMetadata) {
        Long l = mapping.get(deferrableSurface);
        OutputStream.StreamUseCase streamUseCaseM651boximpl = l != null ? OutputStream.StreamUseCase.m651boximpl(OutputStream.StreamUseCase.m652constructorimpl(l.longValue())) : null;
        if (Build.VERSION.SDK_INT >= 33 && streamUseCaseM651boximpl != null && cameraMetadata != null) {
            CameraCharacteristics.Key SCALER_AVAILABLE_STREAM_USE_CASES = CameraCharacteristics.SCALER_AVAILABLE_STREAM_USE_CASES;
            Intrinsics.checkNotNullExpressionValue(SCALER_AVAILABLE_STREAM_USE_CASES, "SCALER_AVAILABLE_STREAM_USE_CASES");
            long[] jArr = (long[]) cameraMetadata.get(SCALER_AVAILABLE_STREAM_USE_CASES);
            if (jArr != null && ArraysKt.contains(jArr, streamUseCaseM651boximpl.m657unboximpl())) {
                return streamUseCaseM651boximpl;
            }
        }
        Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
        if (Logger.isWarnEnabled(Log.TAG)) {
            android.util.Log.w(Camera2Logger.TRUNCATED_TAG, "Expected stream use case for " + deferrableSurface + ", " + streamUseCaseM651boximpl + " cannot be set!");
        }
        return null;
    }

    /* JADX INFO: renamed from: getStreamUseHint-kVKJKLA, reason: not valid java name */
    private final OutputStream.StreamUseHint m90getStreamUseHintkVKJKLA(DeferrableSurface deferrableSurface, Map<DeferrableSurface, Long> mapping) {
        Long l = mapping.get(deferrableSurface);
        if (l != null) {
            return OutputStream.StreamUseHint.m665boximpl(OutputStream.StreamUseHint.m666constructorimpl(l.longValue()));
        }
        return null;
    }

    private final CameraGraph.Flags createCameraGraphFlags(CameraQuirks cameraQuirks, boolean isExtensions) {
        if (cameraQuirks.getQuirks().contains(CaptureSessionStuckQuirk.class)) {
            Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CameraPipe should be enabling CaptureSessionStuckQuirk by default");
            }
        }
        int iM73getBehaviorBm6Tfm4 = FinalizeSessionOnCloseQuirk.INSTANCE.m73getBehaviorBm6Tfm4();
        boolean zShouldCloseCameraDevice = this.closeCameraOnCameraGraphClose.shouldCloseCameraDevice(isExtensions);
        boolean z = false;
        if ((!isExtensions || DeviceQuirks.INSTANCE.get(DisableAbortCapturesOnStopWithSessionProcessorQuirk.class) == null) && DeviceQuirks.INSTANCE.get(DisableAbortCapturesOnStopQuirk.class) == null && Build.VERSION.SDK_INT >= 30) {
            z = true;
        }
        return new CameraGraph.Flags(false, z, new CameraGraph.RepeatingRequestRequirementsBeforeCapture(cameraQuirks.getQuirks().contains(QuickSuccessiveImageCaptureFailsRepeatingRequestQuirk.class) ? 1 : 0, CameraGraph.RepeatingRequestRequirementsBeforeCapture.CompletionBehavior.AT_LEAST, null), null, iM73getBehaviorBm6Tfm4, true, zShouldCloseCameraDevice, true, 9, null);
    }

    /* JADX INFO: renamed from: toDynamicRangeProfile--zsJmt4, reason: not valid java name */
    private final OutputStream.DynamicRangeProfile m91toDynamicRangeProfilezsJmt4(DynamicRange dynamicRange) {
        if (Build.VERSION.SDK_INT < 33) {
            return null;
        }
        OutputStream.DynamicRangeProfile dynamicRangeProfileM611boximpl = OutputStream.DynamicRangeProfile.m611boximpl(OutputStream.DynamicRangeProfile.INSTANCE.m630getSTANDARDfFAQAUE());
        if (this.supportedDynamicRangeProfiles != null) {
            Long lDynamicRangeToFirstSupportedProfile = DynamicRangeConversions.INSTANCE.dynamicRangeToFirstSupportedProfile(dynamicRange, this.supportedDynamicRangeProfiles);
            if (lDynamicRangeToFirstSupportedProfile != null) {
                return OutputStream.DynamicRangeProfile.m611boximpl(OutputStream.DynamicRangeProfile.m612constructorimpl(lDynamicRangeToFirstSupportedProfile.longValue()));
            }
            Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
            if (Logger.isErrorEnabled(Log.TAG)) {
                android.util.Log.e(Camera2Logger.TRUNCATED_TAG, "Requested dynamic range is not supported. Defaulting to STANDARD dynamic range profile.\nRequested dynamic range:\n " + dynamicRange);
            }
        }
        return dynamicRangeProfileM611boximpl;
    }

    private final Camera2ImplConfig toCamera2ImplConfig(SessionConfig sessionConfig) {
        Config implementationOptions = sessionConfig.getImplementationOptions();
        Intrinsics.checkNotNullExpressionValue(implementationOptions, "getImplementationOptions(...)");
        return new Camera2ImplConfig(implementationOptions);
    }

    private final Integer getVideoStabilizationModeFromCaptureConfig(CaptureConfig captureConfig) {
        int previewStabilizationMode = captureConfig.getPreviewStabilizationMode();
        int videoStabilizationMode = captureConfig.getVideoStabilizationMode();
        if (previewStabilizationMode == 1 || videoStabilizationMode == 1) {
            return 0;
        }
        if (previewStabilizationMode == 2) {
            return 2;
        }
        return videoStabilizationMode == 2 ? 1 : null;
    }

    public String toString() {
        return "CameraGraphConfigProvider<" + ((Object) CameraId.m432toStringimpl(this.cameraConfig.getCameraId())) + Typography.greater;
    }
}
