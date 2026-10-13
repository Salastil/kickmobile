package com.fingerprintjs.android.fpjs_pro;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro/ResponseCannotBeParsed;", "Lcom/fingerprintjs/android/fpjs_pro/Error;", "", "requestId", "errorDescription", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ResponseCannotBeParsed extends Error {
    public /* synthetic */ ResponseCannotBeParsed(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? "Response cannot be parsed" : str2);
    }

    public ResponseCannotBeParsed(String str, String str2) {
        super(str, str2, null);
    }
}
