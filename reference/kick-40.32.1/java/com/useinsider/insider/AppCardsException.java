package com.useinsider.insider;

import java.io.IOException;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
public final class AppCardsException extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AppCardsExceptionCode f280a;

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    public enum AppCardsExceptionCode {
        SDK_NOT_INITIALIZED,
        INVALID_PARAMETER,
        NETWORK_ERROR,
        SERVER_ERROR,
        PARSE_ERROR,
        UNKNOWN
    }

    AppCardsException(AppCardsExceptionCode appCardsExceptionCode, String str) {
        super(str);
        this.f280a = appCardsExceptionCode;
    }

    static AppCardsException a(Exception exc) {
        if (exc instanceof IOException) {
            return new AppCardsException(AppCardsExceptionCode.NETWORK_ERROR, "A network error occurred.", exc);
        }
        if (!(exc instanceof i2)) {
            return new AppCardsException(AppCardsExceptionCode.UNKNOWN, "An unexpected error occurred.", exc);
        }
        i2 i2Var = (i2) exc;
        if (i2Var.a() != null) {
            int iB = i2Var.a().b();
            if (iB >= 500) {
                return new AppCardsException(AppCardsExceptionCode.SERVER_ERROR, "Server returned an error (HTTP " + iB + ").", exc);
            }
            if (iB == 404) {
                return new AppCardsException(AppCardsExceptionCode.SERVER_ERROR, "User not found (HTTP " + iB + ").", exc);
            }
            if (iB >= 400) {
                return new AppCardsException(AppCardsExceptionCode.SERVER_ERROR, "Request failed (HTTP " + iB + ").", exc);
            }
        }
        return i2Var.getCause() instanceof JSONException ? new AppCardsException(AppCardsExceptionCode.PARSE_ERROR, "Failed to parse server response.", exc) : new AppCardsException(AppCardsExceptionCode.SERVER_ERROR, "Server returned an unexpected response.", exc);
    }

    public AppCardsExceptionCode getCode() {
        return this.f280a;
    }

    AppCardsException(AppCardsExceptionCode appCardsExceptionCode, String str, Throwable th) {
        super(str, th);
        this.f280a = appCardsExceptionCode;
    }

    static AppCardsException a() {
        return new AppCardsException(AppCardsExceptionCode.SDK_NOT_INITIALIZED, "Insider SDK is not initialized, frozen, or not GDPR compliant.");
    }
}
