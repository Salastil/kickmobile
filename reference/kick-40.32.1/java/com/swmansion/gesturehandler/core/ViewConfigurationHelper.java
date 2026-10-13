package com.swmansion.gesturehandler.core;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;

/* JADX INFO: compiled from: ViewConfigurationHelper.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\bH&¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/swmansion/gesturehandler/core/ViewConfigurationHelper;", "", "getPointerEventsConfigForView", "Lcom/swmansion/gesturehandler/core/PointerEventsConfig;", "view", "Landroid/view/View;", "isViewClippingChildren", "", "Landroid/view/ViewGroup;", "react-native-gesture-handler_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface ViewConfigurationHelper {
    PointerEventsConfig getPointerEventsConfigForView(View view);

    boolean isViewClippingChildren(ViewGroup view);
}
