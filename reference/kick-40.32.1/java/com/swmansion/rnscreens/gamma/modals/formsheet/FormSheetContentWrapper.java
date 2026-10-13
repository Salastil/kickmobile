package com.swmansion.rnscreens.gamma.modals.formsheet;

import android.content.Context;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.views.view.ReactViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FormSheetContentWrapper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J0\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\nH\u0014R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetContentWrapper;", "Lcom/facebook/react/views/view/ReactViewGroup;", "Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetContentSizeChangeProvider;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "delegate", "Lcom/swmansion/rnscreens/gamma/modals/formsheet/FormSheetContentSizeChangeDelegate;", "lastReportedHeight", "", "setContentSizeChangeDelegate", "", "onLayout", "changed", "", "left", ViewProps.TOP, "right", ViewProps.BOTTOM, "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class FormSheetContentWrapper extends ReactViewGroup implements FormSheetContentSizeChangeProvider {
    private FormSheetContentSizeChangeDelegate delegate;
    private int lastReportedHeight;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FormSheetContentWrapper(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.lastReportedHeight = -1;
    }

    @Override // com.swmansion.rnscreens.gamma.modals.formsheet.FormSheetContentSizeChangeProvider
    public void setContentSizeChangeDelegate(FormSheetContentSizeChangeDelegate delegate) {
        this.delegate = delegate;
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        int i = bottom - top;
        if (i != this.lastReportedHeight) {
            this.lastReportedHeight = i;
            FormSheetContentSizeChangeDelegate formSheetContentSizeChangeDelegate = this.delegate;
            if (formSheetContentSizeChangeDelegate != null) {
                formSheetContentSizeChangeDelegate.onContentHeightChanged(i);
            }
        }
    }
}
