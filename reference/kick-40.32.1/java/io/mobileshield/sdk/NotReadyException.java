package io.mobileshield.sdk;

import java.io.IOException;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/mobileshield/sdk/NotReadyException;", "Ljava/io/IOException;", "()V", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class NotReadyException extends IOException {
    public NotReadyException() {
        super("Token not available");
    }
}
