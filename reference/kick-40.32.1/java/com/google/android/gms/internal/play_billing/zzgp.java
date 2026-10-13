package com.google.android.gms.internal.play_billing;

import com.google.android.gms.internal.play_billing.zzgl;
import com.google.android.gms.internal.play_billing.zzgp;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzgp<MessageType extends zzgp<MessageType, BuilderType>, BuilderType extends zzgl<MessageType, BuilderType>> extends zzfa<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzir zzc = zzir.zzc();

    protected static void zzB(Class cls, zzgp zzgpVar) {
        zzgpVar.zzA();
        zzb.put(cls, zzgpVar);
    }

    private final int zza(zzib zzibVar) {
        return zzhy.zza().zzb(getClass()).zza(this);
    }

    private static zzgp zzb(zzgp zzgpVar, byte[] bArr, int i, int i2, zzgc zzgcVar) throws zzhb {
        if (i2 == 0) {
            return zzgpVar;
        }
        zzgp zzgpVarZzs = zzgpVar.zzs();
        try {
            zzib zzibVarZzb = zzhy.zza().zzb(zzgpVarZzs.getClass());
            zzibVarZzb.zzh(zzgpVarZzs, bArr, 0, i2, new zzfd(zzgcVar));
            zzibVarZzb.zzf(zzgpVarZzs);
            return zzgpVarZzs;
        } catch (zzhb e) {
            throw e;
        } catch (zzip e2) {
            throw e2.zza();
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzhb) {
                throw ((zzhb) e3.getCause());
            }
            throw new zzhb(e3);
        } catch (IndexOutOfBoundsException unused) {
            throw new zzhb("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean zzc(zzgp zzgpVar, boolean z) {
        byte bByteValue = ((Byte) zzgpVar.zzd(1, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzk = zzhy.zza().zzb(zzgpVar.getClass()).zzk(zzgpVar);
        if (z) {
            zzgpVar.zzd(2, true != zZzk ? null : zzgpVar, null);
        }
        return zZzk;
    }

    static zzgp zzr(Class cls) {
        Map map = zzb;
        zzgp zzgpVar = (zzgp) map.get(cls);
        if (zzgpVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzgpVar = (zzgp) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzgpVar != null) {
            return zzgpVar;
        }
        zzgp zzgpVar2 = (zzgp) ((zzgp) zzix.zze(cls)).zzd(6, null, null);
        if (zzgpVar2 == null) {
            throw new IllegalStateException();
        }
        map.put(cls, zzgpVar2);
        return zzgpVar2;
    }

    protected static zzgp zzt(zzgp zzgpVar, byte[] bArr) throws zzhb {
        int length = bArr.length;
        int i = zzgc.zzb;
        int i2 = zzfc.zza;
        zzgp zzgpVarZzb = zzb(zzgpVar, bArr, 0, length, zzgc.zza);
        if (zzgpVarZzb == null || zzc(zzgpVarZzb, true)) {
            return zzgpVarZzb;
        }
        throw new zzip(zzgpVarZzb).zza();
    }

    protected static zzgt zzu() {
        return zzgq.zzf();
    }

    protected static zzgu zzv() {
        return zzhz.zze();
    }

    static Object zzx(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    protected static Object zzy(zzhr zzhrVar, String str, Object[] objArr) {
        return new zzia(zzhrVar, str, objArr);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzhy.zza().zzb(getClass()).zzj(this, (zzgp) obj);
    }

    public final int hashCode() {
        if (zzF()) {
            return zzm();
        }
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int iZzm = zzm();
        this.zza = iZzm;
        return iZzm;
    }

    public final String toString() {
        return zzht.zza(this, super.toString());
    }

    final void zzA() {
        this.zzd &= Integer.MAX_VALUE;
    }

    final void zzC(int i) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    @Override // com.google.android.gms.internal.play_billing.zzhr
    public final void zzD(zzfx zzfxVar) throws IOException {
        zzhy.zza().zzb(getClass()).zzi(this, zzfy.zza(zzfxVar));
    }

    final boolean zzF() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    protected abstract Object zzd(int i, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.play_billing.zzfa
    final int zzi(zzib zzibVar) {
        if (zzF()) {
            int iZza = zzibVar.zza(this);
            if (iZza >= 0) {
                return iZza;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + iZza);
        }
        int i = this.zzd & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int iZza2 = zzibVar.zza(this);
        if (iZza2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | iZza2;
            return iZza2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + iZza2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhs
    public final /* synthetic */ zzhr zzl() {
        return (zzgp) zzd(6, null, null);
    }

    final int zzm() {
        return zzhy.zza().zzb(getClass()).zzb(this);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhs
    public final boolean zzo() {
        return zzc(this, true);
    }

    protected final zzgl zzp() {
        return (zzgl) zzd(5, null, null);
    }

    public final zzgl zzq() {
        zzgl zzglVar = (zzgl) zzd(5, null, null);
        zzglVar.zzh(this);
        return zzglVar;
    }

    final zzgp zzs() {
        return (zzgp) zzd(4, null, null);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhr
    public final /* synthetic */ zzhq zzw() {
        return (zzgl) zzd(5, null, null);
    }

    protected final void zzz() {
        zzhy.zza().zzb(getClass()).zzf(this);
        zzA();
    }

    @Override // com.google.android.gms.internal.play_billing.zzhr
    public final int zzn() {
        if (zzF()) {
            int iZza = zza(null);
            if (iZza >= 0) {
                return iZza;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + iZza);
        }
        int i = this.zzd & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int iZza2 = zza(null);
        if (iZza2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | iZza2;
            return iZza2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + iZza2);
    }
}
