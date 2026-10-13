package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzoq implements zzbl {
    private final Map<String, String> zza;

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
    public static final class zza {
        private HashMap<String, String> zza = new HashMap<>();

        public final zzoq zza() {
            if (this.zza == null) {
                throw new IllegalStateException("cannot call build() twice");
            }
            zzoq zzoqVar = new zzoq(Collections.unmodifiableMap(this.zza));
            this.zza = null;
            return zzoqVar;
        }
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        return this.zza.toString();
    }

    static {
        new zza().zza();
    }

    private zzoq(Map<String, String> map) {
        this.zza = map;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzoq) {
            return this.zza.equals(((zzoq) obj).zza);
        }
        return false;
    }

    public final boolean zza() {
        return this.zza.isEmpty();
    }
}
