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
import expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt;
import io.github.expo.pika.PAnnotation;
import io.github.expo.pika.PIntrospectionData;
import io.github.expo.pika.PProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: RecordTypeConverter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001#B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ%\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016¢\u0006\u0002\u0010\u001cJ3\u0010\u001d\u001a\u00028\u00002\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0006\u0012\u0004\u0018\u00010!0\u001f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016¢\u0006\u0002\u0010\"R\u0015\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012¨\u0006$"}, d2 = {"Lexpo/modules/kotlin/records/IntrospectableRecordConversionStrategy;", ExifInterface.GPS_DIRECTION_TRUE, "Lexpo/modules/kotlin/records/Record;", "Lexpo/modules/kotlin/records/RecordConversionStrategy;", "converterProvider", "Lexpo/modules/kotlin/types/TypeConverterProvider;", "typeDescriptor", "Lexpo/modules/kotlin/types/descriptors/TypeDescriptor;", "<init>", "(Lexpo/modules/kotlin/types/TypeConverterProvider;Lexpo/modules/kotlin/types/descriptors/TypeDescriptor;)V", "introspectableData", "Lio/github/expo/pika/PIntrospectionData;", "getIntrospectableData", "()Lio/github/expo/pika/PIntrospectionData;", "propertyDescriptors", "", "Lexpo/modules/kotlin/records/IntrospectableRecordConversionStrategy$PropertyDescriptor;", "getPropertyDescriptors", "()Ljava/util/List;", "propertyDescriptors$delegate", "Lkotlin/Lazy;", "convertFromReadableMap", "jsMap", "Lcom/facebook/react/bridge/ReadableMap;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lexpo/modules/kotlin/types/ConverterContext;", "forceConversion", "", "(Lcom/facebook/react/bridge/ReadableMap;Lexpo/modules/kotlin/types/ConverterContext;Z)Lexpo/modules/kotlin/records/Record;", "convertFromMap", "map", "", "", "", "(Ljava/util/Map;Lexpo/modules/kotlin/types/ConverterContext;Z)Lexpo/modules/kotlin/records/Record;", "PropertyDescriptor", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class IntrospectableRecordConversionStrategy<T extends Record> extends RecordConversionStrategy<T> {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: propertyDescriptors$delegate, reason: from kotlin metadata */
    private final Lazy propertyDescriptors;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IntrospectableRecordConversionStrategy(final TypeConverterProvider converterProvider, TypeDescriptor typeDescriptor) {
        super(converterProvider, typeDescriptor);
        Intrinsics.checkNotNullParameter(converterProvider, "converterProvider");
        Intrinsics.checkNotNullParameter(typeDescriptor, "typeDescriptor");
        this.propertyDescriptors = LazyKt.lazy(new Function0() { // from class: expo.modules.kotlin.records.IntrospectableRecordConversionStrategy$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return IntrospectableRecordConversionStrategy.propertyDescriptors_delegate$lambda$0(this.f$0, converterProvider);
            }
        });
    }

    public final PIntrospectionData<?> getIntrospectableData() {
        PIntrospectionData<?> introspection = getTypeDescriptor().getTypeInfo().getIntrospection();
        if (introspection != null) {
            return introspection;
        }
        throw new IllegalArgumentException("Introspectable data is required for IntrospectableRecordConversionStrategy".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: RecordTypeConverter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\r\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\nHÆ\u0003J\t\u0010\u001c\u001a\u00020\fHÆ\u0003JS\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\b0\u00072\f\b\u0002\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0014\u0010\u001e\u001a\u00020\f2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010 \u001a\u00020!HÖ\u0081\u0004J\n\u0010\"\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R%\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0017¨\u0006#"}, d2 = {"Lexpo/modules/kotlin/records/IntrospectableRecordConversionStrategy$PropertyDescriptor;", "", "key", "", "typeDescriptor", "Lexpo/modules/kotlin/types/descriptors/TypeDescriptor;", "setter", "Lkotlin/Function2;", "", "typeConverter", "Lexpo/modules/kotlin/types/TypeConverter;", "isRequired", "", "<init>", "(Ljava/lang/String;Lexpo/modules/kotlin/types/descriptors/TypeDescriptor;Lkotlin/jvm/functions/Function2;Lexpo/modules/kotlin/types/TypeConverter;Z)V", "getKey", "()Ljava/lang/String;", "getTypeDescriptor", "()Lexpo/modules/kotlin/types/descriptors/TypeDescriptor;", "getSetter", "()Lkotlin/jvm/functions/Function2;", "getTypeConverter", "()Lexpo/modules/kotlin/types/TypeConverter;", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    static final /* data */ class PropertyDescriptor {
        private final boolean isRequired;
        private final String key;
        private final Function2<Object, Object, Unit> setter;
        private final TypeConverter<?> typeConverter;
        private final TypeDescriptor typeDescriptor;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PropertyDescriptor copy$default(PropertyDescriptor propertyDescriptor, String str, TypeDescriptor typeDescriptor, Function2 function2, TypeConverter typeConverter, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = propertyDescriptor.key;
            }
            if ((i & 2) != 0) {
                typeDescriptor = propertyDescriptor.typeDescriptor;
            }
            if ((i & 4) != 0) {
                function2 = propertyDescriptor.setter;
            }
            if ((i & 8) != 0) {
                typeConverter = propertyDescriptor.typeConverter;
            }
            if ((i & 16) != 0) {
                z = propertyDescriptor.isRequired;
            }
            boolean z2 = z;
            Function2 function3 = function2;
            return propertyDescriptor.copy(str, typeDescriptor, function3, typeConverter, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getKey() {
            return this.key;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final TypeDescriptor getTypeDescriptor() {
            return this.typeDescriptor;
        }

        public final Function2<Object, Object, Unit> component3() {
            return this.setter;
        }

        public final TypeConverter<?> component4() {
            return this.typeConverter;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getIsRequired() {
            return this.isRequired;
        }

        public final PropertyDescriptor copy(String key, TypeDescriptor typeDescriptor, Function2<Object, Object, Unit> setter, TypeConverter<?> typeConverter, boolean isRequired) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(typeDescriptor, "typeDescriptor");
            Intrinsics.checkNotNullParameter(setter, "setter");
            Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
            return new PropertyDescriptor(key, typeDescriptor, setter, typeConverter, isRequired);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PropertyDescriptor)) {
                return false;
            }
            PropertyDescriptor propertyDescriptor = (PropertyDescriptor) other;
            return Intrinsics.areEqual(this.key, propertyDescriptor.key) && Intrinsics.areEqual(this.typeDescriptor, propertyDescriptor.typeDescriptor) && Intrinsics.areEqual(this.setter, propertyDescriptor.setter) && Intrinsics.areEqual(this.typeConverter, propertyDescriptor.typeConverter) && this.isRequired == propertyDescriptor.isRequired;
        }

        public int hashCode() {
            return (((((((this.key.hashCode() * 31) + this.typeDescriptor.hashCode()) * 31) + this.setter.hashCode()) * 31) + this.typeConverter.hashCode()) * 31) + Boolean.hashCode(this.isRequired);
        }

        public String toString() {
            return "PropertyDescriptor(key=" + this.key + ", typeDescriptor=" + this.typeDescriptor + ", setter=" + this.setter + ", typeConverter=" + this.typeConverter + ", isRequired=" + this.isRequired + ")";
        }

        public PropertyDescriptor(String key, TypeDescriptor typeDescriptor, Function2<Object, Object, Unit> setter, TypeConverter<?> typeConverter, boolean z) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(typeDescriptor, "typeDescriptor");
            Intrinsics.checkNotNullParameter(setter, "setter");
            Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
            this.key = key;
            this.typeDescriptor = typeDescriptor;
            this.setter = setter;
            this.typeConverter = typeConverter;
            this.isRequired = z;
        }

        public final String getKey() {
            return this.key;
        }

        public final TypeDescriptor getTypeDescriptor() {
            return this.typeDescriptor;
        }

        public final Function2<Object, Object, Unit> getSetter() {
            return this.setter;
        }

        public final TypeConverter<?> getTypeConverter() {
            return this.typeConverter;
        }

        public final boolean isRequired() {
            return this.isRequired;
        }
    }

    private final List<PropertyDescriptor> getPropertyDescriptors() {
        return (List) this.propertyDescriptors.getValue();
    }

    static final List propertyDescriptors_delegate$lambda$0(IntrospectableRecordConversionStrategy introspectableRecordConversionStrategy, TypeConverterProvider typeConverterProvider) {
        PropertyDescriptor propertyDescriptor;
        PAnnotation pAnnotation;
        boolean z;
        PProperty<?, ?>[] properties = introspectableRecordConversionStrategy.getIntrospectableData().getProperties();
        ArrayList arrayList = new ArrayList();
        for (PProperty<?, ?> pProperty : properties) {
            PAnnotation[] annotations = pProperty.getAnnotations();
            int length = annotations.length;
            int i = 0;
            while (true) {
                propertyDescriptor = null;
                if (i >= length) {
                    pAnnotation = null;
                    break;
                }
                pAnnotation = annotations[i];
                if (Intrinsics.areEqual(pAnnotation.getJClass(), Field.class)) {
                    break;
                }
                i++;
            }
            if (pAnnotation != null) {
                Object orDefault = pAnnotation.getArguments().getOrDefault("key", pProperty.getName());
                Intrinsics.checkNotNull(orDefault, "null cannot be cast to non-null type kotlin.String");
                String name = (String) orDefault;
                if (name.length() == 0) {
                    name = pProperty.getName();
                }
                String str = name;
                PAnnotation[] annotations2 = pProperty.getAnnotations();
                int length2 = annotations2.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length2) {
                        z = false;
                        break;
                    }
                    if (Intrinsics.areEqual(annotations2[i2].getJClass(), Required.class)) {
                        z = true;
                        break;
                    }
                    i2++;
                }
                TypeDescriptor typeDescriptor = new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(pProperty.getType()), new Function0() { // from class: expo.modules.kotlin.records.IntrospectableRecordConversionStrategy$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return IntrospectableRecordConversionStrategy.propertyDescriptors_delegate$lambda$0$0$3();
                    }
                });
                propertyDescriptor = new PropertyDescriptor(str, typeDescriptor, (Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(new IntrospectableRecordConversionStrategy$propertyDescriptors$2$1$1(pProperty), 2), typeConverterProvider.obtainTypeConverter(typeDescriptor), z);
            }
            if (propertyDescriptor != null) {
                arrayList.add(propertyDescriptor);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KType propertyDescriptors_delegate$lambda$0$0$3() {
        throw new IllegalStateException("CT type can't be obtain as KType".toString());
    }

    @Override // expo.modules.kotlin.records.RecordConversionStrategy
    public T convertFromReadableMap(ReadableMap jsMap, ConverterContext context, boolean forceConversion) throws FieldRequiredException {
        UnexpectedException codedException;
        Intrinsics.checkNotNullParameter(jsMap, "jsMap");
        Intrinsics.checkNotNullParameter(context, "context");
        T tConstruct = getObjectConstructor(JvmClassMappingKt.getKotlinClass(getTypeDescriptor().getTypeInfo().getJClass())).construct();
        for (PropertyDescriptor propertyDescriptor : getPropertyDescriptors()) {
            String key = propertyDescriptor.getKey();
            if (!jsMap.hasKey(key)) {
                if (propertyDescriptor.isRequired()) {
                    throw new FieldRequiredException(key);
                }
            } else {
                Dynamic dynamic = jsMap.getDynamic(key);
                try {
                    try {
                        propertyDescriptor.getSetter().invoke(tConstruct, propertyDescriptor.getTypeConverter().convert(dynamic, context, forceConversion));
                        Unit unit = Unit.INSTANCE;
                        dynamic.recycle();
                    } catch (Throwable th) {
                        dynamic.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    if (th2 instanceof CodedException) {
                        codedException = (CodedException) th2;
                    } else {
                        codedException = th2 instanceof expo.modules.core.errors.CodedException ? new CodedException(((expo.modules.core.errors.CodedException) th2).getCode(), ((expo.modules.core.errors.CodedException) th2).getMessage(), ((expo.modules.core.errors.CodedException) th2).getCause()) : new UnexpectedException(th2);
                    }
                    throw new FieldCastException(propertyDescriptor.getKey(), propertyDescriptor.getTypeDescriptor(), getTypeDescriptor(), codedException);
                }
            }
        }
        Intrinsics.checkNotNull(tConstruct, "null cannot be cast to non-null type T of expo.modules.kotlin.records.IntrospectableRecordConversionStrategy");
        return tConstruct;
    }

    @Override // expo.modules.kotlin.records.RecordConversionStrategy
    public T convertFromMap(Map<String, ? extends Object> map, ConverterContext context, boolean forceConversion) throws FieldCastException, FieldRequiredException {
        UnexpectedException unexpectedException;
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(context, "context");
        T tConstruct = getObjectConstructor(JvmClassMappingKt.getKotlinClass(getTypeDescriptor().getTypeInfo().getJClass())).construct();
        for (PropertyDescriptor propertyDescriptor : getPropertyDescriptors()) {
            String key = propertyDescriptor.getKey();
            if (!map.containsKey(key)) {
                if (propertyDescriptor.isRequired()) {
                    throw new FieldRequiredException(key);
                }
            } else {
                Double dValueOf = map.get(key);
                if (dValueOf instanceof Number) {
                    Class<?> jClass = propertyDescriptor.getTypeDescriptor().getTypeInfo().getJClass();
                    if (Intrinsics.areEqual(jClass, Integer.TYPE)) {
                        dValueOf = Integer.valueOf(((Number) dValueOf).intValue());
                    } else if (Intrinsics.areEqual(jClass, Long.TYPE)) {
                        dValueOf = Long.valueOf(((Number) dValueOf).longValue());
                    } else if (Intrinsics.areEqual(jClass, Float.TYPE)) {
                        dValueOf = Float.valueOf(((Number) dValueOf).floatValue());
                    } else {
                        dValueOf = Intrinsics.areEqual(jClass, Double.TYPE) ? Double.valueOf(((Number) dValueOf).doubleValue()) : (Number) dValueOf;
                    }
                }
                try {
                    propertyDescriptor.getSetter().invoke(tConstruct, propertyDescriptor.getTypeConverter().convert(dValueOf, context, forceConversion));
                } catch (Throwable th) {
                    if (th instanceof CodedException) {
                        unexpectedException = (CodedException) th;
                    } else if (th instanceof expo.modules.core.errors.CodedException) {
                        expo.modules.core.errors.CodedException codedException = (expo.modules.core.errors.CodedException) th;
                        unexpectedException = new CodedException(codedException.getCode(), codedException.getMessage(), codedException.getCause());
                    } else {
                        unexpectedException = new UnexpectedException(th);
                    }
                    throw new FieldCastException(propertyDescriptor.getKey(), propertyDescriptor.getTypeDescriptor(), dValueOf, unexpectedException);
                }
            }
        }
        Intrinsics.checkNotNull(tConstruct, "null cannot be cast to non-null type T of expo.modules.kotlin.records.IntrospectableRecordConversionStrategy");
        return tConstruct;
    }
}
