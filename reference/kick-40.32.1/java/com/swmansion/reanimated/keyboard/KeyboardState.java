package com.swmansion.reanimated.keyboard;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: KeyboardState.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000b\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/swmansion/reanimated/keyboard/KeyboardState;", "", "mValue", "", "<init>", "(Ljava/lang/String;II)V", "UNKNOWN", "OPENING", "OPEN", "CLOSING", "CLOSED", "asInt", "react-native-reanimated_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public enum KeyboardState {
    UNKNOWN(0),
    OPENING(1),
    OPEN(2),
    CLOSING(3),
    CLOSED(4);

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final int mValue;

    public static EnumEntries<KeyboardState> getEntries() {
        return $ENTRIES;
    }

    KeyboardState(int i) {
        this.mValue = i;
    }

    /* JADX INFO: renamed from: asInt, reason: from getter */
    public final int getMValue() {
        return this.mValue;
    }
}
