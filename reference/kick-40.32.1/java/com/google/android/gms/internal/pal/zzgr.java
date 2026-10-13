package com.google.android.gms.internal.pal;

import android.content.Context;
import android.content.pm.ApkChecksum;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager$OnChecksumsReadyListener;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.ReactRootView$$ExternalSyntheticApiModelOutline0;
import java.security.cert.CertificateEncodingException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzgr {
    public static String zza(Context context, String str, List list, Executor executor) throws ExecutionException, InterruptedException, PackageManager.NameNotFoundException, CertificateEncodingException {
        if (Build.VERSION.SDK_INT <= 30 && !Build.VERSION.CODENAME.equals(ExifInterface.LATITUDE_SOUTH)) {
            return null;
        }
        final zzuj zzujVarZzn = zzuj.zzn();
        context.getPackageManager().requestChecksums(str, false, 8, list, new PackageManager$OnChecksumsReadyListener() { // from class: com.google.android.gms.internal.pal.zzgq
            public final /* synthetic */ void onChecksumsReady(List list2) {
                zzuj zzujVar = zzujVarZzn;
                if (list2 == null) {
                    zzujVar.zzc(null);
                    return;
                }
                try {
                    int size = list2.size();
                    for (int i = 0; i < size; i++) {
                        ApkChecksum apkChecksumM = ReactRootView$$ExternalSyntheticApiModelOutline0.m(list2.get(i));
                        if (apkChecksumM.getType() == 8) {
                            zzujVar.zzc(zzfe.zza(apkChecksumM.getValue()));
                            return;
                        }
                    }
                    zzujVar.zzc(null);
                } catch (Throwable unused) {
                    zzujVar.zzc(null);
                }
            }
        });
        return (String) zzujVarZzn.get();
    }
}
