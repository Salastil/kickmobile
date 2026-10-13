package expo.modules.kotlin.types.descriptors;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: TypeDescriptor.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\n\u0010\u001b\u001a\u00020\u001cH\u0096\u0080\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u00108Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011R\u0016\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00138Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u00108Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0011R\u0018\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00000\u00188Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lexpo/modules/kotlin/types/descriptors/TypeDescriptor;", "", "typeInfo", "Lexpo/modules/kotlin/types/descriptors/RawTypeDescriptor;", "kTypeProvider", "Lkotlin/Function0;", "Lkotlin/reflect/KType;", "<init>", "(Lexpo/modules/kotlin/types/descriptors/RawTypeDescriptor;Lkotlin/jvm/functions/Function0;)V", "getTypeInfo", "()Lexpo/modules/kotlin/types/descriptors/RawTypeDescriptor;", "_kType", "kType", "getKType", "()Lkotlin/reflect/KType;", "isNullable", "", "()Z", "jClass", "Ljava/lang/Class;", "getJClass", "()Ljava/lang/Class;", "isStar", "params", "", "getParams", "()Ljava/util/List;", "toString", "", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class TypeDescriptor {
    public static final int $stable = 8;
    private KType _kType;
    private final Function0<KType> kTypeProvider;
    private final RawTypeDescriptor typeInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public TypeDescriptor(RawTypeDescriptor typeInfo, Function0<? extends KType> kTypeProvider) {
        Intrinsics.checkNotNullParameter(typeInfo, "typeInfo");
        Intrinsics.checkNotNullParameter(kTypeProvider, "kTypeProvider");
        this.typeInfo = typeInfo;
        this.kTypeProvider = kTypeProvider;
    }

    public final RawTypeDescriptor getTypeInfo() {
        return this.typeInfo;
    }

    public final KType getKType() {
        if (this._kType == null) {
            this._kType = this.kTypeProvider.invoke();
        }
        KType kType = this._kType;
        Intrinsics.checkNotNull(kType);
        return kType;
    }

    public final boolean isNullable() {
        return getTypeInfo().isNullable();
    }

    public final Class<?> getJClass() {
        return getTypeInfo().getJClass();
    }

    public final boolean isStar() {
        return Intrinsics.areEqual(getTypeInfo(), RawTypeDescriptor.Star.INSTANCE);
    }

    public final List<TypeDescriptor> getParams() {
        RawTypeDescriptor typeInfo = getTypeInfo();
        if (typeInfo instanceof RawTypeDescriptor.Simple) {
            return CollectionsKt.emptyList();
        }
        if (!(typeInfo instanceof RawTypeDescriptor.Parameterized)) {
            if (Intrinsics.areEqual(typeInfo, RawTypeDescriptor.Star.INSTANCE)) {
                return CollectionsKt.emptyList();
            }
            throw new NoWhenBranchMatchedException();
        }
        List<RawTypeDescriptor> params = ((RawTypeDescriptor.Parameterized) getTypeInfo()).getParams();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(params, 10));
        int i = 0;
        for (Object obj : params) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(new TypeDescriptor((RawTypeDescriptor) obj, new TypeDescriptor$params$1$1(this, i)));
            i = i2;
        }
        return arrayList;
    }

    static final CharSequence toString$lambda$0(TypeDescriptor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.toString();
    }

    public String toString() {
        ArrayList arrayListEmptyList;
        String strJoinToString$default;
        ArrayList arrayListEmptyList2;
        RawTypeDescriptor typeInfo = getTypeInfo();
        int i = 0;
        if (typeInfo instanceof RawTypeDescriptor.Simple) {
            arrayListEmptyList = CollectionsKt.emptyList();
        } else if (typeInfo instanceof RawTypeDescriptor.Parameterized) {
            List<RawTypeDescriptor> params = ((RawTypeDescriptor.Parameterized) getTypeInfo()).getParams();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(params, 10));
            int i2 = 0;
            for (Object obj : params) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                arrayList.add(new TypeDescriptor((RawTypeDescriptor) obj, new TypeDescriptor$params$1$1(this, i2)));
                i2 = i3;
            }
            arrayListEmptyList = arrayList;
        } else {
            if (!Intrinsics.areEqual(typeInfo, RawTypeDescriptor.Star.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            arrayListEmptyList = CollectionsKt.emptyList();
        }
        if (arrayListEmptyList.isEmpty()) {
            strJoinToString$default = "";
        } else {
            RawTypeDescriptor typeInfo2 = getTypeInfo();
            if (typeInfo2 instanceof RawTypeDescriptor.Simple) {
                arrayListEmptyList2 = CollectionsKt.emptyList();
            } else if (typeInfo2 instanceof RawTypeDescriptor.Parameterized) {
                List<RawTypeDescriptor> params2 = ((RawTypeDescriptor.Parameterized) getTypeInfo()).getParams();
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(params2, 10));
                for (Object obj2 : params2) {
                    int i4 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    arrayList2.add(new TypeDescriptor((RawTypeDescriptor) obj2, new TypeDescriptor$params$1$1(this, i)));
                    i = i4;
                }
                arrayListEmptyList2 = arrayList2;
            } else {
                if (!Intrinsics.areEqual(typeInfo2, RawTypeDescriptor.Star.INSTANCE)) {
                    throw new NoWhenBranchMatchedException();
                }
                arrayListEmptyList2 = CollectionsKt.emptyList();
            }
            strJoinToString$default = CollectionsKt.joinToString$default(arrayListEmptyList2, ", ", "<", ">", 0, null, new Function1() { // from class: expo.modules.kotlin.types.descriptors.TypeDescriptor$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj3) {
                    return TypeDescriptor.toString$lambda$0((TypeDescriptor) obj3);
                }
            }, 24, null);
        }
        return getTypeInfo().getJClass() + strJoinToString$default + (getTypeInfo().isNullable() ? "?" : "");
    }
}
