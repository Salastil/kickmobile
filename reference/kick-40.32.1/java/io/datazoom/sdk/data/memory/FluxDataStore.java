package io.datazoom.sdk.data.memory;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.hermes.intl.Constants;
import io.datazoom.sdk.model.FluxData;
import io.datazoom.sdk.model.FluxDataKt;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: FluxDataStore.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u001f\u0010\f\u001a\u0004\u0018\u0001H\r\"\u0004\b\u0000\u0010\r2\n\u0010\u000e\u001a\u00060\u000fj\u0002`\u0010¢\u0006\u0002\u0010\u0011J\u0012\u0010\u0012\u001a\u00020\t2\n\u0010\u000e\u001a\u00060\u000fj\u0002`\u0010J%\u0010\u0013\u001a!\u0012\u0004\u0012\u00020\u0007\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\t0\u00170\u0014j\u0002`\u0018J\u0006\u0010\u0012\u001a\u00020\tJ*\u0010\u0019\u001a\u00020\t2\"\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0014j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001`\u001bJ\u0012\u0010\u001c\u001a\u00020\u001d2\n\u0010\u000e\u001a\u00060\u000fj\u0002`\u0010J\u0012\u0010\u001e\u001a\u00020\t2\n\u0010\u000e\u001a\u00060\u000fj\u0002`\u0010J$\u0010\u001f\u001a\u00020\t2\n\u0010\u000e\u001a\u00060\u000fj\u0002`\u00102\u0010\u0010 \u001a\f\u0012\b\u0012\u00060\u000fj\u0002`\u00100!J\u001a\u0010\"\u001a\u00020\t2\n\u0010\u000e\u001a\u00060\u000fj\u0002`\u00102\u0006\u0010#\u001a\u00020$R \u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lio/datazoom/sdk/data/memory/FluxDataStore;", "", "<init>", "()V", "store", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "", "put", "", "fd", "Lio/datazoom/sdk/model/FluxData;", "get", ExifInterface.GPS_DIRECTION_TRUE, "type", "Lio/datazoom/sdk/model/FluxData$Type;", "Lio/datazoom/sdk/model/FD;", "(Lio/datazoom/sdk/model/FluxData$Type;)Ljava/lang/Object;", "clear", "getAll", "Ljava/util/HashMap;", "Lkotlinx/serialization/Serializable;", "with", "Lio/datazoom/sdk/utils/AnySerializer;", "Lio/datazoom/sdk/utils/DataMap;", "merge", "data", "Lkotlin/collections/HashMap;", "incrementAndGet", "", "incrementCounter", "computeSum", "sources", "", "addDuration", "duration", "", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class FluxDataStore {
    private final MutableStateFlow<Map<String, Object>> store = StateFlowKt.MutableStateFlow(MapsKt.emptyMap());

    public final void put(FluxData fd) {
        Map<String, Object> value;
        Map<String, Object> mutableMap;
        Intrinsics.checkNotNullParameter(fd, "fd");
        if (fd.getData() == null) {
            return;
        }
        if (FluxDataKt.getIgnoreIfZero().contains(fd.getType()) && (Intrinsics.areEqual(fd.getData(), (Object) 0L) || Intrinsics.areEqual(fd.getData(), (Object) 0) || Intrinsics.areEqual(fd.getData(), Float.valueOf(0.0f)))) {
            return;
        }
        MutableStateFlow<Map<String, Object>> mutableStateFlow = this.store;
        do {
            value = mutableStateFlow.getValue();
            mutableMap = MapsKt.toMutableMap(value);
            mutableMap.put(fd.getType().getValue(), fd.getData());
        } while (!mutableStateFlow.compareAndSet(value, mutableMap));
    }

    public final <T> T get(FluxData.Type type) {
        Intrinsics.checkNotNullParameter(type, "type");
        T t = (T) this.store.getValue().get(type.getValue());
        if (t == null) {
            return null;
        }
        return t;
    }

    public final void clear(FluxData.Type type) {
        Map<String, Object> value;
        Map<String, Object> mutableMap;
        Intrinsics.checkNotNullParameter(type, "type");
        MutableStateFlow<Map<String, Object>> mutableStateFlow = this.store;
        do {
            value = mutableStateFlow.getValue();
            mutableMap = MapsKt.toMutableMap(value);
            mutableMap.remove(type.getValue());
        } while (!mutableStateFlow.compareAndSet(value, mutableMap));
    }

    public final HashMap<String, Object> getAll() {
        return new HashMap<>(this.store.getValue());
    }

    public final void clear() {
        MutableStateFlow<Map<String, Object>> mutableStateFlow = this.store;
        while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), MapsKt.emptyMap())) {
        }
    }

    public final void merge(HashMap<String, Object> data) {
        Map<String, Object> value;
        Map<String, Object> mutableMap;
        Intrinsics.checkNotNullParameter(data, "data");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            if (entry.getValue() != null) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = linkedHashMap;
        MutableStateFlow<Map<String, Object>> mutableStateFlow = this.store;
        do {
            value = mutableStateFlow.getValue();
            mutableMap = MapsKt.toMutableMap(value);
            mutableMap.putAll(linkedHashMap2);
        } while (!mutableStateFlow.compareAndSet(value, mutableMap));
    }

    public final int incrementAndGet(FluxData.Type type) {
        Map<String, Object> value;
        int iIntValue;
        Map<String, Object> mutableMap;
        Intrinsics.checkNotNullParameter(type, "type");
        MutableStateFlow<Map<String, Object>> mutableStateFlow = this.store;
        do {
            value = mutableStateFlow.getValue();
            Map<String, Object> map = value;
            Object obj = map.get(type.getValue());
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            iIntValue = (num != null ? num.intValue() : 0) + 1;
            mutableMap = MapsKt.toMutableMap(map);
            mutableMap.put(type.getValue(), Integer.valueOf(iIntValue));
        } while (!mutableStateFlow.compareAndSet(value, mutableMap));
        return iIntValue;
    }

    public final void incrementCounter(FluxData.Type type) {
        Map<String, Object> value;
        Map<String, Object> mutableMap;
        Intrinsics.checkNotNullParameter(type, "type");
        MutableStateFlow<Map<String, Object>> mutableStateFlow = this.store;
        do {
            value = mutableStateFlow.getValue();
            Map<String, Object> map = value;
            Object obj = map.get(type.getValue());
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            int iIntValue = num != null ? num.intValue() : 0;
            mutableMap = MapsKt.toMutableMap(map);
            mutableMap.put(type.getValue(), Integer.valueOf(iIntValue + 1));
        } while (!mutableStateFlow.compareAndSet(value, mutableMap));
    }

    public final void computeSum(FluxData.Type type, List<? extends FluxData.Type> sources) {
        Map<String, Object> value;
        Map<String, Object> mutableMap;
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(sources, "sources");
        MutableStateFlow<Map<String, Object>> mutableStateFlow = this.store;
        do {
            value = mutableStateFlow.getValue();
            Map<String, Object> map = value;
            Iterator<T> it = sources.iterator();
            int iIntValue = 0;
            while (it.hasNext()) {
                Object obj = map.get(((FluxData.Type) it.next()).getValue());
                Integer num = obj instanceof Integer ? (Integer) obj : null;
                iIntValue += num != null ? num.intValue() : 0;
            }
            mutableMap = MapsKt.toMutableMap(map);
            mutableMap.put(type.getValue(), Integer.valueOf(iIntValue));
        } while (!mutableStateFlow.compareAndSet(value, mutableMap));
    }

    public final void addDuration(FluxData.Type type, long duration) {
        Map<String, Object> value;
        Map<String, Object> mutableMap;
        Intrinsics.checkNotNullParameter(type, "type");
        MutableStateFlow<Map<String, Object>> mutableStateFlow = this.store;
        do {
            value = mutableStateFlow.getValue();
            Map<String, Object> map = value;
            Object obj = map.get(type.getValue());
            Long l = obj instanceof Long ? (Long) obj : null;
            long jLongValue = l != null ? l.longValue() : 0L;
            mutableMap = MapsKt.toMutableMap(map);
            mutableMap.put(type.getValue(), Long.valueOf(jLongValue + duration));
        } while (!mutableStateFlow.compareAndSet(value, mutableMap));
    }
}
