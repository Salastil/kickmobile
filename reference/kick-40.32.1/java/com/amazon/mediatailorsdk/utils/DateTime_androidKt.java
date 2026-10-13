package com.amazon.mediatailorsdk.utils;

import kotlin.Metadata;
import kotlin.text.StringsKt;
import org.threeten.bp.Instant;

/* JADX INFO: compiled from: DateTime.android.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0000¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"isoDateTimeStringToEpochSeconds", "", "str", "", "(Ljava/lang/String;)Ljava/lang/Double;", "MediaTailor_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class DateTime_androidKt {
    public static final Double isoDateTimeStringToEpochSeconds(String str) {
        String str2 = str;
        if (str2 == null || StringsKt.isBlank(str2)) {
            return null;
        }
        try {
            return Double.valueOf(Instant.parse(str).toEpochMilli() / 1000.0d);
        } catch (Exception unused) {
            return null;
        }
    }
}
