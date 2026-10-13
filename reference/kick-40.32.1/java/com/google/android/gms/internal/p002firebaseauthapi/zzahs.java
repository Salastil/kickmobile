package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzahs {
    private List<zzaht> zza;

    public final List<zzaht> zza() {
        return this.zza;
    }

    public zzahs() {
        this.zza = new ArrayList();
    }

    public zzahs(List<zzaht> list) {
        this.zza = Collections.unmodifiableList(list);
    }
}
