package com.android.billingclient.api;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes5.dex */
enum zzdk {
    GET_BILLING_CONFIG("getBillingConfig", 29),
    IS_BILLING_PROGRAM_AVAILABLE_ASYNC("isIndirectBillingProgramAvailable", 33),
    CREATE_BILLING_PROGRAM_REPORTING_DETAILS_ASYNC("createIndirectBillingReportingDetails", 35),
    GET_BILLING_CHOICE_INFO_ASYNC("getBillingChoiceInfo", 40);

    private final String zzf;
    private final int zzg;

    zzdk(String str, int i) {
        this.zzf = str;
        this.zzg = i;
    }

    final String zza() {
        return this.zzf;
    }

    final int zzb() {
        return this.zzg;
    }
}
