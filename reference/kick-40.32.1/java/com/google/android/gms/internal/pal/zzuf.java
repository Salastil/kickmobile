package com.google.android.gms.internal.pal;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
abstract class zzuf extends AtomicReference implements Runnable {
    private static final Runnable zza = new zzue(null);
    private static final Runnable zzb = new zzue(null);

    zzuf() {
    }

    private final void zzg(Thread thread) {
        Runnable runnable = (Runnable) get();
        zzud zzudVar = null;
        boolean z = false;
        int i = 0;
        while (true) {
            if (!(runnable instanceof zzud)) {
                if (runnable != zzb) {
                    break;
                }
            } else {
                zzudVar = (zzud) runnable;
            }
            i++;
            if (i > 1000) {
                Runnable runnable2 = zzb;
                if (runnable == runnable2 || compareAndSet(runnable, runnable2)) {
                    z = Thread.interrupted() || z;
                    LockSupport.park(zzudVar);
                }
            } else {
                Thread.yield();
            }
            runnable = (Runnable) get();
        }
        if (z) {
            thread.interrupt();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        Thread threadCurrentThread = Thread.currentThread();
        Object objZzb = null;
        if (compareAndSet(null, threadCurrentThread)) {
            boolean zZza = zza();
            if (!zZza) {
                try {
                    objZzb = zzb();
                } catch (Throwable th) {
                    try {
                        if (th instanceof InterruptedException) {
                            Thread.currentThread().interrupt();
                        }
                        if (!compareAndSet(threadCurrentThread, zza)) {
                            zzg(threadCurrentThread);
                        }
                        zzd(th);
                        return;
                    } catch (Throwable th2) {
                        if (!compareAndSet(threadCurrentThread, zza)) {
                            zzg(threadCurrentThread);
                        }
                        zzc(null);
                        throw th2;
                    }
                }
            }
            if (!compareAndSet(threadCurrentThread, zza)) {
                zzg(threadCurrentThread);
            }
            if (zZza) {
                return;
            }
            zzc(objZzb);
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public final String toString() {
        String string;
        Runnable runnable = (Runnable) get();
        if (runnable == zza) {
            string = "running=[DONE]";
        } else if (runnable instanceof zzud) {
            string = "running=[INTERRUPTED]";
        } else if (runnable instanceof Thread) {
            String name = ((Thread) runnable).getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 21);
            sb.append("running=[RUNNING ON ");
            sb.append(name);
            sb.append("]");
            string = sb.toString();
        } else {
            string = "running=[NOT STARTED YET]";
        }
        String strZzf = zzf();
        StringBuilder sb2 = new StringBuilder(string.length() + 2 + String.valueOf(strZzf).length());
        sb2.append(string);
        sb2.append(", ");
        sb2.append(strZzf);
        return sb2.toString();
    }

    abstract boolean zza();

    abstract Object zzb() throws Exception;

    abstract void zzc(Object obj);

    abstract void zzd(Throwable th);

    final void zze() {
        Runnable runnable = (Runnable) get();
        if (runnable instanceof Thread) {
            zzud zzudVar = new zzud(this, null);
            zzudVar.zza(Thread.currentThread());
            if (compareAndSet(runnable, zzudVar)) {
                try {
                    ((Thread) runnable).interrupt();
                    if (((Runnable) getAndSet(zza)) == zzb) {
                    }
                } finally {
                    if (((Runnable) getAndSet(zza)) == zzb) {
                        LockSupport.unpark((Thread) runnable);
                    }
                }
            }
        }
    }

    abstract String zzf();
}
