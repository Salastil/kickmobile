package com.facebook.fresco.vito.core;

import android.net.Uri;
import com.facebook.common.callercontext.ContextChain;
import com.facebook.datasource.DataSource;
import com.facebook.fresco.vito.options.DecodedImageOptions;
import com.facebook.fresco.vito.options.EncodedImageOptions;
import com.facebook.fresco.vito.options.ImageOptions;
import com.facebook.imagepipeline.listener.RequestListener;
import io.ktor.http.LinkHeader;
import kotlin.Metadata;

/* JADX INFO: compiled from: FrescoVitoPrefetcher.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J<\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\f\u001a\u00020\rH&JF\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\rH&J4\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00112\b\u0010\u000b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\f\u001a\u00020\rH&J>\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00112\b\u0010\u000b\u001a\u0004\u0018\u00010\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\rH&J4\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00132\b\u0010\u000b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\f\u001a\u00020\rH&J>\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00132\b\u0010\u000b\u001a\u0004\u0018\u00010\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\rH&J4\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\f\u001a\u00020\rH&J>\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\rH&J<\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u000b\u001a\u0004\u0018\u00010\u00012\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\f\u001a\u00020\rH&JF\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u000b\u001a\u0004\u0018\u00010\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u0019À\u0006\u0003"}, d2 = {"Lcom/facebook/fresco/vito/core/FrescoVitoPrefetcher;", "", LinkHeader.Rel.Prefetch, "Lcom/facebook/datasource/DataSource;", "Ljava/lang/Void;", "prefetchTarget", "Lcom/facebook/fresco/vito/core/PrefetchTarget;", "uri", "Landroid/net/Uri;", "imageOptions", "Lcom/facebook/fresco/vito/options/ImageOptions;", "callerContext", "callsite", "", "contextChain", "Lcom/facebook/common/callercontext/ContextChain;", "prefetchToBitmapCache", "Lcom/facebook/fresco/vito/options/DecodedImageOptions;", "prefetchToEncodedCache", "Lcom/facebook/fresco/vito/options/EncodedImageOptions;", "prefetchToDiskCache", "imageRequest", "Lcom/facebook/fresco/vito/core/VitoImageRequest;", "requestListener", "Lcom/facebook/imagepipeline/listener/RequestListener;", "core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface FrescoVitoPrefetcher {
    DataSource<Void> prefetch(PrefetchTarget prefetchTarget, Uri uri, ImageOptions imageOptions, Object callerContext, ContextChain contextChain, String callsite);

    DataSource<Void> prefetch(PrefetchTarget prefetchTarget, Uri uri, ImageOptions imageOptions, Object callerContext, String callsite);

    DataSource<Void> prefetch(PrefetchTarget prefetchTarget, VitoImageRequest imageRequest, Object callerContext, ContextChain contextChain, RequestListener requestListener, String callsite);

    DataSource<Void> prefetch(PrefetchTarget prefetchTarget, VitoImageRequest imageRequest, Object callerContext, RequestListener requestListener, String callsite);

    DataSource<Void> prefetchToBitmapCache(Uri uri, DecodedImageOptions imageOptions, Object callerContext, ContextChain contextChain, String callsite);

    DataSource<Void> prefetchToBitmapCache(Uri uri, DecodedImageOptions imageOptions, Object callerContext, String callsite);

    DataSource<Void> prefetchToDiskCache(Uri uri, ImageOptions imageOptions, Object callerContext, ContextChain contextChain, String callsite);

    DataSource<Void> prefetchToDiskCache(Uri uri, ImageOptions imageOptions, Object callerContext, String callsite);

    DataSource<Void> prefetchToEncodedCache(Uri uri, EncodedImageOptions imageOptions, Object callerContext, ContextChain contextChain, String callsite);

    DataSource<Void> prefetchToEncodedCache(Uri uri, EncodedImageOptions imageOptions, Object callerContext, String callsite);
}
