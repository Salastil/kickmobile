package expo.modules.kotlin.types.descriptors;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

/* JADX INFO: compiled from: TypeDescriptor.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toTypeDescriptor", "Lexpo/modules/kotlin/types/descriptors/TypeDescriptor;", "Lkotlin/reflect/KType;", "expo-modules-core_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class TypeDescriptorKt {
    static final KType toTypeDescriptor$lambda$2(KType kType) {
        return kType;
    }

    public static final TypeDescriptor toTypeDescriptor(final KType kType) {
        RawTypeDescriptor.Parameterized parameterized;
        TypeDescriptor typeDescriptor;
        Intrinsics.checkNotNullParameter(kType, "<this>");
        KClassifier classifier = kType.getClassifier();
        KClass kClass = classifier instanceof KClass ? (KClass) classifier : null;
        if (kClass == null) {
            throw new IllegalStateException(("Unsupported type: " + kType).toString());
        }
        boolean isMarkedNullable = kType.getIsMarkedNullable();
        List<KTypeProjection> arguments = kType.getArguments();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(arguments, 10));
        for (KTypeProjection kTypeProjection : arguments) {
            if (kTypeProjection.getVariance() == null) {
                typeDescriptor = new TypeDescriptor(RawTypeDescriptor.Star.INSTANCE, new Function0() { // from class: expo.modules.kotlin.types.descriptors.TypeDescriptorKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TypeDescriptorKt.toTypeDescriptor$lambda$0$0();
                    }
                });
            } else {
                KType type = kTypeProjection.getType();
                if (type == null) {
                    throw new IllegalStateException(("Type argument is missing for " + kType).toString());
                }
                typeDescriptor = toTypeDescriptor(type);
            }
            arrayList.add(typeDescriptor);
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            parameterized = new RawTypeDescriptor.Simple(JvmClassMappingKt.getJavaClass(kClass), isMarkedNullable, null);
        } else {
            Class javaClass = JvmClassMappingKt.getJavaClass(kClass);
            ArrayList arrayList3 = arrayList2;
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                arrayList4.add(((TypeDescriptor) it.next()).getTypeInfo());
            }
            parameterized = new RawTypeDescriptor.Parameterized(javaClass, isMarkedNullable, null, arrayList4);
        }
        return new TypeDescriptor(parameterized, new Function0() { // from class: expo.modules.kotlin.types.descriptors.TypeDescriptorKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TypeDescriptorKt.toTypeDescriptor$lambda$2(kType);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KType toTypeDescriptor$lambda$0$0() {
        throw new IllegalStateException("Star projection doesn't have type".toString());
    }
}
