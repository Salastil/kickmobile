package com.datadog.android.rum.internal.domain.scope;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.context.DeviceInfo;
import com.datadog.android.api.context.DeviceType;
import com.datadog.android.api.context.NetworkInfo;
import com.datadog.android.rum.RumActionType;
import com.datadog.android.rum.RumErrorSource;
import com.datadog.android.rum.RumResourceKind;
import com.datadog.android.rum.RumResourceMethod;
import com.datadog.android.rum.internal.RumErrorSourceType;
import com.datadog.android.rum.internal.domain.battery.BatteryInfo;
import com.datadog.android.rum.internal.domain.display.DisplayInfo;
import com.datadog.android.rum.internal.domain.event.ResourceTiming;
import com.datadog.android.rum.internal.startup.RumStartupScenario;
import com.datadog.android.rum.model.ActionEvent;
import com.datadog.android.rum.model.ErrorEvent;
import com.datadog.android.rum.model.LongTaskEvent;
import com.datadog.android.rum.model.ResourceEvent;
import com.datadog.android.rum.model.TimeseriesCpuEvent;
import com.datadog.android.rum.model.TimeseriesMemoryEvent;
import com.datadog.android.rum.model.ViewEvent;
import com.datadog.android.rum.model.VitalAppLaunchEvent;
import com.datadog.android.rum.model.VitalOperationStepEvent;
import com.datadog.android.rum.operations.FailureReason;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RumEventExt.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000°\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0002\u001a\u0004\u0018\u00010\u0003*\u00020\u0004H\u0000\u001a\u000e\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u0004H\u0000\u001a\u000e\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\u0004H\u0000\u001a\u000e\u0010\t\u001a\u0004\u0018\u00010\n*\u00020\u0004H\u0000\u001a\f\u0010\u000b\u001a\u00020\f*\u00020\rH\u0000\u001a\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f*\u00020\u0010H\u0000¢\u0006\u0002\u0010\u0011\u001a\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013*\u00020\u0010H\u0000¢\u0006\u0002\u0010\u0014\u001a\u000e\u0010\u0015\u001a\u0004\u0018\u00010\u0016*\u00020\u0004H\u0000\u001a\f\u0010\u0017\u001a\u00020\u0018*\u00020\rH\u0000\u001a\f\u0010\u0019\u001a\u00020\u001a*\u00020\u001bH\u0000\u001a\f\u0010\u001c\u001a\u00020\u001d*\u00020\u001eH\u0000\u001a\f\u0010\u001f\u001a\u00020 *\u00020\rH\u0000\u001a\f\u0010!\u001a\u00020\"*\u00020\rH\u0000\u001a\f\u0010#\u001a\u00020$*\u00020%H\u0000\u001a\f\u0010&\u001a\u00020'*\u00020\u001bH\u0000\u001a\f\u0010(\u001a\u00020)*\u00020\u001eH\u0000\u001a\f\u0010*\u001a\u00020+*\u00020\rH\u0000\u001a\f\u0010,\u001a\u00020-*\u00020\u001bH\u0000\u001a\f\u0010.\u001a\u00020/*\u00020\u001eH\u0000\u001a\u0016\u00100\u001a\u0004\u0018\u000101*\u00020\u00012\u0006\u00102\u001a\u000203H\u0000\u001a\f\u00104\u001a\u000205*\u00020\rH\u0000\u001a\f\u00106\u001a\u000207*\u00020%H\u0000\u001a\f\u00108\u001a\u000209*\u00020\u001bH\u0000\u001a\f\u0010:\u001a\u00020;*\u00020\u001eH\u0000\u001a\f\u0010<\u001a\u00020=*\u00020>H\u0000\u001a\f\u0010?\u001a\u00020@*\u00020AH\u0000\u001a\f\u0010B\u001a\u00020C*\u00020DH\u0000\u001a\f\u0010E\u001a\u00020F*\u00020GH\u0000\u001a\f\u0010E\u001a\u00020H*\u00020IH\u0000\u001a\u001c\u0010J\u001a\u00020K*\u00020L2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020PH\u0000\u001a\f\u0010Q\u001a\u00020R*\u00020LH\u0000\u001a\f\u0010S\u001a\u00020T*\u00020\u001bH\u0000\u001a\f\u0010U\u001a\u00020V*\u00020\u001eH\u0000\u001a\u001c\u0010W\u001a\u00020X*\u00020L2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020PH\u0000\u001a\f\u0010Y\u001a\u00020Z*\u00020LH\u0000\u001a\f\u0010[\u001a\u00020\\*\u00020\u001bH\u0000\u001a\f\u0010]\u001a\u00020^*\u00020\u001eH\u0000\u001a\f\u0010_\u001a\u00020`*\u00020\rH\u0000\u001a\f\u0010a\u001a\u00020b*\u00020\u001bH\u0000\u001a\f\u0010c\u001a\u00020d*\u00020\u001eH\u0000\u001a\f\u0010e\u001a\u00020f*\u00020\u001bH\u0000\u001a\f\u0010g\u001a\u00020h*\u00020\u001eH\u0000\u001a\f\u0010i\u001a\u00020j*\u00020kH\u0000\u001a\f\u0010l\u001a\u00020m*\u00020\rH\u0000\u001a\f\u0010n\u001a\u00020o*\u00020\u001bH\u0000\u001a\f\u0010p\u001a\u00020q*\u00020\u001eH\u0000\u001a\u001e\u0010r\u001a\u0004\u0018\u00010s*\u00020t2\u0006\u0010u\u001a\u00020\u00012\u0006\u00102\u001a\u000203H\u0000\u001a\u001e\u0010r\u001a\u0004\u0018\u00010v*\u00020w2\u0006\u0010u\u001a\u00020\u00012\u0006\u00102\u001a\u000203H\u0000\u001a\u001e\u0010r\u001a\u0004\u0018\u00010x*\u00020y2\u0006\u0010u\u001a\u00020\u00012\u0006\u00102\u001a\u000203H\u0000\u001a\u001e\u0010r\u001a\u0004\u0018\u00010z*\u00020{2\u0006\u0010u\u001a\u00020\u00012\u0006\u00102\u001a\u000203H\u0000\u001a\u001e\u0010r\u001a\u0004\u0018\u00010|*\u00020}2\u0006\u0010u\u001a\u00020\u00012\u0006\u00102\u001a\u000203H\u0000\u001a\u001e\u0010r\u001a\u0004\u0018\u00010~*\u00020\u007f2\u0006\u0010u\u001a\u00020\u00012\u0006\u00102\u001a\u000203H\u0000\u001a \u0010r\u001a\u0005\u0018\u00010\u0080\u0001*\u00030\u0081\u00012\u0006\u0010u\u001a\u00020\u00012\u0006\u00102\u001a\u000203H\u0000\u001a \u0010r\u001a\u0005\u0018\u00010\u0082\u0001*\u00030\u0083\u00012\u0006\u0010u\u001a\u00020\u00012\u0006\u00102\u001a\u000203H\u0000\u001a \u0010r\u001a\u0005\u0018\u00010\u0084\u0001*\u00030\u0085\u00012\u0006\u0010u\u001a\u00020\u00012\u0006\u00102\u001a\u000203H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0086\u0001"}, d2 = {"UNKNOWN_SOURCE_WARNING_MESSAGE_FORMAT", "", "connect", "Lcom/datadog/android/rum/model/ResourceEvent$Connect;", "Lcom/datadog/android/rum/internal/domain/event/ResourceTiming;", "dns", "Lcom/datadog/android/rum/model/ResourceEvent$Dns;", "download", "Lcom/datadog/android/rum/model/ResourceEvent$Download;", "firstByte", "Lcom/datadog/android/rum/model/ResourceEvent$FirstByte;", "isConnected", "", "Lcom/datadog/android/api/context/NetworkInfo;", "resolveSessionReplaySampleRate", "", "Lcom/datadog/android/api/context/DatadogContext;", "(Lcom/datadog/android/api/context/DatadogContext;)Ljava/lang/Long;", "resolveTraceSampleRate", "", "(Lcom/datadog/android/api/context/DatadogContext;)Ljava/lang/Float;", "ssl", "Lcom/datadog/android/rum/model/ResourceEvent$Ssl;", "toActionConnectivity", "Lcom/datadog/android/rum/model/ActionEvent$Connectivity;", "toActionSchemaType", "Lcom/datadog/android/rum/model/ActionEvent$DeviceType;", "Lcom/datadog/android/api/context/DeviceType;", "toActionSessionPrecondition", "Lcom/datadog/android/rum/model/ActionEvent$SessionPrecondition;", "Lcom/datadog/android/rum/internal/domain/scope/RumSessionScope$StartReason;", "toAppLaunchVitalConnectivity", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$Connectivity;", "toErrorConnectivity", "Lcom/datadog/android/rum/model/ErrorEvent$Connectivity;", "toErrorMethod", "Lcom/datadog/android/rum/model/ErrorEvent$Method;", "Lcom/datadog/android/rum/RumResourceMethod;", "toErrorSchemaType", "Lcom/datadog/android/rum/model/ErrorEvent$DeviceType;", "toErrorSessionPrecondition", "Lcom/datadog/android/rum/model/ErrorEvent$SessionPrecondition;", "toLongTaskConnectivity", "Lcom/datadog/android/rum/model/LongTaskEvent$Connectivity;", "toLongTaskSchemaType", "Lcom/datadog/android/rum/model/LongTaskEvent$DeviceType;", "toLongTaskSessionPrecondition", "Lcom/datadog/android/rum/model/LongTaskEvent$SessionPrecondition;", "toOperationType", "Lcom/datadog/android/rum/model/ResourceEvent$OperationType;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "toResourceConnectivity", "Lcom/datadog/android/rum/model/ResourceEvent$Connectivity;", "toResourceMethod", "Lcom/datadog/android/rum/model/ResourceEvent$Method;", "toResourceSchemaType", "Lcom/datadog/android/rum/model/ResourceEvent$DeviceType;", "toResourceSessionPrecondition", "Lcom/datadog/android/rum/model/ResourceEvent$SessionPrecondition;", "toSchemaFailureReason", "Lcom/datadog/android/rum/model/VitalOperationStepEvent$FailureReason;", "Lcom/datadog/android/rum/operations/FailureReason;", "toSchemaSource", "Lcom/datadog/android/rum/model/ErrorEvent$ErrorSource;", "Lcom/datadog/android/rum/RumErrorSource;", "toSchemaSourceType", "Lcom/datadog/android/rum/model/ErrorEvent$SourceType;", "Lcom/datadog/android/rum/internal/RumErrorSourceType;", "toSchemaType", "Lcom/datadog/android/rum/model/ActionEvent$ActionEventActionType;", "Lcom/datadog/android/rum/RumActionType;", "Lcom/datadog/android/rum/model/ResourceEvent$ResourceType;", "Lcom/datadog/android/rum/RumResourceKind;", "toTimeseriesCpuDevice", "Lcom/datadog/android/rum/model/TimeseriesCpuEvent$Device;", "Lcom/datadog/android/api/context/DeviceInfo;", "batteryInfo", "Lcom/datadog/android/rum/internal/domain/battery/BatteryInfo;", "displayInfo", "Lcom/datadog/android/rum/internal/domain/display/DisplayInfo;", "toTimeseriesCpuOs", "Lcom/datadog/android/rum/model/TimeseriesCpuEvent$Os;", "toTimeseriesCpuSchemaType", "Lcom/datadog/android/rum/model/TimeseriesCpuEvent$DeviceType;", "toTimeseriesCpuSessionPrecondition", "Lcom/datadog/android/rum/model/TimeseriesCpuEvent$SessionPrecondition;", "toTimeseriesMemoryDevice", "Lcom/datadog/android/rum/model/TimeseriesMemoryEvent$Device;", "toTimeseriesMemoryOs", "Lcom/datadog/android/rum/model/TimeseriesMemoryEvent$Os;", "toTimeseriesMemorySchemaType", "Lcom/datadog/android/rum/model/TimeseriesMemoryEvent$DeviceType;", "toTimeseriesMemorySessionPrecondition", "Lcom/datadog/android/rum/model/TimeseriesMemoryEvent$SessionPrecondition;", "toViewConnectivity", "Lcom/datadog/android/rum/model/ViewEvent$Connectivity;", "toViewSchemaType", "Lcom/datadog/android/rum/model/ViewEvent$DeviceType;", "toViewSessionPrecondition", "Lcom/datadog/android/rum/model/ViewEvent$SessionPrecondition;", "toVitalAppLaunchSchemaType", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$DeviceType;", "toVitalAppLaunchSessionPrecondition", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$SessionPrecondition;", "toVitalAppLaunchStartupType", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$StartupType;", "Lcom/datadog/android/rum/internal/startup/RumStartupScenario;", "toVitalOperationStepConnectivity", "Lcom/datadog/android/rum/model/VitalOperationStepEvent$Connectivity;", "toVitalOperationStepSchemaType", "Lcom/datadog/android/rum/model/VitalOperationStepEvent$DeviceType;", "toVitalOperationStepSessionPrecondition", "Lcom/datadog/android/rum/model/VitalOperationStepEvent$SessionPrecondition;", "tryFromSource", "Lcom/datadog/android/rum/model/ActionEvent$ActionEventSource;", "Lcom/datadog/android/rum/model/ActionEvent$ActionEventSource$Companion;", "source", "Lcom/datadog/android/rum/model/ErrorEvent$ErrorEventSource;", "Lcom/datadog/android/rum/model/ErrorEvent$ErrorEventSource$Companion;", "Lcom/datadog/android/rum/model/LongTaskEvent$LongTaskEventSource;", "Lcom/datadog/android/rum/model/LongTaskEvent$LongTaskEventSource$Companion;", "Lcom/datadog/android/rum/model/ResourceEvent$ResourceEventSource;", "Lcom/datadog/android/rum/model/ResourceEvent$ResourceEventSource$Companion;", "Lcom/datadog/android/rum/model/TimeseriesCpuEvent$Source;", "Lcom/datadog/android/rum/model/TimeseriesCpuEvent$Source$Companion;", "Lcom/datadog/android/rum/model/TimeseriesMemoryEvent$Source;", "Lcom/datadog/android/rum/model/TimeseriesMemoryEvent$Source$Companion;", "Lcom/datadog/android/rum/model/ViewEvent$ViewEventSource;", "Lcom/datadog/android/rum/model/ViewEvent$ViewEventSource$Companion;", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$VitalAppLaunchEventSource;", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent$VitalAppLaunchEventSource$Companion;", "Lcom/datadog/android/rum/model/VitalOperationStepEvent$VitalOperationStepEventSource;", "Lcom/datadog/android/rum/model/VitalOperationStepEvent$VitalOperationStepEventSource$Companion;", "dd-sdk-android-rum_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RumEventExtKt {
    public static final String UNKNOWN_SOURCE_WARNING_MESSAGE_FORMAT = "You are using an unknown source %s for your events";

    /* JADX INFO: compiled from: RumEventExt.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;
        public static final /* synthetic */ int[] $EnumSwitchMapping$5;
        public static final /* synthetic */ int[] $EnumSwitchMapping$6;
        public static final /* synthetic */ int[] $EnumSwitchMapping$7;
        public static final /* synthetic */ int[] $EnumSwitchMapping$8;

        static {
            int[] iArr = new int[RumResourceMethod.values().length];
            try {
                iArr[RumResourceMethod.GET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RumResourceMethod.POST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RumResourceMethod.HEAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[RumResourceMethod.PUT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[RumResourceMethod.DELETE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[RumResourceMethod.PATCH.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[RumResourceMethod.TRACE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[RumResourceMethod.OPTIONS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[RumResourceMethod.CONNECT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[RumResourceKind.values().length];
            try {
                iArr2[RumResourceKind.BEACON.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[RumResourceKind.FETCH.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[RumResourceKind.XHR.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr2[RumResourceKind.DOCUMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr2[RumResourceKind.IMAGE.ordinal()] = 5;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr2[RumResourceKind.JS.ordinal()] = 6;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr2[RumResourceKind.FONT.ordinal()] = 7;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr2[RumResourceKind.CSS.ordinal()] = 8;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr2[RumResourceKind.MEDIA.ordinal()] = 9;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr2[RumResourceKind.NATIVE.ordinal()] = 10;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr2[RumResourceKind.UNKNOWN.ordinal()] = 11;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr2[RumResourceKind.OTHER.ordinal()] = 12;
            } catch (NoSuchFieldError unused21) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[RumErrorSource.values().length];
            try {
                iArr3[RumErrorSource.NETWORK.ordinal()] = 1;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr3[RumErrorSource.SOURCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr3[RumErrorSource.CONSOLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr3[RumErrorSource.LOGGER.ordinal()] = 4;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr3[RumErrorSource.AGENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr3[RumErrorSource.WEBVIEW.ordinal()] = 6;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr3[RumErrorSource.CUSTOM.ordinal()] = 7;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr3[RumErrorSource.REPORT.ordinal()] = 8;
            } catch (NoSuchFieldError unused29) {
            }
            $EnumSwitchMapping$2 = iArr3;
            int[] iArr4 = new int[RumErrorSourceType.values().length];
            try {
                iArr4[RumErrorSourceType.ANDROID.ordinal()] = 1;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                iArr4[RumErrorSourceType.BROWSER.ordinal()] = 2;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                iArr4[RumErrorSourceType.REACT_NATIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                iArr4[RumErrorSourceType.FLUTTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                iArr4[RumErrorSourceType.NDK.ordinal()] = 5;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                iArr4[RumErrorSourceType.NDK_IL2CPP.ordinal()] = 6;
            } catch (NoSuchFieldError unused35) {
            }
            $EnumSwitchMapping$3 = iArr4;
            int[] iArr5 = new int[RumActionType.values().length];
            try {
                iArr5[RumActionType.TAP.ordinal()] = 1;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                iArr5[RumActionType.SCROLL.ordinal()] = 2;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                iArr5[RumActionType.SWIPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                iArr5[RumActionType.CLICK.ordinal()] = 4;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                iArr5[RumActionType.BACK.ordinal()] = 5;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                iArr5[RumActionType.CUSTOM.ordinal()] = 6;
            } catch (NoSuchFieldError unused41) {
            }
            $EnumSwitchMapping$4 = iArr5;
            int[] iArr6 = new int[NetworkInfo.Connectivity.values().length];
            try {
                iArr6[NetworkInfo.Connectivity.NETWORK_ETHERNET.ordinal()] = 1;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                iArr6[NetworkInfo.Connectivity.NETWORK_WIFI.ordinal()] = 2;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                iArr6[NetworkInfo.Connectivity.NETWORK_WIMAX.ordinal()] = 3;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                iArr6[NetworkInfo.Connectivity.NETWORK_BLUETOOTH.ordinal()] = 4;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                iArr6[NetworkInfo.Connectivity.NETWORK_2G.ordinal()] = 5;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                iArr6[NetworkInfo.Connectivity.NETWORK_3G.ordinal()] = 6;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                iArr6[NetworkInfo.Connectivity.NETWORK_4G.ordinal()] = 7;
            } catch (NoSuchFieldError unused48) {
            }
            try {
                iArr6[NetworkInfo.Connectivity.NETWORK_5G.ordinal()] = 8;
            } catch (NoSuchFieldError unused49) {
            }
            try {
                iArr6[NetworkInfo.Connectivity.NETWORK_MOBILE_OTHER.ordinal()] = 9;
            } catch (NoSuchFieldError unused50) {
            }
            try {
                iArr6[NetworkInfo.Connectivity.NETWORK_CELLULAR.ordinal()] = 10;
            } catch (NoSuchFieldError unused51) {
            }
            try {
                iArr6[NetworkInfo.Connectivity.NETWORK_OTHER.ordinal()] = 11;
            } catch (NoSuchFieldError unused52) {
            }
            try {
                iArr6[NetworkInfo.Connectivity.NETWORK_NOT_CONNECTED.ordinal()] = 12;
            } catch (NoSuchFieldError unused53) {
            }
            $EnumSwitchMapping$5 = iArr6;
            int[] iArr7 = new int[DeviceType.values().length];
            try {
                iArr7[DeviceType.MOBILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused54) {
            }
            try {
                iArr7[DeviceType.TABLET.ordinal()] = 2;
            } catch (NoSuchFieldError unused55) {
            }
            try {
                iArr7[DeviceType.TV.ordinal()] = 3;
            } catch (NoSuchFieldError unused56) {
            }
            try {
                iArr7[DeviceType.DESKTOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused57) {
            }
            try {
                iArr7[DeviceType.GAMING_CONSOLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused58) {
            }
            try {
                iArr7[DeviceType.BOT.ordinal()] = 6;
            } catch (NoSuchFieldError unused59) {
            }
            try {
                iArr7[DeviceType.OTHER.ordinal()] = 7;
            } catch (NoSuchFieldError unused60) {
            }
            $EnumSwitchMapping$6 = iArr7;
            int[] iArr8 = new int[RumSessionScope.StartReason.values().length];
            try {
                iArr8[RumSessionScope.StartReason.USER_APP_LAUNCH.ordinal()] = 1;
            } catch (NoSuchFieldError unused61) {
            }
            try {
                iArr8[RumSessionScope.StartReason.INACTIVITY_TIMEOUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused62) {
            }
            try {
                iArr8[RumSessionScope.StartReason.MAX_DURATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused63) {
            }
            try {
                iArr8[RumSessionScope.StartReason.EXPLICIT_STOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused64) {
            }
            try {
                iArr8[RumSessionScope.StartReason.BACKGROUND_LAUNCH.ordinal()] = 5;
            } catch (NoSuchFieldError unused65) {
            }
            try {
                iArr8[RumSessionScope.StartReason.PREWARM.ordinal()] = 6;
            } catch (NoSuchFieldError unused66) {
            }
            try {
                iArr8[RumSessionScope.StartReason.FROM_NON_INTERACTIVE_SESSION.ordinal()] = 7;
            } catch (NoSuchFieldError unused67) {
            }
            $EnumSwitchMapping$7 = iArr8;
            int[] iArr9 = new int[FailureReason.values().length];
            try {
                iArr9[FailureReason.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused68) {
            }
            try {
                iArr9[FailureReason.ABANDONED.ordinal()] = 2;
            } catch (NoSuchFieldError unused69) {
            }
            try {
                iArr9[FailureReason.OTHER.ordinal()] = 3;
            } catch (NoSuchFieldError unused70) {
            }
            $EnumSwitchMapping$8 = iArr9;
        }
    }

    public static final ResourceEvent.Method toResourceMethod(RumResourceMethod rumResourceMethod) {
        Intrinsics.checkNotNullParameter(rumResourceMethod, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[rumResourceMethod.ordinal()]) {
            case 1:
                return ResourceEvent.Method.GET;
            case 2:
                return ResourceEvent.Method.POST;
            case 3:
                return ResourceEvent.Method.HEAD;
            case 4:
                return ResourceEvent.Method.PUT;
            case 5:
                return ResourceEvent.Method.DELETE;
            case 6:
                return ResourceEvent.Method.PATCH;
            case 7:
                return ResourceEvent.Method.TRACE;
            case 8:
                return ResourceEvent.Method.OPTIONS;
            case 9:
                return ResourceEvent.Method.CONNECT;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final ErrorEvent.Method toErrorMethod(RumResourceMethod rumResourceMethod) {
        Intrinsics.checkNotNullParameter(rumResourceMethod, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[rumResourceMethod.ordinal()]) {
            case 1:
                return ErrorEvent.Method.GET;
            case 2:
                return ErrorEvent.Method.POST;
            case 3:
                return ErrorEvent.Method.HEAD;
            case 4:
                return ErrorEvent.Method.PUT;
            case 5:
                return ErrorEvent.Method.DELETE;
            case 6:
                return ErrorEvent.Method.PATCH;
            case 7:
                return ErrorEvent.Method.TRACE;
            case 8:
                return ErrorEvent.Method.OPTIONS;
            case 9:
                return ErrorEvent.Method.CONNECT;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final ResourceEvent.OperationType toOperationType(final String str, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        try {
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String upperCase = str.toUpperCase(US);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            return ResourceEvent.OperationType.valueOf(upperCase);
        } catch (IllegalArgumentException e) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.domain.scope.RumEventExtKt.toOperationType.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Unable to convert [" + str + "] to a valid graphql operation type";
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return null;
        }
    }

    public static final ResourceEvent.ResourceType toSchemaType(RumResourceKind rumResourceKind) {
        Intrinsics.checkNotNullParameter(rumResourceKind, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$1[rumResourceKind.ordinal()]) {
            case 1:
                return ResourceEvent.ResourceType.BEACON;
            case 2:
                return ResourceEvent.ResourceType.FETCH;
            case 3:
                return ResourceEvent.ResourceType.XHR;
            case 4:
                return ResourceEvent.ResourceType.DOCUMENT;
            case 5:
                return ResourceEvent.ResourceType.IMAGE;
            case 6:
                return ResourceEvent.ResourceType.JS;
            case 7:
                return ResourceEvent.ResourceType.FONT;
            case 8:
                return ResourceEvent.ResourceType.CSS;
            case 9:
                return ResourceEvent.ResourceType.MEDIA;
            case 10:
                return ResourceEvent.ResourceType.NATIVE;
            case 11:
            case 12:
                return ResourceEvent.ResourceType.OTHER;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final ErrorEvent.ErrorSource toSchemaSource(RumErrorSource rumErrorSource) {
        Intrinsics.checkNotNullParameter(rumErrorSource, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$2[rumErrorSource.ordinal()]) {
            case 1:
                return ErrorEvent.ErrorSource.NETWORK;
            case 2:
                return ErrorEvent.ErrorSource.SOURCE;
            case 3:
                return ErrorEvent.ErrorSource.CONSOLE;
            case 4:
                return ErrorEvent.ErrorSource.LOGGER;
            case 5:
                return ErrorEvent.ErrorSource.AGENT;
            case 6:
                return ErrorEvent.ErrorSource.WEBVIEW;
            case 7:
                return ErrorEvent.ErrorSource.CUSTOM;
            case 8:
                return ErrorEvent.ErrorSource.REPORT;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final ErrorEvent.SourceType toSchemaSourceType(RumErrorSourceType rumErrorSourceType) {
        Intrinsics.checkNotNullParameter(rumErrorSourceType, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$3[rumErrorSourceType.ordinal()]) {
            case 1:
                return ErrorEvent.SourceType.ANDROID;
            case 2:
                return ErrorEvent.SourceType.BROWSER;
            case 3:
                return ErrorEvent.SourceType.REACT_NATIVE;
            case 4:
                return ErrorEvent.SourceType.FLUTTER;
            case 5:
                return ErrorEvent.SourceType.NDK;
            case 6:
                return ErrorEvent.SourceType.NDK_IL2CPP;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final ResourceEvent.Dns dns(ResourceTiming resourceTiming) {
        Intrinsics.checkNotNullParameter(resourceTiming, "<this>");
        if (resourceTiming.getDnsStart() > 0) {
            return new ResourceEvent.Dns(resourceTiming.getDnsDuration(), resourceTiming.getDnsStart());
        }
        return null;
    }

    public static final ResourceEvent.Connect connect(ResourceTiming resourceTiming) {
        Intrinsics.checkNotNullParameter(resourceTiming, "<this>");
        if (resourceTiming.getConnectStart() > 0) {
            return new ResourceEvent.Connect(resourceTiming.getConnectDuration(), resourceTiming.getConnectStart());
        }
        return null;
    }

    public static final ResourceEvent.Ssl ssl(ResourceTiming resourceTiming) {
        Intrinsics.checkNotNullParameter(resourceTiming, "<this>");
        if (resourceTiming.getSslStart() > 0) {
            return new ResourceEvent.Ssl(resourceTiming.getSslDuration(), resourceTiming.getSslStart());
        }
        return null;
    }

    public static final ResourceEvent.FirstByte firstByte(ResourceTiming resourceTiming) {
        Intrinsics.checkNotNullParameter(resourceTiming, "<this>");
        if (resourceTiming.getFirstByteStart() < 0 || resourceTiming.getFirstByteDuration() <= 0) {
            return null;
        }
        return new ResourceEvent.FirstByte(resourceTiming.getFirstByteDuration(), resourceTiming.getFirstByteStart());
    }

    public static final ResourceEvent.Download download(ResourceTiming resourceTiming) {
        Intrinsics.checkNotNullParameter(resourceTiming, "<this>");
        if (resourceTiming.getDownloadStart() > 0) {
            return new ResourceEvent.Download(resourceTiming.getDownloadDuration(), resourceTiming.getDownloadStart());
        }
        return null;
    }

    public static final ActionEvent.ActionEventActionType toSchemaType(RumActionType rumActionType) {
        Intrinsics.checkNotNullParameter(rumActionType, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$4[rumActionType.ordinal()]) {
            case 1:
                return ActionEvent.ActionEventActionType.TAP;
            case 2:
                return ActionEvent.ActionEventActionType.SCROLL;
            case 3:
                return ActionEvent.ActionEventActionType.SWIPE;
            case 4:
                return ActionEvent.ActionEventActionType.CLICK;
            case 5:
                return ActionEvent.ActionEventActionType.BACK;
            case 6:
                return ActionEvent.ActionEventActionType.CUSTOM;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final ResourceEvent.Connectivity toResourceConnectivity(NetworkInfo networkInfo) {
        ResourceEvent.Status status;
        List listListOf;
        Intrinsics.checkNotNullParameter(networkInfo, "<this>");
        if (isConnected(networkInfo)) {
            status = ResourceEvent.Status.CONNECTED;
        } else {
            status = ResourceEvent.Status.NOT_CONNECTED;
        }
        ResourceEvent.Status status2 = status;
        switch (WhenMappings.$EnumSwitchMapping$5[networkInfo.getConnectivity().ordinal()]) {
            case 1:
                listListOf = CollectionsKt.listOf(ResourceEvent.Interface.ETHERNET);
                break;
            case 2:
                listListOf = CollectionsKt.listOf(ResourceEvent.Interface.WIFI);
                break;
            case 3:
                listListOf = CollectionsKt.listOf(ResourceEvent.Interface.WIMAX);
                break;
            case 4:
                listListOf = CollectionsKt.listOf(ResourceEvent.Interface.BLUETOOTH);
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                listListOf = CollectionsKt.listOf(ResourceEvent.Interface.CELLULAR);
                break;
            case 11:
                listListOf = CollectionsKt.listOf(ResourceEvent.Interface.OTHER);
                break;
            case 12:
                listListOf = CollectionsKt.emptyList();
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return new ResourceEvent.Connectivity(status2, listListOf, null, (networkInfo.getCellularTechnology() == null && networkInfo.getCarrierName() == null) ? null : new ResourceEvent.Cellular(networkInfo.getCellularTechnology(), networkInfo.getCarrierName()), 4, null);
    }

    public static final ErrorEvent.Connectivity toErrorConnectivity(NetworkInfo networkInfo) {
        ErrorEvent.ConnectivityStatus connectivityStatus;
        List listListOf;
        Intrinsics.checkNotNullParameter(networkInfo, "<this>");
        if (isConnected(networkInfo)) {
            connectivityStatus = ErrorEvent.ConnectivityStatus.CONNECTED;
        } else {
            connectivityStatus = ErrorEvent.ConnectivityStatus.NOT_CONNECTED;
        }
        ErrorEvent.ConnectivityStatus connectivityStatus2 = connectivityStatus;
        switch (WhenMappings.$EnumSwitchMapping$5[networkInfo.getConnectivity().ordinal()]) {
            case 1:
                listListOf = CollectionsKt.listOf(ErrorEvent.Interface.ETHERNET);
                break;
            case 2:
                listListOf = CollectionsKt.listOf(ErrorEvent.Interface.WIFI);
                break;
            case 3:
                listListOf = CollectionsKt.listOf(ErrorEvent.Interface.WIMAX);
                break;
            case 4:
                listListOf = CollectionsKt.listOf(ErrorEvent.Interface.BLUETOOTH);
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                listListOf = CollectionsKt.listOf(ErrorEvent.Interface.CELLULAR);
                break;
            case 11:
                listListOf = CollectionsKt.listOf(ErrorEvent.Interface.OTHER);
                break;
            case 12:
                listListOf = CollectionsKt.emptyList();
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return new ErrorEvent.Connectivity(connectivityStatus2, listListOf, null, (networkInfo.getCellularTechnology() == null && networkInfo.getCarrierName() == null) ? null : new ErrorEvent.Cellular(networkInfo.getCellularTechnology(), networkInfo.getCarrierName()), 4, null);
    }

    public static final LongTaskEvent.Connectivity toLongTaskConnectivity(NetworkInfo networkInfo) {
        LongTaskEvent.ConnectivityStatus connectivityStatus;
        List listListOf;
        Intrinsics.checkNotNullParameter(networkInfo, "<this>");
        if (isConnected(networkInfo)) {
            connectivityStatus = LongTaskEvent.ConnectivityStatus.CONNECTED;
        } else {
            connectivityStatus = LongTaskEvent.ConnectivityStatus.NOT_CONNECTED;
        }
        LongTaskEvent.ConnectivityStatus connectivityStatus2 = connectivityStatus;
        switch (WhenMappings.$EnumSwitchMapping$5[networkInfo.getConnectivity().ordinal()]) {
            case 1:
                listListOf = CollectionsKt.listOf(LongTaskEvent.Interface.ETHERNET);
                break;
            case 2:
                listListOf = CollectionsKt.listOf(LongTaskEvent.Interface.WIFI);
                break;
            case 3:
                listListOf = CollectionsKt.listOf(LongTaskEvent.Interface.WIMAX);
                break;
            case 4:
                listListOf = CollectionsKt.listOf(LongTaskEvent.Interface.BLUETOOTH);
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                listListOf = CollectionsKt.listOf(LongTaskEvent.Interface.CELLULAR);
                break;
            case 11:
                listListOf = CollectionsKt.listOf(LongTaskEvent.Interface.OTHER);
                break;
            case 12:
                listListOf = CollectionsKt.emptyList();
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return new LongTaskEvent.Connectivity(connectivityStatus2, listListOf, null, (networkInfo.getCellularTechnology() == null && networkInfo.getCarrierName() == null) ? null : new LongTaskEvent.Cellular(networkInfo.getCellularTechnology(), networkInfo.getCarrierName()), 4, null);
    }

    public static final ViewEvent.Connectivity toViewConnectivity(NetworkInfo networkInfo) {
        ViewEvent.ConnectivityStatus connectivityStatus;
        List listListOf;
        Intrinsics.checkNotNullParameter(networkInfo, "<this>");
        if (isConnected(networkInfo)) {
            connectivityStatus = ViewEvent.ConnectivityStatus.CONNECTED;
        } else {
            connectivityStatus = ViewEvent.ConnectivityStatus.NOT_CONNECTED;
        }
        ViewEvent.ConnectivityStatus connectivityStatus2 = connectivityStatus;
        switch (WhenMappings.$EnumSwitchMapping$5[networkInfo.getConnectivity().ordinal()]) {
            case 1:
                listListOf = CollectionsKt.listOf(ViewEvent.Interface.ETHERNET);
                break;
            case 2:
                listListOf = CollectionsKt.listOf(ViewEvent.Interface.WIFI);
                break;
            case 3:
                listListOf = CollectionsKt.listOf(ViewEvent.Interface.WIMAX);
                break;
            case 4:
                listListOf = CollectionsKt.listOf(ViewEvent.Interface.BLUETOOTH);
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                listListOf = CollectionsKt.listOf(ViewEvent.Interface.CELLULAR);
                break;
            case 11:
                listListOf = CollectionsKt.listOf(ViewEvent.Interface.OTHER);
                break;
            case 12:
                listListOf = CollectionsKt.emptyList();
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return new ViewEvent.Connectivity(connectivityStatus2, listListOf, null, (networkInfo.getCellularTechnology() == null && networkInfo.getCarrierName() == null) ? null : new ViewEvent.Cellular(networkInfo.getCellularTechnology(), networkInfo.getCarrierName()), 4, null);
    }

    public static final ActionEvent.Connectivity toActionConnectivity(NetworkInfo networkInfo) {
        ActionEvent.Status status;
        List listListOf;
        Intrinsics.checkNotNullParameter(networkInfo, "<this>");
        if (isConnected(networkInfo)) {
            status = ActionEvent.Status.CONNECTED;
        } else {
            status = ActionEvent.Status.NOT_CONNECTED;
        }
        ActionEvent.Status status2 = status;
        switch (WhenMappings.$EnumSwitchMapping$5[networkInfo.getConnectivity().ordinal()]) {
            case 1:
                listListOf = CollectionsKt.listOf(ActionEvent.Interface.ETHERNET);
                break;
            case 2:
                listListOf = CollectionsKt.listOf(ActionEvent.Interface.WIFI);
                break;
            case 3:
                listListOf = CollectionsKt.listOf(ActionEvent.Interface.WIMAX);
                break;
            case 4:
                listListOf = CollectionsKt.listOf(ActionEvent.Interface.BLUETOOTH);
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                listListOf = CollectionsKt.listOf(ActionEvent.Interface.CELLULAR);
                break;
            case 11:
                listListOf = CollectionsKt.listOf(ActionEvent.Interface.OTHER);
                break;
            case 12:
                listListOf = CollectionsKt.emptyList();
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return new ActionEvent.Connectivity(status2, listListOf, null, (networkInfo.getCellularTechnology() == null && networkInfo.getCarrierName() == null) ? null : new ActionEvent.Cellular(networkInfo.getCellularTechnology(), networkInfo.getCarrierName()), 4, null);
    }

    public static final VitalOperationStepEvent.Connectivity toVitalOperationStepConnectivity(NetworkInfo networkInfo) {
        VitalOperationStepEvent.ConnectivityStatus connectivityStatus;
        List listListOf;
        Intrinsics.checkNotNullParameter(networkInfo, "<this>");
        if (isConnected(networkInfo)) {
            connectivityStatus = VitalOperationStepEvent.ConnectivityStatus.CONNECTED;
        } else {
            connectivityStatus = VitalOperationStepEvent.ConnectivityStatus.NOT_CONNECTED;
        }
        VitalOperationStepEvent.ConnectivityStatus connectivityStatus2 = connectivityStatus;
        switch (WhenMappings.$EnumSwitchMapping$5[networkInfo.getConnectivity().ordinal()]) {
            case 1:
                listListOf = CollectionsKt.listOf(VitalOperationStepEvent.Interface.ETHERNET);
                break;
            case 2:
                listListOf = CollectionsKt.listOf(VitalOperationStepEvent.Interface.WIFI);
                break;
            case 3:
                listListOf = CollectionsKt.listOf(VitalOperationStepEvent.Interface.WIMAX);
                break;
            case 4:
                listListOf = CollectionsKt.listOf(VitalOperationStepEvent.Interface.BLUETOOTH);
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                listListOf = CollectionsKt.listOf(VitalOperationStepEvent.Interface.CELLULAR);
                break;
            case 11:
                listListOf = CollectionsKt.listOf(VitalOperationStepEvent.Interface.OTHER);
                break;
            case 12:
                listListOf = CollectionsKt.emptyList();
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return new VitalOperationStepEvent.Connectivity(connectivityStatus2, listListOf, null, (networkInfo.getCellularTechnology() == null && networkInfo.getCarrierName() == null) ? null : new VitalOperationStepEvent.Cellular(networkInfo.getCellularTechnology(), networkInfo.getCarrierName()), 4, null);
    }

    public static final VitalAppLaunchEvent.Connectivity toAppLaunchVitalConnectivity(NetworkInfo networkInfo) {
        VitalAppLaunchEvent.ConnectivityStatus connectivityStatus;
        List listListOf;
        Intrinsics.checkNotNullParameter(networkInfo, "<this>");
        if (isConnected(networkInfo)) {
            connectivityStatus = VitalAppLaunchEvent.ConnectivityStatus.CONNECTED;
        } else {
            connectivityStatus = VitalAppLaunchEvent.ConnectivityStatus.NOT_CONNECTED;
        }
        VitalAppLaunchEvent.ConnectivityStatus connectivityStatus2 = connectivityStatus;
        switch (WhenMappings.$EnumSwitchMapping$5[networkInfo.getConnectivity().ordinal()]) {
            case 1:
                listListOf = CollectionsKt.listOf(VitalAppLaunchEvent.Interface.ETHERNET);
                break;
            case 2:
                listListOf = CollectionsKt.listOf(VitalAppLaunchEvent.Interface.WIFI);
                break;
            case 3:
                listListOf = CollectionsKt.listOf(VitalAppLaunchEvent.Interface.WIMAX);
                break;
            case 4:
                listListOf = CollectionsKt.listOf(VitalAppLaunchEvent.Interface.BLUETOOTH);
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                listListOf = CollectionsKt.listOf(VitalAppLaunchEvent.Interface.CELLULAR);
                break;
            case 11:
                listListOf = CollectionsKt.listOf(VitalAppLaunchEvent.Interface.OTHER);
                break;
            case 12:
                listListOf = CollectionsKt.emptyList();
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return new VitalAppLaunchEvent.Connectivity(connectivityStatus2, listListOf, null, (networkInfo.getCellularTechnology() == null && networkInfo.getCarrierName() == null) ? null : new VitalAppLaunchEvent.Cellular(networkInfo.getCellularTechnology(), networkInfo.getCarrierName()), 4, null);
    }

    public static final boolean isConnected(NetworkInfo networkInfo) {
        Intrinsics.checkNotNullParameter(networkInfo, "<this>");
        return networkInfo.getConnectivity() != NetworkInfo.Connectivity.NETWORK_NOT_CONNECTED;
    }

    public static final ViewEvent.DeviceType toViewSchemaType(DeviceType deviceType) {
        Intrinsics.checkNotNullParameter(deviceType, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$6[deviceType.ordinal()]) {
            case 1:
                return ViewEvent.DeviceType.MOBILE;
            case 2:
                return ViewEvent.DeviceType.TABLET;
            case 3:
                return ViewEvent.DeviceType.TV;
            case 4:
                return ViewEvent.DeviceType.DESKTOP;
            case 5:
                return ViewEvent.DeviceType.GAMING_CONSOLE;
            case 6:
                return ViewEvent.DeviceType.BOT;
            case 7:
                return ViewEvent.DeviceType.OTHER;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final ActionEvent.DeviceType toActionSchemaType(DeviceType deviceType) {
        Intrinsics.checkNotNullParameter(deviceType, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$6[deviceType.ordinal()]) {
            case 1:
                return ActionEvent.DeviceType.MOBILE;
            case 2:
                return ActionEvent.DeviceType.TABLET;
            case 3:
                return ActionEvent.DeviceType.TV;
            case 4:
                return ActionEvent.DeviceType.DESKTOP;
            case 5:
                return ActionEvent.DeviceType.GAMING_CONSOLE;
            case 6:
                return ActionEvent.DeviceType.BOT;
            case 7:
                return ActionEvent.DeviceType.OTHER;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final LongTaskEvent.DeviceType toLongTaskSchemaType(DeviceType deviceType) {
        Intrinsics.checkNotNullParameter(deviceType, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$6[deviceType.ordinal()]) {
            case 1:
                return LongTaskEvent.DeviceType.MOBILE;
            case 2:
                return LongTaskEvent.DeviceType.TABLET;
            case 3:
                return LongTaskEvent.DeviceType.TV;
            case 4:
                return LongTaskEvent.DeviceType.DESKTOP;
            case 5:
                return LongTaskEvent.DeviceType.GAMING_CONSOLE;
            case 6:
                return LongTaskEvent.DeviceType.BOT;
            case 7:
                return LongTaskEvent.DeviceType.OTHER;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final ResourceEvent.DeviceType toResourceSchemaType(DeviceType deviceType) {
        Intrinsics.checkNotNullParameter(deviceType, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$6[deviceType.ordinal()]) {
            case 1:
                return ResourceEvent.DeviceType.MOBILE;
            case 2:
                return ResourceEvent.DeviceType.TABLET;
            case 3:
                return ResourceEvent.DeviceType.TV;
            case 4:
                return ResourceEvent.DeviceType.DESKTOP;
            case 5:
                return ResourceEvent.DeviceType.GAMING_CONSOLE;
            case 6:
                return ResourceEvent.DeviceType.BOT;
            case 7:
                return ResourceEvent.DeviceType.OTHER;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final ErrorEvent.DeviceType toErrorSchemaType(DeviceType deviceType) {
        Intrinsics.checkNotNullParameter(deviceType, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$6[deviceType.ordinal()]) {
            case 1:
                return ErrorEvent.DeviceType.MOBILE;
            case 2:
                return ErrorEvent.DeviceType.TABLET;
            case 3:
                return ErrorEvent.DeviceType.TV;
            case 4:
                return ErrorEvent.DeviceType.DESKTOP;
            case 5:
                return ErrorEvent.DeviceType.GAMING_CONSOLE;
            case 6:
                return ErrorEvent.DeviceType.BOT;
            case 7:
                return ErrorEvent.DeviceType.OTHER;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final VitalOperationStepEvent.DeviceType toVitalOperationStepSchemaType(DeviceType deviceType) {
        Intrinsics.checkNotNullParameter(deviceType, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$6[deviceType.ordinal()]) {
            case 1:
                return VitalOperationStepEvent.DeviceType.MOBILE;
            case 2:
                return VitalOperationStepEvent.DeviceType.TABLET;
            case 3:
                return VitalOperationStepEvent.DeviceType.TV;
            case 4:
                return VitalOperationStepEvent.DeviceType.DESKTOP;
            case 5:
                return VitalOperationStepEvent.DeviceType.GAMING_CONSOLE;
            case 6:
                return VitalOperationStepEvent.DeviceType.BOT;
            case 7:
                return VitalOperationStepEvent.DeviceType.OTHER;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final VitalAppLaunchEvent.DeviceType toVitalAppLaunchSchemaType(DeviceType deviceType) {
        Intrinsics.checkNotNullParameter(deviceType, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$6[deviceType.ordinal()]) {
            case 1:
                return VitalAppLaunchEvent.DeviceType.MOBILE;
            case 2:
                return VitalAppLaunchEvent.DeviceType.TABLET;
            case 3:
                return VitalAppLaunchEvent.DeviceType.TV;
            case 4:
                return VitalAppLaunchEvent.DeviceType.DESKTOP;
            case 5:
                return VitalAppLaunchEvent.DeviceType.GAMING_CONSOLE;
            case 6:
                return VitalAppLaunchEvent.DeviceType.BOT;
            case 7:
                return VitalAppLaunchEvent.DeviceType.OTHER;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final TimeseriesCpuEvent.DeviceType toTimeseriesCpuSchemaType(DeviceType deviceType) {
        Intrinsics.checkNotNullParameter(deviceType, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$6[deviceType.ordinal()]) {
            case 1:
                return TimeseriesCpuEvent.DeviceType.MOBILE;
            case 2:
                return TimeseriesCpuEvent.DeviceType.TABLET;
            case 3:
                return TimeseriesCpuEvent.DeviceType.TV;
            case 4:
                return TimeseriesCpuEvent.DeviceType.DESKTOP;
            case 5:
                return TimeseriesCpuEvent.DeviceType.GAMING_CONSOLE;
            case 6:
                return TimeseriesCpuEvent.DeviceType.BOT;
            case 7:
                return TimeseriesCpuEvent.DeviceType.OTHER;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final TimeseriesMemoryEvent.DeviceType toTimeseriesMemorySchemaType(DeviceType deviceType) {
        Intrinsics.checkNotNullParameter(deviceType, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$6[deviceType.ordinal()]) {
            case 1:
                return TimeseriesMemoryEvent.DeviceType.MOBILE;
            case 2:
                return TimeseriesMemoryEvent.DeviceType.TABLET;
            case 3:
                return TimeseriesMemoryEvent.DeviceType.TV;
            case 4:
                return TimeseriesMemoryEvent.DeviceType.DESKTOP;
            case 5:
                return TimeseriesMemoryEvent.DeviceType.GAMING_CONSOLE;
            case 6:
                return TimeseriesMemoryEvent.DeviceType.BOT;
            case 7:
                return TimeseriesMemoryEvent.DeviceType.OTHER;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final TimeseriesCpuEvent.Device toTimeseriesCpuDevice(DeviceInfo deviceInfo, BatteryInfo batteryInfo, DisplayInfo displayInfo) {
        Intrinsics.checkNotNullParameter(deviceInfo, "<this>");
        Intrinsics.checkNotNullParameter(batteryInfo, "batteryInfo");
        Intrinsics.checkNotNullParameter(displayInfo, "displayInfo");
        return new TimeseriesCpuEvent.Device(toTimeseriesCpuSchemaType(deviceInfo.getDeviceType()), deviceInfo.getDeviceName(), deviceInfo.getDeviceModel(), deviceInfo.getDeviceBrand(), deviceInfo.getArchitecture(), null, deviceInfo.getLocaleInfo().getLocales(), deviceInfo.getLocaleInfo().getTimeZone(), batteryInfo.getBatteryLevel(), batteryInfo.getLowPowerMode(), displayInfo.getScreenBrightness(), Integer.valueOf(deviceInfo.getLogicalCpuCount()), deviceInfo.getTotalRam(), deviceInfo.isLowRam(), 32, null);
    }

    public static final TimeseriesMemoryEvent.Device toTimeseriesMemoryDevice(DeviceInfo deviceInfo, BatteryInfo batteryInfo, DisplayInfo displayInfo) {
        Intrinsics.checkNotNullParameter(deviceInfo, "<this>");
        Intrinsics.checkNotNullParameter(batteryInfo, "batteryInfo");
        Intrinsics.checkNotNullParameter(displayInfo, "displayInfo");
        return new TimeseriesMemoryEvent.Device(toTimeseriesMemorySchemaType(deviceInfo.getDeviceType()), deviceInfo.getDeviceName(), deviceInfo.getDeviceModel(), deviceInfo.getDeviceBrand(), deviceInfo.getArchitecture(), null, deviceInfo.getLocaleInfo().getLocales(), deviceInfo.getLocaleInfo().getTimeZone(), batteryInfo.getBatteryLevel(), batteryInfo.getLowPowerMode(), displayInfo.getScreenBrightness(), Integer.valueOf(deviceInfo.getLogicalCpuCount()), deviceInfo.getTotalRam(), deviceInfo.isLowRam(), 32, null);
    }

    public static final TimeseriesCpuEvent.Os toTimeseriesCpuOs(DeviceInfo deviceInfo) {
        Intrinsics.checkNotNullParameter(deviceInfo, "<this>");
        return new TimeseriesCpuEvent.Os(deviceInfo.getOsName(), deviceInfo.getOsVersion(), null, deviceInfo.getOsMajorVersion(), 4, null);
    }

    public static final TimeseriesMemoryEvent.Os toTimeseriesMemoryOs(DeviceInfo deviceInfo) {
        Intrinsics.checkNotNullParameter(deviceInfo, "<this>");
        return new TimeseriesMemoryEvent.Os(deviceInfo.getOsName(), deviceInfo.getOsVersion(), null, deviceInfo.getOsMajorVersion(), 4, null);
    }

    public static final Long resolveSessionReplaySampleRate(DatadogContext datadogContext) {
        Intrinsics.checkNotNullParameter(datadogContext, "<this>");
        Map<String, Object> map = datadogContext.getFeaturesContext().get("session-replay");
        Object obj = map != null ? map.get("session_replay_sample_rate") : null;
        if (obj instanceof Long) {
            return (Long) obj;
        }
        return null;
    }

    public static final Float resolveTraceSampleRate(DatadogContext datadogContext) {
        Intrinsics.checkNotNullParameter(datadogContext, "<this>");
        Map<String, Object> map = datadogContext.getFeaturesContext().get("tracing");
        Object obj = map != null ? map.get("okhttp_interceptor_sample_rate") : null;
        if (obj instanceof Float) {
            return (Float) obj;
        }
        return null;
    }

    public static final ViewEvent.ViewEventSource tryFromSource(ViewEvent.ViewEventSource.Companion companion, final String source, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        try {
            return companion.fromJson(source);
        } catch (NoSuchElementException e) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.domain.scope.RumEventExtKt.tryFromSource.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, "You are using an unknown source %s for your events", Arrays.copyOf(new Object[]{source}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return null;
        }
    }

    public static final LongTaskEvent.LongTaskEventSource tryFromSource(LongTaskEvent.LongTaskEventSource.Companion companion, final String source, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        try {
            return companion.fromJson(source);
        } catch (NoSuchElementException e) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.domain.scope.RumEventExtKt.tryFromSource.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, "You are using an unknown source %s for your events", Arrays.copyOf(new Object[]{source}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return null;
        }
    }

    public static final ErrorEvent.ErrorEventSource tryFromSource(ErrorEvent.ErrorEventSource.Companion companion, final String source, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        try {
            return companion.fromJson(source);
        } catch (NoSuchElementException e) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.domain.scope.RumEventExtKt.tryFromSource.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, "You are using an unknown source %s for your events", Arrays.copyOf(new Object[]{source}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return null;
        }
    }

    public static final ActionEvent.ActionEventSource tryFromSource(ActionEvent.ActionEventSource.Companion companion, final String source, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        try {
            return companion.fromJson(source);
        } catch (NoSuchElementException e) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.domain.scope.RumEventExtKt.tryFromSource.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, "You are using an unknown source %s for your events", Arrays.copyOf(new Object[]{source}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return null;
        }
    }

    public static final ResourceEvent.ResourceEventSource tryFromSource(ResourceEvent.ResourceEventSource.Companion companion, final String source, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        try {
            return companion.fromJson(source);
        } catch (NoSuchElementException e) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.domain.scope.RumEventExtKt.tryFromSource.5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, "You are using an unknown source %s for your events", Arrays.copyOf(new Object[]{source}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return null;
        }
    }

    public static final VitalOperationStepEvent.VitalOperationStepEventSource tryFromSource(VitalOperationStepEvent.VitalOperationStepEventSource.Companion companion, final String source, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        try {
            return companion.fromJson(source);
        } catch (NoSuchElementException e) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.domain.scope.RumEventExtKt.tryFromSource.6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, "You are using an unknown source %s for your events", Arrays.copyOf(new Object[]{source}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return null;
        }
    }

    public static final VitalAppLaunchEvent.VitalAppLaunchEventSource tryFromSource(VitalAppLaunchEvent.VitalAppLaunchEventSource.Companion companion, final String source, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        try {
            return companion.fromJson(source);
        } catch (NoSuchElementException e) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.domain.scope.RumEventExtKt.tryFromSource.7
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, "You are using an unknown source %s for your events", Arrays.copyOf(new Object[]{source}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return null;
        }
    }

    public static final TimeseriesCpuEvent.Source tryFromSource(TimeseriesCpuEvent.Source.Companion companion, final String source, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        try {
            return companion.fromJson(source);
        } catch (NoSuchElementException e) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.domain.scope.RumEventExtKt.tryFromSource.8
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, "You are using an unknown source %s for your events", Arrays.copyOf(new Object[]{source}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return null;
        }
    }

    public static final TimeseriesMemoryEvent.Source tryFromSource(TimeseriesMemoryEvent.Source.Companion companion, final String source, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        try {
            return companion.fromJson(source);
        } catch (NoSuchElementException e) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.domain.scope.RumEventExtKt.tryFromSource.9
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, "You are using an unknown source %s for your events", Arrays.copyOf(new Object[]{source}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return null;
        }
    }

    public static final ViewEvent.SessionPrecondition toViewSessionPrecondition(RumSessionScope.StartReason startReason) {
        Intrinsics.checkNotNullParameter(startReason, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$7[startReason.ordinal()]) {
            case 1:
                return ViewEvent.SessionPrecondition.USER_APP_LAUNCH;
            case 2:
                return ViewEvent.SessionPrecondition.INACTIVITY_TIMEOUT;
            case 3:
                return ViewEvent.SessionPrecondition.MAX_DURATION;
            case 4:
                return ViewEvent.SessionPrecondition.EXPLICIT_STOP;
            case 5:
                return ViewEvent.SessionPrecondition.BACKGROUND_LAUNCH;
            case 6:
                return ViewEvent.SessionPrecondition.PREWARM;
            case 7:
                return ViewEvent.SessionPrecondition.FROM_NON_INTERACTIVE_SESSION;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final ActionEvent.SessionPrecondition toActionSessionPrecondition(RumSessionScope.StartReason startReason) {
        Intrinsics.checkNotNullParameter(startReason, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$7[startReason.ordinal()]) {
            case 1:
                return ActionEvent.SessionPrecondition.USER_APP_LAUNCH;
            case 2:
                return ActionEvent.SessionPrecondition.INACTIVITY_TIMEOUT;
            case 3:
                return ActionEvent.SessionPrecondition.MAX_DURATION;
            case 4:
                return ActionEvent.SessionPrecondition.EXPLICIT_STOP;
            case 5:
                return ActionEvent.SessionPrecondition.BACKGROUND_LAUNCH;
            case 6:
                return ActionEvent.SessionPrecondition.PREWARM;
            case 7:
                return ActionEvent.SessionPrecondition.FROM_NON_INTERACTIVE_SESSION;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final ErrorEvent.SessionPrecondition toErrorSessionPrecondition(RumSessionScope.StartReason startReason) {
        Intrinsics.checkNotNullParameter(startReason, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$7[startReason.ordinal()]) {
            case 1:
                return ErrorEvent.SessionPrecondition.USER_APP_LAUNCH;
            case 2:
                return ErrorEvent.SessionPrecondition.INACTIVITY_TIMEOUT;
            case 3:
                return ErrorEvent.SessionPrecondition.MAX_DURATION;
            case 4:
                return ErrorEvent.SessionPrecondition.EXPLICIT_STOP;
            case 5:
                return ErrorEvent.SessionPrecondition.BACKGROUND_LAUNCH;
            case 6:
                return ErrorEvent.SessionPrecondition.PREWARM;
            case 7:
                return ErrorEvent.SessionPrecondition.FROM_NON_INTERACTIVE_SESSION;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final ResourceEvent.SessionPrecondition toResourceSessionPrecondition(RumSessionScope.StartReason startReason) {
        Intrinsics.checkNotNullParameter(startReason, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$7[startReason.ordinal()]) {
            case 1:
                return ResourceEvent.SessionPrecondition.USER_APP_LAUNCH;
            case 2:
                return ResourceEvent.SessionPrecondition.INACTIVITY_TIMEOUT;
            case 3:
                return ResourceEvent.SessionPrecondition.MAX_DURATION;
            case 4:
                return ResourceEvent.SessionPrecondition.EXPLICIT_STOP;
            case 5:
                return ResourceEvent.SessionPrecondition.BACKGROUND_LAUNCH;
            case 6:
                return ResourceEvent.SessionPrecondition.PREWARM;
            case 7:
                return ResourceEvent.SessionPrecondition.FROM_NON_INTERACTIVE_SESSION;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final LongTaskEvent.SessionPrecondition toLongTaskSessionPrecondition(RumSessionScope.StartReason startReason) {
        Intrinsics.checkNotNullParameter(startReason, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$7[startReason.ordinal()]) {
            case 1:
                return LongTaskEvent.SessionPrecondition.USER_APP_LAUNCH;
            case 2:
                return LongTaskEvent.SessionPrecondition.INACTIVITY_TIMEOUT;
            case 3:
                return LongTaskEvent.SessionPrecondition.MAX_DURATION;
            case 4:
                return LongTaskEvent.SessionPrecondition.EXPLICIT_STOP;
            case 5:
                return LongTaskEvent.SessionPrecondition.BACKGROUND_LAUNCH;
            case 6:
                return LongTaskEvent.SessionPrecondition.PREWARM;
            case 7:
                return LongTaskEvent.SessionPrecondition.FROM_NON_INTERACTIVE_SESSION;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final TimeseriesCpuEvent.SessionPrecondition toTimeseriesCpuSessionPrecondition(RumSessionScope.StartReason startReason) {
        Intrinsics.checkNotNullParameter(startReason, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$7[startReason.ordinal()]) {
            case 1:
                return TimeseriesCpuEvent.SessionPrecondition.USER_APP_LAUNCH;
            case 2:
                return TimeseriesCpuEvent.SessionPrecondition.INACTIVITY_TIMEOUT;
            case 3:
                return TimeseriesCpuEvent.SessionPrecondition.MAX_DURATION;
            case 4:
                return TimeseriesCpuEvent.SessionPrecondition.EXPLICIT_STOP;
            case 5:
                return TimeseriesCpuEvent.SessionPrecondition.BACKGROUND_LAUNCH;
            case 6:
                return TimeseriesCpuEvent.SessionPrecondition.PREWARM;
            case 7:
                return TimeseriesCpuEvent.SessionPrecondition.FROM_NON_INTERACTIVE_SESSION;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final TimeseriesMemoryEvent.SessionPrecondition toTimeseriesMemorySessionPrecondition(RumSessionScope.StartReason startReason) {
        Intrinsics.checkNotNullParameter(startReason, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$7[startReason.ordinal()]) {
            case 1:
                return TimeseriesMemoryEvent.SessionPrecondition.USER_APP_LAUNCH;
            case 2:
                return TimeseriesMemoryEvent.SessionPrecondition.INACTIVITY_TIMEOUT;
            case 3:
                return TimeseriesMemoryEvent.SessionPrecondition.MAX_DURATION;
            case 4:
                return TimeseriesMemoryEvent.SessionPrecondition.EXPLICIT_STOP;
            case 5:
                return TimeseriesMemoryEvent.SessionPrecondition.BACKGROUND_LAUNCH;
            case 6:
                return TimeseriesMemoryEvent.SessionPrecondition.PREWARM;
            case 7:
                return TimeseriesMemoryEvent.SessionPrecondition.FROM_NON_INTERACTIVE_SESSION;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final VitalOperationStepEvent.SessionPrecondition toVitalOperationStepSessionPrecondition(RumSessionScope.StartReason startReason) {
        Intrinsics.checkNotNullParameter(startReason, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$7[startReason.ordinal()]) {
            case 1:
                return VitalOperationStepEvent.SessionPrecondition.USER_APP_LAUNCH;
            case 2:
                return VitalOperationStepEvent.SessionPrecondition.INACTIVITY_TIMEOUT;
            case 3:
                return VitalOperationStepEvent.SessionPrecondition.MAX_DURATION;
            case 4:
                return VitalOperationStepEvent.SessionPrecondition.EXPLICIT_STOP;
            case 5:
                return VitalOperationStepEvent.SessionPrecondition.BACKGROUND_LAUNCH;
            case 6:
                return VitalOperationStepEvent.SessionPrecondition.PREWARM;
            case 7:
                return VitalOperationStepEvent.SessionPrecondition.FROM_NON_INTERACTIVE_SESSION;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final VitalAppLaunchEvent.SessionPrecondition toVitalAppLaunchSessionPrecondition(RumSessionScope.StartReason startReason) {
        Intrinsics.checkNotNullParameter(startReason, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$7[startReason.ordinal()]) {
            case 1:
                return VitalAppLaunchEvent.SessionPrecondition.USER_APP_LAUNCH;
            case 2:
                return VitalAppLaunchEvent.SessionPrecondition.INACTIVITY_TIMEOUT;
            case 3:
                return VitalAppLaunchEvent.SessionPrecondition.MAX_DURATION;
            case 4:
                return VitalAppLaunchEvent.SessionPrecondition.EXPLICIT_STOP;
            case 5:
                return VitalAppLaunchEvent.SessionPrecondition.BACKGROUND_LAUNCH;
            case 6:
                return VitalAppLaunchEvent.SessionPrecondition.PREWARM;
            case 7:
                return VitalAppLaunchEvent.SessionPrecondition.FROM_NON_INTERACTIVE_SESSION;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final VitalOperationStepEvent.FailureReason toSchemaFailureReason(FailureReason failureReason) {
        Intrinsics.checkNotNullParameter(failureReason, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$8[failureReason.ordinal()];
        if (i == 1) {
            return VitalOperationStepEvent.FailureReason.ERROR;
        }
        if (i == 2) {
            return VitalOperationStepEvent.FailureReason.ABANDONED;
        }
        if (i == 3) {
            return VitalOperationStepEvent.FailureReason.OTHER;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final VitalAppLaunchEvent.StartupType toVitalAppLaunchStartupType(RumStartupScenario rumStartupScenario) {
        Intrinsics.checkNotNullParameter(rumStartupScenario, "<this>");
        if (rumStartupScenario instanceof RumStartupScenario.Cold) {
            return VitalAppLaunchEvent.StartupType.COLD_START;
        }
        if (rumStartupScenario instanceof RumStartupScenario.WarmAfterActivityDestroyed ? true : rumStartupScenario instanceof RumStartupScenario.WarmFirstActivity) {
            return VitalAppLaunchEvent.StartupType.WARM_START;
        }
        throw new NoWhenBranchMatchedException();
    }
}
