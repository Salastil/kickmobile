package expo.modules.kotlin.types;

import android.net.Uri;
import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import expo.modules.kotlin.jni.ArrayBuffer;
import expo.modules.kotlin.jni.JavaScriptArrayBuffer;
import expo.modules.kotlin.jni.NativeArrayBuffer;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.records.formatters.FormattedRecord;
import expo.modules.kotlin.typedarray.RawTypedArrayHolder;
import io.github.expo.pika.IntrospectionOfKt;
import io.github.expo.pika.IsIntrospectableKt;
import io.github.expo.pika.PIntrospectionData;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.time.Duration;

/* JADX INFO: compiled from: ReturnType.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u00012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0086\b\u001a\u0018\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u001a$\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00042\f\u0010\b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\t\u001a\u0015\u0010\n\u001a\u00020\u000b\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\fH\u0086\b\u001a\u0011\u0010\r\u001a\u00020\u000b\"\u0006\b\u0000\u0010\u0002\u0018\u0001H\u0086\b¨\u0006\u000e"}, d2 = {"inheritFrom", "", ExifInterface.GPS_DIRECTION_TRUE, "klass", "Ljava/lang/Class;", "getDirectConverter", "Lexpo/modules/kotlin/types/JSTypeConverter;", "getIndirectConverter", "introspectableData", "Lio/github/expo/pika/PIntrospectionData;", "get", "Lexpo/modules/kotlin/types/ReturnType;", "Lexpo/modules/kotlin/types/ReturnTypeProvider;", "toReturnType", "expo-modules-core_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ReturnTypeKt {
    public static final /* synthetic */ <T> boolean inheritFrom(Class<?> klass) {
        Intrinsics.checkNotNullParameter(klass, "klass");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return Object.class.isAssignableFrom(klass);
    }

    public static final JSTypeConverter<?> getDirectConverter(Class<?> klass) {
        Intrinsics.checkNotNullParameter(klass, "klass");
        if (Intrinsics.areEqual(klass, Unit.class)) {
            return JSTypeConverter.PassThroughConverter.INSTANCE;
        }
        if (Intrinsics.areEqual(klass, Bundle.class)) {
            return JSTypeConverter.BundleConverter.INSTANCE;
        }
        if (Intrinsics.areEqual(klass, int[].class)) {
            return JSTypeConverter.IntArrayConverter.INSTANCE;
        }
        if (Intrinsics.areEqual(klass, float[].class)) {
            return JSTypeConverter.FloatArrayConverter.INSTANCE;
        }
        if (Intrinsics.areEqual(klass, double[].class)) {
            return JSTypeConverter.DoubleArrayConverter.INSTANCE;
        }
        if (Intrinsics.areEqual(klass, boolean[].class)) {
            return JSTypeConverter.BooleanArrayConverter.INSTANCE;
        }
        if (Intrinsics.areEqual(klass, byte[].class)) {
            return JSTypeConverter.ByteArrayConverter.INSTANCE;
        }
        if (Intrinsics.areEqual(klass, URI.class)) {
            return JSTypeConverter.URIConverter.INSTANCE;
        }
        if (Intrinsics.areEqual(klass, URL.class)) {
            return JSTypeConverter.URLConverter.INSTANCE;
        }
        if (Intrinsics.areEqual(klass, Uri.class)) {
            return JSTypeConverter.AndroidUriConverter.INSTANCE;
        }
        if (Intrinsics.areEqual(klass, File.class)) {
            return JSTypeConverter.FileConverter.INSTANCE;
        }
        if (Intrinsics.areEqual(klass, Pair.class)) {
            return JSTypeConverter.PairConverter.INSTANCE;
        }
        if (Intrinsics.areEqual(klass, Long.TYPE)) {
            return JSTypeConverter.LongConverter.INSTANCE;
        }
        if (Intrinsics.areEqual(klass, Duration.class)) {
            return JSTypeConverter.DurationConverter.INSTANCE;
        }
        if (Intrinsics.areEqual(klass, JavaScriptArrayBuffer.class)) {
            return JSTypeConverter.JavaScriptArrayBufferConverter.INSTANCE;
        }
        if (Intrinsics.areEqual(klass, ArrayBuffer.class)) {
            return JSTypeConverter.ArrayBufferConverter.INSTANCE;
        }
        if (Intrinsics.areEqual(klass, NativeArrayBuffer.class)) {
            return JSTypeConverter.NativeArrayBufferConverter.INSTANCE;
        }
        if (Intrinsics.areEqual(klass, Object.class)) {
            return JSTypeConverter.AnyConverter.INSTANCE;
        }
        return null;
    }

    public static final /* synthetic */ <T> ReturnType get(ReturnTypeProvider returnTypeProvider) {
        PIntrospectionData<Object> pIntrospectionDataThrowNonReifiedIntrospectionOfError;
        Intrinsics.checkNotNullParameter(returnTypeProvider, "<this>");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        ReturnType returnType = returnTypeProvider.getTypes().get(Object.class);
        if (returnType != null) {
            return returnType;
        }
        JSTypeConverter<?> directConverter = getDirectConverter(Object.class);
        if (directConverter == null) {
            Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
            boolean zThrowNonReifiedIsIntrospectableError = IsIntrospectableKt.throwNonReifiedIsIntrospectableError();
            MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.isIntrospectable");
            if (zThrowNonReifiedIsIntrospectableError) {
                Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
                pIntrospectionDataThrowNonReifiedIntrospectionOfError = IntrospectionOfKt.throwNonReifiedIntrospectionOfError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.introspectionOf");
            } else {
                pIntrospectionDataThrowNonReifiedIntrospectionOfError = null;
            }
            directConverter = getIndirectConverter(Object.class, pIntrospectionDataThrowNonReifiedIntrospectionOfError);
        }
        ReturnType returnType2 = new ReturnType(directConverter);
        Map<Class<?>, ReturnType> types = returnTypeProvider.getTypes();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        types.put(Object.class, returnType2);
        return returnType2;
    }

    public static final /* synthetic */ <T> ReturnType toReturnType() {
        PIntrospectionData<Object> pIntrospectionDataThrowNonReifiedIntrospectionOfError;
        ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        ReturnType returnType = returnTypeProvider.getTypes().get(Object.class);
        if (returnType != null) {
            return returnType;
        }
        JSTypeConverter<?> directConverter = getDirectConverter(Object.class);
        if (directConverter == null) {
            Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
            boolean zThrowNonReifiedIsIntrospectableError = IsIntrospectableKt.throwNonReifiedIsIntrospectableError();
            MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.isIntrospectable");
            if (zThrowNonReifiedIsIntrospectableError) {
                Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
                pIntrospectionDataThrowNonReifiedIntrospectionOfError = IntrospectionOfKt.throwNonReifiedIntrospectionOfError();
                MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.introspectionOf");
            } else {
                pIntrospectionDataThrowNonReifiedIntrospectionOfError = null;
            }
            directConverter = getIndirectConverter(Object.class, pIntrospectionDataThrowNonReifiedIntrospectionOfError);
        }
        ReturnType returnType2 = new ReturnType(directConverter);
        Map<Class<?>, ReturnType> types = returnTypeProvider.getTypes();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        types.put(Object.class, returnType2);
        return returnType2;
    }

    public static final JSTypeConverter<?> getIndirectConverter(Class<?> klass, PIntrospectionData<?> pIntrospectionData) {
        Intrinsics.checkNotNullParameter(klass, "klass");
        if (Map.class.isAssignableFrom(klass)) {
            return JSTypeConverter.MapConverter.INSTANCE;
        }
        if (Enum.class.isAssignableFrom(klass)) {
            return JSTypeConverter.EnumConverter.INSTANCE;
        }
        if (Record.class.isAssignableFrom(klass)) {
            if (pIntrospectionData != null) {
                return new JSTypeConverter.IntrospectableRecordConverter(pIntrospectionData);
            }
            return JSTypeConverter.RecordConverter.INSTANCE;
        }
        if (FormattedRecord.class.isAssignableFrom(klass)) {
            return JSTypeConverter.FormattedRecordConverter.INSTANCE;
        }
        if (RawTypedArrayHolder.class.isAssignableFrom(klass)) {
            return JSTypeConverter.RawTypedArrayHolderConverter.INSTANCE;
        }
        if (Object[].class.isAssignableFrom(klass)) {
            return JSTypeConverter.ArrayConverter.INSTANCE;
        }
        if (Collection.class.isAssignableFrom(klass)) {
            return JSTypeConverter.CollectionConverter.INSTANCE;
        }
        return JSTypeConverter.PassThroughConverter.INSTANCE;
    }
}
