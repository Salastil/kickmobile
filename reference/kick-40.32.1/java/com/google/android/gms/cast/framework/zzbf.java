package com.google.android.gms.cast.framework;

import android.os.Bundle;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzbf extends zzbb {
    final /* synthetic */ Session zza;

    /* synthetic */ zzbf(Session session, byte[] bArr) {
        Objects.requireNonNull(session);
        this.zza = session;
    }

    @Override // com.google.android.gms.cast.framework.zzbc
    public final IObjectWrapper zzb() {
        return ObjectWrapper.wrap(this.zza);
    }

    @Override // com.google.android.gms.cast.framework.zzbc
    public final void zzc(Bundle bundle) {
        this.zza.onStarting(bundle);
    }

    @Override // com.google.android.gms.cast.framework.zzbc
    public final void zzd(Bundle bundle) {
        this.zza.start(bundle);
    }

    @Override // com.google.android.gms.cast.framework.zzbc
    public final void zze(Bundle bundle) {
        this.zza.onResuming(bundle);
    }

    @Override // com.google.android.gms.cast.framework.zzbc
    public final void zzf(Bundle bundle) {
        this.zza.resume(bundle);
    }

    @Override // com.google.android.gms.cast.framework.zzbc
    public final void zzg(boolean z) {
        this.zza.end(z);
    }

    @Override // com.google.android.gms.cast.framework.zzbc
    public final void zzh(Bundle bundle) {
        this.zza.zza(bundle);
    }

    @Override // com.google.android.gms.cast.framework.zzbc
    public final long zzi() {
        return this.zza.getSessionRemainingTimeMs();
    }
}
