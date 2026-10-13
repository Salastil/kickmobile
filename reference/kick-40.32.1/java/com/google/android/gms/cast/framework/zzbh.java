package com.google.android.gms.cast.framework;

import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzbh extends zzaz {
    final /* synthetic */ SessionProvider zza;

    /* synthetic */ zzbh(SessionProvider sessionProvider, byte[] bArr) {
        Objects.requireNonNull(sessionProvider);
        this.zza = sessionProvider;
    }

    @Override // com.google.android.gms.cast.framework.zzba
    public final IObjectWrapper zzb(String str) {
        Session sessionCreateSession = this.zza.createSession(str);
        if (sessionCreateSession == null) {
            return null;
        }
        return sessionCreateSession.zzn();
    }

    @Override // com.google.android.gms.cast.framework.zzba
    public final boolean zzc() {
        return this.zza.isSessionRecoverable();
    }

    @Override // com.google.android.gms.cast.framework.zzba
    public final String zzd() {
        return this.zza.getCategory();
    }
}
