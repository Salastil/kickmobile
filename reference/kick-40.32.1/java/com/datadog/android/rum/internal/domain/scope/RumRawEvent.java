package com.datadog.android.rum.internal.domain.scope;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.datadog.android.core.feature.event.ThreadDump;
import com.datadog.android.heatmaps.CrossPlatformHeatmapActionData;
import com.datadog.android.internal.telemetry.InternalTelemetryEvent;
import com.datadog.android.rum.RumActionType;
import com.datadog.android.rum.RumErrorSource;
import com.datadog.android.rum.RumPerformanceMetric;
import com.datadog.android.rum.RumResourceKind;
import com.datadog.android.rum.RumResourceMethod;
import com.datadog.android.rum.internal.RumErrorSourceType;
import com.datadog.android.rum.internal.RumFeature;
import com.datadog.android.rum.internal.domain.Time;
import com.datadog.android.rum.internal.domain.event.ResourceTiming;
import com.datadog.android.rum.internal.domain.event.RumEventMeta;
import com.datadog.android.rum.internal.heatmaps.NativeHeatmapActionData;
import com.datadog.android.rum.internal.startup.RumAppStartupTelemetryReporterImpl;
import com.datadog.android.rum.internal.startup.RumStartupScenario;
import com.datadog.android.rum.internal.startup.RumTTIDInfo;
import com.datadog.android.rum.model.ActionEvent;
import com.datadog.android.rum.operations.FailureReason;
import com.facebook.react.devsupport.StackTraceHelper;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.ktor.http.ContentDisposition;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RumRawEvent.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:*\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./0B\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001*123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ¨\u0006["}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "", "()V", "eventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "ActionDropped", "ActionSent", "AddCustomTiming", "AddError", "AddFeatureFlagEvaluation", "AddFeatureFlagEvaluations", "AddLongTask", "AddResourceTiming", "AddViewAttributes", "AddViewLoadingTime", "AppStartEvent", "AppStartTTFDEvent", "AppStartTTIDEvent", "ApplicationStarted", "ErrorDropped", "ErrorSent", "LongTaskDropped", "LongTaskSent", "RemoveViewAttributes", "ResetSession", "ResourceDropped", "ResourceSent", "SdkInit", "SendCustomActionNow", "SetInternalViewAttribute", "SetSyntheticsTestAttribute", "StartAction", "StartOperation", "StartResource", "StartView", "StopAction", "StopOperation", "StopResource", "StopResourceWithError", "StopResourceWithStackTrace", "StopSession", "StopView", "TelemetryEventWrapper", "UpdateExternalRefreshRate", "UpdatePerformanceMetric", "WaitForResourceTiming", "WebViewEvent", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$ActionDropped;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$ActionSent;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$AddCustomTiming;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$AddError;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$AddFeatureFlagEvaluation;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$AddFeatureFlagEvaluations;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$AddLongTask;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$AddResourceTiming;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$AddViewAttributes;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$AddViewLoadingTime;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$AppStartEvent;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$AppStartTTFDEvent;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$AppStartTTIDEvent;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$ApplicationStarted;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$ErrorDropped;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$ErrorSent;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$LongTaskDropped;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$LongTaskSent;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$RemoveViewAttributes;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$ResetSession;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$ResourceDropped;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$ResourceSent;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$SdkInit;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$SendCustomActionNow;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$SetInternalViewAttribute;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$SetSyntheticsTestAttribute;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StartAction;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StartOperation;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StartResource;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StartView;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StopAction;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StopOperation;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StopResource;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StopResourceWithError;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StopResourceWithStackTrace;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StopSession;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StopView;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$TelemetryEventWrapper;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$UpdateExternalRefreshRate;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$UpdatePerformanceMetric;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$WaitForResourceTiming;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$WebViewEvent;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class RumRawEvent {
    public /* synthetic */ RumRawEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract Time getEventTime();

    private RumRawEvent() {
    }

    /* JADX INFO: compiled from: RumRawEvent.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\tHÆ\u0003J5\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001R\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StartView;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "key", "Lcom/datadog/android/rum/internal/domain/scope/RumScopeKey;", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "", "", "", "eventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "(Lcom/datadog/android/rum/internal/domain/scope/RumScopeKey;Ljava/util/Map;Lcom/datadog/android/rum/internal/domain/Time;)V", "getAttributes", "()Ljava/util/Map;", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "getKey", "()Lcom/datadog/android/rum/internal/domain/scope/RumScopeKey;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class StartView extends RumRawEvent {
        private final Map<String, Object> attributes;
        private final Time eventTime;
        private final RumScopeKey key;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StartView copy$default(StartView startView, RumScopeKey rumScopeKey, Map map, Time time, int i, Object obj) {
            if ((i & 1) != 0) {
                rumScopeKey = startView.key;
            }
            if ((i & 2) != 0) {
                map = startView.attributes;
            }
            if ((i & 4) != 0) {
                time = startView.eventTime;
            }
            return startView.copy(rumScopeKey, map, time);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final RumScopeKey getKey() {
            return this.key;
        }

        public final Map<String, Object> component2() {
            return this.attributes;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Time getEventTime() {
            return this.eventTime;
        }

        public final StartView copy(RumScopeKey key, Map<String, ? extends Object> attributes, Time eventTime) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            return new StartView(key, attributes, eventTime);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StartView)) {
                return false;
            }
            StartView startView = (StartView) other;
            return Intrinsics.areEqual(this.key, startView.key) && Intrinsics.areEqual(this.attributes, startView.attributes) && Intrinsics.areEqual(this.eventTime, startView.eventTime);
        }

        public int hashCode() {
            return (((this.key.hashCode() * 31) + this.attributes.hashCode()) * 31) + this.eventTime.hashCode();
        }

        public String toString() {
            return "StartView(key=" + this.key + ", attributes=" + this.attributes + ", eventTime=" + this.eventTime + ")";
        }

        public final RumScopeKey getKey() {
            return this.key;
        }

        public final Map<String, Object> getAttributes() {
            return this.attributes;
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StartView(RumScopeKey key, Map<String, ? extends Object> attributes, Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.key = key;
            this.attributes = attributes;
            this.eventTime = eventTime;
        }
    }

    /* JADX INFO: compiled from: RumRawEvent.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\tHÆ\u0003J5\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001R\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StopView;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "key", "Lcom/datadog/android/rum/internal/domain/scope/RumScopeKey;", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "", "", "", "eventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "(Lcom/datadog/android/rum/internal/domain/scope/RumScopeKey;Ljava/util/Map;Lcom/datadog/android/rum/internal/domain/Time;)V", "getAttributes", "()Ljava/util/Map;", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "getKey", "()Lcom/datadog/android/rum/internal/domain/scope/RumScopeKey;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class StopView extends RumRawEvent {
        private final Map<String, Object> attributes;
        private final Time eventTime;
        private final RumScopeKey key;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StopView copy$default(StopView stopView, RumScopeKey rumScopeKey, Map map, Time time, int i, Object obj) {
            if ((i & 1) != 0) {
                rumScopeKey = stopView.key;
            }
            if ((i & 2) != 0) {
                map = stopView.attributes;
            }
            if ((i & 4) != 0) {
                time = stopView.eventTime;
            }
            return stopView.copy(rumScopeKey, map, time);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final RumScopeKey getKey() {
            return this.key;
        }

        public final Map<String, Object> component2() {
            return this.attributes;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Time getEventTime() {
            return this.eventTime;
        }

        public final StopView copy(RumScopeKey key, Map<String, ? extends Object> attributes, Time eventTime) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            return new StopView(key, attributes, eventTime);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StopView)) {
                return false;
            }
            StopView stopView = (StopView) other;
            return Intrinsics.areEqual(this.key, stopView.key) && Intrinsics.areEqual(this.attributes, stopView.attributes) && Intrinsics.areEqual(this.eventTime, stopView.eventTime);
        }

        public int hashCode() {
            return (((this.key.hashCode() * 31) + this.attributes.hashCode()) * 31) + this.eventTime.hashCode();
        }

        public String toString() {
            return "StopView(key=" + this.key + ", attributes=" + this.attributes + ", eventTime=" + this.eventTime + ")";
        }

        public final RumScopeKey getKey() {
            return this.key;
        }

        public final Map<String, Object> getAttributes() {
            return this.attributes;
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StopView(RumScopeKey key, Map<String, ? extends Object> attributes, Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.key = key;
            this.attributes = attributes;
            this.eventTime = eventTime;
        }
    }

    /* JADX INFO: compiled from: RumRawEvent.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010¢\u0006\u0002\u0010\u0012J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\t\u0010%\u001a\u00020\tHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0017\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010HÆ\u0003Jm\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010HÆ\u0001J\u0013\u0010+\u001a\u00020\u00072\b\u0010,\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010-\u001a\u00020.HÖ\u0001J\t\u0010/\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001f\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u00060"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StartAction;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "type", "Lcom/datadog/android/rum/RumActionType;", "name", "", "waitForStop", "", "eventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "nativeHeatmapActionData", "Lcom/datadog/android/rum/internal/heatmaps/NativeHeatmapActionData;", "crossPlatformHeatmapActionData", "Lcom/datadog/android/heatmaps/CrossPlatformHeatmapActionData;", "appPackageName", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "", "", "(Lcom/datadog/android/rum/RumActionType;Ljava/lang/String;ZLcom/datadog/android/rum/internal/domain/Time;Lcom/datadog/android/rum/internal/heatmaps/NativeHeatmapActionData;Lcom/datadog/android/heatmaps/CrossPlatformHeatmapActionData;Ljava/lang/String;Ljava/util/Map;)V", "getAppPackageName", "()Ljava/lang/String;", "getAttributes", "()Ljava/util/Map;", "getCrossPlatformHeatmapActionData", "()Lcom/datadog/android/heatmaps/CrossPlatformHeatmapActionData;", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "getName", "getNativeHeatmapActionData", "()Lcom/datadog/android/rum/internal/heatmaps/NativeHeatmapActionData;", "getType", "()Lcom/datadog/android/rum/RumActionType;", "getWaitForStop", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class StartAction extends RumRawEvent {
        private final String appPackageName;
        private final Map<String, Object> attributes;
        private final CrossPlatformHeatmapActionData crossPlatformHeatmapActionData;
        private final Time eventTime;
        private final String name;
        private final NativeHeatmapActionData nativeHeatmapActionData;
        private final RumActionType type;
        private final boolean waitForStop;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StartAction copy$default(StartAction startAction, RumActionType rumActionType, String str, boolean z, Time time, NativeHeatmapActionData nativeHeatmapActionData, CrossPlatformHeatmapActionData crossPlatformHeatmapActionData, String str2, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                rumActionType = startAction.type;
            }
            if ((i & 2) != 0) {
                str = startAction.name;
            }
            if ((i & 4) != 0) {
                z = startAction.waitForStop;
            }
            if ((i & 8) != 0) {
                time = startAction.eventTime;
            }
            if ((i & 16) != 0) {
                nativeHeatmapActionData = startAction.nativeHeatmapActionData;
            }
            if ((i & 32) != 0) {
                crossPlatformHeatmapActionData = startAction.crossPlatformHeatmapActionData;
            }
            if ((i & 64) != 0) {
                str2 = startAction.appPackageName;
            }
            if ((i & 128) != 0) {
                map = startAction.attributes;
            }
            String str3 = str2;
            Map map2 = map;
            NativeHeatmapActionData nativeHeatmapActionData2 = nativeHeatmapActionData;
            CrossPlatformHeatmapActionData crossPlatformHeatmapActionData2 = crossPlatformHeatmapActionData;
            return startAction.copy(rumActionType, str, z, time, nativeHeatmapActionData2, crossPlatformHeatmapActionData2, str3, map2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final RumActionType getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getWaitForStop() {
            return this.waitForStop;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Time getEventTime() {
            return this.eventTime;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final NativeHeatmapActionData getNativeHeatmapActionData() {
            return this.nativeHeatmapActionData;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final CrossPlatformHeatmapActionData getCrossPlatformHeatmapActionData() {
            return this.crossPlatformHeatmapActionData;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getAppPackageName() {
            return this.appPackageName;
        }

        public final Map<String, Object> component8() {
            return this.attributes;
        }

        public final StartAction copy(RumActionType type, String name, boolean waitForStop, Time eventTime, NativeHeatmapActionData nativeHeatmapActionData, CrossPlatformHeatmapActionData crossPlatformHeatmapActionData, String appPackageName, Map<String, ? extends Object> attributes) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            return new StartAction(type, name, waitForStop, eventTime, nativeHeatmapActionData, crossPlatformHeatmapActionData, appPackageName, attributes);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StartAction)) {
                return false;
            }
            StartAction startAction = (StartAction) other;
            return this.type == startAction.type && Intrinsics.areEqual(this.name, startAction.name) && this.waitForStop == startAction.waitForStop && Intrinsics.areEqual(this.eventTime, startAction.eventTime) && Intrinsics.areEqual(this.nativeHeatmapActionData, startAction.nativeHeatmapActionData) && Intrinsics.areEqual(this.crossPlatformHeatmapActionData, startAction.crossPlatformHeatmapActionData) && Intrinsics.areEqual(this.appPackageName, startAction.appPackageName) && Intrinsics.areEqual(this.attributes, startAction.attributes);
        }

        public int hashCode() {
            int iHashCode = ((((((this.type.hashCode() * 31) + this.name.hashCode()) * 31) + Boolean.hashCode(this.waitForStop)) * 31) + this.eventTime.hashCode()) * 31;
            NativeHeatmapActionData nativeHeatmapActionData = this.nativeHeatmapActionData;
            int iHashCode2 = (iHashCode + (nativeHeatmapActionData == null ? 0 : nativeHeatmapActionData.hashCode())) * 31;
            CrossPlatformHeatmapActionData crossPlatformHeatmapActionData = this.crossPlatformHeatmapActionData;
            int iHashCode3 = (iHashCode2 + (crossPlatformHeatmapActionData == null ? 0 : crossPlatformHeatmapActionData.hashCode())) * 31;
            String str = this.appPackageName;
            return ((iHashCode3 + (str != null ? str.hashCode() : 0)) * 31) + this.attributes.hashCode();
        }

        public String toString() {
            return "StartAction(type=" + this.type + ", name=" + this.name + ", waitForStop=" + this.waitForStop + ", eventTime=" + this.eventTime + ", nativeHeatmapActionData=" + this.nativeHeatmapActionData + ", crossPlatformHeatmapActionData=" + this.crossPlatformHeatmapActionData + ", appPackageName=" + this.appPackageName + ", attributes=" + this.attributes + ")";
        }

        public final RumActionType getType() {
            return this.type;
        }

        public final String getName() {
            return this.name;
        }

        public final boolean getWaitForStop() {
            return this.waitForStop;
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        public final NativeHeatmapActionData getNativeHeatmapActionData() {
            return this.nativeHeatmapActionData;
        }

        public final CrossPlatformHeatmapActionData getCrossPlatformHeatmapActionData() {
            return this.crossPlatformHeatmapActionData;
        }

        public final String getAppPackageName() {
            return this.appPackageName;
        }

        public /* synthetic */ StartAction(RumActionType rumActionType, String str, boolean z, Time time, NativeHeatmapActionData nativeHeatmapActionData, CrossPlatformHeatmapActionData crossPlatformHeatmapActionData, String str2, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(rumActionType, str, z, time, (i & 16) != 0 ? null : nativeHeatmapActionData, (i & 32) != 0 ? null : crossPlatformHeatmapActionData, (i & 64) != 0 ? null : str2, (i & 128) != 0 ? MapsKt.emptyMap() : map);
        }

        public final Map<String, Object> getAttributes() {
            return this.attributes;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StartAction(RumActionType type, String name, boolean z, Time eventTime, NativeHeatmapActionData nativeHeatmapActionData, CrossPlatformHeatmapActionData crossPlatformHeatmapActionData, String str, Map<String, ? extends Object> attributes) {
            super(null);
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            this.type = type;
            this.name = name;
            this.waitForStop = z;
            this.eventTime = eventTime;
            this.nativeHeatmapActionData = nativeHeatmapActionData;
            this.crossPlatformHeatmapActionData = crossPlatformHeatmapActionData;
            this.appPackageName = str;
            this.attributes = attributes;
        }
    }

    /* JADX INFO: compiled from: RumRawEvent.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0017\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\nHÆ\u0003JC\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StopAction;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "type", "Lcom/datadog/android/rum/RumActionType;", "name", "", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "", "", "eventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "(Lcom/datadog/android/rum/RumActionType;Ljava/lang/String;Ljava/util/Map;Lcom/datadog/android/rum/internal/domain/Time;)V", "getAttributes", "()Ljava/util/Map;", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "getName", "()Ljava/lang/String;", "getType", "()Lcom/datadog/android/rum/RumActionType;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class StopAction extends RumRawEvent {
        private final Map<String, Object> attributes;
        private final Time eventTime;
        private final String name;
        private final RumActionType type;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StopAction copy$default(StopAction stopAction, RumActionType rumActionType, String str, Map map, Time time, int i, Object obj) {
            if ((i & 1) != 0) {
                rumActionType = stopAction.type;
            }
            if ((i & 2) != 0) {
                str = stopAction.name;
            }
            if ((i & 4) != 0) {
                map = stopAction.attributes;
            }
            if ((i & 8) != 0) {
                time = stopAction.eventTime;
            }
            return stopAction.copy(rumActionType, str, map, time);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final RumActionType getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final Map<String, Object> component3() {
            return this.attributes;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Time getEventTime() {
            return this.eventTime;
        }

        public final StopAction copy(RumActionType type, String name, Map<String, ? extends Object> attributes, Time eventTime) {
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            return new StopAction(type, name, attributes, eventTime);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StopAction)) {
                return false;
            }
            StopAction stopAction = (StopAction) other;
            return this.type == stopAction.type && Intrinsics.areEqual(this.name, stopAction.name) && Intrinsics.areEqual(this.attributes, stopAction.attributes) && Intrinsics.areEqual(this.eventTime, stopAction.eventTime);
        }

        public int hashCode() {
            RumActionType rumActionType = this.type;
            int iHashCode = (rumActionType == null ? 0 : rumActionType.hashCode()) * 31;
            String str = this.name;
            return ((((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.attributes.hashCode()) * 31) + this.eventTime.hashCode();
        }

        public String toString() {
            return "StopAction(type=" + this.type + ", name=" + this.name + ", attributes=" + this.attributes + ", eventTime=" + this.eventTime + ")";
        }

        public final RumActionType getType() {
            return this.type;
        }

        public final String getName() {
            return this.name;
        }

        public final Map<String, Object> getAttributes() {
            return this.attributes;
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StopAction(RumActionType rumActionType, String str, Map<String, ? extends Object> attributes, Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.type = rumActionType;
            this.name = str;
            this.attributes = attributes;
            this.eventTime = eventTime;
        }
    }

    /* JADX INFO: compiled from: RumRawEvent.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\u0017\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00030\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\u000bHÆ\u0003JI\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u001f\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StartResource;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "key", "", ImagesContract.URL, "", FirebaseAnalytics.Param.METHOD, "Lcom/datadog/android/rum/RumResourceMethod;", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "", "eventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "(Ljava/lang/Object;Ljava/lang/String;Lcom/datadog/android/rum/RumResourceMethod;Ljava/util/Map;Lcom/datadog/android/rum/internal/domain/Time;)V", "getAttributes", "()Ljava/util/Map;", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "getKey", "()Ljava/lang/Object;", "getMethod", "()Lcom/datadog/android/rum/RumResourceMethod;", "getUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class StartResource extends RumRawEvent {
        private final Map<String, Object> attributes;
        private final Time eventTime;
        private final Object key;
        private final RumResourceMethod method;
        private final String url;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StartResource copy$default(StartResource startResource, Object obj, String str, RumResourceMethod rumResourceMethod, Map map, Time time, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = startResource.key;
            }
            if ((i & 2) != 0) {
                str = startResource.url;
            }
            if ((i & 4) != 0) {
                rumResourceMethod = startResource.method;
            }
            if ((i & 8) != 0) {
                map = startResource.attributes;
            }
            if ((i & 16) != 0) {
                time = startResource.eventTime;
            }
            Time time2 = time;
            RumResourceMethod rumResourceMethod2 = rumResourceMethod;
            return startResource.copy(obj, str, rumResourceMethod2, map, time2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Object getKey() {
            return this.key;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final RumResourceMethod getMethod() {
            return this.method;
        }

        public final Map<String, Object> component4() {
            return this.attributes;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Time getEventTime() {
            return this.eventTime;
        }

        public final StartResource copy(Object key, String url, RumResourceMethod method, Map<String, ? extends Object> attributes, Time eventTime) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(method, "method");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            return new StartResource(key, url, method, attributes, eventTime);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StartResource)) {
                return false;
            }
            StartResource startResource = (StartResource) other;
            return Intrinsics.areEqual(this.key, startResource.key) && Intrinsics.areEqual(this.url, startResource.url) && this.method == startResource.method && Intrinsics.areEqual(this.attributes, startResource.attributes) && Intrinsics.areEqual(this.eventTime, startResource.eventTime);
        }

        public int hashCode() {
            return (((((((this.key.hashCode() * 31) + this.url.hashCode()) * 31) + this.method.hashCode()) * 31) + this.attributes.hashCode()) * 31) + this.eventTime.hashCode();
        }

        public String toString() {
            return "StartResource(key=" + this.key + ", url=" + this.url + ", method=" + this.method + ", attributes=" + this.attributes + ", eventTime=" + this.eventTime + ")";
        }

        public final Object getKey() {
            return this.key;
        }

        public final String getUrl() {
            return this.url;
        }

        public final RumResourceMethod getMethod() {
            return this.method;
        }

        public final Map<String, Object> getAttributes() {
            return this.attributes;
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StartResource(Object key, String url, RumResourceMethod method, Map<String, ? extends Object> attributes, Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(method, "method");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.key = key;
            this.url = url;
            this.method = method;
            this.attributes = attributes;
            this.eventTime = eventTime;
        }
    }

    /* JADX INFO: compiled from: RumRawEvent.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$WaitForResourceTiming;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "key", "", "eventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "(Ljava/lang/Object;Lcom/datadog/android/rum/internal/domain/Time;)V", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "getKey", "()Ljava/lang/Object;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class WaitForResourceTiming extends RumRawEvent {
        private final Time eventTime;
        private final Object key;

        public static /* synthetic */ WaitForResourceTiming copy$default(WaitForResourceTiming waitForResourceTiming, Object obj, Time time, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = waitForResourceTiming.key;
            }
            if ((i & 2) != 0) {
                time = waitForResourceTiming.eventTime;
            }
            return waitForResourceTiming.copy(obj, time);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Object getKey() {
            return this.key;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Time getEventTime() {
            return this.eventTime;
        }

        public final WaitForResourceTiming copy(Object key, Time eventTime) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            return new WaitForResourceTiming(key, eventTime);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WaitForResourceTiming)) {
                return false;
            }
            WaitForResourceTiming waitForResourceTiming = (WaitForResourceTiming) other;
            return Intrinsics.areEqual(this.key, waitForResourceTiming.key) && Intrinsics.areEqual(this.eventTime, waitForResourceTiming.eventTime);
        }

        public int hashCode() {
            return (this.key.hashCode() * 31) + this.eventTime.hashCode();
        }

        public String toString() {
            return "WaitForResourceTiming(key=" + this.key + ", eventTime=" + this.eventTime + ")";
        }

        public final Object getKey() {
            return this.key;
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WaitForResourceTiming(Object key, Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.key = key;
            this.eventTime = eventTime;
        }
    }

    /* JADX INFO: compiled from: RumRawEvent.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$AddResourceTiming;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "key", "", "timing", "Lcom/datadog/android/rum/internal/domain/event/ResourceTiming;", "eventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "(Ljava/lang/Object;Lcom/datadog/android/rum/internal/domain/event/ResourceTiming;Lcom/datadog/android/rum/internal/domain/Time;)V", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "getKey", "()Ljava/lang/Object;", "getTiming", "()Lcom/datadog/android/rum/internal/domain/event/ResourceTiming;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class AddResourceTiming extends RumRawEvent {
        private final Time eventTime;
        private final Object key;
        private final ResourceTiming timing;

        public static /* synthetic */ AddResourceTiming copy$default(AddResourceTiming addResourceTiming, Object obj, ResourceTiming resourceTiming, Time time, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = addResourceTiming.key;
            }
            if ((i & 2) != 0) {
                resourceTiming = addResourceTiming.timing;
            }
            if ((i & 4) != 0) {
                time = addResourceTiming.eventTime;
            }
            return addResourceTiming.copy(obj, resourceTiming, time);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Object getKey() {
            return this.key;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ResourceTiming getTiming() {
            return this.timing;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Time getEventTime() {
            return this.eventTime;
        }

        public final AddResourceTiming copy(Object key, ResourceTiming timing, Time eventTime) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(timing, "timing");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            return new AddResourceTiming(key, timing, eventTime);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AddResourceTiming)) {
                return false;
            }
            AddResourceTiming addResourceTiming = (AddResourceTiming) other;
            return Intrinsics.areEqual(this.key, addResourceTiming.key) && Intrinsics.areEqual(this.timing, addResourceTiming.timing) && Intrinsics.areEqual(this.eventTime, addResourceTiming.eventTime);
        }

        public int hashCode() {
            return (((this.key.hashCode() * 31) + this.timing.hashCode()) * 31) + this.eventTime.hashCode();
        }

        public String toString() {
            return "AddResourceTiming(key=" + this.key + ", timing=" + this.timing + ", eventTime=" + this.eventTime + ")";
        }

        public final Object getKey() {
            return this.key;
        }

        public final ResourceTiming getTiming() {
            return this.timing;
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AddResourceTiming(Object key, ResourceTiming timing, Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(timing, "timing");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.key = key;
            this.timing = timing;
            this.eventTime = eventTime;
        }
    }

    /* JADX INFO: compiled from: RumRawEvent.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00030\n\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0018J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\u0017\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00030\nHÆ\u0003J\t\u0010 \u001a\u00020\rHÆ\u0003J\\\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00030\n2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0003HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u000bHÖ\u0001R\u001f\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00030\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001a\u0010\u0018¨\u0006)"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StopResource;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "key", "", "statusCode", "", ContentDisposition.Parameters.Size, "kind", "Lcom/datadog/android/rum/RumResourceKind;", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "", "", "eventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "(Ljava/lang/Object;Ljava/lang/Long;Ljava/lang/Long;Lcom/datadog/android/rum/RumResourceKind;Ljava/util/Map;Lcom/datadog/android/rum/internal/domain/Time;)V", "getAttributes", "()Ljava/util/Map;", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "getKey", "()Ljava/lang/Object;", "getKind", "()Lcom/datadog/android/rum/RumResourceKind;", "getSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getStatusCode", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Object;Ljava/lang/Long;Ljava/lang/Long;Lcom/datadog/android/rum/RumResourceKind;Ljava/util/Map;Lcom/datadog/android/rum/internal/domain/Time;)Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StopResource;", "equals", "", "other", "hashCode", "", "toString", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class StopResource extends RumRawEvent {
        private final Map<String, Object> attributes;
        private final Time eventTime;
        private final Object key;
        private final RumResourceKind kind;
        private final Long size;
        private final Long statusCode;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StopResource copy$default(StopResource stopResource, Object obj, Long l, Long l2, RumResourceKind rumResourceKind, Map map, Time time, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = stopResource.key;
            }
            if ((i & 2) != 0) {
                l = stopResource.statusCode;
            }
            if ((i & 4) != 0) {
                l2 = stopResource.size;
            }
            if ((i & 8) != 0) {
                rumResourceKind = stopResource.kind;
            }
            if ((i & 16) != 0) {
                map = stopResource.attributes;
            }
            if ((i & 32) != 0) {
                time = stopResource.eventTime;
            }
            Map map2 = map;
            Time time2 = time;
            return stopResource.copy(obj, l, l2, rumResourceKind, map2, time2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Object getKey() {
            return this.key;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Long getStatusCode() {
            return this.statusCode;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Long getSize() {
            return this.size;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final RumResourceKind getKind() {
            return this.kind;
        }

        public final Map<String, Object> component5() {
            return this.attributes;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Time getEventTime() {
            return this.eventTime;
        }

        public final StopResource copy(Object key, Long statusCode, Long size, RumResourceKind kind, Map<String, ? extends Object> attributes, Time eventTime) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(kind, "kind");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            return new StopResource(key, statusCode, size, kind, attributes, eventTime);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StopResource)) {
                return false;
            }
            StopResource stopResource = (StopResource) other;
            return Intrinsics.areEqual(this.key, stopResource.key) && Intrinsics.areEqual(this.statusCode, stopResource.statusCode) && Intrinsics.areEqual(this.size, stopResource.size) && this.kind == stopResource.kind && Intrinsics.areEqual(this.attributes, stopResource.attributes) && Intrinsics.areEqual(this.eventTime, stopResource.eventTime);
        }

        public int hashCode() {
            int iHashCode = this.key.hashCode() * 31;
            Long l = this.statusCode;
            int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
            Long l2 = this.size;
            return ((((((iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31) + this.kind.hashCode()) * 31) + this.attributes.hashCode()) * 31) + this.eventTime.hashCode();
        }

        public String toString() {
            return "StopResource(key=" + this.key + ", statusCode=" + this.statusCode + ", size=" + this.size + ", kind=" + this.kind + ", attributes=" + this.attributes + ", eventTime=" + this.eventTime + ")";
        }

        public final Object getKey() {
            return this.key;
        }

        public final Long getStatusCode() {
            return this.statusCode;
        }

        public final Long getSize() {
            return this.size;
        }

        public final RumResourceKind getKind() {
            return this.kind;
        }

        public final Map<String, Object> getAttributes() {
            return this.attributes;
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StopResource(Object key, Long l, Long l2, RumResourceKind kind, Map<String, ? extends Object> attributes, Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(kind, "kind");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.key = key;
            this.statusCode = l;
            this.size = l2;
            this.kind = kind;
            this.attributes = attributes;
            this.eventTime = eventTime;
        }
    }

    /* JADX INFO: compiled from: RumRawEvent.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00030\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001cJ\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003J\t\u0010$\u001a\u00020\u000bHÆ\u0003J\u0017\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00030\rHÆ\u0003J\t\u0010&\u001a\u00020\u000fHÆ\u0003Jd\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00030\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0003HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\t\u0010.\u001a\u00020\u0007HÖ\u0001R\u001f\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00030\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006/"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StopResourceWithError;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "key", "", "statusCode", "", "message", "", "source", "Lcom/datadog/android/rum/RumErrorSource;", RumFeature.EVENT_THROWABLE_PROPERTY, "", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "", "eventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "(Ljava/lang/Object;Ljava/lang/Long;Ljava/lang/String;Lcom/datadog/android/rum/RumErrorSource;Ljava/lang/Throwable;Ljava/util/Map;Lcom/datadog/android/rum/internal/domain/Time;)V", "getAttributes", "()Ljava/util/Map;", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "getKey", "()Ljava/lang/Object;", "getMessage", "()Ljava/lang/String;", "getSource", "()Lcom/datadog/android/rum/RumErrorSource;", "getStatusCode", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getThrowable", "()Ljava/lang/Throwable;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Object;Ljava/lang/Long;Ljava/lang/String;Lcom/datadog/android/rum/RumErrorSource;Ljava/lang/Throwable;Ljava/util/Map;Lcom/datadog/android/rum/internal/domain/Time;)Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StopResourceWithError;", "equals", "", "other", "hashCode", "", "toString", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class StopResourceWithError extends RumRawEvent {
        private final Map<String, Object> attributes;
        private final Time eventTime;
        private final Object key;
        private final String message;
        private final RumErrorSource source;
        private final Long statusCode;
        private final Throwable throwable;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StopResourceWithError copy$default(StopResourceWithError stopResourceWithError, Object obj, Long l, String str, RumErrorSource rumErrorSource, Throwable th, Map map, Time time, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = stopResourceWithError.key;
            }
            if ((i & 2) != 0) {
                l = stopResourceWithError.statusCode;
            }
            if ((i & 4) != 0) {
                str = stopResourceWithError.message;
            }
            if ((i & 8) != 0) {
                rumErrorSource = stopResourceWithError.source;
            }
            if ((i & 16) != 0) {
                th = stopResourceWithError.throwable;
            }
            if ((i & 32) != 0) {
                map = stopResourceWithError.attributes;
            }
            if ((i & 64) != 0) {
                time = stopResourceWithError.eventTime;
            }
            Map map2 = map;
            Time time2 = time;
            Throwable th2 = th;
            String str2 = str;
            return stopResourceWithError.copy(obj, l, str2, rumErrorSource, th2, map2, time2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Object getKey() {
            return this.key;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Long getStatusCode() {
            return this.statusCode;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final RumErrorSource getSource() {
            return this.source;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Throwable getThrowable() {
            return this.throwable;
        }

        public final Map<String, Object> component6() {
            return this.attributes;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Time getEventTime() {
            return this.eventTime;
        }

        public final StopResourceWithError copy(Object key, Long statusCode, String message, RumErrorSource source, Throwable throwable, Map<String, ? extends Object> attributes, Time eventTime) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            return new StopResourceWithError(key, statusCode, message, source, throwable, attributes, eventTime);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StopResourceWithError)) {
                return false;
            }
            StopResourceWithError stopResourceWithError = (StopResourceWithError) other;
            return Intrinsics.areEqual(this.key, stopResourceWithError.key) && Intrinsics.areEqual(this.statusCode, stopResourceWithError.statusCode) && Intrinsics.areEqual(this.message, stopResourceWithError.message) && this.source == stopResourceWithError.source && Intrinsics.areEqual(this.throwable, stopResourceWithError.throwable) && Intrinsics.areEqual(this.attributes, stopResourceWithError.attributes) && Intrinsics.areEqual(this.eventTime, stopResourceWithError.eventTime);
        }

        public int hashCode() {
            int iHashCode = this.key.hashCode() * 31;
            Long l = this.statusCode;
            return ((((((((((iHashCode + (l == null ? 0 : l.hashCode())) * 31) + this.message.hashCode()) * 31) + this.source.hashCode()) * 31) + this.throwable.hashCode()) * 31) + this.attributes.hashCode()) * 31) + this.eventTime.hashCode();
        }

        public String toString() {
            return "StopResourceWithError(key=" + this.key + ", statusCode=" + this.statusCode + ", message=" + this.message + ", source=" + this.source + ", throwable=" + this.throwable + ", attributes=" + this.attributes + ", eventTime=" + this.eventTime + ")";
        }

        public final Object getKey() {
            return this.key;
        }

        public final Long getStatusCode() {
            return this.statusCode;
        }

        public final String getMessage() {
            return this.message;
        }

        public final RumErrorSource getSource() {
            return this.source;
        }

        public final Throwable getThrowable() {
            return this.throwable;
        }

        public final Map<String, Object> getAttributes() {
            return this.attributes;
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StopResourceWithError(Object key, Long l, String message, RumErrorSource source, Throwable throwable, Map<String, ? extends Object> attributes, Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.key = key;
            this.statusCode = l;
            this.message = message;
            this.source = source;
            this.throwable = throwable;
            this.attributes = attributes;
            this.eventTime = eventTime;
        }
    }

    /* JADX INFO: compiled from: RumRawEvent.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00030\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001eJ\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0017\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00030\rHÆ\u0003J\t\u0010'\u001a\u00020\u000fHÆ\u0003Jp\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00030\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0003HÖ\u0003J\t\u0010-\u001a\u00020.HÖ\u0001J\t\u0010/\u001a\u00020\u0007HÖ\u0001R\u001f\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00030\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001e¨\u00060"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StopResourceWithStackTrace;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "key", "", "statusCode", "", "message", "", "source", "Lcom/datadog/android/rum/RumErrorSource;", "stackTrace", "errorType", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "", "eventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "(Ljava/lang/Object;Ljava/lang/Long;Ljava/lang/String;Lcom/datadog/android/rum/RumErrorSource;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/datadog/android/rum/internal/domain/Time;)V", "getAttributes", "()Ljava/util/Map;", "getErrorType", "()Ljava/lang/String;", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "getKey", "()Ljava/lang/Object;", "getMessage", "getSource", "()Lcom/datadog/android/rum/RumErrorSource;", "getStackTrace", "getStatusCode", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Object;Ljava/lang/Long;Ljava/lang/String;Lcom/datadog/android/rum/RumErrorSource;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/datadog/android/rum/internal/domain/Time;)Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StopResourceWithStackTrace;", "equals", "", "other", "hashCode", "", "toString", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class StopResourceWithStackTrace extends RumRawEvent {
        private final Map<String, Object> attributes;
        private final String errorType;
        private final Time eventTime;
        private final Object key;
        private final String message;
        private final RumErrorSource source;
        private final String stackTrace;
        private final Long statusCode;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StopResourceWithStackTrace copy$default(StopResourceWithStackTrace stopResourceWithStackTrace, Object obj, Long l, String str, RumErrorSource rumErrorSource, String str2, String str3, Map map, Time time, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = stopResourceWithStackTrace.key;
            }
            if ((i & 2) != 0) {
                l = stopResourceWithStackTrace.statusCode;
            }
            if ((i & 4) != 0) {
                str = stopResourceWithStackTrace.message;
            }
            if ((i & 8) != 0) {
                rumErrorSource = stopResourceWithStackTrace.source;
            }
            if ((i & 16) != 0) {
                str2 = stopResourceWithStackTrace.stackTrace;
            }
            if ((i & 32) != 0) {
                str3 = stopResourceWithStackTrace.errorType;
            }
            if ((i & 64) != 0) {
                map = stopResourceWithStackTrace.attributes;
            }
            if ((i & 128) != 0) {
                time = stopResourceWithStackTrace.eventTime;
            }
            Map map2 = map;
            Time time2 = time;
            String str4 = str2;
            String str5 = str3;
            return stopResourceWithStackTrace.copy(obj, l, str, rumErrorSource, str4, str5, map2, time2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Object getKey() {
            return this.key;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Long getStatusCode() {
            return this.statusCode;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final RumErrorSource getSource() {
            return this.source;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getStackTrace() {
            return this.stackTrace;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getErrorType() {
            return this.errorType;
        }

        public final Map<String, Object> component7() {
            return this.attributes;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Time getEventTime() {
            return this.eventTime;
        }

        public final StopResourceWithStackTrace copy(Object key, Long statusCode, String message, RumErrorSource source, String stackTrace, String errorType, Map<String, ? extends Object> attributes, Time eventTime) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(stackTrace, "stackTrace");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            return new StopResourceWithStackTrace(key, statusCode, message, source, stackTrace, errorType, attributes, eventTime);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StopResourceWithStackTrace)) {
                return false;
            }
            StopResourceWithStackTrace stopResourceWithStackTrace = (StopResourceWithStackTrace) other;
            return Intrinsics.areEqual(this.key, stopResourceWithStackTrace.key) && Intrinsics.areEqual(this.statusCode, stopResourceWithStackTrace.statusCode) && Intrinsics.areEqual(this.message, stopResourceWithStackTrace.message) && this.source == stopResourceWithStackTrace.source && Intrinsics.areEqual(this.stackTrace, stopResourceWithStackTrace.stackTrace) && Intrinsics.areEqual(this.errorType, stopResourceWithStackTrace.errorType) && Intrinsics.areEqual(this.attributes, stopResourceWithStackTrace.attributes) && Intrinsics.areEqual(this.eventTime, stopResourceWithStackTrace.eventTime);
        }

        public int hashCode() {
            int iHashCode = this.key.hashCode() * 31;
            Long l = this.statusCode;
            int iHashCode2 = (((((((iHashCode + (l == null ? 0 : l.hashCode())) * 31) + this.message.hashCode()) * 31) + this.source.hashCode()) * 31) + this.stackTrace.hashCode()) * 31;
            String str = this.errorType;
            return ((((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + this.attributes.hashCode()) * 31) + this.eventTime.hashCode();
        }

        public String toString() {
            return "StopResourceWithStackTrace(key=" + this.key + ", statusCode=" + this.statusCode + ", message=" + this.message + ", source=" + this.source + ", stackTrace=" + this.stackTrace + ", errorType=" + this.errorType + ", attributes=" + this.attributes + ", eventTime=" + this.eventTime + ")";
        }

        public final Object getKey() {
            return this.key;
        }

        public final Long getStatusCode() {
            return this.statusCode;
        }

        public final String getMessage() {
            return this.message;
        }

        public final RumErrorSource getSource() {
            return this.source;
        }

        public final String getStackTrace() {
            return this.stackTrace;
        }

        public final String getErrorType() {
            return this.errorType;
        }

        public final Map<String, Object> getAttributes() {
            return this.attributes;
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StopResourceWithStackTrace(Object key, Long l, String message, RumErrorSource source, String stackTrace, String str, Map<String, ? extends Object> attributes, Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(stackTrace, "stackTrace");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.key = key;
            this.statusCode = l;
            this.message = message;
            this.source = source;
            this.stackTrace = stackTrace;
            this.errorType = str;
            this.attributes = attributes;
            this.eventTime = eventTime;
        }
    }

    /* JADX INFO: compiled from: RumRawEvent.kt */
    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b%\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u007f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\r0\f\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010\u0018J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0015HÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0002\u0010*J\t\u00100\u001a\u00020\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00103\u001a\u00020\nHÆ\u0003J\u0017\u00104\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\r0\fHÆ\u0003J\u000f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fHÆ\u0003J\t\u00106\u001a\u00020\u0012HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0098\u0001\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\r0\f2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÆ\u0001¢\u0006\u0002\u00109J\u0013\u0010:\u001a\u00020\n2\b\u0010;\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010<\u001a\u00020=HÖ\u0001J\t\u0010>\u001a\u00020\u0003HÖ\u0001R\u001f\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0011\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001fR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u0010+\u001a\u0004\b)\u0010*R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001f¨\u0006?"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$AddError;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "message", "", "source", "Lcom/datadog/android/rum/RumErrorSource;", RumFeature.EVENT_THROWABLE_PROPERTY, "", "stacktrace", StackTraceHelper.IS_FATAL_KEY, "", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "", "", "threads", "", "Lcom/datadog/android/core/feature/event/ThreadDump;", "eventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "type", "sourceType", "Lcom/datadog/android/rum/internal/RumErrorSourceType;", "timeSinceAppStartNs", "", "(Ljava/lang/String;Lcom/datadog/android/rum/RumErrorSource;Ljava/lang/Throwable;Ljava/lang/String;ZLjava/util/Map;Ljava/util/List;Lcom/datadog/android/rum/internal/domain/Time;Ljava/lang/String;Lcom/datadog/android/rum/internal/RumErrorSourceType;Ljava/lang/Long;)V", "getAttributes", "()Ljava/util/Map;", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "()Z", "getMessage", "()Ljava/lang/String;", "getSource", "()Lcom/datadog/android/rum/RumErrorSource;", "getSourceType", "()Lcom/datadog/android/rum/internal/RumErrorSourceType;", "getStacktrace", "getThreads", "()Ljava/util/List;", "getThrowable", "()Ljava/lang/Throwable;", "getTimeSinceAppStartNs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getType", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Lcom/datadog/android/rum/RumErrorSource;Ljava/lang/Throwable;Ljava/lang/String;ZLjava/util/Map;Ljava/util/List;Lcom/datadog/android/rum/internal/domain/Time;Ljava/lang/String;Lcom/datadog/android/rum/internal/RumErrorSourceType;Ljava/lang/Long;)Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$AddError;", "equals", "other", "hashCode", "", "toString", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class AddError extends RumRawEvent {
        private final Map<String, Object> attributes;
        private final Time eventTime;
        private final boolean isFatal;
        private final String message;
        private final RumErrorSource source;
        private final RumErrorSourceType sourceType;
        private final String stacktrace;
        private final List<ThreadDump> threads;
        private final Throwable throwable;
        private final Long timeSinceAppStartNs;
        private final String type;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AddError copy$default(AddError addError, String str, RumErrorSource rumErrorSource, Throwable th, String str2, boolean z, Map map, List list, Time time, String str3, RumErrorSourceType rumErrorSourceType, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                str = addError.message;
            }
            if ((i & 2) != 0) {
                rumErrorSource = addError.source;
            }
            if ((i & 4) != 0) {
                th = addError.throwable;
            }
            if ((i & 8) != 0) {
                str2 = addError.stacktrace;
            }
            if ((i & 16) != 0) {
                z = addError.isFatal;
            }
            if ((i & 32) != 0) {
                map = addError.attributes;
            }
            if ((i & 64) != 0) {
                list = addError.threads;
            }
            if ((i & 128) != 0) {
                time = addError.eventTime;
            }
            if ((i & 256) != 0) {
                str3 = addError.type;
            }
            if ((i & 512) != 0) {
                rumErrorSourceType = addError.sourceType;
            }
            if ((i & 1024) != 0) {
                l = addError.timeSinceAppStartNs;
            }
            RumErrorSourceType rumErrorSourceType2 = rumErrorSourceType;
            Long l2 = l;
            Time time2 = time;
            String str4 = str3;
            Map map2 = map;
            List list2 = list;
            boolean z2 = z;
            Throwable th2 = th;
            return addError.copy(str, rumErrorSource, th2, str2, z2, map2, list2, time2, str4, rumErrorSourceType2, l2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final RumErrorSourceType getSourceType() {
            return this.sourceType;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final Long getTimeSinceAppStartNs() {
            return this.timeSinceAppStartNs;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final RumErrorSource getSource() {
            return this.source;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Throwable getThrowable() {
            return this.throwable;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getStacktrace() {
            return this.stacktrace;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getIsFatal() {
            return this.isFatal;
        }

        public final Map<String, Object> component6() {
            return this.attributes;
        }

        public final List<ThreadDump> component7() {
            return this.threads;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Time getEventTime() {
            return this.eventTime;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getType() {
            return this.type;
        }

        public final AddError copy(String message, RumErrorSource source, Throwable throwable, String stacktrace, boolean isFatal, Map<String, ? extends Object> attributes, List<ThreadDump> threads, Time eventTime, String type, RumErrorSourceType sourceType, Long timeSinceAppStartNs) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            Intrinsics.checkNotNullParameter(threads, "threads");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            Intrinsics.checkNotNullParameter(sourceType, "sourceType");
            return new AddError(message, source, throwable, stacktrace, isFatal, attributes, threads, eventTime, type, sourceType, timeSinceAppStartNs);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AddError)) {
                return false;
            }
            AddError addError = (AddError) other;
            return Intrinsics.areEqual(this.message, addError.message) && this.source == addError.source && Intrinsics.areEqual(this.throwable, addError.throwable) && Intrinsics.areEqual(this.stacktrace, addError.stacktrace) && this.isFatal == addError.isFatal && Intrinsics.areEqual(this.attributes, addError.attributes) && Intrinsics.areEqual(this.threads, addError.threads) && Intrinsics.areEqual(this.eventTime, addError.eventTime) && Intrinsics.areEqual(this.type, addError.type) && this.sourceType == addError.sourceType && Intrinsics.areEqual(this.timeSinceAppStartNs, addError.timeSinceAppStartNs);
        }

        public int hashCode() {
            int iHashCode = ((this.message.hashCode() * 31) + this.source.hashCode()) * 31;
            Throwable th = this.throwable;
            int iHashCode2 = (iHashCode + (th == null ? 0 : th.hashCode())) * 31;
            String str = this.stacktrace;
            int iHashCode3 = (((((((((iHashCode2 + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.isFatal)) * 31) + this.attributes.hashCode()) * 31) + this.threads.hashCode()) * 31) + this.eventTime.hashCode()) * 31;
            String str2 = this.type;
            int iHashCode4 = (((iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.sourceType.hashCode()) * 31;
            Long l = this.timeSinceAppStartNs;
            return iHashCode4 + (l != null ? l.hashCode() : 0);
        }

        public String toString() {
            return "AddError(message=" + this.message + ", source=" + this.source + ", throwable=" + this.throwable + ", stacktrace=" + this.stacktrace + ", isFatal=" + this.isFatal + ", attributes=" + this.attributes + ", threads=" + this.threads + ", eventTime=" + this.eventTime + ", type=" + this.type + ", sourceType=" + this.sourceType + ", timeSinceAppStartNs=" + this.timeSinceAppStartNs + ")";
        }

        public final String getMessage() {
            return this.message;
        }

        public final RumErrorSource getSource() {
            return this.source;
        }

        public final Throwable getThrowable() {
            return this.throwable;
        }

        public final String getStacktrace() {
            return this.stacktrace;
        }

        public final boolean isFatal() {
            return this.isFatal;
        }

        public final Map<String, Object> getAttributes() {
            return this.attributes;
        }

        public final List<ThreadDump> getThreads() {
            return this.threads;
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        public final String getType() {
            return this.type;
        }

        public /* synthetic */ AddError(String str, RumErrorSource rumErrorSource, Throwable th, String str2, boolean z, Map map, List list, Time time, String str3, RumErrorSourceType rumErrorSourceType, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, rumErrorSource, th, str2, z, map, list, time, (i & 256) != 0 ? null : str3, (i & 512) != 0 ? RumErrorSourceType.ANDROID : rumErrorSourceType, (i & 1024) != 0 ? null : l);
        }

        public final RumErrorSourceType getSourceType() {
            return this.sourceType;
        }

        public final Long getTimeSinceAppStartNs() {
            return this.timeSinceAppStartNs;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AddError(String message, RumErrorSource source, Throwable th, String str, boolean z, Map<String, ? extends Object> attributes, List<ThreadDump> threads, Time eventTime, String str2, RumErrorSourceType sourceType, Long l) {
            super(null);
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            Intrinsics.checkNotNullParameter(threads, "threads");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            Intrinsics.checkNotNullParameter(sourceType, "sourceType");
            this.message = message;
            this.source = source;
            this.throwable = th;
            this.stacktrace = str;
            this.isFatal = z;
            this.attributes = attributes;
            this.threads = threads;
            this.eventTime = eventTime;
            this.type = str2;
            this.sourceType = sourceType;
            this.timeSinceAppStartNs = l;
        }
    }

    /* JADX INFO: compiled from: RumRawEvent.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$ResourceSent;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", RumEventMeta.VIEW_ID_KEY, "", "resourceId", "resourceEndTimestampInNanos", "", "eventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "(Ljava/lang/String;Ljava/lang/String;JLcom/datadog/android/rum/internal/domain/Time;)V", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "getResourceEndTimestampInNanos", "()J", "getResourceId", "()Ljava/lang/String;", "getViewId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class ResourceSent extends RumRawEvent {
        private final Time eventTime;
        private final long resourceEndTimestampInNanos;
        private final String resourceId;
        private final String viewId;

        public static /* synthetic */ ResourceSent copy$default(ResourceSent resourceSent, String str, String str2, long j, Time time, int i, Object obj) {
            if ((i & 1) != 0) {
                str = resourceSent.viewId;
            }
            if ((i & 2) != 0) {
                str2 = resourceSent.resourceId;
            }
            if ((i & 4) != 0) {
                j = resourceSent.resourceEndTimestampInNanos;
            }
            if ((i & 8) != 0) {
                time = resourceSent.eventTime;
            }
            Time time2 = time;
            return resourceSent.copy(str, str2, j, time2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getViewId() {
            return this.viewId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getResourceId() {
            return this.resourceId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final long getResourceEndTimestampInNanos() {
            return this.resourceEndTimestampInNanos;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Time getEventTime() {
            return this.eventTime;
        }

        public final ResourceSent copy(String viewId, String resourceId, long resourceEndTimestampInNanos, Time eventTime) {
            Intrinsics.checkNotNullParameter(viewId, "viewId");
            Intrinsics.checkNotNullParameter(resourceId, "resourceId");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            return new ResourceSent(viewId, resourceId, resourceEndTimestampInNanos, eventTime);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ResourceSent)) {
                return false;
            }
            ResourceSent resourceSent = (ResourceSent) other;
            return Intrinsics.areEqual(this.viewId, resourceSent.viewId) && Intrinsics.areEqual(this.resourceId, resourceSent.resourceId) && this.resourceEndTimestampInNanos == resourceSent.resourceEndTimestampInNanos && Intrinsics.areEqual(this.eventTime, resourceSent.eventTime);
        }

        public int hashCode() {
            return (((((this.viewId.hashCode() * 31) + this.resourceId.hashCode()) * 31) + Long.hashCode(this.resourceEndTimestampInNanos)) * 31) + this.eventTime.hashCode();
        }

        public String toString() {
            return "ResourceSent(viewId=" + this.viewId + ", resourceId=" + this.resourceId + ", resourceEndTimestampInNanos=" + this.resourceEndTimestampInNanos + ", eventTime=" + this.eventTime + ")";
        }

        public final String getViewId() {
            return this.viewId;
        }

        public final String getResourceId() {
            return this.resourceId;
        }

        public final long getResourceEndTimestampInNanos() {
            return this.resourceEndTimestampInNanos;
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ResourceSent(String viewId, String resourceId, long j, Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(viewId, "viewId");
            Intrinsics.checkNotNullParameter(resourceId, "resourceId");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.viewId = viewId;
            this.resourceId = resourceId;
            this.resourceEndTimestampInNanos = j;
            this.eventTime = eventTime;
        }
    }

    /* JADX INFO: compiled from: RumRawEvent.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0080\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\u000bHÆ\u0003J;\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$ActionSent;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", RumEventMeta.VIEW_ID_KEY, "", "frustrationCount", "", "type", "Lcom/datadog/android/rum/model/ActionEvent$ActionEventActionType;", "eventEndTimestampInNanos", "", "eventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "(Ljava/lang/String;ILcom/datadog/android/rum/model/ActionEvent$ActionEventActionType;JLcom/datadog/android/rum/internal/domain/Time;)V", "getEventEndTimestampInNanos", "()J", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "getFrustrationCount", "()I", "getType", "()Lcom/datadog/android/rum/model/ActionEvent$ActionEventActionType;", "getViewId", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class ActionSent extends RumRawEvent {
        private final long eventEndTimestampInNanos;
        private final Time eventTime;
        private final int frustrationCount;
        private final ActionEvent.ActionEventActionType type;
        private final String viewId;

        public static /* synthetic */ ActionSent copy$default(ActionSent actionSent, String str, int i, ActionEvent.ActionEventActionType actionEventActionType, long j, Time time, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = actionSent.viewId;
            }
            if ((i2 & 2) != 0) {
                i = actionSent.frustrationCount;
            }
            if ((i2 & 4) != 0) {
                actionEventActionType = actionSent.type;
            }
            if ((i2 & 8) != 0) {
                j = actionSent.eventEndTimestampInNanos;
            }
            if ((i2 & 16) != 0) {
                time = actionSent.eventTime;
            }
            Time time2 = time;
            ActionEvent.ActionEventActionType actionEventActionType2 = actionEventActionType;
            return actionSent.copy(str, i, actionEventActionType2, j, time2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getViewId() {
            return this.viewId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getFrustrationCount() {
            return this.frustrationCount;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final ActionEvent.ActionEventActionType getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final long getEventEndTimestampInNanos() {
            return this.eventEndTimestampInNanos;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Time getEventTime() {
            return this.eventTime;
        }

        public final ActionSent copy(String viewId, int frustrationCount, ActionEvent.ActionEventActionType type, long eventEndTimestampInNanos, Time eventTime) {
            Intrinsics.checkNotNullParameter(viewId, "viewId");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            return new ActionSent(viewId, frustrationCount, type, eventEndTimestampInNanos, eventTime);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ActionSent)) {
                return false;
            }
            ActionSent actionSent = (ActionSent) other;
            return Intrinsics.areEqual(this.viewId, actionSent.viewId) && this.frustrationCount == actionSent.frustrationCount && this.type == actionSent.type && this.eventEndTimestampInNanos == actionSent.eventEndTimestampInNanos && Intrinsics.areEqual(this.eventTime, actionSent.eventTime);
        }

        public int hashCode() {
            return (((((((this.viewId.hashCode() * 31) + Integer.hashCode(this.frustrationCount)) * 31) + this.type.hashCode()) * 31) + Long.hashCode(this.eventEndTimestampInNanos)) * 31) + this.eventTime.hashCode();
        }

        public String toString() {
            return "ActionSent(viewId=" + this.viewId + ", frustrationCount=" + this.frustrationCount + ", type=" + this.type + ", eventEndTimestampInNanos=" + this.eventEndTimestampInNanos + ", eventTime=" + this.eventTime + ")";
        }

        public final String getViewId() {
            return this.viewId;
        }

        public final int getFrustrationCount() {
            return this.frustrationCount;
        }

        public final ActionEvent.ActionEventActionType getType() {
            return this.type;
        }

        public final long getEventEndTimestampInNanos() {
            return this.eventEndTimestampInNanos;
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ActionSent(String viewId, int i, ActionEvent.ActionEventActionType type, long j, Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(viewId, "viewId");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.viewId = viewId;
            this.frustrationCount = i;
            this.type = type;
            this.eventEndTimestampInNanos = j;
            this.eventTime = eventTime;
        }
    }

    /* JADX INFO: compiled from: RumRawEvent.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\rJ:\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$ErrorSent;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", RumEventMeta.VIEW_ID_KEY, "", "eventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "resourceId", "resourceEndTimestampInNanos", "", "(Ljava/lang/String;Lcom/datadog/android/rum/internal/domain/Time;Ljava/lang/String;Ljava/lang/Long;)V", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "getResourceEndTimestampInNanos", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getResourceId", "()Ljava/lang/String;", "getViewId", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Lcom/datadog/android/rum/internal/domain/Time;Ljava/lang/String;Ljava/lang/Long;)Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$ErrorSent;", "equals", "", "other", "", "hashCode", "", "toString", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class ErrorSent extends RumRawEvent {
        private final Time eventTime;
        private final Long resourceEndTimestampInNanos;
        private final String resourceId;
        private final String viewId;

        public static /* synthetic */ ErrorSent copy$default(ErrorSent errorSent, String str, Time time, String str2, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                str = errorSent.viewId;
            }
            if ((i & 2) != 0) {
                time = errorSent.eventTime;
            }
            if ((i & 4) != 0) {
                str2 = errorSent.resourceId;
            }
            if ((i & 8) != 0) {
                l = errorSent.resourceEndTimestampInNanos;
            }
            return errorSent.copy(str, time, str2, l);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getViewId() {
            return this.viewId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Time getEventTime() {
            return this.eventTime;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getResourceId() {
            return this.resourceId;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Long getResourceEndTimestampInNanos() {
            return this.resourceEndTimestampInNanos;
        }

        public final ErrorSent copy(String viewId, Time eventTime, String resourceId, Long resourceEndTimestampInNanos) {
            Intrinsics.checkNotNullParameter(viewId, "viewId");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            return new ErrorSent(viewId, eventTime, resourceId, resourceEndTimestampInNanos);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ErrorSent)) {
                return false;
            }
            ErrorSent errorSent = (ErrorSent) other;
            return Intrinsics.areEqual(this.viewId, errorSent.viewId) && Intrinsics.areEqual(this.eventTime, errorSent.eventTime) && Intrinsics.areEqual(this.resourceId, errorSent.resourceId) && Intrinsics.areEqual(this.resourceEndTimestampInNanos, errorSent.resourceEndTimestampInNanos);
        }

        public int hashCode() {
            int iHashCode = ((this.viewId.hashCode() * 31) + this.eventTime.hashCode()) * 31;
            String str = this.resourceId;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            Long l = this.resourceEndTimestampInNanos;
            return iHashCode2 + (l != null ? l.hashCode() : 0);
        }

        public String toString() {
            return "ErrorSent(viewId=" + this.viewId + ", eventTime=" + this.eventTime + ", resourceId=" + this.resourceId + ", resourceEndTimestampInNanos=" + this.resourceEndTimestampInNanos + ")";
        }

        public /* synthetic */ ErrorSent(String str, Time time, String str2, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, time, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : l);
        }

        public final String getViewId() {
            return this.viewId;
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        public final String getResourceId() {
            return this.resourceId;
        }

        public final Long getResourceEndTimestampInNanos() {
            return this.resourceEndTimestampInNanos;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ErrorSent(String viewId, Time eventTime, String str, Long l) {
            super(null);
            Intrinsics.checkNotNullParameter(viewId, "viewId");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.viewId = viewId;
            this.eventTime = eventTime;
            this.resourceId = str;
            this.resourceEndTimestampInNanos = l;
        }
    }

    /* JADX INFO: compiled from: RumRawEvent.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0007HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$LongTaskSent;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", RumEventMeta.VIEW_ID_KEY, "", "eventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "isFrozenFrame", "", "(Ljava/lang/String;Lcom/datadog/android/rum/internal/domain/Time;Z)V", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "()Z", "getViewId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class LongTaskSent extends RumRawEvent {
        private final Time eventTime;
        private final boolean isFrozenFrame;
        private final String viewId;

        public static /* synthetic */ LongTaskSent copy$default(LongTaskSent longTaskSent, String str, Time time, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = longTaskSent.viewId;
            }
            if ((i & 2) != 0) {
                time = longTaskSent.eventTime;
            }
            if ((i & 4) != 0) {
                z = longTaskSent.isFrozenFrame;
            }
            return longTaskSent.copy(str, time, z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getViewId() {
            return this.viewId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Time getEventTime() {
            return this.eventTime;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getIsFrozenFrame() {
            return this.isFrozenFrame;
        }

        public final LongTaskSent copy(String viewId, Time eventTime, boolean isFrozenFrame) {
            Intrinsics.checkNotNullParameter(viewId, "viewId");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            return new LongTaskSent(viewId, eventTime, isFrozenFrame);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LongTaskSent)) {
                return false;
            }
            LongTaskSent longTaskSent = (LongTaskSent) other;
            return Intrinsics.areEqual(this.viewId, longTaskSent.viewId) && Intrinsics.areEqual(this.eventTime, longTaskSent.eventTime) && this.isFrozenFrame == longTaskSent.isFrozenFrame;
        }

        public int hashCode() {
            return (((this.viewId.hashCode() * 31) + this.eventTime.hashCode()) * 31) + Boolean.hashCode(this.isFrozenFrame);
        }

        public String toString() {
            return "LongTaskSent(viewId=" + this.viewId + ", eventTime=" + this.eventTime + ", isFrozenFrame=" + this.isFrozenFrame + ")";
        }

        public /* synthetic */ LongTaskSent(String str, Time time, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, time, (i & 4) != 0 ? false : z);
        }

        public final String getViewId() {
            return this.viewId;
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        public final boolean isFrozenFrame() {
            return this.isFrozenFrame;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LongTaskSent(String viewId, Time eventTime, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(viewId, "viewId");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.viewId = viewId;
            this.eventTime = eventTime;
            this.isFrozenFrame = z;
        }
    }

    /* JADX INFO: compiled from: RumRawEvent.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$ResourceDropped;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", RumEventMeta.VIEW_ID_KEY, "", "resourceId", "eventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "(Ljava/lang/String;Ljava/lang/String;Lcom/datadog/android/rum/internal/domain/Time;)V", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "getResourceId", "()Ljava/lang/String;", "getViewId", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class ResourceDropped extends RumRawEvent {
        private final Time eventTime;
        private final String resourceId;
        private final String viewId;

        public static /* synthetic */ ResourceDropped copy$default(ResourceDropped resourceDropped, String str, String str2, Time time, int i, Object obj) {
            if ((i & 1) != 0) {
                str = resourceDropped.viewId;
            }
            if ((i & 2) != 0) {
                str2 = resourceDropped.resourceId;
            }
            if ((i & 4) != 0) {
                time = resourceDropped.eventTime;
            }
            return resourceDropped.copy(str, str2, time);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getViewId() {
            return this.viewId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getResourceId() {
            return this.resourceId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Time getEventTime() {
            return this.eventTime;
        }

        public final ResourceDropped copy(String viewId, String resourceId, Time eventTime) {
            Intrinsics.checkNotNullParameter(viewId, "viewId");
            Intrinsics.checkNotNullParameter(resourceId, "resourceId");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            return new ResourceDropped(viewId, resourceId, eventTime);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ResourceDropped)) {
                return false;
            }
            ResourceDropped resourceDropped = (ResourceDropped) other;
            return Intrinsics.areEqual(this.viewId, resourceDropped.viewId) && Intrinsics.areEqual(this.resourceId, resourceDropped.resourceId) && Intrinsics.areEqual(this.eventTime, resourceDropped.eventTime);
        }

        public int hashCode() {
            return (((this.viewId.hashCode() * 31) + this.resourceId.hashCode()) * 31) + this.eventTime.hashCode();
        }

        public String toString() {
            return "ResourceDropped(viewId=" + this.viewId + ", resourceId=" + this.resourceId + ", eventTime=" + this.eventTime + ")";
        }

        public final String getViewId() {
            return this.viewId;
        }

        public final String getResourceId() {
            return this.resourceId;
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ResourceDropped(String viewId, String resourceId, Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(viewId, "viewId");
            Intrinsics.checkNotNullParameter(resourceId, "resourceId");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.viewId = viewId;
            this.resourceId = resourceId;
            this.eventTime = eventTime;
        }
    }

    /* JADX INFO: compiled from: RumRawEvent.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$ActionDropped;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", RumEventMeta.VIEW_ID_KEY, "", "eventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "(Ljava/lang/String;Lcom/datadog/android/rum/internal/domain/Time;)V", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "getViewId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class ActionDropped extends RumRawEvent {
        private final Time eventTime;
        private final String viewId;

        public static /* synthetic */ ActionDropped copy$default(ActionDropped actionDropped, String str, Time time, int i, Object obj) {
            if ((i & 1) != 0) {
                str = actionDropped.viewId;
            }
            if ((i & 2) != 0) {
                time = actionDropped.eventTime;
            }
            return actionDropped.copy(str, time);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getViewId() {
            return this.viewId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Time getEventTime() {
            return this.eventTime;
        }

        public final ActionDropped copy(String viewId, Time eventTime) {
            Intrinsics.checkNotNullParameter(viewId, "viewId");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            return new ActionDropped(viewId, eventTime);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ActionDropped)) {
                return false;
            }
            ActionDropped actionDropped = (ActionDropped) other;
            return Intrinsics.areEqual(this.viewId, actionDropped.viewId) && Intrinsics.areEqual(this.eventTime, actionDropped.eventTime);
        }

        public int hashCode() {
            return (this.viewId.hashCode() * 31) + this.eventTime.hashCode();
        }

        public String toString() {
            return "ActionDropped(viewId=" + this.viewId + ", eventTime=" + this.eventTime + ")";
        }

        public final String getViewId() {
            return this.viewId;
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ActionDropped(String viewId, Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(viewId, "viewId");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.viewId = viewId;
            this.eventTime = eventTime;
        }
    }

    /* JADX INFO: compiled from: RumRawEvent.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$ErrorDropped;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", RumEventMeta.VIEW_ID_KEY, "", "eventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "resourceId", "(Ljava/lang/String;Lcom/datadog/android/rum/internal/domain/Time;Ljava/lang/String;)V", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "getResourceId", "()Ljava/lang/String;", "getViewId", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class ErrorDropped extends RumRawEvent {
        private final Time eventTime;
        private final String resourceId;
        private final String viewId;

        public static /* synthetic */ ErrorDropped copy$default(ErrorDropped errorDropped, String str, Time time, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = errorDropped.viewId;
            }
            if ((i & 2) != 0) {
                time = errorDropped.eventTime;
            }
            if ((i & 4) != 0) {
                str2 = errorDropped.resourceId;
            }
            return errorDropped.copy(str, time, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getViewId() {
            return this.viewId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Time getEventTime() {
            return this.eventTime;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getResourceId() {
            return this.resourceId;
        }

        public final ErrorDropped copy(String viewId, Time eventTime, String resourceId) {
            Intrinsics.checkNotNullParameter(viewId, "viewId");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            return new ErrorDropped(viewId, eventTime, resourceId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ErrorDropped)) {
                return false;
            }
            ErrorDropped errorDropped = (ErrorDropped) other;
            return Intrinsics.areEqual(this.viewId, errorDropped.viewId) && Intrinsics.areEqual(this.eventTime, errorDropped.eventTime) && Intrinsics.areEqual(this.resourceId, errorDropped.resourceId);
        }

        public int hashCode() {
            int iHashCode = ((this.viewId.hashCode() * 31) + this.eventTime.hashCode()) * 31;
            String str = this.resourceId;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "ErrorDropped(viewId=" + this.viewId + ", eventTime=" + this.eventTime + ", resourceId=" + this.resourceId + ")";
        }

        public /* synthetic */ ErrorDropped(String str, Time time, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, time, (i & 4) != 0 ? null : str2);
        }

        public final String getViewId() {
            return this.viewId;
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        public final String getResourceId() {
            return this.resourceId;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ErrorDropped(String viewId, Time eventTime, String str) {
            super(null);
            Intrinsics.checkNotNullParameter(viewId, "viewId");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.viewId = viewId;
            this.eventTime = eventTime;
            this.resourceId = str;
        }
    }

    /* JADX INFO: compiled from: RumRawEvent.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0007HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$LongTaskDropped;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", RumEventMeta.VIEW_ID_KEY, "", "eventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "isFrozenFrame", "", "(Ljava/lang/String;Lcom/datadog/android/rum/internal/domain/Time;Z)V", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "()Z", "getViewId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class LongTaskDropped extends RumRawEvent {
        private final Time eventTime;
        private final boolean isFrozenFrame;
        private final String viewId;

        public static /* synthetic */ LongTaskDropped copy$default(LongTaskDropped longTaskDropped, String str, Time time, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = longTaskDropped.viewId;
            }
            if ((i & 2) != 0) {
                time = longTaskDropped.eventTime;
            }
            if ((i & 4) != 0) {
                z = longTaskDropped.isFrozenFrame;
            }
            return longTaskDropped.copy(str, time, z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getViewId() {
            return this.viewId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Time getEventTime() {
            return this.eventTime;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getIsFrozenFrame() {
            return this.isFrozenFrame;
        }

        public final LongTaskDropped copy(String viewId, Time eventTime, boolean isFrozenFrame) {
            Intrinsics.checkNotNullParameter(viewId, "viewId");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            return new LongTaskDropped(viewId, eventTime, isFrozenFrame);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LongTaskDropped)) {
                return false;
            }
            LongTaskDropped longTaskDropped = (LongTaskDropped) other;
            return Intrinsics.areEqual(this.viewId, longTaskDropped.viewId) && Intrinsics.areEqual(this.eventTime, longTaskDropped.eventTime) && this.isFrozenFrame == longTaskDropped.isFrozenFrame;
        }

        public int hashCode() {
            return (((this.viewId.hashCode() * 31) + this.eventTime.hashCode()) * 31) + Boolean.hashCode(this.isFrozenFrame);
        }

        public String toString() {
            return "LongTaskDropped(viewId=" + this.viewId + ", eventTime=" + this.eventTime + ", isFrozenFrame=" + this.isFrozenFrame + ")";
        }

        public /* synthetic */ LongTaskDropped(String str, Time time, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, time, (i & 4) != 0 ? false : z);
        }

        public final String getViewId() {
            return this.viewId;
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        public final boolean isFrozenFrame() {
            return this.isFrozenFrame;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LongTaskDropped(String viewId, Time eventTime, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(viewId, "viewId");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.viewId = viewId;
            this.eventTime = eventTime;
            this.isFrozenFrame = z;
        }
    }

    /* JADX INFO: compiled from: RumRawEvent.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$ResetSession;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "eventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "(Lcom/datadog/android/rum/internal/domain/Time;)V", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class ResetSession extends RumRawEvent {
        private final Time eventTime;

        public static /* synthetic */ ResetSession copy$default(ResetSession resetSession, Time time, int i, Object obj) {
            if ((i & 1) != 0) {
                time = resetSession.eventTime;
            }
            return resetSession.copy(time);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Time getEventTime() {
            return this.eventTime;
        }

        public final ResetSession copy(Time eventTime) {
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            return new ResetSession(eventTime);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ResetSession) && Intrinsics.areEqual(this.eventTime, ((ResetSession) other).eventTime);
        }

        public int hashCode() {
            return this.eventTime.hashCode();
        }

        public String toString() {
            return "ResetSession(eventTime=" + this.eventTime + ")";
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ResetSession(Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.eventTime = eventTime;
        }
    }

    /* JADX INFO: compiled from: RumRawEvent.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$ApplicationStarted;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "applicationStartupNanos", "", "eventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "(JLcom/datadog/android/rum/internal/domain/Time;)V", "getApplicationStartupNanos", "()J", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class ApplicationStarted extends RumRawEvent {
        private final long applicationStartupNanos;
        private final Time eventTime;

        public static /* synthetic */ ApplicationStarted copy$default(ApplicationStarted applicationStarted, long j, Time time, int i, Object obj) {
            if ((i & 1) != 0) {
                j = applicationStarted.applicationStartupNanos;
            }
            if ((i & 2) != 0) {
                time = applicationStarted.eventTime;
            }
            return applicationStarted.copy(j, time);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getApplicationStartupNanos() {
            return this.applicationStartupNanos;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Time getEventTime() {
            return this.eventTime;
        }

        public final ApplicationStarted copy(long applicationStartupNanos, Time eventTime) {
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            return new ApplicationStarted(applicationStartupNanos, eventTime);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ApplicationStarted)) {
                return false;
            }
            ApplicationStarted applicationStarted = (ApplicationStarted) other;
            return this.applicationStartupNanos == applicationStarted.applicationStartupNanos && Intrinsics.areEqual(this.eventTime, applicationStarted.eventTime);
        }

        public int hashCode() {
            return (Long.hashCode(this.applicationStartupNanos) * 31) + this.eventTime.hashCode();
        }

        public String toString() {
            return "ApplicationStarted(applicationStartupNanos=" + this.applicationStartupNanos + ", eventTime=" + this.eventTime + ")";
        }

        public final long getApplicationStartupNanos() {
            return this.applicationStartupNanos;
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ApplicationStarted(long j, Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.applicationStartupNanos = j;
            this.eventTime = eventTime;
        }
    }

    /* JADX INFO: compiled from: RumRawEvent.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$AddCustomTiming;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "name", "", "eventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "(Ljava/lang/String;Lcom/datadog/android/rum/internal/domain/Time;)V", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class AddCustomTiming extends RumRawEvent {
        private final Time eventTime;
        private final String name;

        public static /* synthetic */ AddCustomTiming copy$default(AddCustomTiming addCustomTiming, String str, Time time, int i, Object obj) {
            if ((i & 1) != 0) {
                str = addCustomTiming.name;
            }
            if ((i & 2) != 0) {
                time = addCustomTiming.eventTime;
            }
            return addCustomTiming.copy(str, time);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Time getEventTime() {
            return this.eventTime;
        }

        public final AddCustomTiming copy(String name, Time eventTime) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            return new AddCustomTiming(name, eventTime);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AddCustomTiming)) {
                return false;
            }
            AddCustomTiming addCustomTiming = (AddCustomTiming) other;
            return Intrinsics.areEqual(this.name, addCustomTiming.name) && Intrinsics.areEqual(this.eventTime, addCustomTiming.eventTime);
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + this.eventTime.hashCode();
        }

        public String toString() {
            return "AddCustomTiming(name=" + this.name + ", eventTime=" + this.eventTime + ")";
        }

        public final String getName() {
            return this.name;
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AddCustomTiming(String name, Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.name = name;
            this.eventTime = eventTime;
        }
    }

    /* JADX INFO: compiled from: RumRawEvent.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$AddViewLoadingTime;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "overwrite", "", "eventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "(ZLcom/datadog/android/rum/internal/domain/Time;)V", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "getOverwrite", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class AddViewLoadingTime extends RumRawEvent {
        private final Time eventTime;
        private final boolean overwrite;

        public static /* synthetic */ AddViewLoadingTime copy$default(AddViewLoadingTime addViewLoadingTime, boolean z, Time time, int i, Object obj) {
            if ((i & 1) != 0) {
                z = addViewLoadingTime.overwrite;
            }
            if ((i & 2) != 0) {
                time = addViewLoadingTime.eventTime;
            }
            return addViewLoadingTime.copy(z, time);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getOverwrite() {
            return this.overwrite;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Time getEventTime() {
            return this.eventTime;
        }

        public final AddViewLoadingTime copy(boolean overwrite, Time eventTime) {
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            return new AddViewLoadingTime(overwrite, eventTime);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AddViewLoadingTime)) {
                return false;
            }
            AddViewLoadingTime addViewLoadingTime = (AddViewLoadingTime) other;
            return this.overwrite == addViewLoadingTime.overwrite && Intrinsics.areEqual(this.eventTime, addViewLoadingTime.eventTime);
        }

        public int hashCode() {
            return (Boolean.hashCode(this.overwrite) * 31) + this.eventTime.hashCode();
        }

        public String toString() {
            return "AddViewLoadingTime(overwrite=" + this.overwrite + ", eventTime=" + this.eventTime + ")";
        }

        public final boolean getOverwrite() {
            return this.overwrite;
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AddViewLoadingTime(boolean z, Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.overwrite = z;
            this.eventTime = eventTime;
        }
    }

    /* JADX INFO: compiled from: RumRawEvent.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B#\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0017\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0007HÆ\u0003J+\u0010\u000f\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0004HÖ\u0001R\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$AddViewAttributes;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "", "", "", "eventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "(Ljava/util/Map;Lcom/datadog/android/rum/internal/domain/Time;)V", "getAttributes", "()Ljava/util/Map;", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class AddViewAttributes extends RumRawEvent {
        private final Map<String, Object> attributes;
        private final Time eventTime;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AddViewAttributes copy$default(AddViewAttributes addViewAttributes, Map map, Time time, int i, Object obj) {
            if ((i & 1) != 0) {
                map = addViewAttributes.attributes;
            }
            if ((i & 2) != 0) {
                time = addViewAttributes.eventTime;
            }
            return addViewAttributes.copy(map, time);
        }

        public final Map<String, Object> component1() {
            return this.attributes;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Time getEventTime() {
            return this.eventTime;
        }

        public final AddViewAttributes copy(Map<String, ? extends Object> attributes, Time eventTime) {
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            return new AddViewAttributes(attributes, eventTime);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AddViewAttributes)) {
                return false;
            }
            AddViewAttributes addViewAttributes = (AddViewAttributes) other;
            return Intrinsics.areEqual(this.attributes, addViewAttributes.attributes) && Intrinsics.areEqual(this.eventTime, addViewAttributes.eventTime);
        }

        public int hashCode() {
            return (this.attributes.hashCode() * 31) + this.eventTime.hashCode();
        }

        public String toString() {
            return "AddViewAttributes(attributes=" + this.attributes + ", eventTime=" + this.eventTime + ")";
        }

        public final Map<String, Object> getAttributes() {
            return this.attributes;
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AddViewAttributes(Map<String, ? extends Object> attributes, Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.attributes = attributes;
            this.eventTime = eventTime;
        }
    }

    /* JADX INFO: compiled from: RumRawEvent.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$RemoveViewAttributes;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "", "", "eventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "(Ljava/util/Collection;Lcom/datadog/android/rum/internal/domain/Time;)V", "getAttributes", "()Ljava/util/Collection;", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class RemoveViewAttributes extends RumRawEvent {
        private final Collection<String> attributes;
        private final Time eventTime;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ RemoveViewAttributes copy$default(RemoveViewAttributes removeViewAttributes, Collection collection, Time time, int i, Object obj) {
            if ((i & 1) != 0) {
                collection = removeViewAttributes.attributes;
            }
            if ((i & 2) != 0) {
                time = removeViewAttributes.eventTime;
            }
            return removeViewAttributes.copy(collection, time);
        }

        public final Collection<String> component1() {
            return this.attributes;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Time getEventTime() {
            return this.eventTime;
        }

        public final RemoveViewAttributes copy(Collection<String> attributes, Time eventTime) {
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            return new RemoveViewAttributes(attributes, eventTime);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RemoveViewAttributes)) {
                return false;
            }
            RemoveViewAttributes removeViewAttributes = (RemoveViewAttributes) other;
            return Intrinsics.areEqual(this.attributes, removeViewAttributes.attributes) && Intrinsics.areEqual(this.eventTime, removeViewAttributes.eventTime);
        }

        public int hashCode() {
            return (this.attributes.hashCode() * 31) + this.eventTime.hashCode();
        }

        public String toString() {
            return "RemoveViewAttributes(attributes=" + this.attributes + ", eventTime=" + this.eventTime + ")";
        }

        public final Collection<String> getAttributes() {
            return this.attributes;
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RemoveViewAttributes(Collection<String> attributes, Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.attributes = attributes;
            this.eventTime = eventTime;
        }
    }

    /* JADX INFO: compiled from: RumRawEvent.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$AddLongTask;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "durationNs", "", TypedValues.Attributes.S_TARGET, "", "eventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "(JLjava/lang/String;Lcom/datadog/android/rum/internal/domain/Time;)V", "getDurationNs", "()J", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "getTarget", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class AddLongTask extends RumRawEvent {
        private final long durationNs;
        private final Time eventTime;
        private final String target;

        public static /* synthetic */ AddLongTask copy$default(AddLongTask addLongTask, long j, String str, Time time, int i, Object obj) {
            if ((i & 1) != 0) {
                j = addLongTask.durationNs;
            }
            if ((i & 2) != 0) {
                str = addLongTask.target;
            }
            if ((i & 4) != 0) {
                time = addLongTask.eventTime;
            }
            return addLongTask.copy(j, str, time);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getDurationNs() {
            return this.durationNs;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTarget() {
            return this.target;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Time getEventTime() {
            return this.eventTime;
        }

        public final AddLongTask copy(long durationNs, String target, Time eventTime) {
            Intrinsics.checkNotNullParameter(target, "target");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            return new AddLongTask(durationNs, target, eventTime);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AddLongTask)) {
                return false;
            }
            AddLongTask addLongTask = (AddLongTask) other;
            return this.durationNs == addLongTask.durationNs && Intrinsics.areEqual(this.target, addLongTask.target) && Intrinsics.areEqual(this.eventTime, addLongTask.eventTime);
        }

        public int hashCode() {
            return (((Long.hashCode(this.durationNs) * 31) + this.target.hashCode()) * 31) + this.eventTime.hashCode();
        }

        public String toString() {
            return "AddLongTask(durationNs=" + this.durationNs + ", target=" + this.target + ", eventTime=" + this.eventTime + ")";
        }

        public final long getDurationNs() {
            return this.durationNs;
        }

        public final String getTarget() {
            return this.target;
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AddLongTask(long j, String target, Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(target, "target");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.durationNs = j;
            this.target = target;
            this.eventTime = eventTime;
        }
    }

    /* JADX INFO: compiled from: RumRawEvent.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$SendCustomActionNow;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "eventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "(Lcom/datadog/android/rum/internal/domain/Time;)V", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class SendCustomActionNow extends RumRawEvent {
        private final Time eventTime;

        public static /* synthetic */ SendCustomActionNow copy$default(SendCustomActionNow sendCustomActionNow, Time time, int i, Object obj) {
            if ((i & 1) != 0) {
                time = sendCustomActionNow.eventTime;
            }
            return sendCustomActionNow.copy(time);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Time getEventTime() {
            return this.eventTime;
        }

        public final SendCustomActionNow copy(Time eventTime) {
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            return new SendCustomActionNow(eventTime);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof SendCustomActionNow) && Intrinsics.areEqual(this.eventTime, ((SendCustomActionNow) other).eventTime);
        }

        public int hashCode() {
            return this.eventTime.hashCode();
        }

        public String toString() {
            return "SendCustomActionNow(eventTime=" + this.eventTime + ")";
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SendCustomActionNow(Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.eventTime = eventTime;
        }
    }

    /* JADX INFO: compiled from: RumRawEvent.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$AddFeatureFlagEvaluation;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "name", "", "value", "", "eventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "(Ljava/lang/String;Ljava/lang/Object;Lcom/datadog/android/rum/internal/domain/Time;)V", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "getName", "()Ljava/lang/String;", "getValue", "()Ljava/lang/Object;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class AddFeatureFlagEvaluation extends RumRawEvent {
        private final Time eventTime;
        private final String name;
        private final Object value;

        public static /* synthetic */ AddFeatureFlagEvaluation copy$default(AddFeatureFlagEvaluation addFeatureFlagEvaluation, String str, Object obj, Time time, int i, Object obj2) {
            if ((i & 1) != 0) {
                str = addFeatureFlagEvaluation.name;
            }
            if ((i & 2) != 0) {
                obj = addFeatureFlagEvaluation.value;
            }
            if ((i & 4) != 0) {
                time = addFeatureFlagEvaluation.eventTime;
            }
            return addFeatureFlagEvaluation.copy(str, obj, time);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Object getValue() {
            return this.value;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Time getEventTime() {
            return this.eventTime;
        }

        public final AddFeatureFlagEvaluation copy(String name, Object value, Time eventTime) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            return new AddFeatureFlagEvaluation(name, value, eventTime);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AddFeatureFlagEvaluation)) {
                return false;
            }
            AddFeatureFlagEvaluation addFeatureFlagEvaluation = (AddFeatureFlagEvaluation) other;
            return Intrinsics.areEqual(this.name, addFeatureFlagEvaluation.name) && Intrinsics.areEqual(this.value, addFeatureFlagEvaluation.value) && Intrinsics.areEqual(this.eventTime, addFeatureFlagEvaluation.eventTime);
        }

        public int hashCode() {
            return (((this.name.hashCode() * 31) + this.value.hashCode()) * 31) + this.eventTime.hashCode();
        }

        public String toString() {
            return "AddFeatureFlagEvaluation(name=" + this.name + ", value=" + this.value + ", eventTime=" + this.eventTime + ")";
        }

        public final String getName() {
            return this.name;
        }

        public final Object getValue() {
            return this.value;
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AddFeatureFlagEvaluation(String name, Object value, Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.name = name;
            this.value = value;
            this.eventTime = eventTime;
        }
    }

    /* JADX INFO: compiled from: RumRawEvent.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B!\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0015\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0007HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0004HÖ\u0001R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$AddFeatureFlagEvaluations;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "featureFlags", "", "", "", "eventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "(Ljava/util/Map;Lcom/datadog/android/rum/internal/domain/Time;)V", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "getFeatureFlags", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class AddFeatureFlagEvaluations extends RumRawEvent {
        private final Time eventTime;
        private final Map<String, Object> featureFlags;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AddFeatureFlagEvaluations copy$default(AddFeatureFlagEvaluations addFeatureFlagEvaluations, Map map, Time time, int i, Object obj) {
            if ((i & 1) != 0) {
                map = addFeatureFlagEvaluations.featureFlags;
            }
            if ((i & 2) != 0) {
                time = addFeatureFlagEvaluations.eventTime;
            }
            return addFeatureFlagEvaluations.copy(map, time);
        }

        public final Map<String, Object> component1() {
            return this.featureFlags;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Time getEventTime() {
            return this.eventTime;
        }

        public final AddFeatureFlagEvaluations copy(Map<String, ? extends Object> featureFlags, Time eventTime) {
            Intrinsics.checkNotNullParameter(featureFlags, "featureFlags");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            return new AddFeatureFlagEvaluations(featureFlags, eventTime);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AddFeatureFlagEvaluations)) {
                return false;
            }
            AddFeatureFlagEvaluations addFeatureFlagEvaluations = (AddFeatureFlagEvaluations) other;
            return Intrinsics.areEqual(this.featureFlags, addFeatureFlagEvaluations.featureFlags) && Intrinsics.areEqual(this.eventTime, addFeatureFlagEvaluations.eventTime);
        }

        public int hashCode() {
            return (this.featureFlags.hashCode() * 31) + this.eventTime.hashCode();
        }

        public String toString() {
            return "AddFeatureFlagEvaluations(featureFlags=" + this.featureFlags + ", eventTime=" + this.eventTime + ")";
        }

        public final Map<String, Object> getFeatureFlags() {
            return this.featureFlags;
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AddFeatureFlagEvaluations(Map<String, ? extends Object> featureFlags, Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(featureFlags, "featureFlags");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.featureFlags = featureFlags;
            this.eventTime = eventTime;
        }
    }

    /* JADX INFO: compiled from: RumRawEvent.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StopSession;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "eventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "(Lcom/datadog/android/rum/internal/domain/Time;)V", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class StopSession extends RumRawEvent {
        private final Time eventTime;

        public static /* synthetic */ StopSession copy$default(StopSession stopSession, Time time, int i, Object obj) {
            if ((i & 1) != 0) {
                time = stopSession.eventTime;
            }
            return stopSession.copy(time);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Time getEventTime() {
            return this.eventTime;
        }

        public final StopSession copy(Time eventTime) {
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            return new StopSession(eventTime);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof StopSession) && Intrinsics.areEqual(this.eventTime, ((StopSession) other).eventTime);
        }

        public int hashCode() {
            return this.eventTime.hashCode();
        }

        public String toString() {
            return "StopSession(eventTime=" + this.eventTime + ")";
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StopSession(Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.eventTime = eventTime;
        }
    }

    /* JADX INFO: compiled from: RumRawEvent.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$UpdatePerformanceMetric;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "metric", "Lcom/datadog/android/rum/RumPerformanceMetric;", "value", "", "eventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "(Lcom/datadog/android/rum/RumPerformanceMetric;DLcom/datadog/android/rum/internal/domain/Time;)V", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "getMetric", "()Lcom/datadog/android/rum/RumPerformanceMetric;", "getValue", "()D", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class UpdatePerformanceMetric extends RumRawEvent {
        private final Time eventTime;
        private final RumPerformanceMetric metric;
        private final double value;

        public static /* synthetic */ UpdatePerformanceMetric copy$default(UpdatePerformanceMetric updatePerformanceMetric, RumPerformanceMetric rumPerformanceMetric, double d, Time time, int i, Object obj) {
            if ((i & 1) != 0) {
                rumPerformanceMetric = updatePerformanceMetric.metric;
            }
            if ((i & 2) != 0) {
                d = updatePerformanceMetric.value;
            }
            if ((i & 4) != 0) {
                time = updatePerformanceMetric.eventTime;
            }
            return updatePerformanceMetric.copy(rumPerformanceMetric, d, time);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final RumPerformanceMetric getMetric() {
            return this.metric;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final double getValue() {
            return this.value;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Time getEventTime() {
            return this.eventTime;
        }

        public final UpdatePerformanceMetric copy(RumPerformanceMetric metric, double value, Time eventTime) {
            Intrinsics.checkNotNullParameter(metric, "metric");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            return new UpdatePerformanceMetric(metric, value, eventTime);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdatePerformanceMetric)) {
                return false;
            }
            UpdatePerformanceMetric updatePerformanceMetric = (UpdatePerformanceMetric) other;
            return this.metric == updatePerformanceMetric.metric && Double.compare(this.value, updatePerformanceMetric.value) == 0 && Intrinsics.areEqual(this.eventTime, updatePerformanceMetric.eventTime);
        }

        public int hashCode() {
            return (((this.metric.hashCode() * 31) + Double.hashCode(this.value)) * 31) + this.eventTime.hashCode();
        }

        public String toString() {
            return "UpdatePerformanceMetric(metric=" + this.metric + ", value=" + this.value + ", eventTime=" + this.eventTime + ")";
        }

        public final RumPerformanceMetric getMetric() {
            return this.metric;
        }

        public final double getValue() {
            return this.value;
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UpdatePerformanceMetric(RumPerformanceMetric metric, double d, Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(metric, "metric");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.metric = metric;
            this.value = d;
            this.eventTime = eventTime;
        }
    }

    /* JADX INFO: compiled from: RumRawEvent.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$UpdateExternalRefreshRate;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "frameTimeSeconds", "", "eventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "(DLcom/datadog/android/rum/internal/domain/Time;)V", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "getFrameTimeSeconds", "()D", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class UpdateExternalRefreshRate extends RumRawEvent {
        private final Time eventTime;
        private final double frameTimeSeconds;

        public static /* synthetic */ UpdateExternalRefreshRate copy$default(UpdateExternalRefreshRate updateExternalRefreshRate, double d, Time time, int i, Object obj) {
            if ((i & 1) != 0) {
                d = updateExternalRefreshRate.frameTimeSeconds;
            }
            if ((i & 2) != 0) {
                time = updateExternalRefreshRate.eventTime;
            }
            return updateExternalRefreshRate.copy(d, time);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final double getFrameTimeSeconds() {
            return this.frameTimeSeconds;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Time getEventTime() {
            return this.eventTime;
        }

        public final UpdateExternalRefreshRate copy(double frameTimeSeconds, Time eventTime) {
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            return new UpdateExternalRefreshRate(frameTimeSeconds, eventTime);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdateExternalRefreshRate)) {
                return false;
            }
            UpdateExternalRefreshRate updateExternalRefreshRate = (UpdateExternalRefreshRate) other;
            return Double.compare(this.frameTimeSeconds, updateExternalRefreshRate.frameTimeSeconds) == 0 && Intrinsics.areEqual(this.eventTime, updateExternalRefreshRate.eventTime);
        }

        public int hashCode() {
            return (Double.hashCode(this.frameTimeSeconds) * 31) + this.eventTime.hashCode();
        }

        public String toString() {
            return "UpdateExternalRefreshRate(frameTimeSeconds=" + this.frameTimeSeconds + ", eventTime=" + this.eventTime + ")";
        }

        public final double getFrameTimeSeconds() {
            return this.frameTimeSeconds;
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UpdateExternalRefreshRate(double d, Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.frameTimeSeconds = d;
            this.eventTime = eventTime;
        }
    }

    /* JADX INFO: compiled from: RumRawEvent.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$SetInternalViewAttribute;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "key", "", "value", "", "eventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "(Ljava/lang/String;Ljava/lang/Object;Lcom/datadog/android/rum/internal/domain/Time;)V", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "getKey", "()Ljava/lang/String;", "getValue", "()Ljava/lang/Object;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class SetInternalViewAttribute extends RumRawEvent {
        private final Time eventTime;
        private final String key;
        private final Object value;

        public static /* synthetic */ SetInternalViewAttribute copy$default(SetInternalViewAttribute setInternalViewAttribute, String str, Object obj, Time time, int i, Object obj2) {
            if ((i & 1) != 0) {
                str = setInternalViewAttribute.key;
            }
            if ((i & 2) != 0) {
                obj = setInternalViewAttribute.value;
            }
            if ((i & 4) != 0) {
                time = setInternalViewAttribute.eventTime;
            }
            return setInternalViewAttribute.copy(str, obj, time);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getKey() {
            return this.key;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Object getValue() {
            return this.value;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Time getEventTime() {
            return this.eventTime;
        }

        public final SetInternalViewAttribute copy(String key, Object value, Time eventTime) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            return new SetInternalViewAttribute(key, value, eventTime);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SetInternalViewAttribute)) {
                return false;
            }
            SetInternalViewAttribute setInternalViewAttribute = (SetInternalViewAttribute) other;
            return Intrinsics.areEqual(this.key, setInternalViewAttribute.key) && Intrinsics.areEqual(this.value, setInternalViewAttribute.value) && Intrinsics.areEqual(this.eventTime, setInternalViewAttribute.eventTime);
        }

        public int hashCode() {
            int iHashCode = this.key.hashCode() * 31;
            Object obj = this.value;
            return ((iHashCode + (obj == null ? 0 : obj.hashCode())) * 31) + this.eventTime.hashCode();
        }

        public String toString() {
            return "SetInternalViewAttribute(key=" + this.key + ", value=" + this.value + ", eventTime=" + this.eventTime + ")";
        }

        public final String getKey() {
            return this.key;
        }

        public final Object getValue() {
            return this.value;
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SetInternalViewAttribute(String key, Object obj, Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.key = key;
            this.value = obj;
            this.eventTime = eventTime;
        }
    }

    /* JADX INFO: compiled from: RumRawEvent.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$SetSyntheticsTestAttribute;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "testId", "", "resultId", "eventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "(Ljava/lang/String;Ljava/lang/String;Lcom/datadog/android/rum/internal/domain/Time;)V", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "getResultId", "()Ljava/lang/String;", "getTestId", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class SetSyntheticsTestAttribute extends RumRawEvent {
        private final Time eventTime;
        private final String resultId;
        private final String testId;

        public static /* synthetic */ SetSyntheticsTestAttribute copy$default(SetSyntheticsTestAttribute setSyntheticsTestAttribute, String str, String str2, Time time, int i, Object obj) {
            if ((i & 1) != 0) {
                str = setSyntheticsTestAttribute.testId;
            }
            if ((i & 2) != 0) {
                str2 = setSyntheticsTestAttribute.resultId;
            }
            if ((i & 4) != 0) {
                time = setSyntheticsTestAttribute.eventTime;
            }
            return setSyntheticsTestAttribute.copy(str, str2, time);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTestId() {
            return this.testId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getResultId() {
            return this.resultId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Time getEventTime() {
            return this.eventTime;
        }

        public final SetSyntheticsTestAttribute copy(String testId, String resultId, Time eventTime) {
            Intrinsics.checkNotNullParameter(testId, "testId");
            Intrinsics.checkNotNullParameter(resultId, "resultId");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            return new SetSyntheticsTestAttribute(testId, resultId, eventTime);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SetSyntheticsTestAttribute)) {
                return false;
            }
            SetSyntheticsTestAttribute setSyntheticsTestAttribute = (SetSyntheticsTestAttribute) other;
            return Intrinsics.areEqual(this.testId, setSyntheticsTestAttribute.testId) && Intrinsics.areEqual(this.resultId, setSyntheticsTestAttribute.resultId) && Intrinsics.areEqual(this.eventTime, setSyntheticsTestAttribute.eventTime);
        }

        public int hashCode() {
            return (((this.testId.hashCode() * 31) + this.resultId.hashCode()) * 31) + this.eventTime.hashCode();
        }

        public String toString() {
            return "SetSyntheticsTestAttribute(testId=" + this.testId + ", resultId=" + this.resultId + ", eventTime=" + this.eventTime + ")";
        }

        public final String getTestId() {
            return this.testId;
        }

        public final String getResultId() {
            return this.resultId;
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SetSyntheticsTestAttribute(String testId, String resultId, Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(testId, "testId");
            Intrinsics.checkNotNullParameter(resultId, "resultId");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.testId = testId;
            this.resultId = resultId;
            this.eventTime = eventTime;
        }
    }

    /* JADX INFO: compiled from: RumRawEvent.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$WebViewEvent;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "eventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "(Lcom/datadog/android/rum/internal/domain/Time;)V", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class WebViewEvent extends RumRawEvent {
        private final Time eventTime;

        public static /* synthetic */ WebViewEvent copy$default(WebViewEvent webViewEvent, Time time, int i, Object obj) {
            if ((i & 1) != 0) {
                time = webViewEvent.eventTime;
            }
            return webViewEvent.copy(time);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Time getEventTime() {
            return this.eventTime;
        }

        public final WebViewEvent copy(Time eventTime) {
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            return new WebViewEvent(eventTime);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof WebViewEvent) && Intrinsics.areEqual(this.eventTime, ((WebViewEvent) other).eventTime);
        }

        public int hashCode() {
            return this.eventTime.hashCode();
        }

        public String toString() {
            return "WebViewEvent(eventTime=" + this.eventTime + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WebViewEvent(Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.eventTime = eventTime;
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }
    }

    /* JADX INFO: compiled from: RumRawEvent.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$TelemetryEventWrapper;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "event", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent;", "eventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "(Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent;Lcom/datadog/android/rum/internal/domain/Time;)V", "getEvent", "()Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent;", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class TelemetryEventWrapper extends RumRawEvent {
        private final InternalTelemetryEvent event;
        private final Time eventTime;

        public static /* synthetic */ TelemetryEventWrapper copy$default(TelemetryEventWrapper telemetryEventWrapper, InternalTelemetryEvent internalTelemetryEvent, Time time, int i, Object obj) {
            if ((i & 1) != 0) {
                internalTelemetryEvent = telemetryEventWrapper.event;
            }
            if ((i & 2) != 0) {
                time = telemetryEventWrapper.eventTime;
            }
            return telemetryEventWrapper.copy(internalTelemetryEvent, time);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final InternalTelemetryEvent getEvent() {
            return this.event;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Time getEventTime() {
            return this.eventTime;
        }

        public final TelemetryEventWrapper copy(InternalTelemetryEvent event, Time eventTime) {
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            return new TelemetryEventWrapper(event, eventTime);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TelemetryEventWrapper)) {
                return false;
            }
            TelemetryEventWrapper telemetryEventWrapper = (TelemetryEventWrapper) other;
            return Intrinsics.areEqual(this.event, telemetryEventWrapper.event) && Intrinsics.areEqual(this.eventTime, telemetryEventWrapper.eventTime);
        }

        public int hashCode() {
            return (this.event.hashCode() * 31) + this.eventTime.hashCode();
        }

        public String toString() {
            return "TelemetryEventWrapper(event=" + this.event + ", eventTime=" + this.eventTime + ")";
        }

        public final InternalTelemetryEvent getEvent() {
            return this.event;
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TelemetryEventWrapper(InternalTelemetryEvent event, Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.event = event;
            this.eventTime = eventTime;
        }
    }

    /* JADX INFO: compiled from: RumRawEvent.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$SdkInit;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "isAppInForeground", "", "eventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "(ZLcom/datadog/android/rum/internal/domain/Time;)V", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class SdkInit extends RumRawEvent {
        private final Time eventTime;
        private final boolean isAppInForeground;

        public static /* synthetic */ SdkInit copy$default(SdkInit sdkInit, boolean z, Time time, int i, Object obj) {
            if ((i & 1) != 0) {
                z = sdkInit.isAppInForeground;
            }
            if ((i & 2) != 0) {
                time = sdkInit.eventTime;
            }
            return sdkInit.copy(z, time);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsAppInForeground() {
            return this.isAppInForeground;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Time getEventTime() {
            return this.eventTime;
        }

        public final SdkInit copy(boolean isAppInForeground, Time eventTime) {
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            return new SdkInit(isAppInForeground, eventTime);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SdkInit)) {
                return false;
            }
            SdkInit sdkInit = (SdkInit) other;
            return this.isAppInForeground == sdkInit.isAppInForeground && Intrinsics.areEqual(this.eventTime, sdkInit.eventTime);
        }

        public int hashCode() {
            return (Boolean.hashCode(this.isAppInForeground) * 31) + this.eventTime.hashCode();
        }

        public String toString() {
            return "SdkInit(isAppInForeground=" + this.isAppInForeground + ", eventTime=" + this.eventTime + ")";
        }

        public final boolean isAppInForeground() {
            return this.isAppInForeground;
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SdkInit(boolean z, Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.isAppInForeground = z;
            this.eventTime = eventTime;
        }
    }

    /* JADX INFO: compiled from: RumRawEvent.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\tHÆ\u0003JA\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001f\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StartOperation;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "name", "", "operationKey", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "", "", "eventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/datadog/android/rum/internal/domain/Time;)V", "getAttributes", "()Ljava/util/Map;", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "getName", "()Ljava/lang/String;", "getOperationKey", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class StartOperation extends RumRawEvent {
        private final Map<String, Object> attributes;
        private final Time eventTime;
        private final String name;
        private final String operationKey;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StartOperation copy$default(StartOperation startOperation, String str, String str2, Map map, Time time, int i, Object obj) {
            if ((i & 1) != 0) {
                str = startOperation.name;
            }
            if ((i & 2) != 0) {
                str2 = startOperation.operationKey;
            }
            if ((i & 4) != 0) {
                map = startOperation.attributes;
            }
            if ((i & 8) != 0) {
                time = startOperation.eventTime;
            }
            return startOperation.copy(str, str2, map, time);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getOperationKey() {
            return this.operationKey;
        }

        public final Map<String, Object> component3() {
            return this.attributes;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Time getEventTime() {
            return this.eventTime;
        }

        public final StartOperation copy(String name, String operationKey, Map<String, ? extends Object> attributes, Time eventTime) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            return new StartOperation(name, operationKey, attributes, eventTime);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StartOperation)) {
                return false;
            }
            StartOperation startOperation = (StartOperation) other;
            return Intrinsics.areEqual(this.name, startOperation.name) && Intrinsics.areEqual(this.operationKey, startOperation.operationKey) && Intrinsics.areEqual(this.attributes, startOperation.attributes) && Intrinsics.areEqual(this.eventTime, startOperation.eventTime);
        }

        public int hashCode() {
            int iHashCode = this.name.hashCode() * 31;
            String str = this.operationKey;
            return ((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.attributes.hashCode()) * 31) + this.eventTime.hashCode();
        }

        public String toString() {
            return "StartOperation(name=" + this.name + ", operationKey=" + this.operationKey + ", attributes=" + this.attributes + ", eventTime=" + this.eventTime + ")";
        }

        public final String getName() {
            return this.name;
        }

        public final String getOperationKey() {
            return this.operationKey;
        }

        public final Map<String, Object> getAttributes() {
            return this.attributes;
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StartOperation(String name, String str, Map<String, ? extends Object> attributes, Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.name = name;
            this.operationKey = str;
            this.attributes = attributes;
            this.eventTime = eventTime;
        }
    }

    /* JADX INFO: compiled from: RumRawEvent.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u000bHÆ\u0003JM\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u001f\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014¨\u0006\""}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StopOperation;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "name", "", "operationKey", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "", "", "eventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "failureReason", "Lcom/datadog/android/rum/operations/FailureReason;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/datadog/android/rum/internal/domain/Time;Lcom/datadog/android/rum/operations/FailureReason;)V", "getAttributes", "()Ljava/util/Map;", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "getFailureReason", "()Lcom/datadog/android/rum/operations/FailureReason;", "getName", "()Ljava/lang/String;", "getOperationKey", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class StopOperation extends RumRawEvent {
        private final Map<String, Object> attributes;
        private final Time eventTime;
        private final FailureReason failureReason;
        private final String name;
        private final String operationKey;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StopOperation copy$default(StopOperation stopOperation, String str, String str2, Map map, Time time, FailureReason failureReason, int i, Object obj) {
            if ((i & 1) != 0) {
                str = stopOperation.name;
            }
            if ((i & 2) != 0) {
                str2 = stopOperation.operationKey;
            }
            if ((i & 4) != 0) {
                map = stopOperation.attributes;
            }
            if ((i & 8) != 0) {
                time = stopOperation.eventTime;
            }
            if ((i & 16) != 0) {
                failureReason = stopOperation.failureReason;
            }
            FailureReason failureReason2 = failureReason;
            Map map2 = map;
            return stopOperation.copy(str, str2, map2, time, failureReason2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getOperationKey() {
            return this.operationKey;
        }

        public final Map<String, Object> component3() {
            return this.attributes;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Time getEventTime() {
            return this.eventTime;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final FailureReason getFailureReason() {
            return this.failureReason;
        }

        public final StopOperation copy(String name, String operationKey, Map<String, ? extends Object> attributes, Time eventTime, FailureReason failureReason) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            return new StopOperation(name, operationKey, attributes, eventTime, failureReason);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StopOperation)) {
                return false;
            }
            StopOperation stopOperation = (StopOperation) other;
            return Intrinsics.areEqual(this.name, stopOperation.name) && Intrinsics.areEqual(this.operationKey, stopOperation.operationKey) && Intrinsics.areEqual(this.attributes, stopOperation.attributes) && Intrinsics.areEqual(this.eventTime, stopOperation.eventTime) && this.failureReason == stopOperation.failureReason;
        }

        public int hashCode() {
            int iHashCode = this.name.hashCode() * 31;
            String str = this.operationKey;
            int iHashCode2 = (((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.attributes.hashCode()) * 31) + this.eventTime.hashCode()) * 31;
            FailureReason failureReason = this.failureReason;
            return iHashCode2 + (failureReason != null ? failureReason.hashCode() : 0);
        }

        public String toString() {
            return "StopOperation(name=" + this.name + ", operationKey=" + this.operationKey + ", attributes=" + this.attributes + ", eventTime=" + this.eventTime + ", failureReason=" + this.failureReason + ")";
        }

        public /* synthetic */ StopOperation(String str, String str2, Map map, Time time, FailureReason failureReason, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, map, time, (i & 16) != 0 ? null : failureReason);
        }

        public final String getName() {
            return this.name;
        }

        public final String getOperationKey() {
            return this.operationKey;
        }

        public final Map<String, Object> getAttributes() {
            return this.attributes;
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        public final FailureReason getFailureReason() {
            return this.failureReason;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StopOperation(String name, String str, Map<String, ? extends Object> attributes, Time eventTime, FailureReason failureReason) {
            super(null);
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.name = name;
            this.operationKey = str;
            this.attributes = attributes;
            this.eventTime = eventTime;
            this.failureReason = failureReason;
        }
    }

    /* JADX INFO: compiled from: RumRawEvent.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$AppStartEvent;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", RumAppStartupTelemetryReporterImpl.KEY_SCENARIO, "Lcom/datadog/android/rum/internal/startup/RumStartupScenario;", "eventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "(Lcom/datadog/android/rum/internal/startup/RumStartupScenario;Lcom/datadog/android/rum/internal/domain/Time;)V", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "getScenario", "()Lcom/datadog/android/rum/internal/startup/RumStartupScenario;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AppStartEvent extends RumRawEvent {
        private final Time eventTime;
        private final RumStartupScenario scenario;

        public final RumStartupScenario getScenario() {
            return this.scenario;
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AppStartEvent(RumStartupScenario scenario, Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(scenario, "scenario");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.scenario = scenario;
            this.eventTime = eventTime;
        }
    }

    /* JADX INFO: compiled from: RumRawEvent.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$AppStartTTIDEvent;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "info", "Lcom/datadog/android/rum/internal/startup/RumTTIDInfo;", "eventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "(Lcom/datadog/android/rum/internal/startup/RumTTIDInfo;Lcom/datadog/android/rum/internal/domain/Time;)V", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "getInfo", "()Lcom/datadog/android/rum/internal/startup/RumTTIDInfo;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AppStartTTIDEvent extends RumRawEvent {
        private final Time eventTime;
        private final RumTTIDInfo info;

        public final RumTTIDInfo getInfo() {
            return this.info;
        }

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AppStartTTIDEvent(RumTTIDInfo info, Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.info = info;
            this.eventTime = eventTime;
        }
    }

    /* JADX INFO: compiled from: RumRawEvent.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$AppStartTTFDEvent;", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "eventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "(Lcom/datadog/android/rum/internal/domain/Time;)V", "getEventTime", "()Lcom/datadog/android/rum/internal/domain/Time;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AppStartTTFDEvent extends RumRawEvent {
        private final Time eventTime;

        @Override // com.datadog.android.rum.internal.domain.scope.RumRawEvent
        public Time getEventTime() {
            return this.eventTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AppStartTTFDEvent(Time eventTime) {
            super(null);
            Intrinsics.checkNotNullParameter(eventTime, "eventTime");
            this.eventTime = eventTime;
        }
    }
}
