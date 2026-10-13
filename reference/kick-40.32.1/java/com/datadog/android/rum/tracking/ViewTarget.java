package com.datadog.android.rum.tracking;

import android.view.View;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewTarget.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B#\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/datadog/android/rum/tracking/ViewTarget;", "", "viewRef", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "node", "Lcom/datadog/android/rum/tracking/Node;", "(Ljava/lang/ref/WeakReference;Lcom/datadog/android/rum/tracking/Node;)V", "getNode", "()Lcom/datadog/android/rum/tracking/Node;", "getViewRef", "()Ljava/lang/ref/WeakReference;", "equals", "", "other", "hashCode", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ViewTarget {
    private final Node node;
    private final WeakReference<View> viewRef;

    /* JADX WARN: Multi-variable type inference failed */
    public ViewTarget() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public ViewTarget(WeakReference<View> viewRef, Node node) {
        Intrinsics.checkNotNullParameter(viewRef, "viewRef");
        this.viewRef = viewRef;
        this.node = node;
    }

    public /* synthetic */ ViewTarget(WeakReference weakReference, Node node, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new WeakReference(null) : weakReference, (i & 2) != 0 ? null : node);
    }

    public final WeakReference<View> getViewRef() {
        return this.viewRef;
    }

    public final Node getNode() {
        return this.node;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ViewTarget)) {
            return false;
        }
        ViewTarget viewTarget = (ViewTarget) other;
        return Intrinsics.areEqual(this.viewRef.get(), viewTarget.viewRef.get()) && Intrinsics.areEqual(this.node, viewTarget.node);
    }

    public int hashCode() {
        View view = this.viewRef.get();
        int iHashCode = (view != null ? view.hashCode() : 0) * 31;
        Node node = this.node;
        return iHashCode + (node != null ? node.hashCode() : 0);
    }
}
