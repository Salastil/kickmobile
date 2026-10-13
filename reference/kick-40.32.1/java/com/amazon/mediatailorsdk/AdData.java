package com.amazon.mediatailorsdk;

import com.datadog.android.rum.internal.RumFeature;
import com.datadog.android.webview.internal.MixedWebViewEventConsumer;
import com.datadog.trace.api.DDTags;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.ReferenceArraySerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: AdData.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b<\u0018\u00002\u00020\u0001:\u0005\\]^_`B±\u0002\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\n\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\n\u0012\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0013\u0012\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0013\u0012\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0013\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\n\u0012\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u0013\u0012\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u0013\u0012\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\u0013\u0012\b\u0010&\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b'\u0010(R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00101\u001a\u0004\b/\u00100R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00101\u001a\u0004\b2\u00100R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00101\u001a\u0004\b3\u00100R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00101\u001a\u0004\b4\u00100R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b5\u0010,R\u001b\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0013¢\u0006\n\n\u0002\u00108\u001a\u0004\b6\u00107R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b9\u0010,R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b:\u0010,R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b;\u0010,R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b<\u0010,R\u001b\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010?\u001a\u0004\b=\u0010>R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b@\u0010,R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\bA\u0010,R\u001b\u0010 \u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010D\u001a\u0004\bB\u0010CR\u001b\u0010\"\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010G\u001a\u0004\bE\u0010FR\u001b\u0010$\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010J\u001a\u0004\bH\u0010IR\u0013\u0010&\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\bK\u0010,R$\u0010\u0007\u001a\u00020\b2\u0006\u0010L\u001a\u00020\b@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010.\"\u0004\bN\u0010OR$\u0010\f\u001a\u00020\b2\u0006\u0010L\u001a\u00020\b@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010.\"\u0004\bQ\u0010OR6\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00132\u000e\u0010L\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0013@@X\u0086\u000e¢\u0006\u0010\n\u0002\u0010V\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR6\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00132\u000e\u0010L\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0013@@X\u0086\u000e¢\u0006\u0010\n\u0002\u0010[\u001a\u0004\bW\u0010X\"\u0004\bY\u0010Z¨\u0006a"}, d2 = {"Lcom/amazon/mediatailorsdk/AdData;", "Lcom/amazon/mediatailorsdk/AdDataCommon;", ViewProps.START, "", "startDate", "duration", "skipOffset", "playCount", "", "availId", "", "availAdIndex", "availAdCount", "availStart", "availDuration", "availMarkedDuration", "inAvailStartOffset", "videoClickThrough", "quartileEventOffsets", "", "adId", "adParameters", "adSystem", "adTitle", "adVerifications", "Lcom/amazon/mediatailorsdk/AdData$AdVerification;", "icons", "Lcom/amazon/mediatailorsdk/AdData$Icon;", "companionAds", "Lcom/amazon/mediatailorsdk/AdData$CompanionAd;", "creativeId", "creativeSequence", "extensions", "Lcom/amazon/mediatailorsdk/AdData$Extension;", "trackingEvents", "Lcom/amazon/mediatailorsdk/AdData$TrackingEvent;", "adBreakTrackingEvents", "Lcom/amazon/mediatailorsdk/AdBreakTrackingEvent;", "vastAdId", "<init>", "(DDDDILjava/lang/String;IILjava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;[Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Lcom/amazon/mediatailorsdk/AdData$AdVerification;[Lcom/amazon/mediatailorsdk/AdData$Icon;[Lcom/amazon/mediatailorsdk/AdData$CompanionAd;Ljava/lang/String;Ljava/lang/String;[Lcom/amazon/mediatailorsdk/AdData$Extension;[Lcom/amazon/mediatailorsdk/AdData$TrackingEvent;[Lcom/amazon/mediatailorsdk/AdBreakTrackingEvent;Ljava/lang/String;)V", "getSkipOffset", "()D", "getAvailId", "()Ljava/lang/String;", "getAvailAdIndex", "()I", "getAvailStart", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getAvailDuration", "getAvailMarkedDuration", "getInAvailStartOffset", "getVideoClickThrough", "getQuartileEventOffsets", "()[Ljava/lang/Double;", "[Ljava/lang/Double;", "getAdId", "getAdParameters", "getAdSystem", "getAdTitle", "getCompanionAds", "()[Lcom/amazon/mediatailorsdk/AdData$CompanionAd;", "[Lcom/amazon/mediatailorsdk/AdData$CompanionAd;", "getCreativeId", "getCreativeSequence", "getExtensions", "()[Lcom/amazon/mediatailorsdk/AdData$Extension;", "[Lcom/amazon/mediatailorsdk/AdData$Extension;", "getTrackingEvents", "()[Lcom/amazon/mediatailorsdk/AdData$TrackingEvent;", "[Lcom/amazon/mediatailorsdk/AdData$TrackingEvent;", "getAdBreakTrackingEvents", "()[Lcom/amazon/mediatailorsdk/AdBreakTrackingEvent;", "[Lcom/amazon/mediatailorsdk/AdBreakTrackingEvent;", "getVastAdId", "value", "getPlayCount", "setPlayCount$MediaTailor_release", "(I)V", "getAvailAdCount", "setAvailAdCount$MediaTailor_release", "getAdVerifications", "()[Lcom/amazon/mediatailorsdk/AdData$AdVerification;", "setAdVerifications$MediaTailor_release", "([Lcom/amazon/mediatailorsdk/AdData$AdVerification;)V", "[Lcom/amazon/mediatailorsdk/AdData$AdVerification;", "getIcons", "()[Lcom/amazon/mediatailorsdk/AdData$Icon;", "setIcons$MediaTailor_release", "([Lcom/amazon/mediatailorsdk/AdData$Icon;)V", "[Lcom/amazon/mediatailorsdk/AdData$Icon;", "AdVerification", "Icon", "CompanionAd", "Extension", "TrackingEvent", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AdData extends AdDataCommon {
    private final AdBreakTrackingEvent[] adBreakTrackingEvents;
    private final String adId;
    private final String adParameters;
    private final String adSystem;
    private final String adTitle;
    private AdVerification[] adVerifications;
    private int availAdCount;
    private final int availAdIndex;
    private final Double availDuration;
    private final String availId;
    private final Double availMarkedDuration;
    private final Double availStart;
    private final CompanionAd[] companionAds;
    private final String creativeId;
    private final String creativeSequence;
    private final Extension[] extensions;
    private Icon[] icons;
    private final Double inAvailStartOffset;
    private int playCount;
    private final Double[] quartileEventOffsets;
    private final double skipOffset;
    private final TrackingEvent[] trackingEvents;
    private final String vastAdId;
    private final String videoClickThrough;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdData(double d, double d2, double d3, double d4, int i, String availId, int i2, int i3, Double d5, Double d6, Double d7, Double d8, String str, Double[] dArr, String str2, String str3, String str4, String str5, AdVerification[] adVerificationArr, Icon[] iconArr, CompanionAd[] companionAdArr, String str6, String str7, Extension[] extensionArr, TrackingEvent[] trackingEventArr, AdBreakTrackingEvent[] adBreakTrackingEventArr, String str8) {
        super(d, d2, d3);
        Intrinsics.checkNotNullParameter(availId, "availId");
        this.skipOffset = d4;
        this.availId = availId;
        this.availAdIndex = i2;
        this.availStart = d5;
        this.availDuration = d6;
        this.availMarkedDuration = d7;
        this.inAvailStartOffset = d8;
        this.videoClickThrough = str;
        this.quartileEventOffsets = dArr;
        this.adId = str2;
        this.adParameters = str3;
        this.adSystem = str4;
        this.adTitle = str5;
        this.companionAds = companionAdArr;
        this.creativeId = str6;
        this.creativeSequence = str7;
        this.extensions = extensionArr;
        this.trackingEvents = trackingEventArr;
        this.adBreakTrackingEvents = adBreakTrackingEventArr;
        this.vastAdId = str8;
        this.playCount = i;
        this.availAdCount = i3;
        this.adVerifications = adVerificationArr;
        this.icons = iconArr;
    }

    public final double getSkipOffset() {
        return this.skipOffset;
    }

    public final String getAvailId() {
        return this.availId;
    }

    public final int getAvailAdIndex() {
        return this.availAdIndex;
    }

    public final Double getAvailStart() {
        return this.availStart;
    }

    public final Double getAvailDuration() {
        return this.availDuration;
    }

    public final Double getAvailMarkedDuration() {
        return this.availMarkedDuration;
    }

    public final Double getInAvailStartOffset() {
        return this.inAvailStartOffset;
    }

    public final String getVideoClickThrough() {
        return this.videoClickThrough;
    }

    public final Double[] getQuartileEventOffsets() {
        return this.quartileEventOffsets;
    }

    public final String getAdId() {
        return this.adId;
    }

    public final String getAdParameters() {
        return this.adParameters;
    }

    public final String getAdSystem() {
        return this.adSystem;
    }

    public final String getAdTitle() {
        return this.adTitle;
    }

    public final CompanionAd[] getCompanionAds() {
        return this.companionAds;
    }

    public final String getCreativeId() {
        return this.creativeId;
    }

    public final String getCreativeSequence() {
        return this.creativeSequence;
    }

    public final Extension[] getExtensions() {
        return this.extensions;
    }

    public final TrackingEvent[] getTrackingEvents() {
        return this.trackingEvents;
    }

    public final AdBreakTrackingEvent[] getAdBreakTrackingEvents() {
        return this.adBreakTrackingEvents;
    }

    public final String getVastAdId() {
        return this.vastAdId;
    }

    public final int getPlayCount() {
        return this.playCount;
    }

    public final void setPlayCount$MediaTailor_release(int i) {
        this.playCount = i;
    }

    public final int getAvailAdCount() {
        return this.availAdCount;
    }

    public final void setAvailAdCount$MediaTailor_release(int i) {
        this.availAdCount = i;
    }

    public final AdVerification[] getAdVerifications() {
        return this.adVerifications;
    }

    public final void setAdVerifications$MediaTailor_release(AdVerification[] adVerificationArr) {
        this.adVerifications = adVerificationArr;
    }

    public final Icon[] getIcons() {
        return this.icons;
    }

    /* JADX INFO: compiled from: AdData.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 52\u00020\u0001:\u000512345B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B_\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0002\u0010\u0012J%\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0001¢\u0006\u0002\b0R6\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R6\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00072\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR6\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00072\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R(\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R(\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010$\"\u0004\b(\u0010&¨\u00066"}, d2 = {"Lcom/amazon/mediatailorsdk/AdData$AdVerification;", "", "<init>", "()V", "seen0", "", "executableResource", "", "Lcom/amazon/mediatailorsdk/AdData$AdVerification$ExecutableResource;", "javaScriptResource", "Lcom/amazon/mediatailorsdk/AdData$AdVerification$JavaScriptResource;", "trackingEvents", "Lcom/amazon/mediatailorsdk/AdData$AdVerification$TrackingEvent;", "vendor", "", "verificationParameters", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(I[Lcom/amazon/mediatailorsdk/AdData$AdVerification$ExecutableResource;[Lcom/amazon/mediatailorsdk/AdData$AdVerification$JavaScriptResource;[Lcom/amazon/mediatailorsdk/AdData$AdVerification$TrackingEvent;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "value", "getExecutableResource", "()[Lcom/amazon/mediatailorsdk/AdData$AdVerification$ExecutableResource;", "setExecutableResource$MediaTailor_release", "([Lcom/amazon/mediatailorsdk/AdData$AdVerification$ExecutableResource;)V", "[Lcom/amazon/mediatailorsdk/AdData$AdVerification$ExecutableResource;", "getJavaScriptResource", "()[Lcom/amazon/mediatailorsdk/AdData$AdVerification$JavaScriptResource;", "setJavaScriptResource$MediaTailor_release", "([Lcom/amazon/mediatailorsdk/AdData$AdVerification$JavaScriptResource;)V", "[Lcom/amazon/mediatailorsdk/AdData$AdVerification$JavaScriptResource;", "getTrackingEvents", "()[Lcom/amazon/mediatailorsdk/AdData$AdVerification$TrackingEvent;", "setTrackingEvents$MediaTailor_release", "([Lcom/amazon/mediatailorsdk/AdData$AdVerification$TrackingEvent;)V", "[Lcom/amazon/mediatailorsdk/AdData$AdVerification$TrackingEvent;", "getVendor", "()Ljava/lang/String;", "setVendor$MediaTailor_release", "(Ljava/lang/String;)V", "getVerificationParameters", "setVerificationParameters$MediaTailor_release", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$MediaTailor_release", "ExecutableResource", "JavaScriptResource", "TrackingEvent", "$serializer", "Companion", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @Serializable
    public static final class AdVerification {
        private ExecutableResource[] executableResource;
        private JavaScriptResource[] javaScriptResource;
        private TrackingEvent[] trackingEvents;
        private String vendor;
        private String verificationParameters;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.amazon.mediatailorsdk.AdData$AdVerification$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AdData.AdVerification._childSerializers$_anonymous_();
            }
        }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.amazon.mediatailorsdk.AdData$AdVerification$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AdData.AdVerification._childSerializers$_anonymous_$0();
            }
        }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.amazon.mediatailorsdk.AdData$AdVerification$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AdData.AdVerification._childSerializers$_anonymous_$1();
            }
        }), null, null};

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new ReferenceArraySerializer(Reflection.getOrCreateKotlinClass(ExecutableResource.class), AdData$AdVerification$ExecutableResource$$serializer.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
            return new ReferenceArraySerializer(Reflection.getOrCreateKotlinClass(JavaScriptResource.class), AdData$AdVerification$JavaScriptResource$$serializer.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
            return new ReferenceArraySerializer(Reflection.getOrCreateKotlinClass(TrackingEvent.class), AdData$AdVerification$TrackingEvent$$serializer.INSTANCE);
        }

        /* JADX INFO: compiled from: AdData.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/amazon/mediatailorsdk/AdData$AdVerification$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/amazon/mediatailorsdk/AdData$AdVerification;", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<AdVerification> serializer() {
                return AdData$AdVerification$$serializer.INSTANCE;
            }
        }

        public AdVerification() {
        }

        public /* synthetic */ AdVerification(int i, ExecutableResource[] executableResourceArr, JavaScriptResource[] javaScriptResourceArr, TrackingEvent[] trackingEventArr, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 1) == 0) {
                this.executableResource = null;
            } else {
                this.executableResource = executableResourceArr;
            }
            if ((i & 2) == 0) {
                this.javaScriptResource = null;
            } else {
                this.javaScriptResource = javaScriptResourceArr;
            }
            if ((i & 4) == 0) {
                this.trackingEvents = null;
            } else {
                this.trackingEvents = trackingEventArr;
            }
            if ((i & 8) == 0) {
                this.vendor = null;
            } else {
                this.vendor = str;
            }
            if ((i & 16) == 0) {
                this.verificationParameters = null;
            } else {
                this.verificationParameters = str2;
            }
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$MediaTailor_release(AdVerification self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.executableResource != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, lazyArr[0].getValue(), self.executableResource);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.javaScriptResource != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, lazyArr[1].getValue(), self.javaScriptResource);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.trackingEvents != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, lazyArr[2].getValue(), self.trackingEvents);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.vendor != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.vendor);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 4) && self.verificationParameters == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.verificationParameters);
        }

        public final ExecutableResource[] getExecutableResource() {
            return this.executableResource;
        }

        public final void setExecutableResource$MediaTailor_release(ExecutableResource[] executableResourceArr) {
            this.executableResource = executableResourceArr;
        }

        public final JavaScriptResource[] getJavaScriptResource() {
            return this.javaScriptResource;
        }

        public final void setJavaScriptResource$MediaTailor_release(JavaScriptResource[] javaScriptResourceArr) {
            this.javaScriptResource = javaScriptResourceArr;
        }

        public final TrackingEvent[] getTrackingEvents() {
            return this.trackingEvents;
        }

        public final void setTrackingEvents$MediaTailor_release(TrackingEvent[] trackingEventArr) {
            this.trackingEvents = trackingEventArr;
        }

        public final String getVendor() {
            return this.vendor;
        }

        public final void setVendor$MediaTailor_release(String str) {
            this.vendor = str;
        }

        /* JADX INFO: compiled from: AdData.kt */
        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0002!\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003BC\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0002\u0010\rJ%\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0001¢\u0006\u0002\b R(\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R(\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R(\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R(\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012¨\u0006#"}, d2 = {"Lcom/amazon/mediatailorsdk/AdData$AdVerification$ExecutableResource;", "", "<init>", "()V", "seen0", "", "apiFramework", "", DDTags.LANGUAGE_TAG_KEY, "type", "uri", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "value", "getApiFramework", "()Ljava/lang/String;", "setApiFramework$MediaTailor_release", "(Ljava/lang/String;)V", "getLanguage", "setLanguage$MediaTailor_release", "getType", "setType$MediaTailor_release", "getUri", "setUri$MediaTailor_release", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$MediaTailor_release", "$serializer", "Companion", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
        @Serializable
        public static final class ExecutableResource {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private String apiFramework;
            private String language;
            private String type;
            private String uri;

            /* JADX INFO: compiled from: AdData.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/amazon/mediatailorsdk/AdData$AdVerification$ExecutableResource$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/amazon/mediatailorsdk/AdData$AdVerification$ExecutableResource;", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<ExecutableResource> serializer() {
                    return AdData$AdVerification$ExecutableResource$$serializer.INSTANCE;
                }
            }

            public ExecutableResource() {
            }

            public /* synthetic */ ExecutableResource(int i, String str, String str2, String str3, String str4, SerializationConstructorMarker serializationConstructorMarker) {
                if ((i & 1) == 0) {
                    this.apiFramework = null;
                } else {
                    this.apiFramework = str;
                }
                if ((i & 2) == 0) {
                    this.language = null;
                } else {
                    this.language = str2;
                }
                if ((i & 4) == 0) {
                    this.type = null;
                } else {
                    this.type = str3;
                }
                if ((i & 8) == 0) {
                    this.uri = null;
                } else {
                    this.uri = str4;
                }
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$MediaTailor_release(ExecutableResource self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.apiFramework != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.apiFramework);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.language != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.language);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.type != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.type);
                }
                if (!output.shouldEncodeElementDefault(serialDesc, 3) && self.uri == null) {
                    return;
                }
                output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.uri);
            }

            public final String getApiFramework() {
                return this.apiFramework;
            }

            public final void setApiFramework$MediaTailor_release(String str) {
                this.apiFramework = str;
            }

            public final String getLanguage() {
                return this.language;
            }

            public final void setLanguage$MediaTailor_release(String str) {
                this.language = str;
            }

            public final String getType() {
                return this.type;
            }

            public final void setType$MediaTailor_release(String str) {
                this.type = str;
            }

            public final String getUri() {
                return this.uri;
            }

            public final void setUri$MediaTailor_release(String str) {
                this.uri = str;
            }
        }

        public final String getVerificationParameters() {
            return this.verificationParameters;
        }

        public final void setVerificationParameters$MediaTailor_release(String str) {
            this.verificationParameters = str;
        }

        /* JADX INFO: compiled from: AdData.kt */
        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003B9\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0002\u0010\fJ%\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0001¢\u0006\u0002\b\u001dR(\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R(\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R(\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011¨\u0006 "}, d2 = {"Lcom/amazon/mediatailorsdk/AdData$AdVerification$JavaScriptResource;", "", "<init>", "()V", "seen0", "", "apiFramework", "", "browserOptional", "uri", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "value", "getApiFramework", "()Ljava/lang/String;", "setApiFramework$MediaTailor_release", "(Ljava/lang/String;)V", "getBrowserOptional", "setBrowserOptional$MediaTailor_release", "getUri", "setUri$MediaTailor_release", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$MediaTailor_release", "$serializer", "Companion", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
        @Serializable
        public static final class JavaScriptResource {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private String apiFramework;
            private String browserOptional;
            private String uri;

            /* JADX INFO: compiled from: AdData.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/amazon/mediatailorsdk/AdData$AdVerification$JavaScriptResource$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/amazon/mediatailorsdk/AdData$AdVerification$JavaScriptResource;", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<JavaScriptResource> serializer() {
                    return AdData$AdVerification$JavaScriptResource$$serializer.INSTANCE;
                }
            }

            public JavaScriptResource() {
            }

            public /* synthetic */ JavaScriptResource(int i, String str, String str2, String str3, SerializationConstructorMarker serializationConstructorMarker) {
                if ((i & 1) == 0) {
                    this.apiFramework = null;
                } else {
                    this.apiFramework = str;
                }
                if ((i & 2) == 0) {
                    this.browserOptional = null;
                } else {
                    this.browserOptional = str2;
                }
                if ((i & 4) == 0) {
                    this.uri = null;
                } else {
                    this.uri = str3;
                }
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$MediaTailor_release(JavaScriptResource self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.apiFramework != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.apiFramework);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.browserOptional != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.browserOptional);
                }
                if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.uri == null) {
                    return;
                }
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.uri);
            }

            public final String getApiFramework() {
                return this.apiFramework;
            }

            public final void setApiFramework$MediaTailor_release(String str) {
                this.apiFramework = str;
            }

            public final String getBrowserOptional() {
                return this.browserOptional;
            }

            public final void setBrowserOptional$MediaTailor_release(String str) {
                this.browserOptional = str;
            }

            public final String getUri() {
                return this.uri;
            }

            public final void setUri$MediaTailor_release(String str) {
                this.uri = str;
            }
        }

        /* JADX INFO: compiled from: AdData.kt */
        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001b\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003B/\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0002\u0010\u000bJ%\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0001¢\u0006\u0002\b\u001aR(\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/amazon/mediatailorsdk/AdData$AdVerification$TrackingEvent;", "", "<init>", "()V", "seen0", "", "event", "", "uri", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "value", "getEvent", "()Ljava/lang/String;", "setEvent$MediaTailor_release", "(Ljava/lang/String;)V", "getUri", "setUri$MediaTailor_release", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$MediaTailor_release", "$serializer", "Companion", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
        @Serializable
        public static final class TrackingEvent {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private String event;
            private String uri;

            /* JADX INFO: compiled from: AdData.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/amazon/mediatailorsdk/AdData$AdVerification$TrackingEvent$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/amazon/mediatailorsdk/AdData$AdVerification$TrackingEvent;", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<TrackingEvent> serializer() {
                    return AdData$AdVerification$TrackingEvent$$serializer.INSTANCE;
                }
            }

            public TrackingEvent() {
            }

            public /* synthetic */ TrackingEvent(int i, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
                if ((i & 1) == 0) {
                    this.event = null;
                } else {
                    this.event = str;
                }
                if ((i & 2) == 0) {
                    this.uri = null;
                } else {
                    this.uri = str2;
                }
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$MediaTailor_release(TrackingEvent self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.event != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.event);
                }
                if (!output.shouldEncodeElementDefault(serialDesc, 1) && self.uri == null) {
                    return;
                }
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.uri);
            }

            public final String getEvent() {
                return this.event;
            }

            public final void setEvent$MediaTailor_release(String str) {
                this.event = str;
            }

            public final String getUri() {
                return this.uri;
            }

            public final void setUri$MediaTailor_release(String str) {
                this.uri = str;
            }
        }
    }

    public final void setIcons$MediaTailor_release(Icon[] iconArr) {
        this.icons = iconArr;
    }

    /* JADX INFO: compiled from: AdData.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 E2\u00020\u0001:\u0005ABCDEB\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0099\u0001\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0002\u0010\u0018J%\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u00002\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0001¢\u0006\u0002\b@R(\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR(\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001dR(\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR(\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR(\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001b\"\u0004\b%\u0010\u001dR(\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001b\"\u0004\b'\u0010\u001dR(\u0010\r\u001a\u0004\u0018\u00010\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010\u001dR(\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001b\"\u0004\b+\u0010\u001dR(\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001b\"\u0004\b-\u0010\u001dR(\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001b\"\u0004\b/\u0010\u001dR6\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012@@X\u0086\u000e¢\u0006\u0010\n\u0002\u00104\u001a\u0004\b0\u00101\"\u0004\b2\u00103R(\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u0015@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u0006F"}, d2 = {"Lcom/amazon/mediatailorsdk/AdData$Icon;", "", "<init>", "()V", "seen0", "", "program", "", ViewProps.WIDTH, ViewProps.HEIGHT, "xPosition", "yPosition", "apiFramework", "duration", "offset", "pxratio", "staticResource", "staticResources", "", "Lcom/amazon/mediatailorsdk/AdData$Icon$StaticResource;", "iconClicks", "Lcom/amazon/mediatailorsdk/AdData$Icon$IconClicks;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Lcom/amazon/mediatailorsdk/AdData$Icon$StaticResource;Lcom/amazon/mediatailorsdk/AdData$Icon$IconClicks;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "value", "getProgram", "()Ljava/lang/String;", "setProgram$MediaTailor_release", "(Ljava/lang/String;)V", "getWidth", "setWidth$MediaTailor_release", "getHeight", "setHeight$MediaTailor_release", "getXPosition", "setXPosition$MediaTailor_release", "getYPosition", "setYPosition$MediaTailor_release", "getApiFramework", "setApiFramework$MediaTailor_release", "getDuration", "setDuration$MediaTailor_release", "getOffset", "setOffset$MediaTailor_release", "getPxratio", "setPxratio$MediaTailor_release", "getStaticResource", "setStaticResource$MediaTailor_release", "getStaticResources", "()[Lcom/amazon/mediatailorsdk/AdData$Icon$StaticResource;", "setStaticResources$MediaTailor_release", "([Lcom/amazon/mediatailorsdk/AdData$Icon$StaticResource;)V", "[Lcom/amazon/mediatailorsdk/AdData$Icon$StaticResource;", "getIconClicks", "()Lcom/amazon/mediatailorsdk/AdData$Icon$IconClicks;", "setIconClicks$MediaTailor_release", "(Lcom/amazon/mediatailorsdk/AdData$Icon$IconClicks;)V", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$MediaTailor_release", "StaticResource", "IconClicks", "IconClickFallbackImage", "$serializer", "Companion", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @Serializable
    public static final class Icon {
        private String apiFramework;
        private String duration;
        private String height;
        private IconClicks iconClicks;
        private String offset;
        private String program;
        private String pxratio;
        private String staticResource;
        private StaticResource[] staticResources;
        private String width;
        private String xPosition;
        private String yPosition;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.amazon.mediatailorsdk.AdData$Icon$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AdData.Icon._childSerializers$_anonymous_();
            }
        }), null};

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new ReferenceArraySerializer(Reflection.getOrCreateKotlinClass(StaticResource.class), AdData$Icon$StaticResource$$serializer.INSTANCE);
        }

        /* JADX INFO: compiled from: AdData.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/amazon/mediatailorsdk/AdData$Icon$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/amazon/mediatailorsdk/AdData$Icon;", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Icon> serializer() {
                return AdData$Icon$$serializer.INSTANCE;
            }
        }

        public Icon() {
        }

        public /* synthetic */ Icon(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, StaticResource[] staticResourceArr, IconClicks iconClicks, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 1) == 0) {
                this.program = null;
            } else {
                this.program = str;
            }
            if ((i & 2) == 0) {
                this.width = null;
            } else {
                this.width = str2;
            }
            if ((i & 4) == 0) {
                this.height = null;
            } else {
                this.height = str3;
            }
            if ((i & 8) == 0) {
                this.xPosition = null;
            } else {
                this.xPosition = str4;
            }
            if ((i & 16) == 0) {
                this.yPosition = null;
            } else {
                this.yPosition = str5;
            }
            if ((i & 32) == 0) {
                this.apiFramework = null;
            } else {
                this.apiFramework = str6;
            }
            if ((i & 64) == 0) {
                this.duration = null;
            } else {
                this.duration = str7;
            }
            if ((i & 128) == 0) {
                this.offset = null;
            } else {
                this.offset = str8;
            }
            if ((i & 256) == 0) {
                this.pxratio = null;
            } else {
                this.pxratio = str9;
            }
            if ((i & 512) == 0) {
                this.staticResource = null;
            } else {
                this.staticResource = str10;
            }
            if ((i & 1024) == 0) {
                this.staticResources = null;
            } else {
                this.staticResources = staticResourceArr;
            }
            if ((i & 2048) == 0) {
                this.iconClicks = null;
            } else {
                this.iconClicks = iconClicks;
            }
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$MediaTailor_release(Icon self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.program != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.program);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.width != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.width);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.height != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.height);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.xPosition != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.xPosition);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.yPosition != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.yPosition);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.apiFramework != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.apiFramework);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.duration != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.duration);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 7) || self.offset != null) {
                output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.offset);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 8) || self.pxratio != null) {
                output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.pxratio);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 9) || self.staticResource != null) {
                output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.staticResource);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 10) || self.staticResources != null) {
                output.encodeNullableSerializableElement(serialDesc, 10, lazyArr[10].getValue(), self.staticResources);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 11) && self.iconClicks == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 11, AdData$Icon$IconClicks$$serializer.INSTANCE, self.iconClicks);
        }

        public final String getProgram() {
            return this.program;
        }

        public final void setProgram$MediaTailor_release(String str) {
            this.program = str;
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

        public final String getXPosition() {
            return this.xPosition;
        }

        public final void setXPosition$MediaTailor_release(String str) {
            this.xPosition = str;
        }

        public final String getYPosition() {
            return this.yPosition;
        }

        public final void setYPosition$MediaTailor_release(String str) {
            this.yPosition = str;
        }

        public final String getApiFramework() {
            return this.apiFramework;
        }

        public final void setApiFramework$MediaTailor_release(String str) {
            this.apiFramework = str;
        }

        public final String getDuration() {
            return this.duration;
        }

        public final void setDuration$MediaTailor_release(String str) {
            this.duration = str;
        }

        public final String getOffset() {
            return this.offset;
        }

        public final void setOffset$MediaTailor_release(String str) {
            this.offset = str;
        }

        public final String getPxratio() {
            return this.pxratio;
        }

        public final void setPxratio$MediaTailor_release(String str) {
            this.pxratio = str;
        }

        public final String getStaticResource() {
            return this.staticResource;
        }

        public final void setStaticResource$MediaTailor_release(String str) {
            this.staticResource = str;
        }

        public final StaticResource[] getStaticResources() {
            return this.staticResources;
        }

        public final void setStaticResources$MediaTailor_release(StaticResource[] staticResourceArr) {
            this.staticResources = staticResourceArr;
        }

        /* JADX INFO: compiled from: AdData.kt */
        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001b\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003B/\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0002\u0010\u000bJ%\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0001¢\u0006\u0002\b\u001aR(\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/amazon/mediatailorsdk/AdData$Icon$StaticResource;", "", "<init>", "()V", "seen0", "", "creativeType", "", "uri", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "value", "getCreativeType", "()Ljava/lang/String;", "setCreativeType$MediaTailor_release", "(Ljava/lang/String;)V", "getUri", "setUri$MediaTailor_release", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$MediaTailor_release", "$serializer", "Companion", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
        @Serializable
        public static final class StaticResource {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private String creativeType;
            private String uri;

            /* JADX INFO: compiled from: AdData.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/amazon/mediatailorsdk/AdData$Icon$StaticResource$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/amazon/mediatailorsdk/AdData$Icon$StaticResource;", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<StaticResource> serializer() {
                    return AdData$Icon$StaticResource$$serializer.INSTANCE;
                }
            }

            public StaticResource() {
            }

            public /* synthetic */ StaticResource(int i, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
                if ((i & 1) == 0) {
                    this.creativeType = null;
                } else {
                    this.creativeType = str;
                }
                if ((i & 2) == 0) {
                    this.uri = null;
                } else {
                    this.uri = str2;
                }
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$MediaTailor_release(StaticResource self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.creativeType != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.creativeType);
                }
                if (!output.shouldEncodeElementDefault(serialDesc, 1) && self.uri == null) {
                    return;
                }
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.uri);
            }

            public final String getCreativeType() {
                return this.creativeType;
            }

            public final void setCreativeType$MediaTailor_release(String str) {
                this.creativeType = str;
            }

            public final String getUri() {
                return this.uri;
            }

            public final void setUri$MediaTailor_release(String str) {
                this.uri = str;
            }
        }

        public final IconClicks getIconClicks() {
            return this.iconClicks;
        }

        public final void setIconClicks$MediaTailor_release(IconClicks iconClicks) {
            this.iconClicks = iconClicks;
        }

        /* JADX INFO: compiled from: AdData.kt */
        @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 !2\u00020\u0001:\u0002 !B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B5\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0002\u0010\rJ%\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0001¢\u0006\u0002\b\u001fR(\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R6\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t@@X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lcom/amazon/mediatailorsdk/AdData$Icon$IconClicks;", "", "<init>", "()V", "seen0", "", "iconClickThrough", "", "iconClickFallbackImages", "", "Lcom/amazon/mediatailorsdk/AdData$Icon$IconClickFallbackImage;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;[Lcom/amazon/mediatailorsdk/AdData$Icon$IconClickFallbackImage;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "value", "getIconClickThrough", "()Ljava/lang/String;", "setIconClickThrough$MediaTailor_release", "(Ljava/lang/String;)V", "getIconClickFallbackImages", "()[Lcom/amazon/mediatailorsdk/AdData$Icon$IconClickFallbackImage;", "setIconClickFallbackImages$MediaTailor_release", "([Lcom/amazon/mediatailorsdk/AdData$Icon$IconClickFallbackImage;)V", "[Lcom/amazon/mediatailorsdk/AdData$Icon$IconClickFallbackImage;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$MediaTailor_release", "$serializer", "Companion", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
        @Serializable
        public static final class IconClicks {
            private IconClickFallbackImage[] iconClickFallbackImages;
            private String iconClickThrough;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.amazon.mediatailorsdk.AdData$Icon$IconClicks$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AdData.Icon.IconClicks._childSerializers$_anonymous_();
                }
            })};

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                return new ReferenceArraySerializer(Reflection.getOrCreateKotlinClass(IconClickFallbackImage.class), AdData$Icon$IconClickFallbackImage$$serializer.INSTANCE);
            }

            /* JADX INFO: compiled from: AdData.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/amazon/mediatailorsdk/AdData$Icon$IconClicks$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/amazon/mediatailorsdk/AdData$Icon$IconClicks;", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<IconClicks> serializer() {
                    return AdData$Icon$IconClicks$$serializer.INSTANCE;
                }
            }

            public IconClicks() {
            }

            public /* synthetic */ IconClicks(int i, String str, IconClickFallbackImage[] iconClickFallbackImageArr, SerializationConstructorMarker serializationConstructorMarker) {
                if ((i & 1) == 0) {
                    this.iconClickThrough = null;
                } else {
                    this.iconClickThrough = str;
                }
                if ((i & 2) == 0) {
                    this.iconClickFallbackImages = null;
                } else {
                    this.iconClickFallbackImages = iconClickFallbackImageArr;
                }
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$MediaTailor_release(IconClicks self, CompositeEncoder output, SerialDescriptor serialDesc) {
                Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.iconClickThrough != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.iconClickThrough);
                }
                if (!output.shouldEncodeElementDefault(serialDesc, 1) && self.iconClickFallbackImages == null) {
                    return;
                }
                output.encodeNullableSerializableElement(serialDesc, 1, lazyArr[1].getValue(), self.iconClickFallbackImages);
            }

            public final String getIconClickThrough() {
                return this.iconClickThrough;
            }

            public final void setIconClickThrough$MediaTailor_release(String str) {
                this.iconClickThrough = str;
            }

            public final IconClickFallbackImage[] getIconClickFallbackImages() {
                return this.iconClickFallbackImages;
            }

            public final void setIconClickFallbackImages$MediaTailor_release(IconClickFallbackImage[] iconClickFallbackImageArr) {
                this.iconClickFallbackImages = iconClickFallbackImageArr;
            }
        }

        /* JADX INFO: compiled from: AdData.kt */
        @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 *2\u00020\u0001:\u0002)*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003BS\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0002\u0010\u0010J%\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0001¢\u0006\u0002\b(R(\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R(\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R(\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R(\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R6\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f@@X\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006+"}, d2 = {"Lcom/amazon/mediatailorsdk/AdData$Icon$IconClickFallbackImage;", "", "<init>", "()V", "seen0", "", ViewProps.WIDTH, "", ViewProps.HEIGHT, "altText", "staticResource", "staticResources", "", "Lcom/amazon/mediatailorsdk/AdData$Icon$StaticResource;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Lcom/amazon/mediatailorsdk/AdData$Icon$StaticResource;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "value", "getWidth", "()Ljava/lang/String;", "setWidth$MediaTailor_release", "(Ljava/lang/String;)V", "getHeight", "setHeight$MediaTailor_release", "getAltText", "setAltText$MediaTailor_release", "getStaticResource", "setStaticResource$MediaTailor_release", "getStaticResources", "()[Lcom/amazon/mediatailorsdk/AdData$Icon$StaticResource;", "setStaticResources$MediaTailor_release", "([Lcom/amazon/mediatailorsdk/AdData$Icon$StaticResource;)V", "[Lcom/amazon/mediatailorsdk/AdData$Icon$StaticResource;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$MediaTailor_release", "$serializer", "Companion", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
        @Serializable
        public static final class IconClickFallbackImage {
            private String altText;
            private String height;
            private String staticResource;
            private StaticResource[] staticResources;
            private String width;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.amazon.mediatailorsdk.AdData$Icon$IconClickFallbackImage$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AdData.Icon.IconClickFallbackImage._childSerializers$_anonymous_();
                }
            })};

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                return new ReferenceArraySerializer(Reflection.getOrCreateKotlinClass(StaticResource.class), AdData$Icon$StaticResource$$serializer.INSTANCE);
            }

            /* JADX INFO: compiled from: AdData.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/amazon/mediatailorsdk/AdData$Icon$IconClickFallbackImage$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/amazon/mediatailorsdk/AdData$Icon$IconClickFallbackImage;", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<IconClickFallbackImage> serializer() {
                    return AdData$Icon$IconClickFallbackImage$$serializer.INSTANCE;
                }
            }

            public IconClickFallbackImage() {
            }

            public /* synthetic */ IconClickFallbackImage(int i, String str, String str2, String str3, String str4, StaticResource[] staticResourceArr, SerializationConstructorMarker serializationConstructorMarker) {
                if ((i & 1) == 0) {
                    this.width = null;
                } else {
                    this.width = str;
                }
                if ((i & 2) == 0) {
                    this.height = null;
                } else {
                    this.height = str2;
                }
                if ((i & 4) == 0) {
                    this.altText = null;
                } else {
                    this.altText = str3;
                }
                if ((i & 8) == 0) {
                    this.staticResource = null;
                } else {
                    this.staticResource = str4;
                }
                if ((i & 16) == 0) {
                    this.staticResources = null;
                } else {
                    this.staticResources = staticResourceArr;
                }
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$MediaTailor_release(IconClickFallbackImage self, CompositeEncoder output, SerialDescriptor serialDesc) {
                Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.width != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.width);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.height != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.height);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.altText != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.altText);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.staticResource != null) {
                    output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.staticResource);
                }
                if (!output.shouldEncodeElementDefault(serialDesc, 4) && self.staticResources == null) {
                    return;
                }
                output.encodeNullableSerializableElement(serialDesc, 4, lazyArr[4].getValue(), self.staticResources);
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

            public final String getAltText() {
                return this.altText;
            }

            public final void setAltText$MediaTailor_release(String str) {
                this.altText = str;
            }

            public final String getStaticResource() {
                return this.staticResource;
            }

            public final void setStaticResource$MediaTailor_release(String str) {
                this.staticResource = str;
            }

            public final StaticResource[] getStaticResources() {
                return this.staticResources;
            }

            public final void setStaticResources$MediaTailor_release(StaticResource[] staticResourceArr) {
                this.staticResources = staticResourceArr;
            }
        }
    }

    /* JADX INFO: compiled from: AdData.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 >2\u00020\u0001:\u0004;<=>B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0085\u0001\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0002\u0010\u0016J%\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u00002\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0001¢\u0006\u0002\b:R(\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR(\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR(\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\n@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R(\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0019\"\u0004\b#\u0010\u001bR(\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0019\"\u0004\b%\u0010\u001bR(\u0010\r\u001a\u0004\u0018\u00010\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0019\"\u0004\b'\u0010\u001bR(\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0019\"\u0004\b)\u0010\u001bR(\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0019\"\u0004\b+\u0010\u001bR(\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0019\"\u0004\b-\u0010\u001bR6\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012@@X\u0086\u000e¢\u0006\u0010\n\u0002\u00102\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u0006?"}, d2 = {"Lcom/amazon/mediatailorsdk/AdData$CompanionAd;", "", "<init>", "()V", "seen0", "", "adParameters", "", "altText", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "Lcom/amazon/mediatailorsdk/AdData$CompanionAd$Attributes;", "companionClickThrough", "companionClickTracking", "htmlResource", "iFrameResource", "sequence", "staticResource", "trackingEvents", "", "Lcom/amazon/mediatailorsdk/AdData$CompanionAd$TrackingEvent;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lcom/amazon/mediatailorsdk/AdData$CompanionAd$Attributes;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Lcom/amazon/mediatailorsdk/AdData$CompanionAd$TrackingEvent;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "value", "getAdParameters", "()Ljava/lang/String;", "setAdParameters$MediaTailor_release", "(Ljava/lang/String;)V", "getAltText", "setAltText$MediaTailor_release", "getAttributes", "()Lcom/amazon/mediatailorsdk/AdData$CompanionAd$Attributes;", "setAttributes$MediaTailor_release", "(Lcom/amazon/mediatailorsdk/AdData$CompanionAd$Attributes;)V", "getCompanionClickThrough", "setCompanionClickThrough$MediaTailor_release", "getCompanionClickTracking", "setCompanionClickTracking$MediaTailor_release", "getHtmlResource", "setHtmlResource$MediaTailor_release", "getIFrameResource", "setIFrameResource$MediaTailor_release", "getSequence", "setSequence$MediaTailor_release", "getStaticResource", "setStaticResource$MediaTailor_release", "getTrackingEvents", "()[Lcom/amazon/mediatailorsdk/AdData$CompanionAd$TrackingEvent;", "setTrackingEvents$MediaTailor_release", "([Lcom/amazon/mediatailorsdk/AdData$CompanionAd$TrackingEvent;)V", "[Lcom/amazon/mediatailorsdk/AdData$CompanionAd$TrackingEvent;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$MediaTailor_release", "Attributes", "TrackingEvent", "$serializer", "Companion", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @Serializable
    public static final class CompanionAd {
        private String adParameters;
        private String altText;
        private Attributes attributes;
        private String companionClickThrough;
        private String companionClickTracking;
        private String htmlResource;
        private String iFrameResource;
        private String sequence;
        private String staticResource;
        private TrackingEvent[] trackingEvents;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.amazon.mediatailorsdk.AdData$CompanionAd$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AdData.CompanionAd._childSerializers$_anonymous_();
            }
        })};

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new ReferenceArraySerializer(Reflection.getOrCreateKotlinClass(TrackingEvent.class), AdData$CompanionAd$TrackingEvent$$serializer.INSTANCE);
        }

        /* JADX INFO: compiled from: AdData.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/amazon/mediatailorsdk/AdData$CompanionAd$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/amazon/mediatailorsdk/AdData$CompanionAd;", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<CompanionAd> serializer() {
                return AdData$CompanionAd$$serializer.INSTANCE;
            }
        }

        public CompanionAd() {
        }

        public /* synthetic */ CompanionAd(int i, String str, String str2, Attributes attributes, String str3, String str4, String str5, String str6, String str7, String str8, TrackingEvent[] trackingEventArr, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 1) == 0) {
                this.adParameters = null;
            } else {
                this.adParameters = str;
            }
            if ((i & 2) == 0) {
                this.altText = null;
            } else {
                this.altText = str2;
            }
            if ((i & 4) == 0) {
                this.attributes = null;
            } else {
                this.attributes = attributes;
            }
            if ((i & 8) == 0) {
                this.companionClickThrough = null;
            } else {
                this.companionClickThrough = str3;
            }
            if ((i & 16) == 0) {
                this.companionClickTracking = null;
            } else {
                this.companionClickTracking = str4;
            }
            if ((i & 32) == 0) {
                this.htmlResource = null;
            } else {
                this.htmlResource = str5;
            }
            if ((i & 64) == 0) {
                this.iFrameResource = null;
            } else {
                this.iFrameResource = str6;
            }
            if ((i & 128) == 0) {
                this.sequence = null;
            } else {
                this.sequence = str7;
            }
            if ((i & 256) == 0) {
                this.staticResource = null;
            } else {
                this.staticResource = str8;
            }
            if ((i & 512) == 0) {
                this.trackingEvents = null;
            } else {
                this.trackingEvents = trackingEventArr;
            }
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$MediaTailor_release(CompanionAd self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.adParameters != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.adParameters);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.altText != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.altText);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.attributes != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, AdData$CompanionAd$Attributes$$serializer.INSTANCE, self.attributes);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.companionClickThrough != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.companionClickThrough);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.companionClickTracking != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.companionClickTracking);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.htmlResource != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.htmlResource);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.iFrameResource != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.iFrameResource);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 7) || self.sequence != null) {
                output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.sequence);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 8) || self.staticResource != null) {
                output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.staticResource);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 9) && self.trackingEvents == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 9, lazyArr[9].getValue(), self.trackingEvents);
        }

        public final String getAdParameters() {
            return this.adParameters;
        }

        public final void setAdParameters$MediaTailor_release(String str) {
            this.adParameters = str;
        }

        public final String getAltText() {
            return this.altText;
        }

        public final void setAltText$MediaTailor_release(String str) {
            this.altText = str;
        }

        public final Attributes getAttributes() {
            return this.attributes;
        }

        public final void setAttributes$MediaTailor_release(Attributes attributes) {
            this.attributes = attributes;
        }

        public final String getCompanionClickThrough() {
            return this.companionClickThrough;
        }

        public final void setCompanionClickThrough$MediaTailor_release(String str) {
            this.companionClickThrough = str;
        }

        public final String getCompanionClickTracking() {
            return this.companionClickTracking;
        }

        public final void setCompanionClickTracking$MediaTailor_release(String str) {
            this.companionClickTracking = str;
        }

        public final String getHtmlResource() {
            return this.htmlResource;
        }

        public final void setHtmlResource$MediaTailor_release(String str) {
            this.htmlResource = str;
        }

        public final String getIFrameResource() {
            return this.iFrameResource;
        }

        public final void setIFrameResource$MediaTailor_release(String str) {
            this.iFrameResource = str;
        }

        public final String getSequence() {
            return this.sequence;
        }

        public final void setSequence$MediaTailor_release(String str) {
            this.sequence = str;
        }

        public final String getStaticResource() {
            return this.staticResource;
        }

        public final void setStaticResource$MediaTailor_release(String str) {
            this.staticResource = str;
        }

        /* JADX INFO: compiled from: AdData.kt */
        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 72\u00020\u0001:\u000267B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0089\u0001\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0002\u0010\u0014J%\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0001¢\u0006\u0002\b5R(\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R(\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R(\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R(\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R(\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\u0019R(\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0017\"\u0004\b#\u0010\u0019R(\u0010\r\u001a\u0004\u0018\u00010\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019R(\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0017\"\u0004\b'\u0010\u0019R(\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0017\"\u0004\b)\u0010\u0019R(\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0017\"\u0004\b+\u0010\u0019R(\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0017\"\u0004\b-\u0010\u0019¨\u00068"}, d2 = {"Lcom/amazon/mediatailorsdk/AdData$CompanionAd$Attributes;", "", "<init>", "()V", "seen0", "", "adSlotId", "", "apiFramework", "assetHeight", "assetWidth", "expandedHeight", "expandedWidth", ViewProps.HEIGHT, "id", "pxratio", "renderingMode", ViewProps.WIDTH, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "value", "getAdSlotId", "()Ljava/lang/String;", "setAdSlotId$MediaTailor_release", "(Ljava/lang/String;)V", "getApiFramework", "setApiFramework$MediaTailor_release", "getAssetHeight", "setAssetHeight$MediaTailor_release", "getAssetWidth", "setAssetWidth$MediaTailor_release", "getExpandedHeight", "setExpandedHeight$MediaTailor_release", "getExpandedWidth", "setExpandedWidth$MediaTailor_release", "getHeight", "setHeight$MediaTailor_release", "getId", "setId$MediaTailor_release", "getPxratio", "setPxratio$MediaTailor_release", "getRenderingMode", "setRenderingMode$MediaTailor_release", "getWidth", "setWidth$MediaTailor_release", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$MediaTailor_release", "$serializer", "Companion", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
        @Serializable
        public static final class Attributes {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private String adSlotId;
            private String apiFramework;
            private String assetHeight;
            private String assetWidth;
            private String expandedHeight;
            private String expandedWidth;
            private String height;
            private String id;
            private String pxratio;
            private String renderingMode;
            private String width;

            /* JADX INFO: compiled from: AdData.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/amazon/mediatailorsdk/AdData$CompanionAd$Attributes$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/amazon/mediatailorsdk/AdData$CompanionAd$Attributes;", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<Attributes> serializer() {
                    return AdData$CompanionAd$Attributes$$serializer.INSTANCE;
                }
            }

            public Attributes() {
            }

            public /* synthetic */ Attributes(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, SerializationConstructorMarker serializationConstructorMarker) {
                if ((i & 1) == 0) {
                    this.adSlotId = null;
                } else {
                    this.adSlotId = str;
                }
                if ((i & 2) == 0) {
                    this.apiFramework = null;
                } else {
                    this.apiFramework = str2;
                }
                if ((i & 4) == 0) {
                    this.assetHeight = null;
                } else {
                    this.assetHeight = str3;
                }
                if ((i & 8) == 0) {
                    this.assetWidth = null;
                } else {
                    this.assetWidth = str4;
                }
                if ((i & 16) == 0) {
                    this.expandedHeight = null;
                } else {
                    this.expandedHeight = str5;
                }
                if ((i & 32) == 0) {
                    this.expandedWidth = null;
                } else {
                    this.expandedWidth = str6;
                }
                if ((i & 64) == 0) {
                    this.height = null;
                } else {
                    this.height = str7;
                }
                if ((i & 128) == 0) {
                    this.id = null;
                } else {
                    this.id = str8;
                }
                if ((i & 256) == 0) {
                    this.pxratio = null;
                } else {
                    this.pxratio = str9;
                }
                if ((i & 512) == 0) {
                    this.renderingMode = null;
                } else {
                    this.renderingMode = str10;
                }
                if ((i & 1024) == 0) {
                    this.width = null;
                } else {
                    this.width = str11;
                }
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$MediaTailor_release(Attributes self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.adSlotId != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.adSlotId);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.apiFramework != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.apiFramework);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.assetHeight != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.assetHeight);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.assetWidth != null) {
                    output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.assetWidth);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 4) || self.expandedHeight != null) {
                    output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.expandedHeight);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 5) || self.expandedWidth != null) {
                    output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.expandedWidth);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 6) || self.height != null) {
                    output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.height);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 7) || self.id != null) {
                    output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.id);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 8) || self.pxratio != null) {
                    output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.pxratio);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 9) || self.renderingMode != null) {
                    output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.renderingMode);
                }
                if (!output.shouldEncodeElementDefault(serialDesc, 10) && self.width == null) {
                    return;
                }
                output.encodeNullableSerializableElement(serialDesc, 10, StringSerializer.INSTANCE, self.width);
            }

            public final String getAdSlotId() {
                return this.adSlotId;
            }

            public final void setAdSlotId$MediaTailor_release(String str) {
                this.adSlotId = str;
            }

            public final String getApiFramework() {
                return this.apiFramework;
            }

            public final void setApiFramework$MediaTailor_release(String str) {
                this.apiFramework = str;
            }

            public final String getAssetHeight() {
                return this.assetHeight;
            }

            public final void setAssetHeight$MediaTailor_release(String str) {
                this.assetHeight = str;
            }

            public final String getAssetWidth() {
                return this.assetWidth;
            }

            public final void setAssetWidth$MediaTailor_release(String str) {
                this.assetWidth = str;
            }

            public final String getExpandedHeight() {
                return this.expandedHeight;
            }

            public final void setExpandedHeight$MediaTailor_release(String str) {
                this.expandedHeight = str;
            }

            public final String getExpandedWidth() {
                return this.expandedWidth;
            }

            public final void setExpandedWidth$MediaTailor_release(String str) {
                this.expandedWidth = str;
            }

            public final String getHeight() {
                return this.height;
            }

            public final void setHeight$MediaTailor_release(String str) {
                this.height = str;
            }

            public final String getId() {
                return this.id;
            }

            public final void setId$MediaTailor_release(String str) {
                this.id = str;
            }

            public final String getPxratio() {
                return this.pxratio;
            }

            public final void setPxratio$MediaTailor_release(String str) {
                this.pxratio = str;
            }

            public final String getRenderingMode() {
                return this.renderingMode;
            }

            public final void setRenderingMode$MediaTailor_release(String str) {
                this.renderingMode = str;
            }

            public final String getWidth() {
                return this.width;
            }

            public final void setWidth$MediaTailor_release(String str) {
                this.width = str;
            }
        }

        public final TrackingEvent[] getTrackingEvents() {
            return this.trackingEvents;
        }

        public final void setTrackingEvents$MediaTailor_release(TrackingEvent[] trackingEventArr) {
            this.trackingEvents = trackingEventArr;
        }

        /* JADX INFO: compiled from: AdData.kt */
        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000  2\u00020\u0001:\u0002\u001f B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B5\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0002\u0010\fJ%\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0001¢\u0006\u0002\b\u001eR6\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R(\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\b@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006!"}, d2 = {"Lcom/amazon/mediatailorsdk/AdData$CompanionAd$TrackingEvent;", "", "<init>", "()V", "seen0", "", "beaconUrls", "", "", MixedWebViewEventConsumer.EVENT_TYPE_KEY, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(I[Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "value", "getBeaconUrls", "()[Ljava/lang/String;", "setBeaconUrls$MediaTailor_release", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "getEventType", "()Ljava/lang/String;", "setEventType$MediaTailor_release", "(Ljava/lang/String;)V", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$MediaTailor_release", "$serializer", "Companion", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
        @Serializable
        public static final class TrackingEvent {
            private String[] beaconUrls;
            private String eventType;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.amazon.mediatailorsdk.AdData$CompanionAd$TrackingEvent$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AdData.CompanionAd.TrackingEvent._childSerializers$_anonymous_();
                }
            }), null};

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                return new ReferenceArraySerializer(Reflection.getOrCreateKotlinClass(String.class), StringSerializer.INSTANCE);
            }

            /* JADX INFO: compiled from: AdData.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/amazon/mediatailorsdk/AdData$CompanionAd$TrackingEvent$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/amazon/mediatailorsdk/AdData$CompanionAd$TrackingEvent;", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<TrackingEvent> serializer() {
                    return AdData$CompanionAd$TrackingEvent$$serializer.INSTANCE;
                }
            }

            public TrackingEvent() {
            }

            public /* synthetic */ TrackingEvent(int i, String[] strArr, String str, SerializationConstructorMarker serializationConstructorMarker) {
                if ((i & 1) == 0) {
                    this.beaconUrls = null;
                } else {
                    this.beaconUrls = strArr;
                }
                if ((i & 2) == 0) {
                    this.eventType = null;
                } else {
                    this.eventType = str;
                }
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$MediaTailor_release(TrackingEvent self, CompositeEncoder output, SerialDescriptor serialDesc) {
                Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.beaconUrls != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, lazyArr[0].getValue(), self.beaconUrls);
                }
                if (!output.shouldEncodeElementDefault(serialDesc, 1) && self.eventType == null) {
                    return;
                }
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.eventType);
            }

            public final String[] getBeaconUrls() {
                return this.beaconUrls;
            }

            public final void setBeaconUrls$MediaTailor_release(String[] strArr) {
                this.beaconUrls = strArr;
            }

            public final String getEventType() {
                return this.eventType;
            }

            public final void setEventType$MediaTailor_release(String str) {
                this.eventType = str;
            }
        }
    }

    /* JADX INFO: compiled from: AdData.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001b\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003B/\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0002\u0010\u000bJ%\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0001¢\u0006\u0002\b\u001aR(\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/amazon/mediatailorsdk/AdData$Extension;", "", "<init>", "()V", "seen0", "", "content", "", "type", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "value", "getContent", "()Ljava/lang/String;", "setContent$MediaTailor_release", "(Ljava/lang/String;)V", "getType", "setType$MediaTailor_release", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$MediaTailor_release", "$serializer", "Companion", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @Serializable
    public static final class Extension {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private String content;
        private String type;

        /* JADX INFO: compiled from: AdData.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/amazon/mediatailorsdk/AdData$Extension$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/amazon/mediatailorsdk/AdData$Extension;", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Extension> serializer() {
                return AdData$Extension$$serializer.INSTANCE;
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
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 02\u00020\u0001:\u0002/0B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B]\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0002\u0010\u0011J%\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0001¢\u0006\u0002\b.R6\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R*\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\n@@X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR(\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\b@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R(\u0010\f\u001a\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\b@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010 R(\u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\b@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R*\u0010\u000e\u001a\u0004\u0018\u00010\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\n@@X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b%\u0010\u0019\"\u0004\b&\u0010\u001b¨\u00061"}, d2 = {"Lcom/amazon/mediatailorsdk/AdData$TrackingEvent;", "", "<init>", "()V", "seen0", "", "beaconUrls", "", "", "durationInSeconds", "", "eventId", "eventProgramDateTime", MixedWebViewEventConsumer.EVENT_TYPE_KEY, "startTimeInSeconds", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(I[Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "value", "getBeaconUrls", "()[Ljava/lang/String;", "setBeaconUrls$MediaTailor_release", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "getDurationInSeconds", "()Ljava/lang/Double;", "setDurationInSeconds$MediaTailor_release", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getEventId", "()Ljava/lang/String;", "setEventId$MediaTailor_release", "(Ljava/lang/String;)V", "getEventProgramDateTime", "setEventProgramDateTime$MediaTailor_release", "getEventType", "setEventType$MediaTailor_release", "getStartTimeInSeconds", "setStartTimeInSeconds$MediaTailor_release", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$MediaTailor_release", "$serializer", "Companion", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
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
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.amazon.mediatailorsdk.AdData$TrackingEvent$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AdData.TrackingEvent._childSerializers$_anonymous_();
            }
        }), null, null, null, null, null};

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new ReferenceArraySerializer(Reflection.getOrCreateKotlinClass(String.class), StringSerializer.INSTANCE);
        }

        /* JADX INFO: compiled from: AdData.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/amazon/mediatailorsdk/AdData$TrackingEvent$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/amazon/mediatailorsdk/AdData$TrackingEvent;", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<TrackingEvent> serializer() {
                return AdData$TrackingEvent$$serializer.INSTANCE;
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
