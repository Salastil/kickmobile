package org.bouncycastle.pqc.crypto.rainbow;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.pqc.crypto.MessageSigner;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes11.dex */
public class RainbowSigner implements MessageSigner {
    private static final int MAXITS = 65536;
    private ComputeInField cf = new ComputeInField();
    private Digest hashAlgo;
    private RainbowKeyParameters key;
    private SecureRandom random;
    int signableDocumentLength;
    private Version version;

    /* JADX INFO: renamed from: org.bouncycastle.pqc.crypto.rainbow.RainbowSigner$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$bouncycastle$pqc$crypto$rainbow$Version;

        static {
            int[] iArr = new int[Version.values().length];
            $SwitchMap$org$bouncycastle$pqc$crypto$rainbow$Version = iArr;
            try {
                iArr[Version.CLASSIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$bouncycastle$pqc$crypto$rainbow$Version[Version.CIRCUMZENITHAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$bouncycastle$pqc$crypto$rainbow$Version[Version.COMPRESSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private byte[] genSignature(byte[] bArr) {
        short[] sArr;
        ComputeInField computeInField;
        short[][] sArr2;
        int i;
        int i2;
        byte[] bArr2 = new byte[this.hashAlgo.getDigestSize()];
        this.hashAlgo.update(bArr, 0, bArr.length);
        this.hashAlgo.doFinal(bArr2, 0);
        int v1 = this.key.getParameters().getV1();
        int o1 = this.key.getParameters().getO1();
        int o2 = this.key.getParameters().getO2();
        int m = this.key.getParameters().getM();
        int n = this.key.getParameters().getN();
        RainbowPrivateKeyParameters rainbowPrivateKeyParameters = (RainbowPrivateKeyParameters) this.key;
        this.random = new RainbowDRBG(RainbowUtil.hash(this.hashAlgo, rainbowPrivateKeyParameters.sk_seed, bArr2, new byte[this.hashAlgo.getDigestSize()]), rainbowPrivateKeyParameters.getParameters().getHash_algo());
        short[] sArr3 = new short[v1];
        short[] sArr4 = new short[o1];
        short[] sArr5 = new short[o2];
        short[][] sArr6 = (short[][]) Array.newInstance((Class<?>) Short.TYPE, o2, o1);
        int i3 = 0;
        short[][] sArr7 = (short[][]) Array.newInstance((Class<?>) Short.TYPE, o2, o2);
        byte[] bArr3 = new byte[rainbowPrivateKeyParameters.getParameters().getLen_salt()];
        short[] sArr8 = new short[m];
        short[] sArr9 = new short[o1];
        short[] sArr10 = new short[o2];
        int i4 = 0;
        short[][] sArrInverse = null;
        while (sArrInverse == null && i4 < 65536) {
            byte[] bArr4 = new byte[v1];
            this.random.nextBytes(bArr4);
            int i5 = 0;
            while (i5 < v1) {
                byte[] bArr5 = bArr4;
                sArr3[i5] = (short) (bArr5[i5] & 255);
                i5++;
                bArr4 = bArr5;
            }
            short[][] sArr11 = (short[][]) Array.newInstance((Class<?>) Short.TYPE, o1, o1);
            int i6 = 0;
            while (true) {
                i2 = i4;
                if (i6 < v1) {
                    int i7 = 0;
                    while (i7 < o1) {
                        int i8 = i7;
                        int i9 = 0;
                        while (i9 < o1) {
                            int i10 = i9;
                            int i11 = i6;
                            short sMultElem = GF2Field.multElem(rainbowPrivateKeyParameters.l1_F2[i8][i6][i10], sArr3[i11]);
                            short[] sArr12 = sArr11[i8];
                            sArr12[i10] = GF2Field.addElem(sArr12[i10], sMultElem);
                            i9 = i10 + 1;
                            i6 = i11;
                        }
                        i7 = i8 + 1;
                    }
                    i6++;
                    i4 = i2;
                }
            }
            sArrInverse = this.cf.inverse(sArr11);
            i4 = i2 + 1;
        }
        int i12 = i4;
        int i13 = 0;
        while (i13 < o1) {
            int i14 = i13;
            sArr4[i14] = this.cf.multiplyMatrix_quad(rainbowPrivateKeyParameters.l1_F1[i14], sArr3);
            i13 = i14 + 1;
        }
        int i15 = 0;
        while (i15 < v1) {
            int i16 = 0;
            while (true) {
                i = i15;
                if (i16 < o2) {
                    int i17 = i16;
                    sArr10[i17] = this.cf.multiplyMatrix_quad(rainbowPrivateKeyParameters.l2_F1[i17], sArr3);
                    int i18 = 0;
                    while (i18 < o1) {
                        int i19 = i18;
                        short sMultElem2 = GF2Field.multElem(rainbowPrivateKeyParameters.l2_F2[i17][i][i18], sArr3[i]);
                        short[] sArr13 = sArr6[i17];
                        sArr13[i19] = GF2Field.addElem(sArr13[i19], sMultElem2);
                        i18 = i19 + 1;
                    }
                    int i20 = 0;
                    while (i20 < o2) {
                        int i21 = i20;
                        short sMultElem3 = GF2Field.multElem(rainbowPrivateKeyParameters.l2_F3[i17][i][i20], sArr3[i]);
                        short[] sArr14 = sArr7[i17];
                        sArr14[i21] = GF2Field.addElem(sArr14[i21], sMultElem3);
                        i20 = i21 + 1;
                    }
                    i16 = i17 + 1;
                    i15 = i;
                }
            }
            i15 = i + 1;
        }
        byte[] bArr6 = new byte[m];
        short[] sArr15 = sArr9;
        int i22 = i12;
        short[] sArrSolveEquation = null;
        while (true) {
            sArr = sArr3;
            if (sArrSolveEquation != null || i22 >= 65536) {
                break;
            }
            int[] iArr = new int[2];
            iArr[1] = o2;
            iArr[i3] = o2;
            short[][] sArr16 = (short[][]) Array.newInstance((Class<?>) Short.TYPE, iArr);
            this.random.nextBytes(bArr3);
            short[] sArrMakeMessageRepresentative = makeMessageRepresentative(RainbowUtil.hash(this.hashAlgo, bArr2, bArr3, bArr6));
            byte[] bArr7 = bArr2;
            byte[] bArr8 = bArr6;
            byte[] bArr9 = bArr3;
            int i23 = i3;
            System.arraycopy(this.cf.addVect(Arrays.copyOf(sArrMakeMessageRepresentative, o1), this.cf.multiplyMatrix(rainbowPrivateKeyParameters.s1, Arrays.copyOfRange(sArrMakeMessageRepresentative, o1, m))), i23, sArr8, i23, o1);
            System.arraycopy(sArrMakeMessageRepresentative, o1, sArr8, o1, o2);
            short[] sArrMultiplyMatrix = this.cf.multiplyMatrix(sArrInverse, this.cf.addVect(sArr4, Arrays.copyOf(sArr8, o1)));
            short[] sArrMultiplyMatrix2 = this.cf.multiplyMatrix(sArr6, sArrMultiplyMatrix);
            int i24 = 0;
            while (true) {
                computeInField = this.cf;
                sArr2 = sArrInverse;
                if (i24 >= o2) {
                    break;
                }
                sArr5[i24] = computeInField.multiplyMatrix_quad(rainbowPrivateKeyParameters.l2_F5[i24], sArrMultiplyMatrix);
                i24++;
                sArrInverse = sArr2;
            }
            short[] sArr17 = sArr10;
            short[] sArrAddVect = this.cf.addVect(this.cf.addVect(computeInField.addVect(sArrMultiplyMatrix2, sArr5), sArr17), Arrays.copyOfRange(sArr8, o1, m));
            for (int i25 = 0; i25 < o1; i25++) {
                int i26 = 0;
                while (true) {
                    short[] sArr18 = sArrMultiplyMatrix;
                    if (i26 < o2) {
                        int i27 = 0;
                        while (i27 < o2) {
                            int i28 = i27;
                            int i29 = m;
                            short sMultElem4 = GF2Field.multElem(rainbowPrivateKeyParameters.l2_F6[i26][i25][i28], sArr18[i25]);
                            short[] sArr19 = sArr16[i26];
                            sArr19[i28] = GF2Field.addElem(sArr19[i28], sMultElem4);
                            i27 = i28 + 1;
                            m = i29;
                        }
                        i26++;
                        sArrMultiplyMatrix = sArr18;
                    }
                }
            }
            i22++;
            sArrSolveEquation = this.cf.solveEquation(this.cf.addMatrix(sArr16, sArr7), sArrAddVect);
            sArr15 = sArrMultiplyMatrix;
            sArr10 = sArr17;
            sArr3 = sArr;
            bArr2 = bArr7;
            bArr6 = bArr8;
            bArr3 = bArr9;
            sArrInverse = sArr2;
            m = m;
            i3 = 0;
        }
        byte[] bArr10 = bArr3;
        short[] sArr20 = sArrSolveEquation == null ? new short[o2] : sArrSolveEquation;
        short[] sArrAddVect2 = this.cf.addVect(this.cf.addVect(sArr, this.cf.multiplyMatrix(rainbowPrivateKeyParameters.t1, sArr15)), this.cf.multiplyMatrix(rainbowPrivateKeyParameters.t4, sArr20));
        short[] sArrAddVect3 = this.cf.addVect(sArr15, this.cf.multiplyMatrix(rainbowPrivateKeyParameters.t3, sArr20));
        short[] sArrCopyOf = Arrays.copyOf(sArrAddVect2, n);
        System.arraycopy(sArrAddVect3, 0, sArrCopyOf, v1, o1);
        System.arraycopy(sArr20, 0, sArrCopyOf, o1 + v1, o2);
        if (i22 != 65536) {
            return Arrays.concatenate(RainbowUtil.convertArray(sArrCopyOf), bArr10);
        }
        throw new IllegalStateException("unable to generate signature - LES not solvable");
    }

    private short[] makeMessageRepresentative(byte[] bArr) {
        int i = this.signableDocumentLength;
        short[] sArr = new short[i];
        int i2 = 0;
        int i3 = 0;
        while (i2 < bArr.length) {
            sArr[i2] = (short) (bArr[i3] & 255);
            i3++;
            i2++;
            if (i2 >= i) {
                break;
            }
        }
        return sArr;
    }

    @Override // org.bouncycastle.pqc.crypto.MessageSigner
    public byte[] generateSignature(byte[] bArr) {
        return genSignature(bArr);
    }

    @Override // org.bouncycastle.pqc.crypto.MessageSigner
    public void init(boolean z, CipherParameters cipherParameters) {
        RainbowKeyParameters rainbowKeyParameters;
        if (z) {
            if (cipherParameters instanceof ParametersWithRandom) {
                ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
                this.random = parametersWithRandom.getRandom();
                rainbowKeyParameters = (RainbowKeyParameters) parametersWithRandom.getParameters();
            } else {
                rainbowKeyParameters = (RainbowKeyParameters) cipherParameters;
                SecureRandom secureRandom = CryptoServicesRegistrar.getSecureRandom();
                byte[] bArr = new byte[rainbowKeyParameters.getParameters().getLen_skseed()];
                secureRandom.nextBytes(bArr);
                this.random = new RainbowDRBG(bArr, rainbowKeyParameters.getParameters().getHash_algo());
            }
            this.version = rainbowKeyParameters.getParameters().getVersion();
            this.key = rainbowKeyParameters;
        } else {
            RainbowKeyParameters rainbowKeyParameters2 = (RainbowKeyParameters) cipherParameters;
            this.key = rainbowKeyParameters2;
            this.version = rainbowKeyParameters2.getParameters().getVersion();
        }
        this.signableDocumentLength = this.key.getDocLength();
        this.hashAlgo = this.key.getParameters().getHash_algo();
    }

    @Override // org.bouncycastle.pqc.crypto.MessageSigner
    public boolean verifySignature(byte[] bArr, byte[] bArr2) {
        short[] sArrPublicMap;
        byte[] bArr3 = new byte[this.hashAlgo.getDigestSize()];
        this.hashAlgo.update(bArr, 0, bArr.length);
        this.hashAlgo.doFinal(bArr3, 0);
        int m = this.key.getParameters().getM();
        int n = this.key.getParameters().getN();
        RainbowPublicMap rainbowPublicMap = new RainbowPublicMap(this.key.getParameters());
        short[] sArrMakeMessageRepresentative = makeMessageRepresentative(RainbowUtil.hash(this.hashAlgo, bArr3, Arrays.copyOfRange(bArr2, n, bArr2.length), new byte[m]));
        short[] sArrConvertArray = RainbowUtil.convertArray(Arrays.copyOfRange(bArr2, 0, n));
        int i = AnonymousClass1.$SwitchMap$org$bouncycastle$pqc$crypto$rainbow$Version[this.version.ordinal()];
        if (i == 1) {
            sArrPublicMap = rainbowPublicMap.publicMap((RainbowPublicKeyParameters) this.key, sArrConvertArray);
        } else {
            if (i != 2 && i != 3) {
                throw new IllegalArgumentException("No valid version. Please choose one of the following: classic, circumzenithal, compressed");
            }
            sArrPublicMap = rainbowPublicMap.publicMap_cyclic((RainbowPublicKeyParameters) this.key, sArrConvertArray);
        }
        return RainbowUtil.equals(sArrMakeMessageRepresentative, sArrPublicMap);
    }
}
