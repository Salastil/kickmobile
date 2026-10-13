package io.datazoom.sdk.openmeasurement;

import com.iab.omid.library.amazon2.adsession.VerificationScriptResource;
import java.net.URL;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SessionPayload.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001*\u00020\u0004¨\u0006\u0005"}, d2 = {"toVerificationScriptResource", "", "Lcom/iab/omid/library/amazon2/adsession/VerificationScriptResource;", "kotlin.jvm.PlatformType", "Lio/datazoom/sdk/openmeasurement/OmAdVerification;", "openmeasurement_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class SessionPayloadKt {
    public static final List<VerificationScriptResource> toVerificationScriptResource(OmAdVerification omAdVerification) {
        Intrinsics.checkNotNullParameter(omAdVerification, "<this>");
        return CollectionsKt.listOf(VerificationScriptResource.createVerificationScriptResourceWithParameters(omAdVerification.getVendor(), new URL(omAdVerification.getJavaScriptResource()), omAdVerification.getVerificationParameters()));
    }
}
