package com.amazonaws.ivs.player;

import android.os.Handler;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
class BufferFilter implements Filter<MediaSample, Pullable<MediaSample>>, Pullable<MediaSample> {
    final String TAG = "BufferFilter";
    private final Buffer buffer = new Buffer();

    BufferFilter() {
    }

    @Override // com.amazonaws.ivs.player.Filter
    public long bufferDurationMs() {
        return this.buffer.bufferDurationUs() / 1000;
    }

    @Override // com.amazonaws.ivs.player.Filter
    public void endOfStream() {
        this.buffer.markLastEnded();
    }

    @Override // com.amazonaws.ivs.player.Filter
    public void setOutput(Filter<Pullable<MediaSample>, ?> filter) {
        filter.receive(this);
    }

    @Override // com.amazonaws.ivs.player.Filter
    public void receive(MediaSample mediaSample) {
        this.buffer.add(mediaSample);
    }

    @Override // com.amazonaws.ivs.player.Filter
    public void release(Handler handler) {
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.amazonaws.ivs.player.BufferFilter$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.reset();
                }
            });
        } else {
            reset();
        }
    }

    @Override // com.amazonaws.ivs.player.Filter
    public void seekTo(long j) {
        this.buffer.seekTo(j);
    }

    @Override // com.amazonaws.ivs.player.Filter
    public void remove(long j, long j2) {
        this.buffer.remove(j, j2);
    }

    @Override // com.amazonaws.ivs.player.Filter
    public void reset() {
        this.buffer.clear();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.amazonaws.ivs.player.Pullable
    public MediaSample take() {
        MediaSample mediaSampleTakeNextSample = this.buffer.takeNextSample();
        if (mediaSampleTakeNextSample != null) {
            mediaSampleTakeNextSample.isDecodeOnlySeek = this.buffer.updatePlayHead(mediaSampleTakeNextSample.decodeTimeUs);
        }
        return mediaSampleTakeNextSample;
    }

    public boolean hasEOS() {
        return this.buffer.hasEOS();
    }

    static class Buffer {
        private int decodeIndex = 0;
        private long playHeadPts = 0;
        private final ArrayList<MediaSample> inputSamples = new ArrayList<>();

        Buffer() {
        }

        synchronized boolean updatePlayHead(long j) {
            if (j < this.playHeadPts) {
                return false;
            }
            this.playHeadPts = j;
            return true;
        }

        synchronized void seekTo(long j) {
            this.playHeadPts = j;
            this.decodeIndex = 0;
            for (int i = 0; i < this.inputSamples.size() && this.inputSamples.get(i).decodeTimeUs <= j; i++) {
                if (this.inputSamples.get(i).isSyncSample) {
                    this.decodeIndex = i;
                }
            }
        }

        synchronized void add(MediaSample mediaSample) {
            this.inputSamples.add(mediaSample);
            if (this.decodeIndex == 0) {
                long j = mediaSample.presentationTimeUs;
                long j2 = this.playHeadPts;
                if (j >= j2) {
                    seekTo(j2);
                }
            }
        }

        synchronized void remove(long j, long j2) {
            int i = 0;
            while (i < this.inputSamples.size()) {
                MediaSample mediaSample = this.inputSamples.get(i);
                if (mediaSample.decodeTimeUs < j || mediaSample.decodeTimeUs >= j2) {
                    i++;
                } else {
                    this.inputSamples.remove(i);
                    mediaSample.release();
                    int i2 = this.decodeIndex;
                    if (i < i2) {
                        this.decodeIndex = i2 - 1;
                    } else {
                        continue;
                    }
                }
            }
        }

        synchronized MediaSample takeNextSample() {
            if (this.decodeIndex >= this.inputSamples.size()) {
                return null;
            }
            ArrayList<MediaSample> arrayList = this.inputSamples;
            int i = this.decodeIndex;
            this.decodeIndex = i + 1;
            return arrayList.get(i);
        }

        synchronized void markNextEnded() {
            if (!this.inputSamples.isEmpty() && this.decodeIndex < this.inputSamples.size()) {
                this.inputSamples.get(this.decodeIndex).isEndOfStream = true;
                remove(this.inputSamples.get(this.decodeIndex).decodeTimeUs + 1, Long.MAX_VALUE);
            }
        }

        synchronized void markLastEnded() {
            if (this.inputSamples.isEmpty()) {
                return;
            }
            ArrayList<MediaSample> arrayList = this.inputSamples;
            arrayList.get(arrayList.size() - 1).isEndOfStream = true;
        }

        synchronized boolean hasEOS() {
            if (this.inputSamples.isEmpty()) {
                return false;
            }
            ArrayList<MediaSample> arrayList = this.inputSamples;
            return arrayList.get(arrayList.size() - 1).isEndOfStream;
        }

        synchronized long bufferDurationUs() {
            if (this.decodeIndex >= this.inputSamples.size()) {
                return 0L;
            }
            ArrayList<MediaSample> arrayList = this.inputSamples;
            MediaSample mediaSample = arrayList.get(arrayList.size() - 1);
            return (mediaSample.decodeTimeUs + mediaSample.durationUs) - this.inputSamples.get(this.decodeIndex).decodeTimeUs;
        }

        void clear() {
            remove(0L, Long.MAX_VALUE);
            this.playHeadPts = 0L;
            this.decodeIndex = 0;
        }
    }
}
