package com.google.android.gms.internal.play_billing;

import java.util.Map;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzgw implements Map.Entry {
    private final Map.Entry zza;

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.zza.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        zzgz zzgzVar = (zzgz) this.zza.getValue();
        if (zzgzVar == null) {
            return null;
        }
        return zzgzVar.zzc();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (!(obj instanceof zzhr)) {
            throw new IllegalArgumentException("Lazy field only supports MessageLite values.");
        }
        Map.Entry entry = this.zza;
        zzhr zzhrVar = ((zzgz) entry.getValue()).zza;
        entry.setValue(new zzgz((zzhr) obj));
        return zzhrVar;
    }

    public final zzgz zza() {
        return (zzgz) this.zza.getValue();
    }
}
