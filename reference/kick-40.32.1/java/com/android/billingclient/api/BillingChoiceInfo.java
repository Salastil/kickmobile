package com.android.billingclient.api;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes5.dex */
public final class BillingChoiceInfo {
    private final String playBillingChoiceImageUrl;
    private final String playBillingLoyaltyInfo;

    BillingChoiceInfo(String str, String str2) {
        this.playBillingChoiceImageUrl = str;
        this.playBillingLoyaltyInfo = str2;
    }

    public String getPlayBillingChoiceImageUrl() {
        return this.playBillingChoiceImageUrl;
    }

    public String getPlayBillingLoyaltyInfo() {
        return this.playBillingLoyaltyInfo;
    }
}
