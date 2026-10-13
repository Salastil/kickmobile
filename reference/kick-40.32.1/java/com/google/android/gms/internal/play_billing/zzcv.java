package com.google.android.gms.internal.play_billing;

import com.datadog.android.core.internal.metrics.BatchMetricsDispatcher;
import com.datadog.android.webview.internal.log.WebViewLogEventConsumer;
import com.facebook.hermes.intl.Constants;
import io.datazoom.sdk.domain.usecases.GetDeviceInfoUseCaseKt;
import io.ktor.http.LinkHeader;
import io.ktor.sse.ServerSentEventKt;
import java.lang.reflect.Field;
import java.security.PrivilegedExceptionAction;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
abstract class zzcv<V> extends zzdq implements zzdk<V> {
    static final Object zza = new Object();
    static final zzdj zzb = new zzdj(zzcu.class);
    static final boolean zzc;
    private static final zza zzd;
    volatile zzcu.zzd listenersField;
    volatile Object valueField;
    volatile zze waitersField;

    /* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
    abstract class zza {
        /* synthetic */ zza(zzcz zzczVar) {
        }

        abstract zzcu.zzd zza(zzcv zzcvVar, zzcu.zzd zzdVar);

        abstract zze zzb(zzcv zzcvVar, zze zzeVar);

        abstract void zzc(zze zzeVar, zze zzeVar2);

        abstract void zzd(zze zzeVar, Thread thread);

        abstract boolean zze(zzcv zzcvVar, zzcu.zzd zzdVar, zzcu.zzd zzdVar2);

        abstract boolean zzf(zzcv zzcvVar, Object obj, Object obj2);

        abstract boolean zzg(zzcv zzcvVar, zze zzeVar, zze zzeVar2);
    }

    /* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
    final class zzb extends zza {
        private static final AtomicReferenceFieldUpdater<zze, Thread> zza = AtomicReferenceFieldUpdater.newUpdater(zze.class, Thread.class, BatchMetricsDispatcher.THREAD_NAME);
        private static final AtomicReferenceFieldUpdater<zze, zze> zzb = AtomicReferenceFieldUpdater.newUpdater(zze.class, zze.class, LinkHeader.Rel.Next);
        private static final AtomicReferenceFieldUpdater<? super zzcv<?>, zze> zzc = AtomicReferenceFieldUpdater.newUpdater(zzcv.class, zze.class, "waitersField");
        private static final AtomicReferenceFieldUpdater<? super zzcv<?>, zzcu.zzd> zzd = AtomicReferenceFieldUpdater.newUpdater(zzcv.class, zzcu.zzd.class, "listenersField");
        private static final AtomicReferenceFieldUpdater<? super zzcv<?>, Object> zze = AtomicReferenceFieldUpdater.newUpdater(zzcv.class, Object.class, "valueField");

        private zzb() {
            throw null;
        }

        /* synthetic */ zzb(zzcz zzczVar) {
            super(null);
        }

        @Override // com.google.android.gms.internal.play_billing.zzcv.zza
        final zzcu.zzd zza(zzcv zzcvVar, zzcu.zzd zzdVar) {
            return zzd.getAndSet(zzcvVar, zzdVar);
        }

        @Override // com.google.android.gms.internal.play_billing.zzcv.zza
        final zze zzb(zzcv zzcvVar, zze zzeVar) {
            return zzc.getAndSet(zzcvVar, zzeVar);
        }

        @Override // com.google.android.gms.internal.play_billing.zzcv.zza
        final void zzc(zze zzeVar, zze zzeVar2) {
            zzb.lazySet(zzeVar, zzeVar2);
        }

        @Override // com.google.android.gms.internal.play_billing.zzcv.zza
        final void zzd(zze zzeVar, Thread thread) {
            zza.lazySet(zzeVar, thread);
        }

        @Override // com.google.android.gms.internal.play_billing.zzcv.zza
        final boolean zze(zzcv zzcvVar, zzcu.zzd zzdVar, zzcu.zzd zzdVar2) {
            return zzcw.zza(zzd, zzcvVar, zzdVar, zzdVar2);
        }

        @Override // com.google.android.gms.internal.play_billing.zzcv.zza
        final boolean zzf(zzcv zzcvVar, Object obj, Object obj2) {
            return zzcw.zza(zze, zzcvVar, obj, obj2);
        }

        @Override // com.google.android.gms.internal.play_billing.zzcv.zza
        final boolean zzg(zzcv zzcvVar, zze zzeVar, zze zzeVar2) {
            return zzcw.zza(zzc, zzcvVar, zzeVar, zzeVar2);
        }
    }

    /* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
    final class zzc extends zza {
        private zzc() {
            throw null;
        }

        /* synthetic */ zzc(zzcz zzczVar) {
            super(null);
        }

        @Override // com.google.android.gms.internal.play_billing.zzcv.zza
        final zzcu.zzd zza(zzcv zzcvVar, zzcu.zzd zzdVar) {
            zzcu.zzd zzdVar2;
            synchronized (zzcvVar) {
                zzdVar2 = zzcvVar.listenersField;
                if (zzdVar2 != zzdVar) {
                    zzcvVar.listenersField = zzdVar;
                }
            }
            return zzdVar2;
        }

        @Override // com.google.android.gms.internal.play_billing.zzcv.zza
        final zze zzb(zzcv zzcvVar, zze zzeVar) {
            zze zzeVar2;
            synchronized (zzcvVar) {
                zzeVar2 = zzcvVar.waitersField;
                if (zzeVar2 != zzeVar) {
                    zzcvVar.waitersField = zzeVar;
                }
            }
            return zzeVar2;
        }

        @Override // com.google.android.gms.internal.play_billing.zzcv.zza
        final void zzc(zze zzeVar, zze zzeVar2) {
            zzeVar.next = zzeVar2;
        }

        @Override // com.google.android.gms.internal.play_billing.zzcv.zza
        final void zzd(zze zzeVar, Thread thread) {
            zzeVar.thread = thread;
        }

        @Override // com.google.android.gms.internal.play_billing.zzcv.zza
        final boolean zze(zzcv zzcvVar, zzcu.zzd zzdVar, zzcu.zzd zzdVar2) {
            synchronized (zzcvVar) {
                if (zzcvVar.listenersField != zzdVar) {
                    return false;
                }
                zzcvVar.listenersField = zzdVar2;
                return true;
            }
        }

        @Override // com.google.android.gms.internal.play_billing.zzcv.zza
        final boolean zzf(zzcv zzcvVar, Object obj, Object obj2) {
            synchronized (zzcvVar) {
                if (zzcvVar.valueField != obj) {
                    return false;
                }
                zzcvVar.valueField = obj2;
                return true;
            }
        }

        @Override // com.google.android.gms.internal.play_billing.zzcv.zza
        final boolean zzg(zzcv zzcvVar, zze zzeVar, zze zzeVar2) {
            synchronized (zzcvVar) {
                if (zzcvVar.waitersField != zzeVar) {
                    return false;
                }
                zzcvVar.waitersField = zzeVar2;
                return true;
            }
        }
    }

    /* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
    final class zzd extends zza {
        static final Unsafe zza;
        static final long zzb;
        static final long zzc;
        static final long zzd;
        static final long zze;
        static final long zzf;

        static {
            Unsafe unsafeZzh;
            try {
                try {
                    unsafeZzh = Unsafe.getUnsafe();
                } catch (SecurityException unused) {
                    try {
                        unsafeZzh = (Unsafe) Class.forName("java.security.AccessController").getMethod("doPrivileged", PrivilegedExceptionAction.class).invoke(null, new PrivilegedExceptionAction() { // from class: com.google.android.gms.internal.play_billing.zzcy
                            @Override // java.security.PrivilegedExceptionAction
                            public final Object run() {
                                return zzcv.zzd.zzh();
                            }
                        });
                    } catch (Exception unused2) {
                        unsafeZzh = zzh();
                        Unsafe unsafe = unsafeZzh;
                    }
                }
                try {
                    zzc = unsafeZzh.objectFieldOffset(zzcv.class.getDeclaredField("waitersField"));
                    zzb = unsafeZzh.objectFieldOffset(zzcv.class.getDeclaredField("listenersField"));
                    zzd = unsafeZzh.objectFieldOffset(zzcv.class.getDeclaredField("valueField"));
                    zze = unsafeZzh.objectFieldOffset(zze.class.getDeclaredField(BatchMetricsDispatcher.THREAD_NAME));
                    zzf = unsafeZzh.objectFieldOffset(zze.class.getDeclaredField(LinkHeader.Rel.Next));
                    zza = unsafeZzh;
                } catch (NoSuchFieldException e) {
                    throw new RuntimeException(e);
                }
            } catch (Exception e2) {
                throw new RuntimeException("Could not initialize intrinsics", e2);
            }
        }

        private zzd() {
            throw null;
        }

        /* synthetic */ zzd(zzcz zzczVar) {
            super(null);
        }

        static /* synthetic */ Unsafe zzh() throws Exception {
            for (Field field : Unsafe.class.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get(null);
                if (Unsafe.class.isInstance(obj)) {
                    return (Unsafe) Unsafe.class.cast(obj);
                }
            }
            throw new NoSuchFieldError("the Unsafe");
        }

        @Override // com.google.android.gms.internal.play_billing.zzcv.zza
        final zzcu.zzd zza(zzcv zzcvVar, zzcu.zzd zzdVar) {
            zzcu.zzd zzdVar2;
            do {
                zzdVar2 = zzcvVar.listenersField;
                if (zzdVar == zzdVar2) {
                    break;
                }
            } while (!zze(zzcvVar, zzdVar2, zzdVar));
            return zzdVar2;
        }

        @Override // com.google.android.gms.internal.play_billing.zzcv.zza
        final zze zzb(zzcv zzcvVar, zze zzeVar) {
            zze zzeVar2;
            do {
                zzeVar2 = zzcvVar.waitersField;
                if (zzeVar == zzeVar2) {
                    break;
                }
            } while (!zzg(zzcvVar, zzeVar2, zzeVar));
            return zzeVar2;
        }

        @Override // com.google.android.gms.internal.play_billing.zzcv.zza
        final void zzc(zze zzeVar, zze zzeVar2) {
            zza.putObject(zzeVar, zzf, zzeVar2);
        }

        @Override // com.google.android.gms.internal.play_billing.zzcv.zza
        final void zzd(zze zzeVar, Thread thread) {
            zza.putObject(zzeVar, zze, thread);
        }

        @Override // com.google.android.gms.internal.play_billing.zzcv.zza
        final boolean zze(zzcv zzcvVar, zzcu.zzd zzdVar, zzcu.zzd zzdVar2) {
            return zzcx.zza(zza, zzcvVar, zzb, zzdVar, zzdVar2);
        }

        @Override // com.google.android.gms.internal.play_billing.zzcv.zza
        final boolean zzf(zzcv zzcvVar, Object obj, Object obj2) {
            return zzcx.zza(zza, zzcvVar, zzd, obj, obj2);
        }

        @Override // com.google.android.gms.internal.play_billing.zzcv.zza
        final boolean zzg(zzcv zzcvVar, zze zzeVar, zze zzeVar2) {
            return zzcx.zza(zza, zzcvVar, zzc, zzeVar, zzeVar2);
        }
    }

    /* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
    final class zze {
        static final zze zza = new zze(false);
        volatile zze next;
        volatile Thread thread;

        zze() {
            zzcv.zzn(this, Thread.currentThread());
        }

        zze(boolean z) {
        }
    }

    static {
        boolean z;
        Throwable th;
        Throwable th2;
        zza zzcVar;
        try {
            z = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", Constants.CASEFIRST_FALSE));
        } catch (SecurityException unused) {
            z = false;
        }
        zzc = z;
        String property = System.getProperty("java.runtime.name", "");
        zzcz zzczVar = null;
        if (property == null || property.contains(GetDeviceInfoUseCaseKt.PLATFORM)) {
            try {
                zzcVar = new zzd(zzczVar);
            } catch (Error | Exception e) {
                try {
                    zzcVar = new zzb(zzczVar);
                    th = null;
                    th2 = e;
                } catch (Error | Exception e2) {
                    th = e2;
                    th2 = e;
                    zzcVar = new zzc(zzczVar);
                }
            }
        } else {
            try {
                zzcVar = new zzb(zzczVar);
            } catch (NoClassDefFoundError unused2) {
                zzcVar = new zzc(zzczVar);
            }
        }
        th = null;
        th2 = null;
        zzd = zzcVar;
        if (th != null) {
            zzdj zzdjVar = zzb;
            zzdjVar.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFutureState", "<clinit>", "UnsafeAtomicHelper is broken!", th2);
            zzdjVar.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFutureState", "<clinit>", "AtomicReferenceFieldUpdaterAtomicHelper is broken!", th);
        }
    }

    zzcv() {
    }

    private final void zza(zze zzeVar) {
        zzeVar.thread = null;
        while (true) {
            zze zzeVar2 = this.waitersField;
            if (zzeVar2 != zze.zza) {
                zze zzeVar3 = null;
                while (zzeVar2 != null) {
                    zze zzeVar4 = zzeVar2.next;
                    if (zzeVar2.thread != null) {
                        zzeVar3 = zzeVar2;
                    } else if (zzeVar3 != null) {
                        zzeVar3.next = zzeVar4;
                        if (zzeVar3.thread == null) {
                        }
                    } else if (!zzd.zzg(this, zzeVar2, zzeVar4)) {
                    }
                    zzeVar2 = zzeVar4;
                }
                return;
            }
            return;
        }
    }

    static /* synthetic */ void zzn(zze zzeVar, Thread thread) {
        zzd.zzd(zzeVar, thread);
    }

    static boolean zzq(zzcv zzcvVar, Object obj, Object obj2) {
        return zzd.zzf(zzcvVar, obj, obj2);
    }

    final zzcu.zzd zzk(zzcu.zzd zzdVar) {
        return zzd.zza(this, zzdVar);
    }

    final Object zzl() throws ExecutionException, InterruptedException {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.valueField;
        if ((obj2 != null) && zzcu.zzh(obj2)) {
            return zzcu.zzc(obj2);
        }
        zze zzeVar = this.waitersField;
        if (zzeVar != zze.zza) {
            zze zzeVar2 = new zze();
            do {
                zza zzaVar = zzd;
                zzaVar.zzc(zzeVar2, zzeVar);
                if (zzaVar.zzg(this, zzeVar, zzeVar2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            zza(zzeVar2);
                            throw new InterruptedException();
                        }
                        obj = this.valueField;
                    } while (!((obj != null) & zzcu.zzh(obj)));
                    return zzcu.zzc(obj);
                }
                zzeVar = this.waitersField;
            } while (zzeVar != zze.zza);
        }
        return zzcu.zzc(Objects.requireNonNull(this.valueField));
    }

    final Object zzm(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.valueField;
        boolean z = true;
        if ((obj != null) && zzcu.zzh(obj)) {
            return zzcu.zzc(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            zze zzeVar = this.waitersField;
            if (zzeVar != zze.zza) {
                zze zzeVar2 = new zze();
                while (true) {
                    zza zzaVar = zzd;
                    zzaVar.zzc(zzeVar2, zzeVar);
                    if (zzaVar.zzg(this, zzeVar, zzeVar2)) {
                        do {
                            LockSupport.parkNanos(this, Math.min(nanos, 2147483647999999999L));
                            if (Thread.interrupted()) {
                                zza(zzeVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.valueField;
                            if ((obj2 != null) && zzcu.zzh(obj2)) {
                                return zzcu.zzc(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        zza(zzeVar2);
                        break;
                    }
                    zzeVar = this.waitersField;
                    if (zzeVar == zze.zza) {
                    }
                }
            }
            return zzcu.zzc(Objects.requireNonNull(this.valueField));
        }
        while (nanos > 0) {
            Object obj3 = this.valueField;
            if ((obj3 != null) && zzcu.zzh(obj3)) {
                return zzcu.zzc(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = jNanoTime - System.nanoTime();
        }
        String string = toString();
        String lowerCase = timeUnit.toString().toLowerCase(Locale.ROOT);
        String strConcat = "Waited " + j + ServerSentEventKt.SPACE + timeUnit.toString().toLowerCase(Locale.ROOT);
        if (nanos + 1000 < 0) {
            String strConcat2 = strConcat.concat(" (plus ");
            long j2 = -nanos;
            long jConvert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
            long nanos2 = j2 - timeUnit.toNanos(jConvert);
            if (jConvert != 0 && nanos2 <= 1000) {
                z = false;
            }
            if (jConvert > 0) {
                String strConcat3 = strConcat2 + jConvert + ServerSentEventKt.SPACE + lowerCase;
                if (z) {
                    strConcat3 = strConcat3.concat(WebViewLogEventConsumer.DDTAGS_SEPARATOR);
                }
                strConcat2 = strConcat3.concat(ServerSentEventKt.SPACE);
            }
            if (z) {
                strConcat2 = strConcat2 + nanos2 + " nanoseconds ";
            }
            strConcat = strConcat2.concat("delay)");
        }
        if (isDone()) {
            throw new TimeoutException(strConcat.concat(" but future completed as timeout expired"));
        }
        throw new TimeoutException(strConcat + " for " + string);
    }

    final void zzo() {
        for (zze zzeVarZzb = zzd.zzb(this, zze.zza); zzeVarZzb != null; zzeVarZzb = zzeVarZzb.next) {
            Thread thread = zzeVarZzb.thread;
            if (thread != null) {
                zzeVarZzb.thread = null;
                LockSupport.unpark(thread);
            }
        }
    }

    final boolean zzp(zzcu.zzd zzdVar, zzcu.zzd zzdVar2) {
        return zzd.zze(this, zzdVar, zzdVar2);
    }
}
