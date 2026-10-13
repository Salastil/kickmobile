package com.datadog.trace.api.naming.v0;

import com.datadog.trace.api.naming.NamingSchema;

/* JADX INFO: loaded from: classes6.dex */
public class CacheNamingV0 implements NamingSchema.ForCache {
    private final boolean allowInferredServices;

    public CacheNamingV0(boolean z) {
        this.allowInferredServices = z;
    }

    @Override // com.datadog.trace.api.naming.NamingSchema.ForCache
    public String operation(String str) {
        String str2;
        str.hashCode();
        if (str.equals("hazelcast")) {
            str2 = ".invoke";
        } else if (str.equals("ignite")) {
            str2 = ".cache";
        } else {
            str2 = ".query";
        }
        return str + str2;
    }

    @Override // com.datadog.trace.api.naming.NamingSchema.ForCache
    public String service(String str) {
        if (this.allowInferredServices) {
            return "hazelcast".equals(str) ? "hazelcast-sdk" : str;
        }
        return null;
    }
}
