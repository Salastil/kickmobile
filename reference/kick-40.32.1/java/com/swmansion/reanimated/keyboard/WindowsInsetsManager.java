package com.swmansion.reanimated.keyboard;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.R;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewProps;
import com.swmansion.reanimated.pseudoSelectors.ExtraWindowObserverBridge;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WindowsInsetsManager.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u001e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\fJ\u0006\u0010\u0018\u001a\u00020\u0013J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\fH\u0002J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001cH\u0002J\u0010\u0010 \u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u001cH\u0002J\u0018\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#H\u0002J\u0018\u0010%\u001a\u00020&2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#H\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082D¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/swmansion/reanimated/keyboard/WindowsInsetsManager;", "", "mReactContext", "Ljava/lang/ref/WeakReference;", "Lcom/facebook/react/bridge/ReactApplicationContext;", "mKeyboard", "Lcom/swmansion/reanimated/keyboard/Keyboard;", "mNotifyAboutKeyboardChange", "Lcom/swmansion/reanimated/keyboard/NotifyAboutKeyboardChangeFunction;", "<init>", "(Ljava/lang/ref/WeakReference;Lcom/swmansion/reanimated/keyboard/Keyboard;Lcom/swmansion/reanimated/keyboard/NotifyAboutKeyboardChangeFunction;)V", "mIsStatusBarTranslucent", "", "mIsNavigationBarTranslucent", "missingContextErrorMsg", "", "getCurrentActivity", "Landroid/app/Activity;", "startObservingChanges", "", "keyboardAnimationCallback", "Lcom/swmansion/reanimated/keyboard/KeyboardAnimationCallback;", "isStatusBarTranslucent", "isNavigationBarTranslucent", "stopObservingChanges", "updateWindowDecor", "decorFitsSystemWindow", "onApplyWindowInsetsListener", "Landroidx/core/view/WindowInsetsCompat;", "view", "Landroid/view/View;", "insets", "setWindowInsets", "updateInsets", ViewProps.PADDING_TOP, "", ViewProps.PADDING_BOTTOM, "getLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "react-native-reanimated_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class WindowsInsetsManager {
    private boolean mIsNavigationBarTranslucent;
    private boolean mIsStatusBarTranslucent;
    private final Keyboard mKeyboard;
    private final NotifyAboutKeyboardChangeFunction mNotifyAboutKeyboardChange;
    private final WeakReference<ReactApplicationContext> mReactContext;
    private final String missingContextErrorMsg;

    public WindowsInsetsManager(WeakReference<ReactApplicationContext> mReactContext, Keyboard mKeyboard, NotifyAboutKeyboardChangeFunction mNotifyAboutKeyboardChange) {
        Intrinsics.checkNotNullParameter(mReactContext, "mReactContext");
        Intrinsics.checkNotNullParameter(mKeyboard, "mKeyboard");
        Intrinsics.checkNotNullParameter(mNotifyAboutKeyboardChange, "mNotifyAboutKeyboardChange");
        this.mReactContext = mReactContext;
        this.mKeyboard = mKeyboard;
        this.mNotifyAboutKeyboardChange = mNotifyAboutKeyboardChange;
        this.missingContextErrorMsg = "Unable to get reference to react activity";
    }

    private final Activity getCurrentActivity() {
        ReactApplicationContext reactApplicationContext = this.mReactContext.get();
        if (reactApplicationContext != null) {
            return reactApplicationContext.getCurrentActivity();
        }
        return null;
    }

    public final void startObservingChanges(KeyboardAnimationCallback keyboardAnimationCallback, boolean isStatusBarTranslucent, boolean isNavigationBarTranslucent) {
        Intrinsics.checkNotNullParameter(keyboardAnimationCallback, "keyboardAnimationCallback");
        this.mIsStatusBarTranslucent = isStatusBarTranslucent;
        this.mIsNavigationBarTranslucent = isNavigationBarTranslucent;
        updateWindowDecor(false);
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            Log.e(ExtraWindowObserverBridge.TAG, this.missingContextErrorMsg);
            return;
        }
        View decorView = currentActivity.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
        ViewCompat.setOnApplyWindowInsetsListener(decorView, new OnApplyWindowInsetsListener() { // from class: com.swmansion.reanimated.keyboard.WindowsInsetsManager$$ExternalSyntheticLambda0
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return this.f$0.onApplyWindowInsetsListener(view, windowInsetsCompat);
            }
        });
        ViewCompat.setWindowInsetsAnimationCallback(decorView, keyboardAnimationCallback);
    }

    public final void stopObservingChanges() {
        updateWindowDecor((this.mIsStatusBarTranslucent || this.mIsNavigationBarTranslucent) ? false : true);
        updateInsets(0, 0);
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            Log.e(ExtraWindowObserverBridge.TAG, this.missingContextErrorMsg);
            return;
        }
        View decorView = currentActivity.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
        ViewCompat.setWindowInsetsAnimationCallback(decorView, null);
        ViewCompat.setOnApplyWindowInsetsListener(decorView, null);
    }

    private final void updateWindowDecor(final boolean decorFitsSystemWindow) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.swmansion.reanimated.keyboard.WindowsInsetsManager$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                WindowsInsetsManager.updateWindowDecor$lambda$0(this.f$0, decorFitsSystemWindow);
            }
        });
    }

    static final void updateWindowDecor$lambda$0(WindowsInsetsManager windowsInsetsManager, boolean z) {
        Activity currentActivity = windowsInsetsManager.getCurrentActivity();
        if (currentActivity == null) {
            Log.e(ExtraWindowObserverBridge.TAG, windowsInsetsManager.missingContextErrorMsg);
        } else {
            WindowCompat.setDecorFitsSystemWindows(currentActivity.getWindow(), z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WindowInsetsCompat onApplyWindowInsetsListener(View view, WindowInsetsCompat insets) {
        WindowInsetsCompat windowInsetsCompatOnApplyWindowInsets = ViewCompat.onApplyWindowInsets(view, insets);
        Intrinsics.checkNotNullExpressionValue(windowInsetsCompatOnApplyWindowInsets, "onApplyWindowInsets(...)");
        if (this.mKeyboard.getMState() == KeyboardState.OPEN) {
            this.mKeyboard.updateHeight(insets, this.mIsNavigationBarTranslucent);
            this.mNotifyAboutKeyboardChange.call();
        }
        setWindowInsets(windowInsetsCompatOnApplyWindowInsets);
        return windowInsetsCompatOnApplyWindowInsets;
    }

    private final void setWindowInsets(WindowInsetsCompat insets) {
        int iSystemBars = WindowInsetsCompat.Type.systemBars();
        updateInsets(insets.getInsets(iSystemBars).top, insets.getInsets(iSystemBars).bottom);
    }

    private final void updateInsets(final int paddingTop, final int paddingBottom) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.swmansion.reanimated.keyboard.WindowsInsetsManager$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                WindowsInsetsManager.updateInsets$lambda$0(this.f$0, paddingTop, paddingBottom);
            }
        });
    }

    static final void updateInsets$lambda$0(WindowsInsetsManager windowsInsetsManager, int i, int i2) {
        FrameLayout.LayoutParams layoutParams = windowsInsetsManager.getLayoutParams(i, i2);
        int i3 = R.id.action_bar_root;
        Activity currentActivity = windowsInsetsManager.getCurrentActivity();
        if (currentActivity == null) {
            Log.e(ExtraWindowObserverBridge.TAG, windowsInsetsManager.missingContextErrorMsg);
        } else {
            currentActivity.getWindow().getDecorView().findViewById(i3).setLayoutParams(layoutParams);
        }
    }

    private final FrameLayout.LayoutParams getLayoutParams(int paddingTop, int paddingBottom) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (this.mIsStatusBarTranslucent) {
            paddingTop = 0;
        }
        if (this.mIsNavigationBarTranslucent) {
            paddingBottom = 0;
        }
        layoutParams.setMargins(0, paddingTop, 0, paddingBottom);
        return layoutParams;
    }
}
