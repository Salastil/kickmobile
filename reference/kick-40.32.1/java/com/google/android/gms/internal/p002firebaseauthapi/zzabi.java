package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import com.google.firebase.auth.zzc;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzabi implements zzaga<zzahq> {
    private final /* synthetic */ zzagb zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ Boolean zzd;
    private final /* synthetic */ zzc zze;
    private final /* synthetic */ zzaeu zzf;
    private final /* synthetic */ zzaia zzg;

    zzabi(zzaba zzabaVar, zzagb zzagbVar, String str, String str2, Boolean bool, zzc zzcVar, zzaeu zzaeuVar, zzaia zzaiaVar) {
        this.zza = zzagbVar;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = bool;
        this.zze = zzcVar;
        this.zzf = zzaeuVar;
        this.zzg = zzaiaVar;
        Objects.requireNonNull(zzabaVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzagb
    public final void zza(String str) {
        this.zza.zza(str);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaga
    public final /* synthetic */ void zza(zzahq zzahqVar) {
        List<zzaht> listZza = zzahqVar.zza();
        if (listZza == null || listZza.isEmpty()) {
            this.zza.zza("No users.");
            return;
        }
        zzaht zzahtVar = listZza.get(0);
        zzaij zzaijVarZzf = zzahtVar.zzf();
        List<zzaig> listZza2 = zzaijVarZzf != null ? zzaijVarZzf.zza() : null;
        if (listZza2 != null && !listZza2.isEmpty()) {
            if (!TextUtils.isEmpty(this.zzb)) {
                for (int i = 0; i < listZza2.size(); i++) {
                    if (listZza2.get(i).zzf().equals(this.zzb)) {
                        listZza2.get(i).zza(this.zzc);
                        break;
                    }
                }
            } else {
                listZza2.get(0).zza(this.zzc);
            }
        }
        Boolean bool = this.zzd;
        if (bool != null) {
            zzahtVar.zza(bool.booleanValue());
        } else {
            zzahtVar.zza(zzahtVar.zzb() - zzahtVar.zza() < 1000);
        }
        zzahtVar.zza(this.zze);
        this.zzf.zza(this.zzg, zzahtVar);
    }
}
