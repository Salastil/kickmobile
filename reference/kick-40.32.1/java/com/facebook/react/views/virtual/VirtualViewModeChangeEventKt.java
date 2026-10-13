package com.facebook.react.views.virtual;

import android.graphics.Rect;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ViewProps;
import com.mux.stats.sdk.core.model.ViewDeviceOrientationData;
import kotlin.Metadata;

/* JADX INFO: compiled from: VirtualViewModeChangeEvent.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, d2 = {"toReadableMap", "Lcom/facebook/react/bridge/ReadableMap;", "Landroid/graphics/Rect;", "ReactAndroid"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class VirtualViewModeChangeEventKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final ReadableMap toReadableMap(Rect rect) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putDouble(ViewDeviceOrientationData.DEVICE_ORIENTATION_X, PixelUtil.INSTANCE.pxToDp(rect.left));
        writableMapCreateMap.putDouble(ViewDeviceOrientationData.DEVICE_ORIENTATION_Y, PixelUtil.INSTANCE.pxToDp(rect.top));
        writableMapCreateMap.putDouble(ViewProps.WIDTH, PixelUtil.INSTANCE.pxToDp(rect.width()));
        writableMapCreateMap.putDouble(ViewProps.HEIGHT, PixelUtil.INSTANCE.pxToDp(rect.height()));
        return writableMapCreateMap;
    }
}
