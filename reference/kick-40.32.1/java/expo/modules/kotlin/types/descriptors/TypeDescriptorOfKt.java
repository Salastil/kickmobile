package expo.modules.kotlin.types.descriptors;

import androidx.exifinterface.media.ExifInterface;
import io.github.expo.pika.PIntrospectionData;
import io.github.expo.pika.PTypeDescriptor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: typeDescriptorOf.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0001\u001a\u0011\u0010\u0003\u001a\u00020\u0004\"\u0006\b\u0000\u0010\u0005\u0018\u0001H\u0081\b\u001a\u0011\u0010\u0006\u001a\u00020\u0004\"\u0006\b\u0000\u0010\u0005\u0018\u0001H\u0086\b¨\u0006\u0007"}, d2 = {"toRawTypeDescriptor", "Lexpo/modules/kotlin/types/descriptors/RawTypeDescriptor;", "Lio/github/expo/pika/PTypeDescriptor;", "ctTypeDescriptorOf", "Lexpo/modules/kotlin/types/descriptors/TypeDescriptor;", ExifInterface.GPS_DIRECTION_TRUE, "typeDescriptorOf", "expo-modules-core_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class TypeDescriptorOfKt {
    public static final RawTypeDescriptor toRawTypeDescriptor(PTypeDescriptor pTypeDescriptor) {
        Intrinsics.checkNotNullParameter(pTypeDescriptor, "<this>");
        if (pTypeDescriptor instanceof PTypeDescriptor.Concrete) {
            if (pTypeDescriptor instanceof PTypeDescriptor.Concrete.Parameterized) {
                PTypeDescriptor.Concrete.Parameterized parameterized = (PTypeDescriptor.Concrete.Parameterized) pTypeDescriptor;
                Class<?> jClass = parameterized.getPType().getJClass();
                boolean zIsNullable = parameterized.getIsNullable();
                PIntrospectionData<?> introspection = parameterized.getIntrospection();
                List<PTypeDescriptor> parameters = parameterized.getParameters();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(parameters, 10));
                Iterator<T> it = parameters.iterator();
                while (it.hasNext()) {
                    arrayList.add(toRawTypeDescriptor((PTypeDescriptor) it.next()));
                }
                return new RawTypeDescriptor.Parameterized(jClass, zIsNullable, introspection, arrayList);
            }
            PTypeDescriptor.Concrete concrete = (PTypeDescriptor.Concrete) pTypeDescriptor;
            return new RawTypeDescriptor.Simple(concrete.getPType().getJClass(), concrete.getIsNullable(), concrete.getIntrospection());
        }
        if (Intrinsics.areEqual(pTypeDescriptor, PTypeDescriptor.Star.INSTANCE)) {
            return RawTypeDescriptor.Star.INSTANCE;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final /* synthetic */ <T> TypeDescriptor ctTypeDescriptorOf() {
        Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
        PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError = io.github.expo.pika.TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
        MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
        RawTypeDescriptor rawTypeDescriptor = toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError);
        Intrinsics.needClassReification();
        return new TypeDescriptor(rawTypeDescriptor, new Function0<KType>() { // from class: expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt$ctTypeDescriptorOf$kTypeProvider$1
            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
                return null;
            }
        });
    }

    public static final /* synthetic */ <T> TypeDescriptor typeDescriptorOf() {
        Object objM12684constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
            PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError = io.github.expo.pika.TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
            MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
            RawTypeDescriptor rawTypeDescriptor = toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError);
            Intrinsics.needClassReification();
            Intrinsics.needClassReification();
            objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(rawTypeDescriptor, new Function0<KType>() { // from class: expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt$typeDescriptorOf$$inlined$runCatching$lambda$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
                    return null;
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
        if (typeDescriptor != null) {
            return typeDescriptor;
        }
        Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
        return TypeDescriptorKt.toTypeDescriptor(null);
    }
}
