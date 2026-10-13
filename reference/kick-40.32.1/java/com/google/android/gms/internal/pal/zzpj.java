package com.google.android.gms.internal.pal;

import java.util.Iterator;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzpj extends zzpz {
    zzpj(String str, Class cls, boolean z) {
        super("group_by", cls, true);
    }

    @Override // com.google.android.gms.internal.pal.zzpz
    public final void zza(Iterator it, zzpy zzpyVar) {
        if (it.hasNext()) {
            Object next = it.next();
            if (!it.hasNext()) {
                zzpyVar.zza(zzd(), next);
                return;
            }
            StringBuilder sb = new StringBuilder("[");
            sb.append(next);
            do {
                sb.append(AbstractJsonLexerKt.COMMA);
                sb.append(it.next());
            } while (it.hasNext());
            String strZzd = zzd();
            sb.append(AbstractJsonLexerKt.END_LIST);
            zzpyVar.zza(strZzd, sb.toString());
        }
    }
}
