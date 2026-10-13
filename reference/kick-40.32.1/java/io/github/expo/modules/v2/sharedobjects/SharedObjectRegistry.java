package io.github.expo.modules.v2.sharedobjects;

import io.github.expo.kolibri.binary.BinaryBuffer;
import io.github.expo.modules.v2.ExpoContext;
import io.github.expo.modules.v2.SharedObject;
import io.github.expo.modules.v2.SharedRef;
import io.github.expo.modules.v2.binary.BinaryBufferExtensionKt;
import io.github.expo.modules.v2.binary.ModuleDescriptorEncoder;
import io.github.expo.modules.v2.cache.MultiKeyCache;
import io.github.expo.modules.v2.events.Event;
import io.github.expo.modules.v2.jni.ClassExtensionsKt;
import io.github.expo.modules.v2.jsi.JavaScriptRuntime;
import io.github.expo.modules.v2.loader.ExpoClassLoader;
import io.github.expo.modules.v2.modules.ModuleBuilder;
import io.github.expo.modules.v2.types.AnyType;
import io.github.expo.modules.v2.types.TypeDescriptor;
import java.nio.BufferOverflowException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SharedObjectRegistry.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001)B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u000b\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\u0006H\u0007J(\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J9\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\u00062\u0019\b\u0002\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0002\b\u0017J\u0016\u0010\u0018\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\u0006\u0010\u0019\u001a\u00020\fH\u0007J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0019\u001a\u00020\fH\u0007J\u001f\u0010\u001b\u001a\u00020\u00072\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\u0006H\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001e\u001a\u0004\u0018\u00010\b2\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\u0006H\u0000¢\u0006\u0002\b\u001fJ\u0018\u0010 \u001a\u00020\b2\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\u0006H\u0002J\u001c\u0010!\u001a\u00060\"j\u0002`#2\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\u0006H\u0002J\u001c\u0010$\u001a\u00020\u0013*\u00020\u00132\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\u0006H\u0002J\u0010\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020\u000eH\u0007J\u0010\u0010'\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u000eH\u0007J\u0012\u0010(\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0019\u001a\u00020\fH\u0007R$\u0010\u0004\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00020\u00070\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lio/github/expo/modules/v2/sharedobjects/SharedObjectRegistry;", "", "<init>", "()V", "classes", "Lio/github/expo/modules/v2/cache/MultiKeyCache;", "Ljava/lang/Class;", "Lio/github/expo/modules/v2/sharedobjects/SharedClassId;", "Lio/github/expo/modules/v2/sharedobjects/SharedObjectRegistry$ClassEntry;", "reservedIds", "Ljava/util/concurrent/ConcurrentHashMap;", "reserve", "", "sharedClass", "Lio/github/expo/modules/v2/SharedObject;", "register", "jsName", "", "definition", "Lio/github/expo/modules/v2/modules/ModuleBuilder;", "build", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "sharedClassOf", "classId", "classDescriptorOf", "classIdFor", "classIdFor-t-OptiM$react_release", "(Ljava/lang/Class;)I", "entryOrNull", "entryOrNull$react_release", "entryFor", "notRegistered", "Ljava/lang/IllegalArgumentException;", "Lkotlin/IllegalArgumentException;", "alsoDeclaringRefType", "classIdOf", "instance", "release", "encodeClass", "ClassEntry", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SharedObjectRegistry {
    public static final SharedObjectRegistry INSTANCE;
    private static final MultiKeyCache<Class<?>, SharedClassId, ClassEntry> classes;
    private static final ConcurrentHashMap<Class<?>, SharedClassId> reservedIds;

    /* JADX INFO: compiled from: SharedObjectRegistry.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lio/github/expo/modules/v2/sharedobjects/SharedObjectRegistry$ClassEntry;", "", "id", "Lio/github/expo/modules/v2/sharedobjects/SharedClassId;", "sharedClass", "Ljava/lang/Class;", "Lio/github/expo/modules/v2/SharedObject;", "jsName", "", "definition", "Lio/github/expo/modules/v2/modules/ModuleBuilder;", "<init>", "(ILjava/lang/Class;Ljava/lang/String;Lio/github/expo/modules/v2/modules/ModuleBuilder;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getId-OgimwPA", "()I", "I", "getSharedClass", "()Ljava/lang/Class;", "getJsName", "()Ljava/lang/String;", "getDefinition", "()Lio/github/expo/modules/v2/modules/ModuleBuilder;", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class ClassEntry {
        private final ModuleBuilder definition;
        private final int id;
        private final String jsName;
        private final Class<? extends SharedObject> sharedClass;

        public /* synthetic */ ClassEntry(int i, Class cls, String str, ModuleBuilder moduleBuilder, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, cls, str, moduleBuilder);
        }

        private ClassEntry(int i, Class<? extends SharedObject> sharedClass, String jsName, ModuleBuilder definition) {
            Intrinsics.checkNotNullParameter(sharedClass, "sharedClass");
            Intrinsics.checkNotNullParameter(jsName, "jsName");
            Intrinsics.checkNotNullParameter(definition, "definition");
            this.id = i;
            this.sharedClass = sharedClass;
            this.jsName = jsName;
            this.definition = definition;
        }

        /* JADX INFO: renamed from: getId-OgimwPA, reason: not valid java name and from getter */
        public final int getId() {
            return this.id;
        }

        public final Class<? extends SharedObject> getSharedClass() {
            return this.sharedClass;
        }

        public final String getJsName() {
            return this.jsName;
        }

        public final ModuleBuilder getDefinition() {
            return this.definition;
        }
    }

    private SharedObjectRegistry() {
    }

    static {
        SharedObjectRegistry sharedObjectRegistry = new SharedObjectRegistry();
        INSTANCE = sharedObjectRegistry;
        classes = new MultiKeyCache<>();
        reservedIds = new ConcurrentHashMap<>();
        register$default(sharedObjectRegistry, "SharedRef", SharedRef.class, null, 4, null);
    }

    @JvmStatic
    public static final int reserve(Class<? extends SharedObject> sharedClass) {
        Intrinsics.checkNotNullParameter(sharedClass, "sharedClass");
        ClassEntry key1 = classes.getKey1(sharedClass);
        if (key1 != null) {
            return key1.getId();
        }
        ConcurrentHashMap<Class<?>, SharedClassId> concurrentHashMap = reservedIds;
        final Function1 function1 = new Function1() { // from class: io.github.expo.modules.v2.sharedobjects.SharedObjectRegistry$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SharedObjectRegistry.reserve$lambda$1((Class) obj);
            }
        };
        return concurrentHashMap.computeIfAbsent(sharedClass, new Function() { // from class: io.github.expo.modules.v2.sharedobjects.SharedObjectRegistry$$ExternalSyntheticLambda2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return SharedObjectRegistry.reserve$lambda$2(function1, obj);
            }
        }).m12399unboximpl();
    }

    static final SharedClassId reserve$lambda$1(Class it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return SharedClassId.m12392boximpl(SharedClassId.INSTANCE.m12400nextOgimwPA());
    }

    static final SharedClassId reserve$lambda$2(Function1 function1, Object obj) {
        return (SharedClassId) function1.invoke(obj);
    }

    @JvmStatic
    public static final int register(String jsName, Class<? extends SharedObject> sharedClass, ModuleBuilder definition) {
        Intrinsics.checkNotNullParameter(jsName, "jsName");
        Intrinsics.checkNotNullParameter(sharedClass, "sharedClass");
        Intrinsics.checkNotNullParameter(definition, "definition");
        MultiKeyCache<Class<?>, SharedClassId, ClassEntry> multiKeyCache = classes;
        ClassEntry key1 = multiKeyCache.getKey1(sharedClass);
        if (key1 != null) {
            return key1.getId();
        }
        INSTANCE.alsoDeclaringRefType(definition, sharedClass);
        ClassEntry classEntry = new ClassEntry(SharedClassId.m12393constructorimpl(reserve(sharedClass)), sharedClass, jsName, definition, null);
        multiKeyCache.put(sharedClass, SharedClassId.m12392boximpl(classEntry.getId()), classEntry);
        reservedIds.remove(sharedClass);
        return classEntry.getId();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ int register$default(SharedObjectRegistry sharedObjectRegistry, String str, Class cls, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = new Function1() { // from class: io.github.expo.modules.v2.sharedobjects.SharedObjectRegistry$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return SharedObjectRegistry.register$lambda$4((ModuleBuilder) obj2);
                }
            };
        }
        return sharedObjectRegistry.register(str, (Class<? extends SharedObject>) cls, (Function1<? super ModuleBuilder, Unit>) function1);
    }

    static final Unit register$lambda$4(ModuleBuilder moduleBuilder) {
        Intrinsics.checkNotNullParameter(moduleBuilder, "<this>");
        return Unit.INSTANCE;
    }

    public final int register(String jsName, Class<? extends SharedObject> sharedClass, Function1<? super ModuleBuilder, Unit> build) {
        Intrinsics.checkNotNullParameter(jsName, "jsName");
        Intrinsics.checkNotNullParameter(sharedClass, "sharedClass");
        Intrinsics.checkNotNullParameter(build, "build");
        ModuleBuilder moduleBuilder = new ModuleBuilder();
        build.invoke(moduleBuilder);
        return register(jsName, sharedClass, moduleBuilder);
    }

    @JvmStatic
    public static final Class<?> sharedClassOf(int classId) {
        ClassEntry key2 = classes.getKey2(SharedClassId.m12392boximpl(SharedClassId.m12393constructorimpl(classId)));
        if (key2 != null) {
            return key2.getSharedClass();
        }
        return null;
    }

    @JvmStatic
    public static final String classDescriptorOf(int classId) {
        Class<?> clsSharedClassOf = sharedClassOf(classId);
        if (clsSharedClassOf != null) {
            return ClassExtensionsKt.getJniDescriptor(clsSharedClassOf);
        }
        return null;
    }

    /* JADX INFO: renamed from: classIdFor-t-OptiM$react_release, reason: not valid java name */
    public final int m12401classIdFortOptiM$react_release(Class<? extends SharedObject> sharedClass) {
        Intrinsics.checkNotNullParameter(sharedClass, "sharedClass");
        ClassEntry classEntryEntryOrNull$react_release = entryOrNull$react_release(sharedClass);
        if (classEntryEntryOrNull$react_release != null) {
            return classEntryEntryOrNull$react_release.getId();
        }
        SharedClassId sharedClassId = reservedIds.get(sharedClass);
        if (sharedClassId != null) {
            return sharedClassId.m12399unboximpl();
        }
        throw notRegistered(sharedClass);
    }

    public final ClassEntry entryOrNull$react_release(Class<? extends SharedObject> sharedClass) {
        Intrinsics.checkNotNullParameter(sharedClass, "sharedClass");
        MultiKeyCache<Class<?>, SharedClassId, ClassEntry> multiKeyCache = classes;
        ClassEntry key1 = multiKeyCache.getKey1(sharedClass);
        if (key1 != null) {
            return key1;
        }
        ExpoClassLoader.INSTANCE.loadAndInitializeClass(sharedClass);
        return multiKeyCache.getKey1(sharedClass);
    }

    private final ClassEntry entryFor(Class<? extends SharedObject> sharedClass) {
        ClassEntry classEntryEntryOrNull$react_release = entryOrNull$react_release(sharedClass);
        if (classEntryEntryOrNull$react_release != null) {
            return classEntryEntryOrNull$react_release;
        }
        throw notRegistered(sharedClass);
    }

    private final IllegalArgumentException notRegistered(Class<? extends SharedObject> sharedClass) {
        return new IllegalArgumentException(sharedClass.getName() + " is not annotated with @JS, so it declares no exports - annotate it, or describe it with SharedObjectRegistry.register(name, " + sharedClass.getSimpleName() + "::class.java) { ... } before anything names it");
    }

    private final ModuleBuilder alsoDeclaringRefType(ModuleBuilder moduleBuilder, Class<? extends SharedObject> cls) {
        if (!SharedRef.class.isAssignableFrom(cls)) {
            return moduleBuilder;
        }
        ModuleBuilder.property$default(moduleBuilder, "nativeRefType", new AnyType(new TypeDescriptor.Simple(String.class, false), false, 2, null), false, null, null, false, 60, null);
        return moduleBuilder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final int classIdOf(SharedObject instance) {
        ExpoContext context;
        Intrinsics.checkNotNullParameter(instance, "instance");
        JavaScriptRuntime current = JavaScriptRuntime.INSTANCE.getCurrent();
        if (current != null && (context = current.getContext()) != null) {
            instance.bindContext$react_release(context);
        }
        return INSTANCE.entryFor(instance.getClass()).getId();
    }

    @JvmStatic
    public static final void release(SharedObject instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        ArrayList<Event<?>> arrayList = instance.events;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                ((Event) it.next()).detachAll$react_release();
            }
        }
        instance.sharedObjectDidRelease();
    }

    @JvmStatic
    public static final String encodeClass(int classId) {
        ClassEntry key2 = classes.getKey2(SharedClassId.m12392boximpl(SharedClassId.m12393constructorimpl(classId)));
        if (key2 == null) {
            return null;
        }
        try {
            ModuleDescriptorEncoder.m12324encode18NA9x0$default(ModuleDescriptorEncoder.INSTANCE, BinaryBufferExtensionKt.newSharedView$default(BinaryBuffer.INSTANCE, 0, 1, null), key2.getDefinition().getFunctions$react_release(), key2.getDefinition().getProperties$react_release(), null, key2.getDefinition().getEvents$react_release(), 8, null);
            return key2.getJsName();
        } catch (BufferOverflowException e) {
            throw new IllegalArgumentException("Shared object class '" + key2.getJsName() + "' metadata does not fit in the fixed bridge buffer", e);
        }
    }
}
