package com.google.firebase.auth.internal;

import com.google.android.gms.internal.p002firebaseauthapi.zzaik;
import com.google.firebase.auth.ActionCodeInfo;
import com.google.firebase.auth.ActionCodeResult;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzw implements ActionCodeResult {
    private final int zza;
    private final String zzb;
    private final String zzc;
    private final ActionCodeInfo zzd;

    @Override // com.google.firebase.auth.ActionCodeResult
    public final int getOperation() {
        return this.zza;
    }

    @Override // com.google.firebase.auth.ActionCodeResult
    public final ActionCodeInfo getInfo() {
        return this.zzd;
    }

    @Override // com.google.firebase.auth.ActionCodeResult
    public final String getData(int i) {
        if (this.zza == 4) {
            return null;
        }
        if (i == 0) {
            return this.zzb;
        }
        if (i != 1) {
            return null;
        }
        return this.zzc;
    }

    public zzw(zzaik zzaikVar) {
        this.zzb = zzaikVar.zzg() ? zzaikVar.zzc() : zzaikVar.zzb();
        this.zzc = zzaikVar.zzb();
        ActionCodeInfo zzuVar = null;
        if (!zzaikVar.zzh()) {
            this.zza = 3;
            this.zzd = null;
            return;
        }
        String strZzd = zzaikVar.zzd();
        strZzd.hashCode();
        int i = 5;
        switch (strZzd) {
            case "REVERT_SECOND_FACTOR_ADDITION":
                i = 6;
                break;
            case "PASSWORD_RESET":
                i = 0;
                break;
            case "VERIFY_EMAIL":
                i = 1;
                break;
            case "VERIFY_AND_CHANGE_EMAIL":
                break;
            case "EMAIL_SIGNIN":
                i = 4;
                break;
            case "RECOVER_EMAIL":
                i = 2;
                break;
            default:
                i = 3;
                break;
        }
        this.zza = i;
        if (i == 4 || i == 3) {
            this.zzd = null;
            return;
        }
        if (zzaikVar.zzf()) {
            zzuVar = new zzt(zzaikVar.zzb(), zzbi.zza(zzaikVar.zza()));
        } else if (zzaikVar.zzg()) {
            zzuVar = new zzr(zzaikVar.zzc(), zzaikVar.zzb());
        } else if (zzaikVar.zze()) {
            zzuVar = new zzu(zzaikVar.zzb());
        }
        this.zzd = zzuVar;
    }
}
