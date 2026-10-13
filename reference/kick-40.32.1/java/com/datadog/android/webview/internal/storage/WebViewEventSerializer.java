package com.datadog.android.webview.internal.storage;

import com.datadog.android.core.persistence.Serializer;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WebViewEventSerializer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/webview/internal/storage/WebViewEventSerializer;", "Lcom/datadog/android/core/persistence/Serializer;", "Lcom/google/gson/JsonObject;", "()V", "serialize", "", "model", "dd-sdk-android-webview_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WebViewEventSerializer implements Serializer<JsonObject> {
    @Override // com.datadog.android.core.persistence.Serializer
    public String serialize(JsonObject model) {
        Intrinsics.checkNotNullParameter(model, "model");
        String string = model.toString();
        Intrinsics.checkNotNullExpressionValue(string, "model.toString()");
        return string;
    }
}
