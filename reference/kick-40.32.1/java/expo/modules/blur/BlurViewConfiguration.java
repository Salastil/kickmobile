package expo.modules.blur;

import com.datadog.trace.api.config.ProfilingConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: ExpoBlurView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lexpo/modules/blur/BlurViewConfiguration;", "", "<init>", "(Ljava/lang/String;I)V", "UNCONFIGURED", ProfilingConfig.PROFILING_DATADOG_PROFILER_LOG_LEVEL_DEFAULT, "DIMEZIS", "expo-blur_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
enum BlurViewConfiguration {
    UNCONFIGURED,
    NONE,
    DIMEZIS;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    public static EnumEntries<BlurViewConfiguration> getEntries() {
        return $ENTRIES;
    }
}
