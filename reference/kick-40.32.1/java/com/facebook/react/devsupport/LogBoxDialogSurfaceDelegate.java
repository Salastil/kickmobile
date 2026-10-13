package com.facebook.react.devsupport;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import com.datadog.android.webview.WebViewTracking;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.SurfaceDelegate;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.util.RNLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LogBoxDialogSurfaceDelegate.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/facebook/react/devsupport/LogBoxDialogSurfaceDelegate;", "Lcom/facebook/react/common/SurfaceDelegate;", "devSupportManager", "Lcom/facebook/react/devsupport/interfaces/DevSupportManager;", "<init>", "(Lcom/facebook/react/devsupport/interfaces/DevSupportManager;)V", "reactRootView", "Landroid/view/View;", "dialog", "Lcom/facebook/react/devsupport/LogBoxDialog;", "createContentView", "", "appKey", "", "isContentViewReady", "", "destroyContentView", WebViewTracking.SESSION_REPLAY_MASK_NONE_TOUCH_PRIVACY, WebViewTracking.SESSION_REPLAY_MASK_ALL_TOUCH_PRIVACY, "isShowing", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LogBoxDialogSurfaceDelegate implements SurfaceDelegate {
    private final DevSupportManager devSupportManager;
    private LogBoxDialog dialog;
    private View reactRootView;

    public LogBoxDialogSurfaceDelegate(DevSupportManager devSupportManager) {
        Intrinsics.checkNotNullParameter(devSupportManager, "devSupportManager");
        this.devSupportManager = devSupportManager;
    }

    @Override // com.facebook.react.common.SurfaceDelegate
    public void createContentView(String appKey) {
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        Assertions.assertCondition(Intrinsics.areEqual(appKey, "LogBox"), "This surface manager can only create LogBox React application");
        View viewCreateRootView = this.devSupportManager.createRootView("LogBox");
        this.reactRootView = viewCreateRootView;
        if (viewCreateRootView == null) {
            RNLog.e("Unable to launch logbox because react was unable to create the root view");
        }
    }

    @Override // com.facebook.react.common.SurfaceDelegate
    public boolean isContentViewReady() {
        return this.reactRootView != null;
    }

    @Override // com.facebook.react.common.SurfaceDelegate
    public void destroyContentView() {
        View view = this.reactRootView;
        if (view != null) {
            this.devSupportManager.destroyRootView(view);
            this.reactRootView = null;
        }
    }

    @Override // com.facebook.react.common.SurfaceDelegate
    public void show() {
        if (isShowing()) {
            return;
        }
        Activity currentActivity = this.devSupportManager.getCurrentActivity();
        if (currentActivity == null || currentActivity.isFinishing()) {
            RNLog.e("Unable to launch logbox because react activity is not available, here is the error that logbox would've displayed: ");
            return;
        }
        if (!isContentViewReady()) {
            createContentView("LogBox");
        }
        if (isContentViewReady()) {
            LogBoxDialog logBoxDialog = new LogBoxDialog(currentActivity, this.reactRootView);
            this.dialog = logBoxDialog;
            logBoxDialog.setCancelable(true);
            logBoxDialog.setCanceledOnTouchOutside(false);
            logBoxDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.facebook.react.devsupport.LogBoxDialogSurfaceDelegate$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    LogBoxDialogSurfaceDelegate.show$lambda$1$lambda$0(this.f$0, dialogInterface);
                }
            });
            logBoxDialog.show();
        }
    }

    static final void show$lambda$1$lambda$0(LogBoxDialogSurfaceDelegate logBoxDialogSurfaceDelegate, DialogInterface dialogInterface) {
        ReactContext currentReactContext = logBoxDialogSurfaceDelegate.devSupportManager.getCurrentReactContext();
        if (currentReactContext != null) {
            currentReactContext.emitDeviceEvent("hardwareBackPress");
        }
    }

    @Override // com.facebook.react.common.SurfaceDelegate
    public void hide() {
        LogBoxDialog logBoxDialog;
        if (isShowing() && (logBoxDialog = this.dialog) != null) {
            logBoxDialog.dismiss();
        }
        View view = this.reactRootView;
        ViewGroup viewGroup = (ViewGroup) (view != null ? view.getParent() : null);
        if (viewGroup != null) {
            viewGroup.removeView(this.reactRootView);
        }
        this.dialog = null;
        destroyContentView();
    }

    @Override // com.facebook.react.common.SurfaceDelegate
    public boolean isShowing() {
        LogBoxDialog logBoxDialog = this.dialog;
        if (logBoxDialog != null) {
            return logBoxDialog.isShowing();
        }
        return false;
    }
}
