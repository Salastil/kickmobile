package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaic {
    public static long zza(String str) {
        zzaif zzaifVarZzb = zzb(str);
        return zzaifVarZzb.zza().longValue() - zzaifVarZzb.zzb().longValue();
    }

    private static zzaif zzb(String str) {
        Preconditions.checkNotEmpty(str);
        List<String> listZza = zzt.zza(FilenameUtils.EXTENSION_SEPARATOR).zza((CharSequence) str);
        if (listZza.size() < 2) {
            throw new RuntimeException("Invalid idToken " + str);
        }
        try {
            return zzaif.zza(new String(Base64Utils.decodeUrlSafeNoPadding(listZza.get(1)), StandardCharsets.UTF_8));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Unable to decode token", e);
        }
    }
}
