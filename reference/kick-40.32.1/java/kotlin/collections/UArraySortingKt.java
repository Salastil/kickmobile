package kotlin.collections;

import com.datadog.trace.bootstrap.instrumentation.api.InstrumentationTags;
import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UArraySorting.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0083\u0080\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a)\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0083\u0080\u0004¢\u0006\u0004\b\n\u0010\u000b\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0083\u0080\u0004¢\u0006\u0004\b\r\u0010\u000e\u001a)\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0083\u0080\u0004¢\u0006\u0004\b\u000f\u0010\u0010\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0083\u0080\u0004¢\u0006\u0004\b\u0012\u0010\u0013\u001a)\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0083\u0080\u0004¢\u0006\u0004\b\u0014\u0010\u0015\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0083\u0080\u0004¢\u0006\u0004\b\u0017\u0010\u0018\u001a)\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0083\u0080\u0004¢\u0006\u0004\b\u0019\u0010\u001a\u001a)\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0081\u0080\u0004¢\u0006\u0004\b\u001e\u0010\u000b\u001a)\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0081\u0080\u0004¢\u0006\u0004\b\u001f\u0010\u0010\u001a)\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0081\u0080\u0004¢\u0006\u0004\b \u0010\u0015\u001a)\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0081\u0080\u0004¢\u0006\u0004\b!\u0010\u001a¨\u0006\""}, d2 = {InstrumentationTags.PARTITION, "", "array", "Lkotlin/UByteArray;", "left", "right", "partition-4UcCI2c", "([BII)I", "quickSort", "", "quickSort-4UcCI2c", "([BII)V", "Lkotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "quickSort-Aa5vz7o", "([SII)V", "Lkotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "quickSort-oBK06Vg", "([III)V", "Lkotlin/ULongArray;", "partition--nroSd4", "([JII)I", "quickSort--nroSd4", "([JII)V", "sortArray", "fromIndex", "toIndex", "sortArray-4UcCI2c", "sortArray-Aa5vz7o", "sortArray-oBK06Vg", "sortArray--nroSd4", "kotlin-stdlib"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class UArraySortingKt {
    /* JADX INFO: renamed from: partition-4UcCI2c, reason: not valid java name */
    private static final int m13152partition4UcCI2c(byte[] bArr, int i, int i2) {
        int i3;
        byte bM12769getw2LRezQ = UByteArray.m12769getw2LRezQ(bArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                i3 = bM12769getw2LRezQ & 255;
                if (Intrinsics.compare(UByteArray.m12769getw2LRezQ(bArr, i) & 255, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UByteArray.m12769getw2LRezQ(bArr, i2) & 255, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                byte bM12769getw2LRezQ2 = UByteArray.m12769getw2LRezQ(bArr, i);
                UByteArray.m12774setVurrAj0(bArr, i, UByteArray.m12769getw2LRezQ(bArr, i2));
                UByteArray.m12774setVurrAj0(bArr, i2, bM12769getw2LRezQ2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: quickSort-4UcCI2c, reason: not valid java name */
    private static final void m13156quickSort4UcCI2c(byte[] bArr, int i, int i2) {
        int iM13152partition4UcCI2c = m13152partition4UcCI2c(bArr, i, i2);
        int i3 = iM13152partition4UcCI2c - 1;
        if (i < i3) {
            m13156quickSort4UcCI2c(bArr, i, i3);
        }
        if (iM13152partition4UcCI2c < i2) {
            m13156quickSort4UcCI2c(bArr, iM13152partition4UcCI2c, i2);
        }
    }

    /* JADX INFO: renamed from: partition-Aa5vz7o, reason: not valid java name */
    private static final int m13153partitionAa5vz7o(short[] sArr, int i, int i2) {
        int i3;
        short sM13032getMh2AYeg = UShortArray.m13032getMh2AYeg(sArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                i3 = sM13032getMh2AYeg & 65535;
                if (Intrinsics.compare(UShortArray.m13032getMh2AYeg(sArr, i) & 65535, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UShortArray.m13032getMh2AYeg(sArr, i2) & 65535, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                short sM13032getMh2AYeg2 = UShortArray.m13032getMh2AYeg(sArr, i);
                UShortArray.m13037set01HTLdE(sArr, i, UShortArray.m13032getMh2AYeg(sArr, i2));
                UShortArray.m13037set01HTLdE(sArr, i2, sM13032getMh2AYeg2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: quickSort-Aa5vz7o, reason: not valid java name */
    private static final void m13157quickSortAa5vz7o(short[] sArr, int i, int i2) {
        int iM13153partitionAa5vz7o = m13153partitionAa5vz7o(sArr, i, i2);
        int i3 = iM13153partitionAa5vz7o - 1;
        if (i < i3) {
            m13157quickSortAa5vz7o(sArr, i, i3);
        }
        if (iM13153partitionAa5vz7o < i2) {
            m13157quickSortAa5vz7o(sArr, iM13153partitionAa5vz7o, i2);
        }
    }

    /* JADX INFO: renamed from: partition-oBK06Vg, reason: not valid java name */
    private static final int m13154partitionoBK06Vg(int[] iArr, int i, int i2) {
        int iM12848getpVg5ArA = UIntArray.m12848getpVg5ArA(iArr, (i + i2) / 2);
        while (i <= i2) {
            while (Integer.compare(UIntArray.m12848getpVg5ArA(iArr, i) ^ Integer.MIN_VALUE, iM12848getpVg5ArA ^ Integer.MIN_VALUE) < 0) {
                i++;
            }
            while (Integer.compare(UIntArray.m12848getpVg5ArA(iArr, i2) ^ Integer.MIN_VALUE, iM12848getpVg5ArA ^ Integer.MIN_VALUE) > 0) {
                i2--;
            }
            if (i <= i2) {
                int iM12848getpVg5ArA2 = UIntArray.m12848getpVg5ArA(iArr, i);
                UIntArray.m12853setVXSXFK8(iArr, i, UIntArray.m12848getpVg5ArA(iArr, i2));
                UIntArray.m12853setVXSXFK8(iArr, i2, iM12848getpVg5ArA2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: quickSort-oBK06Vg, reason: not valid java name */
    private static final void m13158quickSortoBK06Vg(int[] iArr, int i, int i2) {
        int iM13154partitionoBK06Vg = m13154partitionoBK06Vg(iArr, i, i2);
        int i3 = iM13154partitionoBK06Vg - 1;
        if (i < i3) {
            m13158quickSortoBK06Vg(iArr, i, i3);
        }
        if (iM13154partitionoBK06Vg < i2) {
            m13158quickSortoBK06Vg(iArr, iM13154partitionoBK06Vg, i2);
        }
    }

    /* JADX INFO: renamed from: partition--nroSd4, reason: not valid java name */
    private static final int m13151partitionnroSd4(long[] jArr, int i, int i2) {
        long jM12927getsVKNKU = ULongArray.m12927getsVKNKU(jArr, (i + i2) / 2);
        while (i <= i2) {
            while (Long.compare(ULongArray.m12927getsVKNKU(jArr, i) ^ Long.MIN_VALUE, jM12927getsVKNKU ^ Long.MIN_VALUE) < 0) {
                i++;
            }
            while (Long.compare(ULongArray.m12927getsVKNKU(jArr, i2) ^ Long.MIN_VALUE, jM12927getsVKNKU ^ Long.MIN_VALUE) > 0) {
                i2--;
            }
            if (i <= i2) {
                long jM12927getsVKNKU2 = ULongArray.m12927getsVKNKU(jArr, i);
                ULongArray.m12932setk8EXiF4(jArr, i, ULongArray.m12927getsVKNKU(jArr, i2));
                ULongArray.m12932setk8EXiF4(jArr, i2, jM12927getsVKNKU2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: quickSort--nroSd4, reason: not valid java name */
    private static final void m13155quickSortnroSd4(long[] jArr, int i, int i2) {
        int iM13151partitionnroSd4 = m13151partitionnroSd4(jArr, i, i2);
        int i3 = iM13151partitionnroSd4 - 1;
        if (i < i3) {
            m13155quickSortnroSd4(jArr, i, i3);
        }
        if (iM13151partitionnroSd4 < i2) {
            m13155quickSortnroSd4(jArr, iM13151partitionnroSd4, i2);
        }
    }

    /* JADX INFO: renamed from: sortArray-4UcCI2c, reason: not valid java name */
    public static final void m13160sortArray4UcCI2c(byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-array$0");
        m13156quickSort4UcCI2c(bArr, i, i2 - 1);
    }

    /* JADX INFO: renamed from: sortArray-Aa5vz7o, reason: not valid java name */
    public static final void m13161sortArrayAa5vz7o(short[] sArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-array$0");
        m13157quickSortAa5vz7o(sArr, i, i2 - 1);
    }

    /* JADX INFO: renamed from: sortArray-oBK06Vg, reason: not valid java name */
    public static final void m13162sortArrayoBK06Vg(int[] iArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-array$0");
        m13158quickSortoBK06Vg(iArr, i, i2 - 1);
    }

    /* JADX INFO: renamed from: sortArray--nroSd4, reason: not valid java name */
    public static final void m13159sortArraynroSd4(long[] jArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-array$0");
        m13155quickSortnroSd4(jArr, i, i2 - 1);
    }
}
