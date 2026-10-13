package androidx.camera.camera2.pipe;

import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.pipe.core.Log;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.hermes.intl.Constants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Requests.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000@\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00042\u0006\u0010\u0005\u001a\u0002H\u0001H\u0007¢\u0006\u0002\u0010\u0006\u001a-\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00072\u0006\u0010\u0005\u001a\u0002H\u0001H\u0007¢\u0006\u0002\u0010\b\u001a\f\u0010\t\u001a\u00020\n*\u00020\u0002H\u0007\u001a(\u0010\u000b\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\r0\f*\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fH\u0007\u001a(\u0010\u000e\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\r0\f*\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fH\u0007\u001a \u0010\u000f\u001a\u00020\u0010*\u00020\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\r0\fH\u0007\u001a \u0010\u0013\u001a\u00020\u0010*\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\rH\u0007\u001a.\u0010\u0015\u001a\u00020\u0010*\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\r0\fH\u0007¨\u0006\u0018"}, d2 = {"getOrDefault", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/camera/camera2/pipe/Request;", "key", "Landroidx/camera/camera2/pipe/Metadata$Key;", Constants.COLLATION_DEFAULT, "(Landroidx/camera/camera2/pipe/Request;Landroidx/camera/camera2/pipe/Metadata$Key;Ljava/lang/Object;)Ljava/lang/Object;", "Landroid/hardware/camera2/CaptureRequest$Key;", "(Landroidx/camera/camera2/pipe/Request;Landroid/hardware/camera2/CaptureRequest$Key;Ljava/lang/Object;)Ljava/lang/Object;", "formatForLogs", "", "filterToCaptureRequestParameters", "", "", "filterToMetadataParameters", "writeParameters", "", "Landroid/hardware/camera2/CaptureRequest$Builder;", "parameters", "writeParameter", "value", "putAllMetadata", "", "metadata", "camera-camera2-pipe"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class RequestsKt {
    public static final <T> T getOrDefault(Request request, Metadata.Key<T> key, T t) {
        Intrinsics.checkNotNullParameter(request, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        T t2 = (T) request.get(key);
        return t2 == null ? t : t2;
    }

    public static final <T> T getOrDefault(Request request, CaptureRequest.Key<T> key, T t) {
        Intrinsics.checkNotNullParameter(request, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        T t2 = (T) request.get(key);
        return t2 == null ? t : t2;
    }

    public static final String formatForLogs(Request request) {
        Intrinsics.checkNotNullParameter(request, "<this>");
        return "Request(" + request.getStreams() + ")@" + Integer.toHexString(request.hashCode());
    }

    public static final void writeParameters(CaptureRequest.Builder builder, Map<?, ? extends Object> parameters) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        for (Map.Entry<?, ? extends Object> entry : parameters.entrySet()) {
            writeParameter(builder, entry.getKey(), entry.getValue());
        }
    }

    public static final void writeParameter(CaptureRequest.Builder builder, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        if (obj == null || !(obj instanceof CaptureRequest.Key)) {
            return;
        }
        try {
            builder.set((CaptureRequest.Key) obj, obj2);
        } catch (IllegalArgumentException e) {
            IllegalArgumentException illegalArgumentException = e;
            if (Log.INSTANCE.getWARN_LOGGABLE()) {
                android.util.Log.w(Log.TAG, "Failed to set [" + ((CaptureRequest.Key) obj).getName() + ": " + obj2 + "] on CaptureRequest.Builder", illegalArgumentException);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void putAllMetadata(Map<Object, Object> map, Map<?, ? extends Object> metadata) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        map.putAll(metadata);
    }

    public static final Map<CaptureRequest.Key<?>, Object> filterToCaptureRequestParameters(Map<Object, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Object, ? extends Object> entry : map.entrySet()) {
            if (entry.getKey() instanceof CaptureRequest.Key) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = linkedHashMap;
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap2.size()));
        for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
            Object key = entry2.getKey();
            Intrinsics.checkNotNull(key, "null cannot be cast to non-null type android.hardware.camera2.CaptureRequest.Key<*>");
            linkedHashMap3.put((CaptureRequest.Key) key, entry2.getValue());
        }
        return linkedHashMap3;
    }

    public static final Map<Metadata.Key<?>, Object> filterToMetadataParameters(Map<Object, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Object, ? extends Object> entry : map.entrySet()) {
            if (entry.getKey() instanceof Metadata.Key) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = linkedHashMap;
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap2.size()));
        for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
            Object key = entry2.getKey();
            Intrinsics.checkNotNull(key, "null cannot be cast to non-null type androidx.camera.camera2.pipe.Metadata.Key<*>");
            linkedHashMap3.put((Metadata.Key) key, entry2.getValue());
        }
        return linkedHashMap3;
    }
}
