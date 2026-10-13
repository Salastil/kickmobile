package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* JADX INFO: loaded from: classes6.dex */
public interface RNSStackHeaderConfigAndroidManagerInterface<T extends View> extends ViewManagerWithGeneratedInterface {
    void setBackButtonDrawableIconResourceName(T t, String str);

    void setBackButtonHidden(T t, boolean z);

    void setBackButtonImageIconResource(T t, ReadableMap readableMap);

    void setBackButtonTintColorFocused(T t, Integer num);

    void setBackButtonTintColorNormal(T t, Integer num);

    void setBackButtonTintColorPressed(T t, Integer num);

    void setHidden(T t, boolean z);

    void setScrollFlagEnterAlways(T t, boolean z);

    void setScrollFlagEnterAlwaysCollapsed(T t, boolean z);

    void setScrollFlagExitUntilCollapsed(T t, boolean z);

    void setScrollFlagScroll(T t, boolean z);

    void setScrollFlagSnap(T t, boolean z);

    void setTitle(T t, String str);

    void setToolbarMenu(T t, Dynamic dynamic);

    void setToolbarMenuGroupDividerEnabled(T t, boolean z);

    void setTransparent(T t, boolean z);

    void setType(T t, String str);

    void updateToolbarMenuElements(T t, ReadableArray readableArray);
}
