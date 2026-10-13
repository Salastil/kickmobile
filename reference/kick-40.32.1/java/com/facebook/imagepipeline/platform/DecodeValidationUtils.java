package com.facebook.imagepipeline.platform;

import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.image.EncodedImage;
import com.mux.stats.sdk.core.model.ViewDeviceOrientationData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DecodeValidationUtils.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ \u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007J\u001e\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/facebook/imagepipeline/platform/DecodeValidationUtils;", "", "<init>", "()V", "TAG", "", "MAX_DECODE_DIMENSION", "", "validateDimensions", "", "encodedImage", "Lcom/facebook/imagepipeline/image/EncodedImage;", "platformDecoderOptions", "Lcom/facebook/imagepipeline/platform/PlatformDecoderOptions;", "validateInput", "data", "", "offset", "length", "isValidImageHeader", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DecodeValidationUtils {
    public static final DecodeValidationUtils INSTANCE = new DecodeValidationUtils();
    public static final int MAX_DECODE_DIMENSION = 32768;
    private static final String TAG = "DecodeValidationUtils";

    private DecodeValidationUtils() {
    }

    public final boolean validateDimensions(EncodedImage encodedImage, PlatformDecoderOptions platformDecoderOptions) {
        int width;
        int height;
        Intrinsics.checkNotNullParameter(encodedImage, "encodedImage");
        Intrinsics.checkNotNullParameter(platformDecoderOptions, "platformDecoderOptions");
        if (!platformDecoderOptions.getEnableDecodeDimensionValidation()) {
            return true;
        }
        synchronized (encodedImage) {
            width = encodedImage.getWidth();
            height = encodedImage.getHeight();
            Unit unit = Unit.INSTANCE;
        }
        if (width != -1 && height != -1) {
            if (width > 0 && height > 0 && width <= 32768 && height <= 32768) {
                return true;
            }
            String str = "Rejecting decode with invalid dimensions: " + width + ViewDeviceOrientationData.DEVICE_ORIENTATION_X + height;
            FLog.e(TAG, str);
            PlatformDecoderOptions.DecoderErrorReporter errorReporter = platformDecoderOptions.getErrorReporter();
            if (errorReporter != null) {
                errorReporter.reportError("DECODE_DIMENSION_VALIDATION_ERROR", str, null);
            }
        }
        return false;
    }

    public final boolean validateInput(byte[] data, int offset, int length) {
        return data != null && length > 0 && data.length >= offset + length;
    }

    public final boolean isValidImageHeader(byte[] data, int offset, int length) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (length < 2) {
            return true;
        }
        int i = data[offset] & 255;
        int i2 = data[offset + 1] & 255;
        if (i == 255 && i2 == 216) {
            return true;
        }
        if (i == 137 && i2 == 80) {
            return true;
        }
        if (i == 82 && i2 == 73) {
            return true;
        }
        return i == 71 && i2 == 73;
    }
}
