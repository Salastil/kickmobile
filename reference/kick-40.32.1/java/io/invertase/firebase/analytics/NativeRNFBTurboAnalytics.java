package io.invertase.firebase.analytics;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import com.facebook.fbreact.specs.NativeRNFBTurboAnalyticsSpec;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.invertase.firebase.common.ReactNativeFirebaseModule;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes9.dex */
public class NativeRNFBTurboAnalytics extends NativeRNFBTurboAnalyticsSpec {
    private static final long GET_SESSION_ID_TIMEOUT_MS = 60000;
    private static final String[] LONG_NUMERIC_PARAM_KEYS = {FirebaseAnalytics.Param.QUANTITY, FirebaseAnalytics.Param.INDEX, FirebaseAnalytics.Param.LEVEL, FirebaseAnalytics.Param.NUMBER_OF_NIGHTS, FirebaseAnalytics.Param.NUMBER_OF_PASSENGERS, FirebaseAnalytics.Param.NUMBER_OF_ROOMS, FirebaseAnalytics.Param.SCORE};
    private static final String SERVICE_NAME = "Analytics";
    private final UniversalFirebaseAnalyticsModule module;

    public NativeRNFBTurboAnalytics(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.module = new UniversalFirebaseAnalyticsModule(reactApplicationContext, SERVICE_NAME);
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAnalyticsSpec
    public void logEvent(String str, @Nullable ReadableMap readableMap, final Promise promise) {
        this.module.logEvent(str, toBundle(readableMap)).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.analytics.NativeRNFBTurboAnalytics$$ExternalSyntheticLambda7
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                NativeRNFBTurboAnalytics.lambda$logEvent$0(promise, task);
            }
        });
    }

    static /* synthetic */ void lambda$logEvent$0(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAnalyticsSpec
    public void setAnalyticsCollectionEnabled(boolean z, final Promise promise) {
        this.module.setAnalyticsCollectionEnabled(Boolean.valueOf(z)).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.analytics.NativeRNFBTurboAnalytics$$ExternalSyntheticLambda8
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                NativeRNFBTurboAnalytics.lambda$setAnalyticsCollectionEnabled$1(promise, task);
            }
        });
    }

    static /* synthetic */ void lambda$setAnalyticsCollectionEnabled$1(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAnalyticsSpec
    public void setSessionTimeoutDuration(double d, final Promise promise) {
        this.module.setSessionTimeoutDuration((long) d).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.analytics.NativeRNFBTurboAnalytics$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                NativeRNFBTurboAnalytics.lambda$setSessionTimeoutDuration$2(promise, task);
            }
        });
    }

    static /* synthetic */ void lambda$setSessionTimeoutDuration$2(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAnalyticsSpec
    public void getAppInstanceId(final Promise promise) {
        this.module.getAppInstanceId().addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.analytics.NativeRNFBTurboAnalytics$$ExternalSyntheticLambda10
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                NativeRNFBTurboAnalytics.lambda$getAppInstanceId$3(promise, task);
            }
        });
    }

    static /* synthetic */ void lambda$getAppInstanceId$3(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAnalyticsSpec
    public void getSessionId(final Promise promise) {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final Handler handler = new Handler(Looper.getMainLooper());
        final Runnable runnable = new Runnable() { // from class: io.invertase.firebase.analytics.NativeRNFBTurboAnalytics$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                NativeRNFBTurboAnalytics.lambda$getSessionId$4(atomicBoolean, promise);
            }
        };
        handler.postDelayed(runnable, 60000L);
        this.module.getSessionId().addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.analytics.NativeRNFBTurboAnalytics$$ExternalSyntheticLambda6
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                NativeRNFBTurboAnalytics.lambda$getSessionId$5(handler, runnable, atomicBoolean, promise, task);
            }
        });
    }

    static /* synthetic */ void lambda$getSessionId$4(AtomicBoolean atomicBoolean, Promise promise) {
        if (atomicBoolean.compareAndSet(false, true)) {
            promise.resolve(null);
        }
    }

    static /* synthetic */ void lambda$getSessionId$5(Handler handler, Runnable runnable, AtomicBoolean atomicBoolean, Promise promise, Task task) {
        handler.removeCallbacks(runnable);
        if (atomicBoolean.compareAndSet(false, true)) {
            if (task.isSuccessful()) {
                Long l = (Long) task.getResult();
                promise.resolve(l != null ? Double.valueOf(l.doubleValue()) : null);
            } else {
                ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
            }
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAnalyticsSpec
    public void setUserId(@Nullable String str, final Promise promise) {
        this.module.setUserId(str).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.analytics.NativeRNFBTurboAnalytics$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                NativeRNFBTurboAnalytics.lambda$setUserId$6(promise, task);
            }
        });
    }

    static /* synthetic */ void lambda$setUserId$6(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAnalyticsSpec
    public void setUserProperty(String str, @Nullable String str2, final Promise promise) {
        this.module.setUserProperty(str, str2).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.analytics.NativeRNFBTurboAnalytics$$ExternalSyntheticLambda2
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                NativeRNFBTurboAnalytics.lambda$setUserProperty$7(promise, task);
            }
        });
    }

    static /* synthetic */ void lambda$setUserProperty$7(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAnalyticsSpec
    public void setUserProperties(ReadableMap readableMap, final Promise promise) {
        this.module.setUserProperties(Arguments.toBundle(readableMap)).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.analytics.NativeRNFBTurboAnalytics$$ExternalSyntheticLambda4
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                NativeRNFBTurboAnalytics.lambda$setUserProperties$8(promise, task);
            }
        });
    }

    static /* synthetic */ void lambda$setUserProperties$8(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAnalyticsSpec
    public void resetAnalyticsData(final Promise promise) {
        this.module.resetAnalyticsData().addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.analytics.NativeRNFBTurboAnalytics$$ExternalSyntheticLambda9
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                NativeRNFBTurboAnalytics.lambda$resetAnalyticsData$9(promise, task);
            }
        });
    }

    static /* synthetic */ void lambda$resetAnalyticsData$9(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAnalyticsSpec
    public void setDefaultEventParameters(@Nullable ReadableMap readableMap, final Promise promise) {
        this.module.setDefaultEventParameters(toBundle(readableMap)).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.analytics.NativeRNFBTurboAnalytics$$ExternalSyntheticLambda3
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                NativeRNFBTurboAnalytics.lambda$setDefaultEventParameters$10(promise, task);
            }
        });
    }

    static /* synthetic */ void lambda$setDefaultEventParameters$10(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAnalyticsSpec
    public void setConsent(ReadableMap readableMap, final Promise promise) {
        this.module.setConsent(Arguments.toBundle(readableMap)).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.analytics.NativeRNFBTurboAnalytics$$ExternalSyntheticLambda11
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                NativeRNFBTurboAnalytics.lambda$setConsent$11(promise, task);
            }
        });
    }

    static /* synthetic */ void lambda$setConsent$11(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAnalyticsSpec
    public void logTransaction(String str, Promise promise) {
        promise.reject("platform-unsupported", "logTransaction is only supported on iOS");
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAnalyticsSpec
    public void initiateOnDeviceConversionMeasurementWithEmailAddress(String str, Promise promise) {
        promise.reject("platform-unsupported", "initiateOnDeviceConversionMeasurementWithEmailAddress is only supported on iOS");
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAnalyticsSpec
    public void initiateOnDeviceConversionMeasurementWithHashedEmailAddress(String str, Promise promise) {
        promise.reject("platform-unsupported", "initiateOnDeviceConversionMeasurementWithHashedEmailAddress is only supported on iOS");
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAnalyticsSpec
    public void initiateOnDeviceConversionMeasurementWithPhoneNumber(String str, Promise promise) {
        promise.reject("platform-unsupported", "initiateOnDeviceConversionMeasurementWithPhoneNumber is only supported on iOS");
    }

    @Override // com.facebook.fbreact.specs.NativeRNFBTurboAnalyticsSpec
    public void initiateOnDeviceConversionMeasurementWithHashedPhoneNumber(String str, Promise promise) {
        promise.reject("platform-unsupported", "initiateOnDeviceConversionMeasurementWithHashedPhoneNumber is only supported on iOS");
    }

    private Bundle toBundle(ReadableMap readableMap) {
        Bundle bundle = Arguments.toBundle(readableMap);
        if (bundle == null) {
            return null;
        }
        Object obj = bundle.get("items");
        if (obj instanceof ArrayList) {
            ArrayList arrayList = (ArrayList) obj;
            if (arrayList.isEmpty()) {
                bundle.putParcelableArray("items", new Bundle[0]);
            } else {
                ArrayList arrayList2 = new ArrayList(arrayList.size());
                for (Object obj2 : arrayList) {
                    if (obj2 instanceof Bundle) {
                        Bundle bundle2 = (Bundle) obj2;
                        coerceLongNumericParams(bundle2);
                        arrayList2.add(bundle2);
                    }
                }
                bundle.putParcelableArray("items", (Parcelable[]) arrayList2.toArray(new Bundle[0]));
            }
        }
        coerceLongNumericParams(bundle);
        coerceSuccessParamToLong(bundle);
        if (bundle.containsKey(FirebaseAnalytics.Param.EXTEND_SESSION)) {
            bundle.putLong(FirebaseAnalytics.Param.EXTEND_SESSION, (long) bundle.getDouble(FirebaseAnalytics.Param.EXTEND_SESSION));
        }
        return bundle;
    }

    private static void coerceLongNumericParams(Bundle bundle) {
        for (String str : LONG_NUMERIC_PARAM_KEYS) {
            if (bundle.containsKey(str)) {
                bundle.putLong(str, (long) bundle.getDouble(str));
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0021  */
    private static void coerceSuccessParamToLong(Bundle bundle) {
        if (bundle.containsKey(FirebaseAnalytics.Param.SUCCESS)) {
            Object obj = bundle.get(FirebaseAnalytics.Param.SUCCESS);
            bundle.remove(FirebaseAnalytics.Param.SUCCESS);
            long j = 1;
            long j2 = 0;
            if (obj instanceof Boolean) {
                if (!((Boolean) obj).booleanValue()) {
                    j = 0;
                }
                j2 = j;
            } else if (obj instanceof Number) {
                if (((Number) obj).longValue() == 0) {
                    j = 0;
                }
                j2 = j;
            } else if (obj instanceof String) {
                String lowerCase = ((String) obj).trim().toLowerCase(Locale.ROOT);
                if (!"1".equals(lowerCase) && !"true".equals(lowerCase) && !"yes".equals(lowerCase)) {
                    j = 0;
                }
                j2 = j;
            }
            bundle.putLong(FirebaseAnalytics.Param.SUCCESS, j2);
        }
    }
}
