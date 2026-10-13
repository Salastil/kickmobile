package com.datadog.android.core.internal.persistence.file.batch;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.storage.RawBatchEvent;
import com.datadog.android.core.internal.persistence.file.FileExtKt;
import com.datadog.android.internal.telemetry.TelemetryContext;
import expo.modules.notifications.service.NotificationsService;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlainBatchFileReaderWriter.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 *2\u00020\u0001:\u0003()*B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0002J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J(\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\bH\u0002J\u001e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\rH\u0017J&\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u001f2\u0006\u0010\f\u001a\u00020\rH\u0016J(\u0010$\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0017J\u001c\u0010%\u001a\u00020&*\u00020&2\u0006\u0010'\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u0015H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/datadog/android/core/internal/persistence/file/batch/PlainBatchFileReaderWriter;", "Lcom/datadog/android/core/internal/persistence/file/batch/BatchFileReaderWriter;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "(Lcom/datadog/android/api/InternalLogger;)V", "checkReadExpected", "", "expected", "", "actual", "operation", "", "telemetryContext", "Lcom/datadog/android/internal/telemetry/TelemetryContext;", "bytesLost", "lockFileAndWriteData", "", "file", "Ljava/io/File;", "append", "bytes", "", "readBlock", "Lcom/datadog/android/core/internal/persistence/file/batch/PlainBatchFileReaderWriter$BlockReadResult;", "stream", "Ljava/io/InputStream;", "expectedBlockType", "Lcom/datadog/android/core/internal/persistence/file/batch/PlainBatchFileReaderWriter$BlockType;", "remaining", "readData", "", "Lcom/datadog/android/api/storage/RawBatchEvent;", "readFileData", "inputLength", "serializeToBytes", "data", "writeBinaryData", "putAsTlv", "Ljava/nio/ByteBuffer;", "blockType", "BlockReadResult", "BlockType", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PlainBatchFileReaderWriter implements BatchFileReaderWriter {
    public static final String ERROR_READ = "Unable to read data from file.";
    public static final String ERROR_UNEXPECTED_BLOCK_TYPE_MET = "Unexpected block type identifier met";
    public static final String ERROR_UNEXPECTED_EOF = "Unexpected EOF";
    public static final String ERROR_UNEXPECTED_NUMBERS_OF_BYTES = "Number of bytes read doesn't match with expected";
    public static final String ERROR_WRITE = "Unable to write data to file.";
    public static final String ERROR_WRITE_FALLBACK = "Unable to restore file after failed write: %s";
    public static final int HEADER_SIZE_BYTES = 6;
    public static final int LENGTH_SIZE_BYTES = 4;
    public static final int TYPE_SIZE_BYTES = 2;
    public static final String WARNING_NOT_ALL_DATA_READ = "File %s is probably corrupted, not all content was read.";
    private final InternalLogger internalLogger;

    public PlainBatchFileReaderWriter(InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.internalLogger = internalLogger;
    }

    @Override // com.datadog.android.core.internal.persistence.file.batch.BatchFileReaderWriter
    public byte[] serializeToBytes(RawBatchEvent data, TelemetryContext telemetryContext) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(telemetryContext, "telemetryContext");
        byte[] metadata = data.getMetadata();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(metadata.length + 6 + data.getData().length + 6);
        Intrinsics.checkNotNullExpressionValue(byteBufferAllocate, "allocate(metaBlockSize + dataBlockSize)");
        byte[] bArrArray = putAsTlv(putAsTlv(byteBufferAllocate, BlockType.META, metadata), BlockType.EVENT, data.getData()).array();
        Intrinsics.checkNotNullExpressionValue(bArrArray, "allocate(metaBlockSize +…ata)\n            .array()");
        return bArrArray;
    }

    @Override // com.datadog.android.core.internal.persistence.file.batch.BatchFileReaderWriter
    public boolean writeBinaryData(File file, byte[] bytes, boolean append, TelemetryContext telemetryContext) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(telemetryContext, "telemetryContext");
        try {
            lockFileAndWriteData(file, append, bytes);
            return true;
        } catch (IOException e) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.persistence.file.batch.PlainBatchFileReaderWriter.writeBinaryData.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Unable to write data to file.";
                }
            }, (Throwable) e, false, (Map) telemetryContext.asAttributesMap(bytes.length, TuplesKt.to(TelemetryContext.TELEMETRY_FILE_PATH, file.getPath())), 16, (Object) null);
            return false;
        } catch (SecurityException e2) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.persistence.file.batch.PlainBatchFileReaderWriter.writeBinaryData.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Unable to write data to file.";
                }
            }, (Throwable) e2, false, (Map) telemetryContext.asAttributesMap(bytes.length, TuplesKt.to(TelemetryContext.TELEMETRY_FILE_PATH, file.getPath())), 16, (Object) null);
            return false;
        }
    }

    @Override // com.datadog.android.core.internal.persistence.file.batch.BatchFileReader
    public List<RawBatchEvent> readData(File file, TelemetryContext telemetryContext) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(telemetryContext, "telemetryContext");
        int iLengthSafe = (int) FileExtKt.lengthSafe(file, this.internalLogger);
        try {
            return readFileData(file, iLengthSafe, telemetryContext);
        } catch (IOException e) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.persistence.file.batch.PlainBatchFileReaderWriter.readData.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Unable to read data from file.";
                }
            }, (Throwable) e, false, (Map) telemetryContext.asAttributesMap(iLengthSafe, TuplesKt.to(TelemetryContext.TELEMETRY_FILE_PATH, file.getPath())), 16, (Object) null);
            return CollectionsKt.emptyList();
        } catch (SecurityException e2) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.persistence.file.batch.PlainBatchFileReaderWriter.readData.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Unable to read data from file.";
                }
            }, (Throwable) e2, false, (Map) telemetryContext.asAttributesMap(iLengthSafe, TuplesKt.to(TelemetryContext.TELEMETRY_FILE_PATH, file.getPath())), 16, (Object) null);
            return CollectionsKt.emptyList();
        }
    }

    private final void lockFileAndWriteData(final File file, boolean append, byte[] bytes) throws IOException {
        long size;
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        try {
            FileChannel channel = randomAccessFile.getChannel();
            FileLock fileLockLock = channel.lock();
            Intrinsics.checkNotNullExpressionValue(fileLockLock, "channel.lock()");
            if (append) {
                try {
                    size = channel.size();
                } catch (Throwable th) {
                    fileLockLock.release();
                    throw th;
                }
            } else {
                size = 0;
            }
            channel.truncate(size);
            channel.position(size);
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bytes);
            while (byteBufferWrap.hasRemaining()) {
                try {
                    channel.write(byteBufferWrap);
                } catch (IOException e) {
                    try {
                        channel.truncate(size);
                        throw e;
                    } catch (IOException e2) {
                        InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.persistence.file.batch.PlainBatchFileReaderWriter$lockFileAndWriteData$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                String str = String.format(Locale.US, PlainBatchFileReaderWriter.ERROR_WRITE_FALLBACK, Arrays.copyOf(new Object[]{file.getPath()}, 1));
                                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                                return str;
                            }
                        }, (Throwable) e2, false, (Map) null, 48, (Object) null);
                        throw e;
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
            fileLockLock.release();
            Unit unit2 = Unit.INSTANCE;
            CloseableKt.closeFinally(randomAccessFile, null);
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                CloseableKt.closeFinally(randomAccessFile, th2);
                throw th3;
            }
        }
    }

    private final List<RawBatchEvent> readFileData(final File file, int inputLength, TelemetryContext telemetryContext) throws IOException {
        ArrayList arrayList = new ArrayList();
        InputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = fileInputStream instanceof BufferedInputStream ? (BufferedInputStream) fileInputStream : new BufferedInputStream(fileInputStream, 8192);
        try {
            BufferedInputStream bufferedInputStream2 = bufferedInputStream;
            int bytesRead = inputLength;
            while (bytesRead > 0) {
                BlockReadResult block = readBlock(bufferedInputStream2, BlockType.META, telemetryContext, bytesRead);
                if (block.getData() == null) {
                    bytesRead -= block.getBytesRead();
                    break;
                }
                BlockReadResult block2 = readBlock(bufferedInputStream2, BlockType.EVENT, telemetryContext, bytesRead);
                bytesRead -= block.getBytesRead() + block2.getBytesRead();
                if (block2.getData() == null) {
                    break;
                }
                arrayList.add(new RawBatchEvent(block2.getData(), block.getData()));
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(bufferedInputStream, null);
            if (bytesRead == 0 && (inputLength <= 0 || !arrayList.isEmpty())) {
                return arrayList;
            }
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.USER, InternalLogger.Target.MAINTAINER}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.persistence.file.batch.PlainBatchFileReaderWriter.readFileData.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, PlainBatchFileReaderWriter.WARNING_NOT_ALL_DATA_READ, Arrays.copyOf(new Object[]{file.getPath()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return arrayList;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(bufferedInputStream, th);
                throw th2;
            }
        }
    }

    private final BlockReadResult readBlock(InputStream stream, BlockType expectedBlockType, TelemetryContext telemetryContext, int remaining) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(6);
        int i = stream.read(byteBufferAllocate.array());
        if (!checkReadExpected(6, i, "Block(" + expectedBlockType.name() + "): Header read", telemetryContext, remaining)) {
            return new BlockReadResult(null, Math.max(0, i));
        }
        short s = byteBufferAllocate.getShort();
        if (s != expectedBlockType.getIdentifier()) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.persistence.file.batch.PlainBatchFileReaderWriter.readBlock.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return PlainBatchFileReaderWriter.ERROR_UNEXPECTED_BLOCK_TYPE_MET;
                }
            }, (Throwable) null, false, (Map) telemetryContext.asAttributesMap(remaining, TuplesKt.to(TelemetryContext.TELEMETRY_BLOCK_TYPE_ACTUAL_IDENTIFIER, Short.valueOf(s)), TuplesKt.to(TelemetryContext.TELEMETRY_BLOCK_TYPE_EXPECTED_IDENTIFIER, Short.valueOf(expectedBlockType.getIdentifier())), TuplesKt.to(TelemetryContext.TELEMETRY_BLOCK_TYPE_EXPECTED, expectedBlockType.name())), 24, (Object) null);
            return new BlockReadResult(null, i);
        }
        int i2 = byteBufferAllocate.getInt();
        byte[] bArr = new byte[i2];
        int i3 = stream.read(bArr);
        if (checkReadExpected(i2, i3, "Block(" + expectedBlockType.name() + "):Data read", telemetryContext, remaining)) {
            return new BlockReadResult(bArr, i + i3);
        }
        return new BlockReadResult(null, i + Math.max(0, i3));
    }

    private final boolean checkReadExpected(int expected, int actual, String operation, TelemetryContext telemetryContext, int bytesLost) {
        if (expected == actual) {
            return true;
        }
        InternalLogger internalLogger = this.internalLogger;
        if (actual != -1) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.persistence.file.batch.PlainBatchFileReaderWriter.checkReadExpected.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return PlainBatchFileReaderWriter.ERROR_UNEXPECTED_NUMBERS_OF_BYTES;
                }
            }, (Throwable) null, false, (Map) telemetryContext.asAttributesMap(bytesLost, TuplesKt.to(TelemetryContext.TELEMETRY_BATCH_OPERATION, operation), TuplesKt.to(TelemetryContext.TELEMETRY_BATCH_BYTES_EXPECTED, Integer.valueOf(expected)), TuplesKt.to(TelemetryContext.TELEMETRY_BATCH_BYTES_ACTUAL, Integer.valueOf(actual))), 24, (Object) null);
        } else {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.persistence.file.batch.PlainBatchFileReaderWriter.checkReadExpected.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return PlainBatchFileReaderWriter.ERROR_UNEXPECTED_EOF;
                }
            }, (Throwable) null, false, (Map) telemetryContext.asAttributesMap(bytesLost, TuplesKt.to(TelemetryContext.TELEMETRY_BATCH_OPERATION, operation)), 24, (Object) null);
        }
        return false;
    }

    private final ByteBuffer putAsTlv(ByteBuffer byteBuffer, BlockType blockType, byte[] bArr) {
        ByteBuffer byteBufferPut = byteBuffer.putShort(blockType.getIdentifier()).putInt(bArr.length).put(bArr);
        Intrinsics.checkNotNullExpressionValue(byteBufferPut, "this\n            .putSho…e)\n            .put(data)");
        return byteBufferPut;
    }

    /* JADX INFO: compiled from: PlainBatchFileReaderWriter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/datadog/android/core/internal/persistence/file/batch/PlainBatchFileReaderWriter$BlockReadResult;", "", "data", "", "bytesRead", "", "([BI)V", "getBytesRead", "()I", "getData", "()[B", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class BlockReadResult {
        private final int bytesRead;
        private final byte[] data;

        public BlockReadResult(byte[] bArr, int i) {
            this.data = bArr;
            this.bytesRead = i;
        }

        public final byte[] getData() {
            return this.data;
        }

        public final int getBytesRead() {
            return this.bytesRead;
        }
    }

    /* JADX INFO: compiled from: PlainBatchFileReaderWriter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\n\n\u0002\b\u0006\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/datadog/android/core/internal/persistence/file/batch/PlainBatchFileReaderWriter$BlockType;", "", NotificationsService.IDENTIFIER_KEY, "", "(Ljava/lang/String;IS)V", "getIdentifier", "()S", "EVENT", "META", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private enum BlockType {
        EVENT(0),
        META(1);

        private final short identifier;

        BlockType(short s) {
            this.identifier = s;
        }

        public final short getIdentifier() {
            return this.identifier;
        }
    }
}
