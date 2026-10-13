package expo.modules.kotlin.types;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.kotlin.jni.CppType;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.jni.JavaScriptFunction;
import expo.modules.kotlin.types.descriptors.RawTypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptor$params$1$1;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JavaScriptFunctionTypeConverter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00040\u0003B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ&\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lexpo/modules/kotlin/types/JavaScriptFunctionTypeConverter;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lexpo/modules/kotlin/types/NonNullableTypeConverter;", "Lexpo/modules/kotlin/jni/JavaScriptFunction;", "typeDescriptor", "Lexpo/modules/kotlin/types/descriptors/TypeDescriptor;", "<init>", "(Lexpo/modules/kotlin/types/descriptors/TypeDescriptor;)V", "getTypeDescriptor", "()Lexpo/modules/kotlin/types/descriptors/TypeDescriptor;", "convertNonNullable", "value", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lexpo/modules/kotlin/types/ConverterContext;", "forceConversion", "", "getCppRequiredTypes", "Lexpo/modules/kotlin/jni/ExpectedType;", "isTrivial", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class JavaScriptFunctionTypeConverter<T> extends NonNullableTypeConverter<JavaScriptFunction<T>> {
    public static final int $stable = 8;
    private final TypeDescriptor typeDescriptor;

    @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
    public boolean isTrivial() {
        return false;
    }

    public JavaScriptFunctionTypeConverter(TypeDescriptor typeDescriptor) {
        Intrinsics.checkNotNullParameter(typeDescriptor, "typeDescriptor");
        this.typeDescriptor = typeDescriptor;
    }

    public final TypeDescriptor getTypeDescriptor() {
        return this.typeDescriptor;
    }

    @Override // expo.modules.kotlin.types.NonNullableTypeConverter
    public JavaScriptFunction<T> convertNonNullable(Object value, ConverterContext context, boolean forceConversion) {
        ArrayList arrayListEmptyList;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(context, "context");
        JavaScriptFunction<T> javaScriptFunction = (JavaScriptFunction) value;
        TypeDescriptor typeDescriptor = this.typeDescriptor;
        RawTypeDescriptor typeInfo = typeDescriptor.getTypeInfo();
        if (typeInfo instanceof RawTypeDescriptor.Simple) {
            arrayListEmptyList = CollectionsKt.emptyList();
        } else if (typeInfo instanceof RawTypeDescriptor.Parameterized) {
            List<RawTypeDescriptor> params = ((RawTypeDescriptor.Parameterized) typeDescriptor.getTypeInfo()).getParams();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(params, 10));
            int i = 0;
            for (T t : params) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                arrayList.add(new TypeDescriptor((RawTypeDescriptor) t, new TypeDescriptor$params$1$1(typeDescriptor, i)));
                i = i2;
            }
            arrayListEmptyList = arrayList;
        } else {
            if (!Intrinsics.areEqual(typeInfo, RawTypeDescriptor.Star.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            arrayListEmptyList = CollectionsKt.emptyList();
        }
        Object objFirst = CollectionsKt.first((List<? extends Object>) arrayListEmptyList);
        if (objFirst == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        javaScriptFunction.setReturnType((TypeDescriptor) objFirst);
        return javaScriptFunction;
    }

    @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
    /* JADX INFO: renamed from: getCppRequiredTypes */
    public ExpectedType get$cppRequireType() {
        return new ExpectedType(CppType.JS_FUNCTION);
    }
}
