package com.swmansion.rnscreens.gamma.stack.screen;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.datadog.android.webview.internal.rum.WebViewRumEventMapper;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mux.stats.sdk.core.model.ViewDeviceOrientationData;
import com.swmansion.rnscreens.ext.ViewExtKt;
import com.swmansion.rnscreens.gamma.common.FragmentProviding;
import com.swmansion.rnscreens.gamma.common.ShadowStateProxy;
import com.swmansion.rnscreens.gamma.common.container.Container;
import com.swmansion.rnscreens.gamma.common.container.ContainerItem;
import com.swmansion.rnscreens.gamma.common.container.ContainerItemSupport;
import com.swmansion.rnscreens.gamma.scrollviewmarker.ScrollViewMarker;
import com.swmansion.rnscreens.gamma.scrollviewmarker.ScrollViewSeeking;
import com.swmansion.rnscreens.gamma.stack.header.config.OnHeaderConfigurationAttachListener;
import com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfig;
import com.swmansion.rnscreens.gamma.stack.host.StackHost;
import com.swmansion.rnscreens.gamma.stack.screen.event.StackScreenDismissEvent;
import com.swmansion.rnscreens.gamma.stack.screen.event.StackScreenNativeDismissPreventedEvent;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: StackScreen.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001tB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0000¢\u0006\u0002\b:J0\u0010;\u001a\u0002072\u0006\u0010<\u001a\u00020\f2\u0006\u0010=\u001a\u0002092\u0006\u0010>\u001a\u0002092\u0006\u0010?\u001a\u0002092\u0006\u0010@\u001a\u000209H\u0014J\u0015\u0010G\u001a\u0002072\u0006\u0010H\u001a\u00020FH\u0000¢\u0006\u0002\bIJ\r\u0010J\u001a\u000207H\u0000¢\u0006\u0002\bKJ\u0015\u0010L\u001a\u0002072\u0006\u0010M\u001a\u00020AH\u0000¢\u0006\u0002\bNJ\u0015\u0010O\u001a\u0002072\u0006\u0010M\u001a\u00020AH\u0000¢\u0006\u0002\bPJ\u0018\u0010Q\u001a\u0002072\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020\u0001H\u0016J\r\u0010a\u001a\u000207H\u0000¢\u0006\u0002\bbJ\u0015\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020fH\u0000¢\u0006\u0002\bgJ\r\u0010h\u001a\u000207H\u0000¢\u0006\u0002\biJ\r\u0010j\u001a\u000207H\u0000¢\u0006\u0002\bkJ\n\u0010l\u001a\u0004\u0018\u00010mH\u0016J\u0010\u0010n\u001a\u0002072\u0006\u0010o\u001a\u00020pH\u0016J\u0010\u0010q\u001a\u0002072\u0006\u0010o\u001a\u00020pH\u0016J\n\u0010r\u001a\u0004\u0018\u00010pH\u0016J\n\u0010s\u001a\u0004\u0018\u00010\u0001H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\"\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR+\u0010 \u001a\u00020\u001f2\u0006\u0010\u000b\u001a\u00020\u001f8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b%\u0010\u0013\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R(\u0010'\u001a\u0004\u0018\u00010&2\b\u0010\u0014\u001a\u0004\u0018\u00010&@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010/\u001a\u0004\u0018\u00010.2\b\u0010\u000b\u001a\u0004\u0018\u00010.8@@@X\u0080\u008e\u0002¢\u0006\u0012\u001a\u0004\b2\u00103\"\u0004\b4\u00105*\u0004\b0\u00101R\"\u0010B\u001a\u0004\u0018\u00010A2\b\u0010\u0014\u001a\u0004\u0018\u00010A@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0016\u0010E\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010U\u001a\u00020VX\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u001c\u0010[\u001a\u0004\u0018\u00010\\X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`¨\u0006u"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/screen/StackScreen;", "Landroid/view/ViewGroup;", "Lcom/swmansion/rnscreens/gamma/common/FragmentProviding;", "Lcom/swmansion/rnscreens/gamma/scrollviewmarker/ScrollViewSeeking;", "Lcom/swmansion/rnscreens/gamma/common/container/ContainerItem;", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "<init>", "(Lcom/facebook/react/uimanager/ThemedReactContext;)V", "containerItemSupport", "Lcom/swmansion/rnscreens/gamma/common/container/ContainerItemSupport;", "<set-?>", "", "isPreventNativeDismissEnabled", "isPreventNativeDismissEnabled$react_native_screens_release", "()Z", "setPreventNativeDismissEnabled$react_native_screens_release", "(Z)V", "isPreventNativeDismissEnabled$delegate", "Lkotlin/properties/ReadWriteProperty;", "value", "isNativelyDismissed", "isNativelyDismissed$react_native_screens_release", "setNativelyDismissed$react_native_screens_release", "stackHost", "Ljava/lang/ref/WeakReference;", "Lcom/swmansion/rnscreens/gamma/stack/host/StackHost;", "getStackHost$react_native_screens_release", "()Ljava/lang/ref/WeakReference;", "setStackHost$react_native_screens_release", "(Ljava/lang/ref/WeakReference;)V", "Lcom/swmansion/rnscreens/gamma/stack/screen/StackScreen$ActivityMode;", "activityMode", "getActivityMode", "()Lcom/swmansion/rnscreens/gamma/stack/screen/StackScreen$ActivityMode;", "setActivityMode", "(Lcom/swmansion/rnscreens/gamma/stack/screen/StackScreen$ActivityMode;)V", "activityMode$delegate", "", "screenKey", "getScreenKey", "()Ljava/lang/String;", "setScreenKey", "(Ljava/lang/String;)V", "shadowStateProxy", "Lcom/swmansion/rnscreens/gamma/common/ShadowStateProxy;", "Lcom/facebook/react/uimanager/StateWrapper;", "stateWrapper", "getStateWrapper$react_native_screens_release$delegate", "(Lcom/swmansion/rnscreens/gamma/stack/screen/StackScreen;)Ljava/lang/Object;", "getStateWrapper$react_native_screens_release", "()Lcom/facebook/react/uimanager/StateWrapper;", "setStateWrapper$react_native_screens_release", "(Lcom/facebook/react/uimanager/StateWrapper;)V", "onContentYOriginChanged", "", ViewDeviceOrientationData.DEVICE_ORIENTATION_Y, "", "onContentYOriginChanged$react_native_screens_release", "onLayout", "changed", "l", "t", "r", "b", "Lcom/swmansion/rnscreens/gamma/stack/header/config/StackHeaderConfig;", "headerConfig", "getHeaderConfig$react_native_screens_release", "()Lcom/swmansion/rnscreens/gamma/stack/header/config/StackHeaderConfig;", "onHeaderConfigurationAttachListener", "Lcom/swmansion/rnscreens/gamma/stack/header/config/OnHeaderConfigurationAttachListener;", "registerHeaderConfigAttachListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "registerHeaderConfigAttachListener$react_native_screens_release", "clearHeaderConfigAttachListener", "clearHeaderConfigAttachListener$react_native_screens_release", "attachHeaderConfig", "header", "attachHeaderConfig$react_native_screens_release", "detachHeaderConfig", "detachHeaderConfig$react_native_screens_release", "registerScrollView", "marker", "Lcom/swmansion/rnscreens/gamma/scrollviewmarker/ScrollViewMarker;", "scrollView", "eventEmitter", "Lcom/swmansion/rnscreens/gamma/stack/screen/StackScreenEventEmitter;", "getEventEmitter$react_native_screens_release", "()Lcom/swmansion/rnscreens/gamma/stack/screen/StackScreenEventEmitter;", "setEventEmitter$react_native_screens_release", "(Lcom/swmansion/rnscreens/gamma/stack/screen/StackScreenEventEmitter;)V", "preventNativeDismissChangeObserver", "Lcom/swmansion/rnscreens/gamma/stack/screen/PreventNativeDismissChangeObserver;", "getPreventNativeDismissChangeObserver$react_native_screens_release", "()Lcom/swmansion/rnscreens/gamma/stack/screen/PreventNativeDismissChangeObserver;", "setPreventNativeDismissChangeObserver$react_native_screens_release", "(Lcom/swmansion/rnscreens/gamma/stack/screen/PreventNativeDismissChangeObserver;)V", "onViewManagerAddEventEmitters", "onViewManagerAddEventEmitters$react_native_screens_release", "createAppearanceEventsEmitter", "Lcom/swmansion/rnscreens/gamma/stack/screen/StackScreenAppearanceEventsEmitter;", "viewLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "createAppearanceEventsEmitter$react_native_screens_release", StackScreenDismissEvent.EVENT_REGISTRATION_NAME, "onDismiss$react_native_screens_release", StackScreenNativeDismissPreventedEvent.EVENT_REGISTRATION_NAME, "onNativeDismissPrevented$react_native_screens_release", "getAssociatedFragment", "Landroidx/fragment/app/Fragment;", "registerNestedContainer", WebViewRumEventMapper.CONTAINER_KEY_NAME, "Lcom/swmansion/rnscreens/gamma/common/container/Container;", "unregisterNestedContainer", "resolveNestedContainer", "findContentScrollView", "ActivityMode", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class StackScreen extends ViewGroup implements FragmentProviding, ScrollViewSeeking, ContainerItem {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(StackScreen.class, "isPreventNativeDismissEnabled", "isPreventNativeDismissEnabled$react_native_screens_release()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(StackScreen.class, "activityMode", "getActivityMode()Lcom/swmansion/rnscreens/gamma/stack/screen/StackScreen$ActivityMode;", 0))};

    /* JADX INFO: renamed from: activityMode$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty activityMode;
    private final ContainerItemSupport containerItemSupport;
    public StackScreenEventEmitter eventEmitter;
    private StackHeaderConfig headerConfig;
    private boolean isNativelyDismissed;

    /* JADX INFO: renamed from: isPreventNativeDismissEnabled$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty isPreventNativeDismissEnabled;
    private WeakReference<OnHeaderConfigurationAttachListener> onHeaderConfigurationAttachListener;
    private PreventNativeDismissChangeObserver preventNativeDismissChangeObserver;
    private final ThemedReactContext reactContext;
    private String screenKey;
    private final ShadowStateProxy shadowStateProxy;
    private WeakReference<StackHost> stackHost;

    /* JADX INFO: compiled from: StackScreen.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/screen/StackScreen$ActivityMode;", "", "<init>", "(Ljava/lang/String;I)V", "DETACHED", "ATTACHED", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public enum ActivityMode {
        DETACHED,
        ATTACHED;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<ActivityMode> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StackScreen(ThemedReactContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        this.containerItemSupport = new ContainerItemSupport();
        Delegates delegates = Delegates.INSTANCE;
        final boolean z = false;
        this.isPreventNativeDismissEnabled = new ObservableProperty<Boolean>(z) { // from class: com.swmansion.rnscreens.gamma.stack.screen.StackScreen$special$$inlined$observable$1
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, Boolean oldValue, Boolean newValue) {
                PreventNativeDismissChangeObserver preventNativeDismissChangeObserver;
                Intrinsics.checkNotNullParameter(property, "property");
                boolean zBooleanValue = newValue.booleanValue();
                if (oldValue.booleanValue() == zBooleanValue || (preventNativeDismissChangeObserver = this.getPreventNativeDismissChangeObserver()) == null) {
                    return;
                }
                preventNativeDismissChangeObserver.preventNativeDismissChanged(zBooleanValue);
            }
        };
        this.stackHost = new WeakReference<>(null);
        Delegates delegates2 = Delegates.INSTANCE;
        final ActivityMode activityMode = ActivityMode.DETACHED;
        this.activityMode = new ObservableProperty<ActivityMode>(activityMode) { // from class: com.swmansion.rnscreens.gamma.stack.screen.StackScreen$special$$inlined$observable$2
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, StackScreen.ActivityMode oldValue, StackScreen.ActivityMode newValue) {
                StackHost stackHost;
                Intrinsics.checkNotNullParameter(property, "property");
                if (oldValue == newValue || (stackHost = this.getStackHost$react_native_screens_release().get()) == null) {
                    return;
                }
                stackHost.stackScreenChangedActivityMode$react_native_screens_release(this);
            }
        };
        this.shadowStateProxy = new ShadowStateProxy(false, 1, null);
    }

    public final boolean isPreventNativeDismissEnabled$react_native_screens_release() {
        return ((Boolean) this.isPreventNativeDismissEnabled.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    public final void setPreventNativeDismissEnabled$react_native_screens_release(boolean z) {
        this.isPreventNativeDismissEnabled.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z));
    }

    /* JADX INFO: renamed from: isNativelyDismissed$react_native_screens_release, reason: from getter */
    public final boolean getIsNativelyDismissed() {
        return this.isNativelyDismissed;
    }

    public final void setNativelyDismissed$react_native_screens_release(boolean z) {
        if (!z) {
            throw new IllegalArgumentException("[RNScreens] Natively dismissed StackScreen must remain dismissed.".toString());
        }
        this.isNativelyDismissed = true;
    }

    public final WeakReference<StackHost> getStackHost$react_native_screens_release() {
        return this.stackHost;
    }

    public final void setStackHost$react_native_screens_release(WeakReference<StackHost> weakReference) {
        Intrinsics.checkNotNullParameter(weakReference, "<set-?>");
        this.stackHost = weakReference;
    }

    public final ActivityMode getActivityMode() {
        return (ActivityMode) this.activityMode.getValue(this, $$delegatedProperties[1]);
    }

    public final void setActivityMode(ActivityMode activityMode) {
        Intrinsics.checkNotNullParameter(activityMode, "<set-?>");
        this.activityMode.setValue(this, $$delegatedProperties[1], activityMode);
    }

    public final String getScreenKey() {
        return this.screenKey;
    }

    public final void setScreenKey(String str) {
        if (this.screenKey != null) {
            throw new IllegalArgumentException("[RNScreens] StackScreen can't change its screenKey.".toString());
        }
        this.screenKey = str;
    }

    public final StateWrapper getStateWrapper$react_native_screens_release() {
        return this.shadowStateProxy.getStateWrapper();
    }

    public final void setStateWrapper$react_native_screens_release(StateWrapper stateWrapper) {
        this.shadowStateProxy.setStateWrapper$react_native_screens_release(stateWrapper);
    }

    public final void onContentYOriginChanged$react_native_screens_release(int y) {
        ShadowStateProxy.updateStateIfNeeded$default(this.shadowStateProxy, getResources().getDisplayMetrics().density, null, null, null, Integer.valueOf(y), 14, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        ShadowStateProxy.updateStateIfNeeded$default(this.shadowStateProxy, getResources().getDisplayMetrics().density, Integer.valueOf(r - l), Integer.valueOf(b - t), null, null, 24, null);
    }

    /* JADX INFO: renamed from: getHeaderConfig$react_native_screens_release, reason: from getter */
    public final StackHeaderConfig getHeaderConfig() {
        return this.headerConfig;
    }

    public final void registerHeaderConfigAttachListener$react_native_screens_release(OnHeaderConfigurationAttachListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        WeakReference<OnHeaderConfigurationAttachListener> weakReference = this.onHeaderConfigurationAttachListener;
        if ((weakReference != null ? weakReference.get() : null) != null) {
            throw new IllegalStateException("[RNScreens] Attempted to register header config attach listener before previous listener was cleared.".toString());
        }
        this.onHeaderConfigurationAttachListener = new WeakReference<>(listener);
        StackHeaderConfig stackHeaderConfig = this.headerConfig;
        if (stackHeaderConfig != null) {
            listener.onHeaderConfigAttached(stackHeaderConfig, stackHeaderConfig);
        }
    }

    public final void clearHeaderConfigAttachListener$react_native_screens_release() {
        this.onHeaderConfigurationAttachListener = null;
    }

    public final void attachHeaderConfig$react_native_screens_release(StackHeaderConfig header) {
        OnHeaderConfigurationAttachListener onHeaderConfigurationAttachListener;
        Intrinsics.checkNotNullParameter(header, "header");
        this.headerConfig = header;
        WeakReference<OnHeaderConfigurationAttachListener> weakReference = this.onHeaderConfigurationAttachListener;
        if (weakReference == null || (onHeaderConfigurationAttachListener = weakReference.get()) == null) {
            return;
        }
        onHeaderConfigurationAttachListener.onHeaderConfigAttached(header, header);
    }

    public final void detachHeaderConfig$react_native_screens_release(StackHeaderConfig header) {
        OnHeaderConfigurationAttachListener onHeaderConfigurationAttachListener;
        Intrinsics.checkNotNullParameter(header, "header");
        if (this.headerConfig == header) {
            this.headerConfig = null;
            WeakReference<OnHeaderConfigurationAttachListener> weakReference = this.onHeaderConfigurationAttachListener;
            if (weakReference == null || (onHeaderConfigurationAttachListener = weakReference.get()) == null) {
                return;
            }
            onHeaderConfigurationAttachListener.onHeaderConfigAttached(null, null);
        }
    }

    @Override // com.swmansion.rnscreens.gamma.scrollviewmarker.ScrollViewSeeking
    public void registerScrollView(ScrollViewMarker marker, ViewGroup scrollView) {
        Intrinsics.checkNotNullParameter(marker, "marker");
        Intrinsics.checkNotNullParameter(scrollView, "scrollView");
        this.containerItemSupport.registerScrollView(scrollView);
    }

    public final StackScreenEventEmitter getEventEmitter$react_native_screens_release() {
        StackScreenEventEmitter stackScreenEventEmitter = this.eventEmitter;
        if (stackScreenEventEmitter != null) {
            return stackScreenEventEmitter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("eventEmitter");
        return null;
    }

    public final void setEventEmitter$react_native_screens_release(StackScreenEventEmitter stackScreenEventEmitter) {
        Intrinsics.checkNotNullParameter(stackScreenEventEmitter, "<set-?>");
        this.eventEmitter = stackScreenEventEmitter;
    }

    /* JADX INFO: renamed from: getPreventNativeDismissChangeObserver$react_native_screens_release, reason: from getter */
    public final PreventNativeDismissChangeObserver getPreventNativeDismissChangeObserver() {
        return this.preventNativeDismissChangeObserver;
    }

    public final void setPreventNativeDismissChangeObserver$react_native_screens_release(PreventNativeDismissChangeObserver preventNativeDismissChangeObserver) {
        this.preventNativeDismissChangeObserver = preventNativeDismissChangeObserver;
    }

    public final void onViewManagerAddEventEmitters$react_native_screens_release() {
        if (getId() == -1) {
            throw new IllegalStateException("[RNScreens] StackScreen must have its tag set when registering event emitters".toString());
        }
        setEventEmitter$react_native_screens_release(new StackScreenEventEmitter(this.reactContext, getId()));
    }

    public final StackScreenAppearanceEventsEmitter createAppearanceEventsEmitter$react_native_screens_release(LifecycleOwner viewLifecycleOwner) {
        Intrinsics.checkNotNullParameter(viewLifecycleOwner, "viewLifecycleOwner");
        return new StackScreenAppearanceEventsEmitter(viewLifecycleOwner.getLifecycleRegistry(), getEventEmitter$react_native_screens_release());
    }

    public final void onDismiss$react_native_screens_release() {
        if (getActivityMode() == ActivityMode.ATTACHED) {
            setNativelyDismissed$react_native_screens_release(true);
        }
        getEventEmitter$react_native_screens_release().emitOnDismiss$react_native_screens_release(this.isNativelyDismissed);
    }

    public final void onNativeDismissPrevented$react_native_screens_release() {
        getEventEmitter$react_native_screens_release().emitOnNativeDismissPrevented$react_native_screens_release();
    }

    @Override // com.swmansion.rnscreens.gamma.common.FragmentProviding
    public Fragment getAssociatedFragment() {
        Fragment fragmentFindFragmentOrNull = ViewExtKt.findFragmentOrNull(this);
        if (fragmentFindFragmentOrNull == null) {
            return null;
        }
        if (fragmentFindFragmentOrNull instanceof StackScreenFragment) {
            return fragmentFindFragmentOrNull;
        }
        throw new IllegalStateException(("[RNScreens] Unexpected fragment type: " + fragmentFindFragmentOrNull.getClass().getSimpleName()).toString());
    }

    @Override // com.swmansion.rnscreens.gamma.common.container.ContainerItem
    public void registerNestedContainer(Container container) {
        Intrinsics.checkNotNullParameter(container, "container");
        this.containerItemSupport.registerNestedContainer(container);
    }

    @Override // com.swmansion.rnscreens.gamma.common.container.ContainerItem
    public void unregisterNestedContainer(Container container) {
        Intrinsics.checkNotNullParameter(container, "container");
        this.containerItemSupport.unregisterNestedContainer(container);
    }

    @Override // com.swmansion.rnscreens.gamma.common.container.ContainerItem
    public Container resolveNestedContainer() {
        return this.containerItemSupport.resolveNestedContainer();
    }

    @Override // com.swmansion.rnscreens.gamma.common.container.ContainerItem
    public ViewGroup findContentScrollView() {
        return this.containerItemSupport.findContentScrollView(this);
    }
}
