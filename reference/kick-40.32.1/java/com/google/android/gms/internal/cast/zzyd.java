package com.google.android.gms.internal.cast;

import com.google.android.gms.internal.cast.zzya;
import com.google.android.gms.internal.cast.zzyd;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzyd<MessageType extends zzyd<MessageType, BuilderType>, BuilderType extends zzya<MessageType, BuilderType>> extends zzwz<MessageType, BuilderType> {
    private static final Map zzd = new ConcurrentHashMap();
    private int zzb = -1;
    protected zzaae zzc = zzaae.zza();

    static zzyd zzF(Class cls) {
        Map map = zzd;
        zzyd zzydVar = (zzyd) map.get(cls);
        if (zzydVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzydVar = (zzyd) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzydVar != null) {
            return zzydVar;
        }
        zzyd zzydVar2 = (zzyd) ((zzyd) zzaak.zzc(cls)).zzb(6, null, null);
        if (zzydVar2 == null) {
            throw new IllegalStateException();
        }
        map.put(cls, zzydVar2);
        return zzydVar2;
    }

    protected static void zzG(Class cls, zzyd zzydVar) {
        zzydVar.zzw();
        zzd.put(cls, zzydVar);
    }

    protected static Object zzH(zzzi zzziVar, String str, Object[] objArr) {
        return new zzzr(zzziVar, str, objArr);
    }

    static Object zzI(Method method, Object obj, Object... objArr) {
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

    protected static zzyj zzJ() {
        return zzye.zzd();
    }

    protected static zzyk zzK() {
        return zzyx.zzd();
    }

    protected static zzyi zzL() {
        return zzxy.zzd();
    }

    protected static zzyl zzM() {
        return zzzq.zzd();
    }

    protected static zzyl zzN(zzyl zzylVar) {
        int size = zzylVar.size();
        return zzylVar.zzf(size + size);
    }

    private final int zza(zzzs zzzsVar) {
        return zzzp.zza().zzb(getClass()).zze(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean zzc(zzyd zzydVar, boolean z) {
        byte bByteValue = ((Byte) zzydVar.zzb(1, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzh = zzzp.zza().zzb(zzydVar.getClass()).zzh(zzydVar);
        if (z) {
            zzydVar.zzb(2, true != zZzh ? null : zzydVar, null);
        }
        return zZzh;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzzp.zza().zzb(getClass()).zzb(this, (zzyd) obj);
    }

    public final int hashCode() {
        if (zzv()) {
            return zzz();
        }
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int iZzz = zzz();
        this.zza = iZzz;
        return iZzz;
    }

    public final String toString() {
        return zzzk.zza(this, super.toString());
    }

    protected final void zzA() {
        zzzp.zza().zzb(getClass()).zzg(this);
        zzw();
    }

    protected final zzya zzB() {
        return (zzya) zzb(5, null, null);
    }

    final void zzC(int i) {
        this.zzb = (this.zzb & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    @Override // com.google.android.gms.internal.cast.zzzi
    public final void zzD(zzxp zzxpVar) throws IOException {
        zzzp.zza().zzb(getClass()).zzf(this, zzxq.zza(zzxpVar));
    }

    @Override // com.google.android.gms.internal.cast.zzzi
    public final /* synthetic */ zzzh zzO() {
        return (zzya) zzb(5, null, null);
    }

    protected abstract Object zzb(int i, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.cast.zzzj
    public final boolean zzr() {
        return zzc(this, true);
    }

    @Override // com.google.android.gms.internal.cast.zzwz
    final int zzt(zzzs zzzsVar) {
        if (zzv()) {
            int iZze = zzzsVar.zze(this);
            if (iZze >= 0) {
                return iZze;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(iZze).length() + 42);
            sb.append("serialized size must be non-negative, was ");
            sb.append(iZze);
            throw new IllegalStateException(sb.toString());
        }
        int i = this.zzb & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int iZze2 = zzzsVar.zze(this);
        if (iZze2 >= 0) {
            this.zzb = (this.zzb & Integer.MIN_VALUE) | iZze2;
            return iZze2;
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(iZze2).length() + 42);
        sb2.append("serialized size must be non-negative, was ");
        sb2.append(iZze2);
        throw new IllegalStateException(sb2.toString());
    }

    final boolean zzv() {
        return (this.zzb & Integer.MIN_VALUE) != 0;
    }

    final void zzw() {
        this.zzb &= Integer.MAX_VALUE;
    }

    @Override // com.google.android.gms.internal.cast.zzzj
    public final /* synthetic */ zzzi zzx() {
        return (zzyd) zzb(6, null, null);
    }

    final zzyd zzy() {
        return (zzyd) zzb(4, null, null);
    }

    final int zzz() {
        return zzzp.zza().zzb(getClass()).zzc(this);
    }

    @Override // com.google.android.gms.internal.cast.zzzi
    public final int zzE() {
        if (zzv()) {
            int iZza = zza(null);
            if (iZza >= 0) {
                return iZza;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(iZza).length() + 42);
            sb.append("serialized size must be non-negative, was ");
            sb.append(iZza);
            throw new IllegalStateException(sb.toString());
        }
        int i = this.zzb & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int iZza2 = zza(null);
        if (iZza2 >= 0) {
            this.zzb = (this.zzb & Integer.MIN_VALUE) | iZza2;
            return iZza2;
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(iZza2).length() + 42);
        sb2.append("serialized size must be non-negative, was ");
        sb2.append(iZza2);
        throw new IllegalStateException(sb2.toString());
    }
}
