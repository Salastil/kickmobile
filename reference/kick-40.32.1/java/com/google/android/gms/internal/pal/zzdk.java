package com.google.android.gms.internal.pal;

import java.io.File;
import java.security.GeneralSecurityException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzdk implements zzki {
    final /* synthetic */ zzix zza;

    zzdk(zzdm zzdmVar, zzix zzixVar) {
        this.zza = zzixVar;
        Objects.requireNonNull(zzdmVar);
    }

    @Override // com.google.android.gms.internal.pal.zzki
    public final boolean zza(File file) {
        try {
            return this.zza.zza(file);
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }
}
