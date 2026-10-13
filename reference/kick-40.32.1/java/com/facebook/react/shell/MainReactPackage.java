package com.facebook.react.shell;

import com.facebook.react.BaseReactPackage;
import com.facebook.react.ViewManagerOnDemandReactPackage;
import com.facebook.react.animated.NativeAnimatedModule;
import com.facebook.react.bridge.ModuleSpec;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.common.ClassFinder;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.modules.accessibilityinfo.AccessibilityInfoModule;
import com.facebook.react.modules.appearance.AppearanceModule;
import com.facebook.react.modules.appstate.AppStateModule;
import com.facebook.react.modules.blob.BlobModule;
import com.facebook.react.modules.blob.FileReaderModule;
import com.facebook.react.modules.camera.ImageStoreManager;
import com.facebook.react.modules.clipboard.ClipboardModule;
import com.facebook.react.modules.devloading.DevLoadingModule;
import com.facebook.react.modules.devtoolsruntimesettings.ReactDevToolsRuntimeSettingsModule;
import com.facebook.react.modules.dialog.DialogModule;
import com.facebook.react.modules.fresco.FrescoModule;
import com.facebook.react.modules.i18nmanager.I18nManagerModule;
import com.facebook.react.modules.image.ImageLoaderModule;
import com.facebook.react.modules.intent.IntentModule;
import com.facebook.react.modules.network.NetworkingModule;
import com.facebook.react.modules.permissions.PermissionsModule;
import com.facebook.react.modules.reactdevtoolssettings.ReactDevToolsSettingsManagerModule;
import com.facebook.react.modules.share.ShareModule;
import com.facebook.react.modules.sound.SoundManagerModule;
import com.facebook.react.modules.statusbar.StatusBarModule;
import com.facebook.react.modules.toast.ToastModule;
import com.facebook.react.modules.vibration.VibrationModule;
import com.facebook.react.modules.websocket.WebSocketModule;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.views.drawer.ReactDrawerLayoutManager;
import com.facebook.react.views.image.ReactImageManager;
import com.facebook.react.views.modal.ReactModalHostManager;
import com.facebook.react.views.progressbar.ReactProgressBarViewManager;
import com.facebook.react.views.safeareaview.ReactSafeAreaViewManager;
import com.facebook.react.views.scroll.FpsListener;
import com.facebook.react.views.scroll.ReactHorizontalScrollContainerViewManager;
import com.facebook.react.views.scroll.ReactHorizontalScrollViewManager;
import com.facebook.react.views.scroll.ReactNestedScrollViewManager;
import com.facebook.react.views.scroll.ReactScrollViewManager;
import com.facebook.react.views.swiperefresh.SwipeRefreshLayoutManager;
import com.facebook.react.views.switchview.ReactSwitchManager;
import com.facebook.react.views.text.PreparedLayoutTextViewManager;
import com.facebook.react.views.text.ReactTextViewManager;
import com.facebook.react.views.text.ReactTextViewManagerCallback;
import com.facebook.react.views.text.SelectableTextViewManager;
import com.facebook.react.views.textinput.ReactTextInputManager;
import com.facebook.react.views.unimplementedview.ReactUnimplementedViewManager;
import com.facebook.react.views.view.ReactViewManager;
import com.facebook.react.views.virtual.view.ReactVirtualViewManager;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: MainReactPackage.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\b\u0007\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001e\u0010\r\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000f0\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\u0006\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\u001a\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\nH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00120\u00118\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001f"}, d2 = {"Lcom/facebook/react/shell/MainReactPackage;", "Lcom/facebook/react/BaseReactPackage;", "Lcom/facebook/react/ViewManagerOnDemandReactPackage;", "config", "Lcom/facebook/react/shell/MainPackageConfig;", "<init>", "(Lcom/facebook/react/shell/MainPackageConfig;)V", "getModule", "Lcom/facebook/react/bridge/NativeModule;", "name", "", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "createViewManagers", "", "Lcom/facebook/react/uimanager/ViewManager;", "viewManagersMap", "", "Lcom/facebook/react/bridge/ModuleSpec;", "getViewManagersMap$annotations", "()V", "getViewManagersMap", "()Ljava/util/Map;", "getViewManagers", "getViewManagerNames", "", "createViewManager", "viewManagerName", "getReactModuleInfoProvider", "Lcom/facebook/react/module/model/ReactModuleInfoProvider;", "fallbackForMissingClass", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MainReactPackage extends BaseReactPackage implements ViewManagerOnDemandReactPackage {
    private final MainPackageConfig config;
    private final Map<String, ModuleSpec> viewManagersMap;

    /* JADX WARN: Multi-variable type inference failed */
    public MainReactPackage() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    static final Map fallbackForMissingClass$lambda$18(Map map) {
        return map;
    }

    public static /* synthetic */ void getViewManagersMap$annotations() {
    }

    public /* synthetic */ MainReactPackage(MainPackageConfig mainPackageConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : mainPackageConfig);
    }

    public MainReactPackage(MainPackageConfig mainPackageConfig) {
        this.config = mainPackageConfig;
        this.viewManagersMap = MapsKt.mapOf(TuplesKt.to(ReactDrawerLayoutManager.REACT_CLASS, ModuleSpec.INSTANCE.viewManagerSpec(new Provider() { // from class: com.facebook.react.shell.MainReactPackage$$ExternalSyntheticLambda8
            @Override // javax.inject.Provider, jakarta.inject.Provider
            public final Object get() {
                return MainReactPackage.viewManagersMap$lambda$0();
            }
        })), TuplesKt.to(ReactHorizontalScrollViewManager.REACT_CLASS, ModuleSpec.INSTANCE.viewManagerSpec(new Provider() { // from class: com.facebook.react.shell.MainReactPackage$$ExternalSyntheticLambda15
            @Override // javax.inject.Provider, jakarta.inject.Provider
            public final Object get() {
                return MainReactPackage.viewManagersMap$lambda$1();
            }
        })), TuplesKt.to(ReactHorizontalScrollContainerViewManager.REACT_CLASS, ModuleSpec.INSTANCE.viewManagerSpec(new Provider() { // from class: com.facebook.react.shell.MainReactPackage$$ExternalSyntheticLambda16
            @Override // javax.inject.Provider, jakarta.inject.Provider
            public final Object get() {
                return MainReactPackage.viewManagersMap$lambda$2();
            }
        })), TuplesKt.to(ReactProgressBarViewManager.REACT_CLASS, ModuleSpec.INSTANCE.viewManagerSpec(new Provider() { // from class: com.facebook.react.shell.MainReactPackage$$ExternalSyntheticLambda1
            @Override // javax.inject.Provider, jakarta.inject.Provider
            public final Object get() {
                return MainReactPackage.viewManagersMap$lambda$3();
            }
        })), TuplesKt.to(ReactSafeAreaViewManager.REACT_CLASS, ModuleSpec.INSTANCE.viewManagerSpec(new Provider() { // from class: com.facebook.react.shell.MainReactPackage$$ExternalSyntheticLambda2
            @Override // javax.inject.Provider, jakarta.inject.Provider
            public final Object get() {
                return MainReactPackage.viewManagersMap$lambda$4();
            }
        })), TuplesKt.to("RCTScrollView", ModuleSpec.INSTANCE.viewManagerSpec(new Provider() { // from class: com.facebook.react.shell.MainReactPackage$$ExternalSyntheticLambda3
            @Override // javax.inject.Provider, jakarta.inject.Provider
            public final Object get() {
                return MainReactPackage.viewManagersMap$lambda$5();
            }
        })), TuplesKt.to(ReactSwitchManager.REACT_CLASS, ModuleSpec.INSTANCE.viewManagerSpec(new Provider() { // from class: com.facebook.react.shell.MainReactPackage$$ExternalSyntheticLambda4
            @Override // javax.inject.Provider, jakarta.inject.Provider
            public final Object get() {
                return MainReactPackage.viewManagersMap$lambda$6();
            }
        })), TuplesKt.to(SwipeRefreshLayoutManager.REACT_CLASS, ModuleSpec.INSTANCE.viewManagerSpec(new Provider() { // from class: com.facebook.react.shell.MainReactPackage$$ExternalSyntheticLambda5
            @Override // javax.inject.Provider, jakarta.inject.Provider
            public final Object get() {
                return MainReactPackage.viewManagersMap$lambda$7();
            }
        })), TuplesKt.to(ReactImageManager.REACT_CLASS, ModuleSpec.INSTANCE.viewManagerSpec(new Provider() { // from class: com.facebook.react.shell.MainReactPackage$$ExternalSyntheticLambda6
            @Override // javax.inject.Provider, jakarta.inject.Provider
            public final Object get() {
                return MainReactPackage.viewManagersMap$lambda$8();
            }
        })), TuplesKt.to(ReactModalHostManager.REACT_CLASS, ModuleSpec.INSTANCE.viewManagerSpec(new Provider() { // from class: com.facebook.react.shell.MainReactPackage$$ExternalSyntheticLambda7
            @Override // javax.inject.Provider, jakarta.inject.Provider
            public final Object get() {
                return MainReactPackage.viewManagersMap$lambda$9();
            }
        })), TuplesKt.to(ReactTextInputManager.REACT_CLASS, ModuleSpec.INSTANCE.viewManagerSpec(new Provider() { // from class: com.facebook.react.shell.MainReactPackage$$ExternalSyntheticLambda9
            @Override // javax.inject.Provider, jakarta.inject.Provider
            public final Object get() {
                return MainReactPackage.viewManagersMap$lambda$10();
            }
        })), TuplesKt.to("RCTText", ModuleSpec.INSTANCE.viewManagerSpec(new Provider() { // from class: com.facebook.react.shell.MainReactPackage$$ExternalSyntheticLambda10
            @Override // javax.inject.Provider, jakarta.inject.Provider
            public final Object get() {
                return MainReactPackage.viewManagersMap$lambda$11();
            }
        })), TuplesKt.to(SelectableTextViewManager.REACT_CLASS, ModuleSpec.INSTANCE.viewManagerSpec(new Provider() { // from class: com.facebook.react.shell.MainReactPackage$$ExternalSyntheticLambda11
            @Override // javax.inject.Provider, jakarta.inject.Provider
            public final Object get() {
                return MainReactPackage.viewManagersMap$lambda$12();
            }
        })), TuplesKt.to("RCTView", ModuleSpec.INSTANCE.viewManagerSpec(new Provider() { // from class: com.facebook.react.shell.MainReactPackage$$ExternalSyntheticLambda12
            @Override // javax.inject.Provider, jakarta.inject.Provider
            public final Object get() {
                return MainReactPackage.viewManagersMap$lambda$13();
            }
        })), TuplesKt.to(ReactVirtualViewManager.REACT_CLASS, ModuleSpec.INSTANCE.viewManagerSpec(new Provider() { // from class: com.facebook.react.shell.MainReactPackage$$ExternalSyntheticLambda13
            @Override // javax.inject.Provider, jakarta.inject.Provider
            public final Object get() {
                return MainReactPackage.viewManagersMap$lambda$14();
            }
        })), TuplesKt.to(ReactUnimplementedViewManager.REACT_CLASS, ModuleSpec.INSTANCE.viewManagerSpec(new Provider() { // from class: com.facebook.react.shell.MainReactPackage$$ExternalSyntheticLambda14
            @Override // javax.inject.Provider, jakarta.inject.Provider
            public final Object get() {
                return MainReactPackage.viewManagersMap$lambda$15();
            }
        })));
    }

    @Override // com.facebook.react.BaseReactPackage, com.facebook.react.ReactPackage
    public NativeModule getModule(String name, ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        if (Intrinsics.areEqual(name, "AccessibilityInfo")) {
            return new AccessibilityInfoModule(reactContext);
        }
        if (Intrinsics.areEqual(name, "Appearance")) {
            return new AppearanceModule(reactContext, null, 2, null);
        }
        if (Intrinsics.areEqual(name, "AppState")) {
            return new AppStateModule(reactContext);
        }
        if (Intrinsics.areEqual(name, "BlobModule")) {
            return new BlobModule(reactContext);
        }
        if (Intrinsics.areEqual(name, "DevLoadingView")) {
            return new DevLoadingModule(reactContext);
        }
        if (Intrinsics.areEqual(name, FileReaderModule.INSTANCE.getNAME())) {
            return new FileReaderModule(reactContext);
        }
        if (Intrinsics.areEqual(name, "Clipboard")) {
            return new ClipboardModule(reactContext);
        }
        if (Intrinsics.areEqual(name, "DialogManagerAndroid")) {
            return new DialogModule(reactContext);
        }
        if (Intrinsics.areEqual(name, FrescoModule.NAME)) {
            MainPackageConfig mainPackageConfig = this.config;
            return new FrescoModule(reactContext, true, mainPackageConfig != null ? mainPackageConfig.getFrescoConfig() : null);
        }
        if (Intrinsics.areEqual(name, "I18nManager")) {
            return new I18nManagerModule(reactContext);
        }
        if (Intrinsics.areEqual(name, "ImageLoader")) {
            return new ImageLoaderModule(reactContext);
        }
        if (Intrinsics.areEqual(name, "ImageStoreManager")) {
            return new ImageStoreManager(reactContext);
        }
        if (Intrinsics.areEqual(name, "IntentAndroid")) {
            return new IntentModule(reactContext);
        }
        if (Intrinsics.areEqual(name, "NativeAnimatedModule")) {
            return ReactNativeFeatureFlags.cxxNativeAnimatedEnabled() ? null : new NativeAnimatedModule(reactContext);
        }
        if (Intrinsics.areEqual(name, "Networking")) {
            return new NetworkingModule(reactContext);
        }
        if (Intrinsics.areEqual(name, "PermissionsAndroid")) {
            return new PermissionsModule(reactContext);
        }
        if (Intrinsics.areEqual(name, "ShareModule")) {
            return new ShareModule(reactContext);
        }
        if (Intrinsics.areEqual(name, "StatusBarManager")) {
            return new StatusBarModule(reactContext);
        }
        if (Intrinsics.areEqual(name, "SoundManager")) {
            return new SoundManagerModule(reactContext);
        }
        if (Intrinsics.areEqual(name, "ToastAndroid")) {
            return new ToastModule(reactContext);
        }
        if (Intrinsics.areEqual(name, "Vibration")) {
            return new VibrationModule(reactContext);
        }
        if (Intrinsics.areEqual(name, "WebSocketModule")) {
            return new WebSocketModule(reactContext);
        }
        if (Intrinsics.areEqual(name, "ReactDevToolsSettingsManager")) {
            return new ReactDevToolsSettingsManagerModule(reactContext);
        }
        if (Intrinsics.areEqual(name, "ReactDevToolsRuntimeSettingsModule")) {
            return new ReactDevToolsRuntimeSettingsModule(reactContext);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.react.BaseReactPackage, com.facebook.react.ReactPackage
    public List<ViewManager<?, ?>> createViewManagers(ReactApplicationContext reactContext) {
        BaseViewManager reactScrollViewManager;
        BaseViewManager reactTextViewManager;
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        BaseViewManager[] baseViewManagerArr = new BaseViewManager[16];
        baseViewManagerArr[0] = new ReactDrawerLayoutManager();
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object[] objArr5 = 0;
        Object[] objArr6 = 0;
        int i = 1;
        baseViewManagerArr[1] = new ReactHorizontalScrollViewManager(null, i, 0 == true ? 1 : 0);
        baseViewManagerArr[2] = new ReactHorizontalScrollContainerViewManager();
        baseViewManagerArr[3] = new ReactProgressBarViewManager();
        if (ReactNativeFeatureFlags.useNestedScrollViewAndroid()) {
            reactScrollViewManager = new ReactNestedScrollViewManager(objArr6 == true ? 1 : 0, i, objArr5 == true ? 1 : 0);
        } else {
            reactScrollViewManager = new ReactScrollViewManager(objArr2 == true ? 1 : 0, i, objArr == true ? 1 : 0);
        }
        baseViewManagerArr[4] = reactScrollViewManager;
        baseViewManagerArr[5] = new ReactSwitchManager();
        baseViewManagerArr[6] = new ReactSafeAreaViewManager();
        baseViewManagerArr[7] = new SwipeRefreshLayoutManager();
        baseViewManagerArr[8] = new ReactImageManager(null, null, null, 7, null);
        baseViewManagerArr[9] = new ReactModalHostManager();
        baseViewManagerArr[10] = new ReactTextInputManager();
        if (ReactNativeFeatureFlags.enablePreparedTextLayout()) {
            reactTextViewManager = new PreparedLayoutTextViewManager(objArr4 == true ? 1 : 0, i, objArr3 == true ? 1 : 0);
        } else {
            reactTextViewManager = new ReactTextViewManager(null, 1, null);
        }
        baseViewManagerArr[11] = reactTextViewManager;
        baseViewManagerArr[12] = new SelectableTextViewManager(null, 1, null);
        baseViewManagerArr[13] = new ReactViewManager();
        baseViewManagerArr[14] = new ReactVirtualViewManager();
        baseViewManagerArr[15] = new ReactUnimplementedViewManager();
        return CollectionsKt.listOf((Object[]) baseViewManagerArr);
    }

    public final Map<String, ModuleSpec> getViewManagersMap() {
        return this.viewManagersMap;
    }

    static final NativeModule viewManagersMap$lambda$0() {
        return new ReactDrawerLayoutManager();
    }

    /* JADX WARN: Multi-variable type inference failed */
    static final NativeModule viewManagersMap$lambda$1() {
        return new ReactHorizontalScrollViewManager(null, 1, 0 == true ? 1 : 0);
    }

    static final NativeModule viewManagersMap$lambda$2() {
        return new ReactHorizontalScrollContainerViewManager();
    }

    static final NativeModule viewManagersMap$lambda$3() {
        return new ReactProgressBarViewManager();
    }

    static final NativeModule viewManagersMap$lambda$4() {
        return new ReactSafeAreaViewManager();
    }

    /* JADX WARN: Multi-variable type inference failed */
    static final NativeModule viewManagersMap$lambda$5() {
        int i = 1;
        FpsListener fpsListener = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        if (ReactNativeFeatureFlags.useNestedScrollViewAndroid()) {
            return new ReactNestedScrollViewManager(fpsListener, i, objArr3 == true ? 1 : 0);
        }
        return new ReactScrollViewManager(objArr2 == true ? 1 : 0, i, objArr == true ? 1 : 0);
    }

    static final NativeModule viewManagersMap$lambda$6() {
        return new ReactSwitchManager();
    }

    static final NativeModule viewManagersMap$lambda$7() {
        return new SwipeRefreshLayoutManager();
    }

    static final NativeModule viewManagersMap$lambda$8() {
        return new ReactImageManager(null, null, null, 7, null);
    }

    static final NativeModule viewManagersMap$lambda$9() {
        return new ReactModalHostManager();
    }

    static final NativeModule viewManagersMap$lambda$10() {
        return new ReactTextInputManager();
    }

    /* JADX WARN: Multi-variable type inference failed */
    static final NativeModule viewManagersMap$lambda$11() {
        int i = 1;
        ReactTextViewManagerCallback reactTextViewManagerCallback = null;
        Object[] objArr = 0;
        if (ReactNativeFeatureFlags.enablePreparedTextLayout()) {
            return new PreparedLayoutTextViewManager(reactTextViewManagerCallback, i, objArr == true ? 1 : 0);
        }
        return new ReactTextViewManager(null, 1, null);
    }

    static final NativeModule viewManagersMap$lambda$12() {
        return new SelectableTextViewManager(null, 1, null);
    }

    static final NativeModule viewManagersMap$lambda$13() {
        return new ReactViewManager();
    }

    static final NativeModule viewManagersMap$lambda$14() {
        return new ReactVirtualViewManager();
    }

    static final NativeModule viewManagersMap$lambda$15() {
        return new ReactUnimplementedViewManager();
    }

    @Override // com.facebook.react.BaseReactPackage
    public List<ModuleSpec> getViewManagers(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return CollectionsKt.toList(this.viewManagersMap.values());
    }

    @Override // com.facebook.react.ViewManagerOnDemandReactPackage
    public Collection<String> getViewManagerNames(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return this.viewManagersMap.keySet();
    }

    @Override // com.facebook.react.ViewManagerOnDemandReactPackage
    public ViewManager<?, ?> createViewManager(ReactApplicationContext reactContext, String viewManagerName) {
        Provider<? extends NativeModule> provider;
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(viewManagerName, "viewManagerName");
        ModuleSpec moduleSpec = this.viewManagersMap.get(viewManagerName);
        NativeModule nativeModule = (moduleSpec == null || (provider = moduleSpec.provider()) == null) ? null : provider.get();
        if (nativeModule instanceof ViewManager) {
            return (ViewManager) nativeModule;
        }
        return null;
    }

    @Override // com.facebook.react.BaseReactPackage
    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        if (!ClassFinder.canLoadClassesFromAnnotationProcessors()) {
            return fallbackForMissingClass();
        }
        try {
            Class<?> clsFindClass = ClassFinder.findClass("com.facebook.react.shell.MainReactPackage$$ReactModuleInfoProvider");
            Object objNewInstance = clsFindClass != null ? clsFindClass.newInstance() : null;
            ReactModuleInfoProvider reactModuleInfoProvider = objNewInstance instanceof ReactModuleInfoProvider ? (ReactModuleInfoProvider) objNewInstance : null;
            return reactModuleInfoProvider == null ? fallbackForMissingClass() : reactModuleInfoProvider;
        } catch (ClassNotFoundException unused) {
            return fallbackForMissingClass();
        } catch (IllegalAccessException e) {
            throw new RuntimeException("No ReactModuleInfoProvider for MainReactPackage$$ReactModuleInfoProvider", e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("No ReactModuleInfoProvider for MainReactPackage$$ReactModuleInfoProvider", e2);
        }
    }

    private final ReactModuleInfoProvider fallbackForMissingClass() {
        Class[] clsArr = (Class[]) ArraysKt.filterNotNull(new Class[]{AccessibilityInfoModule.class, AppearanceModule.class, AppStateModule.class, BlobModule.class, DevLoadingModule.class, FileReaderModule.class, ClipboardModule.class, DialogModule.class, FrescoModule.class, I18nManagerModule.class, ImageLoaderModule.class, ImageStoreManager.class, IntentModule.class, ReactNativeFeatureFlags.cxxNativeAnimatedEnabled() ? null : NativeAnimatedModule.class, NetworkingModule.class, PermissionsModule.class, ReactDevToolsSettingsManagerModule.class, ReactDevToolsRuntimeSettingsModule.class, ShareModule.class, StatusBarModule.class, SoundManagerModule.class, ToastModule.class, VibrationModule.class, WebSocketModule.class}).toArray(new Class[0]);
        ArrayList arrayList = new ArrayList();
        for (Class cls : clsArr) {
            if (cls.isAnnotationPresent(ReactModule.class)) {
                arrayList.add(cls);
            }
        }
        ArrayList<Class<?>> arrayList2 = arrayList;
        final LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList2, 10)), 16));
        for (Class<?> cls2 : arrayList2) {
            Annotation annotation = cls2.getAnnotation(ReactModule.class);
            if (annotation == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            ReactModule reactModule = (ReactModule) annotation;
            String strName = reactModule.name();
            String strName2 = reactModule.name();
            String name = cls2.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            Pair pair = TuplesKt.to(strName, new ReactModuleInfo(strName2, name, reactModule.canOverrideExistingModule(), reactModule.needsEagerInit(), reactModule.isCxxModule(), ReactModuleInfo.INSTANCE.classIsTurboModule(cls2)));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return new ReactModuleInfoProvider() { // from class: com.facebook.react.shell.MainReactPackage$$ExternalSyntheticLambda0
            @Override // com.facebook.react.module.model.ReactModuleInfoProvider
            public final Map getReactModuleInfos() {
                return MainReactPackage.fallbackForMissingClass$lambda$18(linkedHashMap);
            }
        };
    }
}
