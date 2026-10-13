package com.swmansion.rnscreens.gamma.modals.dimmingview;

import android.content.Context;
import android.util.Log;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DimmingViewManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 %2\u00020\u0001:\u0001%B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0000¢\u0006\u0002\b\u001dJ\r\u0010\u001e\u001a\u00020\u001aH\u0000¢\u0006\u0002\b\u001fJ\u0019\u0010 \u001a\u00020\u001a2\n\u0010!\u001a\u0006\u0012\u0002\b\u00030\"H\u0000¢\u0006\u0002\b#J\b\u0010$\u001a\u00020\u001aH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0080D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t8@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/swmansion/rnscreens/gamma/modals/dimmingview/DimmingViewManager;", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "dialog", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "<init>", "(Landroid/content/Context;Lcom/google/android/material/bottomsheet/BottomSheetDialog;)V", "maxAlpha", "", "getMaxAlpha$react_native_screens_release", "()F", "isTransitionAnimationRunning", "", "isTransitionAnimationRunning$react_native_screens_release", "()Z", "setTransitionAnimationRunning$react_native_screens_release", "(Z)V", "value", "dimmingViewAlpha", "getDimmingViewAlpha$react_native_screens_release", "setDimmingViewAlpha$react_native_screens_release", "(F)V", "dimmingView", "Lcom/swmansion/rnscreens/gamma/modals/dimmingview/DimmingView;", "setOnBackdropClickListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/view/View$OnClickListener;", "setOnBackdropClickListener$react_native_screens_release", "onDialogShow", "onDialogShow$react_native_screens_release", "attachToBehavior", "behavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "attachToBehavior$react_native_screens_release", "attachDimmingViewOverNativeTouchOutside", "Companion", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DimmingViewManager {
    private static final float MAX_ALPHA = 0.3f;
    public static final String TAG = "DimmingViewManager";
    private final BottomSheetDialog dialog;
    private final DimmingView dimmingView;
    private boolean isTransitionAnimationRunning;
    private final float maxAlpha;

    public DimmingViewManager(Context context, BottomSheetDialog dialog) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        this.dialog = dialog;
        this.maxAlpha = MAX_ALPHA;
        DimmingView dimmingView = new DimmingView(context, 0.0f);
        dimmingView.setLayoutParams(new CoordinatorLayout.LayoutParams(-1, -1));
        this.dimmingView = dimmingView;
    }

    /* JADX INFO: renamed from: getMaxAlpha$react_native_screens_release, reason: from getter */
    public final float getMaxAlpha() {
        return this.maxAlpha;
    }

    /* JADX INFO: renamed from: isTransitionAnimationRunning$react_native_screens_release, reason: from getter */
    public final boolean getIsTransitionAnimationRunning() {
        return this.isTransitionAnimationRunning;
    }

    public final void setTransitionAnimationRunning$react_native_screens_release(boolean z) {
        this.isTransitionAnimationRunning = z;
    }

    public final float getDimmingViewAlpha$react_native_screens_release() {
        return this.dimmingView.getAlpha();
    }

    public final void setDimmingViewAlpha$react_native_screens_release(float f) {
        this.dimmingView.setAlpha(f);
    }

    public final void setOnBackdropClickListener$react_native_screens_release(View.OnClickListener listener) {
        this.dimmingView.setOnClickListener(listener);
    }

    public final void onDialogShow$react_native_screens_release() {
        attachDimmingViewOverNativeTouchOutside();
    }

    public final void attachToBehavior$react_native_screens_release(BottomSheetBehavior<?> behavior) {
        Intrinsics.checkNotNullParameter(behavior, "behavior");
        behavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() { // from class: com.swmansion.rnscreens.gamma.modals.dimmingview.DimmingViewManager$attachToBehavior$1
            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onStateChanged(View bottomSheet, int newState) {
                Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onSlide(View bottomSheet, float slideOffset) {
                Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
                if (this.this$0.getIsTransitionAnimationRunning()) {
                    return;
                }
                this.this$0.dimmingView.setAlpha((slideOffset < 0.0f ? 1.0f + slideOffset : 1.0f) * this.this$0.getMaxAlpha());
            }
        });
    }

    private final void attachDimmingViewOverNativeTouchOutside() {
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.dialog.findViewById(R.id.coordinator);
        View viewFindViewById = this.dialog.findViewById(R.id.design_bottom_sheet);
        if (coordinatorLayout == null || this.dimmingView.getParent() != null || viewFindViewById == null) {
            return;
        }
        int iIndexOfChild = coordinatorLayout.indexOfChild(viewFindViewById);
        if (iIndexOfChild >= 0) {
            coordinatorLayout.addView(this.dimmingView, iIndexOfChild);
        } else {
            Log.e(TAG, "[RNScreens] BottomSheetView not found! Falling back to bottom index.");
            coordinatorLayout.addView(this.dimmingView, 0);
        }
    }
}
