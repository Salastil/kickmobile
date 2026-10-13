package com.datadog.android.rum.internal.timeseries;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DataPoint.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\u000e\u0010\r\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\nJ(\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00028\u0000HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/datadog/android/rum/internal/timeseries/DataPoint;", ExifInterface.GPS_DIRECTION_TRUE, "", "timestampNs", "", "value", "(JLjava/lang/Object;)V", "getTimestampNs", "()J", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "copy", "(JLjava/lang/Object;)Lcom/datadog/android/rum/internal/timeseries/DataPoint;", "equals", "", "other", "hashCode", "", "toString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class DataPoint<T> {
    private final long timestampNs;
    private final T value;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DataPoint copy$default(DataPoint dataPoint, long j, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            j = dataPoint.timestampNs;
        }
        if ((i & 2) != 0) {
            obj = dataPoint.value;
        }
        return dataPoint.copy(j, obj);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getTimestampNs() {
        return this.timestampNs;
    }

    public final T component2() {
        return this.value;
    }

    public final DataPoint<T> copy(long timestampNs, T value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return new DataPoint<>(timestampNs, value);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DataPoint)) {
            return false;
        }
        DataPoint dataPoint = (DataPoint) other;
        return this.timestampNs == dataPoint.timestampNs && Intrinsics.areEqual(this.value, dataPoint.value);
    }

    public int hashCode() {
        return (Long.hashCode(this.timestampNs) * 31) + this.value.hashCode();
    }

    public String toString() {
        return "DataPoint(timestampNs=" + this.timestampNs + ", value=" + this.value + ")";
    }

    public DataPoint(long j, T value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.timestampNs = j;
        this.value = value;
    }

    public final long getTimestampNs() {
        return this.timestampNs;
    }

    public final T getValue() {
        return this.value;
    }
}
