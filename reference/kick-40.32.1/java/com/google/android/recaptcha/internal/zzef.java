package com.google.android.recaptcha.internal;

import com.google.android.recaptcha.RecaptchaAction;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzef implements zzcn {
    private final zzdt zza;
    private zzcm zzb = zzcm.zza;
    private zzsc zzc;

    public zzef(zzdt zzdtVar) {
        this.zza = zzdtVar;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    @Override // com.google.android.recaptcha.internal.zzcn
    public final Object zza(String str, RecaptchaAction recaptchaAction, long j, Continuation continuation) throws zzbd {
        zzed zzedVar;
        RecaptchaAction recaptchaAction2;
        double d;
        zzef zzefVar;
        String str2;
        zzef zzefVar2 = this;
        String str3 = str;
        if (continuation instanceof zzed) {
            zzedVar = (zzed) continuation;
            int i = zzedVar.zzd;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzedVar.zzd = i - Integer.MIN_VALUE;
            } else {
                zzedVar = new zzed(zzefVar2, continuation);
            }
        } else {
            zzedVar = new zzed(zzefVar2, continuation);
        }
        Object objZzl = zzedVar.zzb;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzedVar.zzd;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objZzl);
                if (!Intrinsics.areEqual(zzefVar2.zzb, zzcm.zzb)) {
                    throw new zzbd(zzbb.zzb, zzba.zzar, null);
                }
                double d2 = j;
                zzdt zzdtVar = zzefVar2.zza;
                double d3 = 0.45d * d2;
                zzedVar.zze = zzefVar2;
                zzedVar.zzf = str3;
                recaptchaAction2 = recaptchaAction;
                zzedVar.zzg = recaptchaAction2;
                d = d2 * 0.55d;
                zzedVar.zza = d;
                zzedVar.zzd = 1;
                objZzl = zzdtVar.zzl(str3, (long) d3, zzedVar);
                if (objZzl != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i2 == 1) {
                double d4 = zzedVar.zza;
                recaptchaAction2 = zzedVar.zzg;
                String str4 = zzedVar.zzf;
                zzef zzefVar3 = zzedVar.zze;
                ResultKt.throwOnFailure(objZzl);
                zzefVar2 = zzefVar3;
                d = d4;
                str3 = str4;
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                str2 = zzedVar.zzf;
                zzefVar = zzedVar.zze;
                ResultKt.throwOnFailure(objZzl);
            }
            zzsr zzsrVar = (zzsr) objZzl;
            zzefVar.zza.zzq(str2, zzsrVar);
            return zzsrVar.zzj();
            zzsi zzsiVar = (zzsi) objZzl;
            zzdt zzdtVar2 = zzefVar2.zza;
            zzsc zzscVar = zzefVar2.zzc;
            if (zzscVar == null) {
                zzscVar = null;
            }
            zzsp zzspVarZzi = zzdtVar2.zzi(recaptchaAction2, zzsiVar, zzscVar);
            zzedVar.zze = zzefVar2;
            zzedVar.zzf = str3;
            zzedVar.zzg = null;
            zzedVar.zzd = 2;
            String str5 = str3;
            objZzl = zzefVar2.zza.zzm(zzspVarZzi, str5, (long) d, zzedVar);
            if (objZzl != coroutine_suspended) {
                zzefVar = zzefVar2;
                str2 = str5;
                zzsr zzsrVar2 = (zzsr) objZzl;
                zzefVar.zza.zzq(str2, zzsrVar2);
                return zzsrVar2.zzj();
            }
            return coroutine_suspended;
        } catch (zzbd e) {
            throw e;
        } catch (Exception e2) {
            throw new zzbd(zzbb.zzb, zzba.zzaz, e2.getMessage());
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x009d, code lost:
    
        if (r11.zza.zzn(r14, (long) r12, r0) != r1) goto L34;
     */
    @Override // com.google.android.recaptcha.internal.zzcn
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object zzb(long r12, kotlin.coroutines.Continuation r14) throws com.google.android.recaptcha.internal.zzbd {
        /*
            r11 = this;
            boolean r0 = r14 instanceof com.google.android.recaptcha.internal.zzee
            if (r0 == 0) goto L13
            r0 = r14
            com.google.android.recaptcha.internal.zzee r0 = (com.google.android.recaptcha.internal.zzee) r0
            int r1 = r0.zzd
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzd = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzee r0 = new com.google.android.recaptcha.internal.zzee
            r0.<init>(r11, r14)
        L18:
            java.lang.Object r14 = r0.zzb
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zzd
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4e
            if (r2 == r4) goto L3d
            if (r2 != r3) goto L35
            com.google.android.recaptcha.internal.zzef r11 = r0.zze
            r12 = r11
            com.google.android.recaptcha.internal.zzef r12 = (com.google.android.recaptcha.internal.zzef) r12
            kotlin.ResultKt.throwOnFailure(r14)     // Catch: com.google.android.recaptcha.internal.zzbd -> L32
            goto L9f
        L32:
            r12 = move-exception
            goto Lab
        L35:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L3d:
            double r11 = r0.zza
            com.google.android.recaptcha.internal.zzef r13 = r0.zze
            r2 = r13
            com.google.android.recaptcha.internal.zzef r2 = (com.google.android.recaptcha.internal.zzef) r2
            kotlin.ResultKt.throwOnFailure(r14)     // Catch: com.google.android.recaptcha.internal.zzbd -> L4b
            r9 = r11
            r11 = r13
            r12 = r9
            goto L8e
        L4b:
            r12 = move-exception
            r11 = r13
            goto Lab
        L4e:
            kotlin.ResultKt.throwOnFailure(r14)
            com.google.android.recaptcha.internal.zzcm r14 = r11.zzb
            com.google.android.recaptcha.internal.zzcj r2 = com.google.android.recaptcha.internal.zzcm.zzb()
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual(r14, r2)
            if (r14 != 0) goto Lb4
            com.google.android.recaptcha.internal.zzcm r14 = r11.zzb
            com.google.android.recaptcha.internal.zzci r2 = com.google.android.recaptcha.internal.zzcm.zza()
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual(r14, r2)
            if (r14 == 0) goto L6a
            goto Lb4
        L6a:
            com.google.android.recaptcha.internal.zzck r14 = com.google.android.recaptcha.internal.zzcm.zzc()
            com.google.android.recaptcha.internal.zzcm r14 = (com.google.android.recaptcha.internal.zzcm) r14
            r11.zzb = r14
            double r12 = (double) r12
            com.google.android.recaptcha.internal.zzdt r14 = r11.zza     // Catch: com.google.android.recaptcha.internal.zzbd -> L32
            r5 = 4603579539098121011(0x3fe3333333333333, double:0.6)
            double r5 = r5 * r12
            r0.zze = r11     // Catch: com.google.android.recaptcha.internal.zzbd -> L32
            r7 = 4600877379321698714(0x3fd999999999999a, double:0.4)
            double r12 = r12 * r7
            r0.zza = r12     // Catch: com.google.android.recaptcha.internal.zzbd -> L32
            r0.zzd = r4     // Catch: com.google.android.recaptcha.internal.zzbd -> L32
            long r4 = (long) r5     // Catch: com.google.android.recaptcha.internal.zzbd -> L32
            java.lang.Object r14 = r14.zzo(r4, r0)     // Catch: com.google.android.recaptcha.internal.zzbd -> L32
            if (r14 == r1) goto Laa
        L8e:
            com.google.android.recaptcha.internal.zzsc r14 = (com.google.android.recaptcha.internal.zzsc) r14     // Catch: com.google.android.recaptcha.internal.zzbd -> L32
            r11.zzc = r14     // Catch: com.google.android.recaptcha.internal.zzbd -> L32
            com.google.android.recaptcha.internal.zzdt r2 = r11.zza     // Catch: com.google.android.recaptcha.internal.zzbd -> L32
            long r12 = (long) r12     // Catch: com.google.android.recaptcha.internal.zzbd -> L32
            r0.zze = r11     // Catch: com.google.android.recaptcha.internal.zzbd -> L32
            r0.zzd = r3     // Catch: com.google.android.recaptcha.internal.zzbd -> L32
            java.lang.Object r12 = r2.zzn(r14, r12, r0)     // Catch: com.google.android.recaptcha.internal.zzbd -> L32
            if (r12 == r1) goto Laa
        L9f:
            com.google.android.recaptcha.internal.zzcj r12 = com.google.android.recaptcha.internal.zzcm.zzb()     // Catch: com.google.android.recaptcha.internal.zzbd -> L32
            com.google.android.recaptcha.internal.zzcm r12 = (com.google.android.recaptcha.internal.zzcm) r12     // Catch: com.google.android.recaptcha.internal.zzbd -> L32
            r11.zzb = r12     // Catch: com.google.android.recaptcha.internal.zzbd -> L32
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        Laa:
            return r1
        Lab:
            com.google.android.recaptcha.internal.zzci r13 = com.google.android.recaptcha.internal.zzcm.zza()
            com.google.android.recaptcha.internal.zzcm r13 = (com.google.android.recaptcha.internal.zzcm) r13
            r11.zzb = r13
            throw r12
        Lb4:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzef.zzb(long, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
