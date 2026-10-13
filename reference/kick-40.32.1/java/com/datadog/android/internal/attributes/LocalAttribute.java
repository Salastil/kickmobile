package com.datadog.android.internal.attributes;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;

/* JADX INFO: compiled from: LocalAttribute.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/datadog/android/internal/attributes/LocalAttribute;", "", "Constant", "Key", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface LocalAttribute {

    /* JADX INFO: compiled from: LocalAttribute.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/datadog/android/internal/attributes/LocalAttribute$Constant;", "", "key", "Lcom/datadog/android/internal/attributes/LocalAttribute$Key;", "getKey", "()Lcom/datadog/android/internal/attributes/LocalAttribute$Key;", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Constant {
        Key getKey();
    }

    /* JADX INFO: compiled from: LocalAttribute.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/datadog/android/internal/attributes/LocalAttribute$Key;", "", TypedValues.Custom.S_STRING, "", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "CREATION_SAMPLING_RATE", "REPORTING_SAMPLING_RATE", "VIEW_SCOPE_INSTRUMENTATION_TYPE", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum Key {
        CREATION_SAMPLING_RATE("_dd.local.head_sampling_rate_key"),
        REPORTING_SAMPLING_RATE("_dd.local.tail_sampling_rate_key"),
        VIEW_SCOPE_INSTRUMENTATION_TYPE("_dd.local.view_instrumentation_type_key");

        private final String string;

        Key(String str) {
            this.string = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.string;
        }
    }
}
