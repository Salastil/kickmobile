package io.github.expo.pika;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.NotImplementedError;

/* JADX INFO: compiled from: typeDescriptorOf.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\f\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\u001a\b\u0010\u0003\u001a\u00020\u0001H\u0001¨\u0006\u0004"}, d2 = {"typeDescriptorOf", "Lio/github/expo/pika/PTypeDescriptor;", ExifInterface.GPS_DIRECTION_TRUE, "throwNonReifiedTypeDescriptorError", "pika-api"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class TypeDescriptorOfKt {
    public static final <T> PTypeDescriptor typeDescriptorOf() {
        throw new NotImplementedError("typeDescriptorOf<T>() should be replaced by the compiler plugin");
    }

    public static final PTypeDescriptor throwNonReifiedTypeDescriptorError() {
        throw new IllegalStateException("typeDescriptorOf<T>() requires a reified type parameter. Use 'inline fun <reified T>' or call typeDescriptorOf<T>() with a concrete type.");
    }
}
