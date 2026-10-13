package com.facebook.react.uimanager.events;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KeyDownEvent.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\f"}, d2 = {"Lcom/facebook/react/uimanager/events/KeyDownEvent;", "Lcom/facebook/react/uimanager/events/KeyEvent;", "surfaceId", "", "viewTag", "keyEvent", "Landroid/view/KeyEvent;", "<init>", "(IILandroid/view/KeyEvent;)V", "getEventName", "", "Companion", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class KeyDownEvent extends KeyEvent {
    private static final String EVENT_NAME = "topKeyDown";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KeyDownEvent(int i, int i2, android.view.KeyEvent keyEvent) {
        super(i, i2, keyEvent);
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
    }

    @Override // com.facebook.react.uimanager.events.Event
    /* JADX INFO: renamed from: getEventName */
    public String getName() {
        return EVENT_NAME;
    }
}
