package com.google.android.gms.internal.pal;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public class zzarv {
    @Deprecated
    public zzarv() {
    }

    public final String toString() {
        try {
            StringBuilder sb = new StringBuilder();
            zzasu zzasuVar = new zzasu(zzasp.zza(sb));
            zzasuVar.zza(zzasa.LENIENT);
            zzasq.zza.zza(zzasuVar, this);
            return sb.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public String zzd() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public final zzarx zze() {
        if (this instanceof zzarx) {
            return (zzarx) this;
        }
        throw new IllegalStateException("Not a JSON Object: ".concat(toString()));
    }

    public final zzaru zzf() {
        if (this instanceof zzaru) {
            return (zzaru) this;
        }
        throw new IllegalStateException("Not a JSON Array: ".concat(toString()));
    }

    public final zzarz zzg() {
        if (this instanceof zzarz) {
            return (zzarz) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: ".concat(toString()));
    }
}
