package com.datadog.trace.api.naming;

import com.datadog.trace.api.Config;
import com.datadog.trace.api.naming.v0.NamingSchemaV0;
import com.datadog.trace.api.naming.v1.NamingSchemaV1;

/* JADX INFO: loaded from: classes6.dex */
public class SpanNaming {
    public static final int SCHEMA_MAX_VERSION = 1;
    public static final int SCHEMA_MIN_VERSION = 0;
    private final NamingSchema namingSchema;
    private final int version;

    public static class Singleton {
        private static SpanNaming INSTANCE = new SpanNaming();
    }

    public static SpanNaming instance() {
        return Singleton.INSTANCE;
    }

    private SpanNaming() {
        this(Config.get().getSpanAttributeSchemaVersion());
    }

    private SpanNaming(int i) {
        this.version = i;
        if (i == 1) {
            this.namingSchema = new NamingSchemaV1();
        } else {
            this.namingSchema = new NamingSchemaV0();
        }
    }

    public NamingSchema namingSchema() {
        return this.namingSchema;
    }

    public int version() {
        return this.version;
    }
}
