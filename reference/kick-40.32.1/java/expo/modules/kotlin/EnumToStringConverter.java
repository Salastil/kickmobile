package expo.modules.kotlin;

import androidx.exifinterface.media.ExifInterface;
import java.lang.Enum;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EnumToStringConverter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0001\u0018\u0000*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00022\u00020\u0003B\u0017\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00028\u0000¢\u0006\u0002\u0010\u0013R\u0019\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001f\u0010\n\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lexpo/modules/kotlin/EnumToStringConverter;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "enumClass", "Ljava/lang/Class;", "<init>", "(Ljava/lang/Class;)V", "getEnumClass", "()Ljava/lang/Class;", "fields", "", "Ljava/lang/reflect/Field;", "kotlin.jvm.PlatformType", "getFields", "()Ljava/util/List;", "convert", "", "enumValue", "(Ljava/lang/Enum;)Ljava/lang/String;", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class EnumToStringConverter<T extends Enum<?>> {
    public static final int $stable = 8;
    private final Class<? extends T> enumClass;
    private final List<Field> fields;

    public EnumToStringConverter(Class<? extends T> enumClass) {
        Intrinsics.checkNotNullParameter(enumClass, "enumClass");
        this.enumClass = enumClass;
        Field[] declaredFields = enumClass.getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(declaredFields, "getDeclaredFields(...)");
        ArrayList arrayList = new ArrayList();
        for (Field field : declaredFields) {
            Field field2 = field;
            if (!Modifier.isStatic(field2.getModifiers()) && !field2.isSynthetic()) {
                arrayList.add(field);
            }
        }
        this.fields = arrayList;
    }

    public final Class<? extends T> getEnumClass() {
        return this.enumClass;
    }

    public final List<Field> getFields() {
        return this.fields;
    }

    public final String convert(T enumValue) throws IllegalAccessException {
        Intrinsics.checkNotNullParameter(enumValue, "enumValue");
        if (this.fields.isEmpty()) {
            return enumValue.name();
        }
        if (this.fields.size() != 1) {
            throw new IllegalStateException(("Can't convert " + this.enumClass + " to string").toString());
        }
        Field field = (Field) CollectionsKt.first((List) this.fields);
        field.setAccessible(true);
        Object obj = field.get(enumValue);
        String str = obj instanceof String ? (String) obj : null;
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("The enum parameter has to be a string.".toString());
    }
}
