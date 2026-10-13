package com.swmansion.reanimated;

import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTModernEventEmitter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CopiedEvent.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0011@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\nR\"\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0006\u001a\u0004\u0018\u00010\u0017@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\n¨\u0006\u001d"}, d2 = {"Lcom/swmansion/reanimated/CopiedEvent;", "", "event", "Lcom/facebook/react/uimanager/events/Event;", "<init>", "(Lcom/facebook/react/uimanager/events/Event;)V", "value", "", "surfaceId", "getSurfaceId", "()I", "targetTag", "getTargetTag", "", "eventName", "getEventName", "()Ljava/lang/String;", "", "canCoalesceEvent", "getCanCoalesceEvent", "()Z", "customCoalesceKey", "getCustomCoalesceKey", "Lcom/facebook/react/bridge/WritableMap;", "payload", "getPayload", "()Lcom/facebook/react/bridge/WritableMap;", "category", "getCategory", "react-native-reanimated_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CopiedEvent {
    private boolean canCoalesceEvent;
    private int category;
    private int customCoalesceKey;
    private String eventName;
    private WritableMap payload;
    private int surfaceId;
    private int targetTag;

    public CopiedEvent(Event<?> event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.eventName = "";
        event.dispatchModern(new RCTModernEventEmitter() { // from class: com.swmansion.reanimated.CopiedEvent.1
            @Override // com.facebook.react.uimanager.events.RCTEventEmitter
            public void receiveTouches(String eventName, WritableArray touches, WritableArray changedIndices) {
                Intrinsics.checkNotNullParameter(eventName, "eventName");
                Intrinsics.checkNotNullParameter(touches, "touches");
                Intrinsics.checkNotNullParameter(changedIndices, "changedIndices");
            }

            @Override // com.facebook.react.uimanager.events.RCTModernEventEmitter
            public /* bridge */ void receiveEvent(int i, int i2, String str, boolean z, int i3, WritableMap writableMap, int i4, long j) {
                super.receiveEvent(i, i2, str, z, i3, writableMap, i4, j);
            }

            @Override // com.facebook.react.uimanager.events.RCTModernEventEmitter, com.facebook.react.uimanager.events.RCTEventEmitter
            public void receiveEvent(int targetTag, String eventName, WritableMap params) {
                Intrinsics.checkNotNullParameter(eventName, "eventName");
                CopiedEvent.this.targetTag = targetTag;
                CopiedEvent.this.eventName = eventName;
                CopiedEvent copiedEvent = CopiedEvent.this;
                Intrinsics.checkNotNull(params);
                copiedEvent.payload = params.copy();
            }

            @Override // com.facebook.react.uimanager.events.RCTModernEventEmitter
            public void receiveEvent(int surfaceId, int targetTag, String eventName, WritableMap params) {
                Intrinsics.checkNotNullParameter(eventName, "eventName");
                CopiedEvent.this.surfaceId = surfaceId;
                CopiedEvent.this.targetTag = targetTag;
                CopiedEvent.this.eventName = eventName;
                CopiedEvent copiedEvent = CopiedEvent.this;
                Intrinsics.checkNotNull(params);
                copiedEvent.payload = params.copy();
            }

            @Override // com.facebook.react.uimanager.events.RCTModernEventEmitter
            public void receiveEvent(int surfaceId, int targetTag, String eventName, boolean canCoalesceEvent, int customCoalesceKey, WritableMap params, int category) {
                Intrinsics.checkNotNullParameter(eventName, "eventName");
                CopiedEvent.this.surfaceId = surfaceId;
                CopiedEvent.this.targetTag = targetTag;
                CopiedEvent.this.eventName = eventName;
                CopiedEvent.this.canCoalesceEvent = canCoalesceEvent;
                CopiedEvent.this.customCoalesceKey = customCoalesceKey;
                CopiedEvent copiedEvent = CopiedEvent.this;
                Intrinsics.checkNotNull(params);
                copiedEvent.payload = params.copy();
                CopiedEvent.this.category = category;
            }
        });
    }

    public final int getSurfaceId() {
        return this.surfaceId;
    }

    public final int getTargetTag() {
        return this.targetTag;
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final boolean getCanCoalesceEvent() {
        return this.canCoalesceEvent;
    }

    public final int getCustomCoalesceKey() {
        return this.customCoalesceKey;
    }

    public final WritableMap getPayload() {
        return this.payload;
    }

    public final int getCategory() {
        return this.category;
    }
}
