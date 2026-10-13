package com.swmansion.rnscreens.gamma.modals.formsheet;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactPointerEventsView;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.swmansion.rnscreens.gamma.common.ShadowStateProxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FormSheetHost.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020*H\u0000¢\u0006\u0002\bEJ\u0015\u0010F\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0000¢\u0006\u0002\bGJ\u0015\u0010H\u001a\u00020A2\u0006\u0010D\u001a\u00020*H\u0000¢\u0006\u0002\bIJ\r\u0010J\u001a\u00020AH\u0000¢\u0006\u0002\bKJ\r\u0010L\u001a\u00020*H\u0000¢\u0006\u0002\bMJ\u0017\u0010N\u001a\u0004\u0018\u00010C2\u0006\u0010D\u001a\u00020*H\u0000¢\u0006\u0002\bOJ0\u0010T\u001a\u00020A2\u0006\u0010U\u001a\u00020\u001b2\u0006\u0010V\u001a\u00020*2\u0006\u0010W\u001a\u00020*2\u0006\u0010X\u001a\u00020*2\u0006\u0010Y\u001a\u00020*H\u0014J\r\u0010Z\u001a\u00020AH\u0000¢\u0006\u0002\b[J\r\u0010\\\u001a\u00020AH\u0000¢\u0006\u0002\b]J\u001d\u0010^\u001a\u00020A2\u0006\u0010_\u001a\u00020*2\u0006\u0010`\u001a\u00020*H\u0000¢\u0006\u0002\baJ\b\u0010b\u001a\u00020AH\u0002J\r\u0010c\u001a\u00020AH\u0000¢\u0006\u0002\bdR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f8@@@X\u0080\u008e\u0002¢\u0006\u0012\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013*\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0014\u001a\u00020\u0015X\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u001bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\u001a\u0010#\u001a\u00020$X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001e\u0010)\u001a\u0004\u0018\u00010*X\u0080\u000e¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R \u00100\u001a\b\u0012\u0004\u0012\u00020201X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u00107\u001a\u00020*X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u000e\u0010<\u001a\u00020=X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010P\u001a\u00020QX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bR\u0010S¨\u0006e"}, d2 = {"Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetHost;", "Landroid/view/ViewGroup;", "Lcom/facebook/react/uimanager/ReactPointerEventsView;", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "<init>", "(Lcom/facebook/react/uimanager/ThemedReactContext;)V", "getReactContext", "()Lcom/facebook/react/uimanager/ThemedReactContext;", "shadowStateProxy", "Lcom/swmansion/rnscreens/gamma/common/ShadowStateProxy;", "<set-?>", "Lcom/facebook/react/uimanager/StateWrapper;", "stateWrapper", "getStateWrapper$react_native_screens_release$delegate", "(Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetHost;)Ljava/lang/Object;", "getStateWrapper$react_native_screens_release", "()Lcom/facebook/react/uimanager/StateWrapper;", "setStateWrapper$react_native_screens_release", "(Lcom/facebook/react/uimanager/StateWrapper;)V", "eventEmitter", "Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetHostEventEmitter;", "getEventEmitter$react_native_screens_release", "()Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetHostEventEmitter;", "setEventEmitter$react_native_screens_release", "(Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetHostEventEmitter;)V", "isOpen", "", "isOpen$react_native_screens_release", "()Z", "setOpen$react_native_screens_release", "(Z)V", "prefersGrabberVisible", "getPrefersGrabberVisible$react_native_screens_release", "setPrefersGrabberVisible$react_native_screens_release", "preferredCornerRadius", "", "getPreferredCornerRadius$react_native_screens_release", "()F", "setPreferredCornerRadius$react_native_screens_release", "(F)V", "nativeContainerBackgroundColor", "", "getNativeContainerBackgroundColor$react_native_screens_release", "()Ljava/lang/Integer;", "setNativeContainerBackgroundColor$react_native_screens_release", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "detents", "", "", "getDetents$react_native_screens_release", "()Ljava/util/List;", "setDetents$react_native_screens_release", "(Ljava/util/List;)V", "initialDetentIndex", "getInitialDetentIndex$react_native_screens_release", "()I", "setInitialDetentIndex$react_native_screens_release", "(I)V", "sheetContentView", "Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetContentView;", "dialogManager", "Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetDialogManager;", "mountReactSubviewAt", "", "child", "Landroid/view/View;", FirebaseAnalytics.Param.INDEX, "mountReactSubviewAt$react_native_screens_release", "unmountReactSubview", "unmountReactSubview$react_native_screens_release", "unmountReactSubviewAt", "unmountReactSubviewAt$react_native_screens_release", "unmountAllReactSubviews", "unmountAllReactSubviews$react_native_screens_release", "getReactSubviewCount", "getReactSubviewCount$react_native_screens_release", "getReactSubviewAt", "getReactSubviewAt$react_native_screens_release", ViewProps.POINTER_EVENTS, "Lcom/facebook/react/uimanager/PointerEvents;", "getPointerEvents", "()Lcom/facebook/react/uimanager/PointerEvents;", "onLayout", "changed", "l", "t", "r", "b", "onViewManagerAddEventEmitters", "onViewManagerAddEventEmitters$react_native_screens_release", "onAfterUpdateTransaction", "onAfterUpdateTransaction$react_native_screens_release", "updateStateIfNeeded", ViewProps.WIDTH, ViewProps.HEIGHT, "updateStateIfNeeded$react_native_screens_release", "flushPendingStateUpdates", "destroy", "destroy$react_native_screens_release", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class FormSheetHost extends ViewGroup implements ReactPointerEventsView {
    private List<Double> detents;
    private final FormSheetDialogManager dialogManager;
    public FormSheetHostEventEmitter eventEmitter;
    private int initialDetentIndex;
    private boolean isOpen;
    private Integer nativeContainerBackgroundColor;
    private final PointerEvents pointerEvents;
    private float preferredCornerRadius;
    private boolean prefersGrabberVisible;
    private final ThemedReactContext reactContext;
    private final ShadowStateProxy shadowStateProxy;
    private final FormSheetContentView sheetContentView;

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
    }

    public final ThemedReactContext getReactContext() {
        return this.reactContext;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FormSheetHost(ThemedReactContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        this.shadowStateProxy = new ShadowStateProxy(false, 1, null);
        this.preferredCornerRadius = -1.0f;
        this.detents = CollectionsKt.emptyList();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        FormSheetContentView formSheetContentView = new FormSheetContentView(context, new Function2() { // from class: com.swmansion.rnscreens.gamma.modals.formsheet.FormSheetHost$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return FormSheetHost.sheetContentView$lambda$0(this.f$0, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
            }
        });
        this.sheetContentView = formSheetContentView;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        FormSheetDialogManager formSheetDialogManager = new FormSheetDialogManager(context2, formSheetContentView);
        this.dialogManager = formSheetDialogManager;
        formSheetContentView.setContentSizeChangeDelegate$react_native_screens_release(formSheetDialogManager.getContentSizeChangeDelegate$react_native_screens_release());
        this.pointerEvents = PointerEvents.NONE;
    }

    public final StateWrapper getStateWrapper$react_native_screens_release() {
        return this.shadowStateProxy.getStateWrapper();
    }

    public final void setStateWrapper$react_native_screens_release(StateWrapper stateWrapper) {
        this.shadowStateProxy.setStateWrapper$react_native_screens_release(stateWrapper);
    }

    public final FormSheetHostEventEmitter getEventEmitter$react_native_screens_release() {
        FormSheetHostEventEmitter formSheetHostEventEmitter = this.eventEmitter;
        if (formSheetHostEventEmitter != null) {
            return formSheetHostEventEmitter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("eventEmitter");
        return null;
    }

    public final void setEventEmitter$react_native_screens_release(FormSheetHostEventEmitter formSheetHostEventEmitter) {
        Intrinsics.checkNotNullParameter(formSheetHostEventEmitter, "<set-?>");
        this.eventEmitter = formSheetHostEventEmitter;
    }

    /* JADX INFO: renamed from: isOpen$react_native_screens_release, reason: from getter */
    public final boolean getIsOpen() {
        return this.isOpen;
    }

    public final void setOpen$react_native_screens_release(boolean z) {
        this.isOpen = z;
    }

    /* JADX INFO: renamed from: getPrefersGrabberVisible$react_native_screens_release, reason: from getter */
    public final boolean getPrefersGrabberVisible() {
        return this.prefersGrabberVisible;
    }

    public final void setPrefersGrabberVisible$react_native_screens_release(boolean z) {
        this.prefersGrabberVisible = z;
    }

    /* JADX INFO: renamed from: getPreferredCornerRadius$react_native_screens_release, reason: from getter */
    public final float getPreferredCornerRadius() {
        return this.preferredCornerRadius;
    }

    public final void setPreferredCornerRadius$react_native_screens_release(float f) {
        this.preferredCornerRadius = f;
    }

    /* JADX INFO: renamed from: getNativeContainerBackgroundColor$react_native_screens_release, reason: from getter */
    public final Integer getNativeContainerBackgroundColor() {
        return this.nativeContainerBackgroundColor;
    }

    public final void setNativeContainerBackgroundColor$react_native_screens_release(Integer num) {
        this.nativeContainerBackgroundColor = num;
    }

    public final List<Double> getDetents$react_native_screens_release() {
        return this.detents;
    }

    public final void setDetents$react_native_screens_release(List<Double> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.detents = list;
    }

    /* JADX INFO: renamed from: getInitialDetentIndex$react_native_screens_release, reason: from getter */
    public final int getInitialDetentIndex() {
        return this.initialDetentIndex;
    }

    public final void setInitialDetentIndex$react_native_screens_release(int i) {
        this.initialDetentIndex = i;
    }

    static final Unit sheetContentView$lambda$0(FormSheetHost formSheetHost, int i, int i2) {
        formSheetHost.updateStateIfNeeded$react_native_screens_release(i, i2);
        return Unit.INSTANCE;
    }

    public final void mountReactSubviewAt$react_native_screens_release(View child, int index) {
        Intrinsics.checkNotNullParameter(child, "child");
        this.sheetContentView.addView(child, index);
    }

    public final void unmountReactSubview$react_native_screens_release(View child) {
        Intrinsics.checkNotNullParameter(child, "child");
        this.sheetContentView.removeView(child);
    }

    public final void unmountReactSubviewAt$react_native_screens_release(int index) {
        this.sheetContentView.removeViewAt(index);
    }

    public final void unmountAllReactSubviews$react_native_screens_release() {
        this.sheetContentView.removeAllViews();
    }

    public final int getReactSubviewCount$react_native_screens_release() {
        return this.sheetContentView.getChildCount();
    }

    public final View getReactSubviewAt$react_native_screens_release(int index) {
        return this.sheetContentView.getChildAt(index);
    }

    @Override // com.facebook.react.uimanager.ReactPointerEventsView
    public PointerEvents getPointerEvents() {
        return this.pointerEvents;
    }

    public final void onViewManagerAddEventEmitters$react_native_screens_release() {
        if (getId() == -1) {
            throw new IllegalStateException("[RNScreens] FormSheetHost must have its tag set when registering event emitters".toString());
        }
        setEventEmitter$react_native_screens_release(new FormSheetHostEventEmitter(this.reactContext, getId()));
        this.dialogManager.setEventEmitter$react_native_screens_release(getEventEmitter$react_native_screens_release());
    }

    public final void onAfterUpdateTransaction$react_native_screens_release() {
        this.dialogManager.applyConfig$react_native_screens_release(new FormSheetConfig(this.isOpen, this.detents, this.prefersGrabberVisible, this.initialDetentIndex, this.preferredCornerRadius, this.nativeContainerBackgroundColor));
    }

    public final void updateStateIfNeeded$react_native_screens_release(int width, int height) {
        ShadowStateProxy.updateStateIfNeeded$default(this.shadowStateProxy, getResources().getDisplayMetrics().density, Integer.valueOf(width), Integer.valueOf(height), null, null, 24, null);
        flushPendingStateUpdates();
    }

    private final void flushPendingStateUpdates() {
        getEventEmitter$react_native_screens_release().emitOnSyncFlushEvent();
    }

    public final void destroy$react_native_screens_release() {
        this.dialogManager.destroy$react_native_screens_release();
    }
}
