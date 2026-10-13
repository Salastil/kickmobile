package com.datadog.android.core.internal.net;

import com.datadog.android.log.LogAttributes;
import com.datadog.android.trace.TracingHeaderType;
import com.google.android.gms.common.internal.ImagesContract;
import io.ktor.util.date.GMTDateParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: DefaultFirstPartyHostHeaderTypeResolver.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003¢\u0006\u0002\u0010\u0007J'\u0010\u000e\u001a\u00020\u000f2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003H\u0000¢\u0006\u0002\b\u0011J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0014\u001a\u00020\u0004H\u0016J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0004H\u0016J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004H\u0002J\"\u0010\u001c\u001a\u00020\u000f2\u0018\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003H\u0002J\f\u0010\u001e\u001a\u00020\u0017*\u00020\u0004H\u0002J\f\u0010\u001f\u001a\u00020\r*\u00020\u0004H\u0002RB\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00032\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/datadog/android/core/internal/net/DefaultFirstPartyHostHeaderTypeResolver;", "Lcom/datadog/android/core/internal/net/FirstPartyHostHeaderTypeResolver;", "hosts", "", "", "", "Lcom/datadog/android/trace/TracingHeaderType;", "(Ljava/util/Map;)V", "<set-?>", "knownHosts", "getKnownHosts$dd_sdk_android_core_release", "()Ljava/util/Map;", "wildcardMatchers", "Lkotlin/text/Regex;", "addKnownHostsWithHeaderTypes", "", "hostsWithHeaderTypes", "addKnownHostsWithHeaderTypes$dd_sdk_android_core_release", "getAllHeaderTypes", "headerTypesForUrl", ImagesContract.URL, "Lokhttp3/HttpUrl;", "isEmpty", "", "isFirstPartyUrl", "matchesHost", LogAttributes.HOST, "pattern", "updateKnownHosts", "newHosts", "isWildcardPattern", "toHostMatchingRegex", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DefaultFirstPartyHostHeaderTypeResolver implements FirstPartyHostHeaderTypeResolver {
    private Map<String, ? extends Set<? extends TracingHeaderType>> knownHosts;
    private Map<String, Regex> wildcardMatchers;

    public DefaultFirstPartyHostHeaderTypeResolver(Map<String, ? extends Set<? extends TracingHeaderType>> hosts) {
        Intrinsics.checkNotNullParameter(hosts, "hosts");
        this.knownHosts = MapsKt.emptyMap();
        this.wildcardMatchers = MapsKt.emptyMap();
        Set<Map.Entry<String, ? extends Set<? extends TracingHeaderType>>> setEntrySet = hosts.entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10)), 16));
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase = str.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            Pair pair = TuplesKt.to(lowerCase, entry.getValue());
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        updateKnownHosts(linkedHashMap);
    }

    public final Map<String, Set<TracingHeaderType>> getKnownHosts$dd_sdk_android_core_release() {
        return this.knownHosts;
    }

    @Override // com.datadog.android.core.internal.net.FirstPartyHostHeaderTypeResolver
    public boolean isFirstPartyUrl(HttpUrl url) {
        Intrinsics.checkNotNullParameter(url, "url");
        String strHost = url.host();
        Set<String> setKeySet = this.knownHosts.keySet();
        if ((setKeySet instanceof Collection) && setKeySet.isEmpty()) {
            return false;
        }
        Iterator<T> it = setKeySet.iterator();
        while (it.hasNext()) {
            if (matchesHost(strHost, (String) it.next())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.datadog.android.core.internal.net.FirstPartyHostHeaderTypeResolver
    public boolean isFirstPartyUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        HttpUrl httpUrl = HttpUrl.INSTANCE.parse(url);
        if (httpUrl == null) {
            return false;
        }
        return isFirstPartyUrl(httpUrl);
    }

    @Override // com.datadog.android.core.internal.net.FirstPartyHostHeaderTypeResolver
    public Set<TracingHeaderType> headerTypesForUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        HttpUrl httpUrl = HttpUrl.INSTANCE.parse(url);
        return httpUrl == null ? SetsKt.emptySet() : headerTypesForUrl(httpUrl);
    }

    @Override // com.datadog.android.core.internal.net.FirstPartyHostHeaderTypeResolver
    public Set<TracingHeaderType> headerTypesForUrl(HttpUrl url) {
        Object next;
        Intrinsics.checkNotNullParameter(url, "url");
        String strHost = url.host();
        Set<TracingHeaderType> set = (Set) this.knownHosts.get(strHost);
        if (set != null) {
            return set;
        }
        Set<Map.Entry<String, ? extends Set<? extends TracingHeaderType>>> setEntrySet = this.knownHosts.entrySet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : setEntrySet) {
            if (matchesHost(strHost, (String) ((Map.Entry) obj).getKey())) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                int length = ((String) ((Map.Entry) next).getKey()).length();
                do {
                    Object next2 = it.next();
                    int length2 = ((String) ((Map.Entry) next2).getKey()).length();
                    if (length < length2) {
                        next = next2;
                        length = length2;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        Map.Entry entry = (Map.Entry) next;
        Set<TracingHeaderType> set2 = entry != null ? (Set) entry.getValue() : null;
        return set2 == null ? SetsKt.emptySet() : set2;
    }

    @Override // com.datadog.android.core.internal.net.FirstPartyHostHeaderTypeResolver
    public Set<TracingHeaderType> getAllHeaderTypes() {
        return CollectionsKt.toSet(CollectionsKt.flatten(this.knownHosts.values()));
    }

    @Override // com.datadog.android.core.internal.net.FirstPartyHostHeaderTypeResolver
    public boolean isEmpty() {
        return this.knownHosts.isEmpty();
    }

    public final void addKnownHostsWithHeaderTypes$dd_sdk_android_core_release(Map<String, ? extends Set<? extends TracingHeaderType>> hostsWithHeaderTypes) {
        Intrinsics.checkNotNullParameter(hostsWithHeaderTypes, "hostsWithHeaderTypes");
        Map<String, ? extends Set<? extends TracingHeaderType>> map = this.knownHosts;
        Set<Map.Entry<String, ? extends Set<? extends TracingHeaderType>>> setEntrySet = hostsWithHeaderTypes.entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10)), 16));
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase = str.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            Pair pair = TuplesKt.to(lowerCase, entry.getValue());
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        updateKnownHosts(MapsKt.plus(map, linkedHashMap));
    }

    private final void updateKnownHosts(Map<String, ? extends Set<? extends TracingHeaderType>> newHosts) {
        this.knownHosts = newHosts;
        Set<String> setKeySet = newHosts.keySet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : setKeySet) {
            if (isWildcardPattern((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList2, 10)), 16));
        for (Object obj2 : arrayList2) {
            linkedHashMap.put(obj2, toHostMatchingRegex((String) obj2));
        }
        this.wildcardMatchers = linkedHashMap;
    }

    private final boolean isWildcardPattern(String str) {
        String str2 = str;
        int i = 0;
        for (int i2 = 0; i2 < str2.length(); i2++) {
            if (str2.charAt(i2) == '*') {
                i++;
            }
        }
        return i == 1 && StringsKt.startsWith$default(StringsKt.substringAfter$default(str, GMTDateParser.ANY, (String) null, 2, (Object) null), ".", false, 2, (Object) null);
    }

    private final boolean matchesHost(String host, String pattern) {
        Regex regex = this.wildcardMatchers.get(pattern);
        if (regex != null) {
            return regex.matchEntire(host) != null;
        }
        if (!Intrinsics.areEqual(host, pattern)) {
            if (!StringsKt.endsWith$default(host, "." + pattern, false, 2, (Object) null)) {
                return false;
            }
        }
        return true;
    }

    private final Regex toHostMatchingRegex(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '*') {
                sb.append("[a-z0-9.-]+");
            } else if (StringsKt.contains$default((CharSequence) "\\^$.|?+()[]{}", cCharAt, false, 2, (Object) null)) {
                sb.append('\\');
                sb.append(cCharAt);
            } else {
                sb.append(cCharAt);
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return new Regex(string);
    }
}
