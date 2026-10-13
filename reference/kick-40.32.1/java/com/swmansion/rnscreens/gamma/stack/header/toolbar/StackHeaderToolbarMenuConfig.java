package com.swmansion.rnscreens.gamma.stack.header.toolbar;

import android.graphics.drawable.Drawable;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StackHeaderToolbarMenuConfig.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0000¢\u0006\u0002\b\u0011J.\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\"\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J)\u0010\u0017\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0001J\u0014\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\u001cHÖ\u0081\u0004J\n\u0010\u001d\u001a\u00020\u000eHÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u001e"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuConfig;", "", "groups", "", "Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuGroupConfig;", "children", "Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuElementConfig;", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getGroups", "()Ljava/util/List;", "getChildren", "updateItemIcon", "id", "", "icon", "Landroid/graphics/drawable/Drawable;", "updateItemIcon$react_native_screens_release", "updateChildrenIcon", "updateElementIcon", "element", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class StackHeaderToolbarMenuConfig {
    private final List<StackHeaderToolbarMenuElementConfig> children;
    private final List<StackHeaderToolbarMenuGroupConfig> groups;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StackHeaderToolbarMenuConfig copy$default(StackHeaderToolbarMenuConfig stackHeaderToolbarMenuConfig, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = stackHeaderToolbarMenuConfig.groups;
        }
        if ((i & 2) != 0) {
            list2 = stackHeaderToolbarMenuConfig.children;
        }
        return stackHeaderToolbarMenuConfig.copy(list, list2);
    }

    public final List<StackHeaderToolbarMenuGroupConfig> component1() {
        return this.groups;
    }

    public final List<StackHeaderToolbarMenuElementConfig> component2() {
        return this.children;
    }

    public final StackHeaderToolbarMenuConfig copy(List<StackHeaderToolbarMenuGroupConfig> groups, List<? extends StackHeaderToolbarMenuElementConfig> children) {
        Intrinsics.checkNotNullParameter(groups, "groups");
        Intrinsics.checkNotNullParameter(children, "children");
        return new StackHeaderToolbarMenuConfig(groups, children);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StackHeaderToolbarMenuConfig)) {
            return false;
        }
        StackHeaderToolbarMenuConfig stackHeaderToolbarMenuConfig = (StackHeaderToolbarMenuConfig) other;
        return Intrinsics.areEqual(this.groups, stackHeaderToolbarMenuConfig.groups) && Intrinsics.areEqual(this.children, stackHeaderToolbarMenuConfig.children);
    }

    public int hashCode() {
        return (this.groups.hashCode() * 31) + this.children.hashCode();
    }

    public String toString() {
        return "StackHeaderToolbarMenuConfig(groups=" + this.groups + ", children=" + this.children + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StackHeaderToolbarMenuConfig(List<StackHeaderToolbarMenuGroupConfig> groups, List<? extends StackHeaderToolbarMenuElementConfig> children) {
        Intrinsics.checkNotNullParameter(groups, "groups");
        Intrinsics.checkNotNullParameter(children, "children");
        this.groups = groups;
        this.children = children;
    }

    public final List<StackHeaderToolbarMenuGroupConfig> getGroups() {
        return this.groups;
    }

    public final List<StackHeaderToolbarMenuElementConfig> getChildren() {
        return this.children;
    }

    public final StackHeaderToolbarMenuConfig updateItemIcon$react_native_screens_release(String id, Drawable icon) {
        Intrinsics.checkNotNullParameter(id, "id");
        List<StackHeaderToolbarMenuElementConfig> listUpdateChildrenIcon = updateChildrenIcon(this.children, id, icon);
        return listUpdateChildrenIcon != this.children ? copy$default(this, null, listUpdateChildrenIcon, 1, null) : this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<StackHeaderToolbarMenuElementConfig> updateChildrenIcon(List<? extends StackHeaderToolbarMenuElementConfig> children, String id, Drawable icon) {
        int i = 0;
        for (StackHeaderToolbarMenuElementConfig stackHeaderToolbarMenuElementConfig : children) {
            int i2 = i + 1;
            StackHeaderToolbarMenuElementConfig stackHeaderToolbarMenuElementConfigUpdateElementIcon = updateElementIcon(stackHeaderToolbarMenuElementConfig, id, icon);
            if (stackHeaderToolbarMenuElementConfigUpdateElementIcon != stackHeaderToolbarMenuElementConfig) {
                List<StackHeaderToolbarMenuElementConfig> mutableList = CollectionsKt.toMutableList((Collection) children);
                mutableList.set(i, stackHeaderToolbarMenuElementConfigUpdateElementIcon);
                return mutableList;
            }
            i = i2;
        }
        return children;
    }

    private final StackHeaderToolbarMenuElementConfig updateElementIcon(StackHeaderToolbarMenuElementConfig element, String id, Drawable icon) {
        if (Intrinsics.areEqual(element.getItem().getId(), id)) {
            if (icon == element.getItem().getIcon()) {
                return element;
            }
            StackHeaderToolbarMenuItemConfig stackHeaderToolbarMenuItemConfigCopy$default = StackHeaderToolbarMenuItemConfig.copy$default(element.getItem(), null, null, null, null, null, false, false, null, icon, null, null, null, null, null, null, false, 65279, null);
            if (element instanceof StackHeaderToolbarMenuElementConfig.MenuItem) {
                return ((StackHeaderToolbarMenuElementConfig.MenuItem) element).copy(stackHeaderToolbarMenuItemConfigCopy$default);
            }
            if (element instanceof StackHeaderToolbarMenuElementConfig.Submenu) {
                return StackHeaderToolbarMenuElementConfig.Submenu.copy$default((StackHeaderToolbarMenuElementConfig.Submenu) element, stackHeaderToolbarMenuItemConfigCopy$default, null, null, 6, null);
            }
            throw new NoWhenBranchMatchedException();
        }
        if (!(element instanceof StackHeaderToolbarMenuElementConfig.Submenu)) {
            return element;
        }
        StackHeaderToolbarMenuElementConfig.Submenu submenu = (StackHeaderToolbarMenuElementConfig.Submenu) element;
        List<StackHeaderToolbarMenuElementConfig> listUpdateChildrenIcon = updateChildrenIcon(submenu.getMenu().children, id, icon);
        return listUpdateChildrenIcon != submenu.getMenu().children ? StackHeaderToolbarMenuElementConfig.Submenu.copy$default(submenu, null, copy$default(submenu.getMenu(), null, listUpdateChildrenIcon, 1, null), null, 5, null) : element;
    }
}
