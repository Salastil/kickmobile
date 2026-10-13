package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public enum zzaxn {
    DOUBLE(zzaxo.DOUBLE, 1),
    FLOAT(zzaxo.FLOAT, 5),
    INT64(zzaxo.LONG, 0),
    UINT64(zzaxo.LONG, 0),
    INT32(zzaxo.INT, 0),
    FIXED64(zzaxo.LONG, 1),
    FIXED32(zzaxo.INT, 5),
    BOOL(zzaxo.BOOLEAN, 0),
    STRING(zzaxo.STRING, 2),
    GROUP(zzaxo.MESSAGE, 3),
    MESSAGE(zzaxo.MESSAGE, 2),
    BYTES(zzaxo.BYTE_STRING, 2),
    UINT32(zzaxo.INT, 0),
    ENUM(zzaxo.ENUM, 0),
    SFIXED32(zzaxo.INT, 5),
    SFIXED64(zzaxo.LONG, 1),
    SINT32(zzaxo.INT, 0),
    SINT64(zzaxo.LONG, 0);

    private final zzaxo zzs;

    zzaxn(zzaxo zzaxoVar, int i) {
        this.zzs = zzaxoVar;
    }

    public final zzaxo zza() {
        return this.zzs;
    }
}
