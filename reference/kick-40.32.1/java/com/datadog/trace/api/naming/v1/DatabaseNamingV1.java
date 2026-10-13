package com.datadog.trace.api.naming.v1;

import com.datadog.trace.api.DDSpanTypes;
import com.datadog.trace.api.naming.NamingSchema;

/* JADX INFO: loaded from: classes6.dex */
public class DatabaseNamingV1 implements NamingSchema.ForDatabase {
    @Override // com.datadog.trace.api.naming.NamingSchema.ForDatabase
    public String service(String str) {
        return null;
    }

    @Override // com.datadog.trace.api.naming.NamingSchema.ForDatabase
    public String normalizedName(String str) {
        str.hashCode();
        if (str.equals("sqlserver")) {
            return "mssql";
        }
        return !str.equals("mongo") ? str : DDSpanTypes.MONGO;
    }

    @Override // com.datadog.trace.api.naming.NamingSchema.ForDatabase
    public String operation(String str) {
        str.hashCode();
        if (str.equals("opensearch.rest")) {
            str = DDSpanTypes.OPENSEARCH;
        } else if (str.equals("elasticsearch.rest")) {
            str = DDSpanTypes.ELASTICSEARCH;
        }
        return str + ".query";
    }
}
