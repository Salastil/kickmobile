package com.swmansion.rnscreens.gamma.stack.header;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.MenuItemCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.swmansion.rnscreens.ext.ViewExtKt;
import com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfigurationProviding;
import com.swmansion.rnscreens.gamma.stack.header.subview.StackHeaderSubview;
import com.swmansion.rnscreens.gamma.stack.header.subview.StackHeaderSubviewProviding;
import com.swmansion.rnscreens.gamma.stack.header.toolbar.StackHeaderToolbarFieldUpdate;
import com.swmansion.rnscreens.gamma.stack.header.toolbar.StackHeaderToolbarFieldUpdateKt;
import com.swmansion.rnscreens.gamma.stack.header.toolbar.StackHeaderToolbarMenuConfig;
import com.swmansion.rnscreens.gamma.stack.header.toolbar.StackHeaderToolbarMenuElementConfig;
import com.swmansion.rnscreens.gamma.stack.header.toolbar.StackHeaderToolbarMenuElementOptions;
import com.swmansion.rnscreens.gamma.stack.header.toolbar.StackHeaderToolbarMenuGroupConfig;
import com.swmansion.rnscreens.gamma.stack.header.toolbar.StackHeaderToolbarMenuGroupMetadata;
import com.swmansion.rnscreens.gamma.stack.header.toolbar.StackHeaderToolbarMenuItemConfig;
import com.swmansion.rnscreens.gamma.stack.header.toolbar.StackHeaderToolbarMenuItemShowAsAction;
import com.swmansion.rnscreens.gamma.stack.header.toolbar.StackHeaderToolbarMenuItemType;
import com.swmansion.rnscreens.utils.DrawableUtilsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: StackHeaderApplicator.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\b\u0000\u0018\u0000 \\2\u00020\u0001:\u0001\\B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0002J \u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0016\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bJ,\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u001bJ\u0016\u0010\u001c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bJ2\u0010\u001d\u001a&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020 0\u001f0\u001e2\u0006\u0010\"\u001a\u00020#J\u001a\u0010$\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001f2\u0006\u0010\"\u001a\u00020#J\u000e\u0010%\u001a\u00020&2\u0006\u0010\"\u001a\u00020#J\u000e\u0010'\u001a\u00020\r2\u0006\u0010\"\u001a\u00020#JL\u0010(\u001a\u00020\r2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0-2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020 0-2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020!0\u001bH\u0002J2\u00100\u001a\u00020\r2\u0006\u0010\"\u001a\u00020#2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0-2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020!0\u001bH\u0002JR\u00102\u001a\u00020\r2\u0006\u0010\n\u001a\u00020#2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 0-2\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00190-2\u0018\u00105\u001a\u0014\u0012\u0004\u0012\u00020 \u0012\n\u0012\b\u0012\u0004\u0012\u00020 060-H\u0002J\u0092\u0001\u00107\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020#2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001f2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020 0\u001f2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001f2\u0006\u00109\u001a\u00020\u001926\u0010:\u001a2\u0012\u0013\u0012\u00110 ¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(>\u0012\u0013\u0012\u00110?¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(@\u0012\u0004\u0012\u00020\r0;JH\u0010A\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00172\u0006\u0010B\u001a\u00020C2\u0006\u0010\"\u001a\u00020#2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001f2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001fH\u0002J2\u0010D\u001a\u00020\r2\u0006\u0010B\u001a\u00020C2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020F0*2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001fH\u0002J\u0018\u0010G\u001a\u00020\r2\u0006\u0010@\u001a\u00020?2\u0006\u0010H\u001a\u00020IH\u0002J2\u0010J\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00172\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001f2\u0006\u0010>\u001a\u00020 2\u0006\u0010K\u001a\u00020LJ \u0010M\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00172\u0006\u0010@\u001a\u00020?2\u0006\u0010K\u001a\u00020LH\u0002J\u0010\u0010N\u001a\u00020!2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010O\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\n\u0010P\u001a\u0004\u0018\u00010QH\u0002J \u0010R\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0007H\u0002J\u0010\u0010S\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\f\u0010T\u001a\u00020L*\u00020IH\u0002J\u0012\u0010U\u001a\u0004\u0018\u00010V2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u001a\u0010W\u001a\u0004\u0018\u00010V2\u0006\u0010@\u001a\u00020?2\u0006\u0010K\u001a\u00020LH\u0002J\u001b\u0010X\u001a\u0004\u0018\u00010!*\u00020V2\u0006\u0010Y\u001a\u00020ZH\u0002¢\u0006\u0002\u0010[R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006]"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/header/StackHeaderApplicator;", "", "wrappedContext", "Landroidx/appcompat/view/ContextThemeWrapper;", "<init>", "(Landroidx/appcompat/view/ContextThemeWrapper;)V", "rebuild", "Lcom/swmansion/rnscreens/gamma/stack/header/StackHeaderAppBarLayout;", "coordinatorLayout", "Lcom/swmansion/rnscreens/gamma/stack/header/StackHeaderCoordinatorLayout;", "config", "Lcom/swmansion/rnscreens/gamma/stack/header/config/StackHeaderConfigurationProviding;", "populateAppBar", "", "appBar", "populateTitleOrCenter", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "populateBackground", "createManagedTitleView", "Landroidx/appcompat/widget/AppCompatTextView;", "applyTitle", "applyBackButton", "Lcom/google/android/material/appbar/MaterialToolbar;", "canNavigateBack", "", "onNavigationIconClick", "Lkotlin/Function0;", "applyScrollFlags", "generateToolbarMenuItemMappings", "Lkotlin/Pair;", "", "", "", "menuConfig", "Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuConfig;", "generateToolbarMenuGroupMappings", "computeGroupMetadata", "Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuGroupMetadata;", "validateRadioInitialSelection", "assignElementIds", "elements", "", "Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuElementConfig;", "forwardIdMap", "", "reverseIdMap", "nextId", "assignGroupIds", "forwardMap", "collectGroupMetadata", "itemGroupMap", "groupSingleSelection", "groupMemberItems", "", "rebuildToolbarMenu", "forwardGroupIdMap", "groupDividerEnabled", "onItemClicked", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "id", "Landroid/view/MenuItem;", "menuItem", "addElements", "menu", "Landroid/view/Menu;", "configureGroupCheckability", "groups", "Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuGroupConfig;", "applyCheckability", "itemConfig", "Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuItemConfig;", "updateToolbarMenuElement", "options", "Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuElementOptions;", "applyMenuElementOptions", "computeScrollFlags", "warnInvalidScrollFlagCombinations", "resolveDefaultBackButtonIcon", "Landroid/graphics/drawable/Drawable;", "maybeApplyRTLCollapsingToolbarLayoutWorkaround", "moveDummyViewToFront", "toOptions", "resolveBackButtonTintList", "Landroid/content/res/ColorStateList;", "getResolvedIconTintList", "resolvedColorOrNull", "stateSet", "", "(Landroid/content/res/ColorStateList;[I)Ljava/lang/Integer;", "Companion", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class StackHeaderApplicator {
    private static final int SENTINEL_A = 1;
    private static final int SENTINEL_B = 2;
    private static final String TAG = "StackHeaderApplicator";
    private final ContextThemeWrapper wrappedContext;

    /* JADX INFO: compiled from: StackHeaderApplicator.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StackHeaderToolbarMenuItemType.values().length];
            try {
                iArr[StackHeaderToolbarMenuItemType.TOGGLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StackHeaderToolbarMenuItemType.AUTOMATIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[StackHeaderToolbarMenuItemType.ACTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public StackHeaderApplicator(ContextThemeWrapper wrappedContext) {
        Intrinsics.checkNotNullParameter(wrappedContext, "wrappedContext");
        this.wrappedContext = wrappedContext;
    }

    public final StackHeaderAppBarLayout rebuild(StackHeaderCoordinatorLayout coordinatorLayout, StackHeaderConfigurationProviding config) {
        Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(config, "config");
        StackHeaderAppBarLayout stackHeaderAppBarLayoutCreate = StackHeaderAppBarLayout.INSTANCE.create(this.wrappedContext, config.getType());
        if (config.getTransparent()) {
            coordinatorLayout.removeContentBehavior$react_native_screens_release();
            coordinatorLayout.addView(stackHeaderAppBarLayoutCreate);
        } else {
            coordinatorLayout.addView(stackHeaderAppBarLayoutCreate, 0);
            coordinatorLayout.setContentBehavior$react_native_screens_release();
        }
        stackHeaderAppBarLayoutCreate.requestApplyInsets();
        populateAppBar(stackHeaderAppBarLayoutCreate, config);
        maybeApplyRTLCollapsingToolbarLayoutWorkaround(coordinatorLayout, config, stackHeaderAppBarLayoutCreate);
        stackHeaderAppBarLayoutCreate.getToolbar().requestLayout();
        return stackHeaderAppBarLayoutCreate;
    }

    private final void populateAppBar(StackHeaderAppBarLayout appBar, StackHeaderConfigurationProviding config) {
        MaterialToolbar toolbar = appBar.getToolbar();
        StackHeaderSubviewProviding leadingSubview = config.getLeadingSubview();
        if (leadingSubview != null) {
            ViewExtKt.detachFromCurrentParent(leadingSubview.getView());
            toolbar.addView(leadingSubview.getView(), new Toolbar.LayoutParams(-2, -2, 8388611));
        }
        StackHeaderSubviewProviding trailingSubview = config.getTrailingSubview();
        if (trailingSubview != null) {
            ViewExtKt.detachFromCurrentParent(trailingSubview.getView());
            toolbar.addView(trailingSubview.getView(), new Toolbar.LayoutParams(-2, -2, GravityCompat.END));
        }
        populateTitleOrCenter(appBar, toolbar, config);
        populateBackground(appBar, config);
    }

    private final void populateTitleOrCenter(StackHeaderAppBarLayout appBar, Toolbar toolbar, StackHeaderConfigurationProviding config) {
        StackHeaderSubviewProviding centerSubview = config.getCenterSubview();
        if (centerSubview != null) {
            if (appBar instanceof StackHeaderAppBarLayout.Small) {
                ViewExtKt.detachFromCurrentParent(centerSubview.getView());
                toolbar.addView(centerSubview.getView(), new Toolbar.LayoutParams(-2, -2, 1));
                return;
            } else {
                Log.e(TAG, "[RNScreens] Center subview is supported only for small header type.");
                return;
            }
        }
        if (appBar instanceof StackHeaderAppBarLayout.Small) {
            AppCompatTextView appCompatTextViewCreateManagedTitleView = createManagedTitleView(toolbar);
            ((StackHeaderAppBarLayout.Small) appBar).setManagedTitleView$react_native_screens_release(appCompatTextViewCreateManagedTitleView);
            toolbar.addView(appCompatTextViewCreateManagedTitleView, config.isRTL() ? 0 : -1, new Toolbar.LayoutParams(-2, -2, 8388611));
        }
    }

    private final void populateBackground(StackHeaderAppBarLayout appBar, StackHeaderConfigurationProviding config) {
        StackHeaderSubviewProviding backgroundSubview = config.getBackgroundSubview();
        if (backgroundSubview == null) {
            return;
        }
        if (!(appBar instanceof StackHeaderAppBarLayout.Collapsing)) {
            Log.e(TAG, "[RNScreens] Background subview is supported only for collapsing header types (medium, large).");
            return;
        }
        ViewExtKt.detachFromCurrentParent(backgroundSubview.getView());
        StackHeaderAppBarLayout.Collapsing collapsing = (StackHeaderAppBarLayout.Collapsing) appBar;
        FrameLayout frameLayout = new FrameLayout(collapsing.getContext());
        frameLayout.setFitsSystemWindows(true);
        frameLayout.addView(backgroundSubview.getView(), new FrameLayout.LayoutParams(-1, -1));
        CollapsingToolbarLayout.LayoutParams layoutParams = new CollapsingToolbarLayout.LayoutParams(-1, -1);
        layoutParams.setCollapseMode(backgroundSubview.getCollapseMode().toNativeCollapseMode$react_native_screens_release());
        Unit unit = Unit.INSTANCE;
        collapsing.getCollapsingToolbarLayout().addView(frameLayout, 0, layoutParams);
    }

    private final AppCompatTextView createManagedTitleView(Toolbar toolbar) {
        AppCompatTextView appCompatTextView = new AppCompatTextView(toolbar.getContext());
        appCompatTextView.setSingleLine();
        appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
        TextViewCompat.setTextAppearance(appCompatTextView, R.style.TextAppearance_Material3_TitleLarge);
        Toolbar.LayoutParams layoutParams = new Toolbar.LayoutParams(-2, -2, 8388611);
        layoutParams.setMarginStart(toolbar.getTitleMarginStart() + toolbar.getContentInsetStart());
        layoutParams.setMarginEnd(toolbar.getTitleMarginEnd());
        layoutParams.topMargin = toolbar.getTitleMarginTop();
        layoutParams.bottomMargin = toolbar.getTitleMarginBottom();
        appCompatTextView.setLayoutParams(layoutParams);
        return appCompatTextView;
    }

    public final void applyTitle(StackHeaderAppBarLayout appBar, StackHeaderConfigurationProviding config) {
        Intrinsics.checkNotNullParameter(appBar, "appBar");
        Intrinsics.checkNotNullParameter(config, "config");
        if (appBar instanceof StackHeaderAppBarLayout.Small) {
            StackHeaderAppBarLayout.Small small = (StackHeaderAppBarLayout.Small) appBar;
            AppCompatTextView managedTitleView = small.getManagedTitleView();
            if (managedTitleView != null) {
                managedTitleView.setText(config.getTitle());
            }
            AppCompatTextView managedTitleView2 = small.getManagedTitleView();
            if (managedTitleView2 != null) {
                managedTitleView2.requestLayout();
                return;
            }
            return;
        }
        if (!(appBar instanceof StackHeaderAppBarLayout.Collapsing)) {
            throw new NoWhenBranchMatchedException();
        }
        ((StackHeaderAppBarLayout.Collapsing) appBar).getCollapsingToolbarLayout().setTitle(config.getTitle());
    }

    public final void applyBackButton(MaterialToolbar toolbar, StackHeaderConfigurationProviding config, boolean canNavigateBack, final Function0<Unit> onNavigationIconClick) {
        Drawable drawableResolveDefaultBackButtonIcon;
        Intrinsics.checkNotNullParameter(toolbar, "toolbar");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(onNavigationIconClick, "onNavigationIconClick");
        if (!canNavigateBack || config.getBackButtonHidden()) {
            toolbar.setNavigationIcon((Drawable) null);
            toolbar.setNavigationOnClickListener(null);
            return;
        }
        toolbar.clearNavigationIconTint();
        Drawable backButtonIcon = config.getBackButtonIcon();
        if (backButtonIcon == null || (drawableResolveDefaultBackButtonIcon = StackHeaderDrawableUtilsKt.getResizedDrawable(toolbar, backButtonIcon)) == null) {
            drawableResolveDefaultBackButtonIcon = resolveDefaultBackButtonIcon();
        }
        ColorStateList colorStateListResolveBackButtonTintList = resolveBackButtonTintList(config);
        if (colorStateListResolveBackButtonTintList != null && drawableResolveDefaultBackButtonIcon != null) {
            drawableResolveDefaultBackButtonIcon = DrawableCompat.wrap(drawableResolveDefaultBackButtonIcon.mutate());
            DrawableCompat.setTintList(drawableResolveDefaultBackButtonIcon, colorStateListResolveBackButtonTintList);
        }
        toolbar.setNavigationIcon(drawableResolveDefaultBackButtonIcon);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.swmansion.rnscreens.gamma.stack.header.StackHeaderApplicator$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onNavigationIconClick.invoke();
            }
        });
    }

    public final void applyScrollFlags(StackHeaderAppBarLayout appBar, StackHeaderConfigurationProviding config) {
        CollapsingToolbarLayout collapsingToolbarLayout;
        Intrinsics.checkNotNullParameter(appBar, "appBar");
        Intrinsics.checkNotNullParameter(config, "config");
        warnInvalidScrollFlagCombinations(config);
        int iComputeScrollFlags = computeScrollFlags(config);
        if (appBar instanceof StackHeaderAppBarLayout.Small) {
            collapsingToolbarLayout = ((StackHeaderAppBarLayout.Small) appBar).getToolbar();
        } else {
            if (!(appBar instanceof StackHeaderAppBarLayout.Collapsing)) {
                throw new NoWhenBranchMatchedException();
            }
            collapsingToolbarLayout = ((StackHeaderAppBarLayout.Collapsing) appBar).getCollapsingToolbarLayout();
        }
        ViewGroup.LayoutParams layoutParams = collapsingToolbarLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.google.android.material.appbar.AppBarLayout.LayoutParams");
        AppBarLayout.LayoutParams layoutParams2 = (AppBarLayout.LayoutParams) layoutParams;
        layoutParams2.setScrollFlags(iComputeScrollFlags);
        collapsingToolbarLayout.setLayoutParams(layoutParams2);
        appBar.setExpanded(true, false);
    }

    public final Pair<Map<String, Integer>, Map<Integer, String>> generateToolbarMenuItemMappings(StackHeaderToolbarMenuConfig menuConfig) {
        Intrinsics.checkNotNullParameter(menuConfig, "menuConfig");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 1;
        assignElementIds(menuConfig.getChildren(), linkedHashMap, linkedHashMap2, new Function0() { // from class: com.swmansion.rnscreens.gamma.stack.header.StackHeaderApplicator$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(StackHeaderApplicator.generateToolbarMenuItemMappings$lambda$0(intRef));
            }
        });
        return new Pair<>(MapsKt.toMap(linkedHashMap), MapsKt.toMap(linkedHashMap2));
    }

    static final int generateToolbarMenuItemMappings$lambda$0(Ref.IntRef intRef) {
        int i = intRef.element;
        intRef.element = i + 1;
        return i;
    }

    public final Map<String, Integer> generateToolbarMenuGroupMappings(StackHeaderToolbarMenuConfig menuConfig) {
        Intrinsics.checkNotNullParameter(menuConfig, "menuConfig");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 1;
        assignGroupIds(menuConfig, linkedHashMap, new Function0() { // from class: com.swmansion.rnscreens.gamma.stack.header.StackHeaderApplicator$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(StackHeaderApplicator.generateToolbarMenuGroupMappings$lambda$0(intRef));
            }
        });
        return MapsKt.toMap(linkedHashMap);
    }

    static final int generateToolbarMenuGroupMappings$lambda$0(Ref.IntRef intRef) {
        int i = intRef.element;
        intRef.element = i + 1;
        return i;
    }

    public final StackHeaderToolbarMenuGroupMetadata computeGroupMetadata(StackHeaderToolbarMenuConfig menuConfig) {
        Intrinsics.checkNotNullParameter(menuConfig, "menuConfig");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        collectGroupMetadata(menuConfig, linkedHashMap, linkedHashMap2, linkedHashMap3);
        LinkedHashMap linkedHashMap4 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap3.size()));
        Iterator<T> it = linkedHashMap3.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap4.put(entry.getKey(), CollectionsKt.toList((Iterable) entry.getValue()));
        }
        return new StackHeaderToolbarMenuGroupMetadata(linkedHashMap, linkedHashMap2, linkedHashMap4);
    }

    public final void validateRadioInitialSelection(StackHeaderToolbarMenuConfig menuConfig) {
        Intrinsics.checkNotNullParameter(menuConfig, "menuConfig");
        for (StackHeaderToolbarMenuGroupConfig stackHeaderToolbarMenuGroupConfig : menuConfig.getGroups()) {
            if (stackHeaderToolbarMenuGroupConfig.getSingleSelection()) {
                int i = 0;
                for (StackHeaderToolbarMenuElementConfig stackHeaderToolbarMenuElementConfig : menuConfig.getChildren()) {
                    if (Intrinsics.areEqual(stackHeaderToolbarMenuElementConfig.getItem().getGroupId(), stackHeaderToolbarMenuGroupConfig.getGroupId()) && stackHeaderToolbarMenuElementConfig.getItem().getInitialToggleState()) {
                        i++;
                    }
                }
                if (i > 1) {
                    throw new IllegalArgumentException(("[RNScreens] Radio group '" + stackHeaderToolbarMenuGroupConfig.getGroupId() + "' has " + i + " items with initialToggleState=true. At most 1 is allowed for single-selection groups.").toString());
                }
            }
        }
        for (StackHeaderToolbarMenuElementConfig stackHeaderToolbarMenuElementConfig2 : menuConfig.getChildren()) {
            if (stackHeaderToolbarMenuElementConfig2 instanceof StackHeaderToolbarMenuElementConfig.Submenu) {
                validateRadioInitialSelection(((StackHeaderToolbarMenuElementConfig.Submenu) stackHeaderToolbarMenuElementConfig2).getMenu());
            }
        }
    }

    private final void assignElementIds(List<? extends StackHeaderToolbarMenuElementConfig> elements, Map<String, Integer> forwardIdMap, Map<Integer, String> reverseIdMap, Function0<Integer> nextId) {
        for (StackHeaderToolbarMenuElementConfig stackHeaderToolbarMenuElementConfig : elements) {
            if (forwardIdMap.containsKey(stackHeaderToolbarMenuElementConfig.getItem().getId())) {
                throw new IllegalArgumentException(("[RNScreens] Duplicate toolbar menu item id: '" + stackHeaderToolbarMenuElementConfig.getItem().getId() + "'. Item IDs must be unique across the entire menu.").toString());
            }
            int iIntValue = nextId.invoke().intValue();
            forwardIdMap.put(stackHeaderToolbarMenuElementConfig.getItem().getId(), Integer.valueOf(iIntValue));
            reverseIdMap.put(Integer.valueOf(iIntValue), stackHeaderToolbarMenuElementConfig.getItem().getId());
            if (stackHeaderToolbarMenuElementConfig instanceof StackHeaderToolbarMenuElementConfig.Submenu) {
                assignElementIds(((StackHeaderToolbarMenuElementConfig.Submenu) stackHeaderToolbarMenuElementConfig).getMenu().getChildren(), forwardIdMap, reverseIdMap, nextId);
            }
        }
    }

    private final void assignGroupIds(StackHeaderToolbarMenuConfig menuConfig, Map<String, Integer> forwardMap, Function0<Integer> nextId) {
        for (StackHeaderToolbarMenuGroupConfig stackHeaderToolbarMenuGroupConfig : menuConfig.getGroups()) {
            if (forwardMap.containsKey(stackHeaderToolbarMenuGroupConfig.getGroupId())) {
                throw new IllegalArgumentException(("[RNScreens] Duplicate toolbar menu group id: '" + stackHeaderToolbarMenuGroupConfig.getGroupId() + "'. Group IDs must be unique across the entire menu.").toString());
            }
            forwardMap.put(stackHeaderToolbarMenuGroupConfig.getGroupId(), nextId.invoke());
        }
        for (StackHeaderToolbarMenuElementConfig stackHeaderToolbarMenuElementConfig : menuConfig.getChildren()) {
            if (stackHeaderToolbarMenuElementConfig instanceof StackHeaderToolbarMenuElementConfig.Submenu) {
                assignGroupIds(((StackHeaderToolbarMenuElementConfig.Submenu) stackHeaderToolbarMenuElementConfig).getMenu(), forwardMap, nextId);
            }
        }
    }

    private final void collectGroupMetadata(StackHeaderToolbarMenuConfig config, Map<String, String> itemGroupMap, Map<String, Boolean> groupSingleSelection, Map<String, List<String>> groupMemberItems) {
        List<StackHeaderToolbarMenuGroupConfig> groups = config.getGroups();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(groups, 10));
        Iterator<T> it = groups.iterator();
        while (it.hasNext()) {
            arrayList.add(((StackHeaderToolbarMenuGroupConfig) it.next()).getGroupId());
        }
        Set set = CollectionsKt.toSet(arrayList);
        for (StackHeaderToolbarMenuGroupConfig stackHeaderToolbarMenuGroupConfig : config.getGroups()) {
            groupSingleSelection.put(stackHeaderToolbarMenuGroupConfig.getGroupId(), Boolean.valueOf(stackHeaderToolbarMenuGroupConfig.getSingleSelection()));
            String groupId = stackHeaderToolbarMenuGroupConfig.getGroupId();
            if (groupMemberItems.get(groupId) == null) {
                groupMemberItems.put(groupId, new ArrayList());
            }
        }
        for (StackHeaderToolbarMenuElementConfig stackHeaderToolbarMenuElementConfig : config.getChildren()) {
            String groupId2 = stackHeaderToolbarMenuElementConfig.getItem().getGroupId();
            if (groupId2 != null) {
                if (!set.contains(groupId2)) {
                    throw new IllegalArgumentException(("[RNScreens] Menu item '" + stackHeaderToolbarMenuElementConfig.getItem().getId() + "' references group '" + groupId2 + "' which is not defined at the same menu level. Groups cannot span submenus.").toString());
                }
                itemGroupMap.put(stackHeaderToolbarMenuElementConfig.getItem().getId(), groupId2);
                List<String> list = groupMemberItems.get(groupId2);
                Intrinsics.checkNotNull(list);
                list.add(stackHeaderToolbarMenuElementConfig.getItem().getId());
            }
            if (stackHeaderToolbarMenuElementConfig instanceof StackHeaderToolbarMenuElementConfig.Submenu) {
                collectGroupMetadata(((StackHeaderToolbarMenuElementConfig.Submenu) stackHeaderToolbarMenuElementConfig).getMenu(), itemGroupMap, groupSingleSelection, groupMemberItems);
            }
        }
    }

    public final void rebuildToolbarMenu(MaterialToolbar toolbar, StackHeaderToolbarMenuConfig menuConfig, Map<String, Integer> forwardIdMap, final Map<Integer, String> reverseIdMap, Map<String, Integer> forwardGroupIdMap, boolean groupDividerEnabled, final Function2<? super String, ? super MenuItem, Unit> onItemClicked) {
        Intrinsics.checkNotNullParameter(toolbar, "toolbar");
        Intrinsics.checkNotNullParameter(menuConfig, "menuConfig");
        Intrinsics.checkNotNullParameter(forwardIdMap, "forwardIdMap");
        Intrinsics.checkNotNullParameter(reverseIdMap, "reverseIdMap");
        Intrinsics.checkNotNullParameter(forwardGroupIdMap, "forwardGroupIdMap");
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        toolbar.getMenu().clear();
        Menu menu = toolbar.getMenu();
        Intrinsics.checkNotNullExpressionValue(menu, "getMenu(...)");
        addElements(toolbar, menu, menuConfig, forwardIdMap, forwardGroupIdMap);
        if (Build.VERSION.SDK_INT >= 28) {
            toolbar.getMenu().setGroupDividerEnabled(groupDividerEnabled);
        }
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() { // from class: com.swmansion.rnscreens.gamma.stack.header.StackHeaderApplicator$$ExternalSyntheticLambda3
            @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return StackHeaderApplicator.rebuildToolbarMenu$lambda$0(reverseIdMap, onItemClicked, menuItem);
            }
        });
    }

    static final boolean rebuildToolbarMenu$lambda$0(Map map, Function2 function2, MenuItem menuItem) {
        String str = (String) map.get(Integer.valueOf(menuItem.getItemId()));
        if (str == null) {
            return true;
        }
        Intrinsics.checkNotNull(menuItem);
        function2.invoke(str, menuItem);
        return true;
    }

    private final void addElements(MaterialToolbar toolbar, Menu menu, StackHeaderToolbarMenuConfig menuConfig, Map<String, Integer> forwardIdMap, Map<String, Integer> forwardGroupIdMap) {
        Integer num;
        int i = 0;
        for (Object obj : menuConfig.getChildren()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            StackHeaderToolbarMenuElementConfig stackHeaderToolbarMenuElementConfig = (StackHeaderToolbarMenuElementConfig) obj;
            Integer num2 = forwardIdMap.get(stackHeaderToolbarMenuElementConfig.getItem().getId());
            if (num2 == null) {
                throw new IllegalArgumentException(("[RNScreens] Invalid forwardIdMap received. Missing item: " + stackHeaderToolbarMenuElementConfig.getItem() + ".").toString());
            }
            int iIntValue = num2.intValue();
            String groupId = stackHeaderToolbarMenuElementConfig.getItem().getGroupId();
            int iIntValue2 = (groupId == null || (num = forwardGroupIdMap.get(groupId)) == null) ? 0 : num.intValue();
            if (stackHeaderToolbarMenuElementConfig instanceof StackHeaderToolbarMenuElementConfig.MenuItem) {
                MenuItem menuItemAdd = menu.add(iIntValue2, iIntValue, i, (CharSequence) null);
                Intrinsics.checkNotNull(menuItemAdd);
                StackHeaderToolbarMenuElementConfig.MenuItem menuItem = (StackHeaderToolbarMenuElementConfig.MenuItem) stackHeaderToolbarMenuElementConfig;
                applyMenuElementOptions(toolbar, menuItemAdd, toOptions(menuItem.getItem()));
                applyCheckability(menuItemAdd, menuItem.getItem());
            } else {
                if (!(stackHeaderToolbarMenuElementConfig instanceof StackHeaderToolbarMenuElementConfig.Submenu)) {
                    throw new NoWhenBranchMatchedException();
                }
                SubMenu subMenuAddSubMenu = menu.addSubMenu(iIntValue2, iIntValue, i, (CharSequence) null);
                MenuItem item = subMenuAddSubMenu.getItem();
                Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
                StackHeaderToolbarMenuElementConfig.Submenu submenu = (StackHeaderToolbarMenuElementConfig.Submenu) stackHeaderToolbarMenuElementConfig;
                applyMenuElementOptions(toolbar, item, toOptions(submenu.getItem()));
                String menuTitle = submenu.getMenuTitle();
                if (menuTitle != null) {
                    subMenuAddSubMenu.setHeaderTitle(menuTitle);
                }
                Intrinsics.checkNotNull(subMenuAddSubMenu);
                addElements(toolbar, subMenuAddSubMenu, submenu.getMenu(), forwardIdMap, forwardGroupIdMap);
            }
            i = i2;
        }
        configureGroupCheckability(menu, menuConfig.getGroups(), forwardGroupIdMap);
    }

    private final void configureGroupCheckability(Menu menu, List<StackHeaderToolbarMenuGroupConfig> groups, Map<String, Integer> forwardGroupIdMap) {
        for (StackHeaderToolbarMenuGroupConfig stackHeaderToolbarMenuGroupConfig : groups) {
            Integer num = forwardGroupIdMap.get(stackHeaderToolbarMenuGroupConfig.getGroupId());
            if (num != null) {
                menu.setGroupCheckable(num.intValue(), true, stackHeaderToolbarMenuGroupConfig.getSingleSelection());
            }
        }
    }

    private final void applyCheckability(MenuItem menuItem, StackHeaderToolbarMenuItemConfig itemConfig) {
        int i = WhenMappings.$EnumSwitchMapping$0[itemConfig.getItemType().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                if (itemConfig.getGroupId() == null) {
                    return;
                }
                throw new IllegalArgumentException(("[RNScreens] Menu item '" + itemConfig.getId() + "' has itemType=ACTION and belongs to a group. Action items cannot belong to groups.").toString());
            }
            if (itemConfig.getGroupId() == null) {
                return;
            }
        } else if (itemConfig.getGroupId() == null) {
            throw new IllegalArgumentException(("[RNScreens] Menu item '" + itemConfig.getId() + "' has itemType=TOGGLE but no groupId. Toggle items must belong to a group.").toString());
        }
        menuItem.setCheckable(true);
        menuItem.setChecked(itemConfig.getInitialToggleState());
    }

    public final void updateToolbarMenuElement(MaterialToolbar toolbar, Map<String, Integer> forwardIdMap, String id, StackHeaderToolbarMenuElementOptions options) {
        Intrinsics.checkNotNullParameter(toolbar, "toolbar");
        Intrinsics.checkNotNullParameter(forwardIdMap, "forwardIdMap");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(options, "options");
        Integer num = forwardIdMap.get(id);
        if (num != null) {
            MenuItem menuItemFindItem = toolbar.getMenu().findItem(num.intValue());
            if (menuItemFindItem != null) {
                applyMenuElementOptions(toolbar, menuItemFindItem, options);
                return;
            }
        }
        Log.e(TAG, "[RNScreens] Unable to find menu element.");
    }

    private final void applyMenuElementOptions(MaterialToolbar toolbar, MenuItem menuItem, StackHeaderToolbarMenuElementOptions options) {
        StackHeaderToolbarFieldUpdate<String> title = options.getTitle();
        if (title != null) {
            menuItem.setTitle((CharSequence) StackHeaderToolbarFieldUpdateKt.valueOrNull(title));
        }
        StackHeaderToolbarFieldUpdate<String> titleCondensed = options.getTitleCondensed();
        if (titleCondensed != null) {
            menuItem.setTitleCondensed((CharSequence) StackHeaderToolbarFieldUpdateKt.valueOrNull(titleCondensed));
        }
        StackHeaderToolbarFieldUpdate<String> tooltipText = options.getTooltipText();
        if (tooltipText != null) {
            MenuItemCompat.setTooltipText(menuItem, (CharSequence) StackHeaderToolbarFieldUpdateKt.valueOrNull(tooltipText));
        }
        StackHeaderToolbarFieldUpdate<String> accessibilityLabel = options.getAccessibilityLabel();
        if (accessibilityLabel != null) {
            MenuItemCompat.setContentDescription(menuItem, (CharSequence) StackHeaderToolbarFieldUpdateKt.valueOrNull(accessibilityLabel));
        }
        Boolean hidden = options.getHidden();
        if (hidden != null) {
            menuItem.setVisible(!hidden.booleanValue());
        }
        Boolean disabled = options.getDisabled();
        if (disabled != null) {
            menuItem.setEnabled(!disabled.booleanValue());
        }
        StackHeaderToolbarMenuItemShowAsAction showAsAction = options.getShowAsAction();
        if (showAsAction != null) {
            menuItem.setShowAsAction(showAsAction.toNativeShowAsAction$react_native_screens_release());
        }
        StackHeaderToolbarFieldUpdate<Drawable> icon = options.getIcon();
        if (icon != null) {
            if (Intrinsics.areEqual(icon, StackHeaderToolbarFieldUpdate.Reset.INSTANCE)) {
                menuItem.setIcon((Drawable) null);
            } else {
                if (!(icon instanceof StackHeaderToolbarFieldUpdate.Set)) {
                    throw new NoWhenBranchMatchedException();
                }
                menuItem.setIcon(StackHeaderDrawableUtilsKt.getResizedDrawable(toolbar, (Drawable) ((StackHeaderToolbarFieldUpdate.Set) icon).getValue()));
            }
        }
        if (options.getRequiresIconTintColorUpdate() || options.getIcon() != null) {
            MenuItemCompat.setIconTintList(menuItem, getResolvedIconTintList(menuItem, options));
        }
        StackHeaderToolbarFieldUpdate<String> menuTitle = options.getMenuTitle();
        if (menuTitle != null) {
            SubMenu subMenu = menuItem.getSubMenu();
            if (subMenu != null) {
                subMenu.clearHeader();
                String str = (String) StackHeaderToolbarFieldUpdateKt.valueOrNull(menuTitle);
                subMenu.setHeaderTitle(str != null ? str : menuItem.getTitle());
                return;
            }
            Log.w(TAG, "[RNScreens] menuTitle ignored: target is not a submenu.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    private final int computeScrollFlags(StackHeaderConfigurationProviding config) {
        boolean scrollFlagScroll = config.getScrollFlagScroll();
        ?? r1 = scrollFlagScroll;
        if (config.getScrollFlagEnterAlways()) {
            r1 = (scrollFlagScroll ? 1 : 0) | 4;
        }
        ?? r2 = r1;
        if (config.getScrollFlagEnterAlwaysCollapsed()) {
            r2 = (r1 == true ? 1 : 0) | 8;
        }
        ?? r3 = r2;
        if (config.getScrollFlagExitUntilCollapsed()) {
            r3 = (r2 == true ? 1 : 0) | 2;
        }
        return config.getScrollFlagSnap() ? r3 | 16 : r3;
    }

    private final void warnInvalidScrollFlagCombinations(StackHeaderConfigurationProviding config) {
        if ((config.getScrollFlagEnterAlways() || config.getScrollFlagEnterAlwaysCollapsed() || config.getScrollFlagExitUntilCollapsed() || config.getScrollFlagSnap()) && !config.getScrollFlagScroll()) {
            Log.e(TAG, "[RNScreens] scrollFlag* requires scrollFlagScroll to take effect.");
        }
        if (!config.getScrollFlagEnterAlwaysCollapsed() || config.getScrollFlagEnterAlways()) {
            return;
        }
        Log.e(TAG, "[RNScreens] scrollFlagEnterAlwaysCollapsed requires scrollFlagEnterAlways to take effect.");
    }

    private final Drawable resolveDefaultBackButtonIcon() {
        return DrawableUtilsKt.resolveDrawableAttr(this.wrappedContext, androidx.appcompat.R.attr.homeAsUpIndicator);
    }

    private final void maybeApplyRTLCollapsingToolbarLayoutWorkaround(StackHeaderCoordinatorLayout coordinatorLayout, StackHeaderConfigurationProviding config, StackHeaderAppBarLayout appBar) {
        if ((appBar instanceof StackHeaderAppBarLayout.Collapsing) && config.isRTL()) {
            appBar.measure(View.MeasureSpec.makeMeasureSpec(coordinatorLayout.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
            moveDummyViewToFront(((StackHeaderAppBarLayout.Collapsing) appBar).getToolbar());
        }
    }

    private final void moveDummyViewToFront(Toolbar toolbar) {
        int childCount = toolbar.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = toolbar.getChildAt(i);
            if (!(childAt instanceof StackHeaderSubview)) {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                toolbar.removeViewAt(i);
                toolbar.addView(childAt, 0, layoutParams);
                return;
            }
        }
    }

    private final StackHeaderToolbarMenuElementOptions toOptions(StackHeaderToolbarMenuItemConfig stackHeaderToolbarMenuItemConfig) {
        return new StackHeaderToolbarMenuElementOptions(StackHeaderToolbarFieldUpdate.INSTANCE.from(stackHeaderToolbarMenuItemConfig.getTitle()), StackHeaderToolbarFieldUpdate.INSTANCE.from(stackHeaderToolbarMenuItemConfig.getTitleCondensed()), StackHeaderToolbarFieldUpdate.INSTANCE.from(stackHeaderToolbarMenuItemConfig.getTooltipText()), StackHeaderToolbarFieldUpdate.INSTANCE.from(stackHeaderToolbarMenuItemConfig.getAccessibilityLabel()), Boolean.valueOf(stackHeaderToolbarMenuItemConfig.getHidden()), Boolean.valueOf(stackHeaderToolbarMenuItemConfig.getDisabled()), stackHeaderToolbarMenuItemConfig.getShowAsAction(), StackHeaderToolbarFieldUpdate.INSTANCE.from(stackHeaderToolbarMenuItemConfig.getIcon()), StackHeaderToolbarFieldUpdate.INSTANCE.from(stackHeaderToolbarMenuItemConfig.getIconTintColorNormal()), StackHeaderToolbarFieldUpdate.INSTANCE.from(stackHeaderToolbarMenuItemConfig.getIconTintColorPressed()), StackHeaderToolbarFieldUpdate.INSTANCE.from(stackHeaderToolbarMenuItemConfig.getIconTintColorFocused()), StackHeaderToolbarFieldUpdate.INSTANCE.from(stackHeaderToolbarMenuItemConfig.getIconTintColorDisabled()), null, null, 12288, null);
    }

    private final ColorStateList resolveBackButtonTintList(StackHeaderConfigurationProviding config) {
        Integer backButtonTintColorNormal = config.getBackButtonTintColorNormal();
        Integer backButtonTintColorPressed = config.getBackButtonTintColorPressed();
        Integer backButtonTintColorFocused = config.getBackButtonTintColorFocused();
        if (backButtonTintColorNormal == null && backButtonTintColorPressed == null && backButtonTintColorFocused == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (backButtonTintColorPressed != null) {
            int iIntValue = backButtonTintColorPressed.intValue();
            arrayList.add(new int[]{android.R.attr.state_pressed});
            arrayList2.add(Integer.valueOf(iIntValue));
        }
        if (backButtonTintColorFocused != null) {
            int iIntValue2 = backButtonTintColorFocused.intValue();
            arrayList.add(new int[]{android.R.attr.state_focused});
            arrayList2.add(Integer.valueOf(iIntValue2));
        }
        if (backButtonTintColorNormal != null) {
            int iIntValue3 = backButtonTintColorNormal.intValue();
            arrayList.add(new int[0]);
            arrayList2.add(Integer.valueOf(iIntValue3));
        }
        return new ColorStateList((int[][]) arrayList.toArray(new int[0][]), CollectionsKt.toIntArray(arrayList2));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0041  */
    /* JADX WARN: Code duplicated, block: B:31:0x007d  */
    /* JADX WARN: Code duplicated, block: B:46:0x00b9  */
    private final ColorStateList getResolvedIconTintList(MenuItem menuItem, StackHeaderToolbarMenuElementOptions options) {
        Integer num;
        Integer numResolvedColorOrNull;
        Integer numResolvedColorOrNull2;
        Integer numResolvedColorOrNull3;
        ColorStateList iconTintList = MenuItemCompat.getIconTintList(menuItem);
        Integer numResolvedColorOrNull4 = iconTintList != null ? resolvedColorOrNull(iconTintList, new int[]{android.R.attr.state_enabled}) : null;
        StackHeaderToolbarFieldUpdate<Integer> iconTintColorNormal = options.getIconTintColorNormal();
        if (Intrinsics.areEqual(iconTintColorNormal, StackHeaderToolbarFieldUpdate.Reset.INSTANCE)) {
            num = null;
        } else if (iconTintColorNormal instanceof StackHeaderToolbarFieldUpdate.Set) {
            num = (Integer) ((StackHeaderToolbarFieldUpdate.Set) iconTintColorNormal).getValue();
        } else {
            if (iconTintColorNormal != null) {
                throw new NoWhenBranchMatchedException();
            }
            num = numResolvedColorOrNull4;
        }
        StackHeaderToolbarFieldUpdate<Integer> iconTintColorDisabled = options.getIconTintColorDisabled();
        if (Intrinsics.areEqual(iconTintColorDisabled, StackHeaderToolbarFieldUpdate.Reset.INSTANCE)) {
            numResolvedColorOrNull = null;
        } else if (iconTintColorDisabled instanceof StackHeaderToolbarFieldUpdate.Set) {
            numResolvedColorOrNull = (Integer) ((StackHeaderToolbarFieldUpdate.Set) iconTintColorDisabled).getValue();
        } else {
            if (iconTintColorDisabled != null) {
                throw new NoWhenBranchMatchedException();
            }
            if (iconTintList == null || (numResolvedColorOrNull = resolvedColorOrNull(iconTintList, new int[]{-16842910})) == null) {
                numResolvedColorOrNull = null;
            } else {
                int iIntValue = numResolvedColorOrNull.intValue();
                if (numResolvedColorOrNull4 != null && iIntValue == numResolvedColorOrNull4.intValue()) {
                    numResolvedColorOrNull = null;
                }
            }
        }
        StackHeaderToolbarFieldUpdate<Integer> iconTintColorPressed = options.getIconTintColorPressed();
        if (Intrinsics.areEqual(iconTintColorPressed, StackHeaderToolbarFieldUpdate.Reset.INSTANCE)) {
            numResolvedColorOrNull2 = null;
        } else if (iconTintColorPressed instanceof StackHeaderToolbarFieldUpdate.Set) {
            numResolvedColorOrNull2 = (Integer) ((StackHeaderToolbarFieldUpdate.Set) iconTintColorPressed).getValue();
        } else {
            if (iconTintColorPressed != null) {
                throw new NoWhenBranchMatchedException();
            }
            if (iconTintList == null || (numResolvedColorOrNull2 = resolvedColorOrNull(iconTintList, new int[]{android.R.attr.state_enabled, android.R.attr.state_pressed})) == null) {
                numResolvedColorOrNull2 = null;
            } else {
                int iIntValue2 = numResolvedColorOrNull2.intValue();
                if (numResolvedColorOrNull4 != null && iIntValue2 == numResolvedColorOrNull4.intValue()) {
                    numResolvedColorOrNull2 = null;
                }
            }
        }
        StackHeaderToolbarFieldUpdate<Integer> iconTintColorFocused = options.getIconTintColorFocused();
        if (Intrinsics.areEqual(iconTintColorFocused, StackHeaderToolbarFieldUpdate.Reset.INSTANCE)) {
            numResolvedColorOrNull3 = null;
        } else if (iconTintColorFocused instanceof StackHeaderToolbarFieldUpdate.Set) {
            numResolvedColorOrNull3 = (Integer) ((StackHeaderToolbarFieldUpdate.Set) iconTintColorFocused).getValue();
        } else {
            if (iconTintColorFocused != null) {
                throw new NoWhenBranchMatchedException();
            }
            if (iconTintList == null || (numResolvedColorOrNull3 = resolvedColorOrNull(iconTintList, new int[]{android.R.attr.state_enabled, android.R.attr.state_focused})) == null) {
                numResolvedColorOrNull3 = null;
            } else {
                int iIntValue3 = numResolvedColorOrNull3.intValue();
                if (numResolvedColorOrNull4 != null && iIntValue3 == numResolvedColorOrNull4.intValue()) {
                    numResolvedColorOrNull3 = null;
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (numResolvedColorOrNull != null) {
            int iIntValue4 = numResolvedColorOrNull.intValue();
            arrayList.add(new int[]{-16842910});
            arrayList2.add(Integer.valueOf(iIntValue4));
        }
        if (numResolvedColorOrNull2 != null) {
            int iIntValue5 = numResolvedColorOrNull2.intValue();
            arrayList.add(new int[]{android.R.attr.state_pressed});
            arrayList2.add(Integer.valueOf(iIntValue5));
        }
        if (numResolvedColorOrNull3 != null) {
            int iIntValue6 = numResolvedColorOrNull3.intValue();
            arrayList.add(new int[]{android.R.attr.state_focused});
            arrayList2.add(Integer.valueOf(iIntValue6));
        }
        if (num != null) {
            int iIntValue7 = num.intValue();
            arrayList.add(new int[0]);
            arrayList2.add(Integer.valueOf(iIntValue7));
        }
        ArrayList arrayList3 = arrayList;
        if (arrayList3.isEmpty()) {
            return null;
        }
        return new ColorStateList((int[][]) arrayList3.toArray(new int[0][]), CollectionsKt.toIntArray(arrayList2));
    }

    private final Integer resolvedColorOrNull(ColorStateList colorStateList, int[] iArr) {
        int colorForState = colorStateList.getColorForState(iArr, 1);
        if (colorForState == colorStateList.getColorForState(iArr, 2)) {
            return Integer.valueOf(colorForState);
        }
        return null;
    }
}
