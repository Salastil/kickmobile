package com.datadog.android.flags.internal.model;

import com.datadog.android.rum.internal.RumFeature;
import kotlin.Metadata;

/* JADX INFO: compiled from: PrecomputedFlagConstants.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/datadog/android/flags/internal/model/JsonKeys;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "EVALUATION_CONTEXT", "TARGETING_KEY", "ATTRIBUTES", "FLAGS", "LAST_UPDATE_TIMESTAMP", "VARIATION_TYPE", "VARIATION_VALUE", "DO_LOG", "ALLOCATION_KEY", "VARIATION_KEY", "EXTRA_LOGGING", "REASON", "SERIAL_ID", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum JsonKeys {
    EVALUATION_CONTEXT("evaluationContext"),
    TARGETING_KEY("targetingKey"),
    ATTRIBUTES(RumFeature.EVENT_ATTRIBUTES_PROPERTY),
    FLAGS("flags"),
    LAST_UPDATE_TIMESTAMP("lastUpdateTimestamp"),
    VARIATION_TYPE("variationType"),
    VARIATION_VALUE("variationValue"),
    DO_LOG("doLog"),
    ALLOCATION_KEY("allocationKey"),
    VARIATION_KEY("variationKey"),
    EXTRA_LOGGING("extraLogging"),
    REASON("reason"),
    SERIAL_ID("serialId");

    private final String value;

    JsonKeys(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
