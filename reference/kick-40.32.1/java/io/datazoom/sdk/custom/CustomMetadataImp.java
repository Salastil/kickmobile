package io.datazoom.sdk.custom;

import com.facebook.hermes.intl.Constants;
import io.datazoom.sdk.model.Event;
import io.datazoom.sdk.model.EventKt;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: CustomMetadata.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0016J\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0016J\b\u0010\r\u001a\u00020\nH\u0016J$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0016R \u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lio/datazoom/sdk/custom/CustomMetadataImp;", "Lio/datazoom/sdk/custom/CustomMetadata;", "<init>", "()V", "_customMetadata", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "", "", "setCustomMetadata", "", "metadata", "getCustomMetadata", "clearCustomMetadata", "customEvent", "Lio/datazoom/sdk/model/Event;", "name", "payload", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CustomMetadataImp implements CustomMetadata {
    private final MutableStateFlow<Map<String, Object>> _customMetadata = StateFlowKt.MutableStateFlow(MapsKt.emptyMap());

    @Override // io.datazoom.sdk.custom.CustomMetadata
    public void setCustomMetadata(Map<String, ? extends Object> metadata) {
        Map<String, Object> value;
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        MutableStateFlow<Map<String, Object>> mutableStateFlow = this._customMetadata;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, MapsKt.plus(value, metadata)));
    }

    @Override // io.datazoom.sdk.custom.CustomMetadata
    public Map<String, Object> getCustomMetadata() {
        return MapsKt.toMap(this._customMetadata.getValue());
    }

    @Override // io.datazoom.sdk.custom.CustomMetadata
    public void clearCustomMetadata() {
        MutableStateFlow<Map<String, Object>> mutableStateFlow = this._customMetadata;
        while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), MapsKt.emptyMap())) {
        }
    }

    @Override // io.datazoom.sdk.custom.CustomMetadata
    public Event customEvent(String name, Map<String, ? extends Object> payload) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(payload, "payload");
        HashMap map = new HashMap(payload);
        setCustomMetadata(map);
        Event.Type type = Event.Type.CustomEvent;
        HashMap map2 = new HashMap();
        map2.put("CustomEvent.event", name);
        Unit unit = Unit.INSTANCE;
        return EventKt.toEvent$default(type, 0L, map, map2, null, null, 25, null);
    }
}
