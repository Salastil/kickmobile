package com.amazonaws.ivs.player;

/* JADX INFO: compiled from: Filter.java */
/* JADX INFO: loaded from: classes5.dex */
interface AudioFilter<Input, Output> extends Filter<Input, Output> {
    void setVolume(float f);

    @Override // com.amazonaws.ivs.player.Filter
    default Filter.Kind kind() {
        return Filter.Kind.AUDIO;
    }
}
