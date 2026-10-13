package com.datadog.android.flags.internal;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.flags.internal.model.VariationType;
import com.datadog.android.rum.internal.utils.ViewUtilsKt;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: compiled from: FlagValueConverter.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JA\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\b\b\u0000\u0010\u0005*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00050\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u00020\u00072\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nJ\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00072\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0010"}, d2 = {"Lcom/datadog/android/flags/internal/FlagValueConverter;", "", "()V", "convert", "Lkotlin/Result;", ExifInterface.GPS_DIRECTION_TRUE, "variationValue", "", "variationType", "targetType", "Lkotlin/reflect/KClass;", "convert-0E7RQCE", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/reflect/KClass;)Ljava/lang/Object;", "getTypeName", "isTypeCompatible", "", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FlagValueConverter {
    public static final FlagValueConverter INSTANCE = new FlagValueConverter();

    private FlagValueConverter() {
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0073 A[PHI: r2
      0x0073: PHI (r2v30 java.lang.Object) = 
      (r2v25 java.lang.Object)
      (r2v26 java.lang.Object)
      (r2v27 java.lang.Object)
      (r2v28 java.lang.Object)
      (r2v29 java.lang.Object)
      (r2v35 java.lang.Object)
     binds: [B:38:0x00e5, B:34:0x00d4, B:28:0x00bc, B:23:0x00a9, B:18:0x0096, B:9:0x006f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX INFO: renamed from: convert-0E7RQCE, reason: not valid java name */
    public final <T> Object m11150convert0E7RQCE(String variationValue, String variationType, KClass<T> targetType) {
        Object map;
        Intrinsics.checkNotNullParameter(variationValue, "variationValue");
        Intrinsics.checkNotNullParameter(variationType, "variationType");
        Intrinsics.checkNotNullParameter(targetType, "targetType");
        if (!isTypeCompatible(variationType, targetType)) {
            String typeName = getTypeName(targetType);
            Result.Companion companion = Result.INSTANCE;
            return Result.m12684constructorimpl(ResultKt.createFailure(new TypeMismatchException("Flag has type '" + variationType + "' but " + typeName + " was requested")));
        }
        try {
            Result.Companion companion2 = Result.INSTANCE;
            FlagValueConverter flagValueConverter = this;
            String str = null;
            if (Intrinsics.areEqual(targetType, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                Locale US = Locale.US;
                Intrinsics.checkNotNullExpressionValue(US, "US");
                String lowerCase = variationValue.toLowerCase(US);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                map = StringsKt.toBooleanStrictOrNull(lowerCase);
                if (map != null) {
                    str = map;
                }
            } else if (Intrinsics.areEqual(targetType, Reflection.getOrCreateKotlinClass(String.class))) {
                str = variationValue;
            } else if (Intrinsics.areEqual(targetType, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                map = StringsKt.toIntOrNull(variationValue);
                if (map != null) {
                    str = map;
                }
            } else if (Intrinsics.areEqual(targetType, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                map = StringsKt.toDoubleOrNull(variationValue);
                if (map != null) {
                    str = map;
                }
            } else if (Intrinsics.areEqual(targetType, Reflection.getOrCreateKotlinClass(Map.class))) {
                map = JsonExtensionsKt.toMap(variationValue);
                if (map != null) {
                    str = map;
                }
            } else if (Intrinsics.areEqual(targetType, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                map = new JSONObject(variationValue);
                if (map instanceof Object) {
                    str = map;
                }
            } else if (Map.class.isAssignableFrom(JvmClassMappingKt.getJavaClass((KClass) targetType)) && (map = JsonExtensionsKt.toMap(variationValue)) != null) {
                str = map;
            }
            if (str != null) {
                return Result.m12684constructorimpl(str);
            }
            throw new IllegalArgumentException("Failed to parse value '" + variationValue + "'");
        } catch (Throwable th) {
            Result.Companion companion3 = Result.INSTANCE;
            return Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
    }

    public final boolean isTypeCompatible(String variationType, KClass<?> targetType) {
        Intrinsics.checkNotNullParameter(variationType, "variationType");
        Intrinsics.checkNotNullParameter(targetType, "targetType");
        if (Intrinsics.areEqual(targetType, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            return Intrinsics.areEqual(variationType, VariationType.BOOLEAN.getValue());
        }
        if (Intrinsics.areEqual(targetType, Reflection.getOrCreateKotlinClass(String.class))) {
            return Intrinsics.areEqual(variationType, VariationType.STRING.getValue());
        }
        if (Intrinsics.areEqual(targetType, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
            return Intrinsics.areEqual(variationType, VariationType.INTEGER.getValue()) || Intrinsics.areEqual(variationType, VariationType.NUMBER.getValue());
        }
        if (Intrinsics.areEqual(targetType, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            return Intrinsics.areEqual(variationType, VariationType.NUMBER.getValue()) || Intrinsics.areEqual(variationType, VariationType.FLOAT.getValue()) || Intrinsics.areEqual(variationType, VariationType.INTEGER.getValue());
        }
        if (!Intrinsics.areEqual(targetType, Reflection.getOrCreateKotlinClass(JSONObject.class)) && !Intrinsics.areEqual(targetType, Reflection.getOrCreateKotlinClass(Map.class))) {
            if (Map.class.isAssignableFrom(JvmClassMappingKt.getJavaClass((KClass) targetType))) {
                return Intrinsics.areEqual(variationType, VariationType.OBJECT.getValue());
            }
            return false;
        }
        return Intrinsics.areEqual(variationType, VariationType.OBJECT.getValue());
    }

    public final String getTypeName(KClass<?> targetType) {
        Intrinsics.checkNotNullParameter(targetType, "targetType");
        if (Intrinsics.areEqual(targetType, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            return "Boolean";
        }
        if (Intrinsics.areEqual(targetType, Reflection.getOrCreateKotlinClass(String.class))) {
            return "String";
        }
        if (Intrinsics.areEqual(targetType, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
            return "Int";
        }
        if (Intrinsics.areEqual(targetType, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            return "Double";
        }
        if (Intrinsics.areEqual(targetType, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
            return "JSONObject";
        }
        if (Intrinsics.areEqual(targetType, Reflection.getOrCreateKotlinClass(Map.class))) {
            return "Map";
        }
        String simpleName = targetType.getSimpleName();
        return simpleName == null ? ViewUtilsKt.UNKNOWN_DESTINATION_URL : simpleName;
    }
}
