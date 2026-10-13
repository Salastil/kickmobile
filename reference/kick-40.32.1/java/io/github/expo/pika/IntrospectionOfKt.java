package io.github.expo.pika;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.NotImplementedError;

/* JADX INFO: compiled from: introspectionOf.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u0017\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\b\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002ø\u0001\u0000\u001a\u0016\u0010\u0000\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u001a\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001H\u0001\u0082\u0002\u0004\n\u0002\b9¨\u0006\u0006"}, d2 = {"introspectionOf", "Lio/github/expo/pika/PIntrospectionData;", ExifInterface.GPS_DIRECTION_TRUE, "instance", "", "throwNonReifiedIntrospectionOfError", "pika-api"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IntrospectionOfKt {
    public static final <T> PIntrospectionData<T> introspectionOf() {
        throw new NotImplementedError("introspectionOf<T>() should be replaced by the compiler plugin");
    }

    public static final PIntrospectionData<?> introspectionOf(Object obj) {
        if (obj instanceof PIntrospectionProvider) {
            return ((PIntrospectionProvider) obj).getIntrospectionData();
        }
        return null;
    }

    public static final PIntrospectionData<Object> throwNonReifiedIntrospectionOfError() {
        throw new UnsupportedOperationException("introspectionOf<T>() requires a reified type parameter. Use 'inline fun <reified T>' or call introspectionOf<T>() with a concrete type.");
    }
}
