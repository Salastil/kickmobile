package com.google.android.gms.internal.measurement;

import android.text.TextUtils;
import com.google.common.collect.ImmutableList;
import java.util.UUID;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzww {
    zzww() {
    }

    public final String toString() {
        return TextUtils.join(" -> ", zza());
    }

    public abstract ImmutableList zza();

    public abstract ImmutableList zzb();

    public abstract UUID zzc();

    public abstract long zzd();
}
