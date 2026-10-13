package com.swmansion.rnscreens.gamma.stack.header;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.bridge.ReactContext;
import com.google.android.material.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.swmansion.rnscreens.gamma.stack.header.config.OnHeaderConfigurationAttachListener;
import com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfigurationObserver;
import com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfigurationProviding;
import com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderDelegate;
import com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderInvalidationFlags;
import com.swmansion.rnscreens.gamma.stack.header.subview.StackHeaderSubviewProviding;
import com.swmansion.rnscreens.gamma.stack.header.toolbar.StackHeaderToolbarMenuElementUpdate;
import com.swmansion.rnscreens.gamma.stack.header.toolbar.StackHeaderToolbarMenuGroupMetadata;
import com.swmansion.rnscreens.gamma.stack.screen.StackScreen;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StackHeaderCoordinatorLayout.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u009d\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0017\b\u0001\u0018\u0000 M2\u00020\u0001:\u0001MB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0002J\u0010\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010!\u001a\u00020\u0013H\u0002J\u0018\u0010\"\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\rH\u0002J\u0018\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020&2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u00104\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\rH\u0002J+\u00105\u001a\u0004\u0018\u00010.2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020.2\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010:J\u0018\u0010;\u001a\u00020\u00132\u0006\u00106\u001a\u0002072\u0006\u0010<\u001a\u00020.H\u0002J\u001e\u0010=\u001a\b\u0012\u0004\u0012\u00020.0>2\u0006\u00106\u001a\u0002072\u0006\u0010<\u001a\u00020.H\u0002J\b\u0010?\u001a\u00020\u0013H\u0002J\b\u0010@\u001a\u00020\u0013H\u0002J\r\u0010A\u001a\u00020\u0013H\u0000¢\u0006\u0002\bBJ\r\u0010C\u001a\u00020\u0013H\u0000¢\u0006\u0002\bDJ\r\u0010K\u001a\u00020\u0013H\u0000¢\u0006\u0002\bLR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/0-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00102\u001a\b\u0012\u0004\u0012\u00020\u001303X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010E\u001a\u00020FX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010J¨\u0006N"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/header/StackHeaderCoordinatorLayout;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "stackScreen", "Lcom/swmansion/rnscreens/gamma/stack/screen/StackScreen;", "canNavigateBack", "", "<init>", "(Landroid/content/Context;Lcom/swmansion/rnscreens/gamma/stack/screen/StackScreen;Z)V", "getStackScreen$react_native_screens_release", "()Lcom/swmansion/rnscreens/gamma/stack/screen/StackScreen;", "currentProvider", "Lcom/swmansion/rnscreens/gamma/stack/header/config/StackHeaderConfigurationProviding;", "currentDelegate", "Lcom/swmansion/rnscreens/gamma/stack/header/config/StackHeaderDelegate;", "onHeaderConfigAttached", "Lcom/swmansion/rnscreens/gamma/stack/header/config/OnHeaderConfigurationAttachListener;", "handleHeaderConfigAttach", "", "provider", "delegate", "configObserver", "com/swmansion/rnscreens/gamma/stack/header/StackHeaderCoordinatorLayout$configObserver$1", "Lcom/swmansion/rnscreens/gamma/stack/header/StackHeaderCoordinatorLayout$configObserver$1;", "appBarOffsetListener", "Lcom/google/android/material/appbar/AppBarLayout$OnOffsetChangedListener;", "appBarLayoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "attachAppBarListeners", "appBar", "Lcom/swmansion/rnscreens/gamma/stack/header/StackHeaderAppBarLayout;", "detachAppBarListeners", "onMaybeHeaderLayoutChanged", "updateSubviewOffsets", "config", "updateSubviewOffset", "subview", "Lcom/swmansion/rnscreens/gamma/stack/header/subview/StackHeaderSubviewProviding;", "wrappedContext", "Landroidx/appcompat/view/ContextThemeWrapper;", "applicator", "Lcom/swmansion/rnscreens/gamma/stack/header/StackHeaderApplicator;", "appBarLayout", "toolbarMenuForwardIdMap", "", "", "", "toolbarMenuGroupMetadata", "Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuGroupMetadata;", "onNavigationIconClick", "Lkotlin/Function0;", "processUpdate", "applyGroupItemStateChange", "toolbar", "Lcom/google/android/material/appbar/MaterialToolbar;", "itemId", "explicitCheckedValue", "(Lcom/google/android/material/appbar/MaterialToolbar;Ljava/lang/String;Ljava/lang/Boolean;)Ljava/lang/String;", "emitGroupSelection", "groupId", "collectSelectedIds", "", "resetHeader", "removeHeader", "setContentBehavior", "setContentBehavior$react_native_screens_release", "removeContentBehavior", "removeContentBehavior$react_native_screens_release", "stackScreenWrapper", "Landroid/widget/FrameLayout;", "getStackScreenWrapper$react_native_screens_release", "()Landroid/widget/FrameLayout;", "setStackScreenWrapper$react_native_screens_release", "(Landroid/widget/FrameLayout;)V", "tearDown", "tearDown$react_native_screens_release", "Companion", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class StackHeaderCoordinatorLayout extends CoordinatorLayout {
    private static final String TAG = "StackHeaderCoordinatorLayout";
    private StackHeaderAppBarLayout appBarLayout;
    private final View.OnLayoutChangeListener appBarLayoutChangeListener;
    private final AppBarLayout.OnOffsetChangedListener appBarOffsetListener;
    private final StackHeaderApplicator applicator;
    private final boolean canNavigateBack;
    private final StackHeaderCoordinatorLayout$configObserver$1 configObserver;
    private StackHeaderDelegate currentDelegate;
    private StackHeaderConfigurationProviding currentProvider;
    private final OnHeaderConfigurationAttachListener onHeaderConfigAttached;
    private final Function0<Unit> onNavigationIconClick;
    private final StackScreen stackScreen;
    private FrameLayout stackScreenWrapper;
    private Map<String, Integer> toolbarMenuForwardIdMap;
    private StackHeaderToolbarMenuGroupMetadata toolbarMenuGroupMetadata;
    private final ContextThemeWrapper wrappedContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.swmansion.rnscreens.gamma.stack.header.StackHeaderCoordinatorLayout$configObserver$1] */
    public StackHeaderCoordinatorLayout(Context context, StackScreen stackScreen, boolean z) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(stackScreen, "stackScreen");
        this.stackScreen = stackScreen;
        this.canNavigateBack = z;
        OnHeaderConfigurationAttachListener onHeaderConfigurationAttachListener = new OnHeaderConfigurationAttachListener() { // from class: com.swmansion.rnscreens.gamma.stack.header.StackHeaderCoordinatorLayout$$ExternalSyntheticLambda2
            @Override // com.swmansion.rnscreens.gamma.stack.header.config.OnHeaderConfigurationAttachListener
            public final void onHeaderConfigAttached(StackHeaderConfigurationProviding stackHeaderConfigurationProviding, StackHeaderDelegate stackHeaderDelegate) {
                this.f$0.handleHeaderConfigAttach(stackHeaderConfigurationProviding, stackHeaderDelegate);
            }
        };
        this.onHeaderConfigAttached = onHeaderConfigurationAttachListener;
        this.configObserver = new StackHeaderConfigurationObserver() { // from class: com.swmansion.rnscreens.gamma.stack.header.StackHeaderCoordinatorLayout$configObserver$1
            @Override // com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfigurationObserver
            public void onConfigChanged(StackHeaderConfigurationProviding config) {
                Intrinsics.checkNotNullParameter(config, "config");
                this.this$0.processUpdate(config);
            }

            @Override // com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfigurationObserver
            public void onMenuElementsUpdated(List<StackHeaderToolbarMenuElementUpdate> updates) {
                String strApplyGroupItemStateChange;
                Intrinsics.checkNotNullParameter(updates, "updates");
                StackHeaderAppBarLayout stackHeaderAppBarLayout = this.this$0.appBarLayout;
                MaterialToolbar toolbar = stackHeaderAppBarLayout != null ? stackHeaderAppBarLayout.getToolbar() : null;
                if (toolbar == null) {
                    Log.w("StackHeaderCoordinatorLayout", "[RNScreens] Dropping " + updates.size() + " resolved toolbar menu update(s): the header toolbar is not currently attached (header hidden or detached).");
                    return;
                }
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                for (StackHeaderToolbarMenuElementUpdate stackHeaderToolbarMenuElementUpdate : updates) {
                    this.this$0.applicator.updateToolbarMenuElement(toolbar, this.this$0.toolbarMenuForwardIdMap, stackHeaderToolbarMenuElementUpdate.getId(), stackHeaderToolbarMenuElementUpdate.getOptions());
                    Boolean checked = stackHeaderToolbarMenuElementUpdate.getOptions().getChecked();
                    if (checked != null && (strApplyGroupItemStateChange = this.this$0.applyGroupItemStateChange(toolbar, stackHeaderToolbarMenuElementUpdate.getId(), checked)) != null) {
                        linkedHashSet.add(strApplyGroupItemStateChange);
                    }
                }
                StackHeaderCoordinatorLayout stackHeaderCoordinatorLayout = this.this$0;
                Iterator it = linkedHashSet.iterator();
                while (it.hasNext()) {
                    stackHeaderCoordinatorLayout.emitGroupSelection(toolbar, (String) it.next());
                }
            }
        };
        this.appBarOffsetListener = new AppBarLayout.OnOffsetChangedListener() { // from class: com.swmansion.rnscreens.gamma.stack.header.StackHeaderCoordinatorLayout$$ExternalSyntheticLambda3
            @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
            public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                this.f$0.onMaybeHeaderLayoutChanged();
            }
        };
        this.appBarLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.swmansion.rnscreens.gamma.stack.header.StackHeaderCoordinatorLayout$$ExternalSyntheticLambda4
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                this.f$0.onMaybeHeaderLayoutChanged();
            }
        };
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, R.style.Theme_Material3_DayNight_NoActionBar);
        this.wrappedContext = contextThemeWrapper;
        this.applicator = new StackHeaderApplicator(contextThemeWrapper);
        this.toolbarMenuForwardIdMap = MapsKt.emptyMap();
        this.toolbarMenuGroupMetadata = StackHeaderToolbarMenuGroupMetadata.INSTANCE.getEMPTY();
        this.onNavigationIconClick = new Function0() { // from class: com.swmansion.rnscreens.gamma.stack.header.StackHeaderCoordinatorLayout$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StackHeaderCoordinatorLayout.onNavigationIconClick$lambda$0(this.f$0);
            }
        };
        setTransitionGroup(true);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.addView(stackScreen);
        this.stackScreenWrapper = frameLayout;
        addView(frameLayout, new CoordinatorLayout.LayoutParams(-1, -1));
        stackScreen.registerHeaderConfigAttachListener$react_native_screens_release(onHeaderConfigurationAttachListener);
    }

    /* JADX INFO: renamed from: getStackScreen$react_native_screens_release, reason: from getter */
    public final StackScreen getStackScreen() {
        return this.stackScreen;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleHeaderConfigAttach(StackHeaderConfigurationProviding provider, StackHeaderDelegate delegate) {
        StackHeaderConfigurationProviding stackHeaderConfigurationProviding = this.currentProvider;
        if (stackHeaderConfigurationProviding != null) {
            stackHeaderConfigurationProviding.setConfigurationObserver(null);
        }
        this.currentProvider = provider;
        this.currentDelegate = delegate;
        if (provider != null) {
            provider.setConfigurationObserver(this.configObserver);
            processUpdate(provider);
        } else {
            removeHeader();
        }
    }

    private final void attachAppBarListeners(StackHeaderAppBarLayout appBar) {
        appBar.addOnOffsetChangedListener(this.appBarOffsetListener);
        appBar.addOnLayoutChangeListener(this.appBarLayoutChangeListener);
    }

    private final void detachAppBarListeners(StackHeaderAppBarLayout appBar) {
        appBar.removeOnOffsetChangedListener(this.appBarOffsetListener);
        appBar.removeOnLayoutChangeListener(this.appBarLayoutChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onMaybeHeaderLayoutChanged() {
        StackHeaderConfigurationProviding stackHeaderConfigurationProviding;
        StackHeaderAppBarLayout stackHeaderAppBarLayout;
        StackHeaderDelegate stackHeaderDelegate = this.currentDelegate;
        if (stackHeaderDelegate == null || (stackHeaderConfigurationProviding = this.currentProvider) == null || (stackHeaderAppBarLayout = this.appBarLayout) == null) {
            return;
        }
        stackHeaderDelegate.onHeaderFrameChanged(stackHeaderAppBarLayout.getWidth(), stackHeaderAppBarLayout.getHeight(), stackHeaderConfigurationProviding.getTransparent() ? stackHeaderAppBarLayout.getTop() : stackHeaderAppBarLayout.getTop() - stackHeaderAppBarLayout.getBottom());
        updateSubviewOffsets(stackHeaderAppBarLayout, stackHeaderConfigurationProviding);
    }

    private final void updateSubviewOffsets(StackHeaderAppBarLayout appBar, StackHeaderConfigurationProviding config) {
        StackHeaderSubviewProviding leadingSubview = config.getLeadingSubview();
        if (leadingSubview != null) {
            updateSubviewOffset(leadingSubview, appBar);
        }
        StackHeaderSubviewProviding centerSubview = config.getCenterSubview();
        if (centerSubview != null) {
            updateSubviewOffset(centerSubview, appBar);
        }
        StackHeaderSubviewProviding trailingSubview = config.getTrailingSubview();
        if (trailingSubview != null) {
            updateSubviewOffset(trailingSubview, appBar);
        }
        StackHeaderSubviewProviding backgroundSubview = config.getBackgroundSubview();
        if (backgroundSubview != null) {
            updateSubviewOffset(backgroundSubview, appBar);
        }
    }

    private final void updateSubviewOffset(StackHeaderSubviewProviding subview, StackHeaderAppBarLayout appBar) {
        View view = subview.getView();
        if (view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        appBar.getLocationInWindow(iArr);
        view.getLocationInWindow(iArr2);
        StackHeaderDelegate stackHeaderDelegate = this.currentDelegate;
        if (stackHeaderDelegate != null) {
            stackHeaderDelegate.onSubviewOriginChanged(subview.getType(), iArr2[0] - iArr[0], iArr2[1] - iArr[1]);
        }
    }

    static final Unit onNavigationIconClick$lambda$0(StackHeaderCoordinatorLayout stackHeaderCoordinatorLayout) {
        OnBackPressedDispatcher onBackPressedDispatcher;
        Context context = stackHeaderCoordinatorLayout.stackScreen.getContext();
        ReactContext reactContext = context instanceof ReactContext ? (ReactContext) context : null;
        Activity currentActivity = reactContext != null ? reactContext.getCurrentActivity() : null;
        OnBackPressedDispatcherOwner onBackPressedDispatcherOwner = currentActivity instanceof OnBackPressedDispatcherOwner ? (OnBackPressedDispatcherOwner) currentActivity : null;
        if (onBackPressedDispatcherOwner != null && (onBackPressedDispatcher = onBackPressedDispatcherOwner.getOnBackPressedDispatcher()) != null) {
            onBackPressedDispatcher.onBackPressed();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processUpdate(StackHeaderConfigurationProviding provider) {
        boolean zM11795getNeedsRebuildimpl = StackHeaderInvalidationFlags.m11795getNeedsRebuildimpl(provider.getInvalidationFlags());
        if (zM11795getNeedsRebuildimpl) {
            resetHeader();
            if (provider.getHidden()) {
                removeContentBehavior$react_native_screens_release();
                requestLayout();
                provider.mo11786clearInvalidationFlagsgLpVZxs(StackHeaderInvalidationFlags.INSTANCE.m11802getALL2a6ZA60());
                return;
            } else {
                StackHeaderAppBarLayout stackHeaderAppBarLayoutRebuild = this.applicator.rebuild(this, provider);
                this.appBarLayout = stackHeaderAppBarLayoutRebuild;
                attachAppBarListeners(stackHeaderAppBarLayoutRebuild);
                provider.mo11786clearInvalidationFlagsgLpVZxs(StackHeaderInvalidationFlags.m11799or7cgdpso(StackHeaderInvalidationFlags.INSTANCE.m11807getSTRUCTURE2a6ZA60(), StackHeaderInvalidationFlags.INSTANCE.m11808getSUBVIEWS2a6ZA60()));
            }
        }
        final StackHeaderAppBarLayout stackHeaderAppBarLayout = this.appBarLayout;
        if (stackHeaderAppBarLayout != null) {
            if (zM11795getNeedsRebuildimpl || StackHeaderInvalidationFlags.m11792containsAnygLpVZxs(provider.getInvalidationFlags(), StackHeaderInvalidationFlags.INSTANCE.m11809getTITLE2a6ZA60())) {
                this.applicator.applyTitle(stackHeaderAppBarLayout, provider);
                provider.mo11786clearInvalidationFlagsgLpVZxs(StackHeaderInvalidationFlags.INSTANCE.m11809getTITLE2a6ZA60());
            }
            if (zM11795getNeedsRebuildimpl || StackHeaderInvalidationFlags.m11792containsAnygLpVZxs(provider.getInvalidationFlags(), StackHeaderInvalidationFlags.INSTANCE.m11804getBACK_BUTTON2a6ZA60())) {
                this.applicator.applyBackButton(stackHeaderAppBarLayout.getToolbar(), provider, this.canNavigateBack, this.onNavigationIconClick);
                provider.mo11786clearInvalidationFlagsgLpVZxs(StackHeaderInvalidationFlags.INSTANCE.m11804getBACK_BUTTON2a6ZA60());
            }
            if (zM11795getNeedsRebuildimpl || StackHeaderInvalidationFlags.m11792containsAnygLpVZxs(provider.getInvalidationFlags(), StackHeaderInvalidationFlags.INSTANCE.m11806getSCROLL_FLAGS2a6ZA60())) {
                this.applicator.applyScrollFlags(stackHeaderAppBarLayout, provider);
                provider.mo11786clearInvalidationFlagsgLpVZxs(StackHeaderInvalidationFlags.INSTANCE.m11806getSCROLL_FLAGS2a6ZA60());
            }
            if (StackHeaderInvalidationFlags.m11792containsAnygLpVZxs(provider.getInvalidationFlags(), StackHeaderInvalidationFlags.INSTANCE.m11810getTOOLBAR_MENU2a6ZA60())) {
                Pair<Map<String, Integer>, Map<Integer, String>> pairGenerateToolbarMenuItemMappings = this.applicator.generateToolbarMenuItemMappings(provider.getToolbarMenu());
                Map<String, Integer> mapComponent1 = pairGenerateToolbarMenuItemMappings.component1();
                Map<Integer, String> mapComponent2 = pairGenerateToolbarMenuItemMappings.component2();
                Map<String, Integer> mapGenerateToolbarMenuGroupMappings = this.applicator.generateToolbarMenuGroupMappings(provider.getToolbarMenu());
                StackHeaderToolbarMenuGroupMetadata stackHeaderToolbarMenuGroupMetadataComputeGroupMetadata = this.applicator.computeGroupMetadata(provider.getToolbarMenu());
                this.applicator.validateRadioInitialSelection(provider.getToolbarMenu());
                this.toolbarMenuForwardIdMap = mapComponent1;
                this.toolbarMenuGroupMetadata = stackHeaderToolbarMenuGroupMetadataComputeGroupMetadata;
                this.applicator.rebuildToolbarMenu(stackHeaderAppBarLayout.getToolbar(), provider.getToolbarMenu(), mapComponent1, mapComponent2, mapGenerateToolbarMenuGroupMappings, provider.getToolbarMenuGroupDividerEnabled(), new Function2() { // from class: com.swmansion.rnscreens.gamma.stack.header.StackHeaderCoordinatorLayout$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return StackHeaderCoordinatorLayout.processUpdate$lambda$0(this.f$0, stackHeaderAppBarLayout, (String) obj, (MenuItem) obj2);
                    }
                });
                provider.mo11786clearInvalidationFlagsgLpVZxs(StackHeaderInvalidationFlags.INSTANCE.m11810getTOOLBAR_MENU2a6ZA60());
            }
        }
        onMaybeHeaderLayoutChanged();
    }

    static final Unit processUpdate$lambda$0(StackHeaderCoordinatorLayout stackHeaderCoordinatorLayout, StackHeaderAppBarLayout stackHeaderAppBarLayout, String id, MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(menuItem, "menuItem");
        if (menuItem.isCheckable()) {
            String strApplyGroupItemStateChange$default = applyGroupItemStateChange$default(stackHeaderCoordinatorLayout, stackHeaderAppBarLayout.getToolbar(), id, null, 4, null);
            if (strApplyGroupItemStateChange$default != null) {
                stackHeaderCoordinatorLayout.emitGroupSelection(stackHeaderAppBarLayout.getToolbar(), strApplyGroupItemStateChange$default);
            }
        } else {
            StackHeaderDelegate stackHeaderDelegate = stackHeaderCoordinatorLayout.currentDelegate;
            if (stackHeaderDelegate != null) {
                stackHeaderDelegate.onMenuItemClicked(id);
            }
        }
        return Unit.INSTANCE;
    }

    static /* synthetic */ String applyGroupItemStateChange$default(StackHeaderCoordinatorLayout stackHeaderCoordinatorLayout, MaterialToolbar materialToolbar, String str, Boolean bool, int i, Object obj) {
        if ((i & 4) != 0) {
            bool = null;
        }
        return stackHeaderCoordinatorLayout.applyGroupItemStateChange(materialToolbar, str, bool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:20:0x006c  */
    public final String applyGroupItemStateChange(MaterialToolbar toolbar, String itemId, Boolean explicitCheckedValue) {
        Boolean bool;
        String str = this.toolbarMenuGroupMetadata.getItemGroupMap().get(itemId);
        if (str != null && (bool = this.toolbarMenuGroupMetadata.getGroupSingleSelection().get(str)) != null) {
            boolean zBooleanValue = bool.booleanValue();
            Integer num = this.toolbarMenuForwardIdMap.get(itemId);
            if (num != null) {
                MenuItem menuItemFindItem = toolbar.getMenu().findItem(num.intValue());
                if (menuItemFindItem == null) {
                    return null;
                }
                boolean zBooleanValue2 = false;
                if (zBooleanValue && Intrinsics.areEqual((Object) explicitCheckedValue, (Object) false)) {
                    Log.w(TAG, "[RNScreens] Cannot uncheck item '" + itemId + "' in single-selection group '" + str + "'. Check a different item instead.");
                    return null;
                }
                if (zBooleanValue) {
                    zBooleanValue2 = true;
                } else if (explicitCheckedValue != null) {
                    zBooleanValue2 = explicitCheckedValue.booleanValue();
                } else if (!menuItemFindItem.isChecked()) {
                    zBooleanValue2 = true;
                }
                if (menuItemFindItem.isChecked() == zBooleanValue2) {
                    return null;
                }
                menuItemFindItem.setChecked(zBooleanValue2);
                return str;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void emitGroupSelection(MaterialToolbar toolbar, String groupId) {
        StackHeaderDelegate stackHeaderDelegate = this.currentDelegate;
        if (stackHeaderDelegate != null) {
            stackHeaderDelegate.onGroupSelectionChanged(groupId, collectSelectedIds(toolbar, groupId));
        }
    }

    private final List<String> collectSelectedIds(MaterialToolbar toolbar, String groupId) {
        List<String> listEmptyList = this.toolbarMenuGroupMetadata.getGroupMemberItems().get(groupId);
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : listEmptyList) {
            Integer num = this.toolbarMenuForwardIdMap.get((String) obj);
            if (num != null) {
                MenuItem menuItemFindItem = toolbar.getMenu().findItem(num.intValue());
                if (menuItemFindItem != null && menuItemFindItem.isChecked()) {
                    arrayList.add(obj);
                }
            }
        }
        return arrayList;
    }

    private final void resetHeader() {
        StackHeaderAppBarLayout stackHeaderAppBarLayout = this.appBarLayout;
        if (stackHeaderAppBarLayout != null) {
            detachAppBarListeners(stackHeaderAppBarLayout);
            removeView(stackHeaderAppBarLayout);
        }
        this.appBarLayout = null;
        this.toolbarMenuForwardIdMap = MapsKt.emptyMap();
        this.toolbarMenuGroupMetadata = StackHeaderToolbarMenuGroupMetadata.INSTANCE.getEMPTY();
    }

    private final void removeHeader() {
        resetHeader();
        removeContentBehavior$react_native_screens_release();
        requestLayout();
    }

    public final void setContentBehavior$react_native_screens_release() {
        ViewGroup.LayoutParams layoutParams = this.stackScreenWrapper.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        CoordinatorLayout.LayoutParams layoutParams2 = (CoordinatorLayout.LayoutParams) layoutParams;
        if (layoutParams2.getBehavior() == null) {
            layoutParams2.setBehavior(new StackHeaderScrollingViewBehavior(new Function2() { // from class: com.swmansion.rnscreens.gamma.stack.header.StackHeaderCoordinatorLayout$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StackHeaderCoordinatorLayout.setContentBehavior$lambda$0(this.f$0, ((Integer) obj).intValue(), (View) obj2);
                }
            }));
            this.stackScreenWrapper.setLayoutParams(layoutParams2);
            this.stackScreenWrapper.requestLayout();
        }
    }

    static final Unit setContentBehavior$lambda$0(StackHeaderCoordinatorLayout stackHeaderCoordinatorLayout, int i, View view) {
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        stackHeaderCoordinatorLayout.stackScreen.onContentYOriginChanged$react_native_screens_release(i);
        return Unit.INSTANCE;
    }

    public final void removeContentBehavior$react_native_screens_release() {
        ViewGroup.LayoutParams layoutParams = this.stackScreenWrapper.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        CoordinatorLayout.LayoutParams layoutParams2 = (CoordinatorLayout.LayoutParams) layoutParams;
        if (layoutParams2.getBehavior() != null) {
            layoutParams2.setBehavior(null);
            this.stackScreenWrapper.setLayoutParams(layoutParams2);
            this.stackScreen.onContentYOriginChanged$react_native_screens_release(0);
            this.stackScreenWrapper.requestLayout();
        }
    }

    /* JADX INFO: renamed from: getStackScreenWrapper$react_native_screens_release, reason: from getter */
    public final FrameLayout getStackScreenWrapper() {
        return this.stackScreenWrapper;
    }

    public final void setStackScreenWrapper$react_native_screens_release(FrameLayout frameLayout) {
        Intrinsics.checkNotNullParameter(frameLayout, "<set-?>");
        this.stackScreenWrapper = frameLayout;
    }

    public final void tearDown$react_native_screens_release() {
        removeHeader();
        this.stackScreenWrapper.removeView(this.stackScreen);
        StackHeaderConfigurationProviding stackHeaderConfigurationProviding = this.currentProvider;
        if (stackHeaderConfigurationProviding != null) {
            stackHeaderConfigurationProviding.setConfigurationObserver(null);
        }
        this.currentProvider = null;
        this.currentDelegate = null;
        this.stackScreen.clearHeaderConfigAttachListener$react_native_screens_release();
    }
}
