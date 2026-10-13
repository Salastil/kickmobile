package expo.modules.kotlin.types;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import expo.modules.kotlin.exception.DynamicCastException;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.jni.CppType;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.jni.SingleType;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ColorTypeConverter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0013\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0013H\u0002J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\tH\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u000bH\u0016¨\u0006\u001a"}, d2 = {"Lexpo/modules/kotlin/types/ColorTypeConverter;", "Lexpo/modules/kotlin/types/DynamicAwareTypeConverters;", "Landroid/graphics/Color;", "<init>", "()V", "convertFromDynamic", "value", "Lcom/facebook/react/bridge/Dynamic;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lexpo/modules/kotlin/types/ConverterContext;", "forceConversion", "", "convertFromAny", "", "colorFromDoubleArray", "", "colorFromInt", "", "colorFromString", "", "colorFromReadableMap", "Lcom/facebook/react/bridge/ReadableMap;", "converterContext", "getCppRequiredTypes", "Lexpo/modules/kotlin/jni/ExpectedType;", "isTrivial", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ColorTypeConverter extends DynamicAwareTypeConverters<Color> {
    public static final int $stable = 0;

    /* JADX INFO: compiled from: ColorTypeConverter.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ReadableType.values().length];
            try {
                iArr[ReadableType.Number.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ReadableType.String.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ReadableType.Array.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ReadableType.Map.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
    public boolean isTrivial() {
        return false;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
    public Color convertFromDynamic(Dynamic value, ConverterContext context, boolean forceConversion) throws DynamicCastException, UnexpectedException {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(context, "context");
        int i = WhenMappings.$EnumSwitchMapping$0[value.getType().ordinal()];
        if (i == 1) {
            return colorFromInt((int) value.asDouble());
        }
        if (i == 2) {
            String strAsString = value.asString();
            if (strAsString != null) {
                return colorFromString(strAsString);
            }
            throw new DynamicCastException((KClass<?>) Reflection.getOrCreateKotlinClass(String.class));
        }
        if (i != 3) {
            if (i == 4) {
                ReadableMap readableMapAsMap = value.asMap();
                if (readableMapAsMap == null) {
                    throw new DynamicCastException((KClass<?>) Reflection.getOrCreateKotlinClass(ReadableMap.class));
                }
                return colorFromReadableMap(readableMapAsMap, context);
            }
            throw new UnexpectedException("Unknown argument type: " + value.getType());
        }
        ReadableArray readableArrayAsArray = value.asArray();
        if (readableArrayAsArray == null) {
            throw new DynamicCastException((KClass<?>) Reflection.getOrCreateKotlinClass(ReadableArray.class));
        }
        ArrayList<Object> arrayList = readableArrayAsArray.toArrayList();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        for (Object obj : arrayList) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Double");
            Double d = (Double) obj;
            d.doubleValue();
            arrayList2.add(d);
        }
        return colorFromDoubleArray(CollectionsKt.toDoubleArray(arrayList2));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
    public Color convertFromAny(Object value, ConverterContext context, boolean forceConversion) throws UnexpectedException {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(context, "context");
        if (value instanceof Integer) {
            return colorFromInt(((Number) value).intValue());
        }
        if (value instanceof String) {
            return colorFromString((String) value);
        }
        if (value instanceof double[]) {
            return colorFromDoubleArray((double[]) value);
        }
        if (value instanceof ReadableMap) {
            return colorFromReadableMap((ReadableMap) value, context);
        }
        throw new UnexpectedException("Unknown argument type: " + Reflection.getOrCreateKotlinClass(value.getClass()));
    }

    private final Color colorFromDoubleArray(double[] value) throws InvalidColorComponentsException {
        if (value.length < 3) {
            throw new InvalidColorComponentsException(value.length);
        }
        Double orNull = ArraysKt.getOrNull(value, 3);
        return ColorCompat.INSTANCE.valueOf((float) value[0], (float) value[1], (float) value[2], (float) (orNull != null ? orNull.doubleValue() : 1.0d));
    }

    private final Color colorFromInt(int value) {
        return ColorCompat.INSTANCE.valueOf(value);
    }

    private final Color colorFromString(String value) {
        String lowerCase = StringsKt.trim((CharSequence) value).toString().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        List list = (List) ColorTypeConverterKt.namedColors.get(lowerCase);
        if (list != null) {
            return ColorCompat.INSTANCE.valueOf(((Number) list.get(0)).floatValue(), ((Number) list.get(1)).floatValue(), ((Number) list.get(2)).floatValue(), ((Number) list.get(3)).floatValue());
        }
        if (StringsKt.startsWith$default((CharSequence) lowerCase, '#', false, 2, (Object) null)) {
            Color hexColor = ColorTypeConverterKt.parseHexColor(lowerCase);
            return hexColor != null ? hexColor : ColorCompat.INSTANCE.valueOf(Color.parseColor(lowerCase));
        }
        Color cssColorFunction = ColorTypeConverterKt.parseCssColorFunction(lowerCase);
        return cssColorFunction != null ? cssColorFunction : ColorCompat.INSTANCE.valueOf(Color.parseColor(lowerCase));
    }

    private final Color colorFromReadableMap(ReadableMap value, ConverterContext converterContext) throws UnexpectedException {
        Context applicationContext = converterContext.getApplicationContext();
        if (Build.VERSION.SDK_INT >= 26) {
            Color colorInstance = ColorPropConverter.getColorInstance(value, applicationContext);
            if (colorInstance != null) {
                return colorInstance;
            }
            throw new UnexpectedException("ColorPropConverter returned null for a non-null color value.");
        }
        Integer color = ColorPropConverter.getColor(value, applicationContext);
        if (color == null) {
            throw new UnexpectedException("ColorPropConverter returned null for a non-null color value.");
        }
        return ColorCompat.INSTANCE.valueOf(color.intValue());
    }

    @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
    /* JADX INFO: renamed from: getCppRequiredTypes */
    public ExpectedType get$cppRequireType() {
        return new ExpectedType(new SingleType(CppType.INT, null, 2, null), new SingleType(CppType.STRING, null, 2, null), new SingleType(CppType.PRIMITIVE_ARRAY, new ExpectedType[]{new ExpectedType(CppType.DOUBLE)}), new SingleType(CppType.READABLE_MAP, null, 2, null));
    }
}
