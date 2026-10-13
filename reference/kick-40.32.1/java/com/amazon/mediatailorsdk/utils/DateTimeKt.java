package com.amazon.mediatailorsdk.utils;

import java.util.List;
import kotlin.Metadata;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DateTime.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0019\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0000¢\u0006\u0002\u0010\u0004\u001a\u0019\u0010\t\u001a\u0004\u0018\u00010\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0000¢\u0006\u0002\u0010\u0004\"\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"isoTimeStringToSeconds", "", "str", "", "(Ljava/lang/String;)Ljava/lang/Double;", "shortISO8601IntervalRegex", "Lkotlin/text/Regex;", "getShortISO8601IntervalRegex", "()Lkotlin/text/Regex;", "iso8601IntervalToSeconds", "stringValue", "MediaTailor_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class DateTimeKt {
    private static final Regex shortISO8601IntervalRegex = new Regex("P.*T(?:(\\d+)H)?(?:(\\d+)M)?(?:([\\d.]+)S)?");

    public static final Double isoTimeStringToSeconds(String str) {
        if (str == null) {
            return null;
        }
        return DateTime_androidKt.isoDateTimeStringToEpochSeconds("1970-01-01T" + str + "Z");
    }

    public static final Regex getShortISO8601IntervalRegex() {
        return shortISO8601IntervalRegex;
    }

    public static final Double iso8601IntervalToSeconds(String str) {
        MatchResult matchResultFind$default;
        String str2 = str;
        List<String> groupValues = (str2 == null || StringsKt.isBlank(str2) || (matchResultFind$default = Regex.find$default(shortISO8601IntervalRegex, str2, 0, 2, null)) == null) ? null : matchResultFind$default.getGroupValues();
        if (groupValues == null) {
            return null;
        }
        String str3 = groupValues.get(1);
        String str4 = groupValues.get(2);
        String str5 = groupValues.get(3);
        try {
            double d = 0.0d;
            double d2 = (str3.length() == 0 ? 0.0d : Double.parseDouble(str3) * 3600.0d) + (str4.length() == 0 ? 0.0d : Double.parseDouble(str4) * 60.0d);
            if (str5.length() != 0) {
                d = Double.parseDouble(str5);
            }
            return Double.valueOf(d2 + d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}
