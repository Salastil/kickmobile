package com.datadog.android.rum.internal.timeseries.provider;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.internal.time.TimeProvider;
import com.datadog.android.rum.internal.timeseries.DataPoint;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DataPointsReader.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000bH\u0017J\u000f\u0010\f\u001a\u0004\u0018\u00018\u0000H%¢\u0006\u0002\u0010\rR\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/datadog/android/rum/internal/timeseries/provider/DataPointsReader;", ExifInterface.GPS_DIRECTION_TRUE, "", "timeProvider", "Lcom/datadog/android/internal/time/TimeProvider;", "(Lcom/datadog/android/internal/time/TimeProvider;)V", "intervalMs", "", "getIntervalMs", "()J", "read", "Lcom/datadog/android/rum/internal/timeseries/DataPoint;", "readValue", "()Ljava/lang/Object;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class DataPointsReader<T> {
    private final TimeProvider timeProvider;

    public abstract long getIntervalMs();

    protected abstract T readValue();

    public DataPointsReader(TimeProvider timeProvider) {
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        this.timeProvider = timeProvider;
    }

    public DataPoint<T> read() {
        T value = readValue();
        if (value != null) {
            return new DataPoint<>(TimeUnit.MILLISECONDS.toNanos(this.timeProvider.getServerTimestampMillis()), value);
        }
        return null;
    }
}
