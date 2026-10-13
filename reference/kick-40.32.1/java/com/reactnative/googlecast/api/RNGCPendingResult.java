package com.reactnative.googlecast.api;

import com.facebook.react.bridge.Promise;
import com.google.android.gms.cast.CastStatusCodes;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes8.dex */
final class RNGCPendingResult {
    RNGCPendingResult() {
    }

    public static void promisifyResult(PendingResult pendingResult, final Promise promise) {
        pendingResult.setResultCallback(new ResultCallback() { // from class: com.reactnative.googlecast.api.RNGCPendingResult.1
            @Override // com.google.android.gms.common.api.ResultCallback
            public void onResult(Result result) {
                Status status = result.getStatus();
                if (status.isSuccess()) {
                    promise.resolve(null);
                } else {
                    promise.reject(new Exception(CastStatusCodes.getStatusCodeString(status.getStatusCode())));
                }
            }
        });
    }
}
