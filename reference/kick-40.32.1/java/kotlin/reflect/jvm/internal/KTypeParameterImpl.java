package kotlin.reflect.jvm.internal;

import com.datadog.android.webview.internal.rum.WebViewRumEventMapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeParameterReference;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVariance;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.types.DescriptorKType;

/* JADX INFO: compiled from: KTypeParameterImpl.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BE\b\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011B)\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0013B\u001b\b\u0016\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u0014J\u0014\u0010&\u001a\u00020\u000f2\b\u0010'\u001a\u0004\u0018\u00010(H\u0096\u0082\u0004J\n\u0010)\u001a\u00020*H\u0096\u0080\u0004J\n\u0010+\u001a\u00020\u000bH\u0096\u0080\u0004R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\n\u001a\u00020\u000bX\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\f\u001a\u00020\rX\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\u000e\u001a\u00020\u000fX\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR!\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0096®\b¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0014\u0010\u0012\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u0006,"}, d2 = {"Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "Lkotlin/reflect/KTypeParameter;", "Lkotlin/reflect/jvm/internal/impl/types/model/TypeParameterMarker;", "Lkotlin/reflect/jvm/internal/impl/types/model/TypeConstructorMarker;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/TypeParameterDescriptor;", "_container", "Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "computeContainer", "Lkotlin/Function0;", "name", "", "variance", "Lkotlin/reflect/KVariance;", "isReified", "", "<init>", "(Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Lkotlin/reflect/KVariance;Z)V", WebViewRumEventMapper.CONTAINER_KEY_NAME, "(Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;Ljava/lang/String;Lkotlin/reflect/KVariance;Z)V", "(Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;)V", "getName", "()Ljava/lang/String;", "getVariance", "()Lkotlin/reflect/KVariance;", "()Z", "_descriptor", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;", "upperBounds", "", "Lkotlin/reflect/KType;", "getUpperBounds", "()Ljava/util/List;", "setUpperBounds", "(Ljava/util/List;)V", "getContainer", "()Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "equals", "other", "", "hashCode", "", "toString", "kotlin-reflection"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class KTypeParameterImpl implements KTypeParameter, TypeConstructorMarker, TypeParameterMarker {
    private final KTypeParameterOwnerImpl _container;
    private final TypeParameterDescriptor _descriptor;
    private final Function0<KTypeParameterOwnerImpl> computeContainer;
    private final boolean isReified;
    private final String name;
    public volatile List<? extends KType> upperBounds;
    private final KVariance variance;

    public final TypeParameterDescriptor getDescriptor() {
        TypeParameterDescriptor typeParameterDescriptor = this._descriptor;
        if (typeParameterDescriptor != null) {
            return typeParameterDescriptor;
        }
        throw new IllegalStateException(("Descriptor-less type parameter: " + this).toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private KTypeParameterImpl(TypeParameterDescriptor typeParameterDescriptor, KTypeParameterOwnerImpl kTypeParameterOwnerImpl, Function0<? extends KTypeParameterOwnerImpl> function0, String str, KVariance kVariance, boolean z) {
        this._container = kTypeParameterOwnerImpl;
        this.computeContainer = function0;
        this.name = str;
        this.variance = kVariance;
        this.isReified = z;
        this._descriptor = typeParameterDescriptor;
    }

    @Override // kotlin.reflect.KTypeParameter
    public String getName() {
        return this.name;
    }

    @Override // kotlin.reflect.KTypeParameter
    public KVariance getVariance() {
        return this.variance;
    }

    @Override // kotlin.reflect.KTypeParameter
    /* JADX INFO: renamed from: isReified, reason: from getter */
    public boolean getIsReified() {
        return this.isReified;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KTypeParameterImpl(KTypeParameterOwnerImpl container, String name, KVariance variance, boolean z) {
        this(null, container, null, name, variance, z);
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(variance, "variance");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public KTypeParameterImpl(KTypeParameterOwnerImpl kTypeParameterOwnerImpl, final TypeParameterDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        ReflectProperties.LazySoftVal lazySoftValLazySoft = ReflectProperties.lazySoft(new Function0(descriptor) { // from class: kotlin.reflect.jvm.internal.KTypeParameterImpl$$Lambda$0
            private final TypeParameterDescriptor arg$0;

            {
                this.arg$0 = descriptor;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return KTypeParameterImplKt.toContainer(this.arg$0);
            }
        });
        String strAsString = descriptor.getName().asString();
        Intrinsics.checkNotNullExpressionValue(strAsString, "asString(...)");
        Variance variance = descriptor.getVariance();
        Intrinsics.checkNotNullExpressionValue(variance, "getVariance(...)");
        this(descriptor, kTypeParameterOwnerImpl, lazySoftValLazySoft, strAsString, KTypeParameterImplKt.toKVariance(variance), descriptor.isReified());
        List<KotlinType> upperBounds = descriptor.getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(upperBounds, "getUpperBounds(...)");
        List<KotlinType> list = upperBounds;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new DescriptorKType((KotlinType) it.next(), null, 2, null));
        }
        setUpperBounds(arrayList);
    }

    @Override // kotlin.reflect.KTypeParameter
    public List<KType> getUpperBounds() {
        List list = this.upperBounds;
        if (list != null) {
            return list;
        }
        Intrinsics.throwUninitializedPropertyAccessException("upperBounds");
        return null;
    }

    public void setUpperBounds(List<? extends KType> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.upperBounds = list;
    }

    private final KTypeParameterOwnerImpl getContainer() {
        KTypeParameterOwnerImpl kTypeParameterOwnerImpl = this._container;
        if (kTypeParameterOwnerImpl != null) {
            return kTypeParameterOwnerImpl;
        }
        Function0<KTypeParameterOwnerImpl> function0 = this.computeContainer;
        Intrinsics.checkNotNull(function0);
        return function0.invoke();
    }

    public boolean equals(Object other) {
        if (!(other instanceof KTypeParameterImpl)) {
            return false;
        }
        KTypeParameterImpl kTypeParameterImpl = (KTypeParameterImpl) other;
        return Intrinsics.areEqual(getContainer(), kTypeParameterImpl.getContainer()) && Intrinsics.areEqual(getName(), kTypeParameterImpl.getName());
    }

    public int hashCode() {
        return (getContainer().hashCode() * 31) + getName().hashCode();
    }

    public String toString() {
        return TypeParameterReference.INSTANCE.toString(this);
    }
}
