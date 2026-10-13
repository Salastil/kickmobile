package io.github.expo.modules.v2.types;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.infer.annotation.ThreadConfined;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.codec.language.bm.Languages;

/* JADX INFO: compiled from: CppType.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\n\b\u0087@\u0018\u0000 ,2\u00020\u0001:\u0001,B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0086\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0080\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0080\u0002¢\u0006\u0004\b\u0018\u0010\u0015J\r\u0010\u0019\u001a\u00020\u000e¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\"\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%J\u001a\u0010&\u001a\u00020\n2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b+\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u001c\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0005R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b!\u0010\u001f\u0088\u0001\u0002¨\u0006-"}, d2 = {"Lio/github/expo/modules/v2/types/CppType;", "", "code", "", "constructor-impl", "(I)I", "getCode", "()I", "nullable", "isNullable", "", "nullable-IpqU398", "(IZ)I", "plus", "Lio/github/expo/modules/v2/types/TypeCodes;", "tail", "plus-wHJnekk", "(I[I)[I", "schemaId", "Lio/github/expo/modules/v2/records/SchemaId;", "plus-xzi7F-U$react_release", "(II)[I", "classId", "Lio/github/expo/modules/v2/sharedobjects/SharedClassId;", "plus-SrtlfEY$react_release", "toTypeCodes", "toTypeCodes-pj4Pta4", "(I)[I", "codeWithoutHeader", "getCodeWithoutHeader-impl", "isNullable-impl", "(I)Z", "usesBuffer", "getUsesBuffer-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "Companion", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@JvmInline
public final class CppType {
    public static final int HEAD_FLAGS = 768;
    public static final int NULLABLE = 256;
    public static final int USES_BUFFER = 512;
    private final int code;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int BOOLEAN = m12405constructorimpl(0);
    private static final int STRING = m12405constructorimpl(1);
    private static final int INT = m12405constructorimpl(2);
    private static final int LONG = m12405constructorimpl(3);
    private static final int FLOAT = m12405constructorimpl(4);
    private static final int DOUBLE = m12405constructorimpl(5);
    private static final int LIST = m12405constructorimpl(6);
    private static final int MAP = m12405constructorimpl(7);
    private static final int ANY = m12405constructorimpl(8);
    private static final int DOUBLE_ARRAY = m12405constructorimpl(9);
    private static final int INT_ARRAY = m12405constructorimpl(10);
    private static final int LONG_ARRAY = m12405constructorimpl(11);
    private static final int FLOAT_ARRAY = m12405constructorimpl(12);
    private static final int BOOLEAN_ARRAY = m12405constructorimpl(13);
    private static final int BYTE_ARRAY = m12405constructorimpl(14);
    private static final int RECORD = m12405constructorimpl(15);
    private static final int JS_VALUE = m12405constructorimpl(16);
    private static final int JS_OBJECT = m12405constructorimpl(17);
    private static final int UNIT = m12405constructorimpl(18);
    private static final int BOX_INT = m12405constructorimpl(19);
    private static final int BOX_BOOLEAN = m12405constructorimpl(20);
    private static final int BOX_LONG = m12405constructorimpl(21);
    private static final int BOX_FLOAT = m12405constructorimpl(22);
    private static final int BOX_DOUBLE = m12405constructorimpl(23);
    private static final int SHARED_OBJECT = m12405constructorimpl(24);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ CppType m12404boximpl(int i) {
        return new CppType(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m12405constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m12406equalsimpl(int i, Object obj) {
        return (obj instanceof CppType) && i == ((CppType) obj).m12419unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m12407equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: getCodeWithoutHeader-impl, reason: not valid java name */
    public static final int m12408getCodeWithoutHeaderimpl(int i) {
        return i & (-769);
    }

    /* JADX INFO: renamed from: getUsesBuffer-impl, reason: not valid java name */
    public static final boolean m12409getUsesBufferimpl(int i) {
        return (i & 512) != 0;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m12410hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* JADX INFO: renamed from: isNullable-impl, reason: not valid java name */
    public static final boolean m12411isNullableimpl(int i) {
        return (i & 256) != 0;
    }

    public boolean equals(Object obj) {
        return m12406equalsimpl(this.code, obj);
    }

    public int hashCode() {
        return m12410hashCodeimpl(this.code);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m12419unboximpl() {
        return this.code;
    }

    private /* synthetic */ CppType(int i) {
        this.code = i;
    }

    public final int getCode() {
        return this.code;
    }

    /* JADX INFO: renamed from: nullable-IpqU398$default, reason: not valid java name */
    public static /* synthetic */ int m12413nullableIpqU398$default(int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        return m12412nullableIpqU398(i, z);
    }

    /* JADX INFO: renamed from: nullable-IpqU398, reason: not valid java name */
    public static final int m12412nullableIpqU398(int i, boolean z) {
        return z ? m12405constructorimpl(i | 256) : i;
    }

    /* JADX INFO: renamed from: plus-wHJnekk, reason: not valid java name */
    public static final int[] m12415pluswHJnekk(int i, int[] tail) {
        Intrinsics.checkNotNullParameter(tail, "tail");
        int[] iArr = new int[TypeCodes.m12453getSizeimpl(tail) + 1];
        iArr[0] = i;
        ArraysKt.copyInto$default(tail, iArr, 1, 0, 0, 12, (Object) null);
        return TypeCodes.m12446constructorimpl(iArr);
    }

    /* JADX INFO: renamed from: toTypeCodes-pj4Pta4, reason: not valid java name */
    public static final int[] m12418toTypeCodespj4Pta4(int i) {
        return TypeCodes.INSTANCE.m12462ofDWjln38(i);
    }

    public String toString() {
        return m12417toStringimpl(this.code);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m12417toStringimpl(int i) {
        String str;
        int iM12405constructorimpl = m12405constructorimpl(m12408getCodeWithoutHeaderimpl(i));
        if (m12407equalsimpl0(iM12405constructorimpl, BOOLEAN)) {
            str = TypedValues.Custom.S_BOOLEAN;
        } else if (m12407equalsimpl0(iM12405constructorimpl, STRING)) {
            str = TypedValues.Custom.S_STRING;
        } else if (m12407equalsimpl0(iM12405constructorimpl, INT)) {
            str = "int";
        } else if (m12407equalsimpl0(iM12405constructorimpl, LONG)) {
            str = "long";
        } else if (m12407equalsimpl0(iM12405constructorimpl, FLOAT)) {
            str = TypedValues.Custom.S_FLOAT;
        } else if (m12407equalsimpl0(iM12405constructorimpl, DOUBLE)) {
            str = "double";
        } else if (m12407equalsimpl0(iM12405constructorimpl, LIST)) {
            str = "list";
        } else if (m12407equalsimpl0(iM12405constructorimpl, MAP)) {
            str = "map";
        } else if (m12407equalsimpl0(iM12405constructorimpl, ANY)) {
            str = Languages.ANY;
        } else if (m12407equalsimpl0(iM12405constructorimpl, DOUBLE_ARRAY)) {
            str = "double_array";
        } else if (m12407equalsimpl0(iM12405constructorimpl, INT_ARRAY)) {
            str = "int_array";
        } else if (m12407equalsimpl0(iM12405constructorimpl, LONG_ARRAY)) {
            str = "long_array";
        } else if (m12407equalsimpl0(iM12405constructorimpl, FLOAT_ARRAY)) {
            str = "float_array";
        } else if (m12407equalsimpl0(iM12405constructorimpl, BOOLEAN_ARRAY)) {
            str = "boolean_array";
        } else if (m12407equalsimpl0(iM12405constructorimpl, BYTE_ARRAY)) {
            str = "byte_array";
        } else if (m12407equalsimpl0(iM12405constructorimpl, RECORD)) {
            str = "record";
        } else if (m12407equalsimpl0(iM12405constructorimpl, JS_VALUE)) {
            str = "js_value";
        } else if (m12407equalsimpl0(iM12405constructorimpl, JS_OBJECT)) {
            str = "js_object";
        } else if (m12407equalsimpl0(iM12405constructorimpl, UNIT)) {
            str = "unit";
        } else if (m12407equalsimpl0(iM12405constructorimpl, BOX_INT)) {
            str = "box_int";
        } else if (m12407equalsimpl0(iM12405constructorimpl, BOX_BOOLEAN)) {
            str = "box_boolean";
        } else if (m12407equalsimpl0(iM12405constructorimpl, BOX_LONG)) {
            str = "box_long";
        } else if (m12407equalsimpl0(iM12405constructorimpl, BOX_FLOAT)) {
            str = "box_float";
        } else if (m12407equalsimpl0(iM12405constructorimpl, BOX_DOUBLE)) {
            str = "box_double";
        } else if (m12407equalsimpl0(iM12405constructorimpl, SHARED_OBJECT)) {
            str = "shared_object";
        } else {
            str = "unknown(code=" + i + ")";
        }
        return str + (m12411isNullableimpl(i) ? "?" : "") + (m12409getUsesBufferimpl(i) ? " (buffered)" : "");
    }

    /* JADX INFO: compiled from: CppType.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b4\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007R\u0013\u0010\u0013\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0014\u0010\u0007R\u0013\u0010\u0015\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0016\u0010\u0007R\u0013\u0010\u0017\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0018\u0010\u0007R\u0013\u0010\u0019\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001a\u0010\u0007R\u0013\u0010\u001b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001c\u0010\u0007R\u0013\u0010\u001d\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001e\u0010\u0007R\u0013\u0010\u001f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b \u0010\u0007R\u0013\u0010!\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\"\u0010\u0007R\u0013\u0010#\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b$\u0010\u0007R\u0013\u0010%\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b&\u0010\u0007R\u0013\u0010'\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b(\u0010\u0007R\u0013\u0010)\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b*\u0010\u0007R\u0013\u0010+\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b,\u0010\u0007R\u0013\u0010-\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b.\u0010\u0007R\u0013\u0010/\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b0\u0010\u0007R\u0013\u00101\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b2\u0010\u0007R\u0013\u00103\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b4\u0010\u0007R\u0013\u00105\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b6\u0010\u0007R\u0013\u00107\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b8\u0010\u0007R\u000e\u00109\u001a\u00020:X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020:X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020:X\u0080T¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lio/github/expo/modules/v2/types/CppType$Companion;", "", "<init>", "()V", "BOOLEAN", "Lio/github/expo/modules/v2/types/CppType;", "getBOOLEAN-z4oZP-Q", "()I", "I", "STRING", "getSTRING-z4oZP-Q", "INT", "getINT-z4oZP-Q", "LONG", "getLONG-z4oZP-Q", "FLOAT", "getFLOAT-z4oZP-Q", "DOUBLE", "getDOUBLE-z4oZP-Q", "LIST", "getLIST-z4oZP-Q", "MAP", "getMAP-z4oZP-Q", ThreadConfined.ANY, "getANY-z4oZP-Q", "DOUBLE_ARRAY", "getDOUBLE_ARRAY-z4oZP-Q", "INT_ARRAY", "getINT_ARRAY-z4oZP-Q", "LONG_ARRAY", "getLONG_ARRAY-z4oZP-Q", "FLOAT_ARRAY", "getFLOAT_ARRAY-z4oZP-Q", "BOOLEAN_ARRAY", "getBOOLEAN_ARRAY-z4oZP-Q", "BYTE_ARRAY", "getBYTE_ARRAY-z4oZP-Q", "RECORD", "getRECORD-z4oZP-Q", "JS_VALUE", "getJS_VALUE-z4oZP-Q", "JS_OBJECT", "getJS_OBJECT-z4oZP-Q", "UNIT", "getUNIT-z4oZP-Q", "BOX_INT", "getBOX_INT-z4oZP-Q", "BOX_BOOLEAN", "getBOX_BOOLEAN-z4oZP-Q", "BOX_LONG", "getBOX_LONG-z4oZP-Q", "BOX_FLOAT", "getBOX_FLOAT-z4oZP-Q", "BOX_DOUBLE", "getBOX_DOUBLE-z4oZP-Q", "SHARED_OBJECT", "getSHARED_OBJECT-z4oZP-Q", "NULLABLE", "", "USES_BUFFER", "HEAD_FLAGS", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getBOOLEAN-z4oZP-Q, reason: not valid java name */
        public final int m12421getBOOLEANz4oZPQ() {
            return CppType.BOOLEAN;
        }

        /* JADX INFO: renamed from: getSTRING-z4oZP-Q, reason: not valid java name */
        public final int m12443getSTRINGz4oZPQ() {
            return CppType.STRING;
        }

        /* JADX INFO: renamed from: getINT-z4oZP-Q, reason: not valid java name */
        public final int m12433getINTz4oZPQ() {
            return CppType.INT;
        }

        /* JADX INFO: renamed from: getLONG-z4oZP-Q, reason: not valid java name */
        public final int m12438getLONGz4oZPQ() {
            return CppType.LONG;
        }

        /* JADX INFO: renamed from: getFLOAT-z4oZP-Q, reason: not valid java name */
        public final int m12431getFLOATz4oZPQ() {
            return CppType.FLOAT;
        }

        /* JADX INFO: renamed from: getDOUBLE-z4oZP-Q, reason: not valid java name */
        public final int m12429getDOUBLEz4oZPQ() {
            return CppType.DOUBLE;
        }

        /* JADX INFO: renamed from: getLIST-z4oZP-Q, reason: not valid java name */
        public final int m12437getLISTz4oZPQ() {
            return CppType.LIST;
        }

        /* JADX INFO: renamed from: getMAP-z4oZP-Q, reason: not valid java name */
        public final int m12440getMAPz4oZPQ() {
            return CppType.MAP;
        }

        /* JADX INFO: renamed from: getANY-z4oZP-Q, reason: not valid java name */
        public final int m12420getANYz4oZPQ() {
            return CppType.ANY;
        }

        /* JADX INFO: renamed from: getDOUBLE_ARRAY-z4oZP-Q, reason: not valid java name */
        public final int m12430getDOUBLE_ARRAYz4oZPQ() {
            return CppType.DOUBLE_ARRAY;
        }

        /* JADX INFO: renamed from: getINT_ARRAY-z4oZP-Q, reason: not valid java name */
        public final int m12434getINT_ARRAYz4oZPQ() {
            return CppType.INT_ARRAY;
        }

        /* JADX INFO: renamed from: getLONG_ARRAY-z4oZP-Q, reason: not valid java name */
        public final int m12439getLONG_ARRAYz4oZPQ() {
            return CppType.LONG_ARRAY;
        }

        /* JADX INFO: renamed from: getFLOAT_ARRAY-z4oZP-Q, reason: not valid java name */
        public final int m12432getFLOAT_ARRAYz4oZPQ() {
            return CppType.FLOAT_ARRAY;
        }

        /* JADX INFO: renamed from: getBOOLEAN_ARRAY-z4oZP-Q, reason: not valid java name */
        public final int m12422getBOOLEAN_ARRAYz4oZPQ() {
            return CppType.BOOLEAN_ARRAY;
        }

        /* JADX INFO: renamed from: getBYTE_ARRAY-z4oZP-Q, reason: not valid java name */
        public final int m12428getBYTE_ARRAYz4oZPQ() {
            return CppType.BYTE_ARRAY;
        }

        /* JADX INFO: renamed from: getRECORD-z4oZP-Q, reason: not valid java name */
        public final int m12441getRECORDz4oZPQ() {
            return CppType.RECORD;
        }

        /* JADX INFO: renamed from: getJS_VALUE-z4oZP-Q, reason: not valid java name */
        public final int m12436getJS_VALUEz4oZPQ() {
            return CppType.JS_VALUE;
        }

        /* JADX INFO: renamed from: getJS_OBJECT-z4oZP-Q, reason: not valid java name */
        public final int m12435getJS_OBJECTz4oZPQ() {
            return CppType.JS_OBJECT;
        }

        /* JADX INFO: renamed from: getUNIT-z4oZP-Q, reason: not valid java name */
        public final int m12444getUNITz4oZPQ() {
            return CppType.UNIT;
        }

        /* JADX INFO: renamed from: getBOX_INT-z4oZP-Q, reason: not valid java name */
        public final int m12426getBOX_INTz4oZPQ() {
            return CppType.BOX_INT;
        }

        /* JADX INFO: renamed from: getBOX_BOOLEAN-z4oZP-Q, reason: not valid java name */
        public final int m12423getBOX_BOOLEANz4oZPQ() {
            return CppType.BOX_BOOLEAN;
        }

        /* JADX INFO: renamed from: getBOX_LONG-z4oZP-Q, reason: not valid java name */
        public final int m12427getBOX_LONGz4oZPQ() {
            return CppType.BOX_LONG;
        }

        /* JADX INFO: renamed from: getBOX_FLOAT-z4oZP-Q, reason: not valid java name */
        public final int m12425getBOX_FLOATz4oZPQ() {
            return CppType.BOX_FLOAT;
        }

        /* JADX INFO: renamed from: getBOX_DOUBLE-z4oZP-Q, reason: not valid java name */
        public final int m12424getBOX_DOUBLEz4oZPQ() {
            return CppType.BOX_DOUBLE;
        }

        /* JADX INFO: renamed from: getSHARED_OBJECT-z4oZP-Q, reason: not valid java name */
        public final int m12442getSHARED_OBJECTz4oZPQ() {
            return CppType.SHARED_OBJECT;
        }
    }
}
