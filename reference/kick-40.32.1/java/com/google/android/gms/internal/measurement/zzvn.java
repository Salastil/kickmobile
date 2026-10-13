package com.google.android.gms.internal.measurement;

import android.text.TextUtils;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
abstract class zzvn implements zzws {
    private final zzws zza;
    private final UUID zzb;
    private final String zzc;
    private final String zzd;
    private Thread zze;

    zzvn(String str, zzws zzwsVar, zzwq zzwqVar) {
        this.zzd = (String) Preconditions.checkNotNull(str);
        this.zza = zzwsVar;
        this.zzb = zzwsVar.zzc();
        this.zzc = zzwsVar.zzd();
        zzxb zzxbVar = zzwqVar.zzc;
        this.zze = Thread.currentThread();
    }

    public static String zzcL(UUID uuid) {
        String string = Long.toString(uuid.getLeastSignificantBits() >>> 1, 36);
        String.valueOf(string);
        return "tk-trace-id: ".concat(String.valueOf(string));
    }

    @Override // com.google.android.gms.internal.measurement.zzwt, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        int i = zzvy.zzb;
        Preconditions.checkNotNull(this);
        zzwq zzwqVarZzd = zzvy.zzd();
        zzws zzwsVar = zzwqVarZzd.zzb;
        if (zzwsVar == null) {
            String strZze = zze();
            StringBuilder sb = new StringBuilder(String.valueOf(strZze).length() + 101);
            sb.append("Tried to end [");
            sb.append(strZze);
            sb.append("], but no trace was active. This is caused by mismatched or missing calls to beginSpan.");
            throw new zzvv(sb.toString());
        }
        if (this == zzwsVar) {
            zzvy.zzc(zzwqVarZzd, zzwsVar.zzb());
            this.zze = null;
            return;
        }
        String strZze2 = zze();
        String strZze3 = zzwsVar.zze();
        StringBuilder sb2 = new StringBuilder(String.valueOf(strZze2).length() + 79 + String.valueOf(strZze3).length() + 1);
        sb2.append("Tried to end span ");
        sb2.append(strZze2);
        sb2.append(", but that span is not the current span. The current span is ");
        sb2.append(strZze3);
        sb2.append(".");
        throw new zzvw(sb2.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.google.android.gms.internal.measurement.zzvn] */
    /* JADX WARN: Type inference failed for: r11v1, types: [com.google.android.gms.internal.measurement.zzws] */
    /* JADX WARN: Type inference failed for: r11v3, types: [com.google.android.gms.internal.measurement.zzws] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.android.gms.internal.measurement.zzws] */
    /* JADX WARN: Type inference failed for: r1v21, types: [com.google.android.gms.internal.measurement.zzws] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [com.google.android.gms.internal.measurement.zzws] */
    /* JADX WARN: Type inference failed for: r6v11 */
    public final String toString() {
        String strConcat;
        int i = zzvy.zzb;
        ?? Zzb = this;
        int i2 = 0;
        int length = 0;
        while (Zzb != 0) {
            i2++;
            length += Zzb.zze().length();
            Zzb = Zzb.zzb();
            if (Zzb != 0) {
                length += 4;
            }
        }
        if (i2 > 250) {
            int i3 = i2 - 1;
            String[] strArr = new String[i2];
            ?? Zzb2 = this;
            while (i3 >= 0) {
                strArr[i3] = Zzb2.zze();
                i3--;
                Zzb2 = Zzb2.zzb();
            }
            ImmutableMap.Builder builder = ImmutableMap.builder();
            UnmodifiableIterator it = ImmutableSet.copyOf(strArr).iterator();
            int i4 = 0;
            while (it.hasNext()) {
                builder.put(it.next(), Integer.valueOf(i4));
                i4++;
            }
            ImmutableMap immutableMapBuildOrThrow = builder.buildOrThrow();
            int i5 = i2 >> 2;
            zzwo zzwoVar = null;
            if (immutableMapBuildOrThrow.size() <= i5) {
                int[] iArr = new int[i2 + 1];
                for (int i6 = 0; i6 < i2; i6++) {
                    iArr[i6] = ((Integer) immutableMapBuildOrThrow.get(strArr[i6])).intValue();
                }
                iArr[i2] = immutableMapBuildOrThrow.size();
                zzwo zzwoVarZzd = zzwp.zza(iArr).zzd();
                if (zzwoVarZzd.zzc * (zzwoVarZzd.zzb - zzwoVarZzd.zza) >= i5) {
                    zzwoVar = zzwoVarZzd;
                }
            }
            String strConcat2 = "";
            if (zzwoVar != null) {
                int i7 = zzwoVar.zza;
                if (i7 > 0) {
                    String strJoin = TextUtils.join(" -> ", Arrays.copyOf(strArr, i7));
                    String.valueOf(strJoin);
                    strConcat = String.valueOf(strJoin).concat(" -> ");
                } else {
                    strConcat = "";
                }
                int i8 = zzwoVar.zzb;
                int i9 = zzwoVar.zzc;
                int i10 = ((i8 - i7) * i9) + i7;
                if (i10 < i2) {
                    String strJoin2 = TextUtils.join(" -> ", Arrays.copyOfRange(strArr, i10, i2));
                    String.valueOf(strJoin2);
                    strConcat2 = " -> ".concat(String.valueOf(strJoin2));
                }
                strConcat2 = String.format(Locale.US, "%s{%s}x%d%s", strConcat, TextUtils.join(" -> ", Arrays.copyOfRange(strArr, i7, i8)), Integer.valueOf(i9), strConcat2);
            }
            if (!strConcat2.isEmpty()) {
                return strConcat2;
            }
        }
        char[] cArr = new char[length];
        while (this != 0) {
            String strZze = this.zze();
            length -= strZze.length();
            strZze.getChars(0, strZze.length(), cArr, length);
            this = this.zzb();
            if (this != 0) {
                length -= 4;
                " -> ".getChars(0, 4, cArr, length);
            }
        }
        return new String(cArr);
    }

    @Override // com.google.android.gms.internal.measurement.zzws
    public final Thread zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.measurement.zzws
    public final zzws zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzws
    public final UUID zzc() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.measurement.zzws
    public final String zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzws
    public final String zze() {
        return this.zzd;
    }

    zzvn(String str, UUID uuid, String str2, zzwq zzwqVar) {
        this.zzd = (String) Preconditions.checkNotNull(str);
        this.zza = null;
        this.zzb = uuid;
        this.zzc = str2;
        zzxb zzxbVar = zzwqVar.zzc;
        this.zze = Thread.currentThread();
    }
}
