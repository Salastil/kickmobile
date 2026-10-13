package com.amazon.mediatailorsdk;

import java.util.Map;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SessionConfiguration.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001;B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001f\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\tR\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001f\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\rR\u001f\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\rR\u0013\u0010!\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\tR\u0013\u0010#\u001a\u0004\u0018\u00010$¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010'\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\tR\u0015\u0010)\u001a\u0004\u0018\u00010*¢\u0006\n\n\u0002\u0010-\u001a\u0004\b+\u0010,R\u0015\u0010.\u001a\u0004\u0018\u00010*¢\u0006\n\n\u0002\u0010-\u001a\u0004\b/\u0010,R\u0013\u00100\u001a\u0004\u0018\u000101¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0015\u00104\u001a\u0004\u0018\u000105¢\u0006\n\n\u0002\u00108\u001a\u0004\b6\u00107R\u0015\u00109\u001a\u0004\u0018\u000105¢\u0006\n\n\u0002\u00108\u001a\u0004\b:\u00107¨\u0006<"}, d2 = {"Lcom/amazon/mediatailorsdk/SessionConfiguration;", "", "builder", "Lcom/amazon/mediatailorsdk/SessionConfiguration$Builder;", "<init>", "(Lcom/amazon/mediatailorsdk/SessionConfiguration$Builder;)V", "sessionInitUrl", "", "getSessionInitUrl", "()Ljava/lang/String;", "sessionInitHeaders", "", "getSessionInitHeaders", "()Ljava/util/Map;", "sessionInitTimeout", "", "getSessionInitTimeout", "()Ljava/lang/Long;", "Ljava/lang/Long;", "sessionInitMaxRetries", "Lkotlin/UInt;", "getSessionInitMaxRetries-0hXNFcg", "()Lkotlin/UInt;", "userAgent", "getUserAgent", "sessionFeatures", "Lcom/amazon/mediatailorsdk/SessionFeatures;", "getSessionFeatures", "()Lcom/amazon/mediatailorsdk/SessionFeatures;", "playerParams", "getPlayerParams", "originParams", "getOriginParams", "palNonceString", "getPalNonceString", "palNonceRequestParams", "Lcom/amazon/mediatailorsdk/PalNonceRequestParams;", "getPalNonceRequestParams", "()Lcom/amazon/mediatailorsdk/PalNonceRequestParams;", "trackingUrl", "getTrackingUrl", "defaultTrackingRequestInterval", "", "getDefaultTrackingRequestInterval", "()Ljava/lang/Double;", "Ljava/lang/Double;", "incomingAdCountdownInterval", "getIncomingAdCountdownInterval", "adTrackingUpdateMode", "Lcom/amazon/mediatailorsdk/AdTrackingUpdateMode;", "getAdTrackingUpdateMode", "()Lcom/amazon/mediatailorsdk/AdTrackingUpdateMode;", "disableNoninteractiveClientSideBeaconing", "", "getDisableNoninteractiveClientSideBeaconing", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "detectAdRemoval", "getDetectAdRemoval", "Builder", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SessionConfiguration {
    private final AdTrackingUpdateMode adTrackingUpdateMode;
    private final Double defaultTrackingRequestInterval;
    private final Boolean detectAdRemoval;
    private final Boolean disableNoninteractiveClientSideBeaconing;
    private final Double incomingAdCountdownInterval;
    private final Map<String, String> originParams;
    private final PalNonceRequestParams palNonceRequestParams;
    private final String palNonceString;
    private final Map<String, String> playerParams;
    private final SessionFeatures sessionFeatures;
    private final Map<String, String> sessionInitHeaders;
    private final UInt sessionInitMaxRetries;
    private final Long sessionInitTimeout;
    private final String sessionInitUrl;
    private final String trackingUrl;
    private final String userAgent;

    public /* synthetic */ SessionConfiguration(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private SessionConfiguration(Builder builder) {
        this.sessionInitUrl = builder.getSessionInitUrl();
        this.sessionInitHeaders = builder.getSessionInitHeaders();
        this.sessionInitTimeout = builder.getSessionInitTimeout();
        this.sessionInitMaxRetries = builder.getSessionInitMaxRetries();
        this.userAgent = builder.getUserAgent();
        this.sessionFeatures = builder.getSessionFeatures();
        this.playerParams = builder.getPlayerParams();
        this.originParams = builder.getOriginParams();
        this.palNonceString = builder.getPalNonceString();
        this.palNonceRequestParams = builder.getPalNonceRequestParams();
        this.trackingUrl = builder.getTrackingUrl();
        this.defaultTrackingRequestInterval = builder.getDefaultTrackingRequestInterval();
        this.incomingAdCountdownInterval = builder.getIncomingAdCountdownInterval();
        this.adTrackingUpdateMode = builder.getAdTrackingUpdateMode();
        this.disableNoninteractiveClientSideBeaconing = builder.getDisableNoninteractiveClientSideBeaconing();
        this.detectAdRemoval = builder.getDetectAdRemoval();
    }

    public final String getSessionInitUrl() {
        return this.sessionInitUrl;
    }

    public final Map<String, String> getSessionInitHeaders() {
        return this.sessionInitHeaders;
    }

    public final Long getSessionInitTimeout() {
        return this.sessionInitTimeout;
    }

    /* JADX INFO: renamed from: getSessionInitMaxRetries-0hXNFcg, reason: not valid java name and from getter */
    public final UInt getSessionInitMaxRetries() {
        return this.sessionInitMaxRetries;
    }

    public final String getUserAgent() {
        return this.userAgent;
    }

    public final SessionFeatures getSessionFeatures() {
        return this.sessionFeatures;
    }

    public final Map<String, String> getPlayerParams() {
        return this.playerParams;
    }

    public final Map<String, String> getOriginParams() {
        return this.originParams;
    }

    public final String getPalNonceString() {
        return this.palNonceString;
    }

    public final PalNonceRequestParams getPalNonceRequestParams() {
        return this.palNonceRequestParams;
    }

    public final String getTrackingUrl() {
        return this.trackingUrl;
    }

    public final Double getDefaultTrackingRequestInterval() {
        return this.defaultTrackingRequestInterval;
    }

    public final Double getIncomingAdCountdownInterval() {
        return this.incomingAdCountdownInterval;
    }

    public final AdTrackingUpdateMode getAdTrackingUpdateMode() {
        return this.adTrackingUpdateMode;
    }

    public final Boolean getDisableNoninteractiveClientSideBeaconing() {
        return this.disableNoninteractiveClientSideBeaconing;
    }

    public final Boolean getDetectAdRemoval() {
        return this.detectAdRemoval;
    }

    /* JADX INFO: compiled from: SessionConfiguration.kt */
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u001a\u0010\t\u001a\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\nJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u000eJ\u0015\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u001bJ\u001a\u0010\u001e\u001a\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\nJ\u001a\u0010 \u001a\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\nJ\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010$\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020%J\u000e\u0010(\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010*\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020+J\u000e\u0010/\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020+J\u000e\u00101\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u000202J\u000e\u00105\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u000206J\u000e\u0010:\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u000206J\u0006\u0010<\u001a\u00020=R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR:\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n2\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u000e@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0005\u001a\u0004\u0018\u00010\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\bR\"\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u001b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR:\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n2\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\fR:\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n2\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\fR\"\u0010\"\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\bR\"\u0010$\u001a\u0004\u0018\u00010%2\b\u0010\u0005\u001a\u0004\u0018\u00010%@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\"\u0010(\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\bR$\u0010*\u001a\u0004\u0018\u00010+2\b\u0010\u0005\u001a\u0004\u0018\u00010+@BX\u0086\u000e¢\u0006\n\n\u0002\u0010.\u001a\u0004\b,\u0010-R$\u0010/\u001a\u0004\u0018\u00010+2\b\u0010\u0005\u001a\u0004\u0018\u00010+@BX\u0086\u000e¢\u0006\n\n\u0002\u0010.\u001a\u0004\b0\u0010-R\"\u00101\u001a\u0004\u0018\u0001022\b\u0010\u0005\u001a\u0004\u0018\u000102@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R$\u00105\u001a\u0004\u0018\u0001062\b\u0010\u0005\u001a\u0004\u0018\u000106@BX\u0086\u000e¢\u0006\n\n\u0002\u00109\u001a\u0004\b7\u00108R$\u0010:\u001a\u0004\u0018\u0001062\b\u0010\u0005\u001a\u0004\u0018\u000106@BX\u0086\u000e¢\u0006\n\n\u0002\u00109\u001a\u0004\b;\u00108¨\u0006>"}, d2 = {"Lcom/amazon/mediatailorsdk/SessionConfiguration$Builder;", "", "<init>", "()V", "sessionInitUrl", "value", "", "getSessionInitUrl", "()Ljava/lang/String;", "sessionInitHeaders", "", "getSessionInitHeaders", "()Ljava/util/Map;", "sessionInitTimeout", "", "getSessionInitTimeout", "()Ljava/lang/Long;", "Ljava/lang/Long;", "sessionInitMaxRetries", "Lkotlin/UInt;", "sessionInitMaxRetries-WZ4Q5Ns", "(I)Lcom/amazon/mediatailorsdk/SessionConfiguration$Builder;", "getSessionInitMaxRetries-0hXNFcg", "()Lkotlin/UInt;", "userAgent", "getUserAgent", "sessionFeatures", "Lcom/amazon/mediatailorsdk/SessionFeatures;", "getSessionFeatures", "()Lcom/amazon/mediatailorsdk/SessionFeatures;", "playerParams", "getPlayerParams", "originParams", "getOriginParams", "palNonceString", "getPalNonceString", "palNonceRequestParams", "Lcom/amazon/mediatailorsdk/PalNonceRequestParams;", "getPalNonceRequestParams", "()Lcom/amazon/mediatailorsdk/PalNonceRequestParams;", "trackingUrl", "getTrackingUrl", "defaultTrackingRequestInterval", "", "getDefaultTrackingRequestInterval", "()Ljava/lang/Double;", "Ljava/lang/Double;", "incomingAdCountdownInterval", "getIncomingAdCountdownInterval", "adTrackingUpdateMode", "Lcom/amazon/mediatailorsdk/AdTrackingUpdateMode;", "getAdTrackingUpdateMode", "()Lcom/amazon/mediatailorsdk/AdTrackingUpdateMode;", "disableNoninteractiveClientSideBeaconing", "", "getDisableNoninteractiveClientSideBeaconing", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "detectAdRemoval", "getDetectAdRemoval", "build", "Lcom/amazon/mediatailorsdk/SessionConfiguration;", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Builder {
        private AdTrackingUpdateMode adTrackingUpdateMode;
        private Double defaultTrackingRequestInterval;
        private Boolean detectAdRemoval;
        private Boolean disableNoninteractiveClientSideBeaconing;
        private Double incomingAdCountdownInterval;
        private Map<String, String> originParams;
        private PalNonceRequestParams palNonceRequestParams;
        private String palNonceString;
        private Map<String, String> playerParams;
        private SessionFeatures sessionFeatures;
        private Map<String, String> sessionInitHeaders;
        private UInt sessionInitMaxRetries;
        private Long sessionInitTimeout;
        private String sessionInitUrl;
        private String trackingUrl;
        private String userAgent;

        public final Builder sessionInitUrl(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.sessionInitUrl = value;
            return this;
        }

        public final String getSessionInitUrl() {
            return this.sessionInitUrl;
        }

        public final Builder sessionInitHeaders(Map<String, String> value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.sessionInitHeaders = value;
            return this;
        }

        public final Map<String, String> getSessionInitHeaders() {
            return this.sessionInitHeaders;
        }

        public final Builder sessionInitTimeout(long value) {
            this.sessionInitTimeout = Long.valueOf(value);
            return this;
        }

        public final Long getSessionInitTimeout() {
            return this.sessionInitTimeout;
        }

        /* JADX INFO: renamed from: sessionInitMaxRetries-WZ4Q5Ns, reason: not valid java name */
        public final Builder m10979sessionInitMaxRetriesWZ4Q5Ns(int value) {
            this.sessionInitMaxRetries = UInt.m12782boximpl(value);
            return this;
        }

        /* JADX INFO: renamed from: getSessionInitMaxRetries-0hXNFcg, reason: not valid java name and from getter */
        public final UInt getSessionInitMaxRetries() {
            return this.sessionInitMaxRetries;
        }

        public final Builder userAgent(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.userAgent = value;
            return this;
        }

        public final String getUserAgent() {
            return this.userAgent;
        }

        public final Builder sessionFeatures(SessionFeatures value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.sessionFeatures = value;
            return this;
        }

        public final SessionFeatures getSessionFeatures() {
            return this.sessionFeatures;
        }

        public final Builder playerParams(Map<String, String> value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.playerParams = value;
            return this;
        }

        public final Map<String, String> getPlayerParams() {
            return this.playerParams;
        }

        public final Builder originParams(Map<String, String> value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.originParams = value;
            return this;
        }

        public final Map<String, String> getOriginParams() {
            return this.originParams;
        }

        public final Builder palNonceString(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.palNonceString = value;
            return this;
        }

        public final String getPalNonceString() {
            return this.palNonceString;
        }

        public final Builder palNonceRequestParams(PalNonceRequestParams value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.palNonceRequestParams = value;
            return this;
        }

        public final PalNonceRequestParams getPalNonceRequestParams() {
            return this.palNonceRequestParams;
        }

        public final Builder trackingUrl(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.trackingUrl = value;
            return this;
        }

        public final String getTrackingUrl() {
            return this.trackingUrl;
        }

        public final Builder defaultTrackingRequestInterval(double value) {
            this.defaultTrackingRequestInterval = Double.valueOf(value);
            return this;
        }

        public final Double getDefaultTrackingRequestInterval() {
            return this.defaultTrackingRequestInterval;
        }

        public final Builder incomingAdCountdownInterval(double value) {
            this.incomingAdCountdownInterval = Double.valueOf(value);
            return this;
        }

        public final Double getIncomingAdCountdownInterval() {
            return this.incomingAdCountdownInterval;
        }

        public final Builder adTrackingUpdateMode(AdTrackingUpdateMode value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.adTrackingUpdateMode = value;
            return this;
        }

        public final AdTrackingUpdateMode getAdTrackingUpdateMode() {
            return this.adTrackingUpdateMode;
        }

        public final Builder disableNoninteractiveClientSideBeaconing(boolean value) {
            this.disableNoninteractiveClientSideBeaconing = Boolean.valueOf(value);
            return this;
        }

        public final Boolean getDisableNoninteractiveClientSideBeaconing() {
            return this.disableNoninteractiveClientSideBeaconing;
        }

        public final Builder detectAdRemoval(boolean value) {
            this.detectAdRemoval = Boolean.valueOf(value);
            return this;
        }

        public final Boolean getDetectAdRemoval() {
            return this.detectAdRemoval;
        }

        public final SessionConfiguration build() {
            return new SessionConfiguration(this, null);
        }
    }
}
