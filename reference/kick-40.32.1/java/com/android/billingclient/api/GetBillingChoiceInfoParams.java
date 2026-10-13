package com.android.billingclient.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes5.dex */
public final class GetBillingChoiceInfoParams {
    private final int billingProgram;
    private final String playBillingChoiceImageLayout;
    private final Locale userLocale;

    /* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
    public static final class Builder {
        private Locale zza;
        private int zzb = 0;
        private String zzc;

        private Builder() {
        }

        /* synthetic */ Builder(zzdw zzdwVar) {
        }

        public GetBillingChoiceInfoParams build() {
            if (this.zzb != 5) {
                throw new IllegalArgumentException("Only billing choice is allowed for this API.");
            }
            if (this.zzc != null) {
                return new GetBillingChoiceInfoParams(this);
            }
            throw new IllegalArgumentException("Play Billing choice image layout is required.");
        }

        public Builder setBillingProgram(int i) {
            this.zzb = i;
            return this;
        }

        public Builder setPlayBillingChoiceImageLayout(String str) {
            this.zzc = str;
            return this;
        }

        public Builder setUserLocale(Locale locale) {
            this.zza = locale;
            return this;
        }
    }

    /* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ImageLayout {
        public static final String RECTANGULAR_FOUR_BY_ONE = "RECTANGULAR_FOUR_BY_ONE";
        public static final String RECTANGULAR_THREE_BY_ONE = "RECTANGULAR_THREE_BY_ONE";
        public static final String RECTANGULAR_TWO_BY_TWO = "RECTANGULAR_TWO_BY_TWO";
    }

    private GetBillingChoiceInfoParams(Builder builder) {
        this.userLocale = builder.zza;
        this.billingProgram = builder.zzb;
        this.playBillingChoiceImageLayout = builder.zzc;
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    public int getBillingProgram() {
        return this.billingProgram;
    }

    public String getPlayBillingChoiceImageLayout() {
        return this.playBillingChoiceImageLayout;
    }

    public Locale getUserLocale() {
        return this.userLocale;
    }
}
