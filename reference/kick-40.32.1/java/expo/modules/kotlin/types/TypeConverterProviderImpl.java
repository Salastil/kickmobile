package expo.modules.kotlin.types;

import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.horcrux.svg.TSpanView$$ExternalSyntheticApiModelOutline0;
import expo.modules.core.arguments.ReadableArguments;
import expo.modules.kotlin.exception.DynamicCastException;
import expo.modules.kotlin.exception.MissingTypeConverter;
import expo.modules.kotlin.exception.UnsupportedClass;
import expo.modules.kotlin.jni.ArrayBuffer;
import expo.modules.kotlin.jni.CppType;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.jni.JavaScriptArrayBuffer;
import expo.modules.kotlin.jni.JavaScriptFunction;
import expo.modules.kotlin.jni.JavaScriptObject;
import expo.modules.kotlin.jni.JavaScriptValue;
import expo.modules.kotlin.jni.NativeArrayBuffer;
import expo.modules.kotlin.jni.worklets.Serializable;
import expo.modules.kotlin.jni.worklets.Worklet;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.records.RecordTypeConverter;
import expo.modules.kotlin.sharedobjects.SharedObject;
import expo.modules.kotlin.sharedobjects.SharedObjectTypeConverter;
import expo.modules.kotlin.sharedobjects.SharedRef;
import expo.modules.kotlin.sharedobjects.SharedRefTypeConverter;
import expo.modules.kotlin.typedarray.BigInt64Array;
import expo.modules.kotlin.typedarray.BigUint64Array;
import expo.modules.kotlin.typedarray.Float32Array;
import expo.modules.kotlin.typedarray.Float64Array;
import expo.modules.kotlin.typedarray.Int16Array;
import expo.modules.kotlin.typedarray.Int32Array;
import expo.modules.kotlin.typedarray.Int8Array;
import expo.modules.kotlin.typedarray.TypedArray;
import expo.modules.kotlin.typedarray.Uint16Array;
import expo.modules.kotlin.typedarray.Uint32Array;
import expo.modules.kotlin.typedarray.Uint8Array;
import expo.modules.kotlin.typedarray.Uint8ClampedArray;
import expo.modules.kotlin.types.descriptors.TypeDescriptor;
import expo.modules.kotlin.types.io.FileTypeConverter;
import expo.modules.kotlin.types.io.PathTypeConverter;
import expo.modules.kotlin.types.net.JavaURITypeConverter;
import expo.modules.kotlin.types.net.URLTypConverter;
import expo.modules.kotlin.types.net.UriTypeConverter;
import expo.modules.kotlin.types.worklets.SerializableTypeConverter;
import expo.modules.kotlin.types.worklets.WorkletTypeConverter;
import expo.modules.kotlin.views.ViewTypeConverter;
import j$.time.LocalDate;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.time.Duration;

/* JADX INFO: compiled from: TypeConverterProvider.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\rH\u0002J\u0016\u0010\u000e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00072\u0006\u0010\u000f\u001a\u00020\rH\u0002J\u0014\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u0012\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\u000f\u001a\u00020\rJ\u0016\u0010\u0012\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00072\u0006\u0010\u000f\u001a\u00020\rH\u0002J\u001c\u0010\u0013\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0005H\u0002J\u001c\u0010\u0014\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0005H\u0002R\"\u0010\u0004\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lexpo/modules/kotlin/types/TypeConverterProviderImpl;", "Lexpo/modules/kotlin/types/TypeConverterProvider;", "<init>", "()V", "cachedConverters", "", "Ljava/lang/Class;", "Lexpo/modules/kotlin/types/TypeConverter;", "cachedPrimitiveArrayConverters", "cachedRecordConverters", "", "getCachedConverter", "inputType", "Lexpo/modules/kotlin/types/descriptors/TypeDescriptor;", "getCachedPrimitiveArrayConverter", "typeDescriptor", "obtainTypeConverter", "obtainNonNullableTypeConverter", "handelEither", "createCachedConverters", "createCachedPrimitiveArrayConverters", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class TypeConverterProviderImpl implements TypeConverterProvider {
    public static final int $stable;
    public static final TypeConverterProviderImpl INSTANCE;
    private static final Map<Class<?>, TypeConverter<?>> cachedConverters;
    private static final Map<Class<?>, TypeConverter<?>> cachedPrimitiveArrayConverters;
    private static final Map<Class<?>, TypeConverter<?>> cachedRecordConverters;

    private TypeConverterProviderImpl() {
    }

    static {
        TypeConverterProviderImpl typeConverterProviderImpl = new TypeConverterProviderImpl();
        INSTANCE = typeConverterProviderImpl;
        cachedConverters = typeConverterProviderImpl.createCachedConverters();
        cachedPrimitiveArrayConverters = typeConverterProviderImpl.createCachedPrimitiveArrayConverters();
        cachedRecordConverters = new LinkedHashMap();
        $stable = 8;
    }

    private final TypeConverter<?> getCachedConverter(TypeDescriptor inputType) {
        return cachedConverters.get(inputType.getTypeInfo().getJClass());
    }

    private final TypeConverter<?> getCachedPrimitiveArrayConverter(TypeDescriptor typeDescriptor) {
        return cachedPrimitiveArrayConverters.get(typeDescriptor.getTypeInfo().getJClass());
    }

    @Override // expo.modules.kotlin.types.TypeConverterProvider
    public TypeConverter<?> obtainTypeConverter(TypeDescriptor typeDescriptor) throws MissingTypeConverter {
        Intrinsics.checkNotNullParameter(typeDescriptor, "typeDescriptor");
        TypeConverter<?> typeConverterObtainNonNullableTypeConverter = obtainNonNullableTypeConverter(typeDescriptor);
        return typeDescriptor.getTypeInfo().isNullable() ? new NullableTypeConverter(typeConverterObtainNonNullableTypeConverter) : typeConverterObtainNonNullableTypeConverter;
    }

    public final TypeConverter<?> obtainNonNullableTypeConverter(TypeDescriptor typeDescriptor) throws MissingTypeConverter {
        Intrinsics.checkNotNullParameter(typeDescriptor, "typeDescriptor");
        TypeConverter<?> cachedConverter = getCachedConverter(typeDescriptor);
        if (cachedConverter != null) {
            return cachedConverter;
        }
        Class<?> jClass = typeDescriptor.getTypeInfo().getJClass();
        if (jClass.isArray() || Object[].class.isAssignableFrom(jClass)) {
            if (ArrayTypeConverterKt.isPrimitiveArray(typeDescriptor)) {
                TypeConverter<?> cachedPrimitiveArrayConverter = getCachedPrimitiveArrayConverter(typeDescriptor);
                if (cachedPrimitiveArrayConverter != null) {
                    return cachedPrimitiveArrayConverter;
                }
                throw new MissingTypeConverter(typeDescriptor);
            }
            return new ArrayTypeConverter(this, typeDescriptor);
        }
        if (List.class.isAssignableFrom(jClass)) {
            return new ListTypeConverter(this, typeDescriptor);
        }
        if (Map.class.isAssignableFrom(jClass)) {
            return new MapTypeConverter(this, typeDescriptor);
        }
        if (Pair.class.isAssignableFrom(jClass)) {
            return new PairTypeConverter(this, typeDescriptor);
        }
        if (Set.class.isAssignableFrom(jClass)) {
            return new SetTypeConverter(this, typeDescriptor);
        }
        if (jClass.isEnum()) {
            Intrinsics.checkNotNull(jClass, "null cannot be cast to non-null type java.lang.Class<out kotlin.Enum<*>>");
            return new EnumTypeConverter(jClass);
        }
        Map<Class<?>, TypeConverter<?>> map = cachedRecordConverters;
        TypeConverter<?> typeConverter = map.get(jClass);
        if (typeConverter != null) {
            return typeConverter;
        }
        if (Record.class.isAssignableFrom(jClass)) {
            RecordTypeConverter recordTypeConverter = new RecordTypeConverter(this, typeDescriptor);
            map.put(jClass, recordTypeConverter);
            return recordTypeConverter;
        }
        if (View.class.isAssignableFrom(jClass)) {
            return new ViewTypeConverter(typeDescriptor);
        }
        if (SharedRef.class.isAssignableFrom(jClass)) {
            return new SharedRefTypeConverter(typeDescriptor);
        }
        if (SharedObject.class.isAssignableFrom(jClass)) {
            return new SharedObjectTypeConverter(typeDescriptor);
        }
        if (JavaScriptFunction.class.isAssignableFrom(jClass)) {
            return new JavaScriptFunctionTypeConverter(typeDescriptor);
        }
        if (ValueOrUndefined.class.isAssignableFrom(jClass)) {
            return new ValueOrUndefinedTypeConverter(this, typeDescriptor);
        }
        TypeConverter<?> typeConverterHandelEither = handelEither(typeDescriptor);
        if (typeConverterHandelEither != null) {
            return typeConverterHandelEither;
        }
        throw new MissingTypeConverter(typeDescriptor);
    }

    private final Map<Class<?>, TypeConverter<?>> createCachedConverters() {
        final ExpectedType expectedType = new ExpectedType(CppType.INT);
        DynamicAwareTypeConverters<Integer> dynamicAwareTypeConverters = new DynamicAwareTypeConverters<Integer>() { // from class: expo.modules.kotlin.types.TypeConverterProviderImpl$createCachedConverters$$inlined$createTrivialTypeConverter$1
            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Integer convertFromAny(Object value, ConverterContext context, boolean forceConversion) {
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(context, "context");
                return (Integer) value;
            }

            @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
            /* JADX INFO: renamed from: getCppRequiredTypes, reason: from getter */
            public ExpectedType get$cppRequireType() {
                return expectedType;
            }

            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Integer convertFromDynamic(Dynamic value, ConverterContext context, boolean forceConversion) {
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(context, "context");
                return Integer.valueOf((int) value.asDouble());
            }
        };
        final ExpectedType expectedType2 = new ExpectedType(CppType.LONG);
        DynamicAwareTypeConverters<Long> dynamicAwareTypeConverters2 = new DynamicAwareTypeConverters<Long>() { // from class: expo.modules.kotlin.types.TypeConverterProviderImpl$createCachedConverters$$inlined$createTrivialTypeConverter$2
            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Long convertFromAny(Object value, ConverterContext context, boolean forceConversion) {
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(context, "context");
                return (Long) value;
            }

            @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
            /* JADX INFO: renamed from: getCppRequiredTypes, reason: from getter */
            public ExpectedType get$cppRequireType() {
                return expectedType2;
            }

            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Long convertFromDynamic(Dynamic value, ConverterContext context, boolean forceConversion) {
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(context, "context");
                return Long.valueOf((long) value.asDouble());
            }
        };
        final ExpectedType expectedType3 = new ExpectedType(CppType.DOUBLE);
        DynamicAwareTypeConverters<Double> dynamicAwareTypeConverters3 = new DynamicAwareTypeConverters<Double>() { // from class: expo.modules.kotlin.types.TypeConverterProviderImpl$createCachedConverters$$inlined$createTrivialTypeConverter$3
            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Double convertFromAny(Object value, ConverterContext context, boolean forceConversion) {
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(context, "context");
                return (Double) value;
            }

            @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
            /* JADX INFO: renamed from: getCppRequiredTypes, reason: from getter */
            public ExpectedType get$cppRequireType() {
                return expectedType3;
            }

            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Double convertFromDynamic(Dynamic value, ConverterContext context, boolean forceConversion) {
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(context, "context");
                return Double.valueOf(value.asDouble());
            }
        };
        final ExpectedType expectedType4 = new ExpectedType(CppType.FLOAT);
        DynamicAwareTypeConverters<Float> dynamicAwareTypeConverters4 = new DynamicAwareTypeConverters<Float>() { // from class: expo.modules.kotlin.types.TypeConverterProviderImpl$createCachedConverters$$inlined$createTrivialTypeConverter$4
            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Float convertFromAny(Object value, ConverterContext context, boolean forceConversion) {
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(context, "context");
                return (Float) value;
            }

            @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
            /* JADX INFO: renamed from: getCppRequiredTypes, reason: from getter */
            public ExpectedType get$cppRequireType() {
                return expectedType4;
            }

            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Float convertFromDynamic(Dynamic value, ConverterContext context, boolean forceConversion) {
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(context, "context");
                return Float.valueOf((float) value.asDouble());
            }
        };
        final ExpectedType expectedType5 = new ExpectedType(CppType.BOOLEAN);
        DynamicAwareTypeConverters<Boolean> dynamicAwareTypeConverters5 = new DynamicAwareTypeConverters<Boolean>() { // from class: expo.modules.kotlin.types.TypeConverterProviderImpl$createCachedConverters$$inlined$createTrivialTypeConverter$5
            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Boolean convertFromAny(Object value, ConverterContext context, boolean forceConversion) {
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(context, "context");
                return (Boolean) value;
            }

            @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
            /* JADX INFO: renamed from: getCppRequiredTypes, reason: from getter */
            public ExpectedType get$cppRequireType() {
                return expectedType5;
            }

            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Boolean convertFromDynamic(Dynamic value, ConverterContext context, boolean forceConversion) {
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(context, "context");
                return Boolean.valueOf(value.asBoolean());
            }
        };
        SerializableTypeConverter serializableTypeConverter = new SerializableTypeConverter();
        final ExpectedType expectedType6 = new ExpectedType(CppType.STRING);
        final ExpectedType expectedType7 = new ExpectedType(CppType.READABLE_ARRAY);
        final ExpectedType expectedType8 = new ExpectedType(CppType.READABLE_MAP);
        final ExpectedType expectedType9 = new ExpectedType(CppType.JS_VALUE);
        final ExpectedType expectedType10 = new ExpectedType(CppType.JS_OBJECT);
        final ExpectedType expectedType11 = new ExpectedType(CppType.JS_ARRAY_BUFFER);
        final ExpectedType expectedType12 = new ExpectedType(CppType.ARRAY_BUFFER);
        final ExpectedType expectedType13 = new ExpectedType(CppType.NATIVE_ARRAY_BUFFER);
        final ExpectedType expectedType14 = new ExpectedType(CppType.NONE);
        Map<Class<?>, TypeConverter<?>> mapMapOf = MapsKt.mapOf(TuplesKt.to(Integer.TYPE, dynamicAwareTypeConverters), TuplesKt.to(Integer.class, dynamicAwareTypeConverters), TuplesKt.to(Long.TYPE, dynamicAwareTypeConverters2), TuplesKt.to(Long.class, dynamicAwareTypeConverters2), TuplesKt.to(Double.TYPE, dynamicAwareTypeConverters3), TuplesKt.to(Double.class, dynamicAwareTypeConverters3), TuplesKt.to(Float.TYPE, dynamicAwareTypeConverters4), TuplesKt.to(Float.class, dynamicAwareTypeConverters4), TuplesKt.to(Boolean.TYPE, dynamicAwareTypeConverters5), TuplesKt.to(Boolean.class, dynamicAwareTypeConverters5), TuplesKt.to(String.class, new DynamicAwareTypeConverters<String>() { // from class: expo.modules.kotlin.types.TypeConverterProviderImpl$createCachedConverters$$inlined$createTrivialTypeConverter$6
            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public String convertFromAny(Object value, ConverterContext context, boolean forceConversion) {
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(context, "context");
                return (String) value;
            }

            @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
            /* JADX INFO: renamed from: getCppRequiredTypes, reason: from getter */
            public ExpectedType get$cppRequireType() {
                return expectedType6;
            }

            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public String convertFromDynamic(Dynamic value, ConverterContext context, boolean forceConversion) throws DynamicCastException {
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(context, "context");
                String strAsString = value.asString();
                if (strAsString != null) {
                    return strAsString;
                }
                throw new DynamicCastException((KClass<?>) Reflection.getOrCreateKotlinClass(String.class));
            }
        }), TuplesKt.to(ReadableArray.class, new DynamicAwareTypeConverters<ReadableArray>() { // from class: expo.modules.kotlin.types.TypeConverterProviderImpl$createCachedConverters$$inlined$createTrivialTypeConverter$7
            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public ReadableArray convertFromAny(Object value, ConverterContext context, boolean forceConversion) {
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(context, "context");
                return (ReadableArray) value;
            }

            @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
            /* JADX INFO: renamed from: getCppRequiredTypes, reason: from getter */
            public ExpectedType get$cppRequireType() {
                return expectedType7;
            }

            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public ReadableArray convertFromDynamic(Dynamic value, ConverterContext context, boolean forceConversion) throws DynamicCastException {
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(context, "context");
                ReadableArray readableArrayAsArray = value.asArray();
                if (readableArrayAsArray != null) {
                    return readableArrayAsArray;
                }
                throw new DynamicCastException((KClass<?>) Reflection.getOrCreateKotlinClass(ReadableArray.class));
            }
        }), TuplesKt.to(ReadableMap.class, new DynamicAwareTypeConverters<ReadableMap>() { // from class: expo.modules.kotlin.types.TypeConverterProviderImpl$createCachedConverters$$inlined$createTrivialTypeConverter$8
            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public ReadableMap convertFromAny(Object value, ConverterContext context, boolean forceConversion) {
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(context, "context");
                return (ReadableMap) value;
            }

            @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
            /* JADX INFO: renamed from: getCppRequiredTypes, reason: from getter */
            public ExpectedType get$cppRequireType() {
                return expectedType8;
            }

            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public ReadableMap convertFromDynamic(Dynamic value, ConverterContext context, boolean forceConversion) throws DynamicCastException {
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(context, "context");
                ReadableMap readableMapAsMap = value.asMap();
                if (readableMapAsMap != null) {
                    return readableMapAsMap;
                }
                throw new DynamicCastException((KClass<?>) Reflection.getOrCreateKotlinClass(ReadableMap.class));
            }
        }), TuplesKt.to(byte[].class, new ByteArrayTypeConverter()), TuplesKt.to(JavaScriptValue.class, new DynamicAwareTypeConverters<Object>() { // from class: expo.modules.kotlin.types.TypeConverterProviderImpl$createCachedConverters$$inlined$createTrivialTypeConverter$default$1
            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Object convertFromAny(Object value, ConverterContext context, boolean forceConversion) {
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(context, "context");
                return value;
            }

            @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
            /* JADX INFO: renamed from: getCppRequiredTypes, reason: from getter */
            public ExpectedType get$cppRequireType() {
                return expectedType9;
            }

            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Object convertFromDynamic(Dynamic value, ConverterContext context, boolean forceConversion) throws UnsupportedClass {
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(context, "context");
                throw new UnsupportedClass(Reflection.getOrCreateKotlinClass(Object.class));
            }
        }), TuplesKt.to(JavaScriptObject.class, new DynamicAwareTypeConverters<Object>() { // from class: expo.modules.kotlin.types.TypeConverterProviderImpl$createCachedConverters$$inlined$createTrivialTypeConverter$default$2
            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Object convertFromAny(Object value, ConverterContext context, boolean forceConversion) {
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(context, "context");
                return value;
            }

            @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
            /* JADX INFO: renamed from: getCppRequiredTypes, reason: from getter */
            public ExpectedType get$cppRequireType() {
                return expectedType10;
            }

            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Object convertFromDynamic(Dynamic value, ConverterContext context, boolean forceConversion) throws UnsupportedClass {
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(context, "context");
                throw new UnsupportedClass(Reflection.getOrCreateKotlinClass(Object.class));
            }
        }), TuplesKt.to(JavaScriptArrayBuffer.class, new DynamicAwareTypeConverters<Object>() { // from class: expo.modules.kotlin.types.TypeConverterProviderImpl$createCachedConverters$$inlined$createTrivialTypeConverter$default$3
            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Object convertFromAny(Object value, ConverterContext context, boolean forceConversion) {
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(context, "context");
                return value;
            }

            @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
            /* JADX INFO: renamed from: getCppRequiredTypes, reason: from getter */
            public ExpectedType get$cppRequireType() {
                return expectedType11;
            }

            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Object convertFromDynamic(Dynamic value, ConverterContext context, boolean forceConversion) throws UnsupportedClass {
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(context, "context");
                throw new UnsupportedClass(Reflection.getOrCreateKotlinClass(Object.class));
            }
        }), TuplesKt.to(ArrayBuffer.class, new DynamicAwareTypeConverters<Object>() { // from class: expo.modules.kotlin.types.TypeConverterProviderImpl$createCachedConverters$$inlined$createTrivialTypeConverter$default$4
            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Object convertFromAny(Object value, ConverterContext context, boolean forceConversion) {
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(context, "context");
                return value;
            }

            @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
            /* JADX INFO: renamed from: getCppRequiredTypes, reason: from getter */
            public ExpectedType get$cppRequireType() {
                return expectedType12;
            }

            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Object convertFromDynamic(Dynamic value, ConverterContext context, boolean forceConversion) throws UnsupportedClass {
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(context, "context");
                throw new UnsupportedClass(Reflection.getOrCreateKotlinClass(Object.class));
            }
        }), TuplesKt.to(NativeArrayBuffer.class, new DynamicAwareTypeConverters<Object>() { // from class: expo.modules.kotlin.types.TypeConverterProviderImpl$createCachedConverters$$inlined$createTrivialTypeConverter$default$5
            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Object convertFromAny(Object value, ConverterContext context, boolean forceConversion) {
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(context, "context");
                return value;
            }

            @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
            /* JADX INFO: renamed from: getCppRequiredTypes, reason: from getter */
            public ExpectedType get$cppRequireType() {
                return expectedType13;
            }

            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Object convertFromDynamic(Dynamic value, ConverterContext context, boolean forceConversion) throws UnsupportedClass {
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(context, "context");
                throw new UnsupportedClass(Reflection.getOrCreateKotlinClass(Object.class));
            }
        }), TuplesKt.to(Serializable.class, serializableTypeConverter), TuplesKt.to(Worklet.class, new WorkletTypeConverter(serializableTypeConverter)), TuplesKt.to(Int8Array.class, new Int8ArrayTypeConverter()), TuplesKt.to(Int16Array.class, new Int16ArrayTypeConverter()), TuplesKt.to(Int32Array.class, new Int32ArrayTypeConverter()), TuplesKt.to(Uint8Array.class, new Uint8ArrayTypeConverter()), TuplesKt.to(Uint8ClampedArray.class, new Uint8ClampedArrayTypeConverter()), TuplesKt.to(Uint16Array.class, new Uint16ArrayTypeConverter()), TuplesKt.to(Uint32Array.class, new Uint32ArrayTypeConverter()), TuplesKt.to(Float32Array.class, new Float32ArrayTypeConverter()), TuplesKt.to(Float64Array.class, new Float64ArrayTypeConverter()), TuplesKt.to(BigInt64Array.class, new BigInt64ArrayTypeConverter()), TuplesKt.to(BigUint64Array.class, new BigUint64ArrayTypeConverter()), TuplesKt.to(TypedArray.class, new TypedArrayTypeConverter()), TuplesKt.to(URL.class, new URLTypConverter()), TuplesKt.to(Uri.class, new UriTypeConverter()), TuplesKt.to(URI.class, new JavaURITypeConverter()), TuplesKt.to(File.class, new FileTypeConverter()), TuplesKt.to(Duration.class, new DurationTypeConverter()), TuplesKt.to(Object.class, new AnyTypeConverter()), TuplesKt.to(Color.class, new ColorTypeConverter()), TuplesKt.to(Unit.class, new UnitTypeConverter()), TuplesKt.to(ReadableArguments.class, new ReadableArgumentsTypeConverter()), TuplesKt.to(Dynamic.class, new DynamicAwareTypeConverters<Dynamic>() { // from class: expo.modules.kotlin.types.TypeConverterProviderImpl$createCachedConverters$$inlined$createTrivialTypeConverter$9
            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Dynamic convertFromDynamic(Dynamic value, ConverterContext context, boolean forceConversion) {
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(context, "context");
                return value;
            }

            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public Dynamic convertFromAny(Object value, ConverterContext context, boolean forceConversion) {
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(context, "context");
                return (Dynamic) value;
            }

            @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
            /* JADX INFO: renamed from: getCppRequiredTypes, reason: from getter */
            public ExpectedType get$cppRequireType() {
                return expectedType14;
            }
        }));
        return Build.VERSION.SDK_INT >= 26 ? MapsKt.plus(mapMapOf, MapsKt.mapOf(TuplesKt.to(TSpanView$$ExternalSyntheticApiModelOutline0.m11716m$1(), new PathTypeConverter()), TuplesKt.to(LocalDate.class, new DateTypeConverter()))) : mapMapOf;
    }

    private final Map<Class<?>, TypeConverter<?>> createCachedPrimitiveArrayConverters() {
        final ExpectedType expectedTypeForPrimitiveArray = ExpectedType.INSTANCE.forPrimitiveArray(CppType.INT);
        final ExpectedType expectedTypeForPrimitiveArray2 = ExpectedType.INSTANCE.forPrimitiveArray(CppType.LONG);
        final ExpectedType expectedTypeForPrimitiveArray3 = ExpectedType.INSTANCE.forPrimitiveArray(CppType.DOUBLE);
        final ExpectedType expectedTypeForPrimitiveArray4 = ExpectedType.INSTANCE.forPrimitiveArray(CppType.FLOAT);
        final ExpectedType expectedTypeForPrimitiveArray5 = ExpectedType.INSTANCE.forPrimitiveArray(CppType.BOOLEAN);
        return MapsKt.mapOf(TuplesKt.to(int[].class, new DynamicAwareTypeConverters<int[]>() { // from class: expo.modules.kotlin.types.TypeConverterProviderImpl$createCachedPrimitiveArrayConverters$$inlined$createTrivialTypeConverter$1
            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public int[] convertFromAny(Object value, ConverterContext context, boolean forceConversion) {
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(context, "context");
                return (int[]) value;
            }

            @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
            /* JADX INFO: renamed from: getCppRequiredTypes, reason: from getter */
            public ExpectedType get$cppRequireType() {
                return expectedTypeForPrimitiveArray;
            }

            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public int[] convertFromDynamic(Dynamic value, ConverterContext context, boolean forceConversion) throws DynamicCastException {
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(context, "context");
                ReadableArray readableArrayAsArray = value.asArray();
                if (readableArrayAsArray == null) {
                    throw new DynamicCastException((KClass<?>) Reflection.getOrCreateKotlinClass(ReadableArray.class));
                }
                int size = readableArrayAsArray.size();
                int[] iArr = new int[size];
                for (int i = 0; i < size; i++) {
                    iArr[i] = readableArrayAsArray.getInt(i);
                }
                return iArr;
            }
        }), TuplesKt.to(long[].class, new DynamicAwareTypeConverters<long[]>() { // from class: expo.modules.kotlin.types.TypeConverterProviderImpl$createCachedPrimitiveArrayConverters$$inlined$createTrivialTypeConverter$2
            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public long[] convertFromAny(Object value, ConverterContext context, boolean forceConversion) {
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(context, "context");
                return (long[]) value;
            }

            @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
            /* JADX INFO: renamed from: getCppRequiredTypes, reason: from getter */
            public ExpectedType get$cppRequireType() {
                return expectedTypeForPrimitiveArray2;
            }

            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public long[] convertFromDynamic(Dynamic value, ConverterContext context, boolean forceConversion) throws DynamicCastException {
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(context, "context");
                ReadableArray readableArrayAsArray = value.asArray();
                if (readableArrayAsArray == null) {
                    throw new DynamicCastException((KClass<?>) Reflection.getOrCreateKotlinClass(ReadableArray.class));
                }
                int size = readableArrayAsArray.size();
                long[] jArr = new long[size];
                for (int i = 0; i < size; i++) {
                    jArr[i] = (long) readableArrayAsArray.getDouble(i);
                }
                return jArr;
            }
        }), TuplesKt.to(double[].class, new DynamicAwareTypeConverters<double[]>() { // from class: expo.modules.kotlin.types.TypeConverterProviderImpl$createCachedPrimitiveArrayConverters$$inlined$createTrivialTypeConverter$3
            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public double[] convertFromAny(Object value, ConverterContext context, boolean forceConversion) {
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(context, "context");
                return (double[]) value;
            }

            @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
            /* JADX INFO: renamed from: getCppRequiredTypes, reason: from getter */
            public ExpectedType get$cppRequireType() {
                return expectedTypeForPrimitiveArray3;
            }

            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public double[] convertFromDynamic(Dynamic value, ConverterContext context, boolean forceConversion) throws DynamicCastException {
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(context, "context");
                ReadableArray readableArrayAsArray = value.asArray();
                if (readableArrayAsArray == null) {
                    throw new DynamicCastException((KClass<?>) Reflection.getOrCreateKotlinClass(ReadableArray.class));
                }
                int size = readableArrayAsArray.size();
                double[] dArr = new double[size];
                for (int i = 0; i < size; i++) {
                    dArr[i] = readableArrayAsArray.getDouble(i);
                }
                return dArr;
            }
        }), TuplesKt.to(float[].class, new DynamicAwareTypeConverters<float[]>() { // from class: expo.modules.kotlin.types.TypeConverterProviderImpl$createCachedPrimitiveArrayConverters$$inlined$createTrivialTypeConverter$4
            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public float[] convertFromAny(Object value, ConverterContext context, boolean forceConversion) {
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(context, "context");
                return (float[]) value;
            }

            @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
            /* JADX INFO: renamed from: getCppRequiredTypes, reason: from getter */
            public ExpectedType get$cppRequireType() {
                return expectedTypeForPrimitiveArray4;
            }

            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public float[] convertFromDynamic(Dynamic value, ConverterContext context, boolean forceConversion) throws DynamicCastException {
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(context, "context");
                ReadableArray readableArrayAsArray = value.asArray();
                if (readableArrayAsArray == null) {
                    throw new DynamicCastException((KClass<?>) Reflection.getOrCreateKotlinClass(ReadableArray.class));
                }
                int size = readableArrayAsArray.size();
                float[] fArr = new float[size];
                for (int i = 0; i < size; i++) {
                    fArr[i] = (float) readableArrayAsArray.getDouble(i);
                }
                return fArr;
            }
        }), TuplesKt.to(boolean[].class, new DynamicAwareTypeConverters<boolean[]>() { // from class: expo.modules.kotlin.types.TypeConverterProviderImpl$createCachedPrimitiveArrayConverters$$inlined$createTrivialTypeConverter$5
            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public boolean[] convertFromAny(Object value, ConverterContext context, boolean forceConversion) {
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(context, "context");
                return (boolean[]) value;
            }

            @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
            /* JADX INFO: renamed from: getCppRequiredTypes, reason: from getter */
            public ExpectedType get$cppRequireType() {
                return expectedTypeForPrimitiveArray5;
            }

            @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
            public boolean[] convertFromDynamic(Dynamic value, ConverterContext context, boolean forceConversion) throws DynamicCastException {
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(context, "context");
                ReadableArray readableArrayAsArray = value.asArray();
                if (readableArrayAsArray == null) {
                    throw new DynamicCastException((KClass<?>) Reflection.getOrCreateKotlinClass(ReadableArray.class));
                }
                int size = readableArrayAsArray.size();
                boolean[] zArr = new boolean[size];
                for (int i = 0; i < size; i++) {
                    zArr[i] = readableArrayAsArray.getBoolean(i);
                }
                return zArr;
            }
        }));
    }

    private final TypeConverter<?> handelEither(TypeDescriptor typeDescriptor) {
        Class<?> jClass = typeDescriptor.getTypeInfo().getJClass();
        if (!Either.class.isAssignableFrom(jClass)) {
            return null;
        }
        if (EitherOfFour.class.isAssignableFrom(jClass)) {
            return new EitherOfFourTypeConverter(this, typeDescriptor);
        }
        if (EitherOfThree.class.isAssignableFrom(jClass)) {
            return new EitherOfThreeTypeConverter(this, typeDescriptor);
        }
        return new EitherTypeConverter(this, typeDescriptor);
    }
}
