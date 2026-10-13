package com.swmansion.rnscreens.gamma.common.container;

import android.view.ViewGroup;
import com.datadog.android.webview.internal.rum.WebViewRumEventMapper;
import com.swmansion.rnscreens.ext.WeakReferenceExtKt;
import com.swmansion.rnscreens.gamma.helpers.ViewFinder;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContainerItemSupport.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0006J\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0006J\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\bR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/swmansion/rnscreens/gamma/common/container/ContainerItemSupport;", "", "<init>", "()V", "nestedContainer", "Ljava/lang/ref/WeakReference;", "Lcom/swmansion/rnscreens/gamma/common/container/Container;", "contentScrollView", "Landroid/view/ViewGroup;", "registerScrollView", "", "scrollView", "registerNestedContainer", WebViewRumEventMapper.CONTAINER_KEY_NAME, "unregisterNestedContainer", "resolveNestedContainer", "findContentScrollView", "owner", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ContainerItemSupport {
    private WeakReference<Container> nestedContainer = new WeakReference<>(null);
    private WeakReference<ViewGroup> contentScrollView = new WeakReference<>(null);

    public final void registerScrollView(ViewGroup scrollView) {
        Intrinsics.checkNotNullParameter(scrollView, "scrollView");
        this.contentScrollView = new WeakReference<>(scrollView);
    }

    public final void registerNestedContainer(Container container) {
        Intrinsics.checkNotNullParameter(container, "container");
        this.nestedContainer = new WeakReference<>(container);
    }

    public final void unregisterNestedContainer(Container container) {
        Intrinsics.checkNotNullParameter(container, "container");
        if (WeakReferenceExtKt.refersToCompat(this.nestedContainer, container)) {
            this.nestedContainer.clear();
        }
    }

    public final Container resolveNestedContainer() {
        return this.nestedContainer.get();
    }

    public final ViewGroup findContentScrollView(ViewGroup owner) {
        ViewGroup viewGroupResolveCurrentContentScrollView;
        Intrinsics.checkNotNullParameter(owner, "owner");
        ViewGroup viewGroup = this.contentScrollView.get();
        if (viewGroup != null) {
            return viewGroup;
        }
        Container containerResolveNestedContainer = resolveNestedContainer();
        if (containerResolveNestedContainer != null && (viewGroupResolveCurrentContentScrollView = containerResolveNestedContainer.resolveCurrentContentScrollView()) != null) {
            return viewGroupResolveCurrentContentScrollView;
        }
        ViewGroup viewGroupFindScrollViewInFirstDescendantChain = ViewFinder.INSTANCE.findScrollViewInFirstDescendantChain(owner);
        if (viewGroupFindScrollViewInFirstDescendantChain != null) {
            return viewGroupFindScrollViewInFirstDescendantChain;
        }
        return null;
    }
}
