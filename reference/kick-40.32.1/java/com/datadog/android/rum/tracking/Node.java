package com.datadog.android.rum.tracking;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewTarget.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005HÆ\u0003J+\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/datadog/android/rum/tracking/Node;", "", "name", "", "customAttributes", "", "(Ljava/lang/String;Ljava/util/Map;)V", "getCustomAttributes", "()Ljava/util/Map;", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class Node {
    private final Map<String, Object> customAttributes;
    private final String name;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Node copy$default(Node node, String str, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = node.name;
        }
        if ((i & 2) != 0) {
            map = node.customAttributes;
        }
        return node.copy(str, map);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final Map<String, Object> component2() {
        return this.customAttributes;
    }

    public final Node copy(String name, Map<String, ? extends Object> customAttributes) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(customAttributes, "customAttributes");
        return new Node(name, customAttributes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Node)) {
            return false;
        }
        Node node = (Node) other;
        return Intrinsics.areEqual(this.name, node.name) && Intrinsics.areEqual(this.customAttributes, node.customAttributes);
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.customAttributes.hashCode();
    }

    public String toString() {
        return "Node(name=" + this.name + ", customAttributes=" + this.customAttributes + ")";
    }

    public Node(String name, Map<String, ? extends Object> customAttributes) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(customAttributes, "customAttributes");
        this.name = name;
        this.customAttributes = customAttributes;
    }

    public final String getName() {
        return this.name;
    }

    public /* synthetic */ Node(String str, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? MapsKt.emptyMap() : map);
    }

    public final Map<String, Object> getCustomAttributes() {
        return this.customAttributes;
    }
}
