package expo.modules.kotlin.jni;

import com.facebook.jni.HybridData;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.ModuleHolder;
import expo.modules.kotlin.ModuleRegistry;
import expo.modules.kotlin.classcomponent.ClassDefinitionData;
import expo.modules.kotlin.exception.JavaScriptEvaluateException;
import expo.modules.kotlin.jni.decorators.JSDecoratorsBridgingObject;
import expo.modules.kotlin.runtime.Runtime;
import expo.modules.kotlin.sharedobjects.ClassRegistry;
import expo.modules.kotlin.sharedobjects.SharedObject;
import expo.modules.kotlin.sharedobjects.SharedObjectId;
import expo.modules.kotlin.sharedobjects.SharedObjectRegistry;
import expo.modules.kotlin.types.descriptors.TypeDescriptor;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: JSIContext.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B\u001f\b\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0001¢\u0006\u0002\b\u0012J\n\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0007J\u0011\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0086 J\u0011\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0086 J\t\u0010\u0019\u001a\u00020\u001aH\u0086 J\t\u0010\u001b\u001a\u00020\u001aH\u0086 J\u0011\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001eH\u0086 J\t\u0010\u001f\u001a\u00020\u0010H\u0086 J\u0019\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001aH\u0086 J\t\u0010$\u001a\u00020\u0010H\u0086 J\u0016\u0010%\u001a\b\u0012\u0002\b\u0003\u0018\u00010&2\u0006\u0010'\u001a\u00020\"H\u0007J\u0016\u0010(\u001a\u0004\u0018\u00010)2\n\u0010*\u001a\u0006\u0012\u0002\b\u00030&H\u0007J\u0012\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020\u0017H\u0007J\u0010\u0010.\u001a\u00020/2\u0006\u0010-\u001a\u00020\u0017H\u0007J\u0013\u00100\u001a\b\u0012\u0004\u0012\u00020\u001701H\u0007¢\u0006\u0002\u00102J\u0018\u00103\u001a\u00020\u00102\u0006\u00104\u001a\u0002052\u0006\u0010#\u001a\u00020\u001aH\u0007J\u0012\u00106\u001a\u0004\u0018\u00010\u001a2\u0006\u0010!\u001a\u00020\"H\u0007J\u0010\u00107\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"H\u0007J\u001c\u00108\u001a\u00020\u00102\n\u00104\u001a\u0006\u0012\u0002\b\u00030&2\u0006\u0010#\u001a\u00020\u001aH\u0007J\u0016\u00109\u001a\u0004\u0018\u00010\u001a2\n\u00104\u001a\u0006\u0012\u0002\b\u00030&H\u0007J\b\u0010:\u001a\u00020\u0010H\u0004J\b\u0010;\u001a\u00020\u0010H\u0016J\b\u0010<\u001a\u00020\u0005H\u0016R\u0010\u0010\u0004\u001a\u00020\u00058\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lexpo/modules/kotlin/jni/JSIContext;", "Lexpo/modules/kotlin/jni/Destructible;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "mHybridData", "Lcom/facebook/jni/HybridData;", "runtimeHolder", "Ljava/lang/ref/WeakReference;", "Lexpo/modules/kotlin/runtime/Runtime;", "<init>", "(Lcom/facebook/jni/HybridData;Ljava/lang/ref/WeakReference;)V", "getRuntimeHolder", "()Ljava/lang/ref/WeakReference;", "jsHeapAccessExecutor", "Lexpo/modules/kotlin/jni/JSHeapAccessExecutor;", "setJSHeapAccessExecutor", "", "executor", "setJSHeapAccessExecutor$expo_modules_core_release", "getJSHeapAccessExecutor", "evaluateScript", "Lexpo/modules/kotlin/jni/JavaScriptValue;", "script", "", "evaluateVoidScript", "global", "Lexpo/modules/kotlin/jni/JavaScriptObject;", "createObject", "scheduleOnJSThread", "runnable", "Ljava/lang/Runnable;", "drainJSEventLoop", "setNativeStateForSharedObject", "id", "", "js", "installModuleClasses", "getNativeSharedObjectClass", "Ljava/lang/Class;", "objectId", "buildClassDecorator", "Lexpo/modules/kotlin/jni/decorators/JSDecoratorsBridgingObject;", "nativeClass", "getJavaScriptModuleObject", "Lexpo/modules/kotlin/jni/JavaScriptModuleObject;", "name", "hasModule", "", "getJavaScriptModulesName", "", "()[Ljava/lang/String;", "registerSharedObject", "native", "", "getSharedObject", "deleteSharedObject", "registerClass", "getJavascriptClass", "finalize", "close", "getHybridDataForJNIDeallocator", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class JSIContext implements Destructible, AutoCloseable {
    public static final int $stable = 8;
    private JSHeapAccessExecutor jsHeapAccessExecutor;
    private final HybridData mHybridData;
    private final WeakReference<Runtime> runtimeHolder;

    public final native JavaScriptObject createObject();

    public final native void drainJSEventLoop();

    public final native JavaScriptValue evaluateScript(String script) throws JavaScriptEvaluateException;

    public final native void evaluateVoidScript(String script) throws JavaScriptEvaluateException;

    public final native JavaScriptObject global();

    public final native void installModuleClasses();

    public final native void scheduleOnJSThread(Runnable runnable);

    public final native void setNativeStateForSharedObject(int id, JavaScriptObject js);

    public JSIContext(HybridData mHybridData, WeakReference<Runtime> runtimeHolder) {
        Intrinsics.checkNotNullParameter(mHybridData, "mHybridData");
        Intrinsics.checkNotNullParameter(runtimeHolder, "runtimeHolder");
        this.mHybridData = mHybridData;
        this.runtimeHolder = runtimeHolder;
    }

    public final WeakReference<Runtime> getRuntimeHolder() {
        return this.runtimeHolder;
    }

    public final void setJSHeapAccessExecutor$expo_modules_core_release(JSHeapAccessExecutor executor) {
        this.jsHeapAccessExecutor = executor;
    }

    /* JADX INFO: renamed from: getJSHeapAccessExecutor, reason: from getter */
    public final JSHeapAccessExecutor getJsHeapAccessExecutor() {
        return this.jsHeapAccessExecutor;
    }

    public final Class<?> getNativeSharedObjectClass(int objectId) {
        AppContext appContext;
        SharedObject sharedObjectM11963toNativeObjectOrNullkyJHjyY$expo_modules_core_release;
        Runtime runtime = this.runtimeHolder.get();
        if (runtime == null || (appContext = runtime.getAppContext()) == null || (sharedObjectM11963toNativeObjectOrNullkyJHjyY$expo_modules_core_release = appContext.getRuntime().getSharedObjectRegistry().m11963toNativeObjectOrNullkyJHjyY$expo_modules_core_release(SharedObjectId.m11948constructorimpl(objectId))) == null) {
            return null;
        }
        return sharedObjectM11963toNativeObjectOrNullkyJHjyY$expo_modules_core_release.getClass();
    }

    public final JSDecoratorsBridgingObject buildClassDecorator(Class<?> nativeClass) {
        AppContext appContext;
        Object next;
        TypeDescriptor ownerType;
        Intrinsics.checkNotNullParameter(nativeClass, "nativeClass");
        Runtime runtime = this.runtimeHolder.get();
        if (runtime == null || (appContext = runtime.getAppContext()) == null) {
            return null;
        }
        Iterator it = SequencesKt.flatMapIterable(CollectionsKt.asSequence(appContext.getRegistry()), new Function1() { // from class: expo.modules.kotlin.jni.JSIContext$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return JSIContext.buildClassDecorator$lambda$0((ModuleHolder) obj);
            }
        }).iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            ownerType = ((ClassDefinitionData) next).getConstructor().getOwnerType();
        } while (!Intrinsics.areEqual(ownerType != null ? ownerType.getTypeInfo().getJClass() : null, nativeClass));
        ClassDefinitionData classDefinitionData = (ClassDefinitionData) next;
        if (classDefinitionData == null) {
            return null;
        }
        JSDecoratorsBridgingObject jSDecoratorsBridgingObject = new JSDecoratorsBridgingObject(runtime.getDeallocator());
        jSDecoratorsBridgingObject.exportClass(classDefinitionData, appContext, runtime);
        return jSDecoratorsBridgingObject;
    }

    static final Iterable buildClassDecorator$lambda$0(ModuleHolder it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getDefinition().getClassData();
    }

    public final JavaScriptModuleObject getJavaScriptModuleObject(String name) {
        AppContext appContext;
        ModuleRegistry registry;
        ModuleHolder<?> moduleHolder;
        Intrinsics.checkNotNullParameter(name, "name");
        Runtime runtime = this.runtimeHolder.get();
        if (runtime == null || (appContext = runtime.getAppContext()) == null || (registry = appContext.getRegistry()) == null || (moduleHolder = registry.getModuleHolder(name)) == null) {
            return null;
        }
        return moduleHolder.getJsObject();
    }

    public final boolean hasModule(String name) {
        AppContext appContext;
        ModuleRegistry registry;
        Intrinsics.checkNotNullParameter(name, "name");
        Runtime runtime = this.runtimeHolder.get();
        if (runtime == null || (appContext = runtime.getAppContext()) == null || (registry = appContext.getRegistry()) == null) {
            return false;
        }
        return registry.hasModule(name);
    }

    public final String[] getJavaScriptModulesName() {
        AppContext appContext;
        ModuleRegistry registry;
        Map<String, ModuleHolder<?>> registry2;
        Set<String> setKeySet;
        String[] strArr;
        Runtime runtime = this.runtimeHolder.get();
        return (runtime == null || (appContext = runtime.getAppContext()) == null || (registry = appContext.getRegistry()) == null || (registry2 = registry.getRegistry()) == null || (setKeySet = registry2.keySet()) == null || (strArr = (String[]) setKeySet.toArray(new String[0])) == null) ? new String[0] : strArr;
    }

    public final void registerSharedObject(Object obj, JavaScriptObject js) {
        SharedObjectRegistry sharedObjectRegistry;
        Intrinsics.checkNotNullParameter(obj, "native");
        Intrinsics.checkNotNullParameter(js, "js");
        Runtime runtime = this.runtimeHolder.get();
        if (runtime == null || (sharedObjectRegistry = runtime.getSharedObjectRegistry()) == null) {
            return;
        }
        SharedObjectId.m11947boximpl(sharedObjectRegistry.m11960add5WKnsLU$expo_modules_core_release((SharedObject) obj, js));
    }

    public final JavaScriptObject getSharedObject(int id) {
        Runtime runtime = this.runtimeHolder.get();
        if (runtime == null) {
            return null;
        }
        return SharedObjectId.m11952toJavaScriptObjectNullimpl(SharedObjectId.m11948constructorimpl(id), runtime);
    }

    public final void deleteSharedObject(int id) {
        SharedObjectRegistry sharedObjectRegistry;
        Runtime runtime = this.runtimeHolder.get();
        if (runtime == null || (sharedObjectRegistry = runtime.getSharedObjectRegistry()) == null) {
            return;
        }
        sharedObjectRegistry.m11961deletekyJHjyY$expo_modules_core_release(SharedObjectId.m11948constructorimpl(id));
    }

    public final void registerClass(Class<?> cls, JavaScriptObject js) {
        ClassRegistry classRegistry;
        Intrinsics.checkNotNullParameter(cls, "native");
        Intrinsics.checkNotNullParameter(js, "js");
        Runtime runtime = this.runtimeHolder.get();
        if (runtime == null || (classRegistry = runtime.getClassRegistry()) == null) {
            return;
        }
        classRegistry.add$expo_modules_core_release(cls, js);
    }

    public final JavaScriptObject getJavascriptClass(Class<?> cls) {
        ClassRegistry classRegistry;
        Intrinsics.checkNotNullParameter(cls, "native");
        Runtime runtime = this.runtimeHolder.get();
        if (runtime == null || (classRegistry = runtime.getClassRegistry()) == null) {
            return null;
        }
        return classRegistry.toJavaScriptObject$expo_modules_core_release(cls);
    }

    protected final void finalize() throws Throwable {
        close();
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        JSHeapAccessExecutor jSHeapAccessExecutor = this.jsHeapAccessExecutor;
        if (jSHeapAccessExecutor != null) {
            jSHeapAccessExecutor.invalidate();
        }
        this.jsHeapAccessExecutor = null;
        this.mHybridData.resetNative();
    }

    @Override // expo.modules.kotlin.jni.Destructible
    /* JADX INFO: renamed from: getHybridDataForJNIDeallocator, reason: from getter */
    public HybridData getMHybridData() {
        return this.mHybridData;
    }
}
