package com.swmansion.gesturehandler.react;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.TypedValue;
import android.view.Choreographer;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.ViewGroupKt;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.R;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.BackgroundStyleApplicator;
import com.facebook.react.uimanager.LengthPercentage;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactPointerEventsView;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.style.BorderRadiusProp;
import com.facebook.react.uimanager.style.BorderStyle;
import com.facebook.react.uimanager.style.LogicalEdge;
import com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerDelegate;
import com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface;
import com.mux.stats.sdk.core.model.ViewDeviceOrientationData;
import com.swmansion.gesturehandler.core.GestureHandler;
import com.swmansion.gesturehandler.core.GestureHandlerOrchestrator;
import com.swmansion.gesturehandler.core.HoverGestureHandler;
import com.swmansion.gesturehandler.core.NativeViewGestureHandler;
import com.swmansion.gesturehandler.react.events.RNGestureHandlerButtonEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: RNGestureHandlerButtonViewManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u0082\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0004\u0081\u0001\u0082\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u0018\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0017J\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0015H\u0017J\u001a\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\tH\u0017J\u001a\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0017J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001aH\u0002J\u0018\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0015H\u0017J\u0018\u0010 \u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\"H\u0017J\u0018\u0010#\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u0015H\u0017J\u0018\u0010%\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\"H\u0017J\u0018\u0010'\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u0015H\u0017J\u0018\u0010)\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u0015H\u0017J\u0018\u0010+\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010,\u001a\u00020-H\u0017J\u0018\u0010.\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010/\u001a\u00020-H\u0017J\u0018\u00100\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010/\u001a\u00020-H\u0017J\u0018\u00101\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010/\u001a\u00020-H\u0017J\u0018\u00102\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010/\u001a\u00020-H\u0017J\u0018\u00103\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010/\u001a\u00020-H\u0017J\u0018\u00104\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010/\u001a\u00020-H\u0017J\u001f\u00105\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\u00106\u001a\u0004\u0018\u00010\"H\u0017¢\u0006\u0002\u00107J\u001f\u00108\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010/\u001a\u0004\u0018\u00010\"H\u0017¢\u0006\u0002\u00107J\u001f\u00109\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010/\u001a\u0004\u0018\u00010\"H\u0017¢\u0006\u0002\u00107J\u001f\u0010:\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010/\u001a\u0004\u0018\u00010\"H\u0017¢\u0006\u0002\u00107J\u001f\u0010;\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010/\u001a\u0004\u0018\u00010\"H\u0017¢\u0006\u0002\u00107J\u001f\u0010<\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010/\u001a\u0004\u0018\u00010\"H\u0017¢\u0006\u0002\u00107J\u001f\u0010=\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010/\u001a\u0004\u0018\u00010\"H\u0017¢\u0006\u0002\u00107J\u001f\u0010>\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010/\u001a\u0004\u0018\u00010\"H\u0017¢\u0006\u0002\u00107J\u001f\u0010?\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010/\u001a\u0004\u0018\u00010\"H\u0017¢\u0006\u0002\u00107J\u001f\u0010@\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010/\u001a\u0004\u0018\u00010\"H\u0017¢\u0006\u0002\u00107J\u001a\u0010A\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010B\u001a\u0004\u0018\u00010\tH\u0017J\u001a\u0010C\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010D\u001a\u0004\u0018\u00010\tH\u0017J \u0010E\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010F\u001a\u00020G2\u0006\u0010/\u001a\u00020HH\u0002J\u0018\u0010I\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010/\u001a\u00020HH\u0017J\u0018\u0010J\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010/\u001a\u00020HH\u0017J\u0018\u0010K\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010/\u001a\u00020HH\u0017J\u0018\u0010L\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010/\u001a\u00020HH\u0017J\u0018\u0010M\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010/\u001a\u00020HH\u0017J\u0018\u0010N\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010/\u001a\u00020HH\u0017J\u0018\u0010O\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010/\u001a\u00020HH\u0017J\u0018\u0010P\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010/\u001a\u00020HH\u0017J\u0018\u0010Q\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010/\u001a\u00020HH\u0017J\u0018\u0010R\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010/\u001a\u00020HH\u0017J\u0018\u0010S\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010/\u001a\u00020HH\u0017J\u0018\u0010T\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010/\u001a\u00020HH\u0017J\u0018\u0010U\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010/\u001a\u00020HH\u0017J\u001f\u0010V\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010W\u001a\u0004\u0018\u00010\"H\u0017¢\u0006\u0002\u00107J\u0018\u0010X\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010Y\u001a\u00020\"H\u0017J\u0018\u0010Z\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010[\u001a\u00020\u0015H\u0017J\u0018\u0010\\\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010]\u001a\u00020\u0015H\u0017J\u0018\u0010^\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\"H\u0017J\u0018\u0010_\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\"H\u0017J\u0018\u0010`\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\"H\u0017J\u0018\u0010a\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\"H\u0017J\u0018\u0010b\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u0015H\u0017J\u0018\u0010c\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010d\u001a\u00020-H\u0017J\u0018\u0010e\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010f\u001a\u00020-H\u0017J\u0018\u0010g\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010h\u001a\u00020-H\u0017J\u0018\u0010i\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010j\u001a\u00020-H\u0017J\u001f\u0010k\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010l\u001a\u0004\u0018\u00010\"H\u0017¢\u0006\u0002\u00107J\u0018\u0010m\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010n\u001a\u00020-H\u0017J\u0018\u0010o\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010p\u001a\u00020-H\u0017J\u0018\u0010q\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010r\u001a\u00020-H\u0017J\u0018\u0010s\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010t\u001a\u00020-H\u0017J\u0018\u0010u\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010v\u001a\u00020-H\u0017J\u0018\u0010w\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\"H\u0017J\u0018\u0010x\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\"H\u0017J\u001a\u0010y\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010z\u001a\u0004\u0018\u00010\tH\u0017J\u0010\u0010{\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J\u0010\u0010|\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J\u0010\u0010}\u001a\u00020~2\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J\u0010\u0010\u007f\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0014J\u0011\u0010\u0080\u0001\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007H\u0014R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0083\u0001"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerButtonViewManager;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerButtonViewManager$ButtonViewGroup;", "Lcom/facebook/react/viewmanagers/RNGestureHandlerButtonManagerInterface;", "<init>", "()V", "mDelegate", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "getName", "", "createViewInstance", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lcom/facebook/react/uimanager/ThemedReactContext;", "onDropViewInstance", "", "view", "setHandlerTag", "handlerTag", "", "setCancelOnLeave", "cancelOnLeave", "", "setGestureTestID", "gestureTestID", "setGestureHitSlop", "gestureHitSlop", "Lcom/facebook/react/bridge/ReadableMap;", "parseHitSlop", "Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler$HitSlop;", "hitSlop", "setHasLongPressHandler", "hasLongPressHandler", "setModuleId", "moduleId", "", "setForeground", "useDrawableOnForeground", "setBackgroundColor", ViewProps.BACKGROUND_COLOR, "setBorderless", "useBorderlessDrawable", "setEnabled", "enabled", "setBorderWidth", ViewProps.BORDER_WIDTH, "", "setBorderLeftWidth", "value", "setBorderRightWidth", "setBorderTopWidth", "setBorderBottomWidth", "setBorderStartWidth", "setBorderEndWidth", "setBorderColor", ViewProps.BORDER_COLOR, "(Lcom/swmansion/gesturehandler/react/RNGestureHandlerButtonViewManager$ButtonViewGroup;Ljava/lang/Integer;)V", "setBorderLeftColor", "setBorderRightColor", "setBorderTopColor", "setBorderBottomColor", "setBorderStartColor", "setBorderEndColor", "setBorderBlockColor", "setBorderBlockEndColor", "setBorderBlockStartColor", "setBorderStyle", "borderStyle", "setOverflow", ViewProps.OVERFLOW, "setBorderRadiusInternal", "prop", "Lcom/facebook/react/uimanager/style/BorderRadiusProp;", "Lcom/facebook/react/bridge/Dynamic;", "setBorderRadius", "setBorderTopLeftRadius", "setBorderTopRightRadius", "setBorderBottomRightRadius", "setBorderBottomLeftRadius", "setBorderTopStartRadius", "setBorderTopEndRadius", "setBorderBottomStartRadius", "setBorderBottomEndRadius", "setBorderEndEndRadius", "setBorderEndStartRadius", "setBorderStartEndRadius", "setBorderStartStartRadius", "setRippleColor", "rippleColor", "setRippleRadius", "rippleRadius", "setExclusive", "exclusive", "setTouchSoundDisabled", "touchSoundDisabled", "setTapAnimationInDuration", "setTapAnimationOutDuration", "setLongPressDuration", "setLongPressAnimationOutDuration", "setNeedsOffscreenAlphaCompositing", "setDefaultOpacity", "defaultOpacity", "setActiveOpacity", "targetOpacity", "setDefaultScale", "defaultScale", "setActiveScale", "activeScale", "setUnderlayColor", "underlayColor", "setDefaultUnderlayOpacity", "defaultUnderlayOpacity", "setActiveUnderlayOpacity", "activeUnderlayOpacity", "setHoverOpacity", "hoverOpacity", "setHoverScale", "hoverScale", "setHoverUnderlayOpacity", "hoverUnderlayOpacity", "setHoverAnimationInDuration", "setHoverAnimationOutDuration", "setPointerEvents", ViewProps.POINTER_EVENTS, "updateManagedHandler", "dropManagedHandler", "buildManagedHandlerConfig", "Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler$Config;", "onAfterUpdateTransaction", "getDelegate", "ButtonViewGroup", "Companion", "react-native-gesture-handler_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
@ReactModule(name = RNGestureHandlerButtonViewManager.REACT_CLASS)
public final class RNGestureHandlerButtonViewManager extends ViewGroupManager<ButtonViewGroup> implements RNGestureHandlerButtonManagerInterface<ButtonViewGroup> {
    public static final String REACT_CLASS = "RNGestureHandlerButton";
    private final ViewManagerDelegate<ButtonViewGroup> mDelegate;

    public RNGestureHandlerButtonViewManager() {
        super(null, 1, null);
        this.mDelegate = new RNGestureHandlerButtonManagerDelegate(this);
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public ButtonViewGroup createViewInstance(ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ButtonViewGroup(context);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onDropViewInstance(ButtonViewGroup view) {
        Intrinsics.checkNotNullParameter(view, "view");
        dropManagedHandler(view);
        view.setPendingHandlerTag(null);
        view.setManagedHandlerCancelOnLeave(null);
        view.setManagedHandlerTestID(null);
        view.setManagedHandlerHitSlop(null);
        view.setModuleId(null);
        view.resetHoverState();
        view.setManagedHandlerNeedsUpdate(false);
        super.onDropViewInstance(view);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = "handlerTag")
    public void setHandlerTag(ButtonViewGroup view, double handlerTag) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setPendingHandlerTag(Double.valueOf(handlerTag));
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = "cancelOnLeave")
    public void setCancelOnLeave(ButtonViewGroup view, boolean cancelOnLeave) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setManagedHandlerCancelOnLeave(Boolean.valueOf(cancelOnLeave));
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = "gestureTestID")
    public void setGestureTestID(ButtonViewGroup view, String gestureTestID) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setManagedHandlerTestID(gestureTestID);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = "gestureHitSlop")
    public void setGestureHitSlop(ButtonViewGroup view, ReadableMap gestureHitSlop) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setManagedHandlerHitSlop(gestureHitSlop != null ? parseHitSlop(gestureHitSlop) : null);
    }

    private static final float parseHitSlop$edge(ReadableMap readableMap, String str) {
        if (readableMap.hasKey(str)) {
            return PixelUtil.toPixelFromDIP(readableMap.getDouble(str));
        }
        return Float.NaN;
    }

    private final NativeViewGestureHandler.HitSlop parseHitSlop(ReadableMap hitSlop) {
        return new NativeViewGestureHandler.HitSlop(parseHitSlop$edge(hitSlop, "left"), parseHitSlop$edge(hitSlop, ViewProps.TOP), parseHitSlop$edge(hitSlop, "right"), parseHitSlop$edge(hitSlop, ViewProps.BOTTOM));
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = "hasLongPressHandler")
    public void setHasLongPressHandler(ButtonViewGroup view, boolean hasLongPressHandler) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setHasLongPressHandler(hasLongPressHandler);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = "moduleId")
    public void setModuleId(ButtonViewGroup view, int moduleId) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setModuleId(Integer.valueOf(moduleId));
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = "foreground")
    public void setForeground(ButtonViewGroup view, boolean useDrawableOnForeground) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setUseDrawableOnForeground(useDrawableOnForeground);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager
    @ReactProp(name = ViewProps.BACKGROUND_COLOR)
    public void setBackgroundColor(ButtonViewGroup view, int backgroundColor) {
        Intrinsics.checkNotNullParameter(view, "view");
        BackgroundStyleApplicator.setBackgroundColor(view, Integer.valueOf(backgroundColor));
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = "borderless")
    public void setBorderless(ButtonViewGroup view, boolean useBorderlessDrawable) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setUseBorderlessDrawable(useBorderlessDrawable);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = "enabled")
    public void setEnabled(ButtonViewGroup view, boolean enabled) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setEnabled(enabled);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = ViewProps.BORDER_WIDTH)
    public void setBorderWidth(ButtonViewGroup view, float borderWidth) {
        Intrinsics.checkNotNullParameter(view, "view");
        BackgroundStyleApplicator.setBorderWidth(view, LogicalEdge.ALL, Float.valueOf(borderWidth));
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = ViewProps.BORDER_LEFT_WIDTH)
    public void setBorderLeftWidth(ButtonViewGroup view, float value) {
        Intrinsics.checkNotNullParameter(view, "view");
        BackgroundStyleApplicator.setBorderWidth(view, LogicalEdge.LEFT, Float.valueOf(value));
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = ViewProps.BORDER_RIGHT_WIDTH)
    public void setBorderRightWidth(ButtonViewGroup view, float value) {
        Intrinsics.checkNotNullParameter(view, "view");
        BackgroundStyleApplicator.setBorderWidth(view, LogicalEdge.RIGHT, Float.valueOf(value));
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = ViewProps.BORDER_TOP_WIDTH)
    public void setBorderTopWidth(ButtonViewGroup view, float value) {
        Intrinsics.checkNotNullParameter(view, "view");
        BackgroundStyleApplicator.setBorderWidth(view, LogicalEdge.TOP, Float.valueOf(value));
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = ViewProps.BORDER_BOTTOM_WIDTH)
    public void setBorderBottomWidth(ButtonViewGroup view, float value) {
        Intrinsics.checkNotNullParameter(view, "view");
        BackgroundStyleApplicator.setBorderWidth(view, LogicalEdge.BOTTOM, Float.valueOf(value));
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = ViewProps.BORDER_START_WIDTH)
    public void setBorderStartWidth(ButtonViewGroup view, float value) {
        Intrinsics.checkNotNullParameter(view, "view");
        BackgroundStyleApplicator.setBorderWidth(view, LogicalEdge.START, Float.valueOf(value));
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = ViewProps.BORDER_END_WIDTH)
    public void setBorderEndWidth(ButtonViewGroup view, float value) {
        Intrinsics.checkNotNullParameter(view, "view");
        BackgroundStyleApplicator.setBorderWidth(view, LogicalEdge.END, Float.valueOf(value));
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = ViewProps.BORDER_COLOR)
    public void setBorderColor(ButtonViewGroup view, Integer borderColor) {
        Intrinsics.checkNotNullParameter(view, "view");
        BackgroundStyleApplicator.setBorderColor(view, LogicalEdge.ALL, borderColor);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = ViewProps.BORDER_LEFT_COLOR)
    public void setBorderLeftColor(ButtonViewGroup view, Integer value) {
        Intrinsics.checkNotNullParameter(view, "view");
        BackgroundStyleApplicator.setBorderColor(view, LogicalEdge.LEFT, value);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = ViewProps.BORDER_RIGHT_COLOR)
    public void setBorderRightColor(ButtonViewGroup view, Integer value) {
        Intrinsics.checkNotNullParameter(view, "view");
        BackgroundStyleApplicator.setBorderColor(view, LogicalEdge.RIGHT, value);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = ViewProps.BORDER_TOP_COLOR)
    public void setBorderTopColor(ButtonViewGroup view, Integer value) {
        Intrinsics.checkNotNullParameter(view, "view");
        BackgroundStyleApplicator.setBorderColor(view, LogicalEdge.TOP, value);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = ViewProps.BORDER_BOTTOM_COLOR)
    public void setBorderBottomColor(ButtonViewGroup view, Integer value) {
        Intrinsics.checkNotNullParameter(view, "view");
        BackgroundStyleApplicator.setBorderColor(view, LogicalEdge.BOTTOM, value);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = ViewProps.BORDER_START_COLOR)
    public void setBorderStartColor(ButtonViewGroup view, Integer value) {
        Intrinsics.checkNotNullParameter(view, "view");
        BackgroundStyleApplicator.setBorderColor(view, LogicalEdge.START, value);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = ViewProps.BORDER_END_COLOR)
    public void setBorderEndColor(ButtonViewGroup view, Integer value) {
        Intrinsics.checkNotNullParameter(view, "view");
        BackgroundStyleApplicator.setBorderColor(view, LogicalEdge.END, value);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = ViewProps.BORDER_BLOCK_COLOR)
    public void setBorderBlockColor(ButtonViewGroup view, Integer value) {
        Intrinsics.checkNotNullParameter(view, "view");
        BackgroundStyleApplicator.setBorderColor(view, LogicalEdge.BLOCK, value);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = ViewProps.BORDER_BLOCK_END_COLOR)
    public void setBorderBlockEndColor(ButtonViewGroup view, Integer value) {
        Intrinsics.checkNotNullParameter(view, "view");
        BackgroundStyleApplicator.setBorderColor(view, LogicalEdge.BLOCK_END, value);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = ViewProps.BORDER_BLOCK_START_COLOR)
    public void setBorderBlockStartColor(ButtonViewGroup view, Integer value) {
        Intrinsics.checkNotNullParameter(view, "view");
        BackgroundStyleApplicator.setBorderColor(view, LogicalEdge.BLOCK_START, value);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = "borderStyle")
    public void setBorderStyle(ButtonViewGroup view, String borderStyle) {
        Intrinsics.checkNotNullParameter(view, "view");
        BackgroundStyleApplicator.setBorderStyle(view, borderStyle == null ? null : BorderStyle.INSTANCE.fromString(borderStyle));
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = ViewProps.OVERFLOW)
    public void setOverflow(ButtonViewGroup view, String overflow) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setOverflow(overflow);
    }

    private final void setBorderRadiusInternal(ButtonViewGroup view, BorderRadiusProp prop, Dynamic value) {
        BackgroundStyleApplicator.setBorderRadius(view, prop, LengthPercentage.Companion.setFromDynamic$default(LengthPercentage.INSTANCE, value, false, 2, null));
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = ViewProps.BORDER_RADIUS)
    public void setBorderRadius(ButtonViewGroup view, Dynamic value) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(value, "value");
        setBorderRadiusInternal(view, BorderRadiusProp.BORDER_RADIUS, value);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = ViewProps.BORDER_TOP_LEFT_RADIUS)
    public void setBorderTopLeftRadius(ButtonViewGroup view, Dynamic value) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(value, "value");
        setBorderRadiusInternal(view, BorderRadiusProp.BORDER_TOP_LEFT_RADIUS, value);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = ViewProps.BORDER_TOP_RIGHT_RADIUS)
    public void setBorderTopRightRadius(ButtonViewGroup view, Dynamic value) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(value, "value");
        setBorderRadiusInternal(view, BorderRadiusProp.BORDER_TOP_RIGHT_RADIUS, value);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = ViewProps.BORDER_BOTTOM_RIGHT_RADIUS)
    public void setBorderBottomRightRadius(ButtonViewGroup view, Dynamic value) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(value, "value");
        setBorderRadiusInternal(view, BorderRadiusProp.BORDER_BOTTOM_RIGHT_RADIUS, value);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = ViewProps.BORDER_BOTTOM_LEFT_RADIUS)
    public void setBorderBottomLeftRadius(ButtonViewGroup view, Dynamic value) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(value, "value");
        setBorderRadiusInternal(view, BorderRadiusProp.BORDER_BOTTOM_LEFT_RADIUS, value);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = ViewProps.BORDER_TOP_START_RADIUS)
    public void setBorderTopStartRadius(ButtonViewGroup view, Dynamic value) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(value, "value");
        setBorderRadiusInternal(view, BorderRadiusProp.BORDER_TOP_START_RADIUS, value);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = ViewProps.BORDER_TOP_END_RADIUS)
    public void setBorderTopEndRadius(ButtonViewGroup view, Dynamic value) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(value, "value");
        setBorderRadiusInternal(view, BorderRadiusProp.BORDER_TOP_END_RADIUS, value);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = ViewProps.BORDER_BOTTOM_START_RADIUS)
    public void setBorderBottomStartRadius(ButtonViewGroup view, Dynamic value) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(value, "value");
        setBorderRadiusInternal(view, BorderRadiusProp.BORDER_BOTTOM_START_RADIUS, value);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = ViewProps.BORDER_BOTTOM_END_RADIUS)
    public void setBorderBottomEndRadius(ButtonViewGroup view, Dynamic value) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(value, "value");
        setBorderRadiusInternal(view, BorderRadiusProp.BORDER_BOTTOM_END_RADIUS, value);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = ViewProps.BORDER_END_END_RADIUS)
    public void setBorderEndEndRadius(ButtonViewGroup view, Dynamic value) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(value, "value");
        setBorderRadiusInternal(view, BorderRadiusProp.BORDER_END_END_RADIUS, value);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = ViewProps.BORDER_END_START_RADIUS)
    public void setBorderEndStartRadius(ButtonViewGroup view, Dynamic value) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(value, "value");
        setBorderRadiusInternal(view, BorderRadiusProp.BORDER_END_START_RADIUS, value);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = ViewProps.BORDER_START_END_RADIUS)
    public void setBorderStartEndRadius(ButtonViewGroup view, Dynamic value) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(value, "value");
        setBorderRadiusInternal(view, BorderRadiusProp.BORDER_START_END_RADIUS, value);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = ViewProps.BORDER_START_START_RADIUS)
    public void setBorderStartStartRadius(ButtonViewGroup view, Dynamic value) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(value, "value");
        setBorderRadiusInternal(view, BorderRadiusProp.BORDER_START_START_RADIUS, value);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = "rippleColor")
    public void setRippleColor(ButtonViewGroup view, Integer rippleColor) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setRippleColor(rippleColor);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = "rippleRadius")
    public void setRippleRadius(ButtonViewGroup view, int rippleRadius) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setRippleRadius(Integer.valueOf(rippleRadius));
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = "exclusive")
    public void setExclusive(ButtonViewGroup view, boolean exclusive) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setExclusive(exclusive);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = "touchSoundDisabled")
    public void setTouchSoundDisabled(ButtonViewGroup view, boolean touchSoundDisabled) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setSoundEffectsEnabled(!touchSoundDisabled);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = "tapAnimationInDuration")
    public void setTapAnimationInDuration(ButtonViewGroup view, int value) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (value <= 0) {
            value = 0;
        }
        view.setTapAnimationInDuration(value);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = "tapAnimationOutDuration")
    public void setTapAnimationOutDuration(ButtonViewGroup view, int value) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (value <= 0) {
            value = 0;
        }
        view.setTapAnimationOutDuration(value);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = "longPressDuration")
    public void setLongPressDuration(ButtonViewGroup view, int value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setLongPressDuration(value);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = "longPressAnimationOutDuration")
    public void setLongPressAnimationOutDuration(ButtonViewGroup view, int value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setLongPressAnimationOutDuration(value);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = ViewProps.NEEDS_OFFSCREEN_ALPHA_COMPOSITING)
    public void setNeedsOffscreenAlphaCompositing(ButtonViewGroup view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setNeedsOffscreenAlphaCompositing(value);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = "defaultOpacity")
    public void setDefaultOpacity(ButtonViewGroup view, float defaultOpacity) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setDefaultOpacity(defaultOpacity);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = "activeOpacity")
    public void setActiveOpacity(ButtonViewGroup view, float targetOpacity) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setActiveOpacity(targetOpacity);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = "defaultScale")
    public void setDefaultScale(ButtonViewGroup view, float defaultScale) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setDefaultScale(defaultScale);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = "activeScale")
    public void setActiveScale(ButtonViewGroup view, float activeScale) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setActiveScale(activeScale);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = "underlayColor")
    public void setUnderlayColor(ButtonViewGroup view, Integer underlayColor) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setUnderlayColor(underlayColor);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = "defaultUnderlayOpacity")
    public void setDefaultUnderlayOpacity(ButtonViewGroup view, float defaultUnderlayOpacity) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setDefaultUnderlayOpacity(defaultUnderlayOpacity);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = "activeUnderlayOpacity")
    public void setActiveUnderlayOpacity(ButtonViewGroup view, float activeUnderlayOpacity) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setActiveUnderlayOpacity(activeUnderlayOpacity);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = "hoverOpacity")
    public void setHoverOpacity(ButtonViewGroup view, float hoverOpacity) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setHoverOpacity(hoverOpacity);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = "hoverScale")
    public void setHoverScale(ButtonViewGroup view, float hoverScale) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setHoverScale(hoverScale);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = "hoverUnderlayOpacity")
    public void setHoverUnderlayOpacity(ButtonViewGroup view, float hoverUnderlayOpacity) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setHoverUnderlayOpacity(hoverUnderlayOpacity);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = "hoverAnimationInDuration")
    public void setHoverAnimationInDuration(ButtonViewGroup view, int value) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (value <= 0) {
            value = 0;
        }
        view.setHoverAnimationInDuration(value);
    }

    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = "hoverAnimationOutDuration")
    public void setHoverAnimationOutDuration(ButtonViewGroup view, int value) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (value <= 0) {
            value = 0;
        }
        view.setHoverAnimationOutDuration(value);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:21:0x003b  */
    /* JADX WARN: Code duplicated, block: B:22:0x003e  */
    @Override // com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface
    @ReactProp(name = ViewProps.POINTER_EVENTS)
    public void setPointerEvents(ButtonViewGroup view, String pointerEvents) {
        PointerEvents pointerEvents2;
        Intrinsics.checkNotNullParameter(view, "view");
        if (pointerEvents != null) {
            switch (pointerEvents) {
                case "box-none":
                    pointerEvents2 = PointerEvents.BOX_NONE;
                    break;
                case "box-only":
                    pointerEvents2 = PointerEvents.BOX_ONLY;
                    break;
                case "auto":
                    pointerEvents2 = PointerEvents.AUTO;
                    break;
                case "none":
                    pointerEvents2 = PointerEvents.NONE;
                    break;
                default:
                    pointerEvents2 = PointerEvents.AUTO;
                    break;
            }
        } else {
            pointerEvents2 = PointerEvents.AUTO;
        }
        view.setPointerEvents(pointerEvents2);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0030  */
    private final void updateManagedHandler(ButtonViewGroup view) {
        Integer numValueOf;
        Integer moduleId = view.getModuleId();
        if (moduleId != null) {
            int iIntValue = moduleId.intValue();
            if (view.getManagedHandlerNeedsUpdate()) {
                view.setManagedHandlerNeedsUpdate(false);
                Double pendingHandlerTag = view.getPendingHandlerTag();
                if (pendingHandlerTag != null) {
                    numValueOf = Integer.valueOf((int) pendingHandlerTag.doubleValue());
                    if (numValueOf.intValue() <= 0) {
                        numValueOf = null;
                    }
                } else {
                    numValueOf = null;
                }
                if (numValueOf == null) {
                    dropManagedHandler(view);
                    return;
                }
                RNGestureHandlerModule module = RNGestureHandlerModule.INSTANCE.getModule(iIntValue);
                if (module == null) {
                    return;
                }
                int iIntValue2 = numValueOf.intValue();
                Integer managedHandlerTag = view.getManagedHandlerTag();
                boolean z = managedHandlerTag == null || iIntValue2 != managedHandlerTag.intValue();
                if (z) {
                    dropManagedHandler(view);
                    module.createGestureHandler("NativeViewGestureHandler", numValueOf.intValue(), Arguments.createMap());
                }
                RNGestureHandlerRegistry rNGestureHandlerRegistry = RNGestureHandlerModule.INSTANCE.getRegistries().get(moduleId);
                GestureHandler handler = rNGestureHandlerRegistry != null ? rNGestureHandlerRegistry.getHandler(numValueOf.intValue()) : null;
                NativeViewGestureHandler nativeViewGestureHandler = handler instanceof NativeViewGestureHandler ? (NativeViewGestureHandler) handler : null;
                if (nativeViewGestureHandler != null) {
                    nativeViewGestureHandler.updateConfig(buildManagedHandlerConfig(view));
                }
                if (z) {
                    module.attachGestureHandler(numValueOf.intValue(), view.getId(), 0.0d);
                    view.setManagedHandlerTag(numValueOf);
                }
            }
        }
    }

    private final void dropManagedHandler(ButtonViewGroup view) {
        Integer managedHandlerTag = view.getManagedHandlerTag();
        if (managedHandlerTag != null) {
            int iIntValue = managedHandlerTag.intValue();
            view.setManagedHandlerTag(null);
            Integer moduleId = view.getModuleId();
            if (moduleId != null) {
                RNGestureHandlerModule module = RNGestureHandlerModule.INSTANCE.getModule(moduleId.intValue());
                if (module != null) {
                    module.dropGestureHandler(iIntValue);
                }
            }
        }
    }

    private final NativeViewGestureHandler.Config buildManagedHandlerConfig(ButtonViewGroup view) {
        boolean zIsEnabled = view.isEnabled();
        Boolean managedHandlerCancelOnLeave = view.getManagedHandlerCancelOnLeave();
        return new NativeViewGestureHandler.Config(zIsEnabled, managedHandlerCancelOnLeave != null ? managedHandlerCancelOnLeave.booleanValue() : true, view.getManagedHandlerHitSlop(), view.getManagedHandlerTestID(), false, true, true, null, 128, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(ButtonViewGroup view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onAfterUpdateTransaction(view);
        updateManagedHandler(view);
        view.updateBackground();
        view.updateLongPressAccessibility();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    protected ViewManagerDelegate<ButtonViewGroup> getDelegate() {
        return this.mDelegate;
    }

    /* JADX INFO: compiled from: RNGestureHandlerButtonViewManager.kt */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata(d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u0007\n\u0002\b*\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u0098\u00022\u00020\u00012\u00020\u00022\u00020\u0003:\u0006\u0098\u0002\u0099\u0002\u009a\u0002B\u0011\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010³\u0001\u001a\u00030´\u00012\u000f\u0010µ\u0001\u001a\n\u0012\u0005\u0012\u00030´\u00010¶\u0001H\u0082\bJ\u001c\u0010·\u0001\u001a\u00030´\u00012\u000f\u0010µ\u0001\u001a\n\u0012\u0005\u0012\u00030´\u00010¶\u0001H\u0082\bJ\u0013\u0010¸\u0001\u001a\u00030´\u00012\t\u0010¹\u0001\u001a\u0004\u0018\u000101J\b\u0010º\u0001\u001a\u00030´\u0001J\t\u0010»\u0001\u001a\u00020\u0015H\u0002J\u0012\u0010¼\u0001\u001a\u00030´\u00012\u0006\u0010\b\u001a\u00020\tH\u0016J\u0014\u0010½\u0001\u001a\u00030´\u00012\b\u0010¾\u0001\u001a\u00030¿\u0001H\u0016J\u0014\u0010Â\u0001\u001a\u00030´\u00012\b\u0010Ã\u0001\u001a\u00030Ä\u0001H\u0016J&\u0010Å\u0001\u001a\u00030´\u00012\b\u0010Ã\u0001\u001a\u00030Ä\u00012\u0007\u0010Æ\u0001\u001a\u00020\t2\u0007\u0010Ç\u0001\u001a\u00020\tH\u0016J\u001e\u0010È\u0001\u001a\u00030´\u00012\b\u0010É\u0001\u001a\u00030Ê\u00012\b\u0010Ã\u0001\u001a\u00030Ä\u0001H\u0002J\u0013\u0010Ë\u0001\u001a\u00030´\u00012\u0007\u0010Ì\u0001\u001a\u00020\u0015H\u0016J\u0013\u0010Í\u0001\u001a\u00020\u00152\b\u0010Î\u0001\u001a\u00030Ï\u0001H\u0016J\u0013\u0010Ð\u0001\u001a\u00020\u00152\b\u0010Î\u0001\u001a\u00030Ï\u0001H\u0017J\u0013\u0010Ñ\u0001\u001a\u00020\u00152\b\u0010Î\u0001\u001a\u00030Ï\u0001H\u0016J\t\u0010Ò\u0001\u001a\u00020YH\u0002J\n\u0010Ó\u0001\u001a\u00030´\u0001H\u0002J/\u0010Ô\u0001\u001a\u00030´\u00012\u0007\u0010Õ\u0001\u001a\u00020Y2\u0007\u0010Ö\u0001\u001a\u00020Y2\u0007\u0010×\u0001\u001a\u00020Y2\b\u0010Ø\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010Ù\u0001\u001a\u00030´\u0001H\u0002J\n\u0010Ú\u0001\u001a\u00030´\u0001H\u0002J\u0014\u0010Û\u0001\u001a\u00030´\u00012\b\u0010Î\u0001\u001a\u00030Ï\u0001H\u0002J\u0014\u0010Ü\u0001\u001a\u00030´\u00012\b\u0010Î\u0001\u001a\u00030Ï\u0001H\u0002J\n\u0010Ý\u0001\u001a\u00030´\u0001H\u0002J\u001d\u0010Þ\u0001\u001a\u00030\u009c\u00012\b\u0010Î\u0001\u001a\u00030Ï\u00012\u0007\u0010ß\u0001\u001a\u00020\tH\u0002J\u001b\u0010à\u0001\u001a\u00020\u00152\u0007\u0010á\u0001\u001a\u00020Y2\u0007\u0010â\u0001\u001a\u00020YH\u0002J\n\u0010ã\u0001\u001a\u00030´\u0001H\u0002J\u0014\u0010ä\u0001\u001a\u00030´\u00012\b\u0010Î\u0001\u001a\u00030Ï\u0001H\u0002J\b\u0010å\u0001\u001a\u00030´\u0001J\n\u0010æ\u0001\u001a\u00030´\u0001H\u0002J\u0014\u0010ç\u0001\u001a\u00030´\u00012\b\u0010É\u0001\u001a\u00030Ê\u0001H\u0002J\u0013\u0010è\u0001\u001a\u00020\u00152\b\u0010Î\u0001\u001a\u00030Ï\u0001H\u0002J\n\u0010é\u0001\u001a\u00030´\u0001H\u0002J\f\u0010ê\u0001\u001a\u0005\u0018\u00010\u0091\u0001H\u0002J\b\u0010ë\u0001\u001a\u00030´\u0001J\u0014\u0010ì\u0001\u001a\u00030´\u00012\b\u0010í\u0001\u001a\u00030î\u0001H\u0014J\u0013\u0010ï\u0001\u001a\u00020\u00152\b\u0010ð\u0001\u001a\u00030¯\u0001H\u0014J\n\u0010ñ\u0001\u001a\u00030´\u0001H\u0014J\f\u0010ò\u0001\u001a\u0005\u0018\u00010¯\u0001H\u0002J\n\u0010ó\u0001\u001a\u00030´\u0001H\u0014J.\u0010ô\u0001\u001a\u00030´\u00012\u0007\u0010õ\u0001\u001a\u00020\t2\u0007\u0010ö\u0001\u001a\u00020\t2\u0007\u0010÷\u0001\u001a\u00020\t2\u0007\u0010ø\u0001\u001a\u00020\tH\u0014J7\u0010ù\u0001\u001a\u00030´\u00012\u0007\u0010ú\u0001\u001a\u00020\u00152\u0007\u0010û\u0001\u001a\u00020\t2\u0007\u0010ü\u0001\u001a\u00020\t2\u0007\u0010ý\u0001\u001a\u00020\t2\u0007\u0010þ\u0001\u001a\u00020\tH\u0014J\u001c\u0010ÿ\u0001\u001a\u00030´\u00012\u0007\u0010á\u0001\u001a\u00020Y2\u0007\u0010â\u0001\u001a\u00020YH\u0016J\u0013\u0010\u0080\u0002\u001a\u00020\u00152\b\u0010Î\u0001\u001a\u00030Ï\u0001H\u0016J\u0014\u0010\u0081\u0002\u001a\u00030´\u00012\b\u0010Î\u0001\u001a\u00030Ï\u0001H\u0016J$\u0010\u0082\u0002\u001a\u00020\u00152\u000f\u0010\u0083\u0002\u001a\n\u0012\u0005\u0012\u00030\u0085\u00020\u0084\u00022\b\u0010Ã\u0001\u001a\u00030Ä\u0001H\u0016J\n\u0010\u0086\u0002\u001a\u00030´\u0001H\u0002J\t\u0010\u0087\u0002\u001a\u00020\u0015H\u0002J\t\u0010\u0088\u0002\u001a\u00020\u0015H\u0002J\u001c\u0010\u0089\u0002\u001a\u00020\u00152\u0011\b\u0002\u0010\u008a\u0002\u001a\n\u0012\u0005\u0012\u00030\u008c\u00020\u008b\u0002H\u0002J\u001e\u0010\u008d\u0002\u001a\u00020\u00152\u0007\u0010\u008e\u0002\u001a\u00020\t2\n\u0010Î\u0001\u001a\u0005\u0018\u00010\u008f\u0002H\u0016J\t\u0010\u0090\u0002\u001a\u00020\u0015H\u0016J\u0013\u0010\u0091\u0002\u001a\u00030´\u00012\u0007\u0010\u0092\u0002\u001a\u00020\u0015H\u0016J\u0013\u0010\u0093\u0002\u001a\u00030´\u00012\u0007\u0010\u0094\u0002\u001a\u00020\u0015H\u0016J\u001c\u0010\u0095\u0002\u001a\u00030´\u00012\u0007\u0010á\u0001\u001a\u00020Y2\u0007\u0010â\u0001\u001a\u00020YH\u0016J\t\u0010\u0096\u0002\u001a\u00020\u0015H\u0016J\t\u0010\u0097\u0002\u001a\u00020\u0015H\u0016R*\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR*\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\t@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u000eR$\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR*\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010!\u001a\u0004\u0018\u00010\"@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R*\u0010*\u001a\u0004\u0018\u00010\u00152\b\u0010)\u001a\u0004\u0018\u00010\u0015@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R(\u00102\u001a\u0004\u0018\u0001012\b\u00100\u001a\u0004\u0018\u000101@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R(\u00109\u001a\u0004\u0018\u0001082\b\u00107\u001a\u0004\u0018\u000108@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R*\u0010>\u001a\u0004\u0018\u00010\t2\b\u0010>\u001a\u0004\u0018\u00010\t@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b?\u0010\f\"\u0004\b@\u0010\u000eR\u001a\u0010A\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0018\"\u0004\bC\u0010\u001aR\u001a\u0010D\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0018\"\u0004\bF\u0010\u001aR\u001a\u0010G\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0018\"\u0004\bI\u0010\u001aR\u001a\u0010J\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001a\u0010O\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010L\"\u0004\bQ\u0010NR\u001a\u0010R\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010L\"\u0004\bT\u0010NR\u001c\u0010U\u001a\u00020\t8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010L\"\u0004\bW\u0010NR\u001a\u0010X\u001a\u00020YX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u001a\u0010^\u001a\u00020YX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010[\"\u0004\b`\u0010]R\u001a\u0010a\u001a\u00020YX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010[\"\u0004\bc\u0010]R\u001a\u0010d\u001a\u00020YX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010[\"\u0004\bf\u0010]R\u001a\u0010g\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010L\"\u0004\bi\u0010NR\u001a\u0010j\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010L\"\u0004\bl\u0010NR\u001c\u0010m\u001a\u00020Y8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010[\"\u0004\bo\u0010]R\u001c\u0010p\u001a\u00020Y8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010[\"\u0004\br\u0010]R&\u0010t\u001a\u00020Y2\u0006\u0010s\u001a\u00020Y8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010[\"\u0004\bv\u0010]R*\u0010w\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\bx\u0010\f\"\u0004\by\u0010\u000eR$\u0010z\u001a\u00020Y2\u0006\u0010s\u001a\u00020Y@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010[\"\u0004\b|\u0010]R$\u0010}\u001a\u00020Y2\u0006\u0010s\u001a\u00020Y@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010[\"\u0004\b\u007f\u0010]R\u001d\u0010\u0080\u0001\u001a\u00020\u0015X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0001\u0010\u0018\"\u0005\b\u0082\u0001\u0010\u001aR \u0010\u0083\u0001\u001a\u00030\u0084\u0001X\u0096\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R\u000f\u0010\u0089\u0001\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u008a\u0001\u001a\u00030\u008b\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u008c\u0001\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u008d\u0001\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008f\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u0091\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0092\u0001\u001a\u00030\u008b\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0094\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0094\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0097\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0098\u0001\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0099\u0001\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u009a\u0001\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009c\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u009d\u0001\u001a\u00030\u009e\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u009f\u0001\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010 \u0001\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b¡\u0001\u0010\u0018R\u0016\u0010¢\u0001\u001a\u00020Y8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b£\u0001\u0010[R\u0016\u0010¤\u0001\u001a\u00020Y8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b¥\u0001\u0010[R\u0016\u0010¦\u0001\u001a\u00020Y8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b§\u0001\u0010[R\u0016\u0010¨\u0001\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b©\u0001\u0010\u0018R\u0016\u0010ª\u0001\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b«\u0001\u0010\u0018R\u0016\u0010¬\u0001\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u00ad\u0001\u0010\u0018R\u0012\u0010®\u0001\u001a\u0005\u0018\u00010¯\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010°\u0001\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010±\u0001\u001a\u00020\u0015X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b±\u0001\u0010\u0018\"\u0005\b²\u0001\u0010\u001aR\u000f\u0010À\u0001\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Á\u0001\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u009b\u0002"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerButtonViewManager$ButtonViewGroup;", "Landroid/view/ViewGroup;", "Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler$NativeViewGestureHandlerHook;", "Lcom/facebook/react/uimanager/ReactPointerEventsView;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "color", "", "rippleColor", "getRippleColor", "()Ljava/lang/Integer;", "setRippleColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "radius", "rippleRadius", "getRippleRadius", "setRippleRadius", "useForeground", "", "useDrawableOnForeground", "getUseDrawableOnForeground", "()Z", "setUseDrawableOnForeground", "(Z)V", "useBorderlessDrawable", "getUseBorderlessDrawable", "setUseBorderlessDrawable", "managedHandlerTag", "getManagedHandlerTag", "setManagedHandlerTag", "tag", "", "pendingHandlerTag", "getPendingHandlerTag", "()Ljava/lang/Double;", "setPendingHandlerTag", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "cancelOnLeave", "managedHandlerCancelOnLeave", "getManagedHandlerCancelOnLeave", "()Ljava/lang/Boolean;", "setManagedHandlerCancelOnLeave", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", ViewProps.TEST_ID, "", "managedHandlerTestID", "getManagedHandlerTestID", "()Ljava/lang/String;", "setManagedHandlerTestID", "(Ljava/lang/String;)V", "hitSlop", "Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler$HitSlop;", "managedHandlerHitSlop", "getManagedHandlerHitSlop", "()Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler$HitSlop;", "setManagedHandlerHitSlop", "(Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler$HitSlop;)V", "moduleId", "getModuleId", "setModuleId", "managedHandlerNeedsUpdate", "getManagedHandlerNeedsUpdate", "setManagedHandlerNeedsUpdate", "exclusive", "getExclusive", "setExclusive", "hasLongPressHandler", "getHasLongPressHandler", "setHasLongPressHandler", "tapAnimationInDuration", "getTapAnimationInDuration", "()I", "setTapAnimationInDuration", "(I)V", "tapAnimationOutDuration", "getTapAnimationOutDuration", "setTapAnimationOutDuration", "longPressDuration", "getLongPressDuration", "setLongPressDuration", "longPressAnimationOutDuration", "getLongPressAnimationOutDuration", "setLongPressAnimationOutDuration", "activeOpacity", "", "getActiveOpacity", "()F", "setActiveOpacity", "(F)V", "defaultOpacity", "getDefaultOpacity", "setDefaultOpacity", "activeScale", "getActiveScale", "setActiveScale", "defaultScale", "getDefaultScale", "setDefaultScale", "hoverAnimationInDuration", "getHoverAnimationInDuration", "setHoverAnimationInDuration", "hoverAnimationOutDuration", "getHoverAnimationOutDuration", "setHoverAnimationOutDuration", "hoverOpacity", "getHoverOpacity", "setHoverOpacity", "hoverScale", "getHoverScale", "setHoverScale", "value", "hoverUnderlayOpacity", "getHoverUnderlayOpacity", "setHoverUnderlayOpacity", "underlayColor", "getUnderlayColor", "setUnderlayColor", "activeUnderlayOpacity", "getActiveUnderlayOpacity", "setActiveUnderlayOpacity", "defaultUnderlayOpacity", "getDefaultUnderlayOpacity", "setDefaultUnderlayOpacity", ViewProps.NEEDS_OFFSCREEN_ALPHA_COMPOSITING, "getNeedsOffscreenAlphaCompositing", "setNeedsOffscreenAlphaCompositing", ViewProps.POINTER_EVENTS, "Lcom/facebook/react/uimanager/PointerEvents;", "getPointerEvents", "()Lcom/facebook/react/uimanager/PointerEvents;", "setPointerEvents", "(Lcom/facebook/react/uimanager/PointerEvents;)V", "needBackgroundUpdate", "lastEventTime", "", "lastAction", "receivedKeyEvent", "currentAnimator", "Landroid/animation/AnimatorSet;", "underlayDrawable", "Landroid/graphics/drawable/PaintDrawable;", "pressInTimestamp", "pendingPressOut", "Ljava/lang/Runnable;", "pendingLongPress", "pendingHoverOut", "Landroid/view/Choreographer$FrameCallback;", "isPointerInsideBounds", "isHovered", "hoverActiveAtPressStart", "lastHoverSample", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerButtonViewManager$ButtonViewGroup$HoverSample;", "hoverWindowOffset", "", "hoverReported", "effectiveHover", "getEffectiveHover", "restingOpacity", "getRestingOpacity", "restingScale", "getRestingScale", "restingUnderlayOpacity", "getRestingUnderlayOpacity", "hasOpacityAnimation", "getHasOpacityAnimation", "hasScaleAnimation", "getHasScaleAnimation", "hasUnderlayAnimation", "getHasUnderlayAnimation", "selectableDrawable", "Landroid/graphics/drawable/Drawable;", "clipChildrenToShape", "isTouched", "setTouched", "withBackgroundUpdate", "", "block", "Lkotlin/Function0;", "withManagedHandlerUpdate", "setOverflow", ViewProps.OVERFLOW, "updateLongPressAccessibility", "hasLongPressAccessibilityAction", "setBackgroundColor", "onInitializeAccessibilityNodeInfo", "info", "Landroid/view/accessibility/AccessibilityNodeInfo;", "longPressDetected", "lastEventWasInside", "onHandlerUpdate", "handler", "Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler;", "onHandlerStateChange", "newState", "prevState", "dispatchJSEvent", "type", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerButtonViewManager$ButtonViewGroup$EventType;", "requestDisallowInterceptTouchEvent", "disallowIntercept", "onInterceptTouchEvent", "event", "Landroid/view/MotionEvent;", "onTouchEvent", "onHoverEvent", "getAnimatorDurationScale", "applyStartAnimationState", "animateTo", ViewProps.OPACITY, "scale", "underlayOpacity", "durationMs", "animatePressIn", "animateHoverState", "onHoverIn", "onHoverOut", "cancelPendingHoverOut", "hoverSampleFrom", "pointerType", "isPointerInside", ViewDeviceOrientationData.DEVICE_ORIENTATION_X, ViewDeviceOrientationData.DEVICE_ORIENTATION_Y, "captureHoverWindowOffset", "recordHoverSample", "resetHoverState", "dispatchHoverEventIfNeeded", "dispatchHoverEvent", "isWithinBounds", "animatePressOut", "createUnderlayDrawable", "updateBackground", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "verifyDrawable", "who", "drawableStateChanged", "createSelectableDrawable", "onDetachedFromWindow", "onSizeChanged", "w", "h", "oldw", "oldh", "onLayout", "changed", "l", "t", "r", "b", "drawableHotspotChanged", "canBegin", "afterGestureEnd", "shouldBeginWithRecordedHandlers", "recorded", "", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "tryFreeingResponder", "canRespondToTouches", "tryGrabbingResponder", "isChildTouched", "children", "Lkotlin/sequences/Sequence;", "Landroid/view/View;", "onKeyUp", "keyCode", "Landroid/view/KeyEvent;", "performClick", "setEnabled", "enabled", "setPressed", "pressed", "dispatchDrawableHotspotChanged", "shouldDelayChildPressedState", "hasOverlappingRendering", "Companion", "HoverSample", "EventType", "react-native-gesture-handler_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class ButtonViewGroup extends ViewGroup implements NativeViewGestureHandler.NativeViewGestureHandlerHook, ReactPointerEventsView {
        private static ButtonViewGroup soundResponder;
        private static ButtonViewGroup touchResponder;
        private float activeOpacity;
        private float activeScale;
        private float activeUnderlayOpacity;
        private boolean clipChildrenToShape;
        private AnimatorSet currentAnimator;
        private float defaultOpacity;
        private float defaultScale;
        private float defaultUnderlayOpacity;
        private boolean exclusive;
        private boolean hasLongPressHandler;
        private boolean hoverActiveAtPressStart;
        private int hoverAnimationInDuration;
        private int hoverAnimationOutDuration;
        private float hoverOpacity;
        private boolean hoverReported;
        private float hoverScale;
        private float hoverUnderlayOpacity;
        private final int[] hoverWindowOffset;
        private boolean isHovered;
        private boolean isPointerInsideBounds;
        private boolean isTouched;
        private int lastAction;
        private long lastEventTime;
        private boolean lastEventWasInside;
        private HoverSample lastHoverSample;
        private int longPressAnimationOutDuration;
        private boolean longPressDetected;
        private int longPressDuration;
        private Boolean managedHandlerCancelOnLeave;
        private NativeViewGestureHandler.HitSlop managedHandlerHitSlop;
        private boolean managedHandlerNeedsUpdate;
        private Integer managedHandlerTag;
        private String managedHandlerTestID;
        private Integer moduleId;
        private boolean needBackgroundUpdate;
        private boolean needsOffscreenAlphaCompositing;
        private Double pendingHandlerTag;
        private Choreographer.FrameCallback pendingHoverOut;
        private Runnable pendingLongPress;
        private Runnable pendingPressOut;
        private PointerEvents pointerEvents;
        private long pressInTimestamp;
        private boolean receivedKeyEvent;
        private Integer rippleColor;
        private Integer rippleRadius;
        private Drawable selectableDrawable;
        private int tapAnimationInDuration;
        private int tapAnimationOutDuration;
        private Integer underlayColor;
        private PaintDrawable underlayDrawable;
        private boolean useBorderlessDrawable;
        private boolean useDrawableOnForeground;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static TypedValue resolveOutValue = new TypedValue();
        private static final View.OnClickListener dummyClickListener = new View.OnClickListener() { // from class: com.swmansion.gesturehandler.react.RNGestureHandlerButtonViewManager$ButtonViewGroup$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RNGestureHandlerButtonViewManager.ButtonViewGroup.dummyClickListener$lambda$0(view);
            }
        };
        private static final View.OnLongClickListener dummyLongClickListener = new View.OnLongClickListener() { // from class: com.swmansion.gesturehandler.react.RNGestureHandlerButtonViewManager$ButtonViewGroup$$ExternalSyntheticLambda5
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return RNGestureHandlerButtonViewManager.ButtonViewGroup.dummyLongClickListener$lambda$0(view);
            }
        };

        /* JADX INFO: compiled from: RNGestureHandlerButtonViewManager.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerButtonViewManager$ButtonViewGroup$EventType;", "", "<init>", "(Ljava/lang/String;I)V", "Press", "PressIn", "PressOut", "LongPress", "HoverIn", "HoverOut", "InteractionFinished", "react-native-gesture-handler_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public enum EventType {
            Press,
            PressIn,
            PressOut,
            LongPress,
            HoverIn,
            HoverOut,
            InteractionFinished;

            private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

            public static EnumEntries<EventType> getEntries() {
                return $ENTRIES;
            }
        }

        static final void dummyClickListener$lambda$0(View view) {
        }

        @Override // android.view.ViewGroup, android.view.View
        public void dispatchDrawableHotspotChanged(float x, float y) {
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean changed, int l, int t, int r, int b) {
        }

        @Override // android.view.ViewGroup
        public boolean shouldDelayChildPressedState() {
            return false;
        }

        public ButtonViewGroup(Context context) {
            super(context);
            this.exclusive = true;
            this.tapAnimationInDuration = 50;
            this.tapAnimationOutDuration = 100;
            this.longPressDuration = -1;
            this.longPressAnimationOutDuration = -1;
            this.activeOpacity = 1.0f;
            this.defaultOpacity = 1.0f;
            this.activeScale = 1.0f;
            this.defaultScale = 1.0f;
            this.hoverAnimationInDuration = 50;
            this.hoverAnimationOutDuration = 100;
            this.hoverOpacity = -1.0f;
            this.hoverScale = -1.0f;
            this.hoverUnderlayOpacity = -1.0f;
            this.pointerEvents = PointerEvents.AUTO;
            this.lastEventTime = -1L;
            this.lastAction = -1;
            this.hoverWindowOffset = new int[2];
            setOnClickListener(dummyClickListener);
            setClickable(true);
            setFocusable(true);
            this.needBackgroundUpdate = true;
            setClipChildren(false);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ boolean canActivate(View view) {
            return super.canActivate(view);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ void handleEventBeforeActivation(MotionEvent motionEvent) {
            super.handleEventBeforeActivation(motionEvent);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ Boolean sendTouchEvent(View view, MotionEvent motionEvent) {
            return super.sendTouchEvent(view, motionEvent);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ boolean shouldCancelRootViewGestureHandlerIfNecessary() {
            return super.shouldCancelRootViewGestureHandlerIfNecessary();
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ Boolean shouldRecognizeSimultaneously(GestureHandler gestureHandler) {
            return super.shouldRecognizeSimultaneously(gestureHandler);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public /* bridge */ boolean wantsToHandleEventBeforeActivation() {
            return super.wantsToHandleEventBeforeActivation();
        }

        public final Integer getRippleColor() {
            return this.rippleColor;
        }

        public final void setRippleColor(Integer num) {
            this.rippleColor = num;
            this.needBackgroundUpdate = true;
        }

        public final Integer getRippleRadius() {
            return this.rippleRadius;
        }

        public final void setRippleRadius(Integer num) {
            this.rippleRadius = num;
            this.needBackgroundUpdate = true;
        }

        public final boolean getUseDrawableOnForeground() {
            return this.useDrawableOnForeground;
        }

        public final void setUseDrawableOnForeground(boolean z) {
            this.useDrawableOnForeground = z;
            this.needBackgroundUpdate = true;
        }

        public final boolean getUseBorderlessDrawable() {
            return this.useBorderlessDrawable;
        }

        public final void setUseBorderlessDrawable(boolean z) {
            this.useBorderlessDrawable = z;
        }

        public final Integer getManagedHandlerTag() {
            return this.managedHandlerTag;
        }

        public final void setManagedHandlerTag(Integer num) {
            this.managedHandlerTag = num;
        }

        public final Double getPendingHandlerTag() {
            return this.pendingHandlerTag;
        }

        public final void setPendingHandlerTag(Double d) {
            this.pendingHandlerTag = d;
            this.managedHandlerNeedsUpdate = true;
        }

        public final Boolean getManagedHandlerCancelOnLeave() {
            return this.managedHandlerCancelOnLeave;
        }

        public final void setManagedHandlerCancelOnLeave(Boolean bool) {
            this.managedHandlerCancelOnLeave = bool;
            this.managedHandlerNeedsUpdate = true;
        }

        public final String getManagedHandlerTestID() {
            return this.managedHandlerTestID;
        }

        public final void setManagedHandlerTestID(String str) {
            this.managedHandlerTestID = str;
            this.managedHandlerNeedsUpdate = true;
        }

        public final NativeViewGestureHandler.HitSlop getManagedHandlerHitSlop() {
            return this.managedHandlerHitSlop;
        }

        public final void setManagedHandlerHitSlop(NativeViewGestureHandler.HitSlop hitSlop) {
            this.managedHandlerHitSlop = hitSlop;
            this.managedHandlerNeedsUpdate = true;
        }

        public final Integer getModuleId() {
            return this.moduleId;
        }

        public final void setModuleId(Integer num) {
            this.moduleId = num;
            this.managedHandlerNeedsUpdate = true;
        }

        public final boolean getManagedHandlerNeedsUpdate() {
            return this.managedHandlerNeedsUpdate;
        }

        public final void setManagedHandlerNeedsUpdate(boolean z) {
            this.managedHandlerNeedsUpdate = z;
        }

        public final boolean getExclusive() {
            return this.exclusive;
        }

        public final void setExclusive(boolean z) {
            this.exclusive = z;
        }

        public final boolean getHasLongPressHandler() {
            return this.hasLongPressHandler;
        }

        public final void setHasLongPressHandler(boolean z) {
            this.hasLongPressHandler = z;
        }

        public final int getTapAnimationInDuration() {
            return this.tapAnimationInDuration;
        }

        public final void setTapAnimationInDuration(int i) {
            this.tapAnimationInDuration = i;
        }

        public final int getTapAnimationOutDuration() {
            return this.tapAnimationOutDuration;
        }

        public final void setTapAnimationOutDuration(int i) {
            this.tapAnimationOutDuration = i;
        }

        public final int getLongPressDuration() {
            return this.longPressDuration;
        }

        public final void setLongPressDuration(int i) {
            this.longPressDuration = i;
        }

        public final void setLongPressAnimationOutDuration(int i) {
            this.longPressAnimationOutDuration = i;
        }

        public final int getLongPressAnimationOutDuration() {
            int i = this.longPressAnimationOutDuration;
            return i < 0 ? this.tapAnimationOutDuration : i;
        }

        public final float getActiveOpacity() {
            return this.activeOpacity;
        }

        public final void setActiveOpacity(float f) {
            this.activeOpacity = f;
        }

        public final float getDefaultOpacity() {
            return this.defaultOpacity;
        }

        public final void setDefaultOpacity(float f) {
            this.defaultOpacity = f;
        }

        public final float getActiveScale() {
            return this.activeScale;
        }

        public final void setActiveScale(float f) {
            this.activeScale = f;
        }

        public final float getDefaultScale() {
            return this.defaultScale;
        }

        public final void setDefaultScale(float f) {
            this.defaultScale = f;
        }

        public final int getHoverAnimationInDuration() {
            return this.hoverAnimationInDuration;
        }

        public final void setHoverAnimationInDuration(int i) {
            this.hoverAnimationInDuration = i;
        }

        public final int getHoverAnimationOutDuration() {
            return this.hoverAnimationOutDuration;
        }

        public final void setHoverAnimationOutDuration(int i) {
            this.hoverAnimationOutDuration = i;
        }

        public final void setHoverOpacity(float f) {
            this.hoverOpacity = f;
        }

        public final float getHoverOpacity() {
            float f = this.hoverOpacity;
            return f < 0.0f ? this.defaultOpacity : f;
        }

        public final void setHoverScale(float f) {
            this.hoverScale = f;
        }

        public final float getHoverScale() {
            float f = this.hoverScale;
            return f < 0.0f ? this.defaultScale : f;
        }

        public final float getHoverUnderlayOpacity() {
            float f = this.hoverUnderlayOpacity;
            return f < 0.0f ? this.defaultUnderlayOpacity : f;
        }

        public final void setHoverUnderlayOpacity(float f) {
            this.hoverUnderlayOpacity = f;
            this.needBackgroundUpdate = true;
        }

        public final Integer getUnderlayColor() {
            return this.underlayColor;
        }

        public final void setUnderlayColor(Integer num) {
            this.underlayColor = num;
            this.needBackgroundUpdate = true;
        }

        public final float getActiveUnderlayOpacity() {
            return this.activeUnderlayOpacity;
        }

        public final void setActiveUnderlayOpacity(float f) {
            this.activeUnderlayOpacity = f;
            this.needBackgroundUpdate = true;
        }

        public final float getDefaultUnderlayOpacity() {
            return this.defaultUnderlayOpacity;
        }

        public final void setDefaultUnderlayOpacity(float f) {
            this.defaultUnderlayOpacity = f;
            this.needBackgroundUpdate = true;
        }

        public final boolean getNeedsOffscreenAlphaCompositing() {
            return this.needsOffscreenAlphaCompositing;
        }

        public final void setNeedsOffscreenAlphaCompositing(boolean z) {
            this.needsOffscreenAlphaCompositing = z;
        }

        @Override // com.facebook.react.uimanager.ReactPointerEventsView
        public PointerEvents getPointerEvents() {
            return this.pointerEvents;
        }

        public void setPointerEvents(PointerEvents pointerEvents) {
            Intrinsics.checkNotNullParameter(pointerEvents, "<set-?>");
            this.pointerEvents = pointerEvents;
        }

        private final boolean getEffectiveHover() {
            return this.isHovered && isEnabled();
        }

        private final float getRestingOpacity() {
            return getEffectiveHover() ? getHoverOpacity() : this.defaultOpacity;
        }

        private final float getRestingScale() {
            return getEffectiveHover() ? getHoverScale() : this.defaultScale;
        }

        private final float getRestingUnderlayOpacity() {
            return getEffectiveHover() ? getHoverUnderlayOpacity() : this.defaultUnderlayOpacity;
        }

        private final boolean getHasOpacityAnimation() {
            return (this.activeOpacity == 1.0f && this.defaultOpacity == 1.0f && getHoverOpacity() == 1.0f) ? false : true;
        }

        private final boolean getHasScaleAnimation() {
            return (this.activeScale == 1.0f && this.defaultScale == 1.0f && getHoverScale() == 1.0f) ? false : true;
        }

        private final boolean getHasUnderlayAnimation() {
            if (this.underlayDrawable != null) {
                return (this.activeUnderlayOpacity == this.defaultUnderlayOpacity && getHoverUnderlayOpacity() == this.defaultUnderlayOpacity) ? false : true;
            }
            return false;
        }

        /* JADX INFO: renamed from: isTouched, reason: from getter */
        public final boolean getIsTouched() {
            return this.isTouched;
        }

        public final void setTouched(boolean z) {
            this.isTouched = z;
        }

        private final void withBackgroundUpdate(Function0<Unit> block) {
            block.invoke();
            this.needBackgroundUpdate = true;
        }

        private final void withManagedHandlerUpdate(Function0<Unit> block) {
            block.invoke();
            this.managedHandlerNeedsUpdate = true;
        }

        public final void setOverflow(String overflow) {
            this.clipChildrenToShape = Intrinsics.areEqual(overflow, ViewProps.HIDDEN);
            invalidate();
        }

        public final void updateLongPressAccessibility() {
            boolean zHasLongPressAccessibilityAction = hasLongPressAccessibilityAction();
            setOnLongClickListener(zHasLongPressAccessibilityAction ? dummyLongClickListener : null);
            setLongClickable(zHasLongPressAccessibilityAction);
        }

        private final boolean hasLongPressAccessibilityAction() {
            Object tag = getTag(R.id.accessibility_actions);
            ReadableArray readableArray = tag instanceof ReadableArray ? (ReadableArray) tag : null;
            if (readableArray == null) {
                return false;
            }
            int size = readableArray.size();
            for (int i = 0; i < size; i++) {
                ReadableMap map = readableArray.getMap(i);
                if (Intrinsics.areEqual(map != null ? map.getString("name") : null, "longpress")) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.view.View
        public void setBackgroundColor(int color) {
            BackgroundStyleApplicator.setBackgroundColor(this, Integer.valueOf(color));
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            super.onInitializeAccessibilityNodeInfo(info);
            Object tag = super.getTag(R.id.react_test_id);
            if (tag instanceof String) {
                info.setViewIdResourceName((String) tag);
            }
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public void onHandlerUpdate(NativeViewGestureHandler handler) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            if (this.managedHandlerTag == null || handler.getIsWithinBounds() == this.lastEventWasInside) {
                return;
            }
            if (handler.getIsWithinBounds()) {
                dispatchJSEvent(EventType.PressIn, handler);
                return;
            }
            dispatchJSEvent(EventType.PressOut, handler);
            Runnable runnable = this.pendingLongPress;
            if (runnable != null) {
                Handler handler2 = getHandler();
                if (handler2 != null) {
                    handler2.removeCallbacks(runnable);
                }
                this.pendingLongPress = null;
            }
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public void onHandlerStateChange(final NativeViewGestureHandler handler, int newState, int prevState) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            if (this.managedHandlerTag == null) {
                return;
            }
            boolean z = this.lastEventWasInside;
            if (newState == 2) {
                dispatchJSEvent(EventType.PressIn, handler);
                this.longPressDetected = false;
                if (this.hasLongPressHandler && this.longPressDuration >= 0) {
                    Runnable runnable = new Runnable() { // from class: com.swmansion.gesturehandler.react.RNGestureHandlerButtonViewManager$ButtonViewGroup$$ExternalSyntheticLambda3
                        @Override // java.lang.Runnable
                        public final void run() {
                            RNGestureHandlerButtonViewManager.ButtonViewGroup.onHandlerStateChange$lambda$0(this.f$0, handler);
                        }
                    };
                    this.pendingLongPress = runnable;
                    Handler handler2 = getHandler();
                    if (handler2 != null) {
                        handler2.postDelayed(runnable, this.longPressDuration);
                    }
                }
            }
            if (newState == 1 || newState == 3 || newState == 5) {
                if (z) {
                    dispatchJSEvent(EventType.PressOut, handler);
                }
                Runnable runnable2 = this.pendingLongPress;
                if (runnable2 != null) {
                    Handler handler3 = getHandler();
                    if (handler3 != null) {
                        handler3.removeCallbacks(runnable2);
                    }
                    this.pendingLongPress = null;
                }
            }
            if (newState == 5 && !this.longPressDetected && z) {
                dispatchJSEvent(EventType.Press, handler);
            }
            if (newState == 1 || newState == 3 || newState == 5) {
                dispatchJSEvent(EventType.InteractionFinished, handler);
            }
        }

        static final void onHandlerStateChange$lambda$0(ButtonViewGroup buttonViewGroup, NativeViewGestureHandler nativeViewGestureHandler) {
            buttonViewGroup.pendingLongPress = null;
            buttonViewGroup.longPressDetected = true;
            buttonViewGroup.dispatchJSEvent(EventType.LongPress, nativeViewGestureHandler);
        }

        private final void dispatchJSEvent(EventType type, NativeViewGestureHandler handler) {
            EventDispatcher eventDispatcherForReactTag;
            Context context = getContext();
            ReactContext reactContext = context instanceof ReactContext ? (ReactContext) context : null;
            if (reactContext == null || (eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(reactContext, getId())) == null) {
                return;
            }
            eventDispatcherForReactTag.dispatchEvent(RNGestureHandlerButtonEvent.INSTANCE.obtain(this, handler, type));
            if (type == EventType.PressIn) {
                this.lastEventWasInside = true;
            } else if (type == EventType.PressOut) {
                this.lastEventWasInside = false;
            }
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
            Integer num;
            GestureHandlerOrchestrator orchestrator;
            RNGestureHandlerRegistry rNGestureHandlerRegistry;
            GestureHandler handler;
            super.requestDisallowInterceptTouchEvent(disallowIntercept);
            if (disallowIntercept && (num = this.moduleId) != null) {
                num.intValue();
                Integer num2 = this.managedHandlerTag;
                if (num2 != null) {
                    int iIntValue = num2.intValue();
                    RNGestureHandlerRootView rNGestureHandlerRootViewFindGestureHandlerRootView = RNGestureHandlerRootView.INSTANCE.findGestureHandlerRootView(this);
                    if (rNGestureHandlerRootViewFindGestureHandlerRootView == null || (orchestrator = rNGestureHandlerRootViewFindGestureHandlerRootView.getOrchestrator()) == null || (rNGestureHandlerRegistry = RNGestureHandlerModule.INSTANCE.getRegistries().get(num)) == null || (handler = rNGestureHandlerRegistry.getHandler(iIntValue)) == null || orchestrator.getIsHandlingTouch() || handler.getView() == null) {
                        return;
                    }
                    handler.cancel();
                }
            }
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (super.onInterceptTouchEvent(event)) {
                return true;
            }
            onTouchEvent(event);
            return isPressed();
        }

        /* JADX WARN: Code duplicated, block: B:44:0x0087  */
        /* JADX WARN: Code duplicated, block: B:46:0x008b  */
        /* JADX WARN: Code duplicated, block: B:51:0x00a9  */
        /* JADX WARN: Code duplicated, block: B:74:0x00e1  */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x00c7, code lost:
        
            if (r7 != 6) goto L75;
         */
        @Override // android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onTouchEvent(android.view.MotionEvent r10) {
            /*
                Method dump skipped, instruction units count: 228
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.swmansion.gesturehandler.react.RNGestureHandlerButtonViewManager.ButtonViewGroup.onTouchEvent(android.view.MotionEvent):boolean");
        }

        @Override // android.view.View
        public boolean onHoverEvent(MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            int actionMasked = event.getActionMasked();
            if (actionMasked == 9) {
                onHoverIn(event);
            } else if (actionMasked == 10) {
                onHoverOut(event);
            }
            return super.onHoverEvent(event);
        }

        private final float getAnimatorDurationScale() {
            if (Build.VERSION.SDK_INT >= 33) {
                return ValueAnimator.getDurationScale();
            }
            try {
                return Settings.Global.getFloat(getContext().getContentResolver(), "animator_duration_scale");
            } catch (Settings.SettingNotFoundException unused) {
                return 1.0f;
            }
        }

        private final void applyStartAnimationState() {
            if (getHasOpacityAnimation()) {
                setAlpha(this.defaultOpacity);
            }
            if (getHasScaleAnimation()) {
                setScaleX(this.defaultScale);
                setScaleY(this.defaultScale);
            }
            PaintDrawable paintDrawable = this.underlayDrawable;
            if (paintDrawable != null) {
                paintDrawable.setAlpha((int) (this.defaultUnderlayOpacity * 255.0f));
            }
        }

        private final void animateTo(float opacity, float scale, float underlayOpacity, long durationMs) {
            if (getHasOpacityAnimation() || getHasScaleAnimation() || getHasUnderlayAnimation()) {
                AnimatorSet animatorSet = this.currentAnimator;
                if (animatorSet != null) {
                    animatorSet.cancel();
                }
                this.currentAnimator = null;
                float animatorDurationScale = (long) (durationMs * getAnimatorDurationScale());
                Display display = getDisplay();
                if (animatorDurationScale < (display != null ? ExtensionsKt.getMinimumFrameTime(display) : 16.0f)) {
                    if (getHasOpacityAnimation()) {
                        setAlpha(opacity);
                    }
                    if (getHasScaleAnimation()) {
                        setScaleX(scale);
                        setScaleY(scale);
                    }
                    if (getHasUnderlayAnimation()) {
                        PaintDrawable paintDrawable = this.underlayDrawable;
                        Intrinsics.checkNotNull(paintDrawable);
                        paintDrawable.setAlpha((int) (underlayOpacity * 255.0f));
                        return;
                    }
                    return;
                }
                ArrayList arrayList = new ArrayList();
                if (getHasOpacityAnimation()) {
                    arrayList.add(ObjectAnimator.ofFloat(this, "alpha", opacity));
                }
                if (getHasScaleAnimation()) {
                    arrayList.add(ObjectAnimator.ofFloat(this, "scaleX", scale));
                    arrayList.add(ObjectAnimator.ofFloat(this, "scaleY", scale));
                }
                if (getHasUnderlayAnimation()) {
                    PaintDrawable paintDrawable2 = this.underlayDrawable;
                    Intrinsics.checkNotNull(paintDrawable2);
                    arrayList.add(ObjectAnimator.ofInt(paintDrawable2, "alpha", (int) (underlayOpacity * 255.0f)));
                }
                AnimatorSet animatorSet2 = new AnimatorSet();
                animatorSet2.playTogether(arrayList);
                animatorSet2.setDuration(durationMs);
                animatorSet2.setInterpolator(new FastOutSlowInInterpolator());
                animatorSet2.start();
                this.currentAnimator = animatorSet2;
            }
        }

        private final void animatePressIn() {
            Runnable runnable = this.pendingPressOut;
            if (runnable != null) {
                Handler handler = getHandler();
                if (handler != null) {
                    handler.removeCallbacks(runnable);
                }
                this.pendingPressOut = null;
            }
            this.pressInTimestamp = SystemClock.uptimeMillis();
            animateTo(this.activeOpacity, this.activeScale, this.activeUnderlayOpacity, this.tapAnimationInDuration);
        }

        private final void animateHoverState() {
            if (isPressed()) {
                return;
            }
            if (getEffectiveHover()) {
                animateTo(getHoverOpacity(), getHoverScale(), getHoverUnderlayOpacity(), this.hoverAnimationInDuration);
            } else {
                animateTo(this.defaultOpacity, this.defaultScale, this.defaultUnderlayOpacity, this.hoverAnimationOutDuration);
            }
        }

        private final void onHoverIn(MotionEvent event) {
            cancelPendingHoverOut();
            if (this.isHovered) {
                return;
            }
            this.isHovered = true;
            captureHoverWindowOffset();
            recordHoverSample(event);
            dispatchHoverEventIfNeeded();
            animateHoverState();
        }

        private final void onHoverOut(MotionEvent event) {
            if (isPressed()) {
                this.isHovered = false;
                this.hoverActiveAtPressStart = false;
                recordHoverSample(event);
                dispatchHoverEventIfNeeded();
                return;
            }
            cancelPendingHoverOut();
            final HoverSample hoverSampleHoverSampleFrom = hoverSampleFrom(event, ExtensionsKt.getPointerType$default(event, 0, 1, null));
            Choreographer.FrameCallback frameCallback = new Choreographer.FrameCallback() { // from class: com.swmansion.gesturehandler.react.RNGestureHandlerButtonViewManager$ButtonViewGroup$$ExternalSyntheticLambda1
                @Override // android.view.Choreographer.FrameCallback
                public final void doFrame(long j) {
                    RNGestureHandlerButtonViewManager.ButtonViewGroup.onHoverOut$lambda$0(this.f$0, hoverSampleHoverSampleFrom, j);
                }
            };
            this.pendingHoverOut = frameCallback;
            Choreographer.getInstance().postFrameCallback(frameCallback);
        }

        static final void onHoverOut$lambda$0(ButtonViewGroup buttonViewGroup, HoverSample hoverSample, long j) {
            buttonViewGroup.pendingHoverOut = null;
            buttonViewGroup.isHovered = false;
            buttonViewGroup.lastHoverSample = hoverSample;
            buttonViewGroup.dispatchHoverEventIfNeeded();
            buttonViewGroup.animateHoverState();
        }

        private final void cancelPendingHoverOut() {
            Choreographer.FrameCallback frameCallback = this.pendingHoverOut;
            if (frameCallback != null) {
                Choreographer.getInstance().removeFrameCallback(frameCallback);
            }
            this.pendingHoverOut = null;
        }

        private final HoverSample hoverSampleFrom(MotionEvent event, int pointerType) {
            return new HoverSample(event.getX(), event.getY(), event.getRawX() - this.hoverWindowOffset[0], event.getRawY() - this.hoverWindowOffset[1], pointerType, isPointerInside(event.getX(), event.getY()));
        }

        private final boolean isPointerInside(float x, float y) {
            GestureHandler handler;
            Integer num = this.moduleId;
            if (num != null) {
                num.intValue();
                Integer num2 = this.managedHandlerTag;
                if (num2 != null) {
                    int iIntValue = num2.intValue();
                    RNGestureHandlerRegistry rNGestureHandlerRegistry = RNGestureHandlerModule.INSTANCE.getRegistries().get(num);
                    if (rNGestureHandlerRegistry != null && (handler = rNGestureHandlerRegistry.getHandler(iIntValue)) != null) {
                        return handler.isWithinBounds(this, x, y);
                    }
                }
            }
            return false;
        }

        private final void captureHoverWindowOffset() {
            Activity activityFindActivity = ExtensionsKt.findActivity(getContext());
            View viewFindViewById = activityFindActivity != null ? activityFindActivity.findViewById(android.R.id.content) : null;
            int[] iArr = this.hoverWindowOffset;
            if (viewFindViewById != null) {
                viewFindViewById.getLocationOnScreen(iArr);
            } else {
                iArr[0] = 0;
                iArr[1] = 0;
            }
        }

        private final void recordHoverSample(MotionEvent event) {
            this.lastHoverSample = hoverSampleFrom(event, ExtensionsKt.getPointerType$default(event, 0, 1, null));
        }

        public final void resetHoverState() {
            this.isHovered = false;
            this.hoverReported = false;
            this.hoverActiveAtPressStart = false;
            this.lastHoverSample = null;
        }

        private final void dispatchHoverEventIfNeeded() {
            boolean effectiveHover;
            if (this.managedHandlerTag == null || (effectiveHover = getEffectiveHover()) == this.hoverReported) {
                return;
            }
            this.hoverReported = effectiveHover;
            dispatchHoverEvent(effectiveHover ? EventType.HoverIn : EventType.HoverOut);
        }

        private final void dispatchHoverEvent(EventType type) {
            EventDispatcher eventDispatcherForReactTag;
            HoverSample hoverSample = this.lastHoverSample;
            if (hoverSample == null) {
                return;
            }
            Context context = getContext();
            ReactContext reactContext = context instanceof ReactContext ? (ReactContext) context : null;
            if (reactContext == null || (eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(reactContext, getId())) == null) {
                return;
            }
            eventDispatcherForReactTag.dispatchEvent(RNGestureHandlerButtonEvent.INSTANCE.obtain(this, hoverSample, type));
        }

        private final boolean isWithinBounds(MotionEvent event) {
            return event.getX() >= 0.0f && event.getY() >= 0.0f && event.getX() < ((float) getWidth()) && event.getY() < ((float) getHeight());
        }

        private final void animatePressOut() {
            Handler handler;
            Runnable runnable = this.pendingPressOut;
            if (runnable != null && (handler = getHandler()) != null) {
                handler.removeCallbacks(runnable);
            }
            long j = this.tapAnimationInDuration;
            final long j2 = this.tapAnimationOutDuration;
            long j3 = this.longPressDuration;
            long longPressAnimationOutDuration = getLongPressAnimationOutDuration();
            long jUptimeMillis = SystemClock.uptimeMillis() - this.pressInTimestamp;
            if (j3 >= 0 && jUptimeMillis >= j3) {
                animateTo(getRestingOpacity(), getRestingScale(), getRestingUnderlayOpacity(), longPressAnimationOutDuration);
                return;
            }
            if (jUptimeMillis >= j) {
                animateTo(getRestingOpacity(), getRestingScale(), getRestingUnderlayOpacity(), j2);
                return;
            }
            if (2 * jUptimeMillis >= j2) {
                animateTo(getRestingOpacity(), getRestingScale(), getRestingUnderlayOpacity(), jUptimeMillis);
                return;
            }
            long j4 = j - jUptimeMillis;
            animateTo(this.activeOpacity, this.activeScale, this.activeUnderlayOpacity, j4);
            Runnable runnable2 = new Runnable() { // from class: com.swmansion.gesturehandler.react.RNGestureHandlerButtonViewManager$ButtonViewGroup$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    RNGestureHandlerButtonViewManager.ButtonViewGroup.animatePressOut$lambda$1(this.f$0, j2);
                }
            };
            this.pendingPressOut = runnable2;
            Handler handler2 = getHandler();
            if (handler2 != null) {
                handler2.postDelayed(runnable2, (long) (j4 * getAnimatorDurationScale()));
            }
        }

        static final void animatePressOut$lambda$1(ButtonViewGroup buttonViewGroup, long j) {
            buttonViewGroup.pendingPressOut = null;
            buttonViewGroup.animateTo(buttonViewGroup.getRestingOpacity(), buttonViewGroup.getRestingScale(), buttonViewGroup.getRestingUnderlayOpacity(), j);
        }

        private final PaintDrawable createUnderlayDrawable() {
            Integer num = this.underlayColor;
            boolean z = true;
            boolean z2 = num != null && Color.alpha(num.intValue()) == 0;
            if (this.defaultUnderlayOpacity == 0.0f && this.activeUnderlayOpacity == 0.0f && getHoverUnderlayOpacity() == 0.0f) {
                z = false;
            }
            if (z2 || !z) {
                return null;
            }
            Integer num2 = this.underlayColor;
            PaintDrawable paintDrawable = new PaintDrawable(num2 != null ? num2.intValue() : -16777216);
            paintDrawable.setAlpha((int) (this.defaultUnderlayOpacity * 255.0f));
            return paintDrawable;
        }

        public final void updateBackground() {
            if (this.needBackgroundUpdate) {
                this.needBackgroundUpdate = false;
                setForeground(null);
                Drawable drawableCreateSelectableDrawable = createSelectableDrawable();
                PaintDrawable paintDrawableCreateUnderlayDrawable = createUnderlayDrawable();
                this.underlayDrawable = paintDrawableCreateUnderlayDrawable;
                if (paintDrawableCreateUnderlayDrawable != null) {
                    paintDrawableCreateUnderlayDrawable.setCallback(this);
                }
                if (this.useDrawableOnForeground && drawableCreateSelectableDrawable != null) {
                    setForeground(drawableCreateSelectableDrawable);
                    this.selectableDrawable = null;
                } else {
                    this.selectableDrawable = drawableCreateSelectableDrawable;
                    if (drawableCreateSelectableDrawable != null) {
                        drawableCreateSelectableDrawable.setCallback(this);
                    }
                }
                applyStartAnimationState();
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            PaintDrawable paintDrawable = this.underlayDrawable;
            if (paintDrawable != null) {
                canvas.save();
                BackgroundStyleApplicator.clipToPaddingBox(this, canvas);
                paintDrawable.setBounds(0, 0, getWidth(), getHeight());
                paintDrawable.draw(canvas);
                canvas.restore();
            }
            Drawable drawable = this.selectableDrawable;
            if (drawable != null) {
                if (!this.useBorderlessDrawable) {
                    canvas.save();
                    BackgroundStyleApplicator.clipToPaddingBox(this, canvas);
                }
                drawable.setBounds(0, 0, getWidth(), getHeight());
                drawable.draw(canvas);
                if (!this.useBorderlessDrawable) {
                    canvas.restore();
                }
            }
            if (this.clipChildrenToShape) {
                canvas.save();
                BackgroundStyleApplicator.clipToPaddingBox(this, canvas);
                super.dispatchDraw(canvas);
                canvas.restore();
                return;
            }
            super.dispatchDraw(canvas);
        }

        @Override // android.view.View
        protected boolean verifyDrawable(Drawable who) {
            Intrinsics.checkNotNullParameter(who, "who");
            return super.verifyDrawable(who) || Intrinsics.areEqual(who, this.underlayDrawable) || Intrinsics.areEqual(who, this.selectableDrawable);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void drawableStateChanged() {
            super.drawableStateChanged();
            Drawable drawable = this.selectableDrawable;
            if (drawable == null || !drawable.isStateful()) {
                return;
            }
            drawable.setState(getDrawableState());
        }

        private final Drawable createSelectableDrawable() {
            ColorStateList colorStateList;
            Integer num = this.rippleColor;
            if (num != null && num.intValue() == 0) {
                return null;
            }
            int[][] iArr = {new int[]{android.R.attr.state_enabled}};
            Integer num2 = this.rippleRadius;
            Integer num3 = this.rippleColor;
            if (num3 != null) {
                Intrinsics.checkNotNull(num3);
                colorStateList = new ColorStateList(iArr, new int[]{num3.intValue()});
            } else {
                getContext().getTheme().resolveAttribute(android.R.attr.colorControlHighlight, resolveOutValue, true);
                colorStateList = new ColorStateList(iArr, new int[]{resolveOutValue.data});
            }
            RippleDrawable rippleDrawable = new RippleDrawable(colorStateList, null, this.useBorderlessDrawable ? null : new ShapeDrawable(new RectShape()));
            if (num2 != null) {
                rippleDrawable.setRadius((int) PixelUtil.toPixelFromDIP(num2.intValue()));
            }
            return rippleDrawable;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            Handler handler;
            Handler handler2;
            Runnable runnable = this.pendingPressOut;
            if (runnable != null && (handler2 = getHandler()) != null) {
                handler2.removeCallbacks(runnable);
            }
            this.pendingPressOut = null;
            Runnable runnable2 = this.pendingLongPress;
            if (runnable2 != null && (handler = getHandler()) != null) {
                handler.removeCallbacks(runnable2);
            }
            this.pendingLongPress = null;
            cancelPendingHoverOut();
            AnimatorSet animatorSet = this.currentAnimator;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            this.currentAnimator = null;
            this.isHovered = false;
            applyStartAnimationState();
            if (touchResponder == this) {
                touchResponder = null;
            }
            if (soundResponder == this) {
                soundResponder = null;
            }
            super.onDetachedFromWindow();
        }

        @Override // android.view.View
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            super.onSizeChanged(w, h, oldw, oldh);
            this.needBackgroundUpdate = true;
            updateBackground();
        }

        @Override // android.view.View
        public void drawableHotspotChanged(float x, float y) {
            ButtonViewGroup buttonViewGroup = touchResponder;
            if (buttonViewGroup == null || buttonViewGroup == this) {
                super.drawableHotspotChanged(x, y);
                Drawable drawable = this.selectableDrawable;
                if (drawable != null) {
                    drawable.setHotspot(x, y);
                }
            }
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public boolean canBegin(MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (event.getAction() == 3 || event.getAction() == 1 || event.getActionMasked() == 6) {
                return false;
            }
            boolean zTryGrabbingResponder = tryGrabbingResponder();
            if (zTryGrabbingResponder) {
                this.isTouched = true;
            }
            return zTryGrabbingResponder;
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public void afterGestureEnd(MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            tryFreeingResponder();
            this.isTouched = false;
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public boolean shouldBeginWithRecordedHandlers(List<? extends GestureHandler> recorded, NativeViewGestureHandler handler) {
            Intrinsics.checkNotNullParameter(recorded, "recorded");
            Intrinsics.checkNotNullParameter(handler, "handler");
            List<? extends GestureHandler> list = recorded;
            if ((list instanceof Collection) && list.isEmpty()) {
                return true;
            }
            for (GestureHandler gestureHandler : list) {
                if (!gestureHandler.shouldRecognizeSimultaneously(handler) && !handler.shouldRecognizeSimultaneously(gestureHandler) && !Intrinsics.areEqual(gestureHandler.getView(), this) && !(gestureHandler instanceof HoverGestureHandler)) {
                    return false;
                }
            }
            return true;
        }

        private final void tryFreeingResponder() {
            if (touchResponder == this) {
                touchResponder = null;
                soundResponder = this;
            }
        }

        private final boolean canRespondToTouches() {
            if (this.exclusive) {
                return touchResponder == this;
            }
            ButtonViewGroup buttonViewGroup = touchResponder;
            return !(buttonViewGroup != null ? buttonViewGroup.exclusive : false);
        }

        private final boolean tryGrabbingResponder() {
            if (isChildTouched$default(this, null, 1, null)) {
                return false;
            }
            if (touchResponder == null) {
                touchResponder = this;
                return true;
            }
            return canRespondToTouches();
        }

        /* JADX WARN: Multi-variable type inference failed */
        static /* synthetic */ boolean isChildTouched$default(ButtonViewGroup buttonViewGroup, Sequence sequence, int i, Object obj) {
            if ((i & 1) != 0) {
                sequence = ViewGroupKt.getChildren(buttonViewGroup);
            }
            return buttonViewGroup.isChildTouched(sequence);
        }

        private final boolean isChildTouched(Sequence<? extends View> children) {
            for (View view : children) {
                if (view instanceof ButtonViewGroup) {
                    ButtonViewGroup buttonViewGroup = (ButtonViewGroup) view;
                    if (buttonViewGroup.isTouched || buttonViewGroup.isPressed()) {
                        return true;
                    }
                }
                if ((view instanceof ViewGroup) && isChildTouched(ViewGroupKt.getChildren((ViewGroup) view))) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyUp(int keyCode, KeyEvent event) {
            this.receivedKeyEvent = true;
            return super.onKeyUp(keyCode, event);
        }

        @Override // android.view.View
        public boolean performClick() {
            if (!isChildTouched$default(this, null, 1, null)) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                if (ExtensionsKt.isScreenReaderOn(context) && !isPressed()) {
                    RNGestureHandlerRootView rNGestureHandlerRootViewFindGestureHandlerRootView = RNGestureHandlerRootView.INSTANCE.findGestureHandlerRootView(this);
                    if (rNGestureHandlerRootViewFindGestureHandlerRootView != null) {
                        rNGestureHandlerRootViewFindGestureHandlerRootView.activateNativeHandlers(this);
                    }
                } else if (this.receivedKeyEvent) {
                    RNGestureHandlerRootView rNGestureHandlerRootViewFindGestureHandlerRootView2 = RNGestureHandlerRootView.INSTANCE.findGestureHandlerRootView(this);
                    if (rNGestureHandlerRootViewFindGestureHandlerRootView2 != null) {
                        rNGestureHandlerRootViewFindGestureHandlerRootView2.activateNativeHandlers(this);
                    }
                    this.receivedKeyEvent = false;
                }
                if (soundResponder == this) {
                    tryFreeingResponder();
                    soundResponder = null;
                    return super.performClick();
                }
            }
            return false;
        }

        @Override // android.view.View
        public void setEnabled(boolean enabled) {
            boolean z = enabled != isEnabled();
            super.setEnabled(enabled);
            if (z) {
                this.managedHandlerNeedsUpdate = true;
                dispatchHoverEventIfNeeded();
                if (this.isHovered) {
                    animateHoverState();
                }
            }
        }

        /* JADX WARN: Code duplicated, block: B:12:0x0017  */
        @Override // android.view.View
        public void setPressed(boolean pressed) {
            boolean z;
            if (!this.exclusive) {
                ButtonViewGroup buttonViewGroup = touchResponder;
                z = (buttonViewGroup == null || !buttonViewGroup.exclusive) && !isChildTouched$default(this, null, 1, null);
            }
            if (!pressed || touchResponder == this || z) {
                this.isTouched = pressed;
                super.setPressed(pressed);
                if (pressed) {
                    animatePressIn();
                } else {
                    animatePressOut();
                }
            }
            if (pressed || touchResponder != this) {
                return;
            }
            this.isTouched = false;
        }

        @Override // android.view.View
        public boolean hasOverlappingRendering() {
            return this.needsOffscreenAlphaCompositing;
        }

        /* JADX INFO: compiled from: RNGestureHandlerButtonViewManager.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerButtonViewManager$ButtonViewGroup$Companion;", "", "<init>", "()V", "resolveOutValue", "Landroid/util/TypedValue;", "getResolveOutValue", "()Landroid/util/TypedValue;", "setResolveOutValue", "(Landroid/util/TypedValue;)V", "touchResponder", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerButtonViewManager$ButtonViewGroup;", "getTouchResponder", "()Lcom/swmansion/gesturehandler/react/RNGestureHandlerButtonViewManager$ButtonViewGroup;", "setTouchResponder", "(Lcom/swmansion/gesturehandler/react/RNGestureHandlerButtonViewManager$ButtonViewGroup;)V", "soundResponder", "getSoundResponder", "setSoundResponder", "dummyClickListener", "Landroid/view/View$OnClickListener;", "getDummyClickListener", "()Landroid/view/View$OnClickListener;", "dummyLongClickListener", "Landroid/view/View$OnLongClickListener;", "getDummyLongClickListener", "()Landroid/view/View$OnLongClickListener;", "react-native-gesture-handler_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final TypedValue getResolveOutValue() {
                return ButtonViewGroup.resolveOutValue;
            }

            public final void setResolveOutValue(TypedValue typedValue) {
                Intrinsics.checkNotNullParameter(typedValue, "<set-?>");
                ButtonViewGroup.resolveOutValue = typedValue;
            }

            public final ButtonViewGroup getTouchResponder() {
                return ButtonViewGroup.touchResponder;
            }

            public final void setTouchResponder(ButtonViewGroup buttonViewGroup) {
                ButtonViewGroup.touchResponder = buttonViewGroup;
            }

            public final ButtonViewGroup getSoundResponder() {
                return ButtonViewGroup.soundResponder;
            }

            public final void setSoundResponder(ButtonViewGroup buttonViewGroup) {
                ButtonViewGroup.soundResponder = buttonViewGroup;
            }

            public final View.OnClickListener getDummyClickListener() {
                return ButtonViewGroup.dummyClickListener;
            }

            public final View.OnLongClickListener getDummyLongClickListener() {
                return ButtonViewGroup.dummyLongClickListener;
            }
        }

        static final boolean dummyLongClickListener$lambda$0(View view) {
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            if (ExtensionsKt.isScreenReaderOn(context)) {
                return view.performAccessibilityAction(32, null);
            }
            return false;
        }

        /* JADX INFO: compiled from: RNGestureHandlerButtonViewManager.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0014\u0010\u001d\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001f\u001a\u00020\bHÖ\u0081\u0004J\n\u0010 \u001a\u00020!HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerButtonViewManager$ButtonViewGroup$HoverSample;", "", ViewDeviceOrientationData.DEVICE_ORIENTATION_X, "", ViewDeviceOrientationData.DEVICE_ORIENTATION_Y, "absoluteX", "absoluteY", "pointerType", "", "pointerInside", "", "<init>", "(FFFFIZ)V", "getX", "()F", "getY", "getAbsoluteX", "getAbsoluteY", "getPointerType", "()I", "getPointerInside", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "", "react-native-gesture-handler_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final /* data */ class HoverSample {
            private final float absoluteX;
            private final float absoluteY;
            private final boolean pointerInside;
            private final int pointerType;
            private final float x;
            private final float y;

            public static /* synthetic */ HoverSample copy$default(HoverSample hoverSample, float f, float f2, float f3, float f4, int i, boolean z, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    f = hoverSample.x;
                }
                if ((i2 & 2) != 0) {
                    f2 = hoverSample.y;
                }
                if ((i2 & 4) != 0) {
                    f3 = hoverSample.absoluteX;
                }
                if ((i2 & 8) != 0) {
                    f4 = hoverSample.absoluteY;
                }
                if ((i2 & 16) != 0) {
                    i = hoverSample.pointerType;
                }
                if ((i2 & 32) != 0) {
                    z = hoverSample.pointerInside;
                }
                int i3 = i;
                boolean z2 = z;
                return hoverSample.copy(f, f2, f3, f4, i3, z2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final float getX() {
                return this.x;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final float getY() {
                return this.y;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final float getAbsoluteX() {
                return this.absoluteX;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final float getAbsoluteY() {
                return this.absoluteY;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final int getPointerType() {
                return this.pointerType;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final boolean getPointerInside() {
                return this.pointerInside;
            }

            public final HoverSample copy(float x, float y, float absoluteX, float absoluteY, int pointerType, boolean pointerInside) {
                return new HoverSample(x, y, absoluteX, absoluteY, pointerType, pointerInside);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof HoverSample)) {
                    return false;
                }
                HoverSample hoverSample = (HoverSample) other;
                return Float.compare(this.x, hoverSample.x) == 0 && Float.compare(this.y, hoverSample.y) == 0 && Float.compare(this.absoluteX, hoverSample.absoluteX) == 0 && Float.compare(this.absoluteY, hoverSample.absoluteY) == 0 && this.pointerType == hoverSample.pointerType && this.pointerInside == hoverSample.pointerInside;
            }

            public int hashCode() {
                return (((((((((Float.hashCode(this.x) * 31) + Float.hashCode(this.y)) * 31) + Float.hashCode(this.absoluteX)) * 31) + Float.hashCode(this.absoluteY)) * 31) + Integer.hashCode(this.pointerType)) * 31) + Boolean.hashCode(this.pointerInside);
            }

            public String toString() {
                return "HoverSample(x=" + this.x + ", y=" + this.y + ", absoluteX=" + this.absoluteX + ", absoluteY=" + this.absoluteY + ", pointerType=" + this.pointerType + ", pointerInside=" + this.pointerInside + ")";
            }

            public HoverSample(float f, float f2, float f3, float f4, int i, boolean z) {
                this.x = f;
                this.y = f2;
                this.absoluteX = f3;
                this.absoluteY = f4;
                this.pointerType = i;
                this.pointerInside = z;
            }

            public final float getX() {
                return this.x;
            }

            public final float getY() {
                return this.y;
            }

            public final float getAbsoluteX() {
                return this.absoluteX;
            }

            public final float getAbsoluteY() {
                return this.absoluteY;
            }

            public final int getPointerType() {
                return this.pointerType;
            }

            public final boolean getPointerInside() {
                return this.pointerInside;
            }
        }
    }
}
