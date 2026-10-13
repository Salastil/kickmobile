package com.swmansion.rnscreens.gamma.stack.header.config;

import android.graphics.drawable.Drawable;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UIManagerListener;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.views.view.ReactViewGroup;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mux.stats.sdk.core.model.ViewDeviceOrientationData;
import com.swmansion.rnscreens.gamma.common.ShadowStateProxy;
import com.swmansion.rnscreens.gamma.helpers.IconResolution;
import com.swmansion.rnscreens.gamma.helpers.ImageLoaderKt;
import com.swmansion.rnscreens.gamma.helpers.PropIconResolver;
import com.swmansion.rnscreens.gamma.helpers.UIManagerHelperExtKt;
import com.swmansion.rnscreens.gamma.stack.header.subview.OnStackHeaderSubviewChangeListener;
import com.swmansion.rnscreens.gamma.stack.header.subview.StackHeaderSubview;
import com.swmansion.rnscreens.gamma.stack.header.subview.StackHeaderSubviewType;
import com.swmansion.rnscreens.gamma.stack.header.toolbar.StackHeaderToolbarFieldUpdate;
import com.swmansion.rnscreens.gamma.stack.header.toolbar.StackHeaderToolbarMenuConfig;
import com.swmansion.rnscreens.gamma.stack.header.toolbar.StackHeaderToolbarMenuElementRawUpdate;
import com.swmansion.rnscreens.gamma.stack.header.toolbar.StackHeaderToolbarMenuIconResolver;
import com.swmansion.rnscreens.gamma.stack.header.toolbar.StackHeaderToolbarMenuItemIconSource;
import com.swmansion.rnscreens.gamma.stack.header.toolbar.StackHeaderToolbarMenuUpdateQueue;
import com.swmansion.rnscreens.gamma.stack.header.toolbar.StackHeaderToolbarMenuUpdateQueueDelegate;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: StackHeaderConfig.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0016J\u0017\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001a\u0010\u0016J\u0017\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001c\u0010\u0016J\b\u0010\u001d\u001a\u00020\u000fH\u0002J\r\u0010{\u001a\u00020\u000fH\u0000¢\u0006\u0002\b|J\u000f\u0010\u0086\u0001\u001a\u00020\u000fH\u0000¢\u0006\u0003\b\u0087\u0001J\u001d\u0010\u0088\u0001\u001a\u00020\u000f2\u0007\u0010\u0089\u0001\u001a\u00020'2\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010LH\u0002J\t\u0010\u009e\u0001\u001a\u00020\u000fH\u0016J\u0019\u0010\u009f\u0001\u001a\u00020\u000f2\b\u0010 \u0001\u001a\u00030\u008b\u0001H\u0000¢\u0006\u0003\b¡\u0001J\u0019\u0010¢\u0001\u001a\u00020\u000f2\b\u0010 \u0001\u001a\u00030\u008b\u0001H\u0000¢\u0006\u0003\b£\u0001J\u0018\u0010¤\u0001\u001a\u00020\u000f2\u0007\u0010¥\u0001\u001a\u00020=H\u0000¢\u0006\u0003\b¦\u0001J\u000f\u0010§\u0001\u001a\u00020\u000fH\u0000¢\u0006\u0003\b¨\u0001J\u001b\u0010«\u0001\u001a\u0005\u0018\u00010\u008b\u00012\u0007\u0010¥\u0001\u001a\u00020=H\u0000¢\u0006\u0003\b¬\u0001J\u0011\u0010\u00ad\u0001\u001a\n\u0012\u0005\u0012\u00030\u008b\u00010®\u0001H\u0002J$\u0010¹\u0001\u001a\u00020\u000f2\u0007\u0010º\u0001\u001a\u00020=2\u0007\u0010»\u0001\u001a\u00020=2\u0007\u0010¼\u0001\u001a\u00020=H\u0016J\u0012\u0010½\u0001\u001a\u00020\u000f2\u0007\u0010\u0089\u0001\u001a\u00020'H\u0016J\"\u0010¾\u0001\u001a\u00020\u000f2\u0007\u0010¿\u0001\u001a\u00020'2\u000e\u0010À\u0001\u001a\t\u0012\u0004\u0012\u00020'0®\u0001H\u0016J$\u0010Á\u0001\u001a\u00020\u000f2\u0007\u0010 \u001a\u00030Â\u00012\u0007\u0010Ã\u0001\u001a\u00020=2\u0007\u0010Ä\u0001\u001a\u00020=H\u0016J\u000f\u0010Ë\u0001\u001a\u00020\u000fH\u0000¢\u0006\u0003\bÌ\u0001J \u0010Ñ\u0001\u001a\u00020\u000f2\u000f\u0010Ò\u0001\u001a\n\u0012\u0005\u0012\u00030Ó\u00010®\u0001H\u0000¢\u0006\u0003\bÔ\u0001J\u0013\u0010Ö\u0001\u001a\u00020\u000f2\b\u0010×\u0001\u001a\u00030Ø\u0001H\u0016J\u0013\u0010Ù\u0001\u001a\u00020\u000f2\b\u0010×\u0001\u001a\u00030Ø\u0001H\u0016J\u0013\u0010Ú\u0001\u001a\u00020\u000f2\b\u0010×\u0001\u001a\u00030Ø\u0001H\u0016J\u0013\u0010Û\u0001\u001a\u00020\u000f2\b\u0010×\u0001\u001a\u00030Ø\u0001H\u0016J\u0013\u0010Ü\u0001\u001a\u00020\u000f2\b\u0010×\u0001\u001a\u00030Ø\u0001H\u0016J\u000f\u0010Ý\u0001\u001a\u00020\u000fH\u0000¢\u0006\u0003\bÞ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u00020\u0012X\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R+\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001f8V@PX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R+\u0010(\u001a\u00020'2\u0006\u0010\u001e\u001a\u00020'8V@PX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b-\u0010&\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R+\u0010/\u001a\u00020.2\u0006\u0010\u001e\u001a\u00020.8V@PX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b4\u0010&\u001a\u0004\b0\u00101\"\u0004\b2\u00103R+\u00105\u001a\u00020.2\u0006\u0010\u001e\u001a\u00020.8V@PX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b8\u0010&\u001a\u0004\b6\u00101\"\u0004\b7\u00103R+\u00109\u001a\u00020.2\u0006\u0010\u001e\u001a\u00020.8V@PX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b<\u0010&\u001a\u0004\b:\u00101\"\u0004\b;\u00103R/\u0010>\u001a\u0004\u0018\u00010=2\b\u0010\u001e\u001a\u0004\u0018\u00010=8V@PX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bC\u0010&\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR/\u0010D\u001a\u0004\u0018\u00010=2\b\u0010\u001e\u001a\u0004\u0018\u00010=8V@PX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bG\u0010&\u001a\u0004\bE\u0010@\"\u0004\bF\u0010BR/\u0010H\u001a\u0004\u0018\u00010=2\b\u0010\u001e\u001a\u0004\u0018\u00010=8V@PX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bK\u0010&\u001a\u0004\bI\u0010@\"\u0004\bJ\u0010BR/\u0010M\u001a\u0004\u0018\u00010L2\b\u0010\u001e\u001a\u0004\u0018\u00010L8V@PX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bR\u0010&\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR+\u0010S\u001a\u00020.2\u0006\u0010\u001e\u001a\u00020.8V@PX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bV\u0010&\u001a\u0004\bT\u00101\"\u0004\bU\u00103R+\u0010W\u001a\u00020.2\u0006\u0010\u001e\u001a\u00020.8V@PX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bZ\u0010&\u001a\u0004\bX\u00101\"\u0004\bY\u00103R+\u0010[\u001a\u00020.2\u0006\u0010\u001e\u001a\u00020.8V@PX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b^\u0010&\u001a\u0004\b\\\u00101\"\u0004\b]\u00103R+\u0010_\u001a\u00020.2\u0006\u0010\u001e\u001a\u00020.8V@PX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bb\u0010&\u001a\u0004\b`\u00101\"\u0004\ba\u00103R+\u0010c\u001a\u00020.2\u0006\u0010\u001e\u001a\u00020.8V@PX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bf\u0010&\u001a\u0004\bd\u00101\"\u0004\be\u00103R+\u0010h\u001a\u00020g2\u0006\u0010\u001e\u001a\u00020g8V@PX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bm\u0010&\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR+\u0010n\u001a\u00020.2\u0006\u0010\u001e\u001a\u00020.8V@PX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bq\u0010&\u001a\u0004\bo\u00101\"\u0004\bp\u00103R\u0014\u0010r\u001a\u00020.8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\br\u00101R\u001c\u0010s\u001a\u0004\u0018\u00010'X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010*\"\u0004\bu\u0010,R\u001c\u0010v\u001a\u0004\u0018\u00010'X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010*\"\u0004\bx\u0010,R\u000e\u0010y\u001a\u00020zX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010}\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u007f0~X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001b\u0010\u0084\u0001\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020z0~X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0085\u0001\u001a\u0010\u0012\u0004\u0012\u00020'\u0012\u0006\u0012\u0004\u0018\u00010L0~X\u0082\u000e¢\u0006\u0002\n\u0000R7\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008b\u00012\t\u0010\u001e\u001a\u0005\u0018\u00010\u008b\u00018V@RX\u0096\u008e\u0002¢\u0006\u0017\n\u0005\b\u0091\u0001\u0010&\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001\"\u0006\b\u008f\u0001\u0010\u0090\u0001R7\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u008b\u00012\t\u0010\u001e\u001a\u0005\u0018\u00010\u008b\u00018V@RX\u0096\u008e\u0002¢\u0006\u0017\n\u0005\b\u0095\u0001\u0010&\u001a\u0006\b\u0093\u0001\u0010\u008e\u0001\"\u0006\b\u0094\u0001\u0010\u0090\u0001R7\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u008b\u00012\t\u0010\u001e\u001a\u0005\u0018\u00010\u008b\u00018V@RX\u0096\u008e\u0002¢\u0006\u0017\n\u0005\b\u0099\u0001\u0010&\u001a\u0006\b\u0097\u0001\u0010\u008e\u0001\"\u0006\b\u0098\u0001\u0010\u0090\u0001R7\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u008b\u00012\t\u0010\u001e\u001a\u0005\u0018\u00010\u008b\u00018V@RX\u0096\u008e\u0002¢\u0006\u0017\n\u0005\b\u009d\u0001\u0010&\u001a\u0006\b\u009b\u0001\u0010\u008e\u0001\"\u0006\b\u009c\u0001\u0010\u0090\u0001R\u0016\u0010©\u0001\u001a\u00020=8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\bª\u0001\u0010\u0014R\u0010\u0010¯\u0001\u001a\u00030°\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R8\u0010²\u0001\u001a\u0005\u0018\u00010±\u00012\t\u0010\u001e\u001a\u0005\u0018\u00010±\u00018@@@X\u0080\u008e\u0002¢\u0006\u0018\u001a\u0006\bµ\u0001\u0010¶\u0001\"\u0006\b·\u0001\u0010¸\u0001*\u0006\b³\u0001\u0010´\u0001R \u0010Å\u0001\u001a\u00030Æ\u0001X\u0080.¢\u0006\u0012\n\u0000\u001a\u0006\bÇ\u0001\u0010È\u0001\"\u0006\bÉ\u0001\u0010Ê\u0001R\u0010\u0010Í\u0001\u001a\u00030Î\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Ï\u0001\u001a\u00030Ð\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010Õ\u0001\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006ß\u0001"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/header/config/StackHeaderConfig;", "Lcom/facebook/react/views/view/ReactViewGroup;", "Lcom/swmansion/rnscreens/gamma/stack/header/config/StackHeaderConfigurationProviding;", "Lcom/swmansion/rnscreens/gamma/stack/header/config/StackHeaderDelegate;", "Lcom/swmansion/rnscreens/gamma/stack/header/subview/OnStackHeaderSubviewChangeListener;", "Lcom/facebook/react/bridge/UIManagerListener;", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "<init>", "(Lcom/facebook/react/uimanager/ThemedReactContext;)V", "getReactContext", "()Lcom/facebook/react/uimanager/ThemedReactContext;", "configObserver", "Lcom/swmansion/rnscreens/gamma/stack/header/config/StackHeaderConfigurationObserver;", "setConfigurationObserver", "", "observer", "invalidationFlags", "Lcom/swmansion/rnscreens/gamma/stack/header/config/StackHeaderInvalidationFlags;", "getInvalidationFlags-2a6ZA60", "()I", "setInvalidationFlags-gLpVZxs", "(I)V", "I", "clearInvalidationFlags", "flags", "clearInvalidationFlags-gLpVZxs", "invalidate", "invalidate-gLpVZxs", "flushUpdates", "<set-?>", "Lcom/swmansion/rnscreens/gamma/stack/header/config/StackHeaderType;", "type", "getType", "()Lcom/swmansion/rnscreens/gamma/stack/header/config/StackHeaderType;", "setType$react_native_screens_release", "(Lcom/swmansion/rnscreens/gamma/stack/header/config/StackHeaderType;)V", "type$delegate", "Lkotlin/properties/ReadWriteProperty;", "", "title", "getTitle", "()Ljava/lang/String;", "setTitle$react_native_screens_release", "(Ljava/lang/String;)V", "title$delegate", "", ViewProps.HIDDEN, "getHidden", "()Z", "setHidden$react_native_screens_release", "(Z)V", "hidden$delegate", "transparent", "getTransparent", "setTransparent$react_native_screens_release", "transparent$delegate", "backButtonHidden", "getBackButtonHidden", "setBackButtonHidden$react_native_screens_release", "backButtonHidden$delegate", "", "backButtonTintColorNormal", "getBackButtonTintColorNormal", "()Ljava/lang/Integer;", "setBackButtonTintColorNormal$react_native_screens_release", "(Ljava/lang/Integer;)V", "backButtonTintColorNormal$delegate", "backButtonTintColorPressed", "getBackButtonTintColorPressed", "setBackButtonTintColorPressed$react_native_screens_release", "backButtonTintColorPressed$delegate", "backButtonTintColorFocused", "getBackButtonTintColorFocused", "setBackButtonTintColorFocused$react_native_screens_release", "backButtonTintColorFocused$delegate", "Landroid/graphics/drawable/Drawable;", "backButtonIcon", "getBackButtonIcon", "()Landroid/graphics/drawable/Drawable;", "setBackButtonIcon$react_native_screens_release", "(Landroid/graphics/drawable/Drawable;)V", "backButtonIcon$delegate", "scrollFlagScroll", "getScrollFlagScroll", "setScrollFlagScroll$react_native_screens_release", "scrollFlagScroll$delegate", "scrollFlagEnterAlways", "getScrollFlagEnterAlways", "setScrollFlagEnterAlways$react_native_screens_release", "scrollFlagEnterAlways$delegate", "scrollFlagEnterAlwaysCollapsed", "getScrollFlagEnterAlwaysCollapsed", "setScrollFlagEnterAlwaysCollapsed$react_native_screens_release", "scrollFlagEnterAlwaysCollapsed$delegate", "scrollFlagExitUntilCollapsed", "getScrollFlagExitUntilCollapsed", "setScrollFlagExitUntilCollapsed$react_native_screens_release", "scrollFlagExitUntilCollapsed$delegate", "scrollFlagSnap", "getScrollFlagSnap", "setScrollFlagSnap$react_native_screens_release", "scrollFlagSnap$delegate", "Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuConfig;", "toolbarMenu", "getToolbarMenu", "()Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuConfig;", "setToolbarMenu$react_native_screens_release", "(Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuConfig;)V", "toolbarMenu$delegate", "toolbarMenuGroupDividerEnabled", "getToolbarMenuGroupDividerEnabled", "setToolbarMenuGroupDividerEnabled$react_native_screens_release", "toolbarMenuGroupDividerEnabled$delegate", "isRTL", "backButtonDrawableIconResourceName", "getBackButtonDrawableIconResourceName$react_native_screens_release", "setBackButtonDrawableIconResourceName$react_native_screens_release", "backButtonImageIconUri", "getBackButtonImageIconUri$react_native_screens_release", "setBackButtonImageIconUri$react_native_screens_release", "backButtonIconResolver", "Lcom/swmansion/rnscreens/gamma/helpers/PropIconResolver;", "resolveBackButtonIconIfNeeded", "resolveBackButtonIconIfNeeded$react_native_screens_release", "toolbarMenuItemIconSourceMap", "", "Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuItemIconSource;", "getToolbarMenuItemIconSourceMap$react_native_screens_release", "()Ljava/util/Map;", "setToolbarMenuItemIconSourceMap$react_native_screens_release", "(Ljava/util/Map;)V", "toolbarMenuItemIconResolvers", "toolbarMenuItemIcons", "resolveToolbarMenuItemIconsIfNeeded", "resolveToolbarMenuItemIconsIfNeeded$react_native_screens_release", "applyToolbarMenuItemIcon", "id", "icon", "Lcom/swmansion/rnscreens/gamma/stack/header/subview/StackHeaderSubview;", "backgroundSubview", "getBackgroundSubview", "()Lcom/swmansion/rnscreens/gamma/stack/header/subview/StackHeaderSubview;", "setBackgroundSubview", "(Lcom/swmansion/rnscreens/gamma/stack/header/subview/StackHeaderSubview;)V", "backgroundSubview$delegate", "leadingSubview", "getLeadingSubview", "setLeadingSubview", "leadingSubview$delegate", "centerSubview", "getCenterSubview", "setCenterSubview", "centerSubview$delegate", "trailingSubview", "getTrailingSubview", "setTrailingSubview", "trailingSubview$delegate", "onStackHeaderSubviewChanged", "addConfigSubview", "headerSubview", "addConfigSubview$react_native_screens_release", "removeConfigSubview", "removeConfigSubview$react_native_screens_release", "removeConfigSubviewAt", FirebaseAnalytics.Param.INDEX, "removeConfigSubviewAt$react_native_screens_release", "removeAllConfigSubviews", "removeAllConfigSubviews$react_native_screens_release", "configSubviewsCount", "getConfigSubviewsCount$react_native_screens_release", "getConfigSubviewAt", "getConfigSubviewAt$react_native_screens_release", "getListOfSubviews", "", "shadowStateProxy", "Lcom/swmansion/rnscreens/gamma/common/ShadowStateProxy;", "Lcom/facebook/react/uimanager/StateWrapper;", "stateWrapper", "getStateWrapper$react_native_screens_release$delegate", "(Lcom/swmansion/rnscreens/gamma/stack/header/config/StackHeaderConfig;)Ljava/lang/Object;", "getStateWrapper$react_native_screens_release", "()Lcom/facebook/react/uimanager/StateWrapper;", "setStateWrapper$react_native_screens_release", "(Lcom/facebook/react/uimanager/StateWrapper;)V", "onHeaderFrameChanged", ViewProps.WIDTH, ViewProps.HEIGHT, "contentOffsetY", "onMenuItemClicked", "onGroupSelectionChanged", "groupId", "selectedIds", "onSubviewOriginChanged", "Lcom/swmansion/rnscreens/gamma/stack/header/subview/StackHeaderSubviewType;", ViewDeviceOrientationData.DEVICE_ORIENTATION_X, ViewDeviceOrientationData.DEVICE_ORIENTATION_Y, "eventEmitter", "Lcom/swmansion/rnscreens/gamma/stack/header/config/StackHeaderConfigEventEmitter;", "getEventEmitter$react_native_screens_release", "()Lcom/swmansion/rnscreens/gamma/stack/header/config/StackHeaderConfigEventEmitter;", "setEventEmitter$react_native_screens_release", "(Lcom/swmansion/rnscreens/gamma/stack/header/config/StackHeaderConfigEventEmitter;)V", "onViewManagerAddEventEmitters", "onViewManagerAddEventEmitters$react_native_screens_release", "commandIconResolver", "Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuIconResolver;", "menuUpdateQueue", "Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuUpdateQueue;", "dispatchMenuElementUpdates", "updates", "Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuElementRawUpdate;", "dispatchMenuElementUpdates$react_native_screens_release", "isInsideMountTransaction", "willMountItems", "uiManager", "Lcom/facebook/react/bridge/UIManager;", "didMountItems", "willDispatchViewUpdates", "didDispatchMountItems", "didScheduleMountItems", "tearDown", "tearDown$react_native_screens_release", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class StackHeaderConfig extends ReactViewGroup implements StackHeaderConfigurationProviding, StackHeaderDelegate, OnStackHeaderSubviewChangeListener, UIManagerListener {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(StackHeaderConfig.class, "type", "getType()Lcom/swmansion/rnscreens/gamma/stack/header/config/StackHeaderType;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(StackHeaderConfig.class, "title", "getTitle()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(StackHeaderConfig.class, ViewProps.HIDDEN, "getHidden()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(StackHeaderConfig.class, "transparent", "getTransparent()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(StackHeaderConfig.class, "backButtonHidden", "getBackButtonHidden()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(StackHeaderConfig.class, "backButtonTintColorNormal", "getBackButtonTintColorNormal()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(StackHeaderConfig.class, "backButtonTintColorPressed", "getBackButtonTintColorPressed()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(StackHeaderConfig.class, "backButtonTintColorFocused", "getBackButtonTintColorFocused()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(StackHeaderConfig.class, "backButtonIcon", "getBackButtonIcon()Landroid/graphics/drawable/Drawable;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(StackHeaderConfig.class, "scrollFlagScroll", "getScrollFlagScroll()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(StackHeaderConfig.class, "scrollFlagEnterAlways", "getScrollFlagEnterAlways()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(StackHeaderConfig.class, "scrollFlagEnterAlwaysCollapsed", "getScrollFlagEnterAlwaysCollapsed()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(StackHeaderConfig.class, "scrollFlagExitUntilCollapsed", "getScrollFlagExitUntilCollapsed()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(StackHeaderConfig.class, "scrollFlagSnap", "getScrollFlagSnap()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(StackHeaderConfig.class, "toolbarMenu", "getToolbarMenu()Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuConfig;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(StackHeaderConfig.class, "toolbarMenuGroupDividerEnabled", "getToolbarMenuGroupDividerEnabled()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(StackHeaderConfig.class, "backgroundSubview", "getBackgroundSubview()Lcom/swmansion/rnscreens/gamma/stack/header/subview/StackHeaderSubview;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(StackHeaderConfig.class, "leadingSubview", "getLeadingSubview()Lcom/swmansion/rnscreens/gamma/stack/header/subview/StackHeaderSubview;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(StackHeaderConfig.class, "centerSubview", "getCenterSubview()Lcom/swmansion/rnscreens/gamma/stack/header/subview/StackHeaderSubview;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(StackHeaderConfig.class, "trailingSubview", "getTrailingSubview()Lcom/swmansion/rnscreens/gamma/stack/header/subview/StackHeaderSubview;", 0))};
    private String backButtonDrawableIconResourceName;

    /* JADX INFO: renamed from: backButtonHidden$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty backButtonHidden;

    /* JADX INFO: renamed from: backButtonIcon$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty backButtonIcon;
    private final PropIconResolver backButtonIconResolver;
    private String backButtonImageIconUri;

    /* JADX INFO: renamed from: backButtonTintColorFocused$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty backButtonTintColorFocused;

    /* JADX INFO: renamed from: backButtonTintColorNormal$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty backButtonTintColorNormal;

    /* JADX INFO: renamed from: backButtonTintColorPressed$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty backButtonTintColorPressed;

    /* JADX INFO: renamed from: backgroundSubview$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty backgroundSubview;

    /* JADX INFO: renamed from: centerSubview$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty centerSubview;
    private final StackHeaderToolbarMenuIconResolver commandIconResolver;
    private StackHeaderConfigurationObserver configObserver;
    public StackHeaderConfigEventEmitter eventEmitter;

    /* JADX INFO: renamed from: hidden$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty hidden;
    private int invalidationFlags;
    private boolean isInsideMountTransaction;

    /* JADX INFO: renamed from: leadingSubview$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty leadingSubview;
    private final StackHeaderToolbarMenuUpdateQueue menuUpdateQueue;
    private final ThemedReactContext reactContext;

    /* JADX INFO: renamed from: scrollFlagEnterAlways$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty scrollFlagEnterAlways;

    /* JADX INFO: renamed from: scrollFlagEnterAlwaysCollapsed$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty scrollFlagEnterAlwaysCollapsed;

    /* JADX INFO: renamed from: scrollFlagExitUntilCollapsed$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty scrollFlagExitUntilCollapsed;

    /* JADX INFO: renamed from: scrollFlagScroll$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty scrollFlagScroll;

    /* JADX INFO: renamed from: scrollFlagSnap$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty scrollFlagSnap;
    private final ShadowStateProxy shadowStateProxy;

    /* JADX INFO: renamed from: title$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty title;

    /* JADX INFO: renamed from: toolbarMenu$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty toolbarMenu;

    /* JADX INFO: renamed from: toolbarMenuGroupDividerEnabled$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty toolbarMenuGroupDividerEnabled;
    private Map<String, PropIconResolver> toolbarMenuItemIconResolvers;
    private Map<String, StackHeaderToolbarMenuItemIconSource> toolbarMenuItemIconSourceMap;
    private Map<String, ? extends Drawable> toolbarMenuItemIcons;

    /* JADX INFO: renamed from: trailingSubview$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty trailingSubview;

    /* JADX INFO: renamed from: transparent$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty transparent;

    /* JADX INFO: renamed from: type$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty type;

    /* JADX INFO: compiled from: StackHeaderConfig.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StackHeaderSubviewType.values().length];
            try {
                iArr[StackHeaderSubviewType.BACKGROUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StackHeaderSubviewType.LEADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[StackHeaderSubviewType.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[StackHeaderSubviewType.TRAILING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.facebook.react.bridge.UIManagerListener
    public void didDispatchMountItems(UIManager uiManager) {
        Intrinsics.checkNotNullParameter(uiManager, "uiManager");
    }

    @Override // com.facebook.react.bridge.UIManagerListener
    public void didScheduleMountItems(UIManager uiManager) {
        Intrinsics.checkNotNullParameter(uiManager, "uiManager");
    }

    @Override // com.facebook.react.bridge.UIManagerListener
    public void willDispatchViewUpdates(UIManager uiManager) {
        Intrinsics.checkNotNullParameter(uiManager, "uiManager");
    }

    public final ThemedReactContext getReactContext() {
        return this.reactContext;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StackHeaderConfig(ThemedReactContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        UIManagerHelperExtKt.getFabricUIManagerNotNull(UIManagerHelper.INSTANCE, reactContext).addUIManagerEventListener(this);
        this.invalidationFlags = StackHeaderInvalidationFlags.INSTANCE.m11802getALL2a6ZA60();
        Delegates delegates = Delegates.INSTANCE;
        final StackHeaderType stackHeaderType = StackHeaderType.SMALL;
        this.type = new ObservableProperty<StackHeaderType>(stackHeaderType) { // from class: com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfig$special$$inlined$observable$1
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, StackHeaderType oldValue, StackHeaderType newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                if (oldValue != newValue) {
                    this.m11785invalidategLpVZxs(StackHeaderInvalidationFlags.INSTANCE.m11807getSTRUCTURE2a6ZA60());
                }
            }
        };
        Delegates delegates2 = Delegates.INSTANCE;
        final String str = "";
        this.title = new ObservableProperty<String>(str) { // from class: com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfig$special$$inlined$observable$2
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, String oldValue, String newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                if (Intrinsics.areEqual(oldValue, newValue)) {
                    return;
                }
                this.m11785invalidategLpVZxs(StackHeaderInvalidationFlags.INSTANCE.m11809getTITLE2a6ZA60());
            }
        };
        Delegates delegates3 = Delegates.INSTANCE;
        final boolean z = false;
        this.hidden = new ObservableProperty<Boolean>(z) { // from class: com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfig$special$$inlined$observable$3
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, Boolean oldValue, Boolean newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                if (oldValue.booleanValue() != newValue.booleanValue()) {
                    this.m11785invalidategLpVZxs(StackHeaderInvalidationFlags.INSTANCE.m11807getSTRUCTURE2a6ZA60());
                }
            }
        };
        Delegates delegates4 = Delegates.INSTANCE;
        this.transparent = new ObservableProperty<Boolean>(z) { // from class: com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfig$special$$inlined$observable$4
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, Boolean oldValue, Boolean newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                if (oldValue.booleanValue() != newValue.booleanValue()) {
                    this.m11785invalidategLpVZxs(StackHeaderInvalidationFlags.INSTANCE.m11807getSTRUCTURE2a6ZA60());
                }
            }
        };
        Delegates delegates5 = Delegates.INSTANCE;
        this.backButtonHidden = new ObservableProperty<Boolean>(z) { // from class: com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfig$special$$inlined$observable$5
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, Boolean oldValue, Boolean newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                if (oldValue.booleanValue() != newValue.booleanValue()) {
                    this.m11785invalidategLpVZxs(StackHeaderInvalidationFlags.INSTANCE.m11804getBACK_BUTTON2a6ZA60());
                }
            }
        };
        Delegates delegates6 = Delegates.INSTANCE;
        final Object obj = null;
        this.backButtonTintColorNormal = new ObservableProperty<Integer>(obj) { // from class: com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfig$special$$inlined$observable$6
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, Integer oldValue, Integer newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                if (Intrinsics.areEqual(oldValue, newValue)) {
                    return;
                }
                this.m11785invalidategLpVZxs(StackHeaderInvalidationFlags.INSTANCE.m11804getBACK_BUTTON2a6ZA60());
            }
        };
        Delegates delegates7 = Delegates.INSTANCE;
        this.backButtonTintColorPressed = new ObservableProperty<Integer>(obj) { // from class: com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfig$special$$inlined$observable$7
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, Integer oldValue, Integer newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                if (Intrinsics.areEqual(oldValue, newValue)) {
                    return;
                }
                this.m11785invalidategLpVZxs(StackHeaderInvalidationFlags.INSTANCE.m11804getBACK_BUTTON2a6ZA60());
            }
        };
        Delegates delegates8 = Delegates.INSTANCE;
        this.backButtonTintColorFocused = new ObservableProperty<Integer>(obj) { // from class: com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfig$special$$inlined$observable$8
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, Integer oldValue, Integer newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                if (Intrinsics.areEqual(oldValue, newValue)) {
                    return;
                }
                this.m11785invalidategLpVZxs(StackHeaderInvalidationFlags.INSTANCE.m11804getBACK_BUTTON2a6ZA60());
            }
        };
        Delegates delegates9 = Delegates.INSTANCE;
        this.backButtonIcon = new ObservableProperty<Drawable>(obj) { // from class: com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfig$special$$inlined$observable$9
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, Drawable oldValue, Drawable newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                if (oldValue != newValue) {
                    this.m11785invalidategLpVZxs(StackHeaderInvalidationFlags.INSTANCE.m11804getBACK_BUTTON2a6ZA60());
                }
            }
        };
        Delegates delegates10 = Delegates.INSTANCE;
        this.scrollFlagScroll = new ObservableProperty<Boolean>(z) { // from class: com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfig$special$$inlined$observable$10
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, Boolean oldValue, Boolean newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                if (oldValue.booleanValue() != newValue.booleanValue()) {
                    this.m11785invalidategLpVZxs(StackHeaderInvalidationFlags.INSTANCE.m11806getSCROLL_FLAGS2a6ZA60());
                }
            }
        };
        Delegates delegates11 = Delegates.INSTANCE;
        this.scrollFlagEnterAlways = new ObservableProperty<Boolean>(z) { // from class: com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfig$special$$inlined$observable$11
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, Boolean oldValue, Boolean newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                if (oldValue.booleanValue() != newValue.booleanValue()) {
                    this.m11785invalidategLpVZxs(StackHeaderInvalidationFlags.INSTANCE.m11806getSCROLL_FLAGS2a6ZA60());
                }
            }
        };
        Delegates delegates12 = Delegates.INSTANCE;
        this.scrollFlagEnterAlwaysCollapsed = new ObservableProperty<Boolean>(z) { // from class: com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfig$special$$inlined$observable$12
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, Boolean oldValue, Boolean newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                if (oldValue.booleanValue() != newValue.booleanValue()) {
                    this.m11785invalidategLpVZxs(StackHeaderInvalidationFlags.INSTANCE.m11806getSCROLL_FLAGS2a6ZA60());
                }
            }
        };
        Delegates delegates13 = Delegates.INSTANCE;
        this.scrollFlagExitUntilCollapsed = new ObservableProperty<Boolean>(z) { // from class: com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfig$special$$inlined$observable$13
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, Boolean oldValue, Boolean newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                if (oldValue.booleanValue() != newValue.booleanValue()) {
                    this.m11785invalidategLpVZxs(StackHeaderInvalidationFlags.INSTANCE.m11806getSCROLL_FLAGS2a6ZA60());
                }
            }
        };
        Delegates delegates14 = Delegates.INSTANCE;
        this.scrollFlagSnap = new ObservableProperty<Boolean>(z) { // from class: com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfig$special$$inlined$observable$14
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, Boolean oldValue, Boolean newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                if (oldValue.booleanValue() != newValue.booleanValue()) {
                    this.m11785invalidategLpVZxs(StackHeaderInvalidationFlags.INSTANCE.m11806getSCROLL_FLAGS2a6ZA60());
                }
            }
        };
        Delegates delegates15 = Delegates.INSTANCE;
        final StackHeaderToolbarMenuConfig stackHeaderToolbarMenuConfig = new StackHeaderToolbarMenuConfig(CollectionsKt.emptyList(), CollectionsKt.emptyList());
        this.toolbarMenu = new ObservableProperty<StackHeaderToolbarMenuConfig>(stackHeaderToolbarMenuConfig) { // from class: com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfig$special$$inlined$observable$15
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, StackHeaderToolbarMenuConfig oldValue, StackHeaderToolbarMenuConfig newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                if (Intrinsics.areEqual(oldValue, newValue)) {
                    return;
                }
                this.m11785invalidategLpVZxs(StackHeaderInvalidationFlags.INSTANCE.m11810getTOOLBAR_MENU2a6ZA60());
            }
        };
        Delegates delegates16 = Delegates.INSTANCE;
        this.toolbarMenuGroupDividerEnabled = new ObservableProperty<Boolean>(z) { // from class: com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfig$special$$inlined$observable$16
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, Boolean oldValue, Boolean newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                if (oldValue.booleanValue() != newValue.booleanValue()) {
                    this.m11785invalidategLpVZxs(StackHeaderInvalidationFlags.INSTANCE.m11810getTOOLBAR_MENU2a6ZA60());
                }
            }
        };
        this.backButtonIconResolver = new PropIconResolver();
        this.toolbarMenuItemIconSourceMap = MapsKt.emptyMap();
        this.toolbarMenuItemIconResolvers = MapsKt.emptyMap();
        this.toolbarMenuItemIcons = MapsKt.emptyMap();
        Delegates delegates17 = Delegates.INSTANCE;
        this.backgroundSubview = new ObservableProperty<StackHeaderSubview>(obj) { // from class: com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfig$special$$inlined$observable$17
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, StackHeaderSubview oldValue, StackHeaderSubview newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                if (oldValue != newValue) {
                    this.m11785invalidategLpVZxs(StackHeaderInvalidationFlags.INSTANCE.m11808getSUBVIEWS2a6ZA60());
                }
            }
        };
        Delegates delegates18 = Delegates.INSTANCE;
        this.leadingSubview = new ObservableProperty<StackHeaderSubview>(obj) { // from class: com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfig$special$$inlined$observable$18
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, StackHeaderSubview oldValue, StackHeaderSubview newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                if (oldValue != newValue) {
                    this.m11785invalidategLpVZxs(StackHeaderInvalidationFlags.INSTANCE.m11808getSUBVIEWS2a6ZA60());
                }
            }
        };
        Delegates delegates19 = Delegates.INSTANCE;
        this.centerSubview = new ObservableProperty<StackHeaderSubview>(obj) { // from class: com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfig$special$$inlined$observable$19
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, StackHeaderSubview oldValue, StackHeaderSubview newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                if (oldValue != newValue) {
                    this.m11785invalidategLpVZxs(StackHeaderInvalidationFlags.INSTANCE.m11808getSUBVIEWS2a6ZA60());
                }
            }
        };
        Delegates delegates20 = Delegates.INSTANCE;
        this.trailingSubview = new ObservableProperty<StackHeaderSubview>(obj) { // from class: com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfig$special$$inlined$observable$20
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, StackHeaderSubview oldValue, StackHeaderSubview newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                if (oldValue != newValue) {
                    this.m11785invalidategLpVZxs(StackHeaderInvalidationFlags.INSTANCE.m11808getSUBVIEWS2a6ZA60());
                }
            }
        };
        this.shadowStateProxy = new ShadowStateProxy(false, 1, null);
        StackHeaderToolbarMenuIconResolver stackHeaderToolbarMenuIconResolver = new StackHeaderToolbarMenuIconResolver() { // from class: com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfig$$ExternalSyntheticLambda0
            @Override // com.swmansion.rnscreens.gamma.stack.header.toolbar.StackHeaderToolbarMenuIconResolver
            public final void resolve(StackHeaderToolbarMenuItemIconSource stackHeaderToolbarMenuItemIconSource, Function1 function1) {
                StackHeaderConfig.commandIconResolver$lambda$0(this.f$0, stackHeaderToolbarMenuItemIconSource, function1);
            }
        };
        this.commandIconResolver = stackHeaderToolbarMenuIconResolver;
        this.menuUpdateQueue = new StackHeaderToolbarMenuUpdateQueue(stackHeaderToolbarMenuIconResolver, new StackHeaderToolbarMenuUpdateQueueDelegate() { // from class: com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfig$$ExternalSyntheticLambda1
            @Override // com.swmansion.rnscreens.gamma.stack.header.toolbar.StackHeaderToolbarMenuUpdateQueueDelegate
            public final void onUpdatesResolved(List list) {
                StackHeaderConfig.menuUpdateQueue$lambda$0(this.f$0, list);
            }
        });
    }

    @Override // com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfigurationProviding
    public void setConfigurationObserver(StackHeaderConfigurationObserver observer) {
        this.configObserver = observer;
    }

    @Override // com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfigurationProviding
    /* JADX INFO: renamed from: getInvalidationFlags-2a6ZA60, reason: not valid java name and from getter */
    public int getInvalidationFlags() {
        return this.invalidationFlags;
    }

    /* JADX INFO: renamed from: setInvalidationFlags-gLpVZxs, reason: not valid java name */
    public void m11788setInvalidationFlagsgLpVZxs(int i) {
        this.invalidationFlags = i;
    }

    @Override // com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfigurationProviding
    /* JADX INFO: renamed from: clearInvalidationFlags-gLpVZxs, reason: not valid java name */
    public void mo11786clearInvalidationFlagsgLpVZxs(int flags) {
        m11788setInvalidationFlagsgLpVZxs(StackHeaderInvalidationFlags.m11790clearing7cgdpso(getInvalidationFlags(), flags));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: invalidate-gLpVZxs, reason: not valid java name */
    public final void m11785invalidategLpVZxs(int flags) {
        m11788setInvalidationFlagsgLpVZxs(StackHeaderInvalidationFlags.m11799or7cgdpso(getInvalidationFlags(), flags));
    }

    private final void flushUpdates() {
        StackHeaderConfigurationObserver stackHeaderConfigurationObserver;
        if (this.configObserver == null || StackHeaderInvalidationFlags.m11797isEmptyimpl(getInvalidationFlags()) || (stackHeaderConfigurationObserver = this.configObserver) == null) {
            return;
        }
        stackHeaderConfigurationObserver.onConfigChanged(this);
    }

    @Override // com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfigurationProviding
    public StackHeaderType getType() {
        return (StackHeaderType) this.type.getValue(this, $$delegatedProperties[0]);
    }

    public void setType$react_native_screens_release(StackHeaderType stackHeaderType) {
        Intrinsics.checkNotNullParameter(stackHeaderType, "<set-?>");
        this.type.setValue(this, $$delegatedProperties[0], stackHeaderType);
    }

    @Override // com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfigurationProviding
    public String getTitle() {
        return (String) this.title.getValue(this, $$delegatedProperties[1]);
    }

    public void setTitle$react_native_screens_release(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title.setValue(this, $$delegatedProperties[1], str);
    }

    @Override // com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfigurationProviding
    public boolean getHidden() {
        return ((Boolean) this.hidden.getValue(this, $$delegatedProperties[2])).booleanValue();
    }

    public void setHidden$react_native_screens_release(boolean z) {
        this.hidden.setValue(this, $$delegatedProperties[2], Boolean.valueOf(z));
    }

    @Override // com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfigurationProviding
    public boolean getTransparent() {
        return ((Boolean) this.transparent.getValue(this, $$delegatedProperties[3])).booleanValue();
    }

    public void setTransparent$react_native_screens_release(boolean z) {
        this.transparent.setValue(this, $$delegatedProperties[3], Boolean.valueOf(z));
    }

    @Override // com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfigurationProviding
    public boolean getBackButtonHidden() {
        return ((Boolean) this.backButtonHidden.getValue(this, $$delegatedProperties[4])).booleanValue();
    }

    public void setBackButtonHidden$react_native_screens_release(boolean z) {
        this.backButtonHidden.setValue(this, $$delegatedProperties[4], Boolean.valueOf(z));
    }

    @Override // com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfigurationProviding
    public Integer getBackButtonTintColorNormal() {
        return (Integer) this.backButtonTintColorNormal.getValue(this, $$delegatedProperties[5]);
    }

    public void setBackButtonTintColorNormal$react_native_screens_release(Integer num) {
        this.backButtonTintColorNormal.setValue(this, $$delegatedProperties[5], num);
    }

    @Override // com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfigurationProviding
    public Integer getBackButtonTintColorPressed() {
        return (Integer) this.backButtonTintColorPressed.getValue(this, $$delegatedProperties[6]);
    }

    public void setBackButtonTintColorPressed$react_native_screens_release(Integer num) {
        this.backButtonTintColorPressed.setValue(this, $$delegatedProperties[6], num);
    }

    @Override // com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfigurationProviding
    public Integer getBackButtonTintColorFocused() {
        return (Integer) this.backButtonTintColorFocused.getValue(this, $$delegatedProperties[7]);
    }

    public void setBackButtonTintColorFocused$react_native_screens_release(Integer num) {
        this.backButtonTintColorFocused.setValue(this, $$delegatedProperties[7], num);
    }

    @Override // com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfigurationProviding
    public Drawable getBackButtonIcon() {
        return (Drawable) this.backButtonIcon.getValue(this, $$delegatedProperties[8]);
    }

    public void setBackButtonIcon$react_native_screens_release(Drawable drawable) {
        this.backButtonIcon.setValue(this, $$delegatedProperties[8], drawable);
    }

    @Override // com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfigurationProviding
    public boolean getScrollFlagScroll() {
        return ((Boolean) this.scrollFlagScroll.getValue(this, $$delegatedProperties[9])).booleanValue();
    }

    public void setScrollFlagScroll$react_native_screens_release(boolean z) {
        this.scrollFlagScroll.setValue(this, $$delegatedProperties[9], Boolean.valueOf(z));
    }

    @Override // com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfigurationProviding
    public boolean getScrollFlagEnterAlways() {
        return ((Boolean) this.scrollFlagEnterAlways.getValue(this, $$delegatedProperties[10])).booleanValue();
    }

    public void setScrollFlagEnterAlways$react_native_screens_release(boolean z) {
        this.scrollFlagEnterAlways.setValue(this, $$delegatedProperties[10], Boolean.valueOf(z));
    }

    @Override // com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfigurationProviding
    public boolean getScrollFlagEnterAlwaysCollapsed() {
        return ((Boolean) this.scrollFlagEnterAlwaysCollapsed.getValue(this, $$delegatedProperties[11])).booleanValue();
    }

    public void setScrollFlagEnterAlwaysCollapsed$react_native_screens_release(boolean z) {
        this.scrollFlagEnterAlwaysCollapsed.setValue(this, $$delegatedProperties[11], Boolean.valueOf(z));
    }

    @Override // com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfigurationProviding
    public boolean getScrollFlagExitUntilCollapsed() {
        return ((Boolean) this.scrollFlagExitUntilCollapsed.getValue(this, $$delegatedProperties[12])).booleanValue();
    }

    public void setScrollFlagExitUntilCollapsed$react_native_screens_release(boolean z) {
        this.scrollFlagExitUntilCollapsed.setValue(this, $$delegatedProperties[12], Boolean.valueOf(z));
    }

    @Override // com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfigurationProviding
    public boolean getScrollFlagSnap() {
        return ((Boolean) this.scrollFlagSnap.getValue(this, $$delegatedProperties[13])).booleanValue();
    }

    public void setScrollFlagSnap$react_native_screens_release(boolean z) {
        this.scrollFlagSnap.setValue(this, $$delegatedProperties[13], Boolean.valueOf(z));
    }

    @Override // com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfigurationProviding
    public StackHeaderToolbarMenuConfig getToolbarMenu() {
        return (StackHeaderToolbarMenuConfig) this.toolbarMenu.getValue(this, $$delegatedProperties[14]);
    }

    public void setToolbarMenu$react_native_screens_release(StackHeaderToolbarMenuConfig stackHeaderToolbarMenuConfig) {
        Intrinsics.checkNotNullParameter(stackHeaderToolbarMenuConfig, "<set-?>");
        this.toolbarMenu.setValue(this, $$delegatedProperties[14], stackHeaderToolbarMenuConfig);
    }

    @Override // com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfigurationProviding
    public boolean getToolbarMenuGroupDividerEnabled() {
        return ((Boolean) this.toolbarMenuGroupDividerEnabled.getValue(this, $$delegatedProperties[15])).booleanValue();
    }

    public void setToolbarMenuGroupDividerEnabled$react_native_screens_release(boolean z) {
        this.toolbarMenuGroupDividerEnabled.setValue(this, $$delegatedProperties[15], Boolean.valueOf(z));
    }

    @Override // com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfigurationProviding
    public boolean isRTL() {
        return getLayoutDirection() == 1;
    }

    /* JADX INFO: renamed from: getBackButtonDrawableIconResourceName$react_native_screens_release, reason: from getter */
    public final String getBackButtonDrawableIconResourceName() {
        return this.backButtonDrawableIconResourceName;
    }

    public final void setBackButtonDrawableIconResourceName$react_native_screens_release(String str) {
        this.backButtonDrawableIconResourceName = str;
    }

    /* JADX INFO: renamed from: getBackButtonImageIconUri$react_native_screens_release, reason: from getter */
    public final String getBackButtonImageIconUri() {
        return this.backButtonImageIconUri;
    }

    public final void setBackButtonImageIconUri$react_native_screens_release(String str) {
        this.backButtonImageIconUri = str;
    }

    public final void resolveBackButtonIconIfNeeded$react_native_screens_release() {
        this.backButtonIconResolver.resolve(this.reactContext, this.backButtonDrawableIconResourceName, this.backButtonImageIconUri, new Function1() { // from class: com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfig$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StackHeaderConfig.resolveBackButtonIconIfNeeded$lambda$0(this.f$0, (IconResolution) obj);
            }
        });
    }

    static final Unit resolveBackButtonIconIfNeeded$lambda$0(StackHeaderConfig stackHeaderConfig, IconResolution result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (!Intrinsics.areEqual(result, IconResolution.Unchanged.INSTANCE)) {
            if (!(result instanceof IconResolution.Resolved)) {
                throw new NoWhenBranchMatchedException();
            }
            stackHeaderConfig.setBackButtonIcon$react_native_screens_release(((IconResolution.Resolved) result).getDrawable());
            if (!stackHeaderConfig.isInsideMountTransaction) {
                stackHeaderConfig.flushUpdates();
            }
        }
        return Unit.INSTANCE;
    }

    public final Map<String, StackHeaderToolbarMenuItemIconSource> getToolbarMenuItemIconSourceMap$react_native_screens_release() {
        return this.toolbarMenuItemIconSourceMap;
    }

    public final void setToolbarMenuItemIconSourceMap$react_native_screens_release(Map<String, StackHeaderToolbarMenuItemIconSource> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.toolbarMenuItemIconSourceMap = map;
    }

    public final void resolveToolbarMenuItemIconsIfNeeded$react_native_screens_release() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, StackHeaderToolbarMenuItemIconSource> entry : this.toolbarMenuItemIconSourceMap.entrySet()) {
            final String key = entry.getKey();
            StackHeaderToolbarMenuItemIconSource value = entry.getValue();
            PropIconResolver propIconResolver = this.toolbarMenuItemIconResolvers.get(key);
            if (propIconResolver == null) {
                propIconResolver = new PropIconResolver();
            }
            linkedHashMap.put(key, propIconResolver);
            propIconResolver.resolve(this.reactContext, value.getDrawableIconResourceName(), value.getImageIconUri(), new Function1() { // from class: com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfig$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return StackHeaderConfig.resolveToolbarMenuItemIconsIfNeeded$lambda$0$0(this.f$0, key, (IconResolution) obj);
                }
            });
        }
        this.toolbarMenuItemIconResolvers = linkedHashMap;
        Map<String, ? extends Drawable> map = this.toolbarMenuItemIcons;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry<String, ? extends Drawable> entry2 : map.entrySet()) {
            if (this.toolbarMenuItemIconSourceMap.containsKey(entry2.getKey())) {
                linkedHashMap2.put(entry2.getKey(), entry2.getValue());
            }
        }
        this.toolbarMenuItemIcons = linkedHashMap2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit resolveToolbarMenuItemIconsIfNeeded$lambda$0$0(StackHeaderConfig stackHeaderConfig, String str, IconResolution result) {
        Drawable drawable;
        Intrinsics.checkNotNullParameter(result, "result");
        if (Intrinsics.areEqual(result, IconResolution.Unchanged.INSTANCE)) {
            drawable = stackHeaderConfig.toolbarMenuItemIcons.get(str);
        } else {
            if (!(result instanceof IconResolution.Resolved)) {
                throw new NoWhenBranchMatchedException();
            }
            IconResolution.Resolved resolved = (IconResolution.Resolved) result;
            stackHeaderConfig.toolbarMenuItemIcons = MapsKt.plus(stackHeaderConfig.toolbarMenuItemIcons, TuplesKt.to(str, resolved.getDrawable()));
            drawable = resolved.getDrawable();
        }
        stackHeaderConfig.applyToolbarMenuItemIcon(str, drawable);
        return Unit.INSTANCE;
    }

    private final void applyToolbarMenuItemIcon(String id, Drawable icon) {
        StackHeaderToolbarMenuConfig toolbarMenu = getToolbarMenu();
        StackHeaderToolbarMenuConfig stackHeaderToolbarMenuConfigUpdateItemIcon$react_native_screens_release = toolbarMenu.updateItemIcon$react_native_screens_release(id, icon);
        if (stackHeaderToolbarMenuConfigUpdateItemIcon$react_native_screens_release != toolbarMenu) {
            setToolbarMenu$react_native_screens_release(stackHeaderToolbarMenuConfigUpdateItemIcon$react_native_screens_release);
            if (this.isInsideMountTransaction) {
                return;
            }
            flushUpdates();
        }
    }

    private void setBackgroundSubview(StackHeaderSubview stackHeaderSubview) {
        this.backgroundSubview.setValue(this, $$delegatedProperties[16], stackHeaderSubview);
    }

    @Override // com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfigurationProviding
    public StackHeaderSubview getBackgroundSubview() {
        return (StackHeaderSubview) this.backgroundSubview.getValue(this, $$delegatedProperties[16]);
    }

    private void setLeadingSubview(StackHeaderSubview stackHeaderSubview) {
        this.leadingSubview.setValue(this, $$delegatedProperties[17], stackHeaderSubview);
    }

    @Override // com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfigurationProviding
    public StackHeaderSubview getLeadingSubview() {
        return (StackHeaderSubview) this.leadingSubview.getValue(this, $$delegatedProperties[17]);
    }

    private void setCenterSubview(StackHeaderSubview stackHeaderSubview) {
        this.centerSubview.setValue(this, $$delegatedProperties[18], stackHeaderSubview);
    }

    @Override // com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfigurationProviding
    public StackHeaderSubview getCenterSubview() {
        return (StackHeaderSubview) this.centerSubview.getValue(this, $$delegatedProperties[18]);
    }

    private void setTrailingSubview(StackHeaderSubview stackHeaderSubview) {
        this.trailingSubview.setValue(this, $$delegatedProperties[19], stackHeaderSubview);
    }

    @Override // com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfigurationProviding
    public StackHeaderSubview getTrailingSubview() {
        return (StackHeaderSubview) this.trailingSubview.getValue(this, $$delegatedProperties[19]);
    }

    @Override // com.swmansion.rnscreens.gamma.stack.header.subview.OnStackHeaderSubviewChangeListener
    public void onStackHeaderSubviewChanged() {
        m11785invalidategLpVZxs(StackHeaderInvalidationFlags.INSTANCE.m11808getSUBVIEWS2a6ZA60());
    }

    public final void addConfigSubview$react_native_screens_release(StackHeaderSubview headerSubview) {
        Intrinsics.checkNotNullParameter(headerSubview, "headerSubview");
        int i = WhenMappings.$EnumSwitchMapping$0[headerSubview.getType().ordinal()];
        if (i == 1) {
            setBackgroundSubview(headerSubview);
        } else if (i == 2) {
            setLeadingSubview(headerSubview);
        } else if (i == 3) {
            setCenterSubview(headerSubview);
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            setTrailingSubview(headerSubview);
        }
        headerSubview.setOnStackHeaderSubviewChangeListener$react_native_screens_release(new WeakReference<>(this));
    }

    public final void removeConfigSubview$react_native_screens_release(StackHeaderSubview headerSubview) {
        Intrinsics.checkNotNullParameter(headerSubview, "headerSubview");
        headerSubview.setOnStackHeaderSubviewChangeListener$react_native_screens_release(null);
        int i = WhenMappings.$EnumSwitchMapping$0[headerSubview.getType().ordinal()];
        if (i == 1) {
            setBackgroundSubview(null);
            return;
        }
        if (i == 2) {
            setLeadingSubview(null);
        } else if (i == 3) {
            setCenterSubview(null);
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            setTrailingSubview(null);
        }
    }

    public final void removeConfigSubviewAt$react_native_screens_release(int index) {
        StackHeaderSubview configSubviewAt$react_native_screens_release = getConfigSubviewAt$react_native_screens_release(index);
        if (configSubviewAt$react_native_screens_release != null) {
            removeConfigSubview$react_native_screens_release(configSubviewAt$react_native_screens_release);
        }
    }

    public final void removeAllConfigSubviews$react_native_screens_release() {
        StackHeaderSubview backgroundSubview = getBackgroundSubview();
        if (backgroundSubview != null) {
            removeConfigSubview$react_native_screens_release(backgroundSubview);
        }
        StackHeaderSubview leadingSubview = getLeadingSubview();
        if (leadingSubview != null) {
            removeConfigSubview$react_native_screens_release(leadingSubview);
        }
        StackHeaderSubview centerSubview = getCenterSubview();
        if (centerSubview != null) {
            removeConfigSubview$react_native_screens_release(centerSubview);
        }
        StackHeaderSubview trailingSubview = getTrailingSubview();
        if (trailingSubview != null) {
            removeConfigSubview$react_native_screens_release(trailingSubview);
        }
    }

    public final int getConfigSubviewsCount$react_native_screens_release() {
        return getListOfSubviews().size();
    }

    public final StackHeaderSubview getConfigSubviewAt$react_native_screens_release(int index) {
        return (StackHeaderSubview) CollectionsKt.getOrNull(getListOfSubviews(), index);
    }

    private final List<StackHeaderSubview> getListOfSubviews() {
        return CollectionsKt.listOfNotNull((Object[]) new StackHeaderSubview[]{getBackgroundSubview(), getLeadingSubview(), getCenterSubview(), getTrailingSubview()});
    }

    public final StateWrapper getStateWrapper$react_native_screens_release() {
        return this.shadowStateProxy.getStateWrapper();
    }

    public final void setStateWrapper$react_native_screens_release(StateWrapper stateWrapper) {
        this.shadowStateProxy.setStateWrapper$react_native_screens_release(stateWrapper);
    }

    @Override // com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderDelegate
    public void onHeaderFrameChanged(int width, int height, int contentOffsetY) {
        ShadowStateProxy.updateStateIfNeeded$default(this.shadowStateProxy, getResources().getDisplayMetrics().density, Integer.valueOf(width), Integer.valueOf(height), null, Integer.valueOf(contentOffsetY), 8, null);
    }

    @Override // com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderDelegate
    public void onMenuItemClicked(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        getEventEmitter$react_native_screens_release().emitOnToolbarMenuItemPress$react_native_screens_release(id);
    }

    @Override // com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderDelegate
    public void onGroupSelectionChanged(String groupId, List<String> selectedIds) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(selectedIds, "selectedIds");
        getEventEmitter$react_native_screens_release().emitOnToolbarMenuGroupSelectionChange$react_native_screens_release(groupId, selectedIds);
    }

    @Override // com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderDelegate
    public void onSubviewOriginChanged(StackHeaderSubviewType type, int x, int y) {
        StackHeaderSubview backgroundSubview;
        Intrinsics.checkNotNullParameter(type, "type");
        int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i == 1) {
            backgroundSubview = getBackgroundSubview();
        } else if (i == 2) {
            backgroundSubview = getLeadingSubview();
        } else if (i == 3) {
            backgroundSubview = getCenterSubview();
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            backgroundSubview = getTrailingSubview();
        }
        if (backgroundSubview != null) {
            backgroundSubview.updateContentOriginOffset(x, y);
        }
    }

    public final StackHeaderConfigEventEmitter getEventEmitter$react_native_screens_release() {
        StackHeaderConfigEventEmitter stackHeaderConfigEventEmitter = this.eventEmitter;
        if (stackHeaderConfigEventEmitter != null) {
            return stackHeaderConfigEventEmitter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("eventEmitter");
        return null;
    }

    public final void setEventEmitter$react_native_screens_release(StackHeaderConfigEventEmitter stackHeaderConfigEventEmitter) {
        Intrinsics.checkNotNullParameter(stackHeaderConfigEventEmitter, "<set-?>");
        this.eventEmitter = stackHeaderConfigEventEmitter;
    }

    public final void onViewManagerAddEventEmitters$react_native_screens_release() {
        if (getId() == -1) {
            throw new IllegalStateException("[RNScreens] StackHeaderConfig must have its tag set when registering event emitters".toString());
        }
        setEventEmitter$react_native_screens_release(new StackHeaderConfigEventEmitter(this.reactContext, getId()));
    }

    static final void commandIconResolver$lambda$0(StackHeaderConfig stackHeaderConfig, StackHeaderToolbarMenuItemIconSource iconSource, final Function1 onResolved) {
        Intrinsics.checkNotNullParameter(iconSource, "iconSource");
        Intrinsics.checkNotNullParameter(onResolved, "onResolved");
        ImageLoaderKt.resolveImage(stackHeaderConfig.reactContext, iconSource.getDrawableIconResourceName(), iconSource.getImageIconUri(), new Function1() { // from class: com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfig$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StackHeaderConfig.commandIconResolver$lambda$0$0(onResolved, (Drawable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit commandIconResolver$lambda$0$0(Function1 function1, Drawable drawable) {
        function1.invoke(StackHeaderToolbarFieldUpdate.INSTANCE.from(drawable));
        return Unit.INSTANCE;
    }

    static final void menuUpdateQueue$lambda$0(StackHeaderConfig stackHeaderConfig, List updates) {
        Intrinsics.checkNotNullParameter(updates, "updates");
        StackHeaderConfigurationObserver stackHeaderConfigurationObserver = stackHeaderConfig.configObserver;
        if (stackHeaderConfigurationObserver != null) {
            stackHeaderConfigurationObserver.onMenuElementsUpdated(updates);
        }
    }

    public final void dispatchMenuElementUpdates$react_native_screens_release(List<StackHeaderToolbarMenuElementRawUpdate> updates) {
        Intrinsics.checkNotNullParameter(updates, "updates");
        this.menuUpdateQueue.enqueue$react_native_screens_release(updates);
    }

    @Override // com.facebook.react.bridge.UIManagerListener
    public void willMountItems(UIManager uiManager) {
        Intrinsics.checkNotNullParameter(uiManager, "uiManager");
        this.isInsideMountTransaction = true;
    }

    @Override // com.facebook.react.bridge.UIManagerListener
    public void didMountItems(UIManager uiManager) {
        Intrinsics.checkNotNullParameter(uiManager, "uiManager");
        this.isInsideMountTransaction = false;
        flushUpdates();
    }

    public final void tearDown$react_native_screens_release() {
        UIManagerHelperExtKt.getFabricUIManagerNotNull(UIManagerHelper.INSTANCE, this.reactContext).removeUIManagerEventListener(this);
        this.menuUpdateQueue.tearDown$react_native_screens_release();
        m11788setInvalidationFlagsgLpVZxs(StackHeaderInvalidationFlags.INSTANCE.m11805getNONE2a6ZA60());
        this.configObserver = null;
    }
}
