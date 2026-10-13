package androidx.camera.camera2.pipe.compat;

import android.hardware.camera2.CaptureResult;
import androidx.camera.camera2.pipe.FrameMetadata;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.hermes.intl.Constants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: FrameMetadata.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\f\u001a\u0004\u0018\u0001H\r\"\u0004\b\u0000\u0010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u000fH\u0096\u0002¢\u0006\u0002\u0010\u0010J)\u0010\u0011\u001a\u0002H\r\"\u0004\b\u0000\u0010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u000f2\u0006\u0010\u0012\u001a\u0002H\rH\u0016¢\u0006\u0002\u0010\u0013J$\u0010\f\u001a\u0004\u0018\u0001H\r\"\u0004\b\u0000\u0010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u0014H\u0096\u0002¢\u0006\u0002\u0010\u0015J)\u0010\u0011\u001a\u0002H\r\"\u0004\b\u0000\u0010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u00142\u0006\u0010\u0012\u001a\u0002H\rH\u0016¢\u0006\u0002\u0010\u0016J'\u0010\u001f\u001a\u0004\u0018\u0001H\r\"\b\b\u0000\u0010\r*\u00020\u00052\f\u0010 \u001a\b\u0012\u0004\u0012\u0002H\r0!H\u0016¢\u0006\u0002\u0010\"R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0003\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\u0017\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006#"}, d2 = {"Landroidx/camera/camera2/pipe/compat/CorrectedFrameMetadata;", "Landroidx/camera/camera2/pipe/FrameMetadata;", "frameMetadata", "extraMetadata", "", "", "<init>", "(Landroidx/camera/camera2/pipe/FrameMetadata;Ljava/util/Map;)V", "getExtraMetadata", "()Ljava/util/Map;", "setExtraMetadata", "(Ljava/util/Map;)V", "get", ExifInterface.GPS_DIRECTION_TRUE, "key", "Landroidx/camera/camera2/pipe/Metadata$Key;", "(Landroidx/camera/camera2/pipe/Metadata$Key;)Ljava/lang/Object;", "getOrDefault", Constants.COLLATION_DEFAULT, "(Landroidx/camera/camera2/pipe/Metadata$Key;Ljava/lang/Object;)Ljava/lang/Object;", "Landroid/hardware/camera2/CaptureResult$Key;", "(Landroid/hardware/camera2/CaptureResult$Key;)Ljava/lang/Object;", "(Landroid/hardware/camera2/CaptureResult$Key;Ljava/lang/Object;)Ljava/lang/Object;", "camera", "Landroidx/camera/camera2/pipe/CameraId;", "getCamera-Dz_R5H8", "()Ljava/lang/String;", "frameNumber", "Landroidx/camera/camera2/pipe/FrameNumber;", "getFrameNumber-Ugla2oM", "()J", "unwrapAs", "type", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CorrectedFrameMetadata implements FrameMetadata {
    private Map<?, ? extends Object> extraMetadata;
    private FrameMetadata frameMetadata;

    public CorrectedFrameMetadata(FrameMetadata frameMetadata, Map<?, ? extends Object> extraMetadata) {
        Intrinsics.checkNotNullParameter(frameMetadata, "frameMetadata");
        Intrinsics.checkNotNullParameter(extraMetadata, "extraMetadata");
        this.frameMetadata = frameMetadata;
        this.extraMetadata = extraMetadata;
    }

    @Override // androidx.camera.camera2.pipe.FrameMetadata
    public Map<?, Object> getExtraMetadata() {
        return this.extraMetadata;
    }

    public void setExtraMetadata(Map<?, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.extraMetadata = map;
    }

    @Override // androidx.camera.camera2.pipe.Metadata
    public <T> T get(androidx.camera.camera2.pipe.Metadata.Key<T> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        T t = (T) getExtraMetadata().get(key);
        return t == null ? (T) this.frameMetadata.get(key) : t;
    }

    @Override // androidx.camera.camera2.pipe.Metadata
    public <T> T getOrDefault(androidx.camera.camera2.pipe.Metadata.Key<T> key, T t) {
        Intrinsics.checkNotNullParameter(key, "key");
        T t2 = (T) get(key);
        return t2 == null ? t : t2;
    }

    @Override // androidx.camera.camera2.pipe.FrameMetadata
    public <T> T get(CaptureResult.Key<T> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        T t = (T) getExtraMetadata().get(key);
        return t == null ? (T) this.frameMetadata.get(key) : t;
    }

    @Override // androidx.camera.camera2.pipe.FrameMetadata
    public <T> T getOrDefault(CaptureResult.Key<T> key, T t) {
        Intrinsics.checkNotNullParameter(key, "key");
        T t2 = (T) get(key);
        return t2 == null ? t : t2;
    }

    @Override // androidx.camera.camera2.pipe.FrameMetadata
    /* JADX INFO: renamed from: getCamera-Dz_R5H8 */
    public String mo529getCameraDz_R5H8() {
        return this.frameMetadata.mo529getCameraDz_R5H8();
    }

    @Override // androidx.camera.camera2.pipe.FrameMetadata
    /* JADX INFO: renamed from: getFrameNumber-Ugla2oM */
    public long mo530getFrameNumberUgla2oM() {
        return this.frameMetadata.mo530getFrameNumberUgla2oM();
    }

    @Override // androidx.camera.camera2.pipe.UnsafeWrapper
    public <T> T unwrapAs(KClass<T> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return (T) this.frameMetadata.unwrapAs(type);
    }
}
