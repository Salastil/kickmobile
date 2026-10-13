package org.bouncycastle.crypto.engines;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.lang.reflect.Array;
import kotlin.io.encoding.Base64;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.digests.RomulusDigest;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Bytes;

/* JADX INFO: loaded from: classes10.dex */
public class RomulusEngine extends AEADBaseEngine {
    private static final int AD_BLK_LEN_HALF = 16;
    private final byte[] CNT;
    private Instance instance;
    private byte[] k;
    private byte[] npub;
    private static final byte[] sbox_8 = {101, 76, 106, 66, 75, 99, 67, 107, 85, 117, 90, 122, 83, 115, 91, 123, 53, -116, 58, -127, -119, 51, -128, 59, -107, 37, -104, 42, -112, 35, -103, 43, -27, -52, -24, -63, -55, -32, -64, -23, -43, -11, -40, -8, -48, -16, -39, -7, -91, Ascii.FS, -88, Ascii.DC2, Ascii.ESC, -96, 19, -87, 5, -75, 10, -72, 3, -80, Ascii.VT, -71, 50, -120, 60, -123, -115, 52, -124, Base64.padSymbol, -111, 34, -100, 44, -108, 36, -99, 45, 98, 74, 108, 69, 77, 100, 68, 109, 82, 114, 92, 124, 84, 116, 93, 125, -95, Ascii.SUB, -84, Ascii.NAK, Ascii.GS, -92, Ascii.DC4, -83, 2, -79, Ascii.FF, PSSSigner.TRAILER_IMPLICIT, 4, -76, Ascii.CR, -67, -31, -56, -20, -59, -51, -28, -60, -19, -47, -15, -36, -4, -44, -12, -35, -3, 54, -114, 56, -126, -117, 48, -125, 57, -106, 38, -102, 40, -109, 32, -101, 41, 102, 78, 104, 65, 73, 96, SignedBytes.MAX_POWER_OF_TWO, 105, 86, 118, 88, 120, 80, 112, 89, 121, -90, Ascii.RS, -86, 17, Ascii.EM, -93, Ascii.DLE, -85, 6, -74, 8, -70, 0, -77, 9, -69, -26, -50, -22, -62, -53, -29, -61, -21, -42, -10, -38, -6, -45, -13, -37, -5, 49, -118, 62, -122, -113, 55, -121, 63, -110, 33, -98, 46, -105, 39, -97, 47, 97, 72, 110, 70, 79, 103, 71, 111, 81, 113, 94, 126, 87, 119, 95, 127, -94, Ascii.CAN, -82, Ascii.SYN, Ascii.US, -89, Ascii.ETB, -81, 1, -78, Ascii.SO, -66, 7, -73, Ascii.SI, -65, -30, -54, -18, -58, -49, -25, -57, -17, -46, -14, -34, -2, -41, -9, -33, -1};
    private static final byte[] TWEAKEY_P = {9, Ascii.SI, 8, Ascii.CR, 10, Ascii.SO, Ascii.FF, Ascii.VT, 0, 1, 2, 3, 4, 5, 6, 7};
    private static final byte[] RC = {1, 3, 7, Ascii.SI, Ascii.US, 62, Base64.padSymbol, 59, 55, 47, Ascii.RS, 60, 57, 51, 39, Ascii.SO, Ascii.GS, 58, 53, 43, Ascii.SYN, 44, Ascii.CAN, 48, 33, 2, 5, Ascii.VT, Ascii.ETB, 46, Ascii.FS, 56, 49, 35, 6, Ascii.CR, Ascii.ESC, 54, 45, Ascii.SUB};

    private interface Instance {
        void processBufferAAD(byte[] bArr, int i);

        void processBufferDecrypt(byte[] bArr, int i, byte[] bArr2, int i2);

        void processBufferEncrypt(byte[] bArr, int i, byte[] bArr2, int i2);

        void processFinalAAD();

        void processFinalBlock(byte[] bArr, int i);

        void reset();
    }

    private class RomulusM implements Instance {
        private int offset;
        private final byte[] mac_s = new byte[16];
        private final byte[] mac_CNT = new byte[7];
        private final byte[] s = new byte[16];
        private boolean twist = true;

        public RomulusM() {
        }

        int ad_encryption(byte[] bArr, int i, byte[] bArr2, byte[] bArr3, int i2, byte[] bArr4) {
            byte[] bArr5 = new byte[16];
            byte[] bArr6 = new byte[16];
            int iMin = Math.min(i2, 16);
            int i3 = i2 - iMin;
            RomulusEngine.this.pad(bArr, i, bArr6, 16, iMin);
            Bytes.xorTo(16, bArr6, bArr2);
            int i4 = i + iMin;
            this.offset = i4;
            RomulusEngine.this.lfsr_gf56(bArr4);
            if (i3 == 0) {
                return i3;
            }
            int iMin2 = Math.min(i3, 16);
            int i5 = i3 - iMin2;
            RomulusEngine.this.pad(bArr, i4, bArr5, 16, iMin2);
            this.offset = i4 + iMin2;
            RomulusEngine.this.block_cipher(bArr2, bArr3, bArr5, 0, bArr4, (byte) 44);
            RomulusEngine.this.lfsr_gf56(bArr4);
            return i5;
        }

        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        public void processBufferAAD(byte[] bArr, int i) {
            boolean z = this.twist;
            RomulusEngine romulusEngine = RomulusEngine.this;
            if (z) {
                Bytes.xorTo(romulusEngine.MAC_SIZE, bArr, i, this.mac_s);
            } else {
                romulusEngine.block_cipher(this.mac_s, romulusEngine.k, bArr, i, this.mac_CNT, (byte) 40);
            }
            this.twist = !this.twist;
            RomulusEngine.this.lfsr_gf56(this.mac_CNT);
        }

        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        public void processBufferDecrypt(byte[] bArr, int i, byte[] bArr2, int i2) {
        }

        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        public void processBufferEncrypt(byte[] bArr, int i, byte[] bArr2, int i2) {
        }

        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        public void processFinalAAD() {
            int len = RomulusEngine.this.aadOperator.getLen();
            RomulusEngine romulusEngine = RomulusEngine.this;
            if (len == 0) {
                romulusEngine.lfsr_gf56(this.mac_CNT);
            } else if (romulusEngine.m_aadPos != 0) {
                Arrays.fill(RomulusEngine.this.m_aad, RomulusEngine.this.m_aadPos, RomulusEngine.this.BlockSize - 1, (byte) 0);
                RomulusEngine.this.m_aad[RomulusEngine.this.BlockSize - 1] = (byte) (RomulusEngine.this.m_aadPos & 15);
                boolean z = this.twist;
                RomulusEngine romulusEngine2 = RomulusEngine.this;
                if (z) {
                    Bytes.xorTo(romulusEngine2.BlockSize, RomulusEngine.this.m_aad, this.mac_s);
                } else {
                    romulusEngine2.block_cipher(this.mac_s, romulusEngine2.k, RomulusEngine.this.m_aad, 0, this.mac_CNT, (byte) 40);
                }
                RomulusEngine.this.lfsr_gf56(this.mac_CNT);
            }
            RomulusEngine.this.m_aadPos = 0;
            RomulusEngine romulusEngine3 = RomulusEngine.this;
            romulusEngine3.m_bufPos = romulusEngine3.dataOperator.getLen();
        }

        /* JADX WARN: Code duplicated, block: B:26:0x005f  */
        /* JADX WARN: Code duplicated, block: B:28:0x0063  */
        /* JADX WARN: Code duplicated, block: B:29:0x0095 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:30:0x0097  */
        /* JADX WARN: Code duplicated, block: B:33:0x00a2 A[LOOP:0: B:32:0x00a0->B:33:0x00a2, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:35:0x00dd  */
        /* JADX WARN: Code duplicated, block: B:38:0x00fd  */
        /* JADX WARN: Code duplicated, block: B:41:0x0122 A[LOOP:1: B:39:0x011e->B:41:0x0122, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:43:0x0162  */
        /* JADX WARN: Code duplicated, block: B:46:0x0169  */
        /* JADX WARN: Code duplicated, block: B:48:0x016d  */
        /* JADX WARN: Code duplicated, block: B:49:0x01a1 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:50:0x01a3  */
        /* JADX WARN: Code duplicated, block: B:53:0x01ae A[LOOP:2: B:52:0x01ac->B:53:0x01ae, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:58:0x0158 A[EDGE_INSN: B:58:0x0158->B:42:0x0158 BREAK  A[LOOP:1: B:39:0x011e->B:41:0x0122], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:61:? A[RETURN, SYNTHETIC] */
        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        public void processFinalBlock(byte[] bArr, int i) {
            byte b;
            int i2;
            byte b2;
            int i3;
            int iAd_encryption;
            int i4;
            int i5;
            int i6;
            RomulusEngine romulusEngine;
            int i7;
            int len = RomulusEngine.this.aadOperator.getLen();
            int len2 = RomulusEngine.this.dataOperator.getLen() - (RomulusEngine.this.forEncryption ? 0 : RomulusEngine.this.MAC_SIZE);
            byte[] bytes = ((AEADBaseEngine.StreamDataOperator) RomulusEngine.this.dataOperator).getBytes();
            int i8 = len & 31;
            int i9 = 16;
            if (i8 == 0 && len != 0) {
                b = 56;
            } else if (i8 < 16) {
                b = 50;
            } else {
                b = i8 != 16 ? (byte) 58 : (byte) 48;
            }
            int i10 = len2 & 31;
            if (i10 == 0 && len2 != 0) {
                i2 = b ^ 4;
            } else {
                if (i10 >= 16) {
                    if (i10 != 16) {
                        i2 = b ^ 5;
                    }
                    b2 = b;
                    i3 = 0;
                    if (RomulusEngine.this.forEncryption) {
                        if ((b2 & 8) == 0) {
                            byte[] bArr2 = new byte[16];
                            int iMin = Math.min(len2, 16);
                            RomulusEngine.this.pad(bytes, 0, bArr2, 16, iMin);
                            RomulusEngine romulusEngine2 = RomulusEngine.this;
                            romulusEngine2.block_cipher(this.mac_s, romulusEngine2.k, bArr2, 0, this.mac_CNT, (byte) 44);
                            RomulusEngine.this.lfsr_gf56(this.mac_CNT);
                            iAd_encryption = len2 - iMin;
                            i7 = iMin;
                        } else {
                            if (len2 == 0) {
                                RomulusEngine.this.lfsr_gf56(this.mac_CNT);
                            }
                            iAd_encryption = len2;
                            i7 = 0;
                        }
                        while (iAd_encryption > 0) {
                            this.offset = i7;
                            iAd_encryption = ad_encryption(bytes, i7, this.mac_s, RomulusEngine.this.k, iAd_encryption, this.mac_CNT);
                            i7 = this.offset;
                        }
                        RomulusEngine romulusEngine3 = RomulusEngine.this;
                        romulusEngine3.block_cipher(this.mac_s, romulusEngine3.k, RomulusEngine.this.npub, 0, this.mac_CNT, b2);
                        RomulusEngine romulusEngine4 = RomulusEngine.this;
                        romulusEngine4.g8A(this.mac_s, romulusEngine4.mac, 0);
                        i3 = i7 - len2;
                    } else {
                        System.arraycopy(bytes, len2, RomulusEngine.this.mac, 0, RomulusEngine.this.MAC_SIZE);
                        iAd_encryption = len2;
                    }
                    RomulusEngine romulusEngine5 = RomulusEngine.this;
                    romulusEngine5.reset_lfsr_gf56(romulusEngine5.CNT);
                    System.arraycopy(RomulusEngine.this.mac, 0, this.s, 0, 16);
                    if (len2 > 0) {
                        RomulusEngine romulusEngine6 = RomulusEngine.this;
                        romulusEngine6.block_cipher(this.s, romulusEngine6.k, RomulusEngine.this.npub, 0, RomulusEngine.this.CNT, (byte) 36);
                        i6 = i;
                        while (true) {
                            romulusEngine = RomulusEngine.this;
                            if (len2 > i9) {
                                break;
                            }
                            len2 -= 16;
                            romulusEngine.rho(bytes, i3, bArr, i6, this.s, 16);
                            i6 += 16;
                            i3 += 16;
                            RomulusEngine romulusEngine7 = RomulusEngine.this;
                            romulusEngine7.lfsr_gf56(romulusEngine7.CNT);
                            RomulusEngine romulusEngine8 = RomulusEngine.this;
                            romulusEngine8.block_cipher(this.s, romulusEngine8.k, RomulusEngine.this.npub, 0, RomulusEngine.this.CNT, (byte) 36);
                            i9 = i9;
                        }
                        i4 = i9;
                        romulusEngine.rho(bytes, i3, bArr, i6, this.s, len2);
                    } else {
                        i4 = 16;
                    }
                    if (RomulusEngine.this.forEncryption) {
                    }
                    if ((b2 & 8) == 0) {
                        byte[] bArr3 = new byte[i4];
                        int iMin2 = Math.min(iAd_encryption, i4);
                        iAd_encryption -= iMin2;
                        RomulusEngine.this.pad(bArr, i, bArr3, 16, iMin2);
                        RomulusEngine romulusEngine9 = RomulusEngine.this;
                        romulusEngine9.block_cipher(this.mac_s, romulusEngine9.k, bArr3, 0, this.mac_CNT, (byte) 44);
                        RomulusEngine.this.lfsr_gf56(this.mac_CNT);
                        i5 = i + iMin2;
                    } else {
                        if (len2 == 0) {
                            RomulusEngine.this.lfsr_gf56(this.mac_CNT);
                        }
                        i5 = i;
                    }
                    while (iAd_encryption > 0) {
                        this.offset = i5;
                        iAd_encryption = ad_encryption(bArr, i5, this.mac_s, RomulusEngine.this.k, iAd_encryption, this.mac_CNT);
                        i5 = this.offset;
                    }
                    RomulusEngine romulusEngine10 = RomulusEngine.this;
                    romulusEngine10.block_cipher(this.mac_s, romulusEngine10.k, RomulusEngine.this.npub, 0, this.mac_CNT, b2);
                    RomulusEngine romulusEngine11 = RomulusEngine.this;
                    romulusEngine11.g8A(this.mac_s, romulusEngine11.mac, 0);
                    System.arraycopy(bytes, RomulusEngine.this.dataOperator.getLen() - RomulusEngine.this.MAC_SIZE, RomulusEngine.this.m_buf, 0, RomulusEngine.this.MAC_SIZE);
                    RomulusEngine.this.m_bufPos = 0;
                }
                i2 = b ^ 1;
            }
            b = (byte) i2;
            b2 = b;
            i3 = 0;
            if (RomulusEngine.this.forEncryption) {
                if ((b2 & 8) == 0) {
                    byte[] bArr4 = new byte[16];
                    int iMin3 = Math.min(len2, 16);
                    RomulusEngine.this.pad(bytes, 0, bArr4, 16, iMin3);
                    RomulusEngine romulusEngine12 = RomulusEngine.this;
                    romulusEngine12.block_cipher(this.mac_s, romulusEngine12.k, bArr4, 0, this.mac_CNT, (byte) 44);
                    RomulusEngine.this.lfsr_gf56(this.mac_CNT);
                    iAd_encryption = len2 - iMin3;
                    i7 = iMin3;
                } else {
                    if (len2 == 0) {
                        RomulusEngine.this.lfsr_gf56(this.mac_CNT);
                    }
                    iAd_encryption = len2;
                    i7 = 0;
                }
                while (iAd_encryption > 0) {
                    this.offset = i7;
                    iAd_encryption = ad_encryption(bytes, i7, this.mac_s, RomulusEngine.this.k, iAd_encryption, this.mac_CNT);
                    i7 = this.offset;
                }
                RomulusEngine romulusEngine13 = RomulusEngine.this;
                romulusEngine13.block_cipher(this.mac_s, romulusEngine13.k, RomulusEngine.this.npub, 0, this.mac_CNT, b2);
                RomulusEngine romulusEngine14 = RomulusEngine.this;
                romulusEngine14.g8A(this.mac_s, romulusEngine14.mac, 0);
                i3 = i7 - len2;
            } else {
                System.arraycopy(bytes, len2, RomulusEngine.this.mac, 0, RomulusEngine.this.MAC_SIZE);
                iAd_encryption = len2;
            }
            RomulusEngine romulusEngine15 = RomulusEngine.this;
            romulusEngine15.reset_lfsr_gf56(romulusEngine15.CNT);
            System.arraycopy(RomulusEngine.this.mac, 0, this.s, 0, 16);
            if (len2 > 0) {
                RomulusEngine romulusEngine16 = RomulusEngine.this;
                romulusEngine16.block_cipher(this.s, romulusEngine16.k, RomulusEngine.this.npub, 0, RomulusEngine.this.CNT, (byte) 36);
                i6 = i;
                while (true) {
                    romulusEngine = RomulusEngine.this;
                    if (len2 > i9) {
                        break;
                        break;
                    }
                    len2 -= 16;
                    romulusEngine.rho(bytes, i3, bArr, i6, this.s, 16);
                    i6 += 16;
                    i3 += 16;
                    RomulusEngine romulusEngine17 = RomulusEngine.this;
                    romulusEngine17.lfsr_gf56(romulusEngine17.CNT);
                    RomulusEngine romulusEngine18 = RomulusEngine.this;
                    romulusEngine18.block_cipher(this.s, romulusEngine18.k, RomulusEngine.this.npub, 0, RomulusEngine.this.CNT, (byte) 36);
                    i9 = i9;
                }
                i4 = i9;
                romulusEngine.rho(bytes, i3, bArr, i6, this.s, len2);
            } else {
                i4 = 16;
            }
            if (RomulusEngine.this.forEncryption) {
                if ((b2 & 8) == 0) {
                    byte[] bArr5 = new byte[i4];
                    int iMin4 = Math.min(iAd_encryption, i4);
                    iAd_encryption -= iMin4;
                    RomulusEngine.this.pad(bArr, i, bArr5, 16, iMin4);
                    RomulusEngine romulusEngine19 = RomulusEngine.this;
                    romulusEngine19.block_cipher(this.mac_s, romulusEngine19.k, bArr5, 0, this.mac_CNT, (byte) 44);
                    RomulusEngine.this.lfsr_gf56(this.mac_CNT);
                    i5 = i + iMin4;
                } else {
                    if (len2 == 0) {
                        RomulusEngine.this.lfsr_gf56(this.mac_CNT);
                    }
                    i5 = i;
                }
                while (iAd_encryption > 0) {
                    this.offset = i5;
                    iAd_encryption = ad_encryption(bArr, i5, this.mac_s, RomulusEngine.this.k, iAd_encryption, this.mac_CNT);
                    i5 = this.offset;
                }
                RomulusEngine romulusEngine110 = RomulusEngine.this;
                romulusEngine110.block_cipher(this.mac_s, romulusEngine110.k, RomulusEngine.this.npub, 0, this.mac_CNT, b2);
                RomulusEngine romulusEngine111 = RomulusEngine.this;
                romulusEngine111.g8A(this.mac_s, romulusEngine111.mac, 0);
                System.arraycopy(bytes, RomulusEngine.this.dataOperator.getLen() - RomulusEngine.this.MAC_SIZE, RomulusEngine.this.m_buf, 0, RomulusEngine.this.MAC_SIZE);
                RomulusEngine.this.m_bufPos = 0;
            }
        }

        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        public void reset() {
            Arrays.clear(this.s);
            Arrays.clear(this.mac_s);
            RomulusEngine.this.reset_lfsr_gf56(this.mac_CNT);
            RomulusEngine romulusEngine = RomulusEngine.this;
            romulusEngine.reset_lfsr_gf56(romulusEngine.CNT);
            this.twist = true;
        }
    }

    private class RomulusN implements Instance {
        private final byte[] s = new byte[16];
        boolean twist;

        public RomulusN() {
        }

        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        public void processBufferAAD(byte[] bArr, int i) {
            if (this.twist) {
                Bytes.xorTo(16, bArr, i, this.s);
            } else {
                RomulusEngine romulusEngine = RomulusEngine.this;
                romulusEngine.block_cipher(this.s, romulusEngine.k, bArr, i, RomulusEngine.this.CNT, (byte) 8);
            }
            RomulusEngine romulusEngine2 = RomulusEngine.this;
            romulusEngine2.lfsr_gf56(romulusEngine2.CNT);
            this.twist = !this.twist;
        }

        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        public void processBufferDecrypt(byte[] bArr, int i, byte[] bArr2, int i2) {
            RomulusEngine.this.g8A(this.s, bArr2, i2);
            for (int i3 = 0; i3 < 16; i3++) {
                int i4 = i3 + i2;
                byte b = (byte) (bArr2[i4] ^ bArr[i3 + i]);
                bArr2[i4] = b;
                byte[] bArr3 = this.s;
                bArr3[i3] = (byte) (b ^ bArr3[i3]);
            }
            RomulusEngine romulusEngine = RomulusEngine.this;
            romulusEngine.lfsr_gf56(romulusEngine.CNT);
            RomulusEngine romulusEngine2 = RomulusEngine.this;
            romulusEngine2.block_cipher(this.s, romulusEngine2.k, RomulusEngine.this.npub, 0, RomulusEngine.this.CNT, (byte) 4);
        }

        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        public void processBufferEncrypt(byte[] bArr, int i, byte[] bArr2, int i2) {
            RomulusEngine.this.g8A(this.s, bArr2, i2);
            for (int i3 = 0; i3 < 16; i3++) {
                byte[] bArr3 = this.s;
                int i4 = i3 + i;
                bArr3[i3] = (byte) (bArr3[i3] ^ bArr[i4]);
                int i5 = i3 + i2;
                bArr2[i5] = (byte) (bArr2[i5] ^ bArr[i4]);
            }
            RomulusEngine romulusEngine = RomulusEngine.this;
            romulusEngine.lfsr_gf56(romulusEngine.CNT);
            RomulusEngine romulusEngine2 = RomulusEngine.this;
            romulusEngine2.block_cipher(this.s, romulusEngine2.k, RomulusEngine.this.npub, 0, RomulusEngine.this.CNT, (byte) 4);
        }

        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        public void processFinalAAD() {
            if (RomulusEngine.this.m_aadPos != 0) {
                byte[] bArr = new byte[16];
                int iMin = Math.min(RomulusEngine.this.m_aadPos, 16);
                RomulusEngine romulusEngine = RomulusEngine.this;
                romulusEngine.pad(romulusEngine.m_aad, 0, bArr, 16, iMin);
                if (this.twist) {
                    Bytes.xorTo(16, bArr, this.s);
                } else {
                    RomulusEngine romulusEngine2 = RomulusEngine.this;
                    romulusEngine2.block_cipher(this.s, romulusEngine2.k, bArr, 0, RomulusEngine.this.CNT, (byte) 8);
                }
                RomulusEngine romulusEngine3 = RomulusEngine.this;
                romulusEngine3.lfsr_gf56(romulusEngine3.CNT);
            }
            int len = RomulusEngine.this.aadOperator.getLen();
            RomulusEngine romulusEngine4 = RomulusEngine.this;
            if (len == 0) {
                romulusEngine4.lfsr_gf56(romulusEngine4.CNT);
                RomulusEngine romulusEngine5 = RomulusEngine.this;
                romulusEngine5.block_cipher(this.s, romulusEngine5.k, RomulusEngine.this.npub, 0, RomulusEngine.this.CNT, Ascii.SUB);
            } else {
                int i = romulusEngine4.m_aadPos & 15;
                RomulusEngine romulusEngine6 = RomulusEngine.this;
                byte[] bArr2 = this.s;
                byte[] bArr3 = romulusEngine6.k;
                if (i != 0) {
                    romulusEngine6.block_cipher(bArr2, bArr3, RomulusEngine.this.npub, 0, RomulusEngine.this.CNT, Ascii.SUB);
                } else {
                    romulusEngine6.block_cipher(bArr2, bArr3, RomulusEngine.this.npub, 0, RomulusEngine.this.CNT, Ascii.CAN);
                }
            }
            RomulusEngine romulusEngine7 = RomulusEngine.this;
            romulusEngine7.reset_lfsr_gf56(romulusEngine7.CNT);
        }

        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        public void processFinalBlock(byte[] bArr, int i) {
            int len = RomulusEngine.this.dataOperator.getLen() - (RomulusEngine.this.forEncryption ? 0 : RomulusEngine.this.MAC_SIZE);
            RomulusEngine romulusEngine = RomulusEngine.this;
            if (len == 0) {
                romulusEngine.lfsr_gf56(romulusEngine.CNT);
                RomulusEngine romulusEngine2 = RomulusEngine.this;
                romulusEngine2.block_cipher(this.s, romulusEngine2.k, RomulusEngine.this.npub, 0, RomulusEngine.this.CNT, Ascii.NAK);
            } else if (romulusEngine.m_bufPos != 0) {
                int iMin = Math.min(RomulusEngine.this.m_bufPos, 16);
                RomulusEngine romulusEngine3 = RomulusEngine.this;
                romulusEngine3.rho(romulusEngine3.m_buf, 0, bArr, i, this.s, iMin);
                RomulusEngine romulusEngine4 = RomulusEngine.this;
                romulusEngine4.lfsr_gf56(romulusEngine4.CNT);
                RomulusEngine romulusEngine5 = RomulusEngine.this;
                romulusEngine5.block_cipher(this.s, romulusEngine5.k, RomulusEngine.this.npub, 0, RomulusEngine.this.CNT, RomulusEngine.this.m_bufPos == 16 ? Ascii.DC4 : Ascii.NAK);
            }
            RomulusEngine romulusEngine6 = RomulusEngine.this;
            romulusEngine6.g8A(this.s, romulusEngine6.mac, 0);
        }

        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        public void reset() {
            Arrays.clear(this.s);
            RomulusEngine romulusEngine = RomulusEngine.this;
            romulusEngine.reset_lfsr_gf56(romulusEngine.CNT);
            this.twist = true;
        }
    }

    public static class RomulusParameters {
        public static final int ROMULUS_M = 0;
        public static final int ROMULUS_N = 1;
        public static final int ROMULUS_T = 2;
        public static final RomulusParameters RomulusM = new RomulusParameters(0);
        public static final RomulusParameters RomulusN = new RomulusParameters(1);
        public static final RomulusParameters RomulusT = new RomulusParameters(2);
        private final int ord;

        RomulusParameters(int i) {
            this.ord = i;
        }
    }

    private class RomulusT implements Instance {
        byte[] CNT_Z;
        byte[] LR;
        byte[] S;
        byte[] T;
        byte[] Z;
        private final byte[] g;
        private final byte[] h;

        private RomulusT() {
            this.h = new byte[16];
            this.g = new byte[16];
            this.Z = new byte[16];
            this.CNT_Z = new byte[7];
            this.LR = new byte[32];
            this.T = new byte[16];
            this.S = new byte[16];
        }

        private void processAfterAbsorbCiphertext() {
            if (RomulusEngine.this.m_aadPos == RomulusEngine.this.BlockSize) {
                RomulusEngine.hirose_128_128_256(this.h, this.g, RomulusEngine.this.m_aad, 0);
                RomulusEngine.this.m_aadPos = 0;
            } else {
                RomulusEngine romulusEngine = RomulusEngine.this;
                romulusEngine.m_aadPos = romulusEngine.BlockSize;
            }
            RomulusEngine.this.lfsr_gf56(this.CNT_Z);
        }

        private void processBuffer(byte[] bArr, int i, byte[] bArr2, int i2) {
            System.arraycopy(RomulusEngine.this.npub, 0, this.S, 0, 16);
            RomulusEngine romulusEngine = RomulusEngine.this;
            romulusEngine.block_cipher(this.S, this.Z, this.T, 0, romulusEngine.CNT, SignedBytes.MAX_POWER_OF_TWO);
            Bytes.xor(16, this.S, bArr, i, bArr2, i2);
            System.arraycopy(RomulusEngine.this.npub, 0, this.S, 0, 16);
            RomulusEngine romulusEngine2 = RomulusEngine.this;
            romulusEngine2.block_cipher(this.S, this.Z, this.T, 0, romulusEngine2.CNT, (byte) 65);
            System.arraycopy(this.S, 0, this.Z, 0, 16);
            RomulusEngine romulusEngine3 = RomulusEngine.this;
            romulusEngine3.lfsr_gf56(romulusEngine3.CNT);
        }

        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        public void processBufferAAD(byte[] bArr, int i) {
            RomulusEngine.hirose_128_128_256(this.h, this.g, bArr, i);
        }

        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        public void processBufferDecrypt(byte[] bArr, int i, byte[] bArr2, int i2) {
            processBuffer(bArr, i, bArr2, i2);
            System.arraycopy(bArr, i, RomulusEngine.this.m_aad, RomulusEngine.this.m_aadPos, RomulusEngine.this.BlockSize);
            processAfterAbsorbCiphertext();
        }

        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        public void processBufferEncrypt(byte[] bArr, int i, byte[] bArr2, int i2) {
            processBuffer(bArr, i, bArr2, i2);
            System.arraycopy(bArr2, i2, RomulusEngine.this.m_aad, RomulusEngine.this.m_aadPos, RomulusEngine.this.BlockSize);
            processAfterAbsorbCiphertext();
        }

        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        public void processFinalAAD() {
            Arrays.fill(RomulusEngine.this.m_aad, RomulusEngine.this.m_aadPos, RomulusEngine.this.AADBufferSize - 1, (byte) 0);
            int i = RomulusEngine.this.m_aadPos;
            RomulusEngine romulusEngine = RomulusEngine.this;
            if (i >= 16) {
                romulusEngine.m_aad[RomulusEngine.this.AADBufferSize - 1] = (byte) (RomulusEngine.this.m_aadPos & 15);
                RomulusEngine.hirose_128_128_256(this.h, this.g, RomulusEngine.this.m_aad, 0);
                RomulusEngine.this.m_aadPos = 0;
            } else {
                if (romulusEngine.m_aadPos < 0 || RomulusEngine.this.aadOperator.getLen() == 0) {
                    return;
                }
                RomulusEngine.this.m_aad[RomulusEngine.this.BlockSize - 1] = (byte) (RomulusEngine.this.m_aadPos & 15);
                RomulusEngine romulusEngine2 = RomulusEngine.this;
                romulusEngine2.m_aadPos = romulusEngine2.BlockSize;
            }
        }

        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        public void processFinalBlock(byte[] bArr, int i) {
            char c;
            int len = RomulusEngine.this.dataOperator.getLen() - (RomulusEngine.this.forEncryption ? 0 : RomulusEngine.this.MAC_SIZE);
            int i2 = RomulusEngine.this.m_bufPos;
            RomulusEngine romulusEngine = RomulusEngine.this;
            if (i2 != 0) {
                int iMin = Math.min(romulusEngine.m_bufPos, 16);
                System.arraycopy(RomulusEngine.this.npub, 0, this.S, 0, 16);
                RomulusEngine romulusEngine2 = RomulusEngine.this;
                romulusEngine2.block_cipher(this.S, this.Z, this.T, 0, romulusEngine2.CNT, SignedBytes.MAX_POWER_OF_TWO);
                Bytes.xor(iMin, RomulusEngine.this.m_buf, this.S, bArr, i);
                System.arraycopy(RomulusEngine.this.npub, 0, this.S, 0, 16);
                RomulusEngine romulusEngine3 = RomulusEngine.this;
                romulusEngine3.lfsr_gf56(romulusEngine3.CNT);
                if (!RomulusEngine.this.forEncryption) {
                    bArr = RomulusEngine.this.m_buf;
                    i = 0;
                }
                System.arraycopy(bArr, i, RomulusEngine.this.m_aad, RomulusEngine.this.m_aadPos, RomulusEngine.this.m_bufPos);
                Arrays.fill(RomulusEngine.this.m_aad, RomulusEngine.this.m_aadPos + RomulusEngine.this.m_bufPos, RomulusEngine.this.AADBufferSize - 1, (byte) 0);
                RomulusEngine.this.m_aad[(RomulusEngine.this.m_aadPos + RomulusEngine.this.BlockSize) - 1] = (byte) (RomulusEngine.this.m_bufPos & 15);
                if (RomulusEngine.this.m_aadPos == 0) {
                    System.arraycopy(RomulusEngine.this.npub, 0, RomulusEngine.this.m_aad, RomulusEngine.this.BlockSize, RomulusEngine.this.BlockSize);
                    c = 0;
                } else {
                    c = 16;
                }
                RomulusEngine.hirose_128_128_256(this.h, this.g, RomulusEngine.this.m_aad, 0);
                RomulusEngine.this.lfsr_gf56(this.CNT_Z);
            } else if (romulusEngine.m_aadPos != 0) {
                RomulusEngine romulusEngine4 = RomulusEngine.this;
                if (len > 0) {
                    Arrays.fill(romulusEngine4.m_aad, RomulusEngine.this.BlockSize, RomulusEngine.this.AADBufferSize, (byte) 0);
                } else {
                    if (romulusEngine4.aadOperator.getLen() != 0) {
                        System.arraycopy(RomulusEngine.this.npub, 0, RomulusEngine.this.m_aad, RomulusEngine.this.m_aadPos, 16);
                        RomulusEngine.this.m_aadPos = 0;
                        c = 0;
                    }
                    RomulusEngine.hirose_128_128_256(this.h, this.g, RomulusEngine.this.m_aad, 0);
                }
                c = 16;
                RomulusEngine.hirose_128_128_256(this.h, this.g, RomulusEngine.this.m_aad, 0);
            } else if (len > 0) {
                Arrays.fill(RomulusEngine.this.m_aad, 0, RomulusEngine.this.BlockSize, (byte) 0);
                System.arraycopy(RomulusEngine.this.npub, 0, RomulusEngine.this.m_aad, RomulusEngine.this.BlockSize, RomulusEngine.this.BlockSize);
                RomulusEngine.hirose_128_128_256(this.h, this.g, RomulusEngine.this.m_aad, 0);
                c = 0;
            } else {
                c = 16;
            }
            if (c == 16) {
                System.arraycopy(RomulusEngine.this.npub, 0, RomulusEngine.this.m_aad, 0, 16);
                System.arraycopy(RomulusEngine.this.CNT, 0, RomulusEngine.this.m_aad, 16, 7);
                Arrays.fill(RomulusEngine.this.m_aad, 23, 31, (byte) 0);
                RomulusEngine.this.m_aad[31] = Ascii.ETB;
            } else {
                System.arraycopy(this.CNT_Z, 0, RomulusEngine.this.m_aad, 0, 7);
                Arrays.fill(RomulusEngine.this.m_aad, 7, 31, (byte) 0);
                RomulusEngine.this.m_aad[31] = 7;
            }
            byte[] bArr2 = this.h;
            bArr2[0] = (byte) (bArr2[0] ^ 2);
            RomulusEngine.hirose_128_128_256(bArr2, this.g, RomulusEngine.this.m_aad, 0);
            System.arraycopy(this.h, 0, this.LR, 0, 16);
            System.arraycopy(this.g, 0, this.LR, 16, 16);
            Arrays.clear(this.CNT_Z);
            RomulusEngine romulusEngine5 = RomulusEngine.this;
            romulusEngine5.block_cipher(this.LR, romulusEngine5.k, this.LR, 16, this.CNT_Z, (byte) 68);
            System.arraycopy(this.LR, 0, RomulusEngine.this.mac, 0, RomulusEngine.this.MAC_SIZE);
        }

        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        public void reset() {
            Arrays.clear(this.h);
            Arrays.clear(this.g);
            Arrays.clear(this.LR);
            Arrays.clear(this.T);
            Arrays.clear(this.S);
            Arrays.clear(this.CNT_Z);
            RomulusEngine romulusEngine = RomulusEngine.this;
            romulusEngine.reset_lfsr_gf56(romulusEngine.CNT);
            System.arraycopy(RomulusEngine.this.npub, 0, this.Z, 0, RomulusEngine.this.IV_SIZE);
            RomulusEngine romulusEngine2 = RomulusEngine.this;
            romulusEngine2.block_cipher(this.Z, romulusEngine2.k, this.T, 0, this.CNT_Z, (byte) 66);
            RomulusEngine.this.reset_lfsr_gf56(this.CNT_Z);
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0049  */
    /* JADX WARN: Code duplicated, block: B:16:0x004c  */
    /* JADX WARN: Code duplicated, block: B:19:0x0054  */
    /* JADX WARN: Code duplicated, block: B:20:0x0057  */
    public RomulusEngine(RomulusParameters romulusParameters) {
        Instance romulusM;
        AEADBaseEngine.ProcessingBufferType processingBufferType;
        AEADBaseEngine.DataOperatorType dataOperatorType;
        this.AADBufferSize = 16;
        this.BlockSize = 16;
        this.MAC_SIZE = 16;
        this.IV_SIZE = 16;
        this.KEY_SIZE = 16;
        this.CNT = new byte[7];
        int i = romulusParameters.ord;
        if (i == 0) {
            this.algorithmName = "Romulus-M";
            romulusM = new RomulusM();
        } else {
            if (i != 1) {
                if (i == 2) {
                    this.algorithmName = "Romulus-T";
                    this.AADBufferSize = 32;
                    romulusM = new RomulusT();
                }
                if (romulusParameters == RomulusParameters.RomulusN) {
                    processingBufferType = AEADBaseEngine.ProcessingBufferType.Buffered;
                } else {
                    processingBufferType = AEADBaseEngine.ProcessingBufferType.Immediate;
                }
                AEADBaseEngine.AADOperatorType aADOperatorType = AEADBaseEngine.AADOperatorType.Counter;
                if (romulusParameters == RomulusParameters.RomulusM) {
                    dataOperatorType = AEADBaseEngine.DataOperatorType.Stream;
                } else {
                    dataOperatorType = AEADBaseEngine.DataOperatorType.Counter;
                }
                setInnerMembers(processingBufferType, aADOperatorType, dataOperatorType);
            }
            this.algorithmName = "Romulus-N";
            romulusM = new RomulusN();
        }
        this.instance = romulusM;
        if (romulusParameters == RomulusParameters.RomulusN) {
            processingBufferType = AEADBaseEngine.ProcessingBufferType.Buffered;
        } else {
            processingBufferType = AEADBaseEngine.ProcessingBufferType.Immediate;
        }
        AEADBaseEngine.AADOperatorType aADOperatorType2 = AEADBaseEngine.AADOperatorType.Counter;
        if (romulusParameters == RomulusParameters.RomulusM) {
            dataOperatorType = AEADBaseEngine.DataOperatorType.Stream;
        } else {
            dataOperatorType = AEADBaseEngine.DataOperatorType.Counter;
        }
        setInnerMembers(processingBufferType, aADOperatorType2, dataOperatorType);
    }

    public static void hirose_128_128_256(RomulusDigest.Friend friend, byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        if (friend == null) {
            throw new NullPointerException("This method is only for use by RomulusDigest");
        }
        hirose_128_128_256(bArr, bArr2, bArr3, i);
    }

    static void hirose_128_128_256(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        byte[] bArr4 = new byte[48];
        byte[] bArr5 = new byte[16];
        System.arraycopy(bArr2, 0, bArr4, 0, 16);
        System.arraycopy(bArr, 0, bArr2, 0, 16);
        System.arraycopy(bArr, 0, bArr5, 0, 16);
        bArr2[0] = (byte) (bArr2[0] ^ 1);
        System.arraycopy(bArr3, i, bArr4, 16, 32);
        skinny_128_384_plus_enc(bArr, bArr4);
        skinny_128_384_plus_enc(bArr2, bArr4);
        for (int i2 = 0; i2 < 16; i2++) {
            bArr[i2] = (byte) (bArr[i2] ^ bArr5[i2]);
            bArr2[i2] = (byte) (bArr2[i2] ^ bArr5[i2]);
        }
        bArr2[0] = (byte) (bArr2[0] ^ 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset_lfsr_gf56(byte[] bArr) {
        bArr[0] = 1;
        Arrays.fill(bArr, 1, 7, (byte) 0);
    }

    private static void skinny_128_384_plus_enc(byte[] bArr, byte[] bArr2) {
        byte[][] bArr3 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 4, 4);
        byte[][][] bArr4 = (byte[][][]) Array.newInstance((Class<?>) Byte.TYPE, 3, 4, 4);
        byte[][][] bArr5 = (byte[][][]) Array.newInstance((Class<?>) Byte.TYPE, 3, 4, 4);
        for (int i = 0; i < 4; i++) {
            int i2 = i << 2;
            System.arraycopy(bArr, i2, bArr3[i], 0, 4);
            System.arraycopy(bArr2, i2, bArr4[0][i], 0, 4);
            System.arraycopy(bArr2, i2 + 16, bArr4[1][i], 0, 4);
            System.arraycopy(bArr2, i2 + 32, bArr4[2][i], 0, 4);
        }
        for (int i3 = 0; i3 < 40; i3++) {
            for (int i4 = 0; i4 < 4; i4++) {
                for (int i5 = 0; i5 < 4; i5++) {
                    byte[] bArr6 = bArr3[i4];
                    bArr6[i5] = sbox_8[bArr6[i5] & 255];
                }
            }
            byte[] bArr7 = bArr3[0];
            byte b = bArr7[0];
            byte[] bArr8 = RC;
            bArr7[0] = (byte) (b ^ (bArr8[i3] & Ascii.SI));
            byte[] bArr9 = bArr3[1];
            bArr9[0] = (byte) (bArr9[0] ^ ((bArr8[i3] >>> 4) & 3));
            byte[] bArr10 = bArr3[2];
            bArr10[0] = (byte) (bArr10[0] ^ 2);
            for (int i6 = 0; i6 <= 1; i6++) {
                for (int i7 = 0; i7 < 4; i7++) {
                    byte[] bArr11 = bArr3[i6];
                    bArr11[i7] = (byte) (bArr11[i7] ^ ((bArr4[0][i6][i7] ^ bArr4[1][i6][i7]) ^ bArr4[2][i6][i7]));
                }
            }
            for (int i8 = 0; i8 < 4; i8++) {
                for (int i9 = 0; i9 < 4; i9++) {
                    byte b2 = TWEAKEY_P[(i8 << 2) + i9];
                    int i10 = b2 >>> 2;
                    int i11 = b2 & 3;
                    bArr5[0][i8][i9] = bArr4[0][i10][i11];
                    bArr5[1][i8][i9] = bArr4[1][i10][i11];
                    bArr5[2][i8][i9] = bArr4[2][i10][i11];
                }
            }
            int i12 = 0;
            while (i12 <= 1) {
                for (int i13 = 0; i13 < 4; i13++) {
                    bArr4[0][i12][i13] = bArr5[0][i12][i13];
                    byte b3 = bArr5[1][i12][i13];
                    bArr4[1][i12][i13] = (byte) (((b3 >>> 5) & 1) ^ (((b3 << 1) & 254) ^ ((b3 >>> 7) & 1)));
                    byte b4 = bArr5[2][i12][i13];
                    bArr4[2][i12][i13] = (byte) (((b4 << 1) & 128) ^ (((b4 >>> 1) & 127) ^ ((b4 << 7) & 128)));
                }
                i12++;
            }
            while (i12 < 4) {
                for (int i14 = 0; i14 < 4; i14++) {
                    bArr4[0][i12][i14] = bArr5[0][i12][i14];
                    bArr4[1][i12][i14] = bArr5[1][i12][i14];
                    bArr4[2][i12][i14] = bArr5[2][i12][i14];
                }
                i12++;
            }
            byte[] bArr12 = bArr3[1];
            byte b5 = bArr12[3];
            bArr12[3] = bArr12[2];
            bArr12[2] = bArr12[1];
            bArr12[1] = bArr12[0];
            bArr12[0] = b5;
            byte[] bArr13 = bArr3[2];
            byte b6 = bArr13[0];
            bArr13[0] = bArr13[2];
            bArr13[2] = b6;
            byte b7 = bArr13[1];
            bArr13[1] = bArr13[3];
            bArr13[3] = b7;
            byte[] bArr14 = bArr3[3];
            byte b8 = bArr14[0];
            bArr14[0] = bArr14[1];
            bArr14[1] = bArr14[2];
            bArr14[2] = bArr14[3];
            bArr14[3] = b8;
            for (int i15 = 0; i15 < 4; i15++) {
                byte[] bArr15 = bArr3[1];
                byte b9 = bArr15[i15];
                byte[] bArr16 = bArr3[2];
                bArr15[i15] = (byte) (b9 ^ bArr16[i15]);
                byte b10 = bArr16[i15];
                byte[] bArr17 = bArr3[0];
                byte b11 = (byte) (b10 ^ bArr17[i15]);
                bArr16[i15] = b11;
                byte[] bArr18 = bArr3[3];
                byte b12 = (byte) (bArr18[i15] ^ b11);
                bArr18[i15] = b12;
                bArr18[i15] = bArr16[i15];
                bArr16[i15] = bArr15[i15];
                bArr15[i15] = bArr17[i15];
                bArr17[i15] = b12;
            }
        }
        for (int i16 = 0; i16 < 16; i16++) {
            bArr[i16] = (byte) (bArr3[i16 >>> 2][i16 & 3] & 255);
        }
    }

    void block_cipher(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, byte[] bArr4, byte b) {
        byte[] bArr5 = new byte[48];
        System.arraycopy(bArr4, 0, bArr5, 0, 7);
        bArr5[7] = b;
        System.arraycopy(bArr3, i, bArr5, 16, 16);
        System.arraycopy(bArr2, 0, bArr5, 32, 16);
        skinny_128_384_plus_enc(bArr, bArr5);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ int doFinal(byte[] bArr, int i) throws InvalidCipherTextException, IllegalStateException {
        return super.doFinal(bArr, i);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    protected void finishAAD(AEADBaseEngine.State state, boolean z) {
        finishAAD1(state);
    }

    void g8A(byte[] bArr, byte[] bArr2, int i) {
        int iMin = Math.min(bArr2.length - i, 16);
        for (int i2 = 0; i2 < iMin; i2++) {
            byte b = bArr[i2];
            bArr2[i2 + i] = (byte) (((b & 1) << 7) ^ (((b & 255) >>> 1) ^ (b & 128)));
        }
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
        this.npub = bArr2;
        this.k = bArr;
    }

    void lfsr_gf56(byte[] bArr) {
        byte b = bArr[6];
        byte b2 = (byte) ((b & 255) >>> 7);
        byte b3 = bArr[5];
        bArr[6] = (byte) (((b & 255) << 1) | ((b3 & 255) >>> 7));
        int i = (b3 & 255) << 1;
        byte b4 = bArr[4];
        bArr[5] = (byte) (i | ((b4 & 255) >>> 7));
        int i2 = (b4 & 255) << 1;
        byte b5 = bArr[3];
        bArr[4] = (byte) (i2 | ((b5 & 255) >>> 7));
        int i3 = (b5 & 255) << 1;
        byte b6 = bArr[2];
        bArr[3] = (byte) (i3 | ((b6 & 255) >>> 7));
        byte b7 = bArr[1];
        bArr[2] = (byte) (((b6 & 255) << 1) | ((b7 & 255) >>> 7));
        int i4 = (b7 & 255) << 1;
        byte b8 = bArr[0];
        bArr[1] = (byte) (i4 | ((b8 & 255) >>> 7));
        int i5 = (b8 & 255) << 1;
        if (b2 == 1) {
            bArr[0] = (byte) (i5 ^ 149);
        } else {
            bArr[0] = (byte) i5;
        }
    }

    void pad(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        bArr2[i2 - 1] = (byte) (i3 & 15);
        System.arraycopy(bArr, i, bArr2, 0, i3);
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
        this.instance.processBufferAAD(bArr, i);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    protected void processBufferDecrypt(byte[] bArr, int i, byte[] bArr2, int i2) {
        this.instance.processBufferDecrypt(bArr, i, bArr2, i2);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    protected void processBufferEncrypt(byte[] bArr, int i, byte[] bArr2, int i2) {
        this.instance.processBufferEncrypt(bArr, i, bArr2, i2);
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
        this.instance.processFinalAAD();
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    protected void processFinalBlock(byte[] bArr, int i) {
        this.instance.processFinalBlock(bArr, i);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ void reset() {
        super.reset();
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    protected void reset(boolean z) {
        super.reset(z);
        this.instance.reset();
    }

    void rho(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, int i3) {
        int i4;
        byte[] bArr4 = new byte[16];
        pad(bArr, i, bArr4, 16, i3);
        g8A(bArr3, bArr2, i2);
        if (this.forEncryption) {
            for (int i5 = 0; i5 < 16; i5++) {
                bArr3[i5] = (byte) (bArr3[i5] ^ bArr4[i5]);
                int i6 = i5 + i2;
                if (i5 < i3) {
                    bArr2[i6] = (byte) (bArr2[i6] ^ bArr4[i5]);
                } else {
                    bArr2[i6] = 0;
                }
            }
            return;
        }
        for (int i7 = 0; i7 < 16; i7++) {
            byte b = (byte) (bArr3[i7] ^ bArr4[i7]);
            bArr3[i7] = b;
            if (i7 < i3 && (i4 = i7 + i2) < bArr2.length) {
                bArr3[i7] = (byte) (b ^ bArr2[i4]);
                bArr2[i4] = (byte) (bArr2[i4] ^ bArr4[i7]);
            }
        }
    }
}
