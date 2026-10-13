package com.google.android.recaptcha.internal;

import android.content.Context;
import com.google.android.play.core.integrity.StandardIntegrityManager;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzan {
    public CompletableDeferred zza;
    private final CoroutineScope zzb;
    private final zzek zzc;
    private final StandardIntegrityManager zzd;
    private long zzf;
    private boolean zzh;
    private zzao zze = zzao.zza;
    private final Mutex zzg = MutexKt.Mutex$default(false, 1, null);

    public zzan(Context context, CoroutineScope coroutineScope, zzek zzekVar, StandardIntegrityManager standardIntegrityManager, long j) {
        this.zzb = coroutineScope;
        this.zzc = zzekVar;
        this.zzd = standardIntegrityManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object zzi(Continuation continuation) throws Exception {
        zzag zzagVar;
        if (continuation instanceof zzag) {
            zzagVar = (zzag) continuation;
            int i = zzagVar.zzc;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzagVar.zzc = i - Integer.MIN_VALUE;
            } else {
                zzagVar = new zzag(this, continuation);
            }
        } else {
            zzagVar = new zzag(this, continuation);
        }
        Object obj = zzagVar.zza;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzagVar.zzc;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        ResultKt.throwOnFailure(obj);
        Deferred deferredZza = zzbx.zza(this.zzd.prepareIntegrityToken(StandardIntegrityManager.PrepareIntegrityTokenRequest.builder().setCloudProjectNumber(this.zzf).build()));
        zzagVar.zzc = 1;
        Object objAwait = deferredZza.await(zzagVar);
        return objAwait == coroutine_suspended ? coroutine_suspended : objAwait;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006d, code lost:
    
        if (r7 == r1) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object zzj(java.lang.String r6, kotlin.coroutines.Continuation r7) throws java.lang.Exception {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.google.android.recaptcha.internal.zzah
            if (r0 == 0) goto L13
            r0 = r7
            com.google.android.recaptcha.internal.zzah r0 = (com.google.android.recaptcha.internal.zzah) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzc = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzah r0 = new com.google.android.recaptcha.internal.zzah
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.zza
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zzc
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3d
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r7)
            goto L70
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            java.lang.String r6 = r0.zzd
            r5 = r6
            java.lang.String r5 = (java.lang.String) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L4e
        L3d:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlinx.coroutines.CompletableDeferred r5 = r5.zzf()
            r0.zzd = r6
            r0.zzc = r4
            java.lang.Object r7 = r5.await(r0)
            if (r7 == r1) goto L77
        L4e:
            com.google.android.play.core.integrity.StandardIntegrityManager$StandardIntegrityTokenProvider r7 = (com.google.android.play.core.integrity.StandardIntegrityManager.StandardIntegrityTokenProvider) r7
            com.google.android.play.core.integrity.StandardIntegrityManager$StandardIntegrityTokenRequest$Builder r5 = com.google.android.play.core.integrity.StandardIntegrityManager.StandardIntegrityTokenRequest.builder()
            com.google.android.play.core.integrity.StandardIntegrityManager$StandardIntegrityTokenRequest$Builder r5 = r5.setRequestHash(r6)
            com.google.android.play.core.integrity.StandardIntegrityManager$StandardIntegrityTokenRequest r5 = r5.build()
            com.google.android.gms.tasks.Task r5 = r7.request(r5)
            kotlinx.coroutines.Deferred r5 = com.google.android.recaptcha.internal.zzbx.zza(r5)
            r6 = 0
            r0.zzd = r6
            r0.zzc = r3
            java.lang.Object r7 = r5.await(r0)
            if (r7 != r1) goto L70
            goto L77
        L70:
            com.google.android.play.core.integrity.StandardIntegrityManager$StandardIntegrityToken r7 = (com.google.android.play.core.integrity.StandardIntegrityManager.StandardIntegrityToken) r7
            java.lang.String r5 = r7.token()
            return r5
        L77:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzan.zzj(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0081, code lost:
    
        if (r9 != r1) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object zzc(java.lang.String r8, kotlin.coroutines.Continuation r9) throws java.lang.Exception {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.google.android.recaptcha.internal.zzaf
            if (r0 == 0) goto L13
            r0 = r9
            com.google.android.recaptcha.internal.zzaf r0 = (com.google.android.recaptcha.internal.zzaf) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzc = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzaf r0 = new com.google.android.recaptcha.internal.zzaf
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.zza
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zzc
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L53
            if (r2 == r5) goto L45
            if (r2 == r4) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.throwOnFailure(r9)
            goto L83
        L2f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L37:
            java.lang.String r7 = r0.zze
            r8 = r7
            java.lang.String r8 = (java.lang.String) r8
            com.google.android.recaptcha.internal.zzan r8 = r0.zzd
            r2 = r8
            com.google.android.recaptcha.internal.zzan r2 = (com.google.android.recaptcha.internal.zzan) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L76
        L45:
            java.lang.String r8 = r0.zze
            r7 = r8
            java.lang.String r7 = (java.lang.String) r7
            com.google.android.recaptcha.internal.zzan r7 = r0.zzd
            r2 = r7
            com.google.android.recaptcha.internal.zzan r2 = (com.google.android.recaptcha.internal.zzan) r2
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Exception -> L66
            goto L63
        L53:
            kotlin.ResultKt.throwOnFailure(r9)
            r0.zzd = r7     // Catch: java.lang.Exception -> L66
            r0.zze = r8     // Catch: java.lang.Exception -> L66
            r0.zzc = r5     // Catch: java.lang.Exception -> L66
            java.lang.Object r9 = r7.zzj(r8, r0)     // Catch: java.lang.Exception -> L66
            if (r9 != r1) goto L63
            goto L86
        L63:
            java.lang.String r9 = (java.lang.String) r9     // Catch: java.lang.Exception -> L66
            return r9
        L66:
            r0.zzd = r7
            r0.zze = r8
            r0.zzc = r4
            java.lang.Object r9 = r7.zze(r0)
            if (r9 != r1) goto L73
            goto L86
        L73:
            r6 = r8
            r8 = r7
            r7 = r6
        L76:
            r9 = 0
            r0.zzd = r9
            r0.zze = r9
            r0.zzc = r3
            java.lang.Object r9 = r8.zzj(r7, r0)
            if (r9 == r1) goto L86
        L83:
            java.lang.String r9 = (java.lang.String) r9
            return r9
        L86:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzan.zzc(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object zzd(long j, Continuation continuation) {
        this.zzf = j;
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00ba, code lost:
    
        if (kotlin.Unit.INSTANCE == r1) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object zze(kotlin.coroutines.Continuation r13) {
        /*
            r12 = this;
            boolean r0 = r13 instanceof com.google.android.recaptcha.internal.zzak
            if (r0 == 0) goto L13
            r0 = r13
            com.google.android.recaptcha.internal.zzak r0 = (com.google.android.recaptcha.internal.zzak) r0
            int r1 = r0.zzd
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzd = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzak r0 = new com.google.android.recaptcha.internal.zzak
            r0.<init>(r12, r13)
        L18:
            java.lang.Object r13 = r0.zzb
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zzd
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L45
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            kotlin.ResultKt.throwOnFailure(r13)
            goto Lbd
        L2e:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L36:
            java.lang.Object r12 = r0.zza
            kotlinx.coroutines.sync.Mutex r12 = (kotlinx.coroutines.sync.Mutex) r12
            com.google.android.recaptcha.internal.zzan r2 = r0.zze
            r6 = r2
            com.google.android.recaptcha.internal.zzan r6 = (com.google.android.recaptcha.internal.zzan) r6
            kotlin.ResultKt.throwOnFailure(r13)
            r13 = r12
            r12 = r2
            goto L56
        L45:
            kotlin.ResultKt.throwOnFailure(r13)
            kotlinx.coroutines.sync.Mutex r13 = r12.zzg
            r0.zze = r12
            r0.zza = r13
            r0.zzd = r4
            java.lang.Object r2 = r13.lock(r5, r0)
            if (r2 == r1) goto Lc6
        L56:
            com.google.android.recaptcha.internal.zzao r2 = r12.zze     // Catch: java.lang.Throwable -> Lc0
            com.google.android.recaptcha.internal.zzao r6 = com.google.android.recaptcha.internal.zzao.zza     // Catch: java.lang.Throwable -> Lc0
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r6)     // Catch: java.lang.Throwable -> Lc0
            if (r2 != 0) goto L66
            kotlin.Unit r12 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> Lc0
            r13.unlock(r5)
            return r12
        L66:
            com.google.android.recaptcha.internal.zzao r2 = com.google.android.recaptcha.internal.zzao.zzb     // Catch: java.lang.Throwable -> Lc0
            r12.zze = r2     // Catch: java.lang.Throwable -> Lc0
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> Lc0
            r13.unlock(r5)
            com.google.android.recaptcha.internal.zzek r13 = r12.zzc
            java.lang.String r2 = r13.zzd()
            r13.zzc(r2)
            r13.zzb(r3)
            r2 = 38
            com.google.android.recaptcha.internal.zzen r13 = r13.zzf(r2)
            kotlinx.coroutines.CompletableDeferred r2 = kotlinx.coroutines.CompletableDeferredKt.CompletableDeferred$default(r5, r4, r5)
            r12.zza = r2
            kotlinx.coroutines.CoroutineScope r6 = r12.zzb
            com.google.android.recaptcha.internal.zzam r2 = new com.google.android.recaptcha.internal.zzam
            r2.<init>(r12, r13, r5)
            r9 = r2
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r10 = 3
            r11 = 0
            r7 = 0
            r8 = 0
            kotlinx.coroutines.BuildersKt.launch$default(r6, r7, r8, r9, r10, r11)
            r0.zze = r5
            r0.zza = r5
            r0.zzd = r3
            boolean r13 = r12.zzh
            if (r13 != 0) goto Lb8
            java.util.Timer r5 = new java.util.Timer
            r5.<init>()
            com.google.android.recaptcha.internal.zzai r13 = new com.google.android.recaptcha.internal.zzai
            r13.<init>(r12)
            r6 = r13
            java.util.TimerTask r6 = (java.util.TimerTask) r6
            r7 = 28800000(0x1b77400, double:1.42290906E-316)
            r9 = r7
            r5.schedule(r6, r7, r9)
            r12.zzh = r4
        Lb8:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            if (r12 != r1) goto Lbd
            goto Lc6
        Lbd:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        Lc0:
            r0 = move-exception
            r12 = r0
            r13.unlock(r5)
            throw r12
        Lc6:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzan.zze(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final CompletableDeferred zzf() {
        CompletableDeferred completableDeferred = this.zza;
        if (completableDeferred != null) {
            return completableDeferred;
        }
        return null;
    }
}
