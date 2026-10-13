package com.google.android.gms.internal.pal;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.Formattable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzqm extends zzta implements zzsw {
    protected final Object[] zza;
    protected final StringBuilder zzb;
    private int zzc;

    protected zzqm(zzrt zzrtVar, Object[] objArr, StringBuilder sb) {
        super(zzrtVar);
        this.zzc = 0;
        this.zza = objArr;
        this.zzb = sb;
    }

    public static StringBuilder zza(zzqr zzqrVar, StringBuilder sb) {
        if (zzqrVar.zzh() == null) {
            sb.append(zzqv.zza(zzqrVar.zzj()));
            return sb;
        }
        zzqm zzqmVar = new zzqm(zzqrVar.zzh(), zzqrVar.zzi(), sb);
        StringBuilder sb2 = (StringBuilder) zzqmVar.zzl();
        zzqrVar.zzi();
        if (zzqmVar.zzj() <= 0) {
            sb2.append(" [ERROR: UNUSED LOG ARGUMENTS]");
        }
        return sb2;
    }

    private static void zzm(StringBuilder sb, Object obj, String str) {
        sb.append("[INVALID: format=");
        sb.append(str);
        sb.append(", type=");
        sb.append(obj.getClass().getCanonicalName());
        sb.append(", value=");
        sb.append(zzqv.zza(obj));
        sb.append("]");
    }

    @Override // com.google.android.gms.internal.pal.zzta
    public final void zzb(int i, int i2, zzsv zzsvVar) {
        zzh().zzd(this.zzb, zzi(), this.zzc, i);
        zzsvVar.zze(this, this.zza);
        this.zzc = i2;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0024  */
    /* JADX WARN: Code duplicated, block: B:32:0x0041  */
    /* JADX WARN: Code duplicated, block: B:69:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:71:0x00b9  */
    @Override // com.google.android.gms.internal.pal.zzsw
    public final void zzc(Object obj, zzqn zzqnVar, zzqo zzqoVar) {
        boolean zIsValidCodePoint;
        int iOrdinal = zzqnVar.zzc().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                zIsValidCodePoint = obj instanceof Boolean;
            } else if (iOrdinal != 2) {
                if (iOrdinal != 3) {
                    if (iOrdinal != 4) {
                        throw null;
                    }
                    if ((obj instanceof Double) || (obj instanceof Float) || (obj instanceof BigDecimal)) {
                        zIsValidCodePoint = true;
                    } else {
                        zIsValidCodePoint = false;
                    }
                } else if ((obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof BigInteger)) {
                    zIsValidCodePoint = true;
                } else {
                    zIsValidCodePoint = false;
                }
            } else if (obj instanceof Character) {
                zIsValidCodePoint = true;
            } else if ((obj instanceof Integer) || (obj instanceof Byte) || (obj instanceof Short)) {
                zIsValidCodePoint = Character.isValidCodePoint(((Number) obj).intValue());
            } else {
                zIsValidCodePoint = false;
            }
            if (!zIsValidCodePoint) {
                zzm(this.zzb, obj, zzqnVar.zze());
                return;
            }
        }
        StringBuilder sb = this.zzb;
        int iOrdinal2 = zzqnVar.ordinal();
        if (iOrdinal2 != 0) {
            if (iOrdinal2 == 1) {
                if (zzqoVar.zze()) {
                    sb.append(obj);
                    return;
                }
            } else if (iOrdinal2 != 2) {
                if (iOrdinal2 != 3) {
                    if (iOrdinal2 == 5 && zzqoVar.zzd(128, false, false).equals(zzqoVar)) {
                        zzqv.zzc(sb, (Number) obj, zzqoVar);
                        return;
                    }
                } else if (zzqoVar.zze()) {
                    sb.append(obj);
                    return;
                }
            } else if (zzqoVar.zze()) {
                if (obj instanceof Character) {
                    sb.append(obj);
                    return;
                }
                int iIntValue = ((Number) obj).intValue();
                if ((iIntValue >>> 16) == 0) {
                    sb.append((char) iIntValue);
                    return;
                } else {
                    sb.append(Character.toChars(iIntValue));
                    return;
                }
            }
        } else if (obj instanceof Formattable) {
            zzqv.zzb((Formattable) obj, sb, zzqoVar);
            return;
        } else if (zzqoVar.zze()) {
            sb.append(zzqv.zza(obj));
            return;
        }
        String strZze = zzqnVar.zze();
        if (!zzqoVar.zze()) {
            int iZzb = zzqnVar.zzb();
            if (zzqoVar.zzk()) {
                iZzb &= 65503;
            }
            StringBuilder sb2 = new StringBuilder("%");
            zzqoVar.zzl(sb2);
            sb2.append((char) iZzb);
            strZze = sb2.toString();
        }
        sb.append(String.format(zzqv.zza, strZze, obj));
    }

    @Override // com.google.android.gms.internal.pal.zzsw
    public final void zzd(Object obj, zzst zzstVar, zzqo zzqoVar) {
        if ((obj instanceof Date) || (obj instanceof Calendar) || (obj instanceof Long)) {
            StringBuilder sb = new StringBuilder("%");
            zzqoVar.zzl(sb);
            sb.append(true != zzqoVar.zzk() ? 't' : 'T');
            sb.append(zzstVar.zzb());
            this.zzb.append(String.format(zzqv.zza, sb.toString(), obj));
            return;
        }
        StringBuilder sb2 = this.zzb;
        char cZzb = zzstVar.zzb();
        StringBuilder sb3 = new StringBuilder(String.valueOf(cZzb).length() + 2);
        sb3.append("%t");
        sb3.append(cZzb);
        zzm(sb2, obj, sb3.toString());
    }

    @Override // com.google.android.gms.internal.pal.zzsw
    public final void zze() {
        this.zzb.append("[ERROR: MISSING LOG ARGUMENT]");
    }

    @Override // com.google.android.gms.internal.pal.zzsw
    public final void zzf() {
        this.zzb.append(AbstractJsonLexerKt.NULL);
    }

    @Override // com.google.android.gms.internal.pal.zzta
    public final /* bridge */ /* synthetic */ Object zzg() {
        zztb zztbVarZzh = zzh();
        String strZzi = zzi();
        int i = this.zzc;
        int length = zzi().length();
        StringBuilder sb = this.zzb;
        zztbVarZzh.zzd(sb, strZzi, i, length);
        return sb;
    }
}
