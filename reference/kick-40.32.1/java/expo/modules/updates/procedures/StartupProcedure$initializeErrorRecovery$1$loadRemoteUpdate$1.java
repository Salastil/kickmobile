package expo.modules.updates.procedures;

import expo.modules.updates.db.entity.UpdateEntity;
import expo.modules.updates.errorrecovery.ErrorRecoveryDelegate;
import expo.modules.updates.loader.Loader;
import expo.modules.updates.loader.RemoteLoader;
import expo.modules.updates.loader.UpdateDirective;
import expo.modules.updates.loader.UpdateResponse;
import expo.modules.updates.loader.UpdateResponsePart;
import expo.modules.updates.logging.UpdatesErrorCode;
import expo.modules.updates.logging.UpdatesLogger;
import expo.modules.updates.manifest.ResponseHeaderData;
import expo.modules.updates.manifest.Update;
import expo.modules.updates.selectionpolicy.SelectionPolicy;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: StartupProcedure.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.updates.procedures.StartupProcedure$initializeErrorRecovery$1$loadRemoteUpdate$1", f = "StartupProcedure.kt", i = {}, l = {254}, m = "invokeSuspend", n = {}, nl = {269}, s = {}, v = 2)
final class StartupProcedure$initializeErrorRecovery$1$loadRemoteUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RemoteLoader $remoteLoader;
    int label;
    final /* synthetic */ StartupProcedure this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StartupProcedure$initializeErrorRecovery$1$loadRemoteUpdate$1(RemoteLoader remoteLoader, StartupProcedure startupProcedure, Continuation<? super StartupProcedure$initializeErrorRecovery$1$loadRemoteUpdate$1> continuation) {
        super(2, continuation);
        this.$remoteLoader = remoteLoader;
        this.this$0 = startupProcedure;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StartupProcedure$initializeErrorRecovery$1$loadRemoteUpdate$1(this.$remoteLoader, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StartupProcedure$initializeErrorRecovery$1$loadRemoteUpdate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ErrorRecoveryDelegate.RemoteLoadStatus remoteLoadStatus;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                RemoteLoader remoteLoader = this.$remoteLoader;
                final StartupProcedure startupProcedure = this.this$0;
                this.label = 1;
                obj = remoteLoader.load(new Function1() { // from class: expo.modules.updates.procedures.StartupProcedure$initializeErrorRecovery$1$loadRemoteUpdate$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return StartupProcedure$initializeErrorRecovery$1$loadRemoteUpdate$1.invokeSuspend$lambda$0(startupProcedure, (UpdateResponse) obj2);
                    }
                }, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Loader.LoaderResult loaderResult = (Loader.LoaderResult) obj;
            StartupProcedure startupProcedure2 = this.this$0;
            if (loaderResult.getUpdateEntity() != null || (loaderResult.getUpdateDirective() instanceof UpdateDirective.RollBackToEmbeddedUpdateDirective)) {
                remoteLoadStatus = ErrorRecoveryDelegate.RemoteLoadStatus.NEW_UPDATE_LOADED;
            } else {
                remoteLoadStatus = ErrorRecoveryDelegate.RemoteLoadStatus.IDLE;
            }
            startupProcedure2.setRemoteLoadStatus(remoteLoadStatus);
        } catch (CancellationException e) {
            throw e;
        } catch (Exception e2) {
            UpdatesLogger updatesLogger = this.this$0.logger;
            UpdatesErrorCode updatesErrorCode = UpdatesErrorCode.UpdateFailedToLoad;
            UpdateEntity launchedUpdate = this.this$0.getLaunchedUpdate();
            updatesLogger.error("UpdatesController loadRemoteUpdate onFailure", e2, updatesErrorCode, launchedUpdate != null ? launchedUpdate.getLoggingId() : null, null);
            this.this$0.setRemoteLoadStatus(ErrorRecoveryDelegate.RemoteLoadStatus.IDLE);
        }
        return Unit.INSTANCE;
    }

    static final Loader.OnUpdateResponseLoadedResult invokeSuspend$lambda$0(StartupProcedure startupProcedure, UpdateResponse updateResponse) {
        Update update;
        UpdateResponsePart.DirectiveUpdateResponsePart directiveUpdateResponsePart = updateResponse.getDirectiveUpdateResponsePart();
        UpdateDirective updateDirective = directiveUpdateResponsePart != null ? directiveUpdateResponsePart.getUpdateDirective() : null;
        if (updateDirective != null) {
            if ((updateDirective instanceof UpdateDirective.RollBackToEmbeddedUpdateDirective) || (updateDirective instanceof UpdateDirective.NoUpdateAvailableUpdateDirective)) {
                return new Loader.OnUpdateResponseLoadedResult(false);
            }
            throw new NoWhenBranchMatchedException();
        }
        UpdateResponsePart.ManifestUpdateResponsePart manifestUpdateResponsePart = updateResponse.getManifestUpdateResponsePart();
        if (manifestUpdateResponsePart != null && (update = manifestUpdateResponsePart.getUpdate()) != null) {
            SelectionPolicy selectionPolicy = startupProcedure.selectionPolicy;
            UpdateEntity updateEntity = update.getUpdateEntity();
            UpdateEntity launchedUpdate = startupProcedure.getLaunchedUpdate();
            ResponseHeaderData responseHeaderData = updateResponse.getResponseHeaderData();
            return new Loader.OnUpdateResponseLoadedResult(selectionPolicy.shouldLoadNewUpdate(updateEntity, launchedUpdate, responseHeaderData != null ? responseHeaderData.getManifestFilters() : null));
        }
        return new Loader.OnUpdateResponseLoadedResult(false);
    }
}
