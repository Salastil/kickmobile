package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.crypto.Mac;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzark extends ThreadLocal {
    final /* synthetic */ zzarl zza;

    zzark(zzarl zzarlVar) {
        Objects.requireNonNull(zzarlVar);
        this.zza = zzarlVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.lang.ThreadLocal
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final Mac initialValue() {
        try {
            zzaqx zzaqxVar = zzaqx.zzb;
            zzarl zzarlVar = this.zza;
            Mac mac = (Mac) zzaqxVar.zzb(zzarlVar.zzb());
            mac.init(zzarlVar.zzc());
            return mac;
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }
}
