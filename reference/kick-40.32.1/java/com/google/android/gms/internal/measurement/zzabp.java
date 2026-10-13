package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzabp extends zzabn {
    private static final String zza;

    static {
        String property;
        try {
            property = System.getProperty("line.separator");
            if (!property.matches("\\n|\\r(?:\\n)?")) {
                property = "\n";
            }
        } catch (SecurityException unused) {
        }
        zza = property;
    }

    static int zze(String str, int i) throws zzabo {
        while (i < str.length()) {
            int i2 = i + 1;
            if (str.charAt(i) != '%') {
                i = i2;
            } else {
                if (i2 >= str.length()) {
                    throw zzabo.zzc("trailing unquoted '%' character", str, i);
                }
                char cCharAt = str.charAt(i2);
                if (cCharAt != '%' && cCharAt != 'n') {
                    return i;
                }
                i += 2;
            }
        }
        return -1;
    }

    abstract int zzb(zzabm zzabmVar, int i, String str, int i2, int i3, int i4) throws zzabo;

    @Override // com.google.android.gms.internal.measurement.zzabn
    protected final void zzc(zzabm zzabmVar) throws zzabo {
        int i;
        char cCharAt;
        int i2;
        int i3;
        int i4;
        int i5;
        String strZzi = zzabmVar.zzi();
        int iZze = zze(strZzi, 0);
        int i6 = 0;
        int i7 = -1;
        while (iZze >= 0) {
            int i8 = iZze + 1;
            int i9 = i8;
            int i10 = 0;
            while (true) {
                if (i9 >= strZzi.length()) {
                    throw zzabo.zzc("unterminated parameter", strZzi, iZze);
                }
                i = i9 + 1;
                cCharAt = strZzi.charAt(i9);
                char c = (char) (cCharAt - '0');
                if (c < '\n') {
                    i10 = (i10 * 10) + c;
                    if (i10 >= 1000000) {
                        throw zzabo.zza("index too large", strZzi, iZze, i);
                    }
                    i9 = i;
                }
            }
            if (cCharAt == '$') {
                if (i9 - i8 == 0) {
                    throw zzabo.zza("missing index", strZzi, iZze, i);
                }
                if (strZzi.charAt(i8) == '0') {
                    throw zzabo.zza("index has leading zero", strZzi, iZze, i);
                }
                int i11 = i10 - 1;
                if (i == strZzi.length()) {
                    throw zzabo.zzc("unterminated parameter", strZzi, iZze);
                }
                strZzi.charAt(i);
                i5 = i6;
                i4 = i9 + 2;
                i2 = i;
                i3 = i11;
            } else if (cCharAt != '<') {
                int i12 = i6 + 1;
                i2 = i8;
                i3 = i6;
                i4 = i;
                i5 = i12;
            } else {
                if (i7 == -1) {
                    throw zzabo.zza("invalid relative parameter", strZzi, iZze, i);
                }
                if (i == strZzi.length()) {
                    throw zzabo.zzc("unterminated parameter", strZzi, iZze);
                }
                strZzi.charAt(i);
                i5 = i6;
                i4 = i9 + 2;
                i2 = i;
                i3 = i7;
            }
            int i13 = i4 - 1;
            while (true) {
                if (i13 >= strZzi.length()) {
                    throw zzabo.zzc("unterminated parameter", strZzi, iZze);
                }
                if (((char) ((strZzi.charAt(i13) & (-33)) - 65)) < 26) {
                    break;
                } else {
                    i13++;
                }
            }
            zzabp zzabpVar = this;
            iZze = zze(strZzi, zzabpVar.zzb(zzabmVar, i3, strZzi, iZze, i2, i13));
            this = zzabpVar;
            i7 = i3;
            i6 = i5;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzabn
    public final void zzd(StringBuilder sb, String str, int i, int i2) {
        int i3 = i;
        while (i < i2) {
            int i4 = i + 1;
            if (str.charAt(i) == '%') {
                if (i4 == i2) {
                    break;
                }
                char cCharAt = str.charAt(i4);
                if (cCharAt == '%') {
                    sb.append((CharSequence) str, i3, i4);
                } else if (cCharAt == 'n') {
                    sb.append((CharSequence) str, i3, i);
                    sb.append(zza);
                }
                i3 = i + 2;
                i = i3;
            }
            i = i4;
        }
        if (i3 < i2) {
            sb.append((CharSequence) str, i3, i2);
        }
    }
}
