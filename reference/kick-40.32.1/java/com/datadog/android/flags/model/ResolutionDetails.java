package com.datadog.android.flags.model;

import androidx.exifinterface.media.ExifInterface;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ResolutionDetails.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002BS\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\f¢\u0006\u0002\u0010\rJ\u000e\u0010\u001a\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0015\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\fHÆ\u0003Jd\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\fHÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011¨\u0006("}, d2 = {"Lcom/datadog/android/flags/model/ResolutionDetails;", ExifInterface.GPS_DIRECTION_TRUE, "", "value", "variant", "", "reason", "Lcom/datadog/android/flags/model/ResolutionReason;", "errorCode", "Lcom/datadog/android/flags/model/ErrorCode;", "errorMessage", "flagMetadata", "", "(Ljava/lang/Object;Ljava/lang/String;Lcom/datadog/android/flags/model/ResolutionReason;Lcom/datadog/android/flags/model/ErrorCode;Ljava/lang/String;Ljava/util/Map;)V", "getErrorCode", "()Lcom/datadog/android/flags/model/ErrorCode;", "getErrorMessage", "()Ljava/lang/String;", "getFlagMetadata", "()Ljava/util/Map;", "getReason", "()Lcom/datadog/android/flags/model/ResolutionReason;", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getVariant", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Object;Ljava/lang/String;Lcom/datadog/android/flags/model/ResolutionReason;Lcom/datadog/android/flags/model/ErrorCode;Ljava/lang/String;Ljava/util/Map;)Lcom/datadog/android/flags/model/ResolutionDetails;", "equals", "", "other", "hashCode", "", "toString", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ResolutionDetails<T> {
    private final ErrorCode errorCode;
    private final String errorMessage;
    private final Map<String, Object> flagMetadata;
    private final ResolutionReason reason;
    private final T value;
    private final String variant;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ResolutionDetails copy$default(ResolutionDetails resolutionDetails, Object obj, String str, ResolutionReason resolutionReason, ErrorCode errorCode, String str2, Map map, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = resolutionDetails.value;
        }
        if ((i & 2) != 0) {
            str = resolutionDetails.variant;
        }
        if ((i & 4) != 0) {
            resolutionReason = resolutionDetails.reason;
        }
        if ((i & 8) != 0) {
            errorCode = resolutionDetails.errorCode;
        }
        if ((i & 16) != 0) {
            str2 = resolutionDetails.errorMessage;
        }
        if ((i & 32) != 0) {
            map = resolutionDetails.flagMetadata;
        }
        String str3 = str2;
        Map map2 = map;
        return resolutionDetails.copy(obj, str, resolutionReason, errorCode, str3, map2);
    }

    public final T component1() {
        return this.value;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getVariant() {
        return this.variant;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ResolutionReason getReason() {
        return this.reason;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final ErrorCode getErrorCode() {
        return this.errorCode;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final Map<String, Object> component6() {
        return this.flagMetadata;
    }

    public final ResolutionDetails<T> copy(T value, String variant, ResolutionReason reason, ErrorCode errorCode, String errorMessage, Map<String, ? extends Object> flagMetadata) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(flagMetadata, "flagMetadata");
        return new ResolutionDetails<>(value, variant, reason, errorCode, errorMessage, flagMetadata);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResolutionDetails)) {
            return false;
        }
        ResolutionDetails resolutionDetails = (ResolutionDetails) other;
        return Intrinsics.areEqual(this.value, resolutionDetails.value) && Intrinsics.areEqual(this.variant, resolutionDetails.variant) && this.reason == resolutionDetails.reason && this.errorCode == resolutionDetails.errorCode && Intrinsics.areEqual(this.errorMessage, resolutionDetails.errorMessage) && Intrinsics.areEqual(this.flagMetadata, resolutionDetails.flagMetadata);
    }

    public int hashCode() {
        int iHashCode = this.value.hashCode() * 31;
        String str = this.variant;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        ResolutionReason resolutionReason = this.reason;
        int iHashCode3 = (iHashCode2 + (resolutionReason == null ? 0 : resolutionReason.hashCode())) * 31;
        ErrorCode errorCode = this.errorCode;
        int iHashCode4 = (iHashCode3 + (errorCode == null ? 0 : errorCode.hashCode())) * 31;
        String str2 = this.errorMessage;
        return ((iHashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.flagMetadata.hashCode();
    }

    public String toString() {
        return "ResolutionDetails(value=" + this.value + ", variant=" + this.variant + ", reason=" + this.reason + ", errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + ", flagMetadata=" + this.flagMetadata + ")";
    }

    public ResolutionDetails(T value, String str, ResolutionReason resolutionReason, ErrorCode errorCode, String str2, Map<String, ? extends Object> flagMetadata) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(flagMetadata, "flagMetadata");
        this.value = value;
        this.variant = str;
        this.reason = resolutionReason;
        this.errorCode = errorCode;
        this.errorMessage = str2;
        this.flagMetadata = flagMetadata;
    }

    public final T getValue() {
        return this.value;
    }

    public final String getVariant() {
        return this.variant;
    }

    public final ResolutionReason getReason() {
        return this.reason;
    }

    public final ErrorCode getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public /* synthetic */ ResolutionDetails(Object obj, String str, ResolutionReason resolutionReason, ErrorCode errorCode, String str2, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : resolutionReason, (i & 8) != 0 ? null : errorCode, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? MapsKt.emptyMap() : map);
    }

    public final Map<String, Object> getFlagMetadata() {
        return this.flagMetadata;
    }
}
