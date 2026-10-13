package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzzc {

    @Nullable
    private zzze zza;

    @Nullable
    private String zzb;

    @Nullable
    private zzzd zzc;

    @Nullable
    private zzwr zzd;

    private zzzc() {
        throw null;
    }

    /* synthetic */ zzzc(byte[] bArr) {
    }

    public final zzzc zza(zzze zzzeVar) {
        this.zza = zzzeVar;
        return this;
    }

    public final zzzc zzb(String str) {
        this.zzb = str;
        return this;
    }

    public final zzzc zzc(zzzd zzzdVar) {
        this.zzc = zzzdVar;
        return this;
    }

    public final zzzc zzd(zzwr zzwrVar) {
        this.zzd = zzwrVar;
        return this;
    }

    public final zzzf zze() throws GeneralSecurityException {
        if (this.zza == null) {
            this.zza = zzze.zzb;
        }
        if (this.zzb == null) {
            throw new GeneralSecurityException("kekUri must be set");
        }
        zzzd zzzdVar = this.zzc;
        if (zzzdVar == null) {
            throw new GeneralSecurityException("dekParsingStrategy must be set");
        }
        zzwr zzwrVar = this.zzd;
        if (zzwrVar == null) {
            throw new GeneralSecurityException("dekParametersForNewKeys must be set");
        }
        if (zzwrVar.zza()) {
            throw new GeneralSecurityException("dekParametersForNewKeys must not have ID Requirements");
        }
        if ((zzzdVar.equals(zzzd.zza) && (zzwrVar instanceof zzxw)) || ((zzzdVar.equals(zzzd.zzc) && (zzwrVar instanceof zzyl)) || ((zzzdVar.equals(zzzd.zzb) && (zzwrVar instanceof zzaah)) || ((zzzdVar.equals(zzzd.zzd) && (zzwrVar instanceof zzxf)) || ((zzzdVar.equals(zzzd.zze) && (zzwrVar instanceof zzxn)) || (zzzdVar.equals(zzzd.zzf) && (zzwrVar instanceof zzyf))))))) {
            return new zzzf(this.zza, this.zzb, this.zzc, this.zzd, null);
        }
        String string = this.zzc.toString();
        String strValueOf = String.valueOf(this.zzd);
        StringBuilder sb = new StringBuilder(string.length() + 67 + String.valueOf(strValueOf).length() + 1);
        sb.append("Cannot use parsing strategy ");
        sb.append(string);
        sb.append(" when new keys are picked according to ");
        sb.append(strValueOf);
        sb.append(".");
        throw new GeneralSecurityException(sb.toString());
    }
}
