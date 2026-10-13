package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzlv extends zzlz {
    zzlv(zzmb zzmbVar, CharSequence charSequence, int i) {
        super(zzmbVar, charSequence);
    }

    @Override // com.google.android.gms.internal.pal.zzlz
    public final int zzc(int i) {
        int i2 = i + 4000;
        if (i2 < this.zza.length()) {
            return i2;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.pal.zzlz
    public final int zzd(int i) {
        return i;
    }
}
