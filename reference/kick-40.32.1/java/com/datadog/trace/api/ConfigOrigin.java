package com.datadog.trace.api;

import com.facebook.hermes.intl.Constants;

/* JADX INFO: loaded from: classes6.dex */
public enum ConfigOrigin {
    ENV("env_var"),
    REMOTE("remote_config"),
    JVM_PROP("jvm_prop"),
    DEFAULT(Constants.COLLATION_DEFAULT);

    public final String value;

    ConfigOrigin(String str) {
        this.value = str;
    }
}
