package com.useinsider.insider;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.util.Supplier;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
public class InsiderLoginActivity extends Activity {

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f305a;
        final /* synthetic */ JSONObject b;
        final /* synthetic */ Context c;
        final /* synthetic */ int d;
        final /* synthetic */ String e;
        final /* synthetic */ String f;

        a(String str, JSONObject jSONObject, Context context, int i, String str2, String str3) {
            this.f305a = str;
            this.b = jSONObject;
            this.c = context;
            this.d = i;
            this.e = str2;
            this.f = str3;
        }

        /* JADX WARN: Code duplicated, block: B:6:0x001f  */
        @Override // java.lang.Runnable
        public void run() {
            String strA = w4.a(this.f305a, this.b, this.c, false, l4.TEST_DEVICE).a();
            if (strA != null) {
                try {
                    if (strA.equals("")) {
                        strA = " { 'response': '' }";
                    }
                } catch (Exception e) {
                    Insider.Instance.putException(e);
                    return;
                }
            } else {
                strA = " { 'response': '' }";
            }
            JSONObject jSONObject = new JSONObject(strA);
            if (jSONObject.has("response")) {
                if (jSONObject.getString("response").equals("test_device_added")) {
                    e.h = true;
                    h4.a().e(InsiderLoginActivity.this.getApplicationContext(), "Insider").edit().putBoolean("debug_mode", true).apply();
                    f3.b("common", "Test device add request was successfully.", "{}", "InsiderLoginActivity-sendTestDeviceRequest");
                    return;
                }
                int i = this.d;
                if (i < 3) {
                    InsiderLoginActivity.this.a(this.c, this.e, this.f, i + 1);
                    f3.b("common", "Test device add request was retried.", "{'partner_name': '" + this.e + "', 'api_token': '" + this.f + "'}", "InsiderLoginActivity-sendTestDeviceRequest");
                }
            }
        }
    }

    private void b() {
        try {
            Intent launchIntentForPackage = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
            launchIntentForPackage.addFlags(67108864);
            startActivity(launchIntentForPackage);
            finish();
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            Intent intent = getIntent();
            if (intent != null && intent.getData() != null) {
                Uri data = intent.getData();
                if (data.getPath() != null && data.getHost() != null) {
                    String strReplace = data.getPath().replace(DomExceptionUtils.SEPARATOR, "");
                    String host = data.getHost();
                    int iHashCode = host.hashCode();
                    if (iHashCode == -683938141) {
                        if (host.equals("test_device")) {
                            b();
                            a(this, a(data.getScheme()), strReplace, 0);
                            return;
                        }
                        return;
                    }
                    if (iHashCode == 1210633824 && host.equals("connect_wizard")) {
                        m0 m0VarF = m0.f();
                        m0VarF.a(new Supplier() { // from class: com.useinsider.insider.InsiderLoginActivity$$ExternalSyntheticLambda0
                            @Override // androidx.core.util.Supplier
                            public final Object get() {
                                return this.f$0.a();
                            }
                        }, y3.class, m0.b.SINGLETON);
                        y3 y3VarJ = m0VarF.j();
                        if (y3VarJ != null) {
                            y3VarJ.d();
                            b();
                            y3VarJ.a(strReplace);
                        }
                    }
                }
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ y3 a() {
        return new y3(getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, String str2, int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            String strB = w3.ADD_TEST_DEVICE.b();
            jSONObject.put(f.n, str);
            jSONObject.put("udid", w4.k(context));
            jSONObject.put("token", str2);
            new Thread(new a(strB, jSONObject, context, i, str, str2)).start();
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    private String a(String str) {
        String string = e.b;
        try {
            if (string.equals("")) {
                string = h4.a().e(getApplicationContext(), "Insider").getString(f.n, "");
                if (string.equals("")) {
                    return str.replace("insider", "");
                }
            }
            return string;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return string;
        }
    }
}
