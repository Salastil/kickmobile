package com.swmansion.rnscreens.gamma.stack.header.toolbar;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StackHeaderToolbarMenuGroupMetadata.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018BI\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\b0\u0003¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0015\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u001b\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\b0\u0003HÆ\u0003JQ\u0010\u0012\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u00032\u001a\b\u0002\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\b0\u0003HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0004HÖ\u0081\u0004R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR#\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuGroupMetadata;", "", "itemGroupMap", "", "", "groupSingleSelection", "", "groupMemberItems", "", "<init>", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "getItemGroupMap", "()Ljava/util/Map;", "getGroupSingleSelection", "getGroupMemberItems", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class StackHeaderToolbarMenuGroupMetadata {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final StackHeaderToolbarMenuGroupMetadata EMPTY = new StackHeaderToolbarMenuGroupMetadata(MapsKt.emptyMap(), MapsKt.emptyMap(), MapsKt.emptyMap());
    private final Map<String, List<String>> groupMemberItems;
    private final Map<String, Boolean> groupSingleSelection;
    private final Map<String, String> itemGroupMap;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StackHeaderToolbarMenuGroupMetadata copy$default(StackHeaderToolbarMenuGroupMetadata stackHeaderToolbarMenuGroupMetadata, Map map, Map map2, Map map3, int i, Object obj) {
        if ((i & 1) != 0) {
            map = stackHeaderToolbarMenuGroupMetadata.itemGroupMap;
        }
        if ((i & 2) != 0) {
            map2 = stackHeaderToolbarMenuGroupMetadata.groupSingleSelection;
        }
        if ((i & 4) != 0) {
            map3 = stackHeaderToolbarMenuGroupMetadata.groupMemberItems;
        }
        return stackHeaderToolbarMenuGroupMetadata.copy(map, map2, map3);
    }

    public final Map<String, String> component1() {
        return this.itemGroupMap;
    }

    public final Map<String, Boolean> component2() {
        return this.groupSingleSelection;
    }

    public final Map<String, List<String>> component3() {
        return this.groupMemberItems;
    }

    public final StackHeaderToolbarMenuGroupMetadata copy(Map<String, String> itemGroupMap, Map<String, Boolean> groupSingleSelection, Map<String, ? extends List<String>> groupMemberItems) {
        Intrinsics.checkNotNullParameter(itemGroupMap, "itemGroupMap");
        Intrinsics.checkNotNullParameter(groupSingleSelection, "groupSingleSelection");
        Intrinsics.checkNotNullParameter(groupMemberItems, "groupMemberItems");
        return new StackHeaderToolbarMenuGroupMetadata(itemGroupMap, groupSingleSelection, groupMemberItems);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StackHeaderToolbarMenuGroupMetadata)) {
            return false;
        }
        StackHeaderToolbarMenuGroupMetadata stackHeaderToolbarMenuGroupMetadata = (StackHeaderToolbarMenuGroupMetadata) other;
        return Intrinsics.areEqual(this.itemGroupMap, stackHeaderToolbarMenuGroupMetadata.itemGroupMap) && Intrinsics.areEqual(this.groupSingleSelection, stackHeaderToolbarMenuGroupMetadata.groupSingleSelection) && Intrinsics.areEqual(this.groupMemberItems, stackHeaderToolbarMenuGroupMetadata.groupMemberItems);
    }

    public int hashCode() {
        return (((this.itemGroupMap.hashCode() * 31) + this.groupSingleSelection.hashCode()) * 31) + this.groupMemberItems.hashCode();
    }

    public String toString() {
        return "StackHeaderToolbarMenuGroupMetadata(itemGroupMap=" + this.itemGroupMap + ", groupSingleSelection=" + this.groupSingleSelection + ", groupMemberItems=" + this.groupMemberItems + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StackHeaderToolbarMenuGroupMetadata(Map<String, String> itemGroupMap, Map<String, Boolean> groupSingleSelection, Map<String, ? extends List<String>> groupMemberItems) {
        Intrinsics.checkNotNullParameter(itemGroupMap, "itemGroupMap");
        Intrinsics.checkNotNullParameter(groupSingleSelection, "groupSingleSelection");
        Intrinsics.checkNotNullParameter(groupMemberItems, "groupMemberItems");
        this.itemGroupMap = itemGroupMap;
        this.groupSingleSelection = groupSingleSelection;
        this.groupMemberItems = groupMemberItems;
    }

    public final Map<String, String> getItemGroupMap() {
        return this.itemGroupMap;
    }

    public final Map<String, Boolean> getGroupSingleSelection() {
        return this.groupSingleSelection;
    }

    public final Map<String, List<String>> getGroupMemberItems() {
        return this.groupMemberItems;
    }

    /* JADX INFO: compiled from: StackHeaderToolbarMenuGroupMetadata.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuGroupMetadata$Companion;", "", "<init>", "()V", "EMPTY", "Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuGroupMetadata;", "getEMPTY", "()Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuGroupMetadata;", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final StackHeaderToolbarMenuGroupMetadata getEMPTY() {
            return StackHeaderToolbarMenuGroupMetadata.EMPTY;
        }
    }
}
