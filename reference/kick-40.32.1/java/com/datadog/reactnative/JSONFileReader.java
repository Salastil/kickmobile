package com.datadog.reactnative;

import android.content.Context;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: JSONFileReader.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/datadog/reactnative/JSONFileReader;", "", "<init>", "()V", "parseAssetsJSONFile", "", "appContext", "Landroid/content/Context;", "filePath", "parseAssetsJSONFile$datadog_mobile_react_native_release", "datadog_mobile-react-native_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class JSONFileReader {
    public final String parseAssetsJSONFile$datadog_mobile_react_native_release(Context appContext, String filePath) throws IOException {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        InputStream inputStreamOpen = appContext.getAssets().open(filePath);
        try {
            InputStream inputStream = inputStreamOpen;
            Intrinsics.checkNotNull(inputStream);
            Reader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
            String text = TextStreamsKt.readText(inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192));
            CloseableKt.closeFinally(inputStreamOpen, null);
            return text;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(inputStreamOpen, th);
                throw th2;
            }
        }
    }
}
