package com.facebook.react.uimanager;

import android.view.KeyEvent;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.KeyDownEvent;
import com.facebook.react.uimanager.events.KeyUpEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JSKeyDispatcher.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005J\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0005J\u0006\u0010\u000f\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/facebook/react/uimanager/JSKeyDispatcher;", "", "<init>", "()V", "focusedViewTag", "", "handleKeyEvent", "", "keyEvent", "Landroid/view/KeyEvent;", "eventDispatcher", "Lcom/facebook/react/uimanager/events/EventDispatcher;", "surfaceId", "setFocusedView", "viewTag", "clearFocus", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class JSKeyDispatcher {
    private int focusedViewTag = -1;

    public final void handleKeyEvent(KeyEvent keyEvent, EventDispatcher eventDispatcher, int surfaceId) {
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        Intrinsics.checkNotNullParameter(eventDispatcher, "eventDispatcher");
        if (this.focusedViewTag == -1) {
            return;
        }
        int action = keyEvent.getAction();
        if (action == 0) {
            eventDispatcher.dispatchEvent(new KeyDownEvent(surfaceId, this.focusedViewTag, keyEvent));
        } else {
            if (action != 1) {
                return;
            }
            eventDispatcher.dispatchEvent(new KeyUpEvent(surfaceId, this.focusedViewTag, keyEvent));
        }
    }

    public final void setFocusedView(int viewTag) {
        this.focusedViewTag = viewTag;
    }

    public final void clearFocus() {
        this.focusedViewTag = -1;
    }
}
