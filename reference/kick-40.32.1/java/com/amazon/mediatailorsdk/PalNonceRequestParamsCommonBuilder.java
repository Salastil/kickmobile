package com.amazon.mediatailorsdk;

import com.datadog.android.rum.internal.domain.scope.RumSessionScope;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PAL.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\"\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u000fH\u0016J\u0010\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u000fH\u0016J\u0010\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u000fH\u0016J\u0010\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u000fH\u0016J\u0010\u0010!\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u000fH\u0016J\u0010\u0010#\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u000fH\u0016J\u0016\u0010%\u001a\u00020\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00150&H\u0016J\u0010\u0010)\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0015H\u0016J\u0010\u0010+\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0015H\u0016R$\u0010\u0004\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\r\u0010\bR\"\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0013\u0010\bR$\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0005\u001a\u0004\u0018\u00010\u0015@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\"\u0010\u001b\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011R\"\u0010\u001d\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0011R\"\u0010\u001f\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0011R\"\u0010!\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0011R\"\u0010#\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0011R.\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010&2\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010&@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R$\u0010)\u001a\u0004\u0018\u00010\u00152\b\u0010\u0005\u001a\u0004\u0018\u00010\u0015@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b*\u0010\u0017R$\u0010+\u001a\u0004\u0018\u00010\u00152\b\u0010\u0005\u001a\u0004\u0018\u00010\u0015@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b,\u0010\u0017¨\u0006-"}, d2 = {"Lcom/amazon/mediatailorsdk/PalNonceRequestParamsCommonBuilder;", "", "<init>", "()V", "adWillAutoPlay", "value", "", "getAdWillAutoPlay", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "adWillPlayMuted", "getAdWillPlayMuted", "continuousPlayback", "getContinuousPlayback", "descriptionUrl", "", "getDescriptionUrl", "()Ljava/lang/String;", "iconsSupported", "getIconsSupported", "nonceLengthLimit", "", "getNonceLengthLimit", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "omidPartnerName", "getOmidPartnerName", "omidPartnerVersion", "getOmidPartnerVersion", "playerType", "getPlayerType", "playerVersion", "getPlayerVersion", "ppid", "getPpid", RumSessionScope.RUM_SESSION_ID_BUS_MESSAGE_KEY, "getSessionId", "supportedApiFrameworks", "", "getSupportedApiFrameworks", "()Ljava/util/Set;", "videoHeight", "getVideoHeight", "videoWidth", "getVideoWidth", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class PalNonceRequestParamsCommonBuilder {
    private Boolean adWillAutoPlay;
    private Boolean adWillPlayMuted;
    private Boolean continuousPlayback;
    private String descriptionUrl;
    private Boolean iconsSupported;
    private Integer nonceLengthLimit;
    private String omidPartnerName;
    private String omidPartnerVersion;
    private String playerType;
    private String playerVersion;
    private String ppid;
    private String sessionId;
    private Set<Integer> supportedApiFrameworks;
    private Integer videoHeight;
    private Integer videoWidth;

    protected PalNonceRequestParamsCommonBuilder() {
    }

    public PalNonceRequestParamsCommonBuilder adWillAutoPlay(boolean value) {
        this.adWillAutoPlay = Boolean.valueOf(value);
        return this;
    }

    public final Boolean getAdWillAutoPlay() {
        return this.adWillAutoPlay;
    }

    public PalNonceRequestParamsCommonBuilder adWillPlayMuted(boolean value) {
        this.adWillPlayMuted = Boolean.valueOf(value);
        return this;
    }

    public final Boolean getAdWillPlayMuted() {
        return this.adWillPlayMuted;
    }

    public PalNonceRequestParamsCommonBuilder continuousPlayback(boolean value) {
        this.continuousPlayback = Boolean.valueOf(value);
        return this;
    }

    public final Boolean getContinuousPlayback() {
        return this.continuousPlayback;
    }

    public PalNonceRequestParamsCommonBuilder descriptionUrl(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.descriptionUrl = value;
        return this;
    }

    public final String getDescriptionUrl() {
        return this.descriptionUrl;
    }

    public PalNonceRequestParamsCommonBuilder iconsSupported(boolean value) {
        this.iconsSupported = Boolean.valueOf(value);
        return this;
    }

    public final Boolean getIconsSupported() {
        return this.iconsSupported;
    }

    public PalNonceRequestParamsCommonBuilder nonceLengthLimit(int value) {
        this.nonceLengthLimit = Integer.valueOf(value);
        return this;
    }

    public final Integer getNonceLengthLimit() {
        return this.nonceLengthLimit;
    }

    public PalNonceRequestParamsCommonBuilder omidPartnerName(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.omidPartnerName = value;
        return this;
    }

    public final String getOmidPartnerName() {
        return this.omidPartnerName;
    }

    public PalNonceRequestParamsCommonBuilder omidPartnerVersion(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.omidPartnerVersion = value;
        return this;
    }

    public final String getOmidPartnerVersion() {
        return this.omidPartnerVersion;
    }

    public PalNonceRequestParamsCommonBuilder playerType(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.playerType = value;
        return this;
    }

    public final String getPlayerType() {
        return this.playerType;
    }

    public PalNonceRequestParamsCommonBuilder playerVersion(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.playerVersion = value;
        return this;
    }

    public final String getPlayerVersion() {
        return this.playerVersion;
    }

    public PalNonceRequestParamsCommonBuilder ppid(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.ppid = value;
        return this;
    }

    public final String getPpid() {
        return this.ppid;
    }

    public PalNonceRequestParamsCommonBuilder sessionId(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.sessionId = value;
        return this;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public PalNonceRequestParamsCommonBuilder supportedApiFrameworks(Set<Integer> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.supportedApiFrameworks = value;
        return this;
    }

    public final Set<Integer> getSupportedApiFrameworks() {
        return this.supportedApiFrameworks;
    }

    public PalNonceRequestParamsCommonBuilder videoHeight(int value) {
        this.videoHeight = Integer.valueOf(value);
        return this;
    }

    public final Integer getVideoHeight() {
        return this.videoHeight;
    }

    public PalNonceRequestParamsCommonBuilder videoWidth(int value) {
        this.videoWidth = Integer.valueOf(value);
        return this;
    }

    public final Integer getVideoWidth() {
        return this.videoWidth;
    }
}
