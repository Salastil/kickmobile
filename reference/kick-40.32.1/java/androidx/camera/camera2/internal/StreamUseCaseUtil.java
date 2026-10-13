package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.camera2.adapter.SupportedSurfaceCombination;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.impl.Camera2Logger;
import androidx.camera.camera2.pipe.CameraMetadata;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.AttachedSurfaceInfo;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageCaptureConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.SurfaceConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.streamsharing.StreamSharingConfig;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StreamUseCaseUtil.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J:\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0010\u0010\u0014\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u00122\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00060\u0017J\u0012\u0010\u0019\u001a\u00020\u001a2\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u0015J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"JH\u0010#\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\u0016\u0010'\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0015\u0012\u0004\u0012\u00020(0\u00172\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020(0\u0017J\u001c\u0010*\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020,0%J&\u0010-\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u00020\u00062\f\u00100\u001a\b\u0012\u0004\u0012\u00020\r0%H\u0002JB\u00101\u001a\u00020\u001d2\u0014\u00102\u001a\u0010\u0012\u0004\u0012\u000203\u0012\u0006\u0012\u0004\u0018\u00010&0\u000b2\u0016\u00104\u001a\u0012\u0012\u0004\u0012\u000203\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u000b2\f\u00105\u001a\b\u0012\u0004\u0012\u00020,0%Jl\u00106\u001a\u00020\u00102\u0016\u0010'\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0015\u0012\u0004\u0012\u00020(0\u00172\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020(0\u00172\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020&0\u000b2\u0016\u00104\u001a\u0012\u0012\u0004\u0012\u000203\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u000b2\f\u00105\u001a\b\u0012\u0004\u0012\u00020,0%J!\u00107\u001a\u0004\u0018\u0001082\u0006\u00109\u001a\u0002082\b\u0010/\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0002\u0010:J&\u0010;\u001a\u00020\u001d2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\u0010\u0010<\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150%J\u0018\u0010=\u001a\u00020\u001d2\u0006\u0010>\u001a\u0002082\u0006\u0010.\u001a\u00020\rH\u0002J$\u0010?\u001a\u00020\u001d2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00060\f2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00060\fH\u0002J\b\u0010B\u001a\u00020\u0010H\u0002J6\u0010C\u001a\u00020\u001d2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\u0010\u0010<\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150%2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00060\fH\u0002J\u0018\u0010E\u001a\u0002032\u0006\u0010.\u001a\u00020\r2\u0006\u0010F\u001a\u000203H\u0003R\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Landroidx/camera/camera2/internal/StreamUseCaseUtil;", "", "<init>", "()V", "STREAM_USE_CASE_STREAM_SPEC_OPTION", "Landroidx/camera/core/impl/Config$Option;", "", "getSTREAM_USE_CASE_STREAM_SPEC_OPTION$annotations", "getSTREAM_USE_CASE_STREAM_SPEC_OPTION", "()Landroidx/camera/core/impl/Config$Option;", "STREAM_USE_CASE_TO_ELIGIBLE_CAPTURE_TYPES_MAP", "", "", "Landroidx/camera/core/impl/UseCaseConfigFactory$CaptureType;", "STREAM_USE_CASE_TO_ELIGIBLE_STREAM_SHARING_CHILDREN_TYPES_MAP", "populateSurfaceToStreamUseCaseMapping", "", "sessionConfigs", "", "Landroidx/camera/core/impl/SessionConfig;", "useCaseConfigs", "Landroidx/camera/core/impl/UseCaseConfig;", "streamUseCaseMap", "", "Landroidx/camera/core/impl/DeferrableSurface;", "getStreamSpecImplementationOptions", "Landroidx/camera/camera2/impl/Camera2ImplConfig;", "useCaseConfig", "isStreamUseCaseSupported", "", "cameraMetadata", "Landroidx/camera/camera2/pipe/CameraMetadata;", "shouldUseStreamUseCase", "featureSettings", "Landroidx/camera/camera2/adapter/SupportedSurfaceCombination$FeatureSettings;", "populateStreamUseCaseStreamSpecOptionWithInteropOverride", "attachedSurfaces", "", "Landroidx/camera/core/impl/AttachedSurfaceInfo;", "suggestedStreamSpecMap", "Landroidx/camera/core/impl/StreamSpec;", "attachedSurfaceStreamSpecMap", "areStreamUseCasesAvailableForSurfaceConfigs", "surfaceConfigs", "Landroidx/camera/core/impl/SurfaceConfig;", "isEligibleCaptureType", "captureType", "streamUseCase", "streamSharingTypes", "areCaptureTypesEligible", "surfaceConfigIndexAttachedSurfaceInfoMap", "", "surfaceConfigIndexUseCaseConfigMap", "surfaceConfigsWithStreamUseCase", "populateStreamUseCaseStreamSpecOptionWithSupportedSurfaceConfigs", "getUpdatedImplementationOptionsWithUseCaseStreamSpecOption", "Landroidx/camera/core/impl/Config;", "oldImplementationOptions", "(Landroidx/camera/core/impl/Config;Ljava/lang/Long;)Landroidx/camera/core/impl/Config;", "containsZslUseCase", "newUseCaseConfigs", "isZslUseCase", "config", "areStreamUseCasesAvailable", "availableStreamUseCasesSet", "streamUseCases", "throwInvalidCamera2InteropOverrideException", "isValidCamera2InteropOverride", "availableStreamUseCases", "getSessionConfigTemplateType", "captureMode", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StreamUseCaseUtil {
    public static final StreamUseCaseUtil INSTANCE = new StreamUseCaseUtil();
    private static final Config.Option<Long> STREAM_USE_CASE_STREAM_SPEC_OPTION;
    private static final Map<Long, Set<UseCaseConfigFactory.CaptureType>> STREAM_USE_CASE_TO_ELIGIBLE_CAPTURE_TYPES_MAP;
    private static final Map<Long, Set<UseCaseConfigFactory.CaptureType>> STREAM_USE_CASE_TO_ELIGIBLE_STREAM_SHARING_CHILDREN_TYPES_MAP;

    /* JADX INFO: compiled from: StreamUseCaseUtil.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[UseCaseConfigFactory.CaptureType.values().length];
            try {
                iArr[UseCaseConfigFactory.CaptureType.IMAGE_CAPTURE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[UseCaseConfigFactory.CaptureType.STREAM_SHARING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[UseCaseConfigFactory.CaptureType.PREVIEW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[UseCaseConfigFactory.CaptureType.IMAGE_ANALYSIS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ void getSTREAM_USE_CASE_STREAM_SPEC_OPTION$annotations() {
    }

    private StreamUseCaseUtil() {
    }

    public final Config.Option<Long> getSTREAM_USE_CASE_STREAM_SPEC_OPTION() {
        return STREAM_USE_CASE_STREAM_SPEC_OPTION;
    }

    static {
        Class cls = Long.TYPE;
        Intrinsics.checkNotNull(cls);
        Config.Option<Long> optionCreate = Config.Option.create("camera2.streamSpec.streamUseCase", cls);
        Intrinsics.checkNotNullExpressionValue(optionCreate, "create(...)");
        STREAM_USE_CASE_STREAM_SPEC_OPTION = optionCreate;
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        if (Build.VERSION.SDK_INT >= 33) {
            mapCreateMapBuilder.put(4L, SetsKt.setOf((Object[]) new UseCaseConfigFactory.CaptureType[]{UseCaseConfigFactory.CaptureType.PREVIEW, UseCaseConfigFactory.CaptureType.METERING_REPEATING, UseCaseConfigFactory.CaptureType.IMAGE_ANALYSIS}));
            mapCreateMapBuilder.put(1L, SetsKt.setOf((Object[]) new UseCaseConfigFactory.CaptureType[]{UseCaseConfigFactory.CaptureType.PREVIEW, UseCaseConfigFactory.CaptureType.METERING_REPEATING, UseCaseConfigFactory.CaptureType.IMAGE_ANALYSIS}));
            mapCreateMapBuilder.put(2L, SetsKt.setOf(UseCaseConfigFactory.CaptureType.IMAGE_CAPTURE));
            mapCreateMapBuilder.put(3L, SetsKt.setOf(UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE));
        }
        STREAM_USE_CASE_TO_ELIGIBLE_CAPTURE_TYPES_MAP = MapsKt.build(mapCreateMapBuilder);
        Map mapCreateMapBuilder2 = MapsKt.createMapBuilder();
        if (Build.VERSION.SDK_INT >= 33) {
            mapCreateMapBuilder2.put(4L, SetsKt.setOf((Object[]) new UseCaseConfigFactory.CaptureType[]{UseCaseConfigFactory.CaptureType.PREVIEW, UseCaseConfigFactory.CaptureType.IMAGE_CAPTURE, UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE}));
            mapCreateMapBuilder2.put(3L, SetsKt.setOf((Object[]) new UseCaseConfigFactory.CaptureType[]{UseCaseConfigFactory.CaptureType.PREVIEW, UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE}));
        }
        STREAM_USE_CASE_TO_ELIGIBLE_STREAM_SHARING_CHILDREN_TYPES_MAP = MapsKt.build(mapCreateMapBuilder2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void populateSurfaceToStreamUseCaseMapping(Collection<SessionConfig> sessionConfigs, Collection<? extends UseCaseConfig<?>> useCaseConfigs, Map<DeferrableSurface, Long> streamUseCaseMap) {
        Intrinsics.checkNotNullParameter(sessionConfigs, "sessionConfigs");
        Intrinsics.checkNotNullParameter(useCaseConfigs, "useCaseConfigs");
        Intrinsics.checkNotNullParameter(streamUseCaseMap, "streamUseCaseMap");
        ArrayList arrayList = new ArrayList(useCaseConfigs);
        for (SessionConfig sessionConfig : sessionConfigs) {
            Config implementationOptions = sessionConfig.getImplementationOptions();
            Config.Option<Long> option = STREAM_USE_CASE_STREAM_SPEC_OPTION;
            if (implementationOptions.containsOption(option) && sessionConfig.getSurfaces().size() != 1) {
                Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
                if (Logger.isErrorEnabled(Log.TAG)) {
                    android.util.Log.e(Camera2Logger.TRUNCATED_TAG, "StreamUseCaseUtil: SessionConfig has stream use case but also contains " + sessionConfig.getSurfaces().size() + " surfaces, abort populateSurfaceToStreamUseCaseMapping().");
                    return;
                }
                return;
            }
            if (sessionConfig.getImplementationOptions().containsOption(option)) {
                int i = 0;
                for (SessionConfig sessionConfig2 : sessionConfigs) {
                    if (((UseCaseConfig) arrayList.get(i)).getCaptureType() == UseCaseConfigFactory.CaptureType.METERING_REPEATING) {
                        List<DeferrableSurface> surfaces = sessionConfig2.getSurfaces();
                        Intrinsics.checkNotNullExpressionValue(surfaces, "getSurfaces(...)");
                        Preconditions.checkState(!surfaces.isEmpty(), "MeteringRepeating should contain a surface");
                        streamUseCaseMap.put(sessionConfig2.getSurfaces().get(0), 1L);
                    } else {
                        Config implementationOptions2 = sessionConfig2.getImplementationOptions();
                        Config.Option<Long> option2 = STREAM_USE_CASE_STREAM_SPEC_OPTION;
                        if (implementationOptions2.containsOption(option2)) {
                            List<DeferrableSurface> surfaces2 = sessionConfig2.getSurfaces();
                            Intrinsics.checkNotNullExpressionValue(surfaces2, "getSurfaces(...)");
                            if (!surfaces2.isEmpty()) {
                                DeferrableSurface deferrableSurface = sessionConfig2.getSurfaces().get(0);
                                Object objRetrieveOption = sessionConfig2.getImplementationOptions().retrieveOption(option2);
                                Intrinsics.checkNotNull(objRetrieveOption);
                                streamUseCaseMap.put(deferrableSurface, objRetrieveOption);
                            }
                        }
                    }
                    i++;
                }
                break;
            }
        }
        Camera2Logger camera2Logger2 = Camera2Logger.INSTANCE;
        if (Logger.isDebugEnabled(Log.TAG)) {
            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "populateSurfaceToStreamUseCaseMapping() - streamUseCaseMap = " + streamUseCaseMap);
        }
    }

    public final Camera2ImplConfig getStreamSpecImplementationOptions(UseCaseConfig<?> useCaseConfig) {
        Intrinsics.checkNotNullParameter(useCaseConfig, "useCaseConfig");
        MutableOptionsBundle mutableOptionsBundleCreate = MutableOptionsBundle.create();
        Intrinsics.checkNotNullExpressionValue(mutableOptionsBundleCreate, "create(...)");
        if (useCaseConfig.containsOption(Camera2ImplConfig.STREAM_USE_CASE_OPTION)) {
            mutableOptionsBundleCreate.insertOption(Camera2ImplConfig.STREAM_USE_CASE_OPTION, useCaseConfig.retrieveOption(Camera2ImplConfig.STREAM_USE_CASE_OPTION));
        }
        if (useCaseConfig.containsOption(UseCaseConfig.OPTION_ZSL_DISABLED)) {
            mutableOptionsBundleCreate.insertOption(UseCaseConfig.OPTION_ZSL_DISABLED, useCaseConfig.retrieveOption(UseCaseConfig.OPTION_ZSL_DISABLED));
        }
        if (useCaseConfig.containsOption(ImageCaptureConfig.OPTION_IMAGE_CAPTURE_MODE)) {
            mutableOptionsBundleCreate.insertOption(ImageCaptureConfig.OPTION_IMAGE_CAPTURE_MODE, useCaseConfig.retrieveOption(ImageCaptureConfig.OPTION_IMAGE_CAPTURE_MODE));
        }
        if (useCaseConfig.containsOption(UseCaseConfig.OPTION_INPUT_FORMAT)) {
            mutableOptionsBundleCreate.insertOption(UseCaseConfig.OPTION_INPUT_FORMAT, useCaseConfig.retrieveOption(UseCaseConfig.OPTION_INPUT_FORMAT));
        }
        return new Camera2ImplConfig(mutableOptionsBundleCreate);
    }

    public final boolean isStreamUseCaseSupported(CameraMetadata cameraMetadata) {
        Intrinsics.checkNotNullParameter(cameraMetadata, "cameraMetadata");
        if (Build.VERSION.SDK_INT < 33) {
            return false;
        }
        CameraCharacteristics.Key SCALER_AVAILABLE_STREAM_USE_CASES = CameraCharacteristics.SCALER_AVAILABLE_STREAM_USE_CASES;
        Intrinsics.checkNotNullExpressionValue(SCALER_AVAILABLE_STREAM_USE_CASES, "SCALER_AVAILABLE_STREAM_USE_CASES");
        long[] jArr = (long[]) cameraMetadata.get(SCALER_AVAILABLE_STREAM_USE_CASES);
        return (jArr == null || jArr.length == 0) ? false : true;
    }

    public final boolean shouldUseStreamUseCase(SupportedSurfaceCombination.FeatureSettings featureSettings) {
        Intrinsics.checkNotNullParameter(featureSettings, "featureSettings");
        return featureSettings.getCameraMode() == 0 && featureSettings.getRequiredMaxBitDepth() == 8 && !featureSettings.isHighSpeedOn();
    }

    public final boolean populateStreamUseCaseStreamSpecOptionWithInteropOverride(CameraMetadata cameraMetadata, List<? extends AttachedSurfaceInfo> attachedSurfaces, Map<UseCaseConfig<?>, StreamSpec> suggestedStreamSpecMap, Map<AttachedSurfaceInfo, StreamSpec> attachedSurfaceStreamSpecMap) {
        Intrinsics.checkNotNullParameter(cameraMetadata, "cameraMetadata");
        Intrinsics.checkNotNullParameter(attachedSurfaces, "attachedSurfaces");
        Intrinsics.checkNotNullParameter(suggestedStreamSpecMap, "suggestedStreamSpecMap");
        Intrinsics.checkNotNullParameter(attachedSurfaceStreamSpecMap, "attachedSurfaceStreamSpecMap");
        if (Build.VERSION.SDK_INT < 33) {
            return false;
        }
        ArrayList arrayList = new ArrayList(suggestedStreamSpecMap.keySet());
        Iterator<? extends AttachedSurfaceInfo> it = attachedSurfaces.iterator();
        while (it.hasNext()) {
            if (it.next().getImplementationOptions() == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
        }
        Iterator<? extends UseCaseConfig<?>> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            StreamSpec streamSpec = suggestedStreamSpecMap.get(it2.next());
            if (streamSpec == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            if (streamSpec.getImplementationOptions() == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
        }
        CameraCharacteristics.Key SCALER_AVAILABLE_STREAM_USE_CASES = CameraCharacteristics.SCALER_AVAILABLE_STREAM_USE_CASES;
        Intrinsics.checkNotNullExpressionValue(SCALER_AVAILABLE_STREAM_USE_CASES, "SCALER_AVAILABLE_STREAM_USE_CASES");
        long[] jArr = (long[]) cameraMetadata.get(SCALER_AVAILABLE_STREAM_USE_CASES);
        if (jArr != null && jArr.length != 0) {
            HashSet hashSet = new HashSet();
            for (long j : jArr) {
                hashSet.add(Long.valueOf(j));
            }
            if (isValidCamera2InteropOverride(attachedSurfaces, arrayList, hashSet)) {
                for (AttachedSurfaceInfo attachedSurfaceInfo : attachedSurfaces) {
                    Config implementationOptions = attachedSurfaceInfo.getImplementationOptions();
                    Intrinsics.checkNotNull(implementationOptions);
                    Config updatedImplementationOptionsWithUseCaseStreamSpecOption = getUpdatedImplementationOptionsWithUseCaseStreamSpecOption(implementationOptions, (Long) implementationOptions.retrieveOption(Camera2ImplConfig.STREAM_USE_CASE_OPTION));
                    if (updatedImplementationOptionsWithUseCaseStreamSpecOption != null) {
                        attachedSurfaceStreamSpecMap.put(attachedSurfaceInfo, attachedSurfaceInfo.toStreamSpec(updatedImplementationOptionsWithUseCaseStreamSpecOption));
                    }
                }
                for (UseCaseConfig<?> useCaseConfig : arrayList) {
                    StreamSpec streamSpec2 = suggestedStreamSpecMap.get(useCaseConfig);
                    Intrinsics.checkNotNull(streamSpec2);
                    Config implementationOptions2 = streamSpec2.getImplementationOptions();
                    Intrinsics.checkNotNull(implementationOptions2);
                    Config updatedImplementationOptionsWithUseCaseStreamSpecOption2 = getUpdatedImplementationOptionsWithUseCaseStreamSpecOption(implementationOptions2, (Long) implementationOptions2.retrieveOption(Camera2ImplConfig.STREAM_USE_CASE_OPTION));
                    if (updatedImplementationOptionsWithUseCaseStreamSpecOption2 != null) {
                        suggestedStreamSpecMap.put(useCaseConfig, streamSpec2.toBuilder().setImplementationOptions(updatedImplementationOptionsWithUseCaseStreamSpecOption2).build());
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final boolean areStreamUseCasesAvailableForSurfaceConfigs(CameraMetadata cameraMetadata, List<SurfaceConfig> surfaceConfigs) {
        Intrinsics.checkNotNullParameter(cameraMetadata, "cameraMetadata");
        Intrinsics.checkNotNullParameter(surfaceConfigs, "surfaceConfigs");
        if (Build.VERSION.SDK_INT < 33) {
            return false;
        }
        CameraCharacteristics.Key SCALER_AVAILABLE_STREAM_USE_CASES = CameraCharacteristics.SCALER_AVAILABLE_STREAM_USE_CASES;
        Intrinsics.checkNotNullExpressionValue(SCALER_AVAILABLE_STREAM_USE_CASES, "SCALER_AVAILABLE_STREAM_USE_CASES");
        long[] jArr = (long[]) cameraMetadata.get(SCALER_AVAILABLE_STREAM_USE_CASES);
        if (jArr == null || jArr.length == 0) {
            return false;
        }
        HashSet hashSet = new HashSet();
        for (long j : jArr) {
            hashSet.add(Long.valueOf(j));
        }
        Iterator<SurfaceConfig> it = surfaceConfigs.iterator();
        while (it.hasNext()) {
            if (!hashSet.contains(Long.valueOf(it.next().getStreamUseCase().getValue()))) {
                return false;
            }
        }
        return true;
    }

    private final boolean isEligibleCaptureType(UseCaseConfigFactory.CaptureType captureType, long streamUseCase, List<? extends UseCaseConfigFactory.CaptureType> streamSharingTypes) {
        if (Build.VERSION.SDK_INT < 33) {
            return false;
        }
        if (captureType == UseCaseConfigFactory.CaptureType.STREAM_SHARING) {
            Map<Long, Set<UseCaseConfigFactory.CaptureType>> map = STREAM_USE_CASE_TO_ELIGIBLE_STREAM_SHARING_CHILDREN_TYPES_MAP;
            if (!map.containsKey(Long.valueOf(streamUseCase))) {
                return false;
            }
            Set<UseCaseConfigFactory.CaptureType> set = map.get(Long.valueOf(streamUseCase));
            Intrinsics.checkNotNull(set);
            Set<UseCaseConfigFactory.CaptureType> set2 = set;
            if (streamSharingTypes.size() != set2.size()) {
                return false;
            }
            Iterator<? extends UseCaseConfigFactory.CaptureType> it = streamSharingTypes.iterator();
            while (it.hasNext()) {
                if (!set2.contains(it.next())) {
                    return false;
                }
            }
            return true;
        }
        Map<Long, Set<UseCaseConfigFactory.CaptureType>> map2 = STREAM_USE_CASE_TO_ELIGIBLE_CAPTURE_TYPES_MAP;
        if (map2.containsKey(Long.valueOf(streamUseCase))) {
            Set<UseCaseConfigFactory.CaptureType> set3 = map2.get(Long.valueOf(streamUseCase));
            Intrinsics.checkNotNull(set3);
            if (set3.contains(captureType)) {
                return true;
            }
        }
        return false;
    }

    public final boolean areCaptureTypesEligible(Map<Integer, ? extends AttachedSurfaceInfo> surfaceConfigIndexAttachedSurfaceInfoMap, Map<Integer, ? extends UseCaseConfig<?>> surfaceConfigIndexUseCaseConfigMap, List<SurfaceConfig> surfaceConfigsWithStreamUseCase) {
        List<UseCaseConfigFactory.CaptureType> listEmptyList;
        UseCaseConfigFactory.CaptureType captureType;
        Intrinsics.checkNotNullParameter(surfaceConfigIndexAttachedSurfaceInfoMap, "surfaceConfigIndexAttachedSurfaceInfoMap");
        Intrinsics.checkNotNullParameter(surfaceConfigIndexUseCaseConfigMap, "surfaceConfigIndexUseCaseConfigMap");
        Intrinsics.checkNotNullParameter(surfaceConfigsWithStreamUseCase, "surfaceConfigsWithStreamUseCase");
        int size = surfaceConfigsWithStreamUseCase.size();
        for (int i = 0; i < size; i++) {
            long value = surfaceConfigsWithStreamUseCase.get(i).getStreamUseCase().getValue();
            if (surfaceConfigIndexAttachedSurfaceInfoMap.containsKey(Integer.valueOf(i))) {
                AttachedSurfaceInfo attachedSurfaceInfo = surfaceConfigIndexAttachedSurfaceInfoMap.get(Integer.valueOf(i));
                Intrinsics.checkNotNull(attachedSurfaceInfo);
                if (attachedSurfaceInfo.getCaptureTypes().size() == 1) {
                    captureType = attachedSurfaceInfo.getCaptureTypes().get(0);
                } else {
                    captureType = UseCaseConfigFactory.CaptureType.STREAM_SHARING;
                }
                Intrinsics.checkNotNull(captureType);
                List<UseCaseConfigFactory.CaptureType> captureTypes = attachedSurfaceInfo.getCaptureTypes();
                Intrinsics.checkNotNullExpressionValue(captureTypes, "getCaptureTypes(...)");
                if (!isEligibleCaptureType(captureType, value, captureTypes)) {
                    return false;
                }
            } else if (surfaceConfigIndexUseCaseConfigMap.containsKey(Integer.valueOf(i))) {
                UseCaseConfig<?> useCaseConfig = surfaceConfigIndexUseCaseConfigMap.get(Integer.valueOf(i));
                Intrinsics.checkNotNull(useCaseConfig);
                UseCaseConfig<?> useCaseConfig2 = useCaseConfig;
                UseCaseConfigFactory.CaptureType captureType2 = useCaseConfig2.getCaptureType();
                Intrinsics.checkNotNullExpressionValue(captureType2, "getCaptureType(...)");
                if (useCaseConfig2.getCaptureType() == UseCaseConfigFactory.CaptureType.STREAM_SHARING) {
                    listEmptyList = ((StreamSharingConfig) useCaseConfig2).getCaptureTypes();
                    Intrinsics.checkNotNullExpressionValue(listEmptyList, "getCaptureTypes(...)");
                } else {
                    listEmptyList = CollectionsKt.emptyList();
                }
                if (!isEligibleCaptureType(captureType2, value, listEmptyList)) {
                    return false;
                }
            } else {
                throw new AssertionError("SurfaceConfig does not map to any use case");
            }
        }
        return true;
    }

    public final void populateStreamUseCaseStreamSpecOptionWithSupportedSurfaceConfigs(Map<UseCaseConfig<?>, StreamSpec> suggestedStreamSpecMap, Map<AttachedSurfaceInfo, StreamSpec> attachedSurfaceStreamSpecMap, Map<Integer, ? extends AttachedSurfaceInfo> surfaceConfigIndexAttachedSurfaceInfoMap, Map<Integer, ? extends UseCaseConfig<?>> surfaceConfigIndexUseCaseConfigMap, List<SurfaceConfig> surfaceConfigsWithStreamUseCase) {
        Intrinsics.checkNotNullParameter(suggestedStreamSpecMap, "suggestedStreamSpecMap");
        Intrinsics.checkNotNullParameter(attachedSurfaceStreamSpecMap, "attachedSurfaceStreamSpecMap");
        Intrinsics.checkNotNullParameter(surfaceConfigIndexAttachedSurfaceInfoMap, "surfaceConfigIndexAttachedSurfaceInfoMap");
        Intrinsics.checkNotNullParameter(surfaceConfigIndexUseCaseConfigMap, "surfaceConfigIndexUseCaseConfigMap");
        Intrinsics.checkNotNullParameter(surfaceConfigsWithStreamUseCase, "surfaceConfigsWithStreamUseCase");
        int size = surfaceConfigsWithStreamUseCase.size();
        for (int i = 0; i < size; i++) {
            long value = surfaceConfigsWithStreamUseCase.get(i).getStreamUseCase().getValue();
            if (surfaceConfigIndexAttachedSurfaceInfoMap.containsKey(Integer.valueOf(i))) {
                AttachedSurfaceInfo attachedSurfaceInfo = surfaceConfigIndexAttachedSurfaceInfoMap.get(Integer.valueOf(i));
                Intrinsics.checkNotNull(attachedSurfaceInfo);
                Config implementationOptions = attachedSurfaceInfo.getImplementationOptions();
                Intrinsics.checkNotNull(implementationOptions);
                Config updatedImplementationOptionsWithUseCaseStreamSpecOption = getUpdatedImplementationOptionsWithUseCaseStreamSpecOption(implementationOptions, Long.valueOf(value));
                if (updatedImplementationOptionsWithUseCaseStreamSpecOption != null) {
                    attachedSurfaceStreamSpecMap.put(attachedSurfaceInfo, attachedSurfaceInfo.toStreamSpec(updatedImplementationOptionsWithUseCaseStreamSpecOption));
                }
            } else if (surfaceConfigIndexUseCaseConfigMap.containsKey(Integer.valueOf(i))) {
                UseCaseConfig<?> useCaseConfig = surfaceConfigIndexUseCaseConfigMap.get(Integer.valueOf(i));
                Intrinsics.checkNotNull(useCaseConfig);
                UseCaseConfig<?> useCaseConfig2 = useCaseConfig;
                StreamSpec streamSpec = suggestedStreamSpecMap.get(useCaseConfig2);
                Intrinsics.checkNotNull(streamSpec);
                Config implementationOptions2 = streamSpec.getImplementationOptions();
                Intrinsics.checkNotNull(implementationOptions2);
                Config updatedImplementationOptionsWithUseCaseStreamSpecOption2 = getUpdatedImplementationOptionsWithUseCaseStreamSpecOption(implementationOptions2, Long.valueOf(value));
                if (updatedImplementationOptionsWithUseCaseStreamSpecOption2 != null) {
                    StreamSpec streamSpecBuild = streamSpec.toBuilder().setImplementationOptions(updatedImplementationOptionsWithUseCaseStreamSpecOption2).build();
                    Intrinsics.checkNotNullExpressionValue(streamSpecBuild, "build(...)");
                    suggestedStreamSpecMap.put(useCaseConfig2, streamSpecBuild);
                }
            } else {
                throw new AssertionError("SurfaceConfig does not map to any use case");
            }
        }
    }

    private final Config getUpdatedImplementationOptionsWithUseCaseStreamSpecOption(Config oldImplementationOptions, Long streamUseCase) {
        Config.Option<Long> option = STREAM_USE_CASE_STREAM_SPEC_OPTION;
        if (oldImplementationOptions.containsOption(option) && Intrinsics.areEqual(oldImplementationOptions.retrieveOption(option), streamUseCase)) {
            return null;
        }
        MutableOptionsBundle mutableOptionsBundleFrom = MutableOptionsBundle.from(oldImplementationOptions);
        Intrinsics.checkNotNullExpressionValue(mutableOptionsBundleFrom, "from(...)");
        mutableOptionsBundleFrom.insertOption(option, streamUseCase);
        return new Camera2ImplConfig(mutableOptionsBundleFrom);
    }

    public final boolean containsZslUseCase(List<? extends AttachedSurfaceInfo> attachedSurfaces, List<? extends UseCaseConfig<?>> newUseCaseConfigs) {
        Intrinsics.checkNotNullParameter(attachedSurfaces, "attachedSurfaces");
        Intrinsics.checkNotNullParameter(newUseCaseConfigs, "newUseCaseConfigs");
        for (AttachedSurfaceInfo attachedSurfaceInfo : attachedSurfaces) {
            List<UseCaseConfigFactory.CaptureType> captureTypes = attachedSurfaceInfo.getCaptureTypes();
            Intrinsics.checkNotNullExpressionValue(captureTypes, "getCaptureTypes(...)");
            UseCaseConfigFactory.CaptureType captureType = captureTypes.get(0);
            Config implementationOptions = attachedSurfaceInfo.getImplementationOptions();
            Intrinsics.checkNotNull(implementationOptions);
            Intrinsics.checkNotNull(captureType);
            if (isZslUseCase(implementationOptions, captureType)) {
                return true;
            }
        }
        for (UseCaseConfig<?> useCaseConfig : newUseCaseConfigs) {
            UseCaseConfig<?> useCaseConfig2 = useCaseConfig;
            UseCaseConfigFactory.CaptureType captureType2 = useCaseConfig.getCaptureType();
            Intrinsics.checkNotNullExpressionValue(captureType2, "getCaptureType(...)");
            if (isZslUseCase(useCaseConfig2, captureType2)) {
                return true;
            }
        }
        return false;
    }

    private final boolean isZslUseCase(Config config, UseCaseConfigFactory.CaptureType captureType) {
        Object objRetrieveOption = config.retrieveOption(UseCaseConfig.OPTION_ZSL_DISABLED, false);
        Intrinsics.checkNotNull(objRetrieveOption);
        if (((Boolean) objRetrieveOption).booleanValue() || !config.containsOption(ImageCaptureConfig.OPTION_IMAGE_CAPTURE_MODE)) {
            return false;
        }
        Object objRetrieveOption2 = config.retrieveOption(ImageCaptureConfig.OPTION_IMAGE_CAPTURE_MODE);
        Intrinsics.checkNotNull(objRetrieveOption2);
        return getSessionConfigTemplateType(captureType, ((Number) objRetrieveOption2).intValue()) == 5;
    }

    private final boolean areStreamUseCasesAvailable(Set<Long> availableStreamUseCasesSet, Set<Long> streamUseCases) {
        Iterator<Long> it = streamUseCases.iterator();
        while (it.hasNext()) {
            if (!availableStreamUseCasesSet.contains(Long.valueOf(it.next().longValue()))) {
                return false;
            }
        }
        return true;
    }

    private final void throwInvalidCamera2InteropOverrideException() {
        throw new IllegalArgumentException("Either all use cases must have non-default stream use case assigned or none should have it");
    }

    /* JADX WARN: Code duplicated, block: B:6:0x002a  */
    private final boolean isValidCamera2InteropOverride(List<? extends AttachedSurfaceInfo> attachedSurfaces, List<? extends UseCaseConfig<?>> newUseCaseConfigs, Set<Long> availableStreamUseCases) {
        boolean z;
        boolean z2;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<? extends AttachedSurfaceInfo> it = attachedSurfaces.iterator();
        if (it.hasNext()) {
            AttachedSurfaceInfo next = it.next();
            Config implementationOptions = next.getImplementationOptions();
            Intrinsics.checkNotNull(implementationOptions);
            if (implementationOptions.containsOption(Camera2ImplConfig.STREAM_USE_CASE_OPTION)) {
                Config implementationOptions2 = next.getImplementationOptions();
                Intrinsics.checkNotNull(implementationOptions2);
                Object objRetrieveOption = implementationOptions2.retrieveOption(Camera2ImplConfig.STREAM_USE_CASE_OPTION);
                Intrinsics.checkNotNull(objRetrieveOption);
                if (((Number) objRetrieveOption).longValue() == 0) {
                    z2 = true;
                    z = false;
                } else {
                    z = true;
                    z2 = false;
                }
            } else {
                z2 = true;
                z = false;
            }
        } else {
            z = false;
            z2 = false;
        }
        for (UseCaseConfig<?> useCaseConfig : newUseCaseConfigs) {
            if (useCaseConfig.containsOption(Camera2ImplConfig.STREAM_USE_CASE_OPTION)) {
                Object objRetrieveOption2 = useCaseConfig.retrieveOption(Camera2ImplConfig.STREAM_USE_CASE_OPTION);
                Intrinsics.checkNotNull(objRetrieveOption2);
                long jLongValue = ((Number) objRetrieveOption2).longValue();
                if (jLongValue != 0) {
                    if (z2) {
                        throwInvalidCamera2InteropOverrideException();
                    }
                    linkedHashSet.add(Long.valueOf(jLongValue));
                    z = true;
                } else if (z) {
                    throwInvalidCamera2InteropOverrideException();
                }
            } else if (z) {
                throwInvalidCamera2InteropOverrideException();
            }
            z2 = true;
        }
        return !z2 && areStreamUseCasesAvailable(availableStreamUseCases, linkedHashSet);
    }

    private final int getSessionConfigTemplateType(UseCaseConfigFactory.CaptureType captureType, int captureMode) {
        int i = WhenMappings.$EnumSwitchMapping$0[captureType.ordinal()];
        if (i != 1) {
            return (i == 2 || i == 3) ? 3 : 1;
        }
        return captureMode == 2 ? 5 : 1;
    }
}
