package io.github.expo.modules.v2.modules;

import io.github.expo.modules.v2.SharedObject;
import io.github.expo.modules.v2.sharedobjects.SharedObjectRegistry;
import io.github.expo.modules.v2.types.AnyType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ModuleBuilder.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 .2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JC\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u0017\"\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001c¢\u0006\u0002\u0010\u001dJ>\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00182\b\b\u0002\u0010 \u001a\u00020\u001c2\b\b\u0002\u0010!\u001a\u00020\u00152\b\b\u0002\u0010\"\u001a\u00020\u00182\b\b\u0002\u0010#\u001a\u00020\u001cJ?\u0010$\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u000e\u0010$\u001a\n\u0012\u0006\b\u0001\u0012\u00020&0%2\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u0017\"\u00020\u00182\u0006\u0010'\u001a\u00020\u0015¢\u0006\u0002\u0010(J\u0016\u0010)\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u0018J\u0010\u0010*\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\u0015H\u0002J\u0010\u0010,\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u0015H\u0002J\f\u0010-\u001a\u00020\u0015*\u00020\u0015H\u0002R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\b¨\u0006/"}, d2 = {"Lio/github/expo/modules/v2/modules/ModuleBuilder;", "", "<init>", "()V", "functions", "", "Lio/github/expo/modules/v2/modules/ModuleFunctionDefinition;", "getFunctions$react_release", "()Ljava/util/List;", "properties", "Lio/github/expo/modules/v2/modules/ModulePropertyDefinition;", "getProperties$react_release", "sharedClasses", "Lio/github/expo/modules/v2/modules/ModuleSharedClassDefinition;", "getSharedClasses$react_release", "events", "Lio/github/expo/modules/v2/modules/ModuleEventDefinition;", "getEvents$react_release", "function", "", "jsName", "", "argTypes", "", "Lio/github/expo/modules/v2/types/AnyType;", "returns", "methodName", "isAsync", "", "(Ljava/lang/String;[Lio/github/expo/modules/v2/types/AnyType;Lio/github/expo/modules/v2/types/AnyType;Ljava/lang/String;Z)V", "property", "type", "mutable", "propertyName", "setterType", "constant", "sharedClass", "Ljava/lang/Class;", "Lio/github/expo/modules/v2/SharedObject;", "trampolineName", "(Ljava/lang/String;Ljava/lang/Class;[Lio/github/expo/modules/v2/types/AnyType;Ljava/lang/String;)V", "event", "requireAvailableExportName", "name", "hasIsPrefix", "accessorSuffix", "Companion", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ModuleBuilder {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Set<String> RESERVED_EXPORT_NAMES = SetsKt.setOf((Object[]) new String[]{"addListener", "removeListener", "removeAllListeners", "listenerCount", "emit"});
    private final List<ModuleFunctionDefinition> functions = new ArrayList();
    private final List<ModulePropertyDefinition> properties = new ArrayList();
    private final List<ModuleSharedClassDefinition> sharedClasses = new ArrayList();
    private final List<ModuleEventDefinition> events = new ArrayList();

    public final List<ModuleFunctionDefinition> getFunctions$react_release() {
        return this.functions;
    }

    public final List<ModulePropertyDefinition> getProperties$react_release() {
        return this.properties;
    }

    public final List<ModuleSharedClassDefinition> getSharedClasses$react_release() {
        return this.sharedClasses;
    }

    public final List<ModuleEventDefinition> getEvents$react_release() {
        return this.events;
    }

    public static /* synthetic */ void function$default(ModuleBuilder moduleBuilder, String str, AnyType[] anyTypeArr, AnyType anyType, String str2, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            str2 = str;
        }
        if ((i & 16) != 0) {
            z = false;
        }
        moduleBuilder.function(str, anyTypeArr, anyType, str2, z);
    }

    public final void function(String jsName, AnyType[] argTypes, AnyType returns, String methodName, boolean isAsync) {
        Intrinsics.checkNotNullParameter(jsName, "jsName");
        Intrinsics.checkNotNullParameter(argTypes, "argTypes");
        Intrinsics.checkNotNullParameter(returns, "returns");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        if (argTypes.length > 8) {
            throw new IllegalArgumentException(("Function '" + jsName + "' declares " + argTypes.length + " arguments; at most 8 are supported").toString());
        }
        requireAvailableExportName(jsName);
        List<ModuleFunctionDefinition> list = this.functions;
        int length = argTypes.length;
        int[][] iArr = new int[length][];
        for (int i = 0; i < length; i++) {
            iArr[i] = argTypes[i].m12403getCodespj4Pta4();
        }
        list.add(new ModuleFunctionDefinition(jsName, methodName, iArr, returns.m12403getCodespj4Pta4(), isAsync));
    }

    public static /* synthetic */ void property$default(ModuleBuilder moduleBuilder, String str, AnyType anyType, boolean z, String str2, AnyType anyType2, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            str2 = str;
        }
        if ((i & 16) != 0) {
            anyType2 = anyType;
        }
        if ((i & 32) != 0) {
            z2 = false;
        }
        moduleBuilder.property(str, anyType, z, str2, anyType2, z2);
    }

    public final void property(String jsName, AnyType type, boolean mutable, String propertyName, AnyType setterType, boolean constant) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(jsName, "jsName");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(propertyName, "propertyName");
        Intrinsics.checkNotNullParameter(setterType, "setterType");
        requireAvailableExportName(jsName);
        if (hasIsPrefix(propertyName)) {
            str = propertyName;
        } else {
            str = "get" + accessorSuffix(propertyName);
        }
        if (!mutable) {
            str2 = null;
        } else if (hasIsPrefix(propertyName)) {
            String strSubstring = propertyName.substring(2);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            str2 = "set" + strSubstring;
        } else {
            str2 = "set" + accessorSuffix(propertyName);
        }
        this.properties.add(new ModulePropertyDefinition(jsName, str, str2, type.m12403getCodespj4Pta4(), str2 != null ? setterType.m12403getCodespj4Pta4() : null, constant));
    }

    public final void sharedClass(String jsName, Class<? extends SharedObject> sharedClass, AnyType[] argTypes, String trampolineName) {
        Intrinsics.checkNotNullParameter(jsName, "jsName");
        Intrinsics.checkNotNullParameter(sharedClass, "sharedClass");
        Intrinsics.checkNotNullParameter(argTypes, "argTypes");
        Intrinsics.checkNotNullParameter(trampolineName, "trampolineName");
        if (argTypes.length > 8) {
            throw new IllegalArgumentException(("Constructor of '" + jsName + "' declares " + argTypes.length + " arguments; at most 8 are supported").toString());
        }
        requireAvailableExportName(jsName);
        List<ModuleSharedClassDefinition> list = this.sharedClasses;
        int iM12401classIdFortOptiM$react_release = SharedObjectRegistry.INSTANCE.m12401classIdFortOptiM$react_release(sharedClass);
        int length = argTypes.length;
        int[][] iArr = new int[length][];
        for (int i = 0; i < length; i++) {
            iArr[i] = argTypes[i].m12403getCodespj4Pta4();
        }
        list.add(new ModuleSharedClassDefinition(jsName, iM12401classIdFortOptiM$react_release, iArr, trampolineName));
    }

    public final void event(String jsName, AnyType type) {
        Intrinsics.checkNotNullParameter(jsName, "jsName");
        Intrinsics.checkNotNullParameter(type, "type");
        requireAvailableExportName(jsName);
        this.events.add(new ModuleEventDefinition(jsName, type.m12403getCodespj4Pta4()));
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0049  */
    /* JADX WARN: Code duplicated, block: B:23:0x0053  */
    /* JADX WARN: Code duplicated, block: B:28:0x006c  */
    /* JADX WARN: Code duplicated, block: B:31:0x0076  */
    /* JADX WARN: Code duplicated, block: B:34:0x0080  */
    /* JADX WARN: Code duplicated, block: B:39:0x0099  */
    /* JADX WARN: Code duplicated, block: B:45:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:54:0x00be A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:55:? A[LOOP:0: B:43:0x00a7->B:55:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:57:0x00be A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:58:? A[LOOP:1: B:32:0x007a->B:58:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:0x00be A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:61:? A[LOOP:2: B:21:0x004d->B:61:?, LOOP_END, SYNTHETIC] */
    private final void requireAvailableExportName(String name) {
        List<ModulePropertyDefinition> list;
        Iterator<T> it;
        List<ModuleSharedClassDefinition> list2;
        Iterator<T> it2;
        List<ModuleEventDefinition> list3;
        Iterator<T> it3;
        Set<String> set = RESERVED_EXPORT_NAMES;
        if (set.contains(name)) {
            throw new IllegalArgumentException(("Export '" + name + "' is reserved: every module and shared object carries the event emitter members " + CollectionsKt.joinToString$default(set, null, null, null, 0, null, null, 63, null)).toString());
        }
        List<ModuleFunctionDefinition> list4 = this.functions;
        if ((list4 instanceof Collection) && list4.isEmpty()) {
            list = this.properties;
            if (!(list instanceof Collection)) {
                it = list.iterator();
                while (it.hasNext()) {
                    if (!Intrinsics.areEqual(((ModulePropertyDefinition) it.next()).getJsName(), name)) {
                    }
                }
                list2 = this.sharedClasses;
                if (!(list2 instanceof Collection)) {
                    it2 = list2.iterator();
                    while (it2.hasNext()) {
                        if (!Intrinsics.areEqual(((ModuleSharedClassDefinition) it2.next()).getJsName(), name)) {
                        }
                    }
                    list3 = this.events;
                    if (list3 instanceof Collection) {
                    }
                    it3 = list3.iterator();
                    while (it3.hasNext()) {
                        if (!Intrinsics.areEqual(((ModuleEventDefinition) it3.next()).getJsName(), name)) {
                        }
                    }
                    return;
                }
                it2 = list2.iterator();
                while (it2.hasNext()) {
                    if (!Intrinsics.areEqual(((ModuleSharedClassDefinition) it2.next()).getJsName(), name)) {
                    }
                }
                list3 = this.events;
                if (list3 instanceof Collection) {
                }
                it3 = list3.iterator();
                while (it3.hasNext()) {
                    if (!Intrinsics.areEqual(((ModuleEventDefinition) it3.next()).getJsName(), name)) {
                    }
                }
                return;
            }
            it = list.iterator();
            while (it.hasNext()) {
                if (!Intrinsics.areEqual(((ModulePropertyDefinition) it.next()).getJsName(), name)) {
                }
            }
            list2 = this.sharedClasses;
            if (!(list2 instanceof Collection)) {
                it2 = list2.iterator();
                while (it2.hasNext()) {
                    if (!Intrinsics.areEqual(((ModuleSharedClassDefinition) it2.next()).getJsName(), name)) {
                    }
                }
                list3 = this.events;
                if (list3 instanceof Collection) {
                }
                it3 = list3.iterator();
                while (it3.hasNext()) {
                    if (!Intrinsics.areEqual(((ModuleEventDefinition) it3.next()).getJsName(), name)) {
                    }
                }
                return;
            }
            it2 = list2.iterator();
            while (it2.hasNext()) {
                if (!Intrinsics.areEqual(((ModuleSharedClassDefinition) it2.next()).getJsName(), name)) {
                }
            }
            list3 = this.events;
            if (list3 instanceof Collection) {
            }
            it3 = list3.iterator();
            while (it3.hasNext()) {
                if (!Intrinsics.areEqual(((ModuleEventDefinition) it3.next()).getJsName(), name)) {
                }
            }
            return;
        }
        Iterator<T> it4 = list4.iterator();
        while (it4.hasNext()) {
            if (!Intrinsics.areEqual(((ModuleFunctionDefinition) it4.next()).getJsName(), name)) {
            }
        }
        list = this.properties;
        if (!(list instanceof Collection) && list.isEmpty()) {
            list2 = this.sharedClasses;
            if (!(list2 instanceof Collection)) {
                it2 = list2.iterator();
                while (it2.hasNext()) {
                    if (!Intrinsics.areEqual(((ModuleSharedClassDefinition) it2.next()).getJsName(), name)) {
                    }
                }
                list3 = this.events;
                if (list3 instanceof Collection) {
                }
                it3 = list3.iterator();
                while (it3.hasNext()) {
                    if (!Intrinsics.areEqual(((ModuleEventDefinition) it3.next()).getJsName(), name)) {
                    }
                }
                return;
            }
            it2 = list2.iterator();
            while (it2.hasNext()) {
                if (!Intrinsics.areEqual(((ModuleSharedClassDefinition) it2.next()).getJsName(), name)) {
                }
            }
            list3 = this.events;
            if (list3 instanceof Collection) {
            }
            it3 = list3.iterator();
            while (it3.hasNext()) {
                if (!Intrinsics.areEqual(((ModuleEventDefinition) it3.next()).getJsName(), name)) {
                }
            }
            return;
        }
        it = list.iterator();
        while (it.hasNext()) {
            if (!Intrinsics.areEqual(((ModulePropertyDefinition) it.next()).getJsName(), name)) {
            }
        }
        list2 = this.sharedClasses;
        if (!(list2 instanceof Collection) && list2.isEmpty()) {
            list3 = this.events;
            if (list3 instanceof Collection) {
            }
            it3 = list3.iterator();
            while (it3.hasNext()) {
                if (!Intrinsics.areEqual(((ModuleEventDefinition) it3.next()).getJsName(), name)) {
                }
            }
            return;
        }
        it2 = list2.iterator();
        while (it2.hasNext()) {
            if (!Intrinsics.areEqual(((ModuleSharedClassDefinition) it2.next()).getJsName(), name)) {
            }
        }
        list3 = this.events;
        if ((list3 instanceof Collection) || !list3.isEmpty()) {
            it3 = list3.iterator();
            while (it3.hasNext()) {
                if (!Intrinsics.areEqual(((ModuleEventDefinition) it3.next()).getJsName(), name)) {
                }
            }
            return;
        }
        return;
        throw new IllegalArgumentException(("Export '" + name + "' is already declared in this module or shared-object class").toString());
    }

    private final boolean hasIsPrefix(String propertyName) {
        return propertyName.length() > 2 && StringsKt.startsWith$default(propertyName, "is", false, 2, (Object) null) && !Character.isLowerCase(propertyName.charAt(2));
    }

    private final String accessorSuffix(String str) {
        String strValueOf;
        if (str.length() <= 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char cCharAt = str.charAt(0);
        if (Character.isLowerCase(cCharAt)) {
            strValueOf = CharsKt.titlecase(cCharAt);
        } else {
            strValueOf = String.valueOf(cCharAt);
        }
        sb.append((Object) strValueOf);
        String strSubstring = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        sb.append(strSubstring);
        return sb.toString();
    }

    /* JADX INFO: compiled from: ModuleBuilder.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/github/expo/modules/v2/modules/ModuleBuilder$Companion;", "", "<init>", "()V", "RESERVED_EXPORT_NAMES", "", "", "getRESERVED_EXPORT_NAMES", "()Ljava/util/Set;", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Set<String> getRESERVED_EXPORT_NAMES() {
            return ModuleBuilder.RESERVED_EXPORT_NAMES;
        }
    }
}
