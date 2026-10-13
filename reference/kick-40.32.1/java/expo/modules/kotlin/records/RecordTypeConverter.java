package expo.modules.kotlin.records;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableMap;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.DynamicCastException;
import expo.modules.kotlin.exception.RecordCastException;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.jni.CppType;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.types.ConverterContext;
import expo.modules.kotlin.types.DynamicAwareTypeConverters;
import expo.modules.kotlin.types.TypeConverterProvider;
import expo.modules.kotlin.types.descriptors.TypeDescriptor;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: RecordTypeConverter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ%\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¢\u0006\u0002\u0010\u0017J%\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0016H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001e"}, d2 = {"Lexpo/modules/kotlin/records/RecordTypeConverter;", ExifInterface.GPS_DIRECTION_TRUE, "Lexpo/modules/kotlin/records/Record;", "Lexpo/modules/kotlin/types/DynamicAwareTypeConverters;", "converterProvider", "Lexpo/modules/kotlin/types/TypeConverterProvider;", "typeDescriptor", "Lexpo/modules/kotlin/types/descriptors/TypeDescriptor;", "<init>", "(Lexpo/modules/kotlin/types/TypeConverterProvider;Lexpo/modules/kotlin/types/descriptors/TypeDescriptor;)V", "getTypeDescriptor", "()Lexpo/modules/kotlin/types/descriptors/TypeDescriptor;", "conversionStrategy", "Lexpo/modules/kotlin/records/RecordConversionStrategy;", "getConversionStrategy$expo_modules_core_release", "()Lexpo/modules/kotlin/records/RecordConversionStrategy;", "convertFromDynamic", "value", "Lcom/facebook/react/bridge/Dynamic;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lexpo/modules/kotlin/types/ConverterContext;", "forceConversion", "", "(Lcom/facebook/react/bridge/Dynamic;Lexpo/modules/kotlin/types/ConverterContext;Z)Lexpo/modules/kotlin/records/Record;", "convertFromAny", "", "(Ljava/lang/Object;Lexpo/modules/kotlin/types/ConverterContext;Z)Lexpo/modules/kotlin/records/Record;", "getCppRequiredTypes", "Lexpo/modules/kotlin/jni/ExpectedType;", "isTrivial", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RecordTypeConverter<T extends Record> extends DynamicAwareTypeConverters<T> {
    public static final int $stable = 8;
    private final RecordConversionStrategy<T> conversionStrategy;
    private final TypeDescriptor typeDescriptor;

    @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
    public boolean isTrivial() {
        return false;
    }

    public RecordTypeConverter(TypeConverterProvider converterProvider, TypeDescriptor typeDescriptor) {
        ReflectionRecordConversionStrategy reflectionRecordConversionStrategy;
        Intrinsics.checkNotNullParameter(converterProvider, "converterProvider");
        Intrinsics.checkNotNullParameter(typeDescriptor, "typeDescriptor");
        this.typeDescriptor = typeDescriptor;
        if (typeDescriptor.getTypeInfo().getIntrospection() != null) {
            reflectionRecordConversionStrategy = new IntrospectableRecordConversionStrategy(converterProvider, typeDescriptor);
        } else {
            Log.w("ExpoModulesCore", "Introspectable data is missing for " + typeDescriptor.getTypeInfo().getJClass() + ". Falling back to reflection-based conversion, which may have performance implications. To fix this, ensure that the Record class is properly annotated with expo.modules.kotlin.types.Introspectable and that the necessary metadata is available at runtime.");
            reflectionRecordConversionStrategy = new ReflectionRecordConversionStrategy(converterProvider, typeDescriptor);
        }
        this.conversionStrategy = reflectionRecordConversionStrategy;
    }

    public final TypeDescriptor getTypeDescriptor() {
        return this.typeDescriptor;
    }

    public final RecordConversionStrategy<T> getConversionStrategy$expo_modules_core_release() {
        return this.conversionStrategy;
    }

    @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
    public T convertFromDynamic(Dynamic value, ConverterContext context, boolean forceConversion) throws RecordCastException {
        UnexpectedException unexpectedException;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            ReadableMap readableMapAsMap = value.asMap();
            if (readableMapAsMap == null) {
                throw new DynamicCastException((KClass<?>) Reflection.getOrCreateKotlinClass(ReadableMap.class));
            }
            return (T) getConversionStrategy$expo_modules_core_release().convertFromReadableMap(readableMapAsMap, context, forceConversion);
        } catch (Throwable th) {
            if (th instanceof CodedException) {
                unexpectedException = (CodedException) th;
            } else if (th instanceof expo.modules.core.errors.CodedException) {
                expo.modules.core.errors.CodedException codedException = (expo.modules.core.errors.CodedException) th;
                unexpectedException = new CodedException(codedException.getCode(), codedException.getMessage(), codedException.getCause());
            } else {
                unexpectedException = new UnexpectedException(th);
            }
            throw new RecordCastException(getTypeDescriptor(), unexpectedException);
        }
    }

    @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
    public T convertFromAny(Object value, ConverterContext context, boolean forceConversion) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(context, "context");
        if (value instanceof ReadableMap) {
            return (T) this.conversionStrategy.convertFromReadableMap((ReadableMap) value, context, forceConversion);
        }
        if (value instanceof Map) {
            return (T) this.conversionStrategy.convertFromMap((Map) value, context, forceConversion);
        }
        return (T) value;
    }

    @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
    /* JADX INFO: renamed from: getCppRequiredTypes */
    public ExpectedType get$cppRequireType() {
        return new ExpectedType(CppType.READABLE_MAP);
    }
}
