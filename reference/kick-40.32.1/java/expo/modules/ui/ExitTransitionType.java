package expo.modules.ui;

import expo.modules.kotlin.types.Enumerable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: AnimatedVisibilityView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lexpo/modules/ui/ExitTransitionType;", "Lexpo/modules/kotlin/types/Enumerable;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "FADE_OUT", "SLIDE_OUT_HORIZONTALLY", "SLIDE_OUT_VERTICALLY", "SHRINK_OUT", "SHRINK_HORIZONTALLY", "SHRINK_VERTICALLY", "SCALE_OUT", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum ExitTransitionType implements Enumerable {
    FADE_OUT("fadeOut"),
    SLIDE_OUT_HORIZONTALLY("slideOutHorizontally"),
    SLIDE_OUT_VERTICALLY("slideOutVertically"),
    SHRINK_OUT("shrinkOut"),
    SHRINK_HORIZONTALLY("shrinkHorizontally"),
    SHRINK_VERTICALLY("shrinkVertically"),
    SCALE_OUT("scaleOut");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String value;

    public static EnumEntries<ExitTransitionType> getEntries() {
        return $ENTRIES;
    }

    ExitTransitionType(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
