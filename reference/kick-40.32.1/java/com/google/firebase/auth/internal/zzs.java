package com.google.firebase.auth.internal;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.internal.p002firebaseauthapi.zzcl;
import com.google.android.gms.internal.p002firebaseauthapi.zzjj;
import com.google.android.gms.internal.p002firebaseauthapi.zzld;
import com.google.android.gms.internal.p002firebaseauthapi.zzlk;
import com.google.android.gms.internal.p002firebaseauthapi.zznl;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzs {
    private static zzs zza;
    private final String zzb;
    private final zznl zzc;

    public static zzs zza(Context context, String str) {
        zzs zzsVar = zza;
        if (zzsVar == null || !Objects.equals(zzsVar.zzb, str)) {
            zza = new zzs(context, str, true);
        }
        return zza;
    }

    public final String zza(String str) {
        String str2;
        zznl zznlVar = this.zzc;
        if (zznlVar == null) {
            Log.e("FirebearCryptoHelper", "KeysetManager failed to initialize - unable to decrypt payload");
            return null;
        }
        try {
            synchronized (zznlVar) {
                str2 = new String(((com.google.android.gms.internal.p002firebaseauthapi.zzbs) this.zzc.zza().zza(zzjj.zza(), com.google.android.gms.internal.p002firebaseauthapi.zzbs.class)).zza(Base64.decode(str, 8), null), StandardCharsets.UTF_8);
            }
            return str2;
        } catch (GeneralSecurityException e) {
            Log.e("FirebearCryptoHelper", "Exception encountered while decrypting bytes:\n" + e.getMessage());
            return null;
        }
    }

    public final String zza() {
        if (this.zzc == null) {
            Log.e("FirebearCryptoHelper", "KeysetManager failed to initialize - unable to get Public key");
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        zzcl zzclVarZza = com.google.android.gms.internal.p002firebaseauthapi.zzbn.zza(byteArrayOutputStream);
        try {
            synchronized (this.zzc) {
                this.zzc.zza().zzb().zza(zzclVarZza);
            }
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 8);
        } catch (IOException | GeneralSecurityException e) {
            Log.e("FirebearCryptoHelper", "Exception encountered when attempting to get Public Key:\n" + e.getMessage());
            return null;
        }
    }

    private zzs(Context context, String str, boolean z) {
        zznl zznlVarZza;
        this.zzb = str;
        try {
            zzld.zza();
            zznl.zza zzaVarZza = new zznl.zza().zza(context, "GenericIdpKeyset", String.format("com.google.firebase.auth.api.crypto.%s", str)).zza(zzlk.zza);
            zzaVarZza.zza(String.format("android-keystore://firebear_master_key_id.%s", str));
            zznlVarZza = zzaVarZza.zza();
        } catch (IOException | GeneralSecurityException e) {
            Log.e("FirebearCryptoHelper", "Exception encountered during crypto setup:\n" + e.getMessage());
            zznlVarZza = null;
        }
        this.zzc = zznlVarZza;
    }
}
