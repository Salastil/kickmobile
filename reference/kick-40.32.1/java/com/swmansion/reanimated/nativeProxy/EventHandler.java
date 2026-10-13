package com.swmansion.reanimated.nativeProxy;

import com.facebook.jni.HybridData;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.RCTModernEventEmitter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EventHandler.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0013\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0014\u001a\u00020\u000fH\u0002JB\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u00182\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u0018H\u0016J*\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\"\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J \u0010!\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#H\u0016J+\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u00182\b\u0010&\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0014\u001a\u00020\u000fH\u0086 R\u0010\u0010\u0006\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006'"}, d2 = {"Lcom/swmansion/reanimated/nativeProxy/EventHandler;", "Lcom/facebook/react/uimanager/events/RCTModernEventEmitter;", "hybridData", "Lcom/facebook/jni/HybridData;", "<init>", "(Lcom/facebook/jni/HybridData;)V", "mHybridData", "mCustomEventNamesResolver", "Lcom/facebook/react/uimanager/UIManagerModule$CustomEventNamesResolver;", "getMCustomEventNamesResolver", "()Lcom/facebook/react/uimanager/UIManagerModule$CustomEventNamesResolver;", "setMCustomEventNamesResolver", "(Lcom/facebook/react/uimanager/UIManagerModule$CustomEventNamesResolver;)V", "isInDrawPassProvider", "Lkotlin/Function0;", "", "isInDrawPassProvider$react_native_reanimated_release", "()Lkotlin/jvm/functions/Function0;", "setInDrawPassProvider$react_native_reanimated_release", "(Lkotlin/jvm/functions/Function0;)V", "isInDrawPass", "receiveEvent", "", "surfaceId", "", "targetTag", "eventName", "", "canCoalesceEvent", "customCoalesceKey", "params", "Lcom/facebook/react/bridge/WritableMap;", "category", "receiveTouches", "touches", "Lcom/facebook/react/bridge/WritableArray;", "changedIndices", "emitterReactTag", "event", "react-native-reanimated_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class EventHandler implements RCTModernEventEmitter {
    private Function0<Boolean> isInDrawPassProvider;
    private UIManagerModule.CustomEventNamesResolver mCustomEventNamesResolver;
    private final HybridData mHybridData;

    public final native void receiveEvent(String eventName, int emitterReactTag, WritableMap event, boolean isInDrawPass);

    @Override // com.facebook.react.uimanager.events.RCTEventEmitter
    public void receiveTouches(String eventName, WritableArray touches, WritableArray changedIndices) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(touches, "touches");
        Intrinsics.checkNotNullParameter(changedIndices, "changedIndices");
    }

    @Override // com.facebook.react.uimanager.events.RCTModernEventEmitter
    public /* bridge */ void receiveEvent(int i, int i2, String str, boolean z, int i3, WritableMap writableMap, int i4, long j) {
        super.receiveEvent(i, i2, str, z, i3, writableMap, i4, j);
    }

    public final UIManagerModule.CustomEventNamesResolver getMCustomEventNamesResolver() {
        return this.mCustomEventNamesResolver;
    }

    public final void setMCustomEventNamesResolver(UIManagerModule.CustomEventNamesResolver customEventNamesResolver) {
        this.mCustomEventNamesResolver = customEventNamesResolver;
    }

    public final Function0<Boolean> isInDrawPassProvider$react_native_reanimated_release() {
        return this.isInDrawPassProvider;
    }

    public final void setInDrawPassProvider$react_native_reanimated_release(Function0<Boolean> function0) {
        this.isInDrawPassProvider = function0;
    }

    private EventHandler(HybridData hybridData) {
        this.mHybridData = hybridData;
    }

    private final boolean isInDrawPass() {
        Function0<Boolean> function0 = this.isInDrawPassProvider;
        return function0 != null && function0.invoke().booleanValue();
    }

    @Override // com.facebook.react.uimanager.events.RCTModernEventEmitter
    public void receiveEvent(int surfaceId, int targetTag, String eventName, boolean canCoalesceEvent, int customCoalesceKey, WritableMap params, int category) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        UIManagerModule.CustomEventNamesResolver customEventNamesResolver = this.mCustomEventNamesResolver;
        Intrinsics.checkNotNull(customEventNamesResolver);
        String strResolveCustomEventName = customEventNamesResolver.resolveCustomEventName(eventName);
        if (strResolveCustomEventName != null) {
            eventName = strResolveCustomEventName;
        }
        receiveEvent(eventName, targetTag, params, isInDrawPass());
    }

    @Override // com.facebook.react.uimanager.events.RCTModernEventEmitter
    public void receiveEvent(int surfaceId, int targetTag, String eventName, WritableMap params) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        UIManagerModule.CustomEventNamesResolver customEventNamesResolver = this.mCustomEventNamesResolver;
        Intrinsics.checkNotNull(customEventNamesResolver);
        String strResolveCustomEventName = customEventNamesResolver.resolveCustomEventName(eventName);
        if (strResolveCustomEventName != null) {
            eventName = strResolveCustomEventName;
        }
        receiveEvent(eventName, targetTag, params, isInDrawPass());
    }

    @Override // com.facebook.react.uimanager.events.RCTModernEventEmitter, com.facebook.react.uimanager.events.RCTEventEmitter
    public void receiveEvent(int targetTag, String eventName, WritableMap params) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        UIManagerModule.CustomEventNamesResolver customEventNamesResolver = this.mCustomEventNamesResolver;
        Intrinsics.checkNotNull(customEventNamesResolver);
        String strResolveCustomEventName = customEventNamesResolver.resolveCustomEventName(eventName);
        if (strResolveCustomEventName != null) {
            eventName = strResolveCustomEventName;
        }
        receiveEvent(eventName, targetTag, params, isInDrawPass());
    }
}
