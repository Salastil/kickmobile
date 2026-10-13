package com.datadog.android.core.internal.persistence.tlvformat;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.internal.telemetry.TelemetryContext;
import java.nio.ByteBuffer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TLVBlock.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ!\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/datadog/android/core/internal/persistence/tlvformat/TLVBlock;", "", "type", "Lcom/datadog/android/core/internal/persistence/tlvformat/TLVBlockType;", "data", "", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "(Lcom/datadog/android/core/internal/persistence/tlvformat/TLVBlockType;[BLcom/datadog/android/api/InternalLogger;)V", "getData", "()[B", "getInternalLogger", "()Lcom/datadog/android/api/InternalLogger;", "getType", "()Lcom/datadog/android/core/internal/persistence/tlvformat/TLVBlockType;", "serialize", "telemetryContext", "Lcom/datadog/android/internal/telemetry/TelemetryContext;", "maxEntrySize", "", "serialize$dd_sdk_android_core_release", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TLVBlock {
    public static final String BYTE_LENGTH_EXCEEDED_ERROR = "DataBlock length exceeds limit.";
    public static final int MAXIMUM_DATA_SIZE_MB = 10485760;
    private final byte[] data;
    private final InternalLogger internalLogger;
    private final TLVBlockType type;

    public TLVBlock(TLVBlockType type, byte[] data, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.type = type;
        this.data = data;
        this.internalLogger = internalLogger;
    }

    public final TLVBlockType getType() {
        return this.type;
    }

    public final byte[] getData() {
        return this.data;
    }

    public final InternalLogger getInternalLogger() {
        return this.internalLogger;
    }

    public static /* synthetic */ byte[] serialize$dd_sdk_android_core_release$default(TLVBlock tLVBlock, TelemetryContext telemetryContext, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = MAXIMUM_DATA_SIZE_MB;
        }
        return tLVBlock.serialize$dd_sdk_android_core_release(telemetryContext, i);
    }

    public final byte[] serialize$dd_sdk_android_core_release(TelemetryContext telemetryContext, int maxEntrySize) {
        Intrinsics.checkNotNullParameter(telemetryContext, "telemetryContext");
        byte[] bArr = this.data;
        if (bArr.length == 0) {
            return null;
        }
        int length = bArr.length;
        int i = 6 + length;
        if (i > maxEntrySize) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.USER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.persistence.tlvformat.TLVBlock$serialize$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return TLVBlock.BYTE_LENGTH_EXCEEDED_ERROR;
                }
            }, (Throwable) null, false, (Map) telemetryContext.asAttributesMap(i, TuplesKt.to(TelemetryContext.TELEMETRY_TLV_SIZE_LIMIT, Integer.valueOf(maxEntrySize)), TuplesKt.to(TelemetryContext.TELEMETRY_TLV_SIZE, Integer.valueOf(i)), TuplesKt.to(TelemetryContext.TELEMETRY_TLV_TYPE, this.type)), 24, (Object) null);
            return null;
        }
        return ByteBuffer.allocate(i).putShort(this.type.getRawValue()).putInt(length).put(this.data).array();
    }
}
