package com.facebook.imagepipeline.platform;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: PlatformDecoderOptions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u0001:\u0001\u001eBw\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/facebook/imagepipeline/platform/PlatformDecoderOptions;", "", "avoidPoolGet", "", "avoidPoolRelease", "enableDecodeDimensionValidation", "catchNativeDecoderErrors", "errorReporter", "Lcom/facebook/imagepipeline/platform/PlatformDecoderOptions$DecoderErrorReporter;", "useEfficientDecoder", "useBitmapFactoryDecoder", "decodeImmutableBitmaps", "enableDither", "forceSrgbColorSpace", "preferByteArrayDecode", "<init>", "(ZZZZLcom/facebook/imagepipeline/platform/PlatformDecoderOptions$DecoderErrorReporter;ZZZZZZ)V", "getAvoidPoolGet", "()Z", "getAvoidPoolRelease", "getEnableDecodeDimensionValidation", "getCatchNativeDecoderErrors", "getErrorReporter", "()Lcom/facebook/imagepipeline/platform/PlatformDecoderOptions$DecoderErrorReporter;", "getUseEfficientDecoder", "getUseBitmapFactoryDecoder", "getDecodeImmutableBitmaps", "getEnableDither", "getForceSrgbColorSpace", "getPreferByteArrayDecode", "DecoderErrorReporter", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PlatformDecoderOptions {
    private final boolean avoidPoolGet;
    private final boolean avoidPoolRelease;
    private final boolean catchNativeDecoderErrors;
    private final boolean decodeImmutableBitmaps;
    private final boolean enableDecodeDimensionValidation;
    private final boolean enableDither;
    private final DecoderErrorReporter errorReporter;
    private final boolean forceSrgbColorSpace;
    private final boolean preferByteArrayDecode;
    private final boolean useBitmapFactoryDecoder;
    private final boolean useEfficientDecoder;

    /* JADX INFO: compiled from: PlatformDecoderOptions.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/facebook/imagepipeline/platform/PlatformDecoderOptions$DecoderErrorReporter;", "", "reportError", "", "category", "", "message", "cause", "", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface DecoderErrorReporter {
        void reportError(String category, String message, Throwable cause);
    }

    public PlatformDecoderOptions() {
        this(false, false, false, false, null, false, false, false, false, false, false, 2047, null);
    }

    public PlatformDecoderOptions(boolean z, boolean z2, boolean z3, boolean z4, DecoderErrorReporter decoderErrorReporter, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10) {
        this.avoidPoolGet = z;
        this.avoidPoolRelease = z2;
        this.enableDecodeDimensionValidation = z3;
        this.catchNativeDecoderErrors = z4;
        this.errorReporter = decoderErrorReporter;
        this.useEfficientDecoder = z5;
        this.useBitmapFactoryDecoder = z6;
        this.decodeImmutableBitmaps = z7;
        this.enableDither = z8;
        this.forceSrgbColorSpace = z9;
        this.preferByteArrayDecode = z10;
    }

    public /* synthetic */ PlatformDecoderOptions(boolean z, boolean z2, boolean z3, boolean z4, DecoderErrorReporter decoderErrorReporter, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3, (i & 8) != 0 ? false : z4, (i & 16) != 0 ? null : decoderErrorReporter, (i & 32) != 0 ? false : z5, (i & 64) != 0 ? false : z6, (i & 128) != 0 ? false : z7, (i & 256) != 0 ? true : z8, (i & 512) != 0 ? true : z9, (i & 1024) != 0 ? false : z10);
    }

    public final boolean getAvoidPoolGet() {
        return this.avoidPoolGet;
    }

    public final boolean getAvoidPoolRelease() {
        return this.avoidPoolRelease;
    }

    public final boolean getEnableDecodeDimensionValidation() {
        return this.enableDecodeDimensionValidation;
    }

    public final boolean getCatchNativeDecoderErrors() {
        return this.catchNativeDecoderErrors;
    }

    public final DecoderErrorReporter getErrorReporter() {
        return this.errorReporter;
    }

    public final boolean getUseEfficientDecoder() {
        return this.useEfficientDecoder;
    }

    public final boolean getUseBitmapFactoryDecoder() {
        return this.useBitmapFactoryDecoder;
    }

    public final boolean getDecodeImmutableBitmaps() {
        return this.decodeImmutableBitmaps;
    }

    public final boolean getEnableDither() {
        return this.enableDither;
    }

    public final boolean getForceSrgbColorSpace() {
        return this.forceSrgbColorSpace;
    }

    public final boolean getPreferByteArrayDecode() {
        return this.preferByteArrayDecode;
    }
}
