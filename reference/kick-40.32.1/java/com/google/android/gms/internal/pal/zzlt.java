package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzlt extends zzlq {
    private final Object zza;

    zzlt(Object obj) {
        this.zza = obj;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzlt) {
            return this.zza.equals(((zzlt) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() + 1502476572;
    }

    public final String toString() {
        String string = this.zza.toString();
        StringBuilder sb = new StringBuilder(string.length() + 13);
        sb.append("Optional.of(");
        sb.append(string);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.pal.zzlq
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.pal.zzlq
    public final Object zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.pal.zzlq
    public final Object zzc(Object obj) {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.pal.zzlq
    public final zzlq zzd(zzlo zzloVar) {
        return new zzlt(zzloVar.zza(this.zza));
    }
}
