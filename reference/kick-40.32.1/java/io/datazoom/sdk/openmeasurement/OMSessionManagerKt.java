package io.datazoom.sdk.openmeasurement;

import com.iab.omid.library.amazon2.adsession.media.VastProperties;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OMSessionManager.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, d2 = {"toVastProperties", "Lcom/iab/omid/library/amazon2/adsession/media/VastProperties;", "Lio/datazoom/sdk/openmeasurement/OMVastProperties;", "openmeasurement_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class OMSessionManagerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final VastProperties toVastProperties(OMVastProperties oMVastProperties) {
        if (oMVastProperties.getSkipAble()) {
            VastProperties vastPropertiesCreateVastPropertiesForSkippableMedia = VastProperties.createVastPropertiesForSkippableMedia(oMVastProperties.getSkipOffset(), oMVastProperties.getAutoStart(), OmEventKt.toOMPosition(oMVastProperties.getPosition()));
            Intrinsics.checkNotNullExpressionValue(vastPropertiesCreateVastPropertiesForSkippableMedia, "createVastPropertiesForSkippableMedia(...)");
            return vastPropertiesCreateVastPropertiesForSkippableMedia;
        }
        VastProperties vastPropertiesCreateVastPropertiesForNonSkippableMedia = VastProperties.createVastPropertiesForNonSkippableMedia(oMVastProperties.getAutoStart(), OmEventKt.toOMPosition(oMVastProperties.getPosition()));
        Intrinsics.checkNotNullExpressionValue(vastPropertiesCreateVastPropertiesForNonSkippableMedia, "createVastPropertiesForNonSkippableMedia(...)");
        return vastPropertiesCreateVastPropertiesForNonSkippableMedia;
    }
}
