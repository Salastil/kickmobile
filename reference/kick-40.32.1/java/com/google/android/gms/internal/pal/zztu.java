package com.google.android.gms.internal.pal;

import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zztu<V> extends zztv<V> {

    /* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
    final class zza {
        static final zza zza;
        static final zza zzb;
        final boolean zzc;
        final Throwable zzd;

        static {
            if (zztv.zzc) {
                zzb = null;
                zza = null;
            } else {
                zzb = new zza(false, null);
                zza = new zza(true, null);
            }
        }

        zza(boolean z, Throwable th) {
            this.zzc = z;
            this.zzd = th;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
    final class zzb<V> implements Runnable {
        final zztu<V> zza;
        final zzuh<? extends V> zzb;

        @Override // java.lang.Runnable
        public final void run() {
            throw null;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
    final class zzc {
        static final zzc zza = new zzc(new Throwable("Failure occurred while trying to finish a future.") { // from class: com.google.android.gms.internal.pal.zztu.zzc.1
            {
                super("Failure occurred while trying to finish a future.");
            }

            @Override // java.lang.Throwable
            public final Throwable fillInStackTrace() {
                return this;
            }
        });
        final Throwable zzb;

        zzc(Throwable th) {
            th.getClass();
            this.zzb = th;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
    final class zzd {
        static final zzd zza = new zzd();
        zzd next;
        final Runnable zzb = null;
        final Executor zzc = null;

        zzd() {
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
    interface zze<V> extends zzuh<V> {
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
    abstract class zzf<V> extends zztu<V> implements zze<V> {
        zzf() {
        }
    }

    protected zztu() {
    }

    static Object zza(Object obj) throws ExecutionException {
        if (obj instanceof zza) {
            Throwable th = ((zza) obj).zzd;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (obj instanceof zzc) {
            throw new ExecutionException(((zzc) obj).zzb);
        }
        if (obj == zza) {
            return null;
        }
        return obj;
    }

    static boolean zzb(Object obj) {
        return !(obj instanceof zzb);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Object zzn(zzuh zzuhVar) {
        Throwable thZzf;
        if (zzuhVar instanceof zze) {
            Object zzaVar = ((zztu) zzuhVar).valueField;
            if (zzaVar instanceof zza) {
                zza zzaVar2 = (zza) zzaVar;
                if (zzaVar2.zzc) {
                    Throwable th = zzaVar2.zzd;
                    zzaVar = th != null ? new zza(false, th) : zza.zzb;
                }
            }
            return Objects.requireNonNull(zzaVar);
        }
        if ((zzuhVar instanceof zzuo) && (thZzf = ((zzuo) zzuhVar).zzf()) != null) {
            return new zzc(thZzf);
        }
        boolean zIsCancelled = zzuhVar.isCancelled();
        if ((!zzc) && zIsCancelled) {
            return Objects.requireNonNull(zza.zzb);
        }
        try {
            Object objZzo = zzo(zzuhVar);
            if (!zIsCancelled) {
                return objZzo == null ? zza : objZzo;
            }
            String strValueOf = String.valueOf(zzuhVar);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 84);
            sb.append("get() did not throw CancellationException, despite reporting isCancelled() == true: ");
            sb.append(strValueOf);
            return new zza(false, new IllegalArgumentException(sb.toString()));
        } catch (Error | Exception e) {
            return new zzc(e);
        } catch (CancellationException e2) {
            if (zIsCancelled) {
                return new zza(false, e2);
            }
            String strValueOf2 = String.valueOf(zzuhVar);
            String.valueOf(strValueOf2);
            return new zzc(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: ".concat(String.valueOf(strValueOf2)), e2));
        } catch (ExecutionException e3) {
            if (!zIsCancelled) {
                return new zzc(e3.getCause());
            }
            String strValueOf3 = String.valueOf(zzuhVar);
            String.valueOf(strValueOf3);
            return new zza(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: ".concat(String.valueOf(strValueOf3)), e3));
        }
    }

    private static Object zzo(Future future) throws ExecutionException {
        Object obj;
        boolean z = false;
        while (true) {
            try {
                obj = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    private static void zzp(zztu zztuVar, boolean z) {
        zzd zzdVar = null;
        while (true) {
            zztuVar.zzj();
            zztuVar.zze();
            zzd zzdVar2 = zzdVar;
            zzd zzdVarZzh = zztuVar.zzh(zzd.zza);
            zzd zzdVar3 = zzdVar2;
            while (zzdVarZzh != null) {
                zzd zzdVar4 = zzdVarZzh.next;
                zzdVarZzh.next = zzdVar3;
                zzdVar3 = zzdVarZzh;
                zzdVarZzh = zzdVar4;
            }
            while (zzdVar3 != null) {
                Runnable runnable = zzdVar3.zzb;
                zzd zzdVar5 = zzdVar3.next;
                Runnable runnable2 = (Runnable) Objects.requireNonNull(runnable);
                if (runnable2 instanceof zzb) {
                    zzb zzbVar = (zzb) runnable2;
                    zztuVar = zzbVar.zza;
                    if (zztuVar.valueField == zzbVar && zzi(zztuVar, zzbVar, zzn(zzbVar.zzb))) {
                        zzdVar = zzdVar5;
                    }
                } else {
                    Executor executor = (Executor) Objects.requireNonNull(zzdVar3.zzc);
                    try {
                        executor.execute(runnable2);
                    } catch (Exception e) {
                        Logger loggerZza = zzb.zza();
                        Level level = Level.SEVERE;
                        String strValueOf = String.valueOf(runnable2);
                        String strValueOf2 = String.valueOf(executor);
                        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 57 + String.valueOf(strValueOf2).length());
                        sb.append("RuntimeException while executing runnable ");
                        sb.append(strValueOf);
                        sb.append(" with executor ");
                        sb.append(strValueOf2);
                        loggerZza.logp(level, "com.google.common.util.concurrent.AbstractFuture", "executeListener", sb.toString(), (Throwable) e);
                    }
                }
                zzdVar3 = zzdVar5;
            }
            return;
        }
    }

    private final void zzq(StringBuilder sb) {
        try {
            Object objZzo = zzo(this);
            sb.append("SUCCESS, result=[");
            if (objZzo == null) {
                sb.append(AbstractJsonLexerKt.NULL);
            } else if (objZzo == this) {
                sb.append("this future");
            } else {
                sb.append(objZzo.getClass().getName());
                sb.append("@");
                sb.append(Integer.toHexString(System.identityHashCode(objZzo)));
            }
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (ExecutionException e) {
            sb.append("FAILURE, cause=[");
            sb.append(e.getCause());
            sb.append("]");
        } catch (Exception e2) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e2.getClass());
            sb.append(" thrown from get()]");
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        Object objRequireNonNull;
        Object obj = this.valueField;
        if (!(obj instanceof zzb) && !(obj == null)) {
            return false;
        }
        if (zzc) {
            objRequireNonNull = new zza(z, new CancellationException("Future.cancel() was called."));
        } else {
            objRequireNonNull = Objects.requireNonNull(z ? zza.zza : zza.zzb);
        }
        boolean z2 = false;
        while (true) {
            if (zzi(this, obj, objRequireNonNull)) {
                zzp(this, z);
                if (obj instanceof zzb) {
                    zzuh<? extends V> zzuhVar = ((zzb) obj).zzb;
                    if (zzuhVar instanceof zze) {
                        this = (zztu) zzuhVar;
                        obj = this.valueField;
                        if (!(obj == null) && !(obj instanceof zzb)) {
                            return true;
                        }
                        z2 = true;
                    } else {
                        zzuhVar.cancel(z);
                    }
                }
                return true;
            }
            obj = this.valueField;
            if (zzb(obj)) {
                return z2;
            }
        }
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws ExecutionException, InterruptedException {
        return zzl();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.valueField instanceof zza;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        Object obj = this.valueField;
        return (obj != null) & zzb(obj);
    }

    public final String toString() {
        String strConcat;
        StringBuilder sb = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb.append(getClass().getSimpleName());
        } else {
            sb.append(getClass().getName());
        }
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[status=");
        if (this.valueField instanceof zza) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            zzq(sb);
        } else {
            int length = sb.length();
            sb.append("PENDING");
            Object obj = this.valueField;
            if (obj instanceof zzb) {
                sb.append(", setFuture=[");
                zzuh<? extends V> zzuhVar = ((zzb) obj).zzb;
                try {
                    if (zzuhVar == this) {
                        sb.append("this future");
                    } else {
                        sb.append(zzuhVar);
                    }
                } catch (Throwable th) {
                    zzui.zza(th);
                    sb.append("Exception thrown from implementation: ");
                    sb.append(th.getClass());
                }
                sb.append("]");
            } else {
                try {
                    strConcat = zzmd.zza(zzg());
                } catch (Throwable th2) {
                    zzui.zza(th2);
                    String strValueOf = String.valueOf(th2.getClass());
                    String.valueOf(strValueOf);
                    strConcat = "Exception thrown from implementation: ".concat(String.valueOf(strValueOf));
                }
                if (strConcat != null) {
                    sb.append(", info=[");
                    sb.append(strConcat);
                    sb.append("]");
                }
            }
            if (isDone()) {
                sb.delete(length, sb.length());
                zzq(sb);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    protected boolean zzc(Object obj) {
        if (obj == null) {
            obj = zza;
        }
        if (!zzi(this, null, obj)) {
            return false;
        }
        zzp(this, false);
        return true;
    }

    protected final boolean zzd(Throwable th) {
        if (!zzi(this, null, new zzc(th))) {
            return false;
        }
        zzp(this, false);
        return true;
    }

    protected void zze() {
    }

    @Override // com.google.android.gms.internal.pal.zzuo
    protected final Throwable zzf() {
        if (!(this instanceof zze)) {
            return null;
        }
        Object obj = this.valueField;
        if (obj instanceof zzc) {
            return ((zzc) obj).zzb;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected String zzg() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        long delay = ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS);
        StringBuilder sb = new StringBuilder(String.valueOf(delay).length() + 21);
        sb.append("remaining delay=[");
        sb.append(delay);
        sb.append(" ms]");
        return sb.toString();
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return zzk(j, timeUnit);
    }
}
