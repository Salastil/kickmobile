package com.google.android.gms.internal.pal;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaej extends zzafh {
    private final zzaeh zza;
    private final zzaeg zzb;
    private final zzaed zzc;
    private final zzaei zzd;

    /* synthetic */ zzaej(zzaeh zzaehVar, zzaeg zzaegVar, zzaed zzaedVar, zzaei zzaeiVar, byte[] bArr) {
        this.zza = zzaehVar;
        this.zzb = zzaegVar;
        this.zzc = zzaedVar;
        this.zzd = zzaeiVar;
    }

    public static zzaef zzb() {
        return new zzaef(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzaej)) {
            return false;
        }
        zzaej zzaejVar = (zzaej) obj;
        return this.zza == zzaejVar.zza && this.zzb == zzaejVar.zzb && this.zzc == zzaejVar.zzc && this.zzd == zzaejVar.zzd;
    }

    public final int hashCode() {
        return Objects.hash(zzaej.class, this.zza, this.zzb, this.zzc, this.zzd);
    }

    public final String toString() {
        String string = this.zzd.toString();
        int length = string.length();
        String string2 = this.zza.toString();
        int length2 = string2.length();
        String string3 = this.zzb.toString();
        int length3 = string3.length();
        String string4 = this.zzc.toString();
        StringBuilder sb = new StringBuilder(length + 35 + length2 + 9 + length3 + 10 + string4.length() + 1);
        sb.append("HPKE Parameters (Variant: ");
        sb.append(string);
        sb.append(", KemId: ");
        sb.append(string2);
        sb.append(", KdfId: ");
        sb.append(string3);
        sb.append(", AeadId: ");
        sb.append(string4);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.pal.zzwk
    public final boolean zza() {
        throw null;
    }

    public final zzaeh zzc() {
        return this.zza;
    }

    public final zzaeg zzd() {
        return this.zzb;
    }

    public final zzaed zze() {
        return this.zzc;
    }

    public final zzaei zzf() {
        return this.zzd;
    }
}
