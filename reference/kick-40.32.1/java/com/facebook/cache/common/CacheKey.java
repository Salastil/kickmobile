package com.facebook.cache.common;

import android.net.Uri;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public interface CacheKey {
    boolean containsUri(Uri uri);

    boolean equals(@Nullable Object obj);

    String getUriString();

    int hashCode();

    boolean isResourceIdForDebugging();

    String toString();
}
