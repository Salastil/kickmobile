package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzoe {
    private static final Logger zza = Logger.getLogger(zzoe.class.getName());
    private static final zzoe zzb = new zzoe();
    private ConcurrentMap<String, zzbw<?>> zzc = new ConcurrentHashMap();
    private ConcurrentMap<String, Boolean> zzd = new ConcurrentHashMap();

    public final <P> zzbw<P> zza(String str, Class<P> cls) throws GeneralSecurityException {
        zzbw<P> zzbwVar = (zzbw<P>) zzc(str);
        if (zzbwVar.zza().equals(cls)) {
            return zzbwVar;
        }
        throw new GeneralSecurityException("Primitive type " + cls.getName() + " not supported by key manager of type " + String.valueOf(zzbwVar.getClass()) + ", which only supports: " + String.valueOf(zzbwVar.zza()));
    }

    private final synchronized zzbw<?> zzc(String str) throws GeneralSecurityException {
        if (!this.zzc.containsKey(str)) {
            throw new GeneralSecurityException("No key manager found for key type " + str + ", see https://developers.google.com/tink/faq/registration_errors");
        }
        return this.zzc.get(str);
    }

    public final zzbw<?> zza(String str) throws GeneralSecurityException {
        return zzc(str);
    }

    public static zzoe zza() {
        return zzb;
    }

    private final synchronized void zza(zzbw<?> zzbwVar, boolean z, boolean z2) throws GeneralSecurityException {
        String strZzb = zzbwVar.zzb();
        if (z2 && this.zzd.containsKey(strZzb) && !this.zzd.get(strZzb).booleanValue()) {
            throw new GeneralSecurityException("New keys are already disallowed for key type " + strZzb);
        }
        zzbw<?> zzbwVar2 = this.zzc.get(strZzb);
        if (zzbwVar2 != null && !zzbwVar2.getClass().equals(zzbwVar.getClass())) {
            zza.logp(Level.WARNING, "com.google.crypto.tink.internal.KeyManagerRegistry", "insertKeyManager", "Attempted overwrite of a registered key manager for key type " + strZzb);
            throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", strZzb, zzbwVar2.getClass().getName(), zzbwVar.getClass().getName()));
        }
        this.zzc.putIfAbsent(strZzb, zzbwVar);
        this.zzd.put(strZzb, Boolean.valueOf(z2));
    }

    public final synchronized <P> void zza(zzbw<P> zzbwVar, boolean z) throws GeneralSecurityException {
        zza(zzbwVar, zzjd.zza.zza, z);
    }

    public final synchronized <P> void zza(zzbw<P> zzbwVar, zzjd.zza zzaVar, boolean z) throws GeneralSecurityException {
        if (!zzaVar.zza()) {
            throw new GeneralSecurityException("Cannot register key manager: FIPS compatibility insufficient");
        }
        zza((zzbw<?>) zzbwVar, false, z);
    }

    public final boolean zzb(String str) {
        return this.zzd.get(str).booleanValue();
    }
}
