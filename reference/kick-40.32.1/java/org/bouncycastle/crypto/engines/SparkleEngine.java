package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.digests.SparkleDigest;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes10.dex */
public class SparkleEngine extends AEADBaseEngine {
    private static final int[] RCON = {-1209970334, -1083090816, 951376470, 844003128, -1156479509, 1333558103, -809524792, -1028445891};
    private final int CAP_MASK;
    private final int KEY_WORDS;
    private final int RATE_WORDS;
    private final int SPARKLE_STEPS_BIG;
    private final int SPARKLE_STEPS_SLIM;
    private final int STATE_WORDS;
    private final int TAG_WORDS;
    private final int _A0;
    private final int _A1;
    private final int _M2;
    private final int _M3;
    private boolean encrypted;
    private final int[] k;
    private final int[] npub;
    private final int[] state;

    /* JADX INFO: renamed from: org.bouncycastle.crypto.engines.SparkleEngine$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$bouncycastle$crypto$engines$SparkleEngine$SparkleParameters;

        static {
            int[] iArr = new int[SparkleParameters.values().length];
            $SwitchMap$org$bouncycastle$crypto$engines$SparkleEngine$SparkleParameters = iArr;
            try {
                iArr[SparkleParameters.SCHWAEMM128_128.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$bouncycastle$crypto$engines$SparkleEngine$SparkleParameters[SparkleParameters.SCHWAEMM256_128.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$bouncycastle$crypto$engines$SparkleEngine$SparkleParameters[SparkleParameters.SCHWAEMM192_192.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$bouncycastle$crypto$engines$SparkleEngine$SparkleParameters[SparkleParameters.SCHWAEMM256_256.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public enum SparkleParameters {
        SCHWAEMM128_128,
        SCHWAEMM256_128,
        SCHWAEMM192_192,
        SCHWAEMM256_256
    }

    /* JADX WARN: Code duplicated, block: B:19:0x007f  */
    /* JADX WARN: Code duplicated, block: B:20:0x0081  */
    public SparkleEngine(SparkleParameters sparkleParameters) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = AnonymousClass1.$SwitchMap$org$bouncycastle$crypto$engines$SparkleEngine$SparkleParameters[sparkleParameters.ordinal()];
        int i8 = 256;
        int i9 = 128;
        if (i7 != 1) {
            i = 384;
            if (i7 != 2) {
                if (i7 == 3) {
                    this.SPARKLE_STEPS_SLIM = 7;
                    this.SPARKLE_STEPS_BIG = 11;
                    this.algorithmName = "SCHWAEMM192-192";
                    i8 = 192;
                } else {
                    if (i7 != 4) {
                        throw new IllegalArgumentException("Invalid definition of SCHWAEMM instance");
                    }
                    this.SPARKLE_STEPS_SLIM = 8;
                    this.SPARKLE_STEPS_BIG = 12;
                    this.algorithmName = "SCHWAEMM256-256";
                    i = 512;
                }
                i2 = i8;
                i3 = i2;
                i9 = i3;
            } else {
                this.SPARKLE_STEPS_SLIM = 7;
                this.SPARKLE_STEPS_BIG = 11;
                this.algorithmName = "SCHWAEMM256-128";
                i2 = 256;
                i3 = 128;
            }
            int i10 = i8 >>> 5;
            this.KEY_WORDS = i10;
            this.KEY_SIZE = i8 >>> 3;
            this.TAG_WORDS = i9 >>> 5;
            this.MAC_SIZE = i9 >>> 3;
            int i11 = i >>> 5;
            this.STATE_WORDS = i11;
            i4 = i2 >>> 5;
            this.RATE_WORDS = i4;
            this.IV_SIZE = i2 >>> 3;
            int i12 = i3 >>> 6;
            i5 = i3 >>> 5;
            if (i4 > i5) {
                i6 = i5 - 1;
            } else {
                i6 = -1;
            }
            this.CAP_MASK = i6;
            int i13 = 1 << i12;
            this._A0 = i13 << 24;
            this._A1 = (i13 ^ 1) << 24;
            this._M2 = (i13 ^ 2) << 24;
            this._M3 = (i13 ^ 3) << 24;
            this.state = new int[i11];
            this.k = new int[i10];
            this.npub = new int[i4];
            int i14 = this.IV_SIZE;
            this.BlockSize = i14;
            this.AADBufferSize = i14;
            setInnerMembers(AEADBaseEngine.ProcessingBufferType.Buffered, AEADBaseEngine.AADOperatorType.Default, AEADBaseEngine.DataOperatorType.Default);
        }
        this.SPARKLE_STEPS_SLIM = 7;
        this.SPARKLE_STEPS_BIG = 10;
        this.algorithmName = "SCHWAEMM128-128";
        i = 256;
        i2 = 128;
        i3 = 128;
        i8 = i3;
        int i15 = i8 >>> 5;
        this.KEY_WORDS = i15;
        this.KEY_SIZE = i8 >>> 3;
        this.TAG_WORDS = i9 >>> 5;
        this.MAC_SIZE = i9 >>> 3;
        int i16 = i >>> 5;
        this.STATE_WORDS = i16;
        i4 = i2 >>> 5;
        this.RATE_WORDS = i4;
        this.IV_SIZE = i2 >>> 3;
        int i17 = i3 >>> 6;
        i5 = i3 >>> 5;
        if (i4 > i5) {
            i6 = i5 - 1;
        } else {
            i6 = -1;
        }
        this.CAP_MASK = i6;
        int i18 = 1 << i17;
        this._A0 = i18 << 24;
        this._A1 = (i18 ^ 1) << 24;
        this._M2 = (i18 ^ 2) << 24;
        this._M3 = (i18 ^ 3) << 24;
        this.state = new int[i16];
        this.k = new int[i15];
        this.npub = new int[i4];
        int i19 = this.IV_SIZE;
        this.BlockSize = i19;
        this.AADBufferSize = i19;
        setInnerMembers(AEADBaseEngine.ProcessingBufferType.Buffered, AEADBaseEngine.AADOperatorType.Default, AEADBaseEngine.DataOperatorType.Default);
    }

    private static int ELL(int i) {
        return (i & 65535) ^ Integers.rotateRight(i, 16);
    }

    private static void sparkle_opt(int[] iArr, int i) {
        int length = iArr.length;
        if (length == 8) {
            sparkle_opt8(iArr, i);
        } else if (length == 12) {
            sparkle_opt12(iArr, i);
        } else {
            if (length != 16) {
                throw new IllegalStateException();
            }
            sparkle_opt16(iArr, i);
        }
    }

    public static void sparkle_opt12(SparkleDigest.Friend friend, int[] iArr, int i) {
        if (friend == null) {
            throw new NullPointerException("This method is only for use by SparkleDigest");
        }
        sparkle_opt12(iArr, i);
    }

    static void sparkle_opt12(int[] iArr, int i) {
        int i2 = iArr[0];
        int i3 = iArr[1];
        int i4 = iArr[2];
        int i5 = iArr[3];
        char c = 4;
        int i6 = iArr[4];
        char c2 = 5;
        int i7 = iArr[5];
        char c3 = 6;
        int i8 = iArr[6];
        char c4 = 7;
        int i9 = iArr[7];
        int i10 = iArr[8];
        int i11 = iArr[9];
        int i12 = iArr[10];
        int i13 = iArr[11];
        int i14 = 0;
        int i15 = i11;
        while (i14 < i) {
            int[] iArr2 = RCON;
            int i16 = i3 ^ iArr2[i14 & 7];
            int i17 = i5 ^ i14;
            int i18 = iArr2[0];
            char c5 = c;
            int iRotateRight = i2 + Integers.rotateRight(i16, 31);
            char c6 = c2;
            int iRotateRight2 = i16 ^ Integers.rotateRight(iRotateRight, 24);
            char c7 = c3;
            int iRotateRight3 = (iRotateRight ^ i18) + Integers.rotateRight(iRotateRight2, 17);
            int iRotateRight4 = iRotateRight2 ^ Integers.rotateRight(iRotateRight3, 17);
            int i19 = (iRotateRight3 ^ i18) + iRotateRight4;
            int iRotateRight5 = iRotateRight4 ^ Integers.rotateRight(i19, 31);
            int iRotateRight6 = (i19 ^ i18) + Integers.rotateRight(iRotateRight5, 24);
            char c8 = c4;
            int iRotateRight7 = iRotateRight5 ^ Integers.rotateRight(iRotateRight6, 16);
            int i20 = iRotateRight6 ^ i18;
            int i21 = iArr2[1];
            int iRotateRight8 = i4 + Integers.rotateRight(i17, 31);
            int iRotateRight9 = i17 ^ Integers.rotateRight(iRotateRight8, 24);
            int iRotateRight10 = (iRotateRight8 ^ i21) + Integers.rotateRight(iRotateRight9, 17);
            int iRotateRight11 = iRotateRight9 ^ Integers.rotateRight(iRotateRight10, 17);
            int i22 = (iRotateRight10 ^ i21) + iRotateRight11;
            int iRotateRight12 = iRotateRight11 ^ Integers.rotateRight(i22, 31);
            int iRotateRight13 = (i22 ^ i21) + Integers.rotateRight(iRotateRight12, 24);
            int iRotateRight14 = iRotateRight12 ^ Integers.rotateRight(iRotateRight13, 16);
            int i23 = iRotateRight13 ^ i21;
            int i24 = iArr2[2];
            int iRotateRight15 = i6 + Integers.rotateRight(i7, 31);
            int iRotateRight16 = i7 ^ Integers.rotateRight(iRotateRight15, 24);
            int iRotateRight17 = (iRotateRight15 ^ i24) + Integers.rotateRight(iRotateRight16, 17);
            int iRotateRight18 = iRotateRight16 ^ Integers.rotateRight(iRotateRight17, 17);
            int i25 = (iRotateRight17 ^ i24) + iRotateRight18;
            int iRotateRight19 = iRotateRight18 ^ Integers.rotateRight(i25, 31);
            int iRotateRight20 = (i25 ^ i24) + Integers.rotateRight(iRotateRight19, 24);
            int iRotateRight21 = iRotateRight19 ^ Integers.rotateRight(iRotateRight20, 16);
            int i26 = iRotateRight20 ^ i24;
            int i27 = iArr2[3];
            int iRotateRight22 = i8 + Integers.rotateRight(i9, 31);
            int iRotateRight23 = i9 ^ Integers.rotateRight(iRotateRight22, 24);
            int iRotateRight24 = (iRotateRight22 ^ i27) + Integers.rotateRight(iRotateRight23, 17);
            int iRotateRight25 = iRotateRight23 ^ Integers.rotateRight(iRotateRight24, 17);
            int i28 = (iRotateRight24 ^ i27) + iRotateRight25;
            int iRotateRight26 = iRotateRight25 ^ Integers.rotateRight(i28, 31);
            int iRotateRight27 = (i28 ^ i27) + Integers.rotateRight(iRotateRight26, 24);
            int iRotateRight28 = iRotateRight26 ^ Integers.rotateRight(iRotateRight27, 16);
            int i29 = iRotateRight27 ^ i27;
            int i30 = iArr2[c5];
            int iRotateRight29 = i10 + Integers.rotateRight(i15, 31);
            int iRotateRight30 = i15 ^ Integers.rotateRight(iRotateRight29, 24);
            int iRotateRight31 = (iRotateRight29 ^ i30) + Integers.rotateRight(iRotateRight30, 17);
            int iRotateRight32 = iRotateRight30 ^ Integers.rotateRight(iRotateRight31, 17);
            int i31 = (iRotateRight31 ^ i30) + iRotateRight32;
            int iRotateRight33 = iRotateRight32 ^ Integers.rotateRight(i31, 31);
            int iRotateRight34 = (i31 ^ i30) + Integers.rotateRight(iRotateRight33, 24);
            int iRotateRight35 = iRotateRight33 ^ Integers.rotateRight(iRotateRight34, 16);
            int i32 = iRotateRight34 ^ i30;
            int i33 = iArr2[c6];
            int iRotateRight36 = i12 + Integers.rotateRight(i13, 31);
            int iRotateRight37 = i13 ^ Integers.rotateRight(iRotateRight36, 24);
            int iRotateRight38 = (iRotateRight36 ^ i33) + Integers.rotateRight(iRotateRight37, 17);
            int iRotateRight39 = iRotateRight37 ^ Integers.rotateRight(iRotateRight38, 17);
            int i34 = (iRotateRight38 ^ i33) + iRotateRight39;
            int iRotateRight40 = iRotateRight39 ^ Integers.rotateRight(i34, 31);
            int iRotateRight41 = (i34 ^ i33) + Integers.rotateRight(iRotateRight40, 24);
            int iRotateRight42 = iRotateRight40 ^ Integers.rotateRight(iRotateRight41, 16);
            int i35 = iRotateRight41 ^ i33;
            int iELL = ELL((i20 ^ i23) ^ i26);
            int iELL2 = ELL((iRotateRight7 ^ iRotateRight14) ^ iRotateRight21);
            int i36 = (i32 ^ i23) ^ iELL2;
            int i37 = (iRotateRight35 ^ iRotateRight14) ^ iELL;
            int i38 = (iRotateRight42 ^ iRotateRight21) ^ iELL;
            int i39 = iELL ^ (iRotateRight28 ^ iRotateRight7);
            i14++;
            i9 = iRotateRight7;
            i10 = i23;
            i4 = (i35 ^ i26) ^ iELL2;
            i12 = i26;
            i6 = (i29 ^ i20) ^ iELL2;
            c = c5;
            c4 = c8;
            i3 = i37;
            i8 = i20;
            i15 = iRotateRight14;
            i2 = i36;
            c3 = c7;
            i5 = i38;
            i13 = iRotateRight21;
            i7 = i39;
            c2 = c6;
        }
        iArr[0] = i2;
        iArr[1] = i3;
        iArr[2] = i4;
        iArr[3] = i5;
        iArr[c] = i6;
        iArr[c2] = i7;
        iArr[c3] = i8;
        iArr[c4] = i9;
        iArr[8] = i10;
        iArr[9] = i15;
        iArr[10] = i12;
        iArr[11] = i13;
    }

    public static void sparkle_opt16(SparkleDigest.Friend friend, int[] iArr, int i) {
        if (friend == null) {
            throw new NullPointerException("This method is only for use by SparkleDigest");
        }
        sparkle_opt16(iArr, i);
    }

    static void sparkle_opt16(int[] iArr, int i) {
        int i2 = iArr[0];
        int i3 = iArr[1];
        int i4 = iArr[2];
        int i5 = iArr[3];
        int i6 = iArr[4];
        int i7 = iArr[5];
        char c = 6;
        int i8 = iArr[6];
        char c2 = 7;
        int i9 = iArr[7];
        int i10 = iArr[8];
        int i11 = iArr[9];
        int i12 = iArr[10];
        int i13 = iArr[11];
        int i14 = iArr[12];
        int i15 = iArr[13];
        int i16 = iArr[14];
        int i17 = i13;
        int i18 = i15;
        int i19 = iArr[15];
        int i20 = 0;
        int i21 = i11;
        while (i20 < i) {
            int[] iArr2 = RCON;
            int i22 = i3 ^ iArr2[i20 & 7];
            int i23 = i5 ^ i20;
            int i24 = iArr2[0];
            char c3 = c;
            int iRotateRight = i2 + Integers.rotateRight(i22, 31);
            char c4 = c2;
            int iRotateRight2 = i22 ^ Integers.rotateRight(iRotateRight, 24);
            int iRotateRight3 = (iRotateRight ^ i24) + Integers.rotateRight(iRotateRight2, 17);
            int iRotateRight4 = iRotateRight2 ^ Integers.rotateRight(iRotateRight3, 17);
            int i25 = (iRotateRight3 ^ i24) + iRotateRight4;
            int iRotateRight5 = iRotateRight4 ^ Integers.rotateRight(i25, 31);
            int iRotateRight6 = (i25 ^ i24) + Integers.rotateRight(iRotateRight5, 24);
            int iRotateRight7 = iRotateRight5 ^ Integers.rotateRight(iRotateRight6, 16);
            int i26 = iRotateRight6 ^ i24;
            int i27 = iArr2[1];
            int iRotateRight8 = i4 + Integers.rotateRight(i23, 31);
            int iRotateRight9 = i23 ^ Integers.rotateRight(iRotateRight8, 24);
            int iRotateRight10 = (iRotateRight8 ^ i27) + Integers.rotateRight(iRotateRight9, 17);
            int iRotateRight11 = iRotateRight9 ^ Integers.rotateRight(iRotateRight10, 17);
            int i28 = (iRotateRight10 ^ i27) + iRotateRight11;
            int iRotateRight12 = iRotateRight11 ^ Integers.rotateRight(i28, 31);
            int iRotateRight13 = (i28 ^ i27) + Integers.rotateRight(iRotateRight12, 24);
            int iRotateRight14 = iRotateRight12 ^ Integers.rotateRight(iRotateRight13, 16);
            int i29 = iRotateRight13 ^ i27;
            int i30 = iArr2[2];
            int iRotateRight15 = i6 + Integers.rotateRight(i7, 31);
            int iRotateRight16 = i7 ^ Integers.rotateRight(iRotateRight15, 24);
            int iRotateRight17 = (iRotateRight15 ^ i30) + Integers.rotateRight(iRotateRight16, 17);
            int iRotateRight18 = iRotateRight16 ^ Integers.rotateRight(iRotateRight17, 17);
            int i31 = (iRotateRight17 ^ i30) + iRotateRight18;
            int iRotateRight19 = iRotateRight18 ^ Integers.rotateRight(i31, 31);
            int iRotateRight20 = (i31 ^ i30) + Integers.rotateRight(iRotateRight19, 24);
            int iRotateRight21 = iRotateRight19 ^ Integers.rotateRight(iRotateRight20, 16);
            int i32 = iRotateRight20 ^ i30;
            int i33 = iArr2[3];
            int iRotateRight22 = i8 + Integers.rotateRight(i9, 31);
            int iRotateRight23 = i9 ^ Integers.rotateRight(iRotateRight22, 24);
            int iRotateRight24 = (iRotateRight22 ^ i33) + Integers.rotateRight(iRotateRight23, 17);
            int iRotateRight25 = iRotateRight23 ^ Integers.rotateRight(iRotateRight24, 17);
            int i34 = (iRotateRight24 ^ i33) + iRotateRight25;
            int iRotateRight26 = iRotateRight25 ^ Integers.rotateRight(i34, 31);
            int iRotateRight27 = (i34 ^ i33) + Integers.rotateRight(iRotateRight26, 24);
            int iRotateRight28 = iRotateRight26 ^ Integers.rotateRight(iRotateRight27, 16);
            int i35 = i33 ^ iRotateRight27;
            int i36 = iArr2[4];
            int iRotateRight29 = i10 + Integers.rotateRight(i21, 31);
            int iRotateRight30 = i21 ^ Integers.rotateRight(iRotateRight29, 24);
            int iRotateRight31 = (iRotateRight29 ^ i36) + Integers.rotateRight(iRotateRight30, 17);
            int iRotateRight32 = iRotateRight30 ^ Integers.rotateRight(iRotateRight31, 17);
            int i37 = (iRotateRight31 ^ i36) + iRotateRight32;
            int iRotateRight33 = iRotateRight32 ^ Integers.rotateRight(i37, 31);
            int iRotateRight34 = (i37 ^ i36) + Integers.rotateRight(iRotateRight33, 24);
            int iRotateRight35 = iRotateRight33 ^ Integers.rotateRight(iRotateRight34, 16);
            int i38 = iRotateRight34 ^ i36;
            int i39 = iArr2[5];
            int iRotateRight36 = i12 + Integers.rotateRight(i17, 31);
            int iRotateRight37 = i17 ^ Integers.rotateRight(iRotateRight36, 24);
            int iRotateRight38 = (iRotateRight36 ^ i39) + Integers.rotateRight(iRotateRight37, 17);
            int iRotateRight39 = iRotateRight37 ^ Integers.rotateRight(iRotateRight38, 17);
            int i40 = (iRotateRight38 ^ i39) + iRotateRight39;
            int iRotateRight40 = iRotateRight39 ^ Integers.rotateRight(i40, 31);
            int iRotateRight41 = (i40 ^ i39) + Integers.rotateRight(iRotateRight40, 24);
            int iRotateRight42 = iRotateRight40 ^ Integers.rotateRight(iRotateRight41, 16);
            int i41 = iRotateRight41 ^ i39;
            int i42 = iArr2[c3];
            int iRotateRight43 = i14 + Integers.rotateRight(i18, 31);
            int iRotateRight44 = i18 ^ Integers.rotateRight(iRotateRight43, 24);
            int iRotateRight45 = (iRotateRight43 ^ i42) + Integers.rotateRight(iRotateRight44, 17);
            int iRotateRight46 = iRotateRight44 ^ Integers.rotateRight(iRotateRight45, 17);
            int i43 = (iRotateRight45 ^ i42) + iRotateRight46;
            int iRotateRight47 = iRotateRight46 ^ Integers.rotateRight(i43, 31);
            int iRotateRight48 = (i43 ^ i42) + Integers.rotateRight(iRotateRight47, 24);
            int iRotateRight49 = iRotateRight47 ^ Integers.rotateRight(iRotateRight48, 16);
            int i44 = iRotateRight48 ^ i42;
            int i45 = iArr2[c4];
            int iRotateRight50 = i16 + Integers.rotateRight(i19, 31);
            int iRotateRight51 = i19 ^ Integers.rotateRight(iRotateRight50, 24);
            int iRotateRight52 = (iRotateRight50 ^ i45) + Integers.rotateRight(iRotateRight51, 17);
            int iRotateRight53 = iRotateRight51 ^ Integers.rotateRight(iRotateRight52, 17);
            int i46 = (iRotateRight52 ^ i45) + iRotateRight53;
            int iRotateRight54 = iRotateRight53 ^ Integers.rotateRight(i46, 31);
            int iRotateRight55 = (i46 ^ i45) + Integers.rotateRight(iRotateRight54, 24);
            int iRotateRight56 = iRotateRight54 ^ Integers.rotateRight(iRotateRight55, 16);
            int i47 = iRotateRight55 ^ i45;
            int iELL = ELL(((i26 ^ i29) ^ i32) ^ i35);
            int iELL2 = ELL(((iRotateRight7 ^ iRotateRight14) ^ iRotateRight21) ^ iRotateRight28);
            int i48 = iRotateRight14 ^ iRotateRight42;
            int i49 = (i41 ^ i29) ^ iELL2;
            int i50 = (i44 ^ i32) ^ iELL2;
            int i51 = (iRotateRight21 ^ iRotateRight49) ^ iELL;
            int i52 = (i47 ^ i35) ^ iELL2;
            int i53 = (i26 ^ i38) ^ iELL2;
            i9 = (iRotateRight7 ^ iRotateRight35) ^ iELL;
            i20++;
            i7 = (iRotateRight56 ^ iRotateRight28) ^ iELL;
            i21 = iRotateRight7;
            i3 = i48 ^ iELL;
            i12 = i29;
            i4 = i50;
            i18 = iRotateRight21;
            i8 = i53;
            i2 = i49;
            i17 = iRotateRight14;
            i16 = i35;
            i5 = i51;
            c = c3;
            i10 = i26;
            i14 = i32;
            i6 = i52;
            i19 = iRotateRight28;
            c2 = c4;
        }
        iArr[0] = i2;
        iArr[1] = i3;
        iArr[2] = i4;
        iArr[3] = i5;
        iArr[4] = i6;
        iArr[5] = i7;
        iArr[c] = i8;
        iArr[c2] = i9;
        iArr[8] = i10;
        iArr[9] = i21;
        iArr[10] = i12;
        iArr[11] = i17;
        iArr[12] = i14;
        iArr[13] = i18;
        iArr[14] = i16;
        iArr[15] = i19;
    }

    static void sparkle_opt8(int[] iArr, int i) {
        int i2 = iArr[0];
        int i3 = iArr[1];
        char c = 2;
        int i4 = iArr[2];
        char c2 = 3;
        int i5 = iArr[3];
        char c3 = 4;
        int i6 = iArr[4];
        char c4 = 5;
        int i7 = iArr[5];
        int i8 = iArr[6];
        int i9 = iArr[7];
        int i10 = 0;
        while (i10 < i) {
            int[] iArr2 = RCON;
            int i11 = i3 ^ iArr2[i10 & 7];
            int i12 = i5 ^ i10;
            int i13 = iArr2[0];
            char c5 = c;
            int iRotateRight = i2 + Integers.rotateRight(i11, 31);
            char c6 = c2;
            int iRotateRight2 = i11 ^ Integers.rotateRight(iRotateRight, 24);
            char c7 = c3;
            int iRotateRight3 = (iRotateRight ^ i13) + Integers.rotateRight(iRotateRight2, 17);
            int iRotateRight4 = iRotateRight2 ^ Integers.rotateRight(iRotateRight3, 17);
            int i14 = (iRotateRight3 ^ i13) + iRotateRight4;
            int iRotateRight5 = iRotateRight4 ^ Integers.rotateRight(i14, 31);
            int iRotateRight6 = (i14 ^ i13) + Integers.rotateRight(iRotateRight5, 24);
            char c8 = c4;
            int iRotateRight7 = iRotateRight5 ^ Integers.rotateRight(iRotateRight6, 16);
            int i15 = iRotateRight6 ^ i13;
            int i16 = iArr2[1];
            int iRotateRight8 = i4 + Integers.rotateRight(i12, 31);
            int iRotateRight9 = i12 ^ Integers.rotateRight(iRotateRight8, 24);
            int iRotateRight10 = (iRotateRight8 ^ i16) + Integers.rotateRight(iRotateRight9, 17);
            int iRotateRight11 = iRotateRight9 ^ Integers.rotateRight(iRotateRight10, 17);
            int i17 = (iRotateRight10 ^ i16) + iRotateRight11;
            int iRotateRight12 = iRotateRight11 ^ Integers.rotateRight(i17, 31);
            int iRotateRight13 = (i17 ^ i16) + Integers.rotateRight(iRotateRight12, 24);
            int iRotateRight14 = iRotateRight12 ^ Integers.rotateRight(iRotateRight13, 16);
            int i18 = iRotateRight13 ^ i16;
            int i19 = iArr2[c5];
            int iRotateRight15 = i6 + Integers.rotateRight(i7, 31);
            int iRotateRight16 = i7 ^ Integers.rotateRight(iRotateRight15, 24);
            int iRotateRight17 = (iRotateRight15 ^ i19) + Integers.rotateRight(iRotateRight16, 17);
            int iRotateRight18 = iRotateRight16 ^ Integers.rotateRight(iRotateRight17, 17);
            int i20 = (iRotateRight17 ^ i19) + iRotateRight18;
            int iRotateRight19 = iRotateRight18 ^ Integers.rotateRight(i20, 31);
            int iRotateRight20 = (i20 ^ i19) + Integers.rotateRight(iRotateRight19, 24);
            int iRotateRight21 = iRotateRight19 ^ Integers.rotateRight(iRotateRight20, 16);
            int i21 = iArr2[c6];
            int iRotateRight22 = i8 + Integers.rotateRight(i9, 31);
            int iRotateRight23 = i9 ^ Integers.rotateRight(iRotateRight22, 24);
            int iRotateRight24 = (iRotateRight22 ^ i21) + Integers.rotateRight(iRotateRight23, 17);
            int iRotateRight25 = Integers.rotateRight(iRotateRight24, 17) ^ iRotateRight23;
            int i22 = (iRotateRight24 ^ i21) + iRotateRight25;
            int iRotateRight26 = Integers.rotateRight(i22, 31) ^ iRotateRight25;
            int iRotateRight27 = (i22 ^ i21) + Integers.rotateRight(iRotateRight26, 24);
            int iRotateRight28 = iRotateRight26 ^ Integers.rotateRight(iRotateRight27, 16);
            int i23 = iRotateRight27 ^ i21;
            int iELL = ELL(i15 ^ i18);
            int iELL2 = ELL(iRotateRight7 ^ iRotateRight14);
            int i24 = (i23 ^ i18) ^ iELL2;
            int i25 = (iRotateRight28 ^ iRotateRight14) ^ iELL;
            int i26 = iELL ^ (iRotateRight21 ^ iRotateRight7);
            i10++;
            i7 = iRotateRight7;
            i3 = i25;
            i8 = i18;
            i9 = iRotateRight14;
            i5 = i26;
            i4 = ((iRotateRight20 ^ i19) ^ i15) ^ iELL2;
            c = c5;
            c3 = c7;
            c4 = c8;
            i6 = i15;
            i2 = i24;
            c2 = c6;
        }
        iArr[0] = i2;
        iArr[1] = i3;
        iArr[c] = i4;
        iArr[c2] = i5;
        iArr[c3] = i6;
        iArr[c4] = i7;
        iArr[6] = i8;
        iArr[7] = i9;
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ int doFinal(byte[] bArr, int i) throws InvalidCipherTextException, IllegalStateException {
        return super.doFinal(bArr, i);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    protected void finishAAD(AEADBaseEngine.State state, boolean z) {
        finishAAD2(state);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ String getAlgorithmName() {
        return super.getAlgorithmName();
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public /* bridge */ /* synthetic */ int getIVBytesSize() {
        return super.getIVBytesSize();
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public /* bridge */ /* synthetic */ int getKeyBytesSize() {
        return super.getKeyBytesSize();
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ byte[] getMac() {
        return super.getMac();
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ int getOutputSize(int i) {
        return super.getOutputSize(i);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ int getUpdateOutputSize(int i) {
        return super.getUpdateOutputSize(i);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ void init(boolean z, CipherParameters cipherParameters) {
        super.init(z, cipherParameters);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    protected void init(byte[] bArr, byte[] bArr2) throws IllegalArgumentException {
        Pack.littleEndianToInt(bArr, 0, this.k);
        Pack.littleEndianToInt(bArr2, 0, this.npub);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ void processAADByte(byte b) {
        super.processAADByte(b);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ void processAADBytes(byte[] bArr, int i, int i2) {
        super.processAADBytes(bArr, i, i2);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    protected void processBufferAAD(byte[] bArr, int i) {
        int i2 = 0;
        while (true) {
            int i3 = this.RATE_WORDS;
            if (i2 >= i3 / 2) {
                sparkle_opt(this.state, this.SPARKLE_STEPS_SLIM);
                return;
            }
            int i4 = (i3 / 2) + i2;
            int[] iArr = this.state;
            int i5 = iArr[i2];
            int i6 = iArr[i4];
            int iLittleEndianToInt = Pack.littleEndianToInt(bArr, (i2 * 4) + i);
            int iLittleEndianToInt2 = Pack.littleEndianToInt(bArr, (i4 * 4) + i);
            int[] iArr2 = this.state;
            int i7 = this.RATE_WORDS;
            iArr2[i2] = (iLittleEndianToInt ^ i6) ^ iArr2[i7 + i2];
            iArr2[i4] = ((i6 ^ i5) ^ iLittleEndianToInt2) ^ iArr2[i7 + (this.CAP_MASK & i4)];
            i2++;
        }
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    protected void processBufferDecrypt(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = 0;
        while (true) {
            int i4 = this.RATE_WORDS;
            if (i3 >= i4 / 2) {
                sparkle_opt(this.state, this.SPARKLE_STEPS_SLIM);
                this.encrypted = true;
                return;
            }
            int i5 = (i4 / 2) + i3;
            int[] iArr = this.state;
            int i6 = iArr[i3];
            int i7 = iArr[i5];
            int i8 = i3 * 4;
            int iLittleEndianToInt = Pack.littleEndianToInt(bArr, i + i8);
            int i9 = i5 * 4;
            int iLittleEndianToInt2 = Pack.littleEndianToInt(bArr, i + i9);
            int[] iArr2 = this.state;
            int i10 = this.RATE_WORDS;
            iArr2[i3] = ((i6 ^ i7) ^ iLittleEndianToInt) ^ iArr2[i10 + i3];
            iArr2[i5] = (i6 ^ iLittleEndianToInt2) ^ iArr2[i10 + (this.CAP_MASK & i5)];
            Pack.intToLittleEndian(iLittleEndianToInt ^ i6, bArr2, i2 + i8);
            Pack.intToLittleEndian(iLittleEndianToInt2 ^ i7, bArr2, i2 + i9);
            i3++;
        }
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    protected void processBufferEncrypt(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = 0;
        while (true) {
            int i4 = this.RATE_WORDS;
            if (i3 >= i4 / 2) {
                sparkle_opt(this.state, this.SPARKLE_STEPS_SLIM);
                this.encrypted = true;
                return;
            }
            int i5 = (i4 / 2) + i3;
            int[] iArr = this.state;
            int i6 = iArr[i3];
            int i7 = iArr[i5];
            int i8 = i3 * 4;
            int iLittleEndianToInt = Pack.littleEndianToInt(bArr, i + i8);
            int i9 = i5 * 4;
            int iLittleEndianToInt2 = Pack.littleEndianToInt(bArr, i + i9);
            int[] iArr2 = this.state;
            int i10 = this.RATE_WORDS;
            iArr2[i3] = (i7 ^ iLittleEndianToInt) ^ iArr2[i10 + i3];
            iArr2[i5] = ((i6 ^ i7) ^ iLittleEndianToInt2) ^ iArr2[i10 + (this.CAP_MASK & i5)];
            Pack.intToLittleEndian(iLittleEndianToInt ^ i6, bArr2, i2 + i8);
            Pack.intToLittleEndian(iLittleEndianToInt2 ^ i7, bArr2, i2 + i9);
            i3++;
        }
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ int processByte(byte b, byte[] bArr, int i) throws DataLengthException {
        return super.processByte(b, bArr, i);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws DataLengthException {
        return super.processBytes(bArr, i, i2, bArr2, i3);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    protected void processFinalAAD() {
        int i = this.m_aadPos;
        int i2 = this.BlockSize;
        int[] iArr = this.state;
        int i3 = 0;
        if (i < i2) {
            int i4 = this.STATE_WORDS - 1;
            iArr[i4] = iArr[i4] ^ this._A0;
            byte[] bArr = this.m_aad;
            int i5 = this.m_aadPos;
            this.m_aadPos = i5 + 1;
            bArr[i5] = -128;
            Arrays.fill(this.m_aad, this.m_aadPos, this.BlockSize, (byte) 0);
        } else {
            int i6 = this.STATE_WORDS - 1;
            iArr[i6] = iArr[i6] ^ this._A1;
        }
        while (true) {
            int i7 = this.RATE_WORDS;
            if (i3 >= i7 / 2) {
                sparkle_opt(this.state, this.SPARKLE_STEPS_BIG);
                return;
            }
            int i8 = (i7 / 2) + i3;
            int[] iArr2 = this.state;
            int i9 = iArr2[i3];
            int i10 = iArr2[i8];
            int iLittleEndianToInt = Pack.littleEndianToInt(this.m_aad, i3 * 4);
            int iLittleEndianToInt2 = Pack.littleEndianToInt(this.m_aad, i8 * 4);
            int[] iArr3 = this.state;
            int i11 = this.RATE_WORDS;
            iArr3[i3] = (iLittleEndianToInt ^ i10) ^ iArr3[i11 + i3];
            iArr3[i8] = ((i10 ^ i9) ^ iLittleEndianToInt2) ^ iArr3[i11 + (this.CAP_MASK & i8)];
            i3++;
        }
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    protected void processFinalBlock(byte[] bArr, int i) {
        if (this.encrypted || this.m_bufPos > 0) {
            int[] iArr = this.state;
            int i2 = this.STATE_WORDS - 1;
            iArr[i2] = iArr[i2] ^ (this.m_bufPos < this.IV_SIZE ? this._M2 : this._M3);
            int[] iArr2 = new int[this.RATE_WORDS];
            for (int i3 = 0; i3 < this.m_bufPos; i3++) {
                int i4 = i3 >>> 2;
                iArr2[i4] = iArr2[i4] | ((this.m_buf[i3] & 255) << ((i3 & 3) << 3));
            }
            if (this.m_bufPos < this.IV_SIZE) {
                if (!this.forEncryption) {
                    int i5 = (this.m_bufPos & 3) << 3;
                    int i6 = this.m_bufPos >>> 2;
                    iArr2[i6] = ((this.state[this.m_bufPos >>> 2] >>> i5) << i5) | iArr2[i6];
                    int i7 = (this.m_bufPos >>> 2) + 1;
                    System.arraycopy(this.state, i7, iArr2, i7, this.RATE_WORDS - i7);
                }
                int i8 = this.m_bufPos >>> 2;
                iArr2[i8] = iArr2[i8] ^ (128 << ((this.m_bufPos & 3) << 3));
            }
            int i9 = 0;
            while (true) {
                int i10 = this.RATE_WORDS;
                if (i9 >= i10 / 2) {
                    break;
                }
                int i11 = (i10 / 2) + i9;
                int[] iArr3 = this.state;
                int i12 = iArr3[i9];
                int i13 = iArr3[i11];
                boolean z = this.forEncryption;
                int[] iArr4 = this.state;
                if (z) {
                    int i14 = iArr2[i9] ^ i13;
                    int i15 = this.RATE_WORDS;
                    iArr4[i9] = i14 ^ iArr4[i15 + i9];
                    iArr4[i11] = ((i12 ^ i13) ^ iArr2[i11]) ^ iArr4[i15 + (this.CAP_MASK & i11)];
                } else {
                    int i16 = (i12 ^ i13) ^ iArr2[i9];
                    int i17 = this.RATE_WORDS;
                    iArr4[i9] = i16 ^ iArr4[i17 + i9];
                    iArr4[i11] = (iArr2[i11] ^ i12) ^ iArr4[i17 + (this.CAP_MASK & i11)];
                }
                iArr2[i9] = i12 ^ iArr2[i9];
                iArr2[i11] = i13 ^ iArr2[i11];
                i9++;
            }
            int i18 = 0;
            while (i18 < this.m_bufPos) {
                bArr[i] = (byte) (iArr2[i18 >>> 2] >>> ((i18 & 3) << 3));
                i18++;
                i++;
            }
            sparkle_opt(this.state, this.SPARKLE_STEPS_BIG);
        }
        int i19 = 0;
        while (true) {
            int i20 = this.KEY_WORDS;
            int[] iArr5 = this.state;
            if (i19 >= i20) {
                Pack.intToLittleEndian(iArr5, this.RATE_WORDS, this.TAG_WORDS, this.mac, 0);
                return;
            } else {
                int i21 = this.RATE_WORDS + i19;
                iArr5[i21] = iArr5[i21] ^ this.k[i19];
                i19++;
            }
        }
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ void reset() {
        super.reset();
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    protected void reset(boolean z) {
        this.encrypted = false;
        System.arraycopy(this.npub, 0, this.state, 0, this.RATE_WORDS);
        System.arraycopy(this.k, 0, this.state, this.RATE_WORDS, this.KEY_WORDS);
        sparkle_opt(this.state, this.SPARKLE_STEPS_BIG);
        super.reset(z);
    }
}
