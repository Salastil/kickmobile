package com.datadog.android.rum.internal.domain.scope;

import com.datadog.android.rum.internal.domain.event.ResourceTiming;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: ExternalResourceTimings.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a\u001e\u0010\n\u001a\u00020\u000b2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rH\u0002\u001a\"\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\rH\u0000\u001a(\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0013\u001a\u00020\u00022\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00110\rH\u0002\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"ALL_TIMINGS", "", "", "CONNECT_TIMING", "DNS_TIMING", "DOWNLOAD_TIMING", "DURATION_KEY", "FIRST_BYTE_TIMING", "SSL_TIMING", "START_TIME_KEY", "createResourceTiming", "Lcom/datadog/android/rum/internal/domain/event/ResourceTiming;", "timings", "", "Lcom/datadog/android/rum/internal/domain/scope/Timing;", "extractResourceTiming", "timingsPayload", "", "extractTiming", "name", "source", "dd-sdk-android-rum_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ExternalResourceTimingsKt {
    private static final String DURATION_KEY = "duration";
    private static final String START_TIME_KEY = "startTime";
    private static final String FIRST_BYTE_TIMING = "firstByte";
    private static final String DOWNLOAD_TIMING = "download";
    private static final String SSL_TIMING = "ssl";
    private static final String CONNECT_TIMING = "connect";
    private static final String DNS_TIMING = "dns";
    private static final List<String> ALL_TIMINGS = CollectionsKt.listOf((Object[]) new String[]{FIRST_BYTE_TIMING, DOWNLOAD_TIMING, SSL_TIMING, CONNECT_TIMING, DNS_TIMING});

    public static final ResourceTiming extractResourceTiming(Map<String, ? extends Object> map) {
        if (map == null) {
            return null;
        }
        List<String> list = ALL_TIMINGS;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
        for (Object obj : list) {
            linkedHashMap.put(obj, extractTiming((String) obj, map));
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (((Timing) entry.getValue()) != null) {
                linkedHashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        LinkedHashMap linkedHashMap3 = linkedHashMap2;
        if (linkedHashMap3.isEmpty()) {
            return null;
        }
        return createResourceTiming(linkedHashMap3);
    }

    private static final ResourceTiming createResourceTiming(Map<String, Timing> map) {
        Timing timing = map.get(FIRST_BYTE_TIMING);
        long startTime = timing != null ? timing.getStartTime() : 0L;
        Timing timing2 = map.get(FIRST_BYTE_TIMING);
        long duration = timing2 != null ? timing2.getDuration() : 0L;
        Timing timing3 = map.get(DOWNLOAD_TIMING);
        long startTime2 = timing3 != null ? timing3.getStartTime() : 0L;
        Timing timing4 = map.get(DOWNLOAD_TIMING);
        long duration2 = timing4 != null ? timing4.getDuration() : 0L;
        Timing timing5 = map.get(DNS_TIMING);
        long startTime3 = timing5 != null ? timing5.getStartTime() : 0L;
        Timing timing6 = map.get(DNS_TIMING);
        long duration3 = timing6 != null ? timing6.getDuration() : 0L;
        Timing timing7 = map.get(CONNECT_TIMING);
        long startTime4 = timing7 != null ? timing7.getStartTime() : 0L;
        Timing timing8 = map.get(CONNECT_TIMING);
        long duration4 = timing8 != null ? timing8.getDuration() : 0L;
        Timing timing9 = map.get(SSL_TIMING);
        long startTime5 = timing9 != null ? timing9.getStartTime() : 0L;
        Timing timing10 = map.get(SSL_TIMING);
        return new ResourceTiming(startTime3, duration3, startTime4, duration4, startTime5, timing10 != null ? timing10.getDuration() : 0L, startTime, duration, startTime2, duration2);
    }

    private static final Timing extractTiming(String str, Map<String, ? extends Object> map) {
        Object obj = map.get(str);
        if (obj == null || !(obj instanceof Map)) {
            return null;
        }
        Map map2 = (Map) obj;
        Object obj2 = map2.get(START_TIME_KEY);
        Number number = obj2 instanceof Number ? (Number) obj2 : null;
        Long lValueOf = number != null ? Long.valueOf(number.longValue()) : null;
        Object obj3 = map2.get("duration");
        Number number2 = obj3 instanceof Number ? (Number) obj3 : null;
        Long lValueOf2 = number2 != null ? Long.valueOf(number2.longValue()) : null;
        if (lValueOf == null || lValueOf2 == null) {
            return null;
        }
        return new Timing(lValueOf.longValue(), lValueOf2.longValue());
    }
}
