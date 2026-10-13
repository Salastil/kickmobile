package com.amazonaws.ivs.player;

import android.os.Handler;

/* JADX INFO: compiled from: Filter.java */
/* JADX INFO: loaded from: classes5.dex */
class InlineSink<T> implements Filter<T, Void> {
    private final Op<T> op;

    /* JADX INFO: compiled from: Filter.java */
    interface Op<T> {
        void run(T t);
    }

    @Override // com.amazonaws.ivs.player.Filter
    public void release(Handler handler) {
    }

    @Override // com.amazonaws.ivs.player.Filter
    public void setOutput(Filter<Void, ?> filter) {
    }

    InlineSink(Op<T> op) {
        this.op = op;
    }

    @Override // com.amazonaws.ivs.player.Filter
    public void receive(T t) {
        this.op.run(t);
    }
}
