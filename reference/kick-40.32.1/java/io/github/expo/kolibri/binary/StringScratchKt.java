package io.github.expo.kolibri.binary;

import androidx.emoji2.text.flatbuffer.Utf8Old$$ExternalSyntheticThreadLocal1;
import java.util.function.Supplier;
import kotlin.Metadata;

/* JADX INFO: compiled from: StringScratch.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"8\u0010\u0003\u001a&\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005 \u0006*\u0012\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"STRING_SCRATCH_MIN_CAPACITY", "", "MAX_RETAINED_STRING_UNITS", "stringScratch", "Ljava/lang/ThreadLocal;", "Lio/github/expo/kolibri/binary/StringScratch;", "kotlin.jvm.PlatformType", "getStringScratch", "()Ljava/lang/ThreadLocal;", "runtime"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class StringScratchKt {
    public static final int MAX_RETAINED_STRING_UNITS = 4096;
    public static final int STRING_SCRATCH_MIN_CAPACITY = 128;
    private static final ThreadLocal<StringScratch> stringScratch = new Utf8Old$$ExternalSyntheticThreadLocal1(new Supplier() { // from class: io.github.expo.kolibri.binary.StringScratchKt$$ExternalSyntheticLambda0
        @Override // java.util.function.Supplier
        public final Object get() {
            return new StringScratch();
        }
    });

    public static final ThreadLocal<StringScratch> getStringScratch() {
        return stringScratch;
    }
}
