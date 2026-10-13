package com.datadog.reactnative;

import android.os.Handler;
import android.os.Looper;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.heatmaps.CrossPlatformHeatmapActionData;
import com.datadog.android.rum.RumActionType;
import com.datadog.android.rum._RumInternalProxy;
import com.datadog.android.rum.internal.RumFeature;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.events.PointerEventHelper;
import com.mux.stats.sdk.core.model.ViewDeviceOrientationData;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: HeatmapActionHandler.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u0000  2\u00020\u0001:\u0002\u001f B/\b\u0000\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u001a\b\u0002\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ1\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0000¢\u0006\u0002\b\u0013JA\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0000¢\u0006\u0002\b\u0019J(\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001b*\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u000fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/datadog/reactnative/HeatmapActionHandler;", "", "heatmapTouchResolver", "Lcom/datadog/reactnative/HeatmapTouchResolver;", "mainThreadExecutor", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "<init>", "(Lcom/datadog/reactnative/HeatmapTouchResolver;Lkotlin/jvm/functions/Function1;)V", "resolveEligibility", "Lcom/datadog/reactnative/HeatmapActionHandler$EligibleAction;", "datadog", "Lcom/datadog/reactnative/DatadogWrapper;", "type", "", "name", PointerEventHelper.POINTER_TYPE_TOUCH, "Lcom/facebook/react/bridge/ReadableMap;", "resolveEligibility$datadog_mobile_react_native_release", "attachHeatmapData", "eligibleAction", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "", "fallback", "attachHeatmapData$datadog_mobile_react_native_release", "toTouchFieldsOrNull", "Lkotlin/Triple;", "", "", "actionName", "EligibleAction", "Companion", "datadog_mobile-react-native_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HeatmapActionHandler {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static volatile boolean heatmapsEnabled;
    private final HeatmapTouchResolver heatmapTouchResolver;
    private final Function1<Function0<Unit>, Unit> mainThreadExecutor;

    /* JADX WARN: Multi-variable type inference failed */
    public HeatmapActionHandler() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HeatmapActionHandler(HeatmapTouchResolver heatmapTouchResolver, Function1<? super Function0<Unit>, Unit> mainThreadExecutor) {
        Intrinsics.checkNotNullParameter(heatmapTouchResolver, "heatmapTouchResolver");
        Intrinsics.checkNotNullParameter(mainThreadExecutor, "mainThreadExecutor");
        this.heatmapTouchResolver = heatmapTouchResolver;
        this.mainThreadExecutor = mainThreadExecutor;
    }

    public /* synthetic */ HeatmapActionHandler(HeatmapTouchResolver heatmapTouchResolver, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new HeatmapTouchResolver(null, null, 3, null) : heatmapTouchResolver, (i & 2) != 0 ? INSTANCE.defaultMainThreadExecutor() : function1);
    }

    /* JADX INFO: compiled from: HeatmapActionHandler.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J;\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0014\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001f\u001a\u00020\u0007HÖ\u0081\u0004J\n\u0010 \u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014¨\u0006!"}, d2 = {"Lcom/datadog/reactnative/HeatmapActionHandler$EligibleAction;", "", "internalProxy", "Lcom/datadog/android/rum/_RumInternalProxy;", "viewUrl", "", "reactTag", "", "positionX", "", "positionY", "<init>", "(Lcom/datadog/android/rum/_RumInternalProxy;Ljava/lang/String;IJJ)V", "getInternalProxy", "()Lcom/datadog/android/rum/_RumInternalProxy;", "getViewUrl", "()Ljava/lang/String;", "getReactTag", "()I", "getPositionX", "()J", "getPositionY", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "datadog_mobile-react-native_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class EligibleAction {
        private final _RumInternalProxy internalProxy;
        private final long positionX;
        private final long positionY;
        private final int reactTag;
        private final String viewUrl;

        public static /* synthetic */ EligibleAction copy$default(EligibleAction eligibleAction, _RumInternalProxy _ruminternalproxy, String str, int i, long j, long j2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                _ruminternalproxy = eligibleAction.internalProxy;
            }
            if ((i2 & 2) != 0) {
                str = eligibleAction.viewUrl;
            }
            if ((i2 & 4) != 0) {
                i = eligibleAction.reactTag;
            }
            if ((i2 & 8) != 0) {
                j = eligibleAction.positionX;
            }
            if ((i2 & 16) != 0) {
                j2 = eligibleAction.positionY;
            }
            long j3 = j2;
            int i3 = i;
            return eligibleAction.copy(_ruminternalproxy, str, i3, j, j3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final _RumInternalProxy getInternalProxy() {
            return this.internalProxy;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getViewUrl() {
            return this.viewUrl;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getReactTag() {
            return this.reactTag;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final long getPositionX() {
            return this.positionX;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final long getPositionY() {
            return this.positionY;
        }

        public final EligibleAction copy(_RumInternalProxy internalProxy, String viewUrl, int reactTag, long positionX, long positionY) {
            Intrinsics.checkNotNullParameter(internalProxy, "internalProxy");
            Intrinsics.checkNotNullParameter(viewUrl, "viewUrl");
            return new EligibleAction(internalProxy, viewUrl, reactTag, positionX, positionY);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EligibleAction)) {
                return false;
            }
            EligibleAction eligibleAction = (EligibleAction) other;
            return Intrinsics.areEqual(this.internalProxy, eligibleAction.internalProxy) && Intrinsics.areEqual(this.viewUrl, eligibleAction.viewUrl) && this.reactTag == eligibleAction.reactTag && this.positionX == eligibleAction.positionX && this.positionY == eligibleAction.positionY;
        }

        public int hashCode() {
            return (((((((this.internalProxy.hashCode() * 31) + this.viewUrl.hashCode()) * 31) + Integer.hashCode(this.reactTag)) * 31) + Long.hashCode(this.positionX)) * 31) + Long.hashCode(this.positionY);
        }

        public String toString() {
            return "EligibleAction(internalProxy=" + this.internalProxy + ", viewUrl=" + this.viewUrl + ", reactTag=" + this.reactTag + ", positionX=" + this.positionX + ", positionY=" + this.positionY + ")";
        }

        public EligibleAction(_RumInternalProxy internalProxy, String viewUrl, int i, long j, long j2) {
            Intrinsics.checkNotNullParameter(internalProxy, "internalProxy");
            Intrinsics.checkNotNullParameter(viewUrl, "viewUrl");
            this.internalProxy = internalProxy;
            this.viewUrl = viewUrl;
            this.reactTag = i;
            this.positionX = j;
            this.positionY = j2;
        }

        public final _RumInternalProxy getInternalProxy() {
            return this.internalProxy;
        }

        public final String getViewUrl() {
            return this.viewUrl;
        }

        public final int getReactTag() {
            return this.reactTag;
        }

        public final long getPositionX() {
            return this.positionX;
        }

        public final long getPositionY() {
            return this.positionY;
        }
    }

    public final EligibleAction resolveEligibility$datadog_mobile_react_native_release(DatadogWrapper datadog, String type, String name, ReadableMap touch) {
        Intrinsics.checkNotNullParameter(datadog, "datadog");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        if (heatmapsEnabled && touch != null && StringsKt.equals(type, "tap", true)) {
            _RumInternalProxy _ruminternalproxy_getInternal = datadog.getRumMonitor()._getInternal();
            String currentViewUrl = _ruminternalproxy_getInternal != null ? _ruminternalproxy_getInternal.getCurrentViewUrl() : null;
            Triple<Integer, Long, Long> touchFieldsOrNull = toTouchFieldsOrNull(touch, name);
            if (_ruminternalproxy_getInternal != null && currentViewUrl != null && touchFieldsOrNull != null) {
                return new EligibleAction(_ruminternalproxy_getInternal, currentViewUrl, touchFieldsOrNull.component1().intValue(), touchFieldsOrNull.component2().longValue(), touchFieldsOrNull.component3().longValue());
            }
        }
        return null;
    }

    public final void attachHeatmapData$datadog_mobile_react_native_release(final EligibleAction eligibleAction, final String name, final Map<String, ? extends Object> attributes, final Function0<Unit> fallback) {
        Intrinsics.checkNotNullParameter(eligibleAction, "eligibleAction");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(fallback, "fallback");
        this.mainThreadExecutor.invoke(new Function0() { // from class: com.datadog.reactnative.HeatmapActionHandler$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HeatmapActionHandler.attachHeatmapData$lambda$0(this.f$0, eligibleAction, name, attributes, fallback);
            }
        });
    }

    static final Unit attachHeatmapData$lambda$0(HeatmapActionHandler heatmapActionHandler, EligibleAction eligibleAction, String str, Map map, Function0 function0) {
        CrossPlatformHeatmapActionData crossPlatformHeatmapActionDataResolveHeatmapActionData = heatmapActionHandler.heatmapTouchResolver.resolveHeatmapActionData(eligibleAction.getReactTag(), eligibleAction.getPositionX(), eligibleAction.getPositionY(), eligibleAction.getViewUrl());
        if (crossPlatformHeatmapActionDataResolveHeatmapActionData != null) {
            eligibleAction.getInternalProxy().addActionWithHeatmap(RumActionType.TAP, str, crossPlatformHeatmapActionDataResolveHeatmapActionData, map);
        } else {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    private final Triple<Integer, Long, Long> toTouchFieldsOrNull(ReadableMap readableMap, final String str) {
        Object objM12684constructorimpl;
        if (!readableMap.hasKey("reactTag") || !readableMap.hasKey(ViewDeviceOrientationData.DEVICE_ORIENTATION_X) || !readableMap.hasKey(ViewDeviceOrientationData.DEVICE_ORIENTATION_Y)) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(new Triple(Integer.valueOf(readableMap.getInt("reactTag")), Long.valueOf((long) readableMap.getDouble(ViewDeviceOrientationData.DEVICE_ORIENTATION_X)), Long.valueOf((long) readableMap.getDouble(ViewDeviceOrientationData.DEVICE_ORIENTATION_Y))));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM12687exceptionOrNullimpl = Result.m12687exceptionOrNullimpl(objM12684constructorimpl);
        if (thM12687exceptionOrNullimpl != null) {
            InternalLogger.DefaultImpls.log$default(InternalLogger.INSTANCE.getUNBOUND(), InternalLogger.Level.WARN, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.reactnative.HeatmapActionHandler$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return HeatmapActionHandler.toTouchFieldsOrNull$lambda$1$0(str);
                }
            }, thM12687exceptionOrNullimpl, true, (Map) null, 32, (Object) null);
        }
        return (Triple) (Result.m12690isFailureimpl(objM12684constructorimpl) ? null : objM12684constructorimpl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String toTouchFieldsOrNull$lambda$1$0(String str) {
        return "addAction(\"" + str + "\"): heatmap tracking requires actionContext's nativeEvent.target/locationX/locationY to be numbers, as produced by a standard onPress GestureResponderEvent. The value passed for this action didn't match that shape, so heatmap tracking was skipped for it — this is expected if actionContext came from a non-standard event source (e.g. a different gesture library).";
    }

    /* JADX INFO: compiled from: HeatmapActionHandler.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0002R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e²\u0006\n\u0010\u000f\u001a\u00020\u0010X\u008a\u0084\u0002"}, d2 = {"Lcom/datadog/reactnative/HeatmapActionHandler$Companion;", "", "<init>", "()V", "defaultMainThreadExecutor", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "heatmapsEnabled", "", "getHeatmapsEnabled", "()Z", "setHeatmapsEnabled", "(Z)V", "datadog_mobile-react-native_release", "handler", "Landroid/os/Handler;"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Function1<Function0<Unit>, Unit> defaultMainThreadExecutor() {
            final Lazy lazy = LazyKt.lazy(new Function0() { // from class: com.datadog.reactnative.HeatmapActionHandler$Companion$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return HeatmapActionHandler.Companion.defaultMainThreadExecutor$lambda$0();
                }
            });
            return new Function1() { // from class: com.datadog.reactnative.HeatmapActionHandler$Companion$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return HeatmapActionHandler.Companion.defaultMainThreadExecutor$lambda$2(lazy, (Function0) obj);
                }
            };
        }

        static final Handler defaultMainThreadExecutor$lambda$0() {
            return new Handler(Looper.getMainLooper());
        }

        private static final Handler defaultMainThreadExecutor$lambda$1(Lazy<? extends Handler> lazy) {
            return lazy.getValue();
        }

        static final Unit defaultMainThreadExecutor$lambda$2(Lazy lazy, final Function0 action) {
            Intrinsics.checkNotNullParameter(action, "action");
            defaultMainThreadExecutor$lambda$1(lazy).post(new Runnable() { // from class: com.datadog.reactnative.HeatmapActionHandler$Companion$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    action.invoke();
                }
            });
            return Unit.INSTANCE;
        }

        public final boolean getHeatmapsEnabled() {
            return HeatmapActionHandler.heatmapsEnabled;
        }

        public final void setHeatmapsEnabled(boolean z) {
            HeatmapActionHandler.heatmapsEnabled = z;
        }
    }
}
