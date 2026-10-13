package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzbx implements zzch {
    private final List<zzcd> zza;
    private final Map<Class<?>, zzbl> zzb;

    @Nullable
    private final zzbx zzc;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzch
    public final int zza() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzch
    @Nullable
    public final <T extends zzbl> T zza(Class<T> cls) {
        return (T) this.zzb.get(cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzbx zzb(final zzbx zzbxVar) {
        final zzoq zzoqVar = (zzoq) zzbxVar.zza(zzoq.class);
        if (zzoqVar == null) {
            return zzbxVar;
        }
        zzcf zzcfVar = new zzcf() { // from class: com.google.android.gms.internal.firebase-auth-api.zzca
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcf
            public final void zza(zzcd zzcdVar) {
                zzpc.zzb().zza().zza(this.zza, zzoqVar, "keyset_handle", "get_key").zza(zzcdVar.zza());
            }
        };
        ArrayList arrayList = new ArrayList(zzbxVar.zza.size());
        for (zzcd zzcdVar : zzbxVar.zza) {
            arrayList.add(new zzcd(zzcdVar.zzb, zzcdVar.zzc, zzcdVar.zze, zzcdVar.zzf, zzcdVar.zzg, zzcfVar));
        }
        return new zzbx(arrayList, zzbxVar.zzb, zzbxVar);
    }

    static final zzbx zza(zzxq zzxqVar, zzbq zzbqVar) throws GeneralSecurityException {
        zza(zzxqVar);
        List<zzcd> listZzb = zzb(zzxqVar, zzbqVar);
        if (zza(zzbqVar)) {
            HashSet hashSet = new HashSet();
            boolean z = false;
            for (zzcd zzcdVar : listZzb) {
                if (hashSet.contains(Integer.valueOf(zzcdVar.zza()))) {
                    throw new GeneralSecurityException("KeyID " + zzcdVar.zza() + " is duplicated in the keyset, and Tink is configured to reject such keysets with the flag validateKeysetsOnParsing.");
                }
                hashSet.add(Integer.valueOf(zzcdVar.zza()));
                if (zzcdVar.zze()) {
                    z = true;
                }
            }
            if (!z) {
                throw new GeneralSecurityException("Primary key id not found in keyset, and Tink is configured to reject such keysets with the flag validateKeysetsOnParsing.");
            }
        }
        return new zzbx(listZzb, new HashMap());
    }

    public static final zzbx zza(zzby zzbyVar) throws GeneralSecurityException {
        return new zzcc().zza(new zzcb(zzbyVar.zza()).zzb().zza()).zza();
    }

    public final zzbx zzb() throws GeneralSecurityException {
        zzbt zzbtVarZzc;
        ArrayList arrayList = new ArrayList(this.zza.size());
        for (zzcd zzcdVar : this.zza) {
            if (zzcdVar.zzb() instanceof zzcr) {
                zzbtVarZzc = ((zzcr) zzcdVar.zzb()).zzc();
            } else if (zzcdVar.zzb() instanceof zzon) {
                zzbtVarZzc = ((zzon) zzcdVar.zzb()).zzc();
            } else {
                throw new GeneralSecurityException("Cannot get Public Key for key of type " + String.valueOf(zzcdVar.zzb().getClass()));
            }
            zzbt zzbtVar = zzbtVarZzc;
            zzcd zzcdVar2 = new zzcd(zzbtVar, zzcdVar.zzc, zzcdVar.zza(), zzcdVar.zze(), false, zzcd.zza);
            zza(zzbtVar, zzcdVar.zza());
            arrayList.add(zzcdVar2);
        }
        return zzb(new zzbx(arrayList, this.zzb));
    }

    private final zzbx zze() {
        zzbx zzbxVar = this.zzc;
        return zzbxVar == null ? this : zzbxVar;
    }

    @Deprecated
    public static final zzbx zza(zzcm zzcmVar, zzbm zzbmVar, byte[] bArr) throws GeneralSecurityException, IOException {
        zzbq zzbqVarZza = zzda.zza();
        zzwe zzweVarZza = zzcmVar.zza();
        if (zzweVarZza == null || zzweVarZza.zzc().zza() == 0) {
            throw new GeneralSecurityException("empty keyset");
        }
        return zza(zza(zzweVarZza, zzbmVar, bArr), zzbqVarZza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzch
    public final /* synthetic */ zzck zza(int i) {
        if (i < 0 || i >= zza()) {
            throw new IndexOutOfBoundsException("Invalid index " + i + " for keyset of size " + zza());
        }
        zzcd zzcdVar = this.zza.get(i);
        if (!zza(zzcdVar.zzc)) {
            throw new IllegalStateException("Keyset-Entry at position " + i + " has wrong status");
        }
        if (zzcdVar.zzg) {
            throw new IllegalStateException("Keyset-Entry at position " + i + " didn't parse correctly");
        }
        return this.zza.get(i);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzch
    public final /* synthetic */ zzck zzc() {
        for (zzcd zzcdVar : this.zza) {
            if (zzcdVar != null && zzcdVar.zze()) {
                if (zzcdVar.zzc() == zzbv.zza) {
                    return zzcdVar;
                }
                throw new IllegalStateException("Keyset has primary which isn't enabled");
            }
        }
        throw new IllegalStateException("Keyset has no valid primary");
    }

    private static zzct zza(zzxq.zza zzaVar) throws GeneralSecurityException {
        return zzct.zza(zzaVar.zzb().zzf(), zzaVar.zzb().zze(), zzqk.zza(zzaVar.zzb().zzb()), zzqk.zza(zzaVar.zzf()), zzaVar.zzf() == zzyi.RAW ? null : Integer.valueOf(zzaVar.zza()));
    }

    private static zzxq zza(zzwe zzweVar, zzbm zzbmVar, byte[] bArr) throws GeneralSecurityException {
        try {
            zzxq zzxqVarZza = zzxq.zza(zzbmVar.zza(zzweVar.zzc().zzc(), bArr), zzalf.zza());
            zza(zzxqVarZza);
            return zzxqVarZza;
        } catch (zzamd unused) {
            throw new GeneralSecurityException("invalid keyset, corrupted key material");
        }
    }

    final zzxq zzd() {
        try {
            zzbq zzbqVarZza = zzda.zza();
            zzxq.zzb zzbVarZzc = zzxq.zzc();
            for (zzcd zzcdVar : this.zza) {
                zzbt zzbtVarZzb = zzcdVar.zzb();
                zzxh zzxhVar = zzcdVar.zzc;
                int iZza = zzcdVar.zza();
                zzcy zzcyVar = (zzcy) zzbqVarZza.zza(zzcy.class);
                if (zzcyVar == null) {
                    throw new GeneralSecurityException("Passed in configuration cannot be used to parse and serialize proto keysets.");
                }
                zzct zzctVarZza = zzcyVar.zza(zzbtVarZzb, zzdd.zza());
                zza(zzbtVarZzb, iZza);
                zzbVarZzc.zza((zzxq.zza) ((zzalt) zzxq.zza.zzd().zza(zzxg.zza().zza(zzctVarZza.zze()).zza(zzctVarZza.zzc()).zza(zzqk.zza(zzctVarZza.zza()))).zza(zzxhVar).zza(iZza).zza(zzqk.zza(zzctVarZza.zzb())).zze()));
                if (zzcdVar.zze()) {
                    zzbVarZzc.zza(zzcdVar.zza());
                }
            }
            return (zzxq) ((zzalt) zzbVarZzc.zze());
        } catch (GeneralSecurityException e) {
            throw new zzqs(e);
        }
    }

    public final <P> P zza(zzbq zzbqVar, Class<P> cls) throws GeneralSecurityException {
        String strZze;
        zzdf.zzb(zze().zzd());
        for (int i = 0; i < zza(); i++) {
            if (this.zza.get(i).zzg || !zza(this.zza.get(i).zzc)) {
                zzbt zzbtVar = this.zza.get(i).zzb;
                if (!(zzbtVar instanceof zzon)) {
                    strZze = "(unknown)";
                } else {
                    strZze = ((zzon) zzbtVar).zza(zzdd.zza()).zze();
                }
                throw new GeneralSecurityException("Key parsing of key with index " + i + " and type_url " + strZze + " failed, unable to get primitive");
            }
        }
        return (P) zzbqVar.zza(zze(), cls);
    }

    public final String toString() {
        return zzdf.zza(zzd()).toString();
    }

    private static List<zzcd> zzb(zzxq zzxqVar, zzbq zzbqVar) throws GeneralSecurityException {
        zzbt zzonVar;
        boolean z;
        ArrayList arrayList = new ArrayList(zzxqVar.zza());
        for (zzxq.zza zzaVar : zzxqVar.zze()) {
            int iZza = zzaVar.zza();
            try {
                zzct zzctVarZza = zza(zzaVar);
                zzcy zzcyVar = (zzcy) zzbqVar.zza(zzcy.class);
                if (zzcyVar == null) {
                    throw new GeneralSecurityException("Passed in configuration cannot be used to serialize into proto keyset format.");
                }
                zzonVar = zzcyVar.zza(zzctVarZza, zzdd.zza());
                z = false;
            } catch (GeneralSecurityException e) {
                if (zza(zzbqVar)) {
                    throw e;
                }
                zzonVar = new zzon(zza(zzaVar), zzdd.zza());
                z = true;
            }
            if (zza(zzbqVar) && !zza(zzaVar.zzc())) {
                throw new GeneralSecurityException("Parsing of a single key failed (wrong status) and Tink is configured via validateKeysetsOnParsing to reject such keysets.");
            }
            arrayList.add(new zzcd(zzonVar, zzaVar.zzc(), iZza, iZza == zzxqVar.zzb(), z, zzcd.zza));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private zzbx(List<zzcd> list, Map<Class<?>, zzbl> map) throws GeneralSecurityException {
        this.zza = list;
        this.zzb = map;
        this.zzc = null;
    }

    private zzbx(List<zzcd> list, Map<Class<?>, zzbl> map, zzbx zzbxVar) {
        this.zza = list;
        this.zzb = map;
        this.zzc = zzbxVar;
    }

    private static void zza(zzxq zzxqVar) throws GeneralSecurityException {
        if (zzxqVar == null || zzxqVar.zza() <= 0) {
            throw new GeneralSecurityException("empty keyset");
        }
    }

    private static void zza(zzbt zzbtVar, int i) throws GeneralSecurityException {
        Integer numZzb = zzbtVar.zzb();
        if (numZzb != null && numZzb.intValue() != i) {
            throw new GeneralSecurityException("Wrong ID set for key with ID requirement");
        }
    }

    @Deprecated
    public final void zza(zzcl zzclVar) throws GeneralSecurityException, IOException {
        zzxq zzxqVarZzd = zzd();
        for (zzxq.zza zzaVar : zzxqVarZzd.zze()) {
            if (zzaVar.zzb().zzb() == zzxg.zza.UNKNOWN_KEYMATERIAL || zzaVar.zzb().zzb() == zzxg.zza.SYMMETRIC || zzaVar.zzb().zzb() == zzxg.zza.ASYMMETRIC_PRIVATE) {
                throw new GeneralSecurityException(String.format("keyset contains key material of type %s for type url %s", zzaVar.zzb().zzb().name(), zzaVar.zzb().zzf()));
            }
        }
        zzclVar.zza(zzxqVarZzd);
    }

    @Deprecated
    public final void zza(zzcl zzclVar, zzbm zzbmVar, byte[] bArr) throws GeneralSecurityException, IOException {
        zzxq zzxqVarZzd = zzd();
        zzclVar.zza((zzwe) ((zzalt) zzwe.zza().zza(zzakb.zza(zzbmVar.zzb(zzxqVarZzd.zzk(), bArr))).zza(zzdf.zza(zzxqVarZzd)).zze()));
    }

    private static boolean zza(zzxh zzxhVar) {
        int i = zzbz.zza[zzxhVar.ordinal()];
        return i == 1 || i == 2 || i == 3;
    }

    private static boolean zza(zzbq zzbqVar) {
        return zzbqVar.zza(zzqp.class) == null;
    }
}
