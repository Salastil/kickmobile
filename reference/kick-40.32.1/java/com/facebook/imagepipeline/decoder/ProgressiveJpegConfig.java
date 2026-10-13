package com.facebook.imagepipeline.decoder;

import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.request.ImageRequest;

/* JADX INFO: loaded from: classes6.dex */
public interface ProgressiveJpegConfig {
    public static final long DEFAULT_TIME_BETWEEN_PARTIAL_RESULTS_MS = 100;

    boolean decodeProgressively(ImageRequest imageRequest);

    int getNextScanNumberToDecode(ImageRequest imageRequest, int i);

    QualityInfo getQualityInfo(ImageRequest imageRequest, int i);

    default long getTimeBetweenPartialResultsMs(ImageRequest imageRequest) {
        return 100L;
    }
}
