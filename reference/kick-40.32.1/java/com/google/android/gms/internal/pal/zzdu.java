package com.google.android.gms.internal.pal;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzdu implements Runnable, zzdp {
    private static final long zzb = System.currentTimeMillis();
    private Context zzd;
    private final zzjc zze;
    private final Executor zzf;
    private final zzk zzg;
    private final boolean zzh;
    private final AtomicReference zzc = new AtomicReference();
    final CountDownLatch zza = new CountDownLatch(1);
    private final List zzi = new ArrayList();

    public zzdu(Context context, Executor executor, zzk zzkVar) {
        this.zzg = zzkVar;
        this.zzd = context;
        this.zzf = executor;
        zzia.zza(context);
        boolean z = ((Boolean) zzhi.zzc().zzc(zzia.zzc)).booleanValue() && zzkVar.zzd();
        this.zzh = z;
        this.zze = zzjc.zza(context, executor, z);
        executor.execute(this);
    }

    private final void zzo() {
        List<Object[]> list = this.zzi;
        if (list.isEmpty()) {
            return;
        }
        AtomicReference atomicReference = this.zzc;
        if (atomicReference.get() == null) {
            return;
        }
        for (Object[] objArr : list) {
            int length = objArr.length;
            if (length == 1) {
                ((zzdp) atomicReference.get()).zzg((MotionEvent) objArr[0]);
            } else if (length == 3) {
                ((zzdp) atomicReference.get()).zzh(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
            }
        }
        list.clear();
    }

    private final String zzp(Context context, byte[] bArr) {
        if (!zzf()) {
            return "";
        }
        zzo();
        return ((zzdp) this.zzc.get()).zzl(zzr(context));
    }

    private final boolean zzq() {
        this.zzc.set(zzdx.zzt(zzr(this.zzd), new zzdv(this.zzg)));
        return true;
    }

    private static final Context zzr(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                zzk zzkVar = this.zzg;
                if (zzkVar.zzm() - 1 == 2) {
                    i = (new zzkj(this.zzd, zzjr.zzb(this.zzd, this.zze), new zzdr(this), ((Boolean) zzhi.zzc().zzc(zzia.zzb)).booleanValue()).zzd(1) || !zzkVar.zza()) ? 3 : 2;
                }
                if (i - 1 != 2) {
                    zzq();
                    if (zzkVar.zzm() == 3) {
                        this.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.pal.zzds
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                this.zza.zzd();
                            }
                        });
                    }
                } else {
                    zzdm zzdmVarZza = zzdm.zza(zzkVar.zzb(), zzr(this.zzd), this.zzf, zzkVar.zzc(), this.zzh);
                    this.zzc.set(zzdmVarZza);
                    if (!zzdmVarZza.zzc() && zzkVar.zza()) {
                        zzq();
                    }
                }
            } catch (NullPointerException e) {
                if (this.zzg.zza()) {
                    zzq();
                }
                this.zze.zzc(2031, System.currentTimeMillis() - jCurrentTimeMillis, e);
            }
        } finally {
            this.zzd = null;
            this.zza.countDown();
        }
    }

    public final zzdp zza() {
        return (zzdp) this.zzc.get();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String zzb(final Context context) {
        try {
            return (String) zztz.zzb(new Callable() { // from class: com.google.android.gms.internal.pal.zzdt
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Object call() {
                    return this.zza.zzc(context);
                }
            }, this.zzf).get(this.zzg.zzf().zza(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException unused) {
            return Integer.toString(17);
        } catch (TimeoutException unused2) {
            return zzdi.zza(context, this.zzg.zzb(), zzb, true);
        }
    }

    final /* synthetic */ String zzc(Context context) {
        return zzp(context, null);
    }

    final /* synthetic */ void zzd() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            zzk zzkVar = this.zzg;
            zzdm.zzb(zzkVar.zzb(), zzr(this.zzd), zzkVar.zzc(), this.zzh).zzn();
        } catch (NullPointerException e) {
            this.zze.zzc(2027, System.currentTimeMillis() - jCurrentTimeMillis, e);
        }
    }

    @Override // com.google.android.gms.internal.pal.zzdp
    public final boolean zze() {
        if (this.zza.getCount() != 0) {
            return false;
        }
        AtomicReference atomicReference = this.zzc;
        return atomicReference.get() != null && ((zzdp) atomicReference.get()).zze();
    }

    @Override // com.google.android.gms.internal.pal.zzdp
    public final boolean zzf() {
        try {
            this.zza.await();
            AtomicReference atomicReference = this.zzc;
            return atomicReference.get() != null && ((zzdp) atomicReference.get()).zzf();
        } catch (InterruptedException unused) {
        }
    }

    @Override // com.google.android.gms.internal.pal.zzdp
    public final void zzg(MotionEvent motionEvent) {
        AtomicReference atomicReference = this.zzc;
        if (atomicReference.get() == null) {
            this.zzi.add(new Object[]{motionEvent});
        } else {
            zzo();
            ((zzdp) atomicReference.get()).zzg(motionEvent);
        }
    }

    @Override // com.google.android.gms.internal.pal.zzdp
    public final void zzh(int i, int i2, int i3) {
        AtomicReference atomicReference = this.zzc;
        if (atomicReference.get() == null) {
            this.zzi.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        } else {
            zzo();
            ((zzdp) atomicReference.get()).zzh(i, i2, i3);
        }
    }

    @Override // com.google.android.gms.internal.pal.zzdp
    @Deprecated
    public final String zzi(Context context, String str, View view, Activity activity) {
        if (!zzf()) {
            return "";
        }
        zzo();
        return ((zzdp) this.zzc.get()).zzi(zzr(context), str, view, activity);
    }

    @Override // com.google.android.gms.internal.pal.zzdp
    public final void zzj(View view) {
        AtomicReference atomicReference = this.zzc;
        if (atomicReference.get() != null) {
            ((zzdp) atomicReference.get()).zzj(view);
        }
    }

    @Override // com.google.android.gms.internal.pal.zzdp
    public final String zzk(Context context, View view, Activity activity) {
        return zzf() ? ((zzdp) this.zzc.get()).zzk(context, view, activity) : "";
    }

    @Override // com.google.android.gms.internal.pal.zzdp
    public final String zzl(Context context) {
        zzk zzkVar = this.zzg;
        return (!zzkVar.zzf().zzb() || System.currentTimeMillis() - zzb > zzkVar.zzf().zzc()) ? zzp(context, null) : zzb(context);
    }

    @Override // com.google.android.gms.internal.pal.zzdp
    public final String zzm(Context context, byte[] bArr) {
        return zzp(context, bArr);
    }

    final /* synthetic */ zzjc zzn() {
        return this.zze;
    }
}
