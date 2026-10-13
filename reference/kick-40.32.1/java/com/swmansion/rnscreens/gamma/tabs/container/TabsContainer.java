package com.swmansion.rnscreens.gamma.tabs.container;

import android.content.Context;
import android.content.res.Configuration;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewGroupKt;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.swmansion.rnscreens.ScreenStack;
import com.swmansion.rnscreens.gamma.common.colorscheme.ColorScheme;
import com.swmansion.rnscreens.gamma.common.colorscheme.ColorSchemeCoordinator;
import com.swmansion.rnscreens.gamma.common.colorscheme.ColorSchemeListener;
import com.swmansion.rnscreens.gamma.common.colorscheme.ColorSchemeProviding;
import com.swmansion.rnscreens.gamma.common.container.Container;
import com.swmansion.rnscreens.gamma.common.container.ParentContainerItemRegistry;
import com.swmansion.rnscreens.gamma.helpers.FragmentManagerHelper;
import com.swmansion.rnscreens.gamma.helpers.FragmentManagerHelperKt;
import com.swmansion.rnscreens.gamma.helpers.ViewFinder;
import com.swmansion.rnscreens.gamma.helpers.ViewIdGenerator;
import com.swmansion.rnscreens.gamma.tabs.appearance.TabsAppearanceCoordinator;
import com.swmansion.rnscreens.gamma.tabs.host.TabsHost;
import com.swmansion.rnscreens.gamma.tabs.host.TabsHostA11yCoordinator;
import com.swmansion.rnscreens.gamma.tabs.screen.TabsScreen;
import com.swmansion.rnscreens.gamma.tabs.screen.TabsScreenDelegate;
import com.swmansion.rnscreens.gamma.tabs.screen.TabsScreenFragment;
import com.swmansion.rnscreens.safearea.EdgeInsets;
import com.swmansion.rnscreens.safearea.SafeAreaProvider;
import com.swmansion.rnscreens.safearea.SafeAreaView;
import com.swmansion.rnscreens.utils.RNSLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: TabsContainer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 ¼\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0004»\u0001¼\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\"\u001a\u00020!H\u0002J\u000e\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020SJ\u0006\u0010T\u001a\u00020QJ\u000e\u0010U\u001a\u00020\u00142\u0006\u0010V\u001a\u00020WJ\u000e\u0010X\u001a\u00020\u00142\u0006\u0010V\u001a\u00020WJ\u0017\u0010Y\u001a\u00020Q2\b\u0010Z\u001a\u0004\u0018\u00010!H\u0000¢\u0006\u0002\b[J\u001d\u0010\\\u001a\u00020Q2\u0006\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020`H\u0000¢\u0006\u0002\baJ\u0017\u0010b\u001a\u0004\u0018\u00010`2\u0006\u0010]\u001a\u00020^H\u0000¢\u0006\u0002\bcJ\u0015\u0010d\u001a\u00020\u00142\u0006\u0010_\u001a\u00020`H\u0000¢\u0006\u0002\beJ\r\u0010f\u001a\u00020QH\u0000¢\u0006\u0002\bgJ\r\u0010h\u001a\u00020QH\u0000¢\u0006\u0002\biJ\r\u0010j\u001a\u00020QH\u0000¢\u0006\u0002\bkJ\r\u0010l\u001a\u00020QH\u0000¢\u0006\u0002\bmJ\u001d\u0010n\u001a\u00020Q2\u0006\u0010o\u001a\u00020^2\u0006\u0010p\u001a\u00020qH\u0000¢\u0006\u0002\brJ\b\u0010s\u001a\u00020QH\u0014J\b\u0010t\u001a\u00020QH\u0014J\u0012\u0010u\u001a\u00020Q2\b\u0010v\u001a\u0004\u0018\u00010wH\u0014J\u0014\u0010x\u001a\u0004\u0018\u00010y2\b\u0010z\u001a\u0004\u0018\u00010yH\u0016JX\u0010{\u001a\u00020Q2\b\u0010|\u001a\u0004\u0018\u00010}2\u0006\u0010~\u001a\u00020^2\u0006\u0010\u007f\u001a\u00020^2\u0007\u0010\u0080\u0001\u001a\u00020^2\u0007\u0010\u0081\u0001\u001a\u00020^2\u0007\u0010\u0082\u0001\u001a\u00020^2\u0007\u0010\u0083\u0001\u001a\u00020^2\u0007\u0010\u0084\u0001\u001a\u00020^2\u0007\u0010\u0085\u0001\u001a\u00020^H\u0016J\u0012\u0010\u0086\u0001\u001a\u00020Q2\u0007\u0010\u0087\u0001\u001a\u00020GH\u0016J\u0012\u0010\u0088\u0001\u001a\u00020Q2\u0007\u0010\u0087\u0001\u001a\u00020GH\u0016J\n\u0010\u0089\u0001\u001a\u00030\u008a\u0001H\u0016J\t\u0010\u008b\u0001\u001a\u00020^H\u0016J\u0013\u0010\u008c\u0001\u001a\u00020Q2\b\u0010\u0087\u0001\u001a\u00030\u008d\u0001H\u0016J\u0013\u0010\u008e\u0001\u001a\u00020Q2\b\u0010\u0087\u0001\u001a\u00030\u008d\u0001H\u0016J\u0011\u0010\u008f\u0001\u001a\u00020Q2\u0006\u0010_\u001a\u00020`H\u0016J\u0011\u0010\u0090\u0001\u001a\u00020Q2\u0006\u0010_\u001a\u00020`H\u0016J\u0013\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u00102\u0006\u0010_\u001a\u00020`H\u0016J\u001a\u0010\u0092\u0001\u001a\u00020Q2\u0006\u0010_\u001a\u00020`2\u0007\u0010\u0093\u0001\u001a\u00020wH\u0016J\t\u0010\u0094\u0001\u001a\u00020QH\u0002J\t\u0010\u0095\u0001\u001a\u00020QH\u0002J\t\u0010\u0096\u0001\u001a\u00020QH\u0002J\t\u0010\u0097\u0001\u001a\u00020QH\u0002J\t\u0010\u0098\u0001\u001a\u00020QH\u0002J\t\u0010\u0099\u0001\u001a\u00020QH\u0002J\t\u0010\u009a\u0001\u001a\u00020QH\u0002J\t\u0010\u009b\u0001\u001a\u00020QH\u0002J\t\u0010\u009c\u0001\u001a\u00020QH\u0002J\u001a\u0010\u009d\u0001\u001a\u00020\u00142\u0007\u0010\u009e\u0001\u001a\u00020\u00102\u0006\u0010p\u001a\u00020qH\u0002J\u0012\u0010\u009f\u0001\u001a\u00020Q2\u0007\u0010\u009e\u0001\u001a\u00020\u0010H\u0002J\u001b\u0010 \u0001\u001a\u00020Q2\u0007\u0010¡\u0001\u001a\u00020\u00102\u0007\u0010\u009e\u0001\u001a\u00020\u0010H\u0002J\u0012\u0010¢\u0001\u001a\u00020Q2\u0007\u0010£\u0001\u001a\u00020SH\u0002J\u001a\u0010¤\u0001\u001a\u00020Q2\u0007\u0010£\u0001\u001a\u00020S2\u0006\u0010p\u001a\u00020qH\u0002J\u0013\u0010¥\u0001\u001a\u00020\u00142\b\u0010¦\u0001\u001a\u00030§\u0001H\u0002J\t\u0010¨\u0001\u001a\u00020QH\u0002J\u0012\u0010©\u0001\u001a\u00020Q2\u0007\u0010ª\u0001\u001a\u00020^H\u0002J\u0013\u0010«\u0001\u001a\u0004\u0018\u00010\u00102\u0006\u0010o\u001a\u00020^H\u0002J\u001a\u0010¬\u0001\u001a\u0004\u0018\u00010^2\u0007\u0010\u00ad\u0001\u001a\u00020\u0010H\u0002¢\u0006\u0003\u0010®\u0001J\u0011\u0010¯\u0001\u001a\u0004\u0018\u00010^H\u0002¢\u0006\u0003\u0010°\u0001J\u0014\u0010±\u0001\u001a\u0005\u0018\u00010§\u00012\u0006\u0010_\u001a\u00020`H\u0002J\u0013\u0010²\u0001\u001a\u0004\u0018\u00010\u00102\u0006\u0010R\u001a\u00020SH\u0002J\u0011\u0010³\u0001\u001a\u00020\u00102\u0006\u0010R\u001a\u00020SH\u0002J\u001c\u0010´\u0001\u001a\u00020Q2\u000b\b\u0002\u0010µ\u0001\u001a\u0004\u0018\u00010^H\u0002¢\u0006\u0003\u0010¶\u0001J\u0013\u0010·\u0001\u001a\u0004\u0018\u00010y2\u0006\u0010z\u001a\u00020yH\u0002J\u0011\u0010¸\u0001\u001a\u00020\u00142\u0006\u0010Z\u001a\u00020!H\u0002J\f\u0010¹\u0001\u001a\u0005\u0018\u00010º\u0001H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00108@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001dX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u00020%8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\u00020,X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0012\u0010/\u001a\u000600R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0002\n\u0000R+\u00107\u001a\u0002062\u0006\u00105\u001a\u0002068@@@X\u0080\u008e\u0002¢\u0006\u0012\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=*\u0004\b8\u00109R\u001a\u0010>\u001a\u00020\u0014X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0016\"\u0004\b@\u0010\u0018R\u000e\u0010A\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020CX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020EX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010H\u001a\u00020\u00142\u0006\u00105\u001a\u00020\u00148@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bI\u0010\u0016\"\u0004\bJ\u0010\u0018R\u0011\u0010M\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\bN\u0010O¨\u0006½\u0001"}, d2 = {"Lcom/swmansion/rnscreens/gamma/tabs/container/TabsContainer;", "Landroid/widget/FrameLayout;", "Lcom/swmansion/rnscreens/gamma/common/container/Container;", "Lcom/swmansion/rnscreens/gamma/common/colorscheme/ColorSchemeProviding;", "Lcom/swmansion/rnscreens/gamma/tabs/screen/TabsScreenDelegate;", "Lcom/swmansion/rnscreens/safearea/SafeAreaProvider;", "Landroid/view/View$OnLayoutChangeListener;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "navState", "Lcom/swmansion/rnscreens/gamma/tabs/container/TabsNavigationState;", "lastUINavState", "tabsModel", "", "Lcom/swmansion/rnscreens/gamma/tabs/screen/TabsScreenFragment;", "parentContainerRegistry", "Lcom/swmansion/rnscreens/gamma/common/container/ParentContainerItemRegistry;", "rejectStaleNavigationStateUpdates", "", "getRejectStaleNavigationStateUpdates$react_native_screens_release", "()Z", "setRejectStaleNavigationStateUpdates$react_native_screens_release", "(Z)V", "selectedTab", "getSelectedTab$react_native_screens_release", "()Lcom/swmansion/rnscreens/gamma/tabs/screen/TabsScreenFragment;", "invalidationFlags", "Lcom/swmansion/rnscreens/gamma/tabs/container/TabsContainerInvalidationFlags;", "getInvalidationFlags$react_native_screens_release", "()Lcom/swmansion/rnscreens/gamma/tabs/container/TabsContainerInvalidationFlags;", "pendingStateUpdateRequest", "Lcom/swmansion/rnscreens/gamma/tabs/container/TabsNavigationStateUpdateRequest;", "requirePendingStateUpdateRequest", "isInExternalOperationContext", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "requireFragmentManager", "getRequireFragmentManager", "()Landroidx/fragment/app/FragmentManager;", "themedContext", "Landroidx/appcompat/view/ContextThemeWrapper;", "bottomNavigationView", "Lcom/swmansion/rnscreens/gamma/tabs/container/CustomBottomNavigationView;", "getBottomNavigationView$react_native_screens_release", "()Lcom/swmansion/rnscreens/gamma/tabs/container/CustomBottomNavigationView;", "specialEffectsHandler", "Lcom/swmansion/rnscreens/gamma/tabs/container/TabsContainer$SpecialEffectsHandler;", "colorSchemeCoordinator", "Lcom/swmansion/rnscreens/gamma/common/colorscheme/ColorSchemeCoordinator;", "observerRegistry", "Lcom/swmansion/rnscreens/gamma/tabs/container/TabsNavigationStateObserverRegistry;", "<set-?>", "Lcom/swmansion/rnscreens/gamma/common/colorscheme/ColorScheme;", "colorScheme", "getColorScheme$react_native_screens_release$delegate", "(Lcom/swmansion/rnscreens/gamma/tabs/container/TabsContainer;)Ljava/lang/Object;", "getColorScheme$react_native_screens_release", "()Lcom/swmansion/rnscreens/gamma/common/colorscheme/ColorScheme;", "setColorScheme$react_native_screens_release", "(Lcom/swmansion/rnscreens/gamma/common/colorscheme/ColorScheme;)V", "tabBarRespectsIMEInsets", "getTabBarRespectsIMEInsets$react_native_screens_release", "setTabBarRespectsIMEInsets$react_native_screens_release", "contentView", "appearanceCoordinator", "Lcom/swmansion/rnscreens/gamma/tabs/appearance/TabsAppearanceCoordinator;", "a11yCoordinator", "Lcom/swmansion/rnscreens/gamma/tabs/host/TabsHostA11yCoordinator;", "interfaceInsetsChangeListener", "Lcom/swmansion/rnscreens/safearea/SafeAreaView;", "tabBarHidden", "getTabBarHidden$react_native_screens_release", "setTabBarHidden$react_native_screens_release", "tabBarHidden$delegate", "Lkotlin/properties/ReadWriteProperty;", "navigationState", "getNavigationState", "()Lcom/swmansion/rnscreens/gamma/tabs/container/TabsNavigationState;", "submitSelectionOfTabsScreenWithKey", "", "screenKey", "", "flushPendingUpdates", "addNavigationStateObserver", "observer", "Lcom/swmansion/rnscreens/gamma/tabs/container/TabsNavigationStateObserver;", "removeNavigationStateObserver", "setPendingNavigationStateUpdate", "request", "setPendingNavigationStateUpdate$react_native_screens_release", "addTabsScreenAt", FirebaseAnalytics.Param.INDEX, "", "tabsScreen", "Lcom/swmansion/rnscreens/gamma/tabs/screen/TabsScreen;", "addTabsScreenAt$react_native_screens_release", "removeTabsScreenAt", "removeTabsScreenAt$react_native_screens_release", "removeTabsScreen", "removeTabsScreen$react_native_screens_release", "removeAllTabsScreens", "removeAllTabsScreens$react_native_screens_release", "setupFragmentManager", "setupFragmentManager$react_native_screens_release", "teardownFragmentManager", "teardownFragmentManager$react_native_screens_release", "tearDown", "tearDown$react_native_screens_release", "onAfterSetSelectedItemId", "itemId", "actionOrigin", "Lcom/swmansion/rnscreens/gamma/tabs/container/TabsActionOrigin;", "onAfterSetSelectedItemId$react_native_screens_release", "onAttachedToWindow", "onDetachedFromWindow", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "dispatchApplyWindowInsets", "Landroid/view/WindowInsets;", "insets", "onLayoutChange", "view", "Landroid/view/View;", "left", ViewProps.TOP, "right", ViewProps.BOTTOM, "oldLeft", "oldTop", "oldRight", "oldBottom", "setOnInterfaceInsetsChangeListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removeOnInterfaceInsetsChangeListener", "getInterfaceInsets", "Lcom/swmansion/rnscreens/safearea/EdgeInsets;", "getResolvedUiNightMode", "addColorSchemeListener", "Lcom/swmansion/rnscreens/gamma/common/colorscheme/ColorSchemeListener;", "removeColorSchemeListener", "onAppearanceChanged", "onMenuItemAttributesChange", "getFragmentForTabsScreen", "onFragmentConfigurationChange", "config", "performContainerUpdate", "performPreSelectedTabUpdateActions", "performPostSelectedTabUpdateActions", "updateNavigationMenuStructureIfNeeded", "performSelectedTabUpdateIfNeeded", "updateBottomNavigationViewAppearanceIfNeeded", "performSelectedTabUpdate", "updateNavigationMenuStructure", "updateBottomNavigationViewAppearance", "updateNavigationStateAndSelectedFragment", "nextSelectedFragment", "applyInitialStateToFragmentManagerSync", "applyNextSelectedFragmentToFragmentManagerSync", "currSelectedFragment", "initNavigationState", "selectedScreenKey", "progressNavigationState", "onMenuItemSelected", "item", "Landroid/view/MenuItem;", "restoreNavigationStateIfNeeded", "applyDayNightUiMode", "uiMode", "getFragmentForMenuItemId", "getMenuItemIdForFragment", "tabsScreenFragment", "(Lcom/swmansion/rnscreens/gamma/tabs/screen/TabsScreenFragment;)Ljava/lang/Integer;", "getSelectedTabsScreenFragmentId", "()Ljava/lang/Integer;", "getMenuItemForTabsScreen", "getFragmentForScreenKey", "requireFragmentForScreenKey", "updateInterfaceInsets", "newHeight", "(Ljava/lang/Integer;)V", "getInsetsForBottomNavigationView", "isNavigationStateStale", "resolveCurrentContentScrollView", "Landroid/view/ViewGroup;", "SpecialEffectsHandler", "Companion", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class TabsContainer extends FrameLayout implements Container, ColorSchemeProviding, TabsScreenDelegate, SafeAreaProvider, View.OnLayoutChangeListener {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(TabsContainer.class, "tabBarHidden", "getTabBarHidden$react_native_screens_release()Z", 0))};
    public static final String TAG = "TabsContainer";
    private final TabsHostA11yCoordinator a11yCoordinator;
    private final TabsAppearanceCoordinator appearanceCoordinator;
    private final CustomBottomNavigationView bottomNavigationView;
    private final ColorSchemeCoordinator colorSchemeCoordinator;
    private final FrameLayout contentView;
    private final Context context;
    private FragmentManager fragmentManager;
    private SafeAreaView interfaceInsetsChangeListener;
    private final TabsContainerInvalidationFlags invalidationFlags;
    private boolean isInExternalOperationContext;
    private TabsNavigationState lastUINavState;
    private TabsNavigationState navState;
    private final TabsNavigationStateObserverRegistry observerRegistry;
    private final ParentContainerItemRegistry parentContainerRegistry;
    private TabsNavigationStateUpdateRequest pendingStateUpdateRequest;
    private boolean rejectStaleNavigationStateUpdates;
    private final SpecialEffectsHandler specialEffectsHandler;

    /* JADX INFO: renamed from: tabBarHidden$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty tabBarHidden;
    private boolean tabBarRespectsIMEInsets;
    private final List<TabsScreenFragment> tabsModel;
    private final ContextThemeWrapper themedContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabsContainer(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        setId(ViewIdGenerator.INSTANCE.generateViewId());
        this.navState = TabsNavigationState.INSTANCE.getEMPTY();
        this.lastUINavState = TabsNavigationState.INSTANCE.getEMPTY();
        ArrayList arrayList = new ArrayList();
        this.tabsModel = arrayList;
        this.parentContainerRegistry = new ParentContainerItemRegistry();
        TabsContainerInvalidationFlags tabsContainerInvalidationFlags = new TabsContainerInvalidationFlags(false, false, false, 7, null);
        this.invalidationFlags = tabsContainerInvalidationFlags;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, R.style.Theme_Material3_DayNight_NoActionBar);
        this.themedContext = contextThemeWrapper;
        CustomBottomNavigationView customBottomNavigationView = new CustomBottomNavigationView(contextThemeWrapper, this);
        customBottomNavigationView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2, 80));
        this.bottomNavigationView = customBottomNavigationView;
        this.specialEffectsHandler = new SpecialEffectsHandler();
        this.colorSchemeCoordinator = new ColorSchemeCoordinator();
        this.observerRegistry = new TabsNavigationStateObserverRegistry();
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.setId(ViewIdGenerator.INSTANCE.generateViewId());
        this.contentView = frameLayout;
        this.appearanceCoordinator = new TabsAppearanceCoordinator(customBottomNavigationView, arrayList);
        this.a11yCoordinator = new TabsHostA11yCoordinator(customBottomNavigationView, arrayList);
        Delegates delegates = Delegates.INSTANCE;
        final boolean z = false;
        this.tabBarHidden = new ObservableProperty<Boolean>(z) { // from class: com.swmansion.rnscreens.gamma.tabs.container.TabsContainer$special$$inlined$observable$1
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, Boolean oldValue, Boolean newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                if (newValue.booleanValue() != oldValue.booleanValue()) {
                    TabsContainer.updateInterfaceInsets$default(this, null, 1, null);
                    this.getInvalidationFlags().setNavigationMenuAppearanceInvalidated(true);
                    TabsContainer tabsContainer = this;
                    final TabsContainer tabsContainer2 = this;
                    tabsContainer.post(new Runnable() { // from class: com.swmansion.rnscreens.gamma.tabs.container.TabsContainer$tabBarHidden$2$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            tabsContainer2.flushPendingUpdates();
                        }
                    });
                }
            }
        };
        addView(frameLayout);
        addView(customBottomNavigationView);
        customBottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() { // from class: com.swmansion.rnscreens.gamma.tabs.container.TabsContainer$$ExternalSyntheticLambda3
            @Override // com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener
            public final boolean onNavigationItemSelected(MenuItem menuItem) {
                return this.f$0.onMenuItemSelected(menuItem);
            }
        });
        tabsContainerInvalidationFlags.invalidateAll$react_native_screens_release();
    }

    /* JADX INFO: compiled from: TabsContainer.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\t"}, d2 = {"Lcom/swmansion/rnscreens/gamma/tabs/container/TabsContainer$SpecialEffectsHandler;", "", "<init>", "(Lcom/swmansion/rnscreens/gamma/tabs/container/TabsContainer;)V", "handleRepeatedTabSelection", "", "trySmoothScrollToTop", "maybeScrollView", "Landroid/view/ViewGroup;", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    private final class SpecialEffectsHandler {
        public SpecialEffectsHandler() {
        }

        public final boolean handleRepeatedTabSelection() {
            ViewGroup viewGroupFindContentScrollView;
            ScreenStack screenStackFindScreenStackInFirstDescendantChain;
            TabsScreen tabsScreen = TabsContainer.this.getSelectedTab$react_native_screens_release().getTabsScreen();
            if (tabsScreen.getShouldUseRepeatedTabSelectionPopToRootSpecialEffect() && (screenStackFindScreenStackInFirstDescendantChain = ViewFinder.INSTANCE.findScreenStackInFirstDescendantChain(tabsScreen)) != null && screenStackFindScreenStackInFirstDescendantChain.popToRoot()) {
                return true;
            }
            if (!tabsScreen.getShouldUseRepeatedTabSelectionScrollToTopSpecialEffect() || (viewGroupFindContentScrollView = tabsScreen.findContentScrollView()) == null) {
                return false;
            }
            return trySmoothScrollToTop(viewGroupFindContentScrollView);
        }

        private final boolean trySmoothScrollToTop(ViewGroup maybeScrollView) {
            if (maybeScrollView.getScrollY() <= 0) {
                return false;
            }
            if (maybeScrollView instanceof ScrollView) {
                ScrollView scrollView = (ScrollView) maybeScrollView;
                scrollView.smoothScrollTo(scrollView.getScrollX(), 0);
                return true;
            }
            if (!(maybeScrollView instanceof NestedScrollView)) {
                return false;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) maybeScrollView;
            nestedScrollView.smoothScrollTo(nestedScrollView.getScrollX(), 0);
            return true;
        }
    }

    /* JADX INFO: renamed from: getRejectStaleNavigationStateUpdates$react_native_screens_release, reason: from getter */
    public final boolean getRejectStaleNavigationStateUpdates() {
        return this.rejectStaleNavigationStateUpdates;
    }

    public final void setRejectStaleNavigationStateUpdates$react_native_screens_release(boolean z) {
        this.rejectStaleNavigationStateUpdates = z;
    }

    public final TabsScreenFragment getSelectedTab$react_native_screens_release() {
        TabsScreenFragment fragmentForScreenKey = getFragmentForScreenKey(this.navState.getSelectedScreenKey());
        if (fragmentForScreenKey != null) {
            return fragmentForScreenKey;
        }
        throw new IllegalStateException("[RNScreens] No selected tab present".toString());
    }

    /* JADX INFO: renamed from: getInvalidationFlags$react_native_screens_release, reason: from getter */
    public final TabsContainerInvalidationFlags getInvalidationFlags() {
        return this.invalidationFlags;
    }

    private final TabsNavigationStateUpdateRequest requirePendingStateUpdateRequest() {
        TabsNavigationStateUpdateRequest tabsNavigationStateUpdateRequest = this.pendingStateUpdateRequest;
        if (tabsNavigationStateUpdateRequest != null) {
            return tabsNavigationStateUpdateRequest;
        }
        throw new IllegalStateException("[RNScreens] Attempt to require nullish pendingStateUpdateRequest".toString());
    }

    private final FragmentManager getRequireFragmentManager() {
        FragmentManager fragmentManager = this.fragmentManager;
        if (fragmentManager != null) {
            return fragmentManager;
        }
        throw new IllegalStateException("[RNScreens] Attempt to use nullish FragmentManager".toString());
    }

    /* JADX INFO: renamed from: getBottomNavigationView$react_native_screens_release, reason: from getter */
    public final CustomBottomNavigationView getBottomNavigationView() {
        return this.bottomNavigationView;
    }

    public final ColorScheme getColorScheme$react_native_screens_release() {
        return this.colorSchemeCoordinator.getColorScheme$react_native_screens_release();
    }

    public final void setColorScheme$react_native_screens_release(ColorScheme colorScheme) {
        Intrinsics.checkNotNullParameter(colorScheme, "<set-?>");
        this.colorSchemeCoordinator.setColorScheme$react_native_screens_release(colorScheme);
    }

    /* JADX INFO: renamed from: getTabBarRespectsIMEInsets$react_native_screens_release, reason: from getter */
    public final boolean getTabBarRespectsIMEInsets() {
        return this.tabBarRespectsIMEInsets;
    }

    public final void setTabBarRespectsIMEInsets$react_native_screens_release(boolean z) {
        this.tabBarRespectsIMEInsets = z;
    }

    public final boolean getTabBarHidden$react_native_screens_release() {
        return ((Boolean) this.tabBarHidden.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    public final void setTabBarHidden$react_native_screens_release(boolean z) {
        this.tabBarHidden.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z));
    }

    /* JADX INFO: renamed from: getNavigationState, reason: from getter */
    public final TabsNavigationState getNavState() {
        return this.navState;
    }

    public final void submitSelectionOfTabsScreenWithKey(String screenKey) {
        Intrinsics.checkNotNullParameter(screenKey, "screenKey");
        setPendingNavigationStateUpdate$react_native_screens_release(new TabsNavigationStateUpdateRequest(screenKey, getNavState().getProvenance(), TabsActionOrigin.PROGRAMMATIC_NATIVE));
    }

    public final void flushPendingUpdates() {
        if (this.invalidationFlags.any$react_native_screens_release() && isAttachedToWindow()) {
            performContainerUpdate();
        }
    }

    public final boolean addNavigationStateObserver(TabsNavigationStateObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        return this.observerRegistry.add(observer);
    }

    public final boolean removeNavigationStateObserver(TabsNavigationStateObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        return this.observerRegistry.remove(observer);
    }

    public final void setPendingNavigationStateUpdate$react_native_screens_release(TabsNavigationStateUpdateRequest request) {
        this.pendingStateUpdateRequest = request;
        this.invalidationFlags.setSelectedTabInvalidated(request != null);
    }

    public final void addTabsScreenAt$react_native_screens_release(int index, TabsScreen tabsScreen) {
        Intrinsics.checkNotNullParameter(tabsScreen, "tabsScreen");
        this.tabsModel.add(index, new TabsScreenFragment(tabsScreen));
        this.invalidationFlags.invalidateAll$react_native_screens_release();
    }

    public final TabsScreen removeTabsScreenAt$react_native_screens_release(int index) {
        TabsScreen tabsScreen = this.tabsModel.remove(index).getTabsScreen();
        this.invalidationFlags.invalidateAll$react_native_screens_release();
        return tabsScreen;
    }

    static final boolean removeTabsScreen$lambda$0(TabsScreen tabsScreen, TabsScreenFragment it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getTabsScreen() == tabsScreen;
    }

    public final boolean removeTabsScreen$react_native_screens_release(final TabsScreen tabsScreen) {
        Intrinsics.checkNotNullParameter(tabsScreen, "tabsScreen");
        List<TabsScreenFragment> list = this.tabsModel;
        final Function1 function1 = new Function1() { // from class: com.swmansion.rnscreens.gamma.tabs.container.TabsContainer$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(TabsContainer.removeTabsScreen$lambda$0(tabsScreen, (TabsScreenFragment) obj));
            }
        };
        boolean zRemoveIf = list.removeIf(new Predicate() { // from class: com.swmansion.rnscreens.gamma.tabs.container.TabsContainer$$ExternalSyntheticLambda2
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((Boolean) function1.invoke(obj)).booleanValue();
            }
        });
        if (zRemoveIf) {
            this.invalidationFlags.invalidateAll$react_native_screens_release();
        }
        return zRemoveIf;
    }

    public final void removeAllTabsScreens$react_native_screens_release() {
        this.tabsModel.clear();
        this.invalidationFlags.invalidateAll$react_native_screens_release();
    }

    public final void setupFragmentManager$react_native_screens_release() {
        FragmentManager fragmentManagerFindFragmentManagerForView = FragmentManagerHelper.INSTANCE.findFragmentManagerForView(this);
        if (fragmentManagerFindFragmentManagerForView != null) {
            this.fragmentManager = fragmentManagerFindFragmentManagerForView;
            return;
        }
        throw new IllegalStateException("[RNScreens] Nullish fragment manager - can't run container operations".toString());
    }

    public final void teardownFragmentManager$react_native_screens_release() {
        this.fragmentManager = null;
    }

    public final void tearDown$react_native_screens_release() {
        this.observerRegistry.clear();
        setPendingNavigationStateUpdate$react_native_screens_release(null);
    }

    public final void onAfterSetSelectedItemId$react_native_screens_release(int itemId, TabsActionOrigin actionOrigin) {
        Intrinsics.checkNotNullParameter(actionOrigin, "actionOrigin");
        if (actionOrigin == TabsActionOrigin.USER) {
            performPostSelectedTabUpdateActions();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        RNSLog.INSTANCE.d(TAG, "TabsContainer [" + getId() + "] attached to window");
        super.onAttachedToWindow();
        this.parentContainerRegistry.attach(this);
        setupFragmentManager$react_native_screens_release();
        if (this.navState.isNotEmpty$react_native_screens_release()) {
            restoreNavigationStateIfNeeded();
        }
        flushPendingUpdates();
        this.colorSchemeCoordinator.setup$react_native_screens_release(this, new Function1() { // from class: com.swmansion.rnscreens.gamma.tabs.container.TabsContainer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TabsContainer.onAttachedToWindow$lambda$0(this.f$0, ((Integer) obj).intValue());
            }
        });
    }

    static final Unit onAttachedToWindow$lambda$0(TabsContainer tabsContainer, int i) {
        tabsContainer.applyDayNightUiMode(i);
        return Unit.INSTANCE;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        teardownFragmentManager$react_native_screens_release();
        this.parentContainerRegistry.detach(this);
        this.colorSchemeCoordinator.teardown$react_native_screens_release();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        this.colorSchemeCoordinator.onConfigurationChanged$react_native_screens_release(newConfig);
    }

    @Override // android.view.ViewGroup, android.view.View
    public WindowInsets dispatchApplyWindowInsets(WindowInsets insets) {
        if (!(insets != null ? insets.isConsumed() : true)) {
            for (View view : ViewGroupKt.getChildren(this)) {
                if (view == this.bottomNavigationView) {
                    ((CustomBottomNavigationView) view).dispatchApplyWindowInsets(getInsetsForBottomNavigationView(insets));
                } else {
                    view.dispatchApplyWindowInsets(insets);
                }
            }
        }
        return insets;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        if (!(view instanceof BottomNavigationView)) {
            throw new IllegalArgumentException(("[RNScreens] TabsContainer's onLayoutChange expects BottomNavigationView, received " + view + " instead").toString());
        }
        int i = bottom - top;
        if (i != oldBottom - oldTop) {
            updateInterfaceInsets(Integer.valueOf(i));
        }
    }

    @Override // com.swmansion.rnscreens.safearea.SafeAreaProvider
    public void setOnInterfaceInsetsChangeListener(SafeAreaView listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.interfaceInsetsChangeListener == null) {
            this.bottomNavigationView.addOnLayoutChangeListener(this);
        }
        this.interfaceInsetsChangeListener = listener;
    }

    @Override // com.swmansion.rnscreens.safearea.SafeAreaProvider
    public void removeOnInterfaceInsetsChangeListener(SafeAreaView listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (Intrinsics.areEqual(this.interfaceInsetsChangeListener, listener)) {
            this.interfaceInsetsChangeListener = null;
            this.bottomNavigationView.removeOnLayoutChangeListener(this);
        }
    }

    @Override // com.swmansion.rnscreens.safearea.SafeAreaProvider
    public EdgeInsets getInterfaceInsets() {
        return new EdgeInsets(0.0f, 0.0f, 0.0f, this.bottomNavigationView.getHeight());
    }

    @Override // com.swmansion.rnscreens.gamma.common.colorscheme.ColorSchemeProviding
    public int getResolvedUiNightMode() {
        return this.colorSchemeCoordinator.getResolvedUiNightMode();
    }

    @Override // com.swmansion.rnscreens.gamma.common.colorscheme.ColorSchemeProviding
    public void addColorSchemeListener(ColorSchemeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.colorSchemeCoordinator.addColorSchemeListener(listener);
    }

    @Override // com.swmansion.rnscreens.gamma.common.colorscheme.ColorSchemeProviding
    public void removeColorSchemeListener(ColorSchemeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.colorSchemeCoordinator.removeColorSchemeListener(listener);
    }

    @Override // com.swmansion.rnscreens.gamma.tabs.screen.TabsScreenDelegate
    public void onAppearanceChanged(TabsScreen tabsScreen) {
        Intrinsics.checkNotNullParameter(tabsScreen, "tabsScreen");
        if (isAttachedToWindow() && getSelectedTab$react_native_screens_release().getTabsScreen() == tabsScreen) {
            this.invalidationFlags.setNavigationMenuAppearanceInvalidated(true);
            post(new Runnable() { // from class: com.swmansion.rnscreens.gamma.tabs.container.TabsContainer$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.flushPendingUpdates();
                }
            });
        }
    }

    @Override // com.swmansion.rnscreens.gamma.tabs.screen.TabsScreenDelegate
    public void onMenuItemAttributesChange(TabsScreen tabsScreen) {
        Intrinsics.checkNotNullParameter(tabsScreen, "tabsScreen");
        MenuItem menuItemForTabsScreen = getMenuItemForTabsScreen(tabsScreen);
        if (menuItemForTabsScreen != null) {
            this.appearanceCoordinator.updateMenuItemAppearance$react_native_screens_release(this.themedContext, menuItemForTabsScreen, tabsScreen, getSelectedTab$react_native_screens_release().getTabsScreen().getAppearance$react_native_screens_release());
            this.a11yCoordinator.setA11yPropertiesToTabItem(menuItemForTabsScreen, tabsScreen);
        }
    }

    @Override // com.swmansion.rnscreens.gamma.tabs.screen.TabsScreenDelegate
    public TabsScreenFragment getFragmentForTabsScreen(TabsScreen tabsScreen) {
        Object next;
        Intrinsics.checkNotNullParameter(tabsScreen, "tabsScreen");
        Iterator<T> it = this.tabsModel.iterator();
        while (it.hasNext()) {
            next = it.next();
            if (((TabsScreenFragment) next).getTabsScreen() == tabsScreen) {
                return (TabsScreenFragment) next;
            }
        }
        next = null;
        return (TabsScreenFragment) next;
    }

    @Override // com.swmansion.rnscreens.gamma.tabs.screen.TabsScreenDelegate
    public void onFragmentConfigurationChange(TabsScreen tabsScreen, Configuration config) {
        Intrinsics.checkNotNullParameter(tabsScreen, "tabsScreen");
        Intrinsics.checkNotNullParameter(config, "config");
        onConfigurationChanged(config);
    }

    private final void performContainerUpdate() {
        performPreSelectedTabUpdateActions();
        performSelectedTabUpdateIfNeeded();
        performPostSelectedTabUpdateActions();
    }

    private final void performPreSelectedTabUpdateActions() {
        updateNavigationMenuStructureIfNeeded();
    }

    private final void performPostSelectedTabUpdateActions() {
        updateBottomNavigationViewAppearanceIfNeeded();
    }

    private final void updateNavigationMenuStructureIfNeeded() {
        if (this.invalidationFlags.getIsNavigationMenuStructureInvalidated()) {
            this.invalidationFlags.setNavigationMenuStructureInvalidated(false);
            updateNavigationMenuStructure();
        }
    }

    private final void performSelectedTabUpdateIfNeeded() {
        if (this.invalidationFlags.getIsSelectedTabInvalidated()) {
            this.invalidationFlags.setSelectedTabInvalidated(false);
            performSelectedTabUpdate();
        }
    }

    private final void updateBottomNavigationViewAppearanceIfNeeded() {
        if (this.invalidationFlags.getIsNavigationMenuAppearanceInvalidated()) {
            this.invalidationFlags.setNavigationMenuAppearanceInvalidated(false);
            updateBottomNavigationViewAppearance();
            this.a11yCoordinator.setA11yPropertiesToAllTabItems();
        }
    }

    private final void performSelectedTabUpdate() {
        if (this.pendingStateUpdateRequest == null) {
            RNSLog.INSTANCE.w(TAG, "TabsContainer::performSelectedTabUpdate called w/o pending operation; skipping update");
            return;
        }
        TabsNavigationStateUpdateRequest tabsNavigationStateUpdateRequestRequirePendingStateUpdateRequest = requirePendingStateUpdateRequest();
        Integer menuItemIdForFragment = getMenuItemIdForFragment(requireFragmentForScreenKey(tabsNavigationStateUpdateRequestRequirePendingStateUpdateRequest.getSelectedScreenKey()));
        if (menuItemIdForFragment == null) {
            throw new IllegalStateException(("[RNScreens] Failed to find Menu Item for screenKey: " + tabsNavigationStateUpdateRequestRequirePendingStateUpdateRequest.getSelectedScreenKey()).toString());
        }
        int iIntValue = menuItemIdForFragment.intValue();
        if (this.rejectStaleNavigationStateUpdates && isNavigationStateStale(tabsNavigationStateUpdateRequestRequirePendingStateUpdateRequest)) {
            this.observerRegistry.emitOnNavigationStateUpdateRejected(this.navState, tabsNavigationStateUpdateRequestRequirePendingStateUpdateRequest, TabsNavigationStateRejectionReason.STALE);
            this.pendingStateUpdateRequest = null;
            return;
        }
        if (this.bottomNavigationView.getSelectedItemId() != iIntValue || this.navState.isEmpty$react_native_screens_release()) {
            this.isInExternalOperationContext = true;
            this.bottomNavigationView.setSelectedItemIdWithActionOrigin$react_native_screens_release(iIntValue, tabsNavigationStateUpdateRequestRequirePendingStateUpdateRequest.getActionOrigin());
            this.isInExternalOperationContext = false;
        } else {
            this.observerRegistry.emitOnNavigationStateUpdateRejected(this.navState, tabsNavigationStateUpdateRequestRequirePendingStateUpdateRequest, TabsNavigationStateRejectionReason.REPEATED);
        }
        this.pendingStateUpdateRequest = null;
    }

    private final void updateNavigationMenuStructure() {
        Menu menu = this.bottomNavigationView.getMenu();
        Intrinsics.checkNotNullExpressionValue(menu, "getMenu(...)");
        if (menu.size() == this.tabsModel.size()) {
            Iterable<IndexedValue> iterableWithIndex = CollectionsKt.withIndex(this.tabsModel);
            if ((iterableWithIndex instanceof Collection) && ((Collection) iterableWithIndex).isEmpty()) {
                return;
            }
            for (IndexedValue indexedValue : iterableWithIndex) {
                if (menu.getItem(indexedValue.getIndex()).getItemId() == ((TabsScreenFragment) indexedValue.component2()).getMenuItemId()) {
                }
            }
            return;
        }
        menu.clear();
        Iterator<T> it = this.tabsModel.iterator();
        while (it.hasNext()) {
            MenuHelpersKt.getOrCreateMenuItemForFragment(menu, (TabsScreenFragment) it.next());
        }
    }

    private final void updateBottomNavigationViewAppearance() {
        RNSLog.INSTANCE.d(TAG, "updateBottomNavigationViewAppearance");
        this.appearanceCoordinator.updateTabAppearance(this.themedContext, this);
        post(new Runnable() { // from class: com.swmansion.rnscreens.gamma.tabs.container.TabsContainer$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.requestLayout();
            }
        });
    }

    private final boolean updateNavigationStateAndSelectedFragment(TabsScreenFragment nextSelectedFragment, TabsActionOrigin actionOrigin) {
        if (this.navState.isEmpty$react_native_screens_release()) {
            if (!this.isInExternalOperationContext || this.pendingStateUpdateRequest == null) {
                throw new IllegalStateException("Check failed.");
            }
            initNavigationState(nextSelectedFragment.getRequireScreenKey$react_native_screens_release());
            applyInitialStateToFragmentManagerSync(nextSelectedFragment);
            return true;
        }
        TabsScreenFragment selectedTab$react_native_screens_release = getSelectedTab$react_native_screens_release();
        if (nextSelectedFragment == selectedTab$react_native_screens_release) {
            progressNavigationState(this.navState.getSelectedScreenKey(), actionOrigin);
            return true;
        }
        progressNavigationState(nextSelectedFragment.getRequireScreenKey$react_native_screens_release(), actionOrigin);
        applyNextSelectedFragmentToFragmentManagerSync(selectedTab$react_native_screens_release, nextSelectedFragment);
        return true;
    }

    private final void applyInitialStateToFragmentManagerSync(TabsScreenFragment nextSelectedFragment) {
        FragmentTransaction fragmentTransactionCreateTransactionWithReordering = FragmentManagerHelperKt.createTransactionWithReordering(getRequireFragmentManager());
        for (TabsScreenFragment tabsScreenFragment : this.tabsModel) {
            fragmentTransactionCreateTransactionWithReordering.add(this.contentView.getId(), tabsScreenFragment);
            fragmentTransactionCreateTransactionWithReordering.detach(tabsScreenFragment);
        }
        fragmentTransactionCreateTransactionWithReordering.attach(nextSelectedFragment).commitNowAllowingStateLoss();
    }

    private final void applyNextSelectedFragmentToFragmentManagerSync(TabsScreenFragment currSelectedFragment, TabsScreenFragment nextSelectedFragment) {
        FragmentTransaction fragmentTransactionCreateTransactionWithReordering = FragmentManagerHelperKt.createTransactionWithReordering(getRequireFragmentManager());
        fragmentTransactionCreateTransactionWithReordering.detach(currSelectedFragment);
        fragmentTransactionCreateTransactionWithReordering.attach(nextSelectedFragment).commitNowAllowingStateLoss();
    }

    private final void initNavigationState(String selectedScreenKey) {
        if (!this.navState.isEmpty$react_native_screens_release()) {
            throw new IllegalStateException("[RNScreens] Navigation state is already initialized!".toString());
        }
        this.navState = new TabsNavigationState(selectedScreenKey, 0);
    }

    private final void progressNavigationState(String selectedScreenKey, TabsActionOrigin actionOrigin) {
        this.navState = new TabsNavigationState(selectedScreenKey, this.navState.getProvenance() + 1);
        if (actionOrigin != TabsActionOrigin.PROGRAMMATIC_JS) {
            this.lastUINavState = this.navState;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean onMenuItemSelected(MenuItem item) {
        TabsActionOrigin actionOrigin;
        RNSLog.INSTANCE.d(TabsHost.TAG, "Item selected " + item);
        TabsScreenFragment selectedTab$react_native_screens_release = this.navState.isNotEmpty$react_native_screens_release() ? getSelectedTab$react_native_screens_release() : null;
        TabsScreenFragment fragmentForMenuItemId = getFragmentForMenuItemId(item.getItemId());
        if (fragmentForMenuItemId == null) {
            throw new IllegalStateException(("[RNScreens] Can not select item with id: " + item.getItemId() + " - associated fragment does not exist").toString());
        }
        boolean z = fragmentForMenuItemId == selectedTab$react_native_screens_release;
        if (this.isInExternalOperationContext) {
            actionOrigin = requirePendingStateUpdateRequest().getActionOrigin();
        } else {
            actionOrigin = TabsActionOrigin.USER;
        }
        if (!z && actionOrigin == TabsActionOrigin.USER && fragmentForMenuItemId.isPreventNativeSelectionEnabled$react_native_screens_release()) {
            this.observerRegistry.emitOnNavigationStateUpdatePrevented(this.navState, fragmentForMenuItemId.getRequireScreenKey$react_native_screens_release());
            return false;
        }
        boolean zUpdateNavigationStateAndSelectedFragment = updateNavigationStateAndSelectedFragment(fragmentForMenuItemId, actionOrigin);
        boolean zHandleRepeatedTabSelection = z ? this.specialEffectsHandler.handleRepeatedTabSelection() : false;
        if (zUpdateNavigationStateAndSelectedFragment && !z) {
            this.invalidationFlags.invalidateOnSelectedTabChanged$react_native_screens_release();
        }
        if (zUpdateNavigationStateAndSelectedFragment) {
            this.observerRegistry.emitOnNavigationStateUpdate(this.navState, z, zHandleRepeatedTabSelection, actionOrigin);
        }
        return true;
    }

    private final void restoreNavigationStateIfNeeded() {
        if (this.navState.isEmpty$react_native_screens_release()) {
            return;
        }
        List<Fragment> fragments = getRequireFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "getFragments(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : fragments) {
            if (obj instanceof TabsScreenFragment) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (this.tabsModel.contains((TabsScreenFragment) obj2)) {
                arrayList2.add(obj2);
            }
        }
        List list = CollectionsKt.toList(arrayList2);
        if (list.size() == 1 && CollectionsKt.first(list) == getSelectedTab$react_native_screens_release()) {
            return;
        }
        if (list.isEmpty()) {
            applyInitialStateToFragmentManagerSync(getSelectedTab$react_native_screens_release());
            return;
        }
        throw new IllegalStateException("[RNScreens] Unexpected fragment manager state.".toString());
    }

    private final void applyDayNightUiMode(int uiMode) {
        if (uiMode != 16) {
            ContextThemeWrapper contextThemeWrapper = this.themedContext;
            if (uiMode == 32) {
                contextThemeWrapper.setTheme(R.style.Theme_Material3_Dark_NoActionBar);
            } else {
                contextThemeWrapper.setTheme(R.style.Theme_Material3_DayNight_NoActionBar);
            }
        } else {
            this.themedContext.setTheme(R.style.Theme_Material3_Light_NoActionBar);
        }
        this.appearanceCoordinator.updateTabAppearance(this.themedContext, this);
    }

    private final TabsScreenFragment getFragmentForMenuItemId(int itemId) {
        Object next;
        Iterator<T> it = this.tabsModel.iterator();
        while (it.hasNext()) {
            next = it.next();
            if (((TabsScreenFragment) next).getMenuItemId() == itemId) {
                return (TabsScreenFragment) next;
            }
        }
        next = null;
        return (TabsScreenFragment) next;
    }

    private final Integer getMenuItemIdForFragment(TabsScreenFragment tabsScreenFragment) {
        Integer numValueOf = Integer.valueOf(tabsScreenFragment.getMenuItemId());
        numValueOf.intValue();
        List<TabsScreenFragment> list = this.tabsModel;
        if ((list instanceof Collection) && list.isEmpty()) {
            return null;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (((TabsScreenFragment) it.next()) == tabsScreenFragment) {
                return numValueOf;
            }
        }
        return null;
    }

    private final Integer getSelectedTabsScreenFragmentId() {
        Iterator<TabsScreenFragment> it = this.tabsModel.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (Intrinsics.areEqual(it.next().getRequireScreenKey$react_native_screens_release(), this.navState.getSelectedScreenKey())) {
                break;
            }
            i++;
        }
        Integer numValueOf = Integer.valueOf(i);
        if (numValueOf.intValue() != -1) {
            return numValueOf;
        }
        return null;
    }

    private final MenuItem getMenuItemForTabsScreen(TabsScreen tabsScreen) {
        Object next;
        Iterator<T> it = this.tabsModel.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (((TabsScreenFragment) next).getTabsScreen() != tabsScreen);
        TabsScreenFragment tabsScreenFragment = (TabsScreenFragment) next;
        if (tabsScreenFragment != null) {
            return this.bottomNavigationView.getMenu().findItem(tabsScreenFragment.getMenuItemId());
        }
        return null;
    }

    private final TabsScreenFragment getFragmentForScreenKey(String screenKey) {
        Object next;
        Iterator<T> it = this.tabsModel.iterator();
        while (it.hasNext()) {
            next = it.next();
            if (Intrinsics.areEqual(((TabsScreenFragment) next).getRequireScreenKey$react_native_screens_release(), screenKey)) {
                return (TabsScreenFragment) next;
            }
        }
        next = null;
        return (TabsScreenFragment) next;
    }

    private final TabsScreenFragment requireFragmentForScreenKey(String screenKey) {
        TabsScreenFragment fragmentForScreenKey = getFragmentForScreenKey(screenKey);
        if (fragmentForScreenKey != null) {
            return fragmentForScreenKey;
        }
        throw new IllegalStateException(("[RNScreens] Requested fragment for key: " + screenKey + " does not exist").toString());
    }

    static /* synthetic */ void updateInterfaceInsets$default(TabsContainer tabsContainer, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        tabsContainer.updateInterfaceInsets(num);
    }

    private final void updateInterfaceInsets(Integer newHeight) {
        int iIntValue;
        if (getTabBarHidden$react_native_screens_release()) {
            iIntValue = 0;
        } else {
            iIntValue = newHeight != null ? newHeight.intValue() : this.bottomNavigationView.getHeight();
        }
        SafeAreaView safeAreaView = this.interfaceInsetsChangeListener;
        if (safeAreaView != null) {
            safeAreaView.onInterfaceInsetsChange(new EdgeInsets(0.0f, 0.0f, 0.0f, iIntValue));
        }
    }

    private final WindowInsets getInsetsForBottomNavigationView(WindowInsets insets) {
        if (this.tabBarRespectsIMEInsets) {
            return insets;
        }
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(insets, this);
        Intrinsics.checkNotNullExpressionValue(windowInsetsCompat, "toWindowInsetsCompat(...)");
        return new WindowInsetsCompat.Builder(windowInsetsCompat).setInsets(WindowInsetsCompat.Type.ime(), Insets.NONE).build().toWindowInsets();
    }

    private final boolean isNavigationStateStale(TabsNavigationStateUpdateRequest request) {
        return (this.navState.isEmpty$react_native_screens_release() || this.lastUINavState.isEmpty$react_native_screens_release() || request.getBaseProvenance() >= this.lastUINavState.getProvenance()) ? false : true;
    }

    @Override // com.swmansion.rnscreens.gamma.common.container.Container
    public ViewGroup resolveCurrentContentScrollView() {
        return getSelectedTab$react_native_screens_release().getTabsScreen().findContentScrollView();
    }
}
