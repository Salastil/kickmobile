package com.facebook.yoga;

import com.datadog.trace.api.config.ProfilingConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.apache.commons.codec.language.bm.Rule;

/* JADX INFO: compiled from: YogaErrata.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0002\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/facebook/yoga/YogaErrata;", "", "intValue", "", "<init>", "(Ljava/lang/String;II)V", "getIntValue", "()I", ProfilingConfig.PROFILING_DATADOG_PROFILER_LOG_LEVEL_DEFAULT, "STRETCH_FLEX_BASIS", "ABSOLUTE_POSITION_WITHOUT_INSETS_EXCLUDES_PADDING", "ABSOLUTE_PERCENT_AGAINST_INNER_SIZE", "MIN_SIZE_UNDEFINED_INSTEAD_OF_AUTO", Rule.ALL, "CLASSIC", "Companion", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum YogaErrata {
    NONE(0),
    STRETCH_FLEX_BASIS(1),
    ABSOLUTE_POSITION_WITHOUT_INSETS_EXCLUDES_PADDING(2),
    ABSOLUTE_PERCENT_AGAINST_INNER_SIZE(4),
    MIN_SIZE_UNDEFINED_INSTEAD_OF_AUTO(8),
    ALL(Integer.MAX_VALUE),
    CLASSIC(2147483646);

    private final int intValue;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @JvmStatic
    public static final YogaErrata fromInt(int i) {
        return INSTANCE.fromInt(i);
    }

    public static EnumEntries<YogaErrata> getEntries() {
        return $ENTRIES;
    }

    YogaErrata(int i) {
        this.intValue = i;
    }

    public final int getIntValue() {
        return this.intValue;
    }

    public final int intValue() {
        return this.intValue;
    }

    /* JADX INFO: compiled from: YogaErrata.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/facebook/yoga/YogaErrata$Companion;", "", "<init>", "()V", "fromInt", "Lcom/facebook/yoga/YogaErrata;", "value", "", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final YogaErrata fromInt(int value) {
            if (value == 0) {
                return YogaErrata.NONE;
            }
            if (value == 1) {
                return YogaErrata.STRETCH_FLEX_BASIS;
            }
            if (value == 2) {
                return YogaErrata.ABSOLUTE_POSITION_WITHOUT_INSETS_EXCLUDES_PADDING;
            }
            if (value == 4) {
                return YogaErrata.ABSOLUTE_PERCENT_AGAINST_INNER_SIZE;
            }
            if (value == 8) {
                return YogaErrata.MIN_SIZE_UNDEFINED_INSTEAD_OF_AUTO;
            }
            switch (value) {
                case 2147483646:
                    return YogaErrata.CLASSIC;
                case Integer.MAX_VALUE:
                    return YogaErrata.ALL;
                default:
                    throw new IllegalArgumentException("Unknown enum value: " + value);
            }
        }
    }
}
