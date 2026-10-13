package com.amazonaws.ivs.player;

import android.os.Handler;

/* JADX INFO: loaded from: classes5.dex */
interface Filter<Input, Output> {

    public enum Kind {
        NONE,
        AUDIO,
        VIDEO
    }

    default long bufferDurationMs() {
        return 0L;
    }

    default void endOfStream() {
    }

    default void flush() {
    }

    default void pause() {
    }

    default void play() {
    }

    default void processException(Exception exc) {
    }

    void receive(Input input);

    void release(Handler handler);

    default void remove(long j, long j2) {
    }

    default void reset() {
    }

    default void seekTo(long j) {
    }

    void setOutput(Filter<Output, ?> filter);

    default void setPlaybackRate(float f) {
    }

    default void stop() {
    }

    default Kind kind() {
        return Kind.NONE;
    }
}
