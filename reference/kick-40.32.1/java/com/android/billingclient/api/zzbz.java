package com.android.billingclient.api;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.internal.play_billing.zzjj;
import com.google.android.gms.internal.play_billing.zzjl;
import com.google.android.gms.internal.play_billing.zzjn;
import com.google.android.gms.internal.play_billing.zzjp;
import com.google.android.gms.internal.play_billing.zzjq;
import com.google.android.gms.internal.play_billing.zzjs;
import com.google.android.gms.internal.play_billing.zzju;
import com.google.android.gms.internal.play_billing.zzjx;
import com.google.android.gms.internal.play_billing.zzle;
import com.google.android.gms.internal.play_billing.zzlg;
import com.google.android.gms.internal.play_billing.zzlk;
import com.google.android.gms.internal.play_billing.zzll;
import com.google.android.gms.internal.play_billing.zzln;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbz implements ServiceConnection {
    final /* synthetic */ BillingClientImpl zza;
    private final BillingClientStateListener zzb;
    private final com.google.android.gms.internal.play_billing.zzbn zzc;
    private final com.google.android.gms.internal.play_billing.zzbn zzd;
    private final int zze;

    /* synthetic */ zzbz(BillingClientImpl billingClientImpl, BillingClientStateListener billingClientStateListener, int i, zzcm zzcmVar) {
        Objects.requireNonNull(billingClientImpl);
        this.zza = billingClientImpl;
        this.zzc = com.google.android.gms.internal.play_billing.zzbn.zzc(billingClientImpl.zzN);
        this.zzd = com.google.android.gms.internal.play_billing.zzbn.zzc(billingClientImpl.zzN);
        this.zzb = billingClientStateListener;
        this.zze = i;
    }

    /* JADX WARN: Code duplicated, block: B:149:0x017b A[EDGE_INSN: B:149:0x017b->B:76:0x017b BREAK  A[LOOP:0: B:27:0x00a6->B:69:0x0150], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x0107  */
    /* JADX WARN: Code duplicated, block: B:67:0x0135  */
    /* JADX WARN: Instruction removed from duplicated block: B:67:0x0135, please report this as an issue */
    public static /* synthetic */ Object zza(zzbz zzbzVar) {
        Bundle bundle;
        com.google.android.gms.internal.play_billing.zzar zzarVar;
        int i;
        long j;
        long j2;
        BillingClientImpl billingClientImpl = zzbzVar.zza;
        synchronized (billingClientImpl.zza) {
            if (billingClientImpl.zzb != 3) {
                int i2 = 0;
                boolean z = true;
                boolean z2 = billingClientImpl.zzb == 1;
                if (TextUtils.isEmpty(null)) {
                    bundle = null;
                } else {
                    bundle = new Bundle();
                    bundle.putString("accountName", null);
                    com.google.android.gms.internal.play_billing.zzc.zzc(bundle, billingClientImpl.zzc, billingClientImpl.zzd, billingClientImpl.zzM.longValue());
                }
                zzjs zzjsVar = zzjs.REASON_UNSPECIFIED;
                synchronized (billingClientImpl.zza) {
                    zzarVar = billingClientImpl.zzi;
                }
                if (zzarVar != null) {
                    String packageName = zzbzVar.zza.zzg.getPackageName();
                    try {
                        if (zzarVar.zzb(25, packageName, BillingClient.ProductType.INAPP) != 0) {
                            Bundle bundle2 = bundle;
                            boolean z3 = z2;
                            int iZzb = 3;
                            int i3 = 29;
                            while (true) {
                                if (i3 < 3) {
                                    i3 = 0;
                                    break;
                                }
                                try {
                                    com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", zza.zza(i3, "trying subs apiVersion: "));
                                    iZzb = bundle2 == null ? zzarVar.zzb(i3, packageName, BillingClient.ProductType.SUBS) : zzarVar.zzc(i3, packageName, BillingClient.ProductType.SUBS, bundle2);
                                    if (iZzb == 0) {
                                        com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", zza.zza(i3, "highestLevelSupportedForSubs: "));
                                        break;
                                    }
                                    i3--;
                                } catch (Exception e) {
                                    zzbzVar.zzm(e, z3);
                                    return null;
                                }
                            }
                            BillingClientImpl billingClientImpl2 = zzbzVar.zza;
                            billingClientImpl2.zzl = i3 >= 5;
                            if (i3 < 3) {
                                z = false;
                            }
                            billingClientImpl2.zzk = z;
                            if (i3 < 3) {
                                zzjsVar = zzjs.SUBSCRIPTIONS_NOT_SUPPORTED;
                                com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "In-app billing API does not support subscription on this device.");
                            }
                            for (int i4 = 29; i4 >= 3; i4--) {
                                com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", zza.zza(i4, "trying inapp apiVersion: "));
                                iZzb = bundle2 == null ? zzarVar.zzb(i4, packageName, BillingClient.ProductType.INAPP) : zzarVar.zzc(i4, packageName, BillingClient.ProductType.INAPP, bundle2);
                                if (iZzb == 0) {
                                    billingClientImpl2.zzm = i4;
                                    com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "mHighestLevelSupportedForInApp: " + billingClientImpl2.zzm);
                                    break;
                                }
                            }
                            BillingClientImpl.zzat(billingClientImpl2, billingClientImpl2.zzm);
                            if (billingClientImpl2.zzm < 3) {
                                zzjsVar = zzjs.ONE_TIME_PRODUCT_NOT_SUPPORTED;
                                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "In-app billing API version 3 is not supported on this device.");
                            }
                            BillingClientImpl.zzav(billingClientImpl2, iZzb);
                            if (iZzb == 0) {
                                zzbzVar.zzj(z3, 0);
                                zzbzVar.zzk(zzdh.zzi);
                                return null;
                            }
                            BillingResult billingResult = zzdh.zzb;
                            zzbzVar.zzi(billingResult, zzjsVar, null, z3, 0);
                            zzbzVar.zzk(billingResult);
                            return null;
                        }
                        BillingClientImpl billingClientImpl3 = zzbzVar.zza;
                        long jZzb = zzet.zzb(billingClientImpl3.zzg);
                        long jZzc = zzet.zzc(billingClientImpl3.zzg);
                        double dZza = zzet.zza(billingClientImpl3.zzg);
                        boolean z4 = z2;
                        long jZzd = zzet.zzd(billingClientImpl3.zzg);
                        Exception e2 = null;
                        while (true) {
                            long j3 = i2;
                            if (j3 > jZzb) {
                                i = i2;
                                break;
                            }
                            j = jZzc;
                            try {
                                try {
                                    Boolean boolValueOf = Boolean.valueOf(z4);
                                    Bundle bundle3 = new Bundle();
                                    bundle3.putString("callingPackage", billingClientImpl3.zzg.getPackageName());
                                    j2 = jZzd;
                                    try {
                                        com.google.android.gms.internal.play_billing.zzc.zzc(bundle3, billingClientImpl3.zzc, billingClientImpl3.zzd, billingClientImpl3.zzM.longValue());
                                        if (billingClientImpl3.zzG != null && billingClientImpl3.zzG.isEnabledForOneTimeProducts()) {
                                            bundle3.putBoolean("enablePendingPurchases", true);
                                        }
                                        if (billingClientImpl3.zzG != null) {
                                            try {
                                                if (billingClientImpl3.zzG.isEnabledForPrepaidPlans()) {
                                                    try {
                                                        bundle3.putBoolean("enablePendingPurchaseForSubscriptions", true);
                                                    } catch (Exception e3) {
                                                        e2 = e3;
                                                        i = i2;
                                                        if (j3 == jZzb) {
                                                            zzbzVar.zzl(e2, z4, i);
                                                            return null;
                                                        }
                                                        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Transient error during initialize(), retrying in " + j + "ms", e2);
                                                        try {
                                                            Thread.sleep(j);
                                                            long j4 = j2;
                                                            i2 = i + 1;
                                                            jZzc = (long) Math.min(j * dZza, j4);
                                                            jZzd = j4;
                                                            zzarVar = zzarVar;
                                                        } catch (InterruptedException e4) {
                                                            Thread.currentThread().interrupt();
                                                            zzbzVar.zzl(e4, z4, i);
                                                            return null;
                                                        }
                                                    }
                                                }
                                            } catch (Exception e5) {
                                                e2 = e5;
                                            }
                                        }
                                        i = i2;
                                        try {
                                            try {
                                                try {
                                                    zzarVar.zzq(25, billingClientImpl3.zzg.getPackageName(), bundle3, new zzcg(billingClientImpl3, zzbzVar, boolValueOf, i, null));
                                                    return null;
                                                } catch (Exception e6) {
                                                    e2 = e6;
                                                    if (j3 == jZzb) {
                                                        zzbzVar.zzl(e2, z4, i);
                                                        return null;
                                                    }
                                                    com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Transient error during initialize(), retrying in " + j + "ms", e2);
                                                    Thread.sleep(j);
                                                    long j5 = j2;
                                                    i2 = i + 1;
                                                    jZzc = (long) Math.min(j * dZza, j5);
                                                    jZzd = j5;
                                                    zzarVar = zzarVar;
                                                }
                                            } catch (SecurityException e7) {
                                                e = e7;
                                                zzbzVar.zzl(e, z4, i);
                                                return null;
                                            }
                                        } catch (Exception e8) {
                                            e2 = e8;
                                            if (j3 == jZzb) {
                                                zzbzVar.zzl(e2, z4, i);
                                                return null;
                                            }
                                            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Transient error during initialize(), retrying in " + j + "ms", e2);
                                            Thread.sleep(j);
                                            long j6 = j2;
                                            i2 = i + 1;
                                            jZzc = (long) Math.min(j * dZza, j6);
                                            jZzd = j6;
                                            zzarVar = zzarVar;
                                        }
                                    } catch (Exception e9) {
                                        e2 = e9;
                                        i = i2;
                                    }
                                } catch (Exception e10) {
                                    e2 = e10;
                                    i = i2;
                                    j2 = jZzd;
                                }
                            } catch (SecurityException e11) {
                                e = e11;
                                i = i2;
                            }
                            long j7 = j2;
                            i2 = i + 1;
                            jZzc = (long) Math.min(j * dZza, j7);
                            jZzd = j7;
                            zzarVar = zzarVar;
                        }
                        zzbzVar.zzl(e2, z4, i);
                        return null;
                    } catch (Exception e12) {
                        zzbzVar.zzm(e12, z2);
                        return null;
                    }
                }
                BillingClientImpl billingClientImpl4 = zzbzVar.zza;
                billingClientImpl4.zzbs(0);
                int i5 = zzbzVar.zze;
                zzjs zzjsVar2 = zzjs.SERVICE_RESET_TO_NULL;
                BillingResult billingResult2 = zzdh.zzj;
                billingClientImpl4.zzbr(zzjsVar2, billingResult2, i5);
                zzbzVar.zzk(billingResult2);
            }
        }
        return null;
    }

    public static /* synthetic */ void zzb(zzbz zzbzVar) {
        BillingClientImpl billingClientImpl = zzbzVar.zza;
        billingClientImpl.zzbs(0);
        zzjs zzjsVar = zzjs.EXECUTE_ASYNC_TIMEOUT;
        BillingResult billingResult = zzdh.zzk;
        billingClientImpl.zzbr(zzjsVar, billingResult, zzbzVar.zze);
        zzbzVar.zzk(billingResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzi(BillingResult billingResult, zzjs zzjsVar, String str, boolean z, int i) {
        try {
            zzjq zzjqVarZza = zzju.zza();
            zzjqVarZza.zzp(billingResult.getResponseCode());
            zzjqVarZza.zzb(billingResult.getDebugMessage());
            zzjqVarZza.zze(zzjsVar);
            zzjqVarZza.zzc(i);
            if (str != null) {
                zzjqVarZza.zza(str);
            }
            Long lZzh = zzh(z);
            if (!z) {
                zzle zzleVarZza = zzlg.zza();
                zzleVarZza.zza(zzjqVarZza);
                if (lZzh != null) {
                    zzleVarZza.zzb(lZzh.longValue());
                }
                this.zza.zzh.zzm((zzlg) zzleVarZza.zzi());
                return;
            }
            zzll zzllVarZza = zzln.zza();
            int i2 = this.zze;
            zzllVarZza.zza(i2 > 0);
            zzllVarZza.zzb(i2);
            zzllVarZza.zzd(i);
            if (lZzh != null) {
                zzllVarZza.zzc(lZzh.longValue());
            }
            BillingClientImpl billingClientImpl = this.zza;
            zzjj zzjjVarZza = zzjl.zza();
            zzjjVarZza.zzb(zzjqVarZza);
            zzjjVarZza.zzp(6);
            zzjjVarZza.zze(zzllVarZza);
            billingClientImpl.zzbo((zzjl) zzjjVarZza.zzi());
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzj(boolean z, int i) {
        try {
            Long lZzh = zzh(z);
            if (!z) {
                zzle zzleVarZza = zzlg.zza();
                zzjq zzjqVarZza = zzju.zza();
                zzjqVarZza.zzp(0);
                zzjqVarZza.zzc(i);
                zzleVarZza.zza(zzjqVarZza);
                if (lZzh != null) {
                    zzleVarZza.zzb(lZzh.longValue());
                }
                this.zza.zzh.zzm((zzlg) zzleVarZza.zzi());
                return;
            }
            zzjn zzjnVarZza = zzjp.zza();
            zzjnVarZza.zze(6);
            zzll zzllVarZza = zzln.zza();
            int i2 = this.zze;
            zzllVarZza.zza(i2 > 0);
            zzllVarZza.zzb(i2);
            zzllVarZza.zzd(i);
            if (lZzh != null) {
                zzllVarZza.zzc(lZzh.longValue());
            }
            BillingClientImpl billingClientImpl = this.zza;
            zzjnVarZza.zzd(zzllVarZza);
            billingClientImpl.zzbq((zzjp) zzjnVarZza.zzi());
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzk(BillingResult billingResult) {
        BillingClientImpl billingClientImpl = this.zza;
        synchronized (billingClientImpl.zza) {
            if (billingClientImpl.zzb == 3) {
                return;
            }
            try {
                this.zzb.onBillingSetupFinished(billingResult);
            } catch (Throwable th) {
                com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Exception while calling onBillingSetupFinished.", th);
            }
        }
    }

    private final void zzl(Exception exc, boolean z, int i) {
        zzjs zzjsVar;
        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Exception while invoking initialize AIDL method", exc);
        if (exc instanceof DeadObjectException) {
            zzjsVar = zzjs.INITIALIZE_DEAD_OBJECT_EXCEPTION;
        } else if (exc instanceof RemoteException) {
            zzjsVar = zzjs.INITIALIZE_REMOTE_EXCEPTION;
        } else {
            zzjsVar = exc instanceof SecurityException ? zzjs.INITIALIZE_SECURITY_EXCEPTION : zzjs.INITIALIZE_SERVICE_CALL_EXCEPTION;
        }
        zzjs zzjsVar2 = zzjsVar;
        String strZza = zzdc.zza(exc);
        this.zza.zzbs(0);
        zzi(BillingClientImpl.zzn(exc), zzjsVar2, strZza, z, i);
        zzk(BillingClientImpl.zzn(exc));
    }

    private final void zzm(Exception exc, boolean z) {
        zzjs zzjsVar;
        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Exception while checking if billing is supported; try to reconnect", exc);
        if (exc instanceof DeadObjectException) {
            zzjsVar = zzjs.IS_BILLING_SUPPORTED_DEAD_OBJECT_EXCEPTION;
        } else if (exc instanceof RemoteException) {
            zzjsVar = zzjs.IS_BILLING_SUPPORTED_REMOTE_EXCEPTION;
        } else {
            zzjsVar = exc instanceof SecurityException ? zzjs.IS_BILLING_SUPPORTED_SECURITY_EXCEPTION : zzjs.IS_BILLING_SUPPORTED_SERVICE_CALL_EXCEPTION;
        }
        zzjs zzjsVar2 = zzjsVar;
        String strZza = zzjsVar2.equals(zzjs.IS_BILLING_SUPPORTED_SERVICE_CALL_EXCEPTION) ? zzdc.zza(exc) : null;
        this.zza.zzbs(0);
        zzi(BillingClientImpl.zzn(exc), zzjsVar2, strZza, z, 0);
        zzk(BillingClientImpl.zzn(exc));
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Billing service died.");
        try {
            BillingClientImpl billingClientImpl = this.zza;
            if (BillingClientImpl.zzaz(billingClientImpl)) {
                zzdd zzddVar = billingClientImpl.zzh;
                zzjj zzjjVarZza = zzjl.zza();
                zzjjVarZza.zzp(6);
                zzjq zzjqVarZza = zzju.zza();
                zzjqVarZza.zze(zzjs.BINDING_DIED);
                zzjjVarZza.zzb(zzjqVarZza);
                zzll zzllVarZza = zzln.zza();
                int i = this.zze;
                zzllVarZza.zza(i > 0);
                zzllVarZza.zzb(i);
                zzjjVarZza.zze(zzllVarZza);
                zzddVar.zza((zzjl) zzjjVarZza.zzi());
            } else {
                billingClientImpl.zzh.zzi(zzjx.zzb());
            }
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to log.", th);
        }
        BillingClientImpl billingClientImpl2 = this.zza;
        synchronized (billingClientImpl2.zza) {
            if (billingClientImpl2.zzb != 3 && billingClientImpl2.zzb != 0) {
                billingClientImpl2.zzbs(0);
                billingClientImpl2.zzbv();
                try {
                    this.zzb.onBillingServiceDisconnected();
                } catch (Throwable th2) {
                    com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Exception while calling onBillingServiceDisconnected.", th2);
                }
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Billing service connected.");
        BillingClientImpl billingClientImpl = this.zza;
        synchronized (billingClientImpl.zza) {
            if (billingClientImpl.zzb == 3) {
                return;
            }
            billingClientImpl.zzi = com.google.android.gms.internal.play_billing.zzaq.zzu(iBinder);
            if (BillingClientImpl.zzP(new Callable() { // from class: com.android.billingclient.api.zzbx
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    zzbz.zza(this.zza);
                    return null;
                }
            }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzby
                @Override // java.lang.Runnable
                public final void run() {
                    zzbz.zzb(this.zza);
                }
            }, billingClientImpl.zzaE(), billingClientImpl.zzO()) == null) {
                int i = this.zze;
                BillingResult billingResultZzaH = billingClientImpl.zzaH();
                billingClientImpl.zzbr(zzjs.MISSING_RESULT_FROM_EXECUTE_ASYNC, billingResultZzaH, i);
                zzk(billingResultZzaH);
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Billing service disconnected.");
        try {
            BillingClientImpl billingClientImpl = this.zza;
            if (BillingClientImpl.zzaz(billingClientImpl)) {
                zzdd zzddVar = billingClientImpl.zzh;
                zzjj zzjjVarZza = zzjl.zza();
                zzjjVarZza.zzp(6);
                zzjq zzjqVarZza = zzju.zza();
                zzjqVarZza.zze(zzjs.SERVICE_DISCONNECTED);
                zzjjVarZza.zzb(zzjqVarZza);
                zzll zzllVarZza = zzln.zza();
                int i = this.zze;
                zzllVarZza.zza(i > 0);
                zzllVarZza.zzb(i);
                zzjjVarZza.zze(zzllVarZza);
                zzddVar.zza((zzjl) zzjjVarZza.zzi());
            } else {
                billingClientImpl.zzh.zzn(zzlk.zzb());
            }
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to log.", th);
        }
        BillingClientImpl billingClientImpl2 = this.zza;
        synchronized (billingClientImpl2.zza) {
            if (zzdq.zzi()) {
                if (billingClientImpl2.zzb != 3 && billingClientImpl2.zzb != 0) {
                    com.google.android.gms.internal.play_billing.zzbn zzbnVar = this.zzd;
                    zzbnVar.zzd();
                    zzbnVar.zze();
                }
                return;
            }
            com.google.android.gms.internal.play_billing.zzbn zzbnVar2 = this.zzd;
            zzbnVar2.zzd();
            zzbnVar2.zze();
            if (billingClientImpl2.zzb == 3) {
                return;
            }
            billingClientImpl2.zzbs(0);
            try {
                this.zzb.onBillingServiceDisconnected();
            } catch (Throwable th2) {
                com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Exception while calling onBillingServiceDisconnected.", th2);
            }
        }
    }

    public final void zzf() {
        synchronized (this.zza.zza) {
            com.google.android.gms.internal.play_billing.zzbn zzbnVar = this.zzc;
            zzbnVar.zzd();
            zzbnVar.zze();
        }
    }

    final boolean zzg() {
        return this.zze > 0;
    }

    private final Long zzh(boolean z) {
        BillingClientImpl billingClientImpl = this.zza;
        try {
            if (z) {
                synchronized (billingClientImpl.zza) {
                    com.google.android.gms.internal.play_billing.zzbn zzbnVar = this.zzc;
                    if (!zzbnVar.zzg()) {
                        return null;
                    }
                    zzbnVar.zzf();
                    return Long.valueOf(zzbnVar.zza(TimeUnit.MILLISECONDS));
                }
            }
            synchronized (billingClientImpl.zza) {
                com.google.android.gms.internal.play_billing.zzbn zzbnVar2 = this.zzd;
                if (!zzbnVar2.zzg()) {
                    return null;
                }
                zzbnVar2.zzf();
                return Long.valueOf(zzbnVar2.zza(TimeUnit.MILLISECONDS));
            }
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Exception getting connection establishment duration.", th);
        }
        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Exception getting connection establishment duration.", th);
        return null;
    }
}
