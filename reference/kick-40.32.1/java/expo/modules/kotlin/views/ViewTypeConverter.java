package expo.modules.kotlin.views;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.jni.CppType;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.types.ConverterContext;
import expo.modules.kotlin.types.NonNullableTypeConverter;
import expo.modules.kotlin.types.descriptors.TypeDescriptor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewTypeConverter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lexpo/modules/kotlin/views/ViewTypeConverter;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "Lexpo/modules/kotlin/types/NonNullableTypeConverter;", "typeDescriptor", "Lexpo/modules/kotlin/types/descriptors/TypeDescriptor;", "<init>", "(Lexpo/modules/kotlin/types/descriptors/TypeDescriptor;)V", "getTypeDescriptor", "()Lexpo/modules/kotlin/types/descriptors/TypeDescriptor;", "convertNonNullable", "value", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lexpo/modules/kotlin/types/ConverterContext;", "forceConversion", "", "(Ljava/lang/Object;Lexpo/modules/kotlin/types/ConverterContext;Z)Landroid/view/View;", "getCppRequiredTypes", "Lexpo/modules/kotlin/jni/ExpectedType;", "isTrivial", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ViewTypeConverter<T extends View> extends NonNullableTypeConverter<T> {
    public static final int $stable = 8;
    private final TypeDescriptor typeDescriptor;

    @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
    public boolean isTrivial() {
        return false;
    }

    public ViewTypeConverter(TypeDescriptor typeDescriptor) {
        Intrinsics.checkNotNullParameter(typeDescriptor, "typeDescriptor");
        this.typeDescriptor = typeDescriptor;
    }

    public final TypeDescriptor getTypeDescriptor() {
        return this.typeDescriptor;
    }

    @Override // expo.modules.kotlin.types.NonNullableTypeConverter
    public T convertNonNullable(Object value, ConverterContext context, boolean forceConversion) throws Exceptions.ViewNotFound {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(context, "context");
        context.assertMainThread();
        int iIntValue = ((Integer) value).intValue();
        T t = (T) context.findView(iIntValue);
        if (t != null) {
            return t;
        }
        throw new Exceptions.ViewNotFound(this.typeDescriptor.getTypeInfo().getJClass(), iIntValue);
    }

    @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
    public ExpectedType getCppRequiredTypes() {
        return new ExpectedType(CppType.INT, CppType.VIEW_TAG);
    }
}
