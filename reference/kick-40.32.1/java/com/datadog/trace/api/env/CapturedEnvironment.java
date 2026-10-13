package com.datadog.trace.api.env;

import io.ktor.sse.ServerSentEventKt;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class CapturedEnvironment {
    private static final CapturedEnvironment INSTANCE = new CapturedEnvironment();
    private final Map<String, String> properties;

    CapturedEnvironment() {
        HashMap map = new HashMap();
        this.properties = map;
        map.put("service.name", autodetectServiceName());
    }

    public Map<String, String> getProperties() {
        return this.properties;
    }

    static void useFixedEnv(Map<String, String> map) {
        INSTANCE.properties.clear();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            INSTANCE.properties.put(entry.getKey(), entry.getValue());
        }
    }

    private String autodetectServiceName() {
        String str = System.getenv("DD_AZURE_APP_SERVICES");
        String str2 = System.getenv("WEBSITE_SITE_NAME");
        return (("true".equalsIgnoreCase(str) || "1".equals(str)) && str2 != null) ? str2 : extractJarOrClass(System.getProperty("sun.java.command"));
    }

    private String extractJarOrClass(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        String[] strArrSplit = str.trim().split(ServerSentEventKt.SPACE);
        if (strArrSplit.length == 0 || strArrSplit[0].equals("")) {
            return null;
        }
        String str2 = strArrSplit[0];
        return str2.endsWith(".jar") ? new File(str2).getName().replace(".jar", "") : str2;
    }

    public static CapturedEnvironment get() {
        return INSTANCE;
    }
}
