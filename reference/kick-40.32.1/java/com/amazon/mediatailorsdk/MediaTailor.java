package com.amazon.mediatailorsdk;

import android.content.Context;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MediaTailor.android.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/amazon/mediatailorsdk/MediaTailor;", "Lcom/amazon/mediatailorsdk/MediaTailorCommon;", "<init>", "()V", "initPal", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "consentSettings", "Lcom/amazon/mediatailorsdk/PalConsentSettings;", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MediaTailor extends MediaTailorCommon {
    public static final MediaTailor INSTANCE = new MediaTailor();

    private MediaTailor() {
    }

    public final void initPal(Context context, PalConsentSettings consentSettings) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(consentSettings, "consentSettings");
        PAL_androidKt.palInit(context, consentSettings);
    }
}
