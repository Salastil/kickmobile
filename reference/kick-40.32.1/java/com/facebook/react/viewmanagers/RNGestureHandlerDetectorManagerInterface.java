package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* JADX INFO: loaded from: classes6.dex */
public interface RNGestureHandlerDetectorManagerInterface<T extends View> extends ViewManagerWithGeneratedInterface {
    void setHandlerTags(T t, ReadableArray readableArray);

    void setModuleId(T t, int i);

    void setPointerEvents(T t, String str);

    void setVirtualChildren(T t, ReadableArray readableArray);
}
