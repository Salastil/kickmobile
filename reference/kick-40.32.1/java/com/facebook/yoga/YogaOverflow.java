package com.facebook.yoga;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: YogaOverflow.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0002\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/facebook/yoga/YogaOverflow;", "", "intValue", "", "<init>", "(Ljava/lang/String;II)V", "getIntValue", "()I", "VISIBLE", "HIDDEN", "SCROLL", "Companion", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum YogaOverflow {
    VISIBLE(0),
    HIDDEN(1),
    SCROLL(2);

    private final int intValue;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @JvmStatic
    public static final YogaOverflow fromInt(int i) {
        return INSTANCE.fromInt(i);
    }

    public static EnumEntries<YogaOverflow> getEntries() {
        return $ENTRIES;
    }

    YogaOverflow(int i) {
        this.intValue = i;
    }

    public final int getIntValue() {
        return this.intValue;
    }

    public final int intValue() {
        return this.intValue;
    }

    /* JADX INFO: compiled from: YogaOverflow.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/facebook/yoga/YogaOverflow$Companion;", "", "<init>", "()V", "fromInt", "Lcom/facebook/yoga/YogaOverflow;", "value", "", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final YogaOverflow fromInt(int value) {
            if (value == 0) {
                return YogaOverflow.VISIBLE;
            }
            if (value == 1) {
                return YogaOverflow.HIDDEN;
            }
            if (value == 2) {
                return YogaOverflow.SCROLL;
            }
            throw new IllegalArgumentException("Unknown enum value: " + value);
        }
    }
}
