package com.android.billingclient.api;

import android.net.Uri;
import android.text.TextUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes5.dex */
public final class LaunchExternalLinkParams {
    private final Uri zza;
    private final int zzb;
    private final int zzc;
    private final int zzd;
    private final String zze;

    /* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
    public static final class Builder {
        private Uri zza;
        private int zzb = 0;
        private int zzc = 0;
        private int zzd = 0;
        private String zze;

        private Builder() {
        }

        /* synthetic */ Builder(zzea zzeaVar) {
        }

        public LaunchExternalLinkParams build() {
            int i = this.zzc;
            if (i == 0) {
                throw new IllegalArgumentException("Link type is required.");
            }
            int i2 = this.zzb;
            if (i2 == 0) {
                throw new IllegalArgumentException("Launch mode is required.");
            }
            if (i2 != 1 && i == 2) {
                throw new IllegalArgumentException("App downloads must launch in an external browser or app.");
            }
            int i3 = this.zzd;
            if (i3 == 0) {
                throw new IllegalArgumentException("Billing program is required.");
            }
            if (i3 == 5) {
                if (TextUtils.isEmpty(this.zze)) {
                    throw new IllegalArgumentException("External transaction token is required for billing choice with an external link.");
                }
                if (this.zzc != 1) {
                    throw new IllegalArgumentException("Link type must be LINK_TO_DIGITAL_CONTENT_OFFER for billing choice with an external link.");
                }
            }
            Uri uri = this.zza;
            if (uri == null) {
                throw new IllegalArgumentException("URI must be set.");
            }
            if (uri.getScheme() != null) {
                return new LaunchExternalLinkParams(this, null);
            }
            throw new IllegalArgumentException("URI must have a scheme.");
        }

        public Builder setBillingProgram(int i) {
            this.zzd = i;
            return this;
        }

        public Builder setExternalTransactionToken(String str) {
            this.zze = str;
            return this;
        }

        public Builder setLaunchMode(int i) {
            this.zzb = i;
            return this;
        }

        public Builder setLinkType(int i) {
            this.zzc = i;
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

    /* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface LinkType {
        public static final int LINK_TO_APP_DOWNLOAD = 2;
        public static final int LINK_TO_DIGITAL_CONTENT_OFFER = 1;
        public static final int LINK_TYPE_UNSPECIFIED = 0;
    }

    /* synthetic */ LaunchExternalLinkParams(Builder builder, zzea zzeaVar) {
        this.zza = builder.zza;
        this.zzb = builder.zzb;
        this.zzc = builder.zzc;
        this.zzd = builder.zzd;
        this.zze = builder.zze;
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    public int getBillingProgram() {
        return this.zzd;
    }

    public String getExternalTransactionToken() {
        return this.zze;
    }

    public int getLaunchMode() {
        return this.zzb;
    }

    public int getLinkType() {
        return this.zzc;
    }

    public Uri getLinkUri() {
        return this.zza;
    }
}
