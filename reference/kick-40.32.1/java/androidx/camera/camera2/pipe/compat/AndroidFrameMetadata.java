package androidx.camera.camera2.pipe.compat;

import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.camera2.pipe.CameraId;
import androidx.camera.camera2.pipe.FrameMetadata;
import androidx.camera.camera2.pipe.FrameNumber;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.hermes.intl.Constants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: FrameMetadata.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u000b\u001a\u0004\u0018\u0001H\f\"\u0004\b\u0000\u0010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u000eH\u0096\u0002¢\u0006\u0002\u0010\u000fJ)\u0010\u0010\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u000e2\u0006\u0010\u0011\u001a\u0002H\fH\u0016¢\u0006\u0002\u0010\u0012J$\u0010\u000b\u001a\u0004\u0018\u0001H\f\"\u0004\b\u0000\u0010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u0013H\u0096\u0002¢\u0006\u0002\u0010\u0014J)\u0010\u0010\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u00132\u0006\u0010\u0011\u001a\u0002H\fH\u0016¢\u0006\u0002\u0010\u0015J'\u0010\u001f\u001a\u0004\u0018\u0001H\f\"\b\b\u0000\u0010\f*\u00020\u001c2\f\u0010 \u001a\b\u0012\u0004\u0012\u0002H\f0!H\u0016¢\u0006\u0002\u0010\"J\b\u0010#\u001a\u00020$H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R \u0010\u001a\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006%"}, d2 = {"Landroidx/camera/camera2/pipe/compat/AndroidFrameMetadata;", "Landroidx/camera/camera2/pipe/FrameMetadata;", "captureResult", "Landroid/hardware/camera2/CaptureResult;", "camera", "Landroidx/camera/camera2/pipe/CameraId;", "<init>", "(Landroid/hardware/camera2/CaptureResult;Ljava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCamera-Dz_R5H8", "()Ljava/lang/String;", "Ljava/lang/String;", "get", ExifInterface.GPS_DIRECTION_TRUE, "key", "Landroidx/camera/camera2/pipe/Metadata$Key;", "(Landroidx/camera/camera2/pipe/Metadata$Key;)Ljava/lang/Object;", "getOrDefault", Constants.COLLATION_DEFAULT, "(Landroidx/camera/camera2/pipe/Metadata$Key;Ljava/lang/Object;)Ljava/lang/Object;", "Landroid/hardware/camera2/CaptureResult$Key;", "(Landroid/hardware/camera2/CaptureResult$Key;)Ljava/lang/Object;", "(Landroid/hardware/camera2/CaptureResult$Key;Ljava/lang/Object;)Ljava/lang/Object;", "frameNumber", "Landroidx/camera/camera2/pipe/FrameNumber;", "getFrameNumber-Ugla2oM", "()J", "extraMetadata", "", "", "getExtraMetadata", "()Ljava/util/Map;", "unwrapAs", "type", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "toString", "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AndroidFrameMetadata implements FrameMetadata {
    private final String camera;
    private final CaptureResult captureResult;
    private final Map<?, Object> extraMetadata;

    public /* synthetic */ AndroidFrameMetadata(CaptureResult captureResult, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(captureResult, str);
    }

    @Override // androidx.camera.camera2.pipe.Metadata
    public <T> T get(androidx.camera.camera2.pipe.Metadata.Key<T> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return null;
    }

    @Override // androidx.camera.camera2.pipe.Metadata
    public <T> T getOrDefault(androidx.camera.camera2.pipe.Metadata.Key<T> key, T t) {
        Intrinsics.checkNotNullParameter(key, "key");
        return t;
    }

    private AndroidFrameMetadata(CaptureResult captureResult, String camera) {
        Intrinsics.checkNotNullParameter(captureResult, "captureResult");
        Intrinsics.checkNotNullParameter(camera, "camera");
        this.captureResult = captureResult;
        this.camera = camera;
        this.extraMetadata = MapsKt.emptyMap();
    }

    @Override // androidx.camera.camera2.pipe.FrameMetadata
    /* JADX INFO: renamed from: getCamera-Dz_R5H8, reason: from getter */
    public String getCamera() {
        return this.camera;
    }

    @Override // androidx.camera.camera2.pipe.FrameMetadata
    public <T> T get(CaptureResult.Key<T> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        T t = (T) getExtraMetadata().get(key);
        return t == null ? (T) this.captureResult.get(key) : t;
    }

    @Override // androidx.camera.camera2.pipe.FrameMetadata
    public <T> T getOrDefault(CaptureResult.Key<T> key, T t) {
        Intrinsics.checkNotNullParameter(key, "key");
        T t2 = (T) get(key);
        return t2 == null ? t : t2;
    }

    @Override // androidx.camera.camera2.pipe.FrameMetadata
    /* JADX INFO: renamed from: getFrameNumber-Ugla2oM */
    public long mo530getFrameNumberUgla2oM() {
        return FrameNumber.m532constructorimpl(this.captureResult.getFrameNumber());
    }

    @Override // androidx.camera.camera2.pipe.FrameMetadata
    public Map<?, Object> getExtraMetadata() {
        return this.extraMetadata;
    }

    @Override // androidx.camera.camera2.pipe.UnsafeWrapper
    public <T> T unwrapAs(KClass<T> type) {
        T t;
        Intrinsics.checkNotNullParameter(type, "type");
        if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(CaptureResult.class))) {
            Object obj = this.captureResult;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.camera.camera2.pipe.compat.AndroidFrameMetadata.unwrapAs");
            return (T) obj;
        }
        if (!Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(TotalCaptureResult.class)) || (t = (T) this.captureResult) == null) {
            return null;
        }
        return t;
    }

    public String toString() {
        return "FrameMetadata(camera: " + ((Object) CameraId.m432toStringimpl(getCamera())) + ", frameNumber: " + this.captureResult.getFrameNumber() + ')';
    }
}
