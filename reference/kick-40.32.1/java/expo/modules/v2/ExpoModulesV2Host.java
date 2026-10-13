package expo.modules.v2;

import com.facebook.react.bridge.ReactApplicationContext;
import expo.modules.core.logging.Logger;
import expo.modules.kotlin.CoreLoggerKt;
import io.github.expo.modules.v2.Module;
import io.github.expo.modules.v2.modules.ModuleRegistry;
import io.github.expo.modules.v2.react.ReactRuntime;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExpoModulesV2Host.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\tJ\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\u0018\u0010\u0010\u001a\u00020\u000f2\u000e\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lexpo/modules/v2/ExpoModulesV2Host;", "", "<init>", "()V", "GENERATED_PROVIDER_CLASS", "", "runtime", "Lio/github/expo/modules/v2/react/ReactRuntime;", "install", "", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "uninstall", "autolinkedModules", "", "Lio/github/expo/modules/v2/Module;", "instantiate", "moduleClass", "Ljava/lang/Class;", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ExpoModulesV2Host {
    private static final String GENERATED_PROVIDER_CLASS = "expo.modules.ExpoModulesV2ModuleList";
    private static ReactRuntime runtime;
    public static final ExpoModulesV2Host INSTANCE = new ExpoModulesV2Host();
    public static final int $stable = 8;

    private ExpoModulesV2Host() {
    }

    public final void install(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        synchronized (this) {
            if (runtime != null) {
                Logger.warn$default(CoreLoggerKt.getLogger(), "⚠️ Expo Modules v2 was already installed", null, 2, null);
                return;
            }
            try {
                List<Module> listAutolinkedModules = INSTANCE.autolinkedModules();
                if (listAutolinkedModules.isEmpty()) {
                    return;
                }
                try {
                    ReactRuntime reactRuntimeAttach$default = ReactRuntime.Companion.attach$default(ReactRuntime.INSTANCE, reactContext, null, null, 6, null);
                    try {
                        ModuleRegistry moduleRegistry = reactRuntimeAttach$default.getModuleRegistry();
                        Iterator<T> it = listAutolinkedModules.iterator();
                        while (it.hasNext()) {
                            moduleRegistry.register((Module) it.next());
                        }
                        runtime = reactRuntimeAttach$default;
                        CoreLoggerKt.getLogger().info("✅ Expo Modules v2 installed " + listAutolinkedModules.size() + " module(s) on globalThis.expo.modules");
                    } catch (Throwable th) {
                        reactRuntimeAttach$default.close();
                        throw th;
                    }
                } catch (Throwable th2) {
                    CoreLoggerKt.getLogger().error("❌ Cannot install Expo Modules v2: " + th2, th2);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th3) {
                CoreLoggerKt.getLogger().error("❌ Cannot collect Expo Modules v2 modules: " + th3, th3);
            }
        }
    }

    public final void uninstall() {
        synchronized (this) {
            ReactRuntime reactRuntime = runtime;
            if (reactRuntime != null) {
                reactRuntime.close();
            }
            runtime = null;
            Unit unit = Unit.INSTANCE;
        }
    }

    private final List<Module> autolinkedModules() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        try {
            Object objNewInstance = Class.forName(GENERATED_PROVIDER_CLASS).getConstructor(null).newInstance(null);
            Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type expo.modules.v2.ExpoModulesV2Provider");
            List<Class<? extends Module>> modules = ((ExpoModulesV2Provider) objNewInstance).getModules();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(modules, 10));
            Iterator<T> it = modules.iterator();
            while (it.hasNext()) {
                arrayList.add(instantiate((Class) it.next()));
            }
            return arrayList;
        } catch (ClassNotFoundException unused) {
            return CollectionsKt.emptyList();
        }
    }

    private final Module instantiate(Class<? extends Module> moduleClass) throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        Field field;
        Field[] declaredFields = moduleClass.getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(declaredFields, "getDeclaredFields(...)");
        Field[] fieldArr = declaredFields;
        int length = fieldArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                field = null;
                break;
            }
            field = fieldArr[i];
            Field field2 = field;
            if (Intrinsics.areEqual(field2.getName(), "INSTANCE") && Modifier.isStatic(field2.getModifiers())) {
                break;
            }
            i++;
        }
        Field field3 = field;
        if (field3 != null) {
            field3.setAccessible(true);
            Object obj = field3.get(null);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type io.github.expo.modules.v2.Module");
            return (Module) obj;
        }
        Constructor<? extends Module> declaredConstructor = moduleClass.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        Module moduleNewInstance = declaredConstructor.newInstance(null);
        Intrinsics.checkNotNullExpressionValue(moduleNewInstance, "newInstance(...)");
        return moduleNewInstance;
    }
}
