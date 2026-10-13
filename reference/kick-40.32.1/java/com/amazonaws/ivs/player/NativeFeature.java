package com.amazonaws.ivs.player;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
abstract class NativeFeature extends IVSFeature<NoConfig> {
    @Override // com.amazonaws.ivs.player.Configurable
    public void overrideWith(JSONObject jSONObject) throws JSONException {
    }

    NativeFeature(String str) {
        super(str, null);
    }

    static class NoConfig extends IVSFeature.IVSConfig<NoConfig> {
        NoConfig() {
        }
    }
}
