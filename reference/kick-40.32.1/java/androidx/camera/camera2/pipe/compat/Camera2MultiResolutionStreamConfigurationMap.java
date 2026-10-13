package androidx.camera.camera2.pipe.compat;

import android.hardware.camera2.params.MultiResolutionStreamConfigurationMap;
import android.hardware.camera2.params.MultiResolutionStreamInfo;
import androidx.camera.camera2.pipe.CameraMultiResolutionStreamConfigurationMap;
import androidx.camera.camera2.pipe.StreamFormat;
import androidx.compose.foundation.PreferKeepClearNode$$ExternalSyntheticApiModelOutline0;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: Camera2MultiResolutionStreamConfigurationMap.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00072\u0006\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00072\u0006\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0015\u001a\u0004\u0018\u0001H\u0016\"\b\b\u0000\u0010\u0016*\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0019H\u0016¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Landroidx/camera/camera2/pipe/compat/Camera2MultiResolutionStreamConfigurationMap;", "Landroidx/camera/camera2/pipe/CameraMultiResolutionStreamConfigurationMap;", "multiResolutionStreamConfigurationMap", "Landroid/hardware/camera2/params/MultiResolutionStreamConfigurationMap;", "<init>", "(Landroid/hardware/camera2/params/MultiResolutionStreamConfigurationMap;)V", "getOutputFormats", "", "Landroidx/camera/camera2/pipe/StreamFormat;", "getInputFormats", "getOutputInfo", "Landroid/hardware/camera2/params/MultiResolutionStreamInfo;", "format", "getOutputInfo-hNQ4ISI", "(I)Ljava/util/List;", "getInputInfo", "getInputInfo-hNQ4ISI", "isConcurrentReadersSupported", "", "isConcurrentReadersSupported-hNQ4ISI", "(I)Z", "unwrapAs", ExifInterface.GPS_DIRECTION_TRUE, "", "type", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Camera2MultiResolutionStreamConfigurationMap implements CameraMultiResolutionStreamConfigurationMap {
    private final MultiResolutionStreamConfigurationMap multiResolutionStreamConfigurationMap;

    public Camera2MultiResolutionStreamConfigurationMap(MultiResolutionStreamConfigurationMap multiResolutionStreamConfigurationMap) {
        Intrinsics.checkNotNullParameter(multiResolutionStreamConfigurationMap, "multiResolutionStreamConfigurationMap");
        this.multiResolutionStreamConfigurationMap = multiResolutionStreamConfigurationMap;
    }

    @Override // androidx.camera.camera2.pipe.CameraMultiResolutionStreamConfigurationMap
    public List<StreamFormat> getOutputFormats() {
        int[] outputFormats = this.multiResolutionStreamConfigurationMap.getOutputFormats();
        Intrinsics.checkNotNullExpressionValue(outputFormats, "getOutputFormats(...)");
        ArrayList arrayList = new ArrayList(outputFormats.length);
        for (int i : outputFormats) {
            arrayList.add(StreamFormat.m745boximpl(StreamFormat.m746constructorimpl(i)));
        }
        return arrayList;
    }

    @Override // androidx.camera.camera2.pipe.CameraMultiResolutionStreamConfigurationMap
    public List<StreamFormat> getInputFormats() {
        int[] inputFormats = this.multiResolutionStreamConfigurationMap.getInputFormats();
        Intrinsics.checkNotNullExpressionValue(inputFormats, "getInputFormats(...)");
        ArrayList arrayList = new ArrayList(inputFormats.length);
        for (int i : inputFormats) {
            arrayList.add(StreamFormat.m745boximpl(StreamFormat.m746constructorimpl(i)));
        }
        return arrayList;
    }

    @Override // androidx.camera.camera2.pipe.CameraMultiResolutionStreamConfigurationMap
    /* JADX INFO: renamed from: getOutputInfo-hNQ4ISI */
    public List<MultiResolutionStreamInfo> mo448getOutputInfohNQ4ISI(int format) {
        Collection outputInfo = this.multiResolutionStreamConfigurationMap.getOutputInfo(format);
        Intrinsics.checkNotNullExpressionValue(outputInfo, "getOutputInfo(...)");
        return CollectionsKt.toList(outputInfo);
    }

    @Override // androidx.camera.camera2.pipe.CameraMultiResolutionStreamConfigurationMap
    /* JADX INFO: renamed from: getInputInfo-hNQ4ISI */
    public List<MultiResolutionStreamInfo> mo447getInputInfohNQ4ISI(int format) {
        Collection inputInfo = this.multiResolutionStreamConfigurationMap.getInputInfo(format);
        Intrinsics.checkNotNullExpressionValue(inputInfo, "getInputInfo(...)");
        return CollectionsKt.toList(inputInfo);
    }

    @Override // androidx.camera.camera2.pipe.CameraMultiResolutionStreamConfigurationMap
    /* JADX INFO: renamed from: isConcurrentReadersSupported-hNQ4ISI */
    public boolean mo449isConcurrentReadersSupportedhNQ4ISI(int format) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // androidx.camera.camera2.pipe.UnsafeWrapper
    public <T> T unwrapAs(KClass<T> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(PreferKeepClearNode$$ExternalSyntheticApiModelOutline0.m1663m()))) {
            Object obj = this.multiResolutionStreamConfigurationMap;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.camera.camera2.pipe.compat.Camera2MultiResolutionStreamConfigurationMap.unwrapAs");
            return (T) obj;
        }
        if (!Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(Camera2MultiResolutionStreamConfigurationMap.class))) {
            return null;
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.camera.camera2.pipe.compat.Camera2MultiResolutionStreamConfigurationMap.unwrapAs");
        return (T) this;
    }
}
