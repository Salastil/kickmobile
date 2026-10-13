package com.google.android.gms.cast.framework;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class Session {
    private static final Logger zza = new Logger("Session");
    private final zzau zzb;
    private final zzbf zzc;

    protected Session(Context context, String str, String str2) {
        zzbf zzbfVar = new zzbf(this, null);
        this.zzc = zzbfVar;
        this.zzb = com.google.android.gms.internal.cast.zzay.zzb(context, str, str2, zzbfVar);
    }

    protected abstract void end(boolean z);

    public final String getCategory() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzau zzauVar = this.zzb;
        if (zzauVar != null) {
            try {
                return zzauVar.zzg();
            } catch (RemoteException e) {
                zza.d(e, "Unable to call %s on %s.", "getCategory", "zzau");
            }
        }
        return null;
    }

    public final String getSessionId() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzau zzauVar = this.zzb;
        if (zzauVar != null) {
            try {
                return zzauVar.zzh();
            } catch (RemoteException e) {
                zza.d(e, "Unable to call %s on %s.", "getSessionId", "zzau");
            }
        }
        return null;
    }

    public long getSessionRemainingTimeMs() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return 0L;
    }

    public boolean isConnected() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzau zzauVar = this.zzb;
        if (zzauVar != null) {
            try {
                return zzauVar.zzi();
            } catch (RemoteException e) {
                zza.d(e, "Unable to call %s on %s.", "isConnected", "zzau");
            }
        }
        return false;
    }

    public boolean isConnecting() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzau zzauVar = this.zzb;
        if (zzauVar != null) {
            try {
                return zzauVar.zzj();
            } catch (RemoteException e) {
                zza.d(e, "Unable to call %s on %s.", "isConnecting", "zzau");
            }
        }
        return false;
    }

    public boolean isDisconnected() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzau zzauVar = this.zzb;
        if (zzauVar != null) {
            try {
                return zzauVar.zzl();
            } catch (RemoteException e) {
                zza.d(e, "Unable to call %s on %s.", "isDisconnected", "zzau");
            }
        }
        return true;
    }

    public boolean isDisconnecting() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzau zzauVar = this.zzb;
        if (zzauVar != null) {
            try {
                return zzauVar.zzk();
            } catch (RemoteException e) {
                zza.d(e, "Unable to call %s on %s.", "isDisconnecting", "zzau");
            }
        }
        return false;
    }

    public boolean isResuming() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzau zzauVar = this.zzb;
        if (zzauVar != null) {
            try {
                return zzauVar.zzm();
            } catch (RemoteException e) {
                zza.d(e, "Unable to call %s on %s.", "isResuming", "zzau");
            }
        }
        return false;
    }

    public boolean isSuspended() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzau zzauVar = this.zzb;
        if (zzauVar != null) {
            try {
                return zzauVar.zzn();
            } catch (RemoteException e) {
                zza.d(e, "Unable to call %s on %s.", "isSuspended", "zzau");
            }
        }
        return false;
    }

    protected final void notifyFailedToResumeSession(int i) {
        zzau zzauVar = this.zzb;
        if (zzauVar == null) {
            return;
        }
        try {
            zzauVar.zzt(i);
        } catch (RemoteException e) {
            zza.d(e, "Unable to call %s on %s.", "notifyFailedToResumeSession", "zzau");
        }
    }

    protected final void notifyFailedToStartSession(int i) {
        zzau zzauVar = this.zzb;
        if (zzauVar == null) {
            return;
        }
        try {
            zzauVar.zzq(i);
        } catch (RemoteException e) {
            zza.d(e, "Unable to call %s on %s.", "notifyFailedToStartSession", "zzau");
        }
    }

    protected final void notifySessionEnded(int i) {
        zzau zzauVar = this.zzb;
        if (zzauVar == null) {
            return;
        }
        try {
            zzauVar.zzr(i);
        } catch (RemoteException e) {
            zza.d(e, "Unable to call %s on %s.", "notifySessionEnded", "zzau");
        }
    }

    protected final void notifySessionResumed(boolean z) {
        zzau zzauVar = this.zzb;
        if (zzauVar == null) {
            return;
        }
        try {
            zzauVar.zzs(z);
        } catch (RemoteException e) {
            zza.d(e, "Unable to call %s on %s.", "notifySessionResumed", "zzau");
        }
    }

    protected final void notifySessionStarted(String str) {
        zzau zzauVar = this.zzb;
        if (zzauVar == null) {
            return;
        }
        try {
            zzauVar.zzp(str);
        } catch (RemoteException e) {
            zza.d(e, "Unable to call %s on %s.", "notifySessionStarted", "zzau");
        }
    }

    protected final void notifySessionSuspended(int i) {
        zzau zzauVar = this.zzb;
        if (zzauVar == null) {
            return;
        }
        try {
            zzauVar.zzu(i);
        } catch (RemoteException e) {
            zza.d(e, "Unable to call %s on %s.", "notifySessionSuspended", "zzau");
        }
    }

    protected void onResuming(Bundle bundle) {
    }

    protected void onStarting(Bundle bundle) {
    }

    protected abstract void resume(Bundle bundle);

    protected abstract void start(Bundle bundle);

    protected void zza(Bundle bundle) {
    }

    public final int zzm() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzau zzauVar = this.zzb;
        if (zzauVar != null) {
            try {
                if (zzauVar.zze() >= 211100000) {
                    return zzauVar.zzo();
                }
            } catch (RemoteException e) {
                zza.d(e, "Unable to call %s on %s.", "getSessionStartType", "zzau");
            }
        }
        return 0;
    }

    public final IObjectWrapper zzn() {
        zzau zzauVar = this.zzb;
        if (zzauVar != null) {
            try {
                return zzauVar.zzf();
            } catch (RemoteException e) {
                zza.d(e, "Unable to call %s on %s.", "getWrappedObject", "zzau");
            }
        }
        return null;
    }
}
