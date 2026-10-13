package com.datadog.android.rum.internal.domain.event;

import com.datadog.android.api.storage.RawBatchEvent;
import com.datadog.android.core.internal.persistence.Deserializer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RumViewEventFilter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bR\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/datadog/android/rum/internal/domain/event/RumViewEventFilter;", "", "eventMetaDeserializer", "Lcom/datadog/android/core/internal/persistence/Deserializer;", "", "Lcom/datadog/android/rum/internal/domain/event/RumEventMeta;", "(Lcom/datadog/android/core/internal/persistence/Deserializer;)V", "filterOutRedundantViewEvents", "", "Lcom/datadog/android/api/storage/RawBatchEvent;", "batch", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RumViewEventFilter {
    private final Deserializer<byte[], RumEventMeta> eventMetaDeserializer;

    public RumViewEventFilter(Deserializer<byte[], RumEventMeta> eventMetaDeserializer) {
        Intrinsics.checkNotNullParameter(eventMetaDeserializer, "eventMetaDeserializer");
        this.eventMetaDeserializer = eventMetaDeserializer;
    }

    public final List<RawBatchEvent> filterOutRedundantViewEvents(List<RawBatchEvent> batch) {
        Intrinsics.checkNotNullParameter(batch, "batch");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        List<RawBatchEvent> list = batch;
        for (RawBatchEvent rawBatchEvent : list) {
            RumEventMeta rumEventMetaDeserialize = this.eventMetaDeserializer.deserialize(rawBatchEvent.getMetadata());
            if (rumEventMetaDeserialize instanceof RumEventMeta.View) {
                Pair pair = TuplesKt.to(rawBatchEvent, rumEventMetaDeserialize);
                linkedHashMap2.put(pair.getFirst(), pair.getSecond());
                RumEventMeta.View view = (RumEventMeta.View) rumEventMetaDeserialize;
                String viewId = view.getViewId();
                long documentVersion = view.getDocumentVersion();
                Long l = (Long) linkedHashMap.get(viewId);
                if (l == null) {
                    linkedHashMap.put(viewId, Long.valueOf(documentVersion));
                } else {
                    linkedHashMap.put(viewId, Long.valueOf(Math.max(documentVersion, l.longValue())));
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            RawBatchEvent rawBatchEvent2 = (RawBatchEvent) obj;
            if (linkedHashMap2.containsKey(rawBatchEvent2)) {
                RumEventMeta.View view2 = (RumEventMeta.View) MapsKt.getValue(linkedHashMap2, rawBatchEvent2);
                if (Intrinsics.areEqual((Object) view2.getHasAccessibility(), (Object) true) || view2.getDocumentVersion() == ((Number) MapsKt.getValue(linkedHashMap, view2.getViewId())).longValue()) {
                }
            }
            arrayList.add(obj);
        }
        return arrayList;
    }
}
