package io.datazoom.sdk.mediatailor;

import android.view.View;
import com.amazon.mediatailorsdk.AdData;
import com.amazon.mediatailorsdk.AdObserver;
import com.amazon.mediatailorsdk.AdTrackingEvent;
import com.amazon.mediatailorsdk.ConstantsKt;
import com.amazon.mediatailorsdk.PlaybackEvent;
import com.amazon.mediatailorsdk.Session;
import io.datazoom.sdk.DzAdapter;
import io.datazoom.sdk.ad.DzAd;
import io.datazoom.sdk.ad.DzAdEvent;
import io.datazoom.sdk.ad.DzAdEventType;
import io.datazoom.sdk.ad.DzAdSessionMetadata;
import io.datazoom.sdk.logs.Logger_androidKt;
import io.datazoom.sdk.openmeasurement.OMManager;
import io.datazoom.sdk.openmeasurement.OmEvent;
import io.datazoom.sdk.openmeasurement.OmVendor;
import io.datazoom.sdk.utils.AdapterCallbackListener;
import io.datazoom.sdk.utils.DzPlaybackEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MediaTailor.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000i\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0003\u001a\"\u0010\u0007\u001a\u00020\b*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f\u001a\n\u0010\u0010\u001a\u00020\b*\u00020\t\u001a\n\u0010\u0011\u001a\u00020\b*\u00020\t\u001a\n\u0010\u0012\u001a\u00020\b*\u00020\t\u001a\u0014\u0010\u0013\u001a\u00020\u0014*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002\u001a \u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0017H\u0002\u001a\f\u0010\u001c\u001a\u00020\u001d*\u00020\u001eH\u0002\u001a\f\u0010\u001f\u001a\u00020 *\u00020!H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0018\u0010\"\u001a\u00020\u0017*\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$\"\u0015\u0010%\u001a\u00020&*\u00020\t8F¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006)"}, d2 = {"vendor", "Lio/datazoom/sdk/openmeasurement/OmVendor;", "mtSdk", "io/datazoom/sdk/mediatailor/MediaTailorKt$mtSdk$1", "Lio/datazoom/sdk/mediatailor/MediaTailorKt$mtSdk$1;", "adObserver", "Lcom/amazon/mediatailorsdk/AdObserver;", "setupAdSession", "", "Lio/datazoom/sdk/DzAdapter;", "session", "Lcom/amazon/mediatailorsdk/Session;", "adView", "Landroid/view/View;", "contentUrl", "", "trackAdSkip", "trackAdClick", "removeSession", "toDzAd", "Lio/datazoom/sdk/ad/DzAd;", "Lcom/amazon/mediatailorsdk/AdData;", "playHead", "", "adPosition", "Lio/datazoom/sdk/ad/DzAd$Position;", "availStart", "duration", "toDzEventType", "Lio/datazoom/sdk/ad/DzAdEventType;", "Lcom/amazon/mediatailorsdk/AdTrackingEvent;", "toAdEvents", "Lcom/amazon/mediatailorsdk/PlaybackEvent;", "Lio/datazoom/sdk/utils/DzPlaybackEvent;", "playHeadSeconds", "getPlayHeadSeconds", "(Lio/datazoom/sdk/DzAdapter;)J", "partnerInfo", "Lio/datazoom/sdk/mediatailor/PartnerInfo;", "getPartnerInfo", "(Lio/datazoom/sdk/DzAdapter;)Lio/datazoom/sdk/mediatailor/PartnerInfo;", "mediatailor_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class MediaTailorKt {
    private static AdObserver adObserver;
    private static final OmVendor vendor = new OmVendor("amazon2", ConstantsKt.DEFAULT_OMID_PARTNER_VERSION);
    private static final MediaTailorKt$mtSdk$1 mtSdk = new AdapterCallbackListener() { // from class: io.datazoom.sdk.mediatailor.MediaTailorKt$mtSdk$1
        @Override // io.datazoom.sdk.utils.AdapterCallbackListener
        public void onPlaybackUpdate(long playHeadMs, Double livePlayHeadMs) {
            Logger_androidKt.getLogger().v("MediaTailor Playhead Update: " + playHeadMs + " ms");
            MediaTailorHelper.INSTANCE.updateProgress((double) playHeadMs, livePlayHeadMs);
        }

        @Override // io.datazoom.sdk.utils.AdapterCallbackListener
        public void onAdPlaybackEvents(DzPlaybackEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            Logger_androidKt.getLogger().v("MediaTailor Playback Event: " + event);
            MediaTailorHelper.INSTANCE.sendAdPlaybackEvents(MediaTailorKt.toAdEvents(event));
        }

        @Override // io.datazoom.sdk.utils.AdapterCallbackListener
        public void onAdInitialise(DzAdSessionMetadata adSessionMetadata) {
            Intrinsics.checkNotNullParameter(adSessionMetadata, "adSessionMetadata");
            Logger_androidKt.getLogger().v("MediaTailor Ad Initialisation: " + adSessionMetadata.getAdId());
            MediaTailorHelper.INSTANCE.sendAdSession(adSessionMetadata);
        }
    };

    /* JADX INFO: compiled from: MediaTailor.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[AdTrackingEvent.values().length];
            try {
                iArr[AdTrackingEvent.LOADED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AdTrackingEvent.CLICK_THROUGH.ordinal()] = 2;
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
                iArr[AdTrackingEvent.SKIP.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[AdTrackingEvent.PAUSE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[AdTrackingEvent.RESUME.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[AdTrackingEvent.IMPRESSION.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[AdTrackingEvent.MUTE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[AdTrackingEvent.UNMUTE.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[AdTrackingEvent.FULLSCREEN.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[AdTrackingEvent.EXIT_FULLSCREEN.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[DzPlaybackEvent.values().length];
            try {
                iArr2[DzPlaybackEvent.PLAYING.ordinal()] = 1;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr2[DzPlaybackEvent.RESUME.ordinal()] = 2;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr2[DzPlaybackEvent.PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr2[DzPlaybackEvent.END.ordinal()] = 4;
            } catch (NoSuchFieldError unused19) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final void setupAdSession(DzAdapter dzAdapter, Session session, View adView, String contentUrl) {
        Intrinsics.checkNotNullParameter(dzAdapter, "<this>");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(adView, "adView");
        Intrinsics.checkNotNullParameter(contentUrl, "contentUrl");
        MediaTailorHelper.INSTANCE.setMediaSession(session);
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(dzAdapter, adView, contentUrl);
        adObserver = anonymousClass1;
        session.addAdObserver(anonymousClass1);
        Logger_androidKt.getLogger().v("MediaTailor AdObserver added to session");
        dzAdapter.addPlaybackListener(mtSdk);
    }

    /* JADX INFO: renamed from: io.datazoom.sdk.mediatailor.MediaTailorKt$setupAdSession$1, reason: invalid class name */
    /* JADX INFO: compiled from: MediaTailor.kt */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J \u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u000f"}, d2 = {"io/datazoom/sdk/mediatailor/MediaTailorKt$setupAdSession$1", "Lcom/amazon/mediatailorsdk/AdObserver;", "onAdTrackingEvent", "", "adData", "Lcom/amazon/mediatailorsdk/AdData;", "adTrackingEvent", "Lcom/amazon/mediatailorsdk/AdTrackingEvent;", "toDatazoomEvent", "Lio/datazoom/sdk/ad/DzAdEvent;", "onAdProgress", "adElapsedTime", "", "playhead", "onAdEnd", "mediatailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass1 extends AdObserver {
        final /* synthetic */ View $adView;
        final /* synthetic */ String $contentUrl;
        final /* synthetic */ DzAdapter $this_setupAdSession;

        AnonymousClass1(DzAdapter dzAdapter, View view, String str) {
            this.$this_setupAdSession = dzAdapter;
            this.$adView = view;
            this.$contentUrl = str;
        }

        @Override // com.amazon.mediatailorsdk.AdObserver
        public void onAdTrackingEvent(AdData adData, AdTrackingEvent adTrackingEvent) {
            Intrinsics.checkNotNullParameter(adData, "adData");
            Intrinsics.checkNotNullParameter(adTrackingEvent, "adTrackingEvent");
            super.onAdTrackingEvent(adData, adTrackingEvent);
            Logger_androidKt.getLogger().v("MediaTailor Ad Tracking Event: " + adTrackingEvent.name() + " for Ad ID: " + adData.getAdId());
            this.$this_setupAdSession.onAdEvent(toDatazoomEvent(adTrackingEvent, adData));
        }

        private final DzAdEvent toDatazoomEvent(AdTrackingEvent adTrackingEvent, final AdData adData) {
            DzAd dzAd = MediaTailorKt.toDzAd(adData, MediaTailorKt.getPlayHeadSeconds(this.$this_setupAdSession));
            Logger_androidKt.getLogger().v("MediaTailor Ad Event: " + adTrackingEvent.name() + " for Ad ID: " + dzAd.getId());
            if (this.$this_setupAdSession.getOmEnabled() && adData.getPlayCount() == 1) {
                try {
                    OMManager oMManager = OMManager.INSTANCE;
                    OmEvent omEvent = OmExtensionKt.toOmEvent(adTrackingEvent, adData, dzAd.getPosition());
                    final View view = this.$adView;
                    final String str = this.$contentUrl;
                    oMManager.handleAdEvent(omEvent, new Function0() { // from class: io.datazoom.sdk.mediatailor.MediaTailorKt$setupAdSession$1$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return MediaTailorKt.AnonymousClass1.toDatazoomEvent$lambda$0(adData, view, str);
                        }
                    });
                } catch (Exception unused) {
                }
            }
            return new DzAdEvent(MediaTailorKt.toDzEventType(adTrackingEvent), dzAd);
        }

        static final Unit toDatazoomEvent$lambda$0(AdData adData, View view, String str) throws Exception {
            OmExtensionKt.initSession(OMManager.INSTANCE, adData, view, str, MediaTailorKt.vendor);
            return Unit.INSTANCE;
        }

        @Override // com.amazon.mediatailorsdk.AdObserver
        public void onAdProgress(AdData adData, double adElapsedTime, double playhead) {
            Intrinsics.checkNotNullParameter(adData, "adData");
            super.onAdProgress(adData, adElapsedTime, playhead);
            Logger_androidKt.getLogger().v("MediaTailor Ad Progress Event for Ad ID: " + adData.getAdId() + " at playhead: " + playhead + " s");
            this.$this_setupAdSession.onAdEvent(new DzAdEvent(DzAdEventType.AD_PROGRESS, MediaTailorKt.toDzAd(adData, MediaTailorKt.getPlayHeadSeconds(this.$this_setupAdSession))));
        }

        @Override // com.amazon.mediatailorsdk.AdObserver
        public void onAdEnd(AdData adData) {
            Intrinsics.checkNotNullParameter(adData, "adData");
            super.onAdEnd(adData);
            Logger_androidKt.getLogger().v("MediaTailor Ad End Event for Ad ID: " + adData.getAdId());
            OMManager.INSTANCE.onSessionEnd();
        }
    }

    public static final void trackAdSkip(DzAdapter dzAdapter) {
        Intrinsics.checkNotNullParameter(dzAdapter, "<this>");
        MediaTailorHelper.INSTANCE.onAdSkip();
    }

    public static final void trackAdClick(DzAdapter dzAdapter) {
        Intrinsics.checkNotNullParameter(dzAdapter, "<this>");
        MediaTailorHelper.INSTANCE.onAdClickThrough();
    }

    public static final void removeSession(DzAdapter dzAdapter) {
        Session mediaSession;
        Intrinsics.checkNotNullParameter(dzAdapter, "<this>");
        AdObserver adObserver2 = adObserver;
        if (adObserver2 != null && (mediaSession = MediaTailorHelper.INSTANCE.getMediaSession()) != null) {
            mediaSession.removeAdObserver(adObserver2);
        }
        adObserver = null;
        MediaTailorHelper.INSTANCE.removeMediaSession();
        dzAdapter.removePlaybackListener(mtSdk);
        Logger_androidKt.getLogger().v("MediaTailor session removed");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DzAd toDzAd(AdData adData, long j) {
        String adId = adData.getAdId();
        String str = adId == null ? "" : adId;
        long duration = ((long) adData.getDuration()) * 1000;
        String adTitle = adData.getAdTitle();
        String str2 = adTitle == null ? "" : adTitle;
        String adSystem = adData.getAdSystem();
        String str3 = adSystem == null ? "" : adSystem;
        String creativeId = adData.getCreativeId();
        String str4 = creativeId == null ? "" : creativeId;
        long skipOffset = (long) adData.getSkipOffset();
        List listEmptyList = CollectionsKt.emptyList();
        List listEmptyList2 = CollectionsKt.emptyList();
        List listEmptyList3 = CollectionsKt.emptyList();
        String videoClickThrough = adData.getVideoClickThrough();
        long start = (j - ((long) adData.getStart())) * 1000;
        Double availStart = adData.getAvailStart();
        long jDoubleValue = availStart != null ? (long) availStart.doubleValue() : 0L;
        Double availDuration = adData.getAvailDuration();
        return new DzAd(str, start, duration, str2, str3, str4, skipOffset, listEmptyList, listEmptyList2, listEmptyList3, videoClickThrough, adPosition(jDoubleValue, availDuration != null ? (long) availDuration.doubleValue() : 0L, j), adData.getAvailAdIndex() + 1, adData.getAvailAdCount(), null, 16384, null);
    }

    private static final DzAd.Position adPosition(long j, long j2, long j3) {
        if (j == 0) {
            return DzAd.Position.PreRoll.INSTANCE;
        }
        if (j + j2 == j3) {
            return DzAd.Position.PostRoll.INSTANCE;
        }
        return DzAd.Position.MidRoll.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DzAdEventType toDzEventType(AdTrackingEvent adTrackingEvent) {
        switch (WhenMappings.$EnumSwitchMapping$0[adTrackingEvent.ordinal()]) {
            case 1:
                return DzAdEventType.LOADED;
            case 2:
                return DzAdEventType.CLICKED;
            case 3:
                return DzAdEventType.STARTED;
            case 4:
                return DzAdEventType.FIRST_QUARTILE;
            case 5:
                return DzAdEventType.MIDPOINT;
            case 6:
                return DzAdEventType.THIRD_QUARTILE;
            case 7:
                return DzAdEventType.COMPLETED;
            case 8:
                return DzAdEventType.SKIPPED;
            case 9:
                return DzAdEventType.PAUSED;
            case 10:
                return DzAdEventType.RESUMED;
            case 11:
                return DzAdEventType.IMPRESSION;
            case 12:
                return DzAdEventType.MUTED;
            case 13:
                return DzAdEventType.UNMUTED;
            case 14:
                return DzAdEventType.FULLSCREEN;
            case 15:
                return DzAdEventType.EXIT_FULLSCREEN;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PlaybackEvent toAdEvents(DzPlaybackEvent dzPlaybackEvent) {
        int i = WhenMappings.$EnumSwitchMapping$1[dzPlaybackEvent.ordinal()];
        if (i == 1) {
            return PlaybackEvent.START;
        }
        if (i == 2) {
            return PlaybackEvent.RESUME;
        }
        if (i == 3) {
            return PlaybackEvent.PAUSE;
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        return PlaybackEvent.END;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long getPlayHeadSeconds(DzAdapter dzAdapter) {
        return (long) (dzAdapter.getPlayHead() / 1000.0d);
    }

    public static final PartnerInfo getPartnerInfo(DzAdapter dzAdapter) {
        Intrinsics.checkNotNullParameter(dzAdapter, "<this>");
        OmVendor omVendor = vendor;
        return new PartnerInfo(omVendor.getName(), omVendor.getVersion());
    }
}
