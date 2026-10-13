package io.invertase.firebase.messaging;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import androidx.core.app.NotificationManagerCompat;
import com.facebook.fbreact.specs.NativeRNFBTurboMessagingSpec;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.messaging.Constants;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RemoteMessage;
import io.invertase.firebase.common.ReactNativeFirebaseEventEmitter;
import io.invertase.firebase.common.ReactNativeFirebaseModule;
import io.invertase.firebase.common.TaskExecutorService;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes9.dex */
public class NativeRNFBTurboMessaging extends NativeRNFBTurboMessagingSpec implements ActivityEventListener {
    private static final String TAG = "Messaging";
    private final TaskExecutorService executorService;
    ReadableMap initialNotification;
    private final HashMap<String, Boolean> initialNotificationMap;

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboMessagingSpec
    public void completeNotificationProcessing() {
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboMessagingSpec
    public void signalBackgroundMessageHandlerSet() {
    }

    public NativeRNFBTurboMessaging(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.initialNotification = null;
        this.initialNotificationMap = new HashMap<>();
        this.executorService = new TaskExecutorService(NativeRNFBTurboMessagingSpec.NAME);
        reactApplicationContext.addActivityEventListener(this);
    }

    private ExecutorService getExecutor() {
        return this.executorService.getExecutor();
    }

    private WritableMap popRemoteMessageMapFromMessagingStore(String str) {
        ReactNativeFirebaseMessagingStore messagingStore = ReactNativeFirebaseMessagingStoreHelper.getInstance().getMessagingStore();
        WritableMap firebaseMessageMap = messagingStore.getFirebaseMessageMap(str);
        messagingStore.clearFirebaseMessage(str);
        return firebaseMessageMap;
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboMessagingSpec
    protected Map<String, Object> getTypedExportedConstants() {
        HashMap map = new HashMap();
        map.put("isAutoInitEnabled", Boolean.valueOf(FirebaseMessaging.getInstance().isAutoInitEnabled()));
        map.put("isDeliveryMetricsExportToBigQueryEnabled", Boolean.valueOf(FirebaseMessaging.getInstance().deliveryMetricsExportToBigQueryEnabled()));
        map.put("isNotificationDelegationEnabled", Boolean.valueOf(FirebaseMessaging.getInstance().isNotificationDelegationEnabled()));
        return map;
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboMessagingSpec
    public void getDidOpenSettingsForNotification(Promise promise) {
        promise.resolve(false);
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboMessagingSpec
    public void getAPNSToken(Promise promise) {
        promise.resolve(null);
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboMessagingSpec
    public void setAPNSToken(String str, @Nullable String str2, Promise promise) {
        promise.resolve(null);
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboMessagingSpec
    public void getIsHeadless(Promise promise) {
        promise.resolve(false);
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboMessagingSpec
    public void requestPermission(ReadableMap readableMap, Promise promise) {
        promise.resolve(1);
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboMessagingSpec
    public void registerForRemoteNotifications(Promise promise) {
        promise.resolve(null);
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboMessagingSpec
    public void unregisterForRemoteNotifications(Promise promise) {
        promise.resolve(null);
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboMessagingSpec
    public void getInitialNotification(Promise promise) {
        WritableMap writableMapRemoteMessageToWritableMap;
        ReadableMap readableMap = this.initialNotification;
        if (readableMap != null) {
            promise.resolve(readableMap);
            this.initialNotification = null;
            return;
        }
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            Intent intent = currentActivity.getIntent();
            if (intent != null && intent.getExtras() != null) {
                String string = intent.getExtras().getString("google.message_id");
                if (string == null) {
                    string = intent.getExtras().getString(Constants.MessagePayloadKeys.MSGID_SERVER);
                }
                if (string != null && this.initialNotificationMap.get(string) == null) {
                    RemoteMessage remoteMessage = ReactNativeFirebaseMessagingReceiver.notifications.get(string);
                    if (remoteMessage == null) {
                        writableMapRemoteMessageToWritableMap = popRemoteMessageMapFromMessagingStore(string);
                    } else {
                        writableMapRemoteMessageToWritableMap = ReactNativeFirebaseMessagingSerializer.remoteMessageToWritableMap(remoteMessage);
                    }
                    if (writableMapRemoteMessageToWritableMap != null) {
                        promise.resolve(writableMapRemoteMessageToWritableMap);
                        this.initialNotificationMap.put(string, true);
                        return;
                    }
                }
            }
        } else {
            Log.w(TAG, "Attempt to call getInitialNotification failed. The current activity is not ready, try calling the method later in the React lifecycle.");
        }
        promise.resolve(null);
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboMessagingSpec
    public void setAutoInitEnabled(final boolean z, final Promise promise) {
        Tasks.call(getExecutor(), new Callable() { // from class: io.invertase.firebase.messaging.NativeRNFBTurboMessaging$$ExternalSyntheticLambda5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return NativeRNFBTurboMessaging.lambda$setAutoInitEnabled$0(z);
            }
        }).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.messaging.NativeRNFBTurboMessaging$$ExternalSyntheticLambda6
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                NativeRNFBTurboMessaging.lambda$setAutoInitEnabled$1(promise, task);
            }
        });
    }

    static /* synthetic */ Object lambda$setAutoInitEnabled$0(boolean z) throws Exception {
        FirebaseMessaging.getInstance().setAutoInitEnabled(z);
        return null;
    }

    static /* synthetic */ void lambda$setAutoInitEnabled$1(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(Boolean.valueOf(FirebaseMessaging.getInstance().isAutoInitEnabled()));
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboMessagingSpec
    public void isNotificationDelegationEnabled(final Promise promise) {
        Tasks.call(getExecutor(), new Callable() { // from class: io.invertase.firebase.messaging.NativeRNFBTurboMessaging$$ExternalSyntheticLambda11
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Boolean.valueOf(FirebaseMessaging.getInstance().isNotificationDelegationEnabled());
            }
        }).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.messaging.NativeRNFBTurboMessaging$$ExternalSyntheticLambda12
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                NativeRNFBTurboMessaging.lambda$isNotificationDelegationEnabled$3(promise, task);
            }
        });
    }

    static /* synthetic */ void lambda$isNotificationDelegationEnabled$3(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboMessagingSpec
    public void setNotificationDelegationEnabled(final boolean z, final Promise promise) {
        Tasks.call(getExecutor(), new Callable() { // from class: io.invertase.firebase.messaging.NativeRNFBTurboMessaging$$ExternalSyntheticLambda13
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return NativeRNFBTurboMessaging.lambda$setNotificationDelegationEnabled$4(z);
            }
        }).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.messaging.NativeRNFBTurboMessaging$$ExternalSyntheticLambda14
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                NativeRNFBTurboMessaging.lambda$setNotificationDelegationEnabled$5(promise, task);
            }
        });
    }

    static /* synthetic */ Object lambda$setNotificationDelegationEnabled$4(boolean z) throws Exception {
        FirebaseMessaging.getInstance().setNotificationDelegationEnabled(z);
        return null;
    }

    static /* synthetic */ void lambda$setNotificationDelegationEnabled$5(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(Boolean.valueOf(FirebaseMessaging.getInstance().isNotificationDelegationEnabled()));
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboMessagingSpec
    public void getToken(String str, String str2, final Promise promise) {
        final FirebaseMessaging firebaseMessaging = (FirebaseMessaging) FirebaseApp.getInstance(str).get(FirebaseMessaging.class);
        Tasks.call(getExecutor(), new Callable() { // from class: io.invertase.firebase.messaging.NativeRNFBTurboMessaging$$ExternalSyntheticLambda7
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return NativeRNFBTurboMessaging.lambda$getToken$6(firebaseMessaging);
            }
        }).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.messaging.NativeRNFBTurboMessaging$$ExternalSyntheticLambda8
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                NativeRNFBTurboMessaging.lambda$getToken$7(promise, task);
            }
        });
    }

    static /* synthetic */ String lambda$getToken$6(FirebaseMessaging firebaseMessaging) throws Exception {
        return (String) Tasks.await(firebaseMessaging.getToken());
    }

    static /* synthetic */ void lambda$getToken$7(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboMessagingSpec
    public void deleteToken(String str, String str2, final Promise promise) {
        final FirebaseMessaging firebaseMessaging = (FirebaseMessaging) FirebaseApp.getInstance(str).get(FirebaseMessaging.class);
        Tasks.call(getExecutor(), new Callable() { // from class: io.invertase.firebase.messaging.NativeRNFBTurboMessaging$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return NativeRNFBTurboMessaging.lambda$deleteToken$8(firebaseMessaging);
            }
        }).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.messaging.NativeRNFBTurboMessaging$$ExternalSyntheticLambda2
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                NativeRNFBTurboMessaging.lambda$deleteToken$9(promise, task);
            }
        });
    }

    static /* synthetic */ Object lambda$deleteToken$8(FirebaseMessaging firebaseMessaging) throws Exception {
        Tasks.await(firebaseMessaging.deleteToken());
        return null;
    }

    static /* synthetic */ void lambda$deleteToken$9(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboMessagingSpec
    public void hasPermission(final Promise promise) {
        Tasks.call(getExecutor(), new Callable() { // from class: io.invertase.firebase.messaging.NativeRNFBTurboMessaging$$ExternalSyntheticLambda15
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.lambda$hasPermission$10();
            }
        }).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.messaging.NativeRNFBTurboMessaging$$ExternalSyntheticLambda16
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                NativeRNFBTurboMessaging.lambda$hasPermission$11(promise, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$hasPermission$10() throws Exception {
        return Boolean.valueOf(NotificationManagerCompat.from(getReactApplicationContext()).areNotificationsEnabled());
    }

    static /* synthetic */ void lambda$hasPermission$11(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(Integer.valueOf(((Boolean) task.getResult()).booleanValue() ? 1 : 0));
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboMessagingSpec
    public void sendMessage(final ReadableMap readableMap, final Promise promise) {
        Tasks.call(getExecutor(), new Callable() { // from class: io.invertase.firebase.messaging.NativeRNFBTurboMessaging$$ExternalSyntheticLambda9
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return NativeRNFBTurboMessaging.lambda$sendMessage$12(readableMap);
            }
        }).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.messaging.NativeRNFBTurboMessaging$$ExternalSyntheticLambda10
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                NativeRNFBTurboMessaging.lambda$sendMessage$13(promise, task);
            }
        });
    }

    static /* synthetic */ Object lambda$sendMessage$12(ReadableMap readableMap) throws Exception {
        FirebaseMessaging.getInstance().send(ReactNativeFirebaseMessagingSerializer.remoteMessageFromReadableMap(readableMap));
        return null;
    }

    static /* synthetic */ void lambda$sendMessage$13(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboMessagingSpec
    public void subscribeToTopic(String str, final Promise promise) {
        FirebaseMessaging.getInstance().subscribeToTopic(str).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.messaging.NativeRNFBTurboMessaging$$ExternalSyntheticLambda17
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                NativeRNFBTurboMessaging.lambda$subscribeToTopic$14(promise, task);
            }
        });
    }

    static /* synthetic */ void lambda$subscribeToTopic$14(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboMessagingSpec
    public void unsubscribeFromTopic(String str, final Promise promise) {
        FirebaseMessaging.getInstance().unsubscribeFromTopic(str).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.messaging.NativeRNFBTurboMessaging$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                NativeRNFBTurboMessaging.lambda$unsubscribeFromTopic$15(promise, task);
            }
        });
    }

    static /* synthetic */ void lambda$unsubscribeFromTopic$15(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboMessagingSpec
    public void setDeliveryMetricsExportToBigQuery(final boolean z, final Promise promise) {
        Tasks.call(getExecutor(), new Callable() { // from class: io.invertase.firebase.messaging.NativeRNFBTurboMessaging$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return NativeRNFBTurboMessaging.lambda$setDeliveryMetricsExportToBigQuery$16(z);
            }
        }).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.messaging.NativeRNFBTurboMessaging$$ExternalSyntheticLambda4
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                NativeRNFBTurboMessaging.lambda$setDeliveryMetricsExportToBigQuery$17(promise, task);
            }
        });
    }

    static /* synthetic */ Object lambda$setDeliveryMetricsExportToBigQuery$16(boolean z) throws Exception {
        FirebaseMessaging.getInstance().setDeliveryMetricsExportToBigQuery(z);
        return null;
    }

    static /* synthetic */ void lambda$setDeliveryMetricsExportToBigQuery$17(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(Boolean.valueOf(FirebaseMessaging.getInstance().deliveryMetricsExportToBigQueryEnabled()));
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onNewIntent(Intent intent) {
        WritableMap writableMapRemoteMessageToWritableMap;
        if (intent == null || intent.getExtras() == null) {
            return;
        }
        String string = intent.getExtras().getString("google.message_id");
        if (string == null) {
            string = intent.getExtras().getString(Constants.MessagePayloadKeys.MSGID_SERVER);
        }
        if (string != null) {
            RemoteMessage remoteMessage = ReactNativeFirebaseMessagingReceiver.notifications.get(string);
            if (remoteMessage == null) {
                writableMapRemoteMessageToWritableMap = popRemoteMessageMapFromMessagingStore(string);
            } else {
                writableMapRemoteMessageToWritableMap = ReactNativeFirebaseMessagingSerializer.remoteMessageToWritableMap(remoteMessage);
            }
            if (writableMapRemoteMessageToWritableMap != null) {
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                writableNativeMap.merge(writableMapRemoteMessageToWritableMap);
                this.initialNotification = writableNativeMap;
                ReactNativeFirebaseMessagingReceiver.notifications.take(string);
                ReactNativeFirebaseEventEmitter.getSharedInstance().sendEvent(ReactNativeFirebaseMessagingSerializer.remoteMessageMapToEvent(writableMapRemoteMessageToWritableMap, true));
            }
        }
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        super.invalidate();
        this.executorService.shutdown();
    }
}
