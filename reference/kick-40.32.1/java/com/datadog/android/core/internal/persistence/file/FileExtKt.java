package com.datadog.android.core.internal.persistence.file;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.api.InternalLogger;
import com.facebook.hermes.intl.Constants;
import com.facebook.react.uimanager.ViewProps;
import io.ktor.http.auth.HttpAuthHeader;
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: FileExt.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\\\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0014\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a!\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000f*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\u0010\u001a)\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000f*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0007¢\u0006\u0002\u0010\u0013\u001a)\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000f*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\u0015\u001a\u0014\u0010\u0016\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u0018*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a&\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a*\u00020\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a \u0010\u001e\u001a\u0004\u0018\u00010\u001b*\u00020\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u001c\u0010\u001f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010 \u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a@\u0010!\u001a\u0002H\"\"\u0004\b\u0000\u0010\"*\u00020\u00022\u0006\u0010#\u001a\u0002H\"2\u0006\u0010\u0003\u001a\u00020\u00042\u0017\u0010$\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\"0%¢\u0006\u0002\b&H\u0002¢\u0006\u0002\u0010'\u001a&\u0010(\u001a\u00020\u0007*\u00020\u00022\u0006\u0010)\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006*"}, d2 = {"canReadSafe", "", "Ljava/io/File;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "canWriteSafe", "deleteDirectoryContentsSafe", "", "deleteSafe", "existsSafe", "isDirectorySafe", "isFileSafe", "lengthSafe", "", "listFilesSafe", "", "(Ljava/io/File;Lcom/datadog/android/api/InternalLogger;)[Ljava/io/File;", ViewProps.FILTER, "Ljava/io/FilenameFilter;", "(Ljava/io/File;Lcom/datadog/android/api/InternalLogger;Ljava/io/FilenameFilter;)[Ljava/io/File;", "Ljava/io/FileFilter;", "(Ljava/io/File;Ljava/io/FileFilter;Lcom/datadog/android/api/InternalLogger;)[Ljava/io/File;", "mkdirsSafe", "readBytesSafe", "", "readLinesSafe", "", "", HttpAuthHeader.Parameters.Charset, "Ljava/nio/charset/Charset;", "readTextSafe", "renameToSafe", "dest", "safeCall", ExifInterface.GPS_DIRECTION_TRUE, Constants.COLLATION_DEFAULT, "lambda", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Ljava/io/File;Ljava/lang/Object;Lcom/datadog/android/api/InternalLogger;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writeTextSafe", "text", "dd-sdk-android-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FileExtKt {
    private static final <T> T safeCall(final File file, T t, InternalLogger internalLogger, Function1<? super File, ? extends T> function1) {
        try {
            return function1.invoke(file);
        } catch (SecurityException e) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.persistence.file.FileExtKt.safeCall.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Security exception was thrown for file " + file.getPath();
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return t;
        } catch (Exception e2) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.persistence.file.FileExtKt.safeCall.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Unexpected exception was thrown for file " + file.getPath();
                }
            }, (Throwable) e2, false, (Map) null, 48, (Object) null);
            return t;
        }
    }

    public static final boolean canWriteSafe(File file, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        return ((Boolean) safeCall(file, false, internalLogger, new Function1<File, Boolean>() { // from class: com.datadog.android.core.internal.persistence.file.FileExtKt.canWriteSafe.1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(File safeCall) {
                Intrinsics.checkNotNullParameter(safeCall, "$this$safeCall");
                return Boolean.valueOf(safeCall.canWrite());
            }
        })).booleanValue();
    }

    public static final boolean canReadSafe(File file, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        return ((Boolean) safeCall(file, false, internalLogger, new Function1<File, Boolean>() { // from class: com.datadog.android.core.internal.persistence.file.FileExtKt.canReadSafe.1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(File safeCall) {
                Intrinsics.checkNotNullParameter(safeCall, "$this$safeCall");
                return Boolean.valueOf(safeCall.canRead());
            }
        })).booleanValue();
    }

    public static final boolean deleteSafe(File file, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        return ((Boolean) safeCall(file, false, internalLogger, new Function1<File, Boolean>() { // from class: com.datadog.android.core.internal.persistence.file.FileExtKt.deleteSafe.1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(File safeCall) {
                Intrinsics.checkNotNullParameter(safeCall, "$this$safeCall");
                return Boolean.valueOf(safeCall.delete());
            }
        })).booleanValue();
    }

    public static final boolean existsSafe(File file, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        return ((Boolean) safeCall(file, false, internalLogger, new Function1<File, Boolean>() { // from class: com.datadog.android.core.internal.persistence.file.FileExtKt.existsSafe.1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(File safeCall) {
                Intrinsics.checkNotNullParameter(safeCall, "$this$safeCall");
                return Boolean.valueOf(safeCall.exists());
            }
        })).booleanValue();
    }

    public static final boolean isFileSafe(File file, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        return ((Boolean) safeCall(file, false, internalLogger, new Function1<File, Boolean>() { // from class: com.datadog.android.core.internal.persistence.file.FileExtKt.isFileSafe.1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(File safeCall) {
                Intrinsics.checkNotNullParameter(safeCall, "$this$safeCall");
                return Boolean.valueOf(safeCall.isFile());
            }
        })).booleanValue();
    }

    public static final boolean isDirectorySafe(File file, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        return ((Boolean) safeCall(file, false, internalLogger, new Function1<File, Boolean>() { // from class: com.datadog.android.core.internal.persistence.file.FileExtKt.isDirectorySafe.1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(File safeCall) {
                Intrinsics.checkNotNullParameter(safeCall, "$this$safeCall");
                return Boolean.valueOf(safeCall.isDirectory());
            }
        })).booleanValue();
    }

    public static final File[] listFilesSafe(File file, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        return (File[]) safeCall(file, null, internalLogger, new Function1<File, File[]>() { // from class: com.datadog.android.core.internal.persistence.file.FileExtKt.listFilesSafe.1
            @Override // kotlin.jvm.functions.Function1
            public final File[] invoke(File safeCall) {
                Intrinsics.checkNotNullParameter(safeCall, "$this$safeCall");
                return safeCall.listFiles();
            }
        });
    }

    public static final File[] listFilesSafe(File file, final FileFilter filter, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(filter, "filter");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        return (File[]) safeCall(file, null, internalLogger, new Function1<File, File[]>() { // from class: com.datadog.android.core.internal.persistence.file.FileExtKt.listFilesSafe.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final File[] invoke(File safeCall) {
                Intrinsics.checkNotNullParameter(safeCall, "$this$safeCall");
                return safeCall.listFiles(filter);
            }
        });
    }

    public static final File[] listFilesSafe(File file, InternalLogger internalLogger, final FilenameFilter filter) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(filter, "filter");
        return (File[]) safeCall(file, null, internalLogger, new Function1<File, File[]>() { // from class: com.datadog.android.core.internal.persistence.file.FileExtKt.listFilesSafe.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final File[] invoke(File safeCall) {
                Intrinsics.checkNotNullParameter(safeCall, "$this$safeCall");
                return safeCall.listFiles(filter);
            }
        });
    }

    public static final long lengthSafe(File file, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        return ((Number) safeCall(file, 0L, internalLogger, new Function1<File, Long>() { // from class: com.datadog.android.core.internal.persistence.file.FileExtKt.lengthSafe.1
            @Override // kotlin.jvm.functions.Function1
            public final Long invoke(File safeCall) {
                Intrinsics.checkNotNullParameter(safeCall, "$this$safeCall");
                return Long.valueOf(safeCall.length());
            }
        })).longValue();
    }

    public static final boolean mkdirsSafe(File file, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        return ((Boolean) safeCall(file, false, internalLogger, new Function1<File, Boolean>() { // from class: com.datadog.android.core.internal.persistence.file.FileExtKt.mkdirsSafe.1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(File safeCall) {
                Intrinsics.checkNotNullParameter(safeCall, "$this$safeCall");
                return Boolean.valueOf(safeCall.mkdirs());
            }
        })).booleanValue();
    }

    public static final boolean renameToSafe(File file, final File dest, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(dest, "dest");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        return ((Boolean) safeCall(file, false, internalLogger, new Function1<File, Boolean>() { // from class: com.datadog.android.core.internal.persistence.file.FileExtKt.renameToSafe.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(File safeCall) {
                Intrinsics.checkNotNullParameter(safeCall, "$this$safeCall");
                return Boolean.valueOf(safeCall.renameTo(dest));
            }
        })).booleanValue();
    }

    public static final void deleteDirectoryContentsSafe(File file, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        File[] fileArrListFilesSafe = listFilesSafe(file, internalLogger);
        if (fileArrListFilesSafe != null) {
            for (File file2 : fileArrListFilesSafe) {
                deleteSafe(file2, internalLogger);
            }
        }
    }

    public static /* synthetic */ String readTextSafe$default(File file, Charset charset, InternalLogger internalLogger, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return readTextSafe(file, charset, internalLogger);
    }

    public static final String readTextSafe(File file, final Charset charset, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        if (existsSafe(file, internalLogger) && canReadSafe(file, internalLogger)) {
            return (String) safeCall(file, null, internalLogger, new Function1<File, String>() { // from class: com.datadog.android.core.internal.persistence.file.FileExtKt.readTextSafe.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final String invoke(File safeCall) {
                    Intrinsics.checkNotNullParameter(safeCall, "$this$safeCall");
                    return FilesKt.readText(safeCall, charset);
                }
            });
        }
        return null;
    }

    public static final byte[] readBytesSafe(File file, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        if (existsSafe(file, internalLogger) && canReadSafe(file, internalLogger)) {
            return (byte[]) safeCall(file, null, internalLogger, new Function1<File, byte[]>() { // from class: com.datadog.android.core.internal.persistence.file.FileExtKt.readBytesSafe.1
                @Override // kotlin.jvm.functions.Function1
                public final byte[] invoke(File safeCall) {
                    Intrinsics.checkNotNullParameter(safeCall, "$this$safeCall");
                    return FilesKt.readBytes(safeCall);
                }
            });
        }
        return null;
    }

    public static /* synthetic */ List readLinesSafe$default(File file, Charset charset, InternalLogger internalLogger, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return readLinesSafe(file, charset, internalLogger);
    }

    public static final List<String> readLinesSafe(File file, final Charset charset, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        if (existsSafe(file, internalLogger) && canReadSafe(file, internalLogger)) {
            return (List) safeCall(file, null, internalLogger, new Function1<File, List<? extends String>>() { // from class: com.datadog.android.core.internal.persistence.file.FileExtKt.readLinesSafe.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final List<String> invoke(File safeCall) {
                    Intrinsics.checkNotNullParameter(safeCall, "$this$safeCall");
                    return FilesKt.readLines(safeCall, charset);
                }
            });
        }
        return null;
    }

    public static /* synthetic */ void writeTextSafe$default(File file, String str, Charset charset, InternalLogger internalLogger, int i, Object obj) {
        if ((i & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        writeTextSafe(file, str, charset, internalLogger);
    }

    public static final void writeTextSafe(File file, final String text, final Charset charset, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        if (existsSafe(file, internalLogger) && canWriteSafe(file, internalLogger)) {
            safeCall(file, null, internalLogger, new Function1<File, Unit>() { // from class: com.datadog.android.core.internal.persistence.file.FileExtKt.writeTextSafe.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(File file2) {
                    invoke2(file2);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(File safeCall) {
                    Intrinsics.checkNotNullParameter(safeCall, "$this$safeCall");
                    FilesKt.writeText(safeCall, text, charset);
                }
            });
        }
    }
}
