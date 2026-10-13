package com.mux.stats.sdk.core;

import com.mux.stats.sdk.core.model.EnvironmentData;
import com.mux.stats.sdk.core.util.CurrentTime;
import com.mux.stats.sdk.core.util.UUID;
import org.json.JSONException;

/* JADX INFO: loaded from: classes8.dex */
public class Session {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f231a;
    private long b;
    private long c;
    private CurrentTime d = new CurrentTime();

    private void a(long j) {
        this.f231a = UUID.generateUUID();
        this.b = j;
        this.c = j + 1500000;
    }

    public long now() {
        return this.d.now();
    }

    public void setCurrentTime(CurrentTime currentTime) {
        this.d = currentTime;
    }

    public void startSession() {
        a(now());
    }

    public void updateEnvironmentData(EnvironmentData environmentData) throws JSONException {
        long jNow = now();
        if (jNow > this.c) {
            a(now());
        } else {
            this.c = jNow + 1500000;
        }
        environmentData.setSessionStart(Long.valueOf(this.b));
        environmentData.setSessionExpires(Long.valueOf(this.c));
        environmentData.setSessionId(this.f231a);
    }
}
