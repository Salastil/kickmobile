package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.util.Strings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzajf {
    private List<String> zza;

    public static zzajf zza() {
        return new zzajf(null);
    }

    public final List<String> zzb() {
        return this.zza;
    }

    public zzajf() {
        this(null);
    }

    private zzajf(List<String> list) {
        this.zza = new ArrayList();
    }

    public zzajf(int i, List<String> list) {
        if (list == null || list.isEmpty()) {
            this.zza = Collections.EMPTY_LIST;
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            list.set(i2, Strings.emptyToNull(list.get(i2)));
        }
        this.zza = Collections.unmodifiableList(list);
    }
}
