package expo.modules.filesystem;

import kotlin.Metadata;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: compiled from: FileSystemWatcher.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"DEFAULT_DEBOUNCE", "Lkotlin/time/Duration;", "J", "IN_ISDIR", "", "WATCH_MASK", "expo-file-system_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class FileSystemWatcherKt {
    private static final long DEFAULT_DEBOUNCE;
    private static final int IN_ISDIR = 1073741824;
    private static final int WATCH_MASK = 4034;

    static {
        Duration.Companion companion = Duration.INSTANCE;
        DEFAULT_DEBOUNCE = DurationKt.toDuration(100, DurationUnit.MILLISECONDS);
    }
}
