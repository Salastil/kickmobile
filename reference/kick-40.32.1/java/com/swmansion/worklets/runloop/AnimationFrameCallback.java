package com.swmansion.worklets.runloop;

import com.facebook.jni.HybridData;
import kotlin.Metadata;

/* JADX INFO: compiled from: AnimationFrameCallback.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0086 R\u0010\u0010\u0002\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/swmansion/worklets/runloop/AnimationFrameCallback;", "", "mHybridData", "Lcom/facebook/jni/HybridData;", "<init>", "(Lcom/facebook/jni/HybridData;)V", "onAnimationFrame", "", "timestampMs", "", "react-native-worklets_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AnimationFrameCallback {
    private final HybridData mHybridData;

    public final native void onAnimationFrame(double timestampMs);

    private AnimationFrameCallback(HybridData hybridData) {
        this.mHybridData = hybridData;
    }
}
