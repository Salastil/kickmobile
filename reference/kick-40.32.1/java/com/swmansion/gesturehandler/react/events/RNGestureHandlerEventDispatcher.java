package com.swmansion.gesturehandler.react.events;

import android.view.MotionEvent;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.swmansion.gesturehandler.ReactContextExtensionsKt;
import com.swmansion.gesturehandler.ReanimatedProxy;
import com.swmansion.gesturehandler.core.GestureHandler;
import com.swmansion.gesturehandler.core.OnTouchEventListener;
import com.swmansion.gesturehandler.react.ExtensionsKt;
import com.swmansion.gesturehandler.react.RNGestureHandlerDetectorView;
import com.swmansion.gesturehandler.react.RNGestureHandlerFactoryUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RNGestureHandlerEventDispatcher.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\b\u001a\u00020\t\"\b\b\u0000\u0010\n*\u00020\u000b2\u0006\u0010\f\u001a\u0002H\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0002\u0010\u000fJ/\u0010\u0010\u001a\u00020\t\"\b\b\u0000\u0010\n*\u00020\u000b2\u0006\u0010\f\u001a\u0002H\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0002\u0010\u0014J\u001f\u0010\u0015\u001a\u00020\t\"\b\b\u0000\u0010\n*\u00020\u000b2\u0006\u0010\f\u001a\u0002H\nH\u0016¢\u0006\u0002\u0010\u0016J\u001f\u0010\u0017\u001a\u00020\t\"\b\b\u0000\u0010\n*\u00020\u000b2\u0006\u0010\f\u001a\u0002H\nH\u0002¢\u0006\u0002\u0010\u0016J/\u0010\u0018\u001a\u00020\t\"\b\b\u0000\u0010\n*\u00020\u000b2\u0006\u0010\f\u001a\u0002H\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0002\u0010\u0014J\u001f\u0010\u0019\u001a\u00020\t\"\b\b\u0000\u0010\n*\u00020\u000b2\u0006\u0010\f\u001a\u0002H\nH\u0002¢\u0006\u0002\u0010\u0016J%\u0010\u001a\u001a\u00020\t\"\u000e\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u001b2\u0006\u0010\r\u001a\u0002H\nH\u0002¢\u0006\u0002\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u001eH\u0002J\u0018\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/swmansion/gesturehandler/react/events/RNGestureHandlerEventDispatcher;", "Lcom/swmansion/gesturehandler/core/OnTouchEventListener;", "reactApplicationContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "reanimatedProxy", "Lcom/swmansion/gesturehandler/ReanimatedProxy;", "onHandlerUpdate", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/swmansion/gesturehandler/core/GestureHandler;", "handler", "event", "Landroid/view/MotionEvent;", "(Lcom/swmansion/gesturehandler/core/GestureHandler;Landroid/view/MotionEvent;)V", "onStateChange", "newState", "", "oldState", "(Lcom/swmansion/gesturehandler/core/GestureHandler;II)V", "onTouchEvent", "(Lcom/swmansion/gesturehandler/core/GestureHandler;)V", "dispatchHandlerUpdateEvent", "dispatchStateChangeEvent", "dispatchTouchEvent", "sendEventForReanimated", "Lcom/facebook/react/uimanager/events/Event;", "(Lcom/facebook/react/uimanager/events/Event;)V", "sendEventForNativeAnimatedEvent", "Lcom/swmansion/gesturehandler/react/events/RNGestureHandlerEvent;", "sendEventForDeviceEvent", "eventName", "", "data", "Lcom/facebook/react/bridge/WritableMap;", "react-native-gesture-handler_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RNGestureHandlerEventDispatcher implements OnTouchEventListener {
    private final ReactApplicationContext reactApplicationContext;
    private final ReanimatedProxy reanimatedProxy;

    public RNGestureHandlerEventDispatcher(ReactApplicationContext reactApplicationContext) {
        Intrinsics.checkNotNullParameter(reactApplicationContext, "reactApplicationContext");
        this.reactApplicationContext = reactApplicationContext;
        this.reanimatedProxy = new ReanimatedProxy();
    }

    @Override // com.swmansion.gesturehandler.core.OnTouchEventListener
    public <T extends GestureHandler> void onHandlerUpdate(T handler, MotionEvent event) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(event, "event");
        dispatchHandlerUpdateEvent(handler);
    }

    @Override // com.swmansion.gesturehandler.core.OnTouchEventListener
    public <T extends GestureHandler> void onStateChange(T handler, int newState, int oldState) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        dispatchStateChangeEvent(handler, newState, oldState);
    }

    @Override // com.swmansion.gesturehandler.core.OnTouchEventListener
    public <T extends GestureHandler> void onTouchEvent(T handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        dispatchTouchEvent(handler);
    }

    private final <T extends GestureHandler> void dispatchHandlerUpdateEvent(T handler) {
        GestureHandler.Factory<GestureHandler> factoryFindFactoryForHandler;
        EventHandlerType eventHandlerType;
        if (handler.getTag() < 0 || handler.getState() != 4 || (factoryFindFactoryForHandler = RNGestureHandlerFactoryUtil.INSTANCE.findFactoryForHandler(handler)) == null) {
            return;
        }
        switch (handler.getActionType()) {
            case 1:
                sendEventForReanimated(RNGestureHandlerEvent.INSTANCE.obtain(handler, handler.getActionType(), factoryFindFactoryForHandler.createEventBuilder(handler), EventHandlerType.ForJS));
                break;
            case 2:
                sendEventForNativeAnimatedEvent(RNGestureHandlerEvent.INSTANCE.obtain(handler, handler.getActionType(), factoryFindFactoryForHandler.createEventBuilder(handler), EventHandlerType.ForAnimated));
                break;
            case 3:
                sendEventForDeviceEvent("onGestureHandlerEvent", RNGestureHandlerEvent.INSTANCE.createEventData(factoryFindFactoryForHandler.createEventBuilder(handler)));
                break;
            case 4:
                sendEventForDeviceEvent("onGestureHandlerEvent", RNGestureHandlerEvent.INSTANCE.createEventData(factoryFindFactoryForHandler.createEventBuilder(handler)));
                break;
            case 5:
            case 6:
                if (handler.getDispatchesAnimatedEvents()) {
                    eventHandlerType = EventHandlerType.ForAnimated;
                } else if (handler.getDispatchesReanimatedEvents()) {
                    eventHandlerType = EventHandlerType.ForReanimated;
                } else {
                    eventHandlerType = EventHandlerType.ForJS;
                }
                RNGestureHandlerEvent rNGestureHandlerEventObtain = RNGestureHandlerEvent.INSTANCE.obtain(handler, handler.getActionType(), factoryFindFactoryForHandler.createEventBuilder(handler), eventHandlerType);
                RNGestureHandlerDetectorView hostDetectorView = handler.getHostDetectorView();
                if (hostDetectorView != null) {
                    hostDetectorView.dispatchEvent(rNGestureHandlerEventObtain);
                }
                break;
        }
    }

    private final <T extends GestureHandler> void dispatchStateChangeEvent(T handler, int newState, int oldState) {
        GestureHandler.Factory<GestureHandler> factoryFindFactoryForHandler;
        EventHandlerType eventHandlerType;
        if (handler.getTag() >= 0 && (factoryFindFactoryForHandler = RNGestureHandlerFactoryUtil.INSTANCE.findFactoryForHandler(handler)) != null) {
            switch (handler.getActionType()) {
                case 1:
                    sendEventForReanimated(RNGestureHandlerStateChangeEvent.INSTANCE.obtain(handler, newState, oldState, handler.getActionType(), factoryFindFactoryForHandler.createEventBuilder(handler), EventHandlerType.ForJS));
                    break;
                case 2:
                case 3:
                    sendEventForDeviceEvent(RNGestureHandlerStateChangeEvent.EVENT_NAME, RNGestureHandlerStateChangeEvent.INSTANCE.createEventData(factoryFindFactoryForHandler.createEventBuilder(handler), newState, oldState));
                    break;
                case 4:
                    sendEventForDeviceEvent(RNGestureHandlerStateChangeEvent.EVENT_NAME, RNGestureHandlerStateChangeEvent.INSTANCE.createEventData(factoryFindFactoryForHandler.createEventBuilder(handler), newState, oldState));
                    break;
                case 5:
                case 6:
                    if (handler.getDispatchesReanimatedEvents()) {
                        eventHandlerType = EventHandlerType.ForReanimated;
                    } else {
                        eventHandlerType = EventHandlerType.ForJS;
                    }
                    RNGestureHandlerStateChangeEvent rNGestureHandlerStateChangeEventObtain = RNGestureHandlerStateChangeEvent.INSTANCE.obtain(handler, newState, oldState, handler.getActionType(), factoryFindFactoryForHandler.createEventBuilder(handler), eventHandlerType);
                    RNGestureHandlerDetectorView hostDetectorView = handler.getHostDetectorView();
                    if (hostDetectorView != null) {
                        hostDetectorView.dispatchEvent(rNGestureHandlerStateChangeEventObtain);
                    }
                    break;
            }
        }
    }

    private final <T extends GestureHandler> void dispatchTouchEvent(T handler) {
        EventHandlerType eventHandlerType;
        if (handler.getTag() < 0) {
            return;
        }
        if (handler.getState() == 2 || handler.getState() == 4 || handler.getState() == 0 || handler.getView() != null) {
            int actionType = handler.getActionType();
            if (actionType == 1) {
                sendEventForReanimated(RNGestureHandlerTouchEvent.INSTANCE.obtain(handler, handler.getActionType(), EventHandlerType.ForJS));
                return;
            }
            if (actionType == 4) {
                sendEventForDeviceEvent("onGestureHandlerEvent", RNGestureHandlerTouchEvent.INSTANCE.createEventData(handler));
                return;
            }
            if (actionType == 5 || actionType == 6) {
                if (handler.getDispatchesReanimatedEvents()) {
                    eventHandlerType = EventHandlerType.ForReanimated;
                } else {
                    eventHandlerType = EventHandlerType.ForJS;
                }
                RNGestureHandlerTouchEvent rNGestureHandlerTouchEventObtain = RNGestureHandlerTouchEvent.INSTANCE.obtain(handler, handler.getActionType(), eventHandlerType);
                RNGestureHandlerDetectorView hostDetectorView = handler.getHostDetectorView();
                if (hostDetectorView != null) {
                    hostDetectorView.dispatchEvent(rNGestureHandlerTouchEventObtain);
                }
            }
        }
    }

    private final <T extends Event<T>> void sendEventForReanimated(T event) {
        this.reanimatedProxy.sendEvent(event, this.reactApplicationContext);
    }

    private final void sendEventForNativeAnimatedEvent(RNGestureHandlerEvent event) {
        ReactContextExtensionsKt.dispatchEvent(this.reactApplicationContext, event);
    }

    private final void sendEventForDeviceEvent(String eventName, WritableMap data) {
        ExtensionsKt.getDeviceEventEmitter(this.reactApplicationContext).emit(eventName, data);
    }
}
