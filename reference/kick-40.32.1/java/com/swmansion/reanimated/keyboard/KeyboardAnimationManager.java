package com.swmansion.reanimated.keyboard;

import com.facebook.react.bridge.ReactApplicationContext;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KeyboardAnimationManager.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\bJ\u0006\u0010\u0018\u001a\u00020\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/swmansion/reanimated/keyboard/KeyboardAnimationManager;", "", "reactContext", "Ljava/lang/ref/WeakReference;", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Ljava/lang/ref/WeakReference;)V", "mNextListenerId", "", "mListeners", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/swmansion/reanimated/keyboard/KeyboardWorkletWrapper;", "mKeyboard", "Lcom/swmansion/reanimated/keyboard/Keyboard;", "mWindowsInsetsManager", "Lcom/swmansion/reanimated/keyboard/WindowsInsetsManager;", "subscribeForKeyboardUpdates", "callback", "isStatusBarTranslucent", "", "isNavigationBarTranslucent", "unsubscribeFromKeyboardUpdates", "", "listenerId", "notifyAboutKeyboardChange", "react-native-reanimated_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class KeyboardAnimationManager {
    private final Keyboard mKeyboard;
    private final ConcurrentHashMap<Integer, KeyboardWorkletWrapper> mListeners;
    private int mNextListenerId;
    private final WindowsInsetsManager mWindowsInsetsManager;

    public KeyboardAnimationManager(WeakReference<ReactApplicationContext> reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.mListeners = new ConcurrentHashMap<>();
        Keyboard keyboard = new Keyboard();
        this.mKeyboard = keyboard;
        this.mWindowsInsetsManager = new WindowsInsetsManager(reactContext, keyboard, new KeyboardAnimationManager$mWindowsInsetsManager$1(this));
    }

    public final int subscribeForKeyboardUpdates(KeyboardWorkletWrapper callback, boolean isStatusBarTranslucent, boolean isNavigationBarTranslucent) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        int i = this.mNextListenerId;
        this.mNextListenerId = i + 1;
        if (this.mListeners.isEmpty()) {
            this.mWindowsInsetsManager.startObservingChanges(new KeyboardAnimationCallback(this.mKeyboard, new KeyboardAnimationManager$subscribeForKeyboardUpdates$keyboardAnimationCallback$1(this), isNavigationBarTranslucent), isStatusBarTranslucent, isNavigationBarTranslucent);
        }
        this.mListeners.put(Integer.valueOf(i), callback);
        return i;
    }

    public final void unsubscribeFromKeyboardUpdates(int listenerId) {
        this.mListeners.remove(Integer.valueOf(listenerId));
        if (this.mListeners.isEmpty()) {
            this.mWindowsInsetsManager.stopObservingChanges();
        }
    }

    public final void notifyAboutKeyboardChange() {
        for (KeyboardWorkletWrapper keyboardWorkletWrapper : this.mListeners.values()) {
            Intrinsics.checkNotNullExpressionValue(keyboardWorkletWrapper, "next(...)");
            keyboardWorkletWrapper.invoke(this.mKeyboard.getMState().getMValue(), this.mKeyboard.getMHeight());
        }
    }
}
