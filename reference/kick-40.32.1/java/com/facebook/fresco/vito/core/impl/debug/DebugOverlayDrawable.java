package com.facebook.fresco.vito.core.impl.debug;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Pair;
import com.facebook.react.uimanager.ViewProps;
import com.mux.stats.sdk.core.model.ViewDeviceOrientationData;
import expo.modules.notifications.service.NotificationsService;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DebugOverlayDrawable.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 @2\u00020\u0001:\u0001@B\u001d\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u00032\b\b\u0002\u0010.\u001a\u00020\u0005H\u0007J\u0006\u0010/\u001a\u00020\u001bJ\u0010\u00100\u001a\u00020\u001b2\u0006\u00101\u001a\u00020\u001aH\u0014J\u0010\u00102\u001a\u00020\u001b2\u0006\u00103\u001a\u000204H\u0016J\u0010\u00105\u001a\u00020\u001b2\u0006\u00106\u001a\u00020\u0005H\u0016J\u0012\u00107\u001a\u00020\u001b2\b\u00108\u001a\u0004\u0018\u000109H\u0016J\b\u0010:\u001a\u00020\u0005H\u0016J\u0010\u0010;\u001a\u00020\u001b2\u0006\u00101\u001a\u00020\u001aH\u0002J(\u0010<\u001a\u00020\u001b2\u0006\u00103\u001a\u0002042\u0006\u0010=\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u0005H\u0004J8\u0010<\u001a\u00020\u001b2\u0006\u00103\u001a\u0002042\u0006\u0010>\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u0005H\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R(\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR&\u0010 \u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\"0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/debug/DebugOverlayDrawable;", "Landroid/graphics/drawable/Drawable;", NotificationsService.IDENTIFIER_KEY, "", "identifierColor", "", "<init>", "(Ljava/lang/String;I)V", "getIdentifier", "()Ljava/lang/String;", ViewProps.BACKGROUND_COLOR, "getBackgroundColor", "()I", "setBackgroundColor", "(I)V", "textGravity", "getTextGravity", "setTextGravity", "drawIdentifier", "", "getDrawIdentifier", "()Z", "setDrawIdentifier", "(Z)V", "onBoundsChangedCallback", "Lkotlin/Function1;", "Landroid/graphics/Rect;", "", "getOnBoundsChangedCallback", "()Lkotlin/jvm/functions/Function1;", "setOnBoundsChangedCallback", "(Lkotlin/jvm/functions/Function1;)V", "debugData", "Ljava/util/LinkedHashMap;", "Landroid/util/Pair;", "paint", "Landroid/graphics/Paint;", "maxLineLength", "startTextXPx", "startTextYPx", "lineIncrementPx", "currentTextXPx", "currentTextYPx", "addDebugData", "key", "value", "color", "reset", "onBoundsChange", "bounds", "draw", "canvas", "Landroid/graphics/Canvas;", "setAlpha", "alpha", "setColorFilter", "cf", "Landroid/graphics/ColorFilter;", "getOpacity", "prepareDebugTextParameters", "addDebugText", "label", ViewDeviceOrientationData.DEVICE_ORIENTATION_X, ViewDeviceOrientationData.DEVICE_ORIENTATION_Y, "Companion", "core-common-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class DebugOverlayDrawable extends Drawable {
    private static final int INITIAL_MAX_LINE_LENGTH = 4;
    private static final int MARGIN = 2;
    private static final int MAX_TEXT_SIZE_PX = 72;
    private static final int MIN_TEXT_SIZE_PX = 9;
    private static final int OUTLINE_COLOR = -26624;
    private static final int OUTLINE_STROKE_WIDTH_PX = 2;
    private static final int TEXT_BACKGROUND_COLOR = 1711276032;
    private static final int TEXT_COLOR = -1;
    private static final int TEXT_LINE_SPACING_PX = 4;
    private static final int TEXT_PADDING_PX = 10;
    private int backgroundColor;
    private int currentTextXPx;
    private int currentTextYPx;
    private final LinkedHashMap<String, Pair<String, Integer>> debugData;
    private boolean drawIdentifier;
    private final String identifier;
    private final int identifierColor;
    private int lineIncrementPx;
    private int maxLineLength;
    private Function1<? super Rect, Unit> onBoundsChangedCallback;
    private final Paint paint;
    private int startTextXPx;
    private int startTextYPx;
    private int textGravity;

    /* JADX WARN: Multi-variable type inference failed */
    public DebugOverlayDrawable() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DebugOverlayDrawable(String identifier) {
        this(identifier, 0, 2, null);
        Intrinsics.checkNotNullParameter(identifier, "identifier");
    }

    public final void addDebugData(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        addDebugData$default(this, key, value, 0, 4, null);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter cf) {
    }

    public /* synthetic */ DebugOverlayDrawable(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? -16711936 : i);
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public DebugOverlayDrawable(String identifier, int i) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        this.identifier = identifier;
        this.identifierColor = i;
        this.textGravity = 48;
        this.drawIdentifier = true;
        this.debugData = new LinkedHashMap<>();
        this.paint = new Paint(1);
        this.maxLineLength = 4;
        reset();
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final void setBackgroundColor(int i) {
        this.backgroundColor = i;
    }

    public final int getTextGravity() {
        return this.textGravity;
    }

    public final void setTextGravity(int i) {
        this.textGravity = i;
    }

    public final boolean getDrawIdentifier() {
        return this.drawIdentifier;
    }

    public final void setDrawIdentifier(boolean z) {
        this.drawIdentifier = z;
    }

    public final Function1<Rect, Unit> getOnBoundsChangedCallback() {
        return this.onBoundsChangedCallback;
    }

    public final void setOnBoundsChangedCallback(Function1<? super Rect, Unit> function1) {
        this.onBoundsChangedCallback = function1;
    }

    public static /* synthetic */ void addDebugData$default(DebugOverlayDrawable debugOverlayDrawable, String str, String str2, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addDebugData");
        }
        if ((i2 & 4) != 0) {
            i = -1;
        }
        debugOverlayDrawable.addDebugData(str, str2, i);
    }

    public final void addDebugData(String key, String value, int color) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.debugData.put(key, new Pair<>(value, Integer.valueOf(color)));
        this.maxLineLength = Math.max(value.length(), this.maxLineLength);
        Rect bounds = getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
        prepareDebugTextParameters(bounds);
    }

    public final void reset() {
        this.debugData.clear();
        this.maxLineLength = 4;
        this.onBoundsChangedCallback = null;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        super.onBoundsChange(bounds);
        prepareDebugTextParameters(bounds);
        Function1<? super Rect, Unit> function1 = this.onBoundsChangedCallback;
        if (function1 != null) {
            function1.invoke(bounds);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(2.0f);
        this.paint.setColor(OUTLINE_COLOR);
        canvas.drawRect(getBounds().left, getBounds().top, getBounds().right, getBounds().bottom, this.paint);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(this.backgroundColor);
        canvas.drawRect(getBounds().left, getBounds().top, getBounds().right, getBounds().bottom, this.paint);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setStrokeWidth(0.0f);
        this.paint.setColor(-1);
        this.currentTextXPx = this.startTextXPx;
        this.currentTextYPx = this.startTextYPx;
        if (this.drawIdentifier) {
            addDebugText(canvas, "Vito", this.identifier, this.identifierColor);
        }
        for (Map.Entry<String, Pair<String, Integer>> entry : this.debugData.entrySet()) {
            String key = entry.getKey();
            Pair<String, Integer> value = entry.getValue();
            Object first = value.first;
            Intrinsics.checkNotNullExpressionValue(first, "first");
            Object second = value.second;
            Intrinsics.checkNotNullExpressionValue(second, "second");
            addDebugText(canvas, key, (String) first, ((Number) second).intValue());
        }
    }

    private final void prepareDebugTextParameters(Rect bounds) {
        if (this.debugData.isEmpty() || this.maxLineLength <= 0) {
            return;
        }
        int iMin = Math.min(72, Math.max(9, Math.min(bounds.width() / this.maxLineLength, bounds.height() / this.debugData.size())));
        this.paint.setTextSize(iMin);
        this.lineIncrementPx = iMin + 4;
        this.startTextXPx = bounds.left + 10;
        this.startTextYPx = this.textGravity == 80 ? bounds.bottom - 10 : bounds.top + 10 + iMin;
    }

    protected final void addDebugText(Canvas canvas, String label, String value, int color) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(value, "value");
        String str = label + ": ";
        float fMeasureText = this.paint.measureText(str);
        float fMeasureText2 = this.paint.measureText(value);
        this.paint.setColor(TEXT_BACKGROUND_COLOR);
        int i = this.currentTextXPx;
        int i2 = this.currentTextYPx;
        canvas.drawRect(i - 2, i2 + 4, i + fMeasureText + fMeasureText2 + 2.0f, (i2 - this.lineIncrementPx) + 4, this.paint);
        this.paint.setColor(-1);
        canvas.drawText(str, this.currentTextXPx, this.currentTextYPx, this.paint);
        this.paint.setColor(color);
        canvas.drawText(value, this.currentTextXPx + fMeasureText, this.currentTextYPx, this.paint);
        int i3 = this.textGravity;
        int i4 = this.currentTextYPx;
        if (i3 == 80) {
            this.currentTextYPx = i4 - this.lineIncrementPx;
        } else {
            this.currentTextYPx = i4 + this.lineIncrementPx;
        }
    }

    protected final void addDebugText(Canvas canvas, int x, int y, String label, String value, int color) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(value, "value");
        String str = label + ": ";
        float fMeasureText = this.paint.measureText(str);
        float fMeasureText2 = this.paint.measureText(value);
        this.paint.setColor(TEXT_BACKGROUND_COLOR);
        canvas.drawRect(x - 2, y + 4, x + fMeasureText + fMeasureText2 + 2.0f, y + this.lineIncrementPx + 4, this.paint);
        this.paint.setColor(-1);
        canvas.drawText(str, this.currentTextXPx, this.currentTextYPx, this.paint);
        this.paint.setColor(color);
        canvas.drawText(value, this.currentTextXPx + fMeasureText, this.currentTextYPx, this.paint);
        this.currentTextYPx += this.lineIncrementPx;
    }
}
