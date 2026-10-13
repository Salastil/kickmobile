package com.swmansion.rnscreens.gamma.modals.formsheet;

import com.facebook.react.bridge.ReactContext;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.swmansion.rnscreens.gamma.common.event.BaseEventEmitter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FormSheetHostEventEmitter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u0006\u0010\u000b\u001a\u00020\nJ\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0006H\u0016¨\u0006\u0012"}, d2 = {"Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetHostEventEmitter;", "Lcom/swmansion/rnscreens/gamma/common/event/BaseEventEmitter;", "Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetDialogEventEmitter;", "reactContext", "Lcom/facebook/react/bridge/ReactContext;", "viewTag", "", "<init>", "(Lcom/facebook/react/bridge/ReactContext;I)V", "emitOnNativeDismissEvent", "", "emitOnSyncFlushEvent", "emitOnWillAppear", "emitOnDidAppear", "emitOnWillDisappear", "emitOnDidDisappear", "emitOnDetentChanged", FirebaseAnalytics.Param.INDEX, "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class FormSheetHostEventEmitter extends BaseEventEmitter implements FormSheetDialogEventEmitter {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FormSheetHostEventEmitter(ReactContext reactContext, int i) {
        super(reactContext, i);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
    }

    @Override // com.swmansion.rnscreens.gamma.modals.formsheet.FormSheetDialogEventEmitter
    public void emitOnNativeDismissEvent() {
        getReactEventDispatcher().dispatchEvent(new FormSheetNativeDismissEvent(getSurfaceId(), getViewTag()));
    }

    public final void emitOnSyncFlushEvent() {
        getReactEventDispatcher().dispatchEvent(new FormSheetSyncFlushEvent(getSurfaceId(), getViewTag()));
    }

    @Override // com.swmansion.rnscreens.gamma.common.event.ViewAppearanceEventEmitter
    public void emitOnWillAppear() {
        getReactEventDispatcher().dispatchEvent(new FormSheetWillAppearEvent(getSurfaceId(), getViewTag()));
    }

    @Override // com.swmansion.rnscreens.gamma.common.event.ViewAppearanceEventEmitter
    public void emitOnDidAppear() {
        getReactEventDispatcher().dispatchEvent(new FormSheetDidAppearEvent(getSurfaceId(), getViewTag()));
    }

    @Override // com.swmansion.rnscreens.gamma.common.event.ViewAppearanceEventEmitter
    public void emitOnWillDisappear() {
        getReactEventDispatcher().dispatchEvent(new FormSheetWillDisappearEvent(getSurfaceId(), getViewTag()));
    }

    @Override // com.swmansion.rnscreens.gamma.common.event.ViewAppearanceEventEmitter
    public void emitOnDidDisappear() {
        getReactEventDispatcher().dispatchEvent(new FormSheetDidDisappearEvent(getSurfaceId(), getViewTag()));
    }

    @Override // com.swmansion.rnscreens.gamma.modals.formsheet.FormSheetDialogEventEmitter
    public void emitOnDetentChanged(int index) {
        getReactEventDispatcher().dispatchEvent(new FormSheetDetentChangedEvent(getSurfaceId(), getViewTag(), index));
    }
}
