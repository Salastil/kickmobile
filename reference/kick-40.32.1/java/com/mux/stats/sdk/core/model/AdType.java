package com.mux.stats.sdk.core.model;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes8.dex */
public enum AdType {
    PRE_ROLL("preroll"),
    POST_ROLL("postroll"),
    MID_ROLL("midroll");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f246a;

    AdType(String str) {
        this.f246a = str;
    }

    @Nullable
    public static AdType fromTypeString(String str) {
        if (str == null) {
            return null;
        }
        for (AdType adType : values()) {
            if (adType.f246a.equals(str)) {
                return adType;
            }
        }
        return null;
    }

    public final String getTypeString() {
        return this.f246a;
    }
}
