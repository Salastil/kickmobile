package expo.modules.screenorientation;

import android.app.Activity;
import android.graphics.Insets;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import androidx.tracing.Trace;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.core.errors.InvalidArgumentException;
import expo.modules.core.interfaces.LifecycleEventListener;
import expo.modules.core.interfaces.services.UIManager;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.functions.UntypedAsyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeCache;
import expo.modules.kotlin.types.TypeConverterProvider;
import expo.modules.kotlin.types.descriptors.TypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptorKt;
import expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt;
import expo.modules.screenorientation.enums.Orientation;
import expo.modules.screenorientation.enums.OrientationAttr;
import expo.modules.screenorientation.enums.OrientationLock;
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
import kotlin.reflect.KType;

/* JADX INFO: compiled from: ScreenOrientationModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0015H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0006H\u0002J \u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0010H\u0002R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011¨\u0006 "}, d2 = {"Lexpo/modules/screenorientation/ScreenOrientationModule;", "Lexpo/modules/kotlin/modules/Module;", "Lexpo/modules/core/interfaces/LifecycleEventListener;", "<init>", "()V", "weakCurrentActivity", "Landroid/app/Activity;", "getWeakCurrentActivity", "()Landroid/app/Activity;", "currentActivity", "getCurrentActivity", "uiManager", "Lexpo/modules/core/interfaces/services/UIManager;", "getUiManager", "()Lexpo/modules/core/interfaces/services/UIManager;", "initialOrientation", "", "Ljava/lang/Integer;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "onHostResume", "", "onHostPause", "onHostDestroy", "getScreenOrientation", "Lexpo/modules/screenorientation/enums/Orientation;", "activity", "isPortraitNaturalOrientation", "", "rotation", ViewProps.WIDTH, ViewProps.HEIGHT, "expo-screen-orientation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ScreenOrientationModule extends Module implements LifecycleEventListener {
    private Integer initialOrientation;

    private final boolean isPortraitNaturalOrientation(int rotation, int width, int height) {
        if ((rotation == 0 || rotation == 2) && height > width) {
            return true;
        }
        return (rotation == 1 || rotation == 3) && width > height;
    }

    @Override // expo.modules.core.interfaces.LifecycleEventListener
    public void onHostDestroy() {
    }

    @Override // expo.modules.core.interfaces.LifecycleEventListener
    public void onHostPause() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Activity getWeakCurrentActivity() {
        return getAppContext().getCurrentActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Activity getCurrentActivity() throws Exceptions.MissingActivity {
        Activity weakCurrentActivity = getWeakCurrentActivity();
        if (weakCurrentActivity != null) {
            return weakCurrentActivity;
        }
        throw new Exceptions.MissingActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UIManager getUiManager() {
        UIManager uIManager = (UIManager) getAppContext().getLegacyModuleRegistry().getModule(UIManager.class);
        if (uIManager != null) {
            return uIManager;
        }
        throw new IllegalStateException("Could not find implementation for UIManager.");
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        Object objM12684constructorimpl;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent;
        Object objM12684constructorimpl2;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent2;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent3;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent4;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent5;
        Object objM12684constructorimpl3;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent6;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent3;
        ScreenOrientationModule screenOrientationModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (screenOrientationModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(screenOrientationModule);
            moduleDefinitionBuilder.Name("ExpoScreenOrientation");
            moduleDefinitionBuilder.Events("expoDidUpdateDimensions");
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            Object obj = null;
            if (Intrinsics.areEqual(OrientationLock.class, Promise.class)) {
                asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("lockAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.screenorientation.ScreenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$1
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) throws InvalidOrientationLockException {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        OrientationLock orientationLock = (OrientationLock) promise;
                        try {
                            this.this$0.getCurrentActivity().setRequestedOrientation(orientationLock.toPlatformInt$expo_screen_orientation_release());
                        } catch (InvalidArgumentException e) {
                            throw new InvalidOrientationLockException(orientationLock.getValue(), e);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws InvalidOrientationLockException {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                TypeConverterProvider converters = moduleDefinitionBuilder2.getConverters();
                AnyType[] anyTypeArr = new AnyType[1];
                AnyType anyType = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(OrientationLock.class), false));
                if (anyType == null) {
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(OrientationLock.class, false, null)), new Function0<KType>() { // from class: expo.modules.screenorientation.ScreenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$2
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                return Reflection.typeOf(OrientationLock.class);
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
                        typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(OrientationLock.class));
                    }
                    anyType = new AnyType(typeDescriptor, converters);
                }
                anyTypeArr[0] = anyType;
                Function1<Object[], Unit> function1 = new Function1<Object[], Unit>() { // from class: expo.modules.screenorientation.ScreenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$3
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) throws InvalidOrientationLockException {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        OrientationLock orientationLock = (OrientationLock) objArr[0];
                        try {
                            this.this$0.getCurrentActivity().setRequestedOrientation(orientationLock.toPlatformInt$expo_screen_orientation_release());
                            return Unit.INSTANCE;
                        } catch (InvalidArgumentException e) {
                            throw new InvalidOrientationLockException(orientationLock.getValue(), e);
                        }
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    untypedAsyncFunctionComponent = new StringAsyncFunctionComponent("lockAsync", anyTypeArr, function1);
                                } else {
                                    untypedAsyncFunctionComponent = new UntypedAsyncFunctionComponent("lockAsync", anyTypeArr, function1);
                                }
                            } else {
                                untypedAsyncFunctionComponent = new FloatAsyncFunctionComponent("lockAsync", anyTypeArr, function1);
                            }
                        } else {
                            untypedAsyncFunctionComponent = new DoubleAsyncFunctionComponent("lockAsync", anyTypeArr, function1);
                        }
                    } else {
                        untypedAsyncFunctionComponent = new BoolAsyncFunctionComponent("lockAsync", anyTypeArr, function1);
                    }
                } else {
                    untypedAsyncFunctionComponent = new IntAsyncFunctionComponent("lockAsync", anyTypeArr, function1);
                }
                asyncFunctionWithPromiseComponent = untypedAsyncFunctionComponent;
            }
            moduleDefinitionBuilder2.getAsyncFunctions().put("lockAsync", asyncFunctionWithPromiseComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(OrientationAttr.class, Promise.class)) {
                asyncFunctionWithPromiseComponent2 = new AsyncFunctionWithPromiseComponent("lockPlatformAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.screenorientation.ScreenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$4
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        this.this$0.getCurrentActivity().setRequestedOrientation(((OrientationAttr) promise).getValue());
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                TypeConverterProvider converters2 = moduleDefinitionBuilder3.getConverters();
                AnyType[] anyTypeArr2 = new AnyType[1];
                AnyType anyType2 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(OrientationAttr.class), false));
                if (anyType2 == null) {
                    try {
                        Result.Companion companion3 = Result.INSTANCE;
                        objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(OrientationAttr.class, false, null)), new Function0<KType>() { // from class: expo.modules.screenorientation.ScreenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$5
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                return Reflection.typeOf(OrientationAttr.class);
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
                        typeDescriptor2 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(OrientationAttr.class));
                    }
                    anyType2 = new AnyType(typeDescriptor2, converters2);
                }
                anyTypeArr2[0] = anyType2;
                Function1<Object[], Unit> function2 = new Function1<Object[], Unit>() { // from class: expo.modules.screenorientation.ScreenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$6
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        this.this$0.getCurrentActivity().setRequestedOrientation(((OrientationAttr) objArr[0]).getValue());
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    untypedAsyncFunctionComponent2 = new StringAsyncFunctionComponent("lockPlatformAsync", anyTypeArr2, function2);
                                } else {
                                    untypedAsyncFunctionComponent2 = new UntypedAsyncFunctionComponent("lockPlatformAsync", anyTypeArr2, function2);
                                }
                            } else {
                                untypedAsyncFunctionComponent2 = new FloatAsyncFunctionComponent("lockPlatformAsync", anyTypeArr2, function2);
                            }
                        } else {
                            untypedAsyncFunctionComponent2 = new DoubleAsyncFunctionComponent("lockPlatformAsync", anyTypeArr2, function2);
                        }
                    } else {
                        untypedAsyncFunctionComponent2 = new BoolAsyncFunctionComponent("lockPlatformAsync", anyTypeArr2, function2);
                    }
                } else {
                    untypedAsyncFunctionComponent2 = new IntAsyncFunctionComponent("lockPlatformAsync", anyTypeArr2, function2);
                }
                asyncFunctionWithPromiseComponent2 = untypedAsyncFunctionComponent2;
            }
            moduleDefinitionBuilder3.getAsyncFunctions().put("lockPlatformAsync", asyncFunctionWithPromiseComponent2);
            ModuleDefinitionBuilder moduleDefinitionBuilder4 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr3 = new AnyType[0];
            Function1<Object[], Integer> function3 = new Function1<Object[], Integer>() { // from class: expo.modules.screenorientation.ScreenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$7
                @Override // kotlin.jvm.functions.Function1
                public final Integer invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ScreenOrientationModule screenOrientationModule2 = this.this$0;
                    return Integer.valueOf(screenOrientationModule2.getScreenOrientation(screenOrientationModule2.getCurrentActivity()).getValue());
                }
            };
            if (!Intrinsics.areEqual(Integer.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Integer.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Integer.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Integer.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Integer.class, String.class)) {
                                untypedAsyncFunctionComponent3 = new StringAsyncFunctionComponent("getOrientationAsync", anyTypeArr3, function3);
                            } else {
                                untypedAsyncFunctionComponent3 = new UntypedAsyncFunctionComponent("getOrientationAsync", anyTypeArr3, function3);
                            }
                        } else {
                            untypedAsyncFunctionComponent3 = new FloatAsyncFunctionComponent("getOrientationAsync", anyTypeArr3, function3);
                        }
                    } else {
                        untypedAsyncFunctionComponent3 = new DoubleAsyncFunctionComponent("getOrientationAsync", anyTypeArr3, function3);
                    }
                } else {
                    untypedAsyncFunctionComponent3 = new BoolAsyncFunctionComponent("getOrientationAsync", anyTypeArr3, function3);
                }
            } else {
                untypedAsyncFunctionComponent3 = new IntAsyncFunctionComponent("getOrientationAsync", anyTypeArr3, function3);
            }
            moduleDefinitionBuilder4.getAsyncFunctions().put("getOrientationAsync", untypedAsyncFunctionComponent3);
            ModuleDefinitionBuilder moduleDefinitionBuilder5 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr4 = new AnyType[0];
            Function1<Object[], OrientationLock> function4 = new Function1<Object[], OrientationLock>() { // from class: expo.modules.screenorientation.ScreenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$8
                @Override // kotlin.jvm.functions.Function1
                public final OrientationLock invoke(Object[] it) throws GetOrientationLockException {
                    Intrinsics.checkNotNullParameter(it, "it");
                    try {
                        return OrientationLock.INSTANCE.fromPlatformInt(this.this$0.getCurrentActivity().getRequestedOrientation());
                    } catch (Exception e) {
                        throw new GetOrientationLockException(e);
                    }
                }
            };
            if (!Intrinsics.areEqual(OrientationLock.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(OrientationLock.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(OrientationLock.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(OrientationLock.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(OrientationLock.class, String.class)) {
                                untypedAsyncFunctionComponent4 = new StringAsyncFunctionComponent("getOrientationLockAsync", anyTypeArr4, function4);
                            } else {
                                untypedAsyncFunctionComponent4 = new UntypedAsyncFunctionComponent("getOrientationLockAsync", anyTypeArr4, function4);
                            }
                        } else {
                            untypedAsyncFunctionComponent4 = new FloatAsyncFunctionComponent("getOrientationLockAsync", anyTypeArr4, function4);
                        }
                    } else {
                        untypedAsyncFunctionComponent4 = new DoubleAsyncFunctionComponent("getOrientationLockAsync", anyTypeArr4, function4);
                    }
                } else {
                    untypedAsyncFunctionComponent4 = new BoolAsyncFunctionComponent("getOrientationLockAsync", anyTypeArr4, function4);
                }
            } else {
                untypedAsyncFunctionComponent4 = new IntAsyncFunctionComponent("getOrientationLockAsync", anyTypeArr4, function4);
            }
            moduleDefinitionBuilder5.getAsyncFunctions().put("getOrientationLockAsync", untypedAsyncFunctionComponent4);
            ModuleDefinitionBuilder moduleDefinitionBuilder6 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr5 = new AnyType[0];
            Function1<Object[], Integer> function5 = new Function1<Object[], Integer>() { // from class: expo.modules.screenorientation.ScreenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$9
                @Override // kotlin.jvm.functions.Function1
                public final Integer invoke(Object[] it) throws GetPlatformOrientationLockException {
                    Intrinsics.checkNotNullParameter(it, "it");
                    try {
                        return Integer.valueOf(this.this$0.getCurrentActivity().getRequestedOrientation());
                    } catch (Exception e) {
                        throw new GetPlatformOrientationLockException(e);
                    }
                }
            };
            if (!Intrinsics.areEqual(Integer.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Integer.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Integer.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Integer.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Integer.class, String.class)) {
                                untypedAsyncFunctionComponent5 = new StringAsyncFunctionComponent("getPlatformOrientationLockAsync", anyTypeArr5, function5);
                            } else {
                                untypedAsyncFunctionComponent5 = new UntypedAsyncFunctionComponent("getPlatformOrientationLockAsync", anyTypeArr5, function5);
                            }
                        } else {
                            untypedAsyncFunctionComponent5 = new FloatAsyncFunctionComponent("getPlatformOrientationLockAsync", anyTypeArr5, function5);
                        }
                    } else {
                        untypedAsyncFunctionComponent5 = new DoubleAsyncFunctionComponent("getPlatformOrientationLockAsync", anyTypeArr5, function5);
                    }
                } else {
                    untypedAsyncFunctionComponent5 = new BoolAsyncFunctionComponent("getPlatformOrientationLockAsync", anyTypeArr5, function5);
                }
            } else {
                untypedAsyncFunctionComponent5 = new IntAsyncFunctionComponent("getPlatformOrientationLockAsync", anyTypeArr5, function5);
            }
            moduleDefinitionBuilder6.getAsyncFunctions().put("getPlatformOrientationLockAsync", untypedAsyncFunctionComponent5);
            ModuleDefinitionBuilder moduleDefinitionBuilder7 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Integer.class, Promise.class)) {
                asyncFunctionWithPromiseComponent3 = new AsyncFunctionWithPromiseComponent("supportsOrientationLockAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.screenorientation.ScreenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$10
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        OrientationLock.INSTANCE.supportsOrientationLock(((Integer) promise).intValue());
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                TypeConverterProvider converters3 = moduleDefinitionBuilder7.getConverters();
                AnyType[] anyTypeArr6 = new AnyType[1];
                AnyType anyType3 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Integer.class), false));
                if (anyType3 == null) {
                    try {
                        Result.Companion companion5 = Result.INSTANCE;
                        objM12684constructorimpl3 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.INT), new Function0<KType>() { // from class: expo.modules.screenorientation.ScreenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$11
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                return Reflection.typeOf(Integer.TYPE);
                            }
                        }));
                    } catch (Throwable th3) {
                        Result.Companion companion6 = Result.INSTANCE;
                        objM12684constructorimpl3 = Result.m12684constructorimpl(ResultKt.createFailure(th3));
                    }
                    if (!Result.m12690isFailureimpl(objM12684constructorimpl3)) {
                        obj = objM12684constructorimpl3;
                    }
                    TypeDescriptor typeDescriptor3 = (TypeDescriptor) obj;
                    if (typeDescriptor3 == null) {
                        typeDescriptor3 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Integer.TYPE));
                    }
                    anyType3 = new AnyType(typeDescriptor3, converters3);
                }
                anyTypeArr6[0] = anyType3;
                Function1<Object[], Boolean> function6 = new Function1<Object[], Boolean>() { // from class: expo.modules.screenorientation.ScreenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$12
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        return Boolean.valueOf(OrientationLock.INSTANCE.supportsOrientationLock(((Number) objArr[0]).intValue()));
                    }
                };
                if (!Intrinsics.areEqual(Boolean.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Boolean.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Boolean.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Boolean.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Boolean.class, String.class)) {
                                    untypedAsyncFunctionComponent6 = new StringAsyncFunctionComponent("supportsOrientationLockAsync", anyTypeArr6, function6);
                                } else {
                                    untypedAsyncFunctionComponent6 = new UntypedAsyncFunctionComponent("supportsOrientationLockAsync", anyTypeArr6, function6);
                                }
                            } else {
                                untypedAsyncFunctionComponent6 = new FloatAsyncFunctionComponent("supportsOrientationLockAsync", anyTypeArr6, function6);
                            }
                        } else {
                            untypedAsyncFunctionComponent6 = new DoubleAsyncFunctionComponent("supportsOrientationLockAsync", anyTypeArr6, function6);
                        }
                    } else {
                        untypedAsyncFunctionComponent6 = new BoolAsyncFunctionComponent("supportsOrientationLockAsync", anyTypeArr6, function6);
                    }
                } else {
                    untypedAsyncFunctionComponent6 = new IntAsyncFunctionComponent("supportsOrientationLockAsync", anyTypeArr6, function6);
                }
                asyncFunctionWithPromiseComponent3 = untypedAsyncFunctionComponent6;
            }
            moduleDefinitionBuilder7.getAsyncFunctions().put("supportsOrientationLockAsync", asyncFunctionWithPromiseComponent3);
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_CREATE, new BasicEventListener(EventName.MODULE_CREATE, new Function0<Unit>() { // from class: expo.modules.screenorientation.ScreenOrientationModule$definition$lambda$9$$inlined$OnCreate$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    this.this$0.getUiManager().registerLifecycleEventListener(this.this$0);
                }
            }));
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_DESTROY, new BasicEventListener(EventName.MODULE_DESTROY, new Function0<Unit>() { // from class: expo.modules.screenorientation.ScreenOrientationModule$definition$lambda$9$$inlined$OnDestroy$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    this.this$0.getUiManager().unregisterLifecycleEventListener(this.this$0);
                    Integer num = this.this$0.initialOrientation;
                    if (num != null) {
                        int iIntValue = num.intValue();
                        Activity weakCurrentActivity = this.this$0.getWeakCurrentActivity();
                        if (weakCurrentActivity != null) {
                            weakCurrentActivity.setRequestedOrientation(iIntValue);
                        }
                    }
                }
            }));
            ModuleDefinitionData moduleDefinitionDataBuildModule = moduleDefinitionBuilder.buildModule();
            Trace.endSection();
            return moduleDefinitionDataBuildModule;
        } catch (Throwable th4) {
            Trace.endSection();
            throw th4;
        }
    }

    @Override // expo.modules.core.interfaces.LifecycleEventListener
    public void onHostResume() {
        Integer numValueOf = this.initialOrientation;
        if (numValueOf == null) {
            Activity weakCurrentActivity = getWeakCurrentActivity();
            numValueOf = weakCurrentActivity != null ? Integer.valueOf(weakCurrentActivity.getRequestedOrientation()) : null;
        }
        this.initialOrientation = numValueOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Orientation getScreenOrientation(Activity activity) {
        int rotation;
        DisplayMetrics displayMetrics;
        WindowManager windowManager = activity.getWindowManager();
        if (windowManager == null) {
            return Orientation.UNKNOWN;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            Display display = getCurrentActivity().getWindow().getContext().getDisplay();
            if (display == null) {
                return Orientation.UNKNOWN;
            }
            rotation = display.getRotation();
        } else {
            rotation = windowManager.getDefaultDisplay().getRotation();
        }
        if (Build.VERSION.SDK_INT >= 30) {
            WindowMetrics currentWindowMetrics = windowManager.getCurrentWindowMetrics();
            Intrinsics.checkNotNullExpressionValue(currentWindowMetrics, "getCurrentWindowMetrics(...)");
            Insets insetsIgnoringVisibility = currentWindowMetrics.getWindowInsets().getInsetsIgnoringVisibility(WindowInsets.Type.systemBars());
            Intrinsics.checkNotNullExpressionValue(insetsIgnoringVisibility, "getInsetsIgnoringVisibility(...)");
            displayMetrics = new DisplayMetrics();
            displayMetrics.widthPixels = (currentWindowMetrics.getBounds().width() - insetsIgnoringVisibility.left) - insetsIgnoringVisibility.right;
            displayMetrics.heightPixels = (currentWindowMetrics.getBounds().height() - insetsIgnoringVisibility.top) - insetsIgnoringVisibility.bottom;
        } else {
            displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        if (isPortraitNaturalOrientation(rotation, displayMetrics.widthPixels, displayMetrics.heightPixels)) {
            if (rotation == 0) {
                return Orientation.PORTRAIT_UP;
            }
            if (rotation == 1) {
                return Orientation.LANDSCAPE_RIGHT;
            }
            if (rotation == 2) {
                return Orientation.PORTRAIT_DOWN;
            }
            if (rotation == 3) {
                return Orientation.LANDSCAPE_LEFT;
            }
            return Orientation.UNKNOWN;
        }
        if (rotation == 0) {
            return Orientation.LANDSCAPE_RIGHT;
        }
        if (rotation == 1) {
            return Orientation.PORTRAIT_DOWN;
        }
        if (rotation == 2) {
            return Orientation.LANDSCAPE_LEFT;
        }
        if (rotation == 3) {
            return Orientation.PORTRAIT_UP;
        }
        return Orientation.UNKNOWN;
    }
}
