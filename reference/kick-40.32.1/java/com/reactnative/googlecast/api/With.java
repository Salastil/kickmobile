package com.reactnative.googlecast.api;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactContext;
import com.google.android.gms.common.api.PendingResult;

/* JADX INFO: loaded from: classes8.dex */
abstract class With<X> {

    protected interface WithX<X> {
        void execute(X x);
    }

    protected interface WithXPromisify<X> {
        PendingResult execute(X x);
    }

    protected abstract ReactContext getReactApplicationContext();

    protected abstract X getX();

    With() {
    }

    protected void withX(final WithX<X> withX) throws IllegalStateException {
        withX(new WithXPromisify<X>() { // from class: com.reactnative.googlecast.api.With.1
            @Override // com.reactnative.googlecast.api.With.WithXPromisify
            public PendingResult execute(X x) {
                withX.execute(x);
                return null;
            }
        }, (Promise) null);
    }

    protected void withX(final WithX<X> withX, Promise promise) {
        withX(new WithXPromisify<X>() { // from class: com.reactnative.googlecast.api.With.2
            @Override // com.reactnative.googlecast.api.With.WithXPromisify
            public PendingResult execute(X x) {
                withX.execute(x);
                return null;
            }
        }, promise);
    }

    protected void withX(final WithXPromisify<X> withXPromisify, final Promise promise) {
        getReactApplicationContext().runOnUiQueueThread(new Runnable() { // from class: com.reactnative.googlecast.api.With.3
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Object x = With.this.getX();
                    if (x == null) {
                        Promise promise2 = promise;
                        if (promise2 != null) {
                            promise2.reject(new IllegalStateException("No session"));
                            return;
                        }
                        return;
                    }
                    PendingResult pendingResultExecute = withXPromisify.execute(x);
                    Promise promise3 = promise;
                    if (pendingResultExecute != null) {
                        RNGCPendingResult.promisifyResult(pendingResultExecute, promise3);
                    } else if (promise3 != null) {
                        promise3.resolve(null);
                    }
                } catch (Exception e) {
                    Promise promise4 = promise;
                    if (promise4 != null) {
                        promise4.reject(e);
                    }
                }
            }
        });
    }
}
