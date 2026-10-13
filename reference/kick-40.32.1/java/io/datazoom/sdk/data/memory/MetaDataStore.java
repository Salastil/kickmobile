package io.datazoom.sdk.data.memory;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.hermes.intl.Constants;
import io.datazoom.sdk.model.MetaData;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: MetaDataStore.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0014\u0010\f\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u0018\u0010\b\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0001J\u001b\u0010\u0012\u001a\u0004\u0018\u0001H\u0013\"\u0004\b\u0000\u0010\u00132\u0006\u0010\u0014\u001a\u00020\u000f¢\u0006\u0002\u0010\u0015J%\u0010\u0016\u001a!\u0012\u0004\u0012\u00020\u0007\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\t0\u001a0\u0017j\u0002`\u001bJ\u0006\u0010\u001c\u001a\u00020\tR \u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lio/datazoom/sdk/data/memory/MetaDataStore;", "", "<init>", "()V", "store", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "", "put", "", "md", "Lio/datazoom/sdk/model/MetaData;", "remove", "list", "", "Lio/datazoom/sdk/model/MetaData$Type;", "type", "data", "get", ExifInterface.GPS_DIRECTION_TRUE, "metadata", "(Lio/datazoom/sdk/model/MetaData$Type;)Ljava/lang/Object;", "getAll", "Ljava/util/HashMap;", "Lkotlinx/serialization/Serializable;", "with", "Lio/datazoom/sdk/utils/AnySerializer;", "Lio/datazoom/sdk/utils/DataMap;", "clear", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MetaDataStore {
    private final MutableStateFlow<Map<String, Object>> store = StateFlowKt.MutableStateFlow(MapsKt.emptyMap());

    public final void put(MetaData md) {
        Map<String, Object> value;
        Map<String, Object> mutableMap;
        Intrinsics.checkNotNullParameter(md, "md");
        if (md.getData() == null) {
            return;
        }
        MutableStateFlow<Map<String, Object>> mutableStateFlow = this.store;
        do {
            value = mutableStateFlow.getValue();
            mutableMap = MapsKt.toMutableMap(value);
            mutableMap.put(md.getType().getValue(), md.getData());
        } while (!mutableStateFlow.compareAndSet(value, mutableMap));
    }

    public final void remove(MetaData md) {
        Map<String, Object> value;
        Map<String, Object> mutableMap;
        Intrinsics.checkNotNullParameter(md, "md");
        MutableStateFlow<Map<String, Object>> mutableStateFlow = this.store;
        do {
            value = mutableStateFlow.getValue();
            mutableMap = MapsKt.toMutableMap(value);
            mutableMap.remove(md.getType().getValue());
        } while (!mutableStateFlow.compareAndSet(value, mutableMap));
    }

    public final void remove(List<? extends MetaData.Type> list) {
        Map<String, Object> value;
        Map<String, Object> mutableMap;
        Intrinsics.checkNotNullParameter(list, "list");
        MutableStateFlow<Map<String, Object>> mutableStateFlow = this.store;
        do {
            value = mutableStateFlow.getValue();
            mutableMap = MapsKt.toMutableMap(value);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                mutableMap.remove(((MetaData.Type) it.next()).getValue());
            }
        } while (!mutableStateFlow.compareAndSet(value, mutableMap));
    }

    public final MetaData put(MetaData.Type type, Object data) {
        Map<String, Object> value;
        Map<String, Object> mutableMap;
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(data, "data");
        MutableStateFlow<Map<String, Object>> mutableStateFlow = this.store;
        do {
            value = mutableStateFlow.getValue();
            mutableMap = MapsKt.toMutableMap(value);
            mutableMap.put(type.getValue(), data);
        } while (!mutableStateFlow.compareAndSet(value, mutableMap));
        return new MetaData(type, data);
    }

    public final <T> T get(MetaData.Type metadata) {
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        T t = (T) this.store.getValue().get(metadata.getValue());
        if (t == null) {
            return null;
        }
        return t;
    }

    public final HashMap<String, Object> getAll() {
        return new HashMap<>(this.store.getValue());
    }

    public final void clear() {
        MutableStateFlow<Map<String, Object>> mutableStateFlow = this.store;
        while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), MapsKt.emptyMap())) {
        }
    }
}
