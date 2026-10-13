package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzbt;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzoh<KeyT extends zzbt> {
    private final Class<KeyT> zza;

    public static <KeyT extends zzbt> zzoh<KeyT> zza(zzoj<KeyT> zzojVar, Class<KeyT> cls) {
        return new zzok(cls, zzojVar);
    }

    public abstract zzct zza(KeyT keyt, @Nullable zzdd zzddVar) throws GeneralSecurityException;

    public final Class<KeyT> zza() {
        return this.zza;
    }

    private zzoh(Class<KeyT> cls) {
        this.zza = cls;
    }
}
