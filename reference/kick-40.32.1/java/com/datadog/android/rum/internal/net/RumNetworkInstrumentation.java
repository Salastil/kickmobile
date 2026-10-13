package com.datadog.android.rum.internal.net;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.SdkCore;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.api.instrumentation.network.ExtendedRequestInfoKt;
import com.datadog.android.api.instrumentation.network.HttpRequestInfo;
import com.datadog.android.api.instrumentation.network.HttpResponseInfo;
import com.datadog.android.core.SdkReference;
import com.datadog.android.internal.network.HttpSpec;
import com.datadog.android.internal.telemetry.InternalTelemetryEvent;
import com.datadog.android.rum.GlobalRumMonitor;
import com.datadog.android.rum.RumErrorSource;
import com.datadog.android.rum.RumMonitor;
import com.datadog.android.rum.RumResourceAttributesProvider;
import com.datadog.android.rum.RumResourceKind;
import com.datadog.android.rum.RumResourceMethod;
import com.datadog.android.rum.internal.RumFeature;
import com.datadog.android.rum.internal.domain.event.ResourceTiming;
import com.datadog.android.rum.internal.monitor.AdvancedNetworkRumMonitor;
import com.datadog.android.rum.resource.ResourceHeadersExtractor;
import com.datadog.android.rum.resource.ResourceId;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RumNetworkInstrumentation.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0007\u0018\u0000 22\u00020\u0001:\u00012B3\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u001c\u0010\u001b\u001a\u00020\u001c2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001c0\u001eH\u0002J\u0014\u0010 \u001a\u00020\u001c2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\"J\u0016\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'J\u000e\u0010(\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%J\u000e\u0010)\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%J0\u0010*\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%2\u0006\u0010+\u001a\u00020,2\u0016\b\u0002\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010.H\u0007J\u0016\u0010/\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%2\u0006\u00100\u001a\u000201R\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000f¨\u00063"}, d2 = {"Lcom/datadog/android/rum/internal/net/RumNetworkInstrumentation;", "", "sdkInstanceName", "", "networkInstrumentationName", "rumResourceAttributesProvider", "Lcom/datadog/android/rum/RumResourceAttributesProvider;", "libraryType", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$ApiUsage$NetworkInstrumentation$LibraryType;", "resourceHeadersExtractor", "Lcom/datadog/android/rum/resource/ResourceHeadersExtractor;", "(Ljava/lang/String;Ljava/lang/String;Lcom/datadog/android/rum/RumResourceAttributesProvider;Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$ApiUsage$NetworkInstrumentation$LibraryType;Lcom/datadog/android/rum/resource/ResourceHeadersExtractor;)V", "getLibraryType$dd_sdk_android_rum_release", "()Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$ApiUsage$NetworkInstrumentation$LibraryType;", "getNetworkInstrumentationName$dd_sdk_android_rum_release", "()Ljava/lang/String;", "getResourceHeadersExtractor$dd_sdk_android_rum_release", "()Lcom/datadog/android/rum/resource/ResourceHeadersExtractor;", "getRumResourceAttributesProvider$dd_sdk_android_rum_release", "()Lcom/datadog/android/rum/RumResourceAttributesProvider;", "sdkCore", "Lcom/datadog/android/api/SdkCore;", "getSdkCore", "()Lcom/datadog/android/api/SdkCore;", "sdkCoreReference", "Lcom/datadog/android/core/SdkReference;", "getSdkInstanceName$dd_sdk_android_rum_release", "ifRumEnabled", "", "block", "Lkotlin/Function1;", "Lcom/datadog/android/api/feature/FeatureSdkCore;", "reportInstrumentationError", "message", "Lkotlin/Function0;", "sendTiming", "requestInfo", "Lcom/datadog/android/api/instrumentation/network/HttpRequestInfo;", "resourceTiming", "Lcom/datadog/android/rum/internal/domain/event/ResourceTiming;", "sendWaitForResourceTimingEvent", "startResource", "stopResource", "responseInfo", "Lcom/datadog/android/api/instrumentation/network/HttpResponseInfo;", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "", "stopResourceWithError", RumFeature.EVENT_THROWABLE_PROPERTY, "", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RumNetworkInstrumentation {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String ERROR_MSG_FORMAT = "%s request error %s %s";
    public static final String UNSUPPORTED_HTTP_METHOD = "Unsupported HTTP method %s reported by %s instrumentation, using GET instead";
    public static final String WARN_RUM_DISABLED = "You set up a %s instrumentation for %s, but RUM feature is disabled. Make sure you initialized the Datadog SDK with a valid Application ID, and that RUM feature is enabled.";
    private final InternalTelemetryEvent.ApiUsage.NetworkInstrumentation.LibraryType libraryType;
    private final String networkInstrumentationName;
    private final ResourceHeadersExtractor resourceHeadersExtractor;
    private final RumResourceAttributesProvider rumResourceAttributesProvider;
    private final SdkReference sdkCoreReference;
    private final String sdkInstanceName;

    public RumNetworkInstrumentation(String str, String networkInstrumentationName, RumResourceAttributesProvider rumResourceAttributesProvider, InternalTelemetryEvent.ApiUsage.NetworkInstrumentation.LibraryType libraryType, ResourceHeadersExtractor resourceHeadersExtractor) {
        Intrinsics.checkNotNullParameter(networkInstrumentationName, "networkInstrumentationName");
        Intrinsics.checkNotNullParameter(rumResourceAttributesProvider, "rumResourceAttributesProvider");
        Intrinsics.checkNotNullParameter(libraryType, "libraryType");
        this.sdkInstanceName = str;
        this.networkInstrumentationName = networkInstrumentationName;
        this.rumResourceAttributesProvider = rumResourceAttributesProvider;
        this.libraryType = libraryType;
        this.resourceHeadersExtractor = resourceHeadersExtractor;
        this.sdkCoreReference = new SdkReference(str, new Function1<SdkCore, Unit>() { // from class: com.datadog.android.rum.internal.net.RumNetworkInstrumentation$sdkCoreReference$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SdkCore sdkCore) {
                invoke2(sdkCore);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SdkCore it) {
                Intrinsics.checkNotNullParameter(it, "it");
                AdvancedNetworkRumMonitor networkMonitor = RumNetworkInstrumentation.INSTANCE.getNetworkMonitor(it);
                if (networkMonitor != null) {
                    NetworkInstrumentationTelemetryExtKt.reportNetworkInstrumentationConfigured(networkMonitor, this.this$0.getLibraryType(), this.this$0.getResourceHeadersExtractor());
                }
            }
        });
    }

    /* JADX INFO: renamed from: getSdkInstanceName$dd_sdk_android_rum_release, reason: from getter */
    public final String getSdkInstanceName() {
        return this.sdkInstanceName;
    }

    /* JADX INFO: renamed from: getNetworkInstrumentationName$dd_sdk_android_rum_release, reason: from getter */
    public final String getNetworkInstrumentationName() {
        return this.networkInstrumentationName;
    }

    /* JADX INFO: renamed from: getRumResourceAttributesProvider$dd_sdk_android_rum_release, reason: from getter */
    public final RumResourceAttributesProvider getRumResourceAttributesProvider() {
        return this.rumResourceAttributesProvider;
    }

    /* JADX INFO: renamed from: getLibraryType$dd_sdk_android_rum_release, reason: from getter */
    public final InternalTelemetryEvent.ApiUsage.NetworkInstrumentation.LibraryType getLibraryType() {
        return this.libraryType;
    }

    /* JADX INFO: renamed from: getResourceHeadersExtractor$dd_sdk_android_rum_release, reason: from getter */
    public final ResourceHeadersExtractor getResourceHeadersExtractor() {
        return this.resourceHeadersExtractor;
    }

    public final SdkCore getSdkCore() {
        return this.sdkCoreReference.get();
    }

    public final void sendWaitForResourceTimingEvent(final HttpRequestInfo requestInfo) {
        Intrinsics.checkNotNullParameter(requestInfo, "requestInfo");
        ifRumEnabled(new Function1<FeatureSdkCore, Unit>() { // from class: com.datadog.android.rum.internal.net.RumNetworkInstrumentation.sendWaitForResourceTimingEvent.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FeatureSdkCore featureSdkCore) {
                invoke2(featureSdkCore);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FeatureSdkCore sdkCore) {
                Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
                AdvancedNetworkRumMonitor networkMonitor = RumNetworkInstrumentation.INSTANCE.getNetworkMonitor(sdkCore);
                if (networkMonitor != null) {
                    networkMonitor.waitForResourceTiming(RumNetworkInstrumentation.INSTANCE.buildResourceId(requestInfo, true));
                }
            }
        });
    }

    public final void sendTiming(final HttpRequestInfo requestInfo, final ResourceTiming resourceTiming) {
        Intrinsics.checkNotNullParameter(requestInfo, "requestInfo");
        Intrinsics.checkNotNullParameter(resourceTiming, "resourceTiming");
        ifRumEnabled(new Function1<FeatureSdkCore, Unit>() { // from class: com.datadog.android.rum.internal.net.RumNetworkInstrumentation.sendTiming.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FeatureSdkCore featureSdkCore) {
                invoke2(featureSdkCore);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FeatureSdkCore sdkCore) {
                Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
                AdvancedNetworkRumMonitor networkMonitor = RumNetworkInstrumentation.INSTANCE.getNetworkMonitor(sdkCore);
                if (networkMonitor != null) {
                    networkMonitor.addResourceTiming(RumNetworkInstrumentation.INSTANCE.buildResourceId(requestInfo, false), resourceTiming);
                }
            }
        });
    }

    public final void startResource(final HttpRequestInfo requestInfo) {
        Intrinsics.checkNotNullParameter(requestInfo, "requestInfo");
        ifRumEnabled(new Function1<FeatureSdkCore, Unit>() { // from class: com.datadog.android.rum.internal.net.RumNetworkInstrumentation.startResource.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FeatureSdkCore featureSdkCore) {
                invoke2(featureSdkCore);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FeatureSdkCore sdkCore) {
                Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
                AdvancedNetworkRumMonitor networkMonitor = RumNetworkInstrumentation.INSTANCE.getNetworkMonitor(sdkCore);
                if (networkMonitor != null) {
                    AdvancedNetworkRumMonitor.DefaultImpls.startResource$default(networkMonitor, RumNetworkInstrumentation.INSTANCE.buildResourceId(requestInfo, true), RumNetworkInstrumentation.INSTANCE.toRumResourceMethod(requestInfo, this.getNetworkInstrumentationName(), sdkCore.getInternalLogger()), requestInfo.getUrl(), null, 8, null);
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void stopResource$default(RumNetworkInstrumentation rumNetworkInstrumentation, HttpRequestInfo httpRequestInfo, HttpResponseInfo httpResponseInfo, Map map, int i, Object obj) {
        if ((i & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        rumNetworkInstrumentation.stopResource(httpRequestInfo, httpResponseInfo, map);
    }

    public final void stopResource(final HttpRequestInfo requestInfo, final HttpResponseInfo responseInfo, final Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(requestInfo, "requestInfo");
        Intrinsics.checkNotNullParameter(responseInfo, "responseInfo");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        ifRumEnabled(new Function1<FeatureSdkCore, Unit>() { // from class: com.datadog.android.rum.internal.net.RumNetworkInstrumentation.stopResource.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FeatureSdkCore featureSdkCore) {
                invoke2(featureSdkCore);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code duplicated, block: B:11:0x0031  */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FeatureSdkCore sdkCore) {
                Map<String, Object> mapEmptyMap;
                Map<String, List<String>> headers;
                Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
                ResourceHeadersExtractor resourceHeadersExtractor = RumNetworkInstrumentation.this.getResourceHeadersExtractor();
                if (resourceHeadersExtractor != null) {
                    HttpRequestInfo request = responseInfo.getRequest();
                    if (request == null || (headers = request.getHeaders()) == null) {
                        headers = requestInfo.getHeaders();
                    }
                    mapEmptyMap = resourceHeadersExtractor.toResourceAttributes$dd_sdk_android_rum_release(headers, responseInfo.getHeaders(), sdkCore.getInternalLogger());
                    if (mapEmptyMap == null) {
                        mapEmptyMap = MapsKt.emptyMap();
                    }
                } else {
                    mapEmptyMap = MapsKt.emptyMap();
                }
                AdvancedNetworkRumMonitor networkMonitor = RumNetworkInstrumentation.INSTANCE.getNetworkMonitor(sdkCore);
                if (networkMonitor != null) {
                    networkMonitor.stopResource(RumNetworkInstrumentation.INSTANCE.buildResourceId(requestInfo, false), Integer.valueOf(responseInfo.getStatusCode()), RumNetworkInstrumentation.INSTANCE.getBodyLength(responseInfo), RumNetworkInstrumentation.INSTANCE.getRumResourceKind(responseInfo), MapsKt.plus(MapsKt.plus(attributes, RumNetworkInstrumentation.this.getRumResourceAttributesProvider().onProvideAttributes(requestInfo, responseInfo, (Throwable) null)), mapEmptyMap));
                }
            }
        });
    }

    public final void stopResourceWithError(final HttpRequestInfo requestInfo, final Throwable throwable) {
        Intrinsics.checkNotNullParameter(requestInfo, "requestInfo");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        ifRumEnabled(new Function1<FeatureSdkCore, Unit>() { // from class: com.datadog.android.rum.internal.net.RumNetworkInstrumentation.stopResourceWithError.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FeatureSdkCore featureSdkCore) {
                invoke2(featureSdkCore);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FeatureSdkCore sdkCore) {
                Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
                AdvancedNetworkRumMonitor networkMonitor = RumNetworkInstrumentation.INSTANCE.getNetworkMonitor(sdkCore);
                if (networkMonitor != null) {
                    ResourceId resourceIdBuildResourceId = RumNetworkInstrumentation.INSTANCE.buildResourceId(requestInfo, false);
                    String str = String.format(Locale.US, RumNetworkInstrumentation.ERROR_MSG_FORMAT, Arrays.copyOf(new Object[]{this.getNetworkInstrumentationName(), requestInfo.getMethod(), requestInfo.getUrl()}, 3));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    networkMonitor.stopResourceWithError(resourceIdBuildResourceId, (Integer) null, str, RumErrorSource.NETWORK, throwable, (Map<String, ? extends Object>) this.getRumResourceAttributesProvider().onProvideAttributes(requestInfo, (HttpResponseInfo) null, throwable));
                }
            }
        });
    }

    public final void reportInstrumentationError(final Function0<String> message) {
        Intrinsics.checkNotNullParameter(message, "message");
        ifRumEnabled(new Function1<FeatureSdkCore, Unit>() { // from class: com.datadog.android.rum.internal.net.RumNetworkInstrumentation.reportInstrumentationError.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FeatureSdkCore featureSdkCore) {
                invoke2(featureSdkCore);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FeatureSdkCore sdkCore) {
                Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
                InternalLogger internalLogger = sdkCore.getInternalLogger();
                InternalLogger.Level level = InternalLogger.Level.WARN;
                InternalLogger.Target target = InternalLogger.Target.MAINTAINER;
                final Function0<String> function0 = message;
                InternalLogger.DefaultImpls.log$default(internalLogger, level, target, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.net.RumNetworkInstrumentation.reportInstrumentationError.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Unable to instrument RUM resource: " + ((Object) function0.invoke());
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
            }
        });
    }

    private final void ifRumEnabled(Function1<? super FeatureSdkCore, Unit> block) {
        final String str;
        InternalLogger unbound;
        SdkCore sdkCore = getSdkCore();
        FeatureSdkCore featureSdkCore = sdkCore instanceof FeatureSdkCore ? (FeatureSdkCore) sdkCore : null;
        if ((featureSdkCore != null ? featureSdkCore.getFeature("rum") : null) != null) {
            block.invoke(featureSdkCore);
            return;
        }
        String str2 = this.sdkInstanceName;
        if (str2 == null) {
            str = "Default SDK instance";
        } else {
            str = "SDK instance with name=" + str2;
        }
        if (featureSdkCore == null || (unbound = featureSdkCore.getInternalLogger()) == null) {
            unbound = InternalLogger.INSTANCE.getUNBOUND();
        }
        InternalLogger.DefaultImpls.log$default(unbound, InternalLogger.Level.INFO, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.net.RumNetworkInstrumentation.ifRumEnabled.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String str3 = String.format(Locale.US, RumNetworkInstrumentation.WARN_RUM_DISABLED, Arrays.copyOf(new Object[]{RumNetworkInstrumentation.this.getNetworkInstrumentationName(), str}, 2));
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                return str3;
            }
        }, (Throwable) null, false, (Map) null, 56, (Object) null);
    }

    /* JADX INFO: compiled from: RumNetworkInstrumentation.kt */
    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000fH\u0002J\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015*\u00020\u0016H\u0003¢\u0006\u0002\u0010\u0017J\f\u0010\u0018\u001a\u00020\u0019*\u00020\u0016H\u0002J\u001c\u0010\u001a\u001a\u00020\u001b*\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/datadog/android/rum/internal/net/RumNetworkInstrumentation$Companion;", "", "()V", "ERROR_MSG_FORMAT", "", "UNSUPPORTED_HTTP_METHOD", "WARN_RUM_DISABLED", "networkMonitor", "Lcom/datadog/android/rum/internal/monitor/AdvancedNetworkRumMonitor;", "Lcom/datadog/android/api/SdkCore;", "getNetworkMonitor", "(Lcom/datadog/android/api/SdkCore;)Lcom/datadog/android/rum/internal/monitor/AdvancedNetworkRumMonitor;", "buildResourceId", "Lcom/datadog/android/rum/resource/ResourceId;", "request", "Lcom/datadog/android/api/instrumentation/network/HttpRequestInfo;", "generateUuid", "", "identifyRequest", "requestInfo", "getBodyLength", "", "Lcom/datadog/android/api/instrumentation/network/HttpResponseInfo;", "(Lcom/datadog/android/api/instrumentation/network/HttpResponseInfo;)Ljava/lang/Long;", "getRumResourceKind", "Lcom/datadog/android/rum/RumResourceKind;", "toRumResourceMethod", "Lcom/datadog/android/rum/RumResourceMethod;", "networkInstrumentationName", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ResourceId buildResourceId(HttpRequestInfo request, boolean generateUuid) {
            Intrinsics.checkNotNullParameter(request, "request");
            UUID uuidRandomUUID = (UUID) ExtendedRequestInfoKt.tag(request, UUID.class);
            if (uuidRandomUUID == null) {
                uuidRandomUUID = generateUuid ? UUID.randomUUID() : null;
            }
            return new ResourceId(identifyRequest(request), uuidRandomUUID != null ? uuidRandomUUID.toString() : null);
        }

        private final String identifyRequest(HttpRequestInfo requestInfo) {
            String method = requestInfo.getMethod();
            String url = requestInfo.getUrl();
            Long lContentLength = requestInfo.contentLength();
            long jLongValue = lContentLength != null ? lContentLength.longValue() : 0L;
            String contentType = requestInfo.getContentType();
            if (contentType != null || jLongValue != 0) {
                return method + "•" + url + "•" + jLongValue + "•" + contentType;
            }
            return method + "•" + url;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public final RumResourceMethod toRumResourceMethod(final HttpRequestInfo httpRequestInfo, final String str, InternalLogger internalLogger) {
            String method = httpRequestInfo.getMethod();
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String upperCase = method.toUpperCase(US);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            switch (upperCase.hashCode()) {
                case -531492226:
                    if (upperCase.equals(HttpSpec.Method.OPTIONS)) {
                        return RumResourceMethod.OPTIONS;
                    }
                    break;
                case 70454:
                    if (upperCase.equals("GET")) {
                        return RumResourceMethod.GET;
                    }
                    break;
                case 79599:
                    if (upperCase.equals(HttpSpec.Method.PUT)) {
                        return RumResourceMethod.PUT;
                    }
                    break;
                case 2213344:
                    if (upperCase.equals(HttpSpec.Method.HEAD)) {
                        return RumResourceMethod.HEAD;
                    }
                    break;
                case 2461856:
                    if (upperCase.equals("POST")) {
                        return RumResourceMethod.POST;
                    }
                    break;
                case 75900968:
                    if (upperCase.equals(HttpSpec.Method.PATCH)) {
                        return RumResourceMethod.PATCH;
                    }
                    break;
                case 80083237:
                    if (upperCase.equals(HttpSpec.Method.TRACE)) {
                        return RumResourceMethod.TRACE;
                    }
                    break;
                case 1669334218:
                    if (upperCase.equals(HttpSpec.Method.CONNECT)) {
                        return RumResourceMethod.CONNECT;
                    }
                    break;
                case 2012838315:
                    if (upperCase.equals(HttpSpec.Method.DELETE)) {
                        return RumResourceMethod.DELETE;
                    }
                    break;
            }
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.WARN, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.USER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.net.RumNetworkInstrumentation$Companion$toRumResourceMethod$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str2 = String.format(Locale.US, RumNetworkInstrumentation.UNSUPPORTED_HTTP_METHOD, Arrays.copyOf(new Object[]{httpRequestInfo.getMethod(), str}, 2));
                    Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                    return str2;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return RumResourceMethod.GET;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final RumResourceKind getRumResourceKind(HttpResponseInfo httpResponseInfo) {
            String contentType = httpResponseInfo.getContentType();
            if (contentType == null) {
                return RumResourceKind.NATIVE;
            }
            return RumResourceKind.INSTANCE.fromMimeType(contentType);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Long getBodyLength(HttpResponseInfo httpResponseInfo) {
            boolean zIsStream = HttpSpec.ContentType.INSTANCE.isStream(httpResponseInfo.getContentType());
            List<String> list = httpResponseInfo.getHeaders().get("Sec-WebSocket-Accept");
            boolean z = list == null || list.isEmpty();
            if (zIsStream || !z) {
                return null;
            }
            return httpResponseInfo.getContentLength();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final AdvancedNetworkRumMonitor getNetworkMonitor(SdkCore sdkCore) {
            RumMonitor rumMonitor = GlobalRumMonitor.get(sdkCore);
            if (rumMonitor instanceof AdvancedNetworkRumMonitor) {
                return (AdvancedNetworkRumMonitor) rumMonitor;
            }
            return null;
        }
    }
}
