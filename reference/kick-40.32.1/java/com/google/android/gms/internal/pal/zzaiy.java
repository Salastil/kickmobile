package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaiy {
    private final Map zza;
    private final Map zzb;

    private zzaiy() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
    }

    public final zzaiy zza(zzaix zzaixVar) throws GeneralSecurityException {
        if (zzaixVar == null) {
            throw new NullPointerException("primitive constructor must be non-null");
        }
        zzaiz zzaizVar = new zzaiz(zzaixVar.zzb(), zzaixVar.zzc(), null);
        Map map = this.zza;
        if (!map.containsKey(zzaizVar)) {
            map.put(zzaizVar, zzaixVar);
            return this;
        }
        zzaix zzaixVar2 = (zzaix) map.get(zzaizVar);
        if (zzaixVar2.equals(zzaixVar) && zzaixVar.equals(zzaixVar2)) {
            return this;
        }
        throw new GeneralSecurityException("Attempt to register non-equal PrimitiveConstructor object for already existing object of type: ".concat(zzaizVar.toString()));
    }

    public final zzaiy zzb(zzajd zzajdVar) throws GeneralSecurityException {
        Map map = this.zzb;
        Class clsZza = zzajdVar.zza();
        if (!map.containsKey(clsZza)) {
            map.put(clsZza, zzajdVar);
            return this;
        }
        zzajd zzajdVar2 = (zzajd) map.get(clsZza);
        if (zzajdVar2.equals(zzajdVar) && zzajdVar.equals(zzajdVar2)) {
            return this;
        }
        throw new GeneralSecurityException("Attempt to register non-equal PrimitiveWrapper object or input class object for already existing object of type".concat(clsZza.toString()));
    }

    public final zzajb zzc() {
        return new zzajb(this, null);
    }

    final /* synthetic */ Map zzd() {
        return this.zza;
    }

    final /* synthetic */ Map zze() {
        return this.zzb;
    }

    /* synthetic */ zzaiy(zzajb zzajbVar, byte[] bArr) {
        this.zza = new HashMap(zzajbVar.zzd());
        this.zzb = new HashMap(zzajbVar.zze());
    }

    /* synthetic */ zzaiy(byte[] bArr) {
        this.zza = new HashMap();
        this.zzb = new HashMap();
    }
}
