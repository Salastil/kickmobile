package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
enum zzb {
    RESPONSE_CODE_UNSPECIFIED(-999),
    SERVICE_TIMEOUT(-3),
    FEATURE_NOT_SUPPORTED(-2),
    SERVICE_DISCONNECTED(-1),
    OK(0),
    USER_CANCELED(1),
    SERVICE_UNAVAILABLE(2),
    BILLING_UNAVAILABLE(3),
    ITEM_UNAVAILABLE(4),
    DEVELOPER_ERROR(5),
    ERROR(6),
    ITEM_ALREADY_OWNED(7),
    ITEM_NOT_OWNED(8),
    EXPIRED_OFFER_TOKEN(11),
    NETWORK_ERROR(12);

    private static final zzcd zzp;
    private final int zzr;

    static {
        zzcc zzccVar = new zzcc();
        for (zzb zzbVar : values()) {
            zzccVar.zza(Integer.valueOf(zzbVar.zzr), zzbVar);
        }
        zzp = zzccVar.zzb();
    }

    zzb(int i) {
        this.zzr = i;
    }

    static zzb zza(int i) {
        zzcd zzcdVar = zzp;
        Integer numValueOf = Integer.valueOf(i);
        return !zzcdVar.containsKey(numValueOf) ? RESPONSE_CODE_UNSPECIFIED : (zzb) zzcdVar.get(numValueOf);
    }
}
