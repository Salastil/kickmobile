package androidx.camera.camera2.pipe.compat;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.os.Build;
import android.os.Parcelable;
import android.view.Surface;
import androidx.activity.ComponentDialog$$ExternalSyntheticApiModelOutline0;
import androidx.camera.camera2.pipe.Request;
import androidx.camera.camera2.pipe.RequestMetadata;
import androidx.camera.camera2.pipe.StreamId;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.hermes.intl.Constants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: Camera2CaptureSequenceProcessor.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007\u0012\u0012\u0010\n\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J$\u0010$\u001a\u0004\u0018\u0001H%\"\u0004\b\u0000\u0010%2\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H%0'H\u0096\u0002¢\u0006\u0002\u0010(J)\u0010)\u001a\u0002H%\"\u0004\b\u0000\u0010%2\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H%0'2\u0006\u0010*\u001a\u0002H%H\u0016¢\u0006\u0002\u0010+J$\u0010$\u001a\u0004\u0018\u0001H%\"\u0004\b\u0000\u0010%2\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H%0,H\u0096\u0002¢\u0006\u0002\u0010-J)\u0010)\u001a\u0002H%\"\u0004\b\u0000\u0010%2\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H%0,2\u0006\u0010*\u001a\u0002H%H\u0016¢\u0006\u0002\u0010.J'\u0010/\u001a\u0004\u0018\u0001H%\"\b\b\u0000\u0010%*\u00020\b2\f\u00100\u001a\b\u0012\u0004\u0012\u0002H%01H\u0016¢\u0006\u0002\u00102R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0012\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010\u0014\u001a\u00020\u0015X\u0096\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"¨\u00063"}, d2 = {"Landroidx/camera/camera2/pipe/compat/Camera2RequestMetadata;", "Landroidx/camera/camera2/pipe/RequestMetadata;", "cameraCaptureSessionWrapper", "Landroidx/camera/camera2/pipe/compat/CameraCaptureSessionWrapper;", "captureRequest", "Landroid/hardware/camera2/CaptureRequest;", "defaultParameters", "", "", "graphParameters", "requiredParameters", "streams", "Landroidx/camera/camera2/pipe/StreamId;", "Landroid/view/Surface;", "template", "Landroidx/camera/camera2/pipe/RequestTemplate;", "repeating", "", "request", "Landroidx/camera/camera2/pipe/Request;", "requestNumber", "Landroidx/camera/camera2/pipe/RequestNumber;", "<init>", "(Landroidx/camera/camera2/pipe/compat/CameraCaptureSessionWrapper;Landroid/hardware/camera2/CaptureRequest;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;IZLandroidx/camera/camera2/pipe/Request;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getStreams", "()Ljava/util/Map;", "getTemplate-fGx8uWA", "()I", "I", "getRepeating", "()Z", "getRequest", "()Landroidx/camera/camera2/pipe/Request;", "getRequestNumber-my6kx4g", "()J", "J", "get", ExifInterface.GPS_DIRECTION_TRUE, "key", "Landroid/hardware/camera2/CaptureRequest$Key;", "(Landroid/hardware/camera2/CaptureRequest$Key;)Ljava/lang/Object;", "getOrDefault", Constants.COLLATION_DEFAULT, "(Landroid/hardware/camera2/CaptureRequest$Key;Ljava/lang/Object;)Ljava/lang/Object;", "Landroidx/camera/camera2/pipe/Metadata$Key;", "(Landroidx/camera/camera2/pipe/Metadata$Key;)Ljava/lang/Object;", "(Landroidx/camera/camera2/pipe/Metadata$Key;Ljava/lang/Object;)Ljava/lang/Object;", "unwrapAs", "type", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Camera2RequestMetadata implements RequestMetadata {
    private final CameraCaptureSessionWrapper cameraCaptureSessionWrapper;
    private final CaptureRequest captureRequest;
    private final Map<?, Object> defaultParameters;
    private final Map<?, Object> graphParameters;
    private final boolean repeating;
    private final Request request;
    private final long requestNumber;
    private final Map<?, Object> requiredParameters;
    private final Map<StreamId, Surface> streams;
    private final int template;

    public /* synthetic */ Camera2RequestMetadata(CameraCaptureSessionWrapper cameraCaptureSessionWrapper, CaptureRequest captureRequest, Map map, Map map2, Map map3, Map map4, int i, boolean z, Request request, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(cameraCaptureSessionWrapper, captureRequest, map, map2, map3, map4, i, z, request, j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Camera2RequestMetadata(CameraCaptureSessionWrapper cameraCaptureSessionWrapper, CaptureRequest captureRequest, Map<?, ? extends Object> defaultParameters, Map<?, ? extends Object> graphParameters, Map<?, ? extends Object> requiredParameters, Map<StreamId, ? extends Surface> streams, int i, boolean z, Request request, long j) {
        Intrinsics.checkNotNullParameter(cameraCaptureSessionWrapper, "cameraCaptureSessionWrapper");
        Intrinsics.checkNotNullParameter(captureRequest, "captureRequest");
        Intrinsics.checkNotNullParameter(defaultParameters, "defaultParameters");
        Intrinsics.checkNotNullParameter(graphParameters, "graphParameters");
        Intrinsics.checkNotNullParameter(requiredParameters, "requiredParameters");
        Intrinsics.checkNotNullParameter(streams, "streams");
        Intrinsics.checkNotNullParameter(request, "request");
        this.cameraCaptureSessionWrapper = cameraCaptureSessionWrapper;
        this.captureRequest = captureRequest;
        this.defaultParameters = defaultParameters;
        this.graphParameters = graphParameters;
        this.requiredParameters = requiredParameters;
        this.streams = streams;
        this.template = i;
        this.repeating = z;
        this.request = request;
        this.requestNumber = j;
    }

    @Override // androidx.camera.camera2.pipe.RequestMetadata
    public Map<StreamId, Surface> getStreams() {
        return this.streams;
    }

    @Override // androidx.camera.camera2.pipe.RequestMetadata
    /* JADX INFO: renamed from: getTemplate-fGx8uWA, reason: from getter */
    public int getTemplate() {
        return this.template;
    }

    @Override // androidx.camera.camera2.pipe.RequestMetadata
    public boolean getRepeating() {
        return this.repeating;
    }

    @Override // androidx.camera.camera2.pipe.RequestMetadata
    public Request getRequest() {
        return this.request;
    }

    @Override // androidx.camera.camera2.pipe.RequestMetadata
    /* JADX INFO: renamed from: getRequestNumber-my6kx4g, reason: from getter */
    public long getRequestNumber() {
        return this.requestNumber;
    }

    @Override // androidx.camera.camera2.pipe.RequestMetadata
    public <T> T get(CaptureRequest.Key<T> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (T) this.captureRequest.get(key);
    }

    @Override // androidx.camera.camera2.pipe.RequestMetadata
    public <T> T getOrDefault(CaptureRequest.Key<T> key, T t) {
        Intrinsics.checkNotNullParameter(key, "key");
        T t2 = (T) get(key);
        return t2 == null ? t : t2;
    }

    @Override // androidx.camera.camera2.pipe.Metadata
    public <T> T get(androidx.camera.camera2.pipe.Metadata.Key<T> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (this.requiredParameters.containsKey(key)) {
            return (T) this.requiredParameters.get(key);
        }
        if (getRequest().getExtras().containsKey(key)) {
            return (T) getRequest().getExtras().get(key);
        }
        if (this.graphParameters.containsKey(key)) {
            return (T) this.graphParameters.get(key);
        }
        return (T) this.defaultParameters.get(key);
    }

    @Override // androidx.camera.camera2.pipe.Metadata
    public <T> T getOrDefault(androidx.camera.camera2.pipe.Metadata.Key<T> key, T t) {
        Intrinsics.checkNotNullParameter(key, "key");
        T t2 = (T) get(key);
        return t2 == null ? t : t2;
    }

    @Override // androidx.camera.camera2.pipe.UnsafeWrapper
    public <T> T unwrapAs(KClass<T> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(CaptureRequest.class))) {
            Parcelable parcelable = this.captureRequest;
            Intrinsics.checkNotNull(parcelable, "null cannot be cast to non-null type T of androidx.camera.camera2.pipe.compat.Camera2RequestMetadata.unwrapAs");
            return (T) parcelable;
        }
        if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(CameraCaptureSession.class))) {
            T t = (T) this.cameraCaptureSessionWrapper.unwrapAs(Reflection.getOrCreateKotlinClass(CameraCaptureSession.class));
            if (t == null) {
                return null;
            }
            return t;
        }
        if (!Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(ComponentDialog$$ExternalSyntheticApiModelOutline0.m20m()))) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 31) {
            throw new IllegalStateException("Check failed.");
        }
        T t2 = (T) this.cameraCaptureSessionWrapper.unwrapAs(Reflection.getOrCreateKotlinClass(ComponentDialog$$ExternalSyntheticApiModelOutline0.m20m()));
        if (t2 == null) {
            return null;
        }
        return t2;
    }
}
