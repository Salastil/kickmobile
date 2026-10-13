package com.swmansion.gesturehandler.react.events;

import android.view.View;
import androidx.core.util.Pools;
import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.webview.internal.MixedWebViewEventConsumer;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.Event;
import com.swmansion.gesturehandler.core.GestureHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RNGestureHandlerTouchEvent.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0019B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\f\u001a\u00020\r\"\b\b\u0000\u0010\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u0002H\u000e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/swmansion/gesturehandler/react/events/RNGestureHandlerTouchEvent;", "Lcom/facebook/react/uimanager/events/Event;", "<init>", "()V", "extraData", "Lcom/facebook/react/bridge/WritableMap;", "coalescingKey", "", "actionType", "", "eventHandlerType", "Lcom/swmansion/gesturehandler/react/events/EventHandlerType;", "init", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/swmansion/gesturehandler/core/GestureHandler;", "handler", "(Lcom/swmansion/gesturehandler/core/GestureHandler;ILcom/swmansion/gesturehandler/react/events/EventHandlerType;)V", "onDispose", "getEventName", "", "canCoalesce", "", "getCoalescingKey", "getEventData", "Companion", "react-native-gesture-handler_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RNGestureHandlerTouchEvent extends Event<RNGestureHandlerTouchEvent> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Pools.SynchronizedPool<RNGestureHandlerTouchEvent> EVENTS_POOL = new Pools.SynchronizedPool<>(7);
    public static final String EVENT_NAME = "onGestureHandlerEvent";
    public static final int EVENT_TOUCH_CANCEL = 4;
    public static final int EVENT_TOUCH_DOWN = 1;
    public static final int EVENT_TOUCH_MOVE = 2;
    public static final int EVENT_TOUCH_UP = 3;
    public static final int EVENT_UNDETERMINED = 0;
    public static final String NATIVE_EVENT_NAME = "onGestureHandlerTouchEvent";
    public static final String REANIMATED_EVENT_NAME = "onGestureHandlerReanimatedTouchEvent";
    private static final int TOUCH_EVENTS_POOL_SIZE = 7;
    private int actionType;
    private short coalescingKey;
    private EventHandlerType eventHandlerType;
    private WritableMap extraData;

    public /* synthetic */ RNGestureHandlerTouchEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private RNGestureHandlerTouchEvent() {
        this.actionType = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T extends GestureHandler> void init(T handler, int actionType, EventHandlerType eventHandlerType) {
        View viewForEvents = handler.getViewForEvents();
        super.init(UIManagerHelper.getSurfaceId(viewForEvents), viewForEvents.getId());
        this.extraData = INSTANCE.createEventData(handler);
        this.coalescingKey = handler.getEventCoalescingKey();
        this.actionType = actionType;
        this.eventHandlerType = eventHandlerType;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public void onDispose() {
        this.extraData = null;
        EVENTS_POOL.release(this);
    }

    @Override // com.facebook.react.uimanager.events.Event
    /* JADX INFO: renamed from: getEventName */
    public String getName() {
        if (GestureHandler.INSTANCE.usesNativeOrVirtualDetector(this.actionType)) {
            EventHandlerType eventHandlerType = this.eventHandlerType;
            if (eventHandlerType == null) {
                Intrinsics.throwUninitializedPropertyAccessException("eventHandlerType");
                eventHandlerType = null;
            }
            return eventHandlerType == EventHandlerType.ForReanimated ? REANIMATED_EVENT_NAME : NATIVE_EVENT_NAME;
        }
        return "onGestureHandlerEvent";
    }

    @Override // com.facebook.react.uimanager.events.Event
    public boolean canCoalesce() {
        return !GestureHandler.INSTANCE.usesNativeOrVirtualDetector(this.actionType);
    }

    @Override // com.facebook.react.uimanager.events.Event
    public short getCoalescingKey() {
        return this.coalescingKey;
    }

    @Override // com.facebook.react.uimanager.events.Event
    /* JADX INFO: renamed from: getEventData, reason: from getter */
    protected WritableMap getExtraData() {
        return this.extraData;
    }

    /* JADX INFO: compiled from: RNGestureHandlerTouchEvent.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u0012\u001a\u00020\u0011\"\b\b\u0000\u0010\u0013*\u00020\u00142\u0006\u0010\u0015\u001a\u0002H\u00132\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018¢\u0006\u0002\u0010\u0019J\u001d\u0010\u001a\u001a\u00020\u001b\"\b\b\u0000\u0010\u0013*\u00020\u00142\u0006\u0010\u0015\u001a\u0002H\u0013¢\u0006\u0002\u0010\u001cR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/swmansion/gesturehandler/react/events/RNGestureHandlerTouchEvent$Companion;", "", "<init>", "()V", "EVENT_UNDETERMINED", "", "EVENT_TOUCH_DOWN", "EVENT_TOUCH_MOVE", "EVENT_TOUCH_UP", "EVENT_TOUCH_CANCEL", "EVENT_NAME", "", "REANIMATED_EVENT_NAME", "NATIVE_EVENT_NAME", "TOUCH_EVENTS_POOL_SIZE", "EVENTS_POOL", "Landroidx/core/util/Pools$SynchronizedPool;", "Lcom/swmansion/gesturehandler/react/events/RNGestureHandlerTouchEvent;", "obtain", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/swmansion/gesturehandler/core/GestureHandler;", "handler", "actionType", "eventHandlerType", "Lcom/swmansion/gesturehandler/react/events/EventHandlerType;", "(Lcom/swmansion/gesturehandler/core/GestureHandler;ILcom/swmansion/gesturehandler/react/events/EventHandlerType;)Lcom/swmansion/gesturehandler/react/events/RNGestureHandlerTouchEvent;", "createEventData", "Lcom/facebook/react/bridge/WritableMap;", "(Lcom/swmansion/gesturehandler/core/GestureHandler;)Lcom/facebook/react/bridge/WritableMap;", "react-native-gesture-handler_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final <T extends GestureHandler> RNGestureHandlerTouchEvent obtain(T handler, int actionType, EventHandlerType eventHandlerType) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(eventHandlerType, "eventHandlerType");
            RNGestureHandlerTouchEvent rNGestureHandlerTouchEvent = (RNGestureHandlerTouchEvent) RNGestureHandlerTouchEvent.EVENTS_POOL.acquire();
            if (rNGestureHandlerTouchEvent == null) {
                rNGestureHandlerTouchEvent = new RNGestureHandlerTouchEvent(null);
            }
            rNGestureHandlerTouchEvent.init(handler, actionType, eventHandlerType);
            return rNGestureHandlerTouchEvent;
        }

        public final <T extends GestureHandler> WritableMap createEventData(T handler) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putInt("handlerTag", handler.getTag());
            writableMapCreateMap.putInt("state", handler.getState());
            writableMapCreateMap.putInt("numberOfTouches", handler.getTrackedPointersCount());
            writableMapCreateMap.putInt(MixedWebViewEventConsumer.EVENT_TYPE_KEY, handler.getTouchEventType());
            writableMapCreateMap.putInt("pointerType", handler.getPointerType());
            WritableArray writableArrayConsumeChangedTouchesPayload = handler.consumeChangedTouchesPayload();
            if (writableArrayConsumeChangedTouchesPayload == null) {
                writableArrayConsumeChangedTouchesPayload = Arguments.createArray();
            }
            writableMapCreateMap.putArray("changedTouches", writableArrayConsumeChangedTouchesPayload);
            WritableArray writableArrayConsumeAllTouchesPayload = handler.consumeAllTouchesPayload();
            if (writableArrayConsumeAllTouchesPayload == null) {
                writableArrayConsumeAllTouchesPayload = Arguments.createArray();
            }
            writableMapCreateMap.putArray("allTouches", writableArrayConsumeAllTouchesPayload);
            if (handler.getIsAwaiting() && handler.getState() == 4) {
                writableMapCreateMap.putInt("state", 2);
            }
            return writableMapCreateMap;
        }
    }
}
