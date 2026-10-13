package com.swmansion.reanimated.view;

import android.content.Context;
import android.view.ViewGroup;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactPointerEventsView;

/* JADX INFO: loaded from: classes8.dex */
public class REASharedTransitionBoundaryView extends ViewGroup implements ReactPointerEventsView {
    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    public REASharedTransitionBoundaryView(Context context) {
        super(context);
        setClipChildren(false);
    }

    @Override // com.facebook.react.uimanager.ReactPointerEventsView
    public PointerEvents getPointerEvents() {
        return PointerEvents.BOX_NONE;
    }
}
