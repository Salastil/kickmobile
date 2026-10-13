package com.datadog.android.core.internal.persistence.tlvformat;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.internal.persistence.file.FileReaderWriter;
import com.datadog.android.core.internal.utils.ByteArrayExtKt;
import com.datadog.android.internal.telemetry.TelemetryContext;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.UShort;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TLVBlockFileReader.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ#\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0001¢\u0006\u0002\b\u0014J(\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J0\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J(\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/datadog/android/core/internal/persistence/tlvformat/TLVBlockFileReader;", "", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "fileReaderWriter", "Lcom/datadog/android/core/internal/persistence/file/FileReaderWriter;", "maxEntrySize", "", "(Lcom/datadog/android/api/InternalLogger;Lcom/datadog/android/core/internal/persistence/file/FileReaderWriter;I)V", "getFileReaderWriter", "()Lcom/datadog/android/core/internal/persistence/file/FileReaderWriter;", "getInternalLogger", "()Lcom/datadog/android/api/InternalLogger;", "read", "", "Lcom/datadog/android/core/internal/persistence/tlvformat/TLVBlock;", "file", "Ljava/io/File;", "telemetryContext", "Lcom/datadog/android/internal/telemetry/TelemetryContext;", "read$dd_sdk_android_core_release", "readBlock", "Lcom/datadog/android/core/internal/persistence/tlvformat/TLVBlockFileReader$TLVResult;", "inputArray", "", "currentIndex", "readData", "bytesLeft", "readType", "Lcom/datadog/android/core/internal/persistence/tlvformat/TLVBlockType;", "Companion", "TLVResult", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TLVBlockFileReader {
    public static final String WARN_CORRUPT_DATA_LENGTH_ERROR = "Data block length read from file is invalid or exceeds limit";
    public static final String WARN_CORRUPT_HEADER_LENGTH_ERROR = "Header block length read from file is invalid or exceeds limit";
    public static final String WARN_CORRUPT_TLV_HEADER_TYPE = "TLV header corrupt. Invalid type.";
    private final FileReaderWriter fileReaderWriter;
    private final InternalLogger internalLogger;
    private final int maxEntrySize;

    public TLVBlockFileReader(InternalLogger internalLogger, FileReaderWriter fileReaderWriter, int i) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(fileReaderWriter, "fileReaderWriter");
        this.internalLogger = internalLogger;
        this.fileReaderWriter = fileReaderWriter;
        this.maxEntrySize = i;
    }

    public /* synthetic */ TLVBlockFileReader(InternalLogger internalLogger, FileReaderWriter fileReaderWriter, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(internalLogger, fileReaderWriter, (i2 & 4) != 0 ? TLVBlock.MAXIMUM_DATA_SIZE_MB : i);
    }

    public final InternalLogger getInternalLogger() {
        return this.internalLogger;
    }

    public final FileReaderWriter getFileReaderWriter() {
        return this.fileReaderWriter;
    }

    public final List<TLVBlock> read$dd_sdk_android_core_release(File file, TelemetryContext telemetryContext) {
        TLVResult<TLVBlock> block;
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(telemetryContext, "telemetryContext");
        byte[] data = this.fileReaderWriter.readData(file, telemetryContext);
        ArrayList arrayList = new ArrayList();
        int newIndex = 0;
        while (newIndex < data.length && (block = readBlock(data, newIndex, telemetryContext)) != null) {
            arrayList.add(block.getData());
            newIndex = block.getNewIndex();
        }
        return arrayList;
    }

    private final TLVResult<TLVBlock> readBlock(byte[] inputArray, int currentIndex, TelemetryContext telemetryContext) {
        TLVResult<byte[]> data;
        TLVResult<TLVBlockType> type = readType(inputArray, currentIndex, telemetryContext);
        if (type == null || (data = readData(inputArray, type.getNewIndex(), inputArray.length - currentIndex, telemetryContext)) == null) {
            return null;
        }
        return new TLVResult<>(new TLVBlock(type.getData(), data.getData(), this.internalLogger), data.getNewIndex());
    }

    private final TLVResult<TLVBlockType> readType(byte[] inputArray, int currentIndex, TelemetryContext telemetryContext) {
        int i = currentIndex + 2;
        if (i > inputArray.length) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.USER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.persistence.tlvformat.TLVBlockFileReader.readType.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return TLVBlockFileReader.WARN_CORRUPT_HEADER_LENGTH_ERROR;
                }
            }, (Throwable) null, false, (Map) telemetryContext.asAttributesMap(inputArray.length - currentIndex, TuplesKt.to(TelemetryContext.TELEMETRY_TLV_HEADER_LENGTH, 2), TuplesKt.to(TelemetryContext.TELEMETRY_TLV_HEADER_LENGTH_LIMIT, Integer.valueOf(inputArray.length - currentIndex))), 24, (Object) null);
            return null;
        }
        short s = ByteArrayExtKt.toShort(ByteArrayExtKt.copyOfRangeSafe(inputArray, currentIndex, i));
        TLVBlockType tLVBlockTypeM11147fromValuexj2QHRw = TLVBlockType.INSTANCE.m11147fromValuexj2QHRw(UShort.m12974constructorimpl(s));
        if (tLVBlockTypeM11147fromValuexj2QHRw == null) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.persistence.tlvformat.TLVBlockFileReader.readType.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return TLVBlockFileReader.WARN_CORRUPT_TLV_HEADER_TYPE;
                }
            }, (Throwable) null, false, (Map) telemetryContext.asAttributesMap(inputArray.length - currentIndex, TuplesKt.to(TelemetryContext.TELEMETRY_TLV_TYPE, Short.valueOf(s))), 24, (Object) null);
            return null;
        }
        return new TLVResult<>(tLVBlockTypeM11147fromValuexj2QHRw, i);
    }

    private final TLVResult<byte[]> readData(byte[] inputArray, int currentIndex, int bytesLeft, TelemetryContext telemetryContext) {
        int i = currentIndex + 4;
        if (i > inputArray.length) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.USER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.persistence.tlvformat.TLVBlockFileReader.readData.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return TLVBlockFileReader.WARN_CORRUPT_DATA_LENGTH_ERROR;
                }
            }, (Throwable) null, false, (Map) telemetryContext.asAttributesMap(bytesLeft, TuplesKt.to(TelemetryContext.TELEMETRY_TLV_DATA_LENGTH, 4), TuplesKt.to(TelemetryContext.TELEMETRY_TLV_DATA_LENGTH_LIMIT, Integer.valueOf(inputArray.length - currentIndex))), 24, (Object) null);
            return null;
        }
        int i2 = ByteArrayExtKt.toInt(ByteArrayExtKt.copyOfRangeSafe(inputArray, currentIndex, i));
        if (i2 < 0 || i2 > this.maxEntrySize) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.USER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.persistence.tlvformat.TLVBlockFileReader.readData.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return TLVBlockFileReader.WARN_CORRUPT_DATA_LENGTH_ERROR;
                }
            }, (Throwable) null, false, (Map) telemetryContext.asAttributesMap(bytesLeft, TuplesKt.to(TelemetryContext.TELEMETRY_TLV_DATA_LENGTH, Integer.valueOf(i2)), TuplesKt.to(TelemetryContext.TELEMETRY_TLV_DATA_LENGTH_LIMIT, Integer.valueOf(this.maxEntrySize))), 24, (Object) null);
            return null;
        }
        int i3 = i + i2;
        if (i3 > inputArray.length) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.USER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.persistence.tlvformat.TLVBlockFileReader.readData.3
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return TLVBlockFileReader.WARN_CORRUPT_DATA_LENGTH_ERROR;
                }
            }, (Throwable) null, false, (Map) telemetryContext.asAttributesMap(bytesLeft, TuplesKt.to(TelemetryContext.TELEMETRY_TLV_DATA_LENGTH, Integer.valueOf(i2)), TuplesKt.to(TelemetryContext.TELEMETRY_TLV_DATA_LENGTH_LIMIT, Integer.valueOf(inputArray.length - i))), 24, (Object) null);
            return null;
        }
        return new TLVResult<>(ByteArrayExtKt.copyOfRangeSafe(inputArray, i, i3), i3);
    }

    /* JADX INFO: compiled from: TLVBlockFileReader.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\f\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0005HÆ\u0003J(\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/datadog/android/core/internal/persistence/tlvformat/TLVBlockFileReader$TLVResult;", ExifInterface.GPS_DIRECTION_TRUE, "", "data", "newIndex", "", "(Ljava/lang/Object;I)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getNewIndex", "()I", "component1", "component2", "copy", "(Ljava/lang/Object;I)Lcom/datadog/android/core/internal/persistence/tlvformat/TLVBlockFileReader$TLVResult;", "equals", "", "other", "hashCode", "toString", "", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final /* data */ class TLVResult<T> {
        private final T data;
        private final int newIndex;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ TLVResult copy$default(TLVResult tLVResult, Object obj, int i, int i2, Object obj2) {
            if ((i2 & 1) != 0) {
                obj = tLVResult.data;
            }
            if ((i2 & 2) != 0) {
                i = tLVResult.newIndex;
            }
            return tLVResult.copy(obj, i);
        }

        public final T component1() {
            return this.data;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getNewIndex() {
            return this.newIndex;
        }

        public final TLVResult<T> copy(T data, int newIndex) {
            Intrinsics.checkNotNullParameter(data, "data");
            return new TLVResult<>(data, newIndex);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TLVResult)) {
                return false;
            }
            TLVResult tLVResult = (TLVResult) other;
            return Intrinsics.areEqual(this.data, tLVResult.data) && this.newIndex == tLVResult.newIndex;
        }

        public int hashCode() {
            return (this.data.hashCode() * 31) + Integer.hashCode(this.newIndex);
        }

        public String toString() {
            return "TLVResult(data=" + this.data + ", newIndex=" + this.newIndex + ")";
        }

        public TLVResult(T data, int i) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
            this.newIndex = i;
        }

        public final T getData() {
            return this.data;
        }

        public final int getNewIndex() {
            return this.newIndex;
        }
    }
}
