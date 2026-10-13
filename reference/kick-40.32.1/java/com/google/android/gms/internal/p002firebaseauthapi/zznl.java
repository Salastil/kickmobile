package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import com.google.crypto.tink.integration.android.AndroidKeystoreKmsClient;
import java.io.CharConversionException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.security.ProviderException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zznl {
    private static final Object zza = new Object();
    private static final String zzb = "zznl";
    private zzcj zzc;

    static /* synthetic */ boolean zzd() {
        return true;
    }

    public final synchronized zzbx zza() throws GeneralSecurityException {
        return this.zzc.zza();
    }

    static /* synthetic */ void zza(zzbx zzbxVar, zzcl zzclVar, zzbm zzbmVar) throws GeneralSecurityException {
        try {
            if (zzbmVar != null) {
                zzbxVar.zza(zzclVar, zzbmVar, new byte[0]);
            } else {
                zzcq.zza(zzbxVar, zzclVar, zzbu.zza());
            }
        } catch (IOException e) {
            throw new GeneralSecurityException(e);
        }
    }

    private zznl(zza zzaVar) {
        new zzns(zzaVar.zza, zzaVar.zzb, zzaVar.zzc);
        this.zzc = zzaVar.zzi;
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    public static final class zza {
        private Context zza = null;
        private String zzb = null;
        private String zzc = null;
        private String zzd = null;
        private zzbm zze = null;
        private boolean zzf = true;
        private zzby zzg = null;
        private zzxk zzh = null;
        private zzcj zzi;

        private final zzbm zzb() throws GeneralSecurityException {
            zznl.zzd();
            zznq zznqVar = new zznq();
            try {
                boolean zZzc = zznq.zzc(this.zzd);
                try {
                    return zznqVar.zza(this.zzd);
                } catch (GeneralSecurityException | ProviderException e) {
                    if (!zZzc) {
                        throw new KeyStoreException(String.format("the master key %s exists but is unusable", this.zzd), e);
                    }
                    Log.w(zznl.zzb, "cannot use Android Keystore, it'll be disabled", e);
                    return null;
                }
            } catch (GeneralSecurityException | ProviderException e2) {
                Log.w(zznl.zzb, "cannot use Android Keystore, it'll be disabled", e2);
                return null;
            }
        }

        private static zzcj zza(byte[] bArr) throws GeneralSecurityException, IOException {
            return zzcj.zza(zzcq.zza(zzbo.zza(bArr), zzbu.zza()));
        }

        private final zzcj zzb(byte[] bArr) throws GeneralSecurityException, IOException {
            try {
                this.zze = new zznq().zza(this.zzd);
                try {
                    return zzcj.zza(zzbx.zza(zzbo.zza(bArr), this.zze, new byte[0]));
                } catch (IOException | GeneralSecurityException e) {
                    try {
                        return zza(bArr);
                    } catch (IOException unused) {
                        throw e;
                    }
                }
            } catch (GeneralSecurityException | ProviderException e2) {
                try {
                    zzcj zzcjVarZza = zza(bArr);
                    Log.w(zznl.zzb, "cannot use Android Keystore, it'll be disabled", e2);
                    return zzcjVarZza;
                } catch (IOException unused2) {
                    throw e2;
                }
            }
        }

        public final zza zza(zzxk zzxkVar) {
            this.zzh = zzxkVar;
            return this;
        }

        public final zza zza(String str) {
            if (!str.startsWith(AndroidKeystoreKmsClient.PREFIX)) {
                throw new IllegalArgumentException("key URI must start with android-keystore://");
            }
            if (!this.zzf) {
                throw new IllegalArgumentException("cannot call withMasterKeyUri() after calling doNotUseKeystore()");
            }
            this.zzd = str;
            return this;
        }

        public final zza zza(Context context, String str, String str2) throws IOException {
            if (context == null) {
                throw new IllegalArgumentException("need an Android context");
            }
            this.zza = context;
            this.zzb = str;
            this.zzc = str2;
            return this;
        }

        public final synchronized zznl zza() throws GeneralSecurityException, IOException {
            zznl zznlVar;
            if (this.zzb == null) {
                throw new IllegalArgumentException("keysetName cannot be null");
            }
            zzxk zzxkVar = this.zzh;
            if (zzxkVar != null && this.zzg == null) {
                this.zzg = zzby.zza(zzdg.zza(zzxkVar.zzk()));
            }
            synchronized (zznl.zza) {
                byte[] bArrZzb = zzb(this.zza, this.zzb, this.zzc);
                String str = this.zzd;
                if (bArrZzb == null) {
                    if (str != null) {
                        this.zze = zzb();
                    }
                    zzby zzbyVar = this.zzg;
                    if (zzbyVar == null) {
                        throw new GeneralSecurityException("cannot read or generate keyset");
                    }
                    zzbx zzbxVarZza = zzbx.zza(zzbyVar);
                    zznl.zza(zzbxVarZza, new zzns(this.zza, this.zzb, this.zzc), this.zze);
                    this.zzi = zzcj.zza(zzbxVarZza);
                } else if (str != null) {
                    zznl.zzd();
                    this.zzi = zzb(bArrZzb);
                } else {
                    this.zzi = zza(bArrZzb);
                }
                zznlVar = new zznl(this);
            }
            return zznlVar;
        }

        private static byte[] zzb(Context context, String str, String str2) throws IOException {
            SharedPreferences sharedPreferences;
            if (str == null) {
                throw new IllegalArgumentException("keysetName cannot be null");
            }
            Context applicationContext = context.getApplicationContext();
            if (str2 == null) {
                sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
            } else {
                sharedPreferences = applicationContext.getSharedPreferences(str2, 0);
            }
            try {
                String string = sharedPreferences.getString(str, null);
                if (string == null) {
                    return null;
                }
                return zzaaf.zza(string);
            } catch (ClassCastException | IllegalArgumentException unused) {
                throw new CharConversionException(String.format("can't read keyset; the pref value %s is not a valid hex string", str));
            }
        }
    }
}
