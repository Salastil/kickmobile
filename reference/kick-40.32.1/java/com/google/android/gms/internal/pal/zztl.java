package com.google.android.gms.internal.pal;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zztl extends zzto {
    final char[] zza;

    private zztl(zztk zztkVar) {
        super(zztkVar, null);
        this.zza = new char[512];
        zzls.zza(zztkVar.zzf().length == 16);
        for (int i = 0; i < 256; i++) {
            this.zza[i] = zztkVar.zza(i >>> 4);
            this.zza[i | 256] = zztkVar.zza(i & 15);
        }
    }

    @Override // com.google.android.gms.internal.pal.zzto, com.google.android.gms.internal.pal.zztp
    final void zza(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        zzls.zzj(0, i2, bArr.length);
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = bArr[i3] & 255;
            char[] cArr = this.zza;
            appendable.append(cArr[i4]);
            appendable.append(cArr[i4 | 256]);
        }
    }

    @Override // com.google.android.gms.internal.pal.zzto, com.google.android.gms.internal.pal.zztp
    final int zzb(byte[] bArr, CharSequence charSequence) throws zztn {
        if (charSequence.length() % 2 == 1) {
            int length = charSequence.length();
            StringBuilder sb = new StringBuilder(String.valueOf(length).length() + 21);
            sb.append("Invalid input length ");
            sb.append(length);
            throw new zztn(sb.toString());
        }
        int i = 0;
        int i2 = 0;
        while (i < charSequence.length()) {
            zztk zztkVar = this.zzb;
            bArr[i2] = (byte) (zztkVar.zzc(charSequence.charAt(i + 1)) | (zztkVar.zzc(charSequence.charAt(i)) << 4));
            i += 2;
            i2++;
        }
        return i2;
    }

    @Override // com.google.android.gms.internal.pal.zzto
    final zztp zzc(zztk zztkVar, Character ch) {
        return new zztl(zztkVar);
    }

    zztl(String str, String str2) {
        this(new zztk("base16()", new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'}));
    }
}
