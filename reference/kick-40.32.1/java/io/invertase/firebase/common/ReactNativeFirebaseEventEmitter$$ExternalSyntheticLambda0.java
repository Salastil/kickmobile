package io.invertase.firebase.common;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class ReactNativeFirebaseEventEmitter$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ ReactNativeFirebaseEventEmitter f$0;

    public /* synthetic */ ReactNativeFirebaseEventEmitter$$ExternalSyntheticLambda0(ReactNativeFirebaseEventEmitter reactNativeFirebaseEventEmitter) {
        this.f$0 = reactNativeFirebaseEventEmitter;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.sendQueuedEvents();
    }
}
