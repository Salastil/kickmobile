package androidx.camera.camera2.compat;

import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Range;
import android.util.Size;
import androidx.camera.core.Logger;
import androidx.exifinterface.media.ExifInterface;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StreamConfigurationMapCompatBaseImpl.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\u000bJ\u001d\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000fJ)\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\t\"\u0004\b\u0000\u0010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0012H\u0016¢\u0006\u0002\u0010\u0013J\u001d\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000fJ\u001b\u0010\u0015\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0016\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\u0017J#\u0010\u0018\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0016\u0018\u00010\t2\u0006\u0010\u0019\u001a\u00020\rH\u0016¢\u0006\u0002\u0010\u001aJ\u0015\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\u001cJ#\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\t2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\u0016H\u0016¢\u0006\u0002\u0010\u001fJ\u0018\u0010 \u001a\u00020!2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\rH\u0016J\n\u0010\"\u001a\u0004\u0018\u00010\u0003H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006#"}, d2 = {"Landroidx/camera/camera2/compat/StreamConfigurationMapCompatBaseImpl;", "Landroidx/camera/camera2/compat/StreamConfigurationMapCompat$StreamConfigurationMapCompatImpl;", "streamConfigurationMap", "Landroid/hardware/camera2/params/StreamConfigurationMap;", "<init>", "(Landroid/hardware/camera2/params/StreamConfigurationMap;)V", "getStreamConfigurationMap", "()Landroid/hardware/camera2/params/StreamConfigurationMap;", "getOutputFormats", "", "", "()[Ljava/lang/Integer;", "getOutputSizes", "Landroid/util/Size;", "format", "(I)[Landroid/util/Size;", ExifInterface.GPS_DIRECTION_TRUE, "klass", "Ljava/lang/Class;", "(Ljava/lang/Class;)[Landroid/util/Size;", "getHighResolutionOutputSizes", "getHighSpeedVideoFpsRanges", "Landroid/util/Range;", "()[Landroid/util/Range;", "getHighSpeedVideoFpsRangesFor", ContentDisposition.Parameters.Size, "(Landroid/util/Size;)[Landroid/util/Range;", "getHighSpeedVideoSizes", "()[Landroid/util/Size;", "getHighSpeedVideoSizesFor", "fpsRange", "(Landroid/util/Range;)[Landroid/util/Size;", "getOutputMinFrameDuration", "", "unwrap", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class StreamConfigurationMapCompatBaseImpl implements StreamConfigurationMapCompat.StreamConfigurationMapCompatImpl {
    private final StreamConfigurationMap streamConfigurationMap;

    public StreamConfigurationMapCompatBaseImpl(StreamConfigurationMap streamConfigurationMap) {
        this.streamConfigurationMap = streamConfigurationMap;
    }

    public final StreamConfigurationMap getStreamConfigurationMap() {
        return this.streamConfigurationMap;
    }

    @Override // androidx.camera.camera2.compat.StreamConfigurationMapCompat.StreamConfigurationMapCompatImpl
    public Integer[] getOutputFormats() {
        int[] outputFormats;
        try {
            StreamConfigurationMap streamConfigurationMap = this.streamConfigurationMap;
            outputFormats = streamConfigurationMap != null ? streamConfigurationMap.getOutputFormats() : null;
        } catch (IllegalArgumentException e) {
            Logger.w("StreamConfigurationMapCompatBaseImpl", "Failed to get output formats from StreamConfigurationMap", e);
        } catch (NullPointerException e2) {
            Logger.w("StreamConfigurationMapCompatBaseImpl", "Failed to get output formats from StreamConfigurationMap", e2);
        }
        if (outputFormats != null) {
            return ArraysKt.toTypedArray(outputFormats);
        }
        return null;
    }

    @Override // androidx.camera.camera2.compat.StreamConfigurationMapCompat.StreamConfigurationMapCompatImpl
    public Size[] getOutputSizes(int format) {
        StreamConfigurationMap streamConfigurationMap = this.streamConfigurationMap;
        if (streamConfigurationMap != null) {
            return streamConfigurationMap.getOutputSizes(format);
        }
        return null;
    }

    @Override // androidx.camera.camera2.compat.StreamConfigurationMapCompat.StreamConfigurationMapCompatImpl
    public <T> Size[] getOutputSizes(Class<T> klass) {
        Size[] outputSizes;
        Intrinsics.checkNotNullParameter(klass, "klass");
        StreamConfigurationMap streamConfigurationMap = this.streamConfigurationMap;
        return (streamConfigurationMap == null || (outputSizes = streamConfigurationMap.getOutputSizes(klass)) == null) ? new Size[0] : outputSizes;
    }

    @Override // androidx.camera.camera2.compat.StreamConfigurationMapCompat.StreamConfigurationMapCompatImpl
    public Size[] getHighResolutionOutputSizes(int format) {
        StreamConfigurationMap streamConfigurationMap = this.streamConfigurationMap;
        if (streamConfigurationMap != null) {
            return streamConfigurationMap.getHighResolutionOutputSizes(format);
        }
        return null;
    }

    @Override // androidx.camera.camera2.compat.StreamConfigurationMapCompat.StreamConfigurationMapCompatImpl
    public Range<Integer>[] getHighSpeedVideoFpsRanges() {
        StreamConfigurationMap streamConfigurationMap = this.streamConfigurationMap;
        if (streamConfigurationMap != null) {
            return streamConfigurationMap.getHighSpeedVideoFpsRanges();
        }
        return null;
    }

    @Override // androidx.camera.camera2.compat.StreamConfigurationMapCompat.StreamConfigurationMapCompatImpl
    public Range<Integer>[] getHighSpeedVideoFpsRangesFor(Size size) {
        Intrinsics.checkNotNullParameter(size, "size");
        StreamConfigurationMap streamConfigurationMap = this.streamConfigurationMap;
        if (streamConfigurationMap != null) {
            return streamConfigurationMap.getHighSpeedVideoFpsRangesFor(size);
        }
        return null;
    }

    @Override // androidx.camera.camera2.compat.StreamConfigurationMapCompat.StreamConfigurationMapCompatImpl
    public Size[] getHighSpeedVideoSizes() {
        StreamConfigurationMap streamConfigurationMap = this.streamConfigurationMap;
        if (streamConfigurationMap != null) {
            return streamConfigurationMap.getHighSpeedVideoSizes();
        }
        return null;
    }

    @Override // androidx.camera.camera2.compat.StreamConfigurationMapCompat.StreamConfigurationMapCompatImpl
    public Size[] getHighSpeedVideoSizesFor(Range<Integer> fpsRange) {
        Intrinsics.checkNotNullParameter(fpsRange, "fpsRange");
        StreamConfigurationMap streamConfigurationMap = this.streamConfigurationMap;
        if (streamConfigurationMap != null) {
            return streamConfigurationMap.getHighSpeedVideoSizesFor(fpsRange);
        }
        return null;
    }

    @Override // androidx.camera.camera2.compat.StreamConfigurationMapCompat.StreamConfigurationMapCompatImpl
    public long getOutputMinFrameDuration(int format, Size size) {
        Intrinsics.checkNotNullParameter(size, "size");
        StreamConfigurationMap streamConfigurationMap = this.streamConfigurationMap;
        if (streamConfigurationMap != null) {
            return streamConfigurationMap.getOutputMinFrameDuration(format, size);
        }
        return 0L;
    }

    @Override // androidx.camera.camera2.compat.StreamConfigurationMapCompat.StreamConfigurationMapCompatImpl
    public StreamConfigurationMap unwrap() {
        return this.streamConfigurationMap;
    }
}
