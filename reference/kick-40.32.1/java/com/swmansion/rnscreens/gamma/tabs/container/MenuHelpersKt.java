package com.swmansion.rnscreens.gamma.tabs.container;

import android.view.Menu;
import android.view.MenuItem;
import com.swmansion.rnscreens.gamma.tabs.screen.TabsScreenFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MenuHelpers.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"getOrCreateMenuItemForFragment", "Landroid/view/MenuItem;", "Landroid/view/Menu;", "fragment", "Lcom/swmansion/rnscreens/gamma/tabs/screen/TabsScreenFragment;", "react-native-screens_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class MenuHelpersKt {
    public static final MenuItem getOrCreateMenuItemForFragment(Menu menu, TabsScreenFragment fragment) {
        Intrinsics.checkNotNullParameter(menu, "<this>");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        MenuItem menuItemFindItem = menu.findItem(fragment.getMenuItemId());
        if (menuItemFindItem != null) {
            return menuItemFindItem;
        }
        MenuItem menuItemAdd = menu.add(0, fragment.getMenuItemId(), 0, fragment.getTabsScreen().getTabTitle());
        Intrinsics.checkNotNullExpressionValue(menuItemAdd, "add(...)");
        return menuItemAdd;
    }
}
