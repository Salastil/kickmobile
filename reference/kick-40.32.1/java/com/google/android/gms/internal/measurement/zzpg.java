package com.google.android.gms.internal.measurement;

import android.os.StrictMode;
import android.util.Log;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzpg {
    public static final /* synthetic */ int zzb = 0;
    private volatile zzqs zzd;
    private final zzlk zze;
    private final String zzf;
    private final String zzg;
    private final boolean zzh;
    private final ImmutableSet zzi;
    private final zzps zzj;
    private final zzqt zzk;
    private static final zzpe zzc = new zzpe(null);
    static final zzon zza = new zzon(zzox.zza, false, false, false, false, ImmutableSet.of());

    /* synthetic */ zzpg(zzlk zzlkVar, zzon zzonVar, String str, byte[] bArr) {
        this.zze = zzlkVar;
        String strZza = zzonVar.zza(zzlkVar.zzc());
        this.zzf = strZza;
        this.zzg = "";
        this.zzh = zzonVar.zzb();
        this.zzi = zzonVar.zzc();
        this.zzd = null;
        this.zzj = new zzps();
        this.zzk = new zzqt(zzlkVar, strZza, "", false);
    }

    public static zzpe zzd() {
        return zzc;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00a2 A[Catch: all -> 0x00ac, TryCatch #1 {, blocks: (B:5:0x0005, B:7:0x0009, B:9:0x0013, B:26:0x0098, B:28:0x009c, B:30:0x00a2, B:12:0x001e, B:14:0x002b, B:16:0x0033, B:18:0x003d, B:19:0x0052, B:21:0x0077, B:22:0x0083, B:24:0x008b, B:32:0x00a6, B:33:0x00a9, B:34:0x00aa, B:8:0x000d), top: B:42:0x0005, inners: #0 }] */
    private final zzqs zzq() {
        zzqs zzqsVarZzb;
        zzqs zzqsVar = this.zzd;
        if (zzqsVar != null) {
            return zzqsVar;
        }
        synchronized (this) {
            zzqsVarZzb = this.zzd;
            if (zzqsVarZzb == null) {
                StrictMode.ThreadPolicy threadPolicyAllowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
                try {
                    zzqs zzqsVarZza = this.zzk.zza();
                    StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
                    if (!zzqsVarZza.zzk()) {
                        zzlk zzlkVar = this.zze;
                        zzlkVar.zzd().zza();
                        if (this.zzh || this.zzk.zzb() || !zzqsVarZza.zzd().isEmpty()) {
                            zzlkVar.zzg().execute(new Runnable() { // from class: com.google.android.gms.internal.measurement.zzoy
                                @Override // java.lang.Runnable
                                public final /* synthetic */ void run() {
                                    this.zza.zzf();
                                }
                            });
                            zzlkVar.zzk().zza(zzqsVarZza.zze(), this.zzi, this.zzf);
                            if (!this.zzg.equals("")) {
                                zzlkVar.zzg().execute(new Runnable() { // from class: com.google.android.gms.internal.measurement.zzoq
                                    @Override // java.lang.Runnable
                                    public final /* synthetic */ void run() {
                                        this.zza.zzh();
                                    }
                                });
                            }
                            if (this.zzk.zzb()) {
                                zzlkVar.zzg().execute(new Runnable() { // from class: com.google.android.gms.internal.measurement.zzor
                                    @Override // java.lang.Runnable
                                    public final /* synthetic */ void run() {
                                        this.zza.zzi();
                                    }
                                });
                            }
                        } else {
                            zzlkVar.zzg().execute(new Runnable() { // from class: com.google.android.gms.internal.measurement.zzop
                                @Override // java.lang.Runnable
                                public final /* synthetic */ void run() {
                                    this.zza.zzg();
                                }
                            });
                            zzqsVarZzb = zzqs.zzb(zzqv.zzi(), zzqsVarZza);
                        }
                        if (this.zzh || !zzqsVarZzb.zzj()) {
                            this.zzd = zzqsVarZzb;
                        }
                    }
                    zzqsVarZzb = zzqsVarZza;
                    if (this.zzh) {
                        this.zzd = zzqsVarZzb;
                    } else {
                        this.zzd = zzqsVarZzb;
                    }
                } catch (Throwable th) {
                    StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
                    throw th;
                }
            }
        }
        return zzqsVarZzb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzr, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final void zzg() {
        final zzqt zzqtVar = this.zzk;
        final ListenableFuture listenableFutureZzd = zzqtVar.zzd(this.zzg);
        Objects.requireNonNull(zzqtVar);
        AsyncFunction asyncFunction = new AsyncFunction() { // from class: com.google.android.gms.internal.measurement.zzpf
            @Override // com.google.common.util.concurrent.AsyncFunction
            public final /* synthetic */ ListenableFuture apply(Object obj) {
                return zzqtVar.zzc((zzqv) obj);
            }
        };
        zzlk zzlkVar = this.zze;
        Futures.transformAsync(listenableFutureZzd, asyncFunction, zzlkVar.zzg()).addListener(new Runnable() { // from class: com.google.android.gms.internal.measurement.zzov
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzm(listenableFutureZzd);
            }
        }, zzlkVar.zzg());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:14:0x0033 A[Catch: CancellationException | ExecutionException -> 0x006b, ExecutionException -> 0x006d, TryCatch #3 {CancellationException | ExecutionException -> 0x006b, blocks: (B:2:0x0000, B:4:0x0018, B:12:0x0025, B:14:0x0033, B:16:0x003b, B:20:0x0047, B:22:0x004b, B:6:0x001c, B:26:0x006a, B:8:0x001f, B:11:0x0024, B:18:0x003f, B:19:0x0046), top: B:35:0x0000, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:16:0x003b A[Catch: CancellationException | ExecutionException -> 0x006b, ExecutionException -> 0x006d, TRY_LEAVE, TryCatch #3 {CancellationException | ExecutionException -> 0x006b, blocks: (B:2:0x0000, B:4:0x0018, B:12:0x0025, B:14:0x0033, B:16:0x003b, B:20:0x0047, B:22:0x004b, B:6:0x001c, B:26:0x006a, B:8:0x001f, B:11:0x0024, B:18:0x003f, B:19:0x0046), top: B:35:0x0000, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:36:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: zzs, reason: merged with bridge method [inline-methods] */
    public final /* synthetic */ void zzm(ListenableFuture listenableFuture) {
        zzqs zzqsVar;
        zzqm zzqmVarZzj;
        try {
            zzqv zzqvVar = (zzqv) Futures.getDone(listenableFuture);
            zzqs zzqsVarZza = zzqs.zza(zzqvVar, new zzqr(6, 2));
            boolean z = this.zzh;
            Preconditions.checkNotNull(zzqsVarZza);
            if (z || (zzqsVar = this.zzd) == null) {
                synchronized (this) {
                    if (!z) {
                        zzqsVar = this.zzd;
                        if (zzqsVar != null) {
                            if (!zzqsVar.zzf().equals(zzqsVarZza.zzf())) {
                                zzqmVarZzj = this.zze.zzj();
                                if (zzqmVarZzj != null) {
                                    zzqmVarZzj.zza();
                                    return;
                                }
                                return;
                            }
                        }
                    }
                    this.zzd = zzqsVarZza;
                    this.zzj.zzb();
                }
            } else if (!zzqsVar.zzf().equals(zzqsVarZza.zzf())) {
                zzqmVarZzj = this.zze.zzj();
                if (zzqmVarZzj != null) {
                    zzqmVarZzj.zza();
                    return;
                }
                return;
            }
            if (this.zzh) {
                zzlk zzlkVar = this.zze;
                Futures.catching(zzlkVar.zzh().zzb(zzqvVar.zza()), Throwable.class, new Function() { // from class: com.google.android.gms.internal.measurement.zzow
                    @Override // com.google.common.base.Function
                    public final /* synthetic */ Object apply(Object obj) {
                        this.zza.zzn((Throwable) obj);
                        return null;
                    }
                }, zzlkVar.zzg());
            }
        } catch (CancellationException | ExecutionException e) {
            if (e.getCause() instanceof SecurityException) {
                return;
            }
            String str = this.zzf;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 64);
            sb.append("Unable to update local snapshot for ");
            sb.append(str);
            sb.append(", may result in stale flags.");
            Log.w("FlagStore", sb.toString(), e);
        }
    }

    final Object zza(String str, boolean z) {
        return zzq().zzf().get(str);
    }

    final String zzb() {
        return this.zzf;
    }

    final zzps zzc() {
        return this.zzj;
    }

    final /* synthetic */ ListenableFuture zzf() {
        ListenableFuture listenableFutureZzb;
        zzqs zzqsVarZzq = zzq();
        String strZzd = zzqsVarZzq.zzd();
        zzlk zzlkVar = this.zze;
        zzqn zzqnVarZzc = zzlkVar.zzd().zzc(false);
        if (zzqnVarZzc.zze()) {
            if (Strings.isNullOrEmpty(strZzd) && !zzqnVarZzc.zzd()) {
                return Futures.immediateVoidFuture();
            }
            zzmb zzmbVarZzb = zzme.zzb();
            zzmbVarZzb.zzb(zzqsVarZzq.zzi());
            if (!Strings.isNullOrEmpty(strZzd)) {
                zzmbVarZzb.zza(strZzd);
            }
            if (zzqnVarZzc.zzd()) {
                zzmbVarZzb.zzc(this.zzf);
            }
            listenableFutureZzb = zzlkVar.zzh().zzc((zzme) zzmbVarZzb.zzbd());
        } else {
            if (Strings.isNullOrEmpty(strZzd)) {
                return Futures.immediateVoidFuture();
            }
            listenableFutureZzb = zzlkVar.zzh().zzb(strZzd);
        }
        return Futures.catchingAsync(listenableFutureZzb, zzmk.class, new AsyncFunction() { // from class: com.google.android.gms.internal.measurement.zzos
            @Override // com.google.common.util.concurrent.AsyncFunction
            public final /* synthetic */ ListenableFuture apply(Object obj) {
                return this.zza.zzj((zzmk) obj);
            }
        }, zzlkVar.zzg());
    }

    final /* synthetic */ void zzh() {
        zzlk zzlkVar = this.zze;
        final ListenableFuture listenableFutureZza = zzpu.zza(zzlkVar, this.zzf, this.zzg);
        listenableFutureZza.addListener(new Runnable() { // from class: com.google.android.gms.internal.measurement.zzot
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzk(listenableFutureZza);
            }
        }, zzlkVar.zzg());
    }

    final /* synthetic */ void zzi() {
        this.zze.zzf().zza(zzabz.FILE, this.zzh, zzou.zza);
    }

    final /* synthetic */ ListenableFuture zzj(zzmk zzmkVar) {
        int iZza = zzmkVar.zza();
        if ((iZza == 29501 || iZza == 29537 || iZza == 29538 || iZza == 29539 || iZza == 29540 || iZza == 29541 || iZza == 29542 || iZza == 29543 || iZza == 29544) && !this.zzk.zzb()) {
            zzg();
        }
        return Futures.immediateVoidFuture();
    }

    final /* synthetic */ void zzk(ListenableFuture listenableFuture) {
        try {
            Futures.getDone(listenableFuture);
        } catch (Exception e) {
            String str = this.zzf;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 73);
            sb.append("Failed to store account on flag read for: ");
            sb.append(str);
            sb.append(" which may lead to stale flags.");
            Log.w("FlagStore", sb.toString(), e);
        }
    }

    final /* synthetic */ Void zzn(Throwable th) {
        String str = this.zzf;
        String.valueOf(str);
        Log.w("FlagStore", "Failed to commit to updated flags for ".concat(String.valueOf(str)), th);
        return null;
    }

    final /* synthetic */ boolean zzo() {
        if (!this.zzh) {
            return true;
        }
        zzqs zzqsVar = this.zzd;
        if (zzqsVar == null) {
            return false;
        }
        if (!zzqsVar.zzh() && !zzqsVar.zzg() && !this.zzk.zzb()) {
            return false;
        }
        synchronized (this) {
            zzqs zzqsVar2 = this.zzd;
            if (zzqsVar2 != null && (zzqsVar2.zzh() || zzqsVar2.zzg() || this.zzk.zzb())) {
                this.zzd = null;
                this.zzj.zzb();
            }
        }
        return false;
    }

    final /* synthetic */ String zzp() {
        return this.zzf;
    }
}
