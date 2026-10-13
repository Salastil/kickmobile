package expo.modules.navigationbar;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.tracing.Trace;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.interfaces.ExtraWindowEventListener;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.Queues;
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
import io.github.expo.pika.PTypeDescriptorRegistry;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
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

/* JADX INFO: compiled from: NavigationBarModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u0019B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\r\u0010\u000f¨\u0006\u001a"}, d2 = {"Lexpo/modules/navigationbar/NavigationBarModule;", "Lexpo/modules/kotlin/modules/Module;", "Lcom/facebook/react/interfaces/ExtraWindowEventListener;", "<init>", "()V", "currentActivity", "Landroid/app/Activity;", "getCurrentActivity", "()Landroid/app/Activity;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "getReactContext", "()Lcom/facebook/react/bridge/ReactApplicationContext;", "isContrastEnforced", "", "()Z", "isContrastEnforced$delegate", "Lkotlin/Lazy;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "onExtraWindowCreate", "", "window", "Landroid/view/Window;", "onExtraWindowDestroy", "Companion", "expo-navigation-bar_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NavigationBarModule extends Module implements ExtraWindowEventListener {
    private static final String VISIBILITY_EVENT_NAME = "ExpoNavigationBar.didChange";

    /* JADX INFO: renamed from: isContrastEnforced$delegate, reason: from kotlin metadata */
    private final Lazy isContrastEnforced = LazyKt.lazy(new Function0() { // from class: expo.modules.navigationbar.NavigationBarModule$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Boolean.valueOf(NavigationBarModule.isContrastEnforced_delegate$lambda$0(this.f$0));
        }
    });
    private static final Set<Window> extraWindows = Collections.newSetFromMap(new WeakHashMap());

    /* JADX INFO: Access modifiers changed from: private */
    public final Activity getCurrentActivity() {
        return getAppContext().getThrowingActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReactApplicationContext getReactContext() {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext instanceof ReactApplicationContext) {
            return (ReactApplicationContext) reactContext;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isContrastEnforced() {
        return ((Boolean) this.isContrastEnforced.getValue()).booleanValue();
    }

    static final boolean isContrastEnforced_delegate$lambda$0(NavigationBarModule navigationBarModule) {
        Resources.Theme theme = navigationBarModule.getCurrentActivity().getTheme();
        TypedValue typedValue = new TypedValue();
        return (theme.resolveAttribute(Build.VERSION.SDK_INT < 29 ? R.attr.expoEnforceNavigationBarContrast : android.R.attr.enforceNavigationBarContrast, typedValue, true) && typedValue.data == 0) ? false : true;
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
        NavigationBarModule navigationBarModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (navigationBarModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(navigationBarModule);
            moduleDefinitionBuilder.Name("ExpoNavigationBar");
            moduleDefinitionBuilder.Events(VISIBILITY_EVENT_NAME);
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_CREATE, new BasicEventListener(EventName.MODULE_CREATE, new Function0<Unit>() { // from class: expo.modules.navigationbar.NavigationBarModule$definition$lambda$8$$inlined$OnCreate$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ReactApplicationContext reactContext = this.this$0.getReactContext();
                    if (reactContext != null) {
                        reactContext.addExtraWindowEventListener(this.this$0);
                    }
                }
            }));
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_DESTROY, new BasicEventListener(EventName.MODULE_DESTROY, new Function0<Unit>() { // from class: expo.modules.navigationbar.NavigationBarModule$definition$lambda$8$$inlined$OnDestroy$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ReactApplicationContext reactContext = this.this$0.getReactContext();
                    if (reactContext != null) {
                        reactContext.removeExtraWindowEventListener(this.this$0);
                    }
                }
            }));
            moduleDefinitionBuilder.OnStartObserving(new Function0<Unit>() { // from class: expo.modules.navigationbar.NavigationBarModule$definition$1$3
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    final View decorView = this.this$0.getCurrentActivity().getWindow().getDecorView();
                    Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
                    final NavigationBarModule navigationBarModule2 = this.this$0;
                    decorView.post(new Runnable() { // from class: expo.modules.navigationbar.NavigationBarModule$definition$1$3.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            View view = decorView;
                            final NavigationBarModule navigationBarModule3 = navigationBarModule2;
                            view.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: expo.modules.navigationbar.NavigationBarModule.definition.1.3.1.1
                                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                                public final void onSystemUiVisibilityChange(int i) {
                                    String str;
                                    if ((i & 2) == 0) {
                                        str = ViewProps.VISIBLE;
                                    } else {
                                        str = ViewProps.HIDDEN;
                                    }
                                    NavigationBarModule navigationBarModule4 = navigationBarModule3;
                                    Bundle bundle = new Bundle();
                                    bundle.putString("visibility", str);
                                    bundle.putInt("rawVisibility", i);
                                    Unit unit = Unit.INSTANCE;
                                    navigationBarModule4.sendEvent("ExpoNavigationBar.didChange", bundle);
                                }
                            });
                        }
                    });
                }
            });
            moduleDefinitionBuilder.OnStopObserving(new Function0<Unit>() { // from class: expo.modules.navigationbar.NavigationBarModule$definition$1$4
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    final View decorView = this.this$0.getCurrentActivity().getWindow().getDecorView();
                    Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
                    decorView.post(new Runnable() { // from class: expo.modules.navigationbar.NavigationBarModule$definition$1$4.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            decorView.setOnSystemUiVisibilityChangeListener(null);
                        }
                    });
                }
            });
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            Object obj = null;
            if (Intrinsics.areEqual(String.class, Promise.class)) {
                asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("setStyle", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.navigationbar.NavigationBarModule$definition$lambda$8$$inlined$AsyncFunction$1
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        boolean zAreEqual = Intrinsics.areEqual((String) promise, "dark");
                        Window window = this.this$0.getCurrentActivity().getWindow();
                        Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
                        NavigationBarModuleKt.setNavigationBarStyle(window, zAreEqual, this.this$0.isContrastEnforced());
                        Set<Window> set = NavigationBarModule.extraWindows;
                        Intrinsics.checkNotNullExpressionValue(set, "access$getExtraWindows$cp(...)");
                        for (Window window2 : set) {
                            Intrinsics.checkNotNull(window2);
                            NavigationBarModuleKt.setNavigationBarStyle(window2, zAreEqual, this.this$0.isContrastEnforced());
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                TypeConverterProvider converters = moduleDefinitionBuilder2.getConverters();
                AnyType[] anyTypeArr = new AnyType[1];
                AnyType anyType = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
                if (anyType == null) {
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.navigationbar.NavigationBarModule$definition$lambda$8$$inlined$AsyncFunction$2
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                return Reflection.typeOf(String.class);
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
                        typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                    }
                    anyType = new AnyType(typeDescriptor, converters);
                }
                anyTypeArr[0] = anyType;
                Function1<Object[], Unit> function1 = new Function1<Object[], Unit>() { // from class: expo.modules.navigationbar.NavigationBarModule$definition$lambda$8$$inlined$AsyncFunction$3
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        boolean zAreEqual = Intrinsics.areEqual((String) objArr[0], "dark");
                        Window window = this.this$0.getCurrentActivity().getWindow();
                        Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
                        NavigationBarModuleKt.setNavigationBarStyle(window, zAreEqual, this.this$0.isContrastEnforced());
                        Set<Window> set = NavigationBarModule.extraWindows;
                        Intrinsics.checkNotNullExpressionValue(set, "access$getExtraWindows$cp(...)");
                        for (Window window2 : set) {
                            Intrinsics.checkNotNull(window2);
                            NavigationBarModuleKt.setNavigationBarStyle(window2, zAreEqual, this.this$0.isContrastEnforced());
                        }
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    untypedAsyncFunctionComponent = new StringAsyncFunctionComponent("setStyle", anyTypeArr, function1);
                                } else {
                                    untypedAsyncFunctionComponent = new UntypedAsyncFunctionComponent("setStyle", anyTypeArr, function1);
                                }
                            } else {
                                untypedAsyncFunctionComponent = new FloatAsyncFunctionComponent("setStyle", anyTypeArr, function1);
                            }
                        } else {
                            untypedAsyncFunctionComponent = new DoubleAsyncFunctionComponent("setStyle", anyTypeArr, function1);
                        }
                    } else {
                        untypedAsyncFunctionComponent = new BoolAsyncFunctionComponent("setStyle", anyTypeArr, function1);
                    }
                } else {
                    untypedAsyncFunctionComponent = new IntAsyncFunctionComponent("setStyle", anyTypeArr, function1);
                }
                asyncFunctionWithPromiseComponent = untypedAsyncFunctionComponent;
            }
            moduleDefinitionBuilder2.getAsyncFunctions().put("setStyle", asyncFunctionWithPromiseComponent);
            asyncFunctionWithPromiseComponent.runOnQueue(Queues.MAIN);
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Boolean.class, Promise.class)) {
                asyncFunctionWithPromiseComponent2 = new AsyncFunctionWithPromiseComponent("setHidden", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.navigationbar.NavigationBarModule$definition$lambda$8$$inlined$AsyncFunction$4
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        boolean zBooleanValue = ((Boolean) promise).booleanValue();
                        Window window = this.this$0.getCurrentActivity().getWindow();
                        Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
                        NavigationBarModuleKt.setNavigationBarHidden(window, zBooleanValue);
                        Set<Window> set = NavigationBarModule.extraWindows;
                        Intrinsics.checkNotNullExpressionValue(set, "access$getExtraWindows$cp(...)");
                        for (Window window2 : set) {
                            Intrinsics.checkNotNull(window2);
                            NavigationBarModuleKt.setNavigationBarHidden(window2, zBooleanValue);
                        }
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
                AnyType anyType2 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Boolean.class), false));
                if (anyType2 == null) {
                    try {
                        Result.Companion companion3 = Result.INSTANCE;
                        objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.BOOLEAN), new Function0<KType>() { // from class: expo.modules.navigationbar.NavigationBarModule$definition$lambda$8$$inlined$AsyncFunction$5
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                return Reflection.typeOf(Boolean.TYPE);
                            }
                        }));
                    } catch (Throwable th2) {
                        Result.Companion companion4 = Result.INSTANCE;
                        objM12684constructorimpl2 = Result.m12684constructorimpl(ResultKt.createFailure(th2));
                    }
                    if (!Result.m12690isFailureimpl(objM12684constructorimpl2)) {
                        obj = objM12684constructorimpl2;
                    }
                    TypeDescriptor typeDescriptor2 = (TypeDescriptor) obj;
                    if (typeDescriptor2 == null) {
                        typeDescriptor2 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Boolean.TYPE));
                    }
                    anyType2 = new AnyType(typeDescriptor2, converters2);
                }
                anyTypeArr2[0] = anyType2;
                Function1<Object[], Unit> function2 = new Function1<Object[], Unit>() { // from class: expo.modules.navigationbar.NavigationBarModule$definition$lambda$8$$inlined$AsyncFunction$6
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        boolean zBooleanValue = ((Boolean) objArr[0]).booleanValue();
                        Window window = this.this$0.getCurrentActivity().getWindow();
                        Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
                        NavigationBarModuleKt.setNavigationBarHidden(window, zBooleanValue);
                        Set<Window> set = NavigationBarModule.extraWindows;
                        Intrinsics.checkNotNullExpressionValue(set, "access$getExtraWindows$cp(...)");
                        for (Window window2 : set) {
                            Intrinsics.checkNotNull(window2);
                            NavigationBarModuleKt.setNavigationBarHidden(window2, zBooleanValue);
                        }
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    untypedAsyncFunctionComponent2 = new StringAsyncFunctionComponent("setHidden", anyTypeArr2, function2);
                                } else {
                                    untypedAsyncFunctionComponent2 = new UntypedAsyncFunctionComponent("setHidden", anyTypeArr2, function2);
                                }
                            } else {
                                untypedAsyncFunctionComponent2 = new FloatAsyncFunctionComponent("setHidden", anyTypeArr2, function2);
                            }
                        } else {
                            untypedAsyncFunctionComponent2 = new DoubleAsyncFunctionComponent("setHidden", anyTypeArr2, function2);
                        }
                    } else {
                        untypedAsyncFunctionComponent2 = new BoolAsyncFunctionComponent("setHidden", anyTypeArr2, function2);
                    }
                } else {
                    untypedAsyncFunctionComponent2 = new IntAsyncFunctionComponent("setHidden", anyTypeArr2, function2);
                }
                asyncFunctionWithPromiseComponent2 = untypedAsyncFunctionComponent2;
            }
            moduleDefinitionBuilder3.getAsyncFunctions().put("setHidden", asyncFunctionWithPromiseComponent2);
            asyncFunctionWithPromiseComponent2.runOnQueue(Queues.MAIN);
            ModuleDefinitionBuilder moduleDefinitionBuilder4 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr3 = new AnyType[0];
            Function1<Object[], String> function3 = new Function1<Object[], String>() { // from class: expo.modules.navigationbar.NavigationBarModule$definition$lambda$8$$inlined$AsyncFunction$7
                @Override // kotlin.jvm.functions.Function1
                public final String invoke(Object[] it) {
                    boolean zIsVisible;
                    Intrinsics.checkNotNullParameter(it, "it");
                    int i = Build.VERSION.SDK_INT;
                    NavigationBarModule navigationBarModule2 = this.this$0;
                    if (i >= 30) {
                        zIsVisible = navigationBarModule2.getCurrentActivity().getWindow().getDecorView().getRootWindowInsets().isVisible(WindowInsets.Type.navigationBars());
                    } else {
                        zIsVisible = (navigationBarModule2.getCurrentActivity().getWindow().getDecorView().getSystemUiVisibility() & 2) == 0;
                    }
                    if (zIsVisible) {
                        return ViewProps.VISIBLE;
                    }
                    return ViewProps.HIDDEN;
                }
            };
            if (!Intrinsics.areEqual(String.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(String.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(String.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(String.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(String.class, String.class)) {
                                untypedAsyncFunctionComponent3 = new StringAsyncFunctionComponent("getVisibilityAsync", anyTypeArr3, function3);
                            } else {
                                untypedAsyncFunctionComponent3 = new UntypedAsyncFunctionComponent("getVisibilityAsync", anyTypeArr3, function3);
                            }
                        } else {
                            untypedAsyncFunctionComponent3 = new FloatAsyncFunctionComponent("getVisibilityAsync", anyTypeArr3, function3);
                        }
                    } else {
                        untypedAsyncFunctionComponent3 = new DoubleAsyncFunctionComponent("getVisibilityAsync", anyTypeArr3, function3);
                    }
                } else {
                    untypedAsyncFunctionComponent3 = new BoolAsyncFunctionComponent("getVisibilityAsync", anyTypeArr3, function3);
                }
            } else {
                untypedAsyncFunctionComponent3 = new IntAsyncFunctionComponent("getVisibilityAsync", anyTypeArr3, function3);
            }
            moduleDefinitionBuilder4.getAsyncFunctions().put("getVisibilityAsync", untypedAsyncFunctionComponent3);
            untypedAsyncFunctionComponent3.runOnQueue(Queues.MAIN);
            ModuleDefinitionData moduleDefinitionDataBuildModule = moduleDefinitionBuilder.buildModule();
            Trace.endSection();
            return moduleDefinitionDataBuildModule;
        } catch (Throwable th3) {
            Trace.endSection();
            throw th3;
        }
    }

    @Override // com.facebook.react.interfaces.ExtraWindowEventListener
    public void onExtraWindowCreate(Window window) {
        Intrinsics.checkNotNullParameter(window, "window");
        extraWindows.add(window);
        Window window2 = getCurrentActivity().getWindow();
        WindowInsetsControllerCompat insetsController = WindowCompat.getInsetsController(window2, window2.getDecorView());
        Intrinsics.checkNotNullExpressionValue(insetsController, "getInsetsController(...)");
        WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(window2.getDecorView());
        boolean zIsAppearanceLightNavigationBars = insetsController.isAppearanceLightNavigationBars();
        boolean zIsVisible = rootWindowInsets != null ? rootWindowInsets.isVisible(WindowInsetsCompat.Type.navigationBars()) : true;
        NavigationBarModuleKt.setNavigationBarStyle(window, zIsAppearanceLightNavigationBars, isContrastEnforced());
        NavigationBarModuleKt.setNavigationBarHidden(window, !zIsVisible);
    }

    @Override // com.facebook.react.interfaces.ExtraWindowEventListener
    public void onExtraWindowDestroy(Window window) {
        Intrinsics.checkNotNullParameter(window, "window");
        extraWindows.remove(window);
    }
}
