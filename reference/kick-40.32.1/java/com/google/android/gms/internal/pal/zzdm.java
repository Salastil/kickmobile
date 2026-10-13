package com.google.android.gms.internal.pal;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import androidx.compose.ui.autofill.AutofillUtils_androidKt;
import androidx.media3.common.PlaybackException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzdm implements zzdp {
    private static zzdm zzb;
    private final Context zzc;
    private final zzkc zzd;
    private final zzkj zze;
    private final zzkl zzf;
    private final zzev zzg;
    private final zzjc zzh;
    private final Executor zzi;
    private final zzki zzj;
    private final zzfk zzl;
    private final zzfc zzm;
    private volatile boolean zzo;
    private volatile boolean zzp;
    private final int zzq;
    volatile long zza = 0;
    private final Object zzn = new Object();
    private final CountDownLatch zzk = new CountDownLatch(1);

    zzdm(Context context, zzjc zzjcVar, zzkc zzkcVar, zzkj zzkjVar, zzkl zzklVar, zzev zzevVar, Executor executor, zzix zzixVar, int i, zzfk zzfkVar, zzfc zzfcVar, zzet zzetVar) {
        this.zzp = false;
        this.zzc = context;
        this.zzh = zzjcVar;
        this.zzd = zzkcVar;
        this.zze = zzkjVar;
        this.zzf = zzklVar;
        this.zzg = zzevVar;
        this.zzi = executor;
        this.zzq = i;
        this.zzl = zzfkVar;
        this.zzm = zzfcVar;
        this.zzp = false;
        this.zzj = new zzdk(this, zzixVar);
    }

    @Deprecated
    public static synchronized zzdm zza(String str, Context context, Executor executor, boolean z, boolean z2) {
        zzjd zzjdVarZzh;
        zzjdVarZzh = zzje.zzh();
        zzjdVarZzh.zza(str);
        zzjdVarZzh.zzb(z);
        return zzt(context, executor, zzjdVarZzh.zzh(), z2);
    }

    @Deprecated
    public static synchronized zzdm zzb(String str, Context context, boolean z, boolean z2) {
        return zza(str, context, Executors.newCachedThreadPool(), z, z2);
    }

    private static synchronized zzdm zzt(Context context, Executor executor, zzje zzjeVar, boolean z) {
        if (zzb == null) {
            zzjc zzjcVarZza = zzjc.zza(context, executor, z);
            zzee zzeeVarZza = zzee.zza(context);
            zzfk zzfkVarZza = zzfk.zza(context, executor);
            zzfc zzfcVar = new zzfc();
            zzet zzetVar = new zzet();
            zzjq zzjqVarZza = zzjq.zza(context, executor, zzjcVarZza, zzjeVar);
            zzeu zzeuVar = new zzeu(context);
            zzev zzevVar = new zzev(zzjeVar, zzjqVarZza, new zzfi(context, zzeuVar), zzeuVar, zzeeVarZza, zzfkVarZza, zzfcVar, zzetVar);
            int iZzb = zzjr.zzb(context, zzjcVarZza);
            zzix zzixVar = new zzix();
            zzdm zzdmVar = new zzdm(context, zzjcVarZza, new zzkc(context, iZzb), new zzkj(context, iZzb, new zzdj(zzjcVarZza), ((Boolean) zzhi.zzc().zzc(zzia.zzb)).booleanValue()), new zzkl(context, zzevVar, zzjcVarZza, zzixVar, false), zzevVar, executor, zzixVar, iZzb, zzfkVarZza, zzfcVar, zzetVar);
            zzb = zzdmVar;
            zzdmVar.zzd();
            zzb.zzn();
        }
        return zzb;
    }

    private final zzkb zzu(int i) {
        if (zzjr.zza(this.zzq)) {
            return ((Boolean) zzhi.zzc().zzc(zzia.zza)).booleanValue() ? this.zze.zzc(1) : this.zzd.zzb(1);
        }
        return null;
    }

    public final synchronized boolean zzc() {
        return this.zzp;
    }

    final synchronized void zzd() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        zzkb zzkbVarZzu = zzu(1);
        if (zzkbVarZzu == null) {
            this.zzh.zzb(4013, System.currentTimeMillis() - jCurrentTimeMillis);
        } else if (this.zzf.zza(zzkbVarZzu)) {
            this.zzp = true;
            this.zzk.countDown();
        }
    }

    @Override // com.google.android.gms.internal.pal.zzdp
    public final boolean zze() {
        return zzc();
    }

    @Override // com.google.android.gms.internal.pal.zzdp
    public final boolean zzf() {
        try {
            this.zzk.await();
        } catch (InterruptedException unused) {
        }
        return zzc();
    }

    @Override // com.google.android.gms.internal.pal.zzdp
    public final void zzg(MotionEvent motionEvent) {
        zzjf zzjfVarZzb = this.zzf.zzb();
        if (zzjfVarZzb != null) {
            try {
                zzjfVarZzb.zzd(null, motionEvent);
            } catch (zzkk e) {
                this.zzh.zzc(e.zza(), -1L, e);
            }
        }
    }

    @Override // com.google.android.gms.internal.pal.zzdp
    public final void zzh(int i, int i2, int i3) {
        DisplayMetrics displayMetrics;
        if (!((Boolean) zzhi.zzc().zzc(zzia.zzx)).booleanValue() || (displayMetrics = this.zzc.getResources().getDisplayMetrics()) == null) {
            return;
        }
        float f = i;
        float f2 = i2;
        MotionEvent motionEventObtain = MotionEvent.obtain(0L, 0L, 0, f * displayMetrics.density, f2 * displayMetrics.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        zzg(motionEventObtain);
        motionEventObtain.recycle();
        MotionEvent motionEventObtain2 = MotionEvent.obtain(0L, 0L, 2, f * displayMetrics.density, f2 * displayMetrics.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        zzg(motionEventObtain2);
        motionEventObtain2.recycle();
        MotionEvent motionEventObtain3 = MotionEvent.obtain(0L, i3, 1, f * displayMetrics.density, f2 * displayMetrics.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        zzg(motionEventObtain3);
        motionEventObtain3.recycle();
    }

    @Override // com.google.android.gms.internal.pal.zzdp
    public final String zzi(Context context, String str, View view, Activity activity) {
        this.zzl.zzb();
        this.zzm.zzc();
        zzn();
        zzjf zzjfVarZzb = this.zzf.zzb();
        if (zzjfVarZzb == null) {
            return "";
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strZzc = zzjfVarZzb.zzc(context, null, str, view, activity);
        this.zzh.zzd(AutofillUtils_androidKt.MAX_AUTOFILL_TEXT_LENGTH, System.currentTimeMillis() - jCurrentTimeMillis, strZzc, null);
        return strZzc;
    }

    @Override // com.google.android.gms.internal.pal.zzdp
    public final void zzj(View view) {
        this.zzg.zza(view);
    }

    @Override // com.google.android.gms.internal.pal.zzdp
    public final String zzk(Context context, View view, Activity activity) {
        this.zzl.zzb();
        this.zzm.zzb(context, view);
        zzn();
        zzjf zzjfVarZzb = this.zzf.zzb();
        if (zzjfVarZzb == null) {
            return "";
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strZzb = zzjfVarZzb.zzb(context, null, view, activity);
        this.zzh.zzd(PlaybackException.ERROR_CODE_AUDIO_TRACK_WRITE_FAILED, System.currentTimeMillis() - jCurrentTimeMillis, strZzb, null);
        return strZzb;
    }

    @Override // com.google.android.gms.internal.pal.zzdp
    public final String zzl(Context context) {
        this.zzl.zzb();
        this.zzm.zza();
        zzn();
        zzjf zzjfVarZzb = this.zzf.zzb();
        if (zzjfVarZzb == null) {
            return "";
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strZza = zzjfVarZzb.zza(context, null);
        this.zzh.zzd(PlaybackException.ERROR_CODE_AUDIO_TRACK_INIT_FAILED, System.currentTimeMillis() - jCurrentTimeMillis, strZza, null);
        return strZza;
    }

    @Override // com.google.android.gms.internal.pal.zzdp
    public final String zzm(Context context, byte[] bArr) {
        throw null;
    }

    public final void zzn() {
        if (this.zzo) {
            return;
        }
        synchronized (this.zzn) {
            if (!this.zzo) {
                if ((System.currentTimeMillis() / 1000) - this.zza < 3600) {
                    return;
                }
                zzkb zzkbVarZzc = this.zzf.zzc();
                if ((zzkbVarZzc == null || zzkbVarZzc.zze(3600L)) && zzjr.zza(this.zzq)) {
                    this.zzi.execute(new zzdl(this));
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00ce A[Catch: all -> 0x011a, zzavb -> 0x011c, TryCatch #1 {zzavb -> 0x011c, blocks: (B:6:0x0021, B:8:0x0032, B:12:0x0038, B:13:0x0044, B:15:0x0052, B:17:0x0060, B:20:0x006d, B:27:0x009c, B:31:0x00b5, B:37:0x00ce, B:38:0x00db, B:40:0x00e1, B:42:0x00e9, B:43:0x00eb, B:34:0x00bf, B:35:0x00c6, B:23:0x0074, B:25:0x008a, B:44:0x00f5, B:45:0x0102, B:46:0x010f), top: B:58:0x0021, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00f5 A[Catch: all -> 0x011a, zzavb -> 0x011c, TryCatch #1 {zzavb -> 0x011c, blocks: (B:6:0x0021, B:8:0x0032, B:12:0x0038, B:13:0x0044, B:15:0x0052, B:17:0x0060, B:20:0x006d, B:27:0x009c, B:31:0x00b5, B:37:0x00ce, B:38:0x00db, B:40:0x00e1, B:42:0x00e9, B:43:0x00eb, B:34:0x00bf, B:35:0x00c6, B:23:0x0074, B:25:0x008a, B:44:0x00f5, B:45:0x0102, B:46:0x010f), top: B:58:0x0021, outer: #2 }] */
    final /* synthetic */ void zzo() {
        String str;
        String strZzb;
        int length;
        boolean zZza;
        long jCurrentTimeMillis = System.currentTimeMillis();
        zzkb zzkbVarZzu = zzu(1);
        if (zzkbVarZzu != null) {
            String strZza = zzkbVarZzu.zza().zza();
            strZzb = zzkbVarZzu.zza().zzb();
            str = strZza;
        } else {
            str = null;
            strZzb = null;
        }
        try {
            try {
                Context context = this.zzc;
                int i = this.zzq;
                zzjc zzjcVar = this.zzh;
                zzkg zzkgVarZza = zzjl.zza(context, 1, i, str, strZzb, "1", zzjcVar);
                byte[] bArr = zzkgVarZza.zzb;
                if (bArr == null || (length = bArr.length) == 0) {
                    zzjcVar.zzb(5009, System.currentTimeMillis() - jCurrentTimeMillis);
                } else {
                    try {
                        zzgt zzgtVarZzd = zzgt.zzd(zzatl.zzr(bArr, 0, length), zzaty.zza());
                        if (zzgtVarZzd.zza().zza().isEmpty() || zzgtVarZzd.zza().zzb().isEmpty() || zzgtVarZzd.zzc().zzx().length == 0) {
                            this.zzh.zzb(5010, System.currentTimeMillis() - jCurrentTimeMillis);
                        } else {
                            zzkb zzkbVarZzu2 = zzu(1);
                            if (zzkbVarZzu2 != null) {
                                zzgv zzgvVarZza = zzkbVarZzu2.zza();
                                if (zzgtVarZzd.zza().zza().equals(zzgvVarZza.zza()) && zzgtVarZzd.zza().zzb().equals(zzgvVarZza.zzb())) {
                                    this.zzh.zzb(5010, System.currentTimeMillis() - jCurrentTimeMillis);
                                }
                            }
                            zzki zzkiVar = this.zzj;
                            int i2 = zzkgVarZza.zzc;
                            if (!((Boolean) zzhi.zzc().zzc(zzia.zza)).booleanValue()) {
                                zZza = this.zzd.zza(zzgtVarZzd, zzkiVar);
                            } else if (i2 == 3) {
                                zZza = this.zze.zzb(zzgtVarZzd);
                            } else if (i2 == 4) {
                                zZza = this.zze.zza(zzgtVarZzd, zzkiVar);
                            } else {
                                this.zzh.zzb(4009, System.currentTimeMillis() - jCurrentTimeMillis);
                            }
                            if (zZza) {
                                zzkb zzkbVarZzu3 = zzu(1);
                                if (zzkbVarZzu3 != null) {
                                    if (this.zzf.zza(zzkbVarZzu3)) {
                                        this.zzp = true;
                                    }
                                    this.zza = System.currentTimeMillis() / 1000;
                                }
                            } else {
                                this.zzh.zzb(4009, System.currentTimeMillis() - jCurrentTimeMillis);
                            }
                        }
                    } catch (NullPointerException unused) {
                        this.zzh.zzb(2030, System.currentTimeMillis() - jCurrentTimeMillis);
                    }
                }
            } catch (zzavb e) {
                this.zzh.zzc(PlaybackException.ERROR_CODE_DECODER_QUERY_FAILED, System.currentTimeMillis() - jCurrentTimeMillis, e);
            }
        } finally {
            this.zzk.countDown();
        }
    }

    final /* synthetic */ zzjc zzp() {
        return this.zzh;
    }

    final /* synthetic */ Object zzq() {
        return this.zzn;
    }

    final /* synthetic */ boolean zzr() {
        return this.zzo;
    }

    final /* synthetic */ void zzs(boolean z) {
        this.zzo = z;
    }
}
