package com.mux.stats.sdk.core.events;

import com.mux.stats.sdk.core.model.ViewData;

/* JADX INFO: loaded from: classes8.dex */
public class ViewMetricEvent extends BaseEvent {
    public static final String TYPE = "ViewMetricEvent";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewData f241a;

    public ViewMetricEvent(ViewData viewData) {
        this.f241a = viewData;
    }

    @Override // com.mux.stats.sdk.core.events.BaseEvent, com.mux.stats.sdk.core.events.IEvent
    public String getDebugString() {
        String str;
        StringBuilder sb = new StringBuilder("ViewMetricEvent: \n  isViewMetric: ");
        sb.append(isViewMetric());
        if (this.f241a != null) {
            str = "\n  " + this.f241a.getDebugString();
        } else {
            str = "";
        }
        sb.append(str);
        return sb.toString();
    }

    @Override // com.mux.stats.sdk.core.events.BaseEvent, com.mux.stats.sdk.core.events.IEvent
    public String getType() {
        return TYPE;
    }

    public ViewData getViewData() {
        return this.f241a;
    }

    @Override // com.mux.stats.sdk.core.events.BaseEvent, com.mux.stats.sdk.core.events.IEvent
    public boolean isViewMetric() {
        return true;
    }
}
