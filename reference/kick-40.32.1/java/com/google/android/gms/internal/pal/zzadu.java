package com.google.android.gms.internal.pal;

import androidx.media3.muxer.WebmConstants;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzadu {
    private zzadv zza = null;
    private zzadx zzb = null;
    private zzady zzc = null;
    private zzwk zzd = null;
    private zzadz zze = zzadz.zzc;

    @Nullable
    private zzarq zzf = null;

    private zzadu() {
    }

    /* synthetic */ zzadu(byte[] bArr) {
    }

    public final zzadu zza(zzadv zzadvVar) {
        this.zza = zzadvVar;
        return this;
    }

    public final zzadu zzb(zzadx zzadxVar) {
        this.zzb = zzadxVar;
        return this;
    }

    public final zzadu zzc(zzady zzadyVar) {
        this.zzc = zzadyVar;
        return this;
    }

    public final zzadu zzd(zzwk zzwkVar) throws GeneralSecurityException {
        if (zzaea.zzb.contains(zzwkVar)) {
            this.zzd = zzwkVar;
            return this;
        }
        String string = zzwkVar.toString();
        StringBuilder sb = new StringBuilder(string.length() + WebmConstants.MkvEbmlElement.CUE_TRACK_POSITIONS);
        sb.append("Invalid DEM parameters ");
        sb.append(string);
        sb.append("; only AES128_GCM_RAW, AES256_GCM_RAW, AES128_CTR_HMAC_SHA256_RAW, AES256_CTR_HMAC_SHA256_RAW XCHACHA20_POLY1305_RAW and AES256_SIV_RAW are currently supported.");
        throw new GeneralSecurityException(sb.toString());
    }

    public final zzadu zze(zzadz zzadzVar) {
        this.zze = zzadzVar;
        return this;
    }

    public final zzadu zzf(zzarq zzarqVar) {
        if (zzarqVar.zzc() == 0) {
            zzarqVar = null;
        }
        this.zzf = zzarqVar;
        return this;
    }

    public final zzaea zzg() throws GeneralSecurityException {
        zzadv zzadvVar = this.zza;
        if (zzadvVar == null) {
            throw new GeneralSecurityException("Elliptic curve type is not set");
        }
        if (this.zzb == null) {
            throw new GeneralSecurityException("Hash type is not set");
        }
        if (this.zzd == null) {
            throw new GeneralSecurityException("DEM parameters are not set");
        }
        if (this.zze == null) {
            throw new GeneralSecurityException("Variant is not set");
        }
        zzadv zzadvVar2 = zzadv.zzd;
        if (zzadvVar != zzadvVar2 && this.zzc == null) {
            throw new GeneralSecurityException("Point format is not set");
        }
        if (zzadvVar != zzadvVar2 || this.zzc == null) {
            return new zzaea(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, null);
        }
        throw new GeneralSecurityException("For Curve25519 point format must not be set");
    }
}
