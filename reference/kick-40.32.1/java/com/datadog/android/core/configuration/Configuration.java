package com.datadog.android.core.configuration;

import com.datadog.android.DatadogSite;
import com.datadog.android.core.persistence.PersistenceStrategy;
import com.datadog.android.security.Encryption;
import com.datadog.android.trace.TracingHeaderType;
import com.datadog.trace.api.config.GeneralConfig;
import java.net.Proxy;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import okhttp3.Authenticator;

/* JADX INFO: compiled from: Configuration.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\"\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 22\u00020\u0001:\u0003123BW\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u001b\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u001cJ\u000e\u0010\u001d\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\b\u001eJ\u000e\u0010\u001f\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\b J\u000e\u0010!\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\b\"J\u0010\u0010#\u001a\u0004\u0018\u00010\u0005HÀ\u0003¢\u0006\u0002\b$J\u000e\u0010%\u001a\u00020\nHÀ\u0003¢\u0006\u0002\b&J\u001a\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\fHÀ\u0003¢\u0006\u0002\b(J\u0010\u0010)\u001a\u0004\u0018\u00010\u0005HÀ\u0003¢\u0006\u0002\b*Ji\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010,\u001a\u00020\n2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u00020\u0005HÖ\u0001R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\t\u001a\u00020\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0006\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0016\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0014\u0010\u0007\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0016\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012¨\u00064"}, d2 = {"Lcom/datadog/android/core/configuration/Configuration;", "", "coreConfig", "Lcom/datadog/android/core/configuration/Configuration$Core;", "clientToken", "", "env", "variant", "service", "crashReportsEnabled", "", "additionalConfig", "", "version", "(Lcom/datadog/android/core/configuration/Configuration$Core;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Map;Ljava/lang/String;)V", "getAdditionalConfig$dd_sdk_android_core_release", "()Ljava/util/Map;", "getClientToken$dd_sdk_android_core_release", "()Ljava/lang/String;", "getCoreConfig$dd_sdk_android_core_release", "()Lcom/datadog/android/core/configuration/Configuration$Core;", "getCrashReportsEnabled$dd_sdk_android_core_release", "()Z", "getEnv$dd_sdk_android_core_release", "getService$dd_sdk_android_core_release", "getVariant$dd_sdk_android_core_release", "getVersion$dd_sdk_android_core_release", "component1", "component1$dd_sdk_android_core_release", "component2", "component2$dd_sdk_android_core_release", "component3", "component3$dd_sdk_android_core_release", "component4", "component4$dd_sdk_android_core_release", "component5", "component5$dd_sdk_android_core_release", "component6", "component6$dd_sdk_android_core_release", "component7", "component7$dd_sdk_android_core_release", "component8", "component8$dd_sdk_android_core_release", "copy", "equals", "other", "hashCode", "", "toString", "Builder", "Companion", "Core", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class Configuration {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final BackPressureStrategy DEFAULT_BACKPRESSURE_STRATEGY;
    private static final int DEFAULT_BACKPRESSURE_THRESHOLD = 1024;
    private static final Core DEFAULT_CORE_CONFIG;
    public static final String NETWORK_REQUESTS_TRACKING_FEATURE_NAME = "Network requests";
    private static final String NO_VARIANT = "";
    private final Map<String, Object> additionalConfig;
    private final String clientToken;
    private final Core coreConfig;
    private final boolean crashReportsEnabled;
    private final String env;
    private final String service;
    private final String variant;
    private final String version;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Configuration copy$default(Configuration configuration, Core core, String str, String str2, String str3, String str4, boolean z, Map map, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            core = configuration.coreConfig;
        }
        if ((i & 2) != 0) {
            str = configuration.clientToken;
        }
        if ((i & 4) != 0) {
            str2 = configuration.env;
        }
        if ((i & 8) != 0) {
            str3 = configuration.variant;
        }
        if ((i & 16) != 0) {
            str4 = configuration.service;
        }
        if ((i & 32) != 0) {
            z = configuration.crashReportsEnabled;
        }
        if ((i & 64) != 0) {
            map = configuration.additionalConfig;
        }
        if ((i & 128) != 0) {
            str5 = configuration.version;
        }
        Map map2 = map;
        String str6 = str5;
        String str7 = str4;
        boolean z2 = z;
        return configuration.copy(core, str, str2, str3, str7, z2, map2, str6);
    }

    /* JADX INFO: renamed from: component1$dd_sdk_android_core_release, reason: from getter */
    public final Core getCoreConfig() {
        return this.coreConfig;
    }

    /* JADX INFO: renamed from: component2$dd_sdk_android_core_release, reason: from getter */
    public final String getClientToken() {
        return this.clientToken;
    }

    /* JADX INFO: renamed from: component3$dd_sdk_android_core_release, reason: from getter */
    public final String getEnv() {
        return this.env;
    }

    /* JADX INFO: renamed from: component4$dd_sdk_android_core_release, reason: from getter */
    public final String getVariant() {
        return this.variant;
    }

    /* JADX INFO: renamed from: component5$dd_sdk_android_core_release, reason: from getter */
    public final String getService() {
        return this.service;
    }

    /* JADX INFO: renamed from: component6$dd_sdk_android_core_release, reason: from getter */
    public final boolean getCrashReportsEnabled() {
        return this.crashReportsEnabled;
    }

    public final Map<String, Object> component7$dd_sdk_android_core_release() {
        return this.additionalConfig;
    }

    /* JADX INFO: renamed from: component8$dd_sdk_android_core_release, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    public final Configuration copy(Core coreConfig, String clientToken, String env, String variant, String service, boolean crashReportsEnabled, Map<String, ? extends Object> additionalConfig, String version) {
        Intrinsics.checkNotNullParameter(coreConfig, "coreConfig");
        Intrinsics.checkNotNullParameter(clientToken, "clientToken");
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(variant, "variant");
        Intrinsics.checkNotNullParameter(additionalConfig, "additionalConfig");
        return new Configuration(coreConfig, clientToken, env, variant, service, crashReportsEnabled, additionalConfig, version);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Configuration)) {
            return false;
        }
        Configuration configuration = (Configuration) other;
        return Intrinsics.areEqual(this.coreConfig, configuration.coreConfig) && Intrinsics.areEqual(this.clientToken, configuration.clientToken) && Intrinsics.areEqual(this.env, configuration.env) && Intrinsics.areEqual(this.variant, configuration.variant) && Intrinsics.areEqual(this.service, configuration.service) && this.crashReportsEnabled == configuration.crashReportsEnabled && Intrinsics.areEqual(this.additionalConfig, configuration.additionalConfig) && Intrinsics.areEqual(this.version, configuration.version);
    }

    public int hashCode() {
        int iHashCode = ((((((this.coreConfig.hashCode() * 31) + this.clientToken.hashCode()) * 31) + this.env.hashCode()) * 31) + this.variant.hashCode()) * 31;
        String str = this.service;
        int iHashCode2 = (((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.crashReportsEnabled)) * 31) + this.additionalConfig.hashCode()) * 31;
        String str2 = this.version;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "Configuration(coreConfig=" + this.coreConfig + ", clientToken=" + this.clientToken + ", env=" + this.env + ", variant=" + this.variant + ", service=" + this.service + ", crashReportsEnabled=" + this.crashReportsEnabled + ", additionalConfig=" + this.additionalConfig + ", version=" + this.version + ")";
    }

    public Configuration(Core coreConfig, String clientToken, String env, String variant, String str, boolean z, Map<String, ? extends Object> additionalConfig, String str2) {
        Intrinsics.checkNotNullParameter(coreConfig, "coreConfig");
        Intrinsics.checkNotNullParameter(clientToken, "clientToken");
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(variant, "variant");
        Intrinsics.checkNotNullParameter(additionalConfig, "additionalConfig");
        this.coreConfig = coreConfig;
        this.clientToken = clientToken;
        this.env = env;
        this.variant = variant;
        this.service = str;
        this.crashReportsEnabled = z;
        this.additionalConfig = additionalConfig;
        this.version = str2;
    }

    public final Core getCoreConfig$dd_sdk_android_core_release() {
        return this.coreConfig;
    }

    public final String getClientToken$dd_sdk_android_core_release() {
        return this.clientToken;
    }

    public final String getEnv$dd_sdk_android_core_release() {
        return this.env;
    }

    public final String getVariant$dd_sdk_android_core_release() {
        return this.variant;
    }

    public final String getService$dd_sdk_android_core_release() {
        return this.service;
    }

    public final boolean getCrashReportsEnabled$dd_sdk_android_core_release() {
        return this.crashReportsEnabled;
    }

    public final Map<String, Object> getAdditionalConfig$dd_sdk_android_core_release() {
        return this.additionalConfig;
    }

    public final String getVersion$dd_sdk_android_core_release() {
        return this.version;
    }

    /* JADX INFO: compiled from: Configuration.kt */
    @Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\u0002\u0010\u001eJ\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0017HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\t\u0010;\u001a\u00020\u001bHÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\u001b\u0010>\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0006HÆ\u0003J\t\u0010?\u001a\u00020\u000bHÆ\u0003J\t\u0010@\u001a\u00020\rHÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\t\u0010B\u001a\u00020\u0011HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\t\u0010D\u001a\u00020\u0015HÆ\u0003J¥\u0001\u0010E\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u001a\b\u0002\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÆ\u0001J\u0013\u0010F\u001a\u00020\u00032\b\u0010G\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010H\u001a\u00020IHÖ\u0001J\t\u0010J\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R#\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010&R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\b6\u00107¨\u0006K"}, d2 = {"Lcom/datadog/android/core/configuration/Configuration$Core;", "", "needsClearTextHttp", "", "enableDeveloperModeWhenDebuggable", "firstPartyHostsWithHeaderTypes", "", "", "", "Lcom/datadog/android/trace/TracingHeaderType;", "batchSize", "Lcom/datadog/android/core/configuration/BatchSize;", "uploadFrequency", "Lcom/datadog/android/core/configuration/UploadFrequency;", "proxy", "Ljava/net/Proxy;", "proxyAuth", "Lokhttp3/Authenticator;", "encryption", "Lcom/datadog/android/security/Encryption;", GeneralConfig.SITE, "Lcom/datadog/android/DatadogSite;", "batchProcessingLevel", "Lcom/datadog/android/core/configuration/BatchProcessingLevel;", "persistenceStrategyFactory", "Lcom/datadog/android/core/persistence/PersistenceStrategy$Factory;", "backpressureStrategy", "Lcom/datadog/android/core/configuration/BackPressureStrategy;", "uploadSchedulerStrategy", "Lcom/datadog/android/core/configuration/UploadSchedulerStrategy;", "(ZZLjava/util/Map;Lcom/datadog/android/core/configuration/BatchSize;Lcom/datadog/android/core/configuration/UploadFrequency;Ljava/net/Proxy;Lokhttp3/Authenticator;Lcom/datadog/android/security/Encryption;Lcom/datadog/android/DatadogSite;Lcom/datadog/android/core/configuration/BatchProcessingLevel;Lcom/datadog/android/core/persistence/PersistenceStrategy$Factory;Lcom/datadog/android/core/configuration/BackPressureStrategy;Lcom/datadog/android/core/configuration/UploadSchedulerStrategy;)V", "getBackpressureStrategy", "()Lcom/datadog/android/core/configuration/BackPressureStrategy;", "getBatchProcessingLevel", "()Lcom/datadog/android/core/configuration/BatchProcessingLevel;", "getBatchSize", "()Lcom/datadog/android/core/configuration/BatchSize;", "getEnableDeveloperModeWhenDebuggable", "()Z", "getEncryption", "()Lcom/datadog/android/security/Encryption;", "getFirstPartyHostsWithHeaderTypes", "()Ljava/util/Map;", "getNeedsClearTextHttp", "getPersistenceStrategyFactory", "()Lcom/datadog/android/core/persistence/PersistenceStrategy$Factory;", "getProxy", "()Ljava/net/Proxy;", "getProxyAuth", "()Lokhttp3/Authenticator;", "getSite", "()Lcom/datadog/android/DatadogSite;", "getUploadFrequency", "()Lcom/datadog/android/core/configuration/UploadFrequency;", "getUploadSchedulerStrategy", "()Lcom/datadog/android/core/configuration/UploadSchedulerStrategy;", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Core {
        private final BackPressureStrategy backpressureStrategy;
        private final BatchProcessingLevel batchProcessingLevel;
        private final BatchSize batchSize;
        private final boolean enableDeveloperModeWhenDebuggable;
        private final Encryption encryption;
        private final Map<String, Set<TracingHeaderType>> firstPartyHostsWithHeaderTypes;
        private final boolean needsClearTextHttp;
        private final PersistenceStrategy.Factory persistenceStrategyFactory;
        private final Proxy proxy;
        private final Authenticator proxyAuth;
        private final DatadogSite site;
        private final UploadFrequency uploadFrequency;
        private final UploadSchedulerStrategy uploadSchedulerStrategy;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Core copy$default(Core core, boolean z, boolean z2, Map map, BatchSize batchSize, UploadFrequency uploadFrequency, Proxy proxy, Authenticator authenticator, Encryption encryption, DatadogSite datadogSite, BatchProcessingLevel batchProcessingLevel, PersistenceStrategy.Factory factory, BackPressureStrategy backPressureStrategy, UploadSchedulerStrategy uploadSchedulerStrategy, int i, Object obj) {
            if ((i & 1) != 0) {
                z = core.needsClearTextHttp;
            }
            return core.copy(z, (i & 2) != 0 ? core.enableDeveloperModeWhenDebuggable : z2, (i & 4) != 0 ? core.firstPartyHostsWithHeaderTypes : map, (i & 8) != 0 ? core.batchSize : batchSize, (i & 16) != 0 ? core.uploadFrequency : uploadFrequency, (i & 32) != 0 ? core.proxy : proxy, (i & 64) != 0 ? core.proxyAuth : authenticator, (i & 128) != 0 ? core.encryption : encryption, (i & 256) != 0 ? core.site : datadogSite, (i & 512) != 0 ? core.batchProcessingLevel : batchProcessingLevel, (i & 1024) != 0 ? core.persistenceStrategyFactory : factory, (i & 2048) != 0 ? core.backpressureStrategy : backPressureStrategy, (i & 4096) != 0 ? core.uploadSchedulerStrategy : uploadSchedulerStrategy);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getNeedsClearTextHttp() {
            return this.needsClearTextHttp;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final BatchProcessingLevel getBatchProcessingLevel() {
            return this.batchProcessingLevel;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final PersistenceStrategy.Factory getPersistenceStrategyFactory() {
            return this.persistenceStrategyFactory;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final BackPressureStrategy getBackpressureStrategy() {
            return this.backpressureStrategy;
        }

        /* JADX INFO: renamed from: component13, reason: from getter */
        public final UploadSchedulerStrategy getUploadSchedulerStrategy() {
            return this.uploadSchedulerStrategy;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getEnableDeveloperModeWhenDebuggable() {
            return this.enableDeveloperModeWhenDebuggable;
        }

        public final Map<String, Set<TracingHeaderType>> component3() {
            return this.firstPartyHostsWithHeaderTypes;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final BatchSize getBatchSize() {
            return this.batchSize;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final UploadFrequency getUploadFrequency() {
            return this.uploadFrequency;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Proxy getProxy() {
            return this.proxy;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Authenticator getProxyAuth() {
            return this.proxyAuth;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Encryption getEncryption() {
            return this.encryption;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final DatadogSite getSite() {
            return this.site;
        }

        public final Core copy(boolean needsClearTextHttp, boolean enableDeveloperModeWhenDebuggable, Map<String, ? extends Set<? extends TracingHeaderType>> firstPartyHostsWithHeaderTypes, BatchSize batchSize, UploadFrequency uploadFrequency, Proxy proxy, Authenticator proxyAuth, Encryption encryption, DatadogSite site, BatchProcessingLevel batchProcessingLevel, PersistenceStrategy.Factory persistenceStrategyFactory, BackPressureStrategy backpressureStrategy, UploadSchedulerStrategy uploadSchedulerStrategy) {
            Intrinsics.checkNotNullParameter(firstPartyHostsWithHeaderTypes, "firstPartyHostsWithHeaderTypes");
            Intrinsics.checkNotNullParameter(batchSize, "batchSize");
            Intrinsics.checkNotNullParameter(uploadFrequency, "uploadFrequency");
            Intrinsics.checkNotNullParameter(proxyAuth, "proxyAuth");
            Intrinsics.checkNotNullParameter(site, "site");
            Intrinsics.checkNotNullParameter(batchProcessingLevel, "batchProcessingLevel");
            Intrinsics.checkNotNullParameter(backpressureStrategy, "backpressureStrategy");
            return new Core(needsClearTextHttp, enableDeveloperModeWhenDebuggable, firstPartyHostsWithHeaderTypes, batchSize, uploadFrequency, proxy, proxyAuth, encryption, site, batchProcessingLevel, persistenceStrategyFactory, backpressureStrategy, uploadSchedulerStrategy);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Core)) {
                return false;
            }
            Core core = (Core) other;
            return this.needsClearTextHttp == core.needsClearTextHttp && this.enableDeveloperModeWhenDebuggable == core.enableDeveloperModeWhenDebuggable && Intrinsics.areEqual(this.firstPartyHostsWithHeaderTypes, core.firstPartyHostsWithHeaderTypes) && this.batchSize == core.batchSize && this.uploadFrequency == core.uploadFrequency && Intrinsics.areEqual(this.proxy, core.proxy) && Intrinsics.areEqual(this.proxyAuth, core.proxyAuth) && Intrinsics.areEqual(this.encryption, core.encryption) && this.site == core.site && this.batchProcessingLevel == core.batchProcessingLevel && Intrinsics.areEqual(this.persistenceStrategyFactory, core.persistenceStrategyFactory) && Intrinsics.areEqual(this.backpressureStrategy, core.backpressureStrategy) && Intrinsics.areEqual(this.uploadSchedulerStrategy, core.uploadSchedulerStrategy);
        }

        public int hashCode() {
            int iHashCode = ((((((((Boolean.hashCode(this.needsClearTextHttp) * 31) + Boolean.hashCode(this.enableDeveloperModeWhenDebuggable)) * 31) + this.firstPartyHostsWithHeaderTypes.hashCode()) * 31) + this.batchSize.hashCode()) * 31) + this.uploadFrequency.hashCode()) * 31;
            Proxy proxy = this.proxy;
            int iHashCode2 = (((iHashCode + (proxy == null ? 0 : proxy.hashCode())) * 31) + this.proxyAuth.hashCode()) * 31;
            Encryption encryption = this.encryption;
            int iHashCode3 = (((((iHashCode2 + (encryption == null ? 0 : encryption.hashCode())) * 31) + this.site.hashCode()) * 31) + this.batchProcessingLevel.hashCode()) * 31;
            PersistenceStrategy.Factory factory = this.persistenceStrategyFactory;
            int iHashCode4 = (((iHashCode3 + (factory == null ? 0 : factory.hashCode())) * 31) + this.backpressureStrategy.hashCode()) * 31;
            UploadSchedulerStrategy uploadSchedulerStrategy = this.uploadSchedulerStrategy;
            return iHashCode4 + (uploadSchedulerStrategy != null ? uploadSchedulerStrategy.hashCode() : 0);
        }

        public String toString() {
            return "Core(needsClearTextHttp=" + this.needsClearTextHttp + ", enableDeveloperModeWhenDebuggable=" + this.enableDeveloperModeWhenDebuggable + ", firstPartyHostsWithHeaderTypes=" + this.firstPartyHostsWithHeaderTypes + ", batchSize=" + this.batchSize + ", uploadFrequency=" + this.uploadFrequency + ", proxy=" + this.proxy + ", proxyAuth=" + this.proxyAuth + ", encryption=" + this.encryption + ", site=" + this.site + ", batchProcessingLevel=" + this.batchProcessingLevel + ", persistenceStrategyFactory=" + this.persistenceStrategyFactory + ", backpressureStrategy=" + this.backpressureStrategy + ", uploadSchedulerStrategy=" + this.uploadSchedulerStrategy + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Core(boolean z, boolean z2, Map<String, ? extends Set<? extends TracingHeaderType>> firstPartyHostsWithHeaderTypes, BatchSize batchSize, UploadFrequency uploadFrequency, Proxy proxy, Authenticator proxyAuth, Encryption encryption, DatadogSite site, BatchProcessingLevel batchProcessingLevel, PersistenceStrategy.Factory factory, BackPressureStrategy backpressureStrategy, UploadSchedulerStrategy uploadSchedulerStrategy) {
            Intrinsics.checkNotNullParameter(firstPartyHostsWithHeaderTypes, "firstPartyHostsWithHeaderTypes");
            Intrinsics.checkNotNullParameter(batchSize, "batchSize");
            Intrinsics.checkNotNullParameter(uploadFrequency, "uploadFrequency");
            Intrinsics.checkNotNullParameter(proxyAuth, "proxyAuth");
            Intrinsics.checkNotNullParameter(site, "site");
            Intrinsics.checkNotNullParameter(batchProcessingLevel, "batchProcessingLevel");
            Intrinsics.checkNotNullParameter(backpressureStrategy, "backpressureStrategy");
            this.needsClearTextHttp = z;
            this.enableDeveloperModeWhenDebuggable = z2;
            this.firstPartyHostsWithHeaderTypes = firstPartyHostsWithHeaderTypes;
            this.batchSize = batchSize;
            this.uploadFrequency = uploadFrequency;
            this.proxy = proxy;
            this.proxyAuth = proxyAuth;
            this.encryption = encryption;
            this.site = site;
            this.batchProcessingLevel = batchProcessingLevel;
            this.persistenceStrategyFactory = factory;
            this.backpressureStrategy = backpressureStrategy;
            this.uploadSchedulerStrategy = uploadSchedulerStrategy;
        }

        public final boolean getNeedsClearTextHttp() {
            return this.needsClearTextHttp;
        }

        public final boolean getEnableDeveloperModeWhenDebuggable() {
            return this.enableDeveloperModeWhenDebuggable;
        }

        public final Map<String, Set<TracingHeaderType>> getFirstPartyHostsWithHeaderTypes() {
            return this.firstPartyHostsWithHeaderTypes;
        }

        public final BatchSize getBatchSize() {
            return this.batchSize;
        }

        public final UploadFrequency getUploadFrequency() {
            return this.uploadFrequency;
        }

        public final Proxy getProxy() {
            return this.proxy;
        }

        public final Authenticator getProxyAuth() {
            return this.proxyAuth;
        }

        public final Encryption getEncryption() {
            return this.encryption;
        }

        public final DatadogSite getSite() {
            return this.site;
        }

        public final BatchProcessingLevel getBatchProcessingLevel() {
            return this.batchProcessingLevel;
        }

        public final PersistenceStrategy.Factory getPersistenceStrategyFactory() {
            return this.persistenceStrategyFactory;
        }

        public final BackPressureStrategy getBackpressureStrategy() {
            return this.backpressureStrategy;
        }

        public final UploadSchedulerStrategy getUploadSchedulerStrategy() {
            return this.uploadSchedulerStrategy;
        }
    }

    /* JADX INFO: compiled from: Configuration.kt */
    /* JADX INFO: loaded from: classes6.dex */
    @Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B-\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\r\u0010\u0015\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u0016J\u0006\u0010\u0017\u001a\u00020\u0018J\u001a\u0010\u0019\u001a\u00020\u00002\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\tJ\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&J\u0014\u0010'\u001a\u00020\u00002\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00030)J \u0010*\u001a\u00020\u00002\u0018\u0010+\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0,0\tJ\u0010\u0010.\u001a\u00020\u00002\b\u0010/\u001a\u0004\u0018\u000100J\u0018\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u000105J\u000e\u00106\u001a\u00020\u00002\u0006\u00107\u001a\u000208J\u0010\u00109\u001a\u00020\u00002\b\u0010:\u001a\u0004\u0018\u00010;J\u000e\u0010<\u001a\u00020\u00002\u0006\u0010=\u001a\u00020\rJ\u000e\u0010>\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0003J\u000e\u0010?\u001a\u00020\u00002\u0006\u0010@\u001a\u00020AR\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/datadog/android/core/configuration/Configuration$Builder;", "", "clientToken", "", "env", "variant", "service", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "additionalConfig", "", "coreConfig", "Lcom/datadog/android/core/configuration/Configuration$Core;", "crashReportsEnabled", "", "hostsSanitizer", "Lcom/datadog/android/core/configuration/HostsSanitizer;", "getHostsSanitizer$dd_sdk_android_core_release", "()Lcom/datadog/android/core/configuration/HostsSanitizer;", "setHostsSanitizer$dd_sdk_android_core_release", "(Lcom/datadog/android/core/configuration/HostsSanitizer;)V", "version", "allowClearTextHttp", "allowClearTextHttp$dd_sdk_android_core_release", "build", "Lcom/datadog/android/core/configuration/Configuration;", "setAdditionalConfiguration", "setBackpressureStrategy", "backpressureStrategy", "Lcom/datadog/android/core/configuration/BackPressureStrategy;", "setBatchProcessingLevel", "batchProcessingLevel", "Lcom/datadog/android/core/configuration/BatchProcessingLevel;", "setBatchSize", "batchSize", "Lcom/datadog/android/core/configuration/BatchSize;", "setCrashReportsEnabled", "setEncryption", "dataEncryption", "Lcom/datadog/android/security/Encryption;", "setFirstPartyHosts", "hosts", "", "setFirstPartyHostsWithHeaderType", "hostsWithHeaderType", "", "Lcom/datadog/android/trace/TracingHeaderType;", "setPersistenceStrategyFactory", "persistenceStrategyFactory", "Lcom/datadog/android/core/persistence/PersistenceStrategy$Factory;", "setProxy", "proxy", "Ljava/net/Proxy;", "authenticator", "Lokhttp3/Authenticator;", "setUploadFrequency", "uploadFrequency", "Lcom/datadog/android/core/configuration/UploadFrequency;", "setUploadSchedulerStrategy", "uploadSchedulerStrategy", "Lcom/datadog/android/core/configuration/UploadSchedulerStrategy;", "setUseDeveloperModeWhenDebuggable", "developerModeEnabled", "setVersion", "useSite", GeneralConfig.SITE, "Lcom/datadog/android/DatadogSite;", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Builder {
        private Map<String, ? extends Object> additionalConfig;
        private final String clientToken;
        private Core coreConfig;
        private boolean crashReportsEnabled;
        private final String env;
        private HostsSanitizer hostsSanitizer;
        private final String service;
        private final String variant;
        private String version;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(String clientToken, String env) {
            this(clientToken, env, null, null, 12, null);
            Intrinsics.checkNotNullParameter(clientToken, "clientToken");
            Intrinsics.checkNotNullParameter(env, "env");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(String clientToken, String env, String variant) {
            this(clientToken, env, variant, null, 8, null);
            Intrinsics.checkNotNullParameter(clientToken, "clientToken");
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(variant, "variant");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Builder(String clientToken, String env, String variant, String str) {
            Intrinsics.checkNotNullParameter(clientToken, "clientToken");
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(variant, "variant");
            this.clientToken = clientToken;
            this.env = env;
            this.variant = variant;
            this.service = str;
            this.additionalConfig = MapsKt.emptyMap();
            this.coreConfig = Configuration.INSTANCE.getDEFAULT_CORE_CONFIG$dd_sdk_android_core_release();
            this.crashReportsEnabled = true;
            this.hostsSanitizer = new HostsSanitizer(null, 1, 0 == true ? 1 : 0);
        }

        public /* synthetic */ Builder(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? null : str4);
        }

        /* JADX INFO: renamed from: getHostsSanitizer$dd_sdk_android_core_release, reason: from getter */
        public final HostsSanitizer getHostsSanitizer() {
            return this.hostsSanitizer;
        }

        public final void setHostsSanitizer$dd_sdk_android_core_release(HostsSanitizer hostsSanitizer) {
            Intrinsics.checkNotNullParameter(hostsSanitizer, "<set-?>");
            this.hostsSanitizer = hostsSanitizer;
        }

        public final Configuration build() {
            return new Configuration(this.coreConfig, this.clientToken, this.env, this.variant, this.service, this.crashReportsEnabled, this.additionalConfig, this.version);
        }

        public final Builder setUseDeveloperModeWhenDebuggable(boolean developerModeEnabled) {
            this.coreConfig = Core.copy$default(this.coreConfig, false, developerModeEnabled, null, null, null, null, null, null, null, null, null, null, null, 8189, null);
            return this;
        }

        public final Builder setFirstPartyHosts(List<String> hosts) {
            Intrinsics.checkNotNullParameter(hosts, "hosts");
            List<String> listSanitizeHosts = this.hostsSanitizer.sanitizeHosts(hosts, Configuration.NETWORK_REQUESTS_TRACKING_FEATURE_NAME);
            Core core = this.coreConfig;
            List<String> list = listSanitizeHosts;
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
            for (Object obj : list) {
                linkedHashMap.put(obj, SetsKt.setOf((Object[]) new TracingHeaderType[]{TracingHeaderType.DATADOG, TracingHeaderType.TRACECONTEXT}));
            }
            this.coreConfig = Core.copy$default(core, false, false, linkedHashMap, null, null, null, null, null, null, null, null, null, null, 8187, null);
            return this;
        }

        public final Builder setFirstPartyHostsWithHeaderType(Map<String, ? extends Set<? extends TracingHeaderType>> hostsWithHeaderType) {
            Intrinsics.checkNotNullParameter(hostsWithHeaderType, "hostsWithHeaderType");
            List<String> listSanitizeHosts = this.hostsSanitizer.sanitizeHosts(CollectionsKt.toList(hostsWithHeaderType.keySet()), Configuration.NETWORK_REQUESTS_TRACKING_FEATURE_NAME);
            Core core = this.coreConfig;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, ? extends Set<? extends TracingHeaderType>> entry : hostsWithHeaderType.entrySet()) {
                if (listSanitizeHosts.contains(entry.getKey())) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            this.coreConfig = Core.copy$default(core, false, false, linkedHashMap, null, null, null, null, null, null, null, null, null, null, 8187, null);
            return this;
        }

        public final Builder useSite(DatadogSite site) {
            Intrinsics.checkNotNullParameter(site, "site");
            this.coreConfig = Core.copy$default(this.coreConfig, false, false, null, null, null, null, null, null, site, null, null, null, null, 7934, null);
            return this;
        }

        public final Builder setBatchSize(BatchSize batchSize) {
            Intrinsics.checkNotNullParameter(batchSize, "batchSize");
            this.coreConfig = Core.copy$default(this.coreConfig, false, false, null, batchSize, null, null, null, null, null, null, null, null, null, 8183, null);
            return this;
        }

        public final Builder setUploadFrequency(UploadFrequency uploadFrequency) {
            Intrinsics.checkNotNullParameter(uploadFrequency, "uploadFrequency");
            this.coreConfig = Core.copy$default(this.coreConfig, false, false, null, null, uploadFrequency, null, null, null, null, null, null, null, null, 8175, null);
            return this;
        }

        public final Builder setBatchProcessingLevel(BatchProcessingLevel batchProcessingLevel) {
            Intrinsics.checkNotNullParameter(batchProcessingLevel, "batchProcessingLevel");
            this.coreConfig = Core.copy$default(this.coreConfig, false, false, null, null, null, null, null, null, null, batchProcessingLevel, null, null, null, 7679, null);
            return this;
        }

        public final Builder setAdditionalConfiguration(Map<String, ? extends Object> additionalConfig) {
            Intrinsics.checkNotNullParameter(additionalConfig, "additionalConfig");
            this.additionalConfig = additionalConfig;
            return this;
        }

        public final Builder setProxy(Proxy proxy, Authenticator authenticator) {
            Intrinsics.checkNotNullParameter(proxy, "proxy");
            this.coreConfig = Core.copy$default(this.coreConfig, false, false, null, null, null, proxy, authenticator == null ? Authenticator.NONE : authenticator, null, null, null, null, null, null, 8095, null);
            return this;
        }

        public final Builder setEncryption(Encryption dataEncryption) {
            Intrinsics.checkNotNullParameter(dataEncryption, "dataEncryption");
            this.coreConfig = Core.copy$default(this.coreConfig, false, false, null, null, null, null, null, dataEncryption, null, null, null, null, null, 8063, null);
            return this;
        }

        public final Builder setPersistenceStrategyFactory(PersistenceStrategy.Factory persistenceStrategyFactory) {
            this.coreConfig = Core.copy$default(this.coreConfig, false, false, null, null, null, null, null, null, null, null, persistenceStrategyFactory, null, null, 7167, null);
            return this;
        }

        public final Builder setCrashReportsEnabled(boolean crashReportsEnabled) {
            this.crashReportsEnabled = crashReportsEnabled;
            return this;
        }

        public final Builder setBackpressureStrategy(BackPressureStrategy backpressureStrategy) {
            Intrinsics.checkNotNullParameter(backpressureStrategy, "backpressureStrategy");
            this.coreConfig = Core.copy$default(this.coreConfig, false, false, null, null, null, null, null, null, null, null, null, backpressureStrategy, null, 6143, null);
            return this;
        }

        public final Builder setUploadSchedulerStrategy(UploadSchedulerStrategy uploadSchedulerStrategy) {
            this.coreConfig = Core.copy$default(this.coreConfig, false, false, null, null, null, null, null, null, null, null, null, null, uploadSchedulerStrategy, 4095, null);
            return this;
        }

        public final Builder setVersion(String version) {
            Intrinsics.checkNotNullParameter(version, "version");
            this.version = version;
            return this;
        }

        public final Builder allowClearTextHttp$dd_sdk_android_core_release() {
            this.coreConfig = Core.copy$default(this.coreConfig, true, false, null, null, null, null, null, null, null, null, null, null, null, 8190, null);
            return this;
        }
    }

    /* JADX INFO: compiled from: Configuration.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/datadog/android/core/configuration/Configuration$Companion;", "", "()V", "DEFAULT_BACKPRESSURE_STRATEGY", "Lcom/datadog/android/core/configuration/BackPressureStrategy;", "getDEFAULT_BACKPRESSURE_STRATEGY$dd_sdk_android_core_release", "()Lcom/datadog/android/core/configuration/BackPressureStrategy;", "DEFAULT_BACKPRESSURE_THRESHOLD", "", "DEFAULT_CORE_CONFIG", "Lcom/datadog/android/core/configuration/Configuration$Core;", "getDEFAULT_CORE_CONFIG$dd_sdk_android_core_release", "()Lcom/datadog/android/core/configuration/Configuration$Core;", "NETWORK_REQUESTS_TRACKING_FEATURE_NAME", "", "NO_VARIANT", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BackPressureStrategy getDEFAULT_BACKPRESSURE_STRATEGY$dd_sdk_android_core_release() {
            return Configuration.DEFAULT_BACKPRESSURE_STRATEGY;
        }

        public final Core getDEFAULT_CORE_CONFIG$dd_sdk_android_core_release() {
            return Configuration.DEFAULT_CORE_CONFIG;
        }
    }

    static {
        BackPressureStrategy backPressureStrategy = new BackPressureStrategy(1024, new Function0<Unit>() { // from class: com.datadog.android.core.configuration.Configuration$Companion$DEFAULT_BACKPRESSURE_STRATEGY$1
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        }, new Function1<Object, Unit>() { // from class: com.datadog.android.core.configuration.Configuration$Companion$DEFAULT_BACKPRESSURE_STRATEGY$2
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }
        }, BackPressureMitigation.IGNORE_NEWEST);
        DEFAULT_BACKPRESSURE_STRATEGY = backPressureStrategy;
        DEFAULT_CORE_CONFIG = new Core(false, false, MapsKt.emptyMap(), BatchSize.MEDIUM, UploadFrequency.AVERAGE, null, Authenticator.NONE, null, DatadogSite.US1, BatchProcessingLevel.MEDIUM, null, backPressureStrategy, null);
    }
}
