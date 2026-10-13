package expo.modules.kotlin.types;

import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.ReadableMap;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.CollectionElementCastException;
import expo.modules.kotlin.exception.DynamicCastException;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.types.descriptors.RawTypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptor$params$1$1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: MapTypeConverter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ(\u0010\u000b\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J(\u0010\u0012\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010\f\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J(\u0010\u0014\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0011H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lexpo/modules/kotlin/types/MapTypeConverter;", "Lexpo/modules/kotlin/types/DynamicAwareTypeConverters;", "", "converterProvider", "Lexpo/modules/kotlin/types/TypeConverterProvider;", "mapType", "Lexpo/modules/kotlin/types/descriptors/TypeDescriptor;", "<init>", "(Lexpo/modules/kotlin/types/TypeConverterProvider;Lexpo/modules/kotlin/types/descriptors/TypeDescriptor;)V", "valueConverter", "Lexpo/modules/kotlin/types/TypeConverter;", "convertFromDynamic", "value", "Lcom/facebook/react/bridge/Dynamic;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lexpo/modules/kotlin/types/ConverterContext;", "forceConversion", "", "convertFromAny", "", "convertFromReadableMap", "jsMap", "Lcom/facebook/react/bridge/ReadableMap;", "getCppRequiredTypes", "Lexpo/modules/kotlin/jni/ExpectedType;", "isTrivial", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MapTypeConverter extends DynamicAwareTypeConverters<Map<?, ?>> {
    public static final int $stable = 8;
    private final TypeDescriptor mapType;
    private final TypeConverter<?> valueConverter;

    public MapTypeConverter(TypeConverterProvider converterProvider, TypeDescriptor mapType) {
        ArrayList arrayListEmptyList;
        ArrayList arrayListEmptyList2;
        ArrayList arrayListEmptyList3;
        Intrinsics.checkNotNullParameter(converterProvider, "converterProvider");
        Intrinsics.checkNotNullParameter(mapType, "mapType");
        this.mapType = mapType;
        RawTypeDescriptor typeInfo = mapType.getTypeInfo();
        int i = 0;
        if (typeInfo instanceof RawTypeDescriptor.Simple) {
            arrayListEmptyList = CollectionsKt.emptyList();
        } else if (typeInfo instanceof RawTypeDescriptor.Parameterized) {
            List<RawTypeDescriptor> params = ((RawTypeDescriptor.Parameterized) mapType.getTypeInfo()).getParams();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(params, 10));
            int i2 = 0;
            for (Object obj : params) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                arrayList.add(new TypeDescriptor((RawTypeDescriptor) obj, new TypeDescriptor$params$1$1(mapType, i2)));
                i2 = i3;
            }
            arrayListEmptyList = arrayList;
        } else {
            if (!Intrinsics.areEqual(typeInfo, RawTypeDescriptor.Star.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            arrayListEmptyList = CollectionsKt.emptyList();
        }
        boolean zAreEqual = Intrinsics.areEqual(((TypeDescriptor) CollectionsKt.first(arrayListEmptyList)).getTypeInfo().getJClass(), String.class);
        TypeDescriptor typeDescriptor = this.mapType;
        if (!zAreEqual) {
            RawTypeDescriptor typeInfo2 = typeDescriptor.getTypeInfo();
            if (typeInfo2 instanceof RawTypeDescriptor.Simple) {
                arrayListEmptyList3 = CollectionsKt.emptyList();
            } else if (typeInfo2 instanceof RawTypeDescriptor.Parameterized) {
                List<RawTypeDescriptor> params2 = ((RawTypeDescriptor.Parameterized) typeDescriptor.getTypeInfo()).getParams();
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(params2, 10));
                for (Object obj2 : params2) {
                    int i4 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    arrayList2.add(new TypeDescriptor((RawTypeDescriptor) obj2, new TypeDescriptor$params$1$1(typeDescriptor, i)));
                    i = i4;
                }
                arrayListEmptyList3 = arrayList2;
            } else {
                if (!Intrinsics.areEqual(typeInfo2, RawTypeDescriptor.Star.INSTANCE)) {
                    throw new NoWhenBranchMatchedException();
                }
                arrayListEmptyList3 = CollectionsKt.emptyList();
            }
            throw new IllegalArgumentException(("The map key type should be String, but received " + CollectionsKt.first((List<? extends Object>) arrayListEmptyList3) + ".").toString());
        }
        RawTypeDescriptor typeInfo3 = typeDescriptor.getTypeInfo();
        if (typeInfo3 instanceof RawTypeDescriptor.Simple) {
            arrayListEmptyList2 = CollectionsKt.emptyList();
        } else if (typeInfo3 instanceof RawTypeDescriptor.Parameterized) {
            List<RawTypeDescriptor> params3 = ((RawTypeDescriptor.Parameterized) typeDescriptor.getTypeInfo()).getParams();
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(params3, 10));
            for (Object obj3 : params3) {
                int i5 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                arrayList3.add(new TypeDescriptor((RawTypeDescriptor) obj3, new TypeDescriptor$params$1$1(typeDescriptor, i)));
                i = i5;
            }
            arrayListEmptyList2 = arrayList3;
        } else {
            if (!Intrinsics.areEqual(typeInfo3, RawTypeDescriptor.Star.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            arrayListEmptyList2 = CollectionsKt.emptyList();
        }
        Object orNull = CollectionsKt.getOrNull(arrayListEmptyList2, 1);
        if (orNull != null) {
            this.valueConverter = converterProvider.obtainTypeConverter((TypeDescriptor) orNull);
            return;
        }
        throw new IllegalArgumentException("The map type should contain the key type.".toString());
    }

    @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
    public Map<?, ?> convertFromDynamic(Dynamic value, ConverterContext context, boolean forceConversion) throws DynamicCastException {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(context, "context");
        ReadableMap readableMapAsMap = value.asMap();
        if (readableMapAsMap == null) {
            throw new DynamicCastException((KClass<?>) Reflection.getOrCreateKotlinClass(ReadableMap.class));
        }
        return convertFromReadableMap(readableMapAsMap, context, forceConversion);
    }

    @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
    public Map<?, ?> convertFromAny(Object value, ConverterContext context, boolean forceConversion) throws CollectionElementCastException {
        UnexpectedException unexpectedException;
        ArrayList arrayListEmptyList;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.valueConverter.isTrivial() && !forceConversion) {
            return (Map) value;
        }
        Map map = (Map) value;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value2 = entry.getValue();
            try {
                linkedHashMap.put(key, this.valueConverter.convert(value2, context, forceConversion));
            } catch (Throwable th) {
                if (th instanceof CodedException) {
                    unexpectedException = (CodedException) th;
                } else if (th instanceof expo.modules.core.errors.CodedException) {
                    expo.modules.core.errors.CodedException codedException = (expo.modules.core.errors.CodedException) th;
                    unexpectedException = new CodedException(codedException.getCode(), codedException.getMessage(), codedException.getCause());
                } else {
                    unexpectedException = new UnexpectedException(th);
                }
                TypeDescriptor typeDescriptor = this.mapType;
                TypeDescriptor typeDescriptor2 = this.mapType;
                RawTypeDescriptor typeInfo = typeDescriptor2.getTypeInfo();
                if (typeInfo instanceof RawTypeDescriptor.Simple) {
                    arrayListEmptyList = CollectionsKt.emptyList();
                } else if (typeInfo instanceof RawTypeDescriptor.Parameterized) {
                    List<RawTypeDescriptor> params = ((RawTypeDescriptor.Parameterized) typeDescriptor2.getTypeInfo()).getParams();
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(params, 10));
                    int i = 0;
                    for (Object obj : params) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        arrayList.add(new TypeDescriptor((RawTypeDescriptor) obj, new TypeDescriptor$params$1$1(typeDescriptor2, i)));
                        i = i2;
                    }
                    arrayListEmptyList = arrayList;
                } else {
                    if (!Intrinsics.areEqual(typeInfo, RawTypeDescriptor.Star.INSTANCE)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    arrayListEmptyList = CollectionsKt.emptyList();
                }
                TypeDescriptor typeDescriptor3 = (TypeDescriptor) arrayListEmptyList.get(1);
                Intrinsics.checkNotNull(value2);
                throw new CollectionElementCastException(typeDescriptor, typeDescriptor3, (KClass<?>) Reflection.getOrCreateKotlinClass(value2.getClass()), unexpectedException);
            }
        }
        return linkedHashMap;
    }

    private final Map<?, ?> convertFromReadableMap(ReadableMap jsMap, ConverterContext context, boolean forceConversion) {
        UnexpectedException codedException;
        ArrayList arrayListEmptyList;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map.Entry<String, Object>> entryIterator = jsMap.getEntryIterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, Object> next = entryIterator.next();
            String key = next.getKey();
            DynamicFromObject dynamicFromObject = new DynamicFromObject(next.getValue());
            try {
                linkedHashMap.put(key, this.valueConverter.convert(dynamicFromObject, context, forceConversion));
                Unit unit = Unit.INSTANCE;
                try {
                    Unit unit2 = Unit.INSTANCE;
                    dynamicFromObject.recycle();
                } catch (Throwable th) {
                    dynamicFromObject.recycle();
                    throw th;
                }
            } catch (Throwable th2) {
                if (th2 instanceof CodedException) {
                    codedException = (CodedException) th2;
                } else {
                    codedException = th2 instanceof expo.modules.core.errors.CodedException ? new CodedException(((expo.modules.core.errors.CodedException) th2).getCode(), ((expo.modules.core.errors.CodedException) th2).getMessage(), ((expo.modules.core.errors.CodedException) th2).getCause()) : new UnexpectedException(th2);
                }
                TypeDescriptor typeDescriptor = this.mapType;
                TypeDescriptor typeDescriptor2 = this.mapType;
                RawTypeDescriptor typeInfo = typeDescriptor2.getTypeInfo();
                if (typeInfo instanceof RawTypeDescriptor.Simple) {
                    arrayListEmptyList = CollectionsKt.emptyList();
                } else if (typeInfo instanceof RawTypeDescriptor.Parameterized) {
                    List<RawTypeDescriptor> params = ((RawTypeDescriptor.Parameterized) typeDescriptor2.getTypeInfo()).getParams();
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(params, 10));
                    int i = 0;
                    for (Object obj : params) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        arrayList.add(new TypeDescriptor((RawTypeDescriptor) obj, new TypeDescriptor$params$1$1(typeDescriptor2, i)));
                        i = i2;
                    }
                    arrayListEmptyList = arrayList;
                } else {
                    if (!Intrinsics.areEqual(typeInfo, RawTypeDescriptor.Star.INSTANCE)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    arrayListEmptyList = CollectionsKt.emptyList();
                }
                throw new CollectionElementCastException(typeDescriptor, (TypeDescriptor) arrayListEmptyList.get(1), dynamicFromObject.getType(), codedException);
            }
        }
        return linkedHashMap;
    }

    @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
    /* JADX INFO: renamed from: getCppRequiredTypes */
    public ExpectedType get$cppRequireType() {
        return ExpectedType.INSTANCE.forMap(this.valueConverter.get$cppRequireType());
    }

    @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
    public boolean isTrivial() {
        return this.valueConverter.isTrivial();
    }
}
