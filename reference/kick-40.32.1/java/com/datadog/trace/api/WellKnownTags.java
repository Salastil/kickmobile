package com.datadog.trace.api;

import com.datadog.trace.bootstrap.instrumentation.api.UTF8BytesString;

/* JADX INFO: loaded from: classes6.dex */
public class WellKnownTags {
    private final UTF8BytesString env;
    private final UTF8BytesString hostname;
    private final UTF8BytesString language;
    private final UTF8BytesString runtimeId;
    private final UTF8BytesString service;
    private final UTF8BytesString version;

    public WellKnownTags(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, CharSequence charSequence5, CharSequence charSequence6) {
        this.runtimeId = UTF8BytesString.create(charSequence);
        this.hostname = UTF8BytesString.create(charSequence2);
        this.env = UTF8BytesString.create(charSequence3);
        this.service = UTF8BytesString.create(charSequence4);
        this.version = UTF8BytesString.create(charSequence5);
        this.language = UTF8BytesString.create(charSequence6);
    }

    public UTF8BytesString getRuntimeId() {
        return this.runtimeId;
    }

    public UTF8BytesString getHostname() {
        return this.hostname;
    }

    public UTF8BytesString getEnv() {
        return this.env;
    }

    public UTF8BytesString getService() {
        return this.service;
    }

    public UTF8BytesString getVersion() {
        return this.version;
    }

    public UTF8BytesString getLanguage() {
        return this.language;
    }
}
