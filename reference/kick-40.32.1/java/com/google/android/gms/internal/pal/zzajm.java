package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzajm {
    private final Map zza;
    private final Map zzb;
    private final Map zzc;
    private final Map zzd;

    /* synthetic */ zzajm(zzajj zzajjVar, byte[] bArr) {
        this.zza = new HashMap(zzajjVar.zze());
        this.zzb = new HashMap(zzajjVar.zzf());
        this.zzc = new HashMap(zzajjVar.zzg());
        this.zzd = new HashMap(zzajjVar.zzh());
    }

    public final boolean zza(zzaji zzajiVar) {
        return this.zzb.containsKey(new zzajk(zzajiVar.getClass(), zzajiVar.zzd(), null));
    }

    public final zzvz zzb(zzaji zzajiVar, @Nullable zzwm zzwmVar) throws GeneralSecurityException {
        zzajk zzajkVar = new zzajk(zzajiVar.getClass(), zzajiVar.zzd(), null);
        Map map = this.zzb;
        if (map.containsKey(zzajkVar)) {
            return ((zzahm) map.get(zzajkVar)).zza(zzajiVar, zzwmVar);
        }
        String string = zzajkVar.toString();
        StringBuilder sb = new StringBuilder(string.length() + 47);
        sb.append("No Key Parser for requested key type ");
        sb.append(string);
        sb.append(" available");
        throw new GeneralSecurityException(sb.toString());
    }

    public final zzaji zzc(zzvz zzvzVar, Class cls, @Nullable zzwm zzwmVar) throws GeneralSecurityException {
        zzajl zzajlVar = new zzajl(zzvzVar.getClass(), cls, null);
        Map map = this.zza;
        if (map.containsKey(zzajlVar)) {
            return ((zzahp) map.get(zzajlVar)).zza(zzvzVar, zzwmVar);
        }
        String string = zzajlVar.toString();
        StringBuilder sb = new StringBuilder(string.length() + 32);
        sb.append("No Key serializer for ");
        sb.append(string);
        sb.append(" available");
        throw new GeneralSecurityException(sb.toString());
    }

    public final boolean zzd(zzaji zzajiVar) {
        return this.zzd.containsKey(new zzajk(zzajiVar.getClass(), zzajiVar.zzd(), null));
    }

    public final zzwk zze(zzaji zzajiVar) throws GeneralSecurityException {
        zzajk zzajkVar = new zzajk(zzajiVar.getClass(), zzajiVar.zzd(), null);
        Map map = this.zzd;
        if (map.containsKey(zzajkVar)) {
            return ((zzaip) map.get(zzajkVar)).zza(zzajiVar);
        }
        String string = zzajkVar.toString();
        StringBuilder sb = new StringBuilder(string.length() + 54);
        sb.append("No Parameters Parser for requested key type ");
        sb.append(string);
        sb.append(" available");
        throw new GeneralSecurityException(sb.toString());
    }

    public final zzaji zzf(zzwk zzwkVar, Class cls) throws GeneralSecurityException {
        zzajl zzajlVar = new zzajl(zzwkVar.getClass(), cls, null);
        Map map = this.zzc;
        if (map.containsKey(zzajlVar)) {
            return ((zzais) map.get(zzajlVar)).zza(zzwkVar);
        }
        String string = zzajlVar.toString();
        StringBuilder sb = new StringBuilder(string.length() + 39);
        sb.append("No Key Format serializer for ");
        sb.append(string);
        sb.append(" available");
        throw new GeneralSecurityException(sb.toString());
    }

    final /* synthetic */ Map zzg() {
        return this.zza;
    }

    final /* synthetic */ Map zzh() {
        return this.zzb;
    }

    final /* synthetic */ Map zzi() {
        return this.zzc;
    }

    final /* synthetic */ Map zzj() {
        return this.zzd;
    }
}
