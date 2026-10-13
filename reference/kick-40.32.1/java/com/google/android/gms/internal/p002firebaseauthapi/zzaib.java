package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Strings;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public class zzaib implements zzafi<zzaib> {
    private static final String zza = "zzaib";
    private String zzb;
    private zzah<zzaii> zzc;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafi
    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public final zzaib zza(String str) throws zzacw {
        zzah<zzaii> zzahVarZzg;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = Strings.emptyToNull(jSONObject.optString("recaptchaKey"));
            if (jSONObject.has("recaptchaEnforcementState")) {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("recaptchaEnforcementState");
                if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) {
                    zzahVarZzg = zzah.zzg();
                } else {
                    zzak zzakVarZzf = zzah.zzf();
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
                        zzakVarZzf.zza(jSONObject2 == null ? zzaii.zza(null, null) : zzaii.zza(Strings.emptyToNull(jSONObject2.optString("provider")), Strings.emptyToNull(jSONObject2.optString("enforcementState"))));
                    }
                    zzahVarZzg = zzakVarZzf.zza();
                }
                this.zzc = zzahVarZzg;
            }
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzajs.zza(e, zza, str);
        }
    }

    public final String zzb(String str) {
        Preconditions.checkNotEmpty(str);
        zzah<zzaii> zzahVar = this.zzc;
        if (zzahVar != null && !zzahVar.isEmpty()) {
            zzah<zzaii> zzahVar2 = this.zzc;
            int size = zzahVar2.size();
            int i = 0;
            while (i < size) {
                zzaii zzaiiVar = zzahVar2.get(i);
                i++;
                zzaii zzaiiVar2 = zzaiiVar;
                String strZza = zzaiiVar2.zza();
                String strZzb = zzaiiVar2.zzb();
                if (strZza != null && strZzb != null && strZzb.equals(str)) {
                    return zzaiiVar2.zza();
                }
            }
        }
        return null;
    }

    public final String zza() {
        return this.zzb;
    }

    public final boolean zzc(String str) {
        String strZzb = zzb(str);
        if (strZzb == null) {
            return false;
        }
        return strZzb.equals("ENFORCE") || strZzb.equals("AUDIT");
    }
}
