package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzagg {
    static final long zza;
    static final boolean zzb;
    private static final Unsafe zzc;
    private static final Class zzd;
    private static final boolean zze;
    private static final zzagf zzf;
    private static final boolean zzg;

    static {
        boolean z;
        zzagf zzagfVar;
        Unsafe unsafeZzp = zzp();
        zzc = unsafeZzp;
        int i = zzacf.zza;
        zzd = Memory.class;
        boolean zZzq = zzq(Long.TYPE);
        zze = zZzq;
        boolean zZzq2 = zzq(Integer.TYPE);
        zzagf zzagdVar = null;
        if (unsafeZzp != null) {
            if (zZzq) {
                zzagdVar = new zzage(unsafeZzp);
            } else if (zZzq2) {
                zzagdVar = new zzagd(unsafeZzp);
            }
        }
        zzf = zzagdVar;
        if (zzagdVar != null) {
            try {
                Class<?> cls = zzagdVar.zza.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                cls.getMethod("getLong", Object.class, Long.TYPE);
                zzA();
            } catch (Throwable th) {
                zzx(th);
            }
        }
        zzagf zzagfVar2 = zzf;
        if (zzagfVar2 == null) {
            z = false;
        } else {
            try {
                Class<?> cls2 = zzagfVar2.zza.getClass();
                cls2.getMethod("objectFieldOffset", Field.class);
                cls2.getMethod("arrayBaseOffset", Class.class);
                cls2.getMethod("arrayIndexScale", Class.class);
                cls2.getMethod("getInt", Object.class, Long.TYPE);
                cls2.getMethod("putInt", Object.class, Long.TYPE, Integer.TYPE);
                cls2.getMethod("getLong", Object.class, Long.TYPE);
                cls2.getMethod("putLong", Object.class, Long.TYPE, Long.TYPE);
                cls2.getMethod("getObject", Object.class, Long.TYPE);
                cls2.getMethod("putObject", Object.class, Long.TYPE, Object.class);
                z = true;
            } catch (Throwable th2) {
                zzx(th2);
                z = false;
            }
        }
        zzg = z;
        zza = zzy(byte[].class);
        zzy(boolean[].class);
        zzz(boolean[].class);
        zzy(int[].class);
        zzz(int[].class);
        zzy(long[].class);
        zzz(long[].class);
        zzy(float[].class);
        zzz(float[].class);
        zzy(double[].class);
        zzz(double[].class);
        zzy(Object[].class);
        zzz(Object[].class);
        Field fieldZzA = zzA();
        if (fieldZzA != null && (zzagfVar = zzf) != null) {
            zzagfVar.zza.objectFieldOffset(fieldZzA);
        }
        zzb = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    private zzagg() {
    }

    private static Field zzA() {
        int i = zzacf.zza;
        Field fieldZzB = zzB(Buffer.class, "effectiveDirectAddress");
        if (fieldZzB != null) {
            return fieldZzB;
        }
        Field fieldZzB2 = zzB(Buffer.class, "address");
        if (fieldZzB2 == null || fieldZzB2.getType() != Long.TYPE) {
            return null;
        }
        return fieldZzB2;
    }

    private static Field zzB(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzC(Object obj, long j, byte b) {
        Unsafe unsafe = zzf.zza;
        long j2 = (-4) & j;
        int i = unsafe.getInt(obj, j2);
        int i2 = ((~((int) j)) & 3) << 3;
        unsafe.putInt(obj, j2, ((255 & b) << i2) | (i & (~(255 << i2))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzD(Object obj, long j, byte b) {
        Unsafe unsafe = zzf.zza;
        long j2 = (-4) & j;
        int i = (((int) j) & 3) << 3;
        unsafe.putInt(obj, j2, ((255 & b) << i) | (unsafe.getInt(obj, j2) & (~(255 << i))));
    }

    static boolean zza() {
        return zzg;
    }

    static Object zzb(Class cls) {
        try {
            return zzc.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    static int zzc(Object obj, long j) {
        return zzf.zza.getInt(obj, j);
    }

    static void zzd(Object obj, long j, int i) {
        zzf.zza.putInt(obj, j, i);
    }

    static long zze(Object obj, long j) {
        return zzf.zza.getLong(obj, j);
    }

    static void zzf(Object obj, long j, long j2) {
        zzf.zza.putLong(obj, j, j2);
    }

    static boolean zzg(Object obj, long j) {
        return zzf.zzb(obj, j);
    }

    static void zzh(Object obj, long j, boolean z) {
        zzf.zzc(obj, j, z);
    }

    static float zzi(Object obj, long j) {
        return zzf.zzd(obj, j);
    }

    static void zzj(Object obj, long j, float f) {
        zzf.zze(obj, j, f);
    }

    static double zzk(Object obj, long j) {
        return zzf.zzf(obj, j);
    }

    static void zzl(Object obj, long j, double d) {
        zzf.zzg(obj, j, d);
    }

    static Object zzm(Object obj, long j) {
        return zzf.zza.getObject(obj, j);
    }

    static void zzn(Object obj, long j, Object obj2) {
        zzf.zza.putObject(obj, j, obj2);
    }

    static void zzo(byte[] bArr, long j, byte b) {
        zzf.zza(bArr, zza + j, b);
    }

    static Unsafe zzp() {
        Unsafe unsafe;
        try {
            unsafe = (Unsafe) AccessController.doPrivileged(new zzagc());
        } catch (Throwable unused) {
            unsafe = null;
        }
        if (unsafe == null) {
            return null;
        }
        try {
            unsafe.arrayBaseOffset(byte[].class);
            return unsafe;
        } catch (Exception unused2) {
            Logger.getLogger(zzagg.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "getUnsafe", "As part of the planned removal, sun.misc.Unsafe is available in the current environment but configured to throw on use. Protobuf will continue without using it, but with slightly reduced performance. --sun-misc-unsafe-memory-access=allow is likely available to opt back in if desired. A later Protobuf version release will stop using sun.misc.Unsafe entirely.");
            return null;
        }
    }

    static boolean zzq(Class cls) {
        int i = zzacf.zza;
        try {
            Class cls2 = zzd;
            cls2.getMethod("peekLong", cls, Boolean.TYPE);
            cls2.getMethod("pokeLong", cls, Long.TYPE, Boolean.TYPE);
            cls2.getMethod("pokeInt", cls, Integer.TYPE, Boolean.TYPE);
            cls2.getMethod("peekInt", cls, Boolean.TYPE);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, Integer.TYPE, Integer.TYPE);
            cls2.getMethod("peekByteArray", cls, byte[].class, Integer.TYPE, Integer.TYPE);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    static /* synthetic */ boolean zzt(Object obj, long j) {
        return ((byte) ((zzf.zza.getInt(obj, (-4) & j) >>> ((int) (((~j) & 3) << 3))) & 255)) != 0;
    }

    static /* synthetic */ boolean zzu(Object obj, long j) {
        return ((byte) ((zzf.zza.getInt(obj, (-4) & j) >>> ((int) ((j & 3) << 3))) & 255)) != 0;
    }

    static /* synthetic */ void zzx(Throwable th) {
        Logger.getLogger(zzagg.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(th.toString()));
    }

    private static int zzy(Class cls) {
        if (zzg) {
            return zzf.zza.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzz(Class cls) {
        if (zzg) {
            return zzf.zza.arrayIndexScale(cls);
        }
        return -1;
    }
}
