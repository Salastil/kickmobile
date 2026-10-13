package org.jctools.counters;

/* JADX INFO: loaded from: classes11.dex */
public interface Counter {
    long get();

    long getAndReset();

    void inc();

    void inc(long j);
}
