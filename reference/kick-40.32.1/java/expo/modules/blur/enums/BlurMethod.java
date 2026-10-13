package expo.modules.blur.enums;

import com.datadog.trace.api.config.ProfilingConfig;
import expo.modules.kotlin.types.Enumerable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: BlurMethod.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lexpo/modules/blur/enums/BlurMethod;", "Lexpo/modules/kotlin/types/Enumerable;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", ProfilingConfig.PROFILING_DATADOG_PROFILER_LOG_LEVEL_DEFAULT, "DIMEZIS_BLUR_VIEW", "DIMEZIS_BLUR_VIEW_SDK_31_PLUS", "expo-blur_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum BlurMethod implements Enumerable {
    NONE("none"),
    DIMEZIS_BLUR_VIEW("dimezisBlurView"),
    DIMEZIS_BLUR_VIEW_SDK_31_PLUS("dimezisBlurViewSdk31Plus");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String value;

    public static EnumEntries<BlurMethod> getEntries() {
        return $ENTRIES;
    }

    BlurMethod(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
