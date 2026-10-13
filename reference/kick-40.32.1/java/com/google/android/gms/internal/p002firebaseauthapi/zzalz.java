package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzalz<K> implements Map.Entry<K, Object> {
    private final Map.Entry<K, zzama> zza;

    public final zzama zza() {
        return this.zza.getValue();
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.zza.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        zzama value = this.zza.getValue();
        if (value == null) {
            return null;
        }
        return value.zzc();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (!(obj instanceof zzamv)) {
            throw new IllegalArgumentException("Lazy field only supports MessageLite values.");
        }
        zzamv zzamvVar = this.zza.getValue().zza;
        this.zza.setValue(new zzama((zzamv) obj));
        return zzamvVar;
    }

    private zzalz(Map.Entry<K, zzama> entry) {
        this.zza = entry;
    }
}
