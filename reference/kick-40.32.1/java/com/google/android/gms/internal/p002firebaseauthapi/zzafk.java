package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.zzad;
import com.google.firebase.auth.zzat;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzafk extends zzafy implements zzags {
    private zzafe zza;
    private zzafd zzb;
    private zzagh zzc;
    private zzafb zzd;
    private final zzafh zze;
    private final FirebaseApp zzf;
    private String zzg;
    private zzafj zzh;

    private final zzafj zzb() {
        if (this.zzh == null) {
            this.zzh = new zzafj(this.zzf, this.zze.zzb());
        }
        return this.zzh;
    }

    zzafk(FirebaseApp firebaseApp, zzafh zzafhVar) {
        this(firebaseApp, zzafhVar, null, null, null, null);
    }

    private zzafk(FirebaseApp firebaseApp, zzafh zzafhVar, zzagh zzaghVar, zzafe zzafeVar, zzafd zzafdVar, zzafb zzafbVar) {
        this.zzf = firebaseApp;
        this.zzg = firebaseApp.getOptions().getApiKey();
        firebaseApp.getOptions().getProjectId();
        this.zze = (zzafh) Preconditions.checkNotNull(zzafhVar);
        zza(null, null, null, null);
        zzagq.zza(this.zzg, this);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafy
    public final void zza(zzahb zzahbVar, zzaga<zzaha> zzagaVar) {
        Preconditions.checkNotNull(zzahbVar);
        Preconditions.checkNotNull(zzagaVar);
        zzafe zzafeVar = this.zza;
        zzagd.zza(zzafeVar.zza("/createAuthUri", this.zzg), zzahbVar, zzagaVar, new zzaha(), zzafeVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafy
    public final void zza(zzahd zzahdVar, zzaga<Void> zzagaVar) {
        Preconditions.checkNotNull(zzahdVar);
        Preconditions.checkNotNull(zzagaVar);
        zzafe zzafeVar = this.zza;
        zzagd.zza(zzafeVar.zza("/deleteAccount", this.zzg), zzahdVar, zzagaVar, null, zzafeVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafy
    public final void zza(zzahc zzahcVar, zzaga<zzahf> zzagaVar) {
        Preconditions.checkNotNull(zzahcVar);
        Preconditions.checkNotNull(zzagaVar);
        zzafe zzafeVar = this.zza;
        zzagd.zza(zzafeVar.zza("/emailLinkSignin", this.zzg), zzahcVar, zzagaVar, new zzahf(), zzafeVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafy
    public final void zza(zzahe zzaheVar, zzaga<zzahh> zzagaVar) {
        Preconditions.checkNotNull(zzaheVar);
        Preconditions.checkNotNull(zzagaVar);
        zzafd zzafdVar = this.zzb;
        zzafd.zza(zzafdVar.zza("/accounts/mfaEnrollment:finalize", this.zzg), zzaheVar, zzagaVar, new zzahh(), zzafdVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafy
    public final void zza(zzahg zzahgVar, zzaga<zzahj> zzagaVar) {
        Preconditions.checkNotNull(zzahgVar);
        Preconditions.checkNotNull(zzagaVar);
        zzafd zzafdVar = this.zzb;
        zzafd.zza(zzafdVar.zza("/accounts/mfaSignIn:finalize", this.zzg), zzahgVar, zzagaVar, new zzahj(), zzafdVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafy
    public final void zza(zzaho zzahoVar, zzaga<zzaia> zzagaVar) {
        Preconditions.checkNotNull(zzahoVar);
        Preconditions.checkNotNull(zzagaVar);
        zzagh zzaghVar = this.zzc;
        zzagd.zza(zzaghVar.zza("/token", this.zzg), zzahoVar, zzagaVar, new zzaia(), zzaghVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafy
    public final void zza(zzahr zzahrVar, zzaga<zzahq> zzagaVar) {
        Preconditions.checkNotNull(zzahrVar);
        Preconditions.checkNotNull(zzagaVar);
        zzafe zzafeVar = this.zza;
        zzagd.zza(zzafeVar.zza("/getAccountInfo", this.zzg), zzahrVar, zzagaVar, new zzahq(), zzafeVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafy
    public final void zza(zzahv zzahvVar, zzaga<zzahu> zzagaVar) {
        Preconditions.checkNotNull(zzahvVar);
        Preconditions.checkNotNull(zzagaVar);
        if (zzahvVar.zzb() != null) {
            zzb().zzb(zzahvVar.zzb().zze());
        }
        zzafe zzafeVar = this.zza;
        zzagd.zza(zzafeVar.zza("/getOobConfirmationCode", this.zzg), zzahvVar, zzagaVar, new zzahu(), zzafeVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafy
    public final void zza(zzahx zzahxVar, zzaga<zzahw> zzagaVar) {
        Preconditions.checkNotNull(zzahxVar);
        Preconditions.checkNotNull(zzagaVar);
        zzafe zzafeVar = this.zza;
        zzagd.zza(zzafeVar.zza("/getRecaptchaParam", this.zzg), zzagaVar, new zzahw(), zzafeVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafy
    public final void zza(zzahy zzahyVar, zzaga<zzaib> zzagaVar) {
        Preconditions.checkNotNull(zzahyVar);
        Preconditions.checkNotNull(zzagaVar);
        zzafd zzafdVar = this.zzb;
        String str = zzafdVar.zza("/recaptchaConfig", this.zzg) + "&clientType=" + zzahyVar.zzb() + "&version=" + zzahyVar.zzc();
        if (!zzac.zzc(zzahyVar.zzd())) {
            str = str + "&tenantId=" + zzahyVar.zzd();
        }
        zzagd.zza(str, zzagaVar, new zzaib(), zzafdVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzags
    public final void zza() {
        zza(null, null, null, null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafy
    public final void zza(zzail zzailVar, zzaga<zzaik> zzagaVar) {
        Preconditions.checkNotNull(zzailVar);
        Preconditions.checkNotNull(zzagaVar);
        zzafe zzafeVar = this.zza;
        zzagd.zza(zzafeVar.zza("/resetPassword", this.zzg), zzailVar, zzagaVar, new zzaik(), zzafeVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafy
    public final void zza(zzain zzainVar, zzaga<zzaip> zzagaVar) {
        Preconditions.checkNotNull(zzainVar);
        Preconditions.checkNotNull(zzagaVar);
        zzafd zzafdVar = this.zzb;
        zzafd.zza(zzafdVar.zza("/accounts:revokeToken", this.zzg), zzainVar, zzagaVar, new zzaip(), zzafdVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafy
    public final void zza(zzaio zzaioVar, zzaga<zzair> zzagaVar) {
        Preconditions.checkNotNull(zzaioVar);
        Preconditions.checkNotNull(zzagaVar);
        if (!TextUtils.isEmpty(zzaioVar.zzc())) {
            zzb().zzb(zzaioVar.zzc());
        }
        zzafe zzafeVar = this.zza;
        zzagd.zza(zzafeVar.zza("/sendVerificationCode", this.zzg), zzaioVar, zzagaVar, new zzair(), zzafeVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafy
    public final void zza(zzaiq zzaiqVar, zzaga<zzait> zzagaVar) {
        Preconditions.checkNotNull(zzaiqVar);
        Preconditions.checkNotNull(zzagaVar);
        zzafe zzafeVar = this.zza;
        zzagd.zza(zzafeVar.zza("/setAccountInfo", this.zzg), zzaiqVar, zzagaVar, new zzait(), zzafeVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafy
    public final void zza(String str, zzaga<Void> zzagaVar) {
        Preconditions.checkNotNull(zzagaVar);
        zzb().zza(str);
        zzagaVar.zza((Void) null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafy
    public final void zza(zzaiv zzaivVar, zzaga<zzaiu> zzagaVar) {
        Preconditions.checkNotNull(zzaivVar);
        Preconditions.checkNotNull(zzagaVar);
        zzafe zzafeVar = this.zza;
        zzagd.zza(zzafeVar.zza("/signupNewUser", this.zzg), zzaivVar, zzagaVar, new zzaiu(), zzafeVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafy
    public final void zza(zzaix zzaixVar, zzaga<zzaiw> zzagaVar) {
        Preconditions.checkNotNull(zzaixVar);
        Preconditions.checkNotNull(zzagaVar);
        if (zzaixVar instanceof zzajb) {
            zzajb zzajbVar = (zzajb) zzaixVar;
            if (!TextUtils.isEmpty(zzajbVar.zzb())) {
                zzb().zzb(zzajbVar.zzb());
            }
        }
        zzafd zzafdVar = this.zzb;
        zzafd.zza(zzafdVar.zza("/accounts/mfaEnrollment:start", this.zzg), zzaixVar, zzagaVar, new zzaiw(), zzafdVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafy
    public final void zza(zzaiz zzaizVar, zzaga<zzaiy> zzagaVar) {
        Preconditions.checkNotNull(zzaizVar);
        Preconditions.checkNotNull(zzagaVar);
        if (!TextUtils.isEmpty(zzaizVar.zzb())) {
            zzb().zzb(zzaizVar.zzb());
        }
        zzafd zzafdVar = this.zzb;
        zzafd.zza(zzafdVar.zza("/accounts/mfaSignIn:start", this.zzg), zzaizVar, zzagaVar, new zzaiy(), zzafdVar.zza);
    }

    private final void zza(zzagh zzaghVar, zzafe zzafeVar, zzafd zzafdVar, zzafb zzafbVar) {
        this.zzc = null;
        this.zza = null;
        this.zzb = null;
        this.zzd = null;
        String strZza = zzagr.zza("firebear.secureToken");
        if (TextUtils.isEmpty(strZza)) {
            strZza = zzagq.zzd(this.zzg);
        } else {
            Log.e("LocalClient", "Found hermetic configuration for secureToken URL: " + strZza);
        }
        if (this.zzc == null) {
            this.zzc = new zzagh(strZza, zzb());
        }
        String strZza2 = zzagr.zza("firebear.identityToolkit");
        if (TextUtils.isEmpty(strZza2)) {
            strZza2 = zzagq.zzb(this.zzg);
        } else {
            Log.e("LocalClient", "Found hermetic configuration for identityToolkit URL: " + strZza2);
        }
        if (this.zza == null) {
            this.zza = new zzafe(strZza2, zzb());
        }
        String strZza3 = zzagr.zza("firebear.identityToolkitV2");
        if (TextUtils.isEmpty(strZza3)) {
            strZza3 = zzagq.zzc(this.zzg);
        } else {
            Log.e("LocalClient", "Found hermetic configuration for identityToolkitV2 URL: " + strZza3);
        }
        if (this.zzb == null) {
            this.zzb = new zzafd(strZza3, zzb());
        }
        zzat zzatVarZzb = zzad.zza(this.zzf).zzb();
        if (zzatVarZzb != null) {
            String strZza4 = zzagr.zza("firebear.identityPlatformV2");
            if (TextUtils.isEmpty(strZza4)) {
                strZza4 = zzagq.zza(this.zzg, zzatVarZzb.zza());
            } else {
                Log.e("LocalClient", "Found hermetic configuration for identityPlatformV2 URL: " + strZza4);
            }
            if (this.zzd == null) {
                this.zzd = new zzafb(strZza4, zzb());
            }
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafy
    public final void zza(zzajg zzajgVar, zzaga<zzaji> zzagaVar) {
        Preconditions.checkNotNull(zzajgVar);
        Preconditions.checkNotNull(zzagaVar);
        zzafe zzafeVar = this.zza;
        zzagd.zza(zzafeVar.zza("/verifyAssertion", this.zzg), zzajgVar, zzagaVar, new zzaji(), zzafeVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafy
    public final void zza(zzajl zzajlVar, zzaga<zzajk> zzagaVar) {
        Preconditions.checkNotNull(zzajlVar);
        Preconditions.checkNotNull(zzagaVar);
        zzafe zzafeVar = this.zza;
        zzagd.zza(zzafeVar.zza("/verifyCustomToken", this.zzg), zzajlVar, zzagaVar, new zzajk(), zzafeVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafy
    public final void zza(zzajn zzajnVar, zzaga<zzajm> zzagaVar) {
        Preconditions.checkNotNull(zzajnVar);
        Preconditions.checkNotNull(zzagaVar);
        zzafe zzafeVar = this.zza;
        zzagd.zza(zzafeVar.zza("/verifyPassword", this.zzg), zzajnVar, zzagaVar, new zzajm(), zzafeVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafy
    public final void zza(zzajp zzajpVar, zzaga<zzajo> zzagaVar) {
        Preconditions.checkNotNull(zzajpVar);
        Preconditions.checkNotNull(zzagaVar);
        zzafe zzafeVar = this.zza;
        zzagd.zza(zzafeVar.zza("/verifyPhoneNumber", this.zzg), zzajpVar, zzagaVar, new zzajo(), zzafeVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafy
    public final void zza(zzajr zzajrVar, zzaga<zzajq> zzagaVar) {
        Preconditions.checkNotNull(zzajrVar);
        Preconditions.checkNotNull(zzagaVar);
        zzafd zzafdVar = this.zzb;
        zzafd.zza(zzafdVar.zza("/accounts/mfaEnrollment:withdraw", this.zzg), zzajrVar, zzagaVar, new zzajq(), zzafdVar.zza);
    }
}
