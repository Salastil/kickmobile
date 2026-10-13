package com.datadog.android.flags.internal;

import androidx.collection.LruCache;
import com.datadog.android.flags.internal.storage.RecordWriter;
import com.datadog.android.flags.model.EvaluationContext;
import com.datadog.android.flags.model.ExposureEvent;
import com.datadog.android.flags.model.UnparsedFlag;
import com.datadog.android.internal.time.TimeProvider;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExposureEventsProcessor.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u001b2\u00020\u0001:\u0003\u0019\u001a\u001bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J \u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000eH\u0002R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/datadog/android/flags/internal/ExposureEventsProcessor;", "Lcom/datadog/android/flags/internal/EventsProcessor;", "writer", "Lcom/datadog/android/flags/internal/storage/RecordWriter;", "timeProvider", "Lcom/datadog/android/internal/time/TimeProvider;", "(Lcom/datadog/android/flags/internal/storage/RecordWriter;Lcom/datadog/android/internal/time/TimeProvider;)V", "exposuresSentCache", "Landroidx/collection/LruCache;", "Lcom/datadog/android/flags/internal/ExposureEventsProcessor$CacheKey;", "Lcom/datadog/android/flags/internal/ExposureEventsProcessor$CacheValue;", "getExposuresSentCache$annotations", "()V", "buildExposureEvent", "Lcom/datadog/android/flags/model/ExposureEvent;", "flagKey", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lcom/datadog/android/flags/model/EvaluationContext;", "data", "Lcom/datadog/android/flags/model/UnparsedFlag;", "processEvent", "", "writeExposureEvent", "record", "CacheKey", "CacheValue", "Companion", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ExposureEventsProcessor implements EventsProcessor {
    private static final int MAX_CACHE_ENTRIES = 5000;
    private final LruCache<CacheKey, CacheValue> exposuresSentCache;
    private final TimeProvider timeProvider;
    private final RecordWriter writer;

    private static /* synthetic */ void getExposuresSentCache$annotations() {
    }

    public ExposureEventsProcessor(RecordWriter writer, TimeProvider timeProvider) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        this.writer = writer;
        this.timeProvider = timeProvider;
        this.exposuresSentCache = new LruCache<>(5000);
    }

    /* JADX INFO: compiled from: ExposureEventsProcessor.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/datadog/android/flags/internal/ExposureEventsProcessor$CacheKey;", "", "targetingKey", "", "flagKey", "(Ljava/lang/String;Ljava/lang/String;)V", "getFlagKey", "()Ljava/lang/String;", "getTargetingKey", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final /* data */ class CacheKey {
        private final String flagKey;
        private final String targetingKey;

        public static /* synthetic */ CacheKey copy$default(CacheKey cacheKey, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = cacheKey.targetingKey;
            }
            if ((i & 2) != 0) {
                str2 = cacheKey.flagKey;
            }
            return cacheKey.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTargetingKey() {
            return this.targetingKey;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getFlagKey() {
            return this.flagKey;
        }

        public final CacheKey copy(String targetingKey, String flagKey) {
            Intrinsics.checkNotNullParameter(targetingKey, "targetingKey");
            Intrinsics.checkNotNullParameter(flagKey, "flagKey");
            return new CacheKey(targetingKey, flagKey);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CacheKey)) {
                return false;
            }
            CacheKey cacheKey = (CacheKey) other;
            return Intrinsics.areEqual(this.targetingKey, cacheKey.targetingKey) && Intrinsics.areEqual(this.flagKey, cacheKey.flagKey);
        }

        public int hashCode() {
            return (this.targetingKey.hashCode() * 31) + this.flagKey.hashCode();
        }

        public String toString() {
            return "CacheKey(targetingKey=" + this.targetingKey + ", flagKey=" + this.flagKey + ")";
        }

        public CacheKey(String targetingKey, String flagKey) {
            Intrinsics.checkNotNullParameter(targetingKey, "targetingKey");
            Intrinsics.checkNotNullParameter(flagKey, "flagKey");
            this.targetingKey = targetingKey;
            this.flagKey = flagKey;
        }

        public final String getTargetingKey() {
            return this.targetingKey;
        }

        public final String getFlagKey() {
            return this.flagKey;
        }
    }

    /* JADX INFO: compiled from: ExposureEventsProcessor.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000bJ.\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/datadog/android/flags/internal/ExposureEventsProcessor$CacheValue;", "", "allocationKey", "", "variationKey", "serialId", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "getAllocationKey", "()Ljava/lang/String;", "getSerialId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getVariationKey", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/datadog/android/flags/internal/ExposureEventsProcessor$CacheValue;", "equals", "", "other", "hashCode", "", "toString", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final /* data */ class CacheValue {
        private final String allocationKey;
        private final Long serialId;
        private final String variationKey;

        public static /* synthetic */ CacheValue copy$default(CacheValue cacheValue, String str, String str2, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                str = cacheValue.allocationKey;
            }
            if ((i & 2) != 0) {
                str2 = cacheValue.variationKey;
            }
            if ((i & 4) != 0) {
                l = cacheValue.serialId;
            }
            return cacheValue.copy(str, str2, l);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getAllocationKey() {
            return this.allocationKey;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getVariationKey() {
            return this.variationKey;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Long getSerialId() {
            return this.serialId;
        }

        public final CacheValue copy(String allocationKey, String variationKey, Long serialId) {
            Intrinsics.checkNotNullParameter(allocationKey, "allocationKey");
            Intrinsics.checkNotNullParameter(variationKey, "variationKey");
            return new CacheValue(allocationKey, variationKey, serialId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CacheValue)) {
                return false;
            }
            CacheValue cacheValue = (CacheValue) other;
            return Intrinsics.areEqual(this.allocationKey, cacheValue.allocationKey) && Intrinsics.areEqual(this.variationKey, cacheValue.variationKey) && Intrinsics.areEqual(this.serialId, cacheValue.serialId);
        }

        public int hashCode() {
            int iHashCode = ((this.allocationKey.hashCode() * 31) + this.variationKey.hashCode()) * 31;
            Long l = this.serialId;
            return iHashCode + (l == null ? 0 : l.hashCode());
        }

        public String toString() {
            return "CacheValue(allocationKey=" + this.allocationKey + ", variationKey=" + this.variationKey + ", serialId=" + this.serialId + ")";
        }

        public CacheValue(String allocationKey, String variationKey, Long l) {
            Intrinsics.checkNotNullParameter(allocationKey, "allocationKey");
            Intrinsics.checkNotNullParameter(variationKey, "variationKey");
            this.allocationKey = allocationKey;
            this.variationKey = variationKey;
            this.serialId = l;
        }

        public final String getAllocationKey() {
            return this.allocationKey;
        }

        public final String getVariationKey() {
            return this.variationKey;
        }

        public final Long getSerialId() {
            return this.serialId;
        }
    }

    @Override // com.datadog.android.flags.internal.EventsProcessor
    public void processEvent(String flagKey, EvaluationContext context, UnparsedFlag data) {
        Intrinsics.checkNotNullParameter(flagKey, "flagKey");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(data, "data");
        CacheKey cacheKey = new CacheKey(context.getTargetingKey(), flagKey);
        CacheValue cacheValue = new CacheValue(data.getAllocationKey(), data.getVariationKey(), data.getSerialId());
        synchronized (this.exposuresSentCache) {
            if (!Intrinsics.areEqual(this.exposuresSentCache.get(cacheKey), cacheValue)) {
                writeExposureEvent(buildExposureEvent(flagKey, context, data));
                this.exposuresSentCache.put(cacheKey, cacheValue);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final ExposureEvent buildExposureEvent(String flagKey, EvaluationContext context, UnparsedFlag data) {
        return new ExposureEvent(this.timeProvider.getDeviceTimestampMillis(), new ExposureEvent.Identifier(data.getAllocationKey()), new ExposureEvent.Identifier(flagKey), new ExposureEvent.Identifier(data.getVariationKey()), new ExposureEvent.Subject(context.getTargetingKey(), new ExposureEvent.Attributes(MapsKt.toMutableMap(context.getAttributes()))), data.getSerialId());
    }

    private final void writeExposureEvent(ExposureEvent record) {
        this.writer.write(record);
    }
}
