package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public enum zzadl {
    DOUBLE(0, 1, zzaei.DOUBLE),
    FLOAT(1, 1, zzaei.FLOAT),
    INT64(2, 1, zzaei.LONG),
    UINT64(3, 1, zzaei.LONG),
    INT32(4, 1, zzaei.INT),
    FIXED64(5, 1, zzaei.LONG),
    FIXED32(6, 1, zzaei.INT),
    BOOL(7, 1, zzaei.BOOLEAN),
    STRING(8, 1, zzaei.STRING),
    MESSAGE(9, 1, zzaei.MESSAGE),
    BYTES(10, 1, zzaei.BYTE_STRING),
    UINT32(11, 1, zzaei.INT),
    ENUM(12, 1, zzaei.ENUM),
    SFIXED32(13, 1, zzaei.INT),
    SFIXED64(14, 1, zzaei.LONG),
    SINT32(15, 1, zzaei.INT),
    SINT64(16, 1, zzaei.LONG),
    GROUP(17, 1, zzaei.MESSAGE),
    DOUBLE_LIST(18, 2, zzaei.DOUBLE),
    FLOAT_LIST(19, 2, zzaei.FLOAT),
    INT64_LIST(20, 2, zzaei.LONG),
    UINT64_LIST(21, 2, zzaei.LONG),
    INT32_LIST(22, 2, zzaei.INT),
    FIXED64_LIST(23, 2, zzaei.LONG),
    FIXED32_LIST(24, 2, zzaei.INT),
    BOOL_LIST(25, 2, zzaei.BOOLEAN),
    STRING_LIST(26, 2, zzaei.STRING),
    MESSAGE_LIST(27, 2, zzaei.MESSAGE),
    BYTES_LIST(28, 2, zzaei.BYTE_STRING),
    UINT32_LIST(29, 2, zzaei.INT),
    ENUM_LIST(30, 2, zzaei.ENUM),
    SFIXED32_LIST(31, 2, zzaei.INT),
    SFIXED64_LIST(32, 2, zzaei.LONG),
    SINT32_LIST(33, 2, zzaei.INT),
    SINT64_LIST(34, 2, zzaei.LONG),
    DOUBLE_LIST_PACKED(35, 3, zzaei.DOUBLE),
    FLOAT_LIST_PACKED(36, 3, zzaei.FLOAT),
    INT64_LIST_PACKED(37, 3, zzaei.LONG),
    UINT64_LIST_PACKED(38, 3, zzaei.LONG),
    INT32_LIST_PACKED(39, 3, zzaei.INT),
    FIXED64_LIST_PACKED(40, 3, zzaei.LONG),
    FIXED32_LIST_PACKED(41, 3, zzaei.INT),
    BOOL_LIST_PACKED(42, 3, zzaei.BOOLEAN),
    UINT32_LIST_PACKED(43, 3, zzaei.INT),
    ENUM_LIST_PACKED(44, 3, zzaei.ENUM),
    SFIXED32_LIST_PACKED(45, 3, zzaei.INT),
    SFIXED64_LIST_PACKED(46, 3, zzaei.LONG),
    SINT32_LIST_PACKED(47, 3, zzaei.INT),
    SINT64_LIST_PACKED(48, 3, zzaei.LONG),
    GROUP_LIST(49, 2, zzaei.MESSAGE),
    MAP(50, 4, zzaei.VOID);

    private static final zzadl[] zzaa;
    private final int zzZ;

    static {
        zzadl[] zzadlVarArrValues = values();
        zzaa = new zzadl[zzadlVarArrValues.length];
        for (zzadl zzadlVar : zzadlVarArrValues) {
            zzaa[zzadlVar.zzZ] = zzadlVar;
        }
    }

    zzadl(int i, int i2, zzaei zzaeiVar) {
        this.zzZ = i;
        int i3 = i2 - 1;
        if (i3 == 1 || i3 == 3) {
            zzaeiVar.zza();
        }
        if (i2 == 1) {
            zzaei zzaeiVar2 = zzaei.VOID;
            zzaeiVar.ordinal();
        }
    }

    public final int zza() {
        return this.zzZ;
    }
}
