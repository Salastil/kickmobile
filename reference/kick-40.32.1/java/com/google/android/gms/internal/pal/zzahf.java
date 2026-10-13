package com.google.android.gms.internal.pal;

import java.io.IOException;
import java.util.ArrayDeque;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzahf extends zzasb {
    public static final zzarv zza(zzass zzassVar) throws IOException {
        String strZzh;
        int iZzm = zzassVar.zzm();
        zzarv zzarvVarZzc = zzc(zzassVar, iZzm);
        if (zzarvVarZzc == null) {
            return zzb(zzassVar, iZzm);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (zzassVar.zzf()) {
                if (zzarvVarZzc instanceof zzarx) {
                    strZzh = zzassVar.zzh();
                    if (!zzahh.zza(strZzh)) {
                        throw new IOException("illegal characters in string");
                    }
                } else {
                    strZzh = null;
                }
                int iZzm2 = zzassVar.zzm();
                zzarv zzarvVarZzc2 = zzc(zzassVar, iZzm2);
                zzarv zzarvVarZzb = zzarvVarZzc2 == null ? zzb(zzassVar, iZzm2) : zzarvVarZzc2;
                if (zzarvVarZzc instanceof zzaru) {
                    ((zzaru) zzarvVarZzc).zza(zzarvVarZzb);
                } else {
                    zzarx zzarxVar = (zzarx) zzarvVarZzc;
                    if (zzarxVar.zzc(strZzh)) {
                        String.valueOf(strZzh);
                        throw new IOException("duplicate key: ".concat(String.valueOf(strZzh)));
                    }
                    zzarxVar.zza(strZzh, zzarvVarZzb);
                }
                if (zzarvVarZzc2 != null) {
                    arrayDeque.addLast(zzarvVarZzc);
                    if (arrayDeque.size() > 100) {
                        throw new IOException("too many recursions");
                    }
                    zzarvVarZzc = zzarvVarZzb;
                } else {
                    continue;
                }
            } else {
                if (zzarvVarZzc instanceof zzaru) {
                    zzassVar.zzc();
                } else {
                    zzassVar.zze();
                }
                if (arrayDeque.isEmpty()) {
                    return zzarvVarZzc;
                }
                zzarvVarZzc = (zzarv) arrayDeque.removeLast();
            }
        }
    }

    private static final zzarv zzb(zzass zzassVar, int i) throws IOException {
        int i2 = i - 1;
        if (i2 == 5) {
            String strZzi = zzassVar.zzi();
            if (zzahh.zza(strZzi)) {
                return new zzarz(strZzi);
            }
            throw new IOException("illegal characters in string");
        }
        if (i2 == 6) {
            return new zzarz(new zzahg(zzassVar.zzi()));
        }
        if (i2 == 7) {
            return new zzarz(Boolean.valueOf(zzassVar.zzj()));
        }
        if (i2 != 8) {
            throw new IllegalStateException("Unexpected token: ".concat(zzast.zza(i)));
        }
        zzassVar.zzk();
        return zzarw.zza;
    }

    @Nullable
    private static final zzarv zzc(zzass zzassVar, int i) throws IOException {
        int i2 = i - 1;
        if (i2 == 0) {
            zzassVar.zzb();
            return new zzaru();
        }
        if (i2 != 2) {
            return null;
        }
        zzassVar.zzd();
        return new zzarx();
    }
}
