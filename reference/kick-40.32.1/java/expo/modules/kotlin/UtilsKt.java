package expo.modules.kotlin;

import androidx.exifinterface.media.ExifInterface;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0004\u0018\u0001H\u0002¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"weak", "Ljava/lang/ref/WeakReference;", ExifInterface.GPS_DIRECTION_TRUE, "", "(Ljava/lang/Object;)Ljava/lang/ref/WeakReference;", "expo-modules-core_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class UtilsKt {
    public static final <T> WeakReference<T> weak(T t) {
        return new WeakReference<>(t);
    }
}
