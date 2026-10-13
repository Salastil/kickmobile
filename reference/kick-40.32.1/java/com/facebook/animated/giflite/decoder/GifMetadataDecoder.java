package com.facebook.animated.giflite.decoder;

import com.facebook.common.internal.Preconditions;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: loaded from: classes6.dex */
public class GifMetadataDecoder {
    private static final int CONTROL_INDEX_DELAY = 1;
    private static final int CONTROL_INDEX_DISPOSE = 0;
    private static final int DEFAULT_FRAME_DURATION_MS = 100;
    private static final int MAX_BLOCK_SIZE = 256;
    private static final char[] NETSCAPE = {'N', 'E', 'T', 'S', 'C', 'A', 'P', 'E', '2', FilenameUtils.EXTENSION_SEPARATOR, '0'};
    private final InputStream mInputStream;

    @Nullable
    private final OutputStream mOutputStream;
    private int screenHeight;
    private int screenWidth;
    private boolean shouldFixStream;
    private final byte[] block = new byte[256];
    private final List<int[]> mFrameControls = new ArrayList();
    private int mLoopCount = 1;
    private boolean mDecoded = false;
    private int mCurrentOffset = 0;

    public static GifMetadataDecoder create(InputStream inputStream, @Nullable OutputStream outputStream) throws IOException {
        GifMetadataDecoder gifMetadataDecoder = new GifMetadataDecoder(inputStream, outputStream);
        gifMetadataDecoder.decode();
        return gifMetadataDecoder;
    }

    private GifMetadataDecoder(InputStream inputStream, @Nullable OutputStream outputStream) {
        this.mInputStream = inputStream;
        this.mOutputStream = outputStream;
    }

    public void decode() throws IOException {
        if (this.mDecoded) {
            throw new IllegalStateException("decode called multiple times");
        }
        this.mDecoded = true;
        readGifInfo();
    }

    public int getScreenWidth() {
        if (!this.mDecoded) {
            throw new IllegalStateException("getScreenWidth called before decode");
        }
        return this.screenWidth;
    }

    public int getScreenHeight() {
        if (!this.mDecoded) {
            throw new IllegalStateException("getScreenHeight called before decode");
        }
        return this.screenHeight;
    }

    public int getFrameCount() {
        if (!this.mDecoded) {
            throw new IllegalStateException("getFrameCount called before decode");
        }
        return this.mFrameControls.size();
    }

    public int getLoopCount() {
        if (!this.mDecoded) {
            throw new IllegalStateException("getLoopCount called before decode");
        }
        return this.mLoopCount;
    }

    public int getFrameDisposal(int i) {
        if (!this.mDecoded) {
            throw new IllegalStateException("getFrameDisposal called before decode");
        }
        return this.mFrameControls.get(i)[0];
    }

    public int getFrameDurationMs(int i) {
        if (!this.mDecoded) {
            throw new IllegalStateException("getFrameDurationMs called before decode");
        }
        if (i >= getFrameCount()) {
            return 1;
        }
        return this.mFrameControls.get(i)[1];
    }

    private void readGifInfo() throws IOException {
        validateAndIgnoreHeader();
        boolean z = false;
        int[] iArr = {0, 0};
        while (!z) {
            int andWriteNextByte = readAndWriteNextByte();
            if (andWriteNextByte == 33) {
                int andWriteNextByte2 = readAndWriteNextByte();
                if (andWriteNextByte2 == 1) {
                    addFrame(iArr);
                    skipExtension();
                } else if (andWriteNextByte2 == 249) {
                    readGraphicsControlExtension(iArr);
                } else if (andWriteNextByte2 == 255) {
                    readBlock();
                    if (isNetscape()) {
                        readNetscapeExtension();
                    } else {
                        skipExtension();
                    }
                } else {
                    skipExtension();
                }
            } else if (andWriteNextByte == 44) {
                addFrame(iArr);
                skipImage();
            } else {
                if (andWriteNextByte != 59) {
                    throw new IOException("Unknown block header [" + Integer.toHexString(andWriteNextByte) + "]");
                }
                z = true;
            }
        }
    }

    private void addFrame(int[] iArr) {
        this.mFrameControls.add(Arrays.copyOf(iArr, iArr.length));
    }

    private void validateAndIgnoreHeader() throws IOException {
        readIntoBlock(0, 6);
        byte[] bArr = this.block;
        if ('G' == ((char) bArr[0]) && 'I' == ((char) bArr[1]) && 'F' == ((char) bArr[2]) && '8' == ((char) bArr[3])) {
            byte b = bArr[4];
            if (('7' == ((char) b) || '9' == ((char) b)) && 'a' == ((char) bArr[5])) {
                this.screenWidth = readAndWriteNextByte() | (readAndWriteNextByte() << 8);
                this.screenHeight = readAndWriteNextByte() | (readAndWriteNextByte() << 8);
                int andWriteNextByte = readAndWriteNextByte();
                boolean z = (andWriteNextByte & 128) != 0;
                int i = 2 << (andWriteNextByte & 7);
                skipAndWriteBytes(2);
                if (z) {
                    ignoreColorTable(i);
                    return;
                }
                return;
            }
        }
        throw new IOException("Illegal header for gif");
    }

    private void ignoreColorTable(int i) throws IOException {
        skipAndWriteBytes(i * 3);
    }

    private int readBlock() throws IOException {
        int andWriteNextByte = readAndWriteNextByte();
        int intoBlock = 0;
        if (andWriteNextByte > 0) {
            while (intoBlock < andWriteNextByte) {
                intoBlock += readIntoBlock(intoBlock, andWriteNextByte - intoBlock);
            }
        }
        return intoBlock;
    }

    private void skipExtension() throws IOException {
        while (readBlock() > 0) {
        }
    }

    private void skipImage() throws IOException {
        skipAndWriteBytes(8);
        int andWriteNextByte = readAndWriteNextByte();
        if ((andWriteNextByte & 128) != 0) {
            ignoreColorTable(2 << (andWriteNextByte & 7));
        }
        skipAndWriteBytes(1);
        skipExtension();
    }

    private boolean isNetscape() {
        int length = this.block.length;
        char[] cArr = NETSCAPE;
        if (length < cArr.length) {
            return false;
        }
        int length2 = cArr.length;
        for (int i = 0; i < length2; i++) {
            if (NETSCAPE[i] != ((char) this.block[i])) {
                return false;
            }
        }
        return true;
    }

    private void readNetscapeExtension() throws IOException {
        int block;
        do {
            block = readBlock();
            byte[] bArr = this.block;
            if (bArr[0] == 1) {
                this.mLoopCount = (bArr[1] & 255) | ((bArr[2] & 255) << 8);
            }
        } while (block > 0);
    }

    private void readGraphicsControlExtension(int[] iArr) throws IOException {
        skipAndWriteBytes(1);
        iArr[0] = (readAndWriteNextByte() & 28) >> 2;
        int twoByteInt = readTwoByteInt() * 10;
        iArr[1] = twoByteInt;
        if (twoByteInt == 0) {
            iArr[1] = 100;
            initFixedOutputStream();
        }
        writeTwoByteInt(iArr[1] / 10);
        skipAndWriteBytes(2);
    }

    private int readNextByte() throws IOException {
        int i = this.mInputStream.read();
        this.mCurrentOffset++;
        if (i != -1) {
            return i;
        }
        throw new EOFException("Unexpected end of gif file");
    }

    private int readTwoByteInt() throws IOException {
        return (readNextByte() << 8) | readNextByte();
    }

    private int readIntoBlock(int i, int i2) throws IOException {
        int i3 = this.mInputStream.read(this.block, i, i2);
        this.mCurrentOffset += i2;
        if (this.shouldFixStream) {
            ((OutputStream) Preconditions.checkNotNull(this.mOutputStream)).write(this.block, i, i2);
        }
        if (i3 != -1) {
            return i3;
        }
        throw new EOFException("Unexpected end of gif file");
    }

    private int readAndWriteNextByte() throws IOException {
        int nextByte = readNextByte();
        writeNextByte(nextByte);
        return nextByte;
    }

    private void writeNextByte(int i) throws IOException {
        if (this.shouldFixStream) {
            ((OutputStream) Preconditions.checkNotNull(this.mOutputStream, "OutputStream cannot be null when fixing stream")).write(i);
        }
    }

    private void writeTwoByteInt(int i) throws IOException {
        writeNextByte(i);
        writeNextByte(i >> 8);
    }

    private void skipAndWriteBytes(int i) throws IOException {
        boolean z = this.shouldFixStream;
        InputStream inputStream = this.mInputStream;
        if (z) {
            copyFromIsToOs(inputStream, this.mOutputStream, i);
        } else {
            inputStream.skip(i);
        }
        this.mCurrentOffset += i;
    }

    private void initFixedOutputStream() throws IOException {
        if (this.shouldFixStream || this.mOutputStream == null) {
            return;
        }
        this.shouldFixStream = true;
        this.mInputStream.reset();
        copyFromIsToOs(this.mInputStream, this.mOutputStream, this.mCurrentOffset - 2);
        this.mInputStream.skip(2L);
    }

    private void copyFromIsToOs(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
        while (i > 0) {
            int i2 = inputStream.read(this.block, 0, Math.min(256, i));
            i -= 256;
            outputStream.write(this.block, 0, i2);
        }
    }
}
