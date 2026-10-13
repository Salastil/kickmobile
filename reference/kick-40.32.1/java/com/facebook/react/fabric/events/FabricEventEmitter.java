package com.facebook.react.fabric.events;

import android.os.SystemClock;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.fabric.FabricUIManager;
import com.facebook.react.uimanager.events.RCTModernEventEmitter;
import com.facebook.systrace.Systrace;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FabricEventEmitter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JB\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\tH\u0017JJ\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/facebook/react/fabric/events/FabricEventEmitter;", "Lcom/facebook/react/uimanager/events/RCTModernEventEmitter;", "uiManager", "Lcom/facebook/react/fabric/FabricUIManager;", "<init>", "(Lcom/facebook/react/fabric/FabricUIManager;)V", "receiveEvent", "", "surfaceId", "", "targetTag", "eventName", "", "canCoalesceEvent", "", "customCoalesceKey", "params", "Lcom/facebook/react/bridge/WritableMap;", "category", "eventTimestamp", "", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FabricEventEmitter implements RCTModernEventEmitter {
    private final FabricUIManager uiManager;

    public FabricEventEmitter(FabricUIManager uiManager) {
        Intrinsics.checkNotNullParameter(uiManager, "uiManager");
        this.uiManager = uiManager;
    }

    @Override // com.facebook.react.uimanager.events.RCTModernEventEmitter
    @Deprecated(message = "Use the overload with eventTimestamp parameter instead.")
    public void receiveEvent(int surfaceId, int targetTag, String eventName, boolean canCoalesceEvent, int customCoalesceKey, WritableMap params, int category) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        receiveEvent(surfaceId, targetTag, eventName, canCoalesceEvent, customCoalesceKey, params, category, SystemClock.uptimeMillis());
    }

    @Override // com.facebook.react.uimanager.events.RCTModernEventEmitter
    public void receiveEvent(int surfaceId, int targetTag, String eventName, boolean canCoalesceEvent, int customCoalesceKey, WritableMap params, int category, long eventTimestamp) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Systrace.beginSection(0L, "FabricEventEmitter.receiveEvent('" + eventName + "')");
        try {
            this.uiManager.receiveEvent(surfaceId, targetTag, eventName, canCoalesceEvent, params, category, false, eventTimestamp);
        } finally {
            Systrace.endSection(0L);
        }
    }
}
