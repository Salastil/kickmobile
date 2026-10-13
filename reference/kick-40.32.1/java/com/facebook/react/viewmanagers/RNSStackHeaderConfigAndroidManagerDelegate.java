package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.viewmanagers.RNSStackHeaderConfigAndroidManagerInterface;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes6.dex */
public class RNSStackHeaderConfigAndroidManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSStackHeaderConfigAndroidManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSStackHeaderConfigAndroidManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* JADX INFO: renamed from: setProperty */
    public void kotlinCompat$setProperty(T t, String str, Object obj) {
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -1726194350:
                if (str.equals("transparent")) {
                    b = 0;
                }
                break;
            case -1635632637:
                if (str.equals("backButtonHidden")) {
                    b = 1;
                }
                break;
            case -1351025853:
                if (str.equals("scrollFlagSnap")) {
                    b = 2;
                }
                break;
            case -1265371130:
                if (str.equals("scrollFlagScroll")) {
                    b = 3;
                }
                break;
            case -1217487446:
                if (str.equals(ViewProps.HIDDEN)) {
                    b = 4;
                }
                break;
            case -1149435991:
                if (str.equals("backButtonDrawableIconResourceName")) {
                    b = 5;
                }
                break;
            case -1116497648:
                if (str.equals("scrollFlagExitUntilCollapsed")) {
                    b = 6;
                }
                break;
            case -638202514:
                if (str.equals("scrollFlagEnterAlways")) {
                    b = 7;
                }
                break;
            case -166071306:
                if (str.equals("backButtonTintColorNormal")) {
                    b = 8;
                }
                break;
            case 3575610:
                if (str.equals("type")) {
                    b = 9;
                }
                break;
            case 110371416:
                if (str.equals("title")) {
                    b = 10;
                }
                break;
            case 358792301:
                if (str.equals("toolbarMenuGroupDividerEnabled")) {
                    b = Ascii.VT;
                }
                break;
            case 623064648:
                if (str.equals("backButtonTintColorFocused")) {
                    b = Ascii.FF;
                }
                break;
            case 944955529:
                if (str.equals("scrollFlagEnterAlwaysCollapsed")) {
                    b = Ascii.CR;
                }
                break;
            case 995841779:
                if (str.equals("backButtonTintColorPressed")) {
                    b = Ascii.SO;
                }
                break;
            case 1783433897:
                if (str.equals("backButtonImageIconResource")) {
                    b = Ascii.SI;
                }
                break;
            case 1815601018:
                if (str.equals("toolbarMenu")) {
                    b = Ascii.DLE;
                }
                break;
        }
        switch (b) {
            case 0:
                ((RNSStackHeaderConfigAndroidManagerInterface) this.mViewManager).setTransparent(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 1:
                ((RNSStackHeaderConfigAndroidManagerInterface) this.mViewManager).setBackButtonHidden(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 2:
                ((RNSStackHeaderConfigAndroidManagerInterface) this.mViewManager).setScrollFlagSnap(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 3:
                ((RNSStackHeaderConfigAndroidManagerInterface) this.mViewManager).setScrollFlagScroll(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 4:
                ((RNSStackHeaderConfigAndroidManagerInterface) this.mViewManager).setHidden(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 5:
                ((RNSStackHeaderConfigAndroidManagerInterface) this.mViewManager).setBackButtonDrawableIconResourceName(t, obj != null ? (String) obj : null);
                break;
            case 6:
                ((RNSStackHeaderConfigAndroidManagerInterface) this.mViewManager).setScrollFlagExitUntilCollapsed(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 7:
                ((RNSStackHeaderConfigAndroidManagerInterface) this.mViewManager).setScrollFlagEnterAlways(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 8:
                ((RNSStackHeaderConfigAndroidManagerInterface) this.mViewManager).setBackButtonTintColorNormal(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 9:
                ((RNSStackHeaderConfigAndroidManagerInterface) this.mViewManager).setType(t, (String) obj);
                break;
            case 10:
                ((RNSStackHeaderConfigAndroidManagerInterface) this.mViewManager).setTitle(t, obj != null ? (String) obj : null);
                break;
            case 11:
                ((RNSStackHeaderConfigAndroidManagerInterface) this.mViewManager).setToolbarMenuGroupDividerEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 12:
                ((RNSStackHeaderConfigAndroidManagerInterface) this.mViewManager).setBackButtonTintColorFocused(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 13:
                ((RNSStackHeaderConfigAndroidManagerInterface) this.mViewManager).setScrollFlagEnterAlwaysCollapsed(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 14:
                ((RNSStackHeaderConfigAndroidManagerInterface) this.mViewManager).setBackButtonTintColorPressed(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 15:
                ((RNSStackHeaderConfigAndroidManagerInterface) this.mViewManager).setBackButtonImageIconResource(t, (ReadableMap) obj);
                break;
            case 16:
                ((RNSStackHeaderConfigAndroidManagerInterface) this.mViewManager).setToolbarMenu(t, new DynamicFromObject(obj));
                break;
            default:
                super.kotlinCompat$setProperty(t, str, obj);
                break;
        }
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* JADX INFO: renamed from: receiveCommand */
    public void kotlinCompat$receiveCommand(T t, String str, ReadableArray readableArray) {
        str.hashCode();
        if (str.equals("updateToolbarMenuElements")) {
            ((RNSStackHeaderConfigAndroidManagerInterface) this.mViewManager).updateToolbarMenuElements(t, readableArray.getArray(0));
        }
    }
}
