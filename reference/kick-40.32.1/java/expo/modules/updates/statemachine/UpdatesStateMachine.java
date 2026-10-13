package expo.modules.updates.statemachine;

import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.interfaces.permissions.PermissionsResponse;
import expo.modules.manifests.core.JSONObjectExtensionKt;
import expo.modules.updates.EnabledUpdatesController;
import expo.modules.updates.events.IUpdatesEventManager;
import expo.modules.updates.logging.UpdatesLogger;
import expo.modules.updates.procedures.StateMachineProcedure;
import expo.modules.updates.procedures.StateMachineSerialExecutorQueue;
import expo.modules.updatesinterface.UpdatesControllerRegistry;
import expo.modules.updatesinterface.UpdatesInterface;
import expo.modules.updatesinterface.UpdatesStateChangeListener;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: UpdatesStateMachine.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 %2\u00020\u0001:\u0001%B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0019\u001a\u00020\u0010H\u0002J\u001c\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00010\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\"\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010#\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0006\u0010$\u001a\u00020\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006&"}, d2 = {"Lexpo/modules/updates/statemachine/UpdatesStateMachine;", "", "logger", "Lexpo/modules/updates/logging/UpdatesLogger;", "eventManager", "Lexpo/modules/updates/events/IUpdatesEventManager;", "validUpdatesStateValues", "", "Lexpo/modules/updates/statemachine/UpdatesStateValue;", PermissionsResponse.SCOPE_KEY, "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lexpo/modules/updates/logging/UpdatesLogger;Lexpo/modules/updates/events/IUpdatesEventManager;Ljava/util/Set;Lkotlinx/coroutines/CoroutineScope;)V", "serialExecutorQueue", "Lexpo/modules/updates/procedures/StateMachineSerialExecutorQueue;", "queueExecution", "", "stateMachineProcedure", "Lexpo/modules/updates/procedures/StateMachineProcedure;", "state", "value", "Lexpo/modules/updates/statemachine/UpdatesStateContext;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "getContext", "()Lexpo/modules/updates/statemachine/UpdatesStateContext;", "resetAndIncrementRestartCount", "toMap", "", "", "event", "Lexpo/modules/updates/statemachine/UpdatesStateEvent;", "processEvent", "transition", "", "reportDroppedEvent", "droppedEventWarning", "sendContextToJS", "Companion", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class UpdatesStateMachine {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<UpdatesStateValue, Set<UpdatesStateEventType>> updatesStateAllowedEvents = MapsKt.mapOf(TuplesKt.to(UpdatesStateValue.Idle, SetsKt.setOf((Object[]) new UpdatesStateEventType[]{UpdatesStateEventType.StartStartup, UpdatesStateEventType.EndStartup, UpdatesStateEventType.Check, UpdatesStateEventType.Download, UpdatesStateEventType.Restart})), TuplesKt.to(UpdatesStateValue.Checking, SetsKt.setOf((Object[]) new UpdatesStateEventType[]{UpdatesStateEventType.CheckCompleteAvailable, UpdatesStateEventType.CheckCompleteUnavailable, UpdatesStateEventType.CheckError})), TuplesKt.to(UpdatesStateValue.Downloading, SetsKt.setOf((Object[]) new UpdatesStateEventType[]{UpdatesStateEventType.DownloadCompleteUnavailable, UpdatesStateEventType.DownloadCompleteWithUpdate, UpdatesStateEventType.DownloadCompleteWithRollback, UpdatesStateEventType.DownloadError, UpdatesStateEventType.DownloadProgress})), TuplesKt.to(UpdatesStateValue.Restarting, SetsKt.emptySet()));
    private static final Map<UpdatesStateEventType, UpdatesStateValue> updatesStateTransitions = MapsKt.mapOf(TuplesKt.to(UpdatesStateEventType.StartStartup, UpdatesStateValue.Idle), TuplesKt.to(UpdatesStateEventType.EndStartup, UpdatesStateValue.Idle), TuplesKt.to(UpdatesStateEventType.Check, UpdatesStateValue.Checking), TuplesKt.to(UpdatesStateEventType.CheckCompleteAvailable, UpdatesStateValue.Idle), TuplesKt.to(UpdatesStateEventType.CheckCompleteUnavailable, UpdatesStateValue.Idle), TuplesKt.to(UpdatesStateEventType.CheckError, UpdatesStateValue.Idle), TuplesKt.to(UpdatesStateEventType.Download, UpdatesStateValue.Downloading), TuplesKt.to(UpdatesStateEventType.DownloadProgress, UpdatesStateValue.Downloading), TuplesKt.to(UpdatesStateEventType.DownloadCompleteUnavailable, UpdatesStateValue.Idle), TuplesKt.to(UpdatesStateEventType.DownloadCompleteWithUpdate, UpdatesStateValue.Idle), TuplesKt.to(UpdatesStateEventType.DownloadCompleteWithRollback, UpdatesStateValue.Idle), TuplesKt.to(UpdatesStateEventType.DownloadError, UpdatesStateValue.Idle), TuplesKt.to(UpdatesStateEventType.Restart, UpdatesStateValue.Restarting));
    private UpdatesStateContext context;
    private final IUpdatesEventManager eventManager;
    private final UpdatesLogger logger;
    private final StateMachineSerialExecutorQueue serialExecutorQueue;
    private UpdatesStateValue state;
    private final Set<UpdatesStateValue> validUpdatesStateValues;

    /* JADX WARN: Multi-variable type inference failed */
    public UpdatesStateMachine(UpdatesLogger logger, IUpdatesEventManager eventManager, Set<? extends UpdatesStateValue> validUpdatesStateValues, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(eventManager, "eventManager");
        Intrinsics.checkNotNullParameter(validUpdatesStateValues, "validUpdatesStateValues");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.logger = logger;
        this.eventManager = eventManager;
        this.validUpdatesStateValues = validUpdatesStateValues;
        this.serialExecutorQueue = new StateMachineSerialExecutorQueue(logger, new StateMachineProcedure.StateMachineProcedureContext() { // from class: expo.modules.updates.statemachine.UpdatesStateMachine$serialExecutorQueue$1
            @Override // expo.modules.updates.procedures.StateMachineProcedure.StateMachineProcedureContext
            public void processStateEvent(UpdatesStateEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                this.this$0.processEvent(event);
            }

            @Override // expo.modules.updates.procedures.StateMachineProcedure.StateMachineProcedureContext
            @Deprecated(message = "Avoid needing to access current state to know how to transition to next state")
            public UpdatesStateValue getCurrentState() {
                return this.this$0.state;
            }

            @Override // expo.modules.updates.procedures.StateMachineProcedure.StateMachineProcedureContext
            public void resetStateAfterRestart() {
                this.this$0.resetAndIncrementRestartCount();
            }
        }, scope);
        this.state = UpdatesStateValue.Idle;
        this.context = new UpdatesStateContext(false, false, false, false, false, false, 0, null, null, null, null, null, 0.0d, null, null, null, 65535, null);
    }

    public /* synthetic */ UpdatesStateMachine(UpdatesLogger updatesLogger, IUpdatesEventManager iUpdatesEventManager, Set set, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(updatesLogger, iUpdatesEventManager, set, (i & 8) != 0 ? CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()) : coroutineScope);
    }

    public final void queueExecution(StateMachineProcedure stateMachineProcedure) {
        Intrinsics.checkNotNullParameter(stateMachineProcedure, "stateMachineProcedure");
        this.serialExecutorQueue.queueExecution(stateMachineProcedure);
    }

    public final UpdatesStateContext getContext() {
        return this.context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resetAndIncrementRestartCount() {
        this.state = UpdatesStateValue.Idle;
        UpdatesStateContext updatesStateContextResetCopyWithIncrementedRestartCountAndSequenceNumber = this.context.resetCopyWithIncrementedRestartCountAndSequenceNumber();
        this.context = updatesStateContextResetCopyWithIncrementedRestartCountAndSequenceNumber;
        UpdatesLogger.info$default(this.logger, "Updates state change: reset, context = " + updatesStateContextResetCopyWithIncrementedRestartCountAndSequenceNumber.getJson(), null, 2, null);
        sendContextToJS();
    }

    private final Map<String, Object> toMap(UpdatesStateEvent event) {
        if (event instanceof UpdatesStateEvent.DownloadCompleteWithUpdate) {
            return MapsKt.mapOf(TuplesKt.to("type", "downloadCompleteWithUpdate"), TuplesKt.to("manifest", JSONObjectExtensionKt.toMap(((UpdatesStateEvent.DownloadCompleteWithUpdate) event).getManifest())));
        }
        if (event instanceof UpdatesStateEvent.CheckCompleteWithUpdate) {
            return MapsKt.mapOf(TuplesKt.to("type", "checkCompleteWithUpdate"), TuplesKt.to("manifest", JSONObjectExtensionKt.toMap(((UpdatesStateEvent.CheckCompleteWithUpdate) event).getManifest())));
        }
        if (event instanceof UpdatesStateEvent.CheckCompleteWithRollback) {
            return MapsKt.mapOf(TuplesKt.to("type", "checkCompleteWithRollback"));
        }
        if (event instanceof UpdatesStateEvent.CheckError) {
            return MapsKt.mapOf(TuplesKt.to("type", "checkError"), TuplesKt.to("errorMessage", ((UpdatesStateEvent.CheckError) event).getError().getMessage()));
        }
        if (event instanceof UpdatesStateEvent.DownloadError) {
            return MapsKt.mapOf(TuplesKt.to("type", "downloadError"), TuplesKt.to("errorMessage", ((UpdatesStateEvent.DownloadError) event).getError().getMessage()));
        }
        if (event instanceof UpdatesStateEvent.DownloadProgress) {
            return MapsKt.mapOf(TuplesKt.to("type", "downloadProgress"), TuplesKt.to("progress", Double.valueOf(((UpdatesStateEvent.DownloadProgress) event).getProgress())));
        }
        if (!(event instanceof UpdatesStateEvent.Check) && !(event instanceof UpdatesStateEvent.CheckCompleteUnavailable) && !(event instanceof UpdatesStateEvent.Download) && !(event instanceof UpdatesStateEvent.DownloadCompleteUnavailable) && !(event instanceof UpdatesStateEvent.DownloadCompleteWithRollback) && !(event instanceof UpdatesStateEvent.Restart) && !(event instanceof UpdatesStateEvent.StartStartup) && !(event instanceof UpdatesStateEvent.EndStartup)) {
            throw new NoWhenBranchMatchedException();
        }
        return MapsKt.mapOf(TuplesKt.to("type", event.getType().getType()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processEvent(UpdatesStateEvent event) {
        UpdatesInterface updatesInterface;
        if (transition(event)) {
            this.context = INSTANCE.reduceContext(this.context, event);
            if (!(event instanceof UpdatesStateEvent.DownloadProgress)) {
                UpdatesLogger.info$default(this.logger, "Updates state change: " + event.getType() + ", context = " + this.context.getJson(), null, 2, null);
            }
            WeakReference<UpdatesInterface> controller = UpdatesControllerRegistry.INSTANCE.getController();
            if (controller != null && (updatesInterface = controller.get()) != null && (updatesInterface instanceof EnabledUpdatesController)) {
                EnabledUpdatesController enabledUpdatesController = (EnabledUpdatesController) updatesInterface;
                Iterator<T> it = enabledUpdatesController.getStateChangeListenerMap$expo_updates_release().keySet().iterator();
                while (it.hasNext()) {
                    UpdatesStateChangeListener updatesStateChangeListener = enabledUpdatesController.getStateChangeListenerMap$expo_updates_release().get((String) it.next());
                    if (updatesStateChangeListener != null) {
                        updatesStateChangeListener.updatesStateDidChange(toMap(event));
                    }
                }
            }
            sendContextToJS();
        }
    }

    private final boolean transition(UpdatesStateEvent event) {
        Set<UpdatesStateEventType> setEmptySet = updatesStateAllowedEvents.get(this.state);
        if (setEmptySet == null) {
            setEmptySet = SetsKt.emptySet();
        }
        if (!setEmptySet.contains(event.getType())) {
            reportDroppedEvent(event);
            return false;
        }
        UpdatesStateValue updatesStateValue = updatesStateTransitions.get(event.getType());
        if (updatesStateValue == null) {
            updatesStateValue = UpdatesStateValue.Idle;
        }
        if (!this.validUpdatesStateValues.contains(updatesStateValue)) {
            reportDroppedEvent(event);
            return false;
        }
        this.state = updatesStateValue;
        return true;
    }

    private final void reportDroppedEvent(UpdatesStateEvent event) {
        UpdatesLogger.warn$default(this.logger, droppedEventWarning(event), null, 2, null);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0033  */
    private final String droppedEventWarning(UpdatesStateEvent event) {
        String message;
        String str;
        if (event instanceof UpdatesStateEvent.CheckError) {
            message = ((UpdatesStateEvent.CheckError) event).getError().getMessage();
        } else {
            message = event instanceof UpdatesStateEvent.DownloadError ? ((UpdatesStateEvent.DownloadError) event).getError().getMessage() : null;
        }
        if (message != null) {
            str = ", error = " + message;
            if (str == null) {
                str = "";
            }
        } else {
            str = "";
        }
        return "UpdatesState: invalid transition requested, event dropped: state = " + this.state + ", event = " + event.getType() + str;
    }

    public final void sendContextToJS() {
        this.eventManager.sendStateMachineContextEvent(this.context);
    }

    /* JADX INFO: compiled from: UpdatesStateMachine.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R#\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\u0012"}, d2 = {"Lexpo/modules/updates/statemachine/UpdatesStateMachine$Companion;", "", "<init>", "()V", "updatesStateAllowedEvents", "", "Lexpo/modules/updates/statemachine/UpdatesStateValue;", "", "Lexpo/modules/updates/statemachine/UpdatesStateEventType;", "getUpdatesStateAllowedEvents", "()Ljava/util/Map;", "updatesStateTransitions", "getUpdatesStateTransitions", "reduceContext", "Lexpo/modules/updates/statemachine/UpdatesStateContext;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "event", "Lexpo/modules/updates/statemachine/UpdatesStateEvent;", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Map<UpdatesStateValue, Set<UpdatesStateEventType>> getUpdatesStateAllowedEvents() {
            return UpdatesStateMachine.updatesStateAllowedEvents;
        }

        public final Map<UpdatesStateEventType, UpdatesStateValue> getUpdatesStateTransitions() {
            return UpdatesStateMachine.updatesStateTransitions;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final UpdatesStateContext reduceContext(UpdatesStateContext context, UpdatesStateEvent event) {
            if (event instanceof UpdatesStateEvent.StartStartup) {
                return UpdatesStateContext.copyAndIncrementSequenceNumber$default(context, true, false, false, false, false, 0.0d, false, 0, null, null, null, null, null, null, null, null, 65534, null);
            }
            if (event instanceof UpdatesStateEvent.EndStartup) {
                return UpdatesStateContext.copyAndIncrementSequenceNumber$default(context, false, false, false, false, false, 0.0d, false, 0, null, null, null, null, null, null, null, null, 65534, null);
            }
            if (event instanceof UpdatesStateEvent.Check) {
                return UpdatesStateContext.copyAndIncrementSequenceNumber$default(context, false, false, false, true, false, 0.0d, false, 0, null, null, null, null, null, null, null, null, 65527, null);
            }
            if (event instanceof UpdatesStateEvent.CheckCompleteUnavailable) {
                return UpdatesStateContext.copyAndIncrementSequenceNumber$default(context, false, false, false, false, false, 0.0d, false, 0, null, null, null, null, null, new Date(), null, null, 54005, null);
            }
            if (event instanceof UpdatesStateEvent.CheckCompleteWithRollback) {
                return UpdatesStateContext.copyAndIncrementSequenceNumber$default(context, false, true, false, false, false, 0.0d, false, 0, null, null, new UpdatesStateContextRollback(((UpdatesStateEvent.CheckCompleteWithRollback) event).getCommitTime()), null, null, new Date(), null, null, 54005, null);
            }
            if (event instanceof UpdatesStateEvent.CheckCompleteWithUpdate) {
                return UpdatesStateContext.copyAndIncrementSequenceNumber$default(context, false, true, false, false, false, 0.0d, false, 0, ((UpdatesStateEvent.CheckCompleteWithUpdate) event).getManifest(), null, null, null, null, new Date(), null, null, 54005, null);
            }
            if (event instanceof UpdatesStateEvent.CheckError) {
                return UpdatesStateContext.copyAndIncrementSequenceNumber$default(context, false, false, false, false, false, 0.0d, false, 0, null, null, null, ((UpdatesStateEvent.CheckError) event).getError(), null, new Date(), null, null, 55287, null);
            }
            if (event instanceof UpdatesStateEvent.Download) {
                return UpdatesStateContext.copyAndIncrementSequenceNumber$default(context, false, false, false, false, true, 0.0d, false, 0, null, null, null, null, null, null, new Date(), null, 16335, null);
            }
            if (event instanceof UpdatesStateEvent.DownloadProgress) {
                return UpdatesStateContext.copyAndIncrementSequenceNumber$default(context, false, false, false, false, false, ((UpdatesStateEvent.DownloadProgress) event).getProgress(), false, 0, null, null, null, null, null, null, null, null, 65503, null);
            }
            if (event instanceof UpdatesStateEvent.DownloadCompleteUnavailable) {
                return UpdatesStateContext.copyAndIncrementSequenceNumber$default(context, false, false, false, false, false, 1.0d, false, 0, null, null, null, null, null, null, null, null, 12235, null);
            }
            if (event instanceof UpdatesStateEvent.DownloadCompleteWithRollback) {
                return UpdatesStateContext.copyAndIncrementSequenceNumber$default(context, false, false, true, false, false, 0.0d, false, 0, null, null, null, null, null, null, null, null, 12267, null);
            }
            if (event instanceof UpdatesStateEvent.DownloadCompleteWithUpdate) {
                UpdatesStateEvent.DownloadCompleteWithUpdate downloadCompleteWithUpdate = (UpdatesStateEvent.DownloadCompleteWithUpdate) event;
                return UpdatesStateContext.copyAndIncrementSequenceNumber$default(context, false, true, true, false, false, 0.0d, false, 0, downloadCompleteWithUpdate.getManifest(), downloadCompleteWithUpdate.getManifest(), null, null, null, null, null, new Date(), 26857, null);
            }
            if (event instanceof UpdatesStateEvent.DownloadError) {
                return UpdatesStateContext.copyAndIncrementSequenceNumber$default(context, false, false, false, false, false, 0.0d, false, 0, null, null, null, null, ((UpdatesStateEvent.DownloadError) event).getError(), null, null, null, 12271, null);
            }
            if (event instanceof UpdatesStateEvent.Restart) {
                return UpdatesStateContext.copyAndIncrementSequenceNumber$default(context, false, false, false, false, false, 0.0d, true, 0, null, null, null, null, null, null, null, null, 65471, null);
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
