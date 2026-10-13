package com.datadog.android.rum.internal.vitals;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.internal.persistence.file.FileExtKt;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: MemoryVitalReader.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0003\b\u0000\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000f\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/datadog/android/rum/internal/vitals/MemoryVitalReader;", "Lcom/datadog/android/rum/internal/vitals/VitalReader;", "statusFile", "Ljava/io/File;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "(Ljava/io/File;Lcom/datadog/android/api/InternalLogger;)V", "getInternalLogger$dd_sdk_android_rum_release", "()Lcom/datadog/android/api/InternalLogger;", "getStatusFile$dd_sdk_android_rum_release", "()Ljava/io/File;", "readVitalData", "", "()Ljava/lang/Double;", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MemoryVitalReader implements VitalReader {
    private static final int BYTES_IN_KB = 1000;
    private final InternalLogger internalLogger;
    private final File statusFile;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String STATUS_PATH = "/proc/self/status";
    private static final File STATUS_FILE = new File(STATUS_PATH);

    public MemoryVitalReader(File statusFile, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(statusFile, "statusFile");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.statusFile = statusFile;
        this.internalLogger = internalLogger;
    }

    public /* synthetic */ MemoryVitalReader(File file, InternalLogger internalLogger, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? STATUS_FILE : file, internalLogger);
    }

    /* JADX INFO: renamed from: getStatusFile$dd_sdk_android_rum_release, reason: from getter */
    public final File getStatusFile() {
        return this.statusFile;
    }

    /* JADX INFO: renamed from: getInternalLogger$dd_sdk_android_rum_release, reason: from getter */
    public final InternalLogger getInternalLogger() {
        return this.internalLogger;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0074  */
    @Override // com.datadog.android.rum.internal.vitals.VitalReader
    public Double readVitalData() {
        Double doubleOrNull;
        Object next;
        String strRemovePrefix;
        String string;
        String strRemoveSuffix;
        String string2;
        if (!FileExtKt.existsSafe(this.statusFile, this.internalLogger) || !FileExtKt.canReadSafe(this.statusFile, this.internalLogger)) {
            return null;
        }
        List linesSafe$default = FileExtKt.readLinesSafe$default(this.statusFile, null, this.internalLogger, 1, null);
        if (linesSafe$default != null) {
            Iterator it = linesSafe$default.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!StringsKt.startsWith$default((String) next, "VmRSS:", false, 2, (Object) null));
            String str = (String) next;
            if (str == null || (strRemovePrefix = StringsKt.removePrefix(str, (CharSequence) "VmRSS:")) == null || (string = StringsKt.trim((CharSequence) strRemovePrefix).toString()) == null || (strRemoveSuffix = StringsKt.removeSuffix(string, (CharSequence) "kB")) == null || (string2 = StringsKt.trim((CharSequence) strRemoveSuffix).toString()) == null) {
                doubleOrNull = null;
            } else {
                doubleOrNull = StringsKt.toDoubleOrNull(string2);
            }
        } else {
            doubleOrNull = null;
        }
        if (doubleOrNull == null) {
            return null;
        }
        return Double.valueOf(doubleOrNull.doubleValue() * 1000.0d);
    }

    /* JADX INFO: compiled from: MemoryVitalReader.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/datadog/android/rum/internal/vitals/MemoryVitalReader$Companion;", "", "()V", "BYTES_IN_KB", "", "STATUS_FILE", "Ljava/io/File;", "getSTATUS_FILE$dd_sdk_android_rum_release", "()Ljava/io/File;", "STATUS_PATH", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final File getSTATUS_FILE$dd_sdk_android_rum_release() {
            return MemoryVitalReader.STATUS_FILE;
        }
    }
}
