package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
abstract class zzlz extends zzlh {
    final CharSequence zza;
    int zzb = 0;
    int zzc = Integer.MAX_VALUE;

    zzlz(zzmb zzmbVar, CharSequence charSequence) {
        this.zza = charSequence;
    }

    @Override // com.google.android.gms.internal.pal.zzlh
    protected final /* bridge */ /* synthetic */ Object zza() {
        int iZzd;
        int i = this.zzb;
        while (true) {
            int i2 = this.zzb;
            if (i2 == -1) {
                zzb();
                return null;
            }
            int iZzc = zzc(i2);
            if (iZzc == -1) {
                iZzc = this.zza.length();
                this.zzb = -1;
                iZzd = -1;
            } else {
                iZzd = zzd(iZzc);
                this.zzb = iZzd;
            }
            if (iZzd != i) {
                if (i < iZzc) {
                    this.zza.charAt(i);
                }
                if (i < iZzc) {
                    this.zza.charAt(iZzc - 1);
                }
                int i3 = this.zzc;
                if (i3 == 1) {
                    CharSequence charSequence = this.zza;
                    int length = charSequence.length();
                    this.zzb = -1;
                    if (length > i) {
                        charSequence.charAt(length - 1);
                    }
                    iZzc = length;
                } else {
                    this.zzc = i3 - 1;
                }
                return this.zza.subSequence(i, iZzc).toString();
            }
            int i4 = iZzd + 1;
            this.zzb = i4;
            if (i4 > this.zza.length()) {
                this.zzb = -1;
            }
        }
    }

    abstract int zzc(int i);

    abstract int zzd(int i);
}
