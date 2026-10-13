package com.reactnativegooglesignin;

import com.google.android.gms.auth.api.signin.GoogleSignInStatusCodes;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: compiled from: ErrorDto.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001d\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/reactnativegooglesignin/ErrorDto;", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errCodeFallback", "", "<init>", "(Ljava/lang/Exception;Ljava/lang/String;)V", "code", "getCode", "()Ljava/lang/String;", "setCode", "(Ljava/lang/String;)V", "message", "getMessage", "setMessage", "react-native-google-signin_google-signin_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ErrorDto {
    private String code;
    private String message;

    public ErrorDto(Exception e, String str) {
        String statusCodeString;
        Intrinsics.checkNotNullParameter(e, "e");
        String localizedMessage = e.getLocalizedMessage();
        localizedMessage = localizedMessage == null ? e.getMessage() : localizedMessage;
        if (e instanceof ApiException) {
            ApiException apiException = (ApiException) e;
            int statusCode = apiException.getStatusCode();
            if (localizedMessage != null && localizedMessage.length() > 10 && localizedMessage != null) {
                statusCodeString = new Regex(statusCode + ": ").replaceFirst(localizedMessage, "");
            } else {
                statusCodeString = GoogleSignInStatusCodes.getStatusCodeString(statusCode);
                Intrinsics.checkNotNullExpressionValue(statusCodeString, "getStatusCodeString(...)");
            }
            this.code = String.valueOf((statusCode == 12501 || apiException.getStatus().isCanceled()) ? 12501 : statusCode);
            this.message = statusCodeString;
            return;
        }
        if (e instanceof UnsupportedApiCallException) {
            this.code = str;
            this.message = localizedMessage + " Make sure you have the latest version of Google Play Services installed.";
            return;
        }
        this.code = str;
        this.message = localizedMessage;
    }

    public final String getCode() {
        return this.code;
    }

    public final void setCode(String str) {
        this.code = str;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }
}
