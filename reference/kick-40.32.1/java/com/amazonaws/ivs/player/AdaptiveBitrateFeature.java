package com.amazonaws.ivs.player;

import org.json.JSONException;

/* JADX INFO: compiled from: NativeFeature.java */
/* JADX INFO: loaded from: classes5.dex */
class AdaptiveBitrateFeature extends NativeFeature {
    @Override // com.amazonaws.ivs.player.Configurable
    public void overrideWith(Experiments experiments) throws JSONException {
    }

    AdaptiveBitrateFeature() {
        super("adaptiveBitrate");
        this.isEnabled = true;
    }

    @Override // com.amazonaws.ivs.player.IVSFeature
    public String getPropertyHolderKey() {
        return "adaptive_bitrate";
    }
}
