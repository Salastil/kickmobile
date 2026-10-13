package com.google.android.gms.internal.pal;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzwe implements zzwf {
    private final List zza;
    private final Map zzb;

    private zzwe(List list, Map map) throws GeneralSecurityException {
        this.zza = list;
        this.zzb = map;
        if (zzacm.zza.zza()) {
            HashSet hashSet = new HashSet();
            Iterator it = list.iterator();
            boolean zZzd = false;
            while (it.hasNext()) {
                zzwd zzwdVar = (zzwd) it.next();
                if (hashSet.contains(Integer.valueOf(zzwdVar.zzc()))) {
                    int iZzc = zzwdVar.zzc();
                    StringBuilder sb = new StringBuilder(String.valueOf(iZzc).length() + 121);
                    sb.append("KeyID ");
                    sb.append(iZzc);
                    sb.append(" is duplicated in the keyset, and Tink is configured to reject such keysets with the flag validateKeysetsOnParsing.");
                    throw new GeneralSecurityException(sb.toString());
                }
                hashSet.add(Integer.valueOf(zzwdVar.zzc()));
                zZzd |= zzwdVar.zzd();
            }
            if (!zZzd) {
                throw new GeneralSecurityException("Primary key id not found in keyset, and Tink is configured to reject such keysets with the flag validateKeysetsOnParsing.");
            }
        }
    }

    @Deprecated
    public static final zzwe zzf(zzwg zzwgVar) throws GeneralSecurityException, IOException {
        String str;
        try {
            try {
                zzaoz zzaozVarZze = zzaoz.zze(zzwgVar.zzb().zzaq(), zzaty.zza());
                for (zzaoy zzaoyVar : zzaozVarZze.zzb()) {
                    if (zzaoyVar.zzb().zzh() == 2 || zzaoyVar.zzb().zzh() == 3 || zzaoyVar.zzb().zzh() == 4) {
                        int iZzh = zzaoyVar.zzb().zzh();
                        if (iZzh == 2) {
                            str = "UNKNOWN_KEYMATERIAL";
                        } else if (iZzh == 3) {
                            str = "SYMMETRIC";
                        } else if (iZzh == 4) {
                            str = "ASYMMETRIC_PRIVATE";
                        } else if (iZzh != 5) {
                            str = iZzh != 6 ? "UNRECOGNIZED" : "REMOTE";
                        } else {
                            str = "ASYMMETRIC_PUBLIC";
                        }
                        throw new GeneralSecurityException(String.format("keyset contains key material of type %s for type url %s", str, zzaoyVar.zzb().zza()));
                    }
                }
                if (zzaozVarZze == null || zzaozVarZze.zzc() <= 0) {
                    throw new GeneralSecurityException("empty keyset");
                }
                return new zzwe(zzh(zzaozVarZze), new HashMap());
            } catch (zzavb unused) {
                throw new GeneralSecurityException("invalid keyset");
            }
        } catch (zzavb unused2) {
            throw new GeneralSecurityException("invalid keyset");
        }
    }

    private static List zzh(zzaoz zzaozVar) throws GeneralSecurityException {
        zzvz zzahtVar;
        boolean z;
        ArrayList arrayList = new ArrayList(zzaozVar.zzc());
        for (zzaoy zzaoyVar : zzaozVar.zzb()) {
            int iZzc = zzaoyVar.zzc();
            try {
                zzaje zzajeVarZzi = zzi(zzaoyVar);
                zzail zzailVarZza = zzail.zza();
                zzwm zzwmVarZza = zzwm.zza();
                zzahtVar = !zzailVarZza.zzf(zzajeVarZzi) ? new zzaht(zzajeVarZzi, zzwmVarZza) : zzailVarZza.zzg(zzajeVarZzi, zzwmVarZza);
                z = false;
            } catch (GeneralSecurityException e) {
                if (zzacm.zza.zza()) {
                    throw e;
                }
                zzahtVar = new zzaht(zzi(zzaoyVar), zzwm.zza());
                z = true;
            }
            if (zzacm.zza.zza() && !zzj(zzaoyVar.zzj())) {
                throw new GeneralSecurityException("Parsing of a single key failed (wrong status) and Tink is configured via validateKeysetsOnParsing to reject such keysets.");
            }
            boolean z2 = false;
            int iZzj = zzaoyVar.zzj();
            if (iZzc == zzaozVar.zza()) {
                z2 = true;
            }
            arrayList.add(new zzwd(zzahtVar, iZzj, iZzc, z2, z, zzwd.zzf, null));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static zzaje zzi(zzaoy zzaoyVar) throws GeneralSecurityException {
        return zzaje.zzf(zzaoyVar.zzb().zza(), zzaoyVar.zzb().zzb(), zzaoyVar.zzb().zzh(), zzaoyVar.zzd(), zzaoyVar.zzd() == zzapm.RAW ? null : Integer.valueOf(zzaoyVar.zzc()));
    }

    private static boolean zzj(int i) {
        int i2 = i - 2;
        return i2 == 1 || i2 == 2 || i2 == 3;
    }

    public final String toString() {
        zzaoz zzaozVarZza = zza();
        int i = zzwo.zza;
        zzapa zzapaVarZza = zzapd.zza();
        zzapaVarZza.zza(zzaozVarZza.zza());
        for (zzaoy zzaoyVar : zzaozVarZza.zzb()) {
            zzapb zzapbVarZza = zzapc.zza();
            zzapbVarZza.zza(zzaoyVar.zzb().zza());
            zzapbVarZza.zzd(zzaoyVar.zzj());
            zzapbVarZza.zzc(zzaoyVar.zzd());
            zzapbVarZza.zzb(zzaoyVar.zzc());
            zzapaVarZza.zzb((zzapc) zzapbVarZza.zzal());
        }
        return ((zzapd) zzapaVarZza.zzal()).toString();
    }

    final zzaoz zza() {
        try {
            zzaow zzaowVarZzf = zzaoz.zzf();
            for (zzwd zzwdVar : this.zza) {
                zzvz zzvzVarZza = zzwdVar.zza();
                int iZzg = zzwdVar.zzg();
                int iZzc = zzwdVar.zzc();
                zzaje zzajeVar = (zzaje) zzail.zza().zzh(zzvzVarZza, zzaje.class, zzwm.zza());
                Integer numZzb = zzvzVarZza.zzb();
                if (numZzb != null && numZzb.intValue() != iZzc) {
                    throw new GeneralSecurityException("Wrong ID set for key with ID requirement");
                }
                zzaox zzaoxVarZze = zzaoy.zze();
                zzaop zzaopVarZzc = zzaoq.zzc();
                zzaopVarZzc.zza(zzajeVar.zze());
                zzaopVarZzc.zzb(zzajeVar.zza());
                zzaopVarZzc.zzc(zzajeVar.zzg());
                zzaoxVarZze.zzb(zzaopVarZzc);
                zzaoxVarZze.zze(iZzg);
                zzaoxVarZze.zzc(iZzc);
                zzaoxVarZze.zzd(zzajeVar.zzb());
                zzaowVarZzf.zzb((zzaoy) zzaoxVarZze.zzal());
                if (zzwdVar.zzd()) {
                    zzaowVarZzf.zza(zzwdVar.zzc());
                }
            }
            return (zzaoz) zzaowVarZzf.zzal();
        } catch (GeneralSecurityException e) {
            throw new zzajo(e);
        }
    }

    public final zzwd zzb() {
        for (zzwd zzwdVar : this.zza) {
            if (zzwdVar != null && zzwdVar.zzd()) {
                if (zzwdVar.zzb() == zzwb.zza) {
                    return zzwdVar;
                }
                throw new IllegalStateException("Keyset has primary which isn't enabled");
            }
        }
        throw new IllegalStateException("Keyset has no valid primary");
    }

    @Override // com.google.android.gms.internal.pal.zzwf
    public final int zzc() {
        return this.zza.size();
    }

    public final zzwd zzd(int i) {
        if (i < 0 || i >= zzc()) {
            int iZzc = zzc();
            StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 34 + String.valueOf(iZzc).length());
            sb.append("Invalid index ");
            sb.append(i);
            sb.append(" for keyset of size ");
            sb.append(iZzc);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        List list = this.zza;
        zzwd zzwdVar = (zzwd) list.get(i);
        if (!zzj(zzwdVar.zzg())) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(i).length() + 42);
            sb2.append("Keyset-Entry at position ");
            sb2.append(i);
            sb2.append(" has wrong status");
            throw new IllegalStateException(sb2.toString());
        }
        if (!zzwdVar.zze()) {
            return (zzwd) list.get(i);
        }
        StringBuilder sb3 = new StringBuilder(String.valueOf(i).length() + 48);
        sb3.append("Keyset-Entry at position ");
        sb3.append(i);
        sb3.append(" didn't parse correctly");
        throw new IllegalStateException(sb3.toString());
    }

    @Override // com.google.android.gms.internal.pal.zzwf
    @Nullable
    public final zzvs zze(Class cls) {
        return (zzvs) this.zzb.get(cls);
    }

    public final Object zzg(zzvt zzvtVar, Class cls) throws GeneralSecurityException {
        if (!(zzvtVar instanceof zzahe)) {
            throw new GeneralSecurityException("Currently only subclasses of InternalConfiguration are accepted");
        }
        zzahe zzaheVar = (zzahe) zzvtVar;
        zzaoz zzaozVarZza = zza();
        int i = zzwo.zza;
        int iZza = zzaozVarZza.zza();
        boolean z = true;
        int i2 = 0;
        boolean z2 = false;
        for (zzaoy zzaoyVar : zzaozVarZza.zzb()) {
            if (zzaoyVar.zzj() == 3) {
                if (!zzaoyVar.zza()) {
                    throw new GeneralSecurityException(String.format("key %d has no key data", Integer.valueOf(zzaoyVar.zzc())));
                }
                if (zzaoyVar.zzd() == zzapm.UNKNOWN_PREFIX) {
                    throw new GeneralSecurityException(String.format("key %d has unknown prefix", Integer.valueOf(zzaoyVar.zzc())));
                }
                if (zzaoyVar.zzj() == 2) {
                    throw new GeneralSecurityException(String.format("key %d has unknown status", Integer.valueOf(zzaoyVar.zzc())));
                }
                if (zzaoyVar.zzc() == iZza) {
                    if (z2) {
                        throw new GeneralSecurityException("keyset contains multiple primary keys");
                    }
                    z2 = true;
                }
                z &= zzaoyVar.zzb().zzh() == 5;
                i2++;
            }
        }
        if (i2 == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        }
        if (!z2 && !z) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
        for (int i3 = 0; i3 < zzc(); i3++) {
            List list = this.zza;
            if (((zzwd) list.get(i3)).zze() || !zzj(((zzwd) list.get(i3)).zzg())) {
                String strZza = zzaozVarZza.zzd(i3).zzb().zza();
                StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 44 + String.valueOf(strZza).length() + 32);
                sb.append("Key parsing of key with index ");
                sb.append(i3);
                sb.append(" and type_url ");
                sb.append(strZza);
                sb.append(" failed, unable to get primitive");
                throw new GeneralSecurityException(sb.toString());
            }
        }
        return zzaheVar.zza(this, cls);
    }
}
