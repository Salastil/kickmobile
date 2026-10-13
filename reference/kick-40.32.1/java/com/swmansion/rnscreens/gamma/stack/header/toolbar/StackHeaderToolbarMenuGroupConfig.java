package com.swmansion.rnscreens.gamma.stack.header.toolbar;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StackHeaderToolbarMenuGroupConfig.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuGroupConfig;", "", "groupId", "", "singleSelection", "", "<init>", "(Ljava/lang/String;Z)V", "getGroupId", "()Ljava/lang/String;", "getSingleSelection", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class StackHeaderToolbarMenuGroupConfig {
    private final String groupId;
    private final boolean singleSelection;

    public static /* synthetic */ StackHeaderToolbarMenuGroupConfig copy$default(StackHeaderToolbarMenuGroupConfig stackHeaderToolbarMenuGroupConfig, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = stackHeaderToolbarMenuGroupConfig.groupId;
        }
        if ((i & 2) != 0) {
            z = stackHeaderToolbarMenuGroupConfig.singleSelection;
        }
        return stackHeaderToolbarMenuGroupConfig.copy(str, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getSingleSelection() {
        return this.singleSelection;
    }

    public final StackHeaderToolbarMenuGroupConfig copy(String groupId, boolean singleSelection) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        return new StackHeaderToolbarMenuGroupConfig(groupId, singleSelection);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StackHeaderToolbarMenuGroupConfig)) {
            return false;
        }
        StackHeaderToolbarMenuGroupConfig stackHeaderToolbarMenuGroupConfig = (StackHeaderToolbarMenuGroupConfig) other;
        return Intrinsics.areEqual(this.groupId, stackHeaderToolbarMenuGroupConfig.groupId) && this.singleSelection == stackHeaderToolbarMenuGroupConfig.singleSelection;
    }

    public int hashCode() {
        return (this.groupId.hashCode() * 31) + Boolean.hashCode(this.singleSelection);
    }

    public String toString() {
        return "StackHeaderToolbarMenuGroupConfig(groupId=" + this.groupId + ", singleSelection=" + this.singleSelection + ")";
    }

    public StackHeaderToolbarMenuGroupConfig(String groupId, boolean z) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        this.groupId = groupId;
        this.singleSelection = z;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final boolean getSingleSelection() {
        return this.singleSelection;
    }
}
