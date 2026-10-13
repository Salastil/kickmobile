package com.datadog.android.internal.telemetry;

import com.datadog.android.webview.internal.MixedWebViewEventConsumer;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TelemetryContext.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005JM\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2,\b\u0002\u0010\r\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000f0\u000e\"\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\u0010\u0010J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\fHÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u001a"}, d2 = {"Lcom/datadog/android/internal/telemetry/TelemetryContext;", "", "featureName", "", MixedWebViewEventConsumer.EVENT_TYPE_KEY, "(Ljava/lang/String;Ljava/lang/String;)V", "getEventType", "()Ljava/lang/String;", "getFeatureName", "asAttributesMap", "", "bytesLost", "", "customFields", "", "Lkotlin/Pair;", "(I[Lkotlin/Pair;)Ljava/util/Map;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class TelemetryContext {
    public static final int BYTE_LOST_UNKNOWN = -1;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String EVENT_DROPPED_BYTES = "telemetry.dropped_bytes";
    public static final String EVENT_TYPE = "telemetry.event.type";
    public static final String FEATURE_NAME = "telemetry.feature_name";
    public static final String TELEMETRY_BATCH_BYTES_ACTUAL = "telemetry.batch.bytes_actual";
    public static final String TELEMETRY_BATCH_BYTES_EXPECTED = "telemetry.batch.bytes_expected";
    public static final String TELEMETRY_BATCH_OPERATION = "telemetry.batch.operation";
    public static final String TELEMETRY_BLOCK_TYPE_ACTUAL_IDENTIFIER = "telemetry.block.type.actual_identifier";
    public static final String TELEMETRY_BLOCK_TYPE_EXPECTED = "telemetry.block.type.expected";
    public static final String TELEMETRY_BLOCK_TYPE_EXPECTED_IDENTIFIER = "telemetry.block.type.expected_identifier";
    public static final String TELEMETRY_DATA_LIMIT = "telemetry.data.limit";
    public static final String TELEMETRY_FILE_PATH = "telemetry.file.path";
    public static final String TELEMETRY_TLV_DATA_LENGTH = "telemetry.tlv.data.length";
    public static final String TELEMETRY_TLV_DATA_LENGTH_LIMIT = "telemetry.tlv.data.limit";
    public static final String TELEMETRY_TLV_HEADER_LENGTH = "telemetry.tlv.header.length";
    public static final String TELEMETRY_TLV_HEADER_LENGTH_LIMIT = "telemetry.tlv.header.limit";
    public static final String TELEMETRY_TLV_SIZE = "telemetry.tlv.size";
    public static final String TELEMETRY_TLV_SIZE_LIMIT = "telemetry.tlv.limit";
    public static final String TELEMETRY_TLV_TYPE = "telemetry.tlv.type";
    private final String eventType;
    private final String featureName;

    public static /* synthetic */ TelemetryContext copy$default(TelemetryContext telemetryContext, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = telemetryContext.featureName;
        }
        if ((i & 2) != 0) {
            str2 = telemetryContext.eventType;
        }
        return telemetryContext.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFeatureName() {
        return this.featureName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getEventType() {
        return this.eventType;
    }

    public final TelemetryContext copy(String featureName, String eventType) {
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        return new TelemetryContext(featureName, eventType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TelemetryContext)) {
            return false;
        }
        TelemetryContext telemetryContext = (TelemetryContext) other;
        return Intrinsics.areEqual(this.featureName, telemetryContext.featureName) && Intrinsics.areEqual(this.eventType, telemetryContext.eventType);
    }

    public int hashCode() {
        int iHashCode = this.featureName.hashCode() * 31;
        String str = this.eventType;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "TelemetryContext(featureName=" + this.featureName + ", eventType=" + this.eventType + ")";
    }

    public TelemetryContext(String featureName, String str) {
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        this.featureName = featureName;
        this.eventType = str;
    }

    public /* synthetic */ TelemetryContext(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2);
    }

    public final String getFeatureName() {
        return this.featureName;
    }

    public final String getEventType() {
        return this.eventType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Map asAttributesMap$default(TelemetryContext telemetryContext, int i, Pair[] pairArr, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            pairArr = new Pair[0];
        }
        return telemetryContext.asAttributesMap(i, pairArr);
    }

    public final Map<String, Object> asAttributesMap(int bytesLost, Pair<String, ? extends Object>... customFields) {
        Intrinsics.checkNotNullParameter(customFields, "customFields");
        return INSTANCE.asAttributesMap(this.featureName, Integer.valueOf(bytesLost), this.eventType, (Pair[]) Arrays.copyOf(customFields, customFields.length));
    }

    /* JADX INFO: compiled from: TelemetryContext.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Je\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u00062\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00062,\b\u0002\u0010\u001d\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u001f0\u001e\"\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u001f¢\u0006\u0002\u0010 R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/datadog/android/internal/telemetry/TelemetryContext$Companion;", "", "()V", "BYTE_LOST_UNKNOWN", "", "EVENT_DROPPED_BYTES", "", "EVENT_TYPE", "FEATURE_NAME", "TELEMETRY_BATCH_BYTES_ACTUAL", "TELEMETRY_BATCH_BYTES_EXPECTED", "TELEMETRY_BATCH_OPERATION", "TELEMETRY_BLOCK_TYPE_ACTUAL_IDENTIFIER", "TELEMETRY_BLOCK_TYPE_EXPECTED", "TELEMETRY_BLOCK_TYPE_EXPECTED_IDENTIFIER", "TELEMETRY_DATA_LIMIT", "TELEMETRY_FILE_PATH", "TELEMETRY_TLV_DATA_LENGTH", "TELEMETRY_TLV_DATA_LENGTH_LIMIT", "TELEMETRY_TLV_HEADER_LENGTH", "TELEMETRY_TLV_HEADER_LENGTH_LIMIT", "TELEMETRY_TLV_SIZE", "TELEMETRY_TLV_SIZE_LIMIT", "TELEMETRY_TLV_TYPE", "asAttributesMap", "", "featureName", "bytesLost", MixedWebViewEventConsumer.EVENT_TYPE_KEY, "customFields", "", "Lkotlin/Pair;", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;[Lkotlin/Pair;)Ljava/util/Map;", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Map asAttributesMap$default(Companion companion, String str, Integer num, String str2, Pair[] pairArr, int i, Object obj) {
            if ((i & 2) != 0) {
                num = null;
            }
            if ((i & 4) != 0) {
                str2 = null;
            }
            if ((i & 8) != 0) {
                pairArr = new Pair[0];
            }
            return companion.asAttributesMap(str, num, str2, pairArr);
        }

        public final Map<String, Object> asAttributesMap(String featureName, Integer bytesLost, String eventType, Pair<String, ? extends Object>... customFields) {
            Intrinsics.checkNotNullParameter(featureName, "featureName");
            Intrinsics.checkNotNullParameter(customFields, "customFields");
            Map mapCreateMapBuilder = MapsKt.createMapBuilder();
            mapCreateMapBuilder.put(TelemetryContext.FEATURE_NAME, featureName);
            if (bytesLost != null) {
                mapCreateMapBuilder.put(TelemetryContext.EVENT_DROPPED_BYTES, Integer.valueOf(bytesLost.intValue()));
            }
            if (eventType != null) {
                mapCreateMapBuilder.put(TelemetryContext.EVENT_TYPE, eventType);
            }
            for (Pair<String, ? extends Object> pair : customFields) {
                mapCreateMapBuilder.put(pair.getFirst(), pair.getSecond());
            }
            return MapsKt.build(mapCreateMapBuilder);
        }
    }
}
