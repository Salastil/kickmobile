package com.swmansion.rnscreens.gamma.modals.formsheet;

import android.content.DialogInterface;
import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.swmansion.rnscreens.gamma.modals.dimmingview.DimmingViewManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FormSheetNativeDismissCoordinator.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\bH\u0000¢\u0006\u0002\b\fJ\r\u0010\r\u001a\u00020\bH\u0000¢\u0006\u0002\b\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetNativeDismissCoordinator;", "", "dialog", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "dimmingManager", "Lcom/swmansion/rnscreens/gamma/modals/dimmingview/DimmingViewManager;", FormSheetNativeDismissEvent.EVENT_REGISTRATION_NAME, "Lkotlin/Function0;", "", "<init>", "(Lcom/google/android/material/bottomsheet/BottomSheetDialog;Lcom/swmansion/rnscreens/gamma/modals/dimmingview/DimmingViewManager;Lkotlin/jvm/functions/Function0;)V", "setup", "setup$react_native_screens_release", "destroy", "destroy$react_native_screens_release", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class FormSheetNativeDismissCoordinator {
    private final BottomSheetDialog dialog;
    private final DimmingViewManager dimmingManager;
    private final Function0<Unit> onNativeDismiss;

    static final void destroy$lambda$0(View view) {
    }

    public FormSheetNativeDismissCoordinator(BottomSheetDialog dialog, DimmingViewManager dimmingManager, Function0<Unit> onNativeDismiss) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        Intrinsics.checkNotNullParameter(dimmingManager, "dimmingManager");
        Intrinsics.checkNotNullParameter(onNativeDismiss, "onNativeDismiss");
        this.dialog = dialog;
        this.dimmingManager = dimmingManager;
        this.onNativeDismiss = onNativeDismiss;
    }

    public final void setup$react_native_screens_release() {
        this.dialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.swmansion.rnscreens.gamma.modals.formsheet.FormSheetNativeDismissCoordinator$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                this.f$0.onNativeDismiss.invoke();
            }
        });
        this.dimmingManager.setOnBackdropClickListener$react_native_screens_release(new View.OnClickListener() { // from class: com.swmansion.rnscreens.gamma.modals.formsheet.FormSheetNativeDismissCoordinator$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.onNativeDismiss.invoke();
            }
        });
    }

    public final void destroy$react_native_screens_release() {
        this.dimmingManager.setOnBackdropClickListener$react_native_screens_release(new View.OnClickListener() { // from class: com.swmansion.rnscreens.gamma.modals.formsheet.FormSheetNativeDismissCoordinator$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FormSheetNativeDismissCoordinator.destroy$lambda$0(view);
            }
        });
        this.dialog.setOnCancelListener(null);
    }
}
