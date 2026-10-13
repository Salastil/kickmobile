package com.google.android.gms.internal.pal;

import java.io.IOException;
import java.math.RoundingMode;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
class zzto extends zztp {
    private volatile zztp zza;
    final zztk zzb;
    final Character zzc;

    zzto(zztk zztkVar, Character ch) {
        this.zzb = zztkVar;
        boolean z = true;
        if (ch != null) {
            ch.charValue();
            if (zztkVar.zze('=')) {
                z = false;
            }
        }
        zzls.zzd(z, "Padding character %s was already in alphabet", ch);
        this.zzc = ch;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzto) {
            zzto zztoVar = (zzto) obj;
            if (this.zzb.equals(zztoVar.zzb) && Objects.equals(this.zzc, zztoVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.zzb.hashCode() ^ Objects.hashCode(this.zzc);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BaseEncoding.");
        zztk zztkVar = this.zzb;
        sb.append(zztkVar);
        if (8 % zztkVar.zzb != 0) {
            Character ch = this.zzc;
            if (ch == null) {
                sb.append(".omitPadding()");
            } else {
                sb.append(".withPadChar('");
                sb.append(ch);
                sb.append("')");
            }
        }
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.pal.zztp
    void zza(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        zzls.zzj(0, i2, bArr.length);
        while (i3 < i2) {
            int i4 = this.zzb.zzd;
            zze(appendable, bArr, i3, Math.min(i4, i2 - i3));
            i3 += i4;
        }
    }

    @Override // com.google.android.gms.internal.pal.zztp
    int zzb(byte[] bArr, CharSequence charSequence) throws zztn {
        int i;
        CharSequence charSequenceZzg = zzg(charSequence);
        int length = charSequenceZzg.length();
        zztk zztkVar = this.zzb;
        if (!zztkVar.zzb(length)) {
            int length2 = charSequenceZzg.length();
            StringBuilder sb = new StringBuilder(String.valueOf(length2).length() + 21);
            sb.append("Invalid input length ");
            sb.append(length2);
            throw new zztn(sb.toString());
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 < charSequenceZzg.length()) {
            long jZzc = 0;
            int i4 = 0;
            int i5 = 0;
            while (true) {
                i = zztkVar.zzc;
                if (i4 >= i) {
                    break;
                }
                jZzc <<= zztkVar.zzb;
                if (i2 + i4 < charSequenceZzg.length()) {
                    jZzc |= (long) zztkVar.zzc(charSequenceZzg.charAt(i5 + i2));
                    i5++;
                }
                i4++;
            }
            int i6 = zztkVar.zzd;
            int i7 = i5 * zztkVar.zzb;
            int i8 = (i6 - 1) * 8;
            while (i8 >= (i6 * 8) - i7) {
                bArr[i3] = (byte) ((jZzc >>> i8) & 255);
                i8 -= 8;
                i3++;
            }
            i2 += i;
        }
        return i3;
    }

    zztp zzc(zztk zztkVar, Character ch) {
        return new zzto(zztkVar, ch);
    }

    @Override // com.google.android.gms.internal.pal.zztp
    final int zzd(int i) {
        zztk zztkVar = this.zzb;
        return zztkVar.zzc * zzts.zzb(i, zztkVar.zzd, RoundingMode.CEILING);
    }

    final void zze(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        zzls.zzj(i, i + i2, bArr.length);
        zztk zztkVar = this.zzb;
        int i3 = zztkVar.zzd;
        int i4 = 0;
        zzls.zza(i2 <= i3);
        long j = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            j = (j | ((long) (bArr[i + i5] & 255))) << 8;
        }
        int i6 = (i2 + 1) * 8;
        int i7 = zztkVar.zzb;
        while (i4 < i2 * 8) {
            appendable.append(zztkVar.zza(zztkVar.zza & ((int) (j >>> ((i6 - i7) - i4)))));
            i4 += i7;
        }
        Character ch = this.zzc;
        if (ch != null) {
            while (i4 < i3 * 8) {
                ch.charValue();
                appendable.append('=');
                i4 += i7;
            }
        }
    }

    @Override // com.google.android.gms.internal.pal.zztp
    final int zzf(int i) {
        return (int) (((((long) this.zzb.zzb) * ((long) i)) + 7) / 8);
    }

    @Override // com.google.android.gms.internal.pal.zztp
    public final zztp zzh() {
        zztp zztpVarZzc = this.zza;
        if (zztpVarZzc == null) {
            zztk zztkVar = this.zzb;
            zztk zztkVarZzd = zztkVar.zzd();
            zztpVarZzc = zztkVarZzd == zztkVar ? this : zzc(zztkVarZzd, this.zzc);
            this.zza = zztpVarZzc;
        }
        return zztpVarZzc;
    }

    zzto(String str, String str2, Character ch) {
        this(new zztk(str, str2.toCharArray()), ch);
    }

    @Override // com.google.android.gms.internal.pal.zztp
    final CharSequence zzg(CharSequence charSequence) {
        charSequence.getClass();
        Character ch = this.zzc;
        if (ch == null) {
            return charSequence;
        }
        ch.charValue();
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                break;
            }
        } while (charSequence.charAt(length) == '=');
        return charSequence.subSequence(0, length + 1);
    }
}
