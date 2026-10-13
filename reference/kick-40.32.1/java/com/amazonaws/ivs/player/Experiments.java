package com.amazonaws.ivs.player;

import android.text.TextUtils;
import com.amazonaws.ivs.experiments.ExperimentData;
import io.ktor.sse.ServerSentEventKt;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
class Experiments {
    static final String GROUP_CONTROL = "control";
    static final String GROUP_TREATMENT = "treatment";
    private final EnumMap<Experiment, ExperimentData> experiments = new EnumMap<>(Experiment.class);

    enum Experiment {
        AD_LOUDNESS("4dfcb309-1348-439f-8424-df8759481ddd", Experiments.GROUP_CONTROL),
        ANDROID_GPU("9d950d59-1936-4fbc-8eaa-a0d4fe6fcb9f", Experiments.GROUP_CONTROL),
        SUPER_RESOLUTION("8110c7e7-4746-49c9-8d46-dd7835314904", Experiments.GROUP_CONTROL),
        PROBE_ENDPOINT("742b9990-2c8b-427f-b5fc-fe4ccccec50b", Experiments.GROUP_CONTROL),
        ANDROID_ANALYTICS_DIRECT("dc83a207-5c45-4fc8-a1ad-0020b40ecade", Experiments.GROUP_CONTROL),
        ANDROID_MEDIA_SINK("fb311bdb-fe4e-4a24-aae5-51a22c87a1f4", Experiments.GROUP_CONTROL);

        private static final Map<String, Experiment> idToEnum = Collections.unmodifiableMap(createMapping());
        final String defaultGroup;
        final String id;
        final String type = "";
        final int version = 0;

        static Experiment fromId(String str) {
            return idToEnum.get(str);
        }

        private static Map<String, Experiment> createMapping() {
            HashMap map = new HashMap();
            for (Experiment experiment : values()) {
                map.put(experiment.id, experiment);
            }
            return map;
        }

        Experiment(String str, String str2) {
            this.id = str;
            this.defaultGroup = str2;
        }
    }

    static Map<String, String> getEntries() {
        HashMap map = new HashMap();
        for (Experiment experiment : (Experiment[]) Experiment.class.getEnumConstants()) {
            map.put(experiment.id, experiment.defaultGroup);
        }
        return map;
    }

    Experiments() {
        for (Experiment experiment : Experiment.values()) {
            this.experiments.put(experiment, new ExperimentData(experiment.id, experiment.defaultGroup, 0, ""));
        }
    }

    void setExperiment(ExperimentData experimentData) {
        if (experimentData == null || TextUtils.isEmpty(experimentData.getId()) || TextUtils.isEmpty(experimentData.getAssignment())) {
            return;
        }
        Logging.d("setExperiment " + experimentData.getId() + ServerSentEventKt.COLON + experimentData.getAssignment());
        Experiment experimentFromId = Experiment.fromId(experimentData.getId());
        if (experimentFromId == null) {
            Logging.w("Experiment ID not recognized");
        } else {
            this.experiments.put(experimentFromId, experimentData);
        }
    }

    void setExperiments(ExperimentData[] experimentDataArr) {
        if (experimentDataArr != null) {
            for (ExperimentData experimentData : experimentDataArr) {
                setExperiment(experimentData);
            }
        }
    }

    String getAssignedGroup(Experiment experiment) {
        if (this.experiments.containsKey(experiment)) {
            return this.experiments.get(experiment).getAssignment();
        }
        return null;
    }

    String getType(Experiment experiment) {
        if (this.experiments.containsKey(experiment)) {
            return this.experiments.get(experiment).getType();
        }
        return null;
    }

    Integer getVersion(Experiment experiment) {
        if (this.experiments.containsKey(experiment)) {
            return Integer.valueOf(this.experiments.get(experiment).getVersion());
        }
        return null;
    }

    boolean isControl(Experiment experiment) {
        return GROUP_CONTROL.equals(getAssignedGroup(experiment));
    }

    Map<Experiment, ExperimentData> dumpExperiments() {
        return Collections.unmodifiableMap(this.experiments);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Experiments:\n");
        for (K k : this.experiments.keySet()) {
            this.experiments.get(k);
            sb.append(k.id);
            sb.append(ServerSentEventKt.COLON);
            sb.append(getAssignedGroup(k));
            sb.append("\n");
        }
        return sb.toString();
    }
}
