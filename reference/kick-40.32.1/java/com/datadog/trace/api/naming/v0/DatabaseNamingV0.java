package com.datadog.trace.api.naming.v0;

import com.datadog.trace.api.naming.NamingSchema;

/* JADX INFO: loaded from: classes6.dex */
public class DatabaseNamingV0 implements NamingSchema.ForDatabase {
    private final boolean allowInferredServices;

    @Override // com.datadog.trace.api.naming.NamingSchema.ForDatabase
    public String normalizedName(String str) {
        return str;
    }

    public DatabaseNamingV0(boolean z) {
        this.allowInferredServices = z;
    }

    @Override // com.datadog.trace.api.naming.NamingSchema.ForDatabase
    public String operation(String str) {
        String str2;
        if (!"couchbase".equals(str)) {
            str2 = ".query";
        } else {
            str2 = ".call";
        }
        return str + str2;
    }

    @Override // com.datadog.trace.api.naming.NamingSchema.ForDatabase
    public String service(String str) {
        if (this.allowInferredServices) {
            return str;
        }
        return null;
    }
}
