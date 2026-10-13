package com.datadog.trace.core;

import com.datadog.trace.bootstrap.instrumentation.api.UTF8BytesString;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public final class Metadata {
    private final Map<String, String> baggage;
    private final UTF8BytesString httpStatusCode;
    private final int longRunningVersion;
    private final boolean measured;
    private final CharSequence origin;
    private final int samplingPriority;
    private final Map<String, Object> tags;
    private final long threadId;
    private final UTF8BytesString threadName;
    private final boolean topLevel;

    public Metadata(long j, UTF8BytesString uTF8BytesString, Map<String, Object> map, Map<String, String> map2, int i, boolean z, boolean z2, UTF8BytesString uTF8BytesString2, CharSequence charSequence, int i2) {
        this.threadId = j;
        this.threadName = uTF8BytesString;
        this.httpStatusCode = uTF8BytesString2;
        this.tags = map;
        this.baggage = map2;
        this.samplingPriority = i;
        this.measured = z;
        this.topLevel = z2;
        this.origin = charSequence;
        this.longRunningVersion = i2;
    }

    public UTF8BytesString getHttpStatusCode() {
        return this.httpStatusCode;
    }

    public CharSequence getOrigin() {
        return this.origin;
    }

    public long getThreadId() {
        return this.threadId;
    }

    public UTF8BytesString getThreadName() {
        return this.threadName;
    }

    public Map<String, Object> getTags() {
        return this.tags;
    }

    public Map<String, String> getBaggage() {
        return this.baggage;
    }

    public boolean measured() {
        return this.measured;
    }

    public int longRunningVersion() {
        return this.longRunningVersion;
    }

    public boolean topLevel() {
        return this.topLevel;
    }

    public boolean hasSamplingPriority() {
        return this.samplingPriority != -128;
    }

    public int samplingPriority() {
        return this.samplingPriority;
    }
}
