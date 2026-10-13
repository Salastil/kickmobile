package io.datazoom.sdk;

import com.facebook.hermes.intl.Constants;
import kotlin.Metadata;

/* JADX INFO: compiled from: Platform.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001¨\u0006\u0002"}, d2 = {"getPlatform", "Lio/datazoom/sdk/Platform;", Constants.SENSITIVITY_BASE}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class PlatformKt {
    public static final Platform getPlatform() {
        return new Platform(GeneratedSdkVersionKt.BASE_SDK_VERSION);
    }
}
