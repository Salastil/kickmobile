package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* JADX INFO: loaded from: classes6.dex */
public interface RNSFormSheetHostManagerInterface<T extends View> extends ViewManagerWithGeneratedInterface {
    void setDetents(T t, ReadableArray readableArray);

    void setInitialDetentIndex(T t, int i);

    void setIsOpen(T t, boolean z);

    void setLargestUndimmedDetentIndex(T t, int i);

    void setNativeContainerBackgroundColor(T t, Integer num);

    void setPreferredCornerRadius(T t, float f);

    void setPrefersGrabberVisible(T t, boolean z);

    void setPrefersScrollingExpandsWhenScrolledToEdge(T t, boolean z);

    void setPreventNativeDismiss(T t, boolean z);
}
