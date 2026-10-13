package com.facebook.fresco.animation.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck;
import com.facebook.fresco.animation.backend.AnimationInformation;
import com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparationStrategy;
import com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparer;
import com.facebook.fresco.ui.common.DimensionsInfo;
import com.facebook.fresco.vito.core.AnimatedImagePerfLoggingListener;
import com.facebook.fresco.vito.core.FrescoController2;
import com.facebook.fresco.vito.core.FrescoDrawableInterface;
import com.facebook.fresco.vito.core.VitoImagePipeline;
import com.facebook.fresco.vito.listener.ImageListener;
import com.facebook.fresco.vito.options.AnimatedOptions;
import com.facebook.fresco.vito.options.ImageOptions;
import com.facebook.fresco.vito.options.RoundingOptions;
import com.facebook.fresco.vito.provider.FrescoVitoProvider;
import com.facebook.fresco.vito.source.ImageSourceProvider;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imageutils.JfifUtil;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BitmapAnimationBackend.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 o2\u00020\u00012\u00020\u0002:\u0003mnoB]\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010:\u001a\u00020;2\b\u0010/\u001a\u0004\u0018\u000100J\u0010\u0010<\u001a\u00020;2\b\u0010=\u001a\u0004\u0018\u000104J\b\u0010>\u001a\u00020(H\u0016J\u0010\u0010?\u001a\u00020(2\u0006\u0010@\u001a\u00020(H\u0016J\b\u0010A\u001a\u00020(H\u0016J\b\u0010B\u001a\u00020(H\u0016J\b\u0010C\u001a\u00020(H\u0016J\b\u0010D\u001a\u00020(H\u0016J \u0010E\u001a\u00020\f2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020I2\u0006\u0010@\u001a\u00020(H\u0016J \u0010J\u001a\u00020\f2\u0006\u0010H\u001a\u00020I2\u0006\u0010@\u001a\u00020(2\u0006\u0010K\u001a\u00020(H\u0002J\u0012\u0010L\u001a\u00020;2\b\b\u0001\u0010M\u001a\u00020(H\u0016J\u0012\u0010N\u001a\u00020;2\b\u0010O\u001a\u0004\u0018\u00010PH\u0016J\u0012\u0010Q\u001a\u00020;2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010R\u001a\u00020(H\u0016J\b\u0010S\u001a\u00020(H\u0016J\b\u0010T\u001a\u00020(H\u0016J\b\u0010U\u001a\u00020;H\u0016J\b\u0010V\u001a\u00020;H\u0016J\b\u0010W\u001a\u00020;H\u0016J\u0012\u0010X\u001a\u00020;2\b\u0010=\u001a\u0004\u0018\u000102H\u0016J\b\u0010Y\u001a\u00020;H\u0002J \u0010Z\u001a\u00020\f2\u0006\u0010@\u001a\u00020(2\u000e\u0010[\u001a\n\u0012\u0004\u0012\u00020]\u0018\u00010\\H\u0002J(\u0010^\u001a\u00020\f2\u0006\u0010@\u001a\u00020(2\u0006\u0010_\u001a\u00020]2\u0006\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020aH\u0002J \u0010c\u001a\u00020;2\u0006\u0010@\u001a\u00020(2\u0006\u0010_\u001a\u00020]2\u0006\u0010H\u001a\u00020IH\u0002J0\u0010d\u001a\u00020\f2\u0006\u0010@\u001a\u00020(2\u000e\u0010e\u001a\n\u0012\u0004\u0012\u00020]\u0018\u00010\\2\u0006\u0010H\u001a\u00020I2\u0006\u0010K\u001a\u00020(H\u0002J\b\u0010f\u001a\u00020;H\u0002J\u0010\u0010g\u001a\u00020;2\u0006\u0010h\u001a\u00020iH\u0002J\b\u0010j\u001a\u00020\fH\u0002J\u0010\u0010k\u001a\u00020\f2\u0006\u0010H\u001a\u00020IH\u0002J\u0010\u0010l\u001a\u00020;2\u0006\u0010@\u001a\u00020(H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006p"}, d2 = {"Lcom/facebook/fresco/animation/bitmap/BitmapAnimationBackend;", "Lcom/facebook/fresco/animation/backend/AnimationBackend;", "Lcom/facebook/fresco/animation/backend/AnimationBackendDelegateWithInactivityCheck$InactivityListener;", "platformBitmapFactory", "Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;", "bitmapFrameCache", "Lcom/facebook/fresco/animation/bitmap/BitmapFrameCache;", "animationInformation", "Lcom/facebook/fresco/animation/backend/AnimationInformation;", "bitmapFrameRenderer", "Lcom/facebook/fresco/animation/bitmap/BitmapFrameRenderer;", "isNewRenderImplementation", "", "bitmapFramePreparationStrategy", "Lcom/facebook/fresco/animation/bitmap/preparation/BitmapFramePreparationStrategy;", "bitmapFramePreparer", "Lcom/facebook/fresco/animation/bitmap/preparation/BitmapFramePreparer;", "roundingOptions", "Lcom/facebook/fresco/vito/options/RoundingOptions;", "animatedOptions", "Lcom/facebook/fresco/vito/options/AnimatedOptions;", "<init>", "(Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;Lcom/facebook/fresco/animation/bitmap/BitmapFrameCache;Lcom/facebook/fresco/animation/backend/AnimationInformation;Lcom/facebook/fresco/animation/bitmap/BitmapFrameRenderer;ZLcom/facebook/fresco/animation/bitmap/preparation/BitmapFramePreparationStrategy;Lcom/facebook/fresco/animation/bitmap/preparation/BitmapFramePreparer;Lcom/facebook/fresco/vito/options/RoundingOptions;Lcom/facebook/fresco/vito/options/AnimatedOptions;)V", "getRoundingOptions", "()Lcom/facebook/fresco/vito/options/RoundingOptions;", "getAnimatedOptions", "()Lcom/facebook/fresco/vito/options/AnimatedOptions;", "isCircular", "isAntiAliased", "cornerRadii", "", "getCornerRadii", "()[F", "bitmapConfig", "Landroid/graphics/Bitmap$Config;", "paint", "Landroid/graphics/Paint;", "bounds", "Landroid/graphics/Rect;", "bitmapWidth", "", "bitmapHeight", "path", "Landroid/graphics/Path;", "matrix", "Landroid/graphics/Matrix;", "pathFrameNumber", "frameListener", "Lcom/facebook/fresco/animation/bitmap/BitmapAnimationBackend$FrameListener;", "animationListener", "Lcom/facebook/fresco/animation/backend/AnimationBackend$Listener;", "animatedImagePerfLoggingListener", "Lcom/facebook/fresco/vito/core/AnimatedImagePerfLoggingListener;", "thumbnailDrawable", "Lcom/facebook/fresco/vito/core/FrescoDrawableInterface;", "animationCompleted", "totalFramesProcessed", "lastFrameNumber", "setFrameListener", "", "setAnimatedImagePerfLoggingListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "getFrameCount", "getFrameDurationMs", "frameNumber", ViewProps.WIDTH, ViewProps.HEIGHT, "getLoopDurationMs", "getLoopCount", "drawFrame", "parent", "Landroid/graphics/drawable/Drawable;", "canvas", "Landroid/graphics/Canvas;", "drawFrameOrFallback", "frameType", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "setBounds", "getIntrinsicWidth", "getIntrinsicHeight", "getSizeInBytes", "clear", "preloadAnimation", "onInactive", "setAnimationListener", "updateBitmapDimensions", "renderFrameInBitmap", "targetBitmap", "Lcom/facebook/common/references/CloseableReference;", "Landroid/graphics/Bitmap;", "updatePath", "bitmap", "currentBoundsWidth", "", "currentBoundsHeight", "drawBitmap", "drawBitmapAndCache", "bitmapReference", "initializeThumbnailDrawable", "loadFrescoThumbnail", "thumbnailUrl", "", "showThumbnail", "drawThumbnail", "trackAnimationProgress", "FrameListener", "FrameType", "Companion", "animated-drawable_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BitmapAnimationBackend implements AnimationBackend, AnimationBackendDelegateWithInactivityCheck.InactivityListener {
    private static final String CALLER_CONTEXT = "BitmapAnimationBackend";
    public static final int FRAME_TYPE_CACHED = 0;
    public static final int FRAME_TYPE_CREATED = 2;
    public static final int FRAME_TYPE_FALLBACK = 3;
    public static final int FRAME_TYPE_REUSED = 1;
    public static final int FRAME_TYPE_UNKNOWN = -1;
    private AnimatedImagePerfLoggingListener animatedImagePerfLoggingListener;
    private final AnimatedOptions animatedOptions;
    private boolean animationCompleted;
    private final AnimationInformation animationInformation;
    private AnimationBackend.Listener animationListener;
    private final Bitmap.Config bitmapConfig;
    private final BitmapFrameCache bitmapFrameCache;
    private final BitmapFramePreparationStrategy bitmapFramePreparationStrategy;
    private final BitmapFramePreparer bitmapFramePreparer;
    private final BitmapFrameRenderer bitmapFrameRenderer;
    private int bitmapHeight;
    private int bitmapWidth;
    private Rect bounds;
    private final float[] cornerRadii;
    private FrameListener frameListener;
    private final boolean isAntiAliased;
    private final boolean isCircular;
    private final boolean isNewRenderImplementation;
    private int lastFrameNumber;
    private final Matrix matrix;
    private final Paint paint;
    private final Path path;
    private int pathFrameNumber;
    private final PlatformBitmapFactory platformBitmapFactory;
    private final RoundingOptions roundingOptions;
    private FrescoDrawableInterface thumbnailDrawable;
    private int totalFramesProcessed;
    private static final Class<BitmapAnimationBackend> TAG = BitmapAnimationBackend.class;

    /* JADX INFO: compiled from: BitmapAnimationBackend.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/facebook/fresco/animation/bitmap/BitmapAnimationBackend$FrameListener;", "", "onDrawFrameStart", "", "backend", "Lcom/facebook/fresco/animation/bitmap/BitmapAnimationBackend;", "frameNumber", "", "onFrameDrawn", "frameType", "onFrameDropped", "animated-drawable_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface FrameListener {
        void onDrawFrameStart(BitmapAnimationBackend backend, int frameNumber);

        void onFrameDrawn(BitmapAnimationBackend backend, int frameNumber, int frameType);

        void onFrameDropped(BitmapAnimationBackend backend, int frameNumber);
    }

    /* JADX INFO: compiled from: BitmapAnimationBackend.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/facebook/fresco/animation/bitmap/BitmapAnimationBackend$FrameType;", "", "animated-drawable_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface FrameType {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BitmapAnimationBackend(PlatformBitmapFactory platformBitmapFactory, BitmapFrameCache bitmapFrameCache, AnimationInformation animationInformation, BitmapFrameRenderer bitmapFrameRenderer, boolean z, BitmapFramePreparationStrategy bitmapFramePreparationStrategy, BitmapFramePreparer bitmapFramePreparer) {
        this(platformBitmapFactory, bitmapFrameCache, animationInformation, bitmapFrameRenderer, z, bitmapFramePreparationStrategy, bitmapFramePreparer, null, null, 384, null);
        Intrinsics.checkNotNullParameter(platformBitmapFactory, "platformBitmapFactory");
        Intrinsics.checkNotNullParameter(bitmapFrameCache, "bitmapFrameCache");
        Intrinsics.checkNotNullParameter(animationInformation, "animationInformation");
        Intrinsics.checkNotNullParameter(bitmapFrameRenderer, "bitmapFrameRenderer");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BitmapAnimationBackend(PlatformBitmapFactory platformBitmapFactory, BitmapFrameCache bitmapFrameCache, AnimationInformation animationInformation, BitmapFrameRenderer bitmapFrameRenderer, boolean z, BitmapFramePreparationStrategy bitmapFramePreparationStrategy, BitmapFramePreparer bitmapFramePreparer, RoundingOptions roundingOptions) {
        this(platformBitmapFactory, bitmapFrameCache, animationInformation, bitmapFrameRenderer, z, bitmapFramePreparationStrategy, bitmapFramePreparer, roundingOptions, null, 256, null);
        Intrinsics.checkNotNullParameter(platformBitmapFactory, "platformBitmapFactory");
        Intrinsics.checkNotNullParameter(bitmapFrameCache, "bitmapFrameCache");
        Intrinsics.checkNotNullParameter(animationInformation, "animationInformation");
        Intrinsics.checkNotNullParameter(bitmapFrameRenderer, "bitmapFrameRenderer");
    }

    public BitmapAnimationBackend(PlatformBitmapFactory platformBitmapFactory, BitmapFrameCache bitmapFrameCache, AnimationInformation animationInformation, BitmapFrameRenderer bitmapFrameRenderer, boolean z, BitmapFramePreparationStrategy bitmapFramePreparationStrategy, BitmapFramePreparer bitmapFramePreparer, RoundingOptions roundingOptions, AnimatedOptions animatedOptions) {
        Intrinsics.checkNotNullParameter(platformBitmapFactory, "platformBitmapFactory");
        Intrinsics.checkNotNullParameter(bitmapFrameCache, "bitmapFrameCache");
        Intrinsics.checkNotNullParameter(animationInformation, "animationInformation");
        Intrinsics.checkNotNullParameter(bitmapFrameRenderer, "bitmapFrameRenderer");
        this.platformBitmapFactory = platformBitmapFactory;
        this.bitmapFrameCache = bitmapFrameCache;
        this.animationInformation = animationInformation;
        this.bitmapFrameRenderer = bitmapFrameRenderer;
        this.isNewRenderImplementation = z;
        this.bitmapFramePreparationStrategy = bitmapFramePreparationStrategy;
        this.bitmapFramePreparer = bitmapFramePreparer;
        this.roundingOptions = roundingOptions;
        this.animatedOptions = animatedOptions;
        boolean z2 = roundingOptions != null && roundingOptions.isCircular();
        this.isCircular = z2;
        this.isAntiAliased = roundingOptions != null && roundingOptions.isAntiAliased();
        float[] cornerRadii = null;
        if (roundingOptions != null && !z2) {
            if (roundingOptions.getCornerRadius() != 0.0f) {
                float[] fArr = new float[8];
                ArraysKt.fill$default(fArr, roundingOptions.getCornerRadius(), 0, 0, 6, (Object) null);
                cornerRadii = fArr;
            } else {
                cornerRadii = roundingOptions.getCornerRadii();
            }
        }
        this.cornerRadii = cornerRadii;
        this.bitmapConfig = Bitmap.Config.ARGB_8888;
        this.paint = new Paint(6);
        this.path = new Path();
        this.matrix = new Matrix();
        this.pathFrameNumber = -1;
        this.lastFrameNumber = -1;
        initializeThumbnailDrawable();
        updateBitmapDimensions();
    }

    public /* synthetic */ BitmapAnimationBackend(PlatformBitmapFactory platformBitmapFactory, BitmapFrameCache bitmapFrameCache, AnimationInformation animationInformation, BitmapFrameRenderer bitmapFrameRenderer, boolean z, BitmapFramePreparationStrategy bitmapFramePreparationStrategy, BitmapFramePreparer bitmapFramePreparer, RoundingOptions roundingOptions, AnimatedOptions animatedOptions, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(platformBitmapFactory, bitmapFrameCache, animationInformation, bitmapFrameRenderer, z, bitmapFramePreparationStrategy, bitmapFramePreparer, (i & 128) != 0 ? null : roundingOptions, (i & 256) != 0 ? null : animatedOptions);
    }

    public final RoundingOptions getRoundingOptions() {
        return this.roundingOptions;
    }

    public final AnimatedOptions getAnimatedOptions() {
        return this.animatedOptions;
    }

    public final float[] getCornerRadii() {
        return this.cornerRadii;
    }

    public final void setFrameListener(FrameListener frameListener) {
        this.frameListener = frameListener;
    }

    public final void setAnimatedImagePerfLoggingListener(AnimatedImagePerfLoggingListener listener) {
        this.animatedImagePerfLoggingListener = listener;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getFrameCount() {
        return this.animationInformation.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getFrameDurationMs(int frameNumber) {
        return this.animationInformation.getFrameDurationMs(frameNumber);
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int width() {
        return this.animationInformation.width();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int height() {
        return this.animationInformation.height();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getLoopDurationMs() {
        return this.animationInformation.getLoopDurationMs();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getLoopCount() {
        AnimatedOptions animatedOptions = this.animatedOptions;
        if (animatedOptions == null) {
            return this.animationInformation.getLoopCount();
        }
        if (animatedOptions.getLoopCount() == 0) {
            return 0;
        }
        return this.animatedOptions.getLoopCount();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public boolean drawFrame(Drawable parent, Canvas canvas, int frameNumber) throws Throwable {
        BitmapFramePreparer bitmapFramePreparer;
        BitmapFramePreparationStrategy bitmapFramePreparationStrategy;
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        FrameListener frameListener = this.frameListener;
        if (frameListener != null) {
            frameListener.onDrawFrameStart(this, frameNumber);
        }
        if (showThumbnail() && drawThumbnail(canvas)) {
            return true;
        }
        boolean zDrawFrameOrFallback = drawFrameOrFallback(canvas, frameNumber, 0);
        trackAnimationProgress(frameNumber);
        if (!zDrawFrameOrFallback) {
            FrameListener frameListener2 = this.frameListener;
            if (frameListener2 != null) {
                frameListener2.onFrameDropped(this, frameNumber);
            }
            String string = this.animationInformation.toString();
            long jCurrentTimeMillis = System.currentTimeMillis();
            AnimatedImagePerfLoggingListener animatedImagePerfLoggingListener = this.animatedImagePerfLoggingListener;
            if (animatedImagePerfLoggingListener != null) {
                animatedImagePerfLoggingListener.onFrameDropped(string, frameNumber, jCurrentTimeMillis);
            }
        }
        if (!this.isNewRenderImplementation && (bitmapFramePreparer = this.bitmapFramePreparer) != null && (bitmapFramePreparationStrategy = this.bitmapFramePreparationStrategy) != null) {
            BitmapFramePreparationStrategy.prepareFrames$default(bitmapFramePreparationStrategy, bitmapFramePreparer, this.bitmapFrameCache, this, frameNumber, null, 16, null);
        }
        return zDrawFrameOrFallback;
    }

    private final boolean drawFrameOrFallback(Canvas canvas, int frameNumber, int frameType) throws Throwable {
        CloseableReference<Bitmap> cachedFrame;
        boolean zDrawBitmapAndCache;
        CloseableReference<Bitmap> closeableReference = null;
        try {
            boolean z = false;
            int i = 1;
            if (this.isNewRenderImplementation) {
                BitmapFramePreparationStrategy bitmapFramePreparationStrategy = this.bitmapFramePreparationStrategy;
                CloseableReference<Bitmap> bitmapFrame = bitmapFramePreparationStrategy != null ? bitmapFramePreparationStrategy.getBitmapFrame(frameNumber, canvas.getWidth(), canvas.getHeight()) : null;
                if (bitmapFrame != null) {
                    try {
                        if (bitmapFrame.isValid()) {
                            Bitmap bitmap = bitmapFrame.get();
                            Intrinsics.checkNotNullExpressionValue(bitmap, "get(...)");
                            drawBitmap(frameNumber, bitmap, canvas);
                            CloseableReference.closeSafely(bitmapFrame);
                            return true;
                        }
                    } catch (Throwable th) {
                        th = th;
                        closeableReference = bitmapFrame;
                    }
                }
                BitmapFramePreparationStrategy bitmapFramePreparationStrategy2 = this.bitmapFramePreparationStrategy;
                if (bitmapFramePreparationStrategy2 != null) {
                    bitmapFramePreparationStrategy2.prepareFrames(canvas.getWidth(), canvas.getHeight(), null);
                }
                CloseableReference.closeSafely(bitmapFrame);
                return false;
            }
            if (frameType == 0) {
                cachedFrame = this.bitmapFrameCache.getCachedFrame(frameNumber);
                zDrawBitmapAndCache = drawBitmapAndCache(frameNumber, cachedFrame, canvas, 0);
            } else if (frameType == 1) {
                cachedFrame = this.bitmapFrameCache.getBitmapToReuseForFrame(frameNumber, this.bitmapWidth, this.bitmapHeight);
                if (renderFrameInBitmap(frameNumber, cachedFrame) && drawBitmapAndCache(frameNumber, cachedFrame, canvas, 1)) {
                    z = true;
                }
                zDrawBitmapAndCache = z;
                i = 2;
            } else if (frameType == 2) {
                try {
                    cachedFrame = this.platformBitmapFactory.createBitmap(this.bitmapWidth, this.bitmapHeight, this.bitmapConfig);
                    if (renderFrameInBitmap(frameNumber, cachedFrame) && drawBitmapAndCache(frameNumber, cachedFrame, canvas, 2)) {
                        z = true;
                    }
                    zDrawBitmapAndCache = z;
                    i = 3;
                } catch (RuntimeException e) {
                    FLog.w(TAG, "Failed to create frame bitmap", e);
                    CloseableReference.closeSafely((CloseableReference<?>) null);
                    return false;
                }
            } else {
                if (frameType != 3) {
                    CloseableReference.closeSafely((CloseableReference<?>) null);
                    return false;
                }
                cachedFrame = this.bitmapFrameCache.getFallbackFrame(frameNumber);
                zDrawBitmapAndCache = drawBitmapAndCache(frameNumber, cachedFrame, canvas, 3);
                i = -1;
            }
            CloseableReference.closeSafely(cachedFrame);
            return (zDrawBitmapAndCache || i == -1) ? zDrawBitmapAndCache : drawFrameOrFallback(canvas, frameNumber, i);
        } catch (Throwable th2) {
            th = th2;
        }
        CloseableReference.closeSafely(closeableReference);
        throw th;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setAlpha(int alpha) {
        this.paint.setAlpha(alpha);
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setBounds(Rect bounds) {
        this.bounds = bounds;
        this.bitmapFrameRenderer.setBounds(bounds);
        updateBitmapDimensions();
        Object obj = this.thumbnailDrawable;
        if (obj != null) {
            if (bounds == null) {
                bounds = new Rect(0, 0, width(), height());
            }
            ((Drawable) obj).setBounds(bounds);
        }
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    /* JADX INFO: renamed from: getIntrinsicWidth, reason: from getter */
    public int getBitmapWidth() {
        return this.bitmapWidth;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    /* JADX INFO: renamed from: getIntrinsicHeight, reason: from getter */
    public int getBitmapHeight() {
        return this.bitmapHeight;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getSizeInBytes() {
        return this.bitmapFrameCache.getSizeInBytes();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void clear() {
        if (this.isNewRenderImplementation) {
            BitmapFramePreparationStrategy bitmapFramePreparationStrategy = this.bitmapFramePreparationStrategy;
            if (bitmapFramePreparationStrategy != null) {
                bitmapFramePreparationStrategy.clearFrames();
                return;
            }
            return;
        }
        this.bitmapFrameCache.clear();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void preloadAnimation() {
        BitmapFramePreparer bitmapFramePreparer;
        if (!this.isNewRenderImplementation && (bitmapFramePreparer = this.bitmapFramePreparer) != null) {
            BitmapFramePreparationStrategy bitmapFramePreparationStrategy = this.bitmapFramePreparationStrategy;
            if (bitmapFramePreparationStrategy != null) {
                bitmapFramePreparationStrategy.prepareFrames(bitmapFramePreparer, this.bitmapFrameCache, this, 0, new Function0() { // from class: com.facebook.fresco.animation.bitmap.BitmapAnimationBackend$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BitmapAnimationBackend.preloadAnimation$lambda$2(this.f$0);
                    }
                });
                return;
            }
            return;
        }
        BitmapFramePreparationStrategy bitmapFramePreparationStrategy2 = this.bitmapFramePreparationStrategy;
        if (bitmapFramePreparationStrategy2 != null) {
            bitmapFramePreparationStrategy2.prepareFrames(this.animationInformation.width(), this.animationInformation.height(), new Function0() { // from class: com.facebook.fresco.animation.bitmap.BitmapAnimationBackend$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return BitmapAnimationBackend.preloadAnimation$lambda$3(this.f$0);
                }
            });
        }
    }

    static final Unit preloadAnimation$lambda$2(BitmapAnimationBackend bitmapAnimationBackend) {
        AnimationBackend.Listener listener = bitmapAnimationBackend.animationListener;
        if (listener != null) {
            listener.onAnimationLoaded();
        }
        return Unit.INSTANCE;
    }

    static final Unit preloadAnimation$lambda$3(BitmapAnimationBackend bitmapAnimationBackend) {
        AnimationBackend.Listener listener = bitmapAnimationBackend.animationListener;
        if (listener != null) {
            listener.onAnimationLoaded();
        }
        return Unit.INSTANCE;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck.InactivityListener
    public void onInactive() {
        if (this.isNewRenderImplementation) {
            BitmapFramePreparationStrategy bitmapFramePreparationStrategy = this.bitmapFramePreparationStrategy;
            if (bitmapFramePreparationStrategy != null) {
                bitmapFramePreparationStrategy.onStop();
            }
        } else {
            clear();
        }
        FrescoDrawableInterface frescoDrawableInterface = this.thumbnailDrawable;
        if (frescoDrawableInterface != null) {
            FrescoVitoProvider.getController().releaseImmediately(frescoDrawableInterface);
        }
        this.thumbnailDrawable = null;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setAnimationListener(AnimationBackend.Listener listener) {
        this.animationListener = listener;
    }

    private final void updateBitmapDimensions() {
        int intrinsicWidth = this.bitmapFrameRenderer.getIntrinsicWidth();
        this.bitmapWidth = intrinsicWidth;
        if (intrinsicWidth == -1) {
            Rect rect = this.bounds;
            this.bitmapWidth = rect != null ? rect.width() : -1;
        }
        int intrinsicHeight = this.bitmapFrameRenderer.getIntrinsicHeight();
        this.bitmapHeight = intrinsicHeight;
        if (intrinsicHeight == -1) {
            Rect rect2 = this.bounds;
            this.bitmapHeight = rect2 != null ? rect2.height() : -1;
        }
    }

    private final boolean renderFrameInBitmap(int frameNumber, CloseableReference<Bitmap> targetBitmap) {
        if (targetBitmap == null || !targetBitmap.isValid()) {
            return false;
        }
        BitmapFrameRenderer bitmapFrameRenderer = this.bitmapFrameRenderer;
        Bitmap bitmap = targetBitmap.get();
        Intrinsics.checkNotNullExpressionValue(bitmap, "get(...)");
        boolean zRenderFrame = bitmapFrameRenderer.renderFrame(frameNumber, bitmap);
        if (!zRenderFrame) {
            CloseableReference.closeSafely(targetBitmap);
        }
        return zRenderFrame;
    }

    private final boolean updatePath(int frameNumber, Bitmap bitmap, float currentBoundsWidth, float currentBoundsHeight) {
        if (!this.isCircular && this.cornerRadii == null) {
            return false;
        }
        if (frameNumber == this.pathFrameNumber) {
            return true;
        }
        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        this.matrix.setRectToRect(new RectF(0.0f, 0.0f, this.bitmapWidth, this.bitmapHeight), new RectF(0.0f, 0.0f, currentBoundsWidth, currentBoundsHeight), Matrix.ScaleToFit.FILL);
        bitmapShader.setLocalMatrix(this.matrix);
        this.paint.setShader(bitmapShader);
        this.paint.setAntiAlias(this.isAntiAliased);
        this.path.reset();
        if (this.isCircular) {
            float f = currentBoundsWidth / 2.0f;
            float f2 = currentBoundsHeight / 2.0f;
            this.path.addCircle(f, f2, Math.min(f, f2), Path.Direction.CW);
        } else {
            Path path = this.path;
            RectF rectF = new RectF(0.0f, 0.0f, currentBoundsWidth, currentBoundsHeight);
            float[] fArr = this.cornerRadii;
            if (fArr == null) {
                fArr = new float[0];
            }
            path.addRoundRect(rectF, fArr, Path.Direction.CW);
        }
        this.pathFrameNumber = frameNumber;
        return true;
    }

    private final void drawBitmap(int frameNumber, Bitmap bitmap, Canvas canvas) {
        Rect rect = this.bounds;
        if (rect == null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.paint);
        } else if (updatePath(frameNumber, bitmap, rect.width(), rect.height())) {
            canvas.drawPath(this.path, this.paint);
        } else {
            canvas.drawBitmap(bitmap, (Rect) null, rect, this.paint);
        }
    }

    private final boolean drawBitmapAndCache(int frameNumber, CloseableReference<Bitmap> bitmapReference, Canvas canvas, int frameType) {
        if (bitmapReference == null || !CloseableReference.isValid(bitmapReference)) {
            return false;
        }
        Bitmap bitmap = bitmapReference.get();
        Intrinsics.checkNotNullExpressionValue(bitmap, "get(...)");
        drawBitmap(frameNumber, bitmap, canvas);
        if (frameType != 3 && !this.isNewRenderImplementation) {
            this.bitmapFrameCache.onFrameRendered(frameNumber, bitmapReference, frameType);
        }
        FrameListener frameListener = this.frameListener;
        if (frameListener == null) {
            return true;
        }
        frameListener.onFrameDrawn(this, frameNumber, frameType);
        return true;
    }

    private final void initializeThumbnailDrawable() {
        String thumbnailUrl;
        AnimatedOptions animatedOptions = this.animatedOptions;
        if (animatedOptions == null || !animatedOptions.useFallbackThumbnail() || (thumbnailUrl = animatedOptions.getThumbnailUrl()) == null || thumbnailUrl.length() == 0) {
            return;
        }
        try {
            this.thumbnailDrawable = (FrescoDrawableInterface) FrescoVitoProvider.getController().createDrawable("bitmap-animation-thumbnail");
            String thumbnailUrl2 = animatedOptions.getThumbnailUrl();
            if (thumbnailUrl2 != null) {
                loadFrescoThumbnail(thumbnailUrl2);
            }
        } catch (Exception e) {
            FLog.w(TAG, "Failed to initialize thumbnail drawable", e);
            this.thumbnailDrawable = null;
        }
    }

    private final void loadFrescoThumbnail(final String thumbnailUrl) {
        FrescoDrawableInterface frescoDrawableInterface = this.thumbnailDrawable;
        if (frescoDrawableInterface == null) {
            return;
        }
        try {
            ImageOptions imageOptionsBuild = ImageOptions.INSTANCE.defaults().extend().round(this.roundingOptions).build();
            VitoImagePipeline imagePipeline = FrescoVitoProvider.getImagePipeline();
            Resources system = Resources.getSystem();
            Intrinsics.checkNotNullExpressionValue(system, "getSystem(...)");
            FrescoController2.fetch$default(FrescoVitoProvider.getController(), frescoDrawableInterface, VitoImagePipeline.createImageRequest$default(imagePipeline, system, ImageSourceProvider.forUri$default(thumbnailUrl, (Map) null, 2, (Object) null), imageOptionsBuild, false, null, CALLER_CONTEXT, null, null, JfifUtil.MARKER_SOI, null), CALLER_CONTEXT, null, new ImageListener() { // from class: com.facebook.fresco.animation.bitmap.BitmapAnimationBackend$loadFrescoThumbnail$imageListener$1
                @Override // com.facebook.fresco.vito.listener.ImageListener
                public void onFinalImageSet(long id, int imageOrigin, ImageInfo imageInfo, Drawable drawable) {
                }

                @Override // com.facebook.fresco.ui.common.OnDrawControllerListener
                public void onImageDrawn(String id, ImageInfo imageInfo, DimensionsInfo dimensionsInfo) {
                    Intrinsics.checkNotNullParameter(id, "id");
                    Intrinsics.checkNotNullParameter(imageInfo, "imageInfo");
                    Intrinsics.checkNotNullParameter(dimensionsInfo, "dimensionsInfo");
                }

                @Override // com.facebook.fresco.vito.listener.ImageListener
                public void onIntermediateImageFailed(long j, Throwable th) {
                    super.onIntermediateImageFailed(j, th);
                }

                @Override // com.facebook.fresco.vito.listener.ImageListener
                public void onIntermediateImageSet(long j, ImageInfo imageInfo) {
                    super.onIntermediateImageSet(j, imageInfo);
                }

                @Override // com.facebook.fresco.vito.listener.ImageListener
                public void onPlaceholderSet(long j, Drawable drawable) {
                    super.onPlaceholderSet(j, drawable);
                }

                @Override // com.facebook.fresco.vito.listener.ImageListener
                public void onRelease(long j) {
                    super.onRelease(j);
                }

                @Override // com.facebook.fresco.vito.listener.ImageListener
                public void onSubmit(long j, Object obj) {
                    super.onSubmit(j, obj);
                }

                @Override // com.facebook.fresco.vito.listener.ImageListener
                public void onFailure(long id, Drawable error, Throwable throwable) {
                    FLog.w((Class<?>) BitmapAnimationBackend.TAG, "Failed to load thumbnail from URL: " + thumbnailUrl, throwable);
                    this.thumbnailDrawable = null;
                }
            }, null, null, null, null, 288, null);
        } catch (Exception e) {
            FLog.w(TAG, "Failed to load thumbnail through Fresco: " + thumbnailUrl, e);
            FrescoDrawableInterface frescoDrawableInterface2 = this.thumbnailDrawable;
            if (frescoDrawableInterface2 != null) {
                FrescoVitoProvider.getController().releaseImmediately(frescoDrawableInterface2);
            }
            this.thumbnailDrawable = null;
        }
    }

    private final boolean showThumbnail() {
        FrescoDrawableInterface frescoDrawableInterface;
        AnimatedOptions animatedOptions = this.animatedOptions;
        return animatedOptions != null && animatedOptions.useFallbackThumbnail() && (frescoDrawableInterface = this.thumbnailDrawable) != null && frescoDrawableInterface.hasImage() && this.animationCompleted;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean drawThumbnail(Canvas canvas) {
        FrescoDrawableInterface frescoDrawableInterface = this.thumbnailDrawable;
        if (frescoDrawableInterface == 0 || !frescoDrawableInterface.hasImage()) {
            return false;
        }
        try {
            ((Drawable) frescoDrawableInterface).draw(canvas);
            return true;
        } catch (Exception e) {
            FLog.w(TAG, "Failed to draw thumbnail drawable", e);
            return false;
        }
    }

    private final void trackAnimationProgress(int frameNumber) {
        AnimatedOptions animatedOptions = this.animatedOptions;
        if (animatedOptions != null && animatedOptions.useFallbackThumbnail()) {
            int loopCount = getLoopCount();
            int frameCount = getFrameCount();
            if (loopCount == 0) {
                return;
            }
            if (frameNumber < this.lastFrameNumber) {
                this.totalFramesProcessed += frameCount;
            }
            this.lastFrameNumber = frameNumber;
            if (this.totalFramesProcessed / frameCount < loopCount - 1 || frameNumber != frameCount - 1) {
                return;
            }
            this.animationCompleted = true;
        }
    }
}
