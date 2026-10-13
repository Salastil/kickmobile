package com.swmansion.gesturehandler.react.events;

import androidx.core.util.Pools;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.Event;
import com.mux.stats.sdk.core.model.ViewDeviceOrientationData;
import com.swmansion.gesturehandler.core.NativeViewGestureHandler;
import com.swmansion.gesturehandler.react.RNGestureHandlerButtonViewManager;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RNGestureHandlerButtonEvent.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u0019\u001aB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010\u0010\u001a\u00020\tH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/swmansion/gesturehandler/react/events/RNGestureHandlerButtonEvent;", "Lcom/facebook/react/uimanager/events/Event;", "<init>", "()V", "type", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerButtonViewManager$ButtonViewGroup$EventType;", "eventData", "Lcom/swmansion/gesturehandler/react/events/RNGestureHandlerButtonEvent$ButtonEventData;", "init", "", "button", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerButtonViewManager$ButtonViewGroup;", "handler", "Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler;", "sample", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerButtonViewManager$ButtonViewGroup$HoverSample;", "onDispose", "getEventName", "", "canCoalesce", "", "getCoalescingKey", "", "getEventData", "Lcom/facebook/react/bridge/WritableMap;", "ButtonEventData", "Companion", "react-native-gesture-handler_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RNGestureHandlerButtonEvent extends Event<RNGestureHandlerButtonEvent> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Pools.SynchronizedPool<RNGestureHandlerButtonEvent> EVENTS_POOL = new Pools.SynchronizedPool<>(7);
    private static final String ON_HOVER_IN_EVENT_NAME = "onButtonHoverIn";
    private static final String ON_HOVER_OUT_EVENT_NAME = "onButtonHoverOut";
    private static final String ON_INTERACTION_FINISHED_EVENT_NAME = "onButtonInteractionFinished";
    private static final String ON_LONG_PRESS_EVENT_NAME = "onButtonLongPress";
    private static final String ON_PRESS_EVENT_NAME = "onButtonPress";
    private static final String ON_PRESS_IN_EVENT_NAME = "onButtonPressIn";
    private static final String ON_PRESS_OUT_EVENT_NAME = "onButtonPressOut";
    private static final int TOUCH_EVENTS_POOL_SIZE = 7;
    private ButtonEventData eventData;
    private RNGestureHandlerButtonViewManager.ButtonViewGroup.EventType type;

    /* JADX INFO: compiled from: RNGestureHandlerButtonEvent.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RNGestureHandlerButtonViewManager.ButtonViewGroup.EventType.values().length];
            try {
                iArr[RNGestureHandlerButtonViewManager.ButtonViewGroup.EventType.Press.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RNGestureHandlerButtonViewManager.ButtonViewGroup.EventType.PressIn.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RNGestureHandlerButtonViewManager.ButtonViewGroup.EventType.PressOut.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[RNGestureHandlerButtonViewManager.ButtonViewGroup.EventType.LongPress.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[RNGestureHandlerButtonViewManager.ButtonViewGroup.EventType.HoverIn.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[RNGestureHandlerButtonViewManager.ButtonViewGroup.EventType.HoverOut.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[RNGestureHandlerButtonViewManager.ButtonViewGroup.EventType.InteractionFinished.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ RNGestureHandlerButtonEvent(DefaultConstructorMarker defaultConstructorMarker) {
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

    private RNGestureHandlerButtonEvent() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void init(RNGestureHandlerButtonViewManager.ButtonViewGroup button, NativeViewGestureHandler handler, RNGestureHandlerButtonViewManager.ButtonViewGroup.EventType type) {
        super.init(UIManagerHelper.getSurfaceId(button), button.getId());
        this.type = type;
        this.eventData = new ButtonEventData(PixelUtil.toDIPFromPixel(handler.getLastRelativePositionX()), PixelUtil.toDIPFromPixel(handler.getLastRelativePositionY()), PixelUtil.toDIPFromPixel(handler.getLastPositionInWindowX()), PixelUtil.toDIPFromPixel(handler.getLastPositionInWindowY()), handler.getNumberOfPointers(), handler.getPointerType(), handler.getIsWithinBounds());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void init(RNGestureHandlerButtonViewManager.ButtonViewGroup button, RNGestureHandlerButtonViewManager.ButtonViewGroup.HoverSample sample, RNGestureHandlerButtonViewManager.ButtonViewGroup.EventType type) {
        super.init(UIManagerHelper.getSurfaceId(button), button.getId());
        this.type = type;
        this.eventData = new ButtonEventData(PixelUtil.toDIPFromPixel(sample.getX()), PixelUtil.toDIPFromPixel(sample.getY()), PixelUtil.toDIPFromPixel(sample.getAbsoluteX()), PixelUtil.toDIPFromPixel(sample.getAbsoluteY()), 1, sample.getPointerType(), sample.getPointerInside());
    }

    @Override // com.facebook.react.uimanager.events.Event
    public void onDispose() {
        EVENTS_POOL.release(this);
    }

    @Override // com.facebook.react.uimanager.events.Event
    /* JADX INFO: renamed from: getEventName */
    public String getName() {
        RNGestureHandlerButtonViewManager.ButtonViewGroup.EventType eventType = this.type;
        if (eventType == null) {
            Intrinsics.throwUninitializedPropertyAccessException("type");
            eventType = null;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[eventType.ordinal()]) {
            case 1:
                return ON_PRESS_EVENT_NAME;
            case 2:
                return ON_PRESS_IN_EVENT_NAME;
            case 3:
                return ON_PRESS_OUT_EVENT_NAME;
            case 4:
                return ON_LONG_PRESS_EVENT_NAME;
            case 5:
                return ON_HOVER_IN_EVENT_NAME;
            case 6:
                return ON_HOVER_OUT_EVENT_NAME;
            case 7:
                return ON_INTERACTION_FINISHED_EVENT_NAME;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @Override // com.facebook.react.uimanager.events.Event
    /* JADX INFO: renamed from: getEventData */
    protected WritableMap getExtraData() {
        ButtonEventData buttonEventData = this.eventData;
        if (buttonEventData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventData");
            buttonEventData = null;
        }
        return buttonEventData.toWritableMap();
    }

    /* JADX INFO: compiled from: RNGestureHandlerButtonEvent.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0018\u001a\u00020\u0019J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003JO\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0014\u0010\"\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010$\u001a\u00020\bHÖ\u0081\u0004J\n\u0010%\u001a\u00020&HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006'"}, d2 = {"Lcom/swmansion/gesturehandler/react/events/RNGestureHandlerButtonEvent$ButtonEventData;", "", ViewDeviceOrientationData.DEVICE_ORIENTATION_X, "", ViewDeviceOrientationData.DEVICE_ORIENTATION_Y, "absoluteX", "absoluteY", "numberOfPointers", "", "pointerType", "pointerInside", "", "<init>", "(DDDDIIZ)V", "getX", "()D", "getY", "getAbsoluteX", "getAbsoluteY", "getNumberOfPointers", "()I", "getPointerType", "getPointerInside", "()Z", "toWritableMap", "Lcom/facebook/react/bridge/WritableMap;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "", "react-native-gesture-handler_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    private static final /* data */ class ButtonEventData {
        private final double absoluteX;
        private final double absoluteY;
        private final int numberOfPointers;
        private final boolean pointerInside;
        private final int pointerType;
        private final double x;
        private final double y;

        public static /* synthetic */ ButtonEventData copy$default(ButtonEventData buttonEventData, double d, double d2, double d3, double d4, int i, int i2, boolean z, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                d = buttonEventData.x;
            }
            return buttonEventData.copy(d, (i3 & 2) != 0 ? buttonEventData.y : d2, (i3 & 4) != 0 ? buttonEventData.absoluteX : d3, (i3 & 8) != 0 ? buttonEventData.absoluteY : d4, (i3 & 16) != 0 ? buttonEventData.numberOfPointers : i, (i3 & 32) != 0 ? buttonEventData.pointerType : i2, (i3 & 64) != 0 ? buttonEventData.pointerInside : z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final double getX() {
            return this.x;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final double getY() {
            return this.y;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final double getAbsoluteX() {
            return this.absoluteX;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final double getAbsoluteY() {
            return this.absoluteY;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final int getNumberOfPointers() {
            return this.numberOfPointers;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final int getPointerType() {
            return this.pointerType;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final boolean getPointerInside() {
            return this.pointerInside;
        }

        public final ButtonEventData copy(double x, double y, double absoluteX, double absoluteY, int numberOfPointers, int pointerType, boolean pointerInside) {
            return new ButtonEventData(x, y, absoluteX, absoluteY, numberOfPointers, pointerType, pointerInside);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ButtonEventData)) {
                return false;
            }
            ButtonEventData buttonEventData = (ButtonEventData) other;
            return Double.compare(this.x, buttonEventData.x) == 0 && Double.compare(this.y, buttonEventData.y) == 0 && Double.compare(this.absoluteX, buttonEventData.absoluteX) == 0 && Double.compare(this.absoluteY, buttonEventData.absoluteY) == 0 && this.numberOfPointers == buttonEventData.numberOfPointers && this.pointerType == buttonEventData.pointerType && this.pointerInside == buttonEventData.pointerInside;
        }

        public int hashCode() {
            return (((((((((((Double.hashCode(this.x) * 31) + Double.hashCode(this.y)) * 31) + Double.hashCode(this.absoluteX)) * 31) + Double.hashCode(this.absoluteY)) * 31) + Integer.hashCode(this.numberOfPointers)) * 31) + Integer.hashCode(this.pointerType)) * 31) + Boolean.hashCode(this.pointerInside);
        }

        public String toString() {
            return "ButtonEventData(x=" + this.x + ", y=" + this.y + ", absoluteX=" + this.absoluteX + ", absoluteY=" + this.absoluteY + ", numberOfPointers=" + this.numberOfPointers + ", pointerType=" + this.pointerType + ", pointerInside=" + this.pointerInside + ")";
        }

        public ButtonEventData(double d, double d2, double d3, double d4, int i, int i2, boolean z) {
            this.x = d;
            this.y = d2;
            this.absoluteX = d3;
            this.absoluteY = d4;
            this.numberOfPointers = i;
            this.pointerType = i2;
            this.pointerInside = z;
        }

        public final double getX() {
            return this.x;
        }

        public final double getY() {
            return this.y;
        }

        public final double getAbsoluteX() {
            return this.absoluteX;
        }

        public final double getAbsoluteY() {
            return this.absoluteY;
        }

        public final int getNumberOfPointers() {
            return this.numberOfPointers;
        }

        public final int getPointerType() {
            return this.pointerType;
        }

        public final boolean getPointerInside() {
            return this.pointerInside;
        }

        public final WritableMap toWritableMap() {
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putDouble(ViewDeviceOrientationData.DEVICE_ORIENTATION_X, this.x);
            writableMapCreateMap.putDouble(ViewDeviceOrientationData.DEVICE_ORIENTATION_Y, this.y);
            writableMapCreateMap.putDouble("absoluteX", this.absoluteX);
            writableMapCreateMap.putDouble("absoluteY", this.absoluteY);
            writableMapCreateMap.putInt("numberOfPointers", this.numberOfPointers);
            writableMapCreateMap.putInt("pointerType", this.pointerType);
            writableMapCreateMap.putBoolean("pointerInside", this.pointerInside);
            return writableMapCreateMap;
        }
    }

    /* JADX INFO: compiled from: RNGestureHandlerButtonEvent.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/swmansion/gesturehandler/react/events/RNGestureHandlerButtonEvent$Companion;", "", "<init>", "()V", "ON_PRESS_EVENT_NAME", "", "ON_PRESS_IN_EVENT_NAME", "ON_PRESS_OUT_EVENT_NAME", "ON_LONG_PRESS_EVENT_NAME", "ON_HOVER_IN_EVENT_NAME", "ON_HOVER_OUT_EVENT_NAME", "ON_INTERACTION_FINISHED_EVENT_NAME", "TOUCH_EVENTS_POOL_SIZE", "", "EVENTS_POOL", "Landroidx/core/util/Pools$SynchronizedPool;", "Lcom/swmansion/gesturehandler/react/events/RNGestureHandlerButtonEvent;", "obtain", "button", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerButtonViewManager$ButtonViewGroup;", "handler", "Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler;", "type", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerButtonViewManager$ButtonViewGroup$EventType;", "sample", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerButtonViewManager$ButtonViewGroup$HoverSample;", "react-native-gesture-handler_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RNGestureHandlerButtonEvent obtain(RNGestureHandlerButtonViewManager.ButtonViewGroup button, NativeViewGestureHandler handler, RNGestureHandlerButtonViewManager.ButtonViewGroup.EventType type) {
            Intrinsics.checkNotNullParameter(button, "button");
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(type, "type");
            RNGestureHandlerButtonEvent rNGestureHandlerButtonEvent = (RNGestureHandlerButtonEvent) RNGestureHandlerButtonEvent.EVENTS_POOL.acquire();
            if (rNGestureHandlerButtonEvent == null) {
                rNGestureHandlerButtonEvent = new RNGestureHandlerButtonEvent(null);
            }
            rNGestureHandlerButtonEvent.init(button, handler, type);
            return rNGestureHandlerButtonEvent;
        }

        public final RNGestureHandlerButtonEvent obtain(RNGestureHandlerButtonViewManager.ButtonViewGroup button, RNGestureHandlerButtonViewManager.ButtonViewGroup.HoverSample sample, RNGestureHandlerButtonViewManager.ButtonViewGroup.EventType type) {
            Intrinsics.checkNotNullParameter(button, "button");
            Intrinsics.checkNotNullParameter(sample, "sample");
            Intrinsics.checkNotNullParameter(type, "type");
            RNGestureHandlerButtonEvent rNGestureHandlerButtonEvent = (RNGestureHandlerButtonEvent) RNGestureHandlerButtonEvent.EVENTS_POOL.acquire();
            if (rNGestureHandlerButtonEvent == null) {
                rNGestureHandlerButtonEvent = new RNGestureHandlerButtonEvent(null);
            }
            rNGestureHandlerButtonEvent.init(button, sample, type);
            return rNGestureHandlerButtonEvent;
        }
    }
}
