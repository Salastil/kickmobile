package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public enum zzaln {
    DOUBLE(0, zzalp.SCALAR, zzamf.DOUBLE),
    FLOAT(1, zzalp.SCALAR, zzamf.FLOAT),
    INT64(2, zzalp.SCALAR, zzamf.LONG),
    UINT64(3, zzalp.SCALAR, zzamf.LONG),
    INT32(4, zzalp.SCALAR, zzamf.INT),
    FIXED64(5, zzalp.SCALAR, zzamf.LONG),
    FIXED32(6, zzalp.SCALAR, zzamf.INT),
    BOOL(7, zzalp.SCALAR, zzamf.BOOLEAN),
    STRING(8, zzalp.SCALAR, zzamf.STRING),
    MESSAGE(9, zzalp.SCALAR, zzamf.MESSAGE),
    BYTES(10, zzalp.SCALAR, zzamf.BYTE_STRING),
    UINT32(11, zzalp.SCALAR, zzamf.INT),
    ENUM(12, zzalp.SCALAR, zzamf.ENUM),
    SFIXED32(13, zzalp.SCALAR, zzamf.INT),
    SFIXED64(14, zzalp.SCALAR, zzamf.LONG),
    SINT32(15, zzalp.SCALAR, zzamf.INT),
    SINT64(16, zzalp.SCALAR, zzamf.LONG),
    GROUP(17, zzalp.SCALAR, zzamf.MESSAGE),
    DOUBLE_LIST(18, zzalp.VECTOR, zzamf.DOUBLE),
    FLOAT_LIST(19, zzalp.VECTOR, zzamf.FLOAT),
    INT64_LIST(20, zzalp.VECTOR, zzamf.LONG),
    UINT64_LIST(21, zzalp.VECTOR, zzamf.LONG),
    INT32_LIST(22, zzalp.VECTOR, zzamf.INT),
    FIXED64_LIST(23, zzalp.VECTOR, zzamf.LONG),
    FIXED32_LIST(24, zzalp.VECTOR, zzamf.INT),
    BOOL_LIST(25, zzalp.VECTOR, zzamf.BOOLEAN),
    STRING_LIST(26, zzalp.VECTOR, zzamf.STRING),
    MESSAGE_LIST(27, zzalp.VECTOR, zzamf.MESSAGE),
    BYTES_LIST(28, zzalp.VECTOR, zzamf.BYTE_STRING),
    UINT32_LIST(29, zzalp.VECTOR, zzamf.INT),
    ENUM_LIST(30, zzalp.VECTOR, zzamf.ENUM),
    SFIXED32_LIST(31, zzalp.VECTOR, zzamf.INT),
    SFIXED64_LIST(32, zzalp.VECTOR, zzamf.LONG),
    SINT32_LIST(33, zzalp.VECTOR, zzamf.INT),
    SINT64_LIST(34, zzalp.VECTOR, zzamf.LONG),
    DOUBLE_LIST_PACKED(35, zzalp.PACKED_VECTOR, zzamf.DOUBLE),
    FLOAT_LIST_PACKED(36, zzalp.PACKED_VECTOR, zzamf.FLOAT),
    INT64_LIST_PACKED(37, zzalp.PACKED_VECTOR, zzamf.LONG),
    UINT64_LIST_PACKED(38, zzalp.PACKED_VECTOR, zzamf.LONG),
    INT32_LIST_PACKED(39, zzalp.PACKED_VECTOR, zzamf.INT),
    FIXED64_LIST_PACKED(40, zzalp.PACKED_VECTOR, zzamf.LONG),
    FIXED32_LIST_PACKED(41, zzalp.PACKED_VECTOR, zzamf.INT),
    BOOL_LIST_PACKED(42, zzalp.PACKED_VECTOR, zzamf.BOOLEAN),
    UINT32_LIST_PACKED(43, zzalp.PACKED_VECTOR, zzamf.INT),
    ENUM_LIST_PACKED(44, zzalp.PACKED_VECTOR, zzamf.ENUM),
    SFIXED32_LIST_PACKED(45, zzalp.PACKED_VECTOR, zzamf.INT),
    SFIXED64_LIST_PACKED(46, zzalp.PACKED_VECTOR, zzamf.LONG),
    SINT32_LIST_PACKED(47, zzalp.PACKED_VECTOR, zzamf.INT),
    SINT64_LIST_PACKED(48, zzalp.PACKED_VECTOR, zzamf.LONG),
    GROUP_LIST(49, zzalp.VECTOR, zzamf.MESSAGE),
    MAP(50, zzalp.MAP, zzamf.VOID);

    private static final zzaln[] zzaz;
    private final int zzbb;

    public final int zza() {
        return this.zzbb;
    }

    static {
        zzaln[] zzalnVarArrValues = values();
        zzaz = new zzaln[zzalnVarArrValues.length];
        for (zzaln zzalnVar : zzalnVarArrValues) {
            zzaz[zzalnVar.zzbb] = zzalnVar;
        }
    }

    zzaln(int i, zzalp zzalpVar, zzamf zzamfVar) {
        this.zzbb = i;
        int iOrdinal = zzalpVar.ordinal();
        if (iOrdinal == 1 || iOrdinal == 3) {
            zzamfVar.zza();
        }
        if (zzalpVar == zzalp.SCALAR) {
            int i2 = zzalq.zza[zzamfVar.ordinal()];
        }
    }
}
