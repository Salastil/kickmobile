package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzajb {
    private final Map zza;
    private final Map zzb;

    /* synthetic */ zzajb(zzaiy zzaiyVar, byte[] bArr) {
        this.zza = new HashMap(zzaiyVar.zzd());
        this.zzb = new HashMap(zzaiyVar.zze());
    }

    public static zzaiy zza() {
        return new zzaiy(null);
    }

    private final Object zzg(zzvz zzvzVar, Class cls) throws GeneralSecurityException {
        zzaiz zzaizVar = new zzaiz(zzvzVar.getClass(), cls, null);
        Map map = this.zza;
        if (map.containsKey(zzaizVar)) {
            return ((zzaix) map.get(zzaizVar)).zza(zzvzVar);
        }
        String string = zzaizVar.toString();
        StringBuilder sb = new StringBuilder(string.length() + 102);
        sb.append("No PrimitiveConstructor for ");
        sb.append(string);
        sb.append(" available, see https://developers.google.com/tink/faq/registration_errors");
        throw new GeneralSecurityException(sb.toString());
    }

    public final Object zzb(zzvz zzvzVar, Class cls) throws GeneralSecurityException {
        return zzg(zzvzVar, cls);
    }

    public final Object zzc(zzwf zzwfVar, Class cls) throws GeneralSecurityException {
        Map map = this.zzb;
        if (!map.containsKey(cls)) {
            throw new GeneralSecurityException("No wrapper found for ".concat(cls.toString()));
        }
        final zzajd zzajdVar = (zzajd) map.get(cls);
        return zzajdVar.zzd(zzwfVar, new zzajc() { // from class: com.google.android.gms.internal.pal.zzaja
            @Override // com.google.android.gms.internal.pal.zzajc
            public final /* synthetic */ Object zza(zzwd zzwdVar) {
                return this.zza.zzf(zzajdVar, zzwdVar);
            }
        });
    }

    final /* synthetic */ Map zzd() {
        return this.zza;
    }

    final /* synthetic */ Map zze() {
        return this.zzb;
    }

    final /* synthetic */ Object zzf(zzajd zzajdVar, zzwd zzwdVar) {
        return zzg(zzwdVar.zza(), zzajdVar.zzb());
    }
}
