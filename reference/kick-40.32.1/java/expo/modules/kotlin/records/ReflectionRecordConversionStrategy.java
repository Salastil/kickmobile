package expo.modules.kotlin.records;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableMap;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.FieldCastException;
import expo.modules.kotlin.exception.FieldRequiredException;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.types.ConverterContext;
import expo.modules.kotlin.types.TypeConverter;
import expo.modules.kotlin.types.TypeConverterProvider;
import expo.modules.kotlin.types.descriptors.TypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptorKt;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KProperty1;
import kotlin.reflect.full.KClasses;
import kotlin.reflect.jvm.ReflectJvmMapping;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: RecordTypeConverter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u001fB\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ%\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016¢\u0006\u0002\u0010\u001aJ3\u0010\u001b\u001a\u00028\u00002\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016¢\u0006\u0002\u0010\u001eR3\u0010\n\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0006\b\u0001\u0012\u00020\r\u0012\u0002\b\u00030\f\u0012\u0004\u0012\u00020\u000e0\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006 "}, d2 = {"Lexpo/modules/kotlin/records/ReflectionRecordConversionStrategy;", ExifInterface.GPS_DIRECTION_TRUE, "Lexpo/modules/kotlin/records/Record;", "Lexpo/modules/kotlin/records/RecordConversionStrategy;", "converterProvider", "Lexpo/modules/kotlin/types/TypeConverterProvider;", "typeDescriptor", "Lexpo/modules/kotlin/types/descriptors/TypeDescriptor;", "<init>", "(Lexpo/modules/kotlin/types/TypeConverterProvider;Lexpo/modules/kotlin/types/descriptors/TypeDescriptor;)V", "propertyDescriptors", "", "Lkotlin/reflect/KProperty1;", "", "Lexpo/modules/kotlin/records/ReflectionRecordConversionStrategy$PropertyDescriptor;", "getPropertyDescriptors", "()Ljava/util/Map;", "propertyDescriptors$delegate", "Lkotlin/Lazy;", "convertFromReadableMap", "jsMap", "Lcom/facebook/react/bridge/ReadableMap;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lexpo/modules/kotlin/types/ConverterContext;", "forceConversion", "", "(Lcom/facebook/react/bridge/ReadableMap;Lexpo/modules/kotlin/types/ConverterContext;Z)Lexpo/modules/kotlin/records/Record;", "convertFromMap", "map", "", "(Ljava/util/Map;Lexpo/modules/kotlin/types/ConverterContext;Z)Lexpo/modules/kotlin/records/Record;", "PropertyDescriptor", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ReflectionRecordConversionStrategy<T extends Record> extends RecordConversionStrategy<T> {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: propertyDescriptors$delegate, reason: from kotlin metadata */
    private final Lazy propertyDescriptors;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReflectionRecordConversionStrategy(final TypeConverterProvider converterProvider, final TypeDescriptor typeDescriptor) {
        super(converterProvider, typeDescriptor);
        Intrinsics.checkNotNullParameter(converterProvider, "converterProvider");
        Intrinsics.checkNotNullParameter(typeDescriptor, "typeDescriptor");
        this.propertyDescriptors = LazyKt.lazy(new Function0() { // from class: expo.modules.kotlin.records.ReflectionRecordConversionStrategy$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ReflectionRecordConversionStrategy.propertyDescriptors_delegate$lambda$0(typeDescriptor, converterProvider);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: RecordTypeConverter.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B#\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J+\u0010\u0012\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0005HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000e¨\u0006\u0018"}, d2 = {"Lexpo/modules/kotlin/records/ReflectionRecordConversionStrategy$PropertyDescriptor;", "", "typeConverter", "Lexpo/modules/kotlin/types/TypeConverter;", "key", "", "isRequired", "", "<init>", "(Lexpo/modules/kotlin/types/TypeConverter;Ljava/lang/String;Z)V", "getTypeConverter", "()Lexpo/modules/kotlin/types/TypeConverter;", "getKey", "()Ljava/lang/String;", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    static final /* data */ class PropertyDescriptor {
        private final boolean isRequired;
        private final String key;
        private final TypeConverter<?> typeConverter;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PropertyDescriptor copy$default(PropertyDescriptor propertyDescriptor, TypeConverter typeConverter, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                typeConverter = propertyDescriptor.typeConverter;
            }
            if ((i & 2) != 0) {
                str = propertyDescriptor.key;
            }
            if ((i & 4) != 0) {
                z = propertyDescriptor.isRequired;
            }
            return propertyDescriptor.copy(typeConverter, str, z);
        }

        public final TypeConverter<?> component1() {
            return this.typeConverter;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getKey() {
            return this.key;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getIsRequired() {
            return this.isRequired;
        }

        public final PropertyDescriptor copy(TypeConverter<?> typeConverter, String key, boolean isRequired) {
            Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
            Intrinsics.checkNotNullParameter(key, "key");
            return new PropertyDescriptor(typeConverter, key, isRequired);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PropertyDescriptor)) {
                return false;
            }
            PropertyDescriptor propertyDescriptor = (PropertyDescriptor) other;
            return Intrinsics.areEqual(this.typeConverter, propertyDescriptor.typeConverter) && Intrinsics.areEqual(this.key, propertyDescriptor.key) && this.isRequired == propertyDescriptor.isRequired;
        }

        public int hashCode() {
            return (((this.typeConverter.hashCode() * 31) + this.key.hashCode()) * 31) + Boolean.hashCode(this.isRequired);
        }

        public String toString() {
            return "PropertyDescriptor(typeConverter=" + this.typeConverter + ", key=" + this.key + ", isRequired=" + this.isRequired + ")";
        }

        public PropertyDescriptor(TypeConverter<?> typeConverter, String key, boolean z) {
            Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
            Intrinsics.checkNotNullParameter(key, "key");
            this.typeConverter = typeConverter;
            this.key = key;
            this.isRequired = z;
        }

        public final TypeConverter<?> getTypeConverter() {
            return this.typeConverter;
        }

        public final String getKey() {
            return this.key;
        }

        public final boolean isRequired() {
            return this.isRequired;
        }
    }

    private final Map<KProperty1<? extends Object, ?>, PropertyDescriptor> getPropertyDescriptors() {
        return (Map) this.propertyDescriptors.getValue();
    }

    @Override // expo.modules.kotlin.records.RecordConversionStrategy
    public T convertFromReadableMap(ReadableMap jsMap, ConverterContext context, boolean forceConversion) throws FieldRequiredException {
        UnexpectedException codedException;
        Intrinsics.checkNotNullParameter(jsMap, "jsMap");
        Intrinsics.checkNotNullParameter(context, "context");
        T tConstruct = getObjectConstructor(JvmClassMappingKt.getKotlinClass(getTypeDescriptor().getTypeInfo().getJClass())).construct();
        for (Map.Entry<KProperty1<? extends Object, ?>, PropertyDescriptor> entry : getPropertyDescriptors().entrySet()) {
            KProperty1<? extends Object, ?> key = entry.getKey();
            PropertyDescriptor value = entry.getValue();
            String key2 = value.getKey();
            if (!jsMap.hasKey(key2)) {
                if (value.isRequired()) {
                    throw new FieldRequiredException(key);
                }
            } else {
                Dynamic dynamic = jsMap.getDynamic(key2);
                try {
                    java.lang.reflect.Field javaField = ReflectJvmMapping.getJavaField(key);
                    Intrinsics.checkNotNull(javaField);
                    try {
                        Object objConvert = value.getTypeConverter().convert(dynamic, context, forceConversion);
                        javaField.setAccessible(true);
                        javaField.set(tConstruct, objConvert);
                        Unit unit = Unit.INSTANCE;
                        dynamic.recycle();
                    } catch (Throwable th) {
                        if (th instanceof CodedException) {
                            codedException = (CodedException) th;
                        } else {
                            codedException = th instanceof expo.modules.core.errors.CodedException ? new CodedException(((expo.modules.core.errors.CodedException) th).getCode(), ((expo.modules.core.errors.CodedException) th).getMessage(), ((expo.modules.core.errors.CodedException) th).getCause()) : new UnexpectedException(th);
                        }
                        throw new FieldCastException(key.getName(), key.getReturnType(), getTypeDescriptor(), codedException);
                    }
                } catch (Throwable th2) {
                    dynamic.recycle();
                    throw th2;
                }
            }
        }
        Intrinsics.checkNotNull(tConstruct, "null cannot be cast to non-null type T of expo.modules.kotlin.records.ReflectionRecordConversionStrategy");
        return tConstruct;
    }

    @Override // expo.modules.kotlin.records.RecordConversionStrategy
    public T convertFromMap(Map<String, ? extends Object> map, ConverterContext context, boolean forceConversion) throws IllegalAccessException, FieldCastException, FieldRequiredException {
        UnexpectedException unexpectedException;
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(context, "context");
        T tConstruct = getObjectConstructor(JvmClassMappingKt.getKotlinClass(getTypeDescriptor().getTypeInfo().getJClass())).construct();
        for (Map.Entry<KProperty1<? extends Object, ?>, PropertyDescriptor> entry : getPropertyDescriptors().entrySet()) {
            KProperty1<? extends Object, ?> key = entry.getKey();
            PropertyDescriptor value = entry.getValue();
            String key2 = value.getKey();
            if (!map.containsKey(key2)) {
                if (value.isRequired()) {
                    throw new FieldRequiredException(key);
                }
            } else {
                Double dValueOf = map.get(key2);
                if (dValueOf instanceof Number) {
                    KClassifier classifier = key.getReturnType().getClassifier();
                    if (Intrinsics.areEqual(classifier, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        dValueOf = Integer.valueOf(((Number) dValueOf).intValue());
                    } else if (Intrinsics.areEqual(classifier, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        dValueOf = Long.valueOf(((Number) dValueOf).longValue());
                    } else if (Intrinsics.areEqual(classifier, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        dValueOf = Float.valueOf(((Number) dValueOf).floatValue());
                    } else {
                        dValueOf = Intrinsics.areEqual(classifier, Reflection.getOrCreateKotlinClass(Double.TYPE)) ? Double.valueOf(((Number) dValueOf).doubleValue()) : (Number) dValueOf;
                    }
                }
                java.lang.reflect.Field javaField = ReflectJvmMapping.getJavaField(key);
                Intrinsics.checkNotNull(javaField);
                try {
                    Object objConvert = value.getTypeConverter().convert(dValueOf, context, forceConversion);
                    javaField.setAccessible(true);
                    javaField.set(tConstruct, objConvert);
                } catch (Throwable th) {
                    if (th instanceof CodedException) {
                        unexpectedException = (CodedException) th;
                    } else if (th instanceof expo.modules.core.errors.CodedException) {
                        expo.modules.core.errors.CodedException codedException = (expo.modules.core.errors.CodedException) th;
                        unexpectedException = new CodedException(codedException.getCode(), codedException.getMessage(), codedException.getCause());
                    } else {
                        unexpectedException = new UnexpectedException(th);
                    }
                    throw new FieldCastException(key.getName(), key.getReturnType(), getTypeDescriptor(), unexpectedException);
                }
            }
        }
        Intrinsics.checkNotNull(tConstruct, "null cannot be cast to non-null type T of expo.modules.kotlin.records.ReflectionRecordConversionStrategy");
        return tConstruct;
    }

    static final Map propertyDescriptors_delegate$lambda$0(TypeDescriptor typeDescriptor, TypeConverterProvider typeConverterProvider) {
        Object obj;
        Object next;
        Collection<KProperty1> memberProperties = KClasses.getMemberProperties(JvmClassMappingKt.getKotlinClass(typeDescriptor.getTypeInfo().getJClass()));
        ArrayList arrayList = new ArrayList();
        for (KProperty1 kProperty1 : memberProperties) {
            KProperty1 kProperty2 = kProperty1;
            Iterator<T> it = kProperty2.getAnnotations().iterator();
            do {
                obj = null;
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!(((Annotation) next) instanceof Field));
            Field field = (Field) next;
            if (field != null) {
                TypeConverter<?> typeConverterObtainTypeConverter = typeConverterProvider.obtainTypeConverter(TypeDescriptorKt.toTypeDescriptor(kProperty1.getReturnType()));
                String strKey = field.key();
                if (StringsKt.isBlank(strKey)) {
                    strKey = null;
                }
                if (strKey == null) {
                    strKey = kProperty1.getName();
                }
                for (Object obj2 : kProperty2.getAnnotations()) {
                    if (((Annotation) obj2) instanceof Required) {
                        obj = obj2;
                        break;
                    }
                }
                obj = TuplesKt.to(kProperty1, new PropertyDescriptor(typeConverterObtainTypeConverter, strKey, ((Required) obj) != null));
            }
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return MapsKt.toMap(arrayList);
    }
}
