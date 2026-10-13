package io.github.centrifugal.centrifuge;

/* JADX INFO: loaded from: classes9.dex */
public class ConfigurationError extends Throwable {
    private final Throwable error;

    ConfigurationError(Throwable th) {
        super(th);
        this.error = th;
    }

    public Throwable getError() {
        return this.error;
    }
}
