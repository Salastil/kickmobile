package com.facebook.react.modules.network;

import android.os.Bundle;
import android.util.Base64;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArrayBuilder;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.google.firebase.messaging.Constants;
import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import expo.modules.updates.UpdatesConfiguration;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okio.Buffer;

/* JADX INFO: compiled from: NetworkEventUtil.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JF\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J*\u0010\u0011\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0010H\u0007J<\u0010\u0017\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0010H\u0007J*\u0010\u0019\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0010H\u0007J4\u0010\u001a\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001b\u001a\u00020\tH\u0007J2\u0010\u001a\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J6\u0010\u001f\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010\t2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0007J*\u0010#\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007JP\u0010$\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010%\u001a\u00020\u00052\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\r2\u0006\u0010'\u001a\u00020\u0010H\u0007J\u001c\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\r2\u0006\u0010&\u001a\u00020)H\u0007J\u0014\u0010*\u001a\u0004\u0018\u00010\t2\b\u0010+\u001a\u0004\u0018\u00010,H\u0007J\u0010\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00100\u001a\u00020\t2\u0006\u0010.\u001a\u00020,H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/facebook/react/modules/network/NetworkEventUtil;", "", "<init>", "()V", "MAX_BODY_PREVIEW_SIZE", "", "onCreateRequest", "", "devToolsRequestId", "", "requestUrl", "requestMethod", UpdatesConfiguration.UPDATES_CONFIGURATION_REQUEST_HEADERS_KEY, "", "requestBodyForDevTools", "encodedDataLength", "", "onDataSend", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "requestId", "progress", "total", "onIncrementalDataReceived", "data", "onDataReceivedProgress", "onDataReceived", "responseType", "Lcom/facebook/react/bridge/WritableMap;", Constants.MessagePayloadKeys.RAW_DATA, "", "onRequestError", "error", "e", "", "onRequestSuccess", "onResponseReceived", "statusCode", "headers", "contentLength", "okHttpHeadersToMap", "Lokhttp3/Headers;", "getRequestBodyPreview", "requestBody", "Lokhttp3/RequestBody;", "previewMultipartWithBinaryParts", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "Lokhttp3/MultipartBody;", "binaryPartLabel", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NetworkEventUtil {
    public static final NetworkEventUtil INSTANCE = new NetworkEventUtil();
    private static final int MAX_BODY_PREVIEW_SIZE = 524288;

    private NetworkEventUtil() {
    }

    @JvmStatic
    public static final void onCreateRequest(String devToolsRequestId, String requestUrl, String requestMethod, Map<String, String> requestHeaders, String requestBodyForDevTools, long encodedDataLength) {
        Intrinsics.checkNotNullParameter(devToolsRequestId, "devToolsRequestId");
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
        Intrinsics.checkNotNullParameter(requestMethod, "requestMethod");
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        if (requestBodyForDevTools == null) {
            requestBodyForDevTools = "";
        }
        InspectorNetworkReporter.reportRequestStart(devToolsRequestId, requestUrl, requestMethod, requestHeaders, requestBodyForDevTools, encodedDataLength);
        InspectorNetworkReporter.reportConnectionTiming(devToolsRequestId, requestHeaders);
    }

    @JvmStatic
    public static final void onIncrementalDataReceived(ReactApplicationContext reactContext, int requestId, String devToolsRequestId, String data, long progress, long total) {
        Intrinsics.checkNotNullParameter(devToolsRequestId, "devToolsRequestId");
        if (data != null) {
            InspectorNetworkReporter.reportDataReceived(devToolsRequestId, data);
            InspectorNetworkReporter.maybeStoreResponseBodyIncremental(devToolsRequestId, data);
        }
        if (reactContext != null) {
            WritableArray writableArrayCreateArray = Arguments.createArray();
            ReadableArrayBuilder readableArrayBuilder = new ReadableArrayBuilder(writableArrayCreateArray);
            readableArrayBuilder.add(requestId);
            readableArrayBuilder.add(data);
            readableArrayBuilder.add((int) progress);
            readableArrayBuilder.add((int) total);
            Unit unit = Unit.INSTANCE;
            reactContext.emitDeviceEvent("didReceiveNetworkIncrementalData", writableArrayCreateArray);
        }
    }

    @JvmStatic
    public static final void onDataReceived(ReactApplicationContext reactContext, int requestId, String devToolsRequestId, String data, String responseType) {
        Intrinsics.checkNotNullParameter(devToolsRequestId, "devToolsRequestId");
        Intrinsics.checkNotNullParameter(responseType, "responseType");
        InspectorNetworkReporter.maybeStoreResponseBody(devToolsRequestId, data == null ? "" : data, Intrinsics.areEqual(responseType, "base64"));
        if (reactContext != null) {
            WritableArray writableArrayCreateArray = Arguments.createArray();
            ReadableArrayBuilder readableArrayBuilder = new ReadableArrayBuilder(writableArrayCreateArray);
            readableArrayBuilder.add(requestId);
            readableArrayBuilder.add(data);
            Unit unit = Unit.INSTANCE;
            reactContext.emitDeviceEvent("didReceiveNetworkData", writableArrayCreateArray);
        }
    }

    @JvmStatic
    public static final void onDataReceived(ReactApplicationContext reactContext, int requestId, String devToolsRequestId, WritableMap data, byte[] rawData) {
        Intrinsics.checkNotNullParameter(devToolsRequestId, "devToolsRequestId");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(rawData, "rawData");
        String strEncodeToString = Base64.encodeToString(rawData, 2);
        Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(...)");
        InspectorNetworkReporter.maybeStoreResponseBody(devToolsRequestId, strEncodeToString, true);
        if (reactContext != null) {
            WritableArray writableArrayCreateArray = Arguments.createArray();
            writableArrayCreateArray.pushInt(requestId);
            writableArrayCreateArray.pushMap(data);
            Unit unit = Unit.INSTANCE;
            reactContext.emitDeviceEvent("didReceiveNetworkData", writableArrayCreateArray);
        }
    }

    @JvmStatic
    public static final void onRequestError(ReactApplicationContext reactContext, int requestId, String devToolsRequestId, String error, Throwable e) {
        Intrinsics.checkNotNullParameter(devToolsRequestId, "devToolsRequestId");
        InspectorNetworkReporter.reportRequestFailed(devToolsRequestId, false);
        if (reactContext != null) {
            WritableArray writableArrayCreateArray = Arguments.createArray();
            ReadableArrayBuilder readableArrayBuilder = new ReadableArrayBuilder(writableArrayCreateArray);
            readableArrayBuilder.add(requestId);
            readableArrayBuilder.add(error);
            if (Intrinsics.areEqual(e != null ? e.getClass() : null, SocketTimeoutException.class)) {
                readableArrayBuilder.add(true);
            }
            Unit unit = Unit.INSTANCE;
            reactContext.emitDeviceEvent("didCompleteNetworkResponse", writableArrayCreateArray);
        }
    }

    @JvmStatic
    public static final void onRequestSuccess(ReactApplicationContext reactContext, int requestId, String devToolsRequestId, long encodedDataLength) {
        Intrinsics.checkNotNullParameter(devToolsRequestId, "devToolsRequestId");
        InspectorNetworkReporter.reportResponseEnd(devToolsRequestId, encodedDataLength);
        if (reactContext != null) {
            WritableArray writableArrayCreateArray = Arguments.createArray();
            ReadableArrayBuilder readableArrayBuilder = new ReadableArrayBuilder(writableArrayCreateArray);
            readableArrayBuilder.add(requestId);
            readableArrayBuilder.addNull();
            Unit unit = Unit.INSTANCE;
            reactContext.emitDeviceEvent("didCompleteNetworkResponse", writableArrayCreateArray);
        }
    }

    @JvmStatic
    public static final void onResponseReceived(ReactApplicationContext reactContext, int requestId, String devToolsRequestId, String requestUrl, int statusCode, Map<String, String> headers, long contentLength) {
        Intrinsics.checkNotNullParameter(devToolsRequestId, "devToolsRequestId");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Bundle bundle = new Bundle();
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            bundle.putString(entry.getKey(), entry.getValue());
        }
        InspectorNetworkReporter.reportResponseStart(devToolsRequestId, requestUrl == null ? "" : requestUrl, statusCode, headers, contentLength);
        if (reactContext != null) {
            WritableArray writableArrayCreateArray = Arguments.createArray();
            writableArrayCreateArray.pushInt(requestId);
            writableArrayCreateArray.pushInt(statusCode);
            writableArrayCreateArray.pushMap(Arguments.fromBundle(bundle));
            writableArrayCreateArray.pushString(requestUrl);
            Unit unit = Unit.INSTANCE;
            reactContext.emitDeviceEvent("didReceiveNetworkResponse", writableArrayCreateArray);
        }
    }

    @JvmStatic
    public static final Map<String, String> okHttpHeadersToMap(Headers headers) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int iM14397deprecated_size = headers.m14397deprecated_size();
        for (int i = 0; i < iM14397deprecated_size; i++) {
            String strName = headers.name(i);
            if (linkedHashMap.containsKey(strName)) {
                linkedHashMap.put(strName, linkedHashMap.get(strName) + ", " + headers.value(i));
            } else {
                linkedHashMap.put(strName, headers.value(i));
            }
        }
        return linkedHashMap;
    }

    @JvmStatic
    public static final String getRequestBodyPreview(RequestBody requestBody) {
        RequestBody requestBody2;
        if (requestBody == null) {
            return null;
        }
        ProgressRequestBody progressRequestBody = requestBody instanceof ProgressRequestBody ? (ProgressRequestBody) requestBody : null;
        if (progressRequestBody != null && (requestBody2 = progressRequestBody.getRequestBody()) != null) {
            requestBody = requestBody2;
        }
        if (requestBody.isOneShot()) {
            return INSTANCE.binaryPartLabel(requestBody);
        }
        if (requestBody instanceof MultipartBody) {
            MultipartBody multipartBody = (MultipartBody) requestBody;
            List<MultipartBody.Part> listM14428deprecated_parts = multipartBody.m14428deprecated_parts();
            if (!(listM14428deprecated_parts instanceof Collection) || !listM14428deprecated_parts.isEmpty()) {
                Iterator<T> it = listM14428deprecated_parts.iterator();
                while (it.hasNext()) {
                    if (((MultipartBody.Part) it.next()).getBody().isOneShot()) {
                        return INSTANCE.previewMultipartWithBinaryParts(multipartBody);
                    }
                }
            }
        }
        try {
            Buffer buffer = new Buffer();
            requestBody.writeTo(buffer);
            long size = buffer.getSize();
            if (size <= 524288) {
                return buffer.readUtf8();
            }
            return buffer.readUtf8(524288L) + "... (truncated, " + size + " bytes total)";
        } catch (IOException unused) {
            return "[Preview unavailable]";
        }
    }

    private final String previewMultipartWithBinaryParts(MultipartBody body) {
        String strM14427deprecated_boundary = body.m14427deprecated_boundary();
        StringBuilder sb = new StringBuilder();
        Iterator<MultipartBody.Part> it = body.m14428deprecated_parts().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            MultipartBody.Part next = it.next();
            sb.append("--");
            sb.append(strM14427deprecated_boundary);
            sb.append("\r\n");
            Headers headers = next.getHeaders();
            if (headers != null) {
                int iM14397deprecated_size = headers.m14397deprecated_size();
                for (int i = 0; i < iM14397deprecated_size; i++) {
                    sb.append(headers.name(i));
                    sb.append(": ");
                    sb.append(headers.value(i));
                    sb.append("\r\n");
                }
            }
            RequestBody body2 = next.getBody();
            MediaType contentType = body2.getContentType();
            if (contentType != null) {
                sb.append("Content-Type: ");
                sb.append(contentType);
                sb.append("\r\n");
            }
            sb.append("\r\n");
            if (body2.isOneShot()) {
                sb.append(binaryPartLabel(body2));
            } else {
                try {
                    Buffer buffer = new Buffer();
                    body2.writeTo(buffer);
                    sb.append(buffer.readUtf8());
                } catch (IOException unused) {
                    sb.append("[Preview unavailable]");
                }
            }
            sb.append("\r\n");
        }
        sb.append("--");
        sb.append(strM14427deprecated_boundary);
        sb.append("--\r\n");
        if (sb.length() <= 524288) {
            String string = sb.toString();
            Intrinsics.checkNotNull(string);
            return string;
        }
        return sb.substring(0, 524288) + "... (truncated, " + sb.length() + " bytes total)";
    }

    private final String binaryPartLabel(RequestBody body) {
        long jContentLength;
        try {
            jContentLength = body.contentLength();
        } catch (IOException unused) {
            jContentLength = -1;
        }
        if (jContentLength < 0) {
            return "[Binary data]";
        }
        return "[Binary data, " + jContentLength + " bytes]";
    }

    @JvmStatic
    public static final void onDataSend(ReactApplicationContext reactContext, int requestId, long progress, long total) {
        if (reactContext != null) {
            WritableArray writableArrayCreateArray = Arguments.createArray();
            ReadableArrayBuilder readableArrayBuilder = new ReadableArrayBuilder(writableArrayCreateArray);
            readableArrayBuilder.add(requestId);
            readableArrayBuilder.add((int) progress);
            readableArrayBuilder.add((int) total);
            Unit unit = Unit.INSTANCE;
            reactContext.emitDeviceEvent("didSendNetworkData", writableArrayCreateArray);
        }
    }

    @JvmStatic
    public static final void onDataReceivedProgress(ReactApplicationContext reactContext, int requestId, long progress, long total) {
        if (reactContext != null) {
            WritableArray writableArrayCreateArray = Arguments.createArray();
            ReadableArrayBuilder readableArrayBuilder = new ReadableArrayBuilder(writableArrayCreateArray);
            readableArrayBuilder.add(requestId);
            readableArrayBuilder.add((int) progress);
            readableArrayBuilder.add((int) total);
            Unit unit = Unit.INSTANCE;
            reactContext.emitDeviceEvent("didReceiveNetworkDataProgress", writableArrayCreateArray);
        }
    }
}
