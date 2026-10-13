package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public enum zzaue {
    DOUBLE(0, 1, zzavd.DOUBLE),
    FLOAT(1, 1, zzavd.FLOAT),
    INT64(2, 1, zzavd.LONG),
    UINT64(3, 1, zzavd.LONG),
    INT32(4, 1, zzavd.INT),
    FIXED64(5, 1, zzavd.LONG),
    FIXED32(6, 1, zzavd.INT),
    BOOL(7, 1, zzavd.BOOLEAN),
    STRING(8, 1, zzavd.STRING),
    MESSAGE(9, 1, zzavd.MESSAGE),
    BYTES(10, 1, zzavd.BYTE_STRING),
    UINT32(11, 1, zzavd.INT),
    ENUM(12, 1, zzavd.ENUM),
    SFIXED32(13, 1, zzavd.INT),
    SFIXED64(14, 1, zzavd.LONG),
    SINT32(15, 1, zzavd.INT),
    SINT64(16, 1, zzavd.LONG),
    GROUP(17, 1, zzavd.MESSAGE),
    DOUBLE_LIST(18, 2, zzavd.DOUBLE),
    FLOAT_LIST(19, 2, zzavd.FLOAT),
    INT64_LIST(20, 2, zzavd.LONG),
    UINT64_LIST(21, 2, zzavd.LONG),
    INT32_LIST(22, 2, zzavd.INT),
    FIXED64_LIST(23, 2, zzavd.LONG),
    FIXED32_LIST(24, 2, zzavd.INT),
    BOOL_LIST(25, 2, zzavd.BOOLEAN),
    STRING_LIST(26, 2, zzavd.STRING),
    MESSAGE_LIST(27, 2, zzavd.MESSAGE),
    BYTES_LIST(28, 2, zzavd.BYTE_STRING),
    UINT32_LIST(29, 2, zzavd.INT),
    ENUM_LIST(30, 2, zzavd.ENUM),
    SFIXED32_LIST(31, 2, zzavd.INT),
    SFIXED64_LIST(32, 2, zzavd.LONG),
    SINT32_LIST(33, 2, zzavd.INT),
    SINT64_LIST(34, 2, zzavd.LONG),
    DOUBLE_LIST_PACKED(35, 3, zzavd.DOUBLE),
    FLOAT_LIST_PACKED(36, 3, zzavd.FLOAT),
    INT64_LIST_PACKED(37, 3, zzavd.LONG),
    UINT64_LIST_PACKED(38, 3, zzavd.LONG),
    INT32_LIST_PACKED(39, 3, zzavd.INT),
    FIXED64_LIST_PACKED(40, 3, zzavd.LONG),
    FIXED32_LIST_PACKED(41, 3, zzavd.INT),
    BOOL_LIST_PACKED(42, 3, zzavd.BOOLEAN),
    UINT32_LIST_PACKED(43, 3, zzavd.INT),
    ENUM_LIST_PACKED(44, 3, zzavd.ENUM),
    SFIXED32_LIST_PACKED(45, 3, zzavd.INT),
    SFIXED64_LIST_PACKED(46, 3, zzavd.LONG),
    SINT32_LIST_PACKED(47, 3, zzavd.INT),
    SINT64_LIST_PACKED(48, 3, zzavd.LONG),
    GROUP_LIST(49, 2, zzavd.MESSAGE),
    MAP(50, 4, zzavd.VOID);

    private static final zzaue[] zzaa;
    private final int zzZ;

    static {
        zzaue[] zzaueVarArrValues = values();
        zzaa = new zzaue[zzaueVarArrValues.length];
        for (zzaue zzaueVar : zzaueVarArrValues) {
            zzaa[zzaueVar.zzZ] = zzaueVar;
        }
    }

    zzaue(int i, int i2, zzavd zzavdVar) {
        this.zzZ = i;
        int i3 = i2 - 1;
        if (i3 == 1 || i3 == 3) {
            zzavdVar.zza();
        }
        if (i2 == 1) {
            zzavd zzavdVar2 = zzavd.VOID;
            zzavdVar.ordinal();
        }
    }

    public final int zza() {
        return this.zzZ;
    }
}
