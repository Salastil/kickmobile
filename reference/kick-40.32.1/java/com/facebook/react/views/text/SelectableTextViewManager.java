package com.facebook.react.views.text;

import com.facebook.react.common.annotations.UnstableReactNativeAPI;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SelectableTextViewManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0015\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/facebook/react/views/text/SelectableTextViewManager;", "Lcom/facebook/react/views/text/ReactTextViewManager;", "reactTextViewManagerCallback", "Lcom/facebook/react/views/text/ReactTextViewManagerCallback;", "<init>", "(Lcom/facebook/react/views/text/ReactTextViewManagerCallback;)V", "getName", "", "Companion", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
@UnstableReactNativeAPI
public final class SelectableTextViewManager extends ReactTextViewManager {
    public static final String REACT_CLASS = "RCTSelectableText";

    /* JADX WARN: Multi-variable type inference failed */
    public SelectableTextViewManager() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ SelectableTextViewManager(ReactTextViewManagerCallback reactTextViewManagerCallback, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : reactTextViewManagerCallback);
    }

    public SelectableTextViewManager(ReactTextViewManagerCallback reactTextViewManagerCallback) {
        super(reactTextViewManagerCallback);
    }

    @Override // com.facebook.react.views.text.ReactTextViewManager, com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }
}
