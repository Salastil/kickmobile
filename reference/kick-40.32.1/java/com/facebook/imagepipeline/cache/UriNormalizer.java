package com.facebook.imagepipeline.cache;

import android.net.Uri;
import kotlin.Metadata;

/* JADX INFO: compiled from: UriNormalizer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H&¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/facebook/imagepipeline/cache/UriNormalizer;", "", "normalize", "Lcom/facebook/imagepipeline/cache/NormalizedUri;", "uri", "Landroid/net/Uri;", "callerContext", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface UriNormalizer {
    NormalizedUri normalize(Uri uri, Object callerContext);
}
