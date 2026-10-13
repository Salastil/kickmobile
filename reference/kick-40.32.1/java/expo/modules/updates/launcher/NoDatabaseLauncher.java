package expo.modules.updates.launcher;

import android.content.Context;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.updates.db.entity.UpdateEntity;
import expo.modules.updates.loader.EmbeddedLoader;
import expo.modules.updates.logging.UpdatesLogger;
import java.io.File;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: compiled from: NoDatabaseLauncher.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB5\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0014\u0010\u001c\u001a\u00020\u001d2\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u001aX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001b¨\u0006\u001f"}, d2 = {"Lexpo/modules/updates/launcher/NoDatabaseLauncher;", "Lexpo/modules/updates/launcher/Launcher;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "logger", "Lexpo/modules/updates/logging/UpdatesLogger;", "fatalException", "Ljava/lang/Exception;", "Lkotlin/Exception;", "launcherScope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Landroid/content/Context;Lexpo/modules/updates/logging/UpdatesLogger;Ljava/lang/Exception;Lkotlinx/coroutines/CoroutineScope;)V", "bundleAssetName", "", "getBundleAssetName", "()Ljava/lang/String;", "launchedUpdate", "", "getLaunchedUpdate", "()Ljava/lang/Void;", "launchAssetFile", "getLaunchAssetFile", "localAssetFiles", "getLocalAssetFiles", "isUsingEmbeddedAssets", "", "()Z", "writeErrorToLog", "", "Companion", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class NoDatabaseLauncher implements Launcher {
    private static final String ERROR_LOG_FILENAME = "expo-error.log";
    private final String bundleAssetName;
    private final Context context;
    private final boolean isUsingEmbeddedAssets;
    private final Void launchAssetFile;
    private final Void launchedUpdate;
    private final Void localAssetFiles;
    private final UpdatesLogger logger;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "NoDatabaseLauncher";

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NoDatabaseLauncher(Context context, UpdatesLogger logger) {
        this(context, logger, null, null, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(logger, "logger");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NoDatabaseLauncher(Context context, UpdatesLogger logger, Exception exc) {
        this(context, logger, exc, null, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(logger, "logger");
    }

    public NoDatabaseLauncher(Context context, UpdatesLogger logger, Exception exc, CoroutineScope launcherScope) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(launcherScope, "launcherScope");
        this.context = context;
        this.logger = logger;
        this.bundleAssetName = EmbeddedLoader.BARE_BUNDLE_FILENAME;
        this.isUsingEmbeddedAssets = true;
        if (exc != null) {
            BuildersKt__Builders_commonKt.launch$default(launcherScope, null, null, new AnonymousClass1(exc, null), 3, null);
        }
    }

    @Override // expo.modules.updates.launcher.Launcher
    public /* bridge */ /* synthetic */ String getLaunchAssetFile() {
        return (String) getLaunchAssetFile();
    }

    @Override // expo.modules.updates.launcher.Launcher
    public /* bridge */ /* synthetic */ UpdateEntity getLaunchedUpdate() {
        return (UpdateEntity) getLaunchedUpdate();
    }

    @Override // expo.modules.updates.launcher.Launcher
    /* JADX INFO: renamed from: getLocalAssetFiles, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Map mo12144getLocalAssetFiles() {
        return (Map) getLocalAssetFiles();
    }

    public /* synthetic */ NoDatabaseLauncher(Context context, UpdatesLogger updatesLogger, Exception exc, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, updatesLogger, (i & 4) != 0 ? null : exc, (i & 8) != 0 ? CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO())) : coroutineScope);
    }

    @Override // expo.modules.updates.launcher.Launcher
    public String getBundleAssetName() {
        return this.bundleAssetName;
    }

    public Void getLaunchedUpdate() {
        return this.launchedUpdate;
    }

    public Void getLaunchAssetFile() {
        return this.launchAssetFile;
    }

    public Void getLocalAssetFiles() {
        return this.localAssetFiles;
    }

    @Override // expo.modules.updates.launcher.Launcher
    /* JADX INFO: renamed from: isUsingEmbeddedAssets, reason: from getter */
    public boolean getIsUsingEmbeddedAssets() {
        return this.isUsingEmbeddedAssets;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void writeErrorToLog(Exception fatalException) {
        try {
            FilesKt.appendText(new File(this.context.getFilesDir(), ERROR_LOG_FILENAME), fatalException.toString(), Charsets.UTF_8);
        } catch (Exception e) {
            UpdatesLogger.error$default(this.logger, "Failed to write fatal error to log", e, null, 4, null);
        }
    }

    /* JADX INFO: compiled from: NoDatabaseLauncher.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lexpo/modules/updates/launcher/NoDatabaseLauncher$Companion;", "", "<init>", "()V", "TAG", "", "kotlin.jvm.PlatformType", "ERROR_LOG_FILENAME", "consumeErrorLog", "filesDir", "Ljava/io/File;", "logger", "Lexpo/modules/updates/logging/UpdatesLogger;", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String consumeErrorLog(File filesDir, UpdatesLogger logger) {
            Intrinsics.checkNotNullParameter(filesDir, "filesDir");
            Intrinsics.checkNotNullParameter(logger, "logger");
            try {
                File file = new File(filesDir, NoDatabaseLauncher.ERROR_LOG_FILENAME);
                if (!file.exists()) {
                    return null;
                }
                String text = FilesKt.readText(file, Charsets.UTF_8);
                file.delete();
                return text;
            } catch (Exception e) {
                UpdatesLogger.error$default(logger, "Failed to read error log", e, null, 4, null);
                return null;
            }
        }
    }

    /* JADX INFO: renamed from: expo.modules.updates.launcher.NoDatabaseLauncher$1, reason: invalid class name */
    /* JADX INFO: compiled from: NoDatabaseLauncher.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.updates.launcher.NoDatabaseLauncher$1", f = "NoDatabaseLauncher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Exception $fatalException;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Exception exc, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$fatalException = exc;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NoDatabaseLauncher.this.new AnonymousClass1(this.$fatalException, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            NoDatabaseLauncher.this.writeErrorToLog(this.$fatalException);
            return Unit.INSTANCE;
        }
    }
}
