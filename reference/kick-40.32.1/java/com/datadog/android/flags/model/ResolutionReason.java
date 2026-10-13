package com.datadog.android.flags.model;

import com.google.android.gms.cast.MediaError;
import kotlin.Metadata;

/* JADX INFO: compiled from: ResolutionReason.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/datadog/android/flags/model/ResolutionReason;", "", "(Ljava/lang/String;I)V", "STATIC", "DEFAULT", "TARGETING_MATCH", "SPLIT", "RULE_MATCH", "PREREQUISITE_FAILED", MediaError.ERROR_TYPE_ERROR, "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum ResolutionReason {
    STATIC,
    DEFAULT,
    TARGETING_MATCH,
    SPLIT,
    RULE_MATCH,
    PREREQUISITE_FAILED,
    ERROR
}
