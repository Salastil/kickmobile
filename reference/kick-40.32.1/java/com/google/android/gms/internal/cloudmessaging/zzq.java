package com.google.android.gms.internal.cloudmessaging;

import android.content.Context;
import com.google.android.gms.common.api.ApiMetadata;
import com.google.android.gms.common.api.ComplianceOptions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@17.4.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzq {
    public static ApiMetadata zza(Context context) {
        zzn.zza();
        return ApiMetadata.fromComplianceOptions(ComplianceOptions.newBuilder(context).build());
    }
}
