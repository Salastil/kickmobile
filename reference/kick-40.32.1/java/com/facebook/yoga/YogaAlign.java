package com.facebook.yoga;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: YogaAlign.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0013B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0002\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0014"}, d2 = {"Lcom/facebook/yoga/YogaAlign;", "", "intValue", "", "<init>", "(Ljava/lang/String;II)V", "getIntValue", "()I", "AUTO", "FLEX_START", "CENTER", "FLEX_END", "STRETCH", "BASELINE", "SPACE_BETWEEN", "SPACE_AROUND", "SPACE_EVENLY", "START", "END", "Companion", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum YogaAlign {
    AUTO(0),
    FLEX_START(1),
    CENTER(2),
    FLEX_END(3),
    STRETCH(4),
    BASELINE(5),
    SPACE_BETWEEN(6),
    SPACE_AROUND(7),
    SPACE_EVENLY(8),
    START(9),
    END(10);

    private final int intValue;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @JvmStatic
    public static final YogaAlign fromInt(int i) {
        return INSTANCE.fromInt(i);
    }

    public static EnumEntries<YogaAlign> getEntries() {
        return $ENTRIES;
    }

    YogaAlign(int i) {
        this.intValue = i;
    }

    public final int getIntValue() {
        return this.intValue;
    }

    public final int intValue() {
        return this.intValue;
    }

    /* JADX INFO: compiled from: YogaAlign.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/facebook/yoga/YogaAlign$Companion;", "", "<init>", "()V", "fromInt", "Lcom/facebook/yoga/YogaAlign;", "value", "", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final YogaAlign fromInt(int value) {
            switch (value) {
                case 0:
                    return YogaAlign.AUTO;
                case 1:
                    return YogaAlign.FLEX_START;
                case 2:
                    return YogaAlign.CENTER;
                case 3:
                    return YogaAlign.FLEX_END;
                case 4:
                    return YogaAlign.STRETCH;
                case 5:
                    return YogaAlign.BASELINE;
                case 6:
                    return YogaAlign.SPACE_BETWEEN;
                case 7:
                    return YogaAlign.SPACE_AROUND;
                case 8:
                    return YogaAlign.SPACE_EVENLY;
                case 9:
                    return YogaAlign.START;
                case 10:
                    return YogaAlign.END;
                default:
                    throw new IllegalArgumentException("Unknown enum value: " + value);
            }
        }
    }
}
