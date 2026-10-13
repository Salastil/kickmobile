package com.google.android.gms.cast.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.zzbn;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.internal.cast.zzff;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzx extends GmsClient {
    public static final /* synthetic */ int zze = 0;
    private final Map zzA;
    private BaseImplementation.ResultHolder zzB;
    private BaseImplementation.ResultHolder zzC;
    private ApplicationMetadata zzg;
    private final CastDevice zzh;
    private final Cast.Listener zzi;
    private final Map zzj;
    private final long zzk;
    private final Bundle zzl;
    private zzw zzm;
    private String zzn;
    private boolean zzo;
    private boolean zzp;
    private boolean zzq;
    private boolean zzr;
    private double zzs;
    private com.google.android.gms.cast.zzao zzt;
    private int zzu;
    private int zzv;
    private final AtomicLong zzw;
    private String zzx;
    private String zzy;
    private Bundle zzz;
    private static final Logger zzf = new Logger("CastClientImpl");
    private static final Object zzD = new Object();
    private static final Object zzE = new Object();

    public zzx(Context context, Looper looper, ClientSettings clientSettings, CastDevice castDevice, long j, Cast.Listener listener, Bundle bundle, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 10, clientSettings, (ConnectionCallbacks) connectionCallbacks, (OnConnectionFailedListener) onConnectionFailedListener);
        this.zzh = castDevice;
        this.zzi = listener;
        this.zzk = j;
        this.zzl = bundle;
        this.zzj = new HashMap();
        this.zzw = new AtomicLong(0L);
        this.zzA = new HashMap();
        zzI();
        zzG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzY, reason: merged with bridge method [inline-methods] */
    public final void zzI() {
        this.zzr = false;
        this.zzu = -1;
        this.zzv = -1;
        this.zzg = null;
        this.zzn = null;
        this.zzs = 0.0d;
        zzG();
        this.zzo = false;
        this.zzt = null;
    }

    private final void zzZ(BaseImplementation.ResultHolder resultHolder) {
        synchronized (zzD) {
            BaseImplementation.ResultHolder resultHolder2 = this.zzB;
            if (resultHolder2 != null) {
                resultHolder2.setResult(new zzr(new Status(2477), null, null, null, false));
            }
            this.zzB = resultHolder;
        }
    }

    private final void zzaa(BaseImplementation.ResultHolder resultHolder) {
        synchronized (zzE) {
            if (this.zzC != null) {
                resultHolder.setResult(new Status(2001));
            } else {
                this.zzC = resultHolder;
            }
        }
    }

    private final void zzab() {
        zzf.d("removing all MessageReceivedCallbacks", new Object[0]);
        Map map = this.zzj;
        synchronized (map) {
            map.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzac, reason: merged with bridge method [inline-methods] */
    public final void zzL(long j, int i) {
        BaseImplementation.ResultHolder resultHolder;
        Map map = this.zzA;
        synchronized (map) {
            resultHolder = (BaseImplementation.ResultHolder) map.remove(Long.valueOf(j));
        }
        if (resultHolder != null) {
            resultHolder.setResult(new Status(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzad, reason: merged with bridge method [inline-methods] */
    public final void zzM(int i) {
        synchronized (zzE) {
            BaseImplementation.ResultHolder resultHolder = this.zzC;
            if (resultHolder != null) {
                resultHolder.setResult(new Status(i));
                this.zzC = null;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.internal.ICastDeviceController");
        return iInterfaceQueryLocalInterface instanceof zzah ? (zzah) iInterfaceQueryLocalInterface : new zzah(iBinder);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final void disconnect() {
        Logger logger = zzf;
        logger.d("disconnect(); ServiceListener=%s, isConnected=%b", this.zzm, Boolean.valueOf(isConnected()));
        zzw zzwVar = this.zzm;
        this.zzm = null;
        if (zzwVar == null || zzwVar.zzq() == null) {
            logger.d("already disposed, so short-circuiting", new Object[0]);
            return;
        }
        zzab();
        try {
            try {
                ((zzah) getService()).zze(zzff.zza(getContext()));
            } finally {
                super.disconnect();
            }
        } catch (RemoteException | IllegalStateException e) {
            zzf.d(e, "Error while disconnecting the controller interface", new Object[0]);
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Bundle getConnectionHint() {
        Bundle bundle = this.zzz;
        if (bundle == null) {
            return super.getConnectionHint();
        }
        this.zzz = null;
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final Bundle getGetServiceRequestExtraArgs() {
        Bundle bundle = new Bundle();
        zzf.d("getRemoteService(): mLastApplicationId=%s, mLastSessionId=%s", this.zzx, this.zzy);
        this.zzh.putInBundle(bundle);
        bundle.putLong("com.google.android.gms.cast.EXTRA_CAST_FLAGS", this.zzk);
        Bundle bundle2 = this.zzl;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        this.zzm = new zzw(this);
        bundle.putParcelable(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, new BinderWrapper(this.zzm));
        String str = this.zzx;
        if (str != null) {
            bundle.putString("last_application_id", str);
            String str2 = this.zzy;
            if (str2 != null) {
                bundle.putString("last_session_id", str2);
            }
        }
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return 12800000;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getServiceDescriptor() {
        return "com.google.android.gms.cast.internal.ICastDeviceController";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getStartServiceAction() {
        return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        super.onConnectionFailed(connectionResult);
        zzab();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final void onPostInitHandler(int i, IBinder iBinder, Bundle bundle, int i2) {
        zzf.d("in onPostInitHandler; statusCode=%d", Integer.valueOf(i));
        if (i == 0 || i == 2300) {
            this.zzr = true;
            this.zzp = true;
            this.zzq = true;
        } else {
            this.zzr = false;
        }
        if (i == 2300) {
            Bundle bundle2 = new Bundle();
            this.zzz = bundle2;
            bundle2.putBoolean(Cast.EXTRA_APP_NO_LONGER_RUNNING, true);
            i = 0;
        }
        super.onPostInitHandler(i, iBinder, bundle, i2);
    }

    public final int zzA() throws IllegalStateException {
        checkConnected();
        return this.zzv;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzB(String str, Cast.MessageReceivedCallback messageReceivedCallback) throws IllegalStateException, RemoteException, IllegalArgumentException {
        CastUtils.throwIfInvalidNamespace(str);
        zzC(str);
        if (messageReceivedCallback != null) {
            Map map = this.zzj;
            synchronized (map) {
                map.put(str, messageReceivedCallback);
            }
            zzah zzahVar = (zzah) getService();
            if (zzF()) {
                zzahVar.zzl(str, zzff.zza(getContext()));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzC(String str) throws RemoteException, IllegalArgumentException {
        Cast.MessageReceivedCallback messageReceivedCallback;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Channel namespace cannot be null or empty");
        }
        Map map = this.zzj;
        synchronized (map) {
            messageReceivedCallback = (Cast.MessageReceivedCallback) map.remove(str);
        }
        if (messageReceivedCallback != null) {
            try {
                ((zzah) getService()).zzm(str, zzff.zza(getContext()));
            } catch (IllegalStateException e) {
                zzf.d(e, "Error unregistering namespace (%s)", str);
            }
        }
    }

    public final ApplicationMetadata zzD() throws IllegalStateException {
        checkConnected();
        return this.zzg;
    }

    public final String zzE() throws IllegalStateException {
        checkConnected();
        return this.zzn;
    }

    final boolean zzF() {
        zzw zzwVar;
        return (!this.zzr || (zzwVar = this.zzm) == null || zzwVar.zzr()) ? false : true;
    }

    final double zzG() {
        CastDevice castDevice = this.zzh;
        Preconditions.checkNotNull(castDevice, "device should not be null");
        if (castDevice.hasCapability(2048)) {
            return 0.02d;
        }
        return (!castDevice.hasCapability(4) || castDevice.hasCapability(1) || "Chromecast Audio".equals(castDevice.getModelName())) ? 0.05d : 0.02d;
    }

    public final void zzH(int i) {
        synchronized (zzD) {
            BaseImplementation.ResultHolder resultHolder = this.zzB;
            if (resultHolder != null) {
                resultHolder.setResult(new zzr(new Status(i), null, null, null, false));
                this.zzB = null;
            }
        }
    }

    final /* synthetic */ void zzJ(zzac zzacVar) {
        boolean z;
        boolean z2;
        ApplicationMetadata applicationMetadataZze = zzacVar.zze();
        if (!CastUtils.zza(applicationMetadataZze, this.zzg)) {
            this.zzg = applicationMetadataZze;
            this.zzi.onApplicationMetadataChanged(applicationMetadataZze);
        }
        double dZza = zzacVar.zza();
        boolean z3 = true;
        if (Double.isNaN(dZza) || Math.abs(dZza - this.zzs) <= 1.0E-7d) {
            z = false;
        } else {
            this.zzs = dZza;
            z = true;
        }
        boolean zZzb = zzacVar.zzb();
        if (zZzb != this.zzo) {
            this.zzo = zZzb;
            z = true;
        }
        Double.isNaN(zzacVar.zzg());
        Logger logger = zzf;
        logger.d("hasVolumeChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(this.zzq));
        Cast.Listener listener = this.zzi;
        if (listener != null && (z || this.zzq)) {
            listener.onVolumeChanged();
        }
        int iZzc = zzacVar.zzc();
        if (iZzc != this.zzu) {
            this.zzu = iZzc;
            z2 = true;
        } else {
            z2 = false;
        }
        logger.d("hasActiveInputChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z2), Boolean.valueOf(this.zzq));
        if (listener != null && (z2 || this.zzq)) {
            listener.onActiveInputStateChanged(this.zzu);
        }
        int iZzd = zzacVar.zzd();
        if (iZzd != this.zzv) {
            this.zzv = iZzd;
        } else {
            z3 = false;
        }
        logger.d("hasStandbyStateChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z3), Boolean.valueOf(this.zzq));
        if (listener != null && (z3 || this.zzq)) {
            listener.onStandbyStateChanged(this.zzv);
        }
        if (!CastUtils.zza(this.zzt, zzacVar.zzf())) {
            this.zzt = zzacVar.zzf();
        }
        this.zzq = false;
    }

    final /* synthetic */ void zzK(zza zzaVar) {
        boolean z;
        String strZza = zzaVar.zza();
        if (CastUtils.zza(strZza, this.zzn)) {
            z = false;
        } else {
            this.zzn = strZza;
            z = true;
        }
        zzf.d("hasChanged=%b, mFirstApplicationStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(this.zzp));
        Cast.Listener listener = this.zzi;
        if (listener != null && (z || this.zzp)) {
            listener.onApplicationStatusChanged();
        }
        this.zzp = false;
    }

    final /* synthetic */ void zzO(ApplicationMetadata applicationMetadata) {
        this.zzg = applicationMetadata;
    }

    final /* synthetic */ CastDevice zzP() {
        return this.zzh;
    }

    final /* synthetic */ Cast.Listener zzQ() {
        return this.zzi;
    }

    final /* synthetic */ Map zzR() {
        return this.zzj;
    }

    final /* synthetic */ void zzS(String str) {
        this.zzn = str;
    }

    final /* synthetic */ void zzT(String str) {
        this.zzx = str;
    }

    final /* synthetic */ void zzU(String str) {
        this.zzy = str;
    }

    final /* synthetic */ BaseImplementation.ResultHolder zzV() {
        return this.zzB;
    }

    final /* synthetic */ void zzW(BaseImplementation.ResultHolder resultHolder) {
        this.zzB = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzp(String str, String str2, BaseImplementation.ResultHolder resultHolder) throws IllegalStateException, RemoteException, IllegalArgumentException {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("The message payload cannot be null or empty");
        }
        if (str2.length() > 524288) {
            zzf.w("Message send failed. Message exceeds maximum size", new Object[0]);
            throw new IllegalArgumentException("Message exceeds maximum size");
        }
        CastUtils.throwIfInvalidNamespace(str);
        long jIncrementAndGet = this.zzw.incrementAndGet();
        try {
            this.zzA.put(Long.valueOf(jIncrementAndGet), resultHolder);
            zzah zzahVar = (zzah) getService();
            if (zzF()) {
                zzahVar.zzk(str, str2, jIncrementAndGet, zzff.zza(getContext()));
            } else {
                zzL(jIncrementAndGet, 2016);
            }
        } catch (Throwable th) {
            this.zzA.remove(Long.valueOf(jIncrementAndGet));
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzq(String str, LaunchOptions launchOptions, BaseImplementation.ResultHolder resultHolder) throws IllegalStateException, RemoteException {
        zzZ(resultHolder);
        zzah zzahVar = (zzah) getService();
        if (zzF()) {
            zzahVar.zzn(str, launchOptions, zzff.zza(getContext()));
        } else {
            zzH(2016);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzr(String str, String str2, zzbn zzbnVar, BaseImplementation.ResultHolder resultHolder) throws IllegalStateException, RemoteException {
        zzZ(resultHolder);
        zzbn zzbnVar2 = new zzbn();
        zzah zzahVar = (zzah) getService();
        if (zzF()) {
            zzahVar.zzo(str, str2, zzbnVar2, zzff.zza(getContext()));
        } else {
            zzH(2016);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzs(BaseImplementation.ResultHolder resultHolder) throws IllegalStateException, RemoteException {
        zzaa(resultHolder);
        zzah zzahVar = (zzah) getService();
        if (zzF()) {
            zzahVar.zzf(zzff.zza(getContext()));
        } else {
            zzM(2016);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzt(String str, BaseImplementation.ResultHolder resultHolder) throws IllegalStateException, RemoteException {
        zzaa(resultHolder);
        zzah zzahVar = (zzah) getService();
        if (zzF()) {
            zzahVar.zzg(str, zzff.zza(getContext()));
        } else {
            zzM(2016);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzu() throws IllegalStateException, RemoteException {
        zzah zzahVar = (zzah) getService();
        if (zzF()) {
            zzahVar.zzh(zzff.zza(getContext()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzv(double d) throws IllegalStateException, RemoteException, IllegalArgumentException {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            StringBuilder sb = new StringBuilder(String.valueOf(d).length() + 17);
            sb.append("Volume cannot be ");
            sb.append(d);
            throw new IllegalArgumentException(sb.toString());
        }
        zzah zzahVar = (zzah) getService();
        if (zzF()) {
            zzahVar.zzi(d, this.zzs, this.zzo, zzff.zza(getContext()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzw(boolean z) throws IllegalStateException, RemoteException {
        zzah zzahVar = (zzah) getService();
        if (zzF()) {
            zzahVar.zzj(z, this.zzs, this.zzo, zzff.zza(getContext()));
        }
    }

    public final double zzx() throws IllegalStateException {
        checkConnected();
        return this.zzs;
    }

    public final boolean zzy() throws IllegalStateException {
        checkConnected();
        return this.zzo;
    }

    public final int zzz() throws IllegalStateException {
        checkConnected();
        return this.zzu;
    }
}
