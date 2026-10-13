package com.google.android.recaptcha.internal;

import com.google.android.recaptcha.RecaptchaAction;
import java.util.concurrent.TimeUnit;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzec implements zzcn {
    private final zzdt zza;
    private final zzek zzb;
    private zzbd zzd;
    private zzsc zze;
    private final zzbi zzg;
    private CompletableDeferred zzc = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
    private zzcm zzf = zzcm.zza;

    public zzec(zzdt zzdtVar, zzbi zzbiVar, zzek zzekVar, zzbo zzboVar) {
        this.zza = zzdtVar;
        this.zzg = zzbiVar;
        this.zzb = zzekVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object zzl(Function1 function1, Continuation continuation) {
        zzdv zzdvVar;
        zzbn zzbnVar;
        if (continuation instanceof zzdv) {
            zzdvVar = (zzdv) continuation;
            int i = zzdvVar.zzc;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzdvVar.zzc = i - Integer.MIN_VALUE;
            } else {
                zzdvVar = new zzdv(this, continuation);
            }
        } else {
            zzdvVar = new zzdv(this, continuation);
        }
        Object obj = zzdvVar.zza;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzdvVar.zzc;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            zzbn zzbnVar2 = new zzbn();
            zzdvVar.zzd = zzbnVar2;
            zzdvVar.zzc = 1;
            if (function1.invoke(zzdvVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            zzbnVar = zzbnVar2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            zzbnVar = zzdvVar.zzd;
            ResultKt.throwOnFailure(obj);
        }
        zzbnVar.zzc();
        return Boxing.boxLong(zzbnVar.zza(TimeUnit.MILLISECONDS));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:28:0x007b  */
    /* JADX WARN: Code duplicated, block: B:30:0x0080 A[Catch: Exception -> 0x0034, TRY_ENTER, TryCatch #1 {Exception -> 0x0034, blocks: (B:13:0x0030, B:25:0x006e, B:30:0x0080, B:31:0x0089), top: B:53:0x0030 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x0092  */
    /* JADX WARN: Code duplicated, block: B:38:0x0097  */
    /* JADX WARN: Code duplicated, block: B:47:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:48:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object zzm(long j, Continuation continuation) throws zzbd {
        zzdw zzdwVar;
        zzec zzecVar;
        Exception e;
        long j2;
        zzbd zzbdVar;
        zzbd zzbdVar2;
        long jLongValue;
        if (continuation instanceof zzdw) {
            zzdwVar = (zzdw) continuation;
            int i = zzdwVar.zzd;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzdwVar.zzd = i - Integer.MIN_VALUE;
            } else {
                zzdwVar = new zzdw(this, continuation);
            }
        } else {
            zzdwVar = new zzdw(this, continuation);
        }
        Object objZzl = zzdwVar.zzb;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzdwVar.zzd;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objZzl);
                zzdwVar.zze = this;
                zzdwVar.zza = j;
                zzdwVar.zzd = 1;
                if (zzn(j, zzdwVar) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j2 = zzdwVar.zza;
                zzecVar = zzdwVar.zze;
                try {
                    ResultKt.throwOnFailure(objZzl);
                    jLongValue = j2 - ((Number) objZzl).longValue();
                    if (jLongValue >= 500) {
                        return Boxing.boxLong(jLongValue);
                    }
                    throw new zzbd(zzbb.zzc, zzba.zzar, null);
                } catch (Exception e2) {
                    e = e2;
                    zzbdVar = e instanceof zzbd ? (zzbd) e : null;
                    if (zzbdVar == null) {
                        zzbdVar = new zzbd(zzbb.zzc, zzba.zzar, e.getMessage());
                    }
                    if (Intrinsics.areEqual(zzecVar.zzf, zzcm.zzd)) {
                    }
                    zzbdVar2 = zzecVar.zzd;
                    if (zzbdVar2 != null) {
                        throw zzbdVar2;
                    }
                    throw zzbdVar;
                }
            }
            j = zzdwVar.zza;
            this = zzdwVar.zze;
            ResultKt.throwOnFailure(objZzl);
            zzdy zzdyVar = new zzdy(j, this, null);
            zzdwVar.zze = this;
            zzdwVar.zza = j;
            zzdwVar.zzd = 2;
            objZzl = this.zzl(zzdyVar, zzdwVar);
            if (objZzl != coroutine_suspended) {
                zzecVar = this;
                j2 = j;
                jLongValue = j2 - ((Number) objZzl).longValue();
                if (jLongValue >= 500) {
                    return Boxing.boxLong(jLongValue);
                }
                throw new zzbd(zzbb.zzc, zzba.zzar, null);
            }
            return coroutine_suspended;
        } catch (Exception e3) {
            zzecVar = this;
            e = e3;
            if (e instanceof zzbd) {
            }
            if (zzbdVar == null) {
                zzbdVar = new zzbd(zzbb.zzc, zzba.zzar, e.getMessage());
            }
            if (Intrinsics.areEqual(zzecVar.zzf, zzcm.zzd) && !Intrinsics.areEqual(zzecVar.zzf, zzcm.zzc)) {
                throw zzbdVar;
            }
            zzbdVar2 = zzecVar.zzd;
            if (zzbdVar2 != null) {
                throw zzbdVar2;
            }
            throw zzbdVar;
        }
    }

    private final Object zzn(long j, Continuation continuation) {
        if (Intrinsics.areEqual(this.zzf, zzcm.zzb) || Intrinsics.areEqual(this.zzf, zzcm.zzc)) {
            return Unit.INSTANCE;
        }
        if (Intrinsics.areEqual(this.zzf, zzcm.zzd) && !zzo(this.zzd)) {
            return Unit.INSTANCE;
        }
        this.zzf = zzcm.zzc;
        CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        this.zzc = completableDeferredCompletableDeferred$default;
        BuildersKt__Builders_commonKt.launch$default(this.zzg.zza(), null, null, new zzeb(this, completableDeferredCompletableDeferred$default, j, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean zzo(Exception exc) {
        if (!(exc instanceof zzbd)) {
            return true;
        }
        zzbd zzbdVar = (zzbd) exc;
        return (Intrinsics.areEqual(zzbdVar.zzb(), zzbb.zzd) || Intrinsics.areEqual(zzbdVar.zzb(), zzbb.zze) || Intrinsics.areEqual(zzbdVar.zzb(), zzbb.zzf)) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:36:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    @Override // com.google.android.recaptcha.internal.zzcn
    public final Object zza(String str, RecaptchaAction recaptchaAction, long j, Continuation continuation) throws zzbd {
        zzdu zzduVar;
        String str2;
        RecaptchaAction recaptchaAction2;
        Object objZzm;
        zzec zzecVar;
        RecaptchaAction recaptchaAction3;
        String str3;
        double d;
        zzsc zzscVar;
        String str4;
        zzec zzecVar2;
        zzec zzecVar3 = this;
        if (continuation instanceof zzdu) {
            zzduVar = (zzdu) continuation;
            int i = zzduVar.zzd;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzduVar.zzd = i - Integer.MIN_VALUE;
            } else {
                zzduVar = new zzdu(zzecVar3, continuation);
            }
        } else {
            zzduVar = new zzdu(zzecVar3, continuation);
        }
        Object objZzm2 = zzduVar.zzb;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzduVar.zzd;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objZzm2);
                zzduVar.zze = zzecVar3;
                str2 = str;
                zzduVar.zzf = str2;
                recaptchaAction2 = recaptchaAction;
                zzduVar.zzg = recaptchaAction2;
                zzduVar.zzd = 1;
                objZzm = zzecVar3.zzm(j, zzduVar);
                if (objZzm == coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i2 == 1) {
                RecaptchaAction recaptchaAction4 = zzduVar.zzg;
                String str5 = zzduVar.zzf;
                zzec zzecVar4 = zzduVar.zze;
                ResultKt.throwOnFailure(objZzm2);
                recaptchaAction2 = recaptchaAction4;
                zzecVar3 = zzecVar4;
                objZzm = objZzm2;
                str2 = str5;
            } else {
                if (i2 == 2) {
                    d = zzduVar.zza;
                    recaptchaAction3 = zzduVar.zzg;
                    str3 = zzduVar.zzf;
                    zzecVar = zzduVar.zze;
                    ResultKt.throwOnFailure(objZzm2);
                    zzsi zzsiVar = (zzsi) objZzm2;
                    zzdt zzdtVar = zzecVar.zza;
                    zzscVar = zzecVar.zze;
                    if (zzscVar == null) {
                        zzscVar = null;
                    }
                    zzsp zzspVarZzi = zzdtVar.zzi(recaptchaAction3, zzsiVar, zzscVar);
                    zzduVar.zze = zzecVar;
                    zzduVar.zzf = str3;
                    zzduVar.zzg = null;
                    zzduVar.zzd = 3;
                    String str6 = str3;
                    objZzm2 = zzecVar.zza.zzm(zzspVarZzi, str6, (long) d, zzduVar);
                    str4 = str6;
                    if (objZzm2 != coroutine_suspended) {
                        zzecVar2 = zzecVar;
                    }
                    return coroutine_suspended;
                }
                if (i2 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                str4 = zzduVar.zzf;
                zzecVar2 = zzduVar.zze;
                ResultKt.throwOnFailure(objZzm2);
            }
            zzsr zzsrVar = (zzsr) objZzm2;
            zzecVar2.zza.zzq(str4, zzsrVar);
            return zzsrVar.zzj();
            double dLongValue = ((Number) objZzm).longValue();
            zzdt zzdtVar2 = zzecVar3.zza;
            double d2 = 0.45d * dLongValue;
            zzduVar.zze = zzecVar3;
            zzduVar.zzf = str2;
            zzduVar.zzg = recaptchaAction2;
            double d3 = dLongValue * 0.55d;
            zzduVar.zza = d3;
            zzduVar.zzd = 2;
            Object objZzl = zzdtVar2.zzl(str2, (long) d2, zzduVar);
            if (objZzl != coroutine_suspended) {
                zzecVar = zzecVar3;
                recaptchaAction3 = recaptchaAction2;
                str3 = str2;
                objZzm2 = objZzl;
                d = d3;
                zzsi zzsiVar2 = (zzsi) objZzm2;
                zzdt zzdtVar3 = zzecVar.zza;
                zzscVar = zzecVar.zze;
                if (zzscVar == null) {
                    zzscVar = null;
                }
                zzsp zzspVarZzi2 = zzdtVar3.zzi(recaptchaAction3, zzsiVar2, zzscVar);
                zzduVar.zze = zzecVar;
                zzduVar.zzf = str3;
                zzduVar.zzg = null;
                zzduVar.zzd = 3;
                String str7 = str3;
                objZzm2 = zzecVar.zza.zzm(zzspVarZzi2, str7, (long) d, zzduVar);
                str4 = str7;
                if (objZzm2 != coroutine_suspended) {
                    zzecVar2 = zzecVar;
                    zzsr zzsrVar2 = (zzsr) objZzm2;
                    zzecVar2.zza.zzq(str4, zzsrVar2);
                    return zzsrVar2.zzj();
                }
            }
            return coroutine_suspended;
        } catch (zzbd e) {
            throw e;
        } catch (Exception e2) {
            throw new zzbd(zzbb.zzb, zzba.zzay, e2.getMessage());
        }
    }

    @Override // com.google.android.recaptcha.internal.zzcn
    public final Object zzb(long j, Continuation continuation) {
        Object objZzn = zzn(j, continuation);
        return objZzn == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objZzn : Unit.INSTANCE;
    }
}
