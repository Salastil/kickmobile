package com.facebook.react.devsupport.interfaces;

import com.datadog.android.webview.WebViewTracking;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;

/* JADX INFO: compiled from: DevLoadingViewManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J3\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH&¢\u0006\u0002\u0010\u000bJ5\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000fH&¢\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0001"}, d2 = {"Lcom/facebook/react/devsupport/interfaces/DevLoadingViewManager;", "", "showMessage", "", "message", "", "color", "", ViewProps.BACKGROUND_COLOR, "dismissButton", "", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Boolean;)V", "updateProgress", "status", "done", "", "total", "percent", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", WebViewTracking.SESSION_REPLAY_MASK_ALL_TOUCH_PRIVACY, "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface DevLoadingViewManager {
    void hide();

    void showMessage(String message);

    void showMessage(String message, Double color, Double backgroundColor, Boolean dismissButton);

    void updateProgress(String status, Integer done, Integer total, Integer percent);
}
