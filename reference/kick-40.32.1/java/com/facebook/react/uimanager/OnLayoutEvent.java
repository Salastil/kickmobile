package com.facebook.react.uimanager;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.util.Pools;
import androidx.window.reflection.WindowExtensionsConstants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableMapBuilder;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.common.annotations.internal.LegacyArchitectureLogLevel;
import com.facebook.react.common.annotations.internal.LegacyArchitectureLogger;
import com.facebook.react.uimanager.events.Event;
import com.mux.stats.sdk.core.model.ViewDeviceOrientationData;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: OnLayoutEvent.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001 B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0017\u001a\u00020\u0018H\u0016J8\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0004J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0014R$\u0010\u0004\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR$\u0010\u000f\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\b\"\u0004\b\u0012\u0010\nR$\u0010\u0013\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\n¨\u0006!"}, d2 = {"Lcom/facebook/react/uimanager/OnLayoutEvent;", "Lcom/facebook/react/uimanager/events/Event;", "<init>", "()V", ViewDeviceOrientationData.DEVICE_ORIENTATION_X, "", "getX$ReactAndroid$annotations", "getX$ReactAndroid", "()I", "setX$ReactAndroid", "(I)V", ViewDeviceOrientationData.DEVICE_ORIENTATION_Y, "getY$ReactAndroid$annotations", "getY$ReactAndroid", "setY$ReactAndroid", ViewProps.WIDTH, "getWidth$ReactAndroid$annotations", "getWidth$ReactAndroid", "setWidth$ReactAndroid", ViewProps.HEIGHT, "getHeight$ReactAndroid$annotations", "getHeight$ReactAndroid", "setHeight$ReactAndroid", "onDispose", "", "init", "surfaceId", "viewTag", "getEventName", "", "getEventData", "Lcom/facebook/react/bridge/WritableMap;", "Companion", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.WARNING, message = "This class is part of Legacy Architecture and will be removed in a future release")
public final class OnLayoutEvent extends Event<OnLayoutEvent> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Pools.SynchronizedPool<OnLayoutEvent> EVENTS_POOL;
    private int height;
    private int width;
    private int x;
    private int y;

    public /* synthetic */ OnLayoutEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @VisibleForTesting
    public static /* synthetic */ void getHeight$ReactAndroid$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getWidth$ReactAndroid$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getX$ReactAndroid$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getY$ReactAndroid$annotations() {
    }

    @Deprecated(message = "Use `obtain(surfaceId, viewTag, x, y, width, height)` instead.", replaceWith = @ReplaceWith(expression = "obtain(surfaceId, viewTag, x, y, width, height)", imports = {}))
    @JvmStatic
    public static final OnLayoutEvent obtain(int i, int i2, int i3, int i4, int i5) {
        return INSTANCE.obtain(i, i2, i3, i4, i5);
    }

    @JvmStatic
    public static final OnLayoutEvent obtain(int i, int i2, int i3, int i4, int i5, int i6) {
        return INSTANCE.obtain(i, i2, i3, i4, i5, i6);
    }

    private OnLayoutEvent() {
    }

    /* JADX INFO: renamed from: getX$ReactAndroid, reason: from getter */
    public final int getX() {
        return this.x;
    }

    public final void setX$ReactAndroid(int i) {
        this.x = i;
    }

    /* JADX INFO: renamed from: getY$ReactAndroid, reason: from getter */
    public final int getY() {
        return this.y;
    }

    public final void setY$ReactAndroid(int i) {
        this.y = i;
    }

    /* JADX INFO: renamed from: getWidth$ReactAndroid, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    public final void setWidth$ReactAndroid(int i) {
        this.width = i;
    }

    /* JADX INFO: renamed from: getHeight$ReactAndroid, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    public final void setHeight$ReactAndroid(int i) {
        this.height = i;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public void onDispose() {
        EVENTS_POOL.release(this);
    }

    protected final void init(int surfaceId, int viewTag, int x, int y, int width, int height) {
        super.init(surfaceId, viewTag);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override // com.facebook.react.uimanager.events.Event
    /* JADX INFO: renamed from: getEventName */
    public String getName() {
        return "topLayout";
    }

    /* JADX INFO: compiled from: OnLayoutEvent.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0007J8\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0007R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/facebook/react/uimanager/OnLayoutEvent$Companion;", "", "<init>", "()V", "EVENTS_POOL", "Landroidx/core/util/Pools$SynchronizedPool;", "Lcom/facebook/react/uimanager/OnLayoutEvent;", "obtain", "viewTag", "", ViewDeviceOrientationData.DEVICE_ORIENTATION_X, ViewDeviceOrientationData.DEVICE_ORIENTATION_Y, ViewProps.WIDTH, ViewProps.HEIGHT, "surfaceId", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Deprecated(message = "Use `obtain(surfaceId, viewTag, x, y, width, height)` instead.", replaceWith = @ReplaceWith(expression = "obtain(surfaceId, viewTag, x, y, width, height)", imports = {}))
        @JvmStatic
        public final OnLayoutEvent obtain(int viewTag, int x, int y, int width, int height) {
            return obtain(-1, viewTag, x, y, width, height);
        }

        @JvmStatic
        public final OnLayoutEvent obtain(int surfaceId, int viewTag, int x, int y, int width, int height) {
            OnLayoutEvent onLayoutEvent = (OnLayoutEvent) OnLayoutEvent.EVENTS_POOL.acquire();
            if (onLayoutEvent == null) {
                onLayoutEvent = new OnLayoutEvent(null);
            }
            OnLayoutEvent onLayoutEvent2 = onLayoutEvent;
            onLayoutEvent2.init(surfaceId, viewTag, x, y, width, height);
            return onLayoutEvent2;
        }
    }

    static {
        LegacyArchitectureLogger.assertLegacyArchitecture("OnLayoutEvent", LegacyArchitectureLogLevel.WARNING);
        EVENTS_POOL = new Pools.SynchronizedPool<>(20);
    }

    @Override // com.facebook.react.uimanager.events.Event
    /* JADX INFO: renamed from: getEventData */
    protected WritableMap getAccessibilityEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        ReadableMapBuilder readableMapBuilder = new ReadableMapBuilder(writableMapCreateMap);
        readableMapBuilder.put(ViewDeviceOrientationData.DEVICE_ORIENTATION_X, PixelUtil.toDIPFromPixel(this.x));
        readableMapBuilder.put(ViewDeviceOrientationData.DEVICE_ORIENTATION_Y, PixelUtil.toDIPFromPixel(this.y));
        readableMapBuilder.put(ViewProps.WIDTH, PixelUtil.toDIPFromPixel(this.width));
        readableMapBuilder.put(ViewProps.HEIGHT, PixelUtil.toDIPFromPixel(this.height));
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        writableMapCreateMap2.putMap(WindowExtensionsConstants.LAYOUT_PACKAGE, writableMapCreateMap);
        writableMapCreateMap2.putInt(TypedValues.Attributes.S_TARGET, getViewTag());
        return writableMapCreateMap2;
    }
}
