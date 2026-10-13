package expo.modules.application;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.provider.Settings;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import io.github.expo.modules.v2.Module;
import io.github.expo.modules.v2.async.Promise;
import io.github.expo.modules.v2.modules.ModuleBuilder;
import io.github.expo.modules.v2.react.ReactContextExtensionsKt;
import io.github.expo.modules.v2.types.AnyType;
import io.github.expo.modules.v2.types.CommonDescriptors;
import io.github.expo.modules.v2.types.TypeDescriptor;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: ApplicationModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u0006\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0019\u001a\u00020\u001aH\u0087@¢\u0006\u0002\u0010\u001bJ\u000e\u0010\u001c\u001a\u00020\u001aH\u0087@¢\u0006\u0002\u0010\u001bJ\u000e\u0010\u001d\u001a\u00020\tH\u0087@¢\u0006\u0002\u0010\u001bR\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\u000f\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0003\u001a\u0004\b\u0012\u0010\fR\u001a\u0010\u0013\u001a\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0015\u0010\fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\t8GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0003\u001a\u0004\b\u0018\u0010\f¨\u0006\u001e"}, d2 = {"Lexpo/modules/application/ApplicationModule;", "Lio/github/expo/modules/v2/Module;", "<init>", "()V", "packageInfo", "Landroid/content/pm/PackageInfo;", "getPackageInfo", "()Landroid/content/pm/PackageInfo;", "applicationName", "", "getApplicationName$annotations", "getApplicationName", "()Ljava/lang/String;", "applicationId", "getApplicationId$annotations", "getApplicationId", "nativeApplicationVersion", "getNativeApplicationVersion$annotations", "getNativeApplicationVersion", "nativeBuildVersion", "getNativeBuildVersion$annotations", "getNativeBuildVersion", "androidId", "getAndroidId$annotations", "getAndroidId", "getInstallationTimeAsync", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLastUpdateTimeAsync", "getInstallReferrerAsync", "expo-application_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ApplicationModule extends Module {
    public static /* synthetic */ void getAndroidId$annotations() {
    }

    public static /* synthetic */ void getApplicationId$annotations() {
    }

    public static /* synthetic */ void getApplicationName$annotations() {
    }

    public static /* synthetic */ void getNativeApplicationVersion$annotations() {
    }

    public static /* synthetic */ void getNativeBuildVersion$annotations() {
    }

    @Override // io.github.expo.modules.v2.Module
    public final String define$ExpoModulesV2(ModuleBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        builder.property("applicationName", new AnyType(CommonDescriptors.STRING, false), false, "applicationName", new AnyType(CommonDescriptors.STRING, false), true);
        builder.property("applicationId", new AnyType(CommonDescriptors.STRING, false), false, "applicationId", new AnyType(CommonDescriptors.STRING, false), true);
        builder.property("nativeApplicationVersion", new AnyType(CommonDescriptors.STRING_NULL, false), false, "nativeApplicationVersion", new AnyType(CommonDescriptors.STRING_NULL, false), true);
        builder.property("nativeBuildVersion", new AnyType(CommonDescriptors.STRING, false), false, "nativeBuildVersion", new AnyType(CommonDescriptors.STRING, false), true);
        builder.property("androidId", new AnyType(CommonDescriptors.STRING_NULL, false), false, "androidId", new AnyType(CommonDescriptors.STRING_NULL, false), true);
        builder.function("getInstallationTimeAsync", new AnyType[0], new AnyType(TypeDescriptor.Double.INSTANCE, false), "getInstallationTimeAsync__trampoline$ExpoModulesV2", true);
        builder.function("getLastUpdateTimeAsync", new AnyType[0], new AnyType(TypeDescriptor.Double.INSTANCE, false), "getLastUpdateTimeAsync__trampoline$ExpoModulesV2", true);
        builder.function("getInstallReferrerAsync", new AnyType[0], new AnyType(CommonDescriptors.STRING, false), "getInstallReferrerAsync__trampoline$ExpoModulesV2", true);
        return "ExpoApplication";
    }

    public final void getInstallReferrerAsync__trampoline$ExpoModulesV2(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        promise.launch(CommonDescriptors.STRING, false, new ApplicationModule$getInstallReferrerAsync__trampoline$ExpoModulesV2$1(this, null));
    }

    public final void getInstallationTimeAsync__trampoline$ExpoModulesV2(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        promise.launch(TypeDescriptor.Double.INSTANCE, false, new ApplicationModule$getInstallationTimeAsync__trampoline$ExpoModulesV2$1(this, null));
    }

    public final void getLastUpdateTimeAsync__trampoline$ExpoModulesV2(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        promise.launch(TypeDescriptor.Double.INSTANCE, false, new ApplicationModule$getLastUpdateTimeAsync__trampoline$ExpoModulesV2$1(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PackageInfo getPackageInfo() {
        ApplicationModule applicationModule = this;
        PackageManager packageManager = ReactContextExtensionsKt.getAndroidContext(applicationModule).getPackageManager();
        Intrinsics.checkNotNullExpressionValue(packageManager, "getPackageManager(...)");
        String packageName = ReactContextExtensionsKt.getAndroidContext(applicationModule).getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        return ApplicationModuleKt.getPackageInfoCompat$default(packageManager, packageName, 0, 2, null);
    }

    public final String getApplicationName() {
        ApplicationModule applicationModule = this;
        return ReactContextExtensionsKt.getAndroidContext(applicationModule).getApplicationInfo().loadLabel(ReactContextExtensionsKt.getAndroidContext(applicationModule).getPackageManager()).toString();
    }

    public final String getApplicationId() {
        String packageName = ReactContextExtensionsKt.getAndroidContext(this).getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        return packageName;
    }

    public final String getNativeApplicationVersion() {
        return getPackageInfo().versionName;
    }

    public final String getNativeBuildVersion() {
        return String.valueOf((int) ApplicationModuleKt.getLongVersionCode(getPackageInfo()));
    }

    public final String getAndroidId() {
        return Settings.Secure.getString(ReactContextExtensionsKt.getAndroidContext(this).getContentResolver(), "android_id");
    }

    /* JADX INFO: renamed from: expo.modules.application.ApplicationModule$getInstallationTimeAsync$2, reason: invalid class name */
    /* JADX INFO: compiled from: ApplicationModule.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0006\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.application.ApplicationModule$getInstallationTimeAsync$2", f = "ApplicationModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Double>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ApplicationModule.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Double> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return Boxing.boxDouble(ApplicationModule.this.getPackageInfo().firstInstallTime);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object getInstallationTimeAsync(Continuation<? super Double> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(null), continuation);
    }

    /* JADX INFO: renamed from: expo.modules.application.ApplicationModule$getLastUpdateTimeAsync$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ApplicationModule.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0006\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.application.ApplicationModule$getLastUpdateTimeAsync$2", f = "ApplicationModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C08062 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Double>, Object> {
        int label;

        C08062(Continuation<? super C08062> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ApplicationModule.this.new C08062(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Double> continuation) {
            return ((C08062) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return Boxing.boxDouble(ApplicationModule.this.getPackageInfo().lastUpdateTime);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object getLastUpdateTimeAsync(Continuation<? super Double> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C08062(null), continuation);
    }

    public final Object getInstallReferrerAsync(Continuation<? super String> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        final InstallReferrerClient installReferrerClientBuild = InstallReferrerClient.newBuilder(ReactContextExtensionsKt.getAndroidContext(this)).build();
        installReferrerClientBuild.startConnection(new InstallReferrerStateListener() { // from class: expo.modules.application.ApplicationModule$getInstallReferrerAsync$2$listener$1
            @Override // com.android.installreferrer.api.InstallReferrerStateListener
            public void onInstallReferrerSetupFinished(int responseCode) {
                if (cancellableContinuationImpl2.isActive()) {
                    if (responseCode == 0) {
                        try {
                            String installReferrer = installReferrerClientBuild.getInstallReferrer().getInstallReferrer();
                            CancellableContinuation<String> cancellableContinuation = cancellableContinuationImpl2;
                            Result.Companion companion = Result.INSTANCE;
                            cancellableContinuation.resumeWith(Result.m12684constructorimpl(String.valueOf(installReferrer)));
                        } catch (RemoteException e) {
                            CancellableContinuation<String> cancellableContinuation2 = cancellableContinuationImpl2;
                            Result.Companion companion2 = Result.INSTANCE;
                            cancellableContinuation2.resumeWith(Result.m12684constructorimpl(ResultKt.createFailure(new ApplicationInstallReferrerRemoteException(e))));
                        }
                    } else {
                        CancellableContinuation<String> cancellableContinuation3 = cancellableContinuationImpl2;
                        if (responseCode == 2) {
                            Result.Companion companion3 = Result.INSTANCE;
                            cancellableContinuation3.resumeWith(Result.m12684constructorimpl(ResultKt.createFailure(new ApplicationInstallReferrerUnavailableException())));
                        } else {
                            Result.Companion companion4 = Result.INSTANCE;
                            cancellableContinuation3.resumeWith(Result.m12684constructorimpl(ResultKt.createFailure(new ApplicationInstallReferrerException(responseCode))));
                        }
                    }
                    installReferrerClientBuild.endConnection();
                }
            }

            @Override // com.android.installreferrer.api.InstallReferrerStateListener
            public void onInstallReferrerServiceDisconnected() {
                if (cancellableContinuationImpl2.isActive()) {
                    CancellableContinuation<String> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m12684constructorimpl(ResultKt.createFailure(new ApplicationInstallReferrerServiceDisconnectedException())));
                }
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
