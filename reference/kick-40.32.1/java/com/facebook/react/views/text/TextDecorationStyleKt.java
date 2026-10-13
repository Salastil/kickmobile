package com.facebook.react.views.text;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.os.Build;
import android.text.Layout;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import androidx.window.reflection.WindowExtensionsConstants;
import com.facebook.react.uimanager.ViewProps;
import com.mux.stats.sdk.core.model.ViewDeviceOrientationData;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: TextDecorationStyle.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0002\u0005\b\u001aP\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0001H\u0002\u001a\u0085\u0001\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u00162K\u0010\u001f\u001aG\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00100 H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006$"}, d2 = {"scratchPath", "Landroid/graphics/Path;", "decorationPaint", "Landroid/graphics/Paint;", "dottedEffects", "com/facebook/react/views/text/TextDecorationStyleKt$dottedEffects$1", "Lcom/facebook/react/views/text/TextDecorationStyleKt$dottedEffects$1;", "dashedEffects", "com/facebook/react/views/text/TextDecorationStyleKt$dashedEffects$1", "Lcom/facebook/react/views/text/TextDecorationStyleKt$dashedEffects$1;", "drawDecorationLine", "", "canvas", "Landroid/graphics/Canvas;", "paint", "x1", "", "x2", ViewDeviceOrientationData.DEVICE_ORIENTATION_Y, "thickness", "density", "style", "Lcom/facebook/react/views/text/TextDecorationStyle;", "reusablePath", "drawSpannedDecoration", ViewProps.START, "", ViewProps.END, WindowExtensionsConstants.LAYOUT_PACKAGE, "Landroid/text/Layout;", "color", "yOffsetForLine", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "baseline", "ReactAndroid"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class TextDecorationStyleKt {
    private static final Path scratchPath = new Path();
    private static final Paint decorationPaint = new Paint();
    private static final TextDecorationStyleKt$dottedEffects$1 dottedEffects = new LinkedHashMap<Float, DashPathEffect>() { // from class: com.facebook.react.views.text.TextDecorationStyleKt$dottedEffects$1
        public /* bridge */ boolean containsKey(Float f) {
            return super.containsKey((Object) f);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object obj) {
            if (obj instanceof Float) {
                return containsKey((Float) obj);
            }
            return false;
        }

        public /* bridge */ boolean containsValue(DashPathEffect dashPathEffect) {
            return super.containsValue((Object) dashPathEffect);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsValue(Object obj) {
            if (obj instanceof DashPathEffect) {
                return containsValue((DashPathEffect) obj);
            }
            return false;
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Map.Entry<Float, DashPathEffect>> entrySet() {
            return getEntries();
        }

        public /* bridge */ DashPathEffect get(Float f) {
            return (DashPathEffect) super.get((Object) f);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ DashPathEffect get(Object obj) {
            if (obj instanceof Float) {
                return get((Float) obj);
            }
            return null;
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            if (obj instanceof Float) {
                return get((Float) obj);
            }
            return null;
        }

        public /* bridge */ Set<Map.Entry<Float, DashPathEffect>> getEntries() {
            return super.entrySet();
        }

        public /* bridge */ Set<Float> getKeys() {
            return super.keySet();
        }

        public /* bridge */ DashPathEffect getOrDefault(Float f, DashPathEffect dashPathEffect) {
            return (DashPathEffect) super.getOrDefault((Object) f, dashPathEffect);
        }

        public final /* bridge */ DashPathEffect getOrDefault(Object obj, DashPathEffect dashPathEffect) {
            return !(obj instanceof Float) ? dashPathEffect : getOrDefault((Float) obj, dashPathEffect);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
            return !(obj instanceof Float) ? obj2 : getOrDefault((Float) obj, (DashPathEffect) obj2);
        }

        public /* bridge */ int getSize() {
            return super.size();
        }

        public /* bridge */ Collection<DashPathEffect> getValues() {
            return super.values();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Float> keySet() {
            return getKeys();
        }

        public /* bridge */ DashPathEffect remove(Float f) {
            return (DashPathEffect) super.remove((Object) f);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ DashPathEffect remove(Object obj) {
            if (obj instanceof Float) {
                return remove((Float) obj);
            }
            return null;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object remove(Object obj) {
            if (obj instanceof Float) {
                return remove((Float) obj);
            }
            return null;
        }

        public /* bridge */ boolean remove(Float f, DashPathEffect dashPathEffect) {
            return super.remove((Object) f, (Object) dashPathEffect);
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ boolean remove(Object obj, Object obj2) {
            if ((obj instanceof Float) && (obj2 instanceof DashPathEffect)) {
                return remove((Float) obj, (DashPathEffect) obj2);
            }
            return false;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Collection<DashPathEffect> values() {
            return getValues();
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<Float, DashPathEffect> eldest) {
            return size() > 4;
        }
    };
    private static final TextDecorationStyleKt$dashedEffects$1 dashedEffects = new LinkedHashMap<Float, DashPathEffect>() { // from class: com.facebook.react.views.text.TextDecorationStyleKt$dashedEffects$1
        public /* bridge */ boolean containsKey(Float f) {
            return super.containsKey((Object) f);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object obj) {
            if (obj instanceof Float) {
                return containsKey((Float) obj);
            }
            return false;
        }

        public /* bridge */ boolean containsValue(DashPathEffect dashPathEffect) {
            return super.containsValue((Object) dashPathEffect);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsValue(Object obj) {
            if (obj instanceof DashPathEffect) {
                return containsValue((DashPathEffect) obj);
            }
            return false;
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Map.Entry<Float, DashPathEffect>> entrySet() {
            return getEntries();
        }

        public /* bridge */ DashPathEffect get(Float f) {
            return (DashPathEffect) super.get((Object) f);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ DashPathEffect get(Object obj) {
            if (obj instanceof Float) {
                return get((Float) obj);
            }
            return null;
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            if (obj instanceof Float) {
                return get((Float) obj);
            }
            return null;
        }

        public /* bridge */ Set<Map.Entry<Float, DashPathEffect>> getEntries() {
            return super.entrySet();
        }

        public /* bridge */ Set<Float> getKeys() {
            return super.keySet();
        }

        public /* bridge */ DashPathEffect getOrDefault(Float f, DashPathEffect dashPathEffect) {
            return (DashPathEffect) super.getOrDefault((Object) f, dashPathEffect);
        }

        public final /* bridge */ DashPathEffect getOrDefault(Object obj, DashPathEffect dashPathEffect) {
            return !(obj instanceof Float) ? dashPathEffect : getOrDefault((Float) obj, dashPathEffect);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
            return !(obj instanceof Float) ? obj2 : getOrDefault((Float) obj, (DashPathEffect) obj2);
        }

        public /* bridge */ int getSize() {
            return super.size();
        }

        public /* bridge */ Collection<DashPathEffect> getValues() {
            return super.values();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Float> keySet() {
            return getKeys();
        }

        public /* bridge */ DashPathEffect remove(Float f) {
            return (DashPathEffect) super.remove((Object) f);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ DashPathEffect remove(Object obj) {
            if (obj instanceof Float) {
                return remove((Float) obj);
            }
            return null;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object remove(Object obj) {
            if (obj instanceof Float) {
                return remove((Float) obj);
            }
            return null;
        }

        public /* bridge */ boolean remove(Float f, DashPathEffect dashPathEffect) {
            return super.remove((Object) f, (Object) dashPathEffect);
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ boolean remove(Object obj, Object obj2) {
            if ((obj instanceof Float) && (obj2 instanceof DashPathEffect)) {
                return remove((Float) obj, (DashPathEffect) obj2);
            }
            return false;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Collection<DashPathEffect> values() {
            return getValues();
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<Float, DashPathEffect> eldest) {
            return size() > 4;
        }
    };

    /* JADX INFO: compiled from: TextDecorationStyle.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TextDecorationStyle.values().length];
            try {
                iArr[TextDecorationStyle.SOLID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TextDecorationStyle.DOUBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TextDecorationStyle.DOTTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TextDecorationStyle.DASHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[TextDecorationStyle.WAVY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final void drawDecorationLine(Canvas canvas, Paint paint, float f, float f2, float f3, float f4, float f5, TextDecorationStyle textDecorationStyle, Path path) {
        float f6 = f;
        int i = WhenMappings.$EnumSwitchMapping$0[textDecorationStyle.ordinal()];
        if (i == 1) {
            canvas.drawLine(f, f3, f2, f3, paint);
            return;
        }
        if (i == 2) {
            canvas.drawLine(f6, f3, f2, f3, paint);
            float f7 = f3 + f4 + (f5 * 2.0f);
            canvas.drawLine(f, f7, f2, f7, paint);
            return;
        }
        if (i == 3 || i == 4) {
            path.reset();
            path.moveTo(f6, f3);
            path.lineTo(f2, f3);
            canvas.drawPath(path, paint);
            return;
        }
        if (i != 5) {
            throw new NoWhenBranchMatchedException();
        }
        float fMax = Math.max(1.0f, f4);
        float fRoundToInt = 1.0f + (MathKt.roundToInt((fMax * 2.0f) + 0.5f) * 2.0f);
        float fRoundToInt2 = MathKt.roundToInt((fMax * 3.0f) + 0.5f) + 0.5f;
        path.reset();
        path.moveTo(f6, f3);
        while (f6 < f2) {
            float f8 = (fRoundToInt / 2.0f) + f6;
            float f9 = f6 + fRoundToInt;
            path.cubicTo(f8, f3 + fRoundToInt2, f8, f3 - fRoundToInt2, f9, f3);
            f6 = f9;
        }
        canvas.drawPath(path, paint);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x005f  */
    public static final void drawSpannedDecoration(int i, int i2, Canvas canvas, Layout layout, int i3, TextDecorationStyle textDecorationStyle, Function3<? super Paint, ? super Float, ? super Float, Float> yOffsetForLine) {
        int color;
        float fMax;
        int i4 = i;
        TextDecorationStyle style = textDecorationStyle;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(layout, "layout");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(yOffsetForLine, "yOffsetForLine");
        TextPaint paint = layout.getPaint();
        Intrinsics.checkNotNullExpressionValue(paint, "getPaint(...)");
        if (i3 != 0) {
            color = i3;
        } else {
            CharSequence text = layout.getText();
            Spanned spanned = text instanceof Spanned ? (Spanned) text : null;
            ForegroundColorSpan[] foregroundColorSpanArr = spanned != null ? (ForegroundColorSpan[]) spanned.getSpans(i4, i4 + 1, ForegroundColorSpan.class) : null;
            if (foregroundColorSpanArr != null) {
                if (foregroundColorSpanArr.length == 0) {
                    color = paint.getColor();
                } else {
                    color = ((ForegroundColorSpan) ArraysKt.last(foregroundColorSpanArr)).getForegroundColor();
                }
            } else {
                color = paint.getColor();
            }
        }
        if (style == TextDecorationStyle.SOLID || style == TextDecorationStyle.DOUBLE) {
            if (Build.VERSION.SDK_INT >= 29) {
                fMax = paint.underlineThickness;
            } else {
                fMax = paint.getFontMetrics().descent * 0.1f;
            }
        } else {
            float f = paint.density * 1.5f;
            if (Build.VERSION.SDK_INT >= 29) {
                fMax = Math.max(paint.underlineThickness, f);
            } else {
                fMax = Math.max(paint.getFontMetrics().descent * 0.1f, f);
            }
        }
        float f2 = fMax;
        Paint paint2 = decorationPaint;
        paint2.set(paint);
        paint2.setColor(color);
        paint2.setStrokeWidth(f2);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        if (style == TextDecorationStyle.DOTTED || style == TextDecorationStyle.DASHED) {
            LinkedHashMap linkedHashMap = style == TextDecorationStyle.DOTTED ? dottedEffects : dashedEffects;
            Float fValueOf = Float.valueOf(f2);
            Object obj = linkedHashMap.get(fValueOf);
            if (obj == null) {
                DashPathEffect dashPathEffect = new DashPathEffect(style == TextDecorationStyle.DOTTED ? new float[]{f2, 2.0f * f2} : new float[]{4.0f * f2, 2.0f * f2}, 0.0f);
                linkedHashMap.put(fValueOf, dashPathEffect);
                obj = dashPathEffect;
            }
            paint2.setPathEffect((PathEffect) obj);
        }
        int lineForOffset = layout.getLineForOffset(i4);
        int lineForOffset2 = layout.getLineForOffset(i2);
        if (lineForOffset > lineForOffset2) {
            return;
        }
        int i5 = lineForOffset;
        while (true) {
            float lineBaseline = layout.getLineBaseline(i5);
            float primaryHorizontal = i5 == lineForOffset ? layout.getPrimaryHorizontal(i4) : layout.getLineLeft(i5);
            float primaryHorizontal2 = i5 == lineForOffset2 ? layout.getPrimaryHorizontal(i2) : layout.getLineRight(i5);
            float fMin = Math.min(primaryHorizontal, primaryHorizontal2);
            float fMax2 = Math.max(primaryHorizontal, primaryHorizontal2);
            Paint paint3 = decorationPaint;
            int i6 = i5;
            drawDecorationLine(canvas, paint3, fMin, fMax2, yOffsetForLine.invoke(paint3, Float.valueOf(lineBaseline), Float.valueOf(f2)).floatValue(), f2, paint.density, style, scratchPath);
            if (i6 == lineForOffset2) {
                return;
            }
            i5 = i6 + 1;
            i4 = i;
            style = textDecorationStyle;
        }
    }
}
