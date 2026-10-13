package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public enum zzup implements zzaur {
    IAB_TCF_PURPOSE_UNKNOWN(0),
    IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE(1),
    IAB_TCF_PURPOSE_SELECT_BASIC_ADS(2),
    IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE(3),
    IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS(4),
    IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_CONTENT_PROFILE(5),
    IAB_TCF_PURPOSE_SELECT_PERSONALISED_CONTENT(6),
    IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE(7),
    IAB_TCF_PURPOSE_MEASURE_CONTENT_PERFORMANCE(8),
    IAB_TCF_PURPOSE_APPLY_MARKET_RESEARCH_TO_GENERATE_AUDIENCE_INSIGHTS(9),
    IAB_TCF_PURPOSE_DEVELOP_AND_IMPROVE_PRODUCTS(10),
    IAB_TCF_PURPOSE_USE_LIMITED_DATA_TO_SELECT_CONTENT(11),
    UNRECOGNIZED(-1);

    private final int zzn;

    zzup(int i) {
        this.zzn = i;
    }

    public static zzup zzb(int i) {
        switch (i) {
            case 0:
                return IAB_TCF_PURPOSE_UNKNOWN;
            case 1:
                return IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE;
            case 2:
                return IAB_TCF_PURPOSE_SELECT_BASIC_ADS;
            case 3:
                return IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE;
            case 4:
                return IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS;
            case 5:
                return IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_CONTENT_PROFILE;
            case 6:
                return IAB_TCF_PURPOSE_SELECT_PERSONALISED_CONTENT;
            case 7:
                return IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE;
            case 8:
                return IAB_TCF_PURPOSE_MEASURE_CONTENT_PERFORMANCE;
            case 9:
                return IAB_TCF_PURPOSE_APPLY_MARKET_RESEARCH_TO_GENERATE_AUDIENCE_INSIGHTS;
            case 10:
                return IAB_TCF_PURPOSE_DEVELOP_AND_IMPROVE_PRODUCTS;
            case 11:
                return IAB_TCF_PURPOSE_USE_LIMITED_DATA_TO_SELECT_CONTENT;
            default:
                return null;
        }
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzn);
    }

    public final int zza() {
        if (this != UNRECOGNIZED) {
            return this.zzn;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
