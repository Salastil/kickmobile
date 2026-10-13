package androidx.camera.camera2.compat.workaround;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Size;
import androidx.camera.camera2.adapter.EncoderProfilesProviderAdapter;
import androidx.camera.camera2.compat.StreamConfigurationMapCompat;
import androidx.camera.camera2.compat.quirk.CameraQuirks;
import androidx.camera.camera2.pipe.CameraDevices;
import androidx.camera.camera2.pipe.CameraId;
import androidx.camera.camera2.pipe.CameraMetadata;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.SizeFilteredEncoderProfilesProvider;
import androidx.camera.core.internal.utils.SizeUtil;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EncoderProfilesProviderFallback.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001BA\u00128\b\u0002\u0010\u0002\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\r\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\nH\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\f\u0010\u0016\u001a\u00020\u0011*\u00020\u0013H\u0002J\u0012\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018*\u00020\u0013H\u0002J\u0012\u0010\u001a\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002R>\u0010\u0002\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Landroidx/camera/camera2/compat/workaround/EncoderProfilesProviderFallback;", "", "providerFactory", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "cameraId", "Landroidx/camera/core/impl/Quirks;", "quirks", "Landroidx/camera/core/impl/EncoderProfilesProvider;", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "resolveProvider", "cameraDevices", "Landroidx/camera/camera2/pipe/CameraDevices;", "needFallback", "", "cameraMetadata", "Landroidx/camera/camera2/pipe/CameraMetadata;", "provider", "findProviderWithLargestSize", "isExternalCamera", "getPrivateFormatSizes", "", "Landroid/util/Size;", "getQuirks", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EncoderProfilesProviderFallback {
    private final Function2<String, Quirks, EncoderProfilesProvider> providerFactory;

    /* JADX WARN: Multi-variable type inference failed */
    public EncoderProfilesProviderFallback() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EncoderProfilesProviderFallback(Function2<? super String, ? super Quirks, ? extends EncoderProfilesProvider> providerFactory) {
        Intrinsics.checkNotNullParameter(providerFactory, "providerFactory");
        this.providerFactory = providerFactory;
    }

    public /* synthetic */ EncoderProfilesProviderFallback(Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Function2() { // from class: androidx.camera.camera2.compat.workaround.EncoderProfilesProviderFallback$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return EncoderProfilesProviderFallback._init_$lambda$0((String) obj, (Quirks) obj2);
            }
        } : function2);
    }

    static final EncoderProfilesProviderAdapter _init_$lambda$0(String cameraId, Quirks quirks) {
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        Intrinsics.checkNotNullParameter(quirks, "quirks");
        return new EncoderProfilesProviderAdapter(cameraId, quirks);
    }

    public final EncoderProfilesProvider resolveProvider(String cameraId, Quirks quirks, CameraDevices cameraDevices) {
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        Intrinsics.checkNotNullParameter(quirks, "quirks");
        Intrinsics.checkNotNullParameter(cameraDevices, "cameraDevices");
        EncoderProfilesProvider encoderProfilesProviderInvoke = this.providerFactory.invoke(cameraId, quirks);
        SizeFilteredEncoderProfilesProvider sizeFilteredEncoderProfilesProviderFindProviderWithLargestSize = null;
        CameraMetadata cameraMetadataM312awaitCameraMetadataFpsL5FU$default = CameraDevices.m312awaitCameraMetadataFpsL5FU$default(cameraDevices, CameraId.m427constructorimpl(cameraId), null, 2, null);
        if (cameraMetadataM312awaitCameraMetadataFpsL5FU$default != null) {
            if (needFallback(cameraMetadataM312awaitCameraMetadataFpsL5FU$default, encoderProfilesProviderInvoke) && (sizeFilteredEncoderProfilesProviderFindProviderWithLargestSize = findProviderWithLargestSize(cameraDevices)) != null) {
                sizeFilteredEncoderProfilesProviderFindProviderWithLargestSize = new SizeFilteredEncoderProfilesProvider(sizeFilteredEncoderProfilesProviderFindProviderWithLargestSize, getPrivateFormatSizes(cameraMetadataM312awaitCameraMetadataFpsL5FU$default));
            }
            if (sizeFilteredEncoderProfilesProviderFindProviderWithLargestSize != null) {
                return sizeFilteredEncoderProfilesProviderFindProviderWithLargestSize;
            }
        }
        return encoderProfilesProviderInvoke;
    }

    private final boolean needFallback(CameraMetadata cameraMetadata, EncoderProfilesProvider provider) {
        return isExternalCamera(cameraMetadata) && !provider.hasProfile(1);
    }

    private final EncoderProfilesProvider findProviderWithLargestSize(CameraDevices cameraDevices) {
        Object objM12684constructorimpl;
        List<EncoderProfilesProxy.VideoProfileProxy> videoProfiles;
        EncoderProfilesProxy.VideoProfileProxy videoProfileProxy;
        try {
            Result.Companion companion = Result.INSTANCE;
            EncoderProfilesProviderFallback encoderProfilesProviderFallback = this;
            objM12684constructorimpl = Result.m12684constructorimpl(CameraDevices.m311awaitCameraIdsSeavPBo$default(cameraDevices, null, 1, null));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        List list = (List) objM12684constructorimpl;
        if (list == null) {
            return null;
        }
        Iterator it = list.iterator();
        EncoderProfilesProvider encoderProfilesProvider = null;
        int i = 0;
        while (it.hasNext()) {
            String strM433unboximpl = ((CameraId) it.next()).m433unboximpl();
            EncoderProfilesProvider encoderProfilesProviderInvoke = this.providerFactory.invoke(strM433unboximpl, getQuirks(CameraDevices.m312awaitCameraMetadataFpsL5FU$default(cameraDevices, strM433unboximpl, null, 2, null)));
            EncoderProfilesProxy all = encoderProfilesProviderInvoke.getAll(1);
            int area = (all == null || (videoProfiles = all.getVideoProfiles()) == null || (videoProfileProxy = (EncoderProfilesProxy.VideoProfileProxy) CollectionsKt.firstOrNull((List) videoProfiles)) == null) ? 0 : SizeUtil.getArea(videoProfileProxy.getWidth(), videoProfileProxy.getHeight());
            if (area > i) {
                encoderProfilesProvider = encoderProfilesProviderInvoke;
                i = area;
            }
        }
        return encoderProfilesProvider;
    }

    private final boolean isExternalCamera(CameraMetadata cameraMetadata) {
        CameraCharacteristics.Key LENS_FACING = CameraCharacteristics.LENS_FACING;
        Intrinsics.checkNotNullExpressionValue(LENS_FACING, "LENS_FACING");
        Integer num = (Integer) cameraMetadata.get(LENS_FACING);
        return num != null && num.intValue() == 2;
    }

    private final List<Size> getPrivateFormatSizes(CameraMetadata cameraMetadata) {
        Size[] outputSizes;
        List<Size> list;
        CameraCharacteristics.Key SCALER_STREAM_CONFIGURATION_MAP = CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP;
        Intrinsics.checkNotNullExpressionValue(SCALER_STREAM_CONFIGURATION_MAP, "SCALER_STREAM_CONFIGURATION_MAP");
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraMetadata.get(SCALER_STREAM_CONFIGURATION_MAP);
        return (streamConfigurationMap == null || (outputSizes = streamConfigurationMap.getOutputSizes(34)) == null || (list = ArraysKt.toList(outputSizes)) == null) ? CollectionsKt.emptyList() : list;
    }

    private final Quirks getQuirks(CameraMetadata cameraMetadata) {
        if (cameraMetadata == null) {
            return new Quirks(CollectionsKt.emptyList());
        }
        CameraCharacteristics.Key SCALER_STREAM_CONFIGURATION_MAP = CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP;
        Intrinsics.checkNotNullExpressionValue(SCALER_STREAM_CONFIGURATION_MAP, "SCALER_STREAM_CONFIGURATION_MAP");
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraMetadata.get(SCALER_STREAM_CONFIGURATION_MAP);
        return new CameraQuirks(cameraMetadata, new StreamConfigurationMapCompat(streamConfigurationMap, new OutputSizesCorrector(cameraMetadata, streamConfigurationMap))).getQuirks();
    }
}
