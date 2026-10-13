package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzahj {
    private static final Logger zza = Logger.getLogger(zzahj.class.getName());
    private static final zzahj zzd = new zzahj();
    private final ConcurrentMap zzb = new ConcurrentHashMap();
    private final ConcurrentMap zzc = new ConcurrentHashMap();

    public static zzahj zza() {
        return zzd;
    }

    private final synchronized zzwa zze(String str) throws GeneralSecurityException {
        ConcurrentMap concurrentMap;
        concurrentMap = this.zzb;
        if (!concurrentMap.containsKey(str)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 98);
            sb.append("No key manager found for key type ");
            sb.append(str);
            sb.append(", see https://developers.google.com/tink/faq/registration_errors");
            throw new GeneralSecurityException(sb.toString());
        }
        return (zzwa) concurrentMap.get(str);
    }

    private final synchronized void zzf(zzwa zzwaVar, boolean z, boolean z2) throws GeneralSecurityException {
        String strZzb = zzwaVar.zzb();
        if (z2) {
            ConcurrentMap concurrentMap = this.zzc;
            if (concurrentMap.containsKey(strZzb) && !((Boolean) concurrentMap.get(strZzb)).booleanValue()) {
                throw new GeneralSecurityException("New keys are already disallowed for key type ".concat(strZzb));
            }
        }
        ConcurrentMap concurrentMap2 = this.zzb;
        zzwa zzwaVar2 = (zzwa) concurrentMap2.get(strZzb);
        if (zzwaVar2 != null && !zzwaVar2.getClass().equals(zzwaVar.getClass())) {
            zza.logp(Level.WARNING, "com.google.crypto.tink.internal.KeyManagerRegistry", "insertKeyManager", "Attempted overwrite of a registered key manager for key type ".concat(strZzb));
            throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", strZzb, zzwaVar2.getClass().getName(), zzwaVar.getClass().getName()));
        }
        concurrentMap2.putIfAbsent(strZzb, zzwaVar);
        this.zzc.put(strZzb, Boolean.valueOf(z2));
    }

    public final synchronized void zzb(zzwa zzwaVar, boolean z) throws GeneralSecurityException {
        zzd(zzwaVar, 1, z);
    }

    public final zzwa zzc(String str, Class cls) throws GeneralSecurityException {
        zzwa zzwaVarZze = zze(str);
        if (zzwaVarZze.zzc().equals(cls)) {
            return zzwaVarZze;
        }
        String name = cls.getName();
        String strValueOf = String.valueOf(zzwaVarZze.getClass());
        String string = zzwaVarZze.zzc().toString();
        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 53 + String.valueOf(strValueOf).length() + 23 + string.length());
        sb.append("Primitive type ");
        sb.append(name);
        sb.append(" not supported by key manager of type ");
        sb.append(strValueOf);
        sb.append(", which only supports: ");
        sb.append(string);
        throw new GeneralSecurityException(sb.toString());
    }

    public final synchronized void zzd(zzwa zzwaVar, int i, boolean z) throws GeneralSecurityException {
        if (!zzaco.zza(i)) {
            throw new GeneralSecurityException("Cannot register key manager: FIPS compatibility insufficient");
        }
        zzf(zzwaVar, false, z);
    }
}
