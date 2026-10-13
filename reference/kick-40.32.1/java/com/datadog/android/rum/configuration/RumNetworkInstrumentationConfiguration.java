package com.datadog.android.rum.configuration;

import com.datadog.android.internal.telemetry.InternalTelemetryEvent;
import com.datadog.android.rum.NoOpRumResourceAttributesProvider;
import com.datadog.android.rum.RumResourceAttributesProvider;
import com.datadog.android.rum.internal.net.RumNetworkInstrumentation;
import com.datadog.android.rum.resource.ResourceHeadersExtractor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RumNetworkInstrumentationConfiguration.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001d\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0000¢\u0006\u0002\b\u000eJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/datadog/android/rum/configuration/RumNetworkInstrumentationConfiguration;", "", "()V", "resourceAttributesProvider", "Lcom/datadog/android/rum/RumResourceAttributesProvider;", "resourceHeadersExtractor", "Lcom/datadog/android/rum/resource/ResourceHeadersExtractor;", "sdkInstanceName", "", "createInstrumentation", "Lcom/datadog/android/rum/internal/net/RumNetworkInstrumentation;", "instrumentationName", "libraryType", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$ApiUsage$NetworkInstrumentation$LibraryType;", "createInstrumentation$dd_sdk_android_rum_release", "setRumResourceAttributesProvider", "rumResourceAttributesProvider", "setSdkInstanceName", "trackResourceHeaders", "extractor", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RumNetworkInstrumentationConfiguration {
    private RumResourceAttributesProvider resourceAttributesProvider = new NoOpRumResourceAttributesProvider();
    private ResourceHeadersExtractor resourceHeadersExtractor;
    private String sdkInstanceName;

    public final RumNetworkInstrumentationConfiguration setSdkInstanceName(String sdkInstanceName) {
        Intrinsics.checkNotNullParameter(sdkInstanceName, "sdkInstanceName");
        this.sdkInstanceName = sdkInstanceName;
        return this;
    }

    public final RumNetworkInstrumentationConfiguration setRumResourceAttributesProvider(RumResourceAttributesProvider rumResourceAttributesProvider) {
        Intrinsics.checkNotNullParameter(rumResourceAttributesProvider, "rumResourceAttributesProvider");
        this.resourceAttributesProvider = rumResourceAttributesProvider;
        return this;
    }

    public static /* synthetic */ RumNetworkInstrumentationConfiguration trackResourceHeaders$default(RumNetworkInstrumentationConfiguration rumNetworkInstrumentationConfiguration, ResourceHeadersExtractor resourceHeadersExtractor, int i, Object obj) {
        if ((i & 1) != 0) {
            resourceHeadersExtractor = new ResourceHeadersExtractor.Builder(false, 1, null).build();
        }
        return rumNetworkInstrumentationConfiguration.trackResourceHeaders(resourceHeadersExtractor);
    }

    public final RumNetworkInstrumentationConfiguration trackResourceHeaders(ResourceHeadersExtractor extractor) {
        Intrinsics.checkNotNullParameter(extractor, "extractor");
        this.resourceHeadersExtractor = extractor;
        return this;
    }

    public final RumNetworkInstrumentation createInstrumentation$dd_sdk_android_rum_release(String instrumentationName, InternalTelemetryEvent.ApiUsage.NetworkInstrumentation.LibraryType libraryType) {
        Intrinsics.checkNotNullParameter(instrumentationName, "instrumentationName");
        Intrinsics.checkNotNullParameter(libraryType, "libraryType");
        return new RumNetworkInstrumentation(this.sdkInstanceName, instrumentationName, this.resourceAttributesProvider, libraryType, this.resourceHeadersExtractor);
    }
}
