package expo.modules.updates;

import expo.modules.updatesinterface.UpdatesStateChangeSubscription;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UpdatesStateChangeSubscription.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lexpo/modules/updates/EnabledUpdatesStateChangeSubscription;", "Lexpo/modules/updatesinterface/UpdatesStateChangeSubscription;", "subscriptionId", "", "<init>", "(Ljava/lang/String;)V", "getSubscriptionId", "()Ljava/lang/String;", "remove", "", "getContext", "", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class EnabledUpdatesStateChangeSubscription implements UpdatesStateChangeSubscription {
    private final String subscriptionId;

    public EnabledUpdatesStateChangeSubscription(String subscriptionId) {
        Intrinsics.checkNotNullParameter(subscriptionId, "subscriptionId");
        this.subscriptionId = subscriptionId;
    }

    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    @Override // expo.modules.updatesinterface.UpdatesStateChangeSubscription
    public void remove() {
        IUpdatesController updatesController = UpdatesController.getInstance();
        EnabledUpdatesController enabledUpdatesController = updatesController instanceof EnabledUpdatesController ? (EnabledUpdatesController) updatesController : null;
        if (enabledUpdatesController != null) {
            enabledUpdatesController.unsubscribeFromUpdatesStateChanges(this.subscriptionId);
        }
    }

    @Override // expo.modules.updatesinterface.UpdatesStateChangeSubscription
    public Object getContext() {
        IUpdatesController updatesController = UpdatesController.getInstance();
        EnabledUpdatesController enabledUpdatesController = updatesController instanceof EnabledUpdatesController ? (EnabledUpdatesController) updatesController : null;
        if (enabledUpdatesController != null) {
            return enabledUpdatesController.getNativeInterfaceContext$expo_updates_release();
        }
        return null;
    }
}
