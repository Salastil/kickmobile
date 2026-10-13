package com.google.android.gms.internal.cast;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzwr extends zzwa.zzf implements Runnable {
    private final Runnable zzd;

    @Override // com.google.android.gms.internal.cast.zzwa
    protected final String zzg() {
        String string = this.zzd.toString();
        StringBuilder sb = new StringBuilder(string.length() + 7);
        sb.append("task=[");
        sb.append(string);
        sb.append("]");
        return sb.toString();
    }

    zzwr(Runnable runnable) {
        runnable.getClass();
        this.zzd = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzd.run();
        } catch (Throwable th) {
            zzd(th);
            throw th;
        }
    }
}
