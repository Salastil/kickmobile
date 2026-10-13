package expo.modules.updates.events;

import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.updates.statemachine.UpdatesStateContext;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

/* JADX INFO: compiled from: IUpdatesEventManager.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&R \u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lexpo/modules/updates/events/IUpdatesEventManager;", "", "observer", "Ljava/lang/ref/WeakReference;", "Lexpo/modules/updates/events/IUpdatesEventManagerObserver;", "getObserver", "()Ljava/lang/ref/WeakReference;", "setObserver", "(Ljava/lang/ref/WeakReference;)V", "sendStateMachineContextEvent", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lexpo/modules/updates/statemachine/UpdatesStateContext;", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface IUpdatesEventManager {
    WeakReference<IUpdatesEventManagerObserver> getObserver();

    void sendStateMachineContextEvent(UpdatesStateContext context);

    void setObserver(WeakReference<IUpdatesEventManagerObserver> weakReference);
}
