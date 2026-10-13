package com.datadog.android.telemetry.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TelemetryEventId.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/datadog/android/telemetry/internal/TelemetryEventId;", "", "type", "Lcom/datadog/android/telemetry/internal/TelemetryType;", "message", "", "kind", "(Lcom/datadog/android/telemetry/internal/TelemetryType;Ljava/lang/String;Ljava/lang/String;)V", "getKind", "()Ljava/lang/String;", "getMessage", "getType", "()Lcom/datadog/android/telemetry/internal/TelemetryType;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class TelemetryEventId {
    private final String kind;
    private final String message;
    private final TelemetryType type;

    public static /* synthetic */ TelemetryEventId copy$default(TelemetryEventId telemetryEventId, TelemetryType telemetryType, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            telemetryType = telemetryEventId.type;
        }
        if ((i & 2) != 0) {
            str = telemetryEventId.message;
        }
        if ((i & 4) != 0) {
            str2 = telemetryEventId.kind;
        }
        return telemetryEventId.copy(telemetryType, str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final TelemetryType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getKind() {
        return this.kind;
    }

    public final TelemetryEventId copy(TelemetryType type, String message, String kind) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(message, "message");
        return new TelemetryEventId(type, message, kind);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TelemetryEventId)) {
            return false;
        }
        TelemetryEventId telemetryEventId = (TelemetryEventId) other;
        return this.type == telemetryEventId.type && Intrinsics.areEqual(this.message, telemetryEventId.message) && Intrinsics.areEqual(this.kind, telemetryEventId.kind);
    }

    public int hashCode() {
        int iHashCode = ((this.type.hashCode() * 31) + this.message.hashCode()) * 31;
        String str = this.kind;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "TelemetryEventId(type=" + this.type + ", message=" + this.message + ", kind=" + this.kind + ")";
    }

    public TelemetryEventId(TelemetryType type, String message, String str) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(message, "message");
        this.type = type;
        this.message = message;
        this.kind = str;
    }

    public final TelemetryType getType() {
        return this.type;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getKind() {
        return this.kind;
    }
}
