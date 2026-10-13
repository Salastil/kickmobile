package com.google.android.recaptcha.internal;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzcb {
    private Object zza;
    private final Mutex zzb = MutexKt.Mutex$default(false, 1, null);

    public zzcb(Object obj) {
        this.zza = obj;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object zza(Object obj, Continuation continuation) {
        zzby zzbyVar;
        Mutex mutex;
        if (continuation instanceof zzby) {
            zzbyVar = (zzby) continuation;
            int i = zzbyVar.zzd;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzbyVar.zzd = i - Integer.MIN_VALUE;
            } else {
                zzbyVar = new zzby(this, continuation);
            }
        } else {
            zzbyVar = new zzby(this, continuation);
        }
        Object obj2 = zzbyVar.zzb;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzbyVar.zzd;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            mutex = this.zzb;
            zzbyVar.zze = this;
            zzbyVar.zzf = (zzje) obj;
            zzbyVar.zza = mutex;
            zzbyVar.zzd = 1;
            if (mutex.lock(null, zzbyVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Mutex mutex2 = (Mutex) zzbyVar.zza;
            obj = zzbyVar.zzf;
            zzcb zzcbVar = zzbyVar.zze;
            ResultKt.throwOnFailure(obj2);
            mutex = mutex2;
            this = zzcbVar;
        }
        try {
            return Boxing.boxBoolean(Intrinsics.areEqual(this.zza, obj));
        } finally {
            mutex.unlock(null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object zzb(Object[] objArr, Continuation continuation) {
        zzbz zzbzVar;
        Mutex mutex;
        if (continuation instanceof zzbz) {
            zzbzVar = (zzbz) continuation;
            int i = zzbzVar.zzd;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzbzVar.zzd = i - Integer.MIN_VALUE;
            } else {
                zzbzVar = new zzbz(this, continuation);
            }
        } else {
            zzbzVar = new zzbz(this, continuation);
        }
        Object obj = zzbzVar.zzb;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzbzVar.zzd;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            mutex = this.zzb;
            zzbzVar.zze = this;
            zzbzVar.zzf = (zzje[]) objArr;
            zzbzVar.zza = mutex;
            zzbzVar.zzd = 1;
            if (mutex.lock(null, zzbzVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Mutex mutex2 = (Mutex) zzbzVar.zza;
            objArr = zzbzVar.zzf;
            zzcb zzcbVar = zzbzVar.zze;
            ResultKt.throwOnFailure(obj);
            mutex = mutex2;
            this = zzcbVar;
        }
        try {
            return Boxing.boxBoolean(ArraysKt.contains(objArr, this.zza));
        } finally {
            mutex.unlock(null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object zzc(Object obj, Continuation continuation) {
        zzca zzcaVar;
        Mutex mutex;
        if (continuation instanceof zzca) {
            zzcaVar = (zzca) continuation;
            int i = zzcaVar.zzd;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzcaVar.zzd = i - Integer.MIN_VALUE;
            } else {
                zzcaVar = new zzca(this, continuation);
            }
        } else {
            zzcaVar = new zzca(this, continuation);
        }
        Object obj2 = zzcaVar.zzb;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzcaVar.zzd;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            mutex = this.zzb;
            zzcaVar.zze = this;
            zzcaVar.zzf = (zzje) obj;
            zzcaVar.zza = mutex;
            zzcaVar.zzd = 1;
            if (mutex.lock(null, zzcaVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Mutex mutex2 = (Mutex) zzcaVar.zza;
            obj = zzcaVar.zzf;
            zzcb zzcbVar = zzcaVar.zze;
            ResultKt.throwOnFailure(obj2);
            mutex = mutex2;
            this = zzcbVar;
        }
        try {
            this.zza = obj;
            Unit unit = Unit.INSTANCE;
            return Unit.INSTANCE;
        } finally {
            mutex.unlock(null);
        }
    }
}
