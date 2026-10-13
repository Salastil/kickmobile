package com.datadog.trace.api.config;

/* JADX INFO: loaded from: classes6.dex */
public final class CrashTrackingConfig {
    public static final String CRASH_TRACKING_AGENTLESS = "crashtracking.agentless";
    public static final boolean CRASH_TRACKING_AGENTLESS_DEFAULT = false;
    public static final String CRASH_TRACKING_PROXY_HOST = "crashtracking.proxy.host";
    public static final String CRASH_TRACKING_PROXY_PASSWORD = "crashtracking.proxy.password";
    public static final String CRASH_TRACKING_PROXY_PORT = "crashtracking.proxy.port";
    public static final String CRASH_TRACKING_PROXY_USERNAME = "crashtracking.proxy.username";
    public static final String CRASH_TRACKING_TAGS = "crashtracking.tags";
    public static final String CRASH_TRACKING_UPLOAD_TIMEOUT = "crashtracking.upload.timeout";
    public static final int CRASH_TRACKING_UPLOAD_TIMEOUT_DEFAULT = 30;

    private CrashTrackingConfig() {
    }
}
