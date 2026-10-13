package kotlin.reflect.jvm.internal.types;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;
import kotlin.reflect.full.KClassifiers;
import kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;

/* JADX INFO: compiled from: KTypeSubstitutor.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nJ\u0014\u0010\u000b\u001a\u00020\n*\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\f\u0010\r\u001a\u00020\u0005*\u00020\u0005H\u0002J\f\u0010\u000e\u001a\u00020\u0005*\u00020\u0005H\u0002R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkotlin/reflect/jvm/internal/types/KTypeSubstitutor;", "", "substitution", "", "Lkotlin/reflect/KTypeParameter;", "Lkotlin/reflect/KTypeProjection;", "<init>", "(Ljava/util/Map;)V", "substitute", "type", "Lkotlin/reflect/KType;", "withNullabilityOf", "other", "lowerBoundIfFlexible", "upperBoundIfFlexible", "Companion", "kotlin-reflection"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class KTypeSubstitutor {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KTypeSubstitutor EMPTY = new KTypeSubstitutor(MapsKt.emptyMap());
    private final Map<KTypeParameter, KTypeProjection> substitution;

    public KTypeSubstitutor(Map<KTypeParameter, KTypeProjection> substitution) {
        Intrinsics.checkNotNullParameter(substitution, "substitution");
        this.substitution = substitution;
    }

    public final KTypeProjection substitute(KType type) {
        KTypeProjection star;
        Intrinsics.checkNotNullParameter(type, "type");
        boolean z = type instanceof AbstractKType;
        AbstractKType abstractKType = z ? (AbstractKType) type : null;
        AbstractKType lowerBound = abstractKType != null ? abstractKType.getLowerBound() : null;
        AbstractKType abstractKType2 = z ? (AbstractKType) type : null;
        AbstractKType upperBound = abstractKType2 != null ? abstractKType2.getUpperBound() : null;
        if (lowerBound != null && upperBound != null) {
            KTypeProjection kTypeProjectionLowerBoundIfFlexible = lowerBoundIfFlexible(substitute(lowerBound));
            KTypeProjection kTypeProjectionUpperBoundIfFlexible = upperBoundIfFlexible(substitute(upperBound));
            KVariance variance = kTypeProjectionLowerBoundIfFlexible.getVariance();
            KType type2 = kTypeProjectionLowerBoundIfFlexible.getType();
            Intrinsics.checkNotNull(type2);
            KType type3 = kTypeProjectionUpperBoundIfFlexible.getType();
            Intrinsics.checkNotNull(type3);
            return new KTypeProjection(variance, TypeOfImplKt.createPlatformKType(type2, type3));
        }
        KClassifier classifier = type.getClassifier();
        if (classifier == null) {
            return KTypeProjection.INSTANCE.invariant(type);
        }
        KTypeProjection kTypeProjection = this.substitution.get(classifier);
        if (kTypeProjection != null) {
            KVariance variance2 = kTypeProjection.getVariance();
            KType type4 = kTypeProjection.getType();
            return type4 == null ? kTypeProjection : new KTypeProjection(variance2, withNullabilityOf(type4, type));
        }
        KTypeProjection.Companion companion = KTypeProjection.INSTANCE;
        if (!type.getArguments().isEmpty()) {
            List<KTypeProjection> arguments = type.getArguments();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(arguments, 10));
            Iterator<T> it = arguments.iterator();
            while (it.hasNext()) {
                KType type5 = ((KTypeProjection) it.next()).getType();
                if (type5 == null || (star = substitute(type5)) == null) {
                    star = KTypeProjection.INSTANCE.getSTAR();
                }
                arrayList.add(star);
            }
            ArrayList arrayList2 = arrayList;
            boolean isMarkedNullable = type.getIsMarkedNullable();
            List<Annotation> annotations = type.getAnnotations();
            AbstractKType abstractKType3 = z ? (AbstractKType) type : null;
            type = KClassifiers.createTypeImpl(classifier, arrayList2, isMarkedNullable, annotations, abstractKType3 != null ? abstractKType3.getMutableCollectionClass() : null);
        }
        return companion.invariant(type);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0050  */
    private final KType withNullabilityOf(KType kType, KType kType2) {
        Intrinsics.checkNotNull(kType, "null cannot be cast to non-null type org.jetbrains.kotlin.types.model.RigidTypeMarker");
        RigidTypeMarker rigidTypeMarker = (RigidTypeMarker) kType;
        ReflectTypeSystemContext reflectTypeSystemContext = ReflectTypeSystemContext.INSTANCE;
        boolean z = false;
        AbstractKType abstractKTypeWithNullability = ReflectTypeSystemContext.INSTANCE.withNullability(rigidTypeMarker, kType2.getIsMarkedNullable() || kType.getIsMarkedNullable());
        if (abstractKTypeWithNullability instanceof AbstractKType) {
            AbstractKType abstractKType = (AbstractKType) abstractKTypeWithNullability;
            AbstractKType abstractKType2 = kType2 instanceof AbstractKType ? (AbstractKType) kType2 : null;
            if (abstractKType2 == null || !abstractKType2.getIsDefinitelyNotNullType()) {
                AbstractKType abstractKType3 = rigidTypeMarker instanceof AbstractKType ? (AbstractKType) rigidTypeMarker : null;
                if (abstractKType3 != null && abstractKType3.getIsDefinitelyNotNullType() && !kType2.getIsMarkedNullable()) {
                    z = true;
                }
            } else {
                z = true;
            }
            abstractKTypeWithNullability = abstractKType.makeDefinitelyNotNullAsSpecified(z);
        }
        Intrinsics.checkNotNull(abstractKTypeWithNullability, "null cannot be cast to non-null type kotlin.reflect.KType");
        return (KType) abstractKTypeWithNullability;
    }

    private final KTypeProjection lowerBoundIfFlexible(KTypeProjection kTypeProjection) {
        AbstractKType lowerBound;
        KType type = kTypeProjection.getType();
        AbstractKType abstractKType = type instanceof AbstractKType ? (AbstractKType) type : null;
        return (abstractKType == null || (lowerBound = abstractKType.getLowerBound()) == null) ? kTypeProjection : new KTypeProjection(kTypeProjection.getVariance(), lowerBound);
    }

    private final KTypeProjection upperBoundIfFlexible(KTypeProjection kTypeProjection) {
        AbstractKType upperBound;
        KType type = kTypeProjection.getType();
        AbstractKType abstractKType = type instanceof AbstractKType ? (AbstractKType) type : null;
        return (abstractKType == null || (upperBound = abstractKType.getUpperBound()) == null) ? kTypeProjection : new KTypeProjection(kTypeProjection.getVariance(), upperBound);
    }

    /* JADX INFO: compiled from: KTypeSubstitutor.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nJ \u0010\b\u001a\u00020\u00052\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lkotlin/reflect/jvm/internal/types/KTypeSubstitutor$Companion;", "", "<init>", "()V", "EMPTY", "Lkotlin/reflect/jvm/internal/types/KTypeSubstitutor;", "getEMPTY", "()Lkotlin/reflect/jvm/internal/types/KTypeSubstitutor;", "create", "type", "Lkotlin/reflect/KType;", "klass", "Lkotlin/reflect/KClass;", "arguments", "", "Lkotlin/reflect/KTypeProjection;", "kotlin-reflection"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KTypeSubstitutor getEMPTY() {
            return KTypeSubstitutor.EMPTY;
        }

        public final KTypeSubstitutor create(KType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            ReflectTypeSystemContext reflectTypeSystemContext = ReflectTypeSystemContext.INSTANCE;
            TypeConstructorMarker typeConstructorMarkerTypeConstructor = reflectTypeSystemContext.typeConstructor((RigidTypeMarker) type);
            int iParametersCount = reflectTypeSystemContext.parametersCount(typeConstructorMarkerTypeConstructor);
            ArrayList arrayList = new ArrayList(iParametersCount);
            for (int i = 0; i < iParametersCount; i++) {
                TypeParameterMarker parameter = reflectTypeSystemContext.getParameter(typeConstructorMarkerTypeConstructor, i);
                Intrinsics.checkNotNull(parameter, "null cannot be cast to non-null type kotlin.reflect.KTypeParameter");
                arrayList.add((KTypeParameter) parameter);
            }
            ArrayList arrayList2 = arrayList;
            return !arrayList2.isEmpty() ? new KTypeSubstitutor(MapsKt.toMap(CollectionsKt.zip(arrayList2, type.getArguments()))) : getEMPTY();
        }

        public final KTypeSubstitutor create(KClass<?> klass, List<KTypeProjection> arguments) {
            Intrinsics.checkNotNullParameter(klass, "klass");
            Intrinsics.checkNotNullParameter(arguments, "arguments");
            return new KTypeSubstitutor(MapsKt.toMap(CollectionsKt.zip(CapturedKTypeKt.allTypeParameters(klass), arguments)));
        }
    }
}
