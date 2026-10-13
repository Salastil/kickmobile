package com.facebook.react.animated;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.UnexpectedNativeTypeException;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTModernEventEmitter;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EventAnimationDriver.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJB\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0005H\u0017R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/facebook/react/animated/EventAnimationDriver;", "Lcom/facebook/react/uimanager/events/RCTModernEventEmitter;", "eventName", "", "viewTag", "", "eventPath", "", "valueNode", "Lcom/facebook/react/animated/ValueAnimatedNode;", "<init>", "(Ljava/lang/String;ILjava/util/List;Lcom/facebook/react/animated/ValueAnimatedNode;)V", "receiveEvent", "", "surfaceId", "targetTag", "canCoalesceEvent", "", "customCoalesceKey", "params", "Lcom/facebook/react/bridge/WritableMap;", "category", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class EventAnimationDriver implements RCTModernEventEmitter {
    public String eventName;
    private final List<String> eventPath;
    public ValueAnimatedNode valueNode;
    public int viewTag;

    public EventAnimationDriver(String eventName, int i, List<String> eventPath, ValueAnimatedNode valueNode) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(eventPath, "eventPath");
        Intrinsics.checkNotNullParameter(valueNode, "valueNode");
        this.eventName = eventName;
        this.viewTag = i;
        this.eventPath = eventPath;
        this.valueNode = valueNode;
    }

    @Override // com.facebook.react.uimanager.events.RCTModernEventEmitter
    @Deprecated(message = "Use the overload with eventTimestamp parameter instead.")
    public void receiveEvent(int surfaceId, int targetTag, String eventName, boolean canCoalesceEvent, int customCoalesceKey, WritableMap params, int category) {
        ReadableMap map;
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        if (params == null) {
            throw new IllegalArgumentException("Native animated events must have event data.".toString());
        }
        WritableMap writableMap = params;
        int size = this.eventPath.size() - 1;
        ReadableArray array = null;
        for (int i = 0; i < size; i++) {
            List<String> list = this.eventPath;
            if (writableMap != null) {
                String str = list.get(i);
                ReadableType type = writableMap.getType(str);
                if (type == ReadableType.Map) {
                    map = writableMap.getMap(str);
                    writableMap = map;
                    array = null;
                } else {
                    if (type != ReadableType.Array) {
                        throw new UnexpectedNativeTypeException("Unexpected type " + type + " for key '" + str + "'");
                    }
                    array = writableMap.getArray(str);
                    writableMap = null;
                }
            } else {
                int i2 = Integer.parseInt(list.get(i));
                ReadableType type2 = array != null ? array.getType(i2) : null;
                if (type2 == ReadableType.Map) {
                    map = array.getMap(i2);
                    writableMap = map;
                    array = null;
                } else {
                    if (type2 != ReadableType.Array) {
                        throw new UnexpectedNativeTypeException("Unexpected type " + type2 + " for index '" + i2 + "'");
                    }
                    array = array.getArray(i2);
                    writableMap = null;
                }
            }
        }
        List<String> list2 = this.eventPath;
        String str2 = list2.get(list2.size() - 1);
        if (writableMap != null) {
            this.valueNode.nodeValue = writableMap.getDouble(str2);
            return;
        }
        this.valueNode.nodeValue = array != null ? array.getDouble(Integer.parseInt(str2)) : 0.0d;
    }
}
