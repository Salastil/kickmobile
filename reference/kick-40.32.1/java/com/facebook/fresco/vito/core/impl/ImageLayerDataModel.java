package com.facebook.fresco.vito.core.impl;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.fresco.vito.options.BorderOptions;
import com.facebook.fresco.vito.options.RoundingOptions;
import com.facebook.fresco.vito.renderer.BitmapImageDataModel;
import com.facebook.fresco.vito.renderer.CanvasTransformation;
import com.facebook.fresco.vito.renderer.CanvasTransformationHandler;
import com.facebook.fresco.vito.renderer.ImageDataModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImageLayerDataModel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B7\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010+\u001a\u0004\u0018\u00010\u0014JN\u0010,\u001a\u00020\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&J\u0006\u00100\u001a\u00020\u0006J\u001a\u00101\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u001a2\b\b\u0002\u00102\u001a\u000203H\u0002J\u000e\u00104\u001a\u00020\u00062\u0006\u00105\u001a\u00020#J\u0010\u00106\u001a\u00020\u00062\b\b\u0002\u00107\u001a\u00020\bJ\u000e\u00108\u001a\u00020\u00062\u0006\u00109\u001a\u000203J\u0018\u0010:\u001a\u00020\u00062\u0006\u00109\u001a\u0002032\b\b\u0002\u0010;\u001a\u00020\bJ\u000e\u0010<\u001a\u00020\u00062\u0006\u00102\u001a\u000203J\u0006\u0010=\u001a\u000203J\u0006\u0010>\u001a\u00020\bR$\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010!\u001a\u0016\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u0006\u0018\u00010\"j\u0004\u0018\u0001`$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/ImageLayerDataModel;", "", "drawableCallbackProvider", "Lkotlin/Function0;", "Landroid/graphics/drawable/Drawable$Callback;", "invalidateLayerCallback", "", "optimizeAlphaHandling", "", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Z)V", "getDrawableCallbackProvider", "()Lkotlin/jvm/functions/Function0;", "setDrawableCallbackProvider", "(Lkotlin/jvm/functions/Function0;)V", "getInvalidateLayerCallback", "setInvalidateLayerCallback", "getOptimizeAlphaHandling", "()Z", "dataModel", "Lcom/facebook/fresco/vito/renderer/ImageDataModel;", "roundingOptions", "Lcom/facebook/fresco/vito/options/RoundingOptions;", "borderOptions", "Lcom/facebook/fresco/vito/options/BorderOptions;", "currentBounds", "Landroid/graphics/Rect;", "canvasTransformationHandler", "Lcom/facebook/fresco/vito/renderer/CanvasTransformationHandler;", "getCanvasTransformationHandler", "()Lcom/facebook/fresco/vito/renderer/CanvasTransformationHandler;", "paint", "Landroid/graphics/Paint;", "renderCommand", "Lkotlin/Function1;", "Landroid/graphics/Canvas;", "Lcom/facebook/fresco/vito/renderer/RenderCommand;", "colorFilter", "Landroid/graphics/ColorFilter;", "fadeAnimator", "Landroid/animation/ValueAnimator;", "animatorUpdateListener", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "getDataModel", "configure", "canvasTransformation", "Lcom/facebook/fresco/vito/renderer/CanvasTransformation;", "bounds", "invalidateRenderCommand", "computeRenderCommand", "alpha", "", "draw", "canvas", "reset", "endAnimator", "fadeIn", "durationMs", "fadeOut", "resetLayerWhenInvisible", "setAlpha", "getAlpha", "hasBitmapWithGainmap", "core-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ImageLayerDataModel {
    private final ValueAnimator.AnimatorUpdateListener animatorUpdateListener;
    private BorderOptions borderOptions;
    private final CanvasTransformationHandler canvasTransformationHandler;
    private ColorFilter colorFilter;
    private Rect currentBounds;
    private ImageDataModel dataModel;
    private Function0<? extends Drawable.Callback> drawableCallbackProvider;
    private ValueAnimator fadeAnimator;
    private Function0<Unit> invalidateLayerCallback;
    private final boolean optimizeAlphaHandling;
    private final Paint paint;
    private Function1<? super Canvas, Unit> renderCommand;
    private RoundingOptions roundingOptions;

    public ImageLayerDataModel() {
        this(null, null, false, 7, null);
    }

    public ImageLayerDataModel(Function0<? extends Drawable.Callback> function0, Function0<Unit> function1, boolean z) {
        this.drawableCallbackProvider = function0;
        this.invalidateLayerCallback = function1;
        this.optimizeAlphaHandling = z;
        this.canvasTransformationHandler = new CanvasTransformationHandler(null);
        this.paint = new Paint();
        this.animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.facebook.fresco.vito.core.impl.ImageLayerDataModel$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ImageLayerDataModel.animatorUpdateListener$lambda$0(this.f$0, valueAnimator);
            }
        };
    }

    public /* synthetic */ ImageLayerDataModel(Function0 function0, Function0 function1, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : function0, (i & 2) != 0 ? null : function1, (i & 4) != 0 ? false : z);
    }

    public final Function0<Drawable.Callback> getDrawableCallbackProvider() {
        return this.drawableCallbackProvider;
    }

    public final void setDrawableCallbackProvider(Function0<? extends Drawable.Callback> function0) {
        this.drawableCallbackProvider = function0;
    }

    public final Function0<Unit> getInvalidateLayerCallback() {
        return this.invalidateLayerCallback;
    }

    public final void setInvalidateLayerCallback(Function0<Unit> function0) {
        this.invalidateLayerCallback = function0;
    }

    public final boolean getOptimizeAlphaHandling() {
        return this.optimizeAlphaHandling;
    }

    public final CanvasTransformationHandler getCanvasTransformationHandler() {
        return this.canvasTransformationHandler;
    }

    static final void animatorUpdateListener$lambda$0(ImageLayerDataModel imageLayerDataModel, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        imageLayerDataModel.setAlpha(((Integer) animatedValue).intValue());
    }

    public final ImageDataModel getDataModel() {
        return this.dataModel;
    }

    public static /* synthetic */ void configure$default(ImageLayerDataModel imageLayerDataModel, ImageDataModel imageDataModel, RoundingOptions roundingOptions, BorderOptions borderOptions, CanvasTransformation canvasTransformation, Rect rect, ColorFilter colorFilter, int i, Object obj) {
        if ((i & 1) != 0) {
            imageDataModel = imageLayerDataModel.dataModel;
        }
        if ((i & 2) != 0) {
            roundingOptions = imageLayerDataModel.roundingOptions;
        }
        if ((i & 4) != 0) {
            borderOptions = imageLayerDataModel.borderOptions;
        }
        if ((i & 8) != 0) {
            canvasTransformation = imageLayerDataModel.canvasTransformationHandler.getCanvasTransformation();
        }
        if ((i & 16) != 0) {
            rect = imageLayerDataModel.currentBounds;
        }
        if ((i & 32) != 0) {
            colorFilter = imageLayerDataModel.colorFilter;
        }
        Rect rect2 = rect;
        ColorFilter colorFilter2 = colorFilter;
        imageLayerDataModel.configure(imageDataModel, roundingOptions, borderOptions, canvasTransformation, rect2, colorFilter2);
    }

    public final void configure(ImageDataModel dataModel, RoundingOptions roundingOptions, BorderOptions borderOptions, CanvasTransformation canvasTransformation, Rect bounds, ColorFilter colorFilter) {
        if (!Intrinsics.areEqual(dataModel, this.dataModel)) {
            ImageDataModel imageDataModel = this.dataModel;
            if (imageDataModel != null) {
                imageDataModel.onDetach();
                imageDataModel.setCallback(null);
            }
            if (dataModel != null) {
                Function0<? extends Drawable.Callback> function0 = this.drawableCallbackProvider;
                dataModel.setCallback(function0 != null ? function0.invoke() : null);
                dataModel.onAttach();
            } else {
                dataModel = null;
            }
            this.dataModel = dataModel;
        }
        this.roundingOptions = roundingOptions;
        this.borderOptions = borderOptions;
        this.currentBounds = bounds;
        this.colorFilter = colorFilter;
        this.canvasTransformationHandler.setCanvasTransformation(canvasTransformation);
        invalidateRenderCommand();
        if (bounds != null) {
            computeRenderCommand$default(this, bounds, 0, 2, null);
        }
    }

    public final void invalidateRenderCommand() {
        this.renderCommand = null;
    }

    static /* synthetic */ void computeRenderCommand$default(ImageLayerDataModel imageLayerDataModel, Rect rect, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 255;
        }
        imageLayerDataModel.computeRenderCommand(rect, i);
    }

    private final void computeRenderCommand(Rect bounds, int alpha) {
        ImageDataModel imageDataModel = this.dataModel;
        if (imageDataModel == null) {
            this.renderCommand = null;
            return;
        }
        if (this.renderCommand == null || !Intrinsics.areEqual(this.currentBounds, bounds)) {
            this.currentBounds = bounds;
            this.canvasTransformationHandler.configure(bounds, imageDataModel.getWidth(), imageDataModel.getHeight());
            this.paint.setColorFilter(this.colorFilter);
            this.paint.setFlags(imageDataModel.getDefaultPaintFlags());
            this.renderCommand = ImageWithTransformationAndBorderRenderer.INSTANCE.createRenderCommand(imageDataModel, this.roundingOptions, this.borderOptions, this.canvasTransformationHandler.getDrawMatrix(), bounds, this.paint, alpha);
        }
    }

    public final void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Function1<? super Canvas, Unit> function1 = this.renderCommand;
        if (function1 != null) {
            function1.invoke(canvas);
        }
    }

    public static /* synthetic */ void reset$default(ImageLayerDataModel imageLayerDataModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        imageLayerDataModel.reset(z);
    }

    public final void reset(boolean endAnimator) {
        ValueAnimator valueAnimator;
        this.canvasTransformationHandler.setCanvasTransformation(null);
        ImageDataModel imageDataModel = this.dataModel;
        if (imageDataModel != null) {
            imageDataModel.onDetach();
            imageDataModel.setCallback(null);
        }
        this.dataModel = null;
        this.roundingOptions = null;
        this.borderOptions = null;
        this.renderCommand = null;
        this.currentBounds = null;
        this.paint.reset();
        this.colorFilter = null;
        if (endAnimator && (valueAnimator = this.fadeAnimator) != null) {
            valueAnimator.end();
        }
        this.fadeAnimator = null;
    }

    public final void fadeIn(int durationMs) {
        ValueAnimator valueAnimator = this.fadeAnimator;
        if (valueAnimator != null) {
            valueAnimator.end();
        }
        if (durationMs == 0) {
            this.paint.setAlpha(255);
            return;
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 255);
        valueAnimatorOfInt.setDuration(durationMs);
        valueAnimatorOfInt.addUpdateListener(this.animatorUpdateListener);
        valueAnimatorOfInt.start();
        this.fadeAnimator = valueAnimatorOfInt;
    }

    public static /* synthetic */ void fadeOut$default(ImageLayerDataModel imageLayerDataModel, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        imageLayerDataModel.fadeOut(i, z);
    }

    public final void fadeOut(int durationMs, boolean resetLayerWhenInvisible) {
        ValueAnimator valueAnimator = this.fadeAnimator;
        if (valueAnimator != null) {
            valueAnimator.end();
        }
        if (durationMs == 0) {
            this.paint.setAlpha(0);
            return;
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(255, 0);
        valueAnimatorOfInt.setDuration(durationMs);
        valueAnimatorOfInt.addUpdateListener(this.animatorUpdateListener);
        if (resetLayerWhenInvisible) {
            valueAnimatorOfInt.addListener(new AnimatorListenerAdapter() { // from class: com.facebook.fresco.vito.core.impl.ImageLayerDataModel$fadeOut$1$1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    this.this$0.reset(false);
                }
            });
        }
        valueAnimatorOfInt.start();
        this.fadeAnimator = valueAnimatorOfInt;
    }

    public final void setAlpha(int alpha) {
        if (this.optimizeAlphaHandling && this.paint.getAlpha() == alpha) {
            return;
        }
        this.paint.setAlpha(alpha);
        Function0<Unit> function0 = this.invalidateLayerCallback;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final int getAlpha() {
        return this.paint.getAlpha();
    }

    public final boolean hasBitmapWithGainmap() {
        ImageDataModel imageDataModel = this.dataModel;
        return (imageDataModel instanceof BitmapImageDataModel) && ((BitmapImageDataModel) imageDataModel).hasGainmap();
    }
}
