package com.google.android.gms.internal.measurement;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzze {
    public static /* synthetic */ boolean zza(int i, zzyc zzycVar, StringBuilder sb) {
        if (i - 1 != 0 || zzycVar == zzyc.zza) {
            return false;
        }
        sb.append(zzycVar.zza());
        sb.append(FilenameUtils.EXTENSION_SEPARATOR);
        sb.append(zzycVar.zzb());
        sb.append(AbstractJsonLexerKt.COLON);
        sb.append(zzycVar.zzc());
        return true;
    }
}
