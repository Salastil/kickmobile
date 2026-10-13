package com.useinsider.insider;

import android.content.Context;
import android.telephony.TelephonyManager;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
final class d5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f324a;

    d5(Context context) {
        this.f324a = context;
    }

    String b() {
        String str = "";
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.f324a.getSystemService("phone");
            String networkOperatorName = telephonyManager != null ? telephonyManager.getNetworkOperatorName() : "";
            if (networkOperatorName != null) {
                try {
                    if (networkOperatorName.length() != 0) {
                        return networkOperatorName;
                    }
                } catch (Exception e) {
                    str = networkOperatorName;
                    e = e;
                    Insider.Instance.putException(e);
                    return str;
                }
            }
            return "";
        } catch (Exception e2) {
            e = e2;
        }
    }

    String c() {
        return this.f324a.getPackageName();
    }

    String a() {
        try {
            return this.f324a.getPackageManager().getPackageInfo(this.f324a.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return "1.0";
        }
    }
}
