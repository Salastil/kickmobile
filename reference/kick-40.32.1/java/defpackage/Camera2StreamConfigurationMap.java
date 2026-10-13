package defpackage;

import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import androidx.camera.camera2.pipe.CameraStreamConfigurationMap;
import androidx.camera.camera2.pipe.StreamFormat;
import androidx.exifinterface.media.ExifInterface;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: Camera2StreamConfigurationMap.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00072\u0006\u0010\u0010\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0011\u0010\fJ\u0017\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001c\u0010\u0012\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0018H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\"\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007\"\u0004\b\u0000\u0010\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0018H\u0016J\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00072\u0006\u0010\u0010\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001c\u0010\fJ\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007H\u0016J\u001c\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u00072\u0006\u0010!\u001a\u00020\u000fH\u0016J\u0014\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u0007H\u0016J\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00072\f\u0010$\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0016J\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00072\u0006\u0010\u0010\u001a\u00020\bH\u0016¢\u0006\u0004\b&\u0010\fJ\u001f\u0010'\u001a\u00020(2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u000fH\u0016¢\u0006\u0004\b)\u0010*J$\u0010'\u001a\u00020(\"\u0004\b\u0000\u0010\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u00182\u0006\u0010!\u001a\u00020\u000fH\u0016J\u001f\u0010+\u001a\u00020(2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u000fH\u0016¢\u0006\u0004\b,\u0010*J$\u0010+\u001a\u00020(\"\u0004\b\u0000\u0010\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u00182\u0006\u0010!\u001a\u00020\u000fH\u0016J'\u0010-\u001a\u0004\u0018\u0001H\u0016\"\b\b\u0000\u0010\u0016*\u00020.2\f\u0010/\u001a\b\u0012\u0004\u0012\u0002H\u001600H\u0016¢\u0006\u0002\u00101J\b\u00102\u001a\u000203H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"LCamera2StreamConfigurationMap;", "Landroidx/camera/camera2/pipe/CameraStreamConfigurationMap;", "streamConfigurationMap", "Landroid/hardware/camera2/params/StreamConfigurationMap;", "<init>", "(Landroid/hardware/camera2/params/StreamConfigurationMap;)V", "getOutputFormats", "", "Landroidx/camera/camera2/pipe/StreamFormat;", "getValidOutputFormatsForInput", "inputFormat", "getValidOutputFormatsForInput-hNQ4ISI", "(I)Ljava/util/List;", "getInputFormats", "getInputSizes", "Landroid/util/Size;", "format", "getInputSizes-hNQ4ISI", "isOutputSupportedFor", "", "isOutputSupportedFor-hNQ4ISI", "(I)Z", ExifInterface.GPS_DIRECTION_TRUE, "klass", "Ljava/lang/Class;", "surface", "Landroid/view/Surface;", "getOutputSizes", "getOutputSizes-hNQ4ISI", "getHighSpeedVideoSizes", "getHighSpeedVideoFpsRangesFor", "Landroid/util/Range;", "", ContentDisposition.Parameters.Size, "getHighSpeedVideoFpsRanges", "getHighSpeedVideoSizesFor", "fpsRange", "getHighResolutionOutputSizes", "getHighResolutionOutputSizes-hNQ4ISI", "getOutputMinFrameDuration", "", "getOutputMinFrameDuration-lomOqCM", "(ILandroid/util/Size;)J", "getOutputStallDuration", "getOutputStallDuration-lomOqCM", "unwrapAs", "", "type", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "toString", "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Camera2StreamConfigurationMap implements CameraStreamConfigurationMap {
    private final StreamConfigurationMap streamConfigurationMap;

    public Camera2StreamConfigurationMap(StreamConfigurationMap streamConfigurationMap) {
        Intrinsics.checkNotNullParameter(streamConfigurationMap, "streamConfigurationMap");
        this.streamConfigurationMap = streamConfigurationMap;
    }

    @Override // androidx.camera.camera2.pipe.CameraStreamConfigurationMap
    public List<StreamFormat> getOutputFormats() {
        int[] outputFormats = this.streamConfigurationMap.getOutputFormats();
        Intrinsics.checkNotNullExpressionValue(outputFormats, "getOutputFormats(...)");
        ArrayList arrayList = new ArrayList(outputFormats.length);
        for (int i : outputFormats) {
            arrayList.add(StreamFormat.m745boximpl(StreamFormat.m746constructorimpl(i)));
        }
        return arrayList;
    }

    @Override // androidx.camera.camera2.pipe.CameraStreamConfigurationMap
    /* JADX INFO: renamed from: getValidOutputFormatsForInput-hNQ4ISI, reason: not valid java name */
    public List<StreamFormat> mo5getValidOutputFormatsForInputhNQ4ISI(int inputFormat) {
        int[] validOutputFormatsForInput = this.streamConfigurationMap.getValidOutputFormatsForInput(inputFormat);
        Intrinsics.checkNotNullExpressionValue(validOutputFormatsForInput, "getValidOutputFormatsForInput(...)");
        ArrayList arrayList = new ArrayList(validOutputFormatsForInput.length);
        for (int i : validOutputFormatsForInput) {
            arrayList.add(StreamFormat.m745boximpl(StreamFormat.m746constructorimpl(i)));
        }
        return arrayList;
    }

    @Override // androidx.camera.camera2.pipe.CameraStreamConfigurationMap
    public List<StreamFormat> getInputFormats() {
        int[] inputFormats = this.streamConfigurationMap.getInputFormats();
        Intrinsics.checkNotNullExpressionValue(inputFormats, "getInputFormats(...)");
        ArrayList arrayList = new ArrayList(inputFormats.length);
        for (int i : inputFormats) {
            arrayList.add(StreamFormat.m745boximpl(StreamFormat.m746constructorimpl(i)));
        }
        return arrayList;
    }

    @Override // androidx.camera.camera2.pipe.CameraStreamConfigurationMap
    /* JADX INFO: renamed from: getInputSizes-hNQ4ISI, reason: not valid java name */
    public List<Size> mo1getInputSizeshNQ4ISI(int format) {
        List<Size> list;
        Size[] inputSizes = this.streamConfigurationMap.getInputSizes(format);
        return (inputSizes == null || (list = ArraysKt.toList(inputSizes)) == null) ? CollectionsKt.emptyList() : list;
    }

    @Override // androidx.camera.camera2.pipe.CameraStreamConfigurationMap
    /* JADX INFO: renamed from: isOutputSupportedFor-hNQ4ISI, reason: not valid java name */
    public boolean mo6isOutputSupportedForhNQ4ISI(int format) {
        return this.streamConfigurationMap.isOutputSupportedFor(format);
    }

    @Override // androidx.camera.camera2.pipe.CameraStreamConfigurationMap
    public <T> boolean isOutputSupportedFor(Class<T> klass) {
        Intrinsics.checkNotNullParameter(klass, "klass");
        return StreamConfigurationMap.isOutputSupportedFor(klass);
    }

    @Override // androidx.camera.camera2.pipe.CameraStreamConfigurationMap
    public boolean isOutputSupportedFor(Surface surface) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        return this.streamConfigurationMap.isOutputSupportedFor(surface);
    }

    @Override // androidx.camera.camera2.pipe.CameraStreamConfigurationMap
    public <T> List<Size> getOutputSizes(Class<T> klass) {
        List<Size> list;
        Intrinsics.checkNotNullParameter(klass, "klass");
        Size[] outputSizes = this.streamConfigurationMap.getOutputSizes(klass);
        return (outputSizes == null || (list = ArraysKt.toList(outputSizes)) == null) ? CollectionsKt.emptyList() : list;
    }

    @Override // androidx.camera.camera2.pipe.CameraStreamConfigurationMap
    /* JADX INFO: renamed from: getOutputSizes-hNQ4ISI, reason: not valid java name */
    public List<Size> mo3getOutputSizeshNQ4ISI(int format) {
        List<Size> list;
        Size[] outputSizes = this.streamConfigurationMap.getOutputSizes(format);
        return (outputSizes == null || (list = ArraysKt.toList(outputSizes)) == null) ? CollectionsKt.emptyList() : list;
    }

    @Override // androidx.camera.camera2.pipe.CameraStreamConfigurationMap
    public List<Size> getHighSpeedVideoSizes() {
        Size[] highSpeedVideoSizes = this.streamConfigurationMap.getHighSpeedVideoSizes();
        Intrinsics.checkNotNullExpressionValue(highSpeedVideoSizes, "getHighSpeedVideoSizes(...)");
        return ArraysKt.toList(highSpeedVideoSizes);
    }

    @Override // androidx.camera.camera2.pipe.CameraStreamConfigurationMap
    public List<Range<Integer>> getHighSpeedVideoFpsRangesFor(Size size) {
        List<Range<Integer>> list;
        Intrinsics.checkNotNullParameter(size, "size");
        Range<Integer>[] highSpeedVideoFpsRangesFor = this.streamConfigurationMap.getHighSpeedVideoFpsRangesFor(size);
        return (highSpeedVideoFpsRangesFor == null || (list = ArraysKt.toList(highSpeedVideoFpsRangesFor)) == null) ? CollectionsKt.emptyList() : list;
    }

    @Override // androidx.camera.camera2.pipe.CameraStreamConfigurationMap
    public List<Range<Integer>> getHighSpeedVideoFpsRanges() {
        Range<Integer>[] highSpeedVideoFpsRanges = this.streamConfigurationMap.getHighSpeedVideoFpsRanges();
        Intrinsics.checkNotNullExpressionValue(highSpeedVideoFpsRanges, "getHighSpeedVideoFpsRanges(...)");
        return ArraysKt.toList(highSpeedVideoFpsRanges);
    }

    @Override // androidx.camera.camera2.pipe.CameraStreamConfigurationMap
    public List<Size> getHighSpeedVideoSizesFor(Range<Integer> fpsRange) {
        Intrinsics.checkNotNullParameter(fpsRange, "fpsRange");
        Size[] highSpeedVideoSizesFor = this.streamConfigurationMap.getHighSpeedVideoSizesFor(fpsRange);
        Intrinsics.checkNotNullExpressionValue(highSpeedVideoSizesFor, "getHighSpeedVideoSizesFor(...)");
        return ArraysKt.toList(highSpeedVideoSizesFor);
    }

    @Override // androidx.camera.camera2.pipe.CameraStreamConfigurationMap
    /* JADX INFO: renamed from: getHighResolutionOutputSizes-hNQ4ISI, reason: not valid java name */
    public List<Size> mo0getHighResolutionOutputSizeshNQ4ISI(int format) {
        List<Size> list;
        Size[] highResolutionOutputSizes = this.streamConfigurationMap.getHighResolutionOutputSizes(format);
        return (highResolutionOutputSizes == null || (list = ArraysKt.toList(highResolutionOutputSizes)) == null) ? CollectionsKt.emptyList() : list;
    }

    @Override // androidx.camera.camera2.pipe.CameraStreamConfigurationMap
    /* JADX INFO: renamed from: getOutputMinFrameDuration-lomOqCM, reason: not valid java name */
    public long mo2getOutputMinFrameDurationlomOqCM(int format, Size size) {
        Intrinsics.checkNotNullParameter(size, "size");
        return this.streamConfigurationMap.getOutputMinFrameDuration(format, size);
    }

    @Override // androidx.camera.camera2.pipe.CameraStreamConfigurationMap
    public <T> long getOutputMinFrameDuration(Class<T> klass, Size size) {
        Intrinsics.checkNotNullParameter(klass, "klass");
        Intrinsics.checkNotNullParameter(size, "size");
        return this.streamConfigurationMap.getOutputMinFrameDuration(klass, size);
    }

    @Override // androidx.camera.camera2.pipe.CameraStreamConfigurationMap
    /* JADX INFO: renamed from: getOutputStallDuration-lomOqCM, reason: not valid java name */
    public long mo4getOutputStallDurationlomOqCM(int format, Size size) {
        Intrinsics.checkNotNullParameter(size, "size");
        return this.streamConfigurationMap.getOutputStallDuration(format, size);
    }

    @Override // androidx.camera.camera2.pipe.CameraStreamConfigurationMap
    public <T> long getOutputStallDuration(Class<T> klass, Size size) {
        Intrinsics.checkNotNullParameter(klass, "klass");
        Intrinsics.checkNotNullParameter(size, "size");
        return this.streamConfigurationMap.getOutputStallDuration(klass, size);
    }

    @Override // androidx.camera.camera2.pipe.UnsafeWrapper
    public <T> T unwrapAs(KClass<T> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(StreamConfigurationMap.class))) {
            Object obj = this.streamConfigurationMap;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of <root>.Camera2StreamConfigurationMap.unwrapAs");
            return (T) obj;
        }
        if (!Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(Camera2StreamConfigurationMap.class))) {
            return null;
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of <root>.Camera2StreamConfigurationMap.unwrapAs");
        return (T) this;
    }

    public String toString() {
        String string = this.streamConfigurationMap.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
