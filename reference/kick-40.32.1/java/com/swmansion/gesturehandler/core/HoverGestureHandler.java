package com.swmansion.gesturehandler.core;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.swmansion.gesturehandler.react.RNGestureHandlerRootHelper;
import com.swmansion.gesturehandler.react.events.eventbuilders.HoverGestureHandlerEventDataBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HoverGestureHandler.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0001H\u0082\u0004J)\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0001H\u0016J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0014J\u0018\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0014J\b\u0010 \u001a\u00020\u001bH\u0014J\b\u0010!\u001a\u00020\u001bH\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006#"}, d2 = {"Lcom/swmansion/gesturehandler/core/HoverGestureHandler;", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "<init>", "()V", "isContinuous", "", "()Z", "handler", "Landroid/os/Handler;", "finishRunnable", "Ljava/lang/Runnable;", "value", "Lcom/swmansion/gesturehandler/core/StylusData;", "stylusData", "getStylusData", "()Lcom/swmansion/gesturehandler/core/StylusData;", "isAncestorOf", "other", "isViewDisplayedOverAnother", "view", "Landroid/view/View;", "rootView", "(Landroid/view/View;Landroid/view/View;Landroid/view/View;)Ljava/lang/Boolean;", "shouldBeCancelledBy", "shouldRequireToWaitForFailure", "shouldRecognizeSimultaneously", "onHandle", "", "event", "Landroid/view/MotionEvent;", "sourceEvent", "onHandleHover", "onReset", "finish", "Factory", "react-native-gesture-handler_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HoverGestureHandler extends GestureHandler {
    private Handler handler;
    private final boolean isContinuous = true;
    private Runnable finishRunnable = new Runnable() { // from class: com.swmansion.gesturehandler.core.HoverGestureHandler$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.finish();
        }
    };
    private StylusData stylusData = new StylusData(0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 31, null);

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    /* JADX INFO: renamed from: isContinuous, reason: from getter */
    public boolean getIsContinuous() {
        return this.isContinuous;
    }

    public final StylusData getStylusData() {
        return this.stylusData;
    }

    private final boolean isAncestorOf(GestureHandler other) {
        View view = other.getView();
        while (view != null) {
            if (Intrinsics.areEqual(view, getView())) {
                return true;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return false;
    }

    static /* synthetic */ Boolean isViewDisplayedOverAnother$default(HoverGestureHandler hoverGestureHandler, View view, View view2, View view3, int i, Object obj) {
        if ((i & 4) != 0) {
            view3 = view.getRootView();
            Intrinsics.checkNotNullExpressionValue(view3, "getRootView(...)");
        }
        return hoverGestureHandler.isViewDisplayedOverAnother(view, view2, view3);
    }

    private final Boolean isViewDisplayedOverAnother(View view, View other, View rootView) {
        if (Intrinsics.areEqual(rootView, other)) {
            return true;
        }
        if (Intrinsics.areEqual(rootView, view)) {
            return false;
        }
        if (!(rootView instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) rootView;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            Intrinsics.checkNotNull(childAt);
            Boolean boolIsViewDisplayedOverAnother = isViewDisplayedOverAnother(view, other, childAt);
            if (boolIsViewDisplayedOverAnother != null) {
                boolIsViewDisplayedOverAnother.booleanValue();
                return boolIsViewDisplayedOverAnother;
            }
        }
        return null;
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public boolean shouldBeCancelledBy(GestureHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        if ((handler instanceof HoverGestureHandler) && !((HoverGestureHandler) handler).isAncestorOf(this)) {
            View view = handler.getView();
            Intrinsics.checkNotNull(view);
            View view2 = getView();
            Intrinsics.checkNotNull(view2);
            Boolean boolIsViewDisplayedOverAnother$default = isViewDisplayedOverAnother$default(this, view, view2, null, 4, null);
            Intrinsics.checkNotNull(boolIsViewDisplayedOverAnother$default);
            return boolIsViewDisplayedOverAnother$default.booleanValue();
        }
        return super.shouldBeCancelledBy(handler);
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public boolean shouldRequireToWaitForFailure(GestureHandler handler) {
        HoverGestureHandler hoverGestureHandler;
        Intrinsics.checkNotNullParameter(handler, "handler");
        if (!(handler instanceof HoverGestureHandler) || isAncestorOf(handler) || ((HoverGestureHandler) handler).isAncestorOf(this)) {
            hoverGestureHandler = this;
        } else {
            View view = getView();
            Intrinsics.checkNotNull(view);
            View view2 = handler.getView();
            Intrinsics.checkNotNull(view2);
            hoverGestureHandler = this;
            Boolean boolIsViewDisplayedOverAnother$default = isViewDisplayedOverAnother$default(hoverGestureHandler, view, view2, null, 4, null);
            if (boolIsViewDisplayedOverAnother$default != null) {
                return boolIsViewDisplayedOverAnother$default.booleanValue();
            }
        }
        return super.shouldRequireToWaitForFailure(handler);
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public boolean shouldRecognizeSimultaneously(GestureHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        if (((handler instanceof HoverGestureHandler) && (isAncestorOf(handler) || ((HoverGestureHandler) handler).isAncestorOf(this))) || (handler instanceof RNGestureHandlerRootHelper.RootViewGestureHandler)) {
            return true;
        }
        return super.shouldRecognizeSimultaneously(handler);
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    protected void onHandle(MotionEvent event, MotionEvent sourceEvent) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
        if (event.getAction() == 0) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.handler = null;
            return;
        }
        if (event.getAction() != 1 || getIsWithinBounds()) {
            return;
        }
        finish();
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    protected void onHandleHover(MotionEvent event, MotionEvent sourceEvent) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
        if (event.getAction() == 10) {
            if (this.handler == null) {
                this.handler = new Handler(Looper.getMainLooper());
            }
            Handler handler = this.handler;
            Intrinsics.checkNotNull(handler);
            handler.postDelayed(this.finishRunnable, 4L);
            return;
        }
        if (!getIsWithinBounds()) {
            finish();
            return;
        }
        if (getState() == 4 && event.getToolType(0) == 2) {
            this.stylusData = StylusData.INSTANCE.fromEvent(event);
            return;
        }
        if (getState() == 0) {
            if (event.getAction() == 7 || event.getAction() == 9) {
                begin();
                activate();
            }
        }
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    protected void onReset() {
        super.onReset();
        this.stylusData = new StylusData(0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 31, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finish() {
        int state = getState();
        if (state == 0) {
            cancel();
        } else if (state == 2) {
            fail();
        } else {
            if (state != 4) {
                return;
            }
            end();
        }
    }

    /* JADX INFO: compiled from: HoverGestureHandler.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\r\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0016R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/swmansion/gesturehandler/core/HoverGestureHandler$Factory;", "Lcom/swmansion/gesturehandler/core/GestureHandler$Factory;", "Lcom/swmansion/gesturehandler/core/HoverGestureHandler;", "<init>", "()V", "type", "Ljava/lang/Class;", "getType", "()Ljava/lang/Class;", "name", "", "getName", "()Ljava/lang/String;", "create", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "createEventBuilder", "Lcom/swmansion/gesturehandler/react/events/eventbuilders/HoverGestureHandlerEventDataBuilder;", "handler", "react-native-gesture-handler_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Factory extends GestureHandler.Factory<HoverGestureHandler> {
        private final Class<HoverGestureHandler> type = HoverGestureHandler.class;
        private final String name = "HoverGestureHandler";

        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        public Class<HoverGestureHandler> getType() {
            return this.type;
        }

        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        public String getName() {
            return this.name;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        public HoverGestureHandler create(Context context) {
            return new HoverGestureHandler();
        }

        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        public HoverGestureHandlerEventDataBuilder createEventBuilder(HoverGestureHandler handler) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            return new HoverGestureHandlerEventDataBuilder(handler);
        }
    }
}
