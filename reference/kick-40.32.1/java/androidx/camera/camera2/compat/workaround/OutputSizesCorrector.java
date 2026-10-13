package androidx.camera.camera2.compat.workaround;

import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Size;
import androidx.camera.camera2.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.compat.quirk.ExcludedSupportedSizesQuirk;
import androidx.camera.camera2.compat.quirk.ExtraSupportedOutputSizeQuirk;
import androidx.camera.camera2.config.CameraScope;
import androidx.camera.camera2.pipe.CameraMetadata;
import androidx.camera.core.Logger;
import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OutputSizesCorrector.kt */
/* JADX INFO: loaded from: classes.dex */
@CameraScope
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J3\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\"\u0004\b\u0000\u0010\u00152\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0017¢\u0006\u0002\u0010\u0018J\u001e\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00100\u001c2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J*\u0010\u001d\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u00152\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00100\u001c2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0017H\u0002J\u001e\u0010\u001e\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00100\u001c2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J*\u0010\u001f\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u00152\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00100\u001c2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0017H\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Landroidx/camera/camera2/compat/workaround/OutputSizesCorrector;", "", "cameraMetadata", "Landroidx/camera/camera2/pipe/CameraMetadata;", "streamConfigurationMap", "Landroid/hardware/camera2/params/StreamConfigurationMap;", "<init>", "(Landroidx/camera/camera2/pipe/CameraMetadata;Landroid/hardware/camera2/params/StreamConfigurationMap;)V", "tag", "", "excludedSupportedSizesQuirk", "Landroidx/camera/camera2/compat/quirk/ExcludedSupportedSizesQuirk;", "extraSupportedOutputSizeQuirk", "Landroidx/camera/camera2/compat/quirk/ExtraSupportedOutputSizeQuirk;", "applyQuirks", "", "Landroid/util/Size;", "sizes", "format", "", "([Landroid/util/Size;I)[Landroid/util/Size;", ExifInterface.GPS_DIRECTION_TRUE, "klass", "Ljava/lang/Class;", "([Landroid/util/Size;Ljava/lang/Class;)[Landroid/util/Size;", "addExtraSupportedOutputSizesByFormat", "", "sizeList", "", "addExtraSupportedOutputSizesByClass", "excludeProblematicOutputSizesByFormat", "excludeProblematicOutputSizesByClass", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OutputSizesCorrector {
    private final CameraMetadata cameraMetadata;
    private final StreamConfigurationMap streamConfigurationMap;
    private final String tag = "OutputSizesCorrector";
    private final ExcludedSupportedSizesQuirk excludedSupportedSizesQuirk = (ExcludedSupportedSizesQuirk) DeviceQuirks.INSTANCE.get(ExcludedSupportedSizesQuirk.class);
    private final ExtraSupportedOutputSizeQuirk extraSupportedOutputSizeQuirk = (ExtraSupportedOutputSizeQuirk) DeviceQuirks.INSTANCE.get(ExtraSupportedOutputSizeQuirk.class);

    @Inject
    public OutputSizesCorrector(CameraMetadata cameraMetadata, StreamConfigurationMap streamConfigurationMap) {
        this.cameraMetadata = cameraMetadata;
        this.streamConfigurationMap = streamConfigurationMap;
    }

    public final Size[] applyQuirks(Size[] sizes, int format) {
        Intrinsics.checkNotNullParameter(sizes, "sizes");
        List<Size> mutableList = ArraysKt.toMutableList(sizes);
        addExtraSupportedOutputSizesByFormat(mutableList, format);
        excludeProblematicOutputSizesByFormat(mutableList, format);
        if (mutableList.isEmpty()) {
            Logger.w(this.tag, "Sizes array becomes empty after excluding problematic output sizes.");
        }
        return (Size[]) mutableList.toArray(new Size[0]);
    }

    public final <T> Size[] applyQuirks(Size[] sizes, Class<T> klass) {
        Intrinsics.checkNotNullParameter(sizes, "sizes");
        Intrinsics.checkNotNullParameter(klass, "klass");
        List<Size> mutableList = ArraysKt.toMutableList(sizes);
        addExtraSupportedOutputSizesByClass(mutableList, klass);
        excludeProblematicOutputSizesByClass(mutableList, klass);
        if (mutableList.isEmpty()) {
            Logger.w(this.tag, "Sizes array becomes empty after excluding problematic output sizes.");
        }
        return (Size[]) mutableList.toArray(new Size[0]);
    }

    private final void addExtraSupportedOutputSizesByFormat(List<Size> sizeList, int format) {
        ExtraSupportedOutputSizeQuirk extraSupportedOutputSizeQuirk = this.extraSupportedOutputSizeQuirk;
        if (extraSupportedOutputSizeQuirk == null) {
            return;
        }
        Size[] extraSupportedResolutions = extraSupportedOutputSizeQuirk.getExtraSupportedResolutions(format);
        if (extraSupportedResolutions.length == 0) {
            return;
        }
        CollectionsKt.addAll(sizeList, extraSupportedResolutions);
    }

    private final <T> void addExtraSupportedOutputSizesByClass(List<Size> sizeList, Class<T> klass) {
        ExtraSupportedOutputSizeQuirk extraSupportedOutputSizeQuirk = this.extraSupportedOutputSizeQuirk;
        if (extraSupportedOutputSizeQuirk == null) {
            return;
        }
        Size[] extraSupportedResolutions = extraSupportedOutputSizeQuirk.getExtraSupportedResolutions(klass);
        if (extraSupportedResolutions.length == 0) {
            return;
        }
        CollectionsKt.addAll(sizeList, extraSupportedResolutions);
    }

    private final void excludeProblematicOutputSizesByFormat(List<Size> sizeList, int format) {
        ExcludedSupportedSizesQuirk excludedSupportedSizesQuirk;
        CameraMetadata cameraMetadata = this.cameraMetadata;
        if (cameraMetadata == null || (excludedSupportedSizesQuirk = this.excludedSupportedSizesQuirk) == null) {
            return;
        }
        List<Size> excludedSizes = excludedSupportedSizesQuirk.getExcludedSizes(cameraMetadata.mo445getCameraDz_R5H8(), format);
        if (excludedSizes.isEmpty()) {
            return;
        }
        sizeList.removeAll(excludedSizes);
    }

    private final <T> void excludeProblematicOutputSizesByClass(List<Size> sizeList, Class<T> klass) {
        ExcludedSupportedSizesQuirk excludedSupportedSizesQuirk;
        CameraMetadata cameraMetadata = this.cameraMetadata;
        if (cameraMetadata == null || (excludedSupportedSizesQuirk = this.excludedSupportedSizesQuirk) == null) {
            return;
        }
        List<Size> excludedSizes = excludedSupportedSizesQuirk.getExcludedSizes(cameraMetadata.mo445getCameraDz_R5H8(), (Class<?>) klass);
        if (excludedSizes.isEmpty()) {
            return;
        }
        sizeList.removeAll(excludedSizes);
    }
}
