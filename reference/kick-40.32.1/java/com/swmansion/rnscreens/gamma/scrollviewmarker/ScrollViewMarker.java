package com.swmansion.rnscreens.gamma.scrollviewmarker;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ScrollView;
import androidx.core.view.ViewGroupKt;
import androidx.core.widget.NestedScrollView;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.views.view.ReactViewGroup;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScrollViewMarker.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0014J\b\u0010\b\u001a\u00020\u0007H\u0014J\b\u0010\u000b\u001a\u00020\fH\u0002J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0002J\r\u0010\u0011\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/swmansion/rnscreens/gamma/scrollviewmarker/ScrollViewMarker;", "Lcom/facebook/react/views/view/ReactViewGroup;", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "<init>", "(Lcom/facebook/react/uimanager/ThemedReactContext;)V", "onAttachedToWindow", "", "onDetachedFromWindow", "hasAttemptedRegistration", "", "findScrollView", "Landroid/view/ViewGroup;", "findFirstSeekingAncestor", "Lcom/swmansion/rnscreens/gamma/scrollviewmarker/ScrollViewSeeking;", "registerWithSeekingAncestor", "maybeRegisterWithSeekingAncestor", "onViewManagerDropViewInstance", "onViewManagerDropViewInstance$react_native_screens_release", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ScrollViewMarker extends ReactViewGroup {
    private boolean hasAttemptedRegistration;
    private final ThemedReactContext reactContext;

    public final void onViewManagerDropViewInstance$react_native_screens_release() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollViewMarker(ThemedReactContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        maybeRegisterWithSeekingAncestor();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.hasAttemptedRegistration = false;
        super.onDetachedFromWindow();
    }

    private final ViewGroup findScrollView() {
        View next;
        View view;
        Iterator<View> it = ViewGroupKt.getChildren(this).iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            view = next;
            if (view instanceof ScrollView) {
                break;
            }
        } while (!(view instanceof NestedScrollView));
        if (next == null) {
            throw new IllegalStateException("[RNScreens] Failed to find supported type of ScrollView in children of ScrollViewMarker".toString());
        }
        View view2 = next;
        Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type android.view.ViewGroup");
        return (ViewGroup) view2;
    }

    private final ScrollViewSeeking findFirstSeekingAncestor() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof ScrollViewSeeking) {
                return (ScrollViewSeeking) parent;
            }
        }
        return null;
    }

    private final void registerWithSeekingAncestor() {
        ViewGroup viewGroupFindScrollView = findScrollView();
        ScrollViewSeeking scrollViewSeekingFindFirstSeekingAncestor = findFirstSeekingAncestor();
        if (scrollViewSeekingFindFirstSeekingAncestor != null) {
            scrollViewSeekingFindFirstSeekingAncestor.registerScrollView(this, viewGroupFindScrollView);
        }
    }

    private final void maybeRegisterWithSeekingAncestor() {
        if (this.hasAttemptedRegistration) {
            return;
        }
        registerWithSeekingAncestor();
        this.hasAttemptedRegistration = true;
    }
}
