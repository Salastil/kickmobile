package com.google.android.gms.internal.cast;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public enum zzaan {
    DOUBLE(zzaao.DOUBLE, 1),
    FLOAT(zzaao.FLOAT, 5),
    INT64(zzaao.LONG, 0),
    UINT64(zzaao.LONG, 0),
    INT32(zzaao.INT, 0),
    FIXED64(zzaao.LONG, 1),
    FIXED32(zzaao.INT, 5),
    BOOL(zzaao.BOOLEAN, 0),
    STRING(zzaao.STRING, 2),
    GROUP(zzaao.MESSAGE, 3),
    MESSAGE(zzaao.MESSAGE, 2),
    BYTES(zzaao.BYTE_STRING, 2),
    UINT32(zzaao.INT, 0),
    ENUM(zzaao.ENUM, 0),
    SFIXED32(zzaao.INT, 5),
    SFIXED64(zzaao.LONG, 1),
    SINT32(zzaao.INT, 0),
    SINT64(zzaao.LONG, 0);

    private final zzaao zzs;

    zzaan(zzaao zzaaoVar, int i) {
        this.zzs = zzaaoVar;
    }

    public final zzaao zza() {
        return this.zzs;
    }
}
