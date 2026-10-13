package expo.modules.updates.selectionpolicy;

import expo.modules.updates.UpdatesConfiguration;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SelectionPolicyFactory.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lexpo/modules/updates/selectionpolicy/SelectionPolicyFactory;", "", "<init>", "()V", "createFilterAwarePolicy", "Lexpo/modules/updates/selectionpolicy/SelectionPolicy;", UpdatesConfiguration.UPDATES_CONFIGURATION_RUNTIME_VERSION_KEY, "", "config", "Lexpo/modules/updates/UpdatesConfiguration;", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SelectionPolicyFactory {
    public static final SelectionPolicyFactory INSTANCE = new SelectionPolicyFactory();

    private SelectionPolicyFactory() {
    }

    @JvmStatic
    public static final SelectionPolicy createFilterAwarePolicy(String runtimeVersion, UpdatesConfiguration config) {
        Intrinsics.checkNotNullParameter(runtimeVersion, "runtimeVersion");
        Intrinsics.checkNotNullParameter(config, "config");
        return new SelectionPolicy(new LauncherSelectionPolicyFilterAware(runtimeVersion, config), new LoaderSelectionPolicyFilterAware(config), new ReaperSelectionPolicyFilterAware(config.getMaxUpdatesToKeep()));
    }
}
