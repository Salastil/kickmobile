package com.google.ads.interactivemedia.pal;

import androidx.exifinterface.media.ExifInterface;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes6.dex */
enum zzq {
    NONCE_LOADED("1"),
    ERROR_EVENT(ExifInterface.GPS_MEASUREMENT_2D),
    RESERVED_NONCE_MANAGER_IMPRESSION(ExifInterface.GPS_MEASUREMENT_3D),
    RESERVED_NONCE_MANAGER_CLICK("4"),
    RESERVED_NONCE_MANAGER_TOUCH("5");

    private final String zzf;

    zzq(String str) {
        this.zzf = str;
    }

    final String zza() {
        return this.zzf;
    }
}
