package com.datadog.android.rum.internal.timeseries;

import androidx.exifinterface.media.ExifInterface;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Buffer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0014\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\bJ\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u000eJ\u0006\u0010\u000f\u001a\u00020\u000bR*\u0010\u0006\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u0007j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/datadog/android/rum/internal/timeseries/Buffer;", ExifInterface.GPS_DIRECTION_TRUE, "", ContentDisposition.Parameters.Size, "", "(I)V", "items", "Ljava/util/ArrayList;", "Lcom/datadog/android/rum/internal/timeseries/DataPoint;", "Lkotlin/collections/ArrayList;", "add", "", "dataPoint", "drain", "", "isFull", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Buffer<T> {
    private final ArrayList<DataPoint<T>> items;
    private final int size;

    public Buffer(int i) {
        this.size = i;
        this.items = new ArrayList<>(i);
    }

    public final boolean add(DataPoint<T> dataPoint) {
        Intrinsics.checkNotNullParameter(dataPoint, "dataPoint");
        return this.items.add(dataPoint);
    }

    public final boolean isFull() {
        return this.items.size() >= this.size;
    }

    public final List<DataPoint<T>> drain() {
        List<DataPoint<T>> list = CollectionsKt.toList(this.items);
        this.items.clear();
        return list;
    }
}
