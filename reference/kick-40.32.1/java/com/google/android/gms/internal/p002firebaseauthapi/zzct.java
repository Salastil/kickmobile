package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzct {
    private final String zza;
    private final zzakb zzb;
    private final zzcw zzc;
    private final zzcv zzd;

    @Nullable
    private final Integer zze;

    public final zzcw zza() {
        return this.zzc;
    }

    public final zzcv zzb() {
        return this.zzd;
    }

    public static zzct zza(String str, zzakb zzakbVar, zzcw zzcwVar, zzcv zzcvVar, @Nullable Integer num) throws GeneralSecurityException {
        if (num != null && zzcvVar.equals(zzcv.zzd)) {
            throw new GeneralSecurityException("Cannot set idRequirement for OutputPrefixType RAW");
        }
        if (num == null && !zzcvVar.equals(zzcv.zzd)) {
            throw new GeneralSecurityException("Cannot have null idRequirement unless OutputPrefixType is RAW");
        }
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt < '!' || cCharAt > '~') {
                throw new GeneralSecurityException("typeURL " + str + " contains non-ascii character at position " + i);
            }
        }
        return new zzct(str, zzakbVar, zzcwVar, zzcvVar, num);
    }

    public final zzakb zzc() {
        return this.zzb;
    }

    @Nullable
    public final Integer zzd() {
        return this.zze;
    }

    public final String zze() {
        return this.zza;
    }

    private zzct(String str, zzakb zzakbVar, zzcw zzcwVar, zzcv zzcvVar, @Nullable Integer num) {
        this.zza = str;
        this.zzb = zzakbVar;
        this.zzc = zzcwVar;
        this.zzd = zzcvVar;
        this.zze = num;
    }
}
