package com.amazonaws.ivs.player;

import org.json.JSONException;

/* JADX INFO: compiled from: NativeFeature.java */
/* JADX INFO: loaded from: classes5.dex */
class ProbeV2Feature extends NativeFeature implements Experimental {
    ProbeV2Feature() {
        super("abr_probe");
    }

    @Override // com.amazonaws.ivs.player.Configurable
    public void overrideWith(Experiments experiments) throws JSONException {
        if (experiments.getAssignedGroup(getDescription()).equals("treatment")) {
            this.isEnabled = true;
        }
    }

    @Override // com.amazonaws.ivs.player.Experimental
    public Experiments.Experiment getDescription() {
        return Experiments.Experiment.PROBE_ENDPOINT;
    }
}
