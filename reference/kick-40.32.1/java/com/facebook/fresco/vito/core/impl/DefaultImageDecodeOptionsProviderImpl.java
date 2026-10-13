package com.facebook.fresco.vito.core.impl;

import android.os.Build;
import com.facebook.common.logging.FLog;
import com.facebook.fresco.vito.options.AnimatedOptions;
import com.facebook.fresco.vito.options.BitmapConfig;
import com.facebook.fresco.vito.options.DecodedImageOptions;
import com.facebook.fresco.vito.options.RoundingOptions;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DefaultImageDecodeOptionsProviderImpl.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/DefaultImageDecodeOptionsProviderImpl;", "Lcom/facebook/fresco/vito/core/impl/ImagePipelineUtilsImpl$ImageDecodeOptionsProvider;", "circularBitmapRounding", "Lcom/facebook/fresco/vito/core/impl/ImagePipelineUtilsImpl$CircularBitmapRounding;", "<init>", "(Lcom/facebook/fresco/vito/core/impl/ImagePipelineUtilsImpl$CircularBitmapRounding;)V", "create", "Lcom/facebook/imagepipeline/common/ImageDecodeOptions;", "imageRequestBuilder", "Lcom/facebook/imagepipeline/request/ImageRequestBuilder;", "imageOptions", "Lcom/facebook/fresco/vito/options/DecodedImageOptions;", "Companion", "core-java-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DefaultImageDecodeOptionsProviderImpl implements ImagePipelineUtilsImpl.ImageDecodeOptionsProvider {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "DefaultImageOptionsProvider";
    private final ImagePipelineUtilsImpl.CircularBitmapRounding circularBitmapRounding;

    @JvmStatic
    public static final ImageDecodeOptions maybeCreateFromConfigAndCustomDecoder(DecodedImageOptions decodedImageOptions) {
        return INSTANCE.maybeCreateFromConfigAndCustomDecoder(decodedImageOptions);
    }

    @JvmStatic
    public static final ImageDecodeOptions maybeSetupPipelineRounding(RoundingOptions roundingOptions, BitmapConfig bitmapConfig, ImagePipelineUtilsImpl.CircularBitmapRounding circularBitmapRounding) {
        return INSTANCE.maybeSetupPipelineRounding(roundingOptions, bitmapConfig, circularBitmapRounding);
    }

    public DefaultImageDecodeOptionsProviderImpl(ImagePipelineUtilsImpl.CircularBitmapRounding circularBitmapRounding) {
        this.circularBitmapRounding = circularBitmapRounding;
    }

    @Override // com.facebook.fresco.vito.core.impl.ImagePipelineUtilsImpl.ImageDecodeOptionsProvider
    public ImageDecodeOptions create(ImageRequestBuilder imageRequestBuilder, DecodedImageOptions imageOptions) {
        Intrinsics.checkNotNullParameter(imageRequestBuilder, "imageRequestBuilder");
        Intrinsics.checkNotNullParameter(imageOptions, "imageOptions");
        Companion companion = INSTANCE;
        ImageDecodeOptions imageDecodeOptionsMaybeCreateFromConfigAndCustomDecoder = companion.maybeCreateFromConfigAndCustomDecoder(imageOptions);
        return imageDecodeOptionsMaybeCreateFromConfigAndCustomDecoder == null ? companion.maybeSetupPipelineRounding(imageOptions.getRoundingOptions(), imageOptions.getBitmapConfig(), this.circularBitmapRounding) : imageDecodeOptionsMaybeCreateFromConfigAndCustomDecoder;
    }

    /* JADX INFO: compiled from: DefaultImageDecodeOptionsProviderImpl.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J(\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/DefaultImageDecodeOptionsProviderImpl$Companion;", "", "<init>", "()V", "TAG", "", "maybeCreateFromConfigAndCustomDecoder", "Lcom/facebook/imagepipeline/common/ImageDecodeOptions;", "imageOptions", "Lcom/facebook/fresco/vito/options/DecodedImageOptions;", "maybeSetupPipelineRounding", "roundingOptions", "Lcom/facebook/fresco/vito/options/RoundingOptions;", "bitmapConfig", "Lcom/facebook/fresco/vito/options/BitmapConfig;", "circularBitmapRounding", "Lcom/facebook/fresco/vito/core/impl/ImagePipelineUtilsImpl$CircularBitmapRounding;", "pipelineRoundingUnsupportedForBitmapConfig", "", "core-java-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ImageDecodeOptions maybeCreateFromConfigAndCustomDecoder(DecodedImageOptions imageOptions) {
            Intrinsics.checkNotNullParameter(imageOptions, "imageOptions");
            BitmapConfig bitmapConfig = imageOptions.getBitmapConfig();
            ImageDecodeOptions imageDecodeOptions = imageOptions.getImageDecodeOptions();
            AnimatedOptions animatedOptions = imageOptions.getAnimatedOptions();
            boolean z = false;
            if (animatedOptions != null && animatedOptions.isAnimationDisabled()) {
                z = true;
            }
            if (bitmapConfig != null) {
                if (imageOptions.getRoundingOptions() != null || imageOptions.getPostprocessor() != null) {
                    FLog.wtf(DefaultImageDecodeOptionsProviderImpl.TAG, "Trying to use bitmap config incompatible with rounding.");
                } else {
                    ImageDecodeOptionsBuilder bitmapConfig2 = ImageDecodeOptions.newBuilder().setBitmapConfig(bitmapConfig.toAndroidBitmapConfig());
                    ImageDecodeOptions imageDecodeOptions2 = imageOptions.getImageDecodeOptions();
                    return bitmapConfig2.setCustomImageDecoder(imageDecodeOptions2 != null ? imageDecodeOptions2.customImageDecoder : null).setForceStaticImage(z).build();
                }
            } else {
                if ((imageDecodeOptions != null ? imageDecodeOptions.customImageDecoder : null) != null) {
                    return ImageDecodeOptions.newBuilder().setCustomImageDecoder(imageDecodeOptions.customImageDecoder).setForceStaticImage(z).build();
                }
                if (z) {
                    return ImageDecodeOptions.newBuilder().setForceStaticImage(true).build();
                }
            }
            return null;
        }

        @JvmStatic
        public final ImageDecodeOptions maybeSetupPipelineRounding(RoundingOptions roundingOptions, BitmapConfig bitmapConfig, ImagePipelineUtilsImpl.CircularBitmapRounding circularBitmapRounding) {
            if (roundingOptions == null || roundingOptions.isForceRoundAtDecode() || !roundingOptions.isCircular() || circularBitmapRounding == null || pipelineRoundingUnsupportedForBitmapConfig(bitmapConfig)) {
                return null;
            }
            return circularBitmapRounding.getDecodeOptions(roundingOptions.isAntiAliased());
        }

        private final boolean pipelineRoundingUnsupportedForBitmapConfig(BitmapConfig bitmapConfig) {
            return Build.VERSION.SDK_INT >= 26 && bitmapConfig == BitmapConfig.HARDWARE;
        }
    }
}
