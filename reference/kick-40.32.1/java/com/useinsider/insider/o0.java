package com.useinsider.insider;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.webkit.URLUtil;
import com.google.android.gms.common.internal.ImagesContract;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
class o0 implements v3 {
    o0() {
    }

    @Override // com.useinsider.insider.v3
    public void a(Activity activity, String str) {
        try {
            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @Override // com.useinsider.insider.v3
    public void b(Activity activity, String str) {
        try {
            if (URLUtil.isValidUrl(str)) {
                Intent intent = new Intent(activity, (Class<?>) InsiderInappActivity.class);
                intent.putExtra(ImagesContract.URL, str);
                intent.putExtra("keepActivity", true);
                activity.startActivityForResult(intent, 1);
                return;
            }
            Insider.Instance.putException(new Exception("Invalid URL: " + str));
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @Override // com.useinsider.insider.v3
    public void a(Activity activity) {
        try {
            activity.startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + activity.getPackageName())));
        } catch (Exception e) {
            Insider.Instance.putException(e);
            activity.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
        }
    }
}
