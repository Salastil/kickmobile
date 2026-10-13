package org.bouncycastle.crypto.threshold;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import kotlin.io.encoding.Base64;
import org.bouncycastle.crypto.signers.PSSSigner;

/* JADX INFO: loaded from: classes10.dex */
class PolynomialTable extends Polynomial {
    private final byte[] EXP;
    private final byte[] LOG;
    private static final byte[] AES_LOG = {0, -1, Ascii.EM, 1, 50, 2, Ascii.SUB, -58, 75, -57, Ascii.ESC, 104, 51, -18, -33, 3, 100, 4, -32, Ascii.SO, 52, -115, -127, -17, 76, 113, 8, -56, -8, 105, Ascii.FS, -63, 125, -62, Ascii.GS, -75, -7, -71, 39, 106, 77, -28, -90, 114, -102, -55, 9, 120, 101, 47, -118, 5, 33, Ascii.SI, -31, 36, Ascii.DC2, -16, -126, 69, 53, -109, -38, -114, -106, -113, -37, -67, 54, -48, -50, -108, 19, 92, -46, -15, SignedBytes.MAX_POWER_OF_TWO, 70, -125, 56, 102, -35, -3, 48, -65, 6, -117, 98, -77, 37, -30, -104, 34, -120, -111, Ascii.DLE, 126, 110, 72, -61, -93, -74, Ascii.RS, 66, 58, 107, 40, 84, -6, -123, Base64.padSymbol, -70, 43, 121, 10, Ascii.NAK, -101, -97, 94, -54, 78, -44, -84, -27, -13, 115, -89, 87, -81, 88, -88, 80, -12, -22, -42, 116, 79, -82, -23, -43, -25, -26, -83, -24, 44, -41, 117, 122, -21, Ascii.SYN, Ascii.VT, -11, 89, -53, 95, -80, -100, -87, 81, -96, 127, Ascii.FF, -10, 111, Ascii.ETB, -60, 73, -20, -40, 67, Ascii.US, 45, -92, 118, 123, -73, -52, -69, 62, 90, -5, 96, -79, -122, 59, 82, -95, 108, -86, 85, 41, -99, -105, -78, -121, -112, 97, -66, -36, -4, PSSSigner.TRAILER_IMPLICIT, -107, -49, -51, 55, 63, 91, -47, 83, 57, -124, 60, 65, -94, 109, 71, Ascii.DC4, 42, -98, 93, 86, -14, -45, -85, 68, 17, -110, -39, 35, 32, 46, -119, -76, 124, -72, 38, 119, -103, -29, -91, 103, 74, -19, -34, -59, 49, -2, Ascii.CAN, Ascii.CR, 99, -116, -128, -64, -9, 112, 7};
    private static final byte[] AES_EXP = {1, 3, 5, Ascii.SI, 17, 51, 85, -1, Ascii.SUB, 46, 114, -106, -95, -8, 19, 53, 95, -31, 56, 72, -40, 115, -107, -92, -9, 2, 6, 10, Ascii.RS, 34, 102, -86, -27, 52, 92, -28, 55, 89, -21, 38, 106, -66, -39, 112, -112, -85, -26, 49, 83, -11, 4, Ascii.FF, Ascii.DC4, 60, 68, -52, 79, -47, 104, -72, -45, 110, -78, -51, 76, -44, 103, -87, -32, 59, 77, -41, 98, -90, -15, 8, Ascii.CAN, 40, 120, -120, -125, -98, -71, -48, 107, -67, -36, 127, -127, -104, -77, -50, 73, -37, 118, -102, -75, -60, 87, -7, Ascii.DLE, 48, 80, -16, Ascii.VT, Ascii.GS, 39, 105, -69, -42, 97, -93, -2, Ascii.EM, 43, 125, -121, -110, -83, -20, 47, 113, -109, -82, -23, 32, 96, -96, -5, Ascii.SYN, 58, 78, -46, 109, -73, -62, 93, -25, 50, 86, -6, Ascii.NAK, 63, 65, -61, 94, -30, Base64.padSymbol, 71, -55, SignedBytes.MAX_POWER_OF_TWO, -64, 91, -19, 44, 116, -100, -65, -38, 117, -97, -70, -43, 100, -84, -17, 42, 126, -126, -99, PSSSigner.TRAILER_IMPLICIT, -33, 122, -114, -119, -128, -101, -74, -63, 88, -24, 35, 101, -81, -22, 37, 111, -79, -56, 67, -59, 84, -4, Ascii.US, 33, 99, -91, -12, 7, 9, Ascii.ESC, 45, 119, -103, -80, -53, 70, -54, 69, -49, 74, -34, 121, -117, -122, -111, -88, -29, 62, 66, -58, 81, -13, Ascii.SO, Ascii.DC2, 54, 90, -18, 41, 123, -115, -116, -113, -118, -123, -108, -89, -14, Ascii.CR, Ascii.ETB, 57, 75, -35, 124, -124, -105, -94, -3, Ascii.FS, 36, 108, -76, -57, 82, -10, 1};
    private static final byte[] RSA_LOG = {-1, 0, 1, Ascii.EM, 2, 50, Ascii.SUB, -58, 3, -33, 51, -18, Ascii.ESC, 104, -57, 75, 4, 100, -32, Ascii.SO, 52, -115, -17, -127, Ascii.FS, -63, 105, -8, -56, 8, 76, 113, 5, -118, 101, 47, -31, 36, Ascii.SI, 33, 53, -109, -114, -38, -16, Ascii.DC2, -126, 69, Ascii.GS, -75, -62, 125, 106, 39, -7, -71, -55, -102, 9, 120, 77, -28, 114, -90, 6, -65, -117, 98, 102, -35, 48, -3, -30, -104, 37, -77, Ascii.DLE, -111, 34, -120, 54, -48, -108, -50, -113, -106, -37, -67, -15, -46, 19, 92, -125, 56, 70, SignedBytes.MAX_POWER_OF_TWO, Ascii.RS, 66, -74, -93, -61, 72, 126, 110, 107, 58, 40, 84, -6, -123, -70, Base64.padSymbol, -54, 94, -101, -97, 10, Ascii.NAK, 121, 43, 78, -44, -27, -84, 115, -13, -89, 87, 7, 112, -64, -9, -116, -128, 99, Ascii.CR, 103, 74, -34, -19, 49, -59, -2, Ascii.CAN, -29, -91, -103, 119, 38, -72, -76, 124, 17, 68, -110, -39, 35, 32, -119, 46, 55, 63, -47, 91, -107, PSSSigner.TRAILER_IMPLICIT, -49, -51, -112, -121, -105, -78, -36, -4, -66, 97, -14, 86, -45, -85, Ascii.DC4, 42, 93, -98, -124, 60, 57, 83, 71, 109, 65, -94, Ascii.US, 45, 67, -40, -73, 123, -92, 118, -60, Ascii.ETB, 73, -20, 127, Ascii.FF, 111, -10, 108, -95, 59, 82, 41, -99, 85, -86, -5, 96, -122, -79, -69, -52, 62, 90, -53, 89, 95, -80, -100, -87, -96, 81, Ascii.VT, -11, Ascii.SYN, -21, 122, 117, 44, -41, 79, -82, -43, -23, -26, -25, -83, -24, 116, -42, -12, -22, -88, 80, 88, -81};
    private static final byte[] RSA_EXP = {1, 2, 4, 8, Ascii.DLE, 32, SignedBytes.MAX_POWER_OF_TWO, -128, Ascii.GS, 58, 116, -24, -51, -121, 19, 38, 76, -104, 45, 90, -76, 117, -22, -55, -113, 3, 6, Ascii.FF, Ascii.CAN, 48, 96, -64, -99, 39, 78, -100, 37, 74, -108, 53, 106, -44, -75, 119, -18, -63, -97, 35, 70, -116, 5, 10, Ascii.DC4, 40, 80, -96, 93, -70, 105, -46, -71, 111, -34, -95, 95, -66, 97, -62, -103, 47, 94, PSSSigner.TRAILER_IMPLICIT, 101, -54, -119, Ascii.SI, Ascii.RS, 60, 120, -16, -3, -25, -45, -69, 107, -42, -79, 127, -2, -31, -33, -93, 91, -74, 113, -30, -39, -81, 67, -122, 17, 34, 68, -120, Ascii.CR, Ascii.SUB, 52, 104, -48, -67, 103, -50, -127, Ascii.US, 62, 124, -8, -19, -57, -109, 59, 118, -20, -59, -105, 51, 102, -52, -123, Ascii.ETB, 46, 92, -72, 109, -38, -87, 79, -98, 33, 66, -124, Ascii.NAK, 42, 84, -88, 77, -102, 41, 82, -92, 85, -86, 73, -110, 57, 114, -28, -43, -73, 115, -26, -47, -65, 99, -58, -111, 63, 126, -4, -27, -41, -77, 123, -10, -15, -1, -29, -37, -85, 75, -106, 49, 98, -60, -107, 55, 110, -36, -91, 87, -82, 65, -126, Ascii.EM, 50, 100, -56, -115, 7, Ascii.SO, Ascii.FS, 56, 112, -32, -35, -89, 83, -90, 81, -94, 89, -78, 121, -14, -7, -17, -61, -101, 43, 86, -84, 69, -118, 9, Ascii.DC2, 36, 72, -112, Base64.padSymbol, 122, -12, -11, -9, -13, -5, -21, -53, -117, Ascii.VT, Ascii.SYN, 44, 88, -80, 125, -6, -23, -49, -125, Ascii.ESC, 54, 108, -40, -83, 71, -114, 1};

    /* JADX INFO: renamed from: org.bouncycastle.crypto.threshold.PolynomialTable$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$bouncycastle$crypto$threshold$ShamirSecretSplitter$Algorithm;

        static {
            int[] iArr = new int[ShamirSecretSplitter.Algorithm.values().length];
            $SwitchMap$org$bouncycastle$crypto$threshold$ShamirSecretSplitter$Algorithm = iArr;
            try {
                iArr[ShamirSecretSplitter.Algorithm.AES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$bouncycastle$crypto$threshold$ShamirSecretSplitter$Algorithm[ShamirSecretSplitter.Algorithm.RSA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public PolynomialTable(ShamirSecretSplitter.Algorithm algorithm) {
        int i = AnonymousClass1.$SwitchMap$org$bouncycastle$crypto$threshold$ShamirSecretSplitter$Algorithm[algorithm.ordinal()];
        if (i == 1) {
            this.LOG = AES_LOG;
            this.EXP = AES_EXP;
        } else {
            if (i != 2) {
                throw new IllegalArgumentException("The algorithm is not correct");
            }
            this.LOG = RSA_LOG;
            this.EXP = RSA_EXP;
        }
    }

    @Override // org.bouncycastle.crypto.threshold.Polynomial
    protected byte gfDiv(int i, int i2) {
        if (i == 0) {
            return (byte) 0;
        }
        byte[] bArr = this.EXP;
        byte[] bArr2 = this.LOG;
        return bArr[(((bArr2[i] & 255) - (bArr2[i2] & 255)) + 255) % 255];
    }

    @Override // org.bouncycastle.crypto.threshold.Polynomial
    protected byte gfMul(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return (byte) 0;
        }
        byte[] bArr = this.EXP;
        byte[] bArr2 = this.LOG;
        return (byte) (bArr[((bArr2[i] & 255) + (bArr2[i2] & 255)) % 255] & 255);
    }
}
