package expo.modules.kotlin.types;

import expo.modules.kotlin.types.descriptors.RawTypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptor$params$1$1;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ArrayTypeConverter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, d2 = {"isPrimitiveArray", "", "typeDescriptor", "Lexpo/modules/kotlin/types/descriptors/TypeDescriptor;", "expo-modules-core_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ArrayTypeConverterKt {
    public static final boolean isPrimitiveArray(TypeDescriptor typeDescriptor) {
        ArrayList arrayListEmptyList;
        Intrinsics.checkNotNullParameter(typeDescriptor, "typeDescriptor");
        Class<?> jClass = typeDescriptor.getTypeInfo().getJClass();
        int i = 0;
        if (!Intrinsics.areEqual(jClass, boolean[].class) && !Intrinsics.areEqual(jClass, byte[].class) && !Intrinsics.areEqual(jClass, char[].class) && !Intrinsics.areEqual(jClass, short[].class) && !Intrinsics.areEqual(jClass, int[].class) && !Intrinsics.areEqual(jClass, long[].class) && !Intrinsics.areEqual(jClass, float[].class) && !Intrinsics.areEqual(jClass, double[].class)) {
            return false;
        }
        RawTypeDescriptor typeInfo = typeDescriptor.getTypeInfo();
        if (typeInfo instanceof RawTypeDescriptor.Simple) {
            arrayListEmptyList = CollectionsKt.emptyList();
        } else if (typeInfo instanceof RawTypeDescriptor.Parameterized) {
            List<RawTypeDescriptor> params = ((RawTypeDescriptor.Parameterized) typeDescriptor.getTypeInfo()).getParams();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(params, 10));
            for (Object obj : params) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                arrayList.add(new TypeDescriptor((RawTypeDescriptor) obj, new TypeDescriptor$params$1$1(typeDescriptor, i)));
                i = i2;
            }
            arrayListEmptyList = arrayList;
        } else {
            if (!Intrinsics.areEqual(typeInfo, RawTypeDescriptor.Star.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            arrayListEmptyList = CollectionsKt.emptyList();
        }
        return arrayListEmptyList.isEmpty();
    }
}
