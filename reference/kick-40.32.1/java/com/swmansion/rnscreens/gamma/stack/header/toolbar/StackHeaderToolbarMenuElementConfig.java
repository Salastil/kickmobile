package com.swmansion.rnscreens.gamma.stack.header.toolbar;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StackHeaderToolbarMenuElementConfig.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0006\u0007R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0001\u0002\b\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuElementConfig;", "", "item", "Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuItemConfig;", "getItem", "()Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuItemConfig;", "MenuItem", "Submenu", "Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuElementConfig$MenuItem;", "Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuElementConfig$Submenu;", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface StackHeaderToolbarMenuElementConfig {
    StackHeaderToolbarMenuItemConfig getItem();

    /* JADX INFO: compiled from: StackHeaderToolbarMenuElementConfig.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuElementConfig$MenuItem;", "Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuElementConfig;", "item", "Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuItemConfig;", "<init>", "(Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuItemConfig;)V", "getItem", "()Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuItemConfig;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class MenuItem implements StackHeaderToolbarMenuElementConfig {
        private final StackHeaderToolbarMenuItemConfig item;

        public static /* synthetic */ MenuItem copy$default(MenuItem menuItem, StackHeaderToolbarMenuItemConfig stackHeaderToolbarMenuItemConfig, int i, Object obj) {
            if ((i & 1) != 0) {
                stackHeaderToolbarMenuItemConfig = menuItem.item;
            }
            return menuItem.copy(stackHeaderToolbarMenuItemConfig);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final StackHeaderToolbarMenuItemConfig getItem() {
            return this.item;
        }

        public final MenuItem copy(StackHeaderToolbarMenuItemConfig item) {
            Intrinsics.checkNotNullParameter(item, "item");
            return new MenuItem(item);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof MenuItem) && Intrinsics.areEqual(this.item, ((MenuItem) other).item);
        }

        public int hashCode() {
            return this.item.hashCode();
        }

        public String toString() {
            return "MenuItem(item=" + this.item + ")";
        }

        public MenuItem(StackHeaderToolbarMenuItemConfig item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.item = item;
        }

        @Override // com.swmansion.rnscreens.gamma.stack.header.toolbar.StackHeaderToolbarMenuElementConfig
        public StackHeaderToolbarMenuItemConfig getItem() {
            return this.item;
        }
    }

    /* JADX INFO: compiled from: StackHeaderToolbarMenuElementConfig.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0007HÖ\u0081\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuElementConfig$Submenu;", "Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuElementConfig;", "item", "Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuItemConfig;", "menu", "Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuConfig;", "menuTitle", "", "<init>", "(Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuItemConfig;Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuConfig;Ljava/lang/String;)V", "getItem", "()Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuItemConfig;", "getMenu", "()Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuConfig;", "getMenuTitle", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Submenu implements StackHeaderToolbarMenuElementConfig {
        private final StackHeaderToolbarMenuItemConfig item;
        private final StackHeaderToolbarMenuConfig menu;
        private final String menuTitle;

        public static /* synthetic */ Submenu copy$default(Submenu submenu, StackHeaderToolbarMenuItemConfig stackHeaderToolbarMenuItemConfig, StackHeaderToolbarMenuConfig stackHeaderToolbarMenuConfig, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                stackHeaderToolbarMenuItemConfig = submenu.item;
            }
            if ((i & 2) != 0) {
                stackHeaderToolbarMenuConfig = submenu.menu;
            }
            if ((i & 4) != 0) {
                str = submenu.menuTitle;
            }
            return submenu.copy(stackHeaderToolbarMenuItemConfig, stackHeaderToolbarMenuConfig, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final StackHeaderToolbarMenuItemConfig getItem() {
            return this.item;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final StackHeaderToolbarMenuConfig getMenu() {
            return this.menu;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getMenuTitle() {
            return this.menuTitle;
        }

        public final Submenu copy(StackHeaderToolbarMenuItemConfig item, StackHeaderToolbarMenuConfig menu, String menuTitle) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(menu, "menu");
            return new Submenu(item, menu, menuTitle);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Submenu)) {
                return false;
            }
            Submenu submenu = (Submenu) other;
            return Intrinsics.areEqual(this.item, submenu.item) && Intrinsics.areEqual(this.menu, submenu.menu) && Intrinsics.areEqual(this.menuTitle, submenu.menuTitle);
        }

        public int hashCode() {
            int iHashCode = ((this.item.hashCode() * 31) + this.menu.hashCode()) * 31;
            String str = this.menuTitle;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "Submenu(item=" + this.item + ", menu=" + this.menu + ", menuTitle=" + this.menuTitle + ")";
        }

        public Submenu(StackHeaderToolbarMenuItemConfig item, StackHeaderToolbarMenuConfig menu, String str) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(menu, "menu");
            this.item = item;
            this.menu = menu;
            this.menuTitle = str;
        }

        @Override // com.swmansion.rnscreens.gamma.stack.header.toolbar.StackHeaderToolbarMenuElementConfig
        public StackHeaderToolbarMenuItemConfig getItem() {
            return this.item;
        }

        public final StackHeaderToolbarMenuConfig getMenu() {
            return this.menu;
        }

        public final String getMenuTitle() {
            return this.menuTitle;
        }
    }
}
