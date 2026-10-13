package com.useinsider.insider;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import com.android.billingclient.api.BillingClient;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
public class c0 implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private l0 f318a;

    c0(l0 l0Var) {
        this.f318a = l0Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Activity activity) {
        this.f318a.f(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.f318a.e(activity);
        this.f318a.a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        try {
            this.f318a.g(activity);
        } catch (Exception e) {
            this.f318a.a(e);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(final Activity activity) {
        this.f318a.a(activity, new q() { // from class: com.useinsider.insider.c0$$ExternalSyntheticLambda0
            @Override // com.useinsider.insider.q
            public final void a() {
                this.f$0.a(activity);
            }
        });
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        try {
            l0 l0Var = this.f318a;
            if (l0Var == null || l0Var.n() == null) {
                return;
            }
            Activity activityN = this.f318a.n();
            if ((activityN.getPackageManager().getActivityInfo(activityN.getComponentName(), 128).configChanges & 128) != 0) {
                String simpleName = activityN.getClass().getSimpleName();
                this.f318a.a(true, (q) null);
                f3.b(BillingClient.ProductType.INAPP, "Inapp destroyed due to configuration change", new JSONObject().put("activity_name", simpleName).put("handles_config_changes", true).put("orientation", configuration.orientation), "InsiderApplicationCallback-onConfigurationChanged");
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
    }
}
