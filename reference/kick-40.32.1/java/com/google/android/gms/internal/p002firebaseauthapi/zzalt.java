package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.firebase-auth-api.zzalt.zza;
import com.google.android.gms.internal.p002firebaseauthapi.zzalt;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzalt<MessageType extends zzalt<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzaju<MessageType, BuilderType> {
    private static final Map<Class<?>, zzalt<?, ?>> zzc = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzaoa zzb = zzaoa.zzc();

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    public static abstract class zzb<MessageType extends zzb<MessageType, BuilderType>, BuilderType> extends zzalt<MessageType, BuilderType> implements zzamx {
        protected zzalm<zze> zzc = zzalm.zzb();

        final zzalm<zze> zza() {
            if (this.zzc.zzb) {
                this.zzc = (zzalm) this.zzc.clone();
            }
            return this.zzc;
        }
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    protected static class zzc<T extends zzalt<T, ?>> extends zzajw<T> {
        public zzc(T t) {
        }
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    public static class zzd<ContainingType extends zzamv, Type> extends zzalg<ContainingType, Type> {
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    static final class zze implements zzalo<zze> {
        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalo
        public final int zza() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalo
        public final zzaoj zzb() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalo
        public final zzaoq zzc() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalo
        public final void zza(Object obj, Object obj2) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalo
        public final boolean zza(Object obj) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalo
        public final boolean zzd() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalo
        public final boolean zze() {
            throw new NoSuchMethodError();
        }
    }

    private final int zza() {
        return zzank.zza().zza(this).zzb(this);
    }

    static /* synthetic */ boolean zza(zzalt zzaltVar, boolean z) {
        return zzb(zzaltVar, false);
    }

    protected abstract Object zza(int i, Object obj, Object obj2);

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    public static abstract class zza<MessageType extends zzalt<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzajt<MessageType, BuilderType> {
        protected MessageType zza;
        private final MessageType zzb;

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajt
        /* JADX INFO: renamed from: zzb */
        public final /* synthetic */ zzajt clone() {
            return (zza) clone();
        }

        public final BuilderType zza(MessageType messagetype) {
            if (messagetype != null && !this.zzb.getClass().isInstance(messagetype)) {
                throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
            }
            if (this.zzb.equals(messagetype)) {
                return this;
            }
            if (!this.zza.zzu()) {
                zzi();
            }
            zza(this.zza, messagetype);
            return this;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamy
        /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
        public final MessageType zze() {
            MessageType messagetype = (MessageType) zzf();
            if (messagetype.zzj()) {
                return messagetype;
            }
            throw new zzany(messagetype);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamy
        /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
        public MessageType zzf() {
            boolean zZzu = this.zza.zzu();
            MessageType messagetype = this.zza;
            if (!zZzu) {
                return messagetype;
            }
            messagetype.zzs();
            return this.zza;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamx
        public final /* synthetic */ zzamv zzg() {
            return this.zzb;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajt
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza zzaVar = (zza) this.zzb.zza(zzf.zze, null, null);
            zzaVar.zza = (MessageType) zzf();
            return zzaVar;
        }

        protected zza(MessageType messagetype) {
            this.zzb = messagetype;
            if (messagetype.zzu()) {
                throw new IllegalArgumentException("Default instance must be immutable.");
            }
            this.zza = (MessageType) messagetype.zzo();
        }

        protected final void zzh() {
            if (this.zza.zzu()) {
                return;
            }
            zzi();
        }

        protected void zzi() {
            MessageType messagetype = (MessageType) this.zzb.zzo();
            zza(messagetype, this.zza);
            this.zza = messagetype;
        }

        private static <MessageType extends zzalt<?, ?>> void zza(MessageType messagetype, MessageType messagetype2) {
            zzank.zza().zza(messagetype).zza(messagetype, messagetype2);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamx
        public final boolean zzj() {
            return zzalt.zza((zzalt) this.zza, false);
        }
    }

    private final int zzb(zzanl<?> zzanlVar) {
        if (zzanlVar == null) {
            return zzank.zza().zza(this).zza(this);
        }
        return zzanlVar.zza(this);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaju
    final int zzi() {
        return this.zzd & Integer.MAX_VALUE;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamv
    public final int zzl() {
        return zza((zzanl) null);
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    public static final enum zzf {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        public static final int zzg = 7;
        private static final /* synthetic */ int[] zzh = {1, 2, 3, 4, 5, 6, 7};

        public static int[] zza() {
            return (int[]) zzh.clone();
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaju
    final int zza(zzanl zzanlVar) {
        if (zzu()) {
            int iZzb = zzb(zzanlVar);
            if (iZzb >= 0) {
                return iZzb;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + iZzb);
        }
        if (zzi() != Integer.MAX_VALUE) {
            return zzi();
        }
        int iZzb2 = zzb(zzanlVar);
        zza(iZzb2);
        return iZzb2;
    }

    public int hashCode() {
        if (zzu()) {
            return zza();
        }
        if (this.zza == 0) {
            this.zza = zza();
        }
        return this.zza;
    }

    protected final <MessageType2 extends zzalt<MessageType2, BuilderType2>, BuilderType2 extends zza<MessageType2, BuilderType2>> BuilderType2 zzm() {
        return (BuilderType2) zza(zzf.zze, (Object) null, (Object) null);
    }

    public final BuilderType zzn() {
        return (BuilderType) ((zza) zza(zzf.zze, (Object) null, (Object) null)).zza(this);
    }

    private static <T extends zzalt<T, ?>> T zza(T t) throws zzamd {
        if (t == null || zzb(t, true)) {
            return t;
        }
        zzamd zzamdVarZza = new zzany(t).zza();
        zzamdVarZza.getClass();
        throw zzamdVarZza;
    }

    static <T extends zzalt<?, ?>> T zza(Class<T> cls) {
        Map<Class<?>, zzalt<?, ?>> map = zzc;
        T t = (T) map.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (T) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t != null) {
            return t;
        }
        T t2 = (T) ((zzalt) zzaoc.zza(cls)).zza(zzf.zzf, (Object) null, (Object) null);
        if (t2 == null) {
            throw new IllegalStateException();
        }
        map.put((Class<?>) cls, t2);
        return t2;
    }

    final MessageType zzo() {
        return (MessageType) zza(zzf.zzd, (Object) null, (Object) null);
    }

    protected static <T extends zzalt<T, ?>> T zza(T t, zzakb zzakbVar, zzalf zzalfVar) throws zzamd {
        return (T) zza(zzb(t, zzakbVar, zzalfVar));
    }

    protected static <T extends zzalt<T, ?>> T zza(T t, InputStream inputStream, zzalf zzalfVar) throws zzamd {
        zzakn zzakuVar;
        if (inputStream == null) {
            byte[] bArr = zzalw.zza;
            zzakuVar = zzakn.zza(bArr, 0, bArr.length, false);
        } else {
            zzakuVar = new zzaku(inputStream);
        }
        return (T) zza(zza(t, zzakuVar, zzalfVar));
    }

    protected static <T extends zzalt<T, ?>> T zza(T t, byte[] bArr, zzalf zzalfVar) throws zzamd {
        return (T) zza(zza(t, bArr, 0, bArr.length, zzalfVar));
    }

    private static <T extends zzalt<T, ?>> T zzb(T t, zzakb zzakbVar, zzalf zzalfVar) throws zzamd {
        zzakn zzaknVarZzb = zzakbVar.zzb();
        T t2 = (T) zza(t, zzaknVarZzb, zzalfVar);
        zzaknVarZzb.zzc(0);
        return t2;
    }

    private static <T extends zzalt<T, ?>> T zza(T t, zzakn zzaknVar, zzalf zzalfVar) throws zzamd {
        T t2 = (T) t.zzo();
        try {
            zzanl zzanlVarZza = zzank.zza().zza(t2);
            zzanlVarZza.zza(t2, zzakw.zza(zzaknVar), zzalfVar);
            zzanlVarZza.zzd(t2);
            return t2;
        } catch (zzamd e) {
            if (e.zzl()) {
                throw new zzamd(e);
            }
            throw e;
        } catch (zzany e2) {
            zzamd zzamdVarZza = e2.zza();
            zzamdVarZza.getClass();
            throw zzamdVarZza;
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzamd) {
                throw ((zzamd) e3.getCause());
            }
            throw new zzamd(e3);
        } catch (RuntimeException e4) {
            if (e4.getCause() instanceof zzamd) {
                throw ((zzamd) e4.getCause());
            }
            throw e4;
        }
    }

    private static <T extends zzalt<T, ?>> T zza(T t, byte[] bArr, int i, int i2, zzalf zzalfVar) throws zzamd {
        if (i2 == 0) {
            return t;
        }
        T t2 = (T) t.zzo();
        try {
            zzanl zzanlVarZza = zzank.zza().zza(t2);
            zzanlVarZza.zza(t2, bArr, 0, i2, new zzaka(zzalfVar));
            zzanlVarZza.zzd(t2);
            return t2;
        } catch (zzamd e) {
            if (e.zzl()) {
                throw new zzamd(e);
            }
            throw e;
        } catch (zzany e2) {
            zzamd zzamdVarZza = e2.zza();
            zzamdVarZza.getClass();
            throw zzamdVarZza;
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzamd) {
                throw ((zzamd) e3.getCause());
            }
            throw new zzamd(e3);
        } catch (IndexOutOfBoundsException unused) {
            zzamd zzamdVarZzj = zzamd.zzj();
            zzamdVarZzj.getClass();
            throw zzamdVarZzj;
        }
    }

    protected static <E> zzalx<E> zzp() {
        return zzanj.zzd();
    }

    protected static <E> zzalx<E> zza(zzalx<E> zzalxVar) {
        return zzalxVar.zza(zzalxVar.size() << 1);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamv
    public final /* synthetic */ zzamy zzq() {
        return (zza) zza(zzf.zze, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamv
    public final /* synthetic */ zzamy zzr() {
        return ((zza) zza(zzf.zze, (Object) null, (Object) null)).zza(this);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamx
    public final /* synthetic */ zzamv zzg() {
        return (zzalt) zza(zzf.zzf, (Object) null, (Object) null);
    }

    static Object zza(Method method, Object obj, Object... objArr) {
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

    protected static Object zza(zzamv zzamvVar, String str, Object[] objArr) {
        return new zzanm(zzamvVar, str, objArr);
    }

    public String toString() {
        return zzana.zza(this, super.toString());
    }

    protected final void zzs() {
        zzank.zza().zza(this).zzd(this);
        zzt();
    }

    final void zzt() {
        this.zzd &= Integer.MAX_VALUE;
    }

    protected static <T extends zzalt<?, ?>> void zza(Class<T> cls, T t) {
        t.zzt();
        zzc.put(cls, t);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaju
    final void zza(int i) {
        if (i < 0) {
            throw new IllegalStateException("serialized size must be non-negative, was " + i);
        }
        this.zzd = (i & Integer.MAX_VALUE) | (this.zzd & Integer.MIN_VALUE);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamv
    public final void zza(zzaky zzakyVar) throws IOException {
        zzank.zza().zza(this).zza(this, zzale.zza(zzakyVar));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzank.zza().zza(this).zzb(this, (zzalt) obj);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamx
    public final boolean zzj() {
        return zzb(this, true);
    }

    private static final <T extends zzalt<T, ?>> boolean zzb(T t, boolean z) {
        byte bByteValue = ((Byte) t.zza(zzf.zza, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZze = zzank.zza().zza(t).zze(t);
        if (z) {
            t.zza(zzf.zzb, zZze ? t : null, null);
        }
        return zZze;
    }

    final boolean zzu() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }
}
