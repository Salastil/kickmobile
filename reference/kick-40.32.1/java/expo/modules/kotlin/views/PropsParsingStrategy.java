package expo.modules.kotlin.views;

import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.descriptors.TypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptorKt;
import expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt;
import expo.modules.kotlin.views.ComposeProps;
import io.github.expo.pika.PIntrospectionData;
import io.github.expo.pika.PProperty;
import io.github.expo.pika.PTypeDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.full.KClasses;

/* JADX INFO: compiled from: PropsParsingStrategy.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0002\u000b\fJ\r\u0010\u0004\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0005J\u0014\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H&J\u0014\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H&\u0082\u0001\u0002\r\u000e¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lexpo/modules/kotlin/views/PropsParsingStrategy;", "Props", "Lexpo/modules/kotlin/views/ComposeProps;", "", "createNewInstance", "()Lexpo/modules/kotlin/views/ComposeProps;", "props", "", "", "Lexpo/modules/kotlin/views/ComposeViewProp;", "unwrappedProps", "Introspection", "Reflection", "Lexpo/modules/kotlin/views/PropsParsingStrategy$Introspection;", "Lexpo/modules/kotlin/views/PropsParsingStrategy$Reflection;", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface PropsParsingStrategy<Props extends ComposeProps> {
    Props createNewInstance();

    Map<String, ComposeViewProp> props();

    Map<String, ComposeViewProp> unwrappedProps();

    /* JADX INFO: compiled from: PropsParsingStrategy.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0087@\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fH\u0016¢\u0006\u0004\b\u0012\u0010\u0010J\u001b\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0083\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004¢\u0006\u0004\b\u001b\u0010\u001cJ\u0011\u0010\u001d\u001a\u00020\rHÖ\u0081\u0004¢\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0004\u0092\u0001\b\u0012\u0004\u0012\u0002H\u00010\u0005¨\u0006 "}, d2 = {"Lexpo/modules/kotlin/views/PropsParsingStrategy$Introspection;", "Props", "Lexpo/modules/kotlin/views/ComposeProps;", "Lexpo/modules/kotlin/views/PropsParsingStrategy;", "introspectableData", "Lio/github/expo/pika/PIntrospectionData;", "constructor-impl", "(Lio/github/expo/pika/PIntrospectionData;)Lio/github/expo/pika/PIntrospectionData;", "createNewInstance", "createNewInstance-impl", "(Lio/github/expo/pika/PIntrospectionData;)Lexpo/modules/kotlin/views/ComposeProps;", "props", "", "", "Lexpo/modules/kotlin/views/ComposeViewProp;", "props-impl", "(Lio/github/expo/pika/PIntrospectionData;)Ljava/util/Map;", "unwrappedProps", "unwrappedProps-impl", "equals", "", "other", "", "equals-impl", "(Lio/github/expo/pika/PIntrospectionData;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Lio/github/expo/pika/PIntrospectionData;)I", "toString", "toString-impl", "(Lio/github/expo/pika/PIntrospectionData;)Ljava/lang/String;", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @JvmInline
    public static final class Introspection<Props extends ComposeProps> implements PropsParsingStrategy<Props> {
        private final PIntrospectionData<Props> introspectableData;

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Introspection m11979boximpl(PIntrospectionData pIntrospectionData) {
            return new Introspection(pIntrospectionData);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static <Props extends ComposeProps> PIntrospectionData<Props> m11980constructorimpl(PIntrospectionData<Props> introspectableData) {
            Intrinsics.checkNotNullParameter(introspectableData, "introspectableData");
            return introspectableData;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m11982equalsimpl(PIntrospectionData<Props> pIntrospectionData, Object obj) {
            return (obj instanceof Introspection) && Intrinsics.areEqual(pIntrospectionData, ((Introspection) obj).getIntrospectableData());
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m11983equalsimpl0(PIntrospectionData<ComposeProps> pIntrospectionData, PIntrospectionData<ComposeProps> pIntrospectionData2) {
            return Intrinsics.areEqual(pIntrospectionData, pIntrospectionData2);
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m11984hashCodeimpl(PIntrospectionData<Props> pIntrospectionData) {
            return pIntrospectionData.hashCode();
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m11986toStringimpl(PIntrospectionData<Props> pIntrospectionData) {
            return "Introspection(introspectableData=" + pIntrospectionData + ")";
        }

        public boolean equals(Object obj) {
            return m11982equalsimpl(this.introspectableData, obj);
        }

        public int hashCode() {
            return m11984hashCodeimpl(this.introspectableData);
        }

        public String toString() {
            return m11986toStringimpl(this.introspectableData);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
        public final /* synthetic */ PIntrospectionData getIntrospectableData() {
            return this.introspectableData;
        }

        private /* synthetic */ Introspection(PIntrospectionData pIntrospectionData) {
            this.introspectableData = pIntrospectionData;
        }

        @Override // expo.modules.kotlin.views.PropsParsingStrategy
        public Props createNewInstance() {
            return (Props) m11981createNewInstanceimpl(this.introspectableData);
        }

        /* JADX INFO: renamed from: createNewInstance-impl, reason: not valid java name */
        public static Props m11981createNewInstanceimpl(PIntrospectionData<Props> pIntrospectionData) throws IllegalAccessException, InstantiationException, InvocationTargetException {
            Props propsNewInstance = pIntrospectionData.getJClass().getDeclaredConstructor(null).newInstance(null);
            Intrinsics.checkNotNull(propsNewInstance, "null cannot be cast to non-null type Props of expo.modules.kotlin.views.PropsParsingStrategy.Introspection");
            return propsNewInstance;
        }

        @Override // expo.modules.kotlin.views.PropsParsingStrategy
        public Map<String, ComposeViewProp> props() {
            return m11985propsimpl(this.introspectableData);
        }

        /* JADX INFO: renamed from: props-impl, reason: not valid java name */
        public static Map<String, ComposeViewProp> m11985propsimpl(PIntrospectionData<Props> pIntrospectionData) {
            PProperty<Props, ?>[] properties = pIntrospectionData.getProperties();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(properties.length), 16));
            for (PProperty<Props, ?> pProperty : properties) {
                Pair pair = TuplesKt.to(pProperty.getName(), new ComposeViewProp(pProperty.getName(), new AnyType(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(pProperty.getType()), new Function0() { // from class: expo.modules.kotlin.views.PropsParsingStrategy$Introspection$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PropsParsingStrategy.Introspection.props_impl$lambda$0$0();
                    }
                }), null, 2, null), (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(new PropsParsingStrategy$Introspection$props$1$1(pProperty), 1)));
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            return linkedHashMap;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final KType props_impl$lambda$0$0() {
            throw new IllegalStateException("KType is not available for introspected properties, should not be accessed".toString());
        }

        @Override // expo.modules.kotlin.views.PropsParsingStrategy
        public Map<String, ComposeViewProp> unwrappedProps() {
            return m11987unwrappedPropsimpl(this.introspectableData);
        }

        /* JADX INFO: renamed from: unwrappedProps-impl, reason: not valid java name */
        public static Map<String, ComposeViewProp> m11987unwrappedPropsimpl(PIntrospectionData<Props> pIntrospectionData) {
            PProperty<Props, ?>[] properties = pIntrospectionData.getProperties();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(properties.length), 16));
            for (PProperty<Props, ?> pProperty : properties) {
                PTypeDescriptor type = pProperty.getType();
                PTypeDescriptor.Concrete.Parameterized parameterized = type instanceof PTypeDescriptor.Concrete.Parameterized ? (PTypeDescriptor.Concrete.Parameterized) type : null;
                if (parameterized == null) {
                    throw new IllegalArgumentException(("Wrapped props must be of type MutableState<T>. Property " + pProperty.getName() + " is not a valid wrapped prop because its return type is not parameterized.").toString());
                }
                Object objFirstOrNull = CollectionsKt.firstOrNull((List<? extends Object>) parameterized.getParameters());
                if (objFirstOrNull == null) {
                    throw new IllegalArgumentException("Can't unwrap prop type".toString());
                }
                Pair pair = TuplesKt.to(pProperty.getName(), new ComposeViewProp(pProperty.getName(), new AnyType(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor((PTypeDescriptor) objFirstOrNull), new Function0() { // from class: expo.modules.kotlin.views.PropsParsingStrategy$Introspection$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PropsParsingStrategy.Introspection.unwrappedProps_impl$lambda$0$2();
                    }
                }), null, 2, null), (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(new PropsParsingStrategy$Introspection$unwrappedProps$1$2(pProperty), 1)));
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            return linkedHashMap;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final KType unwrappedProps_impl$lambda$0$2() {
            throw new IllegalStateException("KType is not available for introspected properties, should not be accessed".toString());
        }
    }

    /* JADX INFO: compiled from: PropsParsingStrategy.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0087@\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0013\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fH\u0016¢\u0006\u0004\b\u0012\u0010\u0010J\u001b\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0083\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004¢\u0006\u0004\b\u001b\u0010\u001cJ\u0011\u0010\u001d\u001a\u00020\rHÖ\u0081\u0004¢\u0006\u0004\b\u001e\u0010\u001fR\u0012\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0004\u0092\u0001\u0006\u0012\u0002\b\u00030\u0005¨\u0006 "}, d2 = {"Lexpo/modules/kotlin/views/PropsParsingStrategy$Reflection;", "Props", "Lexpo/modules/kotlin/views/ComposeProps;", "Lexpo/modules/kotlin/views/PropsParsingStrategy;", "propsClass", "Lkotlin/reflect/KClass;", "constructor-impl", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KClass;", "createNewInstance", "createNewInstance-impl", "(Lkotlin/reflect/KClass;)Lexpo/modules/kotlin/views/ComposeProps;", "props", "", "", "Lexpo/modules/kotlin/views/ComposeViewProp;", "props-impl", "(Lkotlin/reflect/KClass;)Ljava/util/Map;", "unwrappedProps", "unwrappedProps-impl", "equals", "", "other", "", "equals-impl", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Lkotlin/reflect/KClass;)I", "toString", "toString-impl", "(Lkotlin/reflect/KClass;)Ljava/lang/String;", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @JvmInline
    public static final class Reflection<Props extends ComposeProps> implements PropsParsingStrategy<Props> {
        private final KClass<?> propsClass;

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Reflection m11989boximpl(KClass kClass) {
            return new Reflection(kClass);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static <Props extends ComposeProps> KClass<?> m11990constructorimpl(KClass<?> propsClass) {
            Intrinsics.checkNotNullParameter(propsClass, "propsClass");
            return propsClass;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m11992equalsimpl(KClass<?> kClass, Object obj) {
            return (obj instanceof Reflection) && Intrinsics.areEqual(kClass, ((Reflection) obj).getPropsClass());
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m11993equalsimpl0(KClass<?> kClass, KClass<?> kClass2) {
            return Intrinsics.areEqual(kClass, kClass2);
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m11994hashCodeimpl(KClass<?> kClass) {
            return kClass.hashCode();
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m11996toStringimpl(KClass<?> kClass) {
            return "Reflection(propsClass=" + kClass + ")";
        }

        public boolean equals(Object obj) {
            return m11992equalsimpl(this.propsClass, obj);
        }

        public int hashCode() {
            return m11994hashCodeimpl(this.propsClass);
        }

        public String toString() {
            return m11996toStringimpl(this.propsClass);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
        public final /* synthetic */ KClass getPropsClass() {
            return this.propsClass;
        }

        private /* synthetic */ Reflection(KClass kClass) {
            this.propsClass = kClass;
        }

        @Override // expo.modules.kotlin.views.PropsParsingStrategy
        public Props createNewInstance() {
            return (Props) m11991createNewInstanceimpl(this.propsClass);
        }

        /* JADX INFO: renamed from: createNewInstance-impl, reason: not valid java name */
        public static Props m11991createNewInstanceimpl(KClass<?> kClass) throws IllegalAccessException, InstantiationException, InvocationTargetException {
            Object objNewInstance = JvmClassMappingKt.getJavaClass((KClass) kClass).getDeclaredConstructor(null).newInstance(null);
            Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type Props of expo.modules.kotlin.views.PropsParsingStrategy.Reflection");
            return (Props) objNewInstance;
        }

        @Override // expo.modules.kotlin.views.PropsParsingStrategy
        public Map<String, ComposeViewProp> props() {
            return m11995propsimpl(this.propsClass);
        }

        /* JADX INFO: renamed from: props-impl, reason: not valid java name */
        public static Map<String, ComposeViewProp> m11995propsimpl(KClass<?> kClass) {
            Collection<KProperty1> memberProperties = KClasses.getMemberProperties(kClass);
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(memberProperties, 10)), 16));
            for (final KProperty1 kProperty1 : memberProperties) {
                Pair pair = TuplesKt.to(kProperty1.getName(), new ComposeViewProp(kProperty1.getName(), new AnyType(TypeDescriptorKt.toTypeDescriptor(kProperty1.getReturnType()), null, 2, null), new Function1() { // from class: expo.modules.kotlin.views.PropsParsingStrategy$Reflection$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PropsParsingStrategy.Reflection.props_impl$lambda$0$0(kProperty1, obj);
                    }
                }));
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            return linkedHashMap;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Object props_impl$lambda$0$0(KProperty1 kProperty1, Object self) {
            Intrinsics.checkNotNullParameter(self, "self");
            return kProperty1.getGetter().call(self);
        }

        @Override // expo.modules.kotlin.views.PropsParsingStrategy
        public Map<String, ComposeViewProp> unwrappedProps() {
            return m11997unwrappedPropsimpl(this.propsClass);
        }

        /* JADX INFO: renamed from: unwrappedProps-impl, reason: not valid java name */
        public static Map<String, ComposeViewProp> m11997unwrappedPropsimpl(KClass<?> kClass) {
            Collection<KProperty1> memberProperties = KClasses.getMemberProperties(kClass);
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(memberProperties, 10)), 16));
            for (final KProperty1 kProperty1 : memberProperties) {
                KType type = ((KTypeProjection) CollectionsKt.first((List) kProperty1.getReturnType().getArguments())).getType();
                if (type == null) {
                    throw new IllegalArgumentException(("Wrapped props must be of type MutableState<T>. Property " + kProperty1.getName() + " is not a valid wrapped prop because its return type is not parameterized.").toString());
                }
                Pair pair = TuplesKt.to(kProperty1.getName(), new ComposeViewProp(kProperty1.getName(), new AnyType(TypeDescriptorKt.toTypeDescriptor(type), null, 2, null), new Function1() { // from class: expo.modules.kotlin.views.PropsParsingStrategy$Reflection$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PropsParsingStrategy.Reflection.unwrappedProps_impl$lambda$0$1(kProperty1, obj);
                    }
                }));
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            return linkedHashMap;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Object unwrappedProps_impl$lambda$0$1(KProperty1 kProperty1, Object self) {
            Intrinsics.checkNotNullParameter(self, "self");
            return kProperty1.getGetter().call(self);
        }
    }
}
