package com.facebook.react.views.scroll;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.widget.OverScroller;
import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.log.LogAttributes;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.react.bridge.ScrollEndedListeners;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.fabric.FabricUIManager;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactClippingViewGroup;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mux.stats.sdk.core.model.ViewDeviceOrientationData;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ReactScrollViewHelper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001:\tklmnopqrsB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\u001f\u001a\u00020 \"\u000e\b\u0000\u0010!*\u0004\u0018\u00010\"*\u00020#2\u0006\u0010$\u001a\u0002H!2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&H\u0007¢\u0006\u0002\u0010(J5\u0010)\u001a\u00020 \"\u000e\b\u0000\u0010!*\u0004\u0018\u00010\"*\u00020#2\u0006\u0010$\u001a\u0002H!2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&H\u0007¢\u0006\u0002\u0010(J%\u0010*\u001a\u00020 \"\u000e\b\u0000\u0010!*\u0004\u0018\u00010\"*\u00020#2\u0006\u0010$\u001a\u0002H!H\u0007¢\u0006\u0002\u0010+J5\u0010,\u001a\u00020 \"\u000e\b\u0000\u0010!*\u0004\u0018\u00010\"*\u00020#2\u0006\u0010$\u001a\u0002H!2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&H\u0007¢\u0006\u0002\u0010(J5\u0010-\u001a\u00020 \"\u000e\b\u0000\u0010!*\u0004\u0018\u00010\"*\u00020#2\u0006\u0010$\u001a\u0002H!2\u0006\u0010%\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u0013H\u0007¢\u0006\u0002\u0010.J%\u0010/\u001a\u00020 \"\u000e\b\u0000\u0010!*\u0004\u0018\u00010\"*\u00020#2\u0006\u0010$\u001a\u0002H!H\u0007¢\u0006\u0002\u0010+J-\u0010\u001f\u001a\u00020 \"\u000e\b\u0000\u0010!*\u0004\u0018\u00010\"*\u00020#2\u0006\u0010$\u001a\u0002H!2\u0006\u00100\u001a\u000201H\u0002¢\u0006\u0002\u00102JG\u0010\u001f\u001a\u00020 \"\u000e\b\u0000\u0010!*\u0004\u0018\u00010\"*\u00020#2\u0006\u0010$\u001a\u0002H!2\u0006\u00100\u001a\u0002012\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\b\b\u0002\u00103\u001a\u00020\bH\u0002¢\u0006\u0002\u00104J\u0015\u00105\u001a\u00020 2\u0006\u0010$\u001a\u00020#H\u0001¢\u0006\u0002\b6J\u0010\u00107\u001a\u00020 2\u0006\u0010$\u001a\u00020#H\u0007J\u0010\u00108\u001a\u00020 2\u0006\u0010$\u001a\u00020#H\u0007J\u0012\u00109\u001a\u00020\u00132\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010;\u001a\u00020\u00132\b\u0010<\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010=\u001a\u00020\u00132\b\u0010>\u001a\u0004\u0018\u00010?H\u0007J\u0010\u0010@\u001a\u00020 2\u0006\u0010A\u001a\u00020\u001aH\u0007J\u0010\u0010B\u001a\u00020 2\u0006\u0010A\u001a\u00020\u001aH\u0007J\u0010\u0010C\u001a\u00020 2\u0006\u0010A\u001a\u00020\u001cH\u0007J\u0010\u0010D\u001a\u00020 2\u0006\u0010A\u001a\u00020\u001cH\u0007JG\u0010E\u001a\u00020 \" \b\u0000\u0010!*\u0004\u0018\u00010F*\u0004\u0018\u00010\"*\u0004\u0018\u00010G*\u0004\u0018\u00010H*\u00020#2\u0006\u0010$\u001a\u0002H!2\u0006\u0010I\u001a\u00020\u00132\u0006\u0010J\u001a\u00020\u0013H\u0007¢\u0006\u0002\u0010.JC\u0010K\u001a\u00020\u0013\"\u0014\b\u0000\u0010!*\u0004\u0018\u00010F*\u0004\u0018\u00010G*\u00020#2\u0006\u0010$\u001a\u0002H!2\u0006\u0010L\u001a\u00020\u00132\u0006\u0010M\u001a\u00020\u00132\u0006\u0010N\u001a\u00020\u0013H\u0007¢\u0006\u0002\u0010OJ1\u0010P\u001a\u00020 \"\u001a\b\u0000\u0010!*\u0004\u0018\u00010F*\u0004\u0018\u00010G*\u0004\u0018\u00010H*\u00020#2\u0006\u0010$\u001a\u0002H!H\u0007¢\u0006\u0002\u0010+J9\u0010P\u001a\u00020 \"\u0014\b\u0000\u0010!*\u0004\u0018\u00010G*\u0004\u0018\u00010H*\u00020#2\u0006\u0010$\u001a\u0002H!2\u0006\u0010Q\u001a\u00020\u00132\u0006\u0010R\u001a\u00020\u0013¢\u0006\u0002\u0010.J+\u0010S\u001a\u00020 \"\u0014\b\u0000\u0010!*\u0004\u0018\u00010G*\u0004\u0018\u00010H*\u00020#2\u0006\u0010$\u001a\u0002H!H\u0007¢\u0006\u0002\u0010+J5\u0010T\u001a\u00020 \"\u0014\b\u0000\u0010!*\u0004\u0018\u00010G*\u0004\u0018\u00010H*\u00020#2\u0006\u0010$\u001a\u0002H!2\u0006\u0010U\u001a\u00020VH\u0001¢\u0006\u0004\bW\u0010XJG\u0010Y\u001a\u00020 \" \b\u0000\u0010!*\u0004\u0018\u00010F*\u0004\u0018\u00010\"*\u0004\u0018\u00010G*\u0004\u0018\u00010H*\u00020#2\u0006\u0010$\u001a\u0002H!2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&H\u0007¢\u0006\u0002\u0010(J5\u0010Z\u001a\u00020 \" \b\u0000\u0010!*\u0004\u0018\u00010F*\u0004\u0018\u00010\"*\u0004\u0018\u00010G*\u0004\u0018\u00010H*\u00020#2\u0006\u0010$\u001a\u0002H!¢\u0006\u0002\u0010+J+\u0010[\u001a\u00020 \"\u0014\b\u0000\u0010!*\u0004\u0018\u00010F*\u0004\u0018\u00010\"*\u00020#2\u0006\u0010$\u001a\u0002H!H\u0007¢\u0006\u0002\u0010+JK\u0010\\\u001a\u00020]\"\u0014\b\u0000\u0010!*\u0004\u0018\u00010F*\u0004\u0018\u00010G*\u00020#2\u0006\u0010$\u001a\u0002H!2\u0006\u0010^\u001a\u00020\u00132\u0006\u0010_\u001a\u00020\u00132\u0006\u0010`\u001a\u00020\u00132\u0006\u0010a\u001a\u00020\u0013H\u0007¢\u0006\u0002\u0010bJ\"\u0010c\u001a\u0004\u0018\u00010d2\u0006\u0010e\u001a\u00020#2\u0006\u0010f\u001a\u00020d2\u0006\u0010g\u001a\u00020\u0013H\u0007J \u0010h\u001a\u00020\u00132\u0006\u0010g\u001a\u00020\u00132\u0006\u0010i\u001a\u00020\b2\u0006\u0010j\u001a\u00020\u0013H\u0007R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006t"}, d2 = {"Lcom/facebook/react/views/scroll/ReactScrollViewHelper;", "", "<init>", "()V", "TAG", "", "kotlin.jvm.PlatformType", "DEBUG_MODE", "", "CONTENT_OFFSET_LEFT", "CONTENT_OFFSET_TOP", "SCROLL_AWAY_PADDING_TOP", "SCROLL_AWAY_PADDING_BOTTOM", "MOMENTUM_DELAY", "", "OVER_SCROLL_ALWAYS", "AUTO", "OVER_SCROLL_NEVER", "SNAP_ALIGNMENT_DISABLED", "", "SNAP_ALIGNMENT_START", "SNAP_ALIGNMENT_CENTER", "SNAP_ALIGNMENT_END", "scrollListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/lang/ref/WeakReference;", "Lcom/facebook/react/views/scroll/ReactScrollViewHelper$ScrollListener;", "layoutChangeListeners", "Lcom/facebook/react/views/scroll/ReactScrollViewHelper$LayoutChangeListener;", "SMOOTH_SCROLL_DURATION", "smoothScrollDurationInitialized", "emitScrollEvent", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/facebook/react/views/scroll/ReactScrollViewHelper$HasScrollEventThrottle;", "Landroid/view/ViewGroup;", "scrollView", "xVelocity", "", "yVelocity", "(Landroid/view/ViewGroup;FF)V", "emitScrollEventNoThrottle", "emitScrollBeginDragEvent", "(Landroid/view/ViewGroup;)V", "emitScrollEndDragEvent", "emitScrollMomentumBeginEvent", "(Landroid/view/ViewGroup;II)V", "emitScrollMomentumEndEvent", "scrollEventType", "Lcom/facebook/react/views/scroll/ScrollEventType;", "(Landroid/view/ViewGroup;Lcom/facebook/react/views/scroll/ScrollEventType;)V", "skipThrottle", "(Landroid/view/ViewGroup;Lcom/facebook/react/views/scroll/ScrollEventType;FFZ)V", "notifyUserDrivenScrollEnded", "notifyUserDrivenScrollEnded_internal", "emitLayoutEvent", "emitLayoutChangeEvent", "parseOverScrollMode", "jsOverScrollMode", "parseSnapToAlignment", "alignment", "getDefaultScrollAnimationDuration", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "addScrollListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removeScrollListener", "addLayoutChangeListener", "removeLayoutChangeListener", "smoothScrollTo", "Lcom/facebook/react/views/scroll/ReactScrollViewHelper$HasFlingAnimator;", "Lcom/facebook/react/views/scroll/ReactScrollViewHelper$HasScrollState;", "Lcom/facebook/react/views/scroll/ReactScrollViewHelper$HasStateWrapper;", ViewDeviceOrientationData.DEVICE_ORIENTATION_X, ViewDeviceOrientationData.DEVICE_ORIENTATION_Y, "getNextFlingStartValue", "currentValue", "postAnimationValue", "velocity", "(Landroid/view/ViewGroup;III)I", "updateFabricScrollState", "scrollX", "scrollY", "forceUpdateState", "loadFabricScrollState", "stateWrapper", "Lcom/facebook/react/uimanager/StateWrapper;", "loadFabricScrollState$ReactAndroid", "(Landroid/view/ViewGroup;Lcom/facebook/react/uimanager/StateWrapper;)V", "updateStateOnScrollChanged", "registerFlingAnimator", "dispatchMomentumEndOnAnimationEnd", "predictFinalScrollPosition", "Landroid/graphics/Point;", "velocityX", "velocityY", "maximumOffsetX", "maximumOffsetY", "(Landroid/view/ViewGroup;IIII)Landroid/graphics/Point;", "findNextFocusableView", "Landroid/view/View;", LogAttributes.HOST, "focused", "direction", "resolveAbsoluteDirection", "horizontal", ViewProps.LAYOUT_DIRECTION, "ScrollListener", "LayoutChangeListener", "HasStateWrapper", "OverScrollerDurationGetter", "ReactScrollViewScrollState", "HasScrollState", "HasFlingAnimator", "HasScrollEventThrottle", "HasSmoothScroll", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ReactScrollViewHelper {
    public static final String AUTO = "auto";
    private static final String CONTENT_OFFSET_LEFT = "contentOffsetLeft";
    private static final String CONTENT_OFFSET_TOP = "contentOffsetTop";
    private static final boolean DEBUG_MODE = false;
    public static final long MOMENTUM_DELAY = 20;
    public static final String OVER_SCROLL_ALWAYS = "always";
    public static final String OVER_SCROLL_NEVER = "never";
    private static final String SCROLL_AWAY_PADDING_BOTTOM = "scrollAwayPaddingBottom";
    private static final String SCROLL_AWAY_PADDING_TOP = "scrollAwayPaddingTop";
    public static final int SNAP_ALIGNMENT_CENTER = 2;
    public static final int SNAP_ALIGNMENT_DISABLED = 0;
    public static final int SNAP_ALIGNMENT_END = 3;
    public static final int SNAP_ALIGNMENT_START = 1;
    private static boolean smoothScrollDurationInitialized;
    public static final ReactScrollViewHelper INSTANCE = new ReactScrollViewHelper();
    private static final String TAG = "ReactScrollView";
    private static final CopyOnWriteArrayList<WeakReference<ScrollListener>> scrollListeners = new CopyOnWriteArrayList<>();
    private static final CopyOnWriteArrayList<WeakReference<LayoutChangeListener>> layoutChangeListeners = new CopyOnWriteArrayList<>();
    private static int SMOOTH_SCROLL_DURATION = 250;

    /* JADX INFO: compiled from: ReactScrollViewHelper.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Lcom/facebook/react/views/scroll/ReactScrollViewHelper$HasFlingAnimator;", "", "startFlingAnimator", "", ViewProps.START, "", ViewProps.END, "getFlingAnimator", "Landroid/animation/ValueAnimator;", "getFlingExtrapolatedDistance", "velocity", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface HasFlingAnimator {
        /* JADX INFO: renamed from: getFlingAnimator */
        ValueAnimator getDefaultFlingAnimator();

        int getFlingExtrapolatedDistance(int velocity);

        void startFlingAnimator(int start, int end);
    }

    /* JADX INFO: compiled from: ReactScrollViewHelper.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Lcom/facebook/react/views/scroll/ReactScrollViewHelper$HasScrollEventThrottle;", "", "scrollEventThrottle", "", "getScrollEventThrottle", "()I", "setScrollEventThrottle", "(I)V", "lastScrollDispatchTime", "", "getLastScrollDispatchTime", "()J", "setLastScrollDispatchTime", "(J)V", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface HasScrollEventThrottle {
        long getLastScrollDispatchTime();

        int getScrollEventThrottle();

        void setLastScrollDispatchTime(long j);

        void setScrollEventThrottle(int i);
    }

    /* JADX INFO: compiled from: ReactScrollViewHelper.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Lcom/facebook/react/views/scroll/ReactScrollViewHelper$HasScrollState;", "", "reactScrollViewScrollState", "Lcom/facebook/react/views/scroll/ReactScrollViewHelper$ReactScrollViewScrollState;", "getReactScrollViewScrollState", "()Lcom/facebook/react/views/scroll/ReactScrollViewHelper$ReactScrollViewScrollState;", "setReactScrollViewScrollState", "(Lcom/facebook/react/views/scroll/ReactScrollViewHelper$ReactScrollViewScrollState;)V", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface HasScrollState {
        /* JADX INFO: renamed from: getReactScrollViewScrollState */
        ReactScrollViewScrollState get_reactScrollViewScrollState();

        void setReactScrollViewScrollState(ReactScrollViewScrollState reactScrollViewScrollState);
    }

    /* JADX INFO: compiled from: ReactScrollViewHelper.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Lcom/facebook/react/views/scroll/ReactScrollViewHelper$HasSmoothScroll;", "", "reactSmoothScrollTo", "", ViewDeviceOrientationData.DEVICE_ORIENTATION_X, "", ViewDeviceOrientationData.DEVICE_ORIENTATION_Y, "scrollToPreservingMomentum", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface HasSmoothScroll {
        void reactSmoothScrollTo(int x, int y);

        void scrollToPreservingMomentum(int x, int y);
    }

    /* JADX INFO: compiled from: ReactScrollViewHelper.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Lcom/facebook/react/views/scroll/ReactScrollViewHelper$HasStateWrapper;", "", "stateWrapper", "Lcom/facebook/react/uimanager/StateWrapper;", "getStateWrapper", "()Lcom/facebook/react/uimanager/StateWrapper;", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface HasStateWrapper {
        StateWrapper getStateWrapper();
    }

    /* JADX INFO: compiled from: ReactScrollViewHelper.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Lcom/facebook/react/views/scroll/ReactScrollViewHelper$LayoutChangeListener;", "", "onLayoutChange", "", "scrollView", "Landroid/view/ViewGroup;", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface LayoutChangeListener {
        void onLayoutChange(ViewGroup scrollView);
    }

    /* JADX INFO: compiled from: ReactScrollViewHelper.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH&J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Lcom/facebook/react/views/scroll/ReactScrollViewHelper$ScrollListener;", "", "onScroll", "", "scrollView", "Landroid/view/ViewGroup;", "scrollEventType", "Lcom/facebook/react/views/scroll/ScrollEventType;", "xVelocity", "", "yVelocity", "onLayout", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface ScrollListener {
        void onLayout(ViewGroup scrollView);

        void onScroll(ViewGroup scrollView, ScrollEventType scrollEventType, float xVelocity, float yVelocity);
    }

    @JvmStatic
    public static final int resolveAbsoluteDirection(int direction, boolean horizontal, int layoutDirection) {
        boolean z = layoutDirection == 1;
        if (direction != 1 && direction != 2) {
            return direction;
        }
        if (horizontal) {
            return (direction == 2) != z ? 66 : 17;
        }
        return direction == 2 ? 130 : 33;
    }

    private ReactScrollViewHelper() {
    }

    @JvmStatic
    public static final <T extends ViewGroup & HasScrollEventThrottle> void emitScrollEvent(T scrollView, float xVelocity, float yVelocity) {
        INSTANCE.emitScrollEvent(scrollView, ScrollEventType.SCROLL, xVelocity, yVelocity, false);
    }

    @JvmStatic
    public static final <T extends ViewGroup & HasScrollEventThrottle> void emitScrollEventNoThrottle(T scrollView, float xVelocity, float yVelocity) {
        INSTANCE.emitScrollEvent(scrollView, ScrollEventType.SCROLL, xVelocity, yVelocity, true);
    }

    @JvmStatic
    public static final <T extends ViewGroup & HasScrollEventThrottle> void emitScrollBeginDragEvent(T scrollView) {
        INSTANCE.emitScrollEvent(scrollView, ScrollEventType.BEGIN_DRAG);
    }

    @JvmStatic
    public static final <T extends ViewGroup & HasScrollEventThrottle> void emitScrollEndDragEvent(T scrollView, float xVelocity, float yVelocity) {
        emitScrollEvent$default(INSTANCE, scrollView, ScrollEventType.END_DRAG, xVelocity, yVelocity, false, 16, null);
    }

    @JvmStatic
    public static final <T extends ViewGroup & HasScrollEventThrottle> void emitScrollMomentumBeginEvent(T scrollView, int xVelocity, int yVelocity) {
        emitScrollEvent$default(INSTANCE, scrollView, ScrollEventType.MOMENTUM_BEGIN, xVelocity, yVelocity, false, 16, null);
    }

    @JvmStatic
    public static final <T extends ViewGroup & HasScrollEventThrottle> void emitScrollMomentumEndEvent(T scrollView) {
        INSTANCE.emitScrollEvent(scrollView, ScrollEventType.MOMENTUM_END);
    }

    private final <T extends ViewGroup & HasScrollEventThrottle> void emitScrollEvent(T scrollView, ScrollEventType scrollEventType) {
        emitScrollEvent(scrollView, scrollEventType, 0.0f, 0.0f, false);
    }

    static /* synthetic */ void emitScrollEvent$default(ReactScrollViewHelper reactScrollViewHelper, ViewGroup viewGroup, ScrollEventType scrollEventType, float f, float f2, boolean z, int i, Object obj) {
        if ((i & 16) != 0) {
            z = false;
        }
        reactScrollViewHelper.emitScrollEvent(viewGroup, scrollEventType, f, f2, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T extends ViewGroup & HasScrollEventThrottle> void emitScrollEvent(T scrollView, ScrollEventType scrollEventType, float xVelocity, float yVelocity, boolean skipThrottle) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!skipThrottle && scrollEventType == ScrollEventType.SCROLL) {
            T t = scrollView;
            if (t.getScrollEventThrottle() >= Math.max(17L, jCurrentTimeMillis - t.getLastScrollDispatchTime())) {
                return;
            }
        }
        View childAt = scrollView.getChildAt(0);
        if (childAt == null) {
            return;
        }
        Iterator it = CollectionsKt.toList(scrollListeners).iterator();
        while (it.hasNext()) {
            ScrollListener scrollListener = (ScrollListener) ((WeakReference) it.next()).get();
            if (scrollListener != null) {
                scrollListener.onScroll(scrollView, scrollEventType, xVelocity, yVelocity);
            }
        }
        View view = (View) scrollView;
        Context context = view.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        ReactContext reactContext = (ReactContext) context;
        int surfaceId = UIManagerHelper.getSurfaceId(reactContext);
        EventDispatcher eventDispatcher = UIManagerHelper.getEventDispatcher(reactContext);
        if (eventDispatcher != null) {
            eventDispatcher.dispatchEvent(ScrollEvent.INSTANCE.obtain(surfaceId, view.getId(), scrollEventType, view.getScrollX(), view.getScrollY(), xVelocity, yVelocity, childAt.getWidth(), childAt.getHeight(), view.getWidth(), view.getHeight()));
            if (scrollEventType == ScrollEventType.SCROLL) {
                scrollView.setLastScrollDispatchTime(jCurrentTimeMillis);
            }
        }
    }

    @JvmStatic
    public static final void notifyUserDrivenScrollEnded_internal(ViewGroup scrollView) {
        ScrollEndedListeners scrollEndedListeners;
        Intrinsics.checkNotNullParameter(scrollView, "scrollView");
        Context context = scrollView.getContext();
        ReactContext reactContext = context instanceof ReactContext ? (ReactContext) context : null;
        if (reactContext == null || (scrollEndedListeners = reactContext.getScrollEndedListeners()) == null) {
            return;
        }
        scrollEndedListeners.notifyScrollEnded(scrollView);
    }

    @JvmStatic
    public static final void emitLayoutEvent(ViewGroup scrollView) {
        Intrinsics.checkNotNullParameter(scrollView, "scrollView");
        Iterator<WeakReference<ScrollListener>> it = scrollListeners.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            ScrollListener scrollListener = it.next().get();
            if (scrollListener != null) {
                scrollListener.onLayout(scrollView);
            }
        }
    }

    @JvmStatic
    public static final void emitLayoutChangeEvent(ViewGroup scrollView) {
        Intrinsics.checkNotNullParameter(scrollView, "scrollView");
        Iterator<WeakReference<LayoutChangeListener>> it = layoutChangeListeners.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            LayoutChangeListener layoutChangeListener = it.next().get();
            if (layoutChangeListener != null) {
                layoutChangeListener.onLayoutChange(scrollView);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0028, code lost:
    
        if (r3.equals("auto") != false) goto L25;
     */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int parseOverScrollMode(java.lang.String r3) {
        /*
            r0 = 1
            if (r3 == 0) goto L49
            int r1 = r3.hashCode()
            r2 = -1414557169(0xffffffffabaf920f, float:-1.2475037E-12)
            if (r1 == r2) goto L2b
            r2 = 3005871(0x2dddaf, float:4.212122E-39)
            if (r1 == r2) goto L22
            r2 = 104712844(0x63dca8c, float:3.5695757E-35)
            if (r1 == r2) goto L17
            goto L33
        L17:
            java.lang.String r1 = "never"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L20
            goto L33
        L20:
            r3 = 2
            return r3
        L22:
            java.lang.String r1 = "auto"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L33
            goto L49
        L2b:
            java.lang.String r1 = "always"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L47
        L33:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "wrong overScrollMode: "
            r1.<init>(r2)
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            java.lang.String r1 = "ReactNative"
            com.facebook.common.logging.FLog.w(r1, r3)
            return r0
        L47:
            r3 = 0
            return r3
        L49:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.scroll.ReactScrollViewHelper.parseOverScrollMode(java.lang.String):int");
    }

    @JvmStatic
    public static final int parseSnapToAlignment(String alignment) {
        if (alignment == null) {
            return 0;
        }
        if (StringsKt.equals(ViewProps.START, alignment, true)) {
            return 1;
        }
        if (StringsKt.equals("center", alignment, true)) {
            return 2;
        }
        if (Intrinsics.areEqual(ViewProps.END, alignment)) {
            return 3;
        }
        FLog.w(ReactConstants.TAG, "wrong snap alignment value: " + alignment);
        return 0;
    }

    @JvmStatic
    public static final int getDefaultScrollAnimationDuration(Context context) {
        if (!smoothScrollDurationInitialized) {
            smoothScrollDurationInitialized = true;
            try {
                SMOOTH_SCROLL_DURATION = new OverScrollerDurationGetter(context).getScrollAnimationDuration();
            } catch (Throwable unused) {
            }
        }
        return SMOOTH_SCROLL_DURATION;
    }

    @JvmStatic
    public static final void addScrollListener(ScrollListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        scrollListeners.add(new WeakReference<>(listener));
    }

    @JvmStatic
    public static final void removeScrollListener(ScrollListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ArrayList arrayList = new ArrayList();
        Iterator<WeakReference<ScrollListener>> it = scrollListeners.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            WeakReference<ScrollListener> next = it.next();
            ScrollListener scrollListener = next.get();
            if (scrollListener == null || Intrinsics.areEqual(scrollListener, listener)) {
                arrayList.add(next);
            }
        }
        scrollListeners.removeAll(arrayList);
    }

    @JvmStatic
    public static final void addLayoutChangeListener(LayoutChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        layoutChangeListeners.add(new WeakReference<>(listener));
    }

    @JvmStatic
    public static final void removeLayoutChangeListener(LayoutChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ArrayList arrayList = new ArrayList();
        Iterator<WeakReference<LayoutChangeListener>> it = layoutChangeListeners.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            WeakReference<LayoutChangeListener> next = it.next();
            LayoutChangeListener layoutChangeListener = next.get();
            if (layoutChangeListener == null || Intrinsics.areEqual(layoutChangeListener, listener)) {
                arrayList.add(next);
            }
        }
        layoutChangeListeners.removeAll(arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final <T extends ViewGroup & HasFlingAnimator & HasScrollEventThrottle & HasScrollState & HasStateWrapper> void smoothScrollTo(T scrollView, int x, int y) {
        if (DEBUG_MODE) {
            FLog.i(TAG, "smoothScrollTo[%d] x %d y %d", Integer.valueOf(((View) scrollView).getId()), Integer.valueOf(x), Integer.valueOf(y));
        }
        T t = scrollView;
        ValueAnimator defaultFlingAnimator = t.getDefaultFlingAnimator();
        if (defaultFlingAnimator.getListeners() == null || defaultFlingAnimator.getListeners().size() == 0) {
            INSTANCE.registerFlingAnimator(scrollView);
        }
        scrollView.get_reactScrollViewScrollState().setFinalAnimatedPositionScroll(x, y);
        View view = (View) scrollView;
        int scrollX = view.getScrollX();
        int scrollY = view.getScrollY();
        if (scrollX != x) {
            t.startFlingAnimator(scrollX, x);
        }
        if (scrollY != y) {
            t.startFlingAnimator(scrollY, y);
        }
    }

    @JvmStatic
    public static final <T extends ViewGroup & HasFlingAnimator & HasScrollState> int getNextFlingStartValue(T scrollView, int currentValue, int postAnimationValue, int velocity) {
        ReactScrollViewScrollState reactScrollViewScrollState = scrollView.get_reactScrollViewScrollState();
        return (!reactScrollViewScrollState.isFinished() || (reactScrollViewScrollState.isCanceled() && ((velocity != 0 ? velocity / Math.abs(velocity) : 0) * (postAnimationValue - currentValue) > 0))) ? postAnimationValue : currentValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final <T extends ViewGroup & HasFlingAnimator & HasScrollState & HasStateWrapper> void updateFabricScrollState(T scrollView) {
        View view = (View) scrollView;
        INSTANCE.updateFabricScrollState(scrollView, view.getScrollX(), view.getScrollY());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends ViewGroup & HasScrollState & HasStateWrapper> void updateFabricScrollState(T scrollView, int scrollX, int scrollY) {
        if (DEBUG_MODE) {
            FLog.i(TAG, "updateFabricScrollState[%d] scrollX %d scrollY %d", Integer.valueOf(((View) scrollView).getId()), Integer.valueOf(scrollX), Integer.valueOf(scrollY));
        }
        if (scrollView.getStateWrapper() == null) {
            return;
        }
        ReactScrollViewScrollState reactScrollViewScrollState = scrollView.get_reactScrollViewScrollState();
        reactScrollViewScrollState.setUpdatedByScroll(true);
        if (reactScrollViewScrollState.getLastStateUpdateScroll().equals(scrollX, scrollY)) {
            return;
        }
        reactScrollViewScrollState.setLastStateUpdateScroll(scrollX, scrollY);
        forceUpdateState(scrollView);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final <T extends ViewGroup & HasScrollState & HasStateWrapper> void forceUpdateState(T scrollView) {
        ReactScrollViewScrollState reactScrollViewScrollState = scrollView.get_reactScrollViewScrollState();
        int scrollAwayPaddingTop = reactScrollViewScrollState.getScrollAwayPaddingTop();
        int scrollAwayPaddingBottom = reactScrollViewScrollState.getScrollAwayPaddingBottom();
        Point lastStateUpdateScroll = reactScrollViewScrollState.getLastStateUpdateScroll();
        int i = lastStateUpdateScroll.x;
        int i2 = lastStateUpdateScroll.y;
        if (DEBUG_MODE) {
            FLog.i(TAG, "updateFabricScrollState[%d] scrollX %d scrollY %d", Integer.valueOf(((View) scrollView).getId()), Integer.valueOf(i), Integer.valueOf(i2));
        }
        StateWrapper stateWrapper = scrollView.getStateWrapper();
        if (stateWrapper != null) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putDouble(CONTENT_OFFSET_LEFT, PixelUtil.toDIPFromPixel(i));
            writableNativeMap.putDouble(CONTENT_OFFSET_TOP, PixelUtil.toDIPFromPixel(i2));
            writableNativeMap.putDouble(SCROLL_AWAY_PADDING_TOP, PixelUtil.toDIPFromPixel(scrollAwayPaddingTop));
            writableNativeMap.putDouble(SCROLL_AWAY_PADDING_BOTTOM, PixelUtil.toDIPFromPixel(scrollAwayPaddingBottom));
            stateWrapper.updateState(writableNativeMap);
        }
    }

    @JvmStatic
    public static final <T extends ViewGroup & HasScrollState & HasStateWrapper> void loadFabricScrollState$ReactAndroid(T scrollView, StateWrapper stateWrapper) {
        ReadableNativeMap stateData;
        Intrinsics.checkNotNullParameter(stateWrapper, "stateWrapper");
        T t = scrollView;
        if (t.get_reactScrollViewScrollState().isUpdatedByScroll() || (stateData = stateWrapper.getStateData()) == null) {
            return;
        }
        int pixelFromDIP = (int) PixelUtil.toPixelFromDIP(stateData.getDouble(CONTENT_OFFSET_LEFT));
        int pixelFromDIP2 = (int) PixelUtil.toPixelFromDIP(stateData.getDouble(CONTENT_OFFSET_TOP));
        ReactScrollViewScrollState reactScrollViewScrollStateCopy$default = ReactScrollViewScrollState.copy$default(t.get_reactScrollViewScrollState(), null, (int) PixelUtil.toPixelFromDIP(stateData.getDouble(SCROLL_AWAY_PADDING_TOP)), (int) PixelUtil.toPixelFromDIP(stateData.getDouble(SCROLL_AWAY_PADDING_BOTTOM)), null, false, false, 0.0f, false, 249, null);
        reactScrollViewScrollStateCopy$default.setLastStateUpdateScroll(pixelFromDIP, pixelFromDIP2);
        t.setReactScrollViewScrollState(reactScrollViewScrollStateCopy$default);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final <T extends ViewGroup & HasFlingAnimator & HasScrollEventThrottle & HasScrollState & HasStateWrapper> void updateStateOnScrollChanged(T scrollView, float xVelocity, float yVelocity) {
        View view = (View) scrollView;
        INSTANCE.updateFabricScrollState(scrollView, view.getScrollX(), view.getScrollY());
        emitScrollEvent(scrollView, xVelocity, yVelocity);
    }

    public final <T extends ViewGroup & HasFlingAnimator & HasScrollEventThrottle & HasScrollState & HasStateWrapper> void registerFlingAnimator(final T scrollView) {
        scrollView.getDefaultFlingAnimator().addListener(new Animator.AnimatorListener() { // from class: com.facebook.react.views.scroll.ReactScrollViewHelper.registerFlingAnimator.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
                ReactScrollViewScrollState reactScrollViewScrollState = ((HasScrollState) scrollView).get_reactScrollViewScrollState();
                reactScrollViewScrollState.setCanceled(false);
                reactScrollViewScrollState.setFinished(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
                ((HasScrollState) scrollView).get_reactScrollViewScrollState().setFinished(true);
                ReactScrollViewHelper.notifyUserDrivenScrollEnded_internal(scrollView);
                ReactScrollViewHelper.updateFabricScrollState(scrollView);
                ReactScrollViewHelper.emitScrollEventNoThrottle(scrollView, 0.0f, 0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
                ((HasScrollState) scrollView).get_reactScrollViewScrollState().setCanceled(true);
                ReactScrollViewHelper.notifyUserDrivenScrollEnded_internal(scrollView);
                ReactScrollViewHelper.emitScrollEventNoThrottle(scrollView, 0.0f, 0.0f);
            }
        });
    }

    @JvmStatic
    public static final <T extends ViewGroup & HasFlingAnimator & HasScrollEventThrottle> void dispatchMomentumEndOnAnimationEnd(final T scrollView) {
        scrollView.getDefaultFlingAnimator().addListener(new Animator.AnimatorListener() { // from class: com.facebook.react.views.scroll.ReactScrollViewHelper.dispatchMomentumEndOnAnimationEnd.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
                ReactScrollViewHelper.emitScrollMomentumEndEvent(scrollView);
                animator.removeListener(this);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
                ReactScrollViewHelper.emitScrollMomentumEndEvent(scrollView);
                animator.removeListener(this);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final <T extends ViewGroup & HasFlingAnimator & HasScrollState> Point predictFinalScrollPosition(T scrollView, int velocityX, int velocityY, int maximumOffsetX, int maximumOffsetY) {
        ReactScrollViewScrollState reactScrollViewScrollState = scrollView.get_reactScrollViewScrollState();
        View view = (View) scrollView;
        OverScroller overScroller = new OverScroller(view.getContext());
        overScroller.setFriction(1.0f - reactScrollViewScrollState.getDecelerationRate());
        int width = (view.getWidth() - view.getPaddingStart()) - view.getPaddingEnd();
        int height = (view.getHeight() - view.getPaddingBottom()) - view.getPaddingTop();
        Point finalAnimatedPositionScroll = reactScrollViewScrollState.getFinalAnimatedPositionScroll();
        overScroller.fling(getNextFlingStartValue(scrollView, view.getScrollX(), finalAnimatedPositionScroll.x, velocityX), getNextFlingStartValue(scrollView, view.getScrollY(), finalAnimatedPositionScroll.y, velocityY), velocityX, velocityY, 0, maximumOffsetX, 0, maximumOffsetY, width / 2, height / 2);
        return new Point(overScroller.getFinalX(), overScroller.getFinalY());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final View findNextFocusableView(ViewGroup host, View focused, int direction) {
        FabricUIManager fabricUIManager;
        Integer numFindNextFocusableElement;
        int iIntValue;
        int[] relativeAncestorList;
        Set<Integer> mutableSet;
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(focused, "focused");
        if (!(host instanceof ReactClippingViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = host;
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        UIManager uIManager = UIManagerHelper.getUIManager((ReactContext) context, 2);
        if (uIManager == null || (numFindNextFocusableElement = (fabricUIManager = (FabricUIManager) uIManager).findNextFocusableElement(viewGroup.getId(), focused.getId(), direction)) == null || (relativeAncestorList = fabricUIManager.getRelativeAncestorList(host.getChildAt(0).getId(), (iIntValue = numFindNextFocusableElement.intValue()))) == null || (mutableSet = ArraysKt.toMutableSet(relativeAncestorList)) == null) {
            return null;
        }
        mutableSet.add(numFindNextFocusableElement);
        ((ReactClippingViewGroup) host).updateClippingRect(mutableSet);
        return host.findViewById(iIntValue);
    }

    /* JADX INFO: compiled from: ReactScrollViewHelper.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J0\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/facebook/react/views/scroll/ReactScrollViewHelper$OverScrollerDurationGetter;", "Landroid/widget/OverScroller;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "currentScrollAnimationDuration", "", "scrollAnimationDuration", "getScrollAnimationDuration", "()I", "startScroll", "", "startX", "startY", "dx", "dy", "duration", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class OverScrollerDurationGetter extends OverScroller {
        private int currentScrollAnimationDuration;

        public OverScrollerDurationGetter(Context context) {
            super(context);
            this.currentScrollAnimationDuration = 250;
        }

        public final int getScrollAnimationDuration() {
            super.startScroll(0, 0, 0, 0);
            return this.currentScrollAnimationDuration;
        }

        @Override // android.widget.OverScroller
        public void startScroll(int startX, int startY, int dx, int dy, int duration) {
            this.currentScrollAnimationDuration = duration;
        }
    }

    /* JADX INFO: compiled from: ReactScrollViewHelper.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b(\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0005J\u0016\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0005J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\tHÆ\u0003J\t\u0010-\u001a\u00020\tHÆ\u0003J\t\u0010.\u001a\u00020\fHÆ\u0003J\t\u0010/\u001a\u00020\tHÆ\u0003JY\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\tHÆ\u0001J\u0013\u00101\u001a\u00020\t2\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\u0005HÖ\u0001J\t\u00104\u001a\u000205HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\n\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0019\"\u0004\b\u001c\u0010\u001bR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\r\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0019\"\u0004\b!\u0010\u001b¨\u00066"}, d2 = {"Lcom/facebook/react/views/scroll/ReactScrollViewHelper$ReactScrollViewScrollState;", "", "finalAnimatedPositionScroll", "Landroid/graphics/Point;", ReactScrollViewHelper.SCROLL_AWAY_PADDING_TOP, "", ReactScrollViewHelper.SCROLL_AWAY_PADDING_BOTTOM, "lastStateUpdateScroll", "isCanceled", "", "isFinished", "decelerationRate", "", "isUpdatedByScroll", "<init>", "(Landroid/graphics/Point;IILandroid/graphics/Point;ZZFZ)V", "getFinalAnimatedPositionScroll", "()Landroid/graphics/Point;", "getScrollAwayPaddingTop", "()I", "setScrollAwayPaddingTop", "(I)V", "getScrollAwayPaddingBottom", "setScrollAwayPaddingBottom", "getLastStateUpdateScroll", "()Z", "setCanceled", "(Z)V", "setFinished", "getDecelerationRate", "()F", "setDecelerationRate", "(F)V", "setUpdatedByScroll", "setFinalAnimatedPositionScroll", "finalAnimatedPositionScrollX", "finalAnimatedPositionScrollY", "setLastStateUpdateScroll", "lastStateUpdateScrollX", "lastStateUpdateScrollY", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ReactScrollViewScrollState {
        private float decelerationRate;
        private final Point finalAnimatedPositionScroll;
        private boolean isCanceled;
        private boolean isFinished;
        private boolean isUpdatedByScroll;
        private final Point lastStateUpdateScroll;
        private int scrollAwayPaddingBottom;
        private int scrollAwayPaddingTop;

        public ReactScrollViewScrollState() {
            this(null, 0, 0, null, false, false, 0.0f, false, 255, null);
        }

        public static /* synthetic */ ReactScrollViewScrollState copy$default(ReactScrollViewScrollState reactScrollViewScrollState, Point point, int i, int i2, Point point2, boolean z, boolean z2, float f, boolean z3, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                point = reactScrollViewScrollState.finalAnimatedPositionScroll;
            }
            if ((i3 & 2) != 0) {
                i = reactScrollViewScrollState.scrollAwayPaddingTop;
            }
            if ((i3 & 4) != 0) {
                i2 = reactScrollViewScrollState.scrollAwayPaddingBottom;
            }
            if ((i3 & 8) != 0) {
                point2 = reactScrollViewScrollState.lastStateUpdateScroll;
            }
            if ((i3 & 16) != 0) {
                z = reactScrollViewScrollState.isCanceled;
            }
            if ((i3 & 32) != 0) {
                z2 = reactScrollViewScrollState.isFinished;
            }
            if ((i3 & 64) != 0) {
                f = reactScrollViewScrollState.decelerationRate;
            }
            if ((i3 & 128) != 0) {
                z3 = reactScrollViewScrollState.isUpdatedByScroll;
            }
            float f2 = f;
            boolean z4 = z3;
            boolean z5 = z;
            boolean z6 = z2;
            return reactScrollViewScrollState.copy(point, i, i2, point2, z5, z6, f2, z4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Point getFinalAnimatedPositionScroll() {
            return this.finalAnimatedPositionScroll;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getScrollAwayPaddingTop() {
            return this.scrollAwayPaddingTop;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getScrollAwayPaddingBottom() {
            return this.scrollAwayPaddingBottom;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Point getLastStateUpdateScroll() {
            return this.lastStateUpdateScroll;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getIsCanceled() {
            return this.isCanceled;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getIsFinished() {
            return this.isFinished;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final float getDecelerationRate() {
            return this.decelerationRate;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final boolean getIsUpdatedByScroll() {
            return this.isUpdatedByScroll;
        }

        public final ReactScrollViewScrollState copy(Point finalAnimatedPositionScroll, int scrollAwayPaddingTop, int scrollAwayPaddingBottom, Point lastStateUpdateScroll, boolean isCanceled, boolean isFinished, float decelerationRate, boolean isUpdatedByScroll) {
            Intrinsics.checkNotNullParameter(finalAnimatedPositionScroll, "finalAnimatedPositionScroll");
            Intrinsics.checkNotNullParameter(lastStateUpdateScroll, "lastStateUpdateScroll");
            return new ReactScrollViewScrollState(finalAnimatedPositionScroll, scrollAwayPaddingTop, scrollAwayPaddingBottom, lastStateUpdateScroll, isCanceled, isFinished, decelerationRate, isUpdatedByScroll);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReactScrollViewScrollState)) {
                return false;
            }
            ReactScrollViewScrollState reactScrollViewScrollState = (ReactScrollViewScrollState) other;
            return Intrinsics.areEqual(this.finalAnimatedPositionScroll, reactScrollViewScrollState.finalAnimatedPositionScroll) && this.scrollAwayPaddingTop == reactScrollViewScrollState.scrollAwayPaddingTop && this.scrollAwayPaddingBottom == reactScrollViewScrollState.scrollAwayPaddingBottom && Intrinsics.areEqual(this.lastStateUpdateScroll, reactScrollViewScrollState.lastStateUpdateScroll) && this.isCanceled == reactScrollViewScrollState.isCanceled && this.isFinished == reactScrollViewScrollState.isFinished && Float.compare(this.decelerationRate, reactScrollViewScrollState.decelerationRate) == 0 && this.isUpdatedByScroll == reactScrollViewScrollState.isUpdatedByScroll;
        }

        public int hashCode() {
            return (((((((((((((this.finalAnimatedPositionScroll.hashCode() * 31) + Integer.hashCode(this.scrollAwayPaddingTop)) * 31) + Integer.hashCode(this.scrollAwayPaddingBottom)) * 31) + this.lastStateUpdateScroll.hashCode()) * 31) + Boolean.hashCode(this.isCanceled)) * 31) + Boolean.hashCode(this.isFinished)) * 31) + Float.hashCode(this.decelerationRate)) * 31) + Boolean.hashCode(this.isUpdatedByScroll);
        }

        public String toString() {
            return "ReactScrollViewScrollState(finalAnimatedPositionScroll=" + this.finalAnimatedPositionScroll + ", scrollAwayPaddingTop=" + this.scrollAwayPaddingTop + ", scrollAwayPaddingBottom=" + this.scrollAwayPaddingBottom + ", lastStateUpdateScroll=" + this.lastStateUpdateScroll + ", isCanceled=" + this.isCanceled + ", isFinished=" + this.isFinished + ", decelerationRate=" + this.decelerationRate + ", isUpdatedByScroll=" + this.isUpdatedByScroll + ")";
        }

        public ReactScrollViewScrollState(Point finalAnimatedPositionScroll, int i, int i2, Point lastStateUpdateScroll, boolean z, boolean z2, float f, boolean z3) {
            Intrinsics.checkNotNullParameter(finalAnimatedPositionScroll, "finalAnimatedPositionScroll");
            Intrinsics.checkNotNullParameter(lastStateUpdateScroll, "lastStateUpdateScroll");
            this.finalAnimatedPositionScroll = finalAnimatedPositionScroll;
            this.scrollAwayPaddingTop = i;
            this.scrollAwayPaddingBottom = i2;
            this.lastStateUpdateScroll = lastStateUpdateScroll;
            this.isCanceled = z;
            this.isFinished = z2;
            this.decelerationRate = f;
            this.isUpdatedByScroll = z3;
        }

        public /* synthetic */ ReactScrollViewScrollState(Point point, int i, int i2, Point point2, boolean z, boolean z2, float f, boolean z3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? new Point() : point, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? 0 : i2, (i3 & 8) != 0 ? new Point(-1, -1) : point2, (i3 & 16) != 0 ? false : z, (i3 & 32) != 0 ? true : z2, (i3 & 64) != 0 ? 0.985f : f, (i3 & 128) != 0 ? false : z3);
        }

        public final Point getFinalAnimatedPositionScroll() {
            return this.finalAnimatedPositionScroll;
        }

        public final int getScrollAwayPaddingTop() {
            return this.scrollAwayPaddingTop;
        }

        public final void setScrollAwayPaddingTop(int i) {
            this.scrollAwayPaddingTop = i;
        }

        public final int getScrollAwayPaddingBottom() {
            return this.scrollAwayPaddingBottom;
        }

        public final void setScrollAwayPaddingBottom(int i) {
            this.scrollAwayPaddingBottom = i;
        }

        public final Point getLastStateUpdateScroll() {
            return this.lastStateUpdateScroll;
        }

        public final boolean isCanceled() {
            return this.isCanceled;
        }

        public final void setCanceled(boolean z) {
            this.isCanceled = z;
        }

        public final boolean isFinished() {
            return this.isFinished;
        }

        public final void setFinished(boolean z) {
            this.isFinished = z;
        }

        public final float getDecelerationRate() {
            return this.decelerationRate;
        }

        public final void setDecelerationRate(float f) {
            this.decelerationRate = f;
        }

        public final boolean isUpdatedByScroll() {
            return this.isUpdatedByScroll;
        }

        public final void setUpdatedByScroll(boolean z) {
            this.isUpdatedByScroll = z;
        }

        public final ReactScrollViewScrollState setFinalAnimatedPositionScroll(int finalAnimatedPositionScrollX, int finalAnimatedPositionScrollY) {
            this.finalAnimatedPositionScroll.set(finalAnimatedPositionScrollX, finalAnimatedPositionScrollY);
            return this;
        }

        public final ReactScrollViewScrollState setLastStateUpdateScroll(int lastStateUpdateScrollX, int lastStateUpdateScrollY) {
            this.lastStateUpdateScroll.set(lastStateUpdateScrollX, lastStateUpdateScrollY);
            return this;
        }
    }
}
