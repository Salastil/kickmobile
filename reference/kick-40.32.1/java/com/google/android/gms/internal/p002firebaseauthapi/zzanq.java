package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [FieldDescriptorT] */
/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzanq<FieldDescriptorT> extends zzann<FieldDescriptorT, Object> {
    zzanq() {
        super();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzann
    public final void zzc() {
        if (!zzd()) {
            for (int i = 0; i < zza(); i++) {
                Map.Entry<FieldDescriptorT, Object> entryZza = zza(i);
                if (((zzalo) entryZza.getKey()).zze()) {
                    entryZza.setValue(Collections.unmodifiableList((List) entryZza.getValue()));
                }
            }
            for (Map.Entry<FieldDescriptorT, Object> entry : zzb()) {
                if (((zzalo) entry.getKey()).zze()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zzc();
    }
}
