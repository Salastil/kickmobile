package io.github.centrifugal.centrifuge;

/* JADX INFO: loaded from: classes9.dex */
public class ErrorEvent {
    private final Throwable error;
    private final Integer httpResponseCode;

    ErrorEvent(Throwable th) {
        this(th, null);
    }

    ErrorEvent(Throwable th, Integer num) {
        this.error = th;
        this.httpResponseCode = num;
    }

    public Throwable getError() {
        return this.error;
    }

    public Integer getHttpResponseCode() {
        return this.httpResponseCode;
    }
}
