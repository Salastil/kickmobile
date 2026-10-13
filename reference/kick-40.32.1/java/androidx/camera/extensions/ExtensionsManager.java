package androidx.camera.extensions;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.util.Range;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraFilter;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraProvider;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.impl.ExtendedCameraConfigProviderStore;
import androidx.camera.core.impl.utils.ContextUtil;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.extensions.internal.Camera2ExtensionsInfo;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.concurrent.futures.ListenableFutureKt;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.datadog.trace.api.config.ProfilingConfig;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.ExecutionException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExtensionsManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 -2\u00020\u0001:\u0002,-B!\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0007J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015J\u0017\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0014\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u0018J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015J\u001e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&J\u0015\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\b+R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Landroidx/camera/extensions/ExtensionsManager;", "", "extensionsAvailability", "Landroidx/camera/extensions/ExtensionsManager$ExtensionsAvailability;", "cameraProvider", "Landroidx/camera/core/CameraProvider;", "applicationContext", "Landroid/content/Context;", "<init>", "(Landroidx/camera/extensions/ExtensionsManager$ExtensionsAvailability;Landroidx/camera/core/CameraProvider;Landroid/content/Context;)V", "getExtensionsAvailability$camera_extensions", "()Landroidx/camera/extensions/ExtensionsManager$ExtensionsAvailability;", "extensionsInfo", "Landroidx/camera/extensions/ExtensionsInfo;", "shutdown", "Lcom/google/common/util/concurrent/ListenableFuture;", "Ljava/lang/Void;", "getExtensionEnabledCameraSelector", "Landroidx/camera/core/CameraSelector;", "cameraSelector", "mode", "", "getExtensionCameraFilterAndInjectCameraConfig", "Landroidx/camera/core/CameraFilter;", "getExtensionCameraFilterAndInjectCameraConfig$camera_extensions", "isExtensionAvailable", "", "getEstimatedCaptureLatencyRange", "Landroid/util/Range;", "", "isImageAnalysisSupported", "getCameraExtensionsControl", "Landroidx/camera/extensions/CameraExtensionsControl;", "cameraControl", "Landroidx/camera/core/CameraControl;", "getCameraExtensionsInfo", "Landroidx/camera/extensions/CameraExtensionsInfo;", "cameraInfo", "Landroidx/camera/core/CameraInfo;", "setVendorExtenderFactory", "", "vendorExtenderFactory", "Landroidx/camera/extensions/VendorExtenderFactory;", "setVendorExtenderFactory$camera_extensions", "ExtensionsAvailability", "Companion", "camera-extensions"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExtensionsManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Object EXTENSIONS_LOCK = new Object();
    private static final int MINIMUM_SUPPORTED_API_LEVEL = 33;
    private static final String TAG = "ExtensionsManager";
    private static ListenableFuture<Void> sDeinitializeFuture;
    private static ExtensionsManager sExtensionsManager;
    private static ListenableFuture<ExtensionsManager> sInitializeFuture;
    private final ExtensionsAvailability extensionsAvailability;
    private final ExtensionsInfo extensionsInfo;

    /* JADX INFO: compiled from: ExtensionsManager.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Landroidx/camera/extensions/ExtensionsManager$ExtensionsAvailability;", "", "<init>", "(Ljava/lang/String;I)V", "LIBRARY_AVAILABLE", "LIBRARY_UNAVAILABLE_ERROR_LOADING", "LIBRARY_UNAVAILABLE_MISSING_IMPLEMENTATION", ProfilingConfig.PROFILING_DATADOG_PROFILER_LOG_LEVEL_DEFAULT, "camera-extensions"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public enum ExtensionsAvailability {
        LIBRARY_AVAILABLE,
        LIBRARY_UNAVAILABLE_ERROR_LOADING,
        LIBRARY_UNAVAILABLE_MISSING_IMPLEMENTATION,
        NONE;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<ExtensionsAvailability> getEntries() {
            return $ENTRIES;
        }
    }

    @JvmStatic
    public static final Object getInstance(Context context, CameraProvider cameraProvider, Continuation<? super ExtensionsManager> continuation) {
        return INSTANCE.getInstance(context, cameraProvider, continuation);
    }

    @JvmStatic
    public static final ListenableFuture<ExtensionsManager> getInstanceAsync(Context context, CameraProvider cameraProvider) {
        return INSTANCE.getInstanceAsync(context, cameraProvider);
    }

    public ExtensionsManager(ExtensionsAvailability extensionsAvailability, CameraProvider cameraProvider, Context applicationContext) {
        Intrinsics.checkNotNullParameter(extensionsAvailability, "extensionsAvailability");
        Intrinsics.checkNotNullParameter(cameraProvider, "cameraProvider");
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        this.extensionsAvailability = extensionsAvailability;
        this.extensionsInfo = new ExtensionsInfo(cameraProvider, applicationContext);
    }

    /* JADX INFO: renamed from: getExtensionsAvailability$camera_extensions, reason: from getter */
    public final ExtensionsAvailability getExtensionsAvailability() {
        return this.extensionsAvailability;
    }

    public final ListenableFuture<Void> shutdown() {
        synchronized (EXTENSIONS_LOCK) {
            ListenableFuture<ExtensionsManager> listenableFuture = sInitializeFuture;
            if (listenableFuture == null) {
                ListenableFuture<Void> listenableFutureImmediateFuture = Futures.immediateFuture(null);
                Intrinsics.checkNotNullExpressionValue(listenableFutureImmediateFuture, "immediateFuture(...)");
                return listenableFutureImmediateFuture;
            }
            ListenableFuture<Void> listenableFuture2 = sDeinitializeFuture;
            if (listenableFuture2 != null) {
                Intrinsics.checkNotNull(listenableFuture2);
                return listenableFuture2;
            }
            try {
                Intrinsics.checkNotNull(listenableFuture);
                listenableFuture.get();
                sInitializeFuture = null;
                ExtensionsManager extensionsManager = sExtensionsManager;
                Intrinsics.checkNotNull(extensionsManager);
                ExtensionsAvailability extensionsAvailability = extensionsManager.extensionsAvailability;
                sExtensionsManager = null;
                ExtendedCameraConfigProviderStore.clear();
                ListenableFuture<Void> listenableFutureImmediateFuture2 = Futures.immediateFuture(null);
                sDeinitializeFuture = listenableFutureImmediateFuture2;
                Intrinsics.checkNotNull(listenableFutureImmediateFuture2);
                return listenableFutureImmediateFuture2;
            } catch (InterruptedException e) {
                ListenableFuture<Void> listenableFutureImmediateFailedFuture = Futures.immediateFailedFuture(e);
                sDeinitializeFuture = listenableFutureImmediateFailedFuture;
                Intrinsics.checkNotNull(listenableFutureImmediateFailedFuture);
                return listenableFutureImmediateFailedFuture;
            } catch (ExecutionException e2) {
                ListenableFuture<Void> listenableFutureImmediateFailedFuture2 = Futures.immediateFailedFuture(e2);
                sDeinitializeFuture = listenableFutureImmediateFailedFuture2;
                Intrinsics.checkNotNull(listenableFutureImmediateFailedFuture2);
                return listenableFutureImmediateFailedFuture2;
            }
        }
    }

    public final CameraSelector getExtensionEnabledCameraSelector(CameraSelector cameraSelector, int mode) {
        Intrinsics.checkNotNullParameter(cameraSelector, "cameraSelector");
        if (mode == 0) {
            return cameraSelector;
        }
        if (this.extensionsAvailability != ExtensionsAvailability.LIBRARY_AVAILABLE) {
            throw new IllegalArgumentException("This device doesn't support extensions function! isExtensionAvailable should be checked first before calling getExtensionEnabledCameraSelector.".toString());
        }
        CameraSelector extensionCameraSelectorAndInjectCameraConfig = this.extensionsInfo.getExtensionCameraSelectorAndInjectCameraConfig(cameraSelector, mode);
        Intrinsics.checkNotNullExpressionValue(extensionCameraSelectorAndInjectCameraConfig, "getExtensionCameraSelect…ndInjectCameraConfig(...)");
        return extensionCameraSelectorAndInjectCameraConfig;
    }

    public final CameraFilter getExtensionCameraFilterAndInjectCameraConfig$camera_extensions(int mode) {
        if (mode == 0) {
            return null;
        }
        if (this.extensionsAvailability != ExtensionsAvailability.LIBRARY_AVAILABLE) {
            throw new IllegalArgumentException("This device doesn't support extensions function! isExtensionAvailable should be checked first before calling getExtensionEnabledCameraSelector.".toString());
        }
        this.extensionsInfo.injectExtensionCameraConfig(mode);
        return this.extensionsInfo.getCameraFilter(mode);
    }

    public final boolean isExtensionAvailable(CameraSelector cameraSelector, int mode) {
        Intrinsics.checkNotNullParameter(cameraSelector, "cameraSelector");
        if (mode == 0) {
            return true;
        }
        if (this.extensionsAvailability != ExtensionsAvailability.LIBRARY_AVAILABLE) {
            return false;
        }
        return this.extensionsInfo.isExtensionAvailable(cameraSelector, mode);
    }

    public final Range<Long> getEstimatedCaptureLatencyRange(CameraSelector cameraSelector, int mode) {
        Intrinsics.checkNotNullParameter(cameraSelector, "cameraSelector");
        if (mode == 0 || this.extensionsAvailability != ExtensionsAvailability.LIBRARY_AVAILABLE) {
            return null;
        }
        return this.extensionsInfo.getEstimatedCaptureLatencyRange(cameraSelector, mode, null);
    }

    public final boolean isImageAnalysisSupported(CameraSelector cameraSelector, int mode) {
        Intrinsics.checkNotNullParameter(cameraSelector, "cameraSelector");
        if (mode == 0) {
            return true;
        }
        if (this.extensionsAvailability != ExtensionsAvailability.LIBRARY_AVAILABLE) {
            return false;
        }
        return this.extensionsInfo.isImageAnalysisSupported(cameraSelector, mode);
    }

    public final CameraExtensionsControl getCameraExtensionsControl(CameraControl cameraControl) {
        Intrinsics.checkNotNullParameter(cameraControl, "cameraControl");
        return CameraExtensionsControls.from(cameraControl);
    }

    public final CameraExtensionsInfo getCameraExtensionsInfo(CameraInfo cameraInfo) {
        Intrinsics.checkNotNullParameter(cameraInfo, "cameraInfo");
        CameraExtensionsInfo cameraExtensionsInfoFrom = CameraExtensionsInfos.from(cameraInfo);
        Intrinsics.checkNotNullExpressionValue(cameraExtensionsInfoFrom, "from(...)");
        return cameraExtensionsInfoFrom;
    }

    public final void setVendorExtenderFactory$camera_extensions(VendorExtenderFactory vendorExtenderFactory) {
        Intrinsics.checkNotNullParameter(vendorExtenderFactory, "vendorExtenderFactory");
        this.extensionsInfo.setVendorExtenderFactory(vendorExtenderFactory);
    }

    /* JADX INFO: compiled from: ExtensionsManager.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J \u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0011H\u0002J\u001e\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0087@¢\u0006\u0002\u0010\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/camera/extensions/ExtensionsManager$Companion;", "", "<init>", "()V", "TAG", "", "MINIMUM_SUPPORTED_API_LEVEL", "", "EXTENSIONS_LOCK", "sInitializeFuture", "Lcom/google/common/util/concurrent/ListenableFuture;", "Landroidx/camera/extensions/ExtensionsManager;", "sDeinitializeFuture", "Ljava/lang/Void;", "sExtensionsManager", "getInstanceAsync", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "cameraProvider", "Landroidx/camera/core/CameraProvider;", "getOrCreateExtensionsManager", "extensionsAvailability", "Landroidx/camera/extensions/ExtensionsManager$ExtensionsAvailability;", "applicationContext", "getInstance", "(Landroid/content/Context;Landroidx/camera/core/CameraProvider;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "camera-extensions"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ListenableFuture<ExtensionsManager> getInstanceAsync(Context context, final CameraProvider cameraProvider) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(cameraProvider, "cameraProvider");
            synchronized (ExtensionsManager.EXTENSIONS_LOCK) {
                ListenableFuture listenableFuture = ExtensionsManager.sDeinitializeFuture;
                boolean z = false;
                if (listenableFuture != null && !listenableFuture.isDone()) {
                    z = true;
                }
                if (z) {
                    throw new IllegalStateException("Not yet done deinitializing extensions".toString());
                }
                Companion companion = ExtensionsManager.INSTANCE;
                ExtensionsManager.sDeinitializeFuture = null;
                final Context persistentApplicationContext = ContextUtil.getPersistentApplicationContext(context);
                Intrinsics.checkNotNullExpressionValue(persistentApplicationContext, "getPersistentApplicationContext(...)");
                if (Build.VERSION.SDK_INT < 33) {
                    ListenableFuture<ExtensionsManager> listenableFutureImmediateFuture = Futures.immediateFuture(ExtensionsManager.INSTANCE.getOrCreateExtensionsManager(ExtensionsAvailability.NONE, cameraProvider, persistentApplicationContext));
                    Intrinsics.checkNotNullExpressionValue(listenableFutureImmediateFuture, "immediateFuture(...)");
                    return listenableFutureImmediateFuture;
                }
                if (ExtensionsManager.sInitializeFuture == null) {
                    Companion companion2 = ExtensionsManager.INSTANCE;
                    ExtensionsManager.sInitializeFuture = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.extensions.ExtensionsManager$Companion$$ExternalSyntheticLambda0
                        @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                        public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                            return ExtensionsManager.Companion.getInstanceAsync$lambda$0$1(persistentApplicationContext, cameraProvider, completer);
                        }
                    });
                }
                ListenableFuture<ExtensionsManager> listenableFuture2 = ExtensionsManager.sInitializeFuture;
                Intrinsics.checkNotNull(listenableFuture2);
                return listenableFuture2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Object getInstanceAsync$lambda$0$1(Context context, CameraProvider cameraProvider, CallbackToFutureAdapter.Completer completer) throws CameraAccessException {
            String str;
            ExtensionsAvailability extensionsAvailability;
            Intrinsics.checkNotNullParameter(completer, "completer");
            CameraManager cameraManager = (CameraManager) context.getSystemService(CameraManager.class);
            Intrinsics.checkNotNull(cameraManager);
            Camera2ExtensionsInfo camera2ExtensionsInfo = new Camera2ExtensionsInfo(cameraManager);
            String[] cameraIdList = cameraManager.getCameraIdList();
            Intrinsics.checkNotNullExpressionValue(cameraIdList, "getCameraIdList(...)");
            String[] strArr = cameraIdList;
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    str = null;
                    break;
                }
                str = strArr[i];
                String str2 = str;
                Intrinsics.checkNotNull(str2);
                List supportedExtensions = camera2ExtensionsInfo.getExtensionCharacteristics(str2).getSupportedExtensions();
                Intrinsics.checkNotNullExpressionValue(supportedExtensions, "getSupportedExtensions(...)");
                if (!supportedExtensions.isEmpty()) {
                    break;
                }
                i++;
            }
            boolean z = str != null;
            Companion companion = ExtensionsManager.INSTANCE;
            if (!z) {
                extensionsAvailability = ExtensionsAvailability.NONE;
            } else {
                extensionsAvailability = ExtensionsAvailability.LIBRARY_AVAILABLE;
            }
            completer.set(companion.getOrCreateExtensionsManager(extensionsAvailability, cameraProvider, context));
            return "Initialize extensions";
        }

        private final ExtensionsManager getOrCreateExtensionsManager(ExtensionsAvailability extensionsAvailability, CameraProvider cameraProvider, Context applicationContext) {
            ExtensionsManager extensionsManager;
            synchronized (ExtensionsManager.EXTENSIONS_LOCK) {
                extensionsManager = ExtensionsManager.sExtensionsManager;
                if (extensionsManager == null) {
                    extensionsManager = new ExtensionsManager(extensionsAvailability, cameraProvider, applicationContext);
                    Companion companion = ExtensionsManager.INSTANCE;
                    ExtensionsManager.sExtensionsManager = extensionsManager;
                }
            }
            return extensionsManager;
        }

        @JvmStatic
        public final Object getInstance(Context context, CameraProvider cameraProvider, Continuation<? super ExtensionsManager> continuation) {
            return ListenableFutureKt.await(getInstanceAsync(context, cameraProvider), continuation);
        }
    }
}
