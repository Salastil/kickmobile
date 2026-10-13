package com.datadog.android.core.internal.net;

import com.datadog.android.trace.TracingHeaderType;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.Set;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: FirstPartyHostHeaderTypeResolver.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0006\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\bH&¨\u0006\f"}, d2 = {"Lcom/datadog/android/core/internal/net/FirstPartyHostHeaderTypeResolver;", "", "getAllHeaderTypes", "", "Lcom/datadog/android/trace/TracingHeaderType;", "headerTypesForUrl", ImagesContract.URL, "", "Lokhttp3/HttpUrl;", "isEmpty", "", "isFirstPartyUrl", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface FirstPartyHostHeaderTypeResolver {
    Set<TracingHeaderType> getAllHeaderTypes();

    Set<TracingHeaderType> headerTypesForUrl(String url);

    Set<TracingHeaderType> headerTypesForUrl(HttpUrl url);

    boolean isEmpty();

    boolean isFirstPartyUrl(String url);

    boolean isFirstPartyUrl(HttpUrl url);
}
