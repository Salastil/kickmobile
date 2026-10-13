package com.swmansion.rnscreens.gamma.stack.header.toolbar;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StackHeaderToolbarMenuUpdateQueue.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuElementRawUpdate;", "", "id", "", "options", "Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuElementOptions;", "iconSource", "Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuItemIconSource;", "<init>", "(Ljava/lang/String;Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuElementOptions;Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuItemIconSource;)V", "getId", "()Ljava/lang/String;", "getOptions", "()Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuElementOptions;", "getIconSource", "()Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuItemIconSource;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class StackHeaderToolbarMenuElementRawUpdate {
    private final StackHeaderToolbarMenuItemIconSource iconSource;
    private final String id;
    private final StackHeaderToolbarMenuElementOptions options;

    public static /* synthetic */ StackHeaderToolbarMenuElementRawUpdate copy$default(StackHeaderToolbarMenuElementRawUpdate stackHeaderToolbarMenuElementRawUpdate, String str, StackHeaderToolbarMenuElementOptions stackHeaderToolbarMenuElementOptions, StackHeaderToolbarMenuItemIconSource stackHeaderToolbarMenuItemIconSource, int i, Object obj) {
        if ((i & 1) != 0) {
            str = stackHeaderToolbarMenuElementRawUpdate.id;
        }
        if ((i & 2) != 0) {
            stackHeaderToolbarMenuElementOptions = stackHeaderToolbarMenuElementRawUpdate.options;
        }
        if ((i & 4) != 0) {
            stackHeaderToolbarMenuItemIconSource = stackHeaderToolbarMenuElementRawUpdate.iconSource;
        }
        return stackHeaderToolbarMenuElementRawUpdate.copy(str, stackHeaderToolbarMenuElementOptions, stackHeaderToolbarMenuItemIconSource);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final StackHeaderToolbarMenuElementOptions getOptions() {
        return this.options;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final StackHeaderToolbarMenuItemIconSource getIconSource() {
        return this.iconSource;
    }

    public final StackHeaderToolbarMenuElementRawUpdate copy(String id, StackHeaderToolbarMenuElementOptions options, StackHeaderToolbarMenuItemIconSource iconSource) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(options, "options");
        return new StackHeaderToolbarMenuElementRawUpdate(id, options, iconSource);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StackHeaderToolbarMenuElementRawUpdate)) {
            return false;
        }
        StackHeaderToolbarMenuElementRawUpdate stackHeaderToolbarMenuElementRawUpdate = (StackHeaderToolbarMenuElementRawUpdate) other;
        return Intrinsics.areEqual(this.id, stackHeaderToolbarMenuElementRawUpdate.id) && Intrinsics.areEqual(this.options, stackHeaderToolbarMenuElementRawUpdate.options) && Intrinsics.areEqual(this.iconSource, stackHeaderToolbarMenuElementRawUpdate.iconSource);
    }

    public int hashCode() {
        int iHashCode = ((this.id.hashCode() * 31) + this.options.hashCode()) * 31;
        StackHeaderToolbarMenuItemIconSource stackHeaderToolbarMenuItemIconSource = this.iconSource;
        return iHashCode + (stackHeaderToolbarMenuItemIconSource == null ? 0 : stackHeaderToolbarMenuItemIconSource.hashCode());
    }

    public String toString() {
        return "StackHeaderToolbarMenuElementRawUpdate(id=" + this.id + ", options=" + this.options + ", iconSource=" + this.iconSource + ")";
    }

    public StackHeaderToolbarMenuElementRawUpdate(String id, StackHeaderToolbarMenuElementOptions options, StackHeaderToolbarMenuItemIconSource stackHeaderToolbarMenuItemIconSource) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(options, "options");
        this.id = id;
        this.options = options;
        this.iconSource = stackHeaderToolbarMenuItemIconSource;
    }

    public final String getId() {
        return this.id;
    }

    public final StackHeaderToolbarMenuElementOptions getOptions() {
        return this.options;
    }

    public final StackHeaderToolbarMenuItemIconSource getIconSource() {
        return this.iconSource;
    }
}
