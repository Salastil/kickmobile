package com.google.android.gms.internal.play_billing;

import java.util.Arrays;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzbh {
    private final String zza;
    private final zzbg zzb;
    private zzbg zzc;

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.zza);
        sb.append(AbstractJsonLexerKt.BEGIN_OBJ);
        zzbg zzbgVar = this.zzb.zzb;
        String str = "";
        while (zzbgVar != null) {
            Object obj = zzbgVar.zza;
            sb.append(str);
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                String strDeepToString = Arrays.deepToString(new Object[]{obj});
                sb.append((CharSequence) strDeepToString, 1, strDeepToString.length() - 1);
            }
            zzbgVar = zzbgVar.zzb;
            str = ", ";
        }
        sb.append(AbstractJsonLexerKt.END_OBJ);
        return sb.toString();
    }

    public final zzbh zza(Object obj) {
        zzbg zzbgVar = new zzbg();
        this.zzc.zzb = zzbgVar;
        this.zzc = zzbgVar;
        zzbgVar.zza = obj;
        return this;
    }

    /* synthetic */ zzbh(String str, zzbi zzbiVar) {
        zzbg zzbgVar = new zzbg();
        this.zzb = zzbgVar;
        this.zzc = zzbgVar;
        str.getClass();
        this.zza = str;
    }
}
