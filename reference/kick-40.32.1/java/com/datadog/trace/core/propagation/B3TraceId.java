package com.datadog.trace.core.propagation;

import com.datadog.trace.api.DD128bTraceId;
import com.datadog.trace.api.DDTraceId;

/* JADX INFO: loaded from: classes6.dex */
public class B3TraceId extends DDTraceId {
    protected final DDTraceId delegate;
    protected final String original;

    public static B3TraceId fromHex(String str) {
        return new B3TraceId(str, DD128bTraceId.fromHex(str));
    }

    protected B3TraceId(String str, DDTraceId dDTraceId) {
        this.original = str;
        this.delegate = dDTraceId;
    }

    public String getOriginal() {
        return this.original;
    }

    @Override // com.datadog.trace.api.DDTraceId, com.datadog.android.trace.api.trace.DatadogTraceId
    public String toHexString() {
        return this.delegate.toHexString();
    }

    @Override // com.datadog.trace.api.DDTraceId, com.datadog.android.trace.api.trace.DatadogTraceId
    public String toHexStringPadded(int i) {
        return this.delegate.toHexStringPadded(i);
    }

    @Override // com.datadog.trace.api.DDTraceId, com.datadog.android.trace.api.trace.DatadogTraceId
    public long toLong() {
        return this.delegate.toLong();
    }

    @Override // com.datadog.trace.api.DDTraceId
    public long toHighOrderLong() {
        return this.delegate.toHighOrderLong();
    }

    @Override // com.datadog.trace.api.DDTraceId
    public String toString() {
        return this.delegate.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.delegate.equals(((B3TraceId) obj).delegate);
    }

    public int hashCode() {
        return this.delegate.hashCode();
    }
}
