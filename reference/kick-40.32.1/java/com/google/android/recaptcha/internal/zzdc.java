package com.google.android.recaptcha.internal;

import com.google.android.gms.tasks.Task;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.android.recaptcha.RecaptchaClient;
import com.google.android.recaptcha.RecaptchaTasksClient;
import java.util.UUID;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.text.Regex;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzdc implements RecaptchaClient, RecaptchaTasksClient {
    private static final Regex zza = new Regex("^[a-zA-Z0-9/_]{0,100}$");
    private final zzcn zzb;
    private final String zzc;
    private final zzek zzd;
    private final zzbi zze;

    public zzdc(zzcn zzcnVar, String str, zzbi zzbiVar, zzek zzekVar) {
        this.zzb = zzcnVar;
        this.zzc = str;
        this.zze = zzbiVar;
        this.zzd = zzekVar;
    }

    public static final /* synthetic */ void zze(zzdc zzdcVar, long j, RecaptchaAction recaptchaAction) throws zzbd {
        zzbd zzbdVar = !zza.matches(recaptchaAction.getAction()) ? new zzbd(zzbb.zzg, zzba.zzh, null) : null;
        if (j < 5000) {
            zzbdVar = new zzbd(zzbb.zzb, zzba.zzI, null);
        }
        if (zzbdVar != null) {
            throw zzbdVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object zzg(String str, Function2 function2, Continuation continuation) throws zzbd {
        zzdb zzdbVar;
        Exception e;
        zzen zzenVar;
        zzbd e2;
        if (continuation instanceof zzdb) {
            zzdbVar = (zzdb) continuation;
            int i = zzdbVar.zzc;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzdbVar.zzc = i - Integer.MIN_VALUE;
            } else {
                zzdbVar = new zzdb(this, continuation);
            }
        } else {
            zzdbVar = new zzdb(this, continuation);
        }
        Object objInvoke = zzdbVar.zza;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzdbVar.zzc;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objInvoke);
            zzek zzekVarZza = this.zzd.zza();
            zzekVarZza.zzc(str);
            zzen zzenVarZzf = zzekVarZza.zzf(9);
            try {
                zzdbVar.zzd = zzenVarZzf;
                zzdbVar.zzc = 1;
                objInvoke = function2.invoke(zzekVarZza, zzdbVar);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                zzenVar = zzenVarZzf;
            } catch (zzbd e3) {
                e2 = e3;
                zzenVar = zzenVarZzf;
                zzenVar.zzb(e2);
                throw e2;
            } catch (Exception e4) {
                e = e4;
                zzenVar = zzenVarZzf;
                zzbd zzbdVar = new zzbd(zzbb.zzb, zzba.zzX, e.getMessage());
                zzenVar.zzb(zzbdVar);
                throw zzbdVar;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            zzenVar = zzdbVar.zzd;
            try {
                ResultKt.throwOnFailure(objInvoke);
            } catch (zzbd e5) {
                e2 = e5;
                zzenVar.zzb(e2);
                throw e2;
            } catch (Exception e6) {
                e = e6;
                zzbd zzbdVar2 = new zzbd(zzbb.zzb, zzba.zzX, e.getMessage());
                zzenVar.zzb(zzbdVar2);
                throw zzbdVar2;
            }
        }
        zzenVar.zza();
        return objInvoke;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.google.android.recaptcha.RecaptchaClient
    /* JADX INFO: renamed from: execute-0E7RQCE */
    public final Object mo11568execute0E7RQCE(RecaptchaAction recaptchaAction, long j, Continuation<? super Result<String>> continuation) {
        zzcw zzcwVar;
        if (continuation instanceof zzcw) {
            zzcwVar = (zzcw) continuation;
            int i = zzcwVar.zzc;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzcwVar.zzc = i - Integer.MIN_VALUE;
            } else {
                zzcwVar = new zzcw(this, continuation);
            }
        } else {
            zzcwVar = new zzcw(this, continuation);
        }
        Object obj = zzcwVar.zza;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzcwVar.zzc;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        zzcwVar.zzc = 1;
        Object objZzf = zzf(recaptchaAction, j, zzcwVar);
        return objZzf == coroutine_suspended ? coroutine_suspended : objZzf;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.google.android.recaptcha.RecaptchaClient
    /* JADX INFO: renamed from: execute-gIAlu-s */
    public final Object mo11569executegIAlus(RecaptchaAction recaptchaAction, Continuation<? super Result<String>> continuation) {
        zzcx zzcxVar;
        if (continuation instanceof zzcx) {
            zzcxVar = (zzcx) continuation;
            int i = zzcxVar.zzc;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzcxVar.zzc = i - Integer.MIN_VALUE;
            } else {
                zzcxVar = new zzcx(this, continuation);
            }
        } else {
            zzcxVar = new zzcx(this, continuation);
        }
        Object obj = zzcxVar.zza;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzcxVar.zzc;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        zzcxVar.zzc = 1;
        Object objMo11568execute0E7RQCE = mo11568execute0E7RQCE(recaptchaAction, 10000L, zzcxVar);
        return objMo11568execute0E7RQCE == coroutine_suspended ? coroutine_suspended : objMo11568execute0E7RQCE;
    }

    @Override // com.google.android.recaptcha.RecaptchaTasksClient
    public final Task<String> executeTask(RecaptchaAction recaptchaAction) {
        return zzas.zza(BuildersKt__Builders_commonKt.async$default(this.zze.zzb(), null, null, new zzda(this, recaptchaAction, 10000L, null), 3, null));
    }

    public final String zzd() {
        return this.zzc;
    }

    @Override // com.google.android.recaptcha.RecaptchaTasksClient
    public final Task<String> executeTask(RecaptchaAction recaptchaAction, long j) {
        return zzas.zza(BuildersKt__Builders_commonKt.async$default(this.zze.zzb(), null, null, new zzda(this, recaptchaAction, j, null), 3, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object zzf(RecaptchaAction recaptchaAction, long j, Continuation continuation) {
        zzcy zzcyVar;
        if (continuation instanceof zzcy) {
            zzcyVar = (zzcy) continuation;
            int i = zzcyVar.zzc;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzcyVar.zzc = i - Integer.MIN_VALUE;
            } else {
                zzcyVar = new zzcy(this, continuation);
            }
        } else {
            zzcyVar = new zzcy(this, continuation);
        }
        Object objZzg = zzcyVar.zza;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzcyVar.zzc;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objZzg);
                String string = UUID.randomUUID().toString();
                Function2 zzczVar = new zzcz(this, j, recaptchaAction, string, null);
                zzcyVar.zzc = 1;
                objZzg = zzg(string, zzczVar, zzcyVar);
                if (objZzg == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objZzg);
            }
            return ((Result) objZzg).getValue();
        } catch (zzbd e) {
            Result.Companion companion = Result.INSTANCE;
            return Result.m12684constructorimpl(ResultKt.createFailure(e.zzc()));
        }
    }
}
