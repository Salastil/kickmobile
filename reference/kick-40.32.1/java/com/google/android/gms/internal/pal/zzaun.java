package com.google.android.gms.internal.pal;

import com.google.android.gms.internal.pal.zzaui;
import com.google.android.gms.internal.pal.zzaun;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzaun<MessageType extends zzaun<MessageType, BuilderType>, BuilderType extends zzaui<MessageType, BuilderType>> extends zzasx<MessageType, BuilderType> {
    private static final Map zzd = new ConcurrentHashMap();
    private int zza = -1;
    protected zzaxb zzc = zzaxb.zza();

    private final int zza(zzawn zzawnVar) {
        return zzawf.zza().zzb(getClass()).zze(this);
    }

    static zzaun zzaC(Class cls) {
        Map map = zzd;
        zzaun zzaunVar = (zzaun) map.get(cls);
        if (zzaunVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzaunVar = (zzaun) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzaunVar != null) {
            return zzaunVar;
        }
        zzaun zzaunVar2 = (zzaun) ((zzaun) zzaxh.zzc(cls)).zzl(6, null, null);
        if (zzaunVar2 == null) {
            throw new IllegalStateException();
        }
        map.put(cls, zzaunVar2);
        return zzaunVar2;
    }

    protected static void zzaD(Class cls, zzaun zzaunVar) {
        zzaunVar.zzau();
        zzd.put(cls, zzaunVar);
    }

    protected static Object zzaE(zzavw zzavwVar, String str, Object[] objArr) {
        return new zzawh(zzavwVar, str, objArr);
    }

    static Object zzaF(Method method, Object obj, Object... objArr) {
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

    protected static zzauu zzaG() {
        return zzauo.zzd();
    }

    protected static zzauu zzaH(zzauu zzauuVar) {
        int size = zzauuVar.size();
        return zzauuVar.zzg(size + size);
    }

    protected static zzaux zzaI() {
        return zzavl.zzd();
    }

    protected static zzauy zzaJ() {
        return zzawg.zzd();
    }

    protected static zzauy zzaK(zzauy zzauyVar) {
        int size = zzauyVar.size();
        return zzauyVar.zzg(size + size);
    }

    protected static zzaun zzaL(zzaun zzaunVar, zzatl zzatlVar) throws zzavb {
        int i = zzaty.zzb;
        int i2 = zzata.zza;
        zzaty zzatyVar = zzaty.zza;
        zzatp zzatpVarZzk = zzatlVar.zzk();
        zzaun zzaunVarZzav = zzaunVar.zzav();
        try {
            zzawn zzawnVarZzb = zzawf.zza().zzb(zzaunVarZzav.getClass());
            zzawnVarZzb.zzg(zzaunVarZzav, zzatq.zza(zzatpVarZzk), zzatyVar);
            zzawnVarZzb.zzk(zzaunVarZzav);
            zzatpVarZzk.zzb(0);
            zzd(zzaunVarZzav);
            zzd(zzaunVarZzav);
            return zzaunVarZzav;
        } catch (zzavb e) {
            if (e.zzb()) {
                throw new zzavb(e);
            }
            throw e;
        } catch (zzawz e2) {
            throw e2.zza();
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzavb) {
                throw ((zzavb) e3.getCause());
            }
            throw new zzavb(e3);
        } catch (RuntimeException e4) {
            if (e4.getCause() instanceof zzavb) {
                throw ((zzavb) e4.getCause());
            }
            throw e4;
        }
    }

    protected static zzaun zzaM(zzaun zzaunVar, zzatl zzatlVar, zzaty zzatyVar) throws zzavb {
        zzatp zzatpVarZzk = zzatlVar.zzk();
        zzaun zzaunVarZzav = zzaunVar.zzav();
        try {
            zzawn zzawnVarZzb = zzawf.zza().zzb(zzaunVarZzav.getClass());
            zzawnVarZzb.zzg(zzaunVarZzav, zzatq.zza(zzatpVarZzk), zzatyVar);
            zzawnVarZzb.zzk(zzaunVarZzav);
            zzatpVarZzk.zzb(0);
            zzd(zzaunVarZzav);
            return zzaunVarZzav;
        } catch (zzavb e) {
            if (e.zzb()) {
                throw new zzavb(e);
            }
            throw e;
        } catch (zzawz e2) {
            throw e2.zza();
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzavb) {
                throw ((zzavb) e3.getCause());
            }
            throw new zzavb(e3);
        } catch (RuntimeException e4) {
            if (e4.getCause() instanceof zzavb) {
                throw ((zzavb) e4.getCause());
            }
            throw e4;
        }
    }

    protected static zzaun zzaN(zzaun zzaunVar, byte[] bArr, zzaty zzatyVar) throws zzavb {
        zzaun zzaunVarZzc = zzc(zzaunVar, bArr, 0, bArr.length, zzatyVar);
        zzd(zzaunVarZzc);
        return zzaunVarZzc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean zzb(zzaun zzaunVar, boolean z) {
        byte bByteValue = ((Byte) zzaunVar.zzl(1, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzl = zzawf.zza().zzb(zzaunVar.getClass()).zzl(zzaunVar);
        if (z) {
            zzaunVar.zzl(2, true != zZzl ? null : zzaunVar, null);
        }
        return zZzl;
    }

    private static zzaun zzc(zzaun zzaunVar, byte[] bArr, int i, int i2, zzaty zzatyVar) throws zzavb {
        if (i2 == 0) {
            return zzaunVar;
        }
        zzaun zzaunVarZzav = zzaunVar.zzav();
        try {
            zzawn zzawnVarZzb = zzawf.zza().zzb(zzaunVarZzav.getClass());
            zzawnVarZzb.zzj(zzaunVarZzav, bArr, 0, i2, new zzatb(zzatyVar));
            zzawnVarZzb.zzk(zzaunVarZzav);
            return zzaunVarZzav;
        } catch (zzavb e) {
            if (e.zzb()) {
                throw new zzavb(e);
            }
            throw e;
        } catch (zzawz e2) {
            throw e2.zza();
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzavb) {
                throw ((zzavb) e3.getCause());
            }
            throw new zzavb(e3);
        } catch (IndexOutOfBoundsException unused) {
            throw new zzavb("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    private static zzaun zzd(zzaun zzaunVar) throws zzavb {
        if (zzaunVar == null || zzb(zzaunVar, true)) {
            return zzaunVar;
        }
        throw new zzawz(zzaunVar).zza();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzawf.zza().zzb(getClass()).zzb(this, (zzaun) obj);
    }

    public final int hashCode() {
        if (zzat()) {
            return zzaw();
        }
        int i = this.zzb;
        if (i != 0) {
            return i;
        }
        int iZzaw = zzaw();
        this.zzb = iZzaw;
        return iZzaw;
    }

    public final String toString() {
        return zzavy.zza(this, super.toString());
    }

    @Override // com.google.android.gms.internal.pal.zzavw
    public final void zzaA(zzatt zzattVar) throws IOException {
        zzawf.zza().zzb(getClass()).zzf(this, zzatu.zza(zzattVar));
    }

    @Override // com.google.android.gms.internal.pal.zzavw
    public final /* synthetic */ zzavv zzaO() {
        return (zzaui) zzl(5, null, null);
    }

    @Override // com.google.android.gms.internal.pal.zzavx
    public final boolean zzaR() {
        return zzb(this, true);
    }

    @Override // com.google.android.gms.internal.pal.zzavx
    public final /* synthetic */ zzavw zzap() {
        return (zzaun) zzl(6, null, null);
    }

    @Override // com.google.android.gms.internal.pal.zzasx
    final int zzar(zzawn zzawnVar) {
        if (zzat()) {
            int iZze = zzawnVar.zze(this);
            if (iZze >= 0) {
                return iZze;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(iZze).length() + 42);
            sb.append("serialized size must be non-negative, was ");
            sb.append(iZze);
            throw new IllegalStateException(sb.toString());
        }
        int i = this.zza & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int iZze2 = zzawnVar.zze(this);
        if (iZze2 >= 0) {
            this.zza = (this.zza & Integer.MIN_VALUE) | iZze2;
            return iZze2;
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(iZze2).length() + 42);
        sb2.append("serialized size must be non-negative, was ");
        sb2.append(iZze2);
        throw new IllegalStateException(sb2.toString());
    }

    final boolean zzat() {
        return (this.zza & Integer.MIN_VALUE) != 0;
    }

    final void zzau() {
        this.zza &= Integer.MAX_VALUE;
    }

    final zzaun zzav() {
        return (zzaun) zzl(4, null, null);
    }

    final int zzaw() {
        return zzawf.zza().zzb(getClass()).zzc(this);
    }

    protected final void zzax() {
        zzawf.zza().zzb(getClass()).zzk(this);
        zzau();
    }

    protected final zzaui zzay() {
        return (zzaui) zzl(5, null, null);
    }

    final void zzaz(int i) {
        this.zza = (this.zza & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    protected abstract Object zzl(int i, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.pal.zzavw
    public final int zzaB() {
        if (zzat()) {
            int iZza = zza(null);
            if (iZza >= 0) {
                return iZza;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(iZza).length() + 42);
            sb.append("serialized size must be non-negative, was ");
            sb.append(iZza);
            throw new IllegalStateException(sb.toString());
        }
        int i = this.zza & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int iZza2 = zza(null);
        if (iZza2 >= 0) {
            this.zza = (this.zza & Integer.MIN_VALUE) | iZza2;
            return iZza2;
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(iZza2).length() + 42);
        sb2.append("serialized size must be non-negative, was ");
        sb2.append(iZza2);
        throw new IllegalStateException(sb2.toString());
    }
}
