package expo.modules.updates;

import android.content.Context;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.updates.events.IUpdatesEventManager;
import expo.modules.updates.events.IUpdatesEventManagerObserver;
import expo.modules.updates.logging.UpdatesErrorCode;
import expo.modules.updates.logging.UpdatesLogger;
import expo.modules.updatesinterface.UpdatesControllerRegistry;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UpdatesController.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u001a\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007J$\u0010\u0006\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016H\u0007J\u001b\u0010\u0018\u001a\u00020\r2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0000¢\u0006\u0002\b\u001cJ\r\u0010\u001d\u001a\u00020\rH\u0000¢\u0006\u0002\b\u001eR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\n\u0010\u000b¨\u0006\u001f"}, d2 = {"Lexpo/modules/updates/UpdatesController;", "", "<init>", "()V", "singletonInstance", "Lexpo/modules/updates/IUpdatesController;", "overrideConfiguration", "Lexpo/modules/updates/UpdatesConfiguration;", "instance", "getInstance$annotations", "getInstance", "()Lexpo/modules/updates/IUpdatesController;", "initializeWithoutStarting", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "useDeveloperSupport", "", "initializeAsDevLauncherWithoutStarting", "Lexpo/modules/updates/UpdatesDevLauncherController;", "initialize", "configuration", "", "", "setUpdatesEventManagerObserver", "observer", "Ljava/lang/ref/WeakReference;", "Lexpo/modules/updates/events/IUpdatesEventManagerObserver;", "setUpdatesEventManagerObserver$expo_updates_release", "removeUpdatesEventManagerObserver", "removeUpdatesEventManagerObserver$expo_updates_release", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class UpdatesController {
    public static final UpdatesController INSTANCE = new UpdatesController();
    private static volatile UpdatesConfiguration overrideConfiguration;
    private static volatile IUpdatesController singletonInstance;

    /* JADX INFO: compiled from: UpdatesController.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[UpdatesConfigurationValidationResult.values().length];
            try {
                iArr[UpdatesConfigurationValidationResult.VALID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[UpdatesConfigurationValidationResult.INVALID_NOT_ENABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[UpdatesConfigurationValidationResult.INVALID_MISSING_URL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[UpdatesConfigurationValidationResult.INVALID_MISSING_RUNTIME_VERSION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @JvmStatic
    public static /* synthetic */ void getInstance$annotations() {
    }

    private UpdatesController() {
    }

    public static final IUpdatesController getInstance() {
        IUpdatesController iUpdatesController = singletonInstance;
        if (iUpdatesController != null) {
            return iUpdatesController;
        }
        throw new IllegalStateException("UpdatesController.instance was called before the module was initialized".toString());
    }

    @JvmStatic
    public static final void initializeWithoutStarting(Context context, boolean useDeveloperSupport) throws IOException {
        DisabledUpdatesController disabledUpdatesController;
        Intrinsics.checkNotNullParameter(context, "context");
        if (singletonInstance != null) {
            return;
        }
        if (useDeveloperSupport && !UpdatesPackage.INSTANCE.isUsingNativeDebug()) {
            UpdatesDevLauncherController updatesDevLauncherControllerInitializeAsDevLauncherWithoutStarting = INSTANCE.initializeAsDevLauncherWithoutStarting(context);
            singletonInstance = updatesDevLauncherControllerInitializeAsDevLauncherWithoutStarting;
            UpdatesControllerRegistry.INSTANCE.setController(new WeakReference<>(updatesDevLauncherControllerInitializeAsDevLauncherWithoutStarting));
            return;
        }
        File filesDir = context.getFilesDir();
        Intrinsics.checkNotNullExpressionValue(filesDir, "getFilesDir(...)");
        UpdatesLogger updatesLogger = new UpdatesLogger(filesDir);
        try {
            File orCreateUpdatesDirectory = UpdatesUtils.INSTANCE.getOrCreateUpdatesDirectory(context);
            UpdatesConfiguration updatesConfiguration = overrideConfiguration;
            if (updatesConfiguration == null) {
                int i = WhenMappings.$EnumSwitchMapping$0[UpdatesConfiguration.INSTANCE.getUpdatesConfigurationValidationResult(context, null).ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        updatesLogger.warn("The expo-updates system is explicitly disabled. To enable it, set the enabled setting to true.", UpdatesErrorCode.InitializationError);
                    } else if (i == 3) {
                        updatesLogger.warn("The expo-updates system is disabled due to an invalid configuration. Ensure a valid URL is supplied.", UpdatesErrorCode.InitializationError);
                    } else {
                        if (i != 4) {
                            throw new NoWhenBranchMatchedException();
                        }
                        updatesLogger.warn("The expo-updates system is disabled due to an invalid configuration. Ensure a runtime version is supplied.", UpdatesErrorCode.InitializationError);
                    }
                    updatesConfiguration = null;
                } else {
                    updatesConfiguration = new UpdatesConfiguration(context, null);
                }
            }
            if (updatesConfiguration != null) {
                EnabledUpdatesController enabledUpdatesController = new EnabledUpdatesController(context, updatesConfiguration, orCreateUpdatesDirectory);
                UpdatesControllerRegistry.INSTANCE.setController(new WeakReference<>(enabledUpdatesController));
                disabledUpdatesController = enabledUpdatesController;
            } else {
                DisabledUpdatesController disabledUpdatesController2 = new DisabledUpdatesController(context, null);
                UpdatesControllerRegistry.INSTANCE.setController(new WeakReference<>(disabledUpdatesController2));
                disabledUpdatesController = disabledUpdatesController2;
            }
            singletonInstance = disabledUpdatesController;
        } catch (Exception e) {
            updatesLogger.error("The expo-updates system is disabled due to a storage access error", e, UpdatesErrorCode.InitializationError);
            singletonInstance = new DisabledUpdatesController(context, e);
        }
    }

    private final UpdatesDevLauncherController initializeAsDevLauncherWithoutStarting(Context context) {
        Exception exc;
        File orCreateUpdatesDirectory;
        if (singletonInstance != null) {
            throw new IllegalStateException("UpdatesController must not be initialized prior to calling initializeAsDevLauncherWithoutStarting".toString());
        }
        try {
            orCreateUpdatesDirectory = UpdatesUtils.INSTANCE.getOrCreateUpdatesDirectory(context);
            exc = null;
        } catch (Exception e) {
            exc = e;
            orCreateUpdatesDirectory = null;
        }
        UpdatesConfiguration updatesConfiguration = overrideConfiguration;
        if (updatesConfiguration == null) {
            updatesConfiguration = UpdatesConfiguration.INSTANCE.getUpdatesConfigurationValidationResult(context, null) == UpdatesConfigurationValidationResult.VALID ? new UpdatesConfiguration(context, null) : null;
        }
        UpdatesDevLauncherController updatesDevLauncherController = new UpdatesDevLauncherController(context, updatesConfiguration, orCreateUpdatesDirectory, exc);
        singletonInstance = updatesDevLauncherController;
        return updatesDevLauncherController;
    }

    public static /* synthetic */ void initialize$default(Context context, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        initialize(context, z);
    }

    @JvmStatic
    public static final synchronized void initialize(Context context, boolean useDeveloperSupport) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (singletonInstance == null) {
            initializeWithoutStarting(context, useDeveloperSupport);
            IUpdatesController iUpdatesController = singletonInstance;
            if (iUpdatesController != null) {
                iUpdatesController.start();
            }
        }
    }

    @JvmStatic
    public static final void overrideConfiguration(Context context, Map<String, ? extends Object> configuration) throws IOException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        if (singletonInstance != null) {
            throw new AssertionError("The method should be called before UpdatesController.initialize()");
        }
        UpdatesConfigurationValidationResult updatesConfigurationValidationResult = UpdatesConfiguration.INSTANCE.getUpdatesConfigurationValidationResult(context, configuration);
        if (updatesConfigurationValidationResult == UpdatesConfigurationValidationResult.VALID) {
            overrideConfiguration = new UpdatesConfiguration(context, configuration);
            return;
        }
        File filesDir = context.getFilesDir();
        Intrinsics.checkNotNullExpressionValue(filesDir, "getFilesDir(...)");
        UpdatesLogger.warn$default(new UpdatesLogger(filesDir), "Failed to overrideConfiguration: invalid configuration: " + updatesConfigurationValidationResult.name(), null, 2, null);
    }

    public final void setUpdatesEventManagerObserver$expo_updates_release(WeakReference<IUpdatesEventManagerObserver> observer) {
        IUpdatesEventManager eventManager;
        Intrinsics.checkNotNullParameter(observer, "observer");
        IUpdatesController iUpdatesController = singletonInstance;
        if (iUpdatesController != null && (eventManager = iUpdatesController.getEventManager()) != null) {
            eventManager.setObserver(observer);
        }
        IUpdatesController iUpdatesController2 = singletonInstance;
        if (iUpdatesController2 != null) {
            iUpdatesController2.onEventListenerStartObserving();
        }
    }

    public final void removeUpdatesEventManagerObserver$expo_updates_release() {
        IUpdatesEventManager eventManager;
        IUpdatesController iUpdatesController = singletonInstance;
        if (iUpdatesController == null || (eventManager = iUpdatesController.getEventManager()) == null) {
            return;
        }
        eventManager.setObserver(null);
    }
}
