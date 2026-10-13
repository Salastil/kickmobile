package androidx.camera.camera2.pipe;

import android.util.Range;
import android.util.Size;
import android.view.Surface;
import androidx.exifinterface.media.ExifInterface;
import io.ktor.http.ContentDisposition;
import java.util.List;

/* JADX INFO: compiled from: CameraStreamConfigurationMap.kt */
/* JADX INFO: loaded from: classes5.dex */
@kotlin.Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\u0006\u0010\f\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\bJ\u0017\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u0004H&¢\u0006\u0004\b\u0010\u0010\u0011J\u001c\u0010\u000e\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0014H&J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H&J\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003\"\u0004\b\u0000\u0010\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0014H&J\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\u0006\u0010\f\u001a\u00020\u0004H&¢\u0006\u0004\b\u0018\u0010\bJ\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003H&J\u001c\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0\u00032\u0006\u0010\u001d\u001a\u00020\u000bH&J\u0014\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0\u0003H&J\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH&J\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\u0006\u0010\f\u001a\u00020\u0004H&¢\u0006\u0004\b\"\u0010\bJ\u001f\u0010#\u001a\u00020$2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u000bH&¢\u0006\u0004\b%\u0010&J$\u0010#\u001a\u00020$\"\u0004\b\u0000\u0010\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00142\u0006\u0010\u001d\u001a\u00020\u000bH&J\u001f\u0010'\u001a\u00020$2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u000bH&¢\u0006\u0004\b(\u0010&J$\u0010'\u001a\u00020$\"\u0004\b\u0000\u0010\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00142\u0006\u0010\u001d\u001a\u00020\u000bH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006)À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/CameraStreamConfigurationMap;", "Landroidx/camera/camera2/pipe/UnsafeWrapper;", "getOutputFormats", "", "Landroidx/camera/camera2/pipe/StreamFormat;", "getValidOutputFormatsForInput", "inputFormat", "getValidOutputFormatsForInput-hNQ4ISI", "(I)Ljava/util/List;", "getInputFormats", "getInputSizes", "Landroid/util/Size;", "format", "getInputSizes-hNQ4ISI", "isOutputSupportedFor", "", "isOutputSupportedFor-hNQ4ISI", "(I)Z", ExifInterface.GPS_DIRECTION_TRUE, "klass", "Ljava/lang/Class;", "surface", "Landroid/view/Surface;", "getOutputSizes", "getOutputSizes-hNQ4ISI", "getHighSpeedVideoSizes", "getHighSpeedVideoFpsRangesFor", "Landroid/util/Range;", "", ContentDisposition.Parameters.Size, "getHighSpeedVideoFpsRanges", "getHighSpeedVideoSizesFor", "fpsRange", "getHighResolutionOutputSizes", "getHighResolutionOutputSizes-hNQ4ISI", "getOutputMinFrameDuration", "", "getOutputMinFrameDuration-lomOqCM", "(ILandroid/util/Size;)J", "getOutputStallDuration", "getOutputStallDuration-lomOqCM", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface CameraStreamConfigurationMap extends UnsafeWrapper {
    /* JADX INFO: renamed from: getHighResolutionOutputSizes-hNQ4ISI */
    List<Size> mo0getHighResolutionOutputSizeshNQ4ISI(int format);

    List<Range<Integer>> getHighSpeedVideoFpsRanges();

    List<Range<Integer>> getHighSpeedVideoFpsRangesFor(Size size);

    List<Size> getHighSpeedVideoSizes();

    List<Size> getHighSpeedVideoSizesFor(Range<Integer> fpsRange);

    List<StreamFormat> getInputFormats();

    /* JADX INFO: renamed from: getInputSizes-hNQ4ISI */
    List<Size> mo1getInputSizeshNQ4ISI(int format);

    List<StreamFormat> getOutputFormats();

    <T> long getOutputMinFrameDuration(Class<T> klass, Size size);

    /* JADX INFO: renamed from: getOutputMinFrameDuration-lomOqCM */
    long mo2getOutputMinFrameDurationlomOqCM(int format, Size size);

    <T> List<Size> getOutputSizes(Class<T> klass);

    /* JADX INFO: renamed from: getOutputSizes-hNQ4ISI */
    List<Size> mo3getOutputSizeshNQ4ISI(int format);

    <T> long getOutputStallDuration(Class<T> klass, Size size);

    /* JADX INFO: renamed from: getOutputStallDuration-lomOqCM */
    long mo4getOutputStallDurationlomOqCM(int format, Size size);

    /* JADX INFO: renamed from: getValidOutputFormatsForInput-hNQ4ISI */
    List<StreamFormat> mo5getValidOutputFormatsForInputhNQ4ISI(int inputFormat);

    boolean isOutputSupportedFor(Surface surface);

    <T> boolean isOutputSupportedFor(Class<T> klass);

    /* JADX INFO: renamed from: isOutputSupportedFor-hNQ4ISI */
    boolean mo6isOutputSupportedForhNQ4ISI(int format);
}
