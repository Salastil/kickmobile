package org.bouncycastle.pqc.crypto.snova;

import com.google.common.base.Ascii;
import java.lang.reflect.Array;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.digests.SHAKEDigest;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.pqc.crypto.MessageSigner;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.GF16;

/* JADX INFO: loaded from: classes11.dex */
public class SnovaSigner implements MessageSigner {
    private SnovaEngine engine;
    private SnovaParameters params;
    private SnovaPrivateKeyParameters privKey;
    private SnovaPublicKeyParameters pubKey;
    private SecureRandom random;
    private final SHAKEDigest shake = new SHAKEDigest(256);

    private void evaluation(byte[] bArr, MapGroup1 mapGroup1, byte[][][][] bArr2, byte[] bArr3) {
        int m = this.params.getM();
        int alpha = this.params.getAlpha();
        int n = this.params.getN();
        int l = this.params.getL();
        int lsq = this.params.getLsq();
        int o = this.params.getO();
        byte[][][] bArr4 = (byte[][][]) Array.newInstance((Class<?>) Byte.TYPE, alpha, n, lsq);
        byte[][][] bArr5 = (byte[][][]) Array.newInstance((Class<?>) Byte.TYPE, alpha, n, lsq);
        byte[] bArr6 = new byte[lsq];
        int i = 0;
        int i2 = 0;
        while (i < m) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < n) {
                int i5 = 0;
                while (i5 < alpha) {
                    GF16Utils.gf16mTranMulMul(bArr3, i4, mapGroup1.aAlpha[i][i5], mapGroup1.bAlpha[i][i5], mapGroup1.qAlpha1[i][i5], mapGroup1.qAlpha2[i][i5], bArr6, bArr4[i5][i3], bArr5[i5][i3], l);
                    i5++;
                    i3 = i3;
                }
                i4 += lsq;
                i3++;
            }
            int i6 = l;
            int i7 = i;
            int i8 = 0;
            while (i8 < alpha) {
                if (i7 >= o) {
                    i7 -= o;
                }
                int i9 = i;
                int i10 = 0;
                while (i10 < n) {
                    int i11 = i2;
                    int i12 = i9;
                    int i13 = lsq;
                    int i14 = o;
                    int i15 = i7;
                    GF16Utils.gf16mMul(getPMatrix(mapGroup1, bArr2, i15, i10, 0), bArr5[i8][0], bArr6, i6);
                    int i16 = 1;
                    while (i16 < n) {
                        GF16Utils.gf16mMulTo(getPMatrix(mapGroup1, bArr2, i15, i10, i16), bArr5[i8][i16], bArr6, i6);
                        i16++;
                        m = m;
                    }
                    GF16Utils.gf16mMulTo(bArr4[i8][i10], bArr6, bArr, i11, i6);
                    i10++;
                    mapGroup1 = mapGroup1;
                    i7 = i15;
                    lsq = i13;
                    o = i14;
                    i9 = i12;
                    i2 = i11;
                }
                i8++;
                i7++;
                mapGroup1 = mapGroup1;
                o = o;
                i = i9;
            }
            i++;
            i2 += lsq;
            l = i6;
        }
    }

    private byte[] getMessageHash(byte[] bArr) {
        byte[] bArr2 = new byte[this.shake.getDigestSize()];
        this.shake.update(bArr, 0, bArr.length);
        this.shake.doFinal(bArr2, 0);
        return bArr2;
    }

    private byte[] getPMatrix(MapGroup1 mapGroup1, byte[][][][] bArr, int i, int i2, int i3) {
        int v = this.params.getV();
        if (i2 < v) {
            return i3 < v ? mapGroup1.p11[i][i2][i3] : mapGroup1.p12[i][i2][i3 - v];
        }
        return i3 < v ? mapGroup1.p21[i][i2 - v][i3] : bArr[i][i2 - v][i3 - v];
    }

    private int performGaussianElimination(byte[][] bArr, byte[] bArr2, int i) {
        int i2 = i + 1;
        int i3 = 0;
        while (i3 < i) {
            int i4 = i3;
            while (i4 < i && bArr[i4][i3] == 0) {
                i4++;
            }
            if (i4 >= i) {
                return 1;
            }
            if (i4 != i3) {
                byte[] bArr3 = bArr[i3];
                bArr[i3] = bArr[i4];
                bArr[i4] = bArr3;
            }
            byte bInv = GF16.inv(bArr[i3][i3]);
            for (int i5 = i3; i5 < i2; i5++) {
                byte[] bArr4 = bArr[i3];
                bArr4[i5] = GF16.mul(bArr4[i5], bInv);
            }
            int i6 = i3 + 1;
            for (int i7 = i6; i7 < i; i7++) {
                byte b = bArr[i7][i3];
                if (b != 0) {
                    for (int i8 = i3; i8 < i2; i8++) {
                        byte[] bArr5 = bArr[i7];
                        bArr5[i8] = (byte) (bArr5[i8] ^ GF16.mul(bArr[i3][i8], b));
                    }
                }
            }
            i3 = i6;
        }
        for (int i9 = i - 1; i9 >= 0; i9--) {
            byte bMul = bArr[i9][i];
            for (int i10 = i9 + 1; i10 < i; i10++) {
                bMul = (byte) (bMul ^ GF16.mul(bArr[i9][i10], bArr2[i10]));
            }
            bArr2[i9] = bMul;
        }
        return 0;
    }

    void createSignedHash(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, int i3, int i4, byte[] bArr4, int i5) {
        this.shake.update(bArr, 0, i);
        this.shake.update(bArr2, 0, i2);
        this.shake.update(bArr3, i3, i4);
        this.shake.doFinal(bArr4, 0, i5);
    }

    @Override // org.bouncycastle.pqc.crypto.MessageSigner
    public byte[] generateSignature(byte[] bArr) {
        byte[] bArrCopyOfRange;
        byte[] bArrCopyOfRange2;
        byte[] messageHash = getMessageHash(bArr);
        byte[] bArr2 = new byte[this.params.getSaltLength()];
        this.random.nextBytes(bArr2);
        byte[] bArr3 = new byte[(((this.params.getN() * this.params.getLsq()) + 1) >>> 1) + this.params.getSaltLength()];
        SnovaKeyElements snovaKeyElements = new SnovaKeyElements(this.params);
        boolean zIsSkIsSeed = this.params.isSkIsSeed();
        SnovaPrivateKeyParameters snovaPrivateKeyParameters = this.privKey;
        if (zIsSkIsSeed) {
            byte[] privateKey = snovaPrivateKeyParameters.getPrivateKey();
            bArrCopyOfRange = Arrays.copyOfRange(privateKey, 0, 16);
            bArrCopyOfRange2 = Arrays.copyOfRange(privateKey, 16, privateKey.length);
            this.engine.genMap1T12Map2(snovaKeyElements, bArrCopyOfRange, bArrCopyOfRange2);
        } else {
            byte[] privateKey2 = snovaPrivateKeyParameters.getPrivateKey();
            int length = (privateKey2.length - 48) << 1;
            byte[] bArr4 = new byte[length];
            GF16Utils.decodeMergeInHalf(privateKey2, bArr4, length);
            SnovaKeyElements.copy4d(bArr4, SnovaKeyElements.copy4d(bArr4, SnovaKeyElements.copy4d(bArr4, SnovaKeyElements.copy3d(bArr4, SnovaKeyElements.copy3d(bArr4, SnovaKeyElements.copy3d(bArr4, SnovaKeyElements.copy3d(bArr4, SnovaKeyElements.copy3d(bArr4, 0, snovaKeyElements.map1.aAlpha), snovaKeyElements.map1.bAlpha), snovaKeyElements.map1.qAlpha1), snovaKeyElements.map1.qAlpha2), snovaKeyElements.T12), snovaKeyElements.map2.f11), snovaKeyElements.map2.f12), snovaKeyElements.map2.f21);
            bArrCopyOfRange = Arrays.copyOfRange(privateKey2, privateKey2.length - 48, privateKey2.length - 32);
            bArrCopyOfRange2 = Arrays.copyOfRange(privateKey2, privateKey2.length - 32, privateKey2.length);
        }
        signDigestCore(bArr3, messageHash, bArr2, snovaKeyElements.map1.aAlpha, snovaKeyElements.map1.bAlpha, snovaKeyElements.map1.qAlpha1, snovaKeyElements.map1.qAlpha2, snovaKeyElements.T12, snovaKeyElements.map2.f11, snovaKeyElements.map2.f12, snovaKeyElements.map2.f21, bArrCopyOfRange, bArrCopyOfRange2);
        return Arrays.concatenate(bArr3, bArr);
    }

    @Override // org.bouncycastle.pqc.crypto.MessageSigner
    public void init(boolean z, CipherParameters cipherParameters) {
        SecureRandom secureRandom;
        if (z) {
            this.pubKey = null;
            if (cipherParameters instanceof ParametersWithRandom) {
                ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
                this.privKey = (SnovaPrivateKeyParameters) parametersWithRandom.getParameters();
                secureRandom = parametersWithRandom.getRandom();
            } else {
                this.privKey = (SnovaPrivateKeyParameters) cipherParameters;
                secureRandom = CryptoServicesRegistrar.getSecureRandom();
            }
            this.random = secureRandom;
            this.params = this.privKey.getParameters();
        } else {
            SnovaPublicKeyParameters snovaPublicKeyParameters = (SnovaPublicKeyParameters) cipherParameters;
            this.pubKey = snovaPublicKeyParameters;
            this.params = snovaPublicKeyParameters.getParameters();
            this.privKey = null;
            this.random = null;
        }
        this.engine = new SnovaEngine(this.params);
    }

    void signDigestCore(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[][][] bArr4, byte[][][] bArr5, byte[][][] bArr6, byte[][][] bArr7, byte[][][] bArr8, byte[][][][] bArr9, byte[][][][] bArr10, byte[][][][] bArr11, byte[] bArr12, byte[] bArr13) {
        int i;
        int i2;
        int i3;
        byte[] bArr14;
        int i4;
        byte b;
        int i5;
        byte b2;
        int m = this.params.getM();
        int l = this.params.getL();
        int lsq = this.params.getLsq();
        int alpha = this.params.getAlpha();
        int v = this.params.getV();
        int o = this.params.getO();
        int n = this.params.getN();
        int i6 = m * lsq;
        int i7 = o * lsq;
        int i8 = v * lsq;
        int i9 = (i7 + 1) >>> 1;
        byte[][] bArr15 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i6, i6 + 1);
        byte[][] bArr16 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, lsq, lsq);
        byte[] bArr17 = new byte[i6];
        byte[][][] bArr18 = (byte[][][]) Array.newInstance((Class<?>) Byte.TYPE, alpha, v, lsq);
        byte[][][] bArr19 = (byte[][][]) Array.newInstance((Class<?>) Byte.TYPE, alpha, v, lsq);
        byte[] bArr20 = new byte[lsq];
        byte[] bArr21 = new byte[lsq];
        byte[] bArr22 = new byte[lsq];
        int i10 = lsq;
        byte[] bArr23 = new byte[i6];
        int i11 = n * i10;
        byte[] bArr24 = new byte[i9];
        int i12 = (i8 + 1) >>> 1;
        int i13 = alpha;
        byte[] bArr25 = new byte[i12];
        byte[] bArr26 = new byte[l];
        int i14 = l;
        int i15 = v;
        byte b3 = 0;
        byte[] bArr27 = bArr17;
        byte[] bArr28 = new byte[i11];
        int i16 = i12;
        int i17 = o;
        byte[] bArr29 = bArr21;
        byte[] bArr30 = bArr22;
        int i18 = m;
        createSignedHash(bArr12, bArr12.length, bArr2, bArr2.length, bArr3, 0, bArr3.length, bArr24, i9);
        byte[] bArr31 = bArr2;
        byte[] bArr32 = bArr3;
        GF16.decode(bArr24, 0, bArr23, 0, i6);
        byte b4 = 0;
        while (true) {
            for (int i19 = b3; i19 < bArr15.length; i19++) {
                Arrays.fill(bArr15[i19], b3);
            }
            byte b5 = (byte) (b4 + 1);
            for (int i20 = b3; i20 < i6; i20++) {
                bArr15[i20][i6] = bArr23[i20];
            }
            this.shake.update(bArr13, b3, bArr13.length);
            this.shake.update(bArr31, b3, bArr31.length);
            this.shake.update(bArr32, b3, bArr32.length);
            this.shake.update(b5);
            int i21 = i16;
            this.shake.doFinal(bArr25, b3, i21);
            byte[] bArr33 = bArr28;
            GF16.decode(bArr25, bArr33, i21 << 1);
            int i22 = b3;
            int i23 = i18;
            int i24 = i22;
            while (i22 < i23) {
                byte[] bArr34 = bArr30;
                Arrays.fill(bArr34, b3);
                int i25 = i22;
                int i26 = b3;
                int i27 = i13;
                while (i26 < i27) {
                    byte b6 = b5;
                    int i28 = i17;
                    if (i25 >= i28) {
                        i25 -= i28;
                    }
                    int i29 = i25;
                    byte[] bArr35 = bArr23;
                    int i30 = i15;
                    int i31 = 0;
                    int i32 = 0;
                    while (i31 < i30) {
                        byte[] bArr36 = bArr4[i22][i26];
                        byte[] bArr37 = bArr5[i22][i26];
                        byte[] bArr38 = bArr6[i22][i26];
                        byte[] bArr39 = bArr7[i22][i26];
                        byte[] bArr40 = bArr18[i26][i31];
                        byte[] bArr41 = bArr19[i26][i31];
                        int i33 = i31;
                        int i34 = i27;
                        byte[] bArr42 = bArr33;
                        int i35 = i10;
                        byte[] bArr43 = bArr26;
                        GF16Utils.gf16mTranMulMul(bArr42, i32, bArr36, bArr37, bArr38, bArr39, bArr43, bArr40, bArr41, i14);
                        i32 += i35;
                        i27 = i34;
                        i31 = i33 + 1;
                        bArr35 = bArr35;
                        bArr25 = bArr25;
                        bArr26 = bArr43;
                        i10 = i35;
                        bArr33 = bArr42;
                    }
                    byte[] bArr44 = bArr33;
                    int i36 = i27;
                    byte[] bArr45 = bArr35;
                    int i37 = i10;
                    byte[] bArr46 = bArr26;
                    int i38 = 0;
                    byte[] bArr47 = bArr25;
                    int i39 = 0;
                    while (i39 < i30) {
                        int i40 = i38;
                        while (i40 < i30) {
                            GF16Utils.gf16mMulMulTo(bArr18[i26][i39], bArr9[i29][i39][i40], bArr19[i26][i40], bArr46, bArr34, i14);
                            i40++;
                            i37 = i37;
                            i22 = i22;
                            i23 = i23;
                            i26 = i26;
                            i21 = i21;
                        }
                        i39++;
                        i37 = i37;
                        i26 = i26;
                        i38 = 0;
                    }
                    i27 = i36;
                    i25 = i29 + 1;
                    i10 = i37;
                    i17 = i28;
                    i15 = i30;
                    b5 = b6;
                    bArr23 = bArr45;
                    i21 = i21;
                    i26++;
                    i22 = i22;
                    bArr25 = bArr47;
                    bArr26 = bArr46;
                    bArr33 = bArr44;
                }
                int i41 = i21;
                int i42 = i23;
                byte[] bArr48 = bArr33;
                bArr30 = bArr34;
                byte b7 = b5;
                int i43 = i27;
                byte[] bArr49 = bArr23;
                int i44 = i10;
                byte[] bArr50 = bArr26;
                int i45 = i14;
                int i46 = i15;
                int i47 = i17;
                byte[] bArr51 = bArr25;
                int i48 = i22;
                int i49 = 0;
                int i50 = 0;
                while (i49 < i45) {
                    int i51 = i50;
                    int i52 = 0;
                    while (i52 < i45) {
                        byte[] bArr52 = bArr15[i24 + i51];
                        bArr52[i6] = (byte) (bArr30[i51] ^ bArr52[i6]);
                        i52++;
                        i51++;
                    }
                    i49++;
                    i50 = i51;
                }
                int i53 = 0;
                int i54 = 0;
                while (i53 < i47) {
                    int i55 = i48;
                    int i56 = 0;
                    while (i56 < i43) {
                        if (i55 >= i47) {
                            i55 -= i47;
                        }
                        int i57 = i55;
                        for (int i58 = 0; i58 < i44; i58++) {
                            Arrays.fill(bArr16[i58], (byte) 0);
                        }
                        int i59 = 0;
                        while (i59 < i46) {
                            int i60 = i56;
                            int i61 = i59;
                            GF16Utils.gf16mMulMul(bArr18[i56][i59], bArr10[i57][i59][i53], bArr7[i48][i56], bArr50, bArr20, i45);
                            byte[] bArr53 = bArr29;
                            GF16Utils.gf16mMulMul(bArr6[i48][i60], bArr11[i57][i53][i61], bArr19[i60][i61], bArr50, bArr53, i45);
                            int i62 = 0;
                            int i63 = 0;
                            int i64 = 0;
                            while (i62 < i44) {
                                if (i63 == i45) {
                                    i64 += i45;
                                    i63 = 0;
                                }
                                int i65 = i43;
                                byte b8 = bArr20[i64];
                                byte b9 = bArr53[i63];
                                int i66 = 0;
                                int i67 = 0;
                                int i68 = 0;
                                int i69 = 0;
                                int i70 = i62;
                                int i71 = 0;
                                while (i66 < i44) {
                                    if (i71 == i45) {
                                        i67++;
                                        i68 += i45;
                                        b = bArr20[i64 + i67];
                                        b2 = bArr53[i68 + i63];
                                        i5 = 0;
                                        i69 = 0;
                                    } else {
                                        b = b8;
                                        i5 = i71;
                                        b2 = b9;
                                    }
                                    int i72 = i63;
                                    byte b10 = bArr5[i48][i60][i69 + i63];
                                    int i73 = i64;
                                    byte b11 = bArr4[i48][i60][i64 + i5];
                                    byte[] bArr54 = bArr16[i70];
                                    bArr54[i66] = (byte) (bArr54[i66] ^ (GF16.mul(b, b10) ^ GF16.mul(b11, b2)));
                                    i69 += i45;
                                    b8 = b;
                                    b9 = b2;
                                    i66++;
                                    i71 = i5 + 1;
                                    i63 = i72;
                                    i64 = i73;
                                }
                                i62 = i70 + 1;
                                i63++;
                                i43 = i65;
                            }
                            i59 = i61 + 1;
                            i56 = i60;
                            bArr29 = bArr53;
                        }
                        int i74 = i56;
                        byte[] bArr55 = bArr29;
                        int i75 = i43;
                        int i76 = 0;
                        while (i76 < i44) {
                            int i77 = 0;
                            while (i77 < i44) {
                                byte[] bArr56 = bArr15[i24 + i76];
                                int i78 = i54 + i77;
                                bArr56[i78] = (byte) (bArr56[i78] ^ bArr16[i76][i77]);
                                i77++;
                                i76 = i76;
                            }
                            i76++;
                        }
                        i56 = i74 + 1;
                        i55 = i57 + 1;
                        i43 = i75;
                        bArr29 = bArr55;
                    }
                    i53++;
                    i54 += i44;
                    bArr29 = bArr29;
                }
                i22 = i48 + 1;
                i24 += i44;
                i14 = i45;
                i10 = i44;
                i17 = i47;
                i15 = i46;
                i23 = i42;
                b5 = b7;
                i13 = i43;
                bArr23 = bArr49;
                bArr25 = bArr51;
                i21 = i41;
                b3 = 0;
                bArr26 = bArr50;
                bArr29 = bArr29;
                bArr33 = bArr48;
            }
            i16 = i21;
            int i79 = i23;
            bArr28 = bArr33;
            byte[] bArr57 = bArr23;
            i = i10;
            byte[] bArr58 = bArr29;
            byte[] bArr59 = bArr26;
            i2 = i14;
            i3 = i15;
            bArr14 = bArr27;
            byte[] bArr60 = bArr25;
            int i80 = i13;
            byte b12 = b5;
            i4 = i17;
            if (performGaussianElimination(bArr15, bArr14, i6) == 0) {
                break;
            }
            bArr31 = bArr2;
            bArr27 = bArr14;
            i14 = i2;
            i10 = i;
            i17 = i4;
            i15 = i3;
            i18 = i79;
            b4 = b12;
            i13 = i80;
            bArr23 = bArr57;
            bArr25 = bArr60;
            b3 = 0;
            bArr32 = bArr3;
            bArr26 = bArr59;
            bArr29 = bArr58;
        }
        int i81 = 0;
        int i82 = 0;
        while (i81 < i3) {
            int i83 = 0;
            int i84 = 0;
            while (i83 < i4) {
                byte[] bArr61 = bArr28;
                GF16Utils.gf16mMulTo(bArr8[i81][i83], bArr14, i84, bArr61, i82, i2);
                i83++;
                i84 += i;
                bArr28 = bArr61;
            }
            i81++;
            i82 += i;
        }
        byte[] bArr62 = bArr28;
        System.arraycopy(bArr14, 0, bArr62, i8, i7);
        GF16.encode(bArr62, bArr, i11);
        System.arraycopy(bArr3, 0, bArr, bArr.length - 16, 16);
    }

    @Override // org.bouncycastle.pqc.crypto.MessageSigner
    public boolean verifySignature(byte[] bArr, byte[] bArr2) {
        byte[] messageHash = getMessageHash(bArr);
        MapGroup1 mapGroup1 = new MapGroup1(this.params);
        byte[] encoded = this.pubKey.getEncoded();
        byte[] bArrCopyOf = Arrays.copyOf(encoded, 16);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(encoded, 16, encoded.length);
        this.engine.genABQP(mapGroup1, bArrCopyOf);
        byte[][][][] bArr3 = (byte[][][][]) Array.newInstance((Class<?>) Byte.TYPE, this.params.getM(), this.params.getO(), this.params.getO(), this.params.getLsq());
        if ((this.params.getLsq() & 1) == 0) {
            MapGroup1.decodeP(bArrCopyOfRange, 0, bArr3, bArrCopyOfRange.length << 1);
        } else {
            int length = bArrCopyOfRange.length << 1;
            byte[] bArr4 = new byte[length];
            GF16.decode(bArrCopyOfRange, bArr4, length);
            MapGroup1.fillP(bArr4, 0, bArr3, length);
        }
        return verifySignatureCore(messageHash, bArr2, bArrCopyOf, mapGroup1, bArr3);
    }

    boolean verifySignatureCore(byte[] bArr, byte[] bArr2, byte[] bArr3, MapGroup1 mapGroup1, byte[][][][] bArr4) {
        int lsq = this.params.getLsq();
        int o = this.params.getO() * lsq;
        int i = (o + 1) >>> 1;
        int saltLength = this.params.getSaltLength();
        int m = this.params.getM();
        int n = this.params.getN() * lsq;
        byte[] bArr5 = new byte[i];
        createSignedHash(bArr3, bArr3.length, bArr, bArr.length, bArr2, (n + 1) >>> 1, saltLength, bArr5, i);
        if ((o & 1) != 0) {
            int i2 = i - 1;
            bArr5[i2] = (byte) (bArr5[i2] & Ascii.SI);
        }
        byte[] bArr6 = new byte[n];
        GF16.decode(bArr2, 0, bArr6, 0, n);
        int i3 = m * lsq;
        byte[] bArr7 = new byte[i3];
        evaluation(bArr7, mapGroup1, bArr4, bArr6);
        byte[] bArr8 = new byte[i];
        GF16.encode(bArr7, bArr8, i3);
        return Arrays.areEqual(bArr5, bArr8);
    }
}
