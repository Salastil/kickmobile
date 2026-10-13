package com.facebook.react.views.scroll;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
import androidx.core.view.ViewCompat;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.common.logging.FLog;
import com.facebook.react.R;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.uimanager.BackgroundStyleApplicator;
import com.facebook.react.uimanager.HasChildPressedStateDelay;
import com.facebook.react.uimanager.LengthPercentage;
import com.facebook.react.uimanager.LengthPercentageType;
import com.facebook.react.uimanager.MeasureSpecAssertions;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactClippingViewGroup;
import com.facebook.react.uimanager.ReactClippingViewGroupHelper;
import com.facebook.react.uimanager.ReactOverflowViewWithInset;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.events.NativeGestureUtil;
import com.facebook.react.uimanager.style.BorderRadiusProp;
import com.facebook.react.uimanager.style.BorderStyle;
import com.facebook.react.uimanager.style.LogicalEdge;
import com.facebook.react.uimanager.style.Overflow;
import com.facebook.react.views.view.ImportantForInteractionHelper;
import com.facebook.systrace.Systrace;
import com.mux.stats.sdk.core.model.ViewDeviceOrientationData;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReactScrollView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000ª\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b=\b\u0016\u0018\u0000 \u009d\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\f2\u00020\r:\u0002\u009d\u0002B\u001d\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u007f\u001a\u00030\u0080\u0001H\u0002J\u0010\u0010\u0081\u0001\u001a\u00030\u0080\u0001H\u0000¢\u0006\u0003\b\u0082\u0001J\n\u0010\u0083\u0001\u001a\u00030\u0080\u0001H\u0002J\u0014\u0010\u0084\u0001\u001a\u00030\u0080\u00012\b\u0010\u0085\u0001\u001a\u00030\u0086\u0001H\u0016J\u000b\u0010\u0087\u0001\u001a\u0004\u0018\u00010WH\u0014J\u0012\u0010\u0088\u0001\u001a\u00030\u0080\u00012\u0006\u0010n\u001a\u00020\u0015H\u0016J\u0012\u0010\u0089\u0001\u001a\u00030\u0080\u00012\u0006\u0010i\u001a\u00020\u0015H\u0016J\u0014\u0010\u008a\u0001\u001a\u00030\u0080\u00012\b\u0010j\u001a\u0004\u0018\u00010HH\u0016J\u0012\u0010\u008b\u0001\u001a\u00030\u0080\u00012\u0006\u0010f\u001a\u00020\u0015H\u0016J\u0012\u0010\u008c\u0001\u001a\u00030\u0080\u00012\u0006\u0010~\u001a\u00020\u0015H\u0016J\u0014\u0010\u008d\u0001\u001a\u00030\u0080\u00012\b\u0010\u008e\u0001\u001a\u00030\u008f\u0001H\u0016J\n\u0010\u0090\u0001\u001a\u00030\u0080\u0001H\u0016J\u0012\u0010\u0091\u0001\u001a\u00030\u0080\u00012\u0006\u0010o\u001a\u00020!H\u0016J\u001a\u0010\u0092\u0001\u001a\u00030\u0080\u00012\u000e\u0010p\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010qH\u0016J\u0012\u0010\u0093\u0001\u001a\u00030\u0080\u00012\u0006\u0010r\u001a\u00020\u0015H\u0016J\u0012\u0010\u0094\u0001\u001a\u00030\u0080\u00012\u0006\u0010s\u001a\u00020\u0015H\u0016J\u0012\u0010\u0095\u0001\u001a\u00030\u0080\u00012\u0006\u0010t\u001a\u00020!H\u0016J\n\u0010\u0096\u0001\u001a\u00030\u0080\u0001H\u0016J\n\u0010\u0097\u0001\u001a\u00030\u008f\u0001H\u0014J\n\u0010\u0098\u0001\u001a\u00030\u008f\u0001H\u0014J\u0014\u0010\u0099\u0001\u001a\u00030\u0080\u00012\b\u0010G\u001a\u0004\u0018\u00010HH\u0016J\u001c\u0010\u009a\u0001\u001a\u00030\u0080\u00012\n\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009c\u0001H\u0010¢\u0006\u0003\b\u009d\u0001J.\u0010\u009e\u0001\u001a\u00030\u0080\u00012\u0007\u0010\u009f\u0001\u001a\u00020!2\u0007\u0010 \u0001\u001a\u00020!2\u0007\u0010¡\u0001\u001a\u00020!2\u0007\u0010¢\u0001\u001a\u00020!H\u0016J\u001c\u0010£\u0001\u001a\u00030\u0080\u00012\u0007\u0010¤\u0001\u001a\u00020!2\u0007\u0010¥\u0001\u001a\u00020!H\u0014J7\u0010¦\u0001\u001a\u00030\u0080\u00012\u0007\u0010§\u0001\u001a\u00020\u00152\u0007\u0010¨\u0001\u001a\u00020!2\u0007\u0010©\u0001\u001a\u00020!2\u0007\u0010ª\u0001\u001a\u00020!2\u0007\u0010«\u0001\u001a\u00020!H\u0014J.\u0010¬\u0001\u001a\u00030\u0080\u00012\u0007\u0010\u00ad\u0001\u001a\u00020!2\u0007\u0010®\u0001\u001a\u00020!2\u0007\u0010¯\u0001\u001a\u00020!2\u0007\u0010°\u0001\u001a\u00020!H\u0014J\n\u0010±\u0001\u001a\u00030\u0080\u0001H\u0014J\n\u0010²\u0001\u001a\u00030\u0080\u0001H\u0014J\u001d\u0010³\u0001\u001a\u0004\u0018\u00010v2\u0007\u0010´\u0001\u001a\u00020v2\u0007\u0010µ\u0001\u001a\u00020!H\u0016J\u001e\u0010¶\u0001\u001a\u00030\u0080\u00012\u0007\u0010·\u0001\u001a\u00020v2\t\u0010´\u0001\u001a\u0004\u0018\u00010vH\u0016J\u001e\u0010¸\u0001\u001a\u00030\u0080\u00012\u0007\u0010·\u0001\u001a\u00020v2\t\u0010´\u0001\u001a\u0004\u0018\u00010vH\u0014J$\u0010¹\u0001\u001a\u00020\u00152\u0007\u0010·\u0001\u001a\u00020v2\u0007\u0010º\u0001\u001a\u00020D2\u0007\u0010»\u0001\u001a\u00020\u0015H\u0016J\u0012\u0010¼\u0001\u001a\u00020!2\u0007\u0010½\u0001\u001a\u00020vH\u0002J\u0012\u0010¾\u0001\u001a\u00020\u00152\u0007\u0010¿\u0001\u001a\u00020vH\u0016J\u0013\u0010À\u0001\u001a\u00030\u0080\u00012\u0007\u0010·\u0001\u001a\u00020vH\u0002J.\u0010Á\u0001\u001a\u00030\u0080\u00012\u0007\u0010Â\u0001\u001a\u00020!2\u0007\u0010Ã\u0001\u001a\u00020!2\u0007\u0010Ä\u0001\u001a\u00020!2\u0007\u0010Å\u0001\u001a\u00020!H\u0014J\t\u0010Æ\u0001\u001a\u00020\u0015H\u0016J\u0013\u0010Ç\u0001\u001a\u00020\u00152\b\u0010È\u0001\u001a\u00030É\u0001H\u0016J\u0014\u0010Ê\u0001\u001a\u00030\u0080\u00012\b\u0010È\u0001\u001a\u00030É\u0001H\u0014J\u0013\u0010Ë\u0001\u001a\u00020\u00152\b\u0010È\u0001\u001a\u00030É\u0001H\u0016J\u0013\u0010Ì\u0001\u001a\u00020\u00152\b\u0010È\u0001\u001a\u00030É\u0001H\u0016J\u0013\u0010Í\u0001\u001a\u00020\u00152\b\u0010Î\u0001\u001a\u00030Ï\u0001H\u0016J\n\u0010Ð\u0001\u001a\u00030\u0080\u0001H\u0016J\u001c\u0010Ð\u0001\u001a\u00030\u0080\u00012\u0010\u0010Ñ\u0001\u001a\u000b\u0012\u0004\u0012\u00020!\u0018\u00010Ò\u0001H\u0016J\u0013\u0010Ó\u0001\u001a\u00030\u0080\u00012\u0007\u0010Ô\u0001\u001a\u00020DH\u0016J'\u0010Õ\u0001\u001a\u00020\u00152\u0007\u0010·\u0001\u001a\u00020v2\u0007\u0010ª\u0001\u001a\u00020D2\n\u0010Ö\u0001\u001a\u0005\u0018\u00010×\u0001H\u0016J\u0013\u0010Ø\u0001\u001a\u00030\u0080\u00012\u0007\u0010Ù\u0001\u001a\u00020!H\u0016J\u0012\u0010Ú\u0001\u001a\u00020!2\u0007\u0010Ù\u0001\u001a\u00020!H\u0002J\n\u0010Û\u0001\u001a\u00030\u0080\u0001H\u0002J\n\u0010Ü\u0001\u001a\u00030\u0080\u0001H\u0002J\t\u0010Ý\u0001\u001a\u00020\u0015H\u0002J\t\u0010Þ\u0001\u001a\u00020!H\u0002J\u0014\u0010ß\u0001\u001a\u00030\u0080\u00012\b\u0010à\u0001\u001a\u00030á\u0001H\u0016J\u0014\u0010â\u0001\u001a\u00030\u0080\u00012\b\u0010à\u0001\u001a\u00030á\u0001H\u0016J\u001c\u0010ã\u0001\u001a\u00030\u0080\u00012\u0007\u0010ä\u0001\u001a\u00020!2\u0007\u0010Ù\u0001\u001a\u00020!H\u0002J\n\u0010å\u0001\u001a\u00030\u0080\u0001H\u0002J\u0012\u0010æ\u0001\u001a\u00020!2\u0007\u0010Ù\u0001\u001a\u00020!H\u0002J\u000b\u0010ç\u0001\u001a\u0004\u0018\u00010vH\u0002J\u0013\u0010è\u0001\u001a\u00030\u0080\u00012\u0007\u0010é\u0001\u001a\u00020!H\u0002J\u0013\u0010ê\u0001\u001a\u00030\u0080\u00012\u0007\u0010Ù\u0001\u001a\u00020!H\u0002J,\u0010ë\u0001\u001a\u00020!2\u0006\u0010t\u001a\u00020!2\u0007\u0010ì\u0001\u001a\u00020!2\u0007\u0010í\u0001\u001a\u00020!2\u0007\u0010î\u0001\u001a\u00020!H\u0002J\t\u0010ï\u0001\u001a\u00020!H\u0002J\u0013\u0010ð\u0001\u001a\u00030\u0080\u00012\u0007\u0010ñ\u0001\u001a\u00020!H\u0016J.\u0010ò\u0001\u001a\u00030\u0080\u00012\u0007\u0010ó\u0001\u001a\u00020!2\u0007\u0010ô\u0001\u001a\u00020!2\u0007\u0010õ\u0001\u001a\u00020\u00152\u0007\u0010ö\u0001\u001a\u00020\u0015H\u0014J\u001c\u0010÷\u0001\u001a\u00030\u0080\u00012\u0007\u0010ø\u0001\u001a\u00020v2\u0007\u0010·\u0001\u001a\u00020vH\u0016J\u001c\u0010ù\u0001\u001a\u00030\u0080\u00012\u0007\u0010ø\u0001\u001a\u00020v2\u0007\u0010·\u0001\u001a\u00020vH\u0016J\u0014\u0010ú\u0001\u001a\u00030\u0080\u00012\b\u00102\u001a\u0004\u0018\u00010xH\u0016J\u001c\u0010û\u0001\u001a\u00030\u0080\u00012\u0007\u0010Â\u0001\u001a\u00020!2\u0007\u0010Ã\u0001\u001a\u00020!H\u0016J\u001c\u0010ü\u0001\u001a\u00030\u0080\u00012\u0007\u0010Â\u0001\u001a\u00020!2\u0007\u0010Ã\u0001\u001a\u00020!H\u0016J\u0013\u0010ý\u0001\u001a\u00030\u0080\u00012\u0007\u0010ô\u0001\u001a\u00020!H\u0002J\u001c\u0010þ\u0001\u001a\u00030\u0080\u00012\u0007\u0010Â\u0001\u001a\u00020!2\u0007\u0010Ã\u0001\u001a\u00020!H\u0016J\t\u0010ÿ\u0001\u001a\u00020\u0015H\u0002J\u001c\u0010\u0080\u0002\u001a\u00030\u0080\u00012\u0007\u0010Â\u0001\u001a\u00020!2\u0007\u0010Ã\u0001\u001a\u00020!H\u0002J[\u0010\u0081\u0002\u001a\u00030\u0080\u00012\u0007\u0010\u0082\u0002\u001a\u00020v2\u0007\u0010\u009f\u0001\u001a\u00020!2\u0007\u0010 \u0001\u001a\u00020!2\u0007\u0010¡\u0001\u001a\u00020!2\u0007\u0010¢\u0001\u001a\u00020!2\u0007\u0010\u0083\u0002\u001a\u00020!2\u0007\u0010\u0084\u0002\u001a\u00020!2\u0007\u0010\u0085\u0002\u001a\u00020!2\u0007\u0010\u0086\u0002\u001a\u00020!H\u0016J\u0013\u0010\u0087\u0002\u001a\u00030\u0080\u00012\u0007\u0010ñ\u0001\u001a\u00020!H\u0016J\u001d\u0010\u0088\u0002\u001a\u00030\u0080\u00012\u0007\u0010\u0089\u0002\u001a\u00020!2\b\u0010\u008a\u0002\u001a\u00030\u008f\u0001H\u0016J$\u0010\u008b\u0002\u001a\u00030\u0080\u00012\u0007\u0010\u0089\u0002\u001a\u00020!2\t\u0010ñ\u0001\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0003\u0010\u008c\u0002J\u0014\u0010\u008d\u0002\u001a\u00030\u0080\u00012\b\u0010\u008e\u0002\u001a\u00030\u008f\u0001H\u0016J\u001d\u0010\u008d\u0002\u001a\u00030\u0080\u00012\b\u0010\u008e\u0002\u001a\u00030\u008f\u00012\u0007\u0010\u0089\u0002\u001a\u00020!H\u0016J\u0015\u0010\u008f\u0002\u001a\u00030\u0080\u00012\t\u0010\u0090\u0002\u001a\u0004\u0018\u00010HH\u0016J\u001c\u0010\u0091\u0002\u001a\u00030\u0080\u00012\u0007\u0010\u0092\u0002\u001a\u00020!2\u0007\u0010\u0093\u0002\u001a\u00020!H\u0016J%\u0010\u0091\u0002\u001a\u00030\u0080\u00012\u0007\u0010\u0092\u0002\u001a\u00020!2\u0007\u0010\u0093\u0002\u001a\u00020!2\u0007\u0010\u0094\u0002\u001a\u00020\u0015H\u0016J\u001c\u0010\u0095\u0002\u001a\u00030\u0080\u00012\u0007\u0010\u0096\u0002\u001a\u00020!2\u0007\u0010\u0097\u0002\u001a\u00020!H\u0002J\u001c\u0010\u0098\u0002\u001a\u00030\u0080\u00012\u0007\u0010\u0099\u0002\u001a\u00020!2\u0007\u0010\u009a\u0002\u001a\u00020!H\u0016J\t\u0010\u009b\u0002\u001a\u00020\\H\u0016J\u0012\u0010\u009c\u0002\u001a\u00020!2\u0007\u0010é\u0001\u001a\u00020!H\u0016R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020'X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010,\u001a\u0004\u0018\u00010\u0015X\u0096\u000e¢\u0006\u0010\n\u0002\u00101\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u00104\u001a\u0002032\u0006\u00102\u001a\u000203@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R$\u00109\u001a\u00020!2\u0006\u00102\u001a\u00020!@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010#\"\u0004\b;\u0010%R$\u0010<\u001a\u00020!2\u0006\u00102\u001a\u00020!@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010#\"\u0004\b>\u0010%R\u0014\u0010?\u001a\u00020@8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bA\u0010BR\u0014\u0010C\u001a\u00020D8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bE\u0010FR\u0016\u0010G\u001a\u0004\u0018\u00010H8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bI\u0010JR$\u0010K\u001a\u00020\u00152\u0006\u00102\u001a\u00020\u00158V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bL\u0010\u0017\"\u0004\bM\u0010\u0019R$\u0010O\u001a\u00020N2\u0006\u00102\u001a\u00020N8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u000e\u0010T\u001a\u00020UX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010V\u001a\u0004\u0018\u00010WX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020YX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020DX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\\X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020DX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010^\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020NX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010b\u001a\u0004\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010g\u001a\u0004\u0018\u00010hX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010j\u001a\u0004\u0018\u00010HX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010k\u001a\u0004\u0018\u00010lX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010m\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010o\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010p\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010qX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010t\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010u\u001a\u0004\u0018\u00010vX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010w\u001a\u0004\u0018\u00010xX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010y\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010z\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010{\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010|X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010}\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010~\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u009e\u0002"}, d2 = {"Lcom/facebook/react/views/scroll/ReactScrollView;", "Landroid/widget/ScrollView;", "Lcom/facebook/react/uimanager/ReactClippingViewGroup;", "Landroid/view/ViewGroup$OnHierarchyChangeListener;", "Landroid/view/View$OnLayoutChangeListener;", "Lcom/facebook/react/views/scroll/ReactAccessibleScrollView;", "Lcom/facebook/react/uimanager/ReactOverflowViewWithInset;", "Lcom/facebook/react/views/scroll/ReactScrollViewHelper$HasScrollState;", "Lcom/facebook/react/views/scroll/ReactScrollViewHelper$HasStateWrapper;", "Lcom/facebook/react/views/scroll/ReactScrollViewHelper$HasFlingAnimator;", "Lcom/facebook/react/views/scroll/ReactScrollViewHelper$HasScrollEventThrottle;", "Lcom/facebook/react/views/scroll/ReactScrollViewHelper$HasSmoothScroll;", "Lcom/facebook/react/views/scroll/VirtualViewContainer;", "Lcom/facebook/react/uimanager/HasChildPressedStateDelay;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "fpsListener", "Lcom/facebook/react/views/scroll/FpsListener;", "<init>", "(Landroid/content/Context;Lcom/facebook/react/views/scroll/FpsListener;)V", "scrollEnabled", "", "getScrollEnabled", "()Z", "setScrollEnabled", "(Z)V", "stateWrapper", "Lcom/facebook/react/uimanager/StateWrapper;", "getStateWrapper", "()Lcom/facebook/react/uimanager/StateWrapper;", "setStateWrapper", "(Lcom/facebook/react/uimanager/StateWrapper;)V", "scrollEventThrottle", "", "getScrollEventThrottle", "()I", "setScrollEventThrottle", "(I)V", "lastScrollDispatchTime", "", "getLastScrollDispatchTime", "()J", "setLastScrollDispatchTime", "(J)V", "hasChildPressedStateDelay", "getHasChildPressedStateDelay", "()Ljava/lang/Boolean;", "setHasChildPressedStateDelay", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "value", "Lcom/facebook/react/uimanager/PointerEvents;", ViewProps.POINTER_EVENTS, "getPointerEvents", "()Lcom/facebook/react/uimanager/PointerEvents;", "setPointerEvents", "(Lcom/facebook/react/uimanager/PointerEvents;)V", "fadingEdgeLengthStart", "getFadingEdgeLengthStart", "setFadingEdgeLengthStart", "fadingEdgeLengthEnd", "getFadingEdgeLengthEnd", "setFadingEdgeLengthEnd", "virtualViewContainerState", "Lcom/facebook/react/views/scroll/VirtualViewContainerState;", "getVirtualViewContainerState", "()Lcom/facebook/react/views/scroll/VirtualViewContainerState;", "overflowInset", "Landroid/graphics/Rect;", "getOverflowInset", "()Landroid/graphics/Rect;", ViewProps.OVERFLOW, "", "getOverflow", "()Ljava/lang/String;", ReactClippingViewGroupHelper.PROP_REMOVE_CLIPPED_SUBVIEWS, "getRemoveClippedSubviews", "setRemoveClippedSubviews", "Lcom/facebook/react/views/scroll/ReactScrollViewHelper$ReactScrollViewScrollState;", "reactScrollViewScrollState", "getReactScrollViewScrollState", "()Lcom/facebook/react/views/scroll/ReactScrollViewHelper$ReactScrollViewScrollState;", "setReactScrollViewScrollState", "(Lcom/facebook/react/views/scroll/ReactScrollViewHelper$ReactScrollViewScrollState;)V", "onScrollDispatchHelper", "Lcom/facebook/react/views/scroll/OnScrollDispatchHelper;", "scroller", "Landroid/widget/OverScroller;", "velocityHelper", "Lcom/facebook/react/views/scroll/VelocityHelper;", "tempRect", "defaultFlingAnimator", "Landroid/animation/ValueAnimator;", "_overflowInset", "_virtualViewContainerState", "_removeClippedSubviews", "_reactScrollViewScrollState", "activelyScrolling", "clippingRect", "_overflow", "Lcom/facebook/react/uimanager/style/Overflow;", "dragging", "pagingEnabled", "postTouchRunnable", "Ljava/lang/Runnable;", "sendMomentumEvents", "scrollPerfTag", "endBackground", "Landroid/graphics/drawable/Drawable;", "endFillColor", "disableIntervalMomentum", "snapInterval", "snapOffsets", "", "snapToStart", "snapToEnd", "snapToAlignment", "contentView", "Landroid/view/View;", "currentContentOffset", "Lcom/facebook/react/bridge/ReadableMap;", "pendingContentOffsetX", "pendingContentOffsetY", "maintainVisibleContentPositionHelper", "Lcom/facebook/react/views/scroll/MaintainVisibleScrollPositionHelper;", "emittedOverScrollSinceScrollBegin", "scrollsChildToFocus", "initView", "", "recycleView", "recycleView$ReactAndroid", "updateView", "onInitializeAccessibilityNodeInfo", "info", "Landroid/view/accessibility/AccessibilityNodeInfo;", "getOverScrollerFromParent", "setDisableIntervalMomentum", "setSendMomentumEvents", "setScrollPerfTag", "setPagingEnabled", "setScrollsChildToFocus", "setDecelerationRate", "decelerationRate", "", "abortAnimation", "setSnapInterval", "setSnapOffsets", "setSnapToStart", "setSnapToEnd", "setSnapToAlignment", "flashScrollIndicators", "getTopFadingEdgeStrength", "getBottomFadingEdgeStrength", "setOverflow", "setMaintainVisibleContentPosition", "config", "Lcom/facebook/react/views/scroll/MaintainVisibleScrollPositionHelper$Config;", "setMaintainVisibleContentPosition$ReactAndroid", "setOverflowInset", "left", ViewProps.TOP, "right", ViewProps.BOTTOM, "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onLayout", "changed", "l", "t", "r", "b", "onSizeChanged", "w", "h", "oldw", "oldh", "onAttachedToWindow", "onDetachedFromWindow", "focusSearch", "focused", "direction", "requestChildFocus", "child", "requestChildFocusWithoutScroll", "requestChildRectangleOnScreen", "rectangle", "immediate", "getScrollDelta", "descendent", "isPartiallyScrolledInView", "view", "scrollToChild", "onScrollChanged", ViewDeviceOrientationData.DEVICE_ORIENTATION_X, ViewDeviceOrientationData.DEVICE_ORIENTATION_Y, "oldX", "oldY", "shouldDelayChildPressedState", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "handleInterceptedTouchEvent", "onTouchEvent", "dispatchGenericMotionEvent", "executeKeyEvent", "event", "Landroid/view/KeyEvent;", "updateClippingRect", "excludedViews", "", "getClippingRect", "outClippingRect", "getChildVisibleRect", "offset", "Landroid/graphics/Point;", "fling", "velocityY", "correctFlingVelocityY", "enableFpsListener", "disableFpsListener", "isScrollPerfLoggingEnabled", "getMaxScrollY", "draw", "canvas", "Landroid/graphics/Canvas;", "onDraw", "handlePostTouchScrolling", "velocityX", "cancelPostTouchScrolling", "predictFinalScrollPosition", "getContentView", "smoothScrollAndSnap", "velocity", "flingAndSnap", "getItemStartOffset", "itemStartPosition", "itemHeight", "viewPortHeight", "getSnapInterval", "setEndFillColor", "color", "onOverScrolled", "scrollX", "scrollY", "clampedX", "clampedY", "onChildViewAdded", "parent", "onChildViewRemoved", "setContentOffset", "reactSmoothScrollTo", "scrollTo", "recreateFlingAnimation", "scrollToPreservingMomentum", "isContentReady", "setPendingContentOffsets", "onLayoutChange", "v", "oldLeft", "oldTop", "oldRight", "oldBottom", "setBackgroundColor", "setBorderWidth", ViewProps.POSITION, ViewProps.WIDTH, "setBorderColor", "(ILjava/lang/Integer;)V", "setBorderRadius", ViewProps.BORDER_RADIUS, "setBorderStyle", "style", "setScrollAwayPaddingEnabledUnstable", "topPadding", "bottomPadding", "updateState", "updateScrollAwayState", "scrollAwayPaddingTop", "scrollAwayPaddingBottom", "startFlingAnimator", ViewProps.START, ViewProps.END, "getFlingAnimator", "getFlingExtrapolatedDistance", "Companion", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class ReactScrollView extends ScrollView implements ReactClippingViewGroup, ViewGroup.OnHierarchyChangeListener, View.OnLayoutChangeListener, ReactAccessibleScrollView, ReactOverflowViewWithInset, ReactScrollViewHelper.HasScrollState, ReactScrollViewHelper.HasStateWrapper, ReactScrollViewHelper.HasFlingAnimator, ReactScrollViewHelper.HasScrollEventThrottle, ReactScrollViewHelper.HasSmoothScroll, VirtualViewContainer, HasChildPressedStateDelay {
    private static final Companion Companion = new Companion(null);
    private static final int UNSET_CONTENT_OFFSET = -1;
    private static Field scrollerField;
    private static boolean triedToGetScrollerField;
    private Overflow _overflow;
    private Rect _overflowInset;
    private ReactScrollViewHelper.ReactScrollViewScrollState _reactScrollViewScrollState;
    private boolean _removeClippedSubviews;
    private VirtualViewContainerState _virtualViewContainerState;
    private boolean activelyScrolling;
    private Rect clippingRect;
    private View contentView;
    private ReadableMap currentContentOffset;
    private final ValueAnimator defaultFlingAnimator;
    private boolean disableIntervalMomentum;
    private boolean dragging;
    private boolean emittedOverScrollSinceScrollBegin;
    private Drawable endBackground;
    private int endFillColor;
    private int fadingEdgeLengthEnd;
    private int fadingEdgeLengthStart;
    private final FpsListener fpsListener;
    private Boolean hasChildPressedStateDelay;
    private long lastScrollDispatchTime;
    private MaintainVisibleScrollPositionHelper<ReactScrollView> maintainVisibleContentPositionHelper;
    private final OnScrollDispatchHelper onScrollDispatchHelper;
    private boolean pagingEnabled;
    private int pendingContentOffsetX;
    private int pendingContentOffsetY;
    private PointerEvents pointerEvents;
    private Runnable postTouchRunnable;
    private boolean scrollEnabled;
    private int scrollEventThrottle;
    private String scrollPerfTag;
    private final OverScroller scroller;
    private boolean scrollsChildToFocus;
    private boolean sendMomentumEvents;
    private int snapInterval;
    private List<Integer> snapOffsets;
    private int snapToAlignment;
    private boolean snapToEnd;
    private boolean snapToStart;
    private StateWrapper stateWrapper;
    private final Rect tempRect;
    private final VelocityHelper velocityHelper;

    /* JADX INFO: compiled from: ReactScrollView.kt */
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ReactScrollView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void updateView() {
    }

    public /* synthetic */ ReactScrollView(Context context, FpsListener fpsListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : fpsListener);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactScrollView(Context context, FpsListener fpsListener) {
        Overflow overflow;
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.fpsListener = fpsListener;
        this.scrollEnabled = true;
        this.pointerEvents = PointerEvents.AUTO;
        this.onScrollDispatchHelper = new OnScrollDispatchHelper();
        this.scroller = getOverScrollerFromParent();
        this.velocityHelper = new VelocityHelper();
        this.tempRect = new Rect();
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this, "scrollY", 0, 0);
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfInt, "ofInt(...)");
        this.defaultFlingAnimator = objectAnimatorOfInt;
        this._overflowInset = new Rect();
        this._reactScrollViewScrollState = new ReactScrollViewHelper.ReactScrollViewScrollState(null, 0, 0, null, false, false, 0.0f, false, 255, null);
        if (ReactNativeFeatureFlags.enablePropsUpdateReconciliationAndroid()) {
            overflow = Overflow.VISIBLE;
        } else {
            overflow = Overflow.SCROLL;
        }
        this._overflow = overflow;
        this.snapToStart = true;
        this.snapToEnd = true;
        this.pendingContentOffsetX = -1;
        this.pendingContentOffsetY = -1;
        this.scrollsChildToFocus = true;
        setOnHierarchyChangeListener(this);
        setScrollBarStyle(GroupFlagsKt.HasAuxSlotFlag);
        setClipChildren(false);
        ViewCompat.setAccessibilityDelegate(this, new ReactScrollViewAccessibilityDelegate());
        initView();
    }

    /* JADX INFO: compiled from: ReactScrollView.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/facebook/react/views/scroll/ReactScrollView$Companion;", "", "<init>", "()V", "scrollerField", "Ljava/lang/reflect/Field;", "triedToGetScrollerField", "", "UNSET_CONTENT_OFFSET", "", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // com.facebook.react.views.scroll.ReactAccessibleScrollView
    public boolean getScrollEnabled() {
        return this.scrollEnabled;
    }

    public void setScrollEnabled(boolean z) {
        this.scrollEnabled = z;
    }

    @Override // com.facebook.react.views.scroll.ReactScrollViewHelper.HasStateWrapper
    public StateWrapper getStateWrapper() {
        return this.stateWrapper;
    }

    public void setStateWrapper(StateWrapper stateWrapper) {
        this.stateWrapper = stateWrapper;
    }

    @Override // com.facebook.react.views.scroll.ReactScrollViewHelper.HasScrollEventThrottle
    public int getScrollEventThrottle() {
        return this.scrollEventThrottle;
    }

    @Override // com.facebook.react.views.scroll.ReactScrollViewHelper.HasScrollEventThrottle
    public void setScrollEventThrottle(int i) {
        this.scrollEventThrottle = i;
    }

    @Override // com.facebook.react.views.scroll.ReactScrollViewHelper.HasScrollEventThrottle
    public long getLastScrollDispatchTime() {
        return this.lastScrollDispatchTime;
    }

    @Override // com.facebook.react.views.scroll.ReactScrollViewHelper.HasScrollEventThrottle
    public void setLastScrollDispatchTime(long j) {
        this.lastScrollDispatchTime = j;
    }

    @Override // com.facebook.react.uimanager.HasChildPressedStateDelay
    public Boolean getHasChildPressedStateDelay() {
        return this.hasChildPressedStateDelay;
    }

    @Override // com.facebook.react.uimanager.HasChildPressedStateDelay
    public void setHasChildPressedStateDelay(Boolean bool) {
        this.hasChildPressedStateDelay = bool;
    }

    public PointerEvents getPointerEvents() {
        return this.pointerEvents;
    }

    public void setPointerEvents(PointerEvents value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.pointerEvents = value;
        ImportantForInteractionHelper.setImportantForInteraction(this, value, this._overflow);
    }

    public int getFadingEdgeLengthStart() {
        return this.fadingEdgeLengthStart;
    }

    public void setFadingEdgeLengthStart(int i) {
        this.fadingEdgeLengthStart = i;
        invalidate();
    }

    public int getFadingEdgeLengthEnd() {
        return this.fadingEdgeLengthEnd;
    }

    public void setFadingEdgeLengthEnd(int i) {
        this.fadingEdgeLengthEnd = i;
        invalidate();
    }

    @Override // com.facebook.react.views.scroll.VirtualViewContainer
    public VirtualViewContainerState getVirtualViewContainerState() {
        VirtualViewContainerState virtualViewContainerState = this._virtualViewContainerState;
        if (virtualViewContainerState != null) {
            return virtualViewContainerState;
        }
        VirtualViewContainerState virtualViewContainerStateCreate = VirtualViewContainerState.INSTANCE.create(this);
        this._virtualViewContainerState = virtualViewContainerStateCreate;
        return virtualViewContainerStateCreate;
    }

    @Override // com.facebook.react.uimanager.ReactOverflowViewWithInset
    /* JADX INFO: renamed from: getOverflowInset, reason: from getter */
    public Rect get_overflowInset() {
        return this._overflowInset;
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

    @Override // com.facebook.react.uimanager.ReactClippingViewGroup
    /* JADX INFO: renamed from: getRemoveClippedSubviews, reason: from getter */
    public boolean get_removeClippedSubviews() {
        return this._removeClippedSubviews;
    }

    @Override // com.facebook.react.uimanager.ReactClippingViewGroup
    public void setRemoveClippedSubviews(boolean z) {
        if (ReactNativeFeatureFlags.disableSubviewClippingAndroid()) {
            return;
        }
        if (z && this.clippingRect == null) {
            this.clippingRect = new Rect();
        }
        this._removeClippedSubviews = z;
        updateClippingRect();
    }

    @Override // com.facebook.react.views.scroll.ReactScrollViewHelper.HasScrollState
    /* JADX INFO: renamed from: getReactScrollViewScrollState, reason: from getter */
    public ReactScrollViewHelper.ReactScrollViewScrollState get_reactScrollViewScrollState() {
        return this._reactScrollViewScrollState;
    }

    @Override // com.facebook.react.views.scroll.ReactScrollViewHelper.HasScrollState
    public void setReactScrollViewScrollState(ReactScrollViewHelper.ReactScrollViewScrollState value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this._reactScrollViewScrollState = value;
        if (ReactNativeFeatureFlags.enableViewCulling() || ReactNativeFeatureFlags.useTraitHiddenOnAndroid()) {
            setScrollAwayPaddingEnabledUnstable(value.getScrollAwayPaddingTop(), value.getScrollAwayPaddingBottom(), false);
            Point lastStateUpdateScroll = value.getLastStateUpdateScroll();
            scrollTo(lastStateUpdateScroll.x, lastStateUpdateScroll.y);
        }
    }

    private final void initView() {
        Overflow overflow;
        this._overflowInset = new Rect();
        this._virtualViewContainerState = null;
        this.activelyScrolling = false;
        this.clippingRect = null;
        if (ReactNativeFeatureFlags.enablePropsUpdateReconciliationAndroid()) {
            overflow = Overflow.VISIBLE;
        } else {
            overflow = Overflow.SCROLL;
        }
        this._overflow = overflow;
        this.dragging = false;
        this.pagingEnabled = false;
        this.postTouchRunnable = null;
        this._removeClippedSubviews = false;
        setScrollEnabled(true);
        this.sendMomentumEvents = false;
        this.scrollPerfTag = null;
        this.endBackground = null;
        this.endFillColor = 0;
        this.disableIntervalMomentum = false;
        this.snapInterval = 0;
        this.snapOffsets = null;
        this.snapToStart = true;
        this.snapToEnd = true;
        this.snapToAlignment = 0;
        this.contentView = null;
        this.currentContentOffset = null;
        this.pendingContentOffsetX = -1;
        this.pendingContentOffsetY = -1;
        setStateWrapper(null);
        this._reactScrollViewScrollState = new ReactScrollViewHelper.ReactScrollViewScrollState(null, 0, 0, null, false, false, 0.0f, false, 255, null);
        setPointerEvents(PointerEvents.AUTO);
        setLastScrollDispatchTime(0L);
        setScrollEventThrottle(0);
        this.maintainVisibleContentPositionHelper = null;
        setFadingEdgeLengthStart(0);
        setFadingEdgeLengthEnd(0);
        this.emittedOverScrollSinceScrollBegin = false;
        this.scrollsChildToFocus = true;
    }

    public final void recycleView$ReactAndroid() {
        initView();
        if (getParent() != null) {
            ViewParent parent = getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(this);
        }
        updateView();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        super.onInitializeAccessibilityNodeInfo(info);
        Object tag = getTag(R.id.react_test_id);
        String str = tag instanceof String ? (String) tag : null;
        if (str != null) {
            info.setViewIdResourceName(str);
        }
    }

    protected OverScroller getOverScrollerFromParent() {
        if (!triedToGetScrollerField) {
            triedToGetScrollerField = true;
            try {
                Field declaredField = ScrollView.class.getDeclaredField("mScroller");
                scrollerField = declaredField;
                if (declaredField != null) {
                    declaredField.setAccessible(true);
                }
            } catch (NoSuchFieldException unused) {
                FLog.w(ReactConstants.TAG, "Failed to get mScroller field for ScrollView! This app will exhibit the bounce-back scrolling bug :(");
            }
        }
        Field field = scrollerField;
        if (field == null) {
            return null;
        }
        try {
            Object obj = field.get(this);
            if (obj instanceof OverScroller) {
                return (OverScroller) obj;
            }
            FLog.w(ReactConstants.TAG, "Failed to cast mScroller field in ScrollView (probably due to OEM changes to AOSP)! This app will exhibit the bounce-back scrolling bug :(");
            return null;
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Failed to get mScroller from ScrollView!", e);
        }
    }

    public void setDisableIntervalMomentum(boolean disableIntervalMomentum) {
        this.disableIntervalMomentum = disableIntervalMomentum;
    }

    public void setSendMomentumEvents(boolean sendMomentumEvents) {
        this.sendMomentumEvents = sendMomentumEvents;
    }

    public void setScrollPerfTag(String scrollPerfTag) {
        this.scrollPerfTag = scrollPerfTag;
    }

    public void setPagingEnabled(boolean pagingEnabled) {
        this.pagingEnabled = pagingEnabled;
    }

    public void setScrollsChildToFocus(boolean scrollsChildToFocus) {
        this.scrollsChildToFocus = scrollsChildToFocus;
    }

    public void setDecelerationRate(float decelerationRate) {
        get_reactScrollViewScrollState().setDecelerationRate(decelerationRate);
        OverScroller overScroller = this.scroller;
        if (overScroller != null) {
            overScroller.setFriction(1.0f - decelerationRate);
        }
    }

    public void abortAnimation() {
        OverScroller overScroller = this.scroller;
        if (overScroller == null || overScroller.isFinished()) {
            return;
        }
        this.scroller.abortAnimation();
    }

    public void setSnapInterval(int snapInterval) {
        this.snapInterval = snapInterval;
    }

    public void setSnapOffsets(List<Integer> snapOffsets) {
        this.snapOffsets = snapOffsets;
    }

    public void setSnapToStart(boolean snapToStart) {
        this.snapToStart = snapToStart;
    }

    public void setSnapToEnd(boolean snapToEnd) {
        this.snapToEnd = snapToEnd;
    }

    public void setSnapToAlignment(int snapToAlignment) {
        this.snapToAlignment = snapToAlignment;
    }

    public void flashScrollIndicators() {
        awakenScrollBars();
    }

    @Override // android.widget.ScrollView, android.view.View
    protected float getTopFadingEdgeStrength() {
        return getFadingEdgeLengthStart() / Math.max(getFadingEdgeLengthStart(), getFadingEdgeLengthEnd());
    }

    @Override // android.widget.ScrollView, android.view.View
    protected float getBottomFadingEdgeStrength() {
        return getFadingEdgeLengthEnd() / Math.max(getFadingEdgeLengthStart(), getFadingEdgeLengthEnd());
    }

    public void setOverflow(String overflow) {
        Overflow overflowFromString;
        if (overflow == null) {
            overflowFromString = Overflow.SCROLL;
        } else {
            overflowFromString = Overflow.INSTANCE.fromString(overflow, ReactNativeFeatureFlags.enablePropsUpdateReconciliationAndroid() ? Overflow.VISIBLE : Overflow.SCROLL);
        }
        this._overflow = overflowFromString;
        ImportantForInteractionHelper.setImportantForInteraction(this, getPointerEvents(), this._overflow);
        invalidate();
    }

    public void setMaintainVisibleContentPosition$ReactAndroid(MaintainVisibleScrollPositionHelper.Config config) {
        MaintainVisibleScrollPositionHelper<ReactScrollView> maintainVisibleScrollPositionHelper;
        if (config != null && this.maintainVisibleContentPositionHelper == null) {
            MaintainVisibleScrollPositionHelper<ReactScrollView> maintainVisibleScrollPositionHelper2 = new MaintainVisibleScrollPositionHelper<>(this, false);
            maintainVisibleScrollPositionHelper2.start();
            this.maintainVisibleContentPositionHelper = maintainVisibleScrollPositionHelper2;
        } else if (config == null && (maintainVisibleScrollPositionHelper = this.maintainVisibleContentPositionHelper) != null) {
            if (maintainVisibleScrollPositionHelper != null) {
                maintainVisibleScrollPositionHelper.stop();
            }
            this.maintainVisibleContentPositionHelper = null;
        }
        MaintainVisibleScrollPositionHelper<ReactScrollView> maintainVisibleScrollPositionHelper3 = this.maintainVisibleContentPositionHelper;
        if (maintainVisibleScrollPositionHelper3 != null) {
            maintainVisibleScrollPositionHelper3.setConfig(config);
        }
    }

    @Override // com.facebook.react.uimanager.ReactOverflowViewWithInset
    public void setOverflowInset(int left, int top, int right, int bottom) {
        this._overflowInset.set(left, top, right, bottom);
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        MeasureSpecAssertions.assertExplicitMeasureSpec(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), View.MeasureSpec.getSize(heightMeasureSpec));
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (isContentReady()) {
            int scrollX = this.pendingContentOffsetX;
            if (scrollX == -1) {
                scrollX = getScrollX();
            }
            int scrollY = this.pendingContentOffsetY;
            if (scrollY == -1) {
                scrollY = getScrollY();
            }
            scrollTo(scrollX, scrollY);
        }
        ReactScrollViewHelper.emitLayoutEvent(this);
        VirtualViewContainerState virtualViewContainerState = this._virtualViewContainerState;
        if (virtualViewContainerState != null) {
            virtualViewContainerState.updateState();
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (this._removeClippedSubviews) {
            updateClippingRect();
        }
        VirtualViewContainerState virtualViewContainerState = this._virtualViewContainerState;
        if (virtualViewContainerState != null) {
            virtualViewContainerState.updateState();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this._removeClippedSubviews) {
            updateClippingRect();
        }
        MaintainVisibleScrollPositionHelper<ReactScrollView> maintainVisibleScrollPositionHelper = this.maintainVisibleContentPositionHelper;
        if (maintainVisibleScrollPositionHelper != null) {
            maintainVisibleScrollPositionHelper.start();
        }
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MaintainVisibleScrollPositionHelper<ReactScrollView> maintainVisibleScrollPositionHelper = this.maintainVisibleContentPositionHelper;
        if (maintainVisibleScrollPositionHelper != null) {
            maintainVisibleScrollPositionHelper.stop();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View focused, int direction) {
        View viewFindNextFocusableView;
        Intrinsics.checkNotNullParameter(focused, "focused");
        View viewFocusSearch = super.focusSearch(focused, direction);
        return (!ReactNativeFeatureFlags.enableCustomFocusSearchOnClippedElementsAndroid() || !(viewFocusSearch == null || findViewById(viewFocusSearch.getId()) == null) || (viewFindNextFocusableView = ReactScrollViewHelper.findNextFocusableView(this, focused, direction)) == null) ? viewFocusSearch : viewFindNextFocusableView;
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View child, View focused) {
        Intrinsics.checkNotNullParameter(child, "child");
        if (focused != null && this.scrollsChildToFocus) {
            scrollToChild(focused);
        }
        requestChildFocusWithoutScroll(child, focused);
    }

    protected void requestChildFocusWithoutScroll(View child, View focused) {
        Intrinsics.checkNotNullParameter(child, "child");
        super.requestChildFocus(child, focused);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View child, Rect rectangle, boolean immediate) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(rectangle, "rectangle");
        if (this.scrollsChildToFocus) {
            return super.requestChildRectangleOnScreen(child, rectangle, immediate);
        }
        return false;
    }

    private final int getScrollDelta(View descendent) {
        descendent.getDrawingRect(this.tempRect);
        offsetDescendantRectToMyCoords(descendent, this.tempRect);
        return computeScrollDeltaToGetChildRectOnScreen(this.tempRect);
    }

    @Override // com.facebook.react.views.scroll.ReactAccessibleScrollView
    public boolean isPartiallyScrolledInView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        int scrollDelta = getScrollDelta(view);
        view.getDrawingRect(this.tempRect);
        return scrollDelta != 0 && Math.abs(scrollDelta) < this.tempRect.width();
    }

    private final void scrollToChild(View child) {
        View view = child;
        View view2 = null;
        while (view != null && view != this) {
            if (view instanceof ReactScrollView) {
                view2 = view;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        if (view2 != null) {
            child = view2;
        }
        Rect rect = new Rect();
        child.getDrawingRect(rect);
        offsetDescendantRectToMyCoords(child, rect);
        int iComputeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(rect);
        if (iComputeScrollDeltaToGetChildRectOnScreen != 0) {
            scrollBy(0, iComputeScrollDeltaToGetChildRectOnScreen);
        }
    }

    @Override // android.view.View
    protected void onScrollChanged(int x, int y, int oldX, int oldY) {
        Systrace.beginSection(0L, "ReactScrollView.onScrollChanged");
        try {
            super.onScrollChanged(x, y, oldX, oldY);
            this.activelyScrolling = true;
            if (this.onScrollDispatchHelper.onScrollChanged(x, y)) {
                if (this._removeClippedSubviews) {
                    updateClippingRect();
                }
                ReactScrollViewHelper.updateStateOnScrollChanged(this, this.onScrollDispatchHelper.getXFlingVelocity(), this.onScrollDispatchHelper.getYFlingVelocity());
                VirtualViewContainerState virtualViewContainerState = this._virtualViewContainerState;
                if (virtualViewContainerState != null) {
                    virtualViewContainerState.updateState();
                }
            }
        } finally {
            Systrace.endSection(0L);
        }
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        Boolean hasChildPressedStateDelay = getHasChildPressedStateDelay();
        return hasChildPressedStateDelay != null ? hasChildPressedStateDelay.booleanValue() : super.shouldDelayChildPressedState();
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (!getScrollEnabled()) {
            return false;
        }
        if (!PointerEvents.INSTANCE.canChildrenBeTouchTarget(getPointerEvents())) {
            return true;
        }
        try {
            if (super.onInterceptTouchEvent(ev)) {
                handleInterceptedTouchEvent(ev);
                return true;
            }
        } catch (IllegalArgumentException e) {
            FLog.w(ReactConstants.TAG, "Error intercepting touch event.", e);
        }
        return false;
    }

    protected void handleInterceptedTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (!ReactNativeFeatureFlags.shouldTriggerResponderTransferOnScrollAndroid()) {
            NativeGestureUtil.notifyNativeGestureStarted(this, ev);
        }
        ReactScrollViewHelper.emitScrollBeginDragEvent(this);
        this.dragging = true;
        this.emittedOverScrollSinceScrollBegin = false;
        enableFpsListener();
        getDefaultFlingAnimator().cancel();
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (!getScrollEnabled() || !PointerEvents.INSTANCE.canBeTouchTarget(getPointerEvents())) {
            return false;
        }
        this.velocityHelper.calculateVelocity(ev);
        int actionMasked = ev.getActionMasked();
        if (actionMasked == 1 && this.dragging) {
            ReactScrollView reactScrollView = this;
            ReactScrollViewHelper.updateFabricScrollState(reactScrollView);
            float xVelocity = this.velocityHelper.getXVelocity();
            float yVelocity = this.velocityHelper.getYVelocity();
            ReactScrollViewHelper.emitScrollEndDragEvent(reactScrollView, xVelocity, yVelocity);
            if (!ReactNativeFeatureFlags.shouldTriggerResponderTransferOnScrollAndroid()) {
                NativeGestureUtil.notifyNativeGestureEnded(this, ev);
            }
            this.dragging = false;
            handlePostTouchScrolling(Math.round(xVelocity), Math.round(yVelocity));
        }
        if (actionMasked == 0) {
            cancelPostTouchScrolling();
        }
        try {
            return super.onTouchEvent(ev);
        } catch (IllegalArgumentException e) {
            FLog.w(ReactConstants.TAG, "Error handling touch event.", e);
            return false;
        }
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (!getScrollEnabled() || !PointerEvents.INSTANCE.canChildrenBeTouchTarget(getPointerEvents())) {
            return false;
        }
        if (ev.getActionMasked() == 8) {
            final float axisValue = ev.getAxisValue(9);
            if (axisValue != 0.0f) {
                enableFpsListener();
                boolean zDispatchGenericMotionEvent = super.dispatchGenericMotionEvent(ev);
                if (zDispatchGenericMotionEvent && (this.pagingEnabled || this.snapInterval != 0 || this.snapOffsets != null || this.snapToAlignment != 0)) {
                    Runnable runnable = this.postTouchRunnable;
                    if (runnable != null) {
                        removeCallbacks(runnable);
                        this.postTouchRunnable = null;
                    }
                    Runnable runnable2 = new Runnable() { // from class: com.facebook.react.views.scroll.ReactScrollView$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            ReactScrollView.dispatchGenericMotionEvent$lambda$3(this.f$0, axisValue);
                        }
                    };
                    this.postTouchRunnable = runnable2;
                    postOnAnimationDelayed(runnable2, 20L);
                    return zDispatchGenericMotionEvent;
                }
                handlePostTouchScrolling(0, 0);
                return zDispatchGenericMotionEvent;
            }
        }
        return super.dispatchGenericMotionEvent(ev);
    }

    static final void dispatchGenericMotionEvent$lambda$3(ReactScrollView reactScrollView, float f) {
        reactScrollView.postTouchRunnable = null;
        int i = (int) (-Math.signum(f));
        if (reactScrollView.disableIntervalMomentum) {
            i = 0;
        }
        reactScrollView.flingAndSnap(i);
        reactScrollView.handlePostTouchScrolling(0, i);
    }

    @Override // android.widget.ScrollView
    public boolean executeKeyEvent(KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int keyCode = event.getKeyCode();
        if (getScrollEnabled() || !(keyCode == 19 || keyCode == 20)) {
            return super.executeKeyEvent(event);
        }
        return false;
    }

    @Override // com.facebook.react.uimanager.ReactClippingViewGroup
    public void updateClippingRect() {
        updateClippingRect(null);
    }

    @Override // com.facebook.react.uimanager.ReactClippingViewGroup
    public void updateClippingRect(Set<Integer> excludedViews) {
        if (this._removeClippedSubviews) {
            Systrace.beginSection(0L, "ReactScrollView.updateClippingRect");
            try {
                Rect rect = this.clippingRect;
                if (rect == null) {
                    throw new IllegalStateException("Required value was null.".toString());
                }
                ReactClippingViewGroupHelper.calculateClippingRect(this, rect);
                KeyEvent.Callback contentView = getContentView();
                if (contentView instanceof ReactClippingViewGroup) {
                    ((ReactClippingViewGroup) contentView).updateClippingRect(excludedViews);
                }
                Systrace.endSection(0L);
            } catch (Throwable th) {
                Systrace.endSection(0L);
                throw th;
            }
        }
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

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean getChildVisibleRect(View child, Rect r, Point offset) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(r, "r");
        return super.getChildVisibleRect(child, r, offset);
    }

    @Override // android.widget.ScrollView
    public void fling(int velocityY) {
        int iCorrectFlingVelocityY = correctFlingVelocityY(velocityY);
        if (this.pagingEnabled) {
            flingAndSnap(iCorrectFlingVelocityY);
        } else if (this.scroller != null) {
            this.scroller.fling(getScrollX(), getScrollY(), 0, iCorrectFlingVelocityY, 0, 0, 0, Integer.MAX_VALUE, 0, ((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2);
            postInvalidateOnAnimation();
        } else {
            super.fling(iCorrectFlingVelocityY);
        }
        handlePostTouchScrolling(0, iCorrectFlingVelocityY);
    }

    private final int correctFlingVelocityY(int velocityY) {
        if (Build.VERSION.SDK_INT != 28) {
            return velocityY;
        }
        float fSignum = Math.signum(this.onScrollDispatchHelper.getYFlingVelocity());
        if (fSignum == 0.0f) {
            fSignum = Math.signum(velocityY);
        }
        return (int) (Math.abs(velocityY) * fSignum);
    }

    private final void enableFpsListener() {
        if (isScrollPerfLoggingEnabled()) {
            FpsListener fpsListener = this.fpsListener;
            if (fpsListener == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            String str = this.scrollPerfTag;
            if (str == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            fpsListener.enable(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void disableFpsListener() {
        if (isScrollPerfLoggingEnabled()) {
            FpsListener fpsListener = this.fpsListener;
            if (fpsListener == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            String str = this.scrollPerfTag;
            if (str == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            fpsListener.disable(str);
        }
    }

    private final boolean isScrollPerfLoggingEnabled() {
        String str;
        return (this.fpsListener == null || (str = this.scrollPerfTag) == null || str.length() == 0) ? false : true;
    }

    private final int getMaxScrollY() {
        View view = this.contentView;
        return Math.max(0, (view != null ? view.getHeight() : 0) - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
    }

    @Override // android.widget.ScrollView, android.view.View
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.endFillColor != 0) {
            View contentView = getContentView();
            Drawable drawable = this.endBackground;
            if (drawable != null && contentView != null && contentView.getBottom() < getHeight()) {
                drawable.setBounds(0, contentView.getBottom(), getWidth(), getHeight());
                drawable.draw(canvas);
            }
        }
        super.draw(canvas);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this._overflow != Overflow.VISIBLE) {
            BackgroundStyleApplicator.clipToPaddingBox(this, canvas);
        }
        super.onDraw(canvas);
    }

    private final void handlePostTouchScrolling(int velocityX, int velocityY) {
        if (this.postTouchRunnable != null) {
            return;
        }
        if (this.sendMomentumEvents) {
            enableFpsListener();
            ReactScrollViewHelper.emitScrollMomentumBeginEvent(this, velocityX, velocityY);
        }
        this.activelyScrolling = false;
        Runnable runnable = new Runnable() { // from class: com.facebook.react.views.scroll.ReactScrollView.handlePostTouchScrolling.1
            private boolean snappingToPage;
            private int stableFrames;

            @Override // java.lang.Runnable
            public void run() {
                boolean z = ReactScrollView.this.activelyScrolling;
                ReactScrollView reactScrollView = ReactScrollView.this;
                if (z) {
                    reactScrollView.activelyScrolling = false;
                    this.stableFrames = 0;
                    ReactScrollView.this.postOnAnimationDelayed(this, 20L);
                    return;
                }
                ReactScrollViewHelper.updateFabricScrollState(reactScrollView);
                int i = this.stableFrames + 1;
                this.stableFrames = i;
                ReactScrollView reactScrollView2 = ReactScrollView.this;
                if (i >= 3) {
                    reactScrollView2.postTouchRunnable = null;
                    if (ReactScrollView.this.sendMomentumEvents) {
                        ReactScrollViewHelper.emitScrollMomentumEndEvent(ReactScrollView.this);
                    }
                    ReactScrollViewHelper.notifyUserDrivenScrollEnded_internal(ReactScrollView.this);
                    ReactScrollView.this.disableFpsListener();
                    return;
                }
                if (reactScrollView2.pagingEnabled && !this.snappingToPage) {
                    this.snappingToPage = true;
                    ReactScrollView.this.flingAndSnap(0);
                }
                ReactScrollView.this.postOnAnimationDelayed(this, 20L);
            }
        };
        this.postTouchRunnable = runnable;
        postOnAnimationDelayed(runnable, 20L);
    }

    private final void cancelPostTouchScrolling() {
        Runnable runnable = this.postTouchRunnable;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.postTouchRunnable = null;
            getDefaultFlingAnimator().cancel();
        }
    }

    private final int predictFinalScrollPosition(int velocityY) {
        if (getDefaultFlingAnimator() == this.defaultFlingAnimator) {
            return ReactScrollViewHelper.predictFinalScrollPosition(this, 0, velocityY, 0, getMaxScrollY()).y;
        }
        return ReactScrollViewHelper.getNextFlingStartValue(this, getScrollY(), get_reactScrollViewScrollState().getFinalAnimatedPositionScroll().y, velocityY) + getFlingExtrapolatedDistance(velocityY);
    }

    private final View getContentView() {
        return getChildAt(0);
    }

    private final void smoothScrollAndSnap(int velocity) {
        double snapInterval = getSnapInterval();
        double nextFlingStartValue = ReactScrollViewHelper.getNextFlingStartValue(this, getScrollY(), get_reactScrollViewScrollState().getFinalAnimatedPositionScroll().y, velocity);
        double dPredictFinalScrollPosition = predictFinalScrollPosition(velocity);
        double d = nextFlingStartValue / snapInterval;
        int iFloor = (int) Math.floor(d);
        int iCeil = (int) Math.ceil(d);
        int iRint = (int) Math.rint(d);
        int iRint2 = (int) Math.rint(dPredictFinalScrollPosition / snapInterval);
        if (velocity > 0 && iCeil == iFloor) {
            iCeil++;
        } else if (velocity < 0 && iFloor == iCeil) {
            iFloor--;
        }
        if (velocity > 0 && iRint < iCeil && iRint2 > iFloor) {
            iRint = iCeil;
        } else if (velocity < 0 && iRint > iFloor && iRint2 < iCeil) {
            iRint = iFloor;
        }
        double d2 = ((double) iRint) * snapInterval;
        if (d2 == nextFlingStartValue) {
            return;
        }
        this.activelyScrolling = true;
        reactSmoothScrollTo(getScrollX(), (int) d2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:81:0x0188  */
    public final void flingAndSnap(int velocityY) {
        int iFloor;
        int iMin;
        int iIntValue;
        int iIntValue2;
        int top;
        int top2;
        int height;
        int scrollY;
        OverScroller overScroller;
        if (getChildCount() <= 0) {
            return;
        }
        if (this.snapInterval == 0 && this.snapOffsets == null && this.snapToAlignment == 0) {
            smoothScrollAndSnap(velocityY);
            return;
        }
        boolean z = getDefaultFlingAnimator() != this.defaultFlingAnimator;
        int maxScrollY = getMaxScrollY();
        int iPredictFinalScrollPosition = predictFinalScrollPosition(velocityY);
        if (this.disableIntervalMomentum) {
            iPredictFinalScrollPosition = getScrollY();
        }
        int height2 = (getHeight() - getPaddingBottom()) - getPaddingTop();
        List<Integer> list = this.snapOffsets;
        if (list != null) {
            iIntValue2 = list.get(0).intValue();
            iIntValue = list.get(list.size() - 1).intValue();
            int size = list.size();
            iMin = maxScrollY;
            iFloor = 0;
            for (int i = 0; i < size; i++) {
                int iIntValue3 = list.get(i).intValue();
                if (iIntValue3 <= iPredictFinalScrollPosition && iPredictFinalScrollPosition - iIntValue3 < iPredictFinalScrollPosition - iFloor) {
                    iFloor = iIntValue3;
                }
                if (iIntValue3 >= iPredictFinalScrollPosition && iIntValue3 - iPredictFinalScrollPosition < iMin - iPredictFinalScrollPosition) {
                    iMin = iIntValue3;
                }
            }
        } else {
            int i2 = this.snapToAlignment;
            if (i2 != 0) {
                int i3 = this.snapInterval;
                if (i3 > 0) {
                    double d = ((double) iPredictFinalScrollPosition) / ((double) i3);
                    double dFloor = Math.floor(d);
                    int i4 = this.snapInterval;
                    iFloor = Math.max(getItemStartOffset(i2, (int) (dFloor * ((double) i4)), i4, height2), 0);
                    int i5 = this.snapToAlignment;
                    double dCeil = Math.ceil(d);
                    int i6 = this.snapInterval;
                    iMin = Math.min(getItemStartOffset(i5, (int) (dCeil * ((double) i6)), i6, height2), maxScrollY);
                } else {
                    View contentView = getContentView();
                    Intrinsics.checkNotNull(contentView, "null cannot be cast to non-null type android.view.ViewGroup");
                    ViewGroup viewGroup = (ViewGroup) contentView;
                    int childCount = viewGroup.getChildCount();
                    int iMin2 = maxScrollY;
                    int i7 = iMin2;
                    int i8 = 0;
                    int iMax = 0;
                    for (int i9 = 0; i9 < childCount; i9++) {
                        View childAt = viewGroup.getChildAt(i9);
                        int i10 = this.snapToAlignment;
                        if (i10 != 1) {
                            if (i10 == 2) {
                                top2 = childAt.getTop();
                                height = (height2 - childAt.getHeight()) / 2;
                            } else if (i10 == 3) {
                                top2 = childAt.getTop();
                                height = height2 - childAt.getHeight();
                            } else {
                                throw new IllegalStateException("Invalid SnapToAlignment value: " + this.snapToAlignment);
                            }
                            top = top2 - height;
                        } else {
                            top = childAt.getTop();
                        }
                        if (top <= iPredictFinalScrollPosition && iPredictFinalScrollPosition - top < iPredictFinalScrollPosition - i8) {
                            i8 = top;
                        }
                        if (top >= iPredictFinalScrollPosition && top - iPredictFinalScrollPosition < i7 - iPredictFinalScrollPosition) {
                            i7 = top;
                        }
                        iMin2 = Math.min(iMin2, top);
                        iMax = Math.max(iMax, top);
                    }
                    iFloor = Math.max(i8, iMin2);
                    iMin = Math.min(i7, iMax);
                }
            } else {
                double snapInterval = getSnapInterval();
                double d2 = ((double) iPredictFinalScrollPosition) / snapInterval;
                iFloor = (int) (Math.floor(d2) * snapInterval);
                iMin = Math.min((int) (Math.ceil(d2) * snapInterval), maxScrollY);
            }
            iIntValue = maxScrollY;
            iIntValue2 = 0;
        }
        int i11 = iPredictFinalScrollPosition - iFloor;
        int i12 = iMin - iPredictFinalScrollPosition;
        int i13 = Math.abs(i11) < Math.abs(i12) ? iFloor : iMin;
        if (!this.snapToEnd && iPredictFinalScrollPosition >= iIntValue) {
            if (getScrollY() < iIntValue) {
                scrollY = velocityY;
                iPredictFinalScrollPosition = iIntValue;
            } else {
                scrollY = velocityY;
            }
        } else if (this.snapToStart || iPredictFinalScrollPosition > iIntValue2) {
            if (velocityY > 0) {
                scrollY = !z ? velocityY + ((int) (((double) i12) * 10.0d)) : velocityY;
                iPredictFinalScrollPosition = iMin;
            } else if (velocityY < 0) {
                scrollY = !z ? velocityY - ((int) (((double) i11) * 10.0d)) : velocityY;
                iPredictFinalScrollPosition = iFloor;
            } else {
                scrollY = velocityY;
                iPredictFinalScrollPosition = i13;
            }
        } else if (getScrollY() > iIntValue2) {
            scrollY = velocityY;
            iPredictFinalScrollPosition = iIntValue2;
        } else {
            scrollY = velocityY;
        }
        int iMin3 = Math.min(Math.max(0, iPredictFinalScrollPosition), maxScrollY);
        if (z || (overScroller = this.scroller) == null) {
            reactSmoothScrollTo(getScrollX(), iMin3);
            return;
        }
        this.activelyScrolling = true;
        int scrollX = getScrollX();
        int scrollY2 = getScrollY();
        if (scrollY == 0) {
            scrollY = iMin3 - getScrollY();
        }
        overScroller.fling(scrollX, scrollY2, 0, scrollY, 0, 0, iMin3, iMin3, 0, (iMin3 == 0 || iMin3 == maxScrollY) ? height2 / 2 : 0);
        postInvalidateOnAnimation();
    }

    private final int getItemStartOffset(int snapToAlignment, int itemStartPosition, int itemHeight, int viewPortHeight) {
        int i;
        if (snapToAlignment == 1) {
            return itemStartPosition;
        }
        if (snapToAlignment == 2) {
            i = (viewPortHeight - itemHeight) / 2;
        } else {
            if (snapToAlignment != 3) {
                throw new IllegalStateException("Invalid SnapToAlignment value: " + snapToAlignment);
            }
            i = viewPortHeight - itemHeight;
        }
        return itemStartPosition - i;
    }

    private final int getSnapInterval() {
        int i = this.snapInterval;
        return i != 0 ? i : getHeight();
    }

    public void setEndFillColor(int color) {
        if (color != this.endFillColor) {
            this.endFillColor = color;
            this.endBackground = new ColorDrawable(this.endFillColor);
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) {
        int maxScrollY;
        OverScroller overScroller = this.scroller;
        if (overScroller != null && this.contentView != null && !overScroller.isFinished() && this.scroller.getCurrY() != this.scroller.getFinalY() && scrollY >= (maxScrollY = getMaxScrollY())) {
            this.scroller.abortAnimation();
            scrollY = maxScrollY;
        }
        if (ReactNativeFeatureFlags.shouldTriggerResponderTransferOnScrollAndroid() && clampedY && !this.emittedOverScrollSinceScrollBegin) {
            ReactScrollViewHelper.emitScrollEvent(this, 0.0f, 0.0f);
            this.emittedOverScrollSinceScrollBegin = true;
        }
        super.onOverScrolled(scrollX, scrollY, clampedX, clampedY);
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View parent, View child) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        this.contentView = child;
        child.addOnLayoutChangeListener(this);
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View parent, View child) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        View view = this.contentView;
        if (view != null) {
            view.removeOnLayoutChangeListener(this);
        }
        this.contentView = null;
    }

    public void setContentOffset(ReadableMap value) {
        ReadableMap readableMap = this.currentContentOffset;
        if (readableMap == null || !Intrinsics.areEqual(readableMap, value)) {
            this.currentContentOffset = value;
            if (value != null) {
                scrollTo((int) PixelUtil.toPixelFromDIP(value.hasKey(ViewDeviceOrientationData.DEVICE_ORIENTATION_X) ? value.getDouble(ViewDeviceOrientationData.DEVICE_ORIENTATION_X) : 0.0d), (int) PixelUtil.toPixelFromDIP(value.hasKey(ViewDeviceOrientationData.DEVICE_ORIENTATION_Y) ? value.getDouble(ViewDeviceOrientationData.DEVICE_ORIENTATION_Y) : 0.0d));
            } else {
                scrollTo(0, 0);
            }
        }
    }

    @Override // com.facebook.react.views.scroll.ReactScrollViewHelper.HasSmoothScroll
    public void reactSmoothScrollTo(int x, int y) {
        ReactScrollViewHelper.smoothScrollTo(this, x, y);
        setPendingContentOffsets(x, y);
    }

    @Override // android.widget.ScrollView, android.view.View
    public void scrollTo(int x, int y) {
        super.scrollTo(x, y);
        ReactScrollViewHelper.updateFabricScrollState(this);
        setPendingContentOffsets(x, y);
    }

    private final void recreateFlingAnimation(int scrollY) {
        if (getDefaultFlingAnimator().isRunning()) {
            getDefaultFlingAnimator().cancel();
        }
        OverScroller overScroller = this.scroller;
        if (overScroller == null || overScroller.isFinished()) {
            return;
        }
        int currY = this.scroller.getCurrY();
        boolean zComputeScrollOffset = this.scroller.computeScrollOffset();
        this.scroller.forceFinished(true);
        if (zComputeScrollOffset) {
            this.scroller.fling(getScrollX(), scrollY, 0, (int) (this.scroller.getCurrVelocity() * Math.signum(this.scroller.getFinalY() - this.scroller.getStartY())), 0, 0, 0, Integer.MAX_VALUE);
            return;
        }
        scrollTo(getScrollX(), scrollY + (this.scroller.getCurrY() - currY));
    }

    @Override // com.facebook.react.views.scroll.ReactScrollViewHelper.HasSmoothScroll
    public void scrollToPreservingMomentum(int x, int y) {
        scrollTo(x, y);
        recreateFlingAnimation(y);
    }

    private final boolean isContentReady() {
        View contentView = getContentView();
        return (contentView == null || contentView.getWidth() == 0 || contentView.getHeight() == 0) ? false : true;
    }

    private final void setPendingContentOffsets(int x, int y) {
        if (isContentReady()) {
            this.pendingContentOffsetX = -1;
            this.pendingContentOffsetY = -1;
        } else {
            this.pendingContentOffsetX = x;
            this.pendingContentOffsetY = y;
        }
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        Intrinsics.checkNotNullParameter(v, "v");
        if (this.contentView == null) {
            return;
        }
        if (isShown() && isContentReady()) {
            int scrollY = getScrollY();
            int maxScrollY = getMaxScrollY();
            if (scrollY > maxScrollY) {
                scrollTo(getScrollX(), maxScrollY);
            }
        }
        ReactScrollViewHelper.emitLayoutChangeEvent(this);
    }

    @Override // android.view.View
    public void setBackgroundColor(int color) {
        BackgroundStyleApplicator.setBackgroundColor(this, Integer.valueOf(color));
    }

    public void setBorderWidth(int position, float width) {
        BackgroundStyleApplicator.setBorderWidth(this, LogicalEdge.getEntries().get(position), Float.valueOf(PixelUtil.toDIPFromPixel(width)));
    }

    public void setBorderColor(int position, Integer color) {
        BackgroundStyleApplicator.setBorderColor(this, LogicalEdge.getEntries().get(position), color);
    }

    public void setBorderRadius(float borderRadius) {
        setBorderRadius(borderRadius, BorderRadiusProp.BORDER_RADIUS.ordinal());
    }

    public void setBorderRadius(float borderRadius, int position) {
        BackgroundStyleApplicator.setBorderRadius(this, BorderRadiusProp.getEntries().get(position), Float.isNaN(borderRadius) ? null : new LengthPercentage(PixelUtil.toDIPFromPixel(borderRadius), LengthPercentageType.POINT));
    }

    public void setBorderStyle(String style) {
        BackgroundStyleApplicator.setBorderStyle(this, style == null ? null : BorderStyle.INSTANCE.fromString(style));
    }

    public void setScrollAwayPaddingEnabledUnstable(int topPadding, int bottomPadding) {
        setScrollAwayPaddingEnabledUnstable(topPadding, bottomPadding, true);
    }

    public void setScrollAwayPaddingEnabledUnstable(int topPadding, int bottomPadding, boolean updateState) {
        int childCount = getChildCount();
        if (childCount > 1) {
            throw new IllegalStateException("React Native ScrollView should not have more than one child, it should have exactly 1 child; a content View".toString());
        }
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).setTranslationY(topPadding);
            }
            setPadding(0, 0, 0, topPadding + bottomPadding);
        }
        if (updateState) {
            updateScrollAwayState(topPadding, bottomPadding);
        }
        setRemoveClippedSubviews(this._removeClippedSubviews);
    }

    private final void updateScrollAwayState(int scrollAwayPaddingTop, int scrollAwayPaddingBottom) {
        this._reactScrollViewScrollState.setScrollAwayPaddingTop(scrollAwayPaddingTop);
        this._reactScrollViewScrollState.setScrollAwayPaddingBottom(scrollAwayPaddingBottom);
        ReactScrollViewHelper.forceUpdateState(this);
    }

    @Override // com.facebook.react.views.scroll.ReactScrollViewHelper.HasFlingAnimator
    public void startFlingAnimator(int start, int end) {
        this.defaultFlingAnimator.cancel();
        int defaultScrollAnimationDuration = ReactScrollViewHelper.getDefaultScrollAnimationDuration(getContext());
        this.defaultFlingAnimator.setDuration(defaultScrollAnimationDuration).setIntValues(start, end);
        this.defaultFlingAnimator.start();
        if (this.sendMomentumEvents) {
            ReactScrollView reactScrollView = this;
            ReactScrollViewHelper.emitScrollMomentumBeginEvent(reactScrollView, 0, defaultScrollAnimationDuration > 0 ? (end - start) / defaultScrollAnimationDuration : 0);
            ReactScrollViewHelper.dispatchMomentumEndOnAnimationEnd(reactScrollView);
        }
    }

    @Override // com.facebook.react.views.scroll.ReactScrollViewHelper.HasFlingAnimator
    /* JADX INFO: renamed from: getFlingAnimator, reason: from getter */
    public ValueAnimator getDefaultFlingAnimator() {
        return this.defaultFlingAnimator;
    }

    @Override // com.facebook.react.views.scroll.ReactScrollViewHelper.HasFlingAnimator
    public int getFlingExtrapolatedDistance(int velocity) {
        return ReactScrollViewHelper.predictFinalScrollPosition(this, 0, velocity, 0, getMaxScrollY()).y;
    }
}
