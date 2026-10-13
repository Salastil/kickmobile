package com.swmansion.rnscreens.gamma.modals.formsheet;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.swmansion.rnscreens.gamma.common.event.ViewAppearanceEventEmitter;
import kotlin.Metadata;

/* JADX INFO: compiled from: FormSheetDialogEventEmitter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetDialogEventEmitter;", "Lcom/swmansion/rnscreens/gamma/common/event/ViewAppearanceEventEmitter;", "emitOnNativeDismissEvent", "", "emitOnDetentChanged", FirebaseAnalytics.Param.INDEX, "", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface FormSheetDialogEventEmitter extends ViewAppearanceEventEmitter {
    void emitOnDetentChanged(int index);

    void emitOnNativeDismissEvent();
}
