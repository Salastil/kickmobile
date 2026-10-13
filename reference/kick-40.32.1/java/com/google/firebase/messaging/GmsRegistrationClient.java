package com.google.firebase.messaging;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.cloudmessaging.CloudMessaging;
import com.google.android.gms.cloudmessaging.CloudMessagingClient;
import com.google.android.gms.cloudmessaging.RegisterRequest;
import com.google.android.gms.cloudmessaging.UnregisterRequest;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.installations.InstallationTokenResult;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes8.dex */
class GmsRegistrationClient {
    private static final String FCM_SDK_VERSION_PREFIX = "fcm-";
    private static final int GMS_VERSION_Y2026W12 = 261200000;
    static final String MANIFEST_METADATA_FIREBASE_MESSAGING_INSTALLATION_ID_ENABLED = "firebase_messaging_installation_id_enabled";
    private final FirebaseApp app;
    private final CloudMessagingClient client;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final GmsRpc gmsRpc;
    private final Metadata metadata;

    GmsRegistrationClient(Context context, FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, GmsRpc gmsRpc, Metadata metadata) {
        this(firebaseApp, firebaseInstallationsApi, gmsRpc, CloudMessaging.getClient(context), metadata);
    }

    GmsRegistrationClient(FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, GmsRpc gmsRpc, CloudMessagingClient cloudMessagingClient, Metadata metadata) {
        this.client = cloudMessagingClient;
        this.app = firebaseApp;
        this.firebaseInstallations = firebaseInstallationsApi;
        this.gmsRpc = gmsRpc;
        this.metadata = metadata;
    }

    private boolean haveV1RegistrationSupport() {
        return this.metadata.getGmsVersionCode() >= GMS_VERSION_Y2026W12;
    }

    public boolean isV1RegistrationEnabled() {
        Context applicationContext = this.app.getApplicationContext();
        try {
            PackageManager packageManager = applicationContext.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(applicationContext.getPackageName(), 128);
            if (applicationInfo.metaData == null || !applicationInfo.metaData.containsKey(MANIFEST_METADATA_FIREBASE_MESSAGING_INSTALLATION_ID_ENABLED)) {
                return false;
            }
            return applicationInfo.metaData.getBoolean(MANIFEST_METADATA_FIREBASE_MESSAGING_INSTALLATION_ID_ENABLED);
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    private static boolean isFidAlreadyUsedException(Exception exc) {
        return (exc == null || TextUtils.isEmpty(exc.getMessage()) || !exc.getMessage().contains("FID_ALREADY_USED:")) ? false : true;
    }

    private Exception getOrCreateException(Task<?> task) {
        if (task.getException() != null) {
            return task.getException();
        }
        return new ExecutionException(new RuntimeException("Unexpected Error"));
    }

    private Task<Pair<String, String>> fetchFidCredentials(final ExecutorService executorService) {
        return this.firebaseInstallations.getToken(false).continueWithTask(executorService, new Continuation() { // from class: com.google.firebase.messaging.GmsRegistrationClient$$ExternalSyntheticLambda2
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return this.f$0.m11682xa539888b(executorService, task);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$fetchFidCredentials$1$com-google-firebase-messaging-GmsRegistrationClient, reason: not valid java name */
    /* synthetic */ Task m11682xa539888b(ExecutorService executorService, Task task) throws Exception {
        if (!task.isSuccessful()) {
            return Tasks.forException(getOrCreateException(task));
        }
        final String token = ((InstallationTokenResult) task.getResult()).getToken();
        return this.firebaseInstallations.getId().continueWithTask(executorService, new Continuation() { // from class: com.google.firebase.messaging.GmsRegistrationClient$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task2) {
                return this.f$0.m11681x17fed70a(token, task2);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$fetchFidCredentials$0$com-google-firebase-messaging-GmsRegistrationClient, reason: not valid java name */
    /* synthetic */ Task m11681x17fed70a(String str, Task task) throws Exception {
        if (!task.isSuccessful()) {
            return Tasks.forException(getOrCreateException(task));
        }
        return Tasks.forResult(new Pair((String) task.getResult(), str));
    }

    public Task<String> register() {
        return registerInternal().continueWithTask(FcmExecutors.newTaskExecutor(), new Continuation() { // from class: com.google.firebase.messaging.GmsRegistrationClient$$ExternalSyntheticLambda3
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return this.f$0.m11683x1e3479b4(task);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$register$2$com-google-firebase-messaging-GmsRegistrationClient, reason: not valid java name */
    /* synthetic */ Task m11683x1e3479b4(Task task) throws Exception {
        if (task.isSuccessful() || !isFidAlreadyUsedException(task.getException())) {
            return task;
        }
        Log.w(Constants.TAG, "FID_ALREADY_USED Detected. Retrying with FID cache clearing!");
        this.firebaseInstallations.clearFidCache();
        return registerInternal();
    }

    private Task<String> registerInternal() {
        boolean zIsV1RegistrationEnabled = isV1RegistrationEnabled();
        if (!zIsV1RegistrationEnabled || !haveV1RegistrationSupport()) {
            return this.gmsRpc.getToken(zIsV1RegistrationEnabled);
        }
        final ExecutorService executorServiceNewNetworkIOExecutor = FcmExecutors.newNetworkIOExecutor();
        return fetchFidCredentials(executorServiceNewNetworkIOExecutor).continueWithTask(executorServiceNewNetworkIOExecutor, new Continuation() { // from class: com.google.firebase.messaging.GmsRegistrationClient$$ExternalSyntheticLambda5
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return this.f$0.m11684x4af13fd3(executorServiceNewNetworkIOExecutor, task);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$registerInternal$4$com-google-firebase-messaging-GmsRegistrationClient, reason: not valid java name */
    /* synthetic */ Task m11684x4af13fd3(ExecutorService executorService, Task task) throws Exception {
        if (!task.isSuccessful()) {
            return Tasks.forException(getOrCreateException(task));
        }
        final String str = (String) ((Pair) task.getResult()).first;
        return registerOverV1(str, (String) ((Pair) task.getResult()).second).continueWith(executorService, new Continuation() { // from class: com.google.firebase.messaging.GmsRegistrationClient$$ExternalSyntheticLambda4
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task2) {
                return GmsRegistrationClient.lambda$registerInternal$3(str, task2);
            }
        });
    }

    static /* synthetic */ String lambda$registerInternal$3(String str, Task task) throws Exception {
        if (!task.isSuccessful()) {
            throw new ExecutionException(task.getException());
        }
        String str2 = (String) task.getResult();
        if (TextUtils.isEmpty(str2) || !str2.endsWith(str)) {
            throw new ExecutionException(new IllegalArgumentException("Unexpected Error: FID NOT matching!"));
        }
        return str;
    }

    private Task<String> registerOverV1(String str, String str2) {
        String apiKey = this.app.getOptions().getApiKey();
        return this.client.register(new RegisterRequest(Metadata.getDefaultSenderId(this.app), this.app.getOptions().getApplicationId(), apiKey, str, str2, "fcm-25.1.2"));
    }

    public Task<?> unregister() {
        boolean zIsV1RegistrationEnabled = isV1RegistrationEnabled();
        if (!zIsV1RegistrationEnabled || !haveV1RegistrationSupport()) {
            return this.gmsRpc.deleteToken(zIsV1RegistrationEnabled);
        }
        return unregisterOverV1();
    }

    private Task<Void> unregisterOverV1() {
        ExecutorService executorServiceNewNetworkIOExecutor = FcmExecutors.newNetworkIOExecutor();
        return fetchFidCredentials(executorServiceNewNetworkIOExecutor).continueWithTask(executorServiceNewNetworkIOExecutor, new Continuation() { // from class: com.google.firebase.messaging.GmsRegistrationClient$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return this.f$0.m11685x96a5f(task);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$unregisterOverV1$5$com-google-firebase-messaging-GmsRegistrationClient, reason: not valid java name */
    /* synthetic */ Task m11685x96a5f(Task task) throws Exception {
        if (!task.isSuccessful()) {
            return Tasks.forException(getOrCreateException(task));
        }
        String str = (String) ((Pair) task.getResult()).first;
        String str2 = (String) ((Pair) task.getResult()).second;
        return this.client.unregister(new UnregisterRequest(Metadata.getDefaultSenderId(this.app), this.app.getOptions().getApiKey(), str, str2));
    }
}
