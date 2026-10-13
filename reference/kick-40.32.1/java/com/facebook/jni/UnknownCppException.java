package com.facebook.jni;

import com.datadog.android.rum.internal.utils.ViewUtilsKt;

/* JADX INFO: loaded from: classes6.dex */
public class UnknownCppException extends CppException {
    public UnknownCppException() {
        super(ViewUtilsKt.UNKNOWN_DESTINATION_URL);
    }

    public UnknownCppException(String str) {
        super(str);
    }
}
