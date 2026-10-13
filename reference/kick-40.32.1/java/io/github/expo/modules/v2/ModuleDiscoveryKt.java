package io.github.expo.modules.v2;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: ModuleDiscovery.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"discoveredExpoModules", "", "Ljava/lang/Class;", "Lio/github/expo/modules/v2/Module;", "react_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ModuleDiscoveryKt {
    public static final List<Class<? extends Module>> discoveredExpoModules() {
        throw new IllegalStateException("discoveredExpoModules() was not expanded at compile time, so this build has no list of Expo modules. The Expo Modules v2 Kotlin compiler plugin rewrites this call into the modules it finds on the compile classpath; apply the `io.github.expo.modules.v2` Gradle plugin to the project that calls it, or register the modules by hand with ModuleRegistry.register().");
    }
}
