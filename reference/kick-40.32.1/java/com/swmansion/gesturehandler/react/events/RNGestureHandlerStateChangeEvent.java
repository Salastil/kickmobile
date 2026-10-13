package com.swmansion.gesturehandler.react.events;

import android.view.View;
import androidx.core.util.Pools;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.Event;
import com.swmansion.gesturehandler.core.GestureHandler;
import com.swmansion.gesturehandler.react.events.eventbuilders.GestureHandlerEventDataBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RNGestureHandlerStateChangeEvent.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JM\u0010\f\u001a\u00020\r\"\b\b\u0000\u0010\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u0002H\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0014R\u0014\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/swmansion/gesturehandler/react/events/RNGestureHandlerStateChangeEvent;", "Lcom/facebook/react/uimanager/events/Event;", "<init>", "()V", "dataBuilder", "Lcom/swmansion/gesturehandler/react/events/eventbuilders/GestureHandlerEventDataBuilder;", "newState", "", "oldState", "actionType", "eventHandlerType", "Lcom/swmansion/gesturehandler/react/events/EventHandlerType;", "init", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/swmansion/gesturehandler/core/GestureHandler;", "handler", "(Lcom/swmansion/gesturehandler/core/GestureHandler;IIILcom/swmansion/gesturehandler/react/events/eventbuilders/GestureHandlerEventDataBuilder;Lcom/swmansion/gesturehandler/react/events/EventHandlerType;)V", "onDispose", "getEventName", "", "canCoalesce", "", "getCoalescingKey", "", "getEventData", "Lcom/facebook/react/bridge/WritableMap;", "Companion", "react-native-gesture-handler_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RNGestureHandlerStateChangeEvent extends Event<RNGestureHandlerStateChangeEvent> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Pools.SynchronizedPool<RNGestureHandlerStateChangeEvent> EVENTS_POOL = new Pools.SynchronizedPool<>(7);
    public static final String EVENT_NAME = "onGestureHandlerStateChange";
    public static final String REANIMATED_EVENT_NAME = "onGestureHandlerReanimatedStateChange";
    private static final int TOUCH_EVENTS_POOL_SIZE = 7;
    private int actionType;
    private GestureHandlerEventDataBuilder<?> dataBuilder;
    private EventHandlerType eventHandlerType;
    private int newState;
    private int oldState;

    public /* synthetic */ RNGestureHandlerStateChangeEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.facebook.react.uimanager.events.Event
    public boolean canCoalesce() {
        return false;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public short getCoalescingKey() {
        return (short) 0;
    }

    private RNGestureHandlerStateChangeEvent() {
        this.actionType = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends GestureHandler> void init(T handler, int newState, int oldState, int actionType, GestureHandlerEventDataBuilder<T> dataBuilder, EventHandlerType eventHandlerType) {
        View viewForEvents = handler.getViewForEvents();
        super.init(UIManagerHelper.getSurfaceId(viewForEvents), viewForEvents.getId());
        this.dataBuilder = dataBuilder;
        this.newState = newState;
        this.oldState = oldState;
        this.actionType = actionType;
        this.eventHandlerType = eventHandlerType;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public void onDispose() {
        this.dataBuilder = null;
        this.newState = 0;
        this.oldState = 0;
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
            if (eventHandlerType == EventHandlerType.ForReanimated) {
                return REANIMATED_EVENT_NAME;
            }
        }
        return EVENT_NAME;
    }

    @Override // com.facebook.react.uimanager.events.Event
    /* JADX INFO: renamed from: getEventData */
    protected WritableMap getExtraData() {
        boolean zUsesNativeOrVirtualDetector = GestureHandler.INSTANCE.usesNativeOrVirtualDetector(this.actionType);
        GestureHandlerEventDataBuilder<?> gestureHandlerEventDataBuilder = this.dataBuilder;
        if (zUsesNativeOrVirtualDetector) {
            Companion companion = INSTANCE;
            Intrinsics.checkNotNull(gestureHandlerEventDataBuilder);
            return companion.createNativeEventData(gestureHandlerEventDataBuilder, this.newState, this.oldState);
        }
        Companion companion2 = INSTANCE;
        Intrinsics.checkNotNull(gestureHandlerEventDataBuilder);
        return companion2.createEventData(gestureHandlerEventDataBuilder, this.newState, this.oldState);
    }

    /* JADX INFO: compiled from: RNGestureHandlerStateChangeEvent.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JK\u0010\f\u001a\u00020\u000b\"\b\b\u0000\u0010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u0002H\r2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\r0\u00142\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017J\"\u0010\u0018\u001a\u00020\u00192\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00142\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bJ\"\u0010\u001a\u001a\u00020\u00192\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00142\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/swmansion/gesturehandler/react/events/RNGestureHandlerStateChangeEvent$Companion;", "", "<init>", "()V", "EVENT_NAME", "", "REANIMATED_EVENT_NAME", "TOUCH_EVENTS_POOL_SIZE", "", "EVENTS_POOL", "Landroidx/core/util/Pools$SynchronizedPool;", "Lcom/swmansion/gesturehandler/react/events/RNGestureHandlerStateChangeEvent;", "obtain", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/swmansion/gesturehandler/core/GestureHandler;", "handler", "newState", "oldState", "actionType", "dataBuilder", "Lcom/swmansion/gesturehandler/react/events/eventbuilders/GestureHandlerEventDataBuilder;", "eventHandlerType", "Lcom/swmansion/gesturehandler/react/events/EventHandlerType;", "(Lcom/swmansion/gesturehandler/core/GestureHandler;IIILcom/swmansion/gesturehandler/react/events/eventbuilders/GestureHandlerEventDataBuilder;Lcom/swmansion/gesturehandler/react/events/EventHandlerType;)Lcom/swmansion/gesturehandler/react/events/RNGestureHandlerStateChangeEvent;", "createEventData", "Lcom/facebook/react/bridge/WritableMap;", "createNativeEventData", "react-native-gesture-handler_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final <T extends GestureHandler> RNGestureHandlerStateChangeEvent obtain(T handler, int newState, int oldState, int actionType, GestureHandlerEventDataBuilder<T> dataBuilder, EventHandlerType eventHandlerType) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(dataBuilder, "dataBuilder");
            Intrinsics.checkNotNullParameter(eventHandlerType, "eventHandlerType");
            RNGestureHandlerStateChangeEvent rNGestureHandlerStateChangeEvent = (RNGestureHandlerStateChangeEvent) RNGestureHandlerStateChangeEvent.EVENTS_POOL.acquire();
            if (rNGestureHandlerStateChangeEvent == null) {
                rNGestureHandlerStateChangeEvent = new RNGestureHandlerStateChangeEvent(null);
            }
            RNGestureHandlerStateChangeEvent rNGestureHandlerStateChangeEvent2 = rNGestureHandlerStateChangeEvent;
            rNGestureHandlerStateChangeEvent2.init(handler, newState, oldState, actionType, dataBuilder, eventHandlerType);
            return rNGestureHandlerStateChangeEvent2;
        }

        public final WritableMap createEventData(GestureHandlerEventDataBuilder<?> dataBuilder, int newState, int oldState) {
            Intrinsics.checkNotNullParameter(dataBuilder, "dataBuilder");
            WritableMap writableMapCreateMap = Arguments.createMap();
            dataBuilder.buildEventData(writableMapCreateMap);
            writableMapCreateMap.putInt("handlerTag", dataBuilder.getHandlerTag());
            writableMapCreateMap.putInt("state", newState);
            writableMapCreateMap.putInt("oldState", oldState);
            return writableMapCreateMap;
        }

        public final WritableMap createNativeEventData(GestureHandlerEventDataBuilder<?> dataBuilder, int newState, int oldState) {
            Intrinsics.checkNotNullParameter(dataBuilder, "dataBuilder");
            WritableMap writableMapCreateMap = Arguments.createMap();
            WritableMap writableMapCreateMap2 = Arguments.createMap();
            dataBuilder.buildEventData(writableMapCreateMap2);
            Unit unit = Unit.INSTANCE;
            writableMapCreateMap.putMap("handlerData", writableMapCreateMap2);
            writableMapCreateMap.putInt("handlerTag", dataBuilder.getHandlerTag());
            writableMapCreateMap.putInt("state", newState);
            writableMapCreateMap.putInt("oldState", oldState);
            return writableMapCreateMap;
        }
    }
}
