package com.facebook.imagepipeline.animated.factory;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.vito.core.AnimatedImagePerfLoggingListener;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendImpl;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider;
import com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor;
import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.image.CloseableAnimatedImage;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnimatedImageDecoderBase.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\b&\u0018\u0000 ,2\u00020\u0001:\u0001,B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0014J*\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0004J&\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010%\u001a\u00020&H\u0004J&\u0010'\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020$\u0018\u00010#0(2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0004J&\u0010)\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020&2\u0006\u0010 \u001a\u00020!H\u0005R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0006\u001a\u00020\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\rR\u0014\u0010\u0007\u001a\u00020\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u0010X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/facebook/imagepipeline/animated/factory/AnimatedImageDecoderBase;", "", "platformBitmapFactory", "Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;", "downscaleFrameToDrawableDimensions", "", "isNewRenderImplementation", "treatAnimatedImagesAsStateful", "<init>", "(Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;ZZZ)V", "getPlatformBitmapFactory", "()Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;", "getDownscaleFrameToDrawableDimensions", "()Z", "getTreatAnimatedImagesAsStateful", "animatedDrawableBackendProvider", "Lcom/facebook/imagepipeline/animated/impl/AnimatedDrawableBackendProvider;", "getAnimatedDrawableBackendProvider", "()Lcom/facebook/imagepipeline/animated/impl/AnimatedDrawableBackendProvider;", "animatedImagePerfLoggingListener", "Lcom/facebook/fresco/vito/core/AnimatedImagePerfLoggingListener;", "setAnimatedImagePerfLoggingListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "getCloseableImage", "Lcom/facebook/imagepipeline/image/CloseableImage;", "sourceUri", "", "options", "Lcom/facebook/imagepipeline/common/ImageDecodeOptions;", "image", "Lcom/facebook/imagepipeline/animated/base/AnimatedImage;", "bitmapConfig", "Landroid/graphics/Bitmap$Config;", "createPreviewBitmap", "Lcom/facebook/common/references/CloseableReference;", "Landroid/graphics/Bitmap;", "frameForPreview", "", "decodeAllFrames", "", "createBitmap", ViewProps.WIDTH, ViewProps.HEIGHT, "Companion", "animated-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class AnimatedImageDecoderBase {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AnimatedDrawableBackendProvider animatedDrawableBackendProvider;
    private AnimatedImagePerfLoggingListener animatedImagePerfLoggingListener;
    private final boolean downscaleFrameToDrawableDimensions;
    private final boolean isNewRenderImplementation;
    private final PlatformBitmapFactory platformBitmapFactory;
    private final boolean treatAnimatedImagesAsStateful;

    public AnimatedImageDecoderBase(PlatformBitmapFactory platformBitmapFactory, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(platformBitmapFactory, "platformBitmapFactory");
        this.platformBitmapFactory = platformBitmapFactory;
        this.downscaleFrameToDrawableDimensions = z;
        this.isNewRenderImplementation = z2;
        this.treatAnimatedImagesAsStateful = z3;
        this.animatedDrawableBackendProvider = INSTANCE.createAnimatedDrawableBackendProvider(z);
    }

    public /* synthetic */ AnimatedImageDecoderBase(PlatformBitmapFactory platformBitmapFactory, boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(platformBitmapFactory, z, z2, (i & 8) != 0 ? true : z3);
    }

    protected final PlatformBitmapFactory getPlatformBitmapFactory() {
        return this.platformBitmapFactory;
    }

    protected final boolean getDownscaleFrameToDrawableDimensions() {
        return this.downscaleFrameToDrawableDimensions;
    }

    /* JADX INFO: renamed from: isNewRenderImplementation, reason: from getter */
    protected final boolean getIsNewRenderImplementation() {
        return this.isNewRenderImplementation;
    }

    protected final boolean getTreatAnimatedImagesAsStateful() {
        return this.treatAnimatedImagesAsStateful;
    }

    protected final AnimatedDrawableBackendProvider getAnimatedDrawableBackendProvider() {
        return this.animatedDrawableBackendProvider;
    }

    public final void setAnimatedImagePerfLoggingListener(AnimatedImagePerfLoggingListener listener) {
        this.animatedImagePerfLoggingListener = listener;
    }

    /* JADX INFO: compiled from: AnimatedImageDecoderBase.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/facebook/imagepipeline/animated/factory/AnimatedImageDecoderBase$Companion;", "", "<init>", "()V", "createAnimatedDrawableBackendProvider", "Lcom/facebook/imagepipeline/animated/impl/AnimatedDrawableBackendProvider;", "downscaleFrameToDrawableDimensions", "", "animated-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AnimatedDrawableBackendProvider createAnimatedDrawableBackendProvider(final boolean downscaleFrameToDrawableDimensions) {
            return new AnimatedDrawableBackendProvider() { // from class: com.facebook.imagepipeline.animated.factory.AnimatedImageDecoderBase$Companion$createAnimatedDrawableBackendProvider$1
                @Override // com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider
                public AnimatedDrawableBackend get(AnimatedImageResult animatedImageResult, Rect bounds) {
                    Intrinsics.checkNotNullParameter(animatedImageResult, "animatedImageResult");
                    return new AnimatedDrawableBackendImpl(new AnimatedDrawableUtil(), animatedImageResult, bounds, downscaleFrameToDrawableDimensions);
                }
            };
        }
    }

    protected final CloseableImage getCloseableImage(String sourceUri, ImageDecodeOptions options, AnimatedImage image, Bitmap.Config bitmapConfig) throws Throwable {
        List<CloseableReference<Bitmap>> listDecodeAllFrames;
        String str;
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(bitmapConfig, "bitmapConfig");
        CloseableReference<Bitmap> closeableReferenceCreatePreviewBitmap = null;
        try {
            int frameCount = options.useLastFrameForPreview ? image.getFrameCount() - 1 : 0;
            if (options.forceStaticImage) {
                CloseableStaticBitmap closeableStaticBitmapOf = CloseableStaticBitmap.of(createPreviewBitmap(image, bitmapConfig, frameCount), ImmutableQualityInfo.FULL_QUALITY, 0);
                Intrinsics.checkNotNullExpressionValue(closeableStaticBitmapOf, "of(...)");
                CloseableStaticBitmap closeableStaticBitmap = closeableStaticBitmapOf;
                CloseableReference.closeSafely((CloseableReference<?>) null);
                CloseableReference.closeSafely((Iterable<? extends CloseableReference<?>>) null);
                return closeableStaticBitmap;
            }
            if (options.decodeAllFrames) {
                listDecodeAllFrames = decodeAllFrames(image, bitmapConfig);
                try {
                    closeableReferenceCreatePreviewBitmap = CloseableReference.cloneOrNull(listDecodeAllFrames.get(frameCount));
                } catch (Throwable th) {
                    th = th;
                    CloseableReference.closeSafely(closeableReferenceCreatePreviewBitmap);
                    CloseableReference.closeSafely(listDecodeAllFrames);
                    throw th;
                }
            } else {
                listDecodeAllFrames = null;
            }
            if (options.decodePreviewFrame && closeableReferenceCreatePreviewBitmap == null) {
                closeableReferenceCreatePreviewBitmap = createPreviewBitmap(image, bitmapConfig, frameCount);
            }
            if (sourceUri == null) {
                str = "unknown_" + System.identityHashCode(image);
            } else {
                str = sourceUri;
            }
            long jNanoTime = System.nanoTime();
            AnimatedImagePerfLoggingListener animatedImagePerfLoggingListener = this.animatedImagePerfLoggingListener;
            if (animatedImagePerfLoggingListener != null) {
                animatedImagePerfLoggingListener.onCloseableAnimatedImageCreationStart(str, jNanoTime);
            }
            AnimatedImageResult animatedImageResultBuild = AnimatedImageResult.newBuilder(image).setPreviewBitmap(closeableReferenceCreatePreviewBitmap).setFrameForPreview(frameCount).setDecodedFrames(listDecodeAllFrames).setBitmapTransformation(options.bitmapTransformation).setSource(sourceUri).build();
            Intrinsics.checkNotNullExpressionValue(animatedImageResultBuild, "build(...)");
            CloseableAnimatedImage closeableAnimatedImage = new CloseableAnimatedImage(animatedImageResultBuild, this.treatAnimatedImagesAsStateful);
            long jNanoTime2 = System.nanoTime();
            AnimatedImagePerfLoggingListener animatedImagePerfLoggingListener2 = this.animatedImagePerfLoggingListener;
            if (animatedImagePerfLoggingListener2 != null) {
                animatedImagePerfLoggingListener2.onCloseableAnimatedImageCreationEnd(str, jNanoTime2, true);
            }
            CloseableAnimatedImage closeableAnimatedImage2 = closeableAnimatedImage;
            CloseableReference.closeSafely(closeableReferenceCreatePreviewBitmap);
            CloseableReference.closeSafely(listDecodeAllFrames);
            return closeableAnimatedImage2;
        } catch (Throwable th2) {
            th = th2;
            listDecodeAllFrames = null;
        }
    }

    protected final CloseableReference<Bitmap> createPreviewBitmap(AnimatedImage image, Bitmap.Config bitmapConfig, int frameForPreview) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(bitmapConfig, "bitmapConfig");
        CloseableReference<Bitmap> closeableReferenceCreateBitmap = createBitmap(image.getWidth(), image.getHeight(), bitmapConfig);
        AnimatedImageResult animatedImageResultForAnimatedImage = AnimatedImageResult.forAnimatedImage(image);
        Intrinsics.checkNotNullExpressionValue(animatedImageResultForAnimatedImage, "forAnimatedImage(...)");
        AnimatedDrawableBackend animatedDrawableBackend = this.animatedDrawableBackendProvider.get(animatedImageResultForAnimatedImage, null);
        Intrinsics.checkNotNullExpressionValue(animatedDrawableBackend, "get(...)");
        new AnimatedImageCompositor(animatedDrawableBackend, this.isNewRenderImplementation, new AnimatedImageCompositor.Callback() { // from class: com.facebook.imagepipeline.animated.factory.AnimatedImageDecoderBase$createPreviewBitmap$animatedImageCompositor$1
            @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.Callback
            public CloseableReference<Bitmap> getCachedBitmap(int frameNumber) {
                return null;
            }

            @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.Callback
            public void onIntermediateResult(int frameNumber, Bitmap bitmap) {
                Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            }
        }).renderFrame(frameForPreview, closeableReferenceCreateBitmap.get());
        return closeableReferenceCreateBitmap;
    }

    protected final List<CloseableReference<Bitmap>> decodeAllFrames(AnimatedImage image, Bitmap.Config bitmapConfig) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(bitmapConfig, "bitmapConfig");
        AnimatedImageResult animatedImageResultForAnimatedImage = AnimatedImageResult.forAnimatedImage(image);
        Intrinsics.checkNotNullExpressionValue(animatedImageResultForAnimatedImage, "forAnimatedImage(...)");
        AnimatedDrawableBackend animatedDrawableBackend = this.animatedDrawableBackendProvider.get(animatedImageResultForAnimatedImage, null);
        Intrinsics.checkNotNullExpressionValue(animatedDrawableBackend, "get(...)");
        final ArrayList arrayList = new ArrayList(animatedDrawableBackend.getFrameCount());
        AnimatedImageCompositor animatedImageCompositor = new AnimatedImageCompositor(animatedDrawableBackend, this.isNewRenderImplementation, new AnimatedImageCompositor.Callback() { // from class: com.facebook.imagepipeline.animated.factory.AnimatedImageDecoderBase$decodeAllFrames$animatedImageCompositor$1
            @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.Callback
            public void onIntermediateResult(int frameNumber, Bitmap bitmap) {
                Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            }

            @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.Callback
            public CloseableReference<Bitmap> getCachedBitmap(int frameNumber) {
                return CloseableReference.cloneOrNull(arrayList.get(frameNumber));
            }
        });
        int frameCount = animatedDrawableBackend.getFrameCount();
        for (int i = 0; i < frameCount; i++) {
            CloseableReference<Bitmap> closeableReferenceCreateBitmap = createBitmap(animatedDrawableBackend.getWidth(), animatedDrawableBackend.getHeight(), bitmapConfig);
            animatedImageCompositor.renderFrame(i, closeableReferenceCreateBitmap.get());
            arrayList.add(closeableReferenceCreateBitmap);
        }
        return arrayList;
    }

    protected final CloseableReference<Bitmap> createBitmap(int width, int height, Bitmap.Config bitmapConfig) {
        Intrinsics.checkNotNullParameter(bitmapConfig, "bitmapConfig");
        CloseableReference<Bitmap> closeableReferenceCreateBitmapInternal = this.platformBitmapFactory.createBitmapInternal(width, height, bitmapConfig);
        Intrinsics.checkNotNullExpressionValue(closeableReferenceCreateBitmapInternal, "createBitmapInternal(...)");
        closeableReferenceCreateBitmapInternal.get().eraseColor(0);
        closeableReferenceCreateBitmapInternal.get().setHasAlpha(true);
        return closeableReferenceCreateBitmapInternal;
    }
}
