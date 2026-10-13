package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.internal.zzaq;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzafp implements zzaer {
    final /* synthetic */ zzafn zza;

    zzafp(zzafn zzafnVar) {
        Objects.requireNonNull(zzafnVar);
        this.zza = zzafnVar;
    }

    private final void zza(zzafv zzafvVar) {
        this.zza.zzi.execute(new zzafs(this, zzafvVar));
    }

    private final void zza(Status status, AuthCredential authCredential, String str, String str2) {
        zzafn.zza(this.zza, status);
        this.zza.zzn = authCredential;
        this.zza.zzo = str;
        this.zza.zzp = str2;
        if (this.zza.zzf != null) {
            this.zza.zzf.zza(status);
        }
        this.zza.zza(status);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    public final void zza(String str) throws RemoteException {
        boolean z = this.zza.zza == 8;
        Preconditions.checkState(z, "Unexpected response type " + this.zza.zza);
        this.zza.zzu = true;
        zza(new zzafq(this, str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    public final void zzb(String str) throws RemoteException {
        boolean z = this.zza.zza == 8;
        Preconditions.checkState(z, "Unexpected response type " + this.zza.zza);
        zza(new zzafo(this, str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    public final void zza(zzaha zzahaVar) throws RemoteException {
        boolean z = this.zza.zza == 3;
        Preconditions.checkState(z, "Unexpected response type " + this.zza.zza);
        this.zza.zzl = zzahaVar;
        zzafn.zza(this.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    public final void zza() throws RemoteException {
        boolean z = this.zza.zza == 5;
        Preconditions.checkState(z, "Unexpected response type " + this.zza.zza);
        zzafn.zza(this.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    public final void zza(zzaay zzaayVar) {
        zza(zzaayVar.zza(), zzaayVar.zzb(), zzaayVar.zzc(), zzaayVar.zzd());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    public final void zza(zzaax zzaaxVar) {
        this.zza.zzq = zzaaxVar;
        this.zza.zza(zzaq.zza("REQUIRES_SECOND_FACTOR_AUTH"));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    public final void zza(Status status, PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        boolean z = this.zza.zza == 2;
        Preconditions.checkState(z, "Unexpected response type " + this.zza.zza);
        zza(status, phoneAuthCredential, null, null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    public final void zza(Status status) throws RemoteException {
        String statusMessage = status.getStatusMessage();
        if (statusMessage != null) {
            if (statusMessage.contains("MISSING_MFA_PENDING_CREDENTIAL")) {
                status = new Status(17081);
            } else if (statusMessage.contains("MISSING_MFA_ENROLLMENT_ID")) {
                status = new Status(17082);
            } else if (statusMessage.contains("INVALID_MFA_PENDING_CREDENTIAL")) {
                status = new Status(17083);
            } else if (statusMessage.contains("MFA_ENROLLMENT_NOT_FOUND")) {
                status = new Status(17084);
            } else if (statusMessage.contains("ADMIN_ONLY_OPERATION")) {
                status = new Status(17085);
            } else if (statusMessage.contains("UNVERIFIED_EMAIL")) {
                status = new Status(17086);
            } else if (statusMessage.contains("SECOND_FACTOR_EXISTS")) {
                status = new Status(17087);
            } else if (statusMessage.contains("SECOND_FACTOR_LIMIT_EXCEEDED")) {
                status = new Status(17088);
            } else if (statusMessage.contains("UNSUPPORTED_FIRST_FACTOR")) {
                status = new Status(17089);
            } else if (statusMessage.contains("EMAIL_CHANGE_NEEDS_VERIFICATION")) {
                status = new Status(17090);
            }
        }
        int i = this.zza.zza;
        zzafn zzafnVar = this.zza;
        if (i == 8) {
            zzafnVar.zzu = true;
            zza(new zzaft(this, status));
        } else {
            zzafn.zza(zzafnVar, status);
            this.zza.zza(status);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    public final void zza(zzahw zzahwVar) throws RemoteException {
        this.zza.zzs = zzahwVar;
        zzafn.zza(this.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    public final void zza(zzaib zzaibVar) throws RemoteException {
        this.zza.zzr = zzaibVar;
        zzafn.zza(this.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    public final void zza(zzaia zzaiaVar, zzaht zzahtVar) throws RemoteException {
        boolean z = this.zza.zza == 2;
        Preconditions.checkState(z, "Unexpected response type: " + this.zza.zza);
        this.zza.zzj = zzaiaVar;
        this.zza.zzk = zzahtVar;
        zzafn.zza(this.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    public final void zza(zzaik zzaikVar) throws RemoteException {
        boolean z = this.zza.zza == 4;
        Preconditions.checkState(z, "Unexpected response type " + this.zza.zza);
        this.zza.zzm = zzaikVar;
        zzafn.zza(this.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    public final void zza(zzaip zzaipVar) throws RemoteException {
        zzafn.zza(this.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    public final void zzb() throws RemoteException {
        boolean z = this.zza.zza == 6;
        Preconditions.checkState(z, "Unexpected response type " + this.zza.zza);
        zzafn.zza(this.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    public final void zzc(String str) throws RemoteException {
        boolean z = this.zza.zza == 7;
        Preconditions.checkState(z, "Unexpected response type " + this.zza.zza);
        zzafn.zza(this.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    public final void zzc() throws RemoteException {
        boolean z = this.zza.zza == 9;
        Preconditions.checkState(z, "Unexpected response type " + this.zza.zza);
        zzafn.zza(this.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    public final void zza(zzaiw zzaiwVar) throws RemoteException {
        this.zza.zzt = zzaiwVar;
        zzafn.zza(this.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    public final void zza(zzaia zzaiaVar) throws RemoteException {
        boolean z = this.zza.zza == 1;
        Preconditions.checkState(z, "Unexpected response type: " + this.zza.zza);
        this.zza.zzj = zzaiaVar;
        zzafn.zza(this.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaer
    public final void zza(PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        boolean z = this.zza.zza == 8;
        Preconditions.checkState(z, "Unexpected response type " + this.zza.zza);
        this.zza.zzu = true;
        zza(new zzafr(this, phoneAuthCredential));
    }
}
