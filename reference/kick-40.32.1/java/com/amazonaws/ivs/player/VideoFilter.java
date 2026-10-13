package com.amazonaws.ivs.player;

import android.view.Surface;

/* JADX INFO: compiled from: Filter.java */
/* JADX INFO: loaded from: classes5.dex */
interface VideoFilter<Input, Output> extends Filter<Input, Output> {
    Surface getInputSurface();

    default void setOutputSurface(Surface surface) {
    }

    @Override // com.amazonaws.ivs.player.Filter
    default Filter.Kind kind() {
        return Filter.Kind.VIDEO;
    }
}
