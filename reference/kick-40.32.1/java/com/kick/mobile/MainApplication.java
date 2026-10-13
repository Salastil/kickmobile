package com.kick.mobile;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import com.facebook.react.PackageList;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactHost;
import com.facebook.react.ReactNativeApplicationEntryPoint;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.common.ReleaseLevel;
import com.facebook.react.common.build.ReactBuildConfig;
import com.facebook.react.defaults.DefaultNewArchitectureEntryPoint;
import expo.modules.ApplicationLifecycleDispatcher;
import expo.modules.ExpoReactHostFactory;
import expo.modules.updates.loader.EmbeddedLoader;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MainApplication.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u001b\u0010\u0005\u001a\u00020\u00068VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/kick/mobile/MainApplication;", "Landroid/app/Application;", "Lcom/facebook/react/ReactApplication;", "<init>", "()V", "reactHost", "Lcom/facebook/react/ReactHost;", "getReactHost", "()Lcom/facebook/react/ReactHost;", "reactHost$delegate", "Lkotlin/Lazy;", "onCreate", "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "app_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MainApplication extends Application implements ReactApplication {

    /* JADX INFO: renamed from: reactHost$delegate, reason: from kotlin metadata */
    private final Lazy reactHost = LazyKt.lazy(new Function0() { // from class: com.kick.mobile.MainApplication$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return MainApplication.reactHost_delegate$lambda$0(this.f$0);
        }
    });

    @Override // com.facebook.react.ReactApplication
    public /* bridge */ ReactNativeHost getReactNativeHost() {
        return super.getReactNativeHost();
    }

    @Override // com.facebook.react.ReactApplication
    public ReactHost getReactHost() {
        return (ReactHost) this.reactHost.getValue();
    }

    static final ReactHost reactHost_delegate$lambda$0(MainApplication mainApplication) {
        Context applicationContext = mainApplication.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        ArrayList<ReactPackage> packages = new PackageList(mainApplication).getPackages();
        Intrinsics.checkNotNullExpressionValue(packages, "apply(...)");
        return ExpoReactHostFactory.getDefaultReactHost(applicationContext, packages, (252 & 4) != 0 ? ".expo/.virtual-metro-entry" : null, (252 & 8) != 0 ? EmbeddedLoader.BARE_BUNDLE_FILENAME : null, (252 & 16) != 0 ? null : null, (252 & 32) != 0 ? null : null, (252 & 64) != 0 ? ReactBuildConfig.DEBUG : false, (252 & 128) != 0 ? null : null);
    }

    @Override // android.app.Application
    public void onCreate() {
        ReleaseLevel releaseLevelValueOf;
        super.onCreate();
        DefaultNewArchitectureEntryPoint defaultNewArchitectureEntryPoint = DefaultNewArchitectureEntryPoint.INSTANCE;
        try {
            String upperCase = "experimental".toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            releaseLevelValueOf = ReleaseLevel.valueOf(upperCase);
        } catch (IllegalArgumentException unused) {
            releaseLevelValueOf = ReleaseLevel.STABLE;
        }
        defaultNewArchitectureEntryPoint.setReleaseLevel(releaseLevelValueOf);
        ReactNativeApplicationEntryPoint.loadReactNative(this);
        ApplicationLifecycleDispatcher.onApplicationCreate(this);
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        ApplicationLifecycleDispatcher.onConfigurationChanged(this, newConfig);
    }
}
