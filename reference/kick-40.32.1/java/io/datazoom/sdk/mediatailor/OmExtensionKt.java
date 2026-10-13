package io.datazoom.sdk.mediatailor;

import android.view.View;
import com.amazon.mediatailorsdk.AdData;
import com.amazon.mediatailorsdk.AdTrackingEvent;
import com.facebook.react.uimanager.ViewProps;
import io.datazoom.sdk.ad.DzAd;
import io.datazoom.sdk.logs.Logger_androidKt;
import io.datazoom.sdk.openmeasurement.OMManager;
import io.datazoom.sdk.openmeasurement.OMVastProperties;
import io.datazoom.sdk.openmeasurement.OmAdData;
import io.datazoom.sdk.openmeasurement.OmAdVerification;
import io.datazoom.sdk.openmeasurement.OmEvent;
import io.datazoom.sdk.openmeasurement.OmSessionPayload;
import io.datazoom.sdk.openmeasurement.OmVendor;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OmExtension.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a,\u0010\u0007\u001a\u00020\b*\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0000\u001a\u0014\u0010\u0010\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\rH\u0002\u001a\u0014\u0010\u0014\u001a\u00020\u0015*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0016"}, d2 = {"toOmEvent", "Lio/datazoom/sdk/openmeasurement/OmEvent;", "Lcom/amazon/mediatailorsdk/AdTrackingEvent;", "ad", "Lcom/amazon/mediatailorsdk/AdData;", ViewProps.POSITION, "Lio/datazoom/sdk/ad/DzAd$Position;", "initSession", "", "Lio/datazoom/sdk/openmeasurement/OMManager;", "adView", "Landroid/view/View;", "contentUrl", "", "vendor", "Lio/datazoom/sdk/openmeasurement/OmVendor;", "toVerificationScriptResource", "Lio/datazoom/sdk/openmeasurement/OmAdVerification;", "Lcom/amazon/mediatailorsdk/AdData$AdVerification;", "vendorName", "createVastProperties", "Lio/datazoom/sdk/openmeasurement/OMVastProperties;", "mediatailor_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class OmExtensionKt {

    /* JADX INFO: compiled from: OmExtension.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AdTrackingEvent.values().length];
            try {
                iArr[AdTrackingEvent.IMPRESSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AdTrackingEvent.LOADED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AdTrackingEvent.START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AdTrackingEvent.FIRST_QUARTILE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AdTrackingEvent.MID_POINT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AdTrackingEvent.THIRD_QUARTILE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[AdTrackingEvent.COMPLETE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[AdTrackingEvent.MUTE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[AdTrackingEvent.UNMUTE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[AdTrackingEvent.PAUSE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[AdTrackingEvent.RESUME.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[AdTrackingEvent.FULLSCREEN.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[AdTrackingEvent.EXIT_FULLSCREEN.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[AdTrackingEvent.CLICK_THROUGH.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[AdTrackingEvent.SKIP.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final OmEvent toOmEvent(AdTrackingEvent adTrackingEvent, AdData ad, DzAd.Position position) {
        Intrinsics.checkNotNullParameter(adTrackingEvent, "<this>");
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(position, "position");
        switch (WhenMappings.$EnumSwitchMapping$0[adTrackingEvent.ordinal()]) {
            case 1:
                return OmEvent.Impression.INSTANCE;
            case 2:
                return new OmEvent.Loaded(createVastProperties(ad, position));
            case 3:
                return new OmEvent.Start((float) ad.getDuration(), 1.0f);
            case 4:
                return OmEvent.FirstQuartile.INSTANCE;
            case 5:
                return OmEvent.MidPoint.INSTANCE;
            case 6:
                return OmEvent.ThirdQuartile.INSTANCE;
            case 7:
                return OmEvent.Complete.INSTANCE;
            case 8:
                return OmEvent.Mute.INSTANCE;
            case 9:
                return OmEvent.Unmute.INSTANCE;
            case 10:
                return OmEvent.Pause.INSTANCE;
            case 11:
                return OmEvent.Resume.INSTANCE;
            case 12:
                return OmEvent.Fullscreen.INSTANCE;
            case 13:
                return OmEvent.ExitFullscreen.INSTANCE;
            case 14:
                return OmEvent.ClickThrough.INSTANCE;
            case 15:
                return OmEvent.Skip.INSTANCE;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final void initSession(OMManager oMManager, AdData ad, View adView, String contentUrl, OmVendor vendor) throws Exception {
        Intrinsics.checkNotNullParameter(oMManager, "<this>");
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(adView, "adView");
        Intrinsics.checkNotNullParameter(contentUrl, "contentUrl");
        Intrinsics.checkNotNullParameter(vendor, "vendor");
        AdData.AdVerification[] adVerifications = ad.getAdVerifications();
        AdData.AdVerification adVerification = adVerifications != null ? (AdData.AdVerification) ArraysKt.firstOrNull(adVerifications) : null;
        Logger_androidKt.getLogger().v("Session not initialise because of ad verification is missing");
        if (adVerification == null) {
            return;
        }
        Logger_androidKt.getLogger().v("Ad verification called for vendor: " + adVerification.getVendor());
        String adId = ad.getAdId();
        if (adId == null) {
            adId = "";
        }
        oMManager.initialiseSession(new OmSessionPayload(new OmAdData(adId, toVerificationScriptResource(adVerification, vendor.getName())), adView, contentUrl, vendor));
    }

    private static final OmAdVerification toVerificationScriptResource(AdData.AdVerification adVerification, String str) {
        AdData.AdVerification.JavaScriptResource javaScriptResource;
        AdData.AdVerification.JavaScriptResource[] javaScriptResource2 = adVerification.getJavaScriptResource();
        return new OmAdVerification(str, (javaScriptResource2 == null || (javaScriptResource = (AdData.AdVerification.JavaScriptResource) ArraysKt.getOrNull(javaScriptResource2, 0)) == null) ? null : javaScriptResource.getUri(), adVerification.getVerificationParameters());
    }

    private static final OMVastProperties createVastProperties(AdData adData, DzAd.Position position) {
        return new OMVastProperties(adData.getSkipOffset() >= 0.0d, (float) adData.getSkipOffset(), false, position.getName());
    }
}
