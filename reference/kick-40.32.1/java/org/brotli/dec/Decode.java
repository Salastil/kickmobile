package org.brotli.dec;

/* JADX INFO: loaded from: classes11.dex */
final class Decode {
    private static final int CODE_LENGTH_CODES = 18;
    private static final int CODE_LENGTH_REPEAT_CODE = 16;
    private static final int DEFAULT_CODE_LENGTH = 8;
    private static final int DISTANCE_CONTEXT_BITS = 2;
    private static final int HUFFMAN_TABLE_BITS = 8;
    private static final int HUFFMAN_TABLE_MASK = 255;
    private static final int LITERAL_CONTEXT_BITS = 6;
    private static final int NUM_BLOCK_LENGTH_CODES = 26;
    private static final int NUM_DISTANCE_SHORT_CODES = 16;
    private static final int NUM_INSERT_AND_COPY_CODES = 704;
    private static final int NUM_LITERAL_CODES = 256;
    private static final int[] CODE_LENGTH_CODE_ORDER = {1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    private static final int[] DISTANCE_SHORT_CODE_INDEX_OFFSET = {3, 2, 1, 0, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2};
    private static final int[] DISTANCE_SHORT_CODE_VALUE_OFFSET = {0, 0, 0, 0, -1, 1, -2, 2, -3, 3, -1, 1, -2, 2, -3, 3};
    private static final int[] FIXED_TABLE = {131072, 131076, 131075, 196610, 131072, 131076, 131075, 262145, 131072, 131076, 131075, 196610, 131072, 131076, 131075, 262149};

    Decode() {
    }

    private static int decodeVarLenUnsignedByte(BitReader bitReader) {
        if (BitReader.readBits(bitReader, 1) == 0) {
            return 0;
        }
        int bits = BitReader.readBits(bitReader, 3);
        if (bits == 0) {
            return 1;
        }
        return BitReader.readBits(bitReader, bits) + (1 << bits);
    }

    private static void decodeMetaBlockLength(BitReader bitReader, State state) {
        state.inputEnd = BitReader.readBits(bitReader, 1) == 1;
        state.metaBlockLength = 0;
        state.isUncompressed = false;
        state.isMetadata = false;
        if (!state.inputEnd || BitReader.readBits(bitReader, 1) == 0) {
            int bits = BitReader.readBits(bitReader, 2) + 4;
            if (bits == 7) {
                state.isMetadata = true;
                if (BitReader.readBits(bitReader, 1) != 0) {
                    throw new BrotliRuntimeException("Corrupted reserved bit");
                }
                int bits2 = BitReader.readBits(bitReader, 2);
                if (bits2 == 0) {
                    return;
                }
                for (int i = 0; i < bits2; i++) {
                    int bits3 = BitReader.readBits(bitReader, 8);
                    if (bits3 == 0 && i + 1 == bits2 && bits2 > 1) {
                        throw new BrotliRuntimeException("Exuberant nibble");
                    }
                    state.metaBlockLength = (bits3 << (i * 8)) | state.metaBlockLength;
                }
            } else {
                for (int i2 = 0; i2 < bits; i2++) {
                    int bits4 = BitReader.readBits(bitReader, 4);
                    if (bits4 == 0 && i2 + 1 == bits && bits > 4) {
                        throw new BrotliRuntimeException("Exuberant nibble");
                    }
                    state.metaBlockLength = (bits4 << (i2 * 4)) | state.metaBlockLength;
                }
            }
            state.metaBlockLength++;
            if (state.inputEnd) {
                return;
            }
            state.isUncompressed = BitReader.readBits(bitReader, 1) == 1;
        }
    }

    private static int readSymbol(int[] iArr, int i, BitReader bitReader) {
        int i2 = (int) (bitReader.accumulator >>> bitReader.bitOffset);
        int i3 = i + (i2 & 255);
        int i4 = iArr[i3];
        int i5 = i4 >> 16;
        int i6 = i4 & 65535;
        if (i5 <= 8) {
            bitReader.bitOffset += i5;
            return i6;
        }
        int i7 = i3 + i6 + ((i2 & ((1 << i5) - 1)) >>> 8);
        bitReader.bitOffset += (iArr[i7] >> 16) + 8;
        return iArr[i7] & 65535;
    }

    private static int readBlockLength(int[] iArr, int i, BitReader bitReader) {
        BitReader.fillBitWindow(bitReader);
        int symbol = readSymbol(iArr, i, bitReader);
        return Prefix.BLOCK_LENGTH_OFFSET[symbol] + BitReader.readBits(bitReader, Prefix.BLOCK_LENGTH_N_BITS[symbol]);
    }

    private static int translateShortCodes(int i, int[] iArr, int i2) {
        return i < 16 ? iArr[(i2 + DISTANCE_SHORT_CODE_INDEX_OFFSET[i]) & 3] + DISTANCE_SHORT_CODE_VALUE_OFFSET[i] : i - 15;
    }

    private static void moveToFront(int[] iArr, int i) {
        int i2 = iArr[i];
        while (i > 0) {
            iArr[i] = iArr[i - 1];
            i--;
        }
        iArr[0] = i2;
    }

    private static void inverseMoveToFrontTransform(byte[] bArr, int i) {
        int[] iArr = new int[256];
        for (int i2 = 0; i2 < 256; i2++) {
            iArr[i2] = i2;
        }
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = bArr[i3] & 255;
            bArr[i3] = (byte) iArr[i4];
            if (i4 != 0) {
                moveToFront(iArr, i4);
            }
        }
    }

    private static void readHuffmanCodeLengths(int[] iArr, int i, int[] iArr2, BitReader bitReader) {
        int[] iArr3 = new int[32];
        Huffman.buildHuffmanTable(iArr3, 0, 5, iArr, 18);
        int i2 = 8;
        int i3 = 32768;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < i && i3 > 0) {
            BitReader.readMoreInput(bitReader);
            BitReader.fillBitWindow(bitReader);
            int i7 = ((int) (bitReader.accumulator >>> bitReader.bitOffset)) & 31;
            bitReader.bitOffset += iArr3[i7] >> 16;
            int i8 = iArr3[i7] & 65535;
            if (i8 < 16) {
                i4++;
                iArr2[i4] = i8;
                if (i8 != 0) {
                    i3 -= 32768 >> i8;
                    i2 = i8;
                }
                i6 = 0;
            } else {
                int i9 = i8 - 14;
                int i10 = i8 == 16 ? i2 : 0;
                if (i5 != i10) {
                    i6 = 0;
                    i5 = i10;
                }
                int bits = (i6 > 0 ? (i6 - 2) << i9 : i6) + BitReader.readBits(bitReader, i9) + 3;
                int i11 = bits - i6;
                if (i4 + i11 > i) {
                    throw new BrotliRuntimeException("symbol + repeatDelta > numSymbols");
                }
                int i12 = 0;
                while (i12 < i11) {
                    iArr2[i4] = i5;
                    i12++;
                    i4++;
                }
                if (i5 != 0) {
                    i3 -= i11 << (15 - i5);
                }
                i6 = bits;
            }
        }
        if (i3 != 0) {
            throw new BrotliRuntimeException("Unused space");
        }
        Utils.fillWithZeroes(iArr2, i4, i - i4);
    }

    /* JADX WARN: Code duplicated, block: B:54:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:56:0x00cf  */
    static void readHuffmanCode(int i, int[] iArr, int i2, BitReader bitReader) {
        int i3;
        int i4;
        int i5;
        BitReader.readMoreInput(bitReader);
        int[] iArr2 = new int[i];
        int bits = BitReader.readBits(bitReader, 2);
        boolean z = false;
        boolean z2 = true;
        if (bits == 1) {
            int i6 = i - 1;
            int[] iArr3 = new int[4];
            int bits2 = BitReader.readBits(bitReader, 2) + 1;
            int i7 = 0;
            while (i6 != 0) {
                i6 >>= 1;
                i7++;
            }
            for (int i8 = 0; i8 < bits2; i8++) {
                int bits3 = BitReader.readBits(bitReader, i7) % i;
                iArr3[i8] = bits3;
                iArr2[bits3] = 2;
            }
            iArr2[iArr3[0]] = 1;
            if (bits2 != 1) {
                if (bits2 == 2) {
                    int i9 = iArr3[0];
                    int i10 = iArr3[1];
                    z = i9 != i10;
                    iArr2[i10] = 1;
                } else if (bits2 == 3) {
                    int i11 = iArr3[0];
                    int i12 = iArr3[1];
                    if (i11 != i12 && i11 != (i3 = iArr3[2]) && i12 != i3) {
                        z = true;
                    }
                } else {
                    int i13 = iArr3[0];
                    int i14 = iArr3[1];
                    boolean z3 = (i13 == i14 || i13 == (i4 = iArr3[2]) || i13 == (i5 = iArr3[3]) || i14 == i4 || i14 == i5 || i4 == i5) ? false : true;
                    if (BitReader.readBits(bitReader, 1) == 1) {
                        iArr2[iArr3[2]] = 3;
                        iArr2[iArr3[3]] = 3;
                    } else {
                        iArr2[iArr3[0]] = 2;
                    }
                    z2 = z3;
                }
            }
            if (z2) {
                throw new BrotliRuntimeException("Can't readHuffmanCode");
            }
            Huffman.buildHuffmanTable(iArr, i2, 8, iArr2, i);
        }
        int[] iArr4 = new int[18];
        int i15 = 0;
        int i16 = 32;
        while (bits < 18 && i16 > 0) {
            int i17 = CODE_LENGTH_CODE_ORDER[bits];
            BitReader.fillBitWindow(bitReader);
            int i18 = ((int) (bitReader.accumulator >>> bitReader.bitOffset)) & 15;
            int i19 = bitReader.bitOffset;
            int[] iArr5 = FIXED_TABLE;
            bitReader.bitOffset = i19 + (iArr5[i18] >> 16);
            int i20 = iArr5[i18] & 65535;
            iArr4[i17] = i20;
            if (i20 != 0) {
                i16 -= 32 >> i20;
                i15++;
            }
            bits++;
        }
        z = i15 == 1 || i16 == 0;
        readHuffmanCodeLengths(iArr4, i, iArr2, bitReader);
        z2 = z;
        if (z2) {
            throw new BrotliRuntimeException("Can't readHuffmanCode");
        }
        Huffman.buildHuffmanTable(iArr, i2, 8, iArr2, i);
    }

    private static int decodeContextMap(int i, byte[] bArr, BitReader bitReader) {
        BitReader.readMoreInput(bitReader);
        int iDecodeVarLenUnsignedByte = decodeVarLenUnsignedByte(bitReader) + 1;
        if (iDecodeVarLenUnsignedByte == 1) {
            Utils.fillWithZeroes(bArr, 0, i);
            return iDecodeVarLenUnsignedByte;
        }
        int bits = BitReader.readBits(bitReader, 1) == 1 ? BitReader.readBits(bitReader, 4) + 1 : 0;
        int[] iArr = new int[1080];
        readHuffmanCode(iDecodeVarLenUnsignedByte + bits, iArr, 0, bitReader);
        int i2 = 0;
        while (i2 < i) {
            BitReader.readMoreInput(bitReader);
            BitReader.fillBitWindow(bitReader);
            int symbol = readSymbol(iArr, 0, bitReader);
            if (symbol == 0) {
                bArr[i2] = 0;
            } else if (symbol <= bits) {
                for (int bits2 = (1 << symbol) + BitReader.readBits(bitReader, symbol); bits2 != 0; bits2--) {
                    if (i2 >= i) {
                        throw new BrotliRuntimeException("Corrupted context map");
                    }
                    bArr[i2] = 0;
                    i2++;
                }
            } else {
                bArr[i2] = (byte) (symbol - bits);
            }
            i2++;
        }
        if (BitReader.readBits(bitReader, 1) == 1) {
            inverseMoveToFrontTransform(bArr, i);
        }
        return iDecodeVarLenUnsignedByte;
    }

    private static void decodeBlockTypeAndLength(State state, int i) {
        int i2;
        BitReader bitReader = state.br;
        int[] iArr = state.blockTypeRb;
        int i3 = i * 2;
        BitReader.fillBitWindow(bitReader);
        int i4 = i * 1080;
        int symbol = readSymbol(state.blockTypeTrees, i4, bitReader);
        state.blockLength[i] = readBlockLength(state.blockLenTrees, i4, bitReader);
        if (symbol == 1) {
            i2 = iArr[i3 + 1] + 1;
        } else {
            i2 = symbol == 0 ? iArr[i3] : symbol - 2;
        }
        if (i2 >= state.numBlockTypes[i]) {
            i2 -= state.numBlockTypes[i];
        }
        int i5 = i3 + 1;
        iArr[i3] = iArr[i5];
        iArr[i5] = i2;
    }

    private static void decodeLiteralBlockSwitch(State state) {
        decodeBlockTypeAndLength(state, 0);
        int i = state.blockTypeRb[1];
        state.contextMapSlice = i << 6;
        state.literalTreeIndex = state.contextMap[state.contextMapSlice] & 255;
        state.literalTree = state.hGroup0.trees[state.literalTreeIndex];
        byte b = state.contextModes[i];
        state.contextLookupOffset1 = Context.LOOKUP_OFFSETS[b];
        state.contextLookupOffset2 = Context.LOOKUP_OFFSETS[b + 1];
    }

    private static void decodeCommandBlockSwitch(State state) {
        decodeBlockTypeAndLength(state, 1);
        state.treeCommandOffset = state.hGroup1.trees[state.blockTypeRb[3]];
    }

    private static void decodeDistanceBlockSwitch(State state) {
        decodeBlockTypeAndLength(state, 2);
        state.distContextMapSlice = state.blockTypeRb[5] << 2;
    }

    private static void maybeReallocateRingBuffer(State state) {
        int i;
        int i2;
        int i3 = state.maxRingBufferSize;
        if (i3 > state.expectedTotalSize) {
            while (true) {
                int i4 = i3 >> 1;
                if (i4 <= ((int) state.expectedTotalSize) + state.customDictionary.length) {
                    break;
                } else {
                    i3 = i4;
                }
            }
            if (!state.inputEnd && i3 < 16384 && state.maxRingBufferSize >= 16384) {
                i3 = 16384;
            }
        }
        if (i3 <= state.ringBufferSize) {
            return;
        }
        byte[] bArr = new byte[i3 + 37];
        if (state.ringBuffer != null) {
            System.arraycopy(state.ringBuffer, 0, bArr, 0, state.ringBufferSize);
        } else if (state.customDictionary.length != 0) {
            int length = state.customDictionary.length;
            if (length > state.maxBackwardDistance) {
                i2 = length - state.maxBackwardDistance;
                i = state.maxBackwardDistance;
            } else {
                i = length;
                i2 = 0;
            }
            System.arraycopy(state.customDictionary, i2, bArr, 0, i);
            state.pos = i;
            state.bytesToIgnore = i;
        }
        state.ringBuffer = bArr;
        state.ringBufferSize = i3;
    }

    private static void readMetablockInfo(State state) {
        BitReader bitReader = state.br;
        if (state.inputEnd) {
            state.nextRunningState = 10;
            state.bytesToWrite = state.pos;
            state.bytesWritten = 0;
            state.runningState = 12;
            return;
        }
        state.hGroup0.codes = null;
        state.hGroup0.trees = null;
        state.hGroup1.codes = null;
        state.hGroup1.trees = null;
        state.hGroup2.codes = null;
        state.hGroup2.trees = null;
        BitReader.readMoreInput(bitReader);
        decodeMetaBlockLength(bitReader, state);
        if (state.metaBlockLength != 0 || state.isMetadata) {
            if (state.isUncompressed || state.isMetadata) {
                BitReader.jumpToByteBoundary(bitReader);
                state.runningState = state.isMetadata ? 4 : 5;
            } else {
                state.runningState = 2;
            }
            if (state.isMetadata) {
                return;
            }
            state.expectedTotalSize += (long) state.metaBlockLength;
            if (state.ringBufferSize < state.maxRingBufferSize) {
                maybeReallocateRingBuffer(state);
            }
        }
    }

    private static void readMetablockHuffmanCodesAndContextMaps(State state) {
        BitReader bitReader = state.br;
        for (int i = 0; i < 3; i++) {
            state.numBlockTypes[i] = decodeVarLenUnsignedByte(bitReader) + 1;
            state.blockLength[i] = 268435456;
            if (state.numBlockTypes[i] > 1) {
                int i2 = i * 1080;
                readHuffmanCode(state.numBlockTypes[i] + 2, state.blockTypeTrees, i2, bitReader);
                readHuffmanCode(26, state.blockLenTrees, i2, bitReader);
                state.blockLength[i] = readBlockLength(state.blockLenTrees, i2, bitReader);
            }
        }
        BitReader.readMoreInput(bitReader);
        state.distancePostfixBits = BitReader.readBits(bitReader, 2);
        state.numDirectDistanceCodes = (BitReader.readBits(bitReader, 4) << state.distancePostfixBits) + 16;
        state.distancePostfixMask = (1 << state.distancePostfixBits) - 1;
        int i3 = state.numDirectDistanceCodes + (48 << state.distancePostfixBits);
        state.contextModes = new byte[state.numBlockTypes[0]];
        int i4 = 0;
        while (i4 < state.numBlockTypes[0]) {
            int iMin = Math.min(i4 + 96, state.numBlockTypes[0]);
            while (i4 < iMin) {
                state.contextModes[i4] = (byte) (BitReader.readBits(bitReader, 2) << 1);
                i4++;
            }
            BitReader.readMoreInput(bitReader);
        }
        state.contextMap = new byte[state.numBlockTypes[0] << 6];
        int iDecodeContextMap = decodeContextMap(state.numBlockTypes[0] << 6, state.contextMap, bitReader);
        state.trivialLiteralContext = true;
        for (int i5 = 0; i5 < (state.numBlockTypes[0] << 6); i5++) {
            if (state.contextMap[i5] != (i5 >> 6)) {
                state.trivialLiteralContext = false;
                break;
            }
        }
        state.distContextMap = new byte[state.numBlockTypes[2] << 2];
        int iDecodeContextMap2 = decodeContextMap(state.numBlockTypes[2] << 2, state.distContextMap, bitReader);
        HuffmanTreeGroup.init(state.hGroup0, 256, iDecodeContextMap);
        HuffmanTreeGroup.init(state.hGroup1, NUM_INSERT_AND_COPY_CODES, state.numBlockTypes[1]);
        HuffmanTreeGroup.init(state.hGroup2, i3, iDecodeContextMap2);
        HuffmanTreeGroup.decode(state.hGroup0, bitReader);
        HuffmanTreeGroup.decode(state.hGroup1, bitReader);
        HuffmanTreeGroup.decode(state.hGroup2, bitReader);
        state.contextMapSlice = 0;
        state.distContextMapSlice = 0;
        state.contextLookupOffset1 = Context.LOOKUP_OFFSETS[state.contextModes[0]];
        state.contextLookupOffset2 = Context.LOOKUP_OFFSETS[state.contextModes[0] + 1];
        state.literalTreeIndex = 0;
        state.literalTree = state.hGroup0.trees[0];
        state.treeCommandOffset = state.hGroup1.trees[0];
        int[] iArr = state.blockTypeRb;
        int[] iArr2 = state.blockTypeRb;
        state.blockTypeRb[4] = 1;
        iArr2[2] = 1;
        iArr[0] = 1;
        int[] iArr3 = state.blockTypeRb;
        int[] iArr4 = state.blockTypeRb;
        state.blockTypeRb[5] = 0;
        iArr4[3] = 0;
        iArr3[1] = 0;
    }

    private static void copyUncompressedData(State state) {
        BitReader bitReader = state.br;
        byte[] bArr = state.ringBuffer;
        if (state.metaBlockLength <= 0) {
            BitReader.reload(bitReader);
            state.runningState = 1;
            return;
        }
        int iMin = Math.min(state.ringBufferSize - state.pos, state.metaBlockLength);
        BitReader.copyBytes(bitReader, bArr, state.pos, iMin);
        state.metaBlockLength -= iMin;
        state.pos += iMin;
        if (state.pos == state.ringBufferSize) {
            state.nextRunningState = 5;
            state.bytesToWrite = state.ringBufferSize;
            state.bytesWritten = 0;
            state.runningState = 12;
            return;
        }
        BitReader.reload(bitReader);
        state.runningState = 1;
    }

    private static boolean writeRingBuffer(State state) {
        if (state.bytesToIgnore != 0) {
            state.bytesWritten += state.bytesToIgnore;
            state.bytesToIgnore = 0;
        }
        int iMin = Math.min(state.outputLength - state.outputUsed, state.bytesToWrite - state.bytesWritten);
        if (iMin != 0) {
            System.arraycopy(state.ringBuffer, state.bytesWritten, state.output, state.outputOffset + state.outputUsed, iMin);
            state.outputUsed += iMin;
            state.bytesWritten += iMin;
        }
        return state.outputUsed < state.outputLength;
    }

    static void setCustomDictionary(State state, byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        state.customDictionary = bArr;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:100:0x02d1  */
    /* JADX WARN: Code duplicated, block: B:101:0x02d7  */
    /* JADX WARN: Code duplicated, block: B:103:0x02db  */
    /* JADX WARN: Code duplicated, block: B:106:0x02f0  */
    /* JADX WARN: Code duplicated, block: B:109:0x0306  */
    /* JADX WARN: Code duplicated, block: B:116:0x032f  */
    /* JADX WARN: Code duplicated, block: B:122:0x0360  */
    /* JADX WARN: Code duplicated, block: B:158:0x0369 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:159:0x0363 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:166:0x03a3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:169:0x03a3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:171:0x035b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:172:0x034f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:173:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:174:? A[LOOP:2: B:114:0x0329->B:174:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:176:0x018a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:177:? A[LOOP:3: B:52:0x0152->B:177:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:178:0x0204 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:179:0x0217 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:42:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:43:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:45:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:48:0x0116  */
    /* JADX WARN: Code duplicated, block: B:52:0x0152 A[LOOP:3: B:52:0x0152->B:177:?, LOOP_START] */
    /* JADX WARN: Code duplicated, block: B:54:0x0158  */
    /* JADX WARN: Code duplicated, block: B:56:0x0161  */
    /* JADX WARN: Code duplicated, block: B:61:0x019a  */
    /* JADX WARN: Code duplicated, block: B:64:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:66:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:70:0x020f A[LOOP:4: B:62:0x01aa->B:70:0x020f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:75:0x021f  */
    /* JADX WARN: Code duplicated, block: B:77:0x022a  */
    /* JADX WARN: Code duplicated, block: B:78:0x022e  */
    /* JADX WARN: Code duplicated, block: B:80:0x0232  */
    /* JADX WARN: Code duplicated, block: B:82:0x023b  */
    /* JADX WARN: Code duplicated, block: B:85:0x0259  */
    /* JADX WARN: Code duplicated, block: B:86:0x025b  */
    /* JADX WARN: Code duplicated, block: B:89:0x0272  */
    /* JADX WARN: Code duplicated, block: B:92:0x02b2  */
    /* JADX WARN: Code duplicated, block: B:94:0x02b8  */
    /* JADX WARN: Code duplicated, block: B:97:0x02c3  */
    /* JADX WARN: Multi-variable type inference failed */
    static void decompress(State state) {
        int i;
        int i2;
        int i3;
        int i4;
        char c;
        int symbol;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        if (state.runningState == 0) {
            throw new IllegalStateException("Can't decompress until initialized");
        }
        if (state.runningState == 11) {
            throw new IllegalStateException("Can't decompress after close");
        }
        BitReader bitReader = state.br;
        int i12 = 1;
        int i13 = state.ringBufferSize - 1;
        byte[] bArr = state.ringBuffer;
        while (state.runningState != 10) {
            int i14 = state.runningState;
            if (i14 != 12) {
                String str = "Invalid backward reference";
                char c2 = 2;
                int i15 = 0;
                switch (i14) {
                    case 1:
                        i = i12;
                        if (state.metaBlockLength < 0) {
                            throw new BrotliRuntimeException("Invalid metablock length");
                        }
                        readMetablockInfo(state);
                        i13 = state.ringBufferSize - 1;
                        bArr = state.ringBuffer;
                        break;
                        break;
                    case 2:
                        readMetablockHuffmanCodesAndContextMaps(state);
                        state.runningState = 3;
                        if (state.metaBlockLength <= 0) {
                            state.runningState = i12;
                            i = i12;
                        } else {
                            BitReader.readMoreInput(bitReader);
                            if (state.blockLength[i12] == 0) {
                                decodeCommandBlockSwitch(state);
                            }
                            int[] iArr = state.blockLength;
                            iArr[i12] = iArr[i12] - i12;
                            BitReader.fillBitWindow(bitReader);
                            int symbol2 = readSymbol(state.hGroup1.codes, state.treeCommandOffset, bitReader);
                            i2 = symbol2 >>> 6;
                            state.distanceCode = 0;
                            if (i2 >= 2) {
                                i2 -= 2;
                                state.distanceCode = -1;
                            }
                            int i16 = Prefix.INSERT_RANGE_LUT[i2] + ((symbol2 >>> 3) & 7);
                            int i17 = Prefix.COPY_RANGE_LUT[i2] + (symbol2 & 7);
                            state.insertLength = Prefix.INSERT_LENGTH_OFFSET[i16] + BitReader.readBits(bitReader, Prefix.INSERT_LENGTH_N_BITS[i16]);
                            state.copyLength = Prefix.COPY_LENGTH_OFFSET[i17] + BitReader.readBits(bitReader, Prefix.COPY_LENGTH_N_BITS[i17]);
                            state.j = 0;
                            state.runningState = 6;
                            if (state.trivialLiteralContext) {
                                while (state.j < state.insertLength) {
                                    BitReader.readMoreInput(bitReader);
                                    if (state.blockLength[0] == 0) {
                                        decodeLiteralBlockSwitch(state);
                                    }
                                    int[] iArr2 = state.blockLength;
                                    iArr2[0] = iArr2[0] - i12;
                                    BitReader.fillBitWindow(bitReader);
                                    bArr[state.pos] = (byte) readSymbol(state.hGroup0.codes, state.literalTree, bitReader);
                                    state.j += i12;
                                    i7 = state.pos;
                                    state.pos = i7 + 1;
                                    if (i7 == i13) {
                                        state.nextRunningState = 6;
                                        state.bytesToWrite = state.ringBufferSize;
                                        state.bytesWritten = 0;
                                        state.runningState = 12;
                                        i = i12;
                                        c = 2;
                                    }
                                }
                                i = i12;
                                c = 2;
                            } else {
                                i3 = bArr[(state.pos - i12) & i13] & 255;
                                i4 = bArr[(state.pos - 2) & i13] & 255;
                                while (true) {
                                    c = c2;
                                    if (state.j < state.insertLength) {
                                        BitReader.readMoreInput(bitReader);
                                        if (state.blockLength[0] == 0) {
                                            decodeLiteralBlockSwitch(state);
                                        }
                                        i = i12;
                                        int i18 = state.contextMap[state.contextMapSlice + (Context.LOOKUP[state.contextLookupOffset1 + i3] | Context.LOOKUP[state.contextLookupOffset2 + i4])] & 255;
                                        int[] iArr3 = state.blockLength;
                                        iArr3[0] = iArr3[0] - 1;
                                        BitReader.fillBitWindow(bitReader);
                                        symbol = readSymbol(state.hGroup0.codes, state.hGroup0.trees[i18], bitReader);
                                        bArr[state.pos] = (byte) symbol;
                                        state.j++;
                                        i5 = state.pos;
                                        state.pos = i5 + 1;
                                        if (i5 == i13) {
                                            state.nextRunningState = 6;
                                            state.bytesToWrite = state.ringBufferSize;
                                            state.bytesWritten = 0;
                                            state.runningState = 12;
                                        } else {
                                            i4 = i3;
                                            c2 = c;
                                            i3 = symbol;
                                            i12 = i;
                                        }
                                    } else {
                                        i = i12;
                                    }
                                }
                            }
                            if (state.runningState != 6) {
                                continue;
                            } else {
                                state.metaBlockLength -= state.insertLength;
                                if (state.metaBlockLength <= 0) {
                                    state.runningState = 3;
                                } else {
                                    if (state.distanceCode < 0) {
                                        BitReader.readMoreInput(bitReader);
                                        if (state.blockLength[c] == 0) {
                                            decodeDistanceBlockSwitch(state);
                                        }
                                        int[] iArr4 = state.blockLength;
                                        iArr4[c] = iArr4[c] - 1;
                                        BitReader.fillBitWindow(bitReader);
                                        int[] iArr5 = state.hGroup2.codes;
                                        int[] iArr6 = state.hGroup2.trees;
                                        byte[] bArr2 = state.distContextMap;
                                        int i19 = state.distContextMapSlice;
                                        if (state.copyLength > 4) {
                                            i6 = 3;
                                        } else {
                                            i6 = state.copyLength - 2;
                                        }
                                        state.distanceCode = readSymbol(iArr5, iArr6[bArr2[i19 + i6] & 255], bitReader);
                                        if (state.distanceCode >= state.numDirectDistanceCodes) {
                                            state.distanceCode -= state.numDirectDistanceCodes;
                                            int i20 = state.distanceCode & state.distancePostfixMask;
                                            state.distanceCode >>>= state.distancePostfixBits;
                                            int i21 = (state.distanceCode >>> 1) + 1;
                                            state.distanceCode = state.numDirectDistanceCodes + i20 + ((((((state.distanceCode & 1) + 2) << i21) - 4) + BitReader.readBits(bitReader, i21)) << state.distancePostfixBits);
                                        }
                                    }
                                    state.distance = translateShortCodes(state.distanceCode, state.distRb, state.distRbIdx);
                                    if (state.distance < 0) {
                                        throw new BrotliRuntimeException("Negative distance");
                                    }
                                    if (state.maxDistance == state.maxBackwardDistance && state.pos < state.maxBackwardDistance) {
                                        state.maxDistance = state.pos;
                                    } else {
                                        state.maxDistance = state.maxBackwardDistance;
                                    }
                                    state.copyDst = state.pos;
                                    if (state.distance > state.maxDistance) {
                                        state.runningState = 9;
                                    } else {
                                        if (state.distanceCode > 0) {
                                            state.distRb[state.distRbIdx & 3] = state.distance;
                                            state.distRbIdx++;
                                        }
                                        if (state.copyLength > state.metaBlockLength) {
                                            throw new BrotliRuntimeException(str);
                                        }
                                        state.j = 0;
                                        state.runningState = 7;
                                        i8 = (state.pos - state.distance) & i13;
                                        int i22 = state.pos;
                                        i9 = state.copyLength - state.j;
                                        if (i8 + i9 >= i13 && i22 + i9 < i13) {
                                            while (i15 < i9) {
                                                bArr[i22] = bArr[i8];
                                                i15++;
                                                i22++;
                                                i8++;
                                            }
                                            state.j += i9;
                                            state.metaBlockLength -= i9;
                                            state.pos += i9;
                                        } else {
                                            while (true) {
                                                if (state.j < state.copyLength) {
                                                    bArr[state.pos] = bArr[(state.pos - state.distance) & i13];
                                                    state.metaBlockLength--;
                                                    state.j++;
                                                    i10 = state.pos;
                                                    state.pos = i10 + 1;
                                                    if (i10 == i13) {
                                                        i11 = 7;
                                                        state.nextRunningState = 7;
                                                        state.bytesToWrite = state.ringBufferSize;
                                                        state.bytesWritten = 0;
                                                        state.runningState = 12;
                                                    }
                                                }
                                            }
                                            if (state.runningState == i11) {
                                                state.runningState = 3;
                                            }
                                        }
                                        i11 = 7;
                                        if (state.runningState == i11) {
                                            state.runningState = 3;
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    case 3:
                        if (state.metaBlockLength <= 0) {
                            state.runningState = i12;
                            i = i12;
                        } else {
                            BitReader.readMoreInput(bitReader);
                            if (state.blockLength[i12] == 0) {
                                decodeCommandBlockSwitch(state);
                            }
                            int[] iArr7 = state.blockLength;
                            iArr7[i12] = iArr7[i12] - i12;
                            BitReader.fillBitWindow(bitReader);
                            int symbol3 = readSymbol(state.hGroup1.codes, state.treeCommandOffset, bitReader);
                            i2 = symbol3 >>> 6;
                            state.distanceCode = 0;
                            if (i2 >= 2) {
                                i2 -= 2;
                                state.distanceCode = -1;
                            }
                            int i110 = Prefix.INSERT_RANGE_LUT[i2] + ((symbol3 >>> 3) & 7);
                            int i111 = Prefix.COPY_RANGE_LUT[i2] + (symbol3 & 7);
                            state.insertLength = Prefix.INSERT_LENGTH_OFFSET[i110] + BitReader.readBits(bitReader, Prefix.INSERT_LENGTH_N_BITS[i110]);
                            state.copyLength = Prefix.COPY_LENGTH_OFFSET[i111] + BitReader.readBits(bitReader, Prefix.COPY_LENGTH_N_BITS[i111]);
                            state.j = 0;
                            state.runningState = 6;
                            if (state.trivialLiteralContext) {
                                while (state.j < state.insertLength) {
                                    BitReader.readMoreInput(bitReader);
                                    if (state.blockLength[0] == 0) {
                                        decodeLiteralBlockSwitch(state);
                                    }
                                    int[] iArr8 = state.blockLength;
                                    iArr8[0] = iArr8[0] - i12;
                                    BitReader.fillBitWindow(bitReader);
                                    bArr[state.pos] = (byte) readSymbol(state.hGroup0.codes, state.literalTree, bitReader);
                                    state.j += i12;
                                    i7 = state.pos;
                                    state.pos = i7 + 1;
                                    if (i7 == i13) {
                                        state.nextRunningState = 6;
                                        state.bytesToWrite = state.ringBufferSize;
                                        state.bytesWritten = 0;
                                        state.runningState = 12;
                                        i = i12;
                                        c = 2;
                                    }
                                }
                                i = i12;
                                c = 2;
                            } else {
                                i3 = bArr[(state.pos - i12) & i13] & 255;
                                i4 = bArr[(state.pos - 2) & i13] & 255;
                                while (true) {
                                    c = c2;
                                    if (state.j < state.insertLength) {
                                        BitReader.readMoreInput(bitReader);
                                        if (state.blockLength[0] == 0) {
                                            decodeLiteralBlockSwitch(state);
                                        }
                                        i = i12;
                                        int i112 = state.contextMap[state.contextMapSlice + (Context.LOOKUP[state.contextLookupOffset1 + i3] | Context.LOOKUP[state.contextLookupOffset2 + i4])] & 255;
                                        int[] iArr9 = state.blockLength;
                                        iArr9[0] = iArr9[0] - 1;
                                        BitReader.fillBitWindow(bitReader);
                                        symbol = readSymbol(state.hGroup0.codes, state.hGroup0.trees[i112], bitReader);
                                        bArr[state.pos] = (byte) symbol;
                                        state.j++;
                                        i5 = state.pos;
                                        state.pos = i5 + 1;
                                        if (i5 == i13) {
                                            state.nextRunningState = 6;
                                            state.bytesToWrite = state.ringBufferSize;
                                            state.bytesWritten = 0;
                                            state.runningState = 12;
                                        } else {
                                            i4 = i3;
                                            c2 = c;
                                            i3 = symbol;
                                            i12 = i;
                                        }
                                    } else {
                                        i = i12;
                                    }
                                }
                            }
                            if (state.runningState != 6) {
                                continue;
                            } else {
                                state.metaBlockLength -= state.insertLength;
                                if (state.metaBlockLength <= 0) {
                                    state.runningState = 3;
                                } else {
                                    if (state.distanceCode < 0) {
                                        BitReader.readMoreInput(bitReader);
                                        if (state.blockLength[c] == 0) {
                                            decodeDistanceBlockSwitch(state);
                                        }
                                        int[] iArr10 = state.blockLength;
                                        iArr10[c] = iArr10[c] - 1;
                                        BitReader.fillBitWindow(bitReader);
                                        int[] iArr11 = state.hGroup2.codes;
                                        int[] iArr12 = state.hGroup2.trees;
                                        byte[] bArr3 = state.distContextMap;
                                        int i113 = state.distContextMapSlice;
                                        if (state.copyLength > 4) {
                                            i6 = 3;
                                        } else {
                                            i6 = state.copyLength - 2;
                                        }
                                        state.distanceCode = readSymbol(iArr11, iArr12[bArr3[i113 + i6] & 255], bitReader);
                                        if (state.distanceCode >= state.numDirectDistanceCodes) {
                                            state.distanceCode -= state.numDirectDistanceCodes;
                                            int i23 = state.distanceCode & state.distancePostfixMask;
                                            state.distanceCode >>>= state.distancePostfixBits;
                                            int i24 = (state.distanceCode >>> 1) + 1;
                                            state.distanceCode = state.numDirectDistanceCodes + i23 + ((((((state.distanceCode & 1) + 2) << i24) - 4) + BitReader.readBits(bitReader, i24)) << state.distancePostfixBits);
                                        }
                                    }
                                    state.distance = translateShortCodes(state.distanceCode, state.distRb, state.distRbIdx);
                                    if (state.distance < 0) {
                                        throw new BrotliRuntimeException("Negative distance");
                                    }
                                    if (state.maxDistance == state.maxBackwardDistance) {
                                        state.maxDistance = state.maxBackwardDistance;
                                    } else {
                                        state.maxDistance = state.maxBackwardDistance;
                                    }
                                    state.copyDst = state.pos;
                                    if (state.distance > state.maxDistance) {
                                        state.runningState = 9;
                                    } else {
                                        if (state.distanceCode > 0) {
                                            state.distRb[state.distRbIdx & 3] = state.distance;
                                            state.distRbIdx++;
                                        }
                                        if (state.copyLength > state.metaBlockLength) {
                                            throw new BrotliRuntimeException(str);
                                        }
                                        state.j = 0;
                                        state.runningState = 7;
                                        i8 = (state.pos - state.distance) & i13;
                                        int i25 = state.pos;
                                        i9 = state.copyLength - state.j;
                                        if (i8 + i9 >= i13) {
                                            while (true) {
                                                if (state.j < state.copyLength) {
                                                    bArr[state.pos] = bArr[(state.pos - state.distance) & i13];
                                                    state.metaBlockLength--;
                                                    state.j++;
                                                    i10 = state.pos;
                                                    state.pos = i10 + 1;
                                                    if (i10 == i13) {
                                                        i11 = 7;
                                                        state.nextRunningState = 7;
                                                        state.bytesToWrite = state.ringBufferSize;
                                                        state.bytesWritten = 0;
                                                        state.runningState = 12;
                                                    }
                                                } else {
                                                    i11 = 7;
                                                }
                                            }
                                        } else {
                                            while (true) {
                                                if (state.j < state.copyLength) {
                                                    bArr[state.pos] = bArr[(state.pos - state.distance) & i13];
                                                    state.metaBlockLength--;
                                                    state.j++;
                                                    i10 = state.pos;
                                                    state.pos = i10 + 1;
                                                    if (i10 == i13) {
                                                        i11 = 7;
                                                        state.nextRunningState = 7;
                                                        state.bytesToWrite = state.ringBufferSize;
                                                        state.bytesWritten = 0;
                                                        state.runningState = 12;
                                                    }
                                                } else {
                                                    i11 = 7;
                                                }
                                            }
                                        }
                                        if (state.runningState == i11) {
                                            state.runningState = 3;
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    case 4:
                        while (state.metaBlockLength > 0) {
                            BitReader.readMoreInput(bitReader);
                            BitReader.readBits(bitReader, 8);
                            state.metaBlockLength -= i12;
                        }
                        state.runningState = i12;
                        i = i12;
                        break;
                    case 5:
                        copyUncompressedData(state);
                        i = i12;
                        break;
                    case 6:
                        str = "Invalid backward reference";
                        if (state.trivialLiteralContext) {
                            while (state.j < state.insertLength) {
                                BitReader.readMoreInput(bitReader);
                                if (state.blockLength[0] == 0) {
                                    decodeLiteralBlockSwitch(state);
                                }
                                int[] iArr13 = state.blockLength;
                                iArr13[0] = iArr13[0] - i12;
                                BitReader.fillBitWindow(bitReader);
                                bArr[state.pos] = (byte) readSymbol(state.hGroup0.codes, state.literalTree, bitReader);
                                state.j += i12;
                                i7 = state.pos;
                                state.pos = i7 + 1;
                                if (i7 == i13) {
                                    state.nextRunningState = 6;
                                    state.bytesToWrite = state.ringBufferSize;
                                    state.bytesWritten = 0;
                                    state.runningState = 12;
                                    i = i12;
                                    c = 2;
                                }
                            }
                            i = i12;
                            c = 2;
                        } else {
                            i3 = bArr[(state.pos - i12) & i13] & 255;
                            i4 = bArr[(state.pos - 2) & i13] & 255;
                            while (true) {
                                c = c2;
                                if (state.j < state.insertLength) {
                                    BitReader.readMoreInput(bitReader);
                                    if (state.blockLength[0] == 0) {
                                        decodeLiteralBlockSwitch(state);
                                    }
                                    i = i12;
                                    int i114 = state.contextMap[state.contextMapSlice + (Context.LOOKUP[state.contextLookupOffset1 + i3] | Context.LOOKUP[state.contextLookupOffset2 + i4])] & 255;
                                    int[] iArr14 = state.blockLength;
                                    iArr14[0] = iArr14[0] - 1;
                                    BitReader.fillBitWindow(bitReader);
                                    symbol = readSymbol(state.hGroup0.codes, state.hGroup0.trees[i114], bitReader);
                                    bArr[state.pos] = (byte) symbol;
                                    state.j++;
                                    i5 = state.pos;
                                    state.pos = i5 + 1;
                                    if (i5 == i13) {
                                        state.nextRunningState = 6;
                                        state.bytesToWrite = state.ringBufferSize;
                                        state.bytesWritten = 0;
                                        state.runningState = 12;
                                    } else {
                                        i4 = i3;
                                        c2 = c;
                                        i3 = symbol;
                                        i12 = i;
                                    }
                                } else {
                                    i = i12;
                                }
                            }
                        }
                        if (state.runningState != 6) {
                            continue;
                        } else {
                            state.metaBlockLength -= state.insertLength;
                            if (state.metaBlockLength <= 0) {
                                state.runningState = 3;
                            } else {
                                if (state.distanceCode < 0) {
                                    BitReader.readMoreInput(bitReader);
                                    if (state.blockLength[c] == 0) {
                                        decodeDistanceBlockSwitch(state);
                                    }
                                    int[] iArr15 = state.blockLength;
                                    iArr15[c] = iArr15[c] - 1;
                                    BitReader.fillBitWindow(bitReader);
                                    int[] iArr16 = state.hGroup2.codes;
                                    int[] iArr17 = state.hGroup2.trees;
                                    byte[] bArr4 = state.distContextMap;
                                    int i115 = state.distContextMapSlice;
                                    if (state.copyLength > 4) {
                                        i6 = 3;
                                    } else {
                                        i6 = state.copyLength - 2;
                                    }
                                    state.distanceCode = readSymbol(iArr16, iArr17[bArr4[i115 + i6] & 255], bitReader);
                                    if (state.distanceCode >= state.numDirectDistanceCodes) {
                                        state.distanceCode -= state.numDirectDistanceCodes;
                                        int i26 = state.distanceCode & state.distancePostfixMask;
                                        state.distanceCode >>>= state.distancePostfixBits;
                                        int i27 = (state.distanceCode >>> 1) + 1;
                                        state.distanceCode = state.numDirectDistanceCodes + i26 + ((((((state.distanceCode & 1) + 2) << i27) - 4) + BitReader.readBits(bitReader, i27)) << state.distancePostfixBits);
                                    }
                                }
                                state.distance = translateShortCodes(state.distanceCode, state.distRb, state.distRbIdx);
                                if (state.distance < 0) {
                                    throw new BrotliRuntimeException("Negative distance");
                                }
                                if (state.maxDistance == state.maxBackwardDistance) {
                                    state.maxDistance = state.maxBackwardDistance;
                                } else {
                                    state.maxDistance = state.maxBackwardDistance;
                                }
                                state.copyDst = state.pos;
                                if (state.distance > state.maxDistance) {
                                    state.runningState = 9;
                                } else {
                                    if (state.distanceCode > 0) {
                                        state.distRb[state.distRbIdx & 3] = state.distance;
                                        state.distRbIdx++;
                                    }
                                    if (state.copyLength > state.metaBlockLength) {
                                        throw new BrotliRuntimeException(str);
                                    }
                                    state.j = 0;
                                    state.runningState = 7;
                                    i8 = (state.pos - state.distance) & i13;
                                    int i28 = state.pos;
                                    i9 = state.copyLength - state.j;
                                    if (i8 + i9 >= i13) {
                                        while (true) {
                                            if (state.j < state.copyLength) {
                                                bArr[state.pos] = bArr[(state.pos - state.distance) & i13];
                                                state.metaBlockLength--;
                                                state.j++;
                                                i10 = state.pos;
                                                state.pos = i10 + 1;
                                                if (i10 == i13) {
                                                    i11 = 7;
                                                    state.nextRunningState = 7;
                                                    state.bytesToWrite = state.ringBufferSize;
                                                    state.bytesWritten = 0;
                                                    state.runningState = 12;
                                                }
                                            } else {
                                                i11 = 7;
                                            }
                                        }
                                    } else {
                                        while (true) {
                                            if (state.j < state.copyLength) {
                                                bArr[state.pos] = bArr[(state.pos - state.distance) & i13];
                                                state.metaBlockLength--;
                                                state.j++;
                                                i10 = state.pos;
                                                state.pos = i10 + 1;
                                                if (i10 == i13) {
                                                    i11 = 7;
                                                    state.nextRunningState = 7;
                                                    state.bytesToWrite = state.ringBufferSize;
                                                    state.bytesWritten = 0;
                                                    state.runningState = 12;
                                                }
                                            } else {
                                                i11 = 7;
                                            }
                                        }
                                    }
                                    if (state.runningState == i11) {
                                        state.runningState = 3;
                                    }
                                }
                            }
                        }
                        break;
                    case 7:
                        i = i12;
                        i8 = (state.pos - state.distance) & i13;
                        int i29 = state.pos;
                        i9 = state.copyLength - state.j;
                        if (i8 + i9 >= i13) {
                            while (true) {
                                if (state.j < state.copyLength) {
                                    bArr[state.pos] = bArr[(state.pos - state.distance) & i13];
                                    state.metaBlockLength--;
                                    state.j++;
                                    i10 = state.pos;
                                    state.pos = i10 + 1;
                                    if (i10 == i13) {
                                        i11 = 7;
                                        state.nextRunningState = 7;
                                        state.bytesToWrite = state.ringBufferSize;
                                        state.bytesWritten = 0;
                                        state.runningState = 12;
                                    }
                                } else {
                                    i11 = 7;
                                }
                            }
                        } else {
                            while (true) {
                                if (state.j < state.copyLength) {
                                    bArr[state.pos] = bArr[(state.pos - state.distance) & i13];
                                    state.metaBlockLength--;
                                    state.j++;
                                    i10 = state.pos;
                                    state.pos = i10 + 1;
                                    if (i10 == i13) {
                                        i11 = 7;
                                        state.nextRunningState = 7;
                                        state.bytesToWrite = state.ringBufferSize;
                                        state.bytesWritten = 0;
                                        state.runningState = 12;
                                    }
                                } else {
                                    i11 = 7;
                                }
                            }
                        }
                        if (state.runningState == i11) {
                            state.runningState = 3;
                        }
                        break;
                    case 8:
                        System.arraycopy(bArr, state.ringBufferSize, bArr, 0, state.copyDst - state.ringBufferSize);
                        state.runningState = 3;
                        i = i12;
                        break;
                    case 9:
                        if (state.copyLength >= 4 && state.copyLength <= 24) {
                            int i30 = Dictionary.OFFSETS_BY_LENGTH[state.copyLength];
                            int i31 = (state.distance - state.maxDistance) - i12;
                            int i32 = Dictionary.SIZE_BITS_BY_LENGTH[state.copyLength];
                            int i33 = ((i12 << i32) - i12) & i31;
                            int i34 = i31 >>> i32;
                            int i35 = i30 + (i33 * state.copyLength);
                            if (i34 < Transform.TRANSFORMS.length) {
                                int iTransformDictionaryWord = Transform.transformDictionaryWord(bArr, state.copyDst, Dictionary.getData(), i35, state.copyLength, Transform.TRANSFORMS[i34]);
                                state.copyDst += iTransformDictionaryWord;
                                state.pos += iTransformDictionaryWord;
                                state.metaBlockLength -= iTransformDictionaryWord;
                                if (state.copyDst >= state.ringBufferSize) {
                                    state.nextRunningState = 8;
                                    state.bytesToWrite = state.ringBufferSize;
                                    state.bytesWritten = 0;
                                    state.runningState = 12;
                                } else {
                                    state.runningState = 3;
                                }
                                i = i12;
                            } else {
                                throw new BrotliRuntimeException("Invalid backward reference");
                            }
                        } else {
                            throw new BrotliRuntimeException("Invalid backward reference");
                        }
                        break;
                    default:
                        throw new BrotliRuntimeException("Unexpected state " + state.runningState);
                }
            } else {
                i = i12;
                if (!writeRingBuffer(state)) {
                    return;
                }
                if (state.pos >= state.maxBackwardDistance) {
                    state.maxDistance = state.maxBackwardDistance;
                }
                state.pos &= i13;
                state.runningState = state.nextRunningState;
            }
            i12 = i;
        }
        boolean z = i12;
        if (state.runningState == 10) {
            if (state.metaBlockLength < 0) {
                throw new BrotliRuntimeException("Invalid metablock length");
            }
            BitReader.jumpToByteBoundary(bitReader);
            BitReader.checkHealth(state.br, z);
        }
    }
}
