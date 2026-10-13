package com.facebook.react.devsupport;

import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import com.facebook.react.devsupport.interfaces.DevLoadingViewManager;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DevSupportManagerBase.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J5\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010\u000bJ\u0014\u0010\f\u001a\u00020\u00032\n\u0010\r\u001a\u00060\u000ej\u0002`\u000fH\u0016¨\u0006\u0010"}, d2 = {"com/facebook/react/devsupport/DevSupportManagerBase$fetchSplitBundleAndCreateBundleLoader$1$1", "Lcom/facebook/react/devsupport/interfaces/DevBundleDownloadListener;", "onSuccess", "", "onProgress", "status", "", "done", "", "total", "percent", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "onFailure", "cause", "Ljava/lang/Exception;", "Lkotlin/Exception;", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DevSupportManagerBase$fetchSplitBundleAndCreateBundleLoader$1$1 implements DevBundleDownloadListener {
    final /* synthetic */ File $bundleFile;
    final /* synthetic */ String $bundleUrl;
    final /* synthetic */ DevSupportManagerBase.CallbackWithBundleLoader $callback;
    final /* synthetic */ DevSupportManagerBase this$0;

    DevSupportManagerBase$fetchSplitBundleAndCreateBundleLoader$1$1(DevSupportManagerBase devSupportManagerBase, String str, File file, DevSupportManagerBase.CallbackWithBundleLoader callbackWithBundleLoader) {
        this.this$0 = devSupportManagerBase;
        this.$bundleUrl = str;
        this.$bundleFile = file;
        this.$callback = callbackWithBundleLoader;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevBundleDownloadListener
    public void onSuccess() {
        final DevSupportManagerBase devSupportManagerBase = this.this$0;
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.devsupport.DevSupportManagerBase$fetchSplitBundleAndCreateBundleLoader$1$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                devSupportManagerBase.hideSplitBundleDevLoadingView();
            }
        });
        ReactContext currentReactContext = this.this$0.getCurrentReactContext();
        if (currentReactContext == null || !currentReactContext.hasActiveReactInstance()) {
            return;
        }
        JSBundleLoader.Companion companion = JSBundleLoader.INSTANCE;
        String str = this.$bundleUrl;
        String absolutePath = this.$bundleFile.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        this.$callback.onSuccess(companion.createCachedSplitBundleFromNetworkLoader(str, absolutePath));
    }

    @Override // com.facebook.react.devsupport.interfaces.DevBundleDownloadListener
    public void onProgress(String status, Integer done, Integer total, Integer percent) {
        DevLoadingViewManager devLoadingViewManager = this.this$0.getDevLoadingViewManager();
        if (devLoadingViewManager != null) {
            devLoadingViewManager.updateProgress(status, done, total, percent);
        }
    }

    @Override // com.facebook.react.devsupport.interfaces.DevBundleDownloadListener
    public void onFailure(Exception cause) {
        Intrinsics.checkNotNullParameter(cause, "cause");
        final DevSupportManagerBase devSupportManagerBase = this.this$0;
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.devsupport.DevSupportManagerBase$fetchSplitBundleAndCreateBundleLoader$1$1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                devSupportManagerBase.hideSplitBundleDevLoadingView();
            }
        });
        this.$callback.onError(this.$bundleUrl, cause);
    }
}
