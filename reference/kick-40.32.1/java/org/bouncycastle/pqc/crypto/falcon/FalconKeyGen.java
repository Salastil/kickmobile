package org.bouncycastle.pqc.crypto.falcon;

import androidx.collection.SieveCacheKt;
import org.bouncycastle.crypto.digests.SHAKEDigest;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes11.dex */
class FalconKeyGen {
    private static final int DEPTH_INT_FG = 4;
    private static final short[] REV10 = {0, 512, 256, 768, 128, 640, 384, 896, 64, 576, 320, 832, 192, 704, 448, 960, 32, 544, 288, 800, 160, 672, 416, 928, 96, 608, 352, 864, 224, 736, 480, 992, 16, 528, 272, 784, 144, 656, 400, 912, 80, 592, 336, 848, 208, 720, 464, 976, 48, 560, 304, 816, 176, 688, 432, 944, 112, 624, 368, 880, 240, 752, 496, 1008, 8, 520, 264, 776, 136, 648, 392, 904, 72, 584, 328, 840, 200, 712, 456, 968, 40, 552, 296, 808, 168, 680, 424, 936, 104, 616, 360, 872, 232, 744, 488, 1000, 24, 536, 280, 792, 152, 664, 408, 920, 88, 600, 344, 856, 216, 728, 472, 984, 56, 568, 312, 824, 184, 696, 440, 952, 120, 632, 376, 888, 248, 760, 504, 1016, 4, 516, 260, 772, 132, 644, 388, 900, 68, 580, 324, 836, 196, 708, 452, 964, 36, 548, 292, 804, 164, 676, 420, 932, 100, 612, 356, 868, 228, 740, 484, 996, 20, 532, 276, 788, 148, 660, 404, 916, 84, 596, 340, 852, 212, 724, 468, 980, 52, 564, 308, 820, 180, 692, 436, 948, 116, 628, 372, 884, 244, 756, 500, 1012, 12, 524, 268, 780, 140, 652, 396, 908, 76, 588, 332, 844, 204, 716, 460, 972, 44, 556, 300, 812, 172, 684, 428, 940, 108, 620, 364, 876, 236, 748, 492, 1004, 28, 540, 284, 796, 156, 668, 412, 924, 92, 604, 348, 860, 220, 732, 476, 988, 60, 572, 316, 828, 188, 700, 444, 956, 124, 636, 380, 892, 252, 764, 508, 1020, 2, 514, 258, 770, 130, 642, 386, 898, 66, 578, 322, 834, 194, 706, 450, 962, 34, 546, 290, 802, 162, 674, 418, 930, 98, 610, 354, 866, 226, 738, 482, 994, 18, 530, 274, 786, 146, 658, 402, 914, 82, 594, 338, 850, 210, 722, 466, 978, 50, 562, 306, 818, 178, 690, 434, 946, 114, 626, 370, 882, 242, 754, 498, 1010, 10, 522, 266, 778, 138, 650, 394, 906, 74, 586, 330, 842, 202, 714, 458, 970, 42, 554, 298, 810, 170, 682, 426, 938, 106, 618, 362, 874, 234, 746, 490, 1002, 26, 538, 282, 794, 154, 666, 410, 922, 90, 602, 346, 858, 218, 730, 474, 986, 58, 570, 314, 826, 186, 698, 442, 954, 122, 634, 378, 890, 250, 762, 506, 1018, 6, 518, 262, 774, 134, 646, 390, 902, 70, 582, 326, 838, 198, 710, 454, 966, 38, 550, 294, 806, 166, 678, 422, 934, 102, 614, 358, 870, 230, 742, 486, 998, 22, 534, 278, 790, 150, 662, 406, 918, 86, 598, 342, 854, 214, 726, 470, 982, 54, 566, 310, 822, 182, 694, 438, 950, 118, 630, 374, 886, 246, 758, 502, 1014, 14, 526, 270, 782, 142, 654, 398, 910, 78, 590, 334, 846, 206, 718, 462, 974, 46, 558, 302, 814, 174, 686, 430, 942, 110, 622, 366, 878, 238, 750, 494, 1006, 30, 542, 286, 798, 158, 670, 414, 926, 94, 606, 350, 862, 222, 734, 478, 990, 62, 574, 318, 830, 190, 702, 446, 958, 126, 638, 382, 894, 254, 766, 510, 1022, 1, 513, 257, 769, 129, 641, 385, 897, 65, 577, 321, 833, 193, 705, 449, 961, 33, 545, 289, 801, 161, 673, 417, 929, 97, 609, 353, 865, 225, 737, 481, 993, 17, 529, 273, 785, 145, 657, 401, 913, 81, 593, 337, 849, 209, 721, 465, 977, 49, 561, 305, 817, 177, 689, 433, 945, 113, 625, 369, 881, 241, 753, 497, 1009, 9, 521, 265, 777, 137, 649, 393, 905, 73, 585, 329, 841, 201, 713, 457, 969, 41, 553, 297, 809, 169, 681, 425, 937, 105, 617, 361, 873, 233, 745, 489, 1001, 25, 537, 281, 793, 153, 665, 409, 921, 89, 601, 345, 857, 217, 729, 473, 985, 57, 569, 313, 825, 185, 697, 441, 953, 121, 633, 377, 889, 249, 761, 505, 1017, 5, 517, 261, 773, 133, 645, 389, 901, 69, 581, 325, 837, 197, 709, 453, 965, 37, 549, 293, 805, 165, 677, 421, 933, 101, 613, 357, 869, 229, 741, 485, 997, 21, 533, 277, 789, 149, 661, 405, 917, 85, 597, 341, 853, 213, 725, 469, 981, 53, 565, 309, 821, 181, 693, 437, 949, 117, 629, 373, 885, 245, 757, 501, 1013, 13, 525, 269, 781, 141, 653, 397, 909, 77, 589, 333, 845, 205, 717, 461, 973, 45, 557, 301, 813, 173, 685, 429, 941, 109, 621, 365, 877, 237, 749, 493, 1005, 29, 541, 285, 797, 157, 669, 413, 925, 93, 605, 349, 861, 221, 733, 477, 989, 61, 573, 317, 829, 189, 701, 445, 957, 125, 637, 381, 893, 253, 765, 509, 1021, 3, 515, 259, 771, 131, 643, 387, 899, 67, 579, 323, 835, 195, 707, 451, 963, 35, 547, 291, 803, 163, 675, 419, 931, 99, 611, 355, 867, 227, 739, 483, 995, 19, 531, 275, 787, 147, 659, 403, 915, 83, 595, 339, 851, 211, 723, 467, 979, 51, 563, 307, 819, 179, 691, 435, 947, 115, 627, 371, 883, 243, 755, 499, 1011, 11, 523, 267, 779, 139, 651, 395, 907, 75, 587, 331, 843, 203, 715, 459, 971, 43, 555, 299, 811, 171, 683, 427, 939, 107, 619, 363, 875, 235, 747, 491, 1003, 27, 539, 283, 795, 155, 667, 411, 923, 91, 603, 347, 859, 219, 731, 475, 987, 59, 571, 315, 827, 187, 699, 443, 955, 123, 635, 379, 891, 251, 763, 507, 1019, 7, 519, 263, 775, 135, 647, 391, 903, 71, 583, 327, 839, 199, 711, 455, 967, 39, 551, 295, 807, 167, 679, 423, 935, 103, 615, 359, 871, 231, 743, 487, 999, 23, 535, 279, 791, 151, 663, 407, 919, 87, 599, 343, 855, 215, 727, 471, 983, 55, 567, 311, 823, 183, 695, 439, 951, 119, 631, 375, 887, 247, 759, 503, 1015, 15, 527, 271, 783, 143, 655, 399, 911, 79, 591, 335, 847, 207, 719, 463, 975, 47, 559, 303, 815, 175, 687, 431, 943, 111, 623, 367, 879, 239, 751, 495, 1007, 31, 543, 287, 799, 159, 671, 415, 927, 
    95, 607, 351, 863, 223, 735, 479, 991, 63, 575, 319, 831, 191, 703, 447, 959, 127, 639, 383, 895, 255, 767, 511, 1023};
    private static final long[] gauss_1024_12289 = {1283868770400643928L, 6416574995475331444L, 4078260278032692663L, 2353523259288686585L, 1227179971273316331L, 575931623374121527L, 242543240509105209L, 91437049221049666L, 30799446349977173L, 9255276791179340L, 2478152334826140L, 590642893610164L, 125206034929641L, 23590435911403L, 3948334035941L, 586753615614L, 77391054539L, 9056793210L, 940121950, 86539696, 7062824, 510971, 32764, 1862, 94, 4, 0};
    private static final int[] MAX_BL_SMALL = {1, 1, 2, 2, 4, 7, 14, 27, 53, 106, 209};
    private static final int[] MAX_BL_LARGE = {2, 2, 5, 7, 12, 21, 40, 78, 157, 308};
    private static final int[] bitlength_avg = {4, 11, 24, 50, 102, 202, 401, 794, 1577, 3138, 6308};
    private static final int[] bitlength_std = {0, 1, 1, 1, 1, 2, 4, 5, 8, 13, 25};

    FalconKeyGen() {
    }

    private static long get_rng_u64(SHAKEDigest sHAKEDigest) {
        byte[] bArr = new byte[8];
        sHAKEDigest.doOutput(bArr, 0, 8);
        return Pack.littleEndianToLong(bArr, 0);
    }

    static void keygen(SHAKEDigest sHAKEDigest, byte[] bArr, byte[] bArr2, byte[] bArr3, short[] sArr, int i) {
        int i2;
        int i3;
        byte b;
        byte[] bArr4 = bArr;
        byte[] bArr5 = bArr2;
        int i4 = i;
        int iMkn = mkn(i4);
        short[] sArr2 = sArr;
        while (true) {
            double[] dArr = new double[iMkn * 3];
            poly_small_mkgauss(sHAKEDigest, bArr4, i4);
            poly_small_mkgauss(sHAKEDigest, bArr5, i4);
            int i5 = 1 << (FalconCodec.max_fg_bits[i4] - 1);
            for (int i6 = 0; i6 < iMkn; i6++) {
                byte b2 = bArr4[i6];
                if (b2 >= i5 || b2 <= (i3 = -i5) || (b = bArr5[i6]) >= i5 || b <= i3) {
                    i5 = -1;
                    break;
                }
            }
            if (i5 >= 0) {
                int iPoly_small_sqnorm = poly_small_sqnorm(bArr4, i4);
                int iPoly_small_sqnorm2 = poly_small_sqnorm(bArr5, i4);
                if ((((long) ((-((iPoly_small_sqnorm | iPoly_small_sqnorm2) >>> 31)) | (iPoly_small_sqnorm + iPoly_small_sqnorm2))) & 4294967295L) >= 16823) {
                    continue;
                } else {
                    int i7 = iMkn + iMkn;
                    poly_small_to_fp(dArr, 0, bArr4, i4);
                    poly_small_to_fp(dArr, iMkn, bArr5, i4);
                    FalconFFT.FFT(dArr, 0, i4);
                    FalconFFT.FFT(dArr, iMkn, i4);
                    FalconFFT.poly_invnorm2_fft(dArr, i7, dArr, 0, dArr, iMkn, i4);
                    FalconFFT.poly_adj_fft(dArr, 0, i4);
                    FalconFFT.poly_adj_fft(dArr, iMkn, i4);
                    FalconFFT.poly_mulconst(dArr, 0, 12289.0d, i4);
                    FalconFFT.poly_mulconst(dArr, iMkn, 12289.0d, i4);
                    FalconFFT.poly_mul_autoadj_fft(dArr, 0, dArr, i7, i4);
                    FalconFFT.poly_mul_autoadj_fft(dArr, iMkn, dArr, i7, i4);
                    FalconFFT.iFFT(dArr, 0, i4);
                    FalconFFT.iFFT(dArr, iMkn, i4);
                    double d = 0.0d;
                    for (int i8 = 0; i8 < iMkn; i8++) {
                        double d2 = dArr[i8];
                        double d3 = dArr[iMkn + i8];
                        d += (d2 * d2) + (d3 * d3);
                    }
                    if (d >= 16822.4121d) {
                        continue;
                    } else {
                        short[] sArr3 = new short[iMkn * 2];
                        if (sArr2 == null) {
                            sArr2 = sArr3;
                            i2 = iMkn;
                        } else {
                            i2 = 0;
                        }
                        int iCompute_public = FalconVrfy.compute_public(sArr2, 0, bArr4, bArr5, i4, sArr3, i2);
                        short[] sArr4 = sArr2;
                        if (iCompute_public != 0) {
                            if (solve_NTRU(i4, bArr3, bArr, bArr2, (1 << (FalconCodec.max_FG_bits[i4] - 1)) - 1, new int[i4 > 2 ? iMkn * 28 : iMkn * 84]) != 0) {
                                return;
                            }
                        }
                        bArr4 = bArr;
                        bArr5 = bArr2;
                        i4 = i;
                        sArr2 = sArr4;
                    }
                }
            }
        }
    }

    private static void make_fg(int[] iArr, int i, byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        int iMkn = mkn(i2);
        int i5 = i + iMkn;
        int i6 = FalconSmallPrimeList.PRIMES[0].p;
        for (int i7 = 0; i7 < iMkn; i7++) {
            iArr[i + i7] = modp_set(bArr[i7], i6);
            iArr[i5 + i7] = modp_set(bArr2[i7], i6);
        }
        if (i3 != 0 || i4 == 0) {
            int i8 = 0;
            while (i8 < i3) {
                int i9 = i8 + 1;
                make_fg_step(iArr, i, i2 - i8, i8, i8 != 0 ? 1 : 0, (i9 < i3 || i4 != 0) ? 1 : 0);
                i8 = i9;
            }
            return;
        }
        int i10 = FalconSmallPrimeList.PRIMES[0].p;
        int iModp_ninv31 = modp_ninv31(i10);
        int i11 = i5 + iMkn;
        modp_mkgm2(iArr, i11, iArr, i11 + iMkn, i2, FalconSmallPrimeList.PRIMES[0].g, i10, iModp_ninv31);
        modp_NTT2(iArr, i, iArr, i11, i2, i10, iModp_ninv31);
        modp_NTT2(iArr, i5, iArr, i11, i2, i10, iModp_ninv31);
    }

    private static void make_fg_step(int[] iArr, int i, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int[] iArr2 = iArr;
        boolean z = true;
        int i15 = 1 << i2;
        int i16 = i15 >> 1;
        int[] iArr3 = MAX_BL_SMALL;
        int i17 = iArr3[i3];
        int i18 = iArr3[i3 + 1];
        int i19 = i16 * i18;
        int i20 = i + i19;
        int i21 = i20 + i19;
        int i22 = i15 * i17;
        int i23 = i21 + i22;
        int i24 = i23 + i22;
        int i25 = i24 + i15;
        int i26 = i25 + i15;
        System.arraycopy(iArr2, i, iArr2, i21, i15 * 2 * i17);
        int i27 = 0;
        while (i27 < i17) {
            int i28 = FalconSmallPrimeList.PRIMES[i27].p;
            int iModp_ninv31 = modp_ninv31(i28);
            int iModp_R2 = modp_R2(i28, iModp_ninv31);
            int i29 = FalconSmallPrimeList.PRIMES[i27].g;
            boolean z2 = z;
            int i30 = i27;
            int i31 = i24;
            int i32 = i25;
            modp_mkgm2(iArr2, i31, iArr, i32, i2, i29, i28, iModp_ninv31);
            int i33 = iModp_ninv31;
            int i34 = i21 + i30;
            int i35 = 0;
            int i36 = i34;
            while (i35 < i15) {
                iArr[i26 + i35] = iArr[i36];
                i35++;
                i36 += i17;
            }
            if (i4 == 0) {
                int i37 = i26;
                modp_NTT2(iArr, i37, iArr, i31, i2, i28, i33);
                i8 = i37;
                i33 = i33;
                i28 = i28;
            } else {
                i8 = i26;
            }
            int i38 = i + i30;
            int i39 = 0;
            int i40 = i38;
            while (i39 < i16) {
                int i41 = i8 + (i39 << 1);
                iArr[i40] = modp_montymul(modp_montymul(iArr[i41], iArr[i41 + 1], i28, i33), iModp_R2, i28, i33);
                i39++;
                i40 += i18;
            }
            if (i4 != 0) {
                int i42 = i17;
                int i43 = i33;
                modp_iNTT2_ext(iArr, i34, i42, iArr, i32, i2, i28, i43);
                i9 = i32;
                i33 = i43;
                i10 = i42;
            } else {
                int i44 = i17;
                i9 = i32;
                i10 = i44;
            }
            int i45 = i23 + i30;
            int i46 = 0;
            int i47 = i45;
            while (i46 < i15) {
                iArr[i8 + i46] = iArr[i47];
                i46++;
                i47 += i10;
            }
            if (i4 == 0) {
                int i48 = i28;
                int i49 = i33;
                modp_NTT2(iArr, i8, iArr, i31, i2, i48, i49);
                i33 = i49;
                i28 = i48;
            }
            int i50 = i20 + i30;
            int i51 = 0;
            int i52 = i50;
            while (i51 < i16) {
                int i53 = i8 + (i51 << 1);
                iArr[i52] = modp_montymul(modp_montymul(iArr[i53], iArr[i53 + 1], i28, i33), iModp_R2, i28, i33);
                i51++;
                i52 += i18;
            }
            if (i4 != 0) {
                int i54 = i10;
                i12 = i9;
                i13 = i33;
                modp_iNTT2_ext(iArr, i45, i54, iArr, i12, i2, i28, i13);
                i11 = i54;
            } else {
                i11 = i10;
                i12 = i9;
                i13 = i33;
            }
            if (i5 == 0) {
                int i55 = i2 - 1;
                int i56 = i18;
                modp_iNTT2_ext(iArr, i38, i56, iArr, i12, i55, i28, i13);
                modp_iNTT2_ext(iArr, i50, i56, iArr, i12, i55, i28, i13);
                i14 = i56;
            } else {
                i14 = i18;
            }
            i27 = i30 + 1;
            iArr2 = iArr;
            i25 = i12;
            i24 = i31;
            i26 = i8;
            i18 = i14;
            i17 = i11;
            z = z2;
        }
        int i57 = i17;
        int i58 = i18;
        int i59 = i26;
        int i60 = i24;
        int i61 = i25;
        zint_rebuild_CRT(iArr, i21, i57, i57, i15, 1, iArr, i60);
        zint_rebuild_CRT(iArr, i23, i57, i57, i15, 1, iArr, i60);
        int i62 = i60;
        int i63 = i57;
        while (i63 < i58) {
            int i64 = FalconSmallPrimeList.PRIMES[i63].p;
            int iModp_ninv32 = modp_ninv31(i64);
            int iModp_R3 = modp_R2(i64, iModp_ninv32);
            int iModp_Rx = modp_Rx(i57, i64, iModp_ninv32, iModp_R3);
            int i65 = iModp_R3;
            int i66 = i62;
            int i67 = i61;
            int i68 = i63;
            modp_mkgm2(iArr, i66, iArr, i67, i2, FalconSmallPrimeList.PRIMES[i63].g, i64, iModp_ninv32);
            int i69 = i21;
            int i70 = 0;
            while (i70 < i15) {
                int i71 = i64;
                int i72 = i57;
                int i73 = iModp_Rx;
                int i74 = i65;
                int iZint_mod_small_signed = zint_mod_small_signed(iArr, i69, i72, i71, iModp_ninv32, i74, i73);
                i64 = i71;
                iArr[i59 + i70] = iZint_mod_small_signed;
                i70++;
                i69 += i72;
                i57 = i72;
                iModp_Rx = i73;
                i65 = i74;
            }
            int i75 = iModp_Rx;
            int i76 = i65;
            int i77 = i57;
            int i78 = i76;
            int i79 = i64;
            modp_NTT2(iArr, i59, iArr, i66, i2, i79, iModp_ninv32);
            int i80 = i79;
            int i81 = i + i68;
            int i82 = i81;
            int i83 = 0;
            while (i83 < i16) {
                int i84 = i59 + (i83 << 1);
                iArr[i82] = modp_montymul(modp_montymul(iArr[i84], iArr[i84 + 1], i80, iModp_ninv32), i78, i80, iModp_ninv32);
                i83++;
                i82 += i58;
            }
            int i85 = i23;
            for (int i86 = 0; i86 < i15; i86++) {
                int i87 = i80;
                int i88 = i78;
                int i89 = i77;
                int i90 = i75;
                int iZint_mod_small_signed2 = zint_mod_small_signed(iArr, i85, i89, i87, iModp_ninv32, i88, i90);
                i80 = i87;
                iArr[i59 + i86] = iZint_mod_small_signed2;
                i85 += i89;
                i78 = i88;
                i77 = i89;
                i75 = i90;
            }
            int i91 = i77;
            int i92 = i80;
            modp_NTT2(iArr, i59, iArr, i66, i2, i92, iModp_ninv32);
            int i93 = i20 + i68;
            int i94 = 0;
            int i95 = i93;
            while (i94 < i16) {
                int i96 = i59 + (i94 << 1);
                iArr[i95] = modp_montymul(modp_montymul(iArr[i96], iArr[i96 + 1], i92, iModp_ninv32), i78, i92, iModp_ninv32);
                i94++;
                i95 += i58;
            }
            if (i5 == 0) {
                int i97 = i2 - 1;
                i6 = i58;
                i7 = i67;
                modp_iNTT2_ext(iArr, i81, i6, iArr, i7, i97, i92, iModp_ninv32);
                modp_iNTT2_ext(iArr, i93, i6, iArr, i7, i97, i92, iModp_ninv32);
            } else {
                i6 = i58;
                i7 = i67;
            }
            i63 = i68 + 1;
            i58 = i6;
            i61 = i7;
            i62 = i66;
            i57 = i91;
        }
    }

    private static int mkgauss(SHAKEDigest sHAKEDigest, int i) {
        int i2 = 1 << (10 - i);
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            long j = get_rng_u64(sHAKEDigest);
            int i5 = (int) (j >>> 63);
            int i6 = (int) (((j & Long.MAX_VALUE) - gauss_1024_12289[0]) >>> 63);
            long j2 = Long.MAX_VALUE & get_rng_u64(sHAKEDigest);
            int i7 = 1;
            int i8 = 0;
            while (true) {
                long[] jArr = gauss_1024_12289;
                if (i7 < jArr.length) {
                    int i9 = ((int) ((j2 - jArr[i7]) >>> 63)) ^ 1;
                    i8 |= (-((i6 ^ 1) & i9)) & i7;
                    i6 |= i9;
                    i7++;
                }
            }
            i3 += ((-i5) ^ i8) + i5;
        }
        return i3;
    }

    private static int mkn(int i) {
        return 1 << i;
    }

    private static void modp_NTT2(int[] iArr, int i, int[] iArr2, int i2, int i3, int i4, int i5) {
        modp_NTT2_ext(iArr, i, 1, iArr2, i2, i3, i4, i5);
    }

    private static void modp_NTT2_ext(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6) {
        if (i4 == 0) {
            return;
        }
        int iMkn = mkn(i4);
        int i7 = 1;
        int i8 = iMkn;
        while (i7 < iMkn) {
            int i9 = i8 >> 1;
            int i10 = 0;
            int i11 = 0;
            while (i10 < i7) {
                int i12 = iArr2[i3 + i7 + i10];
                int i13 = i + (i11 * i2);
                int i14 = (i9 * i2) + i13;
                int i15 = 0;
                while (i15 < i9) {
                    int i16 = iArr[i13];
                    int iModp_montymul = modp_montymul(iArr[i14], i12, i5, i6);
                    iArr[i13] = modp_add(i16, iModp_montymul, i5);
                    iArr[i14] = modp_sub(i16, iModp_montymul, i5);
                    i15++;
                    i13 += i2;
                    i14 += i2;
                }
                i10++;
                i11 += i8;
            }
            i7 <<= 1;
            i8 = i9;
        }
    }

    private static int modp_R(int i) {
        return Integer.MIN_VALUE - i;
    }

    private static int modp_R2(int i, int i2) {
        int iModp_R = modp_R(i);
        int iModp_add = modp_add(iModp_R, iModp_R, i);
        int iModp_montymul = modp_montymul(iModp_add, iModp_add, i, i2);
        int iModp_montymul2 = modp_montymul(iModp_montymul, iModp_montymul, i, i2);
        int iModp_montymul3 = modp_montymul(iModp_montymul2, iModp_montymul2, i, i2);
        int iModp_montymul4 = modp_montymul(iModp_montymul3, iModp_montymul3, i, i2);
        int iModp_montymul5 = modp_montymul(iModp_montymul4, iModp_montymul4, i, i2);
        return (iModp_montymul5 + (i & (-(iModp_montymul5 & 1)))) >>> 1;
    }

    private static int modp_Rx(int i, int i2, int i3, int i4) {
        int i5 = i - 1;
        int iModp_R = modp_R(i2);
        int i6 = 0;
        while (true) {
            int i7 = 1 << i6;
            if (i7 > i5) {
                return iModp_R;
            }
            if ((i7 & i5) != 0) {
                iModp_R = modp_montymul(iModp_R, i4, i2, i3);
            }
            i4 = modp_montymul(i4, i4, i2, i3);
            i6++;
        }
    }

    private static int modp_add(int i, int i2, int i3) {
        int i4 = (i + i2) - i3;
        return i4 + ((-(i4 >>> 31)) & i3);
    }

    private static int modp_div(int i, int i2, int i3, int i4, int i5) {
        int i6 = i3 - 2;
        for (int i7 = 30; i7 >= 0; i7--) {
            int iModp_montymul = modp_montymul(i5, i5, i3, i4);
            i5 = iModp_montymul ^ ((-(1 & (i6 >>> i7))) & (modp_montymul(iModp_montymul, i2, i3, i4) ^ iModp_montymul));
        }
        return modp_montymul(i, modp_montymul(i5, 1, i3, i4), i3, i4);
    }

    private static void modp_iNTT2(int[] iArr, int i, int[] iArr2, int i2, int i3, int i4, int i5) {
        modp_iNTT2_ext(iArr, i, 1, iArr2, i2, i3, i4, i5);
    }

    private static void modp_iNTT2_ext(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6) {
        int i7;
        if (i4 == 0) {
            return;
        }
        int iMkn = mkn(i4);
        int i8 = iMkn;
        int i9 = 1;
        while (true) {
            i7 = 0;
            if (i8 <= 1) {
                break;
            }
            i8 >>= 1;
            int i10 = i9 << 1;
            int i11 = 0;
            int i12 = 0;
            while (i11 < i8) {
                int i13 = iArr2[i3 + i8 + i11];
                int i14 = i + (i12 * i2);
                int i15 = (i9 * i2) + i14;
                int i16 = 0;
                while (i16 < i9) {
                    int i17 = iArr[i14];
                    int i18 = iArr[i15];
                    iArr[i14] = modp_add(i17, i18, i5);
                    iArr[i15] = modp_montymul(modp_sub(i17, i18, i5), i13, i5, i6);
                    i16++;
                    i14 += i2;
                    i15 += i2;
                }
                i11++;
                i12 += i10;
            }
            i9 = i10;
        }
        int i19 = 1 << (31 - i4);
        int i20 = i;
        while (i7 < iMkn) {
            iArr[i20] = modp_montymul(iArr[i20], i19, i5, i6);
            i7++;
            i20 += i2;
        }
    }

    private static void modp_mkgm2(int[] iArr, int i, int[] iArr2, int i2, int i3, int i4, int i5, int i6) {
        int iMkn = mkn(i3);
        int iModp_R2 = modp_R2(i5, i6);
        int iModp_montymul = modp_montymul(i4, iModp_R2, i5, i6);
        for (int i7 = i3; i7 < 10; i7++) {
            iModp_montymul = modp_montymul(iModp_montymul, iModp_montymul, i5, i6);
        }
        int iModp_div = modp_div(iModp_R2, iModp_montymul, i5, i6, modp_R(i5));
        int i8 = 10 - i3;
        int iModp_R = modp_R(i5);
        int iModp_montymul2 = iModp_R;
        for (int i9 = 0; i9 < iMkn; i9++) {
            short s = REV10[i9 << i8];
            iArr[i + s] = iModp_R;
            iArr2[s + i2] = iModp_montymul2;
            iModp_R = modp_montymul(iModp_R, iModp_montymul, i5, i6);
            iModp_montymul2 = modp_montymul(iModp_montymul2, iModp_div, i5, i6);
        }
    }

    private static int modp_montymul(int i, int i2, int i3, int i4) {
        long unsignedLong = toUnsignedLong(i) * toUnsignedLong(i2);
        int i5 = ((int) ((unsignedLong + (((((long) i4) * unsignedLong) & SieveCacheKt.NodeLinkMask) * ((long) i3))) >>> 31)) - i3;
        return i5 + ((-(i5 >>> 31)) & i3);
    }

    private static int modp_ninv31(int i) {
        int i2 = 2 - i;
        int i3 = i2 * (2 - (i * i2));
        int i4 = i3 * (2 - (i * i3));
        int i5 = i4 * (2 - (i * i4));
        return Integer.MAX_VALUE & (-(i5 * (2 - (i * i5))));
    }

    private static int modp_norm(int i, int i2) {
        return i - (i2 & (((i - ((i2 + 1) >>> 1)) >>> 31) - 1));
    }

    private static void modp_poly_rec_res(int[] iArr, int i, int i2, int i3, int i4, int i5) {
        int i6 = 1 << (i2 - 1);
        for (int i7 = 0; i7 < i6; i7++) {
            int i8 = (i7 << 1) + i;
            iArr[i + i7] = modp_montymul(modp_montymul(iArr[i8], iArr[i8 + 1], i3, i4), i5, i3, i4);
        }
    }

    private static int modp_set(int i, int i2) {
        return i + (i2 & (-(i >>> 31)));
    }

    private static int modp_sub(int i, int i2, int i3) {
        int i4 = i - i2;
        return i4 + ((-(i4 >>> 31)) & i3);
    }

    private static void poly_big_to_fp(double[] dArr, int[] iArr, int i, int i2, int i3, int i4) {
        int iMkn = mkn(i4);
        double d = 0.0d;
        if (i2 == 0) {
            for (int i5 = 0; i5 < iMkn; i5++) {
                dArr[i5] = 0.0d;
            }
            return;
        }
        int i6 = i;
        int i7 = 0;
        while (i7 < iMkn) {
            int i8 = -(iArr[(i6 + i2) - 1] >>> 30);
            int i9 = i8 >>> 1;
            int i10 = i8 & 1;
            double d2 = 1.0d;
            double d3 = d;
            int i11 = 0;
            while (i11 < i2) {
                int i12 = (iArr[i6 + i11] ^ i9) + i10;
                i10 = i12 >>> 31;
                int i13 = i12 & Integer.MAX_VALUE;
                d3 += ((double) (i13 - ((i13 << 1) & i8))) * d2;
                i11++;
                d2 *= 2.147483648E9d;
            }
            dArr[i7] = d3;
            i7++;
            i6 += i3;
            d = 0.0d;
        }
    }

    private static int poly_big_to_small(byte[] bArr, int i, int[] iArr, int i2, int i3, int i4) {
        int iMkn = mkn(i4);
        for (int i5 = 0; i5 < iMkn; i5++) {
            int iZint_one_to_plain = zint_one_to_plain(iArr, i2 + i5);
            if (iZint_one_to_plain < (-i3) || iZint_one_to_plain > i3) {
                return 0;
            }
            bArr[i + i5] = (byte) iZint_one_to_plain;
        }
        return 1;
    }

    private static void poly_small_mkgauss(SHAKEDigest sHAKEDigest, byte[] bArr, int i) {
        int iMkgauss;
        int iMkn = mkn(i);
        int i2 = 0;
        for (int i3 = 0; i3 < iMkn; i3++) {
            while (true) {
                iMkgauss = mkgauss(sHAKEDigest, i);
                if (iMkgauss >= -127 && iMkgauss <= 127) {
                    if (i3 == iMkn - 1) {
                        if (((iMkgauss & 1) ^ i2) != 0) {
                            break;
                        }
                    } else {
                        i2 ^= iMkgauss & 1;
                        break;
                    }
                }
            }
            bArr[i3] = (byte) iMkgauss;
        }
    }

    private static int poly_small_sqnorm(byte[] bArr, int i) {
        int iMkn = mkn(i);
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < iMkn; i4++) {
            byte b = bArr[i4];
            i2 += b * b;
            i3 |= i2;
        }
        return (-(i3 >>> 31)) | i2;
    }

    private static void poly_small_to_fp(double[] dArr, int i, byte[] bArr, int i2) {
        int iMkn = mkn(i2);
        for (int i3 = 0; i3 < iMkn; i3++) {
            dArr[i + i3] = bArr[i3];
        }
    }

    private static void poly_sub_scaled(int[] iArr, int i, int i2, int i3, int[] iArr2, int i4, int i5, int i6, int[] iArr3, int i7, int i8, int i9) {
        int iMkn = mkn(i9);
        for (int i10 = 0; i10 < iMkn; i10++) {
            int i11 = i4;
            int i12 = -iArr3[i10];
            int i13 = (i10 * i3) + i;
            for (int i14 = 0; i14 < iMkn; i14++) {
                zint_add_scaled_mul_small(iArr, i13, i2, iArr2, i11, i5, i12, i7, i8);
                if (i10 + i14 == iMkn - 1) {
                    i13 = i;
                    i12 = -i12;
                } else {
                    i13 += i3;
                }
                i11 += i6;
            }
        }
    }

    private static void poly_sub_scaled_ntt(int[] iArr, int i, int i2, int i3, int[] iArr2, int i4, int i5, int i6, int[] iArr3, int i7, int i8, int i9, int[] iArr4, int i10) {
        int i11 = i5;
        int iMkn = mkn(i9);
        int i12 = i11 + 1;
        int iMkn2 = i10 + mkn(i9);
        int iMkn3 = iMkn2 + mkn(i9);
        int i13 = iMkn3 + (iMkn * i12);
        int i14 = 0;
        while (i14 < i12) {
            int i15 = FalconSmallPrimeList.PRIMES[i14].p;
            int iModp_ninv31 = modp_ninv31(i15);
            int iModp_R2 = modp_R2(i15, iModp_ninv31);
            int iModp_Rx = modp_Rx(i11, i15, iModp_ninv31, iModp_R2);
            int i16 = iMkn2;
            modp_mkgm2(iArr4, i10, iArr4, i16, i9, FalconSmallPrimeList.PRIMES[i14].g, i15, iModp_ninv31);
            for (int i17 = 0; i17 < iMkn; i17++) {
                iArr4[i13 + i17] = modp_set(iArr3[i17], i15);
            }
            modp_NTT2(iArr4, i13, iArr4, i10, i9, i15, iModp_ninv31);
            int i18 = iMkn3 + i14;
            int i19 = i4;
            int i20 = i18;
            int i21 = 0;
            while (i21 < iMkn) {
                iArr4[i20] = zint_mod_small_signed(iArr2, i19, i11, i15, iModp_ninv31, iModp_R2, iModp_Rx);
                i21++;
                i19 += i6;
                i20 += i12;
                i11 = i5;
            }
            int i22 = i14;
            modp_NTT2_ext(iArr4, i18, i12, iArr4, i10, i9, i15, iModp_ninv31);
            int i23 = i18;
            int i24 = 0;
            while (i24 < iMkn) {
                iArr4[i23] = modp_montymul(modp_montymul(iArr4[i13 + i24], iArr4[i23], i15, iModp_ninv31), iModp_R2, i15, iModp_ninv31);
                i24++;
                i23 += i12;
            }
            iMkn2 = i16;
            modp_iNTT2_ext(iArr4, i18, i12, iArr4, iMkn2, i9, i15, iModp_ninv31);
            i14 = i22 + 1;
            i11 = i5;
        }
        zint_rebuild_CRT(iArr4, iMkn3, i12, i12, iMkn, 1, iArr4, i13);
        int i25 = i;
        int i26 = iMkn3;
        int i27 = 0;
        while (i27 < iMkn) {
            int i28 = i12;
            zint_sub_scaled(iArr, i25, i2, iArr4, i26, i28, i7, i8);
            i12 = i28;
            i27++;
            i25 += i3;
            i26 += i12;
        }
    }

    private static int solve_NTRU(int i, byte[] bArr, byte[] bArr2, byte[] bArr3, int i2, int[] iArr) {
        int iMkn = mkn(i);
        if (solve_NTRU_deepest(i, bArr2, bArr3, iArr) == 0) {
            return 0;
        }
        if (i > 2) {
            int i3 = i;
            while (true) {
                int i4 = i3 - 1;
                if (i3 <= 2) {
                    if (solve_NTRU_binary_depth1(i, bArr2, bArr3, iArr) != 0 && solve_NTRU_binary_depth0(i, bArr2, bArr3, iArr) != 0) {
                        break;
                    }
                    return 0;
                }
                if (solve_NTRU_intermediate(i, bArr2, bArr3, i4, iArr) == 0) {
                    return 0;
                }
                i3 = i4;
            }
        } else {
            int i5 = i;
            while (true) {
                int i6 = i5 - 1;
                if (i5 <= 0) {
                    break;
                }
                if (solve_NTRU_intermediate(i, bArr2, bArr3, i6, iArr) == 0) {
                    return 0;
                }
                i5 = i6;
            }
        }
        byte[] bArr4 = new byte[iMkn];
        if (poly_big_to_small(bArr, 0, iArr, 0, i2, i) == 0 || poly_big_to_small(bArr4, 0, iArr, iMkn, i2, i) == 0) {
            return 0;
        }
        int i7 = iMkn + iMkn;
        int i8 = i7 + iMkn;
        int i9 = i8 + iMkn;
        int i10 = FalconSmallPrimeList.PRIMES[0].p;
        int iModp_ninv31 = modp_ninv31(i10);
        modp_mkgm2(iArr, i9, iArr, 0, i, FalconSmallPrimeList.PRIMES[0].g, i10, iModp_ninv31);
        for (int i11 = 0; i11 < iMkn; i11++) {
            iArr[i11] = modp_set(bArr4[i11], i10);
        }
        for (int i12 = 0; i12 < iMkn; i12++) {
            iArr[iMkn + i12] = modp_set(bArr2[i12], i10);
            iArr[i7 + i12] = modp_set(bArr3[i12], i10);
            iArr[i8 + i12] = modp_set(bArr[i12], i10);
        }
        modp_NTT2(iArr, iMkn, iArr, i9, i, i10, iModp_ninv31);
        modp_NTT2(iArr, i7, iArr, i9, i, i10, iModp_ninv31);
        modp_NTT2(iArr, i8, iArr, i9, i, i10, iModp_ninv31);
        modp_NTT2(iArr, 0, iArr, i9, i, i10, iModp_ninv31);
        int iModp_montymul = modp_montymul(12289, 1, i10, iModp_ninv31);
        for (int i13 = 0; i13 < iMkn; i13++) {
            if (modp_sub(modp_montymul(iArr[iMkn + i13], iArr[i13], i10, iModp_ninv31), modp_montymul(iArr[i7 + i13], iArr[i8 + i13], i10, iModp_ninv31), i10) != iModp_montymul) {
                return 0;
            }
        }
        return 1;
    }

    private static int solve_NTRU_binary_depth0(int i, byte[] bArr, byte[] bArr2, int[] iArr) {
        int i2 = 1;
        int i3 = 1 << i;
        int i4 = i3 >> 1;
        int i5 = 0;
        int i6 = FalconSmallPrimeList.PRIMES[0].p;
        int iModp_ninv31 = modp_ninv31(i6);
        int iModp_R2 = modp_R2(i6, iModp_ninv31);
        int i7 = i4 + i4;
        int i8 = i7 + i3;
        int i9 = i8 + i3;
        int i10 = i9 + i3;
        modp_mkgm2(iArr, i9, iArr, i10, i, FalconSmallPrimeList.PRIMES[0].g, i6, iModp_ninv31);
        for (int i11 = 0; i11 < i4; i11++) {
            iArr[i11] = modp_set(zint_one_to_plain(iArr, i11), i6);
            int i12 = i4 + i11;
            iArr[i12] = modp_set(zint_one_to_plain(iArr, i12), i6);
        }
        int i13 = i - 1;
        modp_NTT2(iArr, 0, iArr, i9, i13, i6, iModp_ninv31);
        modp_NTT2(iArr, i4, iArr, i9, i13, i6, iModp_ninv31);
        for (int i14 = 0; i14 < i3; i14++) {
            iArr[i7 + i14] = modp_set(bArr[i14], i6);
            iArr[i8 + i14] = modp_set(bArr2[i14], i6);
        }
        modp_NTT2(iArr, i7, iArr, i9, i, i6, iModp_ninv31);
        modp_NTT2(iArr, i8, iArr, i9, i, i6, iModp_ninv31);
        int i15 = 0;
        while (i15 < i3) {
            int i16 = i7 + i15;
            int i17 = iArr[i16];
            int i18 = i16 + 1;
            int i19 = iArr[i18];
            int i20 = i8 + i15;
            int i21 = i2;
            int i22 = iArr[i20];
            int i23 = i20 + 1;
            int i24 = i5;
            int i25 = iArr[i23];
            int i26 = i15 >> 1;
            int iModp_montymul = modp_montymul(iArr[i26], iModp_R2, i6, iModp_ninv31);
            int i27 = i15;
            int iModp_montymul2 = modp_montymul(iArr[i4 + i26], iModp_R2, i6, iModp_ninv31);
            iArr[i16] = modp_montymul(i25, iModp_montymul, i6, iModp_ninv31);
            iArr[i18] = modp_montymul(i22, iModp_montymul, i6, iModp_ninv31);
            iArr[i20] = modp_montymul(i19, iModp_montymul2, i6, iModp_ninv31);
            iArr[i23] = modp_montymul(i17, iModp_montymul2, i6, iModp_ninv31);
            i15 = i27 + 2;
            i2 = i21;
            i5 = i24;
        }
        int i28 = i2;
        int i29 = i5;
        modp_iNTT2(iArr, i7, iArr, i10, i, i6, iModp_ninv31);
        modp_iNTT2(iArr, i8, iArr, i10, i, i6, iModp_ninv31);
        int i30 = i3 + i3;
        System.arraycopy(iArr, i7, iArr, 0, i3 * 2);
        int i31 = i30 + i3;
        int i32 = i31 + i3;
        int i33 = i32 + i3;
        int i34 = i33 + i3;
        modp_mkgm2(iArr, i30, iArr, i31, i, FalconSmallPrimeList.PRIMES[i29].g, i6, iModp_ninv31);
        modp_NTT2(iArr, 0, iArr, i30, i, i6, iModp_ninv31);
        modp_NTT2(iArr, i3, iArr, i30, i, i6, iModp_ninv31);
        int iModp_set = modp_set(bArr[i29], i6);
        iArr[i34] = iModp_set;
        iArr[i33] = iModp_set;
        for (int i35 = i28; i35 < i3; i35++) {
            iArr[i33 + i35] = modp_set(bArr[i35], i6);
            iArr[(i34 + i3) - i35] = modp_set(-bArr[i35], i6);
        }
        modp_NTT2(iArr, i33, iArr, i30, i, i6, iModp_ninv31);
        modp_NTT2(iArr, i34, iArr, i30, i, i6, iModp_ninv31);
        for (int i36 = i29; i36 < i3; i36++) {
            int iModp_montymul3 = modp_montymul(iArr[i34 + i36], iModp_R2, i6, iModp_ninv31);
            iArr[i31 + i36] = modp_montymul(iModp_montymul3, iArr[i36], i6, iModp_ninv31);
            iArr[i32 + i36] = modp_montymul(iModp_montymul3, iArr[i33 + i36], i6, iModp_ninv31);
        }
        int iModp_set2 = modp_set(bArr2[i29], i6);
        iArr[i34] = iModp_set2;
        iArr[i33] = iModp_set2;
        for (int i37 = i28; i37 < i3; i37++) {
            iArr[i33 + i37] = modp_set(bArr2[i37], i6);
            iArr[(i34 + i3) - i37] = modp_set(-bArr2[i37], i6);
        }
        modp_NTT2(iArr, i33, iArr, i30, i, i6, iModp_ninv31);
        modp_NTT2(iArr, i34, iArr, i30, i, i6, iModp_ninv31);
        for (int i38 = i29; i38 < i3; i38++) {
            int iModp_montymul4 = modp_montymul(iArr[i34 + i38], iModp_R2, i6, iModp_ninv31);
            int i39 = i31 + i38;
            iArr[i39] = modp_add(iArr[i39], modp_montymul(iModp_montymul4, iArr[i3 + i38], i6, iModp_ninv31), i6);
            int i40 = i32 + i38;
            iArr[i40] = modp_add(iArr[i40], modp_montymul(iModp_montymul4, iArr[i33 + i38], i6, iModp_ninv31), i6);
        }
        modp_mkgm2(iArr, i30, iArr, i33, i, FalconSmallPrimeList.PRIMES[i29].g, i6, iModp_ninv31);
        modp_iNTT2(iArr, i31, iArr, i33, i, i6, iModp_ninv31);
        modp_iNTT2(iArr, i32, iArr, i33, i, i6, iModp_ninv31);
        int i41 = i32;
        for (int i42 = i29; i42 < i3; i42++) {
            int i43 = i31 + i42;
            iArr[i30 + i42] = modp_norm(iArr[i43], i6);
            iArr[i43] = modp_norm(iArr[i41 + i42], i6);
        }
        double[] dArr = new double[i3 * 3];
        for (int i44 = i29; i44 < i3; i44++) {
            dArr[i30 + i44] = iArr[i31 + i44];
        }
        FalconFFT.FFT(dArr, i30, i);
        System.arraycopy(dArr, i30, dArr, i3, i4);
        int i45 = i3 + i4;
        int i46 = i29;
        while (i46 < i3) {
            dArr[i45 + i46] = iArr[i30 + i46];
            i46++;
            i41 = i41;
        }
        int i47 = i41;
        FalconFFT.FFT(dArr, i45, i);
        FalconFFT.poly_div_autoadj_fft(dArr, i45, dArr, i3, i);
        FalconFFT.iFFT(dArr, i45, i);
        int i48 = i29;
        while (i48 < i3) {
            iArr[i30 + i48] = modp_set((int) FPREngine.fpr_rint(dArr[i45 + i48]), i6);
            i48++;
            dArr = dArr;
            i45 = i45;
        }
        modp_mkgm2(iArr, i31, iArr, i47, i, FalconSmallPrimeList.PRIMES[i29].g, i6, iModp_ninv31);
        for (int i49 = i29; i49 < i3; i49++) {
            iArr[i33 + i49] = modp_set(bArr[i49], i6);
            iArr[i34 + i49] = modp_set(bArr2[i49], i6);
        }
        modp_NTT2(iArr, i30, iArr, i31, i, i6, iModp_ninv31);
        modp_NTT2(iArr, i33, iArr, i31, i, i6, iModp_ninv31);
        modp_NTT2(iArr, i34, iArr, i31, i, i6, iModp_ninv31);
        for (int i50 = i29; i50 < i3; i50++) {
            int iModp_montymul5 = modp_montymul(iArr[i30 + i50], iModp_R2, i6, iModp_ninv31);
            iArr[i50] = modp_sub(iArr[i50], modp_montymul(iModp_montymul5, iArr[i33 + i50], i6, iModp_ninv31), i6);
            int i51 = i3 + i50;
            iArr[i51] = modp_sub(iArr[i51], modp_montymul(iModp_montymul5, iArr[i34 + i50], i6, iModp_ninv31), i6);
        }
        modp_iNTT2(iArr, 0, iArr, i47, i, i6, iModp_ninv31);
        modp_iNTT2(iArr, i3, iArr, i47, i, i6, iModp_ninv31);
        for (int i52 = i29; i52 < i3; i52++) {
            iArr[i52] = modp_norm(iArr[i52], i6);
            int i53 = i3 + i52;
            iArr[i53] = modp_norm(iArr[i53], i6);
        }
        return i28;
    }

    private static int solve_NTRU_binary_depth1(int i, byte[] bArr, byte[] bArr2, int[] iArr) {
        int i2;
        int i3;
        int i4 = 1;
        int i5 = 1 << i;
        int i6 = i - 1;
        int i7 = 1 << i6;
        int i8 = i7 >> 1;
        int[] iArr2 = MAX_BL_SMALL;
        int i9 = iArr2[1];
        int i10 = iArr2[2];
        int i11 = MAX_BL_LARGE[1];
        int i12 = i10 * i8;
        int i13 = i12 + i12;
        int i14 = i11 * i7;
        int i15 = i13 + i14;
        int i16 = 0;
        while (i16 < i11) {
            int i17 = FalconSmallPrimeList.PRIMES[i16].p;
            int i18 = i16;
            int iModp_ninv31 = modp_ninv31(i17);
            int iModp_R2 = modp_R2(i17, iModp_ninv31);
            int iModp_Rx = modp_Rx(i10, i17, iModp_ninv31, iModp_R2);
            int i19 = i13 + i18;
            int i20 = i15 + i18;
            int i21 = i15;
            int i22 = i12;
            int i23 = i4;
            int i24 = 0;
            int i25 = 0;
            while (i25 < i8) {
                int i26 = i17;
                int i27 = iModp_R2;
                int i28 = i24;
                iArr[i19] = zint_mod_small_signed(iArr, i24, i10, i26, iModp_ninv31, i27, iModp_Rx);
                int i29 = i22;
                iArr[i20] = zint_mod_small_signed(iArr, i29, i10, i26, iModp_ninv31, i27, iModp_Rx);
                i19 += i11;
                i20 += i11;
                i22 = i29 + i10;
                i24 = i28 + i10;
                i17 = i26;
                iModp_R2 = i27;
                i14 = i14;
                i9 = i9;
                i25++;
                i21 = i21;
            }
            i16 = i18 + 1;
            i14 = i14;
            i9 = i9;
            i4 = i23;
            i15 = i21;
        }
        int i30 = i4;
        int i31 = i9;
        int i32 = 0;
        int i33 = i14;
        int[] iArr3 = iArr;
        System.arraycopy(iArr3, i13, iArr3, 0, i33);
        System.arraycopy(iArr3, i15, iArr3, i33, i33);
        int i34 = i33 + i33;
        int i35 = i31 * i7;
        int i36 = i34 + i35;
        int i37 = i36 + i35;
        int i38 = 0;
        while (i38 < i11) {
            int i39 = FalconSmallPrimeList.PRIMES[i38].p;
            int iModp_ninv32 = modp_ninv31(i39);
            int iModp_R3 = modp_R2(i39, iModp_ninv32);
            int i40 = i37;
            int i41 = i40 + i5;
            int i42 = i41 + i7;
            int i43 = i42 + i5;
            int i44 = i38;
            modp_mkgm2(iArr3, i40, iArr, i41, i, FalconSmallPrimeList.PRIMES[i38].g, i39, iModp_ninv32);
            for (int i45 = i32; i45 < i5; i45++) {
                i2 = i39;
                iArr[i42 + i45] = modp_set(bArr[i45], i2);
                iArr[i43 + i45] = modp_set(bArr2[i45], i2);
            }
            i2 = i39;
            modp_NTT2(iArr, i42, iArr, i40, i, i2, iModp_ninv32);
            modp_NTT2(iArr, i43, iArr, i40, i, i2, iModp_ninv32);
            int i46 = i;
            while (i46 > i6) {
                int i47 = i2;
                int i48 = iModp_R3;
                int i49 = i42;
                modp_poly_rec_res(iArr, i49, i46, i47, iModp_ninv32, i48);
                int i50 = i43;
                modp_poly_rec_res(iArr, i50, i46, i47, iModp_ninv32, i48);
                i2 = i47;
                iModp_R3 = i48;
                i43 = i50;
                i46--;
                i42 = i49;
            }
            int i51 = iModp_R3;
            int i52 = i40 + i7;
            System.arraycopy(iArr, i41, iArr, i52, i7);
            int i53 = i52 + i7;
            System.arraycopy(iArr, i42, iArr, i53, i7);
            int i54 = i53 + i7;
            System.arraycopy(iArr, i43, iArr, i54, i7);
            int i55 = i54 + i7;
            int i56 = i55 + i8;
            int i57 = i33 + i44;
            int i58 = i57;
            int i59 = i44;
            int i60 = 0;
            while (i60 < i8) {
                iArr[i55 + i60] = iArr[i59];
                iArr[i56 + i60] = iArr[i58];
                i60++;
                i59 += i11;
                i58 += i11;
            }
            int i61 = i - 2;
            modp_NTT2(iArr, i55, iArr, i40, i61, i2, iModp_ninv32);
            int i62 = i56;
            modp_NTT2(iArr, i62, iArr, i40, i61, i2, iModp_ninv32);
            int i63 = i57;
            int i64 = i44;
            int i65 = 0;
            while (i65 < i8) {
                int i66 = i65 << 1;
                int i67 = i53 + i66;
                int i68 = i64;
                int i69 = iArr[i67];
                int i70 = i62;
                int i71 = iArr[i67 + 1];
                int i72 = i66 + i54;
                int i73 = i63;
                int i74 = iArr[i72];
                int i75 = iArr[i72 + 1];
                int i76 = i65;
                int iModp_montymul = modp_montymul(iArr[i55 + i65], i51, i2, iModp_ninv32);
                int i77 = i54;
                int iModp_montymul2 = modp_montymul(iArr[i70 + i76], i51, i2, iModp_ninv32);
                iArr[i68] = modp_montymul(i75, iModp_montymul, i2, iModp_ninv32);
                iArr[i68 + i11] = modp_montymul(i74, iModp_montymul, i2, iModp_ninv32);
                iArr[i73] = modp_montymul(i71, iModp_montymul2, i2, iModp_ninv32);
                iArr[i73 + i11] = modp_montymul(i69, iModp_montymul2, i2, iModp_ninv32);
                i65 = i76 + 1;
                int i78 = i11 << 1;
                i63 = i73 + i78;
                i64 = i68 + i78;
                i62 = i70;
                i54 = i77;
            }
            int i79 = i54;
            int i80 = i11;
            int i81 = i2;
            int i82 = i6;
            modp_iNTT2_ext(iArr, i44, i80, iArr, i52, i82, i81, iModp_ninv32);
            modp_iNTT2_ext(iArr, i57, i80, iArr, i52, i82, i81, iModp_ninv32);
            int i83 = i31;
            if (i44 < i83) {
                modp_iNTT2(iArr, i53, iArr, i52, i82, i81, iModp_ninv32);
                modp_iNTT2(iArr, i79, iArr, i52, i82, i81, iModp_ninv32);
                i3 = i82;
                int i84 = i34 + i44;
                int i85 = i36 + i44;
                int i86 = 0;
                while (i86 < i7) {
                    iArr[i84] = iArr[i53 + i86];
                    iArr[i85] = iArr[i79 + i86];
                    i86++;
                    i84 += i83;
                    i85 += i83;
                }
            } else {
                i3 = i82;
            }
            i38 = i44 + 1;
            iArr3 = iArr;
            i31 = i83;
            i6 = i3;
            i37 = i40;
            i32 = 0;
            i11 = i80;
        }
        int i87 = i37;
        int i88 = i11;
        int i89 = i6;
        int i90 = i31;
        int i91 = i7 << 1;
        zint_rebuild_CRT(iArr, 0, i88, i88, i91, 1, iArr, i87);
        zint_rebuild_CRT(iArr, i34, i90, i90, i91, 1, iArr, i87);
        double[] dArr = new double[i7];
        double[] dArr2 = new double[i7];
        poly_big_to_fp(dArr, iArr, 0, i88, i88, i89);
        poly_big_to_fp(dArr2, iArr, i33, i88, i88, i89);
        System.arraycopy(iArr, i34, iArr, 0, i90 * 2 * i7);
        double[] dArr3 = new double[i7];
        double[] dArr4 = new double[i7];
        poly_big_to_fp(dArr3, iArr, 0, i90, i90, i89);
        poly_big_to_fp(dArr4, iArr, i35, i90, i90, i89);
        FalconFFT.FFT(dArr, 0, i89);
        FalconFFT.FFT(dArr2, 0, i89);
        FalconFFT.FFT(dArr3, 0, i89);
        FalconFFT.FFT(dArr4, 0, i89);
        double[] dArr5 = new double[i7];
        double[] dArr6 = new double[i8];
        FalconFFT.poly_add_muladj_fft(dArr5, dArr, dArr2, dArr3, dArr4, i89);
        FalconFFT.poly_invnorm2_fft(dArr6, 0, dArr3, 0, dArr4, 0, i89);
        FalconFFT.poly_mul_autoadj_fft(dArr5, 0, dArr6, 0, i89);
        FalconFFT.iFFT(dArr5, 0, i89);
        for (int i92 = 0; i92 < i7; i92++) {
            double d = dArr5[i92];
            if (d >= 9.223372036854776E18d || -9.223372036854776E18d >= d) {
                return 0;
            }
            dArr5[i92] = FPREngine.fpr_rint(d);
        }
        FalconFFT.FFT(dArr5, 0, i89);
        FalconFFT.poly_mul_fft(dArr3, 0, dArr5, 0, i89);
        FalconFFT.poly_mul_fft(dArr4, 0, dArr5, 0, i89);
        FalconFFT.poly_sub(dArr, 0, dArr3, 0, i89);
        FalconFFT.poly_sub(dArr2, 0, dArr4, 0, i89);
        FalconFFT.iFFT(dArr, 0, i89);
        FalconFFT.iFFT(dArr2, 0, i89);
        for (int i93 = 0; i93 < i7; i93++) {
            iArr[i93] = (int) FPREngine.fpr_rint(dArr[i93]);
            iArr[i7 + i93] = (int) FPREngine.fpr_rint(dArr2[i93]);
        }
        return i30;
    }

    private static int solve_NTRU_deepest(int i, byte[] bArr, byte[] bArr2, int[] iArr) {
        int i2 = MAX_BL_SMALL[i];
        int i3 = i2 + i2;
        int i4 = i3 + i2;
        int i5 = i4 + i2;
        make_fg(iArr, i3, bArr, bArr2, i, i, 0);
        zint_rebuild_CRT(iArr, i3, i2, i2, 2, 0, iArr, i5);
        return (zint_bezout(iArr, i2, iArr, 0, iArr, i3, iArr, i4, i2, iArr, i5) != 0 && zint_mul_small(iArr, 0, i2, 12289) == 0 && zint_mul_small(iArr, i2, i2, 12289) == 0) ? 1 : 0;
    }

    private static int solve_NTRU_intermediate(int i, byte[] bArr, byte[] bArr2, int i2, int[] iArr) {
        double d;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int[] iArr2;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22 = i - i2;
        int i23 = 1;
        int i24 = 1 << i22;
        int i25 = i24 >> 1;
        int[] iArr3 = MAX_BL_SMALL;
        int i26 = iArr3[i2];
        int i27 = iArr3[i2 + 1];
        int i28 = MAX_BL_LARGE[i2];
        int i29 = i27 * i25;
        int i30 = i29 + i29;
        int[] iArr4 = iArr;
        make_fg(iArr4, i30, bArr, bArr2, i, i2, 1);
        int i31 = i2;
        int i32 = i24 * i28;
        int i33 = i32 + i32;
        int i34 = i24 * i26;
        System.arraycopy(iArr4, i30, iArr4, i33, i34 + i34);
        int i35 = i33 + i34;
        int i36 = i35 + i34;
        int i37 = 0;
        System.arraycopy(iArr4, 0, iArr4, i36, i29 + i29);
        int i38 = i29 + i36;
        int i39 = 0;
        while (i39 < i28) {
            int i40 = FalconSmallPrimeList.PRIMES[i39].p;
            int iModp_ninv31 = modp_ninv31(i40);
            int i41 = i23;
            int iModp_R2 = modp_R2(i40, iModp_ninv31);
            int iModp_Rx = modp_Rx(i27, i40, iModp_ninv31, iModp_R2);
            int i42 = i32 + i39;
            int i43 = i36;
            int i44 = i39;
            int i45 = i24;
            int i46 = i38;
            int i47 = 0;
            while (i47 < i25) {
                int i48 = i27;
                int i49 = i39;
                int i50 = i40;
                int i51 = iModp_R2;
                int i52 = i36;
                iArr[i44] = zint_mod_small_signed(iArr4, i36, i48, i50, iModp_ninv31, i51, iModp_Rx);
                int i53 = i46;
                iArr[i42] = zint_mod_small_signed(iArr, i53, i48, i50, iModp_ninv31, i51, iModp_Rx);
                i47++;
                i46 = i53 + i48;
                i44 += i28;
                i42 += i28;
                i27 = i48;
                i33 = i33;
                i36 = i52 + i48;
                iModp_R2 = i51;
                iArr4 = iArr;
                i40 = i50;
                i39 = i49;
            }
            i39++;
            i27 = i27;
            i33 = i33;
            iArr4 = iArr;
            i37 = 0;
            i23 = i41;
            i24 = i45;
            i36 = i43;
        }
        int i54 = i36;
        int i55 = i33;
        int i56 = i24;
        int i57 = i23;
        int i58 = i37;
        while (i58 < i28) {
            int i59 = FalconSmallPrimeList.PRIMES[i58].p;
            int iModp_ninv32 = modp_ninv31(i59);
            int iModp_R3 = modp_R2(i59, iModp_ninv32);
            if (i58 == i26) {
                int i60 = i55;
                i13 = iModp_R3;
                i14 = i26;
                i16 = i56;
                int i61 = i54;
                zint_rebuild_CRT(iArr, i60, i14, i26, i16, 1, iArr, i61);
                i15 = i60;
                zint_rebuild_CRT(iArr, i35, i14, i14, i16, 1, iArr, i61);
                i17 = i61;
            } else {
                i13 = iModp_R3;
                i14 = i26;
                i15 = i55;
                i16 = i56;
                i17 = i54;
            }
            int i62 = i17 + i16;
            int i63 = i62 + i16;
            int i64 = i63 + i16;
            int i65 = i14;
            int i66 = i17;
            int i67 = iModp_ninv32;
            int i68 = i59;
            int i69 = i16;
            int i70 = i22;
            modp_mkgm2(iArr, i66, iArr, i62, i70, FalconSmallPrimeList.PRIMES[i58].g, i68, i67);
            if (i58 < i65) {
                int i71 = i15 + i58;
                int i72 = i35 + i58;
                int i73 = i71;
                int i74 = i72;
                int i75 = 0;
                while (i75 < i69) {
                    iArr[i63 + i75] = iArr[i73];
                    iArr[i64 + i75] = iArr[i74];
                    i75++;
                    i73 += i65;
                    i74 += i65;
                }
                modp_iNTT2_ext(iArr, i71, i65, iArr, i62, i70, i68, i67);
                modp_iNTT2_ext(iArr, i72, i65, iArr, i62, i70, i68, i67);
                i19 = i65;
                i21 = i67;
                i18 = i66;
                i20 = i70;
            } else {
                int i76 = i68;
                int iModp_Rx2 = modp_Rx(i65, i76, i67, i13);
                int i77 = i35;
                int i78 = i15;
                int i79 = 0;
                while (i79 < i69) {
                    int i80 = i76;
                    int i81 = i67;
                    int i82 = i13;
                    int i83 = i79;
                    int i84 = i78;
                    int i85 = iModp_Rx2;
                    iArr[i63 + i79] = zint_mod_small_signed(iArr, i78, i65, i80, i81, i82, iModp_Rx2);
                    int i86 = i77;
                    iArr[i64 + i83] = zint_mod_small_signed(iArr, i86, i65, i80, i81, i82, i85);
                    i77 = i86 + i65;
                    i13 = i82;
                    i76 = i80;
                    i78 = i84 + i65;
                    iModp_Rx2 = i85;
                    i79 = i83 + 1;
                    i67 = i81;
                }
                int i87 = i76;
                int i88 = i67;
                i18 = i66;
                i19 = i65;
                modp_NTT2(iArr, i63, iArr, i18, i70, i87, i88);
                modp_NTT2(iArr, i64, iArr, i18, i70, i87, i88);
                i20 = i70;
                i21 = i88;
                i68 = i87;
            }
            int i89 = i64 + i69;
            int i90 = i89 + i25;
            int i91 = i32 + i58;
            int i92 = i58;
            int i93 = i91;
            int i94 = 0;
            while (i94 < i25) {
                iArr[i89 + i94] = iArr[i92];
                iArr[i90 + i94] = iArr[i93];
                i94++;
                i92 += i28;
                i93 += i28;
            }
            int i95 = i68;
            int i96 = i21;
            int i97 = i20 - 1;
            modp_NTT2(iArr, i89, iArr, i18, i97, i95, i96);
            int i98 = i90;
            modp_NTT2(iArr, i98, iArr, i18, i97, i95, i96);
            i54 = i18;
            int i99 = i58;
            int i100 = i91;
            int i101 = 0;
            while (i101 < i25) {
                int i102 = i101 << 1;
                int i103 = i63 + i102;
                int i104 = i101;
                int i105 = iArr[i103];
                int i106 = i98;
                int i107 = iArr[i103 + 1];
                int i108 = i64 + i102;
                int i109 = i99;
                int i110 = iArr[i108];
                int i111 = iArr[i108 + 1];
                int i112 = i100;
                int iModp_montymul = modp_montymul(iArr[i89 + i104], i13, i95, i96);
                int i113 = i20;
                int iModp_montymul2 = modp_montymul(iArr[i106 + i104], i13, i95, i96);
                iArr[i109] = modp_montymul(i111, iModp_montymul, i95, i96);
                iArr[i109 + i28] = modp_montymul(i110, iModp_montymul, i95, i96);
                iArr[i112] = modp_montymul(i107, iModp_montymul2, i95, i96);
                iArr[i112 + i28] = modp_montymul(i105, iModp_montymul2, i95, i96);
                i101 = i104 + 1;
                int i114 = i28 << 1;
                i99 = i109 + i114;
                i100 = i112 + i114;
                i98 = i106;
                i20 = i113;
            }
            int i115 = i20;
            int i116 = i58;
            modp_iNTT2_ext(iArr, i116, i28, iArr, i62, i115, i95, i96);
            modp_iNTT2_ext(iArr, i91, i28, iArr, i62, i115, i95, i96);
            i58 = i116 + 1;
            i56 = i69;
            i26 = i19;
            i55 = i15;
            i22 = i115;
        }
        int i117 = i55;
        int i118 = i22;
        int i119 = i26;
        int i120 = i56;
        int i121 = i54;
        zint_rebuild_CRT(iArr, 0, i28, i28, i120, 1, iArr, i121);
        zint_rebuild_CRT(iArr, i32, i28, i28, i120, 1, iArr, i121);
        double[] dArr = new double[i120];
        double[] dArr2 = new double[i120];
        double[] dArr3 = new double[i120];
        double[] dArr4 = new double[i120];
        double[] dArr5 = new double[i25];
        int[] iArr5 = new int[i120];
        int iMin = Math.min(i119, 10);
        int i122 = (i117 + i119) - iMin;
        int i123 = 10;
        poly_big_to_fp(dArr3, iArr, i122, iMin, i119, i118);
        poly_big_to_fp(dArr4, iArr, (i35 + i119) - iMin, iMin, i119, i118);
        int i124 = i119;
        int i125 = (i124 - iMin) * 31;
        int i126 = bitlength_avg[i31];
        int i127 = bitlength_std[i31];
        int i128 = i126 - (i127 * 6);
        int i129 = i126 + (i127 * 6);
        FalconFFT.FFT(dArr3, 0, i118);
        FalconFFT.FFT(dArr4, 0, i118);
        FalconFFT.poly_invnorm2_fft(dArr5, 0, dArr3, 0, dArr4, 0, i118);
        double[] dArr6 = dArr4;
        int i130 = i118;
        double[] dArr7 = dArr3;
        FalconFFT.poly_adj_fft(dArr7, 0, i130);
        FalconFFT.poly_adj_fft(dArr6, 0, i130);
        int i131 = i28 * 31;
        int i132 = i131;
        int i133 = i131 - i128;
        int i134 = i28;
        while (true) {
            int iMin2 = Math.min(i134, i123);
            double[] dArr8 = dArr;
            double[] dArr9 = dArr6;
            int i135 = i28;
            double[] dArr10 = dArr5;
            int i136 = i134;
            poly_big_to_fp(dArr8, iArr, i134 - iMin2, iMin2, i135, i130);
            double[] dArr11 = dArr2;
            poly_big_to_fp(dArr11, iArr, (i32 + i136) - iMin2, iMin2, i135, i130);
            FalconFFT.FFT(dArr8, 0, i130);
            FalconFFT.FFT(dArr11, 0, i130);
            FalconFFT.poly_mul_fft(dArr8, 0, dArr7, 0, i130);
            FalconFFT.poly_mul_fft(dArr11, 0, dArr9, 0, i130);
            FalconFFT.poly_add(dArr11, 0, dArr8, 0, i130);
            FalconFFT.poly_mul_autoadj_fft(dArr11, 0, dArr10, 0, i130);
            FalconFFT.iFFT(dArr11, 0, i130);
            int i137 = (i133 - ((i134 - iMin2) * 31)) + i125;
            if (i137 < 0) {
                i137 = -i137;
                d = 2.0d;
            } else {
                d = 0.5d;
            }
            double d2 = 1.0d;
            while (i137 != 0) {
                if ((i137 & 1) != 0) {
                    d2 *= d;
                }
                i137 >>= 1;
                d *= d;
            }
            int i138 = 0;
            while (i138 < i120) {
                double d3 = dArr11[i138] * d2;
                if (-2.147483647E9d >= d3 || d3 >= 2.147483647E9d) {
                    return 0;
                }
                iArr5[i138] = (int) FPREngine.fpr_rint(d3);
                i138++;
                dArr10 = dArr10;
            }
            double[] dArr12 = dArr10;
            int i139 = i132;
            int i140 = i133 / 31;
            int i141 = i133 % 31;
            if (i31 <= 4) {
                i9 = i121;
                i3 = i139;
                i6 = 10;
                i8 = i135;
                i10 = i124;
                i11 = i130;
                int i142 = i117;
                iArr2 = iArr;
                poly_sub_scaled_ntt(iArr2, 0, i136, i8, iArr, i142, i10, i124, iArr5, i140, i141, i11, iArr, i9);
                i7 = 0;
                i4 = i142;
                i12 = i32;
                poly_sub_scaled_ntt(iArr2, i12, i136, i8, iArr, i35, i10, i10, iArr5, i140, i141, i11, iArr, i9);
                i5 = i136;
            } else {
                i3 = i139;
                i4 = i117;
                i5 = i136;
                i6 = 10;
                i7 = 0;
                i8 = i135;
                i9 = i121;
                int i143 = i124;
                iArr2 = iArr;
                i10 = i143;
                i11 = i130;
                poly_sub_scaled(iArr2, 0, i5, i8, iArr, i4, i10, i143, iArr5, i140, i141, i11);
                i12 = i32;
                poly_sub_scaled(iArr2, i12, i5, i8, iArr, i35, i10, i10, iArr5, i140, i141, i11);
            }
            int i144 = i10;
            i130 = i11;
            int i145 = i133 + i129;
            int i146 = i145 + 10;
            if (i146 < i3) {
                if (i5 * 31 >= i145 + 41) {
                    i5--;
                }
                i132 = i146;
            } else {
                i132 = i3;
            }
            if (i133 <= 0) {
                if (i5 < i144) {
                    int i147 = i12;
                    int i148 = 0;
                    int i149 = i7;
                    while (i148 < i120) {
                        int i150 = (-(iArr2[(i149 + i5) - 1] >>> 30)) >>> 1;
                        for (int i151 = i5; i151 < i144; i151++) {
                            iArr2[i149 + i151] = i150;
                        }
                        int i152 = (-(iArr2[(i147 + i5) - 1] >>> 30)) >>> 1;
                        for (int i153 = i5; i153 < i144; i153++) {
                            iArr2[i147 + i153] = i152;
                        }
                        i148++;
                        i149 += i8;
                        i147 += i8;
                    }
                }
                int i154 = 0;
                int i155 = 0;
                int i156 = 0;
                while (i155 < (i120 << 1)) {
                    System.arraycopy(iArr2, i154, iArr2, i156, i144);
                    i155++;
                    i156 += i144;
                    i154 += i8;
                }
                return i57;
            }
            int i157 = i133 - 25;
            i133 = i157 < 0 ? 0 : i157;
            i31 = i2;
            i32 = i12;
            i134 = i5;
            i121 = i9;
            dArr2 = dArr11;
            dArr7 = dArr7;
            dArr6 = dArr9;
            dArr = dArr8;
            dArr5 = dArr12;
            i123 = i6;
            i117 = i4;
            i124 = i144;
            i28 = i8;
        }
    }

    private static long toUnsignedLong(int i) {
        return ((long) i) & 4294967295L;
    }

    private static void zint_add_mul_small(int[] iArr, int i, int[] iArr2, int i2, int i3, int i4) {
        int i5 = 0;
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = i + i6;
            long unsignedLong = (toUnsignedLong(iArr2[i2 + i6]) * toUnsignedLong(i4)) + toUnsignedLong(iArr[i7]) + toUnsignedLong(i5);
            iArr[i7] = ((int) unsignedLong) & Integer.MAX_VALUE;
            i5 = (int) (unsignedLong >>> 31);
        }
        iArr[i + i3] = i5;
    }

    private static void zint_add_scaled_mul_small(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7) {
        if (i4 == 0) {
            return;
        }
        int i8 = (-(iArr2[(i3 + i4) - 1] >>> 30)) >>> 1;
        int i9 = 0;
        int i10 = i6;
        int i11 = 0;
        while (i10 < i2) {
            int i12 = i10 - i6;
            int i13 = i12 < i4 ? iArr2[i3 + i12] : i8;
            int i14 = i + i10;
            long unsignedLong = (toUnsignedLong(i9 | ((i13 << i7) & Integer.MAX_VALUE)) * ((long) i5)) + toUnsignedLong(iArr[i14]) + ((long) i11);
            iArr[i14] = ((int) unsignedLong) & Integer.MAX_VALUE;
            i11 = (int) (unsignedLong >>> 31);
            i10++;
            i9 = i13 >>> (31 - i7);
        }
    }

    private static int zint_bezout(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3, int[] iArr4, int i4, int i5, int[] iArr5, int i6) {
        int[] iArr6 = iArr3;
        int i7 = i3;
        int[] iArr7 = iArr4;
        int i8 = i4;
        int i9 = i5;
        int[] iArr8 = iArr5;
        int i10 = i6;
        if (i9 == 0) {
            return 0;
        }
        int i11 = i10 + i9;
        int i12 = i11 + i9;
        int i13 = i12 + i9;
        int iModp_ninv31 = modp_ninv31(iArr6[i7]);
        int iModp_ninv32 = modp_ninv31(iArr7[i8]);
        System.arraycopy(iArr6, i7, iArr8, i12, i9);
        System.arraycopy(iArr7, i8, iArr8, i13, i9);
        iArr[i] = 1;
        iArr2[i2] = 0;
        for (int i14 = 1; i14 < i9; i14++) {
            iArr[i + i14] = 0;
            iArr2[i2 + i14] = 0;
        }
        System.arraycopy(iArr7, i8, iArr8, i10, i9);
        System.arraycopy(iArr6, i7, iArr8, i11, i9);
        iArr8[i11] = iArr8[i11] - 1;
        int i15 = 30;
        int i16 = (i9 * 62) + 30;
        while (true) {
            int i17 = 31;
            if (i16 < i15) {
                break;
            }
            int i18 = -1;
            int i19 = i9;
            int i20 = -1;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            while (true) {
                int i25 = i19 - 1;
                if (i19 <= 0) {
                    break;
                }
                int i26 = iArr8[i12 + i25];
                int i27 = iArr8[i13 + i25];
                i22 ^= (i22 ^ i26) & i20;
                i21 ^= (i21 ^ i26) & i18;
                i24 ^= (i24 ^ i27) & i20;
                i23 ^= (i23 ^ i27) & i18;
                int i28 = i20 & ((((i26 | i27) + Integer.MAX_VALUE) >>> 31) - 1);
                int i29 = i20;
                i20 = i28;
                i18 = i29;
                i19 = i25;
            }
            int i30 = ~i18;
            long unsignedLong = (toUnsignedLong(i22 & i30) << 31) + toUnsignedLong(i21 | (i22 & i18));
            long unsignedLong2 = (toUnsignedLong(i24 & i30) << 31) + toUnsignedLong(i23 | (i24 & i18));
            int i31 = iArr8[i12];
            int i32 = iArr8[i13];
            long j = 0;
            long j2 = 1;
            int i33 = iModp_ninv31;
            long j3 = 0;
            long j4 = 1;
            int i34 = 0;
            while (i34 < i17) {
                long j5 = unsignedLong2 - unsignedLong;
                int i35 = i17;
                int i36 = i12;
                int i37 = (int) ((j5 ^ ((unsignedLong ^ unsignedLong2) & (unsignedLong ^ j5))) >>> 63);
                int i38 = (i31 >> i34) & 1;
                int i39 = i38 & (i32 >> i34) & 1;
                int i40 = i34;
                int i41 = i39 & i37;
                int i42 = i39 & (~i37);
                int i43 = (i38 ^ 1) | i41;
                int i44 = i31 - ((-i41) & i32);
                long j6 = unsignedLong - (unsignedLong2 & (-toUnsignedLong(i41)));
                long j7 = -i41;
                long j8 = j4 - (j3 & j7);
                long j9 = j - (j2 & j7);
                int i45 = i32 - ((-i42) & i44);
                long j10 = unsignedLong2 - (j6 & (-toUnsignedLong(i42)));
                long j11 = -i42;
                long j12 = j3 - (j8 & j11);
                long j13 = j2 - (j9 & j11);
                i31 = i44 + ((i43 - 1) & i44);
                long j14 = i43;
                long j15 = j14 - 1;
                j4 = j8 + (j8 & j15);
                j = j9 + (j9 & j15);
                unsignedLong = j6 ^ ((j6 ^ (j6 >> 1)) & (-toUnsignedLong(i43)));
                i32 = i45 + ((-i43) & i45);
                long j16 = -j14;
                j3 = j12 + (j12 & j16);
                j2 = j13 + (j13 & j16);
                unsignedLong2 = j10 ^ ((j10 ^ (j10 >> 1)) & (toUnsignedLong(i43) - 1));
                i34 = i40 + 1;
                iModp_ninv32 = iModp_ninv32;
                i12 = i36;
                i17 = i35;
                i16 = i16;
                i11 = i11;
            }
            int i46 = iModp_ninv32;
            long j17 = j;
            long j18 = j4;
            int iZint_co_reduce = zint_co_reduce(iArr8, i12, iArr5, i13, i9, j18, j17, j3, j2);
            long j19 = -(iZint_co_reduce & 1);
            long j20 = j18 - ((j18 + j18) & j19);
            long j21 = j17 - (j19 & (j17 + j17));
            long j22 = -(iZint_co_reduce >>> 1);
            long j23 = j3 - ((j3 + j3) & j22);
            long j24 = j2 - ((j2 + j2) & j22);
            zint_co_reduce_mod(iArr, i, iArr5, i10, iArr7, i8, i5, i46, j20, j21, j23, j24);
            i9 = i5;
            zint_co_reduce_mod(iArr2, i2, iArr5, i11, iArr6, i7, i9, i33, j20, j21, j23, j24);
            i16 -= 30;
            iArr6 = iArr3;
            i7 = i3;
            iArr7 = iArr4;
            i8 = i4;
            iArr8 = iArr5;
            i10 = i6;
            iModp_ninv31 = i33;
            i13 = i13;
            i15 = 30;
            iModp_ninv32 = i46;
            i12 = i12;
        }
        int i47 = i12;
        int i48 = iArr5[i47] ^ 1;
        for (int i49 = 1; i49 < i9; i49++) {
            i48 |= iArr5[i47 + i49];
        }
        return (1 - ((i48 | (-i48)) >>> 31)) & iArr3[i3] & iArr4[i4];
    }

    private static int zint_co_reduce(int[] iArr, int i, int[] iArr2, int i2, int i3, long j, long j2, long j3, long j4) {
        long j5 = 0;
        int i4 = 0;
        long j6 = 0;
        while (i4 < i3) {
            int i5 = i + i4;
            int i6 = i2 + i4;
            long j7 = iArr[i5];
            int i7 = i4;
            long j8 = iArr2[i6];
            long j9 = (j7 * j) + (j8 * j2) + j5;
            long j10 = (j7 * j3) + (j8 * j4) + j6;
            if (i7 > 0) {
                iArr[i5 - 1] = ((int) j9) & Integer.MAX_VALUE;
                iArr2[i6 - 1] = ((int) j10) & Integer.MAX_VALUE;
            }
            j5 = j9 >> 31;
            j6 = j10 >> 31;
            i4 = i7 + 1;
        }
        iArr[(i + i3) - 1] = (int) j5;
        iArr2[(i2 + i3) - 1] = (int) j6;
        int i8 = (int) (j5 >>> 63);
        int i9 = (int) (j6 >>> 63);
        zint_negate(iArr, i, i3, i8);
        zint_negate(iArr2, i2, i3, i9);
        return (i9 << 1) | i8;
    }

    private static void zint_co_reduce_mod(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3, int i4, int i5, long j, long j2, long j3, long j4) {
        long j5 = j2;
        int i6 = iArr[i];
        int i7 = iArr2[i2];
        int i8 = (((((int) j) * i6) + (((int) j5) * i7)) * i5) & Integer.MAX_VALUE;
        int i9 = (((i6 * ((int) j3)) + (i7 * ((int) j4))) * i5) & Integer.MAX_VALUE;
        int i10 = 0;
        int i11 = Integer.MAX_VALUE;
        long j6 = 0;
        long j7 = 0;
        while (i10 < i4) {
            int i12 = i + i10;
            int i13 = i11;
            int i14 = i2 + i10;
            long j8 = iArr[i12];
            long j9 = iArr2[i14];
            int i15 = i3 + i10;
            long unsignedLong = (j8 * j) + (j9 * j5) + (((long) iArr3[i15]) * toUnsignedLong(i8)) + j6;
            long unsignedLong2 = (j8 * j3) + (j9 * j4) + (((long) iArr3[i15]) * toUnsignedLong(i9)) + j7;
            if (i10 > 0) {
                iArr[i12 - 1] = ((int) unsignedLong) & i13;
                iArr2[i14 - 1] = ((int) unsignedLong2) & i13;
            }
            j6 = unsignedLong >> 31;
            j7 = unsignedLong2 >> 31;
            i10++;
            i11 = i13;
            j5 = j2;
        }
        long j10 = j6;
        iArr[(i + i4) - 1] = (int) j10;
        iArr2[(i2 + i4) - 1] = (int) j7;
        zint_finish_mod(iArr, i, i4, iArr3, i3, (int) (j10 >>> 63));
        zint_finish_mod(iArr2, i2, i4, iArr3, i3, (int) (j7 >>> 63));
    }

    private static void zint_finish_mod(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4) {
        int i5 = 0;
        for (int i6 = 0; i6 < i2; i6++) {
            i5 = ((iArr[i + i6] - iArr2[i3 + i6]) - i5) >>> 31;
        }
        int i7 = (-i4) >>> 1;
        int i8 = -((1 - i5) | i4);
        for (int i9 = 0; i9 < i2; i9++) {
            int i10 = i + i9;
            int i11 = (iArr[i10] - ((iArr2[i3 + i9] ^ i7) & i8)) - i4;
            iArr[i10] = Integer.MAX_VALUE & i11;
            i4 = i11 >>> 31;
        }
    }

    private static int zint_mod_small_signed(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6) {
        if (i2 == 0) {
            return 0;
        }
        return modp_sub(zint_mod_small_unsigned(iArr, i, i2, i3, i4, i5), (-(iArr[(i + i2) - 1] >>> 30)) & i6, i3);
    }

    private static int zint_mod_small_unsigned(int[] iArr, int i, int i2, int i3, int i4, int i5) {
        int iModp_add = 0;
        while (true) {
            int i6 = i2 - 1;
            if (i2 <= 0) {
                return iModp_add;
            }
            int iModp_montymul = modp_montymul(iModp_add, i5, i3, i4);
            int i7 = iArr[i + i6] - i3;
            iModp_add = modp_add(iModp_montymul, i7 + ((-(i7 >>> 31)) & i3), i3);
            i2 = i6;
        }
    }

    private static int zint_mul_small(int[] iArr, int i, int i2, int i3) {
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = i + i5;
            long unsignedLong = (toUnsignedLong(iArr[i6]) * toUnsignedLong(i3)) + ((long) i4);
            iArr[i6] = ((int) unsignedLong) & Integer.MAX_VALUE;
            i4 = (int) (unsignedLong >> 31);
        }
        return i4;
    }

    private static void zint_negate(int[] iArr, int i, int i2, int i3) {
        int i4 = (-i3) >>> 1;
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = i + i5;
            int i7 = (iArr[i6] ^ i4) + i3;
            iArr[i6] = Integer.MAX_VALUE & i7;
            i3 = i7 >>> 31;
        }
    }

    private static void zint_norm_zero(int[] iArr, int i, int[] iArr2, int i2, int i3) {
        int i4 = 0;
        int i5 = i3;
        int i6 = 0;
        while (true) {
            int i7 = i5 - 1;
            if (i5 <= 0) {
                zint_sub(iArr, i, iArr2, i2, i3, i4 >>> 31);
                return;
            }
            int i8 = iArr[i + i7];
            int i9 = iArr2[i2 + i7];
            int i10 = ((i6 << 30) | (i9 >>> 1)) - i8;
            i4 |= ((-(i10 >>> 31)) | ((-i10) >>> 31)) & ((i4 & 1) - 1);
            i5 = i7;
            i6 = i9 & 1;
        }
    }

    private static int zint_one_to_plain(int[] iArr, int i) {
        int i2 = iArr[i];
        return i2 | ((1073741824 & i2) << 1);
    }

    private static void zint_rebuild_CRT(int[] iArr, int i, int i2, int i3, int i4, int i5, int[] iArr2, int i6) {
        int i7 = 0;
        iArr2[i6] = FalconSmallPrimeList.PRIMES[0].p;
        int i8 = 1;
        while (i8 < i2) {
            int i9 = FalconSmallPrimeList.PRIMES[i8].p;
            int i10 = FalconSmallPrimeList.PRIMES[i8].s;
            int iModp_ninv31 = modp_ninv31(i9);
            int iModp_R2 = modp_R2(i9, iModp_ninv31);
            int i11 = i;
            int i12 = 0;
            while (i12 < i4) {
                int i13 = i9;
                int i14 = iModp_ninv31;
                int i15 = iModp_R2;
                int iModp_montymul = modp_montymul(i10, modp_sub(iArr[i11 + i8], zint_mod_small_unsigned(iArr, i11, i8, i9, iModp_ninv31, iModp_R2), i13), i13, i14);
                int i16 = i8;
                zint_add_mul_small(iArr, i11, iArr2, i6, i16, iModp_montymul);
                i12++;
                i11 += i3;
                i8 = i16;
                i9 = i13;
                iModp_ninv31 = i14;
                iModp_R2 = i15;
            }
            int i17 = i8;
            iArr2[i6 + i17] = zint_mul_small(iArr2, i6, i17, i9);
            i8 = i17 + 1;
        }
        if (i5 != 0) {
            int i18 = i;
            while (i7 < i4) {
                zint_norm_zero(iArr, i18, iArr2, i6, i2);
                i7++;
                i18 += i3;
            }
        }
    }

    private static void zint_sub(int[] iArr, int i, int[] iArr2, int i2, int i3, int i4) {
        int i5 = -i4;
        int i6 = 0;
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = i + i7;
            int i9 = iArr[i8];
            int i10 = (i9 - iArr2[i2 + i7]) - i6;
            i6 = i10 >>> 31;
            iArr[i8] = i9 ^ (((i10 & Integer.MAX_VALUE) ^ i9) & i5);
        }
    }

    private static void zint_sub_scaled(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6) {
        if (i4 == 0) {
            return;
        }
        int i7 = (-(iArr2[(i3 + i4) - 1] >>> 30)) >>> 1;
        int i8 = 0;
        int i9 = i5;
        int i10 = 0;
        while (i9 < i2) {
            int i11 = i9 - i5;
            int i12 = i11 < i4 ? iArr2[i11 + i3] : i7;
            int i13 = i + i9;
            int i14 = (iArr[i13] - (i8 | ((i12 << i6) & Integer.MAX_VALUE))) - i10;
            iArr[i13] = i14 & Integer.MAX_VALUE;
            i10 = i14 >>> 31;
            i9++;
            i8 = i12 >>> (31 - i6);
        }
    }
}
