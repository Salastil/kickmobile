package com.google.android.gms.internal.mlkit_code_scanner;

import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-code-scanner@@16.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzy extends zzr {
    static final zzr zza = new zzy(null, new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    private zzy(@CheckForNull Object obj, Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    static zzy zzg(int i, Object[] objArr, zzq zzqVar) {
        Object obj = objArr[0];
        obj.getClass();
        Object obj2 = objArr[1];
        obj2.getClass();
        zzi.zza(obj, obj2);
        return new zzy(null, objArr, 1);
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0007  */
    @Override // com.google.android.gms.internal.mlkit_code_scanner.zzr, java.util.Map
    @CheckForNull
    public final Object get(@CheckForNull Object obj) {
        Object obj2;
        Object[] objArr = this.zzb;
        int i = this.zzc;
        if (obj != null && i == 1) {
            Object obj3 = objArr[0];
            obj3.getClass();
            if (obj3.equals(obj)) {
                obj2 = objArr[1];
                obj2.getClass();
            } else {
                obj2 = null;
            }
        } else {
            obj2 = null;
        }
        if (obj2 == null) {
            return null;
        }
        return obj2;
    }

    @Override // java.util.Map
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_code_scanner.zzr
    final zzl zza() {
        return new zzx(this.zzb, 1, this.zzc);
    }

    @Override // com.google.android.gms.internal.mlkit_code_scanner.zzr
    final zzs zzd() {
        return new zzv(this, this.zzb, 0, this.zzc);
    }

    @Override // com.google.android.gms.internal.mlkit_code_scanner.zzr
    final zzs zze() {
        return new zzw(this, new zzx(this.zzb, 0, this.zzc));
    }
}
