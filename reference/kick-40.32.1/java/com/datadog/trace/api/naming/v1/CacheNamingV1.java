package com.datadog.trace.api.naming.v1;

import com.datadog.trace.api.naming.NamingSchema;

/* JADX INFO: loaded from: classes6.dex */
public class CacheNamingV1 implements NamingSchema.ForCache {
    @Override // com.datadog.trace.api.naming.NamingSchema.ForCache
    public String service(String str) {
        return null;
    }

    @Override // com.datadog.trace.api.naming.NamingSchema.ForCache
    public String operation(String str) {
        return str + ".command";
    }
}
