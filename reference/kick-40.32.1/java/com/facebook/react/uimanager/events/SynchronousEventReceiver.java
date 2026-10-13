package com.facebook.react.uimanager.events;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.annotations.UnstableReactNativeAPI;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SynchronousEventReceiver.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\ba\u0018\u00002\u00020\u0001JB\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\nH&JJ\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2 = {"Lcom/facebook/react/uimanager/events/SynchronousEventReceiver;", "", "receiveEvent", "", "surfaceId", "", "reactTag", "eventName", "", "canCoalesceEvent", "", "params", "Lcom/facebook/react/bridge/WritableMap;", "eventCategory", "experimentalIsSynchronous", "eventTimestamp", "", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
@UnstableReactNativeAPI
public interface SynchronousEventReceiver {
    void receiveEvent(int surfaceId, int reactTag, String eventName, boolean canCoalesceEvent, WritableMap params, int eventCategory, boolean experimentalIsSynchronous);

    default void receiveEvent(int surfaceId, int reactTag, String eventName, boolean canCoalesceEvent, WritableMap params, int eventCategory, boolean experimentalIsSynchronous, long eventTimestamp) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        receiveEvent(surfaceId, reactTag, eventName, canCoalesceEvent, params, eventCategory, experimentalIsSynchronous);
    }
}
