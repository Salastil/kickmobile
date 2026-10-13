package com.datadog.android.rum.internal.timeseries.factory;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.rum.internal.domain.RumContext;
import com.datadog.android.rum.internal.timeseries.DataPoint;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: EventFactory.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002J3\u0010\b\u001a\u0004\u0018\u00018\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f0\u000eH&¢\u0006\u0002\u0010\u0010R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/datadog/android/rum/internal/timeseries/factory/EventFactory;", ExifInterface.GPS_DIRECTION_TRUE, "", ExifInterface.LONGITUDE_EAST, "eventName", "", "getEventName", "()Ljava/lang/String;", "create", "datadogContext", "Lcom/datadog/android/api/context/DatadogContext;", "rumContext", "Lcom/datadog/android/rum/internal/domain/RumContext;", "dataPoints", "", "Lcom/datadog/android/rum/internal/timeseries/DataPoint;", "(Lcom/datadog/android/api/context/DatadogContext;Lcom/datadog/android/rum/internal/domain/RumContext;Ljava/util/List;)Ljava/lang/Object;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface EventFactory<T, E> {
    E create(DatadogContext datadogContext, RumContext rumContext, List<DataPoint<T>> dataPoints);

    String getEventName();
}
