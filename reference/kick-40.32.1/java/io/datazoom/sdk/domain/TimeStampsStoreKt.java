package io.datazoom.sdk.domain;

import com.facebook.hermes.intl.Constants;
import io.datazoom.sdk.model.Event;
import io.datazoom.sdk.model.EventKt;
import io.datazoom.sdk.time.Time;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TimeStampsStore.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0014\u0010\u0003\u001a\u00020\u0004*\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"}, d2 = {"toEntry", "Lio/datazoom/sdk/domain/EventEntry;", "Lio/datazoom/sdk/model/Event;", "since", "", "current", Constants.SENSITIVITY_BASE}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class TimeStampsStoreKt {
    public static final EventEntry toEntry(Event event) {
        Intrinsics.checkNotNullParameter(event, "<this>");
        return new EventEntry(EventKt.uniqueName(event.getType()), event.getTime());
    }

    public static final long since(EventEntry eventEntry, long j) {
        Intrinsics.checkNotNullParameter(eventEntry, "<this>");
        return j - eventEntry.getTime();
    }

    public static /* synthetic */ long since$default(EventEntry eventEntry, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = Time.INSTANCE.now();
        }
        return since(eventEntry, j);
    }
}
