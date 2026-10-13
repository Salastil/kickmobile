package expo.modules.ui.convertibles;

import androidx.compose.animation.core.AnimationSpec;
import expo.modules.kotlin.exception.MissingTypeConverter;
import expo.modules.kotlin.records.RecordTypeConverter;
import expo.modules.kotlin.records.RecordTypeConverterKt;
import expo.modules.kotlin.types.ConverterContext;
import expo.modules.kotlin.types.TypeConverter;
import expo.modules.kotlin.types.TypeConverterProviderImpl;
import expo.modules.kotlin.types.descriptors.TypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptorKt;
import expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt;
import io.github.expo.pika.PTypeDescriptorRegistry;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: AnimationSpecParams.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¨\u0006\u0007"}, d2 = {"parseAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "raw", "", "converterContext", "Lexpo/modules/kotlin/types/ConverterContext;", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AnimationSpecParamsKt {
    public static final AnimationSpec<Float> parseAnimationSpec(Object obj, ConverterContext converterContext) throws MissingTypeConverter {
        Object objM12684constructorimpl;
        Object objM12684constructorimpl2;
        Object objM12684constructorimpl3;
        Object objM12684constructorimpl4;
        Intrinsics.checkNotNullParameter(converterContext, "converterContext");
        if (!(obj instanceof Map)) {
            return null;
        }
        Map<?, ?> map = (Map) obj;
        Object obj2 = map.get("$type");
        if (!Intrinsics.areEqual(obj2, "spring")) {
            if (!Intrinsics.areEqual(obj2, "tween")) {
                if (!Intrinsics.areEqual(obj2, "snap")) {
                    if (!Intrinsics.areEqual(obj2, "keyframes")) {
                        return null;
                    }
                    TypeConverterProviderImpl typeConverterProviderImpl = TypeConverterProviderImpl.INSTANCE;
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(KeyframesSpecParams.class, false, KeyframesSpecParams.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.ui.convertibles.AnimationSpecParamsKt$parseAnimationSpec$$inlined$recordFromMap$4
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                return Reflection.typeOf(KeyframesSpecParams.class);
                            }
                        }));
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.INSTANCE;
                        objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
                    }
                    TypeDescriptor typeDescriptor = (TypeDescriptor) (Result.m12690isFailureimpl(objM12684constructorimpl) ? null : objM12684constructorimpl);
                    if (typeDescriptor == null) {
                        typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(KeyframesSpecParams.class));
                    }
                    TypeConverter<?> typeConverterObtainTypeConverter = typeConverterProviderImpl.obtainTypeConverter(typeDescriptor);
                    Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
                    return ((KeyframesSpecParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter, converterContext)).toAnimationSpec(map);
                }
                TypeConverterProviderImpl typeConverterProviderImpl2 = TypeConverterProviderImpl.INSTANCE;
                try {
                    Result.Companion companion3 = Result.INSTANCE;
                    objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(SnapSpecParams.class, false, SnapSpecParams.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.ui.convertibles.AnimationSpecParamsKt$parseAnimationSpec$$inlined$recordFromMap$3
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(SnapSpecParams.class);
                        }
                    }));
                } catch (Throwable th2) {
                    Result.Companion companion4 = Result.INSTANCE;
                    objM12684constructorimpl2 = Result.m12684constructorimpl(ResultKt.createFailure(th2));
                }
                TypeDescriptor typeDescriptor2 = (TypeDescriptor) (Result.m12690isFailureimpl(objM12684constructorimpl2) ? null : objM12684constructorimpl2);
                if (typeDescriptor2 == null) {
                    typeDescriptor2 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(SnapSpecParams.class));
                }
                TypeConverter<?> typeConverterObtainTypeConverter2 = typeConverterProviderImpl2.obtainTypeConverter(typeDescriptor2);
                Intrinsics.checkNotNull(typeConverterObtainTypeConverter2, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
                return ((SnapSpecParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter2, converterContext)).toAnimationSpec();
            }
            TypeConverterProviderImpl typeConverterProviderImpl3 = TypeConverterProviderImpl.INSTANCE;
            try {
                Result.Companion companion5 = Result.INSTANCE;
                objM12684constructorimpl3 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(TweenSpecParams.class, false, TweenSpecParams.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.ui.convertibles.AnimationSpecParamsKt$parseAnimationSpec$$inlined$recordFromMap$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(TweenSpecParams.class);
                    }
                }));
            } catch (Throwable th3) {
                Result.Companion companion6 = Result.INSTANCE;
                objM12684constructorimpl3 = Result.m12684constructorimpl(ResultKt.createFailure(th3));
            }
            TypeDescriptor typeDescriptor3 = (TypeDescriptor) (Result.m12690isFailureimpl(objM12684constructorimpl3) ? null : objM12684constructorimpl3);
            if (typeDescriptor3 == null) {
                typeDescriptor3 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(TweenSpecParams.class));
            }
            TypeConverter<?> typeConverterObtainTypeConverter3 = typeConverterProviderImpl3.obtainTypeConverter(typeDescriptor3);
            Intrinsics.checkNotNull(typeConverterObtainTypeConverter3, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
            return ((TweenSpecParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter3, converterContext)).toAnimationSpec();
        }
        TypeConverterProviderImpl typeConverterProviderImpl4 = TypeConverterProviderImpl.INSTANCE;
        try {
            Result.Companion companion7 = Result.INSTANCE;
            objM12684constructorimpl4 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(SpringSpecParams.class, false, SpringSpecParams.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.ui.convertibles.AnimationSpecParamsKt$parseAnimationSpec$$inlined$recordFromMap$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(SpringSpecParams.class);
                }
            }));
        } catch (Throwable th4) {
            Result.Companion companion8 = Result.INSTANCE;
            objM12684constructorimpl4 = Result.m12684constructorimpl(ResultKt.createFailure(th4));
        }
        TypeDescriptor typeDescriptor4 = (TypeDescriptor) (Result.m12690isFailureimpl(objM12684constructorimpl4) ? null : objM12684constructorimpl4);
        if (typeDescriptor4 == null) {
            typeDescriptor4 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(SpringSpecParams.class));
        }
        TypeConverter<?> typeConverterObtainTypeConverter4 = typeConverterProviderImpl4.obtainTypeConverter(typeDescriptor4);
        Intrinsics.checkNotNull(typeConverterObtainTypeConverter4, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
        return ((SpringSpecParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter4, converterContext)).toAnimationSpec();
    }
}
