package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.MultiFactorAssertion;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneMultiFactorAssertion;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.TotpMultiFactorAssertion;
import com.google.firebase.auth.TotpSecret;
import com.google.firebase.auth.UserProfileChangeRequest;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaet {
    private static final Logger zza = new Logger("FirebaseAuth", "FirebaseAuthFallback:");
    private final zzaba zzb;
    private final zzagl zzc;

    zzaet(FirebaseApp firebaseApp, ScheduledExecutorService scheduledExecutorService) {
        Preconditions.checkNotNull(firebaseApp);
        Context applicationContext = firebaseApp.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        this.zzb = new zzaba(new zzafk(firebaseApp, zzafh.zza()));
        this.zzc = new zzagl(applicationContext, scheduledExecutorService);
    }

    public final void zza(String str, String str2, zzaer zzaerVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaerVar);
        this.zzb.zza(str, str2, new zzaeu(zzaerVar, zza));
    }

    public final void zzb(String str, String str2, zzaer zzaerVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaerVar);
        this.zzb.zzb(str, str2, new zzaeu(zzaerVar, zza));
    }

    public final void zzc(String str, String str2, zzaer zzaerVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaerVar);
        this.zzb.zzc(str, str2, new zzaeu(zzaerVar, zza));
    }

    public final void zzd(String str, String str2, zzaer zzaerVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaerVar);
        this.zzb.zzd(str, str2, new zzaeu(zzaerVar, zza));
    }

    public final void zza(zzail zzailVar, zzaer zzaerVar) {
        Preconditions.checkNotNull(zzailVar);
        Preconditions.checkNotEmpty(zzailVar.zzb());
        Preconditions.checkNotNull(zzaerVar);
        this.zzb.zza(zzailVar, new zzaeu(zzaerVar, zza));
    }

    public final void zza(String str, String str2, String str3, String str4, zzaer zzaerVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaerVar);
        this.zzb.zza(str, str2, str3, str4, new zzaeu(zzaerVar, zza));
    }

    public final void zza(String str, zzaer zzaerVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaerVar);
        this.zzb.zza(str, new zzaeu(zzaerVar, zza));
    }

    public final void zza(MultiFactorAssertion multiFactorAssertion, String str, String str2, String str3, zzaer zzaerVar) {
        zzahe zzaheVarZza;
        Preconditions.checkNotNull(multiFactorAssertion);
        Preconditions.checkNotEmpty(str, "cachedTokenState should not be empty.");
        Preconditions.checkNotNull(zzaerVar);
        if (multiFactorAssertion instanceof PhoneMultiFactorAssertion) {
            PhoneAuthCredential phoneAuthCredentialZza = ((PhoneMultiFactorAssertion) multiFactorAssertion).zza();
            zzaheVarZza = zzahi.zza(str, (String) Preconditions.checkNotNull(phoneAuthCredentialZza.zzc()), (String) Preconditions.checkNotNull(phoneAuthCredentialZza.getSmsCode()), str2, str3);
        } else if (multiFactorAssertion instanceof TotpMultiFactorAssertion) {
            TotpMultiFactorAssertion totpMultiFactorAssertion = (TotpMultiFactorAssertion) multiFactorAssertion;
            zzaheVarZza = zzahk.zza(str, Preconditions.checkNotEmpty(str2), Preconditions.checkNotEmpty(((TotpSecret) Preconditions.checkNotNull(totpMultiFactorAssertion.zza())).getSessionInfo()), Preconditions.checkNotEmpty(totpMultiFactorAssertion.zzc()), str3);
        } else {
            throw new IllegalArgumentException("multiFactorAssertion must be either PhoneMultiFactorAssertion or TotpMultiFactorAssertion.");
        }
        this.zzb.zza(zzaheVarZza, str, new zzaeu(zzaerVar, zza));
    }

    public final void zza(String str, MultiFactorAssertion multiFactorAssertion, String str2, zzaer zzaerVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(multiFactorAssertion);
        Preconditions.checkNotNull(zzaerVar);
        if (multiFactorAssertion instanceof PhoneMultiFactorAssertion) {
            PhoneAuthCredential phoneAuthCredentialZza = ((PhoneMultiFactorAssertion) multiFactorAssertion).zza();
            this.zzb.zza(zzahl.zza(str, (String) Preconditions.checkNotNull(phoneAuthCredentialZza.zzc()), (String) Preconditions.checkNotNull(phoneAuthCredentialZza.getSmsCode()), str2), new zzaeu(zzaerVar, zza));
        } else {
            if (multiFactorAssertion instanceof TotpMultiFactorAssertion) {
                TotpMultiFactorAssertion totpMultiFactorAssertion = (TotpMultiFactorAssertion) multiFactorAssertion;
                this.zzb.zza(zzahn.zza(str, Preconditions.checkNotEmpty(totpMultiFactorAssertion.zzc()), str2, Preconditions.checkNotEmpty(totpMultiFactorAssertion.zzb())), new zzaeu(zzaerVar, zza));
                return;
            }
            throw new IllegalArgumentException("multiFactorAssertion must be either PhoneMultiFactorAssertion or TotpMultiFactorAssertion.");
        }
    }

    public final void zzb(String str, zzaer zzaerVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaerVar);
        this.zzb.zzb(str, new zzaeu(zzaerVar, zza));
    }

    public final void zza(zzahx zzahxVar, zzaer zzaerVar) {
        Preconditions.checkNotNull(zzahxVar);
        this.zzb.zza(zzahxVar, new zzaeu(zzaerVar, zza));
    }

    public final void zze(String str, String str2, zzaer zzaerVar) {
        Preconditions.checkNotEmpty(str);
        this.zzb.zze(str, str2, new zzaeu(zzaerVar, zza));
    }

    public final void zza(zzahy zzahyVar, zzaer zzaerVar) {
        Preconditions.checkNotNull(zzahyVar);
        this.zzb.zza(zzahyVar, new zzaeu(zzaerVar, zza));
    }

    public final void zza(String str, String str2, String str3, String str4, String str5, zzaer zzaerVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzaerVar);
        this.zzb.zza(str, str2, str3, str4, str5, new zzaeu(zzaerVar, zza));
    }

    public final void zza(String str, zzajg zzajgVar, zzaer zzaerVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzajgVar);
        Preconditions.checkNotNull(zzaerVar);
        this.zzb.zza(str, zzajgVar, new zzaeu(zzaerVar, zza));
    }

    public final void zza(zzaie zzaieVar, zzaer zzaerVar) {
        Preconditions.checkNotNull(zzaerVar);
        Preconditions.checkNotNull(zzaieVar);
        this.zzb.zza(Preconditions.checkNotEmpty(zzaieVar.zzb()), zzaieVar.zza(), new zzaeu(zzaerVar, zza));
    }

    public final void zzc(String str, zzaer zzaerVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaerVar);
        this.zzb.zzc(str, new zzaeu(zzaerVar, zza));
    }

    public final void zza(zzain zzainVar, zzaer zzaerVar) {
        Preconditions.checkNotNull(zzainVar);
        this.zzb.zza(zzainVar, new zzaeu(zzaerVar, zza));
    }

    public final void zza(zzahv zzahvVar, zzaer zzaerVar) {
        Preconditions.checkNotNull(zzahvVar);
        Preconditions.checkNotEmpty(zzahvVar.zzd());
        Preconditions.checkNotNull(zzaerVar);
        this.zzb.zza(zzahvVar, new zzaeu(zzaerVar, zza));
    }

    public final void zzb(zzahv zzahvVar, zzaer zzaerVar) {
        Preconditions.checkNotNull(zzahvVar);
        Preconditions.checkNotEmpty(zzahvVar.zzc());
        Preconditions.checkNotNull(zzaerVar);
        this.zzb.zzb(zzahvVar, new zzaeu(zzaerVar, zza));
    }

    public final void zza(zzaio zzaioVar, zzaer zzaerVar) {
        Preconditions.checkNotNull(zzaerVar);
        Preconditions.checkNotNull(zzaioVar);
        String strZzd = zzaioVar.zzd();
        zzaeu zzaeuVar = new zzaeu(zzaerVar, zza);
        if (this.zzc.zzc(strZzd)) {
            boolean zZze = zzaioVar.zze();
            zzagl zzaglVar = this.zzc;
            if (zZze) {
                zzaglVar.zzb(strZzd);
            } else {
                zzaglVar.zzb(zzaeuVar, strZzd);
                return;
            }
        }
        long jZzb = zzaioVar.zzb();
        boolean zZzf = zzaioVar.zzf();
        if (zza(jZzb, zZzf)) {
            zzaioVar.zza(new zzagv(this.zzc.zzb()));
        }
        this.zzc.zza(strZzd, zzaeuVar, jZzb, zZzf);
        this.zzb.zza(zzaioVar, this.zzc.zza(zzaeuVar, strZzd));
    }

    public final void zza(zzais zzaisVar, zzaer zzaerVar) {
        Preconditions.checkNotNull(zzaisVar);
        Preconditions.checkNotNull(zzaerVar);
        this.zzb.zzd(zzaisVar.zza(), new zzaeu(zzaerVar, zza));
    }

    public final void zzd(String str, zzaer zzaerVar) {
        Preconditions.checkNotNull(zzaerVar);
        this.zzb.zze(str, new zzaeu(zzaerVar, zza));
    }

    public final void zza(zzajg zzajgVar, zzaer zzaerVar) {
        Preconditions.checkNotNull(zzajgVar);
        Preconditions.checkNotNull(zzaerVar);
        this.zzb.zza(zzajgVar, new zzaeu(zzaerVar, zza));
    }

    public final void zza(zzajl zzajlVar, zzaer zzaerVar) {
        Preconditions.checkNotNull(zzajlVar);
        Preconditions.checkNotNull(zzaerVar);
        this.zzb.zza(zzajlVar, new zzaeu(zzaerVar, zza));
    }

    public final void zzb(String str, String str2, String str3, String str4, zzaer zzaerVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaerVar);
        Preconditions.checkNotNull(zzaerVar);
        this.zzb.zzb(str, str2, str3, str4, new zzaeu(zzaerVar, zza));
    }

    public final void zza(zzahc zzahcVar, zzaer zzaerVar) {
        Preconditions.checkNotNull(zzaerVar);
        Preconditions.checkNotNull(zzahcVar.zzb());
        this.zzb.zza(zzahcVar.zzb(), zzahcVar.zzc(), new zzaeu(zzaerVar, zza));
    }

    public final void zza(PhoneAuthCredential phoneAuthCredential, String str, zzaer zzaerVar) {
        Preconditions.checkNotNull(zzaerVar);
        Preconditions.checkNotNull(phoneAuthCredential);
        zzajp zzajpVarZza = zzagf.zza(phoneAuthCredential);
        zzajpVarZza.zzb(str);
        this.zzb.zza(zzajpVarZza, new zzaeu(zzaerVar, zza));
    }

    public final void zza(String str, String str2, String str3, long j, boolean z, boolean z2, String str4, String str5, String str6, boolean z3, zzaer zzaerVar) {
        Preconditions.checkNotEmpty(str, "idToken should not be empty.");
        Preconditions.checkNotNull(zzaerVar);
        zzaeu zzaeuVar = new zzaeu(zzaerVar, zza);
        if (this.zzc.zzc(str2)) {
            zzagl zzaglVar = this.zzc;
            if (z) {
                zzaglVar.zzb(str2);
            } else {
                zzaglVar.zzb(zzaeuVar, str2);
                return;
            }
        }
        zzajb zzajbVarZza = zzajb.zza(str, str2, str3, str4, str5, str6, null);
        if (zza(j, z3)) {
            zzajbVarZza.zza(new zzagv(this.zzc.zzb()));
        }
        this.zzc.zza(str2, zzaeuVar, j, z3);
        this.zzb.zza(zzajbVarZza, this.zzc.zza(zzaeuVar, str2));
    }

    public final void zza(PhoneMultiFactorInfo phoneMultiFactorInfo, String str, String str2, long j, boolean z, boolean z2, String str3, String str4, String str5, boolean z3, zzaer zzaerVar) {
        Preconditions.checkNotNull(phoneMultiFactorInfo);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaerVar);
        String phoneNumber = phoneMultiFactorInfo.getPhoneNumber();
        zzaeu zzaeuVar = new zzaeu(zzaerVar, zza);
        if (this.zzc.zzc(phoneNumber)) {
            zzagl zzaglVar = this.zzc;
            if (z) {
                zzaglVar.zzb(phoneNumber);
            } else {
                zzaglVar.zzb(zzaeuVar, phoneNumber);
                return;
            }
        }
        zzaiz zzaizVarZza = zzaiz.zza(str, phoneMultiFactorInfo.getUid(), phoneMultiFactorInfo.getPhoneNumber(), str2, str3, str4, str5);
        if (zza(j, z3)) {
            zzaizVarZza.zza(new zzagv(this.zzc.zzb()));
        }
        this.zzc.zza(phoneNumber, zzaeuVar, j, z3);
        this.zzb.zza(zzaizVarZza, this.zzc.zza(zzaeuVar, phoneNumber));
    }

    public final void zza(zzajd zzajdVar, zzaer zzaerVar) {
        this.zzb.zza(zzajdVar, new zzaeu((zzaer) Preconditions.checkNotNull(zzaerVar), zza));
    }

    public final void zza(String str, String str2, String str3, zzaer zzaerVar) {
        Preconditions.checkNotEmpty(str, "cachedTokenState should not be empty.");
        Preconditions.checkNotEmpty(str2, "uid should not be empty.");
        Preconditions.checkNotNull(zzaerVar);
        this.zzb.zza(str, str2, str3, new zzaeu(zzaerVar, zza));
    }

    public final void zze(String str, zzaer zzaerVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaerVar);
        this.zzb.zzf(str, new zzaeu(zzaerVar, zza));
    }

    public final void zzf(String str, String str2, zzaer zzaerVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaerVar);
        this.zzb.zzf(str, str2, new zzaeu(zzaerVar, zza));
    }

    public final void zza(String str, UserProfileChangeRequest userProfileChangeRequest, zzaer zzaerVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(userProfileChangeRequest);
        Preconditions.checkNotNull(zzaerVar);
        this.zzb.zza(str, userProfileChangeRequest, new zzaeu(zzaerVar, zza));
    }

    public final void zzc(zzahv zzahvVar, zzaer zzaerVar) {
        Preconditions.checkNotNull(zzahvVar);
        this.zzb.zzc(zzahvVar, new zzaeu(zzaerVar, zza));
    }

    private static boolean zza(long j, boolean z) {
        if (j > 0 && z) {
            return true;
        }
        zza.w("App hash will not be appended to the request.", new Object[0]);
        return false;
    }
}
