package com.facebook.react.uimanager.events;

import com.facebook.react.bridge.WritableMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RCTModernEventEmitter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0017J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0017JB\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\u0005H'JJ\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2 = {"Lcom/facebook/react/uimanager/events/RCTModernEventEmitter;", "Lcom/facebook/react/uimanager/events/RCTEventEmitter;", "receiveEvent", "", "targetTag", "", "eventName", "", "params", "Lcom/facebook/react/bridge/WritableMap;", "surfaceId", "canCoalesceEvent", "", "customCoalesceKey", "category", "eventTimestamp", "", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface RCTModernEventEmitter extends RCTEventEmitter {
    @Deprecated(message = "Use the overload with eventTimestamp parameter instead.")
    void receiveEvent(int surfaceId, int targetTag, String eventName, boolean canCoalesceEvent, int customCoalesceKey, WritableMap params, int category);

    @Override // com.facebook.react.uimanager.events.RCTEventEmitter
    @Deprecated(message = "Use RCTModernEventEmitter", replaceWith = @ReplaceWith(expression = "RCTModernEventEmitter.receiveEvent(surfaceId, targetTag, eventName, params)", imports = {}))
    default void receiveEvent(int targetTag, String eventName, WritableMap params) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        receiveEvent(-1, targetTag, eventName, params);
    }

    @Deprecated(message = "Use the overload with eventTimestamp parameter instead.")
    default void receiveEvent(int surfaceId, int targetTag, String eventName, WritableMap params) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        receiveEvent(surfaceId, targetTag, eventName, false, 0, params, 2);
    }

    default void receiveEvent(int surfaceId, int targetTag, String eventName, boolean canCoalesceEvent, int customCoalesceKey, WritableMap params, int category, long eventTimestamp) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        receiveEvent(surfaceId, targetTag, eventName, canCoalesceEvent, customCoalesceKey, params, category);
    }
}
