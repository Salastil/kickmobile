package org.bouncycastle.math.ec.rfc8032;

import androidx.core.view.PointerIconCompat;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat256;

/* JADX INFO: loaded from: classes11.dex */
abstract class Scalar25519 {
    private static final int L0 = -50998291;
    private static final int L1 = 19280294;
    private static final int L2 = 127719000;
    private static final int L3 = -6428113;
    private static final int L4 = 5343;
    private static final long M08L = 255;
    private static final long M28L = 268435455;
    private static final long M32L = 4294967295L;
    private static final int SCALAR_BYTES = 32;
    static final int SIZE = 8;
    private static final int TARGET_LENGTH = 254;
    private static final int[] L = {1559614445, 1477600026, -1560830762, 350157278, 0, 0, 0, 268435456};
    private static final int[] LSq = {-1424848535, -487721339, 580428573, 1745064566, -770181698, 1036971123, 461123738, -1582065343, 1268693629, -889041821, -731974758, 43769659, 0, 0, 0, 16777216};

    Scalar25519() {
    }

    static boolean checkVar(byte[] bArr, int[] iArr) {
        decode(bArr, iArr);
        return !Nat256.gte(iArr, L);
    }

    static void decode(byte[] bArr, int[] iArr) {
        Codec.decode32(bArr, 0, iArr, 0, 8);
    }

    static void getOrderWnafVar(int i, byte[] bArr) {
        Wnaf.getSignedVar(L, i, bArr);
    }

    static void multiply128Var(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArr4 = new int[12];
        Nat256.mul128(iArr, iArr2, iArr4);
        if (iArr2[3] < 0) {
            Nat256.addTo(L, 0, iArr4, 4, 0);
            Nat256.subFrom(iArr, 0, iArr4, 4, 0);
        }
        byte[] bArr = new byte[48];
        Codec.encode32(iArr4, 0, 12, bArr, 0);
        decode(reduce384(bArr), iArr3);
    }

    static byte[] reduce384(byte[] bArr) {
        long jDecode32 = ((long) Codec.decode32(bArr, 0)) & 4294967295L;
        long jDecode24 = ((long) (Codec.decode24(bArr, 4) << 4)) & 4294967295L;
        long jDecode33 = ((long) Codec.decode32(bArr, 7)) & 4294967295L;
        long jDecode25 = ((long) (Codec.decode24(bArr, 11) << 4)) & 4294967295L;
        long jDecode34 = ((long) Codec.decode32(bArr, 14)) & 4294967295L;
        long jDecode26 = ((long) (Codec.decode24(bArr, 18) << 4)) & 4294967295L;
        long jDecode35 = ((long) Codec.decode32(bArr, 21)) & 4294967295L;
        long jDecode27 = ((long) (Codec.decode24(bArr, 25) << 4)) & 4294967295L;
        long jDecode36 = ((long) Codec.decode32(bArr, 28)) & 4294967295L;
        long jDecode28 = Codec.decode24(bArr, 32) << 4;
        long j = jDecode28 & 4294967295L;
        long jDecode37 = Codec.decode32(bArr, 35);
        long j2 = jDecode37 & 4294967295L;
        long jDecode29 = Codec.decode24(bArr, 39) << 4;
        long j3 = jDecode29 & 4294967295L;
        long jDecode38 = Codec.decode32(bArr, 42);
        long jDecode16 = (((long) (Codec.decode16(bArr, 46) << 4)) & 4294967295L) + ((jDecode38 & 4294967295L) >> 28);
        long j4 = jDecode36 - (jDecode16 * 5343);
        long j5 = (jDecode38 & M28L) + (j3 >> 28);
        long j6 = (jDecode34 - (jDecode16 * (-50998291))) - (j5 * 19280294);
        long j7 = (jDecode26 - (jDecode16 * 19280294)) - (j5 * 127719000);
        long j8 = (jDecode35 - (jDecode16 * 127719000)) - (j5 * (-6428113));
        long j9 = (jDecode27 - (jDecode16 * (-6428113))) - (j5 * 5343);
        long j10 = (jDecode29 & M28L) + (j2 >> 28);
        long j11 = jDecode33 - (j10 * (-50998291));
        long j12 = (jDecode25 - (j5 * (-50998291))) - (j10 * 19280294);
        long j13 = j6 - (j10 * 127719000);
        long j14 = j7 - (j10 * (-6428113));
        long j15 = j8 - (j10 * 5343);
        long j16 = (jDecode37 & M28L) + (j >> 28);
        long j17 = jDecode28 & M28L;
        long j18 = jDecode24 - (j16 * (-50998291));
        long j19 = j11 - (j16 * 19280294);
        long j20 = j12 - (j16 * 127719000);
        long j21 = j13 - (j16 * (-6428113));
        long j22 = j14 - (j16 * 5343);
        long j23 = j4 + (j9 >> 28);
        long j24 = j9 & M28L;
        long j25 = j17 + (j23 >> 28);
        long j26 = j23 & M28L;
        long j27 = j26 >>> 27;
        long j28 = j25 + j27;
        long j29 = jDecode32 - (j28 * (-50998291));
        long j30 = j19 - (j28 * 127719000);
        long j31 = j20 - (j28 * (-6428113));
        long j32 = j21 - (j28 * 5343);
        long j33 = (j18 - (j28 * 19280294)) + (j29 >> 28);
        long j34 = j29 & M28L;
        long j35 = j30 + (j33 >> 28);
        long j36 = j33 & M28L;
        long j37 = j31 + (j35 >> 28);
        long j38 = j35 & M28L;
        long j39 = j32 + (j37 >> 28);
        long j40 = j37 & M28L;
        long j41 = j22 + (j39 >> 28);
        long j42 = j39 & M28L;
        long j43 = j15 + (j41 >> 28);
        long j44 = j41 & M28L;
        long j45 = j24 + (j43 >> 28);
        long j46 = j43 & M28L;
        long j47 = j26 + (j45 >> 28);
        long j48 = j45 & M28L;
        long j49 = j47 >> 28;
        long j50 = j47 & M28L;
        long j51 = j49 - j27;
        long j52 = j34 + (j51 & (-50998291));
        long j53 = j36 + (j51 & 19280294) + (j52 >> 28);
        long j54 = j52 & M28L;
        long j55 = j38 + (j51 & 127719000) + (j53 >> 28);
        long j56 = j53 & M28L;
        long j57 = j40 + (j51 & (-6428113)) + (j55 >> 28);
        long j58 = j55 & M28L;
        long j59 = j42 + (j51 & 5343) + (j57 >> 28);
        long j60 = j57 & M28L;
        long j61 = j44 + (j59 >> 28);
        long j62 = j59 & M28L;
        long j63 = j46 + (j61 >> 28);
        long j64 = j61 & M28L;
        long j65 = j48 + (j63 >> 28);
        long j66 = j63 & M28L;
        long j67 = j50 + (j65 >> 28);
        long j68 = M28L & j65;
        byte[] bArr2 = new byte[64];
        Codec.encode56(j54 | (j56 << 28), bArr2, 0);
        Codec.encode56(j58 | (j60 << 28), bArr2, 7);
        Codec.encode56((j64 << 28) | j62, bArr2, 14);
        Codec.encode56((j68 << 28) | j66, bArr2, 21);
        Codec.encode32((int) j67, bArr2, 28);
        return bArr2;
    }

    static byte[] reduce512(byte[] bArr) {
        long jDecode32 = ((long) Codec.decode32(bArr, 0)) & 4294967295L;
        long jDecode24 = ((long) (Codec.decode24(bArr, 4) << 4)) & 4294967295L;
        long jDecode33 = ((long) Codec.decode32(bArr, 7)) & 4294967295L;
        long jDecode25 = ((long) (Codec.decode24(bArr, 11) << 4)) & 4294967295L;
        long jDecode34 = ((long) Codec.decode32(bArr, 14)) & 4294967295L;
        long jDecode26 = ((long) (Codec.decode24(bArr, 18) << 4)) & 4294967295L;
        long jDecode35 = ((long) Codec.decode32(bArr, 21)) & 4294967295L;
        long jDecode27 = ((long) (Codec.decode24(bArr, 25) << 4)) & 4294967295L;
        long jDecode36 = ((long) Codec.decode32(bArr, 28)) & 4294967295L;
        long jDecode28 = ((long) (Codec.decode24(bArr, 32) << 4)) & 4294967295L;
        long jDecode37 = ((long) Codec.decode32(bArr, 35)) & 4294967295L;
        long jDecode29 = ((long) (Codec.decode24(bArr, 39) << 4)) & 4294967295L;
        long jDecode38 = ((long) Codec.decode32(bArr, 42)) & 4294967295L;
        long jDecode210 = ((long) (Codec.decode24(bArr, 46) << 4)) & 4294967295L;
        long jDecode39 = Codec.decode32(bArr, 49);
        long j = jDecode39 & 4294967295L;
        long jDecode211 = ((long) (Codec.decode24(bArr, 53) << 4)) & 4294967295L;
        long jDecode310 = Codec.decode32(bArr, 56);
        long jDecode212 = ((long) (Codec.decode24(bArr, 60) << 4)) & 4294967295L;
        long j2 = ((long) bArr[63]) & 255;
        long j3 = jDecode212 + ((jDecode310 & 4294967295L) >> 28);
        long j4 = jDecode310 & M28L;
        long j5 = (jDecode38 - (j2 * (-6428113))) - (j3 * 5343);
        long j6 = (jDecode36 - (j3 * (-50998291))) - (j4 * 19280294);
        long j7 = ((jDecode28 - (j2 * (-50998291))) - (j3 * 19280294)) - (j4 * 127719000);
        long j8 = ((jDecode37 - (j2 * 19280294)) - (j3 * 127719000)) - (j4 * (-6428113));
        long j9 = ((jDecode29 - (j2 * 127719000)) - (j3 * (-6428113))) - (j4 * 5343);
        long j10 = jDecode211 + (j >> 28);
        long j11 = jDecode39 & M28L;
        long j12 = j8 - (j10 * 5343);
        long j13 = (j7 - (j10 * (-6428113))) - (j11 * 5343);
        long j14 = (jDecode210 - (j2 * 5343)) + (j5 >> 28);
        long j15 = ((jDecode35 - (j10 * (-50998291))) - (j11 * 19280294)) - (j14 * 127719000);
        long j16 = (((jDecode27 - (j4 * (-50998291))) - (j10 * 19280294)) - (j11 * 127719000)) - (j14 * (-6428113));
        long j17 = ((j6 - (j10 * 127719000)) - (j11 * (-6428113))) - (j14 * 5343);
        long j18 = (j5 & M28L) + (j9 >> 28);
        long j19 = (jDecode34 - (j14 * (-50998291))) - (j18 * 19280294);
        long j20 = ((jDecode26 - (j11 * (-50998291))) - (j14 * 19280294)) - (j18 * 127719000);
        long j21 = j16 - (j18 * 5343);
        long j22 = (j9 & M28L) + (j12 >> 28);
        long j23 = jDecode33 - (j22 * (-50998291));
        long j24 = (jDecode25 - (j18 * (-50998291))) - (j22 * 19280294);
        long j25 = j19 - (j22 * 127719000);
        long j26 = j20 - (j22 * (-6428113));
        long j27 = (j15 - (j18 * (-6428113))) - (j22 * 5343);
        long j28 = (j12 & M28L) + (j13 >> 28);
        long j29 = j13 & M28L;
        long j30 = jDecode24 - (j28 * (-50998291));
        long j31 = j23 - (j28 * 19280294);
        long j32 = j24 - (j28 * 127719000);
        long j33 = j25 - (j28 * (-6428113));
        long j34 = j26 - (j28 * 5343);
        long j35 = j17 + (j21 >> 28);
        long j36 = j21 & M28L;
        long j37 = j29 + (j35 >> 28);
        long j38 = j35 & M28L;
        long j39 = j38 >>> 27;
        long j40 = j37 + j39;
        long j41 = jDecode32 - (j40 * (-50998291));
        long j42 = j31 - (j40 * 127719000);
        long j43 = j32 - (j40 * (-6428113));
        long j44 = j33 - (j40 * 5343);
        long j45 = (j30 - (j40 * 19280294)) + (j41 >> 28);
        long j46 = j41 & M28L;
        long j47 = j42 + (j45 >> 28);
        long j48 = j45 & M28L;
        long j49 = j43 + (j47 >> 28);
        long j50 = j47 & M28L;
        long j51 = j44 + (j49 >> 28);
        long j52 = j49 & M28L;
        long j53 = j34 + (j51 >> 28);
        long j54 = j51 & M28L;
        long j55 = j27 + (j53 >> 28);
        long j56 = j53 & M28L;
        long j57 = j36 + (j55 >> 28);
        long j58 = j55 & M28L;
        long j59 = j38 + (j57 >> 28);
        long j60 = j57 & M28L;
        long j61 = j59 >> 28;
        long j62 = j59 & M28L;
        long j63 = j61 - j39;
        long j64 = j46 + (j63 & (-50998291));
        long j65 = j48 + (j63 & 19280294) + (j64 >> 28);
        long j66 = j64 & M28L;
        long j67 = j50 + (j63 & 127719000) + (j65 >> 28);
        long j68 = j65 & M28L;
        long j69 = j52 + (j63 & (-6428113)) + (j67 >> 28);
        long j70 = j67 & M28L;
        long j71 = j54 + (j63 & 5343) + (j69 >> 28);
        long j72 = j69 & M28L;
        long j73 = j56 + (j71 >> 28);
        long j74 = j71 & M28L;
        long j75 = j58 + (j73 >> 28);
        long j76 = j73 & M28L;
        long j77 = j60 + (j75 >> 28);
        long j78 = j75 & M28L;
        long j79 = j62 + (j77 >> 28);
        long j80 = j77 & M28L;
        byte[] bArr2 = new byte[32];
        Codec.encode56(j66 | (j68 << 28), bArr2, 0);
        Codec.encode56(j70 | (j72 << 28), bArr2, 7);
        Codec.encode56((j76 << 28) | j74, bArr2, 14);
        Codec.encode56((j80 << 28) | j78, bArr2, 21);
        Codec.encode32((int) j79, bArr2, 28);
        return bArr2;
    }

    static boolean reduceBasisVar(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArr4 = new int[16];
        System.arraycopy(LSq, 0, iArr4, 0, 16);
        int[] iArr5 = new int[16];
        Nat256.square(iArr, iArr5);
        iArr5[0] = iArr5[0] + 1;
        int[] iArr6 = new int[16];
        int[] iArr7 = L;
        Nat256.mul(iArr7, iArr, iArr6);
        int[] iArr8 = new int[16];
        int[] iArr9 = new int[4];
        System.arraycopy(iArr7, 0, iArr9, 0, 4);
        int[] iArr10 = new int[4];
        System.arraycopy(iArr, 0, iArr10, 0, 4);
        int[] iArr11 = new int[4];
        iArr11[0] = 1;
        int bitLengthPositive = ScalarUtil.getBitLengthPositive(15, iArr5);
        int i = PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW;
        int[] iArr12 = iArr11;
        int[] iArr13 = new int[4];
        int[] iArr14 = iArr9;
        int[] iArr15 = iArr10;
        int i2 = 15;
        int i3 = bitLengthPositive;
        int[] iArr16 = iArr4;
        int[] iArr17 = iArr5;
        while (i3 > TARGET_LENGTH) {
            i--;
            if (i < 0) {
                return false;
            }
            int bitLength = ScalarUtil.getBitLength(i2, iArr6) - i3;
            int i4 = bitLength & (~(bitLength >> 31));
            if (iArr6[i2] < 0) {
                ScalarUtil.addShifted_NP(i2, i4, iArr16, iArr17, iArr6, iArr8);
                ScalarUtil.addShifted_UV(3, i4, iArr14, iArr13, iArr15, iArr12);
            } else {
                ScalarUtil.subShifted_NP(i2, i4, iArr16, iArr17, iArr6, iArr8);
                ScalarUtil.subShifted_UV(3, i4, iArr14, iArr13, iArr15, iArr12);
            }
            int[] iArr18 = iArr15;
            int[] iArr19 = iArr12;
            if (ScalarUtil.lessThan(i2, iArr16, iArr17)) {
                int i5 = i3 >>> 5;
                int bitLengthPositive2 = ScalarUtil.getBitLengthPositive(i5, iArr16);
                int[] iArr20 = iArr17;
                iArr17 = iArr16;
                iArr16 = iArr20;
                i2 = i5;
                i3 = bitLengthPositive2;
                iArr15 = iArr14;
                iArr12 = iArr13;
                iArr13 = iArr19;
                iArr14 = iArr18;
            } else {
                iArr12 = iArr19;
                iArr15 = iArr18;
            }
        }
        System.arraycopy(iArr15, 0, iArr2, 0, 4);
        System.arraycopy(iArr12, 0, iArr3, 0, 4);
        return true;
    }

    static void toSignedDigits(int i, int[] iArr) {
        Nat.caddTo(8, (~iArr[0]) & 1, L, iArr);
        Nat.shiftDownBit(8, iArr, 1);
    }
}
