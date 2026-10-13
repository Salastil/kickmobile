package io.github.expo.pika;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PTypeDescriptorRegistry.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002'(B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u001c\u001a\u00020\u00052\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u001e2\u0006\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\"H\u0007J8\u0010#\u001a\u00020\u001b2\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u001e2\u0006\u0010\u001f\u001a\u00020 2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\f\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\"H\u0007R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00050\u00170\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0019\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00170\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lio/github/expo/pika/PTypeDescriptorRegistry;", "", "<init>", "()V", "INT", "Lio/github/expo/pika/PTypeDescriptor$Concrete;", "INT_NULLABLE", "LONG", "LONG_NULLABLE", "FLOAT", "FLOAT_NULLABLE", "SHORT", "SHORT_NULLABLE", "DOUBLE", "DOUBLE_NULLABLE", "STRING", "STRING_NULLABLE", "BOOLEAN", "BOOLEAN_NULLABLE", "concreteNonNullableCache", "Lio/github/expo/pika/CacheByClass;", "concreteNullableCache", "concreteWithIntrospectionCache", "Ljava/util/concurrent/ConcurrentHashMap;", "Lio/github/expo/pika/PTypeDescriptorRegistry$ConcreteKey;", "parameterizedCache", "Lio/github/expo/pika/PTypeDescriptorRegistry$ParameterizedKey;", "Lio/github/expo/pika/PTypeDescriptor$Concrete$Parameterized;", "getOrCreateConcrete", "jClass", "Ljava/lang/Class;", "isNullable", "", "introspection", "Lio/github/expo/pika/PIntrospectionData;", "getOrCreateParameterized", "parameters", "", "Lio/github/expo/pika/PTypeDescriptor;", "ConcreteKey", "ParameterizedKey", "pika-api"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PTypeDescriptorRegistry {
    public static final PTypeDescriptorRegistry INSTANCE = new PTypeDescriptorRegistry();
    public static final PTypeDescriptor.Concrete INT = new PTypeDescriptor.Concrete(new PType(Integer.TYPE), false, null);
    public static final PTypeDescriptor.Concrete INT_NULLABLE = new PTypeDescriptor.Concrete(new PType(Integer.TYPE), true, null);
    public static final PTypeDescriptor.Concrete LONG = new PTypeDescriptor.Concrete(new PType(Long.TYPE), false, null);
    public static final PTypeDescriptor.Concrete LONG_NULLABLE = new PTypeDescriptor.Concrete(new PType(Long.TYPE), true, null);
    public static final PTypeDescriptor.Concrete FLOAT = new PTypeDescriptor.Concrete(new PType(Float.TYPE), false, null);
    public static final PTypeDescriptor.Concrete FLOAT_NULLABLE = new PTypeDescriptor.Concrete(new PType(Float.TYPE), true, null);
    public static final PTypeDescriptor.Concrete SHORT = new PTypeDescriptor.Concrete(new PType(Short.TYPE), false, null);
    public static final PTypeDescriptor.Concrete SHORT_NULLABLE = new PTypeDescriptor.Concrete(new PType(Short.TYPE), true, null);
    public static final PTypeDescriptor.Concrete DOUBLE = new PTypeDescriptor.Concrete(new PType(Double.TYPE), false, null);
    public static final PTypeDescriptor.Concrete DOUBLE_NULLABLE = new PTypeDescriptor.Concrete(new PType(Double.TYPE), true, null);
    public static final PTypeDescriptor.Concrete STRING = new PTypeDescriptor.Concrete(new PType(String.class), false, null);
    public static final PTypeDescriptor.Concrete STRING_NULLABLE = new PTypeDescriptor.Concrete(new PType(String.class), true, null);
    public static final PTypeDescriptor.Concrete BOOLEAN = new PTypeDescriptor.Concrete(new PType(Boolean.TYPE), false, null);
    public static final PTypeDescriptor.Concrete BOOLEAN_NULLABLE = new PTypeDescriptor.Concrete(new PType(Boolean.TYPE), true, null);
    private static final CacheByClass<PTypeDescriptor.Concrete> concreteNonNullableCache = CacheByClassKt.createCache(new Function1() { // from class: io.github.expo.pika.PTypeDescriptorRegistry$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return PTypeDescriptorRegistry.concreteNonNullableCache$lambda$0((Class) obj);
        }
    });
    private static final CacheByClass<PTypeDescriptor.Concrete> concreteNullableCache = CacheByClassKt.createCache(new Function1() { // from class: io.github.expo.pika.PTypeDescriptorRegistry$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return PTypeDescriptorRegistry.concreteNullableCache$lambda$1((Class) obj);
        }
    });
    private static final CacheByClass<ConcurrentHashMap<ConcreteKey, PTypeDescriptor.Concrete>> concreteWithIntrospectionCache = CacheByClassKt.createCache(new Function1() { // from class: io.github.expo.pika.PTypeDescriptorRegistry$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return PTypeDescriptorRegistry.concreteWithIntrospectionCache$lambda$2((Class) obj);
        }
    });
    private static final CacheByClass<ConcurrentHashMap<ParameterizedKey, PTypeDescriptor.Concrete.Parameterized>> parameterizedCache = CacheByClassKt.createCache(new Function1() { // from class: io.github.expo.pika.PTypeDescriptorRegistry$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return PTypeDescriptorRegistry.parameterizedCache$lambda$3((Class) obj);
        }
    });

    private PTypeDescriptorRegistry() {
    }

    static final PTypeDescriptor.Concrete concreteNonNullableCache$lambda$0(Class type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new PTypeDescriptor.Concrete(new PType(type), false, null);
    }

    static final PTypeDescriptor.Concrete concreteNullableCache$lambda$1(Class type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new PTypeDescriptor.Concrete(new PType(type), true, null);
    }

    /* JADX INFO: compiled from: PTypeDescriptorRegistry.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005HÆ\u0003J#\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0017\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lio/github/expo/pika/PTypeDescriptorRegistry$ConcreteKey;", "", "isNullable", "", "introspection", "Lio/github/expo/pika/PIntrospectionData;", "<init>", "(ZLio/github/expo/pika/PIntrospectionData;)V", "()Z", "getIntrospection", "()Lio/github/expo/pika/PIntrospectionData;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "pika-api"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final /* data */ class ConcreteKey {
        private final PIntrospectionData<?> introspection;
        private final boolean isNullable;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ConcreteKey copy$default(ConcreteKey concreteKey, boolean z, PIntrospectionData pIntrospectionData, int i, Object obj) {
            if ((i & 1) != 0) {
                z = concreteKey.isNullable;
            }
            if ((i & 2) != 0) {
                pIntrospectionData = concreteKey.introspection;
            }
            return concreteKey.copy(z, pIntrospectionData);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsNullable() {
            return this.isNullable;
        }

        public final PIntrospectionData<?> component2() {
            return this.introspection;
        }

        public final ConcreteKey copy(boolean isNullable, PIntrospectionData<?> introspection) {
            return new ConcreteKey(isNullable, introspection);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ConcreteKey)) {
                return false;
            }
            ConcreteKey concreteKey = (ConcreteKey) other;
            return this.isNullable == concreteKey.isNullable && Intrinsics.areEqual(this.introspection, concreteKey.introspection);
        }

        public int hashCode() {
            int iHashCode = Boolean.hashCode(this.isNullable) * 31;
            PIntrospectionData<?> pIntrospectionData = this.introspection;
            return iHashCode + (pIntrospectionData == null ? 0 : pIntrospectionData.hashCode());
        }

        public String toString() {
            return "ConcreteKey(isNullable=" + this.isNullable + ", introspection=" + this.introspection + ")";
        }

        public ConcreteKey(boolean z, PIntrospectionData<?> pIntrospectionData) {
            this.isNullable = z;
            this.introspection = pIntrospectionData;
        }

        public final PIntrospectionData<?> getIntrospection() {
            return this.introspection;
        }

        public final boolean isNullable() {
            return this.isNullable;
        }
    }

    static final ConcurrentHashMap concreteWithIntrospectionCache$lambda$2(Class it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return new ConcurrentHashMap();
    }

    /* JADX INFO: compiled from: PTypeDescriptorRegistry.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0002\b\u0003\u0018\u00010\bHÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lio/github/expo/pika/PTypeDescriptorRegistry$ParameterizedKey;", "", "isNullable", "", "parameters", "", "Lio/github/expo/pika/PTypeDescriptor;", "introspection", "Lio/github/expo/pika/PIntrospectionData;", "<init>", "(ZLjava/util/List;Lio/github/expo/pika/PIntrospectionData;)V", "()Z", "getParameters", "()Ljava/util/List;", "getIntrospection", "()Lio/github/expo/pika/PIntrospectionData;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "pika-api"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final /* data */ class ParameterizedKey {
        private final PIntrospectionData<?> introspection;
        private final boolean isNullable;
        private final List<PTypeDescriptor> parameters;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ParameterizedKey copy$default(ParameterizedKey parameterizedKey, boolean z, List list, PIntrospectionData pIntrospectionData, int i, Object obj) {
            if ((i & 1) != 0) {
                z = parameterizedKey.isNullable;
            }
            if ((i & 2) != 0) {
                list = parameterizedKey.parameters;
            }
            if ((i & 4) != 0) {
                pIntrospectionData = parameterizedKey.introspection;
            }
            return parameterizedKey.copy(z, list, pIntrospectionData);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsNullable() {
            return this.isNullable;
        }

        public final List<PTypeDescriptor> component2() {
            return this.parameters;
        }

        public final PIntrospectionData<?> component3() {
            return this.introspection;
        }

        public final ParameterizedKey copy(boolean isNullable, List<? extends PTypeDescriptor> parameters, PIntrospectionData<?> introspection) {
            Intrinsics.checkNotNullParameter(parameters, "parameters");
            return new ParameterizedKey(isNullable, parameters, introspection);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ParameterizedKey)) {
                return false;
            }
            ParameterizedKey parameterizedKey = (ParameterizedKey) other;
            return this.isNullable == parameterizedKey.isNullable && Intrinsics.areEqual(this.parameters, parameterizedKey.parameters) && Intrinsics.areEqual(this.introspection, parameterizedKey.introspection);
        }

        public int hashCode() {
            int iHashCode = ((Boolean.hashCode(this.isNullable) * 31) + this.parameters.hashCode()) * 31;
            PIntrospectionData<?> pIntrospectionData = this.introspection;
            return iHashCode + (pIntrospectionData == null ? 0 : pIntrospectionData.hashCode());
        }

        public String toString() {
            return "ParameterizedKey(isNullable=" + this.isNullable + ", parameters=" + this.parameters + ", introspection=" + this.introspection + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ParameterizedKey(boolean z, List<? extends PTypeDescriptor> parameters, PIntrospectionData<?> pIntrospectionData) {
            Intrinsics.checkNotNullParameter(parameters, "parameters");
            this.isNullable = z;
            this.parameters = parameters;
            this.introspection = pIntrospectionData;
        }

        public final boolean isNullable() {
            return this.isNullable;
        }

        public final List<PTypeDescriptor> getParameters() {
            return this.parameters;
        }

        public final PIntrospectionData<?> getIntrospection() {
            return this.introspection;
        }
    }

    static final ConcurrentHashMap parameterizedCache$lambda$3(Class it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return new ConcurrentHashMap();
    }

    @JvmStatic
    public static final PTypeDescriptor.Concrete getOrCreateConcrete(Class<?> jClass, boolean isNullable, PIntrospectionData<?> introspection) {
        PTypeDescriptor.Concrete concretePutIfAbsent;
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        if (introspection == null) {
            if (isNullable) {
                return concreteNullableCache.get(jClass);
            }
            return concreteNonNullableCache.get(jClass);
        }
        ConcreteKey concreteKey = new ConcreteKey(isNullable, introspection);
        ConcurrentHashMap<ConcreteKey, PTypeDescriptor.Concrete> concurrentHashMap = concreteWithIntrospectionCache.get(jClass);
        PTypeDescriptor.Concrete concrete = concurrentHashMap.get(concreteKey);
        if (concrete == null && (concretePutIfAbsent = concurrentHashMap.putIfAbsent(concreteKey, (concrete = new PTypeDescriptor.Concrete(new PType(jClass), isNullable, introspection)))) != null) {
            concrete = concretePutIfAbsent;
        }
        Intrinsics.checkNotNull(concrete);
        return concrete;
    }

    @JvmStatic
    public static final PTypeDescriptor.Concrete.Parameterized getOrCreateParameterized(Class<?> jClass, boolean isNullable, List<? extends PTypeDescriptor> parameters, PIntrospectionData<?> introspection) {
        PTypeDescriptor.Concrete.Parameterized parameterizedPutIfAbsent;
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        ParameterizedKey parameterizedKey = new ParameterizedKey(isNullable, parameters, introspection);
        ConcurrentHashMap<ParameterizedKey, PTypeDescriptor.Concrete.Parameterized> concurrentHashMap = parameterizedCache.get(jClass);
        PTypeDescriptor.Concrete.Parameterized parameterized = concurrentHashMap.get(parameterizedKey);
        if (parameterized == null && (parameterizedPutIfAbsent = concurrentHashMap.putIfAbsent(parameterizedKey, (parameterized = new PTypeDescriptor.Concrete.Parameterized(new PType(jClass), isNullable, parameters, introspection)))) != null) {
            parameterized = parameterizedPutIfAbsent;
        }
        Intrinsics.checkNotNullExpressionValue(parameterized, "getOrPut(...)");
        return parameterized;
    }
}
