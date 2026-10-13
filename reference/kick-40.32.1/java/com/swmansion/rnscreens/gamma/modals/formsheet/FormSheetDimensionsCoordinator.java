package com.swmansion.rnscreens.gamma.modals.formsheet;

import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.datadog.android.webview.internal.rum.WebViewRumEventMapper;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: FormSheetDimensionsCoordinator.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\u0015\u001a\u00020\u0016H\u0000¢\u0006\u0002\b\u0017J\b\u0010\u0018\u001a\u00020\u0016H\u0002J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0007H\u0002J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\rH\u0016J+\u0010\u001d\u001a\u00020\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u001f\u001a\u00020\r2\b\b\u0002\u0010 \u001a\u00020\u0013H\u0000¢\u0006\u0002\b!J\b\u0010\"\u001a\u00020\u0016H\u0002J\u0010\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020\r2\u0006\u0010$\u001a\u00020%H\u0002J\r\u0010'\u001a\u00020\u0016H\u0000¢\u0006\u0002\b(R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetDimensionsCoordinator;", "Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetContentSizeChangeDelegate;", "dialog", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", WebViewRumEventMapper.CONTAINER_KEY_NAME, "Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetContainer;", "bottomSheetView", "Landroid/widget/FrameLayout;", "behaviorController", "Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetBehaviorController;", "<init>", "(Lcom/google/android/material/bottomsheet/BottomSheetDialog;Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetContainer;Landroid/widget/FrameLayout;Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetBehaviorController;)V", "lastTopInset", "", "lastBottomInset", "currentDetents", "Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetDetents;", "currentInitialDetentIndex", "shouldApplyInitialDetent", "", "currentContentHeight", "setup", "", "setup$react_native_screens_release", "setupWindowInsetsListener", "disableMaterialInsetsAnimationCallback", "view", "onContentHeightChanged", "newHeight", "updateFormSheetDimensions", "detents", "initialDetentIndex", "applyInitialDetent", "updateFormSheetDimensions$react_native_screens_release", "updateNativeContainerHeight", "getTopInset", "insetsCompat", "Landroidx/core/view/WindowInsetsCompat;", "getBottomInset", "destroy", "destroy$react_native_screens_release", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class FormSheetDimensionsCoordinator implements FormSheetContentSizeChangeDelegate {
    private final FormSheetBehaviorController behaviorController;
    private final FrameLayout bottomSheetView;
    private final FormSheetContainer container;
    private int currentContentHeight;
    private FormSheetDetents currentDetents;
    private int currentInitialDetentIndex;
    private final BottomSheetDialog dialog;
    private int lastBottomInset;
    private int lastTopInset;
    private boolean shouldApplyInitialDetent;

    public FormSheetDimensionsCoordinator(BottomSheetDialog dialog, FormSheetContainer container, FrameLayout frameLayout, FormSheetBehaviorController formSheetBehaviorController) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        Intrinsics.checkNotNullParameter(container, "container");
        this.dialog = dialog;
        this.container = container;
        this.bottomSheetView = frameLayout;
        this.behaviorController = formSheetBehaviorController;
    }

    public final void setup$react_native_screens_release() {
        setupWindowInsetsListener();
        FrameLayout frameLayout = this.bottomSheetView;
        if (frameLayout != null) {
            disableMaterialInsetsAnimationCallback(frameLayout);
        }
    }

    private final void setupWindowInsetsListener() {
        ViewCompat.setOnApplyWindowInsetsListener(this.container, new OnApplyWindowInsetsListener() { // from class: com.swmansion.rnscreens.gamma.modals.formsheet.FormSheetDimensionsCoordinator$$ExternalSyntheticLambda0
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return FormSheetDimensionsCoordinator.setupWindowInsetsListener$lambda$0(this.f$0, view, windowInsetsCompat);
            }
        });
    }

    static final WindowInsetsCompat setupWindowInsetsListener$lambda$0(FormSheetDimensionsCoordinator formSheetDimensionsCoordinator, View view, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        Intrinsics.checkNotNullParameter(insets, "insets");
        formSheetDimensionsCoordinator.lastTopInset = formSheetDimensionsCoordinator.getTopInset(insets);
        formSheetDimensionsCoordinator.lastBottomInset = formSheetDimensionsCoordinator.getBottomInset(insets);
        formSheetDimensionsCoordinator.updateNativeContainerHeight();
        return insets;
    }

    private final void disableMaterialInsetsAnimationCallback(FrameLayout view) {
        FrameLayout frameLayout = view;
        if (frameLayout.isLaidOut() && !frameLayout.isLayoutRequested()) {
            ViewCompat.setWindowInsetsAnimationCallback(frameLayout, null);
        } else {
            frameLayout.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.swmansion.rnscreens.gamma.modals.formsheet.FormSheetDimensionsCoordinator$disableMaterialInsetsAnimationCallback$$inlined$doOnLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view2, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                    view2.removeOnLayoutChangeListener(this);
                    ViewCompat.setWindowInsetsAnimationCallback(view2, null);
                }
            });
        }
    }

    @Override // com.swmansion.rnscreens.gamma.modals.formsheet.FormSheetContentSizeChangeDelegate
    public void onContentHeightChanged(int newHeight) {
        if (this.currentContentHeight != newHeight) {
            this.currentContentHeight = newHeight;
            updateNativeContainerHeight();
        }
    }

    public static /* synthetic */ void updateFormSheetDimensions$react_native_screens_release$default(FormSheetDimensionsCoordinator formSheetDimensionsCoordinator, FormSheetDetents formSheetDetents, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        formSheetDimensionsCoordinator.updateFormSheetDimensions$react_native_screens_release(formSheetDetents, i, z);
    }

    public final void updateFormSheetDimensions$react_native_screens_release(FormSheetDetents detents, int initialDetentIndex, boolean applyInitialDetent) {
        this.currentDetents = detents;
        this.currentInitialDetentIndex = initialDetentIndex;
        this.shouldApplyInitialDetent = applyInitialDetent;
        updateNativeContainerHeight();
    }

    private final void updateNativeContainerHeight() {
        int iCoerceAtLeast;
        View decorView;
        Window window = this.dialog.getWindow();
        int height = (window == null || (decorView = window.getDecorView()) == null) ? 0 : decorView.getHeight();
        if (height <= 0) {
            return;
        }
        FormSheetDetents formSheetDetents = this.currentDetents;
        if (formSheetDetents != null) {
            FormSheetBehaviorController formSheetBehaviorController = this.behaviorController;
            if (formSheetBehaviorController != null) {
                formSheetBehaviorController.updateSheetBehavior$react_native_screens_release(formSheetDetents, height, this.currentContentHeight, this.lastBottomInset, this.currentInitialDetentIndex, this.shouldApplyInitialDetent);
            }
            this.shouldApplyInitialDetent = false;
        }
        FormSheetDetents formSheetDetents2 = this.currentDetents;
        int i = this.lastTopInset;
        if (formSheetDetents2 != null) {
            iCoerceAtLeast = formSheetDetents2.sheetContainerHeight$react_native_screens_release(height, i, this.lastBottomInset, this.currentContentHeight);
        } else {
            iCoerceAtLeast = RangesKt.coerceAtLeast((height - i) - this.lastBottomInset, 0);
        }
        FrameLayout.LayoutParams layoutParams = this.container.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(-1, iCoerceAtLeast);
        }
        if (layoutParams.width == -1 && layoutParams.height == iCoerceAtLeast) {
            return;
        }
        layoutParams.width = -1;
        layoutParams.height = iCoerceAtLeast;
        this.container.setLayoutParams(layoutParams);
    }

    private final int getTopInset(WindowInsetsCompat insetsCompat) {
        return insetsCompat.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout()).top;
    }

    private final int getBottomInset(WindowInsetsCompat insetsCompat) {
        return insetsCompat.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout()).bottom;
    }

    public final void destroy$react_native_screens_release() {
        ViewCompat.setOnApplyWindowInsetsListener(this.container, null);
    }
}
