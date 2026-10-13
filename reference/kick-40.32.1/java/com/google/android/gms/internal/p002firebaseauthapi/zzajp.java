package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import androidx.autofill.HintConstants;
import com.google.android.gms.common.internal.Preconditions;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzajp implements zzaff {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private boolean zzf;
    private String zzg;

    public static zzajp zza(String str, String str2, boolean z) {
        zzajp zzajpVar = new zzajp();
        zzajpVar.zzb = Preconditions.checkNotEmpty(str);
        zzajpVar.zzc = Preconditions.checkNotEmpty(str2);
        zzajpVar.zzf = z;
        return zzajpVar;
    }

    public static zzajp zzb(String str, String str2, boolean z) {
        zzajp zzajpVar = new zzajp();
        zzajpVar.zza = Preconditions.checkNotEmpty(str);
        zzajpVar.zzd = Preconditions.checkNotEmpty(str2);
        zzajpVar.zzf = z;
        return zzajpVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaff
    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.zzd)) {
            jSONObject.put(HintConstants.AUTOFILL_HINT_PHONE_NUMBER, this.zza);
            jSONObject.put("temporaryProof", this.zzd);
        } else {
            jSONObject.put("sessionInfo", this.zzb);
            jSONObject.put("code", this.zzc);
        }
        String str = this.zze;
        if (str != null) {
            jSONObject.put("idToken", str);
        }
        if (!this.zzf) {
            jSONObject.put("operation", 2);
        }
        String str2 = this.zzg;
        if (str2 != null) {
            jSONObject.put("tenantId", str2);
        }
        return jSONObject.toString();
    }

    private zzajp() {
    }

    public final void zza(String str) {
        this.zze = str;
    }

    public final void zzb(String str) {
        this.zzg = str;
    }
}
