package io.github.expo.modules.v2.modules;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import io.github.expo.kolibri.binary.BinaryBuffer;
import io.github.expo.modules.v2.ExpoContext;
import io.github.expo.modules.v2.Module;
import io.github.expo.modules.v2.binary.BinaryBufferExtensionKt;
import io.github.expo.modules.v2.binary.ModuleDescriptorEncoder;
import io.github.expo.modules.v2.core.ExpoModulesV2;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ModuleRegistry.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 !2\u00020\u0001:\u0002 !B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J/\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\f0\u0011¢\u0006\u0002\b\u0013J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0014H\u0000¢\u0006\u0002\b\u0015J)\u0010\u000e\u001a\u0004\u0018\u0001H\u0016\"\b\b\u0000\u0010\u0016*\u00020\u000f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0018H\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ \u0010\u001b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u0012H\u0002J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u00012\u0006\u0010\r\u001a\u00020\bH\u0003J\b\u0010\u001e\u001a\u00020\u001fH\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lio/github/expo/modules/v2/modules/ModuleRegistry;", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lio/github/expo/modules/v2/ExpoContext;", "<init>", "(Lio/github/expo/modules/v2/ExpoContext;)V", "modules", "Ljava/util/LinkedHashMap;", "", "Lio/github/expo/modules/v2/modules/ModuleRegistry$Entry;", "Lkotlin/collections/LinkedHashMap;", "register", "", "name", "module", "Lio/github/expo/modules/v2/Module;", "build", "Lkotlin/Function1;", "Lio/github/expo/modules/v2/modules/ModuleBuilder;", "Lkotlin/ExtensionFunctionType;", "", "modules$react_release", ExifInterface.GPS_DIRECTION_TRUE, "type", "Ljava/lang/Class;", "module$react_release", "(Ljava/lang/Class;)Lio/github/expo/modules/v2/Module;", "add", "definition", "encodeModule", "encodeModuleNames", "", "Entry", "Companion", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ModuleRegistry {
    private final ExpoContext context;
    private final LinkedHashMap<String, Entry> modules;

    /* JADX INFO: compiled from: ModuleRegistry.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005¢\u0006\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012¨\u0006\u0016"}, d2 = {"Lio/github/expo/modules/v2/modules/ModuleRegistry$Entry;", "", "module", "Lio/github/expo/modules/v2/Module;", "functions", "", "Lio/github/expo/modules/v2/modules/ModuleFunctionDefinition;", "properties", "Lio/github/expo/modules/v2/modules/ModulePropertyDefinition;", "sharedClasses", "Lio/github/expo/modules/v2/modules/ModuleSharedClassDefinition;", "events", "Lio/github/expo/modules/v2/modules/ModuleEventDefinition;", "<init>", "(Lio/github/expo/modules/v2/Module;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getModule", "()Lio/github/expo/modules/v2/Module;", "getFunctions", "()Ljava/util/List;", "getProperties", "getSharedClasses", "getEvents", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Entry {
        private final List<ModuleEventDefinition> events;
        private final List<ModuleFunctionDefinition> functions;
        private final Module module;
        private final List<ModulePropertyDefinition> properties;
        private final List<ModuleSharedClassDefinition> sharedClasses;

        public Entry(Module module, List<ModuleFunctionDefinition> functions, List<ModulePropertyDefinition> properties, List<ModuleSharedClassDefinition> sharedClasses, List<ModuleEventDefinition> events) {
            Intrinsics.checkNotNullParameter(module, "module");
            Intrinsics.checkNotNullParameter(functions, "functions");
            Intrinsics.checkNotNullParameter(properties, "properties");
            Intrinsics.checkNotNullParameter(sharedClasses, "sharedClasses");
            Intrinsics.checkNotNullParameter(events, "events");
            this.module = module;
            this.functions = functions;
            this.properties = properties;
            this.sharedClasses = sharedClasses;
            this.events = events;
        }

        public final Module getModule() {
            return this.module;
        }

        public final List<ModuleFunctionDefinition> getFunctions() {
            return this.functions;
        }

        public final List<ModulePropertyDefinition> getProperties() {
            return this.properties;
        }

        public final List<ModuleSharedClassDefinition> getSharedClasses() {
            return this.sharedClasses;
        }

        public final List<ModuleEventDefinition> getEvents() {
            return this.events;
        }
    }

    public ModuleRegistry(ExpoContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.modules = new LinkedHashMap<>();
    }

    public final void register(String name, Module module, Function1<? super ModuleBuilder, Unit> build) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(build, "build");
        ModuleBuilder moduleBuilder = new ModuleBuilder();
        build.invoke(moduleBuilder);
        add(name, module, moduleBuilder);
    }

    public final void register(Module module) {
        Intrinsics.checkNotNullParameter(module, "module");
        ModuleBuilder moduleBuilder = new ModuleBuilder();
        String strDefine$ExpoModulesV2 = module.define$ExpoModulesV2(moduleBuilder);
        if (strDefine$ExpoModulesV2 == null) {
            throw new IllegalArgumentException((module.getClass().getName() + " is not annotated with @JS, so it declares no exports — annotate it, or register it with register(name, module) { ... }").toString());
        }
        add(strDefine$ExpoModulesV2, module, moduleBuilder);
    }

    public final List<Module> modules$react_release() {
        ArrayList arrayList;
        synchronized (this.modules) {
            Collection<Entry> collectionValues = this.modules.values();
            Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
            Collection<Entry> collection = collectionValues;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection, 10));
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                arrayList2.add(((Entry) it.next()).getModule());
            }
            arrayList = arrayList2;
        }
        return arrayList;
    }

    public final <T extends Module> T module$react_release(Class<T> type) {
        Object next;
        Module module;
        Intrinsics.checkNotNullParameter(type, "type");
        synchronized (this.modules) {
            Collection<Entry> collectionValues = this.modules.values();
            Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
            Iterator<T> it = collectionValues.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!type.isInstance(((Entry) next).getModule()));
            Entry entry = (Entry) next;
            module = entry != null ? entry.getModule() : null;
        }
        if (module != null) {
            return type.cast(module);
        }
        return null;
    }

    private final void add(String name, Module module, ModuleBuilder definition) {
        synchronized (this.modules) {
            if (this.modules.containsKey(name)) {
                throw new IllegalArgumentException(("Module '" + name + "' is already registered").toString());
            }
            module.bindContext$react_release(this.context);
            this.modules.put(name, new Entry(module, definition.getFunctions$react_release(), definition.getProperties$react_release(), definition.getSharedClasses$react_release(), definition.getEvents$react_release()));
            Unit unit = Unit.INSTANCE;
        }
    }

    private final Object encodeModule(String name) {
        Entry entry;
        synchronized (this.modules) {
            entry = this.modules.get(name);
        }
        if (entry == null) {
            return null;
        }
        try {
            ModuleDescriptorEncoder.INSTANCE.m12330encode18NA9x0(BinaryBufferExtensionKt.newSharedView$default(BinaryBuffer.INSTANCE, 0, 1, null), entry.getFunctions(), entry.getProperties(), entry.getSharedClasses(), entry.getEvents());
            return entry.getModule();
        } catch (BufferOverflowException e) {
            throw new IllegalArgumentException("Module '" + name + "' registration metadata does not fit in the fixed bridge buffer", e);
        }
    }

    private final int encodeModuleNames() {
        List list;
        ByteBuffer byteBufferNewSharedView$default = BinaryBufferExtensionKt.newSharedView$default(BinaryBuffer.INSTANCE, 0, 1, null);
        try {
            synchronized (this.modules) {
                Set<String> setKeySet = this.modules.keySet();
                Intrinsics.checkNotNullExpressionValue(setKeySet, "<get-keys>(...)");
                list = CollectionsKt.toList(setKeySet);
            }
            BinaryBuffer.m12294putStringCollectionWPjWIpM(byteBufferNewSharedView$default, list);
            return BinaryBuffer.m12269getPositionimpl(byteBufferNewSharedView$default);
        } catch (BufferOverflowException e) {
            throw new IllegalArgumentException("The registered module names do not fit in the fixed bridge buffer", e);
        }
    }

    static {
        ExpoModulesV2.INSTANCE.load();
    }
}
