package com.facebook.react.bridge;

import android.view.ViewGroup;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScrollEndedListener.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eR\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/facebook/react/bridge/ScrollEndedListeners;", "", "<init>", "()V", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/lang/ref/WeakReference;", "Lcom/facebook/react/bridge/ScrollEndedListener;", "addListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removeListener", "notifyScrollEnded", "scrollView", "Landroid/view/ViewGroup;", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ScrollEndedListeners {
    private final CopyOnWriteArrayList<WeakReference<ScrollEndedListener>> listeners = new CopyOnWriteArrayList<>();

    public final void addListener(ScrollEndedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.add(new WeakReference<>(listener));
    }

    public final void removeListener(ScrollEndedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ArrayList arrayList = new ArrayList();
        Iterator<WeakReference<ScrollEndedListener>> it = this.listeners.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            WeakReference<ScrollEndedListener> next = it.next();
            ScrollEndedListener scrollEndedListener = next.get();
            if (scrollEndedListener == null || Intrinsics.areEqual(scrollEndedListener, listener)) {
                arrayList.add(next);
            }
        }
        this.listeners.removeAll(arrayList);
    }

    public final void notifyScrollEnded(ViewGroup scrollView) {
        Intrinsics.checkNotNullParameter(scrollView, "scrollView");
        Iterator<WeakReference<ScrollEndedListener>> it = this.listeners.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            ScrollEndedListener scrollEndedListener = it.next().get();
            if (scrollEndedListener != null) {
                scrollEndedListener.onScrollEnded(scrollView);
            }
        }
    }
}
