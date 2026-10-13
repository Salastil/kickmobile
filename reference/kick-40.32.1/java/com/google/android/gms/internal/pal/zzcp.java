package com.google.android.gms.internal.pal;

import android.content.pm.ApkChecksum;
import android.content.pm.PackageManager$OnChecksumsReadyListener;
import com.facebook.react.ReactRootView$$ExternalSyntheticApiModelOutline0;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzcp implements PackageManager$OnChecksumsReadyListener {
    final zzuj zza = zzuj.zzn();

    public final void onChecksumsReady(List list) {
        if (list == null) {
            this.zza.zzc("");
            return;
        }
        try {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ApkChecksum apkChecksumM = ReactRootView$$ExternalSyntheticApiModelOutline0.m(list.get(i));
                if (apkChecksumM.getType() == 8) {
                    zzuj zzujVar = this.zza;
                    zztp zztpVarZzh = zztp.zzl().zzh();
                    byte[] value = apkChecksumM.getValue();
                    zzujVar.zzc(zztpVarZzh.zzi(value, 0, value.length));
                    return;
                }
            }
        } catch (Throwable unused) {
        }
        this.zza.zzc("");
    }
}
