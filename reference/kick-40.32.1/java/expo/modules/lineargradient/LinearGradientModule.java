package expo.modules.lineargradient;

import androidx.tracing.Trace;
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
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

/* JADX INFO: compiled from: LinearGradientModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lexpo/modules/lineargradient/LinearGradientModule;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-linear-gradient_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LinearGradientModule extends Module {
    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        Object objM12684constructorimpl;
        Object objM12684constructorimpl2;
        Object objM12684constructorimpl3;
        Object objM12684constructorimpl4;
        Object objM12684constructorimpl5;
        Object objM12684constructorimpl6;
        Object objM12684constructorimpl7;
        LinearGradientModule linearGradientModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (linearGradientModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(linearGradientModule);
            moduleDefinitionBuilder.Name("ExpoLinearGradient");
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(LinearGradientView.class);
            try {
                Result.Companion companion = Result.INSTANCE;
                objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(LinearGradientView.class, false, null)), new Function0<KType>() { // from class: expo.modules.lineargradient.LinearGradientModule$definition$lambda$1$$inlined$View$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(LinearGradientView.class);
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
                typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(LinearGradientView.class));
            }
            ViewDefinitionBuilder viewDefinitionBuilder = new ViewDefinitionBuilder(orCreateKotlinClass, typeDescriptor, moduleDefinitionBuilder2.getConverters());
            CSSPropsKt.UseCSSProps(viewDefinitionBuilder);
            LinearGradientModule$definition$1$1$1 linearGradientModule$definition$1$1$1 = new Function2<LinearGradientView, int[], Unit>() { // from class: expo.modules.lineargradient.LinearGradientModule$definition$1$1$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(LinearGradientView linearGradientView, int[] iArr) {
                    invoke2(linearGradientView, iArr);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LinearGradientView view, int[] colors) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(colors, "colors");
                    view.setColors(colors);
                }
            };
            AnyType anyType = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(int[].class), false));
            if (anyType == null) {
                try {
                    Result.Companion companion3 = Result.INSTANCE;
                    objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(int[].class, false, null)), new Function0<KType>() { // from class: expo.modules.lineargradient.LinearGradientModule$definition$lambda$1$lambda$0$$inlined$Prop$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(int[].class);
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
                    typeDescriptor2 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(int[].class));
                }
                anyType = new AnyType(typeDescriptor2, null);
            }
            viewDefinitionBuilder.getProps().put("colors", new ConcreteViewProp("colors", anyType, linearGradientModule$definition$1$1$1));
            LinearGradientModule$definition$1$1$2 linearGradientModule$definition$1$1$2 = new Function2<LinearGradientView, float[], Unit>() { // from class: expo.modules.lineargradient.LinearGradientModule$definition$1$1$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(LinearGradientView linearGradientView, float[] fArr) {
                    invoke2(linearGradientView, fArr);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LinearGradientView view, float[] fArr) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (fArr != null) {
                        view.setLocations(fArr);
                    }
                }
            };
            AnyType anyType2 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(float[].class), true));
            if (anyType2 == null) {
                try {
                    Result.Companion companion5 = Result.INSTANCE;
                    objM12684constructorimpl3 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(float[].class, true, null)), new Function0<KType>() { // from class: expo.modules.lineargradient.LinearGradientModule$definition$lambda$1$lambda$0$$inlined$Prop$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(float[].class);
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
                    typeDescriptor3 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(float[].class));
                }
                anyType2 = new AnyType(typeDescriptor3, null);
            }
            viewDefinitionBuilder.getProps().put("locations", new ConcreteViewProp("locations", anyType2, linearGradientModule$definition$1$1$2));
            LinearGradientModule$definition$1$1$3 linearGradientModule$definition$1$1$3 = new Function2<LinearGradientView, Pair<? extends Float, ? extends Float>, Unit>() { // from class: expo.modules.lineargradient.LinearGradientModule$definition$1$1$3
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(LinearGradientView linearGradientView, Pair<? extends Float, ? extends Float> pair) {
                    invoke2(linearGradientView, (Pair<Float, Float>) pair);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LinearGradientView view, Pair<Float, Float> pair) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.setStartPosition(pair != null ? pair.getFirst().floatValue() : 0.5f, pair != null ? pair.getSecond().floatValue() : 0.0f);
                }
            };
            AnyType anyType3 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Pair.class), true));
            if (anyType3 == null) {
                try {
                    Result.Companion companion7 = Result.INSTANCE;
                    objM12684constructorimpl4 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateParameterized(Pair.class, true, Arrays.asList(PTypeDescriptorRegistry.FLOAT, PTypeDescriptorRegistry.FLOAT), null)), new Function0<KType>() { // from class: expo.modules.lineargradient.LinearGradientModule$definition$lambda$1$lambda$0$$inlined$Prop$3
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(Pair.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Float.TYPE)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Float.TYPE)));
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
                    typeDescriptor4 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Pair.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Float.TYPE)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Float.TYPE))));
                }
                anyType3 = new AnyType(typeDescriptor4, null);
            }
            viewDefinitionBuilder.getProps().put("startPoint", new ConcreteViewProp("startPoint", anyType3, linearGradientModule$definition$1$1$3));
            LinearGradientModule$definition$1$1$4 linearGradientModule$definition$1$1$4 = new Function2<LinearGradientView, Pair<? extends Float, ? extends Float>, Unit>() { // from class: expo.modules.lineargradient.LinearGradientModule$definition$1$1$4
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(LinearGradientView linearGradientView, Pair<? extends Float, ? extends Float> pair) {
                    invoke2(linearGradientView, (Pair<Float, Float>) pair);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LinearGradientView view, Pair<Float, Float> pair) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.setEndPosition(pair != null ? pair.getFirst().floatValue() : 0.5f, pair != null ? pair.getSecond().floatValue() : 1.0f);
                }
            };
            AnyType anyType4 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Pair.class), true));
            if (anyType4 == null) {
                try {
                    Result.Companion companion9 = Result.INSTANCE;
                    objM12684constructorimpl5 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateParameterized(Pair.class, true, Arrays.asList(PTypeDescriptorRegistry.FLOAT, PTypeDescriptorRegistry.FLOAT), null)), new Function0<KType>() { // from class: expo.modules.lineargradient.LinearGradientModule$definition$lambda$1$lambda$0$$inlined$Prop$4
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(Pair.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Float.TYPE)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Float.TYPE)));
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
                    typeDescriptor5 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Pair.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Float.TYPE)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Float.TYPE))));
                }
                anyType4 = new AnyType(typeDescriptor5, null);
            }
            viewDefinitionBuilder.getProps().put("endPoint", new ConcreteViewProp("endPoint", anyType4, linearGradientModule$definition$1$1$4));
            LinearGradientModule$definition$1$1$5 linearGradientModule$definition$1$1$5 = new Function2<LinearGradientView, float[], Unit>() { // from class: expo.modules.lineargradient.LinearGradientModule$definition$1$1$5
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(LinearGradientView linearGradientView, float[] fArr) {
                    invoke2(linearGradientView, fArr);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LinearGradientView view, float[] fArr) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (fArr == null) {
                        fArr = new float[8];
                        for (int i = 0; i < 8; i++) {
                            fArr[i] = 0.0f;
                        }
                    }
                    view.setBorderRadii(fArr);
                }
            };
            AnyType anyType5 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(float[].class), true));
            if (anyType5 == null) {
                try {
                    Result.Companion companion11 = Result.INSTANCE;
                    objM12684constructorimpl6 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(float[].class, true, null)), new Function0<KType>() { // from class: expo.modules.lineargradient.LinearGradientModule$definition$lambda$1$lambda$0$$inlined$Prop$5
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
            viewDefinitionBuilder.getProps().put("borderRadii", new ConcreteViewProp("borderRadii", anyType5, linearGradientModule$definition$1$1$5));
            LinearGradientModule$definition$1$1$6 linearGradientModule$definition$1$1$6 = new Function2<LinearGradientView, Boolean, Unit>() { // from class: expo.modules.lineargradient.LinearGradientModule$definition$1$1$6
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(LinearGradientView linearGradientView, Boolean bool) {
                    invoke2(linearGradientView, bool);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LinearGradientView view, Boolean bool) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.setDither(bool != null ? bool.booleanValue() : true);
                }
            };
            AnyType anyType6 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Boolean.class), true));
            if (anyType6 == null) {
                try {
                    Result.Companion companion13 = Result.INSTANCE;
                    objM12684constructorimpl7 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.BOOLEAN_NULLABLE), new Function0<KType>() { // from class: expo.modules.lineargradient.LinearGradientModule$definition$lambda$1$lambda$0$$inlined$Prop$6
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(Boolean.class);
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
                    typeDescriptor7 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Boolean.class));
                }
                anyType6 = new AnyType(typeDescriptor7, null);
            }
            viewDefinitionBuilder.getProps().put("dither", new ConcreteViewProp("dither", anyType6, linearGradientModule$definition$1$1$6));
            moduleDefinitionBuilder2.registerViewDefinition(viewDefinitionBuilder.build());
            ModuleDefinitionData moduleDefinitionDataBuildModule = moduleDefinitionBuilder.buildModule();
            Trace.endSection();
            return moduleDefinitionDataBuildModule;
        } catch (Throwable th8) {
            Trace.endSection();
            throw th8;
        }
    }
}
