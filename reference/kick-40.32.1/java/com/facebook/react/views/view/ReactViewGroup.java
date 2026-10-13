package com.facebook.react.views.view;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.common.logging.FLog;
import com.facebook.react.R;
import com.facebook.react.ReactRootView$$ExternalSyntheticApiModelOutline0;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.touch.OnInterceptTouchEventListener;
import com.facebook.react.touch.ReactHitSlopView;
import com.facebook.react.touch.ReactInterceptingViewGroup;
import com.facebook.react.uimanager.BackgroundStyleApplicator;
import com.facebook.react.uimanager.BlendModeHelper;
import com.facebook.react.uimanager.LengthPercentage;
import com.facebook.react.uimanager.LengthPercentageType;
import com.facebook.react.uimanager.MeasureSpecAssertions;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactAxOrderHelper;
import com.facebook.react.uimanager.ReactClippingProhibitedView;
import com.facebook.react.uimanager.ReactClippingViewGroup;
import com.facebook.react.uimanager.ReactClippingViewGroupHelper;
import com.facebook.react.uimanager.ReactOverflowViewWithInset;
import com.facebook.react.uimanager.ReactPointerEventsView;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.style.BorderRadiusProp;
import com.facebook.react.uimanager.style.BorderStyle;
import com.facebook.react.uimanager.style.LogicalEdge;
import com.facebook.react.uimanager.style.Overflow;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ReactViewGroup.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\"\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 Ó\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0004Ò\u0001Ó\u0001B\u0011\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010J\u001a\u00020KH\u0002J\r\u0010L\u001a\u00020KH\u0010¢\u0006\u0002\bMJ\u0018\u0010N\u001a\u00020K2\u0006\u0010O\u001a\u00020\u00102\u0006\u0010P\u001a\u00020\u0010H\u0014J0\u0010Q\u001a\u00020K2\u0006\u0010R\u001a\u00020\u00122\u0006\u0010S\u001a\u00020\u00102\u0006\u0010T\u001a\u00020\u00102\u0006\u0010U\u001a\u00020\u00102\u0006\u0010V\u001a\u00020\u0010H\u0014J\b\u0010W\u001a\u00020KH\u0017J\u0010\u0010X\u001a\u00020K2\u0006\u0010Y\u001a\u00020ZH\u0017J\u0010\u0010[\u001a\u00020K2\u0006\u0010\\\u001a\u00020\u0010H\u0016J\u0012\u0010]\u001a\u00020K2\b\u0010^\u001a\u0004\u0018\u00010_H\u0007J\u0010\u0010`\u001a\u00020K2\u0006\u0010a\u001a\u000207H\u0016J\u0010\u0010b\u001a\u00020\u00122\u0006\u0010c\u001a\u00020dH\u0016J\u0010\u0010e\u001a\u00020\u00122\u0006\u0010c\u001a\u00020dH\u0016J\u0010\u0010f\u001a\u00020\u00122\u0006\u0010c\u001a\u00020dH\u0016J\u0010\u0010g\u001a\u00020\u00122\u0006\u0010h\u001a\u00020dH\u0016J\b\u0010i\u001a\u00020\u0012H\u0016J\u000e\u0010j\u001a\u00020K2\u0006\u00108\u001a\u00020\u0012J\u0016\u0010k\u001a\u00020K2\u0006\u0010l\u001a\u00020\u00102\u0006\u0010m\u001a\u00020:J\u001d\u0010n\u001a\u00020K2\u0006\u0010l\u001a\u00020\u00102\b\u0010\\\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010oJ\u0010\u0010p\u001a\u00020K2\u0006\u0010q\u001a\u00020:H\u0007J\u0018\u0010p\u001a\u00020K2\u0006\u0010q\u001a\u00020:2\u0006\u0010l\u001a\u00020\u0010H\u0007J\u0018\u0010p\u001a\u00020K2\u0006\u0010r\u001a\u00020s2\b\u0010q\u001a\u0004\u0018\u00010tJ\u0010\u0010u\u001a\u00020K2\b\u0010v\u001a\u0004\u0018\u00010/J\u0010\u0010{\u001a\u00020K2\u0006\u0010|\u001a\u00020\fH\u0016J\b\u0010}\u001a\u00020KH\u0016J\u0018\u0010}\u001a\u00020K2\u000e\u0010~\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u007fH\u0016J\u000f\u0010\u0080\u0001\u001a\u00020KH\u0000¢\u0006\u0003\b\u0081\u0001J\u000f\u0010\u0082\u0001\u001a\u00020KH\u0000¢\u0006\u0003\b\u0083\u0001J\u0012\u0010\u0084\u0001\u001a\u00020K2\u0007\u0010\u0085\u0001\u001a\u00020\u001aH\u0016J\u0012\u0010\u0086\u0001\u001a\u00020K2\u0007\u0010\u0087\u0001\u001a\u00020\u0010H\u0002J\u0012\u0010\u0088\u0001\u001a\u00020\u00122\u0007\u0010\u0089\u0001\u001a\u00020\u001aH\u0002J*\u0010\u008a\u0001\u001a\u00020K2\u0006\u0010 \u001a\u00020\f2\u0011\b\u0002\u0010\u008b\u0001\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u007fH\u0000¢\u0006\u0003\b\u008c\u0001J6\u0010\u008d\u0001\u001a\u00020K2\u0006\u0010 \u001a\u00020\f2\u0007\u0010\u008e\u0001\u001a\u00020\u00102\u0007\u0010\u008f\u0001\u001a\u00020\u00102\u0011\b\u0002\u0010\u008b\u0001\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u007fH\u0002J\u0012\u0010\u008d\u0001\u001a\u00020K2\u0007\u0010\u0090\u0001\u001a\u00020\u001aH\u0002J-\u0010\u0091\u0001\u001a\u00020K2\u0007\u0010\u0092\u0001\u001a\u00020\u00102\u0007\u0010\u0093\u0001\u001a\u00020\u00102\u0007\u0010\u0094\u0001\u001a\u00020\u00102\u0007\u0010\u0095\u0001\u001a\u00020\u0010H\u0014J\t\u0010\u0096\u0001\u001a\u00020KH\u0014J\u0013\u0010\u0097\u0001\u001a\u00020K2\b\u0010\u0098\u0001\u001a\u00030\u0099\u0001H\u0014J\u001a\u0010\u009a\u0001\u001a\u00020K2\t\u0010\u009b\u0001\u001a\u0004\u0018\u00010BH\u0000¢\u0006\u0003\b\u009c\u0001J\u001a\u0010\u009d\u0001\u001a\u00020K2\t\u0010\u009b\u0001\u001a\u0004\u0018\u00010BH\u0000¢\u0006\u0003\b\u009e\u0001J\u0012\u0010\u009f\u0001\u001a\u00020K2\u0007\u0010\u0089\u0001\u001a\u00020\u001aH\u0016J\u0012\u0010 \u0001\u001a\u00020K2\u0007\u0010\u0089\u0001\u001a\u00020\u001aH\u0016J\u001b\u0010¡\u0001\u001a\u00020K2\u0007\u0010\u0089\u0001\u001a\u00020\u001a2\u0007\u0010¢\u0001\u001a\u00020\u0012H\u0002J\t\u0010£\u0001\u001a\u00020\u0012H\u0016J\u0012\u0010¤\u0001\u001a\u00020K2\u0007\u0010¥\u0001\u001a\u00020\u0012H\u0014J\t\u0010¦\u0001\u001a\u00020KH\u0002J\u001a\u0010§\u0001\u001a\u0004\u0018\u00010\u001a2\u0007\u0010¨\u0001\u001a\u00020\u0010H\u0000¢\u0006\u0003\b©\u0001J!\u0010ª\u0001\u001a\u00020K2\u0007\u0010\u0089\u0001\u001a\u00020\u001a2\u0007\u0010¨\u0001\u001a\u00020\u0010H\u0000¢\u0006\u0003\b«\u0001J\u0018\u0010¬\u0001\u001a\u00020K2\u0007\u0010\u0085\u0001\u001a\u00020\u001aH\u0000¢\u0006\u0003\b\u00ad\u0001J\u000f\u0010®\u0001\u001a\u00020KH\u0000¢\u0006\u0003\b¯\u0001J%\u0010°\u0001\u001a\u00020\u00122\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u001a2\t\u0010¨\u0001\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0003\u0010±\u0001J\u0012\u0010²\u0001\u001a\u00020\u00102\u0007\u0010\u0089\u0001\u001a\u00020\u001aH\u0002J\u001b\u0010³\u0001\u001a\u00020K2\u0007\u0010\u0089\u0001\u001a\u00020\u001a2\u0007\u0010¨\u0001\u001a\u00020\u0010H\u0002J\u0012\u0010´\u0001\u001a\u00020K2\u0007\u0010¨\u0001\u001a\u00020\u0010H\u0002J\u000b\u0010¼\u0001\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010¼\u0001\u001a\u00020\u00122\u0007\u0010½\u0001\u001a\u00020\fH\u0016J)\u0010¾\u0001\u001a\u00020K2\u0006\u0010S\u001a\u00020\u00102\u0006\u0010T\u001a\u00020\u00102\u0006\u0010U\u001a\u00020\u00102\u0006\u0010V\u001a\u00020\u0010H\u0016J\u0014\u0010¿\u0001\u001a\u00020K2\t\u0010À\u0001\u001a\u0004\u0018\u00010_H\u0002J\u0013\u0010Á\u0001\u001a\u00020K2\b\u0010Â\u0001\u001a\u00030Ã\u0001H\u0016J\u0013\u0010Ä\u0001\u001a\u00020K2\b\u0010Â\u0001\u001a\u00030Ã\u0001H\u0014J&\u0010Å\u0001\u001a\u00020\u00122\b\u0010Â\u0001\u001a\u00030Ã\u00012\u0007\u0010\u0089\u0001\u001a\u00020\u001a2\b\u0010Æ\u0001\u001a\u00030Ç\u0001H\u0014J\u0010\u0010È\u0001\u001a\u00020K2\u0007\u0010É\u0001\u001a\u00020:J\u0010\u0010Ê\u0001\u001a\u00020K2\u0007\u0010Ë\u0001\u001a\u00020/J\u0007\u0010Ì\u0001\u001a\u00020KJ\u0019\u0010Í\u0001\u001a\u00020K2\u000e\u0010Î\u0001\u001a\t\u0012\u0004\u0012\u00020\u001a0Ï\u0001H\u0016J\u0019\u0010Ð\u0001\u001a\u00020K2\u000e\u0010Î\u0001\u001a\t\u0012\u0004\u0012\u00020\u001a0Ï\u0001H\u0002J\u0007\u0010Ñ\u0001\u001a\u00020KR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u001e\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0010@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000e\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u000e\"\u0004\b&\u0010#R$\u0010(\u001a\u00020'2\u0006\u0010\u001c\u001a\u00020'@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010-\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010=X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010A\u001a\u0004\u0018\u00010BX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001c\u0010G\u001a\u0004\u0018\u00010BX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010D\"\u0004\bI\u0010FR$\u0010x\u001a\u00020\u00122\u0006\u0010w\u001a\u00020\u00128V@VX\u0096\u000e¢\u0006\f\u001a\u0004\by\u0010\u0014\"\u0004\bz\u0010\u0016R\u0010\u0010µ\u0001\u001a\u00030¶\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R.\u0010·\u0001\u001a\u0004\u0018\u00010/2\t\u0010·\u0001\u001a\u0004\u0018\u00010/8V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b¸\u0001\u0010¹\u0001\"\u0006\bº\u0001\u0010»\u0001¨\u0006Ô\u0001"}, d2 = {"Lcom/facebook/react/views/view/ReactViewGroup;", "Landroid/view/ViewGroup;", "Lcom/facebook/react/touch/ReactInterceptingViewGroup;", "Lcom/facebook/react/uimanager/ReactClippingViewGroup;", "Lcom/facebook/react/uimanager/ReactPointerEventsView;", "Lcom/facebook/react/touch/ReactHitSlopView;", "Lcom/facebook/react/uimanager/ReactOverflowViewWithInset;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "overflowInset", "Landroid/graphics/Rect;", "getOverflowInset", "()Landroid/graphics/Rect;", "recycleCount", "", "_removeClippedSubviews", "", "get_removeClippedSubviews$ReactAndroid", "()Z", "set_removeClippedSubviews$ReactAndroid", "(Z)V", "inSubviewClippingLoop", "allChildren", "", "Landroid/view/View;", "[Landroid/view/View;", "value", "allChildrenCount", "getAllChildrenCount$ReactAndroid", "()I", "clippingRect", "getClippingRect$ReactAndroid", "setClippingRect$ReactAndroid", "(Landroid/graphics/Rect;)V", "hitSlopRect", "getHitSlopRect", "setHitSlopRect", "Lcom/facebook/react/uimanager/PointerEvents;", ViewProps.POINTER_EVENTS, "getPointerEvents", "()Lcom/facebook/react/uimanager/PointerEvents;", "setPointerEvents", "(Lcom/facebook/react/uimanager/PointerEvents;)V", "axOrderList", "", "", "getAxOrderList", "()Ljava/util/List;", "setAxOrderList", "(Ljava/util/List;)V", "childrenLayoutChangeListener", "Lcom/facebook/react/views/view/ReactViewGroup$ChildrenLayoutChangeListener;", "onInterceptTouchEventListener", "Lcom/facebook/react/touch/OnInterceptTouchEventListener;", ViewProps.NEEDS_OFFSCREEN_ALPHA_COMPOSITING, "backfaceOpacity", "", "backfaceVisible", "childrenRemovedWhileTransitioning", "", "accessibilityStateChangeListener", "Landroid/view/accessibility/AccessibilityManager$AccessibilityStateChangeListener;", "focusOnAttach", "nativeBackgroundMap", "Lcom/facebook/react/bridge/ReadableMap;", "getNativeBackgroundMap$ReactAndroid", "()Lcom/facebook/react/bridge/ReadableMap;", "setNativeBackgroundMap$ReactAndroid", "(Lcom/facebook/react/bridge/ReadableMap;)V", "nativeForegroundMap", "getNativeForegroundMap$ReactAndroid", "setNativeForegroundMap$ReactAndroid", "initView", "", "recycleView", "recycleView$ReactAndroid", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onLayout", "changed", "left", ViewProps.TOP, "right", ViewProps.BOTTOM, "requestLayout", "dispatchProvideStructure", "structure", "Landroid/view/ViewStructure;", "setBackgroundColor", "color", "setTranslucentBackgroundDrawable", "background", "Landroid/graphics/drawable/Drawable;", "setOnInterceptTouchEventListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "onInterceptTouchEvent", "event", "Landroid/view/MotionEvent;", "onTouchEvent", "onHoverEvent", "dispatchGenericMotionEvent", "ev", "hasOverlappingRendering", "setNeedsOffscreenAlphaCompositing", "setBorderWidth", ViewProps.POSITION, ViewProps.WIDTH, "setBorderColor", "(ILjava/lang/Integer;)V", "setBorderRadius", ViewProps.BORDER_RADIUS, "property", "Lcom/facebook/react/uimanager/style/BorderRadiusProp;", "Lcom/facebook/react/uimanager/LengthPercentage;", "setBorderStyle", "style", "newValue", ReactClippingViewGroupHelper.PROP_REMOVE_CLIPPED_SUBVIEWS, "getRemoveClippedSubviews", "setRemoveClippedSubviews", "getClippingRect", "outClippingRect", "updateClippingRect", "excludedViews", "", "requestFocusFromJS", "requestFocusFromJS$ReactAndroid", "clearFocusFromJS", "clearFocusFromJS$ReactAndroid", "endViewTransition", "view", "trackChildViewTransition", "childId", "isChildRemovedWhileTransitioning", "child", "updateClippingToRect", "excludedViewsSet", "updateClippingToRect$ReactAndroid", "updateSubviewClipStatus", "idx", "clippedSoFar", "subview", "onSizeChanged", "w", "h", "oldw", "oldh", "onAttachedToWindow", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "applyNativeBackground", "map", "applyNativeBackground$ReactAndroid", "applyNativeForeground", "applyNativeForeground$ReactAndroid", "onViewAdded", "onViewRemoved", "checkViewClippingTag", "expectedTag", "shouldDelayChildPressedState", "dispatchSetPressed", "pressed", "resetPointerEvents", "getChildAtWithSubviewClippingEnabled", FirebaseAnalytics.Param.INDEX, "getChildAtWithSubviewClippingEnabled$ReactAndroid", "addViewWithSubviewClippingEnabled", "addViewWithSubviewClippingEnabled$ReactAndroid", "removeViewWithSubviewClippingEnabled", "removeViewWithSubviewClippingEnabled$ReactAndroid", "removeAllViewsWithSubviewClippingEnabled", "removeAllViewsWithSubviewClippingEnabled$ReactAndroid", "isViewClipped", "(Landroid/view/View;Ljava/lang/Integer;)Z", "indexOfChildInAllChildren", "addInArray", "removeFromArray", "_overflow", "Lcom/facebook/react/uimanager/style/Overflow;", ViewProps.OVERFLOW, "getOverflow", "()Ljava/lang/String;", "setOverflow", "(Ljava/lang/String;)V", "getClipBounds", "outRect", "setOverflowInset", "updateBackgroundDrawable", "drawable", "draw", "canvas", "Landroid/graphics/Canvas;", "dispatchDraw", "drawChild", "drawingTime", "", "setOpacityIfPossible", ViewProps.OPACITY, "setBackfaceVisibility", "backfaceVisibility", "setBackfaceVisibilityDependantOpacity", "addChildrenForAccessibility", "outChildren", "Ljava/util/ArrayList;", "safeAddChildrenForAccessibility", "cleanUpAxOrderListener", "ChildrenLayoutChangeListener", "Companion", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class ReactViewGroup extends ViewGroup implements ReactInterceptingViewGroup, ReactClippingViewGroup, ReactPointerEventsView, ReactHitSlopView, ReactOverflowViewWithInset {
    private static final int ARRAY_CAPACITY_INCREMENT = 12;
    private static final Companion Companion = new Companion(null);
    private static final ViewGroup.LayoutParams defaultLayoutParam = new ViewGroup.LayoutParams(0, 0);
    private Overflow _overflow;
    private boolean _removeClippedSubviews;
    private AccessibilityManager.AccessibilityStateChangeListener accessibilityStateChangeListener;
    private View[] allChildren;
    private int allChildrenCount;
    private List<String> axOrderList;
    private float backfaceOpacity;
    private boolean backfaceVisible;
    private ChildrenLayoutChangeListener childrenLayoutChangeListener;
    private Set<Integer> childrenRemovedWhileTransitioning;
    private Rect clippingRect;
    private boolean focusOnAttach;
    private Rect hitSlopRect;
    private volatile boolean inSubviewClippingLoop;
    private ReadableMap nativeBackgroundMap;
    private ReadableMap nativeForegroundMap;
    private boolean needsOffscreenAlphaCompositing;
    private OnInterceptTouchEventListener onInterceptTouchEventListener;
    private final Rect overflowInset;
    private PointerEvents pointerEvents;
    private int recycleCount;

    /* JADX INFO: compiled from: ReactViewGroup.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Overflow.values().length];
            try {
                iArr[Overflow.HIDDEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Overflow.SCROLL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Overflow.VISIBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean pressed) {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ReactViewGroup(Context context) {
        super(context);
        this.overflowInset = new Rect();
        this.pointerEvents = PointerEvents.AUTO;
        initView();
        this._overflow = Overflow.VISIBLE;
    }

    @Override // com.facebook.react.uimanager.ReactOverflowViewWithInset
    /* JADX INFO: renamed from: getOverflowInset, reason: from getter */
    public Rect get_overflowInset() {
        return this.overflowInset;
    }

    /* JADX INFO: compiled from: ReactViewGroup.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005JP\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\u0006\u0010\u0013\u001a\u00020\u0007R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/facebook/react/views/view/ReactViewGroup$ChildrenLayoutChangeListener;", "Landroid/view/View$OnLayoutChangeListener;", "parent", "Lcom/facebook/react/views/view/ReactViewGroup;", "<init>", "(Lcom/facebook/react/views/view/ReactViewGroup;)V", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", ViewProps.TOP, "right", ViewProps.BOTTOM, "oldLeft", "oldTop", "oldRight", "oldBottom", "shutdown", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class ChildrenLayoutChangeListener implements View.OnLayoutChangeListener {
        private ReactViewGroup parent;

        public ChildrenLayoutChangeListener(ReactViewGroup reactViewGroup) {
            this.parent = reactViewGroup;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            ReactViewGroup reactViewGroup;
            Intrinsics.checkNotNullParameter(v, "v");
            ReactViewGroup reactViewGroup2 = this.parent;
            if (reactViewGroup2 == null || !reactViewGroup2.get_removeClippedSubviews() || (reactViewGroup = this.parent) == null) {
                return;
            }
            reactViewGroup.updateSubviewClipStatus(v);
        }

        public final void shutdown() {
            this.parent = null;
        }
    }

    /* JADX INFO: renamed from: get_removeClippedSubviews$ReactAndroid, reason: from getter */
    public final boolean get_removeClippedSubviews() {
        return this._removeClippedSubviews;
    }

    public final void set_removeClippedSubviews$ReactAndroid(boolean z) {
        this._removeClippedSubviews = z;
    }

    /* JADX INFO: renamed from: getAllChildrenCount$ReactAndroid, reason: from getter */
    public final int getAllChildrenCount() {
        return this.allChildrenCount;
    }

    /* JADX INFO: renamed from: getClippingRect$ReactAndroid, reason: from getter */
    public final Rect getClippingRect() {
        return this.clippingRect;
    }

    public final void setClippingRect$ReactAndroid(Rect rect) {
        this.clippingRect = rect;
    }

    @Override // com.facebook.react.touch.ReactHitSlopView
    public Rect getHitSlopRect() {
        return this.hitSlopRect;
    }

    public void setHitSlopRect(Rect rect) {
        this.hitSlopRect = rect;
    }

    @Override // com.facebook.react.uimanager.ReactPointerEventsView
    public PointerEvents getPointerEvents() {
        return this.pointerEvents;
    }

    public void setPointerEvents(PointerEvents value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.pointerEvents = value;
        ImportantForInteractionHelper.setImportantForInteraction(this, value, this._overflow);
    }

    public final List<String> getAxOrderList() {
        return this.axOrderList;
    }

    public final void setAxOrderList(List<String> list) {
        this.axOrderList = list;
    }

    /* JADX INFO: renamed from: getNativeBackgroundMap$ReactAndroid, reason: from getter */
    public final ReadableMap getNativeBackgroundMap() {
        return this.nativeBackgroundMap;
    }

    public final void setNativeBackgroundMap$ReactAndroid(ReadableMap readableMap) {
        this.nativeBackgroundMap = readableMap;
    }

    /* JADX INFO: renamed from: getNativeForegroundMap$ReactAndroid, reason: from getter */
    public final ReadableMap getNativeForegroundMap() {
        return this.nativeForegroundMap;
    }

    public final void setNativeForegroundMap$ReactAndroid(ReadableMap readableMap) {
        this.nativeForegroundMap = readableMap;
    }

    private final void initView() {
        setClipChildren(false);
        this._removeClippedSubviews = false;
        this.inSubviewClippingLoop = false;
        this.allChildren = null;
        this.allChildrenCount = 0;
        this.clippingRect = null;
        setHitSlopRect(null);
        this._overflow = Overflow.VISIBLE;
        setPointerEvents(PointerEvents.AUTO);
        this.childrenLayoutChangeListener = null;
        this.onInterceptTouchEventListener = null;
        this.needsOffscreenAlphaCompositing = false;
        this.backfaceOpacity = 1.0f;
        this.backfaceVisible = true;
        this.childrenRemovedWhileTransitioning = null;
        this.nativeBackgroundMap = null;
        this.nativeForegroundMap = null;
    }

    public void recycleView$ReactAndroid() {
        ChildrenLayoutChangeListener childrenLayoutChangeListener;
        this.recycleCount++;
        View[] viewArr = this.allChildren;
        if (viewArr != null && (childrenLayoutChangeListener = this.childrenLayoutChangeListener) != null) {
            if (childrenLayoutChangeListener != null) {
                childrenLayoutChangeListener.shutdown();
            }
            int i = this.allChildrenCount;
            for (int i2 = 0; i2 < i; i2++) {
                View view = viewArr[i2];
                if (view != null) {
                    view.removeOnLayoutChangeListener(this.childrenLayoutChangeListener);
                }
            }
        }
        initView();
        get_overflowInset().setEmpty();
        removeAllViews();
        if (getParent() != null) {
            ViewParent parent = getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(this);
        }
        updateBackgroundDrawable(null);
        resetPointerEvents();
        this.focusOnAttach = false;
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        MeasureSpecAssertions.assertExplicitMeasureSpec(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), View.MeasureSpec.getSize(heightMeasureSpec));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchProvideStructure(ViewStructure structure) {
        Intrinsics.checkNotNullParameter(structure, "structure");
        try {
            super.dispatchProvideStructure(structure);
        } catch (NullPointerException e) {
            FLog.e(ReactConstants.TAG, "NullPointerException when executing dispatchProvideStructure", e);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int color) {
        BackgroundStyleApplicator.setBackgroundColor(this, Integer.valueOf(color));
    }

    @Deprecated(message = "setTranslucentBackgroundDrawable is deprecated since React Native 0.76.0 and will be removed in a future version")
    public final void setTranslucentBackgroundDrawable(Drawable background) {
        BackgroundStyleApplicator.setFeedbackUnderlay(this, background);
    }

    @Override // com.facebook.react.touch.ReactInterceptingViewGroup
    public void setOnInterceptTouchEventListener(OnInterceptTouchEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onInterceptTouchEventListener = listener;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        OnInterceptTouchEventListener onInterceptTouchEventListener = this.onInterceptTouchEventListener;
        if ((onInterceptTouchEventListener == null || !onInterceptTouchEventListener.onInterceptTouchEvent(this, event)) && PointerEvents.INSTANCE.canChildrenBeTouchTarget(getPointerEvents())) {
            return super.onInterceptTouchEvent(event);
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return PointerEvents.INSTANCE.canBeTouchTarget(getPointerEvents());
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (ReactFeatureFlags.dispatchPointerEvents) {
            return PointerEvents.INSTANCE.canBeTouchTarget(getPointerEvents());
        }
        return super.onHoverEvent(event);
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (PointerEvents.INSTANCE.canChildrenBeTouchTarget(getPointerEvents())) {
            return super.dispatchGenericMotionEvent(ev);
        }
        return false;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return this.needsOffscreenAlphaCompositing;
    }

    public final void setNeedsOffscreenAlphaCompositing(boolean needsOffscreenAlphaCompositing) {
        this.needsOffscreenAlphaCompositing = needsOffscreenAlphaCompositing;
    }

    public final void setBorderWidth(int position, float width) {
        BackgroundStyleApplicator.setBorderWidth(this, LogicalEdge.getEntries().get(position), Float.valueOf(PixelUtil.toDIPFromPixel(width)));
    }

    public final void setBorderColor(int position, Integer color) {
        BackgroundStyleApplicator.setBorderColor(this, LogicalEdge.getEntries().get(position), color);
    }

    @Deprecated(message = "setBorderRadius(Float) is deprecated and will be removed in the future.", replaceWith = @ReplaceWith(expression = "setBorderRadius(Float,LengthPercentage)", imports = {}))
    public final void setBorderRadius(float borderRadius) {
        BackgroundStyleApplicator.setBorderRadius(this, BorderRadiusProp.BORDER_RADIUS, Float.isNaN(borderRadius) ? null : new LengthPercentage(borderRadius, LengthPercentageType.POINT));
    }

    @Deprecated(message = "setBorderRadius(Float) is deprecated and will be removed in the future.", replaceWith = @ReplaceWith(expression = "setBorderRadius(Float,LengthPercentage)", imports = {}))
    public final void setBorderRadius(float borderRadius, int position) {
        BackgroundStyleApplicator.setBorderRadius(this, BorderRadiusProp.getEntries().get(position), Float.isNaN(borderRadius) ? null : new LengthPercentage(borderRadius, LengthPercentageType.POINT));
    }

    public final void setBorderRadius(BorderRadiusProp property, LengthPercentage borderRadius) {
        Intrinsics.checkNotNullParameter(property, "property");
        BackgroundStyleApplicator.setBorderRadius(this, property, borderRadius);
    }

    public final void setBorderStyle(String style) {
        BackgroundStyleApplicator.setBorderStyle(this, style != null ? BorderStyle.INSTANCE.fromString(style) : null);
    }

    @Override // com.facebook.react.uimanager.ReactClippingViewGroup
    /* JADX INFO: renamed from: getRemoveClippedSubviews */
    public boolean get_removeClippedSubviews() {
        if (ReactNativeFeatureFlags.disableSubviewClippingAndroid()) {
            return false;
        }
        return this._removeClippedSubviews;
    }

    @Override // com.facebook.react.uimanager.ReactClippingViewGroup
    public void setRemoveClippedSubviews(boolean z) {
        if (ReactNativeFeatureFlags.disableSubviewClippingAndroid() || z == this._removeClippedSubviews) {
            return;
        }
        this._removeClippedSubviews = z;
        this.childrenRemovedWhileTransitioning = null;
        if (z) {
            Rect rect = new Rect();
            ReactClippingViewGroupHelper.calculateClippingRect(this, rect);
            this.clippingRect = rect;
            int childCount = getChildCount();
            this.allChildrenCount = childCount;
            View[] viewArr = new View[Math.max(12, childCount)];
            this.childrenLayoutChangeListener = new ChildrenLayoutChangeListener(this);
            int i = this.allChildrenCount;
            for (int i2 = 0; i2 < i; i2++) {
                View childAt = getChildAt(i2);
                viewArr[i2] = childAt;
                childAt.addOnLayoutChangeListener(this.childrenLayoutChangeListener);
                Companion companion = Companion;
                Intrinsics.checkNotNull(childAt);
                companion.setViewClipped(childAt, false);
            }
            this.allChildren = viewArr;
            updateClippingRect();
            return;
        }
        View[] viewArr2 = this.allChildren;
        if (viewArr2 == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        if (this.childrenLayoutChangeListener == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        int i3 = this.allChildrenCount;
        for (int i4 = 0; i4 < i3; i4++) {
            View view = viewArr2[i4];
            if (view != null) {
                view.removeOnLayoutChangeListener(this.childrenLayoutChangeListener);
            }
        }
        Rect rect2 = this.clippingRect;
        if (rect2 == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        getDrawingRect(rect2);
        updateClippingToRect$ReactAndroid$default(this, rect2, null, 2, null);
        this.allChildren = null;
        this.clippingRect = null;
        this.allChildrenCount = 0;
        this.childrenLayoutChangeListener = null;
    }

    @Override // com.facebook.react.uimanager.ReactClippingViewGroup
    public void getClippingRect(Rect outClippingRect) {
        Intrinsics.checkNotNullParameter(outClippingRect, "outClippingRect");
        Rect rect = this.clippingRect;
        if (rect == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        outClippingRect.set(rect);
    }

    @Override // com.facebook.react.uimanager.ReactClippingViewGroup
    public void updateClippingRect() {
        updateClippingRect(null);
    }

    @Override // com.facebook.react.uimanager.ReactClippingViewGroup
    public void updateClippingRect(Set<Integer> excludedViews) {
        if (this._removeClippedSubviews) {
            Rect rect = this.clippingRect;
            if (rect == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            ReactClippingViewGroupHelper.calculateClippingRect(this, rect);
            updateClippingToRect$ReactAndroid(rect, excludedViews);
        }
    }

    public final void requestFocusFromJS$ReactAndroid() {
        if (isAttachedToWindow()) {
            super.requestFocus(130, null);
        } else {
            this.focusOnAttach = true;
        }
    }

    public final void clearFocusFromJS$ReactAndroid() {
        this.focusOnAttach = false;
        super.clearFocus();
    }

    @Override // android.view.ViewGroup
    public void endViewTransition(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.endViewTransition(view);
        Set<Integer> set = this.childrenRemovedWhileTransitioning;
        if (set != null) {
            set.remove(Integer.valueOf(view.getId()));
        }
    }

    private final void trackChildViewTransition(int childId) {
        if (this.childrenRemovedWhileTransitioning == null) {
            this.childrenRemovedWhileTransitioning = new LinkedHashSet();
        }
        Set<Integer> set = this.childrenRemovedWhileTransitioning;
        if (set != null) {
            set.add(Integer.valueOf(childId));
        }
    }

    private final boolean isChildRemovedWhileTransitioning(View child) {
        Set<Integer> set = this.childrenRemovedWhileTransitioning;
        return set != null && set.contains(Integer.valueOf(child.getId()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateClippingToRect$ReactAndroid$default(ReactViewGroup reactViewGroup, Rect rect, Set set, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateClippingToRect");
        }
        if ((i & 2) != 0) {
            set = null;
        }
        reactViewGroup.updateClippingToRect$ReactAndroid(rect, set);
    }

    public final void updateClippingToRect$ReactAndroid(Rect clippingRect, Set<Integer> excludedViewsSet) {
        Intrinsics.checkNotNullParameter(clippingRect, "clippingRect");
        View[] viewArr = this.allChildren;
        if (viewArr == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        this.inSubviewClippingLoop = true;
        int i = this.allChildrenCount;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            try {
                updateSubviewClipStatus(clippingRect, i3, i2, excludedViewsSet);
                if (isViewClipped(viewArr[i3], Integer.valueOf(i3))) {
                    i2++;
                }
                if (i3 - i2 > getChildCount()) {
                    throw new IllegalStateException("Invalid clipping state. i=" + i3 + " clippedSoFar=" + i2 + " count=" + getChildCount() + " allChildrenCount=" + this.allChildrenCount + " recycleCount=" + this.recycleCount + "  excludedViews=" + (excludedViewsSet != null ? excludedViewsSet.size() : 0));
                }
            } catch (IndexOutOfBoundsException e) {
                HashSet hashSet = new HashSet();
                int i4 = 0;
                for (int i5 = 0; i5 < i3; i5++) {
                    i4 += isViewClipped(viewArr[i5], Integer.valueOf(i5)) ? 1 : 0;
                    hashSet.add(viewArr[i5]);
                }
                throw new IllegalStateException("Invalid clipping state. i=" + i3 + " clippedSoFar=" + i2 + " count=" + getChildCount() + " allChildrenCount=" + this.allChildrenCount + " recycleCount=" + this.recycleCount + " realClippedSoFar=" + i4 + " uniqueViewsCount=" + hashSet.size() + " excludedViews=" + (excludedViewsSet != null ? excludedViewsSet.size() : 0), e);
            }
        }
        this.inSubviewClippingLoop = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void updateSubviewClipStatus$default(ReactViewGroup reactViewGroup, Rect rect, int i, int i2, Set set, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateSubviewClipStatus");
        }
        if ((i3 & 8) != 0) {
            set = null;
        }
        reactViewGroup.updateSubviewClipStatus(rect, i, i2, set);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x006a  */
    /* JADX WARN: Code duplicated, block: B:35:0x007b  */
    /* JADX WARN: Code duplicated, block: B:36:0x0089  */
    /* JADX WARN: Multi-variable type inference failed */
    private final void updateSubviewClipStatus(Rect clippingRect, int idx, int clippedSoFar, Set<Integer> excludedViewsSet) {
        View view;
        boolean z;
        boolean z2;
        int i;
        View view2;
        UiThreadUtil.assertOnUiThread();
        View[] viewArr = this.allChildren;
        if (viewArr != null) {
            view2 = viewArr[idx];
        } else {
            view = 0;
        }
        if (view == 0) {
            view = view2;
            throw new IllegalStateException("Required value was null.".toString());
        }
        boolean zIntersects = clippingRect.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        Animation animation = view.getAnimation();
        if (animation == null || animation.hasEnded()) {
            view = view2;
            view = view2;
            z = false;
        } else {
            z = true;
        }
        if (excludedViewsSet == null || !excludedViewsSet.contains(Integer.valueOf(view.getId()))) {
            view = view2;
            view = view2;
            z2 = false;
        } else {
            z2 = true;
        }
        boolean z3 = excludedViewsSet != null;
        if (zIntersects) {
            if (z2) {
                i = idx - clippedSoFar;
                if (i < 0) {
                    throw new IllegalStateException("Check failed.");
                }
                Companion.setViewClipped(view, false);
                addViewInLayout(view, i, defaultLayoutParam, true);
                invalidate();
            } else {
                i = idx - clippedSoFar;
                if (i < 0) {
                    throw new IllegalStateException("Check failed.");
                }
                Companion.setViewClipped(view, false);
                addViewInLayout(view, i, defaultLayoutParam, true);
                invalidate();
            }
            z3 = true;
        } else {
            view = view2;
            if (isViewClipped(view, Integer.valueOf(idx)) || z || view == getFocusedChild() || z2) {
                if ((z2 || zIntersects) && isViewClipped(view, Integer.valueOf(idx))) {
                    i = idx - clippedSoFar;
                    if (i < 0) {
                        throw new IllegalStateException("Check failed.");
                    }
                    Companion.setViewClipped(view, false);
                    addViewInLayout(view, i, defaultLayoutParam, true);
                    invalidate();
                } else if (zIntersects) {
                }
            } else {
                Companion.setViewClipped(view, true);
                removeViewInLayout(view);
            }
            z3 = true;
        }
        if (z3) {
            ReactClippingViewGroup reactClippingViewGroup = view instanceof ReactClippingViewGroup ? (ReactClippingViewGroup) view : null;
            if (reactClippingViewGroup == null || !reactClippingViewGroup.get_removeClippedSubviews()) {
                return;
            }
            ((ReactClippingViewGroup) view).updateClippingRect(excludedViewsSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSubviewClipStatus(View subview) {
        if (!this._removeClippedSubviews || getParent() == null) {
            return;
        }
        Rect rect = this.clippingRect;
        if (rect == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        View[] viewArr = this.allChildren;
        if (viewArr == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        if (rect.intersects(subview.getLeft(), subview.getTop(), subview.getRight(), subview.getBottom()) != (!isViewClipped(subview, null))) {
            this.inSubviewClippingLoop = true;
            int i = this.allChildrenCount;
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                View view = viewArr[i3];
                if (view == subview) {
                    updateSubviewClipStatus$default(this, rect, i3, i2, null, 8, null);
                    break;
                } else {
                    if (isViewClipped(view, Integer.valueOf(i3))) {
                        i2++;
                    }
                }
            }
            this.inSubviewClippingLoop = false;
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (this._removeClippedSubviews) {
            updateClippingRect();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this._removeClippedSubviews) {
            updateClippingRect();
        }
        if (this.focusOnAttach) {
            requestFocusFromJS$ReactAndroid();
            this.focusOnAttach = false;
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        ReadableMap readableMap = this.nativeBackgroundMap;
        if (readableMap != null) {
            applyNativeBackground$ReactAndroid(readableMap);
        }
        ReadableMap readableMap2 = this.nativeForegroundMap;
        if (readableMap2 != null) {
            applyNativeForeground$ReactAndroid(readableMap2);
        }
    }

    public final void applyNativeBackground$ReactAndroid(ReadableMap map) {
        Drawable drawableCreateDrawableFromJSDescription;
        this.nativeBackgroundMap = map;
        ReactViewGroup reactViewGroup = this;
        if (map != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            drawableCreateDrawableFromJSDescription = ReactDrawableHelper.createDrawableFromJSDescription(context, map);
        } else {
            drawableCreateDrawableFromJSDescription = null;
        }
        BackgroundStyleApplicator.setFeedbackUnderlay(reactViewGroup, drawableCreateDrawableFromJSDescription);
    }

    public final void applyNativeForeground$ReactAndroid(ReadableMap map) {
        Drawable drawableCreateDrawableFromJSDescription;
        this.nativeForegroundMap = map;
        if (map != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            drawableCreateDrawableFromJSDescription = ReactDrawableHelper.createDrawableFromJSDescription(context, map);
        } else {
            drawableCreateDrawableFromJSDescription = null;
        }
        setForeground(drawableCreateDrawableFromJSDescription);
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View child) {
        Intrinsics.checkNotNullParameter(child, "child");
        UiThreadUtil.assertOnUiThread();
        checkViewClippingTag(child, false);
        super.onViewAdded(child);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View child) {
        Intrinsics.checkNotNullParameter(child, "child");
        UiThreadUtil.assertOnUiThread();
        checkViewClippingTag(child, true);
        if (child.getParent() != null) {
            trackChildViewTransition(child.getId());
        }
        super.onViewRemoved(child);
    }

    private final void checkViewClippingTag(View child, boolean expectedTag) {
        if (this.inSubviewClippingLoop) {
            Object tag = child.getTag(R.id.view_clipped);
            if (!Intrinsics.areEqual(Boolean.valueOf(expectedTag), tag)) {
                ReactSoftExceptionLogger.logSoftException(ReactSoftExceptionLogger.Categories.RVG_ON_VIEW_REMOVED, new ReactNoCrashSoftException("View clipping tag mismatch: tag=" + tag + " expected=" + expectedTag));
            }
        }
        if (this._removeClippedSubviews) {
            child.setTag(R.id.view_clipped, Boolean.valueOf(expectedTag));
        } else {
            child.setTag(R.id.view_clipped, null);
        }
    }

    private final void resetPointerEvents() {
        setPointerEvents(PointerEvents.AUTO);
    }

    public final View getChildAtWithSubviewClippingEnabled$ReactAndroid(int index) {
        if (index < 0 || index >= this.allChildrenCount) {
            return null;
        }
        View[] viewArr = this.allChildren;
        if (viewArr != null) {
            return viewArr[index];
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final void addViewWithSubviewClippingEnabled$ReactAndroid(final View child, int index) {
        Intrinsics.checkNotNullParameter(child, "child");
        if (!this._removeClippedSubviews) {
            throw new IllegalStateException("Check failed.");
        }
        Companion.setViewClipped(child, true);
        addInArray(child, index);
        Rect rect = this.clippingRect;
        if (rect == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        View[] viewArr = this.allChildren;
        if (viewArr == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        this.inSubviewClippingLoop = true;
        int i = 0;
        for (int i2 = 0; i2 < index; i2++) {
            if (isViewClipped(viewArr[i2], Integer.valueOf(i2))) {
                i++;
            }
        }
        updateSubviewClipStatus$default(this, rect, index, i, null, 8, null);
        this.inSubviewClippingLoop = false;
        child.addOnLayoutChangeListener(this.childrenLayoutChangeListener);
        if (child instanceof ReactClippingProhibitedView) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.views.view.ReactViewGroup$addViewWithSubviewClippingEnabled$1
                @Override // java.lang.Runnable
                public void run() {
                    if (child.isShown()) {
                        return;
                    }
                    ReactSoftExceptionLogger.logSoftException(ReactSoftExceptionLogger.Categories.CLIPPING_PROHIBITED_VIEW, new ReactNoCrashSoftException("Child view has been added to Parent view in which it is clipped and not visible. This is not legal for this particular child view. Child: [" + child.getId() + "] " + child + " Parent: [" + this.getId() + "] " + this));
                }
            });
        }
    }

    public final void removeViewWithSubviewClippingEnabled$ReactAndroid(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        UiThreadUtil.assertOnUiThread();
        if (!this._removeClippedSubviews) {
            throw new IllegalStateException("Check failed.");
        }
        View[] viewArr = this.allChildren;
        if (viewArr == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        view.removeOnLayoutChangeListener(this.childrenLayoutChangeListener);
        int iIndexOfChildInAllChildren = indexOfChildInAllChildren(view);
        if (!isViewClipped(viewArr[iIndexOfChildInAllChildren], Integer.valueOf(iIndexOfChildInAllChildren))) {
            int i = 0;
            for (int i2 = 0; i2 < iIndexOfChildInAllChildren; i2++) {
                if (isViewClipped(viewArr[i2], Integer.valueOf(i2))) {
                    i++;
                }
            }
            removeViewsInLayout(iIndexOfChildInAllChildren - i, 1);
            invalidate();
        }
        removeFromArray(iIndexOfChildInAllChildren);
    }

    public final void removeAllViewsWithSubviewClippingEnabled$ReactAndroid() {
        if (!this._removeClippedSubviews) {
            throw new IllegalStateException("Check failed.");
        }
        View[] viewArr = this.allChildren;
        if (viewArr == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        int i = this.allChildrenCount;
        for (int i2 = 0; i2 < i; i2++) {
            View view = viewArr[i2];
            if (view != null) {
                view.removeOnLayoutChangeListener(this.childrenLayoutChangeListener);
            }
        }
        removeAllViewsInLayout();
        this.allChildrenCount = 0;
    }

    private final boolean isViewClipped(View view, Integer index) {
        if (view == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        Object tag = view.getTag(R.id.view_clipped);
        if (tag != null) {
            return ((Boolean) tag).booleanValue();
        }
        ViewParent parent = view.getParent();
        boolean zIsChildRemovedWhileTransitioning = isChildRemovedWhileTransitioning(view);
        if (index != null) {
            ReactSoftExceptionLogger.logSoftException(ReactSoftExceptionLogger.Categories.RVG_IS_VIEW_CLIPPED, new ReactNoCrashSoftException("View missing clipping tag: index=" + index + " parentNull=" + (parent == null) + " parentThis=" + (parent == this) + " transitioning=" + zIsChildRemovedWhileTransitioning));
        }
        if (parent == null || zIsChildRemovedWhileTransitioning) {
            return true;
        }
        if (parent == this) {
            return false;
        }
        throw new IllegalStateException("Check failed.");
    }

    private final int indexOfChildInAllChildren(View child) {
        int i = this.allChildrenCount;
        View[] viewArr = this.allChildren;
        if (viewArr == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (viewArr[i2] == child) {
                return i2;
            }
        }
        return -1;
    }

    private final void addInArray(View child, int index) {
        View[] viewArr = this.allChildren;
        if (viewArr == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        int i = this.allChildrenCount;
        int length = viewArr.length;
        if (index == i) {
            if (length == i) {
                View[] viewArr2 = new View[length + 12];
                System.arraycopy(viewArr, 0, viewArr2, 0, length);
                this.allChildren = viewArr2;
                viewArr = viewArr2;
            }
            int i2 = this.allChildrenCount;
            this.allChildrenCount = i2 + 1;
            viewArr[i2] = child;
            return;
        }
        if (index < i) {
            if (length == i) {
                View[] viewArr3 = new View[length + 12];
                System.arraycopy(viewArr, 0, viewArr3, 0, index);
                System.arraycopy(viewArr, index, viewArr3, index + 1, i - index);
                this.allChildren = viewArr3;
                viewArr = viewArr3;
            } else {
                System.arraycopy(viewArr, index, viewArr, index + 1, i - index);
            }
            viewArr[index] = child;
            this.allChildrenCount++;
            return;
        }
        throw new IndexOutOfBoundsException("index=" + index + " count=" + i);
    }

    private final void removeFromArray(int index) {
        View[] viewArr = this.allChildren;
        if (viewArr == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        int i = this.allChildrenCount;
        if (index == i - 1) {
            int i2 = i - 1;
            this.allChildrenCount = i2;
            viewArr[i2] = null;
        } else {
            if (index >= 0 && index < i) {
                System.arraycopy(viewArr, index + 1, viewArr, index, (i - index) - 1);
                int i3 = this.allChildrenCount - 1;
                this.allChildrenCount = i3;
                viewArr[i3] = null;
                return;
            }
            throw new IndexOutOfBoundsException();
        }
    }

    @Override // com.facebook.react.uimanager.ReactOverflowView
    public String getOverflow() {
        int i = WhenMappings.$EnumSwitchMapping$0[this._overflow.ordinal()];
        if (i == 1) {
            return ViewProps.HIDDEN;
        }
        if (i == 2) {
            return ViewProps.SCROLL;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return ViewProps.VISIBLE;
    }

    public void setOverflow(String str) {
        this._overflow = Overflow.Companion.fromString$default(Overflow.INSTANCE, str, null, 2, null);
        ImportantForInteractionHelper.setImportantForInteraction(this, getPointerEvents(), this._overflow);
        invalidate();
    }

    @Override // android.view.View
    public Rect getClipBounds() {
        if (ReactNativeFeatureFlags.syncAndroidClipBoundsWithOverflow() && this._overflow != Overflow.VISIBLE) {
            Rect rect = new Rect();
            BackgroundStyleApplicator.INSTANCE.getPaddingBoxRect$ReactAndroid(this, rect);
            return rect;
        }
        return super.getClipBounds();
    }

    @Override // android.view.View
    public boolean getClipBounds(Rect outRect) {
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        if (ReactNativeFeatureFlags.syncAndroidClipBoundsWithOverflow() && this._overflow != Overflow.VISIBLE) {
            BackgroundStyleApplicator.INSTANCE.getPaddingBoxRect$ReactAndroid(this, outRect);
            return true;
        }
        return super.getClipBounds(outRect);
    }

    @Override // com.facebook.react.uimanager.ReactOverflowViewWithInset
    public void setOverflowInset(int left, int top, int right, int bottom) {
        if (BlendModeHelper.needsIsolatedLayer(this) && (get_overflowInset().left != left || get_overflowInset().top != top || get_overflowInset().right != right || get_overflowInset().bottom != bottom)) {
            invalidate();
        }
        get_overflowInset().set(left, top, right, bottom);
    }

    private final void updateBackgroundDrawable(Drawable drawable) {
        super.setBackground(drawable);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (Build.VERSION.SDK_INT >= 29 && BlendModeHelper.needsIsolatedLayer(this)) {
            Rect overflowInset = get_overflowInset();
            canvas.saveLayer(overflowInset.left, overflowInset.top, getWidth() + (-overflowInset.right), getHeight() + (-overflowInset.bottom), null);
            super.draw(canvas);
            canvas.restore();
            return;
        }
        super.draw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this._overflow != Overflow.VISIBLE || getTag(R.id.filter) != null) {
            BackgroundStyleApplicator.clipToPaddingBox(this, canvas);
        }
        super.dispatchDraw(canvas);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0069 A[PHI: r4
      0x0069: PHI (r4v1 android.graphics.BlendMode) = (r4v0 android.graphics.BlendMode), (r4v0 android.graphics.BlendMode), (r4v3 android.graphics.BlendMode) binds: [B:9:0x0022, B:11:0x002b, B:15:0x003e] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        Canvas canvas2;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(child, "child");
        boolean z = child.getElevation() > 0.0f;
        if (z) {
            CanvasUtil.enableZ(canvas, true);
        }
        BlendMode blendModeM11393m = null;
        if (Build.VERSION.SDK_INT < 29 || !BlendModeHelper.needsIsolatedLayer(this)) {
            canvas2 = canvas;
        } else {
            Object tag = child.getTag(R.id.mix_blend_mode);
            blendModeM11393m = ReactRootView$$ExternalSyntheticApiModelOutline0.m11402m(tag) ? ReactRootView$$ExternalSyntheticApiModelOutline0.m11393m(tag) : null;
            if (blendModeM11393m != null) {
                Paint paint = new Paint();
                paint.setBlendMode(blendModeM11393m);
                Rect overflowInset = get_overflowInset();
                canvas2 = canvas;
                canvas2.saveLayer(overflowInset.left, overflowInset.top, getWidth() + (-overflowInset.right), getHeight() + (-overflowInset.bottom), paint);
            } else {
                canvas2 = canvas;
            }
        }
        boolean zDrawChild = super.drawChild(canvas2, child, drawingTime);
        if (blendModeM11393m != null) {
            canvas2.restore();
        }
        if (z) {
            CanvasUtil.enableZ(canvas2, false);
        }
        return zDrawChild;
    }

    public final void setOpacityIfPossible(float opacity) {
        this.backfaceOpacity = opacity;
        setBackfaceVisibilityDependantOpacity();
    }

    public final void setBackfaceVisibility(String backfaceVisibility) {
        Intrinsics.checkNotNullParameter(backfaceVisibility, "backfaceVisibility");
        this.backfaceVisible = Intrinsics.areEqual(ViewProps.VISIBLE, backfaceVisibility);
        setBackfaceVisibilityDependantOpacity();
    }

    public final void setBackfaceVisibilityDependantOpacity() {
        if (this.backfaceVisible) {
            setAlpha(this.backfaceOpacity);
            return;
        }
        float rotationX = getRotationX();
        float rotationY = getRotationY();
        if (rotationX >= -90.0f && rotationX < 90.0f && rotationY >= -90.0f && rotationY < 90.0f) {
            setAlpha(this.backfaceOpacity);
        } else {
            setAlpha(0.0f);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addChildrenForAccessibility(ArrayList<View> outChildren) {
        Intrinsics.checkNotNullParameter(outChildren, "outChildren");
        Object tag = getTag(R.id.accessibility_order_parent);
        List<String> list = tag instanceof ReactViewGroup ? ((ReactViewGroup) tag).axOrderList : null;
        List<String> list2 = this.axOrderList;
        int i = 0;
        if (list2 == null) {
            if (list != null) {
                if (!isFocusable()) {
                    safeAddChildrenForAccessibility(outChildren);
                    return;
                }
                if (isFocusable() && (getContentDescription() == null || Intrinsics.areEqual(getContentDescription(), ""))) {
                    safeAddChildrenForAccessibility(outChildren);
                    int childCount = getChildCount();
                    while (i < childCount) {
                        ReactAxOrderHelper reactAxOrderHelper = ReactAxOrderHelper.INSTANCE;
                        View childAt = getChildAt(i);
                        Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
                        reactAxOrderHelper.disableFocusForSubtree(childAt, list);
                        i++;
                    }
                    return;
                }
                if (!isFocusable() || getContentDescription() == null) {
                    return;
                }
                Intrinsics.areEqual(getContentDescription(), "");
                return;
            }
            safeAddChildrenForAccessibility(outChildren);
            return;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        if (this.accessibilityStateChangeListener == null && accessibilityManager != null) {
            AccessibilityManager.AccessibilityStateChangeListener accessibilityStateChangeListener = new AccessibilityManager.AccessibilityStateChangeListener() { // from class: com.facebook.react.views.view.ReactViewGroup$$ExternalSyntheticLambda1
                @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
                public final void onAccessibilityStateChanged(boolean z) {
                    ReactViewGroup.addChildrenForAccessibility$lambda$3(this.f$0, z);
                }
            };
            accessibilityManager.addAccessibilityStateChangeListener(accessibilityStateChangeListener);
            this.accessibilityStateChangeListener = accessibilityStateChangeListener;
        }
        int size = list2.size();
        View[] viewArr = new View[size];
        int childCount2 = getChildCount();
        for (int i2 = 0; i2 < childCount2; i2++) {
            ReactAxOrderHelper reactAxOrderHelper2 = ReactAxOrderHelper.INSTANCE;
            View childAt2 = getChildAt(i2);
            Intrinsics.checkNotNullExpressionValue(childAt2, "getChildAt(...)");
            reactAxOrderHelper2.buildAxOrderList(childAt2, this, list2, viewArr);
        }
        while (i < size) {
            View view = viewArr[i];
            if (view != null) {
                if (view.isFocusable()) {
                    outChildren.add(view);
                } else {
                    view.addChildrenForAccessibility(outChildren);
                }
            }
            i++;
        }
    }

    static final void addChildrenForAccessibility$lambda$3(ReactViewGroup reactViewGroup, boolean z) {
        if (z) {
            return;
        }
        int childCount = reactViewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = reactViewGroup.getChildAt(i);
            Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
            ReactAxOrderHelper.restoreFocusability(childAt);
        }
    }

    private final void safeAddChildrenForAccessibility(ArrayList<View> outChildren) {
        try {
            super.addChildrenForAccessibility(outChildren);
        } catch (IllegalArgumentException e) {
            String message = e.getMessage();
            if (message != null && StringsKt.contains$default((CharSequence) message, (CharSequence) "descendant of this view", false, 2, (Object) null)) {
                ReactSoftExceptionLogger.logSoftException(ReactSoftExceptionLogger.Categories.RVG_ADD_CHILDREN_FOR_ACCESSIBILITY, e);
                return;
            }
            throw e;
        }
    }

    public final void cleanUpAxOrderListener() {
        AccessibilityManager.AccessibilityStateChangeListener accessibilityStateChangeListener;
        Object systemService = getContext().getSystemService("accessibility");
        AccessibilityManager accessibilityManager = systemService instanceof AccessibilityManager ? (AccessibilityManager) systemService : null;
        if (accessibilityManager != null && (accessibilityStateChangeListener = this.accessibilityStateChangeListener) != null) {
            accessibilityManager.removeAccessibilityStateChangeListener(accessibilityStateChangeListener);
        }
        this.accessibilityStateChangeListener = null;
    }

    /* JADX INFO: compiled from: ReactViewGroup.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/facebook/react/views/view/ReactViewGroup$Companion;", "", "<init>", "()V", "ARRAY_CAPACITY_INCREMENT", "", "defaultLayoutParam", "Landroid/view/ViewGroup$LayoutParams;", "setViewClipped", "", "view", "Landroid/view/View;", "clipped", "", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void setViewClipped(View view, boolean clipped) {
            view.setTag(R.id.view_clipped, Boolean.valueOf(clipped));
        }
    }
}
