package com.iab.omid.library.amazon2.internal;

import android.net.Uri;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public final class j {
    private static Map<String, String> a(Uri uri) {
        HashMap map = new HashMap();
        for (String str : uri.getQueryParameterNames()) {
            map.put(str, uri.getQueryParameter(str));
        }
        return map;
    }

    private static void a(Map<String, String> map) {
        try {
            com.iab.omid.library.amazon2.attestation.e.a(g.b().a().getApplicationContext(), map.get("mechanism"), new com.iab.omid.library.amazon2.attestation.a(map));
        } catch (Exception e) {
            com.iab.omid.library.amazon2.utils.d.a("Error processing attestation request in OmidNativeUrlHandler", e);
        }
    }

    public static void b(Uri uri) {
        String str;
        try {
            String queryParameter = uri.getQueryParameter(FirebaseAnalytics.Param.METHOD);
            if (TextUtils.isEmpty(queryParameter)) {
                str = "OmidNativeUrlHandler failed to handle url [" + uri.toString() + "] as 'method' not available";
            } else {
                if (queryParameter.hashCode() == -1407254715 && queryParameter.equals("attest")) {
                    a(a(uri));
                    return;
                }
                str = "Unknown method in OmidNativeUrlHandler.handle :" + queryParameter;
            }
            com.iab.omid.library.amazon2.utils.d.b(str);
        } catch (Exception e) {
            com.iab.omid.library.amazon2.utils.d.a("OmidNativeUrlHandler failed to handle url [" + uri.toString() + "]", e);
        }
    }
}
