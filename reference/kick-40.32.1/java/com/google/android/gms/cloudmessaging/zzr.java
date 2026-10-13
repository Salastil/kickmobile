package com.google.android.gms.cloudmessaging;

import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@17.4.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzr extends zzs {
    zzr(int i, int i2, Bundle bundle) {
        super(i, i2, bundle);
    }

    @Override // com.google.android.gms.cloudmessaging.zzs
    final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.cloudmessaging.zzs
    final void zzb(Bundle bundle) {
        if (bundle.getBoolean("ack", false)) {
            zzc(null);
        } else {
            zzd(new zzt(4, "Invalid response to one way request", null));
        }
    }
}
