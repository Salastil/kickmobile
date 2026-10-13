package com.swmansion.reanimated.css;

import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CSSPlatformTransitionReconciler.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\rJ\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\nH\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/swmansion/reanimated/css/CSSPlatformTransitionReconciler;", "", "beforeDraw", "Lkotlin/Function0;", "", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "tracked", "Ljava/util/HashMap;", "Landroid/view/ViewTreeObserver;", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "Lkotlin/collections/HashMap;", "track", "", "view", "Landroid/view/View;", "invalidate", "retire", "observer", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "react-native-reanimated_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CSSPlatformTransitionReconciler {
    private final Function0<Boolean> beforeDraw;
    private final HashMap<ViewTreeObserver, ViewTreeObserver.OnPreDrawListener> tracked;

    public CSSPlatformTransitionReconciler(Function0<Boolean> beforeDraw) {
        Intrinsics.checkNotNullParameter(beforeDraw, "beforeDraw");
        this.beforeDraw = beforeDraw;
        this.tracked = new HashMap<>();
    }

    static final boolean track$lambda$0(ViewTreeObserver it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !it.isAlive();
    }

    public final void track(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Set<ViewTreeObserver> setKeySet = this.tracked.keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet, "<get-keys>(...)");
        CollectionsKt.removeAll(setKeySet, new Function1() { // from class: com.swmansion.reanimated.css.CSSPlatformTransitionReconciler$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(CSSPlatformTransitionReconciler.track$lambda$0((ViewTreeObserver) obj));
            }
        });
        if (view.isAttachedToWindow()) {
            final ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (!viewTreeObserver.isAlive() || this.tracked.containsKey(viewTreeObserver)) {
                return;
            }
            ViewTreeObserver.OnPreDrawListener onPreDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: com.swmansion.reanimated.css.CSSPlatformTransitionReconciler$track$listener$1
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    if (((Boolean) this.this$0.beforeDraw.invoke()).booleanValue()) {
                        return true;
                    }
                    CSSPlatformTransitionReconciler cSSPlatformTransitionReconciler = this.this$0;
                    ViewTreeObserver viewTreeObserver2 = viewTreeObserver;
                    Intrinsics.checkNotNull(viewTreeObserver2);
                    cSSPlatformTransitionReconciler.retire(viewTreeObserver2, this);
                    return true;
                }
            };
            this.tracked.put(viewTreeObserver, onPreDrawListener);
            viewTreeObserver.addOnPreDrawListener(onPreDrawListener);
        }
    }

    public final void invalidate() {
        for (Map.Entry<ViewTreeObserver, ViewTreeObserver.OnPreDrawListener> entry : this.tracked.entrySet()) {
            ViewTreeObserver key = entry.getKey();
            ViewTreeObserver.OnPreDrawListener value = entry.getValue();
            if (key.isAlive()) {
                key.removeOnPreDrawListener(value);
            }
        }
        this.tracked.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void retire(ViewTreeObserver observer, ViewTreeObserver.OnPreDrawListener listener) {
        if (observer.isAlive()) {
            observer.removeOnPreDrawListener(listener);
        }
        this.tracked.remove(observer);
    }
}
