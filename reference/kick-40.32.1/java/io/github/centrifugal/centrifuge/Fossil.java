package io.github.centrifugal.centrifuge;

import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes9.dex */
class Fossil {
    private static final int[] zValue = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, 36, -1, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, -1, -1, -1, 63, -1};

    Fossil() {
    }

    static class Reader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private byte[] f458a;
        private int pos = 0;

        static /* synthetic */ int access$112(Reader reader, int i) {
            int i2 = reader.pos + i;
            reader.pos = i2;
            return i2;
        }

        public Reader(byte[] bArr) {
            this.f458a = bArr;
        }

        public boolean haveBytes() {
            return this.pos < this.f458a.length;
        }

        public int getByte() {
            int i = this.pos;
            byte[] bArr = this.f458a;
            if (i >= bArr.length) {
                throw new IndexOutOfBoundsException("out of bounds");
            }
            this.pos = i + 1;
            return bArr[i] & 255;
        }

        public char getChar() {
            return (char) getByte();
        }

        public int getInt() {
            int i;
            int i2 = 0;
            while (haveBytes() && (i = Fossil.zValue[getByte() & 127]) >= 0) {
                i2 = (i2 << 6) + i;
            }
            this.pos--;
            return i2;
        }
    }

    static class Writer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ByteArrayOutputStream f459a = new ByteArrayOutputStream();

        Writer() {
        }

        public byte[] toByteArray() {
            return this.f459a.toByteArray();
        }

        public void putArray(byte[] bArr, int i, int i2) {
            if (i < 0 || i2 > bArr.length || i > i2) {
                throw new IndexOutOfBoundsException("Invalid start or end index");
            }
            this.f459a.write(bArr, i, i2 - i);
        }
    }

    public static long checksum(byte[] bArr) {
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (length >= 16) {
            int i6 = i + (bArr[i2] & 255);
            int i7 = i3 + (bArr[i2 + 1] & 255);
            int i8 = i4 + (bArr[i2 + 2] & 255);
            int i9 = i5 + (bArr[i2 + 3] & 255);
            int i10 = i6 + (bArr[i2 + 4] & 255);
            int i11 = i7 + (bArr[i2 + 5] & 255);
            int i12 = i8 + (bArr[i2 + 6] & 255);
            int i13 = i9 + (bArr[i2 + 7] & 255);
            int i14 = i10 + (bArr[i2 + 8] & 255);
            int i15 = i11 + (bArr[i2 + 9] & 255);
            int i16 = i12 + (bArr[i2 + 10] & 255);
            int i17 = i13 + (bArr[i2 + 11] & 255);
            i = i14 + (bArr[i2 + 12] & 255);
            i3 = i15 + (bArr[i2 + 13] & 255);
            i4 = i16 + (bArr[i2 + 14] & 255);
            i5 = i17 + (bArr[i2 + 15] & 255);
            i2 += 16;
            length -= 16;
        }
        while (length >= 4) {
            i += bArr[i2] & 255;
            i3 += bArr[i2 + 1] & 255;
            i4 += bArr[i2 + 2] & 255;
            i5 += bArr[i2 + 3] & 255;
            i2 += 4;
            length -= 4;
        }
        int i18 = i5 + (i4 << 8) + (i3 << 16) + (i << 24);
        if (length != 1) {
            if (length != 2) {
                if (length == 3) {
                    i18 += (bArr[i2 + 2] & 255) << 8;
                }
            }
            i18 += (bArr[i2 + 1] & 255) << 16;
            i18 += (bArr[i2] & 255) << 24;
        } else {
            i18 += (bArr[i2] & 255) << 24;
        }
        return ((long) i18) & 4294967295L;
    }

    public static byte[] applyDelta(byte[] bArr, byte[] bArr2) throws Exception {
        Reader reader = new Reader(bArr2);
        int length = bArr.length;
        int length2 = bArr2.length;
        int i = reader.getInt();
        if (reader.getChar() != '\n') {
            throw new Exception("size integer not terminated by '\\n'");
        }
        Writer writer = new Writer();
        int i2 = 0;
        while (reader.haveBytes()) {
            int i3 = reader.getInt();
            char c = reader.getChar();
            if (c == ':') {
                i2 += i3;
                if (i2 <= i) {
                    if (i3 <= length2 - reader.pos) {
                        writer.putArray(reader.f458a, reader.pos, reader.pos + i3);
                        Reader.access$112(reader, i3);
                    } else {
                        throw new Exception("insert count exceeds size of delta");
                    }
                } else {
                    throw new Exception("insert command gives an output larger than predicted");
                }
            } else {
                if (c == ';') {
                    byte[] byteArray = writer.toByteArray();
                    if (i3 != ((int) checksum(byteArray))) {
                        throw new Exception("bad checksum");
                    }
                    if (i2 == i) {
                        return byteArray;
                    }
                    throw new Exception("generated size does not match predicted size");
                }
                if (c == '@') {
                    int i4 = reader.getInt();
                    if (reader.haveBytes() && reader.getChar() != ',') {
                        throw new Exception("copy command not terminated by ','");
                    }
                    i2 += i3;
                    if (i2 > i) {
                        throw new Exception("copy exceeds output file size");
                    }
                    int i5 = i3 + i4;
                    if (i5 > length) {
                        throw new Exception("copy extends past end of input");
                    }
                    writer.putArray(bArr, i4, i5);
                } else {
                    throw new Exception("unknown delta operator");
                }
            }
        }
        throw new Exception("unterminated delta");
    }
}
