package com.google.android.gms.internal.p002firebaseauthapi;

import android.app.Activity;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.ActionCodeResult;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.FirebaseAuthProvider;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.PhoneMultiFactorAssertion;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.auth.TotpMultiFactorAssertion;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zzad;
import com.google.firebase.auth.internal.zzaf;
import com.google.firebase.auth.internal.zzao;
import com.google.firebase.auth.internal.zzat;
import com.google.firebase.auth.internal.zzaw;
import com.google.firebase.auth.internal.zzbi;
import com.google.firebase.auth.internal.zzch;
import com.google.firebase.auth.internal.zzj;
import com.google.firebase.auth.internal.zzz;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzacv extends zzafx {
    public final Task<Void> zza(FirebaseApp firebaseApp, String str, String str2) {
        return zza((zzacy) new zzacy(str, str2).zza(firebaseApp));
    }

    public final Task<ActionCodeResult> zzb(FirebaseApp firebaseApp, String str, String str2) {
        return zza((zzacx) new zzacx(str, str2).zza(firebaseApp));
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, String str, String str2, String str3) {
        return zza((zzada) new zzada(str, str2, str3).zza(firebaseApp));
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, String str, String str2, String str3, String str4, zzj zzjVar) {
        return zza((zzacz) new zzacz(str, str2, str3, str4).zza(firebaseApp).zza(zzjVar));
    }

    public final Task<Void> zza(FirebaseUser firebaseUser, zzat zzatVar) {
        return zza((zzadc) new zzadc().zza(firebaseUser).zza(zzatVar).zza((zzaw) zzatVar));
    }

    public final Task<SignInMethodQueryResult> zzc(FirebaseApp firebaseApp, String str, String str2) {
        return zza((zzadb) new zzadb(str, str2).zza(firebaseApp));
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, PhoneMultiFactorAssertion phoneMultiFactorAssertion, FirebaseUser firebaseUser, String str, zzj zzjVar) {
        zzagg.zza();
        zzade zzadeVar = new zzade(phoneMultiFactorAssertion, firebaseUser.zze(), str, null);
        zzadeVar.zza(firebaseApp).zza(zzjVar);
        return zza(zzadeVar);
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, TotpMultiFactorAssertion totpMultiFactorAssertion, FirebaseUser firebaseUser, String str, String str2, zzj zzjVar) {
        zzade zzadeVar = new zzade(totpMultiFactorAssertion, firebaseUser.zze(), str, str2);
        zzadeVar.zza(firebaseApp).zza(zzjVar);
        return zza(zzadeVar);
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneMultiFactorAssertion phoneMultiFactorAssertion, String str, zzj zzjVar) {
        zzagg.zza();
        zzadd zzaddVar = new zzadd(phoneMultiFactorAssertion, str, null);
        zzaddVar.zza(firebaseApp).zza(zzjVar);
        if (firebaseUser != null) {
            zzaddVar.zza(firebaseUser);
        }
        return zza(zzaddVar);
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, TotpMultiFactorAssertion totpMultiFactorAssertion, String str, String str2, zzj zzjVar) {
        zzadd zzaddVar = new zzadd(totpMultiFactorAssertion, str, str2);
        zzaddVar.zza(firebaseApp).zza(zzjVar);
        if (firebaseUser != null) {
            zzaddVar.zza(firebaseUser);
        }
        return zza(zzaddVar);
    }

    public final Task<GetTokenResult> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzch zzchVar) {
        return zza((zzadg) new zzadg(str).zza(firebaseApp).zza(firebaseUser).zza(zzchVar).zza((zzaw) zzchVar));
    }

    public final Task<zzahw> zza() {
        return zza(new zzadf());
    }

    public final Task<zzaib> zza(String str, String str2) {
        return zza(new zzadi(str, str2));
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, AuthCredential authCredential, String str, zzch zzchVar) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(authCredential);
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzchVar);
        List<String> listZzg = firebaseUser.zzg();
        if (listZzg != null && listZzg.contains(authCredential.getProvider())) {
            return Tasks.forException(zzaew.zza(new Status(FirebaseError.ERROR_PROVIDER_ALREADY_LINKED)));
        }
        if (authCredential instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) authCredential;
            if (!emailAuthCredential.zzf()) {
                return zza((zzadh) new zzadh(emailAuthCredential, str).zza(firebaseApp).zza(firebaseUser).zza(zzchVar).zza((zzaw) zzchVar));
            }
            return zza((zzadm) new zzadm(emailAuthCredential).zza(firebaseApp).zza(firebaseUser).zza(zzchVar).zza((zzaw) zzchVar));
        }
        if (authCredential instanceof PhoneAuthCredential) {
            zzagg.zza();
            return zza((zzadj) new zzadj((PhoneAuthCredential) authCredential).zza(firebaseApp).zza(firebaseUser).zza(zzchVar).zza((zzaw) zzchVar));
        }
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(authCredential);
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzchVar);
        return zza((zzadk) new zzadk(authCredential).zza(firebaseApp).zza(firebaseUser).zza(zzchVar).zza((zzaw) zzchVar));
    }

    public final Task<Void> zzb(FirebaseApp firebaseApp, FirebaseUser firebaseUser, AuthCredential authCredential, String str, zzch zzchVar) {
        return zza((zzadl) new zzadl(authCredential, str).zza(firebaseApp).zza(firebaseUser).zza(zzchVar).zza((zzaw) zzchVar));
    }

    public final Task<AuthResult> zzc(FirebaseApp firebaseApp, FirebaseUser firebaseUser, AuthCredential authCredential, String str, zzch zzchVar) {
        return zza((zzado) new zzado(authCredential, str).zza(firebaseApp).zza(firebaseUser).zza(zzchVar).zza((zzaw) zzchVar));
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, EmailAuthCredential emailAuthCredential, String str, zzch zzchVar) {
        return zza((zzadn) new zzadn(emailAuthCredential, str).zza(firebaseApp).zza(firebaseUser).zza(zzchVar).zza((zzaw) zzchVar));
    }

    public final Task<AuthResult> zzb(FirebaseApp firebaseApp, FirebaseUser firebaseUser, EmailAuthCredential emailAuthCredential, String str, zzch zzchVar) {
        return zza((zzadq) new zzadq(emailAuthCredential, str).zza(firebaseApp).zza(firebaseUser).zza(zzchVar).zza((zzaw) zzchVar));
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, String str2, String str3, String str4, zzch zzchVar) {
        return zza((zzadp) new zzadp(str, str2, str3, str4).zza(firebaseApp).zza(firebaseUser).zza(zzchVar).zza((zzaw) zzchVar));
    }

    public final Task<AuthResult> zzb(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, String str2, String str3, String str4, zzch zzchVar) {
        return zza((zzads) new zzads(str, str2, str3, str4).zza(firebaseApp).zza(firebaseUser).zza(zzchVar).zza((zzaw) zzchVar));
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential, String str, zzch zzchVar) {
        zzagg.zza();
        return zza((zzadr) new zzadr(phoneAuthCredential, str).zza(firebaseApp).zza(firebaseUser).zza(zzchVar).zza((zzaw) zzchVar));
    }

    public final Task<AuthResult> zzb(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential, String str, zzch zzchVar) {
        zzagg.zza();
        return zza((zzadu) new zzadu(phoneAuthCredential, str).zza(firebaseApp).zza(firebaseUser).zza(zzchVar).zza((zzaw) zzchVar));
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, zzch zzchVar) {
        return zza((zzadt) new zzadt().zza(firebaseApp).zza(firebaseUser).zza(zzchVar).zza((zzaw) zzchVar));
    }

    public final Task<Void> zza(String str, String str2, String str3, String str4) {
        return zza(new zzadw(str, str2, str3, str4));
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, ActionCodeSettings actionCodeSettings, String str) {
        return zza((zzadv) new zzadv(str, actionCodeSettings).zza(firebaseApp));
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, String str, ActionCodeSettings actionCodeSettings, String str2, String str3) {
        actionCodeSettings.zza(1);
        return zza((zzady) new zzady(str, actionCodeSettings, str2, str3, "sendPasswordResetEmail").zza(firebaseApp));
    }

    public final Task<Void> zzb(FirebaseApp firebaseApp, String str, ActionCodeSettings actionCodeSettings, String str2, String str3) {
        actionCodeSettings.zza(6);
        return zza((zzady) new zzady(str, actionCodeSettings, str2, str3, "sendSignInLinkToEmail").zza(firebaseApp));
    }

    public final Task<Void> zza(String str) {
        return zza(new zzadx(str));
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, zzj zzjVar, String str) {
        return zza((zzaea) new zzaea(str).zza(firebaseApp).zza(zzjVar));
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, AuthCredential authCredential, String str, zzj zzjVar) {
        return zza((zzadz) new zzadz(authCredential, str).zza(firebaseApp).zza(zzjVar));
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, String str, String str2, zzj zzjVar) {
        return zza((zzaec) new zzaec(str, str2).zza(firebaseApp).zza(zzjVar));
    }

    public final Task<AuthResult> zzb(FirebaseApp firebaseApp, String str, String str2, String str3, String str4, zzj zzjVar) {
        return zza((zzaeb) new zzaeb(str, str2, str3, str4).zza(firebaseApp).zza(zzjVar));
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, EmailAuthCredential emailAuthCredential, String str, zzj zzjVar) {
        return zza((zzaee) new zzaee(emailAuthCredential, str).zza(firebaseApp).zza(zzjVar));
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, PhoneAuthCredential phoneAuthCredential, String str, zzj zzjVar) {
        zzagg.zza();
        return zza((zzaed) new zzaed(phoneAuthCredential, str).zza(firebaseApp).zza(zzjVar));
    }

    public final Task<Void> zza(zzao zzaoVar, String str, String str2, long j, boolean z, boolean z2, String str3, String str4, String str5, boolean z3, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Executor executor, Activity activity) {
        zzaeg zzaegVar = new zzaeg(zzaoVar, str, str2, j, z, z2, str3, str4, str5, z3);
        zzaegVar.zza(onVerificationStateChangedCallbacks, activity, executor, str);
        return zza(zzaegVar);
    }

    public final Task<zzaiw> zza(zzao zzaoVar, String str) {
        return zza(new zzaef(zzaoVar, str));
    }

    public final Task<Void> zza(zzao zzaoVar, PhoneMultiFactorInfo phoneMultiFactorInfo, String str, long j, boolean z, boolean z2, String str2, String str3, String str4, boolean z3, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Executor executor, Activity activity) {
        zzaei zzaeiVar = new zzaei(phoneMultiFactorInfo, Preconditions.checkNotEmpty(zzaoVar.zzc()), str, j, z, z2, str2, str3, str4, z3);
        zzaeiVar.zza(onVerificationStateChangedCallbacks, activity, executor, phoneMultiFactorInfo.getUid());
        return zza(zzaeiVar);
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, String str2, zzch zzchVar) {
        return zza((zzaeh) new zzaeh(firebaseUser.zze(), str, str2).zza(firebaseApp).zza(firebaseUser).zza(zzchVar).zza((zzaw) zzchVar));
    }

    public final Task<AuthResult> zzb(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzch zzchVar) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzchVar);
        List<String> listZzg = firebaseUser.zzg();
        if ((listZzg != null && !listZzg.contains(str)) || firebaseUser.isAnonymous()) {
            return Tasks.forException(zzaew.zza(new Status(FirebaseError.ERROR_NO_SUCH_PROVIDER, str)));
        }
        str.hashCode();
        if (str.equals("password")) {
            return zza((zzaek) new zzaek().zza(firebaseApp).zza(firebaseUser).zza(zzchVar).zza((zzaw) zzchVar));
        }
        return zza((zzaej) new zzaej(str).zza(firebaseApp).zza(firebaseUser).zza(zzchVar).zza((zzaw) zzchVar));
    }

    public final Task<Void> zzc(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzch zzchVar) {
        return zza((zzaem) new zzaem(str).zza(firebaseApp).zza(firebaseUser).zza(zzchVar).zza((zzaw) zzchVar));
    }

    public final Task<Void> zzd(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzch zzchVar) {
        return zza((zzael) new zzael(str).zza(firebaseApp).zza(firebaseUser).zza(zzchVar).zza((zzaw) zzchVar));
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential, zzch zzchVar) {
        zzagg.zza();
        return zza((zzaeo) new zzaeo(phoneAuthCredential).zza(firebaseApp).zza(firebaseUser).zza(zzchVar).zza((zzaw) zzchVar));
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, UserProfileChangeRequest userProfileChangeRequest, zzch zzchVar) {
        return zza((zzaen) new zzaen(userProfileChangeRequest).zza(firebaseApp).zza(firebaseUser).zza(zzchVar).zza((zzaw) zzchVar));
    }

    public final Task<Void> zza(String str, String str2, ActionCodeSettings actionCodeSettings) {
        actionCodeSettings.zza(7);
        return zza(new zzaeq(str, str2, actionCodeSettings));
    }

    public final Task<String> zzd(FirebaseApp firebaseApp, String str, String str2) {
        return zza((zzaep) new zzaep(str, str2).zza(firebaseApp));
    }

    static zzad zza(FirebaseApp firebaseApp, zzaht zzahtVar) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(zzahtVar);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new zzz(zzahtVar, FirebaseAuthProvider.PROVIDER_ID));
        List<zzaig> listZzl = zzahtVar.zzl();
        if (listZzl != null && !listZzl.isEmpty()) {
            for (int i = 0; i < listZzl.size(); i++) {
                arrayList.add(new zzz(listZzl.get(i)));
            }
        }
        zzad zzadVar = new zzad(firebaseApp, arrayList);
        zzadVar.zza(new zzaf(zzahtVar.zzb(), zzahtVar.zza()));
        zzadVar.zza(zzahtVar.zzn());
        zzadVar.zza(zzahtVar.zze());
        zzadVar.zzc(zzbi.zza(zzahtVar.zzk()));
        zzadVar.zzb(zzahtVar.zzd());
        return zzadVar;
    }

    public zzacv(FirebaseApp firebaseApp, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        this.zza = new zzaet(firebaseApp, scheduledExecutorService);
        this.zzb = executor;
    }

    public final void zza(FirebaseApp firebaseApp, zzaio zzaioVar, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Activity activity, Executor executor) {
        zza((zzaes) new zzaes(zzaioVar).zza(firebaseApp).zza(onVerificationStateChangedCallbacks, activity, executor, zzaioVar.zzd()));
    }
}
