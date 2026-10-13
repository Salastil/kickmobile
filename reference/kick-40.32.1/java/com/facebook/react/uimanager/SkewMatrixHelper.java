package com.facebook.react.uimanager;

import android.graphics.Matrix;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SkewMatrixHelper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J*\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0007J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J(\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bH\u0002J \u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0002J \u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\u000bH\u0002¨\u0006\u001e"}, d2 = {"Lcom/facebook/react/uimanager/SkewMatrixHelper;", "", "<init>", "()V", "isAffine2DTransformWithSkew", "", "transforms", "Lcom/facebook/react/bridge/ReadableArray;", "buildAffine2DMatrix", "Landroid/graphics/Matrix;", "viewWidthDip", "", "viewHeightDip", ViewProps.TRANSFORM_ORIGIN, "isRawMatrixShorthand", "resolveOriginAxis", "origin", "axis", "", "dimensionDip", "defaultDip", "parseTranslateValue", "", "value", FirebaseAnalytics.Param.INDEX, "parseScalarTranslate", "map", "Lcom/facebook/react/bridge/ReadableMap;", "key", "", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SkewMatrixHelper {
    public static final SkewMatrixHelper INSTANCE = new SkewMatrixHelper();

    /* JADX INFO: compiled from: SkewMatrixHelper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
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
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private SkewMatrixHelper() {
    }

    /* JADX WARN: Code duplicated, block: B:45:0x0095  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @JvmStatic
    public static final boolean isAffine2DTransformWithSkew(ReadableArray transforms) {
        ReadableMap map;
        ReadableArray array;
        Intrinsics.checkNotNullParameter(transforms, "transforms");
        if (INSTANCE.isRawMatrixShorthand(transforms)) {
            return false;
        }
        int size = transforms.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            if (transforms.getType(i) == ReadableType.Map && (map = transforms.getMap(i)) != null) {
                ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = map.keySetIterator();
                if (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
                    String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
                    switch (strNextKey.hashCode()) {
                        case -1081239615:
                            if (strNextKey.equals("matrix")) {
                                return false;
                            }
                            break;
                            break;
                        case 109493390:
                            if (strNextKey.equals("skewX")) {
                                z = true;
                            }
                            break;
                        case 109493391:
                            if (strNextKey.equals("skewY")) {
                                z = true;
                            }
                            break;
                        case 207960636:
                            if (strNextKey.equals("perspective")) {
                                return false;
                            }
                            break;
                            break;
                        case 1052832078:
                            if (strNextKey.equals("translate") && (array = map.getArray(strNextKey)) != null && array.size() > 2 && array.getType(2) == ReadableType.Number && array.getDouble(2) != 0.0d) {
                                return false;
                            }
                            break;
                            break;
                        case 1384173149:
                            if (strNextKey.equals("rotateX")) {
                                return false;
                            }
                            break;
                            break;
                        case 1384173150:
                            if (strNextKey.equals("rotateY")) {
                                return false;
                            }
                            break;
                            break;
                        default:
                            continue;
                    }
                } else {
                    continue;
                }
            }
        }
        return z;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @JvmStatic
    public static final Matrix buildAffine2DMatrix(ReadableArray transforms, float viewWidthDip, float viewHeightDip, ReadableArray transformOrigin) {
        float pixelFromDIP;
        float pixelFromDIP2;
        ReadableMap map;
        Intrinsics.checkNotNullParameter(transforms, "transforms");
        if (transformOrigin == null) {
            pixelFromDIP2 = PixelUtil.toPixelFromDIP(viewWidthDip / 2.0f);
            pixelFromDIP = PixelUtil.toPixelFromDIP(viewHeightDip / 2.0f);
        } else {
            SkewMatrixHelper skewMatrixHelper = INSTANCE;
            float pixelFromDIP3 = PixelUtil.toPixelFromDIP(skewMatrixHelper.resolveOriginAxis(transformOrigin, 0, viewWidthDip, viewWidthDip / 2.0f));
            pixelFromDIP = PixelUtil.toPixelFromDIP(skewMatrixHelper.resolveOriginAxis(transformOrigin, 1, viewHeightDip, viewHeightDip / 2.0f));
            pixelFromDIP2 = pixelFromDIP3;
        }
        Matrix matrix = new Matrix();
        int size = transforms.size();
        for (int i = 0; i < size; i++) {
            if (transforms.getType(i) == ReadableType.Map && (map = transforms.getMap(i)) != null) {
                ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = map.keySetIterator();
                if (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
                    String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
                    switch (strNextKey.hashCode()) {
                        case -1721943862:
                            if (strNextKey.equals(ViewProps.TRANSLATE_X)) {
                                matrix.preTranslate(PixelUtil.toPixelFromDIP((float) INSTANCE.parseScalarTranslate(map, strNextKey, viewWidthDip)), 0.0f);
                                continue;
                            }
                            break;
                        case -1721943861:
                            if (strNextKey.equals(ViewProps.TRANSLATE_Y)) {
                                matrix.preTranslate(0.0f, PixelUtil.toPixelFromDIP((float) INSTANCE.parseScalarTranslate(map, strNextKey, viewHeightDip)));
                                continue;
                            }
                            break;
                        case -925180581:
                            if (!strNextKey.equals("rotate")) {
                            }
                            break;
                        case -908189618:
                            if (strNextKey.equals("scaleX")) {
                                matrix.preScale((float) map.getDouble(strNextKey), 1.0f, pixelFromDIP2, pixelFromDIP);
                                continue;
                            }
                            break;
                        case -908189617:
                            if (strNextKey.equals("scaleY")) {
                                matrix.preScale(1.0f, (float) map.getDouble(strNextKey), pixelFromDIP2, pixelFromDIP);
                                continue;
                            }
                            break;
                        case 109250890:
                            if (strNextKey.equals("scale")) {
                                float f = (float) map.getDouble(strNextKey);
                                matrix.preScale(f, f, pixelFromDIP2, pixelFromDIP);
                                continue;
                            }
                            break;
                        case 109493390:
                            if (strNextKey.equals("skewX")) {
                                matrix.preSkew((float) Math.tan(TransformHelper.INSTANCE.convertToRadians$ReactAndroid(map, strNextKey)), 0.0f, pixelFromDIP2, pixelFromDIP);
                                continue;
                            }
                            break;
                        case 109493391:
                            if (strNextKey.equals("skewY")) {
                                matrix.preSkew(0.0f, (float) Math.tan(TransformHelper.INSTANCE.convertToRadians$ReactAndroid(map, strNextKey)), pixelFromDIP2, pixelFromDIP);
                                continue;
                            }
                            break;
                        case 1052832078:
                            if (strNextKey.equals("translate")) {
                                ReadableArray array = map.getArray(strNextKey);
                                if (array == null) {
                                    continue;
                                } else if (array.size() >= 1) {
                                    SkewMatrixHelper skewMatrixHelper2 = INSTANCE;
                                    matrix.preTranslate(PixelUtil.toPixelFromDIP((float) skewMatrixHelper2.parseTranslateValue(array, 0, viewWidthDip)), PixelUtil.toPixelFromDIP((float) (array.size() > 1 ? skewMatrixHelper2.parseTranslateValue(array, 1, viewHeightDip) : 0.0d)));
                                }
                            }
                            break;
                        case 1384173151:
                            if (!strNextKey.equals("rotateZ")) {
                                break;
                            }
                            break;
                        default:
                            continue;
                    }
                    matrix.preRotate((float) Math.toDegrees(TransformHelper.INSTANCE.convertToRadians$ReactAndroid(map, strNextKey)), pixelFromDIP2, pixelFromDIP);
                }
            }
        }
        return matrix;
    }

    private final boolean isRawMatrixShorthand(ReadableArray transforms) {
        return transforms.size() == 16 && transforms.getType(0) == ReadableType.Number;
    }

    private final float resolveOriginAxis(ReadableArray origin, int axis, float dimensionDip, float defaultDip) {
        String string;
        if (origin.size() > axis) {
            int i = WhenMappings.$EnumSwitchMapping$0[origin.getType(axis).ordinal()];
            if (i == 1) {
                return (float) origin.getDouble(axis);
            }
            if (i == 2 && (string = origin.getString(axis)) != null && StringsKt.endsWith$default(string, "%", false, 2, (Object) null)) {
                try {
                    return (float) ((Double.parseDouble(StringsKt.dropLast(string, 1)) * ((double) dimensionDip)) / 100.0d);
                } catch (NumberFormatException unused) {
                    return defaultDip;
                }
            }
        }
        return defaultDip;
    }

    private final double parseTranslateValue(ReadableArray value, int index, float dimensionDip) {
        if (value.getType(index) != ReadableType.String) {
            return value.getDouble(index);
        }
        String string = value.getString(index);
        if (string == null) {
            return 0.0d;
        }
        return TransformHelper.INSTANCE.parseTranslateValue$ReactAndroid(string, dimensionDip);
    }

    private final double parseScalarTranslate(ReadableMap map, String key, float dimensionDip) {
        if (map.getType(key) != ReadableType.String) {
            return map.getDouble(key);
        }
        String string = map.getString(key);
        if (string == null) {
            return 0.0d;
        }
        return TransformHelper.INSTANCE.parseTranslateValue$ReactAndroid(string, dimensionDip);
    }
}
