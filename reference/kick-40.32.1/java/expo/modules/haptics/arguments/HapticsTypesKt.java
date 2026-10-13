package expo.modules.haptics.arguments;

import kotlin.Metadata;

/* JADX INFO: compiled from: HapticsTypes.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"SelectionType", "Lexpo/modules/haptics/arguments/VibrationType;", "getSelectionType", "()Lexpo/modules/haptics/arguments/VibrationType;", "expo-haptics_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class HapticsTypesKt {
    private static final VibrationType SelectionType = new VibrationType(new long[]{0, 50}, new int[]{0, 30}, new long[]{0, 70});

    public static final VibrationType getSelectionType() {
        return SelectionType;
    }
}
