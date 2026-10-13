package expo.modules.updatesinterface;

import java.lang.ref.WeakReference;
import kotlin.Metadata;

/* JADX INFO: compiled from: UpdatesControllerRegistry.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lexpo/modules/updatesinterface/UpdatesControllerRegistry;", "", "<init>", "()V", "controller", "Ljava/lang/ref/WeakReference;", "Lexpo/modules/updatesinterface/UpdatesInterface;", "getController", "()Ljava/lang/ref/WeakReference;", "setController", "(Ljava/lang/ref/WeakReference;)V", "expo-updates-interface_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class UpdatesControllerRegistry {
    public static final UpdatesControllerRegistry INSTANCE = new UpdatesControllerRegistry();
    private static WeakReference<UpdatesInterface> controller;

    private UpdatesControllerRegistry() {
    }

    public final WeakReference<UpdatesInterface> getController() {
        return controller;
    }

    public final void setController(WeakReference<UpdatesInterface> weakReference) {
        controller = weakReference;
    }
}
