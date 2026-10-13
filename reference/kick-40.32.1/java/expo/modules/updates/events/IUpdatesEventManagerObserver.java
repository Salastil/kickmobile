package expo.modules.updates.events;

import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.updates.statemachine.UpdatesStateContext;
import kotlin.Metadata;

/* JADX INFO: compiled from: IUpdatesEventManager.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lexpo/modules/updates/events/IUpdatesEventManagerObserver;", "", "onStateMachineContextEvent", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lexpo/modules/updates/statemachine/UpdatesStateContext;", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface IUpdatesEventManagerObserver {
    void onStateMachineContextEvent(UpdatesStateContext context);
}
