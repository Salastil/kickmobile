package com.datadog.android.rum.internal.vitals;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.internal.persistence.file.FileExtKt;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CpuStatReader.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000f\u0010\t\u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0003J\u000f\u0010\u000f\u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/datadog/android/rum/internal/vitals/CpuStatReader;", "", "statFile", "Ljava/io/File;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "(Ljava/io/File;Lcom/datadog/android/api/InternalLogger;)V", "getStatFile$dd_sdk_android_rum_release", "()Ljava/io/File;", "readActiveTime", "", "()Ljava/lang/Double;", "readTokens", "", "", "readUserTime", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CpuStatReader {
    private static final int STIME_IDX = 14;
    private static final int UTIME_IDX = 13;
    private final InternalLogger internalLogger;
    private final File statFile;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String STAT_PATH = "/proc/self/stat";
    private static final File STAT_FILE = new File(STAT_PATH);

    public CpuStatReader(File statFile, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(statFile, "statFile");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.statFile = statFile;
        this.internalLogger = internalLogger;
    }

    public /* synthetic */ CpuStatReader(File file, InternalLogger internalLogger, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? STAT_FILE : file, internalLogger);
    }

    /* JADX INFO: renamed from: getStatFile$dd_sdk_android_rum_release, reason: from getter */
    public final File getStatFile() {
        return this.statFile;
    }

    public final Double readUserTime() {
        String str;
        List<String> tokens = readTokens();
        if (tokens == null || (str = (String) CollectionsKt.getOrNull(tokens, 13)) == null) {
            return null;
        }
        return StringsKt.toDoubleOrNull(str);
    }

    public final Double readActiveTime() {
        List<String> tokens = readTokens();
        if (tokens == null || tokens.size() <= 13) {
            return null;
        }
        if (tokens.size() <= 14) {
            return StringsKt.toDoubleOrNull(tokens.get(13));
        }
        Double doubleOrNull = StringsKt.toDoubleOrNull(tokens.get(13));
        if (doubleOrNull != null) {
            double dDoubleValue = doubleOrNull.doubleValue();
            Double doubleOrNull2 = StringsKt.toDoubleOrNull(tokens.get(14));
            if (doubleOrNull2 != null) {
                return Double.valueOf(dDoubleValue + doubleOrNull2.doubleValue());
            }
        }
        return null;
    }

    private final List<String> readTokens() {
        String textSafe$default;
        if (FileExtKt.existsSafe(this.statFile, this.internalLogger) && FileExtKt.canReadSafe(this.statFile, this.internalLogger) && (textSafe$default = FileExtKt.readTextSafe$default(this.statFile, null, this.internalLogger, 1, null)) != null) {
            return StringsKt.split$default((CharSequence) textSafe$default, new char[]{' '}, false, 0, 6, (Object) null);
        }
        return null;
    }

    /* JADX INFO: compiled from: CpuStatReader.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/datadog/android/rum/internal/vitals/CpuStatReader$Companion;", "", "()V", "STAT_FILE", "Ljava/io/File;", "getSTAT_FILE$dd_sdk_android_rum_release", "()Ljava/io/File;", "STAT_PATH", "", "STIME_IDX", "", "UTIME_IDX", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final File getSTAT_FILE$dd_sdk_android_rum_release() {
            return CpuStatReader.STAT_FILE;
        }
    }
}
