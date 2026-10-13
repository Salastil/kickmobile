package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* JADX INFO: loaded from: classes6.dex */
public interface RNGestureHandlerButtonManagerInterface<T extends View> extends ViewManagerWithGeneratedInterface {
    void setActiveOpacity(T t, float f);

    void setActiveScale(T t, float f);

    void setActiveUnderlayOpacity(T t, float f);

    void setBorderBlockColor(T t, Integer num);

    void setBorderBlockEndColor(T t, Integer num);

    void setBorderBlockStartColor(T t, Integer num);

    void setBorderBottomColor(T t, Integer num);

    void setBorderBottomEndRadius(T t, Dynamic dynamic);

    void setBorderBottomLeftRadius(T t, Dynamic dynamic);

    void setBorderBottomRightRadius(T t, Dynamic dynamic);

    void setBorderBottomStartRadius(T t, Dynamic dynamic);

    void setBorderBottomWidth(T t, float f);

    void setBorderColor(T t, Integer num);

    void setBorderEndColor(T t, Integer num);

    void setBorderEndEndRadius(T t, Dynamic dynamic);

    void setBorderEndStartRadius(T t, Dynamic dynamic);

    void setBorderEndWidth(T t, float f);

    void setBorderLeftColor(T t, Integer num);

    void setBorderLeftWidth(T t, float f);

    void setBorderRadius(T t, Dynamic dynamic);

    void setBorderRightColor(T t, Integer num);

    void setBorderRightWidth(T t, float f);

    void setBorderStartColor(T t, Integer num);

    void setBorderStartEndRadius(T t, Dynamic dynamic);

    void setBorderStartStartRadius(T t, Dynamic dynamic);

    void setBorderStartWidth(T t, float f);

    void setBorderStyle(T t, String str);

    void setBorderTopColor(T t, Integer num);

    void setBorderTopEndRadius(T t, Dynamic dynamic);

    void setBorderTopLeftRadius(T t, Dynamic dynamic);

    void setBorderTopRightRadius(T t, Dynamic dynamic);

    void setBorderTopStartRadius(T t, Dynamic dynamic);

    void setBorderTopWidth(T t, float f);

    void setBorderWidth(T t, float f);

    void setBorderless(T t, boolean z);

    void setCancelOnLeave(T t, boolean z);

    void setDefaultOpacity(T t, float f);

    void setDefaultScale(T t, float f);

    void setDefaultUnderlayOpacity(T t, float f);

    void setEnabled(T t, boolean z);

    void setExclusive(T t, boolean z);

    void setForeground(T t, boolean z);

    void setGestureHitSlop(T t, ReadableMap readableMap);

    void setGestureTestID(T t, String str);

    void setHandlerTag(T t, double d);

    void setHasLongPressHandler(T t, boolean z);

    void setHoverAnimationInDuration(T t, int i);

    void setHoverAnimationOutDuration(T t, int i);

    void setHoverOpacity(T t, float f);

    void setHoverScale(T t, float f);

    void setHoverUnderlayOpacity(T t, float f);

    void setLongPressAnimationOutDuration(T t, int i);

    void setLongPressDuration(T t, int i);

    void setModuleId(T t, int i);

    void setNeedsOffscreenAlphaCompositing(T t, boolean z);

    void setOverflow(T t, String str);

    void setPointerEvents(T t, String str);

    void setRippleColor(T t, Integer num);

    void setRippleRadius(T t, int i);

    void setTapAnimationInDuration(T t, int i);

    void setTapAnimationOutDuration(T t, int i);

    void setTouchSoundDisabled(T t, boolean z);

    void setUnderlayColor(T t, Integer num);
}
