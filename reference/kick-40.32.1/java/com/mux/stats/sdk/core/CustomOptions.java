package com.mux.stats.sdk.core;

/* JADX INFO: loaded from: classes8.dex */
public class CustomOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Deprecated
    private String f229a;
    private String b;
    private boolean c;

    public String getBeaconCollectionDomain() {
        return this.b;
    }

    @Deprecated
    public String getBeaconDomain() {
        return this.f229a;
    }

    public boolean isLongBeaconDispatch() {
        return this.c;
    }

    @Deprecated
    public boolean isSentryEnabled() {
        return false;
    }

    public CustomOptions setBeaconCollectionDomain(String str) {
        this.b = str;
        return this;
    }

    @Deprecated
    public CustomOptions setBeaconDomain(String str) {
        if (!str.startsWith(".")) {
            str = "." + str;
        }
        this.f229a = str;
        return this;
    }

    public void setLongBeaconDispatch(boolean z) {
        this.c = z;
    }

    @Deprecated
    public CustomOptions setSentryEnabled(boolean z) {
        return this;
    }
}
