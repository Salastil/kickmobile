package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.framework.devicesuggestions.DeviceSuggestionResult;
import com.google.android.gms.common.api.internal.ListenerHolder;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzam extends zzag {
    final /* synthetic */ ListenerHolder zza;

    zzam(zzav zzavVar, ListenerHolder listenerHolder) {
        this.zza = listenerHolder;
        Objects.requireNonNull(zzavVar);
    }

    @Override // com.google.android.gms.internal.cast.zzah
    public final void zzb(DeviceSuggestionResult deviceSuggestionResult) {
        this.zza.notifyListener(new zzak(this, deviceSuggestionResult));
    }

    @Override // com.google.android.gms.internal.cast.zzah
    public final void zzc(DeviceSuggestionResult deviceSuggestionResult) {
        this.zza.notifyListener(new zzal(this, deviceSuggestionResult));
    }
}
