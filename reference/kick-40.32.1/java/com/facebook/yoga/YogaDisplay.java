package com.facebook.yoga;

import com.datadog.trace.api.config.ProfilingConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: YogaDisplay.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0002\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/facebook/yoga/YogaDisplay;", "", "intValue", "", "<init>", "(Ljava/lang/String;II)V", "getIntValue", "()I", "FLEX", ProfilingConfig.PROFILING_DATADOG_PROFILER_LOG_LEVEL_DEFAULT, "CONTENTS", "GRID", "Companion", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum YogaDisplay {
    FLEX(0),
    NONE(1),
    CONTENTS(2),
    GRID(3);

    private final int intValue;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @JvmStatic
    public static final YogaDisplay fromInt(int i) {
        return INSTANCE.fromInt(i);
    }

    public static EnumEntries<YogaDisplay> getEntries() {
        return $ENTRIES;
    }

    YogaDisplay(int i) {
        this.intValue = i;
    }

    public final int getIntValue() {
        return this.intValue;
    }

    public final int intValue() {
        return this.intValue;
    }

    /* JADX INFO: compiled from: YogaDisplay.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/facebook/yoga/YogaDisplay$Companion;", "", "<init>", "()V", "fromInt", "Lcom/facebook/yoga/YogaDisplay;", "value", "", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final YogaDisplay fromInt(int value) {
            if (value == 0) {
                return YogaDisplay.FLEX;
            }
            if (value == 1) {
                return YogaDisplay.NONE;
            }
            if (value == 2) {
                return YogaDisplay.CONTENTS;
            }
            if (value == 3) {
                return YogaDisplay.GRID;
            }
            throw new IllegalArgumentException("Unknown enum value: " + value);
        }
    }
}
