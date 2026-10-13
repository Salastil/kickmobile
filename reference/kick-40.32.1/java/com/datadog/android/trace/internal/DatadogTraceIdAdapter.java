package com.datadog.android.trace.internal;

import com.datadog.android.trace.api.trace.DatadogTraceId;
import com.datadog.trace.api.DDTraceId;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DatadogTraceIdAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\b\u0080\b\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\t\u0010\u0005\u001a\u00020\u0002HÂ\u0003J\u0013\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/datadog/android/trace/internal/DatadogTraceIdAdapter;", "Lcom/datadog/android/trace/api/trace/DatadogTraceId;", "Lcom/datadog/trace/api/DDTraceId;", "delegate", "(Lcom/datadog/trace/api/DDTraceId;)V", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toHexString", "", "toHexStringPadded", ContentDisposition.Parameters.Size, "toHighOrderLong", "", "toLong", "toString", "dd-sdk-android-trace_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class DatadogTraceIdAdapter extends DDTraceId implements DatadogTraceId {
    private final DDTraceId delegate;

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final DDTraceId getDelegate() {
        return this.delegate;
    }

    public static /* synthetic */ DatadogTraceIdAdapter copy$default(DatadogTraceIdAdapter datadogTraceIdAdapter, DDTraceId dDTraceId, int i, Object obj) {
        if ((i & 1) != 0) {
            dDTraceId = datadogTraceIdAdapter.delegate;
        }
        return datadogTraceIdAdapter.copy(dDTraceId);
    }

    public final DatadogTraceIdAdapter copy(DDTraceId delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        return new DatadogTraceIdAdapter(delegate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof DatadogTraceIdAdapter) && Intrinsics.areEqual(this.delegate, ((DatadogTraceIdAdapter) other).delegate);
    }

    public int hashCode() {
        return this.delegate.hashCode();
    }

    public DatadogTraceIdAdapter(DDTraceId delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // com.datadog.trace.api.DDTraceId, com.datadog.android.trace.api.trace.DatadogTraceId
    public long toLong() {
        return this.delegate.toLong();
    }

    @Override // com.datadog.trace.api.DDTraceId
    public String toString() {
        String string = this.delegate.toString();
        Intrinsics.checkNotNullExpressionValue(string, "delegate.toString()");
        return string;
    }

    @Override // com.datadog.trace.api.DDTraceId, com.datadog.android.trace.api.trace.DatadogTraceId
    public String toHexString() {
        String hexString = this.delegate.toHexString();
        Intrinsics.checkNotNullExpressionValue(hexString, "delegate.toHexString()");
        return hexString;
    }

    @Override // com.datadog.trace.api.DDTraceId
    public long toHighOrderLong() {
        return this.delegate.toHighOrderLong();
    }

    @Override // com.datadog.trace.api.DDTraceId, com.datadog.android.trace.api.trace.DatadogTraceId
    public String toHexStringPadded(int size) {
        String hexStringPadded = this.delegate.toHexStringPadded(size);
        Intrinsics.checkNotNullExpressionValue(hexStringPadded, "delegate.toHexStringPadded(size)");
        return hexStringPadded;
    }
}
