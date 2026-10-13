package expo.modules.kotlin.types;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.bridge.Dynamic;
import expo.modules.kotlin.exception.MissingTypeConverter;
import expo.modules.kotlin.types.descriptors.RawTypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptorKt;
import io.github.expo.pika.PTypeDescriptor;
import io.github.expo.pika.TypeDescriptorOfKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: TypeConverterProvider.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\u0086\b\u001a&\u0010\u0004\u001a\u0002H\u0002\"\u0006\b\u0000\u0010\u0002\u0018\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086\b¢\u0006\u0002\u0010\t\u001a(\u0010\u0004\u001a\u0002H\u0002\"\u0006\b\u0000\u0010\u0002\u0018\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0086\b¢\u0006\u0002\u0010\n\u001a \u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b\u001a\u0012\u0010\r\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e\u001a\f\u0010\u0010\u001a\u00020\u000e*\u0004\u0018\u00010\u000e¨\u0006\u0011"}, d2 = {"obtainTypeConverter", "Lexpo/modules/kotlin/types/TypeConverter;", ExifInterface.GPS_DIRECTION_TRUE, "", "convert", "value", "Lcom/facebook/react/bridge/Dynamic;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lexpo/modules/kotlin/types/ConverterContext;", "(Lcom/facebook/react/bridge/Dynamic;Lexpo/modules/kotlin/types/ConverterContext;)Ljava/lang/Object;", "(Ljava/lang/Object;Lexpo/modules/kotlin/types/ConverterContext;)Ljava/lang/Object;", "type", "Lkotlin/reflect/KType;", "mergeWith", "Lexpo/modules/kotlin/types/TypeConverterProvider;", "otherProvider", "mergeWithDefault", "expo-modules-core_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class TypeConverterProviderKt {
    public static final /* synthetic */ <T> TypeConverter<T> obtainTypeConverter() throws MissingTypeConverter {
        Object objM12684constructorimpl;
        TypeConverterProviderImpl typeConverterProviderImpl = TypeConverterProviderImpl.INSTANCE;
        try {
            Result.Companion companion = Result.INSTANCE;
            Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
            PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
            MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
            RawTypeDescriptor rawTypeDescriptor = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError);
            Intrinsics.needClassReification();
            objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor, new Function0<KType>() { // from class: expo.modules.kotlin.types.TypeConverterProviderKt$obtainTypeConverter$$inlined$typeDescriptorOf$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
                    return null;
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
        if (typeDescriptor == null) {
            Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
            typeDescriptor = TypeDescriptorKt.toTypeDescriptor(null);
        }
        TypeConverter typeConverterObtainTypeConverter = typeConverterProviderImpl.obtainTypeConverter(typeDescriptor);
        Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.types.TypeConverter<T of expo.modules.kotlin.types.TypeConverterProviderKt.obtainTypeConverter>");
        return typeConverterObtainTypeConverter;
    }

    public static final /* synthetic */ <T> T convert(Dynamic value, ConverterContext context) {
        Object objM12684constructorimpl;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(context, "context");
        TypeConverterProviderImpl typeConverterProviderImpl = TypeConverterProviderImpl.INSTANCE;
        try {
            Result.Companion companion = Result.INSTANCE;
            Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
            PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
            MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
            RawTypeDescriptor rawTypeDescriptor = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError);
            Intrinsics.needClassReification();
            objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor, new Function0<KType>() { // from class: expo.modules.kotlin.types.TypeConverterProviderKt$convert$$inlined$typeDescriptorOf$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
                    return null;
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
        if (typeDescriptor == null) {
            Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
            typeDescriptor = TypeDescriptorKt.toTypeDescriptor(null);
        }
        T t = (T) TypeConverter.convert$default(typeConverterProviderImpl.obtainTypeConverter(typeDescriptor), value, context, false, 4, null);
        Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
        return t;
    }

    public static final /* synthetic */ <T> T convert(Object obj, ConverterContext context) {
        Object objM12684constructorimpl;
        Intrinsics.checkNotNullParameter(context, "context");
        TypeConverterProviderImpl typeConverterProviderImpl = TypeConverterProviderImpl.INSTANCE;
        try {
            Result.Companion companion = Result.INSTANCE;
            Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
            PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
            MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
            RawTypeDescriptor rawTypeDescriptor = expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError);
            Intrinsics.needClassReification();
            objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor, new Function0<KType>() { // from class: expo.modules.kotlin.types.TypeConverterProviderKt$convert$$inlined$typeDescriptorOf$2
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
                    return null;
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
        if (typeDescriptor == null) {
            Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
            typeDescriptor = TypeDescriptorKt.toTypeDescriptor(null);
        }
        T t = (T) TypeConverter.convert$default(typeConverterProviderImpl.obtainTypeConverter(typeDescriptor), obj, context, false, 4, null);
        Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
        return t;
    }

    public static final Object convert(Dynamic value, KType type, ConverterContext context) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(context, "context");
        return TypeConverter.convert$default(TypeConverterProviderImpl.INSTANCE.obtainTypeConverter(TypeDescriptorKt.toTypeDescriptor(type)), value, context, false, 4, null);
    }

    public static final TypeConverterProvider mergeWith(TypeConverterProvider typeConverterProvider, TypeConverterProvider otherProvider) {
        Intrinsics.checkNotNullParameter(typeConverterProvider, "<this>");
        Intrinsics.checkNotNullParameter(otherProvider, "otherProvider");
        return new MergedTypeConverterProvider(CollectionsKt.listOf((Object[]) new TypeConverterProvider[]{typeConverterProvider, otherProvider}));
    }

    public static final TypeConverterProvider mergeWithDefault(TypeConverterProvider typeConverterProvider) {
        TypeConverterProvider typeConverterProviderMergeWith;
        return (typeConverterProvider == null || (typeConverterProviderMergeWith = mergeWith(typeConverterProvider, TypeConverterProviderImpl.INSTANCE)) == null) ? TypeConverterProviderImpl.INSTANCE : typeConverterProviderMergeWith;
    }
}
