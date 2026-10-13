package expo.modules;

import expo.modules.application.ApplicationModule;
import expo.modules.crypto.CryptoModule;
import expo.modules.haptics.HapticsModule;
import expo.modules.v2.ExpoModulesV2Provider;
import io.github.expo.modules.v2.Module;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: ExpoModulesV2ModuleList.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00060\u0005H\u0016¨\u0006\b"}, d2 = {"Lexpo/modules/ExpoModulesV2ModuleList;", "Lexpo/modules/v2/ExpoModulesV2Provider;", "<init>", "()V", "getModules", "", "Ljava/lang/Class;", "Lio/github/expo/modules/v2/Module;", "expo_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ExpoModulesV2ModuleList implements ExpoModulesV2Provider {
    @Override // expo.modules.v2.ExpoModulesV2Provider
    public List<Class<? extends Module>> getModules() {
        return CollectionsKt.listOf((Object[]) new Class[]{ApplicationModule.class, CryptoModule.class, HapticsModule.class});
    }
}
