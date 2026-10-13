package com.swmansion.reanimated.view;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;

/* JADX INFO: loaded from: classes8.dex */
public class REASharedTransitionBoundaryManager extends ViewGroupManager<REASharedTransitionBoundaryView> {
    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "REASharedTransitionBoundary";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public REASharedTransitionBoundaryView createViewInstance(ThemedReactContext themedReactContext) {
        return new REASharedTransitionBoundaryView(themedReactContext);
    }
}
