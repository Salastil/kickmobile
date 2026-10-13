package com.google.android.gms.cast.framework;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.cast.zzbx;
import com.google.android.gms.internal.cast.zzcj;
import com.google.android.gms.tasks.Task;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.dataflow.qual.Pure;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public class CastSession extends Session {
    public static final /* synthetic */ int zza = 0;
    private static final Logger zzb = new Logger("CastSession");
    private final Context zzc;
    private final Set zzd;
    private final zzak zze;
    private final CastOptions zzf;
    private final zzbx zzg;
    private final com.google.android.gms.cast.framework.media.internal.zzs zzh;
    private com.google.android.gms.cast.zzq zzi;
    private RemoteMediaClient zzj;
    private CastDevice zzk;
    private Cast.ApplicationConnectionResult zzl;
    private zzr zzm;

    public CastSession(Context context, String str, String str2, CastOptions castOptions, zzbx zzbxVar, com.google.android.gms.cast.framework.media.internal.zzs zzsVar) {
        super(context, str, str2);
        this.zzd = new HashSet();
        this.zzc = context.getApplicationContext();
        this.zzf = castOptions;
        this.zzg = zzbxVar;
        this.zzh = zzsVar;
        this.zze = com.google.android.gms.internal.cast.zzay.zzc(context, castOptions, zzn(), new zzu(this, null));
    }

    private final void zzo(Bundle bundle) {
        CastDevice fromBundle = CastDevice.getFromBundle(bundle);
        this.zzk = fromBundle;
        if (fromBundle == null) {
            if (isResuming()) {
                notifyFailedToResumeSession(2153);
                return;
            } else {
                notifyFailedToStartSession(2151);
                return;
            }
        }
        com.google.android.gms.cast.zzq zzqVar = this.zzi;
        byte[] bArr = null;
        if (zzqVar != null) {
            zzqVar.zzd();
            this.zzi = null;
        }
        zzb.d("Acquiring a connection to Google Play Services for %s", this.zzk);
        CastDevice castDevice = (CastDevice) Preconditions.checkNotNull(this.zzk);
        Bundle bundle2 = new Bundle();
        CastOptions castOptions = this.zzf;
        CastMediaOptions castMediaOptions = castOptions == null ? null : castOptions.getCastMediaOptions();
        NotificationOptions notificationOptions = castMediaOptions == null ? null : castMediaOptions.getNotificationOptions();
        boolean z = castMediaOptions != null && castMediaOptions.zza();
        bundle2.putBoolean("com.google.android.gms.cast.EXTRA_CAST_FRAMEWORK_NOTIFICATION_ENABLED", notificationOptions != null);
        bundle2.putBoolean("com.google.android.gms.cast.EXTRA_CAST_REMOTE_CONTROL_NOTIFICATION_ENABLED", z);
        zzbx zzbxVar = this.zzg;
        bundle2.putBoolean("com.google.android.gms.cast.EXTRA_CAST_ALWAYS_FOLLOW_SESSION_ENABLED", zzbxVar.zzo());
        bundle2.putBoolean("com.google.android.gms.cast.EXTRA_USE_ROUTE_CONNECTION", zzbxVar.zzq());
        Cast.CastOptions.Builder builder = new Cast.CastOptions.Builder(castDevice, new zzv(this, bArr));
        builder.zza(bundle2);
        com.google.android.gms.cast.zzq zzqVarZza = Cast.zza(this.zzc, builder.build());
        zzqVarZza.zzb(new zzy(this, bArr));
        this.zzi = zzqVarZza;
        zzqVarZza.zzc();
    }

    public void addCastListener(Cast.Listener listener) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (listener != null) {
            this.zzd.add(listener);
        }
    }

    @Override // com.google.android.gms.cast.framework.Session
    protected void end(boolean z) {
        zzak zzakVar = this.zze;
        if (zzakVar != null) {
            try {
                zzakVar.zzj(z, 0);
            } catch (RemoteException e) {
                zzb.d(e, "Unable to call %s on %s.", "disconnectFromDevice", "zzak");
            }
            notifySessionEnded(0);
        }
    }

    public int getActiveInputState() throws IllegalStateException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        com.google.android.gms.cast.zzq zzqVar = this.zzi;
        if (zzqVar == null || !zzqVar.zza()) {
            return -1;
        }
        return zzqVar.zzm();
    }

    public Cast.ApplicationConnectionResult getApplicationConnectionResult() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzl;
    }

    public ApplicationMetadata getApplicationMetadata() throws IllegalStateException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        com.google.android.gms.cast.zzq zzqVar = this.zzi;
        if (zzqVar == null || !zzqVar.zza()) {
            return null;
        }
        return zzqVar.zzo();
    }

    public String getApplicationStatus() throws IllegalStateException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        com.google.android.gms.cast.zzq zzqVar = this.zzi;
        if (zzqVar == null || !zzqVar.zza()) {
            return null;
        }
        return zzqVar.zzp();
    }

    @Pure
    public CastDevice getCastDevice() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzk;
    }

    public RemoteMediaClient getRemoteMediaClient() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzj;
    }

    @Override // com.google.android.gms.cast.framework.Session
    public long getSessionRemainingTimeMs() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        RemoteMediaClient remoteMediaClient = this.zzj;
        if (remoteMediaClient == null) {
            return 0L;
        }
        return remoteMediaClient.getStreamDuration() - this.zzj.getApproximateStreamPosition();
    }

    public int getStandbyState() throws IllegalStateException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        com.google.android.gms.cast.zzq zzqVar = this.zzi;
        if (zzqVar == null || !zzqVar.zza()) {
            return -1;
        }
        return zzqVar.zzn();
    }

    public double getVolume() throws IllegalStateException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        com.google.android.gms.cast.zzq zzqVar = this.zzi;
        if (zzqVar == null || !zzqVar.zza()) {
            return 0.0d;
        }
        return zzqVar.zzj();
    }

    public boolean isMute() throws IllegalStateException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        com.google.android.gms.cast.zzq zzqVar = this.zzi;
        return zzqVar != null && zzqVar.zza() && zzqVar.zzl();
    }

    @Override // com.google.android.gms.cast.framework.Session
    protected void onResuming(Bundle bundle) {
        this.zzk = CastDevice.getFromBundle(bundle);
    }

    @Override // com.google.android.gms.cast.framework.Session
    protected void onStarting(Bundle bundle) {
        this.zzk = CastDevice.getFromBundle(bundle);
    }

    public void removeCastListener(Cast.Listener listener) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (listener != null) {
            this.zzd.remove(listener);
        }
    }

    public void removeMessageReceivedCallbacks(String str) throws IOException, IllegalArgumentException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        com.google.android.gms.cast.zzq zzqVar = this.zzi;
        if (zzqVar != null) {
            zzqVar.zzr(str);
        }
    }

    public void requestStatus() throws IllegalStateException, IOException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        com.google.android.gms.cast.zzq zzqVar = this.zzi;
        if (zzqVar != null) {
            zzqVar.zze();
        }
    }

    @Override // com.google.android.gms.cast.framework.Session
    protected void resume(Bundle bundle) {
        zzo(bundle);
    }

    public PendingResult<Status> sendMessage(String str, String str2) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        com.google.android.gms.cast.zzq zzqVar = this.zzi;
        return zzqVar == null ? PendingResults.immediatePendingResult(new Status(17)) : zzcj.zza(zzqVar.zzf(str, str2), zzx.zza, zzw.zza);
    }

    public void setMessageReceivedCallbacks(String str, Cast.MessageReceivedCallback messageReceivedCallback) throws IllegalStateException, IOException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        com.google.android.gms.cast.zzq zzqVar = this.zzi;
        if (zzqVar == null || !zzqVar.zza()) {
            return;
        }
        zzqVar.zzq(str, messageReceivedCallback);
    }

    public void setMute(boolean z) throws IllegalStateException, IOException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        com.google.android.gms.cast.zzq zzqVar = this.zzi;
        if (zzqVar == null || !zzqVar.zza()) {
            return;
        }
        zzqVar.zzk(z);
    }

    public void setVolume(double d) throws IOException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        com.google.android.gms.cast.zzq zzqVar = this.zzi;
        if (zzqVar == null || !zzqVar.zza()) {
            return;
        }
        zzqVar.zzi(d);
    }

    @Override // com.google.android.gms.cast.framework.Session
    protected void start(Bundle bundle) {
        zzo(bundle);
    }

    @Override // com.google.android.gms.cast.framework.Session
    protected final void zza(Bundle bundle) {
        CastDevice castDevice;
        CastDevice castDevice2;
        CastDevice fromBundle = CastDevice.getFromBundle(bundle);
        if (fromBundle == null || fromBundle.equals(this.zzk)) {
            return;
        }
        boolean z = false;
        if (!TextUtils.isEmpty(fromBundle.getFriendlyName()) && ((castDevice2 = this.zzk) == null || !TextUtils.equals(castDevice2.getFriendlyName(), fromBundle.getFriendlyName()))) {
            z = true;
        }
        this.zzk = fromBundle;
        zzb.d("update to device (%s) with name %s", fromBundle, true != z ? "unchanged" : "changed");
        if (!z || (castDevice = this.zzk) == null) {
            return;
        }
        com.google.android.gms.cast.framework.media.internal.zzs zzsVar = this.zzh;
        if (zzsVar != null) {
            zzsVar.zzc(castDevice);
        }
        Iterator it = new HashSet(this.zzd).iterator();
        while (it.hasNext()) {
            ((Cast.Listener) it.next()).onDeviceNameChanged();
        }
        zzr zzrVar = this.zzm;
        if (zzrVar != null) {
            zzrVar.zzd();
        }
    }

    public final void zzb(zzr zzrVar) {
        this.zzm = zzrVar;
    }

    public final com.google.android.gms.cast.framework.media.internal.zzs zzc() {
        return this.zzh;
    }

    public final boolean zzd() {
        return this.zzg.zzo();
    }

    final /* synthetic */ void zze(String str, Task task) {
        zzak zzakVar = this.zze;
        if (zzakVar == null) {
            return;
        }
        try {
            if (task.isSuccessful()) {
                Cast.ApplicationConnectionResult applicationConnectionResult = (Cast.ApplicationConnectionResult) task.getResult();
                this.zzl = applicationConnectionResult;
                if (applicationConnectionResult.getStatus() != null && applicationConnectionResult.getStatus().isSuccess()) {
                    zzb.d("%s() -> success result", str);
                    RemoteMediaClient remoteMediaClient = new RemoteMediaClient(new com.google.android.gms.cast.internal.zzar(null));
                    this.zzj = remoteMediaClient;
                    remoteMediaClient.zza(this.zzi);
                    this.zzj.registerCallback(new zzq(this));
                    this.zzj.zzb();
                    this.zzh.zza(this.zzj, getCastDevice());
                    zzakVar.zzh((ApplicationMetadata) Preconditions.checkNotNull(applicationConnectionResult.getApplicationMetadata()), applicationConnectionResult.getApplicationStatus(), (String) Preconditions.checkNotNull(applicationConnectionResult.getSessionId()), applicationConnectionResult.getWasLaunched());
                    return;
                }
                if (applicationConnectionResult.getStatus() != null) {
                    zzb.d("%s() -> failure result", str);
                    zzakVar.zzi(applicationConnectionResult.getStatus().getStatusCode());
                    return;
                }
            } else {
                Exception exception = task.getException();
                if (exception instanceof ApiException) {
                    zzakVar.zzi(((ApiException) exception).getStatusCode());
                    return;
                }
            }
            zzakVar.zzi(2476);
        } catch (RemoteException e) {
            zzb.d(e, "Unable to call %s on %s.", "methods", "zzak");
        }
    }

    final /* synthetic */ void zzf(int i) {
        this.zzh.zzb(i);
        com.google.android.gms.cast.zzq zzqVar = this.zzi;
        if (zzqVar != null) {
            zzqVar.zzd();
            this.zzi = null;
        }
        this.zzk = null;
        RemoteMediaClient remoteMediaClient = this.zzj;
        if (remoteMediaClient != null) {
            remoteMediaClient.zza(null);
            this.zzj = null;
        }
        this.zzl = null;
    }

    final /* synthetic */ Set zzh() {
        return this.zzd;
    }

    final /* synthetic */ zzak zzi() {
        return this.zze;
    }

    final /* synthetic */ com.google.android.gms.cast.zzq zzj() {
        return this.zzi;
    }

    final /* synthetic */ RemoteMediaClient zzk() {
        return this.zzj;
    }

    final /* synthetic */ zzr zzl() {
        return this.zzm;
    }
}
