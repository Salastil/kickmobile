package com.swmansion.rnscreens.gamma.modals.formsheet;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.material.bottomsheet.BottomSheetDragHandleView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FormSheetContainer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u0010R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetContainer;", "Landroid/widget/LinearLayout;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "contentView", "Landroid/view/View;", "<init>", "(Landroid/content/Context;Landroid/view/View;)V", "getContentView$react_native_screens_release", "()Landroid/view/View;", "grabberView", "Lcom/google/android/material/bottomsheet/BottomSheetDragHandleView;", "setGrabberVisible", "", ViewProps.VISIBLE, "", "setGrabberVisible$react_native_screens_release", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class FormSheetContainer extends LinearLayout {
    private final View contentView;
    private final BottomSheetDragHandleView grabberView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FormSheetContainer(Context context, View contentView) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        this.contentView = contentView;
        BottomSheetDragHandleView bottomSheetDragHandleView = new BottomSheetDragHandleView(context);
        bottomSheetDragHandleView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        bottomSheetDragHandleView.setVisibility(8);
        this.grabberView = bottomSheetDragHandleView;
        setOrientation(1);
        contentView.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        addView(bottomSheetDragHandleView);
        addView(contentView);
    }

    /* JADX INFO: renamed from: getContentView$react_native_screens_release, reason: from getter */
    public final View getContentView() {
        return this.contentView;
    }

    public final void setGrabberVisible$react_native_screens_release(boolean visible) {
        this.grabberView.setVisibility(visible ? 0 : 8);
    }
}
