package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzjy extends zzkp {
    final /* synthetic */ TaskCompletionSource zza;

    zzjy(zzkk zzkkVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
        Objects.requireNonNull(zzkkVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzkq
    public final void zzb(Status status, byte[] bArr) {
        if (!status.isSuccess()) {
            TaskUtil.setResultOrApiException(status, (Object) null, (TaskCompletionSource<Object>) this.zza);
            return;
        }
        try {
            TaskUtil.setResultOrApiException(status, zzno.zzc(bArr, zzadf.zza()), (TaskCompletionSource<zzno>) this.zza);
        } catch (zzaeh e) {
            this.zza.setException(e);
        }
    }
}
