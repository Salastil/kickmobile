package com.android.billingclient.api;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes5.dex */
public final class BillingProgramInformationDialogParams {
    private final int billingProgram;
    private final String externalTransactionToken;

    /* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
    public static final class Builder {
        private int zza;
        private String zzb;

        private Builder() {
            throw null;
        }

        /* synthetic */ Builder(zzde zzdeVar) {
        }

        public BillingProgramInformationDialogParams build() {
            int i = this.zza;
            if (i == 0) {
                throw new IllegalArgumentException("Billing program must be set.");
            }
            if (i != 5) {
                throw new IllegalArgumentException("The requested billing program is not supported for the billing program information dialog API.");
            }
            if (this.zzb != null) {
                return new BillingProgramInformationDialogParams(this);
            }
            throw new IllegalArgumentException("External transaction token must be set.");
        }

        public Builder setBillingProgram(int i) {
            this.zza = i;
            return this;
        }

        public Builder setExternalTransactionToken(String str) {
            this.zzb = str;
            return this;
        }
    }

    private BillingProgramInformationDialogParams(Builder builder) {
        this.billingProgram = builder.zza;
        this.externalTransactionToken = builder.zzb;
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    public int getBillingProgram() {
        return this.billingProgram;
    }

    public String getExternalTransactionToken() {
        return this.externalTransactionToken;
    }
}
