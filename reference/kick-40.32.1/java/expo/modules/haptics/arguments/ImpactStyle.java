package expo.modules.haptics.arguments;

import com.datadog.reactnative.DefaultConfiguration;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: HapticsTypes.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u0011"}, d2 = {"Lexpo/modules/haptics/arguments/ImpactStyle;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "LIGHT", DefaultConfiguration.batchSize, "HEAVY", "SOFT", "RIGID", "vibration", "Lexpo/modules/haptics/arguments/VibrationType;", "getVibration", "()Lexpo/modules/haptics/arguments/VibrationType;", "expo-haptics_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum ImpactStyle {
    LIGHT("light"),
    MEDIUM("medium"),
    HEAVY("heavy"),
    SOFT("soft"),
    RIGID("rigid");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String value;

    /* JADX INFO: compiled from: HapticsTypes.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ImpactStyle.values().length];
            try {
                iArr[ImpactStyle.LIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ImpactStyle.SOFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ImpactStyle.MEDIUM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ImpactStyle.RIGID.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ImpactStyle.HEAVY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static EnumEntries<ImpactStyle> getEntries() {
        return $ENTRIES;
    }

    ImpactStyle(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    public final VibrationType getVibration() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1 || i == 2) {
            return new VibrationType(new long[]{0, 50}, new int[]{0, 30}, new long[]{0, 20});
        }
        if (i == 3 || i == 4) {
            return new VibrationType(new long[]{0, 43}, new int[]{0, 50}, new long[]{0, 43});
        }
        if (i != 5) {
            throw new NoWhenBranchMatchedException();
        }
        return new VibrationType(new long[]{0, 60}, new int[]{0, 70}, new long[]{0, 61});
    }
}
