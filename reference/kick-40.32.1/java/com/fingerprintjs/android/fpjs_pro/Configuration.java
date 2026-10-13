package com.fingerprintjs.android.fpjs_pro;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0017\u0018\u0000 $2\u00020\u0001:\u0002$%Bo\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u0012\u001a\b\u0002\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000b0\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\r\u001a\u00020\u00078\u0007¢\u0006\f\n\u0004\b\r\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0003\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0006\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0018\u0010\u0017R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR,\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000b0\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001d\u0010\u001cR\u001a\u0010\u000f\u001a\u00020\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001a\u0010\u0005\u001a\u00020\u00048\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010!\u001a\u0004\b\"\u0010#"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro/Configuration;", "", "", "apiKey", "Lcom/fingerprintjs/android/fpjs_pro/Configuration$Region;", "region", "endpointUrl", "", "extendedResponseFormat", "", "fallbackEndpointUrls", "Lkotlin/Pair;", "integrationInfo", "allowUseOfLocationData", "", "locationTimeoutMillis", "<init>", "(Ljava/lang/String;Lcom/fingerprintjs/android/fpjs_pro/Configuration$Region;Ljava/lang/String;ZLjava/util/List;Ljava/util/List;ZJ)V", "Z", "getAllowUseOfLocationData", "()Z", "Ljava/lang/String;", "getApiKey", "()Ljava/lang/String;", "getEndpointUrl", "getExtendedResponseFormat", "Ljava/util/List;", "getFallbackEndpointUrls", "()Ljava/util/List;", "getIntegrationInfo", "J", "getLocationTimeoutMillis", "()J", "Lcom/fingerprintjs/android/fpjs_pro/Configuration$Region;", "getRegion", "()Lcom/fingerprintjs/android/fpjs_pro/Configuration$Region;", "Companion", "Region"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Configuration {
    public static final long DEFAULT_LOCATION_TIMEOUT_MILLIS = 5000;
    private final boolean allowUseOfLocationData;
    private final String apiKey;
    private final String endpointUrl;
    private final boolean extendedResponseFormat;
    private final List<String> fallbackEndpointUrls;
    private final List<Pair<String, String>> integrationInfo;
    private final long locationTimeoutMillis;
    private final Region region;

    public Configuration(String str, Region region, String str2, boolean z, List<String> list, List<Pair<String, String>> list2, boolean z2, long j) {
        this.apiKey = str;
        this.region = region;
        this.endpointUrl = str2;
        this.extendedResponseFormat = z;
        this.fallbackEndpointUrls = list;
        this.integrationInfo = list2;
        this.allowUseOfLocationData = z2;
        this.locationTimeoutMillis = j;
    }

    public final String getApiKey() {
        return this.apiKey;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ Configuration(String str, Region region, String str2, boolean z, List list, List list2, boolean z2, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Region region2 = (i & 2) != 0 ? Region.US : region;
        this(str, region2, (i & 4) != 0 ? region2.getEndpointUrl() : str2, (i & 8) != 0 ? false : z, (i & 16) != 0 ? CollectionsKt.emptyList() : list, (i & 32) != 0 ? CollectionsKt.emptyList() : list2, (i & 64) == 0 ? z2 : false, (i & 128) != 0 ? 5000L : j);
    }

    public final Region getRegion() {
        return this.region;
    }

    public final String getEndpointUrl() {
        return this.endpointUrl;
    }

    public final boolean getExtendedResponseFormat() {
        return this.extendedResponseFormat;
    }

    public final List<String> getFallbackEndpointUrls() {
        return this.fallbackEndpointUrls;
    }

    public final List<Pair<String, String>> getIntegrationInfo() {
        return this.integrationInfo;
    }

    public final boolean getAllowUseOfLocationData() {
        return this.allowUseOfLocationData;
    }

    public final long getLocationTimeoutMillis() {
        return this.locationTimeoutMillis;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0003\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro/Configuration$Region;", "", "", "endpointUrl", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Ljava/lang/String;", "getEndpointUrl", "()Ljava/lang/String;", "US", "EU", "AP"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public enum Region {
        US("https://api.fpjs.io"),
        EU("https://eu.api.fpjs.io"),
        AP("https://ap.api.fpjs.io");

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
        private final String endpointUrl;

        Region(String str) {
            this.endpointUrl = str;
        }

        public final String getEndpointUrl() {
            return this.endpointUrl;
        }

        public static EnumEntries<Region> getEntries() {
            return $ENTRIES;
        }
    }

    public Configuration(String str) {
        this(str, null, null, false, null, null, false, 0L, 254, null);
    }

    public Configuration(String str, Region region) {
        this(str, region, null, false, null, null, false, 0L, 252, null);
    }

    public Configuration(String str, Region region, String str2) {
        this(str, region, str2, false, null, null, false, 0L, 248, null);
    }

    public Configuration(String str, Region region, String str2, boolean z) {
        this(str, region, str2, z, null, null, false, 0L, 240, null);
    }

    public Configuration(String str, Region region, String str2, boolean z, List<String> list) {
        this(str, region, str2, z, list, null, false, 0L, 224, null);
    }

    public Configuration(String str, Region region, String str2, boolean z, List<String> list, List<Pair<String, String>> list2) {
        this(str, region, str2, z, list, list2, false, 0L, 192, null);
    }

    public Configuration(String str, Region region, String str2, boolean z, List<String> list, List<Pair<String, String>> list2, boolean z2) {
        this(str, region, str2, z, list, list2, z2, 0L, 128, null);
    }
}
