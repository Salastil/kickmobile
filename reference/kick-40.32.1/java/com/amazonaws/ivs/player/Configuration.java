package com.amazonaws.ivs.player;

import io.ktor.http.LinkHeader;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
class Configuration {
    static final String KEY_CODEC = "codecConfigs";
    static final String KEY_HLS_SUBTITLE_PLAYLISTS = "enableHlsSubtitlePlaylists";
    static final String KEY_RESOLUTION_FILTER_MODE = "resolutionFilterMode";
    static final String KEY_SEI_MESSAGES_ENABLED = "seiMessagesEnabled";
    static final String KEY_SURFACE_SIZE_FILTER_ENABLED = "surfaceSizeFilterEnabled";
    static final String KEY_USE_SOURCE_GROUP_BUFFER_REPLACEMENT = "useSourceGroupBufferReplacement";
    static final String VALUE_ASPECT_RATIO = "aspectRatio";
    private Experiments experiments;
    private final JSONObject configuration = new JSONObject();
    private final ArrayList<IVSFeature<?>> features = new ArrayList<>();

    enum Group {
        ADAPTIVE_BITRATE("adaptiveBitrate"),
        ANALYTICS("analytics"),
        EXPERIMENT("experiments"),
        FEATURES("features"),
        MEDIA(LinkHeader.Parameters.Media);

        final String key;

        Group(String str) {
            this.key = str;
        }
    }

    Configuration() {
        loadDefaults();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void registerFeature(IVSFeature<?> iVSFeature) {
        Experiments experiments = this.experiments;
        if (experiments != null) {
            try {
                iVSFeature.overrideWith(experiments);
                if (iVSFeature instanceof Experimental) {
                    Experiments.Experiment description = ((Experimental) iVSFeature).getDescription();
                    ((JSONObject) this.configuration.get(Group.EXPERIMENT.key)).put(description.name(), fillExperimentData(description));
                }
                if (iVSFeature instanceof SuperResolution) {
                    ((JSONObject) this.configuration.get(Group.EXPERIMENT.key)).put(Experiments.Experiment.ANDROID_GPU.name(), fillExperimentData(Experiments.Experiment.ANDROID_GPU));
                }
            } catch (JSONException e) {
                Logging.w("Failed to update feature with experiments", e);
            }
        }
        this.features.add(iVSFeature);
    }

    void loadDefaults() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(KEY_USE_SOURCE_GROUP_BUFFER_REPLACEMENT, true);
            jSONObject.put(KEY_SURFACE_SIZE_FILTER_ENABLED, false);
            this.configuration.put(Group.ADAPTIVE_BITRATE.key, jSONObject);
            this.configuration.put(Group.ANALYTICS.key, new JSONObject());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(KEY_CODEC, new JSONArray());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(KEY_SEI_MESSAGES_ENABLED, true);
            jSONObject2.put("readers", jSONObject3);
            this.configuration.put(Group.MEDIA.key, jSONObject2);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(KEY_HLS_SUBTITLE_PLAYLISTS, false);
            this.configuration.put(Group.FEATURES.key, jSONObject4);
            this.configuration.put(Group.EXPERIMENT.key, new JSONObject());
        } catch (JSONException e) {
            Logging.w("Failed to load default configurations", e);
        }
    }

    void overrideWith(SessionConfig sessionConfig) {
        try {
            merge(sessionConfig.get(), this.configuration);
        } catch (JSONException e) {
            Logging.w("Failed to update configurations with session data", e);
        }
    }

    void overrideWith(Experiments experiments) {
        this.experiments = experiments;
    }

    void overrideWith(DeviceConfigPropertyHolder deviceConfigPropertyHolder) {
        try {
            for (IVSFeature<?> iVSFeature : this.features) {
                JSONObject jSONObjectOverrideWithPayload = iVSFeature.overrideWithPayload(deviceConfigPropertyHolder);
                if (iVSFeature.isEnabled) {
                    if (!this.configuration.has(iVSFeature.key)) {
                        this.configuration.put(iVSFeature.key, new JSONObject());
                    }
                    merge(jSONObjectOverrideWithPayload, this.configuration.getJSONObject(iVSFeature.key));
                }
            }
        } catch (JSONException e) {
            Logging.w("Failed to update configurations from device config", e);
        }
    }

    void setSEIMessagesEnabled(boolean z) {
        try {
            JSONObject jSONObject = (JSONObject) this.configuration.get(Group.MEDIA.key);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("readers");
            if (jSONObjectOptJSONObject == null) {
                jSONObjectOptJSONObject = new JSONObject();
                jSONObject.put("readers", jSONObjectOptJSONObject);
            }
            jSONObjectOptJSONObject.put(KEY_SEI_MESSAGES_ENABLED, z);
        } catch (JSONException e) {
            Logging.w("Failed to set SEI messages enabled", e);
        }
    }

    String getString(Group group, String str) {
        if (this.configuration.has(group.key)) {
            return this.configuration.optJSONObject(group.key).optString(str, null);
        }
        return null;
    }

    boolean getBoolean(Group group, String str) {
        if (this.configuration.has(group.key)) {
            return this.configuration.optJSONObject(group.key).optBoolean(str);
        }
        return false;
    }

    public String toString() {
        return this.configuration.toString();
    }

    private JSONObject fillExperimentData(Experiments.Experiment experiment) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", experiment.id);
        jSONObject.put("assignment", this.experiments.getAssignedGroup(experiment));
        jSONObject.put("version", this.experiments.getVersion(experiment));
        jSONObject.put("type", this.experiments.getType(experiment));
        return jSONObject;
    }

    private void merge(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object obj = jSONObject.get(next);
            if (!jSONObject2.has(next)) {
                jSONObject2.put(next, obj);
            } else if (obj instanceof JSONObject) {
                merge((JSONObject) obj, jSONObject2.getJSONObject(next));
            } else {
                jSONObject2.put(next, obj);
            }
        }
    }
}
