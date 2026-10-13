package androidx.camera.camera2.compat;

import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import android.util.Range;
import android.util.Size;
import androidx.camera.camera2.compat.workaround.OutputSizesCorrector;
import androidx.camera.camera2.config.CameraScope;
import androidx.camera.camera2.impl.Camera2Logger;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.core.Logger;
import androidx.exifinterface.media.ExifInterface;
import io.ktor.http.ContentDisposition;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StreamConfigurationMapCompat.kt */
/* JADX INFO: loaded from: classes.dex */
@CameraScope
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001+B\u001b\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\r¢\u0006\u0002\u0010\u0015J\u001b\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\u0017\u001a\u00020\f¢\u0006\u0002\u0010\u0018J'\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\"\u0004\b\u0000\u0010\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00190\u0011¢\u0006\u0002\u0010\u001bJ\u001b\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\u0017\u001a\u00020\f¢\u0006\u0002\u0010\u0018J\u0019\u0010\u001d\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u001e\u0018\u00010\r¢\u0006\u0002\u0010\u001fJ!\u0010 \u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u001e\u0018\u00010\r2\u0006\u0010!\u001a\u00020\u000e¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\u0002\u0010$J!\u0010%\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\f0\u001e¢\u0006\u0002\u0010'J\u0016\u0010(\u001a\u00020)2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010!\u001a\u00020\u000eJ\b\u0010*\u001a\u0004\u0018\u00010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R \u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0010\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Landroidx/camera/camera2/compat/StreamConfigurationMapCompat;", "", "map", "Landroid/hardware/camera2/params/StreamConfigurationMap;", "outputSizesCorrector", "Landroidx/camera/camera2/compat/workaround/OutputSizesCorrector;", "<init>", "(Landroid/hardware/camera2/params/StreamConfigurationMap;Landroidx/camera/camera2/compat/workaround/OutputSizesCorrector;)V", "tag", "", "cachedFormatOutputSizes", "", "", "", "Landroid/util/Size;", "cachedFormatHighResolutionOutputSizes", "cachedClassOutputSizes", "Ljava/lang/Class;", "impl", "Landroidx/camera/camera2/compat/StreamConfigurationMapCompat$StreamConfigurationMapCompatImpl;", "getOutputFormats", "()[Ljava/lang/Integer;", "getOutputSizes", "format", "(I)[Landroid/util/Size;", ExifInterface.GPS_DIRECTION_TRUE, "klass", "(Ljava/lang/Class;)[Landroid/util/Size;", "getHighResolutionOutputSizes", "getHighSpeedVideoFpsRanges", "Landroid/util/Range;", "()[Landroid/util/Range;", "getHighSpeedVideoFpsRangesFor", ContentDisposition.Parameters.Size, "(Landroid/util/Size;)[Landroid/util/Range;", "getHighSpeedVideoSizes", "()[Landroid/util/Size;", "getHighSpeedVideoSizesFor", "fpsRange", "(Landroid/util/Range;)[Landroid/util/Size;", "getOutputMinFrameDuration", "", "toStreamConfigurationMap", "StreamConfigurationMapCompatImpl", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StreamConfigurationMapCompat {
    private final Map<Class<?>, Size[]> cachedClassOutputSizes;
    private final Map<Integer, Size[]> cachedFormatHighResolutionOutputSizes;
    private final Map<Integer, Size[]> cachedFormatOutputSizes;
    private StreamConfigurationMapCompatImpl impl;
    private final OutputSizesCorrector outputSizesCorrector;
    private final String tag;

    /* JADX INFO: compiled from: StreamConfigurationMapCompat.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0015\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010\u0005J\u001d\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\u0004H&¢\u0006\u0002\u0010\tJ)\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0003\"\u0004\b\u0000\u0010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\fH&¢\u0006\u0002\u0010\rJ\u001d\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\u0004H&¢\u0006\u0002\u0010\tJ\u001b\u0010\u000f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0010\u0018\u00010\u0003H&¢\u0006\u0002\u0010\u0011J#\u0010\u0012\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0010\u0018\u00010\u00032\u0006\u0010\u0013\u001a\u00020\u0007H&¢\u0006\u0002\u0010\u0014J\u0015\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0003H&¢\u0006\u0002\u0010\u0016J#\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00032\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010H&¢\u0006\u0002\u0010\u0019J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0007H&J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001eÀ\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/compat/StreamConfigurationMapCompat$StreamConfigurationMapCompatImpl;", "", "getOutputFormats", "", "", "()[Ljava/lang/Integer;", "getOutputSizes", "Landroid/util/Size;", "format", "(I)[Landroid/util/Size;", ExifInterface.GPS_DIRECTION_TRUE, "klass", "Ljava/lang/Class;", "(Ljava/lang/Class;)[Landroid/util/Size;", "getHighResolutionOutputSizes", "getHighSpeedVideoFpsRanges", "Landroid/util/Range;", "()[Landroid/util/Range;", "getHighSpeedVideoFpsRangesFor", ContentDisposition.Parameters.Size, "(Landroid/util/Size;)[Landroid/util/Range;", "getHighSpeedVideoSizes", "()[Landroid/util/Size;", "getHighSpeedVideoSizesFor", "fpsRange", "(Landroid/util/Range;)[Landroid/util/Size;", "getOutputMinFrameDuration", "", "unwrap", "Landroid/hardware/camera2/params/StreamConfigurationMap;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface StreamConfigurationMapCompatImpl {
        Size[] getHighResolutionOutputSizes(int format);

        Range<Integer>[] getHighSpeedVideoFpsRanges();

        Range<Integer>[] getHighSpeedVideoFpsRangesFor(Size size) throws IllegalArgumentException;

        Size[] getHighSpeedVideoSizes();

        Size[] getHighSpeedVideoSizesFor(Range<Integer> fpsRange) throws IllegalArgumentException;

        Integer[] getOutputFormats();

        long getOutputMinFrameDuration(int format, Size size);

        Size[] getOutputSizes(int format);

        <T> Size[] getOutputSizes(Class<T> klass);

        StreamConfigurationMap unwrap();
    }

    @Inject
    public StreamConfigurationMapCompat(StreamConfigurationMap streamConfigurationMap, OutputSizesCorrector outputSizesCorrector) {
        StreamConfigurationMapCompatBaseImpl streamConfigurationMapCompatBaseImpl;
        Intrinsics.checkNotNullParameter(outputSizesCorrector, "outputSizesCorrector");
        this.outputSizesCorrector = outputSizesCorrector;
        this.tag = "StreamConfigurationMapCompat";
        this.cachedFormatOutputSizes = new LinkedHashMap();
        this.cachedFormatHighResolutionOutputSizes = new LinkedHashMap();
        this.cachedClassOutputSizes = new LinkedHashMap();
        if (Build.VERSION.SDK_INT >= 34) {
            streamConfigurationMapCompatBaseImpl = new StreamConfigurationMapCompatApi34Impl(streamConfigurationMap);
        } else {
            streamConfigurationMapCompatBaseImpl = new StreamConfigurationMapCompatBaseImpl(streamConfigurationMap);
        }
        this.impl = streamConfigurationMapCompatBaseImpl;
    }

    public final Integer[] getOutputFormats() {
        return this.impl.getOutputFormats();
    }

    public final Size[] getOutputSizes(int format) {
        Size[] outputSizes = null;
        if (this.cachedFormatOutputSizes.containsKey(Integer.valueOf(format))) {
            Size[] sizeArr = this.cachedFormatOutputSizes.get(Integer.valueOf(format));
            if (sizeArr != null) {
                return (Size[]) sizeArr.clone();
            }
            return null;
        }
        try {
            outputSizes = this.impl.getOutputSizes(format);
        } catch (Throwable th) {
            Logger.w(this.tag, "Failed to get output sizes for " + format, th);
        }
        if (outputSizes == null || outputSizes.length == 0) {
            Logger.w(this.tag, "Retrieved output sizes array is null or empty for format " + format);
            return outputSizes;
        }
        Size[] sizeArrApplyQuirks = this.outputSizesCorrector.applyQuirks(outputSizes, format);
        this.cachedFormatOutputSizes.put(Integer.valueOf(format), sizeArrApplyQuirks);
        return (Size[]) sizeArrApplyQuirks.clone();
    }

    public final <T> Size[] getOutputSizes(Class<T> klass) {
        Intrinsics.checkNotNullParameter(klass, "klass");
        Size[] outputSizes = null;
        if (this.cachedClassOutputSizes.containsKey(klass)) {
            Size[] sizeArr = this.cachedClassOutputSizes.get(klass);
            if (sizeArr != null) {
                return (Size[]) sizeArr.clone();
            }
            return null;
        }
        try {
            outputSizes = this.impl.getOutputSizes(klass);
        } catch (Throwable th) {
            Logger.w(this.tag, "Failed to get output sizes for " + klass, th);
        }
        if (outputSizes == null || outputSizes.length == 0) {
            Logger.w(this.tag, "Retrieved output sizes array is null or empty for class " + klass);
            return outputSizes;
        }
        Size[] sizeArrApplyQuirks = this.outputSizesCorrector.applyQuirks(outputSizes, klass);
        this.cachedClassOutputSizes.put(klass, sizeArrApplyQuirks);
        return (Size[]) sizeArrApplyQuirks.clone();
    }

    public final Size[] getHighResolutionOutputSizes(int format) {
        if (this.cachedFormatHighResolutionOutputSizes.containsKey(Integer.valueOf(format))) {
            Size[] sizeArr = this.cachedFormatHighResolutionOutputSizes.get(Integer.valueOf(format));
            if (sizeArr != null) {
                return (Size[]) sizeArr.clone();
            }
            return null;
        }
        Size[] highResolutionOutputSizes = this.impl.getHighResolutionOutputSizes(format);
        if (highResolutionOutputSizes != null && highResolutionOutputSizes.length != 0) {
            highResolutionOutputSizes = this.outputSizesCorrector.applyQuirks(highResolutionOutputSizes, format);
        }
        this.cachedFormatHighResolutionOutputSizes.put(Integer.valueOf(format), highResolutionOutputSizes);
        if (highResolutionOutputSizes != null) {
            return (Size[]) highResolutionOutputSizes.clone();
        }
        return null;
    }

    public final Range<Integer>[] getHighSpeedVideoFpsRanges() {
        return this.impl.getHighSpeedVideoFpsRanges();
    }

    public final Range<Integer>[] getHighSpeedVideoFpsRangesFor(Size size) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(size, "size");
        return this.impl.getHighSpeedVideoFpsRangesFor(size);
    }

    public final Size[] getHighSpeedVideoSizes() {
        return this.impl.getHighSpeedVideoSizes();
    }

    public final Size[] getHighSpeedVideoSizesFor(Range<Integer> fpsRange) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(fpsRange, "fpsRange");
        return this.impl.getHighSpeedVideoSizesFor(fpsRange);
    }

    public final long getOutputMinFrameDuration(int format, Size size) {
        Intrinsics.checkNotNullParameter(size, "size");
        try {
            return this.impl.getOutputMinFrameDuration(format, size);
        } catch (RuntimeException e) {
            Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
            RuntimeException runtimeException = e;
            if (!Logger.isWarnEnabled(Log.TAG)) {
                return 0L;
            }
            android.util.Log.w(Camera2Logger.TRUNCATED_TAG, "Unable to get min frame duration for format = " + format + " and size = " + size, runtimeException);
            return 0L;
        }
    }

    public final StreamConfigurationMap toStreamConfigurationMap() {
        return this.impl.unwrap();
    }
}
