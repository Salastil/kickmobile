package com.datadog.android.rum.event;

import com.datadog.android.event.EventMapper;
import com.datadog.android.rum.model.ViewEvent;
import kotlin.Metadata;

/* JADX INFO: compiled from: ViewEventMapper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¨\u0006\u0005"}, d2 = {"Lcom/datadog/android/rum/event/ViewEventMapper;", "Lcom/datadog/android/event/EventMapper;", "Lcom/datadog/android/rum/model/ViewEvent;", "map", "event", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ViewEventMapper extends EventMapper<ViewEvent> {
    ViewEvent map(ViewEvent event);
}
