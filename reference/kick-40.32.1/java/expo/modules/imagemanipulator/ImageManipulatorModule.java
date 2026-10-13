package expo.modules.imagemanipulator;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.tracing.Trace;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ImagesContract;
import expo.modules.imagemanipulator.transformers.CropTransformer;
import expo.modules.imagemanipulator.transformers.FlipTransformer;
import expo.modules.imagemanipulator.transformers.ResizeTransformer;
import expo.modules.imagemanipulator.transformers.RotateTransformer;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.classcomponent.ClassComponentBuilder;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.AsyncFunctionBuilder;
import expo.modules.kotlin.functions.SuspendFunctionComponent;
import expo.modules.kotlin.functions.SyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.objects.PropertyComponentBuilderWithThis;
import expo.modules.kotlin.sharedobjects.SharedRef;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeCache;
import expo.modules.kotlin.types.EitherOfThree;
import expo.modules.kotlin.types.JSTypeConverter;
import expo.modules.kotlin.types.ReturnType;
import expo.modules.kotlin.types.ReturnTypeKt;
import expo.modules.kotlin.types.ReturnTypeProvider;
import expo.modules.kotlin.types.TypeConverterProvider;
import expo.modules.kotlin.types.descriptors.TypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptorKt;
import expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt;
import io.github.expo.pika.PTypeDescriptor;
import io.github.expo.pika.PTypeDescriptorRegistry;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

/* JADX INFO: compiled from: ImageManipulatorModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\u001c\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lexpo/modules/imagemanipulator/ImageManipulatorModule;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", "createManipulatorContext", "Lexpo/modules/imagemanipulator/ImageManipulatorContext;", ImagesContract.URL, "Landroid/net/Uri;", "options", "Lexpo/modules/imagemanipulator/ImageLoadOptions;", "bitmap", "Landroid/graphics/Bitmap;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-image-manipulator_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ImageManipulatorModule extends Module {
    static /* synthetic */ ImageManipulatorContext createManipulatorContext$default(ImageManipulatorModule imageManipulatorModule, Uri uri, ImageLoadOptions imageLoadOptions, int i, Object obj) {
        if ((i & 2) != 0) {
            imageLoadOptions = null;
        }
        return imageManipulatorModule.createManipulatorContext(uri, imageLoadOptions);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageManipulatorContext createManipulatorContext(Uri url, ImageLoadOptions options) {
        return new ImageManipulatorContext(getRuntime(), new ManipulatorTask(getAppContext().getBackgroundCoroutineScope(), new ImageManipulatorModule$createManipulatorContext$loader$1(this, options, url, null)));
    }

    static /* synthetic */ ImageManipulatorContext createManipulatorContext$default(ImageManipulatorModule imageManipulatorModule, Bitmap bitmap, ImageLoadOptions imageLoadOptions, int i, Object obj) {
        if ((i & 2) != 0) {
            imageLoadOptions = null;
        }
        return imageManipulatorModule.createManipulatorContext(bitmap, imageLoadOptions);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageManipulatorContext createManipulatorContext(Bitmap bitmap, ImageLoadOptions options) {
        return new ImageManipulatorContext(getRuntime(), new ManipulatorTask(getAppContext().getBackgroundCoroutineScope(), new ImageManipulatorModule$createManipulatorContext$task$1(bitmap, options, null)));
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        int i;
        Object objM12684constructorimpl;
        Object objM12684constructorimpl2;
        Object objM12684constructorimpl3;
        AnyType anyType;
        Object objM12684constructorimpl4;
        Object objM12684constructorimpl5;
        Object objM12684constructorimpl6;
        Object objM12684constructorimpl7;
        Object objM12684constructorimpl8;
        Object objM12684constructorimpl9;
        Object objM12684constructorimpl10;
        Object objM12684constructorimpl11;
        Object objM12684constructorimpl12;
        Object objM12684constructorimpl13;
        Object objM12684constructorimpl14;
        Object objM12684constructorimpl15;
        AnyType anyType2;
        Object objM12684constructorimpl16;
        Object objM12684constructorimpl17;
        ImageManipulatorModule imageManipulatorModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (imageManipulatorModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(imageManipulatorModule);
            moduleDefinitionBuilder.Name("ExpoImageManipulator");
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            TypeConverterProvider converters = moduleDefinitionBuilder2.getConverters();
            AnyType[] anyTypeArr = new AnyType[2];
            AnyType anyType3 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(EitherOfThree.class), false));
            if (anyType3 != null) {
                i = 2;
            } else {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    PTypeDescriptor[] pTypeDescriptorArr = new PTypeDescriptor[3];
                    pTypeDescriptorArr[0] = PTypeDescriptorRegistry.getOrCreateConcrete(Uri.class, false, null);
                    PTypeDescriptor[] pTypeDescriptorArr2 = new PTypeDescriptor[1];
                    i = 2;
                    try {
                        pTypeDescriptorArr2[0] = PTypeDescriptorRegistry.getOrCreateConcrete(Bitmap.class, false, null);
                        pTypeDescriptorArr[1] = PTypeDescriptorRegistry.getOrCreateParameterized(SharedRef.class, false, Arrays.asList(pTypeDescriptorArr2), null);
                        pTypeDescriptorArr[2] = PTypeDescriptorRegistry.getOrCreateParameterized(SharedRef.class, false, Arrays.asList(PTypeDescriptorRegistry.getOrCreateConcrete(Drawable.class, false, null)), null);
                        objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateParameterized(EitherOfThree.class, false, Arrays.asList(pTypeDescriptorArr), null)), new Function0<KType>() { // from class: expo.modules.imagemanipulator.ImageManipulatorModule$definition$lambda$13$$inlined$Function$1
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                return Reflection.typeOf(EitherOfThree.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Uri.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(SharedRef.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Bitmap.class)))), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(SharedRef.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Drawable.class)))));
                            }
                        }));
                    } catch (Throwable th) {
                        th = th;
                        Result.Companion companion2 = Result.INSTANCE;
                        objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
                    }
                } catch (Throwable th2) {
                    th = th2;
                    i = 2;
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
                    objM12684constructorimpl = null;
                }
                TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
                if (typeDescriptor == null) {
                    KTypeProjection[] kTypeProjectionArr = new KTypeProjection[3];
                    kTypeProjectionArr[0] = KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Uri.class));
                    kTypeProjectionArr[1] = KTypeProjection.INSTANCE.invariant(Reflection.typeOf(SharedRef.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Bitmap.class))));
                    kTypeProjectionArr[i] = KTypeProjection.INSTANCE.invariant(Reflection.typeOf(SharedRef.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Drawable.class))));
                    typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(EitherOfThree.class, kTypeProjectionArr));
                }
                anyType3 = new AnyType(typeDescriptor, converters);
            }
            anyTypeArr[0] = anyType3;
            AnyType anyType4 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ImageLoadOptions.class), true));
            if (anyType4 == null) {
                try {
                    Result.Companion companion3 = Result.INSTANCE;
                    objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(ImageLoadOptions.class, true, ImageLoadOptions.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.imagemanipulator.ImageManipulatorModule$definition$lambda$13$$inlined$Function$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(ImageLoadOptions.class);
                        }
                    }));
                } catch (Throwable th3) {
                    Result.Companion companion4 = Result.INSTANCE;
                    objM12684constructorimpl2 = Result.m12684constructorimpl(ResultKt.createFailure(th3));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl2)) {
                    objM12684constructorimpl2 = null;
                }
                TypeDescriptor typeDescriptor2 = (TypeDescriptor) objM12684constructorimpl2;
                if (typeDescriptor2 == null) {
                    typeDescriptor2 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(ImageLoadOptions.class));
                }
                anyType4 = new AnyType(typeDescriptor2, converters);
            }
            anyTypeArr[1] = anyType4;
            ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
            ReturnType returnType = returnTypeProvider.getTypes().get(ImageManipulatorContext.class);
            if (returnType == null) {
                JSTypeConverter<?> directConverter = ReturnTypeKt.getDirectConverter(ImageManipulatorContext.class);
                if (directConverter == null) {
                    directConverter = ReturnTypeKt.getIndirectConverter(ImageManipulatorContext.class, null);
                }
                ReturnType returnType2 = new ReturnType(directConverter);
                returnTypeProvider.getTypes().put(ImageManipulatorContext.class, returnType2);
                returnType = returnType2;
            }
            moduleDefinitionBuilder2.getSyncFunctions().put("manipulate", new SyncFunctionComponent("manipulate", anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.imagemanipulator.ImageManipulatorModule$definition$lambda$13$$inlined$Function$3
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) throws Exceptions.IllegalArgument {
                    Bitmap bitmap;
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj = objArr[0];
                    ImageLoadOptions imageLoadOptions = (ImageLoadOptions) objArr[1];
                    EitherOfThree eitherOfThree = (EitherOfThree) obj;
                    if (eitherOfThree.isFirstType(Reflection.getOrCreateKotlinClass(Uri.class))) {
                        return this.this$0.createManipulatorContext((Uri) eitherOfThree.getFirstType(Reflection.getOrCreateKotlinClass(Uri.class)), imageLoadOptions);
                    }
                    if (eitherOfThree.isSecondType(Reflection.getOrCreateKotlinClass(SharedRef.class))) {
                        return this.this$0.createManipulatorContext((Bitmap) ((SharedRef) eitherOfThree.getSecondType(Reflection.getOrCreateKotlinClass(SharedRef.class))).getRef(), imageLoadOptions);
                    }
                    Drawable drawable = (Drawable) ((SharedRef) eitherOfThree.getThirdType(Reflection.getOrCreateKotlinClass(SharedRef.class))).getRef();
                    BitmapDrawable bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : null;
                    if (bitmapDrawable != null && (bitmap = bitmapDrawable.getBitmap()) != null) {
                        return this.this$0.createManipulatorContext(bitmap, imageLoadOptions);
                    }
                    throw new Exceptions.IllegalArgument("The drawable cannot be converted to a bitmap", null, 2, null);
                }
            }));
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ImageManipulatorContext.class);
            Module module = moduleDefinitionBuilder3.getModule();
            if (module == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            AppContext appContext = module.getAppContext();
            AnyType anyType5 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ImageManipulatorContext.class), false));
            if (anyType5 != null) {
                anyType = anyType5;
            } else {
                try {
                    Result.Companion companion5 = Result.INSTANCE;
                    objM12684constructorimpl3 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(ImageManipulatorContext.class, false, null)), new Function0<KType>() { // from class: expo.modules.imagemanipulator.ImageManipulatorModule$definition$lambda$13$$inlined$Class$default$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(ImageManipulatorContext.class);
                        }
                    }));
                } catch (Throwable th4) {
                    Result.Companion companion6 = Result.INSTANCE;
                    objM12684constructorimpl3 = Result.m12684constructorimpl(ResultKt.createFailure(th4));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl3)) {
                    objM12684constructorimpl3 = null;
                }
                TypeDescriptor typeDescriptor3 = (TypeDescriptor) objM12684constructorimpl3;
                if (typeDescriptor3 == null) {
                    typeDescriptor3 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ImageManipulatorContext.class));
                }
                anyType = new AnyType(typeDescriptor3, null);
            }
            ClassComponentBuilder classComponentBuilder = new ClassComponentBuilder(appContext, "Context", orCreateKotlinClass, anyType, moduleDefinitionBuilder3.getConverters());
            TypeConverterProvider converters2 = classComponentBuilder.getConverters();
            AnyType[] anyTypeArr2 = new AnyType[1];
            AnyType anyType6 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Uri.class), false));
            if (anyType6 == null) {
                try {
                    Result.Companion companion7 = Result.INSTANCE;
                    objM12684constructorimpl4 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Uri.class, false, null)), new Function0<KType>() { // from class: expo.modules.imagemanipulator.ImageManipulatorModule$definition$lambda$13$lambda$8$$inlined$Constructor$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Uri.class);
                        }
                    }));
                } catch (Throwable th5) {
                    Result.Companion companion8 = Result.INSTANCE;
                    objM12684constructorimpl4 = Result.m12684constructorimpl(ResultKt.createFailure(th5));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl4)) {
                    objM12684constructorimpl4 = null;
                }
                TypeDescriptor typeDescriptor4 = (TypeDescriptor) objM12684constructorimpl4;
                if (typeDescriptor4 == null) {
                    typeDescriptor4 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Uri.class));
                }
                anyType6 = new AnyType(typeDescriptor4, converters2);
            }
            anyTypeArr2[0] = anyType6;
            ReturnTypeProvider returnTypeProvider2 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType3 = returnTypeProvider2.getTypes().get(Object.class);
            if (returnType3 == null) {
                JSTypeConverter<?> directConverter2 = ReturnTypeKt.getDirectConverter(Object.class);
                if (directConverter2 == null) {
                    directConverter2 = ReturnTypeKt.getIndirectConverter(Object.class, null);
                }
                ReturnType returnType4 = new ReturnType(directConverter2);
                returnTypeProvider2.getTypes().put(Object.class, returnType4);
                returnType3 = returnType4;
            }
            classComponentBuilder.setConstructor(new SyncFunctionComponent("constructor", anyTypeArr2, returnType3, new Function1<Object[], Object>() { // from class: expo.modules.imagemanipulator.ImageManipulatorModule$definition$lambda$13$lambda$8$$inlined$Constructor$2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    return ImageManipulatorModule.createManipulatorContext$default(this.this$0, (Uri) objArr[0], (ImageLoadOptions) null, 2, (Object) null);
                }
            }));
            ClassComponentBuilder classComponentBuilder2 = classComponentBuilder;
            TypeConverterProvider converters3 = classComponentBuilder2.getConverters();
            AnyType[] anyTypeArr3 = new AnyType[i];
            AnyType anyType7 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ImageManipulatorContext.class), false));
            if (anyType7 == null) {
                try {
                    Result.Companion companion9 = Result.INSTANCE;
                    objM12684constructorimpl5 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(ImageManipulatorContext.class, false, null)), new Function0<KType>() { // from class: expo.modules.imagemanipulator.ImageManipulatorModule$definition$lambda$13$lambda$8$$inlined$Function$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(ImageManipulatorContext.class);
                        }
                    }));
                } catch (Throwable th6) {
                    Result.Companion companion10 = Result.INSTANCE;
                    objM12684constructorimpl5 = Result.m12684constructorimpl(ResultKt.createFailure(th6));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl5)) {
                    objM12684constructorimpl5 = null;
                }
                TypeDescriptor typeDescriptor5 = (TypeDescriptor) objM12684constructorimpl5;
                if (typeDescriptor5 == null) {
                    typeDescriptor5 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ImageManipulatorContext.class));
                }
                anyType7 = new AnyType(typeDescriptor5, converters3);
            }
            anyTypeArr3[0] = anyType7;
            AnyType anyType8 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ResizeOptions.class), false));
            if (anyType8 == null) {
                try {
                    Result.Companion companion11 = Result.INSTANCE;
                    objM12684constructorimpl6 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(ResizeOptions.class, false, ResizeOptions.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.imagemanipulator.ImageManipulatorModule$definition$lambda$13$lambda$8$$inlined$Function$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(ResizeOptions.class);
                        }
                    }));
                } catch (Throwable th7) {
                    Result.Companion companion12 = Result.INSTANCE;
                    objM12684constructorimpl6 = Result.m12684constructorimpl(ResultKt.createFailure(th7));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl6)) {
                    objM12684constructorimpl6 = null;
                }
                TypeDescriptor typeDescriptor6 = (TypeDescriptor) objM12684constructorimpl6;
                if (typeDescriptor6 == null) {
                    typeDescriptor6 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ResizeOptions.class));
                }
                anyType8 = new AnyType(typeDescriptor6, converters3);
            }
            anyTypeArr3[1] = anyType8;
            ReturnTypeProvider returnTypeProvider3 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType5 = returnTypeProvider3.getTypes().get(ImageManipulatorContext.class);
            if (returnType5 == null) {
                JSTypeConverter<?> directConverter3 = ReturnTypeKt.getDirectConverter(ImageManipulatorContext.class);
                if (directConverter3 == null) {
                    directConverter3 = ReturnTypeKt.getIndirectConverter(ImageManipulatorContext.class, null);
                }
                ReturnType returnType6 = new ReturnType(directConverter3);
                returnTypeProvider3.getTypes().put(ImageManipulatorContext.class, returnType6);
                returnType5 = returnType6;
            }
            classComponentBuilder2.getSyncFunctions().put("resize", new SyncFunctionComponent("resize", anyTypeArr3, returnType5, new Function1<Object[], Object>() { // from class: expo.modules.imagemanipulator.ImageManipulatorModule$definition$lambda$13$lambda$8$$inlined$Function$3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    return ((ImageManipulatorContext) objArr[0]).addTransformer(new ResizeTransformer((ResizeOptions) objArr[1]));
                }
            }));
            ClassComponentBuilder classComponentBuilder3 = classComponentBuilder;
            TypeConverterProvider converters4 = classComponentBuilder3.getConverters();
            AnyType[] anyTypeArr4 = new AnyType[2];
            AnyType anyType9 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ImageManipulatorContext.class), false));
            if (anyType9 == null) {
                try {
                    Result.Companion companion13 = Result.INSTANCE;
                    objM12684constructorimpl7 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(ImageManipulatorContext.class, false, null)), new Function0<KType>() { // from class: expo.modules.imagemanipulator.ImageManipulatorModule$definition$lambda$13$lambda$8$$inlined$Function$4
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(ImageManipulatorContext.class);
                        }
                    }));
                } catch (Throwable th8) {
                    Result.Companion companion14 = Result.INSTANCE;
                    objM12684constructorimpl7 = Result.m12684constructorimpl(ResultKt.createFailure(th8));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl7)) {
                    objM12684constructorimpl7 = null;
                }
                TypeDescriptor typeDescriptor7 = (TypeDescriptor) objM12684constructorimpl7;
                if (typeDescriptor7 == null) {
                    typeDescriptor7 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ImageManipulatorContext.class));
                }
                anyType9 = new AnyType(typeDescriptor7, converters4);
            }
            anyTypeArr4[0] = anyType9;
            AnyType anyType10 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Float.class), false));
            if (anyType10 == null) {
                try {
                    Result.Companion companion15 = Result.INSTANCE;
                    objM12684constructorimpl8 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.FLOAT), new Function0<KType>() { // from class: expo.modules.imagemanipulator.ImageManipulatorModule$definition$lambda$13$lambda$8$$inlined$Function$5
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Float.TYPE);
                        }
                    }));
                } catch (Throwable th9) {
                    Result.Companion companion16 = Result.INSTANCE;
                    objM12684constructorimpl8 = Result.m12684constructorimpl(ResultKt.createFailure(th9));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl8)) {
                    objM12684constructorimpl8 = null;
                }
                TypeDescriptor typeDescriptor8 = (TypeDescriptor) objM12684constructorimpl8;
                if (typeDescriptor8 == null) {
                    typeDescriptor8 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Float.TYPE));
                }
                anyType10 = new AnyType(typeDescriptor8, converters4);
            }
            anyTypeArr4[1] = anyType10;
            ReturnTypeProvider returnTypeProvider4 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType7 = returnTypeProvider4.getTypes().get(ImageManipulatorContext.class);
            if (returnType7 == null) {
                JSTypeConverter<?> directConverter4 = ReturnTypeKt.getDirectConverter(ImageManipulatorContext.class);
                if (directConverter4 == null) {
                    directConverter4 = ReturnTypeKt.getIndirectConverter(ImageManipulatorContext.class, null);
                }
                ReturnType returnType8 = new ReturnType(directConverter4);
                returnTypeProvider4.getTypes().put(ImageManipulatorContext.class, returnType8);
                returnType7 = returnType8;
            }
            classComponentBuilder3.getSyncFunctions().put("rotate", new SyncFunctionComponent("rotate", anyTypeArr4, returnType7, new Function1<Object[], Object>() { // from class: expo.modules.imagemanipulator.ImageManipulatorModule$definition$lambda$13$lambda$8$$inlined$Function$6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    return ((ImageManipulatorContext) objArr[0]).addTransformer(new RotateTransformer(((Number) objArr[1]).floatValue()));
                }
            }));
            ClassComponentBuilder classComponentBuilder4 = classComponentBuilder;
            TypeConverterProvider converters5 = classComponentBuilder4.getConverters();
            AnyType[] anyTypeArr5 = new AnyType[2];
            AnyType anyType11 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ImageManipulatorContext.class), false));
            if (anyType11 == null) {
                try {
                    Result.Companion companion17 = Result.INSTANCE;
                    objM12684constructorimpl9 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(ImageManipulatorContext.class, false, null)), new Function0<KType>() { // from class: expo.modules.imagemanipulator.ImageManipulatorModule$definition$lambda$13$lambda$8$$inlined$Function$7
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(ImageManipulatorContext.class);
                        }
                    }));
                } catch (Throwable th10) {
                    Result.Companion companion18 = Result.INSTANCE;
                    objM12684constructorimpl9 = Result.m12684constructorimpl(ResultKt.createFailure(th10));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl9)) {
                    objM12684constructorimpl9 = null;
                }
                TypeDescriptor typeDescriptor9 = (TypeDescriptor) objM12684constructorimpl9;
                if (typeDescriptor9 == null) {
                    typeDescriptor9 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ImageManipulatorContext.class));
                }
                anyType11 = new AnyType(typeDescriptor9, converters5);
            }
            anyTypeArr5[0] = anyType11;
            AnyType anyType12 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FlipType.class), false));
            if (anyType12 == null) {
                try {
                    Result.Companion companion19 = Result.INSTANCE;
                    objM12684constructorimpl10 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FlipType.class, false, null)), new Function0<KType>() { // from class: expo.modules.imagemanipulator.ImageManipulatorModule$definition$lambda$13$lambda$8$$inlined$Function$8
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FlipType.class);
                        }
                    }));
                } catch (Throwable th11) {
                    Result.Companion companion20 = Result.INSTANCE;
                    objM12684constructorimpl10 = Result.m12684constructorimpl(ResultKt.createFailure(th11));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl10)) {
                    objM12684constructorimpl10 = null;
                }
                TypeDescriptor typeDescriptor10 = (TypeDescriptor) objM12684constructorimpl10;
                if (typeDescriptor10 == null) {
                    typeDescriptor10 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FlipType.class));
                }
                anyType12 = new AnyType(typeDescriptor10, converters5);
            }
            anyTypeArr5[1] = anyType12;
            ReturnTypeProvider returnTypeProvider5 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType9 = returnTypeProvider5.getTypes().get(ImageManipulatorContext.class);
            if (returnType9 == null) {
                JSTypeConverter<?> directConverter5 = ReturnTypeKt.getDirectConverter(ImageManipulatorContext.class);
                if (directConverter5 == null) {
                    directConverter5 = ReturnTypeKt.getIndirectConverter(ImageManipulatorContext.class, null);
                }
                ReturnType returnType10 = new ReturnType(directConverter5);
                returnTypeProvider5.getTypes().put(ImageManipulatorContext.class, returnType10);
                returnType9 = returnType10;
            }
            classComponentBuilder4.getSyncFunctions().put("flip", new SyncFunctionComponent("flip", anyTypeArr5, returnType9, new Function1<Object[], Object>() { // from class: expo.modules.imagemanipulator.ImageManipulatorModule$definition$lambda$13$lambda$8$$inlined$Function$9
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    return ((ImageManipulatorContext) objArr[0]).addTransformer(new FlipTransformer((FlipType) objArr[1]));
                }
            }));
            ClassComponentBuilder classComponentBuilder5 = classComponentBuilder;
            TypeConverterProvider converters6 = classComponentBuilder5.getConverters();
            AnyType[] anyTypeArr6 = new AnyType[2];
            AnyType anyType13 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ImageManipulatorContext.class), false));
            if (anyType13 == null) {
                try {
                    Result.Companion companion21 = Result.INSTANCE;
                    objM12684constructorimpl11 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(ImageManipulatorContext.class, false, null)), new Function0<KType>() { // from class: expo.modules.imagemanipulator.ImageManipulatorModule$definition$lambda$13$lambda$8$$inlined$Function$10
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(ImageManipulatorContext.class);
                        }
                    }));
                } catch (Throwable th12) {
                    Result.Companion companion22 = Result.INSTANCE;
                    objM12684constructorimpl11 = Result.m12684constructorimpl(ResultKt.createFailure(th12));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl11)) {
                    objM12684constructorimpl11 = null;
                }
                TypeDescriptor typeDescriptor11 = (TypeDescriptor) objM12684constructorimpl11;
                if (typeDescriptor11 == null) {
                    typeDescriptor11 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ImageManipulatorContext.class));
                }
                anyType13 = new AnyType(typeDescriptor11, converters6);
            }
            anyTypeArr6[0] = anyType13;
            AnyType anyType14 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(CropRect.class), false));
            if (anyType14 == null) {
                try {
                    Result.Companion companion23 = Result.INSTANCE;
                    objM12684constructorimpl12 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(CropRect.class, false, CropRect.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.imagemanipulator.ImageManipulatorModule$definition$lambda$13$lambda$8$$inlined$Function$11
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(CropRect.class);
                        }
                    }));
                } catch (Throwable th13) {
                    Result.Companion companion24 = Result.INSTANCE;
                    objM12684constructorimpl12 = Result.m12684constructorimpl(ResultKt.createFailure(th13));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl12)) {
                    objM12684constructorimpl12 = null;
                }
                TypeDescriptor typeDescriptor12 = (TypeDescriptor) objM12684constructorimpl12;
                if (typeDescriptor12 == null) {
                    typeDescriptor12 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(CropRect.class));
                }
                anyType14 = new AnyType(typeDescriptor12, converters6);
            }
            anyTypeArr6[1] = anyType14;
            ReturnTypeProvider returnTypeProvider6 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType11 = returnTypeProvider6.getTypes().get(ImageManipulatorContext.class);
            if (returnType11 == null) {
                JSTypeConverter<?> directConverter6 = ReturnTypeKt.getDirectConverter(ImageManipulatorContext.class);
                if (directConverter6 == null) {
                    directConverter6 = ReturnTypeKt.getIndirectConverter(ImageManipulatorContext.class, null);
                }
                ReturnType returnType12 = new ReturnType(directConverter6);
                returnTypeProvider6.getTypes().put(ImageManipulatorContext.class, returnType12);
                returnType11 = returnType12;
            }
            classComponentBuilder5.getSyncFunctions().put("crop", new SyncFunctionComponent("crop", anyTypeArr6, returnType11, new Function1<Object[], Object>() { // from class: expo.modules.imagemanipulator.ImageManipulatorModule$definition$lambda$13$lambda$8$$inlined$Function$12
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    return ((ImageManipulatorContext) objArr[0]).addTransformer(new CropTransformer((CropRect) objArr[1]));
                }
            }));
            ClassComponentBuilder classComponentBuilder6 = classComponentBuilder;
            TypeConverterProvider converters7 = classComponentBuilder6.getConverters();
            AnyType[] anyTypeArr7 = new AnyType[1];
            AnyType anyType15 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ImageManipulatorContext.class), false));
            if (anyType15 == null) {
                try {
                    Result.Companion companion25 = Result.INSTANCE;
                    objM12684constructorimpl13 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(ImageManipulatorContext.class, false, null)), new Function0<KType>() { // from class: expo.modules.imagemanipulator.ImageManipulatorModule$definition$lambda$13$lambda$8$$inlined$Function$13
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(ImageManipulatorContext.class);
                        }
                    }));
                } catch (Throwable th14) {
                    Result.Companion companion26 = Result.INSTANCE;
                    objM12684constructorimpl13 = Result.m12684constructorimpl(ResultKt.createFailure(th14));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl13)) {
                    objM12684constructorimpl13 = null;
                }
                TypeDescriptor typeDescriptor13 = (TypeDescriptor) objM12684constructorimpl13;
                if (typeDescriptor13 == null) {
                    typeDescriptor13 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ImageManipulatorContext.class));
                }
                anyType15 = new AnyType(typeDescriptor13, converters7);
            }
            anyTypeArr7[0] = anyType15;
            ReturnTypeProvider returnTypeProvider7 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType13 = returnTypeProvider7.getTypes().get(ImageManipulatorContext.class);
            if (returnType13 == null) {
                JSTypeConverter<?> directConverter7 = ReturnTypeKt.getDirectConverter(ImageManipulatorContext.class);
                if (directConverter7 == null) {
                    directConverter7 = ReturnTypeKt.getIndirectConverter(ImageManipulatorContext.class, null);
                }
                ReturnType returnType14 = new ReturnType(directConverter7);
                returnTypeProvider7.getTypes().put(ImageManipulatorContext.class, returnType14);
                returnType13 = returnType14;
            }
            classComponentBuilder6.getSyncFunctions().put("reset", new SyncFunctionComponent("reset", anyTypeArr7, returnType13, new Function1<Object[], Object>() { // from class: expo.modules.imagemanipulator.ImageManipulatorModule$definition$lambda$13$lambda$8$$inlined$Function$14
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    return ((ImageManipulatorContext) objArr[0]).reset();
                }
            }));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction = classComponentBuilder.AsyncFunction("renderAsync");
            String name = asyncFunctionBuilderAsyncFunction.getName();
            TypeConverterProvider converters8 = asyncFunctionBuilderAsyncFunction.getConverters();
            AnyType[] anyTypeArr8 = new AnyType[1];
            AnyType anyType16 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ImageManipulatorContext.class), false));
            if (anyType16 == null) {
                try {
                    Result.Companion companion27 = Result.INSTANCE;
                    objM12684constructorimpl14 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(ImageManipulatorContext.class, false, null)), new Function0<KType>() { // from class: expo.modules.imagemanipulator.ImageManipulatorModule$definition$lambda$13$lambda$8$$inlined$Coroutine$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(ImageManipulatorContext.class);
                        }
                    }));
                } catch (Throwable th15) {
                    Result.Companion companion28 = Result.INSTANCE;
                    objM12684constructorimpl14 = Result.m12684constructorimpl(ResultKt.createFailure(th15));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl14)) {
                    objM12684constructorimpl14 = null;
                }
                TypeDescriptor typeDescriptor14 = (TypeDescriptor) objM12684constructorimpl14;
                if (typeDescriptor14 == null) {
                    typeDescriptor14 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ImageManipulatorContext.class));
                }
                anyType16 = new AnyType(typeDescriptor14, converters8);
            }
            anyTypeArr8[0] = anyType16;
            asyncFunctionBuilderAsyncFunction.setAsyncFunctionComponent(new SuspendFunctionComponent(name, anyTypeArr8, new ImageManipulatorModule$definition$lambda$13$lambda$8$$inlined$Coroutine$2(null, this)));
            moduleDefinitionBuilder3.getClassData().add(classComponentBuilder.buildClass());
            ModuleDefinitionBuilder moduleDefinitionBuilder4 = moduleDefinitionBuilder;
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(ImageRef.class);
            Module module2 = moduleDefinitionBuilder4.getModule();
            if (module2 == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            AppContext appContext2 = module2.getAppContext();
            AnyType anyType17 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ImageRef.class), false));
            if (anyType17 != null) {
                anyType2 = anyType17;
            } else {
                try {
                    Result.Companion companion29 = Result.INSTANCE;
                    objM12684constructorimpl15 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(ImageRef.class, false, null)), new Function0<KType>() { // from class: expo.modules.imagemanipulator.ImageManipulatorModule$definition$lambda$13$$inlined$Class$default$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(ImageRef.class);
                        }
                    }));
                } catch (Throwable th16) {
                    Result.Companion companion30 = Result.INSTANCE;
                    objM12684constructorimpl15 = Result.m12684constructorimpl(ResultKt.createFailure(th16));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl15)) {
                    objM12684constructorimpl15 = null;
                }
                TypeDescriptor typeDescriptor15 = (TypeDescriptor) objM12684constructorimpl15;
                if (typeDescriptor15 == null) {
                    typeDescriptor15 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ImageRef.class));
                }
                anyType2 = new AnyType(typeDescriptor15, null);
            }
            ClassComponentBuilder classComponentBuilder7 = new ClassComponentBuilder(appContext2, "Image", orCreateKotlinClass2, anyType2, moduleDefinitionBuilder4.getConverters());
            PropertyComponentBuilderWithThis propertyComponentBuilderWithThis = new PropertyComponentBuilderWithThis(classComponentBuilder7.getOwnerType().getTypeDescriptor(), ViewProps.WIDTH);
            AnyType[] anyTypeArr9 = {new AnyType(propertyComponentBuilderWithThis.getThisType(), null, 2, null)};
            ReturnTypeProvider returnTypeProvider8 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType15 = returnTypeProvider8.getTypes().get(Integer.class);
            if (returnType15 == null) {
                JSTypeConverter<?> directConverter8 = ReturnTypeKt.getDirectConverter(Integer.class);
                if (directConverter8 == null) {
                    directConverter8 = ReturnTypeKt.getIndirectConverter(Integer.class, null);
                }
                ReturnType returnType16 = new ReturnType(directConverter8);
                returnTypeProvider8.getTypes().put(Integer.class, returnType16);
                returnType15 = returnType16;
            }
            SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent("get", anyTypeArr9, returnType15, new Function1<Object[], Object>() { // from class: expo.modules.imagemanipulator.ImageManipulatorModule$definition$lambda$13$lambda$12$$inlined$Property$1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Integer.valueOf(((ImageRef) it[0]).getRef().getWidth());
                }
            });
            syncFunctionComponent.setOwnerType(propertyComponentBuilderWithThis.getThisType());
            syncFunctionComponent.setCanTakeOwner(true);
            propertyComponentBuilderWithThis.setGetter(syncFunctionComponent);
            classComponentBuilder7.getProperties().put(ViewProps.WIDTH, propertyComponentBuilderWithThis);
            PropertyComponentBuilderWithThis propertyComponentBuilderWithThis2 = new PropertyComponentBuilderWithThis(classComponentBuilder7.getOwnerType().getTypeDescriptor(), ViewProps.HEIGHT);
            AnyType[] anyTypeArr10 = {new AnyType(propertyComponentBuilderWithThis2.getThisType(), null, 2, null)};
            ReturnTypeProvider returnTypeProvider9 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType17 = returnTypeProvider9.getTypes().get(Integer.class);
            if (returnType17 == null) {
                JSTypeConverter<?> directConverter9 = ReturnTypeKt.getDirectConverter(Integer.class);
                if (directConverter9 == null) {
                    directConverter9 = ReturnTypeKt.getIndirectConverter(Integer.class, null);
                }
                ReturnType returnType18 = new ReturnType(directConverter9);
                returnTypeProvider9.getTypes().put(Integer.class, returnType18);
                returnType17 = returnType18;
            }
            SyncFunctionComponent syncFunctionComponent2 = new SyncFunctionComponent("get", anyTypeArr10, returnType17, new Function1<Object[], Object>() { // from class: expo.modules.imagemanipulator.ImageManipulatorModule$definition$lambda$13$lambda$12$$inlined$Property$2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Integer.valueOf(((ImageRef) it[0]).getRef().getHeight());
                }
            });
            syncFunctionComponent2.setOwnerType(propertyComponentBuilderWithThis2.getThisType());
            syncFunctionComponent2.setCanTakeOwner(true);
            propertyComponentBuilderWithThis2.setGetter(syncFunctionComponent2);
            classComponentBuilder7.getProperties().put(ViewProps.HEIGHT, propertyComponentBuilderWithThis2);
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction2 = classComponentBuilder7.AsyncFunction("saveAsync");
            String name2 = asyncFunctionBuilderAsyncFunction2.getName();
            TypeConverterProvider converters9 = asyncFunctionBuilderAsyncFunction2.getConverters();
            AnyType[] anyTypeArr11 = new AnyType[2];
            AnyType anyType18 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ImageRef.class), false));
            if (anyType18 == null) {
                try {
                    Result.Companion companion31 = Result.INSTANCE;
                    objM12684constructorimpl16 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(ImageRef.class, false, null)), new Function0<KType>() { // from class: expo.modules.imagemanipulator.ImageManipulatorModule$definition$lambda$13$lambda$12$$inlined$Coroutine$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(ImageRef.class);
                        }
                    }));
                } catch (Throwable th17) {
                    Result.Companion companion32 = Result.INSTANCE;
                    objM12684constructorimpl16 = Result.m12684constructorimpl(ResultKt.createFailure(th17));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl16)) {
                    objM12684constructorimpl16 = null;
                }
                TypeDescriptor typeDescriptor16 = (TypeDescriptor) objM12684constructorimpl16;
                if (typeDescriptor16 == null) {
                    typeDescriptor16 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ImageRef.class));
                }
                anyType18 = new AnyType(typeDescriptor16, converters9);
            }
            anyTypeArr11[0] = anyType18;
            AnyType anyType19 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ManipulateOptions.class), true));
            if (anyType19 == null) {
                try {
                    Result.Companion companion33 = Result.INSTANCE;
                    objM12684constructorimpl17 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(ManipulateOptions.class, true, ManipulateOptions.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.imagemanipulator.ImageManipulatorModule$definition$lambda$13$lambda$12$$inlined$Coroutine$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(ManipulateOptions.class);
                        }
                    }));
                } catch (Throwable th18) {
                    Result.Companion companion34 = Result.INSTANCE;
                    objM12684constructorimpl17 = Result.m12684constructorimpl(ResultKt.createFailure(th18));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl17)) {
                    objM12684constructorimpl17 = null;
                }
                TypeDescriptor typeDescriptor17 = (TypeDescriptor) objM12684constructorimpl17;
                if (typeDescriptor17 == null) {
                    typeDescriptor17 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(ManipulateOptions.class));
                }
                anyType19 = new AnyType(typeDescriptor17, converters9);
            }
            anyTypeArr11[1] = anyType19;
            asyncFunctionBuilderAsyncFunction2.setAsyncFunctionComponent(new SuspendFunctionComponent(name2, anyTypeArr11, new ImageManipulatorModule$definition$lambda$13$lambda$12$$inlined$Coroutine$3(null, this)));
            moduleDefinitionBuilder4.getClassData().add(classComponentBuilder7.buildClass());
            ModuleDefinitionData moduleDefinitionDataBuildModule = moduleDefinitionBuilder.buildModule();
            Trace.endSection();
            return moduleDefinitionDataBuildModule;
        } catch (Throwable th19) {
            Trace.endSection();
            throw th19;
        }
    }
}
