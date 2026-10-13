package com.fingerprintjs.android.fpjs_pro_internal;

import androidx.core.view.MotionEventCompat;
import com.google.common.base.Ascii;
import java.io.BufferedInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes6.dex */
public final class bx extends FilterInputStream {
    private final int D8871;
    private int N14263A23323;
    private int Y16199;
    private int cW27173;
    private int component10;
    private byte[] component13;
    private final int component5;
    private byte[] component8;
    private final int component9;
    private byte[] sG29839;
    private bw setPivotYN16904;
    private int[] setTopP6481;
    private int vD14832N6715;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final boolean markSupported() {
        return false;
    }

    public bx(InputStream inputStream, int[] iArr, byte[] bArr, int i, boolean z, int i2) throws IOException {
        this(inputStream, iArr, bArr, i, false, i2, (byte) 0);
    }

    private bx(InputStream inputStream, int[] iArr, byte[] bArr, int i, boolean z, int i2, byte b) throws IOException {
        super(new BufferedInputStream(inputStream, 4096));
        this.vD14832N6715 = 1;
        this.Y16199 = Integer.MAX_VALUE;
        int iMin = Math.min(Math.max(i, 3), 16);
        this.component9 = iMin;
        this.component13 = new byte[8];
        byte[] bArr2 = new byte[8];
        this.component8 = bArr2;
        this.sG29839 = new byte[8];
        this.setTopP6481 = new int[2];
        this.N14263A23323 = 8;
        this.cW27173 = 8;
        this.component10 = i2;
        if (i2 == 2) {
            System.arraycopy(bArr, 0, bArr2, 0, 8);
        }
        this.setPivotYN16904 = new bw(iArr, iMin, true, false);
        this.D8871 = 100;
        this.component5 = 100;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        vD14832N6715();
        int i = this.N14263A23323;
        if (i >= this.cW27173) {
            return -1;
        }
        byte[] bArr = this.component13;
        this.N14263A23323 = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = i + i2;
        for (int i4 = i; i4 < i3; i4++) {
            vD14832N6715();
            int i5 = this.N14263A23323;
            if (i5 >= this.cW27173) {
                if (i4 == i) {
                    return -1;
                }
                return i2 - (i3 - i4);
            }
            byte[] bArr2 = this.component13;
            this.N14263A23323 = i5 + 1;
            bArr[i4] = bArr2[i5];
        }
        return i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j) throws IOException {
        long j2 = 0;
        while (j2 < j && read() != -1) {
            j2++;
        }
        return j2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() throws IOException {
        vD14832N6715();
        return this.cW27173 - this.N14263A23323;
    }

    private void component9() {
        if (this.component10 == 2) {
            byte[] bArr = this.component13;
            System.arraycopy(bArr, 0, this.sG29839, 0, bArr.length);
        }
        byte[] bArr2 = this.component13;
        cd.component5(((bArr2[0] << Ascii.CAN) & (-16777216)) + ((bArr2[1] << Ascii.DLE) & 16711680) + ((bArr2[2] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) + (bArr2[3] & 255), ((-16777216) & (bArr2[4] << Ascii.CAN)) + (16711680 & (bArr2[5] << Ascii.DLE)) + (65280 & (bArr2[6] << 8)) + (bArr2[7] & 255), false, this.component9, this.setPivotYN16904.setPivotYN16904, this.setPivotYN16904.component5, this.setTopP6481);
        int[] iArr = this.setTopP6481;
        int i = iArr[0];
        int i2 = iArr[1];
        byte[] bArr3 = this.component13;
        bArr3[0] = (byte) (i >> 24);
        bArr3[1] = (byte) (i >> 16);
        bArr3[2] = (byte) (i >> 8);
        bArr3[3] = (byte) i;
        bArr3[4] = (byte) (i2 >> 24);
        bArr3[5] = (byte) (i2 >> 16);
        bArr3[6] = (byte) (i2 >> 8);
        bArr3[7] = (byte) i2;
        if (this.component10 == 2) {
            for (int i3 = 0; i3 < 8; i3++) {
                byte[] bArr4 = this.component13;
                bArr4[i3] = (byte) (bArr4[i3] ^ this.component8[i3]);
            }
            byte[] bArr5 = this.sG29839;
            System.arraycopy(bArr5, 0, this.component8, 0, bArr5.length);
        }
    }

    private int vD14832N6715() throws IOException {
        if (this.Y16199 == Integer.MAX_VALUE) {
            this.Y16199 = ((FilterInputStream) this).in.read();
        }
        if (this.N14263A23323 == 8) {
            byte[] bArr = this.component13;
            int i = this.Y16199;
            bArr[0] = (byte) i;
            if (i < 0) {
                throw new IllegalStateException("unexpected block size");
            }
            int i2 = 1;
            do {
                int i3 = ((FilterInputStream) this).in.read(this.component13, i2, 8 - i2);
                if (i3 <= 0) {
                    break;
                }
                i2 += i3;
            } while (i2 < 8);
            if (i2 < 8) {
                throw new IllegalStateException("unexpected block size");
            }
            int i4 = this.D8871;
            if (i4 == this.component5) {
                component9();
            } else {
                if (this.vD14832N6715 <= i4) {
                    component9();
                }
                int i5 = this.vD14832N6715;
                if (i5 < this.component5) {
                    this.vD14832N6715 = i5 + 1;
                } else {
                    this.vD14832N6715 = 1;
                }
            }
            int i6 = ((FilterInputStream) this).in.read();
            this.Y16199 = i6;
            this.N14263A23323 = 0;
            this.cW27173 = i6 < 0 ? 8 - (this.component13[7] & 255) : 8;
        }
        return this.cW27173;
    }
}
