package com.amazon.mediatailorsdk;

import com.datadog.android.rum.internal.domain.scope.RumSessionScope;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PAL.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\"\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\tR\u0015\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000e\u0010\tR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u0014\u0010\tR\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0012R\u0013\u0010 \u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0012R\u0013\u0010\"\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0012R\u0013\u0010$\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0012R\u0019\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010'¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0015\u0010*\u001a\u0004\u0018\u00010\u0016¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b+\u0010\u0018R\u0015\u0010,\u001a\u0004\u0018\u00010\u0016¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b-\u0010\u0018¨\u0006."}, d2 = {"Lcom/amazon/mediatailorsdk/PalNonceRequestParamsCommon;", "", "builder", "Lcom/amazon/mediatailorsdk/PalNonceRequestParamsCommonBuilder;", "<init>", "(Lcom/amazon/mediatailorsdk/PalNonceRequestParamsCommonBuilder;)V", "adWillAutoPlay", "", "getAdWillAutoPlay", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "adWillPlayMuted", "getAdWillPlayMuted", "continuousPlayback", "getContinuousPlayback", "descriptionUrl", "", "getDescriptionUrl", "()Ljava/lang/String;", "iconsSupported", "getIconsSupported", "nonceLengthLimit", "", "getNonceLengthLimit", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "omidPartnerName", "getOmidPartnerName", "omidPartnerVersion", "getOmidPartnerVersion", "playerType", "getPlayerType", "playerVersion", "getPlayerVersion", "ppid", "getPpid", RumSessionScope.RUM_SESSION_ID_BUS_MESSAGE_KEY, "getSessionId", "supportedApiFrameworks", "", "getSupportedApiFrameworks", "()Ljava/util/Set;", "videoHeight", "getVideoHeight", "videoWidth", "getVideoWidth", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class PalNonceRequestParamsCommon {
    private final Boolean adWillAutoPlay;
    private final Boolean adWillPlayMuted;
    private final Boolean continuousPlayback;
    private final String descriptionUrl;
    private final Boolean iconsSupported;
    private final Integer nonceLengthLimit;
    private final String omidPartnerName;
    private final String omidPartnerVersion;
    private final String playerType;
    private final String playerVersion;
    private final String ppid;
    private final String sessionId;
    private final Set<Integer> supportedApiFrameworks;
    private final Integer videoHeight;
    private final Integer videoWidth;

    protected PalNonceRequestParamsCommon(PalNonceRequestParamsCommonBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.adWillAutoPlay = builder.getAdWillAutoPlay();
        this.adWillPlayMuted = builder.getAdWillPlayMuted();
        this.continuousPlayback = builder.getContinuousPlayback();
        this.descriptionUrl = builder.getDescriptionUrl();
        this.iconsSupported = builder.getIconsSupported();
        this.nonceLengthLimit = builder.getNonceLengthLimit();
        this.omidPartnerName = builder.getOmidPartnerName();
        this.omidPartnerVersion = builder.getOmidPartnerVersion();
        this.playerType = builder.getPlayerType();
        this.playerVersion = builder.getPlayerVersion();
        this.ppid = builder.getPpid();
        this.sessionId = builder.getSessionId();
        this.supportedApiFrameworks = builder.getSupportedApiFrameworks();
        this.videoHeight = builder.getVideoHeight();
        this.videoWidth = builder.getVideoWidth();
    }

    public final Boolean getAdWillAutoPlay() {
        return this.adWillAutoPlay;
    }

    public final Boolean getAdWillPlayMuted() {
        return this.adWillPlayMuted;
    }

    public final Boolean getContinuousPlayback() {
        return this.continuousPlayback;
    }

    public final String getDescriptionUrl() {
        return this.descriptionUrl;
    }

    public final Boolean getIconsSupported() {
        return this.iconsSupported;
    }

    public final Integer getNonceLengthLimit() {
        return this.nonceLengthLimit;
    }

    public final String getOmidPartnerName() {
        return this.omidPartnerName;
    }

    public final String getOmidPartnerVersion() {
        return this.omidPartnerVersion;
    }

    public final String getPlayerType() {
        return this.playerType;
    }

    public final String getPlayerVersion() {
        return this.playerVersion;
    }

    public final String getPpid() {
        return this.ppid;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final Set<Integer> getSupportedApiFrameworks() {
        return this.supportedApiFrameworks;
    }

    public final Integer getVideoHeight() {
        return this.videoHeight;
    }

    public final Integer getVideoWidth() {
        return this.videoWidth;
    }
}
