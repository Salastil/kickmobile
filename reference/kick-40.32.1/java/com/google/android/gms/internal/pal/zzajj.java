package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzajj {
    private final Map zza;
    private final Map zzb;
    private final Map zzc;
    private final Map zzd;

    public zzajj() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
        this.zzc = new HashMap();
        this.zzd = new HashMap();
    }

    public final zzajj zza(zzahp zzahpVar) throws GeneralSecurityException {
        zzajl zzajlVar = new zzajl(zzahpVar.zzb(), zzahpVar.zzc(), null);
        Map map = this.zza;
        if (!map.containsKey(zzajlVar)) {
            map.put(zzajlVar, zzahpVar);
            return this;
        }
        zzahp zzahpVar2 = (zzahp) map.get(zzajlVar);
        if (zzahpVar2.equals(zzahpVar) && zzahpVar.equals(zzahpVar2)) {
            return this;
        }
        throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: ".concat(zzajlVar.toString()));
    }

    public final zzajj zzb(zzahm zzahmVar) throws GeneralSecurityException {
        zzajk zzajkVar = new zzajk(zzahmVar.zzc(), zzahmVar.zzb(), null);
        Map map = this.zzb;
        if (!map.containsKey(zzajkVar)) {
            map.put(zzajkVar, zzahmVar);
            return this;
        }
        zzahm zzahmVar2 = (zzahm) map.get(zzajkVar);
        if (zzahmVar2.equals(zzahmVar) && zzahmVar.equals(zzahmVar2)) {
            return this;
        }
        throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: ".concat(zzajkVar.toString()));
    }

    public final zzajj zzc(zzais zzaisVar) throws GeneralSecurityException {
        zzajl zzajlVar = new zzajl(zzaisVar.zzb(), zzaisVar.zzc(), null);
        Map map = this.zzc;
        if (!map.containsKey(zzajlVar)) {
            map.put(zzajlVar, zzaisVar);
            return this;
        }
        zzais zzaisVar2 = (zzais) map.get(zzajlVar);
        if (zzaisVar2.equals(zzaisVar) && zzaisVar.equals(zzaisVar2)) {
            return this;
        }
        throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: ".concat(zzajlVar.toString()));
    }

    public final zzajj zzd(zzaip zzaipVar) throws GeneralSecurityException {
        zzajk zzajkVar = new zzajk(zzaipVar.zzc(), zzaipVar.zzb(), null);
        Map map = this.zzd;
        if (!map.containsKey(zzajkVar)) {
            map.put(zzajkVar, zzaipVar);
            return this;
        }
        zzaip zzaipVar2 = (zzaip) map.get(zzajkVar);
        if (zzaipVar2.equals(zzaipVar) && zzaipVar.equals(zzaipVar2)) {
            return this;
        }
        throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: ".concat(zzajkVar.toString()));
    }

    final /* synthetic */ Map zze() {
        return this.zza;
    }

    final /* synthetic */ Map zzf() {
        return this.zzb;
    }

    final /* synthetic */ Map zzg() {
        return this.zzc;
    }

    final /* synthetic */ Map zzh() {
        return this.zzd;
    }

    public zzajj(zzajm zzajmVar) {
        this.zza = new HashMap(zzajmVar.zzg());
        this.zzb = new HashMap(zzajmVar.zzh());
        this.zzc = new HashMap(zzajmVar.zzi());
        this.zzd = new HashMap(zzajmVar.zzj());
    }
}
