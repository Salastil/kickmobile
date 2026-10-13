package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzzx;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzzr<T_WRAPPER extends zzzx<JcePrimitiveT>, JcePrimitiveT> {
    public static final zzzr<zzaaa, Cipher> zza = new zzzr<>(new zzaaa());
    public static final zzzr<zzaae, Mac> zzb = new zzzr<>(new zzaae());
    public static final zzzr<zzzz, KeyAgreement> zzc;
    public static final zzzr<zzaab, KeyPairGenerator> zzd;
    public static final zzzr<zzaac, KeyFactory> zze;
    private final zzzv<JcePrimitiveT> zzf;

    public final JcePrimitiveT zza(String str) throws GeneralSecurityException {
        return this.zzf.zza(str);
    }

    public static List<Provider> zza(String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            Provider provider = Security.getProvider(str);
            if (provider != null) {
                arrayList.add(provider);
            }
        }
        return arrayList;
    }

    static {
        new zzzr(new zzaag());
        new zzzr(new zzaad());
        zzc = new zzzr<>(new zzzz());
        zzd = new zzzr<>(new zzaab());
        zze = new zzzr<>(new zzaac());
    }

    private zzzr(T_WRAPPER t_wrapper) {
        if (zzjd.zzb()) {
            this.zzf = new zzzw(t_wrapper);
        } else if (zzaaq.zza()) {
            this.zzf = new zzzu(t_wrapper);
        } else {
            this.zzf = new zzzt(t_wrapper);
        }
    }
}
