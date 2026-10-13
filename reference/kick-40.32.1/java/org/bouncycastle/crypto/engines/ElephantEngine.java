package org.bouncycastle.crypto.engines;

import androidx.media3.muxer.WebmConstants;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.Arrays;
import kotlin.io.encoding.Base64;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.bouncycastle.util.Bytes;

/* JADX INFO: loaded from: classes10.dex */
public class ElephantEngine extends AEADBaseEngine {
    private byte[] ad;
    private int adOff;
    private int adlen;
    private final byte[] buffer;
    private byte[] current_mask;
    private byte[] expanded_key;
    private final Permutation instance;
    private int nb_its;
    private byte[] next_mask;
    private byte[] npub;
    private byte[] previous_mask;
    private final byte[] previous_outputMessage;
    private final byte[] tag_buffer;

    /* JADX INFO: renamed from: org.bouncycastle.crypto.engines.ElephantEngine$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$bouncycastle$crypto$engines$ElephantEngine$ElephantParameters;

        static {
            int[] iArr = new int[ElephantParameters.values().length];
            $SwitchMap$org$bouncycastle$crypto$engines$ElephantEngine$ElephantParameters = iArr;
            try {
                iArr[ElephantParameters.elephant160.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$bouncycastle$crypto$engines$ElephantEngine$ElephantParameters[ElephantParameters.elephant176.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$bouncycastle$crypto$engines$ElephantEngine$ElephantParameters[ElephantParameters.elephant200.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private class Delirium implements Permutation {
        private static final int nRounds = 18;
        private final int[] KeccakRhoOffsets;
        private final byte[] KeccakRoundConstants;

        private Delirium() {
            this.KeccakRoundConstants = new byte[]{1, -126, -118, 0, -117, 1, -127, 9, -118, -120, 9, 10, -117, -117, -119, 3, 2, -128};
            this.KeccakRhoOffsets = new int[]{0, 1, 6, 4, 3, 4, 4, 6, 7, 4, 3, 2, 3, 1, 7, 1, 5, 7, 5, 0, 2, 2, 5, 0, 6};
        }

        /* synthetic */ Delirium(ElephantEngine elephantEngine, AnonymousClass1 anonymousClass1) {
            this();
        }

        private void KeccakP200Round(byte[] bArr, int i) {
            byte[] bArr2 = new byte[25];
            for (int i2 = 0; i2 < 5; i2++) {
                for (int i3 = 0; i3 < 5; i3++) {
                    bArr2[i2] = (byte) (bArr2[i2] ^ bArr[index(i2, i3)]);
                }
            }
            int i4 = 0;
            while (i4 < 5) {
                int i5 = i4 + 1;
                bArr2[i4 + 5] = (byte) (bArr2[(i4 + 4) % 5] ^ ROL8(bArr2[i5 % 5], 1));
                i4 = i5;
            }
            for (int i6 = 0; i6 < 5; i6++) {
                for (int i7 = 0; i7 < 5; i7++) {
                    int iIndex = index(i6, i7);
                    bArr[iIndex] = (byte) (bArr[iIndex] ^ bArr2[i6 + 5]);
                }
            }
            for (int i8 = 0; i8 < 5; i8++) {
                for (int i9 = 0; i9 < 5; i9++) {
                    bArr2[index(i8, i9)] = ROL8(bArr[index(i8, i9)], this.KeccakRhoOffsets[index(i8, i9)]);
                }
            }
            for (int i10 = 0; i10 < 5; i10++) {
                for (int i11 = 0; i11 < 5; i11++) {
                    bArr[index(i11, ((i10 * 2) + (i11 * 3)) % 5)] = bArr2[index(i10, i11)];
                }
            }
            for (int i12 = 0; i12 < 5; i12++) {
                int i13 = 0;
                while (i13 < 5) {
                    int i14 = i13 + 1;
                    bArr2[i13] = (byte) (bArr[index(i13, i12)] ^ ((~bArr[index(i14 % 5, i12)]) & bArr[index((i13 + 2) % 5, i12)]));
                    i13 = i14;
                }
                for (int i15 = 0; i15 < 5; i15++) {
                    bArr[index(i15, i12)] = bArr2[i15];
                }
            }
            bArr[0] = (byte) (this.KeccakRoundConstants[i] ^ bArr[0]);
        }

        private byte ROL8(byte b, int i) {
            return (byte) ((b << i) | ((b & 255) >>> (8 - i)));
        }

        private int index(int i, int i2) {
            return i + (i2 * 5);
        }

        @Override // org.bouncycastle.crypto.engines.ElephantEngine.Permutation
        public void lfsr_step() {
            byte[] bArr = ElephantEngine.this.next_mask;
            int i = ElephantEngine.this.BlockSize - 1;
            ElephantEngine elephantEngine = ElephantEngine.this;
            byte bRotl = elephantEngine.rotl(elephantEngine.current_mask[0]);
            ElephantEngine elephantEngine2 = ElephantEngine.this;
            bArr[i] = (byte) ((ElephantEngine.this.current_mask[13] << 1) ^ (bRotl ^ elephantEngine2.rotl(elephantEngine2.current_mask[2])));
        }

        @Override // org.bouncycastle.crypto.engines.ElephantEngine.Permutation
        public void permutation(byte[] bArr) {
            for (int i = 0; i < 18; i++) {
                KeccakP200Round(bArr, i);
            }
        }
    }

    private class Dumbo extends Spongent {
        public Dumbo() {
            super(WebmConstants.MkvEbmlElement.BLOCK_GROUP, 20, 80, (byte) 117);
        }

        @Override // org.bouncycastle.crypto.engines.ElephantEngine.Permutation
        public void lfsr_step() {
            ElephantEngine.this.next_mask[ElephantEngine.this.BlockSize - 1] = (byte) (((ElephantEngine.this.current_mask[13] & 255) >>> 7) ^ ((((ElephantEngine.this.current_mask[0] & 255) << 3) | ((ElephantEngine.this.current_mask[0] & 255) >>> 5)) ^ ((ElephantEngine.this.current_mask[3] & 255) << 7)));
        }
    }

    public enum ElephantParameters {
        elephant160,
        elephant176,
        elephant200
    }

    private class Jumbo extends Spongent {
        public Jumbo() {
            super(WebmConstants.MkvEbmlElement.PIXEL_WIDTH, 22, 90, (byte) 69);
        }

        @Override // org.bouncycastle.crypto.engines.ElephantEngine.Permutation
        public void lfsr_step() {
            byte[] bArr = ElephantEngine.this.next_mask;
            int i = ElephantEngine.this.BlockSize - 1;
            ElephantEngine elephantEngine = ElephantEngine.this;
            bArr[i] = (byte) (((ElephantEngine.this.current_mask[19] & 255) >>> 7) ^ (elephantEngine.rotl(elephantEngine.current_mask[0]) ^ ((ElephantEngine.this.current_mask[3] & 255) << 7)));
        }
    }

    private interface Permutation {
        void lfsr_step();

        void permutation(byte[] bArr);
    }

    private static abstract class Spongent implements Permutation {
        private final byte lfsrIV;
        private final int nBits;
        private final int nRounds;
        private final int nSBox;
        private final byte[] sBoxLayer = {-18, -19, -21, -32, -30, -31, -28, -17, -25, -22, -24, -27, -23, -20, -29, -26, -34, -35, -37, -48, -46, -47, -44, -33, -41, -38, -40, -43, -39, -36, -45, -42, -66, -67, -69, -80, -78, -79, -76, -65, -73, -70, -72, -75, -71, PSSSigner.TRAILER_IMPLICIT, -77, -74, Ascii.SO, Ascii.CR, Ascii.VT, 0, 2, 1, 4, Ascii.SI, 7, 10, 8, 5, 9, Ascii.FF, 3, 6, 46, 45, 43, 32, 34, 33, 36, 47, 39, 42, 40, 37, 41, 44, 35, 38, Ascii.RS, Ascii.GS, Ascii.ESC, Ascii.DLE, Ascii.DC2, 17, Ascii.DC4, Ascii.US, Ascii.ETB, Ascii.SUB, Ascii.CAN, Ascii.NAK, Ascii.EM, Ascii.FS, 19, Ascii.SYN, 78, 77, 75, SignedBytes.MAX_POWER_OF_TWO, 66, 65, 68, 79, 71, 74, 72, 69, 73, 76, 67, 70, -2, -3, -5, -16, -14, -15, -12, -1, -9, -6, -8, -11, -7, -4, -13, -10, 126, 125, 123, 112, 114, 113, 116, 127, 119, 122, 120, 117, 121, 124, 115, 118, -82, -83, -85, -96, -94, -95, -92, -81, -89, -86, -88, -91, -87, -84, -93, -90, -114, -115, -117, -128, -126, -127, -124, -113, -121, -118, -120, -123, -119, -116, -125, -122, 94, 93, 91, 80, 82, 81, 84, 95, 87, 90, 88, 85, 89, 92, 83, 86, -98, -99, -101, -112, -110, -111, -108, -97, -105, -102, -104, -107, -103, -100, -109, -106, -50, -51, -53, -64, -62, -63, -60, -49, -57, -54, -56, -59, -55, -52, -61, -58, 62, Base64.padSymbol, 59, 48, 50, 49, 52, 63, 55, 58, 56, 53, 57, 60, 51, 54, 110, 109, 107, 96, 98, 97, 100, 111, 103, 106, 104, 101, 105, 108, 99, 102};

        public Spongent(int i, int i2, int i3, byte b) {
            this.nRounds = i3;
            this.nSBox = i2;
            this.lfsrIV = b;
            this.nBits = i;
        }

        @Override // org.bouncycastle.crypto.engines.ElephantEngine.Permutation
        public void permutation(byte[] bArr) {
            int i;
            byte b = this.lfsrIV;
            byte[] bArr2 = new byte[this.nSBox];
            for (int i2 = 0; i2 < this.nRounds; i2++) {
                bArr[0] = (byte) (bArr[0] ^ b);
                int i3 = this.nSBox - 1;
                byte b2 = bArr[i3];
                int i4 = b & 32;
                int i5 = ((b & 1) << 7) | ((b & 2) << 5) | ((b & 4) << 3) | ((b & 8) << 1) | ((b & Ascii.DLE) >>> 1) | (i4 >>> 3);
                int i6 = b & SignedBytes.MAX_POWER_OF_TWO;
                bArr[i3] = (byte) (b2 ^ ((byte) ((i5 | (i6 >>> 5)) | ((b & 128) >>> 7))));
                b = (byte) (((b << 1) | ((i6 >>> 6) ^ (i4 >>> 5))) & 127);
                for (int i7 = 0; i7 < this.nSBox; i7++) {
                    bArr[i7] = this.sBoxLayer[bArr[i7] & 255];
                }
                Arrays.fill(bArr2, (byte) 0);
                int i8 = 0;
                while (true) {
                    i = this.nSBox;
                    if (i8 < i) {
                        for (int i9 = 0; i9 < 8; i9++) {
                            int i10 = (i8 << 3) + i9;
                            int i11 = this.nBits;
                            if (i10 != i11 - 1) {
                                i10 = ((i10 * i11) >> 2) % (i11 - 1);
                            }
                            int i12 = i10 >>> 3;
                            bArr2[i12] = (byte) (((((bArr[i8] & 255) >>> i9) & 1) << (i10 & 7)) ^ bArr2[i12]);
                        }
                        i8++;
                    }
                }
                System.arraycopy(bArr2, 0, bArr, 0, i);
            }
        }
    }

    public ElephantEngine(ElephantParameters elephantParameters) {
        this.KEY_SIZE = 16;
        this.IV_SIZE = 12;
        int i = AnonymousClass1.$SwitchMap$org$bouncycastle$crypto$engines$ElephantEngine$ElephantParameters[elephantParameters.ordinal()];
        if (i == 1) {
            this.BlockSize = 20;
            this.instance = new Dumbo();
            this.MAC_SIZE = 8;
            this.algorithmName = "Elephant 160 AEAD";
        } else if (i == 2) {
            this.BlockSize = 22;
            this.instance = new Jumbo();
            this.algorithmName = "Elephant 176 AEAD";
            this.MAC_SIZE = 8;
        } else {
            if (i != 3) {
                throw new IllegalArgumentException("Invalid parameter settings for Elephant");
            }
            this.BlockSize = 25;
            this.instance = new Delirium(this, null);
            this.algorithmName = "Elephant 200 AEAD";
            this.MAC_SIZE = 16;
        }
        this.tag_buffer = new byte[this.BlockSize];
        this.previous_mask = new byte[this.BlockSize];
        this.current_mask = new byte[this.BlockSize];
        this.next_mask = new byte[this.BlockSize];
        this.buffer = new byte[this.BlockSize];
        this.previous_outputMessage = new byte[this.BlockSize];
        setInnerMembers(AEADBaseEngine.ProcessingBufferType.Immediate, AEADBaseEngine.AADOperatorType.Stream, AEADBaseEngine.DataOperatorType.Counter);
    }

    private void absorbAAD() {
        processAADBytes(this.buffer);
        Bytes.xorTo(this.BlockSize, this.next_mask, this.buffer);
        this.instance.permutation(this.buffer);
        Bytes.xorTo(this.BlockSize, this.next_mask, this.buffer);
        Bytes.xorTo(this.BlockSize, this.buffer, this.tag_buffer);
    }

    private void absorbCiphertext() {
        xorTo(this.BlockSize, this.previous_mask, this.next_mask, this.buffer);
        this.instance.permutation(this.buffer);
        xorTo(this.BlockSize, this.previous_mask, this.next_mask, this.buffer);
        Bytes.xorTo(this.BlockSize, this.buffer, this.tag_buffer);
    }

    private void computeCipherBlock(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        System.arraycopy(this.npub, 0, this.buffer, 0, this.IV_SIZE);
        Arrays.fill(this.buffer, this.IV_SIZE, this.BlockSize, (byte) 0);
        xorTo(this.BlockSize, this.current_mask, this.next_mask, this.buffer);
        this.instance.permutation(this.buffer);
        xorTo(this.BlockSize, this.current_mask, this.next_mask, this.buffer);
        Bytes.xorTo(i2, bArr, i, this.buffer);
        System.arraycopy(this.buffer, 0, bArr2, i3, i2);
    }

    private void lfsr_step() {
        this.instance.lfsr_step();
        System.arraycopy(this.current_mask, 1, this.next_mask, 0, this.BlockSize - 1);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0027  */
    /* JADX WARN: Code duplicated, block: B:12:0x002d  */
    /* JADX WARN: Code duplicated, block: B:19:0x0057  */
    /* JADX WARN: Code duplicated, block: B:21:0x0062 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:22:0x0064  */
    /* JADX WARN: Code duplicated, block: B:25:0x007b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:26:0x007d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:27:0x007e  */
    /* JADX WARN: Code duplicated, block: B:29:0x0083  */
    private void processAADBytes(byte[] bArr) {
        int i;
        AEADBaseEngine.State state;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6 = this.m_state.ord;
        if (i6 != 1) {
            if (i6 == 2) {
                if (this.adOff == this.adlen) {
                    Arrays.fill(bArr, 0, this.BlockSize, (byte) 0);
                    bArr[0] = 1;
                    return;
                }
            } else if (i6 == 5) {
                System.arraycopy(this.expanded_key, 0, this.current_mask, 0, this.BlockSize);
                System.arraycopy(this.npub, 0, bArr, 0, this.IV_SIZE);
                i = this.IV_SIZE;
                state = AEADBaseEngine.State.DecAad;
            } else if (i6 == 6) {
                if (this.adOff == this.adlen) {
                    Arrays.fill(bArr, 0, this.BlockSize, (byte) 0);
                    bArr[0] = 1;
                    return;
                }
            }
            i = 0;
            i2 = this.BlockSize - i;
            int i7 = this.adlen;
            i3 = this.adOff;
            i4 = i7 - i3;
            if (i2 <= i4) {
                System.arraycopy(this.ad, i3, bArr, i, i2);
                this.adOff += i2;
                return;
            }
            if (i4 > 0) {
                System.arraycopy(this.ad, i3, bArr, i, i4);
                this.adOff += i4;
            }
            int i8 = i4 + i;
            Arrays.fill(bArr, i8, i + i2, (byte) 0);
            bArr[i8] = 1;
            i5 = this.m_state.ord;
            if (i5 != 2) {
                this.m_state = AEADBaseEngine.State.EncData;
            } else {
                if (i5 != 6) {
                    return;
                }
                this.m_state = AEADBaseEngine.State.DecData;
            }
        }
        System.arraycopy(this.expanded_key, 0, this.current_mask, 0, this.BlockSize);
        System.arraycopy(this.npub, 0, bArr, 0, this.IV_SIZE);
        i = this.IV_SIZE;
        state = AEADBaseEngine.State.EncAad;
        this.m_state = state;
        i2 = this.BlockSize - i;
        int i9 = this.adlen;
        i3 = this.adOff;
        i4 = i9 - i3;
        if (i2 <= i4) {
            System.arraycopy(this.ad, i3, bArr, i, i2);
            this.adOff += i2;
            return;
        }
        if (i4 > 0) {
            System.arraycopy(this.ad, i3, bArr, i, i4);
            this.adOff += i4;
        }
        int i10 = i4 + i;
        Arrays.fill(bArr, i10, i + i2, (byte) 0);
        bArr[i10] = 1;
        i5 = this.m_state.ord;
        if (i5 != 2) {
            this.m_state = AEADBaseEngine.State.EncData;
        } else {
            if (i5 != 6) {
                return;
            }
            this.m_state = AEADBaseEngine.State.DecData;
        }
    }

    private void processBuffer(byte[] bArr, int i, byte[] bArr2, int i2, AEADBaseEngine.State state) {
        if (this.m_state == AEADBaseEngine.State.DecInit || this.m_state == AEADBaseEngine.State.EncInit) {
            processFinalAAD();
        }
        lfsr_step();
        computeCipherBlock(bArr, i, this.BlockSize, bArr2, i2);
        if (this.nb_its > 0) {
            System.arraycopy(this.previous_outputMessage, 0, this.buffer, 0, this.BlockSize);
            absorbCiphertext();
        }
        if (this.m_state != state) {
            absorbAAD();
        }
        swapMasks();
        this.nb_its++;
    }

    private void processBytes(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, int i5, int i6) {
        byte[] bArr3 = new byte[this.BlockSize];
        int i7 = this.nb_its;
        int i8 = i;
        int i9 = 0;
        while (i7 < i2) {
            int i10 = i7 == i3 + (-1) ? i5 - (this.BlockSize * i7) : this.BlockSize;
            lfsr_step();
            if (i7 < i3) {
                computeCipherBlock(bArr, i9, i10, bArr2, i8);
                if (this.forEncryption) {
                    System.arraycopy(this.buffer, 0, bArr3, 0, i10);
                } else {
                    System.arraycopy(bArr, i9, bArr3, 0, i10);
                }
                i8 += i10;
                i9 += i10;
            }
            if (i7 > 0 && i7 <= i4) {
                int i11 = (i7 - 1) * this.BlockSize;
                if (i11 == i5) {
                    Arrays.fill(this.buffer, 1, this.BlockSize, (byte) 0);
                    this.buffer[0] = 1;
                } else {
                    int i12 = i5 - i11;
                    if (this.BlockSize <= i12) {
                        System.arraycopy(this.previous_outputMessage, 0, this.buffer, 0, this.BlockSize);
                    } else if (i12 > 0) {
                        System.arraycopy(this.previous_outputMessage, 0, this.buffer, 0, i12);
                        Arrays.fill(this.buffer, i12, this.BlockSize, (byte) 0);
                        this.buffer[i12] = 1;
                    }
                }
                absorbCiphertext();
            }
            i7++;
            if (i7 < i6) {
                absorbAAD();
            }
            swapMasks();
            System.arraycopy(bArr3, 0, this.previous_outputMessage, 0, this.BlockSize);
        }
        this.nb_its = i7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte rotl(byte b) {
        return (byte) ((b << 1) | ((b & 255) >>> 7));
    }

    private void swapMasks() {
        byte[] bArr = this.previous_mask;
        this.previous_mask = this.current_mask;
        this.current_mask = this.next_mask;
        this.next_mask = bArr;
    }

    public static void xorTo(int i, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        for (int i2 = 0; i2 < i; i2++) {
            bArr3[i2] = (byte) (bArr3[i2] ^ (bArr[i2] ^ bArr2[i2]));
        }
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    protected void checkAAD() {
        int i = this.m_state.ord;
        if (i == 3) {
            throw new IllegalArgumentException(this.algorithmName + " cannot process AAD when the length of the ciphertext to be processed exceeds the a block size");
        }
        if (i == 4) {
            throw new IllegalArgumentException(this.algorithmName + " cannot be reused for encryption");
        }
        if (i != 7) {
            return;
        }
        throw new IllegalArgumentException(this.algorithmName + " cannot process AAD when the length of the plaintext to be processed exceeds the a block size");
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    protected boolean checkData(boolean z) {
        switch (this.m_state.ord) {
            case 1:
            case 2:
            case 3:
                return true;
            case 4:
                throw new IllegalStateException(getAlgorithmName() + " cannot be reused for encryption");
            case 5:
            case 6:
            case 7:
                return false;
            default:
                throw new IllegalStateException(getAlgorithmName() + " needs to be initialized");
        }
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
    public int getOutputSize(int i) {
        int i2 = this.m_state.ord;
        if (i2 == 0) {
            throw new IllegalArgumentException(this.algorithmName + " needs call init function before getUpdateOutputSize");
        }
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            return i + this.m_bufPos + this.MAC_SIZE;
        }
        if (i2 == 4 || i2 == 8) {
            return 0;
        }
        return Math.max(0, (i + this.m_bufPos) - this.MAC_SIZE);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public int getUpdateOutputSize(int i) {
        switch (this.m_state.ord) {
            case 0:
                throw new IllegalArgumentException(this.algorithmName + " needs call init function before getUpdateOutputSize");
            case 1:
            case 2:
            case 3:
                int i2 = this.m_bufPos + i;
                return i2 - (i2 % this.BlockSize);
            case 4:
            case 8:
                return 0;
            case 5:
            case 6:
            case 7:
                int iMax = Math.max(0, (this.m_bufPos + i) - this.MAC_SIZE);
                return iMax - (iMax % this.BlockSize);
            default:
                return Math.max(0, (i + this.m_bufPos) - this.MAC_SIZE);
        }
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ void init(boolean z, CipherParameters cipherParameters) {
        super.init(z, cipherParameters);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    protected void init(byte[] bArr, byte[] bArr2) throws IllegalArgumentException {
        this.npub = bArr2;
        byte[] bArr3 = new byte[this.BlockSize];
        this.expanded_key = bArr3;
        System.arraycopy(bArr, 0, bArr3, 0, this.KEY_SIZE);
        this.instance.permutation(this.expanded_key);
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
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    protected void processBufferDecrypt(byte[] bArr, int i, byte[] bArr2, int i2) {
        processBuffer(bArr, i, bArr2, i2, AEADBaseEngine.State.DecData);
        System.arraycopy(bArr, i, this.previous_outputMessage, 0, this.BlockSize);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    protected void processBufferEncrypt(byte[] bArr, int i, byte[] bArr2, int i2) {
        processBuffer(bArr, i, bArr2, i2, AEADBaseEngine.State.EncData);
        System.arraycopy(bArr2, i2, this.previous_outputMessage, 0, this.BlockSize);
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
        if (this.adOff == -1) {
            this.ad = ((AEADBaseEngine.StreamAADOperator) this.aadOperator).getBytes();
            this.adOff = 0;
            this.adlen = this.aadOperator.getLen();
            this.aadOperator.reset();
        }
        int i = this.m_state.ord;
        if (i == 1 || i == 5) {
            processAADBytes(this.tag_buffer);
        }
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    protected void processFinalBlock(byte[] bArr, int i) {
        int len = this.dataOperator.getLen() - (this.forEncryption ? 0 : this.MAC_SIZE);
        processFinalAAD();
        int i2 = len / this.BlockSize;
        int i3 = i2 + 1;
        int i4 = len % this.BlockSize != 0 ? i3 : i2;
        int i5 = (this.IV_SIZE + this.adlen) / this.BlockSize;
        processBytes(this.m_buf, bArr, i, Math.max(i2 + 2, i5), i4, i3, len, i5 + 1);
        Bytes.xorTo(this.BlockSize, this.expanded_key, this.tag_buffer);
        this.instance.permutation(this.tag_buffer);
        Bytes.xorTo(this.BlockSize, this.expanded_key, this.tag_buffer);
        System.arraycopy(this.tag_buffer, 0, this.mac, 0, this.MAC_SIZE);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ void reset() {
        super.reset();
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    protected void reset(boolean z) {
        super.reset(z);
        Arrays.fill(this.tag_buffer, (byte) 0);
        Arrays.fill(this.previous_outputMessage, (byte) 0);
        this.nb_its = 0;
        this.adOff = -1;
    }
}
