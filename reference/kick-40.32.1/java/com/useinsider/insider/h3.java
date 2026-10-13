package com.useinsider.insider;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.webkit.URLUtil;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
abstract class h3 {
    static Activity a() {
        try {
            return Insider.Instance.getCurrentActivity();
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(String str) {
        try {
            Activity activityA = a();
            if (activityA == null) {
                Insider.Instance.putException(new Exception("No activity available for openInternalUrl"));
                return;
            }
            if (URLUtil.isValidUrl(str)) {
                Intent intent = new Intent(activityA, (Class<?>) InsiderInappActivity.class);
                intent.putExtra(ImagesContract.URL, str);
                intent.putExtra("keepActivity", true);
                activityA.startActivity(intent);
                return;
            }
            Insider.Instance.putException(new Exception("Invalid URL: " + str));
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(String str) {
        try {
            Activity activityA = a();
            if (activityA == null) {
                Insider.Instance.putException(new Exception("No activity available for openUrlScheme"));
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            activityA.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Insider.Instance.putException(new Exception("No activity found to handle URL scheme: " + str, e));
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    static void d(final String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        ((Executor) b5.b.a()).execute(new Runnable() { // from class: com.useinsider.insider.h3$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                h3.a(str);
            }
        });
    }

    static void e(final String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        ((Executor) b5.b.a()).execute(new Runnable() { // from class: com.useinsider.insider.h3$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                h3.b(str);
            }
        });
    }

    static void f(final String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        ((Executor) b5.b.a()).execute(new Runnable() { // from class: com.useinsider.insider.h3$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                h3.c(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str) {
        try {
            Activity activityA = a();
            if (activityA == null) {
                Insider.Instance.putException(new Exception("No activity available for openExternalUrl"));
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            activityA.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Insider.Instance.putException(new Exception("No activity found to handle URL: " + str, e));
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    static void c() {
        ((Executor) b5.b.a()).execute(new Runnable() { // from class: com.useinsider.insider.h3$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                h3.b();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b() {
        try {
            Activity activityA = a();
            if (activityA != null) {
                try {
                    activityA.startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + activityA.getPackageName())));
                    return;
                } catch (Exception e) {
                    Insider.Instance.putException(e);
                    activityA.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                    return;
                }
            }
            Insider.Instance.putException(new Exception("No activity available for openAppSettings"));
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }
}
