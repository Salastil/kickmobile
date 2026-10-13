package com.amazon.mediatailorsdk;

import com.datadog.android.webview.internal.MixedWebViewEventConsumer;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.ReferenceArraySerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: AdData.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0003%&'Bs\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000b\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000b\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000b¢\u0006\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u001b\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#¨\u0006("}, d2 = {"Lcom/amazon/mediatailorsdk/NonLinearAdsData;", "Lcom/amazon/mediatailorsdk/AdDataCommon;", ViewProps.START, "", "startDate", "duration", "availId", "", "nonlinearAvail", "", "nonLinearAdList", "", "Lcom/amazon/mediatailorsdk/NonLinearAdsData$NonLinearAd;", "extensions", "Lcom/amazon/mediatailorsdk/NonLinearAdsData$Extension;", "trackingEvents", "Lcom/amazon/mediatailorsdk/NonLinearAdsData$TrackingEvent;", "adBreakTrackingEvents", "Lcom/amazon/mediatailorsdk/AdBreakTrackingEvent;", "<init>", "(DDDLjava/lang/String;Z[Lcom/amazon/mediatailorsdk/NonLinearAdsData$NonLinearAd;[Lcom/amazon/mediatailorsdk/NonLinearAdsData$Extension;[Lcom/amazon/mediatailorsdk/NonLinearAdsData$TrackingEvent;[Lcom/amazon/mediatailorsdk/AdBreakTrackingEvent;)V", "getAvailId", "()Ljava/lang/String;", "getNonlinearAvail", "()Z", "getNonLinearAdList", "()[Lcom/amazon/mediatailorsdk/NonLinearAdsData$NonLinearAd;", "[Lcom/amazon/mediatailorsdk/NonLinearAdsData$NonLinearAd;", "getExtensions", "()[Lcom/amazon/mediatailorsdk/NonLinearAdsData$Extension;", "[Lcom/amazon/mediatailorsdk/NonLinearAdsData$Extension;", "getTrackingEvents", "()[Lcom/amazon/mediatailorsdk/NonLinearAdsData$TrackingEvent;", "[Lcom/amazon/mediatailorsdk/NonLinearAdsData$TrackingEvent;", "getAdBreakTrackingEvents", "()[Lcom/amazon/mediatailorsdk/AdBreakTrackingEvent;", "[Lcom/amazon/mediatailorsdk/AdBreakTrackingEvent;", "NonLinearAd", "Extension", "TrackingEvent", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class NonLinearAdsData extends AdDataCommon {
    private final AdBreakTrackingEvent[] adBreakTrackingEvents;
    private final String availId;
    private final Extension[] extensions;
    private final NonLinearAd[] nonLinearAdList;
    private final boolean nonlinearAvail;
    private final TrackingEvent[] trackingEvents;

    public NonLinearAdsData(double d, double d2, double d3, String str, boolean z, NonLinearAd[] nonLinearAdArr, Extension[] extensionArr, TrackingEvent[] trackingEventArr, AdBreakTrackingEvent[] adBreakTrackingEventArr) {
        super(d, d2, d3);
        this.availId = str;
        this.nonlinearAvail = z;
        this.nonLinearAdList = nonLinearAdArr;
        this.extensions = extensionArr;
        this.trackingEvents = trackingEventArr;
        this.adBreakTrackingEvents = adBreakTrackingEventArr;
    }

    public final String getAvailId() {
        return this.availId;
    }

    public final boolean getNonlinearAvail() {
        return this.nonlinearAvail;
    }

    public final NonLinearAd[] getNonLinearAdList() {
        return this.nonLinearAdList;
    }

    public final Extension[] getExtensions() {
        return this.extensions;
    }

    public final TrackingEvent[] getTrackingEvents() {
        return this.trackingEvents;
    }

    /* JADX INFO: compiled from: AdData.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b9\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 c2\u00020\u0001:\u0002bcB\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0081\u0002\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\t\u0012\b\u0010 \u001a\u0004\u0018\u00010!¢\u0006\u0004\b\u0002\u0010\"J%\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020\u00002\u0006\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020`H\u0001¢\u0006\u0002\baR*\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010#\u001a\u0004\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R(\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010#\u001a\u0004\u0018\u00010\t@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R(\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010#\u001a\u0004\u0018\u00010\t@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010*\"\u0004\b.\u0010,R(\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\u0010#\u001a\u0004\u0018\u00010\t@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010*\"\u0004\b0\u0010,R(\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010#\u001a\u0004\u0018\u00010\t@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010*\"\u0004\b2\u0010,R(\u0010\r\u001a\u0004\u0018\u00010\t2\b\u0010#\u001a\u0004\u0018\u00010\t@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010*\"\u0004\b4\u0010,R(\u0010\u000e\u001a\u0004\u0018\u00010\t2\b\u0010#\u001a\u0004\u0018\u00010\t@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010*\"\u0004\b6\u0010,R(\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010#\u001a\u0004\u0018\u00010\t@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010*\"\u0004\b8\u0010,R(\u0010\u0010\u001a\u0004\u0018\u00010\t2\b\u0010#\u001a\u0004\u0018\u00010\t@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010*\"\u0004\b:\u0010,R(\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\u0010#\u001a\u0004\u0018\u00010\t@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010*\"\u0004\b<\u0010,R(\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\u0010#\u001a\u0004\u0018\u00010\t@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010*\"\u0004\b>\u0010,R(\u0010\u0013\u001a\u0004\u0018\u00010\t2\b\u0010#\u001a\u0004\u0018\u00010\t@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010*\"\u0004\b@\u0010,R*\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010#\u001a\u0004\u0018\u00010\u0015@@X\u0086\u000e¢\u0006\u0010\n\u0002\u0010E\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR*\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010#\u001a\u0004\u0018\u00010\u0015@@X\u0086\u000e¢\u0006\u0010\n\u0002\u0010E\u001a\u0004\bF\u0010B\"\u0004\bG\u0010DR(\u0010\u0017\u001a\u0004\u0018\u00010\t2\b\u0010#\u001a\u0004\u0018\u00010\t@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010*\"\u0004\bI\u0010,R(\u0010\u0018\u001a\u0004\u0018\u00010\t2\b\u0010#\u001a\u0004\u0018\u00010\t@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010*\"\u0004\bK\u0010,R(\u0010\u0019\u001a\u0004\u0018\u00010\t2\b\u0010#\u001a\u0004\u0018\u00010\t@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010*\"\u0004\bM\u0010,R(\u0010\u001a\u001a\u0004\u0018\u00010\t2\b\u0010#\u001a\u0004\u0018\u00010\t@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010*\"\u0004\bO\u0010,R(\u0010\u001b\u001a\u0004\u0018\u00010\t2\b\u0010#\u001a\u0004\u0018\u00010\t@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010*\"\u0004\bQ\u0010,R(\u0010\u001c\u001a\u0004\u0018\u00010\t2\b\u0010#\u001a\u0004\u0018\u00010\t@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010*\"\u0004\bS\u0010,R(\u0010\u001d\u001a\u0004\u0018\u00010\t2\b\u0010#\u001a\u0004\u0018\u00010\t@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010*\"\u0004\bU\u0010,R(\u0010\u001e\u001a\u0004\u0018\u00010\t2\b\u0010#\u001a\u0004\u0018\u00010\t@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010*\"\u0004\bW\u0010,R(\u0010\u001f\u001a\u0004\u0018\u00010\t2\b\u0010#\u001a\u0004\u0018\u00010\t@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010*\"\u0004\bY\u0010,¨\u0006d"}, d2 = {"Lcom/amazon/mediatailorsdk/NonLinearAdsData$NonLinearAd;", "", "<init>", "()V", "seen0", "", "durationInSeconds", "", "adId", "", "adParameters", "adSystem", "adTitle", "creativeId", "creativeAdId", "creativeSequence", ViewProps.WIDTH, ViewProps.HEIGHT, "expandedWidth", "expandedHeight", "scalable", "", "maintainAspectRatio", "minSuggestedDuration", "apiFramework", "staticResource", "staticResourceCreativeType", "iFrameResource", "htmlResource", "clickThrough", "clickTracking", "clickTrackingId", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "value", "getDurationInSeconds", "()Ljava/lang/Double;", "setDurationInSeconds$MediaTailor_release", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getAdId", "()Ljava/lang/String;", "setAdId$MediaTailor_release", "(Ljava/lang/String;)V", "getAdParameters", "setAdParameters$MediaTailor_release", "getAdSystem", "setAdSystem$MediaTailor_release", "getAdTitle", "setAdTitle$MediaTailor_release", "getCreativeId", "setCreativeId$MediaTailor_release", "getCreativeAdId", "setCreativeAdId$MediaTailor_release", "getCreativeSequence", "setCreativeSequence$MediaTailor_release", "getWidth", "setWidth$MediaTailor_release", "getHeight", "setHeight$MediaTailor_release", "getExpandedWidth", "setExpandedWidth$MediaTailor_release", "getExpandedHeight", "setExpandedHeight$MediaTailor_release", "getScalable", "()Ljava/lang/Boolean;", "setScalable$MediaTailor_release", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getMaintainAspectRatio", "setMaintainAspectRatio$MediaTailor_release", "getMinSuggestedDuration", "setMinSuggestedDuration$MediaTailor_release", "getApiFramework", "setApiFramework$MediaTailor_release", "getStaticResource", "setStaticResource$MediaTailor_release", "getStaticResourceCreativeType", "setStaticResourceCreativeType$MediaTailor_release", "getIFrameResource", "setIFrameResource$MediaTailor_release", "getHtmlResource", "setHtmlResource$MediaTailor_release", "getClickThrough", "setClickThrough$MediaTailor_release", "getClickTracking", "setClickTracking$MediaTailor_release", "getClickTrackingId", "setClickTrackingId$MediaTailor_release", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$MediaTailor_release", "$serializer", "Companion", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @Serializable
    public static final class NonLinearAd {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private String adId;
        private String adParameters;
        private String adSystem;
        private String adTitle;
        private String apiFramework;
        private String clickThrough;
        private String clickTracking;
        private String clickTrackingId;
        private String creativeAdId;
        private String creativeId;
        private String creativeSequence;
        private Double durationInSeconds;
        private String expandedHeight;
        private String expandedWidth;
        private String height;
        private String htmlResource;
        private String iFrameResource;
        private Boolean maintainAspectRatio;
        private String minSuggestedDuration;
        private Boolean scalable;
        private String staticResource;
        private String staticResourceCreativeType;
        private String width;

        /* JADX INFO: compiled from: AdData.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/amazon/mediatailorsdk/NonLinearAdsData$NonLinearAd$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/amazon/mediatailorsdk/NonLinearAdsData$NonLinearAd;", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<NonLinearAd> serializer() {
                return NonLinearAdsData$NonLinearAd$$serializer.INSTANCE;
            }
        }

        public NonLinearAd() {
        }

        public /* synthetic */ NonLinearAd(int i, Double d, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Boolean bool, Boolean bool2, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 1) == 0) {
                this.durationInSeconds = null;
            } else {
                this.durationInSeconds = d;
            }
            if ((i & 2) == 0) {
                this.adId = null;
            } else {
                this.adId = str;
            }
            if ((i & 4) == 0) {
                this.adParameters = null;
            } else {
                this.adParameters = str2;
            }
            if ((i & 8) == 0) {
                this.adSystem = null;
            } else {
                this.adSystem = str3;
            }
            if ((i & 16) == 0) {
                this.adTitle = null;
            } else {
                this.adTitle = str4;
            }
            if ((i & 32) == 0) {
                this.creativeId = null;
            } else {
                this.creativeId = str5;
            }
            if ((i & 64) == 0) {
                this.creativeAdId = null;
            } else {
                this.creativeAdId = str6;
            }
            if ((i & 128) == 0) {
                this.creativeSequence = null;
            } else {
                this.creativeSequence = str7;
            }
            if ((i & 256) == 0) {
                this.width = null;
            } else {
                this.width = str8;
            }
            if ((i & 512) == 0) {
                this.height = null;
            } else {
                this.height = str9;
            }
            if ((i & 1024) == 0) {
                this.expandedWidth = null;
            } else {
                this.expandedWidth = str10;
            }
            if ((i & 2048) == 0) {
                this.expandedHeight = null;
            } else {
                this.expandedHeight = str11;
            }
            if ((i & 4096) == 0) {
                this.scalable = null;
            } else {
                this.scalable = bool;
            }
            if ((i & 8192) == 0) {
                this.maintainAspectRatio = null;
            } else {
                this.maintainAspectRatio = bool2;
            }
            if ((i & 16384) == 0) {
                this.minSuggestedDuration = null;
            } else {
                this.minSuggestedDuration = str12;
            }
            if ((32768 & i) == 0) {
                this.apiFramework = null;
            } else {
                this.apiFramework = str13;
            }
            if ((65536 & i) == 0) {
                this.staticResource = null;
            } else {
                this.staticResource = str14;
            }
            if ((131072 & i) == 0) {
                this.staticResourceCreativeType = null;
            } else {
                this.staticResourceCreativeType = str15;
            }
            if ((262144 & i) == 0) {
                this.iFrameResource = null;
            } else {
                this.iFrameResource = str16;
            }
            if ((524288 & i) == 0) {
                this.htmlResource = null;
            } else {
                this.htmlResource = str17;
            }
            if ((1048576 & i) == 0) {
                this.clickThrough = null;
            } else {
                this.clickThrough = str18;
            }
            if ((2097152 & i) == 0) {
                this.clickTracking = null;
            } else {
                this.clickTracking = str19;
            }
            if ((i & 4194304) == 0) {
                this.clickTrackingId = null;
            } else {
                this.clickTrackingId = str20;
            }
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$MediaTailor_release(NonLinearAd self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.durationInSeconds != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, DoubleSerializer.INSTANCE, self.durationInSeconds);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.adId != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.adId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.adParameters != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.adParameters);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.adSystem != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.adSystem);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.adTitle != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.adTitle);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.creativeId != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.creativeId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.creativeAdId != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.creativeAdId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 7) || self.creativeSequence != null) {
                output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.creativeSequence);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 8) || self.width != null) {
                output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.width);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 9) || self.height != null) {
                output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.height);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 10) || self.expandedWidth != null) {
                output.encodeNullableSerializableElement(serialDesc, 10, StringSerializer.INSTANCE, self.expandedWidth);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 11) || self.expandedHeight != null) {
                output.encodeNullableSerializableElement(serialDesc, 11, StringSerializer.INSTANCE, self.expandedHeight);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 12) || self.scalable != null) {
                output.encodeNullableSerializableElement(serialDesc, 12, BooleanSerializer.INSTANCE, self.scalable);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 13) || self.maintainAspectRatio != null) {
                output.encodeNullableSerializableElement(serialDesc, 13, BooleanSerializer.INSTANCE, self.maintainAspectRatio);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 14) || self.minSuggestedDuration != null) {
                output.encodeNullableSerializableElement(serialDesc, 14, StringSerializer.INSTANCE, self.minSuggestedDuration);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 15) || self.apiFramework != null) {
                output.encodeNullableSerializableElement(serialDesc, 15, StringSerializer.INSTANCE, self.apiFramework);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 16) || self.staticResource != null) {
                output.encodeNullableSerializableElement(serialDesc, 16, StringSerializer.INSTANCE, self.staticResource);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 17) || self.staticResourceCreativeType != null) {
                output.encodeNullableSerializableElement(serialDesc, 17, StringSerializer.INSTANCE, self.staticResourceCreativeType);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 18) || self.iFrameResource != null) {
                output.encodeNullableSerializableElement(serialDesc, 18, StringSerializer.INSTANCE, self.iFrameResource);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 19) || self.htmlResource != null) {
                output.encodeNullableSerializableElement(serialDesc, 19, StringSerializer.INSTANCE, self.htmlResource);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 20) || self.clickThrough != null) {
                output.encodeNullableSerializableElement(serialDesc, 20, StringSerializer.INSTANCE, self.clickThrough);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 21) || self.clickTracking != null) {
                output.encodeNullableSerializableElement(serialDesc, 21, StringSerializer.INSTANCE, self.clickTracking);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 22) && self.clickTrackingId == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 22, StringSerializer.INSTANCE, self.clickTrackingId);
        }

        public final Double getDurationInSeconds() {
            return this.durationInSeconds;
        }

        public final void setDurationInSeconds$MediaTailor_release(Double d) {
            this.durationInSeconds = d;
        }

        public final String getAdId() {
            return this.adId;
        }

        public final void setAdId$MediaTailor_release(String str) {
            this.adId = str;
        }

        public final String getAdParameters() {
            return this.adParameters;
        }

        public final void setAdParameters$MediaTailor_release(String str) {
            this.adParameters = str;
        }

        public final String getAdSystem() {
            return this.adSystem;
        }

        public final void setAdSystem$MediaTailor_release(String str) {
            this.adSystem = str;
        }

        public final String getAdTitle() {
            return this.adTitle;
        }

        public final void setAdTitle$MediaTailor_release(String str) {
            this.adTitle = str;
        }

        public final String getCreativeId() {
            return this.creativeId;
        }

        public final void setCreativeId$MediaTailor_release(String str) {
            this.creativeId = str;
        }

        public final String getCreativeAdId() {
            return this.creativeAdId;
        }

        public final void setCreativeAdId$MediaTailor_release(String str) {
            this.creativeAdId = str;
        }

        public final String getCreativeSequence() {
            return this.creativeSequence;
        }

        public final void setCreativeSequence$MediaTailor_release(String str) {
            this.creativeSequence = str;
        }

        public final String getWidth() {
            return this.width;
        }

        public final void setWidth$MediaTailor_release(String str) {
            this.width = str;
        }

        public final String getHeight() {
            return this.height;
        }

        public final void setHeight$MediaTailor_release(String str) {
            this.height = str;
        }

        public final String getExpandedWidth() {
            return this.expandedWidth;
        }

        public final void setExpandedWidth$MediaTailor_release(String str) {
            this.expandedWidth = str;
        }

        public final String getExpandedHeight() {
            return this.expandedHeight;
        }

        public final void setExpandedHeight$MediaTailor_release(String str) {
            this.expandedHeight = str;
        }

        public final Boolean getScalable() {
            return this.scalable;
        }

        public final void setScalable$MediaTailor_release(Boolean bool) {
            this.scalable = bool;
        }

        public final Boolean getMaintainAspectRatio() {
            return this.maintainAspectRatio;
        }

        public final void setMaintainAspectRatio$MediaTailor_release(Boolean bool) {
            this.maintainAspectRatio = bool;
        }

        public final String getMinSuggestedDuration() {
            return this.minSuggestedDuration;
        }

        public final void setMinSuggestedDuration$MediaTailor_release(String str) {
            this.minSuggestedDuration = str;
        }

        public final String getApiFramework() {
            return this.apiFramework;
        }

        public final void setApiFramework$MediaTailor_release(String str) {
            this.apiFramework = str;
        }

        public final String getStaticResource() {
            return this.staticResource;
        }

        public final void setStaticResource$MediaTailor_release(String str) {
            this.staticResource = str;
        }

        public final String getStaticResourceCreativeType() {
            return this.staticResourceCreativeType;
        }

        public final void setStaticResourceCreativeType$MediaTailor_release(String str) {
            this.staticResourceCreativeType = str;
        }

        public final String getIFrameResource() {
            return this.iFrameResource;
        }

        public final void setIFrameResource$MediaTailor_release(String str) {
            this.iFrameResource = str;
        }

        public final String getHtmlResource() {
            return this.htmlResource;
        }

        public final void setHtmlResource$MediaTailor_release(String str) {
            this.htmlResource = str;
        }

        public final String getClickThrough() {
            return this.clickThrough;
        }

        public final void setClickThrough$MediaTailor_release(String str) {
            this.clickThrough = str;
        }

        public final String getClickTracking() {
            return this.clickTracking;
        }

        public final void setClickTracking$MediaTailor_release(String str) {
            this.clickTracking = str;
        }

        public final String getClickTrackingId() {
            return this.clickTrackingId;
        }

        public final void setClickTrackingId$MediaTailor_release(String str) {
            this.clickTrackingId = str;
        }
    }

    public final AdBreakTrackingEvent[] getAdBreakTrackingEvents() {
        return this.adBreakTrackingEvents;
    }

    /* JADX INFO: compiled from: AdData.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001b\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003B/\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0002\u0010\u000bJ%\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0001¢\u0006\u0002\b\u001aR(\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/amazon/mediatailorsdk/NonLinearAdsData$Extension;", "", "<init>", "()V", "seen0", "", "content", "", "type", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "value", "getContent", "()Ljava/lang/String;", "setContent$MediaTailor_release", "(Ljava/lang/String;)V", "getType", "setType$MediaTailor_release", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$MediaTailor_release", "$serializer", "Companion", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @Serializable
    public static final class Extension {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private String content;
        private String type;

        /* JADX INFO: compiled from: AdData.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/amazon/mediatailorsdk/NonLinearAdsData$Extension$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/amazon/mediatailorsdk/NonLinearAdsData$Extension;", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Extension> serializer() {
                return NonLinearAdsData$Extension$$serializer.INSTANCE;
            }
        }

        public Extension() {
        }

        public /* synthetic */ Extension(int i, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 1) == 0) {
                this.content = null;
            } else {
                this.content = str;
            }
            if ((i & 2) == 0) {
                this.type = null;
            } else {
                this.type = str2;
            }
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$MediaTailor_release(Extension self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.content != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.content);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 1) && self.type == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.type);
        }

        public final String getContent() {
            return this.content;
        }

        public final void setContent$MediaTailor_release(String str) {
            this.content = str;
        }

        public final String getType() {
            return this.type;
        }

        public final void setType$MediaTailor_release(String str) {
            this.type = str;
        }
    }

    /* JADX INFO: compiled from: AdData.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 02\u00020\u0001:\u0002/0B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B]\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0002\u0010\u0011J%\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0001¢\u0006\u0002\b.R6\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R*\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\n@@X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR(\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\b@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R(\u0010\f\u001a\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\b@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010 R(\u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\b@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R*\u0010\u000e\u001a\u0004\u0018\u00010\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\n@@X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b%\u0010\u0019\"\u0004\b&\u0010\u001b¨\u00061"}, d2 = {"Lcom/amazon/mediatailorsdk/NonLinearAdsData$TrackingEvent;", "", "<init>", "()V", "seen0", "", "beaconUrls", "", "", "durationInSeconds", "", "eventId", "eventProgramDateTime", MixedWebViewEventConsumer.EVENT_TYPE_KEY, "startTimeInSeconds", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(I[Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "value", "getBeaconUrls", "()[Ljava/lang/String;", "setBeaconUrls$MediaTailor_release", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "getDurationInSeconds", "()Ljava/lang/Double;", "setDurationInSeconds$MediaTailor_release", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getEventId", "()Ljava/lang/String;", "setEventId$MediaTailor_release", "(Ljava/lang/String;)V", "getEventProgramDateTime", "setEventProgramDateTime$MediaTailor_release", "getEventType", "setEventType$MediaTailor_release", "getStartTimeInSeconds", "setStartTimeInSeconds$MediaTailor_release", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$MediaTailor_release", "$serializer", "Companion", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @Serializable
    public static final class TrackingEvent {
        private String[] beaconUrls;
        private Double durationInSeconds;
        private String eventId;
        private String eventProgramDateTime;
        private String eventType;
        private Double startTimeInSeconds;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.amazon.mediatailorsdk.NonLinearAdsData$TrackingEvent$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NonLinearAdsData.TrackingEvent._childSerializers$_anonymous_();
            }
        }), null, null, null, null, null};

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new ReferenceArraySerializer(Reflection.getOrCreateKotlinClass(String.class), StringSerializer.INSTANCE);
        }

        /* JADX INFO: compiled from: AdData.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/amazon/mediatailorsdk/NonLinearAdsData$TrackingEvent$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/amazon/mediatailorsdk/NonLinearAdsData$TrackingEvent;", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<TrackingEvent> serializer() {
                return NonLinearAdsData$TrackingEvent$$serializer.INSTANCE;
            }
        }

        public TrackingEvent() {
        }

        public /* synthetic */ TrackingEvent(int i, String[] strArr, Double d, String str, String str2, String str3, Double d2, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 1) == 0) {
                this.beaconUrls = null;
            } else {
                this.beaconUrls = strArr;
            }
            if ((i & 2) == 0) {
                this.durationInSeconds = null;
            } else {
                this.durationInSeconds = d;
            }
            if ((i & 4) == 0) {
                this.eventId = null;
            } else {
                this.eventId = str;
            }
            if ((i & 8) == 0) {
                this.eventProgramDateTime = null;
            } else {
                this.eventProgramDateTime = str2;
            }
            if ((i & 16) == 0) {
                this.eventType = null;
            } else {
                this.eventType = str3;
            }
            if ((i & 32) == 0) {
                this.startTimeInSeconds = null;
            } else {
                this.startTimeInSeconds = d2;
            }
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$MediaTailor_release(TrackingEvent self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.beaconUrls != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, lazyArr[0].getValue(), self.beaconUrls);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.durationInSeconds != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, DoubleSerializer.INSTANCE, self.durationInSeconds);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.eventId != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.eventId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.eventProgramDateTime != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.eventProgramDateTime);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.eventType != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.eventType);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 5) && self.startTimeInSeconds == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 5, DoubleSerializer.INSTANCE, self.startTimeInSeconds);
        }

        public final String[] getBeaconUrls() {
            return this.beaconUrls;
        }

        public final void setBeaconUrls$MediaTailor_release(String[] strArr) {
            this.beaconUrls = strArr;
        }

        public final Double getDurationInSeconds() {
            return this.durationInSeconds;
        }

        public final void setDurationInSeconds$MediaTailor_release(Double d) {
            this.durationInSeconds = d;
        }

        public final String getEventId() {
            return this.eventId;
        }

        public final void setEventId$MediaTailor_release(String str) {
            this.eventId = str;
        }

        public final String getEventProgramDateTime() {
            return this.eventProgramDateTime;
        }

        public final void setEventProgramDateTime$MediaTailor_release(String str) {
            this.eventProgramDateTime = str;
        }

        public final String getEventType() {
            return this.eventType;
        }

        public final void setEventType$MediaTailor_release(String str) {
            this.eventType = str;
        }

        public final Double getStartTimeInSeconds() {
            return this.startTimeInSeconds;
        }

        public final void setStartTimeInSeconds$MediaTailor_release(Double d) {
            this.startTimeInSeconds = d;
        }
    }
}
