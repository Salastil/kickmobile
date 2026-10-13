package com.amazon.mediatailorsdk.network.tracking.model;

import com.amazon.mediatailorsdk.AdBreakTrackingEvent;
import com.amazon.mediatailorsdk.AdBreakTrackingEvent$$serializer;
import com.amazon.mediatailorsdk.AdData;
import com.amazon.mediatailorsdk.AdData$AdVerification$$serializer;
import com.amazon.mediatailorsdk.AdData$CompanionAd$$serializer;
import com.amazon.mediatailorsdk.AdData$Extension$$serializer;
import com.amazon.mediatailorsdk.AdData$Icon$$serializer;
import com.amazon.mediatailorsdk.AdData$TrackingEvent$$serializer;
import com.amazon.mediatailorsdk.NonLinearAdsData;
import com.amazon.mediatailorsdk.NonLinearAdsData$Extension$$serializer;
import com.amazon.mediatailorsdk.NonLinearAdsData$NonLinearAd$$serializer;
import com.amazon.mediatailorsdk.NonLinearAdsData$TrackingEvent$$serializer;
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
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.ReferenceArraySerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: AdTrackingResponse.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 .2\u00020\u0001:\u0006)*+,-.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003BO\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0002\u0010\u0010J%\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0001¢\u0006\u0002\b(R$\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\r\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001e¨\u0006/"}, d2 = {"Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse;", "", "<init>", "()V", "seen0", "", "avails", "", "Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse$Avail;", "nonLinearAvails", "Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse$NonLinearAvail;", "dashAvailabilityStartTime", "", "nextToken", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(I[Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse$Avail;[Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse$NonLinearAvail;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAvails", "()[Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse$Avail;", "setAvails", "([Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse$Avail;)V", "[Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse$Avail;", "getNonLinearAvails", "()[Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse$NonLinearAvail;", "setNonLinearAvails", "([Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse$NonLinearAvail;)V", "[Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse$NonLinearAvail;", "getDashAvailabilityStartTime", "()Ljava/lang/String;", "setDashAvailabilityStartTime", "(Ljava/lang/String;)V", "getNextToken", "setNextToken", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$MediaTailor_release", "Avail", "Ad", "NonLinearAvail", "NonLinearAds", "$serializer", "Companion", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable
public final class AdTrackingResponse {
    private Avail[] avails;
    private String dashAvailabilityStartTime;
    private String nextToken;
    private NonLinearAvail[] nonLinearAvails;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.amazon.mediatailorsdk.network.tracking.model.AdTrackingResponse$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return AdTrackingResponse._childSerializers$_anonymous_();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.amazon.mediatailorsdk.network.tracking.model.AdTrackingResponse$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return AdTrackingResponse._childSerializers$_anonymous_$0();
        }
    }), null, null};

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ReferenceArraySerializer(Reflection.getOrCreateKotlinClass(Avail.class), AdTrackingResponse$Avail$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new ReferenceArraySerializer(Reflection.getOrCreateKotlinClass(NonLinearAvail.class), AdTrackingResponse$NonLinearAvail$$serializer.INSTANCE);
    }

    /* JADX INFO: compiled from: AdTrackingResponse.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse;", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdTrackingResponse> serializer() {
            return AdTrackingResponse$$serializer.INSTANCE;
        }
    }

    public AdTrackingResponse() {
    }

    public /* synthetic */ AdTrackingResponse(int i, Avail[] availArr, NonLinearAvail[] nonLinearAvailArr, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.avails = null;
        } else {
            this.avails = availArr;
        }
        if ((i & 2) == 0) {
            this.nonLinearAvails = null;
        } else {
            this.nonLinearAvails = nonLinearAvailArr;
        }
        if ((i & 4) == 0) {
            this.dashAvailabilityStartTime = null;
        } else {
            this.dashAvailabilityStartTime = str;
        }
        if ((i & 8) == 0) {
            this.nextToken = null;
        } else {
            this.nextToken = str2;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$MediaTailor_release(AdTrackingResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.avails != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, lazyArr[0].getValue(), self.avails);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.nonLinearAvails != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, lazyArr[1].getValue(), self.nonLinearAvails);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.dashAvailabilityStartTime != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.dashAvailabilityStartTime);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 3) && self.nextToken == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.nextToken);
    }

    public final Avail[] getAvails() {
        return this.avails;
    }

    public final void setAvails(Avail[] availArr) {
        this.avails = availArr;
    }

    public final NonLinearAvail[] getNonLinearAvails() {
        return this.nonLinearAvails;
    }

    public final void setNonLinearAvails(NonLinearAvail[] nonLinearAvailArr) {
        this.nonLinearAvails = nonLinearAvailArr;
    }

    /* JADX INFO: compiled from: AdTrackingResponse.kt */
    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 D2\u00020\u0001:\u0002CDB\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0091\u0001\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0010\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0010\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0002\u0010\u0018J%\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u00002\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AH\u0001¢\u0006\u0002\bBR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001a\"\u0004\b#\u0010\u001cR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001a\"\u0004\b%\u0010\u001cR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001a\"\u0004\b'\u0010\u001cR\u001e\u0010\r\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b(\u0010\u001e\"\u0004\b)\u0010 R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001a\"\u0004\b+\u0010\u001cR$\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u00105\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010:\u001a\u0004\b6\u00107\"\u0004\b8\u00109¨\u0006E"}, d2 = {"Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse$Avail;", "", "<init>", "()V", "seen0", "", "startTime", "", "startTimeInSeconds", "", "availProgramDateTime", "duration", "adMarkerDuration", "durationInSeconds", "availId", "ads", "", "Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse$Ad;", "nonLinearAdsList", "Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse$NonLinearAds;", "adBreakTrackingEvents", "Lcom/amazon/mediatailorsdk/AdBreakTrackingEvent;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;[Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse$Ad;[Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse$NonLinearAds;[Lcom/amazon/mediatailorsdk/AdBreakTrackingEvent;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getStartTime", "()Ljava/lang/String;", "setStartTime", "(Ljava/lang/String;)V", "getStartTimeInSeconds", "()Ljava/lang/Double;", "setStartTimeInSeconds", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getAvailProgramDateTime", "setAvailProgramDateTime", "getDuration", "setDuration", "getAdMarkerDuration", "setAdMarkerDuration", "getDurationInSeconds", "setDurationInSeconds", "getAvailId", "setAvailId", "getAds", "()[Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse$Ad;", "setAds", "([Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse$Ad;)V", "[Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse$Ad;", "getNonLinearAdsList", "()[Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse$NonLinearAds;", "setNonLinearAdsList", "([Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse$NonLinearAds;)V", "[Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse$NonLinearAds;", "getAdBreakTrackingEvents", "()[Lcom/amazon/mediatailorsdk/AdBreakTrackingEvent;", "setAdBreakTrackingEvents", "([Lcom/amazon/mediatailorsdk/AdBreakTrackingEvent;)V", "[Lcom/amazon/mediatailorsdk/AdBreakTrackingEvent;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$MediaTailor_release", "$serializer", "Companion", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @Serializable
    public static final class Avail {
        private AdBreakTrackingEvent[] adBreakTrackingEvents;
        private String adMarkerDuration;
        private Ad[] ads;
        private String availId;
        private String availProgramDateTime;
        private String duration;
        private Double durationInSeconds;
        private NonLinearAds[] nonLinearAdsList;
        private String startTime;
        private Double startTimeInSeconds;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.amazon.mediatailorsdk.network.tracking.model.AdTrackingResponse$Avail$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AdTrackingResponse.Avail._childSerializers$_anonymous_();
            }
        }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.amazon.mediatailorsdk.network.tracking.model.AdTrackingResponse$Avail$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AdTrackingResponse.Avail._childSerializers$_anonymous_$0();
            }
        }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.amazon.mediatailorsdk.network.tracking.model.AdTrackingResponse$Avail$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AdTrackingResponse.Avail._childSerializers$_anonymous_$1();
            }
        })};

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new ReferenceArraySerializer(Reflection.getOrCreateKotlinClass(Ad.class), AdTrackingResponse$Ad$$serializer.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
            return new ReferenceArraySerializer(Reflection.getOrCreateKotlinClass(NonLinearAds.class), AdTrackingResponse$NonLinearAds$$serializer.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
            return new ReferenceArraySerializer(Reflection.getOrCreateKotlinClass(AdBreakTrackingEvent.class), AdBreakTrackingEvent$$serializer.INSTANCE);
        }

        /* JADX INFO: compiled from: AdTrackingResponse.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse$Avail$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse$Avail;", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Avail> serializer() {
                return AdTrackingResponse$Avail$$serializer.INSTANCE;
            }
        }

        public Avail() {
        }

        public /* synthetic */ Avail(int i, String str, Double d, String str2, String str3, String str4, Double d2, String str5, Ad[] adArr, NonLinearAds[] nonLinearAdsArr, AdBreakTrackingEvent[] adBreakTrackingEventArr, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 1) == 0) {
                this.startTime = null;
            } else {
                this.startTime = str;
            }
            if ((i & 2) == 0) {
                this.startTimeInSeconds = null;
            } else {
                this.startTimeInSeconds = d;
            }
            if ((i & 4) == 0) {
                this.availProgramDateTime = null;
            } else {
                this.availProgramDateTime = str2;
            }
            if ((i & 8) == 0) {
                this.duration = null;
            } else {
                this.duration = str3;
            }
            if ((i & 16) == 0) {
                this.adMarkerDuration = null;
            } else {
                this.adMarkerDuration = str4;
            }
            if ((i & 32) == 0) {
                this.durationInSeconds = null;
            } else {
                this.durationInSeconds = d2;
            }
            if ((i & 64) == 0) {
                this.availId = null;
            } else {
                this.availId = str5;
            }
            if ((i & 128) == 0) {
                this.ads = null;
            } else {
                this.ads = adArr;
            }
            if ((i & 256) == 0) {
                this.nonLinearAdsList = null;
            } else {
                this.nonLinearAdsList = nonLinearAdsArr;
            }
            if ((i & 512) == 0) {
                this.adBreakTrackingEvents = null;
            } else {
                this.adBreakTrackingEvents = adBreakTrackingEventArr;
            }
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$MediaTailor_release(Avail self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.startTime != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.startTime);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.startTimeInSeconds != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, DoubleSerializer.INSTANCE, self.startTimeInSeconds);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.availProgramDateTime != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.availProgramDateTime);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.duration != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.duration);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.adMarkerDuration != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.adMarkerDuration);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.durationInSeconds != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, DoubleSerializer.INSTANCE, self.durationInSeconds);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.availId != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.availId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 7) || self.ads != null) {
                output.encodeNullableSerializableElement(serialDesc, 7, lazyArr[7].getValue(), self.ads);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 8) || self.nonLinearAdsList != null) {
                output.encodeNullableSerializableElement(serialDesc, 8, lazyArr[8].getValue(), self.nonLinearAdsList);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 9) && self.adBreakTrackingEvents == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 9, lazyArr[9].getValue(), self.adBreakTrackingEvents);
        }

        public final String getStartTime() {
            return this.startTime;
        }

        public final void setStartTime(String str) {
            this.startTime = str;
        }

        public final Double getStartTimeInSeconds() {
            return this.startTimeInSeconds;
        }

        public final void setStartTimeInSeconds(Double d) {
            this.startTimeInSeconds = d;
        }

        public final String getAvailProgramDateTime() {
            return this.availProgramDateTime;
        }

        public final void setAvailProgramDateTime(String str) {
            this.availProgramDateTime = str;
        }

        public final String getDuration() {
            return this.duration;
        }

        public final void setDuration(String str) {
            this.duration = str;
        }

        public final String getAdMarkerDuration() {
            return this.adMarkerDuration;
        }

        public final void setAdMarkerDuration(String str) {
            this.adMarkerDuration = str;
        }

        public final Double getDurationInSeconds() {
            return this.durationInSeconds;
        }

        public final void setDurationInSeconds(Double d) {
            this.durationInSeconds = d;
        }

        public final String getAvailId() {
            return this.availId;
        }

        public final void setAvailId(String str) {
            this.availId = str;
        }

        public final Ad[] getAds() {
            return this.ads;
        }

        public final void setAds(Ad[] adArr) {
            this.ads = adArr;
        }

        public final NonLinearAds[] getNonLinearAdsList() {
            return this.nonLinearAdsList;
        }

        public final void setNonLinearAdsList(NonLinearAds[] nonLinearAdsArr) {
            this.nonLinearAdsList = nonLinearAdsArr;
        }

        public final AdBreakTrackingEvent[] getAdBreakTrackingEvents() {
            return this.adBreakTrackingEvents;
        }

        public final void setAdBreakTrackingEvents(AdBreakTrackingEvent[] adBreakTrackingEventArr) {
            this.adBreakTrackingEvents = adBreakTrackingEventArr;
        }
    }

    public final String getDashAvailabilityStartTime() {
        return this.dashAvailabilityStartTime;
    }

    public final void setDashAvailabilityStartTime(String str) {
        this.dashAvailabilityStartTime = str;
    }

    public final String getNextToken() {
        return this.nextToken;
    }

    public final void setNextToken(String str) {
        this.nextToken = str;
    }

    /* JADX INFO: compiled from: AdTrackingResponse.kt */
    @Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b:\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 d2\u00020\u0001:\u0002cdB\u0007¢\u0006\u0004\b\u0002\u0010\u0003Bí\u0001\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0012\u0012\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0012\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0012\u0012\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0012\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010 \u001a\u0004\u0018\u00010!¢\u0006\u0004\b\u0002\u0010\"J%\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020\u00002\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020aH\u0001¢\u0006\u0002\bbR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010$\"\u0004\b-\u0010&R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010$\"\u0004\b/\u0010&R\u001e\u0010\f\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b0\u0010(\"\u0004\b1\u0010*R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010$\"\u0004\b3\u0010&R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010$\"\u0004\b5\u0010&R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010$\"\u0004\b7\u0010&R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010$\"\u0004\b9\u0010&R$\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010>\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R$\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010C\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR$\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010H\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010$\"\u0004\bJ\u0010&R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010$\"\u0004\bL\u0010&R$\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010Q\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR$\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010V\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010$\"\u0004\bX\u0010&R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010$\"\u0004\bZ\u0010&¨\u0006e"}, d2 = {"Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse$Ad;", "", "<init>", "()V", "seen0", "", "startTime", "", "startTimeInSeconds", "", "adProgramDateTime", "duration", "durationInSeconds", "adId", "adParameters", "adSystem", "adTitle", "adVerifications", "", "Lcom/amazon/mediatailorsdk/AdData$AdVerification;", "icons", "Lcom/amazon/mediatailorsdk/AdData$Icon;", "companionAds", "Lcom/amazon/mediatailorsdk/AdData$CompanionAd;", "creativeId", "creativeSequence", "extensions", "Lcom/amazon/mediatailorsdk/AdData$Extension;", "trackingEvents", "Lcom/amazon/mediatailorsdk/AdData$TrackingEvent;", "vastAdId", "skipOffset", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Lcom/amazon/mediatailorsdk/AdData$AdVerification;[Lcom/amazon/mediatailorsdk/AdData$Icon;[Lcom/amazon/mediatailorsdk/AdData$CompanionAd;Ljava/lang/String;Ljava/lang/String;[Lcom/amazon/mediatailorsdk/AdData$Extension;[Lcom/amazon/mediatailorsdk/AdData$TrackingEvent;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getStartTime", "()Ljava/lang/String;", "setStartTime", "(Ljava/lang/String;)V", "getStartTimeInSeconds", "()Ljava/lang/Double;", "setStartTimeInSeconds", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getAdProgramDateTime", "setAdProgramDateTime", "getDuration", "setDuration", "getDurationInSeconds", "setDurationInSeconds", "getAdId", "setAdId", "getAdParameters", "setAdParameters", "getAdSystem", "setAdSystem", "getAdTitle", "setAdTitle", "getAdVerifications", "()[Lcom/amazon/mediatailorsdk/AdData$AdVerification;", "setAdVerifications", "([Lcom/amazon/mediatailorsdk/AdData$AdVerification;)V", "[Lcom/amazon/mediatailorsdk/AdData$AdVerification;", "getIcons", "()[Lcom/amazon/mediatailorsdk/AdData$Icon;", "setIcons", "([Lcom/amazon/mediatailorsdk/AdData$Icon;)V", "[Lcom/amazon/mediatailorsdk/AdData$Icon;", "getCompanionAds", "()[Lcom/amazon/mediatailorsdk/AdData$CompanionAd;", "setCompanionAds", "([Lcom/amazon/mediatailorsdk/AdData$CompanionAd;)V", "[Lcom/amazon/mediatailorsdk/AdData$CompanionAd;", "getCreativeId", "setCreativeId", "getCreativeSequence", "setCreativeSequence", "getExtensions", "()[Lcom/amazon/mediatailorsdk/AdData$Extension;", "setExtensions", "([Lcom/amazon/mediatailorsdk/AdData$Extension;)V", "[Lcom/amazon/mediatailorsdk/AdData$Extension;", "getTrackingEvents", "()[Lcom/amazon/mediatailorsdk/AdData$TrackingEvent;", "setTrackingEvents", "([Lcom/amazon/mediatailorsdk/AdData$TrackingEvent;)V", "[Lcom/amazon/mediatailorsdk/AdData$TrackingEvent;", "getVastAdId", "setVastAdId", "getSkipOffset", "setSkipOffset", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$MediaTailor_release", "$serializer", "Companion", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @Serializable
    public static final class Ad {
        private String adId;
        private String adParameters;
        private String adProgramDateTime;
        private String adSystem;
        private String adTitle;
        private AdData.AdVerification[] adVerifications;
        private AdData.CompanionAd[] companionAds;
        private String creativeId;
        private String creativeSequence;
        private String duration;
        private Double durationInSeconds;
        private AdData.Extension[] extensions;
        private AdData.Icon[] icons;
        private String skipOffset;
        private String startTime;
        private Double startTimeInSeconds;
        private AdData.TrackingEvent[] trackingEvents;
        private String vastAdId;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.amazon.mediatailorsdk.network.tracking.model.AdTrackingResponse$Ad$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AdTrackingResponse.Ad._childSerializers$_anonymous_();
            }
        }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.amazon.mediatailorsdk.network.tracking.model.AdTrackingResponse$Ad$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AdTrackingResponse.Ad._childSerializers$_anonymous_$0();
            }
        }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.amazon.mediatailorsdk.network.tracking.model.AdTrackingResponse$Ad$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AdTrackingResponse.Ad._childSerializers$_anonymous_$1();
            }
        }), null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.amazon.mediatailorsdk.network.tracking.model.AdTrackingResponse$Ad$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AdTrackingResponse.Ad._childSerializers$_anonymous_$2();
            }
        }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.amazon.mediatailorsdk.network.tracking.model.AdTrackingResponse$Ad$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AdTrackingResponse.Ad._childSerializers$_anonymous_$3();
            }
        }), null, null};

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new ReferenceArraySerializer(Reflection.getOrCreateKotlinClass(AdData.AdVerification.class), AdData$AdVerification$$serializer.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
            return new ReferenceArraySerializer(Reflection.getOrCreateKotlinClass(AdData.Icon.class), AdData$Icon$$serializer.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
            return new ReferenceArraySerializer(Reflection.getOrCreateKotlinClass(AdData.CompanionAd.class), AdData$CompanionAd$$serializer.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$2() {
            return new ReferenceArraySerializer(Reflection.getOrCreateKotlinClass(AdData.Extension.class), AdData$Extension$$serializer.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$3() {
            return new ReferenceArraySerializer(Reflection.getOrCreateKotlinClass(AdData.TrackingEvent.class), AdData$TrackingEvent$$serializer.INSTANCE);
        }

        /* JADX INFO: compiled from: AdTrackingResponse.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse$Ad$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse$Ad;", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Ad> serializer() {
                return AdTrackingResponse$Ad$$serializer.INSTANCE;
            }
        }

        public Ad() {
        }

        public /* synthetic */ Ad(int i, String str, Double d, String str2, String str3, Double d2, String str4, String str5, String str6, String str7, AdData.AdVerification[] adVerificationArr, AdData.Icon[] iconArr, AdData.CompanionAd[] companionAdArr, String str8, String str9, AdData.Extension[] extensionArr, AdData.TrackingEvent[] trackingEventArr, String str10, String str11, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 1) == 0) {
                this.startTime = null;
            } else {
                this.startTime = str;
            }
            if ((i & 2) == 0) {
                this.startTimeInSeconds = null;
            } else {
                this.startTimeInSeconds = d;
            }
            if ((i & 4) == 0) {
                this.adProgramDateTime = null;
            } else {
                this.adProgramDateTime = str2;
            }
            if ((i & 8) == 0) {
                this.duration = null;
            } else {
                this.duration = str3;
            }
            if ((i & 16) == 0) {
                this.durationInSeconds = null;
            } else {
                this.durationInSeconds = d2;
            }
            if ((i & 32) == 0) {
                this.adId = null;
            } else {
                this.adId = str4;
            }
            if ((i & 64) == 0) {
                this.adParameters = null;
            } else {
                this.adParameters = str5;
            }
            if ((i & 128) == 0) {
                this.adSystem = null;
            } else {
                this.adSystem = str6;
            }
            if ((i & 256) == 0) {
                this.adTitle = null;
            } else {
                this.adTitle = str7;
            }
            if ((i & 512) == 0) {
                this.adVerifications = null;
            } else {
                this.adVerifications = adVerificationArr;
            }
            if ((i & 1024) == 0) {
                this.icons = null;
            } else {
                this.icons = iconArr;
            }
            if ((i & 2048) == 0) {
                this.companionAds = null;
            } else {
                this.companionAds = companionAdArr;
            }
            if ((i & 4096) == 0) {
                this.creativeId = null;
            } else {
                this.creativeId = str8;
            }
            if ((i & 8192) == 0) {
                this.creativeSequence = null;
            } else {
                this.creativeSequence = str9;
            }
            if ((i & 16384) == 0) {
                this.extensions = null;
            } else {
                this.extensions = extensionArr;
            }
            if ((32768 & i) == 0) {
                this.trackingEvents = null;
            } else {
                this.trackingEvents = trackingEventArr;
            }
            if ((65536 & i) == 0) {
                this.vastAdId = null;
            } else {
                this.vastAdId = str10;
            }
            if ((i & 131072) == 0) {
                this.skipOffset = null;
            } else {
                this.skipOffset = str11;
            }
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$MediaTailor_release(Ad self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.startTime != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.startTime);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.startTimeInSeconds != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, DoubleSerializer.INSTANCE, self.startTimeInSeconds);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.adProgramDateTime != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.adProgramDateTime);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.duration != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.duration);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.durationInSeconds != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, DoubleSerializer.INSTANCE, self.durationInSeconds);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.adId != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.adId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.adParameters != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.adParameters);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 7) || self.adSystem != null) {
                output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.adSystem);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 8) || self.adTitle != null) {
                output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.adTitle);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 9) || self.adVerifications != null) {
                output.encodeNullableSerializableElement(serialDesc, 9, lazyArr[9].getValue(), self.adVerifications);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 10) || self.icons != null) {
                output.encodeNullableSerializableElement(serialDesc, 10, lazyArr[10].getValue(), self.icons);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 11) || self.companionAds != null) {
                output.encodeNullableSerializableElement(serialDesc, 11, lazyArr[11].getValue(), self.companionAds);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 12) || self.creativeId != null) {
                output.encodeNullableSerializableElement(serialDesc, 12, StringSerializer.INSTANCE, self.creativeId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 13) || self.creativeSequence != null) {
                output.encodeNullableSerializableElement(serialDesc, 13, StringSerializer.INSTANCE, self.creativeSequence);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 14) || self.extensions != null) {
                output.encodeNullableSerializableElement(serialDesc, 14, lazyArr[14].getValue(), self.extensions);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 15) || self.trackingEvents != null) {
                output.encodeNullableSerializableElement(serialDesc, 15, lazyArr[15].getValue(), self.trackingEvents);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 16) || self.vastAdId != null) {
                output.encodeNullableSerializableElement(serialDesc, 16, StringSerializer.INSTANCE, self.vastAdId);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 17) && self.skipOffset == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 17, StringSerializer.INSTANCE, self.skipOffset);
        }

        public final String getStartTime() {
            return this.startTime;
        }

        public final void setStartTime(String str) {
            this.startTime = str;
        }

        public final Double getStartTimeInSeconds() {
            return this.startTimeInSeconds;
        }

        public final void setStartTimeInSeconds(Double d) {
            this.startTimeInSeconds = d;
        }

        public final String getAdProgramDateTime() {
            return this.adProgramDateTime;
        }

        public final void setAdProgramDateTime(String str) {
            this.adProgramDateTime = str;
        }

        public final String getDuration() {
            return this.duration;
        }

        public final void setDuration(String str) {
            this.duration = str;
        }

        public final Double getDurationInSeconds() {
            return this.durationInSeconds;
        }

        public final void setDurationInSeconds(Double d) {
            this.durationInSeconds = d;
        }

        public final String getAdId() {
            return this.adId;
        }

        public final void setAdId(String str) {
            this.adId = str;
        }

        public final String getAdParameters() {
            return this.adParameters;
        }

        public final void setAdParameters(String str) {
            this.adParameters = str;
        }

        public final String getAdSystem() {
            return this.adSystem;
        }

        public final void setAdSystem(String str) {
            this.adSystem = str;
        }

        public final String getAdTitle() {
            return this.adTitle;
        }

        public final void setAdTitle(String str) {
            this.adTitle = str;
        }

        public final AdData.AdVerification[] getAdVerifications() {
            return this.adVerifications;
        }

        public final void setAdVerifications(AdData.AdVerification[] adVerificationArr) {
            this.adVerifications = adVerificationArr;
        }

        public final AdData.Icon[] getIcons() {
            return this.icons;
        }

        public final void setIcons(AdData.Icon[] iconArr) {
            this.icons = iconArr;
        }

        public final AdData.CompanionAd[] getCompanionAds() {
            return this.companionAds;
        }

        public final void setCompanionAds(AdData.CompanionAd[] companionAdArr) {
            this.companionAds = companionAdArr;
        }

        public final String getCreativeId() {
            return this.creativeId;
        }

        public final void setCreativeId(String str) {
            this.creativeId = str;
        }

        public final String getCreativeSequence() {
            return this.creativeSequence;
        }

        public final void setCreativeSequence(String str) {
            this.creativeSequence = str;
        }

        public final AdData.Extension[] getExtensions() {
            return this.extensions;
        }

        public final void setExtensions(AdData.Extension[] extensionArr) {
            this.extensions = extensionArr;
        }

        public final AdData.TrackingEvent[] getTrackingEvents() {
            return this.trackingEvents;
        }

        public final void setTrackingEvents(AdData.TrackingEvent[] trackingEventArr) {
            this.trackingEvents = trackingEventArr;
        }

        public final String getVastAdId() {
            return this.vastAdId;
        }

        public final void setVastAdId(String str) {
            this.vastAdId = str;
        }

        public final String getSkipOffset() {
            return this.skipOffset;
        }

        public final void setSkipOffset(String str) {
            this.skipOffset = str;
        }
    }

    /* JADX INFO: compiled from: AdTrackingResponse.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 42\u00020\u0001:\u000234B\u0007¢\u0006\u0004\b\u0002\u0010\u0003Bc\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\r\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0002\u0010\u0013J%\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0001¢\u0006\u0002\b2R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0015\"\u0004\b\u001e\u0010\u0017R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017R$\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u00065"}, d2 = {"Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse$NonLinearAvail;", "", "<init>", "()V", "seen0", "", "startTime", "", "startTimeInSeconds", "", "availProgramDateTime", "availId", "nonLinearAdsList", "", "Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse$NonLinearAds;", "adBreakTrackingEvents", "Lcom/amazon/mediatailorsdk/AdBreakTrackingEvent;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;[Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse$NonLinearAds;[Lcom/amazon/mediatailorsdk/AdBreakTrackingEvent;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getStartTime", "()Ljava/lang/String;", "setStartTime", "(Ljava/lang/String;)V", "getStartTimeInSeconds", "()Ljava/lang/Double;", "setStartTimeInSeconds", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getAvailProgramDateTime", "setAvailProgramDateTime", "getAvailId", "setAvailId", "getNonLinearAdsList", "()[Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse$NonLinearAds;", "setNonLinearAdsList", "([Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse$NonLinearAds;)V", "[Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse$NonLinearAds;", "getAdBreakTrackingEvents", "()[Lcom/amazon/mediatailorsdk/AdBreakTrackingEvent;", "setAdBreakTrackingEvents", "([Lcom/amazon/mediatailorsdk/AdBreakTrackingEvent;)V", "[Lcom/amazon/mediatailorsdk/AdBreakTrackingEvent;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$MediaTailor_release", "$serializer", "Companion", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @Serializable
    public static final class NonLinearAvail {
        private AdBreakTrackingEvent[] adBreakTrackingEvents;
        private String availId;
        private String availProgramDateTime;
        private NonLinearAds[] nonLinearAdsList;
        private String startTime;
        private Double startTimeInSeconds;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.amazon.mediatailorsdk.network.tracking.model.AdTrackingResponse$NonLinearAvail$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AdTrackingResponse.NonLinearAvail._childSerializers$_anonymous_();
            }
        }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.amazon.mediatailorsdk.network.tracking.model.AdTrackingResponse$NonLinearAvail$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AdTrackingResponse.NonLinearAvail._childSerializers$_anonymous_$0();
            }
        })};

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new ReferenceArraySerializer(Reflection.getOrCreateKotlinClass(NonLinearAds.class), AdTrackingResponse$NonLinearAds$$serializer.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
            return new ReferenceArraySerializer(Reflection.getOrCreateKotlinClass(AdBreakTrackingEvent.class), AdBreakTrackingEvent$$serializer.INSTANCE);
        }

        /* JADX INFO: compiled from: AdTrackingResponse.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse$NonLinearAvail$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse$NonLinearAvail;", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<NonLinearAvail> serializer() {
                return AdTrackingResponse$NonLinearAvail$$serializer.INSTANCE;
            }
        }

        public NonLinearAvail() {
        }

        public /* synthetic */ NonLinearAvail(int i, String str, Double d, String str2, String str3, NonLinearAds[] nonLinearAdsArr, AdBreakTrackingEvent[] adBreakTrackingEventArr, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 1) == 0) {
                this.startTime = null;
            } else {
                this.startTime = str;
            }
            if ((i & 2) == 0) {
                this.startTimeInSeconds = null;
            } else {
                this.startTimeInSeconds = d;
            }
            if ((i & 4) == 0) {
                this.availProgramDateTime = null;
            } else {
                this.availProgramDateTime = str2;
            }
            if ((i & 8) == 0) {
                this.availId = null;
            } else {
                this.availId = str3;
            }
            if ((i & 16) == 0) {
                this.nonLinearAdsList = null;
            } else {
                this.nonLinearAdsList = nonLinearAdsArr;
            }
            if ((i & 32) == 0) {
                this.adBreakTrackingEvents = null;
            } else {
                this.adBreakTrackingEvents = adBreakTrackingEventArr;
            }
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$MediaTailor_release(NonLinearAvail self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.startTime != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.startTime);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.startTimeInSeconds != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, DoubleSerializer.INSTANCE, self.startTimeInSeconds);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.availProgramDateTime != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.availProgramDateTime);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.availId != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.availId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.nonLinearAdsList != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, lazyArr[4].getValue(), self.nonLinearAdsList);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 5) && self.adBreakTrackingEvents == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 5, lazyArr[5].getValue(), self.adBreakTrackingEvents);
        }

        public final String getStartTime() {
            return this.startTime;
        }

        public final void setStartTime(String str) {
            this.startTime = str;
        }

        public final Double getStartTimeInSeconds() {
            return this.startTimeInSeconds;
        }

        public final void setStartTimeInSeconds(Double d) {
            this.startTimeInSeconds = d;
        }

        public final String getAvailProgramDateTime() {
            return this.availProgramDateTime;
        }

        public final void setAvailProgramDateTime(String str) {
            this.availProgramDateTime = str;
        }

        public final String getAvailId() {
            return this.availId;
        }

        public final void setAvailId(String str) {
            this.availId = str;
        }

        public final NonLinearAds[] getNonLinearAdsList() {
            return this.nonLinearAdsList;
        }

        public final void setNonLinearAdsList(NonLinearAds[] nonLinearAdsArr) {
            this.nonLinearAdsList = nonLinearAdsArr;
        }

        public final AdBreakTrackingEvent[] getAdBreakTrackingEvents() {
            return this.adBreakTrackingEvents;
        }

        public final void setAdBreakTrackingEvents(AdBreakTrackingEvent[] adBreakTrackingEventArr) {
            this.adBreakTrackingEvents = adBreakTrackingEventArr;
        }
    }

    /* JADX INFO: compiled from: AdTrackingResponse.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 (2\u00020\u0001:\u0002'(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003BK\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0002\u0010\u000fJ%\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\b&R$\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006)"}, d2 = {"Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse$NonLinearAds;", "", "<init>", "()V", "seen0", "", "nonLinearAdList", "", "Lcom/amazon/mediatailorsdk/NonLinearAdsData$NonLinearAd;", "extensions", "Lcom/amazon/mediatailorsdk/NonLinearAdsData$Extension;", "trackingEvents", "Lcom/amazon/mediatailorsdk/NonLinearAdsData$TrackingEvent;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(I[Lcom/amazon/mediatailorsdk/NonLinearAdsData$NonLinearAd;[Lcom/amazon/mediatailorsdk/NonLinearAdsData$Extension;[Lcom/amazon/mediatailorsdk/NonLinearAdsData$TrackingEvent;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getNonLinearAdList", "()[Lcom/amazon/mediatailorsdk/NonLinearAdsData$NonLinearAd;", "setNonLinearAdList", "([Lcom/amazon/mediatailorsdk/NonLinearAdsData$NonLinearAd;)V", "[Lcom/amazon/mediatailorsdk/NonLinearAdsData$NonLinearAd;", "getExtensions", "()[Lcom/amazon/mediatailorsdk/NonLinearAdsData$Extension;", "setExtensions", "([Lcom/amazon/mediatailorsdk/NonLinearAdsData$Extension;)V", "[Lcom/amazon/mediatailorsdk/NonLinearAdsData$Extension;", "getTrackingEvents", "()[Lcom/amazon/mediatailorsdk/NonLinearAdsData$TrackingEvent;", "setTrackingEvents", "([Lcom/amazon/mediatailorsdk/NonLinearAdsData$TrackingEvent;)V", "[Lcom/amazon/mediatailorsdk/NonLinearAdsData$TrackingEvent;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$MediaTailor_release", "$serializer", "Companion", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @Serializable
    public static final class NonLinearAds {
        private NonLinearAdsData.Extension[] extensions;
        private NonLinearAdsData.NonLinearAd[] nonLinearAdList;
        private NonLinearAdsData.TrackingEvent[] trackingEvents;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.amazon.mediatailorsdk.network.tracking.model.AdTrackingResponse$NonLinearAds$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AdTrackingResponse.NonLinearAds._childSerializers$_anonymous_();
            }
        }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.amazon.mediatailorsdk.network.tracking.model.AdTrackingResponse$NonLinearAds$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AdTrackingResponse.NonLinearAds._childSerializers$_anonymous_$0();
            }
        }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.amazon.mediatailorsdk.network.tracking.model.AdTrackingResponse$NonLinearAds$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AdTrackingResponse.NonLinearAds._childSerializers$_anonymous_$1();
            }
        })};

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new ReferenceArraySerializer(Reflection.getOrCreateKotlinClass(NonLinearAdsData.NonLinearAd.class), NonLinearAdsData$NonLinearAd$$serializer.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
            return new ReferenceArraySerializer(Reflection.getOrCreateKotlinClass(NonLinearAdsData.Extension.class), NonLinearAdsData$Extension$$serializer.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
            return new ReferenceArraySerializer(Reflection.getOrCreateKotlinClass(NonLinearAdsData.TrackingEvent.class), NonLinearAdsData$TrackingEvent$$serializer.INSTANCE);
        }

        /* JADX INFO: compiled from: AdTrackingResponse.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse$NonLinearAds$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse$NonLinearAds;", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<NonLinearAds> serializer() {
                return AdTrackingResponse$NonLinearAds$$serializer.INSTANCE;
            }
        }

        public NonLinearAds() {
        }

        public /* synthetic */ NonLinearAds(int i, NonLinearAdsData.NonLinearAd[] nonLinearAdArr, NonLinearAdsData.Extension[] extensionArr, NonLinearAdsData.TrackingEvent[] trackingEventArr, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 1) == 0) {
                this.nonLinearAdList = null;
            } else {
                this.nonLinearAdList = nonLinearAdArr;
            }
            if ((i & 2) == 0) {
                this.extensions = null;
            } else {
                this.extensions = extensionArr;
            }
            if ((i & 4) == 0) {
                this.trackingEvents = null;
            } else {
                this.trackingEvents = trackingEventArr;
            }
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$MediaTailor_release(NonLinearAds self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.nonLinearAdList != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, lazyArr[0].getValue(), self.nonLinearAdList);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.extensions != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, lazyArr[1].getValue(), self.extensions);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.trackingEvents == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 2, lazyArr[2].getValue(), self.trackingEvents);
        }

        public final NonLinearAdsData.NonLinearAd[] getNonLinearAdList() {
            return this.nonLinearAdList;
        }

        public final void setNonLinearAdList(NonLinearAdsData.NonLinearAd[] nonLinearAdArr) {
            this.nonLinearAdList = nonLinearAdArr;
        }

        public final NonLinearAdsData.Extension[] getExtensions() {
            return this.extensions;
        }

        public final void setExtensions(NonLinearAdsData.Extension[] extensionArr) {
            this.extensions = extensionArr;
        }

        public final NonLinearAdsData.TrackingEvent[] getTrackingEvents() {
            return this.trackingEvents;
        }

        public final void setTrackingEvents(NonLinearAdsData.TrackingEvent[] trackingEventArr) {
            this.trackingEvents = trackingEventArr;
        }
    }
}
