package expo.modules.kotlin.types;

import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.types.descriptors.RawTypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptor$params$1$1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EitherTypeConverter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u0002*\b\b\u0002\u0010\u0004*\u00020\u00022\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u00060\u0005B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0018\u001a\u00020\u0019H\u0016J2\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0019H\u0016J\b\u0010\u001f\u001a\u00020\u0015H\u0016R\u000e\u0010\r\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lexpo/modules/kotlin/types/EitherOfThreeTypeConverter;", "FirstType", "", "SecondType", "ThirdType", "Lexpo/modules/kotlin/types/NonNullableTypeConverter;", "Lexpo/modules/kotlin/types/EitherOfThree;", "converterProvider", "Lexpo/modules/kotlin/types/TypeConverterProvider;", "eitherTypeDescriptor", "Lexpo/modules/kotlin/types/descriptors/TypeDescriptor;", "<init>", "(Lexpo/modules/kotlin/types/TypeConverterProvider;Lexpo/modules/kotlin/types/descriptors/TypeDescriptor;)V", "firstJavaType", "secondJavaType", "thirdJavaType", "firstTypeConverter", "Lexpo/modules/kotlin/types/TypeConverter;", "secondTypeConverter", "thirdTypeConverter", "firstType", "Lexpo/modules/kotlin/jni/ExpectedType;", "secondType", "thirdType", "isTrivial", "", "convertNonNullable", "value", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lexpo/modules/kotlin/types/ConverterContext;", "forceConversion", "getCppRequiredTypes", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class EitherOfThreeTypeConverter<FirstType, SecondType, ThirdType> extends NonNullableTypeConverter<EitherOfThree<FirstType, SecondType, ThirdType>> {
    public static final int $stable = 8;
    private final TypeDescriptor firstJavaType;
    private final ExpectedType firstType;
    private final TypeConverter<?> firstTypeConverter;
    private final TypeDescriptor secondJavaType;
    private final ExpectedType secondType;
    private final TypeConverter<?> secondTypeConverter;
    private final TypeDescriptor thirdJavaType;
    private final ExpectedType thirdType;
    private final TypeConverter<?> thirdTypeConverter;

    @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
    public boolean isTrivial() {
        return false;
    }

    public EitherOfThreeTypeConverter(TypeConverterProvider converterProvider, TypeDescriptor eitherTypeDescriptor) {
        ArrayList arrayListEmptyList;
        ArrayList arrayListEmptyList2;
        ArrayList arrayListEmptyList3;
        Intrinsics.checkNotNullParameter(converterProvider, "converterProvider");
        Intrinsics.checkNotNullParameter(eitherTypeDescriptor, "eitherTypeDescriptor");
        RawTypeDescriptor typeInfo = eitherTypeDescriptor.getTypeInfo();
        int i = 0;
        if (typeInfo instanceof RawTypeDescriptor.Simple) {
            arrayListEmptyList = CollectionsKt.emptyList();
        } else if (typeInfo instanceof RawTypeDescriptor.Parameterized) {
            List<RawTypeDescriptor> params = ((RawTypeDescriptor.Parameterized) eitherTypeDescriptor.getTypeInfo()).getParams();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(params, 10));
            int i2 = 0;
            for (Object obj : params) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                arrayList.add(new TypeDescriptor((RawTypeDescriptor) obj, new TypeDescriptor$params$1$1(eitherTypeDescriptor, i2)));
                i2 = i3;
            }
            arrayListEmptyList = arrayList;
        } else {
            if (!Intrinsics.areEqual(typeInfo, RawTypeDescriptor.Star.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            arrayListEmptyList = CollectionsKt.emptyList();
        }
        Object orNull = CollectionsKt.getOrNull(arrayListEmptyList, 0);
        if (orNull == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        this.firstJavaType = (TypeDescriptor) orNull;
        RawTypeDescriptor typeInfo2 = eitherTypeDescriptor.getTypeInfo();
        if (typeInfo2 instanceof RawTypeDescriptor.Simple) {
            arrayListEmptyList2 = CollectionsKt.emptyList();
        } else if (typeInfo2 instanceof RawTypeDescriptor.Parameterized) {
            List<RawTypeDescriptor> params2 = ((RawTypeDescriptor.Parameterized) eitherTypeDescriptor.getTypeInfo()).getParams();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(params2, 10));
            int i4 = 0;
            for (Object obj2 : params2) {
                int i5 = i4 + 1;
                if (i4 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                arrayList2.add(new TypeDescriptor((RawTypeDescriptor) obj2, new TypeDescriptor$params$1$1(eitherTypeDescriptor, i4)));
                i4 = i5;
            }
            arrayListEmptyList2 = arrayList2;
        } else {
            if (!Intrinsics.areEqual(typeInfo2, RawTypeDescriptor.Star.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            arrayListEmptyList2 = CollectionsKt.emptyList();
        }
        Object orNull2 = CollectionsKt.getOrNull(arrayListEmptyList2, 1);
        if (orNull2 == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        this.secondJavaType = (TypeDescriptor) orNull2;
        RawTypeDescriptor typeInfo3 = eitherTypeDescriptor.getTypeInfo();
        if (typeInfo3 instanceof RawTypeDescriptor.Simple) {
            arrayListEmptyList3 = CollectionsKt.emptyList();
        } else if (typeInfo3 instanceof RawTypeDescriptor.Parameterized) {
            List<RawTypeDescriptor> params3 = ((RawTypeDescriptor.Parameterized) eitherTypeDescriptor.getTypeInfo()).getParams();
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(params3, 10));
            for (Object obj3 : params3) {
                int i6 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                arrayList3.add(new TypeDescriptor((RawTypeDescriptor) obj3, new TypeDescriptor$params$1$1(eitherTypeDescriptor, i)));
                i = i6;
            }
            arrayListEmptyList3 = arrayList3;
        } else {
            if (!Intrinsics.areEqual(typeInfo3, RawTypeDescriptor.Star.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            arrayListEmptyList3 = CollectionsKt.emptyList();
        }
        Object orNull3 = CollectionsKt.getOrNull(arrayListEmptyList3, 2);
        if (orNull3 == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        TypeDescriptor typeDescriptor = (TypeDescriptor) orNull3;
        this.thirdJavaType = typeDescriptor;
        TypeConverter<?> typeConverterObtainTypeConverter = converterProvider.obtainTypeConverter(this.firstJavaType);
        this.firstTypeConverter = typeConverterObtainTypeConverter;
        TypeConverter<?> typeConverterObtainTypeConverter2 = converterProvider.obtainTypeConverter(this.secondJavaType);
        this.secondTypeConverter = typeConverterObtainTypeConverter2;
        TypeConverter<?> typeConverterObtainTypeConverter3 = converterProvider.obtainTypeConverter(typeDescriptor);
        this.thirdTypeConverter = typeConverterObtainTypeConverter3;
        this.firstType = typeConverterObtainTypeConverter.get$cppRequireType();
        this.secondType = typeConverterObtainTypeConverter2.get$cppRequireType();
        this.thirdType = typeConverterObtainTypeConverter3.get$cppRequireType();
    }

    @Override // expo.modules.kotlin.types.NonNullableTypeConverter
    public EitherOfThree<FirstType, SecondType, ThirdType> convertNonNullable(Object value, ConverterContext context, boolean forceConversion) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(context, "context");
        List listListOf = CollectionsKt.listOf((Object[]) new TypeDescriptor[]{this.firstJavaType, this.secondJavaType, this.thirdJavaType});
        return new EitherOfThree<>(value, CollectionsKt.toMutableList((Collection) EitherTypeConverterKt.createDeferredValues(value, context, CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(this.firstType, this.firstTypeConverter), TuplesKt.to(this.secondType, this.secondTypeConverter), TuplesKt.to(this.thirdType, this.thirdTypeConverter)}), listListOf)), listListOf);
    }

    @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
    /* JADX INFO: renamed from: getCppRequiredTypes */
    public ExpectedType get$cppRequireType() {
        return ExpectedType.INSTANCE.merge(this.firstType, this.secondType, this.thirdType);
    }
}
