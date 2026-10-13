package com.amazonaws.ivs.experiments;

/* JADX INFO: loaded from: classes5.dex */
public class ExperimentData {
    final String assignment;
    final String id;
    final String type;
    final int version;

    public ExperimentData(String str, String str2, int i, String str3) {
        this.id = str;
        this.assignment = str2;
        this.version = i;
        this.type = str3;
    }

    public String getId() {
        return this.id;
    }

    public String getAssignment() {
        return this.assignment;
    }

    public int getVersion() {
        return this.version;
    }

    public String getType() {
        return this.type;
    }
}
