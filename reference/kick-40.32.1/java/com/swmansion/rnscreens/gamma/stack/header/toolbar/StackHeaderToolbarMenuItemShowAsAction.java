package com.swmansion.rnscreens.gamma.stack.header.toolbar;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: StackHeaderToolbarMenuItemShowAsAction.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0002\b\u000bj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\f"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarMenuItemShowAsAction;", "", "<init>", "(Ljava/lang/String;I)V", "ALWAYS", "ALWAYS_WITH_TEXT", "IF_ROOM", "IF_ROOM_WITH_TEXT", "NEVER", "toNativeShowAsAction", "", "toNativeShowAsAction$react_native_screens_release", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public enum StackHeaderToolbarMenuItemShowAsAction {
    ALWAYS,
    ALWAYS_WITH_TEXT,
    IF_ROOM,
    IF_ROOM_WITH_TEXT,
    NEVER;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: compiled from: StackHeaderToolbarMenuItemShowAsAction.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StackHeaderToolbarMenuItemShowAsAction.values().length];
            try {
                iArr[StackHeaderToolbarMenuItemShowAsAction.ALWAYS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StackHeaderToolbarMenuItemShowAsAction.ALWAYS_WITH_TEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[StackHeaderToolbarMenuItemShowAsAction.IF_ROOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[StackHeaderToolbarMenuItemShowAsAction.IF_ROOM_WITH_TEXT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[StackHeaderToolbarMenuItemShowAsAction.NEVER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static EnumEntries<StackHeaderToolbarMenuItemShowAsAction> getEntries() {
        return $ENTRIES;
    }

    public final int toNativeShowAsAction$react_native_screens_release() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        int i2 = 1;
        if (i == 1) {
            return 2;
        }
        if (i == 2) {
            return 6;
        }
        if (i != 3) {
            i2 = 5;
            if (i != 4) {
                if (i == 5) {
                    return 0;
                }
                throw new NoWhenBranchMatchedException();
            }
        }
        return i2;
    }
}
