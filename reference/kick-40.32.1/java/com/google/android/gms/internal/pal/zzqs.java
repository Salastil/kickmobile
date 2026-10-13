package com.google.android.gms.internal.pal;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzqs {
    public static /* synthetic */ boolean zza(int i, zzpq zzpqVar, StringBuilder sb) {
        if (i - 1 != 0 || zzpqVar == zzpq.zza) {
            return false;
        }
        sb.append(zzpqVar.zza());
        sb.append(FilenameUtils.EXTENSION_SEPARATOR);
        sb.append(zzpqVar.zzb());
        sb.append(AbstractJsonLexerKt.COLON);
        sb.append(zzpqVar.zzc());
        return true;
    }
}
