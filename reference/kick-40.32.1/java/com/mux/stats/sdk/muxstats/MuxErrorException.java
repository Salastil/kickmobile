package com.mux.stats.sdk.muxstats;

import com.mux.stats.sdk.core.util.MuxLogger;

/* JADX INFO: loaded from: classes8.dex */
public class MuxErrorException extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f276a;
    private final String b;

    public MuxErrorException(int i, String str) {
        this(i, str, (String) null);
    }

    public MuxErrorException(int i, String str, String str2) {
        super(str);
        this.f276a = String.valueOf(i);
        this.b = str2;
    }

    public MuxErrorException(String str, String str2) {
        this(str, str2, (String) null);
    }

    public MuxErrorException(String str, String str2, String str3) {
        super(str2);
        this.f276a = str;
        this.b = str3;
    }

    @Deprecated
    public int getCode() {
        try {
            return Integer.parseInt(this.f276a);
        } catch (NumberFormatException unused) {
            MuxLogger.d("MuxErrorException", "getCode(): Code [" + this.f276a + "] was not a valid integer. Prefer using getErrorCode()");
            return 0;
        }
    }

    public String getContext() {
        return this.b;
    }

    public String getErrorCode() {
        return this.f276a;
    }
}
