package com.google.android.gms.internal.pal;

import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzun extends zztx implements RunnableFuture {
    private volatile zzuf zzd;

    zzun(Callable callable) {
        this.zzd = new zzum(this, callable);
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        zzuf zzufVar = this.zzd;
        if (zzufVar != null) {
            zzufVar.run();
        }
        this.zzd = null;
    }

    @Override // com.google.android.gms.internal.pal.zztu
    protected final void zze() {
        zzuf zzufVar;
        Object obj = this.valueField;
        if ((obj instanceof zztu.zza) && ((zztu.zza) obj).zzc && (zzufVar = this.zzd) != null) {
            zzufVar.zze();
        }
        this.zzd = null;
    }

    @Override // com.google.android.gms.internal.pal.zztu
    protected final String zzg() {
        zzuf zzufVar = this.zzd;
        if (zzufVar == null) {
            return super.zzg();
        }
        String string = zzufVar.toString();
        StringBuilder sb = new StringBuilder(string.length() + 7);
        sb.append("task=[");
        sb.append(string);
        sb.append("]");
        return sb.toString();
    }
}
