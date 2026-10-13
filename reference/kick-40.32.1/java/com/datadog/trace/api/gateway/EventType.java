package com.datadog.trace.api.gateway;

/* JADX INFO: loaded from: classes5.dex */
public class EventType<C> {
    private final int id;
    private final String name;

    protected EventType(String str, int i) {
        this.name = str;
        this.id = i;
    }

    public String getName() {
        return this.name;
    }

    int getId() {
        return this.id;
    }

    public String toString() {
        return "EventType{name='" + this.name + "'}";
    }
}
