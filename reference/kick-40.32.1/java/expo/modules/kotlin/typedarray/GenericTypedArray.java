package expo.modules.kotlin.typedarray;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: compiled from: GenericTypedArray.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003J\u0016\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u0006H¦\u0002¢\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00028\u0000H¦\u0002¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0096\u0082\u0004¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lexpo/modules/kotlin/typedarray/GenericTypedArray;", ExifInterface.GPS_DIRECTION_TRUE, "Lexpo/modules/kotlin/typedarray/TypedArray;", "", "get", FirebaseAnalytics.Param.INDEX, "", "(I)Ljava/lang/Object;", "set", "", "value", "(ILjava/lang/Object;)V", "iterator", "", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface GenericTypedArray<T> extends TypedArray, Iterable<T>, KMappedMarker {
    T get(int index);

    void set(int index, T value);

    /* JADX INFO: compiled from: GenericTypedArray.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static <T> Iterator<T> iterator(GenericTypedArray<T> genericTypedArray) {
            return GenericTypedArray.super.iterator();
        }
    }

    @Override // java.lang.Iterable
    default Iterator<T> iterator() {
        return new TypedArrayIterator(this);
    }
}
