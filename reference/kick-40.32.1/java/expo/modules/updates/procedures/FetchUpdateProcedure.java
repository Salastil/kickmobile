package expo.modules.updates.procedures;

import android.content.Context;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.interfaces.permissions.PermissionsResponse;
import expo.modules.updates.IUpdatesController;
import expo.modules.updates.UpdatesConfiguration;
import expo.modules.updates.db.UpdatesDatabase;
import expo.modules.updates.db.entity.UpdateEntity;
import expo.modules.updates.loader.FileDownloader;
import expo.modules.updates.loader.Loader;
import expo.modules.updates.loader.ProcessSuccessLoaderResult;
import expo.modules.updates.loader.RemoteLoader;
import expo.modules.updates.loader.UpdateDirective;
import expo.modules.updates.loader.UpdateResponse;
import expo.modules.updates.loader.UpdateResponsePart;
import expo.modules.updates.logging.UpdatesLogger;
import expo.modules.updates.manifest.ResponseHeaderData;
import expo.modules.updates.manifest.Update;
import expo.modules.updates.selectionpolicy.SelectionPolicy;
import expo.modules.updates.statemachine.UpdatesStateEvent;
import java.io.File;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: FetchUpdateProcedure.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015¢\u0006\u0004\b\u0018\u0010\u0019J\u0016\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 H\u0096@¢\u0006\u0002\u0010!J\u001e\u0010\"\u001a\u00020#2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 H\u0082@¢\u0006\u0002\u0010$J\u001e\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020 H\u0082@¢\u0006\u0002\u0010'R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u00020\u001bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006("}, d2 = {"Lexpo/modules/updates/procedures/FetchUpdateProcedure;", "Lexpo/modules/updates/procedures/StateMachineProcedure;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "updatesConfiguration", "Lexpo/modules/updates/UpdatesConfiguration;", "logger", "Lexpo/modules/updates/logging/UpdatesLogger;", "database", "Lexpo/modules/updates/db/UpdatesDatabase;", "updatesDirectory", "Ljava/io/File;", "fileDownloader", "Lexpo/modules/updates/loader/FileDownloader;", "selectionPolicy", "Lexpo/modules/updates/selectionpolicy/SelectionPolicy;", "launchedUpdate", "Lexpo/modules/updates/db/entity/UpdateEntity;", PermissionsResponse.SCOPE_KEY, "Lkotlinx/coroutines/CoroutineScope;", "callback", "Lkotlin/Function1;", "Lexpo/modules/updates/IUpdatesController$FetchUpdateResult;", "", "<init>", "(Landroid/content/Context;Lexpo/modules/updates/UpdatesConfiguration;Lexpo/modules/updates/logging/UpdatesLogger;Lexpo/modules/updates/db/UpdatesDatabase;Ljava/io/File;Lexpo/modules/updates/loader/FileDownloader;Lexpo/modules/updates/selectionpolicy/SelectionPolicy;Lexpo/modules/updates/db/entity/UpdateEntity;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function1;)V", "loggerTimerLabel", "", "getLoggerTimerLabel", "()Ljava/lang/String;", "run", "procedureContext", "Lexpo/modules/updates/procedures/StateMachineProcedure$ProcedureContext;", "(Lexpo/modules/updates/procedures/StateMachineProcedure$ProcedureContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startRemoteLoader", "Lexpo/modules/updates/loader/Loader$LoaderResult;", "(Lexpo/modules/updates/db/UpdatesDatabase;Lexpo/modules/updates/procedures/StateMachineProcedure$ProcedureContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processSuccessLoaderResult", "loaderResult", "(Lexpo/modules/updates/loader/Loader$LoaderResult;Lexpo/modules/updates/procedures/StateMachineProcedure$ProcedureContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class FetchUpdateProcedure extends StateMachineProcedure {
    private final Function1<IUpdatesController.FetchUpdateResult, Unit> callback;
    private final Context context;
    private final UpdatesDatabase database;
    private final FileDownloader fileDownloader;
    private final UpdateEntity launchedUpdate;
    private final UpdatesLogger logger;
    private final String loggerTimerLabel;
    private final CoroutineScope scope;
    private final SelectionPolicy selectionPolicy;
    private final UpdatesConfiguration updatesConfiguration;
    private final File updatesDirectory;

    /* JADX INFO: renamed from: expo.modules.updates.procedures.FetchUpdateProcedure$processSuccessLoaderResult$1, reason: invalid class name */
    /* JADX INFO: compiled from: FetchUpdateProcedure.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.updates.procedures.FetchUpdateProcedure", f = "FetchUpdateProcedure.kt", i = {0, 0}, l = {101}, m = "processSuccessLoaderResult", n = {"loaderResult", "procedureContext"}, nl = {111}, s = {"L$0", "L$1"}, v = 2)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FetchUpdateProcedure.this.processSuccessLoaderResult(null, null, this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.updates.procedures.FetchUpdateProcedure$run$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FetchUpdateProcedure.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.updates.procedures.FetchUpdateProcedure", f = "FetchUpdateProcedure.kt", i = {0, 1, 1}, l = {38, 39}, m = "run", n = {"procedureContext", "procedureContext", "loaderResult"}, nl = {39, 49}, s = {"L$0", "L$0", "L$1"}, v = 2)
    static final class C09391 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C09391(Continuation<? super C09391> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FetchUpdateProcedure.this.run(null, this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.updates.procedures.FetchUpdateProcedure$startRemoteLoader$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FetchUpdateProcedure.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.updates.procedures.FetchUpdateProcedure", f = "FetchUpdateProcedure.kt", i = {0, 0, 0}, l = {70}, m = "startRemoteLoader", n = {"database", "procedureContext", "remoteLoader"}, nl = {93}, s = {"L$0", "L$1", "L$2"}, v = 2)
    static final class C09401 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C09401(Continuation<? super C09401> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FetchUpdateProcedure.this.startRemoteLoader(null, null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FetchUpdateProcedure(Context context, UpdatesConfiguration updatesConfiguration, UpdatesLogger logger, UpdatesDatabase database, File updatesDirectory, FileDownloader fileDownloader, SelectionPolicy selectionPolicy, UpdateEntity updateEntity, CoroutineScope scope, Function1<? super IUpdatesController.FetchUpdateResult, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(updatesConfiguration, "updatesConfiguration");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(updatesDirectory, "updatesDirectory");
        Intrinsics.checkNotNullParameter(fileDownloader, "fileDownloader");
        Intrinsics.checkNotNullParameter(selectionPolicy, "selectionPolicy");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.context = context;
        this.updatesConfiguration = updatesConfiguration;
        this.logger = logger;
        this.database = database;
        this.updatesDirectory = updatesDirectory;
        this.fileDownloader = fileDownloader;
        this.selectionPolicy = selectionPolicy;
        this.launchedUpdate = updateEntity;
        this.scope = scope;
        this.callback = callback;
        this.loggerTimerLabel = "timer-fetch-update";
    }

    @Override // expo.modules.updates.procedures.StateMachineProcedure
    public String getLoggerTimerLabel() {
        return this.loggerTimerLabel;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0071, code lost:
    
        if (processSuccessLoaderResult(r10, r9, r0) == r2) goto L26;
     */
    @Override // expo.modules.updates.procedures.StateMachineProcedure
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object run(expo.modules.updates.procedures.StateMachineProcedure.ProcedureContext r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            java.lang.String r1 = "Failed to download new update: "
            boolean r0 = r10 instanceof expo.modules.updates.procedures.FetchUpdateProcedure.C09391
            if (r0 == 0) goto L16
            r0 = r10
            expo.modules.updates.procedures.FetchUpdateProcedure$run$1 r0 = (expo.modules.updates.procedures.FetchUpdateProcedure.C09391) r0
            int r2 = r0.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L16
            int r10 = r0.label
            int r10 = r10 - r3
            r0.label = r10
            goto L1b
        L16:
            expo.modules.updates.procedures.FetchUpdateProcedure$run$1 r0 = new expo.modules.updates.procedures.FetchUpdateProcedure$run$1
            r0.<init>(r10)
        L1b:
            java.lang.Object r10 = r0.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r0.label
            r4 = 2
            r5 = 1
            if (r3 == 0) goto L47
            if (r3 == r5) goto L3f
            if (r3 != r4) goto L37
            java.lang.Object r9 = r0.L$1
            expo.modules.updates.loader.Loader$LoaderResult r9 = (expo.modules.updates.loader.Loader.LoaderResult) r9
            java.lang.Object r9 = r0.L$0
            expo.modules.updates.procedures.StateMachineProcedure$ProcedureContext r9 = (expo.modules.updates.procedures.StateMachineProcedure.ProcedureContext) r9
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7b java.util.concurrent.CancellationException -> Lb3
            goto L74
        L37:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3f:
            java.lang.Object r9 = r0.L$0
            expo.modules.updates.procedures.StateMachineProcedure$ProcedureContext r9 = (expo.modules.updates.procedures.StateMachineProcedure.ProcedureContext) r9
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7b java.util.concurrent.CancellationException -> Lb3
            goto L61
        L47:
            kotlin.ResultKt.throwOnFailure(r10)
            expo.modules.updates.statemachine.UpdatesStateEvent$Download r10 = new expo.modules.updates.statemachine.UpdatesStateEvent$Download
            r10.<init>()
            expo.modules.updates.statemachine.UpdatesStateEvent r10 = (expo.modules.updates.statemachine.UpdatesStateEvent) r10
            r9.processStateEvent(r10)
            expo.modules.updates.db.UpdatesDatabase r10 = r8.database     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7b java.util.concurrent.CancellationException -> Lb3
            r0.L$0 = r9     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7b java.util.concurrent.CancellationException -> Lb3
            r0.label = r5     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7b java.util.concurrent.CancellationException -> Lb3
            java.lang.Object r10 = r8.startRemoteLoader(r10, r9, r0)     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7b java.util.concurrent.CancellationException -> Lb3
            if (r10 != r2) goto L61
            goto L73
        L61:
            expo.modules.updates.loader.Loader$LoaderResult r10 = (expo.modules.updates.loader.Loader.LoaderResult) r10     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7b java.util.concurrent.CancellationException -> Lb3
            r0.L$0 = r9     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7b java.util.concurrent.CancellationException -> Lb3
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7b java.util.concurrent.CancellationException -> Lb3
            r0.L$1 = r3     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7b java.util.concurrent.CancellationException -> Lb3
            r0.label = r4     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7b java.util.concurrent.CancellationException -> Lb3
            java.lang.Object r8 = r8.processSuccessLoaderResult(r10, r9, r0)     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7b java.util.concurrent.CancellationException -> Lb3
            if (r8 != r2) goto L74
        L73:
            return r2
        L74:
            r9.onComplete()
            goto Lb0
        L78:
            r0 = move-exception
            r8 = r0
            goto Lb6
        L7b:
            r0 = move-exception
            r10 = r0
            r4 = r10
            expo.modules.updates.logging.UpdatesLogger r2 = r8.logger     // Catch: java.lang.Throwable -> L78
            java.lang.String r3 = "Failed to download new update"
            r6 = 4
            r7 = 0
            r5 = 0
            expo.modules.updates.logging.UpdatesLogger.error$default(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L78
            expo.modules.updates.statemachine.UpdatesStateEvent$DownloadError r10 = new expo.modules.updates.statemachine.UpdatesStateEvent$DownloadError     // Catch: java.lang.Throwable -> L78
            r0 = r4
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch: java.lang.Throwable -> L78
            java.lang.String r0 = expo.modules.core.logging.LoggerUtilsKt.localizedMessageWithCauseLocalizedMessage(r0)     // Catch: java.lang.Throwable -> L78
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L78
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L78
            r2.append(r0)     // Catch: java.lang.Throwable -> L78
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L78
            r10.<init>(r0)     // Catch: java.lang.Throwable -> L78
            expo.modules.updates.statemachine.UpdatesStateEvent r10 = (expo.modules.updates.statemachine.UpdatesStateEvent) r10     // Catch: java.lang.Throwable -> L78
            r9.processStateEvent(r10)     // Catch: java.lang.Throwable -> L78
            kotlin.jvm.functions.Function1<expo.modules.updates.IUpdatesController$FetchUpdateResult, kotlin.Unit> r8 = r8.callback     // Catch: java.lang.Throwable -> L78
            expo.modules.updates.IUpdatesController$FetchUpdateResult$ErrorResult r10 = new expo.modules.updates.IUpdatesController$FetchUpdateResult$ErrorResult     // Catch: java.lang.Throwable -> L78
            r10.<init>(r4)     // Catch: java.lang.Throwable -> L78
            r8.invoke(r10)     // Catch: java.lang.Throwable -> L78
            goto L74
        Lb0:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        Lb3:
            r0 = move-exception
            r8 = r0
            throw r8     // Catch: java.lang.Throwable -> L78
        Lb6:
            r9.onComplete()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.updates.procedures.FetchUpdateProcedure.run(expo.modules.updates.procedures.StateMachineProcedure$ProcedureContext, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public final Object startRemoteLoader(UpdatesDatabase updatesDatabase, final StateMachineProcedure.ProcedureContext procedureContext, Continuation<? super Loader.LoaderResult> continuation) {
        C09401 c09401;
        if (continuation instanceof C09401) {
            c09401 = (C09401) continuation;
            if ((c09401.label & Integer.MIN_VALUE) != 0) {
                c09401.label -= Integer.MIN_VALUE;
            } else {
                c09401 = new C09401(continuation);
            }
        } else {
            c09401 = new C09401(continuation);
        }
        Object objLoad = c09401.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09401.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objLoad);
                RemoteLoader remoteLoader = new RemoteLoader(this.context, this.updatesConfiguration, this.logger, updatesDatabase, this.fileDownloader, this.updatesDirectory, this.launchedUpdate, this.scope);
                remoteLoader.setAssetLoadProgressBlock$expo_updates_release(new Function1() { // from class: expo.modules.updates.procedures.FetchUpdateProcedure$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FetchUpdateProcedure.startRemoteLoader$lambda$0(procedureContext, ((Double) obj).doubleValue());
                    }
                });
                Function1<? super UpdateResponse, Loader.OnUpdateResponseLoadedResult> function1 = new Function1() { // from class: expo.modules.updates.procedures.FetchUpdateProcedure$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FetchUpdateProcedure.startRemoteLoader$lambda$1(this.f$0, (UpdateResponse) obj);
                    }
                };
                c09401.L$0 = SpillingKt.nullOutSpilledVariable(updatesDatabase);
                c09401.L$1 = SpillingKt.nullOutSpilledVariable(procedureContext);
                c09401.L$2 = SpillingKt.nullOutSpilledVariable(remoteLoader);
                c09401.label = 1;
                objLoad = remoteLoader.load(function1, c09401);
                if (objLoad == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objLoad);
            }
            return (Loader.LoaderResult) objLoad;
        } catch (CancellationException e) {
            UpdatesLogger.info$default(this.logger, "Remote loader cancelled during fetch update procedure", null, 2, null);
            throw e;
        }
    }

    static final Unit startRemoteLoader$lambda$0(StateMachineProcedure.ProcedureContext procedureContext, double d) {
        procedureContext.processStateEvent(new UpdatesStateEvent.DownloadProgress(d));
        return Unit.INSTANCE;
    }

    static final Loader.OnUpdateResponseLoadedResult startRemoteLoader$lambda$1(FetchUpdateProcedure fetchUpdateProcedure, UpdateResponse updateResponse) {
        Update update;
        Intrinsics.checkNotNullParameter(updateResponse, "updateResponse");
        UpdateResponsePart.DirectiveUpdateResponsePart directiveUpdateResponsePart = updateResponse.getDirectiveUpdateResponsePart();
        UpdateDirective updateDirective = directiveUpdateResponsePart != null ? directiveUpdateResponsePart.getUpdateDirective() : null;
        if (updateDirective != null) {
            if ((updateDirective instanceof UpdateDirective.RollBackToEmbeddedUpdateDirective) || (updateDirective instanceof UpdateDirective.NoUpdateAvailableUpdateDirective)) {
                return new Loader.OnUpdateResponseLoadedResult(false);
            }
            throw new NoWhenBranchMatchedException();
        }
        UpdateResponsePart.ManifestUpdateResponsePart manifestUpdateResponsePart = updateResponse.getManifestUpdateResponsePart();
        if (manifestUpdateResponsePart == null || (update = manifestUpdateResponsePart.getUpdate()) == null) {
            return new Loader.OnUpdateResponseLoadedResult(false);
        }
        SelectionPolicy selectionPolicy = fetchUpdateProcedure.selectionPolicy;
        UpdateEntity updateEntity = update.getUpdateEntity();
        UpdateEntity updateEntity2 = fetchUpdateProcedure.launchedUpdate;
        ResponseHeaderData responseHeaderData = updateResponse.getResponseHeaderData();
        return new Loader.OnUpdateResponseLoadedResult(selectionPolicy.shouldLoadNewUpdate(updateEntity, updateEntity2, responseHeaderData != null ? responseHeaderData.getManifestFilters() : null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object processSuccessLoaderResult(Loader.LoaderResult loaderResult, StateMachineProcedure.ProcedureContext procedureContext, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
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
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object objProcessSuccessLoaderResult = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass2.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objProcessSuccessLoaderResult);
            RemoteLoader.Companion companion = RemoteLoader.INSTANCE;
            Context context = this.context;
            UpdatesConfiguration updatesConfiguration = this.updatesConfiguration;
            UpdatesLogger updatesLogger = this.logger;
            UpdatesDatabase updatesDatabase = this.database;
            SelectionPolicy selectionPolicy = this.selectionPolicy;
            File file = this.updatesDirectory;
            UpdateEntity updateEntity = this.launchedUpdate;
            anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(loaderResult);
            anonymousClass2.L$1 = procedureContext;
            anonymousClass2.label = 1;
            objProcessSuccessLoaderResult = companion.processSuccessLoaderResult(context, updatesConfiguration, updatesLogger, updatesDatabase, selectionPolicy, file, updateEntity, loaderResult, anonymousClass2);
            if (objProcessSuccessLoaderResult == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            procedureContext = (StateMachineProcedure.ProcedureContext) anonymousClass2.L$1;
            ResultKt.throwOnFailure(objProcessSuccessLoaderResult);
        }
        ProcessSuccessLoaderResult processSuccessLoaderResult = (ProcessSuccessLoaderResult) objProcessSuccessLoaderResult;
        UpdateEntity availableUpdate = processSuccessLoaderResult.getAvailableUpdate();
        if (processSuccessLoaderResult.getDidRollBackToEmbedded()) {
            procedureContext.processStateEvent(new UpdatesStateEvent.DownloadCompleteWithRollback());
            this.callback.invoke(new IUpdatesController.FetchUpdateResult.RollBackToEmbedded());
        } else if (availableUpdate == null) {
            procedureContext.processStateEvent(new UpdatesStateEvent.DownloadCompleteUnavailable());
            this.callback.invoke(new IUpdatesController.FetchUpdateResult.Failure());
        } else {
            procedureContext.processStateEvent(new UpdatesStateEvent.DownloadCompleteWithUpdate(availableUpdate.getManifest()));
            this.callback.invoke(new IUpdatesController.FetchUpdateResult.Success(availableUpdate));
        }
        return Unit.INSTANCE;
    }
}
