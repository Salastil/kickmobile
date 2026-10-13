package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* JADX INFO: loaded from: classes6.dex */
public interface RNCWebViewManagerInterface<T extends View> extends ViewManagerWithGeneratedInterface {
    void clearCache(T t, boolean z);

    void clearFormData(T t);

    void clearHistory(T t);

    void goBack(T t);

    void goForward(T t);

    void injectJavaScript(T t, String str);

    void loadUrl(T t, String str);

    void postMessage(T t, String str);

    void reload(T t);

    void requestFocus(T t);

    void setAllowFileAccess(T t, boolean z);

    void setAllowFileAccessFromFileURLs(T t, boolean z);

    void setAllowUniversalAccessFromFileURLs(T t, boolean z);

    void setAllowingReadAccessToURL(T t, String str);

    void setAllowsAirPlayForMediaPlayback(T t, boolean z);

    void setAllowsBackForwardNavigationGestures(T t, boolean z);

    void setAllowsFullscreenVideo(T t, boolean z);

    void setAllowsInlineMediaPlayback(T t, boolean z);

    void setAllowsLinkPreview(T t, boolean z);

    void setAllowsPictureInPictureMediaPlayback(T t, boolean z);

    void setAllowsProtectedMedia(T t, boolean z);

    void setAndroidLayerType(T t, String str);

    void setApplicationNameForUserAgent(T t, String str);

    void setAutoManageStatusBarEnabled(T t, boolean z);

    void setAutomaticallyAdjustContentInsets(T t, boolean z);

    void setBasicAuthCredential(T t, ReadableMap readableMap);

    void setBounces(T t, boolean z);

    void setCacheEnabled(T t, boolean z);

    void setCacheMode(T t, String str);

    void setContentInset(T t, ReadableMap readableMap);

    void setContentInsetAdjustmentBehavior(T t, String str);

    void setContentMode(T t, String str);

    void setDataDetectorTypes(T t, ReadableArray readableArray);

    void setDecelerationRate(T t, double d);

    void setDirectionalLockEnabled(T t, boolean z);

    void setDomStorageEnabled(T t, boolean z);

    void setDownloadingMessage(T t, String str);

    void setEnableApplePay(T t, boolean z);

    void setForceDarkOn(T t, boolean z);

    void setFraudulentWebsiteWarningEnabled(T t, boolean z);

    void setGeolocationEnabled(T t, boolean z);

    void setHasOnFileDownload(T t, boolean z);

    void setHasOnOpenWindowEvent(T t, boolean z);

    void setHasOnScroll(T t, boolean z);

    void setHideKeyboardAccessoryView(T t, boolean z);

    void setIncognito(T t, boolean z);

    void setIndicatorStyle(T t, String str);

    void setInjectedJavaScript(T t, String str);

    void setInjectedJavaScriptBeforeContentLoaded(T t, String str);

    void setInjectedJavaScriptBeforeContentLoadedForMainFrameOnly(T t, boolean z);

    void setInjectedJavaScriptForMainFrameOnly(T t, boolean z);

    void setInjectedJavaScriptObject(T t, String str);

    void setJavaScriptCanOpenWindowsAutomatically(T t, boolean z);

    void setJavaScriptEnabled(T t, boolean z);

    void setKeyboardDisplayRequiresUserAction(T t, boolean z);

    void setLackPermissionToDownloadMessage(T t, String str);

    void setLimitsNavigationsToAppBoundDomains(T t, boolean z);

    void setMediaCapturePermissionGrantType(T t, String str);

    void setMediaPlaybackRequiresUserAction(T t, boolean z);

    void setMenuItems(T t, ReadableArray readableArray);

    void setMessagingEnabled(T t, boolean z);

    void setMessagingModuleName(T t, String str);

    void setMinimumFontSize(T t, int i);

    void setMixedContentMode(T t, String str);

    void setNestedScrollEnabled(T t, boolean z);

    void setNewSource(T t, ReadableMap readableMap);

    void setOverScrollMode(T t, String str);

    void setPagingEnabled(T t, boolean z);

    void setPaymentRequestEnabled(T t, boolean z);

    void setPullToRefreshEnabled(T t, boolean z);

    void setRefreshControlLightMode(T t, boolean z);

    void setRemoveIosKeyboardObserver(T t, boolean z);

    void setSaveFormDataDisabled(T t, boolean z);

    void setScalesPageToFit(T t, boolean z);

    void setScrollEnabled(T t, boolean z);

    void setSetBuiltInZoomControls(T t, boolean z);

    void setSetDisplayZoomControls(T t, boolean z);

    void setSetSupportMultipleWindows(T t, boolean z);

    void setSharedCookiesEnabled(T t, boolean z);

    void setShowsHorizontalScrollIndicator(T t, boolean z);

    void setShowsVerticalScrollIndicator(T t, boolean z);

    void setSuppressMenuItems(T t, ReadableArray readableArray);

    void setTextInteractionEnabled(T t, boolean z);

    void setTextZoom(T t, int i);

    void setThirdPartyCookiesEnabled(T t, boolean z);

    void setUseSharedProcessPool(T t, boolean z);

    void setUserAgent(T t, String str);

    void setWebviewDebuggingEnabled(T t, boolean z);

    void stopLoading(T t);
}
