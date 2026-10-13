package com.swmansion.worklets;

import android.content.Context;
import android.content.res.AssetManager;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.jni.HybridData;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactHost;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.google.android.gms.common.internal.ImagesContract;
import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import io.ktor.sse.ServerSentEventKt;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ScriptBufferWrapper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H\u0082 J\u0019\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0082 R\u0010\u0010\b\u001a\u00020\t8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/swmansion/worklets/ScriptBufferWrapper;", "", "uri", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "<init>", "(Ljava/lang/String;Landroid/content/Context;)V", "mHybridData", "Lcom/facebook/jni/HybridData;", "initHybridFromAssets", "assetManager", "Landroid/content/res/AssetManager;", "assetURL", "initHybridFromFile", "fileName", "sourceURL", "Companion", "react-native-worklets_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ScriptBufferWrapper {
    private static final int CONNECT_TIMEOUT_MS = 5000;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String DEV_BUNDLE_FILE_NAME = "WorkletsDevBundle.js";
    private final HybridData mHybridData;

    private final native HybridData initHybridFromAssets(AssetManager assetManager, String assetURL);

    private final native HybridData initHybridFromFile(String fileName, String sourceURL);

    public ScriptBufferWrapper(String str, Context context) throws IOException {
        HybridData hybridDataInitHybridFromFile;
        Intrinsics.checkNotNullParameter(context, "context");
        if (str == null) {
            throw new IllegalStateException("[Worklets] No script URL provided. Make sure the packager is running or you have embedded a JS bundle in your application bundle.".toString());
        }
        if (StringsKt.startsWith$default(str, "file://", false, 2, (Object) null)) {
            String strSubstring = str.substring(7);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            hybridDataInitHybridFromFile = initHybridFromFile(strSubstring, strSubstring);
        } else if (StringsKt.startsWith$default(str, "assets://", false, 2, (Object) null)) {
            String strSubstring2 = str.substring(9);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
            AssetManager assets = context.getAssets();
            Intrinsics.checkNotNullExpressionValue(assets, "getAssets(...)");
            hybridDataInitHybridFromFile = initHybridFromAssets(assets, strSubstring2);
        } else if (StringsKt.startsWith$default(str, DomExceptionUtils.SEPARATOR, false, 2, (Object) null)) {
            hybridDataInitHybridFromFile = initHybridFromFile(str, str);
        } else {
            Companion companion = INSTANCE;
            File fileReactNativeDownloadedBundleFile = companion.reactNativeDownloadedBundleFile(context);
            if (fileReactNativeDownloadedBundleFile == null) {
                fileReactNativeDownloadedBundleFile = new File(context.getCacheDir(), DEV_BUNDLE_FILE_NAME);
                companion.downloadScriptToFile(str, fileReactNativeDownloadedBundleFile);
            }
            String absolutePath = fileReactNativeDownloadedBundleFile.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
            hybridDataInitHybridFromFile = initHybridFromFile(absolutePath, str);
        }
        this.mHybridData = hybridDataInitHybridFromFile;
    }

    /* JADX INFO: compiled from: ScriptBufferWrapper.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\tH\u0002J \u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/swmansion/worklets/ScriptBufferWrapper$Companion;", "", "<init>", "()V", "DEV_BUNDLE_FILE_NAME", "", "CONNECT_TIMEOUT_MS", "", "reactNativeDownloadedBundleFile", "Ljava/io/File;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "downloadScriptToFile", "", ImagesContract.URL, "outputFile", "serverErrorMessage", "statusCode", "connection", "Ljava/net/HttpURLConnection;", "parseMetroError", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "react-native-worklets_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final File reactNativeDownloadedBundleFile(Context context) {
            ReactHost reactHost;
            DevSupportManager devSupportManager;
            String downloadedJSBundleFile;
            Object applicationContext = context.getApplicationContext();
            ReactApplication reactApplication = applicationContext instanceof ReactApplication ? (ReactApplication) applicationContext : null;
            if (reactApplication != null && (reactHost = reactApplication.getReactHost()) != null && (devSupportManager = reactHost.getDevSupportManager()) != null && (downloadedJSBundleFile = devSupportManager.getDownloadedJSBundleFile()) != null) {
                File file = new File(downloadedJSBundleFile);
                if (file.exists()) {
                    return file;
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void downloadScriptToFile(String url, File outputFile) throws IOException {
            URLConnection uRLConnectionOpenConnection = new URL(url).openConnection();
            Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
            httpURLConnection.setConnectTimeout(5000);
            try {
                try {
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode != 200) {
                        throw new RuntimeException(serverErrorMessage(url, responseCode, httpURLConnection));
                    }
                    try {
                        File file = new File(outputFile.getPath() + ".tmp");
                        InputStream inputStream = httpURLConnection.getInputStream();
                        try {
                            InputStream inputStream2 = inputStream;
                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                            try {
                                Intrinsics.checkNotNull(inputStream2);
                                ByteStreamsKt.copyTo$default(inputStream2, fileOutputStream, 0, 2, null);
                                CloseableKt.closeFinally(fileOutputStream, null);
                                CloseableKt.closeFinally(inputStream, null);
                                if (!file.renameTo(outputFile)) {
                                    throw new IOException("Couldn't rename " + file + " to " + outputFile);
                                }
                                httpURLConnection.disconnect();
                            } catch (Throwable th) {
                                try {
                                    throw th;
                                } catch (Throwable th2) {
                                    CloseableKt.closeFinally(fileOutputStream, th);
                                    throw th2;
                                }
                            }
                        } catch (Throwable th3) {
                            try {
                                throw th3;
                            } catch (Throwable th4) {
                                CloseableKt.closeFinally(inputStream, th3);
                                throw th4;
                            }
                        }
                    } catch (IOException e) {
                        throw new RuntimeException("[Worklets] Failed to store worklets bundle from URL " + url + ": " + e.getMessage(), e);
                    }
                } catch (IOException e2) {
                    throw new RuntimeException("[Worklets] Could not connect to development server.\n", e2);
                }
            } catch (Throwable th5) {
                httpURLConnection.disconnect();
                throw th5;
            }
        }

        private final String serverErrorMessage(String url, int statusCode, HttpURLConnection connection) {
            InputStream errorStream = connection.getErrorStream();
            String str = null;
            if (errorStream != null) {
                InputStream inputStream = errorStream;
                try {
                    byte[] bytes = ByteStreamsKt.readBytes(inputStream);
                    Charset UTF_8 = StandardCharsets.UTF_8;
                    Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                    String str2 = new String(bytes, UTF_8);
                    CloseableKt.closeFinally(inputStream, null);
                    str = str2;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(inputStream, th);
                        throw th2;
                    }
                }
            }
            String metroError = parseMetroError(str);
            if (metroError != null) {
                return "[Worklets] " + metroError;
            }
            return "[Worklets] The development server returned response error code: " + statusCode + "\n\nURL: " + url + "\n\nBody:\n" + str;
        }

        private final String parseMetroError(String body) {
            String str = body;
            if (str != null && str.length() != 0) {
                try {
                    JSONObject jSONObject = new JSONObject(body);
                    String string = jSONObject.getString("filename");
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    String strSubstringAfterLast$default = StringsKt.substringAfterLast$default(string, '/', (String) null, 2, (Object) null);
                    return jSONObject.getString("message") + "\n  at " + strSubstringAfterLast$default + ServerSentEventKt.COLON + jSONObject.getInt("lineNumber") + ServerSentEventKt.COLON + jSONObject.getInt("column");
                } catch (JSONException unused) {
                }
            }
            return null;
        }
    }
}
