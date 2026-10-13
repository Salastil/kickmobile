package com.facebook.imagepipeline.transcoder;

import com.facebook.imageformat.ImageFormat;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: ImageTranscodeResult.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/facebook/imagepipeline/transcoder/ImageTranscodeResult;", "", "transcodeStatus", "", "outputFormat", "Lcom/facebook/imageformat/ImageFormat;", "<init>", "(ILcom/facebook/imageformat/ImageFormat;)V", "getTranscodeStatus", "()I", "getOutputFormat", "()Lcom/facebook/imageformat/ImageFormat;", "toString", "", "imagepipeline-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ImageTranscodeResult {
    private final ImageFormat outputFormat;
    private final int transcodeStatus;

    public ImageTranscodeResult(int i, ImageFormat outputFormat) {
        Intrinsics.checkNotNullParameter(outputFormat, "outputFormat");
        this.transcodeStatus = i;
        this.outputFormat = outputFormat;
    }

    public final int getTranscodeStatus() {
        return this.transcodeStatus;
    }

    public final ImageFormat getOutputFormat() {
        return this.outputFormat;
    }

    public String toString() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(null, "Status: %d", Arrays.copyOf(new Object[]{Integer.valueOf(this.transcodeStatus)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }
}
