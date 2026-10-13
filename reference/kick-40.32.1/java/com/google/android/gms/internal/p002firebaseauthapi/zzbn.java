package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzbn implements zzcl {
    private final OutputStream zza;

    public static zzcl zza(OutputStream outputStream) {
        return new zzbn(outputStream);
    }

    private zzbn(OutputStream outputStream) {
        this.zza = outputStream;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcl
    public final void zza(zzwe zzweVar) throws IOException {
        try {
            zzwe.zza zzaVarZzn = zzweVar.zzn();
            zzwe.zza zzaVar = zzaVarZzn;
            ((zzwe) ((zzalt) zzaVarZzn.zza().zze())).zza(this.zza);
        } finally {
            this.zza.close();
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcl
    public final void zza(zzxq zzxqVar) throws IOException {
        try {
            zzxqVar.zza(this.zza);
        } finally {
            this.zza.close();
        }
    }
}
