package org.bouncycastle.crypto.engines;

import com.facebook.imageutils.JfifUtil;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.digests.XoodyakDigest;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Bytes;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes10.dex */
public class XoodyakEngine extends AEADBaseEngine {
    private static final int ModeHash = 1;
    private static final int ModeKeyed = 0;
    private static final int PhaseDown = 1;
    private static final int PhaseUp = 2;
    private static final int[] RC = {88, 56, 960, JfifUtil.MARKER_RST0, 288, 20, 96, 44, 896, 240, 416, 18};
    private static final int f_bPrime_1 = 47;
    private byte[] K;
    private byte aadcd;
    private boolean encrypted;
    private byte[] iv;
    private int mode;
    private int phase;
    private final byte[] state;

    public XoodyakEngine() {
        this.algorithmName = "Xoodyak AEAD";
        this.MAC_SIZE = 16;
        this.IV_SIZE = 16;
        this.KEY_SIZE = 16;
        this.BlockSize = 24;
        this.AADBufferSize = 44;
        this.state = new byte[48];
        setInnerMembers(AEADBaseEngine.ProcessingBufferType.Immediate, AEADBaseEngine.AADOperatorType.Default, AEADBaseEngine.DataOperatorType.Counter);
    }

    private void AbsorbAny(byte[] bArr, int i, int i2, int i3) {
        if (this.phase != 2) {
            up(this.mode, this.state, 0);
        }
        int i4 = i;
        int i5 = i3;
        while (true) {
            int iMin = Math.min(i2, this.AADBufferSize);
            byte[] bArr2 = bArr;
            down(this.mode, this.state, bArr2, i4, iMin, i5);
            this.phase = 1;
            i4 += iMin;
            i2 -= iMin;
            if (i2 == 0) {
                return;
            }
            i5 = 0;
            bArr = bArr2;
        }
    }

    private static void down(int i, byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        Bytes.xorTo(i3, bArr2, i2, bArr);
        bArr[i3] = (byte) (bArr[i3] ^ 1);
        int i5 = bArr[47];
        if (i == 1) {
            i4 &= 1;
        }
        bArr[47] = (byte) (i5 ^ i4);
    }

    public static void down(XoodyakDigest.Friend friend, int i, byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        if (friend == null) {
            throw new NullPointerException("This method is only for use by XoodyakDigest");
        }
        down(i, bArr, bArr2, i2, i3, i4);
    }

    private static void up(int i, byte[] bArr, int i2) {
        if (i != 1) {
            bArr[47] = (byte) (bArr[47] ^ i2);
        }
        int iLittleEndianToInt = Pack.littleEndianToInt(bArr, 0);
        int iLittleEndianToInt2 = Pack.littleEndianToInt(bArr, 4);
        int iLittleEndianToInt3 = Pack.littleEndianToInt(bArr, 8);
        int i3 = 12;
        int iLittleEndianToInt4 = Pack.littleEndianToInt(bArr, 12);
        int iLittleEndianToInt5 = Pack.littleEndianToInt(bArr, 16);
        int iLittleEndianToInt6 = Pack.littleEndianToInt(bArr, 20);
        int iLittleEndianToInt7 = Pack.littleEndianToInt(bArr, 24);
        int iLittleEndianToInt8 = Pack.littleEndianToInt(bArr, 28);
        int iLittleEndianToInt9 = Pack.littleEndianToInt(bArr, 32);
        int i4 = 0;
        int i5 = iLittleEndianToInt8;
        int iRotateLeft = iLittleEndianToInt9;
        int iLittleEndianToInt10 = Pack.littleEndianToInt(bArr, 36);
        int iLittleEndianToInt11 = Pack.littleEndianToInt(bArr, 40);
        int iLittleEndianToInt12 = Pack.littleEndianToInt(bArr, 44);
        while (i4 < i3) {
            int i6 = (iLittleEndianToInt ^ iLittleEndianToInt5) ^ iRotateLeft;
            int i7 = (iLittleEndianToInt2 ^ iLittleEndianToInt6) ^ iLittleEndianToInt10;
            int i8 = i4;
            int i9 = (iLittleEndianToInt3 ^ iLittleEndianToInt7) ^ iLittleEndianToInt11;
            int i10 = iLittleEndianToInt12;
            int i11 = (iLittleEndianToInt4 ^ i5) ^ i10;
            int i12 = iLittleEndianToInt11;
            int iRotateLeft2 = Integers.rotateLeft(i11, 5) ^ Integers.rotateLeft(i11, 14);
            int iRotateLeft3 = Integers.rotateLeft(i6, 5) ^ Integers.rotateLeft(i6, 14);
            int iRotateLeft4 = Integers.rotateLeft(i7, 5) ^ Integers.rotateLeft(i7, 14);
            int iRotateLeft5 = Integers.rotateLeft(i9, 5) ^ Integers.rotateLeft(i9, 14);
            int i13 = iLittleEndianToInt ^ iRotateLeft2;
            int i14 = iLittleEndianToInt5 ^ iRotateLeft2;
            int i15 = iRotateLeft ^ iRotateLeft2;
            int i16 = iLittleEndianToInt2 ^ iRotateLeft3;
            int i17 = iLittleEndianToInt6 ^ iRotateLeft3;
            int i18 = iRotateLeft3 ^ iLittleEndianToInt10;
            int i19 = iLittleEndianToInt3 ^ iRotateLeft4;
            int i20 = iLittleEndianToInt7 ^ iRotateLeft4;
            int i21 = iLittleEndianToInt4 ^ iRotateLeft5;
            int i22 = i5 ^ iRotateLeft5;
            int iRotateLeft6 = Integers.rotateLeft(i15, 11);
            int iRotateLeft7 = Integers.rotateLeft(i18, 11);
            int iRotateLeft8 = Integers.rotateLeft(i12 ^ iRotateLeft4, 11);
            int iRotateLeft9 = Integers.rotateLeft(i10 ^ iRotateLeft5, 11);
            int i23 = i13 ^ RC[i8];
            int i24 = ((~i22) & iRotateLeft6) ^ i23;
            int i25 = ((~i14) & iRotateLeft7) ^ i16;
            int i26 = ((~i17) & iRotateLeft8) ^ i19;
            int i27 = ((~i20) & iRotateLeft9) ^ i21;
            int i28 = ((~iRotateLeft6) & i23) ^ i22;
            int i29 = i14 ^ ((~iRotateLeft7) & i16);
            int i30 = ((~iRotateLeft8) & i19) ^ i17;
            int i31 = ((~iRotateLeft9) & i21) ^ i20;
            int i32 = iRotateLeft6 ^ ((~i23) & i22);
            int i33 = iRotateLeft7 ^ ((~i16) & i14);
            int i34 = iRotateLeft8 ^ ((~i19) & i17);
            int i35 = iRotateLeft9 ^ ((~i21) & i20);
            iLittleEndianToInt5 = Integers.rotateLeft(i28, 1);
            int iRotateLeft10 = Integers.rotateLeft(i29, 1);
            int iRotateLeft11 = Integers.rotateLeft(i30, 1);
            int iRotateLeft12 = Integers.rotateLeft(i31, 1);
            iRotateLeft = Integers.rotateLeft(i34, 8);
            iLittleEndianToInt10 = Integers.rotateLeft(i35, 8);
            iLittleEndianToInt11 = Integers.rotateLeft(i32, 8);
            iLittleEndianToInt12 = Integers.rotateLeft(i33, 8);
            iLittleEndianToInt = i24;
            iLittleEndianToInt6 = iRotateLeft10;
            iLittleEndianToInt3 = i26;
            i3 = 12;
            iLittleEndianToInt7 = iRotateLeft11;
            i4 = i8 + 1;
            iLittleEndianToInt2 = i25;
            i5 = iRotateLeft12;
            iLittleEndianToInt4 = i27;
        }
        Pack.intToLittleEndian(iLittleEndianToInt, bArr, 0);
        Pack.intToLittleEndian(iLittleEndianToInt2, bArr, 4);
        Pack.intToLittleEndian(iLittleEndianToInt3, bArr, 8);
        Pack.intToLittleEndian(iLittleEndianToInt4, bArr, 12);
        Pack.intToLittleEndian(iLittleEndianToInt5, bArr, 16);
        Pack.intToLittleEndian(iLittleEndianToInt6, bArr, 20);
        Pack.intToLittleEndian(iLittleEndianToInt7, bArr, 24);
        Pack.intToLittleEndian(i5, bArr, 28);
        Pack.intToLittleEndian(iRotateLeft, bArr, 32);
        Pack.intToLittleEndian(iLittleEndianToInt10, bArr, 36);
        Pack.intToLittleEndian(iLittleEndianToInt11, bArr, 40);
        Pack.intToLittleEndian(iLittleEndianToInt12, bArr, 44);
    }

    public static void up(XoodyakDigest.Friend friend, int i, byte[] bArr, int i2) {
        if (friend == null) {
            throw new NullPointerException("This method is only for use by XoodyakDigest");
        }
        up(i, bArr, i2);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ int doFinal(byte[] bArr, int i) throws InvalidCipherTextException, IllegalStateException {
        return super.doFinal(bArr, i);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    protected void finishAAD(AEADBaseEngine.State state, boolean z) {
        finishAAD3(state, z);
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
        this.K = bArr;
        this.iv = bArr2;
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
        AbsorbAny(bArr, i, this.AADBufferSize, this.aadcd);
        this.aadcd = (byte) 0;
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    protected void processBufferDecrypt(byte[] bArr, int i, byte[] bArr2, int i2) {
        up(this.mode, this.state, this.encrypted ? 0 : 128);
        Bytes.xor(this.BlockSize, this.state, bArr, i, bArr2, i2);
        down(this.mode, this.state, bArr2, i2, this.BlockSize, 0);
        this.phase = 1;
        this.encrypted = true;
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    protected void processBufferEncrypt(byte[] bArr, int i, byte[] bArr2, int i2) {
        up(this.mode, this.state, this.encrypted ? 0 : 128);
        Bytes.xor(this.BlockSize, this.state, bArr, i, bArr2, i2);
        down(this.mode, this.state, bArr, i, this.BlockSize, 0);
        this.phase = 1;
        this.encrypted = true;
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
        AbsorbAny(this.m_aad, 0, this.m_aadPos, this.aadcd);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    protected void processFinalBlock(byte[] bArr, int i) {
        if (this.m_bufPos != 0 || !this.encrypted) {
            up(this.mode, this.state, this.encrypted ? 0 : 128);
            Bytes.xor(this.m_bufPos, this.state, this.m_buf, 0, bArr, i);
            boolean z = this.forEncryption;
            int i2 = this.mode;
            if (z) {
                down(i2, this.state, this.m_buf, 0, this.m_bufPos, 0);
            } else {
                down(i2, this.state, bArr, i, this.m_bufPos, 0);
            }
            this.phase = 1;
        }
        up(this.mode, this.state, 64);
        System.arraycopy(this.state, 0, this.mac, 0, this.MAC_SIZE);
        this.phase = 2;
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ void reset() {
        super.reset();
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    protected void reset(boolean z) {
        super.reset(z);
        Arrays.fill(this.state, (byte) 0);
        this.encrypted = false;
        this.phase = 2;
        this.aadcd = (byte) 3;
        int length = this.K.length;
        int length2 = this.iv.length;
        byte[] bArr = new byte[this.AADBufferSize];
        this.mode = 0;
        System.arraycopy(this.K, 0, bArr, 0, length);
        System.arraycopy(this.iv, 0, bArr, length, length2);
        int i = length + length2;
        bArr[i] = (byte) length2;
        AbsorbAny(bArr, 0, i + 1, 2);
    }
}
