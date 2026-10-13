package com.datadog.android.trace.internal.domain.event;

import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: BigIntegerUtils.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007J\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0002R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/datadog/android/trace/internal/domain/event/BigIntegerUtils;", "", "()V", "HEX_RADIX", "", "LONG_BITS_SIZE", "LONG_MASK", "Ljava/math/BigInteger;", "getLONG_MASK$annotations", "REQUIRED_ID_HEX_LENGTH", "leastSignificant64BitsAsDecimal", "", "traceId", "leastSignificant64BitsAsHex", "mostSignificant64BitsAsHex", "dd-sdk-android-trace-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BigIntegerUtils {
    private static final int HEX_RADIX = 16;
    private static final int LONG_BITS_SIZE = 64;
    private static final int REQUIRED_ID_HEX_LENGTH = 16;
    public static final BigIntegerUtils INSTANCE = new BigIntegerUtils();
    private static final BigInteger LONG_MASK = new BigInteger("ffffffffffffffff", 16);

    private static /* synthetic */ void getLONG_MASK$annotations() {
    }

    private BigIntegerUtils() {
    }

    public final String leastSignificant64BitsAsHex(BigInteger traceId) {
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        try {
            String string = traceId.and(LONG_MASK).toString(16);
            Intrinsics.checkNotNullExpressionValue(string, "traceId.and(LONG_MASK).toString(HEX_RADIX)");
            return StringsKt.padStart(string, 16, '0');
        } catch (ArithmeticException | NumberFormatException | IllegalArgumentException unused) {
            return "";
        }
    }

    public final String leastSignificant64BitsAsDecimal(BigInteger traceId) {
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        try {
            String string = traceId.and(LONG_MASK).toString();
            Intrinsics.checkNotNullExpressionValue(string, "{\n            traceId.an…ASK).toString()\n        }");
            return string;
        } catch (ArithmeticException | NumberFormatException unused) {
            return "";
        }
    }

    public final String mostSignificant64BitsAsHex(BigInteger traceId) {
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        try {
            String string = traceId.shiftRight(64).toString(16);
            Intrinsics.checkNotNullExpressionValue(string, "traceId.shiftRight(LONG_…SIZE).toString(HEX_RADIX)");
            return StringsKt.padStart(string, 16, '0');
        } catch (ArithmeticException | NumberFormatException | IllegalArgumentException unused) {
            return "";
        }
    }
}
