package j$.util;

import com.google.common.base.Ascii;
import io.ktor.util.date.GMTDateParser;
import java.util.Arrays;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.bouncycastle.pqc.legacy.math.linearalgebra.Matrix;

/* JADX INFO: loaded from: classes3.dex */
public class Base64 {
    public static Encoder getEncoder() {
        return Encoder.RFC4648;
    }

    public static class Encoder {
        private static final byte[] CRLF;
        static final Encoder RFC2045;
        static final Encoder RFC4648;
        static final Encoder RFC4648_URLSAFE;
        private static final char[] toBase64 = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', Matrix.MATRIX_TYPE_RANDOM_LT, GMTDateParser.MONTH, 'N', 'O', 'P', 'Q', Matrix.MATRIX_TYPE_RANDOM_REGULAR, 'S', 'T', Matrix.MATRIX_TYPE_RANDOM_UT, 'V', 'W', 'X', GMTDateParser.YEAR, Matrix.MATRIX_TYPE_ZERO, 'a', 'b', 'c', GMTDateParser.DAY_OF_MONTH, 'e', 'f', 'g', GMTDateParser.HOURS, 'i', 'j', 'k', 'l', GMTDateParser.MINUTES, 'n', 'o', 'p', 'q', 'r', GMTDateParser.SECONDS, 't', AbstractJsonLexerKt.UNICODE_ESC, 'v', 'w', 'x', 'y', GMTDateParser.ZONE, '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
        private static final char[] toBase64URL = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', Matrix.MATRIX_TYPE_RANDOM_LT, GMTDateParser.MONTH, 'N', 'O', 'P', 'Q', Matrix.MATRIX_TYPE_RANDOM_REGULAR, 'S', 'T', Matrix.MATRIX_TYPE_RANDOM_UT, 'V', 'W', 'X', GMTDateParser.YEAR, Matrix.MATRIX_TYPE_ZERO, 'a', 'b', 'c', GMTDateParser.DAY_OF_MONTH, 'e', 'f', 'g', GMTDateParser.HOURS, 'i', 'j', 'k', 'l', GMTDateParser.MINUTES, 'n', 'o', 'p', 'q', 'r', GMTDateParser.SECONDS, 't', AbstractJsonLexerKt.UNICODE_ESC, 'v', 'w', 'x', 'y', GMTDateParser.ZONE, '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '_'};
        private final boolean doPadding;
        private final boolean isURL;
        private final int linemax;
        private final byte[] newline;

        private Encoder(boolean z, byte[] bArr, int i, boolean z2) {
            this.isURL = z;
            this.newline = bArr;
            this.linemax = i;
            this.doPadding = z2;
        }

        static {
            byte[] bArr = {Ascii.CR, 10};
            CRLF = bArr;
            RFC4648 = new Encoder(false, null, -1, true);
            RFC4648_URLSAFE = new Encoder(true, null, -1, true);
            RFC2045 = new Encoder(false, bArr, 76, true);
        }

        private final int outLength(int i) {
            int i2;
            if (this.doPadding) {
                i2 = ((i + 2) / 3) * 4;
            } else {
                int i3 = i % 3;
                i2 = ((i / 3) * 4) + (i3 == 0 ? 0 : i3 + 1);
            }
            int i4 = this.linemax;
            return i4 > 0 ? i2 + (((i2 - 1) / i4) * this.newline.length) : i2;
        }

        public byte[] encode(byte[] bArr) {
            int iOutLength = outLength(bArr.length);
            byte[] bArr2 = new byte[iOutLength];
            int iEncode0 = encode0(bArr, 0, bArr.length, bArr2);
            return iEncode0 != iOutLength ? Arrays.copyOf(bArr2, iEncode0) : bArr2;
        }

        public String encodeToString(byte[] bArr) {
            byte[] bArrEncode = encode(bArr);
            return new String(bArrEncode, 0, 0, bArrEncode.length);
        }

        private void encodeBlock(byte[] bArr, int i, int i2, byte[] bArr2, int i3, boolean z) {
            char[] cArr = z ? toBase64URL : toBase64;
            while (i < i2) {
                int i4 = i + 2;
                int i5 = ((bArr[i + 1] & 255) << 8) | ((bArr[i] & 255) << 16);
                i += 3;
                int i6 = i5 | (bArr[i4] & 255);
                bArr2[i3] = (byte) cArr[(i6 >>> 18) & 63];
                bArr2[i3 + 1] = (byte) cArr[(i6 >>> 12) & 63];
                int i7 = i3 + 3;
                bArr2[i3 + 2] = (byte) cArr[(i6 >>> 6) & 63];
                i3 += 4;
                bArr2[i7] = (byte) cArr[i6 & 63];
            }
        }

        private int encode0(byte[] bArr, int i, int i2, byte[] bArr2) {
            char[] cArr = this.isURL ? toBase64URL : toBase64;
            int i3 = ((i2 - i) / 3) * 3;
            int i4 = i + i3;
            int i5 = this.linemax;
            if (i5 > 0 && i3 > (i5 / 4) * 3) {
                i3 = (i5 / 4) * 3;
            }
            int i6 = i;
            int i7 = 0;
            while (i6 < i4) {
                int iMin = Math.min(i6 + i3, i4);
                Encoder encoder = this;
                byte[] bArr3 = bArr;
                byte[] bArr4 = bArr2;
                encoder.encodeBlock(bArr3, i6, iMin, bArr4, i7, this.isURL);
                int i8 = ((iMin - i6) / 3) * 4;
                i7 += i8;
                if (i8 == encoder.linemax && iMin < i2) {
                    byte[] bArr5 = encoder.newline;
                    int length = bArr5.length;
                    int i9 = 0;
                    while (i9 < length) {
                        bArr4[i7] = bArr5[i9];
                        i9++;
                        i7++;
                    }
                }
                this = encoder;
                bArr = bArr3;
                i6 = iMin;
                bArr2 = bArr4;
            }
            Encoder encoder2 = this;
            byte[] bArr6 = bArr;
            byte[] bArr7 = bArr2;
            if (i6 >= i2) {
                return i7;
            }
            int i10 = i6 + 1;
            int i11 = bArr6[i6] & 255;
            int i12 = i7 + 1;
            bArr7[i7] = (byte) cArr[i11 >> 2];
            if (i10 == i2) {
                int i13 = i7 + 2;
                bArr7[i12] = (byte) cArr[(i11 << 4) & 63];
                if (!encoder2.doPadding) {
                    return i13;
                }
                int i14 = i7 + 3;
                bArr7[i13] = kotlin.io.encoding.Base64.padSymbol;
                int i15 = i7 + 4;
                bArr7[i14] = kotlin.io.encoding.Base64.padSymbol;
                return i15;
            }
            int i16 = bArr6[i10] & 255;
            bArr7[i12] = (byte) cArr[((i11 << 4) & 63) | (i16 >> 4)];
            int i17 = i7 + 3;
            bArr7[i7 + 2] = (byte) cArr[(i16 << 2) & 63];
            if (!encoder2.doPadding) {
                return i17;
            }
            int i18 = i7 + 4;
            bArr7[i17] = kotlin.io.encoding.Base64.padSymbol;
            return i18;
        }
    }
}
