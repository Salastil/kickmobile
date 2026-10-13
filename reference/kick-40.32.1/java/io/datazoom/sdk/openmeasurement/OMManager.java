package io.datazoom.sdk.openmeasurement;

import android.content.Context;
import android.util.Log;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.iab.omid.library.amazon2.Omid;
import com.iab.omid.library.amazon2.adsession.AdSession;
import com.iab.omid.library.amazon2.adsession.AdSessionConfiguration;
import com.iab.omid.library.amazon2.adsession.AdSessionContext;
import com.iab.omid.library.amazon2.adsession.CreativeType;
import com.iab.omid.library.amazon2.adsession.ImpressionType;
import com.iab.omid.library.amazon2.adsession.Owner;
import com.iab.omid.library.amazon2.adsession.Partner;
import com.iab.omid.library.amazon2.adsession.VerificationScriptResource;
import io.datazoom.sdk.openmeasurement.util.OmidJsLoader;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OMManager.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J\u0018\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n2\u0006\u0010\f\u001a\u00020\rH\u0002J>\u0010\u000e\u001a\n \u000b*\u0004\u0018\u00010\u000f0\u000f2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0012H\u0002J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fJ\u000e\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001dJ\u001c\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\"J\u0006\u0010#\u001a\u00020\u0007J\b\u0010$\u001a\u00020\u0007H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lio/datazoom/sdk/openmeasurement/OMManager;", "", "<init>", "()V", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "init", "", "applicationContext", "createPartner", "Lcom/iab/omid/library/amazon2/adsession/Partner;", "kotlin.jvm.PlatformType", "vendor", "Lio/datazoom/sdk/openmeasurement/OmVendor;", "createAdSessionContext", "Lcom/iab/omid/library/amazon2/adsession/AdSessionContext;", "partner", "serviceContent", "", "verificationScriptResources", "", "Lcom/iab/omid/library/amazon2/adsession/VerificationScriptResource;", "contentUrl", "customReferenceData", "createAdSession", "Lcom/iab/omid/library/amazon2/adsession/AdSession;", "adContext", "initialiseSession", "payload", "Lio/datazoom/sdk/openmeasurement/OmSessionPayload;", "handleAdEvent", "adTrackingEvent", "Lio/datazoom/sdk/openmeasurement/OmEvent;", "onInitialiseSession", "Lkotlin/Function0;", "onSessionEnd", "updateLastActivity", "openmeasurement_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class OMManager {
    public static final OMManager INSTANCE = new OMManager();
    private static Context context;

    private OMManager() {
    }

    public final void init(Context applicationContext) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Log.v("OMManager", "OM is ready to be used");
        Omid.activate(applicationContext);
        context = applicationContext;
        Omid.isActive();
        updateLastActivity();
    }

    private final Partner createPartner(OmVendor vendor) {
        return Partner.createPartner(vendor.getName(), vendor.getVersion());
    }

    private final AdSessionContext createAdSessionContext(Partner partner, String serviceContent, List<VerificationScriptResource> verificationScriptResources, String contentUrl, String customReferenceData) {
        return AdSessionContext.createNativeAdSessionContext(partner, serviceContent, verificationScriptResources, contentUrl, customReferenceData);
    }

    public final AdSession createAdSession(AdSessionContext adContext) {
        Intrinsics.checkNotNullParameter(adContext, "adContext");
        AdSession adSessionCreateAdSession = AdSession.createAdSession(AdSessionConfiguration.createAdSessionConfiguration(CreativeType.VIDEO, ImpressionType.VIEWABLE, Owner.NATIVE, Owner.NATIVE, false), adContext);
        Intrinsics.checkNotNullExpressionValue(adSessionCreateAdSession, "createAdSession(...)");
        return adSessionCreateAdSession;
    }

    public final void initialiseSession(OmSessionPayload payload) throws Exception {
        Intrinsics.checkNotNullParameter(payload, "payload");
        if (context == null) {
            Log.e("OmManager", "Context is missing, session not created");
            return;
        }
        List<VerificationScriptResource> verificationScriptResource = SessionPayloadKt.toVerificationScriptResource(payload.getAd().getAdVerifications());
        OmidJsLoader omidJsLoader = OmidJsLoader.INSTANCE;
        Context context2 = context;
        Intrinsics.checkNotNull(context2);
        String omidJs = omidJsLoader.getOmidJs(context2);
        Partner partnerCreatePartner = createPartner(payload.getVendor());
        Intrinsics.checkNotNullExpressionValue(partnerCreatePartner, "createPartner(...)");
        AdSessionContext adSessionContextCreateAdSessionContext = createAdSessionContext(partnerCreatePartner, omidJs, verificationScriptResource, payload.getContentUrl(), payload.getAd().getAdId());
        Intrinsics.checkNotNull(adSessionContextCreateAdSessionContext);
        OMSessionManager.INSTANCE.setSession(createAdSession(adSessionContextCreateAdSessionContext), payload.getAdView());
    }

    public final void handleAdEvent(OmEvent adTrackingEvent, Function0<Unit> onInitialiseSession) throws Exception {
        Intrinsics.checkNotNullParameter(adTrackingEvent, "adTrackingEvent");
        Intrinsics.checkNotNullParameter(onInitialiseSession, "onInitialiseSession");
        if (adTrackingEvent instanceof OmEvent.Loaded) {
            onInitialiseSession.invoke();
            OMSessionManager.INSTANCE.startSession();
            OMSessionManager.INSTANCE.fireLoaded(((OmEvent.Loaded) adTrackingEvent).getVastProperties());
            return;
        }
        if (adTrackingEvent instanceof OmEvent.Impression) {
            OMSessionManager.INSTANCE.fireImpression();
            return;
        }
        if (adTrackingEvent instanceof OmEvent.Complete) {
            OMSessionManager.INSTANCE.complete();
            return;
        }
        if (adTrackingEvent instanceof OmEvent.FirstQuartile) {
            OMSessionManager.INSTANCE.firstQuartile();
            return;
        }
        if (adTrackingEvent instanceof OmEvent.MidPoint) {
            OMSessionManager.INSTANCE.midpoint();
            return;
        }
        if (adTrackingEvent instanceof OmEvent.Start) {
            OmEvent.Start start = (OmEvent.Start) adTrackingEvent;
            OMSessionManager.INSTANCE.adStart(start.getDuration(), start.getVolume());
            return;
        }
        if (adTrackingEvent instanceof OmEvent.ThirdQuartile) {
            OMSessionManager.INSTANCE.thirdQuartile();
            return;
        }
        if (adTrackingEvent instanceof OmEvent.Pause) {
            OMSessionManager.INSTANCE.pause();
            updateLastActivity();
            return;
        }
        if (adTrackingEvent instanceof OmEvent.Resume) {
            OMSessionManager.INSTANCE.resume();
            updateLastActivity();
        } else if (adTrackingEvent instanceof OmEvent.ClickThrough) {
            OMSessionManager.INSTANCE.clickThrough();
            updateLastActivity();
        } else if (adTrackingEvent instanceof OmEvent.Skip) {
            OMSessionManager.INSTANCE.skipped();
            updateLastActivity();
        }
    }

    public final void onSessionEnd() {
        OMSessionManager.INSTANCE.finishSession();
    }

    private final void updateLastActivity() {
        Omid.updateLastActivity();
    }
}
