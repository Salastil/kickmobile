package io.datazoom.sdk.data.memory;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.hermes.intl.Constants;
import io.datazoom.sdk.model.Preference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: PreferenceStore.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eJ\u001b\u0010\u000f\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0002\u0010\u0012J\u0006\u0010\u0013\u001a\u00020\tR \u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lio/datazoom/sdk/data/memory/PreferenceStore;", "", "<init>", "()V", "store", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "", "put", "", "pf", "Lio/datazoom/sdk/model/Preference;", "reset", "key", "Lio/datazoom/sdk/model/Preference$Type;", "get", ExifInterface.GPS_DIRECTION_TRUE, "type", "(Lio/datazoom/sdk/model/Preference$Type;)Ljava/lang/Object;", "clear", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PreferenceStore {
    private final MutableStateFlow<Map<String, Object>> store = StateFlowKt.MutableStateFlow(MapsKt.emptyMap());

    public final void put(Preference pf) {
        Map<String, Object> value;
        Map<String, Object> mutableMap;
        Intrinsics.checkNotNullParameter(pf, "pf");
        MutableStateFlow<Map<String, Object>> mutableStateFlow = this.store;
        do {
            value = mutableStateFlow.getValue();
            mutableMap = MapsKt.toMutableMap(value);
            mutableMap.put(pf.getKey().getValue(), pf.getValue());
        } while (!mutableStateFlow.compareAndSet(value, mutableMap));
    }

    public final void reset(Preference.Type key) {
        Map<String, Object> value;
        Map<String, Object> mutableMap;
        Intrinsics.checkNotNullParameter(key, "key");
        MutableStateFlow<Map<String, Object>> mutableStateFlow = this.store;
        do {
            value = mutableStateFlow.getValue();
            mutableMap = MapsKt.toMutableMap(value);
            mutableMap.remove(key.getValue());
        } while (!mutableStateFlow.compareAndSet(value, mutableMap));
    }

    public final <T> T get(Preference.Type type) {
        Intrinsics.checkNotNullParameter(type, "type");
        T t = (T) this.store.getValue().get(type.getValue());
        if (t == null) {
            return null;
        }
        return t;
    }

    public final void clear() {
        MutableStateFlow<Map<String, Object>> mutableStateFlow = this.store;
        while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), MapsKt.emptyMap())) {
        }
    }
}
