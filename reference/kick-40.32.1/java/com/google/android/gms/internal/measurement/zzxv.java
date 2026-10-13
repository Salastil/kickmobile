package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzxv extends zzyl {
    zzxv(String str, Class cls, boolean z) {
        super("group_by", cls, true);
    }

    @Override // com.google.android.gms.internal.measurement.zzyl
    public final void zza(Iterator it, zzyk zzykVar) {
        if (it.hasNext()) {
            Object next = it.next();
            if (!it.hasNext()) {
                zzykVar.zza(zzd(), next);
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
            zzykVar.zza(strZzd, sb.toString());
        }
    }
}
