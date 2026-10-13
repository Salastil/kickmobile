package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNSScreenManagerInterface;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes6.dex */
public class RNSScreenManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSScreenManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSScreenManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* JADX INFO: renamed from: setProperty */
    public void kotlinCompat$setProperty(T t, String str, Object obj) {
        byte b;
        str.hashCode();
        switch (str) {
            case "synchronousShadowStateUpdatesEnabled":
                b = 0;
                break;
            case "bottomScrollEdgeEffect":
                b = 1;
                break;
            case "homeIndicatorHidden":
                b = 2;
                break;
            case "topScrollEdgeEffect":
                b = 3;
                break;
            case "gestureEnabled":
                b = 4;
                break;
            case "leftScrollEdgeEffect":
                b = 5;
                break;
            case "hideKeyboardOnSwipe":
                b = 6;
                break;
            case "rightScrollEdgeEffect":
                b = 7;
                break;
            case "sheetCornerRadius":
                b = 8;
                break;
            case "navigationBarHidden":
                b = 9;
                break;
            case "statusBarTranslucent":
                b = 10;
                break;
            case "stackPresentation":
                b = Ascii.VT;
                break;
            case "activityState":
                b = Ascii.FF;
                break;
            case "statusBarColor":
                b = Ascii.CR;
                break;
            case "statusBarStyle":
                b = Ascii.SO;
                break;
            case "fullScreenSwipeShadowEnabled":
                b = Ascii.SI;
                break;
            case "stackAnimation":
                b = Ascii.DLE;
                break;
            case "navigationBarColor":
                b = 17;
                break;
            case "screenId":
                b = Ascii.DC2;
                break;
            case "sheetInitialDetent":
                b = 19;
                break;
            case "sheetAllowedDetents":
                b = Ascii.DC4;
                break;
            case "replaceAnimation":
                b = Ascii.NAK;
                break;
            case "preventNativeDismiss":
                b = Ascii.SYN;
                break;
            case "iosOrientationInheritanceFixEnabled":
                b = Ascii.ETB;
                break;
            case "statusBarHidden":
                b = 24;
                break;
            case "fullScreenSwipeEnabled":
                b = Ascii.EM;
                break;
            case "gestureResponseDistance":
                b = Ascii.SUB;
                break;
            case "screenOrientation":
                b = Ascii.ESC;
                break;
            case "sheetLargestUndimmedDetent":
                b = Ascii.FS;
                break;
            case "transitionDuration":
                b = Ascii.GS;
                break;
            case "sheetShouldOverflowTopInset":
                b = Ascii.RS;
                break;
            case "swipeDirection":
                b = Ascii.US;
                break;
            case "customAnimationOnSwipe":
                b = 32;
                break;
            case "navigationBarTranslucent":
                b = 33;
                break;
            case "sheetElevation":
                b = 34;
                break;
            case "sheetDefaultResizeAnimationEnabled":
                b = 35;
                break;
            case "sheetGrabberVisible":
                b = 36;
                break;
            case "statusBarAnimation":
                b = 37;
                break;
            case "nativeBackButtonDismissalEnabled":
                b = 38;
                break;
            case "androidResetScreenShadowStateOnOrientationChangeEnabled":
                b = 39;
                break;
            case "sheetExpandsWhenScrolledToEdge":
                b = 40;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                ((RNSScreenManagerInterface) this.mViewManager).setSynchronousShadowStateUpdatesEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 1:
                ((RNSScreenManagerInterface) this.mViewManager).setBottomScrollEdgeEffect(t, (String) obj);
                break;
            case 2:
                ((RNSScreenManagerInterface) this.mViewManager).setHomeIndicatorHidden(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 3:
                ((RNSScreenManagerInterface) this.mViewManager).setTopScrollEdgeEffect(t, (String) obj);
                break;
            case 4:
                ((RNSScreenManagerInterface) this.mViewManager).setGestureEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 5:
                ((RNSScreenManagerInterface) this.mViewManager).setLeftScrollEdgeEffect(t, (String) obj);
                break;
            case 6:
                ((RNSScreenManagerInterface) this.mViewManager).setHideKeyboardOnSwipe(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 7:
                ((RNSScreenManagerInterface) this.mViewManager).setRightScrollEdgeEffect(t, (String) obj);
                break;
            case 8:
                ((RNSScreenManagerInterface) this.mViewManager).setSheetCornerRadius(t, obj != null ? ((Double) obj).floatValue() : -1.0f);
                break;
            case 9:
                ((RNSScreenManagerInterface) this.mViewManager).setNavigationBarHidden(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 10:
                ((RNSScreenManagerInterface) this.mViewManager).setStatusBarTranslucent(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 11:
                ((RNSScreenManagerInterface) this.mViewManager).setStackPresentation(t, (String) obj);
                break;
            case 12:
                ((RNSScreenManagerInterface) this.mViewManager).setActivityState(t, obj != null ? ((Double) obj).floatValue() : -1.0f);
                break;
            case 13:
                ((RNSScreenManagerInterface) this.mViewManager).setStatusBarColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 14:
                ((RNSScreenManagerInterface) this.mViewManager).setStatusBarStyle(t, obj != null ? (String) obj : null);
                break;
            case 15:
                ((RNSScreenManagerInterface) this.mViewManager).setFullScreenSwipeShadowEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 16:
                ((RNSScreenManagerInterface) this.mViewManager).setStackAnimation(t, (String) obj);
                break;
            case 17:
                ((RNSScreenManagerInterface) this.mViewManager).setNavigationBarColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 18:
                ((RNSScreenManagerInterface) this.mViewManager).setScreenId(t, obj == null ? "" : (String) obj);
                break;
            case 19:
                ((RNSScreenManagerInterface) this.mViewManager).setSheetInitialDetent(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 20:
                ((RNSScreenManagerInterface) this.mViewManager).setSheetAllowedDetents(t, (ReadableArray) obj);
                break;
            case 21:
                ((RNSScreenManagerInterface) this.mViewManager).setReplaceAnimation(t, (String) obj);
                break;
            case 22:
                ((RNSScreenManagerInterface) this.mViewManager).setPreventNativeDismiss(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 23:
                ((RNSScreenManagerInterface) this.mViewManager).setIosOrientationInheritanceFixEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 24:
                ((RNSScreenManagerInterface) this.mViewManager).setStatusBarHidden(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 25:
                ((RNSScreenManagerInterface) this.mViewManager).setFullScreenSwipeEnabled(t, (String) obj);
                break;
            case 26:
                ((RNSScreenManagerInterface) this.mViewManager).setGestureResponseDistance(t, (ReadableMap) obj);
                break;
            case 27:
                ((RNSScreenManagerInterface) this.mViewManager).setScreenOrientation(t, obj != null ? (String) obj : null);
                break;
            case 28:
                ((RNSScreenManagerInterface) this.mViewManager).setSheetLargestUndimmedDetent(t, obj != null ? ((Double) obj).intValue() : -1);
                break;
            case 29:
                ((RNSScreenManagerInterface) this.mViewManager).setTransitionDuration(t, obj == null ? 500 : ((Double) obj).intValue());
                break;
            case 30:
                ((RNSScreenManagerInterface) this.mViewManager).setSheetShouldOverflowTopInset(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 31:
                ((RNSScreenManagerInterface) this.mViewManager).setSwipeDirection(t, (String) obj);
                break;
            case 32:
                ((RNSScreenManagerInterface) this.mViewManager).setCustomAnimationOnSwipe(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 33:
                ((RNSScreenManagerInterface) this.mViewManager).setNavigationBarTranslucent(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 34:
                ((RNSScreenManagerInterface) this.mViewManager).setSheetElevation(t, obj != null ? ((Double) obj).intValue() : 24);
                break;
            case 35:
                ((RNSScreenManagerInterface) this.mViewManager).setSheetDefaultResizeAnimationEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 36:
                ((RNSScreenManagerInterface) this.mViewManager).setSheetGrabberVisible(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 37:
                ((RNSScreenManagerInterface) this.mViewManager).setStatusBarAnimation(t, obj != null ? (String) obj : null);
                break;
            case 38:
                ((RNSScreenManagerInterface) this.mViewManager).setNativeBackButtonDismissalEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 39:
                ((RNSScreenManagerInterface) this.mViewManager).setAndroidResetScreenShadowStateOnOrientationChangeEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 40:
                ((RNSScreenManagerInterface) this.mViewManager).setSheetExpandsWhenScrolledToEdge(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            default:
                super.kotlinCompat$setProperty(t, str, obj);
                break;
        }
    }
}
