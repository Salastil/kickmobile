package com.swmansion.reanimated.keyboard;

import com.facebook.jni.HybridData;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;

/* JADX INFO: compiled from: KeyboardWorkletWrapper.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0013\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0086 R\u0010\u0010\u0006\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/swmansion/reanimated/keyboard/KeyboardWorkletWrapper;", "", "hybridData", "Lcom/facebook/jni/HybridData;", "<init>", "(Lcom/facebook/jni/HybridData;)V", "mHybridData", "invoke", "", "keyboardState", "", ViewProps.HEIGHT, "react-native-reanimated_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class KeyboardWorkletWrapper {
    private final HybridData mHybridData;

    public final native void invoke(int keyboardState, int height);

    private KeyboardWorkletWrapper(HybridData hybridData) {
        this.mHybridData = hybridData;
    }
}
