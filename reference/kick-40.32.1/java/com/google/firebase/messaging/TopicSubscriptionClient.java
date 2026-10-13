package com.google.firebase.messaging;

import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.installations.InstallationTokenResult;
import io.ktor.sse.ServerSentEventKt;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes8.dex */
class TopicSubscriptionClient {
    static final String ERROR_INTERNAL_SERVER_ERROR = "INTERNAL_SERVER_ERROR";
    static final String ERROR_SERVICE_NOT_AVAILABLE = "SERVICE_NOT_AVAILABLE";
    private static final long RPC_TIMEOUT_SEC = 30;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi firebaseInstallationsApi;
    private final FirebaseMessaging firebaseMessaging;

    TopicSubscriptionClient(FirebaseApp firebaseApp, FirebaseMessaging firebaseMessaging, FirebaseInstallationsApi firebaseInstallationsApi) {
        this.firebaseInstallationsApi = firebaseInstallationsApi;
        this.firebaseApp = firebaseApp;
        this.firebaseMessaging = firebaseMessaging;
    }

    void subscribe(String str) throws IOException {
        String token = ((InstallationTokenResult) awaitTask(this.firebaseInstallationsApi.getToken(false))).getToken();
        this.firebaseMessaging.blockingRegister(false);
        performTopicOperation(str, token, (String) awaitTask(this.firebaseInstallationsApi.getId()), "subscribe");
    }

    void unsubscribe(String str) throws IOException {
        String token = ((InstallationTokenResult) awaitTask(this.firebaseInstallationsApi.getToken(false))).getToken();
        this.firebaseMessaging.blockingRegister(false);
        performTopicOperation(str, token, (String) awaitTask(this.firebaseInstallationsApi.getId()), "unsubscribe");
    }

    private void performTopicOperation(String str, String str2, String str3, String str4) throws IOException {
        if (str2 == null || str3 == null) {
            throw new IOException("FIS auth token or FIS ID is empty");
        }
        String projectId = this.firebaseApp.getOptions().getProjectId();
        String apiKey = this.firebaseApp.getOptions().getApiKey();
        if (projectId == null) {
            throw new IOException("Project ID or API Key is missing");
        }
        URL url = new URL("https://fcmregistrations.googleapis.com/v1/projects/" + projectId + "/registrations/" + str3 + "/topicSubscriptions/" + str + ServerSentEventKt.COLON + str4);
        if (isDebugLogEnabled()) {
            Log.d(Constants.TAG, "Topic " + str4 + " for: " + str + " with url: " + url);
        }
        HttpURLConnection httpURLConnectionCreateConnection = createConnection(url);
        httpURLConnectionCreateConnection.setRequestMethod("POST");
        httpURLConnectionCreateConnection.setRequestProperty("x-goog-api-key", apiKey);
        httpURLConnectionCreateConnection.setRequestProperty("x-goog-firebase-installations-auth", str2);
        httpURLConnectionCreateConnection.setDoOutput(false);
        try {
            try {
                int responseCode = httpURLConnectionCreateConnection.getResponseCode();
                httpURLConnectionCreateConnection.disconnect();
                if (responseCode >= 200 && responseCode < 300) {
                    if (isDebugLogEnabled()) {
                        Log.d(Constants.TAG, "Topic " + str4 + " for: " + str + " succeeded.");
                        return;
                    }
                    return;
                }
                if (responseCode != 404 && responseCode != 403) {
                    if (responseCode >= 500) {
                        throw new IOException(ERROR_INTERNAL_SERVER_ERROR);
                    }
                    throw new IOException("Topic " + str4 + " failed with status: " + responseCode);
                }
                if (isDebugLogEnabled()) {
                    Log.d(Constants.TAG, "Topic " + str4 + " failed: " + httpURLConnectionCreateConnection.getResponseMessage());
                }
                throw new IOException("Topic " + str4 + " failed: " + httpURLConnectionCreateConnection.getResponseMessage());
            } catch (IOException e) {
                throw new IOException(ERROR_SERVICE_NOT_AVAILABLE, e);
            }
        } catch (Throwable th) {
            httpURLConnectionCreateConnection.disconnect();
            throw th;
        }
    }

    protected HttpURLConnection createConnection(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }

    private static <T> T awaitTask(Task<T> task) throws IOException {
        try {
            return (T) Tasks.await(task, 30L, TimeUnit.SECONDS);
        } catch (InterruptedException | TimeoutException e) {
            throw new IOException(ERROR_SERVICE_NOT_AVAILABLE, e);
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof IOException) {
                throw ((IOException) cause);
            }
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new IOException(e2);
        }
    }

    static boolean isDebugLogEnabled() {
        return Log.isLoggable(Constants.TAG, 3);
    }
}
