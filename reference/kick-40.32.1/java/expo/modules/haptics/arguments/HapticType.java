package expo.modules.haptics.arguments;

import android.os.Build;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: HapticsTypes.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001cH\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u001e\u001a\u00020\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006!"}, d2 = {"Lexpo/modules/haptics/arguments/HapticType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CONFIRM", "REJECT", "GESTURE_START", "GESTURE_END", "TOGGLE_ON", "TOGGLE_OFF", "CLOCK_TICK", "CONTEXT_CLICK", "DRAG_START", "KEYBOARD_TAP", "KEYBOARD_PRESS", "KEYBOARD_RELEASE", "LONG_PRESS", "VIRTUAL_KEY", "NO_HAPTICS", "SEGMENT_TICK", "SEGMENT_FREQUENT_TICK", "TEXT_HANDLE_MOVE", "VIRTUAL_KEY_RELEASE", "toHapticFeedbackType", "", "sdkInt", "addedInSdk", "getAddedInSdk", "()I", "expo-haptics_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum HapticType {
    CONFIRM("confirm"),
    REJECT("reject"),
    GESTURE_START("gesture-start"),
    GESTURE_END("gesture-end"),
    TOGGLE_ON("toggle-on"),
    TOGGLE_OFF("toggle-off"),
    CLOCK_TICK("clock-tick"),
    CONTEXT_CLICK("context-click"),
    DRAG_START("drag-start"),
    KEYBOARD_TAP("keyboard-tap"),
    KEYBOARD_PRESS("keyboard-press"),
    KEYBOARD_RELEASE("keyboard-release"),
    LONG_PRESS("long-press"),
    VIRTUAL_KEY("virtual-key"),
    NO_HAPTICS("no-haptics"),
    SEGMENT_TICK("segment-tick"),
    SEGMENT_FREQUENT_TICK("segment-frequent-tick"),
    TEXT_HANDLE_MOVE("text-handle-move"),
    VIRTUAL_KEY_RELEASE("virtual-key-release");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String value;

    /* JADX INFO: compiled from: HapticsTypes.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HapticType.values().length];
            try {
                iArr[HapticType.CONFIRM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HapticType.REJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[HapticType.GESTURE_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[HapticType.GESTURE_END.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[HapticType.TOGGLE_ON.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[HapticType.TOGGLE_OFF.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[HapticType.CLOCK_TICK.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[HapticType.CONTEXT_CLICK.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[HapticType.DRAG_START.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[HapticType.KEYBOARD_TAP.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[HapticType.KEYBOARD_PRESS.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[HapticType.KEYBOARD_RELEASE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[HapticType.LONG_PRESS.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[HapticType.VIRTUAL_KEY.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[HapticType.NO_HAPTICS.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[HapticType.SEGMENT_TICK.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[HapticType.SEGMENT_FREQUENT_TICK.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[HapticType.TEXT_HANDLE_MOVE.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[HapticType.VIRTUAL_KEY_RELEASE.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static EnumEntries<HapticType> getEntries() {
        return $ENTRIES;
    }

    HapticType(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    public static /* synthetic */ int toHapticFeedbackType$default(HapticType hapticType, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toHapticFeedbackType");
        }
        if ((i2 & 1) != 0) {
            i = Build.VERSION.SDK_INT;
        }
        return hapticType.toHapticFeedbackType(i);
    }

    public final int toHapticFeedbackType(int sdkInt) throws HapticTypeNotSupportedException {
        if (sdkInt < getAddedInSdk()) {
            throw new HapticTypeNotSupportedException(this.value);
        }
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                return 16;
            case 2:
                return 17;
            case 3:
                return 12;
            case 4:
                return 13;
            case 5:
                return 21;
            case 6:
                return 22;
            case 7:
                return 4;
            case 8:
                return 6;
            case 9:
                return 25;
            case 10:
            case 11:
                return 3;
            case 12:
                return 7;
            case 13:
                return 0;
            case 14:
                return 1;
            case 15:
                return -1;
            case 16:
                return 26;
            case 17:
                return 27;
            case 18:
                return 9;
            case 19:
                return 8;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final int getAddedInSdk() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                return 30;
            case 5:
            case 6:
            case 9:
            case 15:
            case 16:
            case 17:
                return 34;
            case 7:
            case 8:
            case 10:
            case 13:
            case 14:
                return 1;
            case 11:
            case 12:
            case 18:
            case 19:
                return 27;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
