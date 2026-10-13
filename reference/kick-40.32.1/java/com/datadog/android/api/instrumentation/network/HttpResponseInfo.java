package com.datadog.android.api.instrumentation.network;

import com.google.android.gms.common.internal.ImagesContract;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: HttpResponseInfo.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR$\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\f0\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u00020\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0017\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/datadog/android/api/instrumentation/network/HttpResponseInfo;", "", "contentLength", "", "getContentLength", "()Ljava/lang/Long;", "contentType", "", "getContentType", "()Ljava/lang/String;", "headers", "", "", "getHeaders", "()Ljava/util/Map;", "request", "Lcom/datadog/android/api/instrumentation/network/HttpRequestInfo;", "getRequest", "()Lcom/datadog/android/api/instrumentation/network/HttpRequestInfo;", "statusCode", "", "getStatusCode", "()I", ImagesContract.URL, "getUrl", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface HttpResponseInfo {
    Long getContentLength();

    String getContentType();

    Map<String, List<String>> getHeaders();

    HttpRequestInfo getRequest();

    int getStatusCode();

    String getUrl();
}
