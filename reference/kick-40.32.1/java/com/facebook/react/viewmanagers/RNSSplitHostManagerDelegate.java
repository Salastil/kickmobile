package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNSSplitHostManagerInterface;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes6.dex */
public class RNSSplitHostManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSSplitHostManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSSplitHostManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* JADX INFO: renamed from: setProperty */
    public void kotlinCompat$setProperty(T t, String str, Object obj) {
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -1485785973:
                if (str.equals("preferredSplitBehavior")) {
                    b = 0;
                }
                break;
            case -1439500848:
                if (str.equals("orientation")) {
                    b = 1;
                }
                break;
            case -868016417:
                if (str.equals("primaryEdge")) {
                    b = 2;
                }
                break;
            case -723350406:
                if (str.equals("showInspector")) {
                    b = 3;
                }
                break;
            case 84368445:
                if (str.equals("showSecondaryToggleButton")) {
                    b = 4;
                }
                break;
            case 429590084:
                if (str.equals("preferredDisplayMode")) {
                    b = 5;
                }
                break;
            case 546802369:
                if (str.equals("primaryBackgroundStyle")) {
                    b = 6;
                }
                break;
            case 607868808:
                if (str.equals("topColumnForCollapsing")) {
                    b = 7;
                }
                break;
            case 966195944:
                if (str.equals("colorScheme")) {
                    b = 8;
                }
                break;
            case 1093280619:
                if (str.equals("presentsWithGesture")) {
                    b = 9;
                }
                break;
            case 1446428553:
                if (str.equals("displayModeButtonVisibility")) {
                    b = 10;
                }
                break;
            case 1758738573:
                if (str.equals("columnMetrics")) {
                    b = Ascii.VT;
                }
                break;
        }
        switch (b) {
            case 0:
                ((RNSSplitHostManagerInterface) this.mViewManager).setPreferredSplitBehavior(t, (String) obj);
                break;
            case 1:
                ((RNSSplitHostManagerInterface) this.mViewManager).setOrientation(t, (String) obj);
                break;
            case 2:
                ((RNSSplitHostManagerInterface) this.mViewManager).setPrimaryEdge(t, (String) obj);
                break;
            case 3:
                ((RNSSplitHostManagerInterface) this.mViewManager).setShowInspector(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 4:
                ((RNSSplitHostManagerInterface) this.mViewManager).setShowSecondaryToggleButton(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 5:
                ((RNSSplitHostManagerInterface) this.mViewManager).setPreferredDisplayMode(t, (String) obj);
                break;
            case 6:
                ((RNSSplitHostManagerInterface) this.mViewManager).setPrimaryBackgroundStyle(t, (String) obj);
                break;
            case 7:
                ((RNSSplitHostManagerInterface) this.mViewManager).setTopColumnForCollapsing(t, (String) obj);
                break;
            case 8:
                ((RNSSplitHostManagerInterface) this.mViewManager).setColorScheme(t, (String) obj);
                break;
            case 9:
                ((RNSSplitHostManagerInterface) this.mViewManager).setPresentsWithGesture(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 10:
                ((RNSSplitHostManagerInterface) this.mViewManager).setDisplayModeButtonVisibility(t, (String) obj);
                break;
            case 11:
                ((RNSSplitHostManagerInterface) this.mViewManager).setColumnMetrics(t, (ReadableMap) obj);
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
        if (str.equals("showColumn")) {
            ((RNSSplitHostManagerInterface) this.mViewManager).showColumn(t, readableArray.getString(0));
        }
    }
}
