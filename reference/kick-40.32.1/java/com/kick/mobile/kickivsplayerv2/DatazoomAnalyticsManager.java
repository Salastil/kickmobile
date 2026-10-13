package com.kick.mobile.kickivsplayerv2;

import android.view.View;
import com.amazon.mediatailorsdk.AdCountdown;
import com.amazon.mediatailorsdk.AdData;
import com.amazon.mediatailorsdk.AdObject;
import com.amazon.mediatailorsdk.MediaTailor;
import com.amazon.mediatailorsdk.Session;
import com.amazon.mediatailorsdk.SessionConfiguration;
import com.amazon.mediatailorsdk.SessionError;
import com.amazon.mediatailorsdk.SessionUiEvent;
import com.amazon.mediatailorsdk.SessionUiEventData;
import com.amazonaws.ivs.player.Player;
import io.datazoom.sdk.Config;
import io.datazoom.sdk.Datazoom;
import io.datazoom.sdk.DzAdapter;
import io.datazoom.sdk.ivs.ExtensionsKt;
import io.datazoom.sdk.mediatailor.MediaTailorKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: compiled from: DatazoomAnalyticsManager.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\u0018\u0000 >2\u00020\u0001:\u0002=>B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010 \u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&J\u000e\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0019J\u0010\u0010)\u001a\u00020\u00072\b\u0010*\u001a\u0004\u0018\u00010+J\u0006\u0010,\u001a\u00020\u0007J\u001a\u0010-\u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010\u00152\u0006\u0010%\u001a\u00020&H\u0002J\b\u0010.\u001a\u00020\u0007H\u0002J \u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u00192\u0006\u00102\u001a\u00020\u001dH\u0002J \u00103\u001a\u00020\u00192\u0006\u00104\u001a\u00020\u00132\u0006\u00105\u001a\u0002062\u0006\u00101\u001a\u00020\u0019H\u0002J\b\u00107\u001a\u00020\u0007H\u0002J\u0014\u00108\u001a\u0004\u0018\u00010\"2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\u0014\u00109\u001a\u0004\u0018\u00010\u00152\b\u0010!\u001a\u0004\u0018\u00010\u0015H\u0002J\u001e\u0010:\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0001\u0018\u00010;2\u0006\u0010<\u001a\u00020\u0013H\u0002R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001f¨\u0006?"}, d2 = {"Lcom/kick/mobile/kickivsplayerv2/DatazoomAnalyticsManager;", "", "<init>", "()V", "onMuxAdEvent", "Lkotlin/Function1;", "Lcom/kick/mobile/kickivsplayerv2/MuxAdEventData;", "", "getOnMuxAdEvent", "()Lkotlin/jvm/functions/Function1;", "setOnMuxAdEvent", "(Lkotlin/jvm/functions/Function1;)V", "adapter", "Lio/datazoom/sdk/DzAdapter;", "mediaTailorSession", "Lcom/amazon/mediatailorsdk/Session;", "contextConfiguration", "Lcom/kick/mobile/kickivsplayerv2/DatazoomAnalyticsManager$SDKConfiguration;", "activeMetadataJson", "", "activeMediaTailorConfiguration", "Lcom/kick/mobile/kickivsplayerv2/DatazoomMediaTailorConfig;", "pendingMediaTailorConfiguration", "activeMediaTailorAvailId", "activeMediaTailorAdIsLastInAvail", "", "completedMediaTailorAvailIds", "", "mediaTailorSessionGeneration", "", "fullscreenState", "Ljava/lang/Boolean;", "apply", "config", "Lcom/kick/mobile/kickivsplayerv2/DatazoomAnalyticsConfig;", "player", "Lcom/amazonaws/ivs/player/Player;", "playerView", "Landroid/view/View;", "setFullscreen", "isFullscreen", "sendEvent", "event", "Lcom/kick/mobile/kickivsplayerv2/DatazoomAnalyticsEventConfig;", "release", "configureMediaTailorIfNeeded", "releaseMediaTailorSession", "addMediaTailorUiEventListeners", "session", "isLivestream", "sessionGeneration", "shouldForwardMediaTailorEvent", "name", "data", "Lcom/amazon/mediatailorsdk/SessionUiEventData;", "resetMediaTailorAvailTracking", "normalizedConfig", "normalizedMediaTailorConfig", "parseMetadata", "", "metadataJson", "SDKConfiguration", "Companion", "kick-ivs-player-v2_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DatazoomAnalyticsManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static SDKConfiguration initializedConfiguration;
    private String activeMediaTailorAvailId;
    private DatazoomMediaTailorConfig activeMediaTailorConfiguration;
    private String activeMetadataJson;
    private DzAdapter adapter;
    private SDKConfiguration contextConfiguration;
    private Boolean fullscreenState;
    private Session mediaTailorSession;
    private int mediaTailorSessionGeneration;
    private Function1<? super MuxAdEventData, Unit> onMuxAdEvent;
    private DatazoomMediaTailorConfig pendingMediaTailorConfiguration;
    private boolean activeMediaTailorAdIsLastInAvail = true;
    private final Set<String> completedMediaTailorAvailIds = new LinkedHashSet();

    public final Function1<MuxAdEventData, Unit> getOnMuxAdEvent() {
        return this.onMuxAdEvent;
    }

    public final void setOnMuxAdEvent(Function1<? super MuxAdEventData, Unit> function1) {
        this.onMuxAdEvent = function1;
    }

    /* JADX INFO: compiled from: DatazoomAnalyticsManager.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/kick/mobile/kickivsplayerv2/DatazoomAnalyticsManager$SDKConfiguration;", "", "configurationId", "", "isProduction", "", "<init>", "(Ljava/lang/String;Z)V", "getConfigurationId", "()Ljava/lang/String;", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "kick-ivs-player-v2_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    private static final /* data */ class SDKConfiguration {
        private final String configurationId;
        private final boolean isProduction;

        public static /* synthetic */ SDKConfiguration copy$default(SDKConfiguration sDKConfiguration, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sDKConfiguration.configurationId;
            }
            if ((i & 2) != 0) {
                z = sDKConfiguration.isProduction;
            }
            return sDKConfiguration.copy(str, z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getConfigurationId() {
            return this.configurationId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsProduction() {
            return this.isProduction;
        }

        public final SDKConfiguration copy(String configurationId, boolean isProduction) {
            Intrinsics.checkNotNullParameter(configurationId, "configurationId");
            return new SDKConfiguration(configurationId, isProduction);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SDKConfiguration)) {
                return false;
            }
            SDKConfiguration sDKConfiguration = (SDKConfiguration) other;
            return Intrinsics.areEqual(this.configurationId, sDKConfiguration.configurationId) && this.isProduction == sDKConfiguration.isProduction;
        }

        public int hashCode() {
            return (this.configurationId.hashCode() * 31) + Boolean.hashCode(this.isProduction);
        }

        public String toString() {
            return "SDKConfiguration(configurationId=" + this.configurationId + ", isProduction=" + this.isProduction + ")";
        }

        public SDKConfiguration(String configurationId, boolean z) {
            Intrinsics.checkNotNullParameter(configurationId, "configurationId");
            this.configurationId = configurationId;
            this.isProduction = z;
        }

        public final String getConfigurationId() {
            return this.configurationId;
        }

        public final boolean isProduction() {
            return this.isProduction;
        }
    }

    public final void apply(DatazoomAnalyticsConfig config, Player player, View playerView) {
        Intrinsics.checkNotNullParameter(player, "player");
        Intrinsics.checkNotNullParameter(playerView, "playerView");
        DatazoomAnalyticsConfig datazoomAnalyticsConfigNormalizedConfig = normalizedConfig(config);
        if (datazoomAnalyticsConfigNormalizedConfig == null) {
            release();
            return;
        }
        Map<String, ? extends Object> metadata = parseMetadata(datazoomAnalyticsConfigNormalizedConfig.getMetadataJson());
        if (metadata == null) {
            release();
            return;
        }
        SDKConfiguration sDKConfiguration = new SDKConfiguration(datazoomAnalyticsConfigNormalizedConfig.getConfigurationId(), datazoomAnalyticsConfigNormalizedConfig.isProduction());
        SDKConfiguration sDKConfiguration2 = this.contextConfiguration;
        if (sDKConfiguration2 != null && !Intrinsics.areEqual(sDKConfiguration2, sDKConfiguration)) {
            release();
        }
        INSTANCE.initializeDatazoomIfNeeded(sDKConfiguration);
        if (this.adapter == null) {
            DzAdapter dzAdapterCreateContext$default = ExtensionsKt.createContext$default(Datazoom.INSTANCE, player, null, 2, null);
            this.adapter = dzAdapterCreateContext$default;
            if (dzAdapterCreateContext$default != null) {
                dzAdapterCreateContext$default.setPlayerVersion(BuildConfig.IVS_PLAYER_VERSION);
            }
            Boolean bool = this.fullscreenState;
            if (bool != null) {
                boolean zBooleanValue = bool.booleanValue();
                DzAdapter dzAdapter = this.adapter;
                if (dzAdapter != null) {
                    dzAdapter.sendFullScreenEvent(zBooleanValue);
                }
            }
            this.contextConfiguration = sDKConfiguration;
        }
        configureMediaTailorIfNeeded(datazoomAnalyticsConfigNormalizedConfig.getMediaTailor(), playerView);
        if (Intrinsics.areEqual(this.activeMetadataJson, datazoomAnalyticsConfigNormalizedConfig.getMetadataJson())) {
            return;
        }
        DzAdapter dzAdapter2 = this.adapter;
        if (dzAdapter2 != null) {
            dzAdapter2.setMetadata(metadata);
        }
        this.activeMetadataJson = datazoomAnalyticsConfigNormalizedConfig.getMetadataJson();
    }

    public final void setFullscreen(boolean isFullscreen) {
        if (Intrinsics.areEqual(this.fullscreenState, Boolean.valueOf(isFullscreen))) {
            return;
        }
        this.fullscreenState = Boolean.valueOf(isFullscreen);
        DzAdapter dzAdapter = this.adapter;
        if (dzAdapter != null) {
            dzAdapter.sendFullScreenEvent(isFullscreen);
        }
    }

    public final void sendEvent(DatazoomAnalyticsEventConfig event) {
        DzAdapter dzAdapter;
        String eventName = event != null ? event.getEventName() : null;
        if (Intrinsics.areEqual(eventName, "fullscreen")) {
            Boolean isFullscreen = event.getIsFullscreen();
            if (isFullscreen != null) {
                setFullscreen(isFullscreen.booleanValue());
                return;
            }
            return;
        }
        if (!Intrinsics.areEqual(eventName, "adClick") || (dzAdapter = this.adapter) == null) {
            return;
        }
        MediaTailorKt.trackAdClick(dzAdapter);
    }

    public final void release() {
        DzAdapter dzAdapter = this.adapter;
        if (dzAdapter == null && this.contextConfiguration == null && this.activeMetadataJson == null && this.mediaTailorSession == null && this.activeMediaTailorConfiguration == null && this.pendingMediaTailorConfiguration == null) {
            return;
        }
        releaseMediaTailorSession();
        if (dzAdapter != null) {
            Datazoom.INSTANCE.removeContext(dzAdapter);
        }
        this.adapter = null;
        this.contextConfiguration = null;
        this.activeMetadataJson = null;
    }

    private final void configureMediaTailorIfNeeded(final DatazoomMediaTailorConfig config, final View playerView) {
        final DzAdapter dzAdapter = this.adapter;
        if (dzAdapter == null) {
            return;
        }
        if (config == null) {
            releaseMediaTailorSession();
            return;
        }
        if (Intrinsics.areEqual(this.activeMediaTailorConfiguration, config) || Intrinsics.areEqual(this.pendingMediaTailorConfiguration, config)) {
            return;
        }
        releaseMediaTailorSession();
        this.pendingMediaTailorConfiguration = config;
        SessionConfiguration.Builder builder = new SessionConfiguration.Builder();
        String palNonce = config.getPalNonce();
        if (palNonce != null) {
            builder.palNonceString(palNonce);
        }
        String trackingUrl = config.getTrackingUrl();
        if (trackingUrl != null) {
            builder.trackingUrl(trackingUrl);
        }
        String userAgent = config.getUserAgent();
        if (userAgent != null) {
            builder.userAgent(userAgent);
        }
        MediaTailor.INSTANCE.createSession(builder.build(), new Function2() { // from class: com.kick.mobile.kickivsplayerv2.DatazoomAnalyticsManager$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return DatazoomAnalyticsManager.configureMediaTailorIfNeeded$lambda$3(this.f$0, config, dzAdapter, playerView, (Session) obj, (SessionError) obj2);
            }
        });
    }

    static final Unit configureMediaTailorIfNeeded$lambda$3(DatazoomAnalyticsManager datazoomAnalyticsManager, DatazoomMediaTailorConfig datazoomMediaTailorConfig, DzAdapter dzAdapter, View view, Session session, SessionError sessionError) {
        if (!Intrinsics.areEqual(datazoomAnalyticsManager.pendingMediaTailorConfiguration, datazoomMediaTailorConfig)) {
            return Unit.INSTANCE;
        }
        datazoomAnalyticsManager.pendingMediaTailorConfiguration = null;
        if (sessionError != null || session == null) {
            return Unit.INSTANCE;
        }
        datazoomAnalyticsManager.mediaTailorSession = session;
        datazoomAnalyticsManager.activeMediaTailorConfiguration = datazoomMediaTailorConfig;
        datazoomAnalyticsManager.mediaTailorSessionGeneration++;
        datazoomAnalyticsManager.addMediaTailorUiEventListeners(session, datazoomMediaTailorConfig.isLivestream(), datazoomAnalyticsManager.mediaTailorSessionGeneration);
        MediaTailorKt.setupAdSession(dzAdapter, session, view, datazoomMediaTailorConfig.getContentUrl());
        return Unit.INSTANCE;
    }

    private final void releaseMediaTailorSession() {
        this.mediaTailorSessionGeneration++;
        resetMediaTailorAvailTracking();
        if (this.mediaTailorSession == null && this.activeMediaTailorConfiguration == null && this.pendingMediaTailorConfiguration == null) {
            return;
        }
        DzAdapter dzAdapter = this.adapter;
        if (dzAdapter != null) {
            MediaTailorKt.removeSession(dzAdapter);
        }
        Session session = this.mediaTailorSession;
        if (session != null) {
            session.destroy();
        }
        this.mediaTailorSession = null;
        this.activeMediaTailorConfiguration = null;
        this.pendingMediaTailorConfiguration = null;
    }

    private final void addMediaTailorUiEventListeners(Session session, final boolean isLivestream, final int sessionGeneration) {
        resetMediaTailorAvailTracking();
        for (Pair pair : CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("adStart", SessionUiEvent.AD_START), TuplesKt.to("adEnd", SessionUiEvent.AD_END), TuplesKt.to("adProgress", SessionUiEvent.AD_PROGRESS), TuplesKt.to("adClick", SessionUiEvent.AD_CLICK), TuplesKt.to("adCanSkip", SessionUiEvent.AD_CAN_SKIP), TuplesKt.to("adIncoming", SessionUiEvent.AD_INCOMING), TuplesKt.to("nonlinearAdStart", SessionUiEvent.NONLINEAR_AD_START), TuplesKt.to("nonlinearAdEnd", SessionUiEvent.NONLINEAR_AD_END), TuplesKt.to("adTrackingInfoResponse", SessionUiEvent.AD_TRACKING_INFO_RESPONSE)})) {
            final String str = (String) pair.component1();
            final SessionUiEvent sessionUiEvent = (SessionUiEvent) pair.component2();
            session.addUiEventListener(sessionUiEvent, new Function2() { // from class: com.kick.mobile.kickivsplayerv2.DatazoomAnalyticsManager$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatazoomAnalyticsManager.addMediaTailorUiEventListeners$lambda$0$0(this.f$0, sessionGeneration, str, isLivestream, sessionUiEvent, (SessionUiEvent) obj, (SessionUiEventData) obj2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addMediaTailorUiEventListeners$lambda$0$0(DatazoomAnalyticsManager datazoomAnalyticsManager, int i, String str, boolean z, SessionUiEvent sessionUiEvent, SessionUiEvent sessionUiEvent2, SessionUiEventData data) {
        String adClickthroughUrl;
        String adClickthroughUrl2;
        Intrinsics.checkNotNullParameter(sessionUiEvent2, "<unused var>");
        Intrinsics.checkNotNullParameter(data, "data");
        if (datazoomAnalyticsManager.mediaTailorSessionGeneration == i && datazoomAnalyticsManager.shouldForwardMediaTailorEvent(str, data, z)) {
            AdObject adObject = data.getAdObject();
            AdData adData = adObject != null ? adObject.getAdData() : null;
            Function2<String, Map<String, ? extends Object>, Unit> sendEvent = KickIvsPlayerV2Manager.INSTANCE.getSendEvent();
            if (sendEvent != null) {
                Pair[] pairArr = new Pair[19];
                pairArr[0] = TuplesKt.to("eventName", str);
                pairArr[1] = TuplesKt.to("eventKey", sessionUiEvent.toString());
                if (adObject == null || (adClickthroughUrl2 = adObject.getAdClickthroughUrl()) == null) {
                    adClickthroughUrl2 = data.getAdClickthroughUrl();
                }
                pairArr[2] = TuplesKt.to("adClickthroughUrl", adClickthroughUrl2);
                pairArr[3] = TuplesKt.to("adElapsedTimeSeconds", data.getAdElapsedTime());
                AdCountdown adCountdown = data.getAdCountdown();
                pairArr[4] = TuplesKt.to("countdownToAdEndSeconds", adCountdown != null ? Double.valueOf(adCountdown.getToAdEnd()) : null);
                AdCountdown adCountdown2 = data.getAdCountdown();
                pairArr[5] = TuplesKt.to("countdownToAvailEndSeconds", adCountdown2 != null ? adCountdown2.getToAvailEnd() : null);
                pairArr[6] = TuplesKt.to("timeToNextAdSeconds", data.getTimeToNextAd());
                pairArr[7] = TuplesKt.to("availId", adData != null ? adData.getAvailId() : null);
                pairArr[8] = TuplesKt.to("adId", adData != null ? adData.getAdId() : null);
                pairArr[9] = TuplesKt.to("adTitle", adData != null ? adData.getAdTitle() : null);
                pairArr[10] = TuplesKt.to("adSystem", adData != null ? adData.getAdSystem() : null);
                pairArr[11] = TuplesKt.to("vastAdId", adData != null ? adData.getVastAdId() : null);
                pairArr[12] = TuplesKt.to("creativeId", adData != null ? adData.getCreativeId() : null);
                pairArr[13] = TuplesKt.to("adIndex", adData != null ? Integer.valueOf(adData.getAvailAdIndex() + 1) : null);
                pairArr[14] = TuplesKt.to("adCount", adData != null ? Integer.valueOf(adData.getAvailAdCount()) : null);
                pairArr[15] = TuplesKt.to("adDurationSeconds", adData != null ? Double.valueOf(adData.getDuration()) : null);
                pairArr[16] = TuplesKt.to("adStartSeconds", adData != null ? Double.valueOf(adData.getStart()) : null);
                pairArr[17] = TuplesKt.to("skipOffsetSeconds", adData != null ? Double.valueOf(adData.getSkipOffset()) : null);
                pairArr[18] = TuplesKt.to("videoClickThroughUrl", adData != null ? adData.getVideoClickThrough() : null);
                sendEvent.invoke("onAdEvent", MapsKt.mapOf(pairArr));
            }
            Function1<? super MuxAdEventData, Unit> function1 = datazoomAnalyticsManager.onMuxAdEvent;
            if (function1 != null) {
                String vastAdId = adData != null ? adData.getVastAdId() : null;
                String creativeId = adData != null ? adData.getCreativeId() : null;
                String availId = adData != null ? adData.getAvailId() : null;
                if (adObject == null || (adClickthroughUrl = adObject.getAdClickthroughUrl()) == null) {
                    adClickthroughUrl = data.getAdClickthroughUrl();
                }
                function1.invoke(new MuxAdEventData(str, vastAdId, creativeId, availId, adClickthroughUrl, adData != null ? Double.valueOf(adData.getDuration()) : null, data.getAdElapsedTime(), adData != null ? Integer.valueOf(adData.getAvailAdIndex() + 1) : null, adData != null ? Integer.valueOf(adData.getAvailAdCount()) : null, adData != null ? Double.valueOf(adData.getStart()) : null));
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    private final synchronized boolean shouldForwardMediaTailorEvent(String name, SessionUiEventData data, boolean isLivestream) {
        String string;
        AdData adData;
        String availId;
        AdObject adObject = data.getAdObject();
        if (adObject == null || (adData = adObject.getAdData()) == null || (availId = adData.getAvailId()) == null || (string = StringsKt.trim((CharSequence) availId).toString()) == null || string.length() <= 0) {
            string = null;
        }
        if (!isLivestream) {
            return true;
        }
        AdObject adObject2 = data.getAdObject();
        AdData adData2 = adObject2 != null ? adObject2.getAdData() : null;
        String str = string == null ? this.activeMediaTailorAvailId : string;
        if (str != null && this.completedMediaTailorAvailIds.contains(str)) {
            return false;
        }
        if (adData2 != null) {
            this.activeMediaTailorAvailId = string;
            this.activeMediaTailorAdIsLastInAvail = adData2.getAvailAdIndex() + 1 >= adData2.getAvailAdCount();
        }
        if (Intrinsics.areEqual(name, "adEnd") || Intrinsics.areEqual(name, "nonlinearAdEnd")) {
            if (this.activeMediaTailorAdIsLastInAvail && str != null) {
                this.completedMediaTailorAvailIds.add(str);
            }
            this.activeMediaTailorAvailId = null;
            this.activeMediaTailorAdIsLastInAvail = true;
        }
        return true;
    }

    private final synchronized void resetMediaTailorAvailTracking() {
        this.activeMediaTailorAvailId = null;
        this.activeMediaTailorAdIsLastInAvail = true;
        this.completedMediaTailorAvailIds.clear();
    }

    private final DatazoomAnalyticsConfig normalizedConfig(DatazoomAnalyticsConfig config) {
        if (config == null) {
            return null;
        }
        String string = StringsKt.trim((CharSequence) config.getConfigurationId()).toString();
        String string2 = StringsKt.trim((CharSequence) config.getMetadataJson()).toString();
        if (string.length() == 0 || string2.length() == 0) {
            return null;
        }
        return new DatazoomAnalyticsConfig(string, string2, config.isProduction(), normalizedMediaTailorConfig(config.getMediaTailor()));
    }

    private final DatazoomMediaTailorConfig normalizedMediaTailorConfig(DatazoomMediaTailorConfig config) {
        if (config == null) {
            return null;
        }
        String string = StringsKt.trim((CharSequence) config.getContentUrl()).toString();
        String palNonce = config.getPalNonce();
        String string2 = palNonce != null ? StringsKt.trim((CharSequence) palNonce).toString() : null;
        String trackingUrl = config.getTrackingUrl();
        String string3 = trackingUrl != null ? StringsKt.trim((CharSequence) trackingUrl).toString() : null;
        String userAgent = config.getUserAgent();
        String string4 = userAgent != null ? StringsKt.trim((CharSequence) userAgent).toString() : null;
        if (string.length() == 0) {
            return null;
        }
        return new DatazoomMediaTailorConfig(string, config.isLivestream(), (string2 == null || string2.length() <= 0) ? null : string2, (string3 == null || string3.length() <= 0) ? null : string3, (string4 == null || string4.length() <= 0) ? null : string4);
    }

    private final Map<String, Object> parseMetadata(String metadataJson) {
        try {
            JSONObject jSONObject = new JSONObject(metadataJson);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object objOpt = jSONObject.opt(next);
                if (objOpt != null && !Intrinsics.areEqual(objOpt, JSONObject.NULL)) {
                    linkedHashMap.put(next, objOpt);
                }
            }
            return linkedHashMap;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: compiled from: DatazoomAnalyticsManager.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/kick/mobile/kickivsplayerv2/DatazoomAnalyticsManager$Companion;", "", "<init>", "()V", "initializedConfiguration", "Lcom/kick/mobile/kickivsplayerv2/DatazoomAnalyticsManager$SDKConfiguration;", "initializeDatazoomIfNeeded", "", "configuration", "kick-ivs-player-v2_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void initializeDatazoomIfNeeded(SDKConfiguration configuration) {
            if (Intrinsics.areEqual(DatazoomAnalyticsManager.initializedConfiguration, configuration)) {
                return;
            }
            Config.Builder builder = new Config.Builder(configuration.getConfigurationId());
            builder.isProduction(configuration.isProduction());
            Datazoom.INSTANCE.init(builder.build());
            DatazoomAnalyticsManager.initializedConfiguration = configuration;
        }
    }
}
