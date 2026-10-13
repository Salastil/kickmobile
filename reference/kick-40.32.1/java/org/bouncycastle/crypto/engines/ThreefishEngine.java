package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.TweakableBlockCipherParameters;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes10.dex */
public class ThreefishEngine implements BlockCipher {
    public static final int BLOCKSIZE_1024 = 1024;
    public static final int BLOCKSIZE_256 = 256;
    public static final int BLOCKSIZE_512 = 512;
    private static final long C_240 = 2004413935125273122L;
    private static final int MAX_ROUNDS = 80;
    private static int[] MOD17 = null;
    private static int[] MOD3 = null;
    private static int[] MOD5 = null;
    private static int[] MOD9 = null;
    private static final int ROUNDS_1024 = 80;
    private static final int ROUNDS_256 = 72;
    private static final int ROUNDS_512 = 72;
    private static final int TWEAK_SIZE_BYTES = 16;
    private static final int TWEAK_SIZE_WORDS = 2;
    private int blocksizeBytes;
    private int blocksizeWords;
    private ThreefishCipher cipher;
    private long[] currentBlock;
    private boolean forEncryption;
    private long[] kw;
    private long[] t = new long[5];

    private static final class Threefish1024Cipher extends ThreefishCipher {
        private static final int ROTATION_0_0 = 24;
        private static final int ROTATION_0_1 = 13;
        private static final int ROTATION_0_2 = 8;
        private static final int ROTATION_0_3 = 47;
        private static final int ROTATION_0_4 = 8;
        private static final int ROTATION_0_5 = 17;
        private static final int ROTATION_0_6 = 22;
        private static final int ROTATION_0_7 = 37;
        private static final int ROTATION_1_0 = 38;
        private static final int ROTATION_1_1 = 19;
        private static final int ROTATION_1_2 = 10;
        private static final int ROTATION_1_3 = 55;
        private static final int ROTATION_1_4 = 49;
        private static final int ROTATION_1_5 = 18;
        private static final int ROTATION_1_6 = 23;
        private static final int ROTATION_1_7 = 52;
        private static final int ROTATION_2_0 = 33;
        private static final int ROTATION_2_1 = 4;
        private static final int ROTATION_2_2 = 51;
        private static final int ROTATION_2_3 = 13;
        private static final int ROTATION_2_4 = 34;
        private static final int ROTATION_2_5 = 41;
        private static final int ROTATION_2_6 = 59;
        private static final int ROTATION_2_7 = 17;
        private static final int ROTATION_3_0 = 5;
        private static final int ROTATION_3_1 = 20;
        private static final int ROTATION_3_2 = 48;
        private static final int ROTATION_3_3 = 41;
        private static final int ROTATION_3_4 = 47;
        private static final int ROTATION_3_5 = 28;
        private static final int ROTATION_3_6 = 16;
        private static final int ROTATION_3_7 = 25;
        private static final int ROTATION_4_0 = 41;
        private static final int ROTATION_4_1 = 9;
        private static final int ROTATION_4_2 = 37;
        private static final int ROTATION_4_3 = 31;
        private static final int ROTATION_4_4 = 12;
        private static final int ROTATION_4_5 = 47;
        private static final int ROTATION_4_6 = 44;
        private static final int ROTATION_4_7 = 30;
        private static final int ROTATION_5_0 = 16;
        private static final int ROTATION_5_1 = 34;
        private static final int ROTATION_5_2 = 56;
        private static final int ROTATION_5_3 = 51;
        private static final int ROTATION_5_4 = 4;
        private static final int ROTATION_5_5 = 53;
        private static final int ROTATION_5_6 = 42;
        private static final int ROTATION_5_7 = 41;
        private static final int ROTATION_6_0 = 31;
        private static final int ROTATION_6_1 = 44;
        private static final int ROTATION_6_2 = 47;
        private static final int ROTATION_6_3 = 46;
        private static final int ROTATION_6_4 = 19;
        private static final int ROTATION_6_5 = 42;
        private static final int ROTATION_6_6 = 44;
        private static final int ROTATION_6_7 = 25;
        private static final int ROTATION_7_0 = 9;
        private static final int ROTATION_7_1 = 48;
        private static final int ROTATION_7_2 = 35;
        private static final int ROTATION_7_3 = 52;
        private static final int ROTATION_7_4 = 23;
        private static final int ROTATION_7_5 = 31;
        private static final int ROTATION_7_6 = 37;
        private static final int ROTATION_7_7 = 20;

        public Threefish1024Cipher(long[] jArr, long[] jArr2) {
            super(jArr, jArr2);
        }

        @Override // org.bouncycastle.crypto.engines.ThreefishEngine.ThreefishCipher
        void decryptBlock(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.kw;
            long[] jArr4 = this.t;
            int[] iArr = ThreefishEngine.MOD17;
            int[] iArr2 = ThreefishEngine.MOD3;
            if (jArr3.length != 33) {
                throw new IllegalArgumentException();
            }
            if (jArr4.length != 5) {
                throw new IllegalArgumentException();
            }
            long j = jArr[0];
            int i = 1;
            long j2 = jArr[1];
            long j3 = jArr[2];
            long j4 = jArr[3];
            long j5 = jArr[4];
            long j6 = jArr[5];
            long j7 = jArr[6];
            long j8 = jArr[7];
            long j9 = jArr[8];
            long j10 = jArr[9];
            long j11 = jArr[10];
            long jXorRotr = jArr[11];
            long j12 = jArr[12];
            long jXorRotr2 = jArr[13];
            long j13 = jArr[14];
            long jXorRotr3 = jArr[15];
            int i2 = 19;
            while (i2 >= i) {
                int i3 = iArr[i2];
                int i4 = iArr2[i2];
                int i5 = i3 + 1;
                long j14 = j - jArr3[i5];
                int i6 = i3 + 2;
                long j15 = j2 - jArr3[i6];
                int i7 = i3 + 3;
                long j16 = j3 - jArr3[i7];
                int i8 = i3 + 4;
                long j17 = j4 - jArr3[i8];
                int i9 = i3 + 5;
                int i10 = i;
                long j18 = j5 - jArr3[i9];
                int i11 = i3 + 6;
                long j19 = j6 - jArr3[i11];
                int i12 = i3 + 7;
                long[] jArr5 = jArr4;
                long[] jArr6 = jArr3;
                long j20 = j7 - jArr3[i12];
                int i13 = i3 + 8;
                int[] iArr3 = iArr;
                long j21 = j8 - jArr6[i13];
                int i14 = i3 + 9;
                long j22 = j9 - jArr6[i14];
                int i15 = i3 + 10;
                long j23 = j10 - jArr6[i15];
                int i16 = i3 + 11;
                long j24 = j11 - jArr6[i16];
                int i17 = i3 + 12;
                long j25 = jXorRotr - jArr6[i17];
                int i18 = i3 + 13;
                long j26 = j12 - jArr6[i18];
                int i19 = i3 + 14;
                int i20 = i4 + 1;
                long j27 = jXorRotr2 - (jArr6[i19] + jArr5[i20]);
                int i21 = i3 + 15;
                long j28 = j13 - (jArr6[i21] + jArr5[i4 + 2]);
                long j29 = i2;
                long jXorRotr4 = ThreefishEngine.xorRotr(jXorRotr3 - ((jArr6[i3 + 16] + j29) + 1), 9, j14);
                long j30 = j14 - jXorRotr4;
                long jXorRotr5 = ThreefishEngine.xorRotr(j25, 48, j16);
                long j31 = j16 - jXorRotr5;
                long jXorRotr6 = ThreefishEngine.xorRotr(j27, 35, j20);
                long j32 = j20 - jXorRotr6;
                long jXorRotr7 = ThreefishEngine.xorRotr(j23, 52, j18);
                long j33 = j18 - jXorRotr7;
                long jXorRotr8 = ThreefishEngine.xorRotr(j15, 23, j28);
                long j34 = j28 - jXorRotr8;
                long jXorRotr9 = ThreefishEngine.xorRotr(j19, 31, j22);
                long j35 = j22 - jXorRotr9;
                long jXorRotr10 = ThreefishEngine.xorRotr(j17, 37, j24);
                long j36 = j24 - jXorRotr10;
                long jXorRotr11 = ThreefishEngine.xorRotr(j21, 20, j26);
                long j37 = j26 - jXorRotr11;
                long jXorRotr12 = ThreefishEngine.xorRotr(jXorRotr11, 31, j30);
                long j38 = j30 - jXorRotr12;
                long jXorRotr13 = ThreefishEngine.xorRotr(jXorRotr9, 44, j31);
                long j39 = j31 - jXorRotr13;
                long jXorRotr14 = ThreefishEngine.xorRotr(jXorRotr10, 47, j33);
                long j40 = j33 - jXorRotr14;
                long jXorRotr15 = ThreefishEngine.xorRotr(jXorRotr8, 46, j32);
                long j41 = j32 - jXorRotr15;
                long jXorRotr16 = ThreefishEngine.xorRotr(jXorRotr4, 19, j37);
                long j42 = j37 - jXorRotr16;
                long jXorRotr17 = ThreefishEngine.xorRotr(jXorRotr6, 42, j34);
                long j43 = j34 - jXorRotr17;
                long jXorRotr18 = ThreefishEngine.xorRotr(jXorRotr5, 44, j35);
                long j44 = j35 - jXorRotr18;
                long jXorRotr19 = ThreefishEngine.xorRotr(jXorRotr7, 25, j36);
                long j45 = j36 - jXorRotr19;
                long jXorRotr20 = ThreefishEngine.xorRotr(jXorRotr19, 16, j38);
                long j46 = j38 - jXorRotr20;
                long jXorRotr21 = ThreefishEngine.xorRotr(jXorRotr17, 34, j39);
                long j47 = j39 - jXorRotr21;
                long jXorRotr22 = ThreefishEngine.xorRotr(jXorRotr18, 56, j41);
                long j48 = j41 - jXorRotr22;
                long jXorRotr23 = ThreefishEngine.xorRotr(jXorRotr16, 51, j40);
                long j49 = j40 - jXorRotr23;
                long jXorRotr24 = ThreefishEngine.xorRotr(jXorRotr12, 4, j45);
                long j50 = j45 - jXorRotr24;
                long jXorRotr25 = ThreefishEngine.xorRotr(jXorRotr14, 53, j42);
                long j51 = j42 - jXorRotr25;
                long jXorRotr26 = ThreefishEngine.xorRotr(jXorRotr13, 42, j43);
                long j52 = j43 - jXorRotr26;
                long jXorRotr27 = ThreefishEngine.xorRotr(jXorRotr15, 41, j44);
                long j53 = j44 - jXorRotr27;
                long jXorRotr28 = ThreefishEngine.xorRotr(jXorRotr27, 41, j46);
                long jXorRotr29 = ThreefishEngine.xorRotr(jXorRotr25, 9, j47);
                long j54 = j47 - jXorRotr29;
                long jXorRotr30 = ThreefishEngine.xorRotr(jXorRotr26, 37, j49);
                long j55 = j49 - jXorRotr30;
                long jXorRotr31 = ThreefishEngine.xorRotr(jXorRotr24, 31, j48);
                long j56 = j48 - jXorRotr31;
                long jXorRotr32 = ThreefishEngine.xorRotr(jXorRotr20, 12, j53);
                long j57 = j53 - jXorRotr32;
                long jXorRotr33 = ThreefishEngine.xorRotr(jXorRotr22, 47, j50);
                long j58 = j50 - jXorRotr33;
                long jXorRotr34 = ThreefishEngine.xorRotr(jXorRotr21, 44, j51);
                long j59 = j51 - jXorRotr34;
                long jXorRotr35 = ThreefishEngine.xorRotr(jXorRotr23, 30, j52);
                long j60 = j52 - jXorRotr35;
                long j61 = (j46 - jXorRotr28) - jArr6[i3];
                long j62 = jXorRotr28 - jArr6[i5];
                long j63 = j54 - jArr6[i6];
                long j64 = jXorRotr29 - jArr6[i7];
                long j65 = j55 - jArr6[i8];
                long j66 = jXorRotr30 - jArr6[i9];
                long j67 = j56 - jArr6[i11];
                long j68 = jXorRotr31 - jArr6[i12];
                long j69 = j57 - jArr6[i13];
                long j70 = jXorRotr32 - jArr6[i14];
                long j71 = j58 - jArr6[i15];
                long j72 = jXorRotr33 - jArr6[i16];
                long j73 = j59 - jArr6[i17];
                long j74 = jXorRotr34 - (jArr6[i18] + jArr5[i4]);
                long j75 = j60 - (jArr6[i19] + jArr5[i20]);
                long jXorRotr36 = ThreefishEngine.xorRotr(jXorRotr35 - (jArr6[i21] + j29), 5, j61);
                long j76 = j61 - jXorRotr36;
                long jXorRotr37 = ThreefishEngine.xorRotr(j72, 20, j63);
                long j77 = j63 - jXorRotr37;
                long jXorRotr38 = ThreefishEngine.xorRotr(j74, 48, j67);
                long j78 = j67 - jXorRotr38;
                long jXorRotr39 = ThreefishEngine.xorRotr(j70, 41, j65);
                long j79 = j65 - jXorRotr39;
                long jXorRotr40 = ThreefishEngine.xorRotr(j62, 47, j75);
                long j80 = j75 - jXorRotr40;
                long jXorRotr41 = ThreefishEngine.xorRotr(j66, 28, j69);
                long j81 = j69 - jXorRotr41;
                long jXorRotr42 = ThreefishEngine.xorRotr(j64, 16, j71);
                long j82 = j71 - jXorRotr42;
                long jXorRotr43 = ThreefishEngine.xorRotr(j68, 25, j73);
                long j83 = j73 - jXorRotr43;
                long jXorRotr44 = ThreefishEngine.xorRotr(jXorRotr43, 33, j76);
                long j84 = j76 - jXorRotr44;
                long jXorRotr45 = ThreefishEngine.xorRotr(jXorRotr41, 4, j77);
                long j85 = j77 - jXorRotr45;
                long jXorRotr46 = ThreefishEngine.xorRotr(jXorRotr42, 51, j79);
                long j86 = j79 - jXorRotr46;
                long jXorRotr47 = ThreefishEngine.xorRotr(jXorRotr40, 13, j78);
                long j87 = j78 - jXorRotr47;
                long jXorRotr48 = ThreefishEngine.xorRotr(jXorRotr36, 34, j83);
                long j88 = j83 - jXorRotr48;
                long jXorRotr49 = ThreefishEngine.xorRotr(jXorRotr38, 41, j80);
                long j89 = j80 - jXorRotr49;
                long jXorRotr50 = ThreefishEngine.xorRotr(jXorRotr37, 59, j81);
                long j90 = j81 - jXorRotr50;
                long jXorRotr51 = ThreefishEngine.xorRotr(jXorRotr39, 17, j82);
                long j91 = j82 - jXorRotr51;
                long jXorRotr52 = ThreefishEngine.xorRotr(jXorRotr51, 38, j84);
                long j92 = j84 - jXorRotr52;
                long jXorRotr53 = ThreefishEngine.xorRotr(jXorRotr49, 19, j85);
                long j93 = j85 - jXorRotr53;
                long jXorRotr54 = ThreefishEngine.xorRotr(jXorRotr50, 10, j87);
                long j94 = j87 - jXorRotr54;
                long jXorRotr55 = ThreefishEngine.xorRotr(jXorRotr48, 55, j86);
                long j95 = j86 - jXorRotr55;
                long jXorRotr56 = ThreefishEngine.xorRotr(jXorRotr44, 49, j91);
                long j96 = j91 - jXorRotr56;
                long jXorRotr57 = ThreefishEngine.xorRotr(jXorRotr46, 18, j88);
                long j97 = j88 - jXorRotr57;
                long jXorRotr58 = ThreefishEngine.xorRotr(jXorRotr45, 23, j89);
                long j98 = j89 - jXorRotr58;
                long jXorRotr59 = ThreefishEngine.xorRotr(jXorRotr47, 52, j90);
                long j99 = j90 - jXorRotr59;
                long jXorRotr60 = ThreefishEngine.xorRotr(jXorRotr59, 24, j92);
                j = j92 - jXorRotr60;
                long jXorRotr61 = ThreefishEngine.xorRotr(jXorRotr57, 13, j93);
                j3 = j93 - jXorRotr61;
                long jXorRotr62 = ThreefishEngine.xorRotr(jXorRotr58, 8, j95);
                long j100 = j95 - jXorRotr62;
                long jXorRotr63 = ThreefishEngine.xorRotr(jXorRotr56, 47, j94);
                long j101 = j94 - jXorRotr63;
                long jXorRotr64 = ThreefishEngine.xorRotr(jXorRotr52, 8, j99);
                jXorRotr = ThreefishEngine.xorRotr(jXorRotr54, 17, j96);
                jXorRotr2 = ThreefishEngine.xorRotr(jXorRotr53, 22, j97);
                long j102 = j97 - jXorRotr2;
                jXorRotr3 = ThreefishEngine.xorRotr(jXorRotr55, 37, j98);
                j13 = j98 - jXorRotr3;
                i2 -= 2;
                j11 = j96 - jXorRotr;
                j6 = jXorRotr62;
                j7 = j101;
                j2 = jXorRotr60;
                j10 = jXorRotr64;
                i = i10;
                jArr3 = jArr6;
                jArr4 = jArr5;
                iArr = iArr3;
                iArr2 = iArr2;
                j5 = j100;
                j4 = jXorRotr61;
                j9 = j99 - jXorRotr64;
                j12 = j102;
                j8 = jXorRotr63;
            }
            long[] jArr7 = jArr4;
            long[] jArr8 = jArr3;
            int i22 = i;
            long j103 = j - jArr8[0];
            long j104 = j2 - jArr8[i22];
            long j105 = j3 - jArr8[2];
            long j106 = j4 - jArr8[3];
            long j107 = j5 - jArr8[4];
            long j108 = j6 - jArr8[5];
            long j109 = j7 - jArr8[6];
            long j110 = j8 - jArr8[7];
            long j111 = j9 - jArr8[8];
            long j112 = j10 - jArr8[9];
            long j113 = j11 - jArr8[10];
            long j114 = jXorRotr - jArr8[11];
            long j115 = j12 - jArr8[12];
            long j116 = jXorRotr2 - (jArr8[13] + jArr7[0]);
            long j117 = j13 - (jArr8[14] + jArr7[i22]);
            long j118 = jXorRotr3 - jArr8[15];
            jArr2[0] = j103;
            jArr2[i22] = j104;
            jArr2[2] = j105;
            jArr2[3] = j106;
            jArr2[4] = j107;
            jArr2[5] = j108;
            jArr2[6] = j109;
            jArr2[7] = j110;
            jArr2[8] = j111;
            jArr2[9] = j112;
            jArr2[10] = j113;
            jArr2[11] = j114;
            jArr2[12] = j115;
            jArr2[13] = j116;
            jArr2[14] = j117;
            jArr2[15] = j118;
        }

        @Override // org.bouncycastle.crypto.engines.ThreefishEngine.ThreefishCipher
        void encryptBlock(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.kw;
            long[] jArr4 = this.t;
            int[] iArr = ThreefishEngine.MOD17;
            int[] iArr2 = ThreefishEngine.MOD3;
            if (jArr3.length != 33) {
                throw new IllegalArgumentException();
            }
            if (jArr4.length != 5) {
                throw new IllegalArgumentException();
            }
            long j = jArr[0];
            long j2 = jArr[1];
            long j3 = jArr[2];
            long j4 = jArr[3];
            long j5 = jArr[4];
            long j6 = jArr[5];
            long j7 = jArr[6];
            long j8 = jArr[7];
            long j9 = jArr[8];
            long j10 = jArr[9];
            long j11 = jArr[10];
            long j12 = jArr[11];
            int i = 9;
            long j13 = jArr[12];
            int i2 = 12;
            int i3 = 13;
            long j14 = jArr[13];
            long j15 = jArr[14];
            long j16 = jArr[15];
            long j17 = j + jArr3[0];
            long j18 = j2 + jArr3[1];
            long j19 = j3 + jArr3[2];
            long j20 = j4 + jArr3[3];
            long j21 = j5 + jArr3[4];
            long j22 = j6 + jArr3[5];
            long j23 = j7 + jArr3[6];
            long j24 = j8 + jArr3[7];
            long j25 = j9 + jArr3[8];
            long j26 = j10 + jArr3[9];
            long j27 = j11 + jArr3[10];
            long j28 = j12 + jArr3[11];
            long j29 = j13 + jArr3[12];
            long j30 = j14 + jArr3[13] + jArr4[0];
            long j31 = j15 + jArr3[14] + jArr4[1];
            long j32 = j24;
            long j33 = j26;
            long j34 = j28;
            long j35 = j30;
            long j36 = j16 + jArr3[15];
            int i4 = 1;
            long j37 = j20;
            long j38 = j22;
            long j39 = j21;
            long j40 = j17;
            while (i4 < 20) {
                int i5 = iArr[i4];
                int i6 = iArr2[i4];
                long j41 = j37;
                long j42 = j40 + j18;
                long jRotlXor = ThreefishEngine.rotlXor(j18, 24, j42);
                long j43 = j19 + j41;
                long jRotlXor2 = ThreefishEngine.rotlXor(j41, i3, j43);
                long j44 = j39 + j38;
                long jRotlXor3 = ThreefishEngine.rotlXor(j38, 8, j44);
                int i7 = i4;
                long j45 = j32;
                long j46 = j23 + j45;
                long jRotlXor4 = ThreefishEngine.rotlXor(j45, 47, j46);
                long j47 = j33;
                long j48 = j25 + j47;
                long[] jArr5 = jArr4;
                long jRotlXor5 = ThreefishEngine.rotlXor(j47, 8, j48);
                long[] jArr6 = jArr3;
                int[] iArr3 = iArr;
                long j49 = j34;
                long j50 = j27 + j49;
                long jRotlXor6 = ThreefishEngine.rotlXor(j49, 17, j50);
                long j51 = j35;
                long j52 = j29 + j51;
                long jRotlXor7 = ThreefishEngine.rotlXor(j51, 22, j52);
                long j53 = j36;
                long j54 = j31 + j53;
                long jRotlXor8 = ThreefishEngine.rotlXor(j53, 37, j54);
                long j55 = j42 + jRotlXor5;
                long jRotlXor9 = ThreefishEngine.rotlXor(jRotlXor5, 38, j55);
                long j56 = j43 + jRotlXor7;
                long jRotlXor10 = ThreefishEngine.rotlXor(jRotlXor7, 19, j56);
                long j57 = j46 + jRotlXor6;
                long jRotlXor11 = ThreefishEngine.rotlXor(jRotlXor6, 10, j57);
                long j58 = j44 + jRotlXor8;
                long jRotlXor12 = ThreefishEngine.rotlXor(jRotlXor8, 55, j58);
                long j59 = j50 + jRotlXor4;
                long jRotlXor13 = ThreefishEngine.rotlXor(jRotlXor4, 49, j59);
                long j60 = j52 + jRotlXor2;
                long jRotlXor14 = ThreefishEngine.rotlXor(jRotlXor2, 18, j60);
                long j61 = j54 + jRotlXor3;
                long jRotlXor15 = ThreefishEngine.rotlXor(jRotlXor3, 23, j61);
                long j62 = j48 + jRotlXor;
                long jRotlXor16 = ThreefishEngine.rotlXor(jRotlXor, 52, j62);
                long j63 = j55 + jRotlXor13;
                long jRotlXor17 = ThreefishEngine.rotlXor(jRotlXor13, 33, j63);
                long j64 = j56 + jRotlXor15;
                long jRotlXor18 = ThreefishEngine.rotlXor(jRotlXor15, 4, j64);
                long j65 = j58 + jRotlXor14;
                long jRotlXor19 = ThreefishEngine.rotlXor(jRotlXor14, 51, j65);
                long j66 = j57 + jRotlXor16;
                long jRotlXor20 = ThreefishEngine.rotlXor(jRotlXor16, 13, j66);
                long j67 = j60 + jRotlXor12;
                long jRotlXor21 = ThreefishEngine.rotlXor(jRotlXor12, 34, j67);
                long j68 = j61 + jRotlXor10;
                long jRotlXor22 = ThreefishEngine.rotlXor(jRotlXor10, 41, j68);
                long j69 = j62 + jRotlXor11;
                long jRotlXor23 = ThreefishEngine.rotlXor(jRotlXor11, 59, j69);
                long j70 = j59 + jRotlXor9;
                long jRotlXor24 = ThreefishEngine.rotlXor(jRotlXor9, 17, j70);
                long j71 = j63 + jRotlXor21;
                long jRotlXor25 = ThreefishEngine.rotlXor(jRotlXor21, 5, j71);
                long j72 = j64 + jRotlXor23;
                long jRotlXor26 = ThreefishEngine.rotlXor(jRotlXor23, 20, j72);
                long j73 = j66 + jRotlXor22;
                long jRotlXor27 = ThreefishEngine.rotlXor(jRotlXor22, 48, j73);
                long j74 = j65 + jRotlXor24;
                long jRotlXor28 = ThreefishEngine.rotlXor(jRotlXor24, 41, j74);
                long j75 = j68 + jRotlXor20;
                long jRotlXor29 = ThreefishEngine.rotlXor(jRotlXor20, 47, j75);
                long j76 = j69 + jRotlXor18;
                long jRotlXor30 = ThreefishEngine.rotlXor(jRotlXor18, 28, j76);
                long j77 = j70 + jRotlXor19;
                long jRotlXor31 = ThreefishEngine.rotlXor(jRotlXor19, 16, j77);
                long j78 = j67 + jRotlXor17;
                long jRotlXor32 = ThreefishEngine.rotlXor(jRotlXor17, 25, j78);
                long j79 = j71 + jArr6[i5];
                int i8 = i5 + 1;
                long j80 = jRotlXor29 + jArr6[i8];
                int i9 = i5 + 2;
                long j81 = j72 + jArr6[i9];
                int i10 = i5 + 3;
                long j82 = jRotlXor31 + jArr6[i10];
                int i11 = i5 + 4;
                long j83 = j74 + jArr6[i11];
                int i12 = i5 + 5;
                long j84 = jRotlXor30 + jArr6[i12];
                int i13 = i5 + 6;
                long j85 = j73 + jArr6[i13];
                int i14 = i5 + 7;
                long j86 = jRotlXor32 + jArr6[i14];
                int i15 = i5 + 8;
                long j87 = j76 + jArr6[i15];
                int i16 = i5 + 9;
                long j88 = jRotlXor28 + jArr6[i16];
                int i17 = i5 + 10;
                long j89 = j77 + jArr6[i17];
                int i18 = i5 + 11;
                long j90 = jRotlXor26 + jArr6[i18];
                int i19 = i5 + 12;
                long j91 = j78 + jArr6[i19];
                int i20 = i5 + 13;
                long j92 = jRotlXor27 + jArr6[i20] + jArr5[i6];
                int i21 = i5 + 14;
                int i22 = i6 + 1;
                long j93 = j75 + jArr6[i21] + jArr5[i22];
                int i23 = i5 + 15;
                long j94 = i7;
                long j95 = jRotlXor25 + jArr6[i23] + j94;
                long j96 = j79 + j80;
                long jRotlXor33 = ThreefishEngine.rotlXor(j80, 41, j96);
                long j97 = j81 + j82;
                long jRotlXor34 = ThreefishEngine.rotlXor(j82, i, j97);
                long j98 = j83 + j84;
                long jRotlXor35 = ThreefishEngine.rotlXor(j84, 37, j98);
                long j99 = j85 + j86;
                long jRotlXor36 = ThreefishEngine.rotlXor(j86, 31, j99);
                long j100 = j87 + j88;
                long jRotlXor37 = ThreefishEngine.rotlXor(j88, i2, j100);
                long j101 = j89 + j90;
                long jRotlXor38 = ThreefishEngine.rotlXor(j90, 47, j101);
                long j102 = j91 + j92;
                long jRotlXor39 = ThreefishEngine.rotlXor(j92, 44, j102);
                long j103 = j93 + j95;
                long jRotlXor40 = ThreefishEngine.rotlXor(j95, 30, j103);
                long j104 = j96 + jRotlXor37;
                long jRotlXor41 = ThreefishEngine.rotlXor(jRotlXor37, 16, j104);
                long j105 = j97 + jRotlXor39;
                long jRotlXor42 = ThreefishEngine.rotlXor(jRotlXor39, 34, j105);
                long j106 = j99 + jRotlXor38;
                long jRotlXor43 = ThreefishEngine.rotlXor(jRotlXor38, 56, j106);
                long j107 = j98 + jRotlXor40;
                long jRotlXor44 = ThreefishEngine.rotlXor(jRotlXor40, 51, j107);
                long j108 = j101 + jRotlXor36;
                long jRotlXor45 = ThreefishEngine.rotlXor(jRotlXor36, 4, j108);
                long j109 = j102 + jRotlXor34;
                long jRotlXor46 = ThreefishEngine.rotlXor(jRotlXor34, 53, j109);
                long j110 = j103 + jRotlXor35;
                long jRotlXor47 = ThreefishEngine.rotlXor(jRotlXor35, 42, j110);
                long j111 = j100 + jRotlXor33;
                long jRotlXor48 = ThreefishEngine.rotlXor(jRotlXor33, 41, j111);
                long j112 = j104 + jRotlXor45;
                long jRotlXor49 = ThreefishEngine.rotlXor(jRotlXor45, 31, j112);
                long j113 = j105 + jRotlXor47;
                long jRotlXor50 = ThreefishEngine.rotlXor(jRotlXor47, 44, j113);
                long j114 = j107 + jRotlXor46;
                long jRotlXor51 = ThreefishEngine.rotlXor(jRotlXor46, 47, j114);
                long j115 = j106 + jRotlXor48;
                long jRotlXor52 = ThreefishEngine.rotlXor(jRotlXor48, 46, j115);
                long j116 = j109 + jRotlXor44;
                long jRotlXor53 = ThreefishEngine.rotlXor(jRotlXor44, 19, j116);
                long j117 = j110 + jRotlXor42;
                long jRotlXor54 = ThreefishEngine.rotlXor(jRotlXor42, 42, j117);
                long j118 = j111 + jRotlXor43;
                long jRotlXor55 = ThreefishEngine.rotlXor(jRotlXor43, 44, j118);
                long j119 = j108 + jRotlXor41;
                long jRotlXor56 = ThreefishEngine.rotlXor(jRotlXor41, 25, j119);
                long j120 = j112 + jRotlXor53;
                long jRotlXor57 = ThreefishEngine.rotlXor(jRotlXor53, 9, j120);
                long j121 = j113 + jRotlXor55;
                long jRotlXor58 = ThreefishEngine.rotlXor(jRotlXor55, 48, j121);
                long j122 = j115 + jRotlXor54;
                long jRotlXor59 = ThreefishEngine.rotlXor(jRotlXor54, 35, j122);
                long j123 = j114 + jRotlXor56;
                long jRotlXor60 = ThreefishEngine.rotlXor(jRotlXor56, 52, j123);
                long j124 = j117 + jRotlXor52;
                long jRotlXor61 = ThreefishEngine.rotlXor(jRotlXor52, 23, j124);
                long j125 = j118 + jRotlXor50;
                long jRotlXor62 = ThreefishEngine.rotlXor(jRotlXor50, 31, j125);
                long j126 = j119 + jRotlXor51;
                long jRotlXor63 = ThreefishEngine.rotlXor(jRotlXor51, 37, j126);
                long j127 = j116 + jRotlXor49;
                long jRotlXor64 = ThreefishEngine.rotlXor(jRotlXor49, 20, j127);
                long j128 = jArr6[i8] + j120;
                long j129 = jRotlXor61 + jArr6[i9];
                j19 = j121 + jArr6[i10];
                long j130 = jRotlXor63 + jArr6[i11];
                long j131 = j123 + jArr6[i12];
                long j132 = jRotlXor62 + jArr6[i13];
                long j133 = j122 + jArr6[i14];
                long j134 = jRotlXor64 + jArr6[i15];
                long j135 = j125 + jArr6[i16];
                long j136 = jRotlXor60 + jArr6[i17];
                long j137 = j126 + jArr6[i18];
                j34 = jRotlXor58 + jArr6[i19];
                long j138 = j127 + jArr6[i20];
                long j139 = jRotlXor59 + jArr6[i21] + jArr5[i22];
                long j140 = j124 + jArr6[i23] + jArr5[i6 + 2];
                j36 = jRotlXor57 + jArr6[i5 + 16] + j94 + 1;
                i4 = i7 + 2;
                j23 = j133;
                j25 = j135;
                j35 = j139;
                j33 = j136;
                i3 = 13;
                i = 9;
                i2 = 12;
                j40 = j128;
                j37 = j130;
                j27 = j137;
                j18 = j129;
                j38 = j132;
                j31 = j140;
                j39 = j131;
                j29 = j138;
                iArr = iArr3;
                iArr2 = iArr2;
                j32 = j134;
                jArr4 = jArr5;
                jArr3 = jArr6;
            }
            jArr2[0] = j40;
            jArr2[1] = j18;
            jArr2[2] = j19;
            jArr2[3] = j37;
            jArr2[4] = j39;
            jArr2[5] = j38;
            jArr2[6] = j23;
            jArr2[7] = j32;
            jArr2[8] = j25;
            jArr2[9] = j33;
            jArr2[10] = j27;
            jArr2[11] = j34;
            jArr2[12] = j29;
            jArr2[13] = j35;
            jArr2[14] = j31;
            jArr2[15] = j36;
        }
    }

    private static final class Threefish256Cipher extends ThreefishCipher {
        private static final int ROTATION_0_0 = 14;
        private static final int ROTATION_0_1 = 16;
        private static final int ROTATION_1_0 = 52;
        private static final int ROTATION_1_1 = 57;
        private static final int ROTATION_2_0 = 23;
        private static final int ROTATION_2_1 = 40;
        private static final int ROTATION_3_0 = 5;
        private static final int ROTATION_3_1 = 37;
        private static final int ROTATION_4_0 = 25;
        private static final int ROTATION_4_1 = 33;
        private static final int ROTATION_5_0 = 46;
        private static final int ROTATION_5_1 = 12;
        private static final int ROTATION_6_0 = 58;
        private static final int ROTATION_6_1 = 22;
        private static final int ROTATION_7_0 = 32;
        private static final int ROTATION_7_1 = 32;

        public Threefish256Cipher(long[] jArr, long[] jArr2) {
            super(jArr, jArr2);
        }

        @Override // org.bouncycastle.crypto.engines.ThreefishEngine.ThreefishCipher
        void decryptBlock(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.kw;
            long[] jArr4 = this.t;
            int[] iArr = ThreefishEngine.MOD5;
            int[] iArr2 = ThreefishEngine.MOD3;
            if (jArr3.length != 9) {
                throw new IllegalArgumentException();
            }
            if (jArr4.length != 5) {
                throw new IllegalArgumentException();
            }
            long j = jArr[0];
            int i = 1;
            long j2 = jArr[1];
            char c = 2;
            long j3 = jArr[2];
            char c2 = 3;
            long j4 = jArr[3];
            int i2 = 17;
            while (i2 >= i) {
                int i3 = iArr[i2];
                int i4 = iArr2[i2];
                int i5 = i3 + 1;
                long j5 = j - jArr3[i5];
                int i6 = i3 + 2;
                int i7 = i4 + 1;
                long j6 = j2 - (jArr3[i6] + jArr4[i7]);
                int i8 = i3 + 3;
                long j7 = j3 - (jArr3[i8] + jArr4[i4 + 2]);
                char c3 = c2;
                long j8 = i2;
                int i9 = i;
                long jXorRotr = ThreefishEngine.xorRotr(j4 - ((jArr3[i3 + 4] + j8) + 1), 32, j5);
                long j9 = j5 - jXorRotr;
                long jXorRotr2 = ThreefishEngine.xorRotr(j6, 32, j7);
                long j10 = j7 - jXorRotr2;
                long jXorRotr3 = ThreefishEngine.xorRotr(jXorRotr2, 58, j9);
                long j11 = j9 - jXorRotr3;
                long jXorRotr4 = ThreefishEngine.xorRotr(jXorRotr, 22, j10);
                long j12 = j10 - jXorRotr4;
                long jXorRotr5 = ThreefishEngine.xorRotr(jXorRotr4, 46, j11);
                long j13 = j11 - jXorRotr5;
                long jXorRotr6 = ThreefishEngine.xorRotr(jXorRotr3, 12, j12);
                long j14 = j12 - jXorRotr6;
                long jXorRotr7 = ThreefishEngine.xorRotr(jXorRotr6, 25, j13);
                long jXorRotr8 = ThreefishEngine.xorRotr(jXorRotr5, 33, j14);
                long j15 = (j13 - jXorRotr7) - jArr3[i3];
                long j16 = jXorRotr7 - (jArr3[i5] + jArr4[i4]);
                long j17 = (j14 - jXorRotr8) - (jArr3[i6] + jArr4[i7]);
                long jXorRotr9 = ThreefishEngine.xorRotr(jXorRotr8 - (jArr3[i8] + j8), 5, j15);
                long j18 = j15 - jXorRotr9;
                long jXorRotr10 = ThreefishEngine.xorRotr(j16, 37, j17);
                long j19 = j17 - jXorRotr10;
                long jXorRotr11 = ThreefishEngine.xorRotr(jXorRotr10, 23, j18);
                long j20 = j18 - jXorRotr11;
                long jXorRotr12 = ThreefishEngine.xorRotr(jXorRotr9, 40, j19);
                long j21 = j19 - jXorRotr12;
                long jXorRotr13 = ThreefishEngine.xorRotr(jXorRotr12, 52, j20);
                long j22 = j20 - jXorRotr13;
                long jXorRotr14 = ThreefishEngine.xorRotr(jXorRotr11, 57, j21);
                long j23 = j21 - jXorRotr14;
                long jXorRotr15 = ThreefishEngine.xorRotr(jXorRotr14, 14, j22);
                long jXorRotr16 = ThreefishEngine.xorRotr(jXorRotr13, 16, j23);
                j3 = j23 - jXorRotr16;
                i2 -= 2;
                i = i9;
                j4 = jXorRotr16;
                c = c;
                j = j22 - jXorRotr15;
                c2 = c3;
                j2 = jXorRotr15;
            }
            char c4 = c;
            char c5 = c2;
            int i10 = i;
            long j24 = j - jArr3[0];
            long j25 = j2 - (jArr3[i10] + jArr4[0]);
            long j26 = j3 - (jArr3[c4] + jArr4[i10]);
            long j27 = j4 - jArr3[c5];
            jArr2[0] = j24;
            jArr2[i10] = j25;
            jArr2[c4] = j26;
            jArr2[c5] = j27;
        }

        @Override // org.bouncycastle.crypto.engines.ThreefishEngine.ThreefishCipher
        void encryptBlock(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.kw;
            long[] jArr4 = this.t;
            int[] iArr = ThreefishEngine.MOD5;
            int[] iArr2 = ThreefishEngine.MOD3;
            if (jArr3.length != 9) {
                throw new IllegalArgumentException();
            }
            int i = 5;
            if (jArr4.length != 5) {
                throw new IllegalArgumentException();
            }
            long j = jArr[0];
            boolean z = true;
            long j2 = jArr[1];
            long j3 = jArr[2];
            char c = 3;
            long j4 = jArr[3];
            long j5 = j + jArr3[0];
            long j6 = j2 + jArr3[1] + jArr4[0];
            long j7 = j3 + jArr3[2] + jArr4[1];
            int i2 = 1;
            long j8 = j4 + jArr3[3];
            long j9 = j7;
            while (i2 < 18) {
                int i3 = iArr[i2];
                int i4 = iArr2[i2];
                long j10 = j5 + j6;
                boolean z2 = z;
                long jRotlXor = ThreefishEngine.rotlXor(j6, 14, j10);
                char c2 = c;
                long j11 = j9 + j8;
                long jRotlXor2 = ThreefishEngine.rotlXor(j8, 16, j11);
                long j12 = j10 + jRotlXor2;
                long jRotlXor3 = ThreefishEngine.rotlXor(jRotlXor2, 52, j12);
                long j13 = j11 + jRotlXor;
                long jRotlXor4 = ThreefishEngine.rotlXor(jRotlXor, 57, j13);
                long j14 = j12 + jRotlXor4;
                long jRotlXor5 = ThreefishEngine.rotlXor(jRotlXor4, 23, j14);
                long j15 = j13 + jRotlXor3;
                long jRotlXor6 = ThreefishEngine.rotlXor(jRotlXor3, 40, j15);
                long j16 = j14 + jRotlXor6;
                long jRotlXor7 = ThreefishEngine.rotlXor(jRotlXor6, i, j16);
                long j17 = j15 + jRotlXor5;
                long jRotlXor8 = ThreefishEngine.rotlXor(jRotlXor5, 37, j17);
                long j18 = j16 + jArr3[i3];
                int i5 = i3 + 1;
                long j19 = jRotlXor8 + jArr3[i5] + jArr4[i4];
                int i6 = i3 + 2;
                int i7 = i4 + 1;
                long j20 = j17 + jArr3[i6] + jArr4[i7];
                int i8 = i3 + 3;
                long j21 = i2;
                long j22 = jRotlXor7 + jArr3[i8] + j21;
                long[] jArr5 = jArr4;
                long[] jArr6 = jArr3;
                long j23 = j18 + j19;
                long jRotlXor9 = ThreefishEngine.rotlXor(j19, 25, j23);
                long j24 = j20 + j22;
                long jRotlXor10 = ThreefishEngine.rotlXor(j22, 33, j24);
                long j25 = j23 + jRotlXor10;
                long jRotlXor11 = ThreefishEngine.rotlXor(jRotlXor10, 46, j25);
                long j26 = j24 + jRotlXor9;
                long jRotlXor12 = ThreefishEngine.rotlXor(jRotlXor9, 12, j26);
                long j27 = j25 + jRotlXor12;
                long jRotlXor13 = ThreefishEngine.rotlXor(jRotlXor12, 58, j27);
                long j28 = j26 + jRotlXor11;
                long jRotlXor14 = ThreefishEngine.rotlXor(jRotlXor11, 22, j28);
                long j29 = j27 + jRotlXor14;
                long jRotlXor15 = ThreefishEngine.rotlXor(jRotlXor14, 32, j29);
                long j30 = j28 + jRotlXor13;
                long jRotlXor16 = ThreefishEngine.rotlXor(jRotlXor13, 32, j30);
                long j31 = j29 + jArr6[i5];
                long j32 = jRotlXor16 + jArr6[i6] + jArr5[i7];
                j9 = j30 + jArr6[i8] + jArr5[i4 + 2];
                j8 = jArr6[i3 + 4] + j21 + 1 + jRotlXor15;
                i2 += 2;
                j6 = j32;
                z = z2;
                c = c2;
                i = 5;
                j5 = j31;
                jArr3 = jArr6;
                jArr4 = jArr5;
            }
            jArr2[0] = j5;
            jArr2[z ? 1 : 0] = j6;
            jArr2[2] = j9;
            jArr2[c] = j8;
        }
    }

    private static final class Threefish512Cipher extends ThreefishCipher {
        private static final int ROTATION_0_0 = 46;
        private static final int ROTATION_0_1 = 36;
        private static final int ROTATION_0_2 = 19;
        private static final int ROTATION_0_3 = 37;
        private static final int ROTATION_1_0 = 33;
        private static final int ROTATION_1_1 = 27;
        private static final int ROTATION_1_2 = 14;
        private static final int ROTATION_1_3 = 42;
        private static final int ROTATION_2_0 = 17;
        private static final int ROTATION_2_1 = 49;
        private static final int ROTATION_2_2 = 36;
        private static final int ROTATION_2_3 = 39;
        private static final int ROTATION_3_0 = 44;
        private static final int ROTATION_3_1 = 9;
        private static final int ROTATION_3_2 = 54;
        private static final int ROTATION_3_3 = 56;
        private static final int ROTATION_4_0 = 39;
        private static final int ROTATION_4_1 = 30;
        private static final int ROTATION_4_2 = 34;
        private static final int ROTATION_4_3 = 24;
        private static final int ROTATION_5_0 = 13;
        private static final int ROTATION_5_1 = 50;
        private static final int ROTATION_5_2 = 10;
        private static final int ROTATION_5_3 = 17;
        private static final int ROTATION_6_0 = 25;
        private static final int ROTATION_6_1 = 29;
        private static final int ROTATION_6_2 = 39;
        private static final int ROTATION_6_3 = 43;
        private static final int ROTATION_7_0 = 8;
        private static final int ROTATION_7_1 = 35;
        private static final int ROTATION_7_2 = 56;
        private static final int ROTATION_7_3 = 22;

        protected Threefish512Cipher(long[] jArr, long[] jArr2) {
            super(jArr, jArr2);
        }

        @Override // org.bouncycastle.crypto.engines.ThreefishEngine.ThreefishCipher
        public void decryptBlock(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.kw;
            long[] jArr4 = this.t;
            int[] iArr = ThreefishEngine.MOD9;
            int[] iArr2 = ThreefishEngine.MOD3;
            if (jArr3.length != 17) {
                throw new IllegalArgumentException();
            }
            char c = 5;
            if (jArr4.length != 5) {
                throw new IllegalArgumentException();
            }
            long j = jArr[0];
            int i = 1;
            long j2 = jArr[1];
            char c2 = 2;
            long j3 = jArr[2];
            char c3 = 3;
            long jXorRotr = jArr[3];
            long j4 = jArr[4];
            long jXorRotr2 = jArr[5];
            long j5 = jArr[6];
            long jXorRotr3 = jArr[7];
            int i2 = 17;
            while (i2 >= i) {
                int i3 = iArr[i2];
                int i4 = iArr2[i2];
                int i5 = i3 + 1;
                long j6 = j - jArr3[i5];
                int i6 = i3 + 2;
                long j7 = j2 - jArr3[i6];
                int i7 = i3 + 3;
                long j8 = j3 - jArr3[i7];
                int i8 = i3 + 4;
                char c4 = c;
                long j9 = jXorRotr - jArr3[i8];
                int i9 = i3 + 5;
                char c5 = c2;
                long j10 = j4 - jArr3[i9];
                int i10 = i3 + 6;
                int i11 = i4 + 1;
                int i12 = i;
                long j11 = jXorRotr2 - (jArr3[i10] + jArr4[i11]);
                int i13 = i3 + 7;
                long[] jArr5 = jArr4;
                long[] jArr6 = jArr3;
                long j12 = j5 - (jArr3[i13] + jArr4[i4 + 2]);
                int[] iArr3 = iArr;
                long j13 = i2;
                long j14 = jXorRotr3 - ((jArr6[i3 + 8] + j13) + 1);
                int i14 = i2;
                long jXorRotr4 = ThreefishEngine.xorRotr(j7, 8, j12);
                long j15 = j12 - jXorRotr4;
                long jXorRotr5 = ThreefishEngine.xorRotr(j14, 35, j6);
                long j16 = j6 - jXorRotr5;
                long jXorRotr6 = ThreefishEngine.xorRotr(j11, 56, j8);
                long j17 = j8 - jXorRotr6;
                long jXorRotr7 = ThreefishEngine.xorRotr(j9, 22, j10);
                long j18 = j10 - jXorRotr7;
                long jXorRotr8 = ThreefishEngine.xorRotr(jXorRotr4, 25, j18);
                long j19 = j18 - jXorRotr8;
                long jXorRotr9 = ThreefishEngine.xorRotr(jXorRotr7, 29, j15);
                long j20 = j15 - jXorRotr9;
                long jXorRotr10 = ThreefishEngine.xorRotr(jXorRotr6, 39, j16);
                long j21 = j16 - jXorRotr10;
                long jXorRotr11 = ThreefishEngine.xorRotr(jXorRotr5, 43, j17);
                long j22 = j17 - jXorRotr11;
                long jXorRotr12 = ThreefishEngine.xorRotr(jXorRotr8, 13, j22);
                long j23 = j22 - jXorRotr12;
                long jXorRotr13 = ThreefishEngine.xorRotr(jXorRotr11, 50, j19);
                long j24 = j19 - jXorRotr13;
                long jXorRotr14 = ThreefishEngine.xorRotr(jXorRotr10, 10, j20);
                long j25 = j20 - jXorRotr14;
                long jXorRotr15 = ThreefishEngine.xorRotr(jXorRotr9, 17, j21);
                long j26 = j21 - jXorRotr15;
                long jXorRotr16 = ThreefishEngine.xorRotr(jXorRotr12, 39, j26);
                long jXorRotr17 = ThreefishEngine.xorRotr(jXorRotr15, 30, j23);
                long j27 = j23 - jXorRotr17;
                long jXorRotr18 = ThreefishEngine.xorRotr(jXorRotr14, 34, j24);
                long jXorRotr19 = ThreefishEngine.xorRotr(jXorRotr13, 24, j25);
                long j28 = j25 - jXorRotr19;
                long j29 = (j26 - jXorRotr16) - jArr6[i3];
                long j30 = jXorRotr16 - jArr6[i5];
                long j31 = j27 - jArr6[i6];
                long j32 = jXorRotr17 - jArr6[i7];
                long j33 = (j24 - jXorRotr18) - jArr6[i8];
                long j34 = jXorRotr18 - (jArr6[i9] + jArr5[i4]);
                long j35 = j28 - (jArr6[i10] + jArr5[i11]);
                long j36 = jXorRotr19 - (jArr6[i13] + j13);
                long jXorRotr20 = ThreefishEngine.xorRotr(j30, 44, j35);
                long j37 = j35 - jXorRotr20;
                long jXorRotr21 = ThreefishEngine.xorRotr(j36, 9, j29);
                long j38 = j29 - jXorRotr21;
                long jXorRotr22 = ThreefishEngine.xorRotr(j34, 54, j31);
                long j39 = j31 - jXorRotr22;
                long jXorRotr23 = ThreefishEngine.xorRotr(j32, 56, j33);
                long j40 = j33 - jXorRotr23;
                long jXorRotr24 = ThreefishEngine.xorRotr(jXorRotr20, 17, j40);
                long j41 = j40 - jXorRotr24;
                long jXorRotr25 = ThreefishEngine.xorRotr(jXorRotr23, 49, j37);
                long j42 = j37 - jXorRotr25;
                long jXorRotr26 = ThreefishEngine.xorRotr(jXorRotr22, 36, j38);
                long j43 = j38 - jXorRotr26;
                long jXorRotr27 = ThreefishEngine.xorRotr(jXorRotr21, 39, j39);
                long j44 = j39 - jXorRotr27;
                long jXorRotr28 = ThreefishEngine.xorRotr(jXorRotr24, 33, j44);
                long j45 = j44 - jXorRotr28;
                long jXorRotr29 = ThreefishEngine.xorRotr(jXorRotr27, 27, j41);
                long j46 = j41 - jXorRotr29;
                long jXorRotr30 = ThreefishEngine.xorRotr(jXorRotr26, 14, j42);
                long j47 = j42 - jXorRotr30;
                long jXorRotr31 = ThreefishEngine.xorRotr(jXorRotr25, 42, j43);
                long j48 = j43 - jXorRotr31;
                long jXorRotr32 = ThreefishEngine.xorRotr(jXorRotr28, 46, j48);
                long j49 = j48 - jXorRotr32;
                jXorRotr = ThreefishEngine.xorRotr(jXorRotr31, 36, j45);
                j3 = j45 - jXorRotr;
                jXorRotr2 = ThreefishEngine.xorRotr(jXorRotr30, 19, j46);
                long j50 = j46 - jXorRotr2;
                jXorRotr3 = ThreefishEngine.xorRotr(jXorRotr29, 37, j47);
                j5 = j47 - jXorRotr3;
                i2 = i14 - 2;
                j = j49;
                j2 = jXorRotr32;
                i = i12;
                c = c4;
                c2 = c5;
                iArr = iArr3;
                iArr2 = iArr2;
                c3 = c3;
                j4 = j50;
                jArr3 = jArr6;
                jArr4 = jArr5;
            }
            long[] jArr7 = jArr4;
            long[] jArr8 = jArr3;
            char c6 = c;
            int i15 = i;
            char c7 = c2;
            char c8 = c3;
            long j51 = j - jArr8[0];
            long j52 = j2 - jArr8[i15];
            long j53 = j3 - jArr8[c7];
            long j54 = jXorRotr - jArr8[c8];
            long j55 = j4 - jArr8[4];
            long j56 = jXorRotr2 - (jArr8[c6] + jArr7[0]);
            long j57 = j5 - (jArr8[6] + jArr7[i15]);
            long j58 = jXorRotr3 - jArr8[7];
            jArr2[0] = j51;
            jArr2[i15] = j52;
            jArr2[c7] = j53;
            jArr2[c8] = j54;
            jArr2[4] = j55;
            jArr2[c6] = j56;
            jArr2[6] = j57;
            jArr2[7] = j58;
        }

        @Override // org.bouncycastle.crypto.engines.ThreefishEngine.ThreefishCipher
        public void encryptBlock(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.kw;
            long[] jArr4 = this.t;
            int[] iArr = ThreefishEngine.MOD9;
            int[] iArr2 = ThreefishEngine.MOD3;
            if (jArr3.length != 17) {
                throw new IllegalArgumentException();
            }
            if (jArr4.length != 5) {
                throw new IllegalArgumentException();
            }
            long j = jArr[0];
            long j2 = jArr[1];
            long j3 = jArr[2];
            char c = 3;
            long j4 = jArr[3];
            long j5 = jArr[4];
            long j6 = jArr[5];
            long j7 = jArr[6];
            long j8 = jArr[7];
            long j9 = j + jArr3[0];
            long j10 = j2 + jArr3[1];
            long j11 = j3 + jArr3[2];
            long j12 = j4 + jArr3[3];
            long j13 = j5 + jArr3[4];
            long j14 = j6 + jArr3[5] + jArr4[0];
            long j15 = j7 + jArr3[6] + jArr4[1];
            int i = 1;
            long j16 = j9;
            long j17 = j12;
            long j18 = j8 + jArr3[7];
            long j19 = j11;
            long j20 = j14;
            while (i < 18) {
                int i2 = iArr[i];
                int i3 = iArr2[i];
                long j21 = j17;
                long j22 = j16 + j10;
                long jRotlXor = ThreefishEngine.rotlXor(j10, 46, j22);
                long[] jArr5 = jArr4;
                long[] jArr6 = jArr3;
                long j23 = j19 + j21;
                char c2 = c;
                int[] iArr3 = iArr;
                long jRotlXor2 = ThreefishEngine.rotlXor(j21, 36, j23);
                long j24 = j13 + j20;
                long jRotlXor3 = ThreefishEngine.rotlXor(j20, 19, j24);
                long j25 = j15 + j18;
                long jRotlXor4 = ThreefishEngine.rotlXor(j18, 37, j25);
                long j26 = j23 + jRotlXor;
                long jRotlXor5 = ThreefishEngine.rotlXor(jRotlXor, 33, j26);
                long j27 = j24 + jRotlXor4;
                long jRotlXor6 = ThreefishEngine.rotlXor(jRotlXor4, 27, j27);
                long j28 = j25 + jRotlXor3;
                long jRotlXor7 = ThreefishEngine.rotlXor(jRotlXor3, 14, j28);
                long j29 = j22 + jRotlXor2;
                long jRotlXor8 = ThreefishEngine.rotlXor(jRotlXor2, 42, j29);
                long j30 = j27 + jRotlXor5;
                long jRotlXor9 = ThreefishEngine.rotlXor(jRotlXor5, 17, j30);
                long j31 = j28 + jRotlXor8;
                long jRotlXor10 = ThreefishEngine.rotlXor(jRotlXor8, 49, j31);
                long j32 = j29 + jRotlXor7;
                long jRotlXor11 = ThreefishEngine.rotlXor(jRotlXor7, 36, j32);
                long j33 = j26 + jRotlXor6;
                long jRotlXor12 = ThreefishEngine.rotlXor(jRotlXor6, 39, j33);
                long j34 = j31 + jRotlXor9;
                long jRotlXor13 = ThreefishEngine.rotlXor(jRotlXor9, 44, j34);
                long j35 = j32 + jRotlXor12;
                long jRotlXor14 = ThreefishEngine.rotlXor(jRotlXor12, 9, j35);
                long j36 = j33 + jRotlXor11;
                long jRotlXor15 = ThreefishEngine.rotlXor(jRotlXor11, 54, j36);
                long j37 = j30 + jRotlXor10;
                long jRotlXor16 = ThreefishEngine.rotlXor(jRotlXor10, 56, j37);
                long j38 = j35 + jArr6[i2];
                int i4 = i2 + 1;
                long j39 = jRotlXor13 + jArr6[i4];
                int i5 = i2 + 2;
                long j40 = j36 + jArr6[i5];
                int i6 = i2 + 3;
                long j41 = jRotlXor16 + jArr6[i6];
                int i7 = i2 + 4;
                long j42 = j37 + jArr6[i7];
                int i8 = i2 + 5;
                long j43 = jRotlXor15 + jArr6[i8] + jArr5[i3];
                int i9 = i2 + 6;
                int i10 = i3 + 1;
                long j44 = j34 + jArr6[i9] + jArr5[i10];
                int i11 = i2 + 7;
                long j45 = i;
                long j46 = jRotlXor14 + jArr6[i11] + j45;
                int i12 = i;
                long j47 = j38 + j39;
                long jRotlXor17 = ThreefishEngine.rotlXor(j39, 39, j47);
                long j48 = j40 + j41;
                long jRotlXor18 = ThreefishEngine.rotlXor(j41, 30, j48);
                long j49 = j42 + j43;
                long jRotlXor19 = ThreefishEngine.rotlXor(j43, 34, j49);
                long j50 = j44 + j46;
                long jRotlXor20 = ThreefishEngine.rotlXor(j46, 24, j50);
                long j51 = j48 + jRotlXor17;
                long jRotlXor21 = ThreefishEngine.rotlXor(jRotlXor17, 13, j51);
                long j52 = j49 + jRotlXor20;
                long jRotlXor22 = ThreefishEngine.rotlXor(jRotlXor20, 50, j52);
                long j53 = j50 + jRotlXor19;
                long jRotlXor23 = ThreefishEngine.rotlXor(jRotlXor19, 10, j53);
                long j54 = j47 + jRotlXor18;
                long jRotlXor24 = ThreefishEngine.rotlXor(jRotlXor18, 17, j54);
                long j55 = j52 + jRotlXor21;
                long jRotlXor25 = ThreefishEngine.rotlXor(jRotlXor21, 25, j55);
                long j56 = j53 + jRotlXor24;
                long jRotlXor26 = ThreefishEngine.rotlXor(jRotlXor24, 29, j56);
                long j57 = j54 + jRotlXor23;
                long jRotlXor27 = ThreefishEngine.rotlXor(jRotlXor23, 39, j57);
                long j58 = j51 + jRotlXor22;
                long jRotlXor28 = ThreefishEngine.rotlXor(jRotlXor22, 43, j58);
                long j59 = j56 + jRotlXor25;
                long jRotlXor29 = ThreefishEngine.rotlXor(jRotlXor25, 8, j59);
                long j60 = j57 + jRotlXor28;
                long jRotlXor30 = ThreefishEngine.rotlXor(jRotlXor28, 35, j60);
                long j61 = j58 + jRotlXor27;
                long jRotlXor31 = ThreefishEngine.rotlXor(jRotlXor27, 56, j61);
                long j62 = j55 + jRotlXor26;
                long jRotlXor32 = ThreefishEngine.rotlXor(jRotlXor26, 22, j62);
                long j63 = jArr6[i4] + j60;
                long j64 = jRotlXor29 + jArr6[i5];
                long j65 = j61 + jArr6[i6];
                long j66 = jRotlXor32 + jArr6[i7];
                j13 = j62 + jArr6[i8];
                j20 = jRotlXor31 + jArr6[i9] + jArr5[i10];
                j15 = j59 + jArr6[i11] + jArr5[i3 + 2];
                j19 = j65;
                i = i12 + 2;
                j16 = j63;
                c = c2;
                j17 = j66;
                j10 = j64;
                iArr = iArr3;
                iArr2 = iArr2;
                j18 = jRotlXor30 + jArr6[i2 + 8] + j45 + 1;
                jArr3 = jArr6;
                jArr4 = jArr5;
            }
            jArr2[0] = j16;
            jArr2[1] = j10;
            jArr2[2] = j19;
            jArr2[c] = j17;
            jArr2[4] = j13;
            jArr2[5] = j20;
            jArr2[6] = j15;
            jArr2[7] = j18;
        }
    }

    private static abstract class ThreefishCipher {
        protected final long[] kw;
        protected final long[] t;

        protected ThreefishCipher(long[] jArr, long[] jArr2) {
            this.kw = jArr;
            this.t = jArr2;
        }

        abstract void decryptBlock(long[] jArr, long[] jArr2);

        abstract void encryptBlock(long[] jArr, long[] jArr2);
    }

    static {
        int[] iArr = new int[80];
        MOD9 = iArr;
        MOD17 = new int[iArr.length];
        MOD5 = new int[iArr.length];
        MOD3 = new int[iArr.length];
        int i = 0;
        while (true) {
            int[] iArr2 = MOD9;
            if (i >= iArr2.length) {
                return;
            }
            MOD17[i] = i % 17;
            iArr2[i] = i % 9;
            MOD5[i] = i % 5;
            MOD3[i] = i % 3;
            i++;
        }
    }

    public ThreefishEngine(int i) {
        ThreefishCipher threefish256Cipher;
        int i2 = i / 8;
        this.blocksizeBytes = i2;
        int i3 = i2 / 8;
        this.blocksizeWords = i3;
        this.currentBlock = new long[i3];
        this.kw = new long[(i3 * 2) + 1];
        if (i == 256) {
            threefish256Cipher = new Threefish256Cipher(this.kw, this.t);
        } else if (i == 512) {
            threefish256Cipher = new Threefish512Cipher(this.kw, this.t);
        } else {
            if (i != 1024) {
                throw new IllegalArgumentException("Invalid blocksize - Threefish is defined with block size of 256, 512, or 1024 bits");
            }
            threefish256Cipher = new Threefish1024Cipher(this.kw, this.t);
        }
        this.cipher = threefish256Cipher;
    }

    public static long bytesToWord(byte[] bArr, int i) {
        return Pack.littleEndianToLong(bArr, i);
    }

    static long rotlXor(long j, int i, long j2) {
        return ((j >>> (-i)) | (j << i)) ^ j2;
    }

    private void setKey(long[] jArr) {
        if (jArr.length != this.blocksizeWords) {
            throw new IllegalArgumentException("Threefish key must be same size as block (" + this.blocksizeWords + " words)");
        }
        long j = C_240;
        int i = 0;
        while (true) {
            int i2 = this.blocksizeWords;
            long[] jArr2 = this.kw;
            if (i >= i2) {
                jArr2[i2] = j;
                System.arraycopy(jArr2, 0, jArr2, i2 + 1, i2);
                return;
            } else {
                long j2 = jArr[i];
                jArr2[i] = j2;
                j ^= j2;
                i++;
            }
        }
    }

    private void setTweak(long[] jArr) {
        if (jArr.length != 2) {
            throw new IllegalArgumentException("Tweak must be 2 words.");
        }
        long[] jArr2 = this.t;
        long j = jArr[0];
        jArr2[0] = j;
        long j2 = jArr[1];
        jArr2[1] = j2;
        jArr2[2] = j ^ j2;
        jArr2[3] = j;
        jArr2[4] = j2;
    }

    public static void wordToBytes(long j, byte[] bArr, int i) {
        Pack.longToLittleEndian(j, bArr, i);
    }

    static long xorRotr(long j, int i, long j2) {
        long j3 = j ^ j2;
        return (j3 << (-i)) | (j3 >>> i);
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "Threefish-" + (this.blocksizeBytes * 8);
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return this.blocksizeBytes;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        byte[] key;
        byte[] tweak;
        long[] jArr;
        long[] jArr2 = null;
        if (cipherParameters instanceof TweakableBlockCipherParameters) {
            TweakableBlockCipherParameters tweakableBlockCipherParameters = (TweakableBlockCipherParameters) cipherParameters;
            key = tweakableBlockCipherParameters.getKey().getKey();
            tweak = tweakableBlockCipherParameters.getTweak();
        } else {
            if (!(cipherParameters instanceof KeyParameter)) {
                throw new IllegalArgumentException("Invalid parameter passed to Threefish init - " + cipherParameters.getClass().getName());
            }
            key = ((KeyParameter) cipherParameters).getKey();
            tweak = null;
        }
        if (key == null) {
            jArr = null;
        } else {
            if (key.length != this.blocksizeBytes) {
                throw new IllegalArgumentException("Threefish key must be same size as block (" + this.blocksizeBytes + " bytes)");
            }
            jArr = new long[this.blocksizeWords];
            Pack.littleEndianToLong(key, 0, jArr);
        }
        if (tweak != null) {
            if (tweak.length != 16) {
                throw new IllegalArgumentException("Threefish tweak must be 16 bytes");
            }
            jArr2 = new long[2];
            Pack.littleEndianToLong(tweak, 0, jArr2);
        }
        init(z, jArr, jArr2);
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties(getAlgorithmName(), 256, cipherParameters, Utils.getPurpose(z)));
    }

    public void init(boolean z, long[] jArr, long[] jArr2) {
        this.forEncryption = z;
        if (jArr != null) {
            setKey(jArr);
        }
        if (jArr2 != null) {
            setTweak(jArr2);
        }
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) throws IllegalStateException, DataLengthException {
        int i3 = this.blocksizeBytes;
        if (i + i3 > bArr.length) {
            throw new DataLengthException("Input buffer too short");
        }
        if (i3 + i2 > bArr2.length) {
            throw new OutputLengthException("Output buffer too short");
        }
        Pack.littleEndianToLong(bArr, i, this.currentBlock);
        long[] jArr = this.currentBlock;
        processBlock(jArr, jArr);
        Pack.longToLittleEndian(this.currentBlock, bArr2, i2);
        return this.blocksizeBytes;
    }

    public int processBlock(long[] jArr, long[] jArr2) throws IllegalStateException, DataLengthException {
        long[] jArr3 = this.kw;
        int i = this.blocksizeWords;
        if (jArr3[i] == 0) {
            throw new IllegalStateException("Threefish engine not initialised");
        }
        if (jArr.length != i) {
            throw new DataLengthException("Input buffer too short");
        }
        if (jArr2.length != i) {
            throw new OutputLengthException("Output buffer too short");
        }
        boolean z = this.forEncryption;
        ThreefishCipher threefishCipher = this.cipher;
        if (z) {
            threefishCipher.encryptBlock(jArr, jArr2);
        } else {
            threefishCipher.decryptBlock(jArr, jArr2);
        }
        return this.blocksizeWords;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
    }
}
