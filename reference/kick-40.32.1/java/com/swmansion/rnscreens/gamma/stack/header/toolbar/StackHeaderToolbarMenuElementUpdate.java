package com.swmansion.rnscreens.gamma.stack.header.toolbar;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StackHeaderToolbarMenuUpdateQueue.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuElementUpdate;", "", "id", "", "options", "Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuElementOptions;", "<init>", "(Ljava/lang/String;Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuElementOptions;)V", "getId", "()Ljava/lang/String;", "getOptions", "()Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuElementOptions;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class StackHeaderToolbarMenuElementUpdate {
    private final String id;
    private final StackHeaderToolbarMenuElementOptions options;

    public static /* synthetic */ StackHeaderToolbarMenuElementUpdate copy$default(StackHeaderToolbarMenuElementUpdate stackHeaderToolbarMenuElementUpdate, String str, StackHeaderToolbarMenuElementOptions stackHeaderToolbarMenuElementOptions, int i, Object obj) {
        if ((i & 1) != 0) {
            str = stackHeaderToolbarMenuElementUpdate.id;
        }
        if ((i & 2) != 0) {
            stackHeaderToolbarMenuElementOptions = stackHeaderToolbarMenuElementUpdate.options;
        }
        return stackHeaderToolbarMenuElementUpdate.copy(str, stackHeaderToolbarMenuElementOptions);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final StackHeaderToolbarMenuElementOptions getOptions() {
        return this.options;
    }

    public final StackHeaderToolbarMenuElementUpdate copy(String id, StackHeaderToolbarMenuElementOptions options) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(options, "options");
        return new StackHeaderToolbarMenuElementUpdate(id, options);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StackHeaderToolbarMenuElementUpdate)) {
            return false;
        }
        StackHeaderToolbarMenuElementUpdate stackHeaderToolbarMenuElementUpdate = (StackHeaderToolbarMenuElementUpdate) other;
        return Intrinsics.areEqual(this.id, stackHeaderToolbarMenuElementUpdate.id) && Intrinsics.areEqual(this.options, stackHeaderToolbarMenuElementUpdate.options);
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + this.options.hashCode();
    }

    public String toString() {
        return "StackHeaderToolbarMenuElementUpdate(id=" + this.id + ", options=" + this.options + ")";
    }

    public StackHeaderToolbarMenuElementUpdate(String id, StackHeaderToolbarMenuElementOptions options) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(options, "options");
        this.id = id;
        this.options = options;
    }

    public final String getId() {
        return this.id;
    }

    public final StackHeaderToolbarMenuElementOptions getOptions() {
        return this.options;
    }
}
