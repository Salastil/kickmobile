package expo.modules.updates;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.datadog.android.log.LogAttributes;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.core.errors.InvalidArgumentException;
import expo.modules.updates.codesigning.CodeSigningConfiguration;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: UpdatesConfiguration.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b!\b\u0086\b\u0018\u0000 ^2\u00020\u0001:\u0002]^Bá\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0010\u0012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0010\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010\u0012\u0006\u0010\u0014\u001a\u00020\r\u0012\u0006\u0010\u0015\u001a\u00020\r\u0012\u0006\u0010\u0016\u001a\u00020\r\u0012\u0006\u0010\u0017\u001a\u00020\r\u0012\u0006\u0010\u0018\u001a\u00020\r\u0012\b\b\u0002\u0010\u0019\u001a\u00020\t\u0012\u0006\u0010\u001a\u001a\u00020\r\u0012\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0010¢\u0006\u0004\b\u001c\u0010\u001dB)\b\u0016\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0010¢\u0006\u0004\b\u001c\u0010!B;\b\u0010\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0010\u0012\u0006\u0010\u0018\u001a\u00020\r\u0012\b\u0010\"\u001a\u0004\u0018\u00010#¢\u0006\u0004\b\u001c\u0010$J\u0006\u0010C\u001a\u00020\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0005HÆ\u0003J\t\u0010F\u001a\u00020\u0005HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010H\u001a\u00020\tHÆ\u0003J\t\u0010I\u001a\u00020\u000bHÆ\u0003J\t\u0010J\u001a\u00020\rHÆ\u0003J\t\u0010K\u001a\u00020\rHÆ\u0003J\u0015\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0010HÆ\u0003J\u0015\u0010M\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0010HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010O\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010HÆ\u0003J\t\u0010P\u001a\u00020\rHÆ\u0003J\t\u0010Q\u001a\u00020\rHÂ\u0003J\t\u0010R\u001a\u00020\rHÆ\u0003J\t\u0010S\u001a\u00020\rHÆ\u0003J\t\u0010T\u001a\u00020\rHÆ\u0003J\t\u0010U\u001a\u00020\tHÆ\u0003J\t\u0010V\u001a\u00020\rHÆ\u0003J\u0017\u0010W\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0010HÂ\u0003J\u0089\u0002\u0010X\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00102\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00102\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010\u0019\u001a\u00020\t2\b\b\u0002\u0010\u001a\u001a\u00020\r2\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0010HÆ\u0001J\u0014\u0010Y\u001a\u00020\r2\b\u0010Z\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010[\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\\\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010(R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010&R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b1\u00100R\u001d\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0010¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u001d\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0010¢\u0006\b\n\u0000\u001a\u0004\b4\u00103R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010&R\u001f\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b6\u00103R\u0011\u0010\u0014\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b7\u00100R\u000e\u0010\u0015\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0016\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b8\u00100R\u0011\u0010\u0017\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b9\u00100R\u0011\u0010\u0018\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b:\u00100R\u0011\u0010\u0019\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b;\u0010,R\u0011\u0010\u001a\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b<\u00100R\u001c\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010=\u001a\u0004\u0018\u00010>8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\b?\u0010@¨\u0006_"}, d2 = {"Lexpo/modules/updates/UpdatesConfiguration;", "", UpdatesConfiguration.UPDATES_CONFIGURATION_SCOPE_KEY_KEY, "", UpdatesConfiguration.UPDATES_CONFIGURATION_UPDATE_URL_KEY, "Landroid/net/Uri;", "originalEmbeddedUpdateUrl", "runtimeVersionRaw", UpdatesConfiguration.UPDATES_CONFIGURATION_LAUNCH_WAIT_MS_KEY, "", UpdatesConfiguration.UPDATES_CONFIGURATION_CHECK_ON_LAUNCH_KEY, "Lexpo/modules/updates/UpdatesConfiguration$CheckAutomaticallyConfiguration;", UpdatesConfiguration.UPDATES_CONFIGURATION_HAS_EMBEDDED_UPDATE_KEY, "", "originalHasEmbeddedUpdate", UpdatesConfiguration.UPDATES_CONFIGURATION_REQUEST_HEADERS_KEY, "", "originalEmbeddedRequestHeaders", UpdatesConfiguration.UPDATES_CONFIGURATION_CODE_SIGNING_CERTIFICATE, UpdatesConfiguration.UPDATES_CONFIGURATION_CODE_SIGNING_METADATA, UpdatesConfiguration.UPDATES_CONFIGURATION_CODE_SIGNING_INCLUDE_MANIFEST_RESPONSE_CERTIFICATE_CHAIN, UpdatesConfiguration.UPDATES_CONFIGURATION_CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS, "enableExpoUpdatesProtocolV0CompatibilityMode", UpdatesConfiguration.UPDATES_CONFIGURATION_ENABLE_BSDIFF_PATCH_SUPPORT, UpdatesConfiguration.UPDATES_CONFIGURATION_DISABLE_ANTI_BRICKING_MEASURES, UpdatesConfiguration.UPDATES_CONFIGURATION_MAX_UPDATES_TO_KEEP_KEY, "hasUpdatesOverride", "cachedOverrideMap", "<init>", "(Ljava/lang/String;Landroid/net/Uri;Landroid/net/Uri;Ljava/lang/String;ILexpo/modules/updates/UpdatesConfiguration$CheckAutomaticallyConfiguration;ZZLjava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/util/Map;ZZZZZIZLjava/util/Map;)V", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "overrideMap", "(Landroid/content/Context;Ljava/util/Map;)V", "configOverride", "Lexpo/modules/updates/UpdatesConfigurationOverride;", "(Landroid/content/Context;Ljava/util/Map;ZLexpo/modules/updates/UpdatesConfigurationOverride;)V", "getScopeKey", "()Ljava/lang/String;", "getUpdateUrl", "()Landroid/net/Uri;", "getOriginalEmbeddedUpdateUrl", "getRuntimeVersionRaw", "getLaunchWaitMs", "()I", "getCheckOnLaunch", "()Lexpo/modules/updates/UpdatesConfiguration$CheckAutomaticallyConfiguration;", "getHasEmbeddedUpdate", "()Z", "getOriginalHasEmbeddedUpdate", "getRequestHeaders", "()Ljava/util/Map;", "getOriginalEmbeddedRequestHeaders", "getCodeSigningCertificate", "getCodeSigningMetadata", "getCodeSigningIncludeManifestResponseCertificateChain", "getEnableExpoUpdatesProtocolV0CompatibilityMode", "getEnableBsdiffPatchSupport", "getDisableAntiBrickingMeasures", "getMaxUpdatesToKeep", "getHasUpdatesOverride", "codeSigningConfiguration", "Lexpo/modules/updates/codesigning/CodeSigningConfiguration;", "getCodeSigningConfiguration", "()Lexpo/modules/updates/codesigning/CodeSigningConfiguration;", "codeSigningConfiguration$delegate", "Lkotlin/Lazy;", "getRuntimeVersion", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "copy", "equals", "other", "hashCode", "toString", "CheckAutomaticallyConfiguration", "Companion", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class UpdatesConfiguration {
    private static final String FINGERPRINT_FILE_NAME = "fingerprint";
    public static final String UPDATES_CONFIGURATION_CHECK_ON_LAUNCH_KEY = "checkOnLaunch";
    public static final String UPDATES_CONFIGURATION_CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS = "codeSigningAllowUnsignedManifests";
    public static final String UPDATES_CONFIGURATION_CODE_SIGNING_CERTIFICATE = "codeSigningCertificate";
    public static final String UPDATES_CONFIGURATION_CODE_SIGNING_INCLUDE_MANIFEST_RESPONSE_CERTIFICATE_CHAIN = "codeSigningIncludeManifestResponseCertificateChain";
    public static final String UPDATES_CONFIGURATION_CODE_SIGNING_METADATA = "codeSigningMetadata";
    public static final String UPDATES_CONFIGURATION_DISABLE_ANTI_BRICKING_MEASURES = "disableAntiBrickingMeasures";
    public static final String UPDATES_CONFIGURATION_ENABLED_KEY = "enabled";
    public static final String UPDATES_CONFIGURATION_ENABLE_BSDIFF_PATCH_SUPPORT = "enableBsdiffPatchSupport";
    public static final String UPDATES_CONFIGURATION_ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE = "enableExpoUpdatesProtocolCompatibilityMode";
    public static final String UPDATES_CONFIGURATION_HAS_EMBEDDED_UPDATE_KEY = "hasEmbeddedUpdate";
    private static final int UPDATES_CONFIGURATION_LAUNCH_WAIT_MS_DEFAULT_VALUE = 0;
    public static final String UPDATES_CONFIGURATION_LAUNCH_WAIT_MS_KEY = "launchWaitMs";
    private static final int UPDATES_CONFIGURATION_MAX_UPDATES_TO_KEEP_DEFAULT_VALUE = 2;
    public static final String UPDATES_CONFIGURATION_MAX_UPDATES_TO_KEEP_KEY = "maxUpdatesToKeep";
    private static final int UPDATES_CONFIGURATION_MAX_UPDATES_TO_KEEP_MIN_VALUE = 2;
    public static final String UPDATES_CONFIGURATION_REQUEST_HEADERS_KEY = "requestHeaders";
    public static final String UPDATES_CONFIGURATION_RUNTIME_VERSION_KEY = "runtimeVersion";
    public static final String UPDATES_CONFIGURATION_RUNTIME_VERSION_READ_FINGERPRINT_FILE_SENTINEL = "file:fingerprint";
    public static final String UPDATES_CONFIGURATION_SCOPE_KEY_KEY = "scopeKey";
    public static final String UPDATES_CONFIGURATION_UPDATE_URL_KEY = "updateUrl";
    private final Map<String, Object> cachedOverrideMap;
    private final CheckAutomaticallyConfiguration checkOnLaunch;
    private final boolean codeSigningAllowUnsignedManifests;
    private final String codeSigningCertificate;

    /* JADX INFO: renamed from: codeSigningConfiguration$delegate, reason: from kotlin metadata */
    private final Lazy codeSigningConfiguration;
    private final boolean codeSigningIncludeManifestResponseCertificateChain;
    private final Map<String, String> codeSigningMetadata;
    private final boolean disableAntiBrickingMeasures;
    private final boolean enableBsdiffPatchSupport;
    private final boolean enableExpoUpdatesProtocolV0CompatibilityMode;
    private final boolean hasEmbeddedUpdate;
    private final boolean hasUpdatesOverride;
    private final int launchWaitMs;
    private final int maxUpdatesToKeep;
    private final Map<String, String> originalEmbeddedRequestHeaders;
    private final Uri originalEmbeddedUpdateUrl;
    private final boolean originalHasEmbeddedUpdate;
    private final Map<String, String> requestHeaders;
    private final String runtimeVersionRaw;
    private final String scopeKey;
    private final Uri updateUrl;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "UpdatesConfiguration";

    /* JADX INFO: renamed from: component14, reason: from getter */
    private final boolean getCodeSigningAllowUnsignedManifests() {
        return this.codeSigningAllowUnsignedManifests;
    }

    private final Map<String, Object> component20() {
        return this.cachedOverrideMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UpdatesConfiguration copy$default(UpdatesConfiguration updatesConfiguration, String str, Uri uri, Uri uri2, String str2, int i, CheckAutomaticallyConfiguration checkAutomaticallyConfiguration, boolean z, boolean z2, Map map, Map map2, String str3, Map map3, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i2, boolean z8, Map map4, int i3, Object obj) {
        Map map5;
        boolean z9;
        String str4 = (i3 & 1) != 0 ? updatesConfiguration.scopeKey : str;
        Uri uri3 = (i3 & 2) != 0 ? updatesConfiguration.updateUrl : uri;
        Uri uri4 = (i3 & 4) != 0 ? updatesConfiguration.originalEmbeddedUpdateUrl : uri2;
        String str5 = (i3 & 8) != 0 ? updatesConfiguration.runtimeVersionRaw : str2;
        int i4 = (i3 & 16) != 0 ? updatesConfiguration.launchWaitMs : i;
        CheckAutomaticallyConfiguration checkAutomaticallyConfiguration2 = (i3 & 32) != 0 ? updatesConfiguration.checkOnLaunch : checkAutomaticallyConfiguration;
        boolean z10 = (i3 & 64) != 0 ? updatesConfiguration.hasEmbeddedUpdate : z;
        boolean z11 = (i3 & 128) != 0 ? updatesConfiguration.originalHasEmbeddedUpdate : z2;
        Map map6 = (i3 & 256) != 0 ? updatesConfiguration.requestHeaders : map;
        Map map7 = (i3 & 512) != 0 ? updatesConfiguration.originalEmbeddedRequestHeaders : map2;
        String str6 = (i3 & 1024) != 0 ? updatesConfiguration.codeSigningCertificate : str3;
        Map map8 = (i3 & 2048) != 0 ? updatesConfiguration.codeSigningMetadata : map3;
        boolean z12 = (i3 & 4096) != 0 ? updatesConfiguration.codeSigningIncludeManifestResponseCertificateChain : z3;
        boolean z13 = (i3 & 8192) != 0 ? updatesConfiguration.codeSigningAllowUnsignedManifests : z4;
        String str7 = str4;
        boolean z14 = (i3 & 16384) != 0 ? updatesConfiguration.enableExpoUpdatesProtocolV0CompatibilityMode : z5;
        boolean z15 = (i3 & 32768) != 0 ? updatesConfiguration.enableBsdiffPatchSupport : z6;
        boolean z16 = (i3 & 65536) != 0 ? updatesConfiguration.disableAntiBrickingMeasures : z7;
        int i5 = (i3 & 131072) != 0 ? updatesConfiguration.maxUpdatesToKeep : i2;
        boolean z17 = (i3 & 262144) != 0 ? updatesConfiguration.hasUpdatesOverride : z8;
        if ((i3 & 524288) != 0) {
            z9 = z17;
            map5 = updatesConfiguration.cachedOverrideMap;
        } else {
            map5 = map4;
            z9 = z17;
        }
        return updatesConfiguration.copy(str7, uri3, uri4, str5, i4, checkAutomaticallyConfiguration2, z10, z11, map6, map7, str6, map8, z12, z13, z14, z15, z16, i5, z9, map5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getScopeKey() {
        return this.scopeKey;
    }

    public final Map<String, String> component10() {
        return this.originalEmbeddedRequestHeaders;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getCodeSigningCertificate() {
        return this.codeSigningCertificate;
    }

    public final Map<String, String> component12() {
        return this.codeSigningMetadata;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final boolean getCodeSigningIncludeManifestResponseCertificateChain() {
        return this.codeSigningIncludeManifestResponseCertificateChain;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final boolean getEnableExpoUpdatesProtocolV0CompatibilityMode() {
        return this.enableExpoUpdatesProtocolV0CompatibilityMode;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final boolean getEnableBsdiffPatchSupport() {
        return this.enableBsdiffPatchSupport;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final boolean getDisableAntiBrickingMeasures() {
        return this.disableAntiBrickingMeasures;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final int getMaxUpdatesToKeep() {
        return this.maxUpdatesToKeep;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final boolean getHasUpdatesOverride() {
        return this.hasUpdatesOverride;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Uri getUpdateUrl() {
        return this.updateUrl;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Uri getOriginalEmbeddedUpdateUrl() {
        return this.originalEmbeddedUpdateUrl;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getRuntimeVersionRaw() {
        return this.runtimeVersionRaw;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getLaunchWaitMs() {
        return this.launchWaitMs;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final CheckAutomaticallyConfiguration getCheckOnLaunch() {
        return this.checkOnLaunch;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getHasEmbeddedUpdate() {
        return this.hasEmbeddedUpdate;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getOriginalHasEmbeddedUpdate() {
        return this.originalHasEmbeddedUpdate;
    }

    public final Map<String, String> component9() {
        return this.requestHeaders;
    }

    public final UpdatesConfiguration copy(String scopeKey, Uri updateUrl, Uri originalEmbeddedUpdateUrl, String runtimeVersionRaw, int launchWaitMs, CheckAutomaticallyConfiguration checkOnLaunch, boolean hasEmbeddedUpdate, boolean originalHasEmbeddedUpdate, Map<String, String> requestHeaders, Map<String, String> originalEmbeddedRequestHeaders, String codeSigningCertificate, Map<String, String> codeSigningMetadata, boolean codeSigningIncludeManifestResponseCertificateChain, boolean codeSigningAllowUnsignedManifests, boolean enableExpoUpdatesProtocolV0CompatibilityMode, boolean enableBsdiffPatchSupport, boolean disableAntiBrickingMeasures, int maxUpdatesToKeep, boolean hasUpdatesOverride, Map<String, ? extends Object> cachedOverrideMap) {
        Intrinsics.checkNotNullParameter(scopeKey, "scopeKey");
        Intrinsics.checkNotNullParameter(updateUrl, "updateUrl");
        Intrinsics.checkNotNullParameter(originalEmbeddedUpdateUrl, "originalEmbeddedUpdateUrl");
        Intrinsics.checkNotNullParameter(checkOnLaunch, "checkOnLaunch");
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        Intrinsics.checkNotNullParameter(originalEmbeddedRequestHeaders, "originalEmbeddedRequestHeaders");
        return new UpdatesConfiguration(scopeKey, updateUrl, originalEmbeddedUpdateUrl, runtimeVersionRaw, launchWaitMs, checkOnLaunch, hasEmbeddedUpdate, originalHasEmbeddedUpdate, requestHeaders, originalEmbeddedRequestHeaders, codeSigningCertificate, codeSigningMetadata, codeSigningIncludeManifestResponseCertificateChain, codeSigningAllowUnsignedManifests, enableExpoUpdatesProtocolV0CompatibilityMode, enableBsdiffPatchSupport, disableAntiBrickingMeasures, maxUpdatesToKeep, hasUpdatesOverride, cachedOverrideMap);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UpdatesConfiguration)) {
            return false;
        }
        UpdatesConfiguration updatesConfiguration = (UpdatesConfiguration) other;
        return Intrinsics.areEqual(this.scopeKey, updatesConfiguration.scopeKey) && Intrinsics.areEqual(this.updateUrl, updatesConfiguration.updateUrl) && Intrinsics.areEqual(this.originalEmbeddedUpdateUrl, updatesConfiguration.originalEmbeddedUpdateUrl) && Intrinsics.areEqual(this.runtimeVersionRaw, updatesConfiguration.runtimeVersionRaw) && this.launchWaitMs == updatesConfiguration.launchWaitMs && this.checkOnLaunch == updatesConfiguration.checkOnLaunch && this.hasEmbeddedUpdate == updatesConfiguration.hasEmbeddedUpdate && this.originalHasEmbeddedUpdate == updatesConfiguration.originalHasEmbeddedUpdate && Intrinsics.areEqual(this.requestHeaders, updatesConfiguration.requestHeaders) && Intrinsics.areEqual(this.originalEmbeddedRequestHeaders, updatesConfiguration.originalEmbeddedRequestHeaders) && Intrinsics.areEqual(this.codeSigningCertificate, updatesConfiguration.codeSigningCertificate) && Intrinsics.areEqual(this.codeSigningMetadata, updatesConfiguration.codeSigningMetadata) && this.codeSigningIncludeManifestResponseCertificateChain == updatesConfiguration.codeSigningIncludeManifestResponseCertificateChain && this.codeSigningAllowUnsignedManifests == updatesConfiguration.codeSigningAllowUnsignedManifests && this.enableExpoUpdatesProtocolV0CompatibilityMode == updatesConfiguration.enableExpoUpdatesProtocolV0CompatibilityMode && this.enableBsdiffPatchSupport == updatesConfiguration.enableBsdiffPatchSupport && this.disableAntiBrickingMeasures == updatesConfiguration.disableAntiBrickingMeasures && this.maxUpdatesToKeep == updatesConfiguration.maxUpdatesToKeep && this.hasUpdatesOverride == updatesConfiguration.hasUpdatesOverride && Intrinsics.areEqual(this.cachedOverrideMap, updatesConfiguration.cachedOverrideMap);
    }

    public int hashCode() {
        int iHashCode = ((((this.scopeKey.hashCode() * 31) + this.updateUrl.hashCode()) * 31) + this.originalEmbeddedUpdateUrl.hashCode()) * 31;
        String str = this.runtimeVersionRaw;
        int iHashCode2 = (((((((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.launchWaitMs)) * 31) + this.checkOnLaunch.hashCode()) * 31) + Boolean.hashCode(this.hasEmbeddedUpdate)) * 31) + Boolean.hashCode(this.originalHasEmbeddedUpdate)) * 31) + this.requestHeaders.hashCode()) * 31) + this.originalEmbeddedRequestHeaders.hashCode()) * 31;
        String str2 = this.codeSigningCertificate;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Map<String, String> map = this.codeSigningMetadata;
        int iHashCode4 = (((((((((((((((iHashCode3 + (map == null ? 0 : map.hashCode())) * 31) + Boolean.hashCode(this.codeSigningIncludeManifestResponseCertificateChain)) * 31) + Boolean.hashCode(this.codeSigningAllowUnsignedManifests)) * 31) + Boolean.hashCode(this.enableExpoUpdatesProtocolV0CompatibilityMode)) * 31) + Boolean.hashCode(this.enableBsdiffPatchSupport)) * 31) + Boolean.hashCode(this.disableAntiBrickingMeasures)) * 31) + Integer.hashCode(this.maxUpdatesToKeep)) * 31) + Boolean.hashCode(this.hasUpdatesOverride)) * 31;
        Map<String, Object> map2 = this.cachedOverrideMap;
        return iHashCode4 + (map2 != null ? map2.hashCode() : 0);
    }

    public String toString() {
        return "UpdatesConfiguration(scopeKey=" + this.scopeKey + ", updateUrl=" + this.updateUrl + ", originalEmbeddedUpdateUrl=" + this.originalEmbeddedUpdateUrl + ", runtimeVersionRaw=" + this.runtimeVersionRaw + ", launchWaitMs=" + this.launchWaitMs + ", checkOnLaunch=" + this.checkOnLaunch + ", hasEmbeddedUpdate=" + this.hasEmbeddedUpdate + ", originalHasEmbeddedUpdate=" + this.originalHasEmbeddedUpdate + ", requestHeaders=" + this.requestHeaders + ", originalEmbeddedRequestHeaders=" + this.originalEmbeddedRequestHeaders + ", codeSigningCertificate=" + this.codeSigningCertificate + ", codeSigningMetadata=" + this.codeSigningMetadata + ", codeSigningIncludeManifestResponseCertificateChain=" + this.codeSigningIncludeManifestResponseCertificateChain + ", codeSigningAllowUnsignedManifests=" + this.codeSigningAllowUnsignedManifests + ", enableExpoUpdatesProtocolV0CompatibilityMode=" + this.enableExpoUpdatesProtocolV0CompatibilityMode + ", enableBsdiffPatchSupport=" + this.enableBsdiffPatchSupport + ", disableAntiBrickingMeasures=" + this.disableAntiBrickingMeasures + ", maxUpdatesToKeep=" + this.maxUpdatesToKeep + ", hasUpdatesOverride=" + this.hasUpdatesOverride + ", cachedOverrideMap=" + this.cachedOverrideMap + ")";
    }

    public UpdatesConfiguration(String scopeKey, Uri updateUrl, Uri originalEmbeddedUpdateUrl, String str, int i, CheckAutomaticallyConfiguration checkOnLaunch, boolean z, boolean z2, Map<String, String> requestHeaders, Map<String, String> originalEmbeddedRequestHeaders, String str2, Map<String, String> map, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i2, boolean z8, Map<String, ? extends Object> map2) {
        Intrinsics.checkNotNullParameter(scopeKey, "scopeKey");
        Intrinsics.checkNotNullParameter(updateUrl, "updateUrl");
        Intrinsics.checkNotNullParameter(originalEmbeddedUpdateUrl, "originalEmbeddedUpdateUrl");
        Intrinsics.checkNotNullParameter(checkOnLaunch, "checkOnLaunch");
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        Intrinsics.checkNotNullParameter(originalEmbeddedRequestHeaders, "originalEmbeddedRequestHeaders");
        this.scopeKey = scopeKey;
        this.updateUrl = updateUrl;
        this.originalEmbeddedUpdateUrl = originalEmbeddedUpdateUrl;
        this.runtimeVersionRaw = str;
        this.launchWaitMs = i;
        this.checkOnLaunch = checkOnLaunch;
        this.hasEmbeddedUpdate = z;
        this.originalHasEmbeddedUpdate = z2;
        this.requestHeaders = requestHeaders;
        this.originalEmbeddedRequestHeaders = originalEmbeddedRequestHeaders;
        this.codeSigningCertificate = str2;
        this.codeSigningMetadata = map;
        this.codeSigningIncludeManifestResponseCertificateChain = z3;
        this.codeSigningAllowUnsignedManifests = z4;
        this.enableExpoUpdatesProtocolV0CompatibilityMode = z5;
        this.enableBsdiffPatchSupport = z6;
        this.disableAntiBrickingMeasures = z7;
        this.maxUpdatesToKeep = i2;
        this.hasUpdatesOverride = z8;
        this.cachedOverrideMap = map2;
        if (i2 < 2) {
            throw new AssertionError("UpdatesConfiguration failed to initialize: maxUpdatesToKeep must be >= 2");
        }
        this.codeSigningConfiguration = LazyKt.lazy(new Function0() { // from class: expo.modules.updates.UpdatesConfiguration$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return UpdatesConfiguration.codeSigningConfiguration_delegate$lambda$0(this.f$0);
            }
        });
    }

    public /* synthetic */ UpdatesConfiguration(String str, Uri uri, Uri uri2, String str2, int i, CheckAutomaticallyConfiguration checkAutomaticallyConfiguration, boolean z, boolean z2, Map map, Map map2, String str3, Map map3, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i2, boolean z8, Map map4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, uri, uri2, str2, i, checkAutomaticallyConfiguration, z, z2, map, map2, str3, map3, z3, z4, z5, z6, z7, (i3 & 131072) != 0 ? 2 : i2, z8, map4);
    }

    public final String getScopeKey() {
        return this.scopeKey;
    }

    public final Uri getUpdateUrl() {
        return this.updateUrl;
    }

    public final Uri getOriginalEmbeddedUpdateUrl() {
        return this.originalEmbeddedUpdateUrl;
    }

    public final String getRuntimeVersionRaw() {
        return this.runtimeVersionRaw;
    }

    public final int getLaunchWaitMs() {
        return this.launchWaitMs;
    }

    public final CheckAutomaticallyConfiguration getCheckOnLaunch() {
        return this.checkOnLaunch;
    }

    public final boolean getHasEmbeddedUpdate() {
        return this.hasEmbeddedUpdate;
    }

    public final boolean getOriginalHasEmbeddedUpdate() {
        return this.originalHasEmbeddedUpdate;
    }

    public final Map<String, String> getRequestHeaders() {
        return this.requestHeaders;
    }

    public final Map<String, String> getOriginalEmbeddedRequestHeaders() {
        return this.originalEmbeddedRequestHeaders;
    }

    public final String getCodeSigningCertificate() {
        return this.codeSigningCertificate;
    }

    public final Map<String, String> getCodeSigningMetadata() {
        return this.codeSigningMetadata;
    }

    public final boolean getCodeSigningIncludeManifestResponseCertificateChain() {
        return this.codeSigningIncludeManifestResponseCertificateChain;
    }

    public final boolean getEnableExpoUpdatesProtocolV0CompatibilityMode() {
        return this.enableExpoUpdatesProtocolV0CompatibilityMode;
    }

    public final boolean getEnableBsdiffPatchSupport() {
        return this.enableBsdiffPatchSupport;
    }

    public final boolean getDisableAntiBrickingMeasures() {
        return this.disableAntiBrickingMeasures;
    }

    public final int getMaxUpdatesToKeep() {
        return this.maxUpdatesToKeep;
    }

    public final boolean getHasUpdatesOverride() {
        return this.hasUpdatesOverride;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: UpdatesConfiguration.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\n"}, d2 = {"Lexpo/modules/updates/UpdatesConfiguration$CheckAutomaticallyConfiguration;", "", "<init>", "(Ljava/lang/String;I)V", "NEVER", "ERROR_RECOVERY_ONLY", "WIFI_ONLY", "ALWAYS", "toJSString", "", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class CheckAutomaticallyConfiguration {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ CheckAutomaticallyConfiguration[] $VALUES;
        public static final CheckAutomaticallyConfiguration NEVER = new NEVER("NEVER", 0);
        public static final CheckAutomaticallyConfiguration ERROR_RECOVERY_ONLY = new ERROR_RECOVERY_ONLY("ERROR_RECOVERY_ONLY", 1);
        public static final CheckAutomaticallyConfiguration WIFI_ONLY = new WIFI_ONLY("WIFI_ONLY", 2);
        public static final CheckAutomaticallyConfiguration ALWAYS = new ALWAYS("ALWAYS", 3);

        private static final /* synthetic */ CheckAutomaticallyConfiguration[] $values() {
            return new CheckAutomaticallyConfiguration[]{NEVER, ERROR_RECOVERY_ONLY, WIFI_ONLY, ALWAYS};
        }

        public /* synthetic */ CheckAutomaticallyConfiguration(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i);
        }

        public static EnumEntries<CheckAutomaticallyConfiguration> getEntries() {
            return $ENTRIES;
        }

        public static CheckAutomaticallyConfiguration valueOf(String str) {
            return (CheckAutomaticallyConfiguration) Enum.valueOf(CheckAutomaticallyConfiguration.class, str);
        }

        public static CheckAutomaticallyConfiguration[] values() {
            return (CheckAutomaticallyConfiguration[]) $VALUES.clone();
        }

        /* JADX INFO: compiled from: UpdatesConfiguration.kt */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"expo/modules/updates/UpdatesConfiguration.CheckAutomaticallyConfiguration.NEVER", "Lexpo/modules/updates/UpdatesConfiguration$CheckAutomaticallyConfiguration;", "toJSString", "", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
        static final class NEVER extends CheckAutomaticallyConfiguration {
            NEVER(String str, int i) {
                super(str, i, null);
            }

            @Override // expo.modules.updates.UpdatesConfiguration.CheckAutomaticallyConfiguration
            public String toJSString() {
                return "NEVER";
            }
        }

        private CheckAutomaticallyConfiguration(String str, int i) {
            super(str, i);
        }

        static {
            CheckAutomaticallyConfiguration[] checkAutomaticallyConfigurationArr$values = $values();
            $VALUES = checkAutomaticallyConfigurationArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(checkAutomaticallyConfigurationArr$values);
        }

        /* JADX INFO: compiled from: UpdatesConfiguration.kt */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"expo/modules/updates/UpdatesConfiguration.CheckAutomaticallyConfiguration.ERROR_RECOVERY_ONLY", "Lexpo/modules/updates/UpdatesConfiguration$CheckAutomaticallyConfiguration;", "toJSString", "", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
        static final class ERROR_RECOVERY_ONLY extends CheckAutomaticallyConfiguration {
            ERROR_RECOVERY_ONLY(String str, int i) {
                super(str, i, null);
            }

            @Override // expo.modules.updates.UpdatesConfiguration.CheckAutomaticallyConfiguration
            public String toJSString() {
                return "ERROR_RECOVERY_ONLY";
            }
        }

        /* JADX INFO: compiled from: UpdatesConfiguration.kt */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"expo/modules/updates/UpdatesConfiguration.CheckAutomaticallyConfiguration.WIFI_ONLY", "Lexpo/modules/updates/UpdatesConfiguration$CheckAutomaticallyConfiguration;", "toJSString", "", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
        static final class WIFI_ONLY extends CheckAutomaticallyConfiguration {
            WIFI_ONLY(String str, int i) {
                super(str, i, null);
            }

            @Override // expo.modules.updates.UpdatesConfiguration.CheckAutomaticallyConfiguration
            public String toJSString() {
                return "WIFI_ONLY";
            }
        }

        /* JADX INFO: compiled from: UpdatesConfiguration.kt */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"expo/modules/updates/UpdatesConfiguration.CheckAutomaticallyConfiguration.ALWAYS", "Lexpo/modules/updates/UpdatesConfiguration$CheckAutomaticallyConfiguration;", "toJSString", "", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
        static final class ALWAYS extends CheckAutomaticallyConfiguration {
            ALWAYS(String str, int i) {
                super(str, i, null);
            }

            @Override // expo.modules.updates.UpdatesConfiguration.CheckAutomaticallyConfiguration
            public String toJSString() {
                return "ALWAYS";
            }
        }

        public String toJSString() {
            throw new InvalidArgumentException("Unsupported CheckAutomaticallyConfiguration value");
        }
    }

    public UpdatesConfiguration(Context context, Map<String, ? extends Object> map) {
        this(context, map, INSTANCE.getDisableAntiBrickingMeasures(context, map), context != null ? UpdatesConfigurationOverride.INSTANCE.load$expo_updates_release(context) : null);
    }

    /* JADX WARN: Code duplicated, block: B:106:0x02b1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:107:0x02b3  */
    /* JADX WARN: Code duplicated, block: B:110:0x02ce  */
    /* JADX WARN: Code duplicated, block: B:112:0x02e2  */
    /* JADX WARN: Code duplicated, block: B:114:0x02e8  */
    /* JADX WARN: Code duplicated, block: B:116:0x02f4  */
    /* JADX WARN: Code duplicated, block: B:117:0x02ff  */
    /* JADX WARN: Code duplicated, block: B:119:0x030b  */
    /* JADX WARN: Code duplicated, block: B:120:0x0316  */
    /* JADX WARN: Code duplicated, block: B:121:0x031d  */
    /* JADX WARN: Code duplicated, block: B:135:0x0361 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:136:0x0363  */
    /* JADX WARN: Code duplicated, block: B:138:0x037b  */
    /* JADX WARN: Code duplicated, block: B:139:0x037f  */
    /* JADX WARN: Code duplicated, block: B:141:0x0393  */
    /* JADX WARN: Code duplicated, block: B:142:0x0398  */
    /* JADX WARN: Code duplicated, block: B:144:0x03a4  */
    /* JADX WARN: Code duplicated, block: B:145:0x03af  */
    /* JADX WARN: Code duplicated, block: B:147:0x03bb  */
    /* JADX WARN: Code duplicated, block: B:148:0x03c6  */
    /* JADX WARN: Code duplicated, block: B:14:0x0047 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:151:0x03cf  */
    /* JADX WARN: Code duplicated, block: B:15:0x0049  */
    /* JADX WARN: Code duplicated, block: B:165:0x041b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:166:0x041d  */
    /* JADX WARN: Code duplicated, block: B:169:0x0436  */
    /* JADX WARN: Code duplicated, block: B:171:0x044a  */
    /* JADX WARN: Code duplicated, block: B:172:0x0451  */
    /* JADX WARN: Code duplicated, block: B:174:0x045d  */
    /* JADX WARN: Code duplicated, block: B:175:0x0466  */
    /* JADX WARN: Code duplicated, block: B:177:0x0472  */
    /* JADX WARN: Code duplicated, block: B:178:0x047d  */
    /* JADX WARN: Code duplicated, block: B:179:0x0484  */
    /* JADX WARN: Code duplicated, block: B:181:0x0489  */
    /* JADX WARN: Code duplicated, block: B:182:0x048e  */
    /* JADX WARN: Code duplicated, block: B:18:0x0060  */
    /* JADX WARN: Code duplicated, block: B:194:0x04d1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:195:0x04d3  */
    /* JADX WARN: Code duplicated, block: B:198:0x04ec  */
    /* JADX WARN: Code duplicated, block: B:200:0x0500  */
    /* JADX WARN: Code duplicated, block: B:201:0x0507  */
    /* JADX WARN: Code duplicated, block: B:203:0x0513  */
    /* JADX WARN: Code duplicated, block: B:204:0x051c  */
    /* JADX WARN: Code duplicated, block: B:206:0x0528  */
    /* JADX WARN: Code duplicated, block: B:207:0x0533  */
    /* JADX WARN: Code duplicated, block: B:208:0x053a  */
    /* JADX WARN: Code duplicated, block: B:20:0x0072  */
    /* JADX WARN: Code duplicated, block: B:210:0x053f  */
    /* JADX WARN: Code duplicated, block: B:211:0x0544  */
    /* JADX WARN: Code duplicated, block: B:21:0x0077  */
    /* JADX WARN: Code duplicated, block: B:223:0x0587 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:224:0x0589  */
    /* JADX WARN: Code duplicated, block: B:227:0x05a2  */
    /* JADX WARN: Code duplicated, block: B:229:0x05b6  */
    /* JADX WARN: Code duplicated, block: B:230:0x05bd  */
    /* JADX WARN: Code duplicated, block: B:232:0x05c9  */
    /* JADX WARN: Code duplicated, block: B:233:0x05d2  */
    /* JADX WARN: Code duplicated, block: B:235:0x05de  */
    /* JADX WARN: Code duplicated, block: B:236:0x05e9  */
    /* JADX WARN: Code duplicated, block: B:237:0x05f0  */
    /* JADX WARN: Code duplicated, block: B:239:0x05f5  */
    /* JADX WARN: Code duplicated, block: B:23:0x0083  */
    /* JADX WARN: Code duplicated, block: B:240:0x05fa  */
    /* JADX WARN: Code duplicated, block: B:24:0x008e  */
    /* JADX WARN: Code duplicated, block: B:252:0x063b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:253:0x063d  */
    /* JADX WARN: Code duplicated, block: B:256:0x0656  */
    /* JADX WARN: Code duplicated, block: B:258:0x0668  */
    /* JADX WARN: Code duplicated, block: B:259:0x066f  */
    /* JADX WARN: Code duplicated, block: B:261:0x067b  */
    /* JADX WARN: Code duplicated, block: B:262:0x0684  */
    /* JADX WARN: Code duplicated, block: B:264:0x0690  */
    /* JADX WARN: Code duplicated, block: B:265:0x069b  */
    /* JADX WARN: Code duplicated, block: B:267:0x06a3  */
    /* JADX WARN: Code duplicated, block: B:269:0x06a6  */
    /* JADX WARN: Code duplicated, block: B:26:0x009a  */
    /* JADX WARN: Code duplicated, block: B:270:0x06ab  */
    /* JADX WARN: Code duplicated, block: B:27:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:28:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:41:0x0108 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x010a  */
    /* JADX WARN: Code duplicated, block: B:45:0x0121  */
    /* JADX WARN: Code duplicated, block: B:47:0x0133  */
    /* JADX WARN: Code duplicated, block: B:48:0x013a  */
    /* JADX WARN: Code duplicated, block: B:50:0x0146  */
    /* JADX WARN: Code duplicated, block: B:51:0x0151  */
    /* JADX WARN: Code duplicated, block: B:53:0x015d  */
    /* JADX WARN: Code duplicated, block: B:54:0x0166  */
    /* JADX WARN: Code duplicated, block: B:55:0x016d  */
    /* JADX WARN: Code duplicated, block: B:57:0x0170 A[PHI: r12
      0x0170: PHI (r12v17 java.lang.Integer) = (r12v1 java.lang.Integer), (r12v22 java.lang.Integer) binds: [B:56:0x016e, B:37:0x00e2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:58:0x0175  */
    /* JADX WARN: Code duplicated, block: B:74:0x01d0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:75:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:77:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:78:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:80:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:81:0x0201  */
    /* JADX WARN: Code duplicated, block: B:83:0x020d  */
    /* JADX WARN: Code duplicated, block: B:84:0x0218  */
    /* JADX WARN: Code duplicated, block: B:86:0x0224  */
    /* JADX WARN: Code duplicated, block: B:87:0x022f  */
    /* JADX WARN: Code duplicated, block: B:89:0x0237  */
    /* JADX WARN: Illegal instructions before constructor call */
    public UpdatesConfiguration(Context context, Map<String, ? extends Object> map, boolean z, UpdatesConfigurationOverride updatesConfigurationOverride) throws Exception {
        String string;
        Bundle bundle;
        KClass orCreateKotlinClass;
        Integer numValueOf;
        int iIntValue;
        Bundle bundle2;
        KClass orCreateKotlinClass2;
        String string2;
        CheckAutomaticallyConfiguration checkAutomaticallyConfigurationValueOf;
        CheckAutomaticallyConfiguration checkAutomaticallyConfigurationValueOf2;
        Bundle bundle3;
        KClass orCreateKotlinClass3;
        Map map2;
        String str;
        Bundle bundle4;
        KClass orCreateKotlinClass4;
        String string3;
        CheckAutomaticallyConfiguration checkAutomaticallyConfiguration;
        String string4;
        Map<String, String> mapFromJSONString;
        Bundle bundle5;
        KClass orCreateKotlinClass5;
        Map<String, String> map3;
        Boolean boolValueOf;
        boolean zBooleanValue;
        Bundle bundle6;
        KClass orCreateKotlinClass6;
        boolean z2;
        Boolean boolValueOf2;
        boolean zBooleanValue2;
        Bundle bundle7;
        KClass orCreateKotlinClass7;
        boolean z3;
        Boolean boolValueOf3;
        boolean zBooleanValue3;
        Bundle bundle8;
        KClass orCreateKotlinClass8;
        Boolean bool;
        boolean zBooleanValue4;
        Bundle bundle9;
        KClass orCreateKotlinClass9;
        Boolean boolValueOf4;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        Object obj9;
        if (map != null) {
            if (map.containsKey(UPDATES_CONFIGURATION_SCOPE_KEY_KEY)) {
                obj9 = map.get(UPDATES_CONFIGURATION_SCOPE_KEY_KEY);
                if (!(obj9 instanceof String)) {
                    Intrinsics.checkNotNull(obj9);
                    throw new AssertionError("UpdatesConfiguration failed to initialize: bad value of type " + obj9.getClass().getSimpleName() + " provided for key scopeKey");
                }
            } else {
                obj9 = null;
            }
            string = (String) obj9;
            if (string == null) {
                if (context != null) {
                    bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                    if (bundle.containsKey("expo.modules.updates.EXPO_SCOPE_KEY")) {
                        orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                            string = bundle.getString("expo.modules.updates.EXPO_SCOPE_KEY");
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            string = (String) Boolean.valueOf(bundle.getBoolean("expo.modules.updates.EXPO_SCOPE_KEY"));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            string = (String) Integer.valueOf(bundle.getInt("expo.modules.updates.EXPO_SCOPE_KEY"));
                        } else {
                            string = (String) bundle.get("expo.modules.updates.EXPO_SCOPE_KEY");
                        }
                    } else {
                        string = null;
                    }
                } else {
                    string = null;
                }
            }
        } else if (context != null) {
            bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle.containsKey("expo.modules.updates.EXPO_SCOPE_KEY")) {
                string = null;
            } else {
                orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                    string = bundle.getString("expo.modules.updates.EXPO_SCOPE_KEY");
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    string = (String) Boolean.valueOf(bundle.getBoolean("expo.modules.updates.EXPO_SCOPE_KEY"));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    string = (String) Integer.valueOf(bundle.getInt("expo.modules.updates.EXPO_SCOPE_KEY"));
                } else {
                    string = (String) bundle.get("expo.modules.updates.EXPO_SCOPE_KEY");
                }
            }
        } else {
            string = null;
        }
        Companion companion = INSTANCE;
        Uri updateUrl = companion.getUpdateUrl(context, map, z, updatesConfigurationOverride);
        Intrinsics.checkNotNull(updateUrl);
        String strMaybeGetDefaultScopeKey = UpdatesConfigurationKt.maybeGetDefaultScopeKey(string, updateUrl);
        Uri updateUrl2 = companion.getUpdateUrl(context, map, z, updatesConfigurationOverride);
        Intrinsics.checkNotNull(updateUrl2);
        Uri originalEmbeddedUpdateUrl = companion.getOriginalEmbeddedUpdateUrl(context, map);
        Intrinsics.checkNotNull(originalEmbeddedUpdateUrl);
        String runtimeVersion = companion.getRuntimeVersion(context, map);
        if (map == null) {
            if (context != null) {
                bundle2 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                if (bundle2.containsKey("expo.modules.updates.EXPO_UPDATES_LAUNCH_WAIT_MS")) {
                    orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Integer.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                        numValueOf = (Integer) bundle2.getString("expo.modules.updates.EXPO_UPDATES_LAUNCH_WAIT_MS");
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        numValueOf = (Integer) Boolean.valueOf(bundle2.getBoolean("expo.modules.updates.EXPO_UPDATES_LAUNCH_WAIT_MS"));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        numValueOf = Integer.valueOf(bundle2.getInt("expo.modules.updates.EXPO_UPDATES_LAUNCH_WAIT_MS"));
                    } else {
                        numValueOf = (Integer) bundle2.get("expo.modules.updates.EXPO_UPDATES_LAUNCH_WAIT_MS");
                    }
                } else {
                    numValueOf = null;
                }
            } else {
                numValueOf = null;
            }
            if (numValueOf != null) {
                iIntValue = numValueOf.intValue();
            } else {
                iIntValue = 0;
            }
        } else {
            if (map.containsKey(UPDATES_CONFIGURATION_LAUNCH_WAIT_MS_KEY)) {
                obj8 = map.get(UPDATES_CONFIGURATION_LAUNCH_WAIT_MS_KEY);
                if (!(obj8 instanceof Integer)) {
                    Intrinsics.checkNotNull(obj8);
                    throw new AssertionError("UpdatesConfiguration failed to initialize: bad value of type " + obj8.getClass().getSimpleName() + " provided for key launchWaitMs");
                }
            } else {
                obj8 = null;
            }
            numValueOf = (Integer) obj8;
            if (numValueOf != null) {
                iIntValue = numValueOf.intValue();
            } else {
                if (context != null) {
                    bundle2 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                    if (bundle2.containsKey("expo.modules.updates.EXPO_UPDATES_LAUNCH_WAIT_MS")) {
                        numValueOf = null;
                    } else {
                        orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Integer.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                            numValueOf = (Integer) bundle2.getString("expo.modules.updates.EXPO_UPDATES_LAUNCH_WAIT_MS");
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            numValueOf = (Integer) Boolean.valueOf(bundle2.getBoolean("expo.modules.updates.EXPO_UPDATES_LAUNCH_WAIT_MS"));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            numValueOf = Integer.valueOf(bundle2.getInt("expo.modules.updates.EXPO_UPDATES_LAUNCH_WAIT_MS"));
                        } else {
                            numValueOf = (Integer) bundle2.get("expo.modules.updates.EXPO_UPDATES_LAUNCH_WAIT_MS");
                        }
                    }
                } else {
                    numValueOf = null;
                }
                if (numValueOf != null) {
                    iIntValue = numValueOf.intValue();
                } else {
                    iIntValue = 0;
                }
            }
        }
        if (map == null) {
            if (context != null) {
                bundle3 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                if (bundle3.containsKey("expo.modules.updates.EXPO_UPDATES_CHECK_ON_LAUNCH")) {
                    orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                        string2 = bundle3.getString("expo.modules.updates.EXPO_UPDATES_CHECK_ON_LAUNCH");
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        string2 = (String) Boolean.valueOf(bundle3.getBoolean("expo.modules.updates.EXPO_UPDATES_CHECK_ON_LAUNCH"));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        string2 = (String) Integer.valueOf(bundle3.getInt("expo.modules.updates.EXPO_UPDATES_CHECK_ON_LAUNCH"));
                    } else {
                        string2 = (String) bundle3.get("expo.modules.updates.EXPO_UPDATES_CHECK_ON_LAUNCH");
                    }
                } else {
                    string2 = null;
                }
                string2 = string2 == null ? "ALWAYS" : string2;
            }
            try {
                checkAutomaticallyConfigurationValueOf = CheckAutomaticallyConfiguration.valueOf(string2);
            } catch (IllegalArgumentException unused) {
                Log.e(TAG, "Invalid value " + string2 + " for expo.modules.updates.EXPO_UPDATES_CHECK_ON_LAUNCH in AndroidManifest; defaulting to ALWAYS");
                checkAutomaticallyConfigurationValueOf = CheckAutomaticallyConfiguration.ALWAYS;
            }
            checkAutomaticallyConfigurationValueOf2 = checkAutomaticallyConfigurationValueOf;
        } else {
            if (map.containsKey(UPDATES_CONFIGURATION_CHECK_ON_LAUNCH_KEY)) {
                obj7 = map.get(UPDATES_CONFIGURATION_CHECK_ON_LAUNCH_KEY);
                if (!(obj7 instanceof String)) {
                    Intrinsics.checkNotNull(obj7);
                    throw new AssertionError("UpdatesConfiguration failed to initialize: bad value of type " + obj7.getClass().getSimpleName() + " provided for key checkOnLaunch");
                }
            } else {
                obj7 = null;
            }
            String str2 = (String) obj7;
            if (str2 != null) {
                try {
                    checkAutomaticallyConfigurationValueOf2 = CheckAutomaticallyConfiguration.valueOf(str2);
                    if (checkAutomaticallyConfigurationValueOf2 == null) {
                        if (context != null) {
                            bundle3 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                            if (bundle3.containsKey("expo.modules.updates.EXPO_UPDATES_CHECK_ON_LAUNCH")) {
                                string2 = null;
                            } else {
                                orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(String.class);
                                if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                                    string2 = bundle3.getString("expo.modules.updates.EXPO_UPDATES_CHECK_ON_LAUNCH");
                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                    string2 = (String) Boolean.valueOf(bundle3.getBoolean("expo.modules.updates.EXPO_UPDATES_CHECK_ON_LAUNCH"));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                    string2 = (String) Integer.valueOf(bundle3.getInt("expo.modules.updates.EXPO_UPDATES_CHECK_ON_LAUNCH"));
                                } else {
                                    string2 = (String) bundle3.get("expo.modules.updates.EXPO_UPDATES_CHECK_ON_LAUNCH");
                                }
                            }
                            if (string2 == null) {
                            }
                        }
                        checkAutomaticallyConfigurationValueOf = CheckAutomaticallyConfiguration.valueOf(string2);
                        checkAutomaticallyConfigurationValueOf2 = checkAutomaticallyConfigurationValueOf;
                    }
                } catch (IllegalArgumentException unused2) {
                    throw new AssertionError("UpdatesConfiguration failed to initialize: invalid value " + str2 + " provided for checkOnLaunch");
                }
            } else {
                if (context != null) {
                    bundle3 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                    if (bundle3.containsKey("expo.modules.updates.EXPO_UPDATES_CHECK_ON_LAUNCH")) {
                        string2 = null;
                    } else {
                        orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(String.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                            string2 = bundle3.getString("expo.modules.updates.EXPO_UPDATES_CHECK_ON_LAUNCH");
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            string2 = (String) Boolean.valueOf(bundle3.getBoolean("expo.modules.updates.EXPO_UPDATES_CHECK_ON_LAUNCH"));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            string2 = (String) Integer.valueOf(bundle3.getInt("expo.modules.updates.EXPO_UPDATES_CHECK_ON_LAUNCH"));
                        } else {
                            string2 = (String) bundle3.get("expo.modules.updates.EXPO_UPDATES_CHECK_ON_LAUNCH");
                        }
                    }
                    if (string2 == null) {
                    }
                }
                checkAutomaticallyConfigurationValueOf = CheckAutomaticallyConfiguration.valueOf(string2);
                checkAutomaticallyConfigurationValueOf2 = checkAutomaticallyConfigurationValueOf;
            }
        }
        CheckAutomaticallyConfiguration checkAutomaticallyConfiguration2 = checkAutomaticallyConfigurationValueOf2;
        Companion companion2 = INSTANCE;
        boolean hasEmbeddedUpdate = companion2.getHasEmbeddedUpdate(context, map, z, updatesConfigurationOverride);
        boolean originalHasEmbeddedUpdate = companion2.getOriginalHasEmbeddedUpdate(context, map);
        Map requestHeaders = companion2.getRequestHeaders(context, map, z, updatesConfigurationOverride);
        Map originalEmbeddedRequestHeaders = companion2.getOriginalEmbeddedRequestHeaders(context, map);
        if (map == null) {
            if (context != null) {
                map2 = requestHeaders;
                bundle4 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                if (!bundle4.containsKey("expo.modules.updates.CODE_SIGNING_CERTIFICATE")) {
                    orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                        string3 = bundle4.getString("expo.modules.updates.CODE_SIGNING_CERTIFICATE");
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        string3 = (String) Boolean.valueOf(bundle4.getBoolean("expo.modules.updates.CODE_SIGNING_CERTIFICATE"));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        string3 = (String) Integer.valueOf(bundle4.getInt("expo.modules.updates.CODE_SIGNING_CERTIFICATE"));
                    } else {
                        string3 = (String) bundle4.get("expo.modules.updates.CODE_SIGNING_CERTIFICATE");
                    }
                    str = string3;
                }
            } else {
                map2 = requestHeaders;
            }
            str = null;
        } else {
            if (map.containsKey(UPDATES_CONFIGURATION_CODE_SIGNING_CERTIFICATE)) {
                obj6 = map.get(UPDATES_CONFIGURATION_CODE_SIGNING_CERTIFICATE);
                if (!(obj6 instanceof String)) {
                    Intrinsics.checkNotNull(obj6);
                    throw new AssertionError("UpdatesConfiguration failed to initialize: bad value of type " + obj6.getClass().getSimpleName() + " provided for key codeSigningCertificate");
                }
            } else {
                obj6 = null;
            }
            str = (String) obj6;
            if (str == null) {
                if (context != null) {
                    map2 = requestHeaders;
                    bundle4 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                    if (!bundle4.containsKey("expo.modules.updates.CODE_SIGNING_CERTIFICATE")) {
                        orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(String.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                            string3 = bundle4.getString("expo.modules.updates.CODE_SIGNING_CERTIFICATE");
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            string3 = (String) Boolean.valueOf(bundle4.getBoolean("expo.modules.updates.CODE_SIGNING_CERTIFICATE"));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            string3 = (String) Integer.valueOf(bundle4.getInt("expo.modules.updates.CODE_SIGNING_CERTIFICATE"));
                        } else {
                            string3 = (String) bundle4.get("expo.modules.updates.CODE_SIGNING_CERTIFICATE");
                        }
                        str = string3;
                    }
                } else {
                    map2 = requestHeaders;
                }
                str = null;
            } else {
                map2 = requestHeaders;
            }
        }
        if (map == null) {
            if (context != null) {
                bundle5 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                if (bundle5.containsKey("expo.modules.updates.CODE_SIGNING_METADATA")) {
                    orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(String.class);
                    checkAutomaticallyConfiguration = checkAutomaticallyConfiguration2;
                    if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(String.class))) {
                        string4 = bundle5.getString("expo.modules.updates.CODE_SIGNING_METADATA");
                    } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        string4 = (String) Boolean.valueOf(bundle5.getBoolean("expo.modules.updates.CODE_SIGNING_METADATA"));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        string4 = (String) Integer.valueOf(bundle5.getInt("expo.modules.updates.CODE_SIGNING_METADATA"));
                    } else {
                        string4 = (String) bundle5.get("expo.modules.updates.CODE_SIGNING_METADATA");
                    }
                } else {
                    checkAutomaticallyConfiguration = checkAutomaticallyConfiguration2;
                    string4 = null;
                }
                if (string4 == null) {
                }
                mapFromJSONString = UpdatesUtils.INSTANCE.getMapFromJSONString(string4);
            } else {
                checkAutomaticallyConfiguration = checkAutomaticallyConfiguration2;
            }
            string4 = "{}";
            mapFromJSONString = UpdatesUtils.INSTANCE.getMapFromJSONString(string4);
        } else {
            if (map.containsKey(UPDATES_CONFIGURATION_CODE_SIGNING_METADATA)) {
                obj5 = map.get(UPDATES_CONFIGURATION_CODE_SIGNING_METADATA);
                if (!(obj5 instanceof Map)) {
                    Intrinsics.checkNotNull(obj5);
                    throw new AssertionError("UpdatesConfiguration failed to initialize: bad value of type " + obj5.getClass().getSimpleName() + " provided for key codeSigningMetadata");
                }
            } else {
                obj5 = null;
            }
            mapFromJSONString = (Map) obj5;
            if (mapFromJSONString == null) {
                if (context != null) {
                    bundle5 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                    if (bundle5.containsKey("expo.modules.updates.CODE_SIGNING_METADATA")) {
                        checkAutomaticallyConfiguration = checkAutomaticallyConfiguration2;
                        string4 = null;
                    } else {
                        orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(String.class);
                        checkAutomaticallyConfiguration = checkAutomaticallyConfiguration2;
                        if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(String.class))) {
                            string4 = bundle5.getString("expo.modules.updates.CODE_SIGNING_METADATA");
                        } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            string4 = (String) Boolean.valueOf(bundle5.getBoolean("expo.modules.updates.CODE_SIGNING_METADATA"));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            string4 = (String) Integer.valueOf(bundle5.getInt("expo.modules.updates.CODE_SIGNING_METADATA"));
                        } else {
                            string4 = (String) bundle5.get("expo.modules.updates.CODE_SIGNING_METADATA");
                        }
                    }
                    if (string4 == null) {
                    }
                    mapFromJSONString = UpdatesUtils.INSTANCE.getMapFromJSONString(string4);
                } else {
                    checkAutomaticallyConfiguration = checkAutomaticallyConfiguration2;
                }
                string4 = "{}";
                mapFromJSONString = UpdatesUtils.INSTANCE.getMapFromJSONString(string4);
            } else {
                checkAutomaticallyConfiguration = checkAutomaticallyConfiguration2;
            }
        }
        if (map == null) {
            if (context != null) {
                bundle6 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                if (bundle6.containsKey("expo.modules.updates.CODE_SIGNING_INCLUDE_MANIFEST_RESPONSE_CERTIFICATE_CHAIN")) {
                    orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Boolean.class);
                    map3 = mapFromJSONString;
                    if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(String.class))) {
                        boolValueOf = (Boolean) bundle6.getString("expo.modules.updates.CODE_SIGNING_INCLUDE_MANIFEST_RESPONSE_CERTIFICATE_CHAIN");
                    } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        boolValueOf = Boolean.valueOf(bundle6.getBoolean("expo.modules.updates.CODE_SIGNING_INCLUDE_MANIFEST_RESPONSE_CERTIFICATE_CHAIN"));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        boolValueOf = (Boolean) Integer.valueOf(bundle6.getInt("expo.modules.updates.CODE_SIGNING_INCLUDE_MANIFEST_RESPONSE_CERTIFICATE_CHAIN"));
                    } else {
                        boolValueOf = (Boolean) bundle6.get("expo.modules.updates.CODE_SIGNING_INCLUDE_MANIFEST_RESPONSE_CERTIFICATE_CHAIN");
                    }
                } else {
                    map3 = mapFromJSONString;
                    boolValueOf = null;
                }
            } else {
                map3 = mapFromJSONString;
                boolValueOf = null;
            }
            if (boolValueOf != null) {
                zBooleanValue = boolValueOf.booleanValue();
            } else {
                zBooleanValue = false;
            }
        } else {
            if (map.containsKey(UPDATES_CONFIGURATION_CODE_SIGNING_INCLUDE_MANIFEST_RESPONSE_CERTIFICATE_CHAIN)) {
                obj4 = map.get(UPDATES_CONFIGURATION_CODE_SIGNING_INCLUDE_MANIFEST_RESPONSE_CERTIFICATE_CHAIN);
                if (!(obj4 instanceof Boolean)) {
                    Intrinsics.checkNotNull(obj4);
                    throw new AssertionError("UpdatesConfiguration failed to initialize: bad value of type " + obj4.getClass().getSimpleName() + " provided for key codeSigningIncludeManifestResponseCertificateChain");
                }
            } else {
                obj4 = null;
            }
            Boolean bool2 = (Boolean) obj4;
            if (bool2 != null) {
                zBooleanValue = bool2.booleanValue();
                map3 = mapFromJSONString;
            } else {
                if (context != null) {
                    bundle6 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                    if (bundle6.containsKey("expo.modules.updates.CODE_SIGNING_INCLUDE_MANIFEST_RESPONSE_CERTIFICATE_CHAIN")) {
                        map3 = mapFromJSONString;
                        boolValueOf = null;
                    } else {
                        orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Boolean.class);
                        map3 = mapFromJSONString;
                        if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(String.class))) {
                            boolValueOf = (Boolean) bundle6.getString("expo.modules.updates.CODE_SIGNING_INCLUDE_MANIFEST_RESPONSE_CERTIFICATE_CHAIN");
                        } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            boolValueOf = Boolean.valueOf(bundle6.getBoolean("expo.modules.updates.CODE_SIGNING_INCLUDE_MANIFEST_RESPONSE_CERTIFICATE_CHAIN"));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            boolValueOf = (Boolean) Integer.valueOf(bundle6.getInt("expo.modules.updates.CODE_SIGNING_INCLUDE_MANIFEST_RESPONSE_CERTIFICATE_CHAIN"));
                        } else {
                            boolValueOf = (Boolean) bundle6.get("expo.modules.updates.CODE_SIGNING_INCLUDE_MANIFEST_RESPONSE_CERTIFICATE_CHAIN");
                        }
                    }
                } else {
                    map3 = mapFromJSONString;
                    boolValueOf = null;
                }
                if (boolValueOf != null) {
                    zBooleanValue = boolValueOf.booleanValue();
                } else {
                    zBooleanValue = false;
                }
            }
        }
        if (map == null) {
            if (context != null) {
                bundle7 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                if (bundle7.containsKey("expo.modules.updates.CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS")) {
                    orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Boolean.class);
                    z2 = zBooleanValue;
                    if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(String.class))) {
                        boolValueOf2 = (Boolean) bundle7.getString("expo.modules.updates.CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS");
                    } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        boolValueOf2 = Boolean.valueOf(bundle7.getBoolean("expo.modules.updates.CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS"));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        boolValueOf2 = (Boolean) Integer.valueOf(bundle7.getInt("expo.modules.updates.CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS"));
                    } else {
                        boolValueOf2 = (Boolean) bundle7.get("expo.modules.updates.CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS");
                    }
                } else {
                    z2 = zBooleanValue;
                    boolValueOf2 = null;
                }
            } else {
                z2 = zBooleanValue;
                boolValueOf2 = null;
            }
            if (boolValueOf2 != null) {
                zBooleanValue2 = boolValueOf2.booleanValue();
            } else {
                zBooleanValue2 = false;
            }
        } else {
            if (map.containsKey(UPDATES_CONFIGURATION_CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS)) {
                obj3 = map.get(UPDATES_CONFIGURATION_CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS);
                if (!(obj3 instanceof Boolean)) {
                    Intrinsics.checkNotNull(obj3);
                    throw new AssertionError("UpdatesConfiguration failed to initialize: bad value of type " + obj3.getClass().getSimpleName() + " provided for key codeSigningAllowUnsignedManifests");
                }
            } else {
                obj3 = null;
            }
            Boolean bool3 = (Boolean) obj3;
            if (bool3 != null) {
                zBooleanValue2 = bool3.booleanValue();
                z2 = zBooleanValue;
            } else {
                if (context != null) {
                    bundle7 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                    if (bundle7.containsKey("expo.modules.updates.CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS")) {
                        z2 = zBooleanValue;
                        boolValueOf2 = null;
                    } else {
                        orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Boolean.class);
                        z2 = zBooleanValue;
                        if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(String.class))) {
                            boolValueOf2 = (Boolean) bundle7.getString("expo.modules.updates.CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS");
                        } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            boolValueOf2 = Boolean.valueOf(bundle7.getBoolean("expo.modules.updates.CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS"));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            boolValueOf2 = (Boolean) Integer.valueOf(bundle7.getInt("expo.modules.updates.CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS"));
                        } else {
                            boolValueOf2 = (Boolean) bundle7.get("expo.modules.updates.CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS");
                        }
                    }
                } else {
                    z2 = zBooleanValue;
                    boolValueOf2 = null;
                }
                if (boolValueOf2 != null) {
                    zBooleanValue2 = boolValueOf2.booleanValue();
                } else {
                    zBooleanValue2 = false;
                }
            }
        }
        if (map == null) {
            if (context != null) {
                bundle8 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                if (bundle8.containsKey("expo.modules.updates.ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE")) {
                    orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Boolean.class);
                    z3 = zBooleanValue2;
                    if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(String.class))) {
                        boolValueOf3 = (Boolean) bundle8.getString("expo.modules.updates.ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE");
                    } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        boolValueOf3 = Boolean.valueOf(bundle8.getBoolean("expo.modules.updates.ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE"));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        boolValueOf3 = (Boolean) Integer.valueOf(bundle8.getInt("expo.modules.updates.ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE"));
                    } else {
                        boolValueOf3 = (Boolean) bundle8.get("expo.modules.updates.ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE");
                    }
                } else {
                    z3 = zBooleanValue2;
                    boolValueOf3 = null;
                }
            } else {
                z3 = zBooleanValue2;
                boolValueOf3 = null;
            }
            if (boolValueOf3 != null) {
                zBooleanValue3 = boolValueOf3.booleanValue();
            } else {
                zBooleanValue3 = false;
            }
        } else {
            if (map.containsKey(UPDATES_CONFIGURATION_ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE)) {
                obj2 = map.get(UPDATES_CONFIGURATION_ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE);
                if (!(obj2 instanceof Boolean)) {
                    Intrinsics.checkNotNull(obj2);
                    throw new AssertionError("UpdatesConfiguration failed to initialize: bad value of type " + obj2.getClass().getSimpleName() + " provided for key enableExpoUpdatesProtocolCompatibilityMode");
                }
            } else {
                obj2 = null;
            }
            Boolean bool4 = (Boolean) obj2;
            if (bool4 != null) {
                zBooleanValue3 = bool4.booleanValue();
                z3 = zBooleanValue2;
            } else {
                if (context != null) {
                    bundle8 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                    if (bundle8.containsKey("expo.modules.updates.ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE")) {
                        z3 = zBooleanValue2;
                        boolValueOf3 = null;
                    } else {
                        orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Boolean.class);
                        z3 = zBooleanValue2;
                        if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(String.class))) {
                            boolValueOf3 = (Boolean) bundle8.getString("expo.modules.updates.ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE");
                        } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            boolValueOf3 = Boolean.valueOf(bundle8.getBoolean("expo.modules.updates.ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE"));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            boolValueOf3 = (Boolean) Integer.valueOf(bundle8.getInt("expo.modules.updates.ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE"));
                        } else {
                            boolValueOf3 = (Boolean) bundle8.get("expo.modules.updates.ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE");
                        }
                    }
                } else {
                    z3 = zBooleanValue2;
                    boolValueOf3 = null;
                }
                if (boolValueOf3 != null) {
                    zBooleanValue3 = boolValueOf3.booleanValue();
                } else {
                    zBooleanValue3 = false;
                }
            }
        }
        if (map == null) {
            if (context != null) {
                bundle9 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                if (bundle9.containsKey("expo.modules.updates.ENABLE_BSDIFF_PATCH_SUPPORT")) {
                    orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(Boolean.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(String.class))) {
                        boolValueOf4 = (Boolean) bundle9.getString("expo.modules.updates.ENABLE_BSDIFF_PATCH_SUPPORT");
                    } else if (Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        boolValueOf4 = Boolean.valueOf(bundle9.getBoolean("expo.modules.updates.ENABLE_BSDIFF_PATCH_SUPPORT"));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        boolValueOf4 = (Boolean) Integer.valueOf(bundle9.getInt("expo.modules.updates.ENABLE_BSDIFF_PATCH_SUPPORT"));
                    } else {
                        boolValueOf4 = (Boolean) bundle9.get("expo.modules.updates.ENABLE_BSDIFF_PATCH_SUPPORT");
                    }
                    bool = boolValueOf4;
                } else {
                    bool = null;
                }
            } else {
                bool = null;
            }
            if (bool != null) {
                zBooleanValue4 = bool.booleanValue();
            } else {
                zBooleanValue4 = true;
            }
        } else {
            if (map.containsKey(UPDATES_CONFIGURATION_ENABLE_BSDIFF_PATCH_SUPPORT)) {
                obj = map.get(UPDATES_CONFIGURATION_ENABLE_BSDIFF_PATCH_SUPPORT);
                if (!(obj instanceof Boolean)) {
                    Intrinsics.checkNotNull(obj);
                    throw new AssertionError("UpdatesConfiguration failed to initialize: bad value of type " + obj.getClass().getSimpleName() + " provided for key enableBsdiffPatchSupport");
                }
            } else {
                obj = null;
            }
            Boolean bool5 = (Boolean) obj;
            if (bool5 != null) {
                zBooleanValue4 = bool5.booleanValue();
            } else {
                if (context != null) {
                    bundle9 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                    if (bundle9.containsKey("expo.modules.updates.ENABLE_BSDIFF_PATCH_SUPPORT")) {
                        bool = null;
                    } else {
                        orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(Boolean.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(String.class))) {
                            boolValueOf4 = (Boolean) bundle9.getString("expo.modules.updates.ENABLE_BSDIFF_PATCH_SUPPORT");
                        } else if (Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            boolValueOf4 = Boolean.valueOf(bundle9.getBoolean("expo.modules.updates.ENABLE_BSDIFF_PATCH_SUPPORT"));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            boolValueOf4 = (Boolean) Integer.valueOf(bundle9.getInt("expo.modules.updates.ENABLE_BSDIFF_PATCH_SUPPORT"));
                        } else {
                            boolValueOf4 = (Boolean) bundle9.get("expo.modules.updates.ENABLE_BSDIFF_PATCH_SUPPORT");
                        }
                        bool = boolValueOf4;
                    }
                } else {
                    bool = null;
                }
                if (bool != null) {
                    zBooleanValue4 = bool.booleanValue();
                } else {
                    zBooleanValue4 = true;
                }
            }
        }
        this(strMaybeGetDefaultScopeKey, updateUrl2, originalEmbeddedUpdateUrl, runtimeVersion, iIntValue, checkAutomaticallyConfiguration, hasEmbeddedUpdate, originalHasEmbeddedUpdate, map2, originalEmbeddedRequestHeaders, str, map3, z2, z3, zBooleanValue3, zBooleanValue4, companion2.getDisableAntiBrickingMeasures(context, map), companion2.getMaxUpdatesToKeep(context, map), updatesConfigurationOverride != null, map);
    }

    public final CodeSigningConfiguration getCodeSigningConfiguration() {
        return (CodeSigningConfiguration) this.codeSigningConfiguration.getValue();
    }

    static final CodeSigningConfiguration codeSigningConfiguration_delegate$lambda$0(UpdatesConfiguration updatesConfiguration) {
        String str = updatesConfiguration.codeSigningCertificate;
        if (str != null) {
            return new CodeSigningConfiguration(str, updatesConfiguration.codeSigningMetadata, updatesConfiguration.codeSigningIncludeManifestResponseCertificateChain, updatesConfiguration.codeSigningAllowUnsignedManifests);
        }
        return null;
    }

    public final String getRuntimeVersion() throws Exception {
        String str = this.runtimeVersionRaw;
        if (str != null && str.length() != 0) {
            return this.runtimeVersionRaw;
        }
        throw new Exception("No runtime version provided in configuration");
    }

    /* JADX INFO: compiled from: UpdatesConfiguration.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\"H\u0002J(\u0010#\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\"H\u0002J:\u0010$\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\"2\u0006\u0010%\u001a\u00020\u001e2\b\u0010&\u001a\u0004\u0018\u00010'H\u0002J(\u0010(\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\"H\u0002J<\u0010)\u001a\u0004\u0018\u00010*2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\"2\u0006\u0010%\u001a\u00020\u001e2\b\u0010&\u001a\u0004\u0018\u00010'H\u0002J*\u0010+\u001a\u0004\u0018\u00010*2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\"H\u0002JF\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\"2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\"2\u0006\u0010%\u001a\u00020\u001e2\b\u0010&\u001a\u0004\u0018\u00010'H\u0002J7\u0010-\u001a\u00020\u001e2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\"2\u0014\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\"H\u0000¢\u0006\u0002\b0J>\u0010-\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\"2\u0014\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\"H\u0002J4\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\"2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\"H\u0002J(\u00102\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\"H\u0002J*\u00103\u001a\u0004\u0018\u00010\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\"H\u0002J&\u00104\u001a\u0002052\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\"J \u00106\u001a\u0002072\u0006\u0010\u001f\u001a\u00020 2\u0006\u00108\u001a\u0002072\b\u0010&\u001a\u0004\u0018\u00010'R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lexpo/modules/updates/UpdatesConfiguration$Companion;", "", "<init>", "()V", "TAG", "", "kotlin.jvm.PlatformType", "UPDATES_CONFIGURATION_ENABLED_KEY", "UPDATES_CONFIGURATION_SCOPE_KEY_KEY", "UPDATES_CONFIGURATION_UPDATE_URL_KEY", "UPDATES_CONFIGURATION_REQUEST_HEADERS_KEY", "UPDATES_CONFIGURATION_RUNTIME_VERSION_KEY", "UPDATES_CONFIGURATION_CHECK_ON_LAUNCH_KEY", "UPDATES_CONFIGURATION_LAUNCH_WAIT_MS_KEY", "UPDATES_CONFIGURATION_HAS_EMBEDDED_UPDATE_KEY", "UPDATES_CONFIGURATION_ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE", "UPDATES_CONFIGURATION_DISABLE_ANTI_BRICKING_MEASURES", "UPDATES_CONFIGURATION_ENABLE_BSDIFF_PATCH_SUPPORT", "UPDATES_CONFIGURATION_MAX_UPDATES_TO_KEEP_KEY", "UPDATES_CONFIGURATION_CODE_SIGNING_CERTIFICATE", "UPDATES_CONFIGURATION_CODE_SIGNING_METADATA", "UPDATES_CONFIGURATION_CODE_SIGNING_INCLUDE_MANIFEST_RESPONSE_CERTIFICATE_CHAIN", "UPDATES_CONFIGURATION_CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS", "UPDATES_CONFIGURATION_LAUNCH_WAIT_MS_DEFAULT_VALUE", "", "UPDATES_CONFIGURATION_MAX_UPDATES_TO_KEEP_DEFAULT_VALUE", "UPDATES_CONFIGURATION_MAX_UPDATES_TO_KEEP_MIN_VALUE", "UPDATES_CONFIGURATION_RUNTIME_VERSION_READ_FINGERPRINT_FILE_SENTINEL", "FINGERPRINT_FILE_NAME", "getDisableAntiBrickingMeasures", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "overrideMap", "", "getMaxUpdatesToKeep", "getHasEmbeddedUpdate", UpdatesConfiguration.UPDATES_CONFIGURATION_DISABLE_ANTI_BRICKING_MEASURES, "configOverride", "Lexpo/modules/updates/UpdatesConfigurationOverride;", "getOriginalHasEmbeddedUpdate", "getUpdateUrl", "Landroid/net/Uri;", "getOriginalEmbeddedUpdateUrl", "getRequestHeaders", "isValidRequestHeadersOverride", "originalEmbeddedRequestHeaders", "requestHeadersOverride", "isValidRequestHeadersOverride$expo_updates_release", "getOriginalEmbeddedRequestHeaders", "getIsEnabled", "getRuntimeVersion", "getUpdatesConfigurationValidationResult", "Lexpo/modules/updates/UpdatesConfigurationValidationResult;", "create", "Lexpo/modules/updates/UpdatesConfiguration;", "config", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean getHasEmbeddedUpdate(Context context, Map<String, ? extends Object> overrideMap, boolean disableAntiBrickingMeasures, UpdatesConfigurationOverride configOverride) {
            if (!disableAntiBrickingMeasures || configOverride == null) {
                return getOriginalHasEmbeddedUpdate(context, overrideMap);
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Uri getUpdateUrl(Context context, Map<String, ? extends Object> overrideMap, boolean disableAntiBrickingMeasures, UpdatesConfigurationOverride configOverride) {
            if (disableAntiBrickingMeasures && configOverride != null) {
                return configOverride.getUpdateUrl();
            }
            return getOriginalEmbeddedUpdateUrl(context, overrideMap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Map<String, String> getRequestHeaders(Context context, Map<String, ? extends Object> overrideMap, boolean disableAntiBrickingMeasures, UpdatesConfigurationOverride configOverride) {
            Map<String, String> requestHeaders;
            if (configOverride != null && (requestHeaders = configOverride.getRequestHeaders()) != null) {
                if (UpdatesConfiguration.INSTANCE.isValidRequestHeadersOverride(context, overrideMap, requestHeaders) || disableAntiBrickingMeasures) {
                    return requestHeaders;
                }
                Log.w(UpdatesConfiguration.TAG, "Invalid update requestHeaders override, falling back to embedded requestHeaders - override requestHeaders: " + requestHeaders);
            }
            return getOriginalEmbeddedRequestHeaders(context, overrideMap);
        }

        /* JADX WARN: Code duplicated, block: B:31:0x00ca  */
        /* JADX WARN: Code duplicated, block: B:37:0x00d6 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:39:? A[LOOP:2: B:29:0x00c4->B:39:?, LOOP_END, SYNTHETIC] */
        public final boolean isValidRequestHeadersOverride$expo_updates_release(Map<String, String> originalEmbeddedRequestHeaders, Map<String, String> requestHeadersOverride) {
            Iterator it;
            Intrinsics.checkNotNullParameter(originalEmbeddedRequestHeaders, "originalEmbeddedRequestHeaders");
            if (requestHeadersOverride == null) {
                return true;
            }
            Set<String> setKeySet = originalEmbeddedRequestHeaders.keySet();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(setKeySet, 10));
            Iterator<T> it2 = setKeySet.iterator();
            while (it2.hasNext()) {
                String lowerCase = ((String) it2.next()).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                arrayList.add(StringsKt.trim((CharSequence) lowerCase).toString());
            }
            Set set = CollectionsKt.toSet(arrayList);
            Set of = SetsKt.setOf(LogAttributes.HOST);
            Set<String> setKeySet2 = requestHeadersOverride.keySet();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(setKeySet2, 10));
            Iterator<T> it3 = setKeySet2.iterator();
            while (it3.hasNext()) {
                String lowerCase2 = ((String) it3.next()).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                arrayList2.add(StringsKt.trim((CharSequence) lowerCase2).toString());
            }
            ArrayList arrayList3 = arrayList2;
            boolean z = arrayList3 instanceof Collection;
            if (!z || !arrayList3.isEmpty()) {
                Iterator it4 = arrayList3.iterator();
                while (it4.hasNext()) {
                    if (of.contains((String) it4.next())) {
                    }
                }
                if (!z && arrayList3.isEmpty()) {
                    return true;
                }
                it = arrayList3.iterator();
                while (it.hasNext()) {
                    if (!set.contains((String) it.next())) {
                    }
                }
                return true;
            }
            if (!z) {
            }
            it = arrayList3.iterator();
            while (it.hasNext()) {
                if (!set.contains((String) it.next())) {
                }
            }
            return true;
            return false;
        }

        private final boolean isValidRequestHeadersOverride(Context context, Map<String, ? extends Object> overrideMap, Map<String, String> requestHeadersOverride) {
            return isValidRequestHeadersOverride$expo_updates_release(getOriginalEmbeddedRequestHeaders(context, overrideMap), requestHeadersOverride);
        }

        public final UpdatesConfigurationValidationResult getUpdatesConfigurationValidationResult(Context context, Map<String, ? extends Object> overrideMap) throws IOException {
            if (!getIsEnabled(context, overrideMap)) {
                return UpdatesConfigurationValidationResult.INVALID_NOT_ENABLED;
            }
            if (getUpdateUrl(context, overrideMap, getDisableAntiBrickingMeasures(context, overrideMap), context != null ? UpdatesConfigurationOverride.INSTANCE.load$expo_updates_release(context) : null) == null) {
                return UpdatesConfigurationValidationResult.INVALID_MISSING_URL;
            }
            String runtimeVersion = getRuntimeVersion(context, overrideMap);
            if (runtimeVersion == null || runtimeVersion.length() == 0) {
                return UpdatesConfigurationValidationResult.INVALID_MISSING_RUNTIME_VERSION;
            }
            return UpdatesConfigurationValidationResult.VALID;
        }

        public final UpdatesConfiguration create(Context context, UpdatesConfiguration config, UpdatesConfigurationOverride configOverride) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(config, "config");
            Map<String, ? extends Object> map = config.cachedOverrideMap;
            return new UpdatesConfiguration(context, map, getDisableAntiBrickingMeasures(context, map), configOverride);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean getDisableAntiBrickingMeasures(Context context, Map<String, ? extends Object> overrideMap) {
            Object obj;
            Boolean boolValueOf = null;
            if (overrideMap != null) {
                if (overrideMap.containsKey(UpdatesConfiguration.UPDATES_CONFIGURATION_DISABLE_ANTI_BRICKING_MEASURES)) {
                    obj = overrideMap.get(UpdatesConfiguration.UPDATES_CONFIGURATION_DISABLE_ANTI_BRICKING_MEASURES);
                    if (!(obj instanceof Boolean)) {
                        Intrinsics.checkNotNull(obj);
                        throw new AssertionError("UpdatesConfiguration failed to initialize: bad value of type " + obj.getClass().getSimpleName() + " provided for key disableAntiBrickingMeasures");
                    }
                } else {
                    obj = null;
                }
                Boolean bool = (Boolean) obj;
                if (bool != null) {
                    return bool.booleanValue();
                }
            }
            if (context != null) {
                Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                if (bundle.containsKey("expo.modules.updates.DISABLE_ANTI_BRICKING_MEASURES")) {
                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Boolean.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                        boolValueOf = (Boolean) bundle.getString("expo.modules.updates.DISABLE_ANTI_BRICKING_MEASURES");
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        boolValueOf = Boolean.valueOf(bundle.getBoolean("expo.modules.updates.DISABLE_ANTI_BRICKING_MEASURES"));
                    } else {
                        boolValueOf = Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE)) ? (Boolean) Integer.valueOf(bundle.getInt("expo.modules.updates.DISABLE_ANTI_BRICKING_MEASURES")) : (Boolean) bundle.get("expo.modules.updates.DISABLE_ANTI_BRICKING_MEASURES");
                    }
                }
            }
            if (boolValueOf != null) {
                return boolValueOf.booleanValue();
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int getMaxUpdatesToKeep(Context context, Map<String, ? extends Object> overrideMap) {
            Object obj;
            Integer numValueOf = null;
            if (overrideMap != null) {
                if (overrideMap.containsKey(UpdatesConfiguration.UPDATES_CONFIGURATION_MAX_UPDATES_TO_KEEP_KEY)) {
                    obj = overrideMap.get(UpdatesConfiguration.UPDATES_CONFIGURATION_MAX_UPDATES_TO_KEEP_KEY);
                    if (!(obj instanceof Integer)) {
                        Intrinsics.checkNotNull(obj);
                        throw new AssertionError("UpdatesConfiguration failed to initialize: bad value of type " + obj.getClass().getSimpleName() + " provided for key maxUpdatesToKeep");
                    }
                } else {
                    obj = null;
                }
                Integer num = (Integer) obj;
                if (num != null) {
                    return num.intValue();
                }
            }
            if (context != null) {
                Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                if (bundle.containsKey("expo.modules.updates.EXPO_UPDATES_MAX_UPDATES_TO_KEEP")) {
                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Integer.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                        numValueOf = (Integer) bundle.getString("expo.modules.updates.EXPO_UPDATES_MAX_UPDATES_TO_KEEP");
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        numValueOf = (Integer) Boolean.valueOf(bundle.getBoolean("expo.modules.updates.EXPO_UPDATES_MAX_UPDATES_TO_KEEP"));
                    } else {
                        numValueOf = Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE)) ? Integer.valueOf(bundle.getInt("expo.modules.updates.EXPO_UPDATES_MAX_UPDATES_TO_KEEP")) : (Integer) bundle.get("expo.modules.updates.EXPO_UPDATES_MAX_UPDATES_TO_KEEP");
                    }
                }
            }
            if (numValueOf != null) {
                return numValueOf.intValue();
            }
            return 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean getOriginalHasEmbeddedUpdate(Context context, Map<String, ? extends Object> overrideMap) {
            Object obj;
            Boolean boolValueOf = null;
            if (overrideMap != null) {
                if (overrideMap.containsKey(UpdatesConfiguration.UPDATES_CONFIGURATION_HAS_EMBEDDED_UPDATE_KEY)) {
                    obj = overrideMap.get(UpdatesConfiguration.UPDATES_CONFIGURATION_HAS_EMBEDDED_UPDATE_KEY);
                    if (!(obj instanceof Boolean)) {
                        Intrinsics.checkNotNull(obj);
                        throw new AssertionError("UpdatesConfiguration failed to initialize: bad value of type " + obj.getClass().getSimpleName() + " provided for key hasEmbeddedUpdate");
                    }
                } else {
                    obj = null;
                }
                Boolean bool = (Boolean) obj;
                if (bool != null) {
                    return bool.booleanValue();
                }
            }
            if (context != null) {
                Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                if (bundle.containsKey("expo.modules.updates.HAS_EMBEDDED_UPDATE")) {
                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Boolean.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                        boolValueOf = (Boolean) bundle.getString("expo.modules.updates.HAS_EMBEDDED_UPDATE");
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        boolValueOf = Boolean.valueOf(bundle.getBoolean("expo.modules.updates.HAS_EMBEDDED_UPDATE"));
                    } else {
                        boolValueOf = Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE)) ? (Boolean) Integer.valueOf(bundle.getInt("expo.modules.updates.HAS_EMBEDDED_UPDATE")) : (Boolean) bundle.get("expo.modules.updates.HAS_EMBEDDED_UPDATE");
                    }
                }
            }
            if (boolValueOf != null) {
                return boolValueOf.booleanValue();
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Uri getOriginalEmbeddedUpdateUrl(Context context, Map<String, ? extends Object> overrideMap) {
            String string;
            Object obj;
            if (overrideMap != null) {
                if (overrideMap.containsKey(UpdatesConfiguration.UPDATES_CONFIGURATION_UPDATE_URL_KEY)) {
                    obj = overrideMap.get(UpdatesConfiguration.UPDATES_CONFIGURATION_UPDATE_URL_KEY);
                    if (!(obj instanceof Uri)) {
                        Intrinsics.checkNotNull(obj);
                        throw new AssertionError("UpdatesConfiguration failed to initialize: bad value of type " + obj.getClass().getSimpleName() + " provided for key updateUrl");
                    }
                } else {
                    obj = null;
                }
                Uri uri = (Uri) obj;
                if (uri != null) {
                    return uri;
                }
            }
            if (context == null) {
                return null;
            }
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle.containsKey("expo.modules.updates.EXPO_UPDATE_URL")) {
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                    string = bundle.getString("expo.modules.updates.EXPO_UPDATE_URL");
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    string = (String) Boolean.valueOf(bundle.getBoolean("expo.modules.updates.EXPO_UPDATE_URL"));
                } else {
                    string = Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE)) ? (String) Integer.valueOf(bundle.getInt("expo.modules.updates.EXPO_UPDATE_URL")) : (String) bundle.get("expo.modules.updates.EXPO_UPDATE_URL");
                }
            } else {
                string = null;
            }
            if (string != null) {
                return Uri.parse(string);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code duplicated, block: B:30:0x00a7  */
        public final Map<String, String> getOriginalEmbeddedRequestHeaders(Context context, Map<String, ? extends Object> overrideMap) {
            Object obj;
            String string = null;
            if (overrideMap != null) {
                if (overrideMap.containsKey(UpdatesConfiguration.UPDATES_CONFIGURATION_REQUEST_HEADERS_KEY)) {
                    obj = overrideMap.get(UpdatesConfiguration.UPDATES_CONFIGURATION_REQUEST_HEADERS_KEY);
                    if (!(obj instanceof Map)) {
                        Intrinsics.checkNotNull(obj);
                        throw new AssertionError("UpdatesConfiguration failed to initialize: bad value of type " + obj.getClass().getSimpleName() + " provided for key requestHeaders");
                    }
                } else {
                    obj = null;
                }
                Map<String, String> map = (Map) obj;
                if (map != null) {
                    return map;
                }
            }
            if (context == null) {
                string = "{}";
            } else {
                Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                if (bundle.containsKey("expo.modules.updates.UPDATES_CONFIGURATION_REQUEST_HEADERS_KEY")) {
                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                        string = bundle.getString("expo.modules.updates.UPDATES_CONFIGURATION_REQUEST_HEADERS_KEY");
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        string = (String) Boolean.valueOf(bundle.getBoolean("expo.modules.updates.UPDATES_CONFIGURATION_REQUEST_HEADERS_KEY"));
                    } else {
                        string = Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE)) ? (String) Integer.valueOf(bundle.getInt("expo.modules.updates.UPDATES_CONFIGURATION_REQUEST_HEADERS_KEY")) : (String) bundle.get("expo.modules.updates.UPDATES_CONFIGURATION_REQUEST_HEADERS_KEY");
                    }
                }
                if (string == null) {
                    string = "{}";
                }
            }
            return UpdatesUtils.INSTANCE.getMapFromJSONString(string);
        }

        private final boolean getIsEnabled(Context context, Map<String, ? extends Object> overrideMap) {
            Object obj;
            Boolean boolValueOf = null;
            if (overrideMap != null) {
                if (overrideMap.containsKey("enabled")) {
                    obj = overrideMap.get("enabled");
                    if (!(obj instanceof Boolean)) {
                        Intrinsics.checkNotNull(obj);
                        throw new AssertionError("UpdatesConfiguration failed to initialize: bad value of type " + obj.getClass().getSimpleName() + " provided for key enabled");
                    }
                } else {
                    obj = null;
                }
                Boolean bool = (Boolean) obj;
                if (bool != null) {
                    return bool.booleanValue();
                }
            }
            if (context != null) {
                Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                if (bundle.containsKey("expo.modules.updates.ENABLED")) {
                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Boolean.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                        boolValueOf = (Boolean) bundle.getString("expo.modules.updates.ENABLED");
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        boolValueOf = Boolean.valueOf(bundle.getBoolean("expo.modules.updates.ENABLED"));
                    } else {
                        boolValueOf = Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE)) ? (Boolean) Integer.valueOf(bundle.getInt("expo.modules.updates.ENABLED")) : (Boolean) bundle.get("expo.modules.updates.ENABLED");
                    }
                }
            }
            if (boolValueOf != null) {
                return boolValueOf.booleanValue();
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code duplicated, block: B:14:0x003e A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:15:0x0040  */
        /* JADX WARN: Code duplicated, block: B:17:0x0058  */
        /* JADX WARN: Code duplicated, block: B:18:0x005a  */
        /* JADX WARN: Code duplicated, block: B:20:0x006c  */
        /* JADX WARN: Code duplicated, block: B:21:0x0073  */
        /* JADX WARN: Code duplicated, block: B:23:0x007f  */
        /* JADX WARN: Code duplicated, block: B:24:0x008a  */
        /* JADX WARN: Code duplicated, block: B:26:0x0096  */
        /* JADX WARN: Code duplicated, block: B:27:0x00a1  */
        /* JADX WARN: Code duplicated, block: B:32:0x00bd  */
        public final String getRuntimeVersion(Context context, Map<String, ? extends Object> overrideMap) throws IOException {
            String strReplaceFirst;
            Bundle bundle;
            KClass orCreateKotlinClass;
            Integer numValueOf;
            String string;
            Object obj;
            if (overrideMap != null) {
                if (overrideMap.containsKey(UpdatesConfiguration.UPDATES_CONFIGURATION_RUNTIME_VERSION_KEY)) {
                    obj = overrideMap.get(UpdatesConfiguration.UPDATES_CONFIGURATION_RUNTIME_VERSION_KEY);
                    if (!(obj instanceof String)) {
                        Intrinsics.checkNotNull(obj);
                        throw new AssertionError("UpdatesConfiguration failed to initialize: bad value of type " + obj.getClass().getSimpleName() + " provided for key runtimeVersion");
                    }
                } else {
                    obj = null;
                }
                strReplaceFirst = (String) obj;
                if (strReplaceFirst == null) {
                    if (context != null) {
                        bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                        if (bundle.containsKey("expo.modules.updates.EXPO_RUNTIME_VERSION")) {
                            orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                                numValueOf = bundle.getString("expo.modules.updates.EXPO_RUNTIME_VERSION");
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                numValueOf = Boolean.valueOf(bundle.getBoolean("expo.modules.updates.EXPO_RUNTIME_VERSION"));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                numValueOf = Integer.valueOf(bundle.getInt("expo.modules.updates.EXPO_RUNTIME_VERSION"));
                            } else {
                                numValueOf = bundle.get("expo.modules.updates.EXPO_RUNTIME_VERSION");
                            }
                        } else {
                            numValueOf = null;
                        }
                        if (numValueOf != null) {
                            strReplaceFirst = null;
                        } else {
                            strReplaceFirst = null;
                        }
                    } else {
                        strReplaceFirst = null;
                    }
                }
            } else if (context != null) {
                bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                if (bundle.containsKey("expo.modules.updates.EXPO_RUNTIME_VERSION")) {
                    numValueOf = null;
                } else {
                    orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                        numValueOf = bundle.getString("expo.modules.updates.EXPO_RUNTIME_VERSION");
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        numValueOf = Boolean.valueOf(bundle.getBoolean("expo.modules.updates.EXPO_RUNTIME_VERSION"));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        numValueOf = Integer.valueOf(bundle.getInt("expo.modules.updates.EXPO_RUNTIME_VERSION"));
                    } else {
                        numValueOf = bundle.get("expo.modules.updates.EXPO_RUNTIME_VERSION");
                    }
                }
                if (numValueOf != null || (string = numValueOf.toString()) == null) {
                    strReplaceFirst = null;
                } else {
                    strReplaceFirst = new Regex("^string:").replaceFirst(string, "");
                }
            } else {
                strReplaceFirst = null;
            }
            if (context == null || !Intrinsics.areEqual(strReplaceFirst, UpdatesConfiguration.UPDATES_CONFIGURATION_RUNTIME_VERSION_READ_FINGERPRINT_FILE_SENTINEL)) {
                return strReplaceFirst;
            }
            InputStream inputStreamOpen = context.getAssets().open(UpdatesConfiguration.FINGERPRINT_FILE_NAME);
            try {
                InputStream inputStream = inputStreamOpen;
                Intrinsics.checkNotNull(inputStream);
                Reader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
                BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                try {
                    String text = TextStreamsKt.readText(bufferedReader);
                    CloseableKt.closeFinally(bufferedReader, null);
                    CloseableKt.closeFinally(inputStreamOpen, null);
                    return text;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(bufferedReader, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    CloseableKt.closeFinally(inputStreamOpen, th3);
                    throw th4;
                }
            }
        }
    }
}
