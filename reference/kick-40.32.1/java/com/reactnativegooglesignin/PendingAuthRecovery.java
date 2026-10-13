package com.reactnativegooglesignin;

import com.facebook.react.bridge.WritableMap;

/* JADX INFO: loaded from: classes8.dex */
public class PendingAuthRecovery {
    private final WritableMap userProperties;

    public PendingAuthRecovery(WritableMap writableMap) {
        this.userProperties = writableMap;
    }

    public WritableMap getUserProperties() {
        return this.userProperties;
    }
}
