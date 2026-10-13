package com.amazonaws.ivs.player;

import android.net.Uri;
import android.os.Handler;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public class HlsSource implements Source {
    private final Handler handler;
    private final Source.Listener listener;
    private long native_source;

    private native Set<SourceGroup> getGroups(long j);

    private native String getId(long j);

    private native String getManifest(long j);

    private native Set<Quality> getQualities(long j);

    private native String getSessionData(long j, String str);

    private native long getTimeToLive(long j);

    private native String getUri(long j);

    private native void release(long j);

    protected HlsSource(long j, Handler handler, Source.Listener listener) {
        this.native_source = j;
        this.handler = handler;
        this.listener = listener;
    }

    public void handleLoad() {
        if (this.listener != null) {
            this.handler.post(new Runnable() { // from class: com.amazonaws.ivs.player.HlsSource.1
                @Override // java.lang.Runnable
                public void run() {
                    HlsSource.this.listener.onLoad(this);
                }
            });
        }
    }

    public void handleError(int i, int i2, String str) {
        if (this.listener != null) {
            final Source.LoadError loadError = new Source.LoadError(getId(), getUri().toString(), ErrorType.fromInt(i), i2, str);
            this.handler.post(new Runnable() { // from class: com.amazonaws.ivs.player.HlsSource.2
                @Override // java.lang.Runnable
                public void run() {
                    HlsSource.this.listener.onError(loadError);
                }
            });
        }
    }

    @Override // com.amazonaws.ivs.player.Source
    public synchronized String getId() {
        long j = this.native_source;
        if (j != 0) {
            return getId(j);
        }
        return "";
    }

    @Override // com.amazonaws.ivs.player.Source
    public synchronized Uri getUri() {
        long j = this.native_source;
        if (j != 0) {
            return Uri.parse(getUri(j));
        }
        return Uri.EMPTY;
    }

    public synchronized String getManifest() {
        long j = this.native_source;
        if (j != 0) {
            return getManifest(j);
        }
        return "";
    }

    @Override // com.amazonaws.ivs.player.Source
    public synchronized String getSessionData(String str) {
        long j = this.native_source;
        if (j == 0) {
            return null;
        }
        return getSessionData(j, str);
    }

    @Override // com.amazonaws.ivs.player.Source
    public synchronized Set<Quality> getQualities() {
        Set<Quality> qualities = getQualities(this.native_source);
        if (qualities != null) {
            return qualities;
        }
        return new HashSet();
    }

    @Override // com.amazonaws.ivs.player.Source
    public synchronized Set<SourceGroup> getGroups() {
        Set<SourceGroup> groups = getGroups(this.native_source);
        if (groups != null) {
            return groups;
        }
        return new HashSet();
    }

    @Override // com.amazonaws.ivs.player.Source
    public synchronized long getTimeToLive() {
        long j = this.native_source;
        if (j == 0) {
            return -1L;
        }
        return getTimeToLive(j);
    }

    public long handle() {
        return this.native_source;
    }

    @Override // com.amazonaws.ivs.player.Source, com.amazonaws.ivs.player.Releasable
    public synchronized void release() {
        long j = this.native_source;
        if (j != 0) {
            release(j);
            this.native_source = 0L;
        }
    }

    protected void finalize() throws Throwable {
        try {
            if (this.native_source != 0) {
                Logging.e("Source not released, releasing from finalizer");
                release();
            }
        } finally {
            super.finalize();
        }
    }
}
