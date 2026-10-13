package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zzaq;
import com.google.firebase.auth.zzc;
import io.ktor.http.auth.AuthScheme;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaba {
    private final zzafy zza;

    static /* synthetic */ void zza(zzaba zzabaVar, zzaji zzajiVar, zzaeu zzaeuVar, zzagb zzagbVar) {
        if (!zzajiVar.zzo()) {
            zzabaVar.zza(new zzaia(zzajiVar.zzi(), zzajiVar.zze(), Long.valueOf(zzajiVar.zza()), AuthScheme.Bearer), zzajiVar.zzh(), zzajiVar.zzg(), Boolean.valueOf(zzajiVar.zzn()), zzajiVar.zzb(), zzaeuVar, zzagbVar);
            return;
        }
        zzaeuVar.zza(new zzaay(zzajiVar.zzm() ? new Status(FirebaseError.ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL) : zzaq.zza(zzajiVar.zzd()), zzajiVar.zzb(), zzajiVar.zzc(), zzajiVar.zzj()));
    }

    static /* synthetic */ void zza(zzaba zzabaVar, zzaeu zzaeuVar, zzaiv zzaivVar, zzagb zzagbVar) {
        Preconditions.checkNotNull(zzaeuVar);
        Preconditions.checkNotNull(zzaivVar);
        Preconditions.checkNotNull(zzagbVar);
        zzabaVar.zza.zza(zzaivVar, new zzabp(zzabaVar, zzaeuVar, zzagbVar));
    }

    static /* synthetic */ void zza(zzaba zzabaVar, zzaeu zzaeuVar, zzaia zzaiaVar, zzaiq zzaiqVar, zzagb zzagbVar) {
        Preconditions.checkNotNull(zzaeuVar);
        Preconditions.checkNotNull(zzaiaVar);
        Preconditions.checkNotNull(zzaiqVar);
        Preconditions.checkNotNull(zzagbVar);
        zzabaVar.zza.zza(new zzahr(zzaiaVar.zzc()), new zzabg(zzabaVar, zzagbVar, zzaeuVar, zzaiaVar, zzaiqVar));
    }

    static /* synthetic */ void zza(zzaba zzabaVar, zzaeu zzaeuVar, zzaia zzaiaVar, zzaht zzahtVar, zzaiq zzaiqVar, zzagb zzagbVar) {
        Preconditions.checkNotNull(zzaeuVar);
        Preconditions.checkNotNull(zzaiaVar);
        Preconditions.checkNotNull(zzahtVar);
        Preconditions.checkNotNull(zzaiqVar);
        Preconditions.checkNotNull(zzagbVar);
        zzabaVar.zza.zza(zzaiqVar, new zzabf(zzabaVar, zzaiqVar, zzahtVar, zzaeuVar, zzaiaVar, zzagbVar));
    }

    public zzaba(zzafy zzafyVar) {
        this.zza = (zzafy) Preconditions.checkNotNull(zzafyVar);
    }

    public final void zza(String str, String str2, zzaeu zzaeuVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaeuVar);
        zzaiq zzaiqVar = new zzaiq();
        zzaiqVar.zze(str);
        zzaiqVar.zzh(str2);
        this.zza.zza(zzaiqVar, new zzacu(this, zzaeuVar));
    }

    public final void zzb(String str, String str2, zzaeu zzaeuVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaeuVar);
        zza(str, new zzacs(this, str2, zzaeuVar));
    }

    public final void zzc(String str, String str2, zzaeu zzaeuVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaeuVar);
        zza(str, new zzacr(this, str2, zzaeuVar));
    }

    public final void zzd(String str, String str2, zzaeu zzaeuVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaeuVar);
        this.zza.zza(new zzail(str, null, str2), new zzabj(this, zzaeuVar));
    }

    public final void zza(zzail zzailVar, zzaeu zzaeuVar) {
        Preconditions.checkNotEmpty(zzailVar.zzb());
        Preconditions.checkNotNull(zzaeuVar);
        this.zza.zza(zzailVar, new zzabl(this, zzaeuVar));
    }

    public final void zza(String str, String str2, String str3, String str4, zzaeu zzaeuVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaeuVar);
        this.zza.zza(new zzaiv(str, str2, null, str3, str4, null), new zzabc(this, zzaeuVar));
    }

    public final void zza(String str, zzaeu zzaeuVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaeuVar);
        zza(str, new zzacj(this, zzaeuVar));
    }

    private final void zza(String str, zzaga<zzaia> zzagaVar) {
        Preconditions.checkNotNull(zzagaVar);
        Preconditions.checkNotEmpty(str);
        zzaia zzaiaVarZzb = zzaia.zzb(str);
        if (zzaiaVarZzb.zzg()) {
            zzagaVar.zza(zzaiaVarZzb);
        } else {
            this.zza.zza(new zzaho(zzaiaVarZzb.zzd()), new zzact(this, zzagaVar));
        }
    }

    public final void zza(zzahe zzaheVar, String str, zzaeu zzaeuVar) {
        Preconditions.checkNotNull(zzaheVar);
        Preconditions.checkNotNull(zzaeuVar);
        zza(str, new zzacb(this, zzaheVar, zzaeuVar));
    }

    public final void zza(zzahg zzahgVar, zzaeu zzaeuVar) {
        Preconditions.checkNotNull(zzahgVar);
        Preconditions.checkNotNull(zzaeuVar);
        this.zza.zza(zzahgVar, new zzacd(this, zzaeuVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzahc zzahcVar, zzaeu zzaeuVar) {
        Preconditions.checkNotNull(zzahcVar);
        Preconditions.checkNotNull(zzaeuVar);
        this.zza.zza(zzahcVar, new zzabd(this, zzaeuVar));
    }

    public final void zzb(String str, zzaeu zzaeuVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaeuVar);
        this.zza.zza(new zzaho(str), new zzaaz(this, zzaeuVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzaia zzaiaVar, String str, String str2, Boolean bool, zzc zzcVar, zzaeu zzaeuVar, zzagb zzagbVar) {
        Preconditions.checkNotNull(zzaiaVar);
        Preconditions.checkNotNull(zzagbVar);
        Preconditions.checkNotNull(zzaeuVar);
        this.zza.zza(new zzahr(zzaiaVar.zzc()), new zzabi(this, zzagbVar, str2, str, bool, zzcVar, zzaeuVar, zzaiaVar));
    }

    private final void zzd(zzahv zzahvVar, zzaeu zzaeuVar) {
        Preconditions.checkNotNull(zzahvVar);
        Preconditions.checkNotNull(zzaeuVar);
        this.zza.zza(zzahvVar, new zzaco(this, zzaeuVar));
    }

    public final void zza(zzahx zzahxVar, zzaeu zzaeuVar) {
        Preconditions.checkNotNull(zzahxVar);
        Preconditions.checkNotNull(zzaeuVar);
        this.zza.zza(zzahxVar, new zzaci(this, zzaeuVar));
    }

    public final void zze(String str, String str2, zzaeu zzaeuVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaeuVar);
        this.zza.zza(new zzahb(str, str2), new zzabh(this, zzaeuVar));
    }

    public final void zza(zzahy zzahyVar, zzaeu zzaeuVar) {
        Preconditions.checkNotNull(zzahyVar);
        Preconditions.checkNotNull(zzaeuVar);
        this.zza.zza(zzahyVar, new zzacf(this, zzaeuVar));
    }

    public final void zza(String str, String str2, String str3, String str4, String str5, zzaeu zzaeuVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzaeuVar);
        zza(str3, new zzabq(this, str, str2, str4, str5, zzaeuVar));
    }

    public final void zza(String str, zzajg zzajgVar, zzaeu zzaeuVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzajgVar);
        Preconditions.checkNotNull(zzaeuVar);
        zza(str, new zzabu(this, zzajgVar, zzaeuVar));
    }

    public final void zza(String str, zzajp zzajpVar, zzaeu zzaeuVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzajpVar);
        Preconditions.checkNotNull(zzaeuVar);
        zza(str, new zzabs(this, zzajpVar, zzaeuVar));
    }

    public final void zzc(String str, zzaeu zzaeuVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaeuVar);
        zza(str, new zzach(this, zzaeuVar));
    }

    public final void zza(zzain zzainVar, zzaeu zzaeuVar) {
        this.zza.zza(zzainVar, new zzacq(this, zzaeuVar));
    }

    public final void zza(zzahv zzahvVar, zzaeu zzaeuVar) {
        Preconditions.checkNotEmpty(zzahvVar.zzd());
        Preconditions.checkNotNull(zzaeuVar);
        zzd(zzahvVar, zzaeuVar);
    }

    public final void zzb(zzahv zzahvVar, zzaeu zzaeuVar) {
        Preconditions.checkNotEmpty(zzahvVar.zzc());
        Preconditions.checkNotNull(zzaeuVar);
        this.zza.zza(zzahvVar, new zzabk(this, zzaeuVar));
    }

    public final void zza(zzaio zzaioVar, zzaeu zzaeuVar) {
        Preconditions.checkNotEmpty(zzaioVar.zzd());
        Preconditions.checkNotNull(zzaeuVar);
        this.zza.zza(zzaioVar, new zzabo(this, zzaeuVar));
    }

    public final void zzd(String str, zzaeu zzaeuVar) {
        Preconditions.checkNotNull(zzaeuVar);
        this.zza.zza(str, new zzacl(this, zzaeuVar));
    }

    public final void zze(String str, zzaeu zzaeuVar) {
        Preconditions.checkNotNull(zzaeuVar);
        this.zza.zza(new zzaiv(str), new zzacn(this, zzaeuVar));
    }

    public final void zza(zzajg zzajgVar, zzaeu zzaeuVar) {
        Preconditions.checkNotNull(zzajgVar);
        Preconditions.checkNotNull(zzaeuVar);
        zzajgVar.zzb(true);
        this.zza.zza(zzajgVar, new zzabz(this, zzaeuVar));
    }

    public final void zza(zzajl zzajlVar, zzaeu zzaeuVar) {
        Preconditions.checkNotNull(zzajlVar);
        Preconditions.checkNotNull(zzaeuVar);
        this.zza.zza(zzajlVar, new zzabm(this, zzaeuVar));
    }

    public final void zzb(String str, String str2, String str3, String str4, zzaeu zzaeuVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaeuVar);
        this.zza.zza(new zzajn(str, str2, str3, str4), new zzabb(this, zzaeuVar));
    }

    public final void zza(EmailAuthCredential emailAuthCredential, String str, zzaeu zzaeuVar) {
        Preconditions.checkNotNull(emailAuthCredential);
        Preconditions.checkNotNull(zzaeuVar);
        if (emailAuthCredential.zzg()) {
            zza(emailAuthCredential.zzb(), new zzabe(this, emailAuthCredential, str, zzaeuVar));
        } else {
            zza(new zzahc(emailAuthCredential, null, str), zzaeuVar);
        }
    }

    public final void zza(zzajp zzajpVar, zzaeu zzaeuVar) {
        Preconditions.checkNotNull(zzajpVar);
        Preconditions.checkNotNull(zzaeuVar);
        this.zza.zza(zzajpVar, new zzabn(this, zzaeuVar));
    }

    public final void zza(zzaix zzaixVar, zzaeu zzaeuVar) {
        Preconditions.checkNotNull(zzaixVar);
        Preconditions.checkNotNull(zzaeuVar);
        this.zza.zza(zzaixVar, new zzacc(this, zzaixVar, zzaeuVar));
    }

    public final void zza(zzaiz zzaizVar, zzaeu zzaeuVar) {
        Preconditions.checkNotNull(zzaizVar);
        Preconditions.checkNotNull(zzaeuVar);
        this.zza.zza(zzaizVar, new zzacg(this, zzaeuVar));
    }

    public final void zza(String str, String str2, String str3, zzaeu zzaeuVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaeuVar);
        zza(str, new zzabx(this, str2, str3, zzaeuVar));
    }

    public final void zzf(String str, zzaeu zzaeuVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaeuVar);
        zza(str, new zzabw(this, zzaeuVar));
    }

    public final void zzf(String str, String str2, zzaeu zzaeuVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaeuVar);
        zza(str2, new zzabv(this, str, zzaeuVar));
    }

    public final void zza(String str, UserProfileChangeRequest userProfileChangeRequest, zzaeu zzaeuVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(userProfileChangeRequest);
        Preconditions.checkNotNull(zzaeuVar);
        zza(str, new zzacp(this, userProfileChangeRequest, zzaeuVar));
    }

    public final void zzc(zzahv zzahvVar, zzaeu zzaeuVar) {
        zzd(zzahvVar, zzaeuVar);
    }
}
