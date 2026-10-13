package expo.modules.blur;

import android.view.View;
import androidx.tracing.Trace;
import expo.modules.blur.enums.BlurMethod;
import expo.modules.blur.enums.TintStyle;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeCache;
import expo.modules.kotlin.types.descriptors.TypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptorKt;
import expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt;
import expo.modules.kotlin.views.ConcreteViewProp;
import expo.modules.kotlin.views.ViewDefinitionBuilder;
import expo.modules.kotlin.views.decorators.CSSPropsKt;
import io.github.expo.pika.PTypeDescriptorRegistry;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: BlurModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lexpo/modules/blur/BlurModule;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-blur_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BlurModule extends Module {
    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        Object objM12684constructorimpl;
        Object objM12684constructorimpl2;
        Object objM12684constructorimpl3;
        Object objM12684constructorimpl4;
        Object objM12684constructorimpl5;
        Object objM12684constructorimpl6;
        Object objM12684constructorimpl7;
        Object objM12684constructorimpl8;
        BlurModule blurModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (blurModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(blurModule);
            moduleDefinitionBuilder.Name("ExpoBlur");
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ExpoBlurView.class);
            Object obj = null;
            try {
                Result.Companion companion = Result.INSTANCE;
                objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(ExpoBlurView.class, false, null)), new Function0<KType>() { // from class: expo.modules.blur.BlurModule$definition$lambda$3$$inlined$View$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(ExpoBlurView.class);
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
                typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ExpoBlurView.class));
            }
            ViewDefinitionBuilder viewDefinitionBuilder = new ViewDefinitionBuilder(orCreateKotlinClass, typeDescriptor, moduleDefinitionBuilder2.getConverters());
            CSSPropsKt.UseCSSProps(viewDefinitionBuilder);
            viewDefinitionBuilder.Name("ExpoBlurView");
            BlurModule$definition$1$1$1 blurModule$definition$1$1$1 = new Function2<ExpoBlurView, Integer, Unit>() { // from class: expo.modules.blur.BlurModule$definition$1$1$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoBlurView expoBlurView, Integer num) throws BlurViewConfigurationException {
                    invoke2(expoBlurView, num);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ExpoBlurView view, Integer num) throws BlurViewConfigurationException {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.setBlurTargetId(num);
                }
            };
            AnyType anyType = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Integer.class), true));
            if (anyType == null) {
                try {
                    Result.Companion companion3 = Result.INSTANCE;
                    objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.INT_NULLABLE), new Function0<KType>() { // from class: expo.modules.blur.BlurModule$definition$lambda$3$lambda$1$$inlined$Prop$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(Integer.class);
                        }
                    }));
                } catch (Throwable th2) {
                    Result.Companion companion4 = Result.INSTANCE;
                    objM12684constructorimpl2 = Result.m12684constructorimpl(ResultKt.createFailure(th2));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl2)) {
                    objM12684constructorimpl2 = null;
                }
                TypeDescriptor typeDescriptor2 = (TypeDescriptor) objM12684constructorimpl2;
                if (typeDescriptor2 == null) {
                    typeDescriptor2 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Integer.class));
                }
                anyType = new AnyType(typeDescriptor2, null);
            }
            viewDefinitionBuilder.getProps().put("blurTargetId", new ConcreteViewProp("blurTargetId", anyType, blurModule$definition$1$1$1));
            BlurModule$definition$1$1$2 blurModule$definition$1$1$2 = new Function2<ExpoBlurView, Float, Unit>() { // from class: expo.modules.blur.BlurModule$definition$1$1$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoBlurView expoBlurView, Float f) {
                    invoke(expoBlurView, f.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ExpoBlurView view, float f) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.setBlurRadius(f);
                }
            };
            AnyType anyType2 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Float.class), false));
            if (anyType2 == null) {
                try {
                    Result.Companion companion5 = Result.INSTANCE;
                    objM12684constructorimpl3 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.FLOAT), new Function0<KType>() { // from class: expo.modules.blur.BlurModule$definition$lambda$3$lambda$1$$inlined$Prop$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Float.TYPE);
                        }
                    }));
                } catch (Throwable th3) {
                    Result.Companion companion6 = Result.INSTANCE;
                    objM12684constructorimpl3 = Result.m12684constructorimpl(ResultKt.createFailure(th3));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl3)) {
                    objM12684constructorimpl3 = null;
                }
                TypeDescriptor typeDescriptor3 = (TypeDescriptor) objM12684constructorimpl3;
                if (typeDescriptor3 == null) {
                    typeDescriptor3 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Float.TYPE));
                }
                anyType2 = new AnyType(typeDescriptor3, null);
            }
            viewDefinitionBuilder.getProps().put("intensity", new ConcreteViewProp("intensity", anyType2, blurModule$definition$1$1$2));
            BlurModule$definition$1$1$3 blurModule$definition$1$1$3 = new Function2<ExpoBlurView, TintStyle, Unit>() { // from class: expo.modules.blur.BlurModule$definition$1$1$3
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoBlurView expoBlurView, TintStyle tintStyle) {
                    invoke2(expoBlurView, tintStyle);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ExpoBlurView view, TintStyle tint) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(tint, "tint");
                    view.setTint$expo_blur_release(tint);
                }
            };
            AnyType anyType3 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(TintStyle.class), false));
            if (anyType3 == null) {
                try {
                    Result.Companion companion7 = Result.INSTANCE;
                    objM12684constructorimpl4 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(TintStyle.class, false, null)), new Function0<KType>() { // from class: expo.modules.blur.BlurModule$definition$lambda$3$lambda$1$$inlined$Prop$3
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(TintStyle.class);
                        }
                    }));
                } catch (Throwable th4) {
                    Result.Companion companion8 = Result.INSTANCE;
                    objM12684constructorimpl4 = Result.m12684constructorimpl(ResultKt.createFailure(th4));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl4)) {
                    objM12684constructorimpl4 = null;
                }
                TypeDescriptor typeDescriptor4 = (TypeDescriptor) objM12684constructorimpl4;
                if (typeDescriptor4 == null) {
                    typeDescriptor4 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(TintStyle.class));
                }
                anyType3 = new AnyType(typeDescriptor4, null);
            }
            viewDefinitionBuilder.getProps().put("tint", new ConcreteViewProp("tint", anyType3, blurModule$definition$1$1$3));
            BlurModule$definition$1$1$4 blurModule$definition$1$1$4 = new Function2<ExpoBlurView, Float, Unit>() { // from class: expo.modules.blur.BlurModule$definition$1$1$4
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoBlurView expoBlurView, Float f) {
                    invoke(expoBlurView, f.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ExpoBlurView view, float f) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.applyBlurReduction(f);
                }
            };
            AnyType anyType4 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Float.class), false));
            if (anyType4 == null) {
                try {
                    Result.Companion companion9 = Result.INSTANCE;
                    objM12684constructorimpl5 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.FLOAT), new Function0<KType>() { // from class: expo.modules.blur.BlurModule$definition$lambda$3$lambda$1$$inlined$Prop$4
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Float.TYPE);
                        }
                    }));
                } catch (Throwable th5) {
                    Result.Companion companion10 = Result.INSTANCE;
                    objM12684constructorimpl5 = Result.m12684constructorimpl(ResultKt.createFailure(th5));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl5)) {
                    objM12684constructorimpl5 = null;
                }
                TypeDescriptor typeDescriptor5 = (TypeDescriptor) objM12684constructorimpl5;
                if (typeDescriptor5 == null) {
                    typeDescriptor5 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Float.TYPE));
                }
                anyType4 = new AnyType(typeDescriptor5, null);
            }
            viewDefinitionBuilder.getProps().put("blurReductionFactor", new ConcreteViewProp("blurReductionFactor", anyType4, blurModule$definition$1$1$4));
            BlurModule$definition$1$1$5 blurModule$definition$1$1$5 = new Function2<ExpoBlurView, float[], Unit>() { // from class: expo.modules.blur.BlurModule$definition$1$1$5
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoBlurView expoBlurView, float[] fArr) {
                    invoke2(expoBlurView, fArr);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ExpoBlurView view, float[] fArr) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (fArr == null) {
                        fArr = new float[8];
                    }
                    view.setBorderRadii(fArr);
                }
            };
            AnyType anyType5 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(float[].class), true));
            if (anyType5 == null) {
                try {
                    Result.Companion companion11 = Result.INSTANCE;
                    objM12684constructorimpl6 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(float[].class, true, null)), new Function0<KType>() { // from class: expo.modules.blur.BlurModule$definition$lambda$3$lambda$1$$inlined$Prop$5
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(float[].class);
                        }
                    }));
                } catch (Throwable th6) {
                    Result.Companion companion12 = Result.INSTANCE;
                    objM12684constructorimpl6 = Result.m12684constructorimpl(ResultKt.createFailure(th6));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl6)) {
                    objM12684constructorimpl6 = null;
                }
                TypeDescriptor typeDescriptor6 = (TypeDescriptor) objM12684constructorimpl6;
                if (typeDescriptor6 == null) {
                    typeDescriptor6 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(float[].class));
                }
                anyType5 = new AnyType(typeDescriptor6, null);
            }
            viewDefinitionBuilder.getProps().put("borderRadii", new ConcreteViewProp("borderRadii", anyType5, blurModule$definition$1$1$5));
            BlurModule$definition$1$1$6 blurModule$definition$1$1$6 = new Function2<ExpoBlurView, BlurMethod, Unit>() { // from class: expo.modules.blur.BlurModule$definition$1$1$6
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoBlurView expoBlurView, BlurMethod blurMethod) throws BlurViewConfigurationException {
                    invoke2(expoBlurView, blurMethod);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ExpoBlurView view, BlurMethod blurMethod) throws BlurViewConfigurationException {
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(blurMethod, "blurMethod");
                    view.setBlurMethod(blurMethod);
                }
            };
            AnyType anyType6 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(BlurMethod.class), false));
            if (anyType6 == null) {
                try {
                    Result.Companion companion13 = Result.INSTANCE;
                    objM12684constructorimpl7 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(BlurMethod.class, false, null)), new Function0<KType>() { // from class: expo.modules.blur.BlurModule$definition$lambda$3$lambda$1$$inlined$Prop$6
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(BlurMethod.class);
                        }
                    }));
                } catch (Throwable th7) {
                    Result.Companion companion14 = Result.INSTANCE;
                    objM12684constructorimpl7 = Result.m12684constructorimpl(ResultKt.createFailure(th7));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl7)) {
                    objM12684constructorimpl7 = null;
                }
                TypeDescriptor typeDescriptor7 = (TypeDescriptor) objM12684constructorimpl7;
                if (typeDescriptor7 == null) {
                    typeDescriptor7 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(BlurMethod.class));
                }
                anyType6 = new AnyType(typeDescriptor7, null);
            }
            viewDefinitionBuilder.getProps().put("blurMethod", new ConcreteViewProp("blurMethod", anyType6, blurModule$definition$1$1$6));
            viewDefinitionBuilder.setOnViewDidUpdateProps(new Function1<View, Unit>() { // from class: expo.modules.blur.BlurModule$definition$lambda$3$lambda$1$$inlined$OnViewDidUpdateProps$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ((ExpoBlurView) it).applyTint();
                }
            });
            moduleDefinitionBuilder2.registerViewDefinition(viewDefinitionBuilder.build());
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(ExpoBlurTargetView.class);
            try {
                Result.Companion companion15 = Result.INSTANCE;
                objM12684constructorimpl8 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(ExpoBlurTargetView.class, false, null)), new Function0<KType>() { // from class: expo.modules.blur.BlurModule$definition$lambda$3$$inlined$View$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(ExpoBlurTargetView.class);
                    }
                }));
            } catch (Throwable th8) {
                Result.Companion companion16 = Result.INSTANCE;
                objM12684constructorimpl8 = Result.m12684constructorimpl(ResultKt.createFailure(th8));
            }
            if (!Result.m12690isFailureimpl(objM12684constructorimpl8)) {
                obj = objM12684constructorimpl8;
            }
            TypeDescriptor typeDescriptor8 = (TypeDescriptor) obj;
            if (typeDescriptor8 == null) {
                typeDescriptor8 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ExpoBlurTargetView.class));
            }
            ViewDefinitionBuilder viewDefinitionBuilder2 = new ViewDefinitionBuilder(orCreateKotlinClass2, typeDescriptor8, moduleDefinitionBuilder3.getConverters());
            CSSPropsKt.UseCSSProps(viewDefinitionBuilder2);
            viewDefinitionBuilder2.Name("ExpoBlurTargetView");
            moduleDefinitionBuilder3.registerViewDefinition(viewDefinitionBuilder2.build());
            ModuleDefinitionData moduleDefinitionDataBuildModule = moduleDefinitionBuilder.buildModule();
            Trace.endSection();
            return moduleDefinitionDataBuildModule;
        } catch (Throwable th9) {
            Trace.endSection();
            throw th9;
        }
    }
}
