package com.amazonaws.ivs.player;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
class DeviceConfigPropertyHolder {
    private long mHandle;
    private final Object mLock = new Object();

    private native Boolean getBooleanValueImpl(long j, String str);

    private native Double getNumberValueImpl(long j, String str);

    private native String getStringValueImpl(long j, String str);

    private native void releaseImpl(long j);

    String getStringValue(String str) {
        String stringValueImpl;
        synchronized (this.mLock) {
            stringValueImpl = getStringValueImpl(this.mHandle, str);
        }
        return stringValueImpl;
    }

    Double getNumberValue(String str) {
        Double numberValueImpl;
        synchronized (this.mLock) {
            numberValueImpl = getNumberValueImpl(this.mHandle, str);
        }
        return numberValueImpl;
    }

    Boolean getBooleanValue(String str) {
        Boolean booleanValueImpl;
        synchronized (this.mLock) {
            booleanValueImpl = getBooleanValueImpl(this.mHandle, str);
        }
        return booleanValueImpl;
    }

    JSONObject getJsonObjectValue(String str) throws JSONException {
        String stringValue = getStringValue(str);
        if (stringValue == null) {
            return null;
        }
        return new JSONObject(stringValue);
    }

    void release() {
        synchronized (this.mLock) {
            long j = this.mHandle;
            if (j != 0) {
                releaseImpl(j);
                this.mHandle = 0L;
            }
        }
    }

    long getHandle() {
        return this.mHandle;
    }

    private DeviceConfigPropertyHolder(long j) {
        this.mHandle = j;
    }
}
