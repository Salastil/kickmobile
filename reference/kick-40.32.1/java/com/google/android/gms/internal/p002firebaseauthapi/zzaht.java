package com.google.android.gms.internal.p002firebaseauthapi;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.zzao;
import com.google.firebase.auth.zzc;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaht {
    private String zza;
    private String zzb;
    private boolean zzc;
    private String zzd;
    private String zze;
    private zzaij zzf;
    private String zzg;
    private long zzh;
    private long zzi;
    private boolean zzj;
    private zzc zzk;
    private List<zzaih> zzl;
    private zzah<zzao> zzm;

    public final long zza() {
        return this.zzh;
    }

    public final long zzb() {
        return this.zzi;
    }

    public final Uri zzc() {
        if (TextUtils.isEmpty(this.zze)) {
            return null;
        }
        return Uri.parse(this.zze);
    }

    public final zzah<zzao> zzd() {
        return this.zzm;
    }

    public final zzc zze() {
        return this.zzk;
    }

    public final zzaht zza(zzc zzcVar) {
        this.zzk = zzcVar;
        return this;
    }

    public final zzaht zza(String str) {
        this.zzd = str;
        return this;
    }

    public final zzaht zzb(String str) {
        this.zzb = str;
        return this;
    }

    public final zzaht zza(boolean z) {
        this.zzj = z;
        return this;
    }

    public final zzaht zza(zzah<zzao> zzahVar) {
        Preconditions.checkNotNull(zzahVar);
        this.zzm = zzahVar;
        return this;
    }

    public final zzaht zzc(String str) {
        this.zze = str;
        return this;
    }

    public final zzaht zza(List<zzaig> list) {
        Preconditions.checkNotNull(list);
        zzaij zzaijVar = new zzaij();
        this.zzf = zzaijVar;
        zzaijVar.zza().addAll(list);
        return this;
    }

    public final zzaij zzf() {
        return this.zzf;
    }

    public final String zzg() {
        return this.zzd;
    }

    public final String zzh() {
        return this.zzb;
    }

    public final String zzi() {
        return this.zza;
    }

    public final String zzj() {
        return this.zzg;
    }

    public final List<zzaih> zzk() {
        return this.zzl;
    }

    public final List<zzaig> zzl() {
        return this.zzf.zza();
    }

    public zzaht() {
        this.zzf = new zzaij();
        this.zzm = zzah.zzg();
    }

    public zzaht(String str, String str2, boolean z, String str3, String str4, zzaij zzaijVar, String str5, String str6, long j, long j2, boolean z2, zzc zzcVar, List<zzaih> list, zzah<zzao> zzahVar) {
        zzaij zzaijVar2;
        this.zza = str;
        this.zzb = str2;
        this.zzc = z;
        this.zzd = str3;
        this.zze = str4;
        if (zzaijVar == null) {
            zzaijVar2 = new zzaij();
        } else {
            List<zzaig> listZza = zzaijVar.zza();
            zzaij zzaijVar3 = new zzaij();
            if (listZza != null) {
                zzaijVar3.zza().addAll(listZza);
            }
            zzaijVar2 = zzaijVar3;
        }
        this.zzf = zzaijVar2;
        this.zzg = str6;
        this.zzh = j;
        this.zzi = j2;
        this.zzj = false;
        this.zzk = null;
        this.zzl = list == null ? new ArrayList<>() : list;
        this.zzm = zzahVar;
    }

    public final boolean zzm() {
        return this.zzc;
    }

    public final boolean zzn() {
        return this.zzj;
    }
}
