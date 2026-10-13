package com.amazonaws.ivs.player;

import java.util.AbstractMap;
import java.util.Map;
import kotlin.UByte$$ExternalSyntheticBackport0;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: NativeFeature.java */
/* JADX INFO: loaded from: classes5.dex */
class HlsSubtitlePlaylistsFeature extends NativeFeature {
    @Override // com.amazonaws.ivs.player.Configurable
    public void overrideWith(Experiments experiments) throws JSONException {
    }

    HlsSubtitlePlaylistsFeature() {
        super("features");
        this.isEnabled = false;
    }

    @Override // com.amazonaws.ivs.player.IVSFeature
    public String getPropertyHolderKey() {
        return "hls_subtitle_playlists";
    }

    @Override // com.amazonaws.ivs.player.NativeFeature, com.amazonaws.ivs.player.Configurable
    public void overrideWith(JSONObject jSONObject) throws JSONException {
        super.overrideWith(jSONObject);
        if (jSONObject.has("enabled")) {
            this.isEnabled = jSONObject.getBoolean("enabled");
        }
    }

    @Override // com.amazonaws.ivs.player.IVSFeature
    JSONObject overrideWithPayload(DeviceConfigPropertyHolder deviceConfigPropertyHolder) throws JSONException {
        super.overrideWithPayload(deviceConfigPropertyHolder);
        return new JSONObject().put("subtitles", new JSONObject(UByte$$ExternalSyntheticBackport0.m(new Map.Entry[]{new AbstractMap.SimpleEntry("enableHlsSubtitlePlaylists", Boolean.valueOf(this.isEnabled))})));
    }
}
