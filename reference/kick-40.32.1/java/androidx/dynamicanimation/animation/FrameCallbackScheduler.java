package androidx.dynamicanimation.animation;

/* JADX INFO: loaded from: classes5.dex */
public interface FrameCallbackScheduler {
    boolean isCurrentThread();

    void postFrameCallback(Runnable runnable);
}
