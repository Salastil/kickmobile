package com.datadog.trace.api.profiling;

/* JADX INFO: loaded from: classes6.dex */
public enum RecordingType {
    CONTINUOUS("continuous");

    private final String name;

    RecordingType(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }
}
