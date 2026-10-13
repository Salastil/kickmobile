package com.useinsider.insider;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.core.app.NotificationManagerCompat;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
public class InsiderActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f287a = "android.activity.splashScreenStyle";

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    interface a {
        void b();
    }

    private void a(Intent intent) {
        try {
            int iA = w4.a(intent);
            if (intent.hasExtra("notification_id")) {
                intent.removeExtra("notification_id");
            } else if (intent.hasExtra("notificationId")) {
                sendBroadcast(c4.a(this, intent.getStringExtra("camp_id") + iA));
            }
            NotificationManagerCompat.from(this).cancel(iA);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b() {
        f3.b("push", "Push Intent saved to shared pref.", new JSONObject(), "InsiderActivity-onCreate");
        c();
    }

    private void c() {
        try {
            if (!isTaskRoot()) {
                a();
                return;
            }
            Intent launchIntentForPackage = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
            if (launchIntentForPackage != null) {
                launchIntentForPackage.putExtra("from_insider_push", true);
                a();
                int i = Build.VERSION.SDK_INT;
                if (i >= 33) {
                    ActivityOptions activityOptionsMakeBasic = ActivityOptions.makeBasic();
                    activityOptionsMakeBasic.setSplashScreenStyle(1);
                    startActivity(launchIntentForPackage, activityOptionsMakeBasic.toBundle());
                } else if (i >= 31) {
                    Bundle bundle = ActivityOptions.makeBasic().toBundle();
                    bundle.putInt("android.activity.splashScreenStyle", 1);
                    startActivity(launchIntentForPackage, bundle);
                } else {
                    startActivity(launchIntentForPackage);
                }
                f3.b("push", "Application main activity triggered.", new JSONObject(), "InsiderActivity-openAppIfAppropriateAndFinishThisActivity");
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            if (intent == null) {
                f3.b("push", "Notification Intent is null.", new JSONObject(), "InsiderActivity-onCreate");
                return;
            }
            e.t = false;
            e.u = null;
            e.y = true;
            e.r = b(intent);
            a(intent);
            w4.a(intent, getApplicationContext(), new a() { // from class: com.useinsider.insider.InsiderActivity$$ExternalSyntheticLambda1
                @Override // com.useinsider.insider.InsiderActivity.a
                public final void b() {
                    this.f$0.b();
                }
            });
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    private boolean b(Intent intent) {
        try {
            if (intent.hasExtra(f.k)) {
                JSONObject jSONObject = new JSONObject(intent.getStringExtra(f.k));
                return !jSONObject.has(f.j) && jSONObject.has(f.i);
            }
            if (!intent.hasExtra(f.m)) {
                return (intent.hasExtra(f.j) || intent.hasExtra(f.f329a) || intent.hasExtra(f.b) || !intent.hasExtra(f.i)) ? false : true;
            }
            JSONObject jSONObject2 = new JSONObject(intent.getStringExtra(f.m));
            return !jSONObject2.has(f.j) && jSONObject2.has(f.i);
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return false;
        }
    }

    private void a() {
        try {
            finish();
            f3.b("push", "InsiderActivity finished.", new JSONObject(), "InsiderActivity-finishThisActivity");
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }
}
