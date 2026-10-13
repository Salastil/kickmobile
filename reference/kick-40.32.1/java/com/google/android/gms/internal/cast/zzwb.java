package com.google.android.gms.internal.cast;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import com.datadog.android.core.internal.metrics.BatchMetricsDispatcher;
import com.datadog.android.webview.internal.log.WebViewLogEventConsumer;
import com.facebook.hermes.intl.Constants;
import com.google.common.util.concurrent.ListenableFuture;
import io.datazoom.sdk.domain.usecases.GetDeviceInfoUseCaseKt;
import io.ktor.http.LinkHeader;
import io.ktor.sse.ServerSentEventKt;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
abstract class zzwb<V> extends zzwx implements ListenableFuture<V> {
    static final Object zza = new Object();
    static final zzwn zzb = new zzwn(zzwa.class);
    static final boolean zzc;
    private static final zza zzd;
    volatile zzwa.zzd listenersField;
    volatile Object valueField;
    volatile zze waitersField;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
    abstract class zza {
        /* synthetic */ zza(byte[] bArr) {
        }

        abstract void zza(zze zzeVar, Thread thread);

        abstract void zzb(zze zzeVar, zze zzeVar2);

        abstract boolean zzc(zzwb zzwbVar, zze zzeVar, zze zzeVar2);

        abstract boolean zzd(zzwb zzwbVar, zzwa.zzd zzdVar, zzwa.zzd zzdVar2);

        abstract zze zze(zzwb zzwbVar, zze zzeVar);

        abstract zzwa.zzd zzf(zzwb zzwbVar, zzwa.zzd zzdVar);

        abstract boolean zzg(zzwb zzwbVar, Object obj, Object obj2);
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
    final class zzb extends zza {
        private static final AtomicReferenceFieldUpdater<zze, Thread> zza = AtomicReferenceFieldUpdater.newUpdater(zze.class, Thread.class, BatchMetricsDispatcher.THREAD_NAME);
        private static final AtomicReferenceFieldUpdater<zze, zze> zzb = AtomicReferenceFieldUpdater.newUpdater(zze.class, zze.class, LinkHeader.Rel.Next);
        private static final AtomicReferenceFieldUpdater<? super zzwb<?>, zze> zzc = AtomicReferenceFieldUpdater.newUpdater(zzwb.class, zze.class, "waitersField");
        private static final AtomicReferenceFieldUpdater<? super zzwb<?>, zzwa.zzd> zzd = AtomicReferenceFieldUpdater.newUpdater(zzwb.class, zzwa.zzd.class, "listenersField");
        private static final AtomicReferenceFieldUpdater<? super zzwb<?>, Object> zze = AtomicReferenceFieldUpdater.newUpdater(zzwb.class, Object.class, "valueField");

        private zzb() {
            throw null;
        }

        /* synthetic */ zzb(byte[] bArr) {
            super(null);
        }

        @Override // com.google.android.gms.internal.cast.zzwb.zza
        final void zza(zze zzeVar, Thread thread) {
            zza.lazySet(zzeVar, thread);
        }

        @Override // com.google.android.gms.internal.cast.zzwb.zza
        final void zzb(zze zzeVar, zze zzeVar2) {
            zzb.lazySet(zzeVar, zzeVar2);
        }

        @Override // com.google.android.gms.internal.cast.zzwb.zza
        final boolean zzc(zzwb zzwbVar, zze zzeVar, zze zzeVar2) {
            return AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(zzc, zzwbVar, zzeVar, zzeVar2);
        }

        @Override // com.google.android.gms.internal.cast.zzwb.zza
        final boolean zzd(zzwb zzwbVar, zzwa.zzd zzdVar, zzwa.zzd zzdVar2) {
            return AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(zzd, zzwbVar, zzdVar, zzdVar2);
        }

        @Override // com.google.android.gms.internal.cast.zzwb.zza
        final zze zze(zzwb zzwbVar, zze zzeVar) {
            return zzc.getAndSet(zzwbVar, zzeVar);
        }

        @Override // com.google.android.gms.internal.cast.zzwb.zza
        final zzwa.zzd zzf(zzwb zzwbVar, zzwa.zzd zzdVar) {
            return zzd.getAndSet(zzwbVar, zzdVar);
        }

        @Override // com.google.android.gms.internal.cast.zzwb.zza
        final boolean zzg(zzwb zzwbVar, Object obj, Object obj2) {
            return AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(zze, zzwbVar, obj, obj2);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
    final class zzc extends zza {
        private zzc() {
            throw null;
        }

        /* synthetic */ zzc(byte[] bArr) {
            super(null);
        }

        @Override // com.google.android.gms.internal.cast.zzwb.zza
        final void zza(zze zzeVar, Thread thread) {
            zzeVar.thread = thread;
        }

        @Override // com.google.android.gms.internal.cast.zzwb.zza
        final void zzb(zze zzeVar, zze zzeVar2) {
            zzeVar.next = zzeVar2;
        }

        @Override // com.google.android.gms.internal.cast.zzwb.zza
        final boolean zzc(zzwb zzwbVar, zze zzeVar, zze zzeVar2) {
            synchronized (zzwbVar) {
                if (zzwbVar.waitersField != zzeVar) {
                    return false;
                }
                zzwbVar.waitersField = zzeVar2;
                return true;
            }
        }

        @Override // com.google.android.gms.internal.cast.zzwb.zza
        final boolean zzd(zzwb zzwbVar, zzwa.zzd zzdVar, zzwa.zzd zzdVar2) {
            synchronized (zzwbVar) {
                if (zzwbVar.listenersField != zzdVar) {
                    return false;
                }
                zzwbVar.listenersField = zzdVar2;
                return true;
            }
        }

        @Override // com.google.android.gms.internal.cast.zzwb.zza
        final zze zze(zzwb zzwbVar, zze zzeVar) {
            zze zzeVar2;
            synchronized (zzwbVar) {
                zzeVar2 = zzwbVar.waitersField;
                if (zzeVar2 != zzeVar) {
                    zzwbVar.waitersField = zzeVar;
                }
            }
            return zzeVar2;
        }

        @Override // com.google.android.gms.internal.cast.zzwb.zza
        final zzwa.zzd zzf(zzwb zzwbVar, zzwa.zzd zzdVar) {
            zzwa.zzd zzdVar2;
            synchronized (zzwbVar) {
                zzdVar2 = zzwbVar.listenersField;
                if (zzdVar2 != zzdVar) {
                    zzwbVar.listenersField = zzdVar;
                }
            }
            return zzdVar2;
        }

        @Override // com.google.android.gms.internal.cast.zzwb.zza
        final boolean zzg(zzwb zzwbVar, Object obj, Object obj2) {
            synchronized (zzwbVar) {
                if (zzwbVar.valueField != obj) {
                    return false;
                }
                zzwbVar.valueField = obj2;
                return true;
            }
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
    final class zzd extends zza {
        static final Unsafe zza;
        static final long zzb;
        static final long zzc;
        static final long zzd;
        static final long zze;
        static final long zzf;
        public static final /* synthetic */ int zzg = 0;

        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (SecurityException unused) {
                    unsafe = (Unsafe) AccessController.doPrivileged(zzwc.zza);
                }
                try {
                    zzc = unsafe.objectFieldOffset(zzwb.class.getDeclaredField("waitersField"));
                    zzb = unsafe.objectFieldOffset(zzwb.class.getDeclaredField("listenersField"));
                    zzd = unsafe.objectFieldOffset(zzwb.class.getDeclaredField("valueField"));
                    zze = unsafe.objectFieldOffset(zze.class.getDeclaredField(BatchMetricsDispatcher.THREAD_NAME));
                    zzf = unsafe.objectFieldOffset(zze.class.getDeclaredField(LinkHeader.Rel.Next));
                    zza = unsafe;
                } catch (NoSuchFieldException e) {
                    throw new RuntimeException(e);
                }
            } catch (PrivilegedActionException e2) {
                throw new RuntimeException("Could not initialize intrinsics", e2.getCause());
            }
        }

        private zzd() {
            throw null;
        }

        /* synthetic */ zzd(byte[] bArr) {
            super(null);
        }

        @Override // com.google.android.gms.internal.cast.zzwb.zza
        final void zza(zze zzeVar, Thread thread) {
            zza.putObject(zzeVar, zze, thread);
        }

        @Override // com.google.android.gms.internal.cast.zzwb.zza
        final void zzb(zze zzeVar, zze zzeVar2) {
            zza.putObject(zzeVar, zzf, zzeVar2);
        }

        @Override // com.google.android.gms.internal.cast.zzwb.zza
        final boolean zzc(zzwb zzwbVar, zze zzeVar, zze zzeVar2) {
            return zzwb$zzd$$ExternalSyntheticBackportWithForwarding0.m(zza, zzwbVar, zzc, zzeVar, zzeVar2);
        }

        @Override // com.google.android.gms.internal.cast.zzwb.zza
        final boolean zzd(zzwb zzwbVar, zzwa.zzd zzdVar, zzwa.zzd zzdVar2) {
            return zzwb$zzd$$ExternalSyntheticBackportWithForwarding0.m(zza, zzwbVar, zzb, zzdVar, zzdVar2);
        }

        @Override // com.google.android.gms.internal.cast.zzwb.zza
        final zze zze(zzwb zzwbVar, zze zzeVar) {
            zze zzeVar2;
            do {
                zzeVar2 = zzwbVar.waitersField;
                if (zzeVar == zzeVar2) {
                    break;
                }
            } while (!zzc(zzwbVar, zzeVar2, zzeVar));
            return zzeVar2;
        }

        @Override // com.google.android.gms.internal.cast.zzwb.zza
        final zzwa.zzd zzf(zzwb zzwbVar, zzwa.zzd zzdVar) {
            zzwa.zzd zzdVar2;
            do {
                zzdVar2 = zzwbVar.listenersField;
                if (zzdVar == zzdVar2) {
                    break;
                }
            } while (!zzd(zzwbVar, zzdVar2, zzdVar));
            return zzdVar2;
        }

        @Override // com.google.android.gms.internal.cast.zzwb.zza
        final boolean zzg(zzwb zzwbVar, Object obj, Object obj2) {
            return zzwb$zzd$$ExternalSyntheticBackportWithForwarding0.m(zza, zzwbVar, zzd, obj, obj2);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
    final class zze {
        static final zze zza = new zze(false);
        volatile zze next;
        volatile Thread thread;

        zze() {
            zzwb.zzn(this, Thread.currentThread());
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
        byte[] bArr = null;
        if (property == null || property.contains(GetDeviceInfoUseCaseKt.PLATFORM)) {
            try {
                zzcVar = new zzd(bArr);
            } catch (Error | Exception e) {
                try {
                    zzcVar = new zzb(bArr);
                    th = null;
                    th2 = e;
                } catch (Error | Exception e2) {
                    th = e2;
                    th2 = e;
                    zzcVar = new zzc(bArr);
                }
            }
        } else {
            try {
                zzcVar = new zzb(bArr);
            } catch (NoClassDefFoundError unused2) {
                zzcVar = new zzc(bArr);
            }
        }
        th = null;
        th2 = null;
        zzd = zzcVar;
        if (th != null) {
            zzwn zzwnVar = zzb;
            zzwnVar.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFutureState", "<clinit>", "UnsafeAtomicHelper is broken!", th2);
            zzwnVar.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFutureState", "<clinit>", "AtomicReferenceFieldUpdaterAtomicHelper is broken!", th);
        }
    }

    zzwb() {
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
                    } else if (!zzd.zzc(this, zzeVar2, zzeVar4)) {
                    }
                    zzeVar2 = zzeVar4;
                }
                return;
            }
            return;
        }
    }

    static boolean zzj(zzwb zzwbVar, Object obj, Object obj2) {
        return zzd.zzg(zzwbVar, obj, obj2);
    }

    static /* synthetic */ void zzn(zze zzeVar, Thread thread) {
        zzd.zza(zzeVar, thread);
    }

    final boolean zzh(zzwa.zzd zzdVar, zzwa.zzd zzdVar2) {
        return zzd.zzd(this, zzdVar, zzdVar2);
    }

    final zzwa.zzd zzi(zzwa.zzd zzdVar) {
        return zzd.zzf(this, zzdVar);
    }

    final void zzk() {
        for (zze zzeVarZze = zzd.zze(this, zze.zza); zzeVarZze != null; zzeVarZze = zzeVarZze.next) {
            Thread thread = zzeVarZze.thread;
            if (thread != null) {
                zzeVarZze.thread = null;
                LockSupport.unpark(thread);
            }
        }
    }

    final Object zzl(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.valueField;
        if ((obj != null) && zzwa.zzb(obj)) {
            return zzwa.zza(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            zze zzeVar = this.waitersField;
            if (zzeVar != zze.zza) {
                zze zzeVar2 = new zze();
                while (true) {
                    zza zzaVar = zzd;
                    zzaVar.zzb(zzeVar2, zzeVar);
                    if (zzaVar.zzc(this, zzeVar, zzeVar2)) {
                        do {
                            LockSupport.parkNanos(this, Math.min(nanos, 2147483647999999999L));
                            if (Thread.interrupted()) {
                                zza(zzeVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.valueField;
                            if ((obj2 != null) && zzwa.zzb(obj2)) {
                                return zzwa.zza(obj2);
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
            return zzwa.zza(Objects.requireNonNull(this.valueField));
        }
        while (nanos > 0) {
            Object obj3 = this.valueField;
            if ((obj3 != null) && zzwa.zzb(obj3)) {
                return zzwa.zza(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = jNanoTime - System.nanoTime();
        }
        String string = toString();
        String lowerCase = timeUnit.toString().toLowerCase(Locale.ROOT);
        String lowerCase2 = timeUnit.toString().toLowerCase(Locale.ROOT);
        StringBuilder sb = new StringBuilder(String.valueOf(j).length() + 8 + String.valueOf(lowerCase2).length());
        sb.append("Waited ");
        sb.append(j);
        sb.append(ServerSentEventKt.SPACE);
        sb.append(lowerCase2);
        String string2 = sb.toString();
        if (nanos + 1000 < 0) {
            String strConcat = string2.concat(" (plus ");
            long j2 = -nanos;
            long jConvert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
            long nanos2 = j2 - timeUnit.toNanos(jConvert);
            boolean z = jConvert == 0 || nanos2 > 1000;
            if (jConvert > 0) {
                StringBuilder sb2 = new StringBuilder(strConcat.length() + String.valueOf(jConvert).length() + 1 + String.valueOf(lowerCase).length());
                sb2.append(strConcat);
                sb2.append(jConvert);
                sb2.append(ServerSentEventKt.SPACE);
                sb2.append(lowerCase);
                String string3 = sb2.toString();
                if (z) {
                    string3 = string3.concat(WebViewLogEventConsumer.DDTAGS_SEPARATOR);
                }
                strConcat = string3.concat(ServerSentEventKt.SPACE);
            }
            if (z) {
                StringBuilder sb3 = new StringBuilder(strConcat.length() + String.valueOf(nanos2).length() + 13);
                sb3.append(strConcat);
                sb3.append(nanos2);
                sb3.append(" nanoseconds ");
                strConcat = sb3.toString();
            }
            string2 = strConcat.concat("delay)");
        }
        if (isDone()) {
            throw new TimeoutException(string2.concat(" but future completed as timeout expired"));
        }
        StringBuilder sb4 = new StringBuilder(string2.length() + 5 + String.valueOf(string).length());
        sb4.append(string2);
        sb4.append(" for ");
        sb4.append(string);
        throw new TimeoutException(sb4.toString());
    }

    final Object zzm() throws ExecutionException, InterruptedException {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.valueField;
        if ((obj2 != null) && zzwa.zzb(obj2)) {
            return zzwa.zza(obj2);
        }
        zze zzeVar = this.waitersField;
        if (zzeVar != zze.zza) {
            zze zzeVar2 = new zze();
            do {
                zza zzaVar = zzd;
                zzaVar.zzb(zzeVar2, zzeVar);
                if (zzaVar.zzc(this, zzeVar, zzeVar2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            zza(zzeVar2);
                            throw new InterruptedException();
                        }
                        obj = this.valueField;
                    } while (!((obj != null) & zzwa.zzb(obj)));
                    return zzwa.zza(obj);
                }
                zzeVar = this.waitersField;
            } while (zzeVar != zze.zza);
        }
        return zzwa.zza(Objects.requireNonNull(this.valueField));
    }
}
