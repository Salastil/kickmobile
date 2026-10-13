package io.datazoom.sdk.domain;

import com.facebook.hermes.intl.Constants;
import io.datazoom.sdk.time.Time;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: TimeStampsStore.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007J\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u000eJ\u001f\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\f¢\u0006\u0002\u0010\u0013J\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u0016\u001a\u00020\tR\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lio/datazoom/sdk/domain/TimeStampsStore;", "", "<init>", "()V", "events", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lio/datazoom/sdk/domain/EventEntry;", "addEvent", "", "entry", "lastEventTimeBy", "", "id", "", "(Ljava/lang/String;)Ljava/lang/Long;", "lastEventBy", "timeSince", "current", "(Ljava/lang/String;J)Ljava/lang/Long;", "getEventsBy", "totalEventTime", "clear", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class TimeStampsStore {
    private final MutableStateFlow<List<EventEntry>> events = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());

    public final void addEvent(EventEntry entry) {
        List<EventEntry> value;
        Intrinsics.checkNotNullParameter(entry, "entry");
        MutableStateFlow<List<EventEntry>> mutableStateFlow = this.events;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, CollectionsKt.plus((Collection<? extends EventEntry>) value, entry)));
    }

    public final Long lastEventTimeBy(String id) {
        EventEntry eventEntryPrevious;
        Intrinsics.checkNotNullParameter(id, "id");
        List<EventEntry> value = this.events.getValue();
        ListIterator<EventEntry> listIterator = value.listIterator(value.size());
        do {
            if (!listIterator.hasPrevious()) {
                eventEntryPrevious = null;
                break;
            }
            eventEntryPrevious = listIterator.previous();
        } while (!Intrinsics.areEqual(eventEntryPrevious.getType(), id));
        EventEntry eventEntry = eventEntryPrevious;
        if (eventEntry != null) {
            return Long.valueOf(eventEntry.getTime());
        }
        return null;
    }

    public final EventEntry lastEventBy(String id) {
        EventEntry eventEntryPrevious;
        Intrinsics.checkNotNullParameter(id, "id");
        List<EventEntry> value = this.events.getValue();
        ListIterator<EventEntry> listIterator = value.listIterator(value.size());
        while (listIterator.hasPrevious()) {
            eventEntryPrevious = listIterator.previous();
            if (Intrinsics.areEqual(eventEntryPrevious.getType(), id)) {
                return eventEntryPrevious;
            }
        }
        eventEntryPrevious = null;
        return eventEntryPrevious;
    }

    public static /* synthetic */ Long timeSince$default(TimeStampsStore timeStampsStore, String str, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = Time.INSTANCE.now();
        }
        return timeStampsStore.timeSince(str, j);
    }

    public final Long timeSince(String id, long current) {
        Intrinsics.checkNotNullParameter(id, "id");
        EventEntry eventEntryLastEventBy = lastEventBy(id);
        if (eventEntryLastEventBy != null) {
            return Long.valueOf(TimeStampsStoreKt.since(eventEntryLastEventBy, current));
        }
        return null;
    }

    public final List<EventEntry> getEventsBy(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        List<EventEntry> value = this.events.getValue();
        ArrayList arrayList = new ArrayList();
        for (Object obj : value) {
            if (Intrinsics.areEqual(((EventEntry) obj).getType(), id)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final long totalEventTime(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        List<EventEntry> eventsBy = getEventsBy(id);
        long time = 0;
        if (eventsBy.size() <= 1) {
            return 0L;
        }
        int size = eventsBy.size();
        for (int i = 1; i < size; i++) {
            time += eventsBy.get(i).getTime() - eventsBy.get(i - 1).getTime();
        }
        return time;
    }

    public final void clear() {
        MutableStateFlow<List<EventEntry>> mutableStateFlow = this.events;
        while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), CollectionsKt.emptyList())) {
        }
    }
}
