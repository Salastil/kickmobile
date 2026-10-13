package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public enum zzjg {
    DOUBLE(zzjh.DOUBLE, 1),
    FLOAT(zzjh.FLOAT, 5),
    INT64(zzjh.LONG, 0),
    UINT64(zzjh.LONG, 0),
    INT32(zzjh.INT, 0),
    FIXED64(zzjh.LONG, 1),
    FIXED32(zzjh.INT, 5),
    BOOL(zzjh.BOOLEAN, 0),
    STRING(zzjh.STRING, 2),
    GROUP(zzjh.MESSAGE, 3),
    MESSAGE(zzjh.MESSAGE, 2),
    BYTES(zzjh.BYTE_STRING, 2),
    UINT32(zzjh.INT, 0),
    ENUM(zzjh.ENUM, 0),
    SFIXED32(zzjh.INT, 5),
    SFIXED64(zzjh.LONG, 1),
    SINT32(zzjh.INT, 0),
    SINT64(zzjh.LONG, 0);

    private final zzjh zzt;
    private final int zzu;

    zzjg(zzjh zzjhVar, int i) {
        this.zzt = zzjhVar;
        this.zzu = i;
    }

    public final int zza() {
        return this.zzu;
    }

    public final zzjh zzb() {
        return this.zzt;
    }
}
