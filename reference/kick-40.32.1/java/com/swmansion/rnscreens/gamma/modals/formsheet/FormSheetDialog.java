package com.swmansion.rnscreens.gamma.modals.formsheet;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.core.view.WindowCompat;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FormSheetDialog.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\u0019\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0002\u0010\u000fJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0002\u0010\u000fJ\b\u0010\u0011\u001a\u00020\u0007H\u0002¨\u0006\u0012"}, d2 = {"Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onAttachedToWindow", "forceEdgeToEdge", "hideNativeDimmingView", "window", "Landroid/view/Window;", "(Landroid/view/Window;)Lkotlin/Unit;", "disableNativeWindowAnimation", "setupBottomSheetHeight", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class FormSheetDialog extends BottomSheetDialog {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FormSheetDialog(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideNativeDimmingView(getWindow());
        disableNativeWindowAnimation(getWindow());
        setupBottomSheetHeight();
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialog, android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        forceEdgeToEdge();
    }

    private final void forceEdgeToEdge() {
        Window window = getWindow();
        if (window == null) {
            return;
        }
        WindowCompat.setDecorFitsSystemWindows(window, false);
        View viewFindViewById = findViewById(R.id.container);
        if (viewFindViewById != null) {
            viewFindViewById.setFitsSystemWindows(false);
        }
        View viewFindViewById2 = findViewById(R.id.coordinator);
        if (viewFindViewById2 != null) {
            viewFindViewById2.setFitsSystemWindows(false);
        }
    }

    private final Unit hideNativeDimmingView(Window window) {
        if (window == null) {
            return null;
        }
        window.clearFlags(2);
        return Unit.INSTANCE;
    }

    private final Unit disableNativeWindowAnimation(Window window) {
        if (window == null) {
            return null;
        }
        window.setWindowAnimations(0);
        return Unit.INSTANCE;
    }

    private final void setupBottomSheetHeight() {
        ViewGroup.LayoutParams layoutParams;
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.design_bottom_sheet);
        if (frameLayout == null || (layoutParams = frameLayout.getLayoutParams()) == null) {
            return;
        }
        layoutParams.height = -1;
    }
}
