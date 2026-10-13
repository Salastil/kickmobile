package androidx.camera.camera2.pipe.compat;

import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build;
import android.os.Trace;
import android.util.ArrayMap;
import androidx.camera.camera2.pipe.CameraId;
import androidx.camera.camera2.pipe.FrameInfo;
import androidx.camera.camera2.pipe.FrameMetadata;
import androidx.camera.camera2.pipe.RequestMetadata;
import androidx.camera.camera2.pipe.core.Debug;
import androidx.exifinterface.media.ExifInterface;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: FrameMetadata.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0004\u001a\u00020\u0005H\u0096\u0002¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u001e\u001a\u0004\u0018\u0001H\u001f\"\b\b\u0000\u0010\u001f*\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u001f0\"H\u0016¢\u0006\u0002\u0010#J\b\u0010$\u001a\u00020%H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006&"}, d2 = {"Landroidx/camera/camera2/pipe/compat/AndroidFrameInfo;", "Landroidx/camera/camera2/pipe/FrameInfo;", "totalCaptureResult", "Landroid/hardware/camera2/TotalCaptureResult;", "camera", "Landroidx/camera/camera2/pipe/CameraId;", "requestMetadata", "Landroidx/camera/camera2/pipe/RequestMetadata;", "<init>", "(Landroid/hardware/camera2/TotalCaptureResult;Ljava/lang/String;Landroidx/camera/camera2/pipe/RequestMetadata;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCamera-Dz_R5H8", "()Ljava/lang/String;", "Ljava/lang/String;", "getRequestMetadata", "()Landroidx/camera/camera2/pipe/RequestMetadata;", "result", "Landroidx/camera/camera2/pipe/compat/AndroidFrameMetadata;", "physicalResults", "", "Landroidx/camera/camera2/pipe/FrameMetadata;", "metadata", "getMetadata", "()Landroidx/camera/camera2/pipe/FrameMetadata;", "get", "get-EfqyGwQ", "(Ljava/lang/String;)Landroidx/camera/camera2/pipe/FrameMetadata;", "frameNumber", "Landroidx/camera/camera2/pipe/FrameNumber;", "getFrameNumber-Ugla2oM", "()J", "unwrapAs", ExifInterface.GPS_DIRECTION_TRUE, "", "type", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "toString", "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AndroidFrameInfo implements FrameInfo {
    private final String camera;
    private final Map<CameraId, FrameMetadata> physicalResults;
    private final RequestMetadata requestMetadata;
    private final AndroidFrameMetadata result;
    private final TotalCaptureResult totalCaptureResult;

    public /* synthetic */ AndroidFrameInfo(TotalCaptureResult totalCaptureResult, String str, RequestMetadata requestMetadata, DefaultConstructorMarker defaultConstructorMarker) {
        this(totalCaptureResult, str, requestMetadata);
    }

    private AndroidFrameInfo(TotalCaptureResult totalCaptureResult, String camera, RequestMetadata requestMetadata) {
        Map<String, CaptureResult> physicalCaptureResults;
        ArrayMap arrayMapEmptyMap;
        Intrinsics.checkNotNullParameter(totalCaptureResult, "totalCaptureResult");
        Intrinsics.checkNotNullParameter(camera, "camera");
        Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
        this.totalCaptureResult = totalCaptureResult;
        this.camera = camera;
        this.requestMetadata = requestMetadata;
        this.result = new AndroidFrameMetadata(totalCaptureResult, getCamera(), null);
        Debug debug = Debug.INSTANCE;
        try {
            Trace.beginSection("physicalCaptureResults");
            if (Build.VERSION.SDK_INT >= 31) {
                physicalCaptureResults = Api31Compat.getPhysicalCameraTotalResults(this.totalCaptureResult);
                Intrinsics.checkNotNull(physicalCaptureResults, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, android.hardware.camera2.CaptureResult>");
            } else {
                physicalCaptureResults = Build.VERSION.SDK_INT >= 28 ? Api28Compat.getPhysicalCaptureResults(this.totalCaptureResult) : MapsKt.emptyMap();
            }
            if (physicalCaptureResults != null && !physicalCaptureResults.isEmpty()) {
                ArrayMap arrayMap = new ArrayMap(physicalCaptureResults.size());
                for (Map.Entry<String, CaptureResult> entry : physicalCaptureResults.entrySet()) {
                    String strM427constructorimpl = CameraId.m427constructorimpl(entry.getKey());
                    arrayMap.put(CameraId.m426boximpl(strM427constructorimpl), new AndroidFrameMetadata(entry.getValue(), strM427constructorimpl, null));
                }
                arrayMapEmptyMap = arrayMap;
            } else {
                arrayMapEmptyMap = MapsKt.emptyMap();
            }
            Trace.endSection();
            this.physicalResults = arrayMapEmptyMap;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @Override // androidx.camera.camera2.pipe.FrameInfo
    /* JADX INFO: renamed from: getCamera-Dz_R5H8, reason: from getter */
    public String getCamera() {
        return this.camera;
    }

    @Override // androidx.camera.camera2.pipe.FrameInfo
    public RequestMetadata getRequestMetadata() {
        return this.requestMetadata;
    }

    @Override // androidx.camera.camera2.pipe.FrameInfo
    public FrameMetadata getMetadata() {
        return this.result;
    }

    @Override // androidx.camera.camera2.pipe.FrameInfo
    /* JADX INFO: renamed from: get-EfqyGwQ */
    public FrameMetadata mo107getEfqyGwQ(String camera) {
        Intrinsics.checkNotNullParameter(camera, "camera");
        return this.physicalResults.get(CameraId.m426boximpl(camera));
    }

    @Override // androidx.camera.camera2.pipe.FrameInfo
    /* JADX INFO: renamed from: getFrameNumber-Ugla2oM */
    public long mo109getFrameNumberUgla2oM() {
        return this.result.mo530getFrameNumberUgla2oM();
    }

    @Override // androidx.camera.camera2.pipe.UnsafeWrapper
    public <T> T unwrapAs(KClass<T> type) {
        T t;
        Intrinsics.checkNotNullParameter(type, "type");
        if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(CaptureResult.class))) {
            Object obj = this.totalCaptureResult;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.camera.camera2.pipe.compat.AndroidFrameInfo.unwrapAs");
            return (T) obj;
        }
        if (!Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(TotalCaptureResult.class)) || (t = (T) this.totalCaptureResult) == null) {
            return null;
        }
        return t;
    }

    public String toString() {
        return "FrameInfo(camera: " + ((Object) CameraId.m432toStringimpl(this.result.getCamera())) + ", frameNumber: " + this.result.mo530getFrameNumberUgla2oM() + ')';
    }
}
