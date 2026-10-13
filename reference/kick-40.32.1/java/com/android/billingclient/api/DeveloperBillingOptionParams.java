package com.android.billingclient.api;

import android.net.Uri;
import android.text.TextUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes5.dex */
public final class DeveloperBillingOptionParams {
    private final Uri zza;
    private final int zzb;
    private final int zzc;
    private final String zzd;

    /* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
    public static final class Builder {
        private Uri zza;
        private int zzb = 0;
        private int zzc = 0;
        private String zzd;

        private Builder() {
        }

        /* synthetic */ Builder(zzdn zzdnVar) {
        }

        public DeveloperBillingOptionParams build() {
            int i = this.zzc;
            if (i == 0) {
                throw new IllegalArgumentException("Billing program is required.");
            }
            if (i == 5 && this.zza != null && TextUtils.isEmpty(this.zzd)) {
                throw new IllegalArgumentException("External transaction token is required for billing choice with an external link.");
            }
            Uri uri = this.zza;
            if (uri == null || uri.getScheme() != null) {
                return new DeveloperBillingOptionParams(this, null);
            }
            throw new IllegalArgumentException("URI must have a scheme.");
        }

        public Builder setBillingProgram(int i) {
            this.zzc = i;
            return this;
        }

        public Builder setExternalTransactionToken(String str) {
            this.zzd = str;
            return this;
        }

        public Builder setLaunchMode(int i) {
            this.zzb = i;
            return this;
        }

        public Builder setLinkUri(Uri uri) {
            this.zza = uri;
            return this;
        }
    }

    /* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface LaunchMode {
        public static final int CALLER_WILL_LAUNCH_LINK = 2;
        public static final int LAUNCH_IN_EXTERNAL_BROWSER_OR_APP = 1;
        public static final int LAUNCH_MODE_UNSPECIFIED = 0;
    }

    /* synthetic */ DeveloperBillingOptionParams(Builder builder, zzdn zzdnVar) {
        this.zza = builder.zza;
        this.zzb = builder.zzb;
        this.zzc = builder.zzc;
        this.zzd = builder.zzd;
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    public int getBillingProgram() {
        return this.zzc;
    }

    public String getExternalTransactionToken() {
        return this.zzd;
    }

    public int getLaunchMode() {
        return this.zzb;
    }

    public Uri getLinkUri() {
        return this.zza;
    }
}
