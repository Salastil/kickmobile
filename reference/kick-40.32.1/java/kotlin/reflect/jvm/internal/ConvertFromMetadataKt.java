package kotlin.reflect.jvm.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;
import kotlin.reflect.jvm.KTypesJvm;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.km.Attributes;
import kotlin.reflect.jvm.internal.impl.km.KmAnnotation;
import kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.km.KmClassifier;
import kotlin.reflect.jvm.internal.impl.km.KmType;
import kotlin.reflect.jvm.internal.impl.km.KmTypeProjection;
import kotlin.reflect.jvm.internal.impl.km.KmVariance;
import kotlin.reflect.jvm.internal.impl.km.jvm.JvmExtensionsKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.types.AbstractKType;
import kotlin.reflect.jvm.internal.types.MutableCollectionKClass;
import kotlin.reflect.jvm.internal.types.MutableCollectionKClassKt;
import kotlin.reflect.jvm.internal.types.SimpleKType;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: compiled from: ConvertFromMetadata.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0010\u0010\u0000\u001a\u00020\u0001*\u00060\u0002j\u0002`\u0003H\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u0002*\u00060\u0002j\u0002`\u0003H\u0000\u001a\u001e\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006*\u00020\u00072\n\u0010\b\u001a\u00060\u0002j\u0002`\u0003H\u0000\u001a.\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0000\u001a$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0000\u001a*\u0010\u0017\u001a\u00020\u0018*\u00020\u00192\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002\u001a,\u0010\u001d\u001a\u00020\u001c*\u00020\u001e2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0002\u001a\f\u0010\u001f\u001a\u00020 *\u00020!H\u0002\u001a\u001a\u0010\"\u001a\b\u0012\u0002\b\u0003\u0018\u00010#*\u00020\u00192\u0006\u0010$\u001a\u00020\u0018H\u0002\u001a\u0014\u0010%\u001a\u00020&*\u00020'2\u0006\u0010\f\u001a\u00020\u0007H\u0002\u001a*\u0010(\u001a\u00020)*\u00020*2\n\u0010+\u001a\u00060\u0002j\u0002`\u00032\b\u0010,\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u0007H\u0002¨\u0006-²\u0006\u0010\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00110\u001bX\u008a\u0084\u0002"}, d2 = {"toClassId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "", "Lkotlin/reflect/jvm/internal/impl/km/ClassName;", "toNonLocalSimpleName", "loadKClass", "Lkotlin/reflect/KClass;", "Ljava/lang/ClassLoader;", "name", "toKType", "Lkotlin/reflect/KType;", "Lkotlin/reflect/jvm/internal/impl/km/KmType;", "classLoader", "typeParameterTable", "Lkotlin/reflect/jvm/internal/TypeParameterTable;", "computeJavaType", "Lkotlin/Function0;", "Ljava/lang/reflect/Type;", "convertTypeArgumentToJavaType", "computeType", "Lkotlin/reflect/jvm/internal/types/AbstractKType;", FirebaseAnalytics.Param.INDEX, "", "toClassifier", "Lkotlin/reflect/KClassifier;", "Lkotlin/reflect/jvm/internal/impl/km/KmClassifier;", "typeArguments", "", "Lkotlin/reflect/KTypeProjection;", "toKTypeProjection", "Lkotlin/reflect/jvm/internal/impl/km/KmTypeProjection;", "toKVariance", "Lkotlin/reflect/KVariance;", "Lkotlin/reflect/jvm/internal/impl/km/KmVariance;", "toMutableCollectionKClass", "Lkotlin/reflect/jvm/internal/types/MutableCollectionKClass;", "kClassifier", "toAnnotation", "", "Lkotlin/reflect/jvm/internal/impl/km/KmAnnotation;", "toAnnotationArgument", "", "Lkotlin/reflect/jvm/internal/impl/km/KmAnnotationArgument;", "annotationClassName", "argumentName", "kotlin-reflection", "javaParameterizedTypeArguments"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ConvertFromMetadataKt {

    /* JADX INFO: compiled from: ConvertFromMetadata.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KmVariance.values().length];
            try {
                iArr[KmVariance.IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KmVariance.OUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KmVariance.INVARIANT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final ClassId toClassId(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        boolean zStartsWith$default = StringsKt.startsWith$default(str, ".", false, 2, (Object) null);
        if (zStartsWith$default) {
            str = str.substring(1);
            Intrinsics.checkNotNullExpressionValue(str, "substring(...)");
        }
        return new ClassId(new FqName(StringsKt.replace$default(StringsKt.substringBeforeLast(str, '/', ""), '/', FilenameUtils.EXTENSION_SEPARATOR, false, 4, (Object) null)), new FqName(StringsKt.substringAfterLast$default(str, '/', (String) null, 2, (Object) null)), zStartsWith$default);
    }

    public static final String toNonLocalSimpleName(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (StringsKt.startsWith$default(str, ".", false, 2, (Object) null)) {
            throw new IllegalArgumentException(("Local class is not supported: " + str).toString());
        }
        return StringsKt.substringAfterLast$default(StringsKt.substringAfterLast$default(str, '/', (String) null, 2, (Object) null), FilenameUtils.EXTENSION_SEPARATOR, (String) null, 2, (Object) null);
    }

    public static final KClass<?> loadKClass(ClassLoader classLoader, String name) {
        Intrinsics.checkNotNullParameter(classLoader, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Class clsLoadClass$default = UtilKt.loadClass$default(classLoader, toClassId(name), 0, 2, null);
        if (clsLoadClass$default != null) {
            return JvmClassMappingKt.getKotlinClass(clsLoadClass$default);
        }
        return null;
    }

    public static /* synthetic */ KType toKType$default(KmType kmType, ClassLoader classLoader, TypeParameterTable typeParameterTable, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = null;
        }
        return toKType(kmType, classLoader, typeParameterTable, function0);
    }

    /* JADX WARN: Type inference failed for: r8v1, types: [T, kotlin.reflect.jvm.internal.types.SimpleKType] */
    public static final KType toKType(KmType kmType, final ClassLoader classLoader, final TypeParameterTable typeParameterTable, final Function0<? extends Type> function0) {
        Intrinsics.checkNotNullParameter(kmType, "<this>");
        Intrinsics.checkNotNullParameter(classLoader, "classLoader");
        Intrinsics.checkNotNullParameter(typeParameterTable, "typeParameterTable");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        List list = SequencesKt.toList(SequencesKt.mapIndexed(SequencesKt.flatMapIterable(SequencesKt.generateSequence(kmType, new Function1() { // from class: kotlin.reflect.jvm.internal.ConvertFromMetadataKt$$Lambda$0
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return ConvertFromMetadataKt.toKType$lambda$0((KmType) obj);
            }
        }), new Function1() { // from class: kotlin.reflect.jvm.internal.ConvertFromMetadataKt$$Lambda$1
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return ConvertFromMetadataKt.toKType$lambda$1((KmType) obj);
            }
        }), new Function2(classLoader, typeParameterTable, function0, objectRef) { // from class: kotlin.reflect.jvm.internal.ConvertFromMetadataKt$$Lambda$2
            private final ClassLoader arg$0;
            private final TypeParameterTable arg$1;
            private final Function0 arg$2;
            private final Ref.ObjectRef arg$3;

            {
                this.arg$0 = classLoader;
                this.arg$1 = typeParameterTable;
                this.arg$2 = function0;
                this.arg$3 = objectRef;
            }

            @Override // kotlin.jvm.functions.Function2
            public Object invoke(Object obj, Object obj2) {
                return ConvertFromMetadataKt.toKType$lambda$2(this.arg$0, this.arg$1, this.arg$2, this.arg$3, ((Number) obj).intValue(), (KmTypeProjection) obj2);
            }
        }));
        KClassifier classifier = toClassifier(kmType.getClassifier(), classLoader, typeParameterTable, list);
        boolean zIsNullable = Attributes.isNullable(kmType);
        List<KmAnnotation> annotations = JvmExtensionsKt.getAnnotations(kmType);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(annotations, 10));
        Iterator<T> it = annotations.iterator();
        while (it.hasNext()) {
            arrayList.add(toAnnotation((KmAnnotation) it.next(), classLoader));
        }
        ArrayList arrayList2 = arrayList;
        KmType abbreviatedType = kmType.getAbbreviatedType();
        KType kType$default = abbreviatedType != null ? toKType$default(abbreviatedType, classLoader, typeParameterTable, null, 4, null) : null;
        boolean zIsDefinitelyNonNull = Attributes.isDefinitelyNonNull(kmType);
        KmClassifier classifier2 = kmType.getClassifier();
        KmClassifier.Class r2 = classifier2 instanceof KmClassifier.Class ? (KmClassifier.Class) classifier2 : null;
        ?? simpleKType = new SimpleKType(classifier, list, zIsNullable, arrayList2, kType$default, zIsDefinitelyNonNull, Intrinsics.areEqual(r2 != null ? r2.getName() : null, "kotlin/Nothing"), Attributes.isSuspend(kmType), toMutableCollectionKClass(kmType.getClassifier(), classifier), function0);
        objectRef.element = simpleKType;
        return (KType) simpleKType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KmType toKType$lambda$0(KmType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getOuterType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterable toKType$lambda$1(KmType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getArguments();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KTypeProjection toKType$lambda$2(ClassLoader classLoader, TypeParameterTable typeParameterTable, Function0 function0, final Ref.ObjectRef objectRef, int i, KmTypeProjection typeArgument) {
        Intrinsics.checkNotNullParameter(typeArgument, "typeArgument");
        return toKTypeProjection(typeArgument, classLoader, typeParameterTable, function0 == null ? null : convertTypeArgumentToJavaType(new Function0(objectRef) { // from class: kotlin.reflect.jvm.internal.ConvertFromMetadataKt$$Lambda$4
            private final Ref.ObjectRef arg$0;

            {
                this.arg$0 = objectRef;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return ConvertFromMetadataKt.toKType$lambda$2$0(this.arg$0);
            }
        }, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final AbstractKType toKType$lambda$2$0(Ref.ObjectRef objectRef) {
        SimpleKType simpleKType;
        if (objectRef.element == 0) {
            Intrinsics.throwUninitializedPropertyAccessException("result");
            simpleKType = null;
        } else {
            simpleKType = (SimpleKType) objectRef.element;
        }
        return simpleKType;
    }

    public static final Function0<Type> convertTypeArgumentToJavaType(final Function0<? extends AbstractKType> computeType, final int i) {
        Intrinsics.checkNotNullParameter(computeType, "computeType");
        return new Function0(computeType, i) { // from class: kotlin.reflect.jvm.internal.ConvertFromMetadataKt$$Lambda$3
            private final Function0 arg$0;
            private final int arg$1;

            {
                this.arg$0 = computeType;
                this.arg$1 = i;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return ConvertFromMetadataKt.convertTypeArgumentToJavaType$lambda$0(this.arg$0, this.arg$1);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Type convertTypeArgumentToJavaType$lambda$0(Function0 function0, int i) {
        final AbstractKType abstractKType = (AbstractKType) function0.invoke();
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0(abstractKType) { // from class: kotlin.reflect.jvm.internal.ConvertFromMetadataKt$$Lambda$5
            private final AbstractKType arg$0;

            {
                this.arg$0 = abstractKType;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return ConvertFromMetadataKt.convertTypeArgumentToJavaType$lambda$0$0(this.arg$0);
            }
        });
        Type javaType = abstractKType.getJavaType();
        if (javaType instanceof Class) {
            Class cls = (Class) javaType;
            Class<?> componentType = cls.isArray() ? cls.getComponentType() : Object.class;
            Intrinsics.checkNotNull(componentType);
            return componentType;
        }
        if (javaType instanceof GenericArrayType) {
            if (i != 0) {
                throw new KotlinReflectionInternalError("Array type has been queried for a non-0th argument: " + abstractKType);
            }
            Type genericComponentType = ((GenericArrayType) javaType).getGenericComponentType();
            Intrinsics.checkNotNull(genericComponentType);
            return genericComponentType;
        }
        if (javaType instanceof ParameterizedType) {
            Type type = convertTypeArgumentToJavaType$lambda$0$1(lazy).get(i);
            if (!(type instanceof WildcardType)) {
                return type;
            }
            WildcardType wildcardType = (WildcardType) type;
            Type[] lowerBounds = wildcardType.getLowerBounds();
            Intrinsics.checkNotNullExpressionValue(lowerBounds, "getLowerBounds(...)");
            Type type2 = (Type) ArraysKt.firstOrNull(lowerBounds);
            if (type2 == null) {
                Type[] upperBounds = wildcardType.getUpperBounds();
                Intrinsics.checkNotNullExpressionValue(upperBounds, "getUpperBounds(...)");
                type2 = (Type) ArraysKt.first(upperBounds);
            }
            Intrinsics.checkNotNull(type2);
            return type2;
        }
        throw new KotlinReflectionInternalError("Non-generic type has been queried for arguments: " + abstractKType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List convertTypeArgumentToJavaType$lambda$0$0(AbstractKType abstractKType) {
        Type javaType = abstractKType.getJavaType();
        Intrinsics.checkNotNull(javaType);
        return ReflectClassUtilKt.getParameterizedTypeArguments(javaType);
    }

    private static final List<Type> convertTypeArgumentToJavaType$lambda$0$1(Lazy<? extends List<? extends Type>> lazy) {
        return (List) lazy.getValue();
    }

    private static final KClassifier toClassifier(KmClassifier kmClassifier, ClassLoader classLoader, TypeParameterTable typeParameterTable, List<KTypeProjection> list) {
        KClass<?> kotlinClass;
        if (kmClassifier instanceof KmClassifier.Class) {
            KmClassifier.Class r1 = (KmClassifier.Class) kmClassifier;
            if (Intrinsics.areEqual(r1.getName(), "kotlin/Array")) {
                KType type = ((KTypeProjection) CollectionsKt.single((List) list)).getType();
                if (type == null) {
                    type = StandardKTypes.INSTANCE.getANY();
                }
                kotlinClass = JvmClassMappingKt.getKotlinClass(UtilKt.createArrayType(JvmClassMappingKt.getJavaClass((KClass) KTypesJvm.getJvmErasure(type))));
            } else {
                KClass<?> kClassLoadKClass = loadKClass(classLoader, r1.getName());
                if (kClassLoadKClass == null) {
                    throw new KotlinReflectionInternalError("Class not found: " + r1.getName());
                }
                kotlinClass = kClassLoadKClass;
            }
            return kotlinClass;
        }
        if (kmClassifier instanceof KmClassifier.TypeAlias) {
            return new KTypeAliasImpl(toClassId(((KmClassifier.TypeAlias) kmClassifier).getName()).asSingleFqName());
        }
        if (!(kmClassifier instanceof KmClassifier.TypeParameter)) {
            throw new NoWhenBranchMatchedException();
        }
        KmClassifier.TypeParameter typeParameter = (KmClassifier.TypeParameter) kmClassifier;
        KTypeParameter kTypeParameter = typeParameterTable.get(typeParameter.getId());
        if (kTypeParameter != null) {
            return kTypeParameter;
        }
        throw new KotlinReflectionInternalError("Type parameter not found: " + typeParameter.getId());
    }

    private static final KTypeProjection toKTypeProjection(KmTypeProjection kmTypeProjection, ClassLoader classLoader, TypeParameterTable typeParameterTable, Function0<? extends Type> function0) {
        if (Intrinsics.areEqual(kmTypeProjection, KmTypeProjection.STAR)) {
            return KTypeProjection.INSTANCE.getSTAR();
        }
        KmVariance variance = kmTypeProjection.getVariance();
        KVariance kVariance = variance != null ? toKVariance(variance) : null;
        KmType type = kmTypeProjection.getType();
        return new KTypeProjection(kVariance, type != null ? toKType(type, classLoader, typeParameterTable, function0) : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KVariance toKVariance(KmVariance kmVariance) {
        int i = WhenMappings.$EnumSwitchMapping$0[kmVariance.ordinal()];
        if (i == 1) {
            return KVariance.IN;
        }
        if (i == 2) {
            return KVariance.OUT;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return KVariance.INVARIANT;
    }

    private static final MutableCollectionKClass<?> toMutableCollectionKClass(KmClassifier kmClassifier, KClassifier kClassifier) {
        String name;
        ClassId classId;
        KmClassifier.Class r2 = kmClassifier instanceof KmClassifier.Class ? (KmClassifier.Class) kmClassifier : null;
        if (r2 == null || (name = r2.getName()) == null || (classId = toClassId(name)) == null || !JavaToKotlinClassMap.INSTANCE.isMutable(classId)) {
            return null;
        }
        FqName fqNameAsSingleFqName = classId.asSingleFqName();
        Intrinsics.checkNotNull(kClassifier, "null cannot be cast to non-null type kotlin.reflect.KClass<*>");
        return MutableCollectionKClassKt.getMutableCollectionKClass(fqNameAsSingleFqName, (KClass) kClassifier);
    }

    private static final Annotation toAnnotation(KmAnnotation kmAnnotation, ClassLoader classLoader) {
        Class clsLoadClass$default = UtilKt.loadClass$default(classLoader, toClassId(kmAnnotation.getClassName()), 0, 2, null);
        if (clsLoadClass$default == null) {
            throw new KotlinReflectionInternalError("Annotation class not found: " + kmAnnotation.getClassName());
        }
        Map<String, KmAnnotationArgument> arguments = kmAnnotation.getArguments();
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(arguments.size()));
        Iterator<T> it = arguments.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), toAnnotationArgument((KmAnnotationArgument) entry.getValue(), kmAnnotation.getClassName(), (String) entry.getKey(), classLoader));
        }
        Object objCreateAnnotationInstance$default = AnnotationConstructorCallerKt.createAnnotationInstance$default(clsLoadClass$default, linkedHashMap, null, 4, null);
        Intrinsics.checkNotNull(objCreateAnnotationInstance$default, "null cannot be cast to non-null type kotlin.Annotation");
        return (Annotation) objCreateAnnotationInstance$default;
    }

    private static final Object toAnnotationArgument(KmAnnotationArgument kmAnnotationArgument, String str, String str2, ClassLoader classLoader) {
        List<KParameter> parameters;
        KType type;
        Class javaClass;
        Class<?> javaClass2;
        if (kmAnnotationArgument instanceof KmAnnotationArgument.AnnotationValue) {
            return toAnnotation(((KmAnnotationArgument.AnnotationValue) kmAnnotationArgument).getAnnotation(), classLoader);
        }
        int i = 0;
        if (kmAnnotationArgument instanceof KmAnnotationArgument.ArrayKClassValue) {
            KmAnnotationArgument.ArrayKClassValue arrayKClassValue = (KmAnnotationArgument.ArrayKClassValue) kmAnnotationArgument;
            KClass<?> kClassLoadKClass = loadKClass(classLoader, arrayKClassValue.getClassName());
            if (kClassLoadKClass == null || (javaClass2 = JvmClassMappingKt.getJavaClass((KClass) kClassLoadKClass)) == null) {
                throw new KotlinReflectionInternalError("Unresolved class: " + arrayKClassValue.getClassName());
            }
            int arrayDimensionCount = arrayKClassValue.getArrayDimensionCount();
            while (i < arrayDimensionCount) {
                javaClass2 = UtilKt.createArrayType(javaClass2);
                i++;
            }
            return javaClass2;
        }
        Object obj = null;
        if (kmAnnotationArgument instanceof KmAnnotationArgument.ArrayValue) {
            KClass<?> kClassLoadKClass2 = loadKClass(classLoader, str);
            if (kClassLoadKClass2 != null) {
                if (!JvmClassMappingKt.getJavaClass((KClass) kClassLoadKClass2).isAnnotation()) {
                    kClassLoadKClass2 = null;
                }
                if (kClassLoadKClass2 != null) {
                    KFunction kFunction = (KFunction) CollectionsKt.singleOrNull(kClassLoadKClass2.getConstructors());
                    if (kFunction != null && (parameters = kFunction.getParameters()) != null) {
                        Iterator<T> it = parameters.iterator();
                        boolean z = false;
                        Object obj2 = null;
                        while (true) {
                            if (!it.hasNext()) {
                                if (!z) {
                                    break;
                                }
                                break;
                            }
                            Object next = it.next();
                            if (Intrinsics.areEqual(((KParameter) next).getName(), str2)) {
                                if (!z) {
                                    z = true;
                                    obj2 = next;
                                }
                            }
                            obj2 = null;
                            break;
                        }
                        KParameter kParameter = (KParameter) obj2;
                        if (kParameter != null && (type = kParameter.getType()) != null) {
                            KClassifier classifier = type.getClassifier();
                            KClass kClass = classifier instanceof KClass ? (KClass) classifier : null;
                            if (kClass == null || (javaClass = JvmClassMappingKt.getJavaClass(kClass)) == null) {
                                throw new KotlinReflectionInternalError("Array parameter type is not a class: " + type);
                            }
                            KmAnnotationArgument.ArrayValue arrayValue = (KmAnnotationArgument.ArrayValue) kmAnnotationArgument;
                            Object objNewInstance = Array.newInstance(Intrinsics.areEqual(javaClass.getComponentType(), KClass.class) ? Class.class : javaClass.getComponentType(), arrayValue.getElements().size());
                            Iterator<T> it2 = arrayValue.getElements().iterator();
                            while (it2.hasNext()) {
                                Array.set(objNewInstance, i, toAnnotationArgument((KmAnnotationArgument) it2.next(), str, null, classLoader));
                                i++;
                            }
                            Intrinsics.checkNotNull(objNewInstance);
                            return objNewInstance;
                        }
                    }
                    throw new KotlinReflectionInternalError("No parameter " + str2 + " found in annotation constructor of " + str);
                }
            }
            throw new KotlinReflectionInternalError("Not an annotation class: " + str);
        }
        if (kmAnnotationArgument instanceof KmAnnotationArgument.EnumValue) {
            KmAnnotationArgument.EnumValue enumValue = (KmAnnotationArgument.EnumValue) kmAnnotationArgument;
            Class clsLoadClass$default = UtilKt.loadClass$default(classLoader, toClassId(enumValue.getEnumClassName()), 0, 2, null);
            if (clsLoadClass$default == null) {
                throw new KotlinReflectionInternalError("Unresolved enum class: " + enumValue.getEnumClassName());
            }
            Object[] enumConstants = clsLoadClass$default.getEnumConstants();
            Intrinsics.checkNotNullExpressionValue(enumConstants, "getEnumConstants(...)");
            int length = enumConstants.length;
            boolean z2 = false;
            Object obj3 = null;
            while (true) {
                if (i >= length) {
                    if (!z2) {
                        break;
                    }
                    obj = obj3;
                    break;
                }
                Object obj4 = enumConstants[i];
                Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Enum<*>");
                if (Intrinsics.areEqual(((Enum) obj4).name(), enumValue.getEnumEntryName())) {
                    if (z2) {
                        break;
                    }
                    obj3 = obj4;
                    z2 = true;
                }
                i++;
            }
            if (obj != null) {
                return obj;
            }
            throw new KotlinReflectionInternalError("Unresolved enum entry: " + enumValue.getEnumClassName() + FilenameUtils.EXTENSION_SEPARATOR + enumValue.getEnumEntryName());
        }
        if (kmAnnotationArgument instanceof KmAnnotationArgument.KClassValue) {
            KmAnnotationArgument.KClassValue kClassValue = (KmAnnotationArgument.KClassValue) kmAnnotationArgument;
            Class clsLoadClass$default2 = UtilKt.loadClass$default(classLoader, toClassId(kClassValue.getClassName()), 0, 2, null);
            if (clsLoadClass$default2 != null) {
                return clsLoadClass$default2;
            }
            throw new KotlinReflectionInternalError("Unresolved class: " + kClassValue.getClassName());
        }
        if (kmAnnotationArgument instanceof KmAnnotationArgument.LiteralValue) {
            return ((KmAnnotationArgument.LiteralValue) kmAnnotationArgument).getValue();
        }
        throw new NoWhenBranchMatchedException();
    }
}
