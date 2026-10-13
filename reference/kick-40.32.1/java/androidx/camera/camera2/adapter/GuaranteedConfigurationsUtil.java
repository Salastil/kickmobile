package androidx.camera.camera2.adapter;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import android.util.Size;
import androidx.camera.camera2.pipe.CameraMetadata;
import androidx.camera.core.impl.StreamUseCase;
import androidx.camera.core.impl.SurfaceCombination;
import androidx.camera.core.impl.SurfaceConfig;
import androidx.camera.core.impl.SurfaceSizeDefinition;
import androidx.camera.core.impl.stabilization.VideoStabilization;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GuaranteedConfigurationsUtil.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007J&\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0007J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007J\u001e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0007J\u000e\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\u000e\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\u001e\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)H\u0002J#\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0000¢\u0006\u0002\b0R!\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\b¨\u00061"}, d2 = {"Landroidx/camera/camera2/adapter/GuaranteedConfigurationsUtil;", "", "<init>", "()V", "QUERYABLE_VIC_FCQ_COMBINATIONS", "", "Landroidx/camera/core/impl/SurfaceCombination;", "getQUERYABLE_VIC_FCQ_COMBINATIONS", "()Ljava/util/List;", "QUERYABLE_VIC_FCQ_COMBINATIONS$delegate", "Lkotlin/Lazy;", "QUERYABLE_BAKLAVA_FCQ_COMBINATIONS", "getQUERYABLE_BAKLAVA_FCQ_COMBINATIONS", "QUERYABLE_BAKLAVA_FCQ_COMBINATIONS$delegate", "getLegacySupportedCombinationList", "getLimitedSupportedCombinationList", "getFullSupportedCombinationList", "getRAWSupportedCombinationList", "getBurstSupportedCombinationList", "getLevel3SupportedCombinationList", "getUltraHighResolutionSupportedCombinationList", "getUltraHdrSupportedCombinationList", "getConcurrentSupportedCombinationList", "generateSupportedCombinationList", "hardwareLevel", "", "isRawSupported", "", "isBurstCaptureSupported", "get10BitSupportedCombinationList", "getStreamUseCaseSupportedCombinationList", "getPreviewStabilizationSupportedCombinationList", "generateHighSpeedSupportedCombinationList", "maxSupportedSize", "Landroid/util/Size;", "surfaceSizeDefinition", "Landroidx/camera/core/impl/SurfaceSizeDefinition;", "generateVicQueryableFcqCombinations", "generateBaklavaQueryableFcqCombinations", "createPrivJpegXCombinations", "privSize", "Landroidx/camera/core/impl/SurfaceConfig$ConfigSize;", "jpegXSize", "getQueryableFcqCombinations", "cameraMetadata", "Landroidx/camera/camera2/pipe/CameraMetadata;", "videoStabilization", "Landroidx/camera/core/impl/stabilization/VideoStabilization;", "getQueryableFcqCombinations$camera_camera2", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GuaranteedConfigurationsUtil {
    public static final GuaranteedConfigurationsUtil INSTANCE = new GuaranteedConfigurationsUtil();

    /* JADX INFO: renamed from: QUERYABLE_VIC_FCQ_COMBINATIONS$delegate, reason: from kotlin metadata */
    private static final Lazy QUERYABLE_VIC_FCQ_COMBINATIONS = LazyKt.lazy(new Function0() { // from class: androidx.camera.camera2.adapter.GuaranteedConfigurationsUtil$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return GuaranteedConfigurationsUtil.INSTANCE.generateVicQueryableFcqCombinations();
        }
    });

    /* JADX INFO: renamed from: QUERYABLE_BAKLAVA_FCQ_COMBINATIONS$delegate, reason: from kotlin metadata */
    private static final Lazy QUERYABLE_BAKLAVA_FCQ_COMBINATIONS = LazyKt.lazy(new Function0() { // from class: androidx.camera.camera2.adapter.GuaranteedConfigurationsUtil$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return GuaranteedConfigurationsUtil.INSTANCE.generateBaklavaQueryableFcqCombinations();
        }
    });

    private GuaranteedConfigurationsUtil() {
    }

    public final List<SurfaceCombination> getQUERYABLE_VIC_FCQ_COMBINATIONS() {
        return (List) QUERYABLE_VIC_FCQ_COMBINATIONS.getValue();
    }

    public final List<SurfaceCombination> getQUERYABLE_BAKLAVA_FCQ_COMBINATIONS() {
        return (List) QUERYABLE_BAKLAVA_FCQ_COMBINATIONS.getValue();
    }

    @JvmStatic
    public static final List<SurfaceCombination> getLegacySupportedCombinationList() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        surfaceCombination.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
        arrayList.add(surfaceCombination);
        SurfaceCombination surfaceCombination2 = new SurfaceCombination();
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.JPEG, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
        arrayList.add(surfaceCombination2);
        SurfaceCombination surfaceCombination3 = new SurfaceCombination();
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
        arrayList.add(surfaceCombination3);
        SurfaceCombination surfaceCombination4 = new SurfaceCombination();
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.JPEG, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
        arrayList.add(surfaceCombination4);
        SurfaceCombination surfaceCombination5 = new SurfaceCombination();
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.JPEG, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
        arrayList.add(surfaceCombination5);
        SurfaceCombination surfaceCombination6 = new SurfaceCombination();
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        arrayList.add(surfaceCombination6);
        SurfaceCombination surfaceCombination7 = new SurfaceCombination();
        surfaceCombination7.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination7.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        arrayList.add(surfaceCombination7);
        SurfaceCombination surfaceCombination8 = new SurfaceCombination();
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.JPEG, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
        arrayList.add(surfaceCombination8);
        return arrayList;
    }

    @JvmStatic
    public static final List<SurfaceCombination> getLimitedSupportedCombinationList() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        surfaceCombination.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.RECORD, null, 4, null));
        arrayList.add(surfaceCombination);
        SurfaceCombination surfaceCombination2 = new SurfaceCombination();
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.RECORD, null, 4, null));
        arrayList.add(surfaceCombination2);
        SurfaceCombination surfaceCombination3 = new SurfaceCombination();
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.RECORD, null, 4, null));
        arrayList.add(surfaceCombination3);
        SurfaceCombination surfaceCombination4 = new SurfaceCombination();
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.RECORD, null, 4, null));
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.JPEG, SurfaceConfig.ConfigSize.RECORD, null, 4, null));
        arrayList.add(surfaceCombination4);
        SurfaceCombination surfaceCombination5 = new SurfaceCombination();
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.RECORD, null, 4, null));
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.JPEG, SurfaceConfig.ConfigSize.RECORD, null, 4, null));
        arrayList.add(surfaceCombination5);
        SurfaceCombination surfaceCombination6 = new SurfaceCombination();
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.JPEG, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
        arrayList.add(surfaceCombination6);
        return arrayList;
    }

    @JvmStatic
    public static final List<SurfaceCombination> getFullSupportedCombinationList() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        surfaceCombination.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
        arrayList.add(surfaceCombination);
        SurfaceCombination surfaceCombination2 = new SurfaceCombination();
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
        arrayList.add(surfaceCombination2);
        SurfaceCombination surfaceCombination3 = new SurfaceCombination();
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
        arrayList.add(surfaceCombination3);
        SurfaceCombination surfaceCombination4 = new SurfaceCombination();
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.JPEG, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
        arrayList.add(surfaceCombination4);
        SurfaceCombination surfaceCombination5 = new SurfaceCombination();
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.VGA, null, 4, null));
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
        arrayList.add(surfaceCombination5);
        SurfaceCombination surfaceCombination6 = new SurfaceCombination();
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.VGA, null, 4, null));
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
        arrayList.add(surfaceCombination6);
        return arrayList;
    }

    @JvmStatic
    public static final List<SurfaceCombination> getRAWSupportedCombinationList() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        surfaceCombination.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.RAW, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
        arrayList.add(surfaceCombination);
        SurfaceCombination surfaceCombination2 = new SurfaceCombination();
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.RAW, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
        arrayList.add(surfaceCombination2);
        SurfaceCombination surfaceCombination3 = new SurfaceCombination();
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.RAW, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
        arrayList.add(surfaceCombination3);
        SurfaceCombination surfaceCombination4 = new SurfaceCombination();
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.RAW, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
        arrayList.add(surfaceCombination4);
        SurfaceCombination surfaceCombination5 = new SurfaceCombination();
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.RAW, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
        arrayList.add(surfaceCombination5);
        SurfaceCombination surfaceCombination6 = new SurfaceCombination();
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.RAW, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
        arrayList.add(surfaceCombination6);
        SurfaceCombination surfaceCombination7 = new SurfaceCombination();
        surfaceCombination7.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination7.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.JPEG, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
        surfaceCombination7.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.RAW, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
        arrayList.add(surfaceCombination7);
        SurfaceCombination surfaceCombination8 = new SurfaceCombination();
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.JPEG, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.RAW, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
        arrayList.add(surfaceCombination8);
        return arrayList;
    }

    @JvmStatic
    public static final List<SurfaceCombination> getBurstSupportedCombinationList() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        surfaceCombination.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
        arrayList.add(surfaceCombination);
        SurfaceCombination surfaceCombination2 = new SurfaceCombination();
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
        arrayList.add(surfaceCombination2);
        SurfaceCombination surfaceCombination3 = new SurfaceCombination();
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
        arrayList.add(surfaceCombination3);
        return arrayList;
    }

    @JvmStatic
    public static final List<SurfaceCombination> getLevel3SupportedCombinationList() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        surfaceCombination.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.VGA, null, 4, null));
        surfaceCombination.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
        surfaceCombination.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.RAW, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
        arrayList.add(surfaceCombination);
        SurfaceCombination surfaceCombination2 = new SurfaceCombination();
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.VGA, null, 4, null));
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.JPEG, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.RAW, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
        arrayList.add(surfaceCombination2);
        return arrayList;
    }

    @JvmStatic
    public static final List<SurfaceCombination> getUltraHighResolutionSupportedCombinationList() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        surfaceCombination.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.ULTRA_MAXIMUM, null, 4, null));
        surfaceCombination.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.RECORD, null, 4, null));
        arrayList.add(surfaceCombination);
        SurfaceCombination surfaceCombination2 = new SurfaceCombination();
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.JPEG, SurfaceConfig.ConfigSize.ULTRA_MAXIMUM, null, 4, null));
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.RECORD, null, 4, null));
        arrayList.add(surfaceCombination2);
        SurfaceCombination surfaceCombination3 = new SurfaceCombination();
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.RAW, SurfaceConfig.ConfigSize.ULTRA_MAXIMUM, null, 4, null));
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.RECORD, null, 4, null));
        arrayList.add(surfaceCombination3);
        SurfaceCombination surfaceCombination4 = new SurfaceCombination();
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.ULTRA_MAXIMUM, null, 4, null));
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.JPEG, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
        arrayList.add(surfaceCombination4);
        SurfaceCombination surfaceCombination5 = new SurfaceCombination();
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.JPEG, SurfaceConfig.ConfigSize.ULTRA_MAXIMUM, null, 4, null));
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.JPEG, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
        arrayList.add(surfaceCombination5);
        SurfaceCombination surfaceCombination6 = new SurfaceCombination();
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.RAW, SurfaceConfig.ConfigSize.ULTRA_MAXIMUM, null, 4, null));
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.JPEG, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
        arrayList.add(surfaceCombination6);
        SurfaceCombination surfaceCombination7 = new SurfaceCombination();
        surfaceCombination7.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.ULTRA_MAXIMUM, null, 4, null));
        surfaceCombination7.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination7.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
        arrayList.add(surfaceCombination7);
        SurfaceCombination surfaceCombination8 = new SurfaceCombination();
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.JPEG, SurfaceConfig.ConfigSize.ULTRA_MAXIMUM, null, 4, null));
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
        arrayList.add(surfaceCombination8);
        SurfaceCombination surfaceCombination9 = new SurfaceCombination();
        surfaceCombination9.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.RAW, SurfaceConfig.ConfigSize.ULTRA_MAXIMUM, null, 4, null));
        surfaceCombination9.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination9.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
        arrayList.add(surfaceCombination9);
        SurfaceCombination surfaceCombination10 = new SurfaceCombination();
        surfaceCombination10.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.ULTRA_MAXIMUM, null, 4, null));
        surfaceCombination10.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination10.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.RAW, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
        arrayList.add(surfaceCombination10);
        SurfaceCombination surfaceCombination11 = new SurfaceCombination();
        surfaceCombination11.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.JPEG, SurfaceConfig.ConfigSize.ULTRA_MAXIMUM, null, 4, null));
        surfaceCombination11.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination11.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.RAW, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
        arrayList.add(surfaceCombination11);
        SurfaceCombination surfaceCombination12 = new SurfaceCombination();
        surfaceCombination12.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.RAW, SurfaceConfig.ConfigSize.ULTRA_MAXIMUM, null, 4, null));
        surfaceCombination12.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination12.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.RAW, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
        arrayList.add(surfaceCombination12);
        return arrayList;
    }

    @JvmStatic
    public static final List<SurfaceCombination> getUltraHdrSupportedCombinationList() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        surfaceCombination.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.JPEG_R, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
        arrayList.add(surfaceCombination);
        SurfaceCombination surfaceCombination2 = new SurfaceCombination();
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.JPEG_R, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
        arrayList.add(surfaceCombination2);
        return arrayList;
    }

    @JvmStatic
    public static final List<SurfaceCombination> getConcurrentSupportedCombinationList() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        surfaceCombination.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.S1440P_4_3, null, 4, null));
        arrayList.add(surfaceCombination);
        SurfaceCombination surfaceCombination2 = new SurfaceCombination();
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.S1440P_4_3, null, 4, null));
        arrayList.add(surfaceCombination2);
        SurfaceCombination surfaceCombination3 = new SurfaceCombination();
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.JPEG, SurfaceConfig.ConfigSize.S1440P_4_3, null, 4, null));
        arrayList.add(surfaceCombination3);
        SurfaceCombination surfaceCombination4 = new SurfaceCombination();
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.S720P_16_9, null, 4, null));
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.JPEG, SurfaceConfig.ConfigSize.S1440P_4_3, null, 4, null));
        arrayList.add(surfaceCombination4);
        SurfaceCombination surfaceCombination5 = new SurfaceCombination();
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.S720P_16_9, null, 4, null));
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.JPEG, SurfaceConfig.ConfigSize.S1440P_4_3, null, 4, null));
        arrayList.add(surfaceCombination5);
        SurfaceCombination surfaceCombination6 = new SurfaceCombination();
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.S720P_16_9, null, 4, null));
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.S1440P_4_3, null, 4, null));
        arrayList.add(surfaceCombination6);
        SurfaceCombination surfaceCombination7 = new SurfaceCombination();
        surfaceCombination7.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.S720P_16_9, null, 4, null));
        surfaceCombination7.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.S1440P_4_3, null, 4, null));
        arrayList.add(surfaceCombination7);
        SurfaceCombination surfaceCombination8 = new SurfaceCombination();
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.S720P_16_9, null, 4, null));
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.S1440P_4_3, null, 4, null));
        arrayList.add(surfaceCombination8);
        SurfaceCombination surfaceCombination9 = new SurfaceCombination();
        surfaceCombination9.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.S720P_16_9, null, 4, null));
        surfaceCombination9.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.S1440P_4_3, null, 4, null));
        arrayList.add(surfaceCombination9);
        return arrayList;
    }

    @JvmStatic
    public static final List<SurfaceCombination> generateSupportedCombinationList(int hardwareLevel, boolean isRawSupported, boolean isBurstCaptureSupported) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(getLegacySupportedCombinationList());
        if (hardwareLevel == 0 || hardwareLevel == 1 || hardwareLevel == 3 || hardwareLevel == 4) {
            arrayList.addAll(getLimitedSupportedCombinationList());
        }
        if (hardwareLevel == 1 || hardwareLevel == 3) {
            arrayList.addAll(getFullSupportedCombinationList());
        }
        if (isRawSupported) {
            arrayList.addAll(getRAWSupportedCombinationList());
        }
        if (isBurstCaptureSupported && hardwareLevel == 0) {
            arrayList.addAll(getBurstSupportedCombinationList());
        }
        if (hardwareLevel == 3) {
            arrayList.addAll(getLevel3SupportedCombinationList());
        }
        return arrayList;
    }

    @JvmStatic
    public static final List<SurfaceCombination> get10BitSupportedCombinationList() {
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        surfaceCombination.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
        Unit unit = Unit.INSTANCE;
        SurfaceCombination surfaceCombination2 = new SurfaceCombination();
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
        Unit unit2 = Unit.INSTANCE;
        SurfaceCombination surfaceCombination3 = new SurfaceCombination();
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.JPEG, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
        Unit unit3 = Unit.INSTANCE;
        SurfaceCombination surfaceCombination4 = new SurfaceCombination();
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
        Unit unit4 = Unit.INSTANCE;
        SurfaceCombination surfaceCombination5 = new SurfaceCombination();
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
        Unit unit5 = Unit.INSTANCE;
        SurfaceCombination surfaceCombination6 = new SurfaceCombination();
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.RECORD, null, 4, null));
        Unit unit6 = Unit.INSTANCE;
        SurfaceCombination surfaceCombination7 = new SurfaceCombination();
        surfaceCombination7.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination7.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.RECORD, null, 4, null));
        surfaceCombination7.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.RECORD, null, 4, null));
        Unit unit7 = Unit.INSTANCE;
        SurfaceCombination surfaceCombination8 = new SurfaceCombination();
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.RECORD, null, 4, null));
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.JPEG, SurfaceConfig.ConfigSize.RECORD, null, 4, null));
        Unit unit8 = Unit.INSTANCE;
        return CollectionsKt.listOf((Object[]) new SurfaceCombination[]{surfaceCombination, surfaceCombination2, surfaceCombination3, surfaceCombination4, surfaceCombination5, surfaceCombination6, surfaceCombination7, surfaceCombination8});
    }

    public final List<SurfaceCombination> getStreamUseCaseSupportedCombinationList() {
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        surfaceCombination.addSurfaceConfig(SurfaceConfig.INSTANCE.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.S1440P_4_3, StreamUseCase.PREVIEW_VIDEO_STILL));
        Unit unit = Unit.INSTANCE;
        SurfaceCombination surfaceCombination2 = new SurfaceCombination();
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.INSTANCE.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.S1440P_4_3, StreamUseCase.PREVIEW_VIDEO_STILL));
        Unit unit2 = Unit.INSTANCE;
        SurfaceCombination surfaceCombination3 = new SurfaceCombination();
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.INSTANCE.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.RECORD, StreamUseCase.VIDEO_RECORD));
        Unit unit3 = Unit.INSTANCE;
        SurfaceCombination surfaceCombination4 = new SurfaceCombination();
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.INSTANCE.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.RECORD, StreamUseCase.VIDEO_RECORD));
        Unit unit4 = Unit.INSTANCE;
        SurfaceCombination surfaceCombination5 = new SurfaceCombination();
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.INSTANCE.create(SurfaceConfig.ConfigType.JPEG, SurfaceConfig.ConfigSize.MAXIMUM, StreamUseCase.STILL_CAPTURE));
        Unit unit5 = Unit.INSTANCE;
        SurfaceCombination surfaceCombination6 = new SurfaceCombination();
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.INSTANCE.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.MAXIMUM, StreamUseCase.STILL_CAPTURE));
        Unit unit6 = Unit.INSTANCE;
        SurfaceCombination surfaceCombination7 = new SurfaceCombination();
        surfaceCombination7.addSurfaceConfig(SurfaceConfig.INSTANCE.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, StreamUseCase.PREVIEW));
        surfaceCombination7.addSurfaceConfig(SurfaceConfig.INSTANCE.create(SurfaceConfig.ConfigType.JPEG, SurfaceConfig.ConfigSize.MAXIMUM, StreamUseCase.STILL_CAPTURE));
        Unit unit7 = Unit.INSTANCE;
        SurfaceCombination surfaceCombination8 = new SurfaceCombination();
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.INSTANCE.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, StreamUseCase.PREVIEW));
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.INSTANCE.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.MAXIMUM, StreamUseCase.STILL_CAPTURE));
        Unit unit8 = Unit.INSTANCE;
        SurfaceCombination surfaceCombination9 = new SurfaceCombination();
        surfaceCombination9.addSurfaceConfig(SurfaceConfig.INSTANCE.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, StreamUseCase.PREVIEW));
        surfaceCombination9.addSurfaceConfig(SurfaceConfig.INSTANCE.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.RECORD, StreamUseCase.VIDEO_RECORD));
        Unit unit9 = Unit.INSTANCE;
        SurfaceCombination surfaceCombination10 = new SurfaceCombination();
        surfaceCombination10.addSurfaceConfig(SurfaceConfig.INSTANCE.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, StreamUseCase.PREVIEW));
        surfaceCombination10.addSurfaceConfig(SurfaceConfig.INSTANCE.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.RECORD, StreamUseCase.VIDEO_RECORD));
        Unit unit10 = Unit.INSTANCE;
        SurfaceCombination surfaceCombination11 = new SurfaceCombination();
        surfaceCombination11.addSurfaceConfig(SurfaceConfig.INSTANCE.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, StreamUseCase.PREVIEW));
        surfaceCombination11.addSurfaceConfig(SurfaceConfig.INSTANCE.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.PREVIEW, StreamUseCase.PREVIEW));
        Unit unit11 = Unit.INSTANCE;
        SurfaceCombination surfaceCombination12 = new SurfaceCombination();
        surfaceCombination12.addSurfaceConfig(SurfaceConfig.INSTANCE.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, StreamUseCase.PREVIEW));
        surfaceCombination12.addSurfaceConfig(SurfaceConfig.INSTANCE.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.RECORD, StreamUseCase.VIDEO_RECORD));
        surfaceCombination12.addSurfaceConfig(SurfaceConfig.INSTANCE.create(SurfaceConfig.ConfigType.JPEG, SurfaceConfig.ConfigSize.RECORD, StreamUseCase.STILL_CAPTURE));
        Unit unit12 = Unit.INSTANCE;
        SurfaceCombination surfaceCombination13 = new SurfaceCombination();
        surfaceCombination13.addSurfaceConfig(SurfaceConfig.INSTANCE.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, StreamUseCase.PREVIEW));
        surfaceCombination13.addSurfaceConfig(SurfaceConfig.INSTANCE.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.RECORD, StreamUseCase.VIDEO_RECORD));
        surfaceCombination13.addSurfaceConfig(SurfaceConfig.INSTANCE.create(SurfaceConfig.ConfigType.JPEG, SurfaceConfig.ConfigSize.RECORD, StreamUseCase.STILL_CAPTURE));
        Unit unit13 = Unit.INSTANCE;
        SurfaceCombination surfaceCombination14 = new SurfaceCombination();
        surfaceCombination14.addSurfaceConfig(SurfaceConfig.INSTANCE.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, StreamUseCase.PREVIEW));
        surfaceCombination14.addSurfaceConfig(SurfaceConfig.INSTANCE.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.PREVIEW, StreamUseCase.PREVIEW));
        surfaceCombination14.addSurfaceConfig(SurfaceConfig.INSTANCE.create(SurfaceConfig.ConfigType.JPEG, SurfaceConfig.ConfigSize.MAXIMUM, StreamUseCase.STILL_CAPTURE));
        Unit unit14 = Unit.INSTANCE;
        return CollectionsKt.listOf((Object[]) new SurfaceCombination[]{surfaceCombination, surfaceCombination2, surfaceCombination3, surfaceCombination4, surfaceCombination5, surfaceCombination6, surfaceCombination7, surfaceCombination8, surfaceCombination9, surfaceCombination10, surfaceCombination11, surfaceCombination12, surfaceCombination13, surfaceCombination14});
    }

    @JvmStatic
    public static final List<SurfaceCombination> getPreviewStabilizationSupportedCombinationList() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        surfaceCombination.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.S1440P_4_3, null, 4, null));
        arrayList.add(surfaceCombination);
        SurfaceCombination surfaceCombination2 = new SurfaceCombination();
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.S1440P_4_3, null, 4, null));
        arrayList.add(surfaceCombination2);
        SurfaceCombination surfaceCombination3 = new SurfaceCombination();
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.S1440P_4_3, null, 4, null));
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.JPEG, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
        arrayList.add(surfaceCombination3);
        SurfaceCombination surfaceCombination4 = new SurfaceCombination();
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.S1440P_4_3, null, 4, null));
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.JPEG, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
        arrayList.add(surfaceCombination4);
        SurfaceCombination surfaceCombination5 = new SurfaceCombination();
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.S1440P_4_3, null, 4, null));
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
        arrayList.add(surfaceCombination5);
        SurfaceCombination surfaceCombination6 = new SurfaceCombination();
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.S1440P_4_3, null, 4, null));
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.MAXIMUM, null, 4, null));
        arrayList.add(surfaceCombination6);
        SurfaceCombination surfaceCombination7 = new SurfaceCombination();
        surfaceCombination7.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination7.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.S1440P_4_3, null, 4, null));
        arrayList.add(surfaceCombination7);
        SurfaceCombination surfaceCombination8 = new SurfaceCombination();
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.S1440P_4_3, null, 4, null));
        arrayList.add(surfaceCombination8);
        SurfaceCombination surfaceCombination9 = new SurfaceCombination();
        surfaceCombination9.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination9.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.S1440P_4_3, null, 4, null));
        arrayList.add(surfaceCombination9);
        SurfaceCombination surfaceCombination10 = new SurfaceCombination();
        surfaceCombination10.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.PREVIEW, null, 4, null));
        surfaceCombination10.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.S1440P_4_3, null, 4, null));
        arrayList.add(surfaceCombination10);
        return arrayList;
    }

    @JvmStatic
    public static final List<SurfaceCombination> generateHighSpeedSupportedCombinationList(Size maxSupportedSize, SurfaceSizeDefinition surfaceSizeDefinition) {
        Intrinsics.checkNotNullParameter(maxSupportedSize, "maxSupportedSize");
        Intrinsics.checkNotNullParameter(surfaceSizeDefinition, "surfaceSizeDefinition");
        ArrayList arrayList = new ArrayList();
        SurfaceConfig surfaceConfigTransformSurfaceConfig$default = SurfaceConfig.Companion.transformSurfaceConfig$default(SurfaceConfig.INSTANCE, 34, maxSupportedSize, surfaceSizeDefinition, 0, null, null, 56, null);
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        surfaceCombination.addSurfaceConfig(surfaceConfigTransformSurfaceConfig$default);
        arrayList.add(surfaceCombination);
        SurfaceCombination surfaceCombination2 = new SurfaceCombination();
        surfaceCombination2.addSurfaceConfig(surfaceConfigTransformSurfaceConfig$default);
        surfaceCombination2.addSurfaceConfig(surfaceConfigTransformSurfaceConfig$default);
        arrayList.add(surfaceCombination2);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<SurfaceCombination> generateVicQueryableFcqCombinations() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        surfaceCombination.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.S1080P_16_9, null, 4, null));
        arrayList.add(surfaceCombination);
        SurfaceCombination surfaceCombination2 = new SurfaceCombination();
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.S720P_16_9, null, 4, null));
        arrayList.add(surfaceCombination2);
        arrayList.addAll(createPrivJpegXCombinations(SurfaceConfig.ConfigSize.S1080P_16_9, SurfaceConfig.ConfigSize.MAXIMUM_16_9));
        arrayList.addAll(createPrivJpegXCombinations(SurfaceConfig.ConfigSize.S1080P_16_9, SurfaceConfig.ConfigSize.UHD));
        arrayList.addAll(createPrivJpegXCombinations(SurfaceConfig.ConfigSize.S1080P_16_9, SurfaceConfig.ConfigSize.S1440P_16_9));
        arrayList.addAll(createPrivJpegXCombinations(SurfaceConfig.ConfigSize.S1080P_16_9, SurfaceConfig.ConfigSize.S1080P_16_9));
        arrayList.addAll(createPrivJpegXCombinations(SurfaceConfig.ConfigSize.S720P_16_9, SurfaceConfig.ConfigSize.MAXIMUM_16_9));
        arrayList.addAll(createPrivJpegXCombinations(SurfaceConfig.ConfigSize.S720P_16_9, SurfaceConfig.ConfigSize.UHD));
        arrayList.addAll(createPrivJpegXCombinations(SurfaceConfig.ConfigSize.S720P_16_9, SurfaceConfig.ConfigSize.S1080P_16_9));
        arrayList.addAll(createPrivJpegXCombinations(SurfaceConfig.ConfigSize.X_VGA, SurfaceConfig.ConfigSize.MAXIMUM_4_3));
        arrayList.addAll(createPrivJpegXCombinations(SurfaceConfig.ConfigSize.S1080P_4_3, SurfaceConfig.ConfigSize.MAXIMUM_4_3));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<SurfaceCombination> generateBaklavaQueryableFcqCombinations() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        surfaceCombination.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.S1080P_16_9, null, 4, null));
        surfaceCombination.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.S1080P_16_9, null, 4, null));
        arrayList.add(surfaceCombination);
        SurfaceCombination surfaceCombination2 = new SurfaceCombination();
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.S1080P_16_9, null, 4, null));
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.S1440P_16_9, null, 4, null));
        arrayList.add(surfaceCombination2);
        SurfaceCombination surfaceCombination3 = new SurfaceCombination();
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.S1080P_16_9, null, 4, null));
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.UHD, null, 4, null));
        arrayList.add(surfaceCombination3);
        SurfaceCombination surfaceCombination4 = new SurfaceCombination();
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.S1080P_16_9, null, 4, null));
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.S1080P_16_9, null, 4, null));
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.S1080P_16_9, null, 4, null));
        arrayList.add(surfaceCombination4);
        return arrayList;
    }

    private final List<SurfaceCombination> createPrivJpegXCombinations(SurfaceConfig.ConfigSize privSize, SurfaceConfig.ConfigSize jpegXSize) {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        surfaceCombination.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, privSize, null, 4, null));
        surfaceCombination.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.JPEG, jpegXSize, null, 4, null));
        arrayList.add(surfaceCombination);
        SurfaceCombination surfaceCombination2 = new SurfaceCombination();
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.PRIV, privSize, null, 4, null));
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.Companion.create$default(SurfaceConfig.INSTANCE, SurfaceConfig.ConfigType.JPEG_R, jpegXSize, null, 4, null));
        arrayList.add(surfaceCombination2);
        return arrayList;
    }

    public final List<SurfaceCombination> getQueryableFcqCombinations$camera_camera2(CameraMetadata cameraMetadata, VideoStabilization videoStabilization) {
        Intrinsics.checkNotNullParameter(cameraMetadata, "cameraMetadata");
        Intrinsics.checkNotNullParameter(videoStabilization, "videoStabilization");
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 35) {
            CameraCharacteristics.Key INFO_SESSION_CONFIGURATION_QUERY_VERSION = CameraCharacteristics.INFO_SESSION_CONFIGURATION_QUERY_VERSION;
            Intrinsics.checkNotNullExpressionValue(INFO_SESSION_CONFIGURATION_QUERY_VERSION, "INFO_SESSION_CONFIGURATION_QUERY_VERSION");
            Object obj = cameraMetadata.get((CameraCharacteristics.Key<Object>) INFO_SESSION_CONFIGURATION_QUERY_VERSION);
            if (obj != null) {
                int iIntValue = ((Number) obj).intValue();
                if (iIntValue >= 35 && videoStabilization != VideoStabilization.ON) {
                    arrayList.addAll(getQUERYABLE_VIC_FCQ_COMBINATIONS());
                }
                if (iIntValue >= 36 && videoStabilization != VideoStabilization.PREVIEW) {
                    arrayList.addAll(getQUERYABLE_BAKLAVA_FCQ_COMBINATIONS());
                    return arrayList;
                }
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
        return arrayList;
    }
}
