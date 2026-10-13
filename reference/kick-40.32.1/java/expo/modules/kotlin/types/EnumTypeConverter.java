package expo.modules.kotlin.types;

import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.bridge.Dynamic;
import expo.modules.core.logging.Logger;
import expo.modules.kotlin.CoreLoggerKt;
import expo.modules.kotlin.ReadableTypeExtensionsKt;
import expo.modules.kotlin.exception.DynamicCastException;
import expo.modules.kotlin.exception.EnumNoSuchValueException;
import expo.modules.kotlin.exception.IncompatibleArgTypeException;
import expo.modules.kotlin.jni.ExpectedType;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: EnumTypeConverter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J$\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0011H\u0016J$\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0013\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0011H\u0016J-\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0012\u0010\u0007\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00020\bH\u0002¢\u0006\u0002\u0010\u001dJ5\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u001f\u001a\u00020\u00192\u0012\u0010\u0007\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00020\b2\u0006\u0010 \u001a\u00020\rH\u0002¢\u0006\u0002\u0010!J\u001a\u0010\"\u001a\u0004\u0018\u00010\u0019*\u00020\u00192\n\u0010#\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0007\u001a\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\u0002\b\u0003 \t*\b\u0012\u0002\b\u0003\u0018\u00010\u00020\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lexpo/modules/kotlin/types/EnumTypeConverter;", "Lexpo/modules/kotlin/types/DynamicAwareTypeConverters;", "", "enumClass", "Ljava/lang/Class;", "<init>", "(Ljava/lang/Class;)V", "enumConstants", "", "kotlin.jvm.PlatformType", "[Ljava/lang/Enum;", "userFields", "", "Ljava/lang/reflect/Field;", "getCppRequiredTypes", "Lexpo/modules/kotlin/jni/ExpectedType;", "isTrivial", "", "convertFromDynamic", "value", "Lcom/facebook/react/bridge/Dynamic;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lexpo/modules/kotlin/types/ConverterContext;", "forceConversion", "convertFromAny", "", "convertEnumWithoutParameter", "stringRepresentation", "", "(Ljava/lang/String;[Ljava/lang/Enum;)Ljava/lang/Enum;", "convertEnumWithParameter", "jsValue", "field", "(Ljava/lang/Object;[Ljava/lang/Enum;Ljava/lang/reflect/Field;)Ljava/lang/Enum;", "unwrapValue", "parameterType", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class EnumTypeConverter extends DynamicAwareTypeConverters<Enum<?>> {
    public static final int $stable = 8;
    private final Class<? extends Enum<?>> enumClass;
    private final Enum<?>[] enumConstants;
    private final List<Field> userFields;

    @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
    public boolean isTrivial() {
        return false;
    }

    public EnumTypeConverter(Class<? extends Enum<?>> enumClass) {
        Intrinsics.checkNotNullParameter(enumClass, "enumClass");
        this.enumClass = enumClass;
        Object[] enumConstants = enumClass.getEnumConstants();
        if (enumConstants == null) {
            throw new IllegalArgumentException("Passed type is not an enum type".toString());
        }
        Enum<?>[] enumArr = (Enum[]) enumConstants;
        if (!(enumArr.length == 0)) {
            this.enumConstants = enumArr;
            Field[] declaredFields = enumClass.getDeclaredFields();
            Intrinsics.checkNotNullExpressionValue(declaredFields, "getDeclaredFields(...)");
            ArrayList arrayList = new ArrayList();
            for (Field field : declaredFields) {
                Field field2 = field;
                if (!Modifier.isStatic(field2.getModifiers()) && !field2.isSynthetic()) {
                    arrayList.add(field);
                }
            }
            this.userFields = arrayList;
            if (Enumerable.class.isAssignableFrom(this.enumClass)) {
                return;
            }
            Logger.error$default(CoreLoggerKt.getLogger(), "Enum '" + this.enumClass.getSimpleName() + "' should inherit from " + Reflection.getOrCreateKotlinClass(Enumerable.class) + ".", null, 2, null);
            return;
        }
        throw new IllegalArgumentException("Passed enum type is empty".toString());
    }

    @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
    /* JADX INFO: renamed from: getCppRequiredTypes */
    public ExpectedType get$cppRequireType() {
        return ExpectedType.INSTANCE.forEnum();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
    public Enum<?> convertFromDynamic(Dynamic value, ConverterContext context, boolean forceConversion) throws DynamicCastException, IncompatibleArgTypeException {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.userFields.isEmpty()) {
            String strAsString = value.asString();
            if (strAsString != null) {
                return convertEnumWithoutParameter(strAsString, this.enumConstants);
            }
            throw new DynamicCastException((Class<?>) String.class);
        }
        if (this.userFields.size() == 1) {
            return convertEnumWithParameter(value, this.enumConstants, (Field) CollectionsKt.first((List) this.userFields));
        }
        throw new IncompatibleArgTypeException(ReadableTypeExtensionsKt.toClass(value.getType()), this.enumClass, (Throwable) null, 4, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
    public Enum<?> convertFromAny(Object value, ConverterContext context, boolean forceConversion) throws IncompatibleArgTypeException {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.userFields.isEmpty()) {
            return convertEnumWithoutParameter((String) value, this.enumConstants);
        }
        if (this.userFields.size() == 1) {
            return convertEnumWithParameter(value, this.enumConstants, (Field) CollectionsKt.first((List) this.userFields));
        }
        throw new IncompatibleArgTypeException(value.getClass(), this.enumClass, (Throwable) null, 4, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0017 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:11:0x0018  */
    private final Enum<?> convertEnumWithoutParameter(String stringRepresentation, Enum<?>[] enumConstants) throws EnumNoSuchValueException {
        for (Enum<?> r2 : enumConstants) {
            if (Intrinsics.areEqual(r2.name(), stringRepresentation)) {
                if (r2 != null) {
                    return r2;
                }
                throw new EnumNoSuchValueException(this.enumClass, enumConstants, stringRepresentation);
            }
        }
        r2 = null;
        if (r2 != null) {
            return r2;
        }
        throw new EnumNoSuchValueException(this.enumClass, enumConstants, stringRepresentation);
    }

    private final Enum<?> convertEnumWithParameter(Object jsValue, Enum<?>[] enumConstants, Field field) {
        Enum<?> r3;
        field.setAccessible(true);
        Class<?> type = field.getType();
        Intrinsics.checkNotNull(type);
        Object objUnwrapValue = unwrapValue(jsValue, type);
        int length = enumConstants.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                r3 = null;
                break;
            }
            r3 = enumConstants[i];
            if (Intrinsics.areEqual(field.get(r3), objUnwrapValue)) {
                break;
            }
            i++;
        }
        if (r3 != null) {
            return r3;
        }
        throw new IllegalArgumentException(("Couldn't convert '" + jsValue + "' to " + this.enumClass.getSimpleName() + " where " + field.getName() + " is the enum parameter").toString());
    }

    private final Object unwrapValue(Object obj, Class<?> cls) {
        if (obj instanceof Dynamic) {
            if (Intrinsics.areEqual(cls, String.class)) {
                return ((Dynamic) obj).asString();
            }
            return Integer.valueOf(((Dynamic) obj).asInt());
        }
        if (Intrinsics.areEqual(cls, String.class)) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            return (String) obj;
        }
        if (obj instanceof Double) {
            return Integer.valueOf((int) ((Number) obj).doubleValue());
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        return (Integer) obj;
    }
}
