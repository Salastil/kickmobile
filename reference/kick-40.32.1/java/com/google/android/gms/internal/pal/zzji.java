package com.google.android.gms.internal.pal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzji implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    protected final zzju zza;
    private final String zzb;
    private final String zzc;
    private final LinkedBlockingQueue zzd;
    private final HandlerThread zze;

    public zzji(Context context, String str, String str2) {
        this.zzb = str;
        this.zzc = str2;
        HandlerThread handlerThread = new HandlerThread("GassClient");
        this.zze = handlerThread;
        handlerThread.start();
        zzju zzjuVar = new zzju(context, handlerThread.getLooper(), this, this, 9200000);
        this.zza = zzjuVar;
        this.zzd = new LinkedBlockingQueue();
        zzjuVar.checkAvailabilityAndConnect();
    }

    static zzbd zzc() {
        zzad zzadVarZzg = zzbd.zzg();
        zzadVarZzg.zzl(32768L);
        return (zzbd) zzadVarZzg.zzal();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        zzjz zzjzVarZzd = zzd();
        if (zzjzVarZzd != null) {
            try {
                try {
                    this.zzd.put(zzjzVarZzd.zze(new zzjv(this.zzb, this.zzc)).zza());
                } catch (Throwable unused) {
                    this.zzd.put(zzc());
                }
            } catch (InterruptedException unused2) {
            } finally {
                zzb();
                this.zze.quit();
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            this.zzd.put(zzc());
        } catch (InterruptedException unused) {
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        try {
            this.zzd.put(zzc());
        } catch (InterruptedException unused) {
        }
    }

    public final zzbd zza(int i) {
        zzbd zzbdVar;
        try {
            zzbdVar = (zzbd) this.zzd.poll(5000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            zzbdVar = null;
        }
        return zzbdVar == null ? zzc() : zzbdVar;
    }

    public final void zzb() {
        zzju zzjuVar = this.zza;
        if (zzjuVar != null) {
            if (zzjuVar.isConnected() || zzjuVar.isConnecting()) {
                zzjuVar.disconnect();
            }
        }
    }

    protected final zzjz zzd() {
        try {
            return this.zza.zzp();
        } catch (DeadObjectException | IllegalStateException unused) {
            return null;
        }
    }
}
