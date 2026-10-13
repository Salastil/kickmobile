package com.datadog.trace.common.writer;

import com.datadog.trace.core.DDSpan;
import java.io.Closeable;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface Writer extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    boolean flush();

    void incrementDropCounts(int i);

    void start();

    void write(List<DDSpan> list);
}
