package com.google.android.gms.internal.pal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import com.facebook.device.yearclass.YearClass;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzjk implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    protected final zzju zza;
    private final String zzb;
    private final String zzc;
    private final LinkedBlockingQueue zzd;
    private final HandlerThread zze;
    private final zzjc zzf;
    private final long zzg;
    private final int zzh;

    public zzjk(Context context, int i, int i2, String str, String str2, String str3, zzjc zzjcVar) {
        this.zzb = str;
        this.zzh = i2;
        this.zzc = str2;
        this.zzf = zzjcVar;
        HandlerThread handlerThread = new HandlerThread("GassDGClient");
        this.zze = handlerThread;
        handlerThread.start();
        this.zzg = System.currentTimeMillis();
        zzju zzjuVar = new zzju(context, handlerThread.getLooper(), this, this, 19621000);
        this.zza = zzjuVar;
        this.zzd = new LinkedBlockingQueue();
        zzjuVar.checkAvailabilityAndConnect();
    }

    private final void zzd(int i, long j, Exception exc) {
        this.zzf.zzc(i, System.currentTimeMillis() - j, exc);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        zzjz zzjzVarZzc = zzc();
        if (zzjzVarZzc != null) {
            try {
                zzkg zzkgVarZzf = zzjzVarZzc.zzf(new zzke(1, this.zzh, this.zzb, this.zzc));
                zzd(5011, this.zzg, null);
                this.zzd.put(zzkgVarZzf);
            } catch (Throwable th) {
                try {
                    zzd(YearClass.CLASS_2010, this.zzg, new Exception(th));
                } finally {
                    zzb();
                    this.zze.quit();
                }
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            zzd(4012, this.zzg, null);
            this.zzd.put(new zzkg(null, 1));
        } catch (InterruptedException unused) {
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        try {
            zzd(4011, this.zzg, null);
            this.zzd.put(new zzkg(null, 1));
        } catch (InterruptedException unused) {
        }
    }

    public final zzkg zza(int i) {
        zzkg zzkgVar;
        try {
            zzkgVar = (zzkg) this.zzd.poll(50000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            zzd(YearClass.CLASS_2009, this.zzg, e);
            zzkgVar = null;
        }
        zzd(3004, this.zzg, null);
        if (zzkgVar != null) {
            if (zzkgVar.zzc == 7) {
                zzjc.zzg(3);
            } else {
                zzjc.zzg(2);
            }
        }
        return zzkgVar == null ? new zzkg(null, 1) : zzkgVar;
    }

    public final void zzb() {
        zzju zzjuVar = this.zza;
        if (zzjuVar != null) {
            if (zzjuVar.isConnected() || zzjuVar.isConnecting()) {
                zzjuVar.disconnect();
            }
        }
    }

    protected final zzjz zzc() {
        try {
            return this.zza.zzp();
        } catch (DeadObjectException | IllegalStateException unused) {
            return null;
        }
    }
}
