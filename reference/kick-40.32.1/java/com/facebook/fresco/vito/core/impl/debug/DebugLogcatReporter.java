package com.facebook.fresco.vito.core.impl.debug;

import com.facebook.common.logging.FLog;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DebugLogcatReporter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JL\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u0018J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R*\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/debug/DebugLogcatReporter;", "", "<init>", "()V", "TAG", "", "MAX_TRACKED_IDS", "", "reportedIds", "Ljava/util/LinkedHashMap;", "", "", "Lkotlin/collections/LinkedHashMap;", "lock", "maybeReport", "", "imageId", "uri", "imgW", "imgH", "drawW", "drawH", "origin", "config", "Lcom/facebook/fresco/vito/core/impl/debug/ImageFitRatioConfig;", "colorToStatus", "color", "core-common-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DebugLogcatReporter {
    private static final int MAX_TRACKED_IDS = 2000;
    private static final String TAG = "ImageFitRatio";
    public static final DebugLogcatReporter INSTANCE = new DebugLogcatReporter();
    private static final LinkedHashMap<Long, Boolean> reportedIds = new LinkedHashMap<Long, Boolean>() { // from class: com.facebook.fresco.vito.core.impl.debug.DebugLogcatReporter$reportedIds$1
        public /* bridge */ boolean containsKey(Long l) {
            return super.containsKey((Object) l);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object obj) {
            if (obj instanceof Long) {
                return containsKey((Long) obj);
            }
            return false;
        }

        public /* bridge */ boolean containsValue(Boolean bool) {
            return super.containsValue((Object) bool);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsValue(Object obj) {
            if (obj instanceof Boolean) {
                return containsValue((Boolean) obj);
            }
            return false;
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Map.Entry<Long, Boolean>> entrySet() {
            return getEntries();
        }

        public /* bridge */ Boolean get(Long l) {
            return (Boolean) super.get((Object) l);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Boolean get(Object obj) {
            if (obj instanceof Long) {
                return get((Long) obj);
            }
            return null;
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            if (obj instanceof Long) {
                return get((Long) obj);
            }
            return null;
        }

        public /* bridge */ Set<Map.Entry<Long, Boolean>> getEntries() {
            return super.entrySet();
        }

        public /* bridge */ Set<Long> getKeys() {
            return super.keySet();
        }

        public /* bridge */ Boolean getOrDefault(Long l, Boolean bool) {
            return (Boolean) super.getOrDefault((Object) l, bool);
        }

        public final /* bridge */ Boolean getOrDefault(Object obj, Boolean bool) {
            return !(obj instanceof Long) ? bool : getOrDefault((Long) obj, bool);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
            return !(obj instanceof Long) ? obj2 : getOrDefault((Long) obj, (Boolean) obj2);
        }

        public /* bridge */ int getSize() {
            return super.size();
        }

        public /* bridge */ Collection<Boolean> getValues() {
            return super.values();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Long> keySet() {
            return getKeys();
        }

        public /* bridge */ Boolean remove(Long l) {
            return (Boolean) super.remove((Object) l);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Boolean remove(Object obj) {
            if (obj instanceof Long) {
                return remove((Long) obj);
            }
            return null;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object remove(Object obj) {
            if (obj instanceof Long) {
                return remove((Long) obj);
            }
            return null;
        }

        public /* bridge */ boolean remove(Long l, Boolean bool) {
            return super.remove((Object) l, (Object) bool);
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ boolean remove(Object obj, Object obj2) {
            if ((obj instanceof Long) && (obj2 instanceof Boolean)) {
                return remove((Long) obj, (Boolean) obj2);
            }
            return false;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Collection<Boolean> values() {
            return getValues();
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<Long, Boolean> eldest) {
            return size() > 2000;
        }
    };
    private static final Object lock = new Object();

    private DebugLogcatReporter() {
    }

    public final void maybeReport(long imageId, String uri, int imgW, int imgH, int drawW, int drawH, String origin, ImageFitRatioConfig config) {
        boolean z;
        Intrinsics.checkNotNullParameter(config, "config");
        if (imgW <= 0 || imgH <= 0 || drawW <= 0 || drawH <= 0) {
            return;
        }
        synchronized (lock) {
            LinkedHashMap<Long, Boolean> linkedHashMap = reportedIds;
            z = true;
            if (!linkedHashMap.containsKey(Long.valueOf(imageId))) {
                linkedHashMap.put(Long.valueOf(imageId), true);
                z = false;
            }
        }
        if (z) {
            return;
        }
        Pair<String, Integer> pairComputeImageFitRatioAndColor = DebugDataProviderKt.computeImageFitRatioAndColor(imgW, imgH, drawW, drawH, config);
        String strComponent1 = pairComputeImageFitRatioAndColor.component1();
        int iIntValue = pairComputeImageFitRatioAndColor.component2().intValue();
        Pair pairComputeWastedMemoryAndColor = DebugDataProviderKt.computeWastedMemoryAndColor(imgW, imgH, drawW, drawH, (16 & 16) != 0 ? 4 : 0, (16 & 32) != 0 ? new ImageFitRatioConfig(0.0f, 0.0f, 0.0f, 0L, 15, null) : config);
        FLog.d(TAG, "id=%d uri=%s imgW=%d imgH=%d drawW=%d drawH=%d ratio=%s ratioStatus=%s waste=%s wasteStatus=%s origin=%s", Long.valueOf(imageId), uri == null ? "unknown" : uri, Integer.valueOf(imgW), Integer.valueOf(imgH), Integer.valueOf(drawW), Integer.valueOf(drawH), strComponent1, colorToStatus(iIntValue), (String) pairComputeWastedMemoryAndColor.component1(), colorToStatus(((Number) pairComputeWastedMemoryAndColor.component2()).intValue()), origin == null ? "unknown" : origin);
    }

    private final String colorToStatus(int color) {
        if (color == -16711936) {
            return "GREEN";
        }
        if (color == -65536) {
            return "RED";
        }
        if (color == -256) {
            return "YELLOW";
        }
        return "GRAY";
    }
}
