package com.facebook.yoga;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: YogaJustify.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0002\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, d2 = {"Lcom/facebook/yoga/YogaJustify;", "", "intValue", "", "<init>", "(Ljava/lang/String;II)V", "getIntValue", "()I", "AUTO", "FLEX_START", "CENTER", "FLEX_END", "SPACE_BETWEEN", "SPACE_AROUND", "SPACE_EVENLY", "STRETCH", "START", "END", "Companion", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum YogaJustify {
    AUTO(0),
    FLEX_START(1),
    CENTER(2),
    FLEX_END(3),
    SPACE_BETWEEN(4),
    SPACE_AROUND(5),
    SPACE_EVENLY(6),
    STRETCH(7),
    START(8),
    END(9);

    private final int intValue;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @JvmStatic
    public static final YogaJustify fromInt(int i) {
        return INSTANCE.fromInt(i);
    }

    public static EnumEntries<YogaJustify> getEntries() {
        return $ENTRIES;
    }

    YogaJustify(int i) {
        this.intValue = i;
    }

    public final int getIntValue() {
        return this.intValue;
    }

    public final int intValue() {
        return this.intValue;
    }

    /* JADX INFO: compiled from: YogaJustify.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/facebook/yoga/YogaJustify$Companion;", "", "<init>", "()V", "fromInt", "Lcom/facebook/yoga/YogaJustify;", "value", "", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final YogaJustify fromInt(int value) {
            switch (value) {
                case 0:
                    return YogaJustify.AUTO;
                case 1:
                    return YogaJustify.FLEX_START;
                case 2:
                    return YogaJustify.CENTER;
                case 3:
                    return YogaJustify.FLEX_END;
                case 4:
                    return YogaJustify.SPACE_BETWEEN;
                case 5:
                    return YogaJustify.SPACE_AROUND;
                case 6:
                    return YogaJustify.SPACE_EVENLY;
                case 7:
                    return YogaJustify.STRETCH;
                case 8:
                    return YogaJustify.START;
                case 9:
                    return YogaJustify.END;
                default:
                    throw new IllegalArgumentException("Unknown enum value: " + value);
            }
        }
    }
}
