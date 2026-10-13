package com.google.android.gms.internal.cast;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public enum zzxx {
    DOUBLE(0, 1, zzyp.DOUBLE),
    FLOAT(1, 1, zzyp.FLOAT),
    INT64(2, 1, zzyp.LONG),
    UINT64(3, 1, zzyp.LONG),
    INT32(4, 1, zzyp.INT),
    FIXED64(5, 1, zzyp.LONG),
    FIXED32(6, 1, zzyp.INT),
    BOOL(7, 1, zzyp.BOOLEAN),
    STRING(8, 1, zzyp.STRING),
    MESSAGE(9, 1, zzyp.MESSAGE),
    BYTES(10, 1, zzyp.BYTE_STRING),
    UINT32(11, 1, zzyp.INT),
    ENUM(12, 1, zzyp.ENUM),
    SFIXED32(13, 1, zzyp.INT),
    SFIXED64(14, 1, zzyp.LONG),
    SINT32(15, 1, zzyp.INT),
    SINT64(16, 1, zzyp.LONG),
    GROUP(17, 1, zzyp.MESSAGE),
    DOUBLE_LIST(18, 2, zzyp.DOUBLE),
    FLOAT_LIST(19, 2, zzyp.FLOAT),
    INT64_LIST(20, 2, zzyp.LONG),
    UINT64_LIST(21, 2, zzyp.LONG),
    INT32_LIST(22, 2, zzyp.INT),
    FIXED64_LIST(23, 2, zzyp.LONG),
    FIXED32_LIST(24, 2, zzyp.INT),
    BOOL_LIST(25, 2, zzyp.BOOLEAN),
    STRING_LIST(26, 2, zzyp.STRING),
    MESSAGE_LIST(27, 2, zzyp.MESSAGE),
    BYTES_LIST(28, 2, zzyp.BYTE_STRING),
    UINT32_LIST(29, 2, zzyp.INT),
    ENUM_LIST(30, 2, zzyp.ENUM),
    SFIXED32_LIST(31, 2, zzyp.INT),
    SFIXED64_LIST(32, 2, zzyp.LONG),
    SINT32_LIST(33, 2, zzyp.INT),
    SINT64_LIST(34, 2, zzyp.LONG),
    DOUBLE_LIST_PACKED(35, 3, zzyp.DOUBLE),
    FLOAT_LIST_PACKED(36, 3, zzyp.FLOAT),
    INT64_LIST_PACKED(37, 3, zzyp.LONG),
    UINT64_LIST_PACKED(38, 3, zzyp.LONG),
    INT32_LIST_PACKED(39, 3, zzyp.INT),
    FIXED64_LIST_PACKED(40, 3, zzyp.LONG),
    FIXED32_LIST_PACKED(41, 3, zzyp.INT),
    BOOL_LIST_PACKED(42, 3, zzyp.BOOLEAN),
    UINT32_LIST_PACKED(43, 3, zzyp.INT),
    ENUM_LIST_PACKED(44, 3, zzyp.ENUM),
    SFIXED32_LIST_PACKED(45, 3, zzyp.INT),
    SFIXED64_LIST_PACKED(46, 3, zzyp.LONG),
    SINT32_LIST_PACKED(47, 3, zzyp.INT),
    SINT64_LIST_PACKED(48, 3, zzyp.LONG),
    GROUP_LIST(49, 2, zzyp.MESSAGE),
    MAP(50, 4, zzyp.VOID);

    private static final zzxx[] zzaa;
    private final int zzZ;

    static {
        zzxx[] zzxxVarArrValues = values();
        zzaa = new zzxx[zzxxVarArrValues.length];
        for (zzxx zzxxVar : zzxxVarArrValues) {
            zzaa[zzxxVar.zzZ] = zzxxVar;
        }
    }

    zzxx(int i, int i2, zzyp zzypVar) {
        this.zzZ = i;
        int i3 = i2 - 1;
        if (i3 == 1 || i3 == 3) {
            zzypVar.zza();
        }
        if (i2 == 1) {
            zzyp zzypVar2 = zzyp.VOID;
            zzypVar.ordinal();
        }
    }

    public final int zza() {
        return this.zzZ;
    }
}
