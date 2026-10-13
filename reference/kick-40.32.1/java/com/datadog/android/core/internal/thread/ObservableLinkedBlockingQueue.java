package com.datadog.android.core.internal.thread;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.internal.thread.NamedExecutionUnit;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ObservableLinkedBlockingQueue.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0010\u0018\u0000 \u000f*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u000fB\u000f\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00050\nH\u0002J\u001c\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/datadog/android/core/internal/thread/ObservableLinkedBlockingQueue;", ExifInterface.LONGITUDE_EAST, "", "Ljava/util/concurrent/LinkedBlockingQueue;", "capacity", "", "(I)V", "lastDumpTimestamp", "Ljava/util/concurrent/atomic/AtomicLong;", "buildDumpMap", "", "", "dumpQueue", "currentTimestamp", "", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class ObservableLinkedBlockingQueue<E> extends LinkedBlockingQueue<E> {
    private static final long DUMPING_TIME_INTERVAL_IN_MS;
    public static final int MAX_SIZE_TO_DUMP = 2048;
    private final AtomicLong lastDumpTimestamp;

    public ObservableLinkedBlockingQueue() {
        this(0, 1, null);
    }

    public /* synthetic */ ObservableLinkedBlockingQueue(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? Integer.MAX_VALUE : i);
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    @Override // java.util.concurrent.LinkedBlockingQueue, java.util.AbstractCollection, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    public ObservableLinkedBlockingQueue(int i) {
        super(i);
        this.lastDumpTimestamp = new AtomicLong(0L);
    }

    public final Map<String, Integer> dumpQueue(long currentTimestamp) {
        long j = this.lastDumpTimestamp.get();
        if (currentTimestamp - j <= DUMPING_TIME_INTERVAL_IN_MS || size() > 2048 || !this.lastDumpTimestamp.compareAndSet(j, currentTimestamp)) {
            return null;
        }
        return buildDumpMap();
    }

    private final Map<String, Integer> buildDumpMap() {
        String name;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Object[] array = super.toArray();
        Intrinsics.checkNotNullExpressionValue(array, "super.toArray()");
        for (Object obj : array) {
            NamedExecutionUnit namedExecutionUnit = obj instanceof NamedExecutionUnit ? (NamedExecutionUnit) obj : null;
            if (namedExecutionUnit != null && (name = namedExecutionUnit.getName()) != null) {
                Integer num = (Integer) linkedHashMap.get(name);
                linkedHashMap.put(name, Integer.valueOf((num != null ? num.intValue() : 0) + 1));
            }
        }
        return linkedHashMap;
    }

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        DUMPING_TIME_INTERVAL_IN_MS = 5000L;
    }
}
