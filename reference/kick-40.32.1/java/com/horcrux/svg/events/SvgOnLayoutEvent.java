package com.horcrux.svg.events;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.window.reflection.WindowExtensionsConstants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.events.Event;
import com.mux.stats.sdk.core.model.ViewDeviceOrientationData;

/* JADX INFO: loaded from: classes8.dex */
public class SvgOnLayoutEvent extends Event<SvgOnLayoutEvent> {
    public static final String EVENT_NAME = "topSvgLayout";
    public int height;
    public int width;
    public int x;
    public int y;

    @Override // com.facebook.react.uimanager.events.Event
    public short getCoalescingKey() {
        return (short) 0;
    }

    public SvgOnLayoutEvent(int i, int i2, int i3, int i4, int i5, int i6) {
        super(i, i2);
        this.x = i3;
        this.y = i4;
        this.width = i5;
        this.height = i6;
    }

    @Override // com.facebook.react.uimanager.events.Event
    /* JADX INFO: renamed from: getEventName */
    public String getName() {
        return EVENT_NAME;
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putDouble(ViewDeviceOrientationData.DEVICE_ORIENTATION_X, PixelUtil.toDIPFromPixel(this.x));
        writableMapCreateMap.putDouble(ViewDeviceOrientationData.DEVICE_ORIENTATION_Y, PixelUtil.toDIPFromPixel(this.y));
        writableMapCreateMap.putDouble(ViewProps.WIDTH, PixelUtil.toDIPFromPixel(this.width));
        writableMapCreateMap.putDouble(ViewProps.HEIGHT, PixelUtil.toDIPFromPixel(this.height));
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        writableMapCreateMap2.putMap(WindowExtensionsConstants.LAYOUT_PACKAGE, writableMapCreateMap);
        writableMapCreateMap2.putInt(TypedValues.Attributes.S_TARGET, getViewTag());
        return writableMapCreateMap2;
    }
}
