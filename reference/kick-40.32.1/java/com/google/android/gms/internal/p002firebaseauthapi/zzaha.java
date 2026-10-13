package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public class zzaha implements zzafi<zzaha> {
    private static final String zza = "zzaha";
    private List<String> zzb;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafi
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzaha zza(String str) throws zzacw {
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.optString("authUri", null);
            jSONObject.optBoolean("registered", false);
            jSONObject.optString("providerId", null);
            jSONObject.optBoolean("forExistingProvider", false);
            if (jSONObject.has("allProviders")) {
                new zzajf(1, zzajs.zza(jSONObject.optJSONArray("allProviders")));
            } else {
                zzajf.zza();
            }
            this.zzb = zzajs.zza(jSONObject.optJSONArray("signinMethods"));
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzajs.zza(e, zza, str);
        }
    }

    public final List<String> zza() {
        return this.zzb;
    }

    public zzaha() {
        zzajf.zza();
    }
}
