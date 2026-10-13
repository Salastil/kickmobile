package com.datadog.trace.api.profiling;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes6.dex */
public class RecordingInputStream extends BufferedInputStream {
    public RecordingInputStream(InputStream inputStream) {
        super(inputStream);
    }

    public boolean isEmpty() throws IOException {
        if (this.pos != 0) {
            return false;
        }
        try {
            mark(1);
            return read() == -1;
        } finally {
            reset();
        }
    }
}
