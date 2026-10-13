package expo.modules.updates.procedures;

import android.content.Context;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.core.logging.LoggerUtilsKt;
import expo.modules.updates.IUpdatesController;
import expo.modules.updates.UpdatesConfiguration;
import expo.modules.updates.db.UpdatesDatabase;
import expo.modules.updates.db.entity.UpdateEntity;
import expo.modules.updates.loader.FileDownloader;
import expo.modules.updates.loader.LoaderTask;
import expo.modules.updates.loader.UpdateDirective;
import expo.modules.updates.loader.UpdateResponse;
import expo.modules.updates.loader.UpdateResponsePart;
import expo.modules.updates.logging.UpdatesLogger;
import expo.modules.updates.manifest.EmbeddedManifestUtils;
import expo.modules.updates.manifest.EmbeddedUpdate;
import expo.modules.updates.manifest.ResponseHeaderData;
import expo.modules.updates.manifest.Update;
import expo.modules.updates.selectionpolicy.SelectionPolicy;
import expo.modules.updates.statemachine.UpdatesStateEvent;
import java.io.IOException;
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
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: CheckForUpdateProcedure.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\u0016\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001cH\u0096@¢\u0006\u0002\u0010\u001dJ\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0082@¢\u0006\u0002\u0010\"J\"\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010%\u001a\u0004\u0018\u00010\u000fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u0017X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006&"}, d2 = {"Lexpo/modules/updates/procedures/CheckForUpdateProcedure;", "Lexpo/modules/updates/procedures/StateMachineProcedure;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "updatesConfiguration", "Lexpo/modules/updates/UpdatesConfiguration;", "database", "Lexpo/modules/updates/db/UpdatesDatabase;", "updatesLogger", "Lexpo/modules/updates/logging/UpdatesLogger;", "fileDownloader", "Lexpo/modules/updates/loader/FileDownloader;", "selectionPolicy", "Lexpo/modules/updates/selectionpolicy/SelectionPolicy;", "launchedUpdate", "Lexpo/modules/updates/db/entity/UpdateEntity;", "callback", "Lkotlin/Function1;", "Lexpo/modules/updates/IUpdatesController$CheckForUpdateResult;", "", "<init>", "(Landroid/content/Context;Lexpo/modules/updates/UpdatesConfiguration;Lexpo/modules/updates/db/UpdatesDatabase;Lexpo/modules/updates/logging/UpdatesLogger;Lexpo/modules/updates/loader/FileDownloader;Lexpo/modules/updates/selectionpolicy/SelectionPolicy;Lexpo/modules/updates/db/entity/UpdateEntity;Lkotlin/jvm/functions/Function1;)V", "loggerTimerLabel", "", "getLoggerTimerLabel", "()Ljava/lang/String;", "run", "procedureContext", "Lexpo/modules/updates/procedures/StateMachineProcedure$ProcedureContext;", "(Lexpo/modules/updates/procedures/StateMachineProcedure$ProcedureContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadRemoteUpdate", "Lexpo/modules/updates/loader/UpdateResponse;", "extraHeaders", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processUpdatesResponse", "updateResponse", "embeddedUpdate", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CheckForUpdateProcedure extends StateMachineProcedure {
    private final Function1<IUpdatesController.CheckForUpdateResult, Unit> callback;
    private final Context context;
    private final UpdatesDatabase database;
    private final FileDownloader fileDownloader;
    private final UpdateEntity launchedUpdate;
    private final String loggerTimerLabel;
    private final SelectionPolicy selectionPolicy;
    private final UpdatesConfiguration updatesConfiguration;
    private final UpdatesLogger updatesLogger;

    /* JADX INFO: renamed from: expo.modules.updates.procedures.CheckForUpdateProcedure$downloadRemoteUpdate$1, reason: invalid class name */
    /* JADX INFO: compiled from: CheckForUpdateProcedure.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.updates.procedures.CheckForUpdateProcedure", f = "CheckForUpdateProcedure.kt", i = {0}, l = {57}, m = "downloadRemoteUpdate", n = {"extraHeaders"}, nl = {58}, s = {"L$0"}, v = 2)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CheckForUpdateProcedure.this.downloadRemoteUpdate(null, this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.updates.procedures.CheckForUpdateProcedure$run$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CheckForUpdateProcedure.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.updates.procedures.CheckForUpdateProcedure", f = "CheckForUpdateProcedure.kt", i = {0, 0, 0}, l = {44}, m = "run", n = {"procedureContext", "embeddedUpdate", "extraHeaders"}, nl = {45}, s = {"L$0", "L$1", "L$2"}, v = 2)
    static final class C09381 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C09381(Continuation<? super C09381> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CheckForUpdateProcedure.this.run(null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CheckForUpdateProcedure(Context context, UpdatesConfiguration updatesConfiguration, UpdatesDatabase database, UpdatesLogger updatesLogger, FileDownloader fileDownloader, SelectionPolicy selectionPolicy, UpdateEntity updateEntity, Function1<? super IUpdatesController.CheckForUpdateResult, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(updatesConfiguration, "updatesConfiguration");
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(updatesLogger, "updatesLogger");
        Intrinsics.checkNotNullParameter(fileDownloader, "fileDownloader");
        Intrinsics.checkNotNullParameter(selectionPolicy, "selectionPolicy");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.context = context;
        this.updatesConfiguration = updatesConfiguration;
        this.database = database;
        this.updatesLogger = updatesLogger;
        this.fileDownloader = fileDownloader;
        this.selectionPolicy = selectionPolicy;
        this.launchedUpdate = updateEntity;
        this.callback = callback;
        this.loggerTimerLabel = "timer-check-for-update";
    }

    @Override // expo.modules.updates.procedures.StateMachineProcedure
    public String getLoggerTimerLabel() {
        return this.loggerTimerLabel;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // expo.modules.updates.procedures.StateMachineProcedure
    public Object run(StateMachineProcedure.ProcedureContext procedureContext, Continuation<? super Unit> continuation) throws JSONException {
        C09381 c09381;
        UpdateEntity updateEntity;
        Object objDownloadRemoteUpdate;
        Exception e;
        StateMachineProcedure.ProcedureContext procedureContext2;
        if (continuation instanceof C09381) {
            c09381 = (C09381) continuation;
            if ((c09381.label & Integer.MIN_VALUE) != 0) {
                c09381.label -= Integer.MIN_VALUE;
            } else {
                c09381 = new C09381(continuation);
            }
        } else {
            c09381 = new C09381(continuation);
        }
        Object obj = c09381.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09381.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                procedureContext.processStateEvent(new UpdatesStateEvent.Check());
                EmbeddedUpdate embeddedUpdate = EmbeddedManifestUtils.INSTANCE.getEmbeddedUpdate(this.context, this.updatesConfiguration);
                updateEntity = embeddedUpdate != null ? embeddedUpdate.getUpdateEntity() : null;
                JSONObject extraHeadersForRemoteUpdateRequest = FileDownloader.INSTANCE.getExtraHeadersForRemoteUpdateRequest(this.database, this.updatesConfiguration, this.launchedUpdate, updateEntity);
                try {
                    c09381.L$0 = procedureContext;
                    c09381.L$1 = updateEntity;
                    c09381.L$2 = SpillingKt.nullOutSpilledVariable(extraHeadersForRemoteUpdateRequest);
                    c09381.label = 1;
                    objDownloadRemoteUpdate = downloadRemoteUpdate(extraHeadersForRemoteUpdateRequest, c09381);
                    if (objDownloadRemoteUpdate == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } catch (Exception e2) {
                    procedureContext2 = procedureContext;
                    e = e2;
                    procedureContext2.processStateEvent(new UpdatesStateEvent.CheckError(LoggerUtilsKt.localizedMessageWithCauseLocalizedMessage(e)));
                    this.callback.invoke(new IUpdatesController.CheckForUpdateResult.ErrorResult(e));
                    procedureContext2.onComplete();
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                UpdateEntity updateEntity2 = (UpdateEntity) c09381.L$1;
                procedureContext2 = (StateMachineProcedure.ProcedureContext) c09381.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    updateEntity = updateEntity2;
                    procedureContext = procedureContext2;
                    objDownloadRemoteUpdate = obj;
                } catch (Exception e3) {
                    e = e3;
                    procedureContext2.processStateEvent(new UpdatesStateEvent.CheckError(LoggerUtilsKt.localizedMessageWithCauseLocalizedMessage(e)));
                    this.callback.invoke(new IUpdatesController.CheckForUpdateResult.ErrorResult(e));
                    procedureContext2.onComplete();
                }
            }
            processUpdatesResponse((UpdateResponse) objDownloadRemoteUpdate, procedureContext, updateEntity);
            return Unit.INSTANCE;
        } catch (CancellationException e4) {
            throw e4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object downloadRemoteUpdate(JSONObject jSONObject, Continuation<? super UpdateResponse> continuation) throws IOException {
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
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            FileDownloader fileDownloader = this.fileDownloader;
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(jSONObject);
            anonymousClass1.label = 1;
            Object objDownloadRemoteUpdate = fileDownloader.downloadRemoteUpdate(jSONObject, anonymousClass1);
            return objDownloadRemoteUpdate == coroutine_suspended ? coroutine_suspended : objDownloadRemoteUpdate;
        } catch (CancellationException e) {
            UpdatesLogger.info$default(this.updatesLogger, "Download cancelled for remote update check", null, 2, null);
            throw e;
        }
    }

    private final void processUpdatesResponse(UpdateResponse updateResponse, StateMachineProcedure.ProcedureContext procedureContext, UpdateEntity embeddedUpdate) {
        boolean z;
        LoaderTask.RemoteCheckResultNotAvailableReason remoteCheckResultNotAvailableReason;
        UpdateEntity updateEntityLoadUpdateWithId;
        UpdateResponsePart.DirectiveUpdateResponsePart directiveUpdateResponsePart = updateResponse.getDirectiveUpdateResponsePart();
        UpdateDirective updateDirective = directiveUpdateResponsePart != null ? directiveUpdateResponsePart.getUpdateDirective() : null;
        UpdateResponsePart.ManifestUpdateResponsePart manifestUpdateResponsePart = updateResponse.getManifestUpdateResponsePart();
        Update update = manifestUpdateResponsePart != null ? manifestUpdateResponsePart.getUpdate() : null;
        if (updateDirective != null) {
            if (updateDirective instanceof UpdateDirective.NoUpdateAvailableUpdateDirective) {
                procedureContext.processStateEvent(new UpdatesStateEvent.CheckCompleteUnavailable());
                this.callback.invoke(new IUpdatesController.CheckForUpdateResult.NoUpdateAvailable(LoaderTask.RemoteCheckResultNotAvailableReason.NO_UPDATE_AVAILABLE_ON_SERVER));
                procedureContext.onComplete();
                return;
            }
            if (!(updateDirective instanceof UpdateDirective.RollBackToEmbeddedUpdateDirective)) {
                throw new NoWhenBranchMatchedException();
            }
            if (!this.updatesConfiguration.getHasEmbeddedUpdate()) {
                procedureContext.processStateEvent(new UpdatesStateEvent.CheckCompleteUnavailable());
                this.callback.invoke(new IUpdatesController.CheckForUpdateResult.NoUpdateAvailable(LoaderTask.RemoteCheckResultNotAvailableReason.ROLLBACK_NO_EMBEDDED));
                procedureContext.onComplete();
                return;
            }
            if (embeddedUpdate == null) {
                procedureContext.processStateEvent(new UpdatesStateEvent.CheckCompleteUnavailable());
                this.callback.invoke(new IUpdatesController.CheckForUpdateResult.NoUpdateAvailable(LoaderTask.RemoteCheckResultNotAvailableReason.ROLLBACK_NO_EMBEDDED));
                procedureContext.onComplete();
                return;
            }
            SelectionPolicy selectionPolicy = this.selectionPolicy;
            UpdateDirective.RollBackToEmbeddedUpdateDirective rollBackToEmbeddedUpdateDirective = (UpdateDirective.RollBackToEmbeddedUpdateDirective) updateDirective;
            UpdateEntity updateEntity = this.launchedUpdate;
            ResponseHeaderData responseHeaderData = updateResponse.getResponseHeaderData();
            if (!selectionPolicy.shouldLoadRollBackToEmbeddedDirective(rollBackToEmbeddedUpdateDirective, embeddedUpdate, updateEntity, responseHeaderData != null ? responseHeaderData.getManifestFilters() : null)) {
                procedureContext.processStateEvent(new UpdatesStateEvent.CheckCompleteUnavailable());
                this.callback.invoke(new IUpdatesController.CheckForUpdateResult.NoUpdateAvailable(LoaderTask.RemoteCheckResultNotAvailableReason.ROLLBACK_REJECTED_BY_SELECTION_POLICY));
                procedureContext.onComplete();
                return;
            } else {
                procedureContext.processStateEvent(new UpdatesStateEvent.CheckCompleteWithRollback(rollBackToEmbeddedUpdateDirective.getCommitTime()));
                this.callback.invoke(new IUpdatesController.CheckForUpdateResult.RollBackToEmbedded(rollBackToEmbeddedUpdateDirective.getCommitTime()));
                procedureContext.onComplete();
                return;
            }
        }
        if (update == null) {
            procedureContext.processStateEvent(new UpdatesStateEvent.CheckCompleteUnavailable());
            this.callback.invoke(new IUpdatesController.CheckForUpdateResult.NoUpdateAvailable(LoaderTask.RemoteCheckResultNotAvailableReason.NO_UPDATE_AVAILABLE_ON_SERVER));
            procedureContext.onComplete();
            return;
        }
        if (this.launchedUpdate == null) {
            procedureContext.processStateEvent(new UpdatesStateEvent.CheckCompleteWithUpdate(update.getManifest().getRawJson()));
            this.callback.invoke(new IUpdatesController.CheckForUpdateResult.UpdateAvailable(update));
            procedureContext.onComplete();
            return;
        }
        SelectionPolicy selectionPolicy2 = this.selectionPolicy;
        UpdateEntity updateEntity2 = update.getUpdateEntity();
        UpdateEntity updateEntity3 = this.launchedUpdate;
        ResponseHeaderData responseHeaderData2 = updateResponse.getResponseHeaderData();
        boolean zShouldLoadNewUpdate = selectionPolicy2.shouldLoadNewUpdate(updateEntity2, updateEntity3, responseHeaderData2 != null ? responseHeaderData2.getManifestFilters() : null);
        boolean z2 = false;
        if (zShouldLoadNewUpdate) {
            UpdateEntity updateEntity4 = update.getUpdateEntity();
            if (updateEntity4 == null || (updateEntityLoadUpdateWithId = this.database.updateDao().loadUpdateWithId(updateEntity4.getId())) == null) {
                z = false;
                z2 = true;
            } else {
                z2 = updateEntityLoadUpdateWithId.getFailedLaunchCount() == 0;
                UpdatesLogger.info$default(this.updatesLogger, "Stored update found: ID = " + updateEntity4.getId() + ", failureCount = " + updateEntityLoadUpdateWithId.getFailedLaunchCount(), null, 2, null);
                z = z2 ^ true;
            }
        } else {
            z = false;
        }
        if (z2) {
            procedureContext.processStateEvent(new UpdatesStateEvent.CheckCompleteWithUpdate(update.getManifest().getRawJson()));
            this.callback.invoke(new IUpdatesController.CheckForUpdateResult.UpdateAvailable(update));
            procedureContext.onComplete();
        } else {
            if (z) {
                remoteCheckResultNotAvailableReason = LoaderTask.RemoteCheckResultNotAvailableReason.UPDATE_PREVIOUSLY_FAILED;
            } else {
                remoteCheckResultNotAvailableReason = LoaderTask.RemoteCheckResultNotAvailableReason.UPDATE_REJECTED_BY_SELECTION_POLICY;
            }
            procedureContext.processStateEvent(new UpdatesStateEvent.CheckCompleteUnavailable());
            this.callback.invoke(new IUpdatesController.CheckForUpdateResult.NoUpdateAvailable(remoteCheckResultNotAvailableReason));
            procedureContext.onComplete();
        }
    }
}
