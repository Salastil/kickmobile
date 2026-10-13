package com.datadog.android.rum.featureoperations;

import com.google.android.gms.cast.MediaError;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* JADX INFO: compiled from: FailureReason.kt */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated(message = "Use com.datadog.android.rum.operations.FailureReason instead", replaceWith = @ReplaceWith(expression = "FailureReason", imports = {"com.datadog.android.rum.operations.FailureReason"}))
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/datadog/android/rum/featureoperations/FailureReason;", "", "(Ljava/lang/String;I)V", MediaError.ERROR_TYPE_ERROR, "ABANDONED", "OTHER", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum FailureReason {
    ERROR,
    ABANDONED,
    OTHER
}
