package com.android.billingclient.api;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes5.dex */
public final class EnableBillingProgramParams {
    private final int zza;
    private final DeveloperProvidedBillingListener zzb;

    /* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
    public static final class Builder {
        private int zza;
        private DeveloperProvidedBillingListener zzb;

        public EnableBillingProgramParams build() {
            return new EnableBillingProgramParams(this, null);
        }

        public Builder setBillingProgram(int i) {
            this.zza = i;
            return this;
        }

        public Builder setDeveloperProvidedBillingListener(DeveloperProvidedBillingListener developerProvidedBillingListener) {
            this.zzb = developerProvidedBillingListener;
            return this;
        }
    }

    /* synthetic */ EnableBillingProgramParams(Builder builder, zzdp zzdpVar) {
        this.zza = builder.zza;
        this.zzb = builder.zzb;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public int getBillingProgram() {
        return this.zza;
    }

    public DeveloperProvidedBillingListener getDeveloperProvidedBillingListener() {
        return this.zzb;
    }
}
