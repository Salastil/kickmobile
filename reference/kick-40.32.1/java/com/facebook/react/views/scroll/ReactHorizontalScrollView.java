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
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.HorizontalScrollView;
import android.widget.OverScroller;
import androidx.core.view.ViewCompat;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.common.logging.FLog;
import com.facebook.react.R;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReactHorizontalScrollView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000¢\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u001c\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b;\b\u0016\u0018\u0000 ¢\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\f2\u00020\r:\u0002¢\u0002B\u001d\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u007f\u001a\u00030\u0080\u0001H\u0002J\u0010\u0010\u0081\u0001\u001a\u00030\u0080\u0001H\u0000¢\u0006\u0003\b\u0082\u0001J\n\u0010\u0083\u0001\u001a\u00030\u0080\u0001H\u0002J\u0014\u0010\u0084\u0001\u001a\u00030\u0080\u00012\b\u0010\u0085\u0001\u001a\u00030\u0086\u0001H\u0016J\u0012\u0010\u0087\u0001\u001a\u00020$2\u0007\u0010\u0088\u0001\u001a\u00020\u0015H\u0016J\u000b\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0019H\u0002J\u0014\u0010\u008a\u0001\u001a\u00030\u0080\u00012\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0012\u0010\u008b\u0001\u001a\u00030\u0080\u00012\u0006\u00105\u001a\u00020$H\u0016J\u0012\u0010\u008c\u0001\u001a\u00030\u0080\u00012\u0006\u0010/\u001a\u00020$H\u0016J\u0012\u0010\u008d\u0001\u001a\u00030\u0080\u00012\u0006\u0010,\u001a\u00020$H\u0016J\u0012\u0010\u008e\u0001\u001a\u00030\u0080\u00012\u0006\u0010S\u001a\u00020$H\u0016J\u0014\u0010\u008f\u0001\u001a\u00030\u0080\u00012\b\u0010\u0090\u0001\u001a\u00030\u0091\u0001H\u0016J\n\u0010\u0092\u0001\u001a\u00030\u0080\u0001H\u0016J\u0012\u0010\u0093\u0001\u001a\u00030\u0080\u00012\u0006\u00106\u001a\u00020\u0015H\u0016J\u001a\u0010\u0094\u0001\u001a\u00030\u0080\u00012\u000e\u00107\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u000108H\u0016J\u0012\u0010\u0095\u0001\u001a\u00030\u0080\u00012\u0006\u00109\u001a\u00020$H\u0016J\u0012\u0010\u0096\u0001\u001a\u00030\u0080\u00012\u0006\u0010:\u001a\u00020$H\u0016J\u0012\u0010\u0097\u0001\u001a\u00030\u0080\u00012\u0006\u0010;\u001a\u00020\u0015H\u0016J\n\u0010\u0098\u0001\u001a\u00030\u0080\u0001H\u0016J\n\u0010\u0099\u0001\u001a\u00030\u0091\u0001H\u0014J\n\u0010\u009a\u0001\u001a\u00030\u0091\u0001H\u0014J\u0014\u0010\u009b\u0001\u001a\u00030\u0080\u00012\b\u0010t\u001a\u0004\u0018\u000101H\u0016J\u001c\u0010\u009c\u0001\u001a\u00030\u0080\u00012\n\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009e\u0001H\u0010¢\u0006\u0003\b\u009f\u0001J.\u0010 \u0001\u001a\u00030\u0080\u00012\u0007\u0010¡\u0001\u001a\u00020\u00152\u0007\u0010¢\u0001\u001a\u00020\u00152\u0007\u0010£\u0001\u001a\u00020\u00152\u0007\u0010¤\u0001\u001a\u00020\u0015H\u0016J\u0014\u0010¥\u0001\u001a\u00030\u0080\u00012\b\u0010¦\u0001\u001a\u00030§\u0001H\u0016J\u001c\u0010¨\u0001\u001a\u00030\u0080\u00012\u0007\u0010©\u0001\u001a\u00020\u00152\u0007\u0010ª\u0001\u001a\u00020\u0015H\u0014J7\u0010«\u0001\u001a\u00030\u0080\u00012\u0007\u0010¬\u0001\u001a\u00020$2\u0007\u0010\u00ad\u0001\u001a\u00020\u00152\u0007\u0010®\u0001\u001a\u00020\u00152\u0007\u0010¯\u0001\u001a\u00020\u00152\u0007\u0010°\u0001\u001a\u00020\u0015H\u0014J\u001e\u0010±\u0001\u001a\u00030\u0080\u00012\u0007\u0010²\u0001\u001a\u00020G2\t\u0010³\u0001\u001a\u0004\u0018\u00010GH\u0016J\u001e\u0010´\u0001\u001a\u00030\u0080\u00012\u0007\u0010²\u0001\u001a\u00020G2\t\u0010³\u0001\u001a\u0004\u0018\u00010GH\u0014J$\u0010µ\u0001\u001a\u00020$2\u0007\u0010²\u0001\u001a\u00020G2\u0007\u0010¶\u0001\u001a\u00020\u001d2\u0007\u0010·\u0001\u001a\u00020$H\u0016J7\u0010¸\u0001\u001a\u00030\u0080\u00012\u0019\u0010¹\u0001\u001a\u0014\u0012\u0004\u0012\u00020G0º\u0001j\t\u0012\u0004\u0012\u00020G`»\u00012\u0007\u0010\u0088\u0001\u001a\u00020\u00152\u0007\u0010¼\u0001\u001a\u00020\u0015H\u0016J\u0012\u0010½\u0001\u001a\u00020\u00152\u0007\u0010¾\u0001\u001a\u00020GH\u0002J\u0012\u0010¿\u0001\u001a\u00020$2\u0007\u0010¾\u0001\u001a\u00020GH\u0002J\u0012\u0010À\u0001\u001a\u00020$2\u0007\u0010Á\u0001\u001a\u00020GH\u0016J\u0012\u0010Â\u0001\u001a\u00020$2\u0007\u0010¾\u0001\u001a\u00020GH\u0002J\u0013\u0010Ã\u0001\u001a\u00030\u0080\u00012\u0007\u0010²\u0001\u001a\u00020GH\u0002J.\u0010Ä\u0001\u001a\u00030\u0080\u00012\u0007\u0010Å\u0001\u001a\u00020\u00152\u0007\u0010Æ\u0001\u001a\u00020\u00152\u0007\u0010Ç\u0001\u001a\u00020\u00152\u0007\u0010È\u0001\u001a\u00020\u0015H\u0014J\t\u0010É\u0001\u001a\u00020$H\u0016J\u0013\u0010Ê\u0001\u001a\u00020$2\b\u0010Ë\u0001\u001a\u00030Ì\u0001H\u0016J\u0014\u0010Í\u0001\u001a\u00030\u0080\u00012\b\u0010Ë\u0001\u001a\u00030Ì\u0001H\u0014J\u0012\u0010Î\u0001\u001a\u00020$2\u0007\u0010\u0088\u0001\u001a\u00020\u0015H\u0016J\u001f\u0010Ï\u0001\u001a\u00020$2\t\u0010Ð\u0001\u001a\u0004\u0018\u00010G2\t\u0010Á\u0001\u001a\u0004\u0018\u00010GH\u0002J\u0012\u0010Ñ\u0001\u001a\u00020$2\u0007\u0010\u0088\u0001\u001a\u00020\u0015H\u0016J\u0013\u0010Ò\u0001\u001a\u00020$2\b\u0010Ë\u0001\u001a\u00030Ì\u0001H\u0016J\u0013\u0010Ó\u0001\u001a\u00020$2\b\u0010Ë\u0001\u001a\u00030Ì\u0001H\u0016J\u0013\u0010Ô\u0001\u001a\u00020$2\b\u0010Õ\u0001\u001a\u00030Ö\u0001H\u0016J\u0013\u0010×\u0001\u001a\u00030\u0080\u00012\u0007\u0010Ø\u0001\u001a\u00020\u0015H\u0016J.\u0010Ù\u0001\u001a\u00030\u0080\u00012\u0007\u0010Ú\u0001\u001a\u00020\u00152\u0007\u0010Û\u0001\u001a\u00020\u00152\u0007\u0010Ü\u0001\u001a\u00020\u00152\u0007\u0010Ý\u0001\u001a\u00020\u0015H\u0014J\n\u0010Þ\u0001\u001a\u00030\u0080\u0001H\u0014J\n\u0010ß\u0001\u001a\u00030\u0080\u0001H\u0014J\u001d\u0010à\u0001\u001a\u0004\u0018\u00010G2\u0007\u0010³\u0001\u001a\u00020G2\u0007\u0010\u0088\u0001\u001a\u00020\u0015H\u0016J\n\u0010á\u0001\u001a\u00030\u0080\u0001H\u0016J\u001c\u0010á\u0001\u001a\u00030\u0080\u00012\u0010\u0010â\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0015\u0018\u00010ã\u0001H\u0016J\u0013\u0010ä\u0001\u001a\u00030\u0080\u00012\u0007\u0010å\u0001\u001a\u00020\u001dH\u0016J'\u0010æ\u0001\u001a\u00020$2\u0007\u0010²\u0001\u001a\u00020G2\u0007\u0010¯\u0001\u001a\u00020\u001d2\n\u0010ç\u0001\u001a\u0005\u0018\u00010è\u0001H\u0016J\t\u0010é\u0001\u001a\u00020\u0015H\u0002J\u000b\u0010ê\u0001\u001a\u0004\u0018\u00010GH\u0002J\u0013\u0010ë\u0001\u001a\u00030\u0080\u00012\u0007\u0010ì\u0001\u001a\u00020\u0015H\u0016J.\u0010í\u0001\u001a\u00030\u0080\u00012\u0007\u0010î\u0001\u001a\u00020\u00152\u0007\u0010ï\u0001\u001a\u00020\u00152\u0007\u0010ð\u0001\u001a\u00020$2\u0007\u0010ñ\u0001\u001a\u00020$H\u0014J\u001c\u0010ò\u0001\u001a\u00030\u0080\u00012\u0007\u0010Ð\u0001\u001a\u00020G2\u0007\u0010²\u0001\u001a\u00020GH\u0016J\u001c\u0010ó\u0001\u001a\u00030\u0080\u00012\u0007\u0010Ð\u0001\u001a\u00020G2\u0007\u0010²\u0001\u001a\u00020GH\u0016J\n\u0010ô\u0001\u001a\u00030\u0080\u0001H\u0002J\n\u0010õ\u0001\u001a\u00030\u0080\u0001H\u0002J\t\u0010ö\u0001\u001a\u00020$H\u0002J\u0014\u0010÷\u0001\u001a\u00030\u0080\u00012\b\u0010¦\u0001\u001a\u00030§\u0001H\u0016J\u001c\u0010ø\u0001\u001a\u00030\u0080\u00012\u0007\u0010Ø\u0001\u001a\u00020\u00152\u0007\u0010ù\u0001\u001a\u00020\u0015H\u0002J\n\u0010ú\u0001\u001a\u00030\u0080\u0001H\u0002J\u0012\u0010û\u0001\u001a\u00020\u00152\u0007\u0010Ø\u0001\u001a\u00020\u0015H\u0002J\u0013\u0010ü\u0001\u001a\u00030\u0080\u00012\u0007\u0010ý\u0001\u001a\u00020\u0015H\u0002J\u0013\u0010þ\u0001\u001a\u00030\u0080\u00012\u0007\u0010Ø\u0001\u001a\u00020\u0015H\u0002J,\u0010ÿ\u0001\u001a\u00020\u00152\u0006\u0010;\u001a\u00020\u00152\u0007\u0010\u0080\u0002\u001a\u00020\u00152\u0007\u0010\u0081\u0002\u001a\u00020\u00152\u0007\u0010\u0082\u0002\u001a\u00020\u0015H\u0002J\u0013\u0010\u0083\u0002\u001a\u00030\u0080\u00012\u0007\u0010\u0088\u0001\u001a\u00020\u0015H\u0002J\u0013\u0010\u0084\u0002\u001a\u00030\u0080\u00012\u0007\u0010ì\u0001\u001a\u00020\u0015H\u0016J\u001d\u0010\u0085\u0002\u001a\u00030\u0080\u00012\u0007\u0010\u0086\u0002\u001a\u00020\u00152\b\u0010\u0087\u0002\u001a\u00030\u0091\u0001H\u0016J$\u0010\u0088\u0002\u001a\u00030\u0080\u00012\u0007\u0010\u0086\u0002\u001a\u00020\u00152\t\u0010ì\u0001\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0003\u0010\u0089\u0002J\u0014\u0010\u008a\u0002\u001a\u00030\u0080\u00012\b\u0010\u008b\u0002\u001a\u00030\u0091\u0001H\u0016J\u001d\u0010\u008a\u0002\u001a\u00030\u0080\u00012\b\u0010\u008b\u0002\u001a\u00030\u0091\u00012\u0007\u0010\u0086\u0002\u001a\u00020\u0015H\u0016J\u0015\u0010\u008c\u0002\u001a\u00030\u0080\u00012\t\u0010\u008d\u0002\u001a\u0004\u0018\u000101H\u0016J\u001c\u0010\u008e\u0002\u001a\u00030\u0080\u00012\u0007\u0010Å\u0001\u001a\u00020\u00152\u0007\u0010Æ\u0001\u001a\u00020\u0015H\u0016J\u001c\u0010\u008f\u0002\u001a\u00030\u0080\u00012\u0007\u0010Å\u0001\u001a\u00020\u00152\u0007\u0010Æ\u0001\u001a\u00020\u0015H\u0016J\u001c\u0010\u0090\u0002\u001a\u00030\u0080\u00012\u0007\u0010Å\u0001\u001a\u00020\u00152\u0007\u0010Æ\u0001\u001a\u00020\u0015H\u0016J\u001c\u0010\u0091\u0002\u001a\u00030\u0080\u00012\u0007\u0010Å\u0001\u001a\u00020\u00152\u0007\u0010Æ\u0001\u001a\u00020\u0015H\u0014J\t\u0010\u0092\u0002\u001a\u00020$H\u0002J\u001c\u0010\u0093\u0002\u001a\u00030\u0080\u00012\u0007\u0010Å\u0001\u001a\u00020\u00152\u0007\u0010Æ\u0001\u001a\u00020\u0015H\u0002J[\u0010\u0094\u0002\u001a\u00030\u0080\u00012\u0007\u0010\u0095\u0002\u001a\u00020G2\u0007\u0010¡\u0001\u001a\u00020\u00152\u0007\u0010¢\u0001\u001a\u00020\u00152\u0007\u0010£\u0001\u001a\u00020\u00152\u0007\u0010¤\u0001\u001a\u00020\u00152\u0007\u0010\u0096\u0002\u001a\u00020\u00152\u0007\u0010\u0097\u0002\u001a\u00020\u00152\u0007\u0010\u0098\u0002\u001a\u00020\u00152\u0007\u0010\u0099\u0002\u001a\u00020\u0015H\u0016J\u001c\u0010\u009a\u0002\u001a\u00030\u0080\u00012\u0007\u0010î\u0001\u001a\u00020\u00152\u0007\u0010\u009b\u0002\u001a\u00020\u0015H\u0002J.\u0010\u009c\u0002\u001a\u00030\u0080\u00012\u0007\u0010¡\u0001\u001a\u00020\u00152\u0007\u0010£\u0001\u001a\u00020\u00152\u0007\u0010\u0096\u0002\u001a\u00020\u00152\u0007\u0010\u0098\u0002\u001a\u00020\u0015H\u0002J\u001c\u0010\u009d\u0002\u001a\u00030\u0080\u00012\u0007\u0010\u009e\u0002\u001a\u00020\u00152\u0007\u0010\u009f\u0002\u001a\u00020\u0015H\u0016J\t\u0010 \u0002\u001a\u00020\u001fH\u0016J\u0012\u0010¡\u0002\u001a\u00020\u00152\u0007\u0010ý\u0001\u001a\u00020\u0015H\u0016R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00107\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010A\u001a\u00020@2\u0006\u0010?\u001a\u00020@@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u0010\u0010F\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010H\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010IX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010J\u001a\u00020\u00152\u0006\u0010?\u001a\u00020\u0015@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR$\u0010O\u001a\u00020\u00152\u0006\u0010?\u001a\u00020\u0015@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010L\"\u0004\bQ\u0010NR\u000e\u0010R\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010T\u001a\u00020$X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001c\u0010Y\u001a\u0004\u0018\u00010ZX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u001a\u0010_\u001a\u00020\u0015X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010L\"\u0004\ba\u0010NR\u001a\u0010b\u001a\u00020cX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u001e\u0010h\u001a\u0004\u0018\u00010$X\u0096\u000e¢\u0006\u0010\n\u0002\u0010m\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR\u0014\u0010n\u001a\u00020\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bo\u0010pR\u0014\u0010q\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\br\u0010sR\u0016\u0010t\u001a\u0004\u0018\u0001018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bu\u0010vR$\u0010w\u001a\u00020$2\u0006\u0010?\u001a\u00020$8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bx\u0010V\"\u0004\by\u0010XR$\u0010z\u001a\u00020&2\u0006\u0010?\u001a\u00020&8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~¨\u0006£\u0002"}, d2 = {"Lcom/facebook/react/views/scroll/ReactHorizontalScrollView;", "Landroid/widget/HorizontalScrollView;", "Lcom/facebook/react/uimanager/ReactClippingViewGroup;", "Landroid/view/ViewGroup$OnHierarchyChangeListener;", "Landroid/view/View$OnLayoutChangeListener;", "Lcom/facebook/react/views/scroll/ReactAccessibleScrollView;", "Lcom/facebook/react/uimanager/ReactOverflowViewWithInset;", "Lcom/facebook/react/views/scroll/ReactScrollViewHelper$HasScrollState;", "Lcom/facebook/react/views/scroll/ReactScrollViewHelper$HasStateWrapper;", "Lcom/facebook/react/views/scroll/ReactScrollViewHelper$HasFlingAnimator;", "Lcom/facebook/react/views/scroll/ReactScrollViewHelper$HasScrollEventThrottle;", "Lcom/facebook/react/views/scroll/ReactScrollViewHelper$HasSmoothScroll;", "Lcom/facebook/react/views/scroll/VirtualViewContainer;", "Lcom/facebook/react/uimanager/HasChildPressedStateDelay;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "fpsListener", "Lcom/facebook/react/views/scroll/FpsListener;", "<init>", "(Landroid/content/Context;Lcom/facebook/react/views/scroll/FpsListener;)V", "scrollXAfterMeasure", "", "onScrollDispatchHelper", "Lcom/facebook/react/views/scroll/OnScrollDispatchHelper;", "scroller", "Landroid/widget/OverScroller;", "velocityHelper", "Lcom/facebook/react/views/scroll/VelocityHelper;", "tempRect", "Landroid/graphics/Rect;", "defaultFlingAnimator", "Landroid/animation/ValueAnimator;", "_overflowInset", "_virtualViewContainerState", "Lcom/facebook/react/views/scroll/VirtualViewContainerState;", "_removeClippedSubviews", "", "_reactScrollViewScrollState", "Lcom/facebook/react/views/scroll/ReactScrollViewHelper$ReactScrollViewScrollState;", "activelyScrolling", "clippingRect", "_overflow", "Lcom/facebook/react/uimanager/style/Overflow;", "dragging", "pagingEnabled", "postTouchRunnable", "Ljava/lang/Runnable;", "sendMomentumEvents", "scrollPerfTag", "", "endBackground", "Landroid/graphics/drawable/Drawable;", "endFillColor", "disableIntervalMomentum", "snapInterval", "snapOffsets", "", "snapToStart", "snapToEnd", "snapToAlignment", "pagedArrowScrolling", "pendingContentOffsetX", "pendingContentOffsetY", "value", "Lcom/facebook/react/uimanager/PointerEvents;", ViewProps.POINTER_EVENTS, "getPointerEvents", "()Lcom/facebook/react/uimanager/PointerEvents;", "setPointerEvents", "(Lcom/facebook/react/uimanager/PointerEvents;)V", "contentView", "Landroid/view/View;", "maintainVisibleContentPositionHelper", "Lcom/facebook/react/views/scroll/MaintainVisibleScrollPositionHelper;", "fadingEdgeLengthStart", "getFadingEdgeLengthStart", "()I", "setFadingEdgeLengthStart", "(I)V", "fadingEdgeLengthEnd", "getFadingEdgeLengthEnd", "setFadingEdgeLengthEnd", "emittedOverScrollSinceScrollBegin", "scrollsChildToFocus", "scrollEnabled", "getScrollEnabled", "()Z", "setScrollEnabled", "(Z)V", "stateWrapper", "Lcom/facebook/react/uimanager/StateWrapper;", "getStateWrapper", "()Lcom/facebook/react/uimanager/StateWrapper;", "setStateWrapper", "(Lcom/facebook/react/uimanager/StateWrapper;)V", "scrollEventThrottle", "getScrollEventThrottle", "setScrollEventThrottle", "lastScrollDispatchTime", "", "getLastScrollDispatchTime", "()J", "setLastScrollDispatchTime", "(J)V", "hasChildPressedStateDelay", "getHasChildPressedStateDelay", "()Ljava/lang/Boolean;", "setHasChildPressedStateDelay", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "virtualViewContainerState", "getVirtualViewContainerState", "()Lcom/facebook/react/views/scroll/VirtualViewContainerState;", "overflowInset", "getOverflowInset", "()Landroid/graphics/Rect;", ViewProps.OVERFLOW, "getOverflow", "()Ljava/lang/String;", ReactClippingViewGroupHelper.PROP_REMOVE_CLIPPED_SUBVIEWS, "getRemoveClippedSubviews", "setRemoveClippedSubviews", "reactScrollViewScrollState", "getReactScrollViewScrollState", "()Lcom/facebook/react/views/scroll/ReactScrollViewHelper$ReactScrollViewScrollState;", "setReactScrollViewScrollState", "(Lcom/facebook/react/views/scroll/ReactScrollViewHelper$ReactScrollViewScrollState;)V", "initView", "", "recycleView", "recycleView$ReactAndroid", "updateView", "onInitializeAccessibilityNodeInfo", "info", "Landroid/view/accessibility/AccessibilityNodeInfo;", "canScrollHorizontally", "direction", "getOverScrollerFromParent", "setScrollPerfTag", "setDisableIntervalMomentum", "setSendMomentumEvents", "setPagingEnabled", "setScrollsChildToFocus", "setDecelerationRate", "decelerationRate", "", "abortAnimation", "setSnapInterval", "setSnapOffsets", "setSnapToStart", "setSnapToEnd", "setSnapToAlignment", "flashScrollIndicators", "getLeftFadingEdgeStrength", "getRightFadingEdgeStrength", "setOverflow", "setMaintainVisibleContentPosition", "config", "Lcom/facebook/react/views/scroll/MaintainVisibleScrollPositionHelper$Config;", "setMaintainVisibleContentPosition$ReactAndroid", "setOverflowInset", "left", ViewProps.TOP, "right", ViewProps.BOTTOM, "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onLayout", "changed", "l", "t", "r", "b", "requestChildFocus", "child", "focused", "requestChildFocusWithoutScroll", "requestChildRectangleOnScreen", "rectangle", "immediate", "addFocusables", "views", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "focusableMode", "getScrollDelta", "descendent", "isScrolledInView", "isPartiallyScrolledInView", "view", "isMostlyScrolledInView", "scrollToChild", "onScrollChanged", ViewDeviceOrientationData.DEVICE_ORIENTATION_X, ViewDeviceOrientationData.DEVICE_ORIENTATION_Y, "oldX", "oldY", "shouldDelayChildPressedState", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "handleInterceptedTouchEvent", "pageScroll", "isDescendantOf", "parent", "arrowScroll", "onTouchEvent", "dispatchGenericMotionEvent", "executeKeyEvent", "event", "Landroid/view/KeyEvent;", "fling", "velocityX", "onSizeChanged", "w", "h", "oldw", "oldh", "onAttachedToWindow", "onDetachedFromWindow", "focusSearch", "updateClippingRect", "excludedViews", "", "getClippingRect", "outClippingRect", "getChildVisibleRect", "offset", "Landroid/graphics/Point;", "getSnapInterval", "getContentView", "setEndFillColor", "color", "onOverScrolled", "scrollX", "scrollY", "clampedX", "clampedY", "onChildViewAdded", "onChildViewRemoved", "enableFpsListener", "disableFpsListener", "isScrollPerfLoggingEnabled", "draw", "handlePostTouchScrolling", "velocityY", "cancelPostTouchScrolling", "predictFinalScrollPosition", "smoothScrollAndSnap", "velocity", "flingAndSnap", "getItemStartOffset", "itemStartPosition", "itemWidth", "viewPortWidth", "smoothScrollToNextPage", "setBackgroundColor", "setBorderWidth", ViewProps.POSITION, ViewProps.WIDTH, "setBorderColor", "(ILjava/lang/Integer;)V", "setBorderRadius", ViewProps.BORDER_RADIUS, "setBorderStyle", "style", "reactSmoothScrollTo", "scrollTo", "scrollToPreservingMomentum", "restoreScrollTo", "isContentReady", "setPendingContentOffsets", "onLayoutChange", "v", "oldLeft", "oldTop", "oldRight", "oldBottom", "recreateFlingAnimation", "maxX", "adjustPositionForContentChangeRTL", "startFlingAnimator", ViewProps.START, ViewProps.END, "getFlingAnimator", "getFlingExtrapolatedDistance", "Companion", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class ReactHorizontalScrollView extends HorizontalScrollView implements ReactClippingViewGroup, ViewGroup.OnHierarchyChangeListener, View.OnLayoutChangeListener, ReactAccessibleScrollView, ReactOverflowViewWithInset, ReactScrollViewHelper.HasScrollState, ReactScrollViewHelper.HasStateWrapper, ReactScrollViewHelper.HasFlingAnimator, ReactScrollViewHelper.HasScrollEventThrottle, ReactScrollViewHelper.HasSmoothScroll, VirtualViewContainer, HasChildPressedStateDelay {
    private static final int NO_SCROLL_POSITION = Integer.MIN_VALUE;
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
    private MaintainVisibleScrollPositionHelper<ReactHorizontalScrollView> maintainVisibleContentPositionHelper;
    private final OnScrollDispatchHelper onScrollDispatchHelper;
    private boolean pagedArrowScrolling;
    private boolean pagingEnabled;
    private int pendingContentOffsetX;
    private int pendingContentOffsetY;
    private PointerEvents pointerEvents;
    private Runnable postTouchRunnable;
    private boolean scrollEnabled;
    private int scrollEventThrottle;
    private String scrollPerfTag;
    private int scrollXAfterMeasure;
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
    private static final Companion Companion = new Companion(null);
    private static final boolean DEBUG_MODE = false;
    private static final String TAG = "ReactHorizontalScrollView";

    /* JADX INFO: compiled from: ReactHorizontalScrollView.kt */
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
    public ReactHorizontalScrollView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void updateView() {
    }

    public /* synthetic */ ReactHorizontalScrollView(Context context, FpsListener fpsListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : fpsListener);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactHorizontalScrollView(Context context, FpsListener fpsListener) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.fpsListener = fpsListener;
        this.scrollXAfterMeasure = Integer.MIN_VALUE;
        this.onScrollDispatchHelper = new OnScrollDispatchHelper();
        this.scroller = getOverScrollerFromParent();
        this.velocityHelper = new VelocityHelper();
        this.tempRect = new Rect();
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this, "scrollX", 0, 0);
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfInt, "ofInt(...)");
        this.defaultFlingAnimator = objectAnimatorOfInt;
        this._overflowInset = new Rect();
        this._reactScrollViewScrollState = new ReactScrollViewHelper.ReactScrollViewScrollState(null, 0, 0, null, false, false, 0.0f, false, 255, null);
        this._overflow = ReactNativeFeatureFlags.enablePropsUpdateReconciliationAndroid() ? Overflow.VISIBLE : Overflow.SCROLL;
        this.snapToStart = true;
        this.snapToEnd = true;
        this.pendingContentOffsetX = -1;
        this.pendingContentOffsetY = -1;
        this.pointerEvents = PointerEvents.AUTO;
        this.scrollsChildToFocus = true;
        this.scrollEnabled = true;
        ViewCompat.setAccessibilityDelegate(this, new ReactScrollViewAccessibilityDelegate());
        setOnHierarchyChangeListener(this);
        setClipChildren(false);
        initView();
    }

    /* JADX INFO: compiled from: ReactHorizontalScrollView.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J$\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/facebook/react/views/scroll/ReactHorizontalScrollView$Companion;", "", "<init>", "()V", "DEBUG_MODE", "", "TAG", "", "kotlin.jvm.PlatformType", "NO_SCROLL_POSITION", "", "UNSET_CONTENT_OFFSET", "scrollerField", "Ljava/lang/reflect/Field;", "triedToGetScrollerField", "findDeepestScrollViewForMotionEvent", "Landroid/widget/HorizontalScrollView;", "view", "Landroid/view/View;", "ev", "Landroid/view/MotionEvent;", "skipInitialView", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final HorizontalScrollView findDeepestScrollViewForMotionEvent(View view, MotionEvent ev) {
            return findDeepestScrollViewForMotionEvent(view, ev, true);
        }

        private final HorizontalScrollView findDeepestScrollViewForMotionEvent(View view, MotionEvent ev, boolean skipInitialView) {
            if (view == null) {
                return null;
            }
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            if (!rect.contains((int) ev.getRawX(), (int) ev.getRawY())) {
                return null;
            }
            if (!skipInitialView && (view instanceof HorizontalScrollView) && ViewCompat.isNestedScrollingEnabled(view) && (view instanceof ReactHorizontalScrollView) && ((ReactHorizontalScrollView) view).getScrollEnabled()) {
                return (HorizontalScrollView) view;
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    HorizontalScrollView horizontalScrollViewFindDeepestScrollViewForMotionEvent = findDeepestScrollViewForMotionEvent(viewGroup.getChildAt(i), ev, false);
                    if (horizontalScrollViewFindDeepestScrollViewForMotionEvent != null) {
                        return horizontalScrollViewFindDeepestScrollViewForMotionEvent;
                    }
                }
            }
            return null;
        }
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
            Point lastStateUpdateScroll = value.getLastStateUpdateScroll();
            restoreScrollTo(lastStateUpdateScroll.x, lastStateUpdateScroll.y);
        }
    }

    private final void initView() {
        this._overflowInset = new Rect();
        this._virtualViewContainerState = null;
        this.activelyScrolling = false;
        this.clippingRect = null;
        this._overflow = ReactNativeFeatureFlags.enablePropsUpdateReconciliationAndroid() ? Overflow.VISIBLE : Overflow.SCROLL;
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
        this.pagedArrowScrolling = false;
        this.pendingContentOffsetX = -1;
        this.pendingContentOffsetY = -1;
        setStateWrapper(null);
        this._reactScrollViewScrollState = new ReactScrollViewHelper.ReactScrollViewScrollState(null, 0, 0, null, false, false, 0.0f, false, 255, null);
        setPointerEvents(PointerEvents.AUTO);
        setLastScrollDispatchTime(0L);
        setScrollEventThrottle(0);
        this.contentView = null;
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

    @Override // android.view.View
    public boolean canScrollHorizontally(int direction) {
        return getScrollEnabled() && super.canScrollHorizontally(direction);
    }

    private final OverScroller getOverScrollerFromParent() {
        if (!triedToGetScrollerField) {
            triedToGetScrollerField = true;
            try {
                Field declaredField = HorizontalScrollView.class.getDeclaredField("mScroller");
                scrollerField = declaredField;
                if (declaredField != null) {
                    declaredField.setAccessible(true);
                }
            } catch (NoSuchFieldException unused) {
                FLog.w(TAG, "Failed to get mScroller field for HorizontalScrollView! This app will exhibit the bounce-back scrolling bug :(");
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
            FLog.w(TAG, "Failed to cast mScroller field in HorizontalScrollView (probably due to OEM changes to AOSP)! This app will exhibit the bounce-back scrolling bug :(");
            return null;
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Failed to get mScroller from HorizontalScrollView!", e);
        }
    }

    public void setScrollPerfTag(String scrollPerfTag) {
        this.scrollPerfTag = scrollPerfTag;
    }

    public void setDisableIntervalMomentum(boolean disableIntervalMomentum) {
        this.disableIntervalMomentum = disableIntervalMomentum;
    }

    public void setSendMomentumEvents(boolean sendMomentumEvents) {
        this.sendMomentumEvents = sendMomentumEvents;
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

    @Override // android.widget.HorizontalScrollView, android.view.View
    protected float getLeftFadingEdgeStrength() {
        return (getLayoutDirection() == 1 ? getFadingEdgeLengthEnd() : getFadingEdgeLengthStart()) / Math.max(getFadingEdgeLengthStart(), getFadingEdgeLengthEnd());
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    protected float getRightFadingEdgeStrength() {
        return (getLayoutDirection() == 1 ? getFadingEdgeLengthStart() : getFadingEdgeLengthEnd()) / Math.max(getFadingEdgeLengthStart(), getFadingEdgeLengthEnd());
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
        if (config != null && this.maintainVisibleContentPositionHelper == null) {
            MaintainVisibleScrollPositionHelper<ReactHorizontalScrollView> maintainVisibleScrollPositionHelper = new MaintainVisibleScrollPositionHelper<>(this, true);
            this.maintainVisibleContentPositionHelper = maintainVisibleScrollPositionHelper;
            maintainVisibleScrollPositionHelper.start();
        } else if (config == null) {
            MaintainVisibleScrollPositionHelper<ReactHorizontalScrollView> maintainVisibleScrollPositionHelper2 = this.maintainVisibleContentPositionHelper;
            if (maintainVisibleScrollPositionHelper2 != null) {
                maintainVisibleScrollPositionHelper2.stop();
            }
            this.maintainVisibleContentPositionHelper = null;
        }
        MaintainVisibleScrollPositionHelper<ReactHorizontalScrollView> maintainVisibleScrollPositionHelper3 = this.maintainVisibleContentPositionHelper;
        if (maintainVisibleScrollPositionHelper3 != null) {
            maintainVisibleScrollPositionHelper3.setConfig(config);
        }
    }

    @Override // com.facebook.react.uimanager.ReactOverflowViewWithInset
    public void setOverflowInset(int left, int top, int right, int bottom) {
        this._overflowInset.set(left, top, right, bottom);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this._overflow != Overflow.VISIBLE) {
            BackgroundStyleApplicator.clipToPaddingBox(this, canvas);
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        OverScroller overScroller;
        MeasureSpecAssertions.assertExplicitMeasureSpec(widthMeasureSpec, heightMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        if (DEBUG_MODE) {
            FLog.i(TAG, "onMeasure[%d] measured width: %d measured height: %d", Integer.valueOf(getId()), Integer.valueOf(size), Integer.valueOf(size2));
        }
        boolean z = getMeasuredHeight() != size2;
        setMeasuredDimension(size, size2);
        if (!z || (overScroller = this.scroller) == null) {
            return;
        }
        this.scrollXAfterMeasure = overScroller.getCurrX();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        OverScroller overScroller;
        boolean z = DEBUG_MODE;
        if (z) {
            FLog.i(TAG, "onLayout[%d] l %d t %d r %d b %d", Integer.valueOf(getId()), Integer.valueOf(l), Integer.valueOf(t), Integer.valueOf(r), Integer.valueOf(b));
        }
        int i = this.scrollXAfterMeasure;
        if (i != Integer.MIN_VALUE && (overScroller = this.scroller) != null && i != overScroller.getFinalX() && !this.scroller.isFinished()) {
            if (z) {
                FLog.i(TAG, "onLayout[%d] scroll hack enabled: reset to previous scrollX position of %d", Integer.valueOf(getId()), Integer.valueOf(this.scrollXAfterMeasure));
            }
            OverScroller overScroller2 = this.scroller;
            overScroller2.startScroll(this.scrollXAfterMeasure, overScroller2.getFinalY(), 0, 0);
            this.scroller.forceFinished(true);
            this.scrollXAfterMeasure = Integer.MIN_VALUE;
        }
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

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View child, View focused) {
        Intrinsics.checkNotNullParameter(child, "child");
        if (focused != null && !this.pagingEnabled && this.scrollsChildToFocus) {
            scrollToChild(focused);
        }
        requestChildFocusWithoutScroll(child, focused);
    }

    protected void requestChildFocusWithoutScroll(View child, View focused) {
        Intrinsics.checkNotNullParameter(child, "child");
        super.requestChildFocus(child, focused);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View child, Rect rectangle, boolean immediate) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(rectangle, "rectangle");
        if (this.scrollsChildToFocus) {
            return super.requestChildRectangleOnScreen(child, rectangle, immediate);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> views, int direction, int focusableMode) {
        Intrinsics.checkNotNullParameter(views, "views");
        if (this.pagingEnabled && !this.pagedArrowScrolling) {
            ArrayList arrayList = new ArrayList();
            super.addFocusables(arrayList, direction, focusableMode);
            Iterator it = arrayList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                View view = (View) next;
                if (isScrolledInView(view) || isPartiallyScrolledInView(view) || view.isFocused()) {
                    views.add(view);
                }
            }
            return;
        }
        super.addFocusables(views, direction, focusableMode);
    }

    private final int getScrollDelta(View descendent) {
        descendent.getDrawingRect(this.tempRect);
        offsetDescendantRectToMyCoords(descendent, this.tempRect);
        return computeScrollDeltaToGetChildRectOnScreen(this.tempRect);
    }

    private final boolean isScrolledInView(View descendent) {
        return getScrollDelta(descendent) == 0;
    }

    @Override // com.facebook.react.views.scroll.ReactAccessibleScrollView
    public boolean isPartiallyScrolledInView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        int scrollDelta = getScrollDelta(view);
        view.getDrawingRect(this.tempRect);
        return scrollDelta != 0 && Math.abs(scrollDelta) < this.tempRect.width();
    }

    private final boolean isMostlyScrolledInView(View descendent) {
        int scrollDelta = getScrollDelta(descendent);
        descendent.getDrawingRect(this.tempRect);
        return scrollDelta != 0 && Math.abs(scrollDelta) < this.tempRect.width() / 2;
    }

    private final void scrollToChild(View child) {
        int scrollDelta = getScrollDelta(child);
        if (scrollDelta != 0) {
            scrollBy(scrollDelta, 0);
        }
    }

    @Override // android.view.View
    protected void onScrollChanged(int x, int y, int oldX, int oldY) {
        if (DEBUG_MODE) {
            FLog.i(TAG, "onScrollChanged[%d] x %d y %d oldx %d oldy %d", Integer.valueOf(getId()), Integer.valueOf(x), Integer.valueOf(y), Integer.valueOf(oldX), Integer.valueOf(oldY));
        }
        Systrace.beginSection(0L, "ReactHorizontalScrollView.onScrollChanged");
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

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        Boolean hasChildPressedStateDelay = getHasChildPressedStateDelay();
        return hasChildPressedStateDelay != null ? hasChildPressedStateDelay.booleanValue() : super.shouldDelayChildPressedState();
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (!getScrollEnabled()) {
            return false;
        }
        if (ev.getAction() == 0 && Companion.findDeepestScrollViewForMotionEvent(this, ev) != null) {
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

    @Override // android.widget.HorizontalScrollView
    public boolean pageScroll(int direction) {
        boolean zPageScroll = super.pageScroll(direction);
        if (this.pagingEnabled && zPageScroll) {
            handlePostTouchScrolling(0, 0);
        }
        return zPageScroll;
    }

    private final boolean isDescendantOf(View parent, View view) {
        if (view != null && parent != null) {
            for (ViewParent parent2 = view.getParent(); parent2 != null && parent2.getParent() != null; parent2 = parent2.getParent()) {
                if (parent2 == parent) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.widget.HorizontalScrollView
    public boolean arrowScroll(int direction) {
        if (this.pagingEnabled) {
            boolean z = true;
            this.pagedArrowScrolling = true;
            ReactHorizontalScrollView reactHorizontalScrollView = this;
            if (reactHorizontalScrollView.getChildCount() != 0) {
                View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(reactHorizontalScrollView, findFocus(), direction);
                View contentView = getContentView();
                if (viewFindNextFocus != null && isDescendantOf(contentView, viewFindNextFocus)) {
                    if (!isScrolledInView(viewFindNextFocus) && !isMostlyScrolledInView(viewFindNextFocus)) {
                        smoothScrollToNextPage(direction);
                    }
                    viewFindNextFocus.requestFocus();
                } else {
                    smoothScrollToNextPage(direction);
                }
            } else {
                z = false;
            }
            this.pagedArrowScrolling = false;
            return z;
        }
        return super.arrowScroll(direction);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (!getScrollEnabled() || !PointerEvents.INSTANCE.canBeTouchTarget(getPointerEvents())) {
            return false;
        }
        this.velocityHelper.calculateVelocity(ev);
        int actionMasked = ev.getActionMasked();
        if (actionMasked == 1 && this.dragging) {
            ReactHorizontalScrollView reactHorizontalScrollView = this;
            ReactScrollViewHelper.updateFabricScrollState(reactHorizontalScrollView);
            float xVelocity = this.velocityHelper.getXVelocity();
            float yVelocity = this.velocityHelper.getYVelocity();
            ReactScrollViewHelper.emitScrollEndDragEvent(reactHorizontalScrollView, xVelocity, yVelocity);
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
            final float axisValue = ev.getAxisValue(10);
            if (axisValue != 0.0f) {
                enableFpsListener();
                boolean zDispatchGenericMotionEvent = super.dispatchGenericMotionEvent(ev);
                if (zDispatchGenericMotionEvent && (this.pagingEnabled || this.snapInterval != 0 || this.snapOffsets != null || this.snapToAlignment != 0)) {
                    Runnable runnable = this.postTouchRunnable;
                    if (runnable != null) {
                        removeCallbacks(runnable);
                        this.postTouchRunnable = null;
                    }
                    Runnable runnable2 = new Runnable() { // from class: com.facebook.react.views.scroll.ReactHorizontalScrollView$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            ReactHorizontalScrollView.dispatchGenericMotionEvent$lambda$2(this.f$0, axisValue);
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

    static final void dispatchGenericMotionEvent$lambda$2(ReactHorizontalScrollView reactHorizontalScrollView, float f) {
        reactHorizontalScrollView.postTouchRunnable = null;
        int iSignum = (int) Math.signum(f);
        if (reactHorizontalScrollView.disableIntervalMomentum) {
            iSignum = 0;
        }
        reactHorizontalScrollView.flingAndSnap(iSignum);
        reactHorizontalScrollView.handlePostTouchScrolling(iSignum, 0);
    }

    @Override // android.widget.HorizontalScrollView
    public boolean executeKeyEvent(KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int keyCode = event.getKeyCode();
        if (getScrollEnabled() || !(keyCode == 21 || keyCode == 22)) {
            return super.executeKeyEvent(event);
        }
        return false;
    }

    @Override // android.widget.HorizontalScrollView
    public void fling(int velocityX) {
        if (DEBUG_MODE) {
            FLog.i(TAG, "fling[%d] velocityX %d", Integer.valueOf(getId()), Integer.valueOf(velocityX));
        }
        if (Build.VERSION.SDK_INT == 28) {
            velocityX = (int) (Math.abs(velocityX) * Math.signum(this.onScrollDispatchHelper.getXFlingVelocity()));
        }
        int i = velocityX;
        if (this.pagingEnabled) {
            flingAndSnap(i);
        } else if (this.scroller != null) {
            this.scroller.fling(getScrollX(), getScrollY(), i, 0, 0, Integer.MAX_VALUE, 0, 0, ((getWidth() - getPaddingStart()) - getPaddingEnd()) / 2, 0);
            postInvalidateOnAnimation();
        } else {
            super.fling(i);
        }
        handlePostTouchScrolling(i, 0);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
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
        MaintainVisibleScrollPositionHelper<ReactHorizontalScrollView> maintainVisibleScrollPositionHelper = this.maintainVisibleContentPositionHelper;
        if (maintainVisibleScrollPositionHelper != null) {
            maintainVisibleScrollPositionHelper.start();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MaintainVisibleScrollPositionHelper<ReactHorizontalScrollView> maintainVisibleScrollPositionHelper = this.maintainVisibleContentPositionHelper;
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

    @Override // com.facebook.react.uimanager.ReactClippingViewGroup
    public void updateClippingRect() {
        updateClippingRect(null);
    }

    @Override // com.facebook.react.uimanager.ReactClippingViewGroup
    public void updateClippingRect(Set<Integer> excludedViews) {
        if (this._removeClippedSubviews) {
            Systrace.beginSection(0L, "ReactHorizontalScrollView.updateClippingRect");
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

    private final int getSnapInterval() {
        int i = this.snapInterval;
        return i != 0 ? i : getWidth();
    }

    private final View getContentView() {
        return getChildAt(0);
    }

    public void setEndFillColor(int color) {
        if (color != this.endFillColor) {
            this.endFillColor = color;
            this.endBackground = new ColorDrawable(color);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) {
        int iMax;
        if (DEBUG_MODE) {
            FLog.i(TAG, "onOverScrolled[%d] scrollX %d scrollY %d clampedX %b clampedY %b", Integer.valueOf(getId()), Integer.valueOf(scrollX), Integer.valueOf(scrollY), Boolean.valueOf(clampedX), Boolean.valueOf(clampedY));
        }
        OverScroller overScroller = this.scroller;
        if (overScroller != null && !overScroller.isFinished() && this.scroller.getCurrX() != this.scroller.getFinalX() && scrollX >= (iMax = Math.max(computeHorizontalScrollRange() - getWidth(), 0))) {
            this.scroller.abortAnimation();
            scrollX = iMax;
        }
        if (ReactNativeFeatureFlags.shouldTriggerResponderTransferOnScrollAndroid() && clampedX && !this.emittedOverScrollSinceScrollBegin) {
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

    private final void enableFpsListener() {
        FpsListener fpsListener;
        if (!isScrollPerfLoggingEnabled() || (fpsListener = this.fpsListener) == null) {
            return;
        }
        String str = this.scrollPerfTag;
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            str = null;
        }
        if (str == null) {
            return;
        }
        fpsListener.enable(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void disableFpsListener() {
        FpsListener fpsListener;
        if (!isScrollPerfLoggingEnabled() || (fpsListener = this.fpsListener) == null) {
            return;
        }
        String str = this.scrollPerfTag;
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            str = null;
        }
        if (str == null) {
            return;
        }
        fpsListener.disable(str);
    }

    private final boolean isScrollPerfLoggingEnabled() {
        String str;
        return (this.fpsListener == null || (str = this.scrollPerfTag) == null || str.length() == 0) ? false : true;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.endFillColor != 0) {
            View contentView = getContentView();
            Drawable drawable = this.endBackground;
            if (drawable != null && contentView != null && contentView.getRight() < getWidth()) {
                drawable.setBounds(contentView.getRight(), 0, getWidth(), getHeight());
                drawable.draw(canvas);
            }
        }
        super.draw(canvas);
    }

    private final void handlePostTouchScrolling(int velocityX, int velocityY) {
        if (DEBUG_MODE) {
            FLog.i(TAG, "handlePostTouchScrolling[%d] velocityX %d velocityY %d", Integer.valueOf(getId()), Integer.valueOf(velocityX), Integer.valueOf(velocityY));
        }
        if (this.postTouchRunnable != null) {
            return;
        }
        if (this.sendMomentumEvents) {
            ReactScrollViewHelper.emitScrollMomentumBeginEvent(this, velocityX, velocityY);
        }
        this.activelyScrolling = false;
        Runnable runnable = new Runnable() { // from class: com.facebook.react.views.scroll.ReactHorizontalScrollView.handlePostTouchScrolling.1
            private boolean snappingToPage;
            private int stableFrames;

            @Override // java.lang.Runnable
            public void run() {
                boolean z = ReactHorizontalScrollView.this.activelyScrolling;
                ReactHorizontalScrollView reactHorizontalScrollView = ReactHorizontalScrollView.this;
                if (z) {
                    reactHorizontalScrollView.activelyScrolling = false;
                    this.stableFrames = 0;
                    ReactHorizontalScrollView.this.postOnAnimationDelayed(this, 20L);
                    return;
                }
                ReactScrollViewHelper.updateFabricScrollState(reactHorizontalScrollView);
                int i = this.stableFrames + 1;
                this.stableFrames = i;
                ReactHorizontalScrollView reactHorizontalScrollView2 = ReactHorizontalScrollView.this;
                if (i >= 3) {
                    reactHorizontalScrollView2.postTouchRunnable = null;
                    if (ReactHorizontalScrollView.this.sendMomentumEvents) {
                        ReactScrollViewHelper.emitScrollMomentumEndEvent(ReactHorizontalScrollView.this);
                    }
                    ReactScrollViewHelper.notifyUserDrivenScrollEnded_internal(ReactHorizontalScrollView.this);
                    ReactHorizontalScrollView.this.disableFpsListener();
                    return;
                }
                if (reactHorizontalScrollView2.pagingEnabled && !this.snappingToPage) {
                    this.snappingToPage = true;
                    ReactHorizontalScrollView.this.flingAndSnap(0);
                }
                ReactHorizontalScrollView.this.postOnAnimationDelayed(this, 20L);
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

    private final int predictFinalScrollPosition(int velocityX) {
        int iMax = Math.max(0, computeHorizontalScrollRange() - getWidth());
        if (getDefaultFlingAnimator() == this.defaultFlingAnimator) {
            return ReactScrollViewHelper.predictFinalScrollPosition(this, velocityX, 0, iMax, 0).x;
        }
        return ReactScrollViewHelper.getNextFlingStartValue(this, getScrollX(), get_reactScrollViewScrollState().getFinalAnimatedPositionScroll().x, velocityX) + getFlingExtrapolatedDistance(velocityX);
    }

    private final void smoothScrollAndSnap(int velocity) {
        if (DEBUG_MODE) {
            FLog.i(TAG, "smoothScrollAndSnap[%d] velocity %d", Integer.valueOf(getId()), Integer.valueOf(velocity));
        }
        double snapInterval = getSnapInterval();
        double nextFlingStartValue = ReactScrollViewHelper.getNextFlingStartValue(this, getScrollX(), get_reactScrollViewScrollState().getFinalAnimatedPositionScroll().x, velocity);
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
        reactSmoothScrollTo((int) d2, getScrollY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void flingAndSnap(int velocityX) {
        int scrollX;
        int iFloor;
        int iMin;
        int iIntValue;
        int iIntValue2;
        OverScroller overScroller;
        if (DEBUG_MODE) {
            FLog.i(TAG, "smoothScrollAndSnap[%d] velocityX %d", Integer.valueOf(getId()), Integer.valueOf(velocityX));
        }
        if (getChildCount() == 0) {
            return;
        }
        if (this.snapInterval == 0 && this.snapOffsets == null && this.snapToAlignment == 0) {
            smoothScrollAndSnap(velocityX);
            return;
        }
        boolean z = getDefaultFlingAnimator() != this.defaultFlingAnimator;
        int iMax = Math.max(0, computeHorizontalScrollRange() - getWidth());
        int iPredictFinalScrollPosition = predictFinalScrollPosition(velocityX);
        if (this.disableIntervalMomentum) {
            iPredictFinalScrollPosition = getScrollX();
        }
        int width = (getWidth() - getPaddingStart()) - getPaddingEnd();
        if (getLayoutDirection() == 1) {
            iPredictFinalScrollPosition = iMax - iPredictFinalScrollPosition;
            scrollX = -velocityX;
        } else {
            scrollX = velocityX;
        }
        List<Integer> list = this.snapOffsets;
        List<Integer> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            iIntValue2 = list.get(0).intValue();
            iIntValue = list.get(list.size() - 1).intValue();
            int size = list2.size();
            iMin = iMax;
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
                    iFloor = Math.max(getItemStartOffset(i2, (int) (dFloor * ((double) i4)), i4, width), 0);
                    int i5 = this.snapToAlignment;
                    double dCeil = Math.ceil(d);
                    int i6 = this.snapInterval;
                    iMin = Math.min(getItemStartOffset(i5, (int) (dCeil * ((double) i6)), i6, width), iMax);
                } else {
                    View contentView = getContentView();
                    ViewGroup viewGroup = contentView instanceof ViewGroup ? (ViewGroup) contentView : null;
                    if (viewGroup == null) {
                        return;
                    }
                    int childCount = viewGroup.getChildCount();
                    int iMin2 = iMax;
                    int i7 = iMin2;
                    int i8 = 0;
                    int iMax2 = 0;
                    for (int i9 = 0; i9 < childCount; i9++) {
                        View childAt = viewGroup.getChildAt(i9);
                        int itemStartOffset = getItemStartOffset(this.snapToAlignment, childAt.getLeft(), childAt.getWidth(), width);
                        if (itemStartOffset <= iPredictFinalScrollPosition && iPredictFinalScrollPosition - itemStartOffset < iPredictFinalScrollPosition - i8) {
                            i8 = itemStartOffset;
                        }
                        if (itemStartOffset >= iPredictFinalScrollPosition && itemStartOffset - iPredictFinalScrollPosition < i7 - iPredictFinalScrollPosition) {
                            i7 = itemStartOffset;
                        }
                        iMin2 = Math.min(iMin2, itemStartOffset);
                        iMax2 = Math.max(iMax2, itemStartOffset);
                    }
                    iFloor = Math.max(i8, iMin2);
                    iMin = Math.min(i7, iMax2);
                }
            } else {
                double snapInterval = getSnapInterval();
                double d2 = ((double) iPredictFinalScrollPosition) / snapInterval;
                iFloor = (int) (Math.floor(d2) * snapInterval);
                iMin = Math.min((int) (Math.ceil(d2) * snapInterval), iMax);
            }
            iIntValue = iMax;
            iIntValue2 = 0;
        }
        int i10 = iPredictFinalScrollPosition - iFloor;
        int i11 = iMin - iPredictFinalScrollPosition;
        int i12 = Math.abs(i10) < Math.abs(i11) ? iFloor : iMin;
        int scrollX2 = getScrollX();
        if (getLayoutDirection() == 1) {
            scrollX2 = iMax - scrollX2;
        }
        if (this.snapToEnd || iPredictFinalScrollPosition < iIntValue) {
            if (this.snapToStart || iPredictFinalScrollPosition > iIntValue2) {
                if (scrollX > 0) {
                    if (!z) {
                        scrollX += (int) (((double) i11) * 10.0d);
                    }
                    iPredictFinalScrollPosition = iMin;
                } else if (scrollX < 0) {
                    if (!z) {
                        scrollX -= (int) (((double) i10) * 10.0d);
                    }
                    iPredictFinalScrollPosition = iFloor;
                } else {
                    iPredictFinalScrollPosition = i12;
                }
            } else if (scrollX2 > iIntValue2) {
                iPredictFinalScrollPosition = iIntValue2;
            }
        } else if (scrollX2 < iIntValue) {
            iPredictFinalScrollPosition = iIntValue;
        }
        int iMin3 = Math.min(Math.max(0, iPredictFinalScrollPosition), iMax);
        if (getLayoutDirection() == 1) {
            iMin3 = iMax - iMin3;
            scrollX = -scrollX;
        }
        if (z || (overScroller = this.scroller) == null) {
            reactSmoothScrollTo(iMin3, getScrollY());
            return;
        }
        this.activelyScrolling = true;
        int scrollX3 = getScrollX();
        int scrollY = getScrollY();
        if (scrollX == 0) {
            scrollX = iMin3 - getScrollX();
        }
        overScroller.fling(scrollX3, scrollY, scrollX, 0, iMin3, iMin3, 0, 0, (iMin3 == 0 || iMin3 == iMax) ? width / 2 : 0, 0);
        postInvalidateOnAnimation();
    }

    private final int getItemStartOffset(int snapToAlignment, int itemStartPosition, int itemWidth, int viewPortWidth) {
        int i;
        if (snapToAlignment == 1) {
            return itemStartPosition;
        }
        if (snapToAlignment == 2) {
            i = (viewPortWidth - itemWidth) / 2;
        } else {
            if (snapToAlignment != 3) {
                throw new IllegalStateException("Invalid SnapToAlignment value: " + this.snapToAlignment);
            }
            i = viewPortWidth - itemWidth;
        }
        return itemStartPosition - i;
    }

    private final void smoothScrollToNextPage(int direction) {
        if (DEBUG_MODE) {
            FLog.i(TAG, "smoothScrollToNextPage[%d] direction %d", Integer.valueOf(getId()), Integer.valueOf(direction));
        }
        int width = getWidth();
        int scrollX = getScrollX();
        int i = scrollX / width;
        if (scrollX % width != 0) {
            i++;
        }
        int i2 = direction == 17 ? i - 1 : i + 1;
        if (i2 < 0) {
            i2 = 0;
        }
        reactSmoothScrollTo(i2 * width, getScrollY());
        handlePostTouchScrolling(0, 0);
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

    @Override // com.facebook.react.views.scroll.ReactScrollViewHelper.HasSmoothScroll
    public void reactSmoothScrollTo(int x, int y) {
        ReactScrollViewHelper.smoothScrollTo(this, x, y);
        setPendingContentOffsets(x, y);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void scrollTo(int x, int y) {
        if (DEBUG_MODE) {
            FLog.i(TAG, "scrollTo[%d] x %d y %d", Integer.valueOf(getId()), Integer.valueOf(x), Integer.valueOf(y));
        }
        super.scrollTo(x, y);
        ReactScrollViewHelper.updateFabricScrollState(this);
        setPendingContentOffsets(x, y);
    }

    @Override // com.facebook.react.views.scroll.ReactScrollViewHelper.HasSmoothScroll
    public void scrollToPreservingMomentum(int x, int y) {
        scrollTo(x, y);
        recreateFlingAnimation(x, Integer.MAX_VALUE);
    }

    protected void restoreScrollTo(int x, int y) {
        scrollTo(x, y);
    }

    private final boolean isContentReady() {
        View contentView = getContentView();
        return (contentView == null || contentView.getWidth() == 0 || contentView.getHeight() == 0) ? false : true;
    }

    private final void setPendingContentOffsets(int x, int y) {
        if (DEBUG_MODE) {
            FLog.i(TAG, "setPendingContentOffsets[%d] x %d y %d", Integer.valueOf(getId()), Integer.valueOf(x), Integer.valueOf(y));
        }
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
        if (v.getLayoutDirection() == 1) {
            adjustPositionForContentChangeRTL(left, right, oldLeft, oldRight);
        }
        ReactScrollViewHelper.emitLayoutChangeEvent(this);
    }

    private final void recreateFlingAnimation(int scrollX, int maxX) {
        if (getDefaultFlingAnimator().isRunning()) {
            getDefaultFlingAnimator().cancel();
        }
        OverScroller overScroller = this.scroller;
        if (overScroller == null || overScroller.isFinished()) {
            return;
        }
        int currX = this.scroller.getCurrX();
        boolean zComputeScrollOffset = this.scroller.computeScrollOffset();
        this.scroller.forceFinished(true);
        OverScroller overScroller2 = this.scroller;
        if (zComputeScrollOffset) {
            this.scroller.fling(scrollX, getScrollY(), (int) (this.scroller.getCurrVelocity() * Math.signum(overScroller2.getFinalX() - this.scroller.getStartX())), 0, 0, maxX, 0, 0);
            return;
        }
        scrollTo((overScroller2.getCurrX() - currX) + scrollX, getScrollY());
    }

    private final void adjustPositionForContentChangeRTL(int left, int right, int oldLeft, int oldRight) {
        if (getDefaultFlingAnimator().isRunning()) {
            getDefaultFlingAnimator().end();
        }
        int i = right - left;
        int scrollX = i - (oldRight - getScrollX());
        scrollTo(scrollX, getScrollY());
        recreateFlingAnimation(scrollX, i - getWidth());
    }

    @Override // com.facebook.react.views.scroll.ReactScrollViewHelper.HasFlingAnimator
    public void startFlingAnimator(int start, int end) {
        this.defaultFlingAnimator.cancel();
        int defaultScrollAnimationDuration = ReactScrollViewHelper.getDefaultScrollAnimationDuration(getContext());
        this.defaultFlingAnimator.setDuration(defaultScrollAnimationDuration).setIntValues(start, end);
        this.defaultFlingAnimator.start();
        if (this.sendMomentumEvents) {
            ReactHorizontalScrollView reactHorizontalScrollView = this;
            ReactScrollViewHelper.emitScrollMomentumBeginEvent(reactHorizontalScrollView, defaultScrollAnimationDuration > 0 ? (end - start) / defaultScrollAnimationDuration : 0, 0);
            ReactScrollViewHelper.dispatchMomentumEndOnAnimationEnd(reactHorizontalScrollView);
        }
    }

    @Override // com.facebook.react.views.scroll.ReactScrollViewHelper.HasFlingAnimator
    /* JADX INFO: renamed from: getFlingAnimator, reason: from getter */
    public ValueAnimator getDefaultFlingAnimator() {
        return this.defaultFlingAnimator;
    }

    @Override // com.facebook.react.views.scroll.ReactScrollViewHelper.HasFlingAnimator
    public int getFlingExtrapolatedDistance(int velocity) {
        return ReactScrollViewHelper.predictFinalScrollPosition(this, velocity, 0, Math.max(0, computeHorizontalScrollRange() - getWidth()), 0).x;
    }
}
