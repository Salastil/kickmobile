package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zznq extends zzadp implements zzafd {
    private zznq() {
        throw null;
    }

    /* synthetic */ zznq(byte[] bArr) {
        super(zznr.zzg);
    }

    public final List zza() {
        return Collections.unmodifiableList(((zznr) this.zza).zza());
    }

    public final zznq zzb(String str) {
        zzaY();
        ((zznr) this.zza).zzc("");
        return this;
    }

    public final zznq zzc(String str) {
        zzaY();
        ((zznr) this.zza).zzd("");
        return this;
    }
}
