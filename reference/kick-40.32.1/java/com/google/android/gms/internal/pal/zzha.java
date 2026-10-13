package com.google.android.gms.internal.pal;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzha extends zzhd {
    private final zzdp zza;
    private final zzdy zzb;

    public zzha(Context context, Executor executor, zzk zzkVar) {
        zzdu zzduVar = new zzdu(context, executor, zzkVar);
        this.zza = zzduVar;
        this.zzb = new zzdy(zzduVar);
    }

    @Deprecated
    private final IObjectWrapper zzt(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, boolean z) {
        try {
            Uri uri = (Uri) ObjectWrapper.unwrap(iObjectWrapper);
            Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper2);
            zzdy zzdyVar = this.zzb;
            return ObjectWrapper.wrap(z ? zzdyVar.zze(uri, context) : zzdyVar.zzg(uri, context, null, null));
        } catch (zzdz unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.pal.zzhe
    public final boolean zzb() {
        return this.zza.zze();
    }

    @Override // com.google.android.gms.internal.pal.zzhe
    public final boolean zzc() {
        return this.zza.zzf();
    }

    @Override // com.google.android.gms.internal.pal.zzhe
    public final int zzd() {
        zzdp zzdpVar = this.zza;
        if (zzdpVar instanceof zzdu) {
            zzdp zzdpVarZza = ((zzdu) zzdpVar).zza();
            if (zzdpVarZza instanceof zzdx) {
                return 1;
            }
            if (zzdpVarZza instanceof zzdm) {
                return 2;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.pal.zzhe
    public final String zze(IObjectWrapper iObjectWrapper) {
        return this.zza.zzl((Context) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.pal.zzhe
    public final String zzf(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        return this.zza.zzk((Context) ObjectWrapper.unwrap(iObjectWrapper), (View) ObjectWrapper.unwrap(iObjectWrapper2), (Activity) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    @Override // com.google.android.gms.internal.pal.zzhe
    public final void zzg(IObjectWrapper iObjectWrapper) {
        this.zza.zzj((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.pal.zzhe
    public final void zzh(IObjectWrapper iObjectWrapper) {
        this.zzb.zzf((MotionEvent) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.pal.zzhe
    public final String zzi(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3, IObjectWrapper iObjectWrapper4) {
        return this.zza.zzi((Context) ObjectWrapper.unwrap(iObjectWrapper), (String) ObjectWrapper.unwrap(iObjectWrapper2), (View) ObjectWrapper.unwrap(iObjectWrapper3), (Activity) ObjectWrapper.unwrap(iObjectWrapper4));
    }

    @Override // com.google.android.gms.internal.pal.zzhe
    public final String zzj() {
        return "ms";
    }

    @Override // com.google.android.gms.internal.pal.zzhe
    @Deprecated
    public final void zzk(String str, String str2) {
        this.zzb.zza(str, str2);
    }

    @Override // com.google.android.gms.internal.pal.zzhe
    @Deprecated
    public final boolean zzl(IObjectWrapper iObjectWrapper) {
        return this.zzb.zzb((Uri) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.pal.zzhe
    @Deprecated
    public final boolean zzm(IObjectWrapper iObjectWrapper) {
        return this.zzb.zzc((Uri) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.pal.zzhe
    @Deprecated
    public final void zzn(String str) {
        this.zzb.zzd(str);
    }

    @Override // com.google.android.gms.internal.pal.zzhe
    @Deprecated
    public final IObjectWrapper zzo(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        return zzt(iObjectWrapper, iObjectWrapper2, true);
    }

    @Override // com.google.android.gms.internal.pal.zzhe
    @Deprecated
    public final String zzp(IObjectWrapper iObjectWrapper) {
        return zzq(iObjectWrapper, null);
    }

    @Override // com.google.android.gms.internal.pal.zzhe
    @Deprecated
    public final String zzq(IObjectWrapper iObjectWrapper, byte[] bArr) {
        return this.zza.zzm((Context) ObjectWrapper.unwrap(iObjectWrapper), bArr);
    }

    @Override // com.google.android.gms.internal.pal.zzhe
    @Deprecated
    public final String zzr(IObjectWrapper iObjectWrapper, String str) {
        return ((zzdu) this.zza).zzi((Context) ObjectWrapper.unwrap(iObjectWrapper), str, null, null);
    }

    @Override // com.google.android.gms.internal.pal.zzhe
    @Deprecated
    public final IObjectWrapper zzs(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        return zzt(iObjectWrapper, iObjectWrapper2, false);
    }
}
