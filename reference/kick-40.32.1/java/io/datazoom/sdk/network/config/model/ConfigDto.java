package io.datazoom.sdk.network.config.model;

import com.facebook.hermes.intl.Constants;
import com.mux.stats.sdk.core.events.playback.Sampling;
import com.useinsider.insiderhybrid.constants.InsiderHybridMethods;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LinkedHashSetSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: ConfigDto.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\bH\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u0000 l2\u00020\u0001:\u0004ijklB§\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016B§\u0001\b\u0010\u0012\u0006\u0010\u0017\u001a\u00020\f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u0015\u0010\u001aJ\u000b\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0011\u0010T\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\u0011\u0010U\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\u0011\u0010V\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\u0011\u0010W\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\t\u0010X\u001a\u00020\u0011HÆ\u0003J\u0010\u0010Y\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010FJ\t\u0010Z\u001a\u00020\u0014HÆ\u0003J²\u0001\u0010[\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0013\u001a\u00020\u0014HÆ\u0001¢\u0006\u0002\u0010\\J\u0014\u0010]\u001a\u00020\u00142\b\u0010^\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010_\u001a\u00020\fHÖ\u0081\u0004J\n\u0010`\u001a\u00020\u0005HÖ\u0081\u0004J%\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020\u00002\u0006\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020gH\u0001¢\u0006\u0002\bhR&\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R&\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R&\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b&\u0010\u001c\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R&\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b)\u0010\u001c\u001a\u0004\b*\u0010#\"\u0004\b+\u0010%R&\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b,\u0010\u001c\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R,\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b1\u0010\u001c\u001a\u0004\b2\u00103\"\u0004\b4\u00105R,\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b6\u0010\u001c\u001a\u0004\b7\u00103\"\u0004\b8\u00105R,\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b9\u0010\u001c\u001a\u0004\b:\u00103\"\u0004\b;\u00105R,\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b<\u0010\u001c\u001a\u0004\b=\u00103\"\u0004\b>\u00105R$\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b?\u0010\u001c\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR(\u0010\u0012\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010I\u0012\u0004\bD\u0010\u001c\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR$\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bJ\u0010\u001c\u001a\u0004\bK\u0010L\"\u0004\bM\u0010N¨\u0006m"}, d2 = {"Lio/datazoom/sdk/network/config/model/ConfigDto;", "", "dataPoints", "Lio/datazoom/sdk/network/config/model/ConfigDto$DataPoints;", "customerCode", "", "connectorList", "configurationId", "endpoints", "Lio/datazoom/sdk/network/config/model/ConfigDto$Endpoints;", "contentMilestones", "", "", "adMilestones", "contentQv", "adQv", "heartbeatIntervalMs", "", "appSessionTimeoutMinutes", "omEnabled", "", "<init>", "(Lio/datazoom/sdk/network/config/model/ConfigDto$DataPoints;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/datazoom/sdk/network/config/model/ConfigDto$Endpoints;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;JLjava/lang/Integer;Z)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILio/datazoom/sdk/network/config/model/ConfigDto$DataPoints;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/datazoom/sdk/network/config/model/ConfigDto$Endpoints;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;JLjava/lang/Integer;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDataPoints$annotations", "()V", "getDataPoints", "()Lio/datazoom/sdk/network/config/model/ConfigDto$DataPoints;", "setDataPoints", "(Lio/datazoom/sdk/network/config/model/ConfigDto$DataPoints;)V", "getCustomerCode$annotations", "getCustomerCode", "()Ljava/lang/String;", "setCustomerCode", "(Ljava/lang/String;)V", "getConnectorList$annotations", "getConnectorList", "setConnectorList", "getConfigurationId$annotations", "getConfigurationId", "setConfigurationId", "getEndpoints$annotations", "getEndpoints", "()Lio/datazoom/sdk/network/config/model/ConfigDto$Endpoints;", "setEndpoints", "(Lio/datazoom/sdk/network/config/model/ConfigDto$Endpoints;)V", "getContentMilestones$annotations", "getContentMilestones", "()Ljava/util/List;", "setContentMilestones", "(Ljava/util/List;)V", "getAdMilestones$annotations", "getAdMilestones", "setAdMilestones", "getContentQv$annotations", "getContentQv", "setContentQv", "getAdQv$annotations", "getAdQv", "setAdQv", "getHeartbeatIntervalMs$annotations", "getHeartbeatIntervalMs", "()J", "setHeartbeatIntervalMs", "(J)V", "getAppSessionTimeoutMinutes$annotations", "getAppSessionTimeoutMinutes", "()Ljava/lang/Integer;", "setAppSessionTimeoutMinutes", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getOmEnabled$annotations", "getOmEnabled", "()Z", "setOmEnabled", "(Z)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Lio/datazoom/sdk/network/config/model/ConfigDto$DataPoints;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/datazoom/sdk/network/config/model/ConfigDto$Endpoints;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;JLjava/lang/Integer;Z)Lio/datazoom/sdk/network/config/model/ConfigDto;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$base", "DataPoints", "Endpoints", "$serializer", "Companion", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable
public final /* data */ class ConfigDto {
    private List<Integer> adMilestones;
    private List<Integer> adQv;
    private Integer appSessionTimeoutMinutes;
    private String configurationId;
    private String connectorList;
    private List<Integer> contentMilestones;
    private List<Integer> contentQv;
    private String customerCode;
    private DataPoints dataPoints;
    private Endpoints endpoints;
    private long heartbeatIntervalMs;
    private boolean omEnabled;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: io.datazoom.sdk.network.config.model.ConfigDto$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ConfigDto._childSerializers$_anonymous_();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: io.datazoom.sdk.network.config.model.ConfigDto$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ConfigDto._childSerializers$_anonymous_$0();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: io.datazoom.sdk.network.config.model.ConfigDto$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ConfigDto._childSerializers$_anonymous_$1();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: io.datazoom.sdk.network.config.model.ConfigDto$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ConfigDto._childSerializers$_anonymous_$2();
        }
    }), null, null, null};

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(IntSerializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new ArrayListSerializer(IntSerializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
        return new ArrayListSerializer(IntSerializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$2() {
        return new ArrayListSerializer(IntSerializer.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConfigDto copy$default(ConfigDto configDto, DataPoints dataPoints, String str, String str2, String str3, Endpoints endpoints, List list, List list2, List list3, List list4, long j, Integer num, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            dataPoints = configDto.dataPoints;
        }
        return configDto.copy(dataPoints, (i & 2) != 0 ? configDto.customerCode : str, (i & 4) != 0 ? configDto.connectorList : str2, (i & 8) != 0 ? configDto.configurationId : str3, (i & 16) != 0 ? configDto.endpoints : endpoints, (i & 32) != 0 ? configDto.contentMilestones : list, (i & 64) != 0 ? configDto.adMilestones : list2, (i & 128) != 0 ? configDto.contentQv : list3, (i & 256) != 0 ? configDto.adQv : list4, (i & 512) != 0 ? configDto.heartbeatIntervalMs : j, (i & 1024) != 0 ? configDto.appSessionTimeoutMinutes : num, (i & 2048) != 0 ? configDto.omEnabled : z);
    }

    @SerialName("ad_milestone_percent")
    public static /* synthetic */ void getAdMilestones$annotations() {
    }

    @SerialName("ad_qv_sec")
    public static /* synthetic */ void getAdQv$annotations() {
    }

    @SerialName("app_session_timeout_mins")
    public static /* synthetic */ void getAppSessionTimeoutMinutes$annotations() {
    }

    @SerialName("configuration_id")
    public static /* synthetic */ void getConfigurationId$annotations() {
    }

    @SerialName("connector_list")
    public static /* synthetic */ void getConnectorList$annotations() {
    }

    @SerialName("content_milestone_percent")
    public static /* synthetic */ void getContentMilestones$annotations() {
    }

    @SerialName("content_qv_sec")
    public static /* synthetic */ void getContentQv$annotations() {
    }

    @SerialName("customer_code")
    public static /* synthetic */ void getCustomerCode$annotations() {
    }

    @SerialName("datapoints")
    public static /* synthetic */ void getDataPoints$annotations() {
    }

    @SerialName("endpoints")
    public static /* synthetic */ void getEndpoints$annotations() {
    }

    @SerialName("heartbeat_interval_ms")
    public static /* synthetic */ void getHeartbeatIntervalMs$annotations() {
    }

    @SerialName("om_enabled")
    public static /* synthetic */ void getOmEnabled$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final DataPoints getDataPoints() {
        return this.dataPoints;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final long getHeartbeatIntervalMs() {
        return this.heartbeatIntervalMs;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Integer getAppSessionTimeoutMinutes() {
        return this.appSessionTimeoutMinutes;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getOmEnabled() {
        return this.omEnabled;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCustomerCode() {
        return this.customerCode;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getConnectorList() {
        return this.connectorList;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getConfigurationId() {
        return this.configurationId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Endpoints getEndpoints() {
        return this.endpoints;
    }

    public final List<Integer> component6() {
        return this.contentMilestones;
    }

    public final List<Integer> component7() {
        return this.adMilestones;
    }

    public final List<Integer> component8() {
        return this.contentQv;
    }

    public final List<Integer> component9() {
        return this.adQv;
    }

    public final ConfigDto copy(DataPoints dataPoints, String customerCode, String connectorList, String configurationId, Endpoints endpoints, List<Integer> contentMilestones, List<Integer> adMilestones, List<Integer> contentQv, List<Integer> adQv, long heartbeatIntervalMs, Integer appSessionTimeoutMinutes, boolean omEnabled) {
        return new ConfigDto(dataPoints, customerCode, connectorList, configurationId, endpoints, contentMilestones, adMilestones, contentQv, adQv, heartbeatIntervalMs, appSessionTimeoutMinutes, omEnabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConfigDto)) {
            return false;
        }
        ConfigDto configDto = (ConfigDto) other;
        return Intrinsics.areEqual(this.dataPoints, configDto.dataPoints) && Intrinsics.areEqual(this.customerCode, configDto.customerCode) && Intrinsics.areEqual(this.connectorList, configDto.connectorList) && Intrinsics.areEqual(this.configurationId, configDto.configurationId) && Intrinsics.areEqual(this.endpoints, configDto.endpoints) && Intrinsics.areEqual(this.contentMilestones, configDto.contentMilestones) && Intrinsics.areEqual(this.adMilestones, configDto.adMilestones) && Intrinsics.areEqual(this.contentQv, configDto.contentQv) && Intrinsics.areEqual(this.adQv, configDto.adQv) && this.heartbeatIntervalMs == configDto.heartbeatIntervalMs && Intrinsics.areEqual(this.appSessionTimeoutMinutes, configDto.appSessionTimeoutMinutes) && this.omEnabled == configDto.omEnabled;
    }

    public int hashCode() {
        DataPoints dataPoints = this.dataPoints;
        int iHashCode = (dataPoints == null ? 0 : dataPoints.hashCode()) * 31;
        String str = this.customerCode;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.connectorList;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.configurationId;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Endpoints endpoints = this.endpoints;
        int iHashCode5 = (iHashCode4 + (endpoints == null ? 0 : endpoints.hashCode())) * 31;
        List<Integer> list = this.contentMilestones;
        int iHashCode6 = (iHashCode5 + (list == null ? 0 : list.hashCode())) * 31;
        List<Integer> list2 = this.adMilestones;
        int iHashCode7 = (iHashCode6 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<Integer> list3 = this.contentQv;
        int iHashCode8 = (iHashCode7 + (list3 == null ? 0 : list3.hashCode())) * 31;
        List<Integer> list4 = this.adQv;
        int iHashCode9 = (((iHashCode8 + (list4 == null ? 0 : list4.hashCode())) * 31) + Long.hashCode(this.heartbeatIntervalMs)) * 31;
        Integer num = this.appSessionTimeoutMinutes;
        return ((iHashCode9 + (num != null ? num.hashCode() : 0)) * 31) + Boolean.hashCode(this.omEnabled);
    }

    public String toString() {
        return "ConfigDto(dataPoints=" + this.dataPoints + ", customerCode=" + this.customerCode + ", connectorList=" + this.connectorList + ", configurationId=" + this.configurationId + ", endpoints=" + this.endpoints + ", contentMilestones=" + this.contentMilestones + ", adMilestones=" + this.adMilestones + ", contentQv=" + this.contentQv + ", adQv=" + this.adQv + ", heartbeatIntervalMs=" + this.heartbeatIntervalMs + ", appSessionTimeoutMinutes=" + this.appSessionTimeoutMinutes + ", omEnabled=" + this.omEnabled + ")";
    }

    /* JADX INFO: compiled from: ConfigDto.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lio/datazoom/sdk/network/config/model/ConfigDto$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lio/datazoom/sdk/network/config/model/ConfigDto;", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ConfigDto> serializer() {
            return ConfigDto$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ConfigDto(int i, DataPoints dataPoints, String str, String str2, String str3, Endpoints endpoints, List list, List list2, List list3, List list4, long j, Integer num, boolean z, SerializationConstructorMarker serializationConstructorMarker) {
        if (2560 != (i & 2560)) {
            PluginExceptionsKt.throwMissingFieldException(i, 2560, ConfigDto$$serializer.INSTANCE.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.dataPoints = null;
        } else {
            this.dataPoints = dataPoints;
        }
        if ((i & 2) == 0) {
            this.customerCode = null;
        } else {
            this.customerCode = str;
        }
        if ((i & 4) == 0) {
            this.connectorList = null;
        } else {
            this.connectorList = str2;
        }
        if ((i & 8) == 0) {
            this.configurationId = null;
        } else {
            this.configurationId = str3;
        }
        if ((i & 16) == 0) {
            this.endpoints = null;
        } else {
            this.endpoints = endpoints;
        }
        if ((i & 32) == 0) {
            this.contentMilestones = null;
        } else {
            this.contentMilestones = list;
        }
        if ((i & 64) == 0) {
            this.adMilestones = null;
        } else {
            this.adMilestones = list2;
        }
        if ((i & 128) == 0) {
            this.contentQv = null;
        } else {
            this.contentQv = list3;
        }
        if ((i & 256) == 0) {
            this.adQv = null;
        } else {
            this.adQv = list4;
        }
        this.heartbeatIntervalMs = j;
        if ((i & 1024) == 0) {
            this.appSessionTimeoutMinutes = null;
        } else {
            this.appSessionTimeoutMinutes = num;
        }
        this.omEnabled = z;
    }

    public ConfigDto(DataPoints dataPoints, String str, String str2, String str3, Endpoints endpoints, List<Integer> list, List<Integer> list2, List<Integer> list3, List<Integer> list4, long j, Integer num, boolean z) {
        this.dataPoints = dataPoints;
        this.customerCode = str;
        this.connectorList = str2;
        this.configurationId = str3;
        this.endpoints = endpoints;
        this.contentMilestones = list;
        this.adMilestones = list2;
        this.contentQv = list3;
        this.adQv = list4;
        this.heartbeatIntervalMs = j;
        this.appSessionTimeoutMinutes = num;
        this.omEnabled = z;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$base(ConfigDto self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.dataPoints != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, ConfigDto$DataPoints$$serializer.INSTANCE, self.dataPoints);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.customerCode != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.customerCode);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.connectorList != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.connectorList);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.configurationId != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.configurationId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.endpoints != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, ConfigDto$Endpoints$$serializer.INSTANCE, self.endpoints);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.contentMilestones != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, lazyArr[5].getValue(), self.contentMilestones);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.adMilestones != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, lazyArr[6].getValue(), self.adMilestones);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.contentQv != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, lazyArr[7].getValue(), self.contentQv);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.adQv != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, lazyArr[8].getValue(), self.adQv);
        }
        output.encodeLongElement(serialDesc, 9, self.heartbeatIntervalMs);
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.appSessionTimeoutMinutes != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, IntSerializer.INSTANCE, self.appSessionTimeoutMinutes);
        }
        output.encodeBooleanElement(serialDesc, 11, self.omEnabled);
    }

    public /* synthetic */ ConfigDto(DataPoints dataPoints, String str, String str2, String str3, Endpoints endpoints, List list, List list2, List list3, List list4, long j, Integer num, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : dataPoints, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : endpoints, (i & 32) != 0 ? null : list, (i & 64) != 0 ? null : list2, (i & 128) != 0 ? null : list3, (i & 256) != 0 ? null : list4, j, (i & 1024) != 0 ? null : num, z);
    }

    public final DataPoints getDataPoints() {
        return this.dataPoints;
    }

    public final void setDataPoints(DataPoints dataPoints) {
        this.dataPoints = dataPoints;
    }

    public final String getCustomerCode() {
        return this.customerCode;
    }

    public final void setCustomerCode(String str) {
        this.customerCode = str;
    }

    public final String getConnectorList() {
        return this.connectorList;
    }

    public final void setConnectorList(String str) {
        this.connectorList = str;
    }

    public final String getConfigurationId() {
        return this.configurationId;
    }

    public final void setConfigurationId(String str) {
        this.configurationId = str;
    }

    public final Endpoints getEndpoints() {
        return this.endpoints;
    }

    public final void setEndpoints(Endpoints endpoints) {
        this.endpoints = endpoints;
    }

    public final List<Integer> getContentMilestones() {
        return this.contentMilestones;
    }

    public final void setContentMilestones(List<Integer> list) {
        this.contentMilestones = list;
    }

    public final List<Integer> getAdMilestones() {
        return this.adMilestones;
    }

    public final void setAdMilestones(List<Integer> list) {
        this.adMilestones = list;
    }

    public final List<Integer> getContentQv() {
        return this.contentQv;
    }

    public final void setContentQv(List<Integer> list) {
        this.contentQv = list;
    }

    public final List<Integer> getAdQv() {
        return this.adQv;
    }

    public final void setAdQv(List<Integer> list) {
        this.adQv = list;
    }

    public final long getHeartbeatIntervalMs() {
        return this.heartbeatIntervalMs;
    }

    public final void setHeartbeatIntervalMs(long j) {
        this.heartbeatIntervalMs = j;
    }

    public final Integer getAppSessionTimeoutMinutes() {
        return this.appSessionTimeoutMinutes;
    }

    public final void setAppSessionTimeoutMinutes(Integer num) {
        this.appSessionTimeoutMinutes = num;
    }

    public final boolean getOmEnabled() {
        return this.omEnabled;
    }

    public final void setOmEnabled(boolean z) {
        this.omEnabled = z;
    }

    /* JADX INFO: compiled from: ConfigDto.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 12\u00020\u0001:\u0003/01B7\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nBK\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J?\u0010!\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001J\u0014\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010%\u001a\u00020\fHÖ\u0081\u0004J\n\u0010&\u001a\u00020\u0007HÖ\u0081\u0004J%\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0001¢\u0006\u0002\b.R,\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R,\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR,\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001a¨\u00062"}, d2 = {"Lio/datazoom/sdk/network/config/model/ConfigDto$DataPoints;", "", "events", "", "Lio/datazoom/sdk/network/config/model/ConfigDto$DataPoints$Event;", "metadata", "", "", "fluxData", "<init>", "(Ljava/util/List;Ljava/util/Set;Ljava/util/Set;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/util/Set;Ljava/util/Set;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getEvents$annotations", "()V", "getEvents", "()Ljava/util/List;", "setEvents", "(Ljava/util/List;)V", "getMetadata$annotations", "getMetadata", "()Ljava/util/Set;", "setMetadata", "(Ljava/util/Set;)V", "getFluxData$annotations", "getFluxData", "setFluxData", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$base", "Event", "$serializer", "Companion", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
    @Serializable
    public static final /* data */ class DataPoints {
        private List<Event> events;
        private Set<String> fluxData;
        private Set<String> metadata;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: io.datazoom.sdk.network.config.model.ConfigDto$DataPoints$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ConfigDto.DataPoints._childSerializers$_anonymous_();
            }
        }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: io.datazoom.sdk.network.config.model.ConfigDto$DataPoints$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ConfigDto.DataPoints._childSerializers$_anonymous_$0();
            }
        }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: io.datazoom.sdk.network.config.model.ConfigDto$DataPoints$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ConfigDto.DataPoints._childSerializers$_anonymous_$1();
            }
        })};

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new ArrayListSerializer(ConfigDto$DataPoints$Event$$serializer.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
            return new LinkedHashSetSerializer(StringSerializer.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
            return new LinkedHashSetSerializer(StringSerializer.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DataPoints copy$default(DataPoints dataPoints, List list, Set set, Set set2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = dataPoints.events;
            }
            if ((i & 2) != 0) {
                set = dataPoints.metadata;
            }
            if ((i & 4) != 0) {
                set2 = dataPoints.fluxData;
            }
            return dataPoints.copy(list, set, set2);
        }

        @SerialName("events")
        public static /* synthetic */ void getEvents$annotations() {
        }

        @SerialName("flux_data")
        public static /* synthetic */ void getFluxData$annotations() {
        }

        @SerialName("metadata")
        public static /* synthetic */ void getMetadata$annotations() {
        }

        public final List<Event> component1() {
            return this.events;
        }

        public final Set<String> component2() {
            return this.metadata;
        }

        public final Set<String> component3() {
            return this.fluxData;
        }

        public final DataPoints copy(List<Event> events, Set<String> metadata, Set<String> fluxData) {
            return new DataPoints(events, metadata, fluxData);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DataPoints)) {
                return false;
            }
            DataPoints dataPoints = (DataPoints) other;
            return Intrinsics.areEqual(this.events, dataPoints.events) && Intrinsics.areEqual(this.metadata, dataPoints.metadata) && Intrinsics.areEqual(this.fluxData, dataPoints.fluxData);
        }

        public int hashCode() {
            List<Event> list = this.events;
            int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
            Set<String> set = this.metadata;
            int iHashCode2 = (iHashCode + (set == null ? 0 : set.hashCode())) * 31;
            Set<String> set2 = this.fluxData;
            return iHashCode2 + (set2 != null ? set2.hashCode() : 0);
        }

        public String toString() {
            return "DataPoints(events=" + this.events + ", metadata=" + this.metadata + ", fluxData=" + this.fluxData + ")";
        }

        /* JADX INFO: compiled from: ConfigDto.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lio/datazoom/sdk/network/config/model/ConfigDto$DataPoints$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lio/datazoom/sdk/network/config/model/ConfigDto$DataPoints;", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<DataPoints> serializer() {
                return ConfigDto$DataPoints$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ DataPoints(int i, List list, Set set, Set set2, SerializationConstructorMarker serializationConstructorMarker) {
            if (7 != (i & 7)) {
                PluginExceptionsKt.throwMissingFieldException(i, 7, ConfigDto$DataPoints$$serializer.INSTANCE.getDescriptor());
            }
            this.events = list;
            this.metadata = set;
            this.fluxData = set2;
        }

        public DataPoints(List<Event> list, Set<String> set, Set<String> set2) {
            this.events = list;
            this.metadata = set;
            this.fluxData = set2;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$base(DataPoints self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
            output.encodeNullableSerializableElement(serialDesc, 0, lazyArr[0].getValue(), self.events);
            output.encodeNullableSerializableElement(serialDesc, 1, lazyArr[1].getValue(), self.metadata);
            output.encodeNullableSerializableElement(serialDesc, 2, lazyArr[2].getValue(), self.fluxData);
        }

        public final List<Event> getEvents() {
            return this.events;
        }

        public final void setEvents(List<Event> list) {
            this.events = list;
        }

        public final Set<String> getMetadata() {
            return this.metadata;
        }

        public final void setMetadata(Set<String> set) {
            this.metadata = set;
        }

        /* JADX INFO: compiled from: ConfigDto.kt */
        @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0002()B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B5\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J'\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\u001f\u001a\u00020\u0003HÖ\u0081\u0004J%\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\b'R&\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R,\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006*"}, d2 = {"Lio/datazoom/sdk/network/config/model/ConfigDto$DataPoints$Event;", "", "name", "", "types", "", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getName$annotations", "()V", "getName", "()Ljava/lang/String;", InsiderHybridMethods.SET_NAME, "(Ljava/lang/String;)V", "getTypes$annotations", "getTypes", "()Ljava/util/List;", "setTypes", "(Ljava/util/List;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$base", "$serializer", "Companion", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
        @Serializable
        public static final /* data */ class Event {
            private String name;
            private List<String> types;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: io.datazoom.sdk.network.config.model.ConfigDto$DataPoints$Event$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ConfigDto.DataPoints.Event._childSerializers$_anonymous_();
                }
            })};

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                return new ArrayListSerializer(StringSerializer.INSTANCE);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Event copy$default(Event event, String str, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = event.name;
                }
                if ((i & 2) != 0) {
                    list = event.types;
                }
                return event.copy(str, list);
            }

            @SerialName("name")
            public static /* synthetic */ void getName$annotations() {
            }

            @SerialName("media_types")
            public static /* synthetic */ void getTypes$annotations() {
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getName() {
                return this.name;
            }

            public final List<String> component2() {
                return this.types;
            }

            public final Event copy(String name, List<String> types) {
                return new Event(name, types);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Event)) {
                    return false;
                }
                Event event = (Event) other;
                return Intrinsics.areEqual(this.name, event.name) && Intrinsics.areEqual(this.types, event.types);
            }

            public int hashCode() {
                String str = this.name;
                int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                List<String> list = this.types;
                return iHashCode + (list != null ? list.hashCode() : 0);
            }

            public String toString() {
                return "Event(name=" + this.name + ", types=" + this.types + ")";
            }

            /* JADX INFO: compiled from: ConfigDto.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lio/datazoom/sdk/network/config/model/ConfigDto$DataPoints$Event$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lio/datazoom/sdk/network/config/model/ConfigDto$DataPoints$Event;", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<Event> serializer() {
                    return ConfigDto$DataPoints$Event$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ Event(int i, String str, List list, SerializationConstructorMarker serializationConstructorMarker) {
                if (3 != (i & 3)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 3, ConfigDto$DataPoints$Event$$serializer.INSTANCE.getDescriptor());
                }
                this.name = str;
                this.types = list;
            }

            public Event(String str, List<String> list) {
                this.name = str;
                this.types = list;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$base(Event self, CompositeEncoder output, SerialDescriptor serialDesc) {
                Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.name);
                output.encodeNullableSerializableElement(serialDesc, 1, lazyArr[1].getValue(), self.types);
            }

            public final String getName() {
                return this.name;
            }

            public final void setName(String str) {
                this.name = str;
            }

            public final List<String> getTypes() {
                return this.types;
            }

            public final void setTypes(List<String> list) {
                this.types = list;
            }
        }

        public final Set<String> getFluxData() {
            return this.fluxData;
        }

        public final void setFluxData(Set<String> set) {
            this.fluxData = set;
        }
    }

    /* JADX INFO: compiled from: ConfigDto.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0002*+B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bBC\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010 \u001a\u00020\nHÖ\u0081\u0004J\n\u0010!\u001a\u00020\u0003HÖ\u0081\u0004J%\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\b)R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011¨\u0006,"}, d2 = {"Lio/datazoom/sdk/network/config/model/ConfigDto$Endpoints;", "", "eventUrl", "", "serverTs", Sampling.TYPE, "ipApi", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getEventUrl$annotations", "()V", "getEventUrl", "()Ljava/lang/String;", "getServerTs$annotations", "getServerTs", "getSampling$annotations", "getSampling", "getIpApi$annotations", "getIpApi", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$base", "$serializer", "Companion", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Endpoints {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String eventUrl;
        private final String ipApi;
        private final String sampling;
        private final String serverTs;

        public static /* synthetic */ Endpoints copy$default(Endpoints endpoints, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = endpoints.eventUrl;
            }
            if ((i & 2) != 0) {
                str2 = endpoints.serverTs;
            }
            if ((i & 4) != 0) {
                str3 = endpoints.sampling;
            }
            if ((i & 8) != 0) {
                str4 = endpoints.ipApi;
            }
            return endpoints.copy(str, str2, str3, str4);
        }

        @SerialName("event_ingest")
        public static /* synthetic */ void getEventUrl$annotations() {
        }

        @SerialName("ip_api")
        public static /* synthetic */ void getIpApi$annotations() {
        }

        @SerialName(Sampling.TYPE)
        public static /* synthetic */ void getSampling$annotations() {
        }

        @SerialName("server_ts")
        public static /* synthetic */ void getServerTs$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getEventUrl() {
            return this.eventUrl;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getServerTs() {
            return this.serverTs;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getSampling() {
            return this.sampling;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getIpApi() {
            return this.ipApi;
        }

        public final Endpoints copy(String eventUrl, String serverTs, String sampling, String ipApi) {
            return new Endpoints(eventUrl, serverTs, sampling, ipApi);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Endpoints)) {
                return false;
            }
            Endpoints endpoints = (Endpoints) other;
            return Intrinsics.areEqual(this.eventUrl, endpoints.eventUrl) && Intrinsics.areEqual(this.serverTs, endpoints.serverTs) && Intrinsics.areEqual(this.sampling, endpoints.sampling) && Intrinsics.areEqual(this.ipApi, endpoints.ipApi);
        }

        public int hashCode() {
            String str = this.eventUrl;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.serverTs;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.sampling;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.ipApi;
            return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
        }

        public String toString() {
            return "Endpoints(eventUrl=" + this.eventUrl + ", serverTs=" + this.serverTs + ", sampling=" + this.sampling + ", ipApi=" + this.ipApi + ")";
        }

        /* JADX INFO: compiled from: ConfigDto.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lio/datazoom/sdk/network/config/model/ConfigDto$Endpoints$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lio/datazoom/sdk/network/config/model/ConfigDto$Endpoints;", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Endpoints> serializer() {
                return ConfigDto$Endpoints$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Endpoints(int i, String str, String str2, String str3, String str4, SerializationConstructorMarker serializationConstructorMarker) {
            if (15 != (i & 15)) {
                PluginExceptionsKt.throwMissingFieldException(i, 15, ConfigDto$Endpoints$$serializer.INSTANCE.getDescriptor());
            }
            this.eventUrl = str;
            this.serverTs = str2;
            this.sampling = str3;
            this.ipApi = str4;
        }

        public Endpoints(String str, String str2, String str3, String str4) {
            this.eventUrl = str;
            this.serverTs = str2;
            this.sampling = str3;
            this.ipApi = str4;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$base(Endpoints self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.eventUrl);
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.serverTs);
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.sampling);
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.ipApi);
        }

        public final String getEventUrl() {
            return this.eventUrl;
        }

        public final String getServerTs() {
            return this.serverTs;
        }

        public final String getSampling() {
            return this.sampling;
        }

        public final String getIpApi() {
            return this.ipApi;
        }
    }
}
