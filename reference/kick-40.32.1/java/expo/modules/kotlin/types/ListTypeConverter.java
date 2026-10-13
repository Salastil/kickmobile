package expo.modules.kotlin.types;

import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableType;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.CollectionElementCastException;
import expo.modules.kotlin.exception.DynamicCastException;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.types.descriptors.RawTypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptor$params$1$1;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: ListTypeConverter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ$\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J$\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\f\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J$\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0011H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lexpo/modules/kotlin/types/ListTypeConverter;", "Lexpo/modules/kotlin/types/DynamicAwareTypeConverters;", "", "converterProvider", "Lexpo/modules/kotlin/types/TypeConverterProvider;", "listType", "Lexpo/modules/kotlin/types/descriptors/TypeDescriptor;", "<init>", "(Lexpo/modules/kotlin/types/TypeConverterProvider;Lexpo/modules/kotlin/types/descriptors/TypeDescriptor;)V", "elementConverter", "Lexpo/modules/kotlin/types/TypeConverter;", "convertFromDynamic", "value", "Lcom/facebook/react/bridge/Dynamic;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lexpo/modules/kotlin/types/ConverterContext;", "forceConversion", "", "convertFromAny", "", "convertFromReadableArray", "jsArray", "Lcom/facebook/react/bridge/ReadableArray;", "getCppRequiredTypes", "Lexpo/modules/kotlin/jni/ExpectedType;", "isTrivial", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ListTypeConverter extends DynamicAwareTypeConverters<List<?>> {
    public static final int $stable = 8;
    private final TypeConverter<?> elementConverter;
    private final TypeDescriptor listType;

    public ListTypeConverter(TypeConverterProvider converterProvider, TypeDescriptor listType) {
        ArrayList arrayListEmptyList;
        Intrinsics.checkNotNullParameter(converterProvider, "converterProvider");
        Intrinsics.checkNotNullParameter(listType, "listType");
        this.listType = listType;
        RawTypeDescriptor typeInfo = listType.getTypeInfo();
        if (typeInfo instanceof RawTypeDescriptor.Simple) {
            arrayListEmptyList = CollectionsKt.emptyList();
        } else if (typeInfo instanceof RawTypeDescriptor.Parameterized) {
            List<RawTypeDescriptor> params = ((RawTypeDescriptor.Parameterized) listType.getTypeInfo()).getParams();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(params, 10));
            int i = 0;
            for (Object obj : params) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                arrayList.add(new TypeDescriptor((RawTypeDescriptor) obj, new TypeDescriptor$params$1$1(listType, i)));
                i = i2;
            }
            arrayListEmptyList = arrayList;
        } else {
            if (!Intrinsics.areEqual(typeInfo, RawTypeDescriptor.Star.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            arrayListEmptyList = CollectionsKt.emptyList();
        }
        Object objFirst = CollectionsKt.first((List<? extends Object>) arrayListEmptyList);
        if (objFirst != null) {
            this.elementConverter = converterProvider.obtainTypeConverter((TypeDescriptor) objFirst);
            return;
        }
        throw new IllegalArgumentException("The list type should contain the type of elements.".toString());
    }

    @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
    public List<?> convertFromDynamic(Dynamic value, ConverterContext context, boolean forceConversion) throws CollectionElementCastException, DynamicCastException {
        UnexpectedException unexpectedException;
        ArrayList arrayListEmptyList;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(context, "context");
        if (value.getType() != ReadableType.Array) {
            try {
                return CollectionsKt.listOf(this.elementConverter.convert(value, context, forceConversion));
            } catch (Throwable th) {
                if (th instanceof CodedException) {
                    unexpectedException = (CodedException) th;
                } else if (th instanceof expo.modules.core.errors.CodedException) {
                    expo.modules.core.errors.CodedException codedException = (expo.modules.core.errors.CodedException) th;
                    unexpectedException = new CodedException(codedException.getCode(), codedException.getMessage(), codedException.getCause());
                } else {
                    unexpectedException = new UnexpectedException(th);
                }
                TypeDescriptor typeDescriptor = this.listType;
                TypeDescriptor typeDescriptor2 = this.listType;
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
                throw new CollectionElementCastException(typeDescriptor, (TypeDescriptor) CollectionsKt.first(arrayListEmptyList), (KClass<?>) Reflection.getOrCreateKotlinClass(value.getClass()), unexpectedException);
            }
        }
        ReadableArray readableArrayAsArray = value.asArray();
        if (readableArrayAsArray == null) {
            throw new DynamicCastException((KClass<?>) Reflection.getOrCreateKotlinClass(ReadableArray.class));
        }
        return convertFromReadableArray(readableArrayAsArray, context, forceConversion);
    }

    @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
    public List<?> convertFromAny(Object value, ConverterContext context, boolean forceConversion) throws CollectionElementCastException {
        UnexpectedException unexpectedException;
        ArrayList arrayListEmptyList;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.elementConverter.isTrivial() && !forceConversion) {
            return (List) value;
        }
        List list = (List) value;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (Object obj : list) {
            try {
                arrayList.add(this.elementConverter.convert(obj, context, forceConversion));
            } catch (Throwable th) {
                if (th instanceof CodedException) {
                    unexpectedException = (CodedException) th;
                } else if (th instanceof expo.modules.core.errors.CodedException) {
                    expo.modules.core.errors.CodedException codedException = (expo.modules.core.errors.CodedException) th;
                    unexpectedException = new CodedException(codedException.getCode(), codedException.getMessage(), codedException.getCause());
                } else {
                    unexpectedException = new UnexpectedException(th);
                }
                TypeDescriptor typeDescriptor = this.listType;
                TypeDescriptor typeDescriptor2 = this.listType;
                RawTypeDescriptor typeInfo = typeDescriptor2.getTypeInfo();
                if (typeInfo instanceof RawTypeDescriptor.Simple) {
                    arrayListEmptyList = CollectionsKt.emptyList();
                } else if (typeInfo instanceof RawTypeDescriptor.Parameterized) {
                    List<RawTypeDescriptor> params = ((RawTypeDescriptor.Parameterized) typeDescriptor2.getTypeInfo()).getParams();
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(params, 10));
                    int i = 0;
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
        return arrayList;
    }

    private final List<?> convertFromReadableArray(ReadableArray jsArray, ConverterContext context, boolean forceConversion) {
        UnexpectedException codedException;
        ArrayList arrayListEmptyList;
        int size = jsArray.size();
        ArrayList arrayList = new ArrayList(size);
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            Dynamic dynamic = jsArray.getDynamic(i2);
            try {
                Object objConvert = this.elementConverter.convert(dynamic, context, forceConversion);
                dynamic.recycle();
                arrayList.add(objConvert);
            } catch (Throwable th) {
                try {
                    if (th instanceof CodedException) {
                        codedException = (CodedException) th;
                    } else {
                        codedException = th instanceof expo.modules.core.errors.CodedException ? new CodedException(((expo.modules.core.errors.CodedException) th).getCode(), ((expo.modules.core.errors.CodedException) th).getMessage(), ((expo.modules.core.errors.CodedException) th).getCause()) : new UnexpectedException(th);
                    }
                    TypeDescriptor typeDescriptor = this.listType;
                    TypeDescriptor typeDescriptor2 = this.listType;
                    RawTypeDescriptor typeInfo = typeDescriptor2.getTypeInfo();
                    if (typeInfo instanceof RawTypeDescriptor.Simple) {
                        arrayListEmptyList = CollectionsKt.emptyList();
                    } else if (typeInfo instanceof RawTypeDescriptor.Parameterized) {
                        List<RawTypeDescriptor> params = ((RawTypeDescriptor.Parameterized) typeDescriptor2.getTypeInfo()).getParams();
                        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(params, 10));
                        for (Object obj : params) {
                            int i3 = i + 1;
                            if (i < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            arrayList2.add(new TypeDescriptor((RawTypeDescriptor) obj, new TypeDescriptor$params$1$1(typeDescriptor2, i)));
                            i = i3;
                        }
                        arrayListEmptyList = arrayList2;
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
        return arrayList;
    }

    @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
    /* JADX INFO: renamed from: getCppRequiredTypes */
    public ExpectedType get$cppRequireType() {
        return ExpectedType.INSTANCE.forList(this.elementConverter.get$cppRequireType());
    }

    @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
    public boolean isTrivial() {
        return this.elementConverter.isTrivial();
    }
}
