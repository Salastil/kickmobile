package com.google.android.gms.cast;

import android.content.Context;
import android.content.ServiceConnection;
import android.view.Display;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzah implements OnCompleteListener {
    final /* synthetic */ CastRemoteDisplayLocalService zza;

    zzah(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
        Objects.requireNonNull(castRemoteDisplayLocalService);
        this.zza = castRemoteDisplayLocalService;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        ServiceConnection serviceConnectionZzq;
        if (!task.isSuccessful()) {
            int i = CastRemoteDisplayLocalService.zza;
            CastRemoteDisplayLocalService.zzb.e("Connection was not successful", new Object[0]);
            this.zza.zzf();
            return;
        }
        int i2 = CastRemoteDisplayLocalService.zza;
        CastRemoteDisplayLocalService.zzb.d("startRemoteDisplay successful", new Object[0]);
        synchronized (CastRemoteDisplayLocalService.zzd) {
            if (CastRemoteDisplayLocalService.zzv == null) {
                CastRemoteDisplayLocalService.zzb.d("Remote Display started but session already cancelled", new Object[0]);
                this.zza.zzf();
                return;
            }
            Display display = (Display) task.getResult();
            CastRemoteDisplayLocalService castRemoteDisplayLocalService = this.zza;
            castRemoteDisplayLocalService.zzd(display);
            CastRemoteDisplayLocalService.zze.set(false);
            Context contextZzo = castRemoteDisplayLocalService.zzo();
            if (contextZzo != null && (serviceConnectionZzq = castRemoteDisplayLocalService.zzq()) != null) {
                try {
                    ConnectionTracker.getInstance().unbindService(contextZzo, serviceConnectionZzq);
                } catch (IllegalArgumentException unused) {
                    CastRemoteDisplayLocalService.zzb.d("No need to unbind service, already unbound", new Object[0]);
                }
            }
            CastRemoteDisplayLocalService castRemoteDisplayLocalService2 = this.zza;
            castRemoteDisplayLocalService2.zzr(null);
            castRemoteDisplayLocalService2.zzp(null);
        }
    }
}
