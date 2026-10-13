package com.facebook.react.uimanager;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.NativeArray;
import com.facebook.react.bridge.ReactNativeJNISoLoader;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.common.ReactConstants;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: TransformHelper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0013\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\b\rJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0006H\u0007J:\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J2\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011H\u0007J\u001d\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\bH\u0000¢\u0006\u0002\b\u001cJ$\u0010\u001d\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011H\u0002J3\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u001f2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u001fH\u0083 R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/facebook/react/uimanager/TransformHelper;", "", "<init>", "()V", "helperMatrix", "Ljava/lang/ThreadLocal;", "", "convertToRadians", "", "transformMap", "Lcom/facebook/react/bridge/ReadableMap;", "key", "", "convertToRadians$ReactAndroid", "processTransform", "", "transforms", "Lcom/facebook/react/bridge/ReadableArray;", "result", "viewWidth", "", "viewHeight", ViewProps.TRANSFORM_ORIGIN, "allowPercentageResolution", "", "parseTranslateValue", "stringValue", TypedValues.Custom.S_DIMENSION, "parseTranslateValue$ReactAndroid", "getTranslateForTransformOrigin", "nativeProcessTransform", "Lcom/facebook/react/bridge/NativeArray;", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TransformHelper {
    public static final TransformHelper INSTANCE = new TransformHelper();
    private static final ThreadLocal<double[]> helperMatrix;

    /* JADX INFO: compiled from: TransformHelper.kt */
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

    @JvmStatic
    private static final native void nativeProcessTransform(NativeArray transforms, double[] result, float viewWidth, float viewHeight, NativeArray transformOrigin);

    private TransformHelper() {
    }

    static {
        ReactNativeJNISoLoader.staticInit();
        helperMatrix = new ThreadLocal<double[]>() { // from class: com.facebook.react.uimanager.TransformHelper$helperMatrix$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java.lang.ThreadLocal
            public double[] initialValue() {
                return new double[16];
            }
        };
    }

    public final double convertToRadians$ReactAndroid(ReadableMap transformMap, String key) {
        double d;
        Intrinsics.checkNotNullParameter(transformMap, "transformMap");
        Intrinsics.checkNotNullParameter(key, "key");
        boolean z = true;
        if (transformMap.getType(key) == ReadableType.String) {
            String string = transformMap.getString(key);
            Intrinsics.checkNotNull(string);
            if (StringsKt.endsWith$default(string, "rad", false, 2, (Object) null)) {
                string = StringsKt.dropLast(string, 3);
            } else if (StringsKt.endsWith$default(string, "deg", false, 2, (Object) null)) {
                string = StringsKt.dropLast(string, 3);
                z = false;
            }
            d = Double.parseDouble(string);
        } else {
            d = transformMap.getDouble(key);
        }
        return z ? d : MatrixMathHelper.degreesToRadians(d);
    }

    @Deprecated(message = "Use processTransform(ReadableArray, DoubleArray, Float, Float, ReadableArray) instead", replaceWith = @ReplaceWith(expression = "processTransform(...)", imports = {}))
    @JvmStatic
    public static final void processTransform(ReadableArray transforms, double[] result) {
        Intrinsics.checkNotNullParameter(transforms, "transforms");
        Intrinsics.checkNotNullParameter(result, "result");
        processTransform(transforms, result, 0.0f, 0.0f, null);
    }

    @Deprecated(message = "Use processTransform(ReadableArray, DoubleArray, Float, Float, ReadableArray) instead", replaceWith = @ReplaceWith(expression = "processTransform(...)", imports = {}))
    @JvmStatic
    public static final void processTransform(ReadableArray transforms, double[] result, float viewWidth, float viewHeight, ReadableArray transformOrigin, boolean allowPercentageResolution) {
        Intrinsics.checkNotNullParameter(transforms, "transforms");
        Intrinsics.checkNotNullParameter(result, "result");
        processTransform(transforms, result, viewWidth, viewHeight, transformOrigin);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:106:0x026f A[PHI: r5 r9 r14 r17
      0x026f: PHI (r5v39 int) = (r5v7 int), (r5v8 int), (r5v16 int), (r5v40 int) binds: [B:99:0x024b, B:91:0x021c, B:86:0x01f7, B:25:0x0099] A[DONT_GENERATE, DONT_INLINE]
      0x026f: PHI (r9v10 char) = (r9v2 char), (r9v3 char), (r9v5 char), (r9v11 char) binds: [B:99:0x024b, B:91:0x021c, B:86:0x01f7, B:25:0x0099] A[DONT_GENERATE, DONT_INLINE]
      0x026f: PHI (r14v22 int) = (r14v2 int), (r14v3 int), (r14v11 int), (r14v23 int) binds: [B:99:0x024b, B:91:0x021c, B:86:0x01f7, B:25:0x0099] A[DONT_GENERATE, DONT_INLINE]
      0x026f: PHI (r17v19 int) = (r17v0 int), (r17v1 int), (r17v9 int), (r17v20 int) binds: [B:99:0x024b, B:91:0x021c, B:86:0x01f7, B:25:0x0099] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01db, code lost:
    
        if (r11.equals("rotate") == false) goto L86;
     */
    /* JADX WARN: Instruction removed from duplicated block: B:106:0x026f, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void processTransform(com.facebook.react.bridge.ReadableArray r20, double[] r21, float r22, float r23, com.facebook.react.bridge.ReadableArray r24) {
        /*
            Method dump skipped, instruction units count: 740
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.TransformHelper.processTransform(com.facebook.react.bridge.ReadableArray, double[], float, float, com.facebook.react.bridge.ReadableArray):void");
    }

    public final double parseTranslateValue$ReactAndroid(String stringValue, double dimension) {
        Intrinsics.checkNotNullParameter(stringValue, "stringValue");
        try {
            if (StringsKt.endsWith$default(stringValue, "%", false, 2, (Object) null)) {
                return (Double.parseDouble(StringsKt.dropLast(stringValue, 1)) * dimension) / 100.0d;
            }
            return Double.parseDouble(stringValue);
        } catch (NumberFormatException unused) {
            FLog.w(ReactConstants.TAG, "Invalid translate value: " + stringValue);
            return 0.0d;
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0043  */
    private final double[] getTranslateForTransformOrigin(float viewWidth, float viewHeight, ReadableArray transformOrigin) {
        if (transformOrigin == null || (viewHeight == 0.0f && viewWidth == 0.0f)) {
            return null;
        }
        double d = ((double) viewWidth) / 2.0d;
        double d2 = ((double) viewHeight) / 2.0d;
        double[] dArr = new double[3];
        boolean z = false;
        dArr[0] = d;
        int i = 1;
        dArr[1] = d2;
        dArr[2] = 0.0d;
        int iMin = Math.min(transformOrigin.size(), 3);
        int i2 = 0;
        while (i2 < iMin) {
            int i3 = WhenMappings.$EnumSwitchMapping$0[transformOrigin.getType(i2).ordinal()];
            if (i3 == i) {
                dArr[i2] = transformOrigin.getDouble(i2);
            } else if (i3 == 2) {
                String string = transformOrigin.getString(i2);
                Intrinsics.checkNotNull(string);
                if (StringsKt.endsWith$default(string, "%", z, 2, (Object) null)) {
                    dArr[i2] = (((double) (i2 == 0 ? viewWidth : viewHeight)) * Double.parseDouble(StringsKt.dropLast(string, i))) / 100.0d;
                }
            }
            i2++;
            z = z;
            i = i;
        }
        boolean z2 = z;
        int i4 = i;
        double d3 = (-d) + dArr[z2 ? 1 : 0];
        double d4 = (-d2) + dArr[i4];
        double d5 = dArr[2];
        double[] dArr2 = new double[3];
        dArr2[z2 ? 1 : 0] = d3;
        dArr2[i4] = d4;
        dArr2[2] = d5;
        return dArr2;
    }
}
