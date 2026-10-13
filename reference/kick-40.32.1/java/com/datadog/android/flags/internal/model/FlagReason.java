package com.datadog.android.flags.internal.model;

import com.google.android.gms.cast.MediaError;
import kotlin.Metadata;

/* JADX INFO: compiled from: PrecomputedFlagConstants.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/datadog/android/flags/internal/model/FlagReason;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "DEFAULT", "TARGETING_MATCH", "RULE_MATCH", "PREREQUISITE_FAILED", MediaError.ERROR_TYPE_ERROR, "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum FlagReason {
    DEFAULT("DEFAULT"),
    TARGETING_MATCH("TARGETING_MATCH"),
    RULE_MATCH("RULE_MATCH"),
    PREREQUISITE_FAILED("PREREQUISITE_FAILED"),
    ERROR(MediaError.ERROR_TYPE_ERROR);

    private final String value;

    FlagReason(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
