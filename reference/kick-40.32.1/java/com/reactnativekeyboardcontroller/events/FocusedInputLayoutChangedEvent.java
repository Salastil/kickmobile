package com.reactnativekeyboardcontroller.events;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.window.reflection.WindowExtensionsConstants;
import com.datadog.android.rum.internal.domain.event.RumEventMeta;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.events.Event;
import com.mux.stats.sdk.core.model.ViewDeviceOrientationData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FocusedInputLayoutChangedEvent.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/reactnativekeyboardcontroller/events/FocusedInputLayoutChangedEvent;", "Lcom/facebook/react/uimanager/events/Event;", "surfaceId", "", RumEventMeta.VIEW_ID_KEY, "event", "Lcom/reactnativekeyboardcontroller/events/FocusedInputLayoutChangedEventData;", "<init>", "(IILcom/reactnativekeyboardcontroller/events/FocusedInputLayoutChangedEventData;)V", "getEventName", "", "getCoalescingKey", "", "getEventData", "Lcom/facebook/react/bridge/WritableMap;", "Companion", "react-native-keyboard-controller_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class FocusedInputLayoutChangedEvent extends Event<FocusedInputLayoutChangedEvent> {
    public static final String EVENT_NAME = "topFocusedInputLayoutChanged";
    private final FocusedInputLayoutChangedEventData event;

    @Override // com.facebook.react.uimanager.events.Event
    public short getCoalescingKey() {
        return (short) 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FocusedInputLayoutChangedEvent(int i, int i2, FocusedInputLayoutChangedEventData event) {
        super(i, i2);
        Intrinsics.checkNotNullParameter(event, "event");
        this.event = event;
    }

    @Override // com.facebook.react.uimanager.events.Event
    /* JADX INFO: renamed from: getEventName */
    public String getName() {
        return EVENT_NAME;
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt(TypedValues.Attributes.S_TARGET, this.event.getTarget());
        writableMapCreateMap.putInt("parentScrollViewTarget", this.event.getParentScrollViewTarget());
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        writableMapCreateMap2.putDouble(ViewDeviceOrientationData.DEVICE_ORIENTATION_X, this.event.getX());
        writableMapCreateMap2.putDouble(ViewDeviceOrientationData.DEVICE_ORIENTATION_Y, this.event.getY());
        writableMapCreateMap2.putDouble(ViewProps.WIDTH, this.event.getWidth());
        writableMapCreateMap2.putDouble(ViewProps.HEIGHT, this.event.getHeight());
        writableMapCreateMap2.putDouble("absoluteX", this.event.getAbsoluteX());
        writableMapCreateMap2.putDouble("absoluteY", this.event.getAbsoluteY());
        Unit unit = Unit.INSTANCE;
        writableMapCreateMap.putMap(WindowExtensionsConstants.LAYOUT_PACKAGE, writableMapCreateMap2);
        return writableMapCreateMap;
    }
}
