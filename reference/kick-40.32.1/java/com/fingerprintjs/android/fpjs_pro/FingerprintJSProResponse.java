package com.fingerprintjs.android.fpjs_pro;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B{\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÇ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u000eHÇ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÇ\u0003¢\u0006\u0004\b\u001a\u0010\u0017J\u0010\u0010\u001b\u001a\u00020\u0002HÇ\u0003¢\u0006\u0004\b\u001b\u0010\u0017J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0002HÇ\u0003¢\u0006\u0004\b\u001c\u0010\u0017J\u0010\u0010\u001d\u001a\u00020\u0002HÇ\u0003¢\u0006\u0004\b\u001d\u0010\u0017J\u0010\u0010\u001e\u001a\u00020\u0005HÇ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0002HÇ\u0003¢\u0006\u0004\b\"\u0010\u0017J\u0012\u0010#\u001a\u0004\u0018\u00010\nHÇ\u0003¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u0002HÇ\u0003¢\u0006\u0004\b%\u0010\u0017J\u0010\u0010&\u001a\u00020\u0002HÇ\u0003¢\u0006\u0004\b&\u0010\u0017J\u0010\u0010'\u001a\u00020\u000eHÇ\u0003¢\u0006\u0004\b'\u0010\u0019J\u0098\u0001\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÇ\u0001¢\u0006\u0004\b(\u0010)J\u001a\u0010+\u001a\u00020\u00072\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b+\u0010,J\u0010\u0010.\u001a\u00020-HÖ\u0001¢\u0006\u0004\b.\u0010/J\u0010\u00100\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b0\u0010\u0017R\u001a\u0010\u0012\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u00101\u001a\u0004\b2\u0010\u0017R\u001a\u0010\u0006\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u00103\u001a\u0004\b4\u0010\u001fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u00101\u001a\u0004\b5\u0010\u0017R\u001a\u0010\u000f\u001a\u00020\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u00106\u001a\u0004\b7\u0010\u0019R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u00101\u001a\u0004\b8\u0010\u0017R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u00109\u001a\u0004\b:\u0010$R\u001a\u0010\u0010\u001a\u00020\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u00106\u001a\u0004\b;\u0010\u0019R\u001a\u0010\f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u00101\u001a\u0004\b<\u0010\u0017R\u001a\u0010\r\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u00101\u001a\u0004\b=\u0010\u0017R\u001a\u0010\u0003\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u00101\u001a\u0004\b>\u0010\u0017R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u00101\u001a\u0004\b?\u0010\u0017R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010@\u001a\u0004\bA\u0010!R\u001a\u0010\u0004\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u00101\u001a\u0004\bB\u0010\u0017"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro/FingerprintJSProResponse;", "", "", "requestId", "visitorId", "Lcom/fingerprintjs/android/fpjs_pro/ConfidenceScore;", "confidenceScore", "", "visitorFound", "ipAddress", "Lcom/fingerprintjs/android/fpjs_pro/IpLocation;", "ipLocation", "osName", "osVersion", "Lcom/fingerprintjs/android/fpjs_pro/Timestamp;", "firstSeenAt", "lastSeenAt", "sealedResult", "asJson", "errorMessage", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/fingerprintjs/android/fpjs_pro/ConfidenceScore;ZLjava/lang/String;Lcom/fingerprintjs/android/fpjs_pro/IpLocation;Ljava/lang/String;Ljava/lang/String;Lcom/fingerprintjs/android/fpjs_pro/Timestamp;Lcom/fingerprintjs/android/fpjs_pro/Timestamp;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "component1", "()Ljava/lang/String;", "component10", "()Lcom/fingerprintjs/android/fpjs_pro/Timestamp;", "component11", "component12", "component13", "component2", "component3", "()Lcom/fingerprintjs/android/fpjs_pro/ConfidenceScore;", "component4", "()Z", "component5", "component6", "()Lcom/fingerprintjs/android/fpjs_pro/IpLocation;", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/fingerprintjs/android/fpjs_pro/ConfidenceScore;ZLjava/lang/String;Lcom/fingerprintjs/android/fpjs_pro/IpLocation;Ljava/lang/String;Ljava/lang/String;Lcom/fingerprintjs/android/fpjs_pro/Timestamp;Lcom/fingerprintjs/android/fpjs_pro/Timestamp;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/fingerprintjs/android/fpjs_pro/FingerprintJSProResponse;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAsJson", "Lcom/fingerprintjs/android/fpjs_pro/ConfidenceScore;", "getConfidenceScore", "getErrorMessage", "Lcom/fingerprintjs/android/fpjs_pro/Timestamp;", "getFirstSeenAt", "getIpAddress", "Lcom/fingerprintjs/android/fpjs_pro/IpLocation;", "getIpLocation", "getLastSeenAt", "getOsName", "getOsVersion", "getRequestId", "getSealedResult", "Z", "getVisitorFound", "getVisitorId"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class FingerprintJSProResponse {
    private final String asJson;
    private final ConfidenceScore confidenceScore;
    private final String errorMessage;
    private final Timestamp firstSeenAt;
    private final String ipAddress;
    private final IpLocation ipLocation;
    private final Timestamp lastSeenAt;
    private final String osName;
    private final String osVersion;
    private final String requestId;
    private final String sealedResult;
    private final boolean visitorFound;
    private final String visitorId;

    public FingerprintJSProResponse(String str, String str2, ConfidenceScore confidenceScore, boolean z, String str3, IpLocation ipLocation, String str4, String str5, Timestamp timestamp, Timestamp timestamp2, String str6, String str7, String str8) {
        this.requestId = str;
        this.visitorId = str2;
        this.confidenceScore = confidenceScore;
        this.visitorFound = z;
        this.ipAddress = str3;
        this.ipLocation = ipLocation;
        this.osName = str4;
        this.osVersion = str5;
        this.firstSeenAt = timestamp;
        this.lastSeenAt = timestamp2;
        this.sealedResult = str6;
        this.asJson = str7;
        this.errorMessage = str8;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final String getVisitorId() {
        return this.visitorId;
    }

    public final ConfidenceScore getConfidenceScore() {
        return this.confidenceScore;
    }

    public final boolean getVisitorFound() {
        return this.visitorFound;
    }

    public final String getIpAddress() {
        return this.ipAddress;
    }

    public final IpLocation getIpLocation() {
        return this.ipLocation;
    }

    public final String getOsName() {
        return this.osName;
    }

    public final String getOsVersion() {
        return this.osVersion;
    }

    public final Timestamp getFirstSeenAt() {
        return this.firstSeenAt;
    }

    public final Timestamp getLastSeenAt() {
        return this.lastSeenAt;
    }

    public final String getSealedResult() {
        return this.sealedResult;
    }

    public /* synthetic */ FingerprintJSProResponse(String str, String str2, ConfidenceScore confidenceScore, boolean z, String str3, IpLocation ipLocation, String str4, String str5, Timestamp timestamp, Timestamp timestamp2, String str6, String str7, String str8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, confidenceScore, z, str3, ipLocation, str4, str5, timestamp, timestamp2, (i & 1024) != 0 ? null : str6, (i & 2048) != 0 ? "" : str7, (i & 4096) != 0 ? null : str8);
    }

    public final String getAsJson() {
        return this.asJson;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FingerprintJSProResponse)) {
            return false;
        }
        FingerprintJSProResponse fingerprintJSProResponse = (FingerprintJSProResponse) other;
        return Intrinsics.areEqual(this.requestId, fingerprintJSProResponse.requestId) && Intrinsics.areEqual(this.visitorId, fingerprintJSProResponse.visitorId) && Intrinsics.areEqual(this.confidenceScore, fingerprintJSProResponse.confidenceScore) && this.visitorFound == fingerprintJSProResponse.visitorFound && Intrinsics.areEqual(this.ipAddress, fingerprintJSProResponse.ipAddress) && Intrinsics.areEqual(this.ipLocation, fingerprintJSProResponse.ipLocation) && Intrinsics.areEqual(this.osName, fingerprintJSProResponse.osName) && Intrinsics.areEqual(this.osVersion, fingerprintJSProResponse.osVersion) && Intrinsics.areEqual(this.firstSeenAt, fingerprintJSProResponse.firstSeenAt) && Intrinsics.areEqual(this.lastSeenAt, fingerprintJSProResponse.lastSeenAt) && Intrinsics.areEqual(this.sealedResult, fingerprintJSProResponse.sealedResult) && Intrinsics.areEqual(this.asJson, fingerprintJSProResponse.asJson) && Intrinsics.areEqual(this.errorMessage, fingerprintJSProResponse.errorMessage);
    }

    public final int hashCode() {
        int iHashCode = ((((((((this.requestId.hashCode() * 31) + this.visitorId.hashCode()) * 31) + this.confidenceScore.hashCode()) * 31) + Boolean.hashCode(this.visitorFound)) * 31) + this.ipAddress.hashCode()) * 31;
        IpLocation ipLocation = this.ipLocation;
        int iHashCode2 = (((((((((iHashCode + (ipLocation == null ? 0 : ipLocation.hashCode())) * 31) + this.osName.hashCode()) * 31) + this.osVersion.hashCode()) * 31) + this.firstSeenAt.hashCode()) * 31) + this.lastSeenAt.hashCode()) * 31;
        String str = this.sealedResult;
        int iHashCode3 = (((iHashCode2 + (str == null ? 0 : str.hashCode())) * 31) + this.asJson.hashCode()) * 31;
        String str2 = this.errorMessage;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        return "FingerprintJSProResponse(requestId=" + this.requestId + ", visitorId=" + this.visitorId + ", confidenceScore=" + this.confidenceScore + ", visitorFound=" + this.visitorFound + ", ipAddress=" + this.ipAddress + ", ipLocation=" + this.ipLocation + ", osName=" + this.osName + ", osVersion=" + this.osVersion + ", firstSeenAt=" + this.firstSeenAt + ", lastSeenAt=" + this.lastSeenAt + ", sealedResult=" + this.sealedResult + ", asJson=" + this.asJson + ", errorMessage=" + this.errorMessage + ")";
    }

    public static /* synthetic */ FingerprintJSProResponse copy$default(FingerprintJSProResponse fingerprintJSProResponse, String str, String str2, ConfidenceScore confidenceScore, boolean z, String str3, IpLocation ipLocation, String str4, String str5, Timestamp timestamp, Timestamp timestamp2, String str6, String str7, String str8, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fingerprintJSProResponse.requestId;
        }
        return fingerprintJSProResponse.copy(str, (i & 2) != 0 ? fingerprintJSProResponse.visitorId : str2, (i & 4) != 0 ? fingerprintJSProResponse.confidenceScore : confidenceScore, (i & 8) != 0 ? fingerprintJSProResponse.visitorFound : z, (i & 16) != 0 ? fingerprintJSProResponse.ipAddress : str3, (i & 32) != 0 ? fingerprintJSProResponse.ipLocation : ipLocation, (i & 64) != 0 ? fingerprintJSProResponse.osName : str4, (i & 128) != 0 ? fingerprintJSProResponse.osVersion : str5, (i & 256) != 0 ? fingerprintJSProResponse.firstSeenAt : timestamp, (i & 512) != 0 ? fingerprintJSProResponse.lastSeenAt : timestamp2, (i & 1024) != 0 ? fingerprintJSProResponse.sealedResult : str6, (i & 2048) != 0 ? fingerprintJSProResponse.asJson : str7, (i & 4096) != 0 ? fingerprintJSProResponse.errorMessage : str8);
    }

    public final FingerprintJSProResponse copy(String requestId, String visitorId, ConfidenceScore confidenceScore, boolean visitorFound, String ipAddress, IpLocation ipLocation, String osName, String osVersion, Timestamp firstSeenAt, Timestamp lastSeenAt, String sealedResult, String asJson, String errorMessage) {
        return new FingerprintJSProResponse(requestId, visitorId, confidenceScore, visitorFound, ipAddress, ipLocation, osName, osVersion, firstSeenAt, lastSeenAt, sealedResult, asJson, errorMessage);
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getAsJson() {
        return this.asJson;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getSealedResult() {
        return this.sealedResult;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Timestamp getLastSeenAt() {
        return this.lastSeenAt;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Timestamp getFirstSeenAt() {
        return this.firstSeenAt;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getOsVersion() {
        return this.osVersion;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getOsName() {
        return this.osName;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final IpLocation getIpLocation() {
        return this.ipLocation;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getIpAddress() {
        return this.ipAddress;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getVisitorFound() {
        return this.visitorFound;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ConfidenceScore getConfidenceScore() {
        return this.confidenceScore;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getVisitorId() {
        return this.visitorId;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getRequestId() {
        return this.requestId;
    }
}
