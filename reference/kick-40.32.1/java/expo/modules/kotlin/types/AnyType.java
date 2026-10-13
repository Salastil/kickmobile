package expo.modules.kotlin.types;

import com.facebook.react.bridge.Dynamic;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.types.descriptors.TypeDescriptor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnyType.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u0012\u001a\u0004\u0018\u00010\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001f\u0010\f\u001a\u0006\u0012\u0002\b\u00030\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lexpo/modules/kotlin/types/AnyType;", "", "typeDescriptor", "Lexpo/modules/kotlin/types/descriptors/TypeDescriptor;", "converterProvider", "Lexpo/modules/kotlin/types/TypeConverterProvider;", "<init>", "(Lexpo/modules/kotlin/types/descriptors/TypeDescriptor;Lexpo/modules/kotlin/types/TypeConverterProvider;)V", "getTypeDescriptor", "()Lexpo/modules/kotlin/types/descriptors/TypeDescriptor;", "getConverterProvider", "()Lexpo/modules/kotlin/types/TypeConverterProvider;", "converter", "Lexpo/modules/kotlin/types/TypeConverter;", "getConverter", "()Lexpo/modules/kotlin/types/TypeConverter;", "converter$delegate", "Lkotlin/Lazy;", "convert", "value", "converterContext", "Lexpo/modules/kotlin/types/ConverterContext;", "forceConversion", "", "getCppRequiredTypes", "Lexpo/modules/kotlin/jni/ExpectedType;", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AnyType {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: converter$delegate, reason: from kotlin metadata */
    private final Lazy converter;
    private final TypeConverterProvider converterProvider;
    private final TypeDescriptor typeDescriptor;

    public AnyType(TypeDescriptor typeDescriptor, TypeConverterProvider typeConverterProvider) {
        Intrinsics.checkNotNullParameter(typeDescriptor, "typeDescriptor");
        this.typeDescriptor = typeDescriptor;
        this.converterProvider = typeConverterProvider;
        this.converter = LazyKt.lazy(new Function0() { // from class: expo.modules.kotlin.types.AnyType$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AnyType.converter_delegate$lambda$0(this.f$0);
            }
        });
    }

    public /* synthetic */ AnyType(TypeDescriptor typeDescriptor, TypeConverterProvider typeConverterProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(typeDescriptor, (i & 2) != 0 ? null : typeConverterProvider);
    }

    public final TypeDescriptor getTypeDescriptor() {
        return this.typeDescriptor;
    }

    public final TypeConverterProvider getConverterProvider() {
        return this.converterProvider;
    }

    private final TypeConverter<?> getConverter() {
        return (TypeConverter) this.converter.getValue();
    }

    static final TypeConverter converter_delegate$lambda$0(AnyType anyType) {
        TypeConverter<?> typeConverterObtainTypeConverter;
        TypeConverterProvider typeConverterProvider = anyType.converterProvider;
        return (typeConverterProvider == null || (typeConverterObtainTypeConverter = typeConverterProvider.obtainTypeConverter(anyType.typeDescriptor)) == null) ? TypeConverterProviderImpl.INSTANCE.obtainTypeConverter(anyType.typeDescriptor) : typeConverterObtainTypeConverter;
    }

    public static /* synthetic */ Object convert$default(AnyType anyType, Object obj, ConverterContext converterContext, boolean z, int i, Object obj2) {
        if ((i & 4) != 0) {
            z = false;
        }
        return anyType.convert(obj, converterContext, z);
    }

    public final Object convert(Object value, ConverterContext converterContext, boolean forceConversion) {
        Intrinsics.checkNotNullParameter(converterContext, "converterContext");
        return (forceConversion || !getConverter().isTrivial() || (value instanceof Dynamic)) ? getConverter().convert(value, converterContext, forceConversion) : value;
    }

    public final ExpectedType getCppRequiredTypes() {
        return getConverter().getCppRequiredTypes();
    }
}
