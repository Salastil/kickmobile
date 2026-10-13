package com.amazonaws.ivs.player;

/* JADX INFO: loaded from: classes5.dex */
public final class AdCreativeMetadata {
    private final String adSystem;
    private final String adTitle;
    private final String creativeId;
    private final String vastAdId;

    AdCreativeMetadata(String str, String str2, String str3, String str4) {
        this.vastAdId = str;
        this.creativeId = str2;
        this.adSystem = str3;
        this.adTitle = str4;
    }

    public String getVastAdId() {
        return this.vastAdId;
    }

    public String getCreativeId() {
        return this.creativeId;
    }

    public String getAdSystem() {
        return this.adSystem;
    }

    public String getAdTitle() {
        return this.adTitle;
    }
}
