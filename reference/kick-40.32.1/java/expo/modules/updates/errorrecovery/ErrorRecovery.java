package expo.modules.updates.errorrecovery;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import expo.modules.notifications.service.NotificationsService;
import expo.modules.updates.logging.UpdatesErrorCode;
import expo.modules.updates.logging.UpdatesLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ErrorRecovery.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018J\u0019\u0010\u0019\u001a\u00020\u00132\n\u0010\u001a\u001a\u00060\u001bj\u0002`\u001cH\u0000¢\u0006\u0002\b\u001dJ\u000e\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020 J\u0019\u0010!\u001a\u00020\u00132\n\u0010\u001a\u001a\u00060\u001bj\u0002`\u001cH\u0000¢\u0006\u0002\b\"J\r\u0010#\u001a\u00020\u0013H\u0000¢\u0006\u0002\b$J\b\u0010'\u001a\u00020\u0013H\u0002J\b\u0010(\u001a\u00020\u0013H\u0002J\u0010\u0010)\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010*\u001a\u00020\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lexpo/modules/updates/errorrecovery/ErrorRecovery;", "", "logger", "Lexpo/modules/updates/logging/UpdatesLogger;", "<init>", "(Lexpo/modules/updates/logging/UpdatesLogger;)V", "handlerThread", "Landroid/os/HandlerThread;", "getHandlerThread$expo_updates_release", "()Landroid/os/HandlerThread;", "handler", "Landroid/os/Handler;", "getHandler$expo_updates_release", "()Landroid/os/Handler;", "setHandler$expo_updates_release", "(Landroid/os/Handler;)V", "shouldHandleReactInstanceException", "", "initialize", "", "delegate", "Lexpo/modules/updates/errorrecovery/ErrorRecoveryDelegate;", "startMonitoring", "devSupportManager", "Lcom/facebook/react/devsupport/interfaces/DevSupportManager;", "onReactInstanceException", NotificationsService.EXCEPTION_KEY, "Ljava/lang/Exception;", "Lkotlin/Exception;", "onReactInstanceException$expo_updates_release", "notifyNewRemoteLoadStatus", "newStatus", "Lexpo/modules/updates/errorrecovery/ErrorRecoveryDelegate$RemoteLoadStatus;", "handleException", "handleException$expo_updates_release", "handleContentAppeared", "handleContentAppeared$expo_updates_release", "contentAppearedListener", "Lcom/facebook/react/bridge/ReactMarker$MarkerListener;", "registerContentAppearedListener", "unregisterContentAppearedListener", "registerErrorHandler", "unregisterErrorHandler", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ErrorRecovery {
    private final ReactMarker.MarkerListener contentAppearedListener;
    public Handler handler;
    private final HandlerThread handlerThread;
    private final UpdatesLogger logger;
    private boolean shouldHandleReactInstanceException;

    public ErrorRecovery(UpdatesLogger logger) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.logger = logger;
        this.handlerThread = new HandlerThread("expo-updates-error-recovery");
        this.contentAppearedListener = new ReactMarker.MarkerListener() { // from class: expo.modules.updates.errorrecovery.ErrorRecovery$$ExternalSyntheticLambda0
            @Override // com.facebook.react.bridge.ReactMarker.MarkerListener
            public final void logMarker(ReactMarkerConstants reactMarkerConstants, String str, int i) {
                ErrorRecovery.contentAppearedListener$lambda$0(this.f$0, reactMarkerConstants, str, i);
            }
        };
    }

    /* JADX INFO: renamed from: getHandlerThread$expo_updates_release, reason: from getter */
    public final HandlerThread getHandlerThread() {
        return this.handlerThread;
    }

    public final Handler getHandler$expo_updates_release() {
        Handler handler = this.handler;
        if (handler != null) {
            return handler;
        }
        Intrinsics.throwUninitializedPropertyAccessException("handler");
        return null;
    }

    public final void setHandler$expo_updates_release(Handler handler) {
        Intrinsics.checkNotNullParameter(handler, "<set-?>");
        this.handler = handler;
    }

    public final void initialize(ErrorRecoveryDelegate delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        if (this.handler == null) {
            this.handlerThread.start();
            Looper looper = this.handlerThread.getLooper();
            Intrinsics.checkNotNullExpressionValue(looper, "getLooper(...)");
            setHandler$expo_updates_release(new ErrorRecoveryHandler(looper, delegate, this.logger));
        }
    }

    public final void startMonitoring(DevSupportManager devSupportManager) {
        Intrinsics.checkNotNullParameter(devSupportManager, "devSupportManager");
        registerContentAppearedListener();
        registerErrorHandler(devSupportManager);
    }

    public final void onReactInstanceException$expo_updates_release(Exception exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        if (this.shouldHandleReactInstanceException) {
            handleException$expo_updates_release(exception);
        }
    }

    public final void notifyNewRemoteLoadStatus(ErrorRecoveryDelegate.RemoteLoadStatus newStatus) {
        Intrinsics.checkNotNullParameter(newStatus, "newStatus");
        UpdatesLogger.info$default(this.logger, "ErrorRecovery: remote load status changed: " + newStatus, null, 2, null);
        getHandler$expo_updates_release().sendMessage(getHandler$expo_updates_release().obtainMessage(2, newStatus));
    }

    public final void handleException$expo_updates_release(Exception exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        this.logger.error("ErrorRecovery: exception encountered: " + exception.getLocalizedMessage(), exception, UpdatesErrorCode.Unknown);
        getHandler$expo_updates_release().sendMessage(getHandler$expo_updates_release().obtainMessage(0, exception));
    }

    public final void handleContentAppeared$expo_updates_release() {
        getHandler$expo_updates_release().sendMessage(getHandler$expo_updates_release().obtainMessage(1));
        unregisterContentAppearedListener();
        getHandler$expo_updates_release().postDelayed(new Runnable() { // from class: expo.modules.updates.errorrecovery.ErrorRecovery$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.unregisterErrorHandler();
            }
        }, 10000L);
    }

    static final void contentAppearedListener$lambda$0(ErrorRecovery errorRecovery, ReactMarkerConstants name, String str, int i) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (name == ReactMarkerConstants.CONTENT_APPEARED) {
            errorRecovery.handleContentAppeared$expo_updates_release();
        }
    }

    private final void registerContentAppearedListener() {
        ReactMarker.addListener(this.contentAppearedListener);
    }

    private final void unregisterContentAppearedListener() {
        ReactMarker.removeListener(this.contentAppearedListener);
    }

    private final void registerErrorHandler(DevSupportManager devSupportManager) {
        this.shouldHandleReactInstanceException = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void unregisterErrorHandler() {
        this.shouldHandleReactInstanceException = false;
    }
}
