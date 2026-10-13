package com.google.android.gms.internal.pal;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzarz extends zzarv {
    private final Object zza;

    public zzarz(Boolean bool) {
        this.zza = Objects.requireNonNull(bool);
    }

    private static boolean zzl(zzarz zzarzVar) {
        Object obj = zzarzVar.zza;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzarz zzarzVar = (zzarz) obj;
        Object obj2 = this.zza;
        if (obj2 == null) {
            return zzarzVar.zza == null;
        }
        if (zzl(this) && zzl(zzarzVar)) {
            if ((obj2 instanceof BigInteger) || (zzarzVar.zza instanceof BigInteger)) {
                return zzk().equals(zzarzVar.zzk());
            }
            return zzh().longValue() == zzarzVar.zzh().longValue();
        }
        if (obj2 instanceof Number) {
            Object obj3 = zzarzVar.zza;
            if (obj3 instanceof Number) {
                if ((obj2 instanceof BigDecimal) && (obj3 instanceof BigDecimal)) {
                    return zzj().compareTo(zzarzVar.zzj()) == 0;
                }
                double dZzi = zzi();
                double dZzi2 = zzarzVar.zzi();
                if (dZzi != dZzi2) {
                    return Double.isNaN(dZzi) && Double.isNaN(dZzi2);
                }
                return true;
            }
        }
        return obj2.equals(zzarzVar.zza);
    }

    public final int hashCode() {
        long jDoubleToLongBits;
        Object obj = this.zza;
        if (obj == null) {
            return 31;
        }
        if (zzl(this)) {
            jDoubleToLongBits = zzh().longValue();
        } else {
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            jDoubleToLongBits = Double.doubleToLongBits(zzh().doubleValue());
        }
        return (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
    }

    public final boolean zza() {
        return this.zza instanceof Boolean;
    }

    public final boolean zzb() {
        Object obj = this.zza;
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : Boolean.parseBoolean(zzd());
    }

    public final boolean zzc() {
        return this.zza instanceof Number;
    }

    @Override // com.google.android.gms.internal.pal.zzarv
    public final String zzd() {
        Object obj = this.zza;
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof Number) {
            return zzh().toString();
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).toString();
        }
        String strValueOf = String.valueOf(obj.getClass());
        String.valueOf(strValueOf);
        throw new AssertionError("Unexpected value type: ".concat(String.valueOf(strValueOf)));
    }

    public final Number zzh() {
        Object obj = this.zza;
        if (obj instanceof Number) {
            return (Number) obj;
        }
        if (obj instanceof String) {
            return new zzasd((String) obj);
        }
        throw new UnsupportedOperationException("Primitive is neither a number nor a string");
    }

    public final double zzi() {
        return this.zza instanceof Number ? zzh().doubleValue() : Double.parseDouble(zzd());
    }

    public final BigDecimal zzj() {
        Object obj = this.zza;
        return obj instanceof BigDecimal ? (BigDecimal) obj : zzasm.zza(zzd());
    }

    public final BigInteger zzk() {
        Object obj = this.zza;
        if (obj instanceof BigInteger) {
            return (BigInteger) obj;
        }
        return zzl(this) ? BigInteger.valueOf(zzh().longValue()) : zzasm.zzb(zzd());
    }

    public zzarz(Number number) {
        this.zza = Objects.requireNonNull(number);
    }

    public zzarz(String str) {
        this.zza = Objects.requireNonNull(str);
    }
}
