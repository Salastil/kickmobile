package io.github.centrifugal.centrifuge;

import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class HistoryResult {
    private String epoch;
    private long offset;
    private List<Publication> publications;

    public List<Publication> getPublications() {
        return this.publications;
    }

    public void setPublications(List<Publication> list) {
        this.publications = list;
    }

    public long getOffset() {
        return this.offset;
    }

    void setOffset(long j) {
        this.offset = j;
    }

    public String getEpoch() {
        return this.epoch;
    }

    void setEpoch(String str) {
        this.epoch = str;
    }
}
