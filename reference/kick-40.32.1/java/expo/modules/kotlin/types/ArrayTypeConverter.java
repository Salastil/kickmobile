package expo.modules.kotlin.types;

import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.CollectionElementCastException;
import expo.modules.kotlin.exception.DynamicCastException;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.types.descriptors.RawTypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptor$params$1$1;
import io.ktor.http.ContentDisposition;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: ArrayTypeConverter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¢\u0006\u0002\u0010\u0012J)\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\f\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¢\u0006\u0002\u0010\u0015J\u001d\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00022\u0006\u0010\u0017\u001a\u00020\u0018H\u0002¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0011H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lexpo/modules/kotlin/types/ArrayTypeConverter;", "Lexpo/modules/kotlin/types/DynamicAwareTypeConverters;", "", "converterProvider", "Lexpo/modules/kotlin/types/TypeConverterProvider;", "arrayType", "Lexpo/modules/kotlin/types/descriptors/TypeDescriptor;", "<init>", "(Lexpo/modules/kotlin/types/TypeConverterProvider;Lexpo/modules/kotlin/types/descriptors/TypeDescriptor;)V", "arrayElementConverter", "Lexpo/modules/kotlin/types/TypeConverter;", "convertFromDynamic", "value", "Lcom/facebook/react/bridge/Dynamic;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lexpo/modules/kotlin/types/ConverterContext;", "forceConversion", "", "(Lcom/facebook/react/bridge/Dynamic;Lexpo/modules/kotlin/types/ConverterContext;Z)[Ljava/lang/Object;", "convertFromAny", "", "(Ljava/lang/Object;Lexpo/modules/kotlin/types/ConverterContext;Z)[Ljava/lang/Object;", "createTypedArray", ContentDisposition.Parameters.Size, "", "(I)[Ljava/lang/Object;", "getCppRequiredTypes", "Lexpo/modules/kotlin/jni/ExpectedType;", "isTrivial", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ArrayTypeConverter extends DynamicAwareTypeConverters<Object[]> {
    public static final int $stable = 8;
    private final TypeConverter<?> arrayElementConverter;
    private final TypeDescriptor arrayType;

    public ArrayTypeConverter(TypeConverterProvider converterProvider, TypeDescriptor arrayType) {
        ArrayList arrayListEmptyList;
        Intrinsics.checkNotNullParameter(converterProvider, "converterProvider");
        Intrinsics.checkNotNullParameter(arrayType, "arrayType");
        this.arrayType = arrayType;
        RawTypeDescriptor typeInfo = arrayType.getTypeInfo();
        if (typeInfo instanceof RawTypeDescriptor.Simple) {
            arrayListEmptyList = CollectionsKt.emptyList();
        } else if (typeInfo instanceof RawTypeDescriptor.Parameterized) {
            List<RawTypeDescriptor> params = ((RawTypeDescriptor.Parameterized) arrayType.getTypeInfo()).getParams();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(params, 10));
            int i = 0;
            for (Object obj : params) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                arrayList.add(new TypeDescriptor((RawTypeDescriptor) obj, new TypeDescriptor$params$1$1(arrayType, i)));
                i = i2;
            }
            arrayListEmptyList = arrayList;
        } else {
            if (!Intrinsics.areEqual(typeInfo, RawTypeDescriptor.Star.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            arrayListEmptyList = CollectionsKt.emptyList();
        }
        Object objFirstOrNull = CollectionsKt.firstOrNull((List<? extends Object>) arrayListEmptyList);
        if (objFirstOrNull != null) {
            this.arrayElementConverter = converterProvider.obtainTypeConverter((TypeDescriptor) objFirstOrNull);
            return;
        }
        throw new IllegalArgumentException("The array type should contain the type of the elements.".toString());
    }

    @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
    public Object[] convertFromDynamic(Dynamic value, ConverterContext context, boolean forceConversion) throws DynamicCastException {
        UnexpectedException codedException;
        ArrayList arrayListEmptyList;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(context, "context");
        ReadableArray readableArrayAsArray = value.asArray();
        if (readableArrayAsArray == null) {
            throw new DynamicCastException((KClass<?>) Reflection.getOrCreateKotlinClass(ReadableArray.class));
        }
        Object[] objArrCreateTypedArray = createTypedArray(readableArrayAsArray.size());
        int size = readableArrayAsArray.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            Dynamic dynamic = readableArrayAsArray.getDynamic(i2);
            try {
                Object objConvert = this.arrayElementConverter.convert(dynamic, context, forceConversion);
                dynamic.recycle();
                objArrCreateTypedArray[i2] = objConvert;
            } catch (Throwable th) {
                try {
                    if (th instanceof CodedException) {
                        codedException = (CodedException) th;
                    } else {
                        codedException = th instanceof expo.modules.core.errors.CodedException ? new CodedException(((expo.modules.core.errors.CodedException) th).getCode(), ((expo.modules.core.errors.CodedException) th).getMessage(), ((expo.modules.core.errors.CodedException) th).getCause()) : new UnexpectedException(th);
                    }
                    TypeDescriptor typeDescriptor = this.arrayType;
                    TypeDescriptor typeDescriptor2 = this.arrayType;
                    RawTypeDescriptor typeInfo = typeDescriptor2.getTypeInfo();
                    if (typeInfo instanceof RawTypeDescriptor.Simple) {
                        arrayListEmptyList = CollectionsKt.emptyList();
                    } else if (typeInfo instanceof RawTypeDescriptor.Parameterized) {
                        List<RawTypeDescriptor> params = ((RawTypeDescriptor.Parameterized) typeDescriptor2.getTypeInfo()).getParams();
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(params, 10));
                        for (Object obj : params) {
                            int i3 = i + 1;
                            if (i < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            arrayList.add(new TypeDescriptor((RawTypeDescriptor) obj, new TypeDescriptor$params$1$1(typeDescriptor2, i)));
                            i = i3;
                        }
                        arrayListEmptyList = arrayList;
                    } else {
                        if (!Intrinsics.areEqual(typeInfo, RawTypeDescriptor.Star.INSTANCE)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        arrayListEmptyList = CollectionsKt.emptyList();
                    }
                    throw new CollectionElementCastException(typeDescriptor, (TypeDescriptor) CollectionsKt.first(arrayListEmptyList), dynamic.getType(), codedException);
                } catch (Throwable th2) {
                    dynamic.recycle();
                    throw th2;
                }
            }
        }
        return objArrCreateTypedArray;
    }

    @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
    public Object[] convertFromAny(Object value, ConverterContext context, boolean forceConversion) throws CollectionElementCastException {
        UnexpectedException unexpectedException;
        ArrayList arrayListEmptyList;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.arrayElementConverter.isTrivial() && !forceConversion) {
            return (Object[]) value;
        }
        Object[] objArr = (Object[]) value;
        ArrayList arrayList = new ArrayList(objArr.length);
        int i = 0;
        for (Object obj : objArr) {
            try {
                arrayList.add(this.arrayElementConverter.convert(obj, context, forceConversion));
            } catch (Throwable th) {
                if (th instanceof CodedException) {
                    unexpectedException = (CodedException) th;
                } else if (th instanceof expo.modules.core.errors.CodedException) {
                    expo.modules.core.errors.CodedException codedException = (expo.modules.core.errors.CodedException) th;
                    unexpectedException = new CodedException(codedException.getCode(), codedException.getMessage(), codedException.getCause());
                } else {
                    unexpectedException = new UnexpectedException(th);
                }
                TypeDescriptor typeDescriptor = this.arrayType;
                TypeDescriptor typeDescriptor2 = this.arrayType;
                RawTypeDescriptor typeInfo = typeDescriptor2.getTypeInfo();
                if (typeInfo instanceof RawTypeDescriptor.Simple) {
                    arrayListEmptyList = CollectionsKt.emptyList();
                } else if (typeInfo instanceof RawTypeDescriptor.Parameterized) {
                    List<RawTypeDescriptor> params = ((RawTypeDescriptor.Parameterized) typeDescriptor2.getTypeInfo()).getParams();
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(params, 10));
                    for (Object obj2 : params) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        arrayList2.add(new TypeDescriptor((RawTypeDescriptor) obj2, new TypeDescriptor$params$1$1(typeDescriptor2, i)));
                        i = i2;
                    }
                    arrayListEmptyList = arrayList2;
                } else {
                    if (!Intrinsics.areEqual(typeInfo, RawTypeDescriptor.Star.INSTANCE)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    arrayListEmptyList = CollectionsKt.emptyList();
                }
                TypeDescriptor typeDescriptor3 = (TypeDescriptor) CollectionsKt.first(arrayListEmptyList);
                Intrinsics.checkNotNull(obj);
                throw new CollectionElementCastException(typeDescriptor, typeDescriptor3, (KClass<?>) Reflection.getOrCreateKotlinClass(obj.getClass()), unexpectedException);
            }
        }
        return arrayList.toArray(new Object[0]);
    }

    private final Object[] createTypedArray(int size) {
        ArrayList arrayListEmptyList;
        TypeDescriptor typeDescriptor = this.arrayType;
        RawTypeDescriptor typeInfo = typeDescriptor.getTypeInfo();
        if (typeInfo instanceof RawTypeDescriptor.Simple) {
            arrayListEmptyList = CollectionsKt.emptyList();
        } else if (typeInfo instanceof RawTypeDescriptor.Parameterized) {
            List<RawTypeDescriptor> params = ((RawTypeDescriptor.Parameterized) typeDescriptor.getTypeInfo()).getParams();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(params, 10));
            int i = 0;
            for (Object obj : params) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                arrayList.add(new TypeDescriptor((RawTypeDescriptor) obj, new TypeDescriptor$params$1$1(typeDescriptor, i)));
                i = i2;
            }
            arrayListEmptyList = arrayList;
        } else {
            if (!Intrinsics.areEqual(typeInfo, RawTypeDescriptor.Star.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            arrayListEmptyList = CollectionsKt.emptyList();
        }
        Object objNewInstance = Array.newInstance(ClassExtensionsKt.toBoxedIfPrimitive(((TypeDescriptor) CollectionsKt.first(arrayListEmptyList)).getTypeInfo().getJClass()), size);
        Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        return (Object[]) objNewInstance;
    }

    @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
    /* JADX INFO: renamed from: getCppRequiredTypes */
    public ExpectedType get$cppRequireType() {
        return ExpectedType.INSTANCE.forArray(this.arrayElementConverter.get$cppRequireType());
    }

    @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
    public boolean isTrivial() {
        return this.arrayElementConverter.isTrivial();
    }
}
