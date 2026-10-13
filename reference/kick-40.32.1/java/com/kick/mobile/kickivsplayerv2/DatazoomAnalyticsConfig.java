package com.kick.mobile.kickivsplayerv2;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DatazoomAnalyticsManager.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/kick/mobile/kickivsplayerv2/DatazoomAnalyticsConfig;", "", "configurationId", "", "metadataJson", "isProduction", "", "mediaTailor", "Lcom/kick/mobile/kickivsplayerv2/DatazoomMediaTailorConfig;", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLcom/kick/mobile/kickivsplayerv2/DatazoomMediaTailorConfig;)V", "getConfigurationId", "()Ljava/lang/String;", "getMetadataJson", "()Z", "getMediaTailor", "()Lcom/kick/mobile/kickivsplayerv2/DatazoomMediaTailorConfig;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "kick-ivs-player-v2_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class DatazoomAnalyticsConfig {
    private final String configurationId;
    private final boolean isProduction;
    private final DatazoomMediaTailorConfig mediaTailor;
    private final String metadataJson;

    public static /* synthetic */ DatazoomAnalyticsConfig copy$default(DatazoomAnalyticsConfig datazoomAnalyticsConfig, String str, String str2, boolean z, DatazoomMediaTailorConfig datazoomMediaTailorConfig, int i, Object obj) {
        if ((i & 1) != 0) {
            str = datazoomAnalyticsConfig.configurationId;
        }
        if ((i & 2) != 0) {
            str2 = datazoomAnalyticsConfig.metadataJson;
        }
        if ((i & 4) != 0) {
            z = datazoomAnalyticsConfig.isProduction;
        }
        if ((i & 8) != 0) {
            datazoomMediaTailorConfig = datazoomAnalyticsConfig.mediaTailor;
        }
        return datazoomAnalyticsConfig.copy(str, str2, z, datazoomMediaTailorConfig);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getConfigurationId() {
        return this.configurationId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMetadataJson() {
        return this.metadataJson;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsProduction() {
        return this.isProduction;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final DatazoomMediaTailorConfig getMediaTailor() {
        return this.mediaTailor;
    }

    public final DatazoomAnalyticsConfig copy(String configurationId, String metadataJson, boolean isProduction, DatazoomMediaTailorConfig mediaTailor) {
        Intrinsics.checkNotNullParameter(configurationId, "configurationId");
        Intrinsics.checkNotNullParameter(metadataJson, "metadataJson");
        return new DatazoomAnalyticsConfig(configurationId, metadataJson, isProduction, mediaTailor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DatazoomAnalyticsConfig)) {
            return false;
        }
        DatazoomAnalyticsConfig datazoomAnalyticsConfig = (DatazoomAnalyticsConfig) other;
        return Intrinsics.areEqual(this.configurationId, datazoomAnalyticsConfig.configurationId) && Intrinsics.areEqual(this.metadataJson, datazoomAnalyticsConfig.metadataJson) && this.isProduction == datazoomAnalyticsConfig.isProduction && Intrinsics.areEqual(this.mediaTailor, datazoomAnalyticsConfig.mediaTailor);
    }

    public int hashCode() {
        int iHashCode = ((((this.configurationId.hashCode() * 31) + this.metadataJson.hashCode()) * 31) + Boolean.hashCode(this.isProduction)) * 31;
        DatazoomMediaTailorConfig datazoomMediaTailorConfig = this.mediaTailor;
        return iHashCode + (datazoomMediaTailorConfig == null ? 0 : datazoomMediaTailorConfig.hashCode());
    }

    public String toString() {
        return "DatazoomAnalyticsConfig(configurationId=" + this.configurationId + ", metadataJson=" + this.metadataJson + ", isProduction=" + this.isProduction + ", mediaTailor=" + this.mediaTailor + ")";
    }

    public DatazoomAnalyticsConfig(String configurationId, String metadataJson, boolean z, DatazoomMediaTailorConfig datazoomMediaTailorConfig) {
        Intrinsics.checkNotNullParameter(configurationId, "configurationId");
        Intrinsics.checkNotNullParameter(metadataJson, "metadataJson");
        this.configurationId = configurationId;
        this.metadataJson = metadataJson;
        this.isProduction = z;
        this.mediaTailor = datazoomMediaTailorConfig;
    }

    public /* synthetic */ DatazoomAnalyticsConfig(String str, String str2, boolean z, DatazoomMediaTailorConfig datazoomMediaTailorConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, z, (i & 8) != 0 ? null : datazoomMediaTailorConfig);
    }

    public final String getConfigurationId() {
        return this.configurationId;
    }

    public final String getMetadataJson() {
        return this.metadataJson;
    }

    public final boolean isProduction() {
        return this.isProduction;
    }

    public final DatazoomMediaTailorConfig getMediaTailor() {
        return this.mediaTailor;
    }
}
