package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNSFormSheetHostManagerInterface;

/* JADX INFO: loaded from: classes6.dex */
public class RNSFormSheetHostManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSFormSheetHostManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSFormSheetHostManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* JADX INFO: renamed from: setProperty */
    public void kotlinCompat$setProperty(T t, String str, Object obj) {
        str.hashCode();
        switch (str) {
            case "largestUndimmedDetentIndex":
                ((RNSFormSheetHostManagerInterface) this.mViewManager).setLargestUndimmedDetentIndex(t, obj != null ? ((Double) obj).intValue() : -1);
                break;
            case "isOpen":
                ((RNSFormSheetHostManagerInterface) this.mViewManager).setIsOpen(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "preferredCornerRadius":
                ((RNSFormSheetHostManagerInterface) this.mViewManager).setPreferredCornerRadius(t, obj == null ? -1.0f : ((Double) obj).floatValue());
                break;
            case "preventNativeDismiss":
                ((RNSFormSheetHostManagerInterface) this.mViewManager).setPreventNativeDismiss(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "prefersScrollingExpandsWhenScrolledToEdge":
                ((RNSFormSheetHostManagerInterface) this.mViewManager).setPrefersScrollingExpandsWhenScrolledToEdge(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case "nativeContainerBackgroundColor":
                ((RNSFormSheetHostManagerInterface) this.mViewManager).setNativeContainerBackgroundColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case "prefersGrabberVisible":
                ((RNSFormSheetHostManagerInterface) this.mViewManager).setPrefersGrabberVisible(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "detents":
                ((RNSFormSheetHostManagerInterface) this.mViewManager).setDetents(t, (ReadableArray) obj);
                break;
            case "initialDetentIndex":
                ((RNSFormSheetHostManagerInterface) this.mViewManager).setInitialDetentIndex(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            default:
                super.kotlinCompat$setProperty(t, str, obj);
                break;
        }
    }
}
