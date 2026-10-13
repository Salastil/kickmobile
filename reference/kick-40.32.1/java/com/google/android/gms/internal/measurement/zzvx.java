package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzvx extends ThreadLocal {
    zzvx() {
    }

    @Override // java.lang.ThreadLocal
    protected final /* bridge */ /* synthetic */ Object initialValue() {
        zzwq zzwqVar = new zzwq(zzrn.zza(Thread.currentThread()));
        Thread threadCurrentThread = Thread.currentThread();
        synchronized (zzvy.zze) {
            zzvy.zze.put(threadCurrentThread, zzwqVar);
        }
        return zzwqVar;
    }
}
