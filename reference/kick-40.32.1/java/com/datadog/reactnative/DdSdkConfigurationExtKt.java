package com.datadog.reactnative;

import android.util.Log;
import androidx.autofill.HintConstants;
import com.datadog.android.Datadog;
import com.datadog.android.rum.internal.domain.scope.RumSessionScope;
import com.datadog.android.trace.TracingHeaderType;
import com.datadog.trace.api.config.GeneralConfig;
import com.datadog.trace.core.propagation.B3HttpCodec;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DdSdkConfigurationExt.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0000\u001a\u001c\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0006*\u00020\u0002H\u0000\u001a\u001e\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\n*\u00020\u000eH\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u000fH\u0000\u001a\u001c\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0006*\u00020\u0010H\u0000\u001a$\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\n*\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0000\u001a\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\f*\b\u0012\u0004\u0012\u00020\u000b0\u0011H\u0000\u001a\f\u0010\u0014\u001a\u00020\u0002*\u00020\u0001H\u0000\u001a\f\u0010\u0014\u001a\u00020\u0002*\u00020\u0004H\u0000\u001aD\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00062\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000bH\u0002¨\u0006\u001c"}, d2 = {"asDdSdkConfiguration", "Lcom/datadog/reactnative/DdSdkConfiguration;", "Lcom/facebook/react/bridge/ReadableMap;", "asConfigurationForTelemetry", "Lcom/datadog/reactnative/ConfigurationForTelemetry;", "asProxyConfig", "Lkotlin/Pair;", "Ljava/net/Proxy;", "Lcom/datadog/reactnative/ProxyAuthenticator;", "asFirstPartyHosts", "", "", "", "Lcom/datadog/android/trace/TracingHeaderType;", "Lcom/facebook/react/bridge/ReadableArray;", "Lcom/datadog/reactnative/JSONDdSdkConfiguration;", "Lcom/datadog/reactnative/JSONProxyConfiguration;", "", "Lcom/datadog/reactnative/JSONFirstPartyHost;", "asTracingHeaderTypes", "toReadableMap", "buildProxyConfig", "type", "address", "port", "", HintConstants.AUTOFILL_HINT_USERNAME, "password", "datadog_mobile-react-native_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class DdSdkConfigurationExtKt {

    /* JADX INFO: compiled from: DdSdkConfigurationExt.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            try {
                iArr[Proxy.Type.HTTP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Proxy.Type.SOCKS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final DdSdkConfiguration asDdSdkConfiguration(ReadableMap readableMap) {
        RumConfiguration rumConfiguration;
        LogsConfiguration logsConfiguration;
        LinkedHashMap linkedHashMap;
        Intrinsics.checkNotNullParameter(readableMap, "<this>");
        ReadableMap map = readableMap.getMap("additionalConfiguration");
        HashMap<String, Object> hashMap = map != null ? map.toHashMap() : null;
        ReadableMap map2 = readableMap.getMap("rumConfiguration");
        ReadableMap map3 = readableMap.getMap("logsConfiguration");
        ReadableMap map4 = readableMap.getMap("traceConfiguration");
        ReadableMap map5 = readableMap.getMap("configurationForTelemetry");
        if (map2 != null) {
            String string = map2.getString("applicationId");
            String str = string == null ? "" : string;
            Boolean booleanOrNull = DdSdkBridgeExtKt.getBooleanOrNull(map2, "trackFrustrations");
            Double doubleOrNull = DdSdkBridgeExtKt.getDoubleOrNull(map2, "longTaskThresholdMs");
            Double dValueOf = Double.valueOf(doubleOrNull != null ? doubleOrNull.doubleValue() : 0.0d);
            Double doubleOrNull2 = DdSdkBridgeExtKt.getDoubleOrNull(map2, RumSessionScope.RUM_SESSION_SAMPLE_RATE_BUS_MESSAGE_KEY);
            Double doubleOrNull3 = DdSdkBridgeExtKt.getDoubleOrNull(map2, "resourceTraceSampleRate");
            String string2 = map2.getString("vitalsUpdateFrequency");
            Boolean booleanOrNull2 = DdSdkBridgeExtKt.getBooleanOrNull(map2, "trackBackgroundEvents");
            Boolean booleanOrNull3 = DdSdkBridgeExtKt.getBooleanOrNull(map2, "nativeCrashReportEnabled");
            Double doubleOrNull4 = DdSdkBridgeExtKt.getDoubleOrNull(map2, "nativeLongTaskThresholdMs");
            Boolean booleanOrNull4 = DdSdkBridgeExtKt.getBooleanOrNull(map2, "nativeViewTracking");
            Boolean booleanOrNull5 = DdSdkBridgeExtKt.getBooleanOrNull(map2, "nativeInteractionTracking");
            ReadableArray array = map2.getArray("firstPartyHosts");
            rumConfiguration = new RumConfiguration(str, booleanOrNull, dValueOf, doubleOrNull2, doubleOrNull3, string2, booleanOrNull2, booleanOrNull3, doubleOrNull4, booleanOrNull4, booleanOrNull5, array != null ? asFirstPartyHosts(array) : null, DdSdkBridgeExtKt.getBooleanOrNull(map2, "trackNonFatalAnrs"), DdSdkBridgeExtKt.getDoubleOrNull(map2, "initialResourceThreshold"), DdSdkBridgeExtKt.getDoubleOrNull(map2, "telemetrySampleRate"), map2.getString("customEndpoint"));
        } else {
            rumConfiguration = null;
        }
        if (map3 != null) {
            Boolean booleanOrNull6 = DdSdkBridgeExtKt.getBooleanOrNull(map3, "bundleLogsWithRum");
            boolean zBooleanValue = booleanOrNull6 != null ? booleanOrNull6.booleanValue() : true;
            Boolean booleanOrNull7 = DdSdkBridgeExtKt.getBooleanOrNull(map3, "bundleLogsWithTraces");
            logsConfiguration = new LogsConfiguration(zBooleanValue, booleanOrNull7 != null ? booleanOrNull7.booleanValue() : true, map3.getString("customEndpoint"));
        } else {
            logsConfiguration = null;
        }
        TraceConfiguration traceConfiguration = map4 != null ? new TraceConfiguration(map4.getString("customEndpoint")) : null;
        ConfigurationForTelemetry configurationForTelemetryAsConfigurationForTelemetry = map5 != null ? asConfigurationForTelemetry(map5) : null;
        if (hashMap != null) {
            HashMap<String, Object> map6 = hashMap;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(map6.size()));
            Iterator<T> it = map6.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                linkedHashMap2.put(entry.getKey(), entry.getValue());
            }
            linkedHashMap = linkedHashMap2;
        } else {
            linkedHashMap = null;
        }
        String string3 = readableMap.getString("clientToken");
        String str2 = string3 == null ? "" : string3;
        String string4 = readableMap.getString("env");
        String str3 = string4 == null ? "" : string4;
        String string5 = readableMap.getString(GeneralConfig.SITE);
        String string6 = readableMap.getString("service");
        String string7 = readableMap.getString("verbosity");
        String string8 = readableMap.getString("trackingConsent");
        String string9 = readableMap.getString("uploadFrequency");
        String string10 = readableMap.getString("batchSize");
        String string11 = readableMap.getString("batchProcessingLevel");
        ReadableMap map7 = readableMap.getMap("proxyConfiguration");
        return new DdSdkConfiguration(linkedHashMap, str2, str3, string5, string6, string7, string8, string9, string10, string11, map7 != null ? asProxyConfig(map7) : null, rumConfiguration, logsConfiguration, traceConfiguration, configurationForTelemetryAsConfigurationForTelemetry);
    }

    public static final ConfigurationForTelemetry asConfigurationForTelemetry(ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(readableMap, "<this>");
        return new ConfigurationForTelemetry(readableMap.getString("initializationType"), Boolean.valueOf(readableMap.getBoolean("trackErrors")), Boolean.valueOf(readableMap.getBoolean("trackInteractions")), Boolean.valueOf(readableMap.getBoolean("trackNetworkRequests")), readableMap.getString("reactVersion"), readableMap.getString("reactNativeVersion"));
    }

    public static final Pair<Proxy, ProxyAuthenticator> asProxyConfig(ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(readableMap, "<this>");
        String string = readableMap.getString("address");
        Integer numValueOf = readableMap.hasKey("port") ? Integer.valueOf(readableMap.getInt("port")) : null;
        String string2 = readableMap.getString("type");
        if (string == null || numValueOf == null || string2 == null) {
            return null;
        }
        return buildProxyConfig(string2, string, numValueOf.intValue(), readableMap.getString(HintConstants.AUTOFILL_HINT_USERNAME), readableMap.getString("password"));
    }

    public static final Map<String, Set<TracingHeaderType>> asFirstPartyHosts(ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(readableArray, "<this>");
        List<?> list = DdSdkBridgeExtKt.toList(readableArray);
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            JSONFirstPartyHost jSONFirstPartyHost = null;
            if (obj != null) {
                if (!(obj instanceof Map)) {
                    Log.e(readableArray.getClass().getSimpleName(), "Ignoring " + obj + " (" + obj.getClass().getSimpleName() + ") because it is not of type Map");
                } else {
                    Map map = (Map) obj;
                    Object obj2 = map.get("match");
                    String str = obj2 instanceof String ? (String) obj2 : null;
                    Object obj3 = map.get("propagatorTypes");
                    List list2 = obj3 instanceof List ? (List) obj3 : null;
                    if (str != null && list2 != null) {
                        jSONFirstPartyHost = new JSONFirstPartyHost(str, list2);
                    }
                }
            }
            if (jSONFirstPartyHost != null) {
                arrayList.add(jSONFirstPartyHost);
            }
        }
        return asFirstPartyHosts(arrayList);
    }

    public static final DdSdkConfiguration asDdSdkConfiguration(JSONDdSdkConfiguration jSONDdSdkConfiguration) {
        RumConfiguration rumConfiguration;
        LogsConfiguration logsConfiguration;
        LinkedHashMap linkedHashMap;
        Intrinsics.checkNotNullParameter(jSONDdSdkConfiguration, "<this>");
        JSONRumConfiguration rumConfiguration2 = jSONDdSdkConfiguration.getRumConfiguration();
        if (rumConfiguration2 != null) {
            String applicationId = rumConfiguration2.getApplicationId();
            if (applicationId == null) {
                applicationId = "";
            }
            Boolean trackFrustrations = rumConfiguration2.getTrackFrustrations();
            Boolean boolValueOf = Boolean.valueOf(trackFrustrations != null ? trackFrustrations.booleanValue() : true);
            Double longTaskThresholdMs = rumConfiguration2.getLongTaskThresholdMs();
            Double dValueOf = Double.valueOf(longTaskThresholdMs != null ? longTaskThresholdMs.doubleValue() : 0.0d);
            Double sessionSampleRate = rumConfiguration2.getSessionSampleRate();
            Double dValueOf2 = Double.valueOf(sessionSampleRate != null ? sessionSampleRate.doubleValue() : 100.0d);
            Double resourceTraceSampleRate = rumConfiguration2.getResourceTraceSampleRate();
            String vitalsUpdateFrequency = rumConfiguration2.getVitalsUpdateFrequency();
            if (vitalsUpdateFrequency == null) {
                vitalsUpdateFrequency = "AVERAGE";
            }
            Boolean trackBackgroundEvents = rumConfiguration2.getTrackBackgroundEvents();
            Boolean boolValueOf2 = Boolean.valueOf(trackBackgroundEvents != null ? trackBackgroundEvents.booleanValue() : false);
            Boolean nativeCrashReportEnabled = rumConfiguration2.getNativeCrashReportEnabled();
            Boolean boolValueOf3 = Boolean.valueOf(nativeCrashReportEnabled != null ? nativeCrashReportEnabled.booleanValue() : false);
            Double nativeLongTaskThresholdMs = rumConfiguration2.getNativeLongTaskThresholdMs();
            Double dValueOf3 = Double.valueOf(nativeLongTaskThresholdMs != null ? nativeLongTaskThresholdMs.doubleValue() : 200.0d);
            Boolean nativeViewTracking = rumConfiguration2.getNativeViewTracking();
            Boolean boolValueOf4 = Boolean.valueOf(nativeViewTracking != null ? nativeViewTracking.booleanValue() : false);
            Boolean nativeInteractionTracking = rumConfiguration2.getNativeInteractionTracking();
            Boolean boolValueOf5 = Boolean.valueOf(nativeInteractionTracking != null ? nativeInteractionTracking.booleanValue() : false);
            List<JSONFirstPartyHost> firstPartyHosts = rumConfiguration2.getFirstPartyHosts();
            Map<String, Set<TracingHeaderType>> mapAsFirstPartyHosts = firstPartyHosts != null ? asFirstPartyHosts(firstPartyHosts) : null;
            Boolean trackNonFatalAnrs = rumConfiguration2.getTrackNonFatalAnrs();
            Double initialResourceThreshold = rumConfiguration2.getInitialResourceThreshold();
            Double dValueOf4 = Double.valueOf(initialResourceThreshold != null ? initialResourceThreshold.doubleValue() : 0.1d);
            Double telemetrySampleRate = rumConfiguration2.getTelemetrySampleRate();
            rumConfiguration = new RumConfiguration(applicationId, boolValueOf, dValueOf, dValueOf2, resourceTraceSampleRate, vitalsUpdateFrequency, boolValueOf2, boolValueOf3, dValueOf3, boolValueOf4, boolValueOf5, mapAsFirstPartyHosts, trackNonFatalAnrs, dValueOf4, Double.valueOf(telemetrySampleRate != null ? telemetrySampleRate.doubleValue() : 20.0d), rumConfiguration2.getCustomEndpoint());
        } else {
            rumConfiguration = null;
        }
        JSONLogsConfiguration logsConfiguration2 = jSONDdSdkConfiguration.getLogsConfiguration();
        if (logsConfiguration2 != null) {
            Boolean bundleLogsWithRum = logsConfiguration2.getBundleLogsWithRum();
            boolean zBooleanValue = bundleLogsWithRum != null ? bundleLogsWithRum.booleanValue() : true;
            Boolean bundleLogsWithTraces = logsConfiguration2.getBundleLogsWithTraces();
            logsConfiguration = new LogsConfiguration(zBooleanValue, bundleLogsWithTraces != null ? bundleLogsWithTraces.booleanValue() : true, logsConfiguration2.getCustomEndpoint());
        } else {
            logsConfiguration = null;
        }
        JSONTraceConfiguration traceConfiguration = jSONDdSdkConfiguration.getTraceConfiguration();
        TraceConfiguration traceConfiguration2 = traceConfiguration != null ? new TraceConfiguration(traceConfiguration.getCustomEndpoint()) : null;
        Map<String, Object> additionalConfiguration = jSONDdSdkConfiguration.getAdditionalConfiguration();
        if (additionalConfiguration == null || (linkedHashMap = MapsKt.toMutableMap(additionalConfiguration)) == null) {
            linkedHashMap = new LinkedHashMap();
        }
        Map map = linkedHashMap;
        map.put(Datadog.DD_SOURCE_TAG, "react-native");
        map.put(Datadog.DD_SDK_VERSION_TAG, SdkVersionKt.SDK_VERSION);
        String clientToken = jSONDdSdkConfiguration.getClientToken();
        String env = jSONDdSdkConfiguration.getEnv();
        String site = jSONDdSdkConfiguration.getSite();
        if (site == null) {
            site = DefaultConfiguration.site;
        }
        String str = site;
        String service = jSONDdSdkConfiguration.getService();
        String verbosity = jSONDdSdkConfiguration.getVerbosity();
        String trackingConsent = jSONDdSdkConfiguration.getTrackingConsent();
        if (trackingConsent == null) {
            trackingConsent = DefaultConfiguration.trackingConsent;
        }
        String str2 = trackingConsent;
        String uploadFrequency = jSONDdSdkConfiguration.getUploadFrequency();
        String str3 = uploadFrequency == null ? "AVERAGE" : uploadFrequency;
        String batchSize = jSONDdSdkConfiguration.getBatchSize();
        if (batchSize == null) {
            batchSize = DefaultConfiguration.batchSize;
        }
        String str4 = batchSize;
        String batchProcessingLevel = jSONDdSdkConfiguration.getBatchProcessingLevel();
        JSONProxyConfiguration proxyConfiguration = jSONDdSdkConfiguration.getProxyConfiguration();
        return new DdSdkConfiguration(map, clientToken, env, str, service, verbosity, str2, str3, str4, batchProcessingLevel, proxyConfiguration != null ? asProxyConfig(proxyConfiguration) : null, rumConfiguration, logsConfiguration, traceConfiguration2, null);
    }

    public static final Pair<Proxy, ProxyAuthenticator> asProxyConfig(JSONProxyConfiguration jSONProxyConfiguration) {
        Intrinsics.checkNotNullParameter(jSONProxyConfiguration, "<this>");
        return buildProxyConfig(jSONProxyConfiguration.getType(), jSONProxyConfiguration.getAddress(), jSONProxyConfiguration.getPort(), jSONProxyConfiguration.getUsername(), jSONProxyConfiguration.getPassword());
    }

    public static final Map<String, Set<TracingHeaderType>> asFirstPartyHosts(List<JSONFirstPartyHost> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (JSONFirstPartyHost jSONFirstPartyHost : list) {
            if (!jSONFirstPartyHost.getPropagatorTypes().isEmpty()) {
                Set set = (Set) linkedHashMap.get(jSONFirstPartyHost.getMatch());
                if (set != null) {
                    set.addAll(asTracingHeaderTypes(jSONFirstPartyHost.getPropagatorTypes()));
                } else {
                    linkedHashMap.put(jSONFirstPartyHost.getMatch(), CollectionsKt.toMutableSet(asTracingHeaderTypes(jSONFirstPartyHost.getPropagatorTypes())));
                }
            }
        }
        return linkedHashMap;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0072  */
    public static final Set<TracingHeaderType> asTracingHeaderTypes(List<String> list) {
        TracingHeaderType tracingHeaderType;
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase = str.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            int iHashCode = lowerCase.hashCode();
            if (iHashCode != -1654608952) {
                if (iHashCode != -449889078) {
                    if (iHashCode != 3089) {
                        if (iHashCode == 1443200338 && lowerCase.equals("datadog")) {
                            tracingHeaderType = TracingHeaderType.DATADOG;
                        } else {
                            tracingHeaderType = null;
                        }
                    } else if (lowerCase.equals(B3HttpCodec.B3_KEY)) {
                        tracingHeaderType = TracingHeaderType.B3;
                    } else {
                        tracingHeaderType = null;
                    }
                } else if (lowerCase.equals("tracecontext")) {
                    tracingHeaderType = TracingHeaderType.TRACECONTEXT;
                } else {
                    tracingHeaderType = null;
                }
            } else if (lowerCase.equals("b3multi")) {
                tracingHeaderType = TracingHeaderType.B3MULTI;
            } else {
                tracingHeaderType = null;
            }
            if (tracingHeaderType != null) {
                arrayList.add(tracingHeaderType);
            }
        }
        return CollectionsKt.toSet(arrayList);
    }

    public static final ReadableMap toReadableMap(DdSdkConfiguration ddSdkConfiguration) {
        String strName;
        Intrinsics.checkNotNullParameter(ddSdkConfiguration, "<this>");
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString("clientToken", ddSdkConfiguration.getClientToken());
        writableNativeMap.putString("env", ddSdkConfiguration.getEnv());
        writableNativeMap.putString(GeneralConfig.SITE, String.valueOf(ddSdkConfiguration.getSite()));
        String service = ddSdkConfiguration.getService();
        if (service != null) {
            writableNativeMap.putString("service", service);
        }
        String verbosity = ddSdkConfiguration.getVerbosity();
        if (verbosity != null) {
            writableNativeMap.putString("verbosity", verbosity);
        }
        writableNativeMap.putString("trackingConsent", String.valueOf(ddSdkConfiguration.getTrackingConsent()));
        writableNativeMap.putString("uploadFrequency", String.valueOf(ddSdkConfiguration.getUploadFrequency()));
        writableNativeMap.putString("batchSize", String.valueOf(ddSdkConfiguration.getBatchSize()));
        writableNativeMap.putString("batchProcessingLevel", String.valueOf(ddSdkConfiguration.getBatchProcessingLevel()));
        Map<String, Object> additionalConfiguration = ddSdkConfiguration.getAdditionalConfiguration();
        if (additionalConfiguration != null) {
            writableNativeMap.putMap("additionalConfiguration", DdSdkBridgeExtKt.toWritableMap(additionalConfiguration));
        }
        Pair<Proxy, ProxyAuthenticator> proxyConfiguration = ddSdkConfiguration.getProxyConfiguration();
        if (proxyConfiguration != null) {
            Proxy proxyComponent1 = proxyConfiguration.component1();
            proxyConfiguration.component2();
            WritableNativeMap writableNativeMap2 = new WritableNativeMap();
            SocketAddress socketAddressAddress = proxyComponent1.address();
            if (socketAddressAddress instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
                writableNativeMap2.putString("address", inetSocketAddress.getHostString());
                writableNativeMap2.putInt("port", inetSocketAddress.getPort());
            }
            Proxy.Type type = proxyComponent1.type();
            int i = type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
            if (i == 1) {
                strName = "HTTP";
            } else if (i == 2) {
                strName = "SOCKS";
            } else {
                strName = proxyComponent1.type().name();
            }
            writableNativeMap2.putString("type", strName);
            writableNativeMap.putMap("proxyConfiguration", writableNativeMap2);
        }
        RumConfiguration rumConfiguration = ddSdkConfiguration.getRumConfiguration();
        if (rumConfiguration != null) {
            WritableNativeMap writableNativeMap3 = new WritableNativeMap();
            writableNativeMap3.putString("applicationId", rumConfiguration.getApplicationId());
            Boolean trackFrustrations = rumConfiguration.getTrackFrustrations();
            if (trackFrustrations != null) {
                writableNativeMap3.putBoolean("trackFrustrations", trackFrustrations.booleanValue());
            }
            Double longTaskThresholdMs = rumConfiguration.getLongTaskThresholdMs();
            if (longTaskThresholdMs != null) {
                writableNativeMap3.putDouble("longTaskThresholdMs", longTaskThresholdMs.doubleValue());
            }
            Double sessionSampleRate = rumConfiguration.getSessionSampleRate();
            if (sessionSampleRate != null) {
                writableNativeMap3.putDouble(RumSessionScope.RUM_SESSION_SAMPLE_RATE_BUS_MESSAGE_KEY, sessionSampleRate.doubleValue());
            }
            Double resourceTraceSampleRate = rumConfiguration.getResourceTraceSampleRate();
            if (resourceTraceSampleRate != null) {
                writableNativeMap3.putDouble("resourceTraceSampleRate", resourceTraceSampleRate.doubleValue());
            }
            String vitalsUpdateFrequency = rumConfiguration.getVitalsUpdateFrequency();
            if (vitalsUpdateFrequency != null) {
                writableNativeMap3.putString("vitalsUpdateFrequency", vitalsUpdateFrequency);
            }
            Boolean trackBackgroundEvents = rumConfiguration.getTrackBackgroundEvents();
            if (trackBackgroundEvents != null) {
                writableNativeMap3.putBoolean("trackBackgroundEvents", trackBackgroundEvents.booleanValue());
            }
            Boolean nativeCrashReportEnabled = rumConfiguration.getNativeCrashReportEnabled();
            if (nativeCrashReportEnabled != null) {
                writableNativeMap3.putBoolean("nativeCrashReportEnabled", nativeCrashReportEnabled.booleanValue());
            }
            Double nativeLongTaskThresholdMs = rumConfiguration.getNativeLongTaskThresholdMs();
            if (nativeLongTaskThresholdMs != null) {
                writableNativeMap3.putDouble("nativeLongTaskThresholdMs", nativeLongTaskThresholdMs.doubleValue());
            }
            Boolean nativeViewTracking = rumConfiguration.getNativeViewTracking();
            if (nativeViewTracking != null) {
                writableNativeMap3.putBoolean("nativeViewTracking", nativeViewTracking.booleanValue());
            }
            Boolean nativeInteractionTracking = rumConfiguration.getNativeInteractionTracking();
            if (nativeInteractionTracking != null) {
                writableNativeMap3.putBoolean("nativeInteractionTracking", nativeInteractionTracking.booleanValue());
            }
            Boolean trackNonFatalAnrs = rumConfiguration.getTrackNonFatalAnrs();
            if (trackNonFatalAnrs != null) {
                writableNativeMap3.putBoolean("trackNonFatalAnrs", trackNonFatalAnrs.booleanValue());
            }
            Map<String, Set<TracingHeaderType>> firstPartyHosts = rumConfiguration.getFirstPartyHosts();
            if (firstPartyHosts != null) {
                WritableNativeArray writableNativeArray = new WritableNativeArray();
                for (Map.Entry<String, Set<TracingHeaderType>> entry : firstPartyHosts.entrySet()) {
                    String key = entry.getKey();
                    Set<TracingHeaderType> value = entry.getValue();
                    WritableNativeMap writableNativeMap4 = new WritableNativeMap();
                    writableNativeMap4.putString("match", key);
                    WritableNativeArray writableNativeArray2 = new WritableNativeArray();
                    Iterator<T> it = value.iterator();
                    while (it.hasNext()) {
                        writableNativeArray2.pushString(((TracingHeaderType) it.next()).toString());
                    }
                    writableNativeMap4.putArray("propagatorTypes", writableNativeArray2);
                    writableNativeArray.pushMap(writableNativeMap4);
                }
                writableNativeMap3.putArray("firstPartyHosts", writableNativeArray);
            }
            Double initialResourceThreshold = rumConfiguration.getInitialResourceThreshold();
            if (initialResourceThreshold != null) {
                writableNativeMap3.putDouble("initialResourceThreshold", initialResourceThreshold.doubleValue());
            }
            Double telemetrySampleRate = rumConfiguration.getTelemetrySampleRate();
            if (telemetrySampleRate != null) {
                writableNativeMap3.putDouble("telemetrySampleRate", telemetrySampleRate.doubleValue());
            }
            String customEndpoint = rumConfiguration.getCustomEndpoint();
            if (customEndpoint != null) {
                writableNativeMap3.putString("customEndpoint", customEndpoint);
            }
            writableNativeMap.putMap("rumConfiguration", writableNativeMap3);
        }
        LogsConfiguration logsConfiguration = ddSdkConfiguration.getLogsConfiguration();
        if (logsConfiguration != null) {
            WritableNativeMap writableNativeMap5 = new WritableNativeMap();
            writableNativeMap5.putBoolean("bundleLogsWithRum", logsConfiguration.getBundleLogsWithRum());
            writableNativeMap5.putBoolean("bundleLogsWithTraces", logsConfiguration.getBundleLogsWithTraces());
            String customEndpoint2 = logsConfiguration.getCustomEndpoint();
            if (customEndpoint2 != null) {
                writableNativeMap5.putString("customEndpoint", customEndpoint2);
            }
            writableNativeMap.putMap("logsConfiguration", writableNativeMap5);
        }
        TraceConfiguration traceConfiguration = ddSdkConfiguration.getTraceConfiguration();
        if (traceConfiguration != null) {
            WritableNativeMap writableNativeMap6 = new WritableNativeMap();
            String customEndpoint3 = traceConfiguration.getCustomEndpoint();
            if (customEndpoint3 != null) {
                writableNativeMap6.putString("customEndpoint", customEndpoint3);
            }
            writableNativeMap.putMap("traceConfiguration", writableNativeMap6);
        }
        ConfigurationForTelemetry configurationForTelemetry = ddSdkConfiguration.getConfigurationForTelemetry();
        if (configurationForTelemetry != null) {
            WritableNativeMap writableNativeMap7 = new WritableNativeMap();
            String initializationType = configurationForTelemetry.getInitializationType();
            if (initializationType != null) {
                writableNativeMap7.putString("initializationType", initializationType);
            }
            Boolean trackErrors = configurationForTelemetry.getTrackErrors();
            if (trackErrors != null) {
                writableNativeMap7.putBoolean("trackErrors", trackErrors.booleanValue());
            }
            Boolean trackInteractions = configurationForTelemetry.getTrackInteractions();
            if (trackInteractions != null) {
                writableNativeMap7.putBoolean("trackInteractions", trackInteractions.booleanValue());
            }
            Boolean trackNetworkRequests = configurationForTelemetry.getTrackNetworkRequests();
            if (trackNetworkRequests != null) {
                writableNativeMap7.putBoolean("trackNetworkRequests", trackNetworkRequests.booleanValue());
            }
            String reactVersion = configurationForTelemetry.getReactVersion();
            if (reactVersion != null) {
                writableNativeMap7.putString("reactVersion", reactVersion);
            }
            String reactNativeVersion = configurationForTelemetry.getReactNativeVersion();
            if (reactNativeVersion != null) {
                writableNativeMap7.putString("reactNativeVersion", reactNativeVersion);
            }
            writableNativeMap.putMap("configurationForTelemetry", writableNativeMap7);
        }
        return writableNativeMap;
    }

    public static final ReadableMap toReadableMap(ConfigurationForTelemetry configurationForTelemetry) {
        Intrinsics.checkNotNullParameter(configurationForTelemetry, "<this>");
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        String initializationType = configurationForTelemetry.getInitializationType();
        if (initializationType != null) {
            writableNativeMap.putString("initializationType", initializationType);
        }
        Boolean trackErrors = configurationForTelemetry.getTrackErrors();
        if (trackErrors != null) {
            writableNativeMap.putBoolean("trackErrors", trackErrors.booleanValue());
        }
        Boolean trackInteractions = configurationForTelemetry.getTrackInteractions();
        if (trackInteractions != null) {
            writableNativeMap.putBoolean("trackInteractions", trackInteractions.booleanValue());
        }
        Boolean trackNetworkRequests = configurationForTelemetry.getTrackNetworkRequests();
        if (trackNetworkRequests != null) {
            writableNativeMap.putBoolean("trackNetworkRequests", trackNetworkRequests.booleanValue());
        }
        String reactVersion = configurationForTelemetry.getReactVersion();
        if (reactVersion != null) {
            writableNativeMap.putString("reactVersion", reactVersion);
        }
        String reactNativeVersion = configurationForTelemetry.getReactNativeVersion();
        if (reactNativeVersion != null) {
            writableNativeMap.putString("reactNativeVersion", reactNativeVersion);
        }
        return writableNativeMap;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0060  */
    private static final Pair<Proxy, ProxyAuthenticator> buildProxyConfig(String str, String str2, int i, String str3, String str4) {
        Proxy.Type type;
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = str.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        int iHashCode = lowerCase.hashCode();
        ProxyAuthenticator proxyAuthenticator = null;
        if (iHashCode != 3213448) {
            if (iHashCode != 99617003) {
                if (iHashCode == 109610287 && lowerCase.equals("socks")) {
                    type = Proxy.Type.SOCKS;
                }
            } else if (lowerCase.equals("https")) {
                type = Proxy.Type.HTTP;
            }
            Log.w(DdSdk.class.getCanonicalName(), "Unknown proxy type given: " + str + ", skipping proxy configuration.");
            type = null;
        } else if (lowerCase.equals("http")) {
            type = Proxy.Type.HTTP;
        } else {
            Log.w(DdSdk.class.getCanonicalName(), "Unknown proxy type given: " + str + ", skipping proxy configuration.");
            type = null;
        }
        if (type == null) {
            return null;
        }
        Proxy proxy = new Proxy(type, new InetSocketAddress(str2, i));
        if (str3 != null && str4 != null) {
            proxyAuthenticator = new ProxyAuthenticator(str3, str4);
        }
        return new Pair<>(proxy, proxyAuthenticator);
    }
}
