package expo.modules.updates.procedures;

import android.app.Activity;
import android.content.Context;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.ReactHost;
import expo.modules.updates.UpdatesConfiguration;
import expo.modules.updates.db.Reaper;
import expo.modules.updates.db.UpdatesDatabase;
import expo.modules.updates.launcher.DatabaseLauncher;
import expo.modules.updates.launcher.Launcher;
import expo.modules.updates.loader.FileDownloader;
import expo.modules.updates.logging.UpdatesErrorCode;
import expo.modules.updates.logging.UpdatesLogger;
import expo.modules.updates.reloadscreen.ReloadScreenManager;
import expo.modules.updates.selectionpolicy.SelectionPolicy;
import expo.modules.updates.statemachine.UpdatesStateEvent;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.bouncycastle.asn1.eac.EACTags;

/* JADX INFO: compiled from: RelaunchProcedure.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B¤\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b0\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\u0006\u0010 \u001a\u00020!\u0012\b\b\u0002\u0010\"\u001a\u00020#¢\u0006\u0004\b$\u0010%J\u0016\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020,H\u0096@¢\u0006\u0002\u0010-J\b\u0010.\u001a\u00020\u001bH\u0002J\u0016\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u000201H\u0082@¢\u0006\u0002\u00102R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u00020'X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)¨\u00063"}, d2 = {"Lexpo/modules/updates/procedures/RelaunchProcedure;", "Lexpo/modules/updates/procedures/StateMachineProcedure;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "weakActivity", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "updatesConfiguration", "Lexpo/modules/updates/UpdatesConfiguration;", "logger", "Lexpo/modules/updates/logging/UpdatesLogger;", "database", "Lexpo/modules/updates/db/UpdatesDatabase;", "updatesDirectory", "Ljava/io/File;", "fileDownloader", "Lexpo/modules/updates/loader/FileDownloader;", "selectionPolicy", "Lexpo/modules/updates/selectionpolicy/SelectionPolicy;", "getCurrentLauncher", "Lkotlin/Function0;", "Lexpo/modules/updates/launcher/Launcher;", "setCurrentLauncher", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "launcher", "", "shouldRunReaper", "", "reloadScreenManager", "Lexpo/modules/updates/reloadscreen/ReloadScreenManager;", "callback", "Lexpo/modules/updates/launcher/Launcher$LauncherCallback;", "procedureScope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Landroid/content/Context;Ljava/lang/ref/WeakReference;Lexpo/modules/updates/UpdatesConfiguration;Lexpo/modules/updates/logging/UpdatesLogger;Lexpo/modules/updates/db/UpdatesDatabase;Ljava/io/File;Lexpo/modules/updates/loader/FileDownloader;Lexpo/modules/updates/selectionpolicy/SelectionPolicy;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;ZLexpo/modules/updates/reloadscreen/ReloadScreenManager;Lexpo/modules/updates/launcher/Launcher$LauncherCallback;Lkotlinx/coroutines/CoroutineScope;)V", "loggerTimerLabel", "", "getLoggerTimerLabel", "()Ljava/lang/String;", "run", "procedureContext", "Lexpo/modules/updates/procedures/StateMachineProcedure$ProcedureContext;", "(Lexpo/modules/updates/procedures/StateMachineProcedure$ProcedureContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runReaper", "launchWith", "newLauncher", "Lexpo/modules/updates/launcher/DatabaseLauncher;", "(Lexpo/modules/updates/launcher/DatabaseLauncher;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RelaunchProcedure extends StateMachineProcedure {
    private final Launcher.LauncherCallback callback;
    private final Context context;
    private final UpdatesDatabase database;
    private final FileDownloader fileDownloader;
    private final Function0<Launcher> getCurrentLauncher;
    private final UpdatesLogger logger;
    private final String loggerTimerLabel;
    private final CoroutineScope procedureScope;
    private final ReloadScreenManager reloadScreenManager;
    private final SelectionPolicy selectionPolicy;
    private final Function1<Launcher, Unit> setCurrentLauncher;
    private final boolean shouldRunReaper;
    private final UpdatesConfiguration updatesConfiguration;
    private final File updatesDirectory;
    private final WeakReference<Activity> weakActivity;

    /* JADX INFO: renamed from: expo.modules.updates.procedures.RelaunchProcedure$run$1, reason: invalid class name */
    /* JADX INFO: compiled from: RelaunchProcedure.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.updates.procedures.RelaunchProcedure", f = "RelaunchProcedure.kt", i = {0, 0, 0}, l = {60}, m = "run", n = {"procedureContext", "reactHost", "newLauncher"}, nl = {61}, s = {"L$0", "L$1", "L$2"}, v = 2)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RelaunchProcedure.this.run(null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RelaunchProcedure(Context context, WeakReference<Activity> weakReference, UpdatesConfiguration updatesConfiguration, UpdatesLogger logger, UpdatesDatabase database, File updatesDirectory, FileDownloader fileDownloader, SelectionPolicy selectionPolicy, Function0<? extends Launcher> getCurrentLauncher, Function1<? super Launcher, Unit> setCurrentLauncher, boolean z, ReloadScreenManager reloadScreenManager, Launcher.LauncherCallback callback, CoroutineScope procedureScope) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(updatesConfiguration, "updatesConfiguration");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(updatesDirectory, "updatesDirectory");
        Intrinsics.checkNotNullParameter(fileDownloader, "fileDownloader");
        Intrinsics.checkNotNullParameter(selectionPolicy, "selectionPolicy");
        Intrinsics.checkNotNullParameter(getCurrentLauncher, "getCurrentLauncher");
        Intrinsics.checkNotNullParameter(setCurrentLauncher, "setCurrentLauncher");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(procedureScope, "procedureScope");
        this.context = context;
        this.weakActivity = weakReference;
        this.updatesConfiguration = updatesConfiguration;
        this.logger = logger;
        this.database = database;
        this.updatesDirectory = updatesDirectory;
        this.fileDownloader = fileDownloader;
        this.selectionPolicy = selectionPolicy;
        this.getCurrentLauncher = getCurrentLauncher;
        this.setCurrentLauncher = setCurrentLauncher;
        this.shouldRunReaper = z;
        this.reloadScreenManager = reloadScreenManager;
        this.callback = callback;
        this.procedureScope = procedureScope;
        this.loggerTimerLabel = "timer-relaunch";
    }

    public /* synthetic */ RelaunchProcedure(Context context, WeakReference weakReference, UpdatesConfiguration updatesConfiguration, UpdatesLogger updatesLogger, UpdatesDatabase updatesDatabase, File file, FileDownloader fileDownloader, SelectionPolicy selectionPolicy, Function0 function0, Function1 function1, boolean z, ReloadScreenManager reloadScreenManager, Launcher.LauncherCallback launcherCallback, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, weakReference, updatesConfiguration, updatesLogger, updatesDatabase, file, fileDownloader, selectionPolicy, function0, function1, z, reloadScreenManager, launcherCallback, (i & 8192) != 0 ? CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()) : coroutineScope);
    }

    @Override // expo.modules.updates.procedures.StateMachineProcedure
    public String getLoggerTimerLabel() {
        return this.loggerTimerLabel;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Override // expo.modules.updates.procedures.StateMachineProcedure
    public Object run(StateMachineProcedure.ProcedureContext procedureContext, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        DatabaseLauncher databaseLauncher;
        ReactHost reactHost;
        StateMachineProcedure.ProcedureContext procedureContext2 = procedureContext;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                DatabaseLauncher databaseLauncher2 = (DatabaseLauncher) anonymousClass1.L$2;
                reactHost = (ReactHost) anonymousClass1.L$1;
                StateMachineProcedure.ProcedureContext procedureContext3 = (StateMachineProcedure.ProcedureContext) anonymousClass1.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    databaseLauncher = databaseLauncher2;
                    procedureContext2 = procedureContext3;
                    this.setCurrentLauncher.invoke(databaseLauncher);
                    this.callback.onSuccess();
                    BuildersKt__Builders_commonKt.launch$default(this.procedureScope, null, null, new AnonymousClass2(reactHost, null), 3, null);
                    if (this.shouldRunReaper) {
                        runReaper();
                    }
                    procedureContext2.resetStateAfterRestart();
                    procedureContext2.onComplete();
                    return Unit.INSTANCE;
                } catch (Exception e) {
                    e = e;
                    procedureContext2 = procedureContext3;
                    this.logger.error("Error launching new launcher", e, UpdatesErrorCode.Unknown);
                    this.callback.onFailure(e);
                    procedureContext2.onComplete();
                    return Unit.INSTANCE;
                }
            }
            ResultKt.throwOnFailure(obj);
            ReactHost reactHostResolveReactHostForRestart = RestartReactAppExtensionsKt.resolveReactHostForRestart(this.context);
            if (reactHostResolveReactHostForRestart == null) {
                this.callback.onFailure(new Exception("Could not reload application. Ensure you have passed the correct instance of ReactApplication into UpdatesController.initialize()."));
                return Unit.INSTANCE;
            }
            procedureContext2.processStateEvent(new UpdatesStateEvent.Restart());
            databaseLauncher = new DatabaseLauncher(this.context, this.updatesConfiguration, this.updatesDirectory, this.fileDownloader, this.selectionPolicy, this.logger, this.procedureScope, false, 128, null);
            try {
                anonymousClass1.L$0 = procedureContext2;
                anonymousClass1.L$1 = reactHostResolveReactHostForRestart;
                anonymousClass1.L$2 = databaseLauncher;
                anonymousClass1.label = 1;
                if (launchWith(databaseLauncher, anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                reactHost = reactHostResolveReactHostForRestart;
                this.setCurrentLauncher.invoke(databaseLauncher);
                this.callback.onSuccess();
                BuildersKt__Builders_commonKt.launch$default(this.procedureScope, null, null, new AnonymousClass2(reactHost, null), 3, null);
                if (this.shouldRunReaper) {
                    runReaper();
                }
                procedureContext2.resetStateAfterRestart();
                procedureContext2.onComplete();
                return Unit.INSTANCE;
            } catch (Exception e2) {
                e = e2;
                this.logger.error("Error launching new launcher", e, UpdatesErrorCode.Unknown);
                this.callback.onFailure(e);
                procedureContext2.onComplete();
                return Unit.INSTANCE;
            }
        } catch (CancellationException e3) {
            throw e3;
        }
    }

    /* JADX INFO: renamed from: expo.modules.updates.procedures.RelaunchProcedure$run$2, reason: invalid class name */
    /* JADX INFO: compiled from: RelaunchProcedure.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.updates.procedures.RelaunchProcedure$run$2", f = "RelaunchProcedure.kt", i = {}, l = {EACTags.CERTIFICATION_AUTHORITY_PUBLIC_KEY}, m = "invokeSuspend", n = {}, nl = {78}, s = {}, v = 2)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ReactHost $reactHost;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ReactHost reactHost, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$reactHost = reactHost;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RelaunchProcedure.this.new AnonymousClass2(this.$reactHost, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: expo.modules.updates.procedures.RelaunchProcedure$run$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: RelaunchProcedure.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
        @DebugMetadata(c = "expo.modules.updates.procedures.RelaunchProcedure$run$2$1", f = "RelaunchProcedure.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ ReactHost $reactHost;
            int label;
            final /* synthetic */ RelaunchProcedure this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(RelaunchProcedure relaunchProcedure, ReactHost reactHost, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = relaunchProcedure;
                this.$reactHost = reactHost;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$reactHost, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    ReloadScreenManager reloadScreenManager = this.this$0.reloadScreenManager;
                    if (reloadScreenManager != null) {
                        WeakReference weakReference = this.this$0.weakActivity;
                        reloadScreenManager.show(weakReference != null ? (Activity) weakReference.get() : null);
                    }
                    ReactHost reactHost = this.$reactHost;
                    WeakReference weakReference2 = this.this$0.weakActivity;
                    RestartReactAppExtensionsKt.restart(reactHost, weakReference2 != null ? (Activity) weakReference2.get() : null, "Restart from RelaunchProcedure");
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(RelaunchProcedure.this, this.$reactHost, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: expo.modules.updates.procedures.RelaunchProcedure$runReaper$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RelaunchProcedure.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.updates.procedures.RelaunchProcedure$runReaper$1", f = "RelaunchProcedure.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C09411 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C09411(Continuation<? super C09411> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RelaunchProcedure.this.new C09411(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09411) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                Reaper.reapUnusedUpdates(RelaunchProcedure.this.updatesConfiguration, RelaunchProcedure.this.database, RelaunchProcedure.this.updatesDirectory, ((Launcher) RelaunchProcedure.this.getCurrentLauncher.invoke()).getLaunchedUpdate(), RelaunchProcedure.this.selectionPolicy);
            } catch (CancellationException e) {
                throw e;
            } catch (Exception e2) {
                RelaunchProcedure.this.logger.error("Could not run Reaper.", e2, UpdatesErrorCode.Unknown);
            }
            return Unit.INSTANCE;
        }
    }

    private final void runReaper() {
        BuildersKt__Builders_commonKt.launch$default(this.procedureScope, null, null, new C09411(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object launchWith(DatabaseLauncher databaseLauncher, Continuation<? super Unit> continuation) throws Exception {
        Object objLaunch = databaseLauncher.launch(this.database, continuation);
        return objLaunch == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objLaunch : Unit.INSTANCE;
    }
}
