package com.datadog.trace.common.writer;

import com.datadog.trace.core.DDSpan;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class NoOpWriter implements Writer {
    @Override // com.datadog.trace.common.writer.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // com.datadog.trace.common.writer.Writer
    public boolean flush() {
        return true;
    }

    @Override // com.datadog.trace.common.writer.Writer
    public void incrementDropCounts(int i) {
    }

    @Override // com.datadog.trace.common.writer.Writer
    public void start() {
    }

    @Override // com.datadog.trace.common.writer.Writer
    public void write(List<DDSpan> list) {
    }
}
