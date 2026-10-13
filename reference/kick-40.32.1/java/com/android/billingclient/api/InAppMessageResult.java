package com.android.billingclient.api;

import android.os.Bundle;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes5.dex */
public final class InAppMessageResult {
    private final int zza;
    private final String zzb;

    /* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface InAppMessageResponseCode {
        public static final int NO_ACTION_NEEDED = 0;
        public static final int SUBSCRIPTION_STATUS_UPDATED = 1;
    }

    public InAppMessageResult(int i, String str) {
        this.zza = 0;
        this.zzb = null;
    }

    private InAppMessageResult(int i, String str, String str2) {
        this.zza = i;
        this.zzb = str;
    }

    static InAppMessageResult zza(Bundle bundle) {
        return bundle == null ? new InAppMessageResult(0, null) : new InAppMessageResult(com.google.android.gms.internal.play_billing.zzc.zza(bundle, "InAppMessageResult"), bundle.getString("IN_APP_MESSAGE_PURCHASE_TOKEN"), bundle.getString("IN_APP_MESSAGE_PURCHASE_ID"));
    }

    public String getPurchaseToken() {
        return this.zzb;
    }

    public int getResponseCode() {
        return this.zza;
    }
}
