package com.facebook.fresco.vito.core.impl;

import android.net.Uri;
import com.facebook.common.callercontext.ContextChain;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSources;
import com.facebook.fresco.vito.core.FrescoVitoPrefetcher;
import com.facebook.fresco.vito.core.PrefetchTarget;
import com.facebook.fresco.vito.core.VitoImageRequest;
import com.facebook.fresco.vito.options.DecodedImageOptions;
import com.facebook.fresco.vito.options.EncodedImageOptions;
import com.facebook.fresco.vito.options.ImageOptions;
import com.facebook.imagepipeline.listener.RequestListener;
import io.ktor.http.LinkHeader;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoOpFrescoVitoPrefetcher.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J<\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016JF\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J4\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J>\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J4\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00182\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J>\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00182\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J4\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J>\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J<\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016JF\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/facebook/fresco/vito/core/impl/NoOpFrescoVitoPrefetcher;", "Lcom/facebook/fresco/vito/core/FrescoVitoPrefetcher;", "throwException", "", "<init>", "(Z)V", LinkHeader.Rel.Prefetch, "Lcom/facebook/datasource/DataSource;", "Ljava/lang/Void;", "prefetchTarget", "Lcom/facebook/fresco/vito/core/PrefetchTarget;", "uri", "Landroid/net/Uri;", "imageOptions", "Lcom/facebook/fresco/vito/options/ImageOptions;", "callerContext", "", "callsite", "", "contextChain", "Lcom/facebook/common/callercontext/ContextChain;", "prefetchToBitmapCache", "Lcom/facebook/fresco/vito/options/DecodedImageOptions;", "prefetchToEncodedCache", "Lcom/facebook/fresco/vito/options/EncodedImageOptions;", "prefetchToDiskCache", "imageRequest", "Lcom/facebook/fresco/vito/core/VitoImageRequest;", "requestListener", "Lcom/facebook/imagepipeline/listener/RequestListener;", "maybeThrowUnsupportedOperationException", "Companion", "core-java-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NoOpFrescoVitoPrefetcher implements FrescoVitoPrefetcher {
    private static final Companion Companion = new Companion(null);
    private static final String EXCEPTION_MSG = "Image prefetching with Fresco Vito is disabled!";
    private static final DataSource<Void> FAILED_DATASOURCE;
    private final boolean throwException;

    public NoOpFrescoVitoPrefetcher() {
        this(false, 1, null);
    }

    public NoOpFrescoVitoPrefetcher(boolean z) {
        this.throwException = z;
    }

    public /* synthetic */ NoOpFrescoVitoPrefetcher(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoPrefetcher
    public DataSource<Void> prefetch(PrefetchTarget prefetchTarget, Uri uri, ImageOptions imageOptions, Object callerContext, String callsite) {
        Intrinsics.checkNotNullParameter(prefetchTarget, "prefetchTarget");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(callsite, "callsite");
        return maybeThrowUnsupportedOperationException();
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoPrefetcher
    public DataSource<Void> prefetch(PrefetchTarget prefetchTarget, Uri uri, ImageOptions imageOptions, Object callerContext, ContextChain contextChain, String callsite) {
        Intrinsics.checkNotNullParameter(prefetchTarget, "prefetchTarget");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(callsite, "callsite");
        return maybeThrowUnsupportedOperationException();
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoPrefetcher
    public DataSource<Void> prefetchToBitmapCache(Uri uri, DecodedImageOptions imageOptions, Object callerContext, String callsite) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(callsite, "callsite");
        return maybeThrowUnsupportedOperationException();
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoPrefetcher
    public DataSource<Void> prefetchToBitmapCache(Uri uri, DecodedImageOptions imageOptions, Object callerContext, ContextChain contextChain, String callsite) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(callsite, "callsite");
        return maybeThrowUnsupportedOperationException();
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoPrefetcher
    public DataSource<Void> prefetchToEncodedCache(Uri uri, EncodedImageOptions imageOptions, Object callerContext, String callsite) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(callsite, "callsite");
        return maybeThrowUnsupportedOperationException();
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoPrefetcher
    public DataSource<Void> prefetchToEncodedCache(Uri uri, EncodedImageOptions imageOptions, Object callerContext, ContextChain contextChain, String callsite) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(callsite, "callsite");
        return maybeThrowUnsupportedOperationException();
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoPrefetcher
    public DataSource<Void> prefetchToDiskCache(Uri uri, ImageOptions imageOptions, Object callerContext, String callsite) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(callsite, "callsite");
        return maybeThrowUnsupportedOperationException();
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoPrefetcher
    public DataSource<Void> prefetchToDiskCache(Uri uri, ImageOptions imageOptions, Object callerContext, ContextChain contextChain, String callsite) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(callsite, "callsite");
        return maybeThrowUnsupportedOperationException();
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoPrefetcher
    public DataSource<Void> prefetch(PrefetchTarget prefetchTarget, VitoImageRequest imageRequest, Object callerContext, RequestListener requestListener, String callsite) {
        Intrinsics.checkNotNullParameter(prefetchTarget, "prefetchTarget");
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        Intrinsics.checkNotNullParameter(callsite, "callsite");
        return maybeThrowUnsupportedOperationException();
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoPrefetcher
    public DataSource<Void> prefetch(PrefetchTarget prefetchTarget, VitoImageRequest imageRequest, Object callerContext, ContextChain contextChain, RequestListener requestListener, String callsite) {
        Intrinsics.checkNotNullParameter(prefetchTarget, "prefetchTarget");
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        Intrinsics.checkNotNullParameter(callsite, "callsite");
        return maybeThrowUnsupportedOperationException();
    }

    private final DataSource<Void> maybeThrowUnsupportedOperationException() {
        if (this.throwException) {
            throw new UnsupportedOperationException(EXCEPTION_MSG);
        }
        return FAILED_DATASOURCE;
    }

    /* JADX INFO: compiled from: NoOpFrescoVitoPrefetcher.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/NoOpFrescoVitoPrefetcher$Companion;", "", "<init>", "()V", "EXCEPTION_MSG", "", "FAILED_DATASOURCE", "Lcom/facebook/datasource/DataSource;", "Ljava/lang/Void;", "core-java-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        DataSource<Void> dataSourceImmediateFailedDataSource = DataSources.immediateFailedDataSource(new UnsupportedOperationException(EXCEPTION_MSG));
        Intrinsics.checkNotNullExpressionValue(dataSourceImmediateFailedDataSource, "immediateFailedDataSource(...)");
        FAILED_DATASOURCE = dataSourceImmediateFailedDataSource;
    }
}
