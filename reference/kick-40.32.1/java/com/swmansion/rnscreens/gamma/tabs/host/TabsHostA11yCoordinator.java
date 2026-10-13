package com.swmansion.rnscreens.gamma.tabs.host;

import android.os.Build;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupKt;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.swmansion.rnscreens.gamma.tabs.screen.TabsScreen;
import com.swmansion.rnscreens.gamma.tabs.screen.TabsScreenFragment;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TabsHostA11yCoordinator.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0006\u0010\u0013\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/swmansion/rnscreens/gamma/tabs/host/TabsHostA11yCoordinator;", "", "bottomNavigationView", "Lcom/google/android/material/bottomnavigation/BottomNavigationView;", "tabsScreenFragments", "", "Lcom/swmansion/rnscreens/gamma/tabs/screen/TabsScreenFragment;", "<init>", "(Lcom/google/android/material/bottomnavigation/BottomNavigationView;Ljava/util/List;)V", "setA11yPropertiesToTabItem", "", "menuItem", "Landroid/view/MenuItem;", "tabsScreen", "Lcom/swmansion/rnscreens/gamma/tabs/screen/TabsScreen;", "findTabItemView", "Landroid/view/View;", "menuItemId", "", "setA11yPropertiesToAllTabItems", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class TabsHostA11yCoordinator {
    private final BottomNavigationView bottomNavigationView;
    private final List<TabsScreenFragment> tabsScreenFragments;

    public TabsHostA11yCoordinator(BottomNavigationView bottomNavigationView, List<TabsScreenFragment> tabsScreenFragments) {
        Intrinsics.checkNotNullParameter(bottomNavigationView, "bottomNavigationView");
        Intrinsics.checkNotNullParameter(tabsScreenFragments, "tabsScreenFragments");
        this.bottomNavigationView = bottomNavigationView;
        this.tabsScreenFragments = tabsScreenFragments;
    }

    public final void setA11yPropertiesToTabItem(MenuItem menuItem, final TabsScreen tabsScreen) {
        Intrinsics.checkNotNullParameter(menuItem, "menuItem");
        Intrinsics.checkNotNullParameter(tabsScreen, "tabsScreen");
        if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setContentDescription(tabsScreen.getTabBarItemAccessibilityLabel());
        }
        View viewFindTabItemView = findTabItemView(menuItem.getItemId());
        if (viewFindTabItemView != null) {
            viewFindTabItemView.setTag(tabsScreen.getTabBarItemTestID());
            ViewCompat.setAccessibilityDelegate(viewFindTabItemView, new AccessibilityDelegateCompat() { // from class: com.swmansion.rnscreens.gamma.tabs.host.TabsHostA11yCoordinator$setA11yPropertiesToTabItem$1$1
                @Override // androidx.core.view.AccessibilityDelegateCompat
                public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
                    Intrinsics.checkNotNullParameter(host, "host");
                    Intrinsics.checkNotNullParameter(info, "info");
                    super.onInitializeAccessibilityNodeInfo(host, info);
                    info.setViewIdResourceName(tabsScreen.getTabBarItemTestID());
                }
            });
        }
    }

    private final View findTabItemView(int menuItemId) {
        View next;
        ViewGroup menuViewGroup = this.bottomNavigationView.getMenuViewGroup();
        Intrinsics.checkNotNullExpressionValue(menuViewGroup, "getMenuViewGroup(...)");
        Iterator<View> it = ViewGroupKt.getChildren(menuViewGroup).iterator();
        while (it.hasNext()) {
            next = it.next();
            if (next.getId() == menuItemId) {
                return next;
            }
        }
        next = null;
        return next;
    }

    public final void setA11yPropertiesToAllTabItems() {
        int i = 0;
        for (Object obj : this.tabsScreenFragments) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Menu menu = this.bottomNavigationView.getMenu();
            Intrinsics.checkNotNullExpressionValue(menu, "getMenu(...)");
            setA11yPropertiesToTabItem(menu.getItem(i), ((TabsScreenFragment) obj).getTabsScreen());
            i = i2;
        }
    }
}
