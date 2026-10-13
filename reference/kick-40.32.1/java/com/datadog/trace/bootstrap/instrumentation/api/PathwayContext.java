package com.datadog.trace.bootstrap.instrumentation.api;

import com.datadog.android.trace.internal.compat.function.Consumer;
import java.io.IOException;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes6.dex */
public interface PathwayContext {
    public static final String DATADOG_KEY = "_datadog";
    public static final String PROPAGATION_KEY = "dd-pathway-ctx";
    public static final String PROPAGATION_KEY_BASE64 = "dd-pathway-ctx-base64";

    byte[] encode() throws IOException;

    long getHash();

    StatsPoint getSavedStats();

    boolean isStarted();

    void saveStats(StatsPoint statsPoint);

    void setCheckpoint(LinkedHashMap<String, String> linkedHashMap, Consumer<StatsPoint> consumer);

    void setCheckpoint(LinkedHashMap<String, String> linkedHashMap, Consumer<StatsPoint> consumer, long j);

    void setCheckpoint(LinkedHashMap<String, String> linkedHashMap, Consumer<StatsPoint> consumer, long j, long j2);

    String strEncode() throws IOException;
}
