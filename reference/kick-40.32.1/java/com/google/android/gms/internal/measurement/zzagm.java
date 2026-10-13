package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public enum zzagm {
    DOUBLE(zzagn.DOUBLE, 1),
    FLOAT(zzagn.FLOAT, 5),
    INT64(zzagn.LONG, 0),
    UINT64(zzagn.LONG, 0),
    INT32(zzagn.INT, 0),
    FIXED64(zzagn.LONG, 1),
    FIXED32(zzagn.INT, 5),
    BOOL(zzagn.BOOLEAN, 0),
    STRING(zzagn.STRING, 2),
    GROUP(zzagn.MESSAGE, 3),
    MESSAGE(zzagn.MESSAGE, 2),
    BYTES(zzagn.BYTE_STRING, 2),
    UINT32(zzagn.INT, 0),
    ENUM(zzagn.ENUM, 0),
    SFIXED32(zzagn.INT, 5),
    SFIXED64(zzagn.LONG, 1),
    SINT32(zzagn.INT, 0),
    SINT64(zzagn.LONG, 0);

    private final zzagn zzs;
    private final int zzt;

    zzagm(zzagn zzagnVar, int i) {
        this.zzs = zzagnVar;
        this.zzt = i;
    }

    public final zzagn zza() {
        return this.zzs;
    }

    public final int zzb() {
        return this.zzt;
    }
}
