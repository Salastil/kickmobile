package com.datadog.trace.common.writer;

import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public interface RemoteResponseListener {
    void onResponse(String str, Map<String, Map<String, Number>> map);
}
