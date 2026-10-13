package com.datadog.trace.api.internal;

/* JADX INFO: loaded from: classes6.dex */
public interface TraceSegment {
    void effectivelyBlocked();

    void setDataCurrent(String str, Object obj);

    void setDataTop(String str, Object obj);

    void setTagCurrent(String str, Object obj, boolean z);

    void setTagTop(String str, Object obj, boolean z);

    default void setTagTop(String str, Object obj) {
        setTagTop(str, obj, false);
    }

    default void setTagCurrent(String str, Object obj) {
        setTagCurrent(str, obj, false);
    }

    public static class NoOp implements TraceSegment {
        public static final TraceSegment INSTANCE = new NoOp();

        @Override // com.datadog.trace.api.internal.TraceSegment
        public void effectivelyBlocked() {
        }

        @Override // com.datadog.trace.api.internal.TraceSegment
        public void setDataCurrent(String str, Object obj) {
        }

        @Override // com.datadog.trace.api.internal.TraceSegment
        public void setDataTop(String str, Object obj) {
        }

        @Override // com.datadog.trace.api.internal.TraceSegment
        public void setTagCurrent(String str, Object obj, boolean z) {
        }

        @Override // com.datadog.trace.api.internal.TraceSegment
        public void setTagTop(String str, Object obj, boolean z) {
        }

        private NoOp() {
        }
    }
}
