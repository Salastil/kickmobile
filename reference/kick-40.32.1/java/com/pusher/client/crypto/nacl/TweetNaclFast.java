package com.pusher.client.crypto.nacl;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes8.dex */
public final class TweetNaclFast {
    private static final byte[] sigma = {101, 120, 112, 97, 110, 100, 32, 51, 50, 45, 98, 121, 116, 101, 32, 107};

    public static final class SecretBox {
        public static final int boxzerobytesLength = 16;
        public static final int nonceLength = 24;
        public static final int zerobytesLength = 32;
        private final byte[] key;
        private final AtomicLong nonce;

        public SecretBox(byte[] bArr) {
            this(bArr, 68L);
        }

        public SecretBox(byte[] bArr, long j) {
            this.key = bArr;
            this.nonce = new AtomicLong(j);
        }

        public byte[] open(byte[] bArr, byte[] bArr2) {
            if (bArr == null) {
                return null;
            }
            return open(bArr, 0, bArr.length, bArr2);
        }

        public byte[] open(byte[] bArr, int i, int i2, byte[] bArr2) {
            if (bArr == null || bArr.length < i + i2 || i2 < 16 || bArr2 == null || bArr2.length != 24) {
                return null;
            }
            int i3 = i2 + 16;
            byte[] bArr3 = new byte[i3];
            byte[] bArr4 = new byte[i3];
            for (int i4 = 0; i4 < i2; i4++) {
                bArr3[i4 + 16] = bArr[i4 + i];
            }
            if (TweetNaclFast.crypto_secretbox_open(bArr4, bArr3, i3, bArr2, this.key) != 0) {
                return null;
            }
            int i5 = i2 - 16;
            byte[] bArr5 = new byte[i5];
            for (int i6 = 0; i6 < i5; i6++) {
                bArr5[i6] = bArr4[i6 + 32];
            }
            return bArr5;
        }
    }

    private static int vn(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            i4 |= (bArr[i5 + i] ^ bArr2[i5 + i2]) & 255;
        }
        return (((i4 - 1) >>> 8) & 1) - 1;
    }

    private static int crypto_verify_16(byte[] bArr, int i, byte[] bArr2, int i2) {
        return vn(bArr, i, bArr2, i2, 16);
    }

    private static void core_salsa20(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        int i = (bArr4[0] & 255) | ((bArr4[1] & 255) << 8) | ((bArr4[2] & 255) << 16) | ((bArr4[3] & 255) << 24);
        int i2 = (bArr3[0] & 255) | ((bArr3[1] & 255) << 8) | ((bArr3[2] & 255) << 16) | ((bArr3[3] & 255) << 24);
        int i3 = (bArr3[4] & 255) | ((bArr3[5] & 255) << 8) | ((bArr3[6] & 255) << 16) | ((bArr3[7] & 255) << 24);
        int i4 = ((bArr3[9] & 255) << 8) | (bArr3[8] & 255) | ((bArr3[10] & 255) << 16) | ((bArr3[11] & 255) << 24);
        int i5 = (bArr3[12] & 255) | ((bArr3[13] & 255) << 8) | ((bArr3[14] & 255) << 16) | ((bArr3[15] & 255) << 24);
        int i6 = (bArr4[4] & 255) | ((bArr4[5] & 255) << 8) | ((bArr4[6] & 255) << 16) | ((bArr4[7] & 255) << 24);
        int i7 = (bArr2[0] & 255) | ((bArr2[1] & 255) << 8) | ((bArr2[2] & 255) << 16) | ((bArr2[3] & 255) << 24);
        int i8 = (bArr2[4] & 255) | ((bArr2[5] & 255) << 8) | ((bArr2[6] & 255) << 16) | ((bArr2[7] & 255) << 24);
        int i9 = (bArr2[8] & 255) | ((bArr2[9] & 255) << 8) | ((bArr2[10] & 255) << 16) | ((bArr2[11] & 255) << 24);
        int i10 = (bArr2[12] & 255) | ((bArr2[13] & 255) << 8) | ((bArr2[14] & 255) << 16) | ((bArr2[15] & 255) << 24);
        int i11 = (bArr4[8] & 255) | ((bArr4[9] & 255) << 8) | ((bArr4[10] & 255) << 16) | ((bArr4[11] & 255) << 24);
        int i12 = (bArr3[16] & 255) | ((bArr3[17] & 255) << 8) | ((bArr3[18] & 255) << 16) | ((bArr3[19] & 255) << 24);
        int i13 = (bArr3[20] & 255) | ((bArr3[21] & 255) << 8) | ((bArr3[22] & 255) << 16) | ((bArr3[23] & 255) << 24);
        int i14 = (bArr3[24] & 255) | ((bArr3[25] & 255) << 8) | ((bArr3[26] & 255) << 16) | ((bArr3[27] & 255) << 24);
        int i15 = (bArr3[28] & 255) | ((bArr3[29] & 255) << 8) | ((bArr3[30] & 255) << 16) | ((bArr3[31] & 255) << 24);
        int i16 = ((bArr4[13] & 255) << 8) | (bArr4[12] & 255) | ((bArr4[14] & 255) << 16) | ((bArr4[15] & 255) << 24);
        int i17 = i16;
        int i18 = i;
        int i19 = i5;
        int i20 = i6;
        int i21 = i7;
        int i22 = i8;
        int i23 = i9;
        int i24 = i2;
        int i25 = i10;
        int i26 = i11;
        int i27 = i3;
        int i28 = i12;
        int i29 = i13;
        int i30 = i14;
        int i31 = i15;
        int i32 = 0;
        int i33 = i4;
        while (i32 < 20) {
            int i34 = i18 + i29;
            int i35 = i19 ^ ((i34 << 7) | (i34 >>> 25));
            int i36 = i35 + i18;
            int i37 = i23 ^ ((i36 << 9) | (i36 >>> 23));
            int i38 = i37 + i35;
            int i39 = i29 ^ ((i38 << 13) | (i38 >>> 19));
            int i40 = i39 + i37;
            int i41 = i18 ^ ((i40 << 18) | (i40 >>> 14));
            int i42 = i20 + i24;
            int i43 = i25 ^ ((i42 << 7) | (i42 >>> 25));
            int i44 = i43 + i20;
            int i45 = i30 ^ ((i44 << 9) | (i44 >>> 23));
            int i46 = i45 + i43;
            int i47 = i24 ^ ((i46 << 13) | (i46 >>> 19));
            int i48 = i47 + i45;
            int i49 = i20 ^ ((i48 << 18) | (i48 >>> 14));
            int i50 = i26 + i21;
            int i51 = i31 ^ ((i50 << 7) | (i50 >>> 25));
            int i52 = i51 + i26;
            int i53 = i27 ^ ((i52 << 9) | (i52 >>> 23));
            int i54 = i53 + i51;
            int i55 = i21 ^ ((i54 << 13) | (i54 >>> 19));
            int i56 = i55 + i53;
            int i57 = i26 ^ ((i56 << 18) | (i56 >>> 14));
            int i58 = i17 + i28;
            int i59 = i33 ^ ((i58 << 7) | (i58 >>> 25));
            int i60 = i59 + i17;
            int i61 = i22 ^ ((i60 << 9) | (i60 >>> 23));
            int i62 = i61 + i59;
            int i63 = i28 ^ ((i62 << 13) | (i62 >>> 19));
            int i64 = i63 + i61;
            int i65 = i17 ^ ((i64 << 18) | (i64 >>> 14));
            int i66 = i41 + i59;
            i24 = i47 ^ ((i66 << 7) | (i66 >>> 25));
            int i67 = i24 + i41;
            i27 = i53 ^ ((i67 << 9) | (i67 >>> 23));
            int i68 = i27 + i24;
            i33 = i59 ^ ((i68 << 13) | (i68 >>> 19));
            int i69 = i33 + i27;
            i18 = i41 ^ ((i69 << 18) | (i69 >>> 14));
            int i70 = i49 + i35;
            i21 = i55 ^ ((i70 << 7) | (i70 >>> 25));
            int i71 = i21 + i49;
            i22 = i61 ^ ((i71 << 9) | (i71 >>> 23));
            int i72 = i22 + i21;
            int i73 = i35 ^ ((i72 << 13) | (i72 >>> 19));
            int i74 = i73 + i22;
            i20 = i49 ^ ((i74 << 18) | (i74 >>> 14));
            int i75 = i57 + i43;
            i28 = i63 ^ ((i75 << 7) | (i75 >>> 25));
            int i76 = i28 + i57;
            int i77 = i37 ^ ((i76 << 9) | (i76 >>> 23));
            int i78 = i77 + i28;
            i25 = i43 ^ ((i78 << 13) | (i78 >>> 19));
            int i79 = i25 + i77;
            i26 = i57 ^ ((i79 << 18) | (i79 >>> 14));
            int i80 = i65 + i51;
            int i81 = i39 ^ ((i80 << 7) | (i80 >>> 25));
            int i82 = i81 + i65;
            int i83 = i45 ^ ((i82 << 9) | (i82 >>> 23));
            int i84 = i83 + i81;
            int i85 = i51 ^ ((i84 << 13) | (i84 >>> 19));
            int i86 = i85 + i83;
            i17 = i65 ^ ((i86 << 18) | (i86 >>> 14));
            i32 += 2;
            i31 = i85;
            i30 = i83;
            i29 = i81;
            i23 = i77;
            i19 = i73;
        }
        int i87 = i18 + i;
        int i88 = i24 + i2;
        int i89 = i27 + i3;
        int i90 = i33 + i4;
        int i91 = i19 + i5;
        int i92 = i20 + i6;
        int i93 = i21 + i7;
        int i94 = i22 + i8;
        int i95 = i23 + i9;
        int i96 = i25 + i10;
        int i97 = i26 + i11;
        int i98 = i28 + i12;
        int i99 = i29 + i13;
        int i100 = i30 + i14;
        int i101 = i31 + i15;
        int i102 = i17 + i16;
        bArr[0] = (byte) (i87 & 255);
        bArr[1] = (byte) ((i87 >>> 8) & 255);
        bArr[2] = (byte) ((i87 >>> 16) & 255);
        bArr[3] = (byte) ((i87 >>> 24) & 255);
        bArr[4] = (byte) (i88 & 255);
        bArr[5] = (byte) ((i88 >>> 8) & 255);
        bArr[6] = (byte) ((i88 >>> 16) & 255);
        bArr[7] = (byte) ((i88 >>> 24) & 255);
        bArr[8] = (byte) (i89 & 255);
        bArr[9] = (byte) ((i89 >>> 8) & 255);
        bArr[10] = (byte) ((i89 >>> 16) & 255);
        bArr[11] = (byte) ((i89 >>> 24) & 255);
        bArr[12] = (byte) (i90 & 255);
        bArr[13] = (byte) ((i90 >>> 8) & 255);
        bArr[14] = (byte) ((i90 >>> 16) & 255);
        bArr[15] = (byte) ((i90 >>> 24) & 255);
        bArr[16] = (byte) (i91 & 255);
        bArr[17] = (byte) ((i91 >>> 8) & 255);
        bArr[18] = (byte) ((i91 >>> 16) & 255);
        bArr[19] = (byte) ((i91 >>> 24) & 255);
        bArr[20] = (byte) (i92 & 255);
        bArr[21] = (byte) ((i92 >>> 8) & 255);
        bArr[22] = (byte) ((i92 >>> 16) & 255);
        bArr[23] = (byte) ((i92 >>> 24) & 255);
        bArr[24] = (byte) (i93 & 255);
        bArr[25] = (byte) ((i93 >>> 8) & 255);
        bArr[26] = (byte) ((i93 >>> 16) & 255);
        bArr[27] = (byte) ((i93 >>> 24) & 255);
        bArr[28] = (byte) (i94 & 255);
        bArr[29] = (byte) ((i94 >>> 8) & 255);
        bArr[30] = (byte) ((i94 >>> 16) & 255);
        bArr[31] = (byte) ((i94 >>> 24) & 255);
        bArr[32] = (byte) (i95 & 255);
        bArr[33] = (byte) ((i95 >>> 8) & 255);
        bArr[34] = (byte) ((i95 >>> 16) & 255);
        bArr[35] = (byte) ((i95 >>> 24) & 255);
        bArr[36] = (byte) (i96 & 255);
        bArr[37] = (byte) ((i96 >>> 8) & 255);
        bArr[38] = (byte) ((i96 >>> 16) & 255);
        bArr[39] = (byte) ((i96 >>> 24) & 255);
        bArr[40] = (byte) (i97 & 255);
        bArr[41] = (byte) ((i97 >>> 8) & 255);
        bArr[42] = (byte) ((i97 >>> 16) & 255);
        bArr[43] = (byte) ((i97 >>> 24) & 255);
        bArr[44] = (byte) (i98 & 255);
        bArr[45] = (byte) ((i98 >>> 8) & 255);
        bArr[46] = (byte) ((i98 >>> 16) & 255);
        bArr[47] = (byte) ((i98 >>> 24) & 255);
        bArr[48] = (byte) (i99 & 255);
        bArr[49] = (byte) ((i99 >>> 8) & 255);
        bArr[50] = (byte) ((i99 >>> 16) & 255);
        bArr[51] = (byte) ((i99 >>> 24) & 255);
        bArr[52] = (byte) (i100 & 255);
        bArr[53] = (byte) ((i100 >>> 8) & 255);
        bArr[54] = (byte) ((i100 >>> 16) & 255);
        bArr[55] = (byte) ((i100 >>> 24) & 255);
        bArr[56] = (byte) (i101 & 255);
        bArr[57] = (byte) ((i101 >>> 8) & 255);
        bArr[58] = (byte) ((i101 >>> 16) & 255);
        bArr[59] = (byte) ((i101 >>> 24) & 255);
        bArr[60] = (byte) (i102 & 255);
        bArr[61] = (byte) ((i102 >>> 8) & 255);
        bArr[62] = (byte) ((i102 >>> 16) & 255);
        bArr[63] = (byte) ((i102 >>> 24) & 255);
    }

    private static void core_hsalsa20(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        int i = (bArr4[0] & 255) | ((bArr4[1] & 255) << 8) | ((bArr4[2] & 255) << 16) | ((bArr4[3] & 255) << 24);
        int i2 = (bArr3[0] & 255) | ((bArr3[1] & 255) << 8) | ((bArr3[2] & 255) << 16) | ((bArr3[3] & 255) << 24);
        int i3 = (bArr3[4] & 255) | ((bArr3[5] & 255) << 8) | ((bArr3[6] & 255) << 16) | ((bArr3[7] & 255) << 24);
        int i4 = ((bArr3[9] & 255) << 8) | (bArr3[8] & 255) | ((bArr3[10] & 255) << 16) | ((bArr3[11] & 255) << 24);
        int i5 = (bArr3[12] & 255) | ((bArr3[13] & 255) << 8) | ((bArr3[14] & 255) << 16) | ((bArr3[15] & 255) << 24);
        int i6 = (bArr4[4] & 255) | ((bArr4[5] & 255) << 8) | ((bArr4[6] & 255) << 16) | ((bArr4[7] & 255) << 24);
        int i7 = (bArr2[0] & 255) | ((bArr2[1] & 255) << 8) | ((bArr2[2] & 255) << 16) | ((bArr2[3] & 255) << 24);
        int i8 = (bArr2[4] & 255) | ((bArr2[5] & 255) << 8) | ((bArr2[6] & 255) << 16) | ((bArr2[7] & 255) << 24);
        int i9 = (bArr2[8] & 255) | ((bArr2[9] & 255) << 8) | ((bArr2[10] & 255) << 16) | ((bArr2[11] & 255) << 24);
        int i10 = (bArr2[12] & 255) | ((bArr2[13] & 255) << 8) | ((bArr2[14] & 255) << 16) | ((bArr2[15] & 255) << 24);
        int i11 = (bArr4[8] & 255) | ((bArr4[9] & 255) << 8) | ((bArr4[10] & 255) << 16) | ((bArr4[11] & 255) << 24);
        int i12 = (bArr3[16] & 255) | ((bArr3[17] & 255) << 8) | ((bArr3[18] & 255) << 16) | ((bArr3[19] & 255) << 24);
        int i13 = (bArr3[20] & 255) | ((bArr3[21] & 255) << 8) | ((bArr3[22] & 255) << 16) | ((bArr3[23] & 255) << 24);
        int i14 = (bArr3[24] & 255) | ((bArr3[25] & 255) << 8) | ((bArr3[26] & 255) << 16) | ((bArr3[27] & 255) << 24);
        int i15 = (bArr3[28] & 255) | ((bArr3[29] & 255) << 8) | ((bArr3[30] & 255) << 16) | ((bArr3[31] & 255) << 24);
        int i16 = i4;
        int i17 = ((bArr4[13] & 255) << 8) | (bArr4[12] & 255) | ((bArr4[14] & 255) << 16) | ((bArr4[15] & 255) << 24);
        int i18 = 0;
        while (true) {
            int i19 = i5;
            if (i18 >= 20) {
                bArr[0] = (byte) (i & 255);
                bArr[1] = (byte) ((i >>> 8) & 255);
                bArr[2] = (byte) ((i >>> 16) & 255);
                bArr[3] = (byte) ((i >>> 24) & 255);
                bArr[4] = (byte) (i6 & 255);
                bArr[5] = (byte) ((i6 >>> 8) & 255);
                bArr[6] = (byte) ((i6 >>> 16) & 255);
                bArr[7] = (byte) ((i6 >>> 24) & 255);
                bArr[8] = (byte) (i11 & 255);
                bArr[9] = (byte) ((i11 >>> 8) & 255);
                bArr[10] = (byte) ((i11 >>> 16) & 255);
                bArr[11] = (byte) ((i11 >>> 24) & 255);
                bArr[12] = (byte) (i17 & 255);
                bArr[13] = (byte) ((i17 >>> 8) & 255);
                bArr[14] = (byte) ((i17 >>> 16) & 255);
                bArr[15] = (byte) ((i17 >>> 24) & 255);
                bArr[16] = (byte) (i7 & 255);
                bArr[17] = (byte) ((i7 >>> 8) & 255);
                bArr[18] = (byte) ((i7 >>> 16) & 255);
                bArr[19] = (byte) ((i7 >>> 24) & 255);
                bArr[20] = (byte) (i8 & 255);
                bArr[21] = (byte) ((i8 >>> 8) & 255);
                bArr[22] = (byte) ((i8 >>> 16) & 255);
                bArr[23] = (byte) ((i8 >>> 24) & 255);
                bArr[24] = (byte) (i9 & 255);
                bArr[25] = (byte) ((i9 >>> 8) & 255);
                bArr[26] = (byte) ((i9 >>> 16) & 255);
                bArr[27] = (byte) ((i9 >>> 24) & 255);
                bArr[28] = (byte) (i10 & 255);
                bArr[29] = (byte) ((i10 >>> 8) & 255);
                bArr[30] = (byte) ((i10 >>> 16) & 255);
                bArr[31] = (byte) ((i10 >>> 24) & 255);
                return;
            }
            int i20 = i + i13;
            int i21 = i19 ^ ((i20 << 7) | (i20 >>> 25));
            int i22 = i21 + i;
            int i23 = i9 ^ ((i22 << 9) | (i22 >>> 23));
            int i24 = i23 + i21;
            int i25 = i13 ^ ((i24 << 13) | (i24 >>> 19));
            int i26 = i25 + i23;
            int i27 = i ^ ((i26 << 18) | (i26 >>> 14));
            int i28 = i6 + i2;
            int i29 = i10 ^ ((i28 << 7) | (i28 >>> 25));
            int i30 = i29 + i6;
            int i31 = i14 ^ ((i30 << 9) | (i30 >>> 23));
            int i32 = i31 + i29;
            int i33 = i2 ^ ((i32 << 13) | (i32 >>> 19));
            int i34 = i33 + i31;
            int i35 = i6 ^ ((i34 << 18) | (i34 >>> 14));
            int i36 = i11 + i7;
            int i37 = i15 ^ ((i36 << 7) | (i36 >>> 25));
            int i38 = i37 + i11;
            int i39 = i3 ^ ((i38 << 9) | (i38 >>> 23));
            int i40 = i39 + i37;
            int i41 = i7 ^ ((i40 << 13) | (i40 >>> 19));
            int i42 = i41 + i39;
            int i43 = i11 ^ ((i42 << 18) | (i42 >>> 14));
            int i44 = i17 + i12;
            int i45 = i16 ^ ((i44 << 7) | (i44 >>> 25));
            int i46 = i45 + i17;
            int i47 = i8 ^ ((i46 << 9) | (i46 >>> 23));
            int i48 = i47 + i45;
            int i49 = i12 ^ ((i48 << 13) | (i48 >>> 19));
            int i50 = i49 + i47;
            int i51 = i17 ^ ((i50 << 18) | (i50 >>> 14));
            int i52 = i27 + i45;
            i2 = i33 ^ ((i52 << 7) | (i52 >>> 25));
            int i53 = i2 + i27;
            i3 = i39 ^ ((i53 << 9) | (i53 >>> 23));
            int i54 = i3 + i2;
            i16 = i45 ^ ((i54 << 13) | (i54 >>> 19));
            int i55 = i16 + i3;
            i = i27 ^ ((i55 << 18) | (i55 >>> 14));
            int i56 = i35 + i21;
            i7 = i41 ^ ((i56 << 7) | (i56 >>> 25));
            int i57 = i7 + i35;
            i8 = i47 ^ ((i57 << 9) | (i57 >>> 23));
            int i58 = i8 + i7;
            i5 = i21 ^ ((i58 << 13) | (i58 >>> 19));
            int i59 = i5 + i8;
            i6 = i35 ^ ((i59 << 18) | (i59 >>> 14));
            int i60 = i43 + i29;
            i12 = i49 ^ ((i60 << 7) | (i60 >>> 25));
            int i61 = i12 + i43;
            i9 = i23 ^ ((i61 << 9) | (i61 >>> 23));
            int i62 = i9 + i12;
            i10 = i29 ^ ((i62 << 13) | (i62 >>> 19));
            int i63 = i10 + i9;
            i11 = i43 ^ ((i63 << 18) | (i63 >>> 14));
            int i64 = i51 + i37;
            i13 = i25 ^ ((i64 << 7) | (i64 >>> 25));
            int i65 = i13 + i51;
            i14 = i31 ^ ((i65 << 9) | (i65 >>> 23));
            int i66 = i14 + i13;
            i15 = i37 ^ ((i66 << 13) | (i66 >>> 19));
            int i67 = i15 + i14;
            i17 = i51 ^ ((i67 << 18) | (i67 >>> 14));
            i18 += 2;
        }
    }

    public static int crypto_core_salsa20(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        core_salsa20(bArr, bArr2, bArr3, bArr4);
        return 0;
    }

    public static int crypto_core_hsalsa20(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        core_hsalsa20(bArr, bArr2, bArr3, bArr4);
        return 0;
    }

    private static int crypto_stream_salsa20_xor(byte[] bArr, int i, byte[] bArr2, int i2, long j, byte[] bArr3, byte[] bArr4) {
        byte[] bArr5 = new byte[16];
        byte[] bArr6 = new byte[64];
        for (int i3 = 0; i3 < 16; i3++) {
            bArr5[i3] = 0;
        }
        for (int i4 = 0; i4 < 8; i4++) {
            bArr5[i4] = bArr3[i4];
        }
        int i5 = i;
        int i6 = i2;
        long j2 = j;
        while (j2 >= 64) {
            crypto_core_salsa20(bArr6, bArr5, bArr4, sigma);
            for (int i7 = 0; i7 < 64; i7++) {
                bArr[i5 + i7] = (byte) ((bArr2[i6 + i7] ^ bArr6[i7]) & 255);
            }
            int i8 = 1;
            for (int i9 = 8; i9 < 16; i9++) {
                int i10 = i8 + (bArr5[i9] & 255);
                bArr5[i9] = (byte) (i10 & 255);
                i8 = i10 >>> 8;
            }
            j2 -= 64;
            i5 += 64;
            i6 += 64;
        }
        if (j2 > 0) {
            crypto_core_salsa20(bArr6, bArr5, bArr4, sigma);
            for (int i11 = 0; i11 < j2; i11++) {
                bArr[i5 + i11] = (byte) ((bArr2[i6 + i11] ^ bArr6[i11]) & 255);
            }
        }
        return 0;
    }

    public static int crypto_stream_salsa20(byte[] bArr, int i, long j, byte[] bArr2, byte[] bArr3) {
        byte[] bArr4 = new byte[16];
        byte[] bArr5 = new byte[64];
        for (int i2 = 0; i2 < 16; i2++) {
            bArr4[i2] = 0;
        }
        for (int i3 = 0; i3 < 8; i3++) {
            bArr4[i3] = bArr2[i3];
        }
        while (j >= 64) {
            crypto_core_salsa20(bArr5, bArr4, bArr3, sigma);
            for (int i4 = 0; i4 < 64; i4++) {
                bArr[i + i4] = bArr5[i4];
            }
            int i5 = 1;
            for (int i6 = 8; i6 < 16; i6++) {
                int i7 = i5 + (bArr4[i6] & 255);
                bArr4[i6] = (byte) (i7 & 255);
                i5 = i7 >>> 8;
            }
            j -= 64;
            i += 64;
        }
        if (j > 0) {
            crypto_core_salsa20(bArr5, bArr4, bArr3, sigma);
            for (int i8 = 0; i8 < j; i8++) {
                bArr[i + i8] = bArr5[i8];
            }
        }
        return 0;
    }

    public static int crypto_stream(byte[] bArr, int i, long j, byte[] bArr2, byte[] bArr3) {
        byte[] bArr4 = new byte[32];
        crypto_core_hsalsa20(bArr4, bArr2, bArr3, sigma);
        byte[] bArr5 = new byte[8];
        for (int i2 = 0; i2 < 8; i2++) {
            bArr5[i2] = bArr2[i2 + 16];
        }
        return crypto_stream_salsa20(bArr, i, j, bArr5, bArr4);
    }

    public static int crypto_stream_xor(byte[] bArr, int i, byte[] bArr2, int i2, long j, byte[] bArr3, byte[] bArr4) {
        byte[] bArr5 = new byte[32];
        crypto_core_hsalsa20(bArr5, bArr3, bArr4, sigma);
        byte[] bArr6 = new byte[8];
        for (int i3 = 0; i3 < 8; i3++) {
            bArr6[i3] = bArr3[i3 + 16];
        }
        return crypto_stream_salsa20_xor(bArr, i, bArr2, i2, j, bArr6, bArr5);
    }

    public static final class poly1305 {
        private final int[] pad;
        private final int[] r;
        private final byte[] buffer = new byte[16];
        private final int[] h = new int[10];
        private int leftover = 0;
        private int fin = 0;

        public poly1305(byte[] bArr) {
            this.r = new int[]{i & 8191, ((i >>> 13) | (i << 3)) & 8191, ((i >>> 10) | (i << 6)) & 7939, ((i >>> 7) | (i << 9)) & 8191, ((i >>> 4) | (i << 12)) & 255, (i >>> 1) & 8190, ((i >>> 14) | (i << 2)) & 8191, ((i >>> 11) | (i << 5)) & 8065, ((i >>> 8) | (i << 8)) & 8191, (i >>> 5) & 127};
            this.pad = new int[]{(bArr[16] & 255) | ((bArr[17] & 255) << 8), (bArr[18] & 255) | ((bArr[19] & 255) << 8), (bArr[20] & 255) | ((bArr[21] & 255) << 8), (bArr[22] & 255) | ((bArr[23] & 255) << 8), (bArr[24] & 255) | ((bArr[25] & 255) << 8), (bArr[26] & 255) | ((bArr[27] & 255) << 8), (bArr[28] & 255) | ((bArr[29] & 255) << 8), (bArr[30] & 255) | ((bArr[31] & 255) << 8)};
            int i = (bArr[0] & 255) | ((bArr[1] & 255) << 8);
            int i2 = (bArr[2] & 255) | ((bArr[3] & 255) << 8);
            int i3 = (bArr[4] & 255) | ((bArr[5] & 255) << 8);
            int i4 = ((bArr[7] & 255) << 8) | (bArr[6] & 255);
            int i5 = ((bArr[9] & 255) << 8) | (bArr[8] & 255);
            int i6 = (bArr[10] & 255) | ((bArr[11] & 255) << 8);
            int i7 = (bArr[12] & 255) | ((bArr[13] & 255) << 8);
            int i8 = (bArr[14] & 255) | ((bArr[15] & 255) << 8);
        }

        public poly1305 blocks(byte[] bArr, int i, int i2) {
            int i3 = this.fin != 0 ? 0 : 2048;
            int[] iArr = this.h;
            int i4 = iArr[0];
            int i5 = iArr[1];
            char c = 2;
            int i6 = iArr[2];
            char c2 = 3;
            int i7 = iArr[3];
            int i8 = 4;
            int i9 = iArr[4];
            char c3 = 5;
            int i10 = iArr[5];
            char c4 = 6;
            int i11 = iArr[6];
            int i12 = iArr[7];
            int i13 = iArr[8];
            int i14 = iArr[9];
            int[] iArr2 = this.r;
            int i15 = iArr2[0];
            int i16 = iArr2[1];
            int i17 = iArr2[2];
            int i18 = iArr2[3];
            int i19 = iArr2[4];
            int i20 = iArr2[5];
            int i21 = iArr2[6];
            int i22 = iArr2[7];
            int i23 = iArr2[8];
            int i24 = iArr2[9];
            int i25 = i12;
            int i26 = i13;
            int i27 = i10;
            int i28 = i11;
            int i29 = i7;
            int i30 = i9;
            int i31 = i5;
            int i32 = i6;
            int i33 = i14;
            int i34 = i4;
            int i35 = i;
            int i36 = i2;
            while (i36 >= 16) {
                char c5 = c;
                int i37 = (bArr[i35] & 255) | ((bArr[i35 + 1] & 255) << 8);
                int i38 = i34 + (i37 & 8191);
                char c6 = c2;
                int i39 = (bArr[i35 + 2] & 255) | ((bArr[i35 + 3] & 255) << 8);
                int i40 = i31 + (((i37 >>> 13) | (i39 << 3)) & 8191);
                int i41 = (bArr[i35 + 4] & 255) | ((bArr[i35 + 5] & 255) << 8);
                int i42 = i32 + (((i39 >>> 10) | (i41 << 6)) & 8191);
                int i43 = (bArr[i35 + 6] & 255) | ((bArr[i35 + 7] & 255) << 8);
                int i44 = i29 + (((i41 >>> 7) | (i43 << 9)) & 8191);
                int i45 = (bArr[i35 + 8] & 255) | ((bArr[i35 + 9] & 255) << 8);
                int i46 = i30 + (((i43 >>> i8) | (i45 << 12)) & 8191);
                int i47 = i27 + ((i45 >>> 1) & 8191);
                int i48 = (bArr[i35 + 10] & 255) | ((bArr[i35 + 11] & 255) << 8);
                int i49 = i28 + (((i45 >>> 14) | (i48 << 2)) & 8191);
                int i50 = (bArr[i35 + 12] & 255) | ((bArr[i35 + 13] & 255) << 8);
                int i51 = i25 + (((i48 >>> 11) | (i50 << 5)) & 8191);
                int i52 = (bArr[i35 + 14] & 255) | ((bArr[i35 + 15] & 255) << 8);
                int i53 = i26 + (((i50 >>> 8) | (i52 << 8)) & 8191);
                int i54 = i33 + ((i52 >>> 5) | i3);
                int i55 = i24 * 5;
                int i56 = i23 * 5;
                int i57 = i22 * 5;
                int i58 = i21 * 5;
                int i59 = (i38 * i15) + (i40 * i55) + (i42 * i56) + (i44 * i57) + (i46 * i58);
                int i60 = i59 >>> 13;
                int i61 = i20 * 5;
                int i62 = i19 * 5;
                int i63 = i18 * 5;
                int i64 = i17 * 5;
                int i65 = (i59 & 8191) + (i47 * i61) + (i49 * i62) + (i51 * i63) + (i53 * i64) + (i16 * 5 * i54);
                int i66 = i8;
                int i67 = i60 + (i65 >>> 13) + (i38 * i16) + (i40 * i15) + (i42 * i55) + (i44 * i56) + (i46 * i57);
                int i68 = i67 >>> 13;
                int i69 = (i67 & 8191) + (i47 * i58) + (i49 * i61) + (i51 * i62) + (i53 * i63) + (i64 * i54);
                char c7 = c3;
                int i70 = i68 + (i69 >>> 13) + (i38 * i17) + (i40 * i16) + (i42 * i15) + (i44 * i55) + (i46 * i56);
                int i71 = i70 >>> 13;
                int i72 = (i70 & 8191) + (i47 * i57) + (i49 * i58) + (i51 * i61) + (i53 * i62) + (i63 * i54);
                char c8 = c4;
                int i73 = i71 + (i72 >>> 13) + (i38 * i18) + (i40 * i17) + (i42 * i16) + (i44 * i15) + (i46 * i55);
                int i74 = i73 >>> 13;
                int i75 = (i73 & 8191) + (i47 * i56) + (i49 * i57) + (i51 * i58) + (i53 * i61) + (i62 * i54);
                int i76 = i3;
                int i77 = i74 + (i75 >>> 13) + (i38 * i19) + (i40 * i18) + (i42 * i17) + (i44 * i16) + (i46 * i15);
                int i78 = i77 >>> 13;
                int i79 = (i77 & 8191) + (i47 * i55) + (i49 * i56) + (i51 * i57) + (i53 * i58) + (i61 * i54);
                int i80 = i78 + (i79 >>> 13);
                int i81 = i79 & 8191;
                int i82 = i80 + (i38 * i20) + (i40 * i19) + (i42 * i18) + (i44 * i17) + (i46 * i16);
                int i83 = i82 >>> 13;
                int i84 = (i82 & 8191) + (i47 * i15) + (i49 * i55) + (i51 * i56) + (i53 * i57) + (i58 * i54);
                int i85 = i83 + (i84 >>> 13);
                int i86 = i84 & 8191;
                int i87 = i85 + (i38 * i21) + (i40 * i20) + (i42 * i19) + (i44 * i18) + (i46 * i17);
                int i88 = i87 >>> 13;
                int i89 = (i87 & 8191) + (i47 * i16) + (i49 * i15) + (i51 * i55) + (i53 * i56) + (i57 * i54);
                int i90 = i88 + (i89 >>> 13);
                int i91 = i89 & 8191;
                int i92 = i90 + (i38 * i22) + (i40 * i21) + (i42 * i20) + (i44 * i19) + (i46 * i18);
                int i93 = i92 >>> 13;
                int i94 = (i92 & 8191) + (i47 * i17) + (i49 * i16) + (i51 * i15) + (i53 * i55) + (i56 * i54);
                int i95 = i93 + (i94 >>> 13) + (i38 * i23) + (i40 * i22) + (i42 * i21) + (i44 * i20) + (i46 * i19);
                int i96 = i95 >>> 13;
                int i97 = (i95 & 8191) + (i47 * i18) + (i49 * i17) + (i51 * i16) + (i53 * i15) + (i55 * i54);
                int i98 = i97 & 8191;
                int i99 = i96 + (i97 >>> 13) + (i38 * i24) + (i40 * i23) + (i42 * i22) + (i44 * i21) + (i46 * i20);
                int i100 = i99 >>> 13;
                int i101 = (i99 & 8191) + (i47 * i19) + (i49 * i18) + (i51 * i17) + (i53 * i16) + (i54 * i15);
                int i102 = i100 + (i101 >>> 13);
                i33 = i101 & 8191;
                int i103 = (i102 << 2) + i102 + (i65 & 8191);
                i31 = (i69 & 8191) + (i103 >>> 13);
                i35 += 16;
                i36 -= 16;
                i25 = i94 & 8191;
                i34 = i103 & 8191;
                i26 = i98;
                i32 = i72 & 8191;
                i29 = i75 & 8191;
                c = c5;
                c2 = c6;
                i28 = i91;
                i27 = i86;
                i30 = i81;
                i3 = i76;
                c4 = c8;
                c3 = c7;
                i8 = i66;
            }
            int[] iArr3 = this.h;
            iArr3[0] = i34;
            iArr3[1] = i31;
            iArr3[c] = i32;
            iArr3[c2] = i29;
            iArr3[i8] = i30;
            iArr3[c3] = i27;
            iArr3[c4] = i28;
            iArr3[7] = i25;
            iArr3[8] = i26;
            iArr3[9] = i33;
            return this;
        }

        public poly1305 finish(byte[] bArr, int i) {
            int[] iArr;
            int[] iArr2;
            int[] iArr3 = new int[10];
            int i2 = this.leftover;
            if (i2 != 0) {
                this.buffer[i2] = 1;
                for (int i3 = i2 + 1; i3 < 16; i3++) {
                    this.buffer[i3] = 0;
                }
                this.fin = 1;
                blocks(this.buffer, 0, 16);
            }
            int[] iArr4 = this.h;
            int i4 = iArr4[1];
            int i5 = i4 >>> 13;
            iArr4[1] = i4 & 8191;
            int i6 = 2;
            while (true) {
                iArr = this.h;
                if (i6 >= 10) {
                    break;
                }
                int i7 = iArr[i6] + i5;
                iArr[i6] = i7;
                i5 = i7 >>> 13;
                iArr[i6] = i7 & 8191;
                i6++;
            }
            int i8 = iArr[0] + (i5 * 5);
            iArr[0] = i8;
            int i9 = i8 >>> 13;
            int i10 = i8 & 8191;
            iArr[0] = i10;
            int i11 = iArr[1] + i9;
            iArr[1] = i11;
            iArr[1] = i11 & 8191;
            iArr[2] = iArr[2] + (i11 >>> 13);
            int i12 = i10 + 5;
            iArr3[0] = i12;
            int i13 = i12 >>> 13;
            iArr3[0] = i12 & 8191;
            for (int i14 = 1; i14 < 10; i14++) {
                int i15 = this.h[i14] + i13;
                iArr3[i14] = i15;
                i13 = i15 >>> 13;
                iArr3[i14] = i15 & 8191;
            }
            int i16 = iArr3[9] - 8192;
            iArr3[9] = i16;
            iArr3[9] = i16 & 65535;
            int i17 = ((i13 ^ 1) - 1) & 65535;
            for (int i18 = 0; i18 < 10; i18++) {
                iArr3[i18] = iArr3[i18] & i17;
            }
            int i19 = ~i17;
            int i20 = 0;
            while (true) {
                iArr2 = this.h;
                if (i20 >= 10) {
                    break;
                }
                iArr2[i20] = (iArr2[i20] & i19) | iArr3[i20];
                i20++;
            }
            int i21 = iArr2[0];
            int i22 = iArr2[1];
            int i23 = (i21 | (i22 << 13)) & 65535;
            iArr2[0] = i23;
            int i24 = iArr2[2];
            iArr2[1] = ((i22 >>> 3) | (i24 << 10)) & 65535;
            char c = 6;
            int i25 = iArr2[3];
            iArr2[2] = ((i24 >>> 6) | (i25 << 7)) & 65535;
            int i26 = iArr2[4];
            iArr2[3] = ((i25 >>> 9) | (i26 << 4)) & 65535;
            int i27 = (i26 >>> 12) | (iArr2[5] << 1);
            int i28 = iArr2[6];
            iArr2[4] = (i27 | (i28 << 14)) & 65535;
            int i29 = iArr2[7];
            iArr2[5] = ((i28 >>> 2) | (i29 << 11)) & 65535;
            int i30 = iArr2[8];
            iArr2[6] = ((i29 >>> 5) | (i30 << 8)) & 65535;
            iArr2[7] = ((iArr2[9] << 5) | (i30 >>> 8)) & 65535;
            int i31 = i23 + this.pad[0];
            iArr2[0] = i31 & 65535;
            int i32 = 1;
            while (true) {
                int[] iArr5 = this.h;
                if (i32 < 8) {
                    i31 = (i31 >>> 16) + iArr5[i32] + this.pad[i32];
                    iArr5[i32] = i31 & 65535;
                    i32++;
                    c = c;
                } else {
                    char c2 = c;
                    int i33 = iArr5[0];
                    bArr[i] = (byte) (i33 & 255);
                    bArr[i + 1] = (byte) ((i33 >>> 8) & 255);
                    int i34 = iArr5[1];
                    bArr[i + 2] = (byte) (i34 & 255);
                    bArr[i + 3] = (byte) ((i34 >>> 8) & 255);
                    int i35 = iArr5[2];
                    bArr[i + 4] = (byte) (i35 & 255);
                    bArr[i + 5] = (byte) ((i35 >>> 8) & 255);
                    int i36 = iArr5[3];
                    bArr[i + 6] = (byte) (i36 & 255);
                    bArr[i + 7] = (byte) ((i36 >>> 8) & 255);
                    int i37 = iArr5[4];
                    bArr[i + 8] = (byte) (i37 & 255);
                    bArr[i + 9] = (byte) ((i37 >>> 8) & 255);
                    int i38 = iArr5[5];
                    bArr[i + 10] = (byte) (i38 & 255);
                    bArr[i + 11] = (byte) ((i38 >>> 8) & 255);
                    int i39 = iArr5[c2];
                    bArr[i + 12] = (byte) (i39 & 255);
                    bArr[i + 13] = (byte) ((i39 >>> 8) & 255);
                    int i40 = iArr5[7];
                    bArr[i + 14] = (byte) (i40 & 255);
                    bArr[i + 15] = (byte) ((i40 >>> 8) & 255);
                    return this;
                }
            }
        }

        /* JADX WARN: Code duplicated, block: B:15:0x0030  */
        /* JADX WARN: Code duplicated, block: B:17:0x003b A[ADDED_TO_REGION, LOOP:1: B:17:0x003b->B:18:0x003d, LOOP_START, PHI: r1
          0x003b: PHI (r1v1 int) = (r1v0 int), (r1v2 int) binds: [B:16:0x0039, B:18:0x003d] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:18:0x003d A[LOOP:1: B:17:0x003b->B:18:0x003d, LOOP_END] */
        public poly1305 update(byte[] bArr, int i, int i2) {
            int i3 = this.leftover;
            if (i3 == 0) {
                if (i2 >= 16) {
                    int i4 = i2 - (i2 % 16);
                    blocks(bArr, i, i4);
                    i += i4;
                    i2 -= i4;
                }
                if (i2 != 0) {
                    for (int i5 = 0; i5 < i2; i5++) {
                        this.buffer[this.leftover + i5] = bArr[i + i5];
                    }
                    this.leftover += i2;
                }
            } else {
                int i6 = 16 - i3;
                if (i6 > i2) {
                    i6 = i2;
                }
                for (int i7 = 0; i7 < i6; i7++) {
                    this.buffer[this.leftover + i7] = bArr[i + i7];
                }
                i2 -= i6;
                i += i6;
                int i8 = this.leftover + i6;
                this.leftover = i8;
                if (i8 >= 16) {
                    blocks(this.buffer, 0, 16);
                    this.leftover = 0;
                    if (i2 >= 16) {
                        int i9 = i2 - (i2 % 16);
                        blocks(bArr, i, i9);
                        i += i9;
                        i2 -= i9;
                    }
                    if (i2 != 0) {
                        while (i5 < i2) {
                            this.buffer[this.leftover + i5] = bArr[i + i5];
                        }
                        this.leftover += i2;
                    }
                }
            }
            return this;
        }
    }

    private static int crypto_onetimeauth(byte[] bArr, int i, byte[] bArr2, int i2, int i3, byte[] bArr3) {
        poly1305 poly1305Var = new poly1305(bArr3);
        poly1305Var.update(bArr2, i2, i3);
        poly1305Var.finish(bArr, i);
        return 0;
    }

    private static int crypto_onetimeauth_verify(byte[] bArr, int i, byte[] bArr2, int i2, int i3, byte[] bArr3) {
        byte[] bArr4 = new byte[16];
        crypto_onetimeauth(bArr4, 0, bArr2, i2, i3, bArr3);
        return crypto_verify_16(bArr, i, bArr4, 0);
    }

    public static int crypto_secretbox_open(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4) {
        byte[] bArr5 = new byte[32];
        if (i < 32) {
            return -1;
        }
        crypto_stream(bArr5, 0, 32L, bArr3, bArr4);
        if (crypto_onetimeauth_verify(bArr2, 16, bArr2, 32, i - 32, bArr5) != 0) {
            return -1;
        }
        crypto_stream_xor(bArr, 0, bArr2, 0, i, bArr3, bArr4);
        return 0;
    }
}
