package io.datazoom.sdk.utils;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.hermes.intl.Constants;
import kotlin.Metadata;

/* JADX INFO: compiled from: PrimitiveExtensions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0011\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0002\u001a\u0011\u0010\u0003\u001a\u00020\u0001*\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0002\u001a\f\u0010\u0004\u001a\u00020\u0005*\u0004\u0018\u00010\u0005\u001a\u001b\u0010\u0006\u001a\u00020\u0007\"\b\b\u0000\u0010\b*\u00020\u0007*\u0004\u0018\u0001H\b¢\u0006\u0002\u0010\t\u001a\n\u0010\n\u001a\u00020\u000b*\u00020\u000b\u001a\u001c\u0010\f\u001a\u00020\u000b*\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0086\u0004¢\u0006\u0002\u0010\u000e\u001a\u001c\u0010\f\u001a\u00020\u000f*\u0004\u0018\u00010\u000f2\u0006\u0010\r\u001a\u00020\u000fH\u0086\u0004¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"orFalse", "", "(Ljava/lang/Boolean;)Z", "orTrue", "orEmpty", "", "orZero", "", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/Number;)Ljava/lang/Number;", "validateDuration", "", "dividedBy", "value", "(Ljava/lang/Long;J)J", "", "(Ljava/lang/Integer;I)I", Constants.SENSITIVITY_BASE}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class PrimitiveExtensionsKt {
    public static final long validateDuration(long j) {
        if (j < 0) {
            return 0L;
        }
        return j;
    }

    public static final boolean orFalse(Boolean bool) {
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static final boolean orTrue(Boolean bool) {
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static final String orEmpty(String str) {
        return str == null ? "" : str;
    }

    public static final <T extends Number> Number orZero(T t) {
        return t == null ? (Number) 0 : t;
    }

    public static final long dividedBy(Long l, long j) {
        if (l == null || l.longValue() <= 0) {
            return 0L;
        }
        return l.longValue() / j;
    }

    public static final int dividedBy(Integer num, int i) {
        if (num == null || num.intValue() <= 0) {
            return 0;
        }
        return num.intValue() / i;
    }
}
