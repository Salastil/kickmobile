package io.datazoom.sdk.model;

import com.facebook.hermes.intl.Constants;
import io.datazoom.sdk.network.events.model.EventDto;
import io.datazoom.sdk.time.Time;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Event.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u001a\u009b\u0001\u0010\t\u001a\u00020\n*\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\f2'\b\u0002\u0010\r\u001a!\u0012\u0004\u0012\u00020\b\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\t0\u00120\u000ej\u0002`\u00132'\b\u0002\u0010\u0014\u001a!\u0012\u0004\u0012\u00020\b\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\t0\u00120\u000ej\u0002`\u00132'\b\u0002\u0010\u0015\u001a!\u0012\u0004\u0012\u00020\b\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\t0\u00120\u000ej\u0002`\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u001a\u008f\u0001\u0010\u0018\u001a\u00020\n*\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\f2'\b\u0002\u0010\r\u001a!\u0012\u0004\u0012\u00020\b\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\t0\u00120\u000ej\u0002`\u00132'\b\u0002\u0010\u0014\u001a!\u0012\u0004\u0012\u00020\b\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\t0\u00120\u000ej\u0002`\u00132'\b\u0002\u0010\u0015\u001a!\u0012\u0004\u0012\u00020\b\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\t0\u00120\u000ej\u0002`\u0013\u001a\u008f\u0001\u0010\u0019\u001a\u00020\n*\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\f2'\b\u0002\u0010\r\u001a!\u0012\u0004\u0012\u00020\b\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\t0\u00120\u000ej\u0002`\u00132'\b\u0002\u0010\u0014\u001a!\u0012\u0004\u0012\u00020\b\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\t0\u00120\u000ej\u0002`\u00132'\b\u0002\u0010\u0015\u001a!\u0012\u0004\u0012\u00020\b\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\t0\u00120\u000ej\u0002`\u0013\u001a\n\u0010\u001a\u001a\u00020\b*\u00020\u0004\u001a\n\u0010\u001b\u001a\u00020\b*\u00020\n\u001a\u001a\u0010\u001c\u001a\u00020\u001d*\u00020\n2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020 \"\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000*\n\u0010\u0000\"\u00020\u00012\u00020\u0001¨\u0006!"}, d2 = {"Ap", "Lio/datazoom/sdk/model/Event$Applicability;", "globalEvents", "", "Lio/datazoom/sdk/model/Event$Type;", "getGlobalEvents", "()Ljava/util/List;", "CONTAINER_ID", "", "toEvent", "Lio/datazoom/sdk/model/Event;", "time", "", "customMetadata", "Ljava/util/HashMap;", "", "Lkotlinx/serialization/Serializable;", "with", "Lio/datazoom/sdk/utils/AnySerializer;", "Lio/datazoom/sdk/utils/DataMap;", "metadata", "fluxData", "contentType", "Lio/datazoom/sdk/model/VideoType;", "toAdEvent", "toContentEvent", "uniqueName", "uniqueId", "toEventDto", "Lio/datazoom/sdk/network/events/model/EventDto;", "templatedId", "eventCount", "", Constants.SENSITIVITY_BASE}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class EventKt {
    public static final String CONTAINER_ID = "container_id";
    private static final List<Event.Type> globalEvents = CollectionsKt.listOf(Event.Type.DatazoomLoaded);

    public static final List<Event.Type> getGlobalEvents() {
        return globalEvents;
    }

    public static /* synthetic */ Event toEvent$default(Event.Type type, long j, HashMap map, HashMap map2, HashMap map3, VideoType videoType, int i, Object obj) {
        if ((i & 1) != 0) {
            j = Time.INSTANCE.now();
        }
        long j2 = j;
        if ((i & 2) != 0) {
            map = new HashMap();
        }
        HashMap map4 = map;
        if ((i & 4) != 0) {
            map2 = new HashMap();
        }
        HashMap map5 = map2;
        if ((i & 8) != 0) {
            map3 = new HashMap();
        }
        HashMap map6 = map3;
        if ((i & 16) != 0) {
            videoType = null;
        }
        return toEvent(type, j2, map4, map5, map6, videoType);
    }

    public static final Event toEvent(Event.Type type, long j, HashMap<String, Object> customMetadata, HashMap<String, Object> metadata, HashMap<String, Object> fluxData, VideoType videoType) {
        Intrinsics.checkNotNullParameter(type, "<this>");
        Intrinsics.checkNotNullParameter(customMetadata, "customMetadata");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(fluxData, "fluxData");
        return new Event(type, metadata, fluxData, null, customMetadata, j, null, null, null, null, videoType, 968, null);
    }

    public static /* synthetic */ Event toAdEvent$default(Event.Type type, long j, HashMap map, HashMap map2, HashMap map3, int i, Object obj) {
        if ((i & 1) != 0) {
            j = Time.INSTANCE.now();
        }
        long j2 = j;
        if ((i & 2) != 0) {
            map = new HashMap();
        }
        HashMap map4 = map;
        if ((i & 4) != 0) {
            map2 = new HashMap();
        }
        HashMap map5 = map2;
        if ((i & 8) != 0) {
            map3 = new HashMap();
        }
        return toAdEvent(type, j2, map4, map5, map3);
    }

    public static final Event toAdEvent(Event.Type type, long j, HashMap<String, Object> customMetadata, HashMap<String, Object> metadata, HashMap<String, Object> fluxData) {
        Intrinsics.checkNotNullParameter(type, "<this>");
        Intrinsics.checkNotNullParameter(customMetadata, "customMetadata");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(fluxData, "fluxData");
        return toEvent(type, j, customMetadata, metadata, fluxData, VideoType.AD.INSTANCE);
    }

    public static /* synthetic */ Event toContentEvent$default(Event.Type type, long j, HashMap map, HashMap map2, HashMap map3, int i, Object obj) {
        if ((i & 1) != 0) {
            j = Time.INSTANCE.now();
        }
        long j2 = j;
        if ((i & 2) != 0) {
            map = new HashMap();
        }
        HashMap map4 = map;
        if ((i & 4) != 0) {
            map2 = new HashMap();
        }
        HashMap map5 = map2;
        if ((i & 8) != 0) {
            map3 = new HashMap();
        }
        return toContentEvent(type, j2, map4, map5, map3);
    }

    public static final Event toContentEvent(Event.Type type, long j, HashMap<String, Object> customMetadata, HashMap<String, Object> metadata, HashMap<String, Object> fluxData) {
        Intrinsics.checkNotNullParameter(type, "<this>");
        Intrinsics.checkNotNullParameter(customMetadata, "customMetadata");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(fluxData, "fluxData");
        return toEvent(type, j, customMetadata, metadata, fluxData, VideoType.CONTENT.INSTANCE);
    }

    public static final String uniqueName(Event.Type type) {
        Intrinsics.checkNotNullParameter(type, "<this>");
        return type.name() + "_" + type.getApplicability().name();
    }

    public static final String uniqueId(Event event) {
        Intrinsics.checkNotNullParameter(event, "<this>");
        String strName = event.getType().name();
        Object obj = event.getCustom().get(CONTAINER_ID);
        if (obj == null) {
            obj = "0";
        }
        return strName + "_" + obj;
    }

    public static final EventDto toEventDto(Event event, String templatedId, int i) {
        Intrinsics.checkNotNullParameter(event, "<this>");
        Intrinsics.checkNotNullParameter(templatedId, "templatedId");
        String name = event.getName();
        HashMap<String, Object> metadata = event.getMetadata();
        HashMap<String, Object> fluxData = event.getFluxData();
        fluxData.put(FluxData.Type.EVENT_COUNT.getValue(), Integer.valueOf(i));
        EventDto.Event event2 = new EventDto.Event(name, event.getTime(), fluxData, metadata);
        HashMap<String, Object> custom = event.getCustom();
        return new EventDto((String) null, (String) null, templatedId, (String) null, event2, event.getUserDetails(), (HashMap) null, (HashMap) null, (HashMap) null, event.getVideo(), event.getAd(), (HashMap) null, event.getOpsMetadata(), (HashMap) null, event.getPlayer(), custom, (HashMap) null, 76235, (DefaultConstructorMarker) null);
    }
}
