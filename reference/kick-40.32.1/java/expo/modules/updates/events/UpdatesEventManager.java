package expo.modules.updates.events;

import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.updates.logging.UpdatesErrorCode;
import expo.modules.updates.logging.UpdatesLogger;
import expo.modules.updates.statemachine.UpdatesStateContext;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UpdatesEventManager.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lexpo/modules/updates/events/UpdatesEventManager;", "Lexpo/modules/updates/events/IUpdatesEventManager;", "logger", "Lexpo/modules/updates/logging/UpdatesLogger;", "<init>", "(Lexpo/modules/updates/logging/UpdatesLogger;)V", "observer", "Ljava/lang/ref/WeakReference;", "Lexpo/modules/updates/events/IUpdatesEventManagerObserver;", "getObserver", "()Ljava/lang/ref/WeakReference;", "setObserver", "(Ljava/lang/ref/WeakReference;)V", "sendStateMachineContextEvent", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lexpo/modules/updates/statemachine/UpdatesStateContext;", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class UpdatesEventManager implements IUpdatesEventManager {
    private final UpdatesLogger logger;
    private WeakReference<IUpdatesEventManagerObserver> observer;

    public UpdatesEventManager(UpdatesLogger logger) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.logger = logger;
    }

    @Override // expo.modules.updates.events.IUpdatesEventManager
    public WeakReference<IUpdatesEventManagerObserver> getObserver() {
        return this.observer;
    }

    @Override // expo.modules.updates.events.IUpdatesEventManager
    public void setObserver(WeakReference<IUpdatesEventManagerObserver> weakReference) {
        this.observer = weakReference;
    }

    @Override // expo.modules.updates.events.IUpdatesEventManager
    public void sendStateMachineContextEvent(UpdatesStateContext context) {
        IUpdatesEventManagerObserver iUpdatesEventManagerObserver;
        Intrinsics.checkNotNullParameter(context, "context");
        UpdatesLogger.debug$default(this.logger, "Sending state machine context to observer", null, 2, null);
        WeakReference<IUpdatesEventManagerObserver> observer = getObserver();
        if (observer == null || (iUpdatesEventManagerObserver = observer.get()) == null) {
            this.logger.debug("Unable to send state machine context to observer, no observer", UpdatesErrorCode.JSRuntimeError);
            return;
        }
        try {
            iUpdatesEventManagerObserver.onStateMachineContextEvent(context);
            UpdatesLogger.debug$default(this.logger, "Sent state machine context to observer", null, 2, null);
        } catch (Exception e) {
            this.logger.error("Could not send state machine context to observer", e, UpdatesErrorCode.JSRuntimeError);
        }
    }
}
