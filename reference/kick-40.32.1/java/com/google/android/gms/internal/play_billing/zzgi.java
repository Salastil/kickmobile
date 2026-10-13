package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public enum zzgi {
    DOUBLE(0, 1, zzhc.DOUBLE),
    FLOAT(1, 1, zzhc.FLOAT),
    INT64(2, 1, zzhc.LONG),
    UINT64(3, 1, zzhc.LONG),
    INT32(4, 1, zzhc.INT),
    FIXED64(5, 1, zzhc.LONG),
    FIXED32(6, 1, zzhc.INT),
    BOOL(7, 1, zzhc.BOOLEAN),
    STRING(8, 1, zzhc.STRING),
    MESSAGE(9, 1, zzhc.MESSAGE),
    BYTES(10, 1, zzhc.BYTE_STRING),
    UINT32(11, 1, zzhc.INT),
    ENUM(12, 1, zzhc.ENUM),
    SFIXED32(13, 1, zzhc.INT),
    SFIXED64(14, 1, zzhc.LONG),
    SINT32(15, 1, zzhc.INT),
    SINT64(16, 1, zzhc.LONG),
    GROUP(17, 1, zzhc.MESSAGE),
    DOUBLE_LIST(18, 2, zzhc.DOUBLE),
    FLOAT_LIST(19, 2, zzhc.FLOAT),
    INT64_LIST(20, 2, zzhc.LONG),
    UINT64_LIST(21, 2, zzhc.LONG),
    INT32_LIST(22, 2, zzhc.INT),
    FIXED64_LIST(23, 2, zzhc.LONG),
    FIXED32_LIST(24, 2, zzhc.INT),
    BOOL_LIST(25, 2, zzhc.BOOLEAN),
    STRING_LIST(26, 2, zzhc.STRING),
    MESSAGE_LIST(27, 2, zzhc.MESSAGE),
    BYTES_LIST(28, 2, zzhc.BYTE_STRING),
    UINT32_LIST(29, 2, zzhc.INT),
    ENUM_LIST(30, 2, zzhc.ENUM),
    SFIXED32_LIST(31, 2, zzhc.INT),
    SFIXED64_LIST(32, 2, zzhc.LONG),
    SINT32_LIST(33, 2, zzhc.INT),
    SINT64_LIST(34, 2, zzhc.LONG),
    DOUBLE_LIST_PACKED(35, 3, zzhc.DOUBLE),
    FLOAT_LIST_PACKED(36, 3, zzhc.FLOAT),
    INT64_LIST_PACKED(37, 3, zzhc.LONG),
    UINT64_LIST_PACKED(38, 3, zzhc.LONG),
    INT32_LIST_PACKED(39, 3, zzhc.INT),
    FIXED64_LIST_PACKED(40, 3, zzhc.LONG),
    FIXED32_LIST_PACKED(41, 3, zzhc.INT),
    BOOL_LIST_PACKED(42, 3, zzhc.BOOLEAN),
    UINT32_LIST_PACKED(43, 3, zzhc.INT),
    ENUM_LIST_PACKED(44, 3, zzhc.ENUM),
    SFIXED32_LIST_PACKED(45, 3, zzhc.INT),
    SFIXED64_LIST_PACKED(46, 3, zzhc.LONG),
    SINT32_LIST_PACKED(47, 3, zzhc.INT),
    SINT64_LIST_PACKED(48, 3, zzhc.LONG),
    GROUP_LIST(49, 2, zzhc.MESSAGE),
    MAP(50, 4, zzhc.VOID);

    private static final zzgi[] zzZ;
    private final int zzab;

    static {
        zzgi[] zzgiVarArrValues = values();
        zzZ = new zzgi[zzgiVarArrValues.length];
        for (zzgi zzgiVar : zzgiVarArrValues) {
            zzZ[zzgiVar.zzab] = zzgiVar;
        }
    }

    zzgi(int i, int i2, zzhc zzhcVar) {
        this.zzab = i;
        int i3 = i2 - 1;
        if (i3 == 1 || i3 == 3) {
            zzhcVar.zza();
        }
        if (i2 == 1) {
            zzhc zzhcVar2 = zzhc.VOID;
            zzhcVar.ordinal();
        }
    }

    public final int zza() {
        return this.zzab;
    }
}
