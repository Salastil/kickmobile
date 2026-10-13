package com.facebook.fresco.urimod;

import android.net.Uri;
import com.facebook.common.callercontext.ContextChain;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.drawable.Viewport;
import com.facebook.fresco.vito.source.UriImageSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NopUriModifier.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¨\u0006\u0015"}, d2 = {"Lcom/facebook/fresco/urimod/NopUriModifier;", "Lcom/facebook/fresco/urimod/UriModifierInterface;", "<init>", "()V", "modifyUri", "Lcom/facebook/fresco/urimod/UriModifierInterface$ModificationResult;", "imageSource", "Lcom/facebook/fresco/vito/source/UriImageSource;", "viewport", "Lcom/facebook/fresco/urimod/Dimensions;", "scaleType", "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;", "callerContext", "", "contextChain", "Lcom/facebook/common/callercontext/ContextChain;", "modifyPrefetchUri", "Landroid/net/Uri;", "uri", "unregisterReverseFallbackUri", "", "urimod_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NopUriModifier implements UriModifierInterface {
    public static final NopUriModifier INSTANCE = new NopUriModifier();

    @Override // com.facebook.fresco.urimod.UriModifierInterface
    public Uri modifyPrefetchUri(Uri uri, Object callerContext) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return uri;
    }

    @Override // com.facebook.fresco.urimod.UriModifierInterface
    public void unregisterReverseFallbackUri(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
    }

    private NopUriModifier() {
    }

    @Override // com.facebook.fresco.urimod.UriModifierInterface
    public Uri calculateBestUri(Uri uri, Viewport viewport) {
        return super.calculateBestUri(uri, viewport);
    }

    @Override // com.facebook.fresco.urimod.UriModifierInterface
    public UriModifierInterface.ModificationResult modifyNetworkUriForNetworkFetcher(Uri uri, Viewport viewport, Object obj, ContextChain contextChain) {
        return super.modifyNetworkUriForNetworkFetcher(uri, viewport, obj, contextChain);
    }

    @Override // com.facebook.fresco.urimod.UriModifierInterface
    public UriModifierInterface.ModificationResult modifyUri(UriImageSource imageSource, Dimensions viewport, ScalingUtils.ScaleType scaleType, Object callerContext, ContextChain contextChain) {
        Intrinsics.checkNotNullParameter(imageSource, "imageSource");
        return new UriModifierInterface.ModificationResult.Disabled("NopUriModifier");
    }
}
