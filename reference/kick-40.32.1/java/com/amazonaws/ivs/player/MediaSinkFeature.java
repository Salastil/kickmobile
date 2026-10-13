package com.amazonaws.ivs.player;

import com.amazonaws.ivs.player.json.Json;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
class MediaSinkFeature extends IVSFeature<Config> implements Experimental {

    public static class Config extends IVSFeature.IVSConfig<Config> {

        @Json
        public boolean enableMediaSinkJNI = false;

        @Json
        public boolean enableMediaSinkJNIForDrmContent = false;
    }

    @Override // com.amazonaws.ivs.player.Configurable
    public void overrideWith(Experiments experiments) throws JSONException {
    }

    public boolean shouldUsePlaybackSink() {
        return true;
    }

    @Override // com.amazonaws.ivs.player.Experimental
    public Experiments.Experiment getDescription() {
        return Experiments.Experiment.ANDROID_MEDIA_SINK;
    }

    MediaSinkFeature() {
        super("media_sink", new Config());
    }

    @Override // com.amazonaws.ivs.player.Configurable
    public void overrideWith(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.config.updateWithJson(jSONObject);
            this.isEnabled = true;
        }
    }

    public Config getConfig() {
        return (Config) this.config;
    }

    @Override // com.amazonaws.ivs.player.IVSFeature
    JSONObject getCriteriaForFeature() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (this.platform != null) {
            Map<String, String> deviceProperties = this.platform.getDeviceProperties();
            jSONObject.put("customer", deviceProperties.get("customer"));
            jSONObject.put("appVersion", deviceProperties.get("app_version_code"));
            jSONObject.put("deviceOsVersion", deviceProperties.get("device_os_version"));
            jSONObject.put("deviceManufacturer", deviceProperties.get("device_manufacturer"));
            jSONObject.put("deviceModel", deviceProperties.get("device_model"));
        }
        return jSONObject;
    }

    public boolean shouldUseMediaSinkJNI(boolean z) {
        if (getConfig().enableMediaSinkJNI) {
            return !z || getConfig().enableMediaSinkJNIForDrmContent;
        }
        return false;
    }
}
