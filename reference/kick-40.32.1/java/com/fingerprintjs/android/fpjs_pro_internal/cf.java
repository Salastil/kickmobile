package com.fingerprintjs.android.fpjs_pro_internal;

import androidx.collection.SieveCacheKt;
import java.io.BufferedInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes6.dex */
public final class cf extends FilterInputStream {
    private final int D8871;
    private long[] N14263A23323;
    private int component13;
    private final int component5;
    private short component8;
    private long[] component9;
    private int rP23717;
    private int sG29839;
    private final int setPivotYN16904;
    private byte[] setTopP6481;
    private int vD14832N6715;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final boolean markSupported() {
        return false;
    }

    public cf(InputStream inputStream, int i, int i2, short s, int i3, int i4) throws IOException {
        this(inputStream, i, i2, s, i3, i4, (byte) 0);
    }

    private cf(InputStream inputStream, int i, int i2, short s, int i3, int i4, byte b) throws IOException {
        super(new BufferedInputStream(inputStream, 4096));
        this.vD14832N6715 = 1;
        this.sG29839 = Integer.MAX_VALUE;
        int iMin = Math.min(Math.max((int) s, 4), 8);
        this.D8871 = iMin;
        this.setTopP6481 = new byte[iMin];
        this.component9 = new long[4];
        this.N14263A23323 = new long[4];
        this.component13 = iMin;
        this.rP23717 = iMin;
        this.component9 = cc.component9(i ^ i4, iMin ^ i4);
        this.N14263A23323 = cc.component9(i2 ^ i4, i3 ^ i4);
        this.component5 = 100;
        this.setPivotYN16904 = 100;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        setPivotYN16904();
        int i = this.component13;
        if (i >= this.rP23717) {
            return -1;
        }
        byte[] bArr = this.setTopP6481;
        this.component13 = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = i + i2;
        for (int i4 = i; i4 < i3; i4++) {
            setPivotYN16904();
            int i5 = this.component13;
            if (i5 >= this.rP23717) {
                if (i4 == i) {
                    return -1;
                }
                return i2 - (i3 - i4);
            }
            byte[] bArr2 = this.setTopP6481;
            this.component13 = i5 + 1;
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
        setPivotYN16904();
        return this.rP23717 - this.component13;
    }

    private void component9() {
        long[] jArr = this.component9;
        long[] jArr2 = this.N14263A23323;
        short s = this.component8;
        long j = jArr[s % 4] * 2147483085;
        long j2 = jArr2[(s + 2) % 4];
        long j3 = (j + j2) % SieveCacheKt.NodeLinkMask;
        int i = (s + 3) % 4;
        jArr2[i] = ((jArr[i] * 2147483085) + j2) / SieveCacheKt.NodeLinkMask;
        jArr[i] = j3;
        for (int i2 = 0; i2 < this.D8871; i2++) {
            byte[] bArr = this.setTopP6481;
            bArr[i2] = (byte) (((long) bArr[i2]) ^ ((this.component9[this.component8] >> (i2 << 3)) & 255));
        }
        this.component8 = (short) ((this.component8 + 1) % 4);
    }

    private int setPivotYN16904() throws IOException {
        if (this.sG29839 == Integer.MAX_VALUE) {
            this.sG29839 = ((FilterInputStream) this).in.read();
        }
        if (this.component13 == this.D8871) {
            byte[] bArr = this.setTopP6481;
            int i = this.sG29839;
            bArr[0] = (byte) i;
            if (i < 0) {
                throw new IllegalStateException("unexpected block size");
            }
            int i2 = 1;
            do {
                int i3 = ((FilterInputStream) this).in.read(this.setTopP6481, i2, this.D8871 - i2);
                if (i3 <= 0) {
                    break;
                }
                i2 += i3;
            } while (i2 < this.D8871);
            if (i2 < this.D8871) {
                throw new IllegalStateException("unexpected block size");
            }
            int i4 = this.component5;
            if (i4 == this.setPivotYN16904) {
                component9();
            } else {
                if (this.vD14832N6715 <= i4) {
                    component9();
                }
                int i5 = this.vD14832N6715;
                if (i5 < this.setPivotYN16904) {
                    this.vD14832N6715 = i5 + 1;
                } else {
                    this.vD14832N6715 = 1;
                }
            }
            int i6 = ((FilterInputStream) this).in.read();
            this.sG29839 = i6;
            this.component13 = 0;
            int i7 = this.D8871;
            if (i6 < 0) {
                i7 -= this.setTopP6481[i7 - 1] & 255;
            }
            this.rP23717 = i7;
        }
        return this.rP23717;
    }
}
