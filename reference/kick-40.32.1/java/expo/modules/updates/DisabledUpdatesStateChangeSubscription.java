package expo.modules.updates;

import expo.modules.updatesinterface.UpdatesStateChangeSubscription;
import kotlin.Metadata;

/* JADX INFO: compiled from: UpdatesStateChangeSubscription.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"Lexpo/modules/updates/DisabledUpdatesStateChangeSubscription;", "Lexpo/modules/updatesinterface/UpdatesStateChangeSubscription;", "<init>", "()V", "remove", "", "getContext", "", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DisabledUpdatesStateChangeSubscription implements UpdatesStateChangeSubscription {
    @Override // expo.modules.updatesinterface.UpdatesStateChangeSubscription
    public Object getContext() {
        return null;
    }

    @Override // expo.modules.updatesinterface.UpdatesStateChangeSubscription
    public void remove() {
    }
}
