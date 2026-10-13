package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface;
import com.google.common.base.Ascii;
import kotlin.io.encoding.Base64;
import org.bouncycastle.asn1.eac.EACTags;

/* JADX INFO: loaded from: classes6.dex */
public class RNGestureHandlerButtonManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNGestureHandlerButtonManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNGestureHandlerButtonManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* JADX INFO: renamed from: setProperty */
    public void kotlinCompat$setProperty(T t, String str, Object obj) {
        byte b;
        str.hashCode();
        switch (str) {
            case "rippleRadius":
                b = 0;
                break;
            case "borderRightColor":
                b = 1;
                break;
            case "borderRightWidth":
                b = 2;
                break;
            case "underlayColor":
                b = 3;
                break;
            case "enabled":
                b = 4;
                break;
            case "defaultUnderlayOpacity":
                b = 5;
                break;
            case "borderTopColor":
                b = 6;
                break;
            case "borderTopWidth":
                b = 7;
                break;
            case "borderBottomColor":
                b = 8;
                break;
            case "borderBottomWidth":
                b = 9;
                break;
            case "borderTopLeftRadius":
                b = 10;
                break;
            case "borderTopStartRadius":
                b = Ascii.VT;
                break;
            case "activeScale":
                b = Ascii.FF;
                break;
            case "borderBottomStartRadius":
                b = Ascii.CR;
                break;
            case "rippleColor":
                b = Ascii.SO;
                break;
            case "defaultScale":
                b = Ascii.SI;
                break;
            case "moduleId":
                b = Ascii.DLE;
                break;
            case "hoverAnimationOutDuration":
                b = 17;
                break;
            case "borderTopEndRadius":
                b = Ascii.DC2;
                break;
            case "longPressDuration":
                b = 19;
                break;
            case "pointerEvents":
                b = Ascii.DC4;
                break;
            case "hoverAnimationInDuration":
                b = Ascii.NAK;
                break;
            case "borderLeftColor":
                b = Ascii.SYN;
                break;
            case "borderLeftWidth":
                b = Ascii.ETB;
                break;
            case "borderStartEndRadius":
                b = Ascii.CAN;
                break;
            case "borderBottomEndRadius":
                b = Ascii.EM;
                break;
            case "hoverUnderlayOpacity":
                b = Ascii.SUB;
                break;
            case "borderStartStartRadius":
                b = Ascii.ESC;
                break;
            case "cancelOnLeave":
                b = Ascii.FS;
                break;
            case "gestureTestID":
                b = Ascii.GS;
                break;
            case "hoverScale":
                b = Ascii.RS;
                break;
            case "borderBlockStartColor":
                b = Ascii.US;
                break;
            case "borderTopRightRadius":
                b = 32;
                break;
            case "hasLongPressHandler":
                b = 33;
                break;
            case "overflow":
                b = 34;
                break;
            case "hoverOpacity":
                b = 35;
                break;
            case "tapAnimationOutDuration":
                b = 36;
                break;
            case "borderBottomLeftRadius":
                b = 37;
                break;
            case "borderBottomRightRadius":
                b = 38;
                break;
            case "longPressAnimationOutDuration":
                b = 39;
                break;
            case "gestureHitSlop":
                b = 40;
                break;
            case "borderBlockColor":
                b = 41;
                break;
            case "activeUnderlayOpacity":
                b = 42;
                break;
            case "borderColor":
                b = 43;
                break;
            case "defaultOpacity":
                b = 44;
                break;
            case "borderStyle":
                b = 45;
                break;
            case "borderWidth":
                b = 46;
                break;
            case "borderBlockEndColor":
                b = 47;
                break;
            case "borderEndStartRadius":
                b = 48;
                break;
            case "borderEndColor":
                b = 49;
                break;
            case "borderEndWidth":
                b = 50;
                break;
            case "borderRadius":
                b = 51;
                break;
            case "touchSoundDisabled":
                b = 52;
                break;
            case "tapAnimationInDuration":
                b = 53;
                break;
            case "needsOffscreenAlphaCompositing":
                b = 54;
                break;
            case "exclusive":
                b = 55;
                break;
            case "borderEndEndRadius":
                b = 56;
                break;
            case "borderless":
                b = 57;
                break;
            case "activeOpacity":
                b = 58;
                break;
            case "foreground":
                b = 59;
                break;
            case "handlerTag":
                b = 60;
                break;
            case "borderStartColor":
                b = Base64.padSymbol;
                break;
            case "borderStartWidth":
                b = 62;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setRippleRadius(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 1:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setBorderRightColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 2:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setBorderRightWidth(t, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 3:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setUnderlayColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 4:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 5:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setDefaultUnderlayOpacity(t, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 6:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setBorderTopColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 7:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setBorderTopWidth(t, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 8:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setBorderBottomColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 9:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setBorderBottomWidth(t, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 10:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setBorderTopLeftRadius(t, new DynamicFromObject(obj));
                break;
            case 11:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setBorderTopStartRadius(t, new DynamicFromObject(obj));
                break;
            case 12:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setActiveScale(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 13:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setBorderBottomStartRadius(t, new DynamicFromObject(obj));
                break;
            case 14:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setRippleColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 15:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setDefaultScale(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 16:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setModuleId(t, obj != null ? ((Double) obj).intValue() : -1);
                break;
            case 17:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setHoverAnimationOutDuration(t, obj != null ? ((Double) obj).intValue() : 100);
                break;
            case 18:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setBorderTopEndRadius(t, new DynamicFromObject(obj));
                break;
            case 19:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setLongPressDuration(t, obj != null ? ((Double) obj).intValue() : -1);
                break;
            case 20:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setPointerEvents(t, (String) obj);
                break;
            case 21:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setHoverAnimationInDuration(t, obj != null ? ((Double) obj).intValue() : 50);
                break;
            case 22:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setBorderLeftColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 23:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setBorderLeftWidth(t, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 24:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setBorderStartEndRadius(t, new DynamicFromObject(obj));
                break;
            case 25:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setBorderBottomEndRadius(t, new DynamicFromObject(obj));
                break;
            case 26:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setHoverUnderlayOpacity(t, obj != null ? ((Double) obj).floatValue() : -1.0f);
                break;
            case 27:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setBorderStartStartRadius(t, new DynamicFromObject(obj));
                break;
            case 28:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setCancelOnLeave(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 29:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setGestureTestID(t, obj == null ? null : (String) obj);
                break;
            case 30:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setHoverScale(t, obj != null ? ((Double) obj).floatValue() : -1.0f);
                break;
            case 31:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setBorderBlockStartColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 32:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setBorderTopRightRadius(t, new DynamicFromObject(obj));
                break;
            case 33:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setHasLongPressHandler(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 34:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setOverflow(t, obj == null ? ViewProps.VISIBLE : (String) obj);
                break;
            case 35:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setHoverOpacity(t, obj != null ? ((Double) obj).floatValue() : -1.0f);
                break;
            case 36:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setTapAnimationOutDuration(t, obj != null ? ((Double) obj).intValue() : 100);
                break;
            case 37:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setBorderBottomLeftRadius(t, new DynamicFromObject(obj));
                break;
            case 38:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setBorderBottomRightRadius(t, new DynamicFromObject(obj));
                break;
            case 39:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setLongPressAnimationOutDuration(t, obj != null ? ((Double) obj).intValue() : -1);
                break;
            case 40:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setGestureHitSlop(t, (ReadableMap) obj);
                break;
            case 41:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setBorderBlockColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 42:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setActiveUnderlayOpacity(t, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 43:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setBorderColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 44:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setDefaultOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 45:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setBorderStyle(t, obj == null ? "solid" : (String) obj);
                break;
            case 46:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setBorderWidth(t, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 47:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setBorderBlockEndColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 48:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setBorderEndStartRadius(t, new DynamicFromObject(obj));
                break;
            case 49:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setBorderEndColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 50:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setBorderEndWidth(t, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 51:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setBorderRadius(t, new DynamicFromObject(obj));
                break;
            case 52:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setTouchSoundDisabled(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 53:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setTapAnimationInDuration(t, obj != null ? ((Double) obj).intValue() : 50);
                break;
            case 54:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setNeedsOffscreenAlphaCompositing(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 55:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setExclusive(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 56:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setBorderEndEndRadius(t, new DynamicFromObject(obj));
                break;
            case 57:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setBorderless(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 58:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setActiveOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION /* 59 */:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setForeground(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 60:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setHandlerTag(t, obj == null ? 0.0d : ((Double) obj).doubleValue());
                break;
            case 61:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setBorderStartColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 62:
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setBorderStartWidth(t, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            default:
                super.kotlinCompat$setProperty(t, str, obj);
                break;
        }
    }
}
